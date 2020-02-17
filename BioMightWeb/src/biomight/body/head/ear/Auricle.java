/*
 * Created on May 8, 2006
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
import biomight.ejb.BioMightBeanLocal;
import biomight.exceptions.DataSecurityException;
import biomight.exceptions.ServerException;
import biomight.view.BioMightMethodView;
import biomight.view.BioMightPosition;
import biomight.view.BioMightPropertyView;
import biomight.view.BioMightTransform;
import biomight.view.BioMightTransforms;

/**
 * @author SurferJim
 *
 * Representation of the Auricle or Pinna, the exterior part of the ear.
 */

public class Auricle extends BioMightBase {
	BioMightTransforms bioMightTransforms;
	private ArrayList<BioMightPropertyView> properties;
	private ArrayList<BioMightMethodView> methods;
	private String componentID = "";
	protected PinnaAntiHelix pinnaAntiHelix;
	protected PinnaSuperiorCrux pinnaSuperiorCrux;
	protected PinnaInferiorCrux pinnaInferiorCrux;
	protected Antitragus antitragus;
	protected AuricularSulcus auricularSulcus;
	protected PinnaConcha pinnaConcha;
	protected PinnaConchalAngle pinnaConchalAngle;
	protected PinnaCrusOfHelix pinnaCrusOfHelix;
	protected PinnaCymbaConchae cymbaConchae;
	protected ExternalAuditoryMeatus  externalAuditoryMeatus;
	protected PinnaFossaTriangularis pinnaFossaTriangularis;
	protected PinnaHelix pinnaHelix;
	protected PinnaIncisuraAnterior pinnaIncisuraAnterior;  
	protected PinnaLobe  pinnaLobe;
	protected Scapha scapha;
	protected Tragus tragus;
	
	
	public Auricle()
	{		
		//createAuricle(Constants.EarRef);
	}

	// Create the Auricle of the ear using the position
	public Auricle(String parentID)
	{		
		create(parentID, null);
	}

	// Create the Auricle of the ear using the position
	public Auricle(String parentID, ArrayList<BioMightMethodView> bioMightMethods)
	{		
		create(parentID, bioMightMethods);
	}
	
	
	public void create(String parentID, ArrayList<BioMightMethodView> bioMightMethods)
	{
		this.setImage("images/Auricle.jpg");
		this.setImageHeight(300);
		this.setImageWidth(300);
		
		// Get the information from the database via the Enterprise Bean		
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Getting AuricleInfo for ParentID: " + parentID);
			InitialContext ctx = new InitialContext();
			BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
			bioMightTransforms = bioMightBean.getComponents(Constants.AuricleRef, parentID);
			System.out.println("Have Auricle Info from EJB");   	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - Auricle");
			throw new ServerException("Remote Exception getComponents():", e); 	
		}

		properties = new ArrayList<BioMightPropertyView>();
			
