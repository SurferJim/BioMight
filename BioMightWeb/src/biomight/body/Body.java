/*
 * Created on Jul 8, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.body;

import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;

import javax.naming.Context;
import javax.naming.InitialContext;

import biomight.BioMightBase;
import biomight.Constants;
import biomight.body.arm.Arms;
import biomight.body.arm.ForeArms;
import biomight.body.female.LeftBreast;
import biomight.body.female.RightBreast;
import biomight.body.female.Vagina;
import biomight.body.foot.Feet;
import biomight.body.hand.Hands;
import biomight.body.head.Head;
import biomight.body.hip.Hip;
import biomight.body.hip.Hips;
import biomight.body.leg.Knees;
import biomight.body.leg.cnemis.Cnemes;
import biomight.body.leg.thigh.Thighs;
import biomight.body.male.Genitals;
import biomight.body.neck.Neck;
import biomight.body.organ.stomach.Stomach;
import biomight.cell.bloodandimmune.AnimalCells;
import biomight.ejb.BioMightBeanLocal;
import biomight.ejb.BioMightBeanLocal;
import biomight.exceptions.ServerException;
import biomight.util.BioGraphics;
import biomight.view.BioMightBoundBox;
import biomight.view.BioMightBoundBoxes;
import biomight.view.BioMightConnector;
import biomight.view.BioMightConnectors;
import biomight.view.BioMightConstruct;
import biomight.view.BioMightGenerate;
import biomight.view.BioMightMethodView;
import biomight.view.BioMightPosition;
import biomight.view.BioMightPropertyView;
import biomight.view.BioMightScale;
import biomight.view.BioMightTransform;
import biomight.view.BioMightTransforms;
import biomightweb.util.BioWebUtils;


/*********************************************************************************
 * @author SurferJim
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 **********************************************************************************/

public class Body extends BioMightBase {
	ArrayList<BioMightPropertyView> localBioMightProperties;
	private ArrayList colors;

	// Basic Characteristics
	
	private String model = "Human";
	//private String model = "Ape";
	//private String model "Mutant";
	
	private double weight;
	private int age;

	// Male, Female, Transgender
	private String gender;

	private String ethnicity;

	// Endo, Ecto, Meso
	private String bodyType;

	// action properties
	private boolean isTalking;
	private boolean isSinging;
	private boolean isWhistling;
	private boolean isCrying;
	private boolean isSpitting;
	private boolean isDigesting;
	private boolean isRespiring;
	private boolean isSecreting;
	private boolean isSwallowing;
	private boolean isBurping;
	private boolean isFarting;
	private boolean isGrowing;
	private boolean isDying;
	private boolean isShivering;
	private boolean isShaking;
	private boolean isDancing;
	private boolean isJumpimg;
	private boolean isWalking;
	private boolean isRunning;
	private boolean isJogging;
	private boolean isStandingErect;
	private boolean isStandingSlouched;

	private Anus anus;
	private LeftBreast leftBreast;
	private RightBreast rightBreast;
	private LeftNipple leftNipple;
	private RightNipple rightNipple;

	private Head head;
	private Neck neck;
	private Chest chest;
	private Hips hips;
	private Abdomen abdomen;
	private Navel navel;
	private Back back;
	private Shoulders shoulders;
	private Arms arms;
	private ForeArms foreArms;
	private Wrists wrists;
	private Elbows elbows;
	private Hands hands;

	//private RightForeArm rightForeArm;
	//private LeftForeArm leftForeArm;
	//private LeftWrist leftWrist;
	//private RightWrist rightWrist;
	//private RightHand rightHand;
	//private LeftHand leftHand;

	private Hip hip;
	private Genitals genitals;
	private Vagina vagina;
	private Buttocks buttocks;

	private Thighs thighs;
	private Knees knees;
	//private Legs legs;
	private Cnemes cnemes;
	private Feet feet;
	
	//private RightKnee rightKnee;	
	//private LeftKnee leftKnee;	
	//private RightCnemis rightCnemis;	
	//private LeftCnemis leftCnemis;	

	//private Feet feet;
	//private LeftFoot leftFoot;
	//private RightFoot rightFoot;

