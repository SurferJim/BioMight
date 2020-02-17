/*
 * Created on May 13, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.system.muscular.back;
import java.util.ArrayList;

import javax.naming.InitialContext;



import biomight.Constants;
import biomight.ejb.BioMightBeanLocal;
import biomight.ejb.BioMightMuscularBeanLocal;
import biomight.exceptions.ServerException;
import biomight.system.tissue.muscle.Muscle;
import biomight.system.tissue.muscle.MuscleTissue;
import biomight.util.BioGraphics;
import biomight.view.BioMightMethodView;
import biomight.view.BioMightPosition;
import biomight.view.BioMightPropertyView;
import biomight.view.BioMightScale;
import biomight.view.BioMightTransform;


/*******************************************************************
 * InfraSpinatus Muscle
 * 
 * @author SurferJim
 *
 * Representation of the LongissimusCervicisMuscle
 * 
 ***********************************************************************************/

public class LongissimusCervicisMuscle extends Muscle {
	private BioMightPosition bioMightPosition;
	protected MuscleTissue muscleTissue;
	
	
	/******************************************************************************
	 * CONSTRUCTUORS
	 *****************************************************************************/
	
	public LongissimusCervicisMuscle()
	{
		int localVP =  Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG2X;
		create(localVP, localLOD, Constants.LongissimusCervicisMuscle, null, null);
	}
	
	public LongissimusCervicisMuscle(String parentID)
	{				
		int localVP =  Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG2X;
		create(localVP, localLOD, parentID, null, null);	
	}
		
	public LongissimusCervicisMuscle(String parentID, BioMightPosition bioMightPosition)
	{
		int localVP =  Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG2X;
		create(localVP, localLOD, parentID, null, null);
		//this.bioMightPosition = bioMightPosition;
	}
	

