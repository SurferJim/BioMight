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
import biomight.ejb.BioMightBeanLocal;
import biomight.exceptions.ServerException;
import biomight.view.BioMightMethodView;
import biomight.view.BioMightPosition;
import biomight.view.BioMightPropertyView;
import biomight.view.BioMightTransform;


/****************************************************************************
 * @author SurferJim
 *
 * Representation of a Mesosome
 * 
 ****************************************************************************/

public class Mesosome extends BioMightBase {
	private BioMightPosition bioMightPosition;
	
	
	/********************************************************************************************************************
	 *  Mesosome
	 * 
	 * This method will instantiate the Mesosome that are defined for the current model.  
	 * 
	 ********************************************************************************************************************/

	public Mesosome()
	{		
		int localVP= Constants.BIO_CHILD;
		int localLOD = Constants.VIEW_HAWKEYE;
		create(localVP, localLOD, Constants.CellsRef, null, null);
	}
	
	/********************************************************************************************************************
	 *  Mesosome
	 * 
	 * This method will instantiate the Mesosome that are defined for the current model.  
	 * 
	 ********************************************************************************************************************/

	public Mesosome(String parentID)
	{				
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, parentID, null, null);
	}
	
	public Mesosome(int localVP, int localLOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
	{		
		create(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);
	}
	
	
	/********************************************************************************************************************
	 * CREATE Mesosome
	 * 
	 * This method will instantiate the hips that are defined for the current model.  
	 * 
	 ********************************************************************************************************************/

	private void create(int localVP, int localLOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods) 
	{
			this.setImage("images/Mesosome.jpg");
			this.setImageHeight(300);
			this.setImageWidth(300);
			this.parentID = parentID;
			this.componentID = parentID;	
			this.lod = localLOD;
			this.viewPerspective = localVP;
			

			if (localVP == Constants.VIEW_INTERNAL)			
			{
				// Do nothing.  We are instantiating as part of a collection  
				// There is no drill down, so we use the transforms that the
				// parent has already collected
				System.out.println("In Mesosome Create() - Already Set: " + parentID);				

				// We already have the data for the current instance of Mesosome,
				// Go get the details for the current Mesosome is LOD is set
				if (localLOD == Constants.MAG2X)
				{
					// Go get the finer details of the Mesosome				
					System.out.println("Getting the Mesosome Details: " + parentID);
					localVP = Constants.VIEW_INTERNAL; 
					localLOD = Constants.MAG1X;
					//cellMembrane = new CellMembrane(localVP, localLOD, componentID, bioMightMethods);									
					System.out.println("Mesosome Instance created from SubComponents : " + parentID);
				
					//System.out.println("In Cell - Creating Mesosomes");
					//mesosomes = new Mesosomes(bioMightTransform.getId(), bioMightMethods);
					//System.out.println("In Cell - Cell Membrane is complete");
			
					// initialize the Properties
					//initProperty(bioMightTransform.getName(), Constants.Mesosome, Constants.MesosomeRef, bioMightTransform.getId());
				}
			
			}	
			else if (localVP == Constants.VIEW_HAWKEYE)
			{
				// This is when one is accessing a Mesosome directly
				// Get the information from the database via the Enterprise Bean		
				try {
					// Get the information from the database via the Enterprise Bean		
					System.out.println("Getting HawkEye MesosomeInfo for ParentID: " + parentID);
					InitialContext ctx = new InitialContext();
					BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
					bioMightTransforms = bioMightBean.getComponent(parentID);
					System.out.println("Have Mesosome Info from EJB");   	
				}catch (Exception e) { 
					System.out.println("Exception Getting Components - Mesosome");
					throw new ServerException("Remote Exception getComponents():", e); 	
				}
					
				// Run through the collection of Mesosomes and build them into the model
				// In the default case, we get one instance of the Mesosome for each eye
				ArrayList transforms = bioMightTransforms.getTransforms();
				System.out.println("Mesosome NumTransforms: " + transforms.size());
				for (int i=0; i<transforms.size(); i++)
				{
					// Get the information for the Mesosome
					BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
					System.out.println("Creating Mesosome: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
					this.componentID = bioMightTransform.getId();


					if (localLOD == Constants.MAG1X)
					{
						// initialize the Properties
						initProperties();
					}
					if (localLOD == Constants.MAG2X)
					{
						// Go get the finer details of the Mesosome				
						System.out.println("Creating HawkEye MAG2X Mesosome : " + parentID + " lod: " + localLOD);
						localVP = Constants.VIEW_HAWKEYE; 
						localLOD = Constants.MAG1X;

						//System.out.println("Creating CellMembrane : " + parentID + " lod: " + localLOD);
						//cellMembrane = new CellMembrane(localVP, localLOD, bioMightTransform.getId(), bioMightMethods);
						//initProperty(Constants.CellMembraneRef, Constants.CellMembrane, Constants.CellMembraneRef, cellMembrane.getComponentID());
						System.out.println("Mesosome HawkEye MAG2X : " + parentID);
					
						//System.out.println("In Mesosomes -");
						//mesosomes = new Mesosomes(bioMightTransform.getId(), bioMightMethods);
						//initProperty(Constants.MesosomeRef, Constants.Mesosome, Constants.MesosomeRef, mesosomes.getComponentID());
						//System.out.println("In Cell - Cell Membrane is complete");		
					}
					
				}
			}		
			else
			{
				
			}
				
			initMethods();
			
			System.out.println("CreateMesosome Completed");
			
			// First, get all the data from the database
			// Apply the methods to it
			// Save its state
			this.parentID = parentID;
			if (bioMightMethods != null){
				System.out.println("EXECUTING Mesosome Methods: " + bioMightMethods.size());
				//executeMethods(bioMightMethods);
			}
		}
		

	
		private void initProperties() {

			properties = new ArrayList<BioMightPropertyView>();
			
			BioMightPropertyView property = new BioMightPropertyView();
			property.setPropertyName("Cell Membrane");
			property.setCanonicalName(Constants.CellMembraneRef);
			properties.add(property);

			property = new BioMightPropertyView();
			property.setPropertyName("Mesosome");
			property.setCanonicalName(Constants.MesosomeRef);
			properties.add(property);
		
			property = new BioMightPropertyView();
			property.setPropertyName("Lyososome");
			property.setCanonicalName(Constants.LysosomeRef);
			properties.add(property);			
		}
		
		
		/****************************************************
		 * GENERATE ENDOSOME
		 * 
		 * 
		 * @param parentID
		 * @param componentID
		 ***************************************************/
		public void generate(String parentID, String componentID)
		{
			// Generate the Mesosome		
			BioMightBeanLocal bioMightBean;
			try {
				// Get the information from the database via the Enterprise Bean		
				System.out.println("Generating the Mesosome : " + componentID + "    " + parentID);
				InitialContext ctx = new InitialContext();
				bioMightBean = (BioMightBeanLocal) ctx.lookup("java:global/BioMightWeb/BioMightBean!biomight.ejb.BioMightBeanLocal");
		
				double circumference = 0.125;
				
				if (componentID.equals("Mesosome:01")) {
					
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

						
					//int success = bioMightBean.generateMesosome("Mesosome:00001", "Mesosome", 
					//		"Mesosome", componentID, parentID, currentPoints);			
					
				}
				else if (componentID.equals("Mesosome:02"))
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

					
					
					//int success = bioMightBean.generateMesosome("Mesosome:00160", "Mesosome", 
					//	"Mesosome", componentID, parentID, currentPoints);
			
					
				}
				else if (parentID.equals("")) 
				{	
					System.out.println("Calling Generate Mesosome NoParent");		
				}

				
				System.out.println("Created Mesosome Info using EJB");   	
			}catch (Exception e) { 
				System.out.println("Exception Getting Components - Mesosome");
				throw new ServerException("Remote Exception Mesosome():", e); 	
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
		
		
	
	

		public ArrayList getProperties() {
			return properties;
		}
		

		public ArrayList getMethods() {		
			return methods;
		}
		
		/******************************************************************************************
		 * EXECUTE METHODS 
		 *
		 ******************************************************************************************/
		public void executeMethods(ArrayList<String> methodParams) {

			// Run through the argument list and execute the 
			// associated methods
			System.out.println("Mesosome Executing Methods");
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
		 * This method will return the X3D for the Mesosome.  It runs through each of its components and collects up their
		 * representations and then assembles them into one unified X3D model.
		 * 
		 ********************************************************************************************************************/
		public String getX3D(boolean snipet) {
			
			// Assembe the Mesosome
			String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
			"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n " +
			"<X3D profile='Immersive' >\n" +
			"<head>\n" +
			 "<meta name='BioMightImage' content='Mesosome.jpg'/>\n" +
			 "<meta name='ExportTime' content='7:45:30'/>\n" +
			 "<meta name='ExportDate' content='08/15/2008'/>\n" +
			 "<meta name='BioMight Version' content='1.0'/>\n" + 
			"</head>\n" +
			"<Scene>\n" +
			"<WorldInfo\n" +
			"title='Mesosome'\n" +
			"info='\"BioMight Generated X3D\"'/>\n";		

			String body = "";
			String annotate = "";
			
			
			// Only when the database retrieval has been locally, do we do this??
			if (viewPerspective == Constants.VIEW_INTERNAL) 
			{			
				// We do nada as the Mesosome Data is retrieved in the collection object
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
					System.out.println("Creating Mesosome: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
					System.out.println("Creating Mesosome at Position: " + 
							bioMightTransform.getTranslation().getXPos() + "  " +
							bioMightTransform.getTranslation().getYPos() + "  " +
							bioMightTransform.getTranslation().getZPos());
					
					// Grab the data
					if (lod == Constants.MAG1X)		
					{
						//System.out.println("Getting X3D for MesosomeX: " + bioMightTransform.getTranslation().getXPos());
						//System.out.println("Getting X3D for MesosomeY: " + bioMightTransform.getTranslation().getYPos());
						//System.out.println("Getting X3D for MesosomeZ: " + bioMightTransform.getTranslation().getZPos());
						// Change the height and width based on the displacement.
						body += "<Transform DEF='Mesosome'\n";
						
						
						// Set the position if we are working with the Tissue collection
						if (parentID.equals("1.10000:0"))
						{
							//body += "translation='" 
							//	+ bioMightPosition.getXPos() + " " 
					 		//	+ bioMightPosition.getYPos() + " "
					 		//	+ bioMightPosition.getZPos() + "'\n";
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
						 	"<Shape DEF='Mesosome'\n" +
						    " containerField='children'>\n" +
						    " <Appearance\n" +
						    "  containerField='appearance'>\n";
						    
					
						body+= " <ImageTexture containerField='texture' " +
						    " url='../images/Mesosome.jpg'/>";
						
						
						    
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
						 	"<Sphere DEF='MesosomeGeoSphere'\n" +
						 	"containerField='geometry'\n" +
						 	"radius='" + bioMightTransform.getRadius() +"'/>\n" +
						 	"</Shape>\n" +
						 	
							"\n<TouchSensor DEF='"+bioMightTransform.getId()+"' \n" +
			                   " description='Mesosome'\n" +
				               " containerField='children'/> \n" +
			
						 "</Transform>\n";
						
							//	Add the text to the Tissue sample
							if (parentID.equals("1.10000:0"))
							{
								annotate = 
									"<Transform DEF='MesosomeText' \n" +
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
									"string='\"Mesosomes\"'\n" +
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
							//body += cellMembrane.getX3D(true) +
							//mesosomes.getX3D(true);
						}
					}
			}
			else 
			{			
				// Issue
			}	
				
			
			//System.out.println("Mesosome X3D: " + body);		
			String footer = "</Scene>" + "</X3D>\n";
			
			if (snipet)
				return body;			
			else	
				return header + body + annotate + footer;				
		}

}
