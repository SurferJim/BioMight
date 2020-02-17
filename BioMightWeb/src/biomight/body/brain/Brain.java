package biomight.body.brain;

import biomight.BioMightBase;
import biomight.Constants;

import java.util.ArrayList;
import java.util.Collection;

import javax.naming.InitialContext;

import biomight.body.brain.prosencephalon.*;
import biomight.body.brain.rhombencephalon.Rhombencephalon;
import biomight.body.brain.rhombencephalon.metencephalon.cerebellum.Cerebellum;
import biomight.body.brain.mesencephalon.*;
import biomight.body.organ.Organ;
import biomight.body.organ.stomach.GreaterCurvature;
import biomight.ejb.BioMightBeanLocal;
import biomight.exceptions.DataSecurityException;
import biomight.exceptions.ServerException;
import biomight.system.tissue.edothelial.EndotheliumTissue;
import biomight.system.tissue.epithelial.EpitheliumTissue;
import biomight.system.tissue.membranes.peritoneum.Peritoneum;
import biomight.system.tissue.membranes.peritoneum.VisceralPeritoneum;
import biomight.system.vascular.arteries.abdomen.CommonHepaticArtery;
import biomight.system.vascular.arteries.abdomen.ProperHepaticArtery;
import biomight.system.vascular.veins.EmbryonicUmbilicalVein;
import biomight.util.BioGraphics;
import biomight.view.BioMightGenerate;
import biomight.view.BioMightMethodView;
import biomight.view.BioMightPosition;
import biomight.view.BioMightPropertyView;
import biomight.view.BioMightScale;
import biomight.view.BioMightTransform;
import biomight.view.BioMightTransforms;


/***************************************************************************************
 * @author SurferJim
 *
 * Representation of the Brain
 * 
 ***************************************************************************************/

public class Brain extends Organ {
	protected EpitheliumTissue epithelium;
	private ArrayList<BioMightPropertyView> properties;
	private ArrayList<BioMightMethodView> methods;
	private Rhombencephalon rhombencephalon;
	private Mesencephalon mesencephalon;
	private Prosencephalon prosencephalon;
	private Cerebrums cerebrums;
	
	/*********************************************************************************
	 * CONSTRUCTORS
	 *
	 *********************************************************************************/
	
