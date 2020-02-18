/*
 * Created on May 5, 2007
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.system.skeletal.spine;
import biomight.system.skeletal.leg.Fibula;
import biomight.system.tissue.connective.bone.Bone;
import java.rmi.RemoteException;
import java.util.ArrayList;
import javax.naming.InitialContext;

import biomight.BioMightBase;
import biomight.Constants;
import biomight.ejb.BioMightBeanLocal;
import biomight.ejb.BioMightSkeletalBeanLocal;
import biomight.exceptions.ServerException;
import biomight.util.BioGraphics;
import biomight.view.BioMightMethodView;
import biomight.view.BioMightPosition;
import biomight.view.BioMightPropertyView;
import biomight.view.BioMightScale;
import biomight.view.BioMightTransform;

/**
 * @author SurferJim
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class Vertebrae extends BioMightBase {
	CervicalVertebrae cervicalVertebrae;
	ThoracicVertebrae thoracicVertebrae;
	LumbarVertebrae lumbarVertebrae;
	SacralVertebrae sacralVertebrae;
	Sacrum sacrum;
	
	
	public Vertebrae()
	{
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, Constants.BasilarArteryRef, null, null);
	}

	public Vertebrae(String parentID)
	{
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, parentID, null, null);
	}

	public Vertebrae(int localVP, int localLOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
	{
		create(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);
	}

	/*****************************************************************
	 * CREATE
	 * 
	 * @param parentID
	 * @param bioMightMethods
	 ******************************************************************/
	public void create(int localVP, int localLOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
	{

		this.setImage("images/Vertebrae.jpg");
		this.setImageHeight(300);
		this.setImageWidth(300);
		this.lod = localLOD;
		this.viewPerspective = localVP;
		
		BioMightScale bioScale = new BioMightScale("0.00, 0.00, 0.00");
		BioMightPosition  bioPos = new BioMightPosition("0.00, 0.00, 0.00");
		String bioTemplate="Vertebrae.x3d";
	
		
		// Get the information from the database via the Enterprise Bean		
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Getting VertebraeInfo for ParentID: " + parentID);
			InitialContext ctx = new InitialContext();
			BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
			bioMightTransforms = bioMightBean.getComponents(Constants.VertebraeRef, parentID);
			System.out.println("Have Vertebrae Info from EJB");   	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - Vertebrae");
			throw new ServerException("Remote Exception getComponents():", e); 	
		}
			
		// Run through the collection of Vertebraes and build them into the model
		// In the default case, we get one instance of the Vertebrae for each eye
		ArrayList transforms = bioMightTransforms.getTransforms();
		System.out.println("Vertebrae NumTransforms: " + transforms.size());
		for (int i=0; i<transforms.size(); i++)
		{
			// Get the information for the eye we are creating
			BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
			System.out.println("Created Vertebrae: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
			this.componentID = bioMightTransform.getId();
			
			
			// Generate 
			boolean bGenerate = false;
			if (bGenerate) {
				generate(parentID, componentID);
			}
			
			System.out.println("Creating the CervicalVertebrae for parent: " + parentID);
			cervicalVertebrae = new CervicalVertebrae(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);
			initProperty("CervicalVertebrae", Constants.CervicalVertebrae, Constants.CervicalVertebraeRef, cervicalVertebrae.getComponentID());
			System.out.println("Created the CervicalVertebrae");

			System.out.println("Creating the ThoracicVertebrae for parent: " + parentID);
			thoracicVertebrae = new ThoracicVertebrae(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);
			initProperty("ThoracicVertebrae", Constants.ThoracicVertebrae, Constants.ThoracicVertebrae, thoracicVertebrae.getComponentID());
			System.out.println("Created the CervicalVertebrae");
			
			System.out.println("Creating the LumbarVertebrae for parent: " + parentID);
			lumbarVertebrae = new LumbarVertebrae(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);
			initProperty("LumbarVertebrae", Constants.LumbarVertebrae, Constants.LumbarVertebrae, lumbarVertebrae.getComponentID());
			System.out.println("Created the LumbarVertebrae");

			System.out.println("Creating the SacralVertebrae for parent: " + parentID);
			sacralVertebrae = new SacralVertebrae(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);
			initProperty("SacralVertebrae", Constants.SacralVertebrae, Constants.SacralVertebrae, sacralVertebrae.getComponentID());
			System.out.println("Created the SacralVertebrae");
			
			
			/*int viewPerspective = Constants.VIEW_DETACHED;
			if (viewPerspective == Constants.VIEW_DETACHED)
			{				
				// Create the components of the curvature

			}*/
		}
		initProperties();
		initMethods();
		
		System.out.println("CreateVertebrae Completed");
		
		// First, get all the data from the database
		// Apply the methods to it
		// Save its state
		this.parentID = parentID;
		if (bioMightMethods != null){
			System.out.println("EXECUTING Vertebrae METHODS: " + bioMightMethods.size());
			//executeMethods(bioMightMethods);
		}
	}
		


		/*******************************************************************
		 * GENERATE 
		 * 
		 * @param parentID
		 * @param componentID
		 ****************************************************************/
		
		public void generate(String parentID, String componentID)
		{
			// Generate the VertebraeOsteocytes		
			BioMightSkeletalBeanLocal bioMightBean;
			try {
				// Get the information from the database via the Enterprise Bean		
				System.out.println("Generating the VertebraeOsteocytes: " + componentID + "    " + parentID);
				InitialContext ctx = new InitialContext();
				bioMightBean = (BioMightSkeletalBeanLocal) ctx.lookup(Constants.SkeletalBeanRef);
		
				
				double radius = 0.5;
			
				if (parentID.equals("SkeletalSystem:0")) 
				{	
					// Generate the VertebraeOsteocytes of the stomach
					// Create 5 sections
					double[] startPosChest = {1.15, -10.90, -3.85};
					double[][] currentPoints = BioGraphics.createCylinderInPlane(Constants.YPLANE, startPosChest, radius, 8);
								
					System.out.println("Calling Generate VertebraeOsteocytes: " + componentID + "    " + parentID);	
					//int success = bioMightBean.generateVertebrae("VertebraeOsteocytes:00001", "VertebraeOsteocytes", 
					//	"VertebraeOsteocytes", componentID, parentID, currentPoints);
					
					//double[] startPosAbdo = {0.5, -14.0, -6.0};
					//currentPoints = BioGraphics.createCylinderInPlane(Constants.XPLANE, startPosAbdo, radius, 8);
				
					//System.out.println("Calling Generate AortaArteryOsteocytes: " + componentID + "    " + parentID);
					//success = bioMightBean.generateAortaArtery("AortaArteryOsteocytes:00001", "AortaArteryOsteocytes", 
					//	"AortaArteryOsteocytes", componentID, parentID, currentPoints);			
				}
				else if (parentID.equals("Chest:01")) 
				{	
					// Generate the VertebraeOsteocytes of the stomach
					// Create 5 sections
					double[] startPos = {1.75,-12.0, -6.0};
					double[][] currentPoints = BioGraphics.createCylinderInPlane(Constants.YPLANE, startPos, radius, 8);
					
					
		
					System.out.println("Calling Generate VertebraeOsteocytes: " + componentID + "    " + parentID);
					
					//int success = bioMightBean.generateVertebrae("VertebraeOsteocytes:00001", "VertebraeOsteocytes", 
					//	"VertebraeOsteocytes", componentID, parentID, currentPoints);			
						
				}			
				else if (parentID.equals("Abdomen:01")) 
				{	
					// Generate the VertebraeOsteocytes of the stomach
					// Create 5 sections
					double[] startPos = {0.5,-16.0, -6.0};	
					double[][] currentPoints = BioGraphics.createCylinderInPlane(Constants.YPLANE, startPos, radius, 8);
					
					
					System.out.println("Calling Generate VertebraeOsteocytes: " + componentID + "    " + parentID);
					
					//int success = bioMightBean.generateVertebrae("VertebraeOsteocytes:00080", "VertebraeOsteocytes", 
					//	"VertebraeOsteocytes", componentID, parentID, currentPoints);			
						
				}
				else if (parentID.equals("")) 
				{	
					System.out.println("Calling Generate VertebraeOsteocytes NoParent");
								
				}
				
				System.out.println("Created VertebraeOsteocytes Info using EJB");   	
			}catch (Exception e) { 
				System.out.println("Exception Getting Components - VertebraeOsteocytes");
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
		 * This method will return the X3D for the Stomach Greater Curvature.  It runs through each of its 
		 * components and collects up their representations and then assembles them into one unified X3D model.
		 * 
		 ********************************************************************************************************************/
		
		
		public String getX3D(boolean snipet) {
			
			// Assemble the Greater Curvature
			String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
			"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n " +
			"<X3D profile='Immersive' >\n" +
			"<head>\n" +
			 "<meta name='BioMightImage' content='Vertebrae.jpg'/>\n" +
			 "<meta name='ExportTime' content='7:45:30'/>\n" +
			 "<meta name='ExportDate' content='08/15/2008'/>\n" +
			 "<meta name='BioMight Version' content='1.0'/>\n" + 
			"</head>\n" +
			"<Scene>\n" +
			"<WorldInfo\n" +
			"title='Vertebrae'\n" +
			"info='\"BioMight Generated X3D\"'/>\n";		

			String body = cervicalVertebrae.getX3D(true);  
			//System.out.println("Vertebrae X3D: " + body);		
			
			String footer = "</Scene>" + "</X3D>\n";
			
			if (snipet)
				return body;			
			else	
				return header + body + footer;
		}
		
		
		
		public String getX3DExternal(boolean snipet) {
			
			// Assemble the Femoral Vein 
			String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
			"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n " +
			"<X3D profile='Immersive' >\n" +
			"<head>\n" +
			 "<meta name='BioMightImage' content='Vertebrae .jpg'/>\n" +
			 "<meta name='ExportTime' content='7:45:30'/>\n" +
			 "<meta name='ExportDate' content='08/15/2008'/>\n" +
			 "<meta name='BioMight Version' content='1.0'/>\n" + 
			"</head>\n" +
			"<Scene>\n" +
			"<WorldInfo\n" +
			"title='Vertebrae '\n" +
			"info='\"BioMight Generated X3D\"'/>\n";		


			String body = "";
			
			// Run through the collection of Vertebrae  and build them into the model
			// In the default case, we get one instance of the Vertebrae  for each Stomach
			ArrayList transforms = bioMightTransforms.getTransforms();
			for (int i=0; i<transforms.size(); i++)
			{
				// Get the information for the Vertebrae we are creating
				BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
				System.out.println("Getting Vertebrae X3D: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
			
				int view = Constants.VIEW_FLOATING;
				if (view == Constants.VIEW_FLOATING)
				{
					//System.out.println("Getting X3D for Vertebrae X: " + bioMightSphere.getTranslation().getXPos());
					//System.out.println("Getting X3D for Vertebrae Y: " + bioMightSphere.getTranslation().getYPos());
					//System.out.println("Getting X3D for Vertebrae Z: " + bioMightSphere.getTranslation().getZPos());
					// Change the height and width based on the displacement.
					body += "<Transform DEF='Vertebrae '\n" +
			 			"translation='" + bioMightTransform.getTranslation().getXPos() + " " 
				 					+ bioMightTransform.getTranslation().getYPos() + " "
				 					+ bioMightTransform.getTranslation().getZPos() + "'\n" +
				 		"scale='" 	+ bioMightTransform.getScale().getXPos() + " "
				 				+ bioMightTransform.getScale().getYPos() + " "
				 				+ bioMightTransform.getScale().getZPos() + "'>\n" +
						"<Shape DEF='Vertebrae Shape'\n" +
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
							 	"<IndexedFaceSet DEF='Vertebrae IFS' \n" +
							    	   "containerField='geometry' \n" +
							    	   "creaseAngle='" +  bioMightTransform.getCreaseAngle() + "'\n" +
							    	   "coordIndex='" + bioMightTransform.getCoordindexStr() + "'>" +
							    	   "<Coordinate DEF='Vertebrae _Coord' \n" +
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
				 "<ROUTE fromNode='StomachBeatAnim' fromField='value_changed' toNode='Vertebrae' toField='set_scale'/>\n";
			}
			else
			{
				body = "";//						
			}
			
			}
			
			//System.out.println("RightAtrium X3D: " + body);	
			String footer = "</Scene>" + "</X3D>\n";
			
			if (snipet)
				return body;			
			else	
				return header + body + footer;
		}	
		


	
	
	
	
	
	
}
