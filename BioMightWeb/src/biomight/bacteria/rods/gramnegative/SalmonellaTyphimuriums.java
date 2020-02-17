/*
 * Created on Sep 26, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.bacteria.rods.gramnegative;
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
import biomightweb.util.BioWebUtils;

/*********************************************************************************
 * @author SurferJim
 *
 * Representation of SalmonellaTyphimuriums
 ********************************************************************************/

public class SalmonellaTyphimuriums extends BioMightBase {
private ArrayList salmonellaTyphimuriums;

	
	/********************************************************************************************************************
	 *  SalmonellaTyphimuriums
	 * 
	 * This method will instantiate the SalmonellaTyphimuriums that are defined for the current model.  
	 * 
	 ********************************************************************************************************************/

	public SalmonellaTyphimuriums()
	{		
		int localVP= Constants.BIO_CHILD;
		int localLOD = Constants.VIEW_HAWKEYE;
		create(localVP, localLOD, Constants.SalmonellaTyphimuriumsRef, null, null);
	}
	
	/********************************************************************************************************************
	 *  SalmonellaTyphimuriums
	 * 
	 * This method will instantiate the SalmonellaTyphimuriums that are defined for the current model.  
	 * 
	 ********************************************************************************************************************/

	public SalmonellaTyphimuriums(String parentID)
	{				
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, parentID, null, null);
	}
	
	public SalmonellaTyphimuriums(int localVP, int localLOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
	{		
		create(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);
	}
	
	
	/********************************************************************************************************************
	 * CREATE SalmonellaTyphimuriums
	 * 
	 * This method will instantiate the SalmonellaTyphimuriums that are defined for the current model.  
	 * 
	 ********************************************************************************************************************/

	private void create(int localVP, int localLOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods) 
	{
		this.setImage("images/SalmonellaTyphimuriums.jpg");
		
		salmonellaTyphimuriums = new ArrayList();
	
		// This is a collection, so set the parent of the children
		// to that of the aggregation object
		this.parentID=parentID;
		this.componentID = parentID;
		this.lod = localLOD;
		this.viewPerspective = localVP;
		
		BioMightScale bioScale = new BioMightScale("0.00, 0.00, 0.00");
		BioMightPosition  bioPos = new BioMightPosition("0.00, 0.00, 0.00");
		BioMightOrientation  bioOrient = new BioMightOrientation("0.00, 0.00, 1.00, 0.0");
		String bioTemplate="SalmonellaTyphimuriums.x3d";
	
		if (bioMightMethods != null){
			System.out.println("EXECUTING SalmonellaTyphimuriums Methods: " + bioMightMethods.size());
			executeMethods(bioMightMethods);
		}
		
		// Get the information from the database via the Enterprise Bean.  This will get
		// a collection of SalmonellaTyphimuriums
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Getting SalmonellaTyphimuriums Transform: " + componentID + "   " +  parentID);
			InitialContext ctx = new InitialContext();
			BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
			bioMightTransforms = bioMightBean.getComponents(Constants.SalmonellaTyphimuriumRef, parentID);   	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - SalmonellaTyphimuriums");
			throw new ServerException("Remote Exception getComponents():", e); 	
		}
		
		
		// Run through the collection of salmonellaTyphimuriums and build them into the model
		ArrayList transforms = bioMightTransforms.getTransforms();
		System.out.println("Have SalmonellaTyphimuriums NumTransforms: " + transforms.size());
		
		// If we are culling the data set
		int numRetreive=transforms.size();
		//if (parentID.equals("Cells"))
		
		for (int i=0; i<transforms.size(); i++)
		{
			// Get the information for the salmonellaTyphimuriums we are creating
			BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
			System.out.println("Creating SalmonellaTyphimuriums: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
			
			// Create an instance of a SalmonellaTyphimuriumsfor each tranform specified
			localVP = Constants.VIEW_INTERNAL;
			localLOD = Constants.MAG1X;
			
			SalmonellaTyphimurium salmonellaTyphimurium = new SalmonellaTyphimurium(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);		
			System.out.println("SalmonellaTyphimurium Created!: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
			salmonellaTyphimuriums.add(salmonellaTyphimurium);
			System.out.println("Added salmonellaTyphimurium to Collection!: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());


			String propDesc = Constants.SalmonellaTyphimuriumsRef + "-GramNegative, Enteric Bacillus, motile, FaculativeAnaerobe";
			initProperty(bioMightTransform.getName(), Constants.SalmonellaTyphimuriums, Constants.SalmonellaTyphimuriumsRef, propDesc,  bioMightTransform.getId(), bioPos, bioScale, bioOrient, Constants.SINGLE_COMPONENT, bioTemplate, false);
	
			int numElements = 50;
			if (i == numElements)
				break;
		}

		// Set up methods that will be available to the salmonellaTyphimuriums
		initMethods(bioMightMethods);
	}
	
	
	public void initMethods(ArrayList<BioMightMethodView> bioMightMethodsIn) {
			
		// If we are coming in normally the methods and properties will not
		// be populated.   When processing data they will and we need to use
		// those values
		if (bioMightMethodsIn.size() == 0) {
			System.out.println("New Set of SalmonellaTyphimuriums Methods: " + bioMightMethodsIn.size());
			BioMightMethodView method = new BioMightMethodView();
			method.setCanonicalName(Constants.SalmonellaTyphimuriums);
			method.setMethodName("setColonySize");
			method.setDisplayName("Colony Size:");
			method.setHtmlType("text");
			method.setDataType(Constants.BIO_INT);
			methods.add(method);
		}
		else
		{
			System.out.println("Using Existing SalmonellaTyphimuriums Methods: " + bioMightMethodsIn.size());
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
		
		// Assemble the SalmonellaTyhpis
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
		"title='SalmonellaTyhpis'\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		

		String body = ""; 


		// Grab the data from the collection that we just created.
		if (viewPerspective == Constants.VIEW_HAWKEYE)
		{
			System.out.println("Assembling X3D for SalmonellaTyhpis HawkEyeView - size: " + salmonellaTyphimuriums.size());
			
			// Run through the collection of SalmonellaTyphimuriums and assemble the X3D for each
			for (int i=0; i<salmonellaTyphimuriums.size(); i++)
			{
				// Get the information for the salmonellaTyphimuriums
				//SalmonellaTyhpis salmonellaTyphimuriums = (SalmonellaTyhpis) salmonellaTyphimuriums.get(i);
				//System.out.println("Getting X3D for SalmonellaTyphimuriums: " + salmonellaTyphimuriums.getComponentID());
				//body += salmonellaTyphimuriums.getX3D(true);
			}		
			
			body="";
			
			
			ArrayList transforms = bioMightTransforms.getTransforms();
			for (int i=0; i<transforms.size(); i++)
			{
				// Get the information for the capsomer we are creating
				BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
				System.out.println("Getting X3D -InternalView - for SalmonellaTyhpis: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());				

				//System.out.println("Getting X3D for SalmonellaTyhpisX: " + bioMightTransform.getTranslation().getXPos());
				//System.out.println("Getting X3D for SalmonellaTyhpisY: " + bioMightTransform.getTranslation().getYPos());
				//System.out.println("Getting X3D for SalmonellaTyhpisZ: " + bioMightTransform.getTranslation().getZPos());
				// Change the height and width based on the displacement.
				
				int numLongitude = 12;
				int numLatitude = 12;
				double rotateLatitude = 360/numLatitude;
				double rotateLongitude = 360/numLongitude;
				double angleLatitude = rotateLatitude;
				double angleLongitude = rotateLongitude;
				double xOrient = 0.0;
				double yOrient = 1.0;
				double zOrient = 0.0;
					
				double spikeHeight =  0.0675;
				double spikeRadius = 0.00625;
				double halfSpike = MathUtils.round(spikeHeight/2, 8);
				
				
				double rodOrient[] = {0.0, 0.0, 1.0,  1.57};
					 
				
				double xPos = bioMightTransform.getTranslation().getXPos();  
				double yPos = bioMightTransform.getTranslation().getYPos();
				double zPos = bioMightTransform.getTranslation().getZPos();	
				double height =  bioMightTransform.getHeight();
				double radius = bioMightTransform.getRadius();
		
				String bioGroup = "FlagellaGroup";
				BioMightTransform baseTransform = bioMightTransform;
				
		
				for (int cells=0; cells<1; cells++)
				{
					
					//System.out.println("GenerateCylindricalComponents()  Num Longitude: " + numLongitude + "     NumLatitude: " + numLatitude);
					//System.out.println("GenerateCylindricalComponents()  rotateLongitude: " + rotateLongitude + "   rotateLatitude: " + rotateLatitude);
					
						
					// Pop out a sphere where the start position is
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
					    " url='../images/SalmonellaTyphimuriums.png'/>";
			
					    	
					body+= " <Material DEF='Rust'\n" +
					    "containerField='material'\n" +
					    "ambientIntensity='" 	+ bioMightTransform.getMaterial().getAmbientIntensity() + "'\n" +
					    "shininess='" 			+ bioMightTransform.getMaterial().getShininess() + "'\n" +
					   // "transparency='" 		+ bioMightTransform.getMaterial().getTransparency() + "'\n" +
					    "transparency='" 		+ 0.70 + "'\n" +
					    "diffuseColor='" + 
					 	    1 + " " + 
					 	    0 + " " +
					 	    0 + "'/>\n" +
					 	"</Appearance>\n" +
					 	"<Sphere DEF='StartSphere'\n" +
					 	"containerField='geometry'\n" +
					 	"radius='" + radius +"'/>\n" +
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
					 
					//System.out.println("Longitude Angle: " + MathUtils.round(Math.toDegrees(rotationAngle), 4));
					//System.out.println("radiansLongitude: " + radiansLongitudeSpike);
					double calculatedPoint[][] =  BioGraphics.applyRotation(new double [][] {{0, radiusSpike, 0}},  -1, MathUtils.round(Math.toDegrees(rotationAngle), 4), new double [] {rodOrient[0], rodOrient[1], rodOrient[2]} );
					
					// Extract the computed values
					double xPosCalc = calculatedPoint[0][0]; 
					double yPosCalc = calculatedPoint[0][1];
					double zPosCalc = calculatedPoint[0][2]; 

					// The Constant Point based on the Sphere Equation
					//System.out.println("Current StartPoint (Center): " + xPos + "  " + yPos +  "  " +  zPos);
					//System.out.println("Calculated CenterPoint Translate : " + xPosCalc + "  " + yPosCalc +  "  " +  zPosCalc);
					double newPoints[] = BioGraphics.applyTranslation(new double [] {xPos, yPos, zPos}, new double [] {xPosCalc, yPosCalc, zPosCalc});
					//System.out.println("New CenterPoint: " + newPoints[0] + "  " + newPoints[1] +  "  " +  newPoints[2]);

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
				    
				    //System.out.println("X Y Z Updated: " + newPoints[0] + "  " + newPoints[1] +  "  " +  newPoints[2]);
					
				
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
							+ rodOrient[3] + "'\n";
		
					 					
					body +=  "scale='" 	+ bioMightTransform.getScale().getXPos() + " "
					 				+ bioMightTransform.getScale().getYPos() + " "
					 				+ bioMightTransform.getScale().getZPos() + "'>\n\n" +
					 				
					 	"<Shape DEF='SHAPE_" + bioMightTransform.getId() + "' \n" +
					    " containerField='children'>\n" +
					    " <Appearance\n" +
					    "  containerField='appearance'>\n";
	
			
					body+= " <ImageTexture containerField='texture' " +
						    " url='../images/SalmonellaTyphimuriums.png'/>";
					
										    
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
		                   " description='Salmonella Typhimuriums Cell Membrane'\n" +
			               " containerField='children'/> \n" +
		
					 "</Transform>\n";
									

					//**********************************************************
					// Pop out a sphere where the position is
					//**********************************************************
					body += "<Transform DEF='TRANSFORM_STARTSPHERE'\n";
				
					body += "translation='" 
								+ xPos  + " " 
			 					+ yPos + " "
			 					+ zPos + "'\n";				
					
					body +=  "scale='" 	+ 1 + " "
					 				    + 1 + " "
					 				    + 1 + "'>\n\n" +
					 				    
					 	"<Shape DEF='SHAPE_" + bioMightTransform.getId() + "' \n" +
					    " containerField='children'>\n" +
					    " <Appearance\n" +
					    "  containerField='appearance'>\n";
	

					body+= " <ImageTexture containerField='texture' " +
						    " url='../images/SalmonellaTyphimuriums.png'/>";
			
					    	
					body+= " <Material DEF='Rust'\n" +
					    "containerField='material'\n" +
					    "ambientIntensity='" 	+ bioMightTransform.getMaterial().getAmbientIntensity() + "'\n" +
					    "shininess='" 			+ bioMightTransform.getMaterial().getShininess() + "'\n" +
					    // "transparency='" 		+ bioMightTransform.getMaterial().getTransparency() + "'\n" +
					    "transparency='" 		+ 0.70 + "'\n" +
					    "diffuseColor='" + 
					 	    1 + " " + 
					 	    0 + " " +
					 	    0 + "'/>\n" +
					 	"</Appearance>\n" +
					 	"<Sphere DEF='StartSphere'\n" +
					 	"containerField='geometry'\n" +
					 	"radius='" + radius +"'/>\n" +
					 	"</Shape>\n" +
					 	
						"\n<TouchSensor DEF='TSENSOR_" + bioMightTransform.getId() + "' \n" +
		                   " description='SalmonellaTyphimuriums Cell Membrane'\n" +
			               " containerField='children'/> \n" +
		
					 "</Transform>\n";

					//**************************************************************
					// CREATE SPIKES
					//**************************************************************
					angleLatitude = 90;
					angleLongitude = 360/numLongitude;
					int numSegments = 5;
					
					double segDisplacement = MathUtils.round(height/numSegments, 8);
					//System.out.println("Calculated Segment Displacement: " + segDisplacement); 
					for (int bodySegment=0; bodySegment<numSegments; bodySegment++)
					{
						double segDisplace = bodySegment * segDisplacement;
						//System.out.println("Segment Displace: " + bodySegment + "    "  + segDisplace); 
						
						// Run from top of the sphere to the bottom (Longitude)
						// We are using a consistent, constant, fixed latitude
						for (int longitude=0; longitude<numLongitude; longitude++) 
						{
							// System.out.println("GenerateCylindricalComponents - angleLongitude: " + angleLongitude + "    angleLatitude: " + angleLatitude);	
							// Set the position on the surface of the sphere based on angle of latitude
							// Set the position on the surface of the sphere based on the longitude
							
							// Set up a Group around the whole spike
							bioGroup = "FlagellaGroup" + "L" + longitude + "L" + bodySegment;
							body += "\n<Transform DEF='" + bioGroup + "'\n";
							body += "  translation='" + bioMightTransform.getTranslation().getPositionStr() +  "'>\n\n";
							
							baseTransform = bioMightTransform;
							//body += "\n\n</Transform>\n\n";
									
							
							//********************************************************
							// Create the first spike
							//********************************************************
							double radiansLatitude =  Math.toRadians(angleLatitude);
							double radiansLongitude =  Math.toRadians(angleLongitude);
							//System.out.println("radiansLatitude: " + radiansLatitude + " radiansLongitude: " + radiansLongitude);
							
							// Calculate sine and cosine
							double cosLat = MathUtils.round(Math.cos(radiansLatitude), 8);
							double cosLong = MathUtils.round(Math.cos(radiansLongitude), 8);
							double sinLong = MathUtils.round(Math.sin(radiansLongitude), 8);
							double sinLat = MathUtils.round(Math.sin(radiansLatitude), 8);
							
							// Set the position for the Spike.  Make it sit on the outside of the membrane
							// CHANGE to USE SPIKE POS
							xPos = MathUtils.round(((radius+halfSpike) * (cosLat * sinLong)), 8);  
							yPos = MathUtils.round(((radius+halfSpike) * cosLong), 8);
							zPos = MathUtils.round(((radius+halfSpike) * (sinLat * sinLong)), 8); 
							
							//System.out.println("XPOS: " + xPos + "=  Cos(Lat): " + cosLat + " Sin(Long): " + sinLong);
							// Add the displacement
							xPos -= segDisplace;  
							//System.out.println("XPOS: " + xPos + "=  Cos(Lat): " + cosLat + " Sin(Long): " + sinLong + "   Disp: " + segDisplace);
							
							//System.out.println("Cos(Lat): " + cosLat + " Sin(Lat): " + sinLat + "            Sin(Long): " + sinLong + "  cos(Long): " + cosLong);
							//System.out.println("XPOS: " + xPos + "=  Cos(Lat): " + cosLat + " Sin(Long): " + sinLong);
							//System.out.println("YPOS: " + yPos + "=  Sin(Lat): " + sinLat + " Cos(Long): " + cosLong);
							//System.out.println("ZPOS: " + zPos + "=  Cos(Long): " + cosLong);
							
							// Set the Orientation of the Cylinder on the surface of the Sphere
							// We create a perpindicular and then rotate out by the Longitudenal angle
							double perpindick = angleLatitude+90;
							double perpindickRadians = Math.toRadians(perpindick);
							//System.out.println("ORIENTing Cylinder about " + perpindick + "   radians: " + perpindickRadians);
							
							xOrient =  MathUtils.round(Math.cos(perpindickRadians), 8);
							yOrient =  0;  
							zOrient =  MathUtils.round(Math.sin(perpindickRadians), 8); ;// MathUtils.round(Math.sin(perpindick) * -1, 8);  //MathUtils.round(1 * Math.cos(angleLongitude), 8); 
							
							//System.out.println("X-AXIS: " + xOrient);
							//System.out.println("Y-AXIS: " + yOrient);
							//System.out.println("Z-AXIS: " + zOrient);
					
							double degrees = -radiansLongitude;	
							double spikeDegrees = -radiansLongitude;	
							
							//******************************************
							// Create The Base Cylindrical Spike
							///*****************************************
							body += "<Transform DEF='TRANSFORM_" + bioMightTransform.getId() + "' \n";
						 	body += "translation='" 
						 		+ xPos + " " 
			 					+ yPos + " "
			 					+ zPos + "'\n";					
						
							body +=  "rotation='" 
								+ xOrient + " "
								+ yOrient + " "
								+ zOrient  + " "
								+ degrees + "'\n";
							
							body +=  "scale='1 1 1'>\n\n" +
							
							 	"<Shape DEF='SHAPE_" + bioMightTransform.getId() + (longitude * bodySegment) + "' \n" +
							    " containerField='children'>\n" +
							    " <Appearance\n" +
							    "  containerField='appearance'>\n";
	
							body+= " <ImageTexture containerField='texture' " +
								    " url='../images/SalmonellaTyphimuriums.png'/>";
							
							body+= " <Material DEF='Rust'\n" +
							    "containerField='material'\n" +
							    "ambientIntensity='" 	+ bioMightTransform.getMaterial().getAmbientIntensity() + "'\n" +
							    "shininess='" 			+ bioMightTransform.getMaterial().getShininess() + "'\n" +
							    "transparency='" 		+ 0.25 + "'\n" +
							    "diffuseColor='0.0  1.0  0.0'/>\n" +
							 	"</Appearance>\n" +
							
							 	"<Cylinder DEF='GlycoProteinBaseSpike'\n" +
							 	"containerField='geometry'\n" +
							 	"radius='" + spikeRadius +"'\n" +
							 	"height='" + spikeHeight +"'/>\n" +
							 	"</Shape>\n" +
							 "</Transform>\n";
	
							
							//******************************************************************
							//  Extend the Spike based on some randomness 
							//  We need to establish the Base Vector that we are going to follow
							//  and then use a deviation aspect ratio to see how far we are allowed
							//  to amble off the main path.
							//^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
	
							// Calculate the position for the 2nd Spike.  A simple trick is to just use a larger radius 
							double xSpikePos = MathUtils.round(((radius+spikeHeight) * (cosLat * sinLong)), 8);  
							double ySpikePos = MathUtils.round(((radius+spikeHeight) * cosLong), 8);
							double zSpikePos = MathUtils.round(((radius+spikeHeight) * (sinLat * sinLong)), 8);
							
							//System.out.println("StartPoint (SphereCenter): " + xSpikePos + "  " + xSpikePos +  "  " +  xSpikePos);
							xSpikePos -= segDisplace;  
							//System.out.println("StartPoint (SphereCenter) with Displacement: " + xSpikePos + "  " + xSpikePos +  "  " +  xSpikePos);
						
							//System.out.println("Cos(Lat): " + cosLat + " Sin(Lat): " + sinLat + "            Sin(Long): " + sinLong + "  cos(Long): " + cosLong);
							//System.out.println("XPOS: " + xPos + "=  Cos(Lat): " + cosLat + " Sin(Long): " + sinLong);
							//System.out.println("YPOS: " + yPos + "=  Sin(Lat): " + sinLat + " Cos(Long): " + cosLong);
							//System.out.println("ZPOS: " + zPos + "=  Cos(Long): " + cosLong);
					
							// Run through the segments that make this string of cells
							int randoLength = new Double(MathUtils.round(Math.random()*15, 0)).intValue();
							for (int v=0; v<randoLength; v++) {
			
								// Set up the Angle for growth path
								double randomRotateAngle = Math.random();
								double randomRotateValue = Math.random();
								
								while (randomRotateAngle > .707) {
									randomRotateAngle = Math.random();
								}
								if (randomRotateValue > 0.517)
									spikeDegrees += randomRotateAngle;
								else
									spikeDegrees -= randomRotateAngle;
								
								//*****************************************************
								// Create little sphere connector where the position is
								//*****************************************************
								body += "<Transform DEF='TRANSFORM_STARTSPHERE'\n";
							
								body += "translation='" 
											+ xSpikePos  + " " 
						 					+ ySpikePos + " "
						 					+ zSpikePos + "'\n";				
								
								body +=  "scale='" 	+ 1 + " "
								 				    + 1 + " "
								 				    + 1 + "'>\n" +
								 				    
								 	"<Shape DEF='SHAPE_" + bioMightTransform.getId() + "' \n" +
								    " containerField='children'>\n" +
								    " <Appearance\n" +
								    "  containerField='appearance'>\n";
				
			
								body+= " <ImageTexture containerField='texture' " +
									    " url='../images/SalmonellaTyphimuriums.png'/>";
						
								    	
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
								 	// SPHERE ----
								 	"<Sphere DEF='StartSphere'\n" +
								 	"containerField='geometry'\n" +
								 	"radius='" + spikeRadius +"'/>\n" +
								 	"</Shape>\n" +
								 	
									"\n<TouchSensor DEF='TSENSOR_" + bioMightTransform.getId() + "' \n" +
					                   " description='BacillusAnthracis'\n" +
						               " containerField='children'/> \n" +
					
								 "</Transform>\n";
			
							
								//*************************************************************
								// Create the Cylinder and displace it so that its begin point
								//  moves to natural centerpoint of the cylinder
								//*************************************************************			
	
								// Convert the degrees to radians	
								calculatedPoint =  BioGraphics.applyRotation(new double [][] {{0, halfSpike, 0}},  -1, MathUtils.round(Math.toDegrees(spikeDegrees), 4), new double [] {xOrient, yOrient, zOrient} );
										
								// Extract the computed values
								xPosCalc = calculatedPoint[0][0]; 
								yPosCalc = calculatedPoint[0][1];
								zPosCalc = calculatedPoint[0][2]; 
			
								// The Constant Point based on the Sphere Equation
								//System.out.println("Spike StartPoint (Center): " + xSpikePos + "  " + xSpikePos +  "  " +  xSpikePos);
								//System.out.println("Calculated CenterPoint Translate : " + xPosCalc + "  " + yPosCalc +  "  " +  zPosCalc);
								newPoints = BioGraphics.applyTranslation(new double [] {xSpikePos, ySpikePos, zSpikePos}, new double [] {xPosCalc, yPosCalc, zPosCalc});
							
								double xCurSpikePos = newPoints[0];
								double yCurSpikePos = newPoints[1];
								double zCurSpikePos = newPoints[2];
								//System.out.println("New CenterPoint: " + xCurSpikePos + "  " + yCurSpikePos +  "  " +  zCurSpikePos);
								
								
								// Set up the EndPoint/BeginPoint for the next Cylinder.   We should need to displace the distance twice
								// as the endpoint is twice the distance of what we are currently at.	    
								newPoints = BioGraphics.applyTranslation(new double [] {xSpikePos, ySpikePos, zSpikePos}, new double [] {2*xPosCalc, 2*yPosCalc, 2*zPosCalc} );
								xSpikePos = newPoints[0];
								ySpikePos = newPoints[1];
								zSpikePos = newPoints[2];
							    //System.out.println("X Y Z for Spike Updated: " + xSpikePos + "  " + ySpikePos +  "  " +  zSpikePos);
								
							
								//**************************************************
								// Create the Cylinder to represent Cell Membrane
								//**************************************************
								body += "<Transform DEF='TRANSFORM_BACTBODY" + bioMightTransform.getId() + "' \n";
									
								// Let's compute 
							 	body += "translation='" 
									+ xCurSpikePos + " " 
				 					+ yCurSpikePos + " "
				 					+ zCurSpikePos + "'\n";										
			
								body +=  "rotation='" 
										+ xOrient+ " "
										+ yOrient + " "
										+ zOrient  + " "
										+ spikeDegrees + "'\n";
					
								 					
								body +=  "scale='" 	+ bioMightTransform.getScale().getXPos() + " "
								 				+ bioMightTransform.getScale().getYPos() + " "
								 				+ bioMightTransform.getScale().getZPos() + "'>\n\n" +
								 				
								 	"<Shape DEF='SHAPE_" + bioMightTransform.getId() + "' \n" +
								    " containerField='children'>\n" +
								    " <Appearance\n" +
								    "  containerField='appearance'>\n";
				
						
								body+= " <ImageTexture containerField='texture' " +
									    " url='../images/SalmonellaTyphimuriums.png'/>";
								
													    
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
								 	"radius='" + spikeRadius +" '\n" +
								 	"height='" + spikeHeight +"'/>\n" +
								 	"</Shape>\n" +
								 	
									"\n<TouchSensor DEF='TSENSOR_" + bioMightTransform.getId() + "' \n" +
					                   " description='BacillusAnthracis'\n" +
						               " containerField='children'/> \n" +
					
								 "</Transform>\n";					
							}
						
							
							// Set up a Group that assembles the flagellum
							body += "\n\n</Transform>\n\n";
							//System.out.println("\n\n CALLING ANIMATE: " + bioGroup);
							//body += animate(bioGroup, baseTransform);
							//System.out.println("\n\n COMPLETED ANIMATE: " + bioGroup);
				
							
							// Increase the angle on the Arc that goes top to bottom
							angleLongitude += rotateLongitude;
							//System.out.println("Incremented Longtitude Angle: " + angleLatitude);
						}
						
					}
						
						//**************************************************************
						// CREATE TAIL FLAGELLA, Randomly select an area that is right 
						// where the tail should be
						//**************************************************************
						double angleLatitudeTail = 0;	// {0, 20, -30)
						double angleLongitudeTail = 90;  // {75, 85, 95}
						//int numSegments = 5;
						
						double xTailPos = 0;  
						double yTailPos = 0;
						double zTailPos = 0;
				 
						
						// Create the Strands that comprise the tail
						// Pick several random points clustered at the top-center of the rod
						for (int tailSegment=0; tailSegment<2; tailSegment++)
						{
							if (tailSegment==1)
								angleLatitudeTail = 22;
							
							/****
							// Pick a point for the rod, This will be my longitudinal angle
							angleLongitudeTail = Math.random();
							while (angleLongitudeTail > .707) {
								angleLongitudeTail = Math.random();
							}
							
							// Pick a point for the rod, This will be my latitudinal angle
							angleLatitudeTail = Math.random();
							while (angleLatitudeTail > .707) {
								angleLatitudeTail = Math.random();
							}
							***/
							
							System.out.println("Tail Strand-" + tailSegment + "   Long: "  + angleLongitudeTail + "   Lat: " + angleLatitudeTail); 
									
							// Set up a Group around the whole spike
							bioGroup = "FlagellaGroup" + "L" + angleLongitudeTail + "L" + angleLatitudeTail;
							body += "\n<Transform DEF='" + bioGroup + "'\n";
							body += "  translation='" + bioMightTransform.getTranslation().getPositionStr() +  "'>\n\n";
							
							baseTransform = bioMightTransform;
							//body += "\n\n</Transform>\n\n";
									
							
								//********************************************************
								// Create the first spike
								//********************************************************
								double radiansLatitude =  Math.toRadians(angleLatitudeTail);
								double radiansLongitude =  Math.toRadians(angleLongitudeTail);
								//System.out.println("radiansLatitudeTail: " + radiansLatitude + " radiansLongitudeTail: " + radiansLongitude);
								
								// Calculate sine and cosine
								double cosLat = MathUtils.round(Math.cos(radiansLatitude), 8);
								double cosLong = MathUtils.round(Math.cos(radiansLongitude), 8);
								double sinLong = MathUtils.round(Math.sin(radiansLongitude), 8);
								double sinLat = MathUtils.round(Math.sin(radiansLatitude), 8);
								
								// Set the position for the Spike.  Make it sit on the outside of the membrane
								xTailPos = MathUtils.round(((radius+halfSpike) * (cosLat * sinLong)), 8);  
								yTailPos = MathUtils.round(((radius+halfSpike) * cosLong), 8);
								zTailPos = MathUtils.round(((radius+halfSpike) * (sinLat * sinLong)), 8); 
								
								//System.out.println("xTailPos: " + xPos + "=  Cos(Lat): " + cosLat + " Sin(Long): " + sinLong);
								//System.out.println("XPOS: " + xPos + "=  Cos(Lat): " + cosLat + " Sin(Long): " + sinLong);
								
								//System.out.println("Cos(Lat): " + cosLat + " Sin(Lat): " + sinLat + "            Sin(Long): " + sinLong + "  cos(Long): " + cosLong);
								//System.out.println("XPOS: " + xPos + "=  Cos(Lat): " + cosLat + " Sin(Long): " + sinLong);
								//System.out.println("YPOS: " + yPos + "=  Sin(Lat): " + sinLat + " Cos(Long): " + cosLong);
								//System.out.println("ZPOS: " + zPos + "=  Cos(Long): " + cosLong);
								
								// Set the Orientation of the Cylinder on the surface of the Sphere
								// We create a perpindicular and then rotate out by the Longitudenal angle
								double perpindick = angleLatitude+90;
								double perpindickRadians = Math.toRadians(perpindick);
								//System.out.println("ORIENTing Cylinder about " + perpindick + "   radians: " + perpindickRadians);
								
								xOrient =  MathUtils.round(Math.cos(perpindickRadians), 8);
								yOrient =  0;  
								zOrient =  MathUtils.round(Math.sin(perpindickRadians), 8); ;// MathUtils.round(Math.sin(perpindick) * -1, 8);  //MathUtils.round(1 * Math.cos(angleLongitude), 8); 
								
								//System.out.println("X-AXIS: " + xOrient);
								//System.out.println("Y-AXIS: " + yOrient);
								//System.out.println("Z-AXIS: " + zOrient);
						
								xOrient =  0; 
								yOrient =  0;  
								zOrient =  1;  
						
								
								double degrees = -radiansLongitude;	
								double spikeDegrees = -radiansLongitude;	
								
								spikeDegrees = -1.52;
								
								//******************************************
								// Create The Base Cylindrical Spike
								///*****************************************
								body += "<Transform DEF='TRANSFORM_" + bioMightTransform.getId() + "' \n";
							 	body += "translation='" 
							 		+ xTailPos + " " 
				 					+ yTailPos + " "
				 					+ zTailPos + "'\n";					
							
								body +=  "rotation='" 
									+ xOrient + " "
									+ yOrient + " "
									+ zOrient  + " "
									+ degrees + "'\n";
								
								
								body +=  "scale='1 1 1'>\n\n" +
								
								 	"<Shape DEF='SHAPE_" + bioMightTransform.getId() + (angleLongitudeTail * tailSegment) + "' \n" +
								    " containerField='children'>\n" +
								    " <Appearance\n" +
								    "  containerField='appearance'>\n";
		
								body+= " <ImageTexture containerField='texture' " +
									    " url='../images/SalmonellaTyphimuriums.png'/>";
								
								body+= " <Material DEF='Rust'\n" +
								    "containerField='material'\n" +
								    "ambientIntensity='" 	+ bioMightTransform.getMaterial().getAmbientIntensity() + "'\n" +
								    "shininess='" 			+ bioMightTransform.getMaterial().getShininess() + "'\n" +
								    "transparency='" 		+ 0.25 + "'\n" +
								    "diffuseColor='0.0  1.0  0.0'/>\n" +
								 	"</Appearance>\n" +
								
								 	"<Cylinder DEF='GlycoProteinBaseSpike'\n" +
								 	"containerField='geometry'\n" +
								 	"radius='" + spikeRadius +"'\n" +
								 	"height='" + spikeHeight +"'/>\n" +
								 	"</Shape>\n" +
								 "</Transform>\n";
		
								
								//******************************************************************
								//  Extend the Spike based on some randomness 
								//  We need to establish the Base Vector that we are going to follow
								//  and then use a deviation aspect ratio to see how far we are allowed
								//  to amble off the main path.
								//^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
		
								// Calculate the position for the 2nd Spike.  A simple trick is to just use a larger radius 
								double xTailSpikePos = MathUtils.round(((radius+spikeHeight) * (cosLat * sinLong)), 8);  
								double yTailSpikePos = MathUtils.round(((radius+spikeHeight) * cosLong), 8);
								double zTailSpikePos = MathUtils.round(((radius+spikeHeight) * (sinLat * sinLong)), 8);
								
								//System.out.println("StartPoint (TailSphereCenter): " + xTailSpikePos + "  " + yTailSpikePos +  "  " +  zTailSpikePos);
						
								//System.out.println("Cos(Lat): " + cosLat + " Sin(Lat): " + sinLat + "            Sin(Long): " + sinLong + "  cos(Long): " + cosLong);
								//System.out.println("XPOS: " + xPos + "=  Cos(Lat): " + cosLat + " Sin(Long): " + sinLong);
								//System.out.println("YPOS: " + yPos + "=  Sin(Lat): " + sinLat + " Cos(Long): " + cosLong);
								//System.out.println("ZPOS: " + zPos + "=  Cos(Long): " + cosLong);
						
								// Run through the segments that make this string of cells
								//int randoLength = new Double(MathUtils.round(Math.random()*15, 0)).intValue();
								for (int v=0; v<30; v++) {
				
									// Set up the Angle for Tail growth path
									double randomRotateAngle = Math.random();
									double randomRotateValue = Math.random();
									
									while (randomRotateAngle > 0.707)   {
										//System.out.println("Random#: " + randomRotateAngle);
										randomRotateAngle = Math.random();
									}
									if (randomRotateValue > 0.500)
										spikeDegrees += randomRotateAngle;
									else
										spikeDegrees -= randomRotateAngle;
									
									//*****************************************************
									// Create little sphere connector where the position is
									//*****************************************************
									body += "<Transform DEF='TRANSFORM_STARTSPHERE'\n";
								
									body += "translation='" 
												+ xTailSpikePos  + " " 
							 					+ yTailSpikePos + " "
							 					+ zTailSpikePos + "'\n";				
									
									body +=  "scale='" 	+ 1 + " "
									 				    + 1 + " "
									 				    + 1 + "'>\n" +
									 	"<Shape DEF='SHAPE_" + bioMightTransform.getId() + "' \n" +
									    " containerField='children'>\n" +
									    " <Appearance\n" +
									    "  containerField='appearance'>\n";
					
				
									body+= " <ImageTexture containerField='texture' " +
										    " url='../images/SalmonellaTyphimuriums.png'/>";
							
									    	
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
									 	// SPHERE ----
									 	"<Sphere DEF='StartSphere'\n" +
									 	"containerField='geometry'\n" +
									 	"radius='" + spikeRadius +"'/>\n" +
									 	"</Shape>\n" +
									 	
										"\n<TouchSensor DEF='TSENSOR_" + bioMightTransform.getId() + "' \n" +
						                   " description='BacillusAnthracis'\n" +
							               " containerField='children'/> \n" +
						
									 "</Transform>\n";
				
								
									//*************************************************************
									// Create the Cylinder and displace it so that its begin point
									//  moves to natural centerpoint of the cylinder
									//*************************************************************			
		
									// Convert the degrees to radians	
									calculatedPoint =  BioGraphics.applyRotation(new double [][] {{0, halfSpike, 0}},  -1, MathUtils.round(Math.toDegrees(spikeDegrees), 4), new double [] {xOrient, yOrient, zOrient} );
											
									// Extract the computed values
									xPosCalc = calculatedPoint[0][0]; 
									yPosCalc = calculatedPoint[0][1];
									zPosCalc = calculatedPoint[0][2]; 
				
									// The Constant Point based on the Sphere Equation
									//System.out.println("Spike StartPoint (Center): " + xTailSpikePos + "  " + xTailSpikePos +  "  " +  xTailSpikePos);
									//System.out.println("Calculated CenterPoint Translate : " + xPosCalc + "  " + yPosCalc +  "  " +  zPosCalc);
									newPoints = BioGraphics.applyTranslation(new double [] {xTailSpikePos, yTailSpikePos, zTailSpikePos}, new double [] {xPosCalc, yPosCalc, zPosCalc});
								
									double xCurSpikePos = newPoints[0];
									double yCurSpikePos = newPoints[1];
									double zCurSpikePos = newPoints[2];
									//System.out.println("New CenterPoint: " + xCurSpikePos + "  " + yCurSpikePos +  "  " +  zCurSpikePos);
									
									
									// Set up the EndPoint/BeginPoint for the next Cylinder.   We should need to displace the distance twice
									// as the endpoint is twice the distance of what we are currently at.	    
									newPoints = BioGraphics.applyTranslation(new double [] {xTailSpikePos, yTailSpikePos, zTailSpikePos}, new double [] {2*xPosCalc, 2*yPosCalc, 2*zPosCalc} );
									xTailSpikePos = newPoints[0];
									yTailSpikePos = newPoints[1];
									zTailSpikePos = newPoints[2];
								   // System.out.println("X Y Z for Spike Updated: " + xTailSpikePos + "  " + yTailSpikePos +  "  " +  zTailSpikePos);
									
								
									//**************************************************
									// Create the Cylinder to represent Cell Membrane
									//**************************************************
									body += "<Transform DEF='TRANSFORM_BACTBODY" + bioMightTransform.getId() + "' \n";
										
									// Let's compute 
								 	body += "translation='" 
										+ xCurSpikePos + " " 
					 					+ yCurSpikePos + " "
					 					+ zCurSpikePos + "'\n";										
				
									body +=  "rotation='" 
											+ xOrient+ " "
											+ yOrient + " "
											+ zOrient  + " "
											+ spikeDegrees + "'\n";
						
									 					
									body +=  "scale='" 	+ bioMightTransform.getScale().getXPos() + " "
									 				+ bioMightTransform.getScale().getYPos() + " "
									 				+ bioMightTransform.getScale().getZPos() + "'>\n\n" +
									 				
									 	"<Shape DEF='SHAPE_" + bioMightTransform.getId() + "' \n" +
									    " containerField='children'>\n" +
									    " <Appearance\n" +
									    "  containerField='appearance'>\n";
					
							
									body+= " <ImageTexture containerField='texture' " +
										    " url='../images/SalmonellaTyphimuriums.png'/>";
									
														    
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
									 	"radius='" + spikeRadius +" '\n" +
									 	"height='" + spikeHeight +"'/>\n" +
									 	"</Shape>\n" +
									 	
										"\n<TouchSensor DEF='TSENSOR_" + bioMightTransform.getId() + "' \n" +
						                   " description='BacillusAnthracis'\n" +
							               " containerField='children'/> \n" +
						
									 "</Transform>\n";					
								}
							
								
								// Set up a Group that assembles the flagellum
								body += "\n\n</Transform>\n\n";
								//System.out.println("\n\n CALLING ANIMATE: " + bioGroup);
								//body += animate(bioGroup, baseTransform);
								//System.out.println("\n\n COMPLETED ANIMATE: " + bioGroup);
							
						}
					
						
					
					
	
				}
				
				
			}

		}	
		// This is for when we are going to deal with the collection data separately.  Like
		// when we do not want to access the sub components.
		else if (viewPerspective == Constants.VIEW_INTERNAL)
		{	
			System.out.println("Assembling X3D for SalmonellaTyhpis InternalView - size: " + salmonellaTyphimuriums.size());
			
			ArrayList transforms = bioMightTransforms.getTransforms();
			for (int i=0; i<transforms.size(); i++)
			{
				// Get the information for the capsomer we are creating
				BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
				System.out.println("Getting X3D -InternalView - for SalmonellaTyhpis: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());				

				//System.out.println("Getting X3D for SalmonellaTyhpisX: " + bioMightTransform.getTranslation().getXPos());
				//System.out.println("Getting X3D for SalmonellaTyhpisY: " + bioMightTransform.getTranslation().getYPos());
				//System.out.println("Getting X3D for SalmonellaTyhpisZ: " + bioMightTransform.getTranslation().getZPos());
				// Change the height and width based on the displacement.

				
				int numLongitude = 12;
				int numLatitude = 12;
				double rotateLatitude = 360/numLatitude;
				double rotateLongitude = 360/numLongitude;
				double angleLatitude = rotateLatitude;
				double angleLongitude = rotateLongitude;
				double radius = 0.25;
				double xOrient = 0.0;
				double yOrient = 1.0;
				double zOrient = 0.0;
				
				String bioGroup = "FlagellaGroup";
				BioMightTransform baseTransform = null;
				
				//System.out.println("GenerateCylindricalComponents()  Num Longitude: " + numLongitude + "     NumLatitude: " + numLatitude);
				//System.out.println("GenerateCylindricalComponents()  rotateLongitude: " + rotateLongitude + "   rotateLatitude: " + rotateLatitude);
				
				// Run from top of the sphere to the bottom (Longitude)
				
				for (int longitude=0; longitude<numLongitude ;longitude++) 
				{
					// Run from left to right across the latitude separated points of the sphere
					angleLatitude = 0;
					//System.out.println("Completed Complete Rotation - Resetting Latitude");

					for (int latitude=0; latitude<numLatitude; latitude++)
					{					
						//System.out.println("GenerateCylindricalComponents - angleLongitude: " + angleLongitude + "    angleLatitude: " + angleLatitude);
						
						// Set the position on the surface of the sphere based on angle of latitude
						// Set the position on the surface of the sphere based on the longitude
						// As we build out, we need to keep the position and orientation of the spike prior
						
						// Set up a Group around the whole spike
						bioGroup = "FlagellaGroup" + "L" + longitude + "L" + latitude;
						body += "\n<Transform DEF='" + bioGroup + "'\n";
						body += "  translation='" + bioMightTransform.getTranslation().getPositionStr() + "'\n";
		
						body += "  scale='" + bioMightTransform.getScale().getScaleStr() + "'\n";
		
						body += "  rotation='" + bioMightTransform.getOrientation().getOrientationStr() + "'>\n\n";
						
						baseTransform = bioMightTransform;
						//body += "\n\n</Transform>\n\n";
					
			
						//********************************************************
						// Create the first spike
						//********************************************************
						double radiansLatitude =  Math.toRadians(angleLatitude);
						double radiansLongitude =  Math.toRadians(angleLongitude);
						//System.out.println("radiansLatitude: " + radiansLatitude + " radiansLongitude: " + radiansLongitude);
						
						double cosLat = MathUtils.round(Math.cos(radiansLatitude), 8);
						double cosLong = MathUtils.round(Math.cos(radiansLongitude), 8);
						double sinLong = MathUtils.round(Math.sin(radiansLongitude), 8);
						double sinLat = MathUtils.round(Math.sin(radiansLatitude), 8);
						
						// Set the position
						double xPos = MathUtils.round((radius * (cosLat * sinLong)), 8);  
						double yPos = MathUtils.round((radius * cosLong), 8);
						double zPos = MathUtils.round((radius * (sinLat * sinLong)), 8); 
				
						System.out.println("Cos(Lat): " + cosLat + " Sin(Lat): " + sinLat + "            Sin(Long): " + sinLong + "  cos(Long): " + cosLong);
						System.out.println("XPOS: " + xPos + "=  Cos(Lat): " + cosLat + " Sin(Long): " + sinLong);
						System.out.println("YPOS: " + yPos + "=  Sin(Lat): " + sinLat + " Cos(Long): " + cosLong);
						System.out.println("ZPOS: " + zPos + "=  Cos(Long): " + cosLong);
						
						// Set the Orientation of the Cylinder on the surface of the Sphere
						double perpindick = angleLatitude+90;
						double perpindickRadians = Math.toRadians(perpindick);
						//System.out.println("ORIENTing Cylinder about " + perpindick + "   radians: " + perpindickRadians);
						
						xOrient =  MathUtils.round(Math.cos(perpindickRadians), 8);
						yOrient =  0;  
						zOrient =  MathUtils.round(Math.sin(perpindickRadians), 8); ;// MathUtils.round(Math.sin(perpindick) * -1, 8);  //MathUtils.round(1 * Math.cos(angleLongitude), 8); 
						
						//System.out.println("X-AXIS: " + xOrient);
						//System.out.println("Y-AXIS: " + yOrient);
						//System.out.println("Z-AXIS: " + zOrient);
				
						double degrees = -radiansLongitude;	
						
						
						// Create Another Cylindrical Spike
				
						body += "<Transform DEF='TRANSFORM_" + bioMightTransform.getId() + "' \n";
					 	body += "translation='" 
					 		+ xPos + " " 
		 					+ yPos + " "
		 					+ zPos + "'\n";					
					
						body +=  "rotation='" 
								+ xOrient + " "
								+ yOrient + " "
								+ zOrient  + " "
								+ degrees + "'\n";
						
						body +=  "scale='1 1 1'>\n\n" +
						
						 	"<Shape DEF='SHAPE_" + bioMightTransform.getId() + (longitude * latitude) + "' \n" +
						    " containerField='children'>\n" +
						    " <Appearance\n" +
						    "  containerField='appearance'>\n";

						body+= " <Material DEF='Rust'\n" +
						    "containerField='material'\n" +
						    "ambientIntensity='" 	+ bioMightTransform.getMaterial().getAmbientIntensity() + "'\n" +
						    "shininess='" 			+ bioMightTransform.getMaterial().getShininess() + "'\n" +
						    "transparency='" 		+ 0.25 + "'\n" +
						    "diffuseColor='0.0  1.0  0.0'/>\n" +
						 	"</Appearance>\n" +
						
						 	"<Cylinder DEF='GlycoProteinBaseSpike'\n" +
						 	"containerField='geometry'\n" +
						 	"radius='" + 0.00625	 +"'\n" +
						 	"height='" + 0.0125 +"'/>\n" +
						 	"</Shape>\n" +
						 "</Transform>\n";

						
						double xCurPos = xPos;  
						double yCurPos = yPos;
						double zCurPos = zPos; 

						double xCurOrient =  xOrient;
						double yCurOrient =  yOrient;  
						double zCurOrient =  zOrient; 
						
						
						int maxSpikes = 2;
						for (int currentSpike=0; currentSpike<maxSpikes; currentSpike++)
						{
							 radius+=0.750;
							 radiansLatitude =  Math.toRadians(angleLatitude);
							 radiansLongitude =  Math.toRadians(angleLongitude);
							//System.out.println("radiansLatitude: " + radiansLatitude + " radiansLongitude: " + radiansLongitude);
							
							 cosLat = MathUtils.round(Math.cos(radiansLatitude), 8);
							 cosLong = MathUtils.round(Math.cos(radiansLongitude), 8);
							 sinLong = MathUtils.round(Math.sin(radiansLongitude), 8);
							 sinLat = MathUtils.round(Math.sin(radiansLatitude), 8);
							
							// Set the position
							xPos = MathUtils.round((radius * (cosLat * sinLong)), 8);  
							yPos = MathUtils.round((radius * cosLong), 8);
							zPos = MathUtils.round((radius * (sinLat * sinLong)), 8); 
	
							// Save the current postion
							xCurPos = xPos;
							yCurPos = yPos;
							zCurPos = zPos; 
							
							System.out.println("Cos(Lat): " + cosLat + " Sin(Lat): " + sinLat + "            Sin(Long): " + sinLong + "  cos(Long): " + cosLong);
							System.out.println("XPOS: " + xPos + "=  Cos(Lat): " + cosLat + " Sin(Long): " + sinLong);
							System.out.println("YPOS: " + yPos + "=  Sin(Lat): " + sinLat + " Cos(Long): " + cosLong);
							System.out.println("ZPOS: " + zPos + "=  Cos(Long): " + cosLong);
							
							// Set the Orientation of the Cylinder on the surface of the Sphere
							perpindick = angleLatitude+90;
							perpindickRadians = Math.toRadians(perpindick);
							//System.out.println("ORIENTing Cylinder about " + perpindick + "   radians: " + perpindickRadians);
							
							xOrient =  MathUtils.round(Math.cos(perpindickRadians), 8);
							yOrient =  0;  
							zOrient =  MathUtils.round(Math.sin(perpindickRadians), 8); ;// MathUtils.round(Math.sin(perpindick) * -1, 8);  //MathUtils.round(1 * Math.cos(angleLongitude), 8); 
					
							// Save the current orientation
							xCurOrient = xOrient;
							yCurOrient = yOrient;
							zCurOrient = zOrient;
							
							//System.out.println("X-AXIS: " + xOrient);
							//System.out.println("Y-AXIS: " + yOrient);
							//System.out.println("Z-AXIS: " + zOrient);
					
							degrees = -radiansLongitude;	
							
							
							// Create Another Cylindrical Spike
					
							body += "<Transform DEF='TRANSFORM_" + bioMightTransform.getId() + "' \n";
						 	body += "translation='" 
						 		+ xPos + " " 
			 					+ yPos + " "
			 					+ zPos + "'\n";					
						
							body +=  "rotation='" 
									+ xOrient + " "
									+ yOrient + " "
									+ zOrient  + " "
									+ degrees + "'\n";
							
							body +=  "scale='1 1 1'>\n\n" +
							
							 	"<Shape DEF='SHAPE_" + bioMightTransform.getId() + (longitude * latitude) + "' \n" +
							    " containerField='children'>\n" +
							    " <Appearance\n" +
							    "  containerField='appearance'>\n";
	
							body+= " <Material DEF='Rust'\n" +
							    "containerField='material'\n" +
							    "ambientIntensity='" 	+ bioMightTransform.getMaterial().getAmbientIntensity() + "'\n" +
							    "shininess='" 			+ bioMightTransform.getMaterial().getShininess() + "'\n" +
							    "transparency='" 		+ 0.25 + "'\n" +
							    "diffuseColor='0.0  1.0  0.0'/>\n" +
							 	"</Appearance>\n" +
							
							 	"<Cylinder DEF='GlycoProteinBaseSpike'\n" +
							 	"containerField='geometry'\n" +
							 	"radius='" + 0.00625	 +"'\n" +
							 	"height='" + 0.0125 +"'/>\n" +
							 	"</Shape>\n" +
							 "</Transform>\n";
							
							
							// Set up a Group that assembles the flagellum
							body += "\n\n</Transform>\n\n";
							System.out.println("\n\n CALLING ANIMATE: " + bioGroup);
							//body += animate(bioGroup, baseTransform);
							System.out.println("\n\n COMPLETED ANIMATE: " + bioGroup);
						}
						
						
						
			    		// Increase the angle on the arc that goes from left to right
			    		angleLatitude += rotateLatitude;
			    		//System.out.println("Incremented Latitude Angle: " + angleLatitude);
					}
					
					// Increase the angle on the Arc that goes top to bottom
					angleLongitude += rotateLongitude;
					//System.out.println("Incremented Longtitude Angle: " + angleLatitude);
				}
			
				
				
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
					    " url='../images/SalmonellaTyphimuriums.png'/>";
				
				
				    
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
				 	"<Sphere DEF='InfluenzaAVirusGeoSphere'\n" +
				 	"containerField='geometry'\n" +
				 	"radius='" + bioMightTransform.getRadius() +"'/>\n" +
				 	"</Shape>\n" +
				 	
					"\n<TouchSensor DEF='TSENSOR_" + bioMightTransform.getId() + "' \n" +
	                   " description='InfluenzaAVirus'\n" +
		               " containerField='children'/> \n" +
	
				 "</Transform>\n";
				
				
								
			}
		}			

		
		
		//System.out.println("SalmonellaTyhpis X3D: " + body);		
		String footer = "</Scene>" + "</X3D>\n";
		
		if (snipet)
			return body;			
		else	
			return header + body + footer;
	}


	


	/******************************************************************************************
	 * ANIMATE 
	 *
	 * This method will animate  the component.  The input comes in through the methods
	 * that are presented on the view.  
	 *****************************************************************************************/
	
	public String animate(String bioGroup, BioMightTransform baseTransform) {

		System.out.println("In Animate() Method");
		
		BioMightPosition bioMightPosition= baseTransform.getTranslation();
		System.out.println("Have Position");

		BioMightScale bioMightScale= baseTransform.getScale();		
		System.out.println("Have Scale");

		BioMightOrientation bioMightOrientationStart =  new BioMightOrientation("0.0, 1.0, 0.0, 0.0");
		BioMightOrientation bioMightOrientationEnd = new BioMightOrientation("0.0, 1.0, 0.0, 0.10");
		

		System.out.println("Performed Animate Initialization");
		
		String body = "";
		

		// If we are kicking off via a TouchSensor,add it into ths scene
		// String bioTouchSensor = "BioTouchSensor"+ numElem;
		boolean bStartByTouch = false;
		if (bStartByTouch) {
			// body +=
			// "<TouchSensor DEF='" + bioTouchSensor + "'\n" +
			// " description='Palette Touch Sensor1'\n" +
			// " containerField='children'/> \n" ;
		}
		
		
		int startTime = 0;
		int endTime = 1;
		int speed = Constants.SLOW;

		// Default it
		int duration = endTime - startTime;

		String bioTimer = bioGroup + "_Timer";
		body += "\n<TimeSensor DEF='" + bioTimer + "'\n"
				+ " containerField='children'\n "
				+ " cycleInterval='" + 0.6 + "'\n "
				+ " loop='true' \n"
				+ " startTime='0.0'/> \n\n";


		//System.out.println("\n\n SETup HEADER");
		
		// Setup a Script that will set the TimeStart for each
		// of
		// the animation events.
		String bioScript = bioGroup + "_flagellaScript";
		body += "<Script DEF='" + bioScript + "'>\n";

		String bioScriptStartTime = bioGroup + "_flagellaScriptStartTime";
		body += "<field name='flagellaScriptStartTime"
				+ "'  type='SFTime' accessType='outputOnly'/>\n";


		//System.out.println("\n\n Setup START");
		
		String bioScriptEndTime = bioGroup + "_flagellaScriptEndTime";
		body += "<field name='flagellaScriptEndTime "
				+ "'  type='SFTime' accessType='outputOnly'/>\n";

		String bioScriptTimeVar = bioGroup + "_flagellaScriptTimeVar";
		//body += "\n<![CDATA[\n" + "ecmascript:\n"
		//		+ "function initialize () {\n" + "var "
		//		+ bioScriptTimeVar
		//		+ "= new Date().getTime() + " + startTime
		//		+ ";\n" + bioScriptStartTime + " = "
		//		+ bioScriptTimeVar + ";	\n" + "}\n" + "]]>\n"
		body += "</Script>\n\n";


		System.out.println("\n\n SETup GROup");
		
		String bioAnimation = bioGroup + "_flagellaAnimation";

		// ***************************************************************
		// Setup the Position Interpolator to account for
		// movement
		// ****************************************************************
		body += "<PositionInterpolator DEF='" + bioAnimation
				+ "'\n";

		// Determine the key and key values based upon
		// the start and end position and the duration of time
		String keys = BioGraphics.getVectorKeys(speed, 10);
		String keyVals = BioGraphics.getPositionKeyVals(speed,
				baseTransform.getTranslation(),
				baseTransform.getTranslation(), 10);
		body += keys + keyVals + "/>\n\n";

		// Script sends start and events through this route
		// statement
		body += "<ROUTE fromNode='" + bioScript
				+ "' fromField='" + bioScriptStartTime
				+ "' toNode='" + bioTimer
				+ "' toField='startTime'/>\n\n"
				+ "<ROUTE fromNode='" + bioTimer
				+ "' fromField='fraction_changed' toNode='"
				+ bioAnimation
				+ "' toField='set_fraction'/>\n\n"
				+ "<ROUTE fromNode='" + bioAnimation
				+ "' fromField='value_changed' toNode='"
				+ bioGroup
				+ "' toField='set_translation'/>\n\n";

		// *********************************************************
		// Setup the Orientation Interpolator to account for
		// rotaton
		// **********************************************************
		bioAnimation = bioGroup + "_rotBioAnimation";
		body += "<OrientationInterpolator DEF='" + bioAnimation
				+ "'\n";

		// Determine the key and key values based upon
		// the start and end position and the duration of time
		keys = BioGraphics.getVectorKeys(speed, 10);
		keyVals = BioGraphics.getRotationKeyVals(speed,
				bioMightOrientationStart,
				bioMightOrientationEnd, 10);
		body += keys + keyVals + "/>\n\n";

		// Script sends start and events through this route
		// statement
		body +=
		// "<ROUTE fromNode='" + bioScript +
		// "' fromField='"+bioScriptStartTime+"' toNode='"+
		// bioTimer +"' toField='startTime'/>\n\n" +
		"<ROUTE fromNode='" + bioTimer
				+ "' fromField='fraction_changed' toNode='"
				+ bioAnimation
				+ "' toField='set_fraction'/>\n\n"
				+ "<ROUTE fromNode='" + bioAnimation
				+ "' fromField='value_changed' toNode='"
				+ bioGroup + "' toField='set_rotation'/>\n\n";

		// *********************************************************
		// Setup the Scale Interpolator to account for rotaton
		// **********************************************************
		bioAnimation = bioGroup + "_scaleBioAnimation";

		body += "<PositionInterpolator DEF='" + bioAnimation
				+ "'\n";

		// Determine the key and key values based upon
		// the start and end position and the duration of time
		keys = BioGraphics.getVectorKeys(speed, 10);

		keyVals = BioGraphics.getScalarKeyVals(speed,
				baseTransform.getScale(),
				baseTransform.getScale(), 10);
		body += keys + keyVals + "/>\n\n";

		// Script sends start and events through this route
		// statement
		body +=
		// "<ROUTE fromNode='" + bioScript +
		// "' fromField='"+bioScriptStartTime+"' toNode='"+
		// bioTimer +"' toField='startTime'/>\n\n" +
		"<ROUTE fromNode='" + bioTimer
				+ "' fromField='fraction_changed' toNode='"
				+ bioAnimation
				+ "' toField='set_fraction'/>\n\n"
				+ "<ROUTE fromNode='" + bioAnimation
				+ "' fromField='value_changed' toNode='"
				+ bioGroup + "' toField='set_scale'/>\n\n";
				


				if (bStartByTouch) {
					// body+=
					// "<ROUTE fromNode='"+ bioTouchSensor
					// +"' fromField='touchTime' toNode='"+ bioTimer
					// +"' toField='startTime'/>\n\n" ;
				}


		//System.out.println("\n\n In Gonnoreah Bacteria, BODY: " + body);
		return (body);
	}


	/******************************************************************************************
	 * EXECUTE METHODS 
	 *
	 ******************************************************************************************/
	public void executeMethods(ArrayList<BioMightMethodView> bioMightMethods) {

		// Run through the argument list and executes the 
		// associated methods
		boolean fired = false;
		//System.out.println("SalmonellaTyphimuriums-Executing Methods: " + bioMightMethods.size());
		for (int j=0; j<bioMightMethods.size(); j++){
			
			// Get the parameter from the list and if it is not
			// empty execute the associated method using it
			BioMightMethodView bioMightMethod = (BioMightMethodView) bioMightMethods.get(j);
			System.out.println("Have BioMightMethod for SalmonellaTyphimuriums: " + bioMightMethod.getMethodName());	
			String methodName = bioMightMethod.getMethodName();
			String canonicalName = bioMightMethod.getCanonicalName(); 
			String dataType = bioMightMethod.getDataType();
			String methodParam = bioMightMethod.getMethodParameter(); 
			if (methodParam == null)
				methodParam = "";
			
			// We only execute those methods that are targeted for the IRIS
			// If a parameter is specified then we fire the method, otherwise
			// we just jump over it
			if (canonicalName.equals(Constants.SalmonellaTyphimuriums)) {				
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
				System.out.println("SalmonellaTyphimuriums - Methods have fired.   Calling SalmonellaTyphimuriums Save method!");
			}
		}
	}

	

	/******************************************************************************************
	 * SET COLONY SIZE 
	 *
	 * This method will set the Colony size for the SalmonellaTyphimuriums.  
	 *****************************************************************************************/
	public void setColonySize(int size) {

		// Run through the argument list and executes the 
		// associated methods
		boolean fired = false;
		System.out.println("SalmonellaTyphimuriums-SetColony Size: " + size);
		
		// Generate the SalmonellaTyphimuriums		
		BioMightCellularBeanLocal bioMightBean;
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Generating the SalmonellaTyphimuriums Colony: " + componentID + "    " + parentID);
			InitialContext ctx = new InitialContext();
			//bioMightBean = (BioMightCellularBeanLocal) ctx.lookup("biomight.ejb.BioMightCellularBeanLocal");
			bioMightBean = (BioMightCellularBeanLocal) ctx.lookup("java:global/BioMightWeb/BioMightCellularBean!biomight.ejb.BioMightCellularBeanLocal");
	
			double currentPoints[][] = null;
		//	int success = bioMightBean.generateSalmonellaTyphimuriums(size, "SalmonellaTyphimuriums:00001", "SalmonellaTyphimuriums", 
		//		"SalmonellaTyphimuriums", this.componentID, this.parentID, currentPoints);
			
			System.out.println("Created SalmonellaTyphimuriums Info using EJB");   	
		}catch (Exception e) { 
			System.out.println("Exception Creating Colony - SalmonellaTyphimuriums");
			throw new ServerException("Remote Exception SalmonellaTyphimuriums Epithelium():", e); 	
		}
	}
	
}