	public Brain()
	{
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, Constants.BrainRef, null, null);
	}

	public Brain(String parentID)
	{
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, parentID, null, null);
	}

	public Brain(int hierarchy, int LOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
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
		this.setImage("images/Brain.jpg");
		this.setImageWidth(300);
		this.setImageHeight(325);

		// Get the information from the database via the Enterprise Bean		
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Getting BrainInfo for ParentID: " + parentID);
			InitialContext ctx = new InitialContext();
			BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
			bioMightTransforms = bioMightBean.getComponents(Constants.BrainRef, parentID);
			System.out.println("Have Brain Info from EJB");   	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - Brain");
			throw new ServerException("Remote Exception getComponents():", e); 	
		}
		
		int localVP = Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
				

		BioMightScale bioScale = new BioMightScale("0.00, 0.00, 0.00");
		BioMightPosition  bioPos = new BioMightPosition("0.00, 0.00, 0.00");
		String bioTemplate="Head.x3d";
		boolean bStored = false;

		// Run through the collection of Brains and build them into the model
		// In the default case, we get one instance of the Brain for each eye
		ArrayList transforms = bioMightTransforms.getTransforms();
		System.out.println("Brain NumTransforms: " + transforms.size());
		for (int i=0; i<transforms.size(); i++)
		{			
			// Get the information for the Brain we are creating
			BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
			System.out.println("Created Brain: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
			this.componentID = bioMightTransform.getId();
			
			if (localVP == Constants.VIEW_HAWKEYE) {
				
				// Generate the Brain Epihelium if needed 
				boolean bGenerate = false;
				if (bGenerate) {
					generate(parentID, componentID);
				}
			
				System.out.println("Creating the Cerebrums for ParentID: " + bioMightTransform.getId());
				cerebrums = new Cerebrums(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);	
				BioMightGenerate generatedCerebrums = cerebrums.getBioMightGenerate(); 
				initProperty(Constants.CerebrumsRef, Constants.Cerebrums, Constants.CerebrumsRef, cerebrums.getComponentID(), bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, true);								
				System.out.println("Created the Cerebrums");
	
				//String startID = "BrainEpithelium:00001";
				//System.out.println("HawkEye - Creating Brain Epithelium: " + parentID + "  startID: " + startID);				
				//epithelium = new EpitheliumTissue(localVP, localLOD, startID, "BrainEpithelium",  Constants.EpitheliumTissueRef, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
				//initProperty("BrainEpithelium", Constants.EpitheliumTissue, Constants.EpitheliumTissueRef, bioMightTransform.getId());
						
				//paceMakerCells = new PaceMakerCells(parentID);				
				System.out.println("Brain Instance is created : " + componentID + "    parent: " +  parentID);
			} 
			else if (localVP == Constants.VIEW_FLOATING) {
				
				
				/*
				System.out.println("Creating brainLeftLateralLobe : " + bioMightTransform.getId());				
				brainLeftLateralLobe = new BrainLeftLateralLobe(bioMightTransform.getId());
				initProperty(bioMightTransform.getName(), Constants.Hand, Constants.HandRef, bioMightTransform.getId());
		
				*/	
			}
				
		
		
		}
		System.out.println("Brain - initProperties");
		initProperties();
		System.out.println("Brain - initMethods");
		//initMethods();
		
		System.out.println("CreateBrain Completed");
		
		// First, get all the data from the database
		// Apply the methods to it
		// Save its state
		if (bioMightMethods != null){
			System.out.println("EXECUTING Brain METHODS: " + bioMightMethods.size());
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
		// Generate the Brain Edothelium		
		BioMightBeanLocal bioMightBean;
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Generating the Brain: " + componentID + "    " + parentID);
			InitialContext ctx = new InitialContext();
			bioMightBean = (BioMightBeanLocal) ctx.lookup("java:global/BioMightWeb/BioMightBean!biomight.ejb.BioMightBeanLocal");
	
			double circumference = 0.01;
		
			if (componentID.equals("Brain:01")) 
			{	
				// Create 5 sections
				double[] startPos = {0.0, 1.30, -0.350};
				double[][] currentPoints = BioGraphics.octogonZPlane(startPos, circumference);

				System.out.println("Calling Generate Brain: " + componentID + "    " + parentID);
				int success = bioMightBean.generateBrain("BrainEpithelium:00001", "BrainEpithelium", 
					"BrainEpithelium", componentID, parentID, currentPoints);									
		
			}			
	
			
			else if (parentID.equals("")) 
			{	
					
			}

			
			System.out.println("Created BrainEpithelium Info using EJB");   	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - BrainEpithelium");
			throw new ServerException("Remote Exception getComponents():", e); 	
		}
	}
	
	
	
	public void initProperties() {
	
		BioMightScale bioScale = new BioMightScale("0.00, 0.00, 0.00");
		BioMightPosition bioPos = new BioMightPosition("0.00, 0.00, 0.00");	
		String bioTemplate =""; 

		initProperty("---Not Activated---", Constants.Title, Constants.Title, "ParaThyroidGland:0", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		initProperty(Constants.RhombencephalonRef, Constants.Rhombencephalon, Constants.RhombencephalonRef, "Brain:01", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		initProperty(Constants.MesencephalonRef, Constants.Mesencephalon, Constants.MesencephalonRef, "Brain:01", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		initProperty(Constants.ProsencephalonRef, Constants.Prosencephalon, Constants.ProsencephalonRef, "Brain:01", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
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
	 * This method will return the X3D for the Brain.  It runs through each of its components and collects up their
	 * representations and then assembles them into one unified X3D model.
	 * 
	 ********************************************************************************************************************/
	public String getX3D(boolean snipet) {
		
		String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
		"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n " +
		"<X3D profile='Immersive' >\n" +
		"<head>\n" +
		 "<meta name='BioMightImage' content='Brain.jpg'/>\n" +
		 "<meta name='ExportTime' content='7:45:30'/>\n" +
		 "<meta name='ExportDate' content='08/15/2008'/>\n" +
		 "<meta name='BioMight Version' content='1.0'/>\n" + 
		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='Brain'\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		

		
		String body = "";
		
		
		viewPerspective = Constants.VIEW_HAWKEYE;
		if (viewPerspective == Constants.VIEW_HAWKEYE) {
			System.out.println("Getting Brain X3D - HawkEye");
			//body = epithelium.getX3D(true);
			
			body = cerebrums.getX3D(true);
			
			
		}
		else {
			System.out.println("Getting Brain X3D - HawkEye");
			body = ""; // + caudateLobe.getX3D(true) 	;  
				/*leftSagittalFossa.getX3D(true) + 
				duodenalImpression.getX3D(true) +
		 */

		}

		//System.out.println("Brain X3D: " + body);		
		
		String footer = "</Scene>" + "</X3D>\n";
		
		if (snipet)
			return body;			
		else	
			return header + body + footer;
	}


	
}
