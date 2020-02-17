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
import biomight.cell.nucleus.Nucleus;
import biomight.chemistry.compound.AngiotensinConvertingEnzyme;
import biomight.chemistry.compound.Collagenase;
import biomight.chemistry.compound.Elastase;
import biomight.chemistry.compound.GlutaThione;
import biomight.chemistry.compound.HydrogenPeroxide;
import biomight.chemistry.compound.IgGReceptors;
import biomight.chemistry.compound.Lysozymes;
import biomight.chemistry.compound.PlasminogenActivator;
import biomight.chemistry.compound.PlateletActivatingFactor;
import biomight.chemistry.compound.PlateletDerivedGrowthFactor;
import biomight.chemistry.compound.SuperOxideAnion;
import biomight.chemistry.compound.Thromboplastin;
import biomight.chemistry.cytokine.chemokine.Chemokines;
import biomight.chemistry.hormones.lipid.Leukotrienes;
import biomight.chemistry.hormones.lipid.Prostaglandins;
import biomight.chemistry.hormones.peptide.TransformingGrowthFactor;
import biomight.chemistry.hormones.peptide.TumorNecrosisFactor;
import biomight.chemistry.molecule.receptor.ComplimentReceptorC3b;
import biomight.chemistry.molecule.receptor.FCReceptors;
import biomight.chemistry.nucleicacid.nucleotide.Nucleotides;
import biomight.chemistry.protein.ComplementSystem;
import biomight.chemistry.protein.Integrins;
import biomight.chemistry.protein.ProteinFactorIX;
import biomight.chemistry.protein.ProteinFactorV;
import biomight.chemistry.protein.ProteinFactorVII;
import biomight.chemistry.protein.ProteinFactorX;
import biomight.chemistry.protein.plasma.ProThrombin;
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


/**********************************************************************************
 * @author SurferJim
 *
 * Representation of a Macrophage.  This cell travels through the body eating
 * harmful bacteria and kicking off an immune response when necessary.  Basically,
 * its a biological tank with on-board command ops.
 * 
 **********************************************************************************/

public class Macrophage extends BioMightBase {
	private BioMightPosition bioMightPosition;
	private CellMembrane cellMembrane;
	private Nucleus nucleus;
	
	
	private Chemokines chemokines; 
	private Integrins integrins;
	private FCReceptors fcReceptors;
	private ComplimentReceptorC3b complimentReceptorC3b;
 	private IgGReceptors igGReceptors;
 	
 	// Enzymes
	private Lysozymes lysozymes;
	private Elastase elastase;
	private Collagenase collagenase;
	private PlasminogenActivator plasminogenActivator;
	private AngiotensinConvertingEnzyme angiotensinConvertingEnzyme;
	
	// Mediators
	private TumorNecrosisFactor tumorNecrosisFactor;
	private PlateletDerivedGrowthFactor PlateletDerivedGrowthFactor;
	private PlateletActivatingFactor plateletActivatingFactor;
	private TransformingGrowthFactor transformingGrowthFactor;
	private Prostaglandins prostaglandins;
	private Leukotrienes Lleukotrienes;
	
	// Complement
	private ComplementSystem complementSystem;
	
	// Coagulation factors
	private ProteinFactorV proteinFactorV;
	private ProteinFactorVII proteinFactorVII;
	private ProteinFactorIX proteinFactorIX;
	private ProteinFactorX proteinFactorX;
	private ProThrombin proThrombin;
	private Thromboplastin  Thromboplastin;
	
	// Reactive Oxygen species
	private HydrogenPeroxide hydrogenPeroxide;
	private SuperOxideAnion superOxideAnion;
	
	private GlutaThione glutaThione;
	private Nucleotides nucleotides;
	
	
	public Macrophage()
	{		
		// Create the Base Macrophage
		lod = Constants.VIEW_HAWKEYE;
		hierarchy= Constants.BIO_CHILD;
		create(hierarchy, lod, Constants.MacrophageRef, null, null);
	}
	
	public Macrophage(String parentID)
	{				
		lod = Constants.VIEW_HAWKEYE;
		hierarchy= Constants.BIO_CHILD;
		create(hierarchy, lod, parentID, null, null);	
	}
		

