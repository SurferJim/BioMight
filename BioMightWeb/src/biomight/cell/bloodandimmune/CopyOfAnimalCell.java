/*
 * Created on Oct 25, 2006
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
import biomight.cell.Centrioles;
import biomight.cell.Cytoskeleton;
import biomight.cell.Cytosol;
import biomight.cell.EndoPlasmicReticulum;
import biomight.cell.Endosomes;
import biomight.cell.GolgiApparatus;
import biomight.cell.IonChannel;
import biomight.cell.IonChannels;
import biomight.cell.IonPumps;
import biomight.cell.Lysosomes;
import biomight.cell.Melanosome;
import biomight.cell.Mitochondria;
import biomight.cell.Peroxisomes;
import biomight.cell.Ribosomes;
import biomight.cell.SecretoryVesicle;
import biomight.cell.nucleus.Chromatin;
import biomight.cell.nucleus.Nuclei;
import biomight.ejb.BioMightBeanLocal;
import biomight.exceptions.ServerException;
import biomight.view.BioMightMethodView;
import biomight.view.BioMightOrientation;
import biomight.view.BioMightPosition;
import biomight.view.BioMightPropertyView;
import biomight.view.BioMightScale;
import biomight.view.BioMightTransform;
import biomightweb.util.BioWebX3DUtils;


/************************************************************************************
 * @author SurferJim
 *
 * Representation of a AnimalCell.  It is composed of proteins.
 * 
 ************************************************************************************/

public class CopyOfAnimalCell extends BioMightBase {	
	private BioMightPosition bioMightPosition;
	
	// We should add this into the base Cell,but for now
	// will do seperately to get it working
	private CellMembrane cellMembrane;
	private Nuclei nuclei;
	private Endosomes endosomes;
	private Centrioles centrioles;
	private Chromatin chromatin;
	private Cytoskeleton cytoskeleton;
	private Cytosol cytosol;
	private EndoPlasmicReticulum  endoPlasmicReticulum;
	private GolgiApparatus golgiApparatus;
	private Lysosomes lysosomes;
	private Mitochondria mitochondria; 
	private Peroxisomes peroxisomes; 
	private SecretoryVesicle secretoryVesicle;
	private IonPumps ionPumps;
	private Melanosome melanosome;
	private IonChannel ionChannel;
	private IonChannels ionChannels;
	private Ribosomes ribosomes;
	
	

	public CopyOfAnimalCell()
	{		
		// Create the Base AnimalCell
		int localVP =  Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG2X;
		create(localVP, localLOD, Constants.AnimalCellRef, null, null);
	}
	
	public CopyOfAnimalCell(String parentID)
	{				
		int localVP =  Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG2X;
		create(localVP, localLOD, parentID, null, null);	
	}
		

