package biomight.virus.dna;
import java.util.ArrayList;

import javax.naming.InitialContext;

import biomight.BioMightBase;
import biomight.Constants;
import biomight.bacteria.Fimbriae;
import biomight.bacteria.Flagella;
import biomight.bacteria.Mesosomes;
import biomight.cell.CellMembrane;
import biomight.cell.Ribosomes;
import biomight.ejb.BioMightBeanLocal;
import biomight.exceptions.ServerException;
import biomight.util.BioGraphics;
import biomight.view.BioMightMethodView;
import biomight.view.BioMightPosition;
import biomight.view.BioMightPropertyView;
import biomight.view.BioMightTransform;
import biomight.view.BioMightTransforms;
import biomight.virus.Capsid;
import biomight.virus.CapsidNeck;
import biomight.virus.CapsidTail;
import biomight.virus.DNAPolymerase;
import biomight.virus.GlycoProteinSpikes;
import biomight.virus.LipidEnvelope;
import biomight.virus.MatrixProtein;
import biomight.virus.NucleoCapsid;
import biomight.virus.VirusBasePlate;
import biomight.virus.VirusTailFibers;

/************************************************************************
* @author SurferJim
*
* BioMight Component Class - May 2007
*
*************************************************************************/
public class Bacteriophage  extends BioMightBase {
	private ArrayList colors;
	private BioMightPosition bioMightPosition;
	private Capsid capsid; 
	private DNAPolymerase dnaPolymerase;
	private GlycoProteinSpikes glycoProteinSpikes;
	private LipidEnvelope lipidEnvelope;
	private MatrixProtein matrixProtein;
	private NucleoCapsid NucleoCapsid;
	private CapsidNeck capsidNeck;
	private CapsidTail capsidTail;
	//private VirusTail virusTail;
	private VirusBasePlate virusBasePlate;
	private VirusTailFibers virusTailFibers;	
	
