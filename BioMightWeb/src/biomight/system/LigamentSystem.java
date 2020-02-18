
/**
 * @author SurferJim
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
/*
 * Created on Jul 8, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */

package biomight.system;
import java.util.ArrayList;

import javax.naming.InitialContext;

import biomight.BioMightBase;
import biomight.Constants;
import biomight.body.spine.Spine;
import biomight.ejb.BioMightBeanLocal;
import biomight.ejb.BioMightVascularBeanLocal;
import biomight.ejb.DBUtils;
import biomight.exceptions.DataException;
import biomight.exceptions.DataSecurityException;
import biomight.exceptions.ServerException;
import biomight.util.BioGraphics;
import biomight.view.BioMightConstruct;
import biomight.view.BioMightInstructSet;
import biomight.view.BioMightInstruction;
import biomight.view.BioMightMethodView;
import biomight.view.BioMightOrientation;
import biomight.view.BioMightPropertyView;
import biomight.view.BioMightTransform;


/******************************************************************************
 * @author SurferJim
 *
 * Representation of the Ligament System
 * 
 *****************************************************************************/

public class LigamentSystem extends BioMightBase{

	// Head
	//private Ligament ligament;	

	//7717 0930 7240
	// Neck and Back

	// Chest
	
	// Arm
	
	// Wrist and Hand
	
	// Pelvis
	
	// Leg

	// Foot
	
	
	
	/************************************************************************
	 * LIGAMENT SYSTEM Constructor 
	 *
	 ***********************************************************************/

	public LigamentSystem()
	{
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, Constants.LigamentSystem, null, null);
	}

	public LigamentSystem(String parentID)
	{
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, parentID, null, null);
	}

	
	public LigamentSystem(int localVP, int localLOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods) {
		
		localVP = Constants.VIEW_INTERNAL;
		localLOD = Constants.MAG2X;
		create(localVP, localLOD, parentID, bioMightProperties,  bioMightMethods);
	}
	
	
	/**********************************************************************************
	 * CREATE LIGAMENT SYSTEM
	 * 
	 * @param parentID
	 * @param bioMightMethods
	 *********************************************************************************/
	
	public void create(int localVP, int localLOD,  String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
	{
		this.setImage("images/LigamentSystem.jpg");
		this.setImageHeight(300);
		this.setImageWidth(300);
		
		
		// Get the information from the database via the Enterprise Bean		
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Getting LigamentSystemInfo for ParentID: " + parentID);
			InitialContext ctx = new InitialContext();
			BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
			bioMightTransforms = bioMightBean.getComponents(Constants.LigamentSystemRef, parentID);
			System.out.println("Have LigamentSystem Info from EJB");   	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - LigamentSystem");
			throw new ServerException("Remote Exception getComponents():", e); 	
		}
		
			
		// Run through the collection of LigamentSystems and build them into the model
		// In the default case, we get one instance of the LigamentSystem for each eye
		ArrayList transforms = bioMightTransforms.getTransforms();
		System.out.println("LigamentSystem NumTransforms: " + transforms.size());
		for (int i=0; i<transforms.size(); i++)
		{
			// Get the information for the LigamentSystem we are creating
			BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
			System.out.println("Retrieve LigamentSystem: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
			this.componentID = bioMightTransform.getId();
			
			// Generate the LigamentSystem Endothelium if needed 
			boolean bGenerate = false;
			if (bGenerate) {
				generate(parentID, componentID);
			}	
		
			// ARM BONES
			//System.out.println("Creating the Humeri for parent: " + bioMightTransform.getId());
			//humeri = new Humeri(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
			//initProperty("Humeri", Constants.Humeri, Constants.HumeriRef, humeri.getComponentID());
			//System.out.println("Created the Humeri");
		}
		//initProperties();
		initMethods();
		
		System.out.println("Create LigamentSystem Completed");
		
		// First, get all the data from the database
		// Apply the methods to it
		// Save its state
		this.parentID = parentID;
		if (bioMightMethods != null){
			System.out.println("EXECUTING LigamentSystem METHODS: " + bioMightMethods.size());
			//executeMethods(bioMightMethods);
		}
	}


			
	public void initProperties() {
		
		BioMightPropertyView property = new BioMightPropertyView();
		property.setPropertyName("Skull");
		property.setCanonicalName(Constants.Skull);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("Spine");
		//property.setCanonicalName(Constants.Spine);
		properties.add(property);		
		
		property = new BioMightPropertyView();
		property.setPropertyName("Clavicle");
		property.setCanonicalName(Constants.Clavicle);
		properties.add(property);
	
		property = new BioMightPropertyView();
		property.setPropertyName("TalusBone");
		property.setCanonicalName(Constants.TalusBone);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("Tarsals");
		property.setCanonicalName(Constants.Tarsals);
		properties.add(property);
	
	}
	
	
	public void initMethods() {
	
		BioMightMethodView method = new BioMightMethodView();		
		method = new BioMightMethodView();
		method.setMethodName("Bone Mass");
		method.setHtmlType("text");
		methods.add(method);

	}
	
	
	/*******************************************************************
	 * GENERATE the LigamentSystem
	 * 
	 * @param parentID
	 * @param componentID
	 ****************************************************************/
	
	public void generate(String parentID, String componentID)
	{
		// Generate the DescendingLigamentSystemEndothelium		
		BioMightVascularBeanLocal bioMightBean;
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Generating the LigamentSystemEndothelium: " + componentID + "    " + parentID);
			InitialContext ctx = new InitialContext();
			bioMightBean = (BioMightVascularBeanLocal) ctx.lookup("java:global/BioMightWeb/BioMightVacularBean!biomight.ejb.BioMightVascularBeanLocal");
	
			double circumference = 0.25;
		
			if (parentID.equals("Chest:01")) 
			{	
				// Generate the DescendingLigamentSystemEndothelium of the stomach
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
	
				System.out.println("Calling Generate LigamentSystemEndothelium: " + componentID + "    " + parentID);
				
				//int success = bioMightBean.generateLigamentSystem("LigamentSystemEndothelium:00001", "LigamentSystemEndothelium", 
				//	"LigamentSystemEndothelium", componentID, parentID, currentPoints);			
	
				//success = bioMightBean.generateBlood("LigamentSystemEndothelium:00001", "LigamentSystemEndothelium", 
				//		"LigamentSystemEndothelium", componentID, parentID, currentPoints);			
				
			}			
			else if (parentID.equals("Abdomen:01")) 
			{	
				// Generate the DescendingLigamentSystemEndothelium of the stomach
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
	
				System.out.println("Calling Generate LigamentSystemEndothelium: " + componentID + "    " + parentID);
				
				//int success = bioMightBean.generateLigamentSystem("LigamentSystemEndothelium:00080", "LigamentSystemEndothelium", 
				//	"LigamentSystemEndothelium", componentID, parentID, currentPoints);			
					
			}
			else if (parentID.equals("")) 
			{	
				System.out.println("Calling Generate LigamentSystemEndothelium NoParent");
							
			}
			
			System.out.println("Created LigamentSystemEndothelium Info using EJB");   	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - LigamentSystemEndothelium");
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
		"title='LigamentSystem'\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		

		System.out.println("Getting LigamentSystem X3D!");	
		String body = 	
			 //humeri.getX3D(true) +
			 "";
		
		//System.out.println("LigamentSystem X3D: " + body);		
		String footer = "</Scene>" + "</X3D>\n";
		
		if (snipet)
			return body;			
		else	
			return header + body + footer;
	}
		

	
	public void setBoneDensity()
	{
	}
	
	


}
