
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
import biomight.ejb.BioMightTissueBeanLocal;
import biomight.ejb.BioMightVascularBeanLocal;
import biomight.ejb.DBUtils;
import biomight.exceptions.DataException;
import biomight.exceptions.DataSecurityException;
import biomight.exceptions.ServerException;
import biomight.system.cartilage.CostalCartilage;
import biomight.system.cartilage.CostalCartilages;
import biomight.util.BioGraphics;
import biomight.view.BioMightMethodView;
import biomight.view.BioMightPropertyView;
import biomight.view.BioMightTransform;


/******************************************************************************
 * @author SurferJim
 *
 * Representation of the Tissue System
 * 
 *****************************************************************************/

public class TissueSystem extends BioMightBase{

	// Head
	//private Tissue ligament;	

	//7717 0930 7240
	// Neck and Back

	// Chest
	private CostalCartilages costalCartilages;
	
	
	// Arm
	
	// Wrist and Hand
	
	// Pelvis
	
	// Leg

	// Foot
	
	
	
	/************************************************************************
	 * LIGAMENT SYSTEM Constructor 
	 *
	 ***********************************************************************/

	public TissueSystem()
	{
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, Constants.TissueSystem, null, null);
	}

	public TissueSystem(String parentID)
	{
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, parentID, null, null);
	}

	
	public TissueSystem(int localVP, int localLOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods) {
		
		localVP = Constants.VIEW_INTERNAL;
		localLOD = Constants.MAG2X;
		create(localVP, localLOD, parentID, bioMightProperties,  bioMightMethods);
	}
	
	
	/**********************************************************************************
	 * CREATE TISSUE SYSTEM
	 * 
	 * @param parentID
	 * @param bioMightMethods
	 *********************************************************************************/
	
	public void create(int localVP, int localLOD,  String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
	{
		this.setImage("images/TissueSystem.jpg");
		this.setImageHeight(300);
		this.setImageWidth(300);
		
		
		// Get the information from the database via the Enterprise Bean		
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Getting TissueSystemInfo for ParentID: " + parentID);
			InitialContext ctx = new InitialContext();
			BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
			bioMightTransforms = bioMightBean.getComponents(Constants.TissueSystemRef, parentID);
			System.out.println("Have TissueSystem Info from EJB");   	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - TissueSystem");
			throw new ServerException("Remote Exception getComponents():", e); 	
		}
		
			
		// Run through the collection of TissueSystems and build them into the model
		// In the default case, we get one instance of the TissueSystem for each eye
		ArrayList transforms = bioMightTransforms.getTransforms();
		System.out.println("TissueSystem NumTransforms: " + transforms.size());
		for (int i=0; i<transforms.size(); i++)
		{
			// Get the information for the TissueSystem we are creating
			BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
			System.out.println("Retrieve TissueSystem: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
			this.componentID = bioMightTransform.getId();
			
			// Generate the TissueSystem if needed 
			boolean bGenerate = false;
			if (bGenerate) {
				generate(parentID, componentID);
			}	
		
			// CARTILAGE
			System.out.println("Creating the CostalCartilages for parent: " + bioMightTransform.getId());
			costalCartilages = new CostalCartilages(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
			initProperty("CostalCartilages", Constants.CostalCartilages, Constants.CostalCartilagesRef, costalCartilages.getComponentID());
			System.out.println("Created the CostalCartilages");
		}
		//initProperties();
		initMethods();
		
		System.out.println("Create TissueSystem Completed");
		
		// First, get all the data from the database
		// Apply the methods to it
		// Save its state
		this.parentID = parentID;
		if (bioMightMethods != null){
			System.out.println("EXECUTING TissueSystem METHODS: " + bioMightMethods.size());
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
	 * GENERATE the TissueSystem
	 * 
	 * @param parentID
	 * @param componentID
	 ****************************************************************/
	
	public void generate(String parentID, String componentID)
	{
		// Generate the DescendingTissueSystemEndothelium		
		BioMightTissueBeanLocal bioMightBean;
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Generating the TissueSystem: " + componentID + "    " + parentID);
			InitialContext ctx = new InitialContext();
			bioMightBean = (BioMightTissueBeanLocal) ctx.lookup(Constants.TissueBeanRef);
	
			double radius = 0.25;
		
			
				// Generate the DescendingTissueSystemEndothelium of the stomach
				// Create 5 sections
				double[] startPos = {0.0, -9.50, -0.65};
				double[][] currentPoints = BioGraphics.createCylinderInPlane(Constants.YPLANE, startPos, radius, 8);
		
	
				System.out.println("Calling Generate TissueSystemEndothelium: " + componentID + "    " + parentID);
				
				//int success = bioMightBean.generateTissueSystem("TissueSystemEndothelium:00001", "TissueSystemEndothelium", 
				//	"TissueSystemEndothelium", componentID, parentID, currentPoints);			
	
				//success = bioMightBean.generateBlood("TissueSystemEndothelium:00001", "TissueSystemEndothelium", 
				//		"TissueSystemEndothelium", componentID, parentID, currentPoints);			
				
				
			System.out.println("Created TissueSystemEndothelium Info using EJB");   	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - TissueSystemEndothelium");
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
		"title='TissueSystem'\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		

		System.out.println("Getting TissueSystem X3D!");	
		String body = 	
			 costalCartilages.getX3D(true) +
			 "";
		
		//System.out.println("TissueSystem X3D: " + body);		
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
