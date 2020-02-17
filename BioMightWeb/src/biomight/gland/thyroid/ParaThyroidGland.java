/*
 * Created on Oct 15, 2004
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.body.gland.thyroid;

import java.util.ArrayList;
import java.util.Collection;

import javax.naming.InitialContext;

import biomight.BioMightBase;
import biomight.Constants;
import biomight.system.tissue.edothelial.EndotheliumTissue;
import biomight.system.tissue.epithelial.EpitheliumTissue;
import biomight.system.vascular.arteries.*;
import biomight.system.vascular.arteries.abdomen.*;
import biomight.system.vascular.arteries.pelvis.*;
import biomight.system.vascular.veins.*;
import biomight.system.vascular.veins.abdomen.*;
import biomight.util.BioGraphics;
import biomight.view.BioMightMethodView;
import biomight.view.BioMightPosition;
import biomight.view.BioMightPropertyView;
import biomight.view.BioMightScale;
import biomight.view.BioMightTransform;
import biomight.body.organ.Organ;
import biomight.chemistry.elements.Carbons;
import biomight.ejb.BioMightBeanLocal;
import biomight.exceptions.ServerException;

/***********************************************************************************
* @author SurferJim
*
* Representation of a ParaThyroidGland
* 
***********************************************************************************/

public class ParaThyroidGland extends BioMightBase {
	protected EpitheliumTissue epithelium;
	private BioMightTransform gbioMightTransform; 

	
	public ParaThyroidGland()
	{
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, Constants.ParaThyroidGlandRef, null, null);
	}

	public ParaThyroidGland(String parentID)
	{
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, parentID, null, null);
	}

	public ParaThyroidGland(int hierarchy, int LOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
	{
		create(hierarchy, LOD, parentID, bioMightProperties, bioMightMethods);
	}

	
	/************************************************************************************
	 * 
	 * CREATE PARA THYROID GLAND
	 * 
	 ***********************************************************************************/
	
	public void create(int localVP, int localLOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
	{
		this.setImage("images/ParaThyroidGland.jpg");
		this.setImageHeight(300);
		this.setImageWidth(300);
		this.parentID = parentID;
		this.componentID = parentID;
		this.lod = localLOD;
		this.viewPerspective = localVP;
		
		System.out.println("Creating ParaThyroidGland for: " + parentID);
		componentID = parentID;

		
		BioMightScale bioScale = new BioMightScale("0.00, 0.00, 0.00");
		BioMightPosition  bioPos = new BioMightPosition("0.00, 0.00, 0.00");
		String bioTemplate="Enymes.x3d";
		
		if (localVP == Constants.VIEW_INTERNAL)	
		{
			// Do nothing.  We are instantiating as part of a collection  
			// There is no drill down, so we use the transforms that the
			// parent has already collected
			System.out.println("In ParaThyroidGland Create() - ViewInternal - Already Set: " + parentID);				

			// Do the Epithelial layer
			localLOD = Constants.MAG2X;
			
			// We already have the data for the current instance of ParaThyroidGland,
			// Go get the details for the current ParaThyroidGland is LOD is set
			if (localLOD == Constants.MAG2X)
			{
				// Go get the finer details of the ParaThyroidGland				
				System.out.println("Getting the ParaThyroidGland MAG2X : " + parentID);
				localVP = Constants.VIEW_INTERNAL; 
				localLOD = Constants.MAG1X;		
			
				// If we have initialization parameters from the form, 
				//  then apply them before constructing the objects.
				if (bioMightMethods != null){
					//System.out.println("NEED TO EXECUTE Calyx METHODS: " + bioMightMethods.size());
				}
				
				// Generate the ParaThyroidGland Epihelium if needed 
				boolean bGenerate = false;
				if (bGenerate) {
					generate(parentID, componentID);
				}
			
				System.out.println("Retrieving ParaThyroidGland Epithelium: " + parentID);				
				epithelium = new EpitheliumTissue("ParaThyroidGlandEpithelium", parentID, bioMightMethods);					
				initProperty(Constants.EpitheliumTissueRef, Constants.EpitheliumTissue, Constants.EpitheliumTissueRef, epithelium.getComponentID(), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);

				/*	
			    calyces = new Calyces(parentID, bioMightMethods);
				System.out.println("ParaThyroidGland Calxes created: " + parentID);
				renalArtery = new RenalArtery(parentID, bioMightMethods);
				System.out.println("RenalArtery completed for ParaThyroidGland: " + parentID);
				 */
			}
			
			//paceMakerCells = new PaceMakerCells(parentID);				
			System.out.println("ParaThyroidGland Instance is created : " + parentID);
		} 
		else if (localVP == Constants.VIEW_HAWKEYE)
		{
			
			//***************************************************************
			//***************************************************************
			// ON the drill down go into the detail for now on a single cell
			// HACK
			localLOD = Constants.MAG1X;
			//***************************************************************
			//***************************************************************
		
			// This is when one is accessing a ParaThyroidGland directly
			// Get the information from the database via the Enterprise Bean		
			try {
				// Get the information from the database via the Enterprise Bean		
				System.out.println("Getting HawkEye ParaThyroidGlandInfo for ParentID: " + parentID);
				InitialContext ctx = new InitialContext();
				BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
				bioMightTransforms = bioMightBean.getComponent(parentID);
				
				System.out.println("Have ParaThyroidGland Info from EJB");   	
			}catch (Exception e) { 
				System.out.println("Exception Getting Components - ParaThyroidGland");
				throw new ServerException("Remote Exception getComponents():", e); 	
			}
				
			// Run through the collection of BacilliAnthracis and build them into the model
			// In the default case, we get one instance of the ParaThyroidGland for each eye
			ArrayList transforms = bioMightTransforms.getTransforms();
			System.out.println("ParaThyroidGland NumTransforms: " + transforms.size());
			for (int i=0; i<transforms.size(); i++)
			{
				// Get the information for the ParaThyroidGland
				BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
			
				// A hack, I am using the values down below in the X3D method to set some appearance  and material values
				gbioMightTransform  = bioMightTransform;
			
				System.out.println("Creating ParaThyroidGland: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
				this.componentID = bioMightTransform.getId();

		
				localLOD = Constants.MAG2X;
				if (localLOD == Constants.MAG1X)
				{
					System.out.println("Creating ParaThyroidGland at HawkEye MAG1X - Just Init Properties: " + parentID);
					// initialize the Properties
					initProperties();
				}
				if (localLOD == Constants.MAG2X)
				{
					// Go get the finer details of the ParaThyroidGland				
					System.out.println("Creating ParaThyroidGland at HawkEye MAG2X : " + parentID);
					localVP = Constants.VIEW_INTERNAL; 
					localLOD = Constants.MAG1X;

					// Do the Epithelial layer
					localLOD = Constants.MAG2X;
			
					System.out.println("Retrieving ParaThyroidGland Epithelium: " + parentID);	
					epithelium = new EpitheliumTissue("ParaThyroidGlandEpithelium", parentID, bioMightMethods);
					initProperty(Constants.EpitheliumTissueRef, Constants.EpitheliumTissue, Constants.EpitheliumTissueRef, epithelium.getComponentID(), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		
					//System.out.println("Creating ParaThyroidGland HawkEye - 2X : " + parentID);
					//carbons = new Carbons(localVP, localLOD, componentID, bioMightProperties, bioMightMethods);
					//initProperty(Constants.CarbonsRef, Constants.Carbons, Constants.CarbonsRef, carbons.getComponentID());
					//System.out.println("In ParaThyroidGland - CarbonsRef is complete");

					/*	
				    calyces = new Calyces(parentID, bioMightMethods);
					System.out.println("ParaThyroidGland Calxes created: " + parentID);
					renalArtery = new RenalArtery(parentID, bioMightMethods);
					System.out.println("RenalArtery completed for ParaThyroidGland: " + parentID);

					*/				}
				
			}
		}		
		else 
		{
	
		}

		
	initMethods();
	initProperties();
	
	System.out.println("CreateParaThyroidGland Completed");
	
	// First, get all the data from the database
	// Apply the methods to it
	// Save its state
	this.parentID = parentID;
	if (bioMightMethods != null){
		System.out.println("EXECUTING ParaThyroidGland Methods: " + bioMightMethods.size());
		//executeMethods(bioMightMethods);
	}

	}

	

	
	public void initProperties() {
	
		BioMightScale bioScale = new BioMightScale("0.00, 0.00, 0.00");
		BioMightPosition bioPos = new BioMightPosition("0.00, 0.00, 0.00");	
		String bioTemplate =""; 

		initProperty("Not Available", Constants.Title, Constants.Title, "ParaThyroidGland:0", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		//initProperty(Constants.ParaThyroidMedullaRef, Constants.ParaThyroidMedulla, Constants.ParaThyroidMedullaRef, "ParaThyroidGland:0", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
	}
		
	
	public void initMethods() {

	
		BioMightMethodView method;
		
		method = new BioMightMethodView();
		method.setMethodName("Filtration");
		method.setHtmlType("text");
		methods.add(method);
	}

	
	
	
	/****************************************************
	 * GENERATE ParaThyroidGland
	 * 
	 * 
	 * @param parentID
	 * @param componentID
	 ***************************************************/
	public void generate(String parentID, String componentID)
	{
		// Generate the ParaThyroidGland		
		BioMightBeanLocal bioMightBean;
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Generating the ParaThyroidGland Epithelium: " + componentID + "    " + parentID);
			InitialContext ctx = new InitialContext();
			bioMightBean = (BioMightBeanLocal) ctx.lookup("java:global/BioMightWeb/BioMightBean!biomight.ejb.BioMightBeanLocal");
	
		
			double circumference = 0.0825;
			
			if (componentID.equals("ParaThyroidGland:01")) {
				
				// Generate the Palm
				double[] startPos = {0.75, -6.50, -3.50};
				
				// Create a equilateral octogon
	    		double x =  startPos[0];
	    		double y =  startPos[1];
	    		double z =  startPos[2];
	
	    		double[][] currentPoints = BioGraphics.octogonYPlane(startPos, circumference);
					
				int success = bioMightBean.generateParaThyroidGland("ParaThyroidGlandEpithelium:00001", "ParaThyroidGlandEpithelium", 
						"ParaThyroidGlandEpithelium", componentID, parentID, currentPoints);			
			}
			else if (componentID.equals("ParaThyroidGland:02"))
			{
				// Generate the Elbow
				double[] startPos = {-0.75, -6.50, -3.50};
				
				// Create a equilateral octogon
	    		double x =  startPos[0];
	    		double y =  startPos[1];
	    		double z =  startPos[2];
	    		 
	     		double[][] currentPoints = BioGraphics.octogonYPlane(startPos, circumference);
	    		
				int success = bioMightBean.generateParaThyroidGland("ParaThyroidGlandEpithelium:00160", "ParaThyroidGlandEpithelium", 
					"ParaThyroidGlandEpithelium", componentID, parentID, currentPoints);
				
			}
			else if (parentID.equals("")) 
			{	
				System.out.println("Calling Generate ParaThyroidGlandEpithelium NoParent");		
			}

			
			System.out.println("Created ParaThyroidGlandEpithelium Info using EJB");   	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - ParaThyroidGlandEpithelium");
			throw new ServerException("Remote Exception ParaThyroidGlandEpithelium():", e); 	
		}
	}
	
	
	/********************************************************************************************************************
	 * GET X3D
	 * 
	 * This method will return the X3D for the Cell.  It runs through each of its components and collects up their
	 * representations and then assembles them into one unified X3D model.
	 * 
	 ********************************************************************************************************************/
	public String getX3D(boolean snipet) {
		
		// Assembe the ParaThyroidGland
		String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
		"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n " +
		"<X3D profile='Immersive' >\n" +
		"<head>\n" +
		 "<meta name='BioMightImage' content='ParaThyroidGland.jpg'/>\n" +
		 "<meta name='ExportTime' content='7:45:30'/>\n" +
		 "<meta name='ExportDate' content='08/15/2008'/>\n" +
		 "<meta name='BioMight Version' content='1.0'/>\n" + 
		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='ParaThyroidGland'\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		

	
		String body ="";
		System.out.println("Getting ParaThyroidGland X3D");
		viewPerspective = Constants.VIEW_DETACHED;
		if (viewPerspective == Constants.VIEW_DETACHED) {
			System.out.println("Getting ParaThyroidGland Epithelium X3D");
			body = epithelium.getX3D(true); 
		}
		else {
			body = ""; //calyces.getX3D(true); 
				//renalArtery.getX3D(true) +
		
		}
		
		
		//System.out.println("ParaThyroidGland X3D: " + body);		
		
		String footer = "</Scene>" + "</X3D>\n";
		if (snipet)
			return body;			
		else	
			return header + body + footer;
	}

	
}





	
	
	
	