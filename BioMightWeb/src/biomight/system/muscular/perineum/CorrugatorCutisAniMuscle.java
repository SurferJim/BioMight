/*
 * Created on May 13, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.system.muscular.perineum;
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

/**
 * @author SurferJim
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
/*************************************************************
 * CorrugatorCutisAni Muscle
 * @author SurferJim
 *
 * Representation of the CorrugatorCutisAniMuscle
 ************************************************************/

public class CorrugatorCutisAniMuscle extends Muscle {
	protected MuscleTissue muscleTissue;
	
	
	/******************************************************************************
	 * CONSTRUCTUORS
	 *****************************************************************************/
	public CorrugatorCutisAniMuscle()
	{
		create(Constants.CorrugatorCutisAniMuscle, null);
	}

	public CorrugatorCutisAniMuscle(String parentID)
	{
		create(parentID, null);
	}
	
	public CorrugatorCutisAniMuscle(String parentID, ArrayList<BioMightMethodView> bioMightMethods)
	{
		create(parentID, bioMightMethods);
	}

	
	/*****************************************************************************
	 * CREATE
	 * 
	 * Create an instance of the CorrugatorCutisAniMuscle
	 * 
	 * @param parentID
	 * @param bioMightMethods
	 ****************************************************************************/
	
	public void create(String parentID, ArrayList<BioMightMethodView> bioMightMethods)
	{
		this.setImage("images/CorrugatorCutisAniMuscle.jpg");
		this.setImageHeight(300);
		this.setImageWidth(300);
	
		
		viewPerspective = Constants.VIEW_FLOATING;
		if (viewPerspective == Constants.VIEW_FLOATING) {	
			
			// This is a collection.   The CorrugatorCutisAniMuscles class gets the data
			// and passes thier key in as a parameter here. The lookup to the data
			// has already been done in the collection class
			componentID=parentID;
			
			// Generate the CorrugatorCutisAni Muscle if needed 
			boolean bGenerate = false;
			if (bGenerate) {
				generate(parentID, componentID);
			}
			
			// Create the tissue for the muscle
			System.out.println("Creating CorrugatorCutisAniMuscleTissue: " +  parentID);				
			muscleTissue = new MuscleTissue("CorrugatorCutisAniMuscleTissue", parentID, bioMightMethods);
			initProperty("CorrugatorCutisAniMuscleTissue", Constants.MuscleTissue, Constants.MuscleTissueRef, muscleTissue.getComponentID());
			System.out.println("CorrugatorCutisAniMuscle MuscleTissue is created : " + parentID);		
	
		} 
		else if (viewPerspective == Constants.VIEW_INTERNAL) 
		{	
			// We are looking at object not in the context of the collection
			// so we need to go the the database via the Enterprise bean
			// to get the data
			
			// Get the information from the database via the Enterprise Bean		
			try {
				// Get the information from the database via the Enterprise Bean		
				System.out.println("Getting CorrugatorCutisAniMuscleInfo for ParentID: " + parentID);
				InitialContext ctx = new InitialContext();
				BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
				bioMightTransforms = bioMightBean.getComponents(Constants.CorrugatorCutisAniMuscleRef, parentID);
				System.out.println("Have CorrugatorCutisAniMuscle Info from EJB");   	
			}catch (Exception e) { 
				System.out.println("Exception Getting Components - CorrugatorCutisAniMuscle");
				throw new ServerException("Remote Exception getComponents():", e); 	
			}
			
			// Run through the collection of CorrugatorCutisAniMuscles and build them into the model
			// In the default case, we get one instance of the CorrugatorCutisAniMuscle
			ArrayList transforms = bioMightTransforms.getTransforms();
			System.out.println("CorrugatorCutisAniMuscle NumTransforms: " + transforms.size());
			for (int i=0; i<transforms.size(); i++)
			{
				// Get the information for the eye we are creating
				BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
				this.componentID = bioMightTransform.getId();
				System.out.println("Creating CorrugatorCutisAniMuscleTissue: " + bioMightTransform.getId());				
				muscleTissue = new MuscleTissue("CorrugatorCutisAniMuscleTissue", bioMightTransform.getId(), bioMightMethods);
				initProperty("CorrugatorCutisAniMuscleTissue", Constants.MuscleTissue, Constants.MuscleTissueRef, muscleTissue.getComponentID());
				
			}
		}
	
		
		//initProperties();
		initMethods();
		
		System.out.println("CreateCorrugatorCutisAniMuscle Completed");
		
		// First, get all the data from the database
		// Apply the methods to it
		// Save its state
		this.parentID = parentID;
		if (bioMightMethods != null){
			System.out.println("EXECUTING CorrugatorCutisAniMuscle METHODS: " + bioMightMethods.size());
			//executeMethods(bioMightMethods);
		}
	}
	
	
	
	/**********************************************************************
	 * GENERATE CorrugatorCutisAni Muscle
	 * 
	 * @param parentID
	 * @param componentID
	 ********************************************************************/
	
