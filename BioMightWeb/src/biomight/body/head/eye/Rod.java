/*
 * Created on Jul 2, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.body.head.eye;

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
 * Representation of a Rod
 */

public class Rod extends BioMightBase {

	private BioMightTransforms bioMightTransforms;
	private String componentID;
	private String parentID;
	private ArrayList<BioMightPropertyView> properties;
	private ArrayList<BioMightMethodView> methods;
	
	
	public Rod()
	{
		create(Constants.Rod, null);
	}

	public Rod(String parentID)
	{
		create(parentID, null);
	}
	
	public Rod(String parentID, ArrayList<BioMightMethodView> bioMightMethods)
	{
		create(parentID, bioMightMethods);
	}

	
	public void create(String parentID, ArrayList<BioMightMethodView> bioMightMethods)
	{
		this.setImage("images/Rod.jpg");
		this.setImageHeight(300);
		this.setImageWidth(300);
	
		
		// Get the information from the database via the Enterprise Bean		
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Getting RodInfo for ParentID: " + parentID);
			InitialContext ctx = new InitialContext();
			BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
			bioMightTransforms = bioMightBean.getComponents(Constants.RodRef, parentID);
			System.out.println("Have Rod Info from EJB");   	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - Rod");
			throw new ServerException("Remote Exception getComponents():", e); 	
		}

			
		// Run through the collection of Rods and build them into the model
		// In the default case, we get one instance of the Rod for each eye
		ArrayList transforms = bioMightTransforms.getTransforms();
		System.out.println("Rod NumTransforms: " + transforms.size());
		for (int i=0; i<transforms.size(); i++)
		{
			// Get the information for the eye we are creating
			BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
			System.out.println("Created Rod: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
			this.componentID = bioMightTransform.getId();
			
			
			System.out.println("Creating Rod Endothelium: " + bioMightTransform.getId());				
			//endothelium = new EndotheliumTissue(bioMightTransform.getId());
			
			/*int viewPerspective = Constants.VIEW_DETACHED;
			if (viewPerspective == Constants.VIEW_DETACHED)
			{				
				// Create the components of the curvature
			
		  
		  stereocilia = new Stereocilia();

			}*/
		}
		initProperties();
		initMethods();
		
		System.out.println("CreateRod Completed");
		
		// First, get all the data from the database
		// Apply the methods to it
		// Save its state
		this.parentID = parentID;
		if (bioMightMethods != null){
			System.out.println("EXECUTING Rod METHODS: " + bioMightMethods.size());
			//executeMethods(bioMightMethods);
		}
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
	 * This method will return the X3D for the Rod.  It runs through each of its components and collects up their
	 * representations and then assembles them into one unified X3D model.
	 * 
	 ********************************************************************************************************************/
	public String getX3D(boolean snipet) {
		
		// Assembe the Rod
		String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
		"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n " +
		"<X3D profile='Immersive' >\n" +
		"<head>\n" +
		 "<meta name='BioMightImage' content='Rod.jpg'/>\n" +
		 "<meta name='ExportTime' content='7:45:30'/>\n" +
		 "<meta name='ExportDate' content='08/15/2008'/>\n" +
		 "<meta name='BioMight Version' content='1.0'/>\n" + 
		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='Rod'\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		

		String body =  "";
			//stereocilia.getX3D(true);
		
		
		System.out.println("Rod X3D: " + body);		
		
		String footer = "</Scene>" + "</X3D>\n";
		
		if (snipet)
			return body;			
		else	
			return header + body + footer;
	}
	
}
