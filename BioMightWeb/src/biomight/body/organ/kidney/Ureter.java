/*
 * Created on Jul 23, 2006
 * Copyright 2006 - Biomight.org
 * 
 * This code is the not to be used without written permission from
 * BioMight.org
 * 
 */
 
package biomight.body.organ.kidney;
import java.util.ArrayList;

import javax.naming.InitialContext;

import biomight.BioMightBase;
import biomight.Constants;
import biomight.ejb.BioMightBeanLocal;
import biomight.exceptions.ServerException;
import biomight.system.tissue.epithelial.EpitheliumTissue;
import biomight.system.tissue.muscle.SmoothMuscleTissue;
import biomight.util.BioGraphics;
import biomight.view.BioMightGenerate;
import biomight.view.BioMightMethodView;
import biomight.view.BioMightPosition;
import biomight.view.BioMightPropertyView;
import biomight.view.BioMightScale;

/**
 * @author SurferJim
 *
 * Representation of the Ureter 
 * 
 */

public class Ureter extends BioMightBase {
	//private TransitionalEpitheliumTissue transitionalEpitheliumTissue;
	private EpitheliumTissue epithelium;
	private SmoothMuscleTissue smoothMuscle;
	private OuterTightSpiralMucle outerTightSpiralMucle;
	private InnerLooseSpiralMucle innerLooseSpiralMucle;
	private Adventitia adventitia;
	

		
	/************************************************************************
	 * Ureter Constructor 
	 *
	 ***********************************************************************/
	public Ureter()
	{
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, Constants.UreterRef, null, null);
	}

	/************************************************************************
	 * Ureter Constructor 
	 *
	 ***********************************************************************/
	public Ureter(String parentID)
	{
		System.out.print("Calling parameterized Ureter Constructor!");
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, parentID, null, null);
	}
	
	
	/************************************************************************
	 * Ureter Constructor 
	 *
	 ***********************************************************************/
	public Ureter(int hierarchy, int LOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
	{
		System.out.print("Calling Ureter with MethodParams!");
		create(hierarchy, LOD, parentID, bioMightProperties, bioMightMethods);
	}
	
	
	/************************************************************************
	 * Create Ureter
	 *
	 ***********************************************************************/

	public void create(int hierarchy, int LOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
	{	
		this.setImage("images/Ureter.jpg");
		this.setImageHeight(300);
		this.setImageWidth(300);
	
		componentID = parentID;
	
		int localVP = Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;

		BioMightScale bioScale = new BioMightScale("0.00, 0.00, 0.00");
		BioMightPosition  bioPos = new BioMightPosition("0.00, 0.00, 0.00");
		String bioTemplate="Bacterias.x3d";

		viewPerspective = Constants.VIEW_FLOATING;
		if (viewPerspective == Constants.VIEW_FLOATING) {
			
			// If we have initialization parameters from the form, 
			//  then apply them before constructing the objects.
			if (bioMightMethods != null){
				System.out.println("NEED TO EXECUTE Ureter METHODS: " + bioMightMethods.size());
			}

			if (viewPerspective == Constants.VIEW_FLOATING) {
					
				// Generate the Ureter Epihelium if needed 
				boolean bGenerate = false;
				if (bGenerate) {
					generate(parentID, componentID);
				}
			
				String startID = "SpleenEpithelium:00001";
				System.out.println("Creating Ureter Epithelium: " + parentID);
				epithelium = new EpitheliumTissue(localVP, localLOD, startID, "UreterEpithelium", "UreterEpithelium", componentID, bioMightProperties, bioMightMethods);
				BioMightGenerate generatedEpithelium = epithelium.getBioMightGenerate(); 		
				initProperty("SpleenEpithelium", Constants.EpitheliumTissue, Constants.EpitheliumTissueRef, epithelium.getComponentID(), bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);					
				System.out.println("Ureter Epithelium is created : " + parentID);
				//transitionalEpitheliumTissue = new transitionalEpitheliumTissue(parentID, bioMightMethods);
			}
			else if (viewPerspective == Constants.VIEW_INTERNAL) {

				/***
				System.out.println("Creating Ureter Epithelium: " + parentID);				
				epithelium = new EpitheliumTissue("UreterEpithelium", parentID, bioMightMethods);
				initProperty("EpitheliumTissue", Constants.EpitheliumTissue, Constants.EpitheliumTissueRef, epithelium.getComponentID());
				System.out.println("Ureter Epithelium is created : " + parentID);
				//transitionalEpitheliumTissue = new transitionalEpitheliumTissue(parentID, bioMightMethods);

				System.out.println("Creating Ureter SmoothMuscleTissue: " + parentID);				
				smoothMuscle = new SmoothMuscleTissue("UreterEpithelium", parentID, bioMightMethods);
				initProperty("SmoothMuscleTissue", Constants.SmoothMuscleTissue, Constants.SmoothMuscleTissueRef, smoothMuscle.getComponentID());
				System.out.println("Ureter SmoothMuscleTissue is created : " + parentID);
						
				System.out.println("Creating Ureter OuterTightSpiralMucle: " + parentID);				
				outerTightSpiralMucle = new OuterTightSpiralMucle("UreterEpithelium", parentID, bioMightMethods);
				initProperty("OuterTightSpiralMucle", Constants.OuterTightSpiralMucle, Constants.OuterTightSpiralMucleRef, outerTightSpiralMucle.getComponentID());
				System.out.println("Ureter OuterTightSpiralMucle is created : " + parentID);
				
				System.out.println("Creating Ureter InnerLooseSpiralMucle: " + parentID);				
				innerLooseSpiralMucle = new InnerLooseSpiralMucle("UreterEpithelium", parentID, bioMightMethods);
				initProperty("InnerLooseSpiralMucle", Constants.InnerLooseSpiralMucle, Constants.InnerLooseSpiralMucleeRef, innerLooseSpiralMucle.getComponentID());
				System.out.println("Ureter InnerLooseSpiralMucle is created : " + parentID);
		
				System.out.println("Creating Ureter Adventitia: " + parentID);				
				adventitia = new InnerLooseSpiralMucle("UreterEpithelium", parentID, bioMightMethods);
				initProperty("Adventitia", Constants.Adventitia, Constants.AdventitiaRef, adventitia.getComponentID());
				System.out.println("Ureter Adventitia is created : " + parentID);
				***/
				
			}
			else {
			}
			
			System.out.println("Ureter Instance is created : " + parentID);
		} 
		else if (viewPerspective == Constants.VIEW_INTERNAL) {
	
		}

		//initProperties();
		initMethods();
	}



	/****************************************************
	 * GENERATE URETER
	 * 
	 * 
	 * @param parentID
	 * @param componentID
	 ***************************************************/
	public void generate(String parentID, String componentID)
	{
		// Generate the Palm		
		BioMightBeanLocal bioMightBean;
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Generating the Ureter Epithelium: " + componentID + "    " + parentID);
			InitialContext ctx = new InitialContext();
			bioMightBean = (BioMightBeanLocal) ctx.lookup("java:global/BioMightWeb/BioMightBean!biomight.ejb.BioMightBeanLocal");
	
		
			double radius = 0.125;
			
			if (componentID.equals("Ureter:01")) {
				
				// Generate the Palm
				double[] startPos = {1.95,-23.25,-6.0};
				double[][] currentPoints = BioGraphics.createCylinderInPlane(Constants.YPLANE, startPos, radius, 8);
				
				int success = bioMightBean.generateUreter("UreterEpithelium:00001", "UreterEpithelium", 
						"UreterEpithelium", componentID, currentPoints);			
				
			}
			else if (componentID.equals("Ureter:02"))
			{
				// Generate the Elbow
				double[] startPos = {-1.75,-23.75,-6.0};
				double[][] currentPoints = BioGraphics.createCylinderInPlane(Constants.YPLANE, startPos, radius, 8);

				int success = bioMightBean.generateUreter("UreterEpithelium:00360", "UreterEpithelium", 
					"UreterEpithelium", componentID, currentPoints);			
			}
			else if (parentID.equals("")) 
			{	
				System.out.println("Calling Generate UreterEpithelium NoParent");		
			}

			
			System.out.println("Created UreterEpithelium Info using EJB");   	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - UreterEpithelium");
			throw new ServerException("Remote Exception UreterEpithelium():", e); 	
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
		property.setPropertyName("Ureter Visceral Epithelium");
		//property.setCanonicalName(Constants.UreterVisceralEpithelium);
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
		
		// Assembe the Ureter
		String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
		"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n " +
		"<X3D profile='Immersive' >\n" +
		"<head>\n" +
		 "<meta name='BioMightImage' content='Ureter.jpg'/>\n" +
		 "<meta name='ExportTime' content='7:45:30'/>\n" +
		 "<meta name='ExportDate' content='08/15/2008'/>\n" +
		 "<meta name='BioMight Version' content='1.0'/>\n" + 
		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='Ureter'\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		

		System.out.println("Getting Ureter X3D");
		String body = epithelium.getX3D(true);
		//System.out.println("Ureter X3D: " + body);		
		
		String footer = "</Scene>" + "</X3D>\n";
		
		if (snipet)
			return body;			
		else	
			return header + body + footer;
	}

}