	public LongissimusCervicisMuscle(int localVP, int localLOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
	{				
		create(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);	
	}
	
	/*****************************************************************************
	 * CREATE
	 * 
	 * Create an instance of the LongissimusCervicisMuscle
	 * 
	 * @param parentID
	 * @param bioMightMethods
	 ****************************************************************************/
	
	public void create(int localVP, int localLOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
	{
			this.setImage("images/LongissimusCervicisMuscle.jpg");
			this.setImageHeight(300);
			this.setImageWidth(300);
			this.parentID = parentID;
			this.componentID = parentID;
			this.lod = localLOD;
			this.viewPerspective = localVP;
			
			BioMightScale bioScale = new BioMightScale("0.00, 0.00, 0.00");
			BioMightPosition  bioPos = new BioMightPosition("0.00, 0.00, 0.00");
			String bioTemplate="LongissimusCervicisMuscle.x3d";
			
			// There are 4 modes in which this object will be created
			// 1 - Being instantiated as part of a collection.
			// 2 - Being instantiated when drilling down from a collection, will need to get component by ID
			// 3 - Need level of detail to determine if aggregated, or get current level
			// 4 - 
			if (localVP == Constants.VIEW_INTERNAL)			
			{
				// Do nothing.  We are instantiating as part of a collection  
				// There is no drill down, so we use the transforms that the
				// parent has already collected
				System.out.println("LongissimusCervicisMuscle Create() - ViewInternal Parent: " + parentID);				

				// We already have the data for the current instance of LongissimusCervicisMuscle,
				// Go get the details for the current LongissimusCervicisMuscle is LOD is set
				if (localLOD == Constants.MAG2X)
				{
					// Go get the finer details of the LongissimusCervicisMuscle				
					System.out.println("Getting the LongissimusCervicisMuscle Details - MAG2X: " + parentID);
				
					// Generate the InfraSpinatus Muscle if needed 
					boolean bGenerate = false;
					if (bGenerate) {
						generate(parentID, componentID);
					}
					
					// Get the information for the eye we are creating
					//BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
					//this.componentID = bioMightTransform.getId();
					System.out.println("Creating LongissimusCervicisMuscleTissue - VI: " + parentID);				
					muscleTissue = new MuscleTissue("LongissimusCervicisMuscleTissue", parentID, bioMightMethods);
					initProperty("LongissimusCervicisMuscleTissue", Constants.MuscleTissue, Constants.MuscleTissueRef, muscleTissue.getComponentID());
				}
			
			}	
			else if (localVP == Constants.VIEW_HAWKEYE)
			{
				// This is when one is accessing a LongissimusCervicisMuscle directly
				// Get the information from the database via the Enterprise Bean		
				try {
					// Get the information from the database via the Enterprise Bean		
					System.out.println("Getting HawkEye LongissimusCervicisMuscleInfo for ParentID: " + parentID);
					InitialContext ctx = new InitialContext();
					BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
					bioMightTransforms = bioMightBean.getComponent(componentID);
					System.out.println("Have LongissimusCervicisMuscle Info from EJB");   	
				}catch (Exception e) { 
					System.out.println("Exception Getting Components - LongissimusCervicisMuscle");
					throw new ServerException("Remote Exception getComponents():", e); 	
				}
					
				// Run through the collection of LongissimusCervicisMuscles and build them into the model
				// In the default case, we get one instance of the LongissimusCervicisMuscle for each eye
				ArrayList transforms = bioMightTransforms.getTransforms();
				System.out.println("LongissimusCervicisMuscle NumTransforms: " + transforms.size());
				for (int i=0; i<transforms.size(); i++)
				{
					// Get the information for the LongissimusCervicisMuscle
					BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
					System.out.println("Creating LongissimusCervicisMuscle: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
					this.componentID = bioMightTransform.getId();


					if (localLOD == Constants.MAG1X)
					{
						// initialize the Properties
						initProperties();
					}
					if (localLOD == Constants.MAG2X)
					{
						// Go get the finer details of the LongissimusCervicisMuscle				
						System.out.println("Creating LongissimusCervicisMuscle : " + parentID + " lod: " + localLOD);
						localVP = Constants.VIEW_HAWKEYE; 
						localLOD = Constants.MAG1X;

						// Generate the InfraSpinatus Muscle if needed 
						boolean bGenerate = false;
						if (bGenerate) {
							generate(parentID, componentID);
						}
						
						// Get the information for the eye we are creating
						bioMightTransform = (BioMightTransform) transforms.get(i);
						this.componentID = bioMightTransform.getId();
						System.out.println("Creating LongissimusCervicisMuscleTissue: " + bioMightTransform.getId());				
						muscleTissue = new MuscleTissue("LongissimusCervicisMuscleTissue", bioMightTransform.getId(), bioMightMethods);
						initProperty("LongissimusCervicisMuscleTissue", Constants.MuscleTissue, Constants.MuscleTissueRef, muscleTissue.getComponentID());
					}
					
				}
			}		
			else
			{
				
			}
				
			initMethods();
			
			System.out.println("Create LongissimusCervicisMuscle Completed");
		}
	
	
	/**********************************************************************
	 * GENERATE InfraSpinatus Muscle
	 * 
	 * @param parentID
	 * @param componentID
	 ********************************************************************/
	
	public void generate(String parentID, String componentID)
	{
		// Generate the LongissimusCervicisMuscles 		
		BioMightMuscularBeanLocal bioMightBean;
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Generating the LongissimusCervicisMuscle ParentID: " + parentID   +  "   "  + componentID);
			InitialContext ctx = new InitialContext();
			bioMightBean = (BioMightMuscularBeanLocal) ctx.lookup("java:global/BioMightWeb/BioMightMuscularBean!biomight.ejb.BioMightMuscularBeanLocal");  
																		
			double circumference = 1.25;
		
		// Left InfraSpinatus
		if (parentID.equals("LongissimusCervicisMuscle:01")) 
		{	
			// Generate the LongissimusCervicisMuscle
				
			circumference = 1.25;
			double[] startPos = {7.0, -10.0, -6.5};
			double degrees = 120;
			double[][] currentPoints = BioGraphics.createRingLeftRightByNS(startPos, Constants.OCTOGON_Z4, Constants.NORTH, degrees, circumference);
			
			//int success = bioMightBean.generateLongissimusCervicisMuscle("LongissimusCervicisMuscleTissue:00001", "LongissimusCervicisMuscleTissue", 
			//	"LongissimusCervicisMuscleTissue", componentID, parentID, currentPoints);			
		}
		// Right LongissimusCervicisMuscle 
		else  if (parentID.equals("LongissimusCervicisMuscle:02")) 
		{	
			// Generate the GallBladder
			circumference = 1.25;
			double[] startPos = {-7.0, -10.0, -6.5};
			double degrees = -120;
			double[][] currentPoints = BioGraphics.createRingLeftRightByNS(startPos, Constants.OCTOGON_Z4, Constants.NORTH, degrees, circumference);

			
	    	//int success = bioMightBean.generateLongissimusCervicisMuscle("LongissimusCervicisMuscleTissue:00096", "LongissimusCervicisMuscleTissue", 
			//		"LongissimusCervicisMuscleTissue", componentID, parentID, currentPoints);			
		}
		
			
			System.out.println("Created LongissimusCervicisMuscleTissue Info using EJB");   	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - LongissimusCervicisMuscleTissue");
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
	 * This method will return the X3D for the LongissimusCervicisMuscle.  It runs through each of its components and collects up their
	 * representations and then assembles them into one unified X3D model.
	 * 
	 ********************************************************************************************************************/
	public String getX3D(boolean snipet) {
		
		// Assembe the LongissimusCervicisMuscle
		String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
		"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n " +
		"<X3D profile='Immersive' >\n" +
		"<head>\n" +
		 "<meta name='BioMightImage' content='LongissimusCervicisMuscle.jpg'/>\n" +
		 "<meta name='ExportTime' content='7:45:30'/>\n" +
		 "<meta name='ExportDate' content='08/15/2008'/>\n" +
		 "<meta name='BioMight Version' content='1.0'/>\n" + 
		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='LongissimusCervicisMuscle'\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		

		String body = "";
		String annotate = "";
		
		
		// Only when the database retrieval has been locally, do we do this??
		if (viewPerspective == Constants.VIEW_INTERNAL) 
		{			
			System.out.println("LongissimusCervicisMuscleX3D: View Internal");

			// We do nada as the LongissimusCervicisMuscle Data is retrieved in the collection object
			// and the X3D is generated there
			if (lod == Constants.MAG2X)		
			{
				//We are going to get the X3D from the aggregation objects
				System.out.println("Creating LongissimusCervicisMuscle: MAG2X - Assembling");
				body += muscleTissue.getX3D(true);
				//System.out.println("Assembled: " + body);
			}
		}
		else if (viewPerspective == Constants.VIEW_HAWKEYE) 
		{
			// We went to the database to get data.  There will be 1 Transform record
		
			ArrayList transforms = bioMightTransforms.getTransforms();
			for (int i=0; i<transforms.size(); i++)
			{
				// Get the information for the capsomer we are creating
				BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
				System.out.println("Creating LongissimusCervicisMuscle: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
				System.out.println("Creating LongissimusCervicisMuscle at Position: " + 
						bioMightTransform.getTranslation().getXPos() + "  " +
						bioMightTransform.getTranslation().getYPos() + "  " +
						bioMightTransform.getTranslation().getZPos());
				
				// Grab the data
				if (lod == Constants.MAG1X)		
				{
					//System.out.println("Getting X3D for LongissimusCervicisMuscleX: " + bioMightTransform.getTranslation().getXPos());
					//System.out.println("Getting X3D for LongissimusCervicisMuscleY: " + bioMightTransform.getTranslation().getYPos());
					//System.out.println("Getting X3D for LongissimusCervicisMuscleZ: " + bioMightTransform.getTranslation().getZPos());
					// Change the height and width based on the displacement.
					body += "<Transform DEF='LongissimusCervicisMuscle'\n";
					
					
					// Set the position if we are working with the Tissue collection
					if (parentID.equals("1.10000:0"))
					{
						body += "translation='" 
							+ bioMightPosition.getXPos() + " " 
				 			+ bioMightPosition.getYPos() + " "
				 			+ bioMightPosition.getZPos() + "'\n";
					}
					else
					{
				 		body += "translation='" 
				 			+ bioMightTransform.getTranslation().getXPos() + " " 
	 						+ bioMightTransform.getTranslation().getYPos() + " "
	 						+ bioMightTransform.getTranslation().getZPos() + "'\n";					
					}
					 					
					 					
					body +=  "scale='" 	+ bioMightTransform.getScale().getXPos() + " "
					 				+ bioMightTransform.getScale().getYPos() + " "
					 				+ bioMightTransform.getScale().getZPos() + "'>\n" +
					 	"<Shape DEF='LongissimusCervicisMuscle'\n" +
					    " containerField='children'>\n" +
					    " <Appearance\n" +
					    "  containerField='appearance'>\n";
					    
					body+= " <ImageTexture containerField='texture' " +
					    " url='../images/LongissimusCervicisMuscle.jpg'/>";
					
					body+= " <Material DEF='Rust'\n" +
					    "containerField='material'\n" +
					    "ambientIntensity='" 	+ bioMightTransform.getMaterial().getAmbientIntensity() + "'\n" +
					    "shininess='" 			+ bioMightTransform.getMaterial().getShininess() + "'\n" +
					    "transparency='" 		+ bioMightTransform.getMaterial().getTransparency() + "'\n" +
					    "diffuseColor='" + 
					 	    bioMightTransform.getMaterial().getDiffuseColor().getRed() + " " + 
					 	    bioMightTransform.getMaterial().getDiffuseColor().getGreen() + " " +
					 	    bioMightTransform.getMaterial().getDiffuseColor().getBlue() + "'/>\n" +
					 	"</Appearance>\n" +
					 	"<Sphere DEF='LongissimusCervicisMuscleGeoSphere'\n" +
					 	"containerField='geometry'\n" +
					 	"radius='" + bioMightTransform.getRadius() +"'/>\n" +
					 	"</Shape>\n" +
					 	
						"\n<TouchSensor DEF='"+bioMightTransform.getId()+"' \n" +
		                   " description='LongissimusCervicisMuscle'\n" +
			               " containerField='children'/> \n" +
		
					 "</Transform>\n";
					
						//	Add the text to the Tissue sample
						if (parentID.equals("1.10000:0"))
						{
							annotate = 
								"<Transform DEF='LongissimusCervicisMuscleText' \n" +
								"translation='" + (bioMightPosition.getXPos() + 1.25) + " "  
								+ (bioMightPosition.getYPos()+0.25) + " "
								+ bioMightPosition.getZPos() + "'>\n" +
								"<Shape DEF='Tisssuesn'>\n" +
								"<Appearance\n" +
								"containerField='appearance'>\n" +
								"<Material containerField='material' USE='Red'/>\n" +
								"</Appearance>\n" +
								"<Text DEF='GeoText2'\n" +
								"containerField='geometry'\n" +
								"string='\"LongissimusCervicisMuscles\"'\n" +
								"maxExtent='0.000'>\n" +
								"<FontStyle\n" +
								"containerField='fontStyle'\n" +
								"family='SERIF'\n" +
								"style='PLAIN'\n" +
								"justify='\"BEGIN\" \"BEGIN\"'\n" +
								"size='0.500'\n" +
								"spacing='0.50'/>\n" +
								"</Text>\n" +
								"</Shape>\n" +
							"</Transform>\n";
						}
					}
					else if (lod == Constants.MAG2X)		
					{
						body += muscleTissue.getX3D(true);
						
					}
				}
		}
		else 
		{			
			// Issue
		}	
			
		
		//System.out.println("LongissimusCervicisMuscle X3D: " + body);		
		String footer = "</Scene>" + "</X3D>\n";
		
		if (snipet)
			return body;			
		else	
			return header + body + annotate + footer;				
	}
	
	
}
