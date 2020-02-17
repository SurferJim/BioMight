/*
 * Created on May 8, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.body.head.ear;
import java.util.ArrayList;

import biomight.BioMightBase;
import biomight.Constants;
import biomight.view.BioMightMethodView;
import biomight.view.BioMightPosition;
import biomight.view.BioMightPropertyView;

/**
 * @author SurferJim
 *
 * Representation of the LeftAuricle or Pinna, the exterior part of the ear.
 */

public class LeftAuricle extends Auricle {
	private ArrayList<BioMightPropertyView> properties;
	private ArrayList<BioMightMethodView> methods;
		
	private LeftPinnaAntiHelix leftPinnaAntiHelix;
	private PinnaSuperiorCrux pinnaSuperiorCrux;
	private PinnaInferiorCrux pinnaInferiorCrux;
	private Antitragus antitragus;
	private AuricularSulcus auricularSulcus;
	private PinnaConcha pinnaConcha;
	private PinnaConchalAngle pinnaConchalAngle;
	private PinnaCrusOfHelix pinnaCrusOfHelix;
	private PinnaCymbaConchae cymbaConchae;
	private ExternalAuditoryMeatus  externalAuditoryMeatus;
	private PinnaFossaTriangularis pinnaFossaTriangularis;
	private PinnaHelix pinnaHelix;
	private PinnaIncisuraAnterior pinnaIncisuraAnterior;  
	private PinnaLobe  pinnaLobe;
	private Scapha scapha;
	private Tragus tragus;
	
	
	public LeftAuricle()
	{		
		this.setImage("images/LeftAuricle.jpg");

		// Create the combonents of the Pinna
		leftPinnaAntiHelix = new LeftPinnaAntiHelix();
		pinnaSuperiorCrux = new PinnaSuperiorCrux();
		pinnaInferiorCrux = new PinnaInferiorCrux();
		antitragus = new Antitragus();
		auricularSulcus = new AuricularSulcus();
		pinnaConcha = new PinnaConcha();
		pinnaConchalAngle = new PinnaConchalAngle();
		pinnaCrusOfHelix = new PinnaCrusOfHelix();
		cymbaConchae = new PinnaCymbaConchae();
		externalAuditoryMeatus = new ExternalAuditoryMeatus();
		pinnaFossaTriangularis = new PinnaFossaTriangularis();
		pinnaHelix = new PinnaHelix();
		pinnaIncisuraAnterior = new PinnaIncisuraAnterior();  
		pinnaLobe = new PinnaLobe();
		scapha = new Scapha();
		tragus = new Tragus();
		
		initProperties();
		initMethods();
	}

	// Create the LeftAuricle of the ear using the position
	public LeftAuricle(BioMightPosition bioMightPosition)
	{		
		this.setImage("images/LeftAuricle.jpg");

		// Create the combonents of the Pinna
		System.out.println("Creating pinnaAntiHelix in LeftAuricle Constructor..." + bioMightPosition.getXPos());
		leftPinnaAntiHelix = new LeftPinnaAntiHelix(bioMightPosition);

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
		initProperties();
		initMethods();
	}

	
	// Create the LeftAuricle of the ear using the position
	public void redraw()
	{		
		// Create the combonents of the Pinna
		System.out.println("LeftAuricle Redraw...");
		leftPinnaAntiHelix.redraw(); 

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
		 "<meta name='BioMightImage' content='LeftAuricle.jpg'/>\n" +
		 "<meta name='ExportTime' content='7:45:30'/>\n" +
		 "<meta name='ExportDate' content='08/15/2008'/>\n" +
		 "<meta name='BioMight Version' content='1.0'/>\n" + 
		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='LeftAuricle'\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		

		System.out.println("Getting X3D LeftAuricle...");
		String body =  
			leftPinnaAntiHelix.getX3D(true);
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
		
		System.out.println("LeftAuricle X3D: " + body);		
		
		String footer = "</Scene>" + "</X3D>\n";
		
		if (snipet)
			return body;			
		else	
			return header + body + footer;
	}

}
