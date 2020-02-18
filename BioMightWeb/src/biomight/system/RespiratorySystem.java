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
import biomight.bacteria.cocci.grampositive.StreptococcusPneumoniae;
import biomight.bacteria.pleomorphic.gramnegative.HaemophilusInfluenzae;
import biomight.bacteria.pleomorphic.grampositive.MycobacteriumTuberculosis;
import biomight.body.organ.Trachea;
import biomight.body.organ.heart.Heart;
import biomight.body.organ.lung.Bronchi;
import biomight.body.organ.lung.LobarBronchi;
import biomight.body.organ.lung.Lungs;
import biomight.body.organ.lung.SegmentalinicBronchi;
import biomight.ejb.BioMightBeanLocal;
import biomight.ejb.BioMightVascularBeanLocal;
import biomight.exceptions.ServerException;
import biomight.view.BioMightConstruct;
import biomight.view.BioMightGenerate;
import biomight.view.BioMightMethodView;
import biomight.view.BioMightPosition;
import biomight.view.BioMightPropertyView;
import biomight.view.BioMightScale;
import biomight.view.BioMightTransform;
import biomight.virus.dna.Adenovirus;
import biomight.virus.rna.HantaVirus;
import biomight.virus.rna.MeaslesVirus;
import biomight.virus.rna.MumpsVirus;
import biomight.virus.rna.RespiratorySyncytialVirus;
import biomight.virus.rna.RubellaVirus;
import biomight.virus.rna.picornaviridae.RhinoVirus;
import biomightweb.util.BioWebUtils;

/************************************************************************************
 * @author SurferJim
 *
 * Representation of the RespitatorySystem
 * 
 ************************************************************************************/

public class RespiratorySystem extends BioMightBase{
	private Heart heart;
	private Lungs lungs;
	private Trachea trachea;	
	private Bronchi bronchi;
	private LobarBronchi lobarBronchi;
	private SegmentalinicBronchi segmentalinicBronchi;
	
	
	/************************************************************************
	 * RESPIRATORY SYSTEM CONTRUCTORS 
	 *
	 ***********************************************************************/
		
