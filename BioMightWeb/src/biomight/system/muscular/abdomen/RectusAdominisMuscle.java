/*
 * Created on Sep 20, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.system.muscular.abdomen;
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

/**
 * @author SurferJim
 *
 * Represnetation of the RectusAdominisMuscle
 */

public class RectusAdominisMuscle extends Muscle {
	private BioMightTransforms bioMightTransforms;
	private String componentID;
	private String parentID;
	private ArrayList<BioMightPropertyView> properties;
	private ArrayList<BioMightMethodView> methods;
	protected MuscleTissue muscleTissue;
	
	
	public RectusAdominisMuscle()
	{
		create(Constants.RectusAdominisMuscle, null);
	}

	public RectusAdominisMuscle(String parentID)
	{
		create(parentID, null);
	}
	
	public RectusAdominisMuscle(String parentID, ArrayList<BioMightMethodView> bioMightMethods)
	{
		create(parentID, bioMightMethods);
	}

	
	public void create(String parentID, ArrayList<BioMightMethodView> bioMightMethods)
	{
		this.setImage("images/RectusAdominisMuscle.jpg");
		this.setImageHeight(300);
		this.setImageWidth(300);
	

		viewPerspective = Constants.VIEW_FLOATING;
		if (viewPerspective == Constants.VIEW_FLOATING) {
			componentID=parentID;
			
			// Generate the RectusAdominisMuscleTissue if needed 
			boolean bGenerate = false;
			if (bGenerate) {
				generate(parentID, componentID);
			}
	
			System.out.println("Creating RectusAdominisMuscleTissue: " +  parentID);				
			muscleTissue = new MuscleTissue("RectusAdominisMuscleTissue", parentID, bioMightMethods);
			System.out.println("RectusAdominisMuscle MuscleTissue is created : " + parentID);		
	
		} 
		else if (viewPerspective == Constants.VIEW_INTERNAL) {		
			
			// Get the information from the database via the Enterprise Bean		
			try {
				// Get the information from the database via the Enterprise Bean		
				System.out.println("Getting RectusAdominisMuscleInfo for ParentID: " + parentID);
				InitialContext ctx = new InitialContext();
				BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
				bioMightTransforms = bioMightBean.getComponents(Constants.RectusAdominisMuscleRef, parentID);
				System.out.println("Have RectusAdominisMuscle Info from EJB");   	
			}catch (Exception e) { 
				System.out.println("Exception Getting Components - RectusAdominisMuscle");
				throw new ServerException("Remote Exception getComponents():", e); 	
			}
				
			// Run through the collection of RectusAdominisMuscles and build them into the model
			// In the default case, we get one instance of the RectusAdominisMuscle for each eye
			ArrayList transforms = bioMightTransforms.getTransforms();
			System.out.println("RectusAdominisMuscle NumTransforms: " + transforms.size());
			for (int i=0; i<transforms.size(); i++)
			{
				// Get the information for the Muscle we are creating
				BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
				this.componentID = bioMightTransform.getId();
				System.out.println("Creating RectusAdominisMuscleTissue: " + bioMightTransform.getId());				
				muscleTissue = new MuscleTissue("RectusAdominisMuscleTissue", bioMightTransform.getId(), bioMightMethods);
				
				
				/*int viewPerspective = Constants.VIEW_DETACHED;
				if (viewPerspective == Constants.VIEW_DETACHED)
				{				
					// Create the components of the curvature

				}*/
			}		
			
		}
	
		
		initProperties();
		initMethods();
		
		System.out.println("Create RectusAdominisMuscle Completed");
		
		// First, get all the data from the database
		// Apply the methods to it
		// Save its state
		this.parentID = parentID;
		if (bioMightMethods != null){
			System.out.println("EXECUTING RectusAdominisMuscle METHODS: " + bioMightMethods.size());
			//executeMethods(bioMightMethods);
		}
	}
	
	

	/*******************************************************************
	 * Generate the RectusAdominis Muscle
	 * 
	 * @param parentID
	 * @param componentID
	 ****************************************************************/
	
