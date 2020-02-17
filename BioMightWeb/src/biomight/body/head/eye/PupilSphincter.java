/*
 * Created on Jul 3, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.body.head.eye;

import java.util.ArrayList;

import javax.naming.InitialContext;

import biomight.BioMightBase;
import biomight.Constants;
import biomight.body.head.ear.BasilarMembrane;
import biomight.body.head.ear.Helicotrema;
import biomight.body.head.ear.OrganOfCorti;
import biomight.body.head.ear.ReissnersMembrane;
import biomight.body.head.ear.ScalaMedia;
import biomight.body.head.ear.ScalaTympani;
import biomight.body.head.ear.ScalaVestibuli;
import biomight.ejb.BioMightBeanLocal;
import biomight.exceptions.ServerException;
import biomight.view.BioMightMethodView;
import biomight.view.BioMightPropertyView;
import biomight.view.BioMightTransform;
import biomight.view.BioMightTransforms;

/**
 * @author SurferJim
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class PupilSphincter extends BioMightBase {
	private BioMightTransforms bioMightTransforms;
	private String componentID;
	private String parentID;
	private ArrayList<BioMightPropertyView> properties;
	private ArrayList<BioMightMethodView> methods;

	public PupilSphincter()
	{
		create(Constants.PupilSphincter, null);
	}

	public PupilSphincter(String parentID)
	{
		create(parentID, null);
	}
	
	public PupilSphincter(String parentID, ArrayList<BioMightMethodView> bioMightMethods)
	{
		create(parentID, bioMightMethods);
	}

	
	public void create(String parentID, ArrayList<BioMightMethodView> bioMightMethods)
	{
		this.setImage("images/PupilSphincter.jpg");
		this.setImageHeight(300);
		this.setImageWidth(300);
	
		
		// Get the information from the database via the Enterprise Bean		
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Getting PupilSphincterInfo for ParentID: " + parentID);
			InitialContext ctx = new InitialContext();
			BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
			bioMightTransforms = bioMightBean.getComponents(Constants.PupilSphincterRef, parentID);
			System.out.println("Have PupilSphincter Info from EJB");   	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - PupilSphincter");
			throw new ServerException("Remote Exception getComponents():", e); 	
		}

			
		// Run through the collection of PupilSphincters and build them into the model
		// In the default case, we get one instance of the PupilSphincter for each eye
		ArrayList transforms = bioMightTransforms.getTransforms();
		System.out.println("PupilSphincter NumTransforms: " + transforms.size());
		for (int i=0; i<transforms.size(); i++)
		{
			// Get the information for the eye we are creating
			BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
			System.out.println("Created PupilSphincter: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
			this.componentID = bioMightTransform.getId();
			
		
			//bioMightMethods.scalaVestibuli  = new ScalaVestibuli(bioMightTransform.getId(), bioMightMethods);

			
			System.out.println("Creating PupilSphincter Endothelium: " + bioMightTransform.getId());				
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
		
		System.out.println("CreatePupilSphincter Completed");
		
		// First, get all the data from the database
		// Apply the methods to it
		// Save its state
		this.parentID = parentID;
		if (bioMightMethods != null){
			System.out.println("EXECUTING PupilSphincter METHODS: " + bioMightMethods.size());
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
	 * This method will return the X3D for the PupilSphincter.  It runs through each of its components and collects up their
	 * representations and then assembles them into one unified X3D model.
	 * 
	 ********************************************************************************************************************/
	public String getX3D(boolean snipet) {
		
		// Assembe the PupilSphincter
		String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
		"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n " +
		"<X3D profile='Immersive' >\n" +
		"<head>\n" +
		 "<meta name='BioMightImage' content='PupilSphincter.jpg'/>\n" +
		 "<meta name='ExportTime' content='7:45:30'/>\n" +
		 "<meta name='ExportDate' content='08/15/2008'/>\n" +
		 "<meta name='BioMight Version' content='1.0'/>\n" + 
		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='PupilSphincter'\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		

		String body =  ""; 
			//stereocilia.getX3D(true);
		
		
		System.out.println("PupilSphincter X3D: " + body);		
		
		String footer = "</Scene>" + "</X3D>\n";
		
		if (snipet)
			return body;			
		else	
			return header + body + footer;
	}
	
	
}
