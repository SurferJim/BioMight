/*
 * Created on Sep 5, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.system.vascular.veins.neck;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;

import javax.naming.InitialContext;



import biomight.Constants;
import biomight.ejb.BioMightBeanLocal;
import biomight.ejb.BioMightVascularBeanLocal;
import biomight.exceptions.ServerException;
import biomight.system.tissue.edothelial.EndotheliumTissue;
import biomight.system.vascular.veins.Vein;
import biomight.util.BioGraphics;
import biomight.view.BioMightBoundBox;
import biomight.view.BioMightConnector;
import biomight.view.BioMightConnectors;
import biomight.view.BioMightConstruct;
import biomight.view.BioMightGenerate;
import biomight.view.BioMightMethodView;
import biomight.view.BioMightPosition;
import biomight.view.BioMightPropertyView;
import biomight.view.BioMightTransform;

/**
 * @author SurferJim
 *
 * Representation of the MiddleThyroidVein
 */


public class MiddleThyroidVein extends Vein {
	protected EndotheliumTissue endothelium;
	
	
	public MiddleThyroidVein()
	{
		create(Constants.MiddleThyroidVein, null,null);
	}

	public MiddleThyroidVein(String parentID)
	{
		create(parentID, null, null);
	}
	
	public MiddleThyroidVein(String parentID, BioMightConstruct bioMightConstruct, ArrayList<BioMightMethodView> bioMightMethods)
	{
		create(parentID, bioMightConstruct, bioMightMethods);
	}
	