	public Macrophage(String parentID, BioMightPosition bioMightPosition)
	{
		lod = Constants.VIEW_HAWKEYE;
		hierarchy= Constants.BIO_CHILD;
		create(hierarchy, lod, parentID, null, null);
		//this.bioMightPosition = bioMightPosition;
	}
	
	
	public Macrophage(int localVP, int localLOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
	{
		create(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);
	}
	
	
	public void create(int localVP, int localLOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
	{
			this.setImage("images/Macrophage.jpg");
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
			
			System.out.println("In Macrophage Create() - LOD: " + lod);
			
			if (localVP == Constants.VIEW_INTERNAL)			
			{
				// Do nothing.  We are instantiating as part of a collection  
				// There is no drill down, so we use the transforms that the
				// parent has already collected
				System.out.println("In Macrophage Create() - Already Set: " + parentID);				
			}
			else if (localVP == Constants.VIEW_DETACHED) 
			{	
				// We are going to assemble from subcomponents 
				
				if (bioMightMethods != null){
					//System.out.println("NEED TO EXECUTE Calyx METHODS: " + bioMightMethods.size());
				}
				
				// Generate the Macrophage Epihelium if needed 
				boolean bGenerate = false;
				if (bGenerate) {
					generate(parentID, componentID);
				}
			
				System.out.println("Creating Macrophage : " + parentID);				
				cellMembrane = new CellMembrane(parentID, bioMightMethods);
								
				System.out.println("Macrophage Instance created from SubComponents : " + parentID);
			}	
			else if (localVP == Constants.VIEW_HAWKEYE)
			{
				// This is when one is accessing a Macrophage directly
				// Get the information from the database via the Enterprise Bean		
				try {
					// Get the information from the database via the Enterprise Bean		
					System.out.println("Getting HawkEye MacrophageInfo for ParentID: " + parentID);
					InitialContext ctx = new InitialContext();
					BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
					bioMightTransforms = bioMightBean.getComponent(parentID);
					System.out.println("Have Macrophage Info from EJB");   	
				}catch (Exception e) { 
					System.out.println("Exception Getting Components - Macrophage");
					throw new ServerException("Remote Exception getComponents():", e); 	
				}
					
				// Run through the collection of Macrophages and build them into the model
				// In the default case, we get one instance of the Macrophage for each eye
				ArrayList transforms = bioMightTransforms.getTransforms();
				System.out.println("Macrophage NumTransforms: " + transforms.size());
				for (int i=0; i<transforms.size(); i++)
				{
					// Get the information for the Macrophage
					BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
					System.out.println("Creating Macrophage: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
					this.componentID = bioMightTransform.getId();
					
					// initialize the Properties
					initProperty(bioMightTransform.getName(), Constants.Macrophage, Constants.MacrophageRef, bioMightTransform.getId());

				}
			}
			else if (localVP == Constants.VIEW_BIRDSEYE)
			{
				// This is when one is accessing a Macrophage directly
				// Get the information from the database via the Enterprise Bean		
				try {
					// Get the information from the database via the Enterprise Bean		
					System.out.println("Getting BirdsEye MacrophageInfo for ParentID: " + parentID);
					InitialContext ctx = new InitialContext();
					BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
					bioMightTransforms = bioMightBean.getComponent(parentID);
					System.out.println("Have Macrophage Info from EJB");   	
				}catch (Exception e) { 
					System.out.println("Exception Getting Components - Macrophage");
					throw new ServerException("Remote Exception getComponents():", e); 	
				}
					
				// Run through the collection of Macrophages and build them into the model
				// In the default case, we get one instance of the Macrophage for each eye
				ArrayList transforms = bioMightTransforms.getTransforms();
				System.out.println("Macrophage NumTransforms: " + transforms.size());
				for (int i=0; i<transforms.size(); i++)
				{
					// Get the information for the Macrophage
					BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
					System.out.println("Creating Macrophage: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
					this.componentID = bioMightTransform.getId();
					
					// Go get the finer details of the Macrophage
					
					System.out.println("Creating Macrophage : " + parentID);				
					cellMembrane = new CellMembrane(parentID, bioMightMethods);									
					System.out.println("Macrophage Instance created from SubComponents : " + parentID);
					
					
					
					
					// initialize the Properties
					initProperty("Cell Membrane", Constants.CellMembrane, Constants.CellMembraneRef, bioMightTransform.getId());
				}
			}
			
			else
			{
				
			}
				
			initMethods();
			
			System.out.println("CreateMacrophage Completed");
			
			// First, get all the data from the database
			// Apply the methods to it
			// Save its state
			this.parentID = parentID;
			if (bioMightMethods != null){
				System.out.println("EXECUTING Macrophage Methods: " + bioMightMethods.size());
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
		 * GENERATE MACROPHAGE
		 * 
		 * 
		 * @param parentID
		 * @param componentID
		 ***************************************************/
		public void generate(String parentID, String componentID)
		{
			// Generate the Macrophage		
			BioMightBeanLocal bioMightBean;
			try {
				// Get the information from the database via the Enterprise Bean		
				System.out.println("Generating the Macrophage : " + componentID + "    " + parentID);
				InitialContext ctx = new InitialContext();
				bioMightBean = (BioMightBeanLocal) ctx.lookup("java:global/BioMightWeb/BioMightBean!biomight.ejb.BioMightBeanLocal");
		
				double circumference = 0.125;
				
				if (componentID.equals("Macrophage:01")) {
					
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

						
					//int success = bioMightBean.generateMacrophage("Macrophage:00001", "Macrophage", 
					//		"Macrophage", componentID, parentID, currentPoints);			
					
				}
				else if (componentID.equals("Macrophage:02"))
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

					
					
					//int success = bioMightBean.generateMacrophage("Macrophage:00160", "Macrophage", 
					//	"Macrophage", componentID, parentID, currentPoints);
			
					
				}
				else if (parentID.equals("")) 
				{	
					System.out.println("Calling Generate Macrophage NoParent");		
				}

				
				System.out.println("Created Macrophage Info using EJB");   	
			}catch (Exception e) { 
				System.out.println("Exception Getting Components - Macrophage");
				throw new ServerException("Remote Exception Macrophage():", e); 	
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
			System.out.println("Macrophage Executing Methods");
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
	 * This method will return the X3D for the Macrophage.  It runs through each of its components and collects up their
	 * representations and then assembles them into one unified X3D model.
	 * 
	 ********************************************************************************************************************/
	
	public String getX3D(boolean snipet) {
			
			// Assembe the Macrophage
			String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
			"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n " +
			"<X3D profile='Immersive' >\n" +
			"<head>\n" +
			 "<meta name='BioMightImage' content='Macrophage.jpg'/>\n" +
			 "<meta name='ExportTime' content='7:45:30'/>\n" +
			 "<meta name='ExportDate' content='08/15/2008'/>\n" +
			 "<meta name='BioMight Version' content='1.0'/>\n" + 
			"</head>\n" +
			"<Scene>\n" +
			"<WorldInfo\n" +
			"title='Macrophage'\n" +
			"info='\"BioMight Generated X3D\"'/>\n";		

			String body = "";
			String annotate = "";
			
			
			// Only when the database retrieval has been locally, do we do this??
			if (viewPerspective == Constants.VIEW_INTERNAL) 
			{			
				// We do nada as the Macrophage Data is retrieved in the collection object
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
					System.out.println("Getting HAWKEYE X3D for Macrophage: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());				

					//System.out.println("Getting X3D for MacrophageX: " + bioMightTransform.getTranslation().getXPos());
					//System.out.println("Getting X3D for MacrophageY: " + bioMightTransform.getTranslation().getYPos());
					//System.out.println("Getting X3D for MacrophageZ: " + bioMightTransform.getTranslation().getZPos());
					// Change the height and width based on the displacement.
					body += "<Transform DEF='Macrophage'\n";
						
						
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
					 	"<Shape DEF='Macrophage'\n" +
					    " containerField='children'>\n" +
					    " <Appearance\n" +
					    "  containerField='appearance'>\n";
				
				
					body+= " <ImageTexture containerField='texture' " +
					    " url='../images/SpeckledBlue.png'/>";
					
									    
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
					 	"<Sphere DEF='MacrophageGeoSphere'\n" +
					 	"containerField='geometry'\n" +
					 	"radius='" + bioMightTransform.getRadius() +"'/>\n" +
					 	"</Shape>\n" +
					 	
						"\n<TouchSensor DEF='"+bioMightTransform.getId()+"' \n" +
		                   " description='Macrophage'\n" +
			               " containerField='children'/> \n" +
		
					 "</Transform>\n";			

					BioMightPosition bioMightPosition = new BioMightPosition(0.125, 0, 0);
					BioMightOrientation bioMightOrientation = new BioMightOrientation(0, 0, 1, 90);
					// System.out.println("ORIENT START DOME: " + bioMightOrientation.getXAxis() + "  " + bioMightOrientation.getYAxis()  + "  " + bioMightOrientation.getZAxis()  + "  " + bioMightOrientation.getDegrees() );
				
					//String componentTypeOut = "Macropage";
					//body += "<Group onmouseover=\"showComponent('Endoplasmic Reticulum');\" DEF='" + componentTypeOut + "'>\n";
							
					System.out.println("GENERATE Macrophage: " + bioMightOrientation.getXAxis() + "  " + bioMightOrientation.getYAxis()  + "  " + bioMightOrientation.getZAxis()  + "  " + bioMightOrientation.getDegrees() );
			
					double maxWidth = 0.035;
					double maxHeight = 0.3;
					BioMightRange bioRange = new BioMightRange(25, 3, 7, 3, 9,  0,  maxWidth, 0, maxHeight);
				    body+= BioWebX3DUtils.generateFlagellaSphere(bioMightTransform,  new double[] {bioMightPosition.getXPos(), bioMightPosition.getYPos(), bioMightPosition.getZPos()}, bioRange);
			
				   // body = BioWebX3DUtils.generateMacrophage(bioMightTransform,  bioMightPosition, bioMightOrientation, false);
	
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
			
			
			//System.out.println("Basophil X3D: " + body);		
			String footer = "</Scene>" + "</X3D>\n";
			
			if (snipet)
				return body;			
			else	
				return header + body + annotate + footer;				
		}

		
		
		
}
