/*
 * Created on April 20, 2011
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.body.head;

import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.naming.InitialContext;

import biomight.BioMightBase;
import biomight.Constants;
import biomight.body.*;
import biomight.body.gland.thyroid.*;
import biomight.body.spine.SpineThoracicRegion;
import biomight.ejb.BioMightBeanLocal;
import biomight.exceptions.DataSecurityException;
import biomight.exceptions.ServerException;
import biomight.system.cartilage.*;
import biomight.system.vascular.arteries.*;
import biomight.system.vascular.arteries.head.*;
import biomight.system.vascular.veins.*;
import biomight.system.nervous.nerves.*;
import biomight.system.skeletal.chest.*;
import biomight.system.skeletal.spine.CervicalVertebrae;
import biomight.system.tissue.epithelial.EpitheliumTissue;
import biomight.system.muscular.chest.*;
import biomight.system.muscular.*;
import biomight.system.myology.fasciae.*;
import  biomight.system.nervous.nerves.*;
import biomight.view.BioMightColor;
import biomight.view.BioMightMethodView;
import biomight.view.BioMightPolygon;
import biomight.view.BioMightPolygons;
import biomight.view.BioMightPosition;
import biomight.view.BioMightPositions;
import biomight.view.BioMightPropertyView;
import biomight.view.BioMightTransform;
import biomight.view.BioMightTransforms;

/**
 * @author SurferJim
 * Copyright BioMight.org
 * 
 */

public class Scalp extends BioMightBase {
	private BioMightTransforms bioMightTransforms;
	private EpitheliumTissue epithelium;
	
	// Glands
	//private ThyroidGland sebis, cebus;
	
	private String componentID = "";
	
	
	/*********************************************************************************
	 * CONSTRUCTORS
	 *
	 *********************************************************************************/
	
	public Scalp()
	{
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, Constants.ScalpRef, null, null);
	}

	public Scalp(String parentID)
	{
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, parentID, null, null);
	}

	public Scalp(int hierarchy, int LOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
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
		this.setImage("images/Scalp.jpg");
		this.setImageHeight(300);
		this.setImageWidth(300);
	
		// Get the information from the database via the Enterprise Bean		
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Getting ScalpInfo for ParentID: " + parentID);
			InitialContext ctx = new InitialContext();
			BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
			bioMightTransforms = bioMightBean.getComponents(Constants.ScalpRef, parentID);  	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - Scalp");
			throw new ServerException("Remote Exception getComponents():", e); 	
		}
			
		// Run through Scalp and build them into the model
		ArrayList transforms = bioMightTransforms.getTransforms();
		System.out.println("Scalp NumTransforms: " + transforms.size());
		for (int i=0; i<transforms.size(); i++)
		{
			// Get the information for the Scalp we are creating
			BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
			System.out.println("Creating Scalp (name,id): " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
			componentID = bioMightTransform.getId();
			
			// Create the Skin for the Scalp
			epithelium = new EpitheliumTissue("ScalpEpithelium", bioMightTransform.getId(), bioMightMethods);
			
			System.out.println("Scalp completed");			
		}		


		initProperties();
		initMethods();
	}
	
	
	
	public void initProperties() {

		properties = new ArrayList<BioMightPropertyView>();
		
		BioMightPropertyView property = new BioMightPropertyView();
		property.setPropertyName("Common");
		property.setCanonicalName(Constants.Title);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("Adams Apple");
		property.setCanonicalName(Constants.AdamsApple);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("Glands");
		property.setCanonicalName(Constants.Title);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("ThyroidGland");
		property.setCanonicalName(Constants.ThyroidGland);
		properties.add(property);
	
		property = new BioMightPropertyView();
		property.setPropertyName("ParaThyroidGland");
		property.setCanonicalName(Constants.ParaThyroidGland);
		properties.add(property);		
		
		property = new BioMightPropertyView();
		property.setPropertyName("CarotidArteries");
		property.setCanonicalName(Constants.CarotidArteries);
		properties.add(property);		

		
		property = new BioMightPropertyView();
		property.setPropertyName("Muscles");
		property.setCanonicalName(Constants.Title);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("Anterior Veterbral Muscle");
		property.setCanonicalName(Constants.AnteriorVeterbralMuscle);
		properties.add(property);			
		
		property = new BioMightPropertyView();
		property.setPropertyName("Lateral Cervicle Muscle");
		property.setCanonicalName(Constants.LateralCervicleMuscle);
		properties.add(property);	
		
		property = new BioMightPropertyView();
		property.setPropertyName("Superficial Cervical Muscle");
		property.setCanonicalName(Constants.SuperficialCervicalMuscle);
		properties.add(property);	
		
		property = new BioMightPropertyView();
		property.setPropertyName("Supra Infrahyoid Muscle");
		property.setCanonicalName(Constants.SupraInfrahyoidMuscle);
		properties.add(property);	
		
		property = new BioMightPropertyView();
		property.setPropertyName("Sterno Mastoid Muscle");
		property.setCanonicalName(Constants.SternoMastoidMuscle);
		properties.add(property);	

		property = new BioMightPropertyView();
		property.setPropertyName("Trapezius Muscle");
		property.setCanonicalName(Constants.TrapeziusMuscle);
		properties.add(property);	
		
		property = new BioMightPropertyView();
		property.setPropertyName("Longus Colli Muscle");
		property.setCanonicalName(Constants.LongusColliMuscle);
		properties.add(property);			
		
		property = new BioMightPropertyView();
		property.setPropertyName("Vascular");
		property.setCanonicalName(Constants.Title);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("ExternalJugularVein");
		property.setCanonicalName(Constants.ExternalJugularVein);
		properties.add(property);		
		
		property = new BioMightPropertyView();
		property.setPropertyName("InternalJugularVein");
		property.setCanonicalName(Constants.InternalJugularVein);
		properties.add(property);			
		
		property = new BioMightPropertyView();
		property.setPropertyName("LeftInnominateVein");
		property.setCanonicalName(Constants.LeftInnominateVein);
		properties.add(property);		
		
		property = new BioMightPropertyView();
		property.setPropertyName("RightInnominateVein");
		property.setCanonicalName(Constants.RightInnominateVein);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("SuperiorThyroidVein");
		property.setCanonicalName(Constants.SuperiorThyroidVein);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("MiddleThyroidVein");
		property.setCanonicalName(Constants.MiddleThyroidVein);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("InferiorThyroidVein");
		property.setCanonicalName(Constants.InferiorThyroidVein);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("SuperiorThyroidAtery");
		property.setCanonicalName(Constants.SuperiorThyroidAtery);
		properties.add(property);
	}
	
	
	public void initMethods() {
		methods = new ArrayList<BioMightMethodView>();

		BioMightMethodView method = new BioMightMethodView();

		method = new BioMightMethodView();
		method.setMethodName("Turn");
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
		
		// Assemble the Scalp
		String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
		"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n " +
		"<X3D profile='Immersive' >\n" +
		"<head>\n" +
		 "<meta name='BioMightImage' content='Scalp.jpg'/>\n" +
		 "<meta name='ExportTime' content='7:45:30'/>\n" +
		 "<meta name='ExportDate' content='08/15/2008'/>\n" +
		 "<meta name='BioMight Version' content='1.0'/>\n" + 
		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='Scalp'\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		

		String body = epithelium.getX3D(true);
		//System.out.println("Scalp X3D: " + body);		
		String footer = "</Scene>" + "</X3D>\n";
		
		if (snipet)
			return body;			
		else	
			return header + body + footer;
	}
	

}
 