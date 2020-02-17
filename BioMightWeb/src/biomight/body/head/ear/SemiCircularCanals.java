/*
 * Created on May 8, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.body.head.ear;
import java.util.ArrayList;
import java.util.HashMap;

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
 * Representation of the SemiCircularCanals
 */

public class SemiCircularCanals  extends BioMightBase {
	private ArrayList semiCircularCanals;
	private BioMightTransforms bioMightTransforms; 
	private ArrayList<BioMightPropertyView> properties;
	private ArrayList<BioMightMethodView> methods;
	private String componentID;
	
	
	/********************************************************************************************************************
	 *  SemiCircularCanals
	 * 
	 * This method will instantiate the SemiCircularCanals that are defined for the current model.  
	 * 
	 ********************************************************************************************************************/

	
	public SemiCircularCanals()
	{		
		create(Constants.HeadRef, null);
	}
	

	/********************************************************************************************************************
	 *  SemiCircularCanals
	 * 
	 * This method will instantiate the Eyes that are defined for the current model.  
	 * 
	 ********************************************************************************************************************/

	
	public SemiCircularCanals(String parentID)
	{		
		create(parentID, null);
	}
	

	public SemiCircularCanals(String parentID, ArrayList<BioMightMethodView> bioMightMethods)
	{		
		create(parentID, bioMightMethods);
	}
	
	
	/********************************************************************************************************************
	 * CREATE SemiCircularCanals
	 * 
	 * This method will instantiate the Eyes that are defined for the current model.  
	 * 
	 ********************************************************************************************************************/

	private void create(String parentID, ArrayList<BioMightMethodView> bioMightMethods) {

		// Allocate space for the collection of semiCircularCanals
		semiCircularCanals = new ArrayList();
		
		
		// Get the information from the database via the Enterprise Bean		
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Getting SemiCircularCanalsInfo for ParentID: " + parentID);
			InitialContext ctx = new InitialContext();
			BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
			bioMightTransforms = bioMightBean.getComponents(Constants.SemiCircularCanalRef, parentID);
			System.out.println("Have SemiCircularCanals Info from EJB");   	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - SemiCircularCanals");
			throw new ServerException("Remote Exception getComponents():", e); 	
		}

		
		// This is a collection, so set the parent of the children
		// to that of the aggregation object
		componentID = parentID;
		properties = new ArrayList();
	
		// Run through the collection of SemiCircularCanals and build them into the model
		// In the Default case, we get two instances of the semiCircularCanal, one
		// positioned on the right and one positioned on the left
		ArrayList transforms = bioMightTransforms.getTransforms();
		System.out.println("Creating SemiCircularCanals NumTransforms: " + transforms.size());

		for (int i=0; i<transforms.size(); i++)
		{
			// Get the information for the eye we are creating
			BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
			System.out.println("Creating SemiCircularCanal: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
		
			// Create an instance of the SemiCircularCanal for each tranform brought
			// SemiCircularCanals from the model.  We grabbed the component ID during this fetch
			// so pass it to the EAR creator so that it can be used as a parent reference
			SemiCircularCanal semiCircularCanal = new SemiCircularCanal(bioMightTransform.getId(), bioMightMethods);			
			semiCircularCanals.add(semiCircularCanal);
			System.out.println("Added SemiCircularCanal to Collection!: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
			
			// initialize the Properties
			// in this case, rather than pass canonical name, we pass the name found in the collection
			initProperty(bioMightTransform.getName(), Constants.SemiCircularCanal, Constants.SemiCircularCanalRef, bioMightTransform.getId());
		}
		
		// Set up methods that will be available to the semiCircularCanals
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

		methods = new ArrayList<BioMightMethodView>();
		
		BioMightMethodView method = new BioMightMethodView();

		method = new BioMightMethodView();
		method.setMethodName("setSemiCircularCanalingLevel");
		method.setDisplayName("SemiCircularCanalingLevel");
		method.setHtmlType("dropdown");
		method.setDataType("String");
		HashMap canalRadias = new HashMap();
		canalRadias.put(1, "20db");
		canalRadias.put(2, "25db");
		canalRadias.put(3, "30db");
		canalRadias.put(4, "35dbl");
    	method.setValueMap(canalRadias);
		methods.add(method);	
	}
	
	/********************************************************************************************************************
	 * GET X3D
	 * 
	 * This method will return the X3D for the SemiCircularCanals.  It runs through each of its components and collects up their
	 * representations and then assembles them into one unified X3D model.
	 * 
	 ********************************************************************************************************************/
	public String getX3D(boolean snipet) {
		
		// Assembe the SemiCircularCanals
		String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
		"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n " +
		"<X3D profile='Immersive' >\n" +
		"<head>\n" +
		 "<meta name='BioMightImage' content='SemiCircularCanals.jpg'/>\n" +
		 "<meta name='ExportTime' content='7:45:30'/>\n" +
		 "<meta name='ExportDate' content='08/15/2008'/>\n" +
		 "<meta name='BioMight Version' content='1.0'/>\n" + 
		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='SemiCircularCanals'\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		

		String body = ""; 
		System.out.println("Assembling X3D for SemiCircularCanals");
		
		// Run through the collection of eyes and assemble the X3D for each
		for (int i=0; i<semiCircularCanals.size(); i++)
		{
			// Get the information for the eye
			SemiCircularCanal semiCircularCanal = (SemiCircularCanal) semiCircularCanals.get(i);
			System.out.println("Getting X3D for SemiCircularCanal");
			body += semiCircularCanal.getX3D(true);
		}		
		

		System.out.println("SemiCircularCanals X3D: " + body);		
		
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

}
