/*
 * Created on Jul 15, 2007
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.body.head.eye;

import java.util.ArrayList;

import javax.naming.InitialContext;

import biomight.BioMightBase;
import biomight.Constants;
import biomight.cell.misc.Keratocytes;
import biomight.ejb.BioMightBeanLocal;
import biomight.exceptions.ServerException;
import biomight.view.BioMightMethodView;
import biomight.view.BioMightPropertyView;
import biomight.view.BioMightSphere;
import biomight.view.BioMightTransform;
import biomight.view.BioMightTransforms;

/**
 * @author SurferJim
 * 
 * It is fibrous, tough, unyielding, and perfectly transparent.  Composed of about 200 flattened lamellæ, 
 * superimposed one on another. The lamellæ are produced by keratocytes, which occupy about 10% of the 
 * substantia propria. 
 * 
 * These lamellæ are made up of bundles of modified connective tissue, the fibres of which are 
 * directly continuous with those of the sclera. More collagen fibres run in a temporal-nasal direction 
 * than run in the superior-inferior direction. 
 * 
 *  In conjunctival cells, neutrophils were seen in the epithelium and substantia propria, 
 *  but plasma cells, NK cells and mast cells were present only in the substantia propria.
 * 
 */

public class SubstantiaPropria extends BioMightBase {
	private BioMightTransforms bioMightTransforms;
	private ArrayList<BioMightPropertyView> properties;
	private ArrayList<BioMightMethodView> methods;
	private BioMightSphere bioMightSphere;
	private SubstantiaPropriaLamellae substantiaPropriaLamellae;
	private Keratocytes keratocytes;

	
	
	public SubstantiaPropria()
	{
		create(Constants.SubstantiaPropria, null);
	}
	
	
	public SubstantiaPropria(String parentID)
	{
		create(parentID, null);
	}
	
	public SubstantiaPropria(String parentID, ArrayList<BioMightMethodView> bioMightMethods)
	{
		create(parentID, bioMightMethods);
	}
	
	
	public void create(String parentID, ArrayList<BioMightMethodView> bioMightMethods)
	{
		setImage("images/SubstantiaPropria.jpg");
		setImageHeight(300);
		setImageWidth(300);

		
		// Get the information from the database via the Enterprise Bean		
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Getting SubstantiaPropriaInfo for ParentID: " + parentID);
			InitialContext ctx = new InitialContext();
			BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
			bioMightTransforms = bioMightBean.getComponents(Constants.SubstantiaPropriaRef, parentID);
			System.out.println("Have SubstantiaPropria Info from EJB");   	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - SubstantiaPropria");
			throw new ServerException("Remote Exception getComponents():", e); 	
		}
			
		// Run through the collection of Pupils and build them into the model
		// In the default case, we get one instance of the Pupil for each eye
		ArrayList transforms = bioMightTransforms.getTransforms();
		System.out.println("Have SubstantiaPropria NumTransforms: " + transforms.size());
		for (int i=0; i<transforms.size(); i++)
		{
			// Get the information for the eye we are creating
			BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
			System.out.println("Creating SubstantiaPropria (name,id): " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
			
			int view = Constants.VIEW_FLOATING;
			if (view == Constants.VIEW_FLOATING)
			{
				//lips = new Lips(bioMightTransform.getId(), bioMightMethods);
				//System.out.println("In SubstantiaPropria - Created Lips");
		
			}
			else if (view == Constants.VIEW_DETACHED)
			{
				//lips = new Lips(bioMightTransform.getId());			
				//teeth = new  Teeth();
			}
			else
			{
				//teeth = new  Teeth();
				//tongue = new  Tongue();
				//salivaryGlands = new  SalivaryGlands();
			}	
		}		
	
		initProperties();
		initMethods();
		System.out.println("Created SubstantiaPropria");
	}
	
	
	
	
	public void redraw(String parentID)
	{
		int view = Constants.VIEW_FLOATING;
		if (view == Constants.VIEW_FLOATING)
		{
			System.out.println("SubstantiaPropria - Redraw");
		}
		
		//init3D(position);
		initProperties();
		initMethods();
		System.out.println("SubstantiaPropria Redraw");
	}	
	
	
	public void initProperties() {

		properties = new ArrayList<BioMightPropertyView>();

		BioMightPropertyView property = new BioMightPropertyView();
		property.setPropertyName("Lips");
		property.setCanonicalName(Constants.Lips);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("Teeth");
		property.setCanonicalName(Constants.Teeth);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("Tongue");
		property.setCanonicalName(Constants.Tongue);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("Salivary Glands");
		property.setCanonicalName(Constants.SalivaryGlands);
		properties.add(property);
	}
	

	public void initMethods() {

		methods = new ArrayList<BioMightMethodView>();
		
		BioMightMethodView method = new BioMightMethodView();

		method = new BioMightMethodView();
		method.setMethodName("Reproduce");
		method.setHtmlType("checkbox");
		methods.add(method);	
		
		method = new BioMightMethodView();
		method.setMethodName("Mate");
		method.setHtmlType("text");
		methods.add(method);	

		method = new BioMightMethodView();
		method.setMethodName("Lyse");
		method.setHtmlType("text");
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
		 "<meta name='BioMightImage' content='SubstantiaPropria.jpg'/>\n" +
		 "<meta name='ExportTime' content='7:45:30'/>\n" +
		 "<meta name='ExportDate' content='08/15/2008'/>\n" +
		 "<meta name='BioMight Version' content='1.0'/>\n" + 
		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='SubstantiaPropria'\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		

		System.out.println("Assembling SubstantiaPropria X3D");
		String body = "";
			//lips.getX3D(true)''
			 
		
		//System.out.println("SubstantiaPropria X3D: " + body);		
		
		String footer = "</Scene>" + "</X3D>\n";
		
		if (snipet)
			return body;			
		else	
			return header + body + footer;
	}	


	public void onMessage(String messageType)
	{
		
		// Something is touching the tounge.  The nerves in the tounge
		// will send a message to the Brain and ----- cells will release
		// solvents.
		if (messageType.equals("CHEW"))
		{
			// Send a message to the brain
			
			// Start Digestion
		}

		// Flip the tounge to move the food into the
		// ready to swallow position
		if (messageType.equals("SWALLOW"))
		{
			// Send a message to the object to
			// reposition it in the model.
			// sendMessage();
		}		


		// Carry out messages delivered from the brain
		if (messageType.equals("SPIT"))
		{
			// Send a message to the brain
			// Start Digestion 
		}		


		// Carry out messages delivered from the brain
		if (messageType.equals("EXPOSE TONGUE"))
		{
			// Send a message to the brain
			// Start Digestion 
		}	
			
	}

	public void Ingest()
	{
		// This is the first step of digestion, 
		// placing food in one's substantiaPropria
	}

	public void Chew()
	{
		// Mastication
	}


	public void Salivate()
	{
		
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
