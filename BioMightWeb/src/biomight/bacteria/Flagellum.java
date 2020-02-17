/*
 * Created on Oct 5, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.bacteria;

import java.lang.reflect.Method;
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

/********************************************************************************
 * @author SurferJim
 *
 * Representation of a Flagellum
 * 
 *******************************************************************************/

public class Flagellum extends BioMightBase {
	private BioMightPosition bioMightPosition;
	
	
	/********************************************************************************************************************
	 *  Flagellum
	 * 
	 * This method will instantiate the Flagellum that are defined for the current model.  
	 * 
	 ********************************************************************************************************************/

	public Flagellum()
	{		
		int localVP= Constants.BIO_CHILD;
		int localLOD = Constants.VIEW_HAWKEYE;
		create(localVP, localLOD, Constants.FlagellumRef, null, null);
	}
	
	/********************************************************************************************************************
	 *  Flagellum
	 * 
	 * This method will instantiate the Flagellum that are defined for the current model.  
	 * 
	 ********************************************************************************************************************/

	public Flagellum(String parentID)
	{				
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, parentID, null, null);
	}
	
	
	public Flagellum(int localVP, int localLOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
	{		
		create(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);
	}
	
	
	/********************************************************************************************************************
	 * CREATE Flagellum
	 * 
	 * This method will instantiate the Flagellum that are defined for the current model.  
	 * 
	 ********************************************************************************************************************/

	private void create(int localVP, int localLOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods) 
	{
			this.setImage("images/Flagellum.jpg");
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
	

			if (localVP == Constants.VIEW_INTERNAL)			
			{
				// Do nothing.  We are instantiating as part of a collection  
				// There is no drill down, so we use the transforms that the
				// parent has already collected
				System.out.println("In Flagellum Create() - ViewInternal: " + parentID);				

				// We already have the data for the current instance of Flagellum,
				// Go get the details for the current Flagellum is LOD is set
				if (localLOD == Constants.MAG2X)
				{
					// Go get the finer details of the Flagellum				
					System.out.println("Getting the Flagellum Details: " + parentID);
					localVP = Constants.VIEW_INTERNAL; 
					localLOD = Constants.MAG1X;
				
					System.out.println("In Flagella - Creating ------");
					//flagellum = new Flagellum(bioMightTransform.getId(), bioMightMethods);
					System.out.println("In Flagella - Flagella -------- is complete");
			
					// initialize the Properties
					//initProperty(bioMightTransform.getName(), Constants.Flagellum, Constants.FlagellumRef, bioMightTransform.getId());
				}
			
			}	
			else if (localVP == Constants.VIEW_HAWKEYE)
			{
				// This is when one is accessing a Flagellum directly
				// Get the information from the database via the Enterprise Bean		
				try {
					// Get the information from the database via the Enterprise Bean		
					System.out.println("Getting HawkEye FlagellumInfo for ParentID: " + parentID);
					InitialContext ctx = new InitialContext();
					BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
					bioMightTransforms = bioMightBean.getComponent(parentID);
					System.out.println("Have Flagellum Info from EJB");   	
				}catch (Exception e) { 
					System.out.println("Exception Getting Components - Flagellum");
					throw new ServerException("Remote Exception getComponents():", e); 	
				}
					
				// Run through the collection of Flagellums and build them into the model
				// In the default case, we get one instance of the Flagellum for each eye
				ArrayList transforms = bioMightTransforms.getTransforms();
				System.out.println("Flagellum NumTransforms: " + transforms.size());
				for (int i=0; i<transforms.size(); i++)
				{
					// Get the information for the Flagellum
					BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
					System.out.println("Creating Flagellum: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
					this.componentID = bioMightTransform.getId();


					if (localLOD == Constants.MAG1X)
					{
						// initialize the Properties
						initProperties();
					}
					if (localLOD == Constants.MAG2X)
					{
						// Go get the finer details of the Flagellum				
						System.out.println("Creating HawkEye MAG2X Flagellum : " + parentID + " lod: " + localLOD);
						localVP = Constants.VIEW_HAWKEYE; 
						localLOD = Constants.MAG1X;

						//System.out.println("Creating FlagellaMembrane : " + parentID + " lod: " + localLOD);
						//cellMembrane = new FlagellaMembrane(localVP, localLOD, bioMightTransform.getId(), bioMightMethods);
						//initProperty(Constants.FlagellaMembraneRef, Constants.FlagellaMembrane, Constants.FlagellaMembraneRef, cellMembrane.getComponentID());
						System.out.println("Flagellum HawkEye MAG2X : " + parentID);
					
						//System.out.println("In Flagellums -");
						//flagellums = new Flagellums(bioMightTransform.getId(), bioMightMethods);
						//initProperty(Constants.FlagellumRef, Constants.Flagellum, Constants.FlagellumRef, flagellums.getComponentID());
						//System.out.println("In Flagella - Flagella Membrane is complete");		
					}
					
				}
			}		
			else
			{
				
			}
				
			initMethods();
			
			System.out.println("CreateFlagellum Completed");
			
			// First, get all the data from the database
			// Apply the methods to it
			// Save its state
			this.parentID = parentID;
			if (bioMightMethods != null){
				System.out.println("EXECUTING Flagellum Methods: " + bioMightMethods.size());
				//executeMethods(bioMightMethods);
			}
		}
		

	
		private void initProperties() {

			properties = new ArrayList<BioMightPropertyView>();
			
			BioMightPropertyView property = new BioMightPropertyView();
			property.setPropertyName("Flagellum");
			property.setCanonicalName(Constants.FlagellumRef);
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
			// Generate the Flagellum		
			BioMightBeanLocal bioMightBean;
			try {
				// Get the information from the database via the Enterprise Bean		
				System.out.println("Generating the Flagellum : " + componentID + "    " + parentID);
				InitialContext ctx = new InitialContext();
				bioMightBean = (BioMightBeanLocal) ctx.lookup("java:global/BioMightWeb/BioMightBean!biomight.ejb.BioMightBeanLocal");
		
				double circumference = 0.125;
				
				if (componentID.equals("Flagellum:01")) {
					
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

						
					//int success = bioMightBean.generateFlagellum("Flagellum:00001", "Flagellum", 
					//		"Flagellum", componentID, parentID, currentPoints);			
					
				}
				else if (componentID.equals("Flagellum:02"))
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

					
					
					//int success = bioMightBean.generateFlagellum("Flagellum:00160", "Flagellum", 
					//	"Flagellum", componentID, parentID, currentPoints);
			
					
				}
				else if (parentID.equals("")) 
				{	
					System.out.println("Calling Generate Flagellum NoParent");		
				}

				
				System.out.println("Created Flagellum Info using EJB");   	
			}catch (Exception e) { 
				System.out.println("Exception Getting Components - Flagellum");
				throw new ServerException("Remote Exception Flagellum():", e); 	
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
			System.out.println("Flagellum Executing Methods");
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
		 * This method will return the X3D for the Flagellum.  It runs through each of its components and collects up their
		 * representations and then assembles them into one unified X3D model.
		 * 
		 ********************************************************************************************************************/
		public String getX3D(boolean snipet) {
			
			// Assembe the Flagellum
			String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
			"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n " +
			"<X3D profile='Immersive' >\n" +
			"<head>\n" +
			 "<meta name='BioMightImage' content='Flagellum.jpg'/>\n" +
			 "<meta name='ExportTime' content='7:45:30'/>\n" +
			 "<meta name='ExportDate' content='08/15/2008'/>\n" +
			 "<meta name='BioMight Version' content='1.0'/>\n" + 
			"</head>\n" +
			"<Scene>\n" +
			"<WorldInfo\n" +
			"title='Flagellum'\n" +
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
						System.out.println("Internal 1X - Creating Flagellum: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
						System.out.println("Creating X3D Flagellum Internal at Position: " + 
								bioMightTransform.getTranslation().getXPos() + "  " +
								bioMightTransform.getTranslation().getYPos() + "  " +
								bioMightTransform.getTranslation().getZPos());
						
	
							//System.out.println("Getting X3D for FlagellumX: " + bioMightTransform.getTranslation().getXPos());
							//System.out.println("Getting X3D for FlagellumY: " + bioMightTransform.getTranslation().getYPos());
							//System.out.println("Getting X3D for FlagellumZ: " + bioMightTransform.getTranslation().getZPos());
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
							    " url='../images/Flagellum.jpg'/>";
							
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
							 	"<Cylinder DEF='FlagellumGeoSphere'\n" +
							 	"containerField='geometry'\n" +
							 	"radius='" + bioMightTransform.getRadius() +"'/>\n" +
							 	"height='" + bioMightTransform.getHeight() +"'/>\n" +
							 	"</Shape>\n" +
							 	
								"\n<TouchSensor DEF='TSENSOR_"+ bioMightTransform.getId()+ "' \n" +
				                   " description='Flagellum'\n" +
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
					System.out.println("Getting Flagellum MAG 1X : " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
					System.out.println("Getting X3D HawkEye - Flagellum at Position: " + 
							bioMightTransform.getTranslation().getXPos() + "  " +
							bioMightTransform.getTranslation().getYPos() + "  " +
							bioMightTransform.getTranslation().getZPos());
					
					
					if (lod == Constants.MAG1X)		
					{
						//System.out.println("Getting X3D for FlagellumX: " + bioMightTransform.getTranslation().getXPos());
						//System.out.println("Getting X3D for FlagellumY: " + bioMightTransform.getTranslation().getYPos());
						//System.out.println("Getting X3D for FlagellumZ: " + bioMightTransform.getTranslation().getZPos());
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
						    " url='../images/Flagellum.jpg'/>";
						
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
						 	"<Sphere DEF='FlagellumGeoSphere'\n" +
						 	"containerField='geometry'\n" +
						 	"radius='" + bioMightTransform.getRadius() +"'/>\n" +
						 	"</Shape>\n" +
						 	
							"\n<TouchSensor DEF='TSENSOR_"+ bioMightTransform.getId()+ "' \n" +
			                   " description='Flagellum'\n" +
				               " containerField='children'/> \n" +
			
						 "</Transform>\n";
						
		
						}
						else if (lod == Constants.MAG2X)		
						{
							System.out.println("Getting X3D HawkEye - Flagellum MAG 2X "); 
							body += "";
								
						}
					}
			}
			else 
			{			
				// Issue
			}	
				
			
			//System.out.println("Flagellum X3D: " + body);		
			String footer = "</Scene>" + "</X3D>\n";
			
			if (snipet)
				return body;			
			else	
				return header + body + annotate + footer;
				
			*/
		}


}
