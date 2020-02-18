/*
* Created on Apr 10, 2006
*
* BioMight Component Class - Feb 2007
*
*/
package biomight.system.skeletal.arm;
import java.util.ArrayList;

import javax.naming.InitialContext;

import biomight.BioMightBase;
import biomight.Constants;
import biomight.cell.extracellularmatrixsecretion.Osteocytes;
import biomight.ejb.BioMightBeanLocal;
import biomight.ejb.BioMightSkeletalBeanLocal;
import biomight.exceptions.ServerException;
import biomight.util.BioGraphics;
import biomight.view.BioMightGenerate;
import biomight.view.BioMightMethodView;
import biomight.view.BioMightOrientation;
import biomight.view.BioMightPosition;
import biomight.view.BioMightPropertyView;
import biomight.view.BioMightTransform;
import biomightweb.util.BioWebX3DUtils;


/********************************************************************
* @author SurferJim
*
* BioMight Component Class - Feb 2007
*
*********************************************************************/

public class Radius extends BioMightBase {	
	private BioMightTransform gbioMightTransform; 
	private BioMightPosition bioMightPosition;
	private Osteocytes osteocytes;

	/******************************************************************************
	 * CONSTRUCTUORS
	 *****************************************************************************/
	
	public Radius()
	{
		int localVP =  Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG2X;
		create(localVP, localLOD, Constants.Radius, null, null);
	}
	
	public Radius(String parentID)
	{				
		int localVP =  Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG2X;
		create(localVP, localLOD, parentID, null, null);	
	}
		