		// Run through the collection of Auricle and build them into the model
		// In the default case, we get one instance of the Pupil for each eye
		ArrayList transforms = bioMightTransforms.getTransforms();
		System.out.println("Have AuricleInfo NumTransforms: " + transforms.size());
		for (int i=0; i<transforms.size(); i++)
		{
			// Get the information for the Auricle we are creating
			BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
			System.out.println("Creating Auricle (name,id): " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
			
			componentID = bioMightTransform.getId();
			
			pinnaAntiHelix = new PinnaAntiHelix(bioMightTransform.getId());
			initProperty("PinnaAntiHelix", Constants.PinnaAntiHelix, Constants.PinnaAntiHelixRef, pinnaAntiHelix.getComponentID());
			
			/*
			pinnaSuperiorCrux = new PinnaSuperiorCrux(bioMightPosition);
			pinnaInferiorCrux = new PinnaInferiorCrux(bioMightPosition);
			antitragus = new Antitragus(bioMightPosition);
			auricularSulcus = new AuricularSulcus(bioMightPosition);
			pinnaConcha = new PinnaConcha(bioMightPosition);
			pinnaConchalAngle = new PinnaConchalAngle(bioMightPosition);
			pinnaCrusOfHelix = new PinnaCrusOfHelix(bioMightPosition);
			cymbaConchae = new PinnaCymbaConchae(bioMightPosition);
			externalAuditoryMeatus = new ExternalAuditoryMeatus(bioMightPosition);
			pinnaFossaTriangularis = new PinnaFossaTriangularis(bioMightPosition);
			pinnaHelix = new PinnaHelix(bioMightPosition);
			pinnaIncisuraAnterior = new PinnaIncisuraAnterior(bioMightPosition);  
			pinnaLobe = new PinnaLobe(bioMightPosition);
			scapha = new Scapha(bioMightPosition);
			tragus = new Tragus(bioMightPosition);
			*/
		
			/*int viewPerspective = Constants.VIEW_FLOATING;
			if (viewPerspective == Constants.VIEW_FLOATING) {
				System.out.println("Auricle Eye is created");
			} 
			else if (viewPerspective == Constants.VIEW_INTERNAL) {
			}
			*/
		}		
	
		System.out.println("CreateAuricle Completed: " + parentID);			
		//initProperties();
		initMethods();		
	}
	
	
	public void initProperties() {

		properties = new ArrayList<BioMightPropertyView>();
		
		BioMightPropertyView property = new BioMightPropertyView();
		property.setPropertyName("Pinna Antihelix");
		property.setCanonicalName(Constants.PinnaAntiHelix);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("PinnaSuperiorCrux");
		property.setCanonicalName(Constants.PinnaSuperiorCrux);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("PinnaInferiorCrux");
		property.setCanonicalName(Constants.PinnaInferiorCrux);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("Antitragus");
		property.setCanonicalName(Constants.Antitragus);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("AuricularSulcus");
		property.setCanonicalName(Constants.AuricularSulcus);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("PinnaConcha");
		property.setCanonicalName(Constants.PinnaConcha);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("PinnaConchalAngle");
		property.setCanonicalName(Constants.PinnaConchalAngle);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("PinnaCrusOfHelix");
		property.setCanonicalName(Constants.PinnaCrusOfHelix);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("PinnaCymbaConchae");
		property.setCanonicalName(Constants.PinnaCymbaConchae);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("ExternalAuditoryMeatus");
		property.setCanonicalName(Constants.ExternalAuditoryMeatus);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("PinnaFossaTriangularis");
		property.setCanonicalName(Constants.PinnaFossaTriangularis);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("PinnaHelix");
		property.setCanonicalName(Constants.PinnaHelix);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("pinnaIncisuraAnterior");
		property.setCanonicalName(Constants.PinnaIncisuraAnterior);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("PinnaLobe");
		property.setCanonicalName(Constants.PinnaLobe);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("Scapha");
		property.setCanonicalName(Constants.Scapha);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("Tragus");
		property.setCanonicalName(Constants.Tragus);
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
	
	

	
	// Create the LeftAuricle of the ear using the position
	public void redraw(String parentID)
	{		
		// Create the combonents of the Pinna
		System.out.println("LeftAuricle Redraw...");
		pinnaAntiHelix.redraw(parentID); 

		/*
		pinnaSuperiorCrux.redraw();
		pinnaInferiorCrux.redraw();
		antitragus;
		auricularSulcus.redraw();
		pinnaConcha.redraw();
		pinnaConchalAngle.redraw();
		pinnaCrusOfHelix.redraw();
		cymbaConchae = new PinnaCymbaConchae(bioMightPosition);
		externalAuditoryMeatus.redraw();
		pinnaFossaTriangularis.redraw();
		pinnaHelix = new PinnaHelix(bioMightPosition);
		pinnaIncisuraAnterior = new PinnaIncisuraAnterior(bioMightPosition);  
		pinnaLobe = new PinnaLobe(bioMightPosition);
		scapha = new Scapha(bioMightPosition);
		tragus = new Tragus(bioMightPosition);
		*/
	}
	
	
	/********************************************************************************************************************
	 * GET X3D
	 * 
	 * This method will return the X3D for the Cell.  It runs through each of its components and collects up their
	 * representations and then assembles them into one unified X3D model.
	 * 
	 ********************************************************************************************************************/
	public String getX3D(boolean snipet) {
		
		// Assembe the Head
		String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
		"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n " +
		"<X3D profile='Immersive' >\n" +
		"<head>\n" +
		 "<meta name='BioMightImage' content='Auricle.jpg'/>\n" +
		 "<meta name='ExportTime' content='7:45:30'/>\n" +
		 "<meta name='ExportDate' content='08/15/2008'/>\n" +
		 "<meta name='BioMight Version' content='1.0'/>\n" + 
		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='Auricle'\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		

		System.out.println("Getting X3D Auricle...");
		String body =  
			pinnaAntiHelix.getX3D(true);
			/*
			pinnaSuperiorCrux.getX3D(true) +
			pinnaInferiorCrux.getX3D(true) +
			antitragus.getX3D(true) +
			auricularSulcus.getX3D(true) +
			pinnaConcha.getX3D(true) +
			pinnaConchalAngle.getX3D(true) +
			pinnaCrusOfHelix.getX3D(true) +
			cymbaConchae.getX3D(true) +
			externalAuditoryMeatus.getX3D(true) +
			pinnaFossaTriangularis.getX3D(true) +
			pinnaHelix.getX3D(true) +
			pinnaIncisuraAnterior.getX3D(true) +  
			pinnaLobe.getX3D(true) +
			scapha.getX3D(true) +
			tragus.getX3D(true);
			*/
		
		//System.out.println("Auricle X3D: " + body);		
		
		String footer = "</Scene>" + "</X3D>\n";
		
		if (snipet)
			return body;			
		else	
			return header + body + footer;
	}
	
	
	

	public String getComponentID() {
		return componentID;
	}


	public void setComponentID(String componentID) {
		this.componentID = componentID;
	}

	public ArrayList<BioMightPropertyView> getProperties() {
		return properties;
	}

	public void setProperties(ArrayList<BioMightPropertyView> properties) {
		this.properties = properties;
	}

	public ArrayList<BioMightMethodView> getMethods() {
		return methods;
	}

	public void setMethods(ArrayList<BioMightMethodView> methods) {
		this.methods = methods;
	}
}
