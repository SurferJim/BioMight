package biomight.virus.dna;
import java.lang.reflect.Method;
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
import biomight.view.BioMightOrientation;
import biomight.view.BioMightPosition;
import biomight.view.BioMightPropertyView;
import biomight.view.BioMightTexture;
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
import biomightweb.util.BioWebUtils;
import biomightweb.util.BioWebX3DUtils;

/************************************************************************
* @author SurferJim
*
* BioMight Component Class - May 2007
*
*************************************************************************/
public class Adenovirus  extends BioMightBase {
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
	
	
	public Adenovirus()
	{
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, Constants.AdenovirusRef, null, null);
	}

	public Adenovirus(String parentID)
	{
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, parentID, null, null);
	}

	public Adenovirus(int hierarchy, int LOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
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
		this.setImage("images/Adenovirus.jpg");
		this.setImageHeight(300);
		this.setImageWidth(300);
		this.parentID = parentID;
		this.componentID = parentID;
		this.lod = localLOD;
		this.viewPerspective = localVP;
		
		System.out.println("Creating Adenovirus for: " + parentID);	

		// execute the methods
		this.parentID = parentID;
		if (bioMightMethods != null){
			System.out.println("EXECUTING Adenovirus Methods: " + bioMightMethods.size());
			executeMethods(bioMightMethods);
		}
		
		if (localVP == Constants.VIEW_INTERNAL)			
		{
			// Do nothing.  We are instantiating as part of a collection  
			// There is no drill down, so we use the transforms that the
			// parent has already collected
			System.out.println("In Adenovirus Create() - ViewInternal - Already Set: " + parentID);				

			// We already have the data for the current instance of Adenovirus,
			// Go get the details for the current Adenovirus is LOD is set
			if (localLOD == Constants.MAG2X)
			{
				// Go get the finer details of the Adenovirus				
				System.out.println("Getting the Adenovirus MAG2X : " + parentID);
				localVP = Constants.VIEW_INTERNAL; 
				localLOD = Constants.MAG1X;		
			
				System.out.println("Creating Capsid MAG ViewInternal - 1X : " + parentID);
				capsid = new Capsid(localVP, localLOD, componentID, bioMightProperties, bioMightMethods);
				initProperty(Constants.CapsidRef, Constants.Capsid, Constants.CapsidRef, capsid.getComponentID());
				System.out.println("In Adenovirus - Capsid is complete");
	

				/****
				System.out.println("Creating CapsidNeck MAG ViewInternal - 1X : " + parentID);
				capsidNeck = new CapsidNeck(localVP, localLOD, componentID, bioMightProperties, bioMightMethods);
				initProperty(Constants.CapsidNeckRef, Constants.CapsidNeck, Constants.CapsidNeckRef, capsidNeck.getComponentID());
				System.out.println("In Adenovirus - CapsidNeck is complete");
	
				System.out.println("Creating CapsidTail MAG ViewInternal - 1X : " + parentID);
				capsidTail = new CapsidTail(localVP, localLOD, componentID, bioMightProperties, bioMightMethods);
				initProperty(Constants.CapsidTailRef, Constants.CapsidTail, Constants.CapsidTailRef, capsidTail.getComponentID());
				System.out.println("In Adenovirus - CapsidTail is complete");

				System.out.println("Creating VirusBasePlate MAG ViewInternal - 1X : " + parentID);
				virusBasePlate = new VirusBasePlate(localVP, localLOD, componentID, bioMightProperties, bioMightMethods);
				initProperty(Constants.VirusBasePlateRef, Constants.VirusBasePlate, Constants.VirusBasePlateRef, virusBasePlate.getComponentID());
				System.out.println("In Adenovirus - VirusBasePlate is complete");
				
				localLOD = Constants.MAG2X;	
				System.out.println("Creating VirusTailFibers MAG ViewInternal - 2X : " + parentID);
				virusTailFibers = new VirusTailFibers(localVP, localLOD, componentID, bioMightProperties, bioMightMethods);
				initProperty(Constants.VirusTailFibersRef, Constants.VirusTailFibers, Constants.VirusTailFibersRef, virusTailFibers.getComponentID());
				System.out.println("In Adenovirus - VirusTailFibers is complete");
				***/
				
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
		
			// This is when one is accessing a Adenovirus directly
			// Get the information from the database via the Enterprise Bean		
			try {
				// Get the information from the database via the Enterprise Bean		
				System.out.println("Getting HawkEye AdenovirusInfo for ParentID: " + parentID);
				InitialContext ctx = new InitialContext();
				BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup("java:global/BioMightWeb/BioMightBean!biomight.ejb.BioMightBeanLocal");
				bioMightTransforms = bioMightBean.getComponent(parentID);
				
				System.out.println("Have Adenovirus Info from EJB");   	
			}catch (Exception e) { 
				System.out.println("Exception Getting Components - Adenovirus");
				throw new ServerException("Remote Exception getComponents():", e); 	
			}
				
			// Run through the collection of BacilliAnthracis and build them into the model
			// In the default case, we get one instance of the Adenovirus for each eye
			ArrayList transforms = bioMightTransforms.getTransforms();
			System.out.println("Adenovirus NumTransforms: " + transforms.size());
			for (int i=0; i<transforms.size(); i++)
			{
				// Get the information for the Adenovirus
				
				// HACK - we know that there will be one instance
				bioMightTransform = (BioMightTransform) transforms.get(i);
				System.out.println("Creating Adenovirus: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
				this.componentID = bioMightTransform.getId();

		
				if (localLOD == Constants.MAG1X)
				{
					System.out.println("Creating Adenovirus at HawkEye MAG1X - Just Init Properties: " + parentID);
					// initialize the Properties
					initProperties();
				}
				if (localLOD == Constants.MAG2X)
				{
					// Go get the finer details of the Adenovirus				
					System.out.println("Creating Adenovirus at HawkEye MAG2X : " + parentID);
					localVP = Constants.VIEW_INTERNAL; 
					localLOD = Constants.MAG1X;

					System.out.println("Creating Capsid MAG 1X : " + parentID);
					capsid = new Capsid(localVP, localLOD, componentID, bioMightProperties, bioMightMethods);
					initProperty(Constants.CapsidRef, Constants.Capsid, Constants.CapsidRef, capsid.getComponentID());
					System.out.println("In Adenovirus - Capsid is complete");

					
					/*****
					System.out.println("Creating CapsidNeck MAG ViewInternal - 1X : " + parentID);
					capsidNeck = new CapsidNeck(localVP, localLOD, componentID, bioMightProperties, bioMightMethods);
					initProperty(Constants.CapsidNeckRef, Constants.CapsidNeck, Constants.CapsidNeckRef, capsidNeck.getComponentID());
					System.out.println("In Adenovirus - CapsidNeck is complete");
		
					System.out.println("Creating CapsidTail MAG ViewInternal - 1X : " + parentID);
					capsidTail = new CapsidTail(localVP, localLOD, componentID, bioMightProperties, bioMightMethods);
					initProperty(Constants.CapsidTailRef, Constants.CapsidTail, Constants.CapsidTailRef, capsidTail.getComponentID());
					System.out.println("In Adenovirus - CapsidTail is complete");

					System.out.println("Creating VirusBasePlate MAG ViewInternal - 1X : " + parentID);
					virusBasePlate = new VirusBasePlate(localVP, localLOD, componentID, bioMightProperties, bioMightMethods);
					initProperty(Constants.VirusBasePlateRef, Constants.VirusBasePlate, Constants.VirusBasePlateRef, virusBasePlate.getComponentID());
					System.out.println("In Adenovirus - VirusBasePlate is complete");
					
					localLOD = Constants.MAG2X;	
					System.out.println("Creating VirusTailFibers MAG ViewInternal - 2X : " + parentID);
					//System.out.println("Creating VirusTailFibers MAG ViewInternal - 1X : " + parentID);
					virusTailFibers = new VirusTailFibers(localVP, localLOD, componentID, bioMightProperties, bioMightMethods);
					initProperty(Constants.VirusTailFibersRef, Constants.VirusTailFibers, Constants.VirusTailFibersRef, virusTailFibers.getComponentID());
					System.out.println("In Adenovirus - VirusTailFibers is complete");
					****/
					
				}
				
			}
		}		
		else
		{
			
		}
			
		initMethods();
		
		System.out.println("CreateAdenovirus Completed");			
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
	
		BioMightMethodView method;
		
		method = new BioMightMethodView();
		method.setCanonicalName(Constants.Adenovirus);
		method.setMethodName("setMaterial");
		method.setDisplayName("Material");
		method.setHtmlType(Constants.BIO_DROPDOWN);
		method.setDataType(Constants.BIO_TEXT);
	 	method.setValueMap(materialDDMap);
		methods.add(method);
		
		method = new BioMightMethodView();
		method.setCanonicalName(Constants.Adenovirus);
		method.setMethodName("setTexture");
		method.setDisplayName("Texture");
		method.setHtmlType(Constants.BIO_DROPDOWN);
		method.setDataType(Constants.BIO_TEXT);
	 	method.setValueMap(textureDDMap);
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
		// Generate the Adenovirus		
		BioMightBeanLocal bioMightBean;
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Generating the Adenovirus : " + componentID + "    " + parentID);
			InitialContext ctx = new InitialContext();
			bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
			
			double circumference = 0.0025;
			// Generate the GreaterCurvature of the stomach
			// Create 5 sections
			double[] startPos = {0.0, 0.0, 0.00};
			double[][] currentPoints = BioGraphics.octogonYPlane(startPos, circumference);
					
			//int success = bioMightBean.generateAdenovirus("Adenovirus:00001", "Adenovirus", 
			//		"Adenovirus", componentID, parentID, currentPoints);			
			
			System.out.println("Created Adenovirus Info using EJB");   	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - Adenovirus");
			throw new ServerException("Remote Exception Adenovirus():", e); 	
		}
	}
	
	

	
	/********************************************************************************************************************
	 * GET X3D
	 * 
	 * This method will return the X3D for the Adenovirus.  It runs through each of its components and collects up their
	 * representations and then assembles them into one unified X3D model.
	 * 
	 ********************************************************************************************************************/
	public String getX3D(boolean snipet) {
		
		// Assembe the Adenovirus
		String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
		"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n " +
		"<X3D profile='Immersive' >\n" +
		"<head>\n" +
		 "<meta name='BioMightImage' content='Adenovirus.jpg'/>\n" +
		 "<meta name='ExportTime' content='7:45:30'/>\n" +
		 "<meta name='ExportDate' content='08/15/2008'/>\n" +
		 "<meta name='BioMight Version' content='1.0'/>\n" + 
		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='Adenovirus'\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		

		String body = "";
		String annotate = "";
		

		System.out.println("Getting X3D for Adenovirus!!!!!!!!");

		
		// Only when the database retrieval has been locally, do we do this??
		if (viewPerspective == Constants.VIEW_INTERNAL) 
		{	
			
			//************************************************************888
			//**************************************************************8
			// HACK
			lod = Constants.MAG2X;
			//************************************************************
			//************************************************************

			
			System.out.println("Get X3D Adenovirus - View Internal");
			// We do nada as the Adenovirus Data is retrieved in the collection object
			// and the X3D is generated there
			if (lod == Constants.MAG2X)		
			{
				System.out.println("Get X3D Adenovirus - View Internal - 2X");
				//We are going to get the X3D from the aggregation objects
				body += capsid.getX3D(true) + capsidNeck.getX3D(true) +  capsidTail.getX3D(true) + virusBasePlate.getX3D(true)  + virusTailFibers.getX3D(true);	
			}
			else if (lod == Constants.MAG1X)
			{			
				// We went to the database to get data.  There will be 1 Transform record
			
				/*
				System.out.println("Creating Adenovirus: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
				System.out.println("Creating Adenovirus at Position: " + 
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
				    " url='../images/Adenovirus.jpg'/>";
				
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
				 	"<Sphere DEF='AdenovirusGeoSphere'\n" +
				 	"containerField='geometry'\n" +
				 	"radius='" + bioMightTransform.getRadius() +"'/>\n" +
				 	"</Shape>\n" +
				 	
					"\n<TouchSensor DEF='TSENSOR_"+ bioMightTransform.getId()+ "' \n" +
	                   " description='Adenovirus'\n" +
		               " containerField='children'/> \n" +
	
				 "</Transform>\n";
				*/
			}
		
		}
		else if (viewPerspective == Constants.VIEW_HAWKEYE) 
		{
			System.out.println("Get X3D Adenovirus - View Hawkeye");
			
			//************************************************************888
			//**************************************************************8
			// HACK
			lod = Constants.MAG2X;
			//************************************************************
			//************************************************************

			
			if (lod == Constants.MAG2X)		
			{
				BioMightPosition bioMightPosition = new BioMightPosition(0.0, 0, 0);
				BioMightOrientation bioMightOrientation = new BioMightOrientation(0, 0, 1, 90);
		
				
				System.out.println("Get X3D Adenovirus - View Hawkeye -- 2X");
				//We are going to get the X3D from the aggregation objects
				//body += capsid.getX3D(true) + capsidNeck.getX3D(true) +  capsidTail.getX3D(true)  + virusBasePlate.getX3D(true)  + virusTailFibers.getX3D(true);
				
				// HACK - passing in the one BioMightTransform record that was retrieved above
			    body+= BioWebX3DUtils.generateAdenoVirus(bioMightTransform,  bioMightPosition, bioMightOrientation); 				
			}
			else
			{			
				// We went to the database to get data.  There will be 1 Transform record
				System.out.println("Get X3D Adenovirus - View Hawkeye  1X");
			
				ArrayList transforms = bioMightTransforms.getTransforms();
				for (int i=0; i<transforms.size(); i++)
				{
					// Get the information for the capsomer we are creating
					BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
					System.out.println("Creating Adenovirus: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
					System.out.println("Creating Adenovirus at Position: " + 
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
						    
					body+= " <ImageTexture containerField='texture' " +
					    " url='../images/Adenovirus.jpg'/>";
					
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
					 	"<Sphere DEF='AdenovirusGeoSphere'\n" +
					 	"containerField='geometry'\n" +
					 	"radius='" + bioMightTransform.getRadius() +"'/>\n" +
					 	"</Shape>\n" +
					 	
						"\n<TouchSensor DEF='TSENSOR_"+ bioMightTransform.getId()+ "' \n" +
		                   " description='Adenovirus'\n" +
			               " containerField='children'/> \n" +
		
					 "</Transform>\n";
				}
				
			}
		}
		else 
		{			
			// Issue
		}	
		
		
		body+= "<Viewpoint DEF='Viewpoint_Adenovirus'\n" +
				 "description='Viewpoint1'\n" +
				 "jump='true'\n" +
				 "fieldOfView='0.785'\n" +
				 "position='0.0 0.0 5.0'\n" +
				 "orientation='0 0 1 0'/>\n";
			
		
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
		System.out.println("AdenoVirus-Executing Methods: " + bioMightMethods.size());
		for (int j=0; j<bioMightMethods.size(); j++){
			
			// Get the parameter from the list and if it is not
			// empty execute the associated method using it
			BioMightMethodView bioMightMethod = (BioMightMethodView) bioMightMethods.get(j);
			System.out.println("Have BioMightMethod for AdenoVirus: " + bioMightMethod.getMethodName());	
			String methodName = bioMightMethod.getMethodName();
			String canonicalName = bioMightMethod.getCanonicalName(); 
			String dataType = bioMightMethod.getDataType();
			String methodParam = bioMightMethod.getMethodParameter(); 
			if (methodParam == null)
				methodParam = "";
			
			// We only execute those methods that are targeted for the CellMembrane
			// If a parameter is specified then we fire the method, otherwise
			// we just jump over it
			if (canonicalName.equals(Constants.CellMembrane)) {				
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
