/*
 * Created on May 14, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.body.organ.heart;

import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.naming.InitialContext;

import biomight.BioMightBase;
import biomight.Constants;
import biomight.ejb.BioMightBeanLocal;
import biomight.ejb.BioMightVascularBeanLocal;
import biomight.exceptions.DataSecurityException;
import biomight.exceptions.ServerException;
import biomight.system.tissue.edothelial.EndotheliumTissue;
import biomight.system.tissue.epithelial.EpitheliumTissue;
import biomight.util.BioGraphics;
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
public class Ventricle extends BioMightBase {
		protected EndotheliumTissue endothelium;
		
		
		public Ventricle()
		{
			int localVP= Constants.VIEW_HAWKEYE;
			int localLOD = Constants.MAG1X;
			create(localVP, localLOD, Constants.VentricleRef, null, null);
		}

		public Ventricle(String parentID)
		{
			int localVP= Constants.VIEW_HAWKEYE;
			int localLOD = Constants.MAG1X;
			create(localVP, localLOD, parentID, null, null);
		}

		public Ventricle(int hierarchy, int LOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
		{
			create(hierarchy, LOD, parentID, bioMightProperties, bioMightMethods);
		}

		/*****************************************************************
		 * CREATE
		 * 
		 * @param parentID
		 * @param bioMightMethods
		 ******************************************************************/
		public void create(int hierarchy, int LOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
		{
			this.setImageWidth(300);
			this.setImageHeight(325);
			this.setImage("images/Ventricle.jpg");
		
			componentID=parentID;
			
			viewPerspective = Constants.VIEW_FLOATING;
			if (viewPerspective == Constants.VIEW_FLOATING) {

				// Generate the Heart Ventricle Endothelium if needed 
				boolean bGenerate = false;
				if (bGenerate) {
					generate(parentID, componentID);
				}
			
				System.out.println("Creating Ventricle Endothelium: " + parentID);				
				endothelium = new EndotheliumTissue("VentricleEndothelium", parentID, bioMightMethods);
				System.out.println("Ventricle Endothelium created...");				
			}
			else
			{
				
			}	
			
			//initProperties();
			initMethods();
			
			System.out.println("Created Ventricle");
			
			// First, get all the data from the database
			// Apply the methods to it
			// Save its state
			this.parentID = parentID;
			if (bioMightMethods != null){
				System.out.println("EXECUTING Ventricle METHODS: " + bioMightMethods.size());
				//executeMethods(bioMightMethods);
			}
		}
		
		
		/******************************************************************
		 * GENERATE
		 * 
		 * @param parentID
		 * @param componentID
		 ******************************************************************/
		
		// generate the doHeart Ventricle En
		public void generate(String parentID, String componentID)
		{
			// Generate the Ventricle Endothelium		
			BioMightVascularBeanLocal bioMightBean;
			try {
				// Get the information from the database via the Enterprise Bean		
				System.out.println("Generating the Ventricle HeartEndothelium: " + componentID + "    " + parentID);
				InitialContext ctx = new InitialContext();
				bioMightBean = (BioMightVascularBeanLocal) ctx.lookup(Constants.VascularBeanRef);
		
				double radius = 0.001;
			
				if (parentID.equals("Ventricle:01")) 
				{	
					// Generate the Ventricle HeartEndothelium
					// Create 5 sections
					// Generate the Atrium AtriumEndothelium
					// double[] startPos = {-0.15, -13.250, -3.0};
					double[] startPos = {-0.15, -13.250, -2.750};
					double[][] currentPoints = BioGraphics.createCylinderInPlane(Constants.YPLANE, startPos, radius, 8);
			
					System.out.println("Calling Generate Ventricle HeartEndothelium: " + componentID + "    " + parentID);
					
					int success = bioMightBean.generateVentricle("VentricleEndothelium:00001", "VentricleEndothelium", 
						"VentricleEndothelium", componentID, parentID, currentPoints);			
						
				}			
				else if (parentID.equals("Ventricle:02")) 
				{	
					// Generate the Ventricle of the stomach
					// Create 5 sections	
					double[] startPos = {1.00, -13.250, -2.750};
					double[][] currentPoints = BioGraphics.createCylinderInPlane(Constants.YPLANE, startPos, radius, 8);
	
					System.out.println("Calling Generate Ventricle HeartEndothelium: " + componentID + "    " + parentID);
					
					int success = bioMightBean.generateVentricle("VentricleEndothelium:00360", "VentricleEndothelium", 
						"VentricleEndothelium", componentID, parentID, currentPoints);			
						
				}
				else if (parentID.equals("")) 
				{	
					System.out.println("Calling Generate Ventricle HeartEndothelium NoParent");
								
				}

				
				System.out.println("Created Ventricle HeartEndothelium Info using EJB");   	
			}catch (Exception e) { 
				System.out.println("Exception Getting Components - Ventricle HeartEndothelium");
				throw new ServerException("Remote Exception Ventricle HeartEndothelium():", e); 	
			}
		}

		
		
		
		public void initProperties() {

			properties = new ArrayList<BioMightPropertyView>();
			
			BioMightPropertyView property = new BioMightPropertyView();
			property.setPropertyName("Stapes ---");
			property.setCanonicalName(Constants.RightEar);
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
			
			// Assemble the Ventricle
			String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
			"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n " +
			"<X3D profile='Immersive' >\n" +
			"<head>\n" +
			 "<meta name='BioMightImage' content='RightVentricle.jpg'/>\n" +
			 "<meta name='ExportTime' content='7:45:30'/>\n" +
			 "<meta name='ExportDate' content='08/15/2008'/>\n" +
			 "<meta name='BioMight Version' content='1.0'/>\n" + 
			"</head>\n" +
			"<Scene>\n" +
			"<WorldInfo\n" +
			"title='VentricleEndothelium'\n" +
			"info='\"BioMight Generated X3D\"'/>\n";		

			String body = endothelium.getX3D(true);  
			
			//System.out.println("Ventricle X3D: " + body);		
			
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
			 "<meta name='BioMightImage' content='RightVentricle .jpg'/>\n" +
			 "<meta name='ExportTime' content='7:45:30'/>\n" +
			 "<meta name='ExportDate' content='08/15/2008'/>\n" +
			 "<meta name='BioMight Version' content='1.0'/>\n" + 
			"</head>\n" +
			"<Scene>\n" +
			"<WorldInfo\n" +
			"title='RightVentricle '\n" +
			"info='\"BioMight Generated X3D\"'/>\n";		


			String body = "";
			
			// Run through the collection of RightVentricle  and build them into the model
			// In the default case, we get one instance of the RightVentricle  for each Stomach
			ArrayList transforms = bioMightTransforms.getTransforms();
			for (int i=0; i<transforms.size(); i++)
			{
				// Get the information for the RightVentricle we are creating
				BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
				System.out.println("Getting RightVentricle X3D: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
			
				int view = Constants.VIEW_FLOATING;
				if (view == Constants.VIEW_FLOATING)
				{
					//System.out.println("Getting X3D for RightVentricle X: " + bioMightSphere.getTranslation().getXPos());
					//System.out.println("Getting X3D for RightVentricle Y: " + bioMightSphere.getTranslation().getYPos());
					//System.out.println("Getting X3D for RightVentricle Z: " + bioMightSphere.getTranslation().getZPos());
					// Change the height and width based on the displacement.
					body += "<Transform DEF='RightVentricle '\n" +
			 			"translation='" + bioMightTransform.getTranslation().getXPos() + " " 
				 					+ bioMightTransform.getTranslation().getYPos() + " "
				 					+ bioMightTransform.getTranslation().getZPos() + "'\n" +
				 		"scale='" 	+ bioMightTransform.getScale().getXPos() + " "
				 				+ bioMightTransform.getScale().getYPos() + " "
				 				+ bioMightTransform.getScale().getZPos() + "'>\n" +
						"<Shape DEF='RightVentricle Shape'\n" +
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
							 	"<IndexedFaceSet DEF='RightVentricle IFS' \n" +
							    	   "containerField='geometry' \n" +
							    	   "creaseAngle='" +  bioMightTransform.getCreaseAngle() + "'\n" +
							    	   "coordIndex='" + bioMightTransform.getCoordindexStr() + "'>" +
							    	   "<Coordinate DEF='RightVentricle _Coord' \n" +
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
				 "<ROUTE fromNode='StomachBeatAnim' fromField='value_changed' toNode='RightVentricle' toField='set_scale'/>\n";
			}
			else
			{
				body = "";//						
			}
			
			}
			
			System.out.println("Ventricle X3D: " + body);		
			String footer = "</Scene>" + "</X3D>\n";
			
			if (snipet)
				return body;			
			else	
				return header + body + footer;
		}	
		
	
}
