/*
 * Created on May 1, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.system.vascular.arteries.head;

import java.util.ArrayList;

import javax.naming.InitialContext;





import biomight.Constants;
import biomight.ejb.BioMightBeanLocal;
import biomight.ejb.BioMightVascularBeanLocal;
import biomight.exceptions.ServerException;
import biomight.system.tissue.edothelial.EndotheliumTissue;
import biomight.system.vascular.arteries.Artery;
import biomight.util.BioGraphics;
import biomight.view.BioMightMethodView;
import biomight.view.BioMightPosition;
import biomight.view.BioMightPropertyView;
import biomight.view.BioMightTransform;

/**
 * @author SurferJim
 *
 * Representation of the External Carotid Artery
 */

public class ExternalCarotidArtery  extends Artery {
	protected EndotheliumTissue endothelium;
	
	
	public ExternalCarotidArtery()
	{
		create(Constants.ExternalCarotidArtery, null);
	}

	public ExternalCarotidArtery(String parentID)
	{
		create(parentID, null);
	}
	
	public ExternalCarotidArtery(String parentID, ArrayList<BioMightMethodView> bioMightMethods)
	{
		create(parentID, bioMightMethods);
	}
	
	/********************************************************************************************************************
	 * CREATE ExternalCarotidArtery
	 * 
	 * This method will instantiate the Buccal Artery that are defined for the current model.  
	 * 
	 ********************************************************************************************************************/

	
	public void create(String parentID, ArrayList<BioMightMethodView> bioMightMethods)
	{
		this.setImage("images/ExternalCarotidArtery.jpg");
		this.setImageHeight(300);
		this.setImageWidth(300);
	
		// Build the model based on what you are looking based on LOD
		int viewPerspective = Constants.VIEW_DETACHED;
		if (viewPerspective == Constants.VIEW_DETACHED)
		{	
			componentID=parentID;
			
			// Generate 
			boolean bGenerate = false;
			if (bGenerate) {
				generate(parentID, componentID);
			}
			
			System.out.println("Creating ExternalCarotidArtery Endothelium: " + parentID);	
			endothelium = new EndotheliumTissue("ExternalCarotidArteryEndothelium", parentID,bioMightMethods);
			initProperty("ExternalCarotidArteryEndothelium", Constants.EndotheliumTissue, Constants.EndotheliumTissueRef, endothelium.getComponentID());
		}
		else // Assemble now
		{			
			// Get the information from the database via the Enterprise Bean		
			try {
				// Get the information from the database via the Enterprise Bean		
				System.out.println("Getting ExternalCarotidArteryInfo for ParentID: " + parentID);
				InitialContext ctx = new InitialContext();
				BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
				bioMightTransforms = bioMightBean.getComponents(Constants.ExternalCarotidArteryRef, parentID);
				System.out.println("Have ExternalCarotidArtery Info from EJB");   	
			}catch (Exception e) { 
				System.out.println("Exception Getting Components - ExternalCarotidArtery");
				throw new ServerException("Remote Exception getComponents():", e); 	
			}
				
			// Run through the collection of ExternalCarotidArterys and build them into the model
			// In the default case, we get one instance of the ExternalCarotidArtery for each eye
			ArrayList transforms = bioMightTransforms.getTransforms();
			System.out.println("ExternalCarotidArtery NumTransforms: " + transforms.size());
			for (int i=0; i<transforms.size(); i++)
			{
				// Get the information for the eye we are creating
				BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
				System.out.println("Created ExternalCarotidArtery: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
				this.componentID = bioMightTransform.getId();
				
				System.out.println("Creating ExternalCarotidArtery Endothelium: " + bioMightTransform.getId());	
				endothelium = new EndotheliumTissue("ExternalCarotidArteryEndothelium", bioMightTransform.getId(),bioMightMethods);
				initProperty("ExternalCarotidArteryEndothelium", Constants.EndotheliumTissue, Constants.EndotheliumTissueRef, endothelium.getComponentID());
			}
			
		}
		
		//initProperties();
		initMethods();
		
		System.out.println("CreateExternalCarotidArtery Completed");
		
		// First, get all the data from the database
		// Apply the methods to it
		// Save its state
		this.parentID = parentID;
		if (bioMightMethods != null){
			System.out.println("EXECUTING ExternalCarotidArtery METHODS: " + bioMightMethods.size());
			//executeMethods(bioMightMethods);
		}
	}
	

	/****************************************************************************
	 * GENERATE EXTERNAL CAROTID ARTERY
	 * 
	 * @param parentID
	 * @param componentID
	 ***************************************************************************/
	
	public void generate(String parentID, String componentID)
	{
		// Generate the ExternalCarotidArteryEndothelium		
		BioMightVascularBeanLocal bioMightBean;
		try {
			// Get the information from the database via the Enterprise Bean			
			System.out.println("Generating the InternalCarotidArteryEndothelium: " + componentID + "    " + parentID);
			InitialContext ctx = new InitialContext();
			bioMightBean = (BioMightVascularBeanLocal) ctx.lookup("java:global/BioMightWeb/BioMightVascularBean!biomight.ejb.BioMightVascularBeanLocal");
	
			double radius = 0.0625;
		
			// Left External Carotid Artery - Cervical Region
			if (componentID.equals("ExternalCarotidArtery:01")) 
			{	
				// Generate the ExternalCarotidArteryEndothelium of the neck
				// Create 5 sections
				double[] startPos = {1.0, -7.5, -4.00};
				
				// Create a equilateral octogon
				double x =  startPos[0];
				double y =  startPos[1];
				double z =  startPos[2];

				double[][] currentPoints = BioGraphics.createCylinderInPlane(Constants.YPLANE, startPos, radius, 8);
	
				System.out.println("Calling Generate ExternalCarotidArteryEndothelium: " + componentID + "    " + parentID);
				
				int success = bioMightBean.generateExternalCarotidArtery("ExternalCarotidArteryEndothelium:00001", "ExternalCarotidArteryEndothelium", 
					"ExternalCarotidArteryEndothelium", componentID, parentID, currentPoints);			
					
			}
			// Right External Carotid Artery - Cervicle Region
			else if (componentID.equals("ExternalCarotidArtery:02")) 
			{	
				// Generate the ExternalCarotidArteryEndothelium of the chest
				double[] startPos = {-2.0,-7.5, -3.75};
				double[][] currentPoints = BioGraphics.createCylinderInPlane(Constants.YPLANE, startPos, radius, 8);
	
				System.out.println("Calling Generate ExternalCarotidArteryEndothelium: " + componentID + "    " + parentID);
				
				int success = bioMightBean.generateExternalCarotidArtery("ExternalCarotidArteryEndothelium:00160", "ExternalCarotidArteryEndothelium", 
					"ExternalCarotidArteryEndothelium", componentID, parentID, currentPoints);			
					
			}
			// Right External Carotid Artery - Head region
			else if (componentID.equals("ExternalCarotidArtery:03")) 
			{	
				// Generate the ExternalCarotidArteryEndothelium of the chest
				// Create 5 sections			
				double[] startPos = {1.65, -6.0, -3.20};
				double[][] currentPoints = BioGraphics.createCylinderInPlane(Constants.YPLANE, startPos, radius, 8);
	
	
				System.out.println("Calling Generate ExternalCarotidArteryEndothelium: " + componentID + "    " + parentID);
				
				int success = bioMightBean.generateExternalCarotidArtery("ExternalCarotidArteryEndothelium:00320", "ExternalCarotidArteryEndothelium", 
					"ExternalCarotidArteryEndothelium", componentID, parentID, currentPoints);			
					
			}
			// Right External Carotid Artery - Head Region
			else if (componentID.equals("ExternalCarotidArtery:04")) 
			{	
				// Generate the ExternalCarotidArteryEndothelium of the chest
				// Create 5 sections
				double[] startPos = {-1.58, -6.0, -3.25};
				double[][] currentPoints = BioGraphics.createCylinderInPlane(Constants.YPLANE, startPos, radius, 8);
	
				System.out.println("Calling Generate ExternalCarotidArteryEndothelium: " + componentID + "    " + parentID);
				
				int success = bioMightBean.generateExternalCarotidArtery("ExternalCarotidArteryEndothelium:00480", "ExternalCarotidArteryEndothelium", 
					"ExternalCarotidArteryEndothelium", componentID, parentID, currentPoints);			
					
			}

			else if (parentID.equals("")) 
			{	
				System.out.println("Calling Generate ExternalCarotidArteryEndothelium NoParent");
							
			}
			
			System.out.println("Created ExternalCarotidArteryEndothelium Info using EJB");   	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - ExternalCarotidArteryEndothelium");
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
		method.setMethodName("Embolize");
		method.setHtmlType("checkbox");
		methods.add(method);	
		
		method = new BioMightMethodView();
		method.setMethodName("Rupture");
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
	 * This method will return the X3D for the Stomach Greater Curvature.  It runs through each of its 
	 * components and collects up their representations and then assembles them into one unified X3D model.
	 * 
	 ********************************************************************************************************************/

	public String getX3D(boolean snipet) {
		
		// Assemble the Femoral Vein 
		String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
		"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n " +
		"<X3D profile='Immersive' >\n" +
		"<head>\n" +
		 "<meta name='BioMightImage' content='ExternalCarotidArtery .jpg'/>\n" +
		 "<meta name='ExportTime' content='7:45:30'/>\n" +
		 "<meta name='ExportDate' content='08/15/2008'/>\n" +
		 "<meta name='BioMight Version' content='1.0'/>\n" + 
		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='ExternalCarotidArtery'\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		


		String body = "";
		
		
		int view = Constants.VIEW_FLOATING;
		if (view == Constants.VIEW_FLOATING)
		{
			 body = endothelium.getX3D(true);  		
		}
		else if (view == Constants.VIEW_DETACHED)
		{
		
			// Run through the collection of ExternalCarotidArtery  and build them into the model
			// In the default case, we get one instance of the ExternalCarotidArtery  for each Stomach
			ArrayList transforms = bioMightTransforms.getTransforms();
			for (int i=0; i<transforms.size(); i++)
			{
				// Get the information for the ExternalCarotidArtery we are creating
				BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
				System.out.println("Getting ExternalCarotidArtery X3D: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
		
		
				//System.out.println("Getting X3D for ExternalCarotidArtery X: " + bioMightSphere.getTranslation().getXPos());
				//System.out.println("Getting X3D for ExternalCarotidArtery Y: " + bioMightSphere.getTranslation().getYPos());
				//System.out.println("Getting X3D for ExternalCarotidArtery Z: " + bioMightSphere.getTranslation().getZPos());
				// Change the height and width based on the displacement.
				body += "<Transform DEF='ExternalCarotidArtery '\n" +
		 			"translation='" + bioMightTransform.getTranslation().getXPos() + " " 
			 					+ bioMightTransform.getTranslation().getYPos() + " "
			 					+ bioMightTransform.getTranslation().getZPos() + "'\n" +
			 		"scale='" 	+ bioMightTransform.getScale().getXPos() + " "
			 				+ bioMightTransform.getScale().getYPos() + " "
			 				+ bioMightTransform.getScale().getZPos() + "'>\n" +
					"<Shape DEF='ExternalCarotidArtery Shape'\n" +
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
						 	"<IndexedFaceSet DEF='ExternalCarotidArtery IFS' \n" +
						    	   "containerField='geometry' \n" +
						    	   "creaseAngle='" +  bioMightTransform.getCreaseAngle() + "'\n" +
						    	   "coordIndex='" + bioMightTransform.getCoordindexStr() + "'>" +
						    	   "<Coordinate DEF='ExternalCarotidArtery _Coord' \n" +
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
			 "<ROUTE fromNode='StartStomachBeat' fromField='touchTime' toNode='ExternalCarotidArteryBeatTimer' toField='startTime'/>\n" +
			 "<ROUTE fromNode='StomachBeatTimer' fromField='fraction_changed' toNode='ExternalCarotidArteryBeatAnim' toField='set_fraction'/>\n" +
			 "<ROUTE fromNode='StomachBeatAnim' fromField='value_changed' toNode='ExternalCarotidArtery' toField='set_scale'/>\n";
			}
		}
		else
		{
			body = "";//						
		}
		
		
		//System.out.println("ExternalCarotidArtery X3D: " + body);		
		String footer = "</Scene>" + "</X3D>\n";
		
		if (snipet)
			return body;			
		else	
			return header + body + footer;
	}	
}
