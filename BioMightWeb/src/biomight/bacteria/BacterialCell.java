/*
 * Created on Jun 5, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.bacteria;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Random;

import javax.naming.InitialContext;



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
import biomight.cell.IonPump;
import biomight.cell.IonPumps;
import biomight.cell.Lysosomes;
import biomight.cell.Melanosome;
import biomight.cell.Mitochondrion;
import biomight.cell.Peroxisomes;
import biomight.cell.Procaryote;
import biomight.cell.Ribosomes;
import biomight.cell.SecretoryVesicle;
import biomight.cell.bloodandimmune.CytotoxicTCell;
import biomight.cell.nucleus.Chromatin;
import biomight.cell.nucleus.Nucleus;
import biomight.chemistry.compound.GlycoCalyx;
import biomight.ejb.BioMightBeanLocal;
import biomight.exceptions.ServerException;
import biomight.view.BioMightMethodView;
import biomight.view.BioMightPosition;
import biomight.view.BioMightPositions;
import biomight.view.BioMightPropertyView;
import biomight.view.BioMightTransform;

/**
 * @author SurferJim
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class BacterialCell extends Procaryote {

	private ArrayList colors;
	
	private BacterialCellWall cellWall;
	private CytoplasmicMembrane cytoplasmicMembrane;
	private Nucleoid nucleoid;
	private Mesosome mesosome;
	private Periplasm periplasm;
	private BacterialRibosomes bacterialRibosomes;
	
	// Optional Components
	private BacterialCapsule bacterialCapsule;
	private Flagellum flagellum;
	private Pilus pilus;
	private Fimbria fimbria;
	private Spore spore;
	private Plasmid plasmid;
	private BacterialGranule bacterialGranule;
	private GlycoCalyx glycoCalyx;

	// Components of Cells
	private CellMembrane cellMembrane;
	private Centrioles centrioles;
	private Chromatin chromatin;
	private Cytoskeleton cytoskeleton;
	private Cytosol cytosol;
	private EndoPlasmicReticulum  endoPlasmicReticulum;
	private GolgiApparatus golgiApparatus;
	private Lysosomes lysosomes;
	private Mitochondrion mitochondrian;
	private Nucleus nucleus;
	private Endosomes endosomes; 
	private Peroxisomes peroxisomes; 
	private SecretoryVesicle secretoryVesicle;
	private IonPump ionPump;
	private IonPumps ionPumps;
	private Melanosome melanosome;
	private IonChannel ionChannel;
	private IonChannels ionChannels;
	private Ribosomes ribosomes;
	
	private BigDecimal surfaceCharge;
	private BigDecimal setContactInhibition;
	private BigDecimal osmoticPressure;
	private BigDecimal cytosolVolume;
	private BigDecimal cellDiameter;
	private BigDecimal cellMembraneWidth;
	private int numIonChannels;
	private int numIonPumps;
	private int numLysosomes;
	private int numMitochondrian;
	private int numRibosomes;
	private int numEndosomes;
	private int numVoltageGatedPotassiumChannels;
	private int numVoltageGatedSodiumChannels;
	private int numVoltageGatedCalciumChannels;
	
	
	/************************************************************************
	 * BACTERIAL CELL Constructor 
	 *
	 ***********************************************************************/
	public BacterialCell()
	{
		create("0",null);
	}

	/************************************************************************
	 * BACTERIAL CELL Constructor 
	 *
	 ***********************************************************************/
	public BacterialCell(String parentID)
	{
		System.out.print("Calling parameterized CELL Constructor!");
		create(parentID, null);
	}
	
	
	/************************************************************************
	 * BACTERIAL CELL Constructor 
	 *
	 ***********************************************************************/
	public BacterialCell(String parentID, ArrayList<BioMightMethodView> bioMightMethods)
	{
		System.out.print("Calling CELL with MethodParams!");
		create(parentID, bioMightMethods);
	}
	
	
	/************************************************************************
	 * Create BACTERIAL CELL
	 *
	 ***********************************************************************/

	public void create(String parentID, ArrayList<BioMightMethodView> bioMightMethods)
	{
		this.setImage("images/BacterialCell.jpg");
		
		System.out.println("Creating BacterialCell for: " + parentID);
						
		// Get the data for the Cell that is defined for this 
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Getting BacterialCellInfo for ParentID: " + parentID);
			InitialContext ctx = new InitialContext();
			BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
			bioMightTransforms = bioMightBean.getComponents(Constants.BacterialCellRef, parentID);
			System.out.println("Have BacterialCell Info from EJB");   	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - BacterialCell");
			throw new ServerException("Remote Exception getComponents():", e); 	
		}

		// If we have initialization parameters from the form, 
		//  then apply them before constructing the objects.
		if (bioMightMethods != null){
			System.out.println("NEED TO EXECUTE CELL METHODS: " + bioMightMethods.size());
			//executeMethods(bioMightMethods);
		}
		
		// Run through the collection of Bodys and build them into the model
		// In the default case, we get one instance of the Body for each eye
		ArrayList transforms = bioMightTransforms.getTransforms();
		System.out.println("Have BacterialCell NumTransforms: " + transforms.size());

		// Run through the body instances and build the bodies.
		// The model should be able to support siamese twins whereas the 
		// bodies are conjoined.
		for (int i=0; i<transforms.size(); i++)
		{
			// Get the information for the eye we are creating
			BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
		
			//componentID = bioMightTransform.getId();
			//System.out.println("Creating Body - Setting ComponentID: " + componentID);
			
			System.out.println("Creating BacterialCell: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
			System.out.println("Creating BacterialCell at Position: " + bioMightTransform.getTranslation().getXPos() + ",  " + 
					bioMightTransform.getTranslation().getYPos() + ",  " +
					bioMightTransform.getTranslation().getZPos());
					
			System.out.println("In BacterialCell - Creating BacterialCellWall");
			cellWall = new BacterialCellWall(bioMightTransform.getId(), bioMightMethods);
			System.out.println("In BacterialCell - Cell Membrane is complete");
			//initProperty("CellMembrane", Constants.CellMembrane, Constants.CellRef, cellMembrane.getComponentID());
	
			
			// Set up the cytoskeleton.  This will fill the space of cell membrane
			// in between the various organelles
			//cytoskeleton  = new Cytoskeleton();
			//initProperty("Cytosol", Constants.Cytosol, Constants.Cytosol, cytosol.getComponentID());
			
			// Create the Cytosol mix
			//cytosol  = new Cytosol(bioMightTransform.getId(), bioMightMethods);
			//System.out.println("Cytosol is created...");
			
			// Set up the position for the EndoPlasmic Reticulum		
			//BioMightPosition erPosition = new BioMightPosition();
			//erPosition.setXPos(-2.114);
			//erPosition.setYPos(-.744);
			//erPosition.setZPos(6.044);
			//endoPlasmicReticulum  = new EndoPlasmicReticulum(erPosition);
			//System.out.println("ER is created...");
			

			// Set up the position for the EndoPlasmic Reticulum		
			//BioMightPosition golgiPosition = new BioMightPosition();
			//golgiPosition.setXPos(-0.2);
			//golgiPosition.setYPos(-.2);
			//golgiPosition.setZPos(4.);
			//golgiApparatus  = new GolgiApparatus(golgiPosition);
			//System.out.println("Golgi Apparatus is created...");
			
			// Figure out where we can stuff the lysosomes into the cell
			// Create the lysosomes with provided d-map	
			//BioMightPositions lysoPositions = getDistributionMap(8);	
			//lysosomes  = new Lysosomes(8, lysoPositions);
			//System.out.println("Lysosomes are created...");
		
			// Create the Nuclueas
			//nucleus  = new Nucleus();
			
			// Figure out where we can stuff the endosomes into the cell
			// Create the endosomes with provided d-map	
			//BioMightPositions centPositions = getDistributionMap(9);	
			//centrioles  = new Centrioles(9, centPositions);
			//System.out.println("Centrioles are created...");

			// Figure out where we can stuff the endosomes into the cell
			// Create the endosomes with provided d-map	
			//BioMightPositions peroPositions = getDistributionMap(7);	
			//peroxisomes  = new Peroxisomes(7, peroPositions);
			//System.out.println("Peroxisomes are created...");
				
			//secretoryVesicle  = new SecretoryVesicle();
			
			// Figure out where we can stuff the endosomes into the cell
			// Create the endosomes with provided d-map	
			//BioMightPositions endoPositions = getDistributionMap(5);	
			//endosomes  = new Endosomes(5, endoPositions);
			//System.out.println("Endosomes are created...");

			// Create a collection of ION pumps that are distributed
			// across the surface of the cell
			//BioMightPositions pumpPositions = getDistributionMap(10);	
			//ionPumps  = new IonPumps(10, pumpPositions);
			//System.out.println("Ion Pumps are created...");
			
			//melanosome  = new Melanosome();

			// Create a collection of ION pumps that are distributed
			// across the surface of the cell
			//BioMightPositions channelPositions = getDistributionMap(5);	
			//ionChannels  = new IonChannels(5, channelPositions);
			//System.out.println("Ion Channels are created...");
			
			// Figure out where we can stuff the endosomes into the cell
			// Create the endosomes with provided d-map	
			//BioMightPositions riboPositions = getDistributionMap(5);	
			//ribosomes  = new Ribosomes(5, riboPositions);
			//System.out.println("Ribosomes are created...");
			
			// Figure out where we can stuff the endosomes into the cell
			// Create the endosomes with provided d-map	
			//BioMightPositions mitoPositions = getDistributionMap(3);	
			//mitochondrian  = new Mitochondrian(3, mitoPositions);
			//System.out.println("Mitochondria are created...");
			
		}
		initProperties();
		initMethods();
		System.out.println("Created BacterialCell");				
	}


	public void initProperties() {
		
		BioMightPropertyView property = new BioMightPropertyView();
		property.setPropertyName("CellMembrane");
		property.setCanonicalName(Constants.CellMembrane);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("Centrioles");
		property.setCanonicalName(Constants.Centriole);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("Chromatin");
		property.setCanonicalName(Constants.Chromatin);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("Cytoskeleton");
		property.setCanonicalName(Constants.Cytoskeleton);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("Cytosol");
		property.setCanonicalName(Constants.Cytosol);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("EndoPlasmicReticulumRough");
		property.setCanonicalName(Constants.EndoPlasmicReticulumRough);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("EndoPlasmicReticulumSmooth");
		property.setCanonicalName(Constants.EndoPlasmicReticulumSmooth);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("GolgiApparatus");
		property.setCanonicalName(Constants.GolgiApparatus);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("Lysosomes");
		property.setCanonicalName(Constants.Lysosomes);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("Nucleus");
		property.setCanonicalName(Constants.Nucleus);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("Endosomes");
		property.setCanonicalName(Constants.Endosomes);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("Peroxisomes");
		property.setCanonicalName(Constants.Peroxisomes);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("SecretoryVesicle");
		property.setCanonicalName(Constants.SecretoryVesicle);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("Ion Pumps");
		property.setCanonicalName(Constants.IonPumps);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("Melanosomes");
		property.setCanonicalName(Constants.Melanosomes);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("Ion Channels");
		property.setCanonicalName(Constants.IonChannels);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("Ribosomes");
		property.setCanonicalName(Constants.Ribosomes);
		properties.add(property);
	}
	
	
	public void initMethods() {
		BioMightMethodView method;
		methods = new ArrayList<BioMightMethodView>();
		method = new BioMightMethodView();
		method.setDisplayName("Transcribe");
		method.setMethodName("Transcribe");
		method.setHtmlType("checkbox");
		method.setDataType("boolean");
		methods.add(method);

		method = new BioMightMethodView();
		method.setDisplayName("Lyse");
		method.setMethodName("Lyse");
		method.setHtmlType("checkbox");
		method.setDataType("boolean");
		methods.add(method);

		method = new BioMightMethodView();
		method.setDisplayName("Reproduce");
		method.setMethodName("Reproduce");
		method.setHtmlType("checkbox");
		method.setDataType("boolean");
		methods.add(method);

		method = new BioMightMethodView();
		method.setDisplayName("Surface Charge:");
		method.setMethodName("SurfaceCharge");
		method.setHtmlType("text");
		method.setDataType("double");
		methods.add(method);		
		
		method = new BioMightMethodView();
		method.setDisplayName("Contact Inhibition:");
		method.setMethodName("ContactInhibition");
		method.setHtmlType("text");
		method.setDataType("double");
		methods.add(method);

		method = new BioMightMethodView();
		method.setDisplayName("Osmotic Pressure:");
		method.setMethodName("OsmoticPressure");
		method.setHtmlType("text");
		method.setDataType("double");
		methods.add(method);

		method = new BioMightMethodView();
		method.setDisplayName("Cell Diameter:");
		method.setMethodName("Cell Diameter");
		method.setHtmlType("text");
		method.setDataType("double");
		methods.add(method);

		method = new BioMightMethodView();
		method.setDisplayName("Number Mitochondria:");
		method.setMethodName("setMitochondria");
		method.setHtmlType("text");
		method.setDataType("int");
		methods.add(method);
		
		method = new BioMightMethodView();
		method.setDisplayName("Number Ribosomes:");
		method.setMethodName("setRibosomes");
		method.setHtmlType("text");
		method.setDataType("int");
		methods.add(method);

		method = new BioMightMethodView();
		method.setDisplayName("Number Endosomes:");
		method.setCanonicalName("setNumEndosomes");
		method.setMethodName("setNumEndosomes");
		method.setHtmlType("text");
		method.setDataType("int");
		methods.add(method);
		
		method = new BioMightMethodView();
		method.setDisplayName("Number Lysosomes:");
		method.setMethodName("setLysosomes");
		method.setHtmlType("text");
		method.setDataType("int");
		methods.add(method);
				
		method = new BioMightMethodView();
		method.setDisplayName("Number Ion Channels:");
		method.setMethodName("setIonChannels");
		method.setHtmlType("text");
		method.setDataType("int");
		methods.add(method);

		method = new BioMightMethodView();
		method.setDisplayName("Number Ion Pumps:");
		method.setMethodName("setIonPumps");
		method.setHtmlType("text");
		method.setDataType("int");
		methods.add(method);
	}

	/******************************************************************************************
	 * EXECUTE METHODS 
	 *
	 ******************************************************************************************/
	public void executeMethods(ArrayList<String> methodParams) {

		// Run through the argument list and executes the 
		// associated methods
		System.out.println("Cell-Executing Methods");
		for (int j=0; j<methodParams.size(); j++){
			
			// Get the parameter from the list and if it is not
			// empty execute the associated method using it
			String methodParam = methodParams.get(j);
			if (methodParam != null) {
				if (!methodParam.equals("")) {

					String methodName = (String) methods.get(j).getMethodName(); 
					String htmlType = (String) methods.get(j).getHtmlType();
					String dataType = (String) methods.get(j).getDataType();
					System.out.println("Method " + methodName + " Arg: "  +  methodParam);
					System.out.println("HtmlType " + htmlType + " with DataType: "  +  dataType);
										
					// Use the DataType parameter to convert the data into its base form
					if (dataType.equals("int")) {
						
						try {
							System.out.println("Converting to int ");
							int numElements = Integer.parseInt(methodParam);
							Class paramsType[] = {int.class};
							Method method = this.getClass().getDeclaredMethod(methodName, paramsType);
							System.out.println("Method with Int Param: " + method.getName());

							Object result = method.invoke(this, numElements);
							System.out.println("Method has been invoked!");
							
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
					else if (dataType.equals("String")) {
						/*
						try {
							System.out.println("Converting to String" + methodName);
							Class params[] = (String.class};
							Method method = this.getClass().getDeclaredMethod(methodName, params);
							System.out.println("Method with String Param: " + method.getName());
							// String result = (String) method.invoke(bioMightClass, params);
							// System.out.println("Result is " + result);				
							//Class bioMightClass = Class.forName(currentObject);
						}
						catch (NoSuchMethodException e)
						{
							System.out.println("Method with int param not found: " + methodName);						
						}
						*/	
					}
					else if (dataType.equals("double")) {
						
					}
					else if (dataType.equals("")) {
						
					}
					else if (dataType.equals("")) {
						
					}				
				}
			}
		}
	}
	
	
	/********************************************************************************************************************
	 * GET X3D
	 * 
	 * This method will return the X3D for the Cell.  It runs through each of its components and collects up their
	 * representations and then assembles them into one unified X3D model.
	 * 
	 ********************************************************************************************************************/
	public String getX3D(boolean snipet) {
		
		// Assembe the Cell
		String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
		"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n " +
		"<X3D profile='Immersive' >\n" +
		"<head>\n" +
		 "<meta name='BioMightImage' content='Cell.jpg'/>\n" +
		 "<meta name='ExportTime' content='7:45:30'/>\n" +
		 "<meta name='ExportDate' content='08/15/2008'/>\n" +
		 "<meta name='BioMight Version' content='1.0'/>\n" + 
		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='Cell'\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		
		
		
		String body = cellWall.getX3D(true);
		
		/*
		//cytoskeleton.getX3D() + 
		cytosol.getX3D(true) +
		endoPlasmicReticulum.getX3D(true) +
		golgiApparatus.getX3D(true) +
		lysosomes.getX3D(true) +
		mitochondrian.getX3D(true) +
		nucleus.getX3D(true) +
		centrioles.getX3D(true) +
		peroxisomes.getX3D() +
		//secretoryVesicle.getX3D() +
		endosomes.getX3D(true) +
		ionPumps.getX3D(true) +
		//melanosome.getX3D() +
		ionChannels.getX3D() +
		ribosomes.getX3D(true);
		System.out.println("Have Cell X3D: " + body);		
		*/
		
		String footer = "</Scene>" + "</X3D>\n";
		
		if (snipet)
			return body;			
		else	
			return header + body + footer;
	}



	
	/********************************************************************************************
	 * GET DISTRIBUTION MAP
	 * 
	 *	Create a distribution of endosomes given the confines of the cell wall, 
	 *	taking into consideration of the other cellular stuctures present.  
	 *	We need to look at all like size objects in the cell and get their 
	 *	bounding boxes.  Then we place the endosomes bounding boxes in between
	 *	using a random distribution pattern
	 *******************************************************************************************/
	
	public BioMightPositions getDistributionMap(int numElements) {
	
		BioMightPositions bioMightPositions = new BioMightPositions();

		Random myRandomGen = new Random();
		double xPos = 0.0;
		double yPos = 0.0;
		double zPos = 0.0;
				
		//cellMembrane.getBoundingBox();
		for (int i=0; i<numElements; i++)
		{	
			xPos = (myRandomGen.nextDouble() * 10)/1.5;
			yPos = (myRandomGen.nextDouble() * 10)/2;
			zPos = (myRandomGen.nextDouble() * 10)/3;

			if (i>3)
				xPos = xPos * -1;
			
			// Calculate all the open spaces in the Cell where the
			// endosomes bounding box will fit and store them
			// Randomly select spaces from the set of possibilities
			BioMightPosition bioMightPosition = new BioMightPosition();
			bioMightPosition.setXPos(xPos);
			bioMightPosition.setYPos(yPos);
			bioMightPosition.setZPos(zPos);
			bioMightPositions.setBioMightPosition(i, bioMightPosition);
			//System.out.println("Storing Distribution Map: " + i);
		}
		
		
		return bioMightPositions;
	}

	
	/*******************************************************************************
	 *	SET ENDOSOMES
	 *
	 *	This method will call upon the Endosomes object to create
	 *	a collection of endosomes.
	 * 
	 * @param numEndosomes
	 *******************************************************************************/
	public void setNumEndosomes(int numEndosomes) {
		System.out.println("Setting the number of endosomes");
		this.numEndosomes = numEndosomes;
		
		// Figure out where we can stuff the endosomes into the cell
		BioMightPositions positions = getDistributionMap(numEndosomes);
		
		// Create a collection of endosomes and
		// distribute them throughout the cell
		//endosomes.setEndosomes(numEndosomes, positions);		

		System.out.println("Set the number of endosomes");
	}	
	
	
	
	/**
	 * This method is activated when another BioMight object makes contact
	 * with another object that is representative in size.  
	 */	
	public void onContact(Object obj)
	{	
		if (obj instanceof CytotoxicTCell)
		{
			// Cytotoxic T Cells will interact strongly
			// if the cell is virus infected.	
		}
	}
	

	
	public void Conjugation()
	{}

	public void Transduction()
	{}
	
	public void Transformation()
	{}
	
	public void HomologousRecombination()
	{}
	
	public void NonHomologousRecombination()
	{}

	public void Invade()
	{}
	
	
	public void setOsmoticPressure()
	{
	}
	
	public void onContact()
	{
		
		// It is contacted by a Macrophase
		
		
		// It has connected to a 
		
	}
	
	
	public void die()
	{
	}
	
}
