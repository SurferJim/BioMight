/*
 * Created on Feb 03, 2012
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.body.hand;
import java.util.ArrayList;

import javax.naming.InitialContext;



import biomight.Constants;
import biomight.body.BodyPart;
import biomight.ejb.BioMightBeanLocal;
import biomight.exceptions.ServerException;
import biomight.system.tissue.epithelial.EpitheliumTissue;
import biomight.system.tissue.muscle.MuscleTissue;
import biomight.view.BioMightMethodView;
import biomight.view.BioMightPosition;
import biomight.view.BioMightPropertyView;
import biomight.view.BioMightTransform;
import biomight.view.BioMightTransforms;

/**
 * @author SurferJim
 *
 * Representation of the thumb
 */

public class Thumb extends BodyPart {
	protected EpitheliumTissue epithelium;
	
	
	public Thumb()
	{
		create(Constants.Thumb, null);
	}

	public Thumb(String parentID)
	{
		create(parentID, null);
	}
	
	public Thumb(String parentID, ArrayList<BioMightMethodView> bioMightMethods)
	{
		create(parentID, bioMightMethods);
	}

	
	public void create(String parentID, ArrayList<BioMightMethodView> bioMightMethods)
	{
		this.setImage("images/Thumb.jpg");
		this.setImageHeight(300);
		this.setImageWidth(300);
	
			
		// Get the information from the database via the Enterprise Bean		
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Getting ThumbInfo for ParentID: " + parentID);
			InitialContext ctx = new InitialContext();
			BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
			bioMightTransforms = bioMightBean.getComponents(Constants.ThumbRef, parentID);
			System.out.println("Have Thumb Info from EJB");   	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - Thumb");
			throw new ServerException("Remote Exception getComponents():", e); 	
		}
	
		
		// Run through the collection of Thumbs and build them into the model
		// In the default case, we get one instance of the Thumb for each eye
		ArrayList transforms = bioMightTransforms.getTransforms();
		System.out.println("Thumb NumTransforms: " + transforms.size());
		for (int i=0; i<transforms.size(); i++)
		{
			// Get the information for the eye we are creating
			BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
			this.componentID = bioMightTransform.getId();
	
		
			// In most instances,we will just be retrieving data
			// other times we will generate 
			boolean bGenerate = false;
			if (bGenerate) {
				generate(componentID, parentID);
			}
		
			
			System.out.println("Creating ThumbEpithelium: " + bioMightTransform.getId());
			epithelium = new EpitheliumTissue("ThumbEpithelium", bioMightTransform.getId(), bioMightMethods);
			initProperty("ThumbEpithelium", Constants.EpitheliumTissue, Constants.EpitheliumTissueRef, epithelium.getComponentID());
			
			
			/*int viewPerspective = Constants.VIEW_DETACHED;
			if (viewPerspective == Constants.VIEW_DETACHED)
			{				
				// Create the components of the curvature

			}*/
		}
		//initProperties();
		initMethods();
		
		System.out.println("CreateThumb Completed");
		
