/*
 * Created on Jun 3, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
 
package biomight.chemistry.nucleicacid.nucleotide;
import java.util.ArrayList;
import java.util.HashMap;

import javax.naming.InitialContext;

import biomight.BioMightBase;
import biomight.Constants;
import biomight.chemistry.elements.Carbon;
import biomight.chemistry.elements.Nitrogen;
import biomight.ejb.BioMightBeanLocal;
import biomight.ejb.BioMightDNABeanLocal;
import biomight.exceptions.ServerException;
import biomight.util.BioGraphics;
import biomight.view.BioMightMethodView;
import biomight.view.BioMightPosition;
import biomight.view.BioMightPropertyView;
import biomight.view.BioMightTransform;


/******************************************************************************
 * @author SurferJim
 *
 * Create a representation of a Nucleobase
 ******************************************************************************/

public class Nucleobase extends BioMightBase {
	private BioMightPosition bioMightPosition;
 	private Nitrogen nitrogen;
 	private Carbon carbon;
	private Object someBase;
	private String baseName="";
	
	
	public Nucleobase()
	{		
		// Create the Base Nucleobase
		int localVP =  Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG2X;
		create(localVP, localLOD, Constants.NucleobaseRef, null, null);
	}
	
	public Nucleobase(String parentID)
	{				
		int localVP =  Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG2X;
		create(localVP, localLOD, parentID, null, null);	
	}
		

	public Nucleobase(String parentID, BioMightPosition bioMightPosition)
	{
		int localVP =  Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG2X;
		create(localVP, localLOD, parentID, null, null);
		this.bioMightPosition = bioMightPosition;
	}
	
	
	// When we are drilling into the component from the View Page, we will set
	// the LOD to HAWK-EYE, which means fine detail.
	public Nucleobase(String parentID, ArrayList<BioMightMethodView> bioMightMethods)
	{		
		int localVP =  Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG2X;
		create(localVP, localLOD,  parentID, null, bioMightMethods);	
	}
		
	// We are looking at the object from a collection.  It was created via
	// the Nucleobases parent object and we do not have  to go to the database 
	// to get additional informaion
	
