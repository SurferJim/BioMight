/*
 * Created on Apr 28, 2006
 *
 * Create a representation of an Anitgen
 * 
 */

package biomight.cell.bloodandimmune;

import java.util.ArrayList;

import javax.naming.InitialContext;

import biomight.BioMightBase;
import biomight.Constants;
import biomight.cell.CellMembrane;
import biomight.cell.Ribosomes;
import biomight.ejb.BioMightBeanLocal;
import biomight.exceptions.ServerException;
import biomight.view.BioMightMethodView;
import biomight.view.BioMightOrientation;
import biomight.view.BioMightPosition;
import biomight.view.BioMightPropertyView;
import biomight.view.BioMightScale;
import biomight.view.BioMightTransform;
import biomightweb.util.BioWebUtils;
import biomightweb.util.BioWebX3DUtils;
import biomightweb.view.BioMightRange;

/************************************************************************************
 * @author SurferJim
 *
 * Representation of a Antigen.  It is composed of proteins.
 * 
 ************************************************************************************/

public class CopyOfAntigen extends BioMightBase {
	private BioMightPosition bioMightPosition;
	
	// We should add this into the base Cell,but for now
	// will do seperately to get it working
	private CellMembrane cellMembrane;
	private Granules granules;
	
		
	public CopyOfAntigen()
	{		
		// Create the Base Antigen
		int localVP =  Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG2X;
		create(localVP, localLOD, Constants.AntigenRef, null, null);
	}
	
	public CopyOfAntigen(String parentID)
	{				
		int localVP =  Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG2X;
		create(localVP, localLOD, parentID, null, null);	
	}
		

