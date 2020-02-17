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
 * Representation of a Retinal Cone cell
 * 
 */


public class Cone extends BioMightBase {
	private BioMightTransforms bioMightTransforms;
	private String componentID;
	private String parentID;
	private ArrayList<BioMightPropertyView> properties;
	private ArrayList<BioMightMethodView> methods;
	
	
	public Cone()
	{
		create(Constants.Cone, null);
	}

	public Cone(String parentID)
	{
		create(parentID, null);
	}
	
	public Cone(String parentID, ArrayList<BioMightMethodView> bioMightMethods)
	{
		create(parentID, bioMightMethods);
	}

	
	public void create(String parentID, ArrayList<BioMightMethodView> bioMightMethods)
	{
		this.setImage("images/Cone.jpg");
		this.setImageHeight(300);
		this.setImageWidth(300);
	
		
		// Get the information from the database via the Enterprise Bean		
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Getting ConeInfo for ParentID: " + parentID);
			InitialContext ctx = new InitialContext();
			BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
			bioMightTransforms = bioMightBean.getComponents(Constants.ConeRef, parentID);
			System.out.println("Have Cone Info from EJB");   	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - Cone");
			throw new ServerException("Remote Exception getComponents():", e); 	
		}

			
		// Run through the collection of Cones and build them into the model
		// In the default case, we get one instance of the Cone for each eye
		ArrayList transforms = bioMightTransforms.getTransforms();
		System.out.println("Cone NumTransforms: " + transforms.size());
		for (int i=0; i<transforms.size(); i++)
		{
			// Get the information for the eye we are creating
			BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
			System.out.println("Created Cone: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
			this.componentID = bioMightTransform.getId();
			
			
			System.out.println("Creating Cone Endothelium: " + bioMightTransform.getId());				
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
		
		System.out.println("CreateCone Completed");
		
		// First, get all the data from the database
		// Apply the methods to it
		// Save its state
		this.parentID = parentID;
		if (bioMightMethods != null){
			System.out.println("EXECUTING Cone METHODS: " + bioMightMethods.size());
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
	 * This method will return the X3D for the Cone.  It runs through each of its components and collects up their
	 * representations and then assembles them into one unified X3D model.
	 * 
	 ********************************************************************************************************************/
	public String getX3D(boolean snipet) {
		
		// Assembe the Cone
		String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
		"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n " +
		"<X3D profile='Immersive' >\n" +
		"<head>\n" +
		 "<meta name='BioMightImage' content='Cone.jpg'/>\n" +
		 "<meta name='ExportTime' content='7:45:30'/>\n" +
		 "<meta name='ExportDate' content='08/15/2008'/>\n" +
		 "<meta name='BioMight Version' content='1.0'/>\n" + 
		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='Cone'\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		

		String body =  "";
			//stereocilia.getX3D(true);
		
		
		System.out.println("Cone X3D: " + body);		
		
		String footer = "</Scene>" + "</X3D>\n";
		
		if (snipet)
			return body;			
		else	
			return header + body + footer;
	}
	
	
}
