/*
 * Created on Jun 8, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.chemistry.elements;
import java.util.ArrayList;

import javax.naming.InitialContext;

import biomight.BioMightBase;
import biomight.Constants;
import biomight.ejb.BioMightBeanLocal;
import biomight.exceptions.ServerException;
import biomight.view.BioMightMethodView;
import biomight.view.BioMightPosition;
import biomight.view.BioMightPropertyView;
import biomight.view.BioMightTransform;
import biomight.view.BioMightTransforms;
import biomightweb.util.BioWebDNA;
import biomightweb.util.BioWebX3DUtils;


/************************************************************************
* @author SurferJim
*
* Representation of Silicon
*
*************************************************************************/
public class Silicon  extends BioMightBase {
	private ArrayList colors;
	private BioMightPosition bioMightPosition;
	private Electrons electrons;
	
	public Silicon()
	{
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, Constants.SiliconRef, null, null);
	}

	public Silicon(String parentID)
	{
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, parentID, null, null);
	}

	public Silicon(int hierarchy, int LOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
	{
		create(hierarchy, LOD, parentID, bioMightProperties, bioMightMethods);
	}

	/*****************************************************************
	 * CREATE
	 * 
	 * @param parentID
	 * @param bioMightMethods
	 ******************************************************************/
	public void create(int localVP, int localLOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
	{
		this.setImage("images/Silicon.jpg");
		this.setImageHeight(300);
		this.setImageWidth(300);
		this.parentID = parentID;
		this.componentID = parentID;
		this.lod = localLOD;
		this.viewPerspective = localVP;
		
		System.out.println("Creating Silicon for: " + parentID);
				
	
		if (localVP == Constants.VIEW_INTERNAL)			
		{
			// Do nothing.  We are instantiating as part of a collection  
			// There is no drill down, so we use the transforms that the
			// parent has already collected
			System.out.println("In Silicon Create() - ViewInternal - Already Set: " + parentID);				

			// We already have the data for the current instance of Silicon,
			// Go get the details for the current Silicon is LOD is set
			if (localLOD == Constants.MAG2X)
			{
				// Go get the finer details of the Silicon				
				System.out.println("Getting the Silicon MAG2X : " + parentID);
				localVP = Constants.VIEW_INTERNAL; 
				localLOD = Constants.MAG1X;		
			
				//System.out.println("Creating Capsid MAG ViewInternal - 1X : " + parentID);
				//electrons = new Electrons(localVP, localLOD, componentID, bioMightProperties, bioMightMethods);
				//initProperty(Constants.CapsidRef, Constants.Capsid, Constants.CapsidRef, electrons.getComponentID());
				//System.out.println("In Silicon - Capsid is complete");

			}
		
		}	
		else if (localVP == Constants.VIEW_HAWKEYE)
		{
			
			//***************************************************************
			//***************************************************************
			// ON the drill down go into the detail for now on a single cell
			// HACK
			localLOD = Constants.MAG1X;
			//***************************************************************
			//***************************************************************
		
			// This is when one is accessing a Silicon directly
			// Get the information from the database via the Enterprise Bean		
			try {
				// Get the information from the database via the Enterprise Bean		
				System.out.println("Getting HawkEye SiliconInfo for ParentID: " + parentID);
				InitialContext ctx = new InitialContext();
				BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
				bioMightTransforms = bioMightBean.getComponent(parentID);
				
				System.out.println("Have Silicon Info from EJB");   	
			}catch (Exception e) { 
				System.out.println("Exception Getting Components - Silicon");
				throw new ServerException("Remote Exception getComponents():", e); 	
			}
				
			// Run through the collection of BacilliAnthracis and build them into the model
			// In the default case, we get one instance of the Silicon for each eye
			ArrayList transforms = bioMightTransforms.getTransforms();
			System.out.println("Silicon NumTransforms: " + transforms.size());
			for (int i=0; i<transforms.size(); i++)
			{
				// Get the information for the Silicon
				BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
				System.out.println("Creating Silicon: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
				this.componentID = bioMightTransform.getId();

		
				if (localLOD == Constants.MAG1X)
				{
					System.out.println("Creating Silicon at HawkEye MAG1X - Just Init Properties: " + parentID);
					// initialize the Properties
					initProperties();
				}
				if (localLOD == Constants.MAG2X)
				{
					// Go get the finer details of the Silicon				
					System.out.println("Creating Silicon at HawkEye MAG2X : " + parentID);
					localVP = Constants.VIEW_INTERNAL; 
					localLOD = Constants.MAG1X;

					//System.out.println("Creating Capsid MAG 1X : " + parentID);
					//capsid = new Capsid(localVP, localLOD, componentID, bioMightProperties, bioMightMethods);
					//initProperty(Constants.CapsidRef, Constants.Capsid, Constants.CapsidRef, capsid.getComponentID());
					//System.out.println("In Silicon - Capsid is complete");

					//System.out.println("Creating Capsid MAG ViewInternal - 1X : " + parentID);
					//electrons = new Electrons(localVP, localLOD, componentID, bioMightProperties, bioMightMethods);
					//initProperty(Constants.CapsidRef, Constants.Capsid, Constants.CapsidRef, electrons.getComponentID());
					//System.out.println("In Silicon - Capsid is complete");

					
				}
				
			}
		}		
		else
		{
			
		}
			
		initMethods();
		
		System.out.println("CreateSilicon Completed");
		
		// First, get all the data from the database
		// Apply the methods to it
		// Save its state
		this.parentID = parentID;
		if (bioMightMethods != null){
			System.out.println("EXECUTING Silicon Methods: " + bioMightMethods.size());
			//executeMethods(bioMightMethods);
		}
			
	}
	
	


	public void initProperties() {
		
		BioMightPropertyView property;
		
		// Observable
		property = new BioMightPropertyView();
		property.setPropertyName("Protons");
		property.setCanonicalName(Constants.Title);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("Nuetrons");
		property.setCanonicalName(Constants.Title);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("Electrons");
		property.setCanonicalName(Constants.Electrons);
		properties.add(property);
			
	}
	

	public void initMethods() {

		methods = new ArrayList<BioMightMethodView>();
			
		BioMightMethodView method;
		methods = new ArrayList<BioMightMethodView>();
		method = new BioMightMethodView();
		method.setDisplayName("Transcribe");
		method.setMethodName("Transcribe");
		method.setHtmlType("checkbox");
		method.setDataType("boolean");
		methods.add(method);

		method = new BioMightMethodView();
		method.setDisplayName("Penetrate Silicon");
		method.setMethodName("Penetrate Silicon");
		method.setHtmlType("checkbox");
		method.setDataType("boolean");
		methods.add(method);	
			
		method = new BioMightMethodView();
		method.setDisplayName("UnCoat");
		method.setMethodName("UnCoat");
		method.setHtmlType("checkbox");
		method.setDataType("boolean");
		methods.add(method);
	}

	
	/**********************************************************************
	 * GENERATE 
	 * 
	 * 
	 * @param parentID
	 * @param componentID
	 **********************************************************************/
	public void generate(String parentID, String componentID)
	{
		// Generate the Silicon		
		BioMightBeanLocal bioMightBean;
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Generating the Silicon : " + componentID + "    " + parentID);
			InitialContext ctx = new InitialContext();
			bioMightBean = (BioMightBeanLocal) ctx.lookup("java:global/BioMightWeb/BioMightBean!biomight.ejb.BioMightBeanLocal");
	
			double circumference = 0.125;
			
			if (componentID.equals("Silicon:01")) {
				
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

					
				//int success = bioMightBean.generateSilicon("Silicon:00001", "Silicon", 
				//		"Silicon", componentID, parentID, currentPoints);			
				
			}
			else if (componentID.equals("Silicon:02"))
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

				
				
				//int success = bioMightBean.generateSilicon("Silicon:00160", "Silicon", 
				//	"Silicon", componentID, parentID, currentPoints);
		
				
			}
			else if (parentID.equals("")) 
			{	
				System.out.println("Calling Generate Silicon NoParent");		
			}

			
			System.out.println("Created Silicon Info using EJB");   	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - Silicon");
			throw new ServerException("Remote Exception Silicon():", e); 	
		}
	}
	
	

	
	/********************************************************************************************************************
	 * GET X3D
	 * 
	 * This method will return the X3D for the Silicon.  It runs through each of its components and collects up their
	 * representations and then assembles them into one unified X3D model.
	 * 
	 ********************************************************************************************************************/
	public String getX3D(boolean snipet) {
		
		// Assembe the Silicon
		String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
		"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n " +
		"<X3D profile='Immersive' >\n" +
		"<head>\n" +
		 "<meta name='BioMightImage' content='Silicon.jpg'/>\n" +
		 "<meta name='ExportTime' content='7:45:30'/>\n" +
		 "<meta name='ExportDate' content='08/15/2008'/>\n" +
		 "<meta name='BioMight Version' content='1.0'/>\n" + 
		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='Silicon'\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		

		String body = "";
		String annotate = "";
		

		System.out.println("Getting X3D for Silicon!!!!!!!!");

		
		// Only when the database retrieval has been locally, do we do this??
		if (viewPerspective == Constants.VIEW_INTERNAL) 
		{	
			
			//************************************************************888
			//**************************************************************8
			// HACK
			lod = Constants.MAG2X;
			//************************************************************
			//************************************************************

			
			System.out.println("Get X3D Silicon - View Internal");
			// We do nada as the Silicon Data is retrieved in the collection object
			// and the X3D is generated there
			if (lod == Constants.MAG2X)		
			{
				System.out.println("Get X3D Silicon - View Internal - 2X");
				//We are going to get the X3D from the aggregation objects
				body += electrons.getX3D(true);	
			}
			else if (lod == Constants.MAG1X)
			{			
				// We went to the database to get data.  There will be 1 Transform record
			
				/*
				System.out.println("Creating Silicon: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
				System.out.println("Creating Silicon at Position: " + 
						bioMightTransform.getTranslation().getXPos() + "  " +
						bioMightTransform.getTranslation().getYPos() + "  " +
						bioMightTransform.getTranslation().getZPos());
	
				body += "<Transform DEF= 'TRANSFORM_" + bioMightTransform.getId() + "' \n";
					
					
	
		 		body += "translation='" 
					+ bioMightTransform.getTranslation().getXPos() + " " 
	 				+ bioMightTransform.getTranslation().getYPos() + " "
	 				+ bioMightTransform.getTranslation().getZPos() + "'\n";					
			
					 					
					 					
				body +=  "scale='" 	+ bioMightTransform.getScale().getXPos() + " "
				 				+ bioMightTransform.getScale().getYPos() + " "
				 				+ bioMightTransform.getScale().getZPos() + "'>\n" +
				 	"<Shape DEF='SHAPE_" + bioMightTransform.getId() + "' \n" +
				    " containerField='children'>\n" +
				    " <Appearance\n" +
				    "  containerField='appearance'>\n";
					    
				body+= " <ImageTexture containerField='texture' " +
				    " url='../images/Silicon.jpg'/>";
				
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
				 	"<Sphere DEF='SiliconGeoSphere'\n" +
				 	"containerField='geometry'\n" +
				 	"radius='" + bioMightTransform.getRadius() +"'/>\n" +
				 	"</Shape>\n" +
				 	
					"\n<TouchSensor DEF='TSENSOR_"+ bioMightTransform.getId()+ "' \n" +
	                   " description='Silicon'\n" +
		               " containerField='children'/> \n" +
	
				 "</Transform>\n";
				*/
			}
		
		}
		else if (viewPerspective == Constants.VIEW_HAWKEYE) 
		{
			System.out.println("Get X3D Silicon - View Hawkeye");
			
			//************************************************************888
			//**************************************************************8
			// HACK
			lod = Constants.MAG1X;
			//************************************************************
			//************************************************************

			if (lod == Constants.MAG2X)		
			{
				System.out.println("Get X3D Silicon - View Hawkeye -- 2X");
				//We are going to get the X3D from the aggregation objects
				body += electrons.getX3D(true);	
			}
			else
			{			
				// We went to the database to get data.  There will be 1 Transform record
				System.out.println("Get X3D Silicon - View Hawkeye  1X");
			
				ArrayList transforms = bioMightTransforms.getTransforms();
				for (int i=0; i<transforms.size(); i++)
				{
					// Get the information for the capsomer we are creating
					BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
					System.out.println("Creating Silicon: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
					System.out.println("Creating Silicon at Position: " + 
							bioMightTransform.getTranslation().getXPos() + "  " +
							bioMightTransform.getTranslation().getYPos() + "  " +
							bioMightTransform.getTranslation().getZPos());

					String elementDesc = Constants.SiliconRef + "-AtomicWeight: 14, %Body: less than 0.01";	
					body += "\n<Transform onmouseover=\"showComponent('" + elementDesc + "');\" DEF='" + bioMightTransform.getId() + "'\n";
				
						
						
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
						/*body += "translation='" 
		 				+ bioMightTransform.getTranslation().getXPos() + " " 
						+ bioMightTransform.getTranslation().getYPos() + " "
						+ bioMightTransform.getTranslation().getZPos() + "'\n";				
						 */
				 		body += "translation='" 
					 			+ 0 + " " 
			 					+ 0 + " "
			 					+ 0 + "'\n";									
					}
						 					
						 					
					body +=  "scale='" 	+ bioMightTransform.getScale().getXPos() + " "
					 				+ bioMightTransform.getScale().getYPos() + " "
					 				+ bioMightTransform.getScale().getZPos() + "'>\n" +
					 				
					 	"<Shape DEF='SHAPE_" + bioMightTransform.getId() + "' \n" +
					    " containerField='children'>\n" +
					    " <Appearance\n" +
					    "  containerField='appearance'>\n";
						    
					body+= " <ImageTexture containerField='texture' " +
					    " url='../images/Silicon.jpg'/>";
					
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
					 	"<Sphere DEF='SiliconGeoSphere'\n" +
					 	"containerField='geometry'\n" +
					 	"radius='" + bioMightTransform.getRadius() +"'/>\n" +
					 	"</Shape>\n" +
					 	
						"\n<TouchSensor DEF='TSENSOR_"+ bioMightTransform.getId()+ "' \n" +
		                   " description='Silicon'\n" +
			               " containerField='children'/> \n" +
		
					 "</Transform>\n";
					
					// Selenium has 34 electrons
					// Each ring expands around the Center
					double electronSize = BioWebDNA.getAtomicRadius("Electron");
					int eRing = 0;
					double ringSize = bioMightTransform.getRadius() +  ((electronSize*3) * (eRing+1));
					ArrayList ringData = new ArrayList();	
			
					
					double[][] offSets0 = new double[2][3];	
					offSets0[0][0] = ringSize;
					offSets0[0][1] = ringSize;
					offSets0[0][2] = 0;
							
					offSets0[1][0] = -ringSize;
					offSets0[1][1] = ringSize;
					offSets0[1][2] = 0;

					ringData.add(0, offSets0);
							
					
					eRing = 1;
					ringSize = bioMightTransform.getRadius() +  ((electronSize*3) * (eRing+1));
					double[][] offSets1 = new double[8][3];
					
					offSets1[0][0] = ringSize;
					offSets1[0][1] = ringSize;
					offSets1[0][2] = 0;
							
					offSets1[1][0] = -ringSize;
					offSets1[1][1] = ringSize;
					offSets1[1][2] = 0;		
							
					offSets1[2][0] = -ringSize;
					offSets1[2][1] = -ringSize;
					offSets1[2][2] = 0;
					
					offSets1[3][0] = ringSize;
					offSets1[3][1] = -ringSize;
					offSets1[3][2] = 0;
						
					// y flat
					offSets1[4][0] = ringSize;
					offSets1[4][1] = 0;
					offSets1[4][2] = -ringSize;
					
					offSets1[5][0] = ringSize;
					offSets1[5][1] = 0;
					offSets1[5][2] = ringSize;
					
					offSets1[6][0] = -ringSize;
					offSets1[6][1] = 0;
					offSets1[6][2] = ringSize;
					
					offSets1[7][0] = -ringSize;
					offSets1[7][1] = 0;
					offSets1[7][2] = -ringSize;
					
					ringData.add(1, offSets1);
					
					
					
					eRing = 2;
					ringSize = bioMightTransform.getRadius() +  ((electronSize*3) * (eRing+1));
					double[][] offSets2 = new double[4][3];
					
					offSets2[0][0] = 0;
					offSets2[0][1] = ringSize;
					offSets2[0][2] = ringSize;
					
					offSets2[1][0] = 0;
					offSets2[1][1] = ringSize;
					offSets2[1][2] = -ringSize;		
					
					offSets2[2][0] = 0;
					offSets2[2][1] = -ringSize;
					offSets2[2][2] = -ringSize;
					
					offSets2[3][0] = 0;
					offSets2[3][1] = -ringSize;
					offSets2[3][2] = ringSize;
							
					ringData.add(2, offSets2);

					bioMightTransform.getTranslation().setXPos(0);
					bioMightTransform.getTranslation().setYPos(0);
					bioMightTransform.getTranslation().setZPos(0);
					body += BioWebX3DUtils.addElectrons(bioMightTransform, ringData);

				}
				
			}
		}
		else 
		{			
			// Issue
		}	
			

		body+= "<Viewpoint DEF='Viewpoint_Silicon'\n" +
				 "description='Viewpoint_Silicon'\n" +
				 "jump='true'\n" +
				 "fieldOfView='0.785'\n" +
				 "position='0.0 0.0 120.0'\n" +
				 "orientation='0 0 1 0'/>\n";
		
		String footer = "</Scene>" + "</X3D>\n";		
		if (snipet)
			return body;			
		else	
			return header + body + annotate + footer;				
	}


	

	public void unCoat()
	{
	}

	public void penetrate()
	{
	}
	
	public void transcribe()
	{
	}
		
	public void assemble()
	{
		// 
	}

}