	public CopyOfAntigen(String parentID, BioMightPosition bioMightPosition)
	{
		int localVP =  Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG2X;
		create(localVP, localLOD, parentID, null, null);
		this.bioMightPosition = bioMightPosition;
	}

		
	public CopyOfAntigen(int localVP, int localLOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
	{		
		create(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);
	}
	
	public void create(int localVP, int localLOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
	{
			this.setImage("images/Antigen.jpg");
			this.setImageHeight(300);
			this.setImageWidth(300);
			this.parentID = parentID;
			this.lod = localLOD;
			this.viewPerspective = localVP;
			
			if (localVP == Constants.VIEW_INTERNAL)			
			{
				// Do nothing.  We are instantiating as part of a collection  
				// There is no drill down, so we use the transforms that the
				// parent has already collected
				System.out.println("In Antigen Create() - Already Set: " + parentID);				
			}
			else if (localVP == Constants.VIEW_DETACHED) 
			{	
				// We are going to assemble from subcomponents 
				
				if (bioMightMethods != null){
					//System.out.println("NEED TO EXECUTE Calyx METHODS: " + bioMightMethods.size());
				}
				
				// Generate the Antigen Epihelium if needed 
				boolean bGenerate = false;
				if (bGenerate) {
					generate(parentID, componentID);
				}
			
				System.out.println("Creating Antigen Epithelium: " + parentID);				
				cellMembrane = new CellMembrane(parentID, bioMightMethods);
								
				System.out.println("Antigen Instance created from SubComponents : " + parentID);
			}	
			else if (localVP == Constants.VIEW_HAWKEYE)
			{
				// This is when one is accessing a Antigen directly
				// Get the information from the database via the Enterprise Bean		
				try {
					// Get the information from the database via the Enterprise Bean		
					System.out.println("Getting HawkEye AntigenInfo for ParentID: " + parentID);
					InitialContext ctx = new InitialContext();
					BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
					bioMightTransforms = bioMightBean.getComponent(parentID);
					System.out.println("Have Antigen Info from EJB");   	
				}catch (Exception e) { 
					System.out.println("Exception Getting Components - Antigen");
					throw new ServerException("Remote Exception getComponents():", e); 	
				}
					
				// Run through the collection of Antigens and build them into the model
				// In the default case, we get one instance of the Antigen for each eye
				ArrayList transforms = bioMightTransforms.getTransforms();
				System.out.println("Antigen NumTransforms: " + transforms.size());
				for (int i=0; i<transforms.size(); i++)
				{
					// Get the information for the Antigen
					BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
					System.out.println("Creating Antigen: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
					this.componentID = bioMightTransform.getId();
					this.bioMightTransform = bioMightTransform;
					
					// initialize the Properties
					//System.out.println("In Antigen - Creating Ribosomes");
					//granules = new Granules(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);			
					//initProperty(bioMightTransform.getName(), Constants.Granules, Constants.GranuleRef, bioMightTransform.getId());
					//System.out.println("In Antigen - Granules are complete");

				}
			}
			else
			{
				
			}
				
			initMethods();
			
			System.out.println("CreateAntigen Completed");
			
			// First, get all the data from the database
			// Apply the methods to it
			// Save its state
			this.parentID = parentID;
			if (bioMightMethods != null){
				System.out.println("EXECUTING Antigen Methods: " + bioMightMethods.size());
				//executeMethods(bioMightMethods);
			}
		}
		

	
	private void initProperties() {
		
		BioMightScale bioScale = new BioMightScale("0.00, 0.00, 0.00");
		BioMightPosition bioPos = new BioMightPosition("0.00, 0.00, 0.00");	
		String bioTemplate =""; 

		initProperty(Constants.NOT_ACTIVATED, Constants.Title, Constants.Title, "Cells:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);

		BioMightPropertyView property = new BioMightPropertyView();
		property.setPropertyName("Cell Membrane");
		property.setCanonicalName(Constants.CellMembraneRef);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("Endosome");
		property.setCanonicalName(Constants.EndosomeRef);
		properties.add(property);
	
		property = new BioMightPropertyView();
		property.setPropertyName("Lyososome");
		property.setCanonicalName(Constants.LysosomeRef);
		properties.add(property);			
	}
	
		
		
		/****************************************************
		 * GENERATE BASOPHIL
		 * 
		 * 
		 * @param parentID
		 * @param componentID
		 ***************************************************/
		public void generate(String parentID, String componentID)
		{
			// Generate the Antigen		
			BioMightBeanLocal bioMightBean;
			try {
				// Get the information from the database via the Enterprise Bean		
				System.out.println("Generating the Antigen Epithelium: " + componentID + "    " + parentID);
				InitialContext ctx = new InitialContext();
				bioMightBean = (BioMightBeanLocal) ctx.lookup("java:global/BioMightWeb/BioMightBean!biomight.ejb.BioMightBeanLocal");
		
				double circumference = 0.125;
				
				if (componentID.equals("Antigen:01")) {
					
					// Generate the Palm
					double[] startPos = {3.75,-23.0,-6.0};
					
					// Create a equilateral octogon
		    		double x =  startPos[0];
		    		double y =  startPos[1];
		    		double z =  startPos[2];
		
		    		double[][] currentPoints = { 
			   				 {x, y, z},
			     				 {x, y-circumference,     z-circumference},
			     				 {x, y-(circumference*2), z-circumference},
			     				 {x, y-(circumference*3), z},
			     				 {x, y-(circumference*3), z+(circumference)},
			     				 {x, y-(circumference*2), z+(circumference*2)},
			     				 {x, y-circumference,     z+(circumference*2)},
			     				 {x, y, z+circumference}
			      		};

						
					//int success = bioMightBean.generateAntigen("AntigenEpithelium:00001", "AntigenEpithelium", 
					//		"AntigenEpithelium", componentID, parentID, currentPoints);			
					
				}
				else if (componentID.equals("Antigen:02"))
				{
					// Generate the Elbow
					double[] startPos = {-3.75,-23.0,-6.0};
					
					// Create a equilateral octogon
		    		double x =  startPos[0];
		    		double y =  startPos[1];
		    		double z =  startPos[2];
		    		 
		    		
					double[][] currentPoints = { 
		   				 {x, y, z},
		     				 {x, y-circumference,     z-circumference},
		     				 {x, y-(circumference*2), z-circumference},
		     				 {x, y-(circumference*3), z},
		     				 {x, y-(circumference*3), z+(circumference)},
		     				 {x, y-(circumference*2), z+(circumference*2)},
		     				 {x, y-circumference,     z+(circumference*2)},
		     				 {x, y, z+circumference}
		      		};

					
					
					//int success = bioMightBean.generateAntigen("Antigen:00160", "Antigen", 
					//	"AntigenE", componentID, parentID, currentPoints);
			
					
				}
				else if (parentID.equals("")) 
				{	
					System.out.println("Calling Generate AntigenEpithelium NoParent");		
				}

				
				System.out.println("Created AntigenEpithelium Info using EJB");   	
			}catch (Exception e) { 
				System.out.println("Exception Getting Components - AntigenEpithelium");
				throw new ServerException("Remote Exception AntigenEpithelium():", e); 	
			}
		}
		
		
		// This method will store the method list into the 
		// BioMightBase object. 
		private void initMethods() {
			BioMightMethodView method = new BioMightMethodView();
			method.setMethodName("setMembraneWidth");
			method.setDisplayName("Membrane Width:");
			method.setDataType(Constants.BIO_DOUBLE);
			method.setHtmlType("text");
			methods.add(method);

			method = new BioMightMethodView();
			method.setDataType(Constants.BIO_DOUBLE);
			method.setMethodName("Vsetolume");
			method.setDisplayName("Volume:");
			method.setHtmlType(Constants.BIO_TEXT);
			methods.add(method);
			
			method = new BioMightMethodView();
			method.setMethodName("setTexture");
			method.setDisplayName("Texture:");
			method.setDataType(Constants.BIO_TEXT);
			method.setHtmlType(Constants.BIO_TEXT);
			methods.add(method);
			
			// May need to describe the parameters to the methods
			method = new BioMightMethodView();
			method.setMethodName("setLyse");
			method.setDisplayName("Lyse:");
			method.setDataType(Constants.BIO_TEXT);
			method.setHtmlType(Constants.BIO_TEXT);
			methods.add(method);
		}
		

		
		/******************************************************************************************
		 * EXECUTE METHODS 
		 *
		 ******************************************************************************************/
		public void executeMethods(ArrayList<String> methodParams) {

			// Run through the argument list and execute the 
			// associated methods
			System.out.println("Antigen Executing Methods");
			for (int j=0; j<methodParams.size(); j++){
				
				// Get the parameter from the list and if it is not
				// empty execute the associated method using it
				String methodParam = methodParams.get(j);
				if (methodParam != null) {
					if (!methodParam.equals("")) {
						//String methodName = (String) methods.get[j]; 
						//System.out.println("Applying " + methods.get(j) + " with arg: "  +  methodParam);
					}
				}
			}
			
		}
		

		/********************************************************************************************************************
		 * GET X3D
		 * 
		 * This method will return the X3D for the Antigen.  It runs through each of its components and collects up their
		 * representations and then assembles them into one unified X3D model.
		 * 
		 ********************************************************************************************************************/
		public String getX3D(boolean snipet) {
			
			// Assemble the Antigen
			String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
			"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n " +
			"<X3D profile='Immersive' >\n" +
			"<head>\n" +
			 "<meta name='BioMightImage' content='Antigen.jpg'/>\n" +
			 "<meta name='ExportTime' content='7:45:30'/>\n" +
			 "<meta name='ExportDate' content='08/15/2008'/>\n" +
			 "<meta name='BioMight Version' content='1.0'/>\n" + 
			"</head>\n" +
			"<Scene>\n" +
			"<WorldInfo\n" +
			"title='Antigen'\n" +
			"info='\"BioMight Generated X3D\"'/>\n";		

			String body = "";
			String annotate = "";
			

			System.out.println("Getting X3D for Antigen!!!!!!!!");
	 
			
			// Only when the database retrieval has been locally, do we do this??
			if (viewPerspective == Constants.VIEW_INTERNAL) 
			{	
				
				System.out.println("Get X3D Antigen - View Internal");
				// We do nada as the Antigen Data is retrieved in the collection object
				// and the X3D is generated there
				lod = Constants.MAG2X;
				if (lod == Constants.MAG2X)		
				{
					System.out.println("Get X3D Antigen - View Internal - 2X");
			
					ArrayList ranges = new ArrayList();
			
					//BioMightPosition bioMightPosition = new BioMightPosition(0.0, 0.50, -0.0025);
					BioMightPosition bioMightPosition = 
							new BioMightPosition(bioMightTransform.getTranslation().getXPos(), 
									bioMightTransform.getTranslation().getYPos(), bioMightTransform.getTranslation().getZPos());
					
					double randomRotateAngle = Math.random()*100;
					BioMightOrientation bioMightOrientation = new BioMightOrientation(0, 0, 1, 90);
					String componentTypeOut = "AntigenGlobal";
					body += "<Transform onmouseover=\"showComponent('Antigen');\" DEF='" + componentTypeOut + "'\n";
					body+= "rotation='" 	
							+ "0.0 , " + " "
							+ "0.0 , " + " "
							+ "1.0 , " + " "
							+  randomRotateAngle + "'>\n";
				  	body += BioWebX3DUtils.generateAntigen(bioMightTransform,  bioMightPosition, bioMightOrientation); 	
				  	body += "</Transform>\n";
				}
				else if (lod == Constants.MAG1X)
				{			
					// We went to the database to get data.  There will be 1 Transform record
				
					/*
					System.out.println("Creating Antigen: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
					System.out.println("Creating Antigen at Position: " + 
							bioMightTransform.getTranslation().getXPos() + "  " +
							bioMightTransform.getTranslation().getYPos() + "  " +
							bioMightTransform.getTranslation().getZPos());
		
					double radius = bioMightTransform.getRadius();
					bioMightTransform.setComponentName("Cell Membrane");
					bioMightTransform.setTextureID(5);
					bioMightTransform.setTextureFile("SpeckledAmethyst.png");
					bioMightTransform.setRadius(0.75);
					body += BioWebX3DUtils.generateSphereSimple(bioMightTransform);	
					bioMightTransform.setRadius(radius);	
		
					*/
				}
			
			}
			else if (viewPerspective == Constants.VIEW_HAWKEYE) 
			{
				System.out.println("Get X3D Antigen - View Hawkeye");
				
				//************************************************************888
				//**************************************************************8
				// HACK
				lod = Constants.MAG2X;
				//************************************************************
				//************************************************************

				if (lod == Constants.MAG2X)		
				{
					System.out.println("Get X3D Antigen - View Hawkeye -- 2X");
			
					//BioMightPosition bioMightPosition = new BioMightPosition(0.0, 0.50, -0.0025);
					BioMightPosition bioMightPosition = 
							new BioMightPosition(bioMightTransform.getTranslation().getXPos(), 
									bioMightTransform.getTranslation().getYPos(), bioMightTransform.getTranslation().getZPos());
			
					bioMightPosition = new BioMightPosition(0, 0, 0); 
					
					double randomRotateAngle = Math.random()*100;
					BioMightOrientation bioMightOrientation = new BioMightOrientation(0, 0, 1, 90);
					String componentTypeOut = "AntigenGlobal";
					body += "<Transform onmouseover=\"showComponent('Antigen');\" DEF='" + componentTypeOut + "'\n";
					body+= "rotation='" 	
							+ "0.0 , " + " "
							+ "0.0 , " + " "
							+ "1.0 , " + " "
							+  randomRotateAngle + "'>\n";
				  	body += BioWebX3DUtils.generateAntigen(bioMightTransform,  bioMightPosition, bioMightOrientation); 	
				  	body += "</Transform>\n";
				}
				else
				{			
					// We went to the database to get data.  There will be 1 Transform record
					System.out.println("Get X3D Antigen - View Hawkeye  1X");
				
					ArrayList transforms = bioMightTransforms.getTransforms();
					for (int i=0; i<transforms.size(); i++)
					{
						// Get the information for the capsomer we are creating
						BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
						System.out.println("Creating Antigen: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
						System.out.println("Creating Antigen at Position: " + 
								bioMightTransform.getTranslation().getXPos() + "  " +
								bioMightTransform.getTranslation().getYPos() + "  " +
								bioMightTransform.getTranslation().getZPos());
						

							double xPos = bioMightTransform.getTranslation().getXPos();  
							double yPos = bioMightTransform.getTranslation().getYPos();
							double zPos = bioMightTransform.getTranslation().getZPos();	
							double height =  bioMightTransform.getHeight();
							double radius = bioMightTransform.getRadius();
							
							for (int k=0; k<2; k++) {
									
								yPos = BioWebUtils.randomWithRange(0.0, 1.15*radius);
											
								radius = bioMightTransform.getRadius();
								bioMightTransform.setComponentName("Cell Membrane");
								bioMightTransform.setTextureID(5);
								bioMightTransform.setTextureFile("SpeckledAmethyst.png");
								bioMightTransform.setRadius(0.75);
								body += BioWebX3DUtils.generateSphereSimple(bioMightTransform);	
								bioMightTransform.setRadius(radius);	
												
								
								xPos = xPos + (radius*1.5);
							}
					}
					
				}
			}
			else 
			{			
				// Issue
			}	
			
			
			body+= "<Viewpoint DEF='Viewpoint_Antigen'\n" +
					 "description='Viewpoint1'\n" +
					 "jump='true'\n" +
					 "fieldOfView='0.785'\n" +
					 "position='0.0 0.0 0.5'\n" +
					 "orientation='0 0 1 0'/>\n";
			
			//System.out.println("Antigen X3D: " + body);		
			String footer = "</Scene>" + "</X3D>\n";
			
			if (snipet)
				return body;			
			else	
				return header + body + annotate + footer;				
		}
			
}