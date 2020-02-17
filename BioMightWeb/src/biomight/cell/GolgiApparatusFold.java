/*
 * Created on Oct 15, 2004
 *
 * 
 */
 
package biomight.cell;
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
import biomight.view.BioMightPropertyView;
import biomight.view.BioMightTransform;
import biomight.body.organ.Organ;
import biomight.chemistry.elements.Carbons;
import biomight.ejb.BioMightBeanLocal;
import biomight.ejb.BioMightCellularBeanLocal;
import biomight.exceptions.ServerException;

/**
 * @author SurferJim
 *
 * Representation of a GolgiApparatusFold
 * 
 */

public class GolgiApparatusFold extends BioMightBase {
	BioMightTransform gbioMightTransform; 
	protected EpitheliumTissue epithelium;
	
	
	public GolgiApparatusFold()
	{
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, Constants.GolgiApparatusFoldRef, null, null);
	}

	public GolgiApparatusFold(String parentID)
	{
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, parentID, null, null);
	}

	public GolgiApparatusFold(int hierarchy, int LOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
	{
		create(hierarchy, LOD, parentID, bioMightProperties, bioMightMethods);
	}

	
	/************************************************************************************
	 * 
	 * CREATE GolgiApparatusFold
	 * 
	 ***********************************************************************************/
	
	public void create(int localVP, int localLOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
	{
		this.setImage("images/GolgiApparatusFold.jpg");
		this.setImageHeight(300);
		this.setImageWidth(300);
		this.parentID = parentID;
		this.componentID = parentID;
		this.lod = localLOD;
		this.viewPerspective = localVP;
		
		System.out.println("Creating GolgiApparatusFold for: " + parentID);
		componentID = parentID;

		if (localVP == Constants.VIEW_INTERNAL)	
		{
			// Do nothing.  We are instantiating as part of a collection  
			// There is no drill down, so we use the transforms that the
			// parent has already collected
			System.out.println("In GolgiApparatusFold Create() - ViewInternal - Already Set: " + parentID);				

			// Do the Epithelial layer
			localLOD = Constants.MAG2X;
			
			// We already have the data for the current instance of GolgiApparatusFold,
			// Go get the details for the current GolgiApparatusFold is LOD is set
			if (localLOD == Constants.MAG2X)
			{
				// Go get the finer details of the GolgiApparatusFold				
				System.out.println("Getting the GolgiApparatusFold MAG2X : " + parentID);
				localVP = Constants.VIEW_INTERNAL; 
				localLOD = Constants.MAG1X;		
			
				// If we have initialization parameters from the form, 
				//  then apply them before constructing the objects.
				if (bioMightMethods != null){
					//System.out.println("NEED TO EXECUTE Calyx METHODS: " + bioMightMethods.size());
				}
				
				// Generate the GolgiApparatusFold Epihelium if needed 
				boolean bGenerate = false;
				if (bGenerate) {
					generate(parentID, componentID);
				}
			
				System.out.println("Retrieving GolgiApparatusFold Epithelium: " + parentID);				
				epithelium = new EpitheliumTissue("GolgiApparatusFoldEpithelium", parentID, bioMightMethods);
				
				//System.out.println("Creating GolgiApparatusFold MAG ViewInternal - 2X : " + parentID);
				//carbons = new Carbons(localVP, localLOD, componentID, bioMightProperties, bioMightMethods);
				//initProperty(Constants.CarbonsRef, Constants.Carbons, Constants.CarbonsRef, carbons.getComponentID());
				//System.out.println("In GolgiApparatusFold - CarbonsRef is complete");
			}
			
			//paceMakerCells = new PaceMakerCells(parentID);				
			System.out.println("GolgiApparatusFold Instance is created : " + parentID);
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
		
			// This is when one is accessing a GolgiApparatusFold directly
			// Get the information from the database via the Enterprise Bean		
			try {
				// Get the information from the database via the Enterprise Bean		
				System.out.println("Getting HawkEye GolgiApparatusFoldInfo for ParentID: " + parentID);
				InitialContext ctx = new InitialContext();
				BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
				bioMightTransforms = bioMightBean.getComponent(parentID);
				
				System.out.println("Have GolgiApparatusFold Info from EJB");   	
			}catch (Exception e) { 
				System.out.println("Exception Getting Components - GolgiApparatusFold");
				throw new ServerException("Remote Exception getComponents():", e); 	
			}
				
			// Run through the collection of BacilliAnthracis and build them into the model
			// In the default case, we get one instance of the GolgiApparatusFold for each eye
			ArrayList transforms = bioMightTransforms.getTransforms();
			System.out.println("GolgiApparatusFold NumTransforms: " + transforms.size());
			for (int i=0; i<transforms.size(); i++)
			{
				// Get the information for the GolgiApparatusFold
				BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
			
				// A hack, I am using the values down below in the X3D method to set some appearance  and material values
				gbioMightTransform  = bioMightTransform;
			
				System.out.println("Creating GolgiApparatusFold: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
				this.componentID = bioMightTransform.getId();

		
				if (localLOD == Constants.MAG1X)
				{
					System.out.println("Creating GolgiApparatusFold at HawkEye MAG1X - Just Init Properties: " + parentID);
					// initialize the Properties
					initProperties();
				}
				if (localLOD == Constants.MAG2X)
				{
					// Go get the finer details of the GolgiApparatusFold				
					System.out.println("Creating GolgiApparatusFold at HawkEye MAG2X : " + parentID);
					localVP = Constants.VIEW_INTERNAL; 
					localLOD = Constants.MAG1X;

					// Do the Epithelial layer
					localLOD = Constants.MAG2X;
			
					System.out.println("Retrieving GolgiApparatusFold Epithelium: " + parentID);	
					epithelium = new EpitheliumTissue("GolgiApparatusFoldEpithelium", parentID, bioMightMethods);

					//System.out.println("Creating GolgiApparatusFold HawkEye - 2X : " + parentID);
					//carbons = new Carbons(localVP, localLOD, componentID, bioMightProperties, bioMightMethods);
					//initProperty(Constants.CarbonsRef, Constants.Carbons, Constants.CarbonsRef, carbons.getComponentID());
					//System.out.println("In GolgiApparatusFold - CarbonsRef is complete");

				}
				
			}
		}		
		else 
		{
	
		}

		
	initMethods();
	
	System.out.println("CreateGolgiApparatusFold Completed");
	
	// First, get all the data from the database
	// Apply the methods to it
	// Save its state
	this.parentID = parentID;
	if (bioMightMethods != null){
		System.out.println("EXECUTING GolgiApparatusFold Methods: " + bioMightMethods.size());
		//executeMethods(bioMightMethods);
	}

	}

	
	

	/*******************************************************************
	 * Generate the GolgiApparatusFold
	 * 
	 * @param parentID
	 * @param componentID
	 ****************************************************************/
	
	public void generate(String parentID, String componentID)
	{
		// Generate the SpleenEpithelium		
		BioMightCellularBeanLocal bioMightBean;
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Generating the GolgiApparatus: " + componentID + "    " + parentID);
			
			InitialContext ctx = new InitialContext();
			bioMightBean = (BioMightCellularBeanLocal) ctx.lookup("java:global/BioMightWeb/BioMightCellularBean!biomight.ejb.BioMightCellularBeanLocal");
			
			double[] startPos = {0.0, 0.75, 0.0};
	 		double radius = 0.0025;
	 		double[][] currentPoints = BioGraphics.createHalfPipeInPlane(Constants.XPLANE, startPos, radius, 8);
	 		
			System.out.println("Calling Generate GolgiApparatus: " + componentID + "    " + parentID);
				
			int success = bioMightBean.generateGolgiApparatus("GolgiApparatusEpithelium:00001", "GolgiApparatusEpithelium", 
				"GolgiApparatusEpithelium", componentID, parentID, radius, startPos);			
			
			System.out.println("Created GolgiApparatus Info using EJB");
			
		}catch (Exception e) { 
			System.out.println("Exception Generate GolgiApparatus");
			throw new ServerException("Remote Exception generateGolgiApparatus():", e); 	
		}
	}

	
	public void initProperties() {
	
		BioMightPropertyView property = new BioMightPropertyView();
		property.setPropertyName("Fold");
		property.setCanonicalName(Constants.GolgiApparatusFold);
		properties.add(property);
	}
		
	
	public void initMethods() {

	
		BioMightMethodView method;
		
		method = new BioMightMethodView();
		method.setMethodName("Filtration");
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
		
		// Assembe the GolgiApparatusFold
		String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
		"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n " +
		"<X3D profile='Immersive' >\n" +
		"<head>\n" +
		 "<meta name='BioMightImage' content='GolgiApparatusFold.jpg'/>\n" +
		 "<meta name='ExportTime' content='7:45:30'/>\n" +
		 "<meta name='ExportDate' content='08/15/2008'/>\n" +
		 "<meta name='BioMight Version' content='1.0'/>\n" + 
		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='GolgiApparatusFold'\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		

	
		String body ="";
		System.out.println("Getting GolgiApparatusFold X3D");
		viewPerspective = Constants.VIEW_DETACHED;
		if (viewPerspective == Constants.VIEW_DETACHED) {
			System.out.println("Getting GolgiApparatusFold Epithelium X3D");
			body = epithelium.getX3D(true); 
		}
		else {
			body = epithelium.getX3D(true); /* +
				renalArtery.getX3D(true) +
				renalVein.getX3D(true) +
				renalFibrousCapsule.getX3D(true) +
				renalSinus.getX3D(true) +
				renalPelvis.getX3D(true) +
				renalPapilla.getX3D(true) +
				kidneyVisceralEpithelium.getX3D(true) +
				maculaDensa.getX3D(true);*/
		}
		
		
		//System.out.println("GolgiApparatusFold X3D: " + body);		
		
		String footer = "</Scene>" + "</X3D>\n";
		if (snipet)
			return body;			
		else	
			return header + body + footer;
	}

	
	
}
