/*
 * Created on Jul 7, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.system.muscular.chest;
import java.util.ArrayList;

import javax.naming.InitialContext;



import biomight.Constants;
import biomight.ejb.BioMightBeanLocal;
import biomight.ejb.BioMightMuscularBeanLocal;
import biomight.exceptions.ServerException;
import biomight.system.nervous.nerves.cervicalspinal.*;
import biomight.system.tissue.muscle.Muscle;
import biomight.system.tissue.muscle.MuscleTissue;
import biomight.view.BioMightMethodView;
import biomight.view.BioMightPosition;
import biomight.view.BioMightPropertyView;
import biomight.view.BioMightTransform;
import biomight.view.BioMightTransforms;

public class DiaphragmMuscle extends Muscle {
	protected MuscleTissue muscleTissue;
	
	public DiaphragmMuscle()
	{
		int localVP =  Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG2X;
		create(localVP, localLOD, Constants.DiaphragmMuscle, null, null);
	}
	
	public DiaphragmMuscle(String parentID)
	{				
		int localVP =  Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG2X;
		create(localVP, localLOD, parentID, null, null);	
	}
		
	public DiaphragmMuscle(String parentID, BioMightPosition bioMightPosition)
	{
		int localVP =  Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG2X;
		create(localVP, localLOD, parentID, null, null);
		//this.bioMightPosition = bioMightPosition;
	}
	

	public DiaphragmMuscle(int localVP, int localLOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
	{				
		create(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);	
	}
	
	/*****************************************************************************
	 * CREATE
	 * 
	 * Create an instance of the DiaphragmMuscle
	 * 
	 * @param parentID
	 * @param bioMightMethods
	 ****************************************************************************/
	
	public void create(int localVP, int localLOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
	{		
		this.setImage("images/DiaphragmMuscle.jpg");
		this.setImageHeight(300);
		this.setImageWidth(300);
		componentID=parentID;
		
		if (bioMightMethods != null){
			//System.out.println("EXECUTING DiaphragmMuscle METHODS: " + bioMightMethods.size());
			//executeMethods(bioMightMethods);
		}
		
		viewPerspective = Constants.VIEW_FLOATING;
		if (viewPerspective == Constants.VIEW_FLOATING) {
		
			
			// Generate the Heart Ventricle Endothelium if needed 
			boolean bGenerate = false;
			if (bGenerate) {
				generate(parentID, componentID);
			}
	
			System.out.println("Creating DiaphragmMuscleTissue: " +  parentID);				
			muscleTissue = new MuscleTissue("DiaphragmMuscleTissue", parentID, bioMightMethods);
			System.out.println("DiaphragmMuscle MuscleTissue is created : " + parentID);		
	
		} 
		else if (viewPerspective == Constants.VIEW_INTERNAL) {

			// Get the information from the database via the Enterprise Bean		
			try {
				// Get the information from the database via the Enterprise Bean		
				System.out.println("Getting DiaphragmMuscleInfo for ParentID: " + parentID);
				InitialContext ctx = new InitialContext();
				BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
				bioMightTransforms = bioMightBean.getComponents(Constants.DiaphragmMuscleRef, parentID);
				System.out.println("Have DiaphragmMuscle Info from EJB");   	
			}catch (Exception e) { 
				System.out.println("Exception Getting Components - DiaphragmMuscle");
				throw new ServerException("Remote Exception getComponents():", e); 	
			}
				
			// Run through the collection of DiaphragmMuscles and build them into the model
			// In the default case, we get one instance of the DiaphragmMuscle for each eye
			ArrayList transforms = bioMightTransforms.getTransforms();
			System.out.println("DiaphragmMuscle NumTransforms: " + transforms.size());
			for (int i=0; i<transforms.size(); i++)
			{
				// Get the information for the eye we are creating
				BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
				this.componentID = bioMightTransform.getId();
				System.out.println("Creating DiaphragmMuscleTissue: " + bioMightTransform.getId());				
				muscleTissue = new MuscleTissue("DiaphragmMuscleTissue", bioMightTransform.getId(), bioMightMethods);
			}	
		}
		
		//initProperties();
		initMethods();
		
		System.out.println("CreateDiaphragmMuscle Completed");
	}
	
	
	/******************************************************************
	 * GENERATE DIAPHRAM
	 *  
	 *  In the default diaphram
	 *   
	 * @param parentID
	 * @param componentID
	 ******************************************************************/

	public void generate(String parentID, String componentID)
	{
		// Generate the DiaphramMuscle	
		BioMightMuscularBeanLocal bioMightBean;
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Generating the DiaphramMuscleTissue: " + componentID + "    " + parentID);
			InitialContext ctx = new InitialContext();
			bioMightBean = (BioMightMuscularBeanLocal) ctx.lookup("java:global/BioMightWeb/BioMightMuscularBean!biomight.ejb.BioMightMuscularBeanLocal"); 
	
			double circumference = 0.125;
		
			if (parentID.equals("DiaphragmMuscle:01")) 
			{	
				// Generate the Diaphrammuscle
				double[] startPos = {0.0,-17.0, -4.00};
				
				// Create a equilateral octogon
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
				
				System.out.println("Calling Generate DiaphragmMuscleTissue: " + componentID + "    " + parentID);
				int success = bioMightBean.generateDiaphramMuscle("DiaphragmMuscleTissue:00001", "DiaphragmMuscleTissue", 
					"DiaphragmMuscleTissue", componentID, parentID, currentPoints);			
			}			
			else if (parentID.equals("")) 
			{	
				System.out.println("Calling Generate DiaphragmMuscleTissue NoParent");	
			}
			else 
			{	
				System.out.println("Skipping DiaphragmMuscleTissue ");
							
			}
			
			System.out.println("Created Ventricle DiaphragmMuscleTissue Info using EJB");   	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - DiaphragmMuscleTissue");
			throw new ServerException("Remote Exception DiaphragmMuscleTissue():", e); 	
		}
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
	 * This method will return the X3D for the DiaphragmMuscle.  It runs through each of its 
	 * components and collects up their representations and then assembles them into one unified X3D model.
	 * 
	 ********************************************************************************************************************/
	
	
	public String getX3D(boolean snipet) {
		
		// Assemble the DiaphragmMuscle 
		String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
		"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n " +
		"<X3D profile='Immersive' >\n" +
		"<head>\n" +
		 "<meta name='BioMightImage' content='DiaphragmMuscle .jpg'/>\n" +
		 "<meta name='ExportTime' content='7:45:30'/>\n" +
		 "<meta name='ExportDate' content='08/15/2008'/>\n" +
		 "<meta name='BioMight Version' content='1.0'/>\n" + 
		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='DiaphragmMuscle '\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		


		String body = "";
	
		viewPerspective = Constants.VIEW_FLOATING;
		if (viewPerspective == Constants.VIEW_FLOATING)
		{
			body = muscleTissue.getX3D(true);  
		}
		else if (viewPerspective == Constants.VIEW_BIRDSEYE)
		{
		
			// Run through the collection of DiaphragmMuscle  and build them into the model
			// In the default case, we get one instance of the DiaphragmMuscle  for each Stomach
			ArrayList transforms = bioMightTransforms.getTransforms();
			for (int i=0; i<transforms.size(); i++)
			{
				// Get the information for the DiaphragmMuscle we are creating
				BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
				System.out.println("Getting DiaphragmMuscle X3D: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
		
				//System.out.println("Getting X3D for DiaphragmMuscle X: " + bioMightSphere.getTranslation().getXPos());
				//System.out.println("Getting X3D for DiaphragmMuscle Y: " + bioMightSphere.getTranslation().getYPos());
				//System.out.println("Getting X3D for DiaphragmMuscle Z: " + bioMightSphere.getTranslation().getZPos());
				// Change the height and width based on the displacement.
				body += "<Transform DEF='DiaphragmMuscle '\n" +
		 			"translation='" + bioMightTransform.getTranslation().getXPos() + " " 
			 					+ bioMightTransform.getTranslation().getYPos() + " "
			 					+ bioMightTransform.getTranslation().getZPos() + "'\n" +
			 		"scale='" 	+ bioMightTransform.getScale().getXPos() + " "
			 				+ bioMightTransform.getScale().getYPos() + " "
			 				+ bioMightTransform.getScale().getZPos() + "'>\n" +
					"<Shape DEF='DiaphragmMuscle Shape'\n" +
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
						 	"<IndexedFaceSet DEF='DiaphragmMuscle IFS' \n" +
						    	   "containerField='geometry' \n" +
						    	   "creaseAngle='" +  bioMightTransform.getCreaseAngle() + "'\n" +
						    	   "coordIndex='" + bioMightTransform.getCoordindexStr() + "'>" +
						    	   "<Coordinate DEF='DiaphragmMuscle _Coord' \n" +
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
			 "<ROUTE fromNode='StomachBeatAnim' fromField='value_changed' toNode='DiaphragmMuscle' toField='set_scale'/>\n";	
			}
		}
		else
		{
			body = "";						
		}
		
		
		//System.out.println("DiaphragmMuscle X3D: " + body);		
		String footer = "</Scene>" + "</X3D>\n";
		
		if (snipet)
			return body;			
		else	
			return header + body + footer;

	}
	
	
	
}
