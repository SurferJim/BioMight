
package biomight.virus.dna;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.ArrayList;

import javax.naming.InitialContext;

import biomight.Constants;
import biomight.bacteria.Bacteria;
import biomight.chemistry.nucleicacid.DNA;
import biomight.chemistry.pharma.diuretic.Mannitol;
import biomight.ejb.BioMightBeanLocal;
import biomight.exceptions.ServerException;
import biomight.view.BioMightMethodView;
import biomight.view.BioMightOrientation;
import biomight.view.BioMightPosition;
import biomight.view.BioMightPropertyView;
import biomight.view.BioMightTexture;
import biomight.view.BioMightTransform;
import biomight.view.BioMightTransforms;

import javax.naming.InitialContext;

import biomight.BioMightBase;
import biomight.Constants;
import biomight.bacteria.Bacteria;
import biomight.bacteria.BacterialCellWall;
import biomight.bacteria.BacterialPolymerase;
import biomight.bacteria.BacterialRibosomes;
import biomight.bacteria.CytoplasmicMembrane;
import biomight.bacteria.Fimbriae;
import biomight.bacteria.Flagella;
import biomight.bacteria.Mesosomes;
import biomight.bacteria.Nucleoid;
import biomight.bacteria.Periplasm;
import biomight.bacteria.PeriplasmicSpace;
import biomight.bacteria.Pilus;
import biomight.bacteria.Plasmid;
import biomight.bacteria.Transposons;
import biomight.cell.CellMembrane;
import biomight.cell.Ribosomes;
import biomight.chemistry.aminoacid.GlutamicAcid;
import biomight.chemistry.pharma.diuretic.Mannitol;
import biomight.ejb.BioMightBeanLocal;
import biomight.exceptions.ServerException;
import biomight.util.BioGraphics;
import biomight.view.BioMightMethodView;
import biomight.view.BioMightPosition;
import biomight.view.BioMightPropertyView;
import biomight.view.BioMightTransform;
import biomight.virus.Capsid;
import biomight.virus.CoreMembrane;
import biomight.virus.GlycoProteinSpikes;
import biomight.virus.LateralBodies;
import biomight.virus.MembraneTubules;
import biomight.virus.OuterMembrane;
import biomightweb.util.BioWebUtils;
import biomightweb.util.BioWebX3DUtils;
import biomightweb.view.BioMightRange;

/*********************************************************************************
 * @author SurferJim
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 ********************************************************************************/

public class PoxVirus extends BioMightBase {
	
	private String bacteriaName = "PoxVirus";
	private ArrayList colors;
	private BioMightPosition bioMightPosition;
	private int view = Constants.VIEW_BIRDSEYE; 
	
	//private LethalFactor lethalFactor;
	private GlutamicAcid glutamicAcid;
	private Flagella flagella;
	private Nucleoid nucleoid;	
	private Fimbriae fimbriae;
	private Mesosomes mesosomes;
	private Ribosomes ribosomes;
	private Periplasm periplasm;
	private PeriplasmicSpace periplasmicSpace;
	private Pilus pilus;
	private Plasmid plasmid;
	private Transposons transposons;
	private CytoplasmicMembrane cytoplasmicMembrane;
	private BacterialRibosomes bacterialRibosomes;
	private BacterialPolymerase bacterialPolymerase;
	private BigDecimal amountCoagulse;
	private boolean isMethicillinResistant;
	private boolean isNafcillinResistant;
	private boolean isVancoMycinResistant;
	ArrayList textures = null;
	
	private OuterMembrane outerMembrane;
	private CoreMembrane coreMembrane; 
	private GlycoProteinSpikes glycoProteinSpikes;
	private DNA dna;
	private LateralBodies lateralBodies;
	private MembraneTubules membraneTubules;
	
	//private MajorHistocompatibilityComplex mHC;
	//private B7Protein Bb7Protein;
	//private IgM immunoglobinM;
	
