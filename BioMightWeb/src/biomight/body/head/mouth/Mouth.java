/*
 * Created on Jul 5, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.body.head.mouth;
import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.naming.InitialContext;

import biomight.BioMightBase;
import biomight.Constants;
import biomight.body.head.mouth.tongue.Tongue;
import biomight.body.head.tooth.*;
import biomight.ejb.BioMightBeanLocal;
import biomight.exceptions.DataSecurityException;
import biomight.exceptions.ServerException;
import biomight.system.skeletal.skull.cranial.EthmoidBone;
import biomight.view.BioMightMethodView;
import biomight.view.BioMightPolygons;
import biomight.view.BioMightPosition;
import biomight.view.BioMightPropertyView;
import biomight.view.BioMightScale;
import biomight.view.BioMightSphere;
import biomight.view.BioMightTransform;
import biomight.view.BioMightTransforms;


/**
 * @author SurferJim
 *
 *	Representation of the mouth
 */

public class Mouth extends BioMightBase {
	private BioMightSphere bioMightSphere;
	private Lips lips;
	private Teeth teeth;
	private Tongue tongue;
	private SalivaryGlands salivaryGlands;

	
	
	public Mouth()
	{
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, Constants.MouthRef, null, null);
	}

	public Mouth(String parentID)
	{
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, parentID, null, null);
	}

	public Mouth(int hierarchy, int LOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
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
	{		setImage("images/Mouth.jpg");
		setImageHeight(300);
		setImageWidth(300);

		
		// Get the information from the database via the Enterprise Bean		
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Getting MouthInfo for ParentID: " + parentID);
			InitialContext ctx = new InitialContext();
			BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
			bioMightTransforms = bioMightBean.getComponents(Constants.MouthRef, parentID);
			System.out.println("Have Mouth Info from EJB");   	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - Mouth");
			throw new ServerException("Remote Exception getComponents():", e); 	
		}
		
		int localVP = Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;

		BioMightScale bioScale = new BioMightScale("0.00, 0.00, 0.00");
		BioMightPosition  bioPos = new BioMightPosition("0.00, 0.00, 0.00");
		String bioTemplate="Mouth.x3d";

		
		// Run through the collection of Pupils and build them into the model
		// In the default case, we get one instance of the Pupil for each eye
		ArrayList transforms = bioMightTransforms.getTransforms();
		System.out.println("Have Mouth NumTransforms: " + transforms.size());
		for (int i=0; i<transforms.size(); i++)
		{
			// Get the information for the eye we are creating
			BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
			System.out.println("Creating Mouth (name,id): " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
			componentID = bioMightTransform.getId();
			
			int view = Constants.VIEW_FLOATING;
			if (view == Constants.VIEW_FLOATING)
			{
				lips = new Lips(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);	
				initProperty(Constants.LipsRef, Constants.Lips, Constants.LipsRef, lips.getComponentID(), bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);								
				System.out.println("In Mouth - Created Lips");
				
				teeth = new Teeth(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);	
				initProperty(Constants.TeethRef, Constants.Teeth, Constants.TeethRef, teeth.getComponentID(), bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);	
				System.out.println("In Mouth - Created Teeth");
				
				tongue = new Tongue(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);	
				initProperty(Constants.TongueRef, Constants.Tongue, Constants.TongueRef, tongue.getComponentID(), bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);	
				System.out.println("In Mouth - Created Tongue");
				
				salivaryGlands = new  SalivaryGlands(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
				initProperty(Constants.SalivaryGlandsRef, Constants.SalivaryGlands, Constants.SalivaryGlandsRef, salivaryGlands.getComponentID(), bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);	
				System.out.println("In Mouth - Created SalivaryGlands");

			}
			else if (view == Constants.VIEW_DETACHED)
			{
				//lips = new Lips(bioMightTransform.getId());			
				//teeth = new  Teeth();
			}
			else
			{
				//teeth = new  Teeth();
				//tongue = new  Tongue();
				//salivaryGlands = new  SalivaryGlands();
			}	
		}		
	
		//initProperties();
		initMethods();
		System.out.println("Created Mouth");
	}
	
	
	public void redraw(String parentID)
	{
		int view = Constants.VIEW_FLOATING;
		if (view == Constants.VIEW_FLOATING)
		{
			//lips.redraw(parentID);
			System.out.println("Mouth - Redraw");
		}
		
		//init3D(position);
		initProperties();
		initMethods();
		System.out.println("Mouth Redraw");
	}	
	
	
	public void initProperties() {

		BioMightPropertyView property = new BioMightPropertyView();
		property.setPropertyName("Lips");
		property.setCanonicalName(Constants.Lips);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("Teeth");
		property.setCanonicalName(Constants.Teeth);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("Tongue");
		property.setCanonicalName(Constants.Tongue);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("Salivary Glands");
		property.setCanonicalName(Constants.SalivaryGlands);
		properties.add(property);
	}
	

	public void initMethods() {

		BioMightMethodView method;

		method = new BioMightMethodView();
		method.setMethodName("Reproduce");
		method.setHtmlType("checkbox");
		methods.add(method);	
		
		method = new BioMightMethodView();
		method.setMethodName("Mate");
		method.setHtmlType("text");
		methods.add(method);	

		method = new BioMightMethodView();
		method.setMethodName("Lyse");
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
		
		// Assembe the Head
		String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
		"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n " +
		"<X3D profile='Immersive' >\n" +
		"<head>\n" +
		 "<meta name='BioMightImage' content='Mouth.jpg'/>\n" +
		 "<meta name='ExportTime' content='7:45:30'/>\n" +
		 "<meta name='ExportDate' content='08/15/2008'/>\n" +
		 "<meta name='BioMight Version' content='1.0'/>\n" + 
		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='Mouth'\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		

		System.out.println("Assembling Mouth X3D");
		String body = 
			lips.getX3D(true) +
			teeth.getX3D(true) +
			tongue.getX3D(true) +
			salivaryGlands.getX3D(true); 
		
		//System.out.println("Mouth X3D: " + body);		
		
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



}