	public CopyOfAnimalCell(String parentID, BioMightPosition bioMightPosition)
	{
		int localVP =  Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG2X;
		create(localVP, localLOD, parentID, null, null);
		this.bioMightPosition = bioMightPosition;
	}

		
	public CopyOfAnimalCell(int localVP, int localLOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
	{		
		create(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);
	}
	
	public void create(int localVP, int localLOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
	{
			this.setImage("images/AnimalCell.jpg");
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
				System.out.println("In AnimalCell Create() - Already Set: " + parentID);				

				// We already have the data for the current instance of AnimalCell,
				// Go get the details for the current AnimalCell is LOD is set
				if (localLOD == Constants.MAG2X)
				{
					// Go get the finer details of the AnimalCell				
					System.out.println("Getting the AnimalCell Details: " + parentID);
					localVP = Constants.VIEW_INTERNAL; 
					localLOD = Constants.MAG1X;
					cellMembrane = new CellMembrane(localVP, localLOD, componentID, bioMightMethods);									
					System.out.println("AnimalCell Instance created from SubComponents : " + parentID);
				
					//System.out.println("In Cell - Creating Endosomes");
					//endosomes = new Endosomes(bioMightTransform.getId(), bioMightMethods);
					//System.out.println("In Cell - Cell Membrane is complete");
			
					// initialize the Properties
					//initProperty(bioMightTransform.getName(), Constants.AnimalCell, Constants.AnimalCellRef, bioMightTransform.getId());
				}
			
			}	
			else if (localVP == Constants.VIEW_HAWKEYE)
			{
				// This is when one is accessing a AnimalCell directly
				// Get the information from the database via the Enterprise Bean		
				try {
					// Get the information from the database via the Enterprise Bean		
					System.out.println("Getting HawkEye AnimalCellInfo for ParentID: " + parentID);
					InitialContext ctx = new InitialContext();
					BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
					bioMightTransforms = bioMightBean.getComponent(parentID);
					System.out.println("Have AnimalCell Info from EJB");   	
				}catch (Exception e) { 
					System.out.println("Exception Getting Components - AnimalCell");
					throw new ServerException("Remote Exception getComponents():", e); 	
				}
					
				// Run through the collection of AnimalCells and build them into the model
				// In the default case, we get one instance of the AnimalCell for each eye
				ArrayList transforms = bioMightTransforms.getTransforms();
				System.out.println("AnimalCell NumTransforms: " + transforms.size());
				for (int i=0; i<transforms.size(); i++)
				{
					// Get the information for the AnimalCell
					BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
					System.out.println("Creating AnimalCell: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
					this.componentID = bioMightTransform.getId();

					BioMightScale bioScale = new BioMightScale("0.00, 0.00, 0.00");
					BioMightPosition bioPos = new BioMightPosition("0.00, 0.00, 0.00");	
					String bioTemplate =""; 

					
					//************************************************************888
					//**************************************************************8
					// HACK
					localLOD = Constants.MAG2X;
					//************************************************************888
					//**************************************************************8
					
					if (localLOD == Constants.MAG1X)
					{
						// initialize the Properties
						initProperties();
					}
					if (localLOD == Constants.MAG2X)
					{
						// Go get the finer details of the AnimalCell				
						System.out.println("Creating AnimalCell at MAG2X : " + parentID);
						localVP = Constants.VIEW_INTERNAL; 
						localLOD = Constants.MAG1X;

						
						System.out.println("Creating CellMembrane : " + parentID + " lod: " + localLOD);
						cellMembrane = new CellMembrane(localVP, localLOD, bioMightTransform.getId(), bioMightMethods);
						initProperty(Constants.CellMembraneRef, Constants.CellMembrane, Constants.CellMembraneRef, cellMembrane.getComponentID());
						System.out.println("In AnimalCell - CellMembrane is complete");
						
						localVP = Constants.VIEW_HAWKEYE; 
						localLOD = Constants.MAG1X;
							
						System.out.println("In AnimalCell - Creating Endosomes");
						endosomes = new Endosomes(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
						initProperty(Constants.EndosomesRef, Constants.Endosomes, Constants.EndosomesRef, endosomes.getComponentID());
						System.out.println("In AnimalCell - Endosomes is complete");

						System.out.println("In Cell - Creating Nuclei");
						nuclei = new Nuclei(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
						initProperty(Constants.NucleiRef, Constants.Nuclei, Constants.NucleiRef, nuclei.getComponentID());
						System.out.println("In AnimalCell - Nuclei are complete");
										
						System.out.println("In AnimalCell - Creating Lysosome");
						lysosomes = new Lysosomes(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
						initProperty(Constants.LysosomesRef, Constants.Lysosomes, Constants.LysosomesRef, lysosomes.getComponentID());
						System.out.println("In AnimalCell - Lysosomes are complete");
					
						System.out.println("In AnimalCell - Creating Mitochondria");
						mitochondria = new Mitochondria(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
						initProperty(Constants.MitochondriaRef, Constants.Mitochondria, Constants.MitochondriaRef, mitochondria.getComponentID());
						System.out.println("In AnimalCell - Nucleus is complete");
		
						System.out.println("In AnimalCell - Creating IonPumps");
						ionPumps = new IonPumps(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
						initProperty(Constants.IonPumpsRef, Constants.IonPumps, Constants.IonPumpsRef, ionPumps.getComponentID());
						System.out.println("In AnimalCell - IonPumps are complete");

						System.out.println("In AnimalCell - Creating Peroxisomes");
						peroxisomes = new Peroxisomes(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
						initProperty(Constants.PeroxisomesRef, Constants.Peroxisomes, Constants.PeroxisomesRef, peroxisomes.getComponentID());
						System.out.println("In AnimalCell - Peroxisomes are complete");

						System.out.println("In AnimalCell - Creating Ribosomes");
						ribosomes = new Ribosomes(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
						initProperty(Constants.RibosomesRef, Constants.Ribosomes, Constants.RibosomesRef, ribosomes.getComponentID());
						System.out.println("In AnimalCell - Ribosomes are complete");

						
						initProperty(Constants.NOT_ACTIVATED, Constants.Title, Constants.Title, "AnimalCells:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);

						localVP = Constants.VIEW_DETACHED; 
						localLOD = Constants.MAG1X;
					
						//System.out.println("In AnimalCell - Creating GolgiApparatus");
						//golgiApparatus = new GolgiApparatus(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
						//initProperty(Constants.GolgiApparatusRef, Constants.GolgiApparatus, Constants.GolgiApparatusRef, golgiApparatus.getComponentID());
						//System.out.println("In AnimalCell - GolgiApparatus are complete");

						//System.out.println("In AnimalCell - Creating EndoPlasmicReticulum");
						//endoPlasmicReticulum = new EndoPlasmicReticulum(localVP, localLOD, bioMightTransform.getId(), bioMightMethods);
						//initProperty(Constants.EndoPlasmicReticulumRef, Constants.EndoPlasmicReticulum, Constants.EndoPlasmicReticulumRef, endoPlasmicReticulum.getComponentID());
						//System.out.println("In AnimalCell - EndoPlasmicReticulum are complete");
	
					}
					
				}
			}		
			else
			{
				
			}
				
			initMethods();
			
			System.out.println("CreateAnimalCell Completed");
			
			// First, get all the data from the database
			// Apply the methods to it
			// Save its state
			this.parentID = parentID;
			if (bioMightMethods != null){
				System.out.println("EXECUTING AnimalCell Methods: " + bioMightMethods.size());
				//executeMethods(bioMightMethods);
			}
		}
		

	
		private void initProperties() {
			
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
		
		
		/***************************************************************************************
		 * GENERATE BASOPHIL
		 * 
		 * 
		 * @param parentID
		 * @param componentID
		 **************************************************************************************/
		public void generate(String parentID, String componentID)
		{
			// Generate the AnimalCell		
			BioMightBeanLocal bioMightBean;
			try {
				// Get the information from the database via the Enterprise Bean		
				System.out.println("Generating the AnimalCell : " + componentID + "    " + parentID);
				InitialContext ctx = new InitialContext();
				bioMightBean = (BioMightBeanLocal) ctx.lookup("java:global/BioMightWeb/BioMightBean!biomight.ejb.BioMightBeanLocal");
		
				double circumference = 0.50;
				
				if (componentID.equals("AnimalCell:01")) {
					
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

						
					//int success = bioMightBean.generateAnimalCell("AnimalCell:00001", "AnimalCell", 
					//		"AnimalCell", componentID, parentID, currentPoints);			
					
				}
				else if (componentID.equals("AnimalCell:02"))
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

					
					
					//int success = bioMightBean.generateAnimalCell("AnimalCell:00160", "AnimalCell", 
					//	"AnimalCell", componentID, parentID, currentPoints);
			
					
				}
				else if (parentID.equals("")) 
				{	
					System.out.println("Calling Generate AnimalCell NoParent");		
				}

				
				System.out.println("Created AnimalCell Info using EJB");   	
			}catch (Exception e) { 
				System.out.println("Exception Getting Components - AnimalCell");
				throw new ServerException("Remote Exception AnimalCell():", e); 	
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
			System.out.println("AnimalCell Executing Methods");
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
		 * This method will return the X3D for the AnimalCell.  It runs through each of its components and collects up their
		 * representations and then assembles them into one unified X3D model.
		 * 
		 ********************************************************************************************************************/
		public String getX3D(boolean snipet) {
			
			// Assembe the AnimalCell
			String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
			"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n " +
			"<X3D profile='Immersive' >\n" +
			"<head>\n" +
			 "<meta name='BioMightImage' content='AnimalCell.jpg'/>\n" +
			 "<meta name='ExportTime' content='7:45:30'/>\n" +
			 "<meta name='ExportDate' content='08/15/2008'/>\n" +
			 "<meta name='BioMight Version' content='1.0'/>\n" + 
			"</head>\n" +
			"<Scene>\n" +
			"<WorldInfo\n" +
			"title='AnimalCell'\n" +
			"info='\"BioMight Generated X3D\"'/>\n";		

			String body = "";
			String annotate = "";
			
			
			// Only when the database retrieval has been locally, do we do this??
			if (viewPerspective == Constants.VIEW_INTERNAL) 
			{			
				// We do nada as the AnimalCell Data is retrieved in the collection object
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
					System.out.println("Creating AnimalCell: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
					System.out.println("Creating AnimalCell at Position: " + 
							bioMightTransform.getTranslation().getXPos() + "  " +
							bioMightTransform.getTranslation().getYPos() + "  " +
							bioMightTransform.getTranslation().getZPos());
					
					
					// Grab the data
					//************************************************************888
					//**************************************************************8
					// HACK
					lod = Constants.MAG2X;
					//************************************************************888
					//**************************************************************8
				
					if (lod == Constants.MAG1X)		
					{
						//System.out.println("Getting X3D for AnimalCellX: " + bioMightTransform.getTranslation().getXPos());
						//System.out.println("Getting X3D for AnimalCellY: " + bioMightTransform.getTranslation().getYPos());
						//System.out.println("Getting X3D for AnimalCellZ: " + bioMightTransform.getTranslation().getZPos());
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
						    " url='../images/AnimalCell.jpg'/>";
						
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
						 	"<Sphere DEF='AnimalCellGeoSphere'\n" +
						 	"containerField='geometry'\n" +
						 	"radius='" + bioMightTransform.getRadius() +"'/>\n" +
						 	"</Shape>\n" +
						 	
							"\n<TouchSensor DEF='TSENSOR_"+ bioMightTransform.getId()+ "' \n" +
			                   " description='AnimalCell'\n" +
				               " containerField='children'/> \n" +
			
						 "</Transform>\n";
						
							//	Add the text to the Tissue sample
							if (parentID.equals("1.10000:0"))
							{
								annotate = 
									"<Transform DEF='AnimalCellText' \n" +
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
									"string='\"AnimalCells\"'\n" +
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
							
							
							//******************************************************************************************************
							// Create the startCap 
							// Pass in the position and orientation. We add 180 degrees to flip the dome so it makes a startCap
							//******************************************************************************************************
					
							BioMightPosition bioMightPosition = new BioMightPosition(0.125, 0, 0);
							BioMightOrientation bioMightOrientation = new BioMightOrientation(0, 0, 1, 90);
							//BioMightOrientation bioMightOrientation = new BioMightOrientation(rodOrient[0], rodOrient[1], rodOrient[2], (rodOrient[3] + 0));
							// System.out.println("ORIENT START DOME: " + bioMightOrientation.getXAxis() + "  " + bioMightOrientation.getYAxis()  + "  " + bioMightOrientation.getZAxis()  + "  " + bioMightOrientation.getDegrees() );
						
							String componentTypeOut = "EndoPlasmicGlobal";
							body += "<Group onmouseover=\"showComponent('Endoplasmic Reticulum');\" DEF='" + componentTypeOut + "'>\n";
									
								//System.out.println("GENERATE ENDOPR: " + bioMightOrientation.getXAxis() + "  " + bioMightOrientation.getYAxis()  + "  " + bioMightOrientation.getZAxis()  + "  " + bioMightOrientation.getDegrees() );
								body += BioWebX3DUtils.generateArc(bioMightTransform,  bioMightPosition, bioMightOrientation,  false);
							
								//System.out.println("GENERATE TUBES: " + bioMightOrientation.getXAxis() + "  " + bioMightOrientation.getYAxis()  + "  " + bioMightOrientation.getZAxis()  + "  " + bioMightOrientation.getDegrees() );
								body += BioWebX3DUtils.generateTubes(bioMightTransform,  bioMightPosition, bioMightOrientation,  false);
							
							body += "</Group>\n";

							
							//System.out.println("GENERATE GOLGI: " + bioMightOrientation.getXAxis() + "  " + bioMightOrientation.getYAxis()  + "  " + bioMightOrientation.getZAxis()  + "  " + bioMightOrientation.getDegrees() );
							componentTypeOut = "GolgiApparatusGlobal";
							body += "<Transform onmouseover=\"showComponent('Golgi Apparatus');\" DEF='" + componentTypeOut + "'\n";
									
												
							body+= "rotation='" 	
									+ "0.00 , " + " "
									+ "1.00 , " + " "
									+ "0.00 , " + " "
									+ "1.05  " + "'>\n";
							
							String componentType = "GolgiApparatusGlobal";
							body += "<Transform DEF='" + componentType + "'\n";
							
							body += "translation='" 
							+ -1.48 + " " 
							+ 0.47 + " "
							+ 1.88	 + "'\n";					
						
						
							body+= "rotation='" 	
									+ "1.00 , " + " "
									+ "0.00 , " + " "
									+ "0.00 , " + " "
									+ "3.14  " + "'  \n";
							
							body+= "scale='" 	
							+ "2.55, " + " "
							+ "2.55, " + " "
							+ "2.55 " + "'>\n";
							
							
							BioMightPosition golgiPosition = new BioMightPosition(-0.150, 0.125, 0.150);
							body += BioWebX3DUtils.generateGolgiApparatus(bioMightTransform,  golgiPosition, bioMightOrientation);
							
							body += "</Transform>\n";
							body += "</Transform>\n";
							
							
						
							//double startPos[] = {bioMightTransform.getTranslation().getXPos(), bioMightTransform.getTranslation().getYPos(), bioMightTransform.getTranslation().getZPos()};
							double startPos[] = {0.0, 0.0, 0.0};
							body += BioWebX3DUtils.generateIonPumps(bioMightTransform, startPos);
					
						
							
							
							body += cellMembrane.getX3D(true) +
							endosomes.getX3D(true) +
								//ionPumps.getX3D(true) +
								//golgiApparatus.getX3D(true) +	
								//endoPlasmicReticulum.getX3D(true) +
							lysosomes.getX3D(true) +
							peroxisomes.getX3D(true) +
							ribosomes.getX3D(true) +
							mitochondria.getX3D(true) +
							nuclei.getX3D(true);
							
							
							/****
							body += 
									"<Shape> \n" +				 	    
										"<LineSet vertexCount='2'> \n" +
										"<Coordinate point='0 0 0  0 1.25 0 '/> \n" +
										"</LineSet> \n" +
									"</Shape> \n";
									
									
						
							body += 
									"<Shape> \n" +
											"<Appearance\n" +
											"containerField='appearance'>\n" +
												
												" <Material DEF='Rust'\n" +
												    "containerField='material'\n" +
												    "ambientIntensity='" 	+ bioMightTransform.getMaterial().getAmbientIntensity() + "'\n" +
												    "shininess='" 			+ bioMightTransform.getMaterial().getShininess() + "'\n" +
												    "transparency='" 		+ bioMightTransform.getMaterial().getTransparency() + "'\n" +
												    "diffuseColor='" + 
												 	    1 + " " + 
												 	    0 + " " +
												 	    0 + "'/>\n" +
												 	"</Appearance>\n" 	+
											
										
										"<LineSet vertexCount='2'> \n" +
										"<Coordinate point='0 0 0  0.75 0 0 '/> \n" +
										"</LineSet> \n" +
									"</Shape> \n";
							
							
							body += 
									"<Shape> \n" +
										"<LineSet vertexCount='2'> \n" +
										"<Coordinate point='0 0 0   0 0 1.0 '/> \n" +
										"</LineSet> \n" +
									"</Shape> \n";
							
							
					    	
							body += "<Transform DEF='TRANSFORM_STARTSPHERE'\n";
							
							body += "translation='" 
										+ 0 + " " 
					 					+ 0 + " "
					 					+ 0.5 + "'\n";				
							
							body +=  "scale='" 	+ 1 + " "
							 				    + 1 + " "
							 				    + 1 + "'>\n" +
							 				    
							 	"<Shape DEF='SHAPE_" + bioMightTransform.getId() + "' \n" +
							    " containerField='children'>\n" +
							    " <Appearance\n" +
							    "  containerField='appearance'>\n";

							    	
							body+= " <Material DEF='Rust'\n" +
							    "containerField='material'\n" +
							    "ambientIntensity='" 	+ bioMightTransform.getMaterial().getAmbientIntensity() + "'\n" +
							    "shininess='" 			+ bioMightTransform.getMaterial().getShininess() + "'\n" +
							    "transparency='" 		+ "0.25" + "'\n" +
							    "diffuseColor='" + 
							 	    0.0 + " " + 
							 	    0.0 + " " +
							 	    1.0 + "'/>\n" +
							 	"</Appearance>\n" +
							 	"<Sphere DEF='StartSphere'\n" +
							 	"containerField='geometry'\n" +
							 	"radius='" + 0.055 +"'/>\n" +
							 	"</Shape>\n" +
							 	
		
	 						"</Transform>\n";
		
							
					    	
							body += "<Transform DEF='TRANSFORM_STARTSPHERE'\n";
							
							body += "translation='" 
										+ 0.5 + " " 
					 					+ 0 + " "
					 					+ 0 + "'\n";				
							
							body +=  "scale='" 	+ 1 + " "
							 				    + 1 + " "
							 				    + 1 + "'>\n" +
							 				    
							 	"<Shape DEF='SHAPE_" + bioMightTransform.getId() + "' \n" +
							    " containerField='children'>\n" +
							    " <Appearance\n" +
							    "  containerField='appearance'>\n";

							    	
							body+= " <Material DEF='Rust'\n" +
							    "containerField='material'\n" +
							    "ambientIntensity='" 	+ bioMightTransform.getMaterial().getAmbientIntensity() + "'\n" +
							    "shininess='" 			+ bioMightTransform.getMaterial().getShininess() + "'\n" +
							    "transparency='" 		+ "0.25" + "'\n" +
							    "diffuseColor='" + 
							 	    1.0 + " " + 
							 	    0.0 + " " +
							 	    0.0 + "'/>\n" +
							 	"</Appearance>\n" +
							 	"<Sphere DEF='StartSphere'\n" +
							 	"containerField='geometry'\n" +
							 	"radius='" + 0.055 +"'/>\n" +
							 	"</Shape>\n" +
							 	
		
	 						"</Transform>\n";
							***************/
							
						}
					}
			}
			else 
			{			
				// Issue
			}	
				
			
			body+= "<Viewpoint DEF='Viewpoint_InfluenzaAVirus'\n" +
					 "description='Viewpoint1'\n" +
					 "jump='true'\n" +
					 "fieldOfView='0.785'\n" +
					 "position='0.0 0.0 2.0'\n" +
					 "orientation='0 0 1 0'/>\n";
			
			
			//System.out.println("AnimalCell X3D: " + body);		
			String footer = "</Scene>" + "</X3D>\n";
			
			if (snipet)
				return body;			
			else	
				return header + body + annotate + footer;				
		}



}
