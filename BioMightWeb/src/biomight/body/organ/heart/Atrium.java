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
public class Atrium extends BioMightBase {
		protected EndotheliumTissue endothelium;
		
		
		public Atrium()
		{
			int localVP= Constants.VIEW_HAWKEYE;
			int localLOD = Constants.MAG1X;
			create(localVP, localLOD, Constants.AtriumRef, null, null);
		}

		public Atrium(String parentID)
		{
			int localVP= Constants.VIEW_HAWKEYE;
			int localLOD = Constants.MAG1X;
			create(localVP, localLOD, parentID, null, null);
		}

		public Atrium(int hierarchy, int LOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
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
			this.setImage("images/Atrium.jpg");
		
			componentID=parentID;
			
			viewPerspective = Constants.VIEW_FLOATING;
			if (viewPerspective == Constants.VIEW_FLOATING) {

				// Generate the Atrium Atrium Endothelium if needed 
				boolean bGenerate = false;
				if (bGenerate) {
					generate(parentID, componentID);
				}
			
				System.out.println("Creating Atrium Endothelium: " + parentID);				
				endothelium = new EndotheliumTissue("AtriumEndothelium", parentID, bioMightMethods);
				System.out.println("Atrium Endothelium created...");				
			}
			else
			{
			
				
			}
			
			
			//initProperties();
			initMethods();
			
			System.out.println("Created Atrium");
			
			// First, get all the data from the database
			// Apply the methods to it
			// Save its state
			this.parentID = parentID;
			if (bioMightMethods != null){
				System.out.println("EXECUTING Atrium METHODS: " + bioMightMethods.size());
				//executeMethods(bioMightMethods);
			}
		}
		
	
		/******************************************************************
		 * GENERATE
		 * 
		 * @param parentID
		 * @param componentID
		 ******************************************************************/
		
		// generate the Atriums
		public void generate(String parentID, String componentID)
		{
			// Generate the Greater Curvature Edothelium		
			BioMightVascularBeanLocal bioMightBean;
			try {
				// Get the information from the database via the Enterprise Bean		
				System.out.println("Generating the Atrium AtriumEndothelium: " + componentID + "    " + parentID);
				InitialContext ctx = new InitialContext();
				bioMightBean = (BioMightVascularBeanLocal) ctx.lookup(Constants.VascularBeanRef);
		
				
			
				if (parentID.equals("Atrium:01")) 
				{	
					// Generate the Atrium AtriumEndothelium
					double radius = 0.001;
					double[] startPos = {0.5, -12.25, -2.5};
					double[][] currentPoints = BioGraphics.createCylinderInPlane(Constants.YPLANE, startPos, radius, 8);
				
		
					System.out.println("Calling Generate Atrium AtriumEndothelium: " + componentID + "    " + parentID);
					
					int success = bioMightBean.generateAtrium("AtriumEndothelium:00001", "AtriumEndothelium", 
						"AtriumEndothelium", componentID, parentID, currentPoints);			
						
				}			
				else if (parentID.equals("Atrium:02")) 
				{	
					// Generate the AdrenalArteryEndothelium of the stomach
					// Create 5 sections
				
					double radius = 0.5;
					double[] startPos = {-0.3, -12.25, -2.5};
					double[][] currentPoints = BioGraphics.createCylinderInPlane(Constants.YPLANE, startPos, radius, 8);
				
		
					System.out.println("Calling Generate Atrium AtriumEndothelium: " + componentID + "    " + parentID);
					
					int success = bioMightBean.generateAtrium("AtriumEndothelium:00360", "AtriumEndothelium", 
						"AtriumEndothelium", componentID, parentID, currentPoints);			
						
				}
				else if (parentID.equals("")) 
				{	
					System.out.println("Calling Generate Atrium AtriumEndothelium NoParent");
								
				}

				
				System.out.println("Created Atrium AtriumEndothelium Info using EJB");   	
			}catch (Exception e) { 
				System.out.println("Exception Getting Components - Atrium AtriumEndothelium");
				throw new ServerException("Remote Exception Atrium AtriumEndothelium():", e); 	
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
			
			// Assemble the Atrium
			String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
			"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n " +
			"<X3D profile='Immersive' >\n" +
			"<head>\n" +
			 "<meta name='BioMightImage' content='RightAtrium.jpg'/>\n" +
			 "<meta name='ExportTime' content='7:45:30'/>\n" +
			 "<meta name='ExportDate' content='08/15/2008'/>\n" +
			 "<meta name='BioMight Version' content='1.0'/>\n" + 
			"</head>\n" +
			"<Scene>\n" +
			"<WorldInfo\n" +
			"title='Atrium'\n" +
			"info='\"BioMight Generated X3D\"'/>\n";		

	
			String body = "";  
			
			viewPerspective = Constants.VIEW_FLOATING;
			if (viewPerspective == Constants.VIEW_FLOATING) {
				// Drill down to the endothelium
				body = endothelium.getX3D(true);  
			}
			// Just Render it now, at this level
			else if (viewPerspective == Constants.VIEW_DETACHED) 
			{
				// Run through the collection of RightAtrium  and build them into the model
				// In the default case, we get one instance of the RightAtrium  for each Stomach
				ArrayList transforms = bioMightTransforms.getTransforms();
				for (int i=0; i<transforms.size(); i++)
				{
					// Get the information for the RightAtrium we are creating
					BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
					System.out.println("Getting RightAtrium X3D: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
				
						//System.out.println("Getting X3D for RightAtrium X: " + bioMightSphere.getTranslation().getXPos());
						//System.out.println("Getting X3D for RightAtrium Y: " + bioMightSphere.getTranslation().getYPos());
						//System.out.println("Getting X3D for RightAtrium Z: " + bioMightSphere.getTranslation().getZPos());
						// Change the height and width based on the displacement.
						body += "<Transform DEF='RightAtrium '\n" +
				 			"translation='" + bioMightTransform.getTranslation().getXPos() + " " 
					 					+ bioMightTransform.getTranslation().getYPos() + " "
					 					+ bioMightTransform.getTranslation().getZPos() + "'\n" +
					 		"scale='" 	+ bioMightTransform.getScale().getXPos() + " "
					 				+ bioMightTransform.getScale().getYPos() + " "
					 				+ bioMightTransform.getScale().getZPos() + "'>\n" +
							"<Shape DEF='RightAtrium Shape'\n" +
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
								 	"<IndexedFaceSet DEF='RightAtrium IFS' \n" +
								    	   "containerField='geometry' \n" +
								    	   "creaseAngle='" +  bioMightTransform.getCreaseAngle() + "'\n" +
								    	   "coordIndex='" + bioMightTransform.getCoordindexStr() + "'>" +
								    	   "<Coordinate DEF='RightAtrium _Coord' \n" +
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
					 "<ROUTE fromNode='StomachBeatAnim' fromField='value_changed' toNode='RightAtrium' toField='set_scale'/>\n";
				}
			}
			else
			{
				
			}
			
			//System.out.println("Atrium X3D: " + body);		
			
			String footer = "</Scene>" + "</X3D>\n";
			
			if (snipet)
				return body;			
			else	
				return header + body + footer;
		}
		
		
}
