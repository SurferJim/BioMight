
package biomight.cell.bloodandimmune;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.ArrayList;

import javax.naming.InitialContext;

import biomight.Constants;
import biomight.bacteria.Bacteria;
import biomight.cell.bloodandimmune.AnimalCell;
import biomight.chemistry.pharma.diuretic.Mannitol;
import biomight.ejb.BioMightBeanLocal;
import biomight.exceptions.ServerException;
import biomight.view.BioMightMethodView;
import biomight.view.BioMightOrientation;
import biomight.view.BioMightPosition;
import biomight.view.BioMightPropertyView;
import biomight.view.BioMightScale;
import biomight.view.BioMightTransform;
import biomight.view.BioMightTransforms;

import javax.naming.InitialContext;

import biomight.BioMightBase;
import biomight.Constants;
import biomight.bacteria.Bacteria;
import biomight.bacteria.BacterialCellWall;
import biomight.bacteria.BacterialGranule;
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
import biomight.cell.bloodandimmune.AnimalCell;
import biomight.cell.nucleus.Chromatin;
import biomight.cell.nucleus.Nuclei;
import biomight.chemistry.aminoacid.GlutamicAcid;
import biomight.chemistry.pharma.diuretic.Mannitol;
import biomight.ejb.BioMightBeanLocal;
import biomight.exceptions.ServerException;
import biomight.util.BioGraphics;
import biomight.view.BioMightMethodView;
import biomight.view.BioMightPosition;
import biomight.view.BioMightPropertyView;
import biomight.view.BioMightTransform;
import biomightweb.util.BioWebUtils;
import biomightweb.util.BioWebX3DUtils;
import biomightweb.view.BioMightRange;

/*********************************************************************************
 * @author SurferJim
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 ********************************************************************************/

public class AnimalCell extends BioMightBase {
	
	private String bacteriaName = "AnimalCell";
	private ArrayList colors;
	private BioMightPosition bioMightPosition;
	private int view = Constants.VIEW_BIRDSEYE; 
	
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




	//private MajorHistocompatibilityComplex mHC;
	//private B7Protein Bb7Protein;
	//private IgM immunoglobinM;
	