	/********************************************************************************************************************
	 * CREATE MiddleThyroidVein
	 * 
	 * This method will instantiate the MiddleThyroidVein that are defined for the current model.  
	 * 
	 ********************************************************************************************************************/

	
	public void create(String parentID, BioMightConstruct bioMightConstruct, ArrayList<BioMightMethodView> bioMightMethods)
	{
		this.setImage("images/MiddleThyroidVein.jpg");
		this.setImageHeight(300);
		this.setImageWidth(300);
	

		// Get the Bounding Box from the Constructor that defines the perimeter of MiddleThyroidVein
		// Pass that into the BoundingBoxes method so it can be divied up.
		HashMap boundingBoxes = setupBoundBoxes(bioMightConstruct.getBoundingBox(Constants.MiddleThyroidVeinsRef));
		System.out.println("Bounding Boxes for MiddleThyroidVein Created");

		// Get the Connection Map from the Constructor - this contains the connectors
		// that are needed to link up the MiddleThyroidVein
		//BioMightGenerate bioMightGenerateIn = bioMightConstruct.getGenerateMap();	
		
		// Build the model based on what you are looking based on LOD
		int viewPerspective = Constants.VIEW_DETACHED;
		if (viewPerspective == Constants.VIEW_DETACHED)
		{	
			componentID=parentID;
			
			// Generate the MiddleThyroidVein if needed
			// We should really be creating this at the Epithelial?  
			// Or do we create at the level above so we have it in advance of
			// going in?
			boolean bGenerate = false;
			BioMightGenerate middleThyroidVeinBioGen = null;
			if (bGenerate) {
				middleThyroidVeinBioGen = generate(parentID, componentID, bioMightConstruct);
			}
			this.bioMightGenerate.setMapComponent(componentID, middleThyroidVeinBioGen);
			
			
			System.out.println("Creating MiddleThyroidVein Endothelium: " + parentID);	
			endothelium = new EndotheliumTissue("MiddleThyroidVeinEndothelium", parentID,bioMightMethods);
			initProperty("MiddleThyroidVeinEndothelium", Constants.EndotheliumTissue, Constants.EndotheliumTissueRef, endothelium.getComponentID());
		}
		else // Assemble now
		{			
			// Get the information from the database via the Enterprise Bean		
			try {
				// Get the information from the database via the Enterprise Bean		
				System.out.println("Getting MiddleThyroidVeinInfo for ParentID: " + parentID);
				InitialContext ctx = new InitialContext();
				BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
				bioMightTransforms = bioMightBean.getComponents(Constants.MiddleThyroidVeinRef, parentID);
				System.out.println("Have MiddleThyroidVein Info from EJB");   	
			}catch (Exception e) { 
				System.out.println("Exception Getting Components - MiddleThyroidVein");
				throw new ServerException("Remote Exception getComponents():", e); 	
			}
				
			// Run through the collection of MiddleThyroidVeins and build them into the model
			// In the default case, we get one instance of the MiddleThyroidVein for each eye
			ArrayList transforms = bioMightTransforms.getTransforms();
			System.out.println("MiddleThyroidVein NumTransforms: " + transforms.size());
			for (int i=0; i<transforms.size(); i++)
			{
				// Get the information for the eye we are creating
				BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
				System.out.println("Created MiddleThyroidVein: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
				this.componentID = bioMightTransform.getId();
				
				System.out.println("Creating MiddleThyroidVein Endothelium: " + bioMightTransform.getId());	
				endothelium = new EndotheliumTissue("MiddleThyroidVeinEndothelium", bioMightTransform.getId(),bioMightMethods);
				initProperty("MiddleThyroidVeinEndothelium", Constants.EndotheliumTissue, Constants.EndotheliumTissueRef, endothelium.getComponentID());
			}
			
		}
		
		//initProperties();
		initMethods();
		
		System.out.println("CreateMiddleThyroidVein Completed");
		
		// First, get all the data from the database
		// Apply the methods to it
		// Save its state
		this.parentID = parentID;
		if (bioMightMethods != null){
			System.out.println("EXECUTING MiddleThyroidVein METHODS: " + bioMightMethods.size());
			//executeMethods(bioMightMethods);
		}
	}
	
	/************************************************************************************
	 * GENERATE MIDDLE THYROID VEIN
	 * 
	 * @param parentID
	 * @param componentID
	 ***********************************************************************************/
	
	public BioMightGenerate generate(String parentID, String componentID, BioMightConstruct bioMightConstruct)
	{
		// Generate the MiddleThyroidVein		
		BioMightVascularBeanLocal bioMightBean;
		BioMightGenerate middleThyroidVeinBioGen = null;
		
		
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Generating the MiddleThyroidVeinEndothelium: " + componentID + "    " + parentID);
			InitialContext ctx = new InitialContext();
			bioMightBean = (BioMightVascularBeanLocal) ctx.lookup("java:global/BioMightWeb/BioMightVacularBean!biomight.ejb.BioMightVascularBeanLocal");
			
			// Left Internal Carotid Artery - Cervical Region
			if (componentID.equals("MiddleThyroidVein:01")) 
			{	
				
				
			
				
				System.out.println("Calling Generate MiddleThyroidVeinyEndothelium: " + componentID + "    " + parentID);
				
			 	// Load up the contruction information to pass to the EJB
		    	
		    	//bioMightGenerate = bioMightBean.generateMiddleThyroidVein(bioMightConstruct);			
				middleThyroidVeinBioGen = bioMightBean.generateMiddleThyroidVein("MiddleThyroidVeinEndothelium:00001", "MiddleThyroidVeinEndothelium", 
		    		"MiddleThyroidVeinEndothelium", componentID, parentID, bioMightConstruct);			
					
			}
			// Right Internal Carotid Artery - Cervicle Region
			else if (componentID.equals("MiddleThyroidVein:02")) 
			{	
				// Generate the MiddleThyroidVeinEndothelium 
				if (bioMightConstruct == null )
				{	
					// Set up default points for Generate object if they
					// are not specified
					double circumference = 0.3;
					double[] startPos = {-1.75,-9.0, -3.75};
					
					double[][] neckThyroidPoints = BioGraphics.octogonYPlane(startPos, circumference);
					//bioMightGenerateIn = new BioMightGenerate(neckThyroidPoints, 0, "");	
				}	
	
			
				System.out.println("Calling Generate MiddleThyroidVeinEndothelium: " + componentID + "    " + parentID);

			 	// Load up the contruction information to pass to the EJB
		    	//bioMightConstruct.setStartID("MiddleThyroidVeinEndothelium:00160");
		    	//bioMightConstruct.setComponentType("MiddleThyroidVeinEndothelium");
		    	//bioMightConstruct.setComponentName("MiddleThyroidVeinEndothelium");
		    	//bioMightConstruct.setComponentID(componentID);
		    	//bioMightConstruct.setParentID(parentID);
		    	//bioMightGenerate = bioMightBean.generateMiddleThyroidVein(bioMightConstruct);			

				middleThyroidVeinBioGen = bioMightBean.generateMiddleThyroidVein("MiddleThyroidVeinEndothelium:00160", "MiddleThyroidVeinEndothelium", 
					"MiddleThyroidVeinEndothelium", componentID, parentID,  bioMightConstruct);			
					
			}
			// MiddleThyroidVein
			else if (parentID.equals("")) 
			{	
				System.out.println("Calling Generate MiddleThyroidVeinEndothelium NoParent");
							
			}
			
			System.out.println("Created MiddleThyroidVeinEndothelium Info using EJB");   	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - MiddleThyroidVeinEndothelium");
			throw new ServerException("Remote Exception getComponents():", e); 	
		}
		
		return (middleThyroidVeinBioGen);
	}
	
	
	