	public RespiratorySystem()
	{
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, Constants.RespiratorySystemRef, null, null);
	}

	public RespiratorySystem(String parentID)
	{
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, parentID, null, null);
	}

	public RespiratorySystem(int hierarchy, int LOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
	{
		System.out.print("Calling RespiratorySystem Create");
		create(hierarchy, LOD, parentID, bioMightProperties, bioMightMethods);
	}

	
	/*****************************************************************
	 * CREATE
	 * 
	 * @param parentID
	 * @param bioMightMethods
	 ******************************************************************/
	public void create(int hierarchy, int LOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
	{
		this.setImage("images/RespiratorySystem.jpg");
		this.setImageHeight(300);
		this.setImageWidth(300);
				
		// Get the information from the database via the Enterprise Bean		
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Getting RespiratorySystemInfo for ParentID: " + parentID);
			InitialContext ctx = new InitialContext();
			BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
			bioMightTransforms = bioMightBean.getComponents(Constants.RespiratorySystemRef, parentID);
			//System.out.println("Have RespiratorySystem Info from EJB");   	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - RespiratorySystem");
			throw new ServerException("Remote Exception getComponents():", e); 	
		}
		
		int localVP = Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		boolean bStored = false;
		
		BioMightScale bioScale = new BioMightScale("0.00, 0.00, 0.00");
		BioMightPosition  bioPos = new BioMightPosition("0.00, 0.00, 0.00");
		String bioTemplate="RespiratorySystem.x3d";
			
		// Run through the collection of RespiratorySystems and build them into the model
		// In the default case, we get one instance of the RespiratorySystem for each eye
		ArrayList transforms = bioMightTransforms.getTransforms();
		System.out.println("RespiratorySystem NumTransforms: " + transforms.size());
		for (int i=0; i<transforms.size(); i++)
		{
			// Get the information for the RespiratorySystem we are creating
			BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
			componentID = bioMightTransform.getId();
			System.out.println("Creating RespiratorySystem: " + bioMightTransform.getName() + "  " + bioMightTransform.getId() + "  " + componentID);
					
			// Get the Properties that the user set in the page last time we were in	
			// We will use the enable flag to see what should be turned on/off
			if (bioMightProperties == null ||bioMightProperties.size() == 0)
			{
				try {
					// Get the information from the database via the Enterprise Bean		
					//System.out.println("Getting Property info for DigestiveSystem: " + bioMightTransform.getId());
					InitialContext ctx = new InitialContext();
					BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
					// overwrite the structure that was passed in, as they are empty
					bioMightProperties = bioMightBean.getComponentProps(bioMightTransform.getId());
					System.out.println("Have RespiratorySystem Property Info from EJB - NumProps: " + bioMightProperties.size());   	
				}catch (Exception e) { 
					System.out.println("Exception Getting Components Properties - RespiratorySystem");
					throw new ServerException("Remote Exception getComponents():", e); 	
				} 
	
				System.out.println("RespiratorySystem: Using Properties from Datastore");
				bStored = true;
			}
			else
			{
				//System.out.println("RespiratorySystem - Using LocalProperties...");
			}
			System.out.println("RespiratorySystem - PropertiesSize: " + bioMightProperties.size());
		

			if (BioWebUtils.isViewEnabled(Constants.LungsRef, bioMightProperties)) {	
				System.out.println("Creating the Lungs for ParentID: " + bioMightTransform.getId());
				lungs = new Lungs(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
				BioMightGenerate generatedLungs = lungs.getBioMightGenerate(); 
				initProperty(Constants.LungsRef, Constants.Lungs, Constants.LungsRef, lungs.getComponentID(), bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, true);							
				System.out.println("Created the Lungs");
			}
			else
				initProperty(Constants.LungsRef, Constants.LungsRef, Constants.LungsRef, BioWebUtils.getPropertyID(Constants.LungsRef, bioMightProperties), bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);					
	
			
			if (BioWebUtils.isViewEnabled(Constants.HeartRef, bioMightProperties)) {		
				System.out.println("Creating the Heart for ParentID: " + bioMightTransform.getId());
				heart = new Heart(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
				BioMightGenerate generatedHeart = heart.getBioMightGenerate(); 
				initProperty(Constants.HeartRef, Constants.Heart, Constants.HeartRef, heart.getComponentID(), bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, true);							
				System.out.println("Created the Heart");
			}
			else
				initProperty(Constants.HeartRef, Constants.Heart, Constants.HeartRef, BioWebUtils.getPropertyID(Constants.HeartRef, bioMightProperties), bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);					

			
			if (BioWebUtils.isViewEnabled(Constants.TracheaRef, bioMightProperties)) {		
				System.out.println("Creating the Trachea for ParentID: " + bioMightTransform.getId());
				trachea = new Trachea(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
				BioMightGenerate generatedTrachea = trachea.getBioMightGenerate(); 
				initProperty(Constants.TracheaRef, Constants.Trachea, Constants.TracheaRef, trachea.getComponentID(), bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, true);							
				System.out.println("Created the Trachea");
			}
			else
				initProperty(Constants.TracheaRef, Constants.Trachea, Constants.TracheaRef, BioWebUtils.getPropertyID(Constants.TracheaRef, bioMightProperties), bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);					
	
			
			if (BioWebUtils.isViewEnabled(Constants.BronchiRef, bioMightProperties)) {		
				System.out.println("Creating Bronchi using ParentID: " + bioMightTransform.getId());
				bronchi = new Bronchi(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
				BioMightGenerate generatedBronchi = bronchi.getBioMightGenerate(); 		
				initProperty(Constants.BronchiRef, Constants.Bronchi, Constants.BronchiRef, bronchi.getComponentID(), bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, true);							
				System.out.println("Bronchi are created");
			}
			else
				initProperty(Constants.BronchiRef, Constants.Bronchi, Constants.BronchiRef, BioWebUtils.getPropertyID(Constants.BronchiRef, bioMightProperties), bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);					
	
			
			if (BioWebUtils.isViewEnabled(Constants.LobarBronchiRef, bioMightProperties)) {		
				System.out.println("Creating LobarBronchi using ParentID: " + bioMightTransform.getId());
				lobarBronchi = new LobarBronchi(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
				initProperty(Constants.LobarBronchiRef, Constants.LobarBronchi, Constants.LobarBronchiRef, lobarBronchi.getComponentID(), bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, true);										
				System.out.println("LobarBronchi are created");
			}
			else
				initProperty(Constants.LobarBronchiRef, Constants.LobarBronchi, Constants.LobarBronchiRef, BioWebUtils.getPropertyID(Constants.LobarBronchiRef, bioMightProperties), bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);					
	
			
			if (BioWebUtils.isViewEnabled(Constants.SegmentalinicBronchiRef, bioMightProperties)) {		
				System.out.println("Creating SegmentalinicBronchi using ParentID: " + bioMightTransform.getId());
				segmentalinicBronchi = new SegmentalinicBronchi(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
				BioMightGenerate generatedSegmentalinicBronchi = segmentalinicBronchi.getBioMightGenerate(); 				
				initProperty(Constants.SegmentalinicBronchiRef, Constants.SegmentalinicBronchi, Constants.SegmentalinicBronchiRef, segmentalinicBronchi.getComponentID(), bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, true);							
				
				System.out.println("SegmentalinicBronchi are created");
			}
			else
				initProperty(Constants.SegmentalinicBronchiRef, Constants.SegmentalinicBronchi, Constants.SegmentalinicBronchiRef, BioWebUtils.getPropertyID(Constants.SegmentalinicBronchiRef, bioMightProperties), bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);					
	
			
			// Store the new set of properties based on the init Property methods called above	
			// This means the user set properties
			if (properties != null && !bStored) {
				if (properties.size()>0) {
				// Store the Properties that the user set in the page	
				// We will use the enable flag to see what should be turned on/off
					try {
						// Get the information from the database via the Enterprise Bean		
						//System.out.println("Setting Property info for RespiratorySystem: " + bioMightTransform.getId());
						InitialContext ctx = new InitialContext();
						BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
						int propSave = bioMightBean.insertComponentProps(bioMightTransform.getId(),
								Constants.RespiratorySystemRef, bioMightTransform.getComponentName(), properties);      
						//System.out.println("Stored RespiratorySystem Property Info into EJB: " + propSave);   	
					}catch (Exception e) { 
						System.out.println("Exception Storing Components Properties - RespiratorySystem");
						throw new ServerException("Remote Exception insertComponentProps():", e); 	
					} 
				}
			}

			
		}
		//initProperties();
		initMethods();
		
		System.out.println("Create RespiratorySystem Completed");
		
		// First, get all the data from the database
		// Apply the methods to it
		// Save its state
		this.parentID = parentID;
		if (bioMightMethods != null){
			System.out.println("EXECUTING RespiratorySystem METHODS: " + bioMightMethods.size());
			//executeMethods(bioMightMethods);
		}
	}
	
	
	
	/*******************************************************************
	 * GENERATE the RespiratorySystem
	 * 
	 * @param parentID
	 * @param componentID
	 ****************************************************************/
	
	public void generate(String parentID, String componentID)
	{
		// Generate the DescendingRespiratorySystemEndothelium		
		BioMightVascularBeanLocal bioMightBean;
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Generating the RespiratorySystemEndothelium: " + componentID + "    " + parentID);
			InitialContext ctx = new InitialContext();
			bioMightBean = (BioMightVascularBeanLocal) ctx.lookup("java:global/BioMightWeb/BioMightVacularBean!biomight.ejb.BioMightVascularBeanLocal");
	
			double circumference = 0.25;
		
			if (parentID.equals("Chest:01")) 
			{	
				// Generate the DescendingRespiratorySystemEndothelium of the stomach
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
	
				System.out.println("Calling Generate RespiratorySystemEndothelium: " + componentID + "    " + parentID);
				
				//int success = bioMightBean.generateRespiratorySystem("RespiratorySystemEndothelium:00001", "RespiratorySystemEndothelium", 
				//	"RespiratorySystemEndothelium", componentID, parentID, currentPoints);			
	
				//success = bioMightBean.generateBlood("RespiratorySystemEndothelium:00001", "RespiratorySystemEndothelium", 
				//		"RespiratorySystemEndothelium", componentID, parentID, currentPoints);			
				
			}			
			else if (parentID.equals("Abdomen:01")) 
			{	
				// Generate the DescendingRespiratorySystemEndothelium of the stomach
				// Create 5 sections
				double[] startPos = {-0.3,-14.0, -6.0};
				
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
	
				System.out.println("Calling Generate RespiratorySystemEndothelium: " + componentID + "    " + parentID);
				
				//int success = bioMightBean.generateRespiratorySystem("RespiratorySystemEndothelium:00080", "RespiratorySystemEndothelium", 
				//	"RespiratorySystemEndothelium", componentID, parentID, currentPoints);			
					
			}
			else if (parentID.equals("")) 
			{	
				System.out.println("Calling Generate RespiratorySystemEndothelium NoParent");
							
			}
			
			System.out.println("Created RespiratorySystemEndothelium Info using EJB");   	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - RespiratorySystemEndothelium");
			throw new ServerException("Remote Exception getComponents():", e); 	
		}
	}
	
	
	public void initProperties() {

		BioMightPropertyView property;

		property = new BioMightPropertyView();
		property.setPropertyName("Heart");
		property.setCanonicalName(Constants.Heart);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("Lungs");
		property.setCanonicalName(Constants.Lungs);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("Trachea");
		property.setCanonicalName(Constants.Trachea);
		properties.add(property);
	}
	
	
	public void initMethods() {

		BioMightMethodView method;		
		method = new BioMightMethodView();
		method.setMethodName("Breathe");
		method.setHtmlType("checkbox");
		methods.add(method);
		
		method = new BioMightMethodView();
		method.setMethodName("Inhale");
		method.setHtmlType("checkbox");
		methods.add(method);
		
		method = new BioMightMethodView();
		method.setMethodName("Exhale");
		method.setHtmlType("checkbox");
		methods.add(method);

		method = new BioMightMethodView();
		method.setMethodName("Capacity");
		method.setHtmlType("text");
		methods.add(method);
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
		"title='RespiratorySystem'\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		

		String body = "";
		
		if (BioWebUtils.isViewEnabled(Constants.HeartRef, properties)) {
			body += heart.getX3D(true);
		}
		if (BioWebUtils.isViewEnabled(Constants.TracheaRef, properties)) {
			body += trachea.getX3D(true);
		}
		if (BioWebUtils.isViewEnabled(Constants.BronchiRef, properties)) {
			body += bronchi.getX3D(true);
		}
		if (BioWebUtils.isViewEnabled(Constants.LobarBronchiRef, properties)) {
			body += lobarBronchi.getX3D(true);
		}
		if (BioWebUtils.isViewEnabled(Constants.SegmentalinicBronchiRef, properties)) {
			body += segmentalinicBronchi.getX3D(true);
		}
		if (BioWebUtils.isViewEnabled(Constants.LungsRef, properties)) {
			body += lungs.getX3D(true);
		}
	   
		
		//System.out.println("RespiratorySystem X3D: " + body);		
		String footer = "</Scene>" + "</X3D>\n";
		
		if (snipet)
			return body;			
		else	
			return header + body + footer;
	}
	
	
	
	
	public void setLungCapacity(BigDecimal percent)
	{
	}
	
	public void setOxygenUptake()
	{
	
	}

	public void setCarbonMonoxideUptake()
	{
	
	}
	
	public void onContact(Object obj)
	{
		

		/**
		 *  Bacteria
		 */	
	
		if (obj instanceof StreptococcusPneumoniae)
		{
			// Pneumonia
		}
		
	
		if (obj instanceof HaemophilusInfluenzae)
		{
		}
		
		if (obj instanceof MycobacteriumTuberculosis)
		{
		}

		/**
		 *  Bacteria
		 */	
		
		if (obj instanceof RhinoVirus)
		{
		}


		if (obj instanceof RespiratorySyncytialVirus)
		{
		}
		
		if (obj instanceof MeaslesVirus)
		{
		}		

		if (obj instanceof MumpsVirus)
		{
		}
		
		if (obj instanceof RubellaVirus)
		{
		}

		if (obj instanceof HantaVirus)
		{
		}				

		if (obj instanceof Adenovirus)
		{
		}	
	}
		
	
}

