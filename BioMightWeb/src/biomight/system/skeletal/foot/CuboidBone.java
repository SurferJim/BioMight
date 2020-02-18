/*
* Created on Jul 5, 2006
*
* BioMight Component Class - Feb 2007
*
*/
package biomight.system.skeletal.foot;
import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.naming.InitialContext;



import biomight.Constants;
import biomight.body.head.ear.Auricle;
import biomight.body.head.ear.Cochlea;
import biomight.body.head.ear.ExternalCanal;
import biomight.body.head.ear.Malleus;
import biomight.body.head.ear.Saccule;
import biomight.body.head.ear.SemiCircularCanals;
import biomight.body.head.ear.Stapes;
import biomight.body.head.ear.TympanicMembrane;
import biomight.ejb.BioMightBeanLocal;
import biomight.exceptions.DataSecurityException;
import biomight.exceptions.ServerException;
import biomight.system.tissue.connective.bone.Bone;
import biomight.view.BioMightMethodView;
import biomight.view.BioMightPropertyView;
import biomight.view.BioMightTransform;
import biomight.view.BioMightTransforms;

/**
* @author SurferJim
*
* BioMight Component Class - Feb 2007
*
*/
public class CuboidBone extends Bone {
	private BioMightTransforms bioMightTransforms;
	private ArrayList<BioMightPropertyView> properties;
	private ArrayList<BioMightMethodView> methods;
	private String componentID;
	private String parentID;	
	
	
	public CuboidBone()
	{
		create(Constants.LungHilum, null);
	}

	public CuboidBone(String parentID)
	{
		create(parentID, null);
	}
	
	public CuboidBone(String parentID, ArrayList<BioMightMethodView> bioMightMethods)
	{
		create(parentID, bioMightMethods);
	}
		
	
	public void create(String parentID, ArrayList<BioMightMethodView> bioMightMethods)
	{
		this.setImage("images/LungHilum.jpg");
		this.setImageHeight(300);
		this.setImageWidth(300);
	
		
		// Get the information from the database via the Enterprise Bean		
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Getting CuboidBoneInfo for ParentID: " + parentID);
			InitialContext ctx = new InitialContext();
			BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
			bioMightTransforms = bioMightBean.getComponents(Constants.CuboidBoneRef, parentID);
			System.out.println("Have CuboidBone Info from EJB");   	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - CuboidBone");
			throw new ServerException("Remote Exception getComponents():", e); 	
		}
			
		// Run through the collection of LungHilums and build them into the model
		// In the default case, we get one instance of the LungHilum for each eye
		ArrayList transforms = bioMightTransforms.getTransforms();
		System.out.println("LungHilum NumTransforms: " + transforms.size());
		for (int i=0; i<transforms.size(); i++)
		{
			// Get the information for the eye we are creating
			BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
			System.out.println("Created CuboidBone: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
			this.componentID = bioMightTransform.getId();
			
			//System.out.println("Creating Auricle for CuboidBone");
			//auricle = new Auricle(bioMightTransform.getId());
			//System.out.println("CuboidBone - Auricle is created");
			
			/*int viewPerspective = Constants.VIEW_DETACHED;
			if (viewPerspective == Constants.VIEW_DETACHED)
			{				
				// Create the components of the curvature

			}*/
		}
		initProperties();
		initMethods();
		
		System.out.println("CreateLungHilum Completed");
		
		// First, get all the data from the database
		// Apply the methods to it
		// Save its state
		this.parentID = parentID;
		if (bioMightMethods != null){
			System.out.println("EXECUTING LungHilum METHODS: " + bioMightMethods.size());
			//executeMethods(bioMightMethods);
		}
	}
	
	
	
	public void initProperties() {

		properties = new ArrayList<BioMightPropertyView>();
		
		BioMightPropertyView property = new BioMightPropertyView();
		

		property.setPropertyName("Outer CuboidBone");
		property.setCanonicalName(Constants.Title);
		properties.add(property);
		

		property.setPropertyName("Inner CuboidBone");
		property.setCanonicalName(Constants.Title);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("VestibularNerve");
		property.setCanonicalName(Constants.VestibularNerve);
		properties.add(property);
	
		property = new BioMightPropertyView();
		property.setPropertyName("Cochlea");
		property.setCanonicalName(Constants.Cochlea);
		properties.add(property);		
	
		property = new BioMightPropertyView();
		property.setPropertyName("ExternalCanal");
		property.setCanonicalName(Constants.ExternalCanal);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("Malleus");
		property.setCanonicalName(Constants.Malleus);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("SemiCircularCanals");
		property.setCanonicalName(Constants.SemiCircularCanals);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("Stapes");
		property.setCanonicalName(Constants.Stapes);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("TympanicMembrane");
		property.setCanonicalName(Constants.TympanicMembrane);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("Saccule");
		property.setCanonicalName(Constants.Saccule);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("Utricle");
		property.setCanonicalName(Constants.Utricle);
		properties.add(property);
		

	}
	
	
	public void initMethods() {

		methods = new ArrayList<BioMightMethodView>();
		
		BioMightMethodView method = new BioMightMethodView();

		method = new BioMightMethodView();
		method.setMethodName("Deaf");
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
	 *******************************************************************************************************************/
	public String getX3D(boolean snipet) {
		
		// Assembe the CuboidBone
		String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
		"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n " +
		"<X3D profile='Immersive' >\n" +
		"<head>\n" +
		 "<meta name='BioMightImage' content='CuboidBone.jpg'/>\n" +
		 "<meta name='ExportTime' content='7:45:30'/>\n" +
		 "<meta name='ExportDate' content='08/15/2008'/>\n" +
		 "<meta name='BioMight Version' content='1.0'/>\n" + 
		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='CuboidBone'\n" +
		"info='\"BioMight Generated X3D\"'/>\n";			
		
		viewPerspective = Constants.VIEW_FLOATING;
		// Construct the ear based on the View Perspective. We only want to 
		// activate those components that comprise the view
		String body = "";
		if (viewPerspective == Constants.VIEW_FLOATING) {
			System.out.println("Getting X3D for CuboidBone");
			body = "";
		} else if (viewPerspective == Constants.VIEW_INTERNAL) {
			body = "";
		} else if (viewPerspective == Constants.VIEW_DETACHED) {
			body = "";
		}
		
		System.out.println("CuboidBone X3D: " + body);		
		
		String footer = "</Scene>" + "</X3D>\n";
		
		if (snipet)
			return body;			
		else	
			return header + body + footer;
	}
	

}