	public void generate(String parentID, String componentID)
	{
		// Generate the RectusAdominisMuscle Epithelium		
		BioMightMuscularBeanLocal bioMightBean;
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Generating the RectusAdominisMuscleTissue ParentID: " + parentID);
			InitialContext ctx = new InitialContext();
			bioMightBean = (BioMightMuscularBeanLocal) ctx.lookup("java:global/BioMightWeb/BioMightMuscularBean!biomight.ejb.BioMightMuscularBeanLocal"); 
	
			// Set the base circumference and radius
			double circumference = 1.0;
			double radius = 0.125;
			
		
		 if (parentID.equals("RectusAdominisMuscle:01")) 
			{	
			 // Generate the RectusAdominisMuscle
				//  seven sections
				double[] startPos = {0.5, -16.5, -1.25};
				
				// Create a equilateral octogon
				double x =  startPos[0];
				double y =  startPos[1];
				double z =  startPos[2];

				double[][] currentPoints = { 
		   				 {x, y, z},
		     				 {x, y-circumference,     z-radius},
		     				 {x, y-(circumference*2), z-radius},
		     				 {x, y-(circumference*3), z},
		     				 {x, y-(circumference*3), z+(radius)},
		     				 {x, y-(circumference*2), z+(radius*2)},
		     				 {x, y-circumference,     z+(radius*2)},
		     				 {x, y, z+radius}
		      		};

				
	    	int success = bioMightBean.generateRectusAdominisMuscle("RectusAdominisMuscleTissue:00001", "RectusAdominisMuscleTissue", 
					"RectusAdominisMuscleTissue", componentID, parentID, currentPoints);			
		}
		else  if (parentID.equals("RectusAdominisMuscle:02")) 
		{	
			// Generate the GallBladder
			double[] startPos = {-0.5,-16.5, -1.25};
				
			// Create a equilateral octogon
	    	double x =  startPos[0];
	    	double y =  startPos[1];
	    	double z =  startPos[2];

			double[][] currentPoints = { 
	   				 {x, y, z},
	     				 {x, y-circumference,     z-radius},
	     				 {x, y-(circumference*2), z-radius},
	     				 {x, y-(circumference*3), z},
	     				 {x, y-(circumference*3), z+(radius)},
	     				 {x, y-(circumference*2), z+(radius*2)},
	     				 {x, y-circumference,     z+(radius*2)},
	     				 {x, y, z+radius}
	      		};

			
	    	int success = bioMightBean.generateRectusAdominisMuscle("RectusAdominisMuscleTissue:00096", "RectusAdominisMuscleTissue", 
					"RectusAdominisMuscleTissue", componentID, parentID, currentPoints);			
		}
		else  if (parentID.equals("RectusAdominisMuscle:03")) 
		{	
			// Generate the GallBladder
			double[] startPos = {0.5,-20.5, -1.25};
				
			// Create a equilateral octogon
	    	double x =  startPos[0];
	    	double y =  startPos[1];
	    	double z =  startPos[2];

			double[][] currentPoints = { 
	   				 {x, y, z},
	     				 {x, y-circumference,     z-radius},
	     				 {x, y-(circumference*2), z-radius},
	     				 {x, y-(circumference*3), z},
	     				 {x, y-(circumference*3), z+(radius)},
	     				 {x, y-(circumference*2), z+(radius*2)},
	     				 {x, y-circumference,     z+(radius*2)},
	     				 {x, y, z+radius}
	      		};

			
	    	int success = bioMightBean.generateRectusAdominisMuscle("RectusAdominisMuscleTissue:00192", "RectusAdominisMuscleTissue", 
					"RectusAdominisMuscleTissue", componentID, parentID, currentPoints);			
		}
		else  if (parentID.equals("RectusAdominisMuscle:04")) 
		{	
			// Generate the GallBladder
			double[] startPos = {-0.5,-20.5, -1.25};
				
			// Create a equilateral octogon
	    	double x =  startPos[0];
	    	double y =  startPos[1];
	    	double z =  startPos[2];

			double[][] currentPoints = { 
	   				 {x, y, z},
	     				 {x, y-circumference,     z-radius},
	     				 {x, y-(circumference*2), z-radius},
	     				 {x, y-(circumference*3), z},
	     				 {x, y-(circumference*3), z+(radius)},
	     				 {x, y-(circumference*2), z+(radius*2)},
	     				 {x, y-circumference,     z+(radius*2)},
	     				 {x, y, z+radius}
	      		};

			
	    	int success = bioMightBean.generateRectusAdominisMuscle("RectusAdominisMuscleTissue:00284", "RectusAdominisMuscleTissue", 
					"RectusAdominisMuscleTissue", componentID, parentID, currentPoints);			
		}
		else  if (parentID.equals("RectusAdominisMuscle:05")) 
		{	
			// Generate the GallBladder
			double[] startPos = {0.5,-24.5, -1.5};
				
			// Create a equilateral octogon
	    	double x =  startPos[0];
	    	double y =  startPos[1];
	    	double z =  startPos[2];

			double[][] currentPoints = { 
	   				 {x, y, z},
	     				 {x, y-circumference,     z-radius},
	     				 {x, y-(circumference*2), z-radius},
	     				 {x, y-(circumference*3), z},
	     				 {x, y-(circumference*3), z+(radius)},
	     				 {x, y-(circumference*2), z+(radius*2)},
	     				 {x, y-circumference,     z+(radius*2)},
	     				 {x, y, z+radius}
	      		};

			
	    	int success = bioMightBean.generateRectusAdominisMuscle("RectusAdominisMuscleTissue:00372", "RectusAdominisMuscleTissue", 
					"RectusAdominisMuscleTissue", componentID, parentID, currentPoints);			
		}
		else  if (parentID.equals("RectusAdominisMuscle:06")) 
		{	
			// Generate the GallBladder
			double[] startPos = {-0.5,-24.5, -1.5};
				
			// Create a equilateral octogon
	    	double x =  startPos[0];
	    	double y =  startPos[1];
	    	double z =  startPos[2];

			double[][] currentPoints = { 
	   				 {x, y, z},
	     				 {x, y-circumference,     z-radius},
	     				 {x, y-(circumference*2), z-radius},
	     				 {x, y-(circumference*3), z},
	     				 {x, y-(circumference*3), z+(radius)},
	     				 {x, y-(circumference*2), z+(radius*2)},
	     				 {x, y-circumference,     z+(radius*2)},
	     				 {x, y, z+radius}
	      		};

			
	    	int success = bioMightBean.generateRectusAdominisMuscle("RectusAdominisMuscleTissue:00460", "RectusAdominisMuscleTissue", 
					"RectusAdominisMuscleTissue", componentID, parentID, currentPoints);			
		}
		else  if (parentID.equals("RectusAdominisMuscle:07")) 
		{	
			// Generate the GallBladder
			double[] startPos = {0.5,-27.5, -1.5};
				
			// Create a equilateral octogon
	    	double x =  startPos[0];
	    	double y =  startPos[1];
	    	double z =  startPos[2];

			double[][] currentPoints = { 
	   				 {x, y, z},
	     				 {x, y-circumference,     z-radius},
	     				 {x, y-(circumference*2), z-radius},
	     				 {x, y-(circumference*3), z},
	     				 {x, y-(circumference*3), z+(radius)},
	     				 {x, y-(circumference*2), z+(radius*2)},
	     				 {x, y-circumference,     z+(radius*2)},
	     				 {x, y, z+radius}
	      		};

			
	    	int success = bioMightBean.generateRectusAdominisMuscle("RectusAdominisMuscleTissue:00580", "RectusAdominisMuscleTissue", 
					"RectusAdominisMuscleTissue", componentID, parentID, currentPoints);			
		}
		else  if (parentID.equals("RectusAdominisMuscle:08")) 
		{	
			// Generate the GallBladder
			double[] startPos = {-0.5,-27.5, -1.5};
				
			// Create a equilateral octogon
	    	double x =  startPos[0];
	    	double y =  startPos[1];
	    	double z =  startPos[2];
	    	
	    	
			double[][] currentPoints = { 
	   				 {x, y, z},
	     				 {x, y-circumference,     z-radius},
	     				 {x, y-(circumference*2), z-radius},
	     				 {x, y-(circumference*3), z},
	     				 {x, y-(circumference*3), z+(radius)},
	     				 {x, y-(circumference*2), z+(radius*2)},
	     				 {x, y-circumference,     z+(radius*2)},
	     				 {x, y, z+radius}
	      		};

			
	    	int success = bioMightBean.generateRectusAdominisMuscle("RectusAdominisMuscleTissue:00670", "RectusAdominisMuscleTissue", 
					"RectusAdominisMuscleTissue", componentID, parentID, currentPoints);			
		}
		 
		 
		System.out.println("Created RectusAdominisMuscleTissue Info using EJB");   	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - RectusAdominisMuscleTissue");
			throw new ServerException("Remote Exception getComponents():", e); 	
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
	 * This method will return the X3D for the RectusAdominisMuscle.  It runs through each of its 
	 * components and collects up their representations and then assembles them into one unified X3D model.
	 * 
	 ********************************************************************************************************************/
	
	
	public String getX3D(boolean snipet) {
		
		// Assemble the RectusAdominisMuscle
		String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
		"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n " +
		"<X3D profile='Immersive' >\n" +
		"<head>\n" +
		 "<meta name='BioMightImage' content='RectusAdominisMuscle.jpg'/>\n" +
		 "<meta name='ExportTime' content='7:45:30'/>\n" +
		 "<meta name='ExportDate' content='08/15/2008'/>\n" +
		 "<meta name='BioMight Version' content='1.0'/>\n" + 
		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='RectusAdominisMuscle'\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		

		String body = "";  

		viewPerspective = Constants.VIEW_FLOATING;
		if (viewPerspective == Constants.VIEW_FLOATING) {
			body = muscleTissue.getX3D(true); 
		}
		else if (viewPerspective == Constants.VIEW_DETACHED) 
		{ 
			
			// Run through the collection of RectusAdominisMuscle  and build them into the model
			// In the default case, we get one instance of the RectusAdominisMuscle  for each Stomach
			ArrayList transforms = bioMightTransforms.getTransforms();
			for (int i=0; i<transforms.size(); i++)
			{
				// Get the information for the RectusAdominisMuscle we are creating
				BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
				System.out.println("Getting RectusAdominisMuscle X3D: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
		
				//System.out.println("Getting X3D for RectusAdominisMuscle X: " + bioMightSphere.getTranslation().getXPos());
				//System.out.println("Getting X3D for RectusAdominisMuscle Y: " + bioMightSphere.getTranslation().getYPos());
				//System.out.println("Getting X3D for RectusAdominisMuscle Z: " + bioMightSphere.getTranslation().getZPos());
				// Change the height and width based on the displacement.
				body += "<Transform DEF='RectusAdominisMuscle '\n" +
		 				"translation='" + bioMightTransform.getTranslation().getXPos() + " " 
			 					+ bioMightTransform.getTranslation().getYPos() + " "
			 					+ bioMightTransform.getTranslation().getZPos() + "'\n" +
			 					"scale='" 	+ bioMightTransform.getScale().getXPos() + " "
			 				+ bioMightTransform.getScale().getYPos() + " "
			 				+ bioMightTransform.getScale().getZPos() + "'>\n" +
			 				"<Shape DEF='RectusAdominisMuscle Shape'\n" +
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
						 	"<IndexedFaceSet DEF='RectusAdominisMuscle IFS' \n" +
						    	   "containerField='geometry' \n" +
						    	   "creaseAngle='" +  bioMightTransform.getCreaseAngle() + "'\n" +
						    	   "coordIndex='" + bioMightTransform.getCoordindexStr() + "'>" +
						    	   "<Coordinate DEF='RectusAdominisMuscle _Coord' \n" +
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
			 "<ROUTE fromNode='StomachBeatAnim' fromField='value_changed' toNode='RectusAdominisMuscle' toField='set_scale'/>\n";
			}
		}
		else
		{
			body = "";//						
		}
		
		//System.out.println("RectusAdominisMuscle X3D: " + body);		
		String footer = "</Scene>" + "</X3D>\n";
		
		if (snipet)
			return body;			
		else	
			return header + body + footer;
	}
	

}
