/*
 * Created on May 8, 2007
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.system.vascular.veins.head;


import biomight.Constants;
import biomight.ejb.BioMightBeanLocal;
import biomight.ejb.BioMightVascularBeanLocal;
import biomight.exceptions.ServerException;
import biomight.system.tissue.edothelial.EndotheliumTissue;
import biomight.system.vascular.arteries.Artery;
import biomight.system.vascular.veins.Vein;
import biomight.view.BioMightMethodView;
import biomight.view.BioMightPosition;
import biomight.view.BioMightPropertyView;
import biomight.view.BioMightTransform;

import java.util.ArrayList;

import javax.naming.InitialContext;

/******************************************************************
 * @author SurferJim
 *
 * Representation of the RetroMandibularVein
 ******************************************************************/

public class RetroMandibularVein extends Vein{
protected EndotheliumTissue endothelium;
	
	/*************************************************************
	 * CONSTRUCTORS
	 *************************************************************/
	public RetroMandibularVein()
	{
		create(Constants.RetroMandibularVein, null);
	}

	public RetroMandibularVein(String parentID)
	{
		create(parentID, null);
	}
	
	public RetroMandibularVein(String parentID, ArrayList<BioMightMethodView> bioMightMethods)
	{
		create(parentID, bioMightMethods);
	}

	/******************************************************************************
	 * CREATE
	 * 
	 * Creates a representation of the object
	 * 
	 * @param parentID
	 * @param bioMightMethods
	 *****************************************************************************/
	
