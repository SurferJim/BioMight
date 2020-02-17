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
import biomight.system.tissue.edothelial.EndotheliumTissue;
import biomight.view.BioMightMethodView;
import biomight.view.BioMightPropertyView;
import biomight.view.BioMightTransform;
import biomight.view.BioMightTransforms;

/**
 * @author SurferJim
 *
 * Representation of a Cochlea
 */

public class Cochlea extends BioMightBase {
	private BioMightTransforms bioMightTransforms;
	private String parentID;
	private ArrayList<BioMightPropertyView> properties;
	private ArrayList<BioMightMethodView> methods;
	private ScalaVestibuli scalaVestibuli;
	private ScalaTympani scalaTympani;
	private ScalaMedia scalaMedia;
	private Helicotrema helicotrema;
	private ReissnersMembrane reissnersMembrane;
	private BasilarMembrane basilarMembrane;
	private OrganOfCorti organOfCorti;
	private CochleaHairCells cochleaHairCells;
	private Stereocilia stereocilia;
	private String componentID = "";
	
	
	public Cochlea()
	{
		create(Constants.Cochlea, null);
	}

	public Cochlea(String parentID)
	{
		create(parentID, null);
	}
	
	public Cochlea(String parentID, ArrayList<BioMightMethodView> bioMightMethods)
	{
		create(parentID, bioMightMethods);
	}

	
	public void create(String parentID, ArrayList<BioMightMethodView> bioMightMethods)
	{
		this.setImage("images/Cochlea.jpg");
		this.setImageHeight(300);
		this.setImageWidth(300);
	
		
		// Get the information from the database via the Enterprise Bean		
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Getting CochleaInfo for ParentID: " + parentID);
			InitialContext ctx = new InitialContext();
			BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
			bioMightTransforms = bioMightBean.getComponents(Constants.CochleaRef, parentID);
			System.out.println("Have Cochlea Info from EJB");   	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - Cochlea");
			throw new ServerException("Remote Exception getComponents():", e); 	
		}

		properties = new ArrayList<BioMightPropertyView>();
			
		// Run through the collection of Cochleas and build them into the model
		// In the default case, we get one instance of the Cochlea for each eye
		ArrayList transforms = bioMightTransforms.getTransforms();
		System.out.println("Cochlea NumTransforms: " + transforms.size());
		for (int i=0; i<transforms.size(); i++)
		{
			// Get the information for the eye we are creating
			BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
			System.out.println("Created Cochlea: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
			
			componentID = bioMightTransform.getId();
		
			scalaVestibuli  = new ScalaVestibuli(bioMightTransform.getId(), bioMightMethods);
			initProperty("ScalaVestibuli", Constants.ScalaVestibuli, Constants.ScalaVestibuliRef, scalaVestibuli.getComponentID());
			
			scalaTympani = new ScalaTympani(bioMightTransform.getId(), bioMightMethods);
			initProperty("ScalaTympani", Constants.ScalaTympani, Constants.ScalaTympaniRef, scalaTympani.getComponentID());
			
			scalaMedia = new ScalaMedia(bioMightTransform.getId(), bioMightMethods);
			initProperty("ScalaMedia", Constants.ScalaMedia, Constants.ScalaMediaRef, scalaMedia.getComponentID());
			
			helicotrema = new Helicotrema(bioMightTransform.getId(), bioMightMethods);
			initProperty("Helicotrema", Constants.Helicotrema, Constants.HelicotremaRef, helicotrema.getComponentID());
			
			reissnersMembrane = new ReissnersMembrane(bioMightTransform.getId(), bioMightMethods);
			initProperty("ReissnersMembrane", Constants.ReissnersMembrane, Constants.ReissnersMembraneRef, reissnersMembrane.getComponentID());
			
			basilarMembrane = new BasilarMembrane(bioMightTransform.getId(), bioMightMethods);
			initProperty("BasilarMembrane", Constants.BasilarMembrane, Constants.BasilarMembraneRef, basilarMembrane.getComponentID());
			
			organOfCorti = new OrganOfCorti(bioMightTransform.getId(), bioMightMethods);
			initProperty("OrganOfCorti", Constants.OrganOfCorti, Constants.OrganOfCortiRef, organOfCorti.getComponentID());
			
			cochleaHairCells = new CochleaHairCells(bioMightTransform.getId(), bioMightMethods);
			initProperty("CochleaHairCells", Constants.CochleaHairCells, Constants.CochleaHairCellsRef, cochleaHairCells.getComponentID());
			
			
			System.out.println("Creating Cochlea Endothelium: " + bioMightTransform.getId());				
			//endothelium = new EndotheliumTissue(bioMightTransform.getId());
			
			/*int viewPerspective = Constants.VIEW_DETACHED;
			if (viewPerspective == Constants.VIEW_DETACHED)
			{				
				// Create the components of the curvature
			
		  
		  stereocilia = new Stereocilia();

			}*/
		}
		//initProperties();
		initMethods();
		
		System.out.println("CreateCochlea Completed");
		
		// First, get all the data from the database
		// Apply the methods to it
		// Save its state
		this.parentID = parentID;
		if (bioMightMethods != null){
			System.out.println("EXECUTING Cochlea METHODS: " + bioMightMethods.size());
			//executeMethods(bioMightMethods);
		}
	}

	
	
	protected void initProperty(String componentName, String canonicalName, String componentRef, String componentID) {
		BioMightPropertyView property = new BioMightPropertyView();
		property.setPropertyName(componentName);
		property.setCanonicalName(canonicalName);
		property.setPropertyRef(componentRef);
		property.setPropertyID(componentID);
		properties.add(property);
	}
	
	
	private void initProperties() {

		properties = new ArrayList<BioMightPropertyView>();
		
		BioMightPropertyView property = new BioMightPropertyView();
		property.setPropertyName("Lysosome");
		property.setCanonicalName(Constants.Lysosome);
		properties.add(property);
	}
	

	private void initMethods() {

		methods = new ArrayList<BioMightMethodView>();	
		
		BioMightMethodView method = new BioMightMethodView();
		method.setMethodName("Set Membrane Width");
		method.setHtmlType("text");
		methods.add(method);

		method = new BioMightMethodView();
		method.setMethodName("Set Volumme");
		method.setHtmlType("text");
		methods.add(method);
	}
		
	/********************************************************************************************************************
	 * GET X3D
	 * 
	 * This method will return the X3D for the Cochlea.  It runs through each of its components and collects up their
	 * representations and then assembles them into one unified X3D model.
	 * 
	 ********************************************************************************************************************/
	public String getX3D(boolean snipet) {
		
		// Assembe the Cochlea
		String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
		"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n " +
		"<X3D profile='Immersive' >\n" +
		"<head>\n" +
		 "<meta name='BioMightImage' content='Cochlea.jpg'/>\n" +
		 "<meta name='ExportTime' content='7:45:30'/>\n" +
		 "<meta name='ExportDate' content='08/15/2008'/>\n" +
		 "<meta name='BioMight Version' content='1.0'/>\n" + 
		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='Cochlea'\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		

		String body =  
			scalaVestibuli.getX3D(true) +
			scalaTympani.getX3D(true) +
			scalaMedia.getX3D(true) +
			helicotrema.getX3D(true) +
			reissnersMembrane.getX3D(true) +
			basilarMembrane.getX3D(true) +
			organOfCorti.getX3D(true) +
			cochleaHairCells.getX3D(true);
			//stereocilia.getX3D(true);
		
		
		System.out.println("Cochlea X3D: " + body);		
		
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
