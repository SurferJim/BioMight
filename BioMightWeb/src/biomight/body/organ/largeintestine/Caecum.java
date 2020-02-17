/*
 * Created on Jul 9, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.body.organ.largeintestine;

import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.naming.InitialContext;

import biomight.BioMightBase;
import biomight.Constants;
import biomight.ejb.BioMightBeanLocal;
import biomight.exceptions.DataSecurityException;
import biomight.exceptions.ServerException;
import biomight.system.tissue.edothelial.EndotheliumTissue;
import biomight.view.BioMightMethodView;
import biomight.view.BioMightPropertyView;
import biomight.view.BioMightTransform;
import biomight.view.BioMightTransforms;

/**
 * @author SurferJim
 *
 * Representation of the Caecum
 * 
 */

public class Caecum extends BioMightBase{
	private String componentID = "";
	private BioMightTransforms bioMightTransforms;
	//private StratifiedEpithelialTissue stratifiedEpithelialTissue;
	private EndotheliumTissue endothelium;
	private ArrayList<BioMightPropertyView> properties;
	private ArrayList<BioMightMethodView> methods;
	
		
	public Caecum() {
		create(Constants.CaecumRef, null);
	}
	
	public Caecum(String parentID) {
		create(parentID, null);
	}

	public Caecum(String parentID, ArrayList<BioMightMethodView> bioMightMethods)
	{
		create(parentID, bioMightMethods);
	}
	

	public void create(String parentID, ArrayList<BioMightMethodView> bioMightMethods)
	{
		this.setImage("images/Caecum.jpg");
		this.setImageHeight(300);
		this.setImageWidth(300);

		// Get the information from the database via the Enterprise Bean		
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Getting CaecumInfo for ParentID: " + parentID);
			InitialContext ctx = new InitialContext();
			BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
			bioMightTransforms = bioMightBean.getComponents(Constants.CaecumRef, parentID);
			System.out.println("Have Caecum Info from EJB");   	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - Caecum");
			throw new ServerException("Remote Exception getComponents():", e); 	
		}
			
		// Run through Caecum and build them into the model
		ArrayList transforms = bioMightTransforms.getTransforms();
		System.out.println("Caecum NumTransforms: " + transforms.size());
		for (int i=0; i<transforms.size(); i++)
		{
			// Get the information for the Caecum we are creating
			BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
			System.out.println("Creating Caecum (name,id): " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
			componentID = bioMightTransform.getId();

			endothelium = new EndotheliumTissue("CaecumEndothelium", bioMightTransform.getId(), bioMightMethods);

			System.out.println("Caecum completed");			
		}			
		initProperties();
		initMethods();
	}
	

	
	
	
	public void initProperties() {

		properties = new ArrayList<BioMightPropertyView>();
		
		BioMightPropertyView property = new BioMightPropertyView();
		property.setPropertyName("Stapes ---");
		property.setCanonicalName(Constants.LeftEar);
		properties.add(property);
				
	}
	
	
	public void initMethods() {

		methods = new ArrayList<BioMightMethodView>();
		
		BioMightMethodView method = new BioMightMethodView();

		method = new BioMightMethodView();
		method.setMethodName("Deafness");
		method.setHtmlType("checkbox");
		methods.add(method);	
		
		method = new BioMightMethodView();
		method.setMethodName("Hear");
		method.setHtmlType("checkbox");
		methods.add(method);
	}
	
	/********************************************************************************************************************
	 * GET X3D
	 * 
	 * This method will return the X3D for the rectum.  It runs through each of its components and collects up their
	 * representations and then assembles them into one unified X3D model.
	 * 
	 ********************************************************************************************************************/
	public String getX3D(boolean snipet) {
		
		// Assemble the Caecum
		String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
		"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n " +
		"<X3D profile='Immersive' >\n" +
		"<head>\n" +
		 "<meta name='BioMightImage' content='Caecum.jpg'/>\n" +
		 "<meta name='ExportTime' content='7:45:30'/>\n" +
		 "<meta name='ExportDate' content='08/15/2008'/>\n" +
		 "<meta name='BioMight Version' content='1.0'/>\n" + 
		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='Caecum'\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		

		String body = endothelium.getX3D(true);
		
		System.out.println("Caecum X3D: " + body);		
		String footer = "</Scene>" + "</X3D>\n";
		
		if (snipet)
			return body;			
		else	
			return header + body + footer;
	}


}
