/*
 * Created on Sep 5, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.system.vascular.veins.neck;

import java.util.ArrayList;

import javax.naming.InitialContext;





import biomight.Constants;
import biomight.ejb.BioMightBeanLocal;
import biomight.ejb.BioMightVascularBeanLocal;
import biomight.exceptions.ServerException;
import biomight.system.tissue.edothelial.EndotheliumTissue;
import biomight.system.vascular.veins.Vein;
import biomight.util.BioGraphics;
import biomight.view.BioMightMethodView;
import biomight.view.BioMightPosition;
import biomight.view.BioMightPropertyView;
import biomight.view.BioMightTransform;

/********************************************************************
 * @author SurferJim
 *
 * Representation of the ExternalJugularVein
 ********************************************************************/


public class ExternalJugularVein extends Vein {
	protected EndotheliumTissue endothelium;
	
	
	public ExternalJugularVein()
	{
		create(Constants.ExternalJugularVein, null);
	}

	public ExternalJugularVein(String parentID)
	{
		create(parentID, null);
	}
	
	public ExternalJugularVein(String parentID, ArrayList<BioMightMethodView> bioMightMethods)
	{
		create(parentID, bioMightMethods);
	}
	
	/********************************************************************************************************************
	 * CREATE ExternalJugularVein
	 * 
	 * This method will instantiate the Buccal Vein that are defined for the current model.  
	 * 
	 ********************************************************************************************************************/

	
	public void create(String parentID, ArrayList<BioMightMethodView> bioMightMethods)
	{
		this.setImage("images/ExternalJugularVein.jpg");
		this.setImageHeight(300);
		this.setImageWidth(300);
	
		// Build the model based on what you are looking based on LOD
		int viewPerspective = Constants.VIEW_DETACHED;
		if (viewPerspective == Constants.VIEW_DETACHED)
		{	
			componentID=parentID;
			
			// Generate the ExternalJugularVein Endothelium if needed 
			boolean bGenerate = false;
			if (bGenerate) {
				generate(parentID, componentID);
			}
			
			System.out.println("Creating ExternalJugularVein Endothelium: " + parentID);	
			endothelium = new EndotheliumTissue("ExternalJugularVeinEndothelium", parentID,bioMightMethods);
			initProperty("ExternalJugularVeinEndothelium", Constants.EndotheliumTissue, Constants.EndotheliumTissueRef, endothelium.getComponentID());
		}
		else // Assemble now
		{			
			// Get the information from the database via the Enterprise Bean		
			try {
				// Get the information from the database via the Enterprise Bean		
				System.out.println("Getting ExternalJugularVeinInfo for ParentID: " + parentID);
				InitialContext ctx = new InitialContext();
				BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
				bioMightTransforms = bioMightBean.getComponents(Constants.ExternalJugularVeinRef, parentID);
				System.out.println("Have ExternalJugularVein Info from EJB");   	
			}catch (Exception e) { 
				System.out.println("Exception Getting Components - ExternalJugularVein");
				throw new ServerException("Remote Exception getComponents():", e); 	
			}
				
			// Run through the collection of ExternalJugularVeins and build them into the model
			// In the default case, we get one instance of the ExternalJugularVein for each eye
			ArrayList transforms = bioMightTransforms.getTransforms();
			System.out.println("ExternalJugularVein NumTransforms: " + transforms.size());
			for (int i=0; i<transforms.size(); i++)
			{
				// Get the information for the eye we are creating
				BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
				System.out.println("Created ExternalJugularVein: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
				this.componentID = bioMightTransform.getId();
				
				System.out.println("Creating ExternalJugularVein Endothelium: " + bioMightTransform.getId());	
				endothelium = new EndotheliumTissue("ExternalJugularVeinEndothelium", bioMightTransform.getId(),bioMightMethods);
				initProperty("ExternalJugularVeinEndothelium", Constants.EndotheliumTissue, Constants.EndotheliumTissueRef, endothelium.getComponentID());
			}
			
		}
		
		//initProperties();
		initMethods();
		
		System.out.println("CreateExternalJugularVein Completed");
		
		// First, get all the data from the database
		// Apply the methods to it
		// Save its state
		this.parentID = parentID;
		if (bioMightMethods != null){
			System.out.println("EXECUTING ExternalJugularVein METHODS: " + bioMightMethods.size());
			//executeMethods(bioMightMethods);
		}
	}
	

	/*******************************************************************
	 * GENERATE EXTERNAL JUGULAR VEIN
	 * 
	 * @param parentID
	 * @param componentID
	 ****************************************************************/
	
	public void generate(String parentID, String componentID)
	{
		// Generate the ExternalJugularVein		
		BioMightVascularBeanLocal bioMightBean;
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Generating the BuccalArteryEndothelium: " + componentID + "    " + parentID);
			InitialContext ctx = new InitialContext();
			bioMightBean = (BioMightVascularBeanLocal) ctx.lookup(Constants.VascularBeanRef);
	
			double circumference = 0.0825;
		
			// Left Internal Carotid Artery - Cervical Region
			if (componentID.equals("ExternalJugularVein:01")) 
			{	
				// Generate the ExternalJugularVeinEndothelium of the neck
				// Create 5 sections
				double[] startPos = {2.0,-8.0, -4.00};
				double[][] currentPoints = BioGraphics.octogonYPlane(startPos, circumference);
	
				System.out.println("Calling Generate ExternalJugularVeinEndothelium: " + componentID + "    " + parentID);
				
				int success = bioMightBean.generateExternalJugularVein("ExternalJugularVeinEndothelium:00001", "ExternalJugularVeinEndothelium", 
					"ExternalJugularVeinEndothelium", componentID, parentID, currentPoints);			
					
			}
			// Right Internal Carotid Artery - Cervicle Region
			else if (componentID.equals("ExternalJugularVein:02")) 
			{	
				// Generate the ExternalJugularVeinEndothelium of the chest
				double[] startPos = {-1.75,-8.0, -3.75};
				double[][] currentPoints = BioGraphics.octogonYPlane(startPos, circumference);
	
				System.out.println("Calling Generate ExternalJugularVeinEndothelium: " + componentID + "    " + parentID);
				
				int success = bioMightBean.generateExternalJugularVein("ExternalJugularVeinEndothelium:00160", "ExternalJugularVeinEndothelium", 
					"ExternalJugularVeinEndothelium", componentID, parentID, currentPoints);			
					
			}
			// Right Internal Carotid Artery - Head Region
			else if (componentID.equals("ExternalJugularVein:03")) 
			{	
				System.out.println("Here i am fool!!!!!: " + componentID + "    " + parentID);
				
				
				// Generate the ExternalJugularVeinEndothelium of the chest
				// Create 5 sections
				double[] startPos = {-1.75, -5.0, -3.0};
				System.out.println("Here i am fool!!!!!2: " + componentID + "    " + parentID);
				double[][] currentPoints = BioGraphics.octogonYPlane(startPos, circumference);
	
				System.out.println("Calling Generate ExternalJugularVeinEndothelium: " + componentID + "    " + parentID);
				
				int success = bioMightBean.generateExternalJugularVein("ExternalJugularVeinEndothelium:00320", "ExternalJugularVeinEndothelium", 
					"ExternalJugularVeinEndothelium", componentID, parentID, currentPoints);			
					
			}
			// Left Common Carotid Artery - Head Region
			else if (componentID.equals("ExternalJugularVein:04")) 
			{	
				// Generate the ExternalJugularVeinEndothelium of the chest
				// Create 5 sections
				double[] startPos = {2.00,-5.0, -3.0};
				double[][] currentPoints = BioGraphics.octogonYPlane(startPos, circumference);
	
				System.out.println("Calling Generate ExternalJugularVeinEndothelium: " + componentID + "    " + parentID);
				
				int success = bioMightBean.generateExternalJugularVein("ExternalJugularVeinEndothelium:00480", "ExternalJugularVeinEndothelium", 
					"ExternalJugularVeinEndothelium", componentID, parentID, currentPoints);			
					
			}

			else if (parentID.equals("")) 
			{	
				System.out.println("Calling Generate ExternalJugularVeinEndothelium NoParent");
							
			}
			
			System.out.println("Created ExternalJugularVeinEndothelium Info using EJB");   	
		}catch (Exception e) { 
			System.out.println("Exception Generating Components - ExternalJugularVeinEndothelium");
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
	 * This method will return the X3D for the ExternalJugularVein.  It runs through each of its 
	 * components and collects up their representations and then assembles them into one unified X3D model.
	 * 
	 ********************************************************************************************************************/

	public String getX3D(boolean snipet) {
		
		// Assemble the ExternalJugularVein 
		String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
		"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n " +
		"<X3D profile='Immersive' >\n" +
		"<head>\n" +
		 "<meta name='BioMightImage' content='ExternalJugularVein .jpg'/>\n" +
		 "<meta name='ExportTime' content='7:45:30'/>\n" +
		 "<meta name='ExportDate' content='08/15/2008'/>\n" +
		 "<meta name='BioMight Version' content='1.0'/>\n" + 
		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='ExternalJugularVein '\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		


		String body = "";
		
		
		int view = Constants.VIEW_FLOATING;
		if (view == Constants.VIEW_FLOATING)
		{
			 body = endothelium.getX3D(true);  		
		}
		else if (view == Constants.VIEW_DETACHED)
		{
		
			// Run through the collection of ExternalJugularVein  and build them into the model
			// In the default case, we get one instance of the ExternalJugularVein  for each Stomach
			ArrayList transforms = bioMightTransforms.getTransforms();
			for (int i=0; i<transforms.size(); i++)
			{
				// Get the information for the ExternalJugularVein we are creating
				BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
				System.out.println("Getting ExternalJugularVein X3D: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
		
		
				//System.out.println("Getting X3D for ExternalJugularVein X: " + bioMightSphere.getTranslation().getXPos());
				//System.out.println("Getting X3D for ExternalJugularVein Y: " + bioMightSphere.getTranslation().getYPos());
				//System.out.println("Getting X3D for ExternalJugularVein Z: " + bioMightSphere.getTranslation().getZPos());
				// Change the height and width based on the displacement.
				body += "<Transform DEF='ExternalJugularVein '\n" +
		 			"translation='" + bioMightTransform.getTranslation().getXPos() + " " 
			 					+ bioMightTransform.getTranslation().getYPos() + " "
			 					+ bioMightTransform.getTranslation().getZPos() + "'\n" +
			 		"scale='" 	+ bioMightTransform.getScale().getXPos() + " "
			 				+ bioMightTransform.getScale().getYPos() + " "
			 				+ bioMightTransform.getScale().getZPos() + "'>\n" +
					"<Shape DEF='ExternalJugularVein Shape'\n" +
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
						 	"<IndexedFaceSet DEF='ExternalJugularVein IFS' \n" +
						    	   "containerField='geometry' \n" +
						    	   "creaseAngle='" +  bioMightTransform.getCreaseAngle() + "'\n" +
						    	   "coordIndex='" + bioMightTransform.getCoordindexStr() + "'>" +
						    	   "<Coordinate DEF='ExternalJugularVein _Coord' \n" +
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
			 "<ROUTE fromNode='StomachBeatAnim' fromField='value_changed' toNode='ExternalJugularVein' toField='set_scale'/>\n";
			}
		}
		else
		{
			body = "";//						
		}
		
		
		//System.out.println("ExternalJugularVein X3D: " + body);		
		String footer = "</Scene>" + "</X3D>\n";
		
		if (snipet)
			return body;			
		else	
			return header + body + footer;
	}	
	
}
