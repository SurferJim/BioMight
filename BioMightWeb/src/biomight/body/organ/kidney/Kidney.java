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
 
package biomight.body.organ.kidney;
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
 * Representation of a Kidney
 * 
 */

public class Kidney extends BioMightBase {
	BioMightTransform gbioMightTransform; 
	private RenalArtery renalArtery;
	private RenalVein renalVein;
	private Calyces calyces;
	private RenalFibrousCapsule renalFibrousCapsule;
	private RenalSinus renalSinus;
	private RenalPelvis renalPelvis;
	private RenalPapilla renalPapilla;
	private KidneyVisceralEpithelium kidneyVisceralEpithelium;
	private MaculaDensa maculaDensa;
	protected EpitheliumTissue epithelium;
	
	
	public Kidney()
	{
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, Constants.KidneyRef, null, null);
	}

	public Kidney(String parentID)
	{
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, parentID, null, null);
	}

	public Kidney(int hierarchy, int LOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
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
		this.setImage("images/Kidney.jpg");
		this.setImageHeight(300);
		this.setImageWidth(300);
		this.parentID = parentID;
		this.componentID = parentID;
		this.lod = localLOD;
		this.viewPerspective = localVP;
		
		System.out.println("Creating Kidney for: " + parentID);
		componentID = parentID;

		if (localVP == Constants.VIEW_INTERNAL)	
		{
			// Do nothing.  We are instantiating as part of a collection  
			// There is no drill down, so we use the transforms that the
			// parent has already collected
			System.out.println("In Kidney Create() - ViewInternal - Already Set: " + parentID);				

			// Do the Epithelial layer
			localLOD = Constants.MAG2X;
			
			// We already have the data for the current instance of Kidney,
			// Go get the details for the current Kidney is LOD is set
			if (localLOD == Constants.MAG2X)
			{
				// Go get the finer details of the Kidney				
				System.out.println("Getting the Kidney MAG2X : " + parentID);
				localVP = Constants.VIEW_INTERNAL; 
				localLOD = Constants.MAG1X;		
			
				// If we have initialization parameters from the form, 
				//  then apply them before constructing the objects.
				if (bioMightMethods != null){
					//System.out.println("NEED TO EXECUTE Calyx METHODS: " + bioMightMethods.size());
				}
				
				// Generate the Kidney Epihelium if needed 
				boolean bGenerate = false;
				if (bGenerate) {
					generate(parentID, componentID);
				}
			
				System.out.println("Retrieving Kidney Epithelium: " + parentID);				
				epithelium = new EpitheliumTissue("KidneyEpithelium", parentID, bioMightMethods);

				/*	
			    calyces = new Calyces(parentID, bioMightMethods);
				System.out.println("Kidney Calxes created: " + parentID);
				renalArtery = new RenalArtery(parentID, bioMightMethods);
				System.out.println("RenalArtery completed for Kidney: " + parentID);

				renalVein = new RenalVein(parentID, bioMightMethods);
				System.out.println("RenalVein completed for Kidney: " + parentID);

				renalSinus = new RenalSinus(parentID, bioMightMethods);
				System.out.println("RenalSinus completed for Kidney: " + parentID);

				renalPelvis = new RenalPelvis(parentID, bioMightMethods);
				System.out.println("RenalPelvis completed for Kidney: " + parentID);

				kidneyVisceralEpithelium = new KidneyVisceralEpithelium(parentID, bioMightMethods);
				System.out.println("KidneyVisceralEpithelium completed for Kidney: " + parentID);

				maculaDensa = new MaculaDensa(parentID, bioMightMethods);
				System.out.println("MaculaDensa completed for Kidney: " + parentID);

				renalFibrousCapsule = new RenalFibrousCapsule(parentID, bioMightMethods);
				System.out.println("RenalFibrousCapsule completed for Kidney: " + parentID);

				renalPapilla = new RenalPapilla(parentID, bioMightMethods);
				System.out.println("RenalPapilla completed for Kidney: " + parentID);		
				*/	
				
				//System.out.println("Creating Kidney MAG ViewInternal - 2X : " + parentID);
				//carbons = new Carbons(localVP, localLOD, componentID, bioMightProperties, bioMightMethods);
				//initProperty(Constants.CarbonsRef, Constants.Carbons, Constants.CarbonsRef, carbons.getComponentID());
				//System.out.println("In Kidney - CarbonsRef is complete");
			}
			
			//paceMakerCells = new PaceMakerCells(parentID);				
			System.out.println("Kidney Instance is created : " + parentID);
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
		
			// This is when one is accessing a Kidney directly
			// Get the information from the database via the Enterprise Bean		
			try {
				// Get the information from the database via the Enterprise Bean		
				System.out.println("Getting HawkEye KidneyInfo for ParentID: " + parentID);
				InitialContext ctx = new InitialContext();
				BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
				bioMightTransforms = bioMightBean.getComponent(parentID);
				
				System.out.println("Have Kidney Info from EJB");   	
			}catch (Exception e) { 
				System.out.println("Exception Getting Components - Kidney");
				throw new ServerException("Remote Exception getComponents():", e); 	
			}
				
			// Run through the collection of BacilliAnthracis and build them into the model
			// In the default case, we get one instance of the Kidney for each eye
			ArrayList transforms = bioMightTransforms.getTransforms();
			System.out.println("Kidney NumTransforms: " + transforms.size());
			for (int i=0; i<transforms.size(); i++)
			{
				// Get the information for the Kidney
				BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
			
				// A hack, I am using the values down below in the X3D method to set some appearance  and material values
				gbioMightTransform  = bioMightTransform;
			
				System.out.println("Creating Kidney: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
				this.componentID = bioMightTransform.getId();

		
				if (localLOD == Constants.MAG1X)
				{
					System.out.println("Creating Kidney at HawkEye MAG1X - Just Init Properties: " + parentID);
					// initialize the Properties
					initProperties();
				}
				if (localLOD == Constants.MAG2X)
				{
					// Go get the finer details of the Kidney				
					System.out.println("Creating Kidney at HawkEye MAG2X : " + parentID);
					localVP = Constants.VIEW_INTERNAL; 
					localLOD = Constants.MAG1X;

					// Do the Epithelial layer
					localLOD = Constants.MAG2X;
			
					System.out.println("Retrieving Kidney Epithelium: " + parentID);	
					epithelium = new EpitheliumTissue("KidneyEpithelium", parentID, bioMightMethods);

					//System.out.println("Creating Kidney HawkEye - 2X : " + parentID);
					//carbons = new Carbons(localVP, localLOD, componentID, bioMightProperties, bioMightMethods);
					//initProperty(Constants.CarbonsRef, Constants.Carbons, Constants.CarbonsRef, carbons.getComponentID());
					//System.out.println("In Kidney - CarbonsRef is complete");

					/*	
				    calyces = new Calyces(parentID, bioMightMethods);
					System.out.println("Kidney Calxes created: " + parentID);
					renalArtery = new RenalArtery(parentID, bioMightMethods);
					System.out.println("RenalArtery completed for Kidney: " + parentID);

					renalVein = new RenalVein(parentID, bioMightMethods);
					System.out.println("RenalVein completed for Kidney: " + parentID);

					renalSinus = new RenalSinus(parentID, bioMightMethods);
					System.out.println("RenalSinus completed for Kidney: " + parentID);

					renalPelvis = new RenalPelvis(parentID, bioMightMethods);
					System.out.println("RenalPelvis completed for Kidney: " + parentID);

					kidneyVisceralEpithelium = new KidneyVisceralEpithelium(parentID, bioMightMethods);
					System.out.println("KidneyVisceralEpithelium completed for Kidney: " + parentID);

					maculaDensa = new MaculaDensa(parentID, bioMightMethods);
					System.out.println("MaculaDensa completed for Kidney: " + parentID);

					renalFibrousCapsule = new RenalFibrousCapsule(parentID, bioMightMethods);
					System.out.println("RenalFibrousCapsule completed for Kidney: " + parentID);

					renalPapilla = new RenalPapilla(parentID, bioMightMethods);
					System.out.println("RenalPapilla completed for Kidney: " + parentID);		
					*/				}
				
			}
		}		
		else 
		{
	
		}

		
	initMethods();
	
	System.out.println("CreateKidney Completed");
	
	// First, get all the data from the database
	// Apply the methods to it
	// Save its state
	this.parentID = parentID;
	if (bioMightMethods != null){
		System.out.println("EXECUTING Kidney Methods: " + bioMightMethods.size());
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
		// Generate the Kidney		
		BioMightBeanLocal bioMightBean;
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Generating the Kidney Epithelium: " + componentID + "    " + parentID);
			InitialContext ctx = new InitialContext();
			bioMightBean = (BioMightBeanLocal) ctx.lookup("java:global/BioMightWeb/BioMightBean!biomight.ejb.BioMightBeanLocal");
	
		
			double radius = 0.0025;
			
			if (componentID.equals("Kidney:01")) {
				
				// Generate the Kidney
				double[] startPos = {1.5, -20.50, -6.0};
				double[][] currentPoints = BioGraphics.createCylinderInPlane(Constants.XPLANE, startPos, radius, 8);
					
				int success = bioMightBean.generateKidney("KidneyEpithelium:00001", "KidneyEpithelium", 
						"KidneyEpithelium", componentID, parentID, currentPoints);			
				
			}
			else if (componentID.equals("Kidney:02"))
			{
				// Generate the Kidney
				double[] startPos = {-1.25, -21.00, -6.0};
				double[][] currentPoints = BioGraphics.createCylinderInPlane(Constants.XPLANE, startPos, radius, 8);

				int success = bioMightBean.generateKidney("KidneyEpithelium:00360", "KidneyEpithelium", 
					"KidneyEpithelium", componentID, parentID, currentPoints);
		
				
			}
			else if (parentID.equals("")) 
			{	
				System.out.println("Calling Generate KidneyEpithelium NoParent");		
			}

			
			System.out.println("Created KidneyEpithelium Info using EJB");   	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - KidneyEpithelium");
			throw new ServerException("Remote Exception KidneyEpithelium():", e); 	
		}
	}
	

	
	public void initProperties() {
	
		BioMightPropertyView property = new BioMightPropertyView();
		property.setPropertyName("Renal Artery");
		property.setCanonicalName(Constants.RenalArtery);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("Renal Veins");
		property.setCanonicalName(Constants.RenalVeins);
		properties.add(property);		

		property = new BioMightPropertyView();
		property.setPropertyName("Calyces");
		property.setCanonicalName(Constants.Calyces);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("Fibrous Capsule");
		property.setCanonicalName(Constants.RenalFibrousCapsule);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("Renal Sinus");
		property.setCanonicalName(Constants.RenalSinus);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("Renal Pelvis");
		property.setCanonicalName(Constants.RenalPelvis);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("Papilla");
		property.setCanonicalName(Constants.RenalPapilla);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("Kidney Visceral Epithelium");
		property.setCanonicalName(Constants.KidneyVisceralEpithelium);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("Macula Densa");
		property.setCanonicalName(Constants.MaculaDensa);
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
		
		// Assembe the Kidney
		String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
		"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n " +
		"<X3D profile='Immersive' >\n" +
		"<head>\n" +
		 "<meta name='BioMightImage' content='Kidney.jpg'/>\n" +
		 "<meta name='ExportTime' content='7:45:30'/>\n" +
		 "<meta name='ExportDate' content='08/15/2008'/>\n" +
		 "<meta name='BioMight Version' content='1.0'/>\n" + 
		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='Kidney'\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		

	
		String body ="";
		System.out.println("Getting Kidney X3D");
		viewPerspective = Constants.VIEW_DETACHED;
		if (viewPerspective == Constants.VIEW_DETACHED) {
			System.out.println("Getting Kidney Epithelium X3D");
			body = epithelium.getX3D(true); 
		}
		else {
			body = calyces.getX3D(true); /* +
				renalArtery.getX3D(true) +
				renalVein.getX3D(true) +
				renalFibrousCapsule.getX3D(true) +
				renalSinus.getX3D(true) +
				renalPelvis.getX3D(true) +
				renalPapilla.getX3D(true) +
				kidneyVisceralEpithelium.getX3D(true) +
				maculaDensa.getX3D(true);*/
		}
		
		
		//System.out.println("Kidney X3D: " + body);		
		
		String footer = "</Scene>" + "</X3D>\n";
		if (snipet)
			return body;			
		else	
			return header + body + footer;
	}

	
	public Calyces getCalyces() {
		return calyces;
	}

	public void setCalyces(Calyces calyces) {
		this.calyces = calyces;
	}

	public KidneyVisceralEpithelium getKidneyVisceralEpithelium() {
		return kidneyVisceralEpithelium;
	}

	public void setKkidneyVisceralEpithelium(KidneyVisceralEpithelium kidneyVisceralEpithelium) {
		this.kidneyVisceralEpithelium = kidneyVisceralEpithelium;
	}

	public MaculaDensa getMaculaDensa() {
		return maculaDensa;
	}

	public void setMaculaDensa(MaculaDensa maculaDensa) {
		this.maculaDensa = maculaDensa;
	}

	public RenalPapilla getRenalPapilla() {
		return renalPapilla;
	}

	public void setRenalPapilla(RenalPapilla papilla) {
		this.renalPapilla = papilla;
	}

	public RenalArtery getRenalArtery() {
		return renalArtery;
	}

	public void setRenalArtery(RenalArtery renalArtery) {
		this.renalArtery = renalArtery;
	}

	public RenalPelvis getRenalPelvis() {
		return renalPelvis;
	}

	public void setRenalPelvis(RenalPelvis renalPelvis) {
		this.renalPelvis = renalPelvis;
	}

	public RenalSinus getRenalSinus() {
		return renalSinus;
	}

	public void setRenalSinus(RenalSinus renalSinus) {
		this.renalSinus = renalSinus;
	}

	public RenalVein getRenalVein() {
		return renalVein;
	}

	public void setRenalVein(RenalVein renalVein) {
		this.renalVein = renalVein;
	}

	
}
