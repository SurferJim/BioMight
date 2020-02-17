/*
 * Created on Jul 8, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.body.organ.largeintestine;
import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;

import biomight.BioMightBase;
import biomight.Constants;
import biomight.body.gland.spleen.SpleenExternalSerousCoat;
import biomight.body.organ.smallintestine.Duodenum;
import biomight.body.organ.smallintestine.Ileum;
import biomight.body.organ.smallintestine.Jejunum;
import biomight.ejb.BioMightBeanLocal;
import biomight.exceptions.DataSecurityException;
import biomight.exceptions.ServerException;
import biomight.system.tissue.edothelial.EndotheliumTissue;
import biomight.system.tissue.epithelial.EpitheliumTissue;
import biomight.util.BioGraphics;
import biomight.view.BioMightMethodView;
import biomight.view.BioMightPosition;
import biomight.view.BioMightPropertyView;
import biomight.view.BioMightScale;
import biomight.view.BioMightTransform;
import biomight.view.BioMightTransforms;


/**************************************************************************************************
 * @author SurferJim
 *
 * Representation of the Large Intestine
 * 
 *************************************************************************************************/

public class LargeIntestine extends BioMightBase {
	private BioMightTransform gbioMightTransform; 
	protected EpitheliumTissue epithelium;
	private Rectum rectum;
	private Colon colon;
	private Caecum caecum;

	
	/*********************************************************************************
	 * CONSTRUCTORS
	 *
	 *********************************************************************************/
	
