/****************************************************************************************
 * Created on Sep 26, 2006
 *
 * Represents a collection of MembraneTubules
 * 
 * 
 ****************************************************************************************/


package biomight.virus;
import java.lang.reflect.Method;
import java.util.ArrayList;

import javax.naming.InitialContext;

import org.apache.openejb.math.util.MathUtils;

import biomight.BioMightBase;
import biomight.Constants;
import biomight.ejb.BioMightBeanLocal;
import biomight.ejb.BioMightCellularBeanLocal;
import biomight.exceptions.DataException;
import biomight.exceptions.DataSecurityException;
import biomight.exceptions.ServerException;
import biomight.util.BioGraphics;
import biomight.view.BioMightAppendage;
import biomight.view.BioMightMethodView;
import biomight.view.BioMightOrientation;
import biomight.view.BioMightPosition;
import biomight.view.BioMightPropertyView;
import biomight.view.BioMightScale;
import biomight.view.BioMightTransform;
import biomightweb.util.BioWebX3DUtils;
import biomightweb.view.BioMightRange;

/*********************************************************************************
 * @author SurferJim
 *
 * Representation of MembraneTubules
 ********************************************************************************/

public class MembraneTubules extends BioMightBase {
private ArrayList membraneTubules;

	
	/********************************************************************************************************************
	 *  MembraneTubules
	 * 
	 * This method will instantiate the MembraneTubules that are defined for the current model.  
	 * 
	 ********************************************************************************************************************/

	public MembraneTubules()
	{		
		int localVP= Constants.BIO_CHILD;
		int localLOD = Constants.VIEW_HAWKEYE;
		create(localVP, localLOD, Constants.CellsRef, null, null);
	}
	
	/********************************************************************************************************************
	 *  MembraneTubules
	 * 
	 * This method will instantiate the MembraneTubules that are defined for the current model.  
	 * 
	 ********************************************************************************************************************/

