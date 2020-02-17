/*
 * Created on Sep 26, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.bacteria.rods.grampositive;
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
import biomight.view.BioMightOrientation;
import biomight.view.BioMightPosition;
import biomight.view.BioMightPropertyView;
import biomight.view.BioMightScale;
import biomight.view.BioMightTransform;

/*********************************************************************************
 * @author SurferJim
 *
 * Representation of BacilliAnthracis
 ********************************************************************************/

public class BacilliAnthracis extends BioMightBase {
private ArrayList bacilliAnthracis;

	
	/********************************************************************************************************************
	 *  BacilliAnthracis
	 * 
	 * This method will instantiate the BacilliAnthracis that are defined for the current model.  
	 * 
	 ********************************************************************************************************************/

	public BacilliAnthracis()
	{		
		int localVP= Constants.BIO_CHILD;
		int localLOD = Constants.VIEW_HAWKEYE;
		create(localVP, localLOD, Constants.CellsRef, null, null);
	}
	
	/********************************************************************************************************************
	 *  BacilliAnthracis
	 * 
	 * This method will instantiate the BacilliAnthracis that are defined for the current model.  
	 * 
	 ********************************************************************************************************************/

	public BacilliAnthracis(String parentID)
	{				
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, parentID, null, null);
	}
	
	public BacilliAnthracis(int localVP, int localLOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
	{		
		create(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);
	}
	
	
	/********************************************************************************************************************
	 * CREATE BacilliAnthracis
	 * 
	 * This method will instantiate the hips that are defined for the current model.  
	 * 
	 ********************************************************************************************************************/

	private void create(int localVP, int localLOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods) 
	{
		this.setImage("images/BacilliAnthracis.jpg");
		
		bacilliAnthracis = new ArrayList();
	
		// This is a collection, so set the parent of the children
		// to that of the aggregation object
		this.parentID=parentID;
		this.componentID = parentID;
		this.lod = localLOD;
		this.viewPerspective = localVP;
		
		BioMightScale bioScale = new BioMightScale("0.00, 0.00, 0.00");
		BioMightPosition  bioPos = new BioMightPosition("0.00, 0.00, 0.00");
		BioMightOrientation  bioOrient = new BioMightOrientation("0.00, 0.00, 1.00, 0.0");
		String bioTemplate="BacilliAnthracis.x3d";
		
		if (bioMightMethods != null){
			System.out.println("EXECUTING BacilliAnthracis Methods: " + bioMightMethods.size());
			executeMethods(bioMightMethods);
		}
		
		// Get the information from the database via the Enterprise Bean.  This will get
		// a collection of BacilliAnthracis
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Getting BacilliAnthracis Transform: " + componentID + "   " +  parentID);
			InitialContext ctx = new InitialContext();
			BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
			bioMightTransforms = bioMightBean.getComponents(Constants.BacillusAnthracisRef, parentID);   	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - BacilliAnthracis");
			throw new ServerException("Remote Exception getComponents():", e); 	
		}
		
		
		// Run through the collection of bacilliAnthracis and build them into the model
		ArrayList transforms = bioMightTransforms.getTransforms();
		System.out.println("Have BacilliAnthracis NumTransforms: " + transforms.size());
		
		// If we are culling the data set
		int numRetreive=transforms.size();
		//if (parentID.equals("Cells"))
		
		for (int i=0; i<transforms.size(); i++)
		{
			// Get the information for the bacillusAnthracis we are creating
			BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
			System.out.println("Creating BacillusAnthracis: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
			
			// Create an instance of a BacillusAnthracis for each tranform specified
			localVP = Constants.VIEW_INTERNAL;
			localLOD = Constants.MAG1X;
			
			BacillusAnthracis bacillusAnthracis = new BacillusAnthracis(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);		
			System.out.println("BacillusAnthracis Created!: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
			bacilliAnthracis.add(bacillusAnthracis);
			System.out.println("Added BacillusAnthracis to Collection!: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());

			String propDesc = Constants.BacilliAnthracisRef + "-GramPositive, RodShaped, Spores";
			initProperty(bioMightTransform.getName(), Constants.BacillusAnthracis, Constants.BacillusAnthracisRef, propDesc,  bioMightTransform.getId(), bioPos, bioScale, bioOrient, Constants.SINGLE_COMPONENT, bioTemplate, false);
		
			int numElements = 50;
			if (i == numElements)
				break;
		}

		// Set up methods that will be available to the bacilliAnthracis
		initMethods(bioMightMethods);
	}
	
	
	public void initMethods(ArrayList<BioMightMethodView> bioMightMethodsIn) {
			
		// If we are coming in normally the methods and properties will not
		// be populated.   When processing data they will and we need to use
		// those values
		if (bioMightMethodsIn.size() == 0) {
			System.out.println("New Set of BacilliAnthracisMethods: " + bioMightMethodsIn.size());
			BioMightMethodView method = new BioMightMethodView();
			method.setCanonicalName(Constants.BacilliAnthracis);
			method.setMethodName("setColonySize");
			method.setDisplayName("Colony Size:");
			method.setHtmlType("text");
			method.setDataType(Constants.BIO_INT);
			methods.add(method);
		}
		else
		{
			System.out.println("Using Existing BacilliAnthracisMethods: " + bioMightMethodsIn.size());
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
		
		// Assemble the BacilliAnthracis
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
		"title='BacilliAnthracis'\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		

		String body = ""; 


		// Grab the data from the collection that we just created.
		if (viewPerspective == Constants.VIEW_HAWKEYE)
		{
			System.out.println("Assembling X3D for BacilliAnthracis HawkEyeView - size: " + bacilliAnthracis.size());
			
			// Run through the collection of BacilliAnthracis and assemble the X3D for each
			for (int i=0; i<bacilliAnthracis.size(); i++)
			{
				// Get the information for the bacillusAnthracis
				//BacillusAnthracis bacillusAnthracis = (BacillusAnthracis) bacilliAnthracis.get(i);
				//System.out.println("Getting X3D for BacillusAnthracis: " + bacillusAnthracis.getComponentID());
				//body += bacillusAnthracis.getX3D(true);
			}		
			
			body="";
			
			
			ArrayList transforms = bioMightTransforms.getTransforms();
			for (int i=0; i<transforms.size(); i++)
			{
				// Get the information for the capsomer we are creating
				BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
				System.out.println("Getting X3D -HawkEye - for BacillusAnthracis: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());				

				//System.out.println("Getting X3D for BacillusAnthracisX: " + bioMightTransform.getTranslation().getXPos());
				//System.out.println("Getting X3D for BacillusAnthracisY: " + bioMightTransform.getTranslation().getYPos());
				//System.out.println("Getting X3D for BacillusAnthracisZ: " + bioMightTransform.getTranslation().getZPos());
				// Change the height and width based on the displacement.
				
				
				double rodOrient[] = {0.0,     0.0,     1.0,      1.57};
			
				// Get the base values from the database
				double xStartPos = bioMightTransform.getTranslation().getXPos();  
				double yStartPos = bioMightTransform.getTranslation().getYPos();
				double zStartPos = bioMightTransform.getTranslation().getZPos();
				
				// Represents the current position
				double xPos = xStartPos; 
				double yPos = yStartPos;
				double zPos = zStartPos;
				
				double height =  bioMightTransform.getHeight();
				double radius = bioMightTransform.getRadius();
				System.out.println("StartPoint (Center): " + xPos + "  " + yPos +  "  " +  zPos);
				
				int collectionSize = new Double(MathUtils.round(Math.random()*5, 0)).intValue();
				System.out.println("HawkEye Collection Size: " + collectionSize);
				
				for (int k=0; k<collectionSize; k++) {
					
					double xDisplace = Math.random()*3;
					double yDisplace = Math.random()*3;
					double zDisplace = Math.random()*3;
					
					//reset a new position and start a new strand
					xPos = xStartPos + xDisplace;
					yPos = yStartPos + yDisplace;
					zPos = zStartPos + zDisplace;
			
					
					// Run through the segments that make this string of cells
					int randoLength = new Double(MathUtils.round(Math.random()*10, 0)).intValue();
					for (int v=0; v<randoLength; v++) {
	
					
						// Set up the Angle for growth path
						double randomRotateAngle = Math.random();
						while (randomRotateAngle > .707) {
							randomRotateAngle = Math.random();
						}
						rodOrient[3] = MathUtils.round(randomRotateAngle, 3);
		
						// Pop out a sphere where the position is
						body += "<Transform DEF='TRANSFORM_STARTSPHERE'\n";
					
						body += "translation='" 
									+ xPos  + " " 
				 					+ yPos + " "
				 					+ zPos + "'\n";				
						
						body +=  "scale='" 	+ 1 + " "
						 				    + 1 + " "
						 				    + 1 + "'>\n" +
						 	"<Shape DEF='SHAPE_" + bioMightTransform.getId() + "' \n" +
						    " containerField='children'>\n" +
						    " <Appearance\n" +
						    "  containerField='appearance'>\n";
		
	
						body+= " <ImageTexture containerField='texture' " +
						    " url='../images/BacillusAnthracis.jpg'/>";
				
						    	
						body+= " <Material DEF='Rust'\n" +
						    "containerField='material'\n" +
						    "ambientIntensity='" 	+ bioMightTransform.getMaterial().getAmbientIntensity() + "'\n" +
						    "shininess='" 			+ bioMightTransform.getMaterial().getShininess() + "'\n" +
						    "transparency='" 		+ bioMightTransform.getMaterial().getTransparency() + "'\n" +
						    "diffuseColor='" + 
						 	    1 + " " + 
						 	    0 + " " +
						 	    0 + "'/>\n" +
						 	"</Appearance>\n" +
						 	"<Sphere DEF='StartSphere'\n" +
						 	"containerField='geometry'\n" +
						 	"radius='" + (bioMightTransform.getRadius()) +"'/>\n" +
						 	"</Shape>\n" +
						 	
							"\n<TouchSensor DEF='TSENSOR_" + bioMightTransform.getId() + "' \n" +
			                   " description='BacillusAnthracis'\n" +
				               " containerField='children'/> \n" +
			
						 "</Transform>\n";
	
						
	
						//*************************************************************
						// Create the Cylinder and displace it so that its begin point
						//  moves to natural centerpoint of the cylinder
						//*************************************************************
						
						// Here are the two rotation angles
						double rotationAngle = rodOrient[3];
				
						// Here is the radius
						double radiusSpike = height * 0.50;
						
						// Convert the degrees to radians
						//double radiansLatitudeSpike =  MathUtils.round(Math.toRadians(angleLatitude), 8);
						double radiansLongitudeSpike = rotationAngle;
						 
						System.out.println("Longitude Angle: " + MathUtils.round(Math.toDegrees(rotationAngle), 4));
						System.out.println("radiansLongitude: " + radiansLongitudeSpike);
						double calculatedPoint[][] =  BioGraphics.applyRotation(new double [][] {{0, radiusSpike, 0}}, -1, MathUtils.round(Math.toDegrees(rotationAngle), 4), new double [] {rodOrient[0], rodOrient[1], rodOrient[2]} );
						
						// Extract the computed values
						double xPosCalc = calculatedPoint[0][0]; 
						double yPosCalc = calculatedPoint[0][1];
						double zPosCalc = calculatedPoint[0][2]; 
	
						// The Constant Point based on the Sphere Equation
						System.out.println("Current StartPoint (Center): " + xPos + "  " + yPos +  "  " +  zPos);
						System.out.println("Calculated CenterPoint Translate : " + xPosCalc + "  " + yPosCalc +  "  " +  zPosCalc);
						double newPoints[] = BioGraphics.applyTranslation(new double [] {xPos, yPos, zPos}, new double [] {xPosCalc, yPosCalc, zPosCalc});
						System.out.println("New CenterPoint: " + newPoints[0] + "  " + newPoints[1] +  "  " +  newPoints[2]);
	
						// This is new Center Position for the Cylinder
						double xPosSpike = newPoints[0];
						double yPosSpike = newPoints[1];
						double zPosSpike = newPoints[2];
	
						// Set up the EndPoint/BeginPoint for the next Cylinder.   We should need to displace the distance twice
						// as the endpoint is twice the distance of what we are currently at.	    
						newPoints = BioGraphics.applyTranslation(new double [] {xPos, yPos, zPos}, new double [] {2*xPosCalc, 2*yPosCalc, 2*zPosCalc} );
						xPos = newPoints[0];
						yPos = newPoints[1];
						zPos = newPoints[2];
					    
					    System.out.println("X Y Z Updated: " + newPoints[0] + "  " + newPoints[1] +  "  " +  newPoints[2]);
						
					
						//**************************************************
						// Create the Cylinder to represent Cell Membrane
						//**************************************************
						body += "<Transform DEF='TRANSFORM_BACTBODY" + bioMightTransform.getId() + "' \n";
							
						// Let's compute 
					 	body += "translation='" 
							+ xPosSpike + " " 
		 					+ yPosSpike + " "
		 					+ zPosSpike + "'\n";										
	
						body +=  "rotation='" 
								+ rodOrient[0] + " "
								+ rodOrient[1] + " "
								+ rodOrient[2]  + " "
								+ rodOrient[3] + "'\n\n";
			
						 					
						body +=  "scale='" 	+ bioMightTransform.getScale().getXPos() + " "
						 				+ bioMightTransform.getScale().getYPos() + " "
						 				+ bioMightTransform.getScale().getZPos() + "'>\n" +
						 				
						 	"<Shape DEF='SHAPE_" + bioMightTransform.getId() + "' \n" +
						    " containerField='children'>\n" +
						    " <Appearance\n" +
						    "  containerField='appearance'>\n";
		
				
						body+= " <ImageTexture containerField='texture' " +
						    " url='../images/BacillusAnthracis.jpg'/>";
						
											    
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
						 	"<Cylinder DEF='BacillusAnthracisGeoSphere'\n" +
						 	"containerField='geometry'\n" +
						 	"radius='" + radius +" '\n" +
						 	"height='" + height +"'/>\n" +
						 	"</Shape>\n" +
						 	
							"\n<TouchSensor DEF='TSENSOR_" + bioMightTransform.getId() + "' \n" +
			                   " description='BacillusAnthracis'\n" +
				               " containerField='children'/> \n" +
			
						 "</Transform>\n";
										
						}

				}
			}

		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		else if (viewPerspective == Constants.VIEW_CROSS_SECTION)
		{
			System.out.println("Assembling X3D for BacilliAnthracis CROSS-SECTION - size: " + bacilliAnthracis.size());
			
			// Run through the collection of BacilliAnthracis and assemble the X3D for each
			for (int i=0; i<bacilliAnthracis.size(); i++)
			{
				// Get the information for the bacillusAnthracis
				//BacillusAnthracis bacillusAnthracis = (BacillusAnthracis) bacilliAnthracis.get(i);
				//System.out.println("Getting X3D for BacillusAnthracis: " + bacillusAnthracis.getComponentID());
				//body += bacillusAnthracis.getX3D(true);
			}		
			
			body="";
			
			
			ArrayList transforms = bioMightTransforms.getTransforms();
			for (int i=0; i<transforms.size(); i++)
			{
				// Get the information for the capsomer we are creating
				BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
				System.out.println("Getting X3D -CROSS-SECTION - for BacillusAnthracis: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());				

				//System.out.println("Getting X3D for BacillusAnthracisX: " + bioMightTransform.getTranslation().getXPos());
				//System.out.println("Getting X3D for BacillusAnthracisY: " + bioMightTransform.getTranslation().getYPos());
				//System.out.println("Getting X3D for BacillusAnthracisZ: " + bioMightTransform.getTranslation().getZPos());
				// Change the height and width based on the displacement.

				double rodOrient[][] = {
						{0.0,    0.0,   1.0,  1.57},
						{0.0,    0.0,   1.0,  1.57},
						{0.0,    0.0,   1.0,  1.57},
						{0.0,    0.0,   1.0,  -1.047},
				};
			
				
				double sphereOrient[][] = {
						{0, 90},
						{0, 90},
						{0, 90},
						{0, 60},
				};
			
				// Get the base values from the database
				double xPos = bioMightTransform.getTranslation().getXPos();  
				double yPos = bioMightTransform.getTranslation().getYPos();
				double zPos = bioMightTransform.getTranslation().getZPos();	
				double height =  bioMightTransform.getHeight();
				double radius = bioMightTransform.getRadius();
				
				for (int k=0; k<2; k++) {
						
		
					// Pop out a sphere where the position is
					
					body += "<Transform DEF='TRANSFORM_STARTSPHERE'\n";
				
					body += "translation='" 
								+ xPos  + " " 
			 					+ yPos + " "
			 					+ zPos + "'\n";				
					
					
					body +=  "scale='" 	+ 1 + " "
					 				    + 1 + " "
					 				    + 1 + "'>\n" +
					 	"<Shape DEF='SHAPE_" + bioMightTransform.getId() + "' \n" +
					    " containerField='children'>\n" +
					    " <Appearance\n" +
					    "  containerField='appearance'>\n";
	
				
					    	
					body+= " <Material DEF='Rust'\n" +
					    "containerField='material'\n" +
					    "ambientIntensity='" 	+ bioMightTransform.getMaterial().getAmbientIntensity() + "'\n" +
					    "shininess='" 			+ bioMightTransform.getMaterial().getShininess() + "'\n" +
					    "transparency='" 		+ bioMightTransform.getMaterial().getTransparency() + "'\n" +
					    "diffuseColor='" + 
					 	    1 + " " + 
					 	    0 + " " +
					 	    0 + "'/>\n" +
					 	"</Appearance>\n" +
					 	"<Sphere DEF='StartSphere'\n" +
					 	"containerField='geometry'\n" +
					 	"radius='" + (bioMightTransform.getRadius() *0.25) +"'/>\n" +
					 	"</Shape>\n" +
					 	
						"\n<TouchSensor DEF='TSENSOR_" + bioMightTransform.getId() + "' \n" +
		                   " description='BacillusAnthracis'\n" +
			               " containerField='children'/> \n" +
		
					 "</Transform>\n";

					

					//*************************************************************
					// Create the Cylinder and displace it so that its begin point
					//  moves to natural centerpoint of the cylinder
					//*************************************************************
					
					
					// Here are the two rotation angles
					double angleLatitude = sphereOrient[k][0];
					double angleLongitude = sphereOrient[k][1];
			
					// Here is the radius
					double radiusSpike = height * 0.50;
					
					// Convert the degrees to radians
					double radiansLatitudeSpike =  Math.toRadians(angleLatitude);
					double radiansLongitudeSpike =  Math.toRadians(angleLongitude);
					 
					System.out.println("Latitude Angle: " + angleLatitude + " Longitude Angle: " + angleLongitude);
					System.out.println("radiansLatitude: " + radiansLatitudeSpike + " radiansLongitude: " + radiansLongitudeSpike);
					
					double cosLatSpike = MathUtils.round(Math.cos(radiansLatitudeSpike), 8);
					double cosLongSpike = MathUtils.round(Math.cos(radiansLongitudeSpike), 8);
					double sinLongSpike = MathUtils.round(Math.sin(radiansLongitudeSpike), 8);
					double sinLatSpike = MathUtils.round(Math.sin(radiansLatitudeSpike), 8);
		
					System.out.println("Calcs Cosines - Long/Lat: " + cosLongSpike + "  " + cosLatSpike);
					System.out.println("Calcs Sines - Long/Lat: " + sinLongSpike+ "  " + sinLatSpike);
					System.out.println("Radius:" + radiusSpike);
								
					// Set the position as if positioning on a sphere.   There is a X, Y, and Z component
					// that determines where the point will lie.  We have to rotate two axi to get the
					// objects orientation into orientation with the world.
					double xPosCalc = MathUtils.round((radiusSpike * (cosLatSpike * sinLongSpike)), 8);  
					double yPosCalc = MathUtils.round((radiusSpike * cosLongSpike), 8);
					double zPosCalc = MathUtils.round((radiusSpike * (sinLatSpike * sinLongSpike)), 8); 

					// The Constant Point based on the Sphere Equation
					System.out.println("Current StartPoint (Center): " + xPos + "  " + yPos +  "  " +  zPos);
					
					System.out.println("Calculated CenterPoint Translate : " + xPosCalc + "  " + yPosCalc +  "  " +  zPosCalc);
					
					double newPoints[] = BioGraphics.applyTranslation(new double [] {xPos, yPos, zPos}, new double [] {xPosCalc, yPosCalc, zPosCalc});
					System.out.println("New CenterPoint: " + newPoints[0] + "  " + newPoints[1] +  "  " +  newPoints[2]);

					// This is new Center Position for the Cylinder
					double xPosSpike = newPoints[0];
					double yPosSpike = newPoints[1];
					double zPosSpike = newPoints[2];

					// Set up the EndPoint/BeginPoint for the next Cylinder.   We should need to displace the distance twice
					// as the endpoint is twice the distance of what we are currently at.	    
					newPoints = BioGraphics.applyTranslation(new double [] {xPos, yPos, zPos}, new double [] {2*xPosCalc, 2*yPosCalc, 2*zPosCalc} );
					xPos = newPoints[0];
					yPos = newPoints[1];
					zPos = newPoints[2];
				    
				    System.out.println("X Y Z Updated (EndPoint): " + newPoints[0] + "  " + newPoints[1] +  "  " +  newPoints[2]);
					
				
					//*************************************
					// Create the Cylinder
					//*************************************
					body += "<Transform DEF='TRANSFORM_BACTBODY" + bioMightTransform.getId() + "' \n";
						
					// Let's compute 
				 	body += "translation='" 
						+ xPosSpike + " " 
	 					+ yPosSpike + " "
	 					+ zPosSpike + "'\n";										

					body +=  "rotation='" 
							+ rodOrient[k][0] + " "
							+ rodOrient[k][1] + " "
							+ rodOrient[k][2]  + " "
							+ rodOrient[k][3] + "'>\n\n";
		
					 					
					body +=  "scale='" 	+ bioMightTransform.getScale().getXPos() + " "
					 				+ bioMightTransform.getScale().getYPos() + " "
					 				+ bioMightTransform.getScale().getZPos() + "'>\n" +
					 	"<Shape DEF='SHAPE_" + bioMightTransform.getId() + "' \n" +
					    " containerField='children'>\n" +
					    " <Appearance\n" +
					    "  containerField='appearance'>\n";
	
			
					body+= " <ImageTexture containerField='texture' " +
					    " url='../images/BacillusAnthracis.jpg'/>";
					
					
					    
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
					 	"<Cylinder DEF='BacillusAnthracisGeoSphere'\n" +
					 	"containerField='geometry'\n" +
					 	"radius='" + radius +" '\n" +
					 	"height='" + height +"'/>\n" +
					 	"</Shape>\n" +
					 	
						"\n<TouchSensor DEF='TSENSOR_" + bioMightTransform.getId() + "' \n" +
		                   " description='BacillusAnthracis'\n" +
			               " containerField='children'/> \n" +
		
					 "</Transform>\n";
									
					
					
										
					for (int l=0; l<0; l++) {
					
						body += "<Transform DEF='TRANSFORM_BACTCAP" + l + bioMightTransform.getId() + "' \n";
						
						if (l==0) {
							System.out.println("Getting X3D -InternalView - L IS 0: " + (bioMightTransform.getTranslation().getYPos() - bioMightTransform.getHeight()* 0.5) );				
	
							body += "translation='" 
								+ xPosSpike  + " " 
			 					+ yPosSpike + " "
			 					+ zPosSpike + "'\n";
						}
						else {
							System.out.println("Getting X3D -InternalView - L IS NOT 0: " + (bioMightTransform.getTranslation().getYPos() + bioMightTransform.getHeight()* 0.5) );				
	
							body += "translation='" 
									+ (xPos+height*radius*2)  + " " 
				 					+ yPos + " "
				 					+ zPos + "'\n";				
						}
						
						 					
						body +=  "scale='" 	+ bioMightTransform.getScale().getXPos() + " "
						 				+ bioMightTransform.getScale().getYPos() + " "
						 				+ bioMightTransform.getScale().getZPos() + "'>\n" +
						 	"<Shape DEF='SHAPE_" + bioMightTransform.getId() + "' \n" +
						    " containerField='children'>\n" +
						    " <Appearance\n" +
						    "  containerField='appearance'>\n";
		
				
						body+= " <ImageTexture containerField='texture' " +
						    " url='../images/BacillusAnthracis.jpg'/>";
						
						
						    
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
						 	"<Sphere DEF='BacillusAnthracisGeoSphere'\n" +
						 	"containerField='geometry'\n" +
						 	"radius='" + bioMightTransform.getRadius() +"'/>\n" +
						 	"</Shape>\n" +
						 	
							"\n<TouchSensor DEF='TSENSOR_" + bioMightTransform.getId() + "' \n" +
			                   " description='BacillusAnthracis'\n" +
				               " containerField='children'/> \n" +
			
						 "</Transform>\n";
					}
							

				}
			}

		}	
		// This is for when we are going to deal with the collection data separately.  Like
		// when we do not want to access the sub components.
		else if (viewPerspective == Constants.VIEW_INTERNAL)
		{	
			System.out.println("Assembling X3D for BacilliAnthracis InternalView - size: " + bacilliAnthracis.size());
			
			ArrayList transforms = bioMightTransforms.getTransforms();
			for (int i=0; i<transforms.size(); i++)
			{
				// Get the information for the capsomer we are creating
				BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
				System.out.println("Getting X3D -InternalView - for BacillusAnthracis: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());				

				//System.out.println("Getting X3D for BacillusAnthracisX: " + bioMightTransform.getTranslation().getXPos());
				//System.out.println("Getting X3D for BacillusAnthracisY: " + bioMightTransform.getTranslation().getYPos());
				//System.out.println("Getting X3D for BacillusAnthracisZ: " + bioMightTransform.getTranslation().getZPos());
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
				    " url='../images/BacillusAnthracis.jpg'/>";
				
				
				    
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
				 	"<Sphere DEF='BacillusAnthracisGeoSphere'\n" +
				 	"containerField='geometry'\n" +
				 	"radius='" + bioMightTransform.getRadius() +"'/>\n" +
				 	"</Shape>\n" +
				 	
					"\n<TouchSensor DEF='TSENSOR_" + bioMightTransform.getId() + "' \n" +
	                   " description='BacillusAnthracis'\n" +
		               " containerField='children'/> \n" +
	
				 "</Transform>\n";
								
			}
		}			

		
		
		//System.out.println("BacilliAnthracis X3D: " + body);		
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
		System.out.println("BacilliAnthracis-Executing Methods: " + bioMightMethods.size());
		for (int j=0; j<bioMightMethods.size(); j++){
			
			// Get the parameter from the list and if it is not
			// empty execute the associated method using it
			BioMightMethodView bioMightMethod = (BioMightMethodView) bioMightMethods.get(j);
			System.out.println("Have BioMightMethod for BacilliAnthracis: " + bioMightMethod.getMethodName());	
			String methodName = bioMightMethod.getMethodName();
			String canonicalName = bioMightMethod.getCanonicalName(); 
			String dataType = bioMightMethod.getDataType();
			String methodParam = bioMightMethod.getMethodParameter(); 
			if (methodParam == null)
				methodParam = "";
			
			// We only execute those methods that are targeted for the IRIS
			// If a parameter is specified then we fire the method, otherwise
			// we just jump over it
			if (canonicalName.equals(Constants.BacilliAnthracis)) {				
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
				System.out.println("BacilliAnthracis - Methods have fired.   Calling BacilliAnthracis Save method!");
			}
		}
	}

	

	/******************************************************************************************
	 * SET COLONY SIZE 
	 *
	 * This method will set the Colony size for the BacilliAnthracis.  
	 *****************************************************************************************/
	public void setColonySize(int size) {

		// Run through the argument list and executes the 
		// associated methods
		boolean fired = false;
		System.out.println("BacilliAnthracis-SetColony Size: " + size);
		
		// Generate the BacillusAnthracis		
		BioMightCellularBeanLocal bioMightBean;
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Generating the BacillusAnthracis Colony: " + componentID + "    " + parentID);
			InitialContext ctx = new InitialContext();
			//bioMightBean = (BioMightCellularBeanLocal) ctx.lookup("biomight.ejb.BioMightCellularBeanLocal");
			bioMightBean = (BioMightCellularBeanLocal) ctx.lookup("java:global/BioMightWeb/BioMightCellularBean!biomight.ejb.BioMightCellularBeanLocal");
	
			double currentPoints[][] = null;
		//	int success = bioMightBean.generateBacilliAnthracis(size, "BacillusAnthracis:00001", "BacillusAnthracis", 
		//		"BacillusAnthracis", this.componentID, this.parentID, currentPoints);
			
			System.out.println("Created BacillusAnthracis Info using EJB");   	
		}catch (Exception e) { 
			System.out.println("Exception Creating Colony - BacillusAnthracis");
			throw new ServerException("Remote Exception BacillusAnthracisEpithelium():", e); 	
		}
	}
	
}
