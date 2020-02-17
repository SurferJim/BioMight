/*
 * Created on Oct 15, 2004
 *
 *  Each kidney is about 11.25 cm. in length, 5 to 7.5 cm. in breadth, 
 * and rather more than 2.5 cm. in thickness. The left is somewhat longer, and 
 * narrower, than the right. The weight of the kidney in the adult male varies 
 * from 125 to 170 gm., in the adult female from 115 to 155 gm. The combined weight 
 * of the two kidneys in proportion to that of the body is about 1 to 240.
 * 
 */
 
package biomight.body.organ.pancreas;
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
import biomight.exceptions.ServerException;

/**
 * @author SurferJim
 *
 * Representation of a PancreaticDuct
 * 
 */

public class PancreaticDuct extends BioMightBase {
	private BioMightTransform gbioMightTransform; 
	private EpitheliumTissue epithelium;
	
	
	public PancreaticDuct()
	{
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, Constants.PancreaticDuctRef, null, null);
	}

	public PancreaticDuct(String parentID)
	{
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, parentID, null, null);
	}

	public PancreaticDuct(int hierarchy, int LOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
	{
		create(hierarchy, LOD, parentID, bioMightProperties, bioMightMethods);
	}

	
	/************************************************************************************
	 * 
	 * CREATE PANCREATIC DUCT
	 * 
	 ***********************************************************************************/
	
	public void create(int localVP, int localLOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
	{
		this.setImage("images/PancreaticDuct.jpg");
		this.setImageHeight(300);
		this.setImageWidth(300);
		this.parentID = parentID;
		this.componentID = parentID;
		this.lod = localLOD;
		this.viewPerspective = localVP;
		
		System.out.println("Creating PancreaticDuct for: " + parentID);
		componentID = parentID;

		if (localVP == Constants.VIEW_INTERNAL)	
		{
			// Do nothing.  We are instantiating as part of a collection  
			// There is no drill down, so we use the transforms that the
			// parent has already collected
			System.out.println("In PancreaticDuct Create() - ViewInternal - Already Set: " + parentID);				

			// Do the Epithelial layer
			localLOD = Constants.MAG2X;
			
			// We already have the data for the current instance of PancreaticDuct,
			// Go get the details for the current PancreaticDuct is LOD is set
			if (localLOD == Constants.MAG2X)
			{
				// Go get the finer details of the PancreaticDuct				
				System.out.println("Getting the PancreaticDuct MAG2X : " + parentID);
				localVP = Constants.VIEW_INTERNAL; 
				localLOD = Constants.MAG1X;		
			
				// If we have initialization parameters from the form, 
				//  then apply them before constructing the objects.
				if (bioMightMethods != null){
					//System.out.println("NEED TO EXECUTE Calyx METHODS: " + bioMightMethods.size());
				}
				
				// Generate the PancreaticDuct Epihelium if needed 
				boolean bGenerate = false;
				if (bGenerate) {
					generate(parentID, componentID);
				}
			
				System.out.println("Retrieving PancreaticDuct Epithelium: " + parentID);				
				epithelium = new EpitheliumTissue("PancreaticDuctEpithelium", parentID, bioMightMethods);

			}
			
			//paceMakerCells = new PaceMakerCells(parentID);				
			System.out.println("PancreaticDuct Instance is created : " + parentID);
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
		
			// This is when one is accessing a PancreaticDuct directly
			// Get the information from the database via the Enterprise Bean		
			try {
				// Get the information from the database via the Enterprise Bean		
				System.out.println("Getting HawkEye PancreaticDuctInfo for ParentID: " + parentID);
				InitialContext ctx = new InitialContext();
				BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
				bioMightTransforms = bioMightBean.getComponent(parentID);
				
				System.out.println("Have PancreaticDuct Info from EJB");   	
			}catch (Exception e) { 
				System.out.println("Exception Getting Components - PancreaticDuct");
				throw new ServerException("Remote Exception getComponents():", e); 	
			}
				
			// Run through the collection of BacilliAnthracis and build them into the model
			// In the default case, we get one instance of the PancreaticDuct for each eye
			ArrayList transforms = bioMightTransforms.getTransforms();
			System.out.println("PancreaticDuct NumTransforms: " + transforms.size());
			for (int i=0; i<transforms.size(); i++)
			{
				// Get the information for the PancreaticDuct
				BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
			
				// A hack, I am using the values down below in the X3D method to set some appearance  and material values
				gbioMightTransform  = bioMightTransform;
			
				System.out.println("Creating PancreaticDuct: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
				this.componentID = bioMightTransform.getId();

		
				if (localLOD == Constants.MAG1X)
				{
					System.out.println("Creating PancreaticDuct at HawkEye MAG1X - Just Init Properties: " + parentID);
					// initialize the Properties
					initProperties();
				}
				if (localLOD == Constants.MAG2X)
				{
					// Go get the finer details of the PancreaticDuct				
					System.out.println("Creating PancreaticDuct at HawkEye MAG2X : " + parentID);
					localVP = Constants.VIEW_INTERNAL; 
					localLOD = Constants.MAG1X;

					// Do the Epithelial layer
					localLOD = Constants.MAG2X;
			
					System.out.println("Retrieving PancreaticDuct Epithelium: " + parentID);	
					epithelium = new EpitheliumTissue("PancreaticDuctEpithelium", parentID, bioMightMethods);

				}
				
			}
		}		
		else 
		{
	
		}

		
	initMethods();
	
	System.out.println("CreatePancreaticDuct Completed");
	
	// First, get all the data from the database
	// Apply the methods to it
	// Save its state
	this.parentID = parentID;
	if (bioMightMethods != null){
		System.out.println("EXECUTING PancreaticDuct Methods: " + bioMightMethods.size());
		//executeMethods(bioMightMethods);
	}

	}

	
	
	/****************************************************
	 * GENERATE KIDNEY
	 * 
	 * 
	 * @param parentID
	 * @param componentID
	 ***************************************************/
	public void generate(String parentID, String componentID)
	{
		// Generate the PancreaticDuct		
		BioMightBeanLocal bioMightBean;
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Generating the PancreaticDuct Epithelium: " + componentID + "    " + parentID);
			InitialContext ctx = new InitialContext();
			bioMightBean = (BioMightBeanLocal) ctx.lookup("java:global/BioMightWeb/BioMightBean!biomight.ejb.BioMightBeanLocal");
	
		
			double radius = 0.070;
			
			if (componentID.equals("PancreaticDuct:01")) {
				
				// Generate the PancreaticDuct
				double[] startPos = {-3.50, -24.1, -4.85};
				double[] orient = {0.0, 0.0, 0.05};
				double[][] currentPoints = BioGraphics.createCylinderInPlane(Constants.XPLANE, startPos, radius, 8);
				
				int success = bioMightBean.generatePancreaticDuct("PancreaticDuctEpithelium:00001", "PancreaticDuctEpithelium", 
					"PancreaticDuctEpithelium", componentID, parentID, currentPoints);			
						
			}
			else if (componentID.equals("PancreaticDuct:02")) {
				
				// Generate the PancreaticDuct
				radius = 0.060;
				double[] startPos = {-0.25, -19.05, -3.00};
				double[][] currentPoints = BioGraphics.createCylinderInPlane(Constants.YPLANE, startPos, radius, 8);
					
				int success = bioMightBean.generatePancreaticDuct("PancreaticDuctEpithelium:00240", "PancreaticDuctEpithelium", 
						"PancreaticDuctEpithelium", componentID, parentID, currentPoints);			
			}
			else if (componentID.equals("PancreaticDuct:03")) {
				
				// Generate the PancreaticDuct
				radius = 0.060;
				double[] startPos = {0.0, -18.96, -2.94};
				double[][] currentPoints = BioGraphics.createCylinderInPlane(Constants.XPLANE, startPos, radius, 8);
					
				int success = bioMightBean.generatePancreaticDuct("PancreaticDuctEpithelium:00480", "PancreaticDuctEpithelium", 
						"PancreaticDuctEpithelium", componentID, parentID, currentPoints);			
				
			}
			else if (componentID.equals("PancreaticDuct:04")) {
				
				// Generate the PancreaticDuct
				radius = 0.035;
				double[] startPos = {0.65, -18.15, -2.50};
				double[][] currentPoints = BioGraphics.createCylinderInPlane(Constants.XPLANE, startPos, radius, 8);
					
				int success = bioMightBean.generatePancreaticDuct("PancreaticDuctEpithelium:00720", "PancreaticDuctEpithelium", 
						"PancreaticDuctEpithelium", componentID, parentID, currentPoints);			
				
			}
			
			
			//********************************************************
			// Right Pancreatic Ducts
			//
			//********************************************************
			else if (componentID.equals("PancreaticDuct:05"))
			{
				// Generate the PancreaticDuct
				double[] startPos = {-1.05, -19.65, -3.25};
				double[][] currentPoints = BioGraphics.createCylinderInPlane(Constants.XPLANE, startPos, radius, 8);

				int success = bioMightBean.generatePancreaticDuct("PancreaticDuctEpithelium:00960", "PancreaticDuctEpithelium", 
					"PancreaticDuctEpithelium", componentID, parentID, currentPoints);
				
			}
			else if (componentID.equals("PancreaticDuct:06"))
			{
				// Generate the PancreaticDuct
				radius = 0.060;
				double[] startPos = {-2.15, -19.35, -3.4};
				double[][] currentPoints = BioGraphics.createCylinderInPlane(Constants.YPLANE, startPos, radius, 8);

				int success = bioMightBean.generatePancreaticDuct("PancreaticDuctEpithelium:01200", "PancreaticDuctEpithelium", 
					"PancreaticDuctEpithelium", componentID, parentID, currentPoints);
				
			}
			else if (componentID.equals("PancreaticDuct:07"))
			{
				// Generate the PancreaticDuct
				radius = 0.060;
				double[] startPos = {-2.15, -19.35, -3.4};
				double[][] currentPoints = BioGraphics.createCylinderInPlane(Constants.YPLANE, startPos, radius, 8);

				int success = bioMightBean.generatePancreaticDuct("PancreaticDuctEpithelium:01440", "PancreaticDuctEpithelium", 
					"PancreaticDuctEpithelium", componentID, parentID, currentPoints);
				
			}
			else if (componentID.equals("PancreaticDuct:08"))
			{
				// Generate the PancreaticDuct
				radius = 0.040;
				double[] startPos = {-2.6, -19.95, -3.65};
				double[][] currentPoints = BioGraphics.createCylinderInPlane(Constants.XPLANE, startPos, radius, 8);

				int success = bioMightBean.generatePancreaticDuct("PancreaticDuctEpithelium:01680", "PancreaticDuctEpithelium", 
					"PancreaticDuctEpithelium", componentID, parentID, currentPoints);
				
			}	
			else if (componentID.equals("PancreaticDuct:09"))
			{
				// Generate the PancreaticDuct
				radius = 0.040;
				double[] startPos = {-2.425, -18.75, -3.65};
				double[][] currentPoints = BioGraphics.createCylinderInPlane(Constants.XPLANE, startPos, radius, 8);

				int success = bioMightBean.generatePancreaticDuct("PancreaticDuctEpithelium:01920", "PancreaticDuctEpithelium", 
					"PancreaticDuctEpithelium", componentID, parentID, currentPoints);
				
			}		
			
			
			
			//********************************************************
			// Main line of Pancreatic Ducts
			//
			//********************************************************
			else if (componentID.equals("PancreaticDuct:10"))
			{
				// Generate the PancreaticDuct
				radius = 0.050;
				double[] startPos = {-1.45, -18.5, -3.50};
				double[][] currentPoints = BioGraphics.createCylinderInPlane(Constants.XPLANE, startPos, radius, 8);

				int success = bioMightBean.generatePancreaticDuct("PancreaticDuctEpithelium:2160", "PancreaticDuctEpithelium", 
					"PancreaticDuctEpithelium", componentID, parentID, currentPoints);
				
			}		
			else if (componentID.equals("PancreaticDuct:11"))
			{
				// Generate the PancreaticDuct
				radius = 0.050;
				double[] startPos = {-1.40, -18.6, -3.50};
				double[][] currentPoints = BioGraphics.createCylinderInPlane(Constants.XPLANE, startPos, radius, 8);

				int success = bioMightBean.generatePancreaticDuct("PancreaticDuctEpithelium:2400", "PancreaticDuctEpithelium", 
					"PancreaticDuctEpithelium", componentID, parentID, currentPoints);
				
			}		
			else if (parentID.equals("")) 
			{	
				System.out.println("Calling Generate PancreaticDuctEpithelium NoParent");		
			}

			
			System.out.println("Created PancreaticDuctEpithelium Info using EJB");   	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - PancreaticDuctEpithelium");
			throw new ServerException("Remote Exception PancreaticDuctEpithelium():", e); 	
		}
	}
	

	
	public void initProperties() {
	
		BioMightPropertyView property = new BioMightPropertyView();
		property.setPropertyName("EpitheliumTissue");
		property.setCanonicalName(Constants.EpitheliumTissue);
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
		
		// Assembe the PancreaticDuct
		String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
		"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n " +
		"<X3D profile='Immersive' >\n" +
		"<head>\n" +
		 "<meta name='BioMightImage' content='PancreaticDuct.jpg'/>\n" +
		 "<meta name='ExportTime' content='7:45:30'/>\n" +
		 "<meta name='ExportDate' content='08/15/2008'/>\n" +
		 "<meta name='BioMight Version' content='1.0'/>\n" + 
		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='PancreaticDuct'\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		

	
		String body ="";
		System.out.println("Getting PancreaticDuct X3D");
		viewPerspective = Constants.VIEW_DETACHED;
		if (viewPerspective == Constants.VIEW_DETACHED) {
			System.out.println("Getting PancreaticDuct Epithelium X3D");
			body = epithelium.getX3D(true); 
		}
		else {
			body = ""; 
			    /* calyces.getX3D(true);  +
				renalArtery.getX3D(true) +
				renalVein.getX3D(true) +
				renalFibrousCapsule.getX3D(true) +
				renalSinus.getX3D(true) +
				renalPelvis.getX3D(true) +
				renalPapilla.getX3D(true) +
				kidneyVisceralEpithelium.getX3D(true) +
				maculaDensa.getX3D(true);*/
		}
		
		
		//System.out.println("PancreaticDuct X3D: " + body);		
		
		String footer = "</Scene>" + "</X3D>\n";
		if (snipet)
			return body;			
		else	
			return header + body + footer;
	}

	
}