	public Bacteriophage()
	{
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, Constants.BacteriophageRef, null, null);
	}

	public Bacteriophage(String parentID)
	{
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, parentID, null, null);
	}

	public Bacteriophage(int hierarchy, int LOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
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
		this.setImage("images/Bacteriophage.jpg");
		this.setImageHeight(300);
		this.setImageWidth(300);
		this.parentID = parentID;
		this.componentID = parentID;
		this.lod = localLOD;
		this.viewPerspective = localVP;
		
		System.out.println("Creating Bacteriophage for: " + parentID);
				
		if (localVP == Constants.VIEW_INTERNAL)			
		{
			// Do nothing.  We are instantiating as part of a collection  
			// There is no drill down, so we use the transforms that the
			// parent has already collected
			System.out.println("In Bacteriophage Create() - ViewInternal - Already Set: " + parentID);				

			// We already have the data for the current instance of Bacteriophage,
			// Go get the details for the current Bacteriophage is LOD is set
			if (localLOD == Constants.MAG2X)
			{
				// Go get the finer details of the Bacteriophage				
				System.out.println("Getting the Bacteriophage MAG2X : " + parentID);
				localVP = Constants.VIEW_INTERNAL; 
				localLOD = Constants.MAG1X;		
			
				System.out.println("Creating Capsid with MAG1X ViewInternal : " + parentID);
				capsid = new Capsid(localVP, localLOD, componentID, bioMightProperties, bioMightMethods);
				initProperty(Constants.CapsidRef, Constants.Capsid, Constants.CapsidRef, capsid.getComponentID());
				System.out.println("In Bacteriophage - Capsid is complete");
	
				System.out.println("Creating CapsidNeck Mwith MAG1X ViewInternal : " + parentID);
				capsidNeck = new CapsidNeck(localVP, localLOD, componentID, bioMightProperties, bioMightMethods);
				initProperty(Constants.CapsidNeckRef, Constants.CapsidNeck, Constants.CapsidNeckRef, capsidNeck.getComponentID());
				System.out.println("In Bacteriophage - CapsidNeck is complete");
	
				System.out.println("Creating CapsidTail with MAG1X ViewInternal: " + parentID);
				capsidTail = new CapsidTail(localVP, localLOD, componentID, bioMightProperties, bioMightMethods);
				initProperty(Constants.CapsidTailRef, Constants.CapsidTail, Constants.CapsidTailRef, capsidTail.getComponentID());
				System.out.println("In Bacteriophage - CapsidTail is complete");

				System.out.println("Creating VirusBasePlate with MAG1X ViewInternal : " + parentID);
				virusBasePlate = new VirusBasePlate(localVP, localLOD, componentID, bioMightProperties, bioMightMethods);
				initProperty(Constants.VirusBasePlateRef, Constants.VirusBasePlate, Constants.VirusBasePlateRef, virusBasePlate.getComponentID());
				System.out.println("In Bacteriophage - VirusBasePlate is complete");
				
				localLOD = Constants.MAG2X;	
				System.out.println("Creating VirusTailFibers with MAG1X ViewInternal : " + parentID);
				virusTailFibers = new VirusTailFibers(localVP, localLOD, componentID, bioMightProperties, bioMightMethods);
				initProperty(Constants.VirusTailFibersRef, Constants.VirusTailFibers, Constants.VirusTailFibersRef, virusTailFibers.getComponentID());
				System.out.println("In Bacteriophage - VirusTailFibers is complete");
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
		
			// This is when one is accessing a Bacteriophage directly
			// Get the information from the database via the Enterprise Bean		
			try {
				// Get the information from the database via the Enterprise Bean		
				System.out.println("Getting HawkEye BacteriophageInfo for ParentID: " + parentID);
				InitialContext ctx = new InitialContext();
				BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
				bioMightTransforms = bioMightBean.getComponent(parentID);
				
				System.out.println("Have Bacteriophage Info from EJB");   	
			}catch (Exception e) { 
				System.out.println("Exception Getting Components - Bacteriophage");
				throw new ServerException("Remote Exception getComponents():", e); 	
			}
				
			// Run through the collection of BacilliAnthracis and build them into the model
			// In the default case, we get one instance of the Bacteriophage for each eye
			ArrayList transforms = bioMightTransforms.getTransforms();
			System.out.println("Bacteriophage NumTransforms: " + transforms.size());
			for (int i=0; i<transforms.size(); i++)
			{
				// Get the information for the Bacteriophage
				BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
				System.out.println("Creating Bacteriophage: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
				this.componentID = bioMightTransform.getId();

		
				if (localLOD == Constants.MAG1X)
				{
					System.out.println("Creating Bacteriophage at HawkEye MAG1X - Just Init Properties: " + parentID);
					// initialize the Properties
					initProperties();
				}
				if (localLOD == Constants.MAG2X)
				{
					// Go get the finer details of the Bacteriophage				
					System.out.println("Creating Bacteriophage at HawkEye MAG2X : " + parentID);
					localVP = Constants.VIEW_INTERNAL; 
					localLOD = Constants.MAG1X;

					System.out.println("Creating Capsid MAG 1X : " + parentID);
					capsid = new Capsid(localVP, localLOD, componentID, bioMightProperties, bioMightMethods);
					initProperty(Constants.CapsidRef, Constants.Capsid, Constants.CapsidRef, capsid.getComponentID());
					System.out.println("In Bacteriophage - Capsid is complete");

					System.out.println("Creating CapsidNeck MAG ViewInternal - 1X : " + parentID);
					capsidNeck = new CapsidNeck(localVP, localLOD, componentID, bioMightProperties, bioMightMethods);
					initProperty(Constants.CapsidNeckRef, Constants.CapsidNeck, Constants.CapsidNeckRef, capsidNeck.getComponentID());
					System.out.println("In Bacteriophage - CapsidNeck is complete");
		
					System.out.println("Creating CapsidTail MAG ViewInternal - 1X : " + parentID);
					capsidTail = new CapsidTail(localVP, localLOD, componentID, bioMightProperties, bioMightMethods);
					initProperty(Constants.CapsidTailRef, Constants.CapsidTail, Constants.CapsidTailRef, capsidTail.getComponentID());
					System.out.println("In Bacteriophage - CapsidTail is complete");

					System.out.println("Creating VirusBasePlate MAG ViewInternal - 1X : " + parentID);
					virusBasePlate = new VirusBasePlate(localVP, localLOD, componentID, bioMightProperties, bioMightMethods);
					initProperty(Constants.VirusBasePlateRef, Constants.VirusBasePlate, Constants.VirusBasePlateRef, virusBasePlate.getComponentID());
					System.out.println("In Bacteriophage - VirusBasePlate is complete");
					
					localLOD = Constants.MAG2X;	
					System.out.println("Creating VirusTailFibers MAG ViewInternal - 2X : " + parentID);
					//System.out.println("Creating VirusTailFibers MAG ViewInternal - 1X : " + parentID);
					virusTailFibers = new VirusTailFibers(localVP, localLOD, componentID, bioMightProperties, bioMightMethods);
					initProperty(Constants.VirusTailFibersRef, Constants.VirusTailFibers, Constants.VirusTailFibersRef, virusTailFibers.getComponentID());
					System.out.println("In Bacteriophage - VirusTailFibers is complete");

				}
				
			}
		}		
		else
		{
			
		}
			
		initMethods();
		
		System.out.println("CreateBacteriophage Completed");
		
		// First, get all the data from the database
		// Apply the methods to it
		// Save its state
		this.parentID = parentID;
		if (bioMightMethods != null){
			System.out.println("EXECUTING Bacteriophage Methods: " + bioMightMethods.size());
			//executeMethods(bioMightMethods);
		}
			
	}
	
	


	public void initProperties() {
		
		BioMightPropertyView property;
		
		// Observable
		property = new BioMightPropertyView();
		property.setPropertyName("Common");
		property.setCanonicalName(Constants.Title);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("Capsomer");
		property.setCanonicalName(Constants.Capsomer);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("DNA Polymerase");
		property.setCanonicalName(Constants.DNAPolymerase);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("GlycoProteinSpikes");
		property.setCanonicalName(Constants.GlycoProteinSpikes);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("LipidEnvelope");
		property.setCanonicalName(Constants.LipidEnvelope);
		properties.add(property);		
		
		property = new BioMightPropertyView();
		property.setPropertyName("MatrixProtein");
		property.setCanonicalName(Constants.MatrixProtein);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("NucleoCapsid");
		property.setCanonicalName(Constants.NucleoCapsid);
		properties.add(property);
	
		
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
		method.setDisplayName("Penetrate Bacteriophage");
		method.setMethodName("Penetrate Bacteriophage");
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

	
	/**********************************************************************
	 * GENERATE 
	 * 
	 * 
	 * @param parentID
	 * @param componentID
	 **********************************************************************/
	public void generate(String parentID, String componentID)
	{
		// Generate the Bacteriophage		
		BioMightBeanLocal bioMightBean;
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Generating the Bacteriophage : " + componentID + "    " + parentID);
			InitialContext ctx = new InitialContext();
			bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
			
			double circumference = 0.0025;
			// Generate the GreaterCurvature of the stomach
			// Create 5 sections
			double[] startPos = {0.0, 0.0, 0.00};
			double[][] currentPoints = BioGraphics.octogonYPlane(startPos, circumference);
					
			//int success = bioMightBean.generateBacteriophage("Bacteriophage:00001", "Bacteriophage", 
			//		"Bacteriophage", componentID, parentID, currentPoints);			
			
			System.out.println("Created Bacteriophage Info using EJB");   	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - Bacteriophage");
			throw new ServerException("Remote Exception Bacteriophage():", e); 	
		}
	}
	
	

	
	/********************************************************************************************************************
	 * GET X3D
	 * 
	 * This method will return the X3D for the Bacteriophage.  It runs through each of its components and collects up their
	 * representations and then assembles them into one unified X3D model.
	 * 
	 ********************************************************************************************************************/
	public String getX3D(boolean snipet) {
		
		// Assembe the Bacteriophage
		String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
		"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n " +
		"<X3D profile='Immersive' >\n" +
		"<head>\n" +
		 "<meta name='BioMightImage' content='Bacteriophage.jpg'/>\n" +
		 "<meta name='ExportTime' content='7:45:30'/>\n" +
		 "<meta name='ExportDate' content='08/15/2008'/>\n" +
		 "<meta name='BioMight Version' content='1.0'/>\n" + 
		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='Bacteriophage'\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		

		String body = "";
		String annotate = "";
		

		System.out.println("Getting X3D for Bacteriophage!!!!!!!!");

		
		// Only when the database retrieval has been locally, do we do this??
		if (viewPerspective == Constants.VIEW_INTERNAL) 
		{	
			
			//************************************************************888
			//**************************************************************8
			// HACK
			lod = Constants.MAG2X;
			//************************************************************
			//************************************************************

			
			System.out.println("Get X3D Bacteriophage - View Internal");
			// We do nada as the Bacteriophage Data is retrieved in the collection object
			// and the X3D is generated there
			if (lod == Constants.MAG2X)		
			{
				System.out.println("Get X3D Bacteriophage - View Internal - 2X");
				//We are going to get the X3D from the aggregation objects
				body += capsid.getX3D(true) + capsidNeck.getX3D(true) +  capsidTail.getX3D(true) + virusBasePlate.getX3D(true)  + virusTailFibers.getX3D(true);	
			}
			else if (lod == Constants.MAG1X)
			{			
				// We went to the database to get data.  There will be 1 Transform record
			
				/*
				System.out.println("Creating Bacteriophage: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
				System.out.println("Creating Bacteriophage at Position: " + 
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
				    " url='../images/Bacteriophage.jpg'/>";
				
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
				 	"<Sphere DEF='BacteriophageGeoSphere'\n" +
				 	"containerField='geometry'\n" +
				 	"radius='" + bioMightTransform.getRadius() +"'/>\n" +
				 	"</Shape>\n" +
				 	
					"\n<TouchSensor DEF='TSENSOR_"+ bioMightTransform.getId()+ "' \n" +
	                   " description='Bacteriophage'\n" +
		               " containerField='children'/> \n" +
	
				 "</Transform>\n";
				*/
			}
		
		}
		else if (viewPerspective == Constants.VIEW_HAWKEYE) 
		{
			System.out.println("Get X3D Bacteriophage - View Hawkeye");
			
			//************************************************************888
			//**************************************************************8
			// HACK
			lod = Constants.MAG2X;
			//************************************************************
			//************************************************************

			if (lod == Constants.MAG2X)		
			{
				System.out.println("Get X3D Bacteriophage - View Hawkeye -- 2X");
				//We are going to get the X3D from the aggregation objects
				body += capsid.getX3D(true) + capsidNeck.getX3D(true) +  capsidTail.getX3D(true)  + virusBasePlate.getX3D(true)  + virusTailFibers.getX3D(true);	
			}
			else
			{			
				// We went to the database to get data.  There will be 1 Transform record
				System.out.println("Get X3D Bacteriophage - View Hawkeye  1X");
			
				ArrayList transforms = bioMightTransforms.getTransforms();
				for (int i=0; i<transforms.size(); i++)
				{
					// Get the information for the capsomer we are creating
					BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
					System.out.println("Creating Bacteriophage: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
					System.out.println("Creating Bacteriophage at Position: " + 
							bioMightTransform.getTranslation().getXPos() + "  " +
							bioMightTransform.getTranslation().getYPos() + "  " +
							bioMightTransform.getTranslation().getZPos());

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
						    
					//body+= " <ImageTexture containerField='texture' " +
					//    " url='../images/Bacteriophage.jpg'/>";
					
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
					 	"<Sphere DEF='BacteriophageGeoSphere'\n" +
					 	"containerField='geometry'\n" +
					 	"radius='" + bioMightTransform.getRadius() +"'/>\n" +
					 	"</Shape>\n" +
					 	
						"\n<TouchSensor DEF='TSENSOR_"+ bioMightTransform.getId()+ "' \n" +
		                   " description='Bacteriophage'\n" +
			               " containerField='children'/> \n" +
		
					 "</Transform>\n";
				}
				
			}
		}
		else 
		{			
			// Issue
		}	
			
		
		String footer = "</Scene>" + "</X3D>\n";		
		if (snipet)
			return body;			
		else	
			return header + body + annotate + footer;				
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

	public DNAPolymerase getDnaPolymerase() {
		return dnaPolymerase;
	}

	public void setDnaPolymerase(DNAPolymerase dnaPolymerase) {
		this.dnaPolymerase = dnaPolymerase;
	}

	public GlycoProteinSpikes getGlycoProteinSpikes() {
		return glycoProteinSpikes;
	}

	public void setGlycoProteinSpikes(GlycoProteinSpikes glycoProteinSpikes) {
		this.glycoProteinSpikes = glycoProteinSpikes;
	}

	public LipidEnvelope getLipidEnvelope() {
		return lipidEnvelope;
	}

	public void setLipidEnvelope(LipidEnvelope lipidEnvelope) {
		this.lipidEnvelope = lipidEnvelope;
	}

	public MatrixProtein getMatrixProtein() {
		return matrixProtein;
	}

	public void setMatrixProtein(MatrixProtein matrixProtein) {
		this.matrixProtein = matrixProtein;
	}

	public NucleoCapsid getNucleoCapsid() {
		return NucleoCapsid;
	}

	public void setNucleoCapsid(NucleoCapsid nucleoCapsid) {
		NucleoCapsid = nucleoCapsid;
	}

}
