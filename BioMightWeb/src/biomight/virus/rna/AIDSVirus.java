
package biomight.virus.rna;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.ArrayList;

import javax.naming.InitialContext;

import biomight.Constants;
import biomight.bacteria.Bacteria;
import biomight.chemistry.nucleicacid.RNA;
import biomight.chemistry.nucleicacid.nucleotide.Nucleotides;
import biomight.chemistry.pharma.diuretic.Mannitol;
import biomight.ejb.BioMightBeanLocal;
import biomight.exceptions.ServerException;
import biomight.view.BioMightMethodView;
import biomight.view.BioMightOrientation;
import biomight.view.BioMightPosition;
import biomight.view.BioMightPropertyView;
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
import biomight.virus.GlycoProteinSpikes;
import biomightweb.util.BioWebUtils;
import biomightweb.util.BioWebX3DUtils;
import biomightweb.view.BioMightRange;

/*********************************************************************************
 * @author SurferJim
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 ********************************************************************************/

public class AIDSVirus extends BioMightBase {
	
	private String bacteriaName = "AIDSVirus";
	private ArrayList<String> colors;
	private BioMightPosition bioMightPosition;
	private int view = Constants.VIEW_BIRDSEYE; 
	
	//private LethalFactor lethalFactor;
	private Capsid capsid; 
	private GlycoProteinSpikes glycoProteinSpikes;
	private RNA rna;
	

	//private MajorHistocompatibilityComplex mHC;
	//private B7Protein Bb7Protein;
	//private IgM immunoglobinM;
	
