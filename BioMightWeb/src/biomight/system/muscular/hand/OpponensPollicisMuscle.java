/*
 * Created on Sep 20, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.system.muscular.hand;
import biomight.system.tissue.muscle.Muscle; 

import java.util.ArrayList; 

import javax.naming.InitialContext;



import biomight.Constants;
import biomight.ejb.BioMightBeanLocal;
import biomight.ejb.BioMightMuscularBeanLocal;
import biomight.exceptions.ServerException;
import biomight.system.tissue.muscle.Muscle;
import biomight.system.tissue.muscle.MuscleTissue;
import biomight.view.BioMightMethodView;
import biomight.view.BioMightPosition;
import biomight.view.BioMightPropertyView;
import biomight.view.BioMightTransform;
import biomight.view.BioMightTransforms;

/*************************************************************
 * Opponens Pollicis Muscle
 * @author SurferJim
 *
 * Representation of the OpponensPollicisMuscle
 ************************************************************/

public class OpponensPollicisMuscle extends Muscle {
	protected MuscleTissue muscleTissue;
	
	
	/******************************************************************************
	 * CONSTRUCTUORS
	 *****************************************************************************/
	public OpponensPollicisMuscle()
	{
		create(Constants.OpponensPollicisMuscle, null);
	}

	public OpponensPollicisMuscle(String parentID)
	{
		create(parentID, null);
	}
	
	public OpponensPollicisMuscle(String parentID, ArrayList<BioMightMethodView> bioMightMethods)
	{
		create(parentID, bioMightMethods);
	}

	
	/*****************************************************************************
	 * CREATE
	 * 
	 * Create an instance of the OpponensPollicisMuscle
	 * 
	 * @param parentID
	 * @param bioMightMethods
	 ****************************************************************************/
	
	public void create(String parentID, ArrayList<BioMightMethodView> bioMightMethods)
	{
		this.setImage("images/OpponensPollicisMuscle.jpg");
		this.setImageHeight(300);
		this.setImageWidth(300);
	
		
		viewPerspective = Constants.VIEW_FLOATING;
		if (viewPerspective == Constants.VIEW_FLOATING) {	
			
			// This is a collection.   The OpponensPollicisMuscles class gets the data
			// and passes thier key in as a parameter here. The lookup to the data
			// has already been done in the collection class
			componentID=parentID;
			
			// Generate the Opponens Pollicis Muscle if needed 
			boolean bGenerate = false;
			if (bGenerate) {
				generate(parentID, componentID);
			}
			
			// Create the tissue for the muscle
			System.out.println("Creating OpponensPollicisMuscleTissue: " +  parentID);				
			muscleTissue = new MuscleTissue("OpponensPollicisMuscleTissue", parentID, bioMightMethods);
			initProperty("OpponensPollicisMuscleTissue", Constants.MuscleTissue, Constants.MuscleTissueRef, muscleTissue.getComponentID());
			System.out.println("OpponensPollicisMuscle MuscleTissue is created : " + parentID);		
	
		} 
		else if (viewPerspective == Constants.VIEW_INTERNAL) 
		{	
			// We are looking at object not in the context of the collection
			// so we need to go the the database via the Enterprise bean
			// to get the data
			
			// Get the information from the database via the Enterprise Bean		
			try {
				// Get the information from the database via the Enterprise Bean		
				System.out.println("Getting OpponensPollicisMuscleInfo for ParentID: " + parentID);
				InitialContext ctx = new InitialContext();
				BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
				bioMightTransforms = bioMightBean.getComponents(Constants.OpponensPollicisMuscleRef, parentID);
				System.out.println("Have OpponensPollicisMuscle Info from EJB");   	
			}catch (Exception e) { 
				System.out.println("Exception Getting Components - OpponensPollicisMuscle");
				throw new ServerException("Remote Exception getComponents():", e); 	
			}
			
			// Run through the collection of OpponensPollicisMuscles and build them into the model
			// In the default case, we get one instance of the OpponensPollicisMuscle
			ArrayList transforms = bioMightTransforms.getTransforms();
			System.out.println("OpponensPollicisMuscle NumTransforms: " + transforms.size());
			for (int i=0; i<transforms.size(); i++)
			{
				// Get the information for the eye we are creating
				BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
				this.componentID = bioMightTransform.getId();
				System.out.println("Creating OpponensPollicisMuscleTissue: " + bioMightTransform.getId());				
				muscleTissue = new MuscleTissue("OpponensPollicisMuscleTissue", bioMightTransform.getId(), bioMightMethods);
				initProperty("OpponensPollicisMuscleTissue", Constants.MuscleTissue, Constants.MuscleTissueRef, muscleTissue.getComponentID());
				
			}
		}
	
		
		//initProperties();
		initMethods();
		
		System.out.println("CreateOpponensPollicisMuscle Completed");
		
		// First, get all the data from the database
		// Apply the methods to it
		// Save its state
		this.parentID = parentID;
		if (bioMightMethods != null){
			System.out.println("EXECUTING OpponensPollicisMuscle METHODS: " + bioMightMethods.size());
			//executeMethods(bioMightMethods);
		}
	}
	
	
	
