/*
 * Created on Apr 28, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
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
import biomightweb.util.BioWebX3DUtils;
import biomightweb.view.BioMightRange;

/************************************************************************************
 * @author SurferJim
 *
 * Representation of a Lymphocyte.  It is composed of proteins.
 * 
 ************************************************************************************/

public class Lymphocyte extends BioMightBase {
	private BioMightPosition bioMightPosition;
	
	// We should add this into the base Cell,but for now
	// will do seperately to get it working
	private CellMembrane cellMembrane;
	private Granules granules;
	
		
	public Lymphocyte()
	{		
		// Create the Base Lymphocyte
		int localVP =  Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG2X;
		create(localVP, localLOD, Constants.LymphocyteRef, null, null);
	}
	
	public Lymphocyte(String parentID)
	{				
		int localVP =  Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG2X;
		create(localVP, localLOD, parentID, null, null);	
	}
		

	public Lymphocyte(String parentID, BioMightPosition bioMightPosition)
	{
		int localVP =  Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG2X;
		create(localVP, localLOD, parentID, null, null);
		this.bioMightPosition = bioMightPosition;
	}

		
	public Lymphocyte(int localVP, int localLOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
	{		
		create(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);
	}
	
	public void create(int localVP, int localLOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
	{
			this.setImage("images/Lymphocyte.jpg");
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
				System.out.println("In Lymphocyte Create() - Already Set: " + parentID);				
			}
			else if (localVP == Constants.VIEW_DETACHED) 
			{	
				// We are going to assemble from subcomponents 
				
				if (bioMightMethods != null){
					//System.out.println("NEED TO EXECUTE Calyx METHODS: " + bioMightMethods.size());
				}
				
				// Generate the Lymphocyte Epihelium if needed 
				boolean bGenerate = false;
				if (bGenerate) {
					generate(parentID, componentID);
				}
			
				System.out.println("Creating Lymphocyte Epithelium: " + parentID);				
				cellMembrane = new CellMembrane(parentID, bioMightMethods);
								
				System.out.println("Lymphocyte Instance created from SubComponents : " + parentID);
			}	
			else if (localVP == Constants.VIEW_HAWKEYE)
			{
				// This is when one is accessing a Lymphocyte directly
				// Get the information from the database via the Enterprise Bean		
				try {
					// Get the information from the database via the Enterprise Bean		
					System.out.println("Getting HawkEye LymphocyteInfo for ParentID: " + parentID);
					InitialContext ctx = new InitialContext();
					BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
					bioMightTransforms = bioMightBean.getComponent(parentID);
					System.out.println("Have Lymphocyte Info from EJB");   	
				}catch (Exception e) { 
					System.out.println("Exception Getting Components - Lymphocyte");
					throw new ServerException("Remote Exception getComponents():", e); 	
				}
					
				// Run through the collection of Lymphocytes and build them into the model
				// In the default case, we get one instance of the Lymphocyte for each eye
				ArrayList transforms = bioMightTransforms.getTransforms();
				System.out.println("Lymphocyte NumTransforms: " + transforms.size());
				for (int i=0; i<transforms.size(); i++)
				{
					// Get the information for the Lymphocyte
					BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
					System.out.println("Creating Lymphocyte: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
					this.componentID = bioMightTransform.getId();
					
					// initialize the Properties
					
					
					System.out.println("In Basophil - Creating Ribosomes");
					granules = new Granules(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
					initProperty(Constants.GranulesRef, Constants.Granules, Constants.RibosomesRef, granules.getComponentID());
					System.out.println("In Lymphocyte - Granules are complete");

					initProperty(bioMightTransform.getName(), Constants.Granules, Constants.GranuleRef, bioMightTransform.getId());

				}
			}
			else
			{
				
			}
				
			initMethods();
			
			System.out.println("CreateLymphocyte Completed");
			
			// First, get all the data from the database
			// Apply the methods to it
			// Save its state
			this.parentID = parentID;
			if (bioMightMethods != null){
				System.out.println("EXECUTING Lymphocyte Methods: " + bioMightMethods.size());
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
			// Generate the Lymphocyte		
			BioMightBeanLocal bioMightBean;
			try {
				// Get the information from the database via the Enterprise Bean		
				System.out.println("Generating the Lymphocyte Epithelium: " + componentID + "    " + parentID);
				InitialContext ctx = new InitialContext();
				bioMightBean = (BioMightBeanLocal) ctx.lookup("java:global/BioMightWeb/BioMightBean!biomight.ejb.BioMightBeanLocal");
		
				double circumference = 0.125;
				
				if (componentID.equals("Lymphocyte:01")) {
					
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

						
					//int success = bioMightBean.generateLymphocyte("LymphocyteEpithelium:00001", "LymphocyteEpithelium", 
					//		"LymphocyteEpithelium", componentID, parentID, currentPoints);			
					
				}
				else if (componentID.equals("Lymphocyte:02"))
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

					
					
					//int success = bioMightBean.generateLymphocyte("Lymphocyte:00160", "Lymphocyte", 
					//	"LymphocyteE", componentID, parentID, currentPoints);
			
					
				}
				else if (parentID.equals("")) 
				{	
					System.out.println("Calling Generate LymphocyteEpithelium NoParent");		
				}

				
				System.out.println("Created LymphocyteEpithelium Info using EJB");   	
			}catch (Exception e) { 
				System.out.println("Exception Getting Components - LymphocyteEpithelium");
				throw new ServerException("Remote Exception LymphocyteEpithelium():", e); 	
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
			System.out.println("Lymphocyte Executing Methods");
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
		 * This method will return the X3D for the Cell.  It runs through each of its components and collects up their
		 * representations and then assembles them into one unified X3D model.
		 * 
		 ********************************************************************************************************************/
		public String getX3D(boolean snipet) {
			
			// Assembe the Lymphocyte
			String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
			"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n " +
			"<X3D profile='Immersive' >\n" +
			"<head>\n" +
			 "<meta name='BioMightImage' content='Lymphocyte.jpg'/>\n" +
			 "<meta name='ExportTime' content='7:45:30'/>\n" +
			 "<meta name='ExportDate' content='08/15/2008'/>\n" +
			 "<meta name='BioMight Version' content='1.0'/>\n" + 
			"</head>\n" +
			"<Scene>\n" +
			"<WorldInfo\n" +
			"title='Lymphocyte'\n" +
			"info='\"BioMight Generated X3D\"'/>\n";		

			String body = "";
			String annotate = "";
			
			
			// Only when the database retrieval has been locally, do we do this??
			if (viewPerspective == Constants.VIEW_HAWKEYE) 
			{			
				ArrayList transforms = bioMightTransforms.getTransforms();
				for (int i=0; i<transforms.size(); i++)
				{
					// Get the information for the capsomer we are creating
					BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
					System.out.println("Creating Lymphocyte: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
					System.out.println("Creating Lymphocyte X3D HAWKEYE at Position: " + 
							bioMightTransform.getTranslation().getXPos() + "  " +
							bioMightTransform.getTranslation().getYPos() + "  " +
							bioMightTransform.getTranslation().getZPos());
					

					//System.out.println("Getting X3D for LymphocyteX: " + bioMightTransform.getTranslation().getXPos());
					//System.out.println("Getting X3D for LymphocyteY: " + bioMightTransform.getTranslation().getYPos());
					//System.out.println("Getting X3D for LymphocyteZ: " + bioMightTransform.getTranslation().getZPos());
					// Change the height and width based on the displacement.
					body += "<Transform DEF='Lymphocyte'\n";
					
					
					// Set the position if we are working with the Tissue collection
					if (parentID.equals("1.10000:0"))
					{
						body += "translation='" 
							+ bioMightPosition.getXPos() + " " 
				 			+ bioMightPosition.getYPos() + " "
				 			+ bioMightPosition.getZPos() + "'\n";
					}
					else
					{
				 		body += "translation='" 
				 			+ bioMightTransform.getTranslation().getXPos() + " " 
	 						+ bioMightTransform.getTranslation().getYPos() + " "
	 						+ bioMightTransform.getTranslation().getZPos() + "'\n";					
					}
					 					
					 					
					body +=  "scale='" 	+ bioMightTransform.getScale().getXPos() + " "
					 				+ bioMightTransform.getScale().getYPos() + " "
					 				+ bioMightTransform.getScale().getZPos() + "'>\n" +
					 	"<Shape DEF='Lymphocyte'\n" +
					    " containerField='children'>\n" +
					    " <Appearance\n" +
					    "  containerField='appearance'>\n";
					    
					
					body+= " <ImageTexture containerField='texture' " +
						    " url='../images/SpeckledAmethyst.png'/>";
					
					    
					body+= " <Material DEF='Rust'\n" +
					    "containerField='material'\n" +
					    "ambientIntensity='" 	+ bioMightTransform.getMaterial().getAmbientIntensity() + "'\n" +
					    "shininess='" 			+ bioMightTransform.getMaterial().getShininess() + "'\n" +
					    "transparency='" 		+ bioMightTransform.getMaterial().getTransparency() + "'\n" +
					    "diffuseColor='" + 
					 	    bioMightTransform.getMaterial().getDiffuseColor().getRed() + " " + 
					 	    bioMightTransform.getMaterial().getDiffuseColor().getGreen() + " " +
					 	    bioMightTransform.getMaterial().getDiffuseColor().getBlue() + "'/>\n" +
					 	"</Appearance>\n" +
					 	"<Sphere DEF='LymphocyteGeoSphere'\n" +
					 	"containerField='geometry'\n" +
					 	"radius='" + bioMightTransform.getRadius() +"'/>\n" +
					 	"</Shape>\n" +
					 	
						"\n<TouchSensor DEF='"+bioMightTransform.getId()+"' \n" +
		                   " description='Lymphocyte'\n" +
			               " containerField='children'/> \n" +
		
					 "</Transform>\n";
					

					ArrayList ranges = new ArrayList();
					BioMightPosition bioMightPosition = new BioMightPosition(0.05, 0, 0);
					BioMightOrientation bioMightOrientation = new BioMightOrientation(0, 0, 1, 90);
			
					double maxWidth = 0.035;
					double maxHeight = 0.3;
			
					BioMightRange bioRange = new BioMightRange(25, 3, 5, 0, 3, 0,  maxWidth, 0, maxHeight);
					ranges.add(bioRange);
					double nucleurRadius = bioMightTransform.getRadius()/4;
					bioMightTransform.setRadius(nucleurRadius);
				    //body += BioWebX3DUtils.generateSphereIrregular(bioMightTransform,  new double[] {bioMightPosition.getXPos(), bioMightPosition.getYPos(), bioMightPosition.getZPos()}, ranges);	

					bioMightTransform.setTextureFile("PowderBlue.png");
					bioMightTransform.setTextureID(1);
				  	body += BioWebX3DUtils.generateLymphocyte(bioMightTransform,  bioMightPosition, bioMightOrientation); 	
				}
			}
			else
			{
				body = "";					
			}
			
			
			body+= "<Viewpoint DEF='Viewpoint_Lymphocyte'\n" +
					 "description='Viewpoint1'\n" +
					 "jump='true'\n" +
					 "fieldOfView='0.785'\n" +
					 "position='0.0 0.0 3.0'\n" +
					 "orientation='0 0 1 0'/>\n";
			
			
			//System.out.println("Lymphocyte X3D: " + body);		
			String footer = "</Scene>" + "</X3D>\n";
			
			if (snipet)
				return body;			
			else	
				return header + body + annotate + footer;				
		}
			
}