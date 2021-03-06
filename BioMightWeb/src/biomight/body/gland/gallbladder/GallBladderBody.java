/*
 * Created on May 3, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.body.gland.gallbladder;

import java.util.ArrayList;

import javax.naming.InitialContext;

import biomight.BioMightBase;
import biomight.Constants;
import biomight.ejb.BioMightBeanLocal;
import biomight.exceptions.ServerException;
import biomight.system.tissue.epithelial.EpitheliumTissue;
import biomight.view.BioMightMethodView;
import biomight.view.BioMightPropertyView;
import biomight.view.BioMightTransform;

/**
 * @author SurferJim
 *
 * Representation of the GallBladderBody
 */

public class GallBladderBody extends BioMightBase {
private EpitheliumTissue epithelium;
	
	
	public GallBladderBody()
	{
		create(Constants.BodyRef, null);
	}

	public GallBladderBody(String parentID)
	{
		create(parentID, null);
	}

	
	public GallBladderBody(String parentID, ArrayList<BioMightMethodView> bioMightMethods)
	{
		create(parentID, null);
	}
	
	public void create(String parentID, ArrayList<BioMightMethodView> bioMightMethods)
	{
		this.setImage("images/GallBladderBody.jpg");
		this.setImageHeight(300);
		this.setImageWidth(300);
	
		// Get the information from the database via the Enterprise Bean		
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Getting GallBladderBodyInfo for ParentID: " + parentID);
			InitialContext ctx = new InitialContext();
			BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
			bioMightTransforms = bioMightBean.getComponents(Constants.GallBladderBodyRef, parentID);   	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - GallBladderBody");
			throw new ServerException("Remote Exception getComponents():", e); 	
		}
			
		// Run through GallBladderBody and build them into the model
		ArrayList transforms = bioMightTransforms.getTransforms();
		System.out.println("GallBladderBody NumTransforms: " + transforms.size());
		for (int i=0; i<transforms.size(); i++)
		{
			// Get the information for the GallBladderBody we are creating
			BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
			System.out.println("Creating GallBladderBody (name,id): " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
			componentID = bioMightTransform.getId();
			
			// Create the Epithelium for the GallBladderBody
			epithelium = new EpitheliumTissue("GallBladderBodyEpithelium", bioMightTransform.getId(), bioMightMethods);
			initProperty(bioMightTransform.getName(), Constants.EpitheliumTissue, Constants.EpitheliumTissueRef, epithelium.getComponentID());
					
			System.out.println("GallBladderBody completed");			
		}		


		//initProperties();
		initMethods();
	}
	
	
	
	public void initProperties() {

		properties = new ArrayList<BioMightPropertyView>();
		
		BioMightPropertyView property = new BioMightPropertyView();
		property.setPropertyName("Common");
		property.setCanonicalName(Constants.Title);
		properties.add(property);

	}
	
	
	public void initMethods() {
		methods = new ArrayList<BioMightMethodView>();

		BioMightMethodView method = new BioMightMethodView();

		method = new BioMightMethodView();
		method.setMethodName("Turn");
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
		
		// Assemble the GallBladderBody
		String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
		"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n " +
		"<X3D profile='Immersive' >\n" +
		"<head>\n" +
		 "<meta name='BioMightImage' content='GallBladderBody.jpg'/>\n" +
		 "<meta name='ExportTime' content='7:45:30'/>\n" +
		 "<meta name='ExportDate' content='08/15/2008'/>\n" +
		 "<meta name='BioMight Version' content='1.0'/>\n" + 
		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='GallBladderBody'\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		

		String body = 
			epithelium.getX3D(true);
		//System.out.println("GallBladderBody X3D: " + body);		
		String footer = "</Scene>" + "</X3D>\n";
		
		if (snipet)
			return body;			
		else	
			return header + body + footer;
	}
	

	
}
