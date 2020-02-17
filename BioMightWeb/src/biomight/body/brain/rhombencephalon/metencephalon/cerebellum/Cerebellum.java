/*
 * Created on May 6, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.body.brain.rhombencephalon.metencephalon.cerebellum;

import biomight.BioMightBase;
import biomight.Constants;

import java.util.ArrayList;
import java.util.Collection;

import javax.naming.InitialContext;

import biomight.body.organ.Organ;
import biomight.ejb.BioMightBeanLocal;
import biomight.exceptions.DataSecurityException;
import biomight.exceptions.ServerException;
import biomight.system.tissue.epithelial.EpitheliumTissue;
import biomight.util.BioGraphics;
import biomight.view.BioMightMethodView;
import biomight.view.BioMightPosition;
import biomight.view.BioMightPropertyView;
import biomight.view.BioMightScale;
import biomight.view.BioMightTransform;
import biomight.view.BioMightTransforms;


/***************************************************************************************
 * @author SurferJim
 *
 * Representation of the Cerebellum
 * 
 ***************************************************************************************/

public class Cerebellum extends Organ {
	protected EpitheliumTissue epithelium;

	/*********************************************************************************
	 * CONSTRUCTORS
	 *
	 *********************************************************************************/
	
	public Cerebellum()
	{
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, Constants.CerebellumRef, null, null);
	}

	public Cerebellum(String parentID)
	{
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, parentID, null, null);
	}

	public Cerebellum(int hierarchy, int LOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
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
		this.setImage("images/Cerebellum.jpg");
		this.setImageWidth(300);
		this.setImageHeight(325);

		// Get the information from the database via the Enterprise Bean		
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Getting CerebellumInfo for ParentID: " + parentID);
			InitialContext ctx = new InitialContext();
			BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
			bioMightTransforms = bioMightBean.getComponents(Constants.CerebellumRef, parentID);
			System.out.println("Have Cerebellum Info from EJB");   	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - Cerebellum");
			throw new ServerException("Remote Exception getComponents():", e); 	
		}
		
		int localVP = Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
				
		// Run through the collection of Cerebellums and build them into the model
		// In the default case, we get one instance of the Cerebellum for each eye
		ArrayList transforms = bioMightTransforms.getTransforms();
		System.out.println("Cerebellum NumTransforms: " + transforms.size());
		for (int i=0; i<transforms.size(); i++)
		{			
			// Get the information for the Cerebellum we are creating
			BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
			System.out.println("Created Cerebellum: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
			this.componentID = bioMightTransform.getId();
			
			if (localVP == Constants.VIEW_HAWKEYE) {
				
				// Generate the Cerebellum Epihelium if needed 
				boolean bGenerate = false;
				if (bGenerate) {
					generate(parentID, componentID);
				}
			
				String startID = "CerebellumEpithelium:00001";
				System.out.println("HawkEye - Creating Cerebellum Epithelium: " + parentID + "  startID: " + startID);				
				epithelium = new EpitheliumTissue(localVP, localLOD, startID, "CerebellumEpithelium",  Constants.EpitheliumTissueRef, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
				initProperty("CerebellumEpithelium", Constants.EpitheliumTissue, Constants.EpitheliumTissueRef, bioMightTransform.getId());
						
				//paceMakerCells = new PaceMakerCells(parentID);				
				System.out.println("Cerebellum Instance is created : " + componentID + "    parent: " +  parentID);
			} 
			else if (localVP == Constants.VIEW_FLOATING) {
				
				
				/*
				System.out.println("Creating cerebellumLeftLateralLobe : " + bioMightTransform.getId());				
				cerebellumLeftLateralLobe = new CerebellumLeftLateralLobe(bioMightTransform.getId());
				initProperty(bioMightTransform.getName(), Constants.Hand, Constants.HandRef, bioMightTransform.getId());
		
				*/	
			}
				
		
		
		}
		System.out.println("Cerebellum - initProperties");
		initProperties();
		System.out.println("Cerebellum - initMethods");
		//initMethods();
		
		System.out.println("CreateCerebellum Completed");
		
		// First, get all the data from the database
		// Apply the methods to it
		// Save its state
		if (bioMightMethods != null){
			System.out.println("EXECUTING Cerebellum METHODS: " + bioMightMethods.size());
			//executeMethods(bioMightMethods);
		}
	}
	

	/************************************************************************************
	 * GENERATE BRAIN
	 * 
	 * @param parentID
	 * @param componentID
	 **********************************************************************************/
	
	public void generate(String parentID, String componentID)
	{
		// Generate the Cerebellum Edothelium		
		BioMightBeanLocal bioMightBean;
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Generating the Cerebellum: " + componentID + "    " + parentID);
			InitialContext ctx = new InitialContext();
			bioMightBean = (BioMightBeanLocal) ctx.lookup("java:global/BioMightWeb/BioMightBean!biomight.ejb.BioMightBeanLocal");
	
			double circumference = 0.0625;
		
			if (componentID.equals("Cerebellum:01")) 
			{	
				// Create 5 sections
				double[] startPos = {0.0, -2.25, -4.5};
				double[][] currentPoints = BioGraphics.octogonZPlane(startPos, circumference);

				System.out.println("Calling Generate Cerebellum: " + componentID + "    " + parentID);
				int success = bioMightBean.generateCerebellum("CerebellumEpithelium:00001", "CerebellumEpithelium", 
					"CerebellumEpithelium", componentID, parentID, currentPoints);									
		
			}			
			else if (parentID.equals("")) 
			{	
					
			}

			
			System.out.println("Created CerebellumEpithelium Info using EJB");   	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - CerebellumEpithelium");
			throw new ServerException("Remote Exception getComponents():", e); 	
		}
	}
	
	
	
	public void initProperties() {
	
		BioMightScale bioScale = new BioMightScale("0.00, 0.00, 0.00");
		BioMightPosition bioPos = new BioMightPosition("0.00, 0.00, 0.00");	
		String bioTemplate =""; 

		initProperty("---Not Activated---", Constants.Title, Constants.Title, "ParaThyroidGland:0", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		initProperty(Constants.RhombencephalonRef, Constants.Rhombencephalon, Constants.RhombencephalonRef, "Cerebellum:01", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		initProperty(Constants.MesencephalonRef, Constants.Mesencephalon, Constants.MesencephalonRef, "Cerebellum:01", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		initProperty(Constants.ProsencephalonRef, Constants.Prosencephalon, Constants.ProsencephalonRef, "Cerebellum:01", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
	}
	
	
	public void initMethods() {

		BioMightMethodView method = null;

		method = new BioMightMethodView();
		method.setMethodName("Secrete Bile");
		method.setHtmlType("checkbox");
		methods.add(method);	
		
		method = new BioMightMethodView();
		method.setMethodName("Fibrinogen");
		method.setHtmlType("text");
		methods.add(method);	


		method = new BioMightMethodView();
		method.setMethodName("Albumin");
		method.setHtmlType("text");
		methods.add(method);		
	}
		


	/********************************************************************************************************************
	 * GET X3D
	 * 
	 * This method will return the X3D for the Cerebellum.  It runs through each of its components and collects up their
	 * representations and then assembles them into one unified X3D model.
	 * 
	 ********************************************************************************************************************/
	public String getX3D(boolean snipet) {
		
		// Assemble the Chin
		String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
		"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n " +
		"<X3D profile='Immersive' >\n" +
		"<head>\n" +
		 "<meta name='BioMightImage' content='Cerebellum.jpg'/>\n" +
		 "<meta name='ExportTime' content='7:45:30'/>\n" +
		 "<meta name='ExportDate' content='08/15/2008'/>\n" +
		 "<meta name='BioMight Version' content='1.0'/>\n" + 
		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='Cerebellum'\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		

		
		String body = "";
		
		
		viewPerspective = Constants.VIEW_HAWKEYE;
		if (viewPerspective == Constants.VIEW_HAWKEYE) {
			System.out.println("Getting Cerebellum X3D - HawkEye");
			body = epithelium.getX3D(true); 
		}
		else {
			System.out.println("Getting Cerebellum X3D - HawkEye");
			body = ""; // + caudateLobe.getX3D(true) 	;  
				/*leftSagittalFossa.getX3D(true) + 
				duodenalImpression.getX3D(true) +
		 */

		}

		//System.out.println("Cerebellum X3D: " + body);		
		
		String footer = "</Scene>" + "</X3D>\n";
		
		if (snipet)
			return body;			
		else	
			return header + body + footer;
	}


	
}