	public AIDSVirus()
	{
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, Constants.AIDSVirusRef, null, null);
	}

	public AIDSVirus(String parentID)
	{
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, parentID, null, null);
	}

	public AIDSVirus(int hierarchy, int LOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
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
		this.setImage("images/AIDSVirus.jpg");
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
			System.out.println("In AIDSVirus Create() - ViewInternal - Already Set: " + parentID);				

			// We already have the data for the current instance of AIDSVirus,
			// Go get the details for the current AIDSVirus is LOD is set
			if (localLOD == Constants.MAG2X)
			{
				// Go get the finer details of the AIDSVirus				
				System.out.println("Getting the AIDSVirus MAG2X : " + parentID);
				localVP = Constants.VIEW_INTERNAL; 
				localLOD = Constants.MAG1X;

				capsid = new Capsid(localVP, localLOD, componentID, bioMightProperties, bioMightMethods);
				initProperty(Constants.CapsidRef, Constants.Capsid, Constants.CapsidRef, capsid.getComponentID());
				System.out.println("In AIDSVirus - Capsid is complete");
				
				localVP = Constants.VIEW_DETACHED; 
				localLOD = Constants.MAG2X;
				rna = new RNA(localVP, localLOD, componentID, bioMightProperties, bioMightMethods);
				initProperty(Constants.RNARef, Constants.RNA, Constants.RNARef, rna.getComponentID());
				System.out.println("In AIDSVirus - RNA is complete");
	
				localVP = Constants.VIEW_INTERNAL; 
				localLOD = Constants.MAG1X;
				glycoProteinSpikes = new GlycoProteinSpikes(localVP, localLOD, componentID, bioMightProperties, bioMightMethods);
				initProperty(Constants.GlycoProteinSpikeRef, Constants.GlycoProteinSpike, Constants.GlycoProteinSpikeRef, glycoProteinSpikes.getComponentID());
				System.out.println("In AIDSVirus - GlycoProteinSpike is complete");
				
				
		
				// initialize the Properties
				//initProperty(bioMightTransform.getName(), Constants.AIDSVirus, Constants.AIDSVirusRef, bioMightTransform.getId());
			}
		
		}	
		else if (localVP == Constants.VIEW_DETACHED)			
		{			
			// Generate the Component if needed 
			boolean bGenerate = false;
			if (bGenerate) {
				generate(parentID, componentID);
			}

			// The component is being called from within another component.  We
			// have a parent ID and know what type it is.
			// Get the information from the database via the Enterprise Bean		
			try {
				// Get the information from the database via the Enterprise Bean		
				System.out.println("Getting AIDSVirusInfo DETACHED for ParentID: " + parentID);
				InitialContext ctx = new InitialContext();
				BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
				bioMightTransforms = bioMightBean.getComponents(Constants.AIDSVirusRef, parentID);
				System.out.println("Have AIDSVirus from EJB");   	
			}catch (Exception e) { 
				System.out.println("Exception Getting Components - AIDSVirus");
				throw new ServerException("Remote Exception getComponents():", e); 	
			}
				
			// Run through the collection of Pupils and build them into the model
			// In the default case, we get one instance of the Pupil for each eye
			ArrayList<BioMightTransform> transforms = bioMightTransforms.getTransforms();
			System.out.println("Have AIDSVirus - DETACHED - Transforms : " + transforms.size());
			for (int i=0; i<transforms.size(); i++)
			{	
				// Get the information for the eye we are creating
				BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
				//System.out.println("Creating GlycoProteinSpike: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
				this.componentID = bioMightTransform.getId();
				

				if (localLOD == Constants.MAG1X)
				{
					// initialize the Properties
					initProperties();
				}
				else if (localLOD == Constants.MAG2X)
				{
					// Go get the finer details of the AIDSVirus				
					System.out.println("Creating AIDSVirus at Detached MAG2X : " + parentID);
					localVP = Constants.VIEW_INTERNAL; 
					localLOD = Constants.MAG1X;
					
					capsid = new Capsid(localVP, localLOD, componentID, bioMightProperties, bioMightMethods);
					initProperty(Constants.CapsidRef, Constants.Capsid, Constants.CapsidRef, capsid.getComponentID());
					System.out.println("In AIDSVirus - Capsid is complete");
					
					localVP = Constants.VIEW_DETACHED; 
					localLOD = Constants.MAG2X;
					rna = new RNA(localVP, localLOD, componentID, bioMightProperties, bioMightMethods);
					initProperty(Constants.RNARef, Constants.RNA, Constants.RNARef, rna.getComponentID());
					System.out.println("In AIDSVirus - RNA is complete");
					
					localVP = Constants.VIEW_INTERNAL; 
					localLOD = Constants.MAG1X;
					glycoProteinSpikes = new GlycoProteinSpikes(localVP, localLOD, componentID, bioMightProperties, bioMightMethods);
					initProperty(Constants.GlycoProteinSpikesRef, Constants.GlycoProteinSpikes, Constants.GlycoProteinSpikesRef, glycoProteinSpikes.getComponentID());
					System.out.println("In AIDSVirus - GlycoProteinSpikes are complete");
				}
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
		
			// This is when one is accessing a AIDSVirus directly
			// Get the information from the database via the Enterprise Bean		
			try {
				// Get the information from the database via the Enterprise Bean		
				System.out.println("Getting HawkEye AIDSVirusInfo for ParentID: " + parentID);
				InitialContext ctx = new InitialContext();
				BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
				bioMightTransforms = bioMightBean.getComponent(parentID);
				
				System.out.println("Have AIDSVirus Info from EJB");   	
			}catch (Exception e) { 
				System.out.println("Exception Getting Components - AIDSVirus");
				throw new ServerException("Remote Exception getComponents():", e); 	
			}
				
			// Run through the collection of BacilliAnthracis and build them into the model
			// In the default case, we get one instance of the AIDSVirus for each eye
			ArrayList transforms = bioMightTransforms.getTransforms();
			System.out.println("AIDSVirus NumTransforms: " + transforms.size());
			for (int i=0; i<transforms.size(); i++)
			{
				// Get the information for the AIDSVirus
				BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
				this.setBioMightTransform(bioMightTransform);
				System.out.println("Creating AIDSVirus: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
				this.componentID = bioMightTransform.getId();

		
				if (localLOD == Constants.MAG1X)
				{
					System.out.println("Creating AIDSVirus at HawkEye MAG1X - Just Init Properties: " + parentID);
					// initialize the Properties
					initProperties();
				}
				if (localLOD == Constants.MAG2X)
				{
					// Go get the finer details of the AIDSVirus				
					System.out.println("Creating AIDSVirus at HawkEye MAG2X : " + parentID);
					localVP = Constants.VIEW_INTERNAL; 
					localLOD = Constants.MAG1X;
					
					capsid = new Capsid(localVP, localLOD, componentID, bioMightProperties, bioMightMethods);
					initProperty(Constants.CapsidRef, Constants.Capsid, Constants.CapsidRef, capsid.getComponentID());
					System.out.println("In AIDSVirus - Capsid is complete: " + capsid.getComponentID());
					
					localVP = Constants.VIEW_DETACHED; 
					localLOD = Constants.MAG2X;
					rna = new RNA(localVP, localLOD, componentID, bioMightProperties, bioMightMethods);
					initProperty(Constants.RNARef, Constants.RNA, Constants.RNARef, parentID);
					System.out.println("In AIDSVirus - RNA is complete: " + rna.getComponentID());
					
					localVP = Constants.VIEW_INTERNAL; 
					localLOD = Constants.MAG1X;
					glycoProteinSpikes = new GlycoProteinSpikes(localVP, localLOD, componentID, bioMightProperties, bioMightMethods);
					initProperty(Constants.GlycoProteinSpikesRef, Constants.GlycoProteinSpikes, Constants.GlycoProteinSpikesRef, glycoProteinSpikes.getComponentID());
					System.out.println("In AIDSVirus - GlycoProteinSpikes are complete: " + glycoProteinSpikes.getComponentID());
			
				}
				
			}
		}		
		else
		{
			
		}
			
		initMethods();
		
		System.out.println("CreateAIDSVirus Completed");
		
		// First, get all the data from the database
		// Apply the methods to it
		// Save its state
		this.parentID = parentID;
		if (bioMightMethods != null){
			System.out.println("EXECUTING AIDSVirus Methods: " + bioMightMethods.size());
			//executeMethods(bioMightMethods);
		}
	}
		
	

	public void initMethods() {

		methods = new ArrayList<BioMightMethodView>();
			
		BioMightMethodView method;
		methods = new ArrayList<BioMightMethodView>();
		method = new BioMightMethodView();
		method.setDisplayName("Transcribe");
		method.setMethodName("Transcribe");
		method.setHtmlType("checkbox");
		method.setDataType("boolean");
		methods.add(method);

		method = new BioMightMethodView();
		method.setDisplayName("Penetrate AIDSVirus");
		method.setMethodName("Penetrate AIDSVirus");
		method.setHtmlType("checkbox");
		method.setDataType("boolean");
		methods.add(method);	
			
		method = new BioMightMethodView();
		method.setDisplayName("UnCoat");
		method.setMethodName("UnCoat");
		method.setHtmlType("checkbox");
		method.setDataType("boolean");
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
		// Generate the AIDSVirus		
		BioMightBeanLocal bioMightBean;
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Generating the AIDSVirus : " + componentID + "    " + parentID);
			InitialContext ctx = new InitialContext();
			bioMightBean = (BioMightBeanLocal) ctx.lookup("java:global/BioMightWeb/BioMightBean!biomight.ejb.BioMightBeanLocal");
	
			double radius = 0.125;
					
			// Generate the Palm
			double[] startPos = {3.75,-23.0,-6.0};
			double[][] currentPoints = BioGraphics.octogonXPlane(startPos, radius);
						
			//int success = bioMightBean.generateAIDSVirus("AIDSVirus:00001", "AIDSVirus", 
			//		"AIDSVirus", componentID, parentID, currentPoints);			
			
			System.out.println("Created AIDSVirus Info using EJB");   	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - AIDSVirus");
			throw new ServerException("Remote Exception AIDSVirus():", e); 	
		}
	}
	

	
	/********************************************************************************************************************
	 * GET X3D
	 * 
	 * This method will return the X3D for the AIDSVirus.  It runs through each of its components and collects up their
	 * representations and then assembles them into one unified X3D model.
	 * 
	 ********************************************************************************************************************/
	public String getX3D(boolean snipet) {
		
		// Assemble the AIDSVirus
		String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
		"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n " +
		"<X3D profile='Immersive' >\n" +
		"<head>\n" +
		 "<meta name='BioMightImage' content='AIDSVirus.jpg'/>\n" +
		 "<meta name='ExportTime' content='7:45:30'/>\n" +
		 "<meta name='ExportDate' content='08/15/2008'/>\n" +
		 "<meta name='BioMight Version' content='1.0'/>\n" + 
		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='AIDSVirus'\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		

		String body = "";
		String annotate = "";
		

		System.out.println("Getting X3D for AIDSVirus!!!!!!!!");
 
		
		// Only when the database retrieval has been locally, do we do this??
		if (viewPerspective == Constants.VIEW_INTERNAL) 
		{	
			
			System.out.println("Get X3D AIDSVirus - View Internal");
			// We do nada as the AIDSVirus Data is retrieved in the collection object
			// and the X3D is generated there
			lod = Constants.MAG2X;
			if (lod == Constants.MAG2X)		
			{
				System.out.println("Get X3D AIDSVirus - View Internal - 2X");
				// We are going to get the X3D from the aggregation objects
				// This is really a viral envelope
				body += capsid.getX3D(true); 
				//body += glycoProteinSpikes.getX3D(true); 
				
				ArrayList ranges = new ArrayList();
				BioMightPosition bioMightPosition = new BioMightPosition(0.0, 0, 0);
				BioMightOrientation bioMightOrientation = new BioMightOrientation(0, 0, 1, 90);
		
				double maxWidth = 0.035;
				double maxHeight = 0.3;
		
				BioMightRange bioRange = new BioMightRange(25, 3, 5, 0, 3, 0,  maxWidth, 0, maxHeight);
				ranges.add(bioRange);
		
				maxWidth = 0.035;
				maxHeight = 0.3;
				
				bioMightTransform.setTranslation(bioMightPosition);
				bioMightTransform.setComponentName("Appendage");
				System.out.println("BioMight radius: " + bioMightTransform.getRadius());
			    body+= BioWebX3DUtils.generateAIDSGlycoSpikes(bioMightTransform, bioRange);
			    body+= BioWebX3DUtils.generateAIDSVirusCapsid(bioMightTransform,  bioMightPosition, bioMightOrientation); 		
						    					  	
			}
			else if (lod == Constants.MAG1X)
			{			
				// We went to the database to get data.  There will be 1 Transform record
			
				/*
				System.out.println("Creating AIDSVirus: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
				System.out.println("Creating AIDSVirus at Position: " + 
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
			System.out.println("Get X3D AIDSVirus - View Hawkeye");
			
			//************************************************************888
			//**************************************************************8
			// HACK
			lod = Constants.MAG2X;
			//************************************************************
			//************************************************************

			if (lod == Constants.MAG2X)		
			{
				System.out.println("Get X3D AIDSVirus - View Hawkeye -- 2X");
				//We are going to get the X3D from the aggregation objects
				body += capsid.getX3D(true); 
				
				body += "<Transform onmouseover=\"showComponent('RNA');\" DEF='TRANSFORM_RNAChain"  + "' \n";
			 						
				body +=  "scale='" 
					+ 0.05 + " "
					+ 0.05 + " "
					+ 0.05  + "'>\n";

				body += rna.getX3D(true);
				
				body += "</Transform>";
				
				body += glycoProteinSpikes.getX3D(true); 
			
				ArrayList ranges = new ArrayList();
				BioMightPosition bioMightPosition = new BioMightPosition(0.025, 0, 0);
				BioMightOrientation bioMightOrientation = new BioMightOrientation(0, 0, 1, 90);
		
				double maxWidth = 0.035;
				double maxHeight = 0.3;
		
				BioMightRange bioRange = new BioMightRange(25, 3, 5, 0, 3, 0,  maxWidth, 0, maxHeight);
				ranges.add(bioRange);
		
				maxWidth = 0.035;
				maxHeight = 0.1;
				
				bioMightTransform.setTranslation(bioMightPosition);
				bioMightTransform.setComponentName("Feelers");
				//bioMightTransform.setRadius();
				bioMightTransform.setTextureFile("PowderBlue.png");
				System.out.println("BioMight radius: " + bioMightTransform.getRadius());
			    //body+= BioWebX3DUtils.generateAIDSGlycoSpikes(bioMightTransform, bioRange);		
			    body+= BioWebX3DUtils.generateAIDSVirusCapsid(bioMightTransform,  bioMightPosition, bioMightOrientation); 	
			}
			else
			{			
				// We went to the database to get data.  There will be 1 Transform record
				System.out.println("Get X3D AIDSVirus - View Hawkeye  1X");
			
				ArrayList transforms = bioMightTransforms.getTransforms();
				for (int i=0; i<transforms.size(); i++)
				{
					// Get the information for the capsomer we are creating
					BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
					System.out.println("Creating AIDSVirus: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
					System.out.println("Creating AIDSVirus at Position: " + 
							bioMightTransform.getTranslation().getXPos() + "  " +
							bioMightTransform.getTranslation().getYPos() + "  " +
							bioMightTransform.getTranslation().getZPos());
					

						double xPos = bioMightTransform.getTranslation().getXPos();  
						double yPos = bioMightTransform.getTranslation().getYPos();
						double zPos = bioMightTransform.getTranslation().getZPos();	
						double height =  bioMightTransform.getHeight();
						double radius = bioMightTransform.getRadius();
						
						for (int k=0; k<2; k++) {
								
							yPos = BioWebUtils.randomWithRange(0.0, 1.15*radius);
										
							radius = bioMightTransform.getRadius();
							bioMightTransform.setComponentName("AIDS Virus");
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
		
		
		body+= "<Viewpoint DEF='Viewpoint_AIDSVirus'\n" +
				 "description='Viewpoint1'\n" +
				 "jump='true'\n" +
				 "fieldOfView='0.785'\n" +
				 "position='0.0 0.0 2.0'\n" +
				 "orientation='0 0 1 0'/>\n";
		
		//System.out.println("AIDSVirus X3D: " + body);		
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
		System.out.println("BacillusAntracis-Executing Methods: " + bioMightMethods.size());
		for (int j=0; j<bioMightMethods.size(); j++){
			
			// Get the parameter from the list and if it is not
			// empty execute the associated method using it
			BioMightMethodView bioMightMethod = (BioMightMethodView) bioMightMethods.get(j);
			System.out.println("Have BioMightMethod for AIDSVirus: " + bioMightMethod.getMethodName());	
			String methodName = bioMightMethod.getMethodName();
			String canonicalName = bioMightMethod.getCanonicalName(); 
			String dataType = bioMightMethod.getDataType();
			String methodParam = bioMightMethod.getMethodParameter(); 
			if (methodParam == null)
				methodParam = "";
			
			// We only execute those methods that are targeted for the IRIS
			// If a parameter is specified then we fire the method, otherwise
			// we just jump over it
			if (canonicalName.equals(Constants.AIDSVirus)) {				
				if (!methodParam.equals(""))
				{
					System.out.println("Execute Method " + methodName + " with Signature: "  +  dataType);
					System.out.println("with DataType: "  +  dataType  + "   value: " + methodParam);
					
					fired=true;		
					// Use the DataType parameter to convert the data into its base form
				
					if (dataType.equals("int")) {
						
						try {
							System.out.println("Locating Method(Integer)" + methodName);
							// 	Locate the method through introspection
							int numElements = Integer.parseInt(methodParam);
							Class paramsType[] = {int.class};
							Method method = this.getClass().getDeclaredMethod(methodName, paramsType);
							System.out.println("Before Execute Method(Integer)" + methodName);
							Object result = method.invoke(this, numElements);
							System.out.println("After Execute Method(Integer)" + methodName);	
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
								System.out.println("After Execute Method(Double)" + methodName);
							}
							else
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
					else if (dataType.equals("String")) {
						
						
						try {
							System.out.println("Locating Method(String)");
							
							Class paramsType[] = {String.class};
							Method method = this.getClass().getDeclaredMethod(methodName, paramsType );
							System.out.println("Method with String Param: " + methodName);
							
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
							System.out.println("General Exception: " + e);						
						}	
						
					}
					else if (dataType.equals("")) {
						System.out.println("Data Type not found!!!");	
					}	
				}	
			}
			if (fired)
			{	
				System.out.println("AIDSViruss - Methods have fired.   Calling AIDSViruss Save method!");
			}
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
		// AIDSVirus Bacteria ferments Mannitol
		if (obj instanceof Mannitol)
		{
		}

		// AIDSVirus Bacteria hemolyzes Red Blood Cells
		if (obj instanceof AIDSVirus)
		{
		}
		
	}
			
		
}

	