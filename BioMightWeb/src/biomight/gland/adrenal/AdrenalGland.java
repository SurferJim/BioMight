 package biomight.body.gland.adrenal;

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

/**
 * @author SurferJim
 *
 * Representation of a AdrenalGland
 * 
 */

public class AdrenalGland extends BioMightBase {
	protected EpitheliumTissue epithelium;
	private BioMightTransform gbioMightTransform; 
	private AdrenalCortex cortex;
	private AdrenalMedulla adrenalMedulla;
	private ZonaReticularis zonaReticularis;

	// Vascular 
	//private AdrenalArteries adrenalArteries;
	private SuperiorSupraRenalArtery superiorSupraRenalArtery;
	private InferiorSupraRenalArtery inferiorSupraRenalArtery;	
	private MiddleSupraRenalArtery middleSupraRenalArtery;	

	
	public AdrenalGland()
	{
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, Constants.AdrenalGlandRef, null, null);
	}

	public AdrenalGland(String parentID)
	{
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, parentID, null, null);
	}

	public AdrenalGland(int hierarchy, int LOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
	{
		create(hierarchy, LOD, parentID, bioMightProperties, bioMightMethods);
	}

	
	/************************************************************************************
	 * 
	 * CREATE KIDNEY
	 * 
	 ***********************************************************************************/
	
	public void create(int localVP, int localLOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
	{
		this.setImage("images/AdrenalGland.jpg");
		this.setImageHeight(300);
		this.setImageWidth(300);
		this.parentID = parentID;
		this.componentID = parentID;
		this.lod = localLOD;
		this.viewPerspective = localVP;
		
		System.out.println("Creating AdrenalGland for: " + parentID);
		componentID = parentID;

		
		BioMightScale bioScale = new BioMightScale("0.00, 0.00, 0.00");
		BioMightPosition  bioPos = new BioMightPosition("0.00, 0.00, 0.00");
		String bioTemplate="Enymes.x3d";
		
		if (localVP == Constants.VIEW_INTERNAL)	
		{
			// Do nothing.  We are instantiating as part of a collection  
			// There is no drill down, so we use the transforms that the
			// parent has already collected
			System.out.println("In AdrenalGland Create() - ViewInternal - Already Set: " + parentID);				

			// Do the Epithelial layer
			localLOD = Constants.MAG2X;
			
			// We already have the data for the current instance of AdrenalGland,
			// Go get the details for the current AdrenalGland is LOD is set
			if (localLOD == Constants.MAG2X)
			{
				// Go get the finer details of the AdrenalGland				
				System.out.println("Getting the AdrenalGland MAG2X : " + parentID);
				localVP = Constants.VIEW_INTERNAL; 
				localLOD = Constants.MAG1X;		
			
				// If we have initialization parameters from the form, 
				//  then apply them before constructing the objects.
				if (bioMightMethods != null){
					//System.out.println("NEED TO EXECUTE Calyx METHODS: " + bioMightMethods.size());
				}
				
				// Generate the AdrenalGland Epihelium if needed 
				boolean bGenerate = false;
				if (bGenerate) {
					generate(parentID, componentID);
				}
			
				System.out.println("Retrieving AdrenalGland Epithelium: " + parentID);				
				epithelium = new EpitheliumTissue("AdrenalGlandEpithelium", parentID, bioMightMethods);					
				initProperty(Constants.EpitheliumTissueRef, Constants.EpitheliumTissue, Constants.EpitheliumTissueRef, epithelium.getComponentID(), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);

				
				/*	
			    calyces = new Calyces(parentID, bioMightMethods);
				System.out.println("AdrenalGland Calxes created: " + parentID);
				renalArtery = new RenalArtery(parentID, bioMightMethods);
				System.out.println("RenalArtery completed for AdrenalGland: " + parentID);
				 */


			}
			
			//paceMakerCells = new PaceMakerCells(parentID);				
			System.out.println("AdrenalGland Instance is created : " + parentID);
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
		
			// This is when one is accessing a AdrenalGland directly
			// Get the information from the database via the Enterprise Bean		
			try {
				// Get the information from the database via the Enterprise Bean		
				System.out.println("Getting HawkEye AdrenalGlandInfo for ParentID: " + parentID);
				InitialContext ctx = new InitialContext();
				BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
				bioMightTransforms = bioMightBean.getComponent(parentID);
				
				System.out.println("Have AdrenalGland Info from EJB");   	
			}catch (Exception e) { 
				System.out.println("Exception Getting Components - AdrenalGland");
				throw new ServerException("Remote Exception getComponents():", e); 	
			}
				
			// Run through the collection of BacilliAnthracis and build them into the model
			// In the default case, we get one instance of the AdrenalGland for each eye
			ArrayList transforms = bioMightTransforms.getTransforms();
			System.out.println("AdrenalGland NumTransforms: " + transforms.size());
			for (int i=0; i<transforms.size(); i++)
			{
				// Get the information for the AdrenalGland
				BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
			
				// A hack, I am using the values down below in the X3D method to set some appearance  and material values
				gbioMightTransform  = bioMightTransform;
			
				System.out.println("Creating AdrenalGland: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
				this.componentID = bioMightTransform.getId();

		
				localLOD = Constants.MAG2X;
				if (localLOD == Constants.MAG1X)
				{
					System.out.println("Creating AdrenalGland at HawkEye MAG1X - Just Init Properties: " + parentID);
					// initialize the Properties
					initProperties();
				}
				if (localLOD == Constants.MAG2X)
				{
					// Go get the finer details of the AdrenalGland				
					System.out.println("Creating AdrenalGland at HawkEye MAG2X : " + parentID);
					localVP = Constants.VIEW_INTERNAL; 
					localLOD = Constants.MAG1X;

					// Do the Epithelial layer
					localLOD = Constants.MAG2X;
			
					System.out.println("Retrieving AdrenalGland Epithelium: " + parentID);	
					epithelium = new EpitheliumTissue("AdrenalGlandEpithelium", parentID, bioMightMethods);
					initProperty(Constants.EpitheliumTissueRef, Constants.EpitheliumTissue, Constants.EpitheliumTissueRef, epithelium.getComponentID(), bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		
					/*	
				    calyces = new Calyces(parentID, bioMightMethods);
					System.out.println("AdrenalGland Calxes created: " + parentID);
					renalArtery = new RenalArtery(parentID, bioMightMethods);
					System.out.println("RenalArtery completed for AdrenalGland: " + parentID);

					*/				}
				
			}
		}		
		else 
		{
	
		}

		
	initMethods();
	initProperties();
	System.out.println("CreateAdrenalGland Completed");
	}

	

	
	public void initProperties() {
	
		BioMightScale bioScale = new BioMightScale("0.00, 0.00, 0.00");
		BioMightPosition bioPos = new BioMightPosition("0.00, 0.00, 0.00");	
		String bioTemplate =""; 

		initProperty(Constants.NOT_ACTIVATED, Constants.Title, Constants.Title, "AdrenalGland:0", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		initProperty(Constants.AdrenalMedullaRef, Constants.AdrenalMedulla, Constants.AdrenalMedullaRef, "AdrenalGland:0", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		initProperty(Constants.AdrenalCortexRef, Constants.AdrenalCortex, Constants.AdrenalCortexRef, "Organs:0", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		initProperty(Constants.ZonaReticularisRef, Constants.ZonaReticularis, Constants.ZonaReticularisRef, "Organs:0", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		initProperty(Constants.AdrenalMedullaRef, Constants.AdrenalMedulla, Constants.AdrenalMedullaRef, "Organs:0", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		initProperty(Constants.AdrenalCortexRef, Constants.AdrenalCortex, Constants.AdrenalCortexRef, "Organs:0", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		initProperty(Constants.ZonaReticularisRef, Constants.ZonaReticularis, Constants.ZonaReticularisRef, "Organs:0", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		initProperty(Constants.SuperiorSupraRenalArteryRef, Constants.SuperiorSupraRenalArtery, Constants.SuperiorSupraRenalArteryRef, "Organs:0", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		initProperty(Constants.InferiorSupraRenalArteryRef, Constants.InferiorSupraRenalArtery, Constants.InferiorSupraRenalArteryRef, "Organs:0", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		initProperty(Constants.MiddleSupraRenalArteryRef, Constants.MiddleSupraRenalArtery, Constants.MiddleSupraRenalArteryRef, "Organs:0", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		}
		
	
	public void initMethods() {
		
		BioMightMethodView method = new BioMightMethodView();
		method = new BioMightMethodView();
		method.setCanonicalName(Constants.AdrenalGlands);
		method.setMethodName("setColor");
		method.setDisplayName("Color");
		method.setHtmlType(Constants.BIO_DROPDOWN);
		method.setDataType(Constants.BIO_INT);
	 	method.setValueMap(materialDDMap);
		methods.add(method);
		
		method = new BioMightMethodView();
		method.setCanonicalName(Constants.AdrenalGlands);
		method.setMethodName("setSkin");
		method.setDisplayName("Texture");
		method.setHtmlType(Constants.BIO_DROPDOWN);
		method.setDataType(Constants.BIO_INT);
	 	method.setValueMap(textureDDMap);
		methods.add(method);
	}
	
	
	
	/****************************************************
	 * GENERATE ADRENAL GLAND
	 * 
	 * 
	 * @param parentID
	 * @param componentID
	 ***************************************************/
	public void generate(String parentID, String componentID)
	{
		// Generate the AdrenalGland		
		BioMightBeanLocal bioMightBean;
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Generating the AdrenalGland Epithelium: " + componentID + "    " + parentID);
			InitialContext ctx = new InitialContext();
			bioMightBean = (BioMightBeanLocal) ctx.lookup("java:global/BioMightWeb/BioMightBean!biomight.ejb.BioMightBeanLocal");
	
		
			double radius = 0.0025;
			
			if (componentID.equals("AdrenalGland:01")) {
				
				// Generate the Palm
				double[] startPos = {1.70, -19.35, -6.05};	
				double[] orient = {0, 0, 15};
				double[][] currentPoints = BioGraphics.createCylinderInPlane(orient, startPos, radius, 8);
				
					
				int success = bioMightBean.generateAdrenalGland("AdrenalGlandEpithelium:00001", "AdrenalGlandEpithelium", 
						"AdrenalGlandEpithelium", componentID, parentID, currentPoints);			
			}
			else if (componentID.equals("AdrenalGland:02"))
			{
				// Generate the Elbow
				double[] startPos = {-1.50, -19.75, -6.05};    		 
				double[] orient = {0, 0, -15};
				double[][] currentPoints = BioGraphics.createCylinderInPlane(orient, startPos, radius, 8);
				
				int success = bioMightBean.generateAdrenalGland("AdrenalGlandEpithelium:00240", "AdrenalGlandEpithelium", 
					"AdrenalGlandEpithelium", componentID, parentID, currentPoints);
				
			}
			else if (parentID.equals("")) 
			{	
				System.out.println("Calling Generate AdrenalGlandEpithelium NoParent");		
			}

			
			System.out.println("Created AdrenalGlandEpithelium Info using EJB");   	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - AdrenalGlandEpithelium");
			throw new ServerException("Remote Exception AdrenalGlandEpithelium():", e); 	
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
		
		// Assembe the AdrenalGland
		String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
		"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n " +
		"<X3D profile='Immersive' >\n" +
		"<head>\n" +
		 "<meta name='BioMightImage' content='AdrenalGland.jpg'/>\n" +
		 "<meta name='ExportTime' content='7:45:30'/>\n" +
		 "<meta name='ExportDate' content='08/15/2008'/>\n" +
		 "<meta name='BioMight Version' content='1.0'/>\n" + 
		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='AdrenalGland'\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		

	
		String body ="";
		System.out.println("Getting AdrenalGland X3D");
		viewPerspective = Constants.VIEW_DETACHED;
		if (viewPerspective == Constants.VIEW_DETACHED) {
			System.out.println("Getting AdrenalGland Epithelium X3D");
			body = epithelium.getX3D(true); 
		}
		else {
			body = ""; //calyces.getX3D(true); 
				//renalArtery.getX3D(true) +
		
		}
		
		
		//System.out.println("AdrenalGland X3D: " + body);		
		
		String footer = "</Scene>" + "</X3D>\n";
		if (snipet)
			return body;			
		else	
			return header + body + footer;
	}

	
}





	
	
	
	