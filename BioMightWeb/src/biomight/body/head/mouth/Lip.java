/*
 * Created on Jul 5, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.body.head.mouth;
import java.util.ArrayList;

import javax.naming.InitialContext;

import biomight.BioMightBase;
import biomight.Constants;
import biomight.ejb.BioMightBeanLocal;
import biomight.exceptions.ServerException;
import biomight.system.tissue.edothelial.EndotheliumTissue;
import biomight.system.tissue.epithelial.EpitheliumTissue;
import biomight.view.BioMightMethodView;
import biomight.view.BioMightPolygons;
import biomight.view.BioMightPosition;
import biomight.view.BioMightPropertyView;
import biomight.view.BioMightScale;
import biomight.view.BioMightTransform;
import biomight.view.BioMightTransforms;


/**
 * @author SurferJim
 *
 * Representation of a Lip.  UpperLip and Lower Lip extend it.
 */

public class Lip extends BioMightBase {
	private EpitheliumTissue epitheliumTissue;
	protected BioMightPolygons bioMightPolygons;
	

	public Lip()
	{
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, Constants.LipRef, null, null);
	}

	public Lip(String parentID)
	{
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, parentID, null, null);
	}

	public Lip(int hierarchy, int LOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
	{
		System.out.print("Calling Lip Create");
		create(hierarchy, LOD, parentID, bioMightProperties, bioMightMethods);
	}

	/*****************************************************************
	 * CREATE
	 * 
	 * @param parentID
	 * @param bioMightMethods
	 ******************************************************************/
	public void create(int hierarchy, int LOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
	{		setImage("images/Lip.jpg");
		setImageHeight(300);
		setImageWidth(300);
						
		// This is being assembled from a collection, so we need to reset the ID
		componentID=parentID;

		int localVP = Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;

		BioMightScale bioScale = new BioMightScale("0.00, 0.00, 0.00");
		BioMightPosition  bioPos = new BioMightPosition("0.00, 0.00, 0.00");
		String bioTemplate="Bacterias.x3d";
			
		// Get the information for the Lip we are creating
		String startID = "LipEndothelium:00001";
		System.out.println("Creating Lip");	
		epitheliumTissue = new EpitheliumTissue(localVP, localLOD, startID, "LipEndothelium",  Constants.EpitheliumTissueRef, parentID, bioMightProperties, bioMightMethods);
		initProperty("LipEndothelium", "LipEndothelium", Constants.EpitheliumTissueRef, epitheliumTissue.getComponentID(), bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);					
		
		System.out.println("Created LipEndothelium for Lip");	

	}
	
		
	public void initProperties() {

		BioMightPropertyView property = new BioMightPropertyView();
		property = new BioMightPropertyView();
		property.setPropertyName("Upper Lip");
		property.setCanonicalName(Constants.UpperLip);
		properties.add(property);
	}
	
	
	public void initMethods() {
	
		BioMightMethodView method = new BioMightMethodView();
		method.setMethodName("Kiss");
		method.setHtmlType("checkbox");
		methods.add(method);	
		
		method = new BioMightMethodView();
		method.setMethodName("Pucker");
		method.setHtmlType("Checkbox");
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
		
		// Assemble the Nose
		String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
		"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n " +
		"<X3D profile='Immersive' >\n" +
		"<head>\n" +
		 "<meta name='BioMightImage' content='Nose.jpg'/>\n" +
		 "<meta name='ExportTime' content='7:45:30'/>\n" +
		 "<meta name='ExportDate' content='08/15/2008'/>\n" +
		 "<meta name='BioMight Version' content='1.0'/>\n" + 
		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='Lip'\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		

		String body = epitheliumTissue.getX3D(true);
		
		//System.out.println("Lip X3D: " + body);		
		String footer = "</Scene>" + "</X3D>\n";
		
		if (snipet)
			return body;			
		else	
			return header + body + footer;
	}
	
	

	public void onMessage(String messageType)
	{
		
		// Something is touching the tounge.  The nerves in the tounge
		// will send a message to the Brain and ----- cells will release
		// solvents.
		if (messageType.equals("CHEW"))
		{
			// Send a message to the brain
			
			// Start Digestion
		}

		// Flip the tounge to move the food into the
		// ready to swallow position
		if (messageType.equals("SWALLOW"))
		{
			// Send a message to the object to
			// reposition it in the model.
			// sendMessage();
		}		


		// Carry out messages delivered from the brain
		if (messageType.equals("SPIT"))
		{
			// Send a message to the brain
			// Start Digestion 
		}		


		// Carry out messages delivered from the brain
		if (messageType.equals("EXPOSE TONGUE"))
		{
			// Send a message to the brain
			// Start Digestion 
		}	
			
	}

	
	public void Ingest()
	{
		// This is the first step of digestion, 
		// placing food in one's mouth
	}

	public void Chew()
	{
		// Mastication
	}


	public void Salivate()
	{
		
	}


	public ArrayList<BioMightMethodView> getMethods() {
		return methods;
	}


	public void setMethods(ArrayList<BioMightMethodView> methods) {
		this.methods = methods;
	}


	public ArrayList<BioMightPropertyView> getProperties() {
		return properties;
	}


	public void setProperties(ArrayList<BioMightPropertyView> properties) {
		this.properties = properties;
	}


	public String getComponentID() {
		return componentID;
	}

	public void setComponentID(String componentID) {
		this.componentID = componentID;
	}
}