	public void create(String parentID, ArrayList<BioMightMethodView> bioMightMethods)
	{
		// Build the model based on what you are looking based on LOD
		int viewPerspective = Constants.VIEW_DETACHED;
		if (viewPerspective == Constants.VIEW_DETACHED)
		{	
			// We are looking at the object via a collection,so 
			// we do not retrieve the information,we already 
			// have it from the parent
			componentID=parentID;
					
			// Generate the RetroMandibularVein if needed 
			boolean bGenerate = false;
			if (bGenerate) {
				generate(parentID, componentID);
			}
		
			// Create the Endothelial layer of the Artery
			System.out.println("Creating RetroMandibularVein Endothelium: " + parentID);	
			endothelium = new EndotheliumTissue("RetroMandibularVeinEndothelium", parentID,bioMightMethods);
			initProperty("RetroMandibularVeinEndothelium", Constants.EndotheliumTissue, Constants.EndotheliumTissueRef, endothelium.getComponentID());
		}
		else // Assemble now
		{			
			// We are not getting the information from a collection,
			// so we need to get the instance inforamtion from the database
			
			// Get the information from the database via the Enterprise Bean		
			try {
				// Get the information from the database via the Enterprise Bean		
				System.out.println("Getting RetroMandibularVeinInfo for ParentID: " + parentID);
				InitialContext ctx = new InitialContext();
				BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
				bioMightTransforms = bioMightBean.getComponents(Constants.RetroMandibularVeinRef, parentID);
				System.out.println("Have RetroMandibularVein Info from EJB");   	
			}catch (Exception e) { 
				System.out.println("Exception Getting Components - RetroMandibularVein");
				throw new ServerException("Remote Exception getComponents():", e); 	
			}
				
			// Run through the collection of RetroMandibularVeins and build them into the model
			// In the default case, we get one instance of the RetroMandibularVein for each eye
			ArrayList transforms = bioMightTransforms.getTransforms();
			System.out.println("RetroMandibularVein NumTransforms: " + transforms.size());
			for (int i=0; i<transforms.size(); i++)
			{
				// Get the information for the eye we are creating
				BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
				System.out.println("Created RetroMandibularVein: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
				this.componentID = bioMightTransform.getId();
			
				// Create the Endotheliallayer of the Artery
				System.out.println("Creating RetroMandibularVein Endothelium: " + bioMightTransform.getId());	
				endothelium = new EndotheliumTissue("RetroMandibularVeinEndothelium", bioMightTransform.getId(),bioMightMethods);
				initProperty("RetroMandibularVeinEndothelium", Constants.EndotheliumTissue, Constants.EndotheliumTissueRef, endothelium.getComponentID());
			}
			
		}
		
		//initProperties();
		initMethods();
		
		System.out.println("CreateRetroMandibularVein Completed");
		
		// First, get all the data from the database
		// Apply the methods to it
		// Save its state
		this.parentID = parentID;
		if (bioMightMethods != null){
			System.out.println("EXECUTING RetroMandibularVein METHODS: " + bioMightMethods.size());
			//executeMethods(bioMightMethods);
		}
	}
	
	
	/************************************************************************************
	 * GENERATE RetroMandibularVein
	 * 
	 * Call the Generate routine to update or create an instance of the object using the
	 * specified parameters.
	 * 
	 * @param parentID
	 * @param componentID
	 *************************************************************************************/
	
	public void generate(String parentID, String componentID)
	{
		// Generate the VertebalArtery Edothelium		
		BioMightVascularBeanLocal bioMightBean;
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Generating the RetroMandibularVeinEndothelium: " + componentID + "    " + parentID);
			InitialContext ctx = new InitialContext();
			bioMightBean = (BioMightVascularBeanLocal) ctx.lookup("java:global/BioMightWeb/BioMightVacularBean!biomight.ejb.BioMightVascularBeanLocal");
	
			double circumference = 0.25;
		
			if (parentID.equals("RetroMandibularVein:01")) 
			{	
				// Generate the RetroMandibularVeinEndothelium of the stomach
				// Create 5 sections
				double[] startPos = {-2.75,-24.0, -3.0};
				
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

	
				System.out.println("Calling Generate RetroMandibularVeinEndothelium: " + componentID + "    " + parentID);
				
			//	int success = bioMightBean.generateRetroMandibularVein("RetroMandibularVeinEndothelium:00001", "RetroMandibularVeinEndothelium", 
			//		"RetroMandibularVeinEndothelium", componentID, parentID, currentPoints);			
					
			}			
			else if (parentID.equals("RetroMandibularVein:02"))
			{	
				// Generate the RetroMandibularVeinEndothelium of the stomach
				// Create 5 sections
				double[] startPos = {-3.00,-24.0, -3.0};
				
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
	
				System.out.println("Calling Generate RetroMandibularVeinEndothelium: " + componentID + "    " + parentID);
				//int success = bioMightBean.generateRetroMandibularVein("RetroMandibularVeinEndothelium:00080", "RetroMandibularVeinEndothelium", 
				//	"RetroMandibularVeinEndothelium", componentID, parentID, currentPoints);							
			}
	

			System.out.println("Created RetroMandibularVeinEndothelium Info using EJB");   	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - RetroMandibularVeinEndothelium");
			throw new ServerException("Remote Exception RetroMandibularVeinEndothelium():", e); 	
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
	 * This method will return the X3D for the RetroMandibularVein.  It runs through each of its 
	 * components and collects up their representations and then assembles them into one unified X3D model.
	 * 
	 ********************************************************************************************************************/

	public String getX3D(boolean snipet) {
		
		// Assemble the RetroMandibularVein
		String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
		"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n " +
		"<X3D profile='Immersive' >\n" +
		"<head>\n" +
		 "<meta name='BioMightImage' content='RetroMandibularVein .jpg'/>\n" +
		 "<meta name='ExportTime' content='7:45:30'/>\n" +
		 "<meta name='ExportDate' content='08/15/2008'/>\n" +
		 "<meta name='BioMight Version' content='1.0'/>\n" + 
		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='RetroMandibularVein '\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		


		String body = "";
		
		
		int view = Constants.VIEW_FLOATING;
		if (view == Constants.VIEW_FLOATING)
		{
			 body = endothelium.getX3D(true);  		
		}
		else if (view == Constants.VIEW_DETACHED)
		{
		
			// Run through the collection of RetroMandibularVein  and build them into the model
			// In the default case, we get one instance of the RetroMandibularVein  for each Stomach
			ArrayList transforms = bioMightTransforms.getTransforms();
			for (int i=0; i<transforms.size(); i++)
			{
				// Get the information for the RetroMandibularVein we are creating
				BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
				System.out.println("Getting RetroMandibularVein X3D: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
		
		
				//System.out.println("Getting X3D for RetroMandibularVein X: " + bioMightSphere.getTranslation().getXPos());
				//System.out.println("Getting X3D for RetroMandibularVein Y: " + bioMightSphere.getTranslation().getYPos());
				//System.out.println("Getting X3D for RetroMandibularVein Z: " + bioMightSphere.getTranslation().getZPos());
				// Change the height and width based on the displacement.
				body += "<Transform DEF='RetroMandibularVein '\n" +
		 			"translation='" + bioMightTransform.getTranslation().getXPos() + " " 
			 					+ bioMightTransform.getTranslation().getYPos() + " "
			 					+ bioMightTransform.getTranslation().getZPos() + "'\n" +
			 		"scale='" 	+ bioMightTransform.getScale().getXPos() + " "
			 				+ bioMightTransform.getScale().getYPos() + " "
			 				+ bioMightTransform.getScale().getZPos() + "'>\n" +
					"<Shape DEF='RetroMandibularVein Shape'\n" +
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
						 	"<IndexedFaceSet DEF='RetroMandibularVein IFS' \n" +
						    	   "containerField='geometry' \n" +
						    	   "creaseAngle='" +  bioMightTransform.getCreaseAngle() + "'\n" +
						    	   "coordIndex='" + bioMightTransform.getCoordindexStr() + "'>" +
						    	   "<Coordinate DEF='RetroMandibularVein _Coord' \n" +
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
			 "<ROUTE fromNode='StomachBeatAnim' fromField='value_changed' toNode='RetroMandibularVein' toField='set_scale'/>\n";
			}
		}
		else
		{
			body = "";//						
		}
		
		
		//System.out.println("RetroMandibularVein X3D: " + body);		
		String footer = "</Scene>" + "</X3D>\n";
		
		if (snipet)
			return body;			
		else	
			return header + body + footer;
	}	
	
	
}