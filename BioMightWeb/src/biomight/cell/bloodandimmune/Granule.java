/*
 * Created on Apr 26, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.cell.bloodandimmune;
import java.util.ArrayList;

import javax.naming.InitialContext;

import biomight.BioMightBase;
import biomight.Constants;
import biomight.ejb.BioMightBeanLocal;
import biomight.exceptions.ServerException;
import biomight.view.BioMightCylinder;
import biomight.view.BioMightMethodView;
import biomight.view.BioMightPosition;
import biomight.view.BioMightPropertyView;
import biomight.view.BioMightTransform;

/************************************************************************************
 * @author SurferJim
 *
 * Representation of a Granule
 * 
 **************************************************************************************/
public class Granule extends BioMightBase{
	private BioMightPosition bioMightPosition;
	private BioMightCylinder bioMightCylinder;
	
	
	public Granule()
	{		
		// Create the Base Granule
		int localVP =  Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG2X;
		create(localVP, localLOD, Constants.GranuleRef, null, null);
	}
	
	public Granule(String parentID)
	{				
		int localVP =  Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG2X;
		create(localVP, localLOD, parentID, null, null);	
	}
		

	public Granule(String parentID, BioMightPosition bioMightPosition)
	{
		int localVP =  Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG2X;
		create(localVP, localLOD, parentID, null, null);
		this.bioMightPosition = bioMightPosition;
	}
	
	
	// We are looking at the object from a collection.  It was created via
	// the Granules parent object and we do not have  to go to the database 
	// to get additional informaion
	public Granule(int localVP, int localLOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
	{		
		create(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);
	}

	/********************************************************************************************************************
	 * CREATE
	 * 
	 * This method will create the Granule
	 * 
	 ********************************************************************************************************************/

	public void create(int localVP, int localLOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
	{
			this.setImage("images/Granule.jpg");
			this.setImageHeight(300);
			this.setImageWidth(300);
			this.parentID = parentID;
			this.componentID = parentID;
			this.lod = localLOD;
			this.viewPerspective = localVP;
			
			// There are 4 modes in which this object will be created
			// 1 - Being instantiated as part of a collection.
			// 2 - Being instantiated when drilling down from a collection, will need to get component by ID
			// 3 - Need level of detail to determine if aggregated, or get current level
			// 4 - 
			if (localVP == Constants.VIEW_INTERNAL)			
			{
				// Do nothing.  We are instantiating as part of a collection  
				// There is no drill down, so we use the transforms that the
				// parent has already collected
				System.out.println("In Granule Create() - Already Set: " + parentID);				

				// We already have the data for the current instance of Granule,
				// Go get the details for the current Granule is LOD is set
				if (localLOD == Constants.MAG2X)
				{
					// Go get the finer details of the Granule				
					System.out.println("Getting the Granule Details: " + parentID);
					localVP = Constants.VIEW_INTERNAL; 
					localLOD = Constants.MAG1X;
					//cellMembrane = new CellMembrane(localVP, localLOD, componentID, bioMightMethods);									
					System.out.println("Granule Instance created from SubComponents : " + parentID);
				
					//System.out.println("In Granule - Creating Endosomes");
					//endosomes = new Endosomes(bioMightTransform.getId(), bioMightMethods);
					//System.out.println("In Cell - Cell Membrane is complete");
			
					// initialize the Properties
					//initProperty(bioMightTransform.getName(), Constants.Granule, Constants.GranuleRef, bioMightTransform.getId());
				}
			
			}	
			else if (localVP == Constants.VIEW_HAWKEYE)
			{
				// This is when one is accessing a Granule directly
				// Get the information from the database via the Enterprise Bean		
				try {
					// Get the information from the database via the Enterprise Bean		
					System.out.println("Getting HawkEye GranuleInfo for ParentID: " + parentID);
					InitialContext ctx = new InitialContext();
					BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
					bioMightTransforms = bioMightBean.getComponent(parentID);
					System.out.println("Have Granule Info from EJB");   	
				}catch (Exception e) { 
					System.out.println("Exception Getting Components - Granule");
					throw new ServerException("Remote Exception getComponents():", e); 	
				}
					
				// Run through the collection of Granules and build them into the model
				// In the default case, we get one instance of the Granule for each eye
				ArrayList transforms = bioMightTransforms.getTransforms();
				System.out.println("Granule NumTransforms: " + transforms.size());
				for (int i=0; i<transforms.size(); i++)
				{
					// Get the information for the Granule
					BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
					System.out.println("Creating Granule: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
					this.componentID = bioMightTransform.getId();


					if (localLOD == Constants.MAG1X)
					{
						// initialize the Properties
						initProperties();
					}
					if (localLOD == Constants.MAG2X)
					{
						// Go get the finer details of the Granule				
						System.out.println("Creating Granule : " + parentID + " lod: " + localLOD);
						localVP = Constants.VIEW_HAWKEYE; 
						localLOD = Constants.MAG1X;

						System.out.println("Creating GranuleMembrane : " + parentID + " lod: " + localLOD);
						//cellMembrane = new CellMembrane(localVP, localLOD, bioMightTransform.getId(), bioMightMethods);
						//initProperty(Constants.CellMembraneRef, Constants.CellMembrane, Constants.CellMembraneRef, cellMembrane.getComponentID());
						System.out.println("In Granule - GranuleMembrane is complete");
		
					}
					
				}
			}		
			else
			{
				
			}
				
			initMethods();
			
			System.out.println("CreateGranule Completed");
			
			// First, get all the data from the database
			// Apply the methods to it
			// Save its state
			this.parentID = parentID;
			if (bioMightMethods != null){
				System.out.println("EXECUTING Granule Methods: " + bioMightMethods.size());
				//executeMethods(bioMightMethods);
			}
		}

	private void initProperties() {
		
		BioMightPropertyView property = new BioMightPropertyView();
		property.setPropertyName("Pump Handle");
		property.setCanonicalName(Constants.CellMembraneRef);
		properties.add(property);
			
	}

	
	private void initMethods() {
		
		BioMightMethodView method = new BioMightMethodView();
		method.setMethodName("Set Pump Rate");
		method.setHtmlType("text");
		methods.add(method);

		method = new BioMightMethodView();
		method.setMethodName("Set Pump Volume");
		method.setHtmlType("text");
		methods.add(method);
	}

	/****************************************************
	 * GENERATE PEROXISOME
	 * 
	 * 
	 * @param parentID
	 * @param componentID
	 ***************************************************/
	public void generate(String parentID, String componentID)
	{
		// Generate the Granule		
		BioMightBeanLocal bioMightBean;
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Generating the Granule : " + componentID + "    " + parentID);
			InitialContext ctx = new InitialContext();
			bioMightBean = (BioMightBeanLocal) ctx.lookup("java:global/BioMightWeb/BioMightBean!biomight.ejb.BioMightBeanLocal");
	
			double circumference = 0.125;
			
			if (componentID.equals("Granule:01")) {
				
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

					
				//int success = bioMightBean.generateGranule("Granule:00001", "Granule", 
				//		"Granule", componentID, parentID, currentPoints);			
				
			}
			else if (componentID.equals("Granule:02"))
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

				
				
				//int success = bioMightBean.generateGranule("Granule:00160", "Granule", 
				//	"Granule", componentID, parentID, currentPoints);
		
				
			}
			else if (parentID.equals("")) 
			{	
				System.out.println("Calling Generate Granule NoParent");		
			}

			
			System.out.println("Created Granule Info using EJB");   	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - Granule");
			throw new ServerException("Remote Exception Granule():", e); 	
		}
	}
	

	/******************************************************************************************
	 * EXECUTE METHODS 
	 *
	 ******************************************************************************************/
	public void executeMethods(ArrayList<String> methodParams) {

		// Run through the argument list and execute the 
		// associated methods
		System.out.println("Granule Executing Methods");
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
	 * This method will return the X3D for the Granule.  It runs through each of its components and collects up their
	 * representations and then assembles them into one unified X3D model.
	 * 
	 ********************************************************************************************************************/
	public String getX3D(boolean snipet) {
		
		// Assembe the Granule
		String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
		"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n " +
		"<X3D profile='Immersive' >\n" +
		"<head>\n" +
		 "<meta name='BioMightImage' content='Granule.jpg'/>\n" +
		 "<meta name='ExportTime' content='7:45:30'/>\n" +
		 "<meta name='ExportDate' content='08/15/2008'/>\n" +
		 "<meta name='BioMight Version' content='1.0'/>\n" + 
		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='Granule'\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		

		String body = "";
		String annotate = "";
		
		
		// Only when the database retrieval has been locally, do we do this??
		if (viewPerspective == Constants.VIEW_INTERNAL) 
		{			
			// We do nada as the Granule Data is retrieved in the collection object
			// and the X3D is generated there
			if (lod == Constants.MAG2X)		
			{
				//We are going to get the X3D from the aggregation objects
			}
		}
		else if (viewPerspective == Constants.VIEW_HAWKEYE) 
		{
			// We went to the database to get data.  There will be 1 Transform record
		
			ArrayList transforms = bioMightTransforms.getTransforms();
			for (int i=0; i<transforms.size(); i++)
			{
				// Get the information for the capsomer we are creating
				BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
				System.out.println("Creating Granule: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
				System.out.println("Creating Granule at Position: " + 
						bioMightTransform.getTranslation().getXPos() + "  " +
						bioMightTransform.getTranslation().getYPos() + "  " +
						bioMightTransform.getTranslation().getZPos());
				
				// Grab the data
				if (lod == Constants.MAG1X)		
				{
					//System.out.println("Getting X3D for GranuleX: " + bioMightTransform.getTranslation().getXPos());
					//System.out.println("Getting X3D for GranuleY: " + bioMightTransform.getTranslation().getYPos());
					//System.out.println("Getting X3D for GranuleZ: " + bioMightTransform.getTranslation().getZPos());
					// Change the height and width based on the displacement.
					body += "<Transform DEF='Granule'\n";
					
					
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
					 	"<Shape DEF='Granule'\n" +
					    " containerField='children'>\n" +
					    " <Appearance\n" +
					    "  containerField='appearance'>\n";
					    
					body+= " <ImageTexture containerField='texture'\n" +
						    " url='../images/SpeckledBlack.png'/>\n";
						
					
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
					 	"<Cylinder DEF='GranuleGeoSphere'\n" +
					 	"containerField='geometry'\n" +
					 	"radius='" + bioMightTransform.getRadius() + "'\n" +
					 	"height='" + (bioMightTransform.getRadius()*2) + "'/>\n" +
					 	"</Shape>\n" +
	
					 	/**
						"<Cylinder DEF='GranuleGeoCylinder'\n" +
						 "containerField='geometry'\n" +
						 "radius='" + bioMightCylinder.getRadius() +"'/>\n" +
						 "</Shape>\n" +
						 "</Transform>\n"+ 
					**/
					 	
					 	
						"\n<TouchSensor DEF='"+bioMightTransform.getId()+"' \n" +
		                   " description='Granule'\n" +
			               " containerField='children'/> \n" +
		
					 "</Transform>\n";
					
						//	Add the text to the Tissue sample
						if (parentID.equals("1.10000:0"))
						{
							annotate = 
								"<Transform DEF='GranuleText' \n" +
								"translation='" + (bioMightPosition.getXPos() + 1.25) + " "  
								+ (bioMightPosition.getYPos()+0.25) + " "
								+ bioMightPosition.getZPos() + "'>\n" +
								"<Shape DEF='Tisssuesn'>\n" +
								"<Appearance\n" +
								"containerField='appearance'>\n" +
								"<Material containerField='material' USE='Red'/>\n" +
								"</Appearance>\n" +
								"<Text DEF='GeoText2'\n" +
								"containerField='geometry'\n" +
								"string='\"Granules\"'\n" +
								"maxExtent='0.000'>\n" +
								"<FontStyle\n" +
								"containerField='fontStyle'\n" +
								"family='SERIF'\n" +
								"style='PLAIN'\n" +
								"justify='\"BEGIN\" \"BEGIN\"'\n" +
								"size='0.500'\n" +
								"spacing='0.50'/>\n" +
								"</Text>\n" +
								"</Shape>\n" +
							"</Transform>\n";
						}
					}
					else if (lod == Constants.MAG2X)		
					{
						body += "";
					}
				}
		}
		else 
		{			
			// Issue
		}	
			
		body+= "<Viewpoint DEF='Viewpoint_Granule'\n" +
				 "description='Viewpoint_Granule'\n" +
				 "jump='true'\n" +
				 "fieldOfView='0.785'\n" +
				 "position='0.0 0.0 3.0'\n" +
				 "orientation='0 0 1 0'/>\n";
		
		//System.out.println("Granule X3D: " + body);		
		String footer = "</Scene>" + "</X3D>\n";
		
		if (snipet)
			return body;			
		else	
			return header + body + annotate + footer;				
	}

		
}
