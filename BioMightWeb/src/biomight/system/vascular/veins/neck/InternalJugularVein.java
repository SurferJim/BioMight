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

/*******************************************************************
 * @author SurferJim
 *
 * Representation of the InternalJugularVein
 ******************************************************************/


public class InternalJugularVein extends Vein {
	protected EndotheliumTissue endothelium;
	
	
	public InternalJugularVein()
	{
		create(Constants.InternalJugularVein, null);
	}

	public InternalJugularVein(String parentID)
	{
		create(parentID, null);
	}
	
	public InternalJugularVein(String parentID, ArrayList<BioMightMethodView> bioMightMethods)
	{
		create(parentID, bioMightMethods);
	}
	
	/********************************************************************************************************************
	 * CREATE InternalJugularVein
	 * 
	 * This method will instantiate the Buccal Vein that are defined for the current model.  
	 * 
	 ********************************************************************************************************************/

	
	public void create(String parentID, ArrayList<BioMightMethodView> bioMightMethods)
	{
		this.setImage("images/InternalJugularVein.jpg");
		this.setImageHeight(300);
		this.setImageWidth(300);
	
		// Build the model based on what you are looking based on LOD
		int viewPerspective = Constants.VIEW_DETACHED;
		if (viewPerspective == Constants.VIEW_DETACHED)
		{	
			componentID=parentID;
	
			// Generate the InternalJugularVein Endothelium if needed 
			boolean bGenerate = false;
			if (bGenerate) {
				generate(parentID, componentID);
			}
			
			System.out.println("Creating InternalJugularVein Endothelium: " + parentID);	
			endothelium = new EndotheliumTissue("InternalJugularVeinEndothelium", parentID,bioMightMethods);
			initProperty("InternalJugularVeinEndothelium", Constants.EndotheliumTissue, Constants.EndotheliumTissueRef, endothelium.getComponentID());
		}
		else // Assemble now
		{			
			// Get the information from the database via the Enterprise Bean		
			try {
				// Get the information from the database via the Enterprise Bean		
				System.out.println("Getting InternalJugularVeinInfo for ParentID: " + parentID);
				InitialContext ctx = new InitialContext();
				BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
				bioMightTransforms = bioMightBean.getComponents(Constants.InternalJugularVeinRef, parentID);
				System.out.println("Have InternalJugularVein Info from EJB");   	
			}catch (Exception e) { 
				System.out.println("Exception Getting Components - InternalJugularVein");
				throw new ServerException("Remote Exception getComponents():", e); 	
			}
				
			// Run through the collection of InternalJugularVeins and build them into the model
			// In the default case, we get one instance of the InternalJugularVein for each eye
			ArrayList transforms = bioMightTransforms.getTransforms();
			System.out.println("InternalJugularVein NumTransforms: " + transforms.size());
			for (int i=0; i<transforms.size(); i++)
			{
				// Get the information for the eye we are creating
				BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
				System.out.println("Created InternalJugularVein: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
				this.componentID = bioMightTransform.getId();
	
				
				System.out.println("Creating InternalJugularVein Endothelium: " + bioMightTransform.getId());	
				endothelium = new EndotheliumTissue("InternalJugularVeinEndothelium", bioMightTransform.getId(),bioMightMethods);
				initProperty("InternalJugularVeinEndothelium", Constants.EndotheliumTissue, Constants.EndotheliumTissueRef, endothelium.getComponentID());
			}
			
		}
		
		//initProperties();
		initMethods();
		
		System.out.println("CreateInternalJugularVein Completed");
		
		// First, get all the data from the database
		// Apply the methods to it
		// Save its state
		this.parentID = parentID;
		if (bioMightMethods != null){
			System.out.println("EXECUTING InternalJugularVein METHODS: " + bioMightMethods.size());
			//executeMethods(bioMightMethods);
		}
	}
	
	
	/*******************************************************************
	 * GENERATE INTERNAL JUGULAR VEIN
	 * 
	 * @param parentID
	 * @param componentID
	 ****************************************************************/
	
	public void generate(String parentID, String componentID)
	{
		// Generate the InternalJugularVein		
		BioMightVascularBeanLocal bioMightBean;
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Generating the InternalJugularVeinEndothelium: " + componentID + "    " + parentID);
			InitialContext ctx = new InitialContext();
			bioMightBean = (BioMightVascularBeanLocal) ctx.lookup(Constants.VascularBeanRef);
	
			double circumference = 0.125;
		
			// Left Internal Carotid Artery - Cervical Region
			if (componentID.equals("InternalJugularVein:01")) 
			{	
				// Generate the InternalJugularVeinEndothelium of the neck
				// Create 5 sections
				double[] startPos = {2.0,-13.0, -4.00};
				double[][] currentPoints = BioGraphics.octogonYPlane(startPos, circumference);
	
	
				System.out.println("Calling Generate InternalJugularVeinyEndothelium: " + componentID + "    " + parentID);
				
				int success = bioMightBean.generateInternalJugularVein("InternalJugularVeinEndothelium:00001", "InternalJugularVeinEndothelium", 
					"InternalJugularVeinEndothelium", componentID, parentID, currentPoints);			
					
			}
			// Right Internal Carotid Artery - Cervicle Region
			else if (componentID.equals("InternalJugularVein:02")) 
			{	
				// Generate the InternalJugularVeinEndothelium of the chest
				double[] startPos = {-1.75,-9.0, -3.75};
				double[][] currentPoints = BioGraphics.octogonYPlane(startPos, circumference);
	
	
				System.out.println("Calling Generate InternalJugularVeinEndothelium: " + componentID + "    " + parentID);
				
				int success = bioMightBean.generateInternalJugularVein("InternalJugularVeinEndothelium:00160", "InternalJugularVeinEndothelium", 
					"InternalJugularVeinEndothelium", componentID, parentID, currentPoints);			
					
			}
			// Right InternalJugularVein - Head Region
			else if (componentID.equals("InternalJugularVein:03")) 
			{	
				// Generate the InternalJugularVeinEndothelium of the chest
				// Create 5 sections
				double[] startPos = {-2.0,-8.0, -3.25};
				double[][] currentPoints = BioGraphics.octogonYPlane(startPos, circumference);
	
	
				System.out.println("Calling Generate InternalJugularVeinEndothelium: " + componentID + "    " + parentID);
				
				int success = bioMightBean.generateInternalJugularVein("InternalJugularVeinEndothelium:00320", "InternalJugularVeinEndothelium", 
					"InternalJugularVeinEndothelium", componentID, parentID, currentPoints);			
					
			}
			// Left InternalJugularVein - Head Region
			else if (componentID.equals("InternalJugularVein:04")) 
			{	
				// Generate the InternalJugularVeinEndothelium of the chest
				// Create 5 sections
				double[] startPos = {2.0, -8.0, -3.25};
				double[][] currentPoints = BioGraphics.octogonYPlane(startPos, circumference);
	
	
				System.out.println("Calling Generate InternalJugularVeinEndothelium: " + componentID + "    " + parentID);
				
				int success = bioMightBean.generateInternalJugularVein("InternalJugularVeinEndothelium:00480", "InternalJugularVeinEndothelium", 
					"InternalJugularVeinEndothelium", componentID, parentID, currentPoints);			
					
			}

			else if (parentID.equals("")) 
			{	
				System.out.println("Calling Generate InternalJugularVeinEndothelium NoParent");
							
			}
			
			System.out.println("Created InternalJugularVeinEndothelium Info using EJB");   	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - InternalJugularVeinEndothelium");
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
	 * This method will return the X3D for the InternalJugularVein.  It runs through each of its 
	 * components and collects up their representations and then assembles them into one unified X3D model.
	 * 
	 ********************************************************************************************************************/

	public String getX3D(boolean snipet) {
		
		// Assemble the InternalJugularVein
		String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
		"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n " +
		"<X3D profile='Immersive' >\n" +
		"<head>\n" +
		 "<meta name='BioMightImage' content='InternalJugularVein .jpg'/>\n" +
		 "<meta name='ExportTime' content='7:45:30'/>\n" +
		 "<meta name='ExportDate' content='08/15/2008'/>\n" +
		 "<meta name='BioMight Version' content='1.0'/>\n" + 
		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='InternalJugularVein '\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		


		String body = "";
		
		
		int view = Constants.VIEW_FLOATING;
		if (view == Constants.VIEW_FLOATING)
		{
			 body = endothelium.getX3D(true);  		
		}
		else if (view == Constants.VIEW_DETACHED)
		{
		
			// Run through the collection of InternalJugularVein  and build them into the model
			// In the default case, we get one instance of the InternalJugularVein  for each Stomach
			ArrayList transforms = bioMightTransforms.getTransforms();
			for (int i=0; i<transforms.size(); i++)
			{
				// Get the information for the InternalJugularVein we are creating
				BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
				System.out.println("Getting InternalJugularVein X3D: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
		
		
				//System.out.println("Getting X3D for InternalJugularVein X: " + bioMightSphere.getTranslation().getXPos());
				//System.out.println("Getting X3D for InternalJugularVein Y: " + bioMightSphere.getTranslation().getYPos());
				//System.out.println("Getting X3D for InternalJugularVein Z: " + bioMightSphere.getTranslation().getZPos());
				// Change the height and width based on the displacement.
				body += "<Transform DEF='InternalJugularVein '\n" +
		 			"translation='" + bioMightTransform.getTranslation().getXPos() + " " 
			 					+ bioMightTransform.getTranslation().getYPos() + " "
			 					+ bioMightTransform.getTranslation().getZPos() + "'\n" +
			 		"scale='" 	+ bioMightTransform.getScale().getXPos() + " "
			 				+ bioMightTransform.getScale().getYPos() + " "
			 				+ bioMightTransform.getScale().getZPos() + "'>\n" +
					"<Shape DEF='InternalJugularVein Shape'\n" +
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
						 	"<IndexedFaceSet DEF='InternalJugularVein IFS' \n" +
						    	   "containerField='geometry' \n" +
						    	   "creaseAngle='" +  bioMightTransform.getCreaseAngle() + "'\n" +
						    	   "coordIndex='" + bioMightTransform.getCoordindexStr() + "'>" +
						    	   "<Coordinate DEF='InternalJugularVein _Coord' \n" +
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
			 "<ROUTE fromNode='StomachBeatAnim' fromField='value_changed' toNode='InternalJugularVein' toField='set_scale'/>\n";
			}
		}
		else
		{
			body = "";//						
		}
		
		
		//System.out.println("InternalJugularVein X3D: " + body);		
		String footer = "</Scene>" + "</X3D>\n";
		
		if (snipet)
			return body;			
		else	
			return header + body + footer;
	}	
	
}