		// First, get all the data from the database
		// Apply the methods to it
		// Save its state
		this.parentID = parentID;
		if (bioMightMethods != null){
			System.out.println("EXECUTING Thumb METHODS: " + bioMightMethods.size());
			//executeMethods(bioMightMethods);
		}
	}
	
	


	// Create the Finger using a mathematical algorithm
	public void generate(String componentID, String parentID) 
	{
		String startIndex = "00001";
		double circumference = 0.25;
		double[] startPos = {8.0,-33.0, -1.0};
		
		// Generate the Finger Epithelium		
		BioMightBeanLocal bioMightBean;
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Generating the Thumb ParentID: " + parentID);
			InitialContext ctx = new InitialContext();
			bioMightBean = (BioMightBeanLocal) ctx.lookup("java:global/BioMightWeb/BioMightBean!biomight.ejb.BioMightBeanLocal");
	
			
			//Map into the basic human model of the thumbs
			if (componentID.equals("Thumb:01")) {
				startPos[0] = 11.0;
				startIndex = "00001";
			}
			else if (componentID.equals("Thumb:02")) 
			{
				startPos[0] = -12.00;
				startIndex = "000064";
			}
			else
			{
				startPos[0] = -11.5;
				startIndex = "00448";
				
			}

			
			// 	Create a equilateral octogon
			double x =  startPos[0];
			double y =  startPos[1];
			double z =  startPos[2];
	 
			double[][] currentPoints = { 
	 			{x, y, z},
	 			{x-circumference,     y, z-circumference},
	 			{x-circumference,     y, z-circumference*2},
	 			{x,                   y, z-circumference*3},
	 			{x+circumference,     y, z-circumference*3},
	 			{x+(circumference*2), y, z-circumference*2},
	 			{x+(circumference*2),     y, z-circumference},
	 			{x+circumference, y, z}
	   		};
	
			
			int success = bioMightBean.generateThumb("ThumbEpithelium:"+startIndex, "ThumbEpithelium", 
					"ThumbEpithelium", componentID, currentPoints);			
	
			
		System.out.println("Created ThumEpithelium generateThumb");   	
		}catch (	Exception e) { 
		System.out.println("Exception Getting generateThumb");
		throw new ServerException("Remote Exception getComponents():", e); 	
		}

	}
	

	public void initProperties() {
	
		BioMightPropertyView property = new BioMightPropertyView();
		property.setPropertyName("Stapes ---");
		property.setCanonicalName(Constants.LeftEar);
		properties.add(property);
				
	}
	
	
	public void initMethods() {
		
		BioMightMethodView method;

		method = new BioMightMethodView();
		method.setMethodName("Deafness");
		method.setHtmlType("checkbox");
		methods.add(method);	
		
		method = new BioMightMethodView();
		method.setMethodName("Hear");
		method.setHtmlType("checkbox");
		methods.add(method);
	}
	
	/*********************************************************************************
	 * INIT 3D
	 * 
	 * This method will be executed when we can see cartilage with our regular
	 * perception.  This is not at the cellular level, but as if one were looking
	 * at the ear.
	 *
	 ********************************************************************************/
	public void init3D(BioMightPosition position) {
	
	}
		 						

	
	/********************************************************************************************************************
	 * GET X3D
	 * 
	 * This method will return the X3D for the Thumb.  It runs through each of its 
	 * components and collects up their representations and then assembles them into one unified X3D model.
	 * 
	 ********************************************************************************************************************/
	
	public String getX3D(boolean snipet) {
		
		// Assemble the Stomach Greater Curvature 
		String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
		"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n " +
		"<X3D profile='Immersive' >\n" +
		"<head>\n" +
		 "<meta name='BioMightImage' content='Thumb .jpg'/>\n" +
		 "<meta name='ExportTime' content='7:45:30'/>\n" +
		 "<meta name='ExportDate' content='08/15/2008'/>\n" +
		 "<meta name='BioMight Version' content='1.0'/>\n" + 
		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='Thumb '\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		


		String body = "";
	
		int view = Constants.VIEW_FLOATING;
		if (view == Constants.VIEW_FLOATING)
		{
			body = epithelium.getX3D(true);
		}
		else if (view == Constants.VIEW_DETACHED)
		{	
			// Run through the collection of Thumb  and build them into the model
			// In the default case, we get one instance of the Thumb  for each Stomach
			ArrayList transforms = bioMightTransforms.getTransforms();
			for (int i=0; i<transforms.size(); i++)
			{
				// Get the information for the Thumb we are creating
				BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
				System.out.println("Getting Thumb X3D: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
		
	
				//System.out.println("Getting X3D for Thumb X: " + bioMightSphere.getTranslation().getXPos());
				//System.out.println("Getting X3D for Thumb Y: " + bioMightSphere.getTranslation().getYPos());
				//System.out.println("Getting X3D for Thumb Z: " + bioMightSphere.getTranslation().getZPos());
				// Change the height and width based on the displacement.
				body += "<Transform DEF='Thumb '\n" +
		 			"translation='" + bioMightTransform.getTranslation().getXPos() + " " 
			 					+ bioMightTransform.getTranslation().getYPos() + " "
			 					+ bioMightTransform.getTranslation().getZPos() + "'\n" +
			 		"scale='" 	+ bioMightTransform.getScale().getXPos() + " "
			 				+ bioMightTransform.getScale().getYPos() + " "
			 				+ bioMightTransform.getScale().getZPos() + "'>\n" +
					"<Shape DEF='Thumb Shape'\n" +
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
						 	"<IndexedFaceSet DEF='Thumb IFS' \n" +
						    	   "containerField='geometry' \n" +
						    	   "creaseAngle='" +  bioMightTransform.getCreaseAngle() + "'\n" +
						    	   "coordIndex='" + bioMightTransform.getCoordindexStr() + "'>" +
						    	   "<Coordinate DEF='Thumb _Coord' \n" +
						    	    "containerField='coord' point='" +  bioMightTransform.getCoordpointStr() + "'/>" +
						    	  "</IndexedFaceSet>\n" +
					"</Shape>\n" +
	
					"<TimeSensor DEF='StomachBeatTimer'\n" +
						  " containerField='children'\n " +
						  " cycleInterval='1.000'\n " + 
						  " loop='true' \n" +
						  " startTime='-1.000'/> \n" +
					"<TouchSensor DEF='StartStomachBeat' \n" +
						  " containerField='children'/> \n" +
				    "</Transform>\n" +
				    "<PositionInterpolator DEF='StomachBeatAnim'\n" + 
				    "key='0 .5 1'\n" +
				    "keyValue='1 1 1 .9 .9 .9 1 1 1'/>\n" + 
				    "<ROUTE fromNode='StartStomachBeat' fromField='touchTime' toNode='StomachBeatTimer' toField='startTime'/>\n" +
				    "<ROUTE fromNode='StomachBeatTimer' fromField='fraction_changed' toNode='StomachBeatAnim' toField='set_fraction'/>\n" +
				    "<ROUTE fromNode='StomachBeatAnim' fromField='value_changed' toNode='Thumb' toField='set_scale'/>\n";
				}
		}
		else // No view specified
		{
			body = "";						
		}
		
		
		//System.out.println("Thumb X3D: " + body);		
		String footer = "</Scene>" + "</X3D>\n";
		
		if (snipet)
			return body;			
		else	
			return header + body + footer;
	}

	
}
