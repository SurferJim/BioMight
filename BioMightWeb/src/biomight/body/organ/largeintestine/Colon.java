/*
 * Created on Jul 9, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.body.organ.largeintestine;
import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.naming.InitialContext;

import biomight.BioMightBase;
import biomight.Constants;
import biomight.bacteria.cocci.grampositive.StreptococcusFaecalis;
import biomight.ejb.BioMightBeanLocal;
import biomight.exceptions.DataSecurityException;
import biomight.exceptions.ServerException;
import biomight.view.BioMightMethodView;
import biomight.view.BioMightPosition;
import biomight.view.BioMightPropertyView;
import biomight.view.BioMightTransform;
import biomight.view.BioMightTransforms;

/**
 * @author SurferJim *
 * 
 * Representation of the Colon
 * 
 */

public class Colon extends BioMightBase {
	private String componentID = "";
	private BioMightTransforms bioMightTransforms;
	private ArrayList<BioMightPropertyView> properties;
	private ArrayList<BioMightMethodView> methods;	
	private AscendingColon ascendingColon;
	private TransverseColon transverseColon;
	private DescendingColon descendingColon;
	private SigmoidFlexure sigmoidFlexure;
	

	public Colon() {
		create(Constants.ColonRef, null);
	}
	
	public Colon(String parentID) {
		create(parentID, null);
	}


	public Colon(String parentID, ArrayList<BioMightMethodView> bioMightMethods)
	{
		create(parentID, bioMightMethods);
	}
	

	public void create(String parentID, ArrayList<BioMightMethodView> bioMightMethods)
	{
		this.setImage("images/Colon.jpg");
		this.setImageHeight(300);
		this.setImageWidth(300);

		// Get the information from the database via the Enterprise Bean		
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Getting ColonInfo for ParentID: " + parentID);
			InitialContext ctx = new InitialContext();
			BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
			bioMightTransforms = bioMightBean.getComponents(Constants.ColonRef, parentID);
			System.out.println("Have Colon Info from EJB");   	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - Colon");
			throw new ServerException("Remote Exception getComponents():", e); 	
		}
			
		// Run through Colon and build them into the model
		ArrayList transforms = bioMightTransforms.getTransforms();
		System.out.println("Colon NumTransforms: " + transforms.size());
		for (int i=0; i<transforms.size(); i++)
		{
			// Get the information for the Colon we are creating
			BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
			System.out.println("Creating Colon (name,id): " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
			componentID = bioMightTransform.getId();
				
			//ascendingColon = new AscendingColon(bioMightTransform.getId(), bioMightMethods);
			//System.out.println("Creating Ascending Colon for: " + bioMightTransform.getName());


			transverseColon = new TransverseColon(bioMightTransform.getId(), bioMightMethods);
			
			/*
			descendingColon = new DescendingColon(bioMightTransform.getId(), bioMightMethods);
			sigmoidFlexure = new SigmoidFlexure(bioMightTransform.getId(), bioMightMethods);
			*/
		
			
			System.out.println("Colon completed");			
		}			
		initProperties();
		initMethods();
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
	
	/********************************************************************************************************************
	 * GET X3D
	 * 
	 * This method will return the X3D for the Cell.  It runs through each of its components and collects up their
	 * representations and then assembles them into one unified X3D model.
	 * 
	 ********************************************************************************************************************/
	public String getX3D(boolean snipet) {
		
		// Assemble the Colon
		String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
		"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n " +
		"<X3D profile='Immersive' >\n" +
		"<head>\n" +
		 "<meta name='BioMightImage' content='Colon.jpg'/>\n" +
		 "<meta name='ExportTime' content='7:45:30'/>\n" +
		 "<meta name='ExportDate' content='08/15/2008'/>\n" +
		 "<meta name='BioMight Version' content='1.0'/>\n" + 
		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='Colon'\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		


		String body = "";
		/*
			ascendingColon.getX3D(true) +
			transverseColon.getX3D(true) +
			descendingColon.getX3D(true) +
			sigmoidFlexure.getX3D(true);
			*/
		
		System.out.println("Colon X3D: " + body);		
		
		String footer = "</Scene>" + "</X3D>\n";
		
		if (snipet)
			return body;			
		else	
			return header + body + footer;
	}

	
	public void onContact(Object obj)
	{	
		// Check if a bacteria is making contact with
		// the GastroIntestinal components
		if (obj instanceof StreptococcusFaecalis)
		{
			// 
		}
	}

}