	/**********************************************************************
	 * GENERATE Opponens Pollicis Muscle
	 * 
	 * @param parentID
	 * @param componentID
	 ********************************************************************/
	
	public void generate(String parentID, String componentID)
	{
		// Generate the OpponensPollicisMuscle Epithelium		
		BioMightMuscularBeanLocal bioMightBean;
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Generating the OpponensPollicisMuscle ParentID: " + parentID);
			InitialContext ctx = new InitialContext();
			bioMightBean = (BioMightMuscularBeanLocal) ctx.lookup("java:global/BioMightWeb/BioMightMuscularBean!biomight.ejb.BioMightMuscularBeanLocal"); 
	
			double circumference = 0.125;
		
		// Left Opponens Pollicis
		 if (parentID.equals("OpponensPollicisMuscle:01")) 
			{	
				// Generate the OpponensPollicisMuscle
				//  seven sections
				double[] startPos = {1.5, -30.0, -2.0};
				
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

				
	    	int success = bioMightBean.generateOpponensPollicisMuscle("OpponensPollicisMuscleTissue:00001", "OpponensPollicisMuscleTissue", 
					"OpponensPollicisMuscleTissue", componentID, parentID, currentPoints);			
		}
		// Right Opponens Pollicis
		else  if (parentID.equals("OpponensPollicisMuscle:02")) 
		{	
			// Generate the GallBladder
			double[] startPos = {-1.5, -30.0, -2.0};
				
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

			
	    	int success = bioMightBean.generateOpponensPollicisMuscle("OpponensPollicisMuscleTissue:00096", "OpponensPollicisMuscleTissue", 
					"OpponensPollicisMuscleTissue", componentID, parentID, currentPoints);			
		}
		
			
			System.out.println("Created OpponensPollicisMuscleTissue Info using EJB");   	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - OpponensPollicisMuscleTissue");
			throw new ServerException("Remote Exception getComponents():", e); 	
		}
	}


	/*****************************************
	 * INITIALIZE METHODS
	 * 
	 ****************************************/
	
	public void initProperties() {

		properties = new ArrayList<BioMightPropertyView>();
		
		BioMightPropertyView property = new BioMightPropertyView();
		property.setPropertyName("Muscle Tissue");
		property.setCanonicalName(Constants.MuscleTissue);
		properties.add(property);
				
		property = new BioMightPropertyView();
		property.setPropertyName("Veins");
		property.setCanonicalName(Constants.Vein);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("Arteries");
		property.setCanonicalName(Constants.Artery);
		properties.add(property);
	}
	
	
	/*****************************************
	 * INITIALIZE METHODS
	 * 
	 ****************************************/
	public void initMethods() {

		methods = new ArrayList<BioMightMethodView>();
		
		BioMightMethodView method = new BioMightMethodView();

		method = new BioMightMethodView();
		method.setMethodName("Expand");
		method.setHtmlType("checkbox");
		methods.add(method);	
		
		method = new BioMightMethodView();
		method.setMethodName("Constrict");
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
	 * This method will return the X3D for the OpponensPollicisMuscle.  It runs through each of its 
	 * components and collects up their representations and then assembles them into one unified X3D model.
	 * 
	 ********************************************************************************************************************/
	
	
	public String getX3D(boolean snipet) {
		
		// Assemble the Greater Curvature
		String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
		"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n " +
		"<X3D profile='Immersive' >\n" +
		"<head>\n" +
		 "<meta name='BioMightImage' content='OpponensPollicisMuscle.jpg'/>\n" +
		 "<meta name='ExportTime' content='7:45:30'/>\n" +
		 "<meta name='ExportDate' content='08/15/2008'/>\n" +
		 "<meta name='BioMight Version' content='1.0'/>\n" + 
		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='OpponensPollicisMuscle'\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		

	
		String body = "";
		viewPerspective = Constants.VIEW_FLOATING;
		if (viewPerspective == Constants.VIEW_FLOATING) {
			// Go down a layer to get the X3D
			body = muscleTissue.getX3D(true);
		}
		else if (viewPerspective == Constants.VIEW_INTERNAL) 
		{		
			// Get It now at this level of detail
			// Run through the collection of OpponensPollicisMuscle  and build them into the model
			// In the default case, we get one instance of the OpponensPollicisMuscle  for each Stomach
			ArrayList transforms = bioMightTransforms.getTransforms();
			for (int i=0; i<transforms.size(); i++)
			{
				// Get the information for the OpponensPollicisMuscle we are creating
				BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
				System.out.println("Getting OpponensPollicisMuscle X3D: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
		
	
				//System.out.println("Getting X3D for OpponensPollicisMuscle X: " + bioMightSphere.getTranslation().getXPos());
				//System.out.println("Getting X3D for OpponensPollicisMuscle Y: " + bioMightSphere.getTranslation().getYPos());
				//System.out.println("Getting X3D for OpponensPollicisMuscle Z: " + bioMightSphere.getTranslation().getZPos());
				// Change the height and width based on the displacement.
				body += "<Transform DEF='OpponensPollicisMuscle '\n" +
		 			"translation='" + bioMightTransform.getTranslation().getXPos() + " " 
			 					+ bioMightTransform.getTranslation().getYPos() + " "
			 					+ bioMightTransform.getTranslation().getZPos() + "'\n" +
			 		"scale='" 	+ bioMightTransform.getScale().getXPos() + " "
			 				+ bioMightTransform.getScale().getYPos() + " "
			 				+ bioMightTransform.getScale().getZPos() + "'>\n" +
					"<Shape DEF='OpponensPollicisMuscle Shape'\n" +
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
						 	"<IndexedFaceSet DEF='OpponensPollicisMuscle IFS' \n" +
						    	   "containerField='geometry' \n" +
						    	   "creaseAngle='" +  bioMightTransform.getCreaseAngle() + "'\n" +
						    	   "coordIndex='" + bioMightTransform.getCoordindexStr() + "'>" +
						    	   "<Coordinate DEF='OpponensPollicisMuscle _Coord' \n" +
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
			       "<ROUTE fromNode='StomachBeatAnim' fromField='value_changed' toNode='OpponensPollicisMuscle' toField='set_scale'/>\n";	
				}
			}
		else
		{
			body = "";						
		}	
			
		
		//System.out.println("OpponensPollicisMuscle X3D: " + body);		
		String footer = "</Scene>" + "</X3D>\n";
		
		if (snipet)
			return body;			
		else	
			return header + body + footer;
		}
	
	
}