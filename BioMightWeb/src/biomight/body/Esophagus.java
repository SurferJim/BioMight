/*
 * Created on Apr 24, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.body;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;

import javax.naming.InitialContext;







import biomight.Constants;
import biomight.body.organ.Organ;
import biomight.ejb.BioMightBeanLocal;
import biomight.exceptions.ServerException;
import biomight.system.tissue.epithelial.EpitheliumTissue;
import biomight.system.tissue.membranes.MucousMembrane;
import biomight.util.BioGraphics;
import biomight.view.BioMightBoundBox;
import biomight.view.BioMightConnector;
import biomight.view.BioMightConnectors;
import biomight.view.BioMightConstruct;
import biomight.view.BioMightGenerate;
import biomight.view.BioMightMethodView;
import biomight.view.BioMightPosition;
import biomight.view.BioMightPropertyView;
import biomight.view.BioMightScale;
import biomight.view.BioMightTransform;


/************************************************************************************
 * @author SurferJim
 *
 * Representation of the Esophagus
 * 
 ************************************************************************************/

public class Esophagus extends Organ {

	private MucousMembrane mucousMembrane;
	//private EsophagusLongitudinalMuscularCoat esophagusLongitudinalMuscularCoat;
	private EpitheliumTissue epithelium;
	
		
	/********************************************************
	 * CONSTRUCTORS
	 * 
	 ********************************************************/
	public Esophagus()
	{
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, Constants.EsophagusRef, null, null);
	}

	public Esophagus(String parentID)
	{
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, parentID, null, null);
	}

	public Esophagus(int vp, int LOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
	{
		create(vp, LOD, parentID, bioMightProperties, bioMightMethods);
	}
	
	/*****************************************************************************
	 * CREATE ESOPHAGUS
	 * 
	 * The Esophagus can generate in the context of the whole body, Neck, Chest, 
	 * or Abdomen.  Each part starts and ends at a specifc place in the database
	 * so we use the startID to provide that 
	 * 
	 * @param parentID
	 * @paramBioMightConstruct
	 * @param bioMightMethods
	 *****************************************************************************/
	public void create(int viewPerspective, int LOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
	{
			this.setImage("images/Esophagus.jpg");
			this.setImageHeight(300);
			this.setImageWidth(300);

			this.parentID = parentID;
	
			/*
			// If the constructor is empty,then we just get the information from the database
			// and assemble the model.  If the Constructor has information, then this
			// component is receiving direct change,or getting instructions from its parent
			// to update.
			HashMap boundingBoxes = null;
			// Get the Bounding Box from the Constructor that defines 
			// the perimeter of Esophagus  Pass that into the BoundingBoxes 
			// method so it can be divied up.
			
			System.out.println("ESOPHAGUS - Getting BoundBox & Connectors!");
			BioMightBoundBox componentBoundBox = null;			
			if (bioMightConstruct == null)
			{
				// Its null, so set up default boundbox with connectors 
				componentBoundBox = setupDefaultBoundBox(parentID);
				System.out.println("ESOPHAGUS - Creating Default BoundBox & Connectors!");
				}
			else
			{
				// Use the incoming
				componentBoundBox = bioMightConstruct.getBoundingBox(Constants.EsophagusRef);	
				System.out.println("ESOPHAGUS - Using Incoming BoundBox & Connectors!");
				
			}
			BioMightConnectors componentConnectors = componentBoundBox.getBioMightConnectors();
			if (componentConnectors == null)
				System.out.println("ESOPHAGUS - ComponentConnectors are NULL!!");
			
			System.out.println("ESOPHAGUS - Setting up internal Bounding Boxes!");
			boundingBoxes = setupBoundBoxes(parentID, componentBoundBox);

			// Set up a Constructor that will be used to pass information into the components
			BioMightConstruct bioConstruct = null; 
			*/
			
	
			// Get the information from the database via the Enterprise Bean		
			try {
				// Get the information from the database via the Enterprise Bean		
				System.out.println("Getting EsophagusInfo for ParentID: " + parentID);
				InitialContext ctx = new InitialContext();
				BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
				bioMightTransforms = bioMightBean.getComponents(Constants.EsophagusRef, parentID);   	
			}catch (Exception e) { 
				System.out.println("Exception Getting Components - Esophagus");
				throw new ServerException("Remote Exception getComponents():", e); 	
			}
			
			int localVP = Constants.VIEW_HAWKEYE;
			int localLOD = Constants.MAG1X;

			BioMightScale bioScale = new BioMightScale("0.00, 0.00, 0.00");
			BioMightPosition  bioPos = new BioMightPosition("0.00, 0.00, 0.00");
			String bioTemplate="Esophagus.x3d";

			
			// Run through Esophagus and build them into the model
			ArrayList transforms = bioMightTransforms.getTransforms();
			System.out.println("Esophagus NumTransforms: " + transforms.size());
			for (int i=0; i<transforms.size(); i++)
			{
				// Get the information for the Esophagus we are creating
				BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
				System.out.println("Creating Esophagus (name,id): " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
				componentID = bioMightTransform.getId();

				/*
				// EPITHELIUM 
				// Create and Load Constructor object
				System.out.println("In Esophagus - Setting up Epithelium Constructor");
				bioConstruct = new BioMightConstruct(); 	
				bioConstruct.setBoundingBox(Constants.EsophagusEpitheliumRef, (BioMightBoundBox)boundingBoxes.get(Constants.EsophagusEpitheliumRef));		
				//Set the connector from the parent if defined that defines the starting point  
				System.out.println("In Esophagus - Epithelium Constructor - Set Connector");
											
				//
				BioMightBoundBox tempBox = (BioMightBoundBox) boundingBoxes.get("EsophagusEpithelium");
				if (tempBox == null)
					System.out.println("In Esophagus - Esophagus BoundBox is NULL");	
				
				BioMightConnector tempConn = componentConnectors.getBioMightConnector("EsophagusEpithelium");
				if (tempConn == null)
					System.out.println("In Esophagus - Esophagus Connector is NULL");	
				*/
				
				// Get the whole model of the Esophagus, or the partial section when drilling down
				// into a body part and only that portion within the part is visible
				
				// Create the 'skin' for the portion of the Esophagus we are looking at
				
	
				
				String startID = "";
				if (parentID.equals("Organs:0") || parentID.equals("DigestiveSystem:0"))
				{
					startID="EsophagusEpithelium:00001";
				}	
				else if (componentID.equals("Esophagus:01")) 
				{
					startID="EsophagusEpithelium:00001";
				}			
				// We are creating the Esophagus for the Chest
				else if (parentID.equals("Chest:01")) 
				{	
					startID="EsophagusEpithelium:00160";
				}
				// We are creating the Esophagus for the Chest
				else if (parentID.equals("Abdomen:01")) 
				{	
					// Store information about the generation into a BioMightGenerate object
					startID = "EsophagusEpithelium:00320";
				}
				

				// Generate the GreaterCurvature Endothelium if needed 
				boolean bGenerate = false;
				if (bGenerate) {
					generate(parentID, componentID, null);
				}
			
					
				epithelium = new EpitheliumTissue(localVP, localLOD, startID, Constants.EsophagusEpitheliumRef, "EsophagusEpithelium", bioMightTransform.getId(), bioMightProperties, bioMightMethods);
				BioMightGenerate generatedEpithelium = epithelium.getBioMightGenerate(); 		
				initProperty("EsophagusEpithelium", Constants.EpitheliumTissue, Constants.EpitheliumTissueRef, epithelium.getComponentID(), bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);					
			
				System.out.println("EsophagusEpithelium completed");			
			}		


			//initProperties();
			initMethods();
		}
		
		
	/****************************************************************
	 * GENERATE ESOPHAGUS
	 * 
	 * The esophagus passes through the neck, the chest and into the
	 * abdominal cavity.  The Construct object that is passed into this
	 * method gives us contet for building it.  
	 *  
	 * @param parentID
	 * @param componentID
	 ***************************************************************/
				
	public BioMightGenerate generate(String parentID, String componentID, BioMightConstruct bioMightConstruct)
	{
			// Generate the Esophagus Epithelium		
			BioMightBeanLocal bioMightBean;
			BioMightGenerate generatedEsophagus = null;
			double radius = 0.5;
					
			try {
				// Get the information from the database via the Enterprise Bean		
				System.out.println("Generating the Esophagus ParentID: " + parentID);
				InitialContext ctx = new InitialContext();
				bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
		
				
				// We are creating the Esophagus for the neck
				if (parentID.equals("Organs:0") || parentID.equals("DigestiveSystem:0") || parentID.equals("Neck:01")) 
				{
					// Store information about the generation into a BioMightGenerate object
					//generatedEsophagus = bioMightBean.generateEsophagus("EsophagusEpithelium:00001", "EsophagusEpithelium", 
					//"EsophagusEpithelium", componentID, parentID, bioMightConstruct);	
					
					// Create 5 sections
					double[] startPos = {0.0, -4.75, -3.25};
					double[][] currentPoints = BioGraphics.createCylinderInPlane(Constants.YPLANE, startPos, radius, 8);
		
		
					System.out.println("Calling generateEsophagus: " + componentID + "    " + parentID);
					
					int success = bioMightBean.generateEsophagus("EsophagusEpithelium:00001", "EsophagusEpithelium", 
						"EsophagusEpithelium", componentID, parentID, currentPoints);			
		
					
					System.out.println("Generated Esophagus for ParentID: " + parentID);

				}
						// We are creating the Esophagus for the Chest
				else if (parentID.equals("Chest:01")) 
				{	
					// Store information about the generation into a BioMightGenerate object
					//generatedEsophagus = bioMightBean.generateEsophagus("EsophagusEpithelium:00160", "EsophagusEpithelium", 
					//"EsophagusEpithelium", componentID, parentID, bioMightConstruct);			
					//System.out.println("Generated Esophagus for ParentID: " + parentID);
		
				
					double[] startPos = {0.0, -8.5, -3.0};
					double[][] currentPoints = BioGraphics.octogonYPlane(startPos, radius);
		
					System.out.println("Calling generateEsophagus: " + componentID + "    " + parentID);
					
					int success = bioMightBean.generateEsophagus("EsophagusEpithelium:00160", "EsophagusEpithelium", 
						"EsophagusEpithelium", componentID, parentID, currentPoints);			
		
				
				}
				
				// We are creating the Esophagus for the Abdomen;
				else if (parentID.equals("Abdomen:01")) 
				{	
					// Store information about the generation into a BioMightGenerate object
					//generatedEsophagus = bioMightBean.generateEsophagus("EsophagusEpithelium:00320", "EsophagusEpithelium", 
					//"EsophagusEpithelium", componentID, parentID, bioMightConstruct);			
					//System.out.println("Generated Esophagus for ParentID: " + parentID);
					
					
					
					double[] startPos = {0.0, -15.5, -3.0};
					double[][] currentPoints = BioGraphics.octogonYPlane(startPos, radius);
		
					System.out.println("Calling generateEsophagus: " + componentID + "    " + parentID);
					
					int success = bioMightBean.generateEsophagus("EsophagusEpithelium:00320", "EsophagusEpithelium", 
						"EsophagusEpithelium", componentID, parentID, currentPoints);			

				}
				
				
				System.out.println("Created EsophagusEpithelium Info using EJB");   	
			}catch (Exception e) { 
				System.out.println("Exception Getting Components - EsophagusEpithelium");
				throw new ServerException("Remote Exception getComponents():", e); 	
			}
			
		return (generatedEsophagus);	
	}
	
		
		
		public void initProperties() {

			properties = new ArrayList<BioMightPropertyView>();
			
			BioMightPropertyView property = new BioMightPropertyView();
			property.setPropertyName("Common");
			property.setCanonicalName(Constants.Title);
			properties.add(property);
			
			property = new BioMightPropertyView();
			property.setPropertyName("SuperiorThyroidAtery");
			property.setCanonicalName(Constants.SuperiorThyroidAtery);
			properties.add(property);
		}
		
		
		public void initMethods() {
			methods = new ArrayList<BioMightMethodView>();

			BioMightMethodView method = new BioMightMethodView();

			method = new BioMightMethodView();
			method.setMethodName("Turn");
			method.setHtmlType("text");
			methods.add(method);	
		}

		
		
		
		/********************************************************************************************************************
		 * GET X3D
		 * 
		 * This method will return the X3D for the Cell.  It runs through each of its components and collects up their
		 * representations and then assembles them into one unified X3D model.
		 * 
		 ********************************************************************************************************************/
		public String getX3D(boolean snipet) {
			
			// Assemble the Esophagus
			String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
			"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n " +
			"<X3D profile='Immersive' >\n" +
			"<head>\n" +
			 "<meta name='BioMightImage' content='Esophagus.jpg'/>\n" +
			 "<meta name='ExportTime' content='7:45:30'/>\n" +
			 "<meta name='ExportDate' content='08/15/2008'/>\n" +
			 "<meta name='BioMight Version' content='1.0'/>\n" + 
			"</head>\n" +
			"<Scene>\n" +
			"<WorldInfo\n" +
			"title='Esophagus'\n" +
			"info='\"BioMight Generated X3D\"'/>\n";		

			String body = epithelium.getX3D(true);
			//System.out.println("Esophagus X3D: " + body);		
			String footer = "</Scene>" + "</X3D>\n";
			
			// We should do this on detached view only
			body+= "<Viewpoint DEF='Viewpoint_Esophagus'\n" +
					 "description='Viewpoint1'\n" +
					 "jump='true'\n" +
					 "fieldOfView='0.785'\n" +
					 "position='0.0 -10.0 20.0'\n" +
					 "orientation='0 0 1 0'/>\n";
			
			if (snipet)
				return body;			
			else	
				return header + body + footer;
		}
		
		
		/********************************************************************
		 * SETUP DEFAULT BOUNDBOX
		 * 
		 * Setup the Default Bounding Box and External Connectors for the 
		 * Esophagus.  
		 *
		 * @return
		 ********************************************************************/
		private BioMightBoundBox setupDefaultBoundBox(String parentID) 
		{
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
			

			if (parentID.equals("Organs:0") || parentID.equals("DigestiveSystem:0"))
			{
				//**********************************************************************
				// ESOPHAGUS BOUND BOX		
				//
				// Set up the Bounding Box for the Neck
				// For default model, length of neck is 4.5
				//**********************************************************************
				xPos = new BigDecimal(0.0);
				yPos = new BigDecimal(-5.0);
				zPos= new BigDecimal(-3.0); 
		
				xVector= new BigDecimal(2.5);
				yVector= new BigDecimal(10.0); 
				zVector= new BigDecimal(2.5);
				bioBoundBox = new BioMightBoundBox(xPos, yPos, zPos, xVector, yVector, zVector);
				bioMightConnectors = new BioMightConnectors();
			
				//********************************************
				// ESOPHAGUS - ORGAN CONNECTORS
				//********************************************
		
				// EpitheliumTissue Connector
				circumference = 0.3;
				startPos = getStartPoints(0.0, -5.0, -1.0);
				startPoints = BioGraphics.octogonYPlane(startPos, circumference);
				bioMightConnector = new BioMightConnector(startPoints, "EsophagusEpithelium","connType");
				bioMightConnectors.setBioMightConnector("EsophagusEpithelium", bioMightConnector);
			}
			else if (parentID.equals("Neck:01"))
			{
				//**********************************************************************
				// ESOPHAGUS BOUND BOX		
				//
				// Set up the Bounding Box for the Neck
				// For default model, length of neck is 4.5
				//**********************************************************************
				xPos = new BigDecimal(0.0);
				yPos = new BigDecimal(-5.0);
				zPos= new BigDecimal(-3.0); 
		
				xVector= new BigDecimal(2.5);
				yVector= new BigDecimal(2.0); 
				zVector= new BigDecimal(2.5);
				bioBoundBox = new BioMightBoundBox(xPos, yPos, zPos, xVector, yVector, zVector);
				bioMightConnectors = new BioMightConnectors();
			
				//********************************************
				// ESOPHAGUS - ORGAN CONNECTORS
				//********************************************
		
				// EpitheliumTissue Connector
				circumference = 0.3;
				startPos = getStartPoints(0.0, -5.0, -1.0);
				startPoints = BioGraphics.octogonYPlane(startPos, circumference);
				bioMightConnector = new BioMightConnector(startPoints, "EsophagusEpithelium","connType");
				bioMightConnectors.setBioMightConnector("EsophagusEpithelium", bioMightConnector);
			}
			else if (parentID.equals("Chest:01"))
			{
				//**********************************************************************
				// ESOPHAGUS BOUND BOX		
				//
				// Set up the Bounding Box for the Chest portion
				// For default model, length of Chest portion is 4.5
				//**********************************************************************
				xPos = new BigDecimal(0.0);
				yPos = new BigDecimal(-8.0);
				zPos= new BigDecimal(-3.0); 
		
				xVector= new BigDecimal(2.5);
				yVector= new BigDecimal(2.0); 
				zVector= new BigDecimal(2.5);
				bioBoundBox = new BioMightBoundBox(xPos, yPos, zPos, xVector, yVector, zVector);
				bioMightConnectors = new BioMightConnectors();
			
				//********************************************
				// ESOPHAGUS - ORGAN CONNECTORS
				//********************************************
		
				// EpitheliumTissue Connector
				circumference = 0.3;
				startPos = getStartPoints(0.0, -8.0, -1.0);
				startPoints = BioGraphics.octogonYPlane(startPos, circumference);
				bioMightConnector = new BioMightConnector(startPoints, "EsophagusEpithelium","connType");
				bioMightConnectors.setBioMightConnector("EsophagusEpithelium", bioMightConnector);
				
						
			}
			else if (parentID.equals("Abdomen:01"))
			{
				//**********************************************************************
				// ESOPHAGUS BOUND BOX		
				//
				// Set up the Bounding Box for the Abdomen portion
				// For default model, length of Abdomen portion is 4.5
				//**********************************************************************
				xPos = new BigDecimal(0.0);
				yPos = new BigDecimal(-16.00);
				zPos= new BigDecimal(-3.0); 
		
				xVector= new BigDecimal(2.5);
				yVector= new BigDecimal(2.0); 
				zVector= new BigDecimal(2.5);
				bioBoundBox = new BioMightBoundBox(xPos, yPos, zPos, xVector, yVector, zVector);
				bioMightConnectors = new BioMightConnectors();
			
				//********************************************
				// ESOPHAGUS - ORGAN CONNECTORS
				//********************************************
		
				// EpitheliumTissue Connector
				circumference = 0.3;
				startPos = getStartPoints(0.0, -16.0, -1.0);
				startPoints = BioGraphics.octogonYPlane(startPos, circumference);
				bioMightConnector = new BioMightConnector(startPoints, "EsophagusEpithelium","connType");
				bioMightConnectors.setBioMightConnector("EsophagusEpithelium", bioMightConnector);	
			}
			else
			{}
				
			
				
			// Stuff in the Bounding Box Map
			bioBoundBox.setBioMightConnectors(bioMightConnectors);
			
			
			return (bioBoundBox);	
		}	
			

	/********************************************************************
	 * SETUP BOUND BOXES
	 * 
	 * Setup the Bounding Boxes for the Esophagus.   These boxes will define
	 * the shapes in LxWXH (configurations) that each component must fit 
	 * into.   
	 *
	 * @returnse them
	 ********************************************************************/
	private HashMap setupBoundBoxes(String parentID, BioMightBoundBox bioMightBoundBoxIn) 
	{
		// Set up the bounding boxes for the various components
		// The various components locations will be driven by the
		// bounding boxes

		// Set up the Bounding Boxes for each component of the Esophagus
		// Build everything within in the confines of of the given box
		HashMap boundingBoxMap = new HashMap();

		// Initialize the position of the bounding box vars
		BigDecimal xPos = new BigDecimal(0.0);
		BigDecimal yPos = new BigDecimal(0.0);
		BigDecimal zPos= new BigDecimal(0.0);
		
		// Set to base 1x1x1 cube
		BigDecimal xVector= new BigDecimal(1.0);
		BigDecimal yVector= new BigDecimal(1.0); 
		BigDecimal zVector= new BigDecimal(1.0);
		
		// Create the BoundBox
		BioMightBoundBox bioBoundBox = null;;
		
		// Create the Connectors
		// Initialize the Connectors  
		BioMightConnectors bioMightConnectors = null;
		
		// Define some vars
		double circumference = 0.0;
		double[] startPos = {0.0, -5.0, 0.0};
		double[][] startPoints = null;
		
		// Initialize the Connector  
		BioMightConnector bioMightConnector= null;

		
		// Set up the EsophagusEpithelium bounding boxes based upon whose looking at it
		if (parentID.equals("Organs:0") || parentID.equals("DigestiveSystem:0"))
		{	
			// ESOPHAGUS EPITHELIUM
			// Set up the Bounding Box for the Epithelium
			// Position the box
			xPos = new BigDecimal(0.3);
			yPos = new BigDecimal(-5.00);
			zPos= new BigDecimal(-1.0); 
			
			// Set Dimensions of the box
			xVector= new BigDecimal(1.0);
			yVector= new BigDecimal(5.0); 
			zVector= new BigDecimal(1.0);
			bioBoundBox = new BioMightBoundBox(xPos, yPos, zPos, xVector, yVector, zVector);
			bioMightConnectors = new BioMightConnectors();
						
			
			// Esophagus Connector
			circumference = 0.3;
			startPos = getStartPoints(0.0, -5.0, -1.0);
			startPoints = BioGraphics.octogonYPlane(startPos, circumference);
			bioMightConnector  = new BioMightConnector(startPoints, "EsophagusEpithelialCell","connType");
			bioMightConnectors.setBioMightConnector("EsophagusEpithelialCell", bioMightConnector);
				
			bioBoundBox.setBioMightConnectors(bioMightConnectors);
			boundingBoxMap.put("EsophagusEpithelium", bioBoundBox);	
		}
		else if (parentID.equals("Neck:01")) 
		{	
			// ESOPHAGUS EPITHELIUM
			// Set up the Bounding Box for the Epithelium
			// Position the box
			xPos = new BigDecimal(0.3);
			yPos = new BigDecimal(-5.00);
			zPos= new BigDecimal(-1.0); 
			
			// Set Dimensions of the box
			xVector= new BigDecimal(1.0);
			yVector= new BigDecimal(5.0); 
			zVector= new BigDecimal(1.0);
			bioBoundBox = new BioMightBoundBox(xPos, yPos, zPos, xVector, yVector, zVector);
			bioMightConnectors = new BioMightConnectors();
						
			
			// Esophagus Connector
			circumference = 0.3;
			startPos = getStartPoints(0.0, -5.0, -1.0);
			startPoints = BioGraphics.octogonYPlane(startPos, circumference);
			bioMightConnector  = new BioMightConnector(startPoints, "EsophagusEpithelialCell","connType");
			bioMightConnectors.setBioMightConnector("EsophagusEpithelialCell", bioMightConnector);
				
			bioBoundBox.setBioMightConnectors(bioMightConnectors);
			boundingBoxMap.put("EsophagusEpithelium", bioBoundBox);	
		}
		else if (parentID.equals("Chest:01")) 
		{
			// Set up default points for Generate object if they
			// are not specified
			
			// ESOPHAGUS EPITHELIUM
			// Set up the Bounding Box for the Epithelium
			xPos = new BigDecimal(0.3);
			yPos = new BigDecimal(-8.00);
			zPos= new BigDecimal(-1.0); 
			
			xVector= new BigDecimal(1.0);
			yVector= new BigDecimal(5.0); 
			zVector= new BigDecimal(1.0);
			bioBoundBox = new BioMightBoundBox(xPos, yPos, zPos, xVector, yVector, zVector);
			bioMightConnectors = new BioMightConnectors();
						
			// Esophagus Connector
			circumference = 0.3;
			startPos = getStartPoints(0.0, -9.0, -1.0);
			startPoints = BioGraphics.octogonYPlane(startPos, circumference);
			bioMightConnector  = new BioMightConnector(startPoints, "EsophagusEpithelialCell","connType");
			bioMightConnectors.setBioMightConnector("EsophagusEpithelialCell", bioMightConnector);
				
			bioBoundBox.setBioMightConnectors(bioMightConnectors);
			boundingBoxMap.put("EsophagusEpithelium", bioBoundBox);	

		}			
		else if (parentID.equals("Abdomen:01")) 
		{
			// Set up default points for Generate object if they
			// are not specified
			
			// ESOPHAGUS EPITHELIUM
			// Set up the Bounding Box for the Epithelium
			xPos = new BigDecimal(1.0);
			yPos = new BigDecimal(-17.00);
			zPos= new BigDecimal(-1.0); 
			
			xVector= new BigDecimal(1.0);
			yVector= new BigDecimal(2.0); 
			zVector= new BigDecimal(1.0);
			bioBoundBox = new BioMightBoundBox(xPos, yPos, zPos, xVector, yVector, zVector);
			bioMightConnectors = new BioMightConnectors();
						
			// Esophagus Connector
			circumference = 0.3;
			startPos = getStartPoints(0.0, -17.0, -1.0);
			startPoints = BioGraphics.octogonYPlane(startPos, circumference);
			bioMightConnector  = new BioMightConnector(startPoints, "EsophagusEpithelialCell","connType");
			bioMightConnectors.setBioMightConnector("EsophagusEpithelialCell", bioMightConnector);
				
			bioBoundBox.setBioMightConnectors(bioMightConnectors);
			boundingBoxMap.put("EsophagusEpithelium", bioBoundBox);	
		}
		
		return (boundingBoxMap);
	}
		

		public void setProperties(ArrayList<BioMightPropertyView> properties) {
			this.properties = properties;
		}
	
		public void Peristalisis()
		{
		}
}