	public MembraneTubules(String parentID)
	{				
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, parentID, null, null);
	}
	
	public MembraneTubules(int localVP, int localLOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
	{		
		create(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);
	}
		
	/********************************************************************************************************************
	 * CREATE MembraneTubules
	 * 
	 * This method will instantiate a set of MembraneTubules.  
	 * 
	 ********************************************************************************************************************/

	private void create(int localVP, int localLOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods) 
	{
		this.setImage("images/MembraneTubules.jpg");
		
		membraneTubules = new ArrayList();
	
		// This is a collection, so set the parent of the children
		// to that of the aggregation object
		this.parentID=parentID;
		this.componentID = parentID;
		this.lod = localLOD;
		this.viewPerspective = localVP;

		
		
		if (viewPerspective == Constants.VIEW_INTERNAL)
		{
			System.out.println("VIEW_INTERNAL - MembraneTubules!!!");
			// Generate the Component if needed 
			boolean bGenerate = false;
			if (bGenerate) {
				System.out.println("Generating MembraneTubules!!!");
				generate(parentID, componentID);
			}
		}
		else if (viewPerspective == Constants.VIEW_HAWKEYE)
		{
			System.out.println("VIEW_HAWKEYE - Generating MembraneTubules!!!");
		}		
		
		
		if (bioMightMethods != null){
			System.out.println("EXECUTING MembraneTubules Methods: " + bioMightMethods.size());
			executeMethods(bioMightMethods);
		}
		
		// Get the information from the database via the Enterprise Bean.  This will get
		// a collection of MembraneTubules
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Getting MembraneTubules Transform: " + componentID + "   " +  parentID);
			InitialContext ctx = new InitialContext();
			BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
			bioMightTransforms = bioMightBean.getComponents(Constants.MembraneTubuleRef, parentID);   	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - MembraneTubules");
			throw new ServerException("Remote Exception getComponents():", e); 	
		}
		
		
		// Run through the collection of membraneTubules and build them into the model
		ArrayList transforms = bioMightTransforms.getTransforms();
		System.out.println("Have MembraneTubules NumTransforms: " + transforms.size());
		
		// If we are culling the data set
		int numRetreive=transforms.size();
	
		BioMightScale bioScale = new BioMightScale("0.00, 0.00, 0.00");
		BioMightPosition  bioPos = new BioMightPosition("0.00, 0.00, 0.00");
		String bioTemplate="AdenoViruses.x3d";

		for (int i=0; i<transforms.size(); i++)
		{
			// Get the information for the virusTailFiber we are creating
			BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
			System.out.println("Creating MembraneTubule: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
			
			// Create an instance of a MembraneTubule for each tranform specified
			localVP = Constants.VIEW_INTERNAL;
			localLOD = Constants.MAG1X;
			
			MembraneTubule membraneTubule = new MembraneTubule(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);		
			System.out.println("MembraneTubule Created!: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
			membraneTubules.add(membraneTubule);
			System.out.println("Added MembraneTubule to Collection!: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
			initProperty(bioMightTransform.getName(), Constants.MembraneTubule, Constants.MembraneTubuleRef, bioMightTransform.getId());				
			
			int numElements = 50;
			if (i == numElements)
				break;
		}

		// Set up methods that will be available to the membraneTubules
		initMethods(bioMightMethods);
	}
	
	
	public void initMethods(ArrayList<BioMightMethodView> bioMightMethodsIn) {
			
		// If we are coming in normally the methods and properties will not
		// be populated.   When processing data they will and we need to use
		// those values
		if (bioMightMethodsIn.size() == 0) {
			System.out.println("New Set of MembraneTubulesMethods: " + bioMightMethodsIn.size());
			BioMightMethodView method = new BioMightMethodView();
			method.setCanonicalName(Constants.MembraneTubules);
			method.setMethodName("setColonySize");
			method.setDisplayName("Colony Size:");
			method.setHtmlType("text");
			method.setDataType(Constants.BIO_INT);
			methods.add(method);
		}
		else
		{
			System.out.println("Using Existing MembraneTubulesMethods: " + bioMightMethodsIn.size());
			// using the data passed in from the previous invocation
			methods = bioMightMethodsIn;
		}
	}

	
	
	/***************************************************************************************
	 * GENERATE 
	 * 
	 * Will create Tail Fiber Segment records in the database.   It will create
	 * a group from here.  
	 * 
	 * @param parentID
	 * @param componentID
	 ***************************************************************************************/
	
	public void generate(String parentID, String componentID)
	{
		// Generate the GlyycoProteinSpikes		
		BioMightCellularBeanLocal bioMightBean;
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Generating the MembraneTubules: " + componentID + "    " + parentID);
			InitialContext ctx = new InitialContext();
			bioMightBean = (BioMightCellularBeanLocal) ctx.lookup("java:global/BioMightWeb/BioMightCellularBean!biomight.ejb.BioMightCellularBeanLocal");
	
			//if (parentID.startsWith("Capsid")) 
			//{
				double radius = 0.5;
				double[] startPos = {0.0, 0.0, 0.0};
				double[][] currentPoints = BioGraphics.createCylinderInPlane(Constants.YPLANE, startPos, radius, 8);
				
				double cylinderHeight = 0.0325;
				double cylinderRadius = 0.00625;
				int numElements = 10;
				System.out.println("Calling Generate MembraneTubules: " + componentID + "    " + parentID);
				//int success = bioMightBean.generateMembraneTubule(numElements, radius, cylinderRadius, cylinderHeight, 
				//		Constants.MembraneTubuleRef, Constants.MembraneTubuleRef, componentID, parentID, currentPoints);		
			//}
				
			System.out.println("Created MembraneTubuleInfo using EJB");   	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - MembraneTubule");
			throw new ServerException("Remote Exception getComponents():", e); 	
		}
	}
	

	/********************************************************************************************************************
	 * GET X3D
	 * 
	 * This method will return the X3D for the VirusTailFibers.  It runs through each of its components and collects up their
	 * representations and then assembles them into one unified X3D model.
	 * 
	 ********************************************************************************************************************/
	public String getX3D(boolean snipet) {
		
		// Assemble the MembraneTubules
		String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
		"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n " +
		"<X3D profile='Immersive' >\n" +
		"<head>\n" +
		 "<meta name='BioMightImage' content='Hips.jpg'/>\n" +
		 "<meta name='ExportTime' content='7:45:30'/>\n" +
		 "<meta name='ExportDate' content='08/15/2008'/>\n" +
		 "<meta name='BioMight Version' content='1.0'/>\n" + 
		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='MembraneTubules'\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		

		String body = ""; 

			
		// Grab the data from the collection that we just created.
		
		if (viewPerspective == Constants.VIEW_DETACHED || viewPerspective == Constants.VIEW_HAWKEYE)
		{
			System.out.println("Assembling X3D-MembraneTubules ViewDETACHED - size: " + membraneTubules.size());
		
			double angleLongitude = 0.0;
			double angleLatitude = 0.0;
			
			ArrayList transforms = bioMightTransforms.getTransforms();
			for (int i=0; i<transforms.size(); i++)
			{
				// Get the information for the capsomer we are creating
				BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
				System.out.println("Getting X3D -InternalView - for MembraneTubule: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());				

				//System.out.println("Getting X3D for MembraneTubuleX: " + bioMightTransform.getTranslation().getXPos());
				//System.out.println("Getting X3D for MembraneTubuleY: " + bioMightTransform.getTranslation().getYPos());
				//System.out.println("Getting X3D for MembraneTubuleZ: " + bioMightTransform.getTranslation().getZPos());
				// Change the height and width based on the displacement.
				
				
				if (parentID.contains(Constants.InfluenzaAVirusRef))
				{		
					body += "<Transform  onmouseover=\"showComponent('" + "MembraneTubule" +  "');\"  DEF='" + bioMightTransform.getId() + "'\n";
		
			 		body += "translation='" 
			 			+ bioMightTransform.getTranslation().getXPos() + " " 
						+ bioMightTransform.getTranslation().getYPos() + " "
						+ bioMightTransform.getTranslation().getZPos() + "'\n";
				
	
					 					
					body +=  "scale='" 	+ bioMightTransform.getScale().getXPos() + " "
					 				+ bioMightTransform.getScale().getYPos() + " "
					 				+ bioMightTransform.getScale().getZPos() + "'\n";
					 		
					 				
					body +=  "rotation='" + bioMightTransform.getOrientation().getXAxis() + " "
								+ bioMightTransform.getOrientation().getYAxis()  + " "
								+ bioMightTransform.getOrientation().getZAxis()  + " "
								+ bioMightTransform.getOrientation().getDegrees() + "'>\n\n";
						
					
				 				
					body +=  "<Shape DEF='SHAPE_" + bioMightTransform.getId() + "' \n" +
							" containerField='children'>\n" +
							" <Appearance\n" +
							"  containerField='appearance'>\n";
				
				
					body+= " <ImageTexture containerField='texture' " +
						    " url='../images/SpeckledGreen.png'/>";
					
					    
					 body+= " <Material DEF='Rust'\n" +
							    "containerField='material'\n" +
							    "ambientIntensity='" + bioMightTransform.getMaterial().getAmbientIntensity() + "'\n" +
							    "shininess='" 		 + bioMightTransform.getMaterial().getShininess() + "'\n" +
							    "transparency='" 	 + bioMightTransform.getMaterial().getTransparency() + "'\n" +
							    "diffuseColor='" + 
							    bioMightTransform.getMaterial().getDiffuseColor().getRed() + " " + 
							    bioMightTransform.getMaterial().getDiffuseColor().getGreen() + " " +
							    bioMightTransform.getMaterial().getDiffuseColor().getBlue() + "'/>\n" +
							    "</Appearance>\n" +
							 	"<Cylinder DEF='MembraneTubule'\n" +
							 	"containerField='geometry'\n" +
							 	"radius='" + bioMightTransform.getRadius() +"'\n" +
							 	"height='" + bioMightTransform.getHeight() +"'/>\n" +
							 	"</Shape>\n" +
	
					 "</Transform>\n";
				}
				else if (parentID.contains(Constants.AIDSVirusRef))
				{
					
					System.out.println("Getting X3D -InternalView - for MembraneTubule - AIDSVirus");
		
											
					//**********************************************************
					// Creates a Spike at a specific position
					//**********************************************************

					double radius = bioMightTransform.getRadius();					
				  	double dendriteRadius = 0.05;		
					double minRadius = 0.02;
					double orbitalRadius  = 0.025;
	
					bioMightTransform.setRadius(dendriteRadius);
					bioMightTransform.setTextureID(6);
					bioMightTransform.setTextureFile("SpeckledRed.png");
					
					// Pass the instructions to the builder
					double[] taperPoint = {0.25, 0.50};
					double[] taperValue = {radius, radius/3};
					int minAppendages =  6;
					int maxAppendages = 6;
					
					System.out.println("Generating AIDSVirusSpike with Appendage Radius: " + dendriteRadius + "  orbital " + radius);
					minRadius = 0.02;
					double maxRadius = 0.25;
					
						
					// This one works, but need to accomodate quadrants
					angleLatitude = MathUtils.round(Math.toDegrees(
							Math.atan2(bioMightTransform.getTranslation().getZPos(), 
										bioMightTransform.getTranslation().getXPos()  )), 2);
		
					angleLongitude = MathUtils.round(Math.toDegrees(Math.acos(bioMightTransform.getTranslation().getYPos() / 0.5)), 2);

					if (angleLatitude < 0)
						angleLatitude = 360 + angleLatitude;
					
					System.out.println("Orient Appendage     ----     Lat: " + angleLatitude + "  Long: " + angleLongitude);
														
					// Create the 1st spike
					BioMightAppendage bioMightAppendage = new BioMightAppendage("GlycoProtein Spike", Constants.AIDSVirus, orbitalRadius, minRadius, maxRadius, dendriteRadius, taperPoint,
							taperValue, minAppendages, maxAppendages,
							angleLatitude, angleLongitude, 0, 5, 0, 5, bioMightTransform.getTextureID(), bioMightTransform.getTextureFile());
		 	
					
					body +=BioWebX3DUtils.generateAppendage(bioMightAppendage, bioMightTransform);

					//body += "</Transform>\n";
				}
	
							
				
			}

			
		}	
		// This is for when we are going to deal with the collection data separately.  Like
		// when we do not want to access the sub components.
		else if (viewPerspective == Constants.VIEW_INTERNAL)
		{	
			System.out.println("Assembling X3D for MembraneTubules InternalView - size: " + membraneTubules.size());
			//if (Constants.VIEW_INTERNAL)
			
			lod = Constants.MAG1X;
			if (lod == Constants.MAG2X) {
				// Run through the collection of MembraneTubules and assemble the X3D for each
				for (int i=0; i<membraneTubules.size(); i++)
				{
					// Force the level to grab the individual elements
					// Get the information for the virusTailFiber
					MembraneTubule membraneTubule = (MembraneTubule) membraneTubules.get(i);
					System.out.println("Getting X3D for HACKY SAKIE  MembraneTubule: " + membraneTubule.getComponentID());
					body += membraneTubule.getX3D(true);
				}
			}
			else if (lod == Constants.MAG1X) {
				
				
				double angleLongitude = 0.0;
				double angleLatitude = 0.0;
			
				ArrayList transforms = bioMightTransforms.getTransforms();
				for (int i=0; i<transforms.size(); i++)
				{
					// Get the information for the capsomer we are creating
					BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
					System.out.println("Getting X3D -InternalView - for MembraneTubule: " + bioMightTransform.getName() + "  " + bioMightTransform.getId() + "parent: " + parentID);				
						
					//System.out.println("Getting X3D for MembraneTubuleX: " + bioMightTransform.getTranslation().getXPos());
					//System.out.println("Getting X3D for MembraneTubuleY: " + bioMightTransform.getTranslation().getYPos());
					//System.out.println("Getting X3D for MembraneTubuleZ: " + bioMightTransform.getTranslation().getZPos());
					// Change the height and width based on the displacement.
						
					if (parentID.contains(Constants.InfluenzaAVirusRef))
					{
						System.out.println("Getting X3D -InternalView - for MembraneTubule - InfluenzaAVirus");
						
						body += "<Transform  onmouseover=\"showComponent('" + "MembraneTubule" +  "');\"  DEF='" + bioMightTransform.getId() + "'\n";
						
						// Set the position if we are working with the Tissue collection
				 		body += "translation='" 
				 			+ bioMightTransform.getTranslation().getXPos() + " " 
	 						+ bioMightTransform.getTranslation().getYPos() + " "
	 						+ bioMightTransform.getTranslation().getZPos() + "'\n";					
						
						 					
						body +=  "scale='" 	+ bioMightTransform.getScale().getXPos() + " "
						 				+ bioMightTransform.getScale().getYPos() + " "
						 				+ bioMightTransform.getScale().getZPos() + "'\n";
		
		
						body +=  "rotation='" + bioMightTransform.getOrientation().getXAxis() + " "
								+ bioMightTransform.getOrientation().getYAxis()  + " "
								+ bioMightTransform.getOrientation().getZAxis()  + " "
								+ bioMightTransform.getOrientation().getDegrees() + "'>\n\n" ;
			
						 				
						body +=  "<Shape DEF='SHAPE_" + bioMightTransform.getId() + "' \n" +
								" containerField='children'>\n" +
								" <Appearance\n" +
								"  containerField='appearance'>\n";
		
					
						body+= " <ImageTexture containerField='texture' " +
						    " url='../images/SpeckledGreen.png'/>";
						
						    
						 body+= " <Material DEF='Rust'\n" +
								    "containerField='material'\n" +
								    "ambientIntensity='" + bioMightTransform.getMaterial().getAmbientIntensity() + "'\n" +
								    "shininess='" 		 + bioMightTransform.getMaterial().getShininess() + "'\n" +
								    "transparency='" 	 + bioMightTransform.getMaterial().getTransparency() + "'\n" +
								    "diffuseColor='" + 
								    bioMightTransform.getMaterial().getDiffuseColor().getRed() + " " + 
								    bioMightTransform.getMaterial().getDiffuseColor().getGreen() + " " +
								    bioMightTransform.getMaterial().getDiffuseColor().getBlue() + "'/>\n" +
								    "</Appearance>\n" +
								 	"<Cylinder DEF='MembraneTubuleGeoSphere'\n" +
								 	"containerField='geometry'\n" +
								 	"radius='" + bioMightTransform.getRadius() +"'\n" +
								 	"height='" + bioMightTransform.getHeight() +"'/>\n" +
								 	"</Shape>\n" +
	
			
						 "</Transform>\n";
					}
					else if (parentID.contains(Constants.AIDSVirusRef))
					{
						
						System.out.println("Getting X3D -InternalView - for MembraneTubule - AIDSVirus");
			
												
						//**********************************************************
						// Creates a Spike at a specific position
						//**********************************************************

						double radius = bioMightTransform.getRadius();					
					  	double dendriteRadius = 0.05;		
						double minRadius = 0.02;
						double orbitalRadius  = 0.025;
		
						bioMightTransform.setRadius(dendriteRadius);
						bioMightTransform.setTextureID(6);
						bioMightTransform.setTextureFile("SpeckledRed.png");
						
						// Pass the instructions to the builder
						double[] taperPoint = {0.25, 0.50};
						double[] taperValue = {radius, radius/3};
						int minAppendages =  6;
						int maxAppendages = 6;
						
						System.out.println("Generating AIDSVirusSpike with Appendage Radius: " + dendriteRadius + "  orbital " + radius);
						minRadius = 0.02;
						double maxRadius = 0.25;
						
							
						// This one works, but need to accomodate quadrants
						angleLatitude = MathUtils.round(Math.toDegrees(
								Math.atan2(bioMightTransform.getTranslation().getZPos(), 
											bioMightTransform.getTranslation().getXPos()  )), 2);
			
						angleLongitude = MathUtils.round(Math.toDegrees(Math.acos(bioMightTransform.getTranslation().getYPos() / 0.5)), 2);

						if (angleLatitude < 0)
							angleLatitude = 360 + angleLatitude;
						
						System.out.println("Orient Appendage     ----     Lat: " + angleLatitude + "  Long: " + angleLongitude);
															
						// Create the 1st spike
						BioMightAppendage bioMightAppendage = new BioMightAppendage("GlycoProtein Spike", Constants.AIDSVirus, orbitalRadius, minRadius, maxRadius, dendriteRadius, taperPoint,
								taperValue, minAppendages, maxAppendages,
								angleLatitude, angleLongitude, 0, 5, 0, 5, bioMightTransform.getTextureID(), bioMightTransform.getTextureFile());
			 	
						
						body +=BioWebX3DUtils.generateAppendage(bioMightAppendage, bioMightTransform);

						//body += "</Transform>\n";
					}
					
				}
			}			

		
		}

		
		
		body+= "<Viewpoint DEF='Viewpoint_MembraneTubules'\n" +
				 "description='Viewpoint1'\n" +
				 "jump='true'\n" +
				 "fieldOfView='0.785'\n" +
				 "position='0.0 0.0 2.0'\n" +
				 "orientation='0 0 1 0'/>\n";
		
		//System.out.println("MembraneTubules X3D: " + body);		
		String footer = "</Scene>" + "</X3D>\n";
		
		if (snipet)
			return body;			
		else	
			return header + body + footer;
	}

	
	/******************************************************************************************
	 * EXECUTE METHODS 
	 *
	 ******************************************************************************************/
	public void executeMethods(ArrayList<BioMightMethodView> bioMightMethods) {

		// Run through the argument list and executes the 
		// associated methods
		boolean fired = false;
		System.out.println("MembraneTubules-Executing Methods: " + bioMightMethods.size());
		for (int j=0; j<bioMightMethods.size(); j++){
			
			// Get the parameter from the list and if it is not
			// empty execute the associated method using it
			BioMightMethodView bioMightMethod = (BioMightMethodView) bioMightMethods.get(j);
			System.out.println("Have BioMightMethod for MembraneTubules: " + bioMightMethod.getMethodName());	
			String methodName = bioMightMethod.getMethodName();
			String canonicalName = bioMightMethod.getCanonicalName(); 
			String dataType = bioMightMethod.getDataType();
			String methodParam = bioMightMethod.getMethodParameter(); 
			if (methodParam == null)
				methodParam = "";
			
			// We only execute those methods that are targeted for the IRIS
			// If a parameter is specified then we fire the method, otherwise
			// we just jump over it
			if (canonicalName.equals(Constants.MembraneTubules)) {				
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
				System.out.println("MembraneTubules - Methods have fired.   Calling MembraneTubules Save method!");
			}
		}
	}

	

	/******************************************************************************************
	 * SET COLONY SIZE 
	 *
	 * This method will set the Colony size for the MembraneTubules.  
	 *****************************************************************************************/
	public void setColonySize(int size) {

		// Run through the argument list and executes the 
		// associated methods
		boolean fired = false;
		System.out.println("MembraneTubules-SetColony Size: " + size);
		
		// Generate the MembraneTubule		
		BioMightCellularBeanLocal bioMightBean;
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Generating the MembraneTubule Colony: " + componentID + "    " + parentID);
			InitialContext ctx = new InitialContext();
			//bioMightBean = (BioMightCellularBeanLocal) ctx.lookup("biomight.ejb.BioMightCellularBeanLocal");
			bioMightBean = (BioMightCellularBeanLocal) ctx.lookup("java:global/BioMightWeb/BioMightCellularBean!biomight.ejb.BioMightCellularBeanLocal");
	
			double currentPoints[][] = null;
		//	int success = bioMightBean.generateMembraneTubules(size, "MembraneTubule:00001", "MembraneTubule", 
		//		"MembraneTubule", this.componentID, this.parentID, currentPoints);
			
			System.out.println("Created MembraneTubule Info using EJB");   	
		}catch (Exception e) { 
			System.out.println("Exception Creating Colony - MembraneTubule");
			throw new ServerException("Remote Exception MembraneTubuleEpithelium():", e); 	
		}
	}
	
}
