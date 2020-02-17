/*
 * Created on May 8, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.body.head.ear;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.naming.InitialContext;





import biomight.Constants;
import biomight.body.BodyPart;
import biomight.body.head.eye.Eye;
import biomight.ejb.BioMightBeanLocal;
import biomight.exceptions.DataSecurityException;
import biomight.exceptions.ServerException;
import biomight.system.nervous.nerves.head.ear.VestibularNerve;
import biomight.view.BioMightMethodView;
import biomight.view.BioMightPosition;
import biomight.view.BioMightPropertyView;
import biomight.view.BioMightScale;
import biomight.view.BioMightTransform;
import biomight.view.BioMightTransforms;

/****************************************************************************
 * @author SurferJim
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 ***************************************************************************/

public class Ears extends BodyPart {
	private ArrayList ears;

	
	/********************************************************************************************************************
	 *  EARS
	 * 
	 * This method will instantiate the Ears that are defined for the current model.  
	 * 
	 ********************************************************************************************************************/

	
	public Ears()
	{
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, Constants.EarsRef, null, null);
	}
	

	/********************************************************************************************************************
	 *  EARS
	 * 
	 * This method will instantiate the Eyes that are defined for the current model.  
	 * 
	 ********************************************************************************************************************/

	
	public Ears(String parentID)
	{		
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, parentID, null, null);
	}
	

	public Ears(int hierarchy, int LOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
	{
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
		this.setImage("images/Ears.jpg");
		this.setImageWidth(300);
		this.setImageHeight(325);

		// Allocate space for the collection of ears
		ears = new ArrayList();
		
		
		// Get the information from the database via the Enterprise Bean		
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Getting EarsInfo for ParentID: " + parentID);
			InitialContext ctx = new InitialContext();
			BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
			bioMightTransforms = bioMightBean.getComponents(Constants.EarRef, parentID);
			System.out.println("Have Ears Info from EJB");   	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - Ears");
			throw new ServerException("Remote Exception getComponents():", e); 	
		}

		
		// This is a collection, so set the parent of the children
		// to that of the aggregation object
		//componentID = parentID;
		componentID = Constants.EarsRef+":0"; 
		
		// Run through the collection of Ears and build them into the model
		// In the Default case, we get two instances of the ear, one
		// positioned on the right and one positioned on the left
		ArrayList transforms = bioMightTransforms.getTransforms();
		System.out.println("Creating Ears NumTransforms: " + transforms.size());

		int localVP = Constants.VIEW_INTERNAL;
		int localLOD = Constants.MAG1X;
		
		BioMightScale bioScale = new BioMightScale("0.00, 0.00, 0.00");
		BioMightPosition  bioPos = new BioMightPosition("0.00, 0.00, 0.00");
		String bioTemplate="Histidines.x3d";


		for (int i=0; i<transforms.size(); i++)
		{
			// Get the information for the eye we are creating
			BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
			System.out.println("Creating Ear: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
								
			// Create an instance of the Ear for each tranform brought
			// Ears from the model.  We grabbed the component ID during this fetch
			// so pass it to the EAR creator so that it can be used as a parent reference
			Ear ear = new Ear(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);		
			ears.add(ear);
			initProperty(bioMightTransform.getName(), Constants.Ear, Constants.EarRef, bioMightTransform.getId());
			System.out.println("Added Ear to Collection!: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
			
			// initialize the Properties
			// in this case, rather than pass canonical name, we pass the name found in the collection
			
		}
		
		// Set up methods that will be available to the ears
		initMethods();
	}
		
	
	public void initMethods() {
	
		BioMightMethodView method;

		method = new BioMightMethodView();
		method.setMethodName("setHearingLevel");
		method.setDisplayName("HearingLevel:");
		method.setHtmlType("dropdown");
		method.setDataType("String");
		
     	HashMap eyeColor = new HashMap();
     	eyeColor.put(250, "20db");
    	eyeColor.put(25, "25db");
     	eyeColor.put(30, "30db");
     	eyeColor.put(35, "35dbl");
    	method.setValueMap(eyeColor);
		methods.add(method);	
	}
	
	/********************************************************************************************************************
	 * GET X3D
	 * 
	 * This method will return the X3D for the Ears.  It runs through each of its components and collects up their
	 * representations and then assembles them into one unified X3D model.
	 * 
	 ********************************************************************************************************************/
	public String getX3D(boolean snipet) {
		
		// Assembe the Ears
		String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
		"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n " +
		"<X3D profile='Immersive' >\n" +
		"<head>\n" +
		 "<meta name='BioMightImage' content='Ears.jpg'/>\n" +
		 "<meta name='ExportTime' content='7:45:30'/>\n" +
		 "<meta name='ExportDate' content='08/15/2008'/>\n" +
		 "<meta name='BioMight Version' content='1.0'/>\n" + 
		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='Ears'\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		

		String body = ""; 
		System.out.println("Assembling X3D for Ears");
		
		// Run through the collection of eyes and assemble the X3D for each
		for (int i=0; i<ears.size(); i++)
		{
			// Get the information for the eye
			Ear ear = (Ear) ears.get(i);
			System.out.println("Getting X3D for Ear");
			body += ear.getX3D(true);
		}		
		

		//System.out.println("Ears X3D: " + body);		
		
		String footer = "</Scene>" + "</X3D>\n";
		
		if (snipet)
			return body;			
		else	
			return header + body + footer;
	}

}