	public void generate(String parentID, String componentID)
	{
		// Generate the CorrugatorCutisAniMuscle Epithelium		
		BioMightMuscularBeanLocal bioMightBean;
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Generating the CorrugatorCutisAniMuscle ParentID: " + parentID);
			InitialContext ctx = new InitialContext();
			bioMightBean = (BioMightMuscularBeanLocal) ctx.lookup("java:global/BioMightWeb/BioMightMuscularBean!biomight.ejb.BioMightMuscularBeanLocal"); 
	
			double circumference = 0.125;
		
		// Left CorrugatorCutisAni
		 if (parentID.equals("CorrugatorCutisAniMuscle:01")) 
			{	
				// Generate the CorrugatorCutisAniMuscle
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

				
	    	int success = bioMightBean.generateCorrugatorCutisAniMuscle("CorrugatorCutisAniMuscleTissue:00001", "CorrugatorCutisAniMuscleTissue", 
					"CorrugatorCutisAniMuscleTissue", componentID, parentID, currentPoints);			
		}
		// Right CorrugatorCutisAni
		else  if (parentID.equals("CorrugatorCutisAniMuscle:02")) 
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

			
	    	int success = bioMightBean.generateCorrugatorCutisAniMuscle("CorrugatorCutisAniMuscleTissue:00096", "CorrugatorCutisAniMuscleTissue", 
					"CorrugatorCutisAniMuscleTissue", componentID, parentID, currentPoints);			
		}
		
			
			System.out.println("Created CorrugatorCutisAniMuscleTissue Info using EJB");   	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - CorrugatorCutisAniMuscleTissue");
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
	 * This method will return the X3D for the CorrugatorCutisAniMuscle.  It runs through each of its 
	 * components and collects up their representations and then assembles them into one unified X3D model.
	 * 
	 ********************************************************************************************************************/
	
	
	public String getX3D(boolean snipet) {
		
		// Assemble the Greater Curvature
		String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
		"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n " +
		"<X3D profile='Immersive' >\n" +
		"<head>\n" +
		 "<meta name='BioMightImage' content='CorrugatorCutisAniMuscle.jpg'/>\n" +
		 "<meta name='ExportTime' content='7:45:30'/>\n" +
		 "<meta name='ExportDate' content='08/15/2008'/>\n" +
		 "<meta name='BioMight Version' content='1.0'/>\n" + 
		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='CorrugatorCutisAniMuscle'\n" +
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
			// Run through the collection of CorrugatorCutisAniMuscle  and build them into the model
			// In the default case, we get one instance of the CorrugatorCutisAniMuscle  for each Stomach
			ArrayList transforms = bioMightTransforms.getTransforms();
			for (int i=0; i<transforms.size(); i++)
			{
				// Get the information for the CorrugatorCutisAniMuscle we are creating
				BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
				System.out.println("Getting CorrugatorCutisAniMuscle X3D: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
		
	
				//System.out.println("Getting X3D for CorrugatorCutisAniMuscle X: " + bioMightSphere.getTranslation().getXPos());
				//System.out.println("Getting X3D for CorrugatorCutisAniMuscle Y: " + bioMightSphere.getTranslation().getYPos());
				//System.out.println("Getting X3D for CorrugatorCutisAniMuscle Z: " + bioMightSphere.getTranslation().getZPos());
				// Change the height and width based on the displacement.
				body += "<Transform DEF='CorrugatorCutisAniMuscle '\n" +
		 			"translation='" + bioMightTransform.getTranslation().getXPos() + " " 
			 					+ bioMightTransform.getTranslation().getYPos() + " "
			 					+ bioMightTransform.getTranslation().getZPos() + "'\n" +
			 		"scale='" 	+ bioMightTransform.getScale().getXPos() + " "
			 				+ bioMightTransform.getScale().getYPos() + " "
			 				+ bioMightTransform.getScale().getZPos() + "'>\n" +
					"<Shape DEF='CorrugatorCutisAniMuscle Shape'\n" +
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
						 	"<IndexedFaceSet DEF='CorrugatorCutisAniMuscle IFS' \n" +
						    	   "containerField='geometry' \n" +
						    	   "creaseAngle='" +  bioMightTransform.getCreaseAngle() + "'\n" +
						    	   "coordIndex='" + bioMightTransform.getCoordindexStr() + "'>" +
						    	   "<Coordinate DEF='CorrugatorCutisAniMuscle _Coord' \n" +
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
			       "<ROUTE fromNode='StomachBeatAnim' fromField='value_changed' toNode='CorrugatorCutisAniMuscle' toField='set_scale'/>\n";	
				}
			}
		else
		{
			body = "";						
		}	
			
		
		//System.out.println("CorrugatorCutisAniMuscle X3D: " + body);		
		String footer = "</Scene>" + "</X3D>\n";
		
		if (snipet)
			return body;			
		else	
			return header + body + footer;
		}
	
	
}
