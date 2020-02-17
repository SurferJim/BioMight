/*
5 * Created on May 8, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.body.head.ear;
import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.naming.InitialContext;

import biomight.BioMightBase;
import biomight.Constants;
import biomight.body.organ.skin.Skin;
import biomight.ejb.BioMightBeanLocal;
import biomight.exceptions.DataSecurityException;
import biomight.exceptions.ServerException;
import biomight.system.cartilage.Cartilage;
import biomight.system.tissue.edothelial.EndotheliumTissue;
import biomight.view.BioMightMethodView;
import biomight.view.BioMightPosition;
import biomight.view.BioMightPropertyView;
import biomight.view.BioMightTransform;
import biomight.view.BioMightTransforms;

/**
 * @author SurferJim
 *
 * Create a Representation of the Human CochleaHairCell.
 * 
 *
 */

public class CochleaHairCell extends BioMightBase {
	private BioMightTransforms bioMightTransforms;
	private String componentID;
	private String parentID;
	protected ArrayList<BioMightPropertyView> properties;
	protected ArrayList<BioMightMethodView> methods;
	
	
	protected int viewPerspective = Constants.VIEW_FLOATING;
	
	
	public CochleaHairCell()
	{
		create(Constants.HeadRef, null);
	}

	public CochleaHairCell(String parentID)
	{
		create(parentID, null);
	}
	
	public CochleaHairCell(String parentID, ArrayList<BioMightMethodView> bioMightMethods)
	{
		create(parentID, bioMightMethods);
	}


	
	// This create is called from the CochleaHairCells Collection.  At that point, it has already 
	// gathered the data from the database.  There is no need to get it again
	public void create(String parentID, ArrayList<BioMightMethodView> bioMightMethods)
	{
			this.setImage("images/CochleaHairCell.jpg");
			this.setImageHeight(300);
			this.setImageWidth(300);
	
			System.out.println("Creating ---- for CochleaHairCell using parent: " + parentID);
			//auricle = new Auricle(parentID, bioMightMethods);
			System.out.println("CochleaHairCell - ----- is created");
			
					
			/*int viewPerspective = Constants.VIEW_DETACHED;
			if (viewPerspective == Constants.VIEW_DETACHED)
			{				
				// Create the components of the curvature

			}*/
		
			initProperties();
			initMethods();
		
		System.out.println("Create CochleaHairCell Completed");
		
		// First, get all the data from the database
		// Apply the methods to it
		// Save its state
		this.parentID = parentID;
		if (bioMightMethods != null){
			System.out.println("EXECUTING CochleaHairCell METHODS: " + bioMightMethods.size());
			//executeMethods(bioMightMethods);
		}
	}
	
	
	
	
	
	
	public void initProperties() {

		properties = new ArrayList<BioMightPropertyView>();
		
		BioMightPropertyView property = new BioMightPropertyView();
		

		property.setPropertyName("Outer CochleaHairCell");
		property.setCanonicalName(Constants.Title);
		properties.add(property);
		

		property.setPropertyName("Inner CochleaHairCell");
		property.setCanonicalName(Constants.Title);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("VestibularNerve");
		property.setCanonicalName(Constants.VestibularNerve);
		properties.add(property);
		

	}
	
	
	public void initMethods() {

		methods = new ArrayList<BioMightMethodView>();
		
		BioMightMethodView method = new BioMightMethodView();

		method = new BioMightMethodView();
		method.setMethodName("Deaf");
		method.setHtmlType("checkbox");
		methods.add(method);	
		
		method = new BioMightMethodView();
		method.setMethodName("HcochleaHairCell");
		method.setHtmlType("checkbox");
		methods.add(method);	
	}
	
	
	/********************************************************************************************************************
	 * GET X3D
	 * 
	 * This method will return the X3D for the CochleaHairCell.  It runs through each of its components and collects up their
	 * representations and then assembles them into one unified X3D model.
	 * 
	 *******************************************************************************************************************/
	public String getX3D(boolean snipet) {
		
		// Assembe the CochleaHairCell
		String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
		"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n " +
		"<X3D profile='Immersive' >\n" +
		"<head>\n" +
		 "<meta name='BioMightImage' content='CochleaHairCell'/>\n" +
		 "<meta name='ExportTime' content='7:45:30'/>\n" +
		 "<meta name='ExportDate' content='08/15/2008'/>\n" +
		 "<meta name='BioMight Version' content='1.0'/>\n" + 
		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='CochleaHairCell'\n" +
		"info='\"BioMight Generated X3D\"'/>\n";			
		
		viewPerspective = Constants.VIEW_FLOATING;
		// Construct the cochleaHairCell based on the View Perspective. We only want to 
		// activate those components that comprise the view
		String body = "";
		if (viewPerspective == Constants.VIEW_FLOATING) {
			System.out.println("Getting X3D for Auricle");
			body = "";
		} else if (viewPerspective == Constants.VIEW_INTERNAL) {
			body = 
			"";
		} else if (viewPerspective == Constants.VIEW_DETACHED) {
			body = 
			"";
		}
		
		System.out.println("CochleaHairCell X3D: " + body);		
		
		String footer = "</Scene>" + "</X3D>\n";
		
		if (snipet)
			return body;			
		else	
			return header + body + footer;
	}
	
	
	public ArrayList<BioMightMethodView> getMethods() {
		return methods;
	}


	public void setMethods(ArrayList<BioMightMethodView> methods) {
		this.methods = methods;
	}


	public ArrayList<BioMightPropertyView> getProperties() {
		return properties;
	}


	public void setProperties(ArrayList<BioMightPropertyView> properties) {
		this.properties = properties;
	}


	public int getViewPerspective() {
		return viewPerspective;
	}


	public void setViewPerspective(int viewPerspective) {
		this.viewPerspective = viewPerspective;
	}

}