	public PoxVirus()
	{
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, Constants.PoxVirusRef, null, null);
	}

	public PoxVirus(String parentID)
	{
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, parentID, null, null);
	}

	public PoxVirus(int hierarchy, int LOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
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
		this.setImage("images/PoxVirus.jpg");
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
				
		
	
		// First, get all the data from the database
		if (bioMightMethods != null){
			System.out.println("EXECUTING PoxVirus Methods: " + bioMightMethods.size());
			executeMethods(bioMightMethods);
		}

		
		if (localVP == Constants.VIEW_INTERNAL)			
		{
			// Do nothing.  We are instantiating as part of a collection  
			// There is no drill down, so we use the transforms that the
			// parent has already collected
			System.out.println("In PoxVirus Create() - ViewInternal - Already Set: " + parentID);				

			// We already have the data for the current instance of PoxVirus,
			// Go get the details for the current PoxVirus is LOD is set
			if (localLOD == Constants.MAG2X)
			{
				// Go get the finer details of the PoxVirus				
				System.out.println("Getting the PoxVirus MAG2X : " + parentID);
				localVP = Constants.VIEW_INTERNAL; 
				localLOD = Constants.MAG1X;
							
				outerMembrane = new OuterMembrane(localVP, localLOD, componentID, bioMightProperties, bioMightMethods);
				initProperty(Constants.OuterMembraneRef, Constants.OuterMembrane, Constants.OuterMembraneRef, outerMembrane.getComponentID());
				System.out.println("In PoxVirus - OuterMembrane is complete: " + outerMembrane.getComponentID());
				
				coreMembrane = new CoreMembrane(localVP, localLOD, componentID, bioMightProperties, bioMightMethods);
				initProperty(Constants.CoreMembraneRef, Constants.CoreMembrane, Constants.CoreMembraneRef, coreMembrane.getComponentID());
				System.out.println("In PoxVirus - CoreMembraneRef is complete: " + coreMembrane.getComponentID());
				
				lateralBodies = new LateralBodies(localVP, localLOD, componentID, bioMightProperties, bioMightMethods);
				initProperty(Constants.LateralBodiesRef, Constants.LateralBodies, Constants.LateralBodiesRef, lateralBodies.getComponentID());
				System.out.println("In PoxVirus - LateralBodies is complete: " + lateralBodies.getComponentID());
		
				membraneTubules = new MembraneTubules(localVP, localLOD, componentID, bioMightProperties, bioMightMethods);
				initProperty(Constants.MembraneTubulesRef, Constants.MembraneTubules, Constants.MembraneTubulesRef, membraneTubules.getComponentID());
				System.out.println("In PoxVirus - MembraneTubules is complete: " + membraneTubules.getComponentID());
			}
		
		}	
		else if (localVP == Constants.VIEW_HAWKEYE)
		{
			
			//***************************************************************
			//***************************************************************
			// ON the drill down go into the detail for now on a single cell
			// HACK
			localLOD = Constants.MAG2X;
			//***************************************************************
			//***************************************************************
		
			// This is when one is accessing a PoxVirus directly
			// Get the information from the database via the Enterprise Bean		
			try {
				// Get the information from the database via the Enterprise Bean		
				System.out.println("Getting HawkEye PoxVirusInfo for ParentID: " + parentID);
				InitialContext ctx = new InitialContext();
				BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup("java:global/BioMightWeb/BioMightBean!biomight.ejb.BioMightBeanLocal");
				bioMightTransforms = bioMightBean.getComponent(parentID);
				
				System.out.println("Have PoxVirus Info from EJB");   	
			}catch (Exception e) { 
				System.out.println("Exception Getting Components - PoxVirus");
				throw new ServerException("Remote Exception getComponents():", e); 	
			}
				
			// Run through the collection of BacilliAnthracis and build them into the model
			// In the default case, we get one instance of the PoxVirus for each eye
			ArrayList transforms = bioMightTransforms.getTransforms();
			System.out.println("PoxVirus NumTransforms: " + transforms.size());
			for (int i=0; i<transforms.size(); i++)
			{
				// Get the information for the PoxVirus
				BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
				this.setBioMightTransform(bioMightTransform);
				System.out.println("Creating PoxVirus: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
				this.componentID = bioMightTransform.getId();

		
				if (localLOD == Constants.MAG1X)
				{
					System.out.println("Creating PoxVirus at HawkEye MAG1X - Just Init Properties: " + parentID);
					// initialize the Properties
					initProperties();
				}
				if (localLOD == Constants.MAG2X)
				{
					// Go get the finer details of the PoxVirus				
					System.out.println("Creating PoxVirus at HawkEye MAG2X : " + parentID);
					localVP = Constants.VIEW_INTERNAL; 
					localLOD = Constants.MAG1X;

					outerMembrane = new OuterMembrane(localVP, localLOD, componentID, bioMightProperties, bioMightMethods);
					initProperty(Constants.OuterMembraneRef, Constants.OuterMembrane, Constants.OuterMembraneRef, outerMembrane.getComponentID());
					System.out.println("In PoxVirus - OuterMembrane is complete: " + outerMembrane.getComponentID());
		
					coreMembrane = new CoreMembrane(localVP, localLOD, componentID, bioMightProperties, bioMightMethods);
					initProperty(Constants.CoreMembraneRef, Constants.CoreMembrane, Constants.CoreMembraneRef, coreMembrane.getComponentID());
					System.out.println("In PoxVirus - CoreMembrane is complete: " + coreMembrane.getComponentID());
			
					lateralBodies = new LateralBodies(localVP, localLOD, componentID, bioMightProperties, bioMightMethods);
					initProperty(Constants.LateralBodiesRef, Constants.LateralBodies, Constants.LateralBodiesRef, lateralBodies.getComponentID());
					System.out.println("In PoxVirus - LateralBodies is complete: " + lateralBodies.getComponentID());
			
					membraneTubules = new MembraneTubules(localVP, localLOD, componentID, bioMightProperties, bioMightMethods);
					initProperty(Constants.MembraneTubulesRef, Constants.MembraneTubules, Constants.MembraneTubulesRef, membraneTubules.getComponentID());
					System.out.println("In PoxVirus - MembraneTubules is complete: " + membraneTubules.getComponentID());
				}
				
			}
		}		
		else
		{
			
		}
			
		initMethods();	
		System.out.println("Create PoxVirus Completed");
	}
		
	
	public void initMethods() {
		
		BioMightMethodView method;
		method = new BioMightMethodView();
		method.setCanonicalName(Constants.PoxVirus);
		method.setMethodName("setMaterial");
		method.setDisplayName("Material");
		method.setHtmlType(Constants.BIO_DROPDOWN);
		method.setDataType(Constants.BIO_TEXT);
	 	method.setValueMap(materialDDMap);
		methods.add(method);
		
		method = new BioMightMethodView();
		method.setCanonicalName(Constants.PoxVirus);
		method.setMethodName("setTexture");
		method.setDisplayName("Texture");
		method.setHtmlType(Constants.BIO_DROPDOWN);
		method.setDataType(Constants.BIO_TEXT);
	 	method.setValueMap(textureDDMap);
		methods.add(method);

	}

	private void initProperties() {
		
		BioMightPropertyView property = new BioMightPropertyView();
		property.setPropertyName("Cell Membrane");
		property.setCanonicalName(Constants.CellMembraneRef);
		properties.add(property);
		
		/*
		private MajorHistocompatibilityComplex mHC;
		private B7Protein Bb7Protein;
		private IgM immunoglobinM;
		*/
				
	}
	
	
	/******************************************************************************************
	 * GENERATE 
	 * 
	 * 
	 * @param parentID
	 * @param componentID
	 ******************************************************************************************/
	public void generate(String parentID, String componentID)
	{
		// Generate the PoxVirus		
		BioMightBeanLocal bioMightBean;
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Generating the PoxVirus : " + componentID + "    " + parentID);
			InitialContext ctx = new InitialContext();
			bioMightBean = (BioMightBeanLocal) ctx.lookup("java:global/BioMightWeb/BioMightBean!biomight.ejb.BioMightBeanLocal");
	
			double radius = 0.125;
					
			// Generate the Palm
			double[] startPos = {3.75,-23.0,-6.0};
			double[][] currentPoints = BioGraphics.octogonXPlane(startPos, radius);
						
			//int success = bioMightBean.generatePoxVirus("PoxVirus:00001", "PoxVirus", 
			//		"PoxVirus", componentID, parentID, currentPoints);			
			
			System.out.println("Created PoxVirus Info using EJB");   	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - PoxVirus");
			throw new ServerException("Remote Exception PoxVirus():", e); 	
		}
	}
	

	
	/********************************************************************************************************************
	 * GET X3D
	 * 
	 * This method will return the X3D for the PoxVirus.  It runs through each of its components and collects up their
	 * representations and then assembles them into one unified X3D model.
	 * 
	 ********************************************************************************************************************/
	public String getX3D(boolean snipet) {
		
		// Assemble the PoxVirus
		String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
		"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n " +
		"<X3D profile='Immersive' >\n" +
		"<head>\n" +
		 "<meta name='BioMightImage' content='PoxVirus.jpg'/>\n" +
		 "<meta name='ExportTime' content='7:45:30'/>\n" +
		 "<meta name='ExportDate' content='08/15/2008'/>\n" +
		 "<meta name='BioMight Version' content='1.0'/>\n" + 
		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='PoxVirus'\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		

		String body = "";
		String annotate = "";
		

		System.out.println("Getting X3D for PoxVirus!!!!!!!!");
 
		
		// Only when the database retrieval has been locally, do we do this??
		if (viewPerspective == Constants.VIEW_INTERNAL) 
		{	
			
			System.out.println("Get X3D PoxVirus - View Internal");
			// We do nada as the PoxVirus Data is retrieved in the collection object
			// and the X3D is generated there
			lod = Constants.MAG2X;
			if (lod == Constants.MAG2X)		
			{
				System.out.println("Get X3D PoxVirus - View Internal - 2X");
				//We are going to get the X3D from the aggregation objects
				//body += cellMembrane.getX3D(true) + fimbriae.getX3D(true) + mesosomes.getX3D(true) + flagella.getX3D(true);
				
				//System.out.println("Get X3D PoxVirus - Getting Anitbodies - 2X");
				//body += antibodies.getX3D(true);
				//System.out.println("Get X3D PoxVirus - Have Anitbodies - 2X");
				
				ArrayList ranges = new ArrayList();
				BioMightPosition bioMightPositionOuterMembrane = new BioMightPosition(0.0, 0.250, 0);
				BioMightPosition bioMightPositionCore = new BioMightPosition(0.0, 0.200, 0);
				BioMightPosition bioMightPositionLateralBodyLeft = new BioMightPosition(-0.075, 0.17, 0);
				BioMightPosition bioMightPositionLateralBodyRight = new BioMightPosition(0.075, 0.17, 0);
				BioMightOrientation bioMightOrientation = new BioMightOrientation(0, 0, 1, 90);
		
		
				double maxWidth = 0.035;
				double maxHeight = 0.3;
		
				BioMightRange bioRange = new BioMightRange(25, 3, 5, 0, 3, 0,  maxWidth, 0, maxHeight);
				ranges.add(bioRange);
		
				maxWidth = 0.035;
				maxHeight = 0.3;
			 	
			    ranges = new ArrayList();
				bioRange = new BioMightRange(25, 3, 5, 11, 14, 0,  maxWidth, 0, maxHeight);
				ranges.add(bioRange);
				
				
				//body += BioWebX3DUtils.generatePoxVirusOuterMembrane(bioMightTransform,  bioMightPositionOuterMembrane, bioMightOrientation); 	
			  	body += BioWebX3DUtils.generatePoxVirusCoreMembrane(bioMightTransform,  bioMightPositionCore, bioMightOrientation);
				body += BioWebX3DUtils.generatePoxVirusLateralBody(bioMightTransform,  bioMightPositionLateralBodyLeft, bioMightOrientation);
				body += BioWebX3DUtils.generatePoxVirusLateralBody(bioMightTransform,  bioMightPositionLateralBodyRight, bioMightOrientation);
	
				body += outerMembrane.getX3D(true);
				
									  	
			}
			else if (lod == Constants.MAG1X)
			{			
				// We went to the database to get data.  There will be 1 Transform record
			
				/*
				System.out.println("Creating PoxVirus: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
				System.out.println("Creating PoxVirus at Position: " + 
						bioMightTransform.getTranslation().getXPos() + "  " +
						bioMightTransform.getTranslation().getYPos() + "  " +
						bioMightTransform.getTranslation().getZPos());
	
				double radius = bioMightTransform.getRadius();
				bioMightTransform.setComponentName("Cell Membrane");
				bioMightTransform.setTextureID(5);
				bioMightTransform.setTextureFile("SpeckledAmethyst.png");
				bioMightTransform.setRadius(0.75);
				body += BioWebX3DUtils.generateSphereSimple(bioMightTransform);	
				bioMightTransform.setRadius(radius);	
	
				*/
			}
		
		}
		else if (viewPerspective == Constants.VIEW_HAWKEYE) 
		{
			System.out.println("Get X3D PoxVirus - View Hawkeye");
			
			//************************************************************888
			//**************************************************************8
			// HACK
			lod = Constants.MAG2X;
			//************************************************************
			//************************************************************

			if (lod == Constants.MAG2X)		
			{
				System.out.println("Get X3D PoxVirus - View Hawkeye -- 2X");
				//We are going to get the X3D from the aggregation objects
				//body += cellMembrane.getX3D(true);
				
				//System.out.println("Get X3D PoxVirus - Getting Antibodies - 2X");
				//body += antibodies.getX3D(true);
				//System.out.println("Get X3D PoxVirus - Have Anitbodies - 2X");
			
				ArrayList ranges = new ArrayList();
				
			
				BioMightPosition bioMightPositionCapsid = new BioMightPosition(0.0, 0.250, 0);
				BioMightPosition bioMightPositionCore = new BioMightPosition(0.0, 0.200, 0);
				BioMightPosition bioMightPositionLateralBodyLeft = new BioMightPosition(-0.075, 0.17, 0);
				BioMightPosition bioMightPositionLateralBodyRight = new BioMightPosition(0.075, 0.17, 0);
				BioMightOrientation bioMightOrientation = new BioMightOrientation(0, 0, 1, 90);
		
				double maxWidth = 0.035;
				double maxHeight = 0.3;
		
				BioMightRange bioRange = new BioMightRange(25, 3, 5, 0, 3, 0,  maxWidth, 0, maxHeight);
				ranges.add(bioRange);
		
				maxWidth = 0.035;
				maxHeight = 0.1;
				
				// Set up HawkEye Positioning
				bioMightTransform.setTranslation(bioMightPosition);
			    
				System.out.println("Getting Data from BioMight Transform");
				double nucleurRadius = bioMightTransform.getRadius()/4;
				bioMightTransform.setRadius(nucleurRadius);	
				
			    ranges = new ArrayList();
				bioRange = new BioMightRange(25, 3, 5, 11, 14, 0,  maxWidth, 0, maxHeight);
				ranges.add(bioRange);
			    
			  	body += BioWebX3DUtils.generatePoxVirusOuterMembrane(bioMightTransform,  bioMightPositionCapsid, bioMightOrientation); 	
			  	body += BioWebX3DUtils.generatePoxVirusCoreMembrane(bioMightTransform,  bioMightPositionCore, bioMightOrientation);
				//body += BioWebX3DUtils.generatePoxVirusLateralBody(bioMightTransform,  bioMightPositionLateralBodyLeft, bioMightOrientation);
				//body += BioWebX3DUtils.generatePoxVirusLateralBody(bioMightTransform,  bioMightPositionLateralBodyRight, bioMightOrientation);
				
				body += outerMembrane.getX3D(true);
				
			}
			else
			{			
				// We went to the database to get data.  There will be 1 Transform record
				System.out.println("Get X3D PoxVirus - View Hawkeye  1X");
			
				ArrayList transforms = bioMightTransforms.getTransforms();
				for (int i=0; i<transforms.size(); i++)
				{
					// Get the information for the capsomer we are creating
					BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
				//	System.out.println("Creating PoxVirus: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
				//	System.out.println("Creating PoxVirus at Position: " + 
				//			bioMightTransform.getTranslation().getXPos() + "  " +
				//			bioMightTransform.getTranslation().getYPos() + "  " +
				//			bioMightTransform.getTranslation().getZPos());
					

						double xPos = bioMightTransform.getTranslation().getXPos();  
						double yPos = bioMightTransform.getTranslation().getYPos();
						double zPos = bioMightTransform.getTranslation().getZPos();	
						double height =  bioMightTransform.getHeight();
						double radius = bioMightTransform.getRadius();
						
						for (int k=0; k<2; k++) {
								
							yPos = BioWebUtils.randomWithRange(0.0, 1.15*radius);
										
							radius = bioMightTransform.getRadius();
							bioMightTransform.setComponentName("Pox Virus");
							bioMightTransform.setTextureID(5);
							bioMightTransform.setTextureFile("SpeckledAmethyst.png");
							bioMightTransform.setRadius(0.75);
							body += BioWebX3DUtils.generateSphereSimple(bioMightTransform);	
							bioMightTransform.setRadius(radius);	
											
							
							xPos = xPos + (radius*1.5);
						}
				}
				
			}
		}
		else 
		{			
			// Issue
		}	
		
		
		body+= "<Viewpoint DEF='Viewpoint_PoxVirus'\n" +
				 "description='Viewpoint1'\n" +
				 "jump='true'\n" +
				 "fieldOfView='0.785'\n" +
				 "position='0.0 0.0 0.5'\n" +
				 "orientation='0 0 1 0'/>\n";
		
		//System.out.println("PoxVirus X3D: " + body);		
		String footer = "</Scene>" + "</X3D>\n";
		
		if (snipet)
			return body;			
		else	
			return header + body + annotate + footer;				
	}



	/******************************************************************************************
	 * EXECUTE METHODS 
	 *
	 ******************************************************************************************/
	public void executeMethods(ArrayList<BioMightMethodView> bioMightMethods) {

		// Run through the argument list and executes the 
		// associated methods
		boolean fired = false;
		System.out.println("PoxVirus-Executing Methods: " + bioMightMethods.size());
		for (int j=0; j<bioMightMethods.size(); j++){
			
			// Get the parameter from the list and if it is not
			// empty execute the associated method using it
			BioMightMethodView bioMightMethod = (BioMightMethodView) bioMightMethods.get(j);
			System.out.println("Have BioMightMethod for PoxVirus: " + bioMightMethod.getMethodName());	
			String methodName = bioMightMethod.getMethodName();
			String canonicalName = bioMightMethod.getCanonicalName(); 
			String dataType = bioMightMethod.getDataType();
			String methodParam = bioMightMethod.getMethodParameter(); 
			if (methodParam == null)
				methodParam = "";
			
			// We only execute those methods that are targeted for the CellMembrane
			// If a parameter is specified then we fire the method, otherwise
			// we just jump over it
			if (canonicalName.equals(Constants.PoxVirus)) {				
				if (!methodParam.equals(""))
				{
					System.out.println("Execute Method " + methodName + " with Signature: "  +  dataType);
					System.out.println("with DataType: "  +  dataType  + "   value: " + methodParam);
					
					fired=true;		
					// Use the DataType parameter to convert the data into its base form
				
					if (dataType.equals(Constants.BIO_INT)) {
						
						try {
							System.out.println("Locating Method(Integer)" + methodName);
							// 	Locate the method through introspection
							int numElements = Integer.parseInt(methodParam);
							Class paramsType[] = {int.class};
							Method method = this.getClass().getDeclaredMethod(methodName, paramsType);
							System.out.println("Before Execute Method(Integer)" + methodName);
							Object result = method.invoke(this, numElements);
							System.out.println("Before Execute Method(Integer)" + methodName);	
						}
						catch (NumberFormatException e)
						{
							System.out.println("Could not Convert to int: " + methodParam);						
						}
						catch (NoSuchMethodException e)
						{
							System.out.println("Method with int param not found: " + e);						
						}	
						catch (Exception e)
						{
							System.out.println("General Exception occurred: " + e);						
						}										
					}
					else if (dataType.equals("double")) {
					
						try {
							System.out.println("Locating Method(Double)" + methodName);
						// Locate the method through introspection
							double numElements = Double.parseDouble(methodParam);
							if (numElements > 0.0)
							{
								Class paramsType[] = {double.class};
								Method method = this.getClass().getDeclaredMethod(methodName, paramsType);
								System.out.println("Before Execute Method(Double)" + methodName);
								Object result = method.invoke(this, numElements);
								System.out.println("Before Execute Method(Double)" + methodName);
							}
							System.out.println("Not Executing Double - 0.0"); 
						
							
						}
							catch (NumberFormatException e)
							{
								System.out.println("Could not Convert to double: " + methodParam);						
							}
							catch (NoSuchMethodException e)
							{
								System.out.println("Method with double param not found: " + e);						
							}	
							catch (Exception e)
							{
								System.out.println("General Exception: " + e);						
							}										
					}
					else if (dataType.equals(Constants.BIO_TEXT)) {
						
						
						try {
							System.out.println("Locating Method(String)");
							
							Class paramsType[] = {String.class};
							Method method = this.getClass().getDeclaredMethod(methodName, paramsType );
							System.out.println("Located Method with StringParam: " + methodName + "   " + methodParam);
							
							System.out.println("Before Execute Method(String)" + methodName);
							Object result = method.invoke(this, methodParam);
							System.out.println("After Execute Method(String)" + methodName);
									
						}
						catch (NoSuchMethodException e)
						{
							System.out.println("Method with String param not found!");						
						}	
						catch (Exception e)
						{
							System.out.println("General Exception: " + e.toString());						
						}	
						
					}
					else if (dataType.equals("")) {
					}			
				}	
			}
			if (fired)
			{	
				System.out.println("Methods have fired.");
				//save();
			}
		}
	}
	
	
	/*****************************************************************************
	 * SET COLOR - Sets the color of the CellMembrane
	 * 
	 * Set the color of the CellMembrane
	 * 
	 *****************************************************************************/
	public void setMembraneColor(String color) {

		int numColor = BioWebUtils.mapColor(color);
		if (numColor > 0)
		{
			try {
				// Get the information from the database via the Enterprise Bean		
				System.out.println("Setting Membrane Color to: " + color + " for: " + parentID);
				InitialContext ctx = new InitialContext();
				BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
				int returnCode = bioMightBean.setMaterial(parentID, numColor);
				System.out.println("Color is set: " + returnCode);   	
			}catch (Exception e) { 
				System.out.println("Exception Setting Cell Membrane Color");
				throw new ServerException("Remote Exception setColor():", e); 	
			}
		}
	}
	

	/*****************************************************************************
	 * SET TEXTURE - Sets the color of the CellMembrane
	 * 
	 * Set the color of the CellMembrane
	 * 
	 *****************************************************************************/
	public void setMembraneTexture(String textureName) {

		System.out.println("Setting Membrane Texture to: " + textureName);
		int textureId = 0;
		for (int i=0; i<textures.size(); i++)	
		{
			BioMightTexture texture = (BioMightTexture) textures.get(i);
			if (textureName.equals(texture.getTextureName()))
				textureId = texture.getTextureId();
		}
		System.out.println("Setting Membrane Texture to ID: " + textureId);
		
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Setting Membrane Texture to: " + textureId + " for: " + parentID);
			InitialContext ctx = new InitialContext();
			BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
			
			int returnCode = bioMightBean.setTexture(parentID, textureId);
			System.out.println("Texture is set: " + returnCode);   	
			
		}catch (Exception e) { 
			System.out.println("Exception Setting Cell Membrane Texture");
			throw new ServerException("Remote Exception Texture():", e); 	
		}

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


		
	
	/**
	 * 
	 *
	 */
	public void onContact(Object obj)
	{
		// PoxVirus Bacteria ferments Mannitol
		if (obj instanceof Mannitol)
		{
		}

		// PoxVirus Bacteria hemolyzes Red Blood Cells
		if (obj instanceof PoxVirus)
		{
		}
		
	}
			
		
}

	