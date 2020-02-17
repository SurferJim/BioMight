/*
 * Created on May 5, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.chemistry.elements;

import java.util.ArrayList;

import javax.naming.InitialContext;







import biomight.Constants;
import biomight.ejb.BioMightBeanLocal;
import biomight.exceptions.ServerException;
import biomight.view.BioMightMethodView;
import biomight.view.BioMightPosition;
import biomight.view.BioMightPropertyView;
import biomight.view.BioMightTransform;
import biomightweb.util.BioWebDNA;
import biomightweb.util.BioWebX3DUtils;

/********************************************************************************
 * @author SurferJim
 *
 * Representation of a Phosphorus molecule
 * 
 ********************************************************************************/

public class Phosphorus extends Element{
	private BioMightPosition bioMightPosition;
	
	

	public Phosphorus()
	{		
		// Create the Base Phosphorus
		int localVP =  Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG2X;
		create(localVP, localLOD, Constants.PhosphorusRef, null, null);
	}
	
	public Phosphorus(String parentID)
	{				
		int localVP =  Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG2X;
		create(localVP, localLOD, parentID, null, null);	
	}
		

	public Phosphorus(String parentID, BioMightPosition bioMightPosition)
	{
		int localVP =  Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG2X;
		create(localVP, localLOD, parentID, null, null);
		this.bioMightPosition = bioMightPosition;
	}
	
	
	// When we are drilling into the component from the View Page, we will set
	// the LOD to HAWK-EYE, which means fine detail.
	public Phosphorus(String parentID, ArrayList<BioMightMethodView> bioMightMethods)
	{		
		int localVP =  Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG2X;
		create(localVP, localLOD,  parentID, null, bioMightMethods);	
	}
		
	// We are looking at the object from a collection.  It was created via
	// the Phosphoruss parent object and we do not have  to go to the database 
	// to get additional informaion
	public Phosphorus(int localVP, int localLOD, String parentID, ArrayList<BioMightMethodView> bioMightMethods)
	{				
		create(localVP, localLOD, parentID, null, bioMightMethods);	
	}
	
