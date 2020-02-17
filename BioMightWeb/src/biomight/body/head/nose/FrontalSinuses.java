/*
 * Created on May 19, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.body.head.nose;
import java.lang.reflect.Method;
import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.naming.InitialContext;

import biomight.BioMightBase;
import biomight.Constants;
import biomight.body.BodyPart;
import biomight.cell.neuronglial.*;
import biomight.cell.epithelial.*;
import biomight.cell.neuron.*;
import biomight.ejb.BioMightBeanLocal;
import biomight.exceptions.DataSecurityException;
import biomight.exceptions.ServerException;
import biomight.system.muscular.head.eye.*;
import biomight.view.BioMightMaterial;
import biomight.view.BioMightMethodView;
import biomight.view.BioMightPosition;
import biomight.view.BioMightPropertyView;
import biomight.view.BioMightTransform;
import biomight.view.BioMightTransforms;

/**
 * @author SurferJim
 *
 * This class will instantiate the FrontalSinuses that are defined for the body we
 * are working with.
 * 
 */

public class FrontalSinuses extends BioMightBase {
	private ArrayList frontalSinuses;
	private BioMightTransforms bioMightTransforms; 
	private ArrayList<BioMightPropertyView> properties;
	private ArrayList<BioMightMethodView> methods;
	private String componentID;
	
	
	/********************************************************************************************************************
	 *  FrontalSinuses
	 * 
	 * This method will instantiate the FrontalSinuses that are defined for the current model.  
	 * 
	 ********************************************************************************************************************/

	public FrontalSinuses()
	{		
		create(Constants.HeadRef, null);
	}
	
	/********************************************************************************************************************
	 *  FrontalSinuses
	 * 
	 * This method will instantiate the FrontalSinuses that are defined for the current model.  
	 * 
	 ********************************************************************************************************************/

	public FrontalSinuses(String parentID)
	{		
		create(parentID, null);
	}

	
	public FrontalSinuses(String parentID, ArrayList<BioMightMethodView> bioMightMethods)
	{		
		create(parentID, bioMightMethods);
	}
	
	
	/********************************************************************************************************************
	 * CREATE 
	 * 
	 * This method will instantiate the FrontalSinuses that are defined for the current model.  
	 * 
	 ********************************************************************************************************************/

	private void create(String parentID, ArrayList<BioMightMethodView> bioMightMethods) {

		frontalSinuses = new ArrayList();

		
		// If we have initialization parameters from the form, 
		//  then apply them before constructing the objects.
		if (bioMightMethods != null){
			System.out.println("NEED TO EXECUTE FrontalSinuses METHODS: " + bioMightMethods.size());
		}
		
		
		// Get the information from the database via the Enterprise Bean				
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Getting FrontalSinusesInfo for ParentID: " + parentID);
			InitialContext ctx = new InitialContext();
			BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
			bioMightTransforms = bioMightBean.getComponents(Constants.FrontalSinusRef, parentID);
			System.out.println("Have FrontalSinuses Info from EJB");   	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - Frontal Sinus");
			throw new ServerException("Remote Exception getComponents():", e); 	
		}
		
		// Get the collection of FrontalSinuses from the database.  
		this.componentID = componentID;
		properties = new ArrayList<BioMightPropertyView>();
		
		// Run through the collection of FrontalSinuses and build them into the model
		// In the Default case, we get two instances of the Sinus, one
		// positioned on the right and one positioned on the left
		ArrayList transforms = bioMightTransforms.getTransforms();
		System.out.println("Have FrontalSinuses NumTransforms: " + transforms.size());
		for (int i=0; i<transforms.size(); i++)
		{
			// Get the information for the Sinus we are creating
			BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
			System.out.println("Creating Sinus: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
			
			// Create an instance of the Eye for each tranform specified for the organism
			FrontalSinus frontaSinus = new FrontalSinus(bioMightTransform.getId(), bioMightMethods);		
			System.out.println("Sinus Created!: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
			frontalSinuses.add(frontaSinus);
			System.out.println("Add to Collection!: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());

			// initialize the Properties
			// in this case, rather than pass canonical name, we pass the name found in the collection
			initProperty(bioMightTransform.getName(), Constants.Sinus, Constants.SinusRef, bioMightTransform.getId());
		}

		// Set up methods that will be available to the FrontalSinuses
		initMethods();
	}

	

	protected void initProperty(String componentName, String canonicalName, String componentRef, String componentID) {
		BioMightPropertyView property = new BioMightPropertyView();
		property.setPropertyName(componentName);
		property.setCanonicalName(canonicalName);
		property.setPropertyRef(componentRef);
		property.setPropertyID(componentID);
		properties.add(property);
	}
	
	
	
	public void initMethods() {
		
		BioMightMethodView method = new BioMightMethodView();
		method.setCanonicalName(Constants.FrontalSinuses);
		method.setMethodName("setMaterial");
		method.setDisplayName("Color");
		method.setHtmlType(Constants.BIO_DROPDOWN);
		method.setDataType(Constants.BIO_TEXT);
	 	method.setValueMap(materialDDMap);
		methods.add(method);
		
		method = new BioMightMethodView();
		method.setCanonicalName(Constants.FrontalSinuses);
		method.setMethodName("setTexture");
		method.setDisplayName("Texture");
		method.setHtmlType(Constants.BIO_DROPDOWN);
		method.setDataType(Constants.BIO_TEXT);
	 	method.setValueMap(textureDDMap);
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
		 "<meta name='BioMightImage' content='FrontalSinuses.jpg'/>\n" +
		 "<meta name='ExportTime' content='7:45:30'/>\n" +
		 "<meta name='ExportDate' content='08/15/2008'/>\n" +
		 "<meta name='BioMight Version' content='1.0'/>\n" + 
		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='FrontalSinuses'\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		

		String body = ""; 
		System.out.println("Assembling X3D for FrontalSinuses");
		
		// Run through the collection of FrontalSinuses and assemble the X3D for each
		for (int i=0; i<frontalSinuses.size(); i++)
		{
			
			// Get the information for the eye
			FrontalSinus frontalSinus = (FrontalSinus) frontalSinuses.get(i);
			System.out.println("Getting X3D for FrontalSinus");
			body += frontalSinus.getX3D(true);
		}		
		

		System.out.println("FrontalSinuses X3D: " + body);		
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