	public Radius(String parentID, BioMightPosition bioMightPosition)
	{
		int localVP =  Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG2X;
		create(localVP, localLOD, parentID, null, null);
		//this.bioMightPosition = bioMightPosition;
	}

		
	// When we are drilling into the component from the View Page, we will set
	// the LOD to HAWK-EYE, which means fine detail
	// We are looking at the object from a collection.  It was created via
	// the Radius parent object and we do not have  to go to the database 
	// to get additional informaion
	public Radius(int localVP, int localLOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
	{				
		create(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);	
	}
	
	/*****************************************************************************
	 * CREATE
	 * 
	 * Create an instance of the Radius
	 * 
	 * @param parentID
	 * @param bioMightMethods
	 *****************************************************************************/
	
	public void create(int localVP, int localLOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
	{
			this.setImage("images/Radius.jpg");
			this.setImageHeight(300);
			this.setImageWidth(300);
			this.parentID = parentID;
			this.componentID = parentID;
			this.lod = localLOD;
			this.viewPerspective = localVP;

			localLOD = Constants.MAG2X;
			localVP = Constants.VIEW_INTERNAL;
					
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
				System.out.println("Radius Create() - ViewInternal Parent: " + parentID);				

				// We already have the data for the current instance of Radius,
				// Go get the details for the current Radius is LOD is set
				if (localLOD == Constants.MAG2X)
				{
					// Go get the finer details of the Radius				
					System.out.println("Getting the Radius Details - MAG2X: " + parentID);
				
					// Generate the InfraSpinatus Muscle if needed 
					boolean bGenerate = false;
					if (bGenerate) {
						generate(parentID, componentID);
					}
					
					// Get the information for the eye we are creating
					//BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
					//this.componentID = bioMightTransform.getId();
					System.out.println("Creating Radius Osteocytes - ViewInternal: " + parentID);				
					osteocytes = new Osteocytes("RadiusOsteocyte", parentID, bioMightMethods);
					initProperty("RadiusOsteocyte", Constants.Osteocyte, Constants.OsteocyteRef, osteocytes.getComponentID());
				}
			
			}	
			else if (localVP == Constants.VIEW_HAWKEYE)
			{
				// This is when one is accessing a Radius directly
				// Get the information from the database via the Enterprise Bean		
				try {
					// Get the information from the database via the Enterprise Bean		
					System.out.println("Getting HawkEye RadiusInfo for ParentID: " + parentID);
					InitialContext ctx = new InitialContext();
					BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
					bioMightTransforms = bioMightBean.getComponent(componentID);
					System.out.println("Have Radius Info from EJB");   	
				}catch (Exception e) { 
					System.out.println("Exception Getting Components - Radius");
					throw new ServerException("Remote Exception getComponents():", e); 	
				}
					
				// Run through the collection of Radiuss and build them into the model
				// In the default case, we get one instance of the Radius for each eye
				ArrayList transforms = bioMightTransforms.getTransforms();
				System.out.println("Radius NumTransforms: " + transforms.size());
				for (int i=0; i<transforms.size(); i++)
				{
					// Get the information for the Radius
					BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
					gbioMightTransform  = bioMightTransform;
					
					System.out.println("Creating Radius: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
					this.componentID = bioMightTransform.getId();


					if (localLOD == Constants.MAG1X)
					{
						// initialize the Properties
						System.out.println("Creating Radius : " + parentID + " lod: MAG1X");
						initProperties();
					}
					if (localLOD == Constants.MAG2X)
					{
						// Go get the finer details of the Radius				
						System.out.println("Creating Radius : " + parentID + " lod: MAG2X");
						localVP = Constants.VIEW_HAWKEYE; 
						localLOD = Constants.MAG1X;

						// Generate the Radius if needed 
						boolean bGenerate = false;
						if (bGenerate) {
							generate(parentID, componentID);
						}
						
						// Create the inner bone
						System.out.println("Creating RadiusOsteocytes: " + bioMightTransform.getId());				
						osteocytes = new Osteocytes("RadiusOsteocyte", parentID, bioMightMethods);
						initProperty("RadiusOsteocyte", Constants.Osteocyte, Constants.OsteocyteRef, osteocytes.getComponentID());
						System.out.println("RadiusOsteocytes Completed: " + bioMightTransform.getId());				
					}
					
				}
			}		
			else
			{
				
			}
				
			initMethods();
			
			System.out.println("CreateRadius Completed");
			
			// First, get all the data from the database
			// Apply the methods to it
			// Save its state
			this.parentID = parentID;
			if (bioMightMethods != null){
				System.out.println("EXECUTING Radius Methods: " + bioMightMethods.size());
				//executeMethods(bioMightMethods);
			}
		}
	
	
	/**********************************************************************
	 * GENERATE RADIUS
	 * 
	 * @param parentID
	 * @param componentID
	 ********************************************************************/
	
	public void generate(String parentID, String componentID)
	{
		// Generate the Humeri
		BioMightSkeletalBeanLocal bioMightBean;
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Generating the Radius ParentID: " + parentID   +  "   "  + componentID);
			InitialContext ctx = new InitialContext();
			bioMightBean = (BioMightSkeletalBeanLocal) ctx.lookup("java:global/BioMightWeb/BioMightSkeletalBean!biomight.ejb.BioMightSkeletalBeanLocal");
			
		// Left Radius
		if (parentID.equals("Radius:01")) 
		{	
			// Generate the Radius			
			double radius = 0.020;
			double[] startPos = {10.00, -20.50, -5.0};
			//double degrees = 120;
			//double[][] currentPoints = BioGraphics.createRingLeftRightByNS(startPos, Constants.OCTOGON_REGULAR, Constants.NORTH, degrees, circumference);
			double[][] currentPoints = BioGraphics.createCylinderInPlane(Constants.YPLANE, startPos, radius, 8);
	
			System.out.println("calling generateRadius ParentID: " + parentID   +  "   "  + componentID);
			BioMightGenerate bioMightGenerate = bioMightBean.generateRadius("RadiusOsteocyte:00001", "RadiusOsteocyte", 
				"RadiusOsteocyte", componentID, parentID, currentPoints);			
		}
		
		
		// Right Radius 
		else  if (parentID.equals("Radius:02")) 
		{	
			// Generate the GallBladder
			double radius = 0.020;
			double[] startPos = {-10.00, -20.50, -5.0};
			//double degrees = -120;
			//double[][] currentPoints = BioGraphics.createRingLeftRightByNS(startPos, Constants.OCTOGON_Z4, Constants.NORTH, degrees, circumference);
			double[][] currentPoints = BioGraphics.createCylinderInPlane(Constants.YPLANE, startPos, radius, 8);

			System.out.println("calling generateRadius ParentID: " + parentID   +  "   "  + componentID);
			BioMightGenerate bioGenerate = bioMightBean.generateRadius("RadiusOsteocyte:00192", "RadiusOsteocyte", 
					"RadiusOsteocyte", componentID, parentID, currentPoints);			
		}	
			
			System.out.println("Created RadiusOsteocyte Info using EJB");   	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - RadiusOsteocyte");
			throw new ServerException("Remote Exception generateRadius():", e); 	
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
	
	
	/********************************************************************************************************************
	 * GET X3D
	 * 
	 * This method will return the X3D for the Radius.  It runs through each of its components and collects up their
	 * representations and then assembles them into one unified X3D model.
	 * 
	 ********************************************************************************************************************/
	public String getX3D(boolean snipet) {
		
		// Assembe the Radius
		String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
		"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n " +
		"<X3D profile='Immersive' >\n" +
		"<head>\n" +
		 "<meta name='BioMightImage' content='Radius.jpg'/>\n" +
		 "<meta name='ExportTime' content='7:45:30'/>\n" +
		 "<meta name='ExportDate' content='08/15/2008'/>\n" +
		 "<meta name='BioMight Version' content='1.0'/>\n" + 
		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='Radius'\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		

		String body = "";
		String annotate = "";
		lod = Constants.MAG2X;
			
		// Only when the database retrieval has been locally, do we do this??
		viewPerspective = Constants.VIEW_INTERNAL;
		if (viewPerspective == Constants.VIEW_INTERNAL) 
		{			
			System.out.println("Radius X3D from ViewInternal");
			// We do nada as the Radius Data is retrieved in the collection object
			// and the X3D is generated there
			if (lod == Constants.MAG2X)		
			{
				//We are going to get the X3D from the aggregation objects
				System.out.println("Radius X3D from Osteocytes");
				body += body += osteocytes.getX3D(true);
			}
			
			// The viewpoint will be set by the collection object

		}
		else if (viewPerspective == Constants.VIEW_HAWKEYE) 
		{
			// We went to the database to get data.  There will be 1 Transform record
		
			ArrayList transforms = bioMightTransforms.getTransforms();
			for (int i=0; i<transforms.size(); i++)
			{
				// Get the information for the capsomer we are creating
				BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
				System.out.println("Getting X3D for Radius: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
				System.out.println("Getting X3D for at Position: " + 
						bioMightTransform.getTranslation().getXPos() + "  " +
						bioMightTransform.getTranslation().getYPos() + "  " +
						bioMightTransform.getTranslation().getZPos());
				
				if (lod == Constants.MAG1X)		
				{
					//System.out.println("Getting X3D for RadiusX: " + bioMightTransform.getTranslation().getXPos());
					//System.out.println("Getting X3D for RadiusY: " + bioMightTransform.getTranslation().getYPos());
					//System.out.println("Getting X3D for RadiusZ: " + bioMightTransform.getTranslation().getZPos());
					// Change the height and width based on the displacement.
					
					
					body += "<Transform DEF='" + bioMightTransform.getId() + "'\n";
					
					
					// Set the position if we are working with the Tissue collection
					if (parentID.equals("1.1000:0"))
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
					
				 	body+= "scale='" 	+ bioMightTransform.getScale().getXPos() + " "
				 				+ bioMightTransform.getScale().getYPos() + " "
				 				+ bioMightTransform.getScale().getZPos() + "'>\n" +
						"<Shape DEF='" + bioMightTransform.getId() + "'\n" +
							    " containerField='children'>\n" +
							    " <Appearance\n" +
							    "  containerField='appearance'>\n";
							    
					// We are looking at the base tissue collection
				    if (parentID.equals("Arm:01") || parentID.equals("Arm:02"))
				    {
					    body+= " <ImageTexture containerField='texture' " +
					    " url='../images/EpitheliumTissue.jpg'/>";
					}  
				    else
				    {
					    body+= " <ImageTexture containerField='texture' " +
					    " url='../images/BoneTissue.jpg'/>";
					}				    
				    
					body+= " <Material DEF='Rust'\n" +
					    "containerField='material'\n" +
					    "ambientIntensity='" + bioMightTransform.getMaterial().getAmbientIntensity() + "'\n" +
					    "shininess='" 		 + bioMightTransform.getMaterial().getShininess() + "'\n" +
					    "transparency='" 	 + bioMightTransform.getMaterial().getTransparency() + "'\n" +
					    "diffuseColor='" + 
					    bioMightTransform.getMaterial().getDiffuseColor().getRed() + " " + 
					    bioMightTransform.getMaterial().getDiffuseColor().getGreen() + " " +
					    bioMightTransform.getMaterial().getDiffuseColor().getBlue() + "'/>\n" +
					 	"</Appearance>\n" +			    
					 	"<IndexedFaceSet DEF='RadiusIFS' \n" +
					    	   "containerField='geometry' \n" +
					    	   "creaseAngle='" +  bioMightTransform.getCreaseAngle() + "'\n" +
					    	   "coordIndex='" + bioMightTransform.getCoordindexStr() + "'>" +
					    	   "<Coordinate DEF='RadiusTissue_Coord' \n" +
					    	    "containerField='coord' point='" +  bioMightTransform.getCoordpointStr() + "'/>" +
					    	  "</IndexedFaceSet>\n" +
					    	 "</Shape>\n" +
					    	 
					    	 
					    	 "<TouchSensor DEF='StartEndothelium' \n" +
			                   " description='" + bioMightTransform.getId() + "'\n" +
				               " containerField='children'/> \n" +
					    	 
					"</Transform>\n"; 
					//	Add the text to the Tissue sample
			
					
					body+= "<Viewpoint DEF='Viewpoint_Radius'\n" +
							 "description='Viewpoint1'\n" +
							 "jump='true'\n" +
							 "fieldOfView='0.785'\n" +
							 "position='0.0 -30.0 40.0'\n" +
							 "orientation='0 0 1 0'/>\n";
					
					}
					else if (lod == Constants.MAG2X)		
					{
						System.out.println("Radius X3D from Osteocytes");
						body += body += osteocytes.getX3D(true);
						
						
						body+= "<Viewpoint DEF='Viewpoint_Radius'\n" +
								 "description='Viewpoint1'\n" +
								 "jump='true'\n" +
								 "fieldOfView='0.785'\n" +
								 "position='0.0 -30.0 40.0'\n" +
								 "orientation='0 0 1 0'/>\n";
					}
				}
		}
		else 
		{			
			// Issue
		}	
			
		
		//System.out.println("Radius X3D: " + body);		
		String footer = "</Scene>" + "</X3D>\n";
		
		if (snipet)
			return body;			
		else	
			return header + body + annotate + footer;				
	}
		 					

	
}