	public LargeIntestine()
	{
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, Constants.LargeIntestineRef, null, null);
	}

	public LargeIntestine(String parentID)
	{
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, parentID, null, null);
	}

	public LargeIntestine(int hierarchy, int LOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
	{
		create(hierarchy, LOD, parentID, bioMightProperties, bioMightMethods);
	}

	
	/*****************************************************************
	 * CREATE
	 * 
	 * @param parentID
	 * @param bioMightMethods
	 ******************************************************************/
	public void create(int localVP, int localLOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
	{
		this.setImage("images/LargeIntestine.jpg");
		this.setImageWidth(300);
		this.setImageHeight(325);
		this.viewPerspective = localVP;
		this.lod = localLOD;
		this.parentID = parentID;
		this.componentID = parentID;
	
		if (viewPerspective == Constants.VIEW_DETACHED)			
		{
			System.out.println("In Create LargeIntestine - DETACHED VIEW");   	
		
			
			// Get the information from the database via the Enterprise Bean		
			try {
				// Get the information from the database via the Enterprise Bean		
				System.out.println("Getting LargeIntestineInfo for ParentID: " + parentID);
				InitialContext ctx = new InitialContext();
				BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
				bioMightTransforms = bioMightBean.getComponents(Constants.LargeIntestineRef, parentID);
				System.out.println("Have LargeIntestine Info from EJB");   	
			}catch (Exception e) { 
				System.out.println("Exception Getting Components - LargeIntestine");
				throw new ServerException("Remote Exception getComponents():", e); 	
			}
				
			// Run through the collection of LargeIntestines and build them into the model
			// In the default case, we get one instance of the LargeIntestine for each eye
			ArrayList transforms = bioMightTransforms.getTransforms();
			System.out.println("LargeIntestine NumTransforms: " + transforms.size());
			for (int i=0; i<transforms.size(); i++)
			{
				// Get the information for the eye we are creating
				BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
				System.out.println("Created LargeIntestine: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
				this.componentID = bioMightTransform.getId();
				
				// Generate the component 
				boolean bGenerate = false;
				if (bGenerate) {
					generate(componentID, componentID);
				}
				
				if (localLOD == Constants.MAG1X)
				{
					System.out.println("Creating LargeIntestine at DETACHED MAG1X - Just Init Properties: " + componentID);
					// initialize the Properties
										
					String startID = "LargeIntestineEpithelium:00001";
					System.out.println("HawkEye 1x - Creating LargeIntestine Epithelium: " + parentID + "  startID: " + startID);				
					epithelium = new EpitheliumTissue(localVP, localLOD, startID, "LargeIntestineEpithelium",  Constants.EpitheliumTissueRef, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
					initProperty("LargeIntestineEpithelium", Constants.EpitheliumTissue, Constants.EpitheliumTissueRef, bioMightTransform.getId());
					
					//System.out.println("Creating LargeIntestine Endothelium: " + bioMightTransform.getId());				
					//endothelium = new EndotheliumTissue("LargeIntestineEndothelium", bioMightTransform.getId(), bioMightMethods);
					//initProperty("LargeIntestineEndothelium", Constants.EpitheliumTissue, Constants.EpitheliumTissueRef, bioMightTransform.getId());


					initProperties();
				}
				if (localLOD == Constants.MAG2X)
				{
					// Go get the finer details of the LargeIntestine				
					System.out.println("Creating LargeIntestine at DETACHED MAG2X : " + parentID);
					localVP = Constants.VIEW_INTERNAL; 
					localLOD = Constants.MAG1X;
		
					System.out.println("Creating Colon: " + bioMightTransform.getId());
					colon = new Colon(bioMightTransform.getId(), bioMightMethods);
					initProperty("Colon", Constants.Colon, Constants.ColonRef, bioMightTransform.getId());
					
					System.out.println("Creating Rectum: " + bioMightTransform.getId());
					rectum = new Rectum(bioMightTransform.getId(), bioMightMethods);
					initProperty("Rectum", Constants.Rectum, Constants.RectumRef, bioMightTransform.getId());
				
					System.out.println("Creating Caecum: " + bioMightTransform.getId());
					caecum = new Caecum(bioMightTransform.getId(), bioMightMethods);
					initProperty("Caecum", Constants.Caecum, Constants.CaecumRef, bioMightTransform.getId());

		
					System.out.println("LargeIntestine Instance is created : " + componentID + "    parent: " +  parentID);		
					//System.out.println("Creating LargeIntestine Endothelium: " + bioMightTransform.getId());				
					//endothelium = new EndotheliumTissue("LargeIntestineEndothelium", bioMightTransform.getId(), bioMightMethods);
					//initProperty("LargeIntestineEndothelium", Constants.EpitheliumTissue, Constants.EpitheliumTissueRef, bioMightTransform.getId());
				}

			}
		}
		//
		else if (viewPerspective == Constants.VIEW_INTERNAL)
		{
			// Do nothing.  We are instantiating as part of a collection  
			// There is no drill down, so we use the transforms that the
			// parent has already collected
			System.out.println("In LargeIntestine Create() - ViewInternal - Already Set from: " + parentID);				

			componentID=parentID;
			
			// Generate the component 
			boolean bGenerate = false;
			if (bGenerate) {
				generate(parentID, componentID);
			}
			
			// We already have the data for the current instance of LargeIntestine,
			// Go get the details for the current LargeIntestine is LOD is set
			if (localLOD == Constants.MAG1X)
			{
				// Go get the finer details of the LargeIntestine				
				System.out.println("Getting the LargeIntestine MAG1X : " + parentID);
				localVP = Constants.VIEW_INTERNAL; 
				localLOD = Constants.MAG1X;		
				
				String startID = "LargeIntestineEpithelium:00001";
				System.out.println("Internal 2X - Creating LargeIntestine Epithelium: " + parentID + "  startID: " + startID);				
				epithelium = new EpitheliumTissue(localVP, localLOD, startID, "LargeIntestineEpithelium",  Constants.EpitheliumTissueRef, componentID, bioMightProperties, bioMightMethods);
				initProperty("LargeIntestineEpithelium", Constants.EpitheliumTissue, Constants.EpitheliumTissueRef, componentID);
			}
			else if (localLOD == Constants.MAG2X)
			{
				// Go get the finer details of the LargeIntestine				
				System.out.println("Getting the LargeIntestine MAG2X : " + parentID);
				localVP = Constants.VIEW_INTERNAL; 
				localLOD = Constants.MAG1X;		
					
				System.out.println("Creating Colon: " + parentID);
				colon = new Colon(parentID, bioMightMethods);
				initProperty("Colon", Constants.Colon, Constants.ColonRef, parentID);
				
				System.out.println("Creating Rectum: " + parentID);
				rectum = new Rectum(parentID, bioMightMethods);
				initProperty("Rectum", Constants.Rectum, Constants.RectumRef, parentID);
			
				System.out.println("Creating Caecum: " + parentID);
				caecum = new Caecum(parentID, bioMightMethods);
				initProperty("Caecum", Constants.Caecum, Constants.CaecumRef, parentID);

				System.out.println("LargeIntestine Instance is created : " + componentID + "    parent: " +  parentID);					}

			
		}
		else if (viewPerspective == Constants.VIEW_HAWKEYE)
		{
		System.out.println("In Create LargeIntestine - DETACHED VIEW");   	
		
			
			// Get the information from the database via the Enterprise Bean		
			try {
				// Get the information from the database via the Enterprise Bean		
				System.out.println("Getting LargeIntestineInfo for ParentID: " + parentID);
				InitialContext ctx = new InitialContext();
				BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
				bioMightTransforms = bioMightBean.getComponents(Constants.LargeIntestineRef, parentID);
				System.out.println("Have LargeIntestine Info from EJB");   	
			}catch (Exception e) { 
				System.out.println("Exception Getting Components - LargeIntestine");
				throw new ServerException("Remote Exception getComponents():", e); 	
			}
				
			// Run through the collection of LargeIntestines and build them into the model
			// In the default case, we get one instance of the LargeIntestine for each eye
			ArrayList transforms = bioMightTransforms.getTransforms();
			System.out.println("LargeIntestine NumTransforms: " + transforms.size());
			for (int i=0; i<transforms.size(); i++)
			{
				// Get the information for the eye we are creating
				BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
				System.out.println("Created LargeIntestine: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
				this.componentID = bioMightTransform.getId();
				
				// Generate the component 
				boolean bGenerate = false;
				if (bGenerate) {
					generate(componentID, componentID);
				}
				
				if (localLOD == Constants.MAG1X)
				{
					System.out.println("Creating LargeIntestine at DETACHED MAG1X - Just Init Properties: " + componentID);
					// initialize the Properties
										
					String startID = "LargeIntestineEpithelium:00001";
					System.out.println("HawkEye 1x - Creating LargeIntestine Epithelium: " + parentID + "  startID: " + startID);				
					epithelium = new EpitheliumTissue(localVP, localLOD, startID, "LargeIntestineEpithelium",  Constants.EpitheliumTissueRef, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
					initProperty("LargeIntestineEpithelium", Constants.EpitheliumTissue, Constants.EpitheliumTissueRef, bioMightTransform.getId());
					
					//System.out.println("Creating LargeIntestine Endothelium: " + bioMightTransform.getId());				
					//endothelium = new EndotheliumTissue("LargeIntestineEndothelium", bioMightTransform.getId(), bioMightMethods);
					//initProperty("LargeIntestineEndothelium", Constants.EpitheliumTissue, Constants.EpitheliumTissueRef, bioMightTransform.getId());


					initProperties();
				}
				if (localLOD == Constants.MAG2X)
				{
					// Go get the finer details of the LargeIntestine				
					System.out.println("Creating LargeIntestine at DETACHED MAG2X : " + parentID);
					localVP = Constants.VIEW_INTERNAL; 
					localLOD = Constants.MAG1X;
		
					System.out.println("Creating Colon: " + bioMightTransform.getId());
					colon = new Colon(bioMightTransform.getId(), bioMightMethods);
					initProperty("Colon", Constants.Colon, Constants.ColonRef, bioMightTransform.getId());
					
					System.out.println("Creating Rectum: " + bioMightTransform.getId());
					rectum = new Rectum(bioMightTransform.getId(), bioMightMethods);
					initProperty("Rectum", Constants.Rectum, Constants.RectumRef, bioMightTransform.getId());
				
					System.out.println("Creating Caecum: " + bioMightTransform.getId());
					caecum = new Caecum(bioMightTransform.getId(), bioMightMethods);
					initProperty("Caecum", Constants.Caecum, Constants.CaecumRef, bioMightTransform.getId());

		
					System.out.println("LargeIntestine Instance is created : " + componentID + "    parent: " +  parentID);		
					//System.out.println("Creating LargeIntestine Endothelium: " + bioMightTransform.getId());				
					//endothelium = new EndotheliumTissue("LargeIntestineEndothelium", bioMightTransform.getId(), bioMightMethods);
					//initProperty("LargeIntestineEndothelium", Constants.EpitheliumTissue, Constants.EpitheliumTissueRef, bioMightTransform.getId());
				}

			}
		}
		
		
		initProperties();
		initMethods();
		
		System.out.println("CreateLargeIntestine Completed");
		
		// First, get all the data from the database
		// Apply the methods to it
		// Save its state
		if (bioMightMethods != null){
			System.out.println("EXECUTING LargeIntestine METHODS: " + bioMightMethods.size());
			//executeMethods(bioMightMethods);
		}
	}
	

	
	/****************************************************************************
	 * GENERATE LARGE INTESTINE
	 * 
	 * @param parentID
	 * @param componentID
	 ***************************************************************************/
	
	public void generate(String parentID, String componentID)
	{
		// Generate the LargeIntestine Epithelium		
		BioMightBeanLocal bioMightBean;
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Generating the LargeIntestine ParentID: " + parentID);
			InitialContext ctx = new InitialContext();
			bioMightBean = (BioMightBeanLocal) ctx.lookup("java:global/BioMightWeb/BioMightBean!biomight.ejb.BioMightBeanLocal");
			
			// Generate the large intestine
			double circumference = 0.7;		
			double[] startPos = {-3.0,-30.750, -2.75};
			double[][] currentPoints = BioGraphics.createCylinderInPlane(Constants.XPLANE, startPos, circumference, 8);
				
			int success = bioMightBean.generateLargeIntestine("LargeIntestineEpithelium:00001", "LargeIntestineEpithelium", 
					"LargeIntestineEpithelium", parentID, currentPoints);			
			System.out.println("Created LargeIntestine Info using EJB");   	
		}
		catch (Exception e) { 
			System.out.println("Exception Getting Components - LargeIntestine");
			throw new ServerException("Remote Exception getComponents():", e); 	
		}

	}
	

	/****************************************************************************
	 * INIT PROPERTIES
	 * 
	 * @param parentID
	 * @param componentID
	 ***************************************************************************/
	
	public void initProperties() {

		BioMightScale bioScale = new BioMightScale("0.00, 0.00, 0.00");
		BioMightPosition bioPos = new BioMightPosition("0.00, 0.00, 0.00");	
		String bioTemplate =""; 

		initProperty("Not Available", Constants.Title, Constants.Title, "LargeIntestine:01", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		initProperty(Constants.RectumRef, Constants.Rectum, Constants.RectumRef, "LargeIntestine:01", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		initProperty(Constants.ColonRef, Constants.Colon, Constants.ColonRef, "LargeIntestine:01", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		initProperty(Constants.CaecumRef, Constants.Caecum, Constants.CaecumRef, "LargeIntestine:01", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
	}
	
	
	public void initMethods() {

		methods = new ArrayList<BioMightMethodView>();
		
		BioMightMethodView method = new BioMightMethodView();

		method = new BioMightMethodView();
		method.setMethodName("Digest");
		method.setHtmlType("checkbox");
		methods.add(method);	
		
		method = new BioMightMethodView();
		method.setMethodName("Churn");
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
		
		// Assemble the LargeIntestine
		String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
		"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n " +
		"<X3D profile='Immersive' >\n" +
		"<head>\n" +
		 "<meta name='BioMightImage' content='LargeIntestine.jpg'/>\n" +
		 "<meta name='ExportTime' content='7:45:30'/>\n" +
		 "<meta name='ExportDate' content='08/15/2008'/>\n" +
		 "<meta name='BioMight Version' content='1.0'/>\n" + 
		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='LargeIntestine'\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		

		String body ="";
		
		// Build the model based on what you are looking based on LOD
		int viewPerspective = Constants.VIEW_DETACHED;
		if (viewPerspective == Constants.VIEW_DETACHED)
		{			
			body = epithelium.getX3D(true);		
		
			body+= "<Viewpoint DEF='Viewpoint_LargeIntestine'\n" +
					 "description='Viewpoint1'\n" +
					 "jump='true'\n" +
					 "fieldOfView='0.785'\n" +
					 "position='0.0 -30.0 20.0'\n" +
					 "orientation='0 0 1 0'/>\n";	
		}
		else
		{
			body =
				rectum.getX3D(true) + 
				colon.getX3D(true) + 
				caecum.getX3D(true);
		}
		
		//System.out.println("LargeIntestine X3D: " + body);		
		
		String footer = "</Scene>" + "</X3D>\n";
		
		if (snipet)
			return body;			
		else	
			return header + body + footer;
	}


	
	public String getComponentID() {
		return componentID;
	}


	public void setComponentID(String componentID) {
		this.componentID = componentID;
	}


	public ArrayList<BioMightPropertyView> getProperties() {
		return properties;
	}


	public void setProperties(ArrayList<BioMightPropertyView> properties) {
		this.properties = properties;
	}


	public ArrayList<BioMightMethodView> getMethods() {
		return methods;
	}


	public void setMethods(ArrayList<BioMightMethodView> methods) {
		this.methods = methods;
	}
	

}
