/****************************************************************************************
 * Created on Sep 26, 2006
 *
 * Represents a collection of Bacteriophages
 * 
 * 
 ****************************************************************************************/


package biomight.virus.dna;
import java.lang.reflect.Method;
import java.util.ArrayList;

import javax.naming.InitialContext;

import org.apache.openejb.math.util.MathUtils;

import biomight.BioMightBase;
import biomight.Constants;
import biomight.ejb.BioMightBeanLocal;
import biomight.ejb.BioMightCellularBeanLocal;
import biomight.exceptions.ServerException;
import biomight.util.BioGraphics;
import biomight.view.BioMightMethodView;
import biomight.view.BioMightPolygon;
import biomight.view.BioMightPosition;
import biomight.view.BioMightPositions;
import biomight.view.BioMightPropertyView;
import biomight.view.BioMightScale;
import biomight.view.BioMightTransform;

/*********************************************************************************
 * @author SurferJim
 *
 * Representation of Bacteriophages
 ********************************************************************************/

public class BacteriophagesFlat extends BioMightBase {
private ArrayList bacteriophages;

	
	/********************************************************************************************************************
	 *  Bacteriophages
	 * 
	 * This method will instantiate the Bacteriophages that are defined for the current model.  
	 * 
	 ********************************************************************************************************************/

	public BacteriophagesFlat()
	{		
		int localVP= Constants.BIO_CHILD;
		int localLOD = Constants.VIEW_HAWKEYE;
		create(localVP, localLOD, Constants.CellsRef, null, null);
	}
	
	/********************************************************************************************************************
	 *  Bacteriophages
	 * 
	 * This method will instantiate the Bacteriophages that are defined for the current model.  
	 * 
	 ********************************************************************************************************************/