	/************************************************************************
	 * BODY Constructor 
	 *
	 ***********************************************************************/
	public Body() {
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, Constants.Body, null, null);
	}

	/************************************************************************
	 * BODY Constructor 
	 *
	 ***********************************************************************/
	public Body(String parentID) {
		System.out.print("Calling parameterized BODY Constructor!");
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, parentID, null, null);
	}


	/************************************************************************
	 * BODY Constructor 
	 *
	 ***********************************************************************/
	
	public Body(int hierarchy, int LOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
	{
		System.out.println("Calling BODY with LOD!");
		create(hierarchy, LOD, parentID, bioMightProperties, bioMightMethods);
	}
	
	
	/************************************************************************
	 * CREATE - BODY
	 *
	 ***********************************************************************/

	public void create(int hierarchy, int LOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods) 
	{
		this.setImage("images/humanBody1.jpg");
		localBioMightProperties	 = bioMightProperties;
		
		String bodyID = "Body:1";
		System.out.println("Creating Body for: " + bodyID  +  "   "  + parentID);
		
		// If we have initialization parameters from the form, 
		//  then apply them before constructing the objects.
		if (bioMightMethods != null){
			System.out.println("NEED TO EXECUTE BODY METHODS: " + bioMightMethods.size());
			//executeMethods(bioMightMethods);
		}

		// Set up a Constructor that will be used to pass informatino into the components
		//BioMightConstruct bioConstruct = new BioMightConstruct(); 
		//HashMap boundingBoxes = null;
		
		// Get the material data from the database and store this in the session
		try {
 			Context ctx = new InitialContext(); 
			BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
			// Get the color map
			//colors = bioMightBean.getMaterials();
			
			// Either Create a new body based on the parameters that the user entered
			// or get an existing Body model from the database
			//if (bioMightProperties == null) {
		
				// This is the default instance where we grab the BoundBox information
				// from the database via the Enterprise Bean as is and do 		
				//System.out.println("Properties null - Getting BoundBoxes for Default Body:1");
				//BioMightTransforms bioMightBBTransforms = bioMightBean.getComponentsByParent("Body:1");	
				//ArrayList bbTransforms = bioMightBBTransforms.getTransforms();
				
				//System.out.println("Loading " + bbTransforms.size() + " BoundBoxes from Tranform objects");
				//for (int j=0; j<bbTransforms.size(); j++)
				//{
					// Get the information for the Body we are creating
					//BioMightTransform bioMightTransform = (BioMightTransform) bbTransforms.get(j);
					//String bbParentID = bioMightTransform.getId();
				
					// put the position, dimenions data into the property objects
					//bioMightPropertyView = new BioMightPropertyView();
					//bioMightPropertyView.setPropertyName(bbParentID);
					//bioMightPropertyView.setCanonicalName("");
			
					//bioMightPropertyView.setPropertyScale(new BioMightScale(bioMightTransform.getBoundBoxStr()));
									
					//propertyViewMap.put(bbParentID, bioMightPropertyView);
					//System.out.println("Loaded BBProp into HashMap : " + j + "  " + bioMightPropertyView.getPropertyName()  + "  " +  bioMightPropertyView.getPropertyScale());
				//}
	
				//System.out.println("Have BoundBoxes from EJB");		
			//}
			//else
			//{		
				// Get the input parameters that were supplied by the user
				// via the web interface to create or modify the body, validate, and then 
				// pass the user parameters to the Bound Box method
				// and get the Bounding Boxes for the body components

				// Store the order-bound properties into a collection so we can easily access elements below.
				//System.out.println("Loading BoundBoxParams #size " + bioMightProperties.size());
				//for (int j=0; j<bioMightProperties.size(); j++)
				//{
				//	bioMightPropertyView = (BioMightPropertyView) bioMightProperties.get(j);  
				//	propertyViewMap.put(bioMightPropertyView.getPropertyName(), bioMightPropertyView);
				//	System.out.println("Loaded Prop into HashMap : " + j + "  " + bioMightPropertyView.getPropertyName() + "  " +  bioMightPropertyView.getPropertyScale());
				//}
			
			//}
			
			// The data that comes from the database is already in basic BoundBox form
			// It consists of 8 vertices, enough to create a basic box. The data that comes from
			// the interface will be used to create the 8 points that are stored in the database
			// The Advance mode will allow one to work directy with the mesh points, while regular mode
			// will work in spatial distances )LxWxH)
			
			//  Send the raw data into the the BoundBox routine
			
			//boundingBoxes = setupBoundBoxes(propertyViewMap);
			//System.out.println("Bounding Boxes for Body Created");
			
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Getting BodyInfo for BodyID: " + bodyID);
			bioMightTransforms  = bioMightBean.getComponents(Constants.BodyRef, parentID);	
		}
		catch (Exception e) { 
			System.out.println("Exception Getting Components - Body");
			throw new ServerException("Remote Exception getComponents():", e); 	
		}
		
		int localVP = Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		boolean bStored = false;
		
		BioMightScale bioScale = new BioMightScale("0.00, 0.00, 0.00");
		BioMightPosition  bioPos = new BioMightPosition("0.00, 0.00, 0.00");
		String bioTemplate="Body.x3d";
		
		// Run through the collection of DigestiveSystems and build them into the model
		// In the default case, we get one instance of the DigestiveSystem for each eye
		ArrayList transforms = bioMightTransforms.getTransforms();
		System.out.println("Body NumTransforms: " + transforms.size());	
		for (int i=0; i<transforms.size(); i++)
		{
			// Get the information for the Body we are creating
			BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
			parentID = bioMightTransform.getId();
					
			System.out.println("Creating Body: " + bioMightTransform.getName() + "  " + parentID);
			System.out.println("Creating Body at Position: " + bioMightTransform.getTranslation().getXPos() 
			+ bioMightTransform.getTranslation().getYPos() + "  " + bioMightTransform.getTranslation().getZPos());
			
			// Get the Properties that the user set in the page last time we were in	
			// We will use the enable flag to see what should be turned on/off
			ArrayList<BioMightPropertyView> bioMightStoredProperties;
			try {
				// Get the information from the database via the Enterprise Bean		
				System.out.println("Getting Property info for Body: " + bioMightTransform.getId());
				InitialContext ctx = new InitialContext();
				BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
				bioMightStoredProperties = bioMightBean.getComponentProps(bioMightTransform.getId());
				System.out.println("Have Body Property Info from EJB - NumProps: " + bioMightStoredProperties.size());   	
			}catch (Exception e) { 
				System.out.println("Exception Getting Components Properties - Body");
				throw new ServerException("Remote Exception getComponents():", e); 	
			} 
					
			// If localProperties are null, meaning we are coming into the screen from somewhere
			// else, then use the storedProperties
			if (localBioMightProperties == null || localBioMightProperties.size() == 0)
			{
				System.out.println("In Body - BioMightLocalProperties are Null");
				localBioMightProperties = bioMightStoredProperties;
				System.out.println("Using Property Data from Database");
				bStored = true;
			}
			else
			{
				System.out.println("In Body - BioMightLocalProperties - Size is: " + localBioMightProperties.size());
			}
			
			// CREATE HEAD	
			// Create and Load Constructor object
			System.out.println("In Body - Creating Head");
			//bioConstruct = new BioMightConstruct(); 
			//bioConstruct.setBoundingBox(Constants.HeadRef,(BioMightBoundBox)boundingBoxes.get(Constants.HeadRef));		
			head = new Head(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);

			// Get the Generate Object Map that was created by Head  during construction
			BioMightGenerate bioGenHead = head.getBioMightGenerate(); 
			//BioMightBoundBox tempboundingBox = bioConstruct.getBoundingBox(Constants.HeadRef);
			//if (tempboundingBox  != null) {
			//	bioScale = new  BioMightScale(tempboundingBox.getXVector().doubleValue(), tempboundingBox.getYVector().doubleValue(), tempboundingBox.getZVector().doubleValue());
			//	bioPos = new  BioMightPosition(tempboundingBox.getXPos().doubleValue(),  tempboundingBox.getYPos().doubleValue(), tempboundingBox.getZPos().doubleValue()) ;
			//}
			//bioTemplate = "HeadRound, HeadOval, HeadSquared, Head";		
			initProperty(Constants.HeadRef, Constants.Head, Constants.HeadRef, head.getComponentID(), bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, BioWebUtils.isViewEnabled(Constants.HeadRef, localBioMightProperties));
			
			// CREATE NECK 
			// Create and Load Constructor object
			System.out.println("In Body - Creating Neck");
			//bioConstruct = new BioMightConstruct(); 
			//bioConstruct.setBoundingBox(Constants.NeckRef, (BioMightBoundBox)boundingBoxes.get(Constants.NeckRef));			
			//neck = new Neck(parentID, bioConstruct, bioMightMethods);
			neck = new Neck(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);		
			// Get the Generate Object Map that was created by Neck  during construction
			BioMightGenerate bioGenNeck = neck.getBioMightGenerate(); 
			//tempboundingBox = bioConstruct.getBoundingBox(Constants.NeckRef);
			//if (tempboundingBox  != null) {
			//	bioScale = new  BioMightScale(tempboundingBox.getXVector().doubleValue(), tempboundingBox.getYVector().doubleValue(), tempboundingBox.getZVector().doubleValue());
			//	bioPos = new  BioMightPosition(tempboundingBox.getXPos().doubleValue(),  tempboundingBox.getYPos().doubleValue(), tempboundingBox.getZPos().doubleValue()) ;
			//}			
			initProperty(Constants.NeckRef, Constants.Neck, Constants.NeckRef, neck.getComponentID(), bioPos, bioScale, Constants.SINGLE_COMPONENT,  bioTemplate, BioWebUtils.isViewEnabled(Constants.NeckRef, localBioMightProperties));
			System.out.println("Neck is created");
		
			
			// CREATE CHEST
			// Set the Bounding Box for the Chest
			System.out.println("In Body - Creating Chest");
			//bioConstruct = new BioMightConstruct();
			//bioConstruct.setBoundingBox(Constants.ChestRef, (BioMightBoundBox)boundingBoxes.get(Constants.ChestRef));			
			//chest = new Chest(parentID, bioConstruct, bioMightMethods);
			chest = new Chest(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
				
			//BioMightGenerate bioGenChest = chest.getBioMightGenerate(); 
			//tempboundingBox = bioConstruct.getBoundingBox(Constants.ChestRef);
			//if (tempboundingBox  != null) {
			//	bioScale = new  BioMightScale(tempboundingBox.getXVector().doubleValue(), tempboundingBox.getYVector().doubleValue(), tempboundingBox.getZVector().doubleValue());
			//	bioPos = new  BioMightPosition(tempboundingBox.getXPos().doubleValue(),  tempboundingBox.getYPos().doubleValue(), tempboundingBox.getZPos().doubleValue()) ;
			//}
			initProperty(Constants.ChestRef, Constants.Chest, Constants.ChestRef, chest.getComponentID(), bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, BioWebUtils.isViewEnabled(Constants.ChestRef, localBioMightProperties));								
			System.out.println("Chest is created");	
			
			
			// CREATE BACK
			// Set the Bounding Box for the Back
			//System.out.println("In Body - Creating Back");
			//bioConstruct = new BioMightConstruct();
			//bioConstruct.setBoundingBox(Constants.BackRef, (BioMightBoundBox)boundingBoxes.get(Constants.BackRef));			
			//back = new Back(parentID, bioConstruct, bioMightMethods);
			//back = new Back(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
			
			
			//BioMightGenerate bioGen = back.getBioMightGenerate(); 
			//tempboundingBox = bioConstruct.getBoundingBox(Constants.BackRef);
			//if (tempboundingBox  != null) {
			//	bioScale = new  BioMightScale(tempboundingBox.getXVector().doubleValue(), tempboundingBox.getYVector().doubleValue(), tempboundingBox.getZVector().doubleValue());
			//	bioPos = new  BioMightPosition(tempboundingBox.getXPos().doubleValue(),  tempboundingBox.getYPos().doubleValue(), tempboundingBox.getZPos().doubleValue()) ;
			//}
			//initProperty(Constants.BackRef, Constants.Back, Constants.BackRef, back.getComponentID(), bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, BioWebUtils.isViewEnabled(Constants.BackRef, localBioMightProperties));
			//System.out.println("Back is created");	
	
			
			// CREATE ABDOMEN
			// Where the Chest ends,so the Abdomen begins.   This information is gathered from
			// the generate  object and then passed into the neck constructor so that it
			// can position itself.  
			System.out.println("In Body - Creating Abdomen");
			//bioConstruct = new BioMightConstruct(); 
			//bioConstruct.setBoundingBox(Constants.AbdomenRef, (BioMightBoundBox)boundingBoxes.get(Constants.AbdomenRef));
			
			abdomen = new Abdomen(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
			//BioMightGenerate generatedAbdomen = abdomen.getBioMightGenerate();
			///tempboundingBox = bioConstruct.getBoundingBox(Constants.AbdomenRef);
			//	bioScale = new  BioMightScale(tempboundingBox.getXVector().doubleValue(), tempboundingBox.getYVector().doubleValue(), tempboundingBox.getZVector().doubleValue());
			//bioPos = new  BioMightPosition(tempboundingBox.getXPos().doubleValue(),  tempboundingBox.getYPos().doubleValue(), tempboundingBox.getZPos().doubleValue()) ;
	
			initProperty("Abdomen", Constants.Abdomen, Constants.AbdomenRef, abdomen.getComponentID(), bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, BioWebUtils.isViewEnabled(Constants.AbdomenRef, localBioMightProperties));
			System.out.println("Abdomen is created");

			// HIPS
			// Set the Bounding Box for the Hips
			//System.out.println("In Body - Creating Hips Constructor");
			//bioConstruct = new BioMightConstruct(); 
			// We are placing BoundingBoxes
			//bioConstruct.setBoundingBoxes(Constants.HipsRef, (BioMightBoundBoxes) boundingBoxes.get(Constants.HipsRef));			
			//System.out.println("In Body - Hips Constructor created");
			
			System.out.println("Creating Hips using ParentID: " + bioMightTransform.getId());
			//hips = new Hips(bioMightTransform.getId(), bioConstruct, bioMightMethods);
			hips = new Hips(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
			//BioMightGenerate generatedHips = hips.getBioMightGenerate(); 		
		
			//System.out.println("Setting up Parent Property");
			initProperty(Constants.HipsRef, Constants.Hips, Constants.HipsRef, hips.getComponentID(), "0.0, 0.0, 0.0", "0.0, 0.0, 0.0", Constants.PARENT_COMPONENT, BioWebUtils.isViewEnabled(Constants.HipsRef, localBioMightProperties));
			//grab the properties that were created in the collection
		
			//System.out.println("Setting up Children Property");		
			//bioMightPropertyView = (BioMightPropertyView) propertyViewMap.get(Constants.LeftHipRef);
			//initProperty(bioMightPropertyView.getPropertyName(), Constants.Hip, Constants.HipRef, bioMightPropertyView.getCanonicalName(), bioMightPropertyView.getPropertyPosition(), bioMightPropertyView.getPropertyScale(), Constants.CHILD_COMPONENT, bioTemplate,  false);
		
			//bioMightPropertyView = (BioMightPropertyView) propertyViewMap.get(Constants.RightHipRef);
			//initProperty(bioMightPropertyView.getPropertyName(), Constants.Hip, Constants.HipRef, bioMightPropertyView.getCanonicalName(), bioMightPropertyView.getPropertyPosition(), bioMightPropertyView.getPropertyScale(), Constants.CHILD_COMPONENT, bioTemplate,  false);
			
			// SHOULDERS
			// Set the Bounding Box for the Shoulders
			System.out.println("In Body - Creating Shoulders Constructor");
			//bioConstruct = new BioMightConstruct(); 
			// We are placing BoundingBoxes
			//bioConstruct.setBoundingBoxes(Constants.ShouldersRef, (BioMightBoundBoxes) boundingBoxes.get(Constants.ShouldersRef));			
			//System.out.println("In Body - Shoulders Constructor created");
			
			System.out.println("Creating Shoulders using ParentID: " + bioMightTransform.getId());
			shoulders = new Shoulders(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
			//BioMightGenerate generatedShoulders = shoulders.getBioMightGenerate(); 		
						
			//BioMightGenerate shoulderLeftGen = generatedShoulders.getMapComponent(Constants.LeftShoulderRef);
			//BioMightGenerate shoulderRightGen = generatedShoulders.getMapComponent(Constants.RightShoulderRef);
			//System.out.println("LeftShouldersMapConn are created: " + shoulderLeftGen.getConnectType());
			//System.out.println("RightShouldersMapConn are created: " + shoulderRightGen.getConnectType());
		
			//System.out.println("Setting up Property");
			
			//BioMightBoundBoxes tempboundingBoxes = bioConstruct.getBoundingBoxes(Constants.ShouldersRef);
			//if (tempboundingBoxes != null) {	
			//	tempboundingBox=tempboundingBoxes.getBoundingBox(Constants.LeftShoulderRef);
			//	if (tempboundingBoxes  != null) {	
			//		bioScale = new  BioMightScale(tempboundingBox.getXVector().doubleValue(), tempboundingBox.getYVector().doubleValue(), tempboundingBox.getZVector().doubleValue());
			//		bioPos = new  BioMightPosition(tempboundingBox.getXPos().doubleValue(),  tempboundingBox.getYPos().doubleValue(), tempboundingBox.getZPos().doubleValue()) ;
			//				}
			//	tempboundingBox=tempboundingBoxes.getBoundingBox(Constants.RightShoulderRef);
			//	if (tempboundingBoxes  != null) {
			//		bioScale = new  BioMightScale(tempboundingBox.getXVector().doubleValue(), tempboundingBox.getYVector().doubleValue(), tempboundingBox.getZVector().doubleValue());
			//		bioPos = new  BioMightPosition(tempboundingBox.getXPos().doubleValue(),  tempboundingBox.getYPos().doubleValue(), tempboundingBox.getZPos().doubleValue()) ;
			//	}
			//}
					
			initProperty(Constants.ShouldersRef, Constants.Shoulders, Constants.ShouldersRef, shoulders.getComponentID(), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate,  BioWebUtils.isViewEnabled(Constants.ShouldersRef, localBioMightProperties));
			//grab the properties that were created in the collection
			//ArrayList shoulderProps = shoulders.getProperties();
			//for (int k=0; k < shoulderProps.size(); k++)
			//{
			//	BioMightPropertyView bioMightPropertyView = (BioMightPropertyView) shoulderProps.get(k);
			//	initProperty(bioMightPropertyView.getPropertyName(), Constants.Shoulder, Constants.ShoulderRef, bioMightPropertyView.getCanonicalName(), bioMightPropertyView.getPropertyPosition(), bioMightPropertyView.getPropertyScale(),  Constants.CHILD_COMPONENT, false);
			//	System.out.println("Loaded property:" + bioMightPropertyView.getPropertyName());						
			//}
			System.out.println("Shoulders are created");
			
			
			// ARMS
			// Set the Bounding Box for the Arms
			//System.out.println("In Body - Creating Arms Constructor");
			//bioConstruct = new BioMightConstruct(); 
			// We are placing BoundingBoxes
			//bioConstruct.setBoundingBoxes(Constants.ArmsRef, (BioMightBoundBoxes) boundingBoxes.get(Constants.ArmsRef));			
			//System.out.println("In Body - Arms Constructor created");
			
			System.out.println("Creating Arms using ParentID: " + bioMightTransform.getId());
			arms = new Arms(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
			//BioMightGenerate generatedArms = arms.getBioMightGenerate(); 		

			//BioMightGenerate shoulderLeftGen = generatedArms.getMapComponent(Constants.LeftShoulderRef);
			//BioMightGenerate shoulderRightGen = generatedArms.getMapComponent(Constants.RightShoulderRef);
			//System.out.println("LeftArmsMapConn are created: " + shoulderLeftGen.getConnectType());
			//System.out.println("RightArmsMapConn are created: " + shoulderRightGen.getConnectType());
		
			//System.out.println("Setting up Property");
			
			//tempboundingBoxes = bioConstruct.getBoundingBoxes(Constants.ArmsRef);
			//if (tempboundingBoxes != null) {	
			//	tempboundingBox=tempboundingBoxes.getBoundingBox(Constants.LeftArmRef);
			//	if (tempboundingBoxes  != null) {	
			//		bioScale = new  BioMightScale(tempboundingBox.getXVector().doubleValue(), tempboundingBox.getYVector().doubleValue(), tempboundingBox.getZVector().doubleValue());
			//		bioPos = new  BioMightPosition(tempboundingBox.getXPos().doubleValue(),  tempboundingBox.getYPos().doubleValue(), tempboundingBox.getZPos().doubleValue()) ;
			//		}
			//	tempboundingBox=tempboundingBoxes.getBoundingBox(Constants.RightArmRef);
			//	if (tempboundingBoxes  != null) {
			//		bioScale = new  BioMightScale(tempboundingBox.getXVector().doubleValue(), tempboundingBox.getYVector().doubleValue(), tempboundingBox.getZVector().doubleValue());
			//		bioPos = new  BioMightPosition(tempboundingBox.getXPos().doubleValue(),  tempboundingBox.getYPos().doubleValue(), tempboundingBox.getZPos().doubleValue()) ;
			//	}
			//}
					
			initProperty(Constants.ArmsRef, Constants.Arms, Constants.ArmsRef, arms.getComponentID(), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate,  BioWebUtils.isViewEnabled(Constants.ArmsRef, localBioMightProperties));
			// grab the properties that were created in the collection
			//ArrayList armProps = arms.getProperties();
			//for (int k=0; k < armProps.size(); k++)
			//{
			//	BioMightPropertyView bioMightPropertyView = (BioMightPropertyView) armProps.get(k);
			//	initProperty(bioMightPropertyView.getPropertyName(), Constants.Arm, Constants.ArmRef, bioMightPropertyView.getCanonicalName(), bioMightPropertyView.getPropertyPosition(), bioMightPropertyView.getPropertyScale(),  Constants.CHILD_COMPONENT, false);
			//	System.out.println("Loaded property:" + bioMightPropertyView.getPropertyName());
			//}
		
			System.out.println("Arms are created");
			
			
			// FOREARMS
			// Set the Bounding Box for the ForeArms
			//System.out.println("In Body - Creating ForeArms Constructor");
			//bioConstruct = new BioMightConstruct(); 
			// We are placing BoundingBoxes
			//bioConstruct.setBoundingBoxes(Constants.ForeArmsRef, (BioMightBoundBoxes) boundingBoxes.get(Constants.ForeArmsRef));			
			//System.out.println("In Body - ForeArms Constructor created");
			
			System.out.println("Creating ForeArms using ParentID: " + bioMightTransform.getId());
			foreArms = new ForeArms(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
			//BioMightGenerate generatedForeArms = foreArms.getBioMightGenerate(); 		
							
			//BioMightGenerate shoulderLeftGen = generatedArms.getMapComponent(Constants.LeftShoulderRef);
			//BioMightGenerate shoulderRightGen = generatedArms.getMapComponent(Constants.RightShoulderRef);
			//System.out.println("LeftForeArmsMapConn are created: " + shoulderLeftGen.getConnectType());
			//System.out.println("RightForeArmsMapConn are created: " + shoulderRightGen.getConnectType());
		
			//System.out.println("Setting up Property");
			
			//tempboundingBoxes = bioConstruct.getBoundingBoxes(Constants.ForeArmsRef);
			//if (tempboundingBoxes != null) {	
			//	tempboundingBox=tempboundingBoxes.getBoundingBox(Constants.LeftForeArmRef);
			//	if (tempboundingBoxes  != null) {	
			//		bioScale = new  BioMightScale(tempboundingBox.getXVector().doubleValue(), tempboundingBox.getYVector().doubleValue(), tempboundingBox.getZVector().doubleValue());
			//		bioPos = new  BioMightPosition(tempboundingBox.getXPos().doubleValue(),  tempboundingBox.getYPos().doubleValue(), tempboundingBox.getZPos().doubleValue()) ;
			//	}
			//	tempboundingBox=tempboundingBoxes.getBoundingBox(Constants.RightForeArmRef);
			//	if (tempboundingBoxes  != null) {
			//		bioScale = new  BioMightScale(tempboundingBox.getXVector().doubleValue(), tempboundingBox.getYVector().doubleValue(), tempboundingBox.getZVector().doubleValue());
			//		bioPos = new  BioMightPosition(tempboundingBox.getXPos().doubleValue(),  tempboundingBox.getYPos().doubleValue(), tempboundingBox.getZPos().doubleValue()) ;
			//	}
			//}
					
			initProperty(Constants.ForeArmsRef, Constants.ForeArms, Constants.ForeArmsRef, foreArms.getComponentID(), bioPos, bioScale,  Constants.PARENT_COMPONENT, bioTemplate,  BioWebUtils.isViewEnabled(Constants.ForeArmsRef, localBioMightProperties));
			//grab the properties that were created in the collection
			//ArrayList foreArmProps = foreArms.getProperties();
			//for (int k=0; k < foreArmProps.size(); k++)
			//{
				//BioMightPropertyView bioMightPropertyView = (BioMightPropertyView) foreArmProps.get(k);
				//initProperty(bioMightPropertyView.getPropertyName(), Constants.ForeArm, Constants.ForeArmRef, bioMightPropertyView.getCanonicalName(), bioMightPropertyView.getPropertyPosition(), bioMightPropertyView.getPropertyScale(),  Constants.CHILD_COMPONENT, false);
				//System.out.println("Loaded property:" + bioMightPropertyView.getPropertyName());
			//}
			System.out.println("ForeArms are created");
			
			
			// ELBOWS
			// Set the Bounding Box for the Elbows
			System.out.println("In Body - Creating Elbows Constructor");
			//bioConstruct = new BioMightConstruct(); 
			// We are placing BoundingBoxes
			//bioConstruct.setBoundingBoxes(Constants.ElbowsRef, (BioMightBoundBoxes) boundingBoxes.get(Constants.ElbowsRef));			
			//System.out.println("In Body - Elbows Constructor created");
			
			System.out.println("Creating Elbows using ParentID: " + bioMightTransform.getId());
			elbows = new Elbows(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
			BioMightGenerate generatedElbows = elbows.getBioMightGenerate(); 		
		
			//BioMightGenerate elbowLeftGen = generatedElbows.getMapComponent(Constants.LeftShoulderRef);
			//BioMightGenerate elbowRightGen = generatedElbows.getMapComponent(Constants.RightShoulderRef);
			//System.out.println("LeftElbowsMapConn are created: " + elbowLeftGen.getConnectType());
			//System.out.println("RightElbowsMapConn are created: " + elbowRightGen.getConnectType());
		
			//System.out.println("Setting up Property");
			
			//tempboundingBoxes = bioConstruct.getBoundingBoxes(Constants.ElbowsRef);
			//if (tempboundingBoxes != null) {	
			//	tempboundingBox=tempboundingBoxes.getBoundingBox(Constants.LeftElbowRef);
			//	if (tempboundingBoxes  != null) {	
			//		bioScale = new  BioMightScale(tempboundingBox.getXVector().doubleValue(), tempboundingBox.getYVector().doubleValue(), tempboundingBox.getZVector().doubleValue());
			//		bioPos = new  BioMightPosition(tempboundingBox.getXPos().doubleValue(),  tempboundingBox.getYPos().doubleValue(), tempboundingBox.getZPos().doubleValue()) ;
			//	}
			//	tempboundingBox=tempboundingBoxes.getBoundingBox(Constants.RightElbowRef);
			//	if (tempboundingBoxes  != null) {
			//		bioScale = new  BioMightScale(tempboundingBox.getXVector().doubleValue(), tempboundingBox.getYVector().doubleValue(), tempboundingBox.getZVector().doubleValue());
			//		bioPos = new  BioMightPosition(tempboundingBox.getXPos().doubleValue(),  tempboundingBox.getYPos().doubleValue(), tempboundingBox.getZPos().doubleValue()) ;
			//	}
			//}
					
			initProperty(Constants.ElbowsRef, Constants.Elbows, Constants.ElbowsRef, elbows.getComponentID(), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate,  BioWebUtils.isViewEnabled(Constants.ElbowsRef, localBioMightProperties));
			//grab the properties that were created in the collection
			//ArrayList elbowProps = elbows.getProperties();
			//for (int k=0; k < elbowProps.size(); k++)
			//{
				//BioMightPropertyView bioMightPropertyView = (BioMightPropertyView) elbowProps.get(k);
				//initProperty(bioMightPropertyView.getPropertyName(), Constants.Elbow, Constants.ElbowRef, bioMightPropertyView.getCanonicalName(), bioMightPropertyView.getPropertyPosition(), bioMightPropertyView.getPropertyScale(),  Constants.CHILD_COMPONENT, false);
				//System.out.println("Loaded property:" + bioMightPropertyView.getPropertyName());
			//}
			System.out.println("Elbows are created");
			

			// WRISTS
			// Set the Bounding Box for the Wrists
			//System.out.println("In Body - Creating Wrists Constructor");
			//bioConstruct = new BioMightConstruct(); 
			// We are placing BoundingBoxes
			//bioConstruct.setBoundingBoxes(Constants.WristsRef, (BioMightBoundBoxes) boundingBoxes.get(Constants.WristsRef));			
			///System.out.println("In Body - Wrists Constructor created");
			
			System.out.println("Creating Wrists using ParentID: " + bioMightTransform.getId());
			wrists = new Wrists(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
			//BioMightGenerate generatedWrists = wrists.getBioMightGenerate(); 		
		
			//BioMightGenerate wristLeftGen = generatedElbows.getMapComponent(Constants.LeftShoulderRef);
			//BioMightGenerate wristRightGen = generatedElbows.getMapComponent(Constants.RightShoulderRef);
			//System.out.println("LeftWristsMapConn are created: " + wristLeftGen.getConnectType());
			//System.out.println("RightWristsMapConn are created: " + wristRightGen.getConnectType());

	
			//System.out.println("Setting up Property");
			
			//tempboundingBoxes = bioConstruct.getBoundingBoxes(Constants.WristsRef);
			//if (tempboundingBoxes != null) {	
			//	tempboundingBox=tempboundingBoxes.getBoundingBox(Constants.LeftWristRef);
			//	if (tempboundingBoxes  != null) {	
			//		bioScale = new  BioMightScale(tempboundingBox.getXVector().doubleValue(), tempboundingBox.getYVector().doubleValue(), tempboundingBox.getZVector().doubleValue());
			//		bioPos = new  BioMightPosition(tempboundingBox.getXPos().doubleValue(),  tempboundingBox.getYPos().doubleValue(), tempboundingBox.getZPos().doubleValue()) ;
			//	}
			//	tempboundingBox=tempboundingBoxes.getBoundingBox(Constants.RightWristRef);
			//	if (tempboundingBoxes  != null) {
			//		bioScale = new  BioMightScale(tempboundingBox.getXVector().doubleValue(), tempboundingBox.getYVector().doubleValue(), tempboundingBox.getZVector().doubleValue());
			//		bioPos = new  BioMightPosition(tempboundingBox.getXPos().doubleValue(),  tempboundingBox.getYPos().doubleValue(), tempboundingBox.getZPos().doubleValue()) ;
			//		}
			//}	
			//
			initProperty(Constants.WristsRef, Constants.Wrists, Constants.WristsRef, wrists.getComponentID(), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate,  BioWebUtils.isViewEnabled(Constants.WristsRef, localBioMightProperties));
			// grab the properties that were created by the individuals in the collection
			//ArrayList wristProps = wrists.getProperties();
			//for (int k=0; k < wristProps.size(); k++)
			//{
			//	BioMightPropertyView bioMightPropertyView = (BioMightPropertyView) wristProps.get(k);
			//	initProperty(bioMightPropertyView.getPropertyName(), Constants.Wrist, Constants.WristRef, bioMightPropertyView.getCanonicalName(), bioMightPropertyView.getPropertyPosition(), bioMightPropertyView.getPropertyScale(),  Constants.CHILD_COMPONENT, false);
			//	System.out.println("Loaded property:" + bioMightPropertyView.getPropertyName());
			//}
			System.out.println("Wrists are created");

			
			// HANDS
			// Set the Bounding Box for the Hands
			//System.out.println("In Body - Creating Hands Constructor");
			//bioConstruct = new BioMightConstruct(); 
			// We are placing BoundingBoxes
			//bioConstruct.setBoundingBoxes(Constants.HandsRef, (BioMightBoundBoxes) boundingBoxes.get(Constants.HandsRef));			
			//System.out.println("In Body - Hands Constructor created");
			
			System.out.println("Creating Hands using ParentID: " + bioMightTransform.getId());
			hands = new Hands(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
			BioMightGenerate generatedHands = hands.getBioMightGenerate(); 		
		
			//BioMightGenerate handLeftGen = generatedElbows.getMapComponent(Constants.LeftShoulderRef);
			//BioMightGenerate handRightGen = generatedElbows.getMapComponent(Constants.RightShoulderRef);
			//System.out.println("LeftHandMapConn are created: " + handLefandMapConn are created: " + handRightGen.getConnectType());
		
			//tempboundingBoxes = bioConstruct.getBoundingBoxes(Constants.HandsRef);
			//if (tempboundingBoxes != null) {	
			//	tempboundingBox=tempboundingBoxes.getBoundingBox(Constants.LeftHandRef);
			//	if (tempboundingBoxes  != null) {	
			//		bioScale = new  BioMightScale(tempboundingBox.getXVector().doubleValue(), tempboundingBox.getYVector().doubleValue(), tempboundingBox.getZVector().doubleValue());
			//		bioPos = new  BioMightPosition(tempboundingBox.getXPos().doubleValue(),  tempboundingBox.getYPos().doubleValue(), tempboundingBox.getZPos().doubleValue()) ;
			//	}
			//	tempboundingBox=tempboundingBoxes.getBoundingBox(Constants.RightHandRef);
			//	if (tempboundingBoxes  != null) {
			//		bioScale = new  BioMightScale(tempboundingBox.getXVector().doubleValue(), tempboundingBox.getYVector().doubleValue(), tempboundingBox.getZVector().doubleValue());
			//		bioPos = new  BioMightPosition(tempboundingBox.getXPos().doubleValue(),  tempboundingBox.getYPos().doubleValue(), tempboundingBox.getZPos().doubleValue()) ;
			//	}
			//}
					
			initProperty(Constants.HandsRef, Constants.Hands, Constants.HandsRef, hands.getComponentID(), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate,  BioWebUtils.isViewEnabled(Constants.HandsRef, localBioMightProperties));
			//grab the properties that were created by the individuals in the collection
			//ArrayList handProps = hands.getProperties();
			//for (int k=0; k < handProps.size(); k++)
			//{
			//	BioMightPropertyView bioMightPropertyView = (BioMightPropertyView) handProps.get(k);
			//	initProperty(bioMightPropertyView.getPropertyName(), Constants.Hand, Constants.HandRef, bioMightPropertyView.getCanonicalName(), bioMightPropertyView.getPropertyPosition(), bioMightPropertyView.getPropertyScale(), Constants.CHILD_COMPONENT, false);
			//	System.out.println("Loaded property:" + bioMightPropertyView.getPropertyName());
			//}
			System.out.println("Hands are created");
		
				
			// THIGHS
			// Set the Bounding Box for the ForeArms
			System.out.println("In Body - Creating Thighs Constructor");
			//bioConstruct = new BioMightConstruct(); 
			// We are placing BoundingBoxes
			//bioConstruct.setBoundingBoxes(Constants.ThighsRef, (BioMightBoundBoxes) boundingBoxes.get(Constants.ThighsRef));			
			System.out.println("In Body - Thighs Constructor created");
			
			System.out.println("Creating Thighs using ParentID: " + bioMightTransform.getId());
			thighs = new Thighs(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
			BioMightGenerate generatedThighs = thighs.getBioMightGenerate(); 		
		
			//BioMightGenerate shoulderLeftGen = generatedArms.getMapComponent(Constants.LeftShoulderRef);
			//BioMightGenerate shoulderRightGen = generatedArms.getMapComponent(Constants.RightShoulderRef);
			//System.out.println("LeftThighsMapConn are created: " + shoulderLeftGen.getConnectType());
			//System.out.println("RightThighsMapConn are created: " + shoulderRightGen.getConnectType());
		
			/*
			System.out.println("Setting up Property");
			tempboundingBoxes = bioConstruct.getBoundingBoxes(Constants.ThighsRef);
			if (tempboundingBoxes != null) {	
				tempboundingBox=tempboundingBoxes.getBoundingBox(Constants.LeftThighRef);
				if (tempboundingBoxes  != null) {
					bioScale = new  BioMightScale(tempboundingBox.getXVector().doubleValue(), tempboundingBox.getYVector().doubleValue(), tempboundingBox.getZVector().doubleValue());
					bioPos = new  BioMightPosition(tempboundingBox.getXPos().doubleValue(),  tempboundingBox.getYPos().doubleValue(), tempboundingBox.getZPos().doubleValue()) ;
				}
				tempboundingBox=tempboundingBoxes.getBoundingBox(Constants.RightThighRef);
				if (tempboundingBoxes  != null) {
					bioScale = new  BioMightScale(tempboundingBox.getXVector().doubleValue(), tempboundingBox.getYVector().doubleValue(), tempboundingBox.getZVector().doubleValue());
					bioPos = new  BioMightPosition(tempboundingBox.getXPos().doubleValue(),  tempboundingBox.getYPos().doubleValue(), tempboundingBox.getZPos().doubleValue()) ;
				}
			}		
			*/
			initProperty(Constants.ThighsRef, Constants.Thighs, Constants.ThighsRef, thighs.getComponentID(), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate,  BioWebUtils.isViewEnabled(Constants.ThighsRef, localBioMightProperties));
			//grab the properties that were created by the individuals in the collection
	
			System.out.println("Geting Thigh Properties----");
			
			/*
			ArrayList thighProps = thighs.getProperties();
			System.out.println("The # Thigh Properties: " +  thighProps.size());
			for (int k=0; k < thighProps.size(); k++)
			{
				System.out.println("Getting Thigh Properties for element: " + k);
								
				BioMightPropertyView bioMightPropertyView = (BioMightPropertyView) thighProps.get(k);
				//initProperty(bioMightPropertyView.getPropertyName(), Constants.Thigh, Constants.ThighRef, bioMightPropertyView.getCanonicalName(), bioMightPropertyView.getPropertyPosition(), bioMightPropertyView.getPropertyScale(), Constants.CHILD_COMPONENT,false);
				initProperty(bioMightPropertyView.getPropertyName(), Constants.Thigh, Constants.ThighRef, bioMightPropertyView.getCanonicalName(), bioMightPropertyView.getPropertyPosition(), "1.00, 1.00, 1.00", Constants.CHILD_COMPONENT,false);
				//initProperty(bioMightPropertyView.getPropertyName(), Constants.Thigh, Constants.ThighRef, bioMightPropertyView.getCanonicalName(), bioMightPropertyView.getPropertyPosition(), bioMightPropertyView.getPropertyScale(), Constants.CHILD_COMPONENT,false);

				System.out.println("Loaded property:" + bioMightPropertyView.getPropertyName());
			}
			System.out.println("Thighs are created");
			*/

			// KNEES
			// Set the Bounding Box for the Knees
			System.out.println("In Body - Creating Knees Constructor");
			//bioConstruct = new BioMightConstruct(); 
			// We are placing BoundingBoxes
			//bioConstruct.setBoundingBoxes(Constants.KneesRef, (BioMightBoundBoxes) boundingBoxes.get(Constants.KneesRef));			
			System.out.println("In Body - Knees Constructor created");
			
			System.out.println("Creating Knees using ParentID: " + bioMightTransform.getId());
			knees = new Knees(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
			BioMightGenerate generatedKnees = knees.getBioMightGenerate(); 		
		
			//BioMightGenerate shoulderLeftGen = generatedArms.getMapComponent(Constants.LeftShoulderRef);
			//BioMightGenerate shoulderRightGen = generatedArms.getMapComponent(Constants.RightShoulderRef);
			//System.out.println("LeftKneesMapConn are created: " + shoulderLeftGen.getConnectType());
			//System.out.println("RightKneesMapConn are created: " + shoulderRightGen.getConnectType());
		
			/*	
			System.out.println("Setting up Property");
			tempboundingBoxes = bioConstruct.getBoundingBoxes(Constants.KneesRef);
			if (tempboundingBoxes != null) {	
				tempboundingBox=tempboundingBoxes.getBoundingBox(Constants.LeftKneeRef);
				if (tempboundingBoxes  != null) {
					bioScale = new  BioMightScale(tempboundingBox.getXVector().doubleValue(), tempboundingBox.getYVector().doubleValue(), tempboundingBox.getZVector().doubleValue());
					bioPos = new  BioMightPosition(tempboundingBox.getXPos().doubleValue(),  tempboundingBox.getYPos().doubleValue(), tempboundingBox.getZPos().doubleValue()) ;
				}
				tempboundingBox=tempboundingBoxes.getBoundingBox(Constants.RightKneeRef);
				if (tempboundingBoxes  != null) {
					bioScale = new  BioMightScale(tempboundingBox.getXVector().doubleValue(), tempboundingBox.getYVector().doubleValue(), tempboundingBox.getZVector().doubleValue());
					bioPos = new  BioMightPosition(tempboundingBox.getXPos().doubleValue(),  tempboundingBox.getYPos().doubleValue(), tempboundingBox.getZPos().doubleValue()) ;
				}
			}		
			/*
			initProperty("Knees", Constants.Knees, Constants.KneesRef, knees.getComponentID(), bioPos, dimensions, Constants.PARENT_COMPONENT, false);
			//grab the properties that were created by the individuals in the collection
			ArrayList kneeProps = knees.getProperties();
			for (int k=0; k < kneeProps.size(); k++)
			{
				BioMightPropertyView bioMightPropertyView = (BioMightPropertyView) kneeProps.get(k);
				initProperty(bioMightPropertyView.getPropertyName(), Constants.Knee, Constants.KneeRef, bioMightPropertyView.getCanonicalName(), bioMightPropertyView.getPropertyPosition(), bioMightPropertyView.getPropertyScale(), Constants.CHILD_COMPONENT,  false);
				System.out.println("Loaded property:" + bioMightPropertyView.getPropertyName());
			}
			System.out.println("Knees are created");
			*/
			initProperty(Constants.KneesRef, Constants.Knees, Constants.KneesRef, knees.getComponentID(), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate,  BioWebUtils.isViewEnabled(Constants.KneesRef, localBioMightProperties));
			/*
			// CNEMES
			// Set the Bounding Box for the Cnemes
			System.out.println("In Body - Creating Cnemes Constructor");
			bioConstruct = new BioMightConstruct(); 
			// We are placing BoundingBoxes
			bioConstruct.setBoundingBoxes(Constants.CnemesRef, (BioMightBoundBoxes) boundingBoxes.get(Constants.CnemesRef));			
			System.out.println("In Body - Cnemes Constructor created");
			*/
			
			System.out.println("Creating Cnemes using ParentID: " + bioMightTransform.getId());
			cnemes = new Cnemes(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
			BioMightGenerate generatedCnemes = cnemes.getBioMightGenerate(); 		
		
			//BioMightGenerate shoulderLeftGen = generatedArms.getMapComponent(Constants.LeftShoulderRef);
			//BioMightGenerate shoulderRightGen = generatedArms.getMapComponent(Constants.RightShoulderRef);
			//System.out.println("LeftCnemesMapConn are created: " + shoulderLeftGen.getConnectType());
			//System.out.println("RightCnemesMapConn are created: " + shoulderRightGen.getConnectType());
		
			/*
			System.out.println("Setting up Property");
			tempboundingBoxes = bioConstruct.getBoundingBoxes(Constants.CnemesRef);
			if (tempboundingBoxes != null) {	
				tempboundingBox=tempboundingBoxes.getBoundingBox(Constants.LeftCnemisRef);
				if (tempboundingBoxes  != null) {
					bioScale = new  BioMightScale(tempboundingBox.getXVector().doubleValue(), tempboundingBox.getYVector().doubleValue(), tempboundingBox.getZVector().doubleValue());
					bioPos = new  BioMightPosition(tempboundingBox.getXPos().doubleValue(),  tempboundingBox.getYPos().doubleValue(), tempboundingBox.getZPos().doubleValue()) ;
				}
				tempboundingBox=tempboundingBoxes.getBoundingBox(Constants.RightCnemisRef);
				if (tempboundingBoxes  != null) {
					bioScale = new  BioMightScale(tempboundingBox.getXVector().doubleValue(), tempboundingBox.getYVector().doubleValue(), tempboundingBox.getZVector().doubleValue());
					bioPos = new  BioMightPosition(tempboundingBox.getXPos().doubleValue(),  tempboundingBox.getYPos().doubleValue(), tempboundingBox.getZPos().doubleValue()) ;
				}
			}
			*/		
			initProperty(Constants.CnemesRef, Constants.Cnemes, Constants.CnemesRef, cnemes.getComponentID(), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate,  BioWebUtils.isViewEnabled(Constants.CnemesRef, localBioMightProperties));
			/*
			//grab the properties that were created by the individuals in the collection
			ArrayList cnemisProps = cnemes.getProperties();
			for (int k=0; k < cnemisProps.size(); k++)
			{
				BioMightPropertyView bioMightPropertyView = (BioMightPropertyView) cnemisProps.get(k);
				initProperty(bioMightPropertyView.getPropertyName(), Constants.Cnemis, Constants.CnemisRef, bioMightPropertyView.getCanonicalName(), bioMightPropertyView.getPropertyPosition(), bioMightPropertyView.getPropertyScale(), Constants.CHILD_COMPONENT,false);
				System.out.println("Loaded property:" + bioMightPropertyView.getPropertyName());
			}
			****/
			System.out.println("Cnemes are created");
			
		
			// FEET
			// Set the Bounding Box for the Feet
			/*
			System.out.println("In Body - Creating Feet Constructor");
			bioConstruct = new BioMightConstruct(); 
			bioConstruct.setBoundingBoxes(Constants.FeetRef, (BioMightBoundBoxes) boundingBoxes.get(Constants.FeetRef));			
			System.out.println("In Body - Feets Constructor created");
			*/
			
			
			System.out.println("Creating Feet using ParentID: " + bioMightTransform.getId());
			feet = new Feet(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
			BioMightGenerate generatedFeet = feet.getBioMightGenerate(); 		
		
			//BioMightGenerate shoulderLeftGen = generatedArms.getMapComponent(Constants.LeftShoulderRef);
			//BioMightGenerate shoulderRightGen = generatedArms.getMapComponent(Constants.RightShoulderRef);
			//System.out.println("LeftKneesMapConn are created: " + shoulderLeftGen.getConnectType());
			//System.out.println("RightKneesMapConn are created: " + shoulderRightGen.getConnectType());
		
			
			
			/*
			System.out.println("Setting up Property");
			tempboundingBoxes = bioConstruct.getBoundingBoxes(Constants.FeetRef);
			if (tempboundingBoxes != null) {	
				tempboundingBox=tempboundingBoxes.getBoundingBox(Constants.LeftFootRef);
				if (tempboundingBoxes  != null) {
					bioScale = new  BioMightScale(tempboundingBox.getXVector().doubleValue(), tempboundingBox.getYVector().doubleValue(), tempboundingBox.getZVector().doubleValue());
					bioPos = new  BioMightPosition(tempboundingBox.getXPos().doubleValue(),  tempboundingBox.getYPos().doubleValue(), tempboundingBox.getZPos().doubleValue()) ;
				}
				tempboundingBox=tempboundingBoxes.getBoundingBox(Constants.RightFootRef);
				if (tempboundingBoxes  != null) {
					bioScale = new  BioMightScale(tempboundingBox.getXVector().doubleValue(), tempboundingBox.getYVector().doubleValue(), tempboundingBox.getZVector().doubleValue());
					bioPos = new  BioMightPosition(tempboundingBox.getXPos().doubleValue(),  tempboundingBox.getYPos().doubleValue(), tempboundingBox.getZPos().doubleValue()) ;
				}
			}
			*/
			
			initProperty(Constants.FeetRef, Constants.Feet, Constants.FeetRef, feet.getComponentID(), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate,  BioWebUtils.isViewEnabled(Constants.FeetRef, localBioMightProperties));
			//grab the properties that were created by the individuals in the collection
			/* ArrayList footProps = feet.getProperties();
			for (int k=0; k < cnemisProps.size(); k++)
			{
				BioMightPropertyView bioMightPropertyView = (BioMightPropertyView) footProps.get(k);
				initProperty(bioMightPropertyView.getPropertyName(), Constants.Foot, Constants.FootRef, bioMightPropertyView.getCanonicalName(), bioMightPropertyView.getPropertyPosition(), bioMightPropertyView.getPropertyScale(), Constants.CHILD_COMPONENT, false);
				System.out.println("Loaded property:" + bioMightPropertyView.getPropertyName());
			}
			*/
			System.out.println("Feet are created");
			
			genitals = new Genitals(parentID, bioMightMethods);
			//initProperty("Penis", Constants.Penis, Constants.PenisRef, penis.getComponentID());
			System.out.println("Genitals are created");
				
			/*
			navel  = new Navel();
			anus = new Anus();

			if (gender.equ
			als("Male"))
			{
				penis = new Penis();
			}
			else
			{
				leftBreast = new LeftBreast();
				rightBreast = new RightBreast();
				vagina = new Vagina();
			}
			 */
			
			
			if (localBioMightProperties != null && !bStored) {
				if (localBioMightProperties.size()>0) {
				// Store the Properties that the user set in the page	
				// We will use the enable flag to see what should be turned on/off
					try {
						// Get the information from the database via the Enterprise Bean		
						System.out.println("Setting Property info for Body: " + bioMightTransform.getId());
						InitialContext ctx = new InitialContext();
						BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
						int propSave = bioMightBean.insertComponentProps(bioMightTransform.getId(),
								Constants.BodyRef, bioMightTransform.getComponentName(), bioMightProperties);      
						System.out.println("Stored Body Property Info into EJB: " + propSave);   	
					}catch (Exception e) { 
						System.out.println("Exception Storing Components Properties - Body");
						throw new ServerException("Remote Exception insertComponentProps():", e); 	
					} 
				}
			}
	
		
		}
		
		//initProperties();
		initMethods();
		System.out.println("Created BODY  --- Returning");				
	}
	

	
	
	
	public void initProperties() {

		BioMightPropertyView property = new BioMightPropertyView();
		property.setPropertyName("Common");
		property.setCanonicalName(Constants.Title);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("Head");
		property.setCanonicalName(Constants.Head);
		property.setPropertyRef(Constants.HeadRef);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("Neck");
		property.setCanonicalName(Constants.Neck);
		property.setPropertyRef(Constants.NeckRef);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("Chest");
		property.setCanonicalName(Constants.Chest);
		property.setPropertyRef(Constants.ChestRef);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("Left Breast");
		property.setCanonicalName(Constants.LeftBreast);
		properties.add(property);
   	
		property = new BioMightPropertyView();
		property.setPropertyName("Right Breast");
		property.setCanonicalName(Constants.RightBreast);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("Left Nipple");
		property.setCanonicalName(Constants.LeftNipple);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("Right Nipple");
		property.setCanonicalName(Constants.RightNipple);
		properties.add(property);  

		property = new BioMightPropertyView();
		property.setPropertyName("Abdomen");
		property.setCanonicalName(Constants.Abdomen);
		properties.add(property);  

		property = new BioMightPropertyView();
		property.setPropertyName("Navel");
		property.setCanonicalName(Constants.Navel);
		properties.add(property);  

		property = new BioMightPropertyView();
		property.setPropertyName("Back");
		property.setCanonicalName(Constants.Back);
		properties.add(property);  

		property = new BioMightPropertyView();
		property.setPropertyName("Right Shoulder");
		property.setCanonicalName(Constants.RightShoulder);
		properties.add(property);  

		property = new BioMightPropertyView();
		property.setPropertyName("Left Shoulder");
		property.setCanonicalName(Constants.LeftShoulder);
		properties.add(property);  
		
		property = new BioMightPropertyView();
		property.setPropertyName("Right Arm");
		property.setCanonicalName(Constants.RightArm);
		properties.add(property);  

		property = new BioMightPropertyView();
		property.setPropertyName("Left Arm");
		property.setCanonicalName(Constants.LeftArm);
		properties.add(property);  
		
		property = new BioMightPropertyView();
		property.setPropertyName("Right Wrist");
		property.setCanonicalName(Constants.RightWrist);
		properties.add(property);  

		property = new BioMightPropertyView();
		property.setPropertyName("Left Wrist");
		property.setCanonicalName(Constants.LeftWrist);
		properties.add(property);  

		property = new BioMightPropertyView();
		property.setPropertyName("Left Hand");
		property.setCanonicalName(Constants.LeftHand);
		properties.add(property);  

		property = new BioMightPropertyView();
		property.setPropertyName("Right Wrist");
		property.setCanonicalName(Constants.RightHand);
		properties.add(property);  

		property = new BioMightPropertyView();
		property.setPropertyName("Hip");
		property.setCanonicalName(Constants.Hip);
		properties.add(property);  

		property = new BioMightPropertyView();
		property.setPropertyName("Anus");
		property.setCanonicalName(Constants.Anus);
		properties.add(property);  

		property = new BioMightPropertyView();
		property.setPropertyName("Vagina");
		property.setCanonicalName(Constants.Vagina);
		properties.add(property);  

		property = new BioMightPropertyView();
		property.setPropertyName("Penis");
		property.setCanonicalName(Constants.Penis);
		properties.add(property);  

		property = new BioMightPropertyView();
		property.setPropertyName("Left Leg");
		property.setCanonicalName(Constants.LeftLeg);
		properties.add(property);  

		property = new BioMightPropertyView();
		property.setPropertyName("Right Leg");
		property.setCanonicalName(Constants.RightLeg);
		properties.add(property);  

		property = new BioMightPropertyView();
		property.setPropertyName("Left Foot");
		property.setCanonicalName(Constants.LeftFoot);
		properties.add(property);  

		property = new BioMightPropertyView();
		property.setPropertyName("RightFoot");
		property.setCanonicalName(Constants.RightFoot);
		properties.add(property);  
	
		property = new BioMightPropertyView();
		property.setPropertyName("Systems");
		property.setCanonicalName(Constants.Title);
		properties.add(property);
	
		property = new BioMightPropertyView();
		property.setPropertyName("Billary System");
		property.setCanonicalName(Constants.BillarySystem);
		properties.add(property);  
		
		property = new BioMightPropertyView();
		property.setPropertyName("Circulatory System");
		property.setCanonicalName(Constants.CirculatorySystem);
		properties.add(property); 
		
		property = new BioMightPropertyView();
		property.setPropertyName("Digestive System");
		property.setCanonicalName(Constants.DigestiveSystem);
		properties.add(property); 
		
		property = new BioMightPropertyView();
		property.setPropertyName("Endocrine System");
		property.setCanonicalName(Constants.EndocrineSystem);
		properties.add(property); 
		
		property = new BioMightPropertyView();
		property.setPropertyName("Execretory System");
		property.setCanonicalName(Constants.ExecretorySystem);
		properties.add(property); 

		property = new BioMightPropertyView();
		property.setPropertyName("Muscular System");
		property.setCanonicalName(Constants.MuscularSystem);
		properties.add(property); 
		
		property = new BioMightPropertyView();
		property.setPropertyName("Repiratory System");
		property.setCanonicalName(Constants.RespiratorySystem);
		properties.add(property); 
		
		property = new BioMightPropertyView();
		property.setPropertyName("Reproductive System");
		property.setCanonicalName(Constants.ReproductiveSystem);
		properties.add(property); 

		property = new BioMightPropertyView();
		property.setPropertyName("Urinary System");
		property.setCanonicalName(Constants.UrinarySystem);
		properties.add(property); 
	}
	
	
	public void initMethods() {

		BioMightMethodView method = new BioMightMethodView();
		method.setCanonicalName(Constants.Body);
		method.setMethodName("setHeight");
		method.setDisplayName("Height:");
		method.setHtmlType("text");
		method.setDataType("double");
		methods.add(method);
		
		method = new BioMightMethodView();
		method.setCanonicalName(Constants.Body);
		method.setMethodName("setWeight");
		method.setDisplayName("Weight:");
		method.setHtmlType("text");
		method.setDataType("double");
		methods.add(method);
		
		method = new BioMightMethodView();
		method.setCanonicalName(Constants.Body);
		method.setMethodName("setAge");
		method.setDisplayName("Age:");
		method.setHtmlType("text");
		method.setDataType("int");
		methods.add(method);

		method = new BioMightMethodView();
		method.setCanonicalName(Constants.Body);
		method.setMethodName("setGender");
		method.setDisplayName("Gender:");
		method.setHtmlType(Constants.BIO_DROPDOWN);
		method.setDataType("String");
		HashMap gender = new HashMap();
    	gender.put(1, "Female");
    	gender.put(2, "Male");
    	gender.put(3, "Transgendered");
    	method.setValueMap(gender);
		method.setDataType("String");
		methods.add(method);

	
		method = new BioMightMethodView();
		method.setCanonicalName(Constants.Body);
		method.setMethodName("setBodyType");
		method.setDisplayName("Body Type:");
		method.setHtmlType("dropdown");
		method.setDataType("String");
     	ArrayList<String> bodyType = new ArrayList<String>();
    	bodyType.add("Endomorph");
    	bodyType.add("Ectomorph");
    	bodyType.add("Mesomorph");
    	//method.setValueMap(bodyType);
		method.setDataType("String");
		methods.add(method);

		// SKIN COLOR
		method = new BioMightMethodView();
		method.setCanonicalName(Constants.Body);
		method.setMethodName("setMaterial");
		method.setDisplayName("Material");
		method.setHtmlType(Constants.BIO_DROPDOWN);
		method.setDataType(Constants.BIO_TEXT);
	 	method.setValueMap(materialDDMap);
		methods.add(method);
		
		method = new BioMightMethodView();
		method.setCanonicalName(Constants.Body);
		method.setMethodName("setTexture");
		method.setDisplayName("Texture");
		method.setHtmlType(Constants.BIO_DROPDOWN);
		method.setDataType(Constants.BIO_TEXT);
	 	method.setValueMap(textureDDMap);
		methods.add(method);

		method = new BioMightMethodView();
		method.setCanonicalName(Constants.Body);
		method.setMethodName("setHairColor");
		method.setDisplayName("Hair Color:");
		method.setHtmlType("dropdown");
		method.setDataType("String");
     	ArrayList<String> hairColor = new ArrayList<String>();

     	/*
     	System.out.println("Loading Hair Color into PickList");
     	for (int i=0; i< colors.size(); i++)
     	{
     		BioMightColorElement bioMightColorElement = (BioMightColorElement) colors.get(i);
     		System.out.println("Checking Hair Color: " + bioMightColorElement.getName());
     		//if (bioMightColorElement.getCompType().equals(Constants.HairShaftRef))
     		//{
     			System.out.println("Loading Hair Color into PickList: " + bioMightColorElement.getName());
     			hairColor.add(bioMightColorElement.getName());
     		//}
     	}
     	method.setValues(hairColor);
		methods.add(method);
		
	
		method = new BioMightMethodView();
		method.setCanonicalName(Constants.Body);
		method.setMethodName("setEthnicity");
		method.setDisplayName("Ethnicity:");
		method.setHtmlType("dropdown");
		method.setDataType("String");
     	ArrayList<String> ethnicity = new ArrayList<String>();
     	ethnicity.add("Asiatic");
     	ethnicity.add("Autralian");
     	ethnicity.add("European");
     	ethnicity.add("Indian");
     	ethnicity.add("Middle Eastern");
    	ethnicity.add("North American");
     	ethnicity.add("South American");
    	method.setValues(ethnicity);
		method.setDataType("String");
		methods.add(method);
		
	
		method = new BioMightMethodView();
		method.setCanonicalName(Constants.Body);
		method.setMethodName("setPosture");
		method.setDisplayName("Posture:");
		method.setHtmlType("dropdown");
		method.setDataType("String");
     	ArrayList<String> posture = new ArrayList<String>();
     	posture.add("Dancing");
     	posture.add("Shaking");
     	posture.add("Shivering");
     	posture.add("Jumping");
     	posture.add("Walking");
     	posture.add("Running");
     	posture.add("Jogging");
     	posture.add("Standing Erect");
     	posture.add("Stadinding Slouched");
    	method.setValues(posture);
		method.setDataType("String");
		methods.add(method);

		method = new BioMightMethodView();
		method.setCanonicalName(Constants.Body);
		method.setMethodName("setEyeColor");
		method.setDisplayName("Eye Color:");
		method.setHtmlType("dropdown");
		method.setDataType("String");
     	
     	// Grab the colors from the color ArrayList that was popluated from
     	// a call to the database.  Use the component type to the get the
     	// appropriate colors.     	
		ArrayList<String> eyeColor = new ArrayList<String>();
     	for (int i=0; i< colors.size(); i++)
     	{
     		BioMightColorElement bioMightColorElement = (BioMightColorElement) colors.get(i);
     		System.out.println("Checking Eye Color: " + bioMightColorElement.getName());
     		//if (bioMightColorElement.getCompType().equals(Constants.IrisRef))
     		//{
     			System.out.println("Loading Eye Color into PickList: " + bioMightColorElement.getName());
     			eyeColor.add(bioMightColorElement.getName());
     		//}
     	}
     	method.setValues(eyeColor);
		methods.add(method);

		method = new BioMightMethodView();
		method.setCanonicalName(Constants.Lips);
		method.setMethodName("setLipColor");
		method.setDisplayName("Lip Color:");
		method.setHtmlType("dropdown");
		method.setDataType("String");
     	ArrayList<String> lipColor = new ArrayList<String>();
     	
       	for (int i=0; i< colors.size(); i++)
     	{
     		BioMightColorElement bioMightColorElement = (BioMightColorElement) colors.get(i);
     		System.out.println("Checking Lip Color: " + bioMightColorElement.getName());
     		//if (bioMightColorElement.getCompType().equals(Constants.Lips))
     		//{
     			System.out.println("Loading Lip Color into PickList: " + bioMightColorElement.getName());
     			lipColor.add(bioMightColorElement.getName());
     		//}
     	}

    	method.setValues(lipColor);
		methods.add(method);
		*/
     	
	}
	
	/******************************************************************************************
	 * EXECUTE METHODS 
	 * 
	 *   This executes dynamic method invocation of the method against the class based on 
	 *   the function that the user selects from the BioMight User Interface
	 *
	 ******************************************************************************************/
	public void executeMethods(ArrayList<BioMightMethodView> bioMightMethods) {

		// Run through the argument list and executes the 
		// associated methods
		boolean fired = false;
		System.out.println("BODY-Executing Methods: " + bioMightMethods.size());
		for (int j=0; j<bioMightMethods.size(); j++){
			
			// Get the parameter from the list and if it is not
			// empty execute the associated method using it
			BioMightMethodView bioMightMethod = (BioMightMethodView) bioMightMethods.get(j);
			System.out.println("Have BioMightMethod for BODY: " + bioMightMethod.getMethodName());	
			String methodName = bioMightMethod.getMethodName();
			String canonicalName = bioMightMethod.getCanonicalName(); 
			String dataType = bioMightMethod.getDataType();
			String methodParam = bioMightMethod.getMethodParameter(); 
			if (methodParam == null)
				methodParam = "";
			
			// We only execute those methods that are targeted for the IRIS
			// If a parameter is specified then we fire the method, otherwise
			// we just jump over it
			if (canonicalName.equals(Constants.Body)) {				
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
					}			
				}	
			}
			if (fired)
			{	
				//System.out.println("Methods have fired.   Calling BODY Save method!");
				//save();
			}
		}
	}
	

	
	
	

	/*****************************************************************************
	 * SET HAIR COLOR - Sets the color of the skin
	 * 
	 * Set the color of the skin
	 * 
	 *****************************************************************************/
	public void setHairColor(String colorStr) {
		int colorCode = 52;
		System.out.println("Setting Hair Color");			
     	setMaterial(colorCode, "HeadHair"); 
	}

	/*****************************************************************************
	 * SET SKIN COLOR - Sets the color of the skin
	 * 
	 * Set the color of the skin
	 * 
	 *****************************************************************************/
	public void setSkinColor(String colorStr) {
	
		int colorCode = 10;
		System.out.println("Setting SKIN Color: " + colorStr);						
		setMaterial(colorCode, "Skin:0"); 
	}

	/*****************************************************************************
	 * SET EYE COLOR - Sets the color of the IRIS
	 * 
	 * Set the color of the skin
	 * 
	 *****************************************************************************/
	public void setEyeColor(String colorStr) {

		int colorCode = 1;

		System.out.println("Setting Eye Color");
     	
		setMaterial(colorCode, Constants.IrisRef); 
	}

	
	
	/*****************************************************************************
	 * SET LIP COLOR - Sets the color of the IRIS
	 * 
	 * Set the color of the Lips
	 * 
	 *****************************************************************************/
	public void setLipColor(String colorStr) {

		int colorCode = 1;

		System.out.println("Setting Lip Color");     	
		setMaterial(colorCode, Constants.LipsRef); 
	}




	
	/********************************************************************************************************************
	 * GET X3D
	 * 
	 * This method will return the X3D for the Cell.  It runs through each of its components and collects up their
	 * representations and then assembles them into one unified X3D model.  Body is at the top of the culmination.  
	 * There is no sniplet.
	 * 
	 ********************************************************************************************************************/
	public String getX3D(boolean snipet) {
		
		// Assemble the Body
		String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
		"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n " +
		"<X3D profile='Immersive' >\n" +
		"<head>\n" +
		 "<meta name='BioMightImage' content='Body.jpg'/>\n" +
		 "<meta name='ExportTime' content='7:45:30'/>\n" +
		 "<meta name='ExportDate' content='08/15/2008'/>\n" +
		 "<meta name='BioMight Version' content='1.0'/>\n" + 
		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='Body'\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		


		String body = "";
			
		if (BioWebUtils.isViewEnabled(Constants.HeadRef, localBioMightProperties)) {
			body += head.getX3D(true);
		}
		if (BioWebUtils.isViewEnabled(Constants.NeckRef, localBioMightProperties)) {
			body += neck.getX3D(true);
		}
		if (BioWebUtils.isViewEnabled(Constants.ChestRef, localBioMightProperties)) {
			body += chest.getX3D(true);
		}
		if (BioWebUtils.isViewEnabled(Constants.BackRef, localBioMightProperties)) {
			//body += back.getX3D(true);
		}
		if (BioWebUtils.isViewEnabled(Constants.AbdomenRef, localBioMightProperties)) {
			body += abdomen.getX3D(true);
		}
		if (BioWebUtils.isViewEnabled(Constants.HipsRef, localBioMightProperties)) {
			body += hips.getX3D(true);
		}
		if (BioWebUtils.isViewEnabled(Constants.ShouldersRef, localBioMightProperties)) {
			body += shoulders.getX3D(true);
		}
		if (BioWebUtils.isViewEnabled(Constants.ArmsRef, localBioMightProperties)) {
			body += arms.getX3D(true);
		}
		if (BioWebUtils.isViewEnabled(Constants.ForeArmsRef, localBioMightProperties)) {
			body += foreArms.getX3D(true);
		}
		if (BioWebUtils.isViewEnabled(Constants.ElbowsRef, localBioMightProperties)) {
			body += elbows.getX3D(true);
		}
		if (BioWebUtils.isViewEnabled(Constants.WristsRef, localBioMightProperties)) {
			body += wrists.getX3D(true);
		}
		if (BioWebUtils.isViewEnabled(Constants.HandsRef, localBioMightProperties)) {
			body += hands.getX3D(true);
		}
		if (BioWebUtils.isViewEnabled(Constants.ThighsRef, localBioMightProperties)) {
			body += thighs.getX3D(true);
		}
		if (BioWebUtils.isViewEnabled(Constants.KneesRef, localBioMightProperties)) {
			body += knees.getX3D(true);
		}
		if (BioWebUtils.isViewEnabled(Constants.CnemesRef, localBioMightProperties)) {
			body += cnemes.getX3D(true);
		}
		if (BioWebUtils.isViewEnabled(Constants.FeetRef, localBioMightProperties)) {
			body += feet.getX3D(true);
		}
		
		System.out.println("Have BODY X3D");
		//System.out.println("Have Body X3D: " + body);				
		String footer = "</Scene>" + "</X3D>\n";
		
		
		if (snipet)
			return body;			
		else	
			return header + body + footer;
	}

	
	/********************************************************************
	 * SETUP BOUND BOXES
	 * 
	 * Setup the Bounding Boxes for the Body.   These boxes will define
	 * the local coordinate system for each component, and also
	 * set the parameters in LxWxH that the component and its contents
	 * are confined to.
	 *
	 * In the EJB Layer,the bounding box will be used to restrict the 
	 * actions of the instruction set, allowing to exceed its 
	 * 'normal' paramaterized execution via configuration
	 *
	 * @return
	 ********************************************************************/
	private HashMap setupBoundBoxes(HashMap propertyViewMap) 
	{
		// Set up the bounding boxes for the various components
		HashMap boundingBoxMap = new HashMap();
	
		// Initialize the position of the bounding box vars
		BigDecimal xPos = new BigDecimal(0.0);
		BigDecimal yPos = new BigDecimal(0.0);
		BigDecimal zPos= new BigDecimal(0.0);
		
		// Set to base 1x1x1 cube
		BigDecimal xVector= new BigDecimal(1.0);
		BigDecimal yVector= new BigDecimal(1.0); 
		BigDecimal zVector= new BigDecimal(1.0);
	
		// Set to base 1x1x1 magnitude
		BigDecimal xVectorMag= new BigDecimal(1.0);
		BigDecimal yVectorMag= new BigDecimal(1.0); 
		BigDecimal zVectorMag= new BigDecimal(1.0);
	
		// Set to base 1x1x1 direction resulting in cube
		BigDecimal xVectorDir= new BigDecimal(1.0);
		BigDecimal yVectorDir= new BigDecimal(1.0); 
		BigDecimal zVectorDir= new BigDecimal(1.0);
	
		double theta = 45.0;
	
		// Initialize the BoundBoxes. This is used for
		// collections such as arms, legs,lungs,etc
		BioMightBoundBoxes bioBoundBoxes = null;
	
		// Initialize the BoundBox
		BioMightBoundBox bioBoundBox = null;

		// Initialize the Connectors  
		BioMightConnectors bioMightConnectors = null; 

		// Initialize the Connector  
		BioMightConnector bioMightConnector= null;
	
		double circumference = 0.0;
		double[] startPos = {0.0, 0.0, 0.0};
		double[][] startPoints = BioGraphics.octogonYPlane(startPos, circumference);
		
		double[] endPos = {0.0, 0.0, 0.0};
		double[][] endPoints = BioGraphics.octogonYPlane(endPos, circumference);

		// The object used to pull propertyView objects from the HashMap
		BioMightPropertyView bioMightPropertyView = null;

		// 
		double [][] bioPositions = null;

		//********************************************************************* 
		//	HEAD BOUNDBOX
		// 	Set up the Bounding Box for the Head
		// 	On a porportioned human, the pupils lie in the middle of the face
		// 	For the Default model, the length is 7x9x9 
		// 	This puts the bounding box at the center of the head
		//**********************************************************************
		
		bioMightPropertyView = (BioMightPropertyView) propertyViewMap.get(Constants.HeadRef);
		if (bioMightPropertyView != null) {			
			System.out.println("User Pos for Head");
	
			xPos = new BigDecimal(bioMightPropertyView.getPropertyPosition().getXPos());
			yPos = new BigDecimal(bioMightPropertyView.getPropertyPosition().getYPos());
			zPos = new BigDecimal(bioMightPropertyView.getPropertyPosition().getZPos());
			
			xVector = new BigDecimal(bioMightPropertyView.getPropertyScale().getXScale());
			yVector = new BigDecimal(bioMightPropertyView.getPropertyScale().getYScale());
			zVector = new BigDecimal(bioMightPropertyView.getPropertyScale().getZScale());
		}
		
		
		bioBoundBox = new BioMightBoundBox(xPos, yPos, zPos, xVector, yVector, zVector);
		bioMightConnectors = new BioMightConnectors();
		
		//********************************************
		// HEAD - ORGAN CONNECTORS
		//********************************************
	
		// Nasal-pharnyx-Trachea Connector
		circumference = 0.3;
		startPos = getStartPoints(0.0, -5.0, -1.0);
		startPoints = BioGraphics.octogonYPlane(startPos, circumference);
		bioMightConnector  = new BioMightConnector(startPoints, Constants.TracheaEpitheliumRef,"connType");
		bioMightConnectors.setBioMightConnector(Constants.TracheaEpitheliumRef, bioMightConnector);
	
		// Nasal-pharnyx-Esophagus Connector 
		circumference = 0.3;
		startPos = getStartPoints(0.0, -5.0, -1.0);
		startPoints = BioGraphics.octogonYPlane(startPos, circumference);
		bioMightConnector  = new BioMightConnector(startPoints, Constants.EsophagusEpitheliumRef,"connType");
		bioMightConnectors.setBioMightConnector(Constants.EsophagusEpitheliumRef, bioMightConnector);
		
		//********************************************	
		// HEAD - VASCULAR CONNECTORS  
		//********************************************
	
		// InternalCarotidArteryEpithelium
		circumference = 0.3;
		startPos = getStartPoints(0.0, -5.0, -1.0);
		startPoints = BioGraphics.octogonYPlane(startPos, circumference);
		bioMightConnector = new BioMightConnector(startPoints, "InternalCarotidArteryEpithelium","connType");
		bioMightConnectors.setBioMightConnector("InternalCarotidArteryEpithelium", bioMightConnector);
	
		// ExternalCarotidArteryEpithelium 
		circumference = 0.3;
		startPos = getStartPoints(0.0, -5.0, -1.0);
		startPoints = BioGraphics.octogonYPlane(startPos, circumference);
		bioMightConnector  = new BioMightConnector(startPoints, "ExternalCarotidArteryEpithelium","connType");
		bioMightConnectors.setBioMightConnector("ExternalCarotidArteryEpithelium", bioMightConnector);
	
		//********************************************
		// HEAD - MUSCULAR CONNECTORS
		//********************************************
		
	
		//********************************************
		// HEAD - SKELETAL CONNECTORS
		//********************************************

		// CervicalVertebrae c1 
		circumference = 0.3;
		startPos = getStartPoints(0.0, -5.0, -1.0);
		startPoints = BioGraphics.octogonYPlane(startPos, circumference);
		bioMightConnector  = new BioMightConnector(startPoints, "CervicalVertebrae","connType");
		bioMightConnectors.setBioMightConnector("CervicalVertebrae", bioMightConnector);
	
		// Stuff in the Bounding Box Map
		bioBoundBox.setBioMightConnectors(bioMightConnectors);
		boundingBoxMap.put(Constants.HeadRef, bioBoundBox);

	
		//**********************************************************************
		// NECK BOUND BOX		
		//
		// Set up the Bounding Box for the Neck
		// For default model, length of neck is 4.5
		//**********************************************************************

		bioMightPropertyView = (BioMightPropertyView) propertyViewMap.get(Constants.NeckRef);
		if (bioMightPropertyView != null) {			
			xPos = new BigDecimal(bioMightPropertyView.getPropertyPosition().getXPos());
			yPos = new BigDecimal(bioMightPropertyView.getPropertyPosition().getYPos());
			zPos = new BigDecimal(bioMightPropertyView.getPropertyPosition().getZPos());
			
			xVector = new BigDecimal(bioMightPropertyView.getPropertyScale().getXScale());
			yVector = new BigDecimal(bioMightPropertyView.getPropertyScale().getYScale());
			zVector = new BigDecimal(bioMightPropertyView.getPropertyScale().getZScale());
		}
		else
		{
			xPos = new BigDecimal(0.00);
			yPos = new BigDecimal(-7.75);
			zPos= new BigDecimal(-3.00); 
		
			xVector= new BigDecimal(2.5);
			yVector= new BigDecimal(2.0); 
			zVector= new BigDecimal(2.5);
			
			bioBoundBox = new BioMightBoundBox(xPos, yPos, zPos, xVector, yVector, zVector);
			bioMightConnectors = new BioMightConnectors();
		}
		
		//********************************************
		// NECK - ORGAN CONNECTORS
		//********************************************
	
		// Skin Connector
		circumference = 0.3;
		startPos = getStartPoints(0.0, -5.0, -1.0);
		startPoints = BioGraphics.octogonYPlane(startPos, circumference);
		bioMightConnector = new BioMightConnector(startPoints, Constants.NeckEpitheliumRef,"connType");
		bioMightConnectors.setBioMightConnector(Constants.NeckEpitheliumRef, bioMightConnector);
	
		// Trachea Connector
		circumference = 0.3;
		startPos = getStartPoints(0.0, -5.0, -2.0);
		startPoints = BioGraphics.octogonYPlane(startPos, circumference);
		bioMightConnector = new BioMightConnector(startPoints, Constants.TracheaRef,"connType");
		bioMightConnectors.setBioMightConnector(Constants.TracheaRef, bioMightConnector);
	
		// Esophagus Connector 
		circumference = 0.3;
		startPos = getStartPoints(0.0, -5.0, -3.0);
		startPoints = BioGraphics.octogonYPlane(startPos, circumference);
		bioMightConnector  = new BioMightConnector(startPoints, Constants.EsophagusRef,"connType");
		bioMightConnectors.setBioMightConnector(Constants.EsophagusRef, bioMightConnector);
		
		//********************************************	
		// NECK - VASCULAR CONNECTORS  
		//********************************************
	
		// InternalCarotidArteryEpithelium
		circumference = 0.3;
		startPos = getStartPoints(0.0, -5.0, -1.0);
		startPoints = BioGraphics.octogonYPlane(startPos, circumference);
		bioMightConnector = new BioMightConnector(startPoints, "InternalCarotidArteryEpithelium","connType");
		bioMightConnectors.setBioMightConnector("InternalCarotidArteryEpithelium", bioMightConnector);
	
		// ExternalCarotidArteryEpithelium 
		circumference = 0.3;
		startPos = getStartPoints(0.0, -5.0, -1.0);
		startPoints = BioGraphics.octogonYPlane(startPos, circumference);
		bioMightConnector  = new BioMightConnector(startPoints, "ExternalCarotidArteryEpithelium","connType");
		bioMightConnectors.setBioMightConnector("ExternalCarotidArteryEpithelium", bioMightConnector);
	
		//********************************************
		// NECK - MUSCULAR CONNECTORS
		//********************************************

	
		//********************************************
		// NECK - SKELETAL CONNECTORS
		//********************************************

		// CervicalVertebrae C5 
		circumference = 0.3;
		startPos = getStartPoints(0.0, -5.0, -1.0);
		startPoints = BioGraphics.octogonYPlane(startPos, circumference);
		bioMightConnector  = new BioMightConnector(startPoints, "CervicalVertebrae","connType");
		bioMightConnectors.setBioMightConnector("CervicalVertebrae", bioMightConnector);
		
		// Stuff in the Bounding Box Map
		bioBoundBox.setBioMightConnectors(bioMightConnectors);
		boundingBoxMap.put(Constants.NeckRef, bioBoundBox);

		
		//**********************************************************************
		// CHEST BOUNDBOX
		//
		// Set up the Bounding Box for the Chest
		// Set up the Connectors on the Bounding Box
		// For default model, the box is set at 
		//
		//**********************************************************************
	
		bioMightPropertyView = (BioMightPropertyView) propertyViewMap.get(Constants.ChestRef);
		if (bioMightPropertyView != null) {			
			xPos = new BigDecimal(bioMightPropertyView.getPropertyPosition().getXPos());
			yPos = new BigDecimal(bioMightPropertyView.getPropertyPosition().getYPos());
			zPos = new BigDecimal(bioMightPropertyView.getPropertyPosition().getZPos());
			
			xVector = new BigDecimal(bioMightPropertyView.getPropertyScale().getXScale());
			yVector = new BigDecimal(bioMightPropertyView.getPropertyScale().getYScale());
			zVector = new BigDecimal(bioMightPropertyView.getPropertyScale().getZScale());

		}		
		else
		{
			xPos = new BigDecimal(0.0);
			yPos = new BigDecimal(-15.0);
			zPos= new BigDecimal(-3.0);
		
			xVector= new BigDecimal(11.5);
			yVector= new BigDecimal(6.0); 
			zVector= new BigDecimal(5.0);
		}

		bioBoundBox = new BioMightBoundBox(xPos, yPos, zPos, xVector, yVector, zVector);
		bioMightConnectors = new BioMightConnectors();
		
		//********************************************
		// CHEST - ORGAN CONNECTORS
		//********************************************
	
		// Skin Connector
		circumference = 0.3;
		startPos = getStartPoints(0.0, -8.0, -1.0);
		startPoints = BioGraphics.octogonYPlane(startPos, circumference);
		bioMightConnector = new BioMightConnector(startPoints, Constants.ChestEpitheliumRef,"connType");
		bioMightConnectors.setBioMightConnector(Constants.ChestEpitheliumRef, bioMightConnector);
	
		// Trachea Connector
		circumference = 0.3;
		startPos = getStartPoints(0.0, -8.0, -1.0);
		startPoints = BioGraphics.octogonYPlane(startPos, circumference);
		bioMightConnector = new BioMightConnector(startPoints, Constants.TracheaRef,"connType");
		bioMightConnectors.setBioMightConnector(Constants.TracheaRef, bioMightConnector);
	
		// Esophagus Connector 
		circumference = 0.3;
		startPos = getStartPoints(0.0, -8.0, -1.0);
		startPoints = BioGraphics.octogonYPlane(startPos, circumference);
		bioMightConnector  = new BioMightConnector(startPoints, Constants.EsophagusRef,"connType");
		bioMightConnectors.setBioMightConnector(Constants.EsophagusRef, bioMightConnector);
		
		//********************************************	
		// CHEST - VASCULAR CONNECTORS  
		//********************************************
		
		// InternalCarotidArteryEpithelium
		circumference = 0.3;
		startPos = getStartPoints(0.0, -5.0, -1.0);
		startPoints = BioGraphics.octogonYPlane(startPos, circumference);
		bioMightConnector = new BioMightConnector(startPoints, "InternalCarotidArteryEpithelium","connType");
		bioMightConnectors.setBioMightConnector("InternalCarotidArteryEpithelium", bioMightConnector);
	
		// ExternalCarotidArteryEpithelium 
		circumference = 0.3;
		startPos = getStartPoints(0.0, -5.0, -1.0);
		startPoints = BioGraphics.octogonYPlane(startPos, circumference);
		bioMightConnector  = new BioMightConnector(startPoints, "ExternalCarotidArteryEpithelium","connType");
		bioMightConnectors.setBioMightConnector("ExternalCarotidArteryEpithelium", bioMightConnector);
	
		//********************************************
		// CHEST - MUSCULAR CONNECTORS
		//********************************************
	
	
		//********************************************
		// CHEST - SKELETAL CONNECTORS
		//********************************************

		// CervicalVertebrae C5 
		circumference = 0.3;
		startPos = getStartPoints(0.0, -5.0, -1.0);
		startPoints = BioGraphics.octogonYPlane(startPos, circumference);
		bioMightConnector  = new BioMightConnector(startPoints, "CervicalVertebrae","connType");
		bioMightConnectors.setBioMightConnector("CervicalVertebrae", bioMightConnector);
		
		// Stuff in the Bounding Box Map
		bioBoundBox.setBioMightConnectors(bioMightConnectors);
		boundingBoxMap.put(Constants.ChestRef, bioBoundBox);
	
	
		
		//**********************************************************************
		// BACK BOUNDBOX
		//
		// Set up the Bounding Box for the Back
		// Set up the Connectors on the Bounding Box
		// For default model, the box is set at 
		//
		//**********************************************************************
		
		bioMightPropertyView = (BioMightPropertyView) propertyViewMap.get(Constants.BackRef);
		if (bioMightPropertyView != null) {			
			xPos = new BigDecimal(bioMightPropertyView.getPropertyPosition().getXPos());
			yPos = new BigDecimal(bioMightPropertyView.getPropertyPosition().getYPos());
			zPos = new BigDecimal(bioMightPropertyView.getPropertyPosition().getZPos());
			
			xVector = new BigDecimal(bioMightPropertyView.getPropertyScale().getXScale());
			yVector = new BigDecimal(bioMightPropertyView.getPropertyScale().getYScale());
			zVector = new BigDecimal(bioMightPropertyView.getPropertyScale().getZScale());

		}
		else
		{
			xPos = new BigDecimal(0.0);
			yPos = new BigDecimal(-15.0);
			zPos= new BigDecimal(-6.0);
		
			xVector= new BigDecimal(11.5);
			yVector= new BigDecimal(6.0); 
			zVector= new BigDecimal(5.0);		
		}
			
			
		bioBoundBox = new BioMightBoundBox(xPos, yPos, zPos, xVector, yVector, zVector);
		bioMightConnectors = new BioMightConnectors();
		
		//********************************************
		// BACK - ORGAN CONNECTORS
		//********************************************
	
		// Skin Connector
		circumference = 0.3;
		startPos = getStartPoints(0.0, -8.0, -1.0);
		startPoints = BioGraphics.octogonYPlane(startPos, circumference);
		bioMightConnector = new BioMightConnector(startPoints, Constants.BackEpitheliumRef,"connType");
		bioMightConnectors.setBioMightConnector(Constants.BackEpitheliumRef, bioMightConnector);
	
			
		//********************************************	
		// BACK - VASCULAR CONNECTORS  
		//********************************************
		
		// InternalCarotidArteryEpithelium
		circumference = 0.3;
		startPos = getStartPoints(0.0, -5.0, -1.0);
		startPoints = BioGraphics.octogonYPlane(startPos, circumference);
		bioMightConnector = new BioMightConnector(startPoints, "InternalCarotidArteryEpithelium","connType");
		bioMightConnectors.setBioMightConnector("InternalCarotidArteryEpithelium", bioMightConnector);
	
		// ExternalCarotidArteryEpithelium 
		circumference = 0.3;
		startPos = getStartPoints(0.0, -5.0, -1.0);
		startPoints = BioGraphics.octogonYPlane(startPos, circumference);
		bioMightConnector  = new BioMightConnector(startPoints, "ExternalCarotidArteryEpithelium","connType");
		bioMightConnectors.setBioMightConnector("ExternalCarotidArteryEpithelium", bioMightConnector);
	
		//********************************************
		// BACK - MUSCULAR CONNECTORS
		//********************************************
	
	
		//********************************************
		// BACK - SKELETAL CONNECTORS
		//********************************************

		// Thorarcic Vertebrae T11
		circumference = 0.3;
		startPos = getStartPoints(0.0, -5.0, -1.0);
		startPoints = BioGraphics.octogonYPlane(startPos, circumference);
		bioMightConnector  = new BioMightConnector(startPoints, "ThoracicVertebrae","connType");
		bioMightConnectors.setBioMightConnector("ThoracicVertebrae", bioMightConnector);
		
		// Stuff in the Bounding Box Map
		bioBoundBox.setBioMightConnectors(bioMightConnectors);
		boundingBoxMap.put(Constants.BackRef, bioBoundBox);
	
	
		//**********************************************************************
		// SHOULDERS BOUNDBOXES
		//
		// Set up the Bounding Box for the Shoulders
		// 
		//**********************************************************************
	
		// Setup the Boxes for the collection
		bioBoundBoxes = new BioMightBoundBoxes();
	
		//********************************************************************* 
		// LEFT SHOULDER BOUNDBOX
		// Set up the Bounding Box for the Left Shoulder
		// On a porportioned human, the Shoulder are located in the --- 
		//**********************************************************************

		bioMightPropertyView = (BioMightPropertyView) propertyViewMap.get(Constants.LeftShoulderRef);
		if (bioMightPropertyView != null) {			
			xPos = new BigDecimal(bioMightPropertyView.getPropertyPosition().getXPos());
			yPos = new BigDecimal(bioMightPropertyView.getPropertyPosition().getYPos());
			zPos = new BigDecimal(bioMightPropertyView.getPropertyPosition().getZPos());
			
			xVector = new BigDecimal(bioMightPropertyView.getPropertyScale().getXScale());
			yVector = new BigDecimal(bioMightPropertyView.getPropertyScale().getYScale());
			zVector = new BigDecimal(bioMightPropertyView.getPropertyScale().getZScale());

		}
		else
		{
			xPos = new BigDecimal(8.5);
			yPos = new BigDecimal(-8.0);
			zPos = new BigDecimal(-1.0);
			
			xVectorMag= new BigDecimal(1.0);
			yVectorMag= new BigDecimal(1.0); 
			zVectorMag= new BigDecimal(1.0);
	
			xVectorDir= new BigDecimal(1.0);
			yVectorDir= new BigDecimal(1.0); 
			zVectorDir= new BigDecimal(1.0);
		}
	
		bioBoundBox = new BioMightBoundBox(xPos, yPos, zPos, xVectorMag, yVectorMag, zVectorMag, xVectorDir, yVectorDir, zVectorDir, theta);
		bioMightConnectors = new BioMightConnectors();
			
		// Shoulder Epithelium Connector
		circumference = 0.3;
		startPos = getStartPoints(8.5, -8.0, -1.0);
		startPoints = BioGraphics.octogonYPlane(startPos, circumference);
		endPos = getEndPoints(8.75, -13.0, -1.0);
		endPoints = BioGraphics.octogonYPlane(endPos, circumference);
	
		bioMightConnector  = new BioMightConnector(startPoints, endPoints, Constants.ShoulderEpitheliumRef,"connType");
		bioMightConnectors.setBioMightConnector(Constants.ShoulderEpitheliumRef, bioMightConnector);
			
		bioBoundBox.setBioMightConnectors(bioMightConnectors);
			
		// Put the Bounding Box into the Collection of Bounding Boxes 
		bioBoundBoxes.setBoundingBox(Constants.LeftShoulderRef, bioBoundBox);	

		
		//********************************************************************* 
		// RIGHT SHOULDER BOUNDBOX
		// Set up the Bounding Box for the Shoulder
		// On a porportioned human, the Shoulder are located in the --- 
		//**********************************************************************
		
		bioMightPropertyView = (BioMightPropertyView) propertyViewMap.get(Constants.RightShoulderRef);
		if (bioMightPropertyView != null) {			
			xPos = new BigDecimal(bioMightPropertyView.getPropertyPosition().getXPos());
			yPos = new BigDecimal(bioMightPropertyView.getPropertyPosition().getYPos());
			zPos = new BigDecimal(bioMightPropertyView.getPropertyPosition().getZPos());
			
			xVector = new BigDecimal(bioMightPropertyView.getPropertyScale().getXScale());
			yVector = new BigDecimal(bioMightPropertyView.getPropertyScale().getYScale());
			zVector = new BigDecimal(bioMightPropertyView.getPropertyScale().getZScale());
		}
		else
		{
			xPos = new BigDecimal(-8.5);
			yPos = new BigDecimal(-8.0);
			zPos= new BigDecimal(-1.0);
			
			xVectorMag= new BigDecimal(1.0);
			yVectorMag= new BigDecimal(1.0); 
			zVectorMag= new BigDecimal(1.0);
	
			xVectorDir= new BigDecimal(1.0);
			yVectorDir= new BigDecimal(1.0); 
			zVectorDir= new BigDecimal(1.0);
		}
		
		bioBoundBox = new BioMightBoundBox(xPos, yPos, zPos, xVectorMag, yVectorMag, zVectorMag);
		bioMightConnectors = new BioMightConnectors();
			
		// ShoulderEpithelium Connector
		circumference = 0.3;
		startPos = getStartPoints(-8.5, -8.0, -1.0);
		startPoints = BioGraphics.octogonYPlane(startPos, circumference);
		endPos = getEndPoints(-8.5, -13.0, -1.0);
		endPoints = BioGraphics.octogonYPlane(endPos, circumference);
	
		bioMightConnector  = new BioMightConnector(startPoints, endPoints, Constants.ShoulderEpitheliumRef,"connType");
		bioMightConnectors.setBioMightConnector(Constants.ShoulderEpitheliumRef, bioMightConnector);
			
		bioBoundBox.setBioMightConnectors(bioMightConnectors);
		
		// Put the Bounding Box into the Collection of Bounding Boxes 
		bioBoundBoxes.setBoundingBox(Constants.RightShoulderRef, bioBoundBox);		
		
		// Put the BioMight BoundBoxes for the Shoulders 
		// into the BoundingBoxMap 
		boundingBoxMap.put(Constants.ShouldersRef, bioBoundBoxes);	
		
		
			
		//**********************************************************************
		// ARMS BOUNDBOXES
		//
		// Set up the Bounding Box for the Arms
		// For default model, length of arm is 4.5
		//**********************************************************************

		// Setup the Boxes for the collection
		bioBoundBoxes = new BioMightBoundBoxes();
	
		//********************************************************************* 
		// LEFT ARM BOUNDBOX
		// Set up the Bounding Box for the Left Arm
		// On a porportioned human, the Arm are located in the --- 
		//**********************************************************************

		bioMightPropertyView = (BioMightPropertyView) propertyViewMap.get(Constants.LeftArmRef);
		if (bioMightPropertyView != null) {			
			xPos = new BigDecimal(bioMightPropertyView.getPropertyPosition().getXPos());
			yPos = new BigDecimal(bioMightPropertyView.getPropertyPosition().getYPos());
			zPos = new BigDecimal(bioMightPropertyView.getPropertyPosition().getZPos());
			
			xVector = new BigDecimal(bioMightPropertyView.getPropertyScale().getXScale());
			yVector = new BigDecimal(bioMightPropertyView.getPropertyScale().getYScale());
			zVector = new BigDecimal(bioMightPropertyView.getPropertyScale().getZScale());

		}
		else
		{
			xPos = new BigDecimal(8.5);
			yPos = new BigDecimal(-13.0);
			zPos= new BigDecimal(-1.0);
			
			xVectorMag= new BigDecimal(1.0);
			yVectorMag= new BigDecimal(5.0); 
			zVectorMag= new BigDecimal(1.0);
	
			xVectorDir= new BigDecimal(1.0);
			yVectorDir= new BigDecimal(1.0); 
			zVectorDir= new BigDecimal(1.0);
		}
		
		
		bioBoundBox = new BioMightBoundBox(xPos, yPos, zPos, xVectorMag, yVectorMag, zVectorMag, xVectorDir, yVectorDir, zVectorDir, theta);
		bioMightConnectors = new BioMightConnectors();
			
		// Arm Epithelium Connector
		circumference = 0.3;
		startPos = getStartPoints(8.5, -13.0, -1.0);
		startPoints = BioGraphics.octogonYPlane(startPos, circumference);
		endPos = getEndPoints(8.5, -18.0, -1.0);
		endPoints = BioGraphics.octogonYPlane(endPos, circumference);
	
		bioMightConnector  = new BioMightConnector(startPoints, endPoints, Constants.ArmEpitheliumRef,"connType");
		bioMightConnectors.setBioMightConnector(Constants.ArmEpitheliumRef, bioMightConnector);
			
		bioBoundBox.setBioMightConnectors(bioMightConnectors);
			
		// Put the Bounding Box into the Collection of Bounding Boxes 
		bioBoundBoxes.setBoundingBox(Constants.LeftArmRef, bioBoundBox);	
		
		//********************************************************************* 
		// RIGHT ARM BOUNDBOX
		// Set up the Bounding Box for the Arm
		// On a porportioned human, the Arm are located in the --- 
		//**********************************************************************

		bioMightPropertyView = (BioMightPropertyView) propertyViewMap.get(Constants.RightArmRef);
		if (bioMightPropertyView != null) {			
			xPos = new BigDecimal(bioMightPropertyView.getPropertyPosition().getXPos());
			yPos = new BigDecimal(bioMightPropertyView.getPropertyPosition().getYPos());
			zPos = new BigDecimal(bioMightPropertyView.getPropertyPosition().getZPos());
			
			xVector = new BigDecimal(bioMightPropertyView.getPropertyScale().getXScale());
			yVector = new BigDecimal(bioMightPropertyView.getPropertyScale().getYScale());
			zVector = new BigDecimal(bioMightPropertyView.getPropertyScale().getZScale());

		}
		else
		{
			xPos = new BigDecimal(-8.5);
			yPos = new BigDecimal(-13.0);
			zPos= new BigDecimal(-1.0);
			
			xVectorMag= new BigDecimal(1.0);
			yVectorMag= new BigDecimal(5.0); 
			zVectorMag= new BigDecimal(1.0);
		}
		
		
		bioBoundBox = new BioMightBoundBox(xPos, yPos, zPos, xVectorMag, yVectorMag, zVectorMag);
		bioMightConnectors = new BioMightConnectors();
			
		// Arm Epithelium Connector
		circumference = 0.3;
		startPos = getStartPoints(-8.5, -13.0, -1.0);
		startPoints = BioGraphics.octogonYPlane(startPos, circumference);
		endPos = getEndPoints(-8.75, -18.0, -1.0);
		endPoints = BioGraphics.octogonYPlane(endPos, circumference);
	
		bioMightConnector  = new BioMightConnector(startPoints, endPoints, Constants.ArmEpitheliumRef,"connType");
		bioMightConnectors.setBioMightConnector(Constants.ArmEpitheliumRef, bioMightConnector);
			
		bioBoundBox.setBioMightConnectors(bioMightConnectors);
		
		// Put the Bounding Box into the Collection of Bounding Boxes 
		bioBoundBoxes.setBoundingBox(Constants.RightArmRef, bioBoundBox);		

		// Put the BioMight BoundBoxes for the Arms 
		// into the BoundingBoxMap 
		boundingBoxMap.put(Constants.ArmsRef, bioBoundBoxes);	
	
	
		//**********************************************************************
		// ELBOWS
		//
		// Set up the Bounding Box for the Elbows
		// For default model, length of Elbow is 1.1
		//**********************************************************************

		// Setup the Boxes for the collection
		bioBoundBoxes = new BioMightBoundBoxes();
	
		//********************************************************************* 
		// LEFT ELBOW BOUNDBOX
		// Set up the Bounding Box for the Left Elbow
		// On a porportioned human, the Elbow are located in the --- 
		//**********************************************************************
		xPos = new BigDecimal(8.75);
		yPos = new BigDecimal(-18.0);
		zPos= new BigDecimal(-1.0);
		
		xVectorMag= new BigDecimal(1.0);
		yVectorMag= new BigDecimal(1.0); 
		zVectorMag= new BigDecimal(1.0);

		xVectorDir= new BigDecimal(1.0);
		yVectorDir= new BigDecimal(1.0); 
		zVectorDir= new BigDecimal(1.0);

	
		bioBoundBox = new BioMightBoundBox(xPos, yPos, zPos, xVectorMag, yVectorMag, zVectorMag, xVectorDir, yVectorDir, zVectorDir, theta);
		bioMightConnectors = new BioMightConnectors();
			
		// Elbow Epithelium Connector
		circumference = 0.3;
		startPos = getStartPoints(8.75, -18.0, -1.0);
		startPoints = BioGraphics.octogonYPlane(startPos, circumference);
		endPos = getEndPoints(8.75, -19.0, -1.0);
		endPoints = BioGraphics.octogonYPlane(endPos, circumference);
	
		bioMightConnector  = new BioMightConnector(startPoints, endPoints, Constants.ElbowEpitheliumRef,"connType");
		bioMightConnectors.setBioMightConnector(Constants.ElbowEpitheliumRef, bioMightConnector);
			
		bioBoundBox.setBioMightConnectors(bioMightConnectors);
			
		// Put the Bounding Box into the Collection of Bounding Boxes 
		bioBoundBoxes.setBoundingBox(Constants.LeftElbowRef, bioBoundBox);	
		
		//********************************************************************* 
		// RIGHT ELBOW BOUNDBOX
		// Set up the Bounding Box for the Shoulder
		// On a porportioned human, the Shoulder are located in the --- 
		//*********************************************************************
		xPos = new BigDecimal(-0.5);
		yPos = new BigDecimal(-18.0);
		zPos= new BigDecimal(-1.0);
		
		xVectorMag= new BigDecimal(1.0);
		yVectorMag= new BigDecimal(1.0); 
		zVectorMag= new BigDecimal(1.0);

		bioBoundBox = new BioMightBoundBox(xPos, yPos, zPos, xVectorMag, yVectorMag, zVectorMag);
		bioMightConnectors = new BioMightConnectors();
			
		// Elbow Epithelium Connector
		circumference = 0.3;
		startPos = getStartPoints(-8.75, -18.0, -1.0);
		startPoints = BioGraphics.octogonYPlane(startPos, circumference);
		endPos = getEndPoints(-8.75, -19.0, -1.0);
		endPoints = BioGraphics.octogonYPlane(endPos, circumference);
	
		bioMightConnector  = new BioMightConnector(startPoints, endPoints, Constants.ElbowEpitheliumRef,"connType");
		bioMightConnectors.setBioMightConnector(Constants.ElbowEpitheliumRef, bioMightConnector);
			
		bioBoundBox.setBioMightConnectors(bioMightConnectors);
		
		// Put the Bounding Box into the Collection of Bounding Boxes 
		bioBoundBoxes.setBoundingBox(Constants.RightElbowRef, bioBoundBox);		

		// Put the BioMight BoundBoxes for the Elbow 
		// into the BoundingBoxMap 
		boundingBoxMap.put(Constants.ElbowsRef, bioBoundBoxes);
		
		
		//******************************************************
		// FOREARMS
		// Set up the Bounding Box for the Left ForeArm
		//******************************************************
	
		// Setup the Boxes for the collection
		bioBoundBoxes = new BioMightBoundBoxes();
	
		//********************************************************************* 
		// LEFT FOREARM BOUNDBOX
		// Set up the Bounding Box for the Left ForeArm
		// On a porportioned human, the ForeArm are located in the --- 
		//**********************************************************************
		xPos = new BigDecimal(8.75);
		yPos = new BigDecimal(-19.0);
		zPos= new BigDecimal(-1.0);
		
		xVectorMag= new BigDecimal(1.0);
		yVectorMag= new BigDecimal(1.0); 
		zVectorMag= new BigDecimal(1.0);

		xVectorDir= new BigDecimal(1.0);
		yVectorDir= new BigDecimal(1.0); 
		zVectorDir= new BigDecimal(1.0);

	
		bioBoundBox = new BioMightBoundBox(xPos, yPos, zPos, xVectorMag, yVectorMag, zVectorMag, xVectorDir, yVectorDir, zVectorDir, theta);
		bioMightConnectors = new BioMightConnectors();
			
		// ForeArm Epithelium Connector
		circumference = 0.3;
		startPos = getStartPoints(8.75, -19.0, -1.0);
		startPoints = BioGraphics.octogonYPlane(startPos, circumference);
		endPos = getEndPoints(8.75, -30.0, -1.0);
		endPoints = BioGraphics.octogonYPlane(endPos, circumference);
	
		bioMightConnector  = new BioMightConnector(startPoints, endPoints, Constants.ForeArmEpitheliumRef,"connType");
		bioMightConnectors.setBioMightConnector(Constants.ForeArmEpitheliumRef, bioMightConnector);
			
		bioBoundBox.setBioMightConnectors(bioMightConnectors);
			
		// Put the Bounding Box into the Collection of Bounding Boxes 
		bioBoundBoxes.setBoundingBox(Constants.LeftForeArmRef, bioBoundBox);	
		
		//********************************************************************* 
		// RIGHT FOREARM BOUNDBOX
		// Set up the Bounding Box for the ForeArm
		// On a porportioned human, the ForeArm are located in the --- 
		//**********************************************************************
		xPos = new BigDecimal(-8.5);
		yPos = new BigDecimal(-16.0);
		zPos= new BigDecimal(-1.0);
		
		xVectorMag= new BigDecimal(1.0);
		yVectorMag= new BigDecimal(1.0); 
		zVectorMag= new BigDecimal(1.0);

		bioBoundBox = new BioMightBoundBox(xPos, yPos, zPos, xVectorMag, yVectorMag, zVectorMag);
		bioMightConnectors = new BioMightConnectors();
			
		// ForeArm Epithelium Connector
		circumference = 0.3;
		startPos = getStartPoints(-8.75, -19.0, -1.0);
		startPoints = BioGraphics.octogonYPlane(startPos, circumference);
		endPos = getEndPoints(-8.75, -30.0, -1.0);
		endPoints = BioGraphics.octogonYPlane(endPos, circumference);
	
		bioMightConnector  = new BioMightConnector(startPoints, endPoints, Constants.ForeArmEpitheliumRef,"connType");
		bioMightConnectors.setBioMightConnector(Constants.ForeArmEpitheliumRef, bioMightConnector);
			
		bioBoundBox.setBioMightConnectors(bioMightConnectors);
		
		// Put the Bounding Box into the Collection of Bounding Boxes 
		bioBoundBoxes.setBoundingBox(Constants.RightForeArmRef, bioBoundBox);		

		// Put the BioMight BoundBoxes for the ForeArm 
		// into the BoundingBoxMap 
		boundingBoxMap.put(Constants.ForeArmsRef, bioBoundBoxes);
		
		//*********************************************************************
		// WRISTS BOUNDBOXES
		// Set up the Bounding Boxes for the Wrists
		//
		//*********************************************************************
	
		// Setup the Boxes for the collection
		bioBoundBoxes = new BioMightBoundBoxes();
	
		//********************************************************************* 
		// LEFT WRIST BOUNDBOX
		// Set up the Bounding Box for the Left Wrist
		// On a porportioned human, the Wrist are located in the --- 
		//**********************************************************************
		xPos = new BigDecimal(0.5);
		yPos = new BigDecimal(-30.0);
		zPos= new BigDecimal(-1.0);
		
		xVectorMag= new BigDecimal(1.0);
		yVectorMag= new BigDecimal(1.0); 
		zVectorMag= new BigDecimal(1.0);

		xVectorDir= new BigDecimal(1.0);
		yVectorDir= new BigDecimal(1.0); 
		zVectorDir= new BigDecimal(1.0);

	
		bioBoundBox = new BioMightBoundBox(xPos, yPos, zPos, xVectorMag, yVectorMag, zVectorMag, xVectorDir, yVectorDir, zVectorDir, theta);
		bioMightConnectors = new BioMightConnectors();
			
		// Wrist Epithelium Connector
		circumference = 0.3;
		startPos = getStartPoints(8.75, -30.0, -1.0);
		startPoints = BioGraphics.octogonYPlane(startPos, circumference);
		endPos = getEndPoints(8.75, -31.0, -1.0);
		endPoints = BioGraphics.octogonYPlane(endPos, circumference);
	
		bioMightConnector  = new BioMightConnector(startPoints, endPoints, Constants.WristEpitheliumRef,"connType");
		bioMightConnectors.setBioMightConnector(Constants.WristEpitheliumRef, bioMightConnector);
			
		bioBoundBox.setBioMightConnectors(bioMightConnectors);
			
		// Put the Bounding Box into the Collection of Bounding Boxes 
		bioBoundBoxes.setBoundingBox(Constants.LeftWristRef, bioBoundBox);	
		
		//********************************************************************* 
		// RIGHT WRIST BOUNDBOX
		// Set up the Bounding Box for the Wrist
		// On a porportioned human, the Wrist are located in the --- 
		//**********************************************************************
		xPos = new BigDecimal(-8.75);
		yPos = new BigDecimal(-30.0);
		zPos= new BigDecimal(-1.0);
		
		xVectorMag= new BigDecimal(1.0);
		yVectorMag= new BigDecimal(1.0); 
		zVectorMag= new BigDecimal(1.0);

		bioBoundBox = new BioMightBoundBox(xPos, yPos, zPos, xVectorMag, yVectorMag, zVectorMag);
		bioMightConnectors = new BioMightConnectors();
			
		// Wrist Epithelium Connector
		circumference = 0.3;
		startPos = getStartPoints(-8.75, -30.0, -1.0);
		startPoints = BioGraphics.octogonYPlane(startPos, circumference);
		endPos = getEndPoints(-8.75, -31.0, -1.0);
		endPoints = BioGraphics.octogonYPlane(endPos, circumference);
	
		bioMightConnector  = new BioMightConnector(startPoints, endPoints, Constants.WristEpitheliumRef,"connType");
		bioMightConnectors.setBioMightConnector(Constants.WristEpitheliumRef, bioMightConnector);
			
		bioBoundBox.setBioMightConnectors(bioMightConnectors);
		
		// Put the Bounding Box into the Collection of Bounding Boxes 
		bioBoundBoxes.setBoundingBox(Constants.RightWristRef, bioBoundBox);		

		// Put the BioMight BoundBoxes for the Wrist 
		// into the BoundingBoxMap 
		boundingBoxMap.put(Constants.WristsRef, bioBoundBoxes);
	
		//*********************************************************************
		// HANDS BOUNDING BOXES
		// Set up the Bounding Boxes
		//*********************************************************************
	
		// Setup the Boxes for the collection
		bioBoundBoxes = new BioMightBoundBoxes();
	
		//********************************************************************* 
		// LEFT HANDS BOUNDBOX
		// Set up the Bounding Box for the Left Hand
		// On a porportioned human, the Hand are located in the --- 
		//**********************************************************************
		xPos = new BigDecimal(0.5);
		yPos = new BigDecimal(-12.0);
		zPos= new BigDecimal(-1.0);
		
		xVectorMag= new BigDecimal(1.0);
		yVectorMag= new BigDecimal(1.0); 
		zVectorMag= new BigDecimal(1.0);

		xVectorDir= new BigDecimal(1.0);
		yVectorDir= new BigDecimal(1.0); 
		zVectorDir= new BigDecimal(1.0);

	
		bioBoundBox = new BioMightBoundBox(xPos, yPos, zPos, xVectorMag, yVectorMag, zVectorMag, xVectorDir, yVectorDir, zVectorDir, theta);
		bioMightConnectors = new BioMightConnectors();
			
		// Hand Epithelium Connector
		circumference = 0.3;
		startPos = getStartPoints(0.5, -12.0, -1.0);
		startPoints = BioGraphics.octogonYPlane(startPos, circumference);
		endPos = getEndPoints(0.75, -13.0, -1.0);
		endPoints = BioGraphics.octogonYPlane(endPos, circumference);
	
		bioMightConnector  = new BioMightConnector(startPoints, endPoints, Constants.HandEpitheliumRef,"connType");
		bioMightConnectors.setBioMightConnector(Constants.HandEpitheliumRef, bioMightConnector);
			
		bioBoundBox.setBioMightConnectors(bioMightConnectors);
			
		// Put the Bounding Box into the Collection of Bounding Boxes 
		bioBoundBoxes.setBoundingBox(Constants.LeftHandRef, bioBoundBox);	
		
		//********************************************************************* 
		// RIGHT HAND BOUNDBOX
		// Set up the Bounding Box for the Hand
		// On a porportioned human, the Hand are located in the --- 
		//**********************************************************************
		xPos = new BigDecimal(-0.5);
		yPos = new BigDecimal(-12.0);
		zPos= new BigDecimal(-1.0);
		
		xVectorMag= new BigDecimal(1.0);
		yVectorMag= new BigDecimal(1.0); 
		zVectorMag= new BigDecimal(1.0);

		bioBoundBox = new BioMightBoundBox(xPos, yPos, zPos, xVectorMag, yVectorMag, zVectorMag);
		bioMightConnectors = new BioMightConnectors();
			
		// Hand Epithelium Connector
		circumference = 0.3;
		startPos = getStartPoints(-8.5, -12.0, -1.0);
		startPoints = BioGraphics.octogonYPlane(startPos, circumference);
		endPos = getEndPoints(-8.75, -13.0, -1.0);
		endPoints = BioGraphics.octogonYPlane(endPos, circumference);
	
		bioMightConnector  = new BioMightConnector(startPoints, endPoints, Constants.HandEpitheliumRef,"connType");
		bioMightConnectors.setBioMightConnector(Constants.HandEpitheliumRef, bioMightConnector);
			
		bioBoundBox.setBioMightConnectors(bioMightConnectors);
		
		// Put the Bounding Box into the Collection of Bounding Boxes 
		bioBoundBoxes.setBoundingBox(Constants.RightHandRef, bioBoundBox);		

		// Put the BioMight BoundBoxes for the Hand 
		// into the BoundingBoxMap 
		boundingBoxMap.put(Constants.HandsRef, bioBoundBoxes);	
	
		//**********************************************************************
		// ABDOMEN
		//
		// Set up the Bounding Box for the Abdomen
		//**********************************************************************
		xPos = new BigDecimal(0.0);
		yPos = new BigDecimal(-21.0);
		zPos= new BigDecimal(-5.5);
	
		xVector= new BigDecimal(11.5);
		yVector= new BigDecimal(6.0); 
		zVector= new BigDecimal(5.0);		

		bioBoundBox = new BioMightBoundBox(xPos, yPos, zPos, xVector, yVector, zVector);
		bioMightConnectors = new BioMightConnectors();
		
		//********************************************
		// ABDOMEN - ORGAN CONNECTORS
		//********************************************
	
		// Skin Connector
		circumference = 0.3;
		startPos = getStartPoints(0.0, -16.0, -1.0);
		startPoints = BioGraphics.octogonYPlane(startPos, circumference);
		bioMightConnector = new BioMightConnector(startPoints, Constants.AbdomenEpitheliumRef,"connType");
		bioMightConnectors.setBioMightConnector(Constants.AbdomenEpitheliumRef, bioMightConnector);

		// Esophagus Connector 
		circumference = 0.3;
		startPos = getStartPoints(0.0, -16.0, -1.0);
		startPoints = BioGraphics.octogonYPlane(startPos, circumference);
		bioMightConnector  = new BioMightConnector(startPoints, Constants.EsophagusRef,"connType");
		bioMightConnectors.setBioMightConnector(Constants.EsophagusRef, bioMightConnector);
		
		//********************************************	
		// ABDOMEN - VASCULAR CONNECTORS  
		//********************************************
	
		//********************************************
		// ABDOMEN - MUSCULAR CONNECTORS
		//********************************************

		//********************************************
		// ABDOMEN - SKELETAL CONNECTORS
		//********************************************

		
		// Stuff in the Bounding Box Map
		bioBoundBox.setBioMightConnectors(bioMightConnectors);
		boundingBoxMap.put(Constants.AbdomenRef, bioBoundBox);
	
		
		//****************************************************
		// HIPS  BOUND BOXES
		// Set up the Bounding Box for the Hips
		// Default Model 26-31
		//****************************************************
	
		// Setup the Boxes for the collection
		bioBoundBoxes = new BioMightBoundBoxes();
		
		//********************************************************************* 
		// LEFT HIP BOUNDBOX
		// Set up the Bounding Box for the Left Hip
		// On a porportioned human, the Hip are located in the --- 
		//**********************************************************************
		xPos = new BigDecimal(0.5);
		yPos = new BigDecimal(-26.0);
		zPos= new BigDecimal(-3.0);
		
		xVectorMag= new BigDecimal(1.00);
		yVectorMag= new BigDecimal(1.00); 
		zVectorMag= new BigDecimal(1.0);

		xVectorDir= new BigDecimal(1.0);
		yVectorDir= new BigDecimal(1.0); 
		zVectorDir= new BigDecimal(1.0);

		bioBoundBox = new BioMightBoundBox(xPos, yPos, zPos, xVectorMag, yVectorMag, zVectorMag, xVectorDir, yVectorDir, zVectorDir, theta);
		bioMightConnectors = new BioMightConnectors();
			
		// Hip Epithelium Connector
		circumference = 0.3;
		startPos = getStartPoints(0.5, -26.0, -3.0);
		startPoints = BioGraphics.octogonYPlane(startPos, circumference);
		endPos = getEndPoints(0.75, -34.0, -3.0);
		endPoints = BioGraphics.octogonYPlane(endPos, circumference);
	
		bioMightConnector  = new BioMightConnector(startPoints, endPoints, Constants.HipEpitheliumRef,"connType");
		bioMightConnectors.setBioMightConnector(Constants.HipEpitheliumRef, bioMightConnector);
			
		bioBoundBox.setBioMightConnectors(bioMightConnectors);
			
		// Put the Bounding Box into the Collection of Bounding Boxes 
		bioBoundBoxes.setBoundingBox(Constants.LeftHipRef, bioBoundBox);	
		
		//********************************************************************* 
		// RIGHT HIP BOUNDBOX
		// Set up the Bounding Box for the Hip
		// On a porportioned human, the Hip are located in the --- 
		//**********************************************************************
		xPos = new BigDecimal(-0.5);
		yPos = new BigDecimal(-26.0);
		zPos= new BigDecimal(-3.0);
		
		xVectorMag= new BigDecimal(1.0);
		yVectorMag= new BigDecimal(1.0); 
		zVectorMag= new BigDecimal(1.0);

		bioBoundBox = new BioMightBoundBox(xPos, yPos, zPos, xVectorMag, yVectorMag, zVectorMag);
		bioMightConnectors = new BioMightConnectors();
			
		// Hip Epithelium Connector
		circumference = 0.3;
		startPos = getStartPoints(-8.5, -26.0, -3.0);
		startPoints = BioGraphics.octogonYPlane(startPos, circumference);
		endPos = getEndPoints(-8.75, -34.0, -3.0);
		endPoints = BioGraphics.octogonYPlane(endPos, circumference);
	
		bioMightConnector  = new BioMightConnector(startPoints, endPoints, Constants.HipEpitheliumRef,"connType");
		bioMightConnectors.setBioMightConnector(Constants.HipEpitheliumRef, bioMightConnector);
			
		bioBoundBox.setBioMightConnectors(bioMightConnectors);
		
		// Put the Bounding Box into the Collection of Bounding Boxes 
		bioBoundBoxes.setBoundingBox(Constants.RightHipRef, bioBoundBox);		

		// Put the BioMight BoundBoxes for the Hips 
		// into the BoundingBoxMap 
		boundingBoxMap.put(Constants.HipsRef, bioBoundBoxes);	
	

		//****************************************************
		// THIGHS  BOUND BOXES
		// Set up the Bounding Box for the Thigh
		// Default Model 26-31
		//****************************************************
		
		// Setup the Boxes for the collection
		bioBoundBoxes = new BioMightBoundBoxes();
	
		//********************************************************************* 
		// LEFT THIGH BOUNDBOX
		// Set up the Bounding Box for the Left Thigh
		// On a porportioned human, the Thigh are located in the --- 
		//**********************************************************************
		xPos = new BigDecimal(0.5);
		yPos = new BigDecimal(-34.0);
		zPos= new BigDecimal(-3.0);
		
		xVectorMag= new BigDecimal(1.00);
		yVectorMag= new BigDecimal(8.00); 
		zVectorMag= new BigDecimal(1.00);

		xVectorDir= new BigDecimal(1.00);
		yVectorDir= new BigDecimal(1.00); 
		zVectorDir= new BigDecimal(1.00);

		bioBoundBox = new BioMightBoundBox(xPos, yPos, zPos, xVectorMag, yVectorMag, zVectorMag, xVectorDir, yVectorDir, zVectorDir, theta);
		bioMightConnectors = new BioMightConnectors();
			
		// Thigh Epithelium Connector
		circumference = 0.3;
		startPos = getStartPoints(0.50, -34.0, -3.0);
		startPoints = BioGraphics.octogonYPlane(startPos, circumference);
		endPos = getEndPoints(0.75, -44.0, -3.0);
		endPoints = BioGraphics.octogonYPlane(endPos, circumference);
	
		bioMightConnector  = new BioMightConnector(startPoints, endPoints, Constants.ThighEpitheliumRef,"connType");
		bioMightConnectors.setBioMightConnector(Constants.ThighEpitheliumRef, bioMightConnector);
			
		bioBoundBox.setBioMightConnectors(bioMightConnectors);
			
		// Put the Bounding Box into the Collection of Bounding Boxes 
		bioBoundBoxes.setBoundingBox(Constants.LeftThighRef, bioBoundBox);	
		
		//********************************************************************* 
		// RIGHT THIGH BOUNDBOX
		// Set up the Bounding Box for the Thigh
		// On a porportioned human, the Thigh are located in the --- 
		//**********************************************************************
		xPos = new BigDecimal(-0.50);
		yPos = new BigDecimal(-34.00);
		zPos= new BigDecimal(-3.00);
		
		xVectorMag= new BigDecimal(1.00);
		yVectorMag= new BigDecimal(8.00); 
		zVectorMag= new BigDecimal(1.00);

		bioBoundBox = new BioMightBoundBox(xPos, yPos, zPos, xVectorMag, yVectorMag, zVectorMag);
		bioMightConnectors = new BioMightConnectors();
			
		// Thigh Epithelium Connector
		circumference = 0.3;
		startPos = getStartPoints(-8.5, -34.0, -1.0);
		startPoints = BioGraphics.octogonYPlane(startPos, circumference);
		endPos = getEndPoints(-8.75, -44.0, -1.0);
		endPoints = BioGraphics.octogonYPlane(endPos, circumference);
	
		bioMightConnector  = new BioMightConnector(startPoints, endPoints, Constants.ThighEpitheliumRef,"connType");
		bioMightConnectors.setBioMightConnector(Constants.ThighEpitheliumRef, bioMightConnector);
			
		bioBoundBox.setBioMightConnectors(bioMightConnectors);
		
		// Put the Bounding Box into the Collection of Bounding Boxes 
		bioBoundBoxes.setBoundingBox(Constants.RightThighRef, bioBoundBox);		

		// Put the BioMight BoundBoxes for the Thigh 
		// into the BoundingBoxMap 
		boundingBoxMap.put(Constants.ThighsRef, bioBoundBoxes);	
	
		
		//****************************************************
		// KNEES
		// Set up the Bounding Box for the Left Knee
		// On Default, 46-50
		//****************************************************
	
		// Setup the Boxes for the collection
		bioBoundBoxes = new BioMightBoundBoxes();
	
		//********************************************************************* 
		// LEFT KNEE BOUNDBOX
		// Set up the Bounding Box for the Left Knee
		// On a porportioned human, the Knee are located in the --- 
		//**********************************************************************
		xPos = new BigDecimal(0.5);
		yPos = new BigDecimal(-44.0);
		zPos= new BigDecimal(-3.0);
		
		xVectorMag= new BigDecimal(1.0);
		yVectorMag= new BigDecimal(1.0); 
		zVectorMag= new BigDecimal(1.0);

		xVectorDir= new BigDecimal(1.0);
		yVectorDir= new BigDecimal(1.0); 
		zVectorDir= new BigDecimal(1.0);

		bioBoundBox = new BioMightBoundBox(xPos, yPos, zPos, xVectorMag, yVectorMag, zVectorMag, xVectorDir, yVectorDir, zVectorDir, theta);
		bioMightConnectors = new BioMightConnectors();
			
		// Knee Epithelium Connector
		circumference = 0.3;
		startPos = getStartPoints(0.5, -44.0, -3.0);
		startPoints = BioGraphics.octogonYPlane(startPos, circumference);
		endPos = getEndPoints(0.75, -48.0, -3.0);
		endPoints = BioGraphics.octogonYPlane(endPos, circumference);
	
		bioMightConnector  = new BioMightConnector(startPoints, endPoints, Constants.KneeEpitheliumRef,"connType");
		bioMightConnectors.setBioMightConnector(Constants.KneeEpitheliumRef, bioMightConnector);
			
		bioBoundBox.setBioMightConnectors(bioMightConnectors);
			
		// Put the Bounding Box into the Collection of Bounding Boxes 
		bioBoundBoxes.setBoundingBox(Constants.LeftKneeRef, bioBoundBox);	
		
		//********************************************************************* 
		// RIGHT KNEE BOUNDBOX
		// Set up the Bounding Box for the Knee
		// On a porportioned human, the Knee are located in the --- 
		//**********************************************************************
		xPos = new BigDecimal(-0.5);
		yPos = new BigDecimal(-44.0);
		zPos= new BigDecimal(-3.0);
		
		xVectorMag= new BigDecimal(1.0);
		yVectorMag= new BigDecimal(1.0); 
		zVectorMag= new BigDecimal(1.0);

		bioBoundBox = new BioMightBoundBox(xPos, yPos, zPos, xVectorMag, yVectorMag, zVectorMag);
		bioMightConnectors = new BioMightConnectors();
			
		// Knee Epithelium Connector
		circumference = 0.3;
		startPos = getStartPoints(-8.5, -44.0, -1.0);
		startPoints = BioGraphics.octogonYPlane(startPos, circumference);
		endPos = getEndPoints(-8.75, -48.0, -1.0);
		endPoints = BioGraphics.octogonYPlane(endPos, circumference);
	
		bioMightConnector  = new BioMightConnector(startPoints, endPoints, Constants.KneeEpitheliumRef,"connType");
		bioMightConnectors.setBioMightConnector(Constants.KneeEpitheliumRef, bioMightConnector);
			
		bioBoundBox.setBioMightConnectors(bioMightConnectors);
		
		// Put the Bounding Box into the Collection of Bounding Boxes 
		bioBoundBoxes.setBoundingBox(Constants.RightKneeRef, bioBoundBox);		

		// Put the BioMight BoundBoxes for the Knee 
		// into the BoundingBoxMap 
		boundingBoxMap.put(Constants.KneesRef, bioBoundBoxes);	
	
		
		//****************************************************
		// CNEMIS
		// Set up the Bounding Box for the Cnemis
		//  Default 50-65
		//****************************************************
	
		// Setup the Boxes for the collection
		bioBoundBoxes = new BioMightBoundBoxes();
		
		//********************************************************************* 
		// LEFT CNEMIS BOUNDBOX
		// Set up the Bounding Box for the Left Cnemis
		// On a porportioned human, the Cnemis are located in the --- 
		//**********************************************************************
		xPos = new BigDecimal(0.5);
		yPos = new BigDecimal(-50.0);
		zPos= new BigDecimal(-3.0);
		
		xVectorMag= new BigDecimal(1.0);
		yVectorMag= new BigDecimal(1.0); 
		zVectorMag= new BigDecimal(1.0);

		xVectorDir= new BigDecimal(1.0);
		yVectorDir= new BigDecimal(1.0); 
		zVectorDir= new BigDecimal(1.0);

		bioBoundBox = new BioMightBoundBox(xPos, yPos, zPos, xVectorMag, yVectorMag, zVectorMag, xVectorDir, yVectorDir, zVectorDir, theta);
		bioMightConnectors = new BioMightConnectors();
			
		// Cnemis Epithelium Connector
		circumference = 0.3;
		startPos = getStartPoints(0.5, -50.0, -3.0);
		startPoints = BioGraphics.octogonYPlane(startPos, circumference);
		endPos = getEndPoints(0.75, -62.0, -3.0);
		endPoints = BioGraphics.octogonYPlane(endPos, circumference);
	
		bioMightConnector  = new BioMightConnector(startPoints, endPoints, Constants.CnemisEpitheliumRef,"connType");
		bioMightConnectors.setBioMightConnector(Constants.CnemisEpitheliumRef, bioMightConnector);
			
		bioBoundBox.setBioMightConnectors(bioMightConnectors);
			
		// Put the Bounding Box into the Collection of Bounding Boxes 
		bioBoundBoxes.setBoundingBox(Constants.LeftCnemisRef, bioBoundBox);	
		
		//********************************************************************* 
		// RIGHT CNEMIS BOUNDBOX
		// Set up the Bounding Box for the Cnemis
		// On a porportioned human, the Cnemis are located in the --- 
		//**********************************************************************
		xPos = new BigDecimal(-0.5);
		yPos = new BigDecimal(-48.0);
		zPos= new BigDecimal(-3.0);
		
		xVectorMag= new BigDecimal(1.0);
		yVectorMag= new BigDecimal(1.0); 
		zVectorMag= new BigDecimal(1.0);

		bioBoundBox = new BioMightBoundBox(xPos, yPos, zPos, xVectorMag, yVectorMag, zVectorMag);
		bioMightConnectors = new BioMightConnectors();
			
		// Cnemis Epithelium Connector
		circumference = 0.3;
		startPos = getStartPoints(-8.5, -50.0, -1.0);
		startPoints = BioGraphics.octogonYPlane(startPos, circumference);
		endPos = getEndPoints(-8.75, -62.0, -1.0);
		endPoints = BioGraphics.octogonYPlane(endPos, circumference);
	
		bioMightConnector  = new BioMightConnector(startPoints, endPoints, Constants.CnemisEpitheliumRef,"connType");
		bioMightConnectors.setBioMightConnector(Constants.CnemisEpitheliumRef, bioMightConnector);
			
		bioBoundBox.setBioMightConnectors(bioMightConnectors);
		
		// Put the Bounding Box into the Collection of Bounding Boxes 
		bioBoundBoxes.setBoundingBox(Constants.RightCnemisRef, bioBoundBox);		

		// Put the BioMight BoundBoxes for the Cnemis 
		// into the BoundingBoxMap 
		boundingBoxMap.put(Constants.CnemesRef, bioBoundBoxes);	
	
		
		//****************************************************
		// FEET
		// On Default 64-67.5
		// Set up the Bounding Box for the Feet
		//****************************************************
		
		// Setup the Boxes for the collection
		bioBoundBoxes = new BioMightBoundBoxes();
	
		//********************************************************************* 
		// LEFT FOOT BOUNDBOX
		// Set up the Bounding Box for the Left Foot
		// On a porportioned human, the Foot are located in the --- 
		//**********************************************************************
		xPos = new BigDecimal(0.5);
		yPos = new BigDecimal(-64.0);
		zPos= new BigDecimal(-3.0);
		
		xVectorMag= new BigDecimal(1.0);
		yVectorMag= new BigDecimal(1.0); 
		zVectorMag= new BigDecimal(1.0);

		xVectorDir= new BigDecimal(1.0);
		yVectorDir= new BigDecimal(1.0); 
		zVectorDir= new BigDecimal(1.0);

		bioBoundBox = new BioMightBoundBox(xPos, yPos, zPos, xVectorMag, yVectorMag, zVectorMag, xVectorDir, yVectorDir, zVectorDir, theta);
		bioMightConnectors = new BioMightConnectors();
			
		// Foot Epithelium Connector
		circumference = 0.3;
		startPos = getStartPoints(0.5, -64.0, -3.0);
		startPoints = BioGraphics.octogonYPlane(startPos, circumference);
		endPos = getEndPoints(0.75, -67.5, -3.0);
		endPoints = BioGraphics.octogonYPlane(endPos, circumference);
	
		bioMightConnector  = new BioMightConnector(startPoints, endPoints, Constants.FootEpitheliumRef,"connType");
		bioMightConnectors.setBioMightConnector(Constants.FootEpitheliumRef, bioMightConnector);
			
		bioBoundBox.setBioMightConnectors(bioMightConnectors);
			
		// Put the Bounding Box into the Collection of Bounding Boxes 
		bioBoundBoxes.setBoundingBox(Constants.LeftFootRef, bioBoundBox);	
		
		//********************************************************************* 
		// RIGHT FOOT BOUNDBOX
		// Set up the Bounding Box for the Foot
		// On a porportioned human, the Foot are located in the --- 
		//**********************************************************************
		xPos = new BigDecimal(-0.5);
		yPos = new BigDecimal(-64.0);
		zPos= new BigDecimal(-3.0);
		
		xVectorMag= new BigDecimal(1.00);
		yVectorMag= new BigDecimal(1.00); 
		zVectorMag= new BigDecimal(1.00);

		bioBoundBox = new BioMightBoundBox(xPos, yPos, zPos, xVectorMag, yVectorMag, zVectorMag);
		bioMightConnectors = new BioMightConnectors();
			
		// Foot Epithelium Connector
		circumference = 0.3;
		startPos = getStartPoints(-8.5, -64.5, -1.0);
		startPoints = BioGraphics.octogonYPlane(startPos, circumference);
		endPos = getEndPoints(-8.75, -67.5, -1.0);
		endPoints = BioGraphics.octogonYPlane(endPos, circumference);
	
		bioMightConnector  = new BioMightConnector(startPoints, endPoints, Constants.FootEpitheliumRef,"connType");
		bioMightConnectors.setBioMightConnector(Constants.FootEpitheliumRef, bioMightConnector);
			
		bioBoundBox.setBioMightConnectors(bioMightConnectors);
		
		// Put the Bounding Box into the Collection of Bounding Boxes 
		bioBoundBoxes.setBoundingBox(Constants.RightFootRef, bioBoundBox);		

		// Put the BioMight BoundBoxes for the Feet 
		// into the BoundingBoxMap 
		boundingBoxMap.put(Constants.FeetRef, bioBoundBoxes);		
				
		return (boundingBoxMap);
		}
	
	
	// Show the various Systems
	public void showSkeletalSystem() {
		
	}
	
	public void showMuscularSystem() {
		
	}

	public void showCirculatorySystem() {
		
	}
	
	public void showDigestiveSystem() {
		
	}
	
	public void showNervousSystem() {
		
	}

	public void showEndocrineSystem() {
		
	}	

	public void showBiliarySystem() {
		
	}		

	public void showExecretorySystem() {
		
	}

	public void showLigamentSystem() {
		
	}
	
	public void showLymphaticSystem() {
		
	}		

	public void showRespiratorySystem() {
		
	}

	public void showUrinarySystem() {
		
	}

	public void showReproductiveSystem() {
		
	}

	public void showIntegumentarySystem() {
		
	}
	

	public String getBodyType() {
		return bodyType;
	}


	public void setBodyType(String bodyType) {
		this.bodyType = bodyType;
	}


	public String getEthnicity() {
		return ethnicity;
	}


	public void setEthnicity(String ethnicity) {
		this.ethnicity = ethnicity;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public boolean isBurping() {
		return isBurping;
	}


	public void setBurping(boolean isBurping) {
		this.isBurping = isBurping;
	}


	public boolean isCrying() {
		return isCrying;
	}


	public void setCrying(boolean isCrying) {
		this.isCrying = isCrying;
	}


	public boolean isDancing() {
		return isDancing;
	}


	public void setDancing(boolean isDancing) {
		this.isDancing = isDancing;
	}


	public boolean isDigesting() {
		return isDigesting;
	}


	public void setDigesting(boolean isDigesting) {
		this.isDigesting = isDigesting;
	}


	public boolean isDying() {
		return isDying;
	}


	public void setDying(boolean isDying) {
		this.isDying = isDying;
	}


	public boolean isFarting() {
		return isFarting;
	}


	public void setFarting(boolean isFarting) {
		this.isFarting = isFarting;
	}


	public boolean isGrowing() {
		return isGrowing;
	}


	public void setGrowing(boolean isGrowing) {
		this.isGrowing = isGrowing;
	}


	public boolean isJogging() {
		return isJogging;
	}


	public void setJogging(boolean isJogging) {
		this.isJogging = isJogging;
	}


	public boolean isJumpimg() {
		return isJumpimg;
	}


	public void setJumpimg(boolean isJumpimg) {
		this.isJumpimg = isJumpimg;
	}


	public boolean isRespiring() {
		return isRespiring;
	}


	public void setRespiring(boolean isRespiring) {
		this.isRespiring = isRespiring;
	}


	public boolean isRunning() {
		return isRunning;
	}


	public void setRunning(boolean isRunning) {
		this.isRunning = isRunning;
	}


	public boolean isSecreting() {
		return isSecreting;
	}


	public void setSecreting(boolean isSecreting) {
		this.isSecreting = isSecreting;
	}


	public boolean isShaking() {
		return isShaking;
	}


	public void setShaking(boolean isShaking) {
		this.isShaking = isShaking;
	}


	public boolean isShivering() {
		return isShivering;
	}


	public void setShivering(boolean isShivering) {
		this.isShivering = isShivering;
	}


	public boolean isSinging() {
		return isSinging;
	}


	public void setSinging(boolean isSinging) {
		this.isSinging = isSinging;
	}


	public boolean isSpitting() {
		return isSpitting;
	}


	public void setSpitting(boolean isSpitting) {
		this.isSpitting = isSpitting;
	}


	public boolean isStandingErect() {
		return isStandingErect;
	}


	public void setStandingErect(boolean isStandingErect) {
		this.isStandingErect = isStandingErect;
	}


	public boolean isStandingSlouched() {
		return isStandingSlouched;
	}


	public void setStandingSlouched(boolean isStandingSlouched) {
		this.isStandingSlouched = isStandingSlouched;
	}


	public boolean isSwallowing() {
		return isSwallowing;
	}


	public void setSwallowing(boolean isSwallowing) {
		this.isSwallowing = isSwallowing;
	}


	public boolean isTalking() {
		return isTalking;
	}


	public void setTalking(boolean isTalking) {
		this.isTalking = isTalking;
	}


	public boolean isWalking() {
		return isWalking;
	}


	public void setWalking(boolean isWalking) {
		this.isWalking = isWalking;
	}


	public boolean isWhistling() {
		return isWhistling;
	}


	public void setWhistling(boolean isWhistling) {
		this.isWhistling = isWhistling;
	}



	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public double getWeight() {
		return weight;
	}


	public void setWeight(double weight) {
		this.weight = weight;
	}

	
	public boolean validateWeight(double weight) {
		boolean goodWeight = false;
		
		// if running models that conform to the human norm are on,
		if (model.equals("Human"))
		{
			// Base Parameters of default constraints that set up
			// the base domain upon which BioMight can function
			//if (weight > 200 && height < 48)
			//{
				
			//}
		
		}
		else if (model.equals("Mutant"))
		{
			// Base Parameters of default constraints that set up
			// the base domain upon which BioMight can function
		}		
		

		
		return goodWeight;
	}
	

	public Abdomen getAbdomen() {
		return abdomen;
	}


	public void setAbdomen(Abdomen abdomen) {
		this.abdomen = abdomen;
	}


	public Anus getAnus() {
		return anus;
	}


	public void setAnus(Anus anus) {
		this.anus = anus;
	}


	public Back getBack() {
		return back;
	}


	public void setBack(Back back) {
		this.back = back;
	}


	public Chest getChest() {
		return chest;
	}


	public void setChest(Chest chest) {
		this.chest = chest;
	}


	public Head getHead() {
		return head;
	}


	public void setHead(Head head) {
		this.head = head;
	}


	public Hip getHip() {
		return hip;
	}


	public void setHip(Hip hip) {
		this.hip = hip;
	}



	public LeftNipple getLeftNipple() {
		return leftNipple;
	}


	public void setLeftNipple(LeftNipple leftNipple) {
		this.leftNipple = leftNipple;
	}


	

	public Navel getNavel() {
		return navel;
	}


	public void setNavel(Navel navel) {
		this.navel = navel;
	}


	public Neck getNeck() {
		return neck;
	}


	public void setNeck(Neck neck) {
		this.neck = neck;
	}


	public RightBreast getRightBreast() {
		return rightBreast;
	}


	public void setRightBreast(RightBreast rightBreast) {
		this.rightBreast = rightBreast;
	}
	
	public RightNipple getRightNipple() {
		return rightNipple;
	}


	public void setRightNipple(RightNipple rightNipple) {
		this.rightNipple = rightNipple;
	}

	public Vagina getVagina() {
		return vagina;
	}


	public void setVagina(Vagina vagina) {
		this.vagina = vagina;
	}

}
