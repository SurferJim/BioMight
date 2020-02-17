
package biomight.bacteria.cocci.grampositive;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.ArrayList;

import javax.naming.InitialContext;

import biomight.Constants;
import biomight.bacteria.Bacteria;
import biomight.cell.bloodandimmune.Erythrocyte;
import biomight.chemistry.pharma.diuretic.Mannitol;
import biomight.ejb.BioMightBeanLocal;
import biomight.exceptions.ServerException;
import biomight.view.BioMightMethodView;
import biomight.view.BioMightPosition;
import biomight.view.BioMightPropertyView;
import biomight.view.BioMightTransform;

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
import biomight.cell.Ribosomes;
import biomight.cell.bloodandimmune.Erythrocyte;
import biomight.chemistry.aminoacid.GlutamicAcid;
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

/*********************************************************************************
 * @author SurferJim
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 ********************************************************************************/

public class StaphylococcusAureus extends Bacteria {
	private String bacteriaName = "StaphylococcusAureus";
	private ArrayList colors;
	private BioMightPosition bioMightPosition;
	private int view = Constants.VIEW_BIRDSEYE; 
	
	//private LethalFactor lethalFactor;
private GlutamicAcid glutamicAcid;;
	private CellMembrane cellMembrane;

	private BacterialCellWall bacterialCellWall;
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
	private BacterialGranule bacterialGranule;
	private BacterialPolymerase bacterialPolymerase;

	
	private BigDecimal amountCoagulse;
	private boolean isMethicillinResistant;
	private boolean isNafcillinResistant;
	private boolean isVancoMycinResistant;
	
	
	public StaphylococcusAureus()
	{
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, Constants.StaphylococcusAureusRef, null, null);
	}

	public StaphylococcusAureus(String parentID)
	{
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, parentID, null, null);
	}

	public StaphylococcusAureus(int hierarchy, int LOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
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
		this.setImage("images/StaphylococcusAureus.jpg");
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
			System.out.println("In StaphylococcusAureus Create() - ViewInternal - Already Set: " + parentID);				

			
			// We already have the data for the current instance of StaphylococcusAureus,
			// Go get the details for the current StaphylococcusAureus is LOD is set
			if (localLOD == Constants.MAG2X)
			{
				// Go get the finer details of the StaphylococcusAureus				
				System.out.println("Getting the StaphylococcusAureus MAG2X : " + parentID);
				localVP = Constants.VIEW_INTERNAL; 
				localLOD = Constants.MAG1X;
				cellMembrane = new CellMembrane(localVP, localLOD, componentID, bioMightMethods);									
				System.out.println("StaphylococcusAureus Instance created from SubComponents : " + parentID);
			
				System.out.println("Creating Fimbriae MAG 1X : " + parentID);
				fimbriae = new Fimbriae(localVP, localLOD, componentID, bioMightProperties, bioMightMethods);
				initProperty(Constants.FimbriaeRef, Constants.Fimbriae, Constants.FimbriaeRef, fimbriae.getComponentID());
				System.out.println("In StaphylococcusAureus - Fimbriae is complete");
	
				System.out.println("Creating Mesosomes MAG 1X : " + parentID);
				mesosomes = new Mesosomes(localVP, localLOD, componentID, bioMightProperties, bioMightMethods);
				initProperty(Constants.MesosomesRef, Constants.Mesosomes, Constants.MesosomesRef, mesosomes.getComponentID());
				System.out.println("In Mesosome - Mesosome is complete");

				// Make this a collection of a few flagella components
				System.out.println("Creating Flagella MAG 1X : " + parentID);
				flagella = new Flagella(localVP, localLOD, componentID, bioMightProperties, bioMightMethods);
				initProperty(Constants.FlagellaRef, Constants.Flagella, Constants.FlagellaRef, fimbriae.getComponentID());
				System.out.println("In StaphylococcusAureus - Flagella is complete");
	
				// initialize the Properties
				//initProperty(bioMightTransform.getName(), Constants.StaphylococcusAureus, Constants.StaphylococcusAureusRef, bioMightTransform.getId());
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
		
			// This is when one is accessing a StaphylococcusAureus directly
			// Get the information from the database via the Enterprise Bean		
			try {
				// Get the information from the database via the Enterprise Bean		
				System.out.println("Getting HawkEye StaphylococcusAureusInfo for ParentID: " + parentID);
				InitialContext ctx = new InitialContext();
				BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
				bioMightTransforms = bioMightBean.getComponent(parentID);
				
				System.out.println("Have StaphylococcusAureus Info from EJB");   	
			}catch (Exception e) { 
				System.out.println("Exception Getting Components - StaphylococcusAureus");
				throw new ServerException("Remote Exception getComponents():", e); 	
			}
				
			// Run through the collection of BacilliAnthracis and build them into the model
			// In the default case, we get one instance of the StaphylococcusAureus for each eye
			ArrayList transforms = bioMightTransforms.getTransforms();
			System.out.println("StaphylococcusAureus NumTransforms: " + transforms.size());
			for (int i=0; i<transforms.size(); i++)
			{
				// Get the information for the StaphylococcusAureus
				BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
				System.out.println("Creating StaphylococcusAureus: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
				this.componentID = bioMightTransform.getId();

		
				if (localLOD == Constants.MAG1X)
				{
					System.out.println("Creating StaphylococcusAureus at HawkEye MAG1X - Just Init Properties: " + parentID);
					// initialize the Properties
					initProperties();
				}
				if (localLOD == Constants.MAG2X)
				{
					// Go get the finer details of the StaphylococcusAureus				
					System.out.println("Creating StaphylococcusAureus at HawkEye MAG2X : " + parentID);
					localVP = Constants.VIEW_INTERNAL; 
					localLOD = Constants.MAG1X;

					System.out.println("Creating CellMembrane : " + parentID + " lod: " + localLOD);
					cellMembrane = new CellMembrane(localVP, localLOD, bioMightTransform.getId(), bioMightMethods);
					initProperty(Constants.CellMembraneRef, Constants.CellMembrane, Constants.CellMembraneRef, cellMembrane.getComponentID());
					System.out.println("In StaphylococcusAureus - CellMembrane is complete");
		
					localVP = Constants.VIEW_HAWKEYE; 
					localLOD = Constants.MAG1X;
					
					System.out.println("Creating Fimbriae: " + parentID);
					fimbriae = new Fimbriae(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
					initProperty(Constants.FimbriaeRef, Constants.Fimbriae, Constants.FimbriaeRef, fimbriae.getComponentID());
					System.out.println("In StaphylococcusAureus - Fimbriae is complete");
				
					System.out.println("Creating Mesosomes: " + parentID);
					mesosomes = new Mesosomes(localVP, localLOD, componentID, bioMightProperties, bioMightMethods);
					initProperty(Constants.MesosomesRef, Constants.Mesosomes, Constants.MesosomesRef, mesosomes.getComponentID());
					System.out.println("In Mesosome - Mesosome is complete");
	
					// Make this a collection of a few flagella components
					System.out.println("Creating Flagella: " + parentID);
					flagella = new Flagella(localVP, localLOD, componentID, bioMightProperties, bioMightMethods);
					initProperty(Constants.FlagellaRef, Constants.Flagella, Constants.FlagellaRef, fimbriae.getComponentID());
					System.out.println("In StaphylococcusAureus - Flagella is complete");
	
					System.out.println("Creating Ribosomes: " + parentID);
					ribosomes = new Ribosomes(localVP, localLOD, componentID, bioMightProperties, bioMightMethods);
					initProperty(Constants.RibosomesRef, Constants.Ribosomes, Constants.RibosomesRef, ribosomes.getComponentID());
					System.out.println("In StaphylococcusAureus - Ribosomes are complete");
	
				}
				
			}
		}		
		else
		{
			
		}
			
		initMethods();
		
		System.out.println("CreateStaphylococcusAureus Completed");
		
		// First, get all the data from the database
		// Apply the methods to it
		// Save its state
		this.parentID = parentID;
		if (bioMightMethods != null){
			System.out.println("EXECUTING StaphylococcusAureus Methods: " + bioMightMethods.size());
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
		method.setDisplayName("Penetrate StaphylococcusAureus");
		method.setMethodName("Penetrate StaphylococcusAureus");
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

				
	}
	
	
	/****************************************************
	 * GENERATE 
	 * 
	 * 
	 * @param parentID
	 * @param componentID
	 ***************************************************/
	public void generate(String parentID, String componentID)
	{
		// Generate the StaphylococcusAureus		
		BioMightBeanLocal bioMightBean;
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Generating the StaphylococcusAureus : " + componentID + "    " + parentID);
			InitialContext ctx = new InitialContext();
			bioMightBean = (BioMightBeanLocal) ctx.lookup("java:global/BioMightWeb/BioMightBean!biomight.ejb.BioMightBeanLocal");
	
			double circumference = 0.125;
			
			if (componentID.equals("StaphylococcusAureus:01")) {
				
				// Generate the Palm
				double[] startPos = {3.75,-23.0,-6.0};
				double[][] currentPoints = BioGraphics.octogonXPlane(startPos, circumference);
						
				//int success = bioMightBean.generateStaphylococcusAureus("StaphylococcusAureus:00001", "StaphylococcusAureus", 
				//		"StaphylococcusAureus", componentID, parentID, currentPoints);			
				
			}
			else if (componentID.equals("StaphylococcusAureus:02"))
			{
				// Generate the Elbow
				double[] startPos = {-3.75,-23.0,-6.0};
				double[][] currentPoints = BioGraphics.octogonXPlane(startPos, circumference);
				
				//int success = bioMightBean.generateStaphylococcusAureus("StaphylococcusAureus:00160", "StaphylococcusAureus", 
				//	"StaphylococcusAureus", componentID, parentID, currentPoints);
		
				
			}
			else if (parentID.equals("")) 
			{	
				System.out.println("Calling Generate StaphylococcusAureus NoParent");		
			}

			
			System.out.println("Created StaphylococcusAureus Info using EJB");   	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - StaphylococcusAureus");
			throw new ServerException("Remote Exception StaphylococcusAureus():", e); 	
		}
	}
	
	

	
	/********************************************************************************************************************
	 * GET X3D
	 * 
	 * This method will return the X3D for the StaphylococcusAureus.  It runs through each of its components and collects up their
	 * representations and then assembles them into one unified X3D model.
	 * 
	 ********************************************************************************************************************/
	public String getX3D(boolean snipet) {
		
		// Assembe the StaphylococcusAureus
		String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
		"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n " +
		"<X3D profile='Immersive' >\n" +
		"<head>\n" +
		 "<meta name='BioMightImage' content='StaphylococcusAureus.jpg'/>\n" +
		 "<meta name='ExportTime' content='7:45:30'/>\n" +
		 "<meta name='ExportDate' content='08/15/2008'/>\n" +
		 "<meta name='BioMight Version' content='1.0'/>\n" + 
		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='StaphylococcusAureus'\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		

		String body = "";
		String annotate = "";
		

		System.out.println("Getting X3D for StaphylococcusAureus!!!!!!!!");

		
		// Only when the database retrieval has been locally, do we do this??
		if (viewPerspective == Constants.VIEW_INTERNAL) 
		{	
			
			System.out.println("Get X3D StaphylococcusAureus - View Internal");
			// We do nada as the StaphylococcusAureus Data is retrieved in the collection object
			// and the X3D is generated there
			if (lod == Constants.MAG2X)		
			{
				System.out.println("Get X3D StaphylococcusAureus - View Internal - 2X");
				//We are going to get the X3D from the aggregation objects
				body += cellMembrane.getX3D(true) + fimbriae.getX3D(true) + mesosomes.getX3D(true) + flagella.getX3D(true);	
			}
			else if (lod == Constants.MAG1X)
			{			
				// We went to the database to get data.  There will be 1 Transform record
			
				/*
				System.out.println("Creating StaphylococcusAureus: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
				System.out.println("Creating StaphylococcusAureus at Position: " + 
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
				    " url='../images/StaphylococcusAureus.png'/>";
				
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
				 	"<Sphere DEF='StaphylococcusAureusGeoSphere'\n" +
				 	"containerField='geometry'\n" +
				 	"radius='" + bioMightTransform.getRadius() +"'/>\n" +
				 	"</Shape>\n" +
				 	
					"\n<TouchSensor DEF='TSENSOR_"+ bioMightTransform.getId()+ "' \n" +
	                   " description='StaphylococcusAureus'\n" +
		               " containerField='children'/> \n" +
	
				 "</Transform>\n";
				*/
			}
		
		}
		else if (viewPerspective == Constants.VIEW_HAWKEYE) 
		{
			System.out.println("Get X3D StaphylococcusAureus - View Hawkeye");
			
			//************************************************************888
			//**************************************************************8
			// HACK
			lod = Constants.MAG1X;
			//************************************************************
			//************************************************************

			if (lod == Constants.MAG2X)		
			{
				System.out.println("Get X3D StaphylococcusAureus - View Hawkeye -- 2X");
				//We are going to get the X3D from the aggregation objects
				body += cellMembrane.getX3D(true)  
						+ fimbriae.getX3D(true) 
						+ ribosomes.getX3D(true) 
						+ mesosomes.getX3D(true) 
						+ flagella.getX3D(true);	
			}
			else
			{			
				// We went to the database to get data.  There will be 1 Transform record
				System.out.println("Get X3D StaphylococcusAureus - View Hawkeye  1X");
			
				ArrayList transforms = bioMightTransforms.getTransforms();
				for (int i=0; i<transforms.size(); i++)
				{
					// Get the information for the capsomer we are creating
					BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
					System.out.println("Creating StaphylococcusAureus: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
					System.out.println("Creating StaphylococcusAureus at Position: " + 
							bioMightTransform.getTranslation().getXPos() + "  " +
							bioMightTransform.getTranslation().getYPos() + "  " +
							bioMightTransform.getTranslation().getZPos());
					
						
					double xPos = bioMightTransform.getTranslation().getXPos();  
					double yPos = bioMightTransform.getTranslation().getYPos();
					double zPos = bioMightTransform.getTranslation().getZPos();	
					double height =  bioMightTransform.getHeight();
					double radius = bioMightTransform.getRadius();
					
					
					int eRing = 0;
					double ringSize = radius * 1.25;
					ArrayList ringData = new ArrayList();	
			
					double[][] offSets0 = new double[7][3];
					
					offSets0[0][0] = ringSize;
					offSets0[0][1] = ringSize;
					offSets0[0][2] = 0;
							
					offSets0[1][0] = -ringSize;
					offSets0[1][1] = ringSize;
					offSets0[1][2] = 0;

					offSets0[2][0] = -ringSize;
					offSets0[2][1] = -ringSize;
					offSets0[2][2] = 0;
					
					offSets0[3][0] = ringSize;
					offSets0[3][1] = -ringSize;
					offSets0[3][2] = 0;
					
					offSets0[4][0] = 0;
					offSets0[4][1] = 0;
					offSets0[4][2] = ringSize;
					
					offSets0[5][0] = 0;
					offSets0[5][1] = 0;
					offSets0[5][2] = -ringSize;
					
					offSets0[6][0] = 0;
					offSets0[6][1] = 0;
					offSets0[6][2] = 0;
							
					ringData.add(0, offSets0);

					
					eRing = 1;
				    ringSize = radius * 2.5;
					double[][] offSets1 = new double[5][3];
					
					offSets1[0][0] = .707 * ringSize;
					offSets1[0][1] = 0;
					offSets1[0][2] = .707 * ringSize;
							
					offSets1[1][0] = -.707 * ringSize;
					offSets1[1][1] = 0;
					offSets1[1][2] = .707 * ringSize;		
							
					offSets1[2][0] = .707 * ringSize;
					offSets1[2][1] = 0;
					offSets1[2][2] = -.707 * ringSize;
					
					offSets1[3][0] = -.707 * ringSize;
					offSets1[3][1] = 0;
					offSets1[3][2] = -.707 * ringSize;
				
					ringSize = radius * 1.5;
					offSets1[4][0] = 0;
					offSets1[4][1] = ringSize;
					offSets1[4][2] = ringSize;
				
					
					ringData.add(1, offSets1);
					
					
				
					/*

					
					eRing = 2;
					ringSize = radius +  (2*radius * eRing);
					double[][] offSets2 = new double[18][3];
					
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
					
					offSets2[5][0] = ringSize;
					offSets2[5][1] = 0;
					offSets2[5][2] = ringSize;
					
					offSets2[6][0] = -ringSize;
					offSets2[6][1] = 0;
					offSets2[6][2] = ringSize;
					
					offSets2[7][0] = -ringSize;
					offSets2[7][1] = 0;
					offSets2[7][2] = -ringSize;
					
					
					// Z Flat
					offSets2[8][0] = ringSize;
					offSets2[8][1] = 0;
					offSets2[8][2] = 0;
					
					offSets2[9][0] = 0;
					offSets2[9][1] = ringSize;
					offSets2[9][2] = 0;
					
					offSets2[10][0] = -ringSize;
					offSets2[10][1] = -ringSize;
					offSets2[10][2] = 0;
					
					offSets2[11][0] = -ringSize;
					offSets2[11][1] =  ringSize;
					offSets2[11][2] = 0;
					
					offSets2[12][0] = ringSize;
					offSets2[12][1] = ringSize;
					offSets2[12][2] = 0;
					
					offSets2[13][0] = ringSize;
					offSets2[13][1] = ringSize;
					offSets2[13][2] = 0;
					
					// Z-Y
					offSets2[14][0] = -ringSize * .707;
					offSets2[14][1] = 0;
					offSets2[14][2] = ringSize * .707;
					
					offSets2[15][0] = -ringSize;
					offSets2[15][1] = 0;
					offSets2[15][2] = -ringSize;
				
					offSets2[16][0] = -ringSize;
					offSets2[16][1] = 0;
					offSets2[16][2] = ringSize;
					
					offSets2[17][0] = -ringSize;
					offSets2[17][1] = 0;
					offSets2[17][2] = -ringSize;
					ringData.add(2, offSets2);

					*/
				
					body += BioWebX3DUtils.addCocci(bioMightTransform, ringData);

					
				}
				
			}
		}
		else 
		{			
			// Issue
		}	
			
		
		//System.out.println("StaphylococcusAureus X3D: " + body);		
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
			System.out.println("Have BioMightMethod for StaphylococcusAureus: " + bioMightMethod.getMethodName());	
			String methodName = bioMightMethod.getMethodName();
			String canonicalName = bioMightMethod.getCanonicalName(); 
			String dataType = bioMightMethod.getDataType();
			String methodParam = bioMightMethod.getMethodParameter(); 
			if (methodParam == null)
				methodParam = "";
			
			// We only execute those methods that are targeted for the IRIS
			// If a parameter is specified then we fire the method, otherwise
			// we just jump over it
			if (canonicalName.equals(Constants.StaphylococcusAureus)) {				
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
				System.out.println("Basophils - Methods have fired.   Calling Basophils Save method!");
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
		// StaphylococcusAureus Bacteria ferments Mannitol
		if (obj instanceof Mannitol)
		{
		}

		// StaphylococcusAureus Bacteria hemolyzes Red Blood Cells
		if (obj instanceof Erythrocyte)
		{
		}
		
	}
			
		
}

	