	public BacteriophagesFlat(String parentID)
	{				
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, parentID, null, null);
	}
	
	public BacteriophagesFlat(int localVP, int localLOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
	{		
		create(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);
	}
		
	/********************************************************************************************************************
	 * CREATE Bacteriophages
	 * 
	 * This method will instantiate the hips that are defined for the current model.  
	 * 
	 ********************************************************************************************************************/

	private void create(int localVP, int localLOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods) 
	{
		this.setImage("images/Bacteriophages.jpg");
		
		bacteriophages = new ArrayList();
	
		// This is a collection, so set the parent of the children
		// to that of the aggregation object
		this.parentID=parentID;
		this.componentID = parentID;
		this.lod = localLOD;
		this.viewPerspective = localVP;
		
		
		if (bioMightMethods != null){
			System.out.println("EXECUTING Bacteriophages Methods: " + bioMightMethods.size());
			executeMethods(bioMightMethods);
		}
		
		// Get the information from the database via the Enterprise Bean.  This will get
		// a collection of Bacteriophages
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Getting Bacteriophages Transform: " + componentID + "   " +  parentID);
			InitialContext ctx = new InitialContext();
			BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
			bioMightTransforms = bioMightBean.getComponents(Constants.BacteriophageRef, parentID);   	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - Bacteriophages");
			throw new ServerException("Remote Exception getComponents():", e); 	
		}
		
		
		// Run through the collection of bacteriophages and build them into the model
		ArrayList transforms = bioMightTransforms.getTransforms();
		System.out.println("Have Bacteriophages NumTransforms: " + transforms.size());
		
		// If we are culling the data set
		int numRetreive=transforms.size();
	
		BioMightScale bioScale = new BioMightScale("0.00, 0.00, 0.00");
		BioMightPosition  bioPos = new BioMightPosition("0.00, 0.00, 0.00");
		String bioTemplate="AdenoViruses.x3d";

		for (int i=0; i<transforms.size(); i++)
		{
			// Get the information for the bacteriophage we are creating
			BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
			System.out.println("Creating Bacteriophage: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
			
			// Create an instance of a Bacteriophage for each tranform specified
			localVP = Constants.VIEW_INTERNAL;
			localLOD = Constants.MAG1X;
			
			Bacteriophage bacteriophage = new Bacteriophage(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);		
			System.out.println("Bacteriophage Created!: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
			bacteriophages.add(bacteriophage);
			System.out.println("Added Bacteriophage to Collection!: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());

			// initialize the Properties
			// in this case, rather than pass canonical name, we pass the name found in the collectio
			initProperty(bioMightTransform.getName(), Constants.Bacteriophage, Constants.BacteriophageRef, bioMightTransform.getId());				
			//initProperty(bioMightTransform.getName(), Constants.Bacteriophage, Constants.BacteriophageRef, parentID);
			
			int numElements = 50;
			if (i == numElements)
				break;
		}

		// Set up methods that will be available to the bacteriophages
		initMethods(bioMightMethods);
	}
	
	
	public void initMethods(ArrayList<BioMightMethodView> bioMightMethodsIn) {
			
		// If we are coming in normally the methods and properties will not
		// be populated.   When processing data they will and we need to use
		// those values
		if (bioMightMethodsIn.size() == 0) {
			System.out.println("New Set of BacteriophagesMethods: " + bioMightMethodsIn.size());
			BioMightMethodView method = new BioMightMethodView();
			method.setCanonicalName(Constants.Bacteriophages);
			method.setMethodName("setColonySize");
			method.setDisplayName("Colony Size:");
			method.setHtmlType("text");
			method.setDataType(Constants.BIO_INT);
			methods.add(method);
		}
		else
		{
			System.out.println("Using Existing BacteriophagesMethods: " + bioMightMethodsIn.size());
			// using the data passed in from the previous invocation
			methods = bioMightMethodsIn;
		}
	}
	
	
	/********************************************************************************************************************
	 * GET X3D
	 * 
	 * This method will return the X3D for the Cell.  It runs through each of its components and collects up their
	 * representations and then assembles them into one unified X3D model.
	 * 
	 ********************************************************************************************************************/
	public String getX3D(boolean snipet) {
		
		// Assemble the Bacteriophages
		String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
		"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n " +
		"<X3D profile='Immersive' >\n" +
		"<head>\n" +
		 "<meta name='BioMightImage' content='Hips.jpg'/>\n" +
		 "<meta name='ExportTime' content='7:45:30'/>\n" +
		 "<meta name='ExportDate' content='08/15/2008'/>\n" +
		 "<meta name='BioMight Version' content='1.0'/>\n" + 
		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='Bacteriophages'\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		

		String body = ""; 


		// Grab the data from the collection that we just created.
		if (viewPerspective == Constants.VIEW_HAWKEYE)
		{
			System.out.println("Assembling X3D for Bacteriophages HawkEyeView - size: " + bacteriophages.size());
			
			// Run through the collection of Bacteriophages and assemble the X3D for each
			for (int i=0; i<bacteriophages.size(); i++)
			{
				// Get the information for the bacteriophage
				//Bacteriophage bacteriophage = (Bacteriophage) bacteriophages.get(i);
				//System.out.println("Getting X3D for Bacteriophage: " + bacteriophage.getComponentID());
				//body += bacteriophage.getX3D(true);
			}		
			
			body="";
			
			
			//*******************************************************************
			//
			// Run through the records in the database
			//
			//*******************************************************************
			
			ArrayList transforms = bioMightTransforms.getTransforms();
			for (int i=0; i<transforms.size(); i++)
			{
				// Get the information for the capsomer we are creating
				BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
				System.out.println("Getting X3D -InternalView - for Bacteriophage: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());				
				//System.out.println("Getting X3D for BacteriophageX: " + bioMightTransform.getTranslation().getXPos());
				//System.out.println("Getting X3D for BacteriophageY: " + bioMightTransform.getTranslation().getYPos());
				//System.out.println("Getting X3D for BacteriophageZ: " + bioMightTransform.getTranslation().getZPos());

				
				//*******************************************************************
				//
				// CREATE THE TOP CAP
				//
				//*******************************************************************
				double capHeight = 0.5;
				double bodyHeight = 0.5;
				double neckHeight = 2.0;
				double neckDisplacement = 0.75;
				double neckRadius = 0.1;
			
				double fiberRadius = 0.05;
				double fiberLength = MathUtils.round(neckHeight/2, 8);
				
				double[] startPos = {0, 0, 0};
						//bioMightTransform.getTranslation().getXPos(), 
						//bioMightTransform.getTranslation().getYPos()-capHeight, 
						//bioMightTransform.getTranslation().getZPos()};
				double capTopPos[] = {(startPos[0] + capHeight), 0, 0};
				
				double radius = 0.5; //bioMightTransform.getRadius();
				double outerRadius = 0.75;
				System.out.println("Creating Pentagon with radius: " + radius);
				
				int numPoints = 6;
				double[][] cyPoints = BioGraphics.createCylinderInPlane(Constants.XPLANE, startPos, radius, numPoints);
				double[][] cyCapPoints = BioGraphics.createCylinderInPlane(Constants.XPLANE, startPos, outerRadius, numPoints);
				
		        float angle = 360 / numPoints;
		      	//double angleRadians = Math.toRadians(angle);
		    
		        double degrees90 = Math.toRadians(90);
		        
				// Create 5 triangles and form them into an index faced set.
				// Use the Centerpoint of 0,0,0 and drop the startPos 
				// of the create Cylinder to determine the depth of the cap
				String coordinateString = "";
				String centerPointStr = capTopPos[0] + ",  0.0,  0.0"; 
				for (int k=0; k<cyPoints.length; k++)
				{
					// Draw 5 triangles by connecting the Centerpoint to each of
					// the cylinder points generated above
					if (k==0)
						coordinateString = centerPointStr + ", \n" + cyPoints[k][0]  + ", " +  cyPoints[k][1] + ", " + cyPoints[k][2];
					else
						coordinateString += ",\n  " + cyPoints[k][0]  + ",  " +  cyPoints[k][1] + ",  " + cyPoints[k][2];									
				}
				//System.out.println("Top Cap-CoordinateStr: " + coordinateString);
				
	
				//********************************************
				//
				// Create a GlycoProteinShell for the Top Cap
				//
				//*********************************************
				
				// Allocate the Coordinate-Index Array for Polygon 
				String tempIndexStr = 
					"0, 2, 1, -1,\n" +
					"0, 3, 2, -1,\n" +
					"0, 4, 3, -1,\n" +
					"0, 5, 4, -1,\n" +
					"0, 6, 5, -1,\n" +
					"0, 1, 6, -1,\n";
				
				
				String componentType = "BacteriophageCap";
				body += "<Transform DEF='" + componentType + "'\n";
				
		 		body += "translation='" 
		 			+ bioMightTransform.getTranslation().getXPos() + " " 
					+ bioMightTransform.getTranslation().getYPos() + " "
					+ bioMightTransform.getTranslation().getZPos() + "'\n";					
		
			 	body+= "scale='" 	
			 			+ bioMightTransform.getScale().getXPos() + " "
			 			+ bioMightTransform.getScale().getYPos() + " "
			 			+ bioMightTransform.getScale().getZPos() + "'>\n" +
					"<Shape DEF='" + componentType + "'\n" +
		    	    	
					    " containerField='children'>\n" +
					    " <Appearance\n" +
					    "  containerField='appearance'>\n";
						    
			 	//bioMightTransform.setCoordpoint(Constants.TRIANGLE, coordinateString, 0.025, 0);
			 	//bioMightTransform.setCoordIndex(tempInd);
			
			 	body+= " <Material DEF='Rust'\n" +
				    "containerField='material'\n" +
				    "ambientIntensity='" + bioMightTransform.getMaterial().getAmbientIntensity() + "'\n" +
				    "shininess='" 		 + bioMightTransform.getMaterial().getShininess() + "'\n" +
				    "transparency='" 	 + 0 + "'\n" +
				    "diffuseColor='" + 
				    0 + " " + 
				    .20 + " " +
				    .40 + "'/>\n" +
				 	"</Appearance>\n" +
				    
				 	"<IndexedFaceSet DEF='AdenoVirusCapIFS' \n" +
				    	   "containerField='geometry' \n" +
				    	   "creaseAngle='" +  bioMightTransform.getCreaseAngle() + "'\n" +
				    	   "solid='false' \n" +
				    	   "coordIndex='" + tempIndexStr + "'>" +
				    	   "<Coordinate DEF='AdenoVirusCap_Coord' \n" + 
				    	    "containerField='coord' point='" + coordinateString + "'/>" +
				    	  "</IndexedFaceSet>\n" +
				    
				    	 "</Shape>\n" +
				    	 
				    	 "<TouchSensor DEF='StartEndothelium' \n" +
		                   " description='" + componentType + "'\n" +
			               " containerField='children'/> \n" +
				    	 
				"</Transform>\n"; 
			
			 	
			 	//***************************************************************
			 	// CREATE THE BOTTOM CAP
			 	//
				// Create coordinates for the base of the Bacteriophage capsid
			 	//
			 	//****************************************************************
				String baseCoordinateString = "";
				startPos[0] = (startPos[0] - bodyHeight);
				double capBasePos[] = {(startPos[0] - capHeight), 0, 0};
				double[][] cyBasePoints = BioGraphics.createCylinderInPlane(Constants.XPLANE, startPos, radius, numPoints);
				//double[][] cyBaseCapPoints = BioGraphics.createCylinderInPlane(Constants.XPLANE, startPos, outerRadius, numPoints);
						
				// Create 5 triangles and form them into an index faced set.
				// Use the Centerpoint of 0,0,0 and drop the startPos 
				// of the create Cylinder to determine the depth of the cap
				centerPointStr = capBasePos[0] + ", 0.0, 0.0"; 
				for (int k=0; k<cyBasePoints.length; k++)
				{
					// Draw 5 triangles by connecting the Centerpoint to each of
					// the cylinder points generated above
					if (k==0)
						baseCoordinateString = centerPointStr + ", \n" + cyBasePoints[k][0]  + ", " +  cyBasePoints[k][1] + ", " + cyBasePoints[k][2];
					else
						baseCoordinateString += ",\n  " + cyBasePoints[k][0]  + ",  " +  cyBasePoints[k][1] + ",  " + cyBasePoints[k][2];		
				
					//*********************************
					// Do Bottom Center Pinnacle
					//*********************************
					if (k==0)
					{
						//System.out.println("CapBase Coordinates: " 
						//       + capBasePos[0]  + " " 
			 			//		+ capBasePos[1]  + " "
			 			//		+ capBasePos[2]);			
					}
						
				}
				
				// Allocate the Coordinate-Index Array for Polygon 
				String tempBaseIndexStr = 
					"0, 1, 2, -1,\n" +
					"0, 2, 3, -1,\n" +
					"0, 3, 4, -1,\n" +
					"0, 4, 5, -1,\n" +
					"0, 5, 6, -1,\n" +
					"0, 6, 1, -1,\n";
				 
				
				componentType = "AdenoBody";
				body += "<Transform DEF='" + componentType + "'\n";
				
			
		 		body += "translation='" 
		 			+ bioMightTransform.getTranslation().getXPos() + " " 
					+ bioMightTransform.getTranslation().getYPos() + " "
					+ bioMightTransform.getTranslation().getZPos() + "'\n";					
		
				
			 	body+= "scale='" 	
			 			+ bioMightTransform.getScale().getXPos() + " "
			 			+ bioMightTransform.getScale().getYPos() + " "
			 			+ bioMightTransform.getScale().getZPos() + "'>\n" +
					"<Shape DEF='" + componentType + "'\n" +
		    	    	
					    " containerField='children'>\n" +
					    " <Appearance\n" +
					    "  containerField='appearance'>\n";
						    
			 	//bioMightTransform.setCoordpoint(Constants.TRIANGLE, coordinateString, 0.025, 0);
			 	//bioMightTransform.setCoordIndex(tempInd);
			
			 	body+= " <Material DEF='Rust'\n" +
				    "containerField='material'\n" +
				    "ambientIntensity='" + bioMightTransform.getMaterial().getAmbientIntensity() + "'\n" +
				    "shininess='" 		 + bioMightTransform.getMaterial().getShininess() + "'\n" +
				    "transparency='" 	 + 0 + "'\n" +
				    "diffuseColor='" +  0 + " " + .20 + " " + .40 + "'/>\n" +
				 	"</Appearance>\n" +			    
				 	"<IndexedFaceSet DEF='AdenoVirusCapIFS' \n" +
				    	   "containerField='geometry' \n" +
				    	   "creaseAngle='" +  bioMightTransform.getCreaseAngle() + "'\n" +
				    	   "solid='false' \n" +
				    	   "coordIndex='" + tempBaseIndexStr + "'>" +
				    	   "<Coordinate DEF='AdenoVirusCap_Coord' \n" + 
				    	    "containerField='coord' point='" + baseCoordinateString + "'/>" +
				    	  "</IndexedFaceSet>\n" +
				    
				    	 "</Shape>\n" +
				    	 
				    	 "<TouchSensor DEF='StartEndothelium' \n" +
		                   " description='" + componentType + "'\n" +
			               " containerField='children'/> \n" +
				    	 
				"</Transform>\n"; 
				

			 	
			 	//***************************************************************
			 	// CREATE THE BODY
			 	//
			 	// Now that we have the top and base caps, we connect the opposing 
			 	// vetices.  No new vertices are added.  We first go around the top
			 	// connecting to the bottom, then we connect going around the bottom
			 	// connecting to the top
			 	//****************************************************************
				
				// Allocate the Coordinate-Index Array for Polygon 
			 	// 0 and 6 are ctrpoints	
				String tempBodyIndexStr = 	
					"1,       2,     9,      8,   -1,  \n" +
					"2,       3,     10,     9,   -1,  \n" + 
					"3,       4,     11,    10,   -1,  \n" +
					"4,       5,     12,    11,   -1,  \n" +
					"5,       6,     13,    12,   -1, \n" +
					"6,       1,     8,     13,   -1, \n" 
			
					//"7,     1,     8,   -1,\n" +
					//"8,     2,     9,   -1,\n" +
					//"9,     3,    10,   -1,\n" +
					//"10,    4,    11,   -1,\n" +
					//"11,    5,     7,   -1,\n"	
					;
				
				
				componentType = "AdenoBody";
				body += "<Transform DEF='" + componentType + "'\n";
				
			
		 		body += "translation='" 
		 			+ bioMightTransform.getTranslation().getXPos() + " " 
					+ bioMightTransform.getTranslation().getYPos() + " "
					+ bioMightTransform.getTranslation().getZPos() + "'\n";					
		
				
			 	body+= "scale='" 	
			 			+ bioMightTransform.getScale().getXPos() + " "
			 			+ bioMightTransform.getScale().getYPos() + " "
			 			+ bioMightTransform.getScale().getZPos() + "'>\n" +
					"<Shape DEF='" + componentType + "'\n" +
		    	    	
					    " containerField='children'>\n" +
					    " <Appearance\n" +
					    "  containerField='appearance'>\n";
						    
			 	//bioMightTransform.setCoordpoint(Constants.TRIANGLE, coordinateString, 0.025, 0);
			 	//bioMightTransform.setCoordIndex(tempInd);
			
			 	body+= " <Material DEF='Rust'\n" +
				    "containerField='material'\n" +
				    "ambientIntensity='" + bioMightTransform.getMaterial().getAmbientIntensity() + "'\n" +
				    "shininess='" 		 + bioMightTransform.getMaterial().getShininess() + "'\n" +
				    "transparency='" 	 + 0 + "'\n" +
				    "diffuseColor='" +  0 + " " + .20 + " " + .40 + "'/>\n" +
				 	"</Appearance>\n" +			    
				 	"<IndexedFaceSet DEF='AdenoVirusBodyIFS' \n" +
				    	   "containerField='geometry' \n" +
				    	   "creaseAngle='" +  bioMightTransform.getCreaseAngle() + "'\n" +
				    	   "solid='false' \n" +
				    	   "coordIndex='" + tempBodyIndexStr + "'>" +
				    	   "<Coordinate DEF='AdenoVirusBody_Coord' \n" + 
				    	    "containerField='coord' point='" + coordinateString + " " + baseCoordinateString + "'/>" +
				    	  "</IndexedFaceSet>\n" +
				    
				    	 "</Shape>\n" +
				    	 
				    	 
				"</Transform>\n";
			 	
			 
				//********************************************
				// CREATE the NECK
				//********************************************
			 	
				body += "<Transform DEF='TRANSFORM_CAPBASECTR" + bioMightTransform.getId() + "' \n";
			 	body += "translation='" 
			 		+ (capBasePos[0] - neckDisplacement) + " " 
 					+ capBasePos[1] + " "
 					+ capBasePos[2] + "'\n";	
			 	
				body +=  "rotation='" 
						+ 0 + " "
						+ 0 + " "
						+ 1  + " "
						+ degrees90 + "'>\n\n";
				
				body +=  "scale='1 1 1'>\n" +
				 	"<Shape DEF='SHAPE_" + bioMightTransform.getId() + 101 + "' \n" +
				    " containerField='children'>\n" +
				    " <Appearance\n" +
				    "  containerField='appearance'>\n";

				body+= " <Material DEF='Rust'\n" +
				    "containerField='material'\n" +
				    "ambientIntensity='" 	+ bioMightTransform.getMaterial().getAmbientIntensity() + "'\n" +
				    "shininess='" 			+ bioMightTransform.getMaterial().getShininess() + "'\n" +
				    "transparency='" 		+ 0.25 + "'\n" +
				    "diffuseColor='0.0  0.80  0.40'/>\n" +
				 	"</Appearance>\n" +
				 
				 	"<Cylinder DEF='PhageNeck'\n" +
				 	"containerField='geometry'\n" +
				 	"radius='" + neckRadius +"'\n" +
				 	"height='" + neckHeight +"'/>\n" +
				 	"</Shape>\n" +
				 "</Transform>\n";
		
			
			 	//***************************************************************
			 	// CREATE THE INNER LEGS
			 	//
				// Create coordinates for the inner leg segmments.  Tilt the legs
				// back outward
			 	//
			 	//****************************************************************
				double innerLegsRadius = 0.45;
				double innerLegPos[] = {-2.25, 0.0, 0.0};
				//numPoints=6;
				double[][] innerLegPoints = BioGraphics.createCylinderInPlane(Constants.XPLANE, innerLegPos, innerLegsRadius, numPoints);
				
				double angleLatitude = 60;
				double radiansLatitude =  Math.toRadians(angleLatitude);
				double totalAngleLatitude = 0;
				
				// We are drawing quarter way
			
				double angleLongitude = 120;
				double radiansLongitude =  Math.toRadians(angleLongitude);
		
				System.out.println("\nCreate Inner Leg!");
				System.out.println("radiansLatitude: " + radiansLatitude + " radiansLongitude: " + radiansLongitude);
		
				// Create 5 triangles and form them into an index faced set.
				// Use the Centerpoint of 0,0,0 and drop the startPos 
				// of the create Cylinder to determine the depth of the cap 
				for (int k=0; k<innerLegPoints.length; k++)
				{
					System.out.println("InnerLeg Coordinates for : + " + k + "\n" 
				        + "XPOS: " + innerLegPoints[k][0]  + "\n" 
		 				+ "YPOS: " + innerLegPoints[k][1]  + "\n" 
		 				+ "ZPOS: " + innerLegPoints[k][2] + "\n");			
					
					// Set the Orientation of the Cylinder on the surface of the Sphere
					// This replicates the logic in the Graphics routine that sets up the original coordinates
					
					// Get a Perpindicular so that we can rotate 
					double perpindick = MathUtils.round(((k*angleLatitude)+90), 6);
					double perpindickRadians = MathUtils.round(Math.toRadians(perpindick), 8);
					//System.out.println("Axilating  InnerLegs degrees: " + perpindick + "   radians: " + perpindickRadians);
					
			       	double sinRadians = MathUtils.round(Math.sin(perpindickRadians), 8);
		        	double cosRadians = MathUtils.round(Math.cos(perpindickRadians), 8);
		            			
					double xOrient =  0.0 ; //MathUtils.round(cosRadians * radius, 8) *  MathUtils.round(sinRadians * radius, 8); 
					double yOrient =  0.0; //MathUtils.round(sinRadians, 8); 
					double zOrient =  0.0; // MathUtils.round(cosRadians, 8); ; //MathUtils.round(sinRadians * radius, 8); ; 
					
					String diffuseColor = "0.0  0.80  0.40";
					if (k==0)
					{	        
						angleLongitude = 150;
						radiansLongitude =  Math.toRadians(angleLongitude);
						
						perpindick = 90;
						perpindickRadians = MathUtils.round(Math.toRadians(perpindick), 8);
				      	sinRadians = MathUtils.round(Math.sin(perpindickRadians), 8);
			        	cosRadians = MathUtils.round(Math.cos(perpindickRadians), 8);
						
						xOrient =  0.26; //-MathUtils.round(sinRadians, 8);  
						yOrient =  -0.68; // MathUtils.round(cosRadians, 8); 
						zOrient =  0.68; //0.2; //-MathUtils.round(sinRadians, 8); 
						// or
						
						angleLongitude = 100;
						xOrient =  0.85; //-MathUtils.round(sinRadians, 8);  
						yOrient =  0.36; // MathUtils.round(cosRadians, 8); 
						zOrient =  -0.36; //0.2; //-MathUtils.round(sinRadians, 8); 
					}
					else if (k==1)  // 60 
					{	
						angleLongitude = 100;
						radiansLongitude =  Math.toRadians(angleLongitude);
						
						perpindick = 60;
						perpindickRadians = MathUtils.round(Math.toRadians(perpindick), 8);
				      	sinRadians = MathUtils.round(Math.sin(perpindickRadians), 8);
			        	cosRadians = MathUtils.round(Math.cos(perpindickRadians), 8);
				
						xOrient =  -0.39; // MathUtils.round(sinRadians, 8); 
						yOrient =  -0.843; // MathUtils.round(sinRadians, 8); 
						zOrient =  -0.365; //MathUtils.round(cosRadians, 8); 
					}
					else if (k==2) // 120
					{
						angleLongitude = 150;
						radiansLongitude =  Math.toRadians(angleLongitude);
						
						perpindick = 60;
						perpindickRadians = MathUtils.round(Math.toRadians(perpindick), 8);
				      	sinRadians = MathUtils.round(Math.sin(perpindickRadians), 8);
			        	cosRadians = MathUtils.round(Math.cos(perpindickRadians), 8);
			
						xOrient =    0.28; // MathUtils.round(sinRadians, 8);  
						yOrient =  	 0.67; //MathUtils.round(cosRadians, 8); 
						zOrient =   -0.67; 
					
					}
					else if (k==3) // 180
					{
						diffuseColor = "0.10  0.40  0.40";
						angleLongitude = 150;
						radiansLongitude =  Math.toRadians(angleLongitude);
						
						perpindick = 60;
						perpindickRadians = MathUtils.round(Math.toRadians(perpindick), 8);
				      	sinRadians = MathUtils.round(Math.sin(perpindickRadians), 8);
			        	cosRadians = MathUtils.round(Math.cos(perpindickRadians), 8);
			
						xOrient =    0.28; // MathUtils.round(sinRadians, 8);  
						yOrient =  	 0.67; //MathUtils.round(cosRadians, 8); 
						zOrient =   -0.67;
					}
					else if (k==4) // 240
					{
						angleLongitude = 80;
						radiansLongitude =  Math.toRadians(angleLongitude);
						
						
						xOrient = 0.56; //MathUtils.round(cosRadians, 8) * MathUtils.round(sinRadians, 8); ;  
						yOrient = -0.707; // MathUtils.round(cosRadians, 8); // 0; //MathUtils.round(cosRadians, 8);
						zOrient = 0.31; //MathUtils.round(cosRadians, 8) * MathUtils.round(sinRadians, 8); //MathUtils.round(cosRadians * radius, 8); ; 
					}
					else if (k==5) // 300
					{
						angleLongitude = 80;
						radiansLongitude =  Math.toRadians(angleLongitude);
						
						
						xOrient = 0.17; //MathUtils.round(cosRadians, 8) * MathUtils.round(sinRadians, 8); ;  
						yOrient = -0.7; // MathUtils.round(cosRadians, 8); // 0; //MathUtils.round(cosRadians, 8);
						zOrient = 0.63; //MathUtils.round(cosRadians, 8) * MathUtils.round(sinRadians, 8); //MathUtils.round(cosRadians * radius, 8); ; 
					}
					else  
					{	
						xOrient =  MathUtils.round(sinRadians, 8); 
						yOrient =  MathUtils.round(cosRadians, 8); 
						zOrient =  0.0; //MathUtils.round(cosRadians * radius, 8); ; 
					}		
		
					System.out.println("InnerLeg Axis for : + " + k);
					System.out.println("innerLeg X-AXIS: " + xOrient);
					System.out.println("innerLeg Y-AXIS: " + yOrient);
					System.out.println("innerLeg Z-AXIS: " + zOrient);
					
					
					double degrees = radiansLongitude;
					System.out.println("innerLeg RotateAngle: " + angleLatitude + "  degrees: " +  degrees);
					
		
					if (k==0 || k==1 || k==2 || k==3 || k==4 || k==5) {
				
					//********************************************
					// Create the Bacteriophage inner legs
					//********************************************
				 	
					body += "<Transform DEF='TRANSFORM_CAPBASECTR" + bioMightTransform.getId() + k + "' \n";
				 	body += "translation='" 
				 		+ innerLegPoints[k][0] + " " 
	 					+ innerLegPoints[k][1] + " "
	 					+ innerLegPoints[k][2] + "'\n";	
	 		
					body +=  "rotation='" 
							+ xOrient + " "
							+ yOrient + " "
							+ zOrient  + " "
							+ degrees + "'>\n\n";
					
					body +=  "scale='1 1 1'>\n" +
					 	"<Shape DEF='SHAPE_" + bioMightTransform.getId() + "' \n" +
					    " containerField='children'>\n" +
					    " <Appearance\n" +
					    "  containerField='appearance'>\n";

					body+= " <Material DEF='Rust'\n" +
					    "containerField='material'\n" +
					    "ambientIntensity='" 	+ bioMightTransform.getMaterial().getAmbientIntensity() + "'\n" +
					    "shininess='" 			+ bioMightTransform.getMaterial().getShininess() + "'\n" +
					    "transparency='" 		+ 0.25 + "'\n" +
					    "diffuseColor='" + diffuseColor + "'/>\n" +
					 	
					    "</Appearance>\n" +
					 
					 	"<Cylinder DEF='PhageNeck'\n" +
					 	"containerField='geometry'\n" +
					 	"radius='" + fiberRadius +"'\n" +
					 	"height='" + fiberLength +"'/>\n" +
					 	"</Shape>\n" +
					 "</Transform>\n" ;
				
					}
					
					
					// Increase the angle on the arc that goes from left to right
					totalAngleLatitude = totalAngleLatitude + angleLatitude;
				}
				
				
				/*
			
			 	//***************************************************************
			 	// CREATE THE OUTER LEGS
			 	//
				// Create coordinates for the outer leg segmments.  Tilt the legs
				// back inward
			 	//
			 	//****************************************************************
				double outerLegsRadius = 1.0;
				double outerLegPos[] = {-2.25, 0, 0.0};
				String baseOuterCoordinateString = "";
				double[][] outerLegPoints = BioGraphics.createCylinderInPlane(Constants.XPLANE, outerLegPos, outerLegsRadius, numPoints);
		
				System.out.println("\nCreate Outer Leg!");
				System.out.println("radiansLatitude: " + radiansLatitude + " radiansLongitude: " + radiansLongitude);
		

				for (int j=0; j<outerLegPoints.length; j++)
				{
					System.out.println("OuterLegPoints Coordinates: \n" 
					        + outerLegPoints[j][0]  + "\n" 
			 				+ outerLegPoints[j][1]  + "\n" 
			 				+ outerLegPoints[j][2] + "\n");			

					// Set the Orientation of the Cylinder on the surface of the Sphere
					// This replicates the logic in the Graphics routine that sets up the original coordinates
								
					double perpindick = MathUtils.round(((j*angle)+90), 6);
					double perpindickRadians = MathUtils.round(Math.toRadians(perpindick), 8);
					System.out.println("Axilating  outerLegPoints degrees: " + perpindick + "   radians: " + perpindickRadians);
					
					double sinRadians = MathUtils.round(Math.sin(perpindickRadians), 8);
					double cosRadians = MathUtils.round(Math.cos(perpindickRadians), 8);
		            			
					double xOrient =  0.0 ; //MathUtils.round(cosRadians * radius, 8) *  MathUtils.round(sinRadians * radius, 8); 
					double yOrient =  0.0; //MathUtils.round(sinRadians, 8); 
					double zOrient =  0.0; // MathUtils.round(cosRadians, 8); ; //MathUtils.round(sinRadians * radius, 8); ; 
					
											
					angleLongitude = 120;
					if (j==0)
					{	  
						
						// Add 90 degrees to get perpindicular
						perpindick = MathUtils.round( ( (j*angleLatitude) +90) , 6);
						perpindickRadians = MathUtils.round(Math.toRadians(perpindick), 8);
						System.out.println("Axilating  outerLeg degrees: " + perpindick + "   radians: " + perpindickRadians);
						
				       	sinRadians = MathUtils.round(Math.sin(perpindickRadians), 8);
			        	cosRadians = MathUtils.round(Math.cos(perpindickRadians), 8);
			        		
						xOrient =  0.0;   
						yOrient =  0.55;   //MathUtils.round(cosRadians, 8);  
						zOrient = -0.834;  //-MathUtils.round(sinRadians, 8); 
					}
					else if (j==1) 
					{	
						radiansLongitude =  Math.toRadians(angleLongitude);
						
						
						xOrient = 0.5; //MathUtils.round(cosRadians, 8) * MathUtils.round(sinRadians, 8); ;  
						yOrient = -0.7; // MathUtils.round(cosRadians, 8); // 0; //MathUtils.round(cosRadians, 8);
						zOrient = 0.34; //MathUtils.round(cosRadians, 8) * MathUtils.round(sinRadians, 8); //MathUtils.round(cosRadians * radius, 8); ; 
	
					}
					else if (j==2) 
					{
						radiansLongitude =  Math.toRadians(angleLongitude);
						
						
						xOrient = -0.1; //MathUtils.round(cosRadians, 8) * MathUtils.round(sinRadians, 8); ;  
						yOrient = -0.3; // MathUtils.round(cosRadians, 8); // 0; //MathUtils.round(cosRadians, 8);
						zOrient = 0.95; //MathUtils.round(cosRadians, 8) * MathUtils.round(sinRadians, 8); //MathUtils.round(cosRadians * radius, 8); ; 
					}
					else if (j==3) 
					{
						radiansLongitude =  Math.toRadians(angleLongitude);
						
						
						xOrient = 0.8; //MathUtils.round(cosRadians, 8) * MathUtils.round(sinRadians, 8); ;  
						yOrient = 0.5; // MathUtils.round(cosRadians, 8); // 0; //MathUtils.round(cosRadians, 8);
						zOrient = -0.; //MathUtils.round(cosRadians, 8) * MathUtils.round(sinRadians, 8); //MathUtils.round(cosRadians * radius, 8); ; 
					}
					else if (j==4) 
					{
						radiansLongitude =  Math.toRadians(angleLongitude);
						
						
						xOrient = -0.39	; //MathUtils.round(cosRadians, 8) * MathUtils.round(sinRadians, 8); ;  
						yOrient = -0.78; // MathUtils.round(cosRadians, 8); // 0; //MathUtils.round(cosRadians, 8);
						zOrient = -0.47; //MathUtils.round(cosRadians, 8) * MathUtils.round(sinRadians, 8); //MathUtils.round(cosRadians * radius, 8); ; 
					}
					else if (j==5) 
					{
						radiansLongitude =  Math.toRadians(angleLongitude);
						
						
						xOrient = -0.5; //MathUtils.round(cosRadians, 8) * MathUtils.round(sinRadians, 8); ;  
						yOrient = -0.6; // MathUtils.round(cosRadians, 8); // 0; //MathUtils.round(cosRadians, 8);
						zOrient = -0.55; //MathUtils.round(cosRadians, 8) * MathUtils.round(sinRadians, 8); //MathUtils.round(cosRadians * radius, 8); ; 
					}
					else  
					{	
						xOrient =  MathUtils.round(sinRadians, 8); 
						yOrient =  MathUtils.round(cosRadians, 8); 
						zOrient =  0.0; //MathUtils.round(cosRadians * radius, 8); ; 
					}		
		
					System.out.println("outerLeg X-AXIS: " + xOrient);
					System.out.println("outerLeg Y-AXIS: " + yOrient);
					System.out.println("outerLeg Z-AXIS: " + zOrient);
					
					
					double degrees = radiansLongitude;
					System.out.println("outerLeg RotateAngle: " + radiansLongitude + "  degrees: " +  degrees);
					
	
					//********************************************
					// Create the Bacteriophage Neck
					//********************************************
				
					
					body += "<Transform DEF='TRANSFORM_CAPBASECTR" + bioMightTransform.getId() + "' \n";
				 	body += "translation='" 
					 		+ outerLegPoints[j][0] + " " 
		 					+ outerLegPoints[j][1] + " "
		 					+ outerLegPoints[j][2] + "'\n";	
				 	
					body +=  "rotation='" 
							+ xOrient + " "
							+ yOrient + " "
							+ zOrient  + " "
							+ degrees + "'>\n\n";
					
					body +=  "scale='1 1 1'>\n" +
					 	"<Shape DEF='SHAPE_" + bioMightTransform.getId() + 101 + "' \n" +
					    " containerField='children'>\n" +
					    " <Appearance\n" +
					    "  containerField='appearance'>\n";

					body+= " <Material DEF='Rust'\n" +
					    "containerField='material'\n" +
					    "ambientIntensity='" 	+ bioMightTransform.getMaterial().getAmbientIntensity() + "'\n" +
					    "shininess='" 			+ bioMightTransform.getMaterial().getShininess() + "'\n" +
					    "transparency='" 		+ 0.25 + "'\n" +
					    "diffuseColor='0.0  0.80  0.40'/>\n" +
					 	"</Appearance>\n" +
					 
					 	"<Cylinder DEF='PhageNeck'\n" +
					 	"containerField='geometry'\n" +
					 	"radius='" + fiberRadius +"'\n" +
					 	"height='" + fiberLength +"'/>\n" +
					 	"</Shape>\n" +
					 "</Transform>\n" ;							
				}
				*/
				
			}

		}	
		// This is for when we are going to deal with the collection data separately.  Like
		// when we do not want to access the sub components.
		else if (viewPerspective == Constants.VIEW_INTERNAL)
		{	
			System.out.println("Assembling X3D for Bacteriophages InternalView - size: " + bacteriophages.size());
			
			ArrayList transforms = bioMightTransforms.getTransforms();
			for (int i=0; i<transforms.size(); i++)
			{
				// Get the information for the capsomer we are creating
				BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
				System.out.println("Getting X3D -InternalView - for Bacteriophage: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());				

				//System.out.println("Getting X3D for BacteriophageX: " + bioMightTransform.getTranslation().getXPos());
				//System.out.println("Getting X3D for BacteriophageY: " + bioMightTransform.getTranslation().getYPos());
				//System.out.println("Getting X3D for BacteriophageZ: " + bioMightTransform.getTranslation().getZPos());
				// Change the height and width based on the displacement.
				body += "<Transform DEF='TRANSFORM_" + bioMightTransform.getId() + "' \n";
					
					
				// Set the position if we are working with the Tissue collection
				if (parentID.equals("1.10000:0"))
				{
					//body += "translation='" 
					//	+ bioMightPosition.getXPos() + " " 
			 		//	+ bioMightPosition.getYPos() + " "
			 		//	+ bioMightPosition.getZPos() + "'\n";
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
				 	"<Shape DEF='SHAPE_" + bioMightTransform.getId() + "' \n" +
				    " containerField='children'>\n" +
				    " <Appearance\n" +
				    "  containerField='appearance'>\n";

		
			
				body+= " <ImageTexture containerField='texture' " +
				    " url='../images/Bacteriophage.jpg'/>";
				
				
				    
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
				 	"<Sphere DEF='BacteriophageGeoSphere'\n" +
				 	"containerField='geometry'\n" +
				 	"radius='" + bioMightTransform.getRadius() +"'/>\n" +
				 	"</Shape>\n" +
				 	
					"\n<TouchSensor DEF='TSENSOR_" + bioMightTransform.getId() + "' \n" +
	                   " description='Bacteriophage'\n" +
		               " containerField='children'/> \n" +
	
				 "</Transform>\n";
								
			}
		}			

		body+= "<Viewpoint DEF='Viewpoint_Bacteriophage'\n" +
				 "description='Viewpoint1'\n" +
				 "jump='true'\n" +
				 "fieldOfView='0.785'\n" +
				 "position='0.0 0.0 10.0'\n" +
				 "orientation='0 0 1 0'/>\n";
		
		
		//System.out.println("Bacteriophages X3D: " + body);		
		String footer = "</Scene>" + "</X3D>\n";
		
		if (snipet)
			return body;			
		else	
			return header + body + footer;
	}


	/******************************************************************************************
	 * EXECUTE METHODS 
	 *
	 ******************************************************************************************/
	public void executeMethods(ArrayList<BioMightMethodView> bioMightMethods) {

		// Run through the argument list and executes the 
		// associated methods
		boolean fired = false;
		System.out.println("Bacteriophages-Executing Methods: " + bioMightMethods.size());
		for (int j=0; j<bioMightMethods.size(); j++){
			
			// Get the parameter from the list and if it is not
			// empty execute the associated method using it
			BioMightMethodView bioMightMethod = (BioMightMethodView) bioMightMethods.get(j);
			System.out.println("Have BioMightMethod for Bacteriophages: " + bioMightMethod.getMethodName());	
			String methodName = bioMightMethod.getMethodName();
			String canonicalName = bioMightMethod.getCanonicalName(); 
			String dataType = bioMightMethod.getDataType();
			String methodParam = bioMightMethod.getMethodParameter(); 
			if (methodParam == null)
				methodParam = "";
			
			// We only execute those methods that are targeted for the IRIS
			// If a parameter is specified then we fire the method, otherwise
			// we just jump over it
			if (canonicalName.equals(Constants.Bacteriophages)) {				
				if (!methodParam.equals(""))
				{
					System.out.println("Execute Method " + methodName + " with Signature: "  +  dataType);
					System.out.println("with DataType: "  +  dataType  + "   value: " + methodParam);
					
					fired=true;		
					// Use the DataType parameter to convert the data into its base form
				
					if (dataType.equals("int")) {
						
						try {
							System.out.println("Locating Method(Integer)" + methodName);
							// 	Locate the method through introspection
							int numElements = Integer.parseInt(methodParam);
							Class paramsType[] = {int.class};
							Method method = this.getClass().getDeclaredMethod(methodName, paramsType);
							System.out.println("Before Execute Method(Integer)" + methodName);
							Object result = method.invoke(this, numElements);
							System.out.println("After Execute Method(Integer)" + methodName);	
						}
						catch (NumberFormatException e)
						{
							System.out.println("Could not Convert to int: " + methodParam);						
						}
						catch (NoSuchMethodException e)
						{
							System.out.println("Method with int param not found: " + e);						
						}	
						catch (Exception e)
						{
							System.out.println("General Exception occurred: " + e);						
						}										
					}
					else if (dataType.equals("double")) {
					
						try {
							System.out.println("Locating Method(Double)" + methodName);
							// Locate the method through introspection
							double numElements = Double.parseDouble(methodParam);
							if (numElements > 0.0)
							{
								Class paramsType[] = {double.class};
								Method method = this.getClass().getDeclaredMethod(methodName, paramsType);
								System.out.println("Before Execute Method(Double)" + methodName);
								Object result = method.invoke(this, numElements);
								System.out.println("After Execute Method(Double)" + methodName);
							}
							else
								System.out.println("Not Executing Double - 0.0"); 
							}
							catch (NumberFormatException e)
							{
								System.out.println("Could not Convert to double: " + methodParam);						
							}
							catch (NoSuchMethodException e)
							{
								System.out.println("Method with double param not found: " + e);						
							}	
							catch (Exception e)
							{
								System.out.println("General Exception: " + e);						
							}										
					}
					else if (dataType.equals("String")) {
						
						
						try {
							System.out.println("Locating Method(String)");
							
							Class paramsType[] = {String.class};
							Method method = this.getClass().getDeclaredMethod(methodName, paramsType );
							System.out.println("Method with String Param: " + methodName);
							
							System.out.println("Before Execute Method(String)" + methodName);
							Object result = method.invoke(this, methodParam);
							System.out.println("After Execute Method(String)" + methodName);
									
						}
						catch (NoSuchMethodException e)
						{
							System.out.println("Method with String param not found!");						
						}	
						catch (Exception e)
						{
							System.out.println("General Exception: " + e);						
						}	
						
					}
					else if (dataType.equals("")) {
						System.out.println("Data Type not found!!!");	
					}	
				}	
			}
			if (fired)
			{	
				System.out.println("Bacteriophages - Methods have fired.   Calling Bacteriophages Save method!");
			}
		}
	}

	

	/******************************************************************************************
	 * SET COLONY SIZE 
	 *
	 * This method will set the Colony size for the Bacteriophages.  
	 *****************************************************************************************/
	public void setColonySize(int size) {

		// Run through the argument list and executes the 
		// associated methods
		boolean fired = false;
		System.out.println("Bacteriophages-SetColony Size: " + size);
		
		// Generate the Bacteriophage		
		BioMightCellularBeanLocal bioMightBean;
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Generating the Bacteriophage Colony: " + componentID + "    " + parentID);
			InitialContext ctx = new InitialContext();
			//bioMightBean = (BioMightCellularBeanLocal) ctx.lookup("biomight.ejb.BioMightCellularBeanLocal");
			bioMightBean = (BioMightCellularBeanLocal) ctx.lookup("java:global/BioMightWeb/BioMightCellularBean!biomight.ejb.BioMightCellularBeanLocal");
	
			double currentPoints[][] = null;
		//	int success = bioMightBean.generateBacteriophages(size, "Bacteriophage:00001", "Bacteriophage", 
		//		"Bacteriophage", this.componentID, this.parentID, currentPoints);
			
			System.out.println("Created Bacteriophage Info using EJB");   	
		}catch (Exception e) { 
			System.out.println("Exception Creating Colony - Bacteriophage");
			throw new ServerException("Remote Exception BacteriophageEpithelium():", e); 	
		}
	}
	
}
