/*
 * Created on Jul 8, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.system;
import java.math.BigDecimal;
import java.util.ArrayList;

import javax.naming.InitialContext;

import biomight.BioMightBase;
import biomight.Constants;
import biomight.body.organ.heart.Heart;
import biomight.ejb.BioMightBeanLocal;
import biomight.ejb.BioMightVascularBeanLocal;
import biomight.exceptions.ServerException;
import biomight.system.tissue.connective.blood.Blood;
import biomight.system.vascular.arteries.Arteries;
import biomight.system.vascular.veins.Veins;
import biomight.view.BioMightMethodView;
import biomight.view.BioMightOrientation;
import biomight.view.BioMightPosition;
import biomight.view.BioMightPropertyView;
import biomight.view.BioMightScale;
import biomight.view.BioMightTransform;
import biomightweb.util.BioWebUtils;
import biomightweb.util.BioWebX3DUtils;


/******************************************************************************
 * @author SurferJim
 *
 * Representation of the Circulatory System
 * 
 * 
 *****************************************************************************/

public class CirculatorySystem extends BioMightBase  {
	
	// The muscle of all muscles
	private Heart heart;
	private Arteries arteries;
	private Veins veins;
	private Blood blood;
	
	private BigDecimal bloodVolume;
	private BigDecimal diffusionRate;
	private int systolicRate;
	private int daistolicRate;
	
	
	/************************************************************************
	 * SKELETAL SYSTEM Constructor 
	 *
	 ***********************************************************************/

