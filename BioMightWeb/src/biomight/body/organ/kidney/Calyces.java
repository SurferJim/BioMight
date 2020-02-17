/*
 * Created on Jul 10, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.body.organ.kidney;

import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.naming.InitialContext;

import biomight.BioMightBase;
import biomight.Constants;
import biomight.body.arm.Arm;
import biomight.ejb.BioMightBeanLocal;
import biomight.exceptions.DataSecurityException;
import biomight.exceptions.ServerException;
import biomight.view.BioMightMethodView;
import biomight.view.BioMightPropertyView;
import biomight.view.BioMightTransform;
import biomight.view.BioMightTransforms;

/**
 * @author SurferJim
 *
 * Representation of a Calyces.  
 * 
 */

public class Calyces extends BioMightBase {
	private ArrayList calyces;
	private BioMightTransforms bioMightTransforms; 
	private ArrayList<BioMightPropertyView> properties;
	private ArrayList<BioMightMethodView> methods;
	private String componentID;
	
	
	public Calyces()
	{		
		// Create hte base Eye
		create(Constants.HipRef, null);
	}
	
	
	public Calyces(String parentID)
	{				
		create(parentID, null);	
	}
	

	public Calyces(String parentID, ArrayList<BioMightMethodView> bioMightMethods)
	{				
		create(parentID, bioMightMethods);	
	}
	
	
	public void create(String parentID, ArrayList<BioMightMethodView> bioMightMethods)
	{
		this.setImage("images/Calyces.jpg");
		this.setImageHeight(300);
		this.setImageWidth(300);
		
		calyces = new ArrayList();
		
		// Get the information from the database via the Enterprise Bean		
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Getting CalycesInfo for ParentID: " + parentID);
			InitialContext ctx = new InitialContext();
			BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
			bioMightTransforms = bioMightBean.getComponents(Constants.CalyxRef, parentID);
			System.out.println("Have Calyces Info from EJB");   	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - Calyces");
			throw new ServerException("Remote Exception getComponents():", e); 	
		}
		
		// This is a collection, so set the parent of the children
		// to that of the aggregation object
		componentID = parentID;
		properties = new ArrayList<BioMightPropertyView>();
		