	public AnimalCell()
	{
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, Constants.AnimalCellRef, null, null);
	}

	public AnimalCell(String parentID)
	{
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, parentID, null, null);
	}

	public AnimalCell(int hierarchy, int LOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
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
			System.out.println("In AnimalCell Create() - ViewInternal - Already Set: " + parentID);				
			
			// We already have the data for the current instance of AnimalCell,
			// Go get the details for the current AnimalCell is LOD is set
			if (localLOD == Constants.MAG2X)
			{
				// Go get the finer details of the AnimalCell				
				System.out.println("Getting the AnimalCell MAG2X : " + parentID);
			
				localVP = Constants.VIEW_INTERNAL; 
				localLOD = Constants.MAG1X;
				System.out.println("In AnimalCell - ViewInternal - Creating CellMembrane : " + parentID + "  " + parentID);
				cellMembrane = new CellMembrane(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);
				initProperty(Constants.CellMembraneRef, Constants.CellMembrane, Constants.CellMembraneRef, cellMembrane.getComponentID());
				System.out.println("In AnimalCell - CellMembrane is complete");
				
				localVP = Constants.VIEW_HAWKEYE; 
				localLOD = Constants.MAG1X;
					
				//System.out.println("In AnimalCell - Creating Endosomes");
				endosomes = new Endosomes(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);
				initProperty(Constants.EndosomesRef, Constants.Endosomes, Constants.EndosomesRef, endosomes.getComponentID());
				System.out.println("In AnimalCell - Endosomes is complete");

				System.out.println("In AnimalCell - Creating Lysosome");
				lysosomes = new Lysosomes(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);
				initProperty(Constants.LysosomesRef, Constants.Lysosomes, Constants.LysosomesRef, lysosomes.getComponentID());
				System.out.println("In AnimalCell - Lysosomes are complete");
			
				System.out.println("In AnimalCell - Creating Peroxisomes");
				peroxisomes = new Peroxisomes(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);
				initProperty(Constants.PeroxisomesRef, Constants.Peroxisomes, Constants.PeroxisomesRef, peroxisomes.getComponentID());
				System.out.println("In AnimalCell - Peroxisomes are complete");

				System.out.println("In Cell - Creating Nuclei");
				nuclei = new Nuclei(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);
				initProperty(Constants.NucleiRef, Constants.Nuclei, Constants.NucleiRef, nuclei.getComponentID());
				System.out.println("In AnimalCell - Nuclei are complete");
											
				System.out.println("In AnimalCell - Creating Mitochondria");
				mitochondria = new Mitochondria(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);
				initProperty(Constants.MitochondriaRef, Constants.Mitochondria, Constants.MitochondriaRef, mitochondria.getComponentID());
				System.out.println("In AnimalCell - Nucleus is complete");

				System.out.println("In AnimalCell - Creating Ribosomes");
				ribosomes = new Ribosomes(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);
				initProperty(Constants.RibosomesRef, Constants.Ribosomes, Constants.RibosomesRef, ribosomes.getComponentID());
				System.out.println("In AnimalCell - Ribosomes are complete");
					
				// initialize the Properties
				//initProperty(bioMightTransform.getName(), Constants.AnimalCell, Constants.AnimalCellRef, bioMightTransform.getId());
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
				
			BioMightScale bioScale = new BioMightScale("0.00, 0.00, 0.00");
			BioMightPosition bioPos = new BioMightPosition("0.00, 0.00, 0.00");	
			String bioTemplate =""; 

			// Run through the collection of BacilliAnthracis and build them into the model
			// In the default case, we get one instance of the AnimalCell for each eye
			ArrayList transforms = bioMightTransforms.getTransforms();
			System.out.println("AnimalCell NumTransforms: " + transforms.size());
			for (int i=0; i<transforms.size(); i++)
			{
				// Get the information for the AnimalCell
				BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
				this.setBioMightTransform(bioMightTransform);
				System.out.println("Creating AnimalCell: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
				this.componentID = bioMightTransform.getId();

		
				if (localLOD == Constants.MAG1X)
				{
					System.out.println("Creating AnimalCell at HawkEye MAG1X - Just Init Properties: " + parentID);
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

					//System.out.println("In AnimalCell - Creating IonPumps");
					//ionPumps = new IonPumps(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
					//initProperty(Constants.IonPumpsRef, Constants.IonPumps, Constants.IonPumpsRef, ionPumps.getComponentID());
					//System.out.println("In AnimalCell - IonPumps are complete");

					System.out.println("In AnimalCell - Creating Lysosome");
					lysosomes = new Lysosomes(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
					initProperty(Constants.LysosomesRef, Constants.Lysosomes, Constants.LysosomesRef, lysosomes.getComponentID());
					System.out.println("In AnimalCell - Lysosomes are complete");
				
					System.out.println("In AnimalCell - Creating Peroxisomes");
					peroxisomes = new Peroxisomes(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
					initProperty(Constants.PeroxisomesRef, Constants.Peroxisomes, Constants.PeroxisomesRef, peroxisomes.getComponentID());
					System.out.println("In AnimalCell - Peroxisomes are complete");

					System.out.println("In Cell - Creating Nuclei");
					nuclei = new Nuclei(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
					initProperty(Constants.NucleiRef, Constants.Nuclei, Constants.NucleiRef, nuclei.getComponentID());
					System.out.println("In AnimalCell - Nuclei are complete");
												
					System.out.println("In AnimalCell - Creating Mitochondria");
					mitochondria = new Mitochondria(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
					initProperty(Constants.MitochondriaRef, Constants.Mitochondria, Constants.MitochondriaRef, mitochondria.getComponentID());
					System.out.println("In AnimalCell - Nucleus is complete");
	
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
							
					/*
					localVP = Constants.VIEW_HAWKEYE; 
					localLOD = Constants.MAG1X;
					
					System.out.println("Creating Fimbriae: " + parentID);
					fimbriae = new Fimbriae(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
					initProperty(Constants.FimbriaeRef, Constants.Fimbriae, Constants.FimbriaeRef, fimbriae.getComponentID());
					System.out.println("In AnimalCell - Fimbriae is complete");
				
					System.out.println("Creating Mesosomes: " + parentID);
					mesosomes = new Mesosomes(localVP, localLOD, componentID, bioMightProperties, bioMightMethods);
					initProperty(Constants.MesosomesRef, Constants.Mesosomes, Constants.MesosomesRef, mesosomes.getComponentID());
					System.out.println("In Mesosome - Mesosome is complete");
	
					// Make this a collection of a few flagella components
					System.out.println("Creating Flagella: " + parentID);
					flagella = new Flagella(localVP, localLOD, componentID, bioMightProperties, bioMightMethods);
					initProperty(Constants.FlagellaRef, Constants.Flagella, Constants.FlagellaRef, fimbriae.getComponentID());
					System.out.println("In AnimalCell - Flagella is complete");
	
					System.out.println("Creating Ribosomes: " + parentID);
					ribosomes = new Ribosomes(localVP, localLOD, componentID, bioMightProperties, bioMightMethods);
					initProperty(Constants.RibosomesRef, Constants.Ribosomes, Constants.RibosomesRef, ribosomes.getComponentID());
					System.out.println("In AnimalCell - Ribosomes are complete");
					*/
					
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
		method.setDisplayName("Penetrate AnimalCell");
		method.setMethodName("Penetrate AnimalCell");
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
		// Generate the AnimalCell		
		BioMightBeanLocal bioMightBean;
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Generating the AnimalCell : " + componentID + "    " + parentID);
			InitialContext ctx = new InitialContext();
			bioMightBean = (BioMightBeanLocal) ctx.lookup("java:global/BioMightWeb/BioMightBean!biomight.ejb.BioMightBeanLocal");
	
			double radius = 0.125;
					
			// Generate the Palm
			double[] startPos = {3.75,-23.0,-6.0};
			double[][] currentPoints = BioGraphics.octogonXPlane(startPos, radius);
						
			//int success = bioMightBean.generateAnimalCell("AnimalCell:00001", "AnimalCell", 
			//		"AnimalCell", componentID, parentID, currentPoints);			
			
			System.out.println("Created AnimalCell Info using EJB");   	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - AnimalCell");
			throw new ServerException("Remote Exception AnimalCell():", e); 	
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
		
		// Assemble the AnimalCell
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
		

		System.out.println("Getting X3D for AnimalCell");
 
		
		// Only when the database retrieval has been locally, do we do this??
		if (viewPerspective == Constants.VIEW_INTERNAL) 
		{	
			
			System.out.println("Get X3D AnimalCell - View Internal");
			// We do nada as the AnimalCell Data is retrieved in the collection object
			// and the X3D is generated there
			lod = Constants.MAG2X;
			if (lod == Constants.MAG2X)		
			{
				
				System.out.println("Getting AnimalCell X3D for MAG2X");
				
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

				
				System.out.println("GENERATE GOLGI: " + bioMightOrientation.getXAxis() + "  " + bioMightOrientation.getYAxis()  + "  " + bioMightOrientation.getZAxis()  + "  " + bioMightOrientation.getDegrees() );
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
					lysosomes.getX3D(true) +
					peroxisomes.getX3D(true) +
					ribosomes.getX3D(true) +
					mitochondria.getX3D(true) +
					nuclei.getX3D(true);
						
				//ionPumps.getX3D(true);
				//golgiApparatus.getX3D(true) +	
				//endoPlasmicReticulum.getX3D(true) +				
			}
			else if (lod == Constants.MAG1X)
			{			
				// We went to the database to get data.  There will be 1 Transform record
			
				/*
				System.out.println("Creating AnimalCell: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
				System.out.println("Creating AnimalCell at Position: " + 
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
				*/
			}
		
		}
		else if (viewPerspective == Constants.VIEW_HAWKEYE) 
		{
			System.out.println("Get X3D AnimalCell - View Hawkeye");
			
			//************************************************************888
			//**************************************************************8
			// HACK
			lod = Constants.MAG2X;
			//************************************************************
			//************************************************************

			if (lod == Constants.MAG2X)		
			{
				System.out.println("Get X3D AnimalCell - View Hawkeye -- 2X");
				//We are going to get the X3D from the aggregation objects
				body += cellMembrane.getX3D(true);
				
				
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
				bioMightTransform.setTextureFile("PowderBlue.png");
				double nucleurRadius = bioMightTransform.getRadius()/4;
				bioMightTransform.setRadius(nucleurRadius);
			    //body += BioWebX3DUtils.generateSphereIrregular(bioMightTransform,  new double[] {bioMightPosition.getXPos(), bioMightPosition.getYPos(), bioMightPosition.getZPos()}, ranges);	
				
			    ranges = new ArrayList();
				bioRange = new BioMightRange(25, 3, 5, 11, 14, 0,  maxWidth, 0, maxHeight);
				ranges.add(bioRange);
			    
			  	body += BioWebX3DUtils.generateLymphocyte(bioMightTransform,  bioMightPosition, bioMightOrientation); 	

			}
			else
			{			
				// We went to the database to get data.  There will be 1 Transform record
				System.out.println("Get X3D AnimalCell - View Hawkeye  1X");
			
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
					

						double xPos = bioMightTransform.getTranslation().getXPos();  
						double yPos = bioMightTransform.getTranslation().getYPos();
						double zPos = bioMightTransform.getTranslation().getZPos();	
						double height =  bioMightTransform.getHeight();
						double radius = bioMightTransform.getRadius();
						
						for (int k=0; k<2; k++) {
								
							yPos = BioWebUtils.randomWithRange(0.0, 1.15*radius);
										
							//*************************************
							// Create the Body out of Cylinder
							//*************************************
							body += "<Transform DEF='TRANSFORM_BACTBODY" + bioMightTransform.getId() + "' \n";
								
							// Let's compute 
								
						 	body += "translation='" 
								+ xPos + " " 
			 					+ yPos + " "
			 					+ bioMightTransform.getTranslation().getZPos() + "'\n";					
							
			 					
							body +=  "scale='" 	+ bioMightTransform.getScale().getXPos() + " "
							 				+ bioMightTransform.getScale().getYPos() + " "
							 				+ bioMightTransform.getScale().getZPos() + "'>\n" +
							 	"<Shape DEF='SHAPE_" + bioMightTransform.getId() + "' \n" +
							    " containerField='children'>\n" +
							    " <Appearance\n" +
							    "  containerField='appearance'>\n";
			
					
							body+= " <ImageTexture containerField='texture' " +
							    " url='../images/SpeckledPink.png'/>";  
							

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
							 	"radius='" + (bioMightTransform.getRadius()) +"'/>\n" +
							 	"</Shape>\n" +
							 	
								"\n<TouchSensor DEF='TSENSOR_" + bioMightTransform.getId() + "' \n" +
				                   " description='AnimalCell'\n" +
					               " containerField='children'/> \n" +
				
							 "</Transform>\n";
											
							
							xPos = xPos + (radius*1.5);
						}
				}
				
			}
		}
		else 
		{			
			// Issue
		}	
		
		
		body+= "<Viewpoint DEF='Viewpoint_Basoophil'\n" +
				 "description='Viewpoint1'\n" +
				 "jump='true'\n" +
				 "fieldOfView='0.785'\n" +
				 "position='0.0 0.0 3.0'\n" +
				 "orientation='0 0 1 0'/>\n";
		
		//System.out.println("AnimalCell X3D: " + body);		
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
			System.out.println("Have BioMightMethod for AnimalCell: " + bioMightMethod.getMethodName());	
			String methodName = bioMightMethod.getMethodName();
			String canonicalName = bioMightMethod.getCanonicalName(); 
			String dataType = bioMightMethod.getDataType();
			String methodParam = bioMightMethod.getMethodParameter(); 
			if (methodParam == null)
				methodParam = "";
			
			// We only execute those methods that are targeted for the IRIS
			// If a parameter is specified then we fire the method, otherwise
			// we just jump over it
			if (canonicalName.equals(Constants.AnimalCell)) {				
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
				System.out.println("AnimalCells - Methods have fired.   Calling AnimalCells Save method!");
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
		// AnimalCell Bacteria ferments Mannitol
		if (obj instanceof Mannitol)
		{
		}

		// AnimalCell Bacteria hemolyzes Red Blood Cells
		if (obj instanceof AnimalCell)
		{
		}
		
	}
			
		
}

	