	public CirculatorySystem()
	{
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, Constants.CirculatorySystem, null, null);
	}

	public CirculatorySystem(String parentID)
	{
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, parentID, null, null);
	}

	
	public CirculatorySystem(int localVP, int localLOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods) {
		
		localVP = Constants.VIEW_INTERNAL;
		localLOD = Constants.MAG2X;
		create(localVP, localLOD, parentID, bioMightProperties,  bioMightMethods);
	}
	
	
	/**********************************************************************************
	 * CREATE SKELETAL SYSTEM
	 * 
	 * @param parentID
	 * @param bioMightMethods
	 *********************************************************************************/
	
	public void create(int localVP, int localLOD,  String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
	{
		this.setImage("images/CirculatorySystem.jpg");
		this.setImageHeight(300);
		this.setImageWidth(300);
		
		
		// Get the information from the database via the Enterprise Bean		
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Getting CirculatorySystemInfo for ParentID: " + parentID);
			InitialContext ctx = new InitialContext();
			BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
			bioMightTransforms = bioMightBean.getComponents(Constants.CirculatorySystemRef, parentID);
			System.out.println("Have CirculatorySystem Info from EJB");   	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - CirculatorySystem");
			throw new ServerException("Remote Exception getComponents():", e); 	
		}
		
		// We are not drilling into the components, so we do not use HawkEye,
		// We use the Internal as that will use Circulatory as the parent
		localVP = Constants.VIEW_INTERNAL;
		localLOD = Constants.MAG1X;
		boolean bStored = false;
		
		BioMightScale bioScale = new BioMightScale("0.00, 0.00, 0.00");
		BioMightPosition  bioPos = new BioMightPosition("0.00, 0.00, 0.00");
		String bioTemplate="CirculatorySystem.x3d";

		// Run through the collection of CirculatorySystems and build them into the model
		// In the default case, we get one instance of the CirculatorySystem for each eye
		ArrayList transforms = bioMightTransforms.getTransforms();
		System.out.println("CirculatorySystem NumTransforms: " + transforms.size());
		for (int i=0; i<transforms.size(); i++)
		{
			// Get the information for the CirculatorySystem we are creating
			BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
			System.out.println("Retrieve CirculatorySystem: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
			componentID = bioMightTransform.getId();
			//System.out.println("Creating CirculatorySystem: " + bioMightTransform.getName() + "  " + bioMightTransform.getId() + "  " + componentID);
			

			// Get the Properties that the user set in the page last time we were in	
			// We will use the enable flag to see what should be turned on/off
			if (bioMightProperties == null ||bioMightProperties.size() == 0)
			{
				try {
					// Get the information from the database via the Enterprise Bean		
					//System.out.println("Getting Property info for CirculatorySystem: " + bioMightTransform.getId());
					InitialContext ctx = new InitialContext();
					BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
					// overwrite the structure that was passed in, as they are empty
					bioMightProperties = bioMightBean.getComponentProps(bioMightTransform.getId());
					//System.out.println("Have CirculatorySystem Property Info from EJB - NumProps: " + bioMightProperties.size());   	
				}catch (Exception e) { 
					System.out.println("Exception Getting Components Properties - CirculatorySystem");
					throw new ServerException("Remote Exception getComponents():", e); 	
				} 

				//System.out.println("CirculatorySystem: Using Properties from Datastore");
				bStored = true;
			}
			else
			{
				//System.out.println("CirculatorySystem - Using LocalProperties...");
			}
			//System.out.println("CirculatorySystem - PropertiesSize: " + bioMightProperties.size());
	
	
			if (BioWebUtils.isViewEnabled(Constants.HeartRef, bioMightProperties)) {	
				System.out.println("Creating the Heart for parent: " + bioMightTransform.getId());
				heart = new Heart(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
				initProperty(Constants.HeartRef, Constants.Heart, Constants.HeartRef, heart.getComponentID());
				System.out.println("Created the Heart");
			}
			else
				initProperty(Constants.HeartRef, Constants.Heart, Constants.HeartRef, BioWebUtils.getPropertyID(Constants.HeartRef, bioMightProperties), bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);					
	
			if (BioWebUtils.isViewEnabled(Constants.ArteriesRef, bioMightProperties)) {	
				System.out.println("Creating the Arteries for parent: " + bioMightTransform.getId());
				arteries = new Arteries(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
				initProperty(Constants.ArteriesRef, Constants.Arteries, Constants.ArteriesRef, arteries.getComponentID());
				System.out.println("Created the Arteries");
				}
			else
				initProperty(Constants.ArteriesRef, Constants.Arteries, Constants.ArteriesRef, BioWebUtils.getPropertyID(Constants.ArteriesRef, bioMightProperties), bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);					
	
			if (BioWebUtils.isViewEnabled(Constants.VeinsRef, bioMightProperties)) {	
				System.out.println("Creating the Veins for parent: " + bioMightTransform.getId());
				veins = new Veins(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
				initProperty(Constants.VeinsRef, Constants.Veins, Constants.VeinsRef, veins.getComponentID());
				System.out.println("Created the Veins");
			}
			else
				initProperty(Constants.VeinsRef, Constants.Veins, Constants.VeinsRef, BioWebUtils.getPropertyID(Constants.VeinsRef, bioMightProperties), bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);					
	
			
			// Store the new set of properties based on the init Property methods called above	
			// This means the user set properties
			if (properties != null && !bStored) {
				if (properties.size()>0) {
				// Store the Properties that the user set in the page	
				// We will use the enable flag to see what should be turned on/off
					try {
						// Get the information from the database via the Enterprise Bean		
						//System.out.println("Setting Property info for CirculatorySystem: " + bioMightTransform.getId());
						InitialContext ctx = new InitialContext();
						BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
						int propSave = bioMightBean.insertComponentProps(bioMightTransform.getId(),
								Constants.CirculatorySystemRef, bioMightTransform.getComponentName(), properties);      
						//System.out.println("Stored CirculatorySystem Property Info into EJB: " + propSave);   	
					}catch (Exception e) { 
						System.out.println("Exception Storing Components Properties - CirculatorySystem");
						throw new ServerException("Remote Exception insertComponentProps():", e); 	
					} 
				}
			}			
		}
		//initProperties();
		initMethods();
		
		System.out.println("Create CirculatorySystem Completed");
		
		// First, get all the data from the database
		// Apply the methods to it
		// Save its state
		this.parentID = parentID;
		if (bioMightMethods != null){
			//System.out.println("EXECUTING CirculatorySystem METHODS: " + bioMightMethods.size());
			//executeMethods(bioMightMethods);
		}
	}

	
		
	public void initProperties() {
		
		BioMightPropertyView property = new BioMightPropertyView();		
		BioMightScale bioScale = new BioMightScale("0.00, 0.00, 0.00");
		BioMightPosition bioPos = new BioMightPosition("0.00, 0.00, 0.00");	
		String bioTemplate =""; 

		initProperty("---Not Activated---", Constants.Title, Constants.Title, "SmallIntestine:01", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		initProperty(Constants.HeartRef, Constants.Heart, Constants.HeartRef, "CiculartorySystem:0", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
	
	}
	
	
	public void initMethods() {

		ArrayList<BioMightMethodView> methods = new ArrayList<BioMightMethodView>();
		BioMightMethodView method;
		
		method = new BioMightMethodView();
		method.setMethodName("Constrict");
		method.setHtmlType("checkbox");
		methods.add(method);

		method = new BioMightMethodView();
		method.setMethodName("Relax");
		method.setHtmlType("checkbox");
		methods.add(method);

		method = new BioMightMethodView();
		method.setMethodName("Muscle Density");
		method.setHtmlType("text");
		methods.add(method);
	}

	
	

	/*******************************************************************
	 * GENERATE the CirculatorySystem
	 * 
	 * @param parentID
	 * @param componentID
	 ****************************************************************/
	
	public void generate(String parentID, String componentID)
	{
		// Generate the CirculatorySystem		
		BioMightVascularBeanLocal bioMightBean;
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Generating the CirculatorySystem: " + componentID + "    " + parentID);
			InitialContext ctx = new InitialContext();
			bioMightBean = (BioMightVascularBeanLocal) ctx.lookup("java:global/BioMightWeb/BioMightVacularBean!biomight.ejb.BioMightVascularBeanLocal");
	
			double circumference = 0.25;
		
			if (parentID.equals("Chest:01")) 
			{	
				// Generate the DescendingCirculatorySystemEndothelium of the stomach
				// Create 5 sections
				double[] startPos = {-0.3,-8.0, -6.0};
				
				// Create a equilateral octogon
				double x =  startPos[0];
				double y =  startPos[1];
				double z =  startPos[2];

				double[][] currentPoints = { 
	    			{x, y, z},
	    	 		{x-circumference,     y, z-circumference},
	    	   		{x-circumference,     y, z-circumference*2},
	    	   		{x,                   y, z-circumference*3},
	    	   		{x+circumference,     y, z-circumference*3},
	    	   		{x+(circumference*2), y, z-circumference*2},
	    	   		{x+(circumference*2),     y, z-circumference},
	    	  		{x+circumference, y, z}
	    	   		};
	
				System.out.println("Calling Generate CirculatorySystem: " + componentID + "    " + parentID);
				
				//int success = bioMightBean.generateCirculatorySystem("CirculatorySystemEndothelium:00001", "CirculatorySystemEndothelium", 
				//	"CirculatorySystemEndothelium", componentID, parentID, currentPoints);			
	
				//success = bioMightBean.generateBlood("CirculatorySystemEndothelium:00001", "CirculatorySystemEndothelium", 
				//		"CirculatorySystemEndothelium", componentID, parentID, currentPoints);			
				
			}			
			else if (parentID.equals("Abdomen:01")) 
			{	
					}
			else if (parentID.equals("")) 
			{	
				System.out.println("Calling Generate CirculatorySystemEndothelium NoParent");
							
			}
			
			System.out.println("Created CirculatorySystemEndothelium Info using EJB");   	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - CirculatorySystemEndothelium");
			throw new ServerException("Remote Exception getComponents():", e); 	
		}
	}
	
	
	
	/********************************************************************************************************************
	 * GET X3D
	 * 
	 * This method will return the X3D for the BioMightSystems.  It runs through each of its components and collects up their
	 * representations and then assembles them into one unified X3D model.
	 * 
	 ********************************************************************************************************************/
	public String getX3D(boolean snipet) {
		
		// Assemble the Abdomen
		String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
		"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n " +
		"<X3D profile='Immersive' >\n" +
		"<head>\n" +
		 "<meta name='BioMightImage' content='Abdomen.jpg'/>\n" +
		 "<meta name='ExportTime' content='7:45:30'/>\n" +
		 "<meta name='ExportDate' content='08/15/2008'/>\n" +
		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='CirculatorySystem'\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		

		System.out.println("Getting CirculatorySystem X3D!");	
		String body =  "";
				
		
		if (BioWebUtils.isViewEnabled(Constants.HeartRef, properties)) {
			body +=heart.getX3D(true);
		}
		if (BioWebUtils.isViewEnabled(Constants.ArteriesRef, properties)) {
			body +=arteries.getX3D(true);
		}
		if (BioWebUtils.isViewEnabled(Constants.VeinsRef, properties)) {
			body +=veins.getX3D(true);
		}
		
		//BioMightPosition bioMightPositionCore = new BioMightPosition(0.0, 0.0, 0.0);
		//BioMightOrientation bioMightOrientation = new BioMightOrientation(0, 0, 1, 90);
		//body +=BioWebX3DUtils.generateArtery(bioMightTransform,  bioMightPositionCore, bioMightOrientation);
	
		/*body+= "<Viewpoint DEF='Viewpoint_Artery'\n" +
				 "description='Viewpoint1'\n" +
				 "jump='true'\n" +
				 "fieldOfView='0.785'\n" +
				 "position='0.0 0.0 1.0'\n" +
				 "orientation='0 0 1 0'/>\n";	body+= "<Viewpoint DEF='Viewpoint_Artery'\n" +
						 "description='Viewpoint1'\n" +
						 "jump='true'\n" +
						 "fieldOfView='0.785'\n" +
						 "position='0.0 0.0 5.0'\n" +
						 "orientation='0 0 1 0'/>\n";
			*/
		
		
		//System.out.println("CirculatorySystem X3D: " + body);		
		String footer = "</Scene>" + "</X3D>\n";
		
		if (snipet)
			return body;			
		else	
			return header + body + footer;
	}
		
	
	/**
	 * @return
	 */
	public int getDaistolicRate() {
		return daistolicRate;
	}

	/**
	 * @return
	 */
	public BigDecimal getDiffusionRate() {
		return diffusionRate;
	}

	/**
	 * @return
	 */
	public int getSystolicRate() {
		return systolicRate;
	}

	/**
	 * @param i
	 */
	public void setDaistolicRate(int i) {
		daistolicRate = i;
	}

	/**
	 * @param decimal
	 */
	public void setDiffusionRate(BigDecimal decimal) {
		diffusionRate = decimal;
	}

	/**
	 * @param i
	 */
	public void setSystolicRate(int i) {
		systolicRate = i;
	}

	/**
	 * @return
	 */
	public BigDecimal getBloodVolume() {
		return bloodVolume;
	}

	/**
	 * @param decimal
	 */
	public void setBloodVolume(BigDecimal decimal) {
		bloodVolume = decimal;
	}


	public Arteries getArteries() {
		return arteries;
	}


	public void setArteries(Arteries arteries) {
		this.arteries = arteries;
	}


	public Blood getBlood() {
		return blood;
	}


	public void setBlood(Blood blood) {
		this.blood = blood;
	}


	public Heart getHeart() {
		return heart;
	}


	public void setHeart(Heart heart) {
		this.heart = heart;
	}


	public Veins getVeins() {
		return veins;
	}


	public void setVeins(Veins veins) {
		this.veins = veins;
	}

}
