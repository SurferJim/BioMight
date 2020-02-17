/*
 * Created on May 5, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.chemistry.nucleicacid.nucleotide;

import java.util.ArrayList;

import javax.naming.InitialContext;



import biomight.Constants;
import biomight.chemistry.elements.Carbon;
import biomight.chemistry.elements.Hydrogen;
import biomight.chemistry.elements.Nitrogen;
import biomight.chemistry.elements.Oxygen;
import biomight.ejb.BioMightBeanLocal;
import biomight.exceptions.ServerException;
import biomight.util.BioGraphics;
import biomight.view.BioMightMethodView;
import biomight.view.BioMightPosition;
import biomight.view.BioMightPropertyView;
import biomight.view.BioMightTransform;

/***********************************************************************
 * @author SurferJim
 *
 * Representation of Guanine 
 * 
 **********************************************************************/

public class Guanine extends Nucleotide {
	private Guanine guanine;
	private BioMightPosition bioMightPosition;

	private Carbon carbon1;
	private Carbon carbon2;
	private Carbon carbon3;
	private Carbon carbon4;
	private Carbon carbon5;
	
	private Nitrogen nitrogen1;
	private Nitrogen nitrogen2;
	private Nitrogen nitrogen3;
	private Nitrogen nitrogen4;
	private Nitrogen nitrogen5;
	
	private Hydrogen hydrogen1;
	private Hydrogen hydrogen2;
	private Hydrogen hydrogen3;
	private Hydrogen hydrogen4;
	private Hydrogen hydrogen5;
	
	private Oxygen oxygen;
	

	
	public Guanine()
	{		
		// Create the Base Guanine
		int localVP =  Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG2X;
		create(localVP, localLOD, Constants.GuanineRef, null, null);
	}
	
	public Guanine(String parentID)
	{				
		int localVP =  Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG2X;
		create(localVP, localLOD, parentID, null, null);	
	}
		

	public Guanine(String parentID, BioMightPosition bioMightPosition)
	{
		int localVP =  Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG2X;
		create(localVP, localLOD, parentID, null, null);
		this.bioMightPosition = bioMightPosition;
	}
	
	
	// When we are drilling into the component from the View Page, we will set
	// the LOD to HAWK-EYE, which means fine detail.
	public Guanine(String parentID, ArrayList<BioMightMethodView> bioMightMethods)
	{		
		int localVP =  Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG2X;
		create(localVP, localLOD,  parentID, null, bioMightMethods);	
	}
		
	// We are looking at the object from a collection.  It was created via
	// the Guanines parent object and we do not have  to go to the database 
	// to get additional informaion
	public Guanine(int localVP, int localLOD, String parentID, ArrayList<BioMightMethodView> bioMightMethods)
	{				
		create(localVP, localLOD, parentID, null, bioMightMethods);	
	}
	
