/*
GastroEpiploicArtery.java * Created on Sep 10, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.system.vascular.veins.abdomen;

import java.util.ArrayList;

import javax.naming.InitialContext;



import biomight.Constants;
import biomight.ejb.BioMightBeanLocal;
import biomight.ejb.BioMightVascularBeanLocal;
import biomight.exceptions.ServerException;
import biomight.system.tissue.edothelial.EndotheliumTissue;
import biomight.system.vascular.veins.Vein;
import biomight.view.BioMightMethodView;
import biomight.view.BioMightPosition;
import biomight.view.BioMightPropertyView;
import biomight.view.BioMightTransform;

/**
 * @author SurferJim
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class GastroEpiploicVein extends Vein {
protected EndotheliumTissue endothelium;
	
	
	public GastroEpiploicVein()
	{
		create(Constants.GastroEpiploicVein, null);
	}

	public GastroEpiploicVein(String parentID)
	{
		create(parentID, null);
	}
	
	public GastroEpiploicVein(String parentID, ArrayList<BioMightMethodView> bioMightMethods)
	{
		create(parentID, bioMightMethods);
	}

	
	public void create(String parentID, ArrayList<BioMightMethodView> bioMightMethods)
	{
		// Build the model based on what you are looking based on LOD
		int viewPerspective = Constants.VIEW_DETACHED;
		if (viewPerspective == Constants.VIEW_DETACHED)
		{	
			componentID=parentID;

			// Generate the GastroEpiploicVein Endothelium if needed 
			boolean bGenerate = false;
			if (bGenerate) {
				generate(parentID, componentID);
			}
				
			System.out.println("Creating GastroEpiploicVein Endothelium: " + parentID);	
			endothelium = new EndotheliumTissue("GastroEpiploicVeinEndothelium", parentID,bioMightMethods);
			initProperty("GastroEpiploicVeinEndothelium", Constants.EndotheliumTissue, Constants.EndotheliumTissueRef, endothelium.getComponentID());
		}
		else // Assemble now
		{			
			// Get the information from the database via the Enterprise Bean		
			try {
				// Get the information from the database via the Enterprise Bean		
				System.out.println("Getting GastroEpiploicVeinInfo for ParentID: " + parentID);
				InitialContext ctx = new InitialContext();
				BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
				bioMightTransforms = bioMightBean.getComponents(Constants.GastroEpiploicVeinRef, parentID);
				System.out.println("Have GastroEpiploicVein Info from EJB");   	
			}catch (Exception e) { 
				System.out.println("Exception Getting Components - GastroEpiploicVein");
				throw new ServerException("Remote Exception getComponents():", e); 	
			}
				
			// Run through the collection of GastroEpiploicVeins and build them into the model
			// In the default case, we get one instance of the GastroEpiploicVein for each eye
			ArrayList transforms = bioMightTransforms.getTransforms();
			System.out.println("GastroEpiploicVein NumTransforms: " + transforms.size());
			for (int i=0; i<transforms.size(); i++)
			{
				// Get the information for the eye we are creating
				BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
				System.out.println("Created GastroEpiploicVein: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
				this.componentID = bioMightTransform.getId();
				
				System.out.println("Creating GastroEpiploicVein Endothelium: " + bioMightTransform.getId());	
				endothelium = new EndotheliumTissue("GastroEpiploicVeinEndothelium", bioMightTransform.getId(),bioMightMethods);
				initProperty("GastroEpiploicVeinEndothelium", Constants.EndotheliumTissue, Constants.EndotheliumTissueRef, endothelium.getComponentID());
			}
			
		}
		
		//initProperties();
		initMethods();
		
		System.out.println("CreateGastroEpiploicVein Completed");
		
		// First, get all the data from the database
		// Apply the methods to it
		// Save its state
		this.parentID = parentID;
		if (bioMightMethods != null){
			System.out.println("EXECUTING GastroEpiploicVein METHODS: " + bioMightMethods.size());
			//executeMethods(bioMightMethods);
		}
	}
	
	

	/****************************************************
	 * GENERATE
	 * 
	 * 
	 * @param parentID
	 * @param componentID
	 ***************************************************/
	public void generate(String parentID, String componentID)
	{
		// Generate the GastroEpiploicVein Edothelium		
		BioMightVascularBeanLocal bioMightBean;
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Generating the GastroEpiploicVein Endothelium: " + componentID + "    " + parentID);
			InitialContext ctx = new InitialContext();
			bioMightBean = (BioMightVascularBeanLocal) ctx.lookup("java:global/BioMightWeb/BioMightVacularBean!biomight.ejb.BioMightVascularBeanLocal");
	
			double circumference = 0.125;
		
			
			if (parentID.equals("GastroEpiploicVein:01")) 
			{	
				// Generate the GastroEpiploicVein Endothelium of the stomach
				// Create 5 sections
				double[] startPos = {-0.25,-23.0, -6.0};
				
				// Create a equilateral octogon
				double x =  startPos[0];
				double y =  startPos[1];
				double z =  startPos[2];

				
				double[][] currentPoints = { 
	   				 {x, y, z},
	     				 {x, y-circumference,     z-circumference},
	     				 {x, y-(circumference*2), z-circumference},
	     				 {x, y-(circumference*3), z},
	     				 {x, y-(circumference*3), z+(circumference)},
	     				 {x, y-(circumference*2), z+(circumference*2)},
	     				 {x, y-circumference,     z+(circumference*2)},
	     				 {x, y, z+circumference}
	      		};

	
				System.out.println("Calling Generate GastroEpiploicVeinEndothelium: " + componentID + "    " + parentID);
				
				int success = bioMightBean.generateGastroEpiploicVein("GastroEpiploicVeinEndothelium:00001", "GastroEpiploicVeinEndothelium", 
					"GastroEpiploicVeinEndothelium", componentID, parentID, currentPoints);			
					
			}			
			else if (parentID.equals("GastroEpiploicVein:02")) 
			{	
				// Generate the GastroEpiploicVein Endothelium of the stomach
				// Create 5 sections
				double[] startPos = {0.25,-23.0, -6.0};
				
				// Create a equilateral octogon
				double x =  startPos[0];
				double y =  startPos[1];
				double z =  startPos[2];

				// Runs side to side
				double[][] currentPoints = { 
		   				 {x, y, z},
		     				 {x, y-circumference,     z-circumference},
		     				 {x, y-(circumference*2), z-circumference},
		     				 {x, y-(circumference*3), z},
		     				 {x, y-(circumference*3), z+(circumference)},
		     				 {x, y-(circumference*2), z+(circumference*2)},
		     				 {x, y-circumference,     z+(circumference*2)},
		     				 {x, y, z+circumference}
		      		};
	
				System.out.println("Calling Generate GastroEpiploicVeinEndothelium: " + componentID + "    " + parentID);
				
				int success = bioMightBean.generateGastroEpiploicVein("GastroEpiploicVeinEndothelium:00080", "GastroEpiploicVeinEndothelium", 
					"GastroEpiploicVeinEndothelium", componentID, parentID, currentPoints);			
					
			}
			else if (parentID.equals("")) 
			{	
				System.out.println("Calling Generate GastroEpiploicVeinEndothelium NoParent");
							
			}

			
			System.out.println("Created GastroEpiploicVeinEndothelium Info using EJB");   	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - GastroEpiploicVeinEndothelium");
			throw new ServerException("Remote Exception GastroEpiploicVeinEndothelium():", e); 	
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
	 * This method will return the X3D for the GastroEpiploicVein.  It runs through each of its 
	 * components and collects up their representations and then assembles them into one unified X3D model.
	 * 
	 ********************************************************************************************************************/

	public String getX3D(boolean snipet) {
		
		// Assemble the GastroEpiploicVein
		String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
		"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n " +
		"<X3D profile='Immersive' >\n" +
		"<head>\n" +
		 "<meta name='BioMightImage' content='GastroEpiploicVein .jpg'/>\n" +
		 "<meta name='ExportTime' content='7:45:30'/>\n" +
		 "<meta name='ExportDate' content='08/15/2008'/>\n" +
		 "<meta name='BioMight Version' content='1.0'/>\n" + 
		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='GastroEpiploicVein '\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		


		String body = "";
		
		
		int view = Constants.VIEW_FLOATING;
		if (view == Constants.VIEW_FLOATING)
		{
			 body = endothelium.getX3D(true);  		
		}
		else if (view == Constants.VIEW_DETACHED)
		{
		
			// Run through the collection of GastroEpiploicVein  and build them into the model
			// In the default case, we get one instance of the GastroEpiploicVein  for each Stomach
			ArrayList transforms = bioMightTransforms.getTransforms();
			for (int i=0; i<transforms.size(); i++)
			{
				// Get the information for the GastroEpiploicVein we are creating
				BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
				System.out.println("Getting GastroEpiploicVein X3D: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
		
		
				//System.out.println("Getting X3D for GastroEpiploicVein X: " + bioMightSphere.getTranslation().getXPos());
				//System.out.println("Getting X3D for GastroEpiploicVein Y: " + bioMightSphere.getTranslation().getYPos());
				//System.out.println("Getting X3D for GastroEpiploicVein Z: " + bioMightSphere.getTranslation().getZPos());
				// Change the height and width based on the displacement.
				body += "<Transform DEF='GastroEpiploicVein '\n" +
		 			"translation='" + bioMightTransform.getTranslation().getXPos() + " " 
			 					+ bioMightTransform.getTranslation().getYPos() + " "
			 					+ bioMightTransform.getTranslation().getZPos() + "'\n" +
			 		"scale='" 	+ bioMightTransform.getScale().getXPos() + " "
			 				+ bioMightTransform.getScale().getYPos() + " "
			 				+ bioMightTransform.getScale().getZPos() + "'>\n" +
					"<Shape DEF='GastroEpiploicVein Shape'\n" +
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
						 	"<IndexedFaceSet DEF='GastroEpiploicVein IFS' \n" +
						    	   "containerField='geometry' \n" +
						    	   "creaseAngle='" +  bioMightTransform.getCreaseAngle() + "'\n" +
						    	   "coordIndex='" + bioMightTransform.getCoordindexStr() + "'>" +
						    	   "<Coordinate DEF='GastroEpiploicVein _Coord' \n" +
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
			 "<ROUTE fromNode='StomachBeatAnim' fromField='value_changed' toNode='GastroEpiploicVein' toField='set_scale'/>\n";
			}
		}
		else
		{
			body = "";//						
		}
		
		
		//System.out.println("GastroEpiploicVein X3D: " + body);		
		String footer = "</Scene>" + "</X3D>\n";
		
		if (snipet)
			return body;			
		else	
			return header + body + footer;
	}	
	
	
}
