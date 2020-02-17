/*
 * Created on Oct 5, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.bacteria;

import java.util.ArrayList;

import javax.naming.InitialContext;

import biomight.BioMightBase;
import biomight.Constants;
import biomight.chemistry.secretion.Curlin;
import biomight.chemistry.secretion.Curlins;
import biomight.ejb.BioMightBeanLocal;
import biomight.exceptions.ServerException;
import biomight.view.BioMightMethodView;
import biomight.view.BioMightPosition;
import biomight.view.BioMightPropertyView;
import biomight.view.BioMightTransform;

/**************************************************************************************
 * @author SurferJim
 *
 * Representation of a Fimbria
 * 
 **************************************************************************************/

public class Fimbria extends BioMightBase {
	private BioMightPosition bioMightPosition;
	private Curlins curlins;

	
	public Fimbria()
	{		
		// Create the Base Fimbria
		int localVP =  Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG2X;
		create(localVP, localLOD, Constants.FimbriaRef, null, null);
	}
	
	public Fimbria(String parentID)
	{				
		int localVP =  Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG2X;
		create(localVP, localLOD, parentID, null, null);	
	}
		

	public Fimbria(String parentID, BioMightPosition bioMightPosition)
	{
		int localVP =  Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG2X;
		create(localVP, localLOD, parentID, null, null);
		this.bioMightPosition = bioMightPosition;
	}

		
	public Fimbria(int localVP, int localLOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
	{		
		create(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);
	}

	
	/*****************************************************************
	 * CREATE
	 * 
	 * @param parentID
	 * @param bioMightMethods
	 ******************************************************************/

	public void create(int localVP, int localLOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
	{
			this.setImage("images/Fimbria.jpg");
			this.setImageHeight(300);
			this.setImageWidth(300);
			this.parentID = parentID;
			this.componentID = parentID;
			this.lod = localLOD;
			this.viewPerspective = localVP;
			
			
			//************************************************************888
			//**************************************************************8
			// HACK
			localLOD = Constants.MAG1X;
			//************************************************************888
			//**************************************************************8
	
			
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
				System.out.println("In Fimbria Create() - ViewInternal - MAG1X - Already Set: " + parentID);				

				// We already have the data for the current instance of Fimbria,
				// Go get the details for the current Fimbria is LOD is set
				if (localLOD == Constants.MAG2X)
				{
					// Go get the finer details of the Fimbria				
					System.out.println("Getting the Fimbria Internal - MAG 2X Details: " + parentID);
					localVP = Constants.VIEW_INTERNAL; 
					localLOD = Constants.MAG1X;
					curlins = new Curlins(localVP, localLOD, componentID, bioMightProperties, bioMightMethods);									
					System.out.println("Fimbria Instance created from SubComponents : " + parentID);
			
					// initialize the Properties
					//initProperty(bioMightTransform.getName(), Constants.Curlins, Constants.CurlinsRef, bioMightTransform.getId());
				}
			
			}	
			else if (localVP == Constants.VIEW_HAWKEYE)
			{
				// This is when one is accessing a Fimbria directly
				// Get the information from the database via the Enterprise Bean		
				try {
					// Get the information from the database via the Enterprise Bean		
					System.out.println("Getting HawkEye FimbriaInfo for ParentID: " + parentID);
					InitialContext ctx = new InitialContext();
					BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
					bioMightTransforms = bioMightBean.getComponent(parentID);
					System.out.println("Have Fimbria Info from EJB");   	
				}catch (Exception e) { 
					System.out.println("Exception Getting Components - Fimbria");
					throw new ServerException("Remote Exception getComponents():", e); 	
				}
					
				// Run through the collection of Fimbrias and build them into the model
				// In the default case, we get one instance of the Fimbria for each eye
				ArrayList transforms = bioMightTransforms.getTransforms();
				System.out.println("Fimbria NumTransforms: " + transforms.size());
				for (int i=0; i<transforms.size(); i++)
				{
					// Get the information for the Fimbria
					BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
					System.out.println("Creating Fimbria: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
					this.componentID = bioMightTransform.getId();

						
					if (localLOD == Constants.MAG1X)
					{
						// initialize the Properties
						System.out.println("Creating Fimbria at MAG 1X - Just creating propeties : " + parentID);
						initProperties();
					}
					if (localLOD == Constants.MAG2X)
					{
						// Go get the finer details of the Fimbria				
						System.out.println("Creating Fimbria at MAG 2X  : " + parentID);
						localVP = Constants.VIEW_HAWKEYE; 
						localLOD = Constants.MAG1X;

						System.out.println("Creating Curlins : " + parentID + " lod: " + localLOD);
						curlins = new Curlins(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
						initProperty(Constants.CurlinsRef, Constants.Curlins, Constants.CurlinsRef, curlins.getComponentID());
						System.out.println("In Fimbria - Curlins is complete");
					
					}
					
				}
			}		
			else
			{
				
			}
				
			initMethods();
			
			System.out.println("CreateFimbria Completed");
			
			// First, get all the data from the database
			// Apply the methods to it
			// Save its state
			this.parentID = parentID;
			if (bioMightMethods != null){
				System.out.println("EXECUTING Fimbria Methods: " + bioMightMethods.size());
				//executeMethods(bioMightMethods);
			}
		}
		

	
		private void initProperties() {
			
			BioMightPropertyView property = new BioMightPropertyView();
			property.setPropertyName("Cell Membrane");
			property.setCanonicalName(Constants.CurlinsRef);
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
			// Generate the Fimbria		
			BioMightBeanLocal bioMightBean;
			try {
				// Get the information from the database via the Enterprise Bean		
				System.out.println("Generating the Fimbria : " + componentID + "    " + parentID);
				InitialContext ctx = new InitialContext();
				bioMightBean = (BioMightBeanLocal) ctx.lookup("java:global/BioMightWeb/BioMightBean!biomight.ejb.BioMightBeanLocal");
		
				double circumference = 0.125;
				
				if (componentID.equals("Fimbria:01")) {
					
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

						
					//int success = bioMightBean.generateFimbria("Fimbria:00001", "Fimbria", 
					//		"Fimbria", componentID, parentID, currentPoints);			
					
				}
				else if (componentID.equals("Fimbria:02"))
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

					
					
					//int success = bioMightBean.generateFimbria("Fimbria:00160", "Fimbria", 
					//	"Fimbria", componentID, parentID, currentPoints);
			
					
				}
				else if (parentID.equals("")) 
				{	
					System.out.println("Calling Generate Fimbria NoParent");		
				}

				
				System.out.println("Created Fimbria Info using EJB");   	
			}catch (Exception e) { 
				System.out.println("Exception Getting Components - Fimbria");
				throw new ServerException("Remote Exception Fimbria():", e); 	
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
			System.out.println("Fimbria Executing Methods");
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
		 * This method will return the X3D for the Fimbria.  It runs through each of its components and collects up their
		 * representations and then assembles them into one unified X3D model.
		 * 
		 ********************************************************************************************************************/
		public String getX3D(boolean snipet) {
			
			// Assembe the Fimbria
			String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
			"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n " +
			"<X3D profile='Immersive' >\n" +
			"<head>\n" +
			 "<meta name='BioMightImage' content='Fimbria.jpg'/>\n" +
			 "<meta name='ExportTime' content='7:45:30'/>\n" +
			 "<meta name='ExportDate' content='08/15/2008'/>\n" +
			 "<meta name='BioMight Version' content='1.0'/>\n" + 
			"</head>\n" +
			"<Scene>\n" +
			"<WorldInfo\n" +
			"title='Fimbria'\n" +
			"info='\"BioMight Generated X3D\"'/>\n";		

			String body = "";
			String annotate = "";
	
			

			//************************************************************888
			//**************************************************************8
			// HACK
			lod = Constants.MAG1X;
			//************************************************************888
			//**************************************************************8
			System.out.println("Getting Fibria Elemental Empty X3D!!!"); 
			body ="";
			return body;
			
			
			/*
		
			// Only when the database retrieval has been locally, do we do this??
			if (viewPerspective == Constants.VIEW_INTERNAL) 
			{			

				if (lod == Constants.MAG1X) 
				{		
					ArrayList transforms = bioMightTransforms.getTransforms();
					for (int i=0; i<transforms.size(); i++)
					{
						// Get the information for the capsomer we are creating
						BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
						System.out.println("Internal 1X - Creating Fimbria: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
						System.out.println("Creating X3D Fimbria Internal at Position: " + 
								bioMightTransform.getTranslation().getXPos() + "  " +
								bioMightTransform.getTranslation().getYPos() + "  " +
								bioMightTransform.getTranslation().getZPos());
						
	
							//System.out.println("Getting X3D for FimbriaX: " + bioMightTransform.getTranslation().getXPos());
							//System.out.println("Getting X3D for FimbriaY: " + bioMightTransform.getTranslation().getYPos());
							//System.out.println("Getting X3D for FimbriaZ: " + bioMightTransform.getTranslation().getZPos());
							// Change the height and width based on the displacement.
							body += "<Transform DEF= 'TRANSFORM_" + bioMightTransform.getId() + "' \n";
							
							
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
							 	"<Shape DEF='SHAPE_" + bioMightTransform.getId() + "' \n" +
							    " containerField='children'>\n" +
							    " <Appearance\n" +
							    "  containerField='appearance'>\n";
							    
							body+= " <ImageTexture containerField='texture' " +
							    " url='../images/Fimbria.jpg'/>";
							
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
							 	"<Cylinder DEF='FimbriaGeoSphere'\n" +
							 	"containerField='geometry'\n" +
							 	"radius='" + bioMightTransform.getRadius() +"'/>\n" +
							 	"height='" + bioMightTransform.getHeight() +"'/>\n" +
							 	"</Shape>\n" +
							 	
								"\n<TouchSensor DEF='TSENSOR_"+ bioMightTransform.getId()+ "' \n" +
				                   " description='Fimbria'\n" +
					               " containerField='children'/> \n" +
				
							 "</Transform>\n";
							
			
						}
				
				}
				else if (lod == Constants.MAG2X)		
				{
					//We are going to get the X3D from the aggregation objects
					// curlins
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
					System.out.println("Getting Fimbria MAG 1X : " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
					System.out.println("Getting X3D HawkEye - Fimbria at Position: " + 
							bioMightTransform.getTranslation().getXPos() + "  " +
							bioMightTransform.getTranslation().getYPos() + "  " +
							bioMightTransform.getTranslation().getZPos());
					
					
					if (lod == Constants.MAG1X)		
					{
						//System.out.println("Getting X3D for FimbriaX: " + bioMightTransform.getTranslation().getXPos());
						//System.out.println("Getting X3D for FimbriaY: " + bioMightTransform.getTranslation().getYPos());
						//System.out.println("Getting X3D for FimbriaZ: " + bioMightTransform.getTranslation().getZPos());
						// Change the height and width based on the displacement.
						body += "<Transform DEF= 'TRANSFORM_" + bioMightTransform.getId() + "' \n";
						
						
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
						 	"<Shape DEF='SHAPE_" + bioMightTransform.getId() + "' \n" +
						    " containerField='children'>\n" +
						    " <Appearance\n" +
						    "  containerField='appearance'>\n";
						    
						body+= " <ImageTexture containerField='texture' " +
						    " url='../images/Fimbria.jpg'/>";
						
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
						 	"<Sphere DEF='FimbriaGeoSphere'\n" +
						 	"containerField='geometry'\n" +
						 	"radius='" + bioMightTransform.getRadius() +"'/>\n" +
						 	"</Shape>\n" +
						 	
							"\n<TouchSensor DEF='TSENSOR_"+ bioMightTransform.getId()+ "' \n" +
			                   " description='Fimbria'\n" +
				               " containerField='children'/> \n" +
			
						 "</Transform>\n";
						
		
						}
						else if (lod == Constants.MAG2X)		
						{
							System.out.println("Getting X3D HawkEye - Fimbria MAG 2X "); 
							body += "";
								
						}
					}
			}
			else 
			{			
				// Issue
			}	
				
			
			//System.out.println("Fimbria X3D: " + body);		
			String footer = "</Scene>" + "</X3D>\n";
			
			if (snipet)
				return body;			
			else	
				return header + body + annotate + footer;
				
			*/
		}



}