		// Run through the collection of Calyces thst are associated with the parent,
		// which in many cases is the liver.  
		ArrayList transforms = bioMightTransforms.getTransforms();
		for (int i=0; i<transforms.size(); i++)
		{
			// Get the information for the calyce we are creating
			BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
			System.out.println("Creating Calyces: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
			
			// Create an instance of the Calyx
			componentID = bioMightTransform.getId();
			Calyx calyx = new Calyx(componentID, bioMightMethods);		
			System.out.println("Calyces Created!: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
			
			calyces.add(calyx);
			System.out.println("Add Calyces to Collection!: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());

			// initialize the Properties
			// in this case, rather than pass canonical name, we pass the name found in the collection
			//initProperty(bioMightTransform.getName(), Constants.Hip, Constants.HipRef, bioMightTransform.getId());
		}
		
	
		initProperties();
		initMethods();
	}
	
	
	public void initProperties() {

		properties = new ArrayList<BioMightPropertyView>();
		
		BioMightPropertyView property = new BioMightPropertyView();
		property.setPropertyName("Stapes ---");
		property.setCanonicalName(Constants.Calyces);
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
	 * This method will return the X3D for the Calyces.  It runs through each of its components and collects up their
	 * representations and then assembles them into one unified X3D model.
	 * 
	 ********************************************************************************************************************/

	public String getX3D(boolean snipet) {
		
		// Assemble the Calyces
		String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
		"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n " +
		"<X3D profile='Immersive' >\n" +
		"<head>\n" +
		 "<meta name='BioMightImage' content='Calyces.jpg'/>\n" +
		 "<meta name='ExportTime' content='7:45:30'/>\n" +
		 "<meta name='ExportDate' content='08/15/2008'/>\n" +
		 "<meta name='BioMight Version' content='1.0'/>\n" + 
		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='Calyces'\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		

		String body = ""; 
		System.out.println("Assembling X3D for Calyces");
		
		// Run through the collection of Arms and assemble the X3D for each
		for (int i=0; i<calyces.size(); i++)
		{
			// Get the information for the Calyx
			Calyx calyx = (Calyx) calyces.get(i);
			//System.out.println("Getting X3D for Calyx");
			body +=calyx.getX3D(true);
		}		
		

		//System.out.println("Calyces X3D: " + body);		
		String footer = "</Scene>" + "</X3D>\n";
		
		if (snipet)
			return body;			
		else	
			return header + body + footer;
	}
	
	
	
	public String getX3DExternal(boolean snipet) {
		
		// Assemble the Calyces
		String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
		"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n " +
		"<X3D profile='Immersive' >\n" +
		"<head>\n" +
		 "<meta name='BioMightImage' content='Calyces.jpg'/>\n" +
		 "<meta name='ExportTime' content='7:45:30'/>\n" +
		 "<meta name='ExportDate' content='08/15/2008'/>\n" +
		 "<meta name='BioMight Version' content='1.0'/>\n" + 
		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='Calyces'\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		

		String body = "";
		
		// Run through the collection of Calyx and build them into the model
		ArrayList transforms = bioMightTransforms.getTransforms();
		for (int i=0; i<transforms.size(); i++)
		{
			// Get the information for the PinnaAntiHelix we are creating
			BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
			System.out.println("Getting ChestEpithelium X3D: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
		
			int view = Constants.VIEW_FLOATING;
			if (view == Constants.VIEW_FLOATING)
			{
				//System.out.println("Getting X3D for ChestEpitheliumX: " + bioMightSphere.getTranslation().getXPos());
				//System.out.println("Getting X3D for ChestEpitheliumY: " + bioMightSphere.getTranslation().getYPos());
				//System.out.println("Getting X3D for ChestEpitheliumZ: " + bioMightSphere.getTranslation().getZPos());
				// Change the height and width based on the displacement.
				body += "<Transform DEF='Calyx'\n" +
		 			"translation='" + bioMightTransform.getTranslation().getXPos() + " " 
			 					+ bioMightTransform.getTranslation().getYPos() + " "
			 					+ bioMightTransform.getTranslation().getZPos() + "'\n" +
			 		"scale='" 	+ bioMightTransform.getScale().getXPos() + " "
			 				+ bioMightTransform.getScale().getYPos() + " "
			 				+ bioMightTransform.getScale().getZPos() + "'>\n" +
					"<Shape DEF='Calyx'\n" +
						    " containerField='children'>\n" +
						    " <Appearance\n" +
						    "  containerField='appearance'>\n" +
						    " <Material DEF='Rust'\n" +
						    "containerField='material'\n" +
						    "ambientIntensity='" + bioMightTransform.getMaterial().getAmbientIntensity() + "'\n" +
						    "shininess='" 		 + bioMightTransform.getMaterial().getShininess() + "'\n" +
						    "transparency='" 	 + bioMightTransform.getMaterial().getTransparency() + "'\n" +
						    "diffuseColor='" + 
						    bioMightTransform.getMaterial().getDiffuseColor().getRed() + " " + 
						    bioMightTransform.getMaterial().getDiffuseColor().getGreen() + " " +
						    bioMightTransform.getMaterial().getDiffuseColor().getBlue() + "'/>\n" +
						 	"</Appearance>\n" +			    
						 	"<IndexedFaceSet DEF='CalyxIFS' \n" +
						    	   "containerField='geometry' \n" +
						    	   "creaseAngle='" +  bioMightTransform.getCreaseAngle() + "'\n" +
						    	   "coordIndex='" + bioMightTransform.getCoordindexStr() + "'>" +
						    	   "<Coordinate DEF='Calyx_Coord' \n" +
						    	    "containerField='coord' point='" +  bioMightTransform.getCoordpointStr() + "'/>" +
						    	  "</IndexedFaceSet>\n" +
					"</Shape>\n" +
			 "</Transform>\n"; 
		}
		else
		{
			body = "";//						
		}
		
		}

		//System.out.println("Calyces X3D: " + body);		
		String footer = "</Scene>" + "</X3D>\n";
		
		if (snipet)
			return body;			
		else	
			return header + body + footer;
	}

}