	public Nucleobase(int localVP, int localLOD, String parentID,  ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
	{
		localVP =  Constants.VIEW_DETACHED;
		localLOD = Constants.MAG1X;		
		create(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);
	}
	
	
	public void create(int localVP, int localLOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
	{
			this.setImage("images/Nucleobase.jpg");
			this.setImageHeight(300);
			this.setImageWidth(300);
			this.lod = localLOD;
			this.viewPerspective = localVP;
	
			
			// There are 4 modes in which this object will be created
			// 1 - Being instantiated as part of a collection.
			// 2 - Being instantiated when drilling down from a collection, will need to get component by ID
			// 3 - Being instantiated when drilling down directly to an individual nucleobase as the parent only has 1
			// 4 - Need level of detail to determine if aggregated, or get current level
			// 4 - 
			if (localVP == Constants.VIEW_INTERNAL)			
			{
				this.componentID = parentID;
			
				// Do nothing.  We are instantiating as part of a collection  
				// There is no drill down, so we use the transforms that the
				// parent has already collected
				System.out.println("In Nucleobase Create() - ViewInternal - Gathered by parent: " + parentID);				
					

				if (localLOD == Constants.MAG2X)
				{
					// Go get the finer details of the Ribose				
					System.out.println("Nucleobase Internal 2X - Gettin' Details : " + parentID + " lod: " + localLOD);
				}
				
			}
			else if (localVP == Constants.VIEW_DETACHED)
			{	
				this.parentID = parentID;
				this.componentID = componentID;
		
				
				// Generate the Ribose that the user desires if needed 
				boolean bGenerate = true;
				if (bGenerate) {
					generate(parentID, componentID);
				}
		
				// Get the information from the database via the Enterprise Bean.  This will get
				// a collection of Nucleobases
				try {
					// Get the information from the database via the Enterprise Bean		
					System.out.println("Getting Nucleobase Transform: " + componentID + "   " +  parentID);
					InitialContext ctx = new InitialContext();
					BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
					bioMightTransforms = bioMightBean.getComponents(Constants.NucleobaseRef, parentID);   	
				}catch (Exception e) { 
					System.out.println("Exception Getting Components - Nucleobases");
					throw new ServerException("Remote Exception getComponents():", e); 	
				}
						
				// Run through the collection of nucleobases and build them into the model
				ArrayList transforms = bioMightTransforms.getTransforms();
				System.out.println("Have Nucleobases NumTransforms: " + transforms.size());
				
				// If we are culling the data set
				int numRetreive=transforms.size();
				//if (parentID.equals("Cells"))
				
				// There should be only 1
				for (int i=0; i<transforms.size(); i++)
				{
					// Get the information for the nucleobase we are creating
					BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
					System.out.println("Creating Nucleobase: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
					this.componentID = bioMightTransform.getId();
					
				
					if (localLOD == Constants.MAG1X)
					{
						System.out.println("Nucleobase Detached - 1x View - parent : " + parentID);
						// initialize the Properties
						initProperties();
					}
					else if (localLOD == Constants.MAG2X)
					{
						// Go get the finer details of the Ribose				
						System.out.println("Nucleobase Detached - 2x View Creating SubComponents using parent : " + parentID);
						localVP = Constants.VIEW_HAWKEYE; 
						localLOD = Constants.MAG1X;

						System.out.println("Creating NitroGen : " + parentID + " lod: " + localLOD);
						//ribose = new Ribose(localVP, localLOD, bioMightTransform.getId(), bioMightMethods);
						//initProperty(Constants.RiboseRef, Constants.Ribose, Constants.RiboseRef, ribose.getComponentID());
						System.out.println("Nitogen is complete");
					}				
					
				}			

				// Set up methods that will be available to the nucleobases
				initMethods();
		
			}	
			else if (localVP == Constants.VIEW_HAWKEYE)
			{
				// This is when one is accessing a Nucleobase directly
				//System.out.println("In Nucleobase Create() - Getting Name from properties: " + bioMightProperties.get(0).getPropertyName());				

				// Generate the Nucleobase that the user desires if needed 
				boolean bGenerate = true;
				if (bGenerate) {
					generate(parentID, componentID);
				}
		
				
				// Get the information from the database via the Enterprise Bean		
				try {
					// Get the information from the database via the Enterprise Bean		
					System.out.println("Getting HawkEye NucleobaseInfo for ParentID: " + parentID);
					InitialContext ctx = new InitialContext();
					BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
					bioMightTransforms = bioMightBean.getComponent(parentID);
					System.out.println("Have Nucleobase Info from EJB");   	
				}catch (Exception e) { 
					System.out.println("Exception Getting Components - Nucleobase");
					throw new ServerException("Remote Exception getComponents():", e); 	
				}
					
				// Run through the collection of Nucleobases and build them into the model
				ArrayList transforms = bioMightTransforms.getTransforms();
				System.out.println("Nucleobase NumTransforms: " + transforms.size());
				for (int i=0; i<transforms.size(); i++)
				{
					// Get the information for the Nucleobase
					BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
					System.out.println("Creating HawkEye Nucleobase: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
					this.componentID = bioMightTransform.getId();
					String nucleobaseName = bioMightTransform.getName();

					if (localLOD == Constants.MAG1X)
					{
						System.out.println("Nucleobase 1x View - parent : " + parentID + " nucleobase " + nucleobaseName);
						// initialize the Properties
						initProperties();
					}
					else if (localLOD == Constants.MAG2X)
					{
						// Go get the finer details of the Ribose				
						System.out.println("Nucleobase Hawkeye - Creating group : " + parentID + " lod: " + localLOD);
						localVP = Constants.VIEW_HAWKEYE; 
						localLOD = Constants.MAG1X;

						//System.out.println("Creating Nitrogen : " + parentID + " lod: " + localLOD);
						//nitrogen = new Nitrogen(localVP, localLOD, bioMightTransform.getId(), bioMightMethods);
						//initProperty(Constants.NitrogenRef, Constants.Nitrogen, Constants.NitrogenRef, nitrogen.getComponentID());
						//System.out.println("Nitrogen is complete");				
					}
					
				}
			}		
			else
			{
				
			}
				
			initMethods();
			
			System.out.println("CreateNucleobase Completed");
			
			// First, get all the data from the database
			// Apply the methods to it
			// Save its state
			this.parentID = parentID;
			if (bioMightMethods != null){
				//System.out.println("EXECUTING Nucleobase Methods: " + bioMightMethods.size());
				//executeMethods(bioMightMethods);
			}
		}
		
	
		private void initProperties() {
					
			String dimensions = "0.00, 0.00, 0.00";
			String bioPos = "0.00, 0.00, 0.00";
			
			System.out.println("Nucleobase InitProperties: " + componentID);
			
			initProperty("Nitrogen", Constants.Nitrogen, Constants.NitrogenRef, componentID, bioPos, dimensions, Constants.SINGLE_COMPONENT, false);
			initProperty("Carbon", Constants.Carbon, Constants.CarbonRef, componentID, bioPos, dimensions, Constants.SINGLE_COMPONENT, false);
			
			if (baseName.equals(Constants.AdenineRef))
				initProperty(baseName, Constants.Adenine, Constants.AdenineRef, componentID, bioPos, dimensions, Constants.SINGLE_COMPONENT, false);
			else if (baseName.equals(Constants.Cytosine)) 
				initProperty(baseName, Constants.Cytosine, Constants.CytosineRef, componentID, bioPos, dimensions, Constants.SINGLE_COMPONENT, false);
			else if (baseName.equals(Constants.Guanine))
				initProperty(baseName, Constants.Guanine, Constants.GuanineRef, componentID, bioPos, dimensions, Constants.SINGLE_COMPONENT, false);
			else if (baseName.equals(Constants.Thymine))
				initProperty(baseName, Constants.Thymine, Constants.ThymineRef, componentID, bioPos, dimensions, Constants.SINGLE_COMPONENT, false);
				 
		}
		
		
		/**************************************************************************
		 * GENERATE NUCLEOTIDE
		 * 
		 * @param parentID
		 * @param componentID
		 *************************************************************************/
		public void generate(String parentID, String componentID)
		{
			// Generate the Nucleobase		
			BioMightDNABeanLocal bioMightBean;
			try {
				// Get the information from the database via the Enterprise Bean		
				System.out.println("Generating the Nucleobase : " + componentID + "    " + parentID);
				InitialContext ctx = new InitialContext();
				bioMightBean = (BioMightDNABeanLocal) ctx.lookup("java:global/BioMightWeb/BioMightDNABean!biomight.ejb.BioMightDNABeanLocal");
		
				double circumference = 0.125;
				
				// We should create the Nucleobase based upon where it is in the body.
				// The position would be in the hunndred thousand trillions.  
				// We can grid off the body and then everything has an offset off the base
				// As a user will have a limited domain we allow them to have only so many per com
				
				// There will be a bunch of users all trying to find out where they are going to put their
				// rows in the database.   I believe we can number everything the same across models.  
				// They can all use the exact same numbering scheme.   When it stores in the database the
				// Body ID the Project ID will be used to isolate the insert into various parts of the database
				// no two users will every be selecting from the 
				
					
				// Generate the Palm
				double[] startPos = {0.0, 0.0, 0.0};
				
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

					
				//int success = bioMightBean.generateNucleobase(Constants.AdenineRef, "Nucleobase:00001", "Nucleobase", 
				//		"Nucleobase", componentID, parentID, currentPoints);			
					
				System.out.println("Created Nucleobase Info using EJB");   	
			}catch (Exception e) { 
				System.out.println("Exception Getting Components - Nucleobase");
				throw new ServerException("Remote Exception Nucleobase():", e); 	
			}
		}
		
		
		
		// This method will store the method list into the 
		// BioMightBase object. 
		private void initMethods() {
			BioMightMethodView method = new BioMightMethodView();
			
			method = new BioMightMethodView();
			method.setCanonicalName(Constants.Guanine);
			method.setMethodName("setSugar");
			method.setDisplayName("Sugar:");
			method.setHtmlType("dropdown");
			method.setDataType("String");
	     	HashMap sugarType = new HashMap();
	     	sugarType.put("Ribose", "Ribose");
	     	sugarType.put("2-DeoxyRibose", "2-DeoxyRibose");
	    	method.setValueMap(sugarType);
			method.setDataType("String");
			methods.add(method);

			method = new BioMightMethodView();
			method.setCanonicalName(Constants.Guanine);
			method.setMethodName("setNuceloBase");
			method.setDisplayName("Nucleobase:");
			method.setHtmlType("dropdown");
			method.setDataType("String");
	     	HashMap bodyType = new HashMap();
	     	bodyType.put("Adenine", "Adenine");
	     	bodyType.put("Cytosine", "Cytosine");
	     	bodyType.put("Guanine", "Guanine");
	    	bodyType.put("Thymine", "Thymine");
	    	method.setValueMap(bodyType);
			method.setDataType("String");
			methods.add(method);
		}
		
		
		
		/******************************************************************************************
		 * EXECUTE METHODS 
		 *
		 ******************************************************************************************/
		public void executeMethods(ArrayList<String> methodParams) {

			// Run through the argument list and execute the 
			// associated methods
			System.out.println("Nucleobase Executing Methods");
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
		 * This method will return the X3D for the Nucleobase.  It runs through each of its components and collects up their
		 * representations and then assembles them into one unified X3D model.
		 * 
		 ********************************************************************************************************************/
		public String getX3D(boolean snipet) {
			
			// Assembe the Nucleobase
			String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
			"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n " +
			"<X3D profile='Immersive' >\n" +
			"<head>\n" +
			 "<meta name='BioMightImage' content='Nucleobase.jpg'/>\n" +
			 "<meta name='ExportTime' content='7:45:30'/>\n" +
			 "<meta name='ExportDate' content='08/15/2008'/>\n" +
			 "<meta name='BioMight Version' content='1.0'/>\n" + 
			"</head>\n" +
			"<Scene>\n" +
			"<WorldInfo\n" +
			"title='Nucleobase'\n" +
			"info='\"BioMight Generated X3D\"'/>\n";		

			String body = "";
			String annotate = "";
			
			
			// Only when the database retrieval has been locally, do we do this??
			if (viewPerspective == Constants.VIEW_INTERNAL) 
			{			
				
				if (lod == Constants.MAG1X)		
				{
		
				}
				
				// We do nada as the Nucleobase Data is retrieved in the collection object
				// and the X3D is generated there
				else if (lod == Constants.MAG2X)		
				{
					//We are going to get the X3D from the aggregation objects
				}
			}
			else if (viewPerspective == Constants.VIEW_DETACHED) 
			{			
				
				if (lod == Constants.MAG1X)		
				{
					ArrayList transforms = bioMightTransforms.getTransforms();
					for (int i=0; i<transforms.size(); i++)
					{
						// Get the information for the capsomer we are creating
						BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
						System.out.println("In Nucleobase - Creating Nucleobase Detached: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
						System.out.println("In Nucleobase - Creating Nucleobase at Position: " + 
								bioMightTransform.getTranslation().getXPos() + "  " +
								bioMightTransform.getTranslation().getYPos() + "  " +
								bioMightTransform.getTranslation().getZPos());
						
						// Grab the data
						if (lod == Constants.MAG1X)		
						{
							//System.out.println("Getting X3D for NucleobaseX: " + bioMightTransform.getTranslation().getXPos());
							//System.out.println("Getting X3D for NucleobaseY: " + bioMightTransform.getTranslation().getYPos());
							//System.out.println("Getting X3D for NucleobaseZ: " + bioMightTransform.getTranslation().getZPos());
							// Change the height and width based on the displacement.
										
							// Create the Nuceotide representation
							body += getX3D(bioMightTransform);
							
						}
						else if (lod == Constants.MAG2X)		
						{
							body += ""; //nitrogen.getX3D(true) + carbon.getX3D(true);
						}
					}
		
				}
				
				// We do nada as the Nucleobase Data is retrieved in the collection object
				// and the X3D is generated there
				else if (lod == Constants.MAG2X)		
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
					System.out.println("In Nucleobase - Creating Nucleobase Hawkeye: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
					System.out.println("In Nucleobase - Creating Nucleobase at Position: " + 
							bioMightTransform.getTranslation().getXPos() + "  " +
							bioMightTransform.getTranslation().getYPos() + "  " +
							bioMightTransform.getTranslation().getZPos());
					
					// Grab the data
					if (lod == Constants.MAG1X)		
					{
						//System.out.println("Getting X3D for NucleobaseX: " + bioMightTransform.getTranslation().getXPos());
						//System.out.println("Getting X3D for NucleobaseY: " + bioMightTransform.getTranslation().getYPos());
						//System.out.println("Getting X3D for NucleobaseZ: " + bioMightTransform.getTranslation().getZPos());
						// Change the height and width based on the displacement.
									
						// Create the Nuceotide representation
						body += getX3D(bioMightTransform);
						
					}
					else if (lod == Constants.MAG2X)		
					{
						body += ""; //nitrogen.getX3D(true) + carbon.getX3D(true);
					}
				}
			}
			else 
			{			
				// Issue
			}	
				
			
			//System.out.println("Nucleobase X3D: " + body);		
			String footer = "</Scene>" + "</X3D>\n";
			
			if (snipet)
				return body;			
			else	
				return header + body + annotate + footer;				
		}


		
		/********************************************************************************************************************
		 * GET X3D
		 * 
		 * This method will return the X3D for the Nucleobase.  It runs through each of its components and collects up their
		 * representations and then assembles them into one unified X3D model.
		 * 
		 ********************************************************************************************************************/
		public String getX3D(BioMightTransform bioMightTransform) 
		{
			String body = "";
			double angle = 0.0;
			
			double x = bioMightTransform.getTranslation().getXPos();
			double y = bioMightTransform.getTranslation().getYPos();
			double z = bioMightTransform.getTranslation().getZPos();
			
			double xScale = 1.0;
			double yScale = 1.0;
			double zScale = 1.0;

			// Make a 5 pointed ribose sugar molecule
			double circumference = 0.25;
			String riboseElements[] = {"Carbon", "Carbon", "Oygen", "Carbon", "Carbon"};
			double[][] ribosePoints = {
					 {x-circumference,             	y, 						 z},
	 				 {x+circumference,             	y, 						 z},
	 				 {x+(circumference * 1.5), 		y,  		z+circumference},
	 				 {x, 							y, 	z+(circumference * 1.5)},
	 				 {x-(circumference * 1.5), 		y, 			z+circumference}	
	  		};


			if (angle > 0.0)
			{
				System.out.println("Rotating Nucleobase: " + angle);			
				ribosePoints = BioGraphics.rotateY(ribosePoints, angle);
				System.out.println("Rotated Nucleobase: " + angle);			
			}
			
			// Create the Ribose X3D
			for (int i=0; i<riboseElements.length; i++)
			{
				//System.out.println("Creating X3D for : " + riboseElements[i]);				
				
				// Change the height and width based on the displacement.
				body += "\n<Transform DEF='" + riboseElements[i] + "'\n";
						
			 	body += "translation='" 
			 		 	+ ribosePoints[i][0] + " " 
			 		 	+ ribosePoints[i][1] + " "
						+ ribosePoints[i][2]+ "'\n";					
				
				body +=  "scale='" 	+ xScale + " "
				 					+ yScale + " "
				 					+ zScale + "'>\n" +

				 "\n<Shape DEF='" + riboseElements[i] + "Shape'\n" +
				    " containerField='children'>\n" +
				    " <Appearance\n" +
				    "  containerField='appearance'>\n";

			
				body+= " <ImageTexture containerField='texture' " +
				    " url='../images/" + riboseElements[i] + ".jpg'/>";
					
				    
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
				 	"<Sphere DEF='" + riboseElements[i] + "Sphere'\n" +
				 	"containerField='geometry'\n" +
				 	"radius='" + bioMightTransform.getRadius() +"'/>\n" +
				 	"</Shape>\n" +
				 	
					"\n<TouchSensor DEF='"+riboseElements[i]+"Touch' \n" +
	                   " description='"+riboseElements[i]+"'\n" +
		               " containerField='children'/> \n" +

				 "</Transform>\n";
						
				//System.out.println("Nuceotides - Set Transform: ");				
			}

			
			// Make a cross-shaped phosphate backbone
			// Align to the Sugar Stabilizer
			String phosphateElements[] = {"Phosphorous", "Oxygen", "Oygen", "Oxygen", "Oygen"};
			x = x - circumference * 3;
			z = z + circumference * 3; 
			double[][] phosphatePoints = {
					 {x,             				y, 							z},
	 				 {x-circumference,             	y, 							z},
	 				 {x,					 		y,  		  z+circumference},
	 				 {x+circumference, 				y, 							z},
	 				 {x, 							y, 			  z-circumference}	
	  		};

			if (angle > 0.0)
			{
				System.out.println("Rotating Nucleobase: " + angle);			
				phosphatePoints = BioGraphics.rotateY(phosphatePoints, angle);
				System.out.println("Rotated Nucleobase: " + angle);			
			}
			
			// Create the Phosphate X3D
			for (int i=0; i<phosphateElements.length; i++)
			{
				//System.out.println("Creating X3D for : " + phosphateElements[i]);				
				
				// Change the height and width based on the displacement.
				body += "\n<Transform DEF='" + phosphateElements[i] + "'\n";
						
			 	body += "translation='" 
			 		 	+ phosphatePoints[i][0] + " " 
			 		 	+ phosphatePoints[i][1] + " "
						+ phosphatePoints[i][2]+ "'\n";					
				
				body +=  "scale='" 	+ xScale + " "
				 					+ yScale + " "
				 					+ zScale + "'>\n" +

				 "\n<Shape DEF='" + phosphateElements[i] + "Shape'\n" +
				    " containerField='children'>\n" +
				    " <Appearance\n" +
				    "  containerField='appearance'>\n";

			
				body+= " <ImageTexture containerField='texture' " +
				    " url='../images/" + phosphateElements[i] + ".jpg'/>";
					
				    
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
				 	"<Sphere DEF='" + phosphateElements[i] + "Sphere'\n" +
				 	"containerField='geometry'\n" +
				 	"radius='" + bioMightTransform.getRadius() +"'/>\n" +
				 	"</Shape>\n" +
				 	
					"\n<TouchSensor DEF='"+phosphateElements[i]+"Touch' \n" +
	                   " description='"+phosphateElements[i]+"'\n" +
		               " containerField='children'/> \n" +

				 "</Transform>\n";
				
				//System.out.println("Nuceotides - Set Transform: ");				
			}
				

			// Make a Nitrogeneous Base	- Pentose
			// Align to the Sugar Stabilizer
			String nbElements[] = {"Nitrogen", "Nitrogen", "Nitrogen", "Nitrogen", "Hydrogen"};
			x = x + circumference * 3;
			z = z + circumference * 3; 
			double[][] nbPoints = {
					 {x,             			y, 							z},
	 				 {x+circumference,          y, 	  z+(circumference * 1.5)},
	 				 {x+circumference*2,	 	y,  		  z+circumference},
	 				 {x+circumference*2, 		y, 			  z-circumference},
	 				 {x+circumference, 			y, 	   z-(circumference * 1.5)}	
	  		};
			
			if (angle > 0.0)
			{
				System.out.println("Rotating Nucleobase: " + angle);			
				nbPoints = BioGraphics.rotateY(nbPoints, angle);
				System.out.println("Rotated Nucleobase: " + angle);			
			}		
			
			// Create the Nitrogeneous Base	 X3D
			for (int i=0; i<nbElements.length; i++)
			{
				//System.out.println("Creating X3D for : " + phosphateElements[i]);				
				
				// Change the height and width based on the displacement.
				body += "\n<Transform DEF='" + nbElements[i] + "'\n";
						
			 	body += "translation='" 
			 		 	+ nbPoints[i][0] + " " 
			 		 	+ nbPoints[i][1] + " "
						+ nbPoints[i][2]+ "'\n";					
				
				//System.out.println("Set Translation: ");				

				body +=  "scale='" 	+ xScale + " "
				 					+ yScale + " "
				 					+ zScale + "'>\n" +

				 "\n<Shape DEF='" + nbElements[i] + "Shape'\n" +
				    " containerField='children'>\n" +
				    " <Appearance\n" +
				    "  containerField='appearance'>\n";

			
				body+= " <ImageTexture containerField='texture' " +

				" url='../images/" + nbElements[i] + ".jpg'/>";
					
				    
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
				 	"<Sphere DEF='" + nbElements[i] + "Sphere'\n" +
				 	"containerField='geometry'\n" +
				 	"radius='" + bioMightTransform.getRadius() +"'/>\n" +
				 	"</Shape>\n" +
				 	
					"\n<TouchSensor DEF='"+nbElements[i]+"Touch' \n" +
	                   " description='"+nbElements[i]+"'\n" +
		               " containerField='children'/> \n" +

				 "</Transform>\n";
				
				//System.out.println("Nuceotides - Set Transform: ");				
			}
			

			// Make a Nitrogeneous Base	- Hexose
			// Align to the Pentanomer Nitrogen 
			String nbHElements[] = {"Nitrogen", "Nitrogen", "Nitrogen", "Nitrogen", "Hydrogen"};
			x = x + circumference * 2;
			z = z + circumference; 
			double[][] nbHPoints = {
					 {x,             			y, 							z},
	 				 {x+circumference,          y,		 	z+(circumference)},
	 				 {x+circumference*2,	 	y,				  			z},
	 				 {x+circumference*2, 		y, 			  z-circumference},
	 				 {x+circumference,	 		y, 			z-circumference*2},
	 				 {x,			 			y,		 	z-(circumference)}	
	  		};

			if (angle > 0.0)
			{
				System.out.println("Rotating Nucleobase: " + angle);			
				nbHPoints = BioGraphics.rotateY(nbHPoints, angle);
				System.out.println("Rotated Nucleobase: " + angle);			
			}
			
			// Create the Nitrogeneous Base	 X3D
			for (int i=0; i<nbElements.length; i++)
			{
				//System.out.println("Creating X3D for : " + phosphateElements[i]);				
				
				// Change the height and width based on the displacement.
				body += "\n<Transform DEF='" + nbHElements[i] + "'\n";
						
			 	body += "translation='" 
			 		 	+ nbHPoints[i][0] + " " 
			 		 	+ nbHPoints[i][1] + " "
						+ nbHPoints[i][2]+ "'\n";					
				
				System.out.println("Set Translation: ");				

				body +=  "scale='" 	+ xScale + " "
				 					+ yScale + " "
				 					+ zScale + "'>\n" +

				 "\n<Shape DEF='" + nbHElements[i] + "Shape'\n" +
				    " containerField='children'>\n" +
				    " <Appearance\n" +
				    "  containerField='appearance'>\n";

			
				body+= " <ImageTexture containerField='texture' " +

				" url='../images/" + nbHElements[i] + ".jpg'/>";
					
				    
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
				 	"<Sphere DEF='" + nbHElements[i] + "Sphere'\n" +
				 	"containerField='geometry'\n" +
				 	"radius='" + bioMightTransform.getRadius() +"'/>\n" +
				 	"</Shape>\n" +
				 	
					"\n<TouchSensor DEF='"+nbHElements[i]+"Touch' \n" +
	                   " description='"+nbHElements[i]+"'\n" +
		               " containerField='children'/> \n" +

				 "</Transform>\n";
				
				//System.out.println("Nuceotides - Set Transform: ");				
			}

		
			return (body);		
			}
		
}
