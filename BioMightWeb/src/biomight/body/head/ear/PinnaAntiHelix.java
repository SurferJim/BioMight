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
import biomight.system.cartilage.Cartilage;
import biomight.system.tissue.epithelial.EpitheliumTissue;
import biomight.view.BioMightColor;
import biomight.view.BioMightMethodView;
import biomight.view.BioMightPolygon;
import biomight.view.BioMightPolygons;
import biomight.view.BioMightPosition;
import biomight.view.BioMightPositions;
import biomight.view.BioMightPropertyView;
import biomight.view.BioMightSphere;
import biomight.view.BioMightTransform;
import biomight.view.BioMightTransforms;

/**
 * @author SurferJim
 *
 * Representation of the PinnaAntiHelix.  Comprised of cartilage
 * 
 */

public class PinnaAntiHelix  extends BioMightBase {
	private ArrayList<BioMightPropertyView> properties;
	private ArrayList<BioMightMethodView> methods;
	private BioMightTransforms bioMightTransforms;
	private EpitheliumTissue epithelium;
	private String componentID = "";
	
	
	// Set up a block of Cartilage that comprises the AntiHelix
	//Cartilage[][][] cartilage;
	
	
	public PinnaAntiHelix()
	{		
		createPinnaAntiHelix(Constants.EarRef, null);
	}

	/****
	 * 
	 * This position is delivered from the Auricle and will be a displacement from its center point
	 * @param bioMightPosition
	 */

	public PinnaAntiHelix(String parentID)
	{		
		createPinnaAntiHelix(parentID, null);
	}
	
	
	public PinnaAntiHelix(String parentID, ArrayList<BioMightMethodView> bioMightMethods)
	{		
		createPinnaAntiHelix(parentID, bioMightMethods);
	}
	

	/**************************************************************
	 * Create PinaAntiHelix 
	 * 
	 * 
	 **************************************************************/
	public void createPinnaAntiHelix(String parentID, ArrayList<BioMightMethodView> bioMightMethods)
	{		
		this.setImage("images/PinnaAntiHelix.jpg");
		
		// Get the information from the database via the Enterprise Bean		
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Getting PinnaAntiHelixInfo for ParentID: " + parentID);
			InitialContext ctx = new InitialContext();
			BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
			bioMightTransforms = bioMightBean.getComponents(Constants.PinnaAntiHelixRef, parentID);
			System.out.println("Have PinnaAntiHelix Info from EJB");   	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - PinnaAntiHelix");
			throw new ServerException("Remote Exception getComponents():", e); 	
		}

		properties = new ArrayList<BioMightPropertyView>();
			
		// Run through the collection of Pupils and build them into the model
		// In the default case, we get one instance of the Pupil for each eye
		ArrayList transforms = bioMightTransforms.getTransforms();
		System.out.println("Have PinaAntiHelix NumTransforms: " + transforms.size());
		for (int i=0; i<transforms.size(); i++)
		{
			// Get the information for the eye we are creating
			BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
			System.out.println("Creating PinnaAntiHelix (name,id): " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
			
			componentID = bioMightTransform.getId();
			
			
			System.out.println("Creating PinnaAntiHelix Epithelium: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());			
			epithelium = new EpitheliumTissue("EarEpithelium", bioMightTransform.getId(), bioMightMethods);
			initProperty("EpitheliumTissue", Constants.EpitheliumTissue, Constants.EpitheliumTissueRef, epithelium.getComponentID());
			
			
			/*int viewPerspective = Constants.VIEW_FLOATING;
			if (viewPerspective == Constants.VIEW_FLOATING) {
				System.out.println("Iris Eye is created");
			} 
			else if (viewPerspective == Constants.VIEW_INTERNAL) {
			}
			*/
		}		
	
		System.out.println("Create PinaAntiHelix Completed: " + parentID);
		
		initProperties();
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
	
	public void initProperties() {

		properties = new ArrayList<BioMightPropertyView>();
		
		BioMightPropertyView property = new BioMightPropertyView();
		property.setPropertyName("Stapes ---");
		property.setCanonicalName(Constants.LeftEar);
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
	

	
	public void redraw(String parentID)
	{			
		System.out.println("PinnaAnitHelix - Redraw");
	}

	
	/********************************************************************************************************************
	 * GET X3D
	 * 
	 * This method will return the X3D for the Cell.  It runs through each of its components and collects up their
	 * representations and then assembles them into one unified X3D model.
	 * 
	 ********************************************************************************************************************/
	public String getX3D(boolean snipet) {
		
		// Assemble the PinnaAntiHelix
		String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
		"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n " +
		"<X3D profile='Immersive' >\n" +
		"<head>\n" +
		 "<meta name='BioMightImage' content='PinnaAntiHelix.jpg'/>\n" +
		 "<meta name='ExportTime' content='7:45:30'/>\n" +
		 "<meta name='ExportDate' content='08/15/2008'/>\n" +
		 "<meta name='BioMight Version' content='1.0'/>\n" + 
		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='PinnaAntiHelix'\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		

		
		String body = epithelium.getX3D(true);

		
		//System.out.println("PinnaAntiHelix X3D: " + body);		
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
	
}