	public Guanine(int localVP, int localLOD, String parentID,  ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
	{		
		create(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);
	}
	
	public void create(int localVP, int localLOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
	{
			this.setImage("images/Guanine.jpg");
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
				System.out.println("In Guanine Create() - Already Set: " + parentID);				

				// We already have the data for the current instance of Guanine,
				// Go get the details for the current Guanine is LOD is set
				if (localLOD == Constants.MAG2X)
				{
					// Go get the finer details of the Guanine				
					System.out.println("Getting the Guanine Details: " + parentID);
					localVP = Constants.VIEW_INTERNAL; 
					localLOD = Constants.MAG1X;
					
					//nucleoside
					//cellMembrane = new CellMembrane(localVP, localLOD, componentID, bioMightMethods);									
					//System.out.println("Guanine Instance created from SubComponents : " + parentID);
				
					//System.out.println("In Cell - Creating Endosomes");
					//endosomes = new Endosomes(bioMightTransform.getId(), bioMightMethods);
					//System.out.println("In Cell - Cell Membrane is complete");
			
					// initialize the Properties
					//initProperty(bioMightTransform.getName(), Constants.Guanine, Constants.GuanineRef, bioMightTransform.getId());
				}
			
			}	
			else if (localVP == Constants.VIEW_HAWKEYE)
			{
				// This is when one is accessing a Guanine directly
				// Get the information from the database via the Enterprise Bean		
				try {
					// Get the information from the database via the Enterprise Bean		
					System.out.println("Getting HawkEye GuanineInfo for ParentID: " + parentID);
					InitialContext ctx = new InitialContext();
					BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
					bioMightTransforms = bioMightBean.getComponent(parentID);
					System.out.println("Have Guanine Info from EJB");   	
				}catch (Exception e) { 
					System.out.println("Exception Getting Components - Guanine");
					throw new ServerException("Remote Exception getComponents():", e); 	
				}
					
				// Run through the collection of Guanines and build them into the model
				// In the default case, we get one instance of the Guanine for each eye
				ArrayList transforms = bioMightTransforms.getTransforms();
				System.out.println("Guanine NumTransforms: " + transforms.size());
				for (int i=0; i<transforms.size(); i++)
				{
					// Get the information for the Guanine
					BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
					System.out.println("Creating Guanine: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
					this.componentID = bioMightTransform.getId();


					if (localLOD == Constants.MAG1X)
					{
						// initialize the Properties
						initProperties();
					}
					if (localLOD == Constants.MAG2X)
					{
						// Go get the finer details of the Guanine				
						System.out.println("Creating Guanine : " + parentID + " lod: " + localLOD);
						localVP = Constants.VIEW_HAWKEYE; 
						localLOD = Constants.MAG1X;

						System.out.println("Creating Guanine : " + parentID + " lod: " + localLOD);
						guanine = new Guanine(localVP, localLOD, bioMightTransform.getId(), bioMightMethods);
						initProperty(Constants.GuanineRef, Constants.Guanine, Constants.GuanineRef, guanine.getComponentID());
						System.out.println("Guanine is complete");
						
					}
					
				}
			}		
			else
			{
				
			}
				
			initMethods();
			
			System.out.println("CreateGuanine Completed");
			
			// First, get all the data from the database
			// Apply the methods to it
			// Save its state
			this.parentID = parentID;
			if (bioMightMethods != null){
				System.out.println("EXECUTING Guanine Methods: " + bioMightMethods.size());
				//executeMethods(bioMightMethods);
			}
		}
		

	
		private void initProperties() {
						
		}
		
		
		/******************************************************************************************
		 * GENERATE GUANINE
		 * 
		 * 
		 * @param parentID
		 * @param componentID
		 ******************************************************************************************/
		public void generate(String parentID, String componentID)
		{
			// Generate the Guanine		
			BioMightBeanLocal bioMightBean;
			try {
				// Get the information from the database via the Enterprise Bean		
				System.out.println("Generating the Guanine : " + componentID + "    " + parentID);
				InitialContext ctx = new InitialContext();
				bioMightBean = (BioMightBeanLocal) ctx.lookup("java:global/BioMightWeb/BioMightBean!biomight.ejb.BioMightBeanLocal");
		
				double circumference = 0.125;
				
				if (componentID.equals("Guanine:01")) {
					
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

						
					//int success = bioMightBean.generateGuanine("Guanine:00001", "Guanine", 
					//		"Guanine", componentID, parentID, currentPoints);			
					
				}
				else if (componentID.equals("Guanine:02"))
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

					
					
					//int success = bioMightBean.generateGuanine("Guanine:00160", "Guanine", 
					//	"Guanine", componentID, parentID, currentPoints);
			
					
				}
				else if (parentID.equals("")) 
				{	
					System.out.println("Calling Generate Guanine NoParent");		
				}

				
				System.out.println("Created Guanine Info using EJB");   	
			}catch (Exception e) { 
				System.out.println("Exception Getting Components - Guanine");
				throw new ServerException("Remote Exception Guanine():", e); 	
			}
		}
		
		
		// This method will store the method list into the 
		// BioMightBase object. 
		private void initMethods() {
	
			BioMightMethodView method = new BioMightMethodView();
	
			method = new BioMightMethodView();
			method.setMethodName("flux");
			method.setDisplayName("ionize");
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
			System.out.println("Guanine Executing Methods");
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
		 * This method will return the X3D for the Guanine.  It runs through each of its components and collects up their
		 * representations and then assembles them into one unified X3D model.
		 * 
		 ********************************************************************************************************************/
		public String getX3D(boolean snipet) {
			
			// Assembe the Guanine
			String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
			"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n " +
			"<X3D profile='Immersive' >\n" +
			"<head>\n" +
			 "<meta name='BioMightImage' content='Guanine.jpg'/>\n" +
			 "<meta name='ExportTime' content='7:45:30'/>\n" +
			 "<meta name='ExportDate' content='08/15/2008'/>\n" +
			 "<meta name='BioMight Version' content='1.0'/>\n" + 
			"</head>\n" +
			"<Scene>\n" +
			"<WorldInfo\n" +
			"title='Guanine'\n" +
			"info='\"BioMight Generated X3D\"'/>\n";		

			String body = "";
			String annotate = "";
			
			
			// Only when the database retrieval has been locally, do we do this??
			if (viewPerspective == Constants.VIEW_INTERNAL) 
			{			
				
				if (lod == Constants.MAG1X)		
				{
		
				}
				
				// We do nada as the Guanine Data is retrieved in the collection object
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
					System.out.println("Creating Guanine: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
					System.out.println("Creating Guanine at Position: " + 
							bioMightTransform.getTranslation().getXPos() + "  " +
							bioMightTransform.getTranslation().getYPos() + "  " +
							bioMightTransform.getTranslation().getZPos());
					
					// Grab the data
					if (lod == Constants.MAG1X)		
					{
						//System.out.println("Getting X3D for GuanineX: " + bioMightTransform.getTranslation().getXPos());
						//System.out.println("Getting X3D for GuanineY: " + bioMightTransform.getTranslation().getYPos());
						//System.out.println("Getting X3D for GuanineZ: " + bioMightTransform.getTranslation().getZPos());
						// Change the height and width based on the displacement.
									
						// Create the Nuceotide representation
						body += getX3D(bioMightTransform);
						
					}
					else if (lod == Constants.MAG2X)		
					{
						body += "";// nucleosides(true) ;
					}
				}
			}
			else 
			{			
				// Issue
			}	
				
			body+= "<Viewpoint DEF='Viewpoint_Nucleotide'\n" +
					 "description='Viewpoint1_Bucloetide'\n" +
					 "jump='true'\n" +
					 "fieldOfView='0.785'\n" +
					 "position='0.0 0.0 4.0'\n" +
					 "orientation='0 0 1 0'/>\n";
			
			//System.out.println("Guanine X3D: " + body);		
			String footer = "</Scene>" + "</X3D>\n";
			
			if (snipet)
				return body;			
			else	
				return header + body + annotate + footer;				
		}


		
		/********************************************************************************************************************
		 * GET X3D 
		 * 
		 * This method will return the X3D for the Guanine.  It runs through each of its components and collects up their
		 * representations and then assembles them into one unified X3D model.
		 * 
		 ********************************************************************************************************************/
		public String getX3D(BioMightTransform bioMightTransform) 
		{

			String body = "";
			
			double x = 0.0;
			double y = 0.0;
			double z = 0.0;
			
			double xScale = 1.0;
			double yScale = 1.0;
			double zScale = 1.0;
			
			// Make a 5 pointed guanine sugar molecule
			double circumference = 0.25;
			double angle = 0.0;


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
				System.out.println("Rotating Nucleotide: " + angle);			
				nbPoints = BioGraphics.rotateY(nbPoints, angle);
				System.out.println("Rotated Nucleotide: " + angle);			
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
				System.out.println("Rotating Nucleotide: " + angle);			
				nbHPoints = BioGraphics.rotateY(nbHPoints, angle);
				System.out.println("Rotated Nucleotide: " + angle);			
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
	

	
	public void setGuanine()
	{
	}
	
	
}


