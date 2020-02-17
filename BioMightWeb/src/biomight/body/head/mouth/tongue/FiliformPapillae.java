/*
 * Created on Jun 04, 2011
 * Copyright 2006 - Biomight.org
 * 
 * This code is the not to be used without written permission from
 * BioMight.org
 * 
 */
 
package biomight.body.head.mouth.tongue;

import java.util.ArrayList;

import javax.naming.InitialContext;

import biomight.BioMightBase;
import biomight.Constants;
import biomight.ejb.BioMightBeanLocal;
import biomight.exceptions.ServerException;
import biomight.view.BioMightMethodView;
import biomight.view.BioMightPropertyView;
import biomight.view.BioMightTransform;
import biomight.view.BioMightTransforms;

/**
 * @author SurferJim
 *
 * Representation of the FiliformPapillae that reside on the Tongue
 * 
 */


public class FiliformPapillae extends BioMightBase {
	private ArrayList filiformPapillae;
	private BioMightTransforms bioMightTransforms; 
	private ArrayList<BioMightPropertyView> properties;
	private ArrayList<BioMightMethodView> methods;
	private String componentID;


	
	/********************************************************************************************************************
	 *  FiliformPapillae
	 * 
	 * This method will instantiate the FiliformPapillae that are defined for the current model.  
	 * 
	 ********************************************************************************************************************/

	public FiliformPapillae()
	{		
		create(Constants.HeadRef, null);
	}
	
	/********************************************************************************************************************
	 *  FiliformPapillae
	 * 
	 * This method will instantiate the FiliformPapillae that are defined for the current model.  
	 * 
	 ********************************************************************************************************************/

	public FiliformPapillae(String parentID)
	{		
		create(parentID, null);
	}

	
	public FiliformPapillae(String parentID, ArrayList<BioMightMethodView> bioMightMethods)
	{		
		create(parentID, bioMightMethods);
	}
	
	
	/********************************************************************************************************************
	 * CREATE 
	 * 
	 * This method will instantiate the FiliformPapillae that are defined for the current model.  
	 * 
	 ********************************************************************************************************************/

	private void create(String parentID, ArrayList<BioMightMethodView> bioMightMethods) {

		filiformPapillae = new ArrayList();

		
		// If we have initialization parameters from the form, 
		//  then apply them before constructing the objects.
		if (bioMightMethods != null){
			System.out.println("NEED TO EXECUTE EYES METHODS: " + bioMightMethods.size());
		}
		
		
		// Get the information from the database via the Enterprise Bean				
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Getting FiliformPapillaesInfo for ParentID: " + parentID);
			InitialContext ctx = new InitialContext();
			BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
			bioMightTransforms = bioMightBean.getComponents(Constants.FiliformPapillaRef, parentID);
			System.out.println("Have FiliformPapillae Info from EJB");   	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - Back");
			throw new ServerException("Remote Exception getComponents():", e); 	
		}
		
		// Get the collection of FiliformPapillae from the database.  
		this.componentID = componentID;
		properties = new ArrayList<BioMightPropertyView>();
		
		// Run through the collection of FiliformPapillae and build them into the model
		// In the Default case, we get two instances of the eys, one
		// positioned on the right and one positioned on the left
		ArrayList transforms = bioMightTransforms.getTransforms();
		System.out.println("Have FiliformPapillae NumTransforms: " + transforms.size());
		for (int i=0; i<transforms.size(); i++)
		{
			// Get the information for the eye we are creating
			BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
			System.out.println("Creating FiliformPapilla: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
			
			componentID = bioMightTransform.getId();
						
			// Create an instance of the FiliformPapillae for each tranform specified for the organism
			FiliformPapilla filiformPapilla = new FiliformPapilla(bioMightTransform.getId(), bioMightMethods);		
			System.out.println("FiliformPapilla Created!: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
			filiformPapillae.add(filiformPapilla);
			//String tempID = eye.getComponentID();
			System.out.println("Add to Collection!: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());

			// initialize the Properties
			// in this case, rather than pass canonical name, we pass the name found in the collection
			initProperty(bioMightTransform.getName(), Constants.FungiformPapilla, Constants.FungiformPapillaRef, bioMightTransform.getId());
		}

		// Set up methods that will be available to the eyes
		initMethods();
	}
	
	
	
	protected void initProperty(String componentName, String canonicalName, String componentRef, String componentID) {
		BioMightPropertyView property = new BioMightPropertyView();
		property.setPropertyName(componentName);
		property.setCanonicalName(canonicalName);
		property.setPropertyRef(componentRef);
		property.setPropertyID(componentID);
		property.setPropertyType(Constants.PARENT_COMPONENT);
		properties.add(property);
	}
	
	
	public void initProperties() {

		properties = new ArrayList<BioMightPropertyView>();
		
		BioMightPropertyView property = new BioMightPropertyView();
		property.setPropertyName("Connective Tissue");
		property.setCanonicalName(Constants.ConnectiveTissue);
		properties.add(property);
	
		property = new BioMightPropertyView();
		property.setPropertyName("Nerves");
		property.setCanonicalName(Constants.Nerve);
		properties.add(property);				
				
	}
	
	
	public void initMethods() {

		methods = new ArrayList<BioMightMethodView>();
		
		BioMightMethodView method;

		method = new BioMightMethodView();
		method.setMethodName("Flick");
		method.setHtmlType("checkbox");
		methods.add(method);	
	
	}	

	
	/********************************************************************************************************************
	 * GET X3D
	 * 
	 * This method will return the X3D for the Collection of FiliformPapilla.  It runs through each of its components 
	 * and collects up their representations and then assembles them into model.
	 * 
	 ********************************************************************************************************************/
	public String getX3D(boolean snipet) {
		
		// Assemble the FiliformPapilla
		String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
		"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n " +
		"<X3D profile='Immersive' >\n" +
		"<head>\n" +
		 "<meta name='BioMightImage' content='FiliformPapilla.jpg'/>\n" +
		 "<meta name='ExportTime' content='7:45:30'/>\n" +
		 "<meta name='ExportDate' content='08/15/2008'/>\n" +
		 "<meta name='BioMight Version' content='1.0'/>\n" + 
		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='FiliformPapilla'\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		

		String body = ""; 
		System.out.println("Assembling X3D for FiliformPapilla");
		
		// Run through the collection of eyes and assemble the X3D for each
		for (int i=0; i<filiformPapillae.size(); i++)
		{
			
			// Get the information for the eye
			FiliformPapilla filiformPapilla = (FiliformPapilla) filiformPapillae.get(i);
			System.out.println("Getting X3D for FiliformPapilla");
			body += filiformPapilla.getX3D(true);
		}		
		

		//System.out.println("FiliformPapilla X3D: " + body);		
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
	

	public String getComponentID() {
		return componentID;
	}


	public void setComponentID(String componentID) {
		this.componentID = componentID;
	}
	
}
