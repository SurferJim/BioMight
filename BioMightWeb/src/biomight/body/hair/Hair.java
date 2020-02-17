/*
 * Created on Jul 7, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.body.hair;

import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.naming.InitialContext;

import biomight.BioMightBase;
import biomight.Constants;
import biomight.ejb.BioMightBeanLocal;
import biomight.exceptions.DataSecurityException;
import biomight.exceptions.ServerException;
import biomight.view.BioMightMethodView;
import biomight.view.BioMightPropertyView;
import biomight.view.BioMightTransform;
import biomight.view.BioMightTransforms;

/*******************************************************************************************
 * @author SurferJim
 *
 * Representation of the Human Hair
 * 
 ******************************************************************************************/
public class Hair extends BioMightBase {
	private BioMightTransforms bioMightTransforms;
	private HairShaft hairShaft;
	private String componentID="";
	private ArrayList<BioMightPropertyView> properties;
	private ArrayList<BioMightMethodView> methods;
	
	
	public Hair()
	{
		create(Constants.Hair, null);
	}

	public Hair(String parentID)
	{
		create(parentID, null);
	}

	public Hair(String parentID, ArrayList<BioMightMethodView> bioMightMethods)
	{
		create(parentID, bioMightMethods);
	}
	
	public void create(String parentID, ArrayList<BioMightMethodView> bioMightMethods)
	{
		this.setImage("images/Hair.jpg");
		this.setImageHeight(300);
		this.setImageWidth(300);
		
		
		// Generate the Hair		
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Creating the Hair for parent: " + Constants.HairShaftRef+":0");
			InitialContext ctx = new InitialContext();
			BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
			int insertFlag = bioMightBean.generateHair(parentID); 
			System.out.println("Have ScalpHair Info from EJB");   	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - ScalpHair");
			throw new ServerException("Remote Exception getComponents():", e); 	
		}
				
		// Get the information from the database via the Enterprise Bean		
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Getting ScalpHairInfo for ParentID: " + parentID);
			InitialContext ctx = new InitialContext();
			BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
			bioMightTransforms = bioMightBean.getComponents(Constants.ScalpHairRef, parentID);
			System.out.println("Have ScalpHair Info from EJB");   	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - ScalpHair");
			throw new ServerException("Remote Exception getComponents():", e); 	
		}
			
		// Run through the collection of Hair Shafts and build them into the model
		ArrayList transforms = bioMightTransforms.getTransforms();
		System.out.println("Have Hair Info NumTransforms: " + transforms.size());
		BioMightTransform bioMightTransform;
		for (int i=0; i<transforms.size(); i++)
		{
			// Get the information for the Hair we are creating
			bioMightTransform = (BioMightTransform) transforms.get(i);
			//System.out.println("Creating ScalpHair (name,id): " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
				
			componentID = bioMightTransform.getId();
			hairShaft = new HairShaft(bioMightTransform.getId());
			//System.out.println("Hair completed");		
		}		
				
		/*int viewPerspective = Constants.VIEW_FLOATING;
		if (viewPerspective == Constants.VIEW_FLOATING) {
			System.out.println("Sclera Eye is created");
		} 
		else if (viewPerspective == Constants.VIEW_INTERNAL) {
		}
		*/
		
		System.out.println("Creating the Hair for Head: " + parentID);
		initProperties();
		initMethods();
	}	
	

	public void redraw(String headReference)
	{		
		System.out.println("Hair Redraw");
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
	
	
		/***
		for (int alpha=0; alpha<16; alpha++)
		{	
			// Allocate the Coordinate-Point Array for Polygon 
			BioMightPositions coordpoint = new BioMightPositions();
			
			coordinateString = 				
						

			System.out.println("HairCoordStr: " + coordinateString); 
			String[] coords = coordinateString.split(",", 24);
			System.out.println("After Split: " + coords[0]+coords[1]+coords[2]+coords[3]); 
			
			// Store the Coordinate Points in BioMightPosition objects
			int j=0;
			for (int i=0;i<=11;i+=3)
			{
				BioMightPosition vertex = new BioMightPosition();
				
				vertex.setXPos(Double.valueOf(coords[i]));
				vertex.setYPos(Double.valueOf(coords[i+1]));
				vertex.setZPos(Double.valueOf(coords[i+2]));
				System.out.println("Storing Coordinates: " + j +    "  x: " + coords[i] + " y: " + coords[i+1] + " z: " + coords[i+2]);	
				coordpoint.setBioMightPosition(j++, vertex);
			}

			// Store the lower plane
			for (int i=0;i<=11;i+=3)
			{
				BioMightPosition vertex = new BioMightPosition();
				
				vertex.setXPos(Double.valueOf(coords[i]));
				vertex.setYPos(Double.valueOf(coords[i+1]));
				vertex.setZPos(Double.valueOf(coords[i+2])-0.02);
				System.out.println("Storing Coordinates: " + j +    "  x: " + coords[i] + " y: " + coords[i+1] + " z: " + coords[i+2]);	
				coordpoint.setBioMightPosition(j++, vertex);
			}
			
			***/
	
	
	/********************************************************************************************************************
	 * GET X3D
	 * 
	 * This method will return the X3D for the Cell.  It runs through each of its components and collects up their
	 * representations and then assembles them into one unified X3D model.
	 * 
	 ********************************************************************************************************************/
	public String getX3D(boolean snipet) {
		
		// Assemble the Hair
		String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
		"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n " +
		"<X3D profile='Immersive' >\n" +
		"<head>\n" +
		 "<meta name='BioMightImage' content='Hair.jpg'/>\n" +
		 "<meta name='ExportTime' content='7:45:30'/>\n" +
		 "<meta name='ExportDate' content='08/15/2008'/>\n" +
		 "<meta name='BioMight Version' content='1.0'/>\n" + 
		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='Hair'\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		

		String body="";
		
		// Run through the collection of Pupils and build them into the model
		// In the default case, we get one instance of the Pupil for each eye
		ArrayList transforms = bioMightTransforms.getTransforms();
		for (int i=0; i<transforms.size(); i++)
		{
			// Get the information for the PinnaAntiHelix we are creating
			BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
			System.out.println("Getting HairShaft X3D: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
		
			int view = Constants.VIEW_FLOATING;
			if (view == Constants.VIEW_FLOATING)
			{
				// Change the height and width based on the displacement.
				body += "<Transform DEF='HairShaft'\n" +
		 			"translation='" + bioMightTransform.getTranslation().getXPos() + " " 
			 					+ bioMightTransform.getTranslation().getYPos() + " "
			 					+ bioMightTransform.getTranslation().getZPos() + "'\n" +
			 		"scale='" 	+ bioMightTransform.getScale().getXPos() + " "
			 				+ bioMightTransform.getScale().getYPos() + " "
			 				+ bioMightTransform.getScale().getZPos() + "'>\n" +
					"<Shape DEF='HairShaft'\n" +
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
						 	"<IndexedFaceSet DEF='HairShaftIFS' \n" +
						    	   "containerField='geometry' \n" +
						    	   "creaseAngle='" +  bioMightTransform.getCreaseAngle() + "'\n" +
						    	   "coordIndex='" + bioMightTransform.getCoordindexStr() + "'>" +
						    	   "<Coordinate DEF='HairShaft_Coord' \n" +
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
	
		
		//System.out.println("Hair X3D: " + body);		
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
