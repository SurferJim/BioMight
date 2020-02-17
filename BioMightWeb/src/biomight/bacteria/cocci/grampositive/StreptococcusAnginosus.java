
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
import biomight.chemistry.pharma.diuretic.Mannitol;
import biomight.ejb.BioMightBeanLocal;
import biomight.exceptions.ServerException;
import biomight.util.BioGraphics;
import biomight.view.BioMightMethodView;
import biomight.view.BioMightPosition;
import biomight.view.BioMightPropertyView;
import biomight.view.BioMightTransform;
import biomightweb.util.BioWebUtils;

/*********************************************************************************
 * @author SurferJim
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 ********************************************************************************/

public class StreptococcusAnginosus extends Bacteria {
	private String bacteriaName = "StreptococcusAnginosus";
	private ArrayList colors;
	private BioMightPosition bioMightPosition;
	private int view = Constants.VIEW_BIRDSEYE; 
	
	//private LethalFactor lethalFactor;
private GlutamicAcid glutamicAcid;
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
	
	
	public StreptococcusAnginosus()
	{
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, Constants.StreptococcusAnginosusRef, null, null);
	}

	public StreptococcusAnginosus(String parentID)
	{
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, parentID, null, null);
	}

	public StreptococcusAnginosus(int hierarchy, int LOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
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
		this.setImage("images/StreptococcusAnginosus.jpg");
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
			System.out.println("In StreptococcusAnginosus Create() - ViewInternal - Already Set: " + parentID);				

			
			// We already have the data for the current instance of StreptococcusAnginosus,
			// Go get the details for the current StreptococcusAnginosus is LOD is set
			if (localLOD == Constants.MAG2X)
			{
				// Go get the finer details of the StreptococcusAnginosus				
				System.out.println("Getting the StreptococcusAnginosus MAG2X : " + parentID);
				localVP = Constants.VIEW_INTERNAL; 
				localLOD = Constants.MAG1X;
				cellMembrane = new CellMembrane(localVP, localLOD, componentID, bioMightMethods);									
				System.out.println("StreptococcusAnginosus Instance created from SubComponents : " + parentID);
			
				System.out.println("Creating Fimbriae MAG 1X : " + parentID);
				fimbriae = new Fimbriae(localVP, localLOD, componentID, bioMightProperties, bioMightMethods);
				initProperty(Constants.FimbriaeRef, Constants.Fimbriae, Constants.FimbriaeRef, fimbriae.getComponentID());
				System.out.println("In StreptococcusAnginosus - Fimbriae is complete");
	
				System.out.println("Creating Mesosomes MAG 1X : " + parentID);
				mesosomes = new Mesosomes(localVP, localLOD, componentID, bioMightProperties, bioMightMethods);
				initProperty(Constants.MesosomesRef, Constants.Mesosomes, Constants.MesosomesRef, mesosomes.getComponentID());
				System.out.println("In Mesosome - Mesosome is complete");

				// Make this a collection of a few flagella components
				System.out.println("Creating Flagella MAG 1X : " + parentID);
				flagella = new Flagella(localVP, localLOD, componentID, bioMightProperties, bioMightMethods);
				initProperty(Constants.FlagellaRef, Constants.Flagella, Constants.FlagellaRef, fimbriae.getComponentID());
				System.out.println("In StreptococcusAnginosus - Flagella is complete");
	
				// initialize the Properties
				//initProperty(bioMightTransform.getName(), Constants.StreptococcusAnginosus, Constants.StreptococcusAnginosusRef, bioMightTransform.getId());
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
		
			// This is when one is accessing a StreptococcusAnginosus directly
			// Get the information from the database via the Enterprise Bean		
			try {
				// Get the information from the database via the Enterprise Bean		
				System.out.println("Getting HawkEye StreptococcusAnginosusInfo for ParentID: " + parentID);
				InitialContext ctx = new InitialContext();
				BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
				bioMightTransforms = bioMightBean.getComponent(parentID);
				
				System.out.println("Have StreptococcusAnginosus Info from EJB");   	
			}catch (Exception e) { 
				System.out.println("Exception Getting Components - StreptococcusAnginosus");
				throw new ServerException("Remote Exception getComponents():", e); 	
			}
				
			// Run through the collection of BacilliAnthracis and build them into the model
			// In the default case, we get one instance of the StreptococcusAnginosus for each eye
			ArrayList transforms = bioMightTransforms.getTransforms();
			System.out.println("StreptococcusAnginosus NumTransforms: " + transforms.size());
			for (int i=0; i<transforms.size(); i++)
			{
				// Get the information for the StreptococcusAnginosus
				BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
				System.out.println("Creating StreptococcusAnginosus: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
				this.componentID = bioMightTransform.getId();

		
				if (localLOD == Constants.MAG1X)
				{
					System.out.println("Creating StreptococcusAnginosus at HawkEye MAG1X - Just Init Properties: " + parentID);
					// initialize the Properties
					initProperties();
				}
				if (localLOD == Constants.MAG2X)
				{
					// Go get the finer details of the StreptococcusAnginosus				
					System.out.println("Creating StreptococcusAnginosus at HawkEye MAG2X : " + parentID);
					localVP = Constants.VIEW_INTERNAL; 
					localLOD = Constants.MAG1X;

					System.out.println("Creating CellMembrane : " + parentID + " lod: " + localLOD);
					cellMembrane = new CellMembrane(localVP, localLOD, bioMightTransform.getId(), bioMightMethods);
					initProperty(Constants.CellMembraneRef, Constants.CellMembrane, Constants.CellMembraneRef, cellMembrane.getComponentID());
					System.out.println("In StreptococcusAnginosus - CellMembrane is complete");
		
					localVP = Constants.VIEW_HAWKEYE; 
					localLOD = Constants.MAG1X;
					
					System.out.println("Creating Fimbriae: " + parentID);
					fimbriae = new Fimbriae(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
					initProperty(Constants.FimbriaeRef, Constants.Fimbriae, Constants.FimbriaeRef, fimbriae.getComponentID());
					System.out.println("In StreptococcusAnginosus - Fimbriae is complete");
				
					System.out.println("Creating Mesosomes: " + parentID);
					mesosomes = new Mesosomes(localVP, localLOD, componentID, bioMightProperties, bioMightMethods);
					initProperty(Constants.MesosomesRef, Constants.Mesosomes, Constants.MesosomesRef, mesosomes.getComponentID());
					System.out.println("In Mesosome - Mesosome is complete");
	
					// Make this a collection of a few flagella components
					System.out.println("Creating Flagella: " + parentID);
					flagella = new Flagella(localVP, localLOD, componentID, bioMightProperties, bioMightMethods);
					initProperty(Constants.FlagellaRef, Constants.Flagella, Constants.FlagellaRef, fimbriae.getComponentID());
					System.out.println("In StreptococcusAnginosus - Flagella is complete");
	
					System.out.println("Creating Ribosomes: " + parentID);
					ribosomes = new Ribosomes(localVP, localLOD, componentID, bioMightProperties, bioMightMethods);
					initProperty(Constants.RibosomesRef, Constants.Ribosomes, Constants.RibosomesRef, ribosomes.getComponentID());
					System.out.println("In StreptococcusAnginosus - Ribosomes are complete");
	
				}
				
			}
		}		
		else
		{
			
		}
			
		initMethods();
		
		System.out.println("CreateStreptococcusAnginosus Completed");
		
		// First, get all the data from the database
		// Apply the methods to it
		// Save its state
		this.parentID = parentID;
		if (bioMightMethods != null){
			System.out.println("EXECUTING StreptococcusAnginosus Methods: " + bioMightMethods.size());
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
		method.setDisplayName("Penetrate StreptococcusAnginosus");
		method.setMethodName("Penetrate StreptococcusAnginosus");
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
		// Generate the StreptococcusAnginosus		
		BioMightBeanLocal bioMightBean;
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Generating the StreptococcusAnginosus : " + componentID + "    " + parentID);
			InitialContext ctx = new InitialContext();
			bioMightBean = (BioMightBeanLocal) ctx.lookup("java:global/BioMightWeb/BioMightBean!biomight.ejb.BioMightBeanLocal");
	
			double circumference = 0.125;
			
			if (componentID.equals("StreptococcusAnginosus:01")) {
				
				// Generate the Palm
				double[] startPos = {3.75,-23.0,-6.0};
				double[][] currentPoints = BioGraphics.octogonXPlane(startPos, circumference);
						
				//int success = bioMightBean.generateStreptococcusAnginosus("StreptococcusAnginosus:00001", "StreptococcusAnginosus", 
				//		"StreptococcusAnginosus", componentID, parentID, currentPoints);			
				
			}
			else if (componentID.equals("StreptococcusAnginosus:02"))
			{
				// Generate the Elbow
				double[] startPos = {-3.75,-23.0,-6.0};
				double[][] currentPoints = BioGraphics.octogonXPlane(startPos, circumference);
				
				//int success = bioMightBean.generateStreptococcusAnginosus("StreptococcusAnginosus:00160", "StreptococcusAnginosus", 
				//	"StreptococcusAnginosus", componentID, parentID, currentPoints);
		
				
			}
			else if (parentID.equals("")) 
			{	
				System.out.println("Calling Generate StreptococcusAnginosus NoParent");		
			}

			
			System.out.println("Created StreptococcusAnginosus Info using EJB");   	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - StreptococcusAnginosus");
			throw new ServerException("Remote Exception StreptococcusAnginosus():", e); 	
		}
	}
	
	

	
	/********************************************************************************************************************
	 * GET X3D
	 * 
	 * This method will return the X3D for the StreptococcusAnginosus.  It runs through each of its components and collects up their
	 * representations and then assembles them into one unified X3D model.
	 * 
	 ********************************************************************************************************************/
	public String getX3D(boolean snipet) {
		
		// Assembe the StreptococcusAnginosus
		String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
		"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n " +
		"<X3D profile='Immersive' >\n" +
		"<head>\n" +
		 "<meta name='BioMightImage' content='StreptococcusAnginosus.jpg'/>\n" +
		 "<meta name='ExportTime' content='7:45:30'/>\n" +
		 "<meta name='ExportDate' content='08/15/2008'/>\n" +
		 "<meta name='BioMight Version' content='1.0'/>\n" + 
		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='StreptococcusAnginosus'\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		

		String body = "";
		String annotate = "";
		

		System.out.println("Getting X3D for StreptococcusAnginosus!!!!!!!!");

		
		// Only when the database retrieval has been locally, do we do this??
		if (viewPerspective == Constants.VIEW_INTERNAL) 
		{	
			
			System.out.println("Get X3D StreptococcusAnginosus - View Internal");
			// We do nada as the StreptococcusAnginosus Data is retrieved in the collection object
			// and the X3D is generated there
			if (lod == Constants.MAG2X)		
			{
				System.out.println("Get X3D StreptococcusAnginosus - View Internal - 2X");
				//We are going to get the X3D from the aggregation objects
				body += cellMembrane.getX3D(true) + fimbriae.getX3D(true) + mesosomes.getX3D(true) + flagella.getX3D(true);	
			}
			else if (lod == Constants.MAG1X)
			{			
				// We went to the database to get data.  There will be 1 Transform record
			
				/*
				System.out.println("Creating StreptococcusAnginosus: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
				System.out.println("Creating StreptococcusAnginosus at Position: " + 
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
				    " url='../images/StreptococcusAnginosus.jpg'/>";
				
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
				 	"<Sphere DEF='StreptococcusAnginosusGeoSphere'\n" +
				 	"containerField='geometry'\n" +
				 	"radius='" + bioMightTransform.getRadius() +"'/>\n" +
				 	"</Shape>\n" +
				 	
					"\n<TouchSensor DEF='TSENSOR_"+ bioMightTransform.getId()+ "' \n" +
	                   " description='StreptococcusAnginosus'\n" +
		               " containerField='children'/> \n" +
	
				 "</Transform>\n";
				*/
			}
		
		}
		else if (viewPerspective == Constants.VIEW_HAWKEYE) 
		{
			System.out.println("Get X3D StreptococcusAnginosus - View Hawkeye");
			
			//************************************************************888
			//**************************************************************8
			// HACK
			lod = Constants.MAG1X;
			//************************************************************
			//************************************************************

			if (lod == Constants.MAG2X)		
			{
				System.out.println("Get X3D StreptococcusAnginosus - View Hawkeye -- 2X");
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
				System.out.println("Get X3D StreptococcusAnginosus - View Hawkeye  1X");
			
				ArrayList transforms = bioMightTransforms.getTransforms();
				for (int i=0; i<transforms.size(); i++)
				{
					// Get the information for the capsomer we are creating
					BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
					System.out.println("Creating StreptococcusAnginosus: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
					System.out.println("Creating StreptococcusAnginosus at Position: " + 
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
							    " url='../images/StreptococcusAnginosus.jpg'/>";  
							
							
							    
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
							 	"<Sphere DEF='StreptococcusAnginosusGeoSphere'\n" +
							 	"containerField='geometry'\n" +
							 	"radius='" + (bioMightTransform.getRadius()) +"'/>\n" +
							 	"</Shape>\n" +
							 	
								"\n<TouchSensor DEF='TSENSOR_" + bioMightTransform.getId() + "' \n" +
				                   " description='StreptococcusAnginosus'\n" +
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
			
		
		//System.out.println("StreptococcusAnginosus X3D: " + body);		
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
			System.out.println("Have BioMightMethod for StreptococcusAnginosus: " + bioMightMethod.getMethodName());	
			String methodName = bioMightMethod.getMethodName();
			String canonicalName = bioMightMethod.getCanonicalName(); 
			String dataType = bioMightMethod.getDataType();
			String methodParam = bioMightMethod.getMethodParameter(); 
			if (methodParam == null)
				methodParam = "";
			
			// We only execute those methods that are targeted for the IRIS
			// If a parameter is specified then we fire the method, otherwise
			// we just jump over it
			if (canonicalName.equals(Constants.StreptococcusAnginosus)) {				
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
		// StreptococcusAnginosus Bacteria ferments Mannitol
		if (obj instanceof Mannitol)
		{
		}

		// StreptococcusAnginosus Bacteria hemolyzes Red Blood Cells
		if (obj instanceof Erythrocyte)
		{
		}
		
	}
			
		
}

	

	
	
	
	
	
	