	public Phosphorus(int localVP, int localLOD, String parentID,  ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
	{		
		create(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);
	}
	
	public void create(int localVP, int localLOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
	{
			this.setImage("images/Phosphorus.jpg");
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
				System.out.println("In Phosphorus Create() - Already Set: " + parentID);				

				// We already have the data for the current instance of Phosphorus,
				// Go get the details for the current Phosphorus is LOD is set
				if (localLOD == Constants.MAG2X)
				{
					// Go get the finer details of the Phosphorus				
					System.out.println("Getting the Phosphorus Details: " + parentID);
					localVP = Constants.VIEW_INTERNAL; 
					localLOD = Constants.MAG1X;
					
					//nucleoside
					//cellMembrane = new CellMembrane(localVP, localLOD, componentID, bioMightMethods);									
					//System.out.println("Phosphorus Instance created from SubComponents : " + parentID);
				
					//System.out.println("In Cell - Creating Endosomes");
					//endosomes = new Endosomes(bioMightTransform.getId(), bioMightMethods);
					//System.out.println("In Cell - Cell Membrane is complete");
			
					// initialize the Properties
					//initProperty(bioMightTransform.getName(), Constants.Phosphorus, Constants.PhosphorusRef, bioMightTransform.getId());
				}
			
			}	
			else if (localVP == Constants.VIEW_HAWKEYE)
			{
				// This is when one is accessing a Phosphorus directly
				// Get the information from the database via the Enterprise Bean		
				try {
					// Get the information from the database via the Enterprise Bean		
					System.out.println("Getting HawkEye PhosphorusInfo for ParentID: " + parentID);
					InitialContext ctx = new InitialContext();
					BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
					bioMightTransforms = bioMightBean.getComponent(parentID);
					System.out.println("Have Phosphorus Info from EJB");   	
				}catch (Exception e) { 
					System.out.println("Exception Getting Components - Phosphorus");
					throw new ServerException("Remote Exception getComponents():", e); 	
				}
					
				// Run through the collection of Phosphoruss and build them into the model
				// In the default case, we get one instance of the Phosphorus for each eye
				ArrayList transforms = bioMightTransforms.getTransforms();
				System.out.println("Phosphorus NumTransforms: " + transforms.size());
				for (int i=0; i<transforms.size(); i++)
				{
					// Get the information for the Phosphorus
					BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
					System.out.println("Creating Phosphorus: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
					this.componentID = bioMightTransform.getId();


					if (localLOD == Constants.MAG1X)
					{
						// initialize the Properties
						initProperties();
					}
					if (localLOD == Constants.MAG2X)
					{
						// Go get the finer details of the Phosphorus				
						System.out.println("Creating Phosphorus : " + parentID + " lod: " + localLOD);
						localVP = Constants.VIEW_HAWKEYE; 
						localLOD = Constants.MAG1X;

						//System.out.println("Creating Phosphorus : " + parentID + " lod: " + localLOD);
						//phosphorus = new Phosphorus(localVP, localLOD, bioMightTransform.getId(), bioMightMethods);
						//initProperty(Constants.PhosphorusRef, Constants.Phosphorus, Constants.PhosphorusRef, phosphorus.getComponentID());
						//System.out.println("Phosphorus is complete");
						
					}
					
				}
			}		
			else
			{
				
			}
				
			initMethods();
			
			System.out.println("CreatePhosphorus Completed");
			
			// First, get all the data from the database
			// Apply the methods to it
			// Save its state
			this.parentID = parentID;
			if (bioMightMethods != null){
				System.out.println("EXECUTING Phosphorus Methods: " + bioMightMethods.size());
				//executeMethods(bioMightMethods);
			}
		}
		

	
		private void initProperties() {
			
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
		
		
		/****************************************************
		 * GENERATE BASOPHIL
		 * 
		 * 
		 * @param parentID
		 * @param componentID
		 ***************************************************/
		public void generate(String parentID, String componentID)
		{
			// Generate the Phosphorus		
			BioMightBeanLocal bioMightBean;
			try {
				// Get the information from the database via the Enterprise Bean		
				System.out.println("Generating the Phosphorus : " + componentID + "    " + parentID);
				InitialContext ctx = new InitialContext();
				bioMightBean = (BioMightBeanLocal) ctx.lookup("java:global/BioMightWeb/BioMightBean!biomight.ejb.BioMightBeanLocal");
		
				double circumference = 0.125;
				
				if (componentID.equals("Phosphorus:01")) {
					
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

						
					//int success = bioMightBean.generatePhosphorus("Phosphorus:00001", "Phosphorus", 
					//		"Phosphorus", componentID, parentID, currentPoints);			
					
				}
				else if (componentID.equals("Phosphorus:02"))
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

					
					
					//int success = bioMightBean.generatePhosphorus("Phosphorus:00160", "Phosphorus", 
					//	"Phosphorus", componentID, parentID, currentPoints);
			
					
				}
				else if (parentID.equals("")) 
				{	
					System.out.println("Calling Generate Phosphorus NoParent");		
				}

				
				System.out.println("Created Phosphorus Info using EJB");   	
			}catch (Exception e) { 
				System.out.println("Exception Getting Components - Phosphorus");
				throw new ServerException("Remote Exception Phosphorus():", e); 	
			}
		}
		
		
		// This method will store the method list into the 
		// BioMightBase object. 
		private void initMethods() {
			BioMightMethodView method = new BioMightMethodView();
			
			method = new BioMightMethodView();
			method.setMethodName("setTexture");
			method.setDisplayName("Texture:");
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
			System.out.println("Phosphorus Executing Methods");
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
		 * This method will return the X3D for the Phosphorus.  It runs through each of its components and collects up their
		 * representations and then assembles them into one unified X3D model.
		 * 
		 ********************************************************************************************************************/
		public String getX3D(boolean snipet) {
			
			// Assembe the Phosphorus
			String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
			"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n " +
			"<X3D profile='Immersive' >\n" +
			"<head>\n" +
			 "<meta name='BioMightImage' content='Phosphorus.jpg'/>\n" +
			 "<meta name='ExportTime' content='7:45:30'/>\n" +
			 "<meta name='ExportDate' content='08/15/2008'/>\n" +
			 "<meta name='BioMight Version' content='1.0'/>\n" + 
			"</head>\n" +
			"<Scene>\n" +
			"<WorldInfo\n" +
			"title='Phosphorus'\n" +
			"info='\"BioMight Generated X3D\"'/>\n";		

			String body = "";
			String annotate = "";
			

			System.out.println("Getting X3D for Phosphorus!!!!!!!!");

			
			// Only when the database retrieval has been locally, do we do this??
			if (viewPerspective == Constants.VIEW_INTERNAL) 
			{	
				
				//************************************************************888
				//**************************************************************8
				// HACK
				lod = Constants.MAG2X;
				//************************************************************
				//************************************************************

				
				System.out.println("Get X3D Phosphorus - View Internal");
				// We do nada as the Phosphorus Data is retrieved in the collection object
				// and the X3D is generated there
				if (lod == Constants.MAG2X)		
				{
					System.out.println("Get X3D Phosphorus - View Internal - 2X");
					//We are going to get the X3D from the aggregation objects
					body += ""; //electrons.getX3D(true);	
				}
				else if (lod == Constants.MAG1X)
				{			
					// We went to the database to get data.  There will be 1 Transform record
				
					/*
					System.out.println("Creating Phosphorus: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
					System.out.println("Creating Phosphorus at Position: " + 
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
					    " url='../images/Phosphorus.jpg'/>";
					
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
					 	"<Sphere DEF='PhosphorusGeoSphere'\n" +
					 	"containerField='geometry'\n" +
					 	"radius='" + bioMightTransform.getRadius() +"'/>\n" +
					 	"</Shape>\n" +
					 	
						"\n<TouchSensor DEF='TSENSOR_"+ bioMightTransform.getId()+ "' \n" +
		                   " description='Phosphorus'\n" +
			               " containerField='children'/> \n" +
		
					 "</Transform>\n";
					*/
				}
			
			}
			else if (viewPerspective == Constants.VIEW_HAWKEYE) 
			{
				System.out.println("Get X3D Phosphorus - View Hawkeye");
				
				//************************************************************888
				//**************************************************************8
				// HACK
				lod = Constants.MAG1X;
				//************************************************************
				//************************************************************

				if (lod == Constants.MAG2X)		
				{
					System.out.println("Get X3D Phosphorus - View Hawkeye -- 2X");
					//We are going to get the X3D from the aggregation objects
					body += ""; //electrons.getX3D(true);	
				}
				else
				{			
					// We went to the database to get data.  There will be 1 Transform record
					System.out.println("Get X3D Phosphorus - View Hawkeye  1X");
				
					ArrayList transforms = bioMightTransforms.getTransforms();
					for (int i=0; i<transforms.size(); i++)
					{
						// Get the information for the capsomer we are creating
						BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
						System.out.println("Creating Phosphorus: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
						System.out.println("Creating Phosphorus at Position: " + 
								bioMightTransform.getTranslation().getXPos() + "  " +
								bioMightTransform.getTranslation().getYPos() + "  " +
								bioMightTransform.getTranslation().getZPos());

						String elementDesc = Constants.PhosphorusRef + "-AtomicWeight: 15, %Body: 1.1";	
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
						    " url='../images/Phosphorus.png'/>";
						
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
						 	"<Sphere DEF='PhosphorusGeoSphere'\n" +
						 	"containerField='geometry'\n" +
						 	"radius='" + bioMightTransform.getRadius() +"'/>\n" +
						 	"</Shape>\n" +
						 	
							"\n<TouchSensor DEF='TSENSOR_"+ bioMightTransform.getId()+ "' \n" +
			                   " description='Phosphorus'\n" +
				               " containerField='children'/> \n" +
			
						 "</Transform>\n";
						
						// Phosphorous has 15 electrons
						double electronSize = BioWebDNA.getAtomicRadius("Electron");
						int eRing = 0;
						double 	ringSize =  bioMightTransform.getRadius() +  ((electronSize) * (eRing+1));
						ArrayList ringData = new ArrayList();	
				
						
						eRing = 0;
						ringSize =  bioMightTransform.getRadius() +  ((electronSize) * (eRing+1));
						
						double[][] offSets0 = new double[2][3];	
						offSets0[0][0] = ringSize;
						offSets0[0][1] = ringSize;
						offSets0[0][2] = 0;
								
						offSets0[1][0] = -ringSize;
						offSets0[1][1] = ringSize;
						offSets0[1][2] = 0;

						ringData.add(0, offSets0);
								
						
						eRing = 1;
						ringSize = bioMightTransform.getRadius() +  ((electronSize) * (eRing+1));
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
						ringSize = bioMightTransform.getRadius() +  ((electronSize) * (eRing+1));
						double[][] offSets2 = new double[5][3];
						
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
						
						// y flat
						offSets2[4][0] = ringSize;
						offSets2[4][1] = 0;
						offSets2[4][2] = -ringSize;
						
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
				
			
			body+= "<Viewpoint DEF='Viewpoint_Phosphorous'\n" +
				 "description='Viewpoint_Phosphorous'\n" +
				 "jump='true'\n" +
				 "fieldOfView='0.785'\n" +
				 "position='0.0 0.0 80.0'\n" +
				 "orientation='0 0 1 0'/>\n";
		
			String footer = "</Scene>" + "</X3D>\n";		
			if (snipet)
				return body;			
			else	
				return header + body + annotate + footer;				
		}

		
		/********************************************************************************************************************
		 * GET X3D 
		 * 
		 * This method will return the X3D for the Phosphorus.  It runs through each of its components and collects up their
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
			
			// Make a 5 pointed phosphorus sugar molecule
			double circumference = 0.25;
			String phosphorusElements[] = {"Carbon", "Carbon", "Oygen", "Carbon", "Carbon"};
			double[][] phosphorusPoints = {
					 {x-circumference,             	y, 						 z},
	 				 {x+circumference,             	y, 						 z},
	 				 {x+(circumference * 1.5), 		y,  		z+circumference},
	 				 {x, 							y, 	z+(circumference * 1.5)},
	 				 {x-(circumference * 1.5), 		y, 			z+circumference}	
	  		};


			/*if (angle > 0.0)
			{
				System.out.println("Rotating Nucleotide: " + angle);			
				phosphorusPoints = BioGraphics.rotateY(phosphorusPoints, angle);
				System.out.println("Rotated Nucleotide: " + angle);			
			}*/
			
			// Create the Phosphorus X3D
			for (int i=0; i<phosphorusElements.length; i++)
			{
				//System.out.println("Creating X3D for : " + phosphorusElements[i]);				
				
				// Change the height and width based on the displacement.
				body += "\n<Transform DEF='" + phosphorusElements[i] + "'\n";
						
			 	body += "translation='" 
			 		 	+ phosphorusPoints[i][0] + " " 
			 		 	+ phosphorusPoints[i][1] + " "
						+ phosphorusPoints[i][2]+ "'\n";					
				
				body +=  "scale='" 	+ xScale + " "
				 					+ yScale + " "
				 					+ zScale + "'>\n" +

				 "\n<Shape DEF='" + phosphorusElements[i] + "Shape'\n" +
				    " containerField='children'>\n" +
				    " <Appearance\n" +
				    "  containerField='appearance'>\n";

			
				body+= " <ImageTexture containerField='texture' " +
				    " url='../images/" + phosphorusElements[i] + ".jpg'/>";
					
				    
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
				 	"<Sphere DEF='" + phosphorusElements[i] + "Sphere'\n" +
				 	"containerField='geometry'\n" +
				 	"radius='" + bioMightTransform.getRadius() +"'/>\n" +
				 	"</Shape>\n" +
				 	
					"\n<TouchSensor DEF='"+phosphorusElements[i]+"Touch' \n" +
	                   " description='"+phosphorusElements[i]+"'\n" +
		               " containerField='children'/> \n" +

				 "</Transform>\n";
				
				// Phosphorous has 15 electrons
				int eRing = 0;
				double ringSize = bioMightTransform.getRadius() +  ((bioMightTransform.getRadius() * 0.25) * eRing);
				ArrayList ringData = new ArrayList();	
		
				
				eRing = 0;
				ringSize = bioMightTransform.getRadius() +  ((bioMightTransform.getRadius() * 0.25) * eRing);
				
				double[][] offSets0 = new double[2][3];	
				offSets0[0][0] = ringSize;
				offSets0[0][1] = ringSize;
				offSets0[0][2] = 0;
						
				offSets0[1][0] = -ringSize;
				offSets0[1][1] = ringSize;
				offSets0[1][2] = 0;

				ringData.add(0, offSets0);
						
				
				eRing = 1;
				ringSize = bioMightTransform.getRadius() +  ((bioMightTransform.getRadius() * 0.25) * eRing);
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
				ringSize = bioMightTransform.getRadius() +  ((bioMightTransform.getRadius() * 0.25) * eRing);
				double[][] offSets2 = new double[5][3];
				
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
				
				// y flat
				offSets2[4][0] = ringSize;
				offSets2[4][1] = 0;
				offSets2[4][2] = -ringSize;
				
				ringData.add(2, offSets2);


				body += BioWebX3DUtils.addElectrons(bioMightTransform, ringData);

						
				//System.out.println("Nuceotides - Set Transform: ");				
			}

		
			return (body);
		}
	
}
