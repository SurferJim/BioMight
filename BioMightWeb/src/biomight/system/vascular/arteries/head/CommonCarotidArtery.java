/*
 * Created on Apr 25, 2006
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
import biomight.view.BioMightGenerate;
import biomight.view.BioMightMethodView;
import biomight.view.BioMightPosition;
import biomight.view.BioMightPropertyView;
import biomight.view.BioMightTransform;

/**
 * @author SurferJim
 *
 * Representation of the CommonCarotid Artery
 * 
 */
public class CommonCarotidArtery extends Artery {
	protected EndotheliumTissue endothelium;
	
	
	public CommonCarotidArtery()
	{
		create(Constants.CommonCarotidArtery, null);
	}

	public CommonCarotidArtery(String parentID)
	{
		create(parentID, null);
	}
	
	public CommonCarotidArtery(String parentID, ArrayList<BioMightMethodView> bioMightMethods)
	{
		create(parentID, bioMightMethods);
	}
	
	/********************************************************************************************************************
	 * CREATE CommonCarotidArtery
	 * 
	 * This method will instantiate the Buccal Artery that are defined for the current model.  
	 * 
	 ********************************************************************************************************************/

	
	public BioMightGenerate create(String parentID, ArrayList<BioMightMethodView> bioMightMethods)
	{
		BioMightGenerate bioGenerate= null;
		
		this.setImage("images/CommonCarotidArtery.jpg");
		this.setImageHeight(300);
		this.setImageWidth(300);
	
		// Build the model based on what you are looking based on LOD
		int viewPerspective = Constants.VIEW_DETACHED;
		if (viewPerspective == Constants.VIEW_DETACHED)
		{	
			componentID=parentID;
			
			// Generate the GreaterCurvature Endothelium if needed 
			boolean bGenerate = false;
			if (bGenerate) {
				bioGenerate = generate(parentID, componentID);
			}
			
			System.out.println("Creating CommonCarotidArtery Endothelium: " + parentID);	
			endothelium = new EndotheliumTissue("CommonCarotidArteryEndothelium", parentID,bioMightMethods);
			initProperty("CommonCarotidArteryEndothelium", Constants.EndotheliumTissue, Constants.EndotheliumTissueRef, endothelium.getComponentID());
		}
		else // Assemble now
		{			
			// Get the information from the database via the Enterprise Bean		
			try {
				// Get the information from the database via the Enterprise Bean		
				System.out.println("Getting CommonCarotidArteryInfo for ParentID: " + parentID);
				InitialContext ctx = new InitialContext();
				BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
				bioMightTransforms = bioMightBean.getComponents(Constants.CommonCarotidArteryRef, parentID);
				System.out.println("Have CommonCarotidArtery Info from EJB");   	
			}catch (Exception e) { 
				System.out.println("Exception Getting Components - CommonCarotidArtery");
				throw new ServerException("Remote Exception getComponents():", e); 	
			}
				
			// Run through the collection of CommonCarotidArterys and build them into the model
			// In the default case, we get one instance of the CommonCarotidArtery for each eye
			ArrayList transforms = bioMightTransforms.getTransforms();
			System.out.println("CommonCarotidArtery NumTransforms: " + transforms.size());
			for (int i=0; i<transforms.size(); i++)
			{
				// Get the information for the eye we are creating
				BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
				System.out.println("Created CommonCarotidArtery: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
				this.componentID = bioMightTransform.getId();
				
				System.out.println("Creating CommonCarotidArtery Endothelium: " + bioMightTransform.getId());	
				endothelium = new EndotheliumTissue("CommonCarotidArteryEndothelium", bioMightTransform.getId(),bioMightMethods);
				initProperty("CommonCarotidArteryEndothelium", Constants.EndotheliumTissue, Constants.EndotheliumTissueRef, endothelium.getComponentID());
			}
			
		}
		
		//initProperties();
		initMethods();
		
		System.out.println("CreateCommonCarotidArtery Completed");
		
		// First, get all the data from the database
		// Apply the methods to it
		// Save its state
		this.parentID = parentID;
		if (bioMightMethods != null){
			System.out.println("EXECUTING CommonCarotidArtery METHODS: " + bioMightMethods.size());
			//executeMethods(bioMightMethods);
		}
		
		return (bioGenerate);
	}
	
	
	/*******************************************************************
	 * GENERATE COMMON CAROTID ARTERY
	 * 
	 * @param parentID
	 * @param componentID
	 ****************************************************************/
	
	public BioMightGenerate generate(String parentID, String componentID)
	{
		BioMightGenerate bioGenerate = null;
		
		// Generate the CommonCarotidArteryEndothelium		
		BioMightVascularBeanLocal bioMightBean;
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Generating the CommonCarotidArteryEndothelium: " + componentID + "    " + parentID);
			InitialContext ctx = new InitialContext();
			bioMightBean = (BioMightVascularBeanLocal) ctx.lookup(Constants.VascularBeanRef);
	
			double radius = 0.20;
		
			// Left Common Carotid Artery - Thoracic Region
			// This one comes right out of the top of the heart
			if (componentID.equals("CommonCarotidArtery:01")) 
			{	
				// Generate the CommonCarotidArteryEndothelium of the neck
				// Create 5 sections
				double[] startPos = {0.95, -10.25, -3.00};
				double[][] currentPoints = BioGraphics.createCylinderInPlane(Constants.YPLANE, startPos, radius, 8);

				
				System.out.println("Calling Generate CommonCarotidArteryEndothelium: " + componentID + "    " + parentID);
				
				bioGenerate = bioMightBean.generateCommonCarotidArtery("CommonCarotidArteryEndothelium:00001", "CommonCarotidArteryEndothelium", 
					"LeftCommonCarotidArteryEndothelium", componentID, parentID, currentPoints);			
					
			}
			// Right Common Carotid Artery - Thoracic Region
			// This comes  off the Subclavia about an 1 1/2 inch above
			else if (componentID.equals("CommonCarotidArtery:02")) 
			{	
				// Generate the CommonCarotidArteryEndothelium of the chest
				double[] startPos = {-1.60, -6.9, -2.95};
				double[][] currentPoints = BioGraphics.createCylinderInPlane(Constants.YPLANE, startPos, radius, 8);

	
				System.out.println("Calling Generate CommonCarotidArteryEndothelium: " + componentID + "    " + parentID);
				
				bioGenerate = bioMightBean.generateCommonCarotidArtery("CommonCarotidArteryEndothelium:00160", "CommonCarotidArteryEndothelium", 
					"RightCommonCarotidArteryEndothelium", componentID, parentID, currentPoints);			
					
			}
			// Right Common Carotid Artery - Cervical Region
			else if (componentID.equals("CommonCarotidArtery:03")) 
			{	
				// Generate the CommonCarotidArteryEndothelium of the chest
				// Create 5 sections
				double[] startPos = {1.650, -6.25, -3.0};
				
				double[][] currentPoints = BioGraphics.createCylinderInPlane(Constants.YPLANE, startPos, radius, 8);

	
				System.out.println("Calling Generate CommonCarotidArteryEndothelium: " + componentID + "    " + parentID);
				
				bioGenerate = bioMightBean.generateCommonCarotidArtery("CommonCarotidArteryEndothelium:00320", "CommonCarotidArteryEndothelium", 
					"LeftCommonCarotidArteryEndothelium", componentID, parentID, currentPoints);			
					
			}
			// Right Common Carotid Artery - Cervical Region
			else if (componentID.equals("CommonCarotidArtery:04")) 
			{	
				// Generate the CommonCarotidArteryEndothelium of the chest
				// Create 5 sections
				double[] startPos = {-1.60, -6.05, -2.95};
				double[][] currentPoints = BioGraphics.createCylinderInPlane(Constants.YPLANE, startPos, radius, 8);

	
				System.out.println("Calling Generate CommonCarotidArteryEndothelium: " + componentID + "    " + parentID);
				
				bioGenerate = bioMightBean.generateCommonCarotidArtery("CommonCarotidArteryEndothelium:00480", "CommonCarotidArteryEndothelium", 
					"CommonCarotidArteryEndothelium", componentID, parentID, currentPoints);			
					
			}

			else if (parentID.equals("")) 
			{	
				System.out.println("Calling Generate CommonCarotidArteryEndothelium NoParent");
							
			}
			
			System.out.println("Created CommonCarotidArteryEndothelium Info using EJB");   	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - CommonCarotidArteryEndothelium");
			throw new ServerException("Remote Exception getComponents():", e); 	
		}
		
		
		return(bioGenerate);
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
		 "<meta name='BioMightImage' content='CommonCarotidArtery .jpg'/>\n" +
		 "<meta name='ExportTime' content='7:45:30'/>\n" +
		 "<meta name='ExportDate' content='08/15/2008'/>\n" +
		 "<meta name='BioMight Version' content='1.0'/>\n" + 
		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='CommonCarotidArtery '\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		


		String body = "";
		
		
		int view = Constants.VIEW_FLOATING;
		if (view == Constants.VIEW_FLOATING)
		{
			 body = endothelium.getX3D(true);  		
		}
		else if (view == Constants.VIEW_DETACHED)
		{
		
			// Run through the collection of CommonCarotidArtery  and build them into the model
			// In the default case, we get one instance of the CommonCarotidArtery  for each Stomach
			ArrayList transforms = bioMightTransforms.getTransforms();
			for (int i=0; i<transforms.size(); i++)
			{
				// Get the information for the CommonCarotidArtery we are creating
				BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
				System.out.println("Getting CommonCarotidArtery X3D: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
		
		
				//System.out.println("Getting X3D for CommonCarotidArtery X: " + bioMightSphere.getTranslation().getXPos());
				//System.out.println("Getting X3D for CommonCarotidArtery Y: " + bioMightSphere.getTranslation().getYPos());
				//System.out.println("Getting X3D for CommonCarotidArtery Z: " + bioMightSphere.getTranslation().getZPos());
				// Change the height and width based on the displacement.
				body += "<Transform DEF='CommonCarotidArtery '\n" +
		 			"translation='" + bioMightTransform.getTranslation().getXPos() + " " 
			 					+ bioMightTransform.getTranslation().getYPos() + " "
			 					+ bioMightTransform.getTranslation().getZPos() + "'\n" +
			 		"scale='" 	+ bioMightTransform.getScale().getXPos() + " "
			 				+ bioMightTransform.getScale().getYPos() + " "
			 				+ bioMightTransform.getScale().getZPos() + "'>\n" +
					"<Shape DEF='CommonCarotidArtery Shape'\n" +
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
						 	"<IndexedFaceSet DEF='CommonCarotidArtery IFS' \n" +
						    	   "containerField='geometry' \n" +
						    	   "creaseAngle='" +  bioMightTransform.getCreaseAngle() + "'\n" +
						    	   "coordIndex='" + bioMightTransform.getCoordindexStr() + "'>" +
						    	   "<Coordinate DEF='CommonCarotidArtery _Coord' \n" +
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
			 "<ROUTE fromNode='StomachBeatAnim' fromField='value_changed' toNode='CommonCarotidArtery' toField='set_scale'/>\n";
			}
		}
		else
		{
			body = "";//						
		}
		
		
		//System.out.println("CommonCarotid X3D: " + body);		
		String footer = "</Scene>" + "</X3D>\n";
		
		if (snipet)
			return body;			
		else	
			return header + body + footer;
	}	
}