	public void initProperties() {
	
		BioMightPropertyView property = new BioMightPropertyView();
		property.setPropertyName("Stapes ---");
		property.setCanonicalName(Constants.LeftEar);
		properties.add(property);
				
	}
	
	
	public void initMethods() {	
		BioMightMethodView method;

		method = new BioMightMethodView();
		method.setMethodName("Embolize");
		method.setHtmlType("checkbox");
		methods.add(method);	
		
		method = new BioMightMethodView();
		method.setMethodName("Rupture");
		method.setHtmlType("checkbox");
		methods.add(method);
	}
	
	/*********************************************************************************
	 * INIT 3D
	 * 
	 * This method will be executed when we can see cartilage with our regular
	 * perception.  This is not at the cellular level, but as if one were looking
	 * at the ear.
	 *
	 ********************************************************************************/
	public void init3D(BioMightPosition position) {
	
	}
		 						

	
	/********************************************************************************************************************
	 * GET X3D
	 * 
	 * This method will return the X3D for the Stomach Greater Curvature.  It runs through each of its 
	 * components and collects up their representations and then assembles them into one unified X3D model.
	 * 
	 ********************************************************************************************************************/

	public String getX3D(boolean snipet) {
		
		// Assemble the Femoral Vein 
		String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
		"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n " +
		"<X3D profile='Immersive' >\n" +
		"<head>\n" +
		 "<meta name='BioMightImage' content='MiddleThyroidVein .jpg'/>\n" +
		 "<meta name='ExportTime' content='7:45:30'/>\n" +
		 "<meta name='ExportDate' content='08/15/2008'/>\n" +
		 "<meta name='BioMight Version' content='1.0'/>\n" + 
		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='MiddleThyroidVein '\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		


		String body = "";
		
		
		int view = Constants.VIEW_FLOATING;
		if (view == Constants.VIEW_FLOATING)
		{
			 body = endothelium.getX3D(true);  		
		}
		else if (view == Constants.VIEW_DETACHED)
		{
		
			// Run through the collection of MiddleThyroidVein  and build them into the model
			// In the default case, we get one instance of the MiddleThyroidVein  for each Stomach
			ArrayList transforms = bioMightTransforms.getTransforms();
			for (int i=0; i<transforms.size(); i++)
			{
				// Get the information for the MiddleThyroidVein we are creating
				BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
				System.out.println("Getting MiddleThyroidVein X3D: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
		
		
				//System.out.println("Getting X3D for MiddleThyroidVein X: " + bioMightSphere.getTranslation().getXPos());
				//System.out.println("Getting X3D for MiddleThyroidVein Y: " + bioMightSphere.getTranslation().getYPos());
				//System.out.println("Getting X3D for MiddleThyroidVein Z: " + bioMightSphere.getTranslation().getZPos());
				// Change the height and width based on the displacement.
				body += "<Transform DEF='MiddleThyroidVein '\n" +
		 			"translation='" + bioMightTransform.getTranslation().getXPos() + " " 
			 					+ bioMightTransform.getTranslation().getYPos() + " "
			 					+ bioMightTransform.getTranslation().getZPos() + "'\n" +
			 		"scale='" 	+ bioMightTransform.getScale().getXPos() + " "
			 				+ bioMightTransform.getScale().getYPos() + " "
			 				+ bioMightTransform.getScale().getZPos() + "'>\n" +
					"<Shape DEF='MiddleThyroidVein Shape'\n" +
						    " containerField='children'>\n" +
						    " <Appearance\n" +
						    "  containerField='appearance'>\n" +
						    " <Material DEF='Rust'\n" +
						    "containerField='material'\n" +
						    "ambientIntensity='" + bioMightTransform.getMaterial().getAmbientIntensity() + "'\n" +
						    "shininess='" 		 + bioMightTransform.getMaterial().getShininess() + "'\n" +
						    "transparency='" 	 + bioMightTransform.getMaterial().getTransparency() + "'\n" +
						    "diffuseColor='" + 
						    bioMightTransform.getMaterial().getDiffuseColor().getRed() + " " + 
						    bioMightTransform.getMaterial().getDiffuseColor().getGreen() + " " +
						    bioMightTransform.getMaterial().getDiffuseColor().getBlue() + "'/>\n" +
						 	"</Appearance>\n" +			    
						 	"<IndexedFaceSet DEF='MiddleThyroidVein IFS' \n" +
						    	   "containerField='geometry' \n" +
						    	   "creaseAngle='" +  bioMightTransform.getCreaseAngle() + "'\n" +
						    	   "coordIndex='" + bioMightTransform.getCoordindexStr() + "'>" +
						    	   "<Coordinate DEF='MiddleThyroidVein _Coord' \n" +
						    	    "containerField='coord' point='" +  bioMightTransform.getCoordpointStr() + "'/>" +
						    	  "</IndexedFaceSet>\n" +
					"</Shape>\n" +
	
					"<TimeSensor DEF='StomachBeatTimer'\n" +
						  " containerField='children'\n " +
						  " cycleInterval='1.000'\n " + 
						  " loop='true' \n" +
						  " startTime='-1.000'/> \n" +
					"<TouchSensor DEF='StartStomachBeat' \n" +
						  " containerField='children'/> \n" +
			 "</Transform>\n" +
			 "<PositionInterpolator DEF='StomachBeatAnim'\n" + 
			 "key='0 .5 1'\n" +
			 "keyValue='1 1 1 .9 .9 .9 1 1 1'/>\n" + 
			 "<ROUTE fromNode='StartStomachBeat' fromField='touchTime' toNode='StomachBeatTimer' toField='startTime'/>\n" +
			 "<ROUTE fromNode='StomachBeatTimer' fromField='fraction_changed' toNode='StomachBeatAnim' toField='set_fraction'/>\n" +
			 "<ROUTE fromNode='StomachBeatAnim' fromField='value_changed' toNode='MiddleThyroidVein' toField='set_scale'/>\n";
			}
		}
		else
		{
			body = "";//						
		}
		
		
		//System.out.println("RightAtrium X3D: " + body);	
		String footer = "</Scene>" + "</X3D>\n";
		
		if (snipet)
			return body;			
		else	
			return header + body + footer;
	}	
	
	

	/********************************************************************
	 * SETUP BOUND BOXES
	 * 
	 * Setup the Bounding Boxes for the Trachea.   These boxes will define
	 * the shapes in LxWXH (configurations) that each component must fit 
	 * into.   
	 *
	 * @returnse them
	 ********************************************************************/
	private HashMap setupBoundBoxes(BioMightBoundBox bioMightBoundBoxIn) 
	
	{
		// Set up the bounding boxes for the various components
		// The various components locations will be driven by the
		// bounding boxes
		HashMap boundingBoxMap = new HashMap();
		
		// Initialize the position of the bounding box vars
		BigDecimal xPos = new BigDecimal(0.0);
		BigDecimal yPos = new BigDecimal(0.0);
		BigDecimal zPos= new BigDecimal(0.0);
			
		// Set to base 1x1x1 cube
		BigDecimal xVector= new BigDecimal(1.0);
		BigDecimal yVector= new BigDecimal(1.0); 
		BigDecimal zVector= new BigDecimal(1.0);
		
		// Initialize the BoundBox
		BioMightBoundBox bioBoundBox = null;
		
		// Initialize the Connectors  
		BioMightConnectors bioMightConnectors = null; 

		// Initialize the Connector  
		BioMightConnector bioMightConnector= null;
		
		double circumference = 0.0;
		double[] startPos = {0.0, 0.0, 0.0};
		double[][] startPoints = BioGraphics.octogonYPlane(startPos, circumference);
			
		
			
		//********************************************************************* 
		//	TRACHEA EPITHELIUM BOUNDBOX
		// Set up the Bounding Box for the Trachea
		// On a porportioned human, the pupils lie in the middle of the face
		// For the Default model, the length is 7x9x9 
		// This puts the bounding box at the center of the head
		//**********************************************************************
		xPos = new BigDecimal(0.0);
		yPos = new BigDecimal(0.0);
		zPos= new BigDecimal(-4.5);
		
		xVector= new BigDecimal(3.5);
		yVector= new BigDecimal(4.5); 
		zVector= new BigDecimal(4.5);

		bioBoundBox = new BioMightBoundBox(xPos, yPos, zPos, xVector, yVector, zVector);
		bioMightConnectors = new BioMightConnectors();
			
		// Vascular Connector
		circumference = 0.3;
		startPos = getStartPoints(0.0, -5.0, -1.0);
		startPoints = BioGraphics.octogonYPlane(startPos, circumference);
		bioMightConnector  = new BioMightConnector(startPoints, "SeptimEpithelium","connType");
		bioMightConnectors.setBioMightConnector("SeptimEpithelium", bioMightConnector);
		
		
		// Muscle Connector 
		circumference = 0.3;
		startPos = getStartPoints(0.0, -5.0, -1.0);
		startPoints = BioGraphics.octogonYPlane(startPos, circumference);
		bioMightConnector  = new BioMightConnector(startPoints, "PharnyxEpithelium","connType");
		bioMightConnectors.setBioMightConnector("PharnyxEpithelium", bioMightConnector);
		
		// Stuff in the Bounding Box Map
		bioBoundBox.setBioMightConnectors(bioMightConnectors);
		boundingBoxMap.put("TracheaEpithelium", bioBoundBox);
	
		
	return (boundingBoxMap);
	}
	
	
}
