package biomightweb.util;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

import org.apache.commons.lang.StringUtils;
import org.apache.openejb.math.util.MathUtils;

import biomight.Constants;
import biomight.ejb.DBUtils;
import biomight.exceptions.DataException;
import biomight.exceptions.DataSecurityException;
import biomight.util.BioGraphics;
import biomight.util.BioVector;
import biomight.view.BioMightAppendage;
import biomight.view.BioMightInstructSet;
import biomight.view.BioMightInstruction;
import biomight.view.BioMightOrientation;
import biomight.view.BioMightPosition;
import biomight.view.BioMightPropertyView;
import biomight.view.BioMightScale;
import biomight.view.BioMightTransform;
import biomightweb.view.BioMightRange;

public class BioWebX3DUtils {

	
	// True is the default
	public static String addElectrons(BioMightTransform bioMightTransform, ArrayList ringData)
	{
	
		String body = "";
		
		// Set up the positions for the 1st ring Electrons
		// 2N*N electrons in each shell
		double electronSize = 0.5;
		double[][]offSets = null;
		int nMaxRings = ringData.size();
		int numElectrons = 0;
		double ringSize = 0.0;
		int transformCount = 0;
		
		System.out.println("There are : " + nMaxRings + " Orbital Sphere's");
		
		for (int eRing=0; eRing<nMaxRings; eRing++)
		{
			
			offSets = (double[][]) ringData.get(eRing);			
			System.out.println("There are : " + offSets.length + " Electrons in ring: " + eRing);
			
			// Each ring expands around the Center
			ringSize = bioMightTransform.getRadius() +  ((electronSize) * (eRing+1));
					
			for (int k=0; k<offSets.length; k++)
			{
				
				
				body += "<Transform DEF='TRANSFORM_" + bioMightTransform.getId() + "_" + transformCount + "' \n";
				transformCount++;
				
		 		body += "translation='" 
		 			+ (bioMightTransform.getTranslation().getXPos()  + offSets[k][0]) + " " 
						+ (bioMightTransform.getTranslation().getYPos()  + offSets[k][1]) + " "
						+ (bioMightTransform.getTranslation().getZPos()  + offSets[k][2]) + "'\n";					
		
	
				body +=  "scale='" 	+ bioMightTransform.getScale().getXPos() + " "
				 				+ bioMightTransform.getScale().getYPos() + " "
				 				+ bioMightTransform.getScale().getZPos() + "'>\n" +
				 	"<Shape DEF='SHAPE_" + bioMightTransform.getId() + "' \n" +
				    " containerField='children'>\n" +
				    " <Appearance\n" +
				    "  containerField='appearance'>\n";
	
		
			
				body+= " <ImageTexture containerField='texture' " +
				    " url='../images/Electron.jpg'/>";
				
				
				    
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
				 	"<Sphere DEF='FlourineGeoSphere'\n" +
				 	"containerField='geometry'\n" +
				 	"radius='" + electronSize +"'/>\n" +
				 	"</Shape>\n" +
				 	
					"\n<TouchSensor DEF='TSENSOR_" + bioMightTransform.getId() + "' \n" +
	                   " description='" + bioMightTransform.getComponentName() + " Electron '\n" +
		               " containerField='children'/> \n" +
	
				 "</Transform>\n";
				
				
				String bioGroup = bioMightTransform.getName() + "_" + k;
				//body += BioWebX3DUtils.animateElectrons(bioGroup, bioMightTransform, transformCount);
		
			}
		}
		return (body);	
	}
	
	
	// True is the default
	public static String addCocci(BioMightTransform bioMightTransform, ArrayList ringData)
	{
	
		String body = "";
		

		double[][]offSets = null;
		int nMaxRings = ringData.size();
		int numElectrons = 0;
		double ringSize = 0.0;
		
		System.out.println("There are : " + nMaxRings + " Orbital Sphere's");
		
		for (int eRing=0; eRing<nMaxRings; eRing++)
		{
			
			offSets = (double[][]) ringData.get(eRing);			
			System.out.println("There are : " + offSets.length + " Cocci in cluster: " + eRing);
			
			for (int k=0; k<offSets.length; k++)
			{
				
				body += "<Transform DEF='TRANSFORM_" + bioMightTransform.getId() + "' \n";
				
				
		 		body += "translation='" 
		 			+ (bioMightTransform.getTranslation().getXPos()  + offSets[k][0]) + " " 
						+ (bioMightTransform.getTranslation().getYPos()  + offSets[k][1]) + " "
						+ (bioMightTransform.getTranslation().getZPos()  + offSets[k][2]) + "'\n";					
		
	
				body +=  "scale='" 	+ bioMightTransform.getScale().getXPos() + " "
				 				+ bioMightTransform.getScale().getYPos() + " "
				 				+ bioMightTransform.getScale().getZPos() + "'>\n" +
				 	"<Shape DEF='SHAPE_" + bioMightTransform.getId() + "' \n" +
				    " containerField='children'>\n" +
				    " <Appearance\n" +
				    "  containerField='appearance'>\n";
	
		
			
				body+= " <ImageTexture containerField='texture' " +
				    " url='../images/" + bioMightTransform.getComponentName() +  ".png' />\n";
				
				
				    
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
				 	"<Sphere DEF='CocciGeoSphere'\n" +
				 	"containerField='geometry'\n" +
				 	"radius='" + bioMightTransform.getRadius() +"'/>\n" +
				 	"</Shape>\n" +
				 	
					"\n<TouchSensor DEF='TSENSOR_" + bioMightTransform.getId() + "' \n" +
	                   " description='" + bioMightTransform.getComponentName() + "'\n" +
		               " containerField='children'/> \n" +
	
				 "</Transform>\n";
			}
		}
		return (body);	
	}
	
  	
  	/***********************************************************************************************************************
  	 * CREATE FLAGELLA SPHERE
  	 * 
  	 * HARDCODED to CREATE 1 Flagella at a specific position
  	 * 
  	 * @param bioMightTransform
  	 * @param currentPoints
  	 * @param bHeader
  	 * @param bFooter
  	 * @param diffColor
  	 * @return
  	 ***********************************************************************************************************************/
	
  	public static String generateFlagellaSphere(BioMightTransform bioMightTransform,  double[] startPoint) 	
	{	
		int numLongitude = 12;
		int numLatitude = 12;
		double rotateLatitude = 360/numLatitude;
		double rotateLongitude = 360/numLongitude;
		double angleLatitude = rotateLatitude;
		double angleLongitude = rotateLongitude;
		
		double radius = bioMightTransform.getRadius();
		double height = bioMightTransform.getHeight();
				
		double xOrient = 0.0;
		double yOrient = 1.0;
		double zOrient = 0.0;
			
		double spikeHeight = MathUtils.round(radius/2.5, 6);
		double spikeRadius = MathUtils.round(radius/10, 6);
		double halfSpike   = MathUtils.round(spikeHeight/2, 8);
		
		String body = "";
		String bioGroup = "FlagellaGroup";
		BioMightTransform baseTransform = bioMightTransform;
		int transformCount = 0;
		
		double xStartPos = startPoint[0]; //bioMightTransform.getTranslation().getXPos();
		double yStartPos = startPoint[1]; //bioMightTransform.getTranslation().getYPos();
		double zStartPos = startPoint[2]; //bioMightTransform.getTranslation().getZPos();
		
		//***************************************************************
		// Create the Sphere that represents the Cell Membrane
		//****************************************************************
		body += "<Transform DEF='TRANSFORM_" + bioMightTransform.getId() + "' \n";
									
 		body += "translation='" 
 			+ xStartPos + " " 
			+ yStartPos + " "
			+ zStartPos + "'\n";					
		
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
		 	"<Sphere DEF='BacteriaGeoSphere'\n" +
		 	"containerField='geometry'\n" +
		 	"radius='" + radius +"'/>\n" +
		 	"</Shape>\n" +
		 	
			"\n<TouchSensor DEF='TSENSOR_" + bioMightTransform.getId() + "' \n" +
               " description='Gonococci'\n" +
               " containerField='children'/> \n" +

		 "</Transform>\n";
		
		
			
		//System.out.println("GenerateCylindricalComponents()  Num Longitude: " + numLongitude + "     NumLatitude: " + numLatitude);
		//System.out.println("GenerateCylindricalComponents()  rotateLongitude: " + rotateLongitude + "   rotateLatitude: " + rotateLatitude);
		// Run from top of the sphere to the bottom (Longitude)
		
		//for (int longitude=0; longitude<numLongitude ;longitude++)
		for (int longitude=0; longitude<numLongitude; longitude++) 
		{
			// Run from left to right across the latitude separated points of the sphere
			angleLatitude = 0;
			//System.out.println("Completed Complete Rotation - Resetting Latitude");

			//*****************************************
			// We have hardcoded it to a longitude
			//*****************************************
			if (longitude==(numLongitude-1))
			{
			
			for (int latitude=0; latitude<numLatitude; latitude++)
			{	
				
				//*****************************************
				// We have hardcoded it to a latitude
				//*****************************************
				if (latitude==8)
				{
			
				System.out.println("Spike - angleLongitude: " + angleLongitude + "    angleLatitude: " + angleLatitude);
				
				// Set the position on the surface of the sphere based on angle of latitude
				// Set the position on the surface of the sphere based on the longitude
				
				// Set up a Group around the whole spike
				bioGroup = "FlagellaGroup" + "L" + longitude + "L" + latitude;
				body += "\n<Transform DEF='" + bioGroup + "'\n";
				transformCount++;
				
				body += "  translation='" + bioMightTransform.getTranslation().getPositionStr() +  "'>\n\n";
				
				baseTransform = bioMightTransform;
				//body += "\n\n</Transform>\n\n";
				
				
				baseTransform = bioMightTransform;
				//body += "\n\n</Transform>\n\n";
			
				
				//********************************************************
				// Create the first spike
				//********************************************************
				double radiansLatitude =  Math.toRadians(angleLatitude);
				double radiansLongitude =  Math.toRadians(angleLongitude);
				System.out.println("radiansLatitude: " + radiansLatitude + " radiansLongitude: " + radiansLongitude);
				
				// Calculate sine and cosine
				double cosLat = MathUtils.round(Math.cos(radiansLatitude), 8);
				double cosLong = MathUtils.round(Math.cos(radiansLongitude), 8);
				double sinLong = MathUtils.round(Math.sin(radiansLongitude), 8);
				double sinLat = MathUtils.round(Math.sin(radiansLatitude), 8);
				
				// Set the position for the Spike.  Make it sit on the outside of the membrane
				double xPos = MathUtils.round(((radius+halfSpike) * (cosLat * sinLong)), 8);  
				double yPos = MathUtils.round(((radius+halfSpike) * cosLong), 8);
				double zPos = MathUtils.round(((radius+halfSpike) * (sinLat * sinLong)), 8); 
	
				// Translate to the offset position
				xPos += xStartPos;
				yPos += yStartPos;
				zPos += zStartPos;
				
				//System.out.println("Cos(Lat): " + cosLat + " Sin(Lat): " + sinLat + "            Sin(Long): " + sinLong + "  cos(Long): " + cosLong);
				//System.out.print   ln("XPOS: " + xPos + "=  Cos(Lat): " + cosLat + " Sin(Long): " + sinLong);
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
				
				 	"<Shape DEF='SHAPE_" + bioMightTransform.getId() + (longitude * latitude) + "' \n" +
				    " containerField='children'>\n" +
				    " <Appearance\n" +
				    "  containerField='appearance'>\n";

				body+= " <ImageTexture containerField='texture' " +
					    " url='../images/BacillusAnthracis.jpg'/>";
				
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
				System.out.println("StartPoint (SphereCenter): " + xSpikePos + "  " + xSpikePos +  "  " +  xSpikePos);
			
				
				xSpikePos += xStartPos;
				ySpikePos += yStartPos;
				zSpikePos += zStartPos;
		
				
				
				//System.out.println("Cos(Lat): " + cosLat + " Sin(Lat): " + sinLat + "            Sin(Long): " + sinLong + "  cos(Long): " + cosLong);
				//System.out.println("XPOS: " + xPos + "=  Cos(Lat): " + cosLat + " Sin(Long): " + sinLong);
				//System.out.println("YPOS: " + yPos + "=  Sin(Lat): " + sinLat + " Cos(Long): " + cosLong);
				//System.out.println("ZPOS: " + zPos + "=  Cos(Long): " + cosLong);
		
				// Run through the segments that make this string of cells
				int randoLength = new Double(MathUtils.round(Math.random()*150, 0)).intValue();
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
					// Create SPHERE connector where the position is
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
					double calculatedPoint[][] =  BioGraphics.applyRotation(new double [][] {{0, halfSpike, 0}}, -1, MathUtils.round(Math.toDegrees(spikeDegrees), 4), new double [] {xOrient, yOrient, zOrient} );
							
					// Extract the computed values
					double xPosCalc = calculatedPoint[0][0]; 
					double yPosCalc = calculatedPoint[0][1];
					double zPosCalc = calculatedPoint[0][2]; 

					// The Constant Point based on the Sphere Equation
					System.out.println("Spike StartPoint (Center): " + xSpikePos + "  " + xSpikePos +  "  " +  xSpikePos);
					System.out.println("Calculated CenterPoint Translate : " + xPosCalc + "  " + yPosCalc +  "  " +  zPosCalc);
					double newPoints[] = BioGraphics.applyTranslation(new double [] {xSpikePos, ySpikePos, zSpikePos}, new double [] {xPosCalc, yPosCalc, zPosCalc});
				
					double xCurSpikePos = newPoints[0];
					double yCurSpikePos = newPoints[1];
					double zCurSpikePos = newPoints[2];
					System.out.println("New CenterPoint: " + xCurSpikePos + "  " + yCurSpikePos +  "  " +  zCurSpikePos);
					
					
					// Set up the EndPoint/BeginPoint for the next Cylinder.   We should need to displace the distance twice
					// as the endpoint is twice the distance of what we are currently at.	    
					newPoints = BioGraphics.applyTranslation(new double [] {xSpikePos, ySpikePos, zSpikePos}, new double [] {2*xPosCalc, 2*yPosCalc, 2*zPosCalc} );
					xSpikePos = newPoints[0];
					ySpikePos = newPoints[1];
					zSpikePos = newPoints[2];
				    System.out.println("X Y Z for Spike Updated: " + xSpikePos + "  " + ySpikePos +  "  " +  zSpikePos);
					
				
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
				///System.out.println("\n\n CALLING ANIMATE: " + bioGroup);
				body += animate(bioGroup, baseTransform, transformCount);
				//System.out.println("\n\n COMPLETED ANIMATE: " + bioGroup);

				}
				
	    		// Increase the angle on the arc that goes from left to right
	    		angleLatitude += rotateLatitude;
	    		//System.out.println("Incremented Latitude Angle: " + angleLatitude);
			}
			}
			
			// Increase the angle on the Arc that goes top to bottom
			angleLongitude += rotateLongitude;
			//System.out.println("Incremented Longtitude Angle: " + angleLatitude);
		}
	
		return (body);
	}
  	
  	
	/***********************************************************************************************************************
  	 * CREATE FLAGELLA SPHERE
  	 * 
  	 * Set the lat range and long range that define the area that the flagella will occupy
  	 *  
  	 * @param bioMightTransform
  	 * @param currentPoints
  	 * @param bHeader
  	 * @param bFooter
  	 * @param diffColor
  	 * @return
  	 ***********************************************************************************************************************/
	
  	public static String generateFlagellaSphere(BioMightTransform bioMightTransform,  double[] startPoint, BioMightRange bioRange) 	
	{	
		int numLongitude = 12;
		int numLatitude = 12;
		double rotateLatitude = 360/numLatitude;
		double rotateLongitude = 360/numLongitude;
		double angleLatitude = rotateLatitude;
		double angleLongitude = rotateLongitude;
		
		double radius = bioMightTransform.getRadius();
		double height = bioMightTransform.getHeight();
				
		double xOrient = 0.0;
		double yOrient = 1.0;
		double zOrient = 0.0;
			
		//double spikeHeight = MathUtils.round(radius/2.5, 6);
		//double spikeRadius = MathUtils.round(radius/10, 6);
		//double halfSpike   = MathUtils.round(spikeHeight/2, 8);
		
		double spikeRadius = bioRange.getMaxWidth();
		double spikeHeight = bioRange.getMaxHeight();
		double halfSpike   = MathUtils.round(spikeHeight/2, 8);
	
		//double spikeRadius = new Double(MathUtils.round(Math.random()*bioRange.getMaxWidth(), 0)).intValue();
		//double spikeHeight = new Double(MathUtils.round(Math.random()*bioRange.getMaxHeight(), 0)).intValue();
		//double halfSpike   = MathUtils.round(spikeHeight/2, 8);
		
		String body = "";
		String bioGroup = "FlagellaGroup";
		BioMightTransform baseTransform = bioMightTransform;
		int transformCount = 0;
		
		double xStartPos = startPoint[0]; //bioMightTransform.getTranslation().getXPos();
		double yStartPos = startPoint[1]; //bioMightTransform.getTranslation().getYPos();
		double zStartPos = startPoint[2]; //bioMightTransform.getTranslation().getZPos();
		
		//***************************************************************
		// Create the Sphere that represents the Cell Membrane
		//****************************************************************
		body += "<Transform DEF='TRANSFORM_" + bioMightTransform.getId() + "' \n";
									
 		body += "translation='" 
 			+ xStartPos + " " 
			+ yStartPos + " "
			+ zStartPos + "'\n";					
	

		 					
		body +=  "scale='" 	+ bioMightTransform.getScale().getXPos() + " "
		 				+ bioMightTransform.getScale().getYPos() + " "
		 				+ bioMightTransform.getScale().getZPos() + "'>\n" +
		 				
		 	"<Shape DEF='SHAPE_" + bioMightTransform.getId() + "' \n" +
		    " containerField='children'>\n" +
		    " <Appearance\n" +
		    "  containerField='appearance'>\n";

					    
		if (bioMightTransform.getTextureID() > 0) {
			body+= " <ImageTexture containerField='texture' url='../images/" +
    			 bioMightTransform.getTextureFile() +  "' />";
		}
		else
		{
			body+= " <ImageTexture containerField='texture' " +
				    " url='../images/TexturedBlue.png'/>";
		}
		
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
		 	"<Sphere DEF='BacteriaGeoSphere'\n" +
		 	"containerField='geometry'\n" +
		 	"radius='" + radius +"'/>\n" +
		 	"</Shape>\n" +
		 	
			"\n<TouchSensor DEF='TSENSOR_" + bioMightTransform.getId() + "' \n" +
               " description='Gonococci'\n" +
               " containerField='children'/> \n" +

		 "</Transform>\n";
		
		
			
		//System.out.println("GenerateCylindricalComponents()  Num Longitude: " + numLongitude + "     NumLatitude: " + numLatitude);
		//System.out.println("GenerateCylindricalComponents()  rotateLongitude: " + rotateLongitude + "   rotateLatitude: " + rotateLatitude);
		// Run from top of the sphere to the bottom (Longitude)
		
		//for (int longitude=0; longitude<numLongitude ;longitude++)
		for (int longitude=0; longitude<numLongitude; longitude++) 
		{
			// Run from left to right across the latitude separated points of the sphere
			angleLatitude = 0;
			//System.out.println("Completed Complete Rotation - Resetting Latitude");

			// Show only those within the longitude range
			if (longitude>=bioRange.getMinLongRange() && longitude<=bioRange.getMaxLongRange())
			{
			
			for (int latitude=0; latitude<numLatitude; latitude++)
			{	
				// Show only those within the latitude range
				if (latitude>=bioRange.getMinLatRange() && latitude<=bioRange.getMaxLatRange())
				{
				
				System.out.println("FlagellaSpike - angleLongitude: " + angleLongitude + "    angleLatitude: " + angleLatitude);
				
				// Set the position on the surface of the sphere based on angle of latitude
				// Set the position on the surface of the sphere based on the longitude
				
				// Set up a Group around the whole spike
				bioGroup = "FlagellaGroup" + "L" + longitude + "L" + latitude;
				body += "\n<Transform DEF='" + bioGroup + "'\n";
				transformCount++;
				
				body += "  translation='" + bioMightTransform.getTranslation().getPositionStr() +  "'>\n\n";
				
				baseTransform = bioMightTransform;
				//body += "\n\n</Transform>\n\n";
				
				
				baseTransform = bioMightTransform;
				//body += "\n\n</Transform>\n\n";
		
				//********************************************************
				// Create the first spike
				//********************************************************
				double radiansLatitude =  Math.toRadians(angleLatitude);
				double radiansLongitude =  Math.toRadians(angleLongitude);
				//System.out.println("flagRadiansLatitude: " + radiansLatitude + " flagRadiansLongitude: " + radiansLongitude);
				
				// Calculate sine and cosine
				double cosLat = MathUtils.round(Math.cos(radiansLatitude), 8);
				double cosLong = MathUtils.round(Math.cos(radiansLongitude), 8);
				double sinLong = MathUtils.round(Math.sin(radiansLongitude), 8);
				double sinLat = MathUtils.round(Math.sin(radiansLatitude), 8);
				
				// Set the position for the Spike.  Make it sit on the outside of the membrane
				double xPos = MathUtils.round(((radius+halfSpike) * (cosLat * sinLong)), 8);  
				double yPos = MathUtils.round(((radius+halfSpike) * cosLong), 8);
				double zPos = MathUtils.round(((radius+halfSpike) * (sinLat * sinLong)), 8); 
	
				// Translate to the offset position
				xPos += xStartPos;
				yPos += yStartPos;
				zPos += zStartPos;
				
				//System.out.println("Cos(Lat): " + cosLat + " Sin(Lat): " + sinLat + "            Sin(Long): " + sinLong + "  cos(Long): " + cosLong);
				//System.out.print   ln("XPOS: " + xPos + "=  Cos(Lat): " + cosLat + " Sin(Long): " + sinLong);
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
				
				 	"<Shape DEF='SHAPE_" + bioMightTransform.getId() + (longitude * latitude) + "' \n" +
				    " containerField='children'>\n" +
				    " <Appearance\n" +
				    "  containerField='appearance'>\n";

				if (bioMightTransform.getTextureID() > 0) {
					body+= " <ImageTexture containerField='texture' url='../images/" +
		    			 bioMightTransform.getTextureFile() +  "' />";
				}
				else
				{
					body+= " <ImageTexture containerField='texture' " +
						    " url='../images/TexturedBlue.png'/>";
				}
				
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
			
				
				xSpikePos += xStartPos;
				ySpikePos += yStartPos;
				zSpikePos += zStartPos;
		
				
				
				//System.out.println("Cos(Lat): " + cosLat + " Sin(Lat): " + sinLat + "            Sin(Long): " + sinLong + "  cos(Long): " + cosLong);
				//System.out.println("XPOS: " + xPos + "=  Cos(Lat): " + cosLat + " Sin(Long): " + sinLong);
				//System.out.println("YPOS: " + yPos + "=  Sin(Lat): " + sinLat + " Cos(Long): " + cosLong);
				//System.out.println("ZPOS: " + zPos + "=  Cos(Long): " + cosLong);
		
				// Run through the segments that make this string of cells
				int randoLength = new Double(MathUtils.round(Math.random()*bioRange.getSections(), 0)).intValue();
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
					// Create SPHERE connector where the position is
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
	

					if (bioMightTransform.getTextureID() > 0) {
						body+= " <ImageTexture containerField='texture' url='../images/" +
			    			 bioMightTransform.getTextureFile() +  "' />";
					}
					else
					{
						body+= " <ImageTexture containerField='texture' " +
							    " url='../images/TexturedBlue.png'/>";
					}
			
					    	
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
					double calculatedPoint[][] =  BioGraphics.applyRotation(new double [][] {{0, halfSpike, 0}}, -1, MathUtils.round(Math.toDegrees(spikeDegrees), 4), new double [] {xOrient, yOrient, zOrient} );
							
					// Extract the computed values
					double xPosCalc = calculatedPoint[0][0]; 
					double yPosCalc = calculatedPoint[0][1];
					double zPosCalc = calculatedPoint[0][2]; 

					// The Constant Point based on the Sphere Equation
					//System.out.println("Spike StartPoint (Center): " + xSpikePos + "  " + xSpikePos +  "  " +  xSpikePos);
					//System.out.println("Calculated CenterPoint Translate : " + xPosCalc + "  " + yPosCalc +  "  " +  zPosCalc);
					double newPoints[] = BioGraphics.applyTranslation(new double [] {xSpikePos, ySpikePos, zSpikePos}, new double [] {xPosCalc, yPosCalc, zPosCalc});
				
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
	
			
					if (bioMightTransform.getTextureID() > 0) {
						body+= " <ImageTexture containerField='texture' url='../images/" +
			    			 bioMightTransform.getTextureFile() +  "' />";
					}
					else
					{
						body+= " <ImageTexture containerField='texture' " +
							    " url='../images/TexturedBlue.png'/>";
					}
					
										    
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

					 "</Transform>\n";					
				}
				
					
				// Set up a Group that assembles the flagellum
				body += "\n\n</Transform>\n\n";
				///System.out.println("\n\n CALLING ANIMATE: " + bioGroup);
				body += animate(bioGroup, baseTransform, transformCount);
				//System.out.println("\n\n COMPLETED ANIMATE: " + bioGroup);

				}
				
	    		// Increase the angle on the arc that goes from left to right
	    		angleLatitude += rotateLatitude;
	    		//System.out.println("Incremented Latitude Angle: " + angleLatitude);
			}
			}
			
			// Increase the angle on the Arc that goes top to bottom
			angleLongitude += rotateLongitude;
			//System.out.println("Incremented Longtitude Angle: " + angleLatitude);
		}
	
		return (body);
	}
  	

	/***********************************************************************************************************************
  	 * CREATE SPHERE SIMPLE
  	 *
  	 * Uses a basic Sphere shape in X3D
  	 * 
  	 * @param bioMightTransform
  	 * @param currentPoints
  	 * @param bHeader
  	 * @param bFooter
  	 * @param diffColor
  	 * @return
  	 ***********************************************************************************************************************/
	
  	public static String generateSphereSimple(BioMightTransform bioMightTransform) 	
	{	
  		String body = "";
  		
		String compName = bioMightTransform.getComponentName();
		body = "<Transform  onmouseover=\"showComponent('" + compName+ "');\" DEF='" + compName + "'\n";
	
		
		System.out.println("GenerateSphere  Texture: " + bioMightTransform.getTextureFile());
		
		
	 	body += "translation='" 
	 		+ bioMightTransform.getTranslation().getXPos() + " " 
			+ bioMightTransform.getTranslation().getYPos() + " "
			+ bioMightTransform.getTranslation().getZPos() + "'\n";					 					
		 					
		body +=  "scale='" 	+ bioMightTransform.getScale().getXPos() + " "
		 				+ bioMightTransform.getScale().getYPos() + " "
		 				+ bioMightTransform.getScale().getZPos() + "'>\n\n";
		
		body += "<Shape DEF='SHAPE_" + bioMightTransform.getId() + "' \n" +
			    " containerField='children'>\n" +
			    " <Appearance\n" +
			    "  containerField='appearance'>\n";
		
		if (bioMightTransform.getTextureID() > 0) {
			body+= " <ImageTexture containerField='texture' url='../images/" +
    	    bioMightTransform.getTextureFile() +  "' />";
		}
		else
		{
			body+= " <ImageTexture containerField='texture' " +
				    " url='../images/MembraneColor.jpg'/>";
		}
		
		    
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
		 	"<Sphere DEF='NeuronGeoSphere'\n" +
		 	"containerField='geometry'\n" +
		 	"radius='" + bioMightTransform.getRadius() +"'/>\n" +
		 	"</Shape>\n" +
		 	
			"\n<TouchSensor DEF='"+bioMightTransform.getId()+"' \n" +
               " description='Neuron'\n" +
               " containerField='children'/> \n" +

		 "</Transform>\n";

  		
		return(body);
	}

	/***********************************************************************************************************************
  	 * CREATE SPHERE
  	 *
  	 * Creates a sphere out of indexed faced sets. 
  	 * 
  	 * @param bioMightTransform
  	 * @param currentPoints
  	 * @param bHeader
  	 * @param bFooter
  	 * @param diffColor
  	 * @return
  	 ***********************************************************************************************************************/
	
  	public static String generateSphere(BioMightTransform bioMightTransform,  double[] startPoint) 	
	{	
	
	  	String body = "";
		int numLongitude = 12;
		int numLatitude = 12;
		double rotateLatitude = 360/numLatitude;
		double rotateLongitude = 360/numLongitude;
		double angleLatitude = rotateLatitude;
		double angleLongitude = rotateLongitude;
		double xOrient = 0.0;
		double yOrient = 1.0;
		double zOrient = 0.0;
	
		double radius = (bioMightTransform.getRadius());
		double height =  bioMightTransform.getHeight();
	
		double spikeHeight =  0.0875;
		double spikeRadius = 0.00825;
		double halfSpike = MathUtils.round(spikeHeight/2, 8);
		 
			
		String bioGroup = "FlagellaGroup";
		BioMightTransform baseTransform = bioMightTransform;
		
		
		double[][] lastPoints = new double [numLatitude][3];
		double[][] currentPoints = new double [numLatitude][3];		
	
		for (int cells=0; cells<1; cells++)
		{
			
		
			System.out.println("GenerateCylindricalComponents()  Num Longitude: " + numLongitude + "     NumLatitude: " + numLatitude);
			System.out.println("GenerateCylindricalComponents()  rotateLongitude: " + rotateLongitude + "   rotateLatitude: " + rotateLatitude);
			
			// Run from top of the sphere to the bottom (Longitude)
			
			//for (int longitude=0; longitude<numLongitude ;longitude++)
			for (int longitude=0; longitude<numLongitude; longitude++) 
			{
				// Run from left to right across the latitude separated points of the sphere
				angleLatitude = 0;
				//System.out.println("Completed Complete Rotation - Resetting Latitude");
	
				for (int latitude=0; latitude<numLatitude; latitude++)
				{					
					//System.out.println("GenerateCylindricalComponents - angleLongitude: " + angleLongitude + "    angleLatitude: " + angleLatitude);
					
					// Set the position on the surface of the sphere based on angle of latitude
					// Set the position on the surface of the sphere based on the longitude
					
					// Set up a Group around the whole spike
					bioGroup = "FlagellaGroup" + "L" + longitude + "L" + latitude;
					body += "\n<Transform DEF='" + bioGroup + "'\n";
					body += "  translation='" + bioMightTransform.getTranslation().getPositionStr() +  "'>\n\n";
					
					baseTransform = bioMightTransform;
					//body += "\n\n</Transform>\n\n";
								
					
					//********************************************************
					// Create the first spike
					//********************************************************
					double radiansLatitude =  Math.toRadians(angleLatitude);
					double radiansLongitude =  Math.toRadians(angleLongitude);
					System.out.println("radiansLatitude: " + radiansLatitude + " radiansLongitude: " + radiansLongitude);
					
					// Calculate sine and cosine
					double cosLat = MathUtils.round(Math.cos(radiansLatitude), 8);
					double cosLong = MathUtils.round(Math.cos(radiansLongitude), 8);
					double sinLong = MathUtils.round(Math.sin(radiansLongitude), 8);
					double sinLat = MathUtils.round(Math.sin(radiansLatitude), 8);
					
							
					// Set the position for the Spike.  Make it sit on the outside of the membrane
					double xPos = MathUtils.round(((radius+halfSpike) * (cosLat * sinLong)), 8);  
					double yPos = MathUtils.round(((radius+halfSpike) * cosLong), 8);
					double zPos = MathUtils.round(((radius+halfSpike) * (sinLat * sinLong)), 8); 
		
					// Store all the latitude current points for the given longitude
					currentPoints[latitude][0] = xPos;
					currentPoints[latitude][1] = yPos;
					currentPoints[latitude][2] = zPos;
									
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
					
					 	"<Shape DEF='SHAPE_" + bioMightTransform.getId() + (longitude * latitude) + "' \n" +
					    " containerField='children'>\n" +
					    " <Appearance\n" +
					    "  containerField='appearance'>\n";
	
					body+= " <ImageTexture containerField='texture' " +
						    " url='../images/BacillusAnthracis.jpg'/>";
					
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
	
	
					// Set up a Group that assembles the flagellum
					body += "\n\n</Transform>\n\n";		
					//body += animate(bioGroup, baseTransform);
						
		    		// Increase the angle on the arc that goes from left to right
		    		angleLatitude += rotateLatitude;
		    		//System.out.println("Incremented Latitude Angle: " + angleLatitude);
				}
			
		
				// On Every Longitutde, we 
				// Connect the previous row with the current row
				// On the first instancr, there is nothing to connect to
				if (longitude < 1)
				{
					System.out.println("Not Connecting Longitude - only 1 row");
				}
				else 
				{
					// Connect up the last and current.
					String coordIndexStr = "";
					String topRowVertices = "";
					String bottomRowVertices = "";
					
					// Linearly store the Vertices
					// Load the coordinates/vertices for first row
					for (int latitude=0; latitude<numLatitude; latitude++)
					{
						/// build the top row
						if (latitude==0)
							topRowVertices = "\n" + currentPoints[latitude][0]  + ", " +  currentPoints[latitude][1] + ", " + currentPoints[latitude][2];
							//coordinateString = centerPointStr + ", \n" + cyPoints[k][0]  + ", " +  cyPoints[k][1] + ", " + cyPoints[k][2];
						else
							topRowVertices += ",\n  " + currentPoints[latitude][0]  + ",  " +  currentPoints[latitude][1] + ",  " + currentPoints[latitude][2];		
				
						// Buid the bottom row
						if (latitude==0)
							bottomRowVertices = "\n" + lastPoints[latitude][0]  + ", " +  lastPoints[latitude][1] + ", " + lastPoints[latitude][2];
							//coordinateString = centerPointStr + ", \n" + cyPoints[k][0]  + ", " +  cyPoints[k][1] + ", " + cyPoints[k][2];
						else
							bottomRowVertices += ",\n  " + lastPoints[latitude][0]  + ",  " +  lastPoints[latitude][1] + ",  " + lastPoints[latitude][2];		
					
					}
					
					
					coordIndexStr = topRowVertices + "," + bottomRowVertices;
					//System.out.println("NUM COORDS: " + currentPoints.length  + "    "  + currentPoints.length );
					//System.out.println("COORDS are: " + coordIndexStr);
					
					
	
					// Now connect the points together
					String tempIndexStr = "";
					for (int latitude=0; latitude<numLatitude; latitude++)
					{
						
						if (latitude==0)
						{	
							tempIndexStr = " " +  
									(latitude+1)     			+ "  " +
									 latitude 			+ "  " +
									(latitude+numLatitude) 	+ "  " +
									(latitude+numLatitude+1) + "  -1";
						}	
						else if (latitude==(numLatitude-1))
						{	
							tempIndexStr += ", " +  
									0    			+ "  " +
									(numLatitude-1) + "  " +
									(2*numLatitude-1) 	+ "  " +
									numLatitude + "  -1";
						}
						else
						{	
							tempIndexStr += ", " +  
									(latitude+1) 		+ "  " +
									 latitude 			+ "  " +
									(latitude+numLatitude) + "  " +
										(latitude+numLatitude+1) + "  -1";
						}
					}
					
					
					System.out.println("********* Index is: " + tempIndexStr);	
					
					
					String componentType = "AdenovirusCap";
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
					    	    "containerField='coord' point='" + coordIndexStr + "'/>" +
					    	  "</IndexedFaceSet>\n" +
					    
					    	 "</Shape>\n" +
					    	 
					    	 "<TouchSensor DEF='StartEndothelium' \n" +
			                   " description='" + componentType + "'\n" +
				               " containerField='children'/> \n" +
					    	 
					"</Transform>\n"; 
				}
				
				
				// Store all the latitude points for future use
				for (int latitude=0; latitude<numLatitude; latitude++)
				{
					lastPoints[latitude][0] = currentPoints[latitude][0];
					lastPoints[latitude][1] = currentPoints[latitude][1];
					lastPoints[latitude][2] = currentPoints[latitude][2];
			
				}
		
							
				// Increase the angle on the Arc that goes top to bottom
				angleLongitude += rotateLongitude;
				//System.out.println("Incremented Longtitude Angle: " + angleLatitude);
			}
	
		}
	
		return (body);		
	}
  	
	/***********************************************************************************************************************
  	 * CREATE SPHERE IRREGULAR
  	 *
  	 * Creates a sphere out of indexed faced sets that is not symetrical, or is irregular.  It uses
  	 * a series of ranges over the shape of the sphere that are to be affected.  Ranges are 
  	 *  
  	 * @param bioMightTransform
  	 * @param currentPoints
  	 * @param bHeader
  	 * @param bFooter
  	 * @param diffColor
  	 * @return
  	 ***********************************************************************************************************************/
	
  	public static String generateSphereIrregular(BioMightTransform bioMightTransform,  double[] startPoint, ArrayList ranges) 	
	{	
	
	  	String body = "";
		int numLongitude = 24;
		int numLatitude = 24;
		double rotateLatitude = 360/numLatitude;
		double rotateLongitude = 360/numLongitude;
		double angleLatitude = rotateLatitude;
		double angleLongitude = rotateLongitude;
		double xOrient = 0.0;
		double yOrient = 1.0;
		double zOrient = 0.0;
	
		double radius = (bioMightTransform.getRadius());
		double height =  bioMightTransform.getHeight();
	
		double spikeHeight =  0.0875;
		double spikeRadius = 0.00825;
		double halfSpike = MathUtils.round(spikeHeight/2, 8);
		 
			
		String bioGroup = "FlagellaGroup";
		BioMightTransform baseTransform = bioMightTransform;
		
		
		double[][] lastPoints = new double [numLatitude][3];
		double[][] currentPoints = new double [numLatitude][3];		
	
		double extrudeRad = radius/2;
		for (int cells=0; cells<1; cells++)
		{
			System.out.println("generateSphereIrregular()  Num Longitude: " + numLongitude + "     NumLatitude: " + numLatitude);
			System.out.println("generateSphereIrregular()  rotateLongitude: " + rotateLongitude + "   rotateLatitude: " + rotateLatitude);
			
			// Run from top of the sphere to the bottom (Longitude)
			
			//for (int longitude=0; longitude<numLongitude ;longitude++)
			for (int longitude=0; longitude<numLongitude; longitude++) 
			{
				// Run from left to right across the latitude separated points of the sphere
				angleLatitude = 0;
				//System.out.println("Completed Complete Rotation - Resetting Latitude");
		
					for (int latitude=0; latitude<numLatitude; latitude++)
					{				
						radius = (bioMightTransform.getRadius());
						
						// Apply extrusion to those points within the longitude/latitude ranges
						for (int r=0; r< ranges.size(); r++)
						{
							BioMightRange bioRange = (BioMightRange) ranges.get(r);
							if ((longitude>=bioRange.getMinLongRange() && longitude<=bioRange.getMaxLongRange()) &&
								(latitude>=bioRange.getMinLatRange() && latitude<=bioRange.getMaxLatRange()))			
							{
								radius += extrudeRad; 
							}
						}
						
							//System.out.println("GenerateCylindricalComponents - angleLongitude: " + angleLongitude + "    angleLatitude: " + angleLatitude);
							
							// Set the position on the surface of the sphere based on angle of latitude
							// Set the position on the surface of the sphere based on the longitude
							
							// Set up a Group around the whole spike
							bioGroup = "FlagellaGroup" + "L" + longitude + "L" + latitude;
							
							//body += "\n<Group DEF='" + bioGroup + "'>\n\n";
							
							baseTransform = bioMightTransform;
							//body += "\n\n</Transform>\n\n";
															
							//********************************************************
							// Create the first spike
							//********************************************************
							double radiansLatitude =  Math.toRadians(angleLatitude);
							double radiansLongitude =  Math.toRadians(angleLongitude);
							System.out.println("radiansLatitude: " + radiansLatitude + " radiansLongitude: " + radiansLongitude);
							
							// Calculate sine and cosine
							double cosLat = MathUtils.round(Math.cos(radiansLatitude), 8);
							double cosLong = MathUtils.round(Math.cos(radiansLongitude), 8);
							double sinLong = MathUtils.round(Math.sin(radiansLongitude), 8);
							double sinLat = MathUtils.round(Math.sin(radiansLatitude), 8);
							
									
							// Set the position for the Spike.  Make it sit on the outside of the membrane
							//double xPos = MathUtils.round(((radius+halfSpike) * (cosLat * sinLong)), 8);  
							//double yPos = MathUtils.round(((radius+halfSpike) * cosLong), 8);
							//double zPos = MathUtils.round(((radius+halfSpike) * (sinLat * sinLong)), 8); 
				
							double xPos = MathUtils.round(((radius) * (cosLat * sinLong)), 8);  
							double yPos = MathUtils.round(((radius) * cosLong), 8);
							double zPos = MathUtils.round(((radius) * (sinLat * sinLong)), 8); 
				
							// Store all the latitude current points for the given longitude
							currentPoints[latitude][0] = xPos + startPoint[0];
							currentPoints[latitude][1] = yPos + startPoint[1];
							currentPoints[latitude][2] = zPos + startPoint[2];
											
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
							
							/************
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
			
							body+= " <ImageTexture containerField='texture' " +
								    " url='../images/SpeckledOrange.png'/>";
							
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
			
			
							// Set up a Group that assembles the flagellum
							body += "\n\n</Group>\n\n";		
							//body += animate(bioGroup, baseTransform);
								
							**************************/	
							
				    		// Increase the angle on the arc that goes from left to right
				    		angleLatitude += rotateLatitude;
				    		//System.out.println("Incremented Latitude Angle: " + angleLatitude);
						}
					
					
			
					// On Every Longitutde, we 
					// Connect the previous row with the current row
					// On the first instance, there is nothing to connect to
					if (longitude < 1)
					{
						System.out.println("Not Connecting Longitude - only 1 row");
					}
					else 
					{
						// Connect up the last and current.
						String coordIndexStr = "";
						String topRowVertices = "";
						String bottomRowVertices = "";
						
						// Linearly store the Vertices
						// Load the coordinates/vertices for first row
						for (int latitude=0; latitude<numLatitude; latitude++)
						{
							/// build the top row
							if (latitude==0)
								topRowVertices = "\n" + currentPoints[latitude][0]  + ", " +  currentPoints[latitude][1] + ", " + currentPoints[latitude][2];
								//coordinateString = centerPointStr + ", \n" + cyPoints[k][0]  + ", " +  cyPoints[k][1] + ", " + cyPoints[k][2];
							else
								topRowVertices += ",\n  " + currentPoints[latitude][0]  + ",  " +  currentPoints[latitude][1] + ",  " + currentPoints[latitude][2];		
					
							// Buid the bottom row
							if (latitude==0)
								bottomRowVertices = "\n" + lastPoints[latitude][0]  + ", " +  lastPoints[latitude][1] + ", " + lastPoints[latitude][2];
								//coordinateString = centerPointStr + ", \n" + cyPoints[k][0]  + ", " +  cyPoints[k][1] + ", " + cyPoints[k][2];
							else
								bottomRowVertices += ",\n  " + lastPoints[latitude][0]  + ",  " +  lastPoints[latitude][1] + ",  " + lastPoints[latitude][2];		
						
						}
						
						
						coordIndexStr = topRowVertices + "," + bottomRowVertices;
						//System.out.println("NUM COORDS: " + currentPoints.length  + "    "  + currentPoints.length );
						//System.out.println("COORDS are: " + coordIndexStr);
						
						
		
						// Now connect the points together
						String tempIndexStr = "";
						for (int latitude=0; latitude<numLatitude; latitude++)
						{
							
							if (latitude==0)
							{	
								tempIndexStr = " " +  
										(latitude+1)     			+ "  " +
										 latitude 			+ "  " +
										(latitude+numLatitude) 	+ "  " +
										(latitude+numLatitude+1) + "  -1";
							}	
							else if (latitude==(numLatitude-1))
							{	
								tempIndexStr += ", " +  
										0    			+ "  " +
										(numLatitude-1) + "  " +
										(2*numLatitude-1) 	+ "  " +
										numLatitude + "  -1";
							}
							else
							{	
								tempIndexStr += ", " +  
										(latitude+1) 		+ "  " +
										 latitude 			+ "  " +
										(latitude+numLatitude) + "  " +
											(latitude+numLatitude+1) + "  -1";
							}
						}
						
						
						System.out.println("********* Index is: " + tempIndexStr);	
						
						
						String componentType = "AdenovirusCap";
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
						    	    "containerField='coord' point='" + coordIndexStr + "'/>" +
						    	  "</IndexedFaceSet>\n" +
						    
						    	 "</Shape>\n" +
						    	 
						    	 "<TouchSensor DEF='StartEndothelium' \n" +
				                   " description='" + componentType + "'\n" +
					               " containerField='children'/> \n" +
						    	 
						"</Transform>\n"; 
					}
					
					
					
					// Store all the latitude points for future use
					for (int latitude=0; latitude<numLatitude; latitude++)
					{
						lastPoints[latitude][0] = currentPoints[latitude][0];
						lastPoints[latitude][1] = currentPoints[latitude][1];
						lastPoints[latitude][2] = currentPoints[latitude][2];
				
					}
	
				
			
							
				// Increase the angle on the Arc that goes top to bottom
				angleLongitude += rotateLongitude;
				//System.out.println("Incremented Longtitude Angle: " + angleLatitude);
			}
	
		}
	
		return (body);		
	}
 	

	/******************************************************************************************
	 * GENERATE RODS
	 *
	 * This method will create Rods which are comprised of a Cylinder and Dome.  
	 * 
	 *****************************************************************************************/
	
  	public static String generateRods(int numRods, BioMightTransform bioMightTransform,  double[] startPoint) 	
	{	
		System.out.println("generateRods...");

	  	String body = "";
		double rodOrient[] = {0.0,     0.0,     1.0,      1.52};
		
		// Get the base values from the database (translation)
		// of where the object is positioned
		double xStartPos = bioMightTransform.getTranslation().getXPos();  
		double yStartPos = bioMightTransform.getTranslation().getYPos();
		double zStartPos = bioMightTransform.getTranslation().getZPos();
		
		// Vars to Represent the current position
		double xPos = xStartPos; 
		double yPos = yStartPos;
		double zPos = zStartPos;
		
		double height = bioMightTransform.getHeight();
		double radius = bioMightTransform.getRadius();
		System.out.println("Object's StartPoint: " + xPos + "  " + yPos +  "  " +  zPos);
		
		int collectionSize = new Double(MathUtils.round(Math.random()*5, 0)).intValue();
		collectionSize=1;
		System.out.println("Rod Collection Size: " + collectionSize);
		
		
		for (int k=0; k<collectionSize; k++) {
										
			// Create a string of interconnected rods
			int randoLength = 0;
			if (numRods == 0)
				randoLength = new Double(MathUtils.round(Math.random()*7, 0)).intValue();
			else
				randoLength = numRods;
			randoLength = 1;
			System.out.println("NumRods in Collection: " + collectionSize);
					
			for (int v=0; v<randoLength; v++) {
	
				// Set up the Angle that defines the outward growth path
				double randomRotateAngle = Math.random();
				while (randomRotateAngle > .707) {
					randomRotateAngle = Math.random();
				}
				//rodOrient[3] = MathUtils.round(randomRotateAngle, 3);
				
				if (v==0)
					rodOrient[3] = 1.57; //MathUtils.round(randomRotateAngle, 3);
				else if (v==1)
					rodOrient[3] = 1.57; 
				
				//******************************************************************************************************
				// Create the startCap 
				// Pass in the position and orientation. We add 180 degrees to flip the dome so it makes a startCap
				//******************************************************************************************************
				BioMightPosition bioMightPosition = new BioMightPosition(xPos, yPos, zPos);
				BioMightOrientation bioMightOrientation = new BioMightOrientation(rodOrient[0], rodOrient[1], rodOrient[2], 0);
				//BioMightOrientation bioMightOrientation = new BioMightOrientation(rodOrient[0], rodOrient[1], rodOrient[2], (rodOrient[3] + 0));
				// System.out.println("ORIENT START DOME: " + bioMightOrientation.getXAxis() + "  " + bioMightOrientation.getYAxis()  + "  " + bioMightOrientation.getZAxis()  + "  " + bioMightOrientation.getDegrees() );
				//body += BioWebX3DUtils.generateDome(bioMightTransform,  bioMightPosition, bioMightOrientation,  false);
			
		
				BioMightOrientation bioMightOrientation1 = new BioMightOrientation(rodOrient[0], rodOrient[1], rodOrient[2], rodOrient[3]);
				System.out.println("ORIENT DOME: " + bioMightOrientation.getXAxis() + "  " + bioMightOrientation.getYAxis()  + "  " + bioMightOrientation.getZAxis()  + "  " + bioMightOrientation.getDegrees() );
				body += BioWebX3DUtils.generateDome(bioMightTransform,  bioMightPosition, bioMightOrientation1,  false);
		
				
				
				//*************************************************************
				// Determine the position of the Cylinder based on the
				// rotation and orientations
				//*************************************************************
				
				// Get the rotation angle in degrees
				double rotationAngleDegrees = MathUtils.round(Math.toDegrees( (rodOrient[3]) ), 4);
		
				// The cylinder is centered, so we rotate half the radius
				double rotationRadius = height * 0.50;
							 
				// Debug statement that shows the degrees from the radians angle
				//System.out.println("Longitude Angle: " + rotationAngleDegrees);
				
				// Calculate the new position based on the orientation using arbitrary rotation vector
				double calculatedPoint[][] =  BioGraphics.applyRotation(new double [][] {{0, rotationRadius, 0}}, -1, rotationAngleDegrees, new double [] {rodOrient[0], rodOrient[1], rodOrient[2]} );
				
				// Extract the computed values
				double xPosCalc = calculatedPoint[0][0]; 
				double yPosCalc = calculatedPoint[0][1];
				double zPosCalc = calculatedPoint[0][2]; 
	
				// Move the object based on the calculated orientation
				System.out.println("Current Rod StartPoint (Center)    : " + xPos + "  " + yPos +  "  " +  zPos);
				System.out.println("Current Rod Orientation Adjustment : " + xPosCalc + "  " + yPosCalc +  "  " +  zPosCalc);
				double newPoints[] = BioGraphics.applyTranslation(new double [] {xPos, yPos, zPos}, new double [] {xPosCalc, yPosCalc, zPosCalc});
				System.out.println("New Rod CenterPoint: " + newPoints[0] + "  " + newPoints[1] +  "  " +  newPoints[2]);
	
				// This is new Center Position for the Cylinder
				double xPosRod = newPoints[0];
				double yPosRod = newPoints[1];
				double zPosRod = newPoints[2];
	
				// Set up the Position for Rod endCap.   We should need to displace the distance twice
				// as the endpoint is twice the distance of what we are currently at.	    
				newPoints = BioGraphics.applyTranslation(new double [] {xPos, yPos, zPos}, new double [] {2*xPosCalc, 2*yPosCalc, 2*zPosCalc} );
				xPos = newPoints[0];
				yPos = newPoints[1];
				zPos = newPoints[2];
			    
			    System.out.println("X Y Z Updated: " + newPoints[0] + "  " + newPoints[1] +  "  " +  newPoints[2]);
				
			
				//**************************************************
				// Stup the Cylinder X3D to represent Cell Membrane
				//**************************************************
			    
			  /*
				body += "<Transform DEF='TRANSFORM_BACTBODY" + bioMightTransform.getId() + "' \n";
					
				// Let's compute 
			 	body += "translation='" 
					+ xPosRod + " " 
					+ yPosRod + " "
					+ zPosRod + "'\n";										
	
				body +=  "rotation='" 
						+ rodOrient[0] + " "
						+ rodOrient[1] + " "
						+ rodOrient[2]  + " "
						+ rodOrient[3] + "'>\n\n";
	
				 					
				body +=  "scale='" 	+ bioMightTransform.getScale().getXPos() + " "
				 				+ bioMightTransform.getScale().getYPos() + " "
				 				+ bioMightTransform.getScale().getZPos() + "'>\n" +
				 	"<Shape DEF='SHAPE_" + bioMightTransform.getId() + "' \n" +
				    " containerField='children'>\n" +
				    " <Appearance\n" +
				    "  containerField='appearance'>\n";
	
		
				body+= " <ImageTexture containerField='texture' " +
				    " url='../images/MembraneColor.jpg'/>";
				
									    
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
				*/
				
				//****************************************************************************
				// Create Dome EndCap
				// Pass in the position and orientation, we have to flip the dome
				//****************************************************************************
				
				rotationAngleDegrees = MathUtils.round(Math.toDegrees( rodOrient[3] ), 4);
				
				bioMightPosition = new BioMightPosition(xPos, yPos, zPos);
				bioMightOrientation = new BioMightOrientation(rodOrient[0], rodOrient[1], rodOrient[2], (rodOrient[3]));
	
				//System.out.println("ORIENT DOME: " + rodOrient[0] + "  " + rodOrient[1] + "  " + rodOrient[2] + "  " + rodOrient[3]);
				//System.out.println("ORIENT END DOME: " + bioMightOrientation.getXAxis() + "  " + bioMightOrientation.getYAxis()  + "  " + bioMightOrientation.getZAxis()  + "  " + bioMightOrientation.getDegrees() );
				//body += BioWebX3DUtils.generateDome(bioMightTransform,  bioMightPosition, bioMightOrientation,  false);
	
				
				//****************************************************************************
				// Calculate Position for the Start of the Next Rod (startCap)
				//****************************************************************************
				
				// Debug statement that shows the degrees from the radians angle
				double calculatedPointEndCap[][] =  BioGraphics.applyRotation(new double [][] {{0, rotationRadius, 0}}, -1, rotationAngleDegrees, new double [] {rodOrient[0], rodOrient[1], rodOrient[2]} );
				
				// Extract the computed values
				xPosCalc = calculatedPointEndCap[0][0]; 
				yPosCalc = calculatedPointEndCap[0][1];
				zPosCalc = calculatedPointEndCap[0][2]; 
	
				// The Constant Point based on the Sphere Equation
				System.out.println("Current StartPoint EndCap: " + xPos + "  " + yPos +  "  " +  zPos);
				System.out.println("Calculated CenterPoint Translate : " + xPosCalc + "  " + yPosCalc +  "  " +  zPosCalc);
				double newPointsEndCap[] = BioGraphics.applyTranslation(new double [] {xPos, yPos, zPos}, new double [] {xPosCalc, yPosCalc, zPosCalc});
				System.out.println("New EndCap CenterPoint: " + newPointsEndCap[0] + "  " + newPointsEndCap[1] +  "  " +  newPointsEndCap[2]);
	
				// This is new Center Position for the Cylinder
				double xPosSpike = newPointsEndCap[0];
				double yPosSpike = newPointsEndCap[1];
				double zPosSpike = newPointsEndCap[2];
	
				// Set up the EndPoint/BeginPoint for the next Cylinder.   We should need to displace the distance twice
				// as the endpoint is twice the distance of what we are currently at.	    
				newPoints = BioGraphics.applyTranslation(new double [] {-xPosSpike, -yPosSpike, -zPosSpike}, new double [] {2*xPosCalc, 2*yPosCalc, 2*zPosCalc} );
				xPos = newPointsEndCap[0];
				yPos = newPointsEndCap[1];
				zPos = newPointsEndCap[2];
			    
			    System.out.println("X Y Z Updated: " + newPointsEndCap[0] + "  " + newPointsEndCap[1] +  "  " +  newPointsEndCap[2]);

				
				}
				
			}

		return (body);
	}
	

	/***********************************************************************************************************************
  	 * GENERATE DOME
  	 * 
  	 * Creates a Dome out of indexed faced sets that are oriented to the orientation of the rod
  	 * 
  	 * @param bioMightTransform
  	 * @param currentPoints
  	 * @param bHeader
  	 * @param bFooter
  	 * @param diffColor
  	 * @return
  	 ***********************************************************************************************************************/
	
  	public static String generateDome(BioMightTransform bioMightTransform,  BioMightPosition startPos, BioMightOrientation bioMightOrientation, boolean bSpikes) 	
	{		
	  	String body = "";
		int numLongitude = 12;
		int numLatitude = 12;
		double rotateLatitude = 360/numLatitude;
		double rotateLongitude = 360/numLongitude;
		double angleLatitude = rotateLatitude;
		double angleLongitude = rotateLongitude;
	
		// Use the radius of the cylinder
		double radius = (bioMightTransform.getRadius());
		
		double xStartPos = startPos.getXPos(); 
		double yStartPos = startPos.getYPos(); 
		double zStartPos = startPos.getZPos();
		System.out.println("GenerateDome() at Start Position: " + xStartPos +   ",   " + yStartPos + ",   " + zStartPos);
			
		// Extract and set up the Orientation angle  
		double rotationAngle = bioMightOrientation.getDegrees();
		double domeDegrees = MathUtils.round(Math.toDegrees(rotationAngle), 4);
		System.out.println("Dome Rotation Angle: " + rotationAngle + "  In Degrees: " +  domeDegrees);
			
		double spikeRadius = 0.02225;
		double perpRadius = 0.03225;

		
		//***************************************************************
		// SPHERE 
		// Pop out a sphere at the base position
		//***************************************************************

		body += "<Transform DEF='TRANSFORM_STARTSPHERE'\n";
		
		body += "translation='" 
					+ xStartPos  + " " 
 					+ yStartPos + " "
 					+ zStartPos + "'\n";				
		
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
		    "transparency='" 		+ "0.0" + "'\n" +
		    "diffuseColor='" + 
		 	    0.10 + " " + 
		 	    0.80 + " " +
		 	    0.10 + "'/>\n" +
		 	"</Appearance>\n" +
		 	"<Sphere DEF='StartSphere'\n" +
		 	"containerField='geometry'\n" +
		 	"radius='" + spikeRadius +"'/>\n" +
		 	"</Shape>\n" +
		 	
		 "</Transform>\n";

		
		// Allocate arrays to hold the Dome Point positions
		double[][] lastPoints = new double [numLatitude][3];
		double[][] currentPoints = new double [numLatitude][3];		

		//**************************************************************
		// SETUP POLE
		// Determine the Pole's position.  We create sphere in normal
		// upright position first, then we apply to rotation to 
		// orient it into the proper perspective
		// 
		//**************************************************************
		 
		double calculatedPoint[][] =  BioGraphics.applyRotation(new double [][] {{0, radius, 0}}, -1, domeDegrees, new double [] {bioMightOrientation.getXAxis(), bioMightOrientation.getYAxis(), bioMightOrientation.getZAxis()} );
		
		// Extract the computed values
		double xPosCalc = calculatedPoint[0][0]; 
		double yPosCalc = calculatedPoint[0][1];
		double zPosCalc = calculatedPoint[0][2]; 

		// Displace the points based on the start position
		double xPolePos = xPosCalc + xStartPos;
		double yPolePos = yPosCalc + yStartPos;
		double zPolePos = zPosCalc + zStartPos;

		// Run from top of the sphere to the bottom (Longitude)
		// for (int longitude=0; longitude<numLongitude ;longitude++)
		for (int longitude=0; longitude<numLongitude; longitude++) 
		{
			if (longitude<3 ) {
				
				
			// Run from left to right across the latitude separated points of the sphere
			angleLatitude = 0;
			//System.out.println("Completed Complete Rotation - Resetting Latitude");

			for (int latitude=0; latitude<numLatitude; latitude++)
			{								
				//********************************************************
				// Create the points that will create the Dome
				//********************************************************
				double radiansLatitude =  Math.toRadians(angleLatitude);
				double radiansLongitude =  Math.toRadians(angleLongitude);
				
				if (longitude == 0 && latitude == 0) {
					System.out.println("Latitude: " + angleLatitude + " Longitude: " + angleLongitude);
					System.out.println("radiansLatitude: " + radiansLatitude + " radiansLongitude: " + radiansLongitude);
				}
				
				// Calculate sine and cosine of longitude and lattitude
				double cosLat = MathUtils.round(Math.cos(radiansLatitude), 8);
				double cosLong = MathUtils.round(Math.cos(radiansLongitude), 8);
				double sinLong = MathUtils.round(Math.sin(radiansLongitude), 8);
				double sinLat = MathUtils.round(Math.sin(radiansLatitude), 8);
						
				// Using Sphere equation, Calculate the points that comprise the dome
				double xPos = MathUtils.round(((radius) * (cosLat * sinLong)), 8);  
				double yPos = MathUtils.round(((radius) * cosLong), 8);
				double zPos = MathUtils.round(((radius) * (sinLat * sinLong)), 8); 
				
				if (longitude == 0 && latitude == 0)
				System.out.println("GeneratedDome Point: " + xPos +   ",   " + yPos + ",   " + zPos);
				
				// We have the point in respect to the origin, rotate it using the orientation.  
				rotationAngle = bioMightOrientation.getDegrees();
				domeDegrees = MathUtils.round(Math.toDegrees(rotationAngle), 4);
				//System.out.println("Dome Rotation Angle: " + rotationAngle + "  In Degrees: " +  domeDegrees);
				
				calculatedPoint =  BioGraphics.applyRotation(new double [][] {{xPos, yPos, zPos}}, -1, domeDegrees, new double [] {bioMightOrientation.getXAxis(), bioMightOrientation.getYAxis(), bioMightOrientation.getZAxis()} );
				
				// Extract the computed values
				xPosCalc = calculatedPoint[0][0]; 
				yPosCalc = calculatedPoint[0][1];
				zPosCalc = calculatedPoint[0][2]; 
		
				// Displace the points based on the start position
				// If there is an isssue, use the translation function
				xPos = xPosCalc + xStartPos;
				yPos = yPosCalc + yStartPos;
				zPos = zPosCalc + zStartPos;
	
				// Store all the latitude current points for the given longitude
				currentPoints[latitude][0] = xPos;
				currentPoints[latitude][1] = yPos;
				currentPoints[latitude][2] = zPos;
	
				if (longitude == 0 && latitude == 0)
				System.out.println("GeneratedDome Rotated Point: " + xPos +   ",   " + yPos + ",   " + zPos);
	

				bSpikes = true;
				if (bSpikes)
				{
					if (longitude == 0 && (latitude == 0 || latitude == 1))
					{							
			
					
					// Set the Orientation of the Cylinder on the surface of the Sphere
					// We create- a perpindicular and then rotate out by the Longitudenal angle					
	
					//************************************************************************
					// Perpindicular
					// Set the Orientation of the Cylinder on the surface of the Sphere
					// We create a perpindicular and then rotate out by the Longitudinal angle
					//************************************************************************
										
					double perpindick= angleLatitude+90;
			
					double perpindickRadians = Math.toRadians(perpindick);
					System.out.println("ORIENT Cylinder about " + angleLatitude + "  " + perpindick + "   radians: " + perpindickRadians);
		
					// Calculate sine and cosine of longitude and lattitude
					double cosLatSpike = MathUtils.round(Math.cos(perpindickRadians), 8);
					double cosLongSpike = MathUtils.round(Math.cos(radiansLongitude), 8);
					double sinLongSpike = MathUtils.round(Math.sin(radiansLongitude), 8);
					double sinLatSpike = MathUtils.round(Math.sin(perpindickRadians), 8);
							
					// Calculate the points that comprise the dome
					double xOrient = MathUtils.round(((radius) * (cosLatSpike * sinLongSpike)), 8);  
					double yOrient = MathUtils.round(((radius) * cosLongSpike), 8);
					double zOrient = MathUtils.round(((radius) * (sinLatSpike * sinLongSpike)), 8); 
					System.out.println("RotateVector: " + xOrient +   ",   " + yOrient + ",   " + zOrient);

					//double xOrient =  MathUtils.round(radius * Math.cos(perpindickRadians), 8);
					//double yOrient =  MathUtils.round(radius * Math.sin(perpindickRadians), 8);;  
					//double zOrient =  0;  
	
					//calculatedPoint =  BioGraphics.rotateArbitrary(new double [][] {{xOrient, yOrient, zOrient}}, domeDegrees, new double [] {bioMightOrientation.getXAxis(), bioMightOrientation.getYAxis(), bioMightOrientation.getZAxis()} );
					calculatedPoint =  BioGraphics.applyRotation(new double [][] {{xOrient, yOrient, zOrient}}, -1, domeDegrees, new double [] {-1, 0, 0} );
													
					// Extract the computed values
					double xOrientRot = 0; //calculatedPoint[0][0] + xStartPos; 
					double yOrientRot = 0; //calculatedPoint[0][1] + yStartPos;
					double zOrientRot = -radius; //calculatedPoint[0][2] + zStartPos;  
					System.out.println("RotateVector Rotated + StartPos: " + xOrientRot +   ",   " + yOrientRot + ",   " + zOrientRot);
					
					
					double degrees = -radiansLongitude;	
					double spikeDegrees = -radiansLongitude;	

										
					//***************************************************************
					// SPHERE 
					// Pop out a sphere at the base position
					//***************************************************************
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
						    "transparency='" 		+ "0.0" + "'\n" +
						    "diffuseColor='" + 
						 	    0.35 + " " + 
						 	    0.50 + " " +
						 	    0.30 + "'/>\n" +
						 	"</Appearance>\n" +
						 	"<Sphere DEF='StartSphere'\n" +
						 	"containerField='geometry'\n" +
						 	"radius='" + spikeRadius +"'/>\n" +
						 	"</Shape>\n" +
						 	
							"\n<TouchSensor DEF='TSENSOR_" + bioMightTransform.getId() + "' \n" +
				               " description='BacillusAnthracis'\n" +
				               " containerField='children'/> \n" +

						 "</Transform>\n";
		
									
						//***************************************************************
						// SPHERE 
						// Pop out a sphere at the base position + 90 rotated
						//***************************************************************
				
						body += "<Transform DEF='TRANSFORM_STARTSPHERE'\n";
						
						body += "translation='" 
									+ xOrient  + " " 
				 					+ yOrient + " "
				 					+ zOrient + "'\n";				
						
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
						    "transparency='" 		+ "0.25" + "'\n" +
						    "diffuseColor='" + 
						 	    0.0 + " " + 
						 	    0.0 + " " +
						 	    1.0 + "'/>\n" +
						 	"</Appearance>\n" +
						 	"<Sphere DEF='StartSphere'\n" +
						 	"containerField='geometry'\n" +
						 	"radius='" + spikeRadius +"'/>\n" +
						 	"</Shape>\n" +
						 	
	
 						"</Transform>\n";
					
						
						body += "<Transform DEF='TRANSFORM_STARTSPHERE'\n";
						
						body += "translation='" 
									+ xOrientRot  + " " 
				 					+ yOrientRot + " "
				 					+ zOrientRot + "'\n";				
						
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
						    "transparency='" 		+ "0.25" + "'\n" +
						    "diffuseColor='" + 
						 	    1.0 + " " + 
						 	    0.0 + " " +
						 	    0.0 + "'/>\n" +
						 	"</Appearance>\n" +
						 	"<Sphere DEF='StartSphere'\n" +
						 	"containerField='geometry'\n" +
						 	"radius='" + perpRadius +"'/>\n" +
						 	"</Shape>\n" +
						 	
	
 						"</Transform>\n";

						
						body += 
								"<Shape> \n" +				 	    
									"<LineSet vertexCount='2'> \n" +
									"<Coordinate point='0 0 0  0 1.25 0 '/> \n" +
									"</LineSet> \n" +
								"</Shape> \n";
								
								
					
						body += 
								"<Shape> \n" +
									"<LineSet vertexCount='2'> \n" +
									"<Coordinate point='0 0 0 0.75 0 0 '/> \n" +
									"</LineSet> \n" +
								"</Shape> \n";
						
						
						body += 
								"<Shape> \n" +
									"<LineSet vertexCount='2'> \n" +
									"<Coordinate point='0 0 0 0 0 1.0 '/> \n" +
									"</LineSet> \n" +
								"</Shape> \n";
						
						
						body += 
							"<Shape> \n" +
								"<LineSet vertexCount='2'> \n" +
								"<Coordinate point='0 0 0 " +  xOrientRot + " " + yOrientRot + " " + zOrientRot + "'/> \n" +
								"</LineSet> \n" +
							"</Shape> \n";
												
					
						BioMightPosition bioMightSpikePosition = new BioMightPosition(xPos, yPos, zPos);
						//BioMightOrientation bioMightOrientationSpike =  new BioMightOrientation(xOrientRot, 0, zOrientRot, 0);
						//body += generateDomeSpikes(bioMightTransform,  bioMightSpikePosition, bioMightOrientationSpike);
						
						BioMightOrientation bioMightOrientationSpike1 =  new BioMightOrientation(xOrientRot, yOrientRot, zOrientRot, degrees);
						System.out.println("ORIENT DOMESPIKE : " + bioMightOrientation.getXAxis() + "  " + bioMightOrientation.getYAxis()  + "  " + bioMightOrientation.getZAxis()  + "  " + degrees );
						body += generateDomeSpikes(bioMightTransform,  bioMightSpikePosition, bioMightOrientationSpike1);

						
						BioMightOrientation bioMightOrientationSpike2 =  new BioMightOrientation(xOrientRot, yOrientRot, zOrientRot, 1.57);
						body += generateDomeSpikes(bioMightTransform,  bioMightSpikePosition, bioMightOrientationSpike2);

						//BioMightOrientation bioMightOrientationSpike3 =  new BioMightOrientation(0, yOrientRot, zOrientRot, 0.707);
						//body += generateDomeSpikes(bioMightTransform,  bioMightSpikePosition, bioMightOrientationSpike3);

					}
				}
				
	    		// Increase the angle on the arc that goes from left to right
	    		angleLatitude += rotateLatitude;
	    		//System.out.println("Incremented Latitude Angle: " + angleLatitude);
			}
		
			
			// On Every Longitutde, Connect the previous row with the current row
			// On the first instance, we connect to the Pole to which the Sphere
			// is oriented
			String indexStr = "";
			String coordIndexStr = "";
			String topRowVertices = "";
			String bottomRowVertices = "";
			
			
			if (longitude < 1)
			{
				// Connect to the pole
				System.out.println("Connecting Longitude-1 to POLE: " + bioMightOrientation.getDegrees() );

				// Connect up the pole and the current.	
				// Set up Vertices for (0, radius, 0) - the North Pole
				if (bioMightOrientation.getDegrees() > 3.0)
					topRowVertices = "\n" + xPolePos  + ", " +  yPolePos + ", " + zPolePos;
					//topRowVertices = "\n" + xStartPos  + ", " +  (radius-yStartPos) + ", " + zStartPos;
				else
					topRowVertices = "\n" + xPolePos  + ", " +  yPolePos + ", " + zPolePos;	
					//topRowVertices = "\n" + xStartPos  + ", " +  (radius+yStartPos) + ", " + zStartPos;
				
				for (int latitude=0; latitude<numLatitude; latitude++)
				{
					// Build the bottom row of vertices
					if (latitude==0)
						bottomRowVertices = "\n" + currentPoints[latitude][0]  + ", " +  currentPoints[latitude][1] + ", " + currentPoints[latitude][2];
						//coordinateString = centerPointStr + ", \n" + cyPoints[k][0]  + ", " +  cyPoints[k][1] + ", " + cyPoints[k][2];
					else
						bottomRowVertices += ",\n  " + currentPoints[latitude][0]  + ",  " +  currentPoints[latitude][1] + ",  " + currentPoints[latitude][2];		
				
				}
				
				coordIndexStr = topRowVertices + "," + bottomRowVertices;
				//System.out.println("NUM COORDS: " + currentPoints.length  + "    "  + currentPoints.length );
				//System.out.println("COORDS are: " + coordIndexStr);
				
			
				// Now connect the points together
				for (int latitude=0; latitude<numLatitude; latitude++)
				{
					
					if (latitude==(numLatitude-2))
					{	
						indexStr += " " +  
								 0  + "  " +
							     1	+ "  " +
								12	+ "  -1";
					}	
					else if (latitude==(numLatitude-1))
					{	
						indexStr += " " +  
								 0       		+ "  " +
							     12	+ "  " +
								 11	+ "  -1";
					}
					else
					{	
						indexStr += " " +  
								 0       		+ "  " +
								(latitude+2) 	+ "  " +
								(latitude+1)	+ "  -1";
					}
				}
				
			}
			//*******************************************************************
			//
			// Now we have bottom and top rows so a connection can be made
			//
			//*******************************************************************
			else 
			{
				// Connect up the last and current.		
				// Linearly store the Vertices
				// Load the coordinates/vertices for first row
				for (int latitude=0; latitude<numLatitude; latitude++)
				{
					/// build the top row
					if (latitude==0)
						topRowVertices = "\n" + currentPoints[latitude][0]  + ", " +  currentPoints[latitude][1] + ", " + currentPoints[latitude][2];
						//coordinateString = centerPointStr + ", \n" + cyPoints[k][0]  + ", " +  cyPoints[k][1] + ", " + cyPoints[k][2];
					else
						topRowVertices += ",\n  " + currentPoints[latitude][0]  + ",  " +  currentPoints[latitude][1] + ",  " + currentPoints[latitude][2];		
			
					// Buid the bottom row
					if (latitude==0)
						bottomRowVertices = "\n" + lastPoints[latitude][0]  + ", " +  lastPoints[latitude][1] + ", " + lastPoints[latitude][2];
						//coordinateString = centerPointStr + ", \n" + cyPoints[k][0]  + ", " +  cyPoints[k][1] + ", " + cyPoints[k][2];
					else
						bottomRowVertices += ",\n  " + lastPoints[latitude][0]  + ",  " +  lastPoints[latitude][1] + ",  " + lastPoints[latitude][2];		
				
				}
				
				
				coordIndexStr = topRowVertices + "," + bottomRowVertices;
				//System.out.println("NUM COORDS: " + currentPoints.length  + "    "  + currentPoints.length );
				//System.out.println("COORDS are: " + coordIndexStr);
								
				

				// Now connect the points together
				
				for (int latitude=0; latitude<numLatitude; latitude++)
				{
					
					if (latitude==0)
					{	
						indexStr = " " +  
								(latitude+1)     			+ "  " +
								 latitude 					+ "  " +
								(latitude+numLatitude) 		+ "  " +
								(latitude+numLatitude+1)	+ "  -1";
					}	
					else if (latitude==(numLatitude-1))
					{	
						indexStr += ", " +  
								0    			+ "  " +
								(numLatitude-1) + "  " +
								(2*numLatitude-1) 	+ "  " +
								numLatitude + "  -1";
					}
					else
					{	
						indexStr += ", " +  
								(latitude+1) 		+ "  " +
								 latitude 			+ "  " +
								(latitude+numLatitude) + "  " +
								(latitude+numLatitude+1) + "  -1";
					}
				}

				
			}
			//System.out.println("********* Index is: " + indexStr);	
						
				
			
				String componentType = "DomeCap";
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
			
				//body+= " <ImageTexture containerField='texture' " +
				//	    " url='../images/MembraneColor.jpg'/>";
				
			 	body+= " <Material DEF='Rust'\n" +
				    "containerField='material'\n" +
				    "ambientIntensity='" + bioMightTransform.getMaterial().getAmbientIntensity() + "'\n" +
				    "shininess='" 		 + bioMightTransform.getMaterial().getShininess() + "'\n" +
				    "transparency='" 	 + 0.50 + "'\n" +
				    "diffuseColor='" + 
				    0.0 + " " + 
				    0.20 + " " +
				    0.40 + "'/>\n" +
				 	"</Appearance>\n" +
				    
				  	
				 	"<IndexedFaceSet DEF='DomeCapIFS' \n" +
				    	   "containerField='geometry' \n" +
				    	   "creaseAngle='" +  bioMightTransform.getCreaseAngle() + "'\n" +
				    	   "solid='false' \n" +
				    	   "coordIndex='" + indexStr + "'>" +
				    	   "<Coordinate DEF='AdenoVirusCap_Coord' \n" + 
				    	    "containerField='coord' point='" + coordIndexStr + "'/>" +
				    	  "</IndexedFaceSet>\n" +
				    
				    	 "</Shape>\n" +
				    	 
				    	 "<TouchSensor DEF='StartEndothelium' \n" +
		                   " description='" + componentType + "'\n" +
			               " containerField='children'/> \n" +
				    	 
				"</Transform>\n"; 
			
			
				
				// Store all the latitude points for future use
				for (int latitude=0; latitude<numLatitude; latitude++)
				{
					lastPoints[latitude][0] = currentPoints[latitude][0];
					lastPoints[latitude][1] = currentPoints[latitude][1];
					lastPoints[latitude][2] = currentPoints[latitude][2];
				}
	
			}
						
			// Increase the angle on the Arc that goes top to bottom
			angleLongitude += rotateLongitude;
			//System.out.println("Incremented Longtitude Angle: " + angleLatitude);
		}

		
		
		return (body);		
	}
 	
  	
  
	/***********************************************************************************************************************
  	 * GENERATE DOME SPIKES
  	 * 
  	 * This metod will add spikes to a generated dome.   It places them on the calcuated vertices
  	 * 
  	 * @param bioMightTransform
  	 * @param currentPoints
  	 * @param bHeader
  	 * @param bFooter
  	 * @param diffColor
  	 * @return
  	 ***********************************************************************************************************************/
	
  	public static String generateDomeSpikes(BioMightTransform bioMightTransform,  BioMightPosition startPos, BioMightOrientation bioMightOrientation) 	
	{	
	  	String body = "";
		int numLongitude = 12;
		int numLatitude = 12;

		double xOrient = bioMightOrientation.getXAxis();
		double yOrient = bioMightOrientation.getYAxis();
		double zOrient = bioMightOrientation.getZAxis();
		double degrees = bioMightOrientation.getDegrees();
				
		double radius = (bioMightTransform.getRadius()/100);
		double height =  bioMightTransform.getHeight();
	
		double spikeHeight =  0.175;
		double spikeRadius = 0.00825;
		double halfSpike = MathUtils.round(spikeHeight/2, 8);
		
		double xStartPos = startPos.getXPos(); 
		double yStartPos = startPos.getYPos(); 
		double zStartPos = startPos.getZPos();
		System.out.println("GenerateDomeSpike()  at: " + xStartPos +   ",   " + yStartPos + ",   " + zStartPos);
			
		String bioGroup = "FlagellaGroup";
		BioMightTransform baseTransform = bioMightTransform;
		
		double[][] lastPoints = new double [numLatitude][3];
		double[][] currentPoints = new double [numLatitude][3];		
	
		//***************************************************************
		// SPHERE 
		// Pop out a sphere at the specified position
		//***************************************************************
		body += "<Transform DEF='TRANSFORM_STARTSPHERE'\n";
	
		body += "translation='" 
					+ xStartPos  + " " 
 					+ yStartPos + " "
 					+ zStartPos + "'\n";				
		
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
		 	"radius='" + spikeRadius +"'/>\n" +
		 	"</Shape>\n" +
		 	
			"\n<TouchSensor DEF='TSENSOR_" + bioMightTransform.getId() + "' \n" +
               " description='BacillusAnthracis'\n" +
               " containerField='children'/> \n" +

		 "</Transform>\n";
		//****************************************************************************

		baseTransform = bioMightTransform;
		//body += "\n\n</Transform>\n\n";
							
		// Set up a Group around the whole spike
		bioGroup = "FlagellaGroup" + "L" +   "L";
		//body += "\n<Transform DEF='" + bioGroup + "'\n";
		//body += "  translation='" + bioMightTransform.getTranslation().getPositionStr() +  "'>\n\n";
	
		

		//******************************************
		// Create The Base Cylindrical Spike
		///*****************************************
		body += "<Transform DEF='TRANSFORM_" + bioMightTransform.getId() + "' \n";
	 	body += "translation='" 
	 		+ xStartPos + " " 
			+ yStartPos + " "
			+ zStartPos + "'\n";					
	
		body +=  "rotation='" 
			+ xOrient + " "
			+ yOrient + " "
			+ zOrient + " "
			+ degrees + "'\n"
			+ "\n";
		
		body +=  "scale='1 1 1'>\n\n" +
		
		 	"<Shape DEF='SHAPE_" + bioMightTransform.getId() + "' \n" +
		    " containerField='children'>\n" +
		    " <Appearance\n" +
		    "  containerField='appearance'>\n";
	
		
		body+= " <Material DEF='Rust'\n" +
		    "containerField='material'\n" +
		    "ambientIntensity='" 	+ bioMightTransform.getMaterial().getAmbientIntensity() + "'\n" +
		    "shininess='" 			+ bioMightTransform.getMaterial().getShininess() + "'\n" +
		    "transparency='" 		+ 0.25 + "'\n" +
		    "diffuseColor='0.40  0.20  0.30'/>\n" +
		 	"</Appearance>\n" +
		
		 	"<Cylinder DEF='GlycoProteinBaseSpike'\n" +
		 	"containerField='geometry'\n" +
		 	"radius='" + spikeRadius +"'\n" +
		 	"height='" + spikeHeight +"'/>\n" +
		 	"</Shape>\n" +
		 "</Transform>\n";
		
		
		/***************
		
					
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
					System.out.println("StartPoint (SphereCenter): " + xSpikePos + "  " + xSpikePos +  "  " +  xSpikePos);
				
				
					// Displace these as well
					xSpikePos = xSpikePos + xStartPos;
					ySpikePos = ySpikePos + yStartPos;
					zSpikePos = zSpikePos + zStartPos;
			
					
					//System.out.println("Cos(Lat): " + cosLat + " Sin(Lat): " + sinLat + "            Sin(Long): " + sinLong + "  cos(Long): " + cosLong);
					//System.out.println("XPOS: " + xPos + "=  Cos(Lat): " + cosLat + " Sin(Long): " + sinLong);
					//System.out.println("YPOS: " + yPos + "=  Sin(Lat): " + sinLat + " Cos(Long): " + cosLong);
					//System.out.println("ZPOS: " + zPos + "=  Cos(Long): " + cosLong);
			
					// Run through the segments that make this string of cells
					int randoLength = new Double(MathUtils.round(Math.random()*5, 0)).intValue();
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
						// Create SPHERE connector where the position is
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
						 
						 	// SPHERE ----
						 	"<Sphere DEF='StartSphere't\n" +
						 	"containerField='geometry'\n" +
						 	"radius='" + spikeRadius +"'/>\n" +
						 	"</Shape>\n" +
						 	
							//"\n<TouchSensor DEF='TSENSOR_" + bioMightTransform.getId() + "' \n" +
			                //  " description='BacillusAnthracis'\n" +
				            //   " containerField='children'/> \n" +
			
						 "</Transform>\n";

					
						//*************************************************************
						// Create the Cylinder and displace it so that its begin point
						//  moves to natural centerpoint of the cylinder
						//*************************************************************			

						// Convert the degrees to radians	
						double calculatedPoint[][] =  BioGraphics.applyRotation(new double [][] {{0, halfSpike, 0}}, MathUtils.round(Math.toDegrees(spikeDegrees), 4), new double [] {xOrient, yOrient, zOrient} );
								
						// Extract the computed values
						double xPosCalc = calculatedPoint[0][0]; 
						double yPosCalc = calculatedPoint[0][1];
						double zPosCalc = calculatedPoint[0][2]; 

						// The Constant Point based on the Sphere Equation
						System.out.println("Spike StartPoint (Center): " + xSpikePos + "  " + xSpikePos +  "  " +  xSpikePos);
						System.out.println("Calculated CenterPoint Translate : " + xPosCalc + "  " + yPosCalc +  "  " +  zPosCalc);
						double newPoints[] = BioGraphics.applyTranslation(new double [] {xSpikePos, ySpikePos, zSpikePos}, new double [] {xPosCalc, yPosCalc, zPosCalc});
					
						double xCurSpikePos = newPoints[0];
						double yCurSpikePos = newPoints[1];
						double zCurSpikePos = newPoints[2];
						System.out.println("New CenterPoint: " + xCurSpikePos + "  " + yCurSpikePos +  "  " +  zCurSpikePos);
						
						
						// Set up the EndPoint/BeginPoint for the next Cylinder.   We should need to displace the distance twice
						// as the endpoint is twice the distance of what we are currently at.	    
						newPoints = BioGraphics.applyTranslation(new double [] {xSpikePos, ySpikePos, zSpikePos}, new double [] {2*xPosCalc, 2*yPosCalc, 2*zPosCalc} );
						xSpikePos = newPoints[0];
						ySpikePos = newPoints[1];
						zSpikePos = newPoints[2];
					    System.out.println("X Y Z for Spike Updated: " + xSpikePos + "  " + ySpikePos +  "  " +  zSpikePos);
						
					
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
								+ spikeDegrees + "'>\n\n";
			
						 					
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
					//body += animate(bioGroup, baseTransform);
				}
				
					
	    		// Increase the angle on the arc that goes from left to right
	    		angleLatitude += rotateLatitude;
	    		//System.out.println("Incremented Latitude Angle: " + angleLatitude);
			}
		
			
			// On Every Longitutde, Connect the previous row with the current row
			// On the first instance, we connect to the Pole to which the Sphere
			// is oriented
			String indexStr = "";
			String coordIndexStr = "";
			String topRowVertices = "";
			String bottomRowVertices = "";
			
			
			if (longitude < 1)
			{
				// Connect to the pole
				System.out.println("Connecting Longitude-1 to POLE");

				// Connect up the pole and the current.	
				// Set up Vertices for (0, radius, 0) - the North Pole
				topRowVertices = "\n" + xStartPos  + ", " +  (radius+yStartPos) + ", " + zStartPos;	

				for (int latitude=0; latitude<numLatitude; latitude++)
				{
					// Build the bottom row of vertices
					if (latitude==0)
						bottomRowVertices = "\n" + currentPoints[latitude][0]  + ", " +  currentPoints[latitude][1] + ", " + currentPoints[latitude][2];
						//coordinateString = centerPointStr + ", \n" + cyPoints[k][0]  + ", " +  cyPoints[k][1] + ", " + cyPoints[k][2];
					else
						bottomRowVertices += ",\n  " + currentPoints[latitude][0]  + ",  " +  currentPoints[latitude][1] + ",  " + currentPoints[latitude][2];		
				
				}
				
				coordIndexStr = topRowVertices + "," + bottomRowVertices;
				//System.out.println("NUM COORDS: " + currentPoints.length  + "    "  + currentPoints.length );
				//System.out.println("COORDS are: " + coordIndexStr);
				
			
				// Now connect the points together
				
				for (int latitude=0; latitude<numLatitude; latitude++)
				{
					
					if (latitude==(numLatitude-2))
					{	
						indexStr += " " +  
								 0       		+ "  " +
							     1	+ "  " +
								12	+ "  -1";
					}	
					else if (latitude==(numLatitude-1))
					{	
						indexStr += " " +  
								 0       		+ "  " +
							     12	+ "  " +
								 11	+ "  -1";
					}
					else
					{	
						indexStr += " " +  
								 0       		+ "  " +
								(latitude+2) 	+ "  " +
								(latitude+1)	+ "  -1";
					}
				}
					
				
				
			}
			//*******************************************************************
			//
			//Now we have bottom and top rows so a connection can be made
			//
			//*******************************************************************
			else 
			{
				// Connect up the last and current.		
				// Linearly store the Vertices
				// Load the coordinates/vertices for first row
				for (int latitude=0; latitude<numLatitude; latitude++)
				{
					/// build the top row
					if (latitude==0)
						topRowVertices = "\n" + currentPoints[latitude][0]  + ", " +  currentPoints[latitude][1] + ", " + currentPoints[latitude][2];
						//coordinateString = centerPointStr + ", \n" + cyPoints[k][0]  + ", " +  cyPoints[k][1] + ", " + cyPoints[k][2];
					else
						topRowVertices += ",\n  " + currentPoints[latitude][0]  + ",  " +  currentPoints[latitude][1] + ",  " + currentPoints[latitude][2];		
			
					// Buid the bottom row
					if (latitude==0)
						bottomRowVertices = "\n" + lastPoints[latitude][0]  + ", " +  lastPoints[latitude][1] + ", " + lastPoints[latitude][2];
						//coordinateString = centerPointStr + ", \n" + cyPoints[k][0]  + ", " +  cyPoints[k][1] + ", " + cyPoints[k][2];
					else
						bottomRowVertices += ",\n  " + lastPoints[latitude][0]  + ",  " +  lastPoints[latitude][1] + ",  " + lastPoints[latitude][2];		
				
				}
				
				
				coordIndexStr = topRowVertices + "," + bottomRowVertices;
				System.out.println("NUM COORDS: " + currentPoints.length  + "    "  + currentPoints.length );
				System.out.println("COORDS are: " + coordIndexStr);
								
				

				// Now connect the points together
				
				for (int latitude=0; latitude<numLatitude; latitude++)
				{
					
					if (latitude==0)
					{	
						indexStr = " " +  
								(latitude+1)     			+ "  " +
								 latitude 					+ "  " +
								(latitude+numLatitude) 		+ "  " +
								(latitude+numLatitude+1)	+ "  -1";
					}	
					else if (latitude==(numLatitude-1))
					{	
						indexStr += ", " +  
								0    			+ "  " +
								(numLatitude-1) + "  " +
								(2*numLatitude-1) 	+ "  " +
								numLatitude + "  -1";
					}
					else
					{	
						indexStr += ", " +  
								(latitude+1) 		+ "  " +
								 latitude 			+ "  " +
								(latitude+numLatitude) + "  " +
								(latitude+numLatitude+1) + "  -1";
					}
				}

				
			}
			System.out.println("********* Index is: " + indexStr);	
						
				
			
				String componentType = "DomeCap";
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
			
				body+= " <ImageTexture containerField='texture' " +
					    " url='../images/MembraneColor.jpg'/>";
				
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
				    
				  	
				 	"<IndexedFaceSet DEF='DomeCapIFS' \n" +
				    	   "containerField='geometry' \n" +
				    	   "creaseAngle='" +  bioMightTransform.getCreaseAngle() + "'\n" +
				    	      "solid='false' \n" +
				    	   "coordIndex='" + indexStr + "'>" +
				    	   "<Coordinate DEF='AdenoVirusCap_Coord' \n" + 
				    	    "containerField='coord' point='" + coordIndexStr + "'/>" +
				    	  "</IndexedFaceSet>\n" +
				    
				    	 "</Shape>\n" +
				    	 
				    	 "<TouchSensor DEF='StartEndothelium' \n" +
		                   " description='" + componentType + "'\n" +
			               " containerField='children'/> \n" +
				    	 
				"</Transform>\n"; 
			
			
			
			
			
			// Store all the latitude points for future use
			for (int latitude=0; latitude<numLatitude; latitude++)
			{
				lastPoints[latitude][0] = currentPoints[latitude][0];
				lastPoints[latitude][1] = currentPoints[latitude][1];
				lastPoints[latitude][2] = currentPoints[latitude][2];
		
			}
	
			}
						
			// Increase the angle on the Arc that goes top to bottom
			angleLongitude += rotateLongitude;
			//System.out.println("Incremented Longtitude Angle: " + angleLatitude);
		}

		******************************/
	
		//body += "\n\n</Transform>\n\n";	
		
		return (body);		
	}



	/***********************************************************************************************************************
  	 * CREATE DOME SPIKES
  	 * 
  	 * This method will add spikes to a generated Rod.   It places them on the outside of the cylinder.  It can
  	 * variate the axial point so that randomness is interoduced to the model
  	 * 
  	 * @param bioMightTransform
  	 * @param currentPoints
  	 * @param bHeader
  	 * @param bFooter
  	 * @param diffColor
  	 * @return
  	 ***********************************************************************************************************************/
	
  	public static String generateRodSpikes(BioMightTransform bioMightTransform,  BioMightPosition startPos, BioMightOrientation bioMightOrientation, boolean bSpikes) 	
	{	
	  	String body = "";
	
	  	
	  	
	  	
	  /*****	
	  	
	  	
		// Set up a Group around the whole spike
		String bioGroup = "FlagellaGroup" + "L" + longitude + "L" + latitude;
		body += "\n<Transform DEF='" + bioGroup + "'\n";
		body += "  translation='" + bioMightTransform.getTranslation().getPositionStr() +  "'>\n\n";
	
		
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
			+ degrees + "'>\n"
					+ "\n";
		
		body +=  "scale='1 1 1'>\n" +
		 	"<Shape DEF='SHAPE_" + bioMightTransform.getId() + (longitude * latitude) + "' \n" +
		    " containerField='children'>\n" +
		    " <Appearance\n" +
		    "  containerField='appearance'>\n";

		body+= " <ImageTexture containerField='texture' " +
			    " url='../images/CellMembrane.jpg'/>";
		
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
		System.out.println("StartPoint (SphereCenter): " + xSpikePos + "  " + xSpikePos +  "  " +  xSpikePos);
	
	
		// Displace these as well
		xSpikePos = xSpikePos + xStartPos;
		ySpikePos = ySpikePos + yStartPos;
		zSpikePos = zSpikePos + zStartPos;

		
		//System.out.println("Cos(Lat): " + cosLat + " Sin(Lat): " + sinLat + "            Sin(Long): " + sinLong + "  cos(Long): " + cosLong);
		//System.out.println("XPOS: " + xPos + "=  Cos(Lat): " + cosLat + " Sin(Long): " + sinLong);
		//System.out.println("YPOS: " + yPos + "=  Sin(Lat): " + sinLat + " Cos(Long): " + cosLong);
		//System.out.println("ZPOS: " + zPos + "=  Cos(Long): " + cosLong);

		// Run through the segments that make this string of cells
		int randoLength = new Double(MathUtils.round(Math.random()*5, 0)).intValue();
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
			// Create SPHERE connector where the position is
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
			 
			 	// SPHERE ----
			 	"<Sphere DEF='StartSphere't\n" +
			 	"containerField='geometry'\n" +
			 	"radius='" + spikeRadius +"'/>\n" +
			 	"</Shape>\n" +
			 	
				//"\n<TouchSensor DEF='TSENSOR_" + bioMightTransform.getId() + "' \n" +
                //  " description='BacillusAnthracis'\n" +
	            //   " containerField='children'/> \n" +

			 "</Transform>\n";

		
			//*************************************************************
			// Create the Cylinder and displace it so that its begin point
			//  moves to natural centerpoint of the cylinder
			//*************************************************************			

			// Convert the degrees to radians	
			double calculatedPoint[][] =  BioGraphics.rotateArbitrary(new double [][] {{0, halfSpike, 0}}, MathUtils.round(Math.toDegrees(spikeDegrees), 4), new double [] {xOrient, yOrient, zOrient} );
					
			// Extract the computed values
			double xPosCalc = calculatedPoint[0][0]; 
			double yPosCalc = calculatedPoint[0][1];
			double zPosCalc = calculatedPoint[0][2]; 

			// The Constant Point based on the Sphere Equation
			System.out.println("Spike StartPoint (Center): " + xSpikePos + "  " + xSpikePos +  "  " +  xSpikePos);
			System.out.println("Calculated CenterPoint Translate : " + xPosCalc + "  " + yPosCalc +  "  " +  zPosCalc);
			double newPoints[] = BioGraphics.applyTranslation(new double [] {xSpikePos, ySpikePos, zSpikePos}, new double [] {xPosCalc, yPosCalc, zPosCalc});
		
			double xCurSpikePos = newPoints[0];
			double yCurSpikePos = newPoints[1];
			double zCurSpikePos = newPoints[2];
			System.out.println("New CenterPoint: " + xCurSpikePos + "  " + yCurSpikePos +  "  " +  zCurSpikePos);
			
			
			// Set up the EndPoint/BeginPoint for the next Cylinder.   We should need to displace the distance twice
			// as the endpoint is twice the distance of what we are currently at.	    
			newPoints = BioGraphics.applyTranslation(new double [] {xSpikePos, ySpikePos, zSpikePos}, new double [] {2*xPosCalc, 2*yPosCalc, 2*zPosCalc} );
			xSpikePos = newPoints[0];
			ySpikePos = newPoints[1];
			zSpikePos = newPoints[2];
		    System.out.println("X Y Z for Spike Updated: " + xSpikePos + "  " + ySpikePos +  "  " +  zSpikePos);
			
		
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
					+ spikeDegrees + "'>\n\n";

			 					
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
		//body += animate(bioGroup, baseTransform);
	
		***/  	
  	
	  	return(body);
	}
  	
  	

  	
	/******************************************************************************************
	 * ANIMATE FLAGELLA
	 *
	 * This method will animate  the component.  The input comes in through the methods
	 * that are presented on the view.  
	 *****************************************************************************************/
	
	private static String animate(String bioGroup, BioMightTransform baseTransform, int transformCount) {

		System.out.println("In Animate() Method");
		
		BioMightPosition bioMightPosition= baseTransform.getTranslation();
		System.out.println("Have Position");

		BioMightScale bioMightScale= baseTransform.getScale();		
		System.out.println("Have Scale");

		BioMightOrientation bioMightOrientationStart =  new BioMightOrientation("0.0, 1.0, 0.0, 0.0");
		BioMightOrientation bioMightOrientationEnd = new BioMightOrientation("0.0, 1.0, 0.0, 0.05");
		

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

		bioGroup += "_" + transformCount;
		String bioTimer = bioGroup + "_Timer";
		body += "\n<TimeSensor DEF='" + bioTimer + "'\n"
				+ " containerField='children'\n "
				+ " cycleInterval='" + 0.6 + "'\n "
				+ " loop='true' \n"
				+ " startTime='0.0'/> \n\n";


		System.out.println("\n\n SETup HEADER");
		
		// Setup a Script that will set the TimeStart for each
		// of
		// the animation events.
		String bioScript = bioGroup + "_flagellaScript";
		body += "<Script DEF='" + bioScript + "'>\n";

		String bioScriptStartTime = bioGroup + "_flagellaScriptStartTime";
		body += "<field name='flagellaScriptStartTime"
				+ "'  type='SFTime' accessType='outputOnly'/>\n";


		System.out.println("\n\n Setup START");
		
		String bioScriptEndTime = bioGroup + "_flagellaScriptEndTime";
		body += "<field name='flagellaScriptEndTime "
				+ "'  type='SFTime' accessType='outputOnly'/>\n";

		String bioScriptTimeVar = bioGroup + "_flagellaScriptTimeVar";
		//body += "\n<![CDATA[\n" + "ecmascript:\n"
		//		+ "function initialize_"   + bioGroup + "() {\n" + "var "
		//		+ bioScriptTimeVar
		//		+ "= new Date().getTime() + " + startTime
		//		+ ";\n" + bioScriptStartTime + " = "
		//		+ bioScriptTimeVar + ";	\n" + "}\n" + "]]>\n"
		body +=  "</Script>\n\n";


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


		System.out.println("\n\n In Gonnoreah Bacteria, BODY: " + body);
		return (body);
	}


	/***********************************************************************************************************************
  	 * GENERATE TUBES
  	 * 
  	 * Creates an arc
  	 * 
  	 * @param bioMightTransform
  	 * @param currentPoints
  	 * @param bHeader
  	 * @param bFooter
  	 * @param diffColor
  	 * @return
  	 ***********************************************************************************************************************/
	
  	public static String generateTubes(BioMightTransform bioMightTransform,  BioMightPosition startPos, BioMightOrientation bioMightOrientation, boolean bSpikes) 	
	{		
	  	String body = "";
		int numLongitude = 24;
		int numLatitude = 24;
		
		int longitudeSections = 4;
		int arcSections = 2;
		
		double rotateLatitude = 360/numLatitude;
		double rotateLongitude = 360/numLongitude;
		double angleLongitude = rotateLongitude*3;
	
		// Use the radius of the cylinder
		double radius = 0.35; //(bioMightTransform.getRadius());
		
		double xStartPos = 0.225; //startPos.getXPos(); 
		double yStartPos = 0;     //startPos.getYPos(); 
		double zStartPos = 0;     //startPos.getZPos();
		System.out.println("\n\nGenerateTube() at Start Position: " + xStartPos +   ",   " + yStartPos + ",   " + zStartPos + "  with radius: " + radius);
			
			
		// Set up initialization table for latitiude displacement
		// so that the sections have some variation
		//int latitudeStart[] = {0, 0, 15, 15, 25, 25};
		int latitudeStart[] = {30, 28, 0, 0, 0, 0, 0, 0};
		
		int maxLatitudeSections = 5;
		int latitudeSections[] = {5, 5, 5, 5, 5};
		
		double angleLatitude = rotateLatitude;
		
		//body += "<Group DEF='" + "EndoGroup" + ">'\n";

		// Number of sides in the Tube
		int numPoints = 8;
		
		// The radius for each of the tubes 
		double tubeRadii[] = {
				// Arc 0, Longitude 0, Lat-0-4
				0.02, 0.03, 0.02, 0.03, 0.025, 
				
				// Arc 0, Longitude 1, Lat-0-4
				0.021, 0.03, 0.02, 0.03, .027,
				
				// Arc 0, Longitude 2, Lat-0-4
				0.025, 0.03, 0.02, 0.03, .027,
				
				// Arc 0, Longitude 3, Lat-0-4
				0.030, 0.03, 0.02, 0.03, .027,
				
				
				// Arc 1, Longitude 0, Lat-0-4
				0.02, 0.03, 0.02, 0.03, 0.025, 
				
				// Arc 1, Longitude 1, Lat-0-4
				0.021, 0.03, 0.02, 0.03, .027,
				
				// Arc 1, Longitude 2, Lat-0-4
				0.021, 0.03, 0.02, 0.03, .027,
				
				// Arc 1, Longitude 3, Lat-0-4
				0.021, 0.03, 0.02, 0.02, .030	
		};
		
		//double[][] tubeScale = BioGraphics.get8points();
		// 5 latitudes * 2 arcs
		double[][] tubeScale = { 
				
				// Arc 0, Long 0, Lat-0-4	
				{1.0,  0.25, 0.75},  // Tube 1, section 1
				{1.25, 1.0, 0.75},
				{1.30, 1.0, 0.55},
				{1.30, 1.0, 0.65},
				{1.30, 1.0, 0.75},

				// Arc 0, Long 1, Lat-0-4	
				{1.25, 0.25, 0.45},  // Tube 1, section 2
				{1.25, 1.0, 0.75},
				{1.30, 1.0, 0.55},
				{1.30, 1.0, 0.65},
				{1.30, 1.0, 0.75},
				
				// Arc 0, Long 2, Lat-0-4	
				{1.25, 0.25, 0.75},  // Tube 1, section 3
				{1.25, 1.0, 0.75},	 // Tube 2, section 3
				{1.30, 1.0, 0.55},   // Tube 3, section 3
				{1.30, 1.0, 0.65},   // Tube 4, section 3
				{1.30, 1.0, 0.75},   // Tube 5, section 3
				
				// Arc 0, Long 3, Lat-0-4	 
				{1.45, 0.25, 1.20},   // Tube 1, section 4
				{0.75, 1.0, 1.75},	  // Tube 2, section 4
				{1.80, 1.0, 0.55},	  // Tube 3, section 4
				{1.30, 1.0, 0.65},    // Tube 4, section 4
				{1.50, 1.0, 1.50},	  // Tube 5, section 4
			
				//*****************************
				// ARC 1
				//*****************************
				// Arc 1, Long 0, Lat-0-4	
				{1.25, 0.0, 0.45},
				{1.25, 1.0, 0.75},
				{1.30, 1.0, 0.55},
				{1.30, 1.0, 0.65},
				{1.30, 1.0, 0.75},

				// Arc 1, Long 1, Lat-0-4	
				{1.25, 1.0, 0.65},   // Tube 1, section 2
				{1.25, 1.0, 0.75},   // Tube 2, section 2
				{1.30, 1.0, 0.55},   // Tube 3, section 2
				{1.30, 1.0, 0.65},   // Tube 4, section 2
				{1.30, 1.0, 0.75},   // Tube 5, section 2
				
				// Arc 1, Long 2, Lat-0-4	
				{1.25, 1.0, 2.25},   // Tube 1, section 3
				{1.25, 1.0, 0.75},   // Tube 2, section 3
				{1.30, 1.0, 0.55},   // Tube 3, section 3
				{1.30, 1.0, 0.65},   // Tube 4, section 3
				{1.30, 1.0, 0.75},   // Tube 5, section 3
				
				// Arc 1, Long 3, Lat-0-4	
				{0.80, 1.0, 3.25},   // Tube 1, section 4
				{1.25, 1.0, 0.75},   // Tube 2, section 4
				{1.40, 1.0, 1.50},   // Tube 3, section 4
				{1.30, 1.0, 0.65},   // Tube 4, section 4
				{2.5, 1.0, 1.0}      // Tube 5, section 4
			
		};
		
		double[][] tubeDisplacePosition = { 
				
				// Arc 0, Long 0, Lat-0-4
				{-0.04,    -0.03,   0.0},	// Tube 1, section 1
				{0.0,      -0.03,   0.02},
				{0.0, 	   0.0,   0.02},
				{0.0, 	   0.0,   0.02},
				{0.0, 	   0.0,   0.02},
				
				// Arc 0, Long 1, Lat-0-4
				{-0.03,  0.00, 0.00},
				{0.0,   0.00,  0.02},
				{0.0,   0.00,  0.02},
				{0.0,   0.00,  0.02},
				{0.0,   0.00,  0.02},
				
				// Arc 0, Long 2, Lat-0-4
				{-0.03,  0.00,  0.00},
				{0.0,  0.00,  0.02},
				{0.0,  0.00,  0.02},
				{0.0,  0.00,  0.02},
				{0.0,  0.00,  0.02},
				
				// Arc 0, Long 3, Lat-0-4
				{-0.04,  0.00,   -0.03},    // Tube 1, section 4
				{0.00,  0.0,    0.00},   	// Tube 2, section 4
				{-0.01,  0.00,   0.02},     // Tube 3, section 4
				{0.0,    0.00,   0.02},     // Tube 4, section 4
				{0.0,    0.00,   0.06},     // Tube 5, section 4
				
				//******************************
				// ARC 1
				//******************************
				// Arc 1, Long 0, Lat-0-4
				// X moves it down, y moves in and out, z - left to right
				{0.0,   -0.0925,   0.0225},	  	// Tube 1, section 1
				{0.0,   -0.06,   0.08},	      	// Tube 2, section 1
			{0.0,   -0.04,   -0.02},       	// Tube 3, section 1
				{0.0,   -0.05,   -0.06},   		// Tube 4, section 1
				{0.0,   -0.04,   0.0},    		// Tube 5, section 1
				
				     
				// Arc 1, Long 1, Lat-0-4
				{-0.03, -0.05,   0.0},	// Tube 1, section 2
				{0.0,   -0.04,  0.04},
			{0.0,   -0.02,  -0.04},
				{0.0,   -0.02,  0.02},
				{0.0,   -0.02,  0.02},
				
				// Arc 1, Long 2, Lat-0-4
				{-0.02,    0.0,   0.0},	
				{0.0, 0.00, 0.02},
			{0.0, -0.02, 0.02},
				{0.0, 0.00, 0.02},
				{0.0, 0.00, 0.02},
		
				// Arc 1, Long 3, Lat-0-4
				{-0.02,    -0.03,   -0.04},	// Tube 1, Section 4
				{0.0, 0.00, 0.02},
			{0.0, -0.02, 0.02},
				{0.0, 0.00, 0.02},
				{0.06, 0.00, 0.06}
	
		};
		
		// The number of rows of tubes
		for (int arcs=0; arcs<arcSections; arcs++) 
		{
			angleLongitude = 30; // longitudeArc[arcs];
		
			// Store the points for the current longitude
			double[][][] lastPoints = new double [maxLatitudeSections][numPoints][3];		
	
			for (int longitude=0; longitude<longitudeSections; longitude++) 
			{
				// Run from left to right across the latitude separated points of the sphere
				// Vary the start position if desired
				angleLatitude = latitudeStart[arcs];
				
				radius+= 0.001;
				
				for (int latitude=0; latitude<latitudeSections[arcs]; latitude++)
				{						
					//********************************************************
					// Create the points that will create the Arc
					//********************************************************
					double radiansLatitude =  Math.toRadians(angleLatitude);
					double radiansLongitude =  Math.toRadians(angleLongitude);
					
					System.out.println("EndoPlasmic Tube Latitude: " + angleLatitude + " Longitude: " + angleLongitude);
					System.out.println("EndoPlasmic Tube radiansLatitude: " + radiansLatitude + " radiansLongitude: " + radiansLongitude);
					
					// Calculate sine and cosine of longitude and lattitude
					double cosLat = MathUtils.round(Math.cos(radiansLatitude), 8);
					double cosLong = MathUtils.round(Math.cos(radiansLongitude), 8);
					double sinLong = MathUtils.round(Math.sin(radiansLongitude), 8);
					double sinLat = MathUtils.round(Math.sin(radiansLatitude), 8);
							
					// Using Sphere equation, Calculate the points that comprise the dome
					double xPos = MathUtils.round(((radius) * (cosLat * sinLong)), 8);  
					double yPos = MathUtils.round(((radius) * cosLong), 8);
					double zPos = MathUtils.round(((radius) * (sinLat * sinLong)), 8); 
					
					System.out.println("GeneratedTube Point: " + xPos +   ",   " + yPos + ",   " + zPos);
					
					// Displace the points based on the start position
					// If there is an isssue, use the translation function
					xPos += xStartPos;
					yPos += yStartPos;
					zPos += zStartPos;
					
					System.out.println("GeneratedTube Point (with StartPos) : " + xPos +   ",   " + yPos + ",   " + zPos);
	
		    		// Vary the angle on the the latitude distance 
					angleLatitude += rotateLatitude;

					
				 	//***************************************************************
				 	// CREATE THE TUBE
					//
					// HARD CODED
				 	//
				 	//****************************************************************

					int arrayPos = arcs * (maxLatitudeSections*longitudeSections)  + (longitude*maxLatitudeSections + latitude);
	
					System.out.println("\nCreating Tube using ArrayPosition: " + arrayPos + " arc:  " + arcs + " maxLat: " + maxLatitudeSections + " + lat: " + latitude);
					
					System.out.println("Creating Tube with Radiii: " 
									+ tubeRadii[arrayPos]);
					
					System.out.println("Creating Tube with Scale: " 
									+ tubeScale[arrayPos][0] + "  " +
									+ tubeScale[arrayPos][1] + "  " +
									+ tubeScale[arrayPos][2]);
									
					System.out.println("Creating Tube with Displace: " 
									+ tubeDisplacePosition[arrayPos][0] + "  " +
									+ tubeDisplacePosition[arrayPos][1] + "  " +
									+ tubeDisplacePosition[arrayPos][2]);
					
					xPos += tubeDisplacePosition[arrayPos][0];
					yPos += tubeDisplacePosition[arrayPos][1];
					zPos += tubeDisplacePosition[arrayPos][2];
			
					double[] startPosTube = {xPos, yPos, zPos};
					double[][] tubePoints = BioGraphics.createCylinderInPlaneScaled(Constants.YPLANE, startPosTube, tubeRadii[arrayPos], tubeScale[arrayPos], numPoints);
			
					String componentType = "TubeBody";
					//body += "<Transform DEF='" + componentType + "'\n";
					
					String topRowVertices = "";
					String bottomRowVertices = "";
					
					if (longitude == 0)
					{}
					else
					{
					for (int i=0; i<numPoints; i++)
					{			
						/// build the top row
						if (i==0)
						{
							topRowVertices = "\n " + tubePoints[i][0]  + ", " +  tubePoints[i][1] + ", " + tubePoints[i][2];
							//System.out.println("TOPROW " + i + " are  " + topRowVertices);
						}
						else
						{
							topRowVertices += ",\n  " + tubePoints[i][0]  + ",  " +  tubePoints[i][1] + ",  " + tubePoints[i][2];	
							//System.out.println("TOPROW " + i + " are  " + topRowVertices);
						}
						
						// Buid the bottom row using the last of set of points
						if (i==0)
						{
							bottomRowVertices = "\n " + lastPoints[latitude][i][0]  + ", " +  lastPoints[latitude][i][1] + ", " + lastPoints[latitude][i][2];
							//System.out.println("BOTROW " + i + " are  " + bottomRowVertices);
						}
						else
						{
							bottomRowVertices += ",\n  " + lastPoints[latitude][i][0]  + ",  " +  lastPoints[latitude][i][1] + ",  " + lastPoints[latitude][i][2];
							//System.out.println("BOTROW " + i + " are  " + bottomRowVertices);
						}
					
						//System.out.println("TOP " + i + " are  " + topRowVertices);
						//System.out.println("BOT " + i + " are  " + bottomRowVertices);
					}
						
							
					String coordIndexStr = topRowVertices + "," + bottomRowVertices;
					//System.out.println("TOP : " + topRowVertices);
					//System.out.println("BOT : " + bottomRowVertices);
					//System.out.println("NUM COORDS: " + currentPoints.length  + "    "  + currentPoints.length );
					System.out.println("TUBE COORDS are: " + coordIndexStr);
				
					String indexStr = "";
					for (int i=0; i<numPoints; i++)
					{
						if ((numPoints-1) == i) 
						{
							indexStr += " " +  
								 numPoints + "  " +
								 (numPoints*2-1) + "  " +
								 (numPoints-1)  + "  " +
								 0  + "  -1";
							System.out.println("********* Last one Tube Index: " +indexStr);	
						}
						else
						{
							indexStr += " " +  
									(i  + numPoints + 1 ) + "  " +
									(i + numPoints) + "  " +
									 i  + "  " +
									(i + 1)  + "  -1";
						}
						
						System.out.println("********* Tube Index: " +indexStr);	
									
						body += "<Transform DEF='" + componentType + "_" + i + "'\n";
						
				 		body += "translation='" 
				 			+ 0.0 + " " 
							+ 0.0 + " "
							+ 0.0 + "'\n";					
				
						
					 	body+= "scale='" 	
					 			+ bioMightTransform.getScale().getXPos() + " "
					 			+ bioMightTransform.getScale().getYPos() + " "
					 			+ bioMightTransform.getScale().getZPos() + "'>\n" +
							"<Shape DEF='" + componentType + "'\n" +
				    	    	
							    " containerField='children'>\n" +
							    " <Appearance\n" +
							    "  containerField='appearance'>\n";
								    		
					 	//if  (longitude == 3 && latitude==0)
						//{
						body+= " <ImageTexture containerField='texture' " +
							    " url='../images/SpeckledOrange.png'/>";
						//}
					 	//else
					 	//{
						//	body+= " <ImageTexture containerField='texture' " +
						//		    " url='../images/SpeckledGreen.png'/>";
					 	//}
					 	
					 	body+= " <Material DEF='Rust'\n" +
						    "containerField='material'\n" +
						    "ambientIntensity='" + bioMightTransform.getMaterial().getAmbientIntensity() + "'\n" +
						    "shininess='" 		 + bioMightTransform.getMaterial().getShininess() + "'\n" +
						    "transparency='" 	 + 0.0 + "'\n" +
						    "diffuseColor='" + 
						    0.0 + " " + 
						    0.20 + " " +
						    0.40 + "'/>\n" +
						 	"</Appearance>\n" +
						    
						  	
						 	"<IndexedFaceSet DEF='EndoArcIFS' \n" +
						    	   "containerField='geometry' \n" +
						    	   "solid='false' \n" +
						    	   "creaseAngle='" +  bioMightTransform.getCreaseAngle() + "'\n" +
						    	   "coordIndex='" + indexStr + "'>" +
						    	   "<Coordinate DEF='Endo_Coord' \n" + 
						    	    "containerField='coord' point='" + coordIndexStr + "'/>" +
						    	  "</IndexedFaceSet>\n" +
						    
						    	 "</Shape>\n" +
						    	 
						    	 "<TouchSensor DEF='StartEndothelium' \n" +
				                   " description='" + componentType + "'\n" +
					               " containerField='children'/> \n" +
						    	 
							"</Transform>\n"; 
						}
					}
					
					 	// Set the current tube points into the latitude storage
						for (int l=0; l<numPoints; l++)
						{
							lastPoints[latitude][l][0] = tubePoints[l][0];
							lastPoints[latitude][l][1] = tubePoints[l][1];
							lastPoints[latitude][l][2] = tubePoints[l][2];
							System.out.println("Stored LastPoints for : " + l);				
						}
				
					}

				
					// Increase the angle on the Arc that goes top to bottom
					angleLongitude += rotateLongitude;
					System.out.println("INCREMENTED Longtitude Angle: " + angleLatitude);
				
				}
			
				radius += 0.05;
			}
		
		//body += "</Group>\n";
		return (body);		
	}

  	
  	/***********************************************************************************************************************
  	 * GENERATE Macrophage
  	 * 
  	 * Creates an irregular shaped cell, such as a simple macrophage
  	 * 
  	 * @param bioMightTransform
  	 * @param currentPoints
  	 * @param bHeader
  	 * @param bFooter
  	 * @param diffColor
  	 * @return
  	 ***********************************************************************************************************************/
	
  	public static String generateMacrophage(BioMightTransform bioMightTransform,  BioMightPosition startPos, BioMightOrientation bioMightOrientation, boolean bSpikes) 	
	{		
	  	String body = "";
	
			
		// Use the radius of the cylinder
		double radius = 0.25; //(bioMightTransform.getRadius());
		
		double xStartPos = 0.125; //startPos.getXPos(); 
		double yStartPos = 0;     //startPos.getYPos(); 
		double zStartPos = 0;     //startPos.getZPos();
		System.out.println("\n\nGenerateArc() at Start Position: " + xStartPos +   ",   " + yStartPos + ",   " + zStartPos + "  with radius: " + radius);
			
		// Allocate arrays to hold the Latitutde Point positions
		int numPoints = 8;
		double[] macStart = {startPos.getXPos(), startPos.getYPos(), startPos.getZPos()};
	
		double[][] circle1 = BioGraphics.createCylinderInPlane(Constants.YPLANE, macStart, radius, numPoints);			

		//macStart[1] -= 0.125;
		double[][] circle2 = BioGraphics.createCylinderInPlane(Constants.YPLANE, macStart, radius* 1.25, numPoints);			
	
		double[][] circle3 = BioGraphics.createCylinderInPlane(Constants.YPLANE, macStart, radius*3, numPoints);
		
		double[][] circle4 = BioGraphics.createCylinderInPlane(Constants.YPLANE, macStart, radius*4, numPoints);
		
		//double[][] lowerPoints = BioGraphics.createCylinderInPlane(Constants.YPLANE, macStart, radius, numPoints);			

		// Connect the inner/outer points
		String indexStr = "";
		String coordIndexStr = "";
		//for (int arcs=0; arcs<numPoints; arcs++) 
		//for (int arcs=0; arcs<2; arcs++) 
		//{
		
			int arc=0;
			coordIndexStr =   " "  + circle1[arc][0]   + " " + circle1[arc][1]   + " " + circle1[arc][2];
			arc++;
			coordIndexStr +=  ", " + circle1[arc][0]   + " " + circle1[arc][1]   + " " + circle1[arc][2];
			arc++;
			coordIndexStr +=  ", " + circle1[arc][0]   + " " + circle1[arc][1]   + " " + circle1[arc][2];
			arc++;
			coordIndexStr +=  ", " + circle1[arc][0]   + " " + circle1[arc][1]   + " " + circle1[arc][2];
			arc++;
			coordIndexStr +=  ", " + circle1[arc][0]   + " " + circle1[arc][1]   + " " + circle1[arc][2];
			arc++;
			coordIndexStr +=  ", " + circle1[arc][0]   + " " + circle1[arc][1]   + " " + circle1[arc][2];
			arc++;
			coordIndexStr +=  ", " + circle1[arc][0]   + " " + circle1[arc][1]   + " " + circle1[arc][2];
			arc++;
			coordIndexStr +=  ", " + circle1[arc][0]   + " " + circle1[arc][1]   + " " + circle1[arc][2];
			
			indexStr = "0, 1, 2, 3, 4, 5, 6, 7, -1";
			System.out.println("GenerateArms: " + coordIndexStr);
			
			String componentType = "Arch";
			body += "<Transform DEF='" + componentType + "'\n";
			
		
	 		body += "translation='" 
	 			+ 0.0 + " " 
				+ 0.0 + " "
				+ 0.0 + "'\n";					
	
			
		 	body+= "scale='" 	
		 			+ bioMightTransform.getScale().getXPos() + " "
		 			+ bioMightTransform.getScale().getYPos() + " "
		 			+ bioMightTransform.getScale().getZPos() + "'>\n" +
				"<Shape DEF='" + componentType + "'\n" +
	    	    	
				    " containerField='children'>\n" +
				    " <Appearance\n" +
				    "  containerField='appearance'>\n";
					    
			body+= " <ImageTexture containerField='texture' " +
				    " url='../images/SpeckledOrange.png'/>";
			
		 	body+= " <Material DEF='Rust'\n" +
			    "containerField='material'\n" +
			    "ambientIntensity='" + bioMightTransform.getMaterial().getAmbientIntensity() + "'\n" +
			    "shininess='" 		 + bioMightTransform.getMaterial().getShininess() + "'\n" +
			    "transparency='" 	 + 0.0 + "'\n" +
			    "diffuseColor='" + 
			    0.0 + " " + 
			    0.20 + " " +
			    0.40 + "'/>\n" +
			 	"</Appearance>\n" +
			    
			  	
			 	"<IndexedFaceSet DEF='EndoArcIFS' \n" +
			    	   "containerField='geometry' \n" +
			    	   "solid='false' \n" +
			    	   "creaseAngle='" +  bioMightTransform.getCreaseAngle() + "'\n" +
			    	   "coordIndex='" + indexStr + "'>" +
			    	   "<Coordinate DEF='Endo_Coord' \n" + 
			    	    "containerField='coord' point='" + coordIndexStr + "'/>" +
			    	  "</IndexedFaceSet>\n" +
			    
			    	 "</Shape>\n" +
			    	 
			    	 "<TouchSensor DEF='StartEndothelium' \n" +
	                   " description='" + componentType + "'\n" +
		               " containerField='children'/> \n" +
			    	 
			"</Transform>\n";


		 	arc=0;
			coordIndexStr =   " "  + circle2[arc][0]   + " " + circle2[arc][1]   + " " + circle2[arc][2];
			arc++;
			coordIndexStr +=  ", " + circle2[arc][0]   + " " + circle2[arc][1]   + " " + circle2[arc][2];
			arc++;
			coordIndexStr +=  ", " + circle2[arc][0]   + " " + circle2[arc][1]   + " " + circle2[arc][2];
			arc++;
			coordIndexStr +=  ", " + circle2[arc][0]   + " " + circle2[arc][1]   + " " + circle2[arc][2];
			arc++;
			coordIndexStr +=  ", " + circle2[arc][0]   + " " + circle2[arc][1]   + " " + circle2[arc][2];
			arc++;
			coordIndexStr +=  ", " + circle2[arc][0]   + " " + circle2[arc][1]   + " " + circle2[arc][2];
			arc++;
			coordIndexStr +=  ", " + circle2[arc][0]   + " " + circle2[arc][1]   + " " + circle2[arc][2];
			arc++;
			coordIndexStr +=  ", " + circle2[arc][0]   + " " + circle2[arc][1]   + " " + circle2[arc][2];
			
			indexStr = "0, 1, 2, 3, 4, 5, 6, 7, -1";
			System.out.println("GenerateArms: " + coordIndexStr);
			
			componentType = "Arch2";
			body += "<Transform DEF='" + componentType + "'\n";
			
		
	 		body += "translation='" 
	 			+ 0.0 + " " 
				+ 0.0 + " "
				+ 0.0 + "'\n";					
	
			
		 	body+= "scale='" 	
		 			+ bioMightTransform.getScale().getXPos() + " "
		 			+ bioMightTransform.getScale().getYPos() + " "
		 			+ bioMightTransform.getScale().getZPos() + "'>\n" +
				"<Shape DEF='" + componentType + "'\n" +
	    	    	
				    " containerField='children'>\n" +
				    " <Appearance\n" +
				    "  containerField='appearance'>\n";
					    
			body+= " <ImageTexture containerField='texture' " +
				    " url='../images/SpeckledGreen.png'/>";
			
		 	body+= " <Material DEF='Rust'\n" +
			    "containerField='material'\n" +
			    "ambientIntensity='" + bioMightTransform.getMaterial().getAmbientIntensity() + "'\n" +
			    "shininess='" 		 + bioMightTransform.getMaterial().getShininess() + "'\n" +
			    "transparency='" 	 + 0.0 + "'\n" +
			    "diffuseColor='" + 
			    0.0 + " " + 
			    0.20 + " " +
			    0.40 + "'/>\n" +
			 	"</Appearance>\n" +
			    
			  	
			 	"<IndexedFaceSet DEF='EndoArcIFS' \n" +
			    	   "containerField='geometry' \n" +
			    	   "solid='false' \n" +
			    	   "creaseAngle='" +  bioMightTransform.getCreaseAngle() + "'\n" +
			    	   "coordIndex='" + indexStr + "'>" +
			    	   "<Coordinate DEF='Endo_Coord' \n" + 
			    	    "containerField='coord' point='" + coordIndexStr + "'/>" +
			    	  "</IndexedFaceSet>\n" +
			    
			    	 "</Shape>\n" +
			    	 
			    	 "<TouchSensor DEF='StartEndothelium' \n" +
	                   " description='" + componentType + "'\n" +
		               " containerField='children'/> \n" +
			    	 
			"</Transform>\n";

		 	
		 	
		//}
		
		System.out.println("Completed GenerateArm()");
		return body;
	}

	/***********************************************************************************************************************
  	 * GENERATE ENDO ARC 
  	 * 
  	 * Creates an the arcs of the Endoplasmic reticulum
  	 * 
  	 * @param bioMightTransform
  	 * @param currentPoints
  	 * @param bHeader
  	 * @param bFooter
  	 * @param diffColor
  	 * @return
  	 ***********************************************************************************************************************/
	
  	public static String generateArc(BioMightTransform bioMightTransform,  BioMightPosition startPos, BioMightOrientation bioMightOrientation, boolean bSpikes) 	
	{		
	  	String body = "";
		int numLongitude = 24;
		int numLatitude = 24;
		
		int longitudeSections = 4;
		int maxLatitudeSections = 8;
		int arcSections = 5;
		
		double rotateLatitude = 360/numLatitude;
		double rotateLongitude = 360/numLongitude;
		double angleLongitude = rotateLongitude*3;
	
		// Use the radius of the cylinder
		double radius = 0.28; //(bioMightTransform.getRadius());
		
		double xStartPos = 0.125; //startPos.getXPos(); 
		double yStartPos = 0;     //startPos.getYPos(); 
		double zStartPos = 0;     //startPos.getZPos();
		System.out.println("\n\nGenerateArc() at Start Position: " + xStartPos +   ",   " + yStartPos + ",   " + zStartPos + "  with radius: " + radius);
			
		// Allocate arrays to hold the Latitutde Point positions
		double[][] lastPoints = new double [numLatitude][3];
		double[][] currentPoints = new double [numLatitude][3];	

		// Allocate arrays to hold the Arc Point positions
		double[][][][] arcPoints = new double [arcSections][longitudeSections][maxLatitudeSections][3];	

		
		// Set up initialization table for latitiude displacement
		// so that the sections have some variation
		//int latitudeStart[] = {0, 0, 15, 15, 25, 25};
		int latitudeStart[] = {0, 0, 0, 0, 0, 0, 0, 0};
		int latitudeSections[] = {7, 7, 7, 7, 7, 7, 7};
		double latitudeDistance[] = {15, 15, 15, 15, 30, 15, 15};
		
		// Specify the gaps for each Arc
		int gap[][] = {{1, 3}, 
					   {2, 4}, 
					   {0, 0}, 
					   {0, 0},
					   {0, 0},
					   {0, 0},
					   {0, 0}
					  };
		
		double angleLatitude = rotateLatitude;
		
		//body += "<Group DEF='" + "EndoGroup" + ">'\n";
		
		
		for (int arcs=0; arcs<arcSections; arcs++) 
		{
			angleLongitude = 30; // longitudeArc[arcs];
		
			for (int longitude=0; longitude<longitudeSections; longitude++) 
			{
				// Run from left to right across the latitude separated points of the sphere
				angleLatitude = latitudeStart[arcs];
				//System.out.println("Completed Complete Rotation - Resetting Latitude");

				if (arcs == 4)
					radius+= 0.0025;
				
				for (int latitude=0; latitude<latitudeSections[arcs]; latitude++)
				{	
					
					//********************************************************
					// Create the points that will create the Arc
					//********************************************************
					double radiansLatitude =  Math.toRadians(angleLatitude);
					double radiansLongitude =  Math.toRadians(angleLongitude);
					
					//System.out.println("EndoPlasmic Latitude: " + angleLatitude + " Longitude: " + angleLongitude);
					//System.out.println("EndoPlasmic radiansLatitude: " + radiansLatitude + " radiansLongitude: " + radiansLongitude);
					
					// Calculate sine and cosine of longitude and lattitude
					double cosLat = MathUtils.round(Math.cos(radiansLatitude), 8);
					double cosLong = MathUtils.round(Math.cos(radiansLongitude), 8);
					double sinLong = MathUtils.round(Math.sin(radiansLongitude), 8);
					double sinLat = MathUtils.round(Math.sin(radiansLatitude), 8);
							
					// Using Sphere equation, Calculate the points that comprise the dome
					double xPos = MathUtils.round(((radius) * (cosLat * sinLong)), 8);  
					double yPos = MathUtils.round(((radius) * cosLong), 8);
					double zPos = MathUtils.round(((radius) * (sinLat * sinLong)), 8); 
					
					//System.out.println("GeneratedArc Point: " + xPos +   ",   " + yPos + ",   " + zPos);
					
					// Displace the points based on the start position
					// If there is an isssue, use the translation function
					xPos += xStartPos;
					yPos += yStartPos;
					zPos += zStartPos;
		
					// Store all the latitude current points for the given longitude
					currentPoints[latitude][0] = xPos;
					currentPoints[latitude][1] = yPos;
					currentPoints[latitude][2] = zPos;
		
					// Store the point in the structure that holds all the points
					arcPoints[arcs][longitude][latitude][0] = xPos;
					arcPoints[arcs][longitude][latitude][1] = yPos;
					arcPoints[arcs][longitude][latitude][2] = zPos;
					
					//System.out.println("GeneratedArc Point + StartPos: " + xPos +   ",   " + yPos + ",   " + zPos);
	
		    		// Increase the angle on the arc that goes from left to right
		    		//angleLatitude += rotateLatitude;
		    		
		    		
		    		// Increase the angle on the arc that goes from left to right
					if (arcs==4) {			
						System.out.println("Latitude Distance for : " + latitude);
						angleLatitude += latitudeDistance[latitude];
					}
					else
						angleLatitude += rotateLatitude;	
		    		
		    		
				}
		
				
				if (longitude==0)
				{
					System.out.println("Skip Connnect Points as Longy==0");
				}
				else if (longitude>0)
				{
					// On Every Longitutde, Connect the previous row with the current row
					// On the first instance, we connect to the Pole to which the Sphere
					// is oriented
					String indexStr = "";
					String coordIndexStr = "";
					String topRowVertices = "";
					String bottomRowVertices = "";
					
				
					// Extract the vertices and compose the vertex string
					for (int latitude=0; latitude<latitudeSections[arcs]; latitude++)
					{
						/// build the top row
						if (latitude==0)
						{
							topRowVertices = "\n" + currentPoints[latitude][0]  + ", " +  currentPoints[latitude][1] + ", " + currentPoints[latitude][2];
							//System.out.println("TOPROW " + latitude + " are  " + topRowVertices);
						}
						else
						{
							topRowVertices += ",\n  " + currentPoints[latitude][0]  + ",  " +  currentPoints[latitude][1] + ",  " + currentPoints[latitude][2];	
							//System.out.println("TOPROW " + latitude + " are  " + topRowVertices);
						}
						
						// Buid the bottom row using the last of set of points
						if (latitude==0)
						{
							bottomRowVertices = "\n" + lastPoints[latitude][0]  + ", " +  lastPoints[latitude][1] + ", " + lastPoints[latitude][2];
							//System.out.println("BOTROW " + latitude + " are  " + bottomRowVertices);
						}
						else
						{
							bottomRowVertices += ",\n  " + lastPoints[latitude][0]  + ",  " +  lastPoints[latitude][1] + ",  " + lastPoints[latitude][2];
							//System.out.println("BOTROW " + latitude + " are  " + bottomRowVertices);
						}
					
						//System.out.println("TOP " + latitude + " are  " + topRowVertices);
						//System.out.println("BOT " + latitude + " are  " + bottomRowVertices);
					}
						
							
					coordIndexStr = topRowVertices + "," + bottomRowVertices;
					//System.out.println("TOP : " + topRowVertices);
					//System.out.println("BOT : " + bottomRowVertices);
					//System.out.println("NUM COORDS: " + currentPoints.length  + "    "  + currentPoints.length );
				//	System.out.println("COORDS are: " + coordIndexStr);
										
						
					// Connect the points together
					for (int latitude=0; latitude<latitudeSections[arcs]-1; latitude++)
					{	
						// Check to see if there should be a gap
						//for (int k=0; k < gap.length; k++) {
						//	if gap[arc][latitude] = 
						//}
						
						if ((arcs==0 && latitude == 4) || 
							(arcs==1 && latitude == 2) || 
							(arcs==2 && latitude == 3) ||
							(arcs==2 && latitude == 5) || 
							(arcs==4 && latitude == 3) ||
							(arcs==4 && latitude == 1))
						{ 
						
							System.out.println("********* WALL GAP at arc: " + arcs + "  Latitude:  " + latitude );	
						}
						else {
							indexStr += " " +
									(latitude+latitudeSections[arcs]) 	+ "  " +
									(latitude+latitudeSections[arcs]+1)	+ "  " +
									(latitude+1)     				+ "  " +
									latitude 						+ "  -1";
						}
					}
					
		
				//	System.out.println("********* WALL Index for arc: " + arcs + " is: " +indexStr);	
								
						
					String componentType = "Arch";
					body += "<Transform DEF='" + componentType + "'\n";
					
				
			 		body += "translation='" 
			 			+ 0.0 + " " 
						+ 0.0 + " "
						+ 0.0 + "'\n";					
			
					
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
				
					body+= " <ImageTexture containerField='texture' " +
						    " url='../images/SpeckledOrange.png'/>";
					
				 	body+= " <Material DEF='Rust'\n" +
					    "containerField='material'\n" +
					    "ambientIntensity='" + bioMightTransform.getMaterial().getAmbientIntensity() + "'\n" +
					    "shininess='" 		 + bioMightTransform.getMaterial().getShininess() + "'\n" +
					    "transparency='" 	 + 0.0 + "'\n" +
					    "diffuseColor='" + 
					    0.0 + " " + 
					    0.20 + " " +
					    0.40 + "'/>\n" +
					 	"</Appearance>\n" +
					    
					  	
					 	"<IndexedFaceSet DEF='EndoArcIFS' \n" +
					    	   "containerField='geometry' \n" +
					    	   "solid='false' \n" +
					    	   "creaseAngle='" +  bioMightTransform.getCreaseAngle() + "'\n" +
					    	   "coordIndex='" + indexStr + "'>" +
					    	   "<Coordinate DEF='Endo_Coord' \n" + 
					    	    "containerField='coord' point='" + coordIndexStr + "'/>" +
					    	  "</IndexedFaceSet>\n" +
					    
					    	 "</Shape>\n" +
					    	 
					    	 "<TouchSensor DEF='StartEndothelium' \n" +
			                   " description='" + componentType + "'\n" +
				               " containerField='children'/> \n" +
					    	 
					"</Transform>\n"; 
				}
					
				
				// Store all the latitude points for future use
				for (int latitude=0; latitude<latitudeSections[arcs]; latitude++)
				{
					lastPoints[latitude][0] = currentPoints[latitude][0];
					lastPoints[latitude][1] = currentPoints[latitude][1];
					lastPoints[latitude][2] = currentPoints[latitude][2];
					//System.out.println("Stored LastPoints for : " + latitude);				
				}
				
				// Increase the angle on the Arc that goes top to bottom
				angleLongitude += rotateLongitude;
				//System.out.println("INCREMENTED Longtitude Angle: " + angleLatitude);
			
			}
	
			
			//*****************************************************************
			// Create the floor
			// Connect points across the Arcs
			//****************************************************************
			
			if (arcs==0)
			{
				System.out.println("Skip FlOOR Arc is 0");
			}
			else
			{
				// On every Arc, connect the latitude points between arcs
				String indexStr = "";
				String coordIndexStr = "";
				String topArcVertices = "";
				String bottomArcVertices = "";
			
				//System.out.println("\nFLOOR ARC is " + arcs);
			
				// Extract the vertices and compose the verticies string
				// Put together two complete rows of vertices
				for (int latitude=0; latitude<latitudeSections[arcs]; latitude++)
				{
					// Build the vertices that are on the floor of the arc
					// As there are varying sizes of arcs, we need to double connect some vertices
					if (latitudeSections[arcs] == latitudeSections[arcs]-1)
					{
						// The number of latitude sections is the same
						if (latitude==0)
						{
							topArcVertices = "\n  " + arcPoints[arcs][0][latitude][0]  + ", " + 
						                              arcPoints[arcs][0][latitude][1]  + ", " + 
						                              arcPoints[arcs][0][latitude][2];
							//System.out.println("CUR ARC Endpoints for Latitude " + latitude + " are  " + topArcVertices);
						}
						else
						{
							topArcVertices += ",\n  " + arcPoints[arcs][0][latitude][0]  + ", " + 
														arcPoints[arcs][0][latitude][1]  + ", " + 
														arcPoints[arcs][0][latitude][2];
							//System.out.println("CUR ARC Endpoints for Latitude " + latitude + " are  " + topArcVertices);
						}
						
					
						// Buid the vertices that are at the end of the next arc
						if (latitude==0)
						{
							bottomArcVertices = "\n" + arcPoints[arcs-1][0][latitude][0]  + ", " + 
		                            				   arcPoints[arcs-1][0][latitude][1]  + ", " + 
		                            				   arcPoints[arcs-1][0][latitude][2];
							//System.out.println("PRIOR ARC Endpoints for Latitude " + latitude + " are  " + bottomArcVertices);
						}
						else
						{
							bottomArcVertices += ",\n  " + arcPoints[arcs-1][0][latitude][0]  + ", " + 
		                            					   arcPoints[arcs-1][0][latitude][1]  + ", " + 
		                            					   arcPoints[arcs-1][0][latitude][2];
		                            					   //arcPoints[arcs-1][longitudeSections-1][latitude][2];
							//System.out.println("PRIOR ARC Endpoints for Latitude " + latitude + " are  " + bottomArcVertices);
						}
					}
					else if (latitudeSections[arcs] < latitudeSections[arcs]-1)
					{
						// The number of latitude sections of the new arc is less than
						// the sections of the prior arc
						if (latitude==0)
						{
							topArcVertices = "\n  " + arcPoints[arcs][0][latitude][0]  + ", " + 
						                              arcPoints[arcs][0][latitude][1]  + ", " + 
						                              arcPoints[arcs][0][latitude][2];
							//System.out.println("CUR ARC Endpoints for Latitude " + latitude + " are  " + topArcVertices);
						}
						else
						{
							topArcVertices += ",\n  " + arcPoints[arcs][0][latitude][0]  + ", " + 
														arcPoints[arcs][0][latitude][1]  + ", " + 
														arcPoints[arcs][0][latitude][2];
							//System.out.println("CUR ARC Endpoints for Latitude " + latitude + " are  " + topArcVertices);
						}
						
					
						// Buid the vertices that are at the end of the next arc
						if (latitude==0)
						{
							bottomArcVertices = "\n" + arcPoints[arcs-1][0][latitude][0]  + ", " + 
		                            				   arcPoints[arcs-1][0][latitude][1]  + ", " + 
		                            				   arcPoints[arcs-1][0][latitude][2];
							//System.out.println("PRIOR ARC Endpoints for Latitude " + latitude + " are  " + bottomArcVertices);
						}
						else
						{
							bottomArcVertices += ",\n  " + arcPoints[arcs-1][0][latitude][0]  + ", " + 
		                            					   arcPoints[arcs-1][0][latitude][1]  + ", " + 
		                            					   arcPoints[arcs-1][0][latitude][2];
		                            					   //arcPoints[arcs-1][longitudeSections-1][latitude][2];
							//System.out.println("PRIOR ARC Endpoints for Latitude " + latitude + " are  " + bottomArcVertices);
						}
					}
					else if (latitudeSections[arcs] > latitudeSections[arcs]-1)
					{
						if (latitude==0)
						{
							topArcVertices = "\n  " + arcPoints[arcs][0][latitude][0]  + ", " + 
						                              arcPoints[arcs][0][latitude][1]  + ", " + 
						                              arcPoints[arcs][0][latitude][2];
							//System.out.println("CUR ARC Endpoints for Latitude " + latitude + " are  " + topArcVertices);
						}
						else
						{
							topArcVertices += ",\n  " + arcPoints[arcs][0][latitude][0]  + ", " + 
														arcPoints[arcs][0][latitude][1]  + ", " + 
														arcPoints[arcs][0][latitude][2];
							//System.out.println("CUR ARC Endpoints for Latitude " + latitude + " are  " + topArcVertices);
						}
						
					
						// Buid the vertices that are at the end of the next arc
						if (latitude==0)
						{
							bottomArcVertices = "\n" + arcPoints[arcs-1][0][latitude][0]  + ", " + 
		                            				   arcPoints[arcs-1][0][latitude][1]  + ", " + 
		                            				   arcPoints[arcs-1][0][latitude][2];
							//System.out.println("PRIOR ARC Endpoints for Latitude " + latitude + " are  " + bottomArcVertices);
						}
						else
						{
							bottomArcVertices += ",\n  " + arcPoints[arcs-1][0][latitude][0]  + ", " + 
		                            					   arcPoints[arcs-1][0][latitude][1]  + ", " + 
		                            					   arcPoints[arcs-1][0][latitude][2];
		                            					   //arcPoints[arcs-1][longitudeSections-1][latitude][2];
							//System.out.println("PRIOR ARC Endpoints for Latitude " + latitude + " are  " + bottomArcVertices);
						}
					}
		
				}
				
					
				coordIndexStr = topArcVertices + "," + bottomArcVertices;
				//System.out.println("CUR FLOOR ARC VERTICES  : " + topArcVertices);
				//System.out.println("PRIOR FLOOR ARC VERTICES: " + bottomArcVertices);
				//System.out.println("NUM COORDS: " + currentPoints.length  + "    "  + currentPoints.length );
				//System.out.println("FLOOR COORDS are: " + coordIndexStr);
									
						
				// Connect the points together, building section by section
				// as we move across the latitude row for last longitude
				// We do not connect latitude 0, as it would go nowhere
				for (int latitude=0; latitude<latitudeSections[arcs]-1; latitude++)
				{
					indexStr += " " +  
							((latitude  + latitudeSections[arcs] + 1 ) )    + "  " +
							((latitude) + latitudeSections[arcs])           + "  " +
							((latitude) )      + "  " +
							((latitude) + 1)   + "  -1";
				
				
				//	System.out.println("********* ARC FLOOR Index from: " + arcs + " to " + (arcs-1) + "  is: " + indexStr);	
					
					String componentType = "ArchFloor" + arcs + latitude + " ";
					body += "<Transform DEF='" + componentType + "'\n";
					
				
			 		body += "translation='" 
			 			+ 0.0 + " " 
						+ 0.0 + " "
						+ 0.0 + "'\n";					
			
					
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
				
					body+= " <ImageTexture containerField='texture' " +
						    " url='../images/SpeckledGreen.png'/>";
				
				 	body+= " <Material DEF='Rust'\n" +
					    "containerField='material'\n" +
					    "ambientIntensity='" + bioMightTransform.getMaterial().getAmbientIntensity() + "'\n" +
					    "shininess='" 		 + bioMightTransform.getMaterial().getShininess() + "'\n" +
					    "transparency='" 	 + 0.0 + "'\n" +
					    "diffuseColor='" + 
					    0.0 + " " + 
					    0.20 + " " +
					    0.40 + "'/>\n" +
					 	"</Appearance>\n" +				    
					  	
					 	"<IndexedFaceSet DEF='DomeCapIFS' \n" +
					    	   "containerField='geometry' \n" +
					    	   "creaseAngle='" +  bioMightTransform.getCreaseAngle() + "'\n" +
					    	   "solid='false' \n" +
					    	   "coordIndex='" + indexStr + "'>" +
					    	   "<Coordinate DEF='AdenoVirusCap_Coord' \n" + 
					    	    "containerField='coord' point='" + coordIndexStr + "'/>" +
					    	  "</IndexedFaceSet>\n" +
					    
					    	 "</Shape>\n" +
					    	 
					    	 "<TouchSensor DEF='StartEndothelium' \n" +
			                   " description='" + componentType + "'\n" +
				               " containerField='children'/> \n" +
					    	 
					"</Transform>\n"; 
				}
			}
			
			//*****************************************************************
			// Create the outer walls - Right Side
			// Connect points across the Arcs at the endpoints
			//
			//****************************************************************
		
			if (arcs==0)
			{
				//System.out.println("Skip Connnect Points as Arcs is 0");
			}
			else if (arcs>0)
			{
				// On every Arc, connect the endPoints so we can encapsulate the arcs
				String indexStr = "";
				String coordIndexStr = "";
				String topArcVertices = "";
				String bottomArcVertices = "";
			
				//System.out.println("\nARCs is " + arcs);
			
				// Extract the vertices and compose the vertex string
				for (int longitude=0; longitude<longitudeSections; longitude++)
				{
					/// build the vertices that are at the end of the arc
					if (longitude==0)
					{
						topArcVertices = "\n" + arcPoints[arcs][longitude][latitudeSections[arcs]-1][0]  + ", " + 
					                            arcPoints[arcs][longitude][latitudeSections[arcs]-1][1]  + ", " + 
					                            arcPoints[arcs][longitude][latitudeSections[arcs]-1][2];
					//	System.out.println("CUR ARC Endpoints for Long " + longitude + " are  " + topArcVertices);
					}
					else
					{
						topArcVertices += ",\n  " + arcPoints[arcs][longitude][latitudeSections[arcs]-1][0]  + ", " + 
													arcPoints[arcs][longitude][latitudeSections[arcs]-1][1]  + ", " + 
													arcPoints[arcs][longitude][latitudeSections[arcs]-1][2];
					//	System.out.println("CUR ARC Endpoints for Long " + longitude + " are  " + topArcVertices);
					}
					
				
					// Buid the vertices that are at the end of the next arc
					if (longitude==0)
					{
						bottomArcVertices = "\n" + arcPoints[arcs-1][longitude][latitudeSections[arcs-1]-1][0]  + ", " + 
	                            				   arcPoints[arcs-1][longitude][latitudeSections[arcs-1]-1][1]  + ", " + 
	                            				   arcPoints[arcs-1][longitude][latitudeSections[arcs-1]-1][2];
					//	System.out.println("PRIOR ARC Endpoints for Long " + longitude + " are  " + bottomArcVertices);
					}
					else
					{
						bottomArcVertices += ",\n  " + arcPoints[arcs-1][longitude][latitudeSections[arcs-1]-1][0]  + ", " + 
	                            					   arcPoints[arcs-1][longitude][latitudeSections[arcs-1]-1][1]  + ", " + 
	                            					   arcPoints[arcs-1][longitude][latitudeSections[arcs-1]-1][2];
					//	System.out.println("PRIOR ARC Endpoints for Long " + longitude + " are  " + bottomArcVertices);
					}
				}
				
					
				coordIndexStr = topArcVertices + "," + bottomArcVertices;
				//System.out.println("CUR ARC VERTICES  : " + topArcVertices);
				//System.out.println("PRIOR ARC VERTICES: " + bottomArcVertices);
				//System.out.println("NUM COORDS: " + currentPoints.length  + "    "  + currentPoints.length );
				//System.out.println("COORDS are: " + coordIndexStr);
									
						
				// Connect the points together
				for (int longitude=0; longitude<longitudeSections; longitude++)
				{
					if (arcs==1) {
						indexStr += " " +  
								((longitude+longitudeSections)  )    + "  " +
								((longitude+longitudeSections) + 1  )    + "  " +
								((longitude) + 1)   + "  " +
								((longitude) + 0)   + "  -1";
					}
					else { 	
						indexStr += " " +  
								((longitude+longitudeSections)  )    + "  " +
								((longitude+longitudeSections) + 1  )    + "  " +
								((longitude) + 1)   + "  " +
								((longitude) + 0)   + "  -1";
					}
					

				//	System.out.println("********* ARC Index from: " + arcs + " to " + (arcs-1) + "  is: " + indexStr);	
									
					String componentType = "ArchEnd" + arcs + longitude + " ";
					body += "<Transform DEF='" + componentType + "'\n";
					
				
			 		body += "translation='" 
			 			+ 0.0 + " " 
						+ 0.0 + " "
						+ 0.0 + "'\n";					
			
					
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
				
					body+= " <ImageTexture containerField='texture' " +
						    " url='../images/SpeckledOrange.png'/>";
				
				 	body+= " <Material DEF='Rust'\n" +
					    "containerField='material'\n" +
					    "ambientIntensity='" + bioMightTransform.getMaterial().getAmbientIntensity() + "'\n" +
					    "shininess='" 		 + bioMightTransform.getMaterial().getShininess() + "'\n" +
					    "transparency='" 	 + 0.0 + "'\n" +
					    "diffuseColor='" + 
					    0.0 + " " + 
					    0.20 + " " +
					    0.40 + "'/>\n" +
					 	"</Appearance>\n" +
					    
					  	
					 	"<IndexedFaceSet DEF='DomeCapIFS' \n" +
					    	   "containerField='geometry' \n" +
					    	   "creaseAngle='" +  bioMightTransform.getCreaseAngle() + "'\n" +
					    	   "solid='false' \n" +
					    	   "coordIndex='" + indexStr + "'>" +
					    	   "<Coordinate DEF='AdenoVirusCap_Coord' \n" + 
					    	    "containerField='coord' point='" + coordIndexStr + "'/>" +
					    	  "</IndexedFaceSet>\n" +
					    
					    	 "</Shape>\n" +
					    	 
					    	 "<TouchSensor DEF='StartEndothelium' \n" +
			                   " description='" + componentType + "'\n" +
				               " containerField='children'/> \n" +
					    	 
					"</Transform>\n"; 
				}
			
				
			}
			
			//*****************************************************************
			// Create the other outer walls - Left side
			// Connect points across the Arcs at the endpoints
			//
			//****************************************************************
		
			if (arcs==0)
			{
				//System.out.println("Skip Connnect Points as Arcs is 0");
			}
			else if (arcs>0)
			{
				// On every Arc, connect the endPoints so we can encapsulate the arcs
				String indexStr = "";
				String coordIndexStr = "";
				String topArcVertices = "";
				String bottomArcVertices = "";
			
				//System.out.println("\nARCs is " + arcs);
			
				// Extract the vertices and compose the vertex string
				for (int longitude=0; longitude<longitudeSections; longitude++)
				{
					/// build the vertices that are at the end of the arc
					if (longitude==0)
					{
						topArcVertices = "\n" + arcPoints[arcs][longitude][0][0]  + ", " + 
					                            arcPoints[arcs][longitude][0][1]  + ", " + 
					                            arcPoints[arcs][longitude][0][2];
					//	System.out.println("CUR ARC Endpoints for Long " + longitude + " are  " + topArcVertices);
					}
					else
					{
						topArcVertices += ",\n  " + arcPoints[arcs][longitude][0][0]  + ", " + 
													arcPoints[arcs][longitude][0][1]  + ", " + 
													arcPoints[arcs][longitude][0][2];
					//	System.out.println("CUR ARC Endpoints for Long " + longitude + " are  " + topArcVertices);
					}
					
				
					// Buid the vertices that are at the end of the next arc
					if (longitude==0)
					{
						bottomArcVertices = "\n" + arcPoints[arcs-1][longitude][0][0]  + ", " + 
	                            				   arcPoints[arcs-1][longitude][0][1]  + ", " + 
	                            				   arcPoints[arcs-1][longitude][0][2];
					//	System.out.println("PRIOR ARC Endpoints for Long " + longitude + " are  " + bottomArcVertices);
					}
					else
					{
						bottomArcVertices += ",\n  " + arcPoints[arcs-1][longitude][0][0]  + ", " + 
	                            					   arcPoints[arcs-1][longitude][0][1]  + ", " + 
	                            					   arcPoints[arcs-1][longitude][0][2];
					//	System.out.println("PRIOR ARC Endpoints for Long " + longitude + " are  " + bottomArcVertices);
					}
				}
				
					
				coordIndexStr = topArcVertices + "," + bottomArcVertices;
				//System.out.println("CUR ARC VERTICES  : " + topArcVertices);
				//System.out.println("PRIOR ARC VERTICES: " + bottomArcVertices);
				//System.out.println("NUM COORDS: " + currentPoints.length  + "    "  + currentPoints.length );
				//System.out.println("COORDS are: " + coordIndexStr);
									
						
				// Connect the points together
				for (int longitude=0; longitude<longitudeSections; longitude++)
				{
		
					if (arcs==1) {
						indexStr += " " +  
								((longitude+longitudeSections)  )    + "  " +
								((longitude+longitudeSections) + 1  )    + "  " +
								((longitude) + 1)   + "  " +
								((longitude) + 0)   + "  -1";
					}
					else { 	
						indexStr += " " +  
								((longitude+longitudeSections)  )    + "  " +
								((longitude+longitudeSections) + 1  )    + "  " +
								((longitude) + 1)   + "  " +
								((longitude) + 0)   + "  -1";
					}
					

					//System.out.println("********* ARC Index from: " + arcs + " to " + (arcs-1) + "  is: " + indexStr);	
							
						
					String componentType = "Other ArchEnd" + arcs + longitude + " ";
					body += "<Transform DEF='" + componentType + "'\n";
					
				
			 		body += "translation='" 
			 			+ 0.0 + " " 
						+ 0.0 + " "
						+ 0.0 + "'\n";					
			
					
				 	body+= "scale='" 	
				 			+ bioMightTransform.getScale().getXPos() + " "
				 			+ bioMightTransform.getScale().getYPos() + " "
				 			+ bioMightTransform.getScale().getZPos() + "'>\n" +
						"<Shape onmouseover=\"showComponent('EndoPlasmic Reticulum');\" DEF='" + componentType + "'\n" +
			    	    	
						    " containerField='children'>\n" +
						    " <Appearance\n" +
						    "  containerField='appearance'>\n";
							    
				 	//bioMightTransform.setCoordpoint(Constants.TRIANGLE, coordinateString, 0.025, 0);
				 	//bioMightTransform.setCoordIndex(tempInd);
				
					body+= " <ImageTexture containerField='texture' " +
						    " url='../images/SpeckledOrange.png'/>";
				
				 	body+= " <Material DEF='Rust'\n" +
					    "containerField='material'\n" +
					    "ambientIntensity='" + bioMightTransform.getMaterial().getAmbientIntensity() + "'\n" +
					    "shininess='" 		 + bioMightTransform.getMaterial().getShininess() + "'\n" +
					    "transparency='" 	 + 0.0 + "'\n" +
					    "diffuseColor='" + 
					    0.0 + " " + 
					    0.20 + " " +
					    0.40 + "'/>\n" +
					 	"</Appearance>\n" +
					    
					  	
					 	"<IndexedFaceSet DEF='DomeCapIFS' \n" +
					    	   "containerField='geometry' \n" +
					    	   "creaseAngle='" +  bioMightTransform.getCreaseAngle() + "'\n" +
					    	   "solid='false' \n" +
					    	   "coordIndex='" + indexStr + "'>" +
					    	   "<Coordinate DEF='AdenoVirusCap_Coord' \n" + 
					    	    "containerField='coord' point='" + coordIndexStr + "'/>" +
					    	  "</IndexedFaceSet>\n" +
					    
					    	 "</Shape>\n" +
					    	 
					    	 "<TouchSensor DEF='StartEndothelium' \n" +
			                   " description='" + componentType + "'\n" +
				               " containerField='children'/> \n" +
					    	 
					"</Transform>\n"; 
				}
			
				
			}


			//*****************************************************************
			// Create the inner walls on the last arc
			// Connect points across the Arcs at the endpoints
			//
			//****************************************************************
	
			if (arcs==4)
			{
				int wallSections[] = {1, 2, 3, 4}; 
				for (int j=0; j<wallSections.length; j++)
				{
				// On every Arc, connect the endPoints so we can encapsulate the arcs
				String indexStr = "";
				String coordIndexStr = "";
				String topArcVertices = "";
				String bottomArcVertices = "";
		
				
				//System.out.println("\nARCs is " + arcs);
			
				// Extract the vertices and compose the vertex string
				for (int longitude=0; longitude<longitudeSections; longitude++)
				{
					/// build the vertices that are at the end of the arc
					if (longitude==0)
					{
						topArcVertices = "\n" + arcPoints[arcs][longitude][wallSections[j]] [0]  + ", " + 
					                            arcPoints[arcs][longitude][wallSections[j]] [1]  + ", " + 
					                            arcPoints[arcs][longitude][wallSections[j]] [2];
					//	System.out.println("CUR ARC Endpoints for Long " + longitude + " are  " + topArcVertices);
					}
					else
					{
						topArcVertices += ",\n  " + arcPoints[arcs][longitude][wallSections[j]][0]  + ", " + 
													arcPoints[arcs][longitude][wallSections[j]][1]  + ", " + 
													arcPoints[arcs][longitude][wallSections[j]][2];
					//	System.out.println("CUR ARC Endpoints for Long " + longitude + " are  " + topArcVertices);
					}
					
				
					// Buid the vertices that are at the end of the next arc
					if (longitude==0)
					{
						bottomArcVertices = "\n" + arcPoints[arcs-1][longitude][wallSections[j]][0]  + ", " + 
	                            				   arcPoints[arcs-1][longitude][wallSections[j]][1]  + ", " + 
	                            				   arcPoints[arcs-1][longitude][wallSections[j]][2];
					//	System.out.println("PRIOR ARC Endpoints for Long " + longitude + " are  " + bottomArcVertices);
					}
					else
					{
						bottomArcVertices += ",\n  " + arcPoints[arcs-1][longitude][wallSections[j]][0]  + ", " + 
	                            					   arcPoints[arcs-1][longitude][wallSections[j]][1]  + ", " + 
	                            					   arcPoints[arcs-1][longitude][wallSections[j]][2];
						//System.out.println("PRIOR ARC Endpoints for Long " + longitude + " are  " + bottomArcVertices);
					}
				}
				
					
				coordIndexStr = topArcVertices + "," + bottomArcVertices;
				//System.out.println("CUR ARC VERTICES  : " + topArcVertices);
				//System.out.println("PRIOR ARC VERTICES: " + bottomArcVertices);
				//System.out.println("NUM COORDS: " + currentPoints.length  + "    "  + currentPoints.length );
				//System.out.println("COORDS are: " + coordIndexStr);
									
						
				// Connect the points together
				for (int longitude=0; longitude<longitudeSections; longitude++)
				{
		
					if (arcs==1) {
						indexStr += " " +  
								((longitude+longitudeSections)  )    + "  " +
								((longitude+longitudeSections) + 1  )    + "  " +
								((longitude) + 1)   + "  " +
								((longitude) + 0)   + "  -1";
					}
					else { 	
						indexStr += " " +  
								((longitude+longitudeSections)  )    + "  " +
								((longitude+longitudeSections) + 1  )    + "  " +
								((longitude) + 1)   + "  " +
								((longitude) + 0)   + "  -1";
					}
					

					//System.out.println("********* ARC Index from: " + arcs + " to " + (arcs-1) + "  is: " + indexStr);	
							
						
					String componentType = "Other ArchEnd" + arcs + longitude + " ";
					body += "<Transform DEF='" + componentType + "'\n";
					
				
			 		body += "translation='" 
			 			+ 0.0 + " " 
						+ 0.0 + " "
						+ 0.0 + "'\n";					
			
					
				 	body+= "scale='" 	
				 			+ bioMightTransform.getScale().getXPos() + " "
				 			+ bioMightTransform.getScale().getYPos() + " "
				 			+ bioMightTransform.getScale().getZPos() + "'>\n" +
						"<Shape onmouseover=\"showComponent('EndoPlasmic Reticulum');\" DEF='" + componentType + "'\n" +
			    	    	
						    " containerField='children'>\n" +
						    " <Appearance\n" +
						    "  containerField='appearance'>\n";
							    
				 	//bioMightTransform.setCoordpoint(Constants.TRIANGLE, coordinateString, 0.025, 0);
				 	//bioMightTransform.setCoordIndex(tempInd);
				
					body+= " <ImageTexture containerField='texture' " +
						    " url='../images/SpeckledOrange.png'/>";
				
				 	body+= " <Material DEF='Rust'\n" +
					    "containerField='material'\n" +
					    "ambientIntensity='" + bioMightTransform.getMaterial().getAmbientIntensity() + "'\n" +
					    "shininess='" 		 + bioMightTransform.getMaterial().getShininess() + "'\n" +
					    "transparency='" 	 + 0.0 + "'\n" +
					    "diffuseColor='" + 
					    0.0 + " " + 
					    0.20 + " " +
					    0.40 + "'/>\n" +
					 	"</Appearance>\n" +
					    
					  	
					 	"<IndexedFaceSet DEF='DomeCapIFS' \n" +
					    	   "containerField='geometry' \n" +
					    	   "creaseAngle='" +  bioMightTransform.getCreaseAngle() + "'\n" +
					    	   "solid='false' \n" +
					    	   "coordIndex='" + indexStr + "'>" +
					    	   "<Coordinate DEF='AdenoVirusCap_Coord' \n" + 
					    	    "containerField='coord' point='" + coordIndexStr + "'/>" +
					    	  "</IndexedFaceSet>\n" +
					    
					    	 "</Shape>\n" +
					    	 
					    	 "<TouchSensor DEF='StartEndothelium' \n" +
			                   " description='" + componentType + "'\n" +
				               " containerField='children'/> \n" +
					    	 
					"</Transform>\n";
				}
				}
			
				
			}

			
			
			
			radius += 0.025;
		}
		
			//body += "</Group>\n";
		
			return (body);		
	}
 	
  	
  	/***********************************************************************************************************************
  	 * GENERATE Polymorphonuclear leukocytes
  	 * 
  	 * Creates Polymorphonuclear leukocytes
  	 * 
  	 * @param bioMightTransform
  	 * @param currentPoints
  	 * @param bHeader
  	 * @param bFooter
  	 * @param diffColor
  	 * @return
  	 * 
  	 ***********************************************************************************************************************/
	
  	public static String generatePMN(BioMightTransform bioMightTransform,  BioMightPosition startPos, BioMightOrientation bioMightOrientation) 	
	{		
	  	String body = "";			
		//double xStartPos = startPos.getXPos(); 
		//double yStartPos = startPos.getYPos(); 
		//double zStartPos = startPos.getZPos();
		System.out.println("\nGeneratePMN() at Start Position: ");
			

		//***********************************************
		// Create the first lobe
	  	//***********************************************
	  	double[] nukStartPos = {-0.19, 0.25, 0.00};
	  	double radius = 0.000625;
		double[][] nuclueiPoints = BioGraphics.createCylinderInPlane(Constants.YPLANE, nukStartPos, radius, 8);
		

		// Move the point around, and connect it, creating a wall of 
		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstructSet = new BioMightInstructSet();
		
		int numInstructions = 18;
		//BioMightOrientation bioMightOrientation = new BioMightOrientation(0.0, 0.0, 1.0, 90);
		for (int instructCount=0; instructCount<numInstructions; instructCount++)
		{
			// Create a place for an instruction 
			BioMightInstruction bioInstruct = new BioMightInstruction();
			
			// Place a transform object into each instruction set
			bioInstruct.setBioMightTransform(bioMightTransform);
			
			if (instructCount==0){		
				//BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, -90);
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(25, 25, 25);
				bioInstruct.setTranslateMatrix(0.0, -0.002, 0.0);      
			}
			else if (instructCount==1){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(2, 2, 2);
				bioInstruct.setTranslateMatrix(0.0, -0.0025, 0.0); 
			}
			else if (instructCount==2){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(2.75, 2.75, 2.75);
				bioInstruct.setTranslateMatrix(0.0, -0.035, 0.00);   
			}				
			else if (instructCount==3){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.5, 1.5, 1.5);
				bioInstruct.setTranslateMatrix(0.0, -0.035, 0.0);      
			}
			else if (instructCount==4){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.2, 1.2, 1.2);
				bioInstruct.setTranslateMatrix(0.0, -0.025, 0.0);      
			}
			else if (instructCount==5){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.1, 1.1, 1.1);
				bioInstruct.setTranslateMatrix(0.0, -0.04, 0.0);      
			}
			else if (instructCount==6){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.1, 1.1, 1.1);
				bioInstruct.setTranslateMatrix(0.0, -0.04, 0.00);      
			}
			else if (instructCount==7){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.1, 1.1, 1.1);
				bioInstruct.setTranslateMatrix(0.0, -0.04, 0.00);      
			}
			else if (instructCount==8){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.04, 1.04, 1.04);
				bioInstruct.setTranslateMatrix(0.0, -0.04, 0.00);      
			}
			else if (instructCount==9){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.02, 1.02, 1.02);
				bioInstruct.setTranslateMatrix(0.0, -0.04, 0.00);      
			}
			else if (instructCount==10){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.01, 1.01, 1.01);
				bioInstruct.setTranslateMatrix(0.0, -0.04, 0.00);      
			}
			else if (instructCount==11){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.0, -0.04, 0.00);      
			}
			else if (instructCount==12){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(0.9, 0.9, 0.9);
				bioInstruct.setTranslateMatrix(0.0, -0.025, 0.0);      
			}
			else if (instructCount==13){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(0.9, 0.9, 0.9);
				bioInstruct.setTranslateMatrix(0.0, -0.025, -0.01);      
			}
			else if (instructCount==14){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(0.8, 0.8, 0.8);
				bioInstruct.setTranslateMatrix(0.01, -0.025, 0.000);      
			}
			else if (instructCount==15){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(0.7, 0.7, 0.7);
				bioInstruct.setTranslateMatrix(0.02, -0.025, 0.000);      
			}
			else if (instructCount==16){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(0.2, 0.2, 0.2);
				bioInstruct.setTranslateMatrix(0.03, -0.025, 0.000);      
			}
		
			else if (instructCount==17){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(0.0001, 0.0001, 0.0001);
				bioInstruct.setTranslateMatrix(0.0, -0.00015, 0.000);      
			}
			else {
				bioInstruct.setTransType(Constants.TRANSLATE);
				BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, 90);
				bioInstruct.setOrientation(orientationUpd);
				bioInstruct.setTranslateMatrix(0.0, -0.05, 0.0);       
			}
	
			
			
			// Add the instruction into the instruction set
    		bioMightInstructSet.addElement(bioInstruct);
		}	
			
		// Pass the instructions to the builder
		body += generateIndexFacedComponents(bioMightOrientation, bioMightInstructSet, nuclueiPoints); 	
				
		
		//***********************************************
		//
		// Create the second lobe
		//
	  	//***********************************************
		
	  	double[] nukStartPos2 = {0.2, 0.20, 0.00};
		nuclueiPoints = BioGraphics.createCylinderInPlane(Constants.YPLANE, nukStartPos2, radius, 8);

		bioMightInstructSet = new BioMightInstructSet();
		
		numInstructions = 18;
		//BioMightOrientation bioMightOrientation = new BioMightOrientation(0.0, 0.0, 1.0, 90);
		for (int instructCount=0; instructCount<numInstructions; instructCount++)
		{
			// Create a place for an instruction 
			BioMightInstruction bioInstruct = new BioMightInstruction();
			
			// Place a transform object into each instruction set
			bioInstruct.setBioMightTransform(bioMightTransform);
		
			if (instructCount==0){		
				//BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, -90);
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(25, 25, 25);
				bioInstruct.setTranslateMatrix(0.0, -0.002, 0.0);      
			}
			else if (instructCount==1){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(2, 2, 2);
				bioInstruct.setTranslateMatrix(0.0, -0.0025, 0.0); 
			}
			else if (instructCount==2){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(2.75, 2.75, 2.75);
				bioInstruct.setTranslateMatrix(0.0, -0.035, 0.00);   
			}				
			else if (instructCount==3){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.5, 1.5, 1.5);
				bioInstruct.setTranslateMatrix(0.0, -0.035, 0.0);      
			}
			else if (instructCount==4){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.2, 1.2, 1.2);
				bioInstruct.setTranslateMatrix(0.0, -0.025, 0.0);      
			}
			else if (instructCount==5){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.1, 1.1, 1.1);
				bioInstruct.setTranslateMatrix(0.0, -0.04, 0.0);      
			}
			else if (instructCount==6){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.1, 1.1, 1.1);
				bioInstruct.setTranslateMatrix(0.0, -0.04, 0.00);      
			}
			else if (instructCount==7){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.1, 1.1, 1.1);
				bioInstruct.setTranslateMatrix(0.0, -0.04, 0.00);      
			}
			else if (instructCount==8){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.04, 1.04, 1.04);
				bioInstruct.setTranslateMatrix(0.0, -0.04, 0.00);      
			}
			else if (instructCount==9){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.02, 1.02, 1.02);
				bioInstruct.setTranslateMatrix(0.0, -0.04, 0.00);      
			}
			else if (instructCount==10){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.01, 1.01, 1.01);
				bioInstruct.setTranslateMatrix(0.0, -0.04, 0.00);      
			}
			else if (instructCount==11){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.0, -0.04, 0.00);      
			}
			else if (instructCount==12){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(0.9, 0.9, 0.9);
				bioInstruct.setTranslateMatrix(0.0, -0.025, 0.0);      
			}
			else if (instructCount==13){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(0.9, 0.9, 0.9);
				bioInstruct.setTranslateMatrix(0.0, -0.025, -0.01);      
			}
			else if (instructCount==14){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(0.8, 0.8, 0.8);
				bioInstruct.setTranslateMatrix(0.01, -0.025, 0.000);      
			}
			else if (instructCount==15){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(0.7, 0.7, 0.7);
				bioInstruct.setTranslateMatrix(0.02, -0.025, 0.000);      
			}
			else if (instructCount==16){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(0.2, 0.2, 0.2);
				bioInstruct.setTranslateMatrix(0.03, -0.025, 0.000);      
			}	
			else if (instructCount==17){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(0.0001, 0.0001, 0.0001);
				bioInstruct.setTranslateMatrix(0.0, -0.00015, 0.000);      
			}
			else {
				bioInstruct.setTransType(Constants.TRANSLATE);
				BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, 90);
				bioInstruct.setOrientation(orientationUpd);
				bioInstruct.setTranslateMatrix(0.0, -0.05, 0.0);       
			}
				
			
			// Add the instruction into the instruction set
    		bioMightInstructSet.addElement(bioInstruct);
		}	
			
		
		String bioGroup = "EosinophilGroup" + "L" + 1 + "L" + 0;
		body += "\n<Transform DEF='" + bioGroup + "'\n";
		//body += "  translation='" + "0.0  4.0  1.0, 0.35" +  "'\n";
		body += "  rotation='" + "0.0  0.0  1.0, 1.05" +  "'>\n\n";

		// Pass the instructions to the builder
		body += generateIndexFacedComponents(bioMightOrientation, bioMightInstructSet, nuclueiPoints); 	
	
		body += "\n</Transform>'\n";
		

		
		//***********************************************
		//
		// Create the third lobe
		//
	  	//***********************************************

		
	  	double[] nukStartPos3 = {-0.19, 0.24, -0.0035};
		nuclueiPoints = BioGraphics.createCylinderInPlane(Constants.XPLANE, nukStartPos3, radius, 8);
			
		bioMightInstructSet = new BioMightInstructSet();
		
		numInstructions = 8;
		//BioMightOrientation bioMightOrientation = new BioMightOrientation(0.0, 0.0, 1.0, 90);
		for (int instructCount=0; instructCount<numInstructions; instructCount++)
		{
			// Create a place for an instruction 
			BioMightInstruction bioInstruct = new BioMightInstruction();
			
			// Place a transform object into each instruction set
			bioInstruct.setBioMightTransform(bioMightTransform);
		
			if (instructCount==0){		
				//BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, -90);
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(40, 40, 40);
				bioInstruct.setTranslateMatrix(0.00025, 0.00, 0.0);      
			}
			else if (instructCount==1){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.025, 0.01,  0.01); 
			}
			else if (instructCount==2){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.025, 0.01, 0.009);   
			}				
			else if (instructCount==3){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.025, 0.00, 0.01);      
			}
			else if (instructCount==4){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.025, 0.0, 0.01);      
			}
			else if (instructCount==5){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.025, -0.01, 0.01);      
			}
			else if (instructCount==6){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.025, -0.01, 0.01);      
			}
			else if (instructCount==7){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.025, 0.0, 0.000);      
			}
			
			else {
				bioInstruct.setTransType(Constants.TRANSLATE);
				BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, 90);
				bioInstruct.setOrientation(orientationUpd);
				bioInstruct.setTranslateMatrix(0.0, -0.05, 0.0);       
			}
	
			// Add the instruction into the instruction set
    		bioMightInstructSet.addElement(bioInstruct);
		}	
				
		// Pass the instructions to the builder
		body += generateIndexFacedComponents(bioMightOrientation, bioMightInstructSet, nuclueiPoints); 	

	

		return (body);		
		
	}
  	
 	/***********************************************************************************************************************
  	 * GENERATE BASOPHIL NUCLEUS
  	 * 
  	 * Creates a Basophil (Polymorphonuclear leukocyte)
  	 * 
  	 * @param bioMightTransform
  	 * @param currentPoints
  	 * @param bHeader
  	 * @param bFooter
  	 * @param diffColor
  	 * @return
  	 * 
  	 ***********************************************************************************************************************/
	
  	public static String generateBasophil(BioMightTransform bioMightTransform,  BioMightPosition startPos, BioMightOrientation bioMightOrientation) 	
	{		
	  	String body = "";			
		//double xStartPos = startPos.getXPos(); 
		//double yStartPos = startPos.getYPos(); 
		//double zStartPos = startPos.getZPos();
		System.out.println("\nGenerateBasophil() at Start Position: ");
			

		//***********************************************
		// Create the first lobe
	  	//***********************************************
	  	double[] nukStartPos = {-0.25, 0.75, 0.00};
	  	double radius = 0.000625;
		double[][] nuclueiPoints = BioGraphics.createCylinderInPlane(Constants.YPLANE, nukStartPos, radius, 8);
		

		// Move the point around, and connect it, creating a wall of 
		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstructSet = new BioMightInstructSet();
		
		int numInstructions = 27;
		//BioMightOrientation bioMightOrientation = new BioMightOrientation(0.0, 0.0, 1.0, 90);
		for (int instructCount=0; instructCount<numInstructions; instructCount++)
		{
			// Create a place for an instruction 
			BioMightInstruction bioInstruct = new BioMightInstruction();
			
			// Place a transform object into each instruction set
			// Use the same one when homogenous
			bioInstruct.setBioMightTransform(bioMightTransform);
			
			
			bioMightTransform = new BioMightTransform();
			bioMightTransform.setTextureID(5);
			bioMightTransform.setTextureFile("SpeckledSlateBlue.png");
			bioMightTransform.setComponentName("Nucleus");
			
			// Place a transform object into each instruction set
			bioInstruct.setBioMightTransform(bioMightTransform);
			
			if (instructCount==0){		
				//BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, -90);
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(25, 25, 25);
				bioInstruct.setTranslateMatrix(0.0, -0.0002, 0.0);      
			}
			else if (instructCount==1){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(3.5, 3.5, 3.5);
				bioInstruct.setTranslateMatrix(0.0, -0.0002, 0.0); 
			}
			else if (instructCount==2){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(2.75, 2.75, 2.75);
				bioInstruct.setTranslateMatrix(0.0, -0.025, 0.00);   
			}				
			else if (instructCount==3){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(2.0, 2.0, 2.0);
				bioInstruct.setTranslateMatrix(0.0, -0.050, 0.0);      
			}
			else if (instructCount==4){
				bioInstruct.setTransType(Constants.SCALE);	
				bioInstruct.setScaleMatrix(1.25, 1.25, 1.25);
				bioInstruct.setTranslateMatrix(0.0, -0.075, 0.0);      
			}
			else if (instructCount==5){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.25, 1.25, 1.25);
				bioInstruct.setTranslateMatrix(0.0, -0.1, 0.0);      
			}
			else if (instructCount==6){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.1, 1.1, 1.1);
				bioInstruct.setTranslateMatrix(0.0, -0.120, 0.00);      
			}
			else if (instructCount==7){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.0, -0.05, 0.00);      
			}
			else if (instructCount==8){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(0.9, 0.9, 0.9);
				bioInstruct.setTranslateMatrix(0.0, -0.120, 0.00);       
			}	
			else if (instructCount==9){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(0.9, 0.9, 0.9);
				bioInstruct.setTranslateMatrix(0.0, -0.1, 0.00);      
			}
			else if (instructCount==10){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(0.9, 0.9, 0.9);
				bioInstruct.setTranslateMatrix(0.0, -0.075, 0.00);      
			}
			else if (instructCount==11){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(0.8, 0.8, 0.8);
				bioInstruct.setTranslateMatrix(0.0, -0.05, 0.00);       
			}
			else if (instructCount==12){
				bioInstruct.setTransType(Constants.TRANSLATE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.025, -0.05, 0.00);     
			}
			else if (instructCount==13){
				bioInstruct.setTransType(Constants.ROTATEOCTO);
				bioInstruct.setTranslateMatrix(0.02, -0.025, 0.000);     
				BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, 90);
				bioInstruct.setOrientation(orientationUpd);	
				bioInstruct.setPivotPoint(0);
				BioMightOrientation rotationUpd = new BioMightOrientation(0.0, 0.0, 1.0, 5);
				bioInstruct.setRotation(rotationUpd);	   
			}
			else if (instructCount==14){
				bioInstruct.setTransType(Constants.ROTATEOCTO);
				bioInstruct.setTranslateMatrix(0.02, -0.025, 0.000);     
				BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, -90);
				bioInstruct.setOrientation(orientationUpd);	
				bioInstruct.setPivotPoint(0);
				BioMightOrientation rotationUpd = new BioMightOrientation(0.0, 0.0, 1.0, 5);
				bioInstruct.setRotation(rotationUpd);	
			}
			else if (instructCount==15){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.25, 1.25, 1.25);
				bioInstruct.setTranslateMatrix(0.05, 0.02, 0.00);   
			}
			else if (instructCount==16){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.125, 1.125, 1.125);
				bioInstruct.setTranslateMatrix(0.05, 0.02, 0.00);   
			}			
			else if (instructCount==17){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.125, 1.125, 1.125);
				bioInstruct.setTranslateMatrix(0.05, 0.02, 0.00);         
			}
			else if (instructCount==18){		
				bioInstruct.setTransType(Constants.TRANSLATE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.05, 0.02, 0.00);        
			}
			else if (instructCount==19){
				bioInstruct.setTransType(Constants.TRANSLATE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.075, 0.02, 0.00); 
			}
			else if (instructCount==20){
				bioInstruct.setTransType(Constants.TRANSLATE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.05, 0.02, 0.00); 
			}
			else if (instructCount==21){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(0.9, 0.9, 0.9);
				bioInstruct.setTranslateMatrix(0.05, 0.02, 0.0);      
			}
			else if (instructCount==22){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(0.85, 0.85, 0.85);
				bioInstruct.setTranslateMatrix(0.05, 0.02, 0.0);        
			}
			else if (instructCount==23){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(0.85, 0.85, 0.85);
				bioInstruct.setTranslateMatrix(0.05, 0.02, 0.0);       
			}
			else if (instructCount==24){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(0.5, 0.5, 0.5);
				bioInstruct.setTranslateMatrix(0.075, 0.02, 0.0);       
			}
			else if (instructCount==25){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(0.85, 0.85, 0.85);
				bioInstruct.setTranslateMatrix(0.0125, 0.000125, 0.0);        
			}
			else if (instructCount==26){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(0.000025, 0.000025, 0.000025);
				bioInstruct.setTranslateMatrix(0.00001, 0.00001, 0.0);      
			}
			
			
			else if (instructCount==27){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(0.00001, 0.00001, 0.00001);
				bioInstruct.setTranslateMatrix(0.0, 0.0000025, 0.00);      
			}
			
			
			
			else if (instructCount==28){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.01, 1.01, 1.01);
				bioInstruct.setTranslateMatrix(0.0, -0.04, 0.00);      
			}
			else if (instructCount==29){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.0, -0.04, 0.00);      
			}
			else if (instructCount==30){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(0.9, 0.9, 0.9);
				bioInstruct.setTranslateMatrix(0.0, -0.025, 0.0);      
			}
			else if (instructCount==31){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(0.9, 0.9, 0.9);
				bioInstruct.setTranslateMatrix(0.0, -0.025, -0.01);      
			}
			else if (instructCount==32){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(0.8, 0.8, 0.8);
				bioInstruct.setTranslateMatrix(0.01, -0.025, 0.000);      
			}
			else if (instructCount==33){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(0.7, 0.7, 0.7);
				bioInstruct.setTranslateMatrix(0.02, -0.025, 0.000);      
			}
			else if (instructCount==34){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(0.2, 0.2, 0.2);
				bioInstruct.setTranslateMatrix(0.03, -0.025, 0.000);      
			}	
			else if (instructCount==35){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(0.0001, 0.0001, 0.0001);
				bioInstruct.setTranslateMatrix(0.0, -0.00015, 0.000);      
			}
		
			else if (instructCount==36){		
				//BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, -90);
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(40, 40, 40);
				bioInstruct.setTranslateMatrix(0.00025, 0.00, 0.0);      
			}
			else if (instructCount==37){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.025, 0.01,  0.01); 
			}
			else if (instructCount==38){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.025, 0.01, 0.009);   
			}				
			else if (instructCount==39){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.025, 0.00, 0.01);      
			}
			else if (instructCount==40){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.025, 0.0, 0.01);      
			}
			else if (instructCount==41){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.025, -0.01, 0.01);      
			}
			else if (instructCount==42){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.025, -0.01, 0.01);      
			}
			else if (instructCount==43){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.025, 0.0, 0.000);      
			}
			
			else {
				bioInstruct.setTransType(Constants.TRANSLATE);
				BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, 90);
				bioInstruct.setOrientation(orientationUpd);
				bioInstruct.setTranslateMatrix(0.0, -0.05, 0.0);       
			}
	
			// Add the instruction into the instruction set
    		bioMightInstructSet.addElement(bioInstruct);
		}	
				
		// Pass the instructions to the builder
		// These data points will need to be stored in the database and be modifiable
		// based on user inputs
		body += generateIndexFacedComponents(bioMightOrientation, bioMightInstructSet, nuclueiPoints); 	

	
		return (body);		
		
	}
  	
  	
 	
 	/***********************************************************************************************************************
  	 * GENERATE NEUTROPHIL NUCLEUS
  	 * 
  	 * Creates a Neutrophil (Polymorphonuclear leukocyte)
  	 * 
  	 * @param bioMightTransform
  	 * @param currentPoints
  	 * @param bHeader
  	 * @param bFooter
  	 * @param diffColor
  	 * @return
  	 * 
  	 ***********************************************************************************************************************/
	
  	public static String generateNeutrophil(BioMightTransform bioMightTransform,  BioMightPosition startPos, BioMightOrientation bioMightOrientation) 	
	{		
	  	String body = "";			
		//double xStartPos = startPos.getXPos(); 
		//double yStartPos = startPos.getYPos(); 
		//double zStartPos = startPos.getZPos();
		System.out.println("\nGenerateNeutrophil() at Start Position: ");
			

		//***********************************************
		// Create the first lobe
	  	//***********************************************
	  	double[] nukStartPos = {0.0, 0.65, -0.0025};
	  	double radius = 0.000625;
		double[][] nuclueiPoints = BioGraphics.createCylinderInPlane(Constants.YPLANE, nukStartPos, radius, 8);
		

		// Move the point around, and connect it, creating a wall of 
		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstructSet = new BioMightInstructSet();
		
		int numInstructions = 29;
		//BioMightOrientation bioMightOrientation = new BioMightOrientation(0.0, 0.0, 1.0, 90);
		for (int instructCount=0; instructCount<numInstructions; instructCount++)
		{
			// Create a place for an instruction 
			BioMightInstruction bioInstruct = new BioMightInstruction();
			
			// Place a transform object into each instruction set
			// Use the same one when homogenous
			bioInstruct.setBioMightTransform(bioMightTransform);
			
			
			bioMightTransform = new BioMightTransform();
			bioMightTransform.setTextureID(5);
			bioMightTransform.setTextureFile("SpeckledPink.png");
			bioMightTransform.setComponentName("Nucleus");
			
			// Place a transform object into each instruction set
			bioInstruct.setBioMightTransform(bioMightTransform);
			
			if (instructCount==0){		
				//BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, -90);
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(20, 20, 20);
				bioInstruct.setTranslateMatrix(0.0, -0.0002, 0.0);      
			}
			else if (instructCount==1){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(2.5, 2.5, 2.5);
				bioInstruct.setTranslateMatrix(0.0, -0.0002, 0.0); 
			}
			else if (instructCount==2){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(2.25, 2.25, 2.25);
				bioInstruct.setTranslateMatrix(0.0, -0.0125, 0.00);   
			}				
			else if (instructCount==3){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.75, 1.75, 1.75);
				bioInstruct.setTranslateMatrix(0.0, -0.025, 0.0);      
			}
			else if (instructCount==4){
				bioInstruct.setTransType(Constants.SCALE);	
				bioInstruct.setScaleMatrix(1.25, 1.25, 1.25);
				bioInstruct.setTranslateMatrix(0.0, -0.025, 0.0);      
			}
			else if (instructCount==5){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.25, 1.25, 1.25);
				bioInstruct.setTranslateMatrix(0.0, -0.05, 0.0);      
			}
			else if (instructCount==6){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.05, 1.05, 1.05);
				bioInstruct.setTranslateMatrix(0.0, -0.05, 0.00);      
			}
			else if (instructCount==7){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(0.98, 0.98, 0.98);
				bioInstruct.setTranslateMatrix(0.0, -0.05, 0.00);      
			}
			else if (instructCount==8){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(0.85, 0.85, 0.85);
				bioInstruct.setTranslateMatrix(0.0, -0.05, 0.00);       
			}	
			else if (instructCount==9){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(0.20, 0.20, 0.20);
				bioInstruct.setTranslateMatrix(0.0, -0.05, 0.00);       
			}
			else if (instructCount==9){
				bioInstruct.setTransType(Constants.TRANSLATE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(-0.025, -0.1, 0.00);      
			}
			else if (instructCount==10){
				bioInstruct.setTransType(Constants.TRANSLATE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(-0.025, -0.1, 0.00);       
			}
			else if (instructCount==11){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(3.5, 3.5, 3.5);
				bioInstruct.setTranslateMatrix(0.0, -0.025, 0.00);       
			}
			else if (instructCount==12){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.1, 1.1, 1.1);
				bioInstruct.setTranslateMatrix(0.0, -0.025, 0.00);     
			}
			else if (instructCount==13){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.25, 1.25, 1.25);
				bioInstruct.setTranslateMatrix(0.0, -0.05, 0.00);     
			}
			else if (instructCount==14){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.1, 1.1, 1.1);
				bioInstruct.setTranslateMatrix(0.0, -0.05, 0.00);
			}
			else if (instructCount==15){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(0.98, 0.98, 0.98);
				bioInstruct.setTranslateMatrix(0.0, -0.05, 0.00);  
			}
			else if (instructCount==16){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(0.65, 0.65, 0.65);
				bioInstruct.setTranslateMatrix(0.0, -0.05, 0.00);    
			}			
			else if (instructCount==17){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(0.25, 0.25, 0.25);
				bioInstruct.setTranslateMatrix(0.0, -0.05, 0.00);          
			}
			else if (instructCount==18){		
				bioInstruct.setTransType(Constants.TRANSLATE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.05, -0.025, 0.00);        
			}
			else if (instructCount==19){
				bioInstruct.setTransType(Constants.TRANSLATE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.05, -0.05, 0.00); 
			}
			else if (instructCount==20){
				bioInstruct.setTransType(Constants.SCALE);	
				bioInstruct.setScaleMatrix(3.5, 3.5, 3.5);
				bioInstruct.setTranslateMatrix(0.0, -0.025, 0.0); 
			}
			else if (instructCount==21){
				bioInstruct.setTransType(Constants.SCALE);	
				bioInstruct.setScaleMatrix(1.35, 1.35, 1.35);
				bioInstruct.setTranslateMatrix(0.0, -0.025, 0.0);      
			}
			else if (instructCount==22){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.15, 1.15, 1.15);
				bioInstruct.setTranslateMatrix(0.0, -0.05, 0.0);        
			}
			else if (instructCount==23){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.1, 1.1, 1.1);
				bioInstruct.setTranslateMatrix(0.0, -0.05, 0.0);        
			}
			else if (instructCount==24){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(0.98, 0.98, 0.98);
				bioInstruct.setTranslateMatrix(0.0, -0.05, 0.0);       
			}
			else if (instructCount==25){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(0.9, 0.9, 0.9);
				bioInstruct.setTranslateMatrix(0.0, -0.05, 0.0);        
			}
			else if (instructCount==26){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(0.8, 0.8, 0.8);
				bioInstruct.setTranslateMatrix(0.0, -0.05, 0.0);  
			}
			else if (instructCount==27){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(0.25, 0.25, 0.25);
				bioInstruct.setTranslateMatrix(0.0, -0.05, 0.0);     
			}
			else if (instructCount==28){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(0.0025, 0.0025, 0.0025);
				bioInstruct.setTranslateMatrix(0.0, -0.0005, 0.0);     
			}
			
			
			else if (instructCount==29){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.0, -0.04, 0.00);      
			}
			else if (instructCount==30){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(0.9, 0.9, 0.9);
				bioInstruct.setTranslateMatrix(0.0, -0.025, 0.0);      
			}
			else if (instructCount==31){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(0.9, 0.9, 0.9);
				bioInstruct.setTranslateMatrix(0.0, -0.025, -0.01);      
			}
			else if (instructCount==32){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(0.8, 0.8, 0.8);
				bioInstruct.setTranslateMatrix(0.01, -0.025, 0.000);      
			}
			else if (instructCount==33){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(0.7, 0.7, 0.7);
				bioInstruct.setTranslateMatrix(0.02, -0.025, 0.000);      
			}
			else if (instructCount==34){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(0.2, 0.2, 0.2);
				bioInstruct.setTranslateMatrix(0.03, -0.025, 0.000);      
			}	
			else if (instructCount==35){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(0.0001, 0.0001, 0.0001);
				bioInstruct.setTranslateMatrix(0.0, -0.00015, 0.000);      
			}
			else if (instructCount==36){		
				//BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, -90);
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(40, 40, 40);
				bioInstruct.setTranslateMatrix(0.00025, 0.00, 0.0);      
			}
			else if (instructCount==37){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.025, 0.01,  0.01); 
			}
			else if (instructCount==38){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.025, 0.01, 0.009);   
			}				
			else if (instructCount==39){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.025, 0.00, 0.01);      
			}
			else if (instructCount==40){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.025, 0.0, 0.01);      
			}
			else if (instructCount==41){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.025, -0.01, 0.01);      
			}
			else if (instructCount==42){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.025, -0.01, 0.01);      
			}
			else if (instructCount==43){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.025, 0.0, 0.000);      
			}
			else if (instructCount==44){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.025, 0.0, 0.000);      
			}
			
			else {
				bioInstruct.setTransType(Constants.TRANSLATE);
				BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, 90);
				bioInstruct.setOrientation(orientationUpd);
				bioInstruct.setTranslateMatrix(0.0, -0.05, 0.0);       
			}
	
			// Add the instruction into the instruction set
    		bioMightInstructSet.addElement(bioInstruct);
		}	
				
		// Pass the instructions to the builder
		// These data points will need to be stored in the database and be modifiable
		// based on user inputs
		body += generateIndexFacedComponents(bioMightOrientation, bioMightInstructSet, nuclueiPoints); 	

	
		return (body);		
		
	}
  	
	/***********************************************************************************************************************
  	 * GENERATE MONOCYTE
  	 * 
  	 * Creates Monocyte
  	 * 
  	 * @param bioMightTransform
  	 * @param currentPoints
  	 * @param bHeader
  	 * @param bFooter
  	 * @param diffColor
  	 * @return
  	 * 
  	 ***********************************************************************************************************************/
	
  	public static String generateMonocyte(BioMightTransform bioMightTransform,  BioMightPosition startPos, BioMightOrientation bioMightOrientation) 	
	{		
	  	String body = "";			
		//double xStartPos = startPos.getXPos(); 
		//double yStartPos = startPos.getYPos(); 
		//double zStartPos = startPos.getZPos();
		System.out.println("\nGenerateMonocyte() at Start Position: ");
			

		//***********************************************
		// Create the lobe
	  	//***********************************************
	  	double[] nukStartPos = {-0.19, 0.25, 0.00};
	  	double radius = 0.000625;
		double[][] nuclueiPoints = BioGraphics.createCylinderInPlane(Constants.YPLANE, nukStartPos, radius, 8);
		

		// Move the point around, and connect it, creating a wall of 
		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstructSet = new BioMightInstructSet();
		
		int numInstructions = 30;
		//BioMightOrientation bioMightOrientation = new BioMightOrientation(0.0, 0.0, 1.0, 90);
		for (int instructCount=0; instructCount<numInstructions; instructCount++)
		{
			// Create a place for an instruction 
			BioMightInstruction bioInstruct = new BioMightInstruction();
			
			// Place a transform object into each instruction set
			bioInstruct.setBioMightTransform(bioMightTransform);
			
			if (instructCount==0){		
				//BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, -90);
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(25, 25, 25);
				bioInstruct.setTranslateMatrix(0.0, -0.002, 0.0);      
			}
			else if (instructCount==1){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(2, 2, 2);
				bioInstruct.setTranslateMatrix(0.0, -0.0025, 0.0); 
			}
			else if (instructCount==2){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(2.75, 2.75, 2.75);
				bioInstruct.setTranslateMatrix(0.0, -0.035, 0.00);   
			}				
			else if (instructCount==3){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.5, 1.0, 1.5);
				bioInstruct.setTranslateMatrix(0.0, -0.037, 0.0);      
			}
			else if (instructCount==4){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.2, 1.0, 1.2);
				bioInstruct.setTranslateMatrix(0.0, -0.025, 0.0);      
			}
			else if (instructCount==5){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.1, 1.0, 1.1);
				bioInstruct.setTranslateMatrix(0.0, -0.04, 0.0);      
			}
			else if (instructCount==6){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.1, 1.1, 1.1);
				bioInstruct.setTranslateMatrix(0.0, -0.04, 0.00);      
			}
			else if (instructCount==7){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.1, 1.1, 1.1);
				bioInstruct.setTranslateMatrix(0.0, -0.04, 0.00);      
			}
			else if (instructCount==8){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.0, -0.04, 0.00);      
			}
			else if (instructCount==9){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.02, -0.04, 0.00);      
			}
			else if (instructCount==10){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(0.99, 0.99, 0.99);
				bioInstruct.setTranslateMatrix(0.01, -0.04, 0.00);      
			}
			else if (instructCount==11){
				bioInstruct.setTransType(Constants.TRANSLATE);
				bioInstruct.setTranslateMatrix(0.01, -0.04, 0.00);      
			}
			else if (instructCount==12){
				bioInstruct.setTransType(Constants.TRANSLATE);
				bioInstruct.setTranslateMatrix(0.01, -0.04, 0.00);      
			}
			else if (instructCount==13){
				bioInstruct.setTransType(Constants.ROTATEOCTO);
				bioInstruct.setTranslateMatrix(0.02, -0.025, 0.000);     
				BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, -90);
				bioInstruct.setOrientation(orientationUpd);	
				bioInstruct.setPivotPoint(0);
				BioMightOrientation rotationUpd = new BioMightOrientation(0.0, 0.0, 1.0, 5);
				bioInstruct.setRotation(rotationUpd);		   
			}
			else if (instructCount==14){
				bioInstruct.setTransType(Constants.ROTATEOCTO);
				bioInstruct.setTranslateMatrix(0.02, -0.025, 0.000);     
				BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, -90);
				bioInstruct.setOrientation(orientationUpd);	
				bioInstruct.setPivotPoint(0);
				BioMightOrientation rotationUpd = new BioMightOrientation(0.0, 0.0, 1.0, 5);
				bioInstruct.setRotation(rotationUpd);		   
			}
			else if (instructCount==15){
				bioInstruct.setTransType(Constants.ROTATEOCTO);
				bioInstruct.setTranslateMatrix(0.02, -0.025, 0.000);     
				BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, -90);
				bioInstruct.setOrientation(orientationUpd);	
				bioInstruct.setPivotPoint(0);
				BioMightOrientation rotationUpd = new BioMightOrientation(0.0, 0.0, 1.0, 2.5);
				bioInstruct.setRotation(rotationUpd);		   
			}
			else if (instructCount==16){
				bioInstruct.setTransType(Constants.TRANSLATE);
				bioInstruct.setTranslateMatrix(0.02, 0.01, 0.0);           
			}
			else if (instructCount==17){
				bioInstruct.setTransType(Constants.TRANSLATE);
				bioInstruct.setTranslateMatrix(0.02, 0.01, 0.0);      
			}
			else if (instructCount==18){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.05, 1.05, 1.05);
				bioInstruct.setTranslateMatrix(0.03, 0.02, 0.0);      
			}
			else if (instructCount==19){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.025, 1.025, 1.025);
				bioInstruct.setTranslateMatrix(0.03, 0.02, 0.0);        
			}
			else if (instructCount==20){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.03, 0.03, -0.01);   
			}
			else if (instructCount==21){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.025, 0.01, -0.01);   
			}
			else if (instructCount==22){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.025, 0.02, 0.000);      
			}
			else if (instructCount==23){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(0.9, 0.9, 0.9);
				bioInstruct.setTranslateMatrix(0.025, 0.02, 0.000);      
			}
			else if (instructCount==24){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(0.9, 0.9, 0.9);
				bioInstruct.setTranslateMatrix(0.025, 0.02, 0.000);      
			}
			else if (instructCount==25){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(0.9, 0.9, 0.9);
				bioInstruct.setTranslateMatrix(0.025, 0.02, 0.000);      
			}
			else if (instructCount==26){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(0.8, 0.8, 0.8);
				bioInstruct.setTranslateMatrix(0.025, 0.02, 0.000);      
			}
			else if (instructCount==27){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(0.7, 0.7, 0.7);
				bioInstruct.setTranslateMatrix(0.025, 0.02, 0.000);      
			}
			else if (instructCount==28){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(0.7, 0.7, 0.7);
				bioInstruct.setTranslateMatrix(0.025, 0.02, 0.000);      
			}
			else if (instructCount==29){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(0.0001, 0.0001, 0.0001);
					bioInstruct.setTranslateMatrix(0.00015, 0.0, 0.0);      
				}
			else {
				bioInstruct.setTransType(Constants.TRANSLATE);
				BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, 90);
				bioInstruct.setOrientation(orientationUpd);
				bioInstruct.setTranslateMatrix(0.0, -0.05, 0.0);       
			}
	
			
			
			// Add the instruction into the instruction set
    		bioMightInstructSet.addElement(bioInstruct);
		}	
			
		// Pass the instructions to the builder
		body += generateIndexFacedComponents(bioMightOrientation, bioMightInstructSet, nuclueiPoints); 	
				
		return (body);		
		
	}
  	
	
	/***********************************************************************************************************************
  	 * GENERATE LYMPHOCYTE
  	 * 
  	 * Creates Lymphocyte
  	 * 
  	 * @param bioMightTransform
  	 * @param currentPoints
  	 * @param bHeader
  	 * @param bFooter
  	 * @param diffColor
  	 * @return
  	 * 
  	 ***********************************************************************************************************************/
	
  	public static String generateLymphocyte(BioMightTransform bioMightTransform,  BioMightPosition startPos, BioMightOrientation bioMightOrientation) 	
	{		
	  	String body = "";			
		//double xStartPos = startPos.getXPos(); 
		//double yStartPos = startPos.getYPos(); 
		//double zStartPos = startPos.getZPos();
		System.out.println("\nGenerateLymphocyte() at Start Position: ");
			

		//***********************************************
		// Create the Nucleus
	  	//***********************************************
	  	double[] nukStartPos = {0.0, 0.250, 0.00};
	  	double radius = 0.000625;
		double[][] nuclueiPoints = BioGraphics.createCylinderInPlane(Constants.YPLANE, nukStartPos, radius, 8);
		

		// Move the point around, and connect it, creating a wall of 
		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstructSet = new BioMightInstructSet();
		
		int numInstructions = 15;
		//BioMightOrientation bioMightOrientation = new BioMightOrientation(0.0, 0.0, 1.0, 90);
		for (int instructCount=0; instructCount<numInstructions; instructCount++)
		{
			// Create a place for an instruction 
			BioMightInstruction bioInstruct = new BioMightInstruction();
			
			// Place a transform object into each instruction set
			bioInstruct.setBioMightTransform(bioMightTransform);
			
			bioMightTransform = new BioMightTransform();
			bioMightTransform.setTextureID(5);
			bioMightTransform.setTextureFile("PowderBlue.png");
			bioMightTransform.setComponentName("Nucleus");
			
			// Place a transform object into each instruction set
			bioInstruct.setBioMightTransform(bioMightTransform);
			
			if (instructCount==0){		
				//BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, -90);
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(25, 25, 25);
				bioInstruct.setTranslateMatrix(0.0, -0.0002, 0.0);      
			}
			else if (instructCount==1){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(2.0, 2, 2);
				bioInstruct.setTranslateMatrix(0.0, -0.0002, 0.0); 
			}
			else if (instructCount==2){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(3.25, 3.25, 3.25);
				bioInstruct.setTranslateMatrix(0.0, -0.025, 0.00);   
			}				
			else if (instructCount==3){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(2.0, 2.0, 2.0);
				bioInstruct.setTranslateMatrix(0.0, -0.050, 0.0);      
			}
			else if (instructCount==4){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.25, 1.25, 1.25);
				bioInstruct.setTranslateMatrix(0.0, -0.05, 0.0);      
			}
			else if (instructCount==5){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.10, 1.10, 1.10);
				bioInstruct.setTranslateMatrix(0.0, -0.05, 0.0);      
			}
			else if (instructCount==6){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.1, 1.1, 1.1);
				bioInstruct.setTranslateMatrix(0.0, -0.05, 0.00);      
			}
			else if (instructCount==7){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.0, -0.05, 0.00);      
			}
			else if (instructCount==8){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.0, -0.05, 0.00);       
			}
			else if (instructCount==9){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(0.9, 0.9, 0.9);
				bioInstruct.setTranslateMatrix(0.0, -0.05, 0.00);      
			}
			else if (instructCount==10){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(0.9, 0.9, 0.9);
				bioInstruct.setTranslateMatrix(0.0, -0.05, 0.00);      
			}
			else if (instructCount==11){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(0.8, 0.8, 0.8);
				bioInstruct.setTranslateMatrix(0.0, -0.05, 0.00);       
			}
			else if (instructCount==12){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(0.5, 0.5, 0.5);
				bioInstruct.setTranslateMatrix(0.0, -0.025, 0.00);     
			}
			else if (instructCount==13){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(0.25, 0.25, 0.25);
				bioInstruct.setTranslateMatrix(0.0, -0.025, 0.00);     
			}
			else if (instructCount==14){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(0.025, 0.025, 0.025);
				bioInstruct.setTranslateMatrix(0.0, -0.00025, 0.00);     
			}


			
			else {
				bioInstruct.setTransType(Constants.TRANSLATE);
				BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, 90);
				bioInstruct.setOrientation(orientationUpd);
				bioInstruct.setTranslateMatrix(0.0, -0.05, 0.0);       
			}
	
			
			
			// Add the instruction into the instruction set
    		bioMightInstructSet.addElement(bioInstruct);
		}	
			
		// Pass the instructions to the builder
		body += generateIndexFacedComponents(bioMightOrientation, bioMightInstructSet, nuclueiPoints); 	
				
		return (body);		
		
	}

  	

	/***********************************************************************************************************************
  	 * GENERATE POX VIRUS PALLISADE LAYER
  	 * 
  	 * Creates Pox Virus Core
  	 * 
  	 * @param bioMightTransform
  	 * @param currentPoints
  	 * @param bHeader
  	 * @param bFooter
  	 * @param diffColor
  	 * @return
  	 * 
  	 ***********************************************************************************************************************/
	
  	public static String generatePoxPallisade(BioMightTransform bioMightTransform,  BioMightPosition startPos, BioMightOrientation bioMightOrientation) 	
	{		
	  	String body = "";			
		//double xStartPos = startPos.getXPos(); 
		//double yStartPos = startPos.getYPos(); 
		//double zStartPos = startPos.getZPos();
		System.out.println("\nGeneratePoxPallisade() at Start Position: ");
			
		//***********************************************
		// Create the Pox Virus 
	  	//***********************************************
	  	double[] nukStartPos = {0.0, 0.250, 0.00};
	  	double radius = 0.000625;
		double[][] nuclueiPoints = BioGraphics.createCylinderInPlane(Constants.YPLANE, nukStartPos, radius, 8);
		
		// Move the point around, and connect it, creating a wall of 
		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstructSet = new BioMightInstructSet();
		
		int numInstructions = 11;
		//BioMightOrientation bioMightOrientation = new BioMightOrientation(0.0, 0.0, 1.0, 90);
		for (int instructCount=0; instructCount<numInstructions; instructCount++)
		{
			// Create a place for an instruction 
			BioMightInstruction bioInstruct = new BioMightInstruction();
			
			// Place a transform object into each instruction set
			bioInstruct.setBioMightTransform(bioMightTransform);
			
			bioMightTransform = new BioMightTransform();
			bioMightTransform.setTextureID(5);
			bioMightTransform.setTextureFile("PowderBlue.png");
			bioMightTransform.setComponentName("Nucleus");
			
			// Place a transform object into each instruction set
			bioInstruct.setBioMightTransform(bioMightTransform);
			
			if (instructCount==0){		
				//BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, -90);
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(20, 20, 20);
				bioInstruct.setTranslateMatrix(0.0, -0.0002, 0.0);      
			}
			else if (instructCount==1){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.75, 1.75, 1.75);
				bioInstruct.setTranslateMatrix(0.0, -0.0125, 0.0); 
			}
			else if (instructCount==2){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.25, 1.25, 1.25);
				bioInstruct.setTranslateMatrix(0.0, -0.0125, 0.00);   
			}				
			else if (instructCount==3){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.250, 1.250, 1.250);
				bioInstruct.setTranslateMatrix(0.0, -0.0250, 0.0);      
			}
			else if (instructCount==4){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.1, 1.1, 1.1);
				bioInstruct.setTranslateMatrix(0.0, -0.05, 0.0);      
			}
			else if (instructCount==5){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.0, -0.05, 0.0);      
			}
			else if (instructCount==6){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(0.95, 0.95, 0.95);
				bioInstruct.setTranslateMatrix(0.0, -0.05, 0.00);      
			}
			else if (instructCount==7){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(0.85, 0.85, 0.85);
				bioInstruct.setTranslateMatrix(0.0, -0.025, 0.00);      
			}
			else if (instructCount==8){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(0.75, 0.75, 0.75);
				bioInstruct.setTranslateMatrix(0.0, -0.025, 0.00);       
			}
			else if (instructCount==9){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(0.5, 0.5, 0.5);
				bioInstruct.setTranslateMatrix(0.0, -0.0125, 0.00);       
			}
			else if (instructCount==10){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(0.0025, 0.0025, 0.025);
				bioInstruct.setTranslateMatrix(0.0, -0.00025, 0.00);      
			}
			
			
			else if (instructCount==11){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(0.8, 0.8, 0.8);
				bioInstruct.setTranslateMatrix(0.0, -0.05, 0.00);       
			}
			else if (instructCount==12){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(0.5, 0.5, 0.5);
				bioInstruct.setTranslateMatrix(0.0, -0.025, 0.00);     
			}
			else if (instructCount==13){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(0.25, 0.25, 0.25);
				bioInstruct.setTranslateMatrix(0.0, -0.025, 0.00);     
			}
			else if (instructCount==14){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(0.025, 0.025, 0.025);
				bioInstruct.setTranslateMatrix(0.0, -0.00025, 0.00);     
			}

			else {
				bioInstruct.setTransType(Constants.TRANSLATE);
				BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, 90);
				bioInstruct.setOrientation(orientationUpd);
				bioInstruct.setTranslateMatrix(0.0, -0.05, 0.0);       
			}
	
			
			// Add the instruction into the instruction set
    		bioMightInstructSet.addElement(bioInstruct);
		}	
		
		// We need to run this as a seperate/parallel instruction set that
		// gets assembled above.  This way we can control individual spikes
		// on the points
		
		// Pass the instructions to the builder for the POX Virus Appendages
		double[] taperPoint = {0.25, 0.50};
		double[] taperValue = {radius, radius/3};
		int minAppendages = 6;
		int maxAppendages = 10;
		double latitude = 0.0;
		double longitude = 60.0;

		double orbitalRadius  = 0.005; 	
	  	double dendriteRadius = 0.01;
		double minRadius = 0.001;;
		double maxRadius = 0.00725;
		
		BioMightAppendage bioMightAppendage = new BioMightAppendage(Constants.PalisadeLayerRef, Constants.PoxVirus, orbitalRadius, minRadius, maxRadius,
			    dendriteRadius, taperPoint,
				taperValue, minAppendages, maxAppendages,
				latitude, longitude, 75, 90, 75, 90, bioMightTransform.getTextureID(), bioMightTransform.getTextureFile());
		
		body += generateIndexFacedComponents(null, bioMightOrientation, bioMightInstructSet, nuclueiPoints); 	
				
		return (body);		
		
	}


	/***********************************************************************************************************************
  	 * GENERATE POX VIRUS CORE WALL
  	 * 
  	 * Creates Pox Virus Core
  	 * 
  	 * @param bioMightTransform
  	 * @param currentPoints
  	 * @param bHeader
  	 * @param bFooter
  	 * @param diffColor
  	 * @return
  	 * 
  	 ***********************************************************************************************************************/
	
  	public static String generatePoxVirusCoreMembrane(BioMightTransform bioMightTransform,  BioMightPosition startPos, BioMightOrientation bioMightOrientation) 	
	{		
	  	String body = "";			
		//double xStartPos = startPos.getXPos(); 
		//double yStartPos = startPos.getYPos(); 
		//double zStartPos = startPos.getZPos();
		System.out.println("\nGeneratePoxVirusCoreMembrane() at Start Position: ");
			
		//***********************************************
		// Create the Pox Virus Core Wall
	  	//***********************************************
	  	double[] nukStartPos = {startPos.getXPos(), startPos.getYPos(), startPos.getZPos()};
	  	double radius = 0.000625;
		double[][] nuclueiPoints = BioGraphics.createCylinderInPlane(Constants.YPLANE, nukStartPos, radius, 8);
		
		// Move the point around, and connect it, creating a wall of 
		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstructSet = new BioMightInstructSet();
		BioMightAppendage bioMightAppendage = null;
		
		int numInstructions = 11;
		//BioMightOrientation bioMightOrientation = new BioMightOrientation(0.0, 0.0, 1.0, 90);
		for (int instructCount=0; instructCount<numInstructions; instructCount++)
		{
			// Create a place for an instruction 
			BioMightInstruction bioInstruct = new BioMightInstruction();
						
			bioMightTransform = new BioMightTransform();
			bioMightTransform.setTextureID(5);
			bioMightTransform.setTextureFile("PowderBlue.png");
			bioMightTransform.setComponentName("Core Wall");
			
			// Place a transform object into each instruction set
			bioInstruct.setBioMightTransform(bioMightTransform);
			
			// Pass the instructions to the builder for the Appendages
			double[] taperPoint = {};
			double[] taperValue = {};
			int minAppendages = 3;
			int maxAppendages = 4;
			double latitude = 0.0;
			double longitude = 90.0;

			double orbitalRadius  = 0.005; 	
		  	double dendriteRadius = 0.002;
		  	double minRadius = 0.0008;
			double maxRadius = 0.002;
			
			String textureFileName = "SpeckledOrange.png";
			int textureID = 1;
			bioMightAppendage = new BioMightAppendage(Constants.PalisadeLayer, Constants.CoreMembrane, 
					orbitalRadius, minRadius, maxRadius,
				    dendriteRadius, taperPoint,
					taperValue, minAppendages, maxAppendages,
					latitude, longitude, 0, 5, 0, 5, textureID, textureFileName);
		
			// Place the appendage into the instruction set
			bioInstruct.setBioMightAppendage(bioMightAppendage);
			bioInstruct.setFillAppendage(true); 
			
			if (instructCount==0){		
				//BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, -90);
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(25, 25, 15);
				bioInstruct.setTranslateMatrix(0.0, -0.0002, 0.0);   
				
				// Do not create appendages on the endcap
				bioInstruct.setBioMightAppendage(null);
			}
			else if (instructCount==1){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(2.5, 2.5, 1.25);
				bioInstruct.setTranslateMatrix(0.0, -0.00225, 0.00); 
				
				// Do not create appendages on endcap
				bioInstruct.setBioMightAppendage(null);
			}
			else if (instructCount==2){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.1, 1.1, 1.1);
				bioInstruct.setTranslateMatrix(0.0, -0.0250, 0.00);

				// Do not create appendages on endcap
				//bioInstruct.setBioMightAppendage(null);
			}				
			else if (instructCount==3){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.0, -0.0250, 0.0);
				
				// Do not create appendages on endcap
				//bioInstruct.setBioMightAppendage(null);
			}
			else if (instructCount==4){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(0.65, 0.65, 1.0);
				bioInstruct.setTranslateMatrix(0.0, -0.025, 0.0);
				
				// Do not create appendages on endcap
				//bioInstruct.setBioMightAppendage(null);
			}
			else if (instructCount==5){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(0.85, 0.85, 1.0);
				bioInstruct.setTranslateMatrix(0.0, -0.025, 0.0);
				
				// Do not create appendages on endcap
				//bioInstruct.setBioMightAppendage(null);
			}
			else if (instructCount==6){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.0, -0.0125, 0.00);
				
				// Do not create appendages on endcap
				//bioInstruct.setBioMightAppendage(null);
			}
			else if (instructCount==7){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.65, 1.65, 1.1);
				bioInstruct.setTranslateMatrix(0.0, -0.025, 0.00);       
				
				// Do not create appendages on endcap
				//bioInstruct.setBioMightAppendage(null);
			}
			else if (instructCount==8){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.1, 1.1, 1.0);
				bioInstruct.setTranslateMatrix(0.0, -0.025, 0.00);
				
			}
			else if (instructCount==9){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(0.98, 0.98, 0.98);
				bioInstruct.setTranslateMatrix(0.0, -0.025, 0.00);
				
				// Do not create appendages on endcap
				//bioInstruct.setBioMightAppendage(null);
			}
			else if (instructCount==10){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(0.0025, 0.0025, 0.025);
				bioInstruct.setTranslateMatrix(0.0, -0.00025, 0.00);
				
				// Do not create appendages on endcap
				bioInstruct.setBioMightAppendage(null);
			}
			
			
			else if (instructCount==11){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(0.5, 0.5, 0.5);
				bioInstruct.setTranslateMatrix(0.0, -0.025, 0.00);     
			}
			else {
				bioInstruct.setTransType(Constants.TRANSLATE);
				BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, 90);
				bioInstruct.setOrientation(orientationUpd);
				bioInstruct.setTranslateMatrix(0.0, -0.05, 0.0);       
			}
	
			
			BioMightAppendage biomio = bioInstruct.getBioMightAppendage(); 
			if (biomio == null)
				System.out.println("Appendage is null for instruction: " + instructCount);
			
			
			// Add the instruction into the instruction set		
    		bioMightInstructSet.addElement(bioInstruct);
		}	
		
		// We need to run this as a seperate/parallel instruction set that
		// gets assembled above.  This way we can control individual spikes
		// on the points
		
		
		
		body += generateIndexFacedComponents(bioMightOrientation, bioMightInstructSet, nuclueiPoints); 	
				
		return (body);		
		
	}


  	
	/***********************************************************************************************************************
  	 * GENERATE POX VIRUS CORE WALL
  	 * 
  	 * Creates Pox Virus Core
  	 * 
  	 * @param bioMightTransform
  	 * @param currentPoints
  	 * @param bHeader
  	 * @param bFooter
  	 * @param diffColor
  	 * @return
  	 * 
  	 ***********************************************************************************************************************/
	
  	public static String generateArtery(BioMightTransform bioMightTransform,  BioMightPosition startPos, BioMightOrientation bioMightOrientation) 	
	{		
	  	String body = "";			
		//double xStartPos = startPos.getXPos(); 
		//double yStartPos = startPos.getYPos(); 
		//double zStartPos = startPos.getZPos();
		System.out.println("\nGenerateArtery() at Start Position: ");
			
		//***********************************************
		// Create the Artery
	  	//***********************************************
	  	double[] arteryStartPos = {startPos.getXPos(), startPos.getYPos(), startPos.getZPos()};
	  	double radius = 0.0825;
	  	double orient[] = {0, 0, 0};
		double[][] arteryPoints = BioGraphics.createCylinderInPlane(Constants.YPLANE, arteryStartPos, radius, 8);
		
		// Move the point around, and connect it, creating a wall of 
		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstructSet = new BioMightInstructSet();
		BioMightAppendage bioMightAppendage = null;
		
		int numInstructions = 3;
		//BioMightOrientation bioMightOrientation = new BioMightOrientation(0.0, 0.0, 1.0, 90);
		for (int instructCount=0; instructCount<numInstructions; instructCount++)
		{
			// Create a place for an instruction 
			BioMightInstruction bioInstruct = new BioMightInstruction();
						
			bioMightTransform = new BioMightTransform();
			bioMightTransform.setTextureID(5);
			bioMightTransform.setTextureFile("PowderBlue.png");
			bioMightTransform.setComponentName("Endothelium");
			
			// Place a transform object into each instruction set
			bioInstruct.setBioMightTransform(bioMightTransform);
				
			// Place the appendage into the instruction set
			bioInstruct.setBioMightAppendage(null);
			bioInstruct.setFillAppendage(true); 
			
			if (instructCount==0){
				bioInstruct.setTransType(Constants.TRANSLATE);
				bioInstruct.setTranslateMatrix(0.0, -0.5, 0.0);
			}
			else if (instructCount==1){			
				BioMightOrientation orientation = new BioMightOrientation(0.0, -1.0, 0.0, 90.0);
	 			bioInstruct.setTransType(Constants.ROTATEOCTO);
    			bioInstruct.setTheta(45);	
    			bioInstruct.setPivotPoint(0);	
     			bioInstruct.setRotateVector(0.0, 0.0, 1.0);
     			bioInstruct.setOrientation(orientation);
			}
			else if (instructCount==2){			
				BioMightOrientation orientation = new BioMightOrientation(0.0, -1.0, 0.0, 90.0);
	 			bioInstruct.setTransType(Constants.ROTATEOCTO);
    			bioInstruct.setTheta(45);	
    			bioInstruct.setPivotPoint(0);	
     			bioInstruct.setRotateVector(0.0, 0.0, 1.0);
     			bioInstruct.setOrientation(orientation);
			}
			
		
			
			else {
				bioInstruct.setTransType(Constants.TRANSLATE);
				bioInstruct.setTranslateMatrix(0.0, -1.0, 0.0);
			}
				
			
			// Add the instruction into the instruction set		
    		bioMightInstructSet.addElement(bioInstruct);
		}	
		
		
		
		body += generateIndexFacedComponents(bioMightOrientation, bioMightInstructSet, arteryPoints); 	
				
		return (body);		
		
	}

	/***********************************************************************************************************************
  	 * GENERATE POX VIRUS CORE WALL
  	 * 
  	 * Creates Pox Virus Core
  	 * 
  	 * @param bioMightTransform
  	 * @param currentPoints
  	 * @param bHeader
  	 * @param bFooter
  	 * @param diffColor
  	 * @return
  	 * 
  	 ***********************************************************************************************************************/
	
  	public static String generateBone(BioMightTransform bioMightTransform,  BioMightPosition startPos, BioMightOrientation bioMightOrientation) 	
	{		
	  	String body = "";			
		//double xStartPos = startPos.getXPos(); 
		//double yStartPos = startPos.getYPos(); 
		//double zStartPos = startPos.getZPos();
		System.out.println("\nGenerateBone() at Start Position: ");
			
		//***********************************************
		// Create the Bone
	  	//***********************************************
	  	double[] arteryStartPos = {startPos.getXPos(), startPos.getYPos(), startPos.getZPos()};
	  	double radius = 0.030;
		double[][] arteryPoints = BioGraphics.createCylinderInPlane(Constants.YPLANE, arteryStartPos, radius, 8);
		
		// Move the point around, and connect it, creating a wall of 
		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstructSet = new BioMightInstructSet();
		BioMightAppendage bioMightAppendage = null;
		
		int numInstructions = 18;
		//BioMightOrientation bioMightOrientation = new BioMightOrientation(0.0, 0.0, 1.0, 90);
		for (int instructCount=0; instructCount<numInstructions; instructCount++)
		{
			// Create a place for an instruction 
			BioMightInstruction bioInstruct = new BioMightInstruction();
						
			bioMightTransform = new BioMightTransform();
			bioMightTransform.setTextureID(5);
			bioMightTransform.setTextureFile("PowderBlue.png");
			bioMightTransform.setComponentName("Bone");
			
			// Place a transform object into each instruction set
			bioInstruct.setBioMightTransform(bioMightTransform);
				
			// Place the appendage into the instruction set
			bioInstruct.setBioMightAppendage(null);
			bioInstruct.setFillAppendage(true); 
			
			if (instructCount==0){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(22.0, 22.0, 20.0);
				bioInstruct.setTranslateMatrix(0.0, -0.00025, 0.00);  
			}
			else if (instructCount==1){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.1, 1.0, 1.5);
				bioInstruct.setTranslateMatrix(0.0, -0.25, 0.00);  
			}
			else if (instructCount==2){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.3);
				bioInstruct.setTranslateMatrix(0.0, -0.25, 0.00); 
			}
			else if (instructCount==3){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.2);
				bioInstruct.setTranslateMatrix(0.0, -0.25, 0.0);
			}	
			else if (instructCount==4){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.0, -0.25, 0.0);
			}	
			else if (instructCount==5){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(0.9, 1.0, 0.9);
				bioInstruct.setTranslateMatrix(0.0, -0.25, 0.0);	
			}	
			else if (instructCount==6){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 0.7);
				bioInstruct.setTranslateMatrix(0.0, -0.25, 0.0);
			}	
			else if (instructCount==7){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(0.95, 1.0, 0.6);
				bioInstruct.setTranslateMatrix(0.0, -0.25, 0.0);
			}		
			else if (instructCount==8){
				bioInstruct.setTransType(Constants.TRANSLATE);
				bioInstruct.setTranslateMatrix(0.0, -1.0, 0.0);
			}	
			else if (instructCount==9){
				bioInstruct.setTransType(Constants.TRANSLATE);
				bioInstruct.setTranslateMatrix(0.0, -1.0, 0.0);
			}	
			else if (instructCount==10){
				bioInstruct.setTransType(Constants.TRANSLATE);
				bioInstruct.setTranslateMatrix(0.0, -1.0, 0.0);
			}
			else if (instructCount==11){
				bioInstruct.setTransType(Constants.TRANSLATE);
				bioInstruct.setTranslateMatrix(0.0, -1.0, 0.0);
				bioInstruct.setScaleMatrix(0.0, 1.0, 1.0);
			}			
			else if (instructCount==12){
				bioInstruct.setTransType(Constants.TRANSLATE);
				bioInstruct.setTranslateMatrix(0.0, -1.0, 0.0);
			}
			else if (instructCount==13){
				bioInstruct.setTransType(Constants.TRANSLATE);
				bioInstruct.setTranslateMatrix(0.0, -1.0, 0.0);
			}	
			else if (instructCount==14){
				bioInstruct.setTransType(Constants.TRANSLATE);
				bioInstruct.setTranslateMatrix(0.0, -1.0, 0.0);
			}	
			else if (instructCount==15){
				bioInstruct.setTransType(Constants.TRANSLATE);
				bioInstruct.setTranslateMatrix(0.0, -1.0, 0.0);
			}	
			else if (instructCount==16){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.35, 1.35, 1.1);
				bioInstruct.setTranslateMatrix(0.0, -1.0, 0.0);
			}	
			else if (instructCount==17){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.15, 1.15, 1.0);
				bioInstruct.setTranslateMatrix(0.0, -1.0, 0.0);
			}		
			
			
			else if (instructCount==18){
				bioInstruct.setTransType(Constants.TRANSLATE);
				bioInstruct.setTranslateMatrix(0.0, -0.5, 0.0);
			}	
			else {
				bioInstruct.setTransType(Constants.TRANSLATE);
				bioInstruct.setTranslateMatrix(0.0, -1.0, 0.0);
			}
				
			
			// Add the instruction into the instruction set		
    		bioMightInstructSet.addElement(bioInstruct);
		}	
		
		
		
		body += generateIndexFacedComponents(bioMightOrientation, bioMightInstructSet, arteryPoints); 	
				
		return (body);		
		
	}

 	
  	
  	
	/***********************************************************************************************************************
  	 * GENERATE POX VIRUS OUTER MEMBRANE
  	 * 
  	 * Creates Pox Virus Outer Membrane
  	 * 
  	 * @param bioMightTransform
  	 * @param currentPoints
  	 * @param bHeader
  	 * @param bFooter
  	 * @param diffColor
  	 * @return
  	 * 
  	 ***********************************************************************************************************************/
	
  	public static String generatePoxVirusOuterMembrane(BioMightTransform bioMightTransform,  BioMightPosition startPos, BioMightOrientation bioMightOrientation) 	
	{		
	  	String body = "";		
		//double xStartPos = startPos.getXPos(); 
		//double yStartPos = startPos.getYPos(); 
		//double zStartPos = startPos.getZPos();
		System.out.println("\nGeneratePoxVirusOuterMembrane() using Texture: " + bioMightTransform.getTextureID() + "  " + bioMightTransform.getTextureFile());
			
		//***********************************************
		// Create the Pox Virus 
	  	//***********************************************
	  	double[] nukStartPos = {startPos.getXPos(), startPos.getYPos(), startPos.getZPos()};
	  	double radius = 0.000625;
		double[][] nuclueiPoints = BioGraphics.createCylinderInPlane(Constants.YPLANE, nukStartPos, radius, 8);
		
		// Move the point around, and connect it, creating a wall of 
		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstructSet = new BioMightInstructSet();
		
		int numInstructions = 11;
		//BioMightOrientation bioMightOrientation = new BioMightOrientation(0.0, 0.0, 1.0, 90);
		for (int instructCount=0; instructCount<numInstructions; instructCount++)
		{
			// Create a place for an instruction 
			BioMightInstruction bioInstruct = new BioMightInstruction();
			
			// Make the name come out for the capsid
			bioMightTransform = new BioMightTransform();
			bioMightTransform.setTextureID(5);
			bioMightTransform.setTextureFile("SpeckledOlive.png");
			bioMightTransform.setComponentName("Outer Membrane");
			
			// Place a transform object into each instruction set
			bioInstruct.setBioMightTransform(bioMightTransform);

			// Pass the instructions to the builder for the Appendages
			double[] taperPoint = {};
			double[] taperValue = {};
			int minAppendages = 2;
			int maxAppendages = 2;
			double latitude = 0.0;
			double longitude = 90.0;
			
			
			
			double orbitalRadius  = 0.005; 	
		  	double dendriteRadius = 0.002;
			double minRadius = 0.008;
			double maxRadius = 0.01;
			
			String tubulesTexture = "PowderBlue.png";
			int textureID = 1;
			BioMightAppendage bioMightAppendage = new BioMightAppendage("Membrane Tubules", Constants.PoxVirus, orbitalRadius, minRadius, maxRadius,
				    dendriteRadius, taperPoint,
					taperValue, minAppendages, maxAppendages,
					latitude, longitude, 75, 90, 75, 90, textureID, tubulesTexture);
		
			// Place the appendage into the instruction set
			bioInstruct.setBioMightAppendage(bioMightAppendage);
			bioInstruct.setFillAppendage(false); 
			
			if (instructCount==0){		
				//BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, -90);
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(25, 25, 25);
				bioInstruct.setTranslateMatrix(0.0, -0.0002, 0.0);
				bioInstruct.setBioMightAppendage(null);
			}
			else if (instructCount==1){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(2.75, 2.75, 2.75);
				bioInstruct.setTranslateMatrix(0.0, -0.0125, 0.0);
				bioInstruct.setBioMightAppendage(null);	
			}
			else if (instructCount==2){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.75,1.75, 1.75);
				bioInstruct.setTranslateMatrix(0.0, -0.0125, 0.00);   
				
				bioMightAppendage.setLongitude(45);
				bioMightAppendage.setAngleLongitudeMinDev(40);
				bioMightAppendage.setAngleLongitudeMaxDev(50);
				
				//bioMightAppendage.setLatitude(angleLongitudeMinDev);
				//bioMightAppendage.setAngleLatitudeMinDev(angleLongitudeMinDev);
				//bioMightAppendage.setAngleLatitudeMaxDev(angleLongitudeMinDev);
			
				// Place the appendage into the instruction set
				bioInstruct.setBioMightAppendage(bioMightAppendage);
				bioInstruct.setFillAppendage(false); 
				
			}				
			else if (instructCount==3){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.250, 1.250, 1.250);
				bioInstruct.setTranslateMatrix(0.0, -0.0250, 0.0);      

				bioMightAppendage.setLongitude(45);
				bioMightAppendage.setAngleLongitudeMinDev(40);
				bioMightAppendage.setAngleLongitudeMaxDev(50);
				
				//bioMightAppendage.setLatitude(angleLongitudeMinDev);
				//bioMightAppendage.setAngleLatitudeMinDev(angleLongitudeMinDev);
				//bioMightAppendage.setAngleLatitudeMaxDev(angleLongitudeMinDev);
			
				// Place the appendage into the instruction set
				bioInstruct.setBioMightAppendage(bioMightAppendage);
				bioInstruct.setFillAppendage(false); 
			
			}
			else if (instructCount==4){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.1, 1.1, 1.1);
				bioInstruct.setTranslateMatrix(0.0, -0.05, 0.0);      
			}
			else if (instructCount==5){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.0, -0.05, 0.0);      
			}
			else if (instructCount==6){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(0.95, 0.95, 0.95);
				bioInstruct.setTranslateMatrix(0.0, -0.05, 0.00);      
			}
			else if (instructCount==7){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(0.85, 0.85, 0.85);
				bioInstruct.setTranslateMatrix(0.0, -0.025, 0.00);      
			}
			else if (instructCount==8){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(0.75, 0.75, 0.75);
				bioInstruct.setTranslateMatrix(0.0, -0.025, 0.00);       
	
				bioMightAppendage.setLongitude(125);
				bioMightAppendage.setAngleLongitudeMinDev(120);
				bioMightAppendage.setAngleLongitudeMaxDev(130);
						
				// Place the appendage into the instruction set
				bioInstruct.setBioMightAppendage(bioMightAppendage);
				
				// Set the fill to false
				bioInstruct.setFillAppendage(false); 
			}
			else if (instructCount==9){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(0.5, 0.5, 0.5);
				bioInstruct.setTranslateMatrix(0.0, -0.0125, 0.00);       
				
				bioMightAppendage.setLongitude(125);
				bioMightAppendage.setAngleLongitudeMinDev(120);
				bioMightAppendage.setAngleLongitudeMaxDev(130);
						
				// Place the appendage into the instruction set
				bioInstruct.setBioMightAppendage(bioMightAppendage);
				
				// Set the fill to false
				bioInstruct.setFillAppendage(false); 
			}
			else if (instructCount==10){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(0.0025, 0.0025, 0.025);
				bioInstruct.setTranslateMatrix(0.0, -0.00025, 0.00);
				
				bioMightAppendage.setLongitude(175);
				bioMightAppendage.setAngleLongitudeMinDev(170);
				bioMightAppendage.setAngleLongitudeMaxDev(180);
						
				// Place the appendage into the instruction set
				bioInstruct.setBioMightAppendage(bioMightAppendage);
				
				// Set the fill to false
				bioInstruct.setFillAppendage(false); 
			}
			
			
			else if (instructCount==11){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(0.8, 0.8, 0.8);
				bioInstruct.setTranslateMatrix(0.0, -0.05, 0.00);       
			}
			else if (instructCount==12){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(0.5, 0.5, 0.5);
				bioInstruct.setTranslateMatrix(0.0, -0.025, 0.00);     
			}
			else if (instructCount==13){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(0.25, 0.25, 0.25);
				bioInstruct.setTranslateMatrix(0.0, -0.025, 0.00);     
			}
			else if (instructCount==14){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(0.025, 0.025, 0.025);
				bioInstruct.setTranslateMatrix(0.0, -0.00025, 0.00);     
			}

			else {
				bioInstruct.setTransType(Constants.TRANSLATE);
				BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, 90);
				bioInstruct.setOrientation(orientationUpd);
				bioInstruct.setTranslateMatrix(0.0, -0.05, 0.0);       
			}
	
			
			// Add the instruction into the instruction set
    		bioMightInstructSet.addElement(bioInstruct);
		}	
		
		body += generateIndexFacedComponents(bioMightOrientation, bioMightInstructSet, nuclueiPoints); 	
				
		return (body);		
		
	}
  	
  	
	/***********************************************************************************************************************
  	 * GENERATE POX VIRUS LATERAL BODY
  	 * 
  	 * Creates Pox Virus Lateral Body
  	 * 
  	 * @param bioMightTransform
  	 * @param currentPoints
  	 * @param bHeader
  	 * @param bFooter
  	 * @param diffColor
  	 * @return
  	 * 
  	 ***********************************************************************************************************************/
	
  	public static String generatePoxVirusLateralBody(BioMightTransform bioMightTransform,  BioMightPosition startPos, BioMightOrientation bioMightOrientation) 	
	{		
	  	String body = "";		
		//double xStartPos = startPos.getXPos(); 
		//double yStartPos = startPos.getYPos(); 
		//double zStartPos = startPos.getZPos();
		System.out.println("\nGeneratePoxVirusLateralBody() using Texture: " + bioMightTransform.getTextureID() + "  " + bioMightTransform.getTextureFile());
			
		//***********************************************
		// Create the Pox Virus 
	  	//***********************************************
	  	double[] tempStartPos = {startPos.getXPos(), startPos.getYPos(), startPos.getZPos()};
	  	double radius = 0.000625;
		double[][] nuclueiPoints = BioGraphics.createCylinderInPlane(Constants.YPLANE, tempStartPos, radius, 8);
		
		// Move the point around, and connect it, creating a wall of 
		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstructSet = new BioMightInstructSet();
		
		if (startPos.getXPos() > 0)
		{
			int numInstructions = 14;
			//BioMightOrientation bioMightOrientation = new BioMightOrientation(0.0, 0.0, 1.0, 90);
			for (int instructCount=0; instructCount<numInstructions; instructCount++)
			{
				// Create a place for an instruction 
				BioMightInstruction bioInstruct = new BioMightInstruction();
				
				// Make the name come out for the capsid
				bioMightTransform.setComponentName("LateralBody");
				
				// Place a transform object into each instruction set
				bioInstruct.setBioMightTransform(bioMightTransform);
				
				
				bioMightTransform = new BioMightTransform();
				bioMightTransform.setTextureID(5);
				bioMightTransform.setTextureFile("SpeckledTeal.png");
				bioMightTransform.setComponentName("Lateral Body");
				
				// Place a transform object into each instruction set
				bioInstruct.setBioMightTransform(bioMightTransform);
				
				if (instructCount==0){		
					//BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, -90);
					bioInstruct.setTransType(Constants.SCALE);
					bioInstruct.setScaleMatrix(7, 7, 7);
					bioInstruct.setTranslateMatrix(0.0, -0.0002, 0.0);      
				}
				else if (instructCount==1){
					bioInstruct.setTransType(Constants.SCALE);
					bioInstruct.setScaleMatrix(2.75, 2.75, 2.0);
					bioInstruct.setTranslateMatrix(0.0, -0.0025, 0.0); 
				}
				else if (instructCount==2){
					bioInstruct.setTransType(Constants.SCALE);
					bioInstruct.setScaleMatrix(1.65, 1.65, 1.65);
					bioInstruct.setTranslateMatrix(0.0, -0.0125, 0.00);   
				}				
				else if (instructCount==3){
					bioInstruct.setTransType(Constants.SCALE);
					bioInstruct.setScaleMatrix(1.20, 1.20, 1.20);
					bioInstruct.setTranslateMatrix(-0.002, -0.0125, 0.0);      
				}
				else if (instructCount==4){
					bioInstruct.setTransType(Constants.SCALE);
					bioInstruct.setScaleMatrix(1.275, 1.275, 1.2);
					bioInstruct.setTranslateMatrix(-0.005, -0.0125, 0.0);      
				}
				else if (instructCount==5){
					bioInstruct.setTransType(Constants.SCALE);
					bioInstruct.setScaleMatrix(1.175, 1.175, 1.175);
					bioInstruct.setTranslateMatrix(-0.005, -0.0125, 0.0);      
				}
				else if (instructCount==6){
					bioInstruct.setTransType(Constants.SCALE);
					bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
					bioInstruct.setTranslateMatrix(0.0, -0.0125, 0.0);      
				}
				else if (instructCount==7){
					bioInstruct.setTransType(Constants.SCALE);
					bioInstruct.setScaleMatrix(0.90, 0.90, 0.90	);
					bioInstruct.setTranslateMatrix(0.001, -0.0125, 0.00);      
				}
				else if (instructCount==8){
					bioInstruct.setTransType(Constants.SCALE);
					bioInstruct.setScaleMatrix(0.80, 0.80, 0.80);
					bioInstruct.setTranslateMatrix(0.002, -0.0125, 0.00);       
				}
				else if (instructCount==9){
					bioInstruct.setTransType(Constants.SCALE);
					bioInstruct.setScaleMatrix(0.85, 0.85, 0.85);
					bioInstruct.setTranslateMatrix(0.003, -0.0125, 0.00);       
				}
				else if (instructCount==10){
					bioInstruct.setTransType(Constants.SCALE);
					bioInstruct.setScaleMatrix(0.80, 0.80, 0.80);
					bioInstruct.setTranslateMatrix(0.001, -0.0125, 0.00);       
				}
				else if (instructCount==11){
					bioInstruct.setTransType(Constants.SCALE);
					bioInstruct.setScaleMatrix(0.65, 0.65, 0.65);
					bioInstruct.setTranslateMatrix(0.002, -0.0125, 0.00);       
				}
				else if (instructCount==12){
					bioInstruct.setTransType(Constants.SCALE);
					bioInstruct.setScaleMatrix(0.0025, 0.0025, 0.0025);
					bioInstruct.setTranslateMatrix(0.001, -0.0025, 0.00);      
				}
				else if (instructCount==13){
					bioInstruct.setTransType(Constants.SCALE);
					bioInstruct.setScaleMatrix(0.0025, 0.0025, 0.0025);
					bioInstruct.setTranslateMatrix(0.0, -0.00025, 0.00);      
				}
								
				
				else {
					bioInstruct.setTransType(Constants.TRANSLATE);
					BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, 90);
					bioInstruct.setOrientation(orientationUpd);
					bioInstruct.setTranslateMatrix(0.0, -0.05, 0.0);       
				}
		
				
				// Add the instruction into the instruction set
	    		bioMightInstructSet.addElement(bioInstruct);
			}	
		}
		else
		{
			int numInstructions = 14;
			//BioMightOrientation bioMightOrientation = new BioMightOrientation(0.0, 0.0, 1.0, 90);
			for (int instructCount=0; instructCount<numInstructions; instructCount++)
			{
				// Create a place for an instruction 
				BioMightInstruction bioInstruct = new BioMightInstruction();
				
				// Make the name come out for the capsid
				bioMightTransform.setComponentName("LateralBody");
				
				// Place a transform object into each instruction set
				bioInstruct.setBioMightTransform(bioMightTransform);
				
				
				bioMightTransform = new BioMightTransform();
				bioMightTransform.setTextureID(5);
				bioMightTransform.setTextureFile("SpeckledTeal.png");
				bioMightTransform.setComponentName("Lateral Body");
				
				// Place a transform object into each instruction set
				bioInstruct.setBioMightTransform(bioMightTransform);
				
				if (instructCount==0){		
					//BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, -90);
					bioInstruct.setTransType(Constants.SCALE);
					bioInstruct.setScaleMatrix(7, 7, 7);
					bioInstruct.setTranslateMatrix(0.0, -0.0002, 0.0);      
				}
				else if (instructCount==1){
					bioInstruct.setTransType(Constants.SCALE);
					bioInstruct.setScaleMatrix(2.75, 2.75, 2.0);
					bioInstruct.setTranslateMatrix(0.0, -0.0025, 0.0); 
				}
				else if (instructCount==2){
					bioInstruct.setTransType(Constants.SCALE);
					bioInstruct.setScaleMatrix(1.65, 1.65, 1.65);
					bioInstruct.setTranslateMatrix(0.0, -0.0125, 0.00);   
				}				
				else if (instructCount==3){
					bioInstruct.setTransType(Constants.SCALE);
					bioInstruct.setScaleMatrix(1.20, 1.20, 1.20);
					bioInstruct.setTranslateMatrix(0.002, -0.0125, 0.0);      
				}
				else if (instructCount==4){
					bioInstruct.setTransType(Constants.SCALE);
					bioInstruct.setScaleMatrix(1.275, 1.275, 1.2);
					bioInstruct.setTranslateMatrix(0.005, -0.0125, 0.0);      
				}
				else if (instructCount==5){
					bioInstruct.setTransType(Constants.SCALE);
					bioInstruct.setScaleMatrix(1.175, 1.175, 1.175);
					bioInstruct.setTranslateMatrix(0.005, -0.0125, 0.0);      
				}
				else if (instructCount==6){
					bioInstruct.setTransType(Constants.SCALE);
					bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
					bioInstruct.setTranslateMatrix(0.0, -0.0125, 0.0);      
				}
				else if (instructCount==7){
					bioInstruct.setTransType(Constants.SCALE);
					bioInstruct.setScaleMatrix(0.90, 0.90, 0.90	);
					bioInstruct.setTranslateMatrix(-0.001, -0.0125, 0.00);      
				}
				else if (instructCount==8){
					bioInstruct.setTransType(Constants.SCALE);
					bioInstruct.setScaleMatrix(0.80, 0.80, 0.80);
					bioInstruct.setTranslateMatrix(-0.002, -0.0125, 0.00);       
				}
				else if (instructCount==9){
					bioInstruct.setTransType(Constants.SCALE);
					bioInstruct.setScaleMatrix(0.85, 0.85, 0.85);
					bioInstruct.setTranslateMatrix(-0.003, -0.0125, 0.00);       
				}
				else if (instructCount==10){
					bioInstruct.setTransType(Constants.SCALE);
					bioInstruct.setScaleMatrix(0.80, 0.80, 0.80);
					bioInstruct.setTranslateMatrix(-0.001, -0.0125, 0.00);       
				}
				else if (instructCount==11){
					bioInstruct.setTransType(Constants.SCALE);
					bioInstruct.setScaleMatrix(0.65, 0.65, 0.65);
					bioInstruct.setTranslateMatrix(-0.002, -0.0125, 0.00);       
				}
				else if (instructCount==12){
					bioInstruct.setTransType(Constants.SCALE);
					bioInstruct.setScaleMatrix(0.0025, 0.0025, 0.0025);
					bioInstruct.setTranslateMatrix(-0.001, -0.0025, 0.00);      
				}
				else if (instructCount==13){
					bioInstruct.setTransType(Constants.SCALE);
					bioInstruct.setScaleMatrix(0.0025, 0.0025, 0.0025);
					bioInstruct.setTranslateMatrix(0.0, -0.00025, 0.00);      
				}
												
				else 
				{
					bioInstruct.setTransType(Constants.TRANSLATE);
					BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, 90);
					bioInstruct.setOrientation(orientationUpd);
					bioInstruct.setTranslateMatrix(0.0, -0.05, 0.0);       
				}
		
				
				// Add the instruction into the instruction set
	    		bioMightInstructSet.addElement(bioInstruct);
			}
		}
		
		// We need to run this as a seperate/parallel instruction set that
		// gets assembled above.  This way we can control individual spikes
		// on the points
		
		// Pass the instructions to the builder for the POX Virus Appendages
		double[] taperPoint = {0.25, 0.50};
		double[] taperValue = {radius, radius/3};
		int minAppendages = 6;
		int maxAppendages = 10;
		double latitude = 0.0;
		double longitude = 60.0;

		double orbitalRadius  = 0.005; 	
	  	double dendriteRadius = 0.01;
		double minRadius = 0.001;;
		double maxRadius = 0.00725;
		
		//BioMightAppendage bioMightAppendage = new BioMightAppendage(Constants.PoxVirus, orbitalRadius, minRadius, maxRadius,
		//	    dendriteRadius, taperPoint,
		//		taperValue, minAppendages, maxAppendages,
		//		latitude, longitude, 75, 90, 75, 90);
		
		body += generateIndexFacedComponents(null, bioMightOrientation, bioMightInstructSet, nuclueiPoints); 	
				
		return (body);		
		
	}
  	
	/***********************************************************************************************************************
  	 * GENERATE RETRO VIRUS CAPSID
  	 * 
  	 * Creates Pox Virus
  	 * 
  	 * @param bioMightTransform
  	 * @param currentPoints
  	 * @param bHeader
  	 * @param bFooter
  	 * @param diffColor
  	 * @return
  	 * 
  	 ***********************************************************************************************************************/
	
  	public static String generateRetroVirusCapsid(BioMightTransform bioMightTransform,  BioMightPosition startPos, BioMightOrientation bioMightOrientation) 	
	{		
	  	String body = "";			
		//double xStartPos = startPos.getXPos(); 
		//double yStartPos = startPos.getYPos(); 
		//double zStartPos = startPos.getZPos();
		System.out.println("\nGenerateRetroVirusCapsidVirus() at Start Position: ");
			
		//***********************************************
		// Create the Pox Virus 
	  	//***********************************************
	  	double[] nukStartPos = {0.0, 0.40, 0.00};
	  	double radius = 0.000625;
		double[][] nuclueiPoints = BioGraphics.createCylinderInPlane(Constants.YPLANE, nukStartPos, radius, 8);
		
		// Move the point around, and connect it, creating a wall of 
		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstructSet = new BioMightInstructSet();
		
		int numInstructions = 17;
		//BioMightOrientation bioMightOrientation = new BioMightOrientation(0.0, 0.0, 1.0, 90);
		for (int instructCount=0; instructCount<numInstructions; instructCount++)
		{
			// Create a place for an instruction 
			BioMightInstruction bioInstruct = new BioMightInstruction();
			
			// Place a transform object into each instruction set
			bioInstruct.setBioMightTransform(bioMightTransform);
			
			bioMightTransform = new BioMightTransform();
			bioMightTransform.setTextureID(5);
			bioMightTransform.setTextureFile("SpeckledBlue.png");
			bioMightTransform.setComponentName("Capsid");
			
			// Place a transform object into each instruction set
			bioInstruct.setBioMightTransform(bioMightTransform);
			
			if (instructCount==0){		
				//BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, -90);
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(25, 25, 25);
				bioInstruct.setTranslateMatrix(0.0, -0.0002, 0.0);      
			}
			else if (instructCount==1){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(3.75, 3.75, 3.75);
				bioInstruct.setTranslateMatrix(0.0, -0.0125, 0.0); 
			}
			else if (instructCount==2){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(2.0, 2.0, 2.0);
				bioInstruct.setTranslateMatrix(0.0, -0.025, 0.00);   
			}				
			else if (instructCount==3){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.50, 1.50, 1.50);
				bioInstruct.setTranslateMatrix(0.0, -0.025, 0.0);      
			}
			else if (instructCount==4){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.1, 1.1, 1.1);
				bioInstruct.setTranslateMatrix(0.0, -0.05, 0.0);      
			}
			else if (instructCount==5){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.1, 1.1, 1.1);
				bioInstruct.setTranslateMatrix(0.0, -0.05, 0.0);      
			}
			else if (instructCount==6){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.1, 1.1, 1.1);
				bioInstruct.setTranslateMatrix(0.0, -0.05, 0.0);      
			}
			else if (instructCount==7){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.0, -0.05, 0.0);      
			}
			else if (instructCount==8){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.0, -0.05, 0.0);      
			}
			else if (instructCount==9){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.0, -0.05, 0.0);      
			}
			else if (instructCount==10){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(0.95, 0.95, 0.95);
				bioInstruct.setTranslateMatrix(0.0, -0.05, 0.00);      
			}
			else if (instructCount==11){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(0.95, 0.95, 0.95);
				bioInstruct.setTranslateMatrix(0.0, -0.05, 0.00);      
			}
			else if (instructCount==12){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(0.95, 0.95, 0.95);
				bioInstruct.setTranslateMatrix(0.0, -0.05, 0.00);      
			}
			else if (instructCount==13){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(0.85, 0.85, 0.85);
				bioInstruct.setTranslateMatrix(0.0, -0.025, 0.00);      
			}
			else if (instructCount==14){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(0.75, 0.75, 0.75);
				bioInstruct.setTranslateMatrix(0.0, -0.025, 0.00);       
			}
			else if (instructCount==15){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(0.5, 0.5, 0.5);
				bioInstruct.setTranslateMatrix(0.0, -0.0125, 0.00);       
			}
			else if (instructCount==16){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(0.0025, 0.0025, 0.025);
				bioInstruct.setTranslateMatrix(0.0, -0.00025, 0.00);      
			}
			
			
	

			else {
				bioInstruct.setTransType(Constants.TRANSLATE);
				BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, 90);
				bioInstruct.setOrientation(orientationUpd);
				bioInstruct.setTranslateMatrix(0.0, -0.05, 0.0);       
			}
	
			
			// Add the instruction into the instruction set
			System.out.println("\nInstruction Texture: " + bioInstruct.getBioMightTransform().getTextureFile());

    		bioMightInstructSet.addElement(bioInstruct);
		}	
		
		// We need to run this as a seperate/parallel instruction set that
		// gets assembled above.  This way we can control individual spikes
		// on the points
		
		// Pass the instructions to the builder for the POX Virus Appendages
		double[] taperPoint = {0.25, 0.50};
		double[] taperValue = {radius, radius/3};
		int minAppendages = 6;
		int maxAppendages = 10;
		double latitude = 0.0;
		double longitude = 60.0;

		int growthRate = 1;
		double orbitalRadius  = 0.005; 	
	  	double dendriteRadius = 0.01;
		double minRadius = 0.001;;
		double maxRadius = 0.00725;
		
		//BioMightAppendage bioMightAppendage = new BioMightAppendage(growthRate, orbitalRadius, minRadius, maxRadius,
		//	    dendriteRadius, taperPoint,
		//		taperValue, minAppendages, maxAppendages,
		//		latitude, longitude);
		
		body += generateIndexFacedComponents(bioMightOrientation, bioMightInstructSet, nuclueiPoints); 	
				
		return (body);		
		
	}
  	
  	/***********************************************************************************************************************
  	 * GENERATE AIDS VIRUS CAPSID
  	 * 
  	 * Creates AIDS Virus Capsid
  	 * 
  	 * @param bioMightTransform
  	 * @param currentPoints
  	 * @param bHeader
  	 * @param bFooter
  	 * @param diffColor
  	 * @return
  	 * 
  	 ***********************************************************************************************************************/
	
  	public static String generateAIDSVirusCapsid(BioMightTransform bioMightTransform,  BioMightPosition startPos, BioMightOrientation bioMightOrientation) 	
	{		
	  	String body = "";			
		//double xStartPos = startPos.getXPos(); 
		//double yStartPos = startPos.getYPos(); 
		//double zStartPos = startPos.getZPos();
		System.out.println("\nGenerateAIDSVirusCapsidVirus() at Start Position: ");
			
		//***********************************************
		// Create the AIDS Virus 
	  	//***********************************************
	  	double[] nukStartPos = {0.0, 0.40, 0.00};
	  	double radius = 0.000625;
		double[][] nuclueiPoints = BioGraphics.createCylinderInPlane(Constants.YPLANE, nukStartPos, radius, 8);
		
		// Move the point around, and connect it, creating a wall of 
		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstructSet = new BioMightInstructSet();
		
		int numInstructions = 19;
		//BioMightOrientation bioMightOrientation = new BioMightOrientation(0.0, 0.0, 1.0, 90);
		for (int instructCount=0; instructCount<numInstructions; instructCount++)
		{
			// Create a place for an instruction 
			BioMightInstruction bioInstruct = new BioMightInstruction();
			
			// Place a transform object into each instruction set
			bioInstruct.setBioMightTransform(bioMightTransform);
			
			bioMightTransform = new BioMightTransform();
			bioMightTransform.setTextureID(5);
			bioMightTransform.setTextureFile("SpeckledBlue.png");
			bioMightTransform.setComponentName("Capsid");
			
			// Place a transform object into each instruction set
			bioInstruct.setBioMightTransform(bioMightTransform);
			
			if (instructCount==0){		
				//BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, -90);
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(25, 25, 25);
				bioInstruct.setTranslateMatrix(0.0, -0.0002, 0.0);      
			}
			else if (instructCount==1){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(3.75, 3.75, 3.75);
				bioInstruct.setTranslateMatrix(0.0, -0.0125, 0.0); 
			}
			else if (instructCount==2){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(2.0, 2.0, 2.0);
				bioInstruct.setTranslateMatrix(0.0, -0.025, 0.00);   
			}				
			else if (instructCount==3){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.50, 1.50, 1.50);
				bioInstruct.setTranslateMatrix(0.0, -0.025, 0.0);      
			}
			else if (instructCount==4){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.1, 1.1, 1.1);
				bioInstruct.setTranslateMatrix(0.0, -0.05, 0.0);      
			}
			else if (instructCount==5){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.1, 1.1, 1.1);
				bioInstruct.setTranslateMatrix(0.0, -0.05, 0.0);      
			}
			else if (instructCount==6){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.1, 1.1, 1.0);
				bioInstruct.setTranslateMatrix(0.0, -0.05, 0.0);      
			}
			else if (instructCount==7){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.1, 1.1, 1.0);
				bioInstruct.setTranslateMatrix(0.0, -0.05, 0.0);      
			}
			else if (instructCount==8){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.1, 1.1, 1.0);
				bioInstruct.setTranslateMatrix(0.0, -0.05, 0.0);      
			}
			else if (instructCount==9){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.1, 1.1, 1.0);
				bioInstruct.setTranslateMatrix(0.0, -0.05, 0.0);      
			}
			else if (instructCount==10){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.05, 1.05, 1.0);
				bioInstruct.setTranslateMatrix(0.0, -0.05, 0.0);      
			}
			else if (instructCount==11){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.025, 1.025, 1.0);
				bioInstruct.setTranslateMatrix(0.0, -0.05, 0.0);      
			}
			else if (instructCount==12){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.025, 1.025, 1.0);
				bioInstruct.setTranslateMatrix(0.0, -0.05, 0.0);      
			}
			else if (instructCount==13){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(0.95, 0.95, 0.95);
				bioInstruct.setTranslateMatrix(0.0, -0.05, 0.0);      
			}
			else if (instructCount==14){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(0.95, 0.95, 0.95);
				bioInstruct.setTranslateMatrix(0.0, -0.05, 0.00);      
			}
			else if (instructCount==15){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(0.95, 0.95, 0.95);
				bioInstruct.setTranslateMatrix(0.0, -0.05, 0.00);      
			}
			else if (instructCount==16){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(0.9, 0.9, 0.9);
				bioInstruct.setTranslateMatrix(0.0, -0.05, 0.00);      
			}
			else if (instructCount==17){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(0.75, 0.75, 0.75);
				bioInstruct.setTranslateMatrix(0.0, -0.05, 0.00);      
			}
			else if (instructCount==18){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(0.0025, 0.0025, 0.025);
				bioInstruct.setTranslateMatrix(0.0, -0.0125, 0.00);      
			}
			
		
			else {
				bioInstruct.setTransType(Constants.TRANSLATE);
				BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, 90);
				bioInstruct.setOrientation(orientationUpd);
				bioInstruct.setTranslateMatrix(0.0, -0.05, 0.0);       
			}
	
			
			// Add the instruction into the instruction set
			System.out.println("\nInstruction Texture: " + bioInstruct.getBioMightTransform().getTextureFile());

    		bioMightInstructSet.addElement(bioInstruct);
		}	
		
		// We need to run this as a seperate/parallel instruction set that
		// gets assembled above.  This way we can control individual spikes
		// on the points
		
		// Pass the instructions to the builder for the POX Virus Appendages
		double[] taperPoint = {0.25, 0.50};
		double[] taperValue = {radius, radius/3};
		int minAppendages = 6;
		int maxAppendages = 10;
		double latitude = 0.0;
		double longitude = 60.0;

		int growthRate = 1;
		double orbitalRadius  = 0.005; 	
	  	double dendriteRadius = 0.01;
		double minRadius = 0.001;;
		double maxRadius = 0.00725;
		
		//BioMightAppendage bioMightAppendage = new BioMightAppendage(growthRate, orbitalRadius, minRadius, maxRadius,
		//	    dendriteRadius, taperPoint,
		//		taperValue, minAppendages, maxAppendages,
		//		latitude, longitude);
		
		body += generateIndexFacedComponents(bioMightOrientation, bioMightInstructSet, nuclueiPoints); 	
				
		return (body);		
		
	}
  	
  	
	/***********************************************************************************************************************
  	 * GENERATE ADENO VIRUS CAPSID
  	 * 
  	 * Creates Adeno Virus
  	 * 
  	 * @param bioMightTransform
  	 * @param currentPoints
  	 * @param bHeader
  	 * @param bFooter
  	 * @param diffColor
  	 * @return
  	 * 
  	 ***********************************************************************************************************************/
	
  	public static String generateAdenoVirus(BioMightTransform bioMightTransform,  BioMightPosition startPosTemp, BioMightOrientation bioMightOrientation) 	
	{		
	  	String body = "";			
		//double xStartPos = startPos.getXPos(); 
		//double yStartPos = startPos.getYPos(); 
		//double zStartPos = startPos.getZPos();
		System.out.println("\nGenerateAdenoVirusCapsid()");
			
	
		// Get the information for the capsomer we are creating
		System.out.println("Getting X3D -InternalView - for Adenovirus: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());				
		//System.out.println("Getting X3D for AdenovirusX: " + bioMightTransform.getTranslation().getXPos());
		//System.out.println("Getting X3D for AdenovirusY: " + bioMightTransform.getTranslation().getYPos());
		//System.out.println("Getting X3D for AdenovirusZ: " + bioMightTransform.getTranslation().getZPos());

		
		//*******************************************************************
		//
		// CREATE THE TOP CAP
		//
		//*******************************************************************
		double capHeight = 0.5;
		double bodyHeight = 0.5;
		
		double[] startPos = {0, 0, 0};
				//bioMightTransform.getTranslation().getXPos(), 
				//bioMightTransform.getTranslation().getYPos()-capHeight, 
				//bioMightTransform.getTranslation().getZPos()};
		double capTopPos[] = {(startPos[0] + capHeight), 0, 0};
		
		double radius = 0.5; //bioMightTransform.getRadius();
		double outerRadius = 0.75;
		System.out.println("Creating Pentagon with radius: " + radius);
		
		int numPoints = 5;
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
				
			//*************************************
			// CREATE PINNACLE
			//*************************************
			if (k==0) {
	
				//System.out.println("Create CapPinnacle at Coordinates: " 
				//      + capTopPos[0]  + "   " 
	 			//		+ capTopPos[1]  + "   "
	 			//		+ capTopPos[2]);	
					
				
				//************************************
				// Create the Center Top Spike
				//************************************
				body += "<Transform DEF='TRANSFORM_CAPTOPCTR" + bioMightTransform.getId() + "' \n";
			 	body += "translation='" 
			 		+ capTopPos[0] + "   " 
 					+ capTopPos[1] + "   "
 					+ capTopPos[2] + "'\n";	
			 	
				body +=  "rotation='" 
						+ 0 + " "
						+ 0 + " "
						+ 1  + " "
						+ degrees90 + "'\n";
				
				body +=  "scale='1 1 1'>\n\n" +
				
				 	"<Shape DEF='SHAPE_" + bioMightTransform.getId() + k + "' \n" +
				    " containerField='children'>\n" +
				    " <Appearance\n" +
				    "  containerField='appearance'>\n";

				if (bioMightTransform.getTextureID() > 0) {
					body+= " <ImageTexture containerField='texture' url='../images/" +
		    			 bioMightTransform.getTextureFile() +  "' />";
				}
				else
				{
					body+= " <ImageTexture containerField='texture' " +
						    " url='../images/Adenovirus.jpg'/>";
				}
				
				body+= " <Material DEF='Rust'\n" +
				    "containerField='material'\n" +
				    "ambientIntensity='" 	+ bioMightTransform.getMaterial().getAmbientIntensity() + "'\n" +
				    "shininess='" 			+ bioMightTransform.getMaterial().getShininess() + "'\n" +
				    "transparency='" 		+ 0.25 + "'\n" +
				    "diffuseColor='1.0  0.0  0.0'/>\n" +
				 	"</Appearance>\n" +
				
				 	"<Cylinder DEF='CapSpikeTop'\n" +
				 	"containerField='geometry'\n" +
				 	"radius='" + 0.0425 +"'\n" +
				 	"height='" + 0.425 +"'/>\n" +
				 	"</Shape>\n" +
				 "</Transform>\n";
		
			
				//******************************************
				// Create the Base for the Center Top Spike
				//******************************************
				body += "<Transform DEF='TRANSFORM_CAPBASESPIKE" + bioMightTransform.getId() + "' \n";
			 	body += "translation='" 
			 		+ capTopPos[0] + " " 
 					+ capTopPos[1] + " "
 					+ capTopPos[2] + "'\n";	
			 	
				body +=  "scale='1 1 1'>\n" +
				
				 	"<Shape DEF='SHAPE_" + bioMightTransform.getId() + k + "' \n" +
				    " containerField='children'>\n" +
				    " <Appearance\n" +
				    "  containerField='appearance'>\n";

				if (bioMightTransform.getTextureID() > 0) {
					body+= " <ImageTexture containerField='texture' url='../images/" +
		    			 bioMightTransform.getTextureFile() +  "' />";
				}
				else
				{
					body+= " <ImageTexture containerField='texture' " +
						    " url='../images/Adenovirus.jpg'/>";
				}
				
				body+= " <Material DEF='Rust'\n" +
				    "containerField='material'\n" +
				    "ambientIntensity='" 	+ bioMightTransform.getMaterial().getAmbientIntensity() + "'\n" +
				    "shininess='" 			+ bioMightTransform.getMaterial().getShininess() + "'\n" +
				    "transparency='" 		+ 0.0 + "'\n" +
				    "diffuseColor='1.0  0.0  0.0'/>\n" +
				 	"</Appearance>\n" +
				 	
				 	"<Sphere DEF='CapBaseSpike'\n" +
				 	"containerField='geometry'\n" +
				 	"radius='" + 0.0825 +"'/>\n" +
				 	"</Shape>\n" +
				 "</Transform>\n";

				
				//******************************************
				// Create the Top for Center Spike 
				//******************************************
				body += "<Transform DEF='TRANSFORM_CAPBASESPIKE" + bioMightTransform.getId() + "' \n";
			 	body += "translation='" 
			 		+ (capTopPos[0] + capHeight/2) + "  "
 					+ capTopPos[1]+ " "
 					+ capTopPos[2] + "'\n";	
			 	
				body +=  "scale='1 1 1'>\n" +
				 	"<Shape DEF='SHAPE_" + bioMightTransform.getId() + k + "' \n" +
				    " containerField='children'>\n" +
				    " <Appearance\n" +
				    "  containerField='appearance'>\n";

				if (bioMightTransform.getTextureID() > 0) {
					body+= " <ImageTexture containerField='texture' url='../images/" +
		    			 bioMightTransform.getTextureFile() +  "' />";
				}
				else
				{
					body+= " <ImageTexture containerField='texture' " +
						    " url='../images/Adenovirus.jpg'/>";
				}
				
				body+= " <Material DEF='Rust'\n" +
				    "containerField='material'\n" +
				    "ambientIntensity='" 	+ bioMightTransform.getMaterial().getAmbientIntensity() + "'\n" +
				    "shininess='" 			+ bioMightTransform.getMaterial().getShininess() + "'\n" +
				    "transparency='" 		+ 0.0 + "'\n" +
				    "diffuseColor='1.0  0.0  0.0'/>\n" +
				 	"</Appearance>\n" +
				 	
				 	"<Sphere DEF='CapBaseSpike'\n" +
				 	"containerField='geometry'\n" +
				 	"radius='" + 0.0625 +"'/>\n" +
				 	"</Shape>\n" +
				 "</Transform>\n";

			}
	
			
			//********************************************
			//
			// Create the GlycoProteinSpikes for the Top Cap
			//
			//*********************************************
	
			System.out.println("Coordinates for Vertex " + k + ":\n" 
			        + "XPOS: " + cyPoints[k][0]  + "\n" 
 					+ "YPOS: " + cyPoints[k][1]  + "\n"
 					+ "ZPOS: " + cyPoints[k][2]);
			
			// Set the Orientation of the Cylinder on the surface of the Sphere
			// This replicates the logic in the Graphics routine that sets up the original coordinates
						
			double perpindick = MathUtils.round(((k*angle)+90), 6);
			double perpindickRadians = MathUtils.round(Math.toRadians(perpindick), 8);
			System.out.println("Axilating  degrees: " + perpindick + "   radians: " + perpindickRadians);
			
	       	double sinRadians = MathUtils.round(Math.sin(perpindickRadians), 8);
        	double cosRadians = MathUtils.round(Math.cos(perpindickRadians), 8);
            			
			double xOrient =  1; //MathUtils.round(cosRadians * radius, 8); 
			double yOrient =  0; // MathUtils.round(cosRadians * radius, 8); 
			double zOrient =  0; //MathUtils.round(sinRadians * radius, 8); ; 
			
			double rotateAngle = 90;
			if (k==0)
			{	
				xOrient =  1.0; //MathUtils.round(sinRadians * radius, 8); 
				yOrient =  0.0;   // MathUtils.round(cosRadians * radius, 8); 
				zOrient =  0.0; //MathUtils.round(cosRadians * radius, 8); ; 
			}
			// We tilt back into Z to angle X up
			/*else if (k==1)
			{	
		       	double offRadians = MathUtils.round(Math.toRadians(90), 8);
	        	double sinOffRadians = MathUtils.round(Math.sin(offRadians), 8);
	        	double cosOffRadians = MathUtils.round(Math.cos(offRadians), 8);
	            			
				rotateAngle = 90+(k*72);
				xOrient = .951; 
				yOrient =  0; // MathUtils.round(cosRadians * radius, 8); 
				zOrient = -0.309; //-MathUtils.round(sinOffRadians * radius, 8); ; 
			}*/
			//else if (k==2)
			//{	
			//	rotateAngle = 90+(k*72);
			//	xOrient = MathUtils.round(cosOffRadians * radius, 8); 
			//	yOrient =  0; // MathUtils.round(cosRadians * radius, 8); 
			//	zOrient = MathUtils.round(sinOffRadians * radius, 8); ; 
			//}
	
	
			else 
			{	
				rotateAngle = 90+(k*72);
				xOrient =  1.0; //MathUtils.round(sinRadians * radius, 8); 
				yOrient =  0; // MathUtils.round(cosRadians * radius, 8); 
				zOrient =  0.0; //MathUtils.round(cosRadians * radius, 8); ; 
			}
			
			
			
			System.out.println("X-AXIS: " + xOrient);
			System.out.println("Y-AXIS: " + yOrient);
			System.out.println("Z-AXIS: " + zOrient);
		
			double degrees = -Math.toRadians(rotateAngle);
		
			
			//**************************************************
			// Create the GlycoProtein Spike  
			//**************************************************
			body += "<Transform DEF='TRANSFORM_" + bioMightTransform.getId() + "' \n";
		 	body += "translation='"  
		 		+ cyPoints[k][0]+ " " 
					+ cyPoints[k][1] + " "
					+ cyPoints[k][2] + "'\n";					
			
			body +=  "rotation='" 
					+ xOrient + " "
					+ yOrient + " "
					+ zOrient  + " "
					+ degrees + "'\n";
			
			body +=  "scale='1 1 1'>\n\n" +
			
			 	"<Shape DEF='SHAPE_" + bioMightTransform.getId() + k + "' \n" +
			    " containerField='children'>\n" +
			    " <Appearance\n" +
			    "  containerField='appearance'>\n";

			if (bioMightTransform.getTextureID() > 0) {
				body+= " <ImageTexture containerField='texture' url='../images/" +
	    			 bioMightTransform.getTextureFile() +  "' />";
			}
			else
			{
				body+= " <ImageTexture containerField='texture' " +
					    " url='../images/Adenovirus.jpg'/>";
			}
			
			body+= " <Material DEF='Rust'\n" +
			    "containerField='material'\n" +
			    "ambientIntensity='" 	+ bioMightTransform.getMaterial().getAmbientIntensity() + "'\n" +
			    "shininess='" 			+ bioMightTransform.getMaterial().getShininess() + "'\n" +
			    "transparency='" 		+ 0.25 + "'\n" +
			    "diffuseColor='" + 1 + "  0.0  0.0'/>\n" +  // ((k*0.15)+.20)
			 	"</Appearance>\n" +
			    
			 	"<Cylinder DEF='AdenovirusSpike'\n" +
			 	"containerField='geometry'\n" +
				"radius='" + 0.0425 +"'\n" +
			 	"height='" + 0.425 +"'/>\n" +
			 	"</Shape>\n" +
			 "</Transform>\n";
			
			
			//********************************************
			// Create the GlycoProteinSpike Base
			//*********************************************
			  
			body += "<Transform DEF='TRANSFORM_" + bioMightTransform.getId() + "' \n";
		 	body += "translation='"  
		 		+ cyPoints[k][0]+ " " 
					+ cyPoints[k][1] + " "
					+ cyPoints[k][2] + "'\n";					
	
			body +=  "scale='1 1 1'>\n" +
			
			 	"<Shape DEF='SHAPE_" + bioMightTransform.getId() + k + "' \n" +
			    " containerField='children'>\n" +
			    " <Appearance\n" +
			    "  containerField='appearance'>\n";

			if (bioMightTransform.getTextureID() > 0) {
				body+= " <ImageTexture containerField='texture' url='../images/" +
	    			 bioMightTransform.getTextureFile() +  "' />";
			}
			else
			{
				body+= " <ImageTexture containerField='texture' " +
					    " url='../images/Adenovirus.jpg'/>";
			}
			
			body+= " <Material DEF='Rust'\n" +
			    "containerField='material'\n" +
			    "ambientIntensity='" 	+ bioMightTransform.getMaterial().getAmbientIntensity() + "'\n" +
			    "shininess='" 			+ bioMightTransform.getMaterial().getShininess() + "'\n" +
			    "transparency='" 		+ 0.0 + "'\n" +
			    "diffuseColor='" + 1 + "  0.0  0.0'/>\n" +  // ((k*0.15)+.20)
			 	"</Appearance>\n" +
			    
			 	"<Sphere DEF='AdenovirusSpikeBase'\n" +
			 	"containerField='geometry'\n" +
				"radius='" + 0.0625 +"'/>\n" +
			 	"</Shape>\n" +
			 "</Transform>\n";

			//********************************************
			// Create the GlycoProteinSpike Top
			//*********************************************
			  
			body += "<Transform DEF='TRANSFORM_" + bioMightTransform.getId() + "' \n";
		 	body += "translation='"  
		 		+ cyCapPoints[k][0]+ " " 
					+ cyCapPoints[k][1] + " "
					+ cyCapPoints[k][2] + "'\n";					
	
			body +=  "scale='1 1 1'>\n" +
			
			 	"<Shape DEF='SHAPE_" + bioMightTransform.getId() + k + "' \n" +
			    " containerField='children'>\n" +
			    " <Appearance\n" +
			    "  containerField='appearance'>\n";

			if (bioMightTransform.getTextureID() > 0) {
				body+= " <ImageTexture containerField='texture' url='../images/" +
	    			 bioMightTransform.getTextureFile() +  "' />";
			}
			else
			{
				body+= " <ImageTexture containerField='texture' " +
					    " url='../images/Adenovirus.jpg'/>";
			}
			
			body+= " <Material DEF='Rust'\n" +
			    "containerField='material'\n" +
			    "ambientIntensity='" 	+ bioMightTransform.getMaterial().getAmbientIntensity() + "'\n" +
			    "shininess='" 			+ bioMightTransform.getMaterial().getShininess() + "'\n" +
			    "transparency='" 		+ 0.0 + "'\n" +
			    "diffuseColor='" + 1 + "  0.0  0.0'/>\n" +  // ((k*0.15)+.20)
			 	"</Appearance>\n" +
			    
			 	"<Sphere DEF='AdenovirusSpikeTop'\n" +
			 	"containerField='geometry'\n" +
				"radius='" + 0.0625 +"'/>\n" +
			 	"</Shape>\n" +
			 "</Transform>\n";
			
		}
		//System.out.println("Top Cap-CoordinateStr: " + coordinateString);
		

		//********************************************
		// Create a GlycoProteinShell for the Top Cap
		//*********************************************
		
		// Allocate the Coordinate-Index Array for Polygon 
		String tempIndexStr = 
			"0, 2, 1, -1,\n" +
			"0, 3, 2, -1,\n" +
			"0, 4, 3, -1,\n" +
			"0, 5, 4, -1,\n" +
			"0, 1, 5, -1,\n";
		
		
		String componentType = "AdenovirusCap";
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
				   
		if (bioMightTransform.getTextureID() > 0) {
			body+= " <ImageTexture containerField='texture' url='../images/" +
    			 bioMightTransform.getTextureFile() +  "' />";
		}
		else
		{
			body+= " <ImageTexture containerField='texture' " +
				    " url='../images/Adenovirus.jpg'/>";
		}
		
	 	//bioMightTransform.setCoordpoint(Constants.TRIANGLE, coordinateString, 0.025, 0);
	 	//bioMightTransform.setCoordIndex(tempInd);
	
		if (bioMightTransform.getTextureID() > 0) {
			body+= " <ImageTexture containerField='texture' url='../images/" +
    			 bioMightTransform.getTextureFile() +  "' />";
		}
		else
		{
			body+= " <ImageTexture containerField='texture' " +
				    " url='../images/Adenovirus.jpg'/>";
		}
		
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
		// Create coordinates for the base of the Adenovirus capsid
	 	//
	 	//****************************************************************
		String baseCoordinateString = "";
		startPos[0] = (startPos[0] - bodyHeight);
		double capBasePos[] = {(startPos[0] - capHeight), 0, 0};
		double[][] cyBasePoints = BioGraphics.createCylinderInPlane(Constants.XPLANE, startPos, radius, numPoints);
		double[][] cyBaseCapPoints = BioGraphics.createCylinderInPlane(Constants.XPLANE, startPos, outerRadius, numPoints);
		double halfTurn = MathUtils.round(angle/2, 8);
		cyBasePoints = BioGraphics.rotateX(cyBasePoints, MathUtils.round(halfTurn, 6));
		halfTurn = MathUtils.round((angle-2)/2, 8);
		cyBaseCapPoints = BioGraphics.rotateX(cyBaseCapPoints, MathUtils.round(halfTurn, 6));
		
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
				
				
				//********************************************
				// Create the Center Bottom Cap Spike
				//********************************************
				body += "<Transform DEF='TRANSFORM_CAPBASECTR" + bioMightTransform.getId() + "' \n";
			 	body += "translation='" 
			 		+ capBasePos[0] + " " 
 					+ capBasePos[1] + " "
 					+ capBasePos[2] + "'\n";	
			 	
				body +=  "rotation='" 
						+ 0 + " "
						+ 0 + " "
						+ 1  + " "
						+ degrees90 + "'\n";
				
				body +=  "scale='1 1 1'>\n\n" +
				
				 	"<Shape DEF='SHAPE_" + bioMightTransform.getId() + k + "' \n" +
				    " containerField='children'>\n" +
				    " <Appearance\n" +
				    "  containerField='appearance'>\n";

				if (bioMightTransform.getTextureID() > 0) {
					body+= " <ImageTexture containerField='texture' url='../images/" +
		    			 bioMightTransform.getTextureFile() +  "' />";
				}
				else
				{
					body+= " <ImageTexture containerField='texture' " +
						    " url='../images/Adenovirus.jpg'/>";
				}
				
				body+= " <Material DEF='Rust'\n" +
				    "containerField='material'\n" +
				    "ambientIntensity='" 	+ bioMightTransform.getMaterial().getAmbientIntensity() + "'\n" +
				    "shininess='" 			+ bioMightTransform.getMaterial().getShininess() + "'\n" +
				    "transparency='" 		+ 0.25 + "'\n" +
				    "diffuseColor='0.0  0.80  0.40'/>\n" +
				 	"</Appearance>\n" +
				 
				 	"<Cylinder DEF='CapBaseSpike'\n" +
				 	"containerField='geometry'\n" +
				 	"radius='" + 0.0425 +"'\n" +
				 	"height='" + 0.425 +"'/>\n" +
				 	"</Shape>\n" +
				 "</Transform>\n";
				
				//************************************************
				// Create the Base for Center Spike on Base
				//************************************************
				body += "<Transform DEF='TRANSFORM_CAPBASESPIKE" + bioMightTransform.getId() + "' \n";
			 	body += "translation='" 
			 		+ capBasePos[0] + " " 
 					+ capBasePos[1] + " "
 					+ capBasePos[2] + "'\n";	
			 	
				body +=  "scale='1 1 1'>\n" +
				 	"<Shape DEF='SHAPE_" + bioMightTransform.getId() + k + "' \n" +
				    " containerField='children'>\n" +
				    " <Appearance\n" +
				    "  containerField='appearance'>\n";

				if (bioMightTransform.getTextureID() > 0) {
					body+= " <ImageTexture containerField='texture' url='../images/" +
		    			 bioMightTransform.getTextureFile() +  "' />";
				}
				else
				{
					body+= " <ImageTexture containerField='texture' " +
						    " url='../images/Adenovirus.jpg'/>";
				}
				
				body+= " <Material DEF='Rust'\n" +
				    "containerField='material'\n" +
				    "ambientIntensity='" 	+ bioMightTransform.getMaterial().getAmbientIntensity() + "'\n" +
				    "shininess='" 			+ bioMightTransform.getMaterial().getShininess() + "'\n" +
				    "transparency='" 		+ 0.0 + "'\n" +
				    "diffuseColor='0.0  0.80  0.40'/>\n" +
				 	"</Appearance>\n" +
				 	
				 	"<Sphere DEF='CapBaseSpike'\n" +
				 	"containerField='geometry'\n" +
				 	"radius='" + 0.0625 +"'/>\n" +
				 	"</Shape>\n" +
				 "</Transform>\n";

				//******************************************************
				// Create the Top for Center Spike on the Base Cap 
				//******************************************************
				body += "<Transform DEF='TRANSFORM_CAPBASESPIKE" + bioMightTransform.getId() + "' \n";
			 	body += "translation='" 
			 		+ (capBasePos[0] - capHeight/2) + " " 
 					+ capBasePos[1] + " "
 					+ capBasePos[2] + "'\n";	
			 	
				body +=  "scale='1 1 1'>\n" +
				 	"<Shape DEF='SHAPE_" + bioMightTransform.getId() + k + "' \n" +
				    " containerField='children'>\n" +
				    " <Appearance\n" +
				    "  containerField='appearance'>\n";

				if (bioMightTransform.getTextureID() > 0) {
					body+= " <ImageTexture containerField='texture' url='../images/" +
		    			 bioMightTransform.getTextureFile() +  "' />";
				}
				else
				{
					body+= " <ImageTexture containerField='texture' " +
						    " url='../images/Adenovirus.jpg'/>";
				}
				
				body+= " <Material DEF='Rust'\n" +
				    "containerField='material'\n" +
				    "ambientIntensity='" 	+ bioMightTransform.getMaterial().getAmbientIntensity() + "'\n" +
				    "shininess='" 			+ bioMightTransform.getMaterial().getShininess() + "'\n" +
				    "transparency='" 		+ 0.0 + "'\n" +
				    "diffuseColor='0.0  0.80  0.40'/>\n" +
				 	"</Appearance>\n" +
				 	
				 	"<Sphere DEF='CapBaseSpike'\n" +
				 	"containerField='geometry'\n" +
				 	"radius='" + 0.0625 +"'/>\n" +
				 	"</Shape>\n" +
				 "</Transform>\n";
			}
				
			
			//*********************************************
			//
			// CREATE THE SPIKES ON BASE CAP
			//
			//*********************************************
			///System.out.println("BaseCoordinateStr: " + baseCoordinateString);
			System.out.println("Base Coordinates for " + k + ":\n"   
			        + "baseXPOS: " + cyBasePoints[k][0]  + "\n" 
 					+ "baseYPOS: " + cyBasePoints[k][1]  + "\n"
 					+ "baseZPOS: " + cyBasePoints[k][2]);
			
			// Set the Orientation of the Cylinder on the surface of the Sphere
			// This replicates the logic in the Graphics routine that sets up the original coordinates
						
			double perpindick = MathUtils.round(((k*angle)+90), 6);
			double perpindickRadians = MathUtils.round(Math.toRadians(perpindick), 8);
			System.out.println("Axilating  degrees: " + perpindick + "   radians: " + perpindickRadians);
			
	       	double sinRadians = MathUtils.round(Math.sin(perpindickRadians), 8);
        	double cosRadians = MathUtils.round(Math.cos(perpindickRadians), 8);
            			
			double xOrient =  1; //MathUtils.round(cosRadians * radius, 8); 
			double yOrient =  0; // MathUtils.round(cosRadians * radius, 8); 
			double zOrient =  0; //MathUtils.round(sinRadians * radius, 8); ; 
			
			double rotateAngle = 90-32;
			if (k==0)
			{	
				xOrient =  1.0; //MathUtils.round(sinRadians * radius, 8); 
				yOrient =  0.0;   // MathUtils.round(cosRadians * radius, 8); 
				zOrient =  0.0; //MathUtils.round(cosRadians * radius, 8); ; 
			}
			else 
			{	
				rotateAngle = 90+(k*72)-32;
				xOrient =  1.0; //MathUtils.round(sinRadians * radius, 8); 
				yOrient =  0; // MathUtils.round(cosRadians * radius, 8); 
				zOrient =  0.0; //MathUtils.round(cosRadians * radius, 8); ; 
			}

			System.out.println("BaseX-AXIS: " + xOrient);
			System.out.println("BaseY-AXIS: " + yOrient);
			System.out.println("BaseZ-AXIS: " + zOrient);
						
			double degrees = -Math.toRadians(rotateAngle);
			
			
			body += "<Transform DEF='TRANSFORM_" + bioMightTransform.getId() + "' \n";
		 	body += "translation='" 
		 		+ cyBasePoints[k][0]+ " " 
					+ cyBasePoints[k][1] + " "
					+ cyBasePoints[k][2] + "'\n";					
		
			body +=  "rotation='" 
					+ xOrient + " "
					+ yOrient + " "
					+ zOrient  + " "
					+ degrees + "'\n";
			
			body +=  "scale='1 1 1'>\n\n" +
			
			 	"<Shape DEF='SHAPE_" + bioMightTransform.getId() + k + "' \n" +
			    " containerField='children'>\n" +
			    " <Appearance\n" +
			    "  containerField='appearance'>\n";

			
			if (bioMightTransform.getTextureID() > 0) {
				body+= " <ImageTexture containerField='texture' url='../images/" +
	    			 bioMightTransform.getTextureFile() +  "' />";
			}
			else
			{
				body+= " <ImageTexture containerField='texture' " +
					    " url='../images/Adenovirus.jpg'/>";
			}
			
			body+= " <Material DEF='Rust'\n" +
			    "containerField='material'\n" +
			    "ambientIntensity='" 	+ bioMightTransform.getMaterial().getAmbientIntensity() + "'\n" +
			    "shininess='" 			+ bioMightTransform.getMaterial().getShininess() + "'\n" +
			    "transparency='" 		+ 0.25 + "'\n" +
			    "diffuseColor='0.0  1.0  0.0'/>\n" +
			 	"</Appearance>\n" +
			
			 	"<Cylinder DEF='GlycoProteinBaseSpike'\n" +
			 	"containerField='geometry'\n" +
			 	"radius='" + 0.0425 +"'\n" +
			 	"height='" + 0.525 +"'/>\n" +
			 	"</Shape>\n" +
			 "</Transform>\n";
			
			
		//*****************************
		// Create the Spike's Base
		//*****************************
		body += "<Transform DEF='TRANSFORM_" + bioMightTransform.getId() + "' \n";
	 	body += "translation='" 
	 		+ cyBasePoints[k][0]+ " " 
				+ cyBasePoints[k][1] + " "
				+ cyBasePoints[k][2] + "'\n";					
	
		
		body +=  "scale='1 1 1'>\n" +
		 	"<Shape DEF='SHAPE_" + bioMightTransform.getId() + k + "' \n" +
		    " containerField='children'>\n" +
		    " <Appearance\n" +
		    "  containerField='appearance'>\n";
		
		if (bioMightTransform.getTextureID() > 0) {
			body+= " <ImageTexture containerField='texture' url='../images/" +
    			 bioMightTransform.getTextureFile() +  "' />";
		}
		else
		{
			body+= " <ImageTexture containerField='texture' " +
				    " url='../images/Adenovirus.jpg'/>";
		}

		body+= " <Material DEF='Rust'\n" +
		    "containerField='material'\n" +
		    "ambientIntensity='" 	+ bioMightTransform.getMaterial().getAmbientIntensity() + "'\n" +
		    "shininess='" 			+ bioMightTransform.getMaterial().getShininess() + "'\n" +
		    "transparency='" 		+ 0.0 + "'\n" +
		    "diffuseColor='0.0  1.0  0.0'/>\n" +
		 	"</Appearance>\n" +
		    
		 	"<Sphere DEF='GlycoProteinSpikeBase'\n" +
		 	"containerField='geometry'\n" +
		 	"radius='" + 0.0625 +"'/>\n" +
		 	"</Shape>\n" +
		 "</Transform>\n";
			
		
		//*****************************
		// Create the Spike's Top
		//*****************************
		body += "<Transform DEF='TRANSFORM_" + bioMightTransform.getId() + "' \n";
	 	body += "translation='" 
	 		+ cyBaseCapPoints[k][0]+ " " 
				+ cyBaseCapPoints[k][1] + " "
				+ cyBaseCapPoints[k][2] + "'\n";					
					
		body +=  "scale='1 1 1'>\n" +
		 	"<Shape DEF='SHAPE_" + bioMightTransform.getId() + k + "' \n" +
		    " containerField='children'>\n" +
		    " <Appearance\n" +
		    "  containerField='appearance'>\n";

		
		if (bioMightTransform.getTextureID() > 0) {
			body+= " <ImageTexture containerField='texture' url='../images/" +
    			 bioMightTransform.getTextureFile() +  "' />";
		}
		else
		{
			body+= " <ImageTexture containerField='texture' " +
				    " url='../images/Adenovirus.jpg'/>";
		}

		body+= " <Material DEF='Rust'\n" +
		    "containerField='material'\n" +
		    "ambientIntensity='" 	+ bioMightTransform.getMaterial().getAmbientIntensity() + "'\n" +
		    "shininess='" 			+ bioMightTransform.getMaterial().getShininess() + "'\n" +
		    "transparency='" 		+ 0.0 + "'\n" +
		    "diffuseColor='0.0  1.0  0.0'/>\n" +
		 	"</Appearance>\n" +
		    
		 	"<Sphere DEF='GlycoProteinSpikeTops'\n" +
		 	"containerField='geometry'\n" +
		 	"radius='" + 0.0625 + "'/>\n" +
		 	"</Shape>\n" +
		 "</Transform>\n";
		}
	
		
	
		//*****************************
		// Construct  the Base Cap
		//*****************************
		
		// Allocate the Coordinate-Index Array for Polygon 
		String tempBaseIndexStr = 
			"0, 1, 2, -1,\n" +
			"0, 2, 3, -1,\n" +
			"0, 3, 4, -1,\n" +
			"0, 4, 5, -1,\n" +
			"0, 5, 1, -1,\n";
		 
		
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
				    
		if (bioMightTransform.getTextureID() > 0) {
			body+= " <ImageTexture containerField='texture' url='../images/" +
    			 bioMightTransform.getTextureFile() +  "' />";
		}
		else
		{
			body+= " <ImageTexture containerField='texture' " +
				    " url='../images/Adenovirus.jpg'/>";
		}
		
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
				"1,     7,     5,   -1 \n" +
				"2,     8,     1,   -1 \n" +
				"3,     9,     2,   -1 \n" +
				"4,     10,    3,   -1,\n" +
				"5,     11,    4,   -1,\n" +
		
				"7,     1,     8,   -1,\n" +
				"8,     2,     9,   -1,\n" +
				"9,     3,    10,   -1,\n" +
				"10,    4,    11,   -1,\n" +
				"11,    5,     7,   -1,\n"	;
		
		
		
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
				    
		if (bioMightTransform.getTextureID() > 0) {
			body+= " <ImageTexture containerField='texture' url='../images/" +
    			 bioMightTransform.getTextureFile() +  "' />";
		}
		else
		{
			body+= " <ImageTexture containerField='texture' " +
				    " url='../images/Adenovirus.jpg'/>";
		}
	 	//bioMightTransform.setCoordpoint(Constants.TRIANGLE, coordinateString, 0.025, 0);
	 	//bioMightTransform.setCoordIndex(tempInd);
	 	
	 	System.out.println("Coords are: : " + coordinateString + " " + baseCoordinateString);
	
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
		    	    "containerField='coord' point='" + coordinateString + " " +baseCoordinateString + "'/>" +
		    	  "</IndexedFaceSet>\n" +
		    
		    	 "</Shape>\n" +
		    	 
		    	 
		"</Transform>\n"; 
	
			
		return (body);				
	}
  	
  	
  	/***********************************************************************************************************************
  	 * GENERATE ADENO VIRUS CAPSID
  	 * 
  	 * Creates Adeno Virus
  	 * 
  	 * @param bioMightTransform
  	 * @param currentPoints
  	 * @param bHeader
  	 * @param bFooter
  	 * @param diffColor
  	 * @return
  	 * 
  	 ***********************************************************************************************************************/
	
  	public static String generateAdenoVirusCapsid(BioMightTransform bioMightTransform,  BioMightPosition startPosTemp, BioMightOrientation bioMightOrientation) 	
	{		
	  	String body = "";			
		//double xStartPos = startPos.getXPos(); 
		//double yStartPos = startPos.getYPos(); 
		//double zStartPos = startPos.getZPos();
		System.out.println("\nGenerateAdenoVirusCapsid()");
			
	
		// Get the information for the capsomer we are creating
		//System.out.println("Getting X3D -Adenovirus: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());				
		//System.out.println("Getting X3D for AdenovirusX: " + bioMightTransform.getTranslation().getXPos());
		//System.out.println("Getting X3D for AdenovirusY: " + bioMightTransform.getTranslation().getYPos());
		//System.out.println("Getting X3D for AdenovirusZ: " + bioMightTransform.getTranslation().getZPos());

		
		//*******************************************************************
		//
		// CREATE THE TOP CAP
		//
		//*******************************************************************
		double capHeight = 0.5;
		double bodyHeight = 0.5;
		
		double[] startPos = {0, 0, 0};
				//bioMightTransform.getTranslation().getXPos(), 
				//bioMightTransform.getTranslation().getYPos()-capHeight, 
				//bioMightTransform.getTranslation().getZPos()};
		double capTopPos[] = {(startPos[0] + capHeight), 0, 0};
		
		double radius = 0.5; //bioMightTransform.getRadius();
		double outerRadius = 0.75;
		System.out.println("Creating Pentagon with radius: " + radius);
		
		int numPoints = 5;
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
		// Create a GlycoProteinShell for the Top Cap
		//*********************************************
		
		// Allocate the Coordinate-Index Array for Polygon 
		String tempIndexStr = 
			"0, 2, 1, -1,\n" +
			"0, 3, 2, -1,\n" +
			"0, 4, 3, -1,\n" +
			"0, 5, 4, -1,\n" +
			"0, 1, 5, -1,\n";
		
		
		String componentType = "AdenovirusCap";
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
				   
	 	
		if (bioMightTransform.getTextureID() > 0) {
			body+= " <ImageTexture containerField='texture' url='../images/" +
    			 bioMightTransform.getTextureFile() +  "' />";
		}
		else
		{
			body+= " <ImageTexture containerField='texture' " +
				    " url='../images/Adenovirus.jpg'/>";
		}
		
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
		// Create coordinates for the base of the Adenovirus capsid
	 	//
	 	//****************************************************************
		String baseCoordinateString = "";
		startPos[0] = (startPos[0] - bodyHeight);
		double capBasePos[] = {(startPos[0] - capHeight), 0, 0};
		double[][] cyBasePoints = BioGraphics.createCylinderInPlane(Constants.XPLANE, startPos, radius, numPoints);
		double[][] cyBaseCapPoints = BioGraphics.createCylinderInPlane(Constants.XPLANE, startPos, outerRadius, numPoints);
		double halfTurn = MathUtils.round(angle/2, 8);
		cyBasePoints = BioGraphics.rotateX(cyBasePoints, MathUtils.round(halfTurn, 6));
		halfTurn = MathUtils.round((angle-2)/2, 8);
		cyBaseCapPoints = BioGraphics.rotateX(cyBaseCapPoints, MathUtils.round(halfTurn, 6));
		
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
		}
	
		//*****************************
		// Construct  the Base Cap
		//*****************************
		
		// Allocate the Coordinate-Index Array for Polygon 
		String tempBaseIndexStr = 
			"0, 1, 2, -1,\n" +
			"0, 2, 3, -1,\n" +
			"0, 3, 4, -1,\n" +
			"0, 4, 5, -1,\n" +
			"0, 5, 1, -1,\n";
		 
		
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
				    
		if (bioMightTransform.getTextureID() > 0) {
			body+= " <ImageTexture containerField='texture' url='../images/" +
    			 bioMightTransform.getTextureFile() +  "' />";
		}
		else
		{
			body+= " <ImageTexture containerField='texture' " +
				    " url='../images/Adenovirus.jpg'/>";
		}
		
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
				"1,     7,     5,   -1 \n" +
				"2,     8,     1,   -1 \n" +
				"3,     9,     2,   -1 \n" +
				"4,     10,    3,   -1,\n" +
				"5,     11,    4,   -1,\n" +
		
				"7,     1,     8,   -1,\n" +
				"8,     2,     9,   -1,\n" +
				"9,     3,    10,   -1,\n" +
				"10,    4,    11,   -1,\n" +
				"11,    5,     7,   -1,\n"	;
		
		
		
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
				    
		if (bioMightTransform.getTextureID() > 0) {
			body+= " <ImageTexture containerField='texture' url='../images/" +
    			 bioMightTransform.getTextureFile() +  "' />";
		}
		else
		{
			body+= " <ImageTexture containerField='texture' " +
				    " url='../images/Adenovirus.jpg'/>";
		}
	 	//bioMightTransform.setCoordpoint(Constants.TRIANGLE, coordinateString, 0.025, 0);
	 	//bioMightTransform.setCoordIndex(tempInd);
	 	
	 	System.out.println("Coords are: : " + coordinateString + " " + baseCoordinateString);
	
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
		    	    "containerField='coord' point='" + coordinateString + " " +baseCoordinateString + "'/>" +
		    	  "</IndexedFaceSet>\n" +
		    
		    	 "</Shape>\n" +
		    	 
		    	 
		"</Transform>\n"; 
	
			
		return (body);				
	}
  	
 	
	/***********************************************************************************************************************
  	 * GENERATE RETRO VIRUS RECEPTOR
  	 * 
  	 * Creates Pox Virus
  	 * 
  	 * @param bioMightTransform
  	 * @param currentPoints
  	 * @param bHeader
  	 * @param bFooter
  	 * @param diffColor
  	 * @return
  	 * 
  	 ***********************************************************************************************************************/
	
  	public static String generateRetroVirusReceptor(BioMightTransform bioMightTransform,  BioMightPosition startPos, BioMightOrientation bioMightOrientation) 	
	{		
	  	String body = "";			
		//double xStartPos = startPos.getXPos(); 
		//double yStartPos = startPos.getYPos(); 
		//double zStartPos = startPos.getZPos();
		System.out.println("\nGenerateRetroVirusCapsidVirus() at Start Position: ");
			
		//***********************************************
		// Create the Pox Virus 
	  	//***********************************************
	  	double[] nukStartPos = {0.0, 0.250, 0.00};
	  	double radius = 0.000625;
		double[][] nuclueiPoints = BioGraphics.createCylinderInPlane(Constants.YPLANE, nukStartPos, radius, 8);
		
		// Move the point around, and connect it, creating a wall of 
		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstructSet = new BioMightInstructSet();
		
		int numInstructions = 11;
		//BioMightOrientation bioMightOrientation = new BioMightOrientation(0.0, 0.0, 1.0, 90);
		for (int instructCount=0; instructCount<numInstructions; instructCount++)
		{
			// Create a place for an instruction 
			BioMightInstruction bioInstruct = new BioMightInstruction();
			
			// Place a transform object into each instruction set
			bioInstruct.setBioMightTransform(bioMightTransform);
			
			bioMightTransform = new BioMightTransform();
			bioMightTransform.setTextureID(5);
			bioMightTransform.setTextureFile("PowderBlue.png");
			bioMightTransform.setComponentName("Nucleus");
			
			// Place a transform object into each instruction set
			bioInstruct.setBioMightTransform(bioMightTransform);
			
			if (instructCount==0){		
				//BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, -90);
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(25, 25, 25);
				bioInstruct.setTranslateMatrix(0.0, -0.0002, 0.0);      
			}
			else if (instructCount==1){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(2.75, 2.75, 2.75);
				bioInstruct.setTranslateMatrix(0.0, -0.0125, 0.0); 
			}
			else if (instructCount==2){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.75,1.75, 1.75);
				bioInstruct.setTranslateMatrix(0.0, -0.025, 0.00);   
			}				
			else if (instructCount==3){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.250, 1.250, 1.250);
				bioInstruct.setTranslateMatrix(0.0, -0.0250, 0.0);      
			}
			else if (instructCount==4){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.1, 1.1, 1.1);
				bioInstruct.setTranslateMatrix(0.0, -0.05, 0.0);      
			}
			else if (instructCount==5){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.0, -0.05, 0.0);      
			}
			else if (instructCount==6){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(0.95, 0.95, 0.95);
				bioInstruct.setTranslateMatrix(0.0, -0.05, 0.00);      
			}
			else if (instructCount==7){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(0.85, 0.85, 0.85);
				bioInstruct.setTranslateMatrix(0.0, -0.025, 0.00);      
			}
			else if (instructCount==8){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(0.75, 0.75, 0.75);
				bioInstruct.setTranslateMatrix(0.0, -0.025, 0.00);       
			}
			else if (instructCount==9){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(0.5, 0.5, 0.5);
				bioInstruct.setTranslateMatrix(0.0, -0.0125, 0.00);       
			}
			else if (instructCount==10){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(0.0025, 0.0025, 0.025);
				bioInstruct.setTranslateMatrix(0.0, -0.00025, 0.00);      
			}
			
			
			else if (instructCount==11){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(0.8, 0.8, 0.8);
				bioInstruct.setTranslateMatrix(0.0, -0.05, 0.00);       
			}
			else if (instructCount==12){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(0.5, 0.5, 0.5);
				bioInstruct.setTranslateMatrix(0.0, -0.025, 0.00);     
			}
			else if (instructCount==13){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(0.25, 0.25, 0.25);
				bioInstruct.setTranslateMatrix(0.0, -0.025, 0.00);     
			}
			else if (instructCount==14){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(0.025, 0.025, 0.025);
				bioInstruct.setTranslateMatrix(0.0, -0.00025, 0.00);     
			}

			else {
				bioInstruct.setTransType(Constants.TRANSLATE);
				BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, 90);
				bioInstruct.setOrientation(orientationUpd);
				bioInstruct.setTranslateMatrix(0.0, -0.05, 0.0);       
			}
	
			
			// Add the instruction into the instruction set
    		bioMightInstructSet.addElement(bioInstruct);
		}	
		
		// We need to run this as a seperate/parallel instruction set that
		// gets assembled above.  This way we can control individual spikes
		// on the points
		
		// Pass the instructions to the builder for the POX Virus Appendages
		double[] taperPoint = {0.25, 0.50};
		double[] taperValue = {radius, radius/3};
		int minAppendages = 6;
		int maxAppendages = 10;
		double latitude = 0.0;
		double longitude = 60.0;

		int growthRate = 1;
		double orbitalRadius  = 0.005; 	
	  	double dendriteRadius = 0.01;
		double minRadius = 0.001;;
		double maxRadius = 0.00725;
		
		//BioMightAppendage bioMightAppendage = new BioMightAppendage(growthRate, orbitalRadius, minRadius, maxRadius,
		//	    dendriteRadius, taperPoint,
		//		taperValue, minAppendages, maxAppendages,
		//		latitude, longitude);
		
		body += generateIndexFacedComponents(bioMightOrientation, bioMightInstructSet, nuclueiPoints); 	
				
		return (body);		
		
	}
  	
	/***********************************************************************************************************************
  	 * GENERATE BOUTONS
  	 * 
  	 * Creates Boutons
  	 * 
  	 * @param bioMightTransform
  	 * @param currentPoints
  	 * @param bHeader
  	 * @param bFooter
  	 * @param diffColor
  	 * @return
  	 * 
  	 ***********************************************************************************************************************/
	
  	public static String generateBoutons(BioMightTransform bioMightTransform,  BioMightPosition startPos, BioMightOrientation bioMightOrientation) 	
	{		
	  	String body = "";			
		double xStartPos = startPos.getXPos(); 
		double yStartPos = startPos.getYPos(); 
		double zStartPos = startPos.getZPos();
		System.out.println("\nGenerateBoutons(): " + xStartPos + " " + yStartPos + " " + zStartPos);
			

		//***********************************************
		// Create the 1st Main Line 
	  	//***********************************************
	  	double[] nukStartPos =  {
	  	  		0.2, 
	    		0, 
	    		4.34 };
	  	
	  	double radius = 0.000625;
		double[][] nuclueiPoints = BioGraphics.createCylinderInPlane(Constants.ZPLANE, nukStartPos, radius, 8);
		

		// Move the point around, and connect it, creating a wall of 
		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstructSet = new BioMightInstructSet();
		
		int numInstructions = 18;
		//BioMightOrientation bioMightOrientation = new BioMightOrientation(0.0, 0.0, 1.0, 90);
		for (int instructCount=0; instructCount<numInstructions; instructCount++)
		{
			// Create a place for an instruction 
			BioMightInstruction bioInstruct = new BioMightInstruction();
			
			// Place a transform object into each instruction set
			bioInstruct.setBioMightTransform(bioMightTransform);
			
			if (instructCount==0){		
				//BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, -90);
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(25, 25, 25);
				bioInstruct.setTranslateMatrix(0.0, 0.002, 0.0);      
			}
			else if (instructCount==1){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(2.0, 2.0, 1.0);
				bioInstruct.setTranslateMatrix(0.0, 0.0, -0.0125); 
			}
			else if (instructCount==2){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.25, 1.25, 1.0);
				bioInstruct.setTranslateMatrix(0.0, 0.00, -0.0125);   
			}				
			else if (instructCount==3){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.0, 0.0, -0.0125);      
			}
			else if (instructCount==4){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(0.7, 0.7, 1.0);
				bioInstruct.setTranslateMatrix(0.0, 0.0, -0.0125);      
			}
			else if (instructCount==5){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(0.3, 0.3, 1.0);
				bioInstruct.setTranslateMatrix(0.0, 0.0, -0.0125);      
			}
			else if (instructCount==6){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.0, 0.00, -0.025);       
			}
			else if (instructCount==7){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(-0.01, 0.00, -0.05);       
			}
			else if (instructCount==8){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(-0.01, 0.00, -0.05);       
			}
			else if (instructCount==9){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(-0.02, 0.00, -0.05);       
			}
			else if (instructCount==10){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(-0.01, 0.00, -0.05);       
			}
			else if (instructCount==11){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(-0.01, 0.00, -0.05);       
			}
			else if (instructCount==12){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(-0.02, 0.00, -0.05);       
			}
			else if (instructCount==13){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(-0.02, 0.00, -0.05);       
			}
			else if (instructCount==14){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(-0.02, 0.00, -0.05);       
			}
			else if (instructCount==15){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(-0.03, 0.00, -0.05);       
			}
			else if (instructCount==16){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(-0.03, 0.00, -0.05);       
			}
			else if (instructCount==17){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(-0.02, 0.00, -0.05);       
			}
			else {
				bioInstruct.setTransType(Constants.TRANSLATE);
				BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, 90);
				bioInstruct.setOrientation(orientationUpd);
				bioInstruct.setTranslateMatrix(0.0, -0.05, 0.0);       
			}			
			
			// Add the instruction into the instruction set
    		bioMightInstructSet.addElement(bioInstruct);
		}	
			
		// Pass the instructions to the builder
		body += generateIndexFacedComponents(bioMightOrientation, bioMightInstructSet, nuclueiPoints); 	
				
		
		//***********************************************
		//
		// Create the 2nd comm line
		//
	  	//***********************************************
		
	  	double[] nukStartPos2 =  {
	    		-0.2, 
	    		0, 
	    		4.34 };
		nuclueiPoints = BioGraphics.createCylinderInPlane(Constants.ZPLANE, nukStartPos2, radius, 8);

		bioMightInstructSet = new BioMightInstructSet();
		
		numInstructions = 18;
		//BioMightOrientation bioMightOrientation = new BioMightOrientation(0.0, 0.0, 1.0, 90);
		for (int instructCount=0; instructCount<numInstructions; instructCount++)
		{
			// Create a place for an instruction 
			BioMightInstruction bioInstruct = new BioMightInstruction();
			
			// Place a transform object into each instruction set
			bioInstruct.setBioMightTransform(bioMightTransform);
			
			
			if (instructCount==0){		
				//BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, -90);
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(25, 25, 25);
				bioInstruct.setTranslateMatrix(0.0, 0.002, 0.0);      
			}
			else if (instructCount==1){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(2.0, 2.0, 1.0);
				bioInstruct.setTranslateMatrix(0.0, 0.0, -0.0125); 
			}
			else if (instructCount==2){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.25, 1.25, 1.0);
				bioInstruct.setTranslateMatrix(0.0, 0.00, -0.0125);   
			}				
			else if (instructCount==3){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.0, 0.0, -0.0125);      
			}
			else if (instructCount==4){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(0.7, 0.7, 1.0);
				bioInstruct.setTranslateMatrix(0.0, 0.0, -0.0125);      
			}
			else if (instructCount==5){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(0.3, 0.3, 1.0);
				bioInstruct.setTranslateMatrix(0.0, 0.0, -0.0125);      
			}
			else if (instructCount==6){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.0, 0.00, -0.025);       
			}
			else if (instructCount==7){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.01, 0.00, -0.05);       
			}
			else if (instructCount==8){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.01, 0.00, -0.05);       
			}
			else if (instructCount==9){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.02, 0.00, -0.05);       
			}
			else if (instructCount==10){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.01, 0.00, -0.05);       
			}
			else if (instructCount==11){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.01, 0.00, -0.05);       
			}
			else if (instructCount==12){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.02, 0.00, -0.05);       
			}
			else if (instructCount==13){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.02, 0.00, -0.05);       
			}
			else if (instructCount==14){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.02, 0.00, -0.05);       
			}
			else if (instructCount==15){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.03, 0.00, -0.05);       
			}
			else if (instructCount==16){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.03, 0.00, -0.05);       
			}
			else if (instructCount==17){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.02, 0.00, -0.05);       
			}
			else {
				bioInstruct.setTransType(Constants.TRANSLATE);
				BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, 90);
				bioInstruct.setOrientation(orientationUpd);
				bioInstruct.setTranslateMatrix(0.0, -0.05, 0.0);       
			}			
			
			// Add the instruction into the instruction set
    		bioMightInstructSet.addElement(bioInstruct);
		}	
			
		// Pass the instructions to the builder
		body += generateIndexFacedComponents(bioMightOrientation, bioMightInstructSet, nuclueiPoints); 	
				
		//***********************************************
		//
		// Create the 3rd comm line
		//
	  	//***********************************************
		
	  	double[] nukStartPos3 =  {
	    		0.0, 
	    		0.22, 
	    		4.26 };
		nuclueiPoints = BioGraphics.createCylinderInPlane(Constants.ZPLANE, nukStartPos3, radius, 8);

		bioMightInstructSet = new BioMightInstructSet();
		
		numInstructions = 16;
		//BioMightOrientation bioMightOrientation = new BioMightOrientation(0.0, 0.0, 1.0, 90);
		for (int instructCount=0; instructCount<numInstructions; instructCount++)
		{
			// Create a place for an instruction 
			BioMightInstruction bioInstruct = new BioMightInstruction();
			
			// Place a transform object into each instruction set
			bioInstruct.setBioMightTransform(bioMightTransform);
			
			if (instructCount==0){		
				//BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, -90);
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(25, 25, 25);
				bioInstruct.setTranslateMatrix(0.0, 0.002, 0.0);      
			}
			else if (instructCount==1){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(2.0, 2.0, 1.0);
				bioInstruct.setTranslateMatrix(0.0, 0.0, -0.0125); 
			}
			else if (instructCount==2){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.25, 1.25, 1.0);
				bioInstruct.setTranslateMatrix(0.0, 0.00, -0.0125);   
			}				
			else if (instructCount==3){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.0, 0.0, -0.0125);      
			}
			else if (instructCount==4){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(0.7, 0.7, 1.0);
				bioInstruct.setTranslateMatrix(0.0, 0.0, -0.0125);      
			}
			else if (instructCount==5){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(0.3, 0.3, 1.0);
				bioInstruct.setTranslateMatrix(0.0, 0.0, -0.0125);      
			}
			else if (instructCount==6){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.0, -0.03, -0.025);       
			}
			else if (instructCount==7){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.0, -0.02, -0.05);       
			}
			else if (instructCount==8){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.0, -0.01, -0.05);       
			}
			else if (instructCount==9){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.0, -0.02, -0.05);       
			}
			else if (instructCount==10){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.0, -0.01, -0.05);       
			}
			else if (instructCount==11){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.0, -0.03, -0.05);       
			}
			else if (instructCount==12){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.0, -0.02, -0.05);       
			}
			else if (instructCount==13){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.0, -0.02, -0.05);       
			}
			else if (instructCount==14){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.0, -0.02, -0.05);       
			}
			else if (instructCount==15){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.0, -0.03, -0.05);       
			}
			else {
				bioInstruct.setTransType(Constants.TRANSLATE);
				BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, 90);
				bioInstruct.setOrientation(orientationUpd);
				bioInstruct.setTranslateMatrix(0.0, -0.05, 0.0);       
			}			
			
			// Add the instruction into the instruction set
    		bioMightInstructSet.addElement(bioInstruct);
		}	
			
		// Pass the instructions to the builder
		body += generateIndexFacedComponents(bioMightOrientation, bioMightInstructSet, nuclueiPoints); 	

		
		
		//***********************************************
		//
		// Create the 4th comm line - Sub Branch
		//
	  	//***********************************************
		
		
	  	double[] nukStartPos1A =  {
	  			0.36, 
	    		0, 
	    		4.47};
		nuclueiPoints = BioGraphics.createCylinderInPlane(Constants.ZPLANE, nukStartPos1A, radius, 8);

		bioMightInstructSet = new BioMightInstructSet();
		
		numInstructions = 14;
		//BioMightOrientation bioMightOrientation = new BioMightOrientation(0.0, 0.0, 1.0, 90);
		for (int instructCount=0; instructCount<numInstructions; instructCount++)
		{
			// Create a place for an instruction 
			BioMightInstruction bioInstruct = new BioMightInstruction();
			
			// Place a transform object into each instruction set
			bioInstruct.setBioMightTransform(bioMightTransform);
			
			
			if (instructCount==0){		
				//BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, -90);
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(25, 25, 25);
				bioInstruct.setTranslateMatrix(0.0, 0.002, 0.0);      
			}
			else if (instructCount==1){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(2.0, 2.0, 1.0);
				bioInstruct.setTranslateMatrix(0.0, 0.0, -0.0125); 
			}
			else if (instructCount==2){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.25, 1.25, 1.0);
				bioInstruct.setTranslateMatrix(0.0, 0.00, -0.0125);   
			}				
			else if (instructCount==3){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.0, 0.0, -0.0125);      
			}
			else if (instructCount==4){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(0.7, 0.7, 1.0);
				bioInstruct.setTranslateMatrix(0.0, 0.0, -0.0125);      
			}
			else if (instructCount==5){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(0.3, 0.3, 1.0);
				bioInstruct.setTranslateMatrix(0.0, 0.0, -0.0125);      
			}
			else if (instructCount==6){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.0, 0.00, -0.025);       
			}
			else if (instructCount==7){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(-0.03, 0.0, -0.05);       
			}
			else if (instructCount==8){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(-0.04, 0.0, -0.05);       
			}
			else if (instructCount==9){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(-0.02, 0.0, -0.05);       
			}
			else if (instructCount==10){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(-0.02, 0.0, -0.05);       
			}
			else if (instructCount==11){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(-0.04, 0.0, -0.05);       
			}
			else if (instructCount==12){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(-0.03, 0.0, -0.05);       
			}
			else if (instructCount==13){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(-0.03, 0.0, -0.05);       
			}	
			else {
				bioInstruct.setTransType(Constants.TRANSLATE);
				BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, 90);
				bioInstruct.setOrientation(orientationUpd);
				bioInstruct.setTranslateMatrix(0.0, -0.05, 0.0);       
			}			
			
			// Add the instruction into the instruction set
    		bioMightInstructSet.addElement(bioInstruct);
		}	
			
		// Pass the instructions to the builder
		body += generateIndexFacedComponents(bioMightOrientation, bioMightInstructSet, nuclueiPoints); 	

		
		//***********************************************
		//
		// Create the 4th comm line - Sub Branch
		//
	  	//***********************************************
		
		
	  	double[] nukStartPos3A =  {
	  			-0.36, 
	    		0, 
	    		4.47};
		nuclueiPoints = BioGraphics.createCylinderInPlane(Constants.ZPLANE, nukStartPos3A, radius, 8);

		bioMightInstructSet = new BioMightInstructSet();
		
		numInstructions = 14;
		//BioMightOrientation bioMightOrientation = new BioMightOrientation(0.0, 0.0, 1.0, 90);
		for (int instructCount=0; instructCount<numInstructions; instructCount++)
		{
			// Create a place for an instruction 
			BioMightInstruction bioInstruct = new BioMightInstruction();
			
			// Place a transform object into each instruction set
			bioInstruct.setBioMightTransform(bioMightTransform);
		
			
			if (instructCount==0){		
				//BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, -90);
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(25, 25, 25);
				bioInstruct.setTranslateMatrix(0.0, 0.002, 0.0);      
			}
			else if (instructCount==1){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(2.0, 2.0, 1.0);
				bioInstruct.setTranslateMatrix(0.0, 0.0, -0.0125); 
			}
			else if (instructCount==2){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.25, 1.25, 1.0);
				bioInstruct.setTranslateMatrix(0.0, 0.00, -0.0125);   
			}				
			else if (instructCount==3){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.0, 0.0, -0.0125);      
			}
			else if (instructCount==4){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(0.7, 0.7, 1.0);
				bioInstruct.setTranslateMatrix(0.0, 0.0, -0.0125);      
			}
			else if (instructCount==5){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(0.3, 0.3, 1.0);
				bioInstruct.setTranslateMatrix(0.0, 0.0, -0.0125);      
			}
			else if (instructCount==6){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.0, 0.00, -0.025);       
			}
			else if (instructCount==7){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.03, 0.0, -0.05);       
			}
			else if (instructCount==8){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.04, 0.0, -0.05);       
			}
			else if (instructCount==9){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.02, 0.0, -0.05);       
			}
			else if (instructCount==10){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.02, 0.0, -0.05);       
			}
			else if (instructCount==11){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.04, 0.0, -0.05);       
			}
			else if (instructCount==12){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.03, 0.0, -0.05);       
			}
			else if (instructCount==13){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.03, 0.0, -0.05);       
			}	
			else {
				bioInstruct.setTransType(Constants.TRANSLATE);
				BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, 90);
				bioInstruct.setOrientation(orientationUpd);
				bioInstruct.setTranslateMatrix(0.0, -0.05, 0.0);       
			}			
			
			// Add the instruction into the instruction set
    		bioMightInstructSet.addElement(bioInstruct);
		}	
			
		// Pass the instructions to the builder
		body += generateIndexFacedComponents(bioMightOrientation, bioMightInstructSet, nuclueiPoints); 	

		
		
		//***********************************************
		//
		// Create the 3rd - 1st secondary comm line
		//
		//***********************************************

		double[] nukStartPos3C =  {
			0.0, 
			-0.14, 
			4.48 };
		nuclueiPoints = BioGraphics.createCylinderInPlane(Constants.ZPLANE, nukStartPos3C, radius, 8);
		
		bioMightInstructSet = new BioMightInstructSet();
		
		numInstructions = 16;
		//BioMightOrientation bioMightOrientation = new BioMightOrientation(0.0, 0.0, 1.0, 90);
		for (int instructCount=0; instructCount<numInstructions; instructCount++)
		{
			// Create a place for an instruction 
			BioMightInstruction bioInstruct = new BioMightInstruction();
			
			// Place a transform object into each instruction set
			bioInstruct.setBioMightTransform(bioMightTransform);
			
			
			if (instructCount==0){		
				//BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, -90);
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(25, 25, 25);
				bioInstruct.setTranslateMatrix(0.0, 0.002, 0.0);      
			}
			else if (instructCount==1){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(2.0, 2.0, 1.0);
				bioInstruct.setTranslateMatrix(0.0, 0.0, -0.0125); 
			}
			else if (instructCount==2){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.25, 1.25, 1.0);
				bioInstruct.setTranslateMatrix(0.0, 0.00, -0.0125);   
			}				
			else if (instructCount==3){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.0, 0.0, -0.0125);      
			}
			else if (instructCount==4){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(0.7, 0.7, 1.0);
				bioInstruct.setTranslateMatrix(0.0, 0.0, -0.0125);      
			}
			else if (instructCount==5){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(0.3, 0.3, 1.0);
				bioInstruct.setTranslateMatrix(0.0, 0.0, -0.0125);      
			}
			else if (instructCount==6){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.0, 0.03, -0.025);       
			}
			else if (instructCount==7){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.0, 0.02, -0.05);       
			}
			else if (instructCount==8){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.0, 0.01, -0.05);       
			}
			else if (instructCount==9){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.0, 0.02, -0.05);       
			}
			else if (instructCount==10){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.0, 0.01, -0.05);       
			}
			else if (instructCount==11){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.0, 0.03, -0.05);       
			}
			else if (instructCount==12){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.0, 0.04, -0.05);       
			}
			else if (instructCount==13){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.0, 0.02, -0.05);       
			}
			else if (instructCount==14){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.0, 0.03, -0.05);       
			}
			else if (instructCount==15){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.0, 0.04, -0.05);       
			}
			else {
				bioInstruct.setTransType(Constants.TRANSLATE);
				BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, 90);
				bioInstruct.setOrientation(orientationUpd);
				bioInstruct.setTranslateMatrix(0.0, -0.05, 0.0);       
			}			
			
			// Add the instruction into the instruction set
			bioMightInstructSet.addElement(bioInstruct);
		}	
			
		// Pass the instructions to the builder
		body += generateIndexFacedComponents(bioMightOrientation, bioMightInstructSet, nuclueiPoints); 	
			
		
		//***********************************************
		//
		// Create the 4th - 1st secondary comm line
		//
		//***********************************************

		double[] nukStartPos3D =  {
			0.0, 
			0.365, 
			4.50 };
		nuclueiPoints = BioGraphics.createCylinderInPlane(Constants.ZPLANE, nukStartPos3D, radius, 8);
		
		bioMightInstructSet = new BioMightInstructSet();
		
		numInstructions = 16;
		//BioMightOrientation bioMightOrientation = new BioMightOrientation(0.0, 0.0, 1.0, 90);
		for (int instructCount=0; instructCount<numInstructions; instructCount++)
		{
			// Create a place for an instruction 
			BioMightInstruction bioInstruct = new BioMightInstruction();
			
			// Place a transform object into each instruction set
			bioInstruct.setBioMightTransform(bioMightTransform);
			
			
			if (instructCount==0){		
				//BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, -90);
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(25, 25, 25);
				bioInstruct.setTranslateMatrix(0.0, 0.00, -0.002);      
			}
			else if (instructCount==1){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(2.0, 2.0, 1.0);
				bioInstruct.setTranslateMatrix(0.0, 0.0, -0.0125); 
			}
			else if (instructCount==2){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.25, 1.25, 1.0);
				bioInstruct.setTranslateMatrix(0.0, 0.00, -0.0125);   
			}				
			else if (instructCount==3){
				bioInstruct.setTransType(Constants.TRANSLATE);
				bioInstruct.setTranslateMatrix(0.0, 0.0, -0.0125);      
			}
			else if (instructCount==4){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(0.7, 0.7, 1.0);
				bioInstruct.setTranslateMatrix(0.0, 0.0, -0.0125);      
			}
			else if (instructCount==5){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(0.3, 0.3, 1.0);
				bioInstruct.setTranslateMatrix(0.0, 0.0, -0.0125);      
			}
			else if (instructCount==6){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.0, 0.0, -0.025);       
			}
			else if (instructCount==7){
				bioInstruct.setTransType(Constants.TRANSLATE);
				bioInstruct.setTranslateMatrix(0.0, 0.0, -0.05);       
			}
			else if (instructCount==8){
				bioInstruct.setTransType(Constants.TRANSLATE);
				bioInstruct.setTranslateMatrix(0.0, -0.01, -0.05);       
			}
			else if (instructCount==9){
				bioInstruct.setTransType(Constants.TRANSLATE);
				bioInstruct.setTranslateMatrix(0.0, -0.03, -0.05);       
			}
			else if (instructCount==10){
				bioInstruct.setTransType(Constants.TRANSLATE);
				bioInstruct.setTranslateMatrix(0.0, -0.04, -0.05);       
			}
			else if (instructCount==11){
				bioInstruct.setTransType(Constants.TRANSLATE);
				bioInstruct.setTranslateMatrix(0.0, -0.02, -0.05);       
			}
			else if (instructCount==12){
				bioInstruct.setTransType(Constants.TRANSLATE);
				bioInstruct.setTranslateMatrix(0.0, -0.04, -0.05);       
			}
			else if (instructCount==13){
				bioInstruct.setTransType(Constants.TRANSLATE);
				bioInstruct.setTranslateMatrix(0.0, -0.04, -0.05);       
			}
			else if (instructCount==14){
				bioInstruct.setTransType(Constants.TRANSLATE);
				bioInstruct.setTranslateMatrix(0.0, -0.05, -0.05);       
			}
			else if (instructCount==15){
				bioInstruct.setTransType(Constants.TRANSLATE);
				bioInstruct.setTranslateMatrix(0.0, -0.01, -0.05);       
			}
			else {
				bioInstruct.setTransType(Constants.TRANSLATE);
				BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, 90);
				bioInstruct.setOrientation(orientationUpd);
				bioInstruct.setTranslateMatrix(0.0, -0.05, 0.0);       
			}			
			
			// Add the instruction into the instruction set
			bioMightInstructSet.addElement(bioInstruct);
		}	
			
		// Pass the instructions to the builder
		body += generateIndexFacedComponents(bioMightOrientation, bioMightInstructSet, nuclueiPoints); 	
			
		
		//***********************************************
		//
		// Create the 4th - 1st secondary comm line
		//
		//***********************************************

		double[] nukStartPos3E =  {
			0.16, 
			-0.24, 
			 4.642 };
		nuclueiPoints = BioGraphics.createCylinderInPlane(Constants.ZPLANE, nukStartPos3E, radius, 8);
		
		bioMightInstructSet = new BioMightInstructSet();
		
		numInstructions = 16;
		//BioMightOrientation bioMightOrientation = new BioMightOrientation(0.0, 0.0, 1.0, 90);
		for (int instructCount=0; instructCount<numInstructions; instructCount++)
		{
			// Create a place for an instruction 
			BioMightInstruction bioInstruct = new BioMightInstruction();
			
			// Place a transform object into each instruction set
			bioInstruct.setBioMightTransform(bioMightTransform);
			
			if (instructCount==0){		
				//BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, -90);
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(25, 25, 25);
				bioInstruct.setTranslateMatrix(0.0, 0.00, -0.002);      
			}
			else if (instructCount==1){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(2.0, 2.0, 1.0);
				bioInstruct.setTranslateMatrix(0.0, 0.0, -0.0125); 
			}
			else if (instructCount==2){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.25, 1.25, 1.0);
				bioInstruct.setTranslateMatrix(0.0, 0.00, -0.0125);   
			}				
			else if (instructCount==3){
				bioInstruct.setTransType(Constants.TRANSLATE);
				bioInstruct.setTranslateMatrix(0.0, 0.0, -0.0125);      
			}
			else if (instructCount==4){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(0.7, 0.7, 1.0);
				bioInstruct.setTranslateMatrix(0.0, 0.0, -0.0125);      
			}
			else if (instructCount==5){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(0.3, 0.3, 1.0);
				bioInstruct.setTranslateMatrix(0.0, 0.0, -0.0125);      
			}
			else if (instructCount==6){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.0, 0.0, -0.025);       
			}
			else if (instructCount==7){
				bioInstruct.setTransType(Constants.TRANSLATE);
				bioInstruct.setTranslateMatrix(0.0, 0.0, -0.05);       
			}
			else if (instructCount==8){
				bioInstruct.setTransType(Constants.TRANSLATE);
				bioInstruct.setTranslateMatrix(0.0, 0.01, -0.05);       
			}
			else if (instructCount==9){
				bioInstruct.setTransType(Constants.TRANSLATE);
				bioInstruct.setTranslateMatrix(0.0, 0.03, -0.05);       
			}
			else if (instructCount==10){
				bioInstruct.setTransType(Constants.TRANSLATE);
				bioInstruct.setTranslateMatrix(0.0, 0.04, -0.05);       
			}
			else if (instructCount==11){
				bioInstruct.setTransType(Constants.TRANSLATE);
				bioInstruct.setTranslateMatrix(0.0, 0.03, -0.05);       
			}
			else if (instructCount==12){
				bioInstruct.setTransType(Constants.TRANSLATE);
				bioInstruct.setTranslateMatrix(0.0, 0.05, -0.05);       
			}
			else if (instructCount==13){
				bioInstruct.setTransType(Constants.TRANSLATE);
				bioInstruct.setTranslateMatrix(0.0, 0.04, -0.05);       
			}
			else if (instructCount==14){
				bioInstruct.setTransType(Constants.TRANSLATE);
				bioInstruct.setTranslateMatrix(0.01, 0.03, -0.05);       
			}
			else if (instructCount==15){
				bioInstruct.setTransType(Constants.TRANSLATE);
				bioInstruct.setTranslateMatrix(-0.01, 0.01, -0.05);       
			}
			else {
				bioInstruct.setTransType(Constants.TRANSLATE);
				BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, 90);
				bioInstruct.setOrientation(orientationUpd);
				bioInstruct.setTranslateMatrix(0.0, 0.05, 0.0);       
			}			
			
			// Add the instruction into the instruction set
			bioMightInstructSet.addElement(bioInstruct);
		}	
			
		// Pass the instructions to the builder
		body += generateIndexFacedComponents(bioMightOrientation, bioMightInstructSet, nuclueiPoints); 	

		
		return (body);
	}
  	
  	
	
 	/***********************************************************************************************************************
  	 * GENERATE GONOCOCCI
  	 * 
  	 * Creates Gonococci.  
  	 * 
  	 * @param bioMightTransform
  	 * @param currentPoints
  	 * @param bHeader
  	 * @param bFooter
  	 * @param diffColor
  	 * @return
  	 * 
  	 ***********************************************************************************************************************/
	
  	public static String generateGonococci(BioMightTransform bioMightTransform,  BioMightPosition startPos, BioMightOrientation bioMightOrientation) 	
	{		
		System.out.println("generateGonococci: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());				

		//System.out.println("Getting X3D for GonococciX: " + bioMightTransform.getTranslation().getXPos());
		//System.out.println("Getting X3D for GonococciY: " + bioMightTransform.getTranslation().getYPos());
		//System.out.println("Getting X3D for GonococciZ: " + bioMightTransform.getTranslation().getZPos());
		// Change the height and width based on the displacement.
		
		String body = "";
		int transformCount = 0;
		
		int numLongitude = 12;
		int numLatitude = 12;
		double rotateLatitude = 360/numLatitude;
		double rotateLongitude = 360/numLongitude;
		double angleLatitude = rotateLatitude;
		double angleLongitude = rotateLongitude;
		double radius = 0.5;
		double xOrient = 0.0;
		double yOrient = 1.0;
		double zOrient = 0.0;
			
		double spikeHeight =  0.0675;
		double spikeRadius = 0.00625;
		double halfSpike = MathUtils.round(spikeHeight/2, 8);
		
		
		String bioGroup = "FlagellaGroup";
		BioMightTransform baseTransform = bioMightTransform;
		

		for (int cells=0; cells<1; cells++)
		{
			
			//System.out.println("GenerateCylindricalComponents()  Num Longitude: " + numLongitude + "     NumLatitude: " + numLatitude);
			//System.out.println("GenerateCylindricalComponents()  rotateLongitude: " + rotateLongitude + "   rotateLatitude: " + rotateLatitude);
			
			// Run from top of the sphere to the bottom (Longitude)
			
			//for (int longitude=0; longitude<numLongitude ;longitude++)
			for (int longitude=0; longitude<5; longitude++) 
			{
				// Run from left to right across the latitude separated points of the sphere
				angleLatitude = 0;
				//System.out.println("Completed Complete Rotation - Resetting Latitude");

				for (int latitude=0; latitude<numLatitude; latitude++)
				{					
					//System.out.println("GenerateCylindricalComponents - angleLongitude: " + angleLongitude + "    angleLatitude: " + angleLatitude);
					
					// Set the position on the surface of the sphere based on angle of latitude
					// Set the position on the surface of the sphere based on the longitude
					
					// Set up a Group around the whole spike
					bioGroup = "FlagellaGroup" + "L" + longitude + "L" + latitude;
					body += "\n<Transform DEF='" + bioGroup + "'\n";
					transformCount++;
					
					body += "  translation='" + bioMightTransform.getTranslation().getPositionStr() +  "'>\n\n";
					
					baseTransform = bioMightTransform;
					//body += "\n\n</Transform>\n\n";
					
					
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
					double xPos = MathUtils.round(((radius+halfSpike) * (cosLat * sinLong)), 8);  
					double yPos = MathUtils.round(((radius+halfSpike) * cosLong), 8);
					double zPos = MathUtils.round(((radius+halfSpike) * (sinLat * sinLong)), 8); 
		
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
					body += "<Transform DEF='TRANSFORM_BaseSpike_" + bioGroup + "' \n";
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

					body+= " <ImageTexture containerField='texture' " +
						    " url='../images/BacillusAnthracis.jpg'/>";
					
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
				
					//System.out.println("Cos(Lat): " + cosLat + " Sin(Lat): " + sinLat + "            Sin(Long): " + sinLong + "  cos(Long): " + cosLong);
					//System.out.println("XPOS: " + xPos + "=  Cos(Lat): " + cosLat + " Sin(Long): " + sinLong);
					//System.out.println("YPOS: " + yPos + "=  Sin(Lat): " + sinLat + " Cos(Long): " + cosLong);
					//System.out.println("ZPOS: " + zPos + "=  Cos(Long): " + cosLong);
			
					// Run through the segments that make this string of cells
					int randoLength = new Double(MathUtils.round(Math.random()*15, 0)).intValue();
					randoLength = 0;
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
						// Create SPHERE connector where the position is
						//*****************************************************
						body += "<Transform DEF='TRANSFORM_SPHERECON_" + bioGroup + "'\n";
					
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
		
	
						//body+= " <ImageTexture containerField='texture' " +
						//   " url='../images/BacillusAnthracis.jpg'/>";
				
						    	
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
						double calculatedPoint[][] =  BioGraphics.applyRotation(new double [][] {{0, halfSpike, 0}},  -1, MathUtils.round(Math.toDegrees(spikeDegrees), 4), new double [] {xOrient, yOrient, zOrient} );
								
						// Extract the computed values
						double xPosCalc = calculatedPoint[0][0]; 
						double yPosCalc = calculatedPoint[0][1];
						double zPosCalc = calculatedPoint[0][2]; 
	
						// The Constant Point based on the Sphere Equation
						//System.out.println("Spike StartPoint (Center): " + xSpikePos + "  " + xSpikePos +  "  " +  xSpikePos);
						//System.out.println("Calculated CenterPoint Translate : " + xPosCalc + "  " + yPosCalc +  "  " +  zPosCalc);
						double newPoints[] = BioGraphics.applyTranslation(new double [] {xSpikePos, ySpikePos, zSpikePos}, new double [] {xPosCalc, yPosCalc, zPosCalc});
					
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
						body += "<Transform DEF='TRANSFORM_BACTBODY" + bioGroup + "' \n";
							
						// Let's compute 
					 	body += "translation='" 
							+ xCurSpikePos + " " 
		 					+ yCurSpikePos + " "
		 					+ zCurSpikePos + "'\n";										
	
						body +=  "rotation='" 
								+ xOrient+ " "
								+ yOrient + " "
								+ zOrient  + " "
								+ spikeDegrees + "'\n\n";
			
						 					
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

					//body += animate(bioGroup, baseTransform, transformCount);
					//System.out.println("\n\n COMPLETED ANIMATE: " + bioGroup);
					
	
		    		// Increase the angle on the arc that goes from left to right
		    		angleLatitude += rotateLatitude;
		    		//System.out.println("Incremented Latitude Angle: " + angleLatitude);
				}
				
				// Increase the angle on the Arc that goes top to bottom
				angleLongitude += rotateLongitude;
				//System.out.println("Incremented Longtitude Angle: " + angleLatitude);
			}
		
			
			//***************************************************************
			// Create the Sphere that represents the Cell Membrane
			//****************************************************************
			body += "<Transform DEF='TRANSFORM_Sphere" + bioGroup + "' \n";
										
	 		body += "translation='" 
	 			+ bioMightTransform.getTranslation().getXPos() + " " 
					+ bioMightTransform.getTranslation().getYPos() + " "
					+ bioMightTransform.getTranslation().getZPos() + "'\n";					

			 					
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
			 	"<Sphere DEF='GonococciGeoSphere'\n" +
			 	"containerField='geometry'\n" +
			 	"radius='" + bioMightTransform.getRadius() +"'/>\n" +
			 	"</Shape>\n" +
			 	
				"\n<TouchSensor DEF='TSENSOR_" + bioMightTransform.getId() + "' \n" +
                   " description='Gonococci'\n" +
	               " containerField='children'/> \n" +

			 "</Transform>\n";
		}
		
		return(body);
	}

  	

  	
	/***********************************************************************************************************************
	 * GENERATE APPENDAGES
	 * 
	 * This method creates a series of appendages/tentacles/feelers
	 * 
	 * @param bioMightTransform
	 * @param currentPoints
	 * @param bHeader
	 * @param bFooter
	 * @param diffColor
	 * @return
	 ***********************************************************************************************************************/
	 	
	public static String generateAppendages(BioMightTransform bioMightTransform, BioMightRange bioRange) 	
	{	
		int numLongitude = 18;
		int numLatitude = 18;
		double rotateLatitude = 360/numLatitude;
		double rotateLongitude = 360/numLongitude;
		double angleLatitude = 0;
		double angleLongitude = 0;
		
		double orbitalRadius = bioMightTransform.getRadius();
		
		String body = "";
		String bioGroup = "AppendageGroup";
		BioMightTransform baseTransform = bioMightTransform;
		int transformCount = 0;
		
		double xStartPos = bioMightTransform.getTranslation().getXPos();
		double yStartPos = bioMightTransform.getTranslation().getYPos();
		double zStartPos = bioMightTransform.getTranslation().getZPos();
		
		
		// Run from top of the sphere to the bottom (Longitude).  We only have to do 180 degrees of the sphere,
		// or there will be over
		for (int longitude=0; longitude<=9; longitude++) 
		{
			// Run from left to right across the latitude separated points of the sphere
			angleLatitude = 0;
			//System.out.println("Completed Complete Rotation - Resetting Latitude");

			// Show only those within the longitude range.  The UI can pass in Lat/Long ranges
			// and these will be used to disperse the spikes according to the user's needs
			//if (longitude>=bioRange.getMinLongRange() && longitude<=bioRange.getMaxLongRange())
						
			if (longitude >= 0)
			{
			
				// We must skip or they are all sitting on top of each other
				if (longitude==0 || longitude==9) {
					numLatitude = 1;
				}
				else
					numLatitude = 18;
				
				for (int latitude=0; latitude<numLatitude; latitude++)
				{	
					// Reset for the next dendrite
					xStartPos = bioMightTransform.getTranslation().getXPos();
					yStartPos = bioMightTransform.getTranslation().getYPos();
					zStartPos = bioMightTransform.getTranslation().getZPos();
					
				
					// Show only those within the latitude range
					//if (latitude>=bioRange.getMinLatRange() && latitude<=bioRange.getMaxLatRange())
					//if (latitude> 0 || ((longitude == 7 && (latitude%2 == 0)) ))
					if (latitude >= 0)
					{
						
						
					// On the first longitude, we must 
					if (longitude==1 || longitude==8) {
						if (latitude%2 == 0)
						{
							//System.out.println("Skipping Latitude " + longitude + "  " + latitude);
							angleLatitude += rotateLatitude;
							continue;
						}
					}
						
					//System.out.println("Generating Appendage - angleLongitude: " + angleLongitude + "    angleLatitude: " + angleLatitude);
		
					// Set up a Group around the whole spike
					bioGroup = "AppendageGroup" + "L" + longitude + "L" + latitude;
					body += "\n<Transform DEF='" + bioGroup + "'\n";
					transformCount++;
					
					body += "  translation='" + bioMightTransform.getTranslation().getPositionStr() +  "'>\n\n";
							
					baseTransform = bioMightTransform;
					//body += "\n\n</Transform>\n\n";
			
					//**************************************************************************
					// Calculate the position of the initial spike that lays on the surphace of
					// the sphere
					//**************************************************************************
					
					// Convert the degrees to radians
					double diversionLatitude = Math.random()*10;
					double diversionLongitude = Math.random()*10;
					
					double radiansLatitude =  Math.toRadians(angleLatitude + diversionLatitude);
					double radiansLongitude =  Math.toRadians(angleLongitude + diversionLongitude);
					//System.out.println("Dendrite RadiansLatitude: " + radiansLatitude + " flagRadiansLongitude: " + radiansLongitude);
	
					// Calculate sine and cosine of the current longiture and latitude
					double cosLat = MathUtils.round(Math.cos(radiansLatitude), 8);
					double cosLong = MathUtils.round(Math.cos(radiansLongitude), 8);
					double sinLong = MathUtils.round(Math.sin(radiansLongitude), 8);
					double sinLat = MathUtils.round(Math.sin(radiansLatitude), 8);
			
					// Calculate the position for the Spike.  
					double xSpikePos = MathUtils.round(((orbitalRadius) * (cosLat * sinLong)), 8);  
					double ySpikePos = MathUtils.round(((orbitalRadius) * cosLong), 8);
					double zSpikePos = MathUtils.round(((orbitalRadius) * (sinLat * sinLong)), 8); 
					//System.out.println("StartPoint Appendage Cylinder Center: " + orbitalRadius + "   "  + xSpikePos + "  " + xSpikePos +  "  " +  xSpikePos);
			
					// Adjust to start postion
					xSpikePos += xStartPos;
					ySpikePos += yStartPos;
					zSpikePos += zStartPos;
	
					// Update the start position
					xStartPos = xSpikePos;
					yStartPos = ySpikePos;
					zStartPos = zSpikePos;
					
					// ************************************************************************
					// We have the position on the object, so create the starting set of points
					//*************************************************************************
				  	double dendriteRadius = 0.0625;
				  	double[] basePosition = {xSpikePos, ySpikePos, zSpikePos};
				  	double[] tempTranslate = {0, 0, 0};
				  	
				  	double orientation[] = {-angleLongitude, -angleLatitude};
					double[][] currentPoints = createCylinderInPlane(orientation,  basePosition, dendriteRadius, 8);
					
					int randoLength = 10; //new Double(MathUtils.round(Math.random()*bioRange.getSections(), 0)).intValue();
					double minRadius = 0.02;
					double decreaseRate = 0.0125; //randoLength/10;
						
					//**********************************************************
					// Run through the sections and create the Appendage
					//**********************************************************
					int runCount = 0;
					double satelliteRadius = 0.035;		
					// Set up the Angle for growth path
					double randomRotateAngle = 0;	
					
					// Generate a random length for the Appendage
					int minLength=3;
					int maxLength = 15;
					randoLength = minLength + (int)(Math.random() * ((maxLength - minLength) + 1));
		
					//System.out.println("Selected Appendage Length: " + firstDigit + " = " + randoLength);
					//randoLength=3;   
					
					// As random generates a number between 0 and 1
					// We will not be getting a negative angle to work with.
					// This will even it out.
					int negga = -1;
					double negativeOrPositive = Math.random();
					if (negativeOrPositive >= 0.50)
						negga = 1;
					
					double oneThird = MathUtils.round(randoLength/3, 3);
					for (int v=0; v<randoLength; v++) {
						
						// Do not apply an angle to the first two sections of the appendage
						if (runCount>=2) {		
						
							//System.out.println("Generating RandomRotate: " + v);
							minLength=0;
							maxLength = 45;
							randomRotateAngle = minLength + (int)(Math.random() * ((maxLength - minLength) + 1));
							//System.out.println("Setting RandomRotate at v: " + v + "  angle: " + randomRotateAngle);
						}
						else
							//System.out.println("Keeping RandomRotate runCount:  " + runCount + "   v: " + v + "  angle:  " + randomRotateAngle);
							
						runCount++;
						
						//****************************************************************************************
						// Find the new position by using the new latitude and longitude
						// Convert the degrees to radians
						// Apply a deviation to the latitutde and longitude so that it varies by a little
						// HAVE TO CALCULATE
						//*****************************************************************************************
						
						radiansLatitude =  Math.toRadians(angleLatitude);
						radiansLongitude =  Math.toRadians(angleLongitude + randomRotateAngle);
						//System.out.println("Dendrite RadiansLatitude: " + radiansLatitude + " flagRadiansLongitude: " + radiansLongitude);
	
						// Calculate sine and cosine of the new Angles
						cosLat = MathUtils.round(Math.cos(radiansLatitude), 8);
						cosLong = MathUtils.round(Math.cos(radiansLongitude), 8);
						sinLong = MathUtils.round(Math.sin(radiansLongitude), 8);
						sinLat = MathUtils.round(Math.sin(radiansLatitude), 8);
				
						
						// Set the position for the Dendrite.  Make it sit on the outside of the membrane
						double xPos = MathUtils.round(((satelliteRadius) * (cosLat * sinLong)), 8);  
						double yPos = MathUtils.round(((satelliteRadius) * cosLong), 8);
						double zPos = MathUtils.round(((satelliteRadius) * (sinLat * sinLong)), 8); 
			
						// Translate to where its specified start position is
						xPos += xStartPos;
						yPos += yStartPos;
						zPos += zStartPos;
				
						// Update the start position
						xStartPos = xPos;
						yStartPos = yPos;
						zStartPos = zPos;
										
						//System.out.println("Cos(Lat): " + cosLat + " Sin(Lat): " + sinLat + "            Sin(Long): " + sinLong + "  cos(Long): " + cosLong);
						//System.out.print   ln("XPOS: " + xPos + "=  Cos(Lat): " + cosLat + " Sin(Long): " + sinLong);
						//System.out.println("YPOS: " + yPos + "=  Sin(Lat): " + sinLat + " Cos(Long): " + cosLong);
						//System.out.println("ZPOS: " + zPos + "=  Cos(Long): " + cosLong);
						
						// Set the Orientation of the Cylinder on the surface of the Sphere
						// We create a perpindicular and then rotate out by the Longitudenal angle
						double perpindick = angleLatitude+90;
						double perpindickRadians = Math.toRadians(perpindick);
						//System.out.println("ORIENTing Cylinder about " + perpindick + "   radians: " + perpindickRadians);
						
						double xOrient =  MathUtils.round(Math.cos(perpindickRadians), 8);
						double yOrient =  0;  
						double zOrient =  MathUtils.round(Math.sin(perpindickRadians), 8); ;// MathUtils.round(Math.sin(perpindick) * -1, 8);  //MathUtils.round(1 * Math.cos(angleLongitude), 8); 
						
						//System.out.println("X-AXIS: " + xOrient);
						//System.out.println("Y-AXIS: " + yOrient);
						//System.out.println("Z-AXIS: " + zOrient);
		
						// Adjust the radius smaller and smaller as we go
						// Divide the number of sections by the distance and
						// Determine how much we need to decrease the diameter/radius
	
						
						if (v == randoLength-1) {
							dendriteRadius = 0.000125;
							//System.out.println("DendriteRadius Closure: " + v +  "  radius: " + dendriteRadius);	
						}
						
						
						//System.out.println("Orbital Radius: " + orbitalRadius);
						double[] spikePosition = {xPos, yPos, zPos};
						double[][] nextPoints = createCylinderInPlane(orientation, spikePosition, dendriteRadius, 8);
						//double[] scaleNext = {1, 1, 1}; 
						//nextPoints = BioGraphics.applyScale(nextPoints, tempTranslate, scaleNext);
						
						
						
						//****************************************
						//  Connect the current and next points
						//****************************************
						// Now that the points are generated, create the sides
						// If we are creating an octogon, that would be 4 sides
						String topRowVertices = "";
						String bottomRowVertices = "";
	
						int numPoints = nextPoints.length;
						for (int point=0; point<numPoints; point++)
						{					
							// Set up the vertices for the current and next points
							/// build the top row
							if (point==0)
								topRowVertices = "\n" + currentPoints[point][0]  + ", " +  currentPoints[point][1] + ", " + currentPoints[point][2];
							else
								topRowVertices += ",\n  " + currentPoints[point][0]  + ",  " +  currentPoints[point][1] + ",  " + currentPoints[point][2];		
					
							// Buid the bottom row
							if (point==0)
								bottomRowVertices = "\n" + nextPoints[point][0]  + ", " +  nextPoints[point][1] + ", " + nextPoints[point][2];
							else
								bottomRowVertices += ",\n  " + nextPoints[point][0]  + ",  " +  nextPoints[point][1] + ",  " + nextPoints[point][2];		
				
						}
						
						String vertices = topRowVertices + "," + bottomRowVertices;
						//System.out.println("COORDS are: " + vertices);
				
	
						// Now connect the points together
						String tempIndexStr = "";
						for (int point=0; point<numPoints; point++)
						{
							
							if (point==0)
							{	
								tempIndexStr = " " +  
										(point+1)     			+ "  " +
										 point 			+ "  " +
										(point+numPoints) 	+ "  " +
										(point+numPoints+1) + "  -1";
							}	
							else if (point==(numPoints-1))
							{	
								tempIndexStr += ", " +  
										0    			+ "  " +
										(numPoints-1) + "  " +
										(2*numPoints-1) 	+ "  " +
										numPoints + "  -1";
							}
							else
							{	
								tempIndexStr += ", " +  
										(point+1) 		+ "  " +
										 point 			+ "  " +
										(point+numPoints) + "  " +
										(point+numPoints+1) + "  -1";
							}
						}
						
						//System.out.println("********* Index is: " + tempIndexStr);	
	
				
						String componentType = "Section_" + v;
						body += "<Transform  onmouseover=\"showComponent('" + bioMightTransform.getComponentName() +  "');\"  DEF='" + componentType + "'\n";
						
						//body += "translation='" 
						//+ xStartPos + " " 
						//+ yStartPos + " "
						//+ zStartPos + "'\n";					
						
						body+= "scale='" 	
						+ bioMightTransform.getScale().getXPos()  + " "
						+ bioMightTransform.getScale().getYPos() + " "
						+ bioMightTransform.getScale().getZPos()  + "'>\n" +
						"<Shape DEF='" + componentType + "'\n" +
						
						" containerField='children'>\n" +
						" <Appearance\n" +
						"  containerField='appearance'>\n";
						
						//bioMightTransform.setCoordpoint(Constants.TRIANGLE, coordinateString, 0.025, 0);
						//bioMightTransform.setCoordIndex(tempInd);
						
						body+= " <ImageTexture containerField='texture' " +
						" url='../images/StaphylococcusAureus.png'/>";
						
						body+= " <Material DEF='Rust'\n" +
						"containerField='material'\n" +
						"ambientIntensity='" + bioMightTransform.getMaterial().getAmbientIntensity() + "'\n" +
						"shininess='" 		 + bioMightTransform.getMaterial().getShininess() + "'\n" +
						"transparency='" 	 + 0.0 + "'\n" +
						"diffuseColor='" + 
						0.0 + " " + 
						0.20 + " " +
						0.40 + "'/>\n" +
						"</Appearance>\n" +
						
						
						"<IndexedFaceSet DEF='EndoArcIFS' \n" +
						"containerField='geometry' \n" +
						"solid='false' \n" +
						"creaseAngle='" +  bioMightTransform.getCreaseAngle() + "'\n" +
						"coordIndex='" + tempIndexStr + "'>" +
						"<Coordinate DEF='Endo_Coord' \n" + 
						"containerField='coord' point='" + vertices + "'/>\n" +
						"</IndexedFaceSet>\n" +
						"</Shape>\n" +
						
						"<TouchSensor DEF='StartEndothelium' \n" +
						" description='" + componentType + "'\n" +
						" containerField='children'/> \n" +
						
						"</Transform>\n"; 
										
						
						// Store the prior set of points
						for (int l=0; l<nextPoints.length; l++) 
						{
							currentPoints[l][0] = nextPoints[l][0]; 
							currentPoints[l][1] = nextPoints[l][1]; 
							currentPoints[l][2] = nextPoints[l][2]; 
						}			
					}
					
						
					// Set up a Group that assembles the flagellum
					body += "\n\n</Transform>\n\n";
					///System.out.println("\n\n CALLING ANIMATE: " + bioGroup);
					//body += animate(bioGroup, baseTransform, transformCount);
					//System.out.println("\n\n COMPLETED ANIMATE: " + bioGroup);
	
					}
					
		    		// Increase the angle on the arc that goes from left to right
		    		angleLatitude += rotateLatitude;
		    		//System.out.println("Incremented Latitude Angle: " + angleLatitude);
				}
			}
			
			// Increase the angle on the Arc that goes top to bottom
			angleLongitude += rotateLongitude;
			System.out.println("Incremented Longtitude Angle: " + angleLongitude + "\n\n");
		}
	
		return (body);
	}
  	
	/***********************************************************************************************************************
	 * GENERATE DENDRITES
	 * 
	 * This method creates a series of dendrites based on longitude and latitude.  It increases the radius to get the 
	 * next section of the dendritic spike.
	 * 
	 * @param bioMightTransform
	 * @param currentPoints
	 * @param bHeader
	 * @param bFooter
	 * @param diffColor
	 * @return
	 ***********************************************************************************************************************/
	 	
	public static String generateDendrites(BioMightTransform bioMightTransform,  BioMightRange bioRange) 	
	{	
		int numLongitude = 12;
		int numLatitude = 12;
		double rotateLatitude = 360/numLatitude;
		double rotateLongitude = 360/numLongitude;
		double angleLatitude = 0;
		double angleLongitude = rotateLongitude;
		
		double radius = bioMightTransform.getRadius() - 0.1;
				
		double xOrient = 0.0;
		double yOrient = 1.0;
		double zOrient = 0.0;
			
			
		String body = "";
		String bioGroup = "DendriteGroup";
		BioMightTransform baseTransform = bioMightTransform;
		int transformCount = 0;
		
		double xStartPos = bioMightTransform.getTranslation().getXPos();
		double yStartPos = bioMightTransform.getTranslation().getYPos();
		double zStartPos = bioMightTransform.getTranslation().getZPos();
		
		
		//System.out.println("GenerateCylindricalComponents()  Num Longitude: " + numLongitude + "     NumLatitude: " + numLatitude);
		//System.out.println("GenerateCylindricalComponents()  rotateLongitude: " + rotateLongitude + "   rotateLatitude: " + rotateLatitude);
		
		
		// Run from top of the sphere to the bottom (Longitude)
		for (int longitude=0; longitude<numLongitude; longitude++) 
		{
			// Run from left to right across the latitude separated points of the sphere
			angleLatitude = 0;
			//System.out.println("Completed Complete Rotation - Resetting Latitude");

			// Show only those within the longitude range.  The UI can pass in Lat/Long ranges
			// and these will be used to disperse the spikes according to the user's needs
			//if (longitude>=bioRange.getMinLongRange() && longitude<=bioRange.getMaxLongRange())
			if (longitude==0 || longitude==3 || longitude==6 || longitude == 9)
			{
			
			for (int latitude=0; latitude<numLatitude; latitude++)
			{	
				// Reset for the next dendrite
				radius = bioMightTransform.getRadius() - 0.1;
				xStartPos = bioMightTransform.getTranslation().getXPos();
				yStartPos = bioMightTransform.getTranslation().getYPos();
				zStartPos = bioMightTransform.getTranslation().getZPos();
				
			
				// Show only those within the latitude range
				//if (latitude>=bioRange.getMinLatRange() && latitude<=bioRange.getMaxLatRange())
				if (latitude == 0 || latitude == 4 || latitude == 8 || latitude == 11)
				{
				
				System.out.println("Generating Dendrites - angleLongitude: " + angleLongitude + "    angleLatitude: " + angleLatitude);
				// Set the position on the surface of the sphere based on angle of latitude
				// Set the position on the surace of the sphere based on the longitude
				
				// Set up a Group around the whole spike
				bioGroup = "DendriteGroup" + "L" + longitude + "L" + latitude;
				body += "\n<Transform DEF='" + bioGroup + "'\n";
				transformCount++;
				
				body += "  translation='" + bioMightTransform.getTranslation().getPositionStr() +  "'>\n\n";
						
				baseTransform = bioMightTransform;
				//body += "\n\n</Transform>\n\n";
		
				//********************************************************
				// Calculate the position of the initial spike
				//********************************************************
				
				// Convert the degrees to radians
				double radiansLatitude =  Math.toRadians(angleLatitude);
				double radiansLongitude =  Math.toRadians(angleLongitude);
				//System.out.println("Dendrite RadiansLatitude: " + radiansLatitude + " flagRadiansLongitude: " + radiansLongitude);

				// Calculate sine and cosine of the current longiture and latitude
				double cosLat = MathUtils.round(Math.cos(radiansLatitude), 8);
				double cosLong = MathUtils.round(Math.cos(radiansLongitude), 8);
				double sinLong = MathUtils.round(Math.sin(radiansLongitude), 8);
				double sinLat = MathUtils.round(Math.sin(radiansLatitude), 8);
		
				// Calculate the position for the Spike.  
				double xSpikePos = MathUtils.round(((radius) * (cosLat * sinLong)), 8);  
				double ySpikePos = MathUtils.round(((radius) * cosLong), 8);
				double zSpikePos = MathUtils.round(((radius) * (sinLat * sinLong)), 8); 
				System.out.println("StartPoint Dendrite Cylinder Center: " + xSpikePos + "  " + xSpikePos +  "  " +  xSpikePos);
		
				// Adjust to start postion
				xSpikePos += xStartPos;
				ySpikePos += yStartPos;
				zSpikePos += zStartPos;

				// Update the start position
				xStartPos = xSpikePos;
				yStartPos = ySpikePos;
				zStartPos = zSpikePos;
				
				// *******************************************
				// Create the starting Cylinder of points
				//********************************************
			  	double dendriteRadius = 0.125;
			  	double[] basePosition = {xSpikePos, ySpikePos, zSpikePos};
			  	double[] tempTranslate = {0, 0, 0};
			  	
				double scaleX = 1.25;
			  	double[] scale = {scaleX, 1, 1};
			  	double orientation[] = {-angleLongitude, -angleLatitude};
				double[][] currentPoints = createCylinderInPlane(orientation,  basePosition, dendriteRadius, 8);
				currentPoints = BioGraphics.applyScale(currentPoints, tempTranslate, scale);
				
				double minRadius = 0.02;
				double decreaseRate = 0.0125; //randoLength/10;
				
				//**********************************************************
				// Run through the sections and create the Dendrite Arm
				// Run through the segments that make this string of cells
				//**********************************************************
				double orbitalRadius  = 0.05;
				int runCount = 0;
				
				// Set up the Angle for growth path
				double randomRotateAngle = 0;

				// Generate a random length for the Dendritic Spike
				int minLength = 25;
				int maxLength = 35;
				int randoLength =  minLength + (int)(Math.random() * ((maxLength - minLength) + 1));	
				System.out.println("Selected Dendritic Arm Length: " + randoLength);
				
				double oneThird = MathUtils.round(randoLength/3, 3);
				for (int v=0; v<randoLength; v++) {
					
					if (v > oneThird && runCount>=3) {		
					
						System.out.println("Generating RandomRotate: " + v);
						minLength = 0;
						maxLength = 30;
						randomRotateAngle = minLength + (int)(Math.random() * ((maxLength - minLength) + 1));	
						System.out.println("Generating RandomRotate at v: " + v + "  angle:  " + randomRotateAngle);
						
						// As Random generates a number between 0 and 1
						// We will no be getting a negative angle to work with.
						// This will even it out.
						//double negativeOrPositive = Math.random();
						//if (negativeOrPositive >= 0.50)
						//randomRotateAngle =  randomRotateAngle * -1;
						
						runCount = 0;
						System.out.println("Setting RandomRotate at v: " + v + "  angle: " + randomRotateAngle);
					}
					else
						System.out.println("Keeping RandomRotate runCount:  " + runCount + "   v: " + v + "  angle:  " + randomRotateAngle);
						
					runCount++;
					
					// Convert the degrees to radians
					// Apply a deviation to the latitutde and longitude so that it varies by a little
					// HAVE TO CALCULATE
					
					radiansLatitude =  Math.toRadians(angleLatitude);
					radiansLongitude =  Math.toRadians(angleLongitude + randomRotateAngle);
					//System.out.println("Dendrite RadiansLatitude: " + radiansLatitude + " flagRadiansLongitude: " + radiansLongitude);

					// Calculate sine and cosine of the new Angles
					cosLat = MathUtils.round(Math.cos(radiansLatitude), 8);
					cosLong = MathUtils.round(Math.cos(radiansLongitude), 8);
					sinLong = MathUtils.round(Math.sin(radiansLongitude), 8);
					sinLat = MathUtils.round(Math.sin(radiansLatitude), 8);
			
					
					// Set the position for the Dendrite.  Make it sit on the outside of the membrane
					double xPos = MathUtils.round(((orbitalRadius) * (cosLat * sinLong)), 8);  
					double yPos = MathUtils.round(((orbitalRadius) * cosLong), 8);
					double zPos = MathUtils.round(((orbitalRadius) * (sinLat * sinLong)), 8); 
		
					// Translate to where its specified start position is
					xPos += xStartPos;
					yPos += yStartPos;
					zPos += zStartPos;
			
					// Update the start position
					xStartPos = xPos;
					yStartPos = yPos;
					zStartPos = zPos;
									
					//System.out.println("Cos(Lat): " + cosLat + " Sin(Lat): " + sinLat + "            Sin(Long): " + sinLong + "  cos(Long): " + cosLong);
					//System.out.print   ln("XPOS: " + xPos + "=  Cos(Lat): " + cosLat + " Sin(Long): " + sinLong);
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
	
					// Adjust the radius smaller and smaller as we go
					// Divide the number of sections by the distance and
					// Determine how much we need to decrease the diameter/radius

					if (v <= oneThird) {
						scaleX = 1.5;
						decreaseRate = 0.0125;
						dendriteRadius -= decreaseRate;

						System.out.println("DendriteRadius at 1/3: " + v +  "  radius: " + dendriteRadius);	
					}
					else if (v > oneThird && v <= 2 * oneThird) {
						
						if (scaleX > 1.0)
							scaleX = scaleX-0.125;
						
						decreaseRate = 0.00625;
						dendriteRadius = 0.02;
						//dendriteRadius -= decreaseRate;

						System.out.println("DendriteRadius at 1/3 to 2/3: " + v +  "  radius: " + dendriteRadius)	;
					}
					else
					{
						scaleX = 1.0;
						decreaseRate = 0.00625;
						dendriteRadius -= decreaseRate;
						System.out.println("DendriteRadius at > 2/3: " +  + v +  "  radius:  " + dendriteRadius);
					}
					
					// Do not get less than the radius
					if (dendriteRadius < 0.02)
						dendriteRadius = minRadius;
					
					// This is used to determine how far apart the sections are based on the sphere formula
					//radius = 0.05;
					
					System.out.println("Orbital Radius: " + orbitalRadius  +  "    " + dendriteRadius);
					double[] spikePosition = {xPos, yPos, zPos};
					double[][] nextPoints = createCylinderInPlane(orientation, spikePosition, dendriteRadius, 8);
					double[] scaleNext = {scaleX, 1, 1}; 
					nextPoints = BioGraphics.applyScale(nextPoints, tempTranslate, scaleNext);
					
					//****************************************
					//  Connect the current and next points
					//****************************************
					// Now that the points are generated, create the sides
					// If we are creating an octogon, that would be 4 sides
					String topRowVertices = "";
					String bottomRowVertices = "";

					int numPoints = nextPoints.length;
					for (int point=0; point<numPoints; point++)
					{					
						// Set up the vertices for the current and next points
						/// build the top row
						if (point==0)
							topRowVertices = "\n" + currentPoints[point][0]  + ", " +  currentPoints[point][1] + ", " + currentPoints[point][2];
						else
							topRowVertices += ",\n  " + currentPoints[point][0]  + ",  " +  currentPoints[point][1] + ",  " + currentPoints[point][2];		
				
						// Buid the bottom row
						if (point==0)
							bottomRowVertices = "\n" + nextPoints[point][0]  + ", " +  nextPoints[point][1] + ", " + nextPoints[point][2];
						else
							bottomRowVertices += ",\n  " + nextPoints[point][0]  + ",  " +  nextPoints[point][1] + ",  " + nextPoints[point][2];		
			
					}
					
					String vertices = topRowVertices + "," + bottomRowVertices;
					//System.out.println("COORDS are: " + vertices);
			

					// Now connect the points together
					String tempIndexStr = "";
					for (int point=0; point<numPoints; point++)
					{
						
						if (point==0)
						{	
							tempIndexStr = " " +  
									(point+1)     			+ "  " +
									 point 			+ "  " +
									(point+numPoints) 	+ "  " +
									(point+numPoints+1) + "  -1";
						}	
						else if (point==(numPoints-1))
						{	
							tempIndexStr += ", " +  
									0    			+ "  " +
									(numPoints-1) + "  " +
									(2*numPoints-1) 	+ "  " +
									numPoints + "  -1";
						}
						else
						{	
							tempIndexStr += ", " +  
									(point+1) 		+ "  " +
									 point 			+ "  " +
									(point+numPoints) + "  " +
									(point+numPoints+1) + "  -1";
						}
					}
					
					//System.out.println("********* Index is: " + tempIndexStr);	

			
					String componentType = "Section_" + v;
					body += "<Transform  onmouseover=\"showComponent('" + bioMightTransform.getComponentName() +  "');\"  DEF='" + componentType + "'\n";
					
					//body += "translation='" 
					//+ xStartPos + " " 
					//+ yStartPos + " "
					//+ zStartPos + "'\n";					
					
					body+= "scale='" 	
					+ bioMightTransform.getScale().getXPos()  + " "
					+ bioMightTransform.getScale().getYPos() + " "
					+ bioMightTransform.getScale().getZPos()  + "'>\n" +
					"<Shape DEF='" + componentType + "'\n" +
					
					" containerField='children'>\n" +
					" <Appearance\n" +
					"  containerField='appearance'>\n";
					
					//bioMightTransform.setCoordpoint(Constants.TRIANGLE, coordinateString, 0.025, 0);
					//bioMightTransform.setCoordIndex(tempInd);
					
					body+= " <ImageTexture containerField='texture' " +
					" url='../images/StaphylococcusAureus.png'/>";
					
					body+= " <Material DEF='Rust'\n" +
					"containerField='material'\n" +
					"ambientIntensity='" + bioMightTransform.getMaterial().getAmbientIntensity() + "'\n" +
					"shininess='" 		 + bioMightTransform.getMaterial().getShininess() + "'\n" +
					"transparency='" 	 + 0.0 + "'\n" +
					"diffuseColor='" + 
					0.0 + " " + 
					0.20 + " " +
					0.40 + "'/>\n" +
					"</Appearance>\n" +
					
					
					"<IndexedFaceSet DEF='EndoArcIFS' \n" +
					"containerField='geometry' \n" +
					"solid='false' \n" +
					"creaseAngle='" +  bioMightTransform.getCreaseAngle() + "'\n" +
					"coordIndex='" + tempIndexStr + "'>" +
					"<Coordinate DEF='Endo_Coord' \n" + 
					"containerField='coord' point='" + vertices + "'/>\n" +
					"</IndexedFaceSet>\n" +
					"</Shape>\n" +
					
					"<TouchSensor DEF='StartEndothelium' \n" +
					" description='" + componentType + "'\n" +
					" containerField='children'/> \n" +
					
					"</Transform>\n"; 
					
					
					//**********************************************************
					// Creates a dendrite at a specific position
					//**********************************************************

					BioMightPosition currentPos = bioMightTransform.getTranslation();
					double currentRadius = bioMightTransform.getRadius();
					if (v == 18) {

						BioMightPosition spikePos = new BioMightPosition(xPos, yPos, zPos);
						bioMightTransform.setTranslation(spikePos);
						bioMightTransform.setRadius(dendriteRadius);
						
						// Pass the instructions to the builder
						double[] taperPoint = {0.25, 0.50};
						double[] taperValue = {radius, radius/3};
						int minAppendages = 15;
						int maxAppendages = 30;
						//latitude = 0.0;
						//double longitude = 90.0;
						
						System.out.println("Generating DendriteSpike with DendriteRadius: " + dendriteRadius + "  orbital " + radius);
						int growthPath = 0;
						minRadius = 0.02;
						double maxRadius = 0.25;
						BioMightAppendage bioMightAppendage = new BioMightAppendage("Dendrite", Constants.Neuron, orbitalRadius, minRadius, maxRadius, dendriteRadius, taperPoint,
								taperValue, minAppendages, maxAppendages,
								angleLatitude, angleLongitude, 0, 30, 0, 30, bioMightTransform.getTextureID(), bioMightTransform.getTextureFile());
						
						body += generateAppendage(bioMightAppendage, bioMightTransform);	
					}
					bioMightTransform.setTranslation(currentPos);
					bioMightTransform.setRadius(currentRadius);
					
					
					// Store the prior set of points
					for (int l=0; l<nextPoints.length; l++)
					{
						currentPoints[l][0] = nextPoints[l][0]; 
						currentPoints[l][1] = nextPoints[l][1]; 
						currentPoints[l][2] = nextPoints[l][2]; 
					}
							
				}
				
					
				// Set up a Group that assembles the flagellum
				body += "\n\n</Transform>\n\n";
				///System.out.println("\n\n CALLING ANIMATE: " + bioGroup);
				//body += animate(bioGroup, baseTransform, transformCount);
				//System.out.println("\n\n COMPLETED ANIMATE: " + bioGroup);

				}
				
	    		// Increase the angle on the arc that goes from left to right
	    		angleLatitude += rotateLatitude;
	    		//System.out.println("Incremented Latitude Angle: " + angleLatitude);
			}
			}
			
			// Increase the angle on the Arc that goes top to bottom
			angleLongitude += rotateLongitude;
			//System.out.println("Incremented Longtitude Angle: " + angleLatitude);
		}
	
		return (body);
	}
  	
	
	/***********************************************************************************************************************
	 * GENERATE REOVIRUS
	 * 
	 * This method creates the appendages that comprise a ReoVirus
	 * 
	 * We need an algorithm that tells us where on the sphere to place appendage.   We need a routine that given the
	 * position and orientation can create an appendage at that location.
	 * 
	 * @param bioMightTransform
	 * @param currentPoints
	 * @param bHeader
	 * @param bFooter
	 * @param diffColor
	 * @return
	 ***********************************************************************************************************************/
	 	
	public static String generateReoVirus(BioMightTransform bioMightTransform,  BioMightRange bioRange) 	
	{	
		int numLongitude = 18;
		int numLatitude = 18;
		double rotateLatitude = 360/numLatitude;
		double rotateLongitude = 360/numLongitude;
		double angleLatitude = 0;
		double angleLongitude = rotateLongitude;
		
		double radius = bioMightTransform.getRadius();
				
		double xOrient = 0.0;
		double yOrient = 1.0;
		double zOrient = 0.0;
			
			
		String body = "";
		String bioGroup = "ReoVirusAppendageGroup";
		BioMightTransform baseTransform = bioMightTransform;
		int transformCount = 0;
		
		double xStartPos = bioMightTransform.getTranslation().getXPos();
		double yStartPos = bioMightTransform.getTranslation().getYPos();
		double zStartPos = bioMightTransform.getTranslation().getZPos();
		
		
		//System.out.println("GenerateReoVirus()  Num Longitude: " + numLongitude + "     NumLatitude: " + numLatitude);
		//System.out.println("GenerateReoVirus()  rotateLongitude: " + rotateLongitude + "   rotateLatitude: " + rotateLatitude);
		
		
		// Run from top of the sphere to the bottom (Longitude)
		for (int longitude=0; longitude<numLongitude/2; longitude++) 
		{
			// Run from left to right across the latitude separated points of the sphere
			angleLatitude = 0;
			//System.out.println("Completed Complete Rotation - Resetting Latitude");

			// Show only those within the longitude range.  The UI can pass in Lat/Long ranges
			// and these will be used to disperse the spikes according to the user's needs
			//if (longitude>=bioRange.getMinLongRange() && longitude<=bioRange.getMaxLongRange())
			if (longitude>=0)
			{
			
			for (int latitude=0; latitude<numLatitude; latitude++)
			{	
				// Reset for the next appendage
				radius = bioMightTransform.getRadius();
				xStartPos = bioMightTransform.getTranslation().getXPos();
				yStartPos = bioMightTransform.getTranslation().getYPos();
				zStartPos = bioMightTransform.getTranslation().getZPos();
				
			
				// Show only those within the latitude range
				//if (latitude>=bioRange.getMinLatRange() && latitude<=bioRange.getMaxLatRange())
				if (latitude >= 0)
				{
				
				System.out.println("Generating ReoVirusAppendage - angleLongitude: " + angleLongitude + "    angleLatitude: " + angleLatitude);
				// Set the position on the surface of the sphere based on angle of latitude
				// Set the position on the surace of the sphere based on the longitude
				
				// Set up a Group around the whole spike
				bioGroup = "ReoVirusGroup" + "L" + longitude + "L" + latitude;
				body += "\n<Transform DEF='" + bioGroup + "'\n";
				transformCount++;
				
				body += "  translation='" + bioMightTransform.getTranslation().getPositionStr() +  "'>\n\n";
						
				baseTransform = bioMightTransform;
				//body += "\n\n</Transform>\n\n";
		
				//********************************************************
				// Calculate the position of the initial spike
				//********************************************************
				
				// Convert the degrees to radians
				double radiansLatitude =  Math.toRadians(angleLatitude);
				double radiansLongitude =  Math.toRadians(angleLongitude);
				//System.out.println("Dendrite RadiansLatitude: " + radiansLatitude + " flagRadiansLongitude: " + radiansLongitude);

				// Calculate sine and cosine of the current longiture and latitude
				double cosLat = MathUtils.round(Math.cos(radiansLatitude), 8);
				double cosLong = MathUtils.round(Math.cos(radiansLongitude), 8);
				double sinLong = MathUtils.round(Math.sin(radiansLongitude), 8);
				double sinLat = MathUtils.round(Math.sin(radiansLatitude), 8);
		
				// Calculate the position for the Spike.  
				double xSpikePos = MathUtils.round(((radius) * (cosLat * sinLong)), 8);  
				double ySpikePos = MathUtils.round(((radius) * cosLong), 8);
				double zSpikePos = MathUtils.round(((radius) * (sinLat * sinLong)), 8); 
				
				System.out.println("StartPoint of Virus: " + xStartPos + "  " + yStartPos +  "  " +  zStartPos);
				System.out.println("StartPoint ReoVirus Cylinder Center: " + xSpikePos + "  " + ySpikePos +  "  " +  zSpikePos);
		
				// Adjust to start postion
				xSpikePos += xStartPos;
				ySpikePos += yStartPos;
				zSpikePos += zStartPos;
								
				//**********************************************************
				// Creates a dendrite at a specific position
				//**********************************************************
				
				// Create 6 sections around the center
				if ( ((latitude % 3 == 0) && (longitude == 3))  ||
					 ((latitude % 6 == 0) && (longitude == 5))  ||
					 ((latitude % 6 == 0) && (longitude == 1)) )
				{
				  	double dendriteRadius = 0.075;		
					double minRadius = 0.02;
					double orbitalRadius  = 0.05;
	
					BioMightPosition currentPos = bioMightTransform.getTranslation();
					double currentRadius = bioMightTransform.getRadius();
					
					BioMightPosition spikePos = new BioMightPosition(xSpikePos, ySpikePos, zSpikePos);
					bioMightTransform.setTranslation(spikePos);
					bioMightTransform.setRadius(dendriteRadius);
					bioMightTransform.setTextureID(6);
					bioMightTransform.setTextureFile("StaphylococcusAureus.png");
					
					// Pass the instructions to the builder
					double[] taperPoint = {0.25, 0.50};
					double[] taperValue = {radius, radius/3};
					int minAppendages =  4;
					int maxAppendages = 6;
					
					System.out.println("Generating ReoVirusSpike with Appendage Radius: " + dendriteRadius + "  orbital " + radius);
					minRadius = 0.02;
					double maxRadius = 0.25;
					
					// Create the 1st spike
					BioMightAppendage bioMightAppendage = new BioMightAppendage("GlycoProtein Spike", Constants.ReoVirus, orbitalRadius, minRadius, maxRadius, dendriteRadius, taperPoint,
							taperValue, minAppendages, maxAppendages,
							angleLatitude, angleLongitude, 0, 30, 0, 30, bioMightTransform.getTextureID(), bioMightTransform.getTextureFile());
					body += generateAppendage(bioMightAppendage, bioMightTransform);	
					
					// Create the 2nd spike
					bioMightAppendage = new BioMightAppendage("GlycoProtein Spike", Constants.ReoVirus, orbitalRadius, minRadius, maxRadius, dendriteRadius, taperPoint,
							taperValue, minAppendages, maxAppendages,
							angleLatitude+30, angleLongitude+30, 0, 30, 0, 30, bioMightTransform.getTextureID(), bioMightTransform.getTextureFile());
					
					body += generateAppendage(bioMightAppendage, bioMightTransform);	
	
					// Create the 3rd Spike
					bioMightAppendage = new BioMightAppendage("GlycoProtein Spike", Constants.ReoVirus, orbitalRadius, minRadius, maxRadius, dendriteRadius, taperPoint,
							taperValue, minAppendages, maxAppendages,
							angleLatitude-30, angleLongitude+30, 0, 30, 0, 30, bioMightTransform.getTextureID(), bioMightTransform.getTextureFile());
					
					body += generateAppendage(bioMightAppendage, bioMightTransform);	
					
					
					// Create the 4th Spike
					bioMightAppendage = new BioMightAppendage("GlycoProtein Spike", Constants.ReoVirus, orbitalRadius, minRadius, maxRadius, dendriteRadius, taperPoint,
							taperValue, minAppendages, maxAppendages,
							angleLatitude-30, angleLongitude-30, 0, 30, 0, 30, bioMightTransform.getTextureID(), bioMightTransform.getTextureFile());
					
					body += generateAppendage(bioMightAppendage, bioMightTransform);	
		
					
					// Create the 5th Spike
					bioMightAppendage = new BioMightAppendage("GlycoProtein Spike", Constants.ReoVirus, orbitalRadius, minRadius, maxRadius, dendriteRadius, taperPoint,
							taperValue, minAppendages, maxAppendages,
							angleLatitude+30, angleLongitude-30, 0, 30, 0, 30, bioMightTransform.getTextureID(), bioMightTransform.getTextureFile());
					
					body += generateAppendage(bioMightAppendage, bioMightTransform);
					
					bioMightTransform.setTranslation(currentPos);
					bioMightTransform.setRadius(currentRadius);
				}
				else
				{
				  	double dendriteRadius = 0.05;		
					double minRadius = 0.02;
					double orbitalRadius  = 0.025;
	
					BioMightPosition currentPos = bioMightTransform.getTranslation();
					double currentRadius = bioMightTransform.getRadius();
					
					BioMightPosition spikePos = new BioMightPosition(xSpikePos, ySpikePos, zSpikePos);
					bioMightTransform.setTranslation(spikePos);
					bioMightTransform.setRadius(dendriteRadius);
					bioMightTransform.setTextureID(6);
					bioMightTransform.setTextureFile("SpeckledGreen.png");
					
					// Pass the instructions to the builder
					double[] taperPoint = {0.25, 0.50};
					double[] taperValue = {radius, radius/3};
					int minAppendages =  2;
					int maxAppendages = 3;
					
					System.out.println("Generating ReoVirusSpike with Appendage Radius: " + dendriteRadius + "  orbital " + radius);
					minRadius = 0.02;
					double maxRadius = 0.25;
					
					// Create the 1st spike
					BioMightAppendage bioMightAppendage = new BioMightAppendage("GlycoProtein Spike", Constants.ReoVirus, orbitalRadius, minRadius, maxRadius, dendriteRadius, taperPoint,
							taperValue, minAppendages, maxAppendages,
							angleLatitude, angleLongitude, 0, 30, 0, 30, bioMightTransform.getTextureID(), bioMightTransform.getTextureFile());
					
					body += generateAppendage(bioMightAppendage, bioMightTransform);
					
					bioMightTransform.setTranslation(currentPos);
					bioMightTransform.setRadius(currentRadius);	
					
				}
										
				// Set up a Group that assembles the flagellum
				body += "\n\n</Transform>\n\n";
				///System.out.println("\n\n CALLING ANIMATE: " + bioGroup);
				//body += animate(bioGroup, baseTransform, transformCount);
				//System.out.println("\n\n COMPLETED ANIMATE: " + bioGroup);

				}
				
	    		// Increase the angle on the arc that goes from left to right
	    		angleLatitude += rotateLatitude;
	    		//System.out.println("Incremented Latitude Angle: " + angleLatitude);
			}
			}
			
			// Increase the angle on the Arc that goes top to bottom
			angleLongitude += rotateLongitude;
			//System.out.println("Incremented Longtitude Angle: " + angleLatitude);
		}
	
		return (body);
	}
  	
	
	
	/***********************************************************************************************************************
	 * GENERATE ROTAVIRUS
	 * 
	 * This method creates the appendages that comprise a RotaVirus
	 * 
	 * We need an algorithm that tells us where on the sphere to place appendage.   We need a routine that given the
	 * position and orientation can create an appendage at that location.
	 * 
	 * @param bioMightTransform
	 * @param currentPoints
	 * @param bHeader
	 * @param bFooter
	 * @param diffColor
	 * @return
	 ***********************************************************************************************************************/
	 	
	public static String generateRotaVirus(BioMightTransform bioMightTransform,  BioMightRange bioRange) 	
	{	
		int numLongitude = 18;
		int numLatitude = 18;
		double rotateLatitude = 360/numLatitude;
		double rotateLongitude = 360/numLongitude;
		double angleLatitude = 0;
		double angleLongitude = rotateLongitude;
		
		double radius = bioMightTransform.getRadius();
				
		double xOrient = 0.0;
		double yOrient = 1.0;
		double zOrient = 0.0;
			
			
		String body = "";
		String bioGroup = "RotaVirusAppendageGroup";
		BioMightTransform baseTransform = bioMightTransform;
		int transformCount = 0;
		
		double xStartPos = bioMightTransform.getTranslation().getXPos();
		double yStartPos = bioMightTransform.getTranslation().getYPos();
		double zStartPos = bioMightTransform.getTranslation().getZPos();
		
		
		//System.out.println("GenerateReoVirus()  Num Longitude: " + numLongitude + "     NumLatitude: " + numLatitude);
		//System.out.println("GenerateReoVirus()  rotateLongitude: " + rotateLongitude + "   rotateLatitude: " + rotateLatitude);
		
		
		// Run from top of the sphere to the bottom (Longitude)
		for (int longitude=0; longitude<numLongitude/2; longitude++) 
		{
			// Run from left to right across the latitude separated points of the sphere
			angleLatitude = 0;
			//System.out.println("Completed Complete Rotation - Resetting Latitude");

			// Show only those within the longitude range.  The UI can pass in Lat/Long ranges
			// and these will be used to disperse the spikes according to the user's needs
			//if (longitude>=bioRange.getMinLongRange() && longitude<=bioRange.getMaxLongRange())
			if (longitude>=0)
			{
			
			for (int latitude=0; latitude<numLatitude; latitude++)
			{	
				// Reset for the next appendage
				radius = bioMightTransform.getRadius();
				xStartPos = bioMightTransform.getTranslation().getXPos();
				yStartPos = bioMightTransform.getTranslation().getYPos();
				zStartPos = bioMightTransform.getTranslation().getZPos();
				
			
				// Show only those within the latitude range
				//if (latitude>=bioRange.getMinLatRange() && latitude<=bioRange.getMaxLatRange())
				if (latitude >= 0)
				{
				
				System.out.println("Generating RotaVirusAppendage - angleLongitude: " + angleLongitude + "    angleLatitude: " + angleLatitude);
				// Set the position on the surface of the sphere based on angle of latitude
				// Set the position on the surace of the sphere based on the longitude
				
				// Set up a Group around the whole spike
				bioGroup = "RotaVirusGroup" + "L" + longitude + "L" + latitude;
				body += "\n<Transform DEF='" + bioGroup + "'\n";
				transformCount++;
				
				body += "  translation='" + bioMightTransform.getTranslation().getPositionStr() +  "'>\n\n";
						
				baseTransform = bioMightTransform;
				//body += "\n\n</Transform>\n\n";
		
				//********************************************************
				// Calculate the position of the initial spike
				//********************************************************
				
				// Convert the degrees to radians
				double radiansLatitude =  Math.toRadians(angleLatitude);
				double radiansLongitude =  Math.toRadians(angleLongitude);
				//System.out.println("Dendrite RadiansLatitude: " + radiansLatitude + " flagRadiansLongitude: " + radiansLongitude);

				// Calculate sine and cosine of the current longiture and latitude
				double cosLat = MathUtils.round(Math.cos(radiansLatitude), 8);
				double cosLong = MathUtils.round(Math.cos(radiansLongitude), 8);
				double sinLong = MathUtils.round(Math.sin(radiansLongitude), 8);
				double sinLat = MathUtils.round(Math.sin(radiansLatitude), 8);
		
				// Calculate the position for the Spike.  
				double xSpikePos = MathUtils.round(((radius) * (cosLat * sinLong)), 8);  
				double ySpikePos = MathUtils.round(((radius) * cosLong), 8);
				double zSpikePos = MathUtils.round(((radius) * (sinLat * sinLong)), 8); 
				
				System.out.println("StartPoint of Virus: " + xStartPos + "  " + yStartPos +  "  " +  zStartPos);
				System.out.println("StartPoint RotaVirus Cylinder Center: " + xSpikePos + "  " + ySpikePos +  "  " +  zSpikePos);
		
				// Adjust to start postion
				xSpikePos += xStartPos;
				ySpikePos += yStartPos;
				zSpikePos += zStartPos;
								
				//**********************************************************
				// Creates a dendrite at a specific position
				//**********************************************************
				
				// Create 6 sections around the center
				if ( ((latitude % 3 == 0) && (longitude == 3))  ||
					 ((latitude % 6 == 0) && (longitude == 5))  ||
					 ((latitude % 6 == 0) && (longitude == 1)) )
				{
				  	double dendriteRadius = 0.075;		
					double minRadius = 0.02;
					double orbitalRadius  = 0.05;
	
					BioMightPosition currentPos = bioMightTransform.getTranslation();
					double currentRadius = bioMightTransform.getRadius();
					
					BioMightPosition spikePos = new BioMightPosition(xSpikePos, ySpikePos, zSpikePos);
					bioMightTransform.setTranslation(spikePos);
					bioMightTransform.setRadius(dendriteRadius);
					bioMightTransform.setTextureID(6);
					bioMightTransform.setTextureFile("StaphylococcusAureus.png");
					
					// Pass the instructions to the builder
					double[] taperPoint = {0.25, 0.50};
					double[] taperValue = {radius, radius/3};
					int minAppendages =  4;
					int maxAppendages = 6;
					
					System.out.println("Generating RotaVirusSpike with Appendage Radius: " + dendriteRadius + "  orbital " + radius);
					minRadius = 0.02;
					double maxRadius = 0.25;
					
					// Create the 1st spike
					BioMightAppendage bioMightAppendage = new BioMightAppendage("GlycoProtein Spike", Constants.RotaVirus, orbitalRadius, minRadius, maxRadius, dendriteRadius, taperPoint,
							taperValue, minAppendages, maxAppendages,
							angleLatitude, angleLongitude, 0, 5, 0, 5, bioMightTransform.getTextureID(), bioMightTransform.getTextureFile());
					
					body += generateAppendage(bioMightAppendage, bioMightTransform);	
					
					// Create the 2nd spike
					bioMightAppendage = new BioMightAppendage("GlycoProtein Spike", Constants.RotaVirus, orbitalRadius, minRadius, maxRadius, dendriteRadius, taperPoint,
							taperValue, minAppendages, maxAppendages,
							angleLatitude+30, angleLongitude+30, 0, 5, 0, 5, bioMightTransform.getTextureID(), bioMightTransform.getTextureFile());
					
					body += generateAppendage(bioMightAppendage, bioMightTransform);	
	
					// Create the 3rd Spike
					bioMightAppendage = new BioMightAppendage("GlycoProtein Spike", Constants.RotaVirus, orbitalRadius, minRadius, maxRadius, dendriteRadius, taperPoint,
							taperValue, minAppendages, maxAppendages,
							angleLatitude-30, angleLongitude+30, 0, 5, 0, 5, bioMightTransform.getTextureID(), bioMightTransform.getTextureFile());
					
					body += generateAppendage(bioMightAppendage, bioMightTransform);	
					
					
					// Create the 4th Spike
					bioMightAppendage = new BioMightAppendage("GlycoProtein Spike", Constants.RotaVirus, orbitalRadius, minRadius, maxRadius, dendriteRadius, taperPoint,
							taperValue, minAppendages, maxAppendages,
							angleLatitude-30, angleLongitude-30, 0, 5, 0, 5, bioMightTransform.getTextureID(), bioMightTransform.getTextureFile());
					
					body += generateAppendage(bioMightAppendage, bioMightTransform);	
		
					
					// Create the 5th Spike
					bioMightAppendage = new BioMightAppendage("GlycoProtein Spike", Constants.RotaVirus, orbitalRadius, minRadius, maxRadius, dendriteRadius, taperPoint,
							taperValue, minAppendages, maxAppendages,
							angleLatitude+30, angleLongitude-30, 0, 5, 0, 5, bioMightTransform.getTextureID(), bioMightTransform.getTextureFile());
					
					body += generateAppendage(bioMightAppendage, bioMightTransform);
					
					bioMightTransform.setTranslation(currentPos);
					bioMightTransform.setRadius(currentRadius);
				}
				else
				{
				  	double dendriteRadius = 0.05;		
					double minRadius = 0.02;
					double orbitalRadius  = 0.025;
	
					BioMightPosition currentPos = bioMightTransform.getTranslation();
					double currentRadius = bioMightTransform.getRadius();
					
					BioMightPosition spikePos = new BioMightPosition(xSpikePos, ySpikePos, zSpikePos);
					bioMightTransform.setTranslation(spikePos);
					bioMightTransform.setRadius(dendriteRadius);
					bioMightTransform.setTextureID(6);
					bioMightTransform.setTextureFile("SpeckledGreen.png");
					
					// Pass the instructions to the builder
					double[] taperPoint = {0.25, 0.50};
					double[] taperValue = {radius, radius/3};
					int minAppendages =  2;
					int maxAppendages = 3;
					
					System.out.println("Generating RotaVirusSpike with Appendage Radius: " + dendriteRadius + "  orbital " + radius);
					minRadius = 0.02;
					double maxRadius = 0.25;
					
					// Create the 1st spike
					BioMightAppendage bioMightAppendage = new BioMightAppendage("GlycoProtein Spike", Constants.RotaVirus, orbitalRadius, minRadius, maxRadius, dendriteRadius, taperPoint,
							taperValue, minAppendages, maxAppendages,
							angleLatitude, angleLongitude, 0, 5, 0, 5, bioMightTransform.getTextureID(), bioMightTransform.getTextureFile());
					
					body += generateAppendage(bioMightAppendage, bioMightTransform);
					
					bioMightTransform.setTranslation(currentPos);
					bioMightTransform.setRadius(currentRadius);	
					
				}
										
				// Set up a Group that assembles the flagellum
				body += "\n\n</Transform>\n\n";
				///System.out.println("\n\n CALLING ANIMATE: " + bioGroup);
				//body += animate(bioGroup, baseTransform, transformCount);
				//System.out.println("\n\n COMPLETED ANIMATE: " + bioGroup);

				}
				
	    		// Increase the angle on the arc that goes from left to right
	    		angleLatitude += rotateLatitude;
	    		//System.out.println("Incremented Latitude Angle: " + angleLatitude);
			}
			}
			
			// Increase the angle on the Arc that goes top to bottom
			angleLongitude += rotateLongitude;
			//System.out.println("Incremented Longtitude Angle: " + angleLatitude);
		}
	
		return (body);
	}
  	
	/***********************************************************************************************************************
	 * GENERATE NOROOVIRUS
	 * 
	 * This method creates the appendages that comprise a NoroVirus
	 * 
	 * Create the outer shell of the RetroVirus
	 * 
	 * @param bioMightTransform
	 * @param currentPoints
	 * @param bHeader
	 * @param bFooter
	 * @param diffColor
	 * @return
	 ***********************************************************************************************************************/
	 	
	public static String generateNoroVirus(BioMightTransform bioMightTransform,  BioMightRange bioRange) 	
	{	
		int numLongitude = 18;
		int numLatitude = 18;
		double rotateLatitude = 360/numLatitude;
		double rotateLongitude = 360/numLongitude;
		double angleLatitude = 0;
		double angleLongitude = rotateLongitude;
		
		double radius = bioMightTransform.getRadius();
				
		double xOrient = 0.0;
		double yOrient = 1.0;
		double zOrient = 0.0;
			
			
		String body = "";
		String bioGroup = "NoroVirusAppendageGroup";
		BioMightTransform baseTransform = bioMightTransform;
		int transformCount = 0;
		
		double xStartPos = bioMightTransform.getTranslation().getXPos();
		double yStartPos = bioMightTransform.getTranslation().getYPos();
		double zStartPos = bioMightTransform.getTranslation().getZPos();
		
		
		//System.out.println("GenerateReoVirus()  Num Longitude: " + numLongitude + "     NumLatitude: " + numLatitude);
		//System.out.println("GenerateReoVirus()  rotateLongitude: " + rotateLongitude + "   rotateLatitude: " + rotateLatitude);
		
		
		// Run from top of the sphere to the bottom (Longitude)
		for (int longitude=0; longitude<numLongitude/2; longitude++) 
		{
			// Run from left to right across the latitude separated points of the sphere
			angleLatitude = 0;
			//System.out.println("Completed Complete Rotation - Resetting Latitude");

			// Show only those within the longitude range.  The UI can pass in Lat/Long ranges
			// and these will be used to disperse the spikes according to the user's needs
			//if (longitude>=bioRange.getMinLongRange() && longitude<=bioRange.getMaxLongRange())
			if (longitude>=0)
			{
			
			for (int latitude=0; latitude<numLatitude; latitude++)
			{	
				// Reset for the next appendage
				radius = bioMightTransform.getRadius();
				xStartPos = bioMightTransform.getTranslation().getXPos();
				yStartPos = bioMightTransform.getTranslation().getYPos();
				zStartPos = bioMightTransform.getTranslation().getZPos();
				
			
				// Show only those within the latitude range
				//if (latitude>=bioRange.getMinLatRange() && latitude<=bioRange.getMaxLatRange())
				if (latitude >= 0)
				{
				
				System.out.println("Generating NoroVirusAppendage - angleLongitude: " + angleLongitude + "    angleLatitude: " + angleLatitude);
				// Set the position on the surface of the sphere based on angle of latitude
				// Set the position on the surace of the sphere based on the longitude
				
				// Set up a Group around the whole spike
				bioGroup = "NoroVirusGroup" + "L" + longitude + "L" + latitude;
				body += "\n<Transform DEF='" + bioGroup + "'\n";
				transformCount++;
				
				body += "  translation='" + bioMightTransform.getTranslation().getPositionStr() +  "'>\n\n";
						
				baseTransform = bioMightTransform;
				//body += "\n\n</Transform>\n\n";
		
				//********************************************************
				// Calculate the position of the initial spike
				//********************************************************
				
				// Convert the degrees to radians
				double radiansLatitude =  Math.toRadians(angleLatitude);
				double radiansLongitude =  Math.toRadians(angleLongitude);
				//System.out.println("Dendrite RadiansLatitude: " + radiansLatitude + " flagRadiansLongitude: " + radiansLongitude);

				// Calculate sine and cosine of the current longiture and latitude
				double cosLat = MathUtils.round(Math.cos(radiansLatitude), 8);
				double cosLong = MathUtils.round(Math.cos(radiansLongitude), 8);
				double sinLong = MathUtils.round(Math.sin(radiansLongitude), 8);
				double sinLat = MathUtils.round(Math.sin(radiansLatitude), 8);
		
				// Calculate the position for the Spike.  
				double xSpikePos = MathUtils.round(((radius) * (cosLat * sinLong)), 8);  
				double ySpikePos = MathUtils.round(((radius) * cosLong), 8);
				double zSpikePos = MathUtils.round(((radius) * (sinLat * sinLong)), 8); 
				
				System.out.println("StartPoint of Virus: " + xStartPos + "  " + yStartPos +  "  " +  zStartPos);
				System.out.println("StartPoint NoroVirus Cylinder Center: " + xSpikePos + "  " + ySpikePos +  "  " +  zSpikePos);
		
				// Adjust to start postion
				xSpikePos += xStartPos;
				ySpikePos += yStartPos;
				zSpikePos += zStartPos;
								
				//**********************************************************
				// Creates a dendrite at a specific position
				//**********************************************************
				
		
			  	double dendriteRadius = 0.05;		
				double minRadius = 0.02;
				double orbitalRadius  = 0.025;

				BioMightPosition currentPos = bioMightTransform.getTranslation();
				double currentRadius = bioMightTransform.getRadius();
				
				BioMightPosition spikePos = new BioMightPosition(xSpikePos, ySpikePos, zSpikePos);
				bioMightTransform.setTranslation(spikePos);
				bioMightTransform.setRadius(dendriteRadius);
				bioMightTransform.setTextureID(6);
				bioMightTransform.setTextureFile("SpeckledGreen.png");
				
				// Pass the instructions to the builder
				double[] taperPoint = {0.25, 0.50};
				double[] taperValue = {radius, radius/3};
				int minAppendages =  6;
				int maxAppendages = 6;
				
				System.out.println("Generating NoroVirusSpike with Appendage Radius: " + dendriteRadius + "  orbital " + radius);
				minRadius = 0.02;
				double maxRadius = 0.25;
				
				// Create the 1st spike
				BioMightAppendage bioMightAppendage = new BioMightAppendage("GlycoProtein Spike", Constants.NoroVirus, orbitalRadius, minRadius, maxRadius, dendriteRadius, taperPoint,
						taperValue, minAppendages, maxAppendages,
						angleLatitude, angleLongitude, 0, 5, 0, 5, bioMightTransform.getTextureID(), bioMightTransform.getTextureFile());
				
				body += generateAppendage(bioMightAppendage, bioMightTransform);
				
				bioMightTransform.setTranslation(currentPos);
				bioMightTransform.setRadius(currentRadius);	
				
			
				// Set up a Group that assembles the flagellum
				body += "\n\n</Transform>\n\n";
				///System.out.println("\n\n CALLING ANIMATE: " + bioGroup);
				//body += animate(bioGroup, baseTransform, transformCount);
				//System.out.println("\n\n COMPLETED ANIMATE: " + bioGroup);

				}
				
	    		// Increase the angle on the arc that goes from left to right
	    		angleLatitude += rotateLatitude;
	    		//System.out.println("Incremented Latitude Angle: " + angleLatitude);
			}
			}
			
			// Increase the angle on the Arc that goes top to bottom
			angleLongitude += rotateLongitude;
			//System.out.println("Incremented Longtitude Angle: " + angleLatitude);
		}
	
		return (body);
	}
  	
	
	/***********************************************************************************************************************
	 * GENERATE AIDSVIRUS Glycoprotein Spikes
	 * 
	 * This method creates the appendages for the AIDS Virus
	 * 
	 * Create the outer shell of the AIDSVirus
	 * 
	 * @param bioMightTransform
	 * @param currentPoints
	 * @param bHeader
	 * @param bFooter
	 * @param diffColor
	 * @return
	 ***********************************************************************************************************************/
	 	
	public static String generateAIDSGlycoSpikes(BioMightTransform bioMightTransform,  BioMightRange bioRange) 	
	{	
		int numLongitude = 18;
		int numLatitude = 18;
		double rotateLatitude = 360/numLatitude;
		double rotateLongitude = 360/numLongitude;
		double angleLatitude = 0;
		double angleLongitude = 0;
		
		double radius = bioMightTransform.getRadius();
				
		double xOrient = 0.0;
		double yOrient = 1.0;
		double zOrient = 0.0;
			
			
		String body = "";
		String bioGroup = "AIDSVirusAppendageGroup";
		BioMightTransform baseTransform = bioMightTransform;
		int transformCount = 0;
		
		double xStartPos = bioMightTransform.getTranslation().getXPos();
		double yStartPos = bioMightTransform.getTranslation().getYPos();
		double zStartPos = bioMightTransform.getTranslation().getZPos();
		
		
		//System.out.println("GenerateReoVirus()  Num Longitude: " + numLongitude + "     NumLatitude: " + numLatitude);
		//System.out.println("GenerateReoVirus()  rotateLongitude: " + rotateLongitude + "   rotateLatitude: " + rotateLatitude);
		
		
		// Run from top of the sphere to the bottom (Longitude)
		for (int longitude=0; longitude<=(numLongitude/2); longitude++) 
		{
			// Run from left to right across the latitude separated points of the sphere
			angleLatitude = 0;
			//System.out.println("Completed Complete Rotation - Resetting Latitude");

			// Show only those within the longitude range.  The UI can pass in Lat/Long ranges
			// and these will be used to disperse the spikes according to the user's needs
			//if (longitude>=bioRange.getMinLongRange() && longitude<=bioRange.getMaxLongRange())
			if (longitude>=0)
			{
			
				for (int latitude=0; latitude<numLatitude; latitude++)
				{	
					// Reset for the next appendage
					radius = bioMightTransform.getRadius();
					xStartPos = bioMightTransform.getTranslation().getXPos();
					yStartPos = bioMightTransform.getTranslation().getYPos();
					zStartPos = bioMightTransform.getTranslation().getZPos();
					
					 System.out.println("Generating AIDSVirusAppendage - angleLongitude: " + angleLongitude + "    angleLatitude: " + angleLatitude);
					 System.out.println("Generating AIDSVirusAppendage - Longitude: " + longitude + "    Latitude: " + latitude);		
				
					// Show only those within the latitude range
					//if (latitude>=bioRange.getMinLatRange() && latitude<=bioRange.getMaxLatRange())
					if (latitude >= 0)
					{
					
					 // At the poles, only generate once
					 if ((longitude == 0 || longitude == (numLongitude/2)) && (latitude > 0))
					 {
						// System.out.println("Generating AIDSVirusAppendage SKIP - Longitude: " + longitude + "    Latitude: " + latitude);	
						// System.out.println("Generating AIDSVirusAppendage SKIP - angleLongitude: " + angleLongitude + "    angleLatitude: " + angleLatitude);
						 angleLatitude += rotateLatitude;
						 continue;
					 }	  
					 // At the latitude next to the poles, skip ever other one
					 else if ((longitude == 1 || longitude == (numLongitude/2)-1) && latitude%2 == 0)
					 {
						 //System.out.println("Generating AIDSVirusAppendage SKIP - Longitude: " + longitude + "    Latitude: " + latitude);	
						 //System.out.println("Generating AIDSVirusAppendage SKIP - angleLongitude: " + angleLongitude + "    angleLatitude: " + angleLatitude);
						 angleLatitude += rotateLatitude;
						 continue;
					 }	
					 
					 
					// Set the position on the surface of the sphere based on angle of latitude
					// Set the position on the surace of the sphere based on the longitude
					
					// Set up a Group around the whole spike
					bioGroup = "AIDSVirusGroup" + "L" + longitude + "L" + latitude;
					//body += "\n<Transform DEF='" + bioGroup + "'\n";
					transformCount++;
					String componentType = "GlycoProteinSpike";
					body += "<Transform  onmouseover=\"showComponent('" + "GlycoProteinSpike" +  "');\"  DEF='" + componentType + "'\n";
					body += "  translation='" + bioMightTransform.getTranslation().getPositionStr() +  "'>\n\n";
							
					baseTransform = bioMightTransform;
					//body += "\n\n</Transform>\n\n";
			
					//********************************************************
					// Calculate the position of the initial spike
					//********************************************************
					
					// Convert the degrees to radians
					double radiansLatitude =  Math.toRadians(angleLatitude);
					double radiansLongitude =  Math.toRadians(angleLongitude);
					//System.out.println("Dendrite RadiansLatitude: " + radiansLatitude + " flagRadiansLongitude: " + radiansLongitude);
	
					// Calculate sine and cosine of the current longiture and latitude
					double cosLat = MathUtils.round(Math.cos(radiansLatitude), 8);
					double cosLong = MathUtils.round(Math.cos(radiansLongitude), 8);
					double sinLong = MathUtils.round(Math.sin(radiansLongitude), 8);
					double sinLat = MathUtils.round(Math.sin(radiansLatitude), 8);
			
					// Calculate the position for the Spike.  
					double xSpikePos = MathUtils.round(((radius) * (cosLat * sinLong)), 8);  
					double ySpikePos = MathUtils.round(((radius) * cosLong), 8);
					double zSpikePos = MathUtils.round(((radius) * (sinLat * sinLong)), 8); 
					
					System.out.println("StartPoint of AIDSVirus: " + xStartPos + "  " + yStartPos +  "  " +  zStartPos);
					System.out.println("StartPoint AIDSVirus Cylinder Center: " + xSpikePos + "  " + ySpikePos +  "  " +  zSpikePos);
			
					// Adjust to start postion
					xSpikePos += xStartPos;
					ySpikePos += yStartPos;
					zSpikePos += zStartPos;
									
					//**********************************************************
					// Creates a dendrite at a specific position
					//**********************************************************
					
			
				  	double dendriteRadius = 0.05;		
					double minRadius = 0.02;
					double orbitalRadius  = 0.025;
	
					BioMightPosition currentPos = bioMightTransform.getTranslation();
					double currentRadius = bioMightTransform.getRadius();
					
					BioMightPosition spikePos = new BioMightPosition(xSpikePos, ySpikePos, zSpikePos);
					bioMightTransform.setTranslation(spikePos);
					bioMightTransform.setRadius(dendriteRadius);
					bioMightTransform.setTextureID(6);
					bioMightTransform.setTextureFile("SpeckledRed.png");
					
					// Pass the instructions to the builder
					double[] taperPoint = {0.25, 0.50};
					double[] taperValue = {radius, radius/3};
					int minAppendages =  6;
					int maxAppendages = 6;
					
					System.out.println("Generating AIDSVirusSpike with Appendage Radius: " + dendriteRadius + "  orbital " + radius);
					minRadius = 0.02;
					double maxRadius = 0.25;
					
					// Create the 1st spike
					BioMightAppendage bioMightAppendage = new BioMightAppendage("GlycoProtein Spike", Constants.AIDSVirus, orbitalRadius, minRadius, maxRadius, dendriteRadius, taperPoint,
							taperValue, minAppendages, maxAppendages,
							angleLatitude, angleLongitude,0, 5, 0, 5, bioMightTransform.getTextureID(), bioMightTransform.getTextureFile());
					
					body += generateAppendage(bioMightAppendage, bioMightTransform);
					
					bioMightTransform.setTranslation(currentPos);
					bioMightTransform.setRadius(currentRadius);	
					
				
											
					// Set up a Group that assembles the flagellum
					body += "\n\n</Transform>\n\n";
					///System.out.println("\n\n CALLING ANIMATE: " + bioGroup);
					//body += animate(bioGroup, baseTransform, transformCount);
					//System.out.println("\n\n COMPLETED ANIMATE: " + bioGroup);
	
					}
					
		    		// Increase the angle on the arc that goes from left to right
		    		angleLatitude += rotateLatitude;
		    		//System.out.println("Incremented Latitude Angle: " + angleLatitude);
				}
			}
			
			// Increase the angle on the Arc that goes top to bottom
			angleLongitude += rotateLongitude;
			//System.out.println("Incremented Longtitude Angle: " + angleLatitude);
		}
	
		return (body);
	}
	
	/***********************************************************************************************************************
	 * GENERATE RETROVIRUS
	 * 
	 * This method creates the appendages that comprise a RetroVirus
	 * 
	 * Create the outer shell of the RetroVirus
	 * 
	 * @param bioMightTransform
	 * @param currentPoints
	 * @param bHeader
	 * @param bFooter
	 * @param diffColor
	 * @return
	 ***********************************************************************************************************************/
	 	
	public static String generateRetroVirus(BioMightTransform bioMightTransform,  BioMightRange bioRange) 	
	{	
		int numLongitude = 18;
		int numLatitude = 18;
		double rotateLatitude = 360/numLatitude;
		double rotateLongitude = 360/numLongitude;
		double angleLatitude = 0;
		double angleLongitude = rotateLongitude;
		
		double radius = bioMightTransform.getRadius();
				
		double xOrient = 0.0;
		double yOrient = 1.0;
		double zOrient = 0.0;
			
			
		String body = "";
		String bioGroup = "RetroVirusAppendageGroup";
		BioMightTransform baseTransform = bioMightTransform;
		int transformCount = 0;
		
		double xStartPos = bioMightTransform.getTranslation().getXPos();
		double yStartPos = bioMightTransform.getTranslation().getYPos();
		double zStartPos = bioMightTransform.getTranslation().getZPos();
		
		
		//System.out.println("GenerateReoVirus()  Num Longitude: " + numLongitude + "     NumLatitude: " + numLatitude);
		//System.out.println("GenerateReoVirus()  rotateLongitude: " + rotateLongitude + "   rotateLatitude: " + rotateLatitude);
		
		
		// Run from top of the sphere to the bottom (Longitude)
		for (int longitude=0; longitude<numLongitude/2; longitude++) 
		{
			// Run from left to right across the latitude separated points of the sphere
			angleLatitude = 0;
			//System.out.println("Completed Complete Rotation - Resetting Latitude");

			// Show only those within the longitude range.  The UI can pass in Lat/Long ranges
			// and these will be used to disperse the spikes according to the user's needs
			//if (longitude>=bioRange.getMinLongRange() && longitude<=bioRange.getMaxLongRange())
			if (longitude>=0)
			{
			
			for (int latitude=0; latitude<numLatitude; latitude++)
			{	
				// Reset for the next appendage
				radius = bioMightTransform.getRadius();
				xStartPos = bioMightTransform.getTranslation().getXPos();
				yStartPos = bioMightTransform.getTranslation().getYPos();
				zStartPos = bioMightTransform.getTranslation().getZPos();
				
			
				// Show only those within the latitude range
				//if (latitude>=bioRange.getMinLatRange() && latitude<=bioRange.getMaxLatRange())
				if (latitude >= 0)
				{
				
				System.out.println("Generating RetroVirusAppendage - angleLongitude: " + angleLongitude + "    angleLatitude: " + angleLatitude);
				// Set the position on the surface of the sphere based on angle of latitude
				// Set the position on the surace of the sphere based on the longitude
				
				// Set up a Group around the whole spike
				bioGroup = "RetroVirusGroup" + "L" + longitude + "L" + latitude;
				body += "\n<Transform DEF='" + bioGroup + "'\n";
				transformCount++;
				
				body += "  translation='" + bioMightTransform.getTranslation().getPositionStr() +  "'>\n\n";
						
				baseTransform = bioMightTransform;
				//body += "\n\n</Transform>\n\n";
		
				//********************************************************
				// Calculate the position of the initial spike
				//********************************************************
				
				// Convert the degrees to radians
				double radiansLatitude =  Math.toRadians(angleLatitude);
				double radiansLongitude =  Math.toRadians(angleLongitude);
				//System.out.println("Dendrite RadiansLatitude: " + radiansLatitude + " flagRadiansLongitude: " + radiansLongitude);

				// Calculate sine and cosine of the current longiture and latitude
				double cosLat = MathUtils.round(Math.cos(radiansLatitude), 8);
				double cosLong = MathUtils.round(Math.cos(radiansLongitude), 8);
				double sinLong = MathUtils.round(Math.sin(radiansLongitude), 8);
				double sinLat = MathUtils.round(Math.sin(radiansLatitude), 8);
		
				// Calculate the position for the Spike.  
				double xSpikePos = MathUtils.round(((radius) * (cosLat * sinLong)), 8);  
				double ySpikePos = MathUtils.round(((radius) * cosLong), 8);
				double zSpikePos = MathUtils.round(((radius) * (sinLat * sinLong)), 8); 
				
				System.out.println("StartPoint of Virus: " + xStartPos + "  " + yStartPos +  "  " +  zStartPos);
				System.out.println("StartPoint RetroVirus Cylinder Center: " + xSpikePos + "  " + ySpikePos +  "  " +  zSpikePos);
		
				// Adjust to start postion
				xSpikePos += xStartPos;
				ySpikePos += yStartPos;
				zSpikePos += zStartPos;
								
				//**********************************************************
				// Creates a dendrite at a specific position
				//**********************************************************
				
		
			  	double dendriteRadius = 0.05;		
				double minRadius = 0.02;
				double orbitalRadius  = 0.025;

				BioMightPosition currentPos = bioMightTransform.getTranslation();
				double currentRadius = bioMightTransform.getRadius();
				
				BioMightPosition spikePos = new BioMightPosition(xSpikePos, ySpikePos, zSpikePos);
				bioMightTransform.setTranslation(spikePos);
				bioMightTransform.setRadius(dendriteRadius);
				bioMightTransform.setTextureID(6);
				bioMightTransform.setTextureFile("SpeckledGreen.png");
				
				// Pass the instructions to the builder
				double[] taperPoint = {0.25, 0.50};
				double[] taperValue = {radius, radius/3};
				int minAppendages =  6;
				int maxAppendages = 6;
				
				System.out.println("Generating RetroVirusSpike with Appendage Radius: " + dendriteRadius + "  orbital " + radius);
				int growthPath = 3;
				minRadius = 0.02;
				double maxRadius = 0.25;
				
				// Create the 1st spike
				BioMightAppendage bioMightAppendage = new BioMightAppendage("GlycoProtein Spike", Constants.RetroVirus, orbitalRadius, minRadius, maxRadius, dendriteRadius, taperPoint,
						taperValue, minAppendages, maxAppendages,
						angleLatitude, angleLongitude, 0, 5, 0, 5, bioMightTransform.getTextureID(), bioMightTransform.getTextureFile());
				
				body += generateAppendage(bioMightAppendage, bioMightTransform);
				
				bioMightTransform.setTranslation(currentPos);
				bioMightTransform.setRadius(currentRadius);	
				
			
										
				// Set up a Group that assembles the flagellum
				body += "\n\n</Transform>\n\n";
				///System.out.println("\n\n CALLING ANIMATE: " + bioGroup);
				//body += animate(bioGroup, baseTransform, transformCount);
				//System.out.println("\n\n COMPLETED ANIMATE: " + bioGroup);

				}
				
	    		// Increase the angle on the arc that goes from left to right
	    		angleLatitude += rotateLatitude;
	    		//System.out.println("Incremented Latitude Angle: " + angleLatitude);
			}
			}
			
			// Increase the angle on the Arc that goes top to bottom
			angleLongitude += rotateLongitude;
			//System.out.println("Incremented Longtitude Angle: " + angleLatitude);
		}
	
		return (body);
	}
  	
	
	
	/***********************************************************************************************************************
	 * GENERATE ENTEROVIRUS
	 * 
	 * This method creates the appendages that comprise a RotaVirus
	 * 
	 * We need an algorithm that tells us where on the sphere to place appendage.   We need a routine that given the
	 * position and orientation can create an appendage at that location.
	 * 
	 * @param bioMightTransform
	 * @param currentPoints
	 * @param bHeader
	 * @param bFooter
	 * @param diffColor
	 * @return
	 ***********************************************************************************************************************/
	 	
	public static String generateEnteroVirus(BioMightTransform bioMightTransform,  BioMightRange bioRange) 	
	{	
		int numLongitude = 18;
		int numLatitude = 18;
		double rotateLatitude = 360/numLatitude;
		double rotateLongitude = 360/numLongitude;
		double angleLatitude = 0;
		double angleLongitude = rotateLongitude;
		
		double radius = bioMightTransform.getRadius();
				
		double xOrient = 0.0;
		double yOrient = 1.0;
		double zOrient = 0.0;
			
			
		String body = "";
		String bioGroup = "ReoVirusAppendageGroup";
		BioMightTransform baseTransform = bioMightTransform;
		int transformCount = 0;
		
		double xStartPos = bioMightTransform.getTranslation().getXPos();
		double yStartPos = bioMightTransform.getTranslation().getYPos();
		double zStartPos = bioMightTransform.getTranslation().getZPos();
		
		
		//System.out.println("GenerateReoVirus()  Num Longitude: " + numLongitude + "     NumLatitude: " + numLatitude);
		//System.out.println("GenerateReoVirus()  rotateLongitude: " + rotateLongitude + "   rotateLatitude: " + rotateLatitude);
		
		
		// Run from top of the sphere to the bottom (Longitude)
		for (int longitude=0; longitude<numLongitude/2; longitude++) 
		{
			// Run from left to right across the latitude separated points of the sphere
			angleLatitude = 0;
			//System.out.println("Completed Complete Rotation - Resetting Latitude");

			// Show only those within the longitude range.  The UI can pass in Lat/Long ranges
			// and these will be used to disperse the spikes according to the user's needs
			//if (longitude>=bioRange.getMinLongRange() && longitude<=bioRange.getMaxLongRange())
			if (longitude>=0)
			{
			
			for (int latitude=0; latitude<numLatitude; latitude++)
			{	
				// Reset for the next appendage
				radius = bioMightTransform.getRadius();
				xStartPos = bioMightTransform.getTranslation().getXPos();
				yStartPos = bioMightTransform.getTranslation().getYPos();
				zStartPos = bioMightTransform.getTranslation().getZPos();
				
			
				// Show only those within the latitude range
				//if (latitude>=bioRange.getMinLatRange() && latitude<=bioRange.getMaxLatRange())
				if (latitude >= 0)
				{
				
				System.out.println("Generating ReoVirusAppendage - angleLongitude: " + angleLongitude + "    angleLatitude: " + angleLatitude);
				// Set the position on the surface of the sphere based on angle of latitude
				// Set the position on the surace of the sphere based on the longitude
				
				// Set up a Group around the whole spike
				bioGroup = "ReoVirusGroup" + "L" + longitude + "L" + latitude;
				body += "\n<Transform DEF='" + bioGroup + "'\n";
				transformCount++;
				
				body += "  translation='" + bioMightTransform.getTranslation().getPositionStr() +  "'>\n\n";
						
				baseTransform = bioMightTransform;
				//body += "\n\n</Transform>\n\n";
		
				//********************************************************
				// Calculate the position of the initial spike
				//********************************************************
				
				// Convert the degrees to radians
				double radiansLatitude =  Math.toRadians(angleLatitude);
				double radiansLongitude =  Math.toRadians(angleLongitude);
				//System.out.println("Dendrite RadiansLatitude: " + radiansLatitude + " flagRadiansLongitude: " + radiansLongitude);

				// Calculate sine and cosine of the current longiture and latitude
				double cosLat = MathUtils.round(Math.cos(radiansLatitude), 8);
				double cosLong = MathUtils.round(Math.cos(radiansLongitude), 8);
				double sinLong = MathUtils.round(Math.sin(radiansLongitude), 8);
				double sinLat = MathUtils.round(Math.sin(radiansLatitude), 8);
		
				// Calculate the position for the Spike.  
				double xSpikePos = MathUtils.round(((radius) * (cosLat * sinLong)), 8);  
				double ySpikePos = MathUtils.round(((radius) * cosLong), 8);
				double zSpikePos = MathUtils.round(((radius) * (sinLat * sinLong)), 8); 
				
				System.out.println("StartPoint of Virus: " + xStartPos + "  " + yStartPos +  "  " +  zStartPos);
				System.out.println("StartPoint ReoVirus Cylinder Center: " + xSpikePos + "  " + ySpikePos +  "  " +  zSpikePos);
		
				// Adjust to start postion
				xSpikePos += xStartPos;
				ySpikePos += yStartPos;
				zSpikePos += zStartPos;
								
				//**********************************************************
				// Creates a dendrite at a specific position
				//**********************************************************
				
				// Create 6 sections around the center
				if ( ((latitude % 3 == 0) && (longitude == 3))  ||
					 ((latitude % 6 == 0) && (longitude == 5))  ||
					 ((latitude % 6 == 0) && (longitude == 1)) )
				{
				  	double dendriteRadius = 0.075;		
					double minRadius = 0.02;
					double orbitalRadius  = 0.05;
	
					BioMightPosition currentPos = bioMightTransform.getTranslation();
					double currentRadius = bioMightTransform.getRadius();
					
					BioMightPosition spikePos = new BioMightPosition(xSpikePos, ySpikePos, zSpikePos);
					bioMightTransform.setTranslation(spikePos);
					bioMightTransform.setRadius(dendriteRadius);
					bioMightTransform.setTextureID(6);
					bioMightTransform.setTextureFile("StaphylococcusAureus.png");
					
					// Pass the instructions to the builder
					double[] taperPoint = {0.25, 0.50};
					double[] taperValue = {radius, radius/3};
					int minAppendages =  4;
					int maxAppendages = 6;
					
					System.out.println("Generating ReoVirusSpike with Appendage Radius: " + dendriteRadius + "  orbital " + radius);
					int growthPath = 2;
					minRadius = 0.02;
					double maxRadius = 0.25;
					
					// Create the 1st spike
					BioMightAppendage bioMightAppendage = new BioMightAppendage("GlycoProtein Spike", Constants.ReoVirus, orbitalRadius, minRadius, maxRadius, dendriteRadius, taperPoint,
							taperValue, minAppendages, maxAppendages,
							angleLatitude, angleLongitude, 0, 5, 0, 5, bioMightTransform.getTextureID(), bioMightTransform.getTextureFile());
					
					body += generateAppendage(bioMightAppendage, bioMightTransform);	
					
					// Create the 2nd spike
					bioMightAppendage = new BioMightAppendage("GlycoProtein Spike", Constants.ReoVirus, orbitalRadius, minRadius, maxRadius, dendriteRadius, taperPoint,
							taperValue, minAppendages, maxAppendages,
							angleLatitude+30, angleLongitude+30, 0, 5, 0, 5, bioMightTransform.getTextureID(), bioMightTransform.getTextureFile());
					
					body += generateAppendage(bioMightAppendage, bioMightTransform);	
	
					// Create the 3rd Spike
					bioMightAppendage = new BioMightAppendage("GlycoProtein Spike", Constants.ReoVirus, orbitalRadius, minRadius, maxRadius, dendriteRadius, taperPoint,
							taperValue, minAppendages, maxAppendages,
							angleLatitude-30, angleLongitude+30, 0, 5, 0, 5, bioMightTransform.getTextureID(), bioMightTransform.getTextureFile());
					
					body += generateAppendage(bioMightAppendage, bioMightTransform);	
					
					
					// Create the 4th Spike
					bioMightAppendage = new BioMightAppendage("GlycoProtein Spike", Constants.ReoVirus, orbitalRadius, minRadius, maxRadius, dendriteRadius, taperPoint,
							taperValue, minAppendages, maxAppendages,
							angleLatitude-30, angleLongitude-30, 0, 5, 0, 5, bioMightTransform.getTextureID(), bioMightTransform.getTextureFile());
					
					body += generateAppendage(bioMightAppendage, bioMightTransform);	
		
					
					// Create the 5th Spike
					bioMightAppendage = new BioMightAppendage("GlycoProtein Spike", Constants.ReoVirus, orbitalRadius, minRadius, maxRadius, dendriteRadius, taperPoint,
							taperValue, minAppendages, maxAppendages,
							angleLatitude+30, angleLongitude-30, 0, 5, 0, 5, bioMightTransform.getTextureID(), bioMightTransform.getTextureFile());
					
					body += generateAppendage(bioMightAppendage, bioMightTransform);
					
					bioMightTransform.setTranslation(currentPos);
					bioMightTransform.setRadius(currentRadius);
				}
				else
				{
				  	double dendriteRadius = 0.05;		
					double minRadius = 0.02;
					double orbitalRadius  = 0.025;
	
					BioMightPosition currentPos = bioMightTransform.getTranslation();
					double currentRadius = bioMightTransform.getRadius();
					
					BioMightPosition spikePos = new BioMightPosition(xSpikePos, ySpikePos, zSpikePos);
					bioMightTransform.setTranslation(spikePos);
					bioMightTransform.setRadius(dendriteRadius);
					bioMightTransform.setTextureID(6);
					bioMightTransform.setTextureFile("SpeckledGreen.png");
					
					// Pass the instructions to the builder
					double[] taperPoint = {0.25, 0.50};
					double[] taperValue = {radius, radius/3};
					int minAppendages =  2;
					int maxAppendages = 3;
					
					System.out.println("Generating ReoVirusSpike with Appendage Radius: " + dendriteRadius + "  orbital " + radius);
					int growthPath = 2;
					minRadius = 0.02;
					double maxRadius = 0.25;
					
					// Create the 1st spike
					BioMightAppendage bioMightAppendage = new BioMightAppendage("GlycoProtein Spike", Constants.ReoVirus, orbitalRadius, minRadius, maxRadius, dendriteRadius, taperPoint,
							taperValue, minAppendages, maxAppendages,
							angleLatitude, angleLongitude, 0, 5, 0, 5, bioMightTransform.getTextureID(), bioMightTransform.getTextureFile());
					
					body += generateAppendage(bioMightAppendage, bioMightTransform);
					
					bioMightTransform.setTranslation(currentPos);
					bioMightTransform.setRadius(currentRadius);	
					
				}
										
				// Set up a Group that assembles the flagellum
				body += "\n\n</Transform>\n\n";
				///System.out.println("\n\n CALLING ANIMATE: " + bioGroup);
				//body += animate(bioGroup, baseTransform, transformCount);
				//System.out.println("\n\n COMPLETED ANIMATE: " + bioGroup);

				}
				
	    		// Increase the angle on the arc that goes from left to right
	    		angleLatitude += rotateLatitude;
	    		//System.out.println("Incremented Latitude Angle: " + angleLatitude);
			}
			}
			
			// Increase the angle on the Arc that goes top to bottom
			angleLongitude += rotateLongitude;
			//System.out.println("Incremented Longtitude Angle: " + angleLatitude);
		}
	
		return (body);
	}
	
	/***********************************************************************************************************************
	 * GENERATE APPENDAGE
	 * 
	 * This method creates an Appendages based on a position and orientation.   It uses the parent object 
	 * stored in the BioMightAppedage object to determine how to create the particular appendage
	 * 
	 * int
	 * @param bioMightTransform
	 * @param currentPoints
	 * @param bHeader
	 * @param bFooter
	 * @param diffColor
	 * @return
	 ***********************************************************************************************************************/
	 	
	public static String generateAppendage(BioMightAppendage bioMightAppendage, BioMightTransform bioMightTransform) 	
	{	
		int spikeNum = 1;
		double orbitalRadius = bioMightAppendage.getOrbitalRadius();
	  	double dendriteRadius = bioMightAppendage.getRadius();
	  	double angleLatitude = bioMightAppendage.getLatitude();
	  	double angleLongitude = bioMightAppendage.getLongitude();	
	  	
	  	int angleLatitudeMinDev = bioMightAppendage.getAngleLatitudeMinDev();
	  	int angleLatitudeMaxDev = bioMightAppendage.getAngleLatitudeMaxDev();
	  	int angleLongitudeMinDev = bioMightAppendage.getAngleLongitudeMinDev();	
	  	int angleLongitudeMaxDev = bioMightAppendage.getAngleLongitudeMaxDev();	
	  	
		double radiansLatitude =  Math.toRadians(angleLatitude);
		double radiansLongitude =  Math.toRadians(angleLongitude);
		//System.out.println("generateAppendage - angleLongitude: " + angleLongitude + "    angleLatitude: " + angleLatitude + "  Oradius: " + + orbitalRadius);
				
		double xOrient = 0.0;
		double yOrient = 1.0;
		double zOrient = 0.0;
			
		String body = "";
		String bioGroup = "AppendageGroup";

		double xStartPos = bioMightTransform.getTranslation().getXPos();
		double yStartPos = bioMightTransform.getTranslation().getYPos();
		double zStartPos = bioMightTransform.getTranslation().getZPos();
		
		// Set the position on the surface of the sphere based on angle of latitude
		// Set the position on the surace of the sphere based on the longitude
		
		// Set up a Group around the whole spike
		bioGroup = "AppendageGroup" + "L" + angleLatitude + "L" + angleLongitude;
		body += "\n<Transform DEF='" + bioGroup + "'\n";
		
		body += "  translation='0 0 0'>\n";

		//body +=  "rotation='" 
		// 		+ bioMightTransform.getOrientation().getXAxis() + " "
		//		+ bioMightTransform.getOrientation().getYAxis() + " "
		//		+ bioMightTransform.getOrientation().getZAxis()  + " "
		//		+ bioMightTransform.getOrientation().getDegrees() + "'>\n\n";
		
		//body += "\n\n</Transform>\n\n";
	
		// Convert the degrees to radians
		//double radiansLatitude =  Math.toRadians(angleLatitude);
		//double radiansLongitude =  Math.toRadians(angleLongitude);
		//System.out.println("Dendrite RadiansLatitude: " + radiansLatitude + " flagRadiansLongitude: " + radiansLongitude);

		
		// *******************************************
		// Create the starting Cylinder of points
		//********************************************

	  	double[] basePosition = {xStartPos, yStartPos, zStartPos};
	  	double[] tempTranslate = {0, 0, 0};
	  	
	  	double orientation[] = {-angleLongitude, -angleLatitude};
		double[][] currentPoints = createCylinderInPlane(orientation,  basePosition, dendriteRadius, 8);
		//System.out.println("Create 1st Appendage Segment using radius: " + dendriteRadius + "   orbitalRadius: " + orbitalRadius);
		
		// Generate a random length for the Dendritic Spike
		// based on the information set up in the appendage object
		int randoLength = bioMightAppendage.getMinAppendages() + (int)(Math.random() * ((bioMightAppendage.getMaxAppendages() - bioMightAppendage.getMinAppendages()) + 1));
		//System.out.println("Random Appendage Length: " + randoLength);
	
		//**********************************************************
		// Run through the sections and create the Dendrite Arm
		// Run through the segments that make this collection of fragments
		//**********************************************************
		int runCount = 0;
		
		// Set up the Angle for growth path
		double randomRotateAngleLat  = 0;
		double randomRotateAngleLong = 0;
		double oneThird = MathUtils.round(randoLength/3, 3);
		
		for (int v=0; v<randoLength; v++) {
			
			// NEURON DENDRITE - Growth Path 0
			if (v > oneThird && runCount>=3  && bioMightAppendage.getParent().equals(Constants.Neuron)) {			
				
				randomRotateAngleLat = angleLatitudeMinDev + (int)(Math.random() * ((angleLatitudeMaxDev - angleLatitudeMinDev) + 1));
				randomRotateAngleLong = angleLongitudeMinDev + (int)(Math.random() * ((angleLongitudeMaxDev - angleLongitudeMinDev) + 1));
				//System.out.println("GrowthPath0 - RandomRotate at v: " + v + "  Angles: " + randomRotateAngleLat + "   " + randomRotateAngleLong);
					
				// As Random generates a number between 0 and 1
				// We will no be getting a negative angle to work with.
				// This will even it out.
		
				double negativeOrPositive = Math.random();
				if (negativeOrPositive >= 0.50)
					randomRotateAngleLong =  randomRotateAngleLong * -1;
			
			
				runCount = 0;
				//System.out.println("Setting RandomRotate at v: " + v + "  Angles: " + randomRotateAngleLat + "   " + randomRotateAngleLong);
			}
			// POXVIRUS - GROWTH PATH 1
			else if (runCount>=1  && bioMightAppendage.getParent().equals(Constants.PoxVirus)) {	
					
				randomRotateAngleLat = angleLatitudeMinDev + (int)(Math.random() * ((angleLatitudeMaxDev - angleLatitudeMinDev) + 1));
				randomRotateAngleLong = angleLongitudeMinDev + (int)(Math.random() * ((angleLongitudeMaxDev - angleLongitudeMinDev) + 1));		
				//System.out.println("Generating RandomRotate at v: " + v + "  Angles: " + randomRotateAngleLat + "   " + randomRotateAngleLong);
		
				runCount = 0;
			}
			else if ((bioMightAppendage.getParent().equals(Constants.ReoVirus)) ||  
				(bioMightAppendage.getParent().equals(Constants.CoreMembrane)) ||
				(bioMightAppendage.getParent().equals(Constants.RotaVirus)) ||
				(bioMightAppendage.getParent().equals(Constants.NoroVirus)) ||
				(bioMightAppendage.getParent().equals(Constants.AIDSVirus))) 
			{	
				randomRotateAngleLat = angleLatitudeMinDev + (int)(Math.random() * ((angleLatitudeMaxDev - angleLatitudeMinDev) + 1));
				randomRotateAngleLong = angleLongitudeMinDev + (int)(Math.random() * ((angleLongitudeMaxDev - angleLongitudeMinDev) + 1));		
				//System.out.println("GrowthPath: " + bioMightAppendage.getParent() +
				//		           " - RandomRotate at v: " + v + "  Angles: " + randomRotateAngleLat + "   " + randomRotateAngleLong);
					
				// As Random generates a number between 0 and 1
				// We will no be getting a negative angle to work with.
				// This will even it out.
			
				double negativeOrPositive = Math.random();
				if (negativeOrPositive >= 0.50)
					randomRotateAngleLong =  randomRotateAngleLong * -1;
				
				runCount = 0;
				//System.out.println("Setting RandomRotate at v: " + v + "  Angles: " + randomRotateAngleLat + "   " + randomRotateAngleLong);
			}			
			//else
				//System.out.println("Keeping RandomRotate runCount:  " + runCount + "   v: " + v + "  Angles: " + randomRotateAngleLat + "   " + randomRotateAngleLong);
					
			runCount++;
				
			// Convert the degrees to radians
			// Apply a deviation to the latitutde and longitude so that it varies by a little
			// HAVE TO CALCULATE
		
			//System.out.println("generateAppendageBefore - angleLongitude: " + angleLongitude + "    angleLatitude: " + angleLatitude);
			
			radiansLatitude =  Math.toRadians(angleLatitude + randomRotateAngleLat);
			radiansLongitude =  Math.toRadians(angleLongitude + randomRotateAngleLong);
			//System.out.println("Appendage Divertage - AngleLatitude: " + randomRotateAngleLat + " AngleLongitude: " + randomRotateAngleLong);

			// Calculate sine and cosine of the new Angles
			double cosLat = MathUtils.round(Math.cos(radiansLatitude), 8);
			double cosLong = MathUtils.round(Math.cos(radiansLongitude), 8);
			double sinLong = MathUtils.round(Math.sin(radiansLongitude), 8);
			double sinLat = MathUtils.round(Math.sin(radiansLatitude), 8);
			
			// Set the position for the Dendrite.  Make it sit on the outside of the membrane
			double xPos = MathUtils.round(((orbitalRadius) * (cosLat * sinLong)), 8);  
			double yPos = MathUtils.round(((orbitalRadius) * cosLong), 8);
			double zPos = MathUtils.round(((orbitalRadius) * (sinLat * sinLong)), 8); 

			// Translate to where its specified start position is
			xPos += xStartPos;
			yPos += yStartPos;
			zPos += zStartPos;
	
			// Update the start position
			xStartPos = xPos;
			yStartPos = yPos;
			zStartPos = zPos;
		
			//System.out.println("Cos(Lat): " + cosLat + " Sin(Lat): " + sinLat + "            Sin(Long): " + sinLong + "  cos(Long): " + cosLong);
			//System.out.print   ln("XPOS: " + xPos + "=  Cos(Lat): " + cosLat + " Sin(Long): " + sinLong);
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

			// Adjust the radius smaller and smaller as we go
			// Divide the number of sections by the distance and
			// Determine how much we need to decrease the diameter/radius

			boolean bAppendageClose = true;
			if (bioMightAppendage.getParent().equals(Constants.Neuron))
			{
				double decreaseRate = 0.0;
		
				if (v <= oneThird) {
					decreaseRate = 0.0125;
					dendriteRadius -= decreaseRate;
					System.out.println("AppendageRadius at 1/3: " + v +  "  dendriteRadius: " + dendriteRadius);	
				}
				else if (v > oneThird && v <= 2 * oneThird) {
					decreaseRate = 0.00625;
					dendriteRadius = 0.02;
					dendriteRadius = 0.0125;
					
					System.out.println("AppendageRadius at 1/3 to 2/3: " + v +  "  radius: " + dendriteRadius)	;
				}
				else
				{
					decreaseRate = 0.00625;
					dendriteRadius -= decreaseRate;
					System.out.println("AppendageRadius at > 2/3: " +  + v +  "  radius:  " + dendriteRadius);
				}
				
			}
			else if (bioMightAppendage.getParent().equals(Constants.PoxVirus))
			{
					double decreaseRate = 0.0;
				
			}
			else if (bioMightAppendage.getParent().equals(Constants.CoreMembrane))
			{
					double decreaseRate = 0.0;
					bAppendageClose = false;
				
			}
			else if (bioMightAppendage.getParent().equals(Constants.ReoVirus))
			{
					double decreaseRate = 0.0;
				
			}
			else if (bioMightAppendage.getParent().equals(Constants.RetroVirus))
			{
					double decreaseRate = 0.0;
					if (v==2)
						dendriteRadius = dendriteRadius+0.0125;
					if (v==3)
						dendriteRadius = dendriteRadius+0.001;
					if (v==4)
						dendriteRadius = dendriteRadius-0.0126;
					if (v==5)
						dendriteRadius = 0.0005;
			}
			else if (bioMightAppendage.getParent().equals(Constants.AIDSVirus))
			{
					double decreaseRate = 0.0;
					if (v==2)
						dendriteRadius = dendriteRadius+0.015;
					if (v==3)
						dendriteRadius = dendriteRadius+0.002;
					if (v==4){
						dendriteRadius = dendriteRadius-0.015;
						orbitalRadius = orbitalRadius/10;
					}
					if (v==5)
					{
						dendriteRadius = 0.0005;
					
					}	
			}
			
			
			// Do not get smaller than the minimum defined radius
			if (dendriteRadius < bioMightAppendage.getMinRadius())
				dendriteRadius = bioMightAppendage.getMinRadius();
			
			//System.out.println("Appendage OrbitalRadius: " + orbitalRadius + "  DendriteRadius: " + dendriteRadius);
			double[] spikePosition = {xPos, yPos, zPos};
			
			if (randomRotateAngleLong > 30) {
				orientation[0] = (-angleLongitude-(randomRotateAngleLong/2));
				//System.out.println("Appendage Rotate >30 : " + randomRotateAngleLong + "     Longitude: " + angleLongitude + "   Combined: " +orientation[0]);
			}
			
			double[][] nextPoints;
			if (v == randoLength-1)
			{
				// On the last segment, close it
				if (bAppendageClose)
					nextPoints = createCylinderInPlane(orientation, spikePosition, dendriteRadius/100, 8);
				else
					nextPoints = createCylinderInPlane(orientation, spikePosition, dendriteRadius, 8);
				
				//double[] scaleNext = {1, 1, 1}; 
				//nextPoints = BioGraphics.applyScale(nextPoints, tempTranslate, scaleNext);
			}
			else
			{
				nextPoints = createCylinderInPlane(orientation, spikePosition, dendriteRadius, 8);
				//double[] scaleNext = {1, 1, 1}; 
				//nextPoints = BioGraphics.applyScale(nextPoints, tempTranslate, scaleNext);
			}
			
			//****************************************
			//  Connect the current and next points
			//****************************************
			// Now that the points are generated, create the sides
			// If we are creating an octogon, that would be 4 sides
			String topRowVertices = "";
			String bottomRowVertices = "";

			int numPoints = nextPoints.length;
			for (int point=0; point<numPoints; point++)
			{					
				// Set up the vertices for the current and next points
				/// build the top row
				if (point==0)
					topRowVertices = "\n" + currentPoints[point][0]  + ", " +  currentPoints[point][1] + ", " + currentPoints[point][2];
				else
					topRowVertices += ",\n  " + currentPoints[point][0]  + ",  " +  currentPoints[point][1] + ",  " + currentPoints[point][2];		
		
				// Buid the bottom row
				if (point==0)
					bottomRowVertices = "\n" + nextPoints[point][0]  + ", " +  nextPoints[point][1] + ", " + nextPoints[point][2];
				else
					bottomRowVertices += ",\n  " + nextPoints[point][0]  + ",  " +  nextPoints[point][1] + ",  " + nextPoints[point][2];		
	
			}
				
			String vertices = topRowVertices + "," + bottomRowVertices;
			//System.out.println("COORDS are: " + vertices);
	

			// Now connect the points together
			String tempIndexStr = "";
			for (int point=0; point<numPoints; point++)
			{
				
				if (point==0)
				{	
					tempIndexStr = " " +  
							(point+1)     			+ "  " +
							 point 			+ "  " +
							(point+numPoints) 	+ "  " +
							(point+numPoints+1) + "  -1";
				}	
				else if (point==(numPoints-1))
				{	
					tempIndexStr += ", " +  
							0    			+ "  " +
							(numPoints-1) + "  " +
							(2*numPoints-1) 	+ "  " +
							numPoints + "  -1";
				}
				else
				{	
					tempIndexStr += ", " +  
							(point+1) 		+ "  " +
							 point 			+ "  " +
							(point+numPoints) + "  " +
							(point+numPoints+1) + "  -1";
				}
			}
			
			//System.out.println("********* Index is: " + tempIndexStr);	

	
			String componentType = "Section_" + v;
			body += "<Transform  onmouseover=\"showComponent('" + bioMightAppendage.getComponentName() +  "');\"  DEF='" + componentType + "'\n";
			
			//body += "translation='" 
			//+ xStartPos + " " 
			//+ yStartPos + " "
			//+ zStartPos + "'\n";					
			
			body+= "scale='" 	
			+ bioMightTransform.getScale().getXPos()  + " "
			+ bioMightTransform.getScale().getYPos() + " "
			+ bioMightTransform.getScale().getZPos()  + "'>\n" +
			"<Shape DEF='" + componentType + "'\n" +
			
			" containerField='children'>\n" +
			" <Appearance\n" +
			"  containerField='appearance'>\n";
			
			//bioMightTransform.setCoordpoint(Constants.TRIANGLE, coordinateString, 0.025, 0);
			//bioMightTransform.setCoordIndex(tempInd);

			/*****
			if (bioMightTransform.getTextureID() > 0) {
				body+= " <ImageTexture containerField='texture' url='../images/" +
	    			 bioMightTransform.getTextureFile() +  "' />";
				}
			else
			{
				body+= " <ImageTexture containerField='texture' " +
						" url='../images/StaphylococcusAureus.png'/>";
			}
			*********/
			
			if (bioMightAppendage.getTextureID() > 0) {
				body+= " <ImageTexture containerField='texture' url='../images/" +
						bioMightAppendage.getTextureFile() +  "' />";
				//System.out.println("Appendage - Using TextureFile ------ : " + vertices);
				}
			else
			{
				body+= " <ImageTexture containerField='texture' " +
						" url='../images/StaphylococcusAureus.png'/>";
			}
			
			
			body+= " <Material DEF='Rust'\n" +
			"containerField='material'\n" +
			"ambientIntensity='" + bioMightTransform.getMaterial().getAmbientIntensity() + "'\n" +
			"shininess='" 		 + bioMightTransform.getMaterial().getShininess() + "'\n" +
			"transparency='" 	 + 0.0 + "'\n" +
			"diffuseColor='" + 
			0.0 + " " + 
			0.20 + " " +
			0.40 + "'/>\n" +
			"</Appearance>\n" +
			
			
			"<IndexedFaceSet DEF='EndoArcIFS' \n" +
			"containerField='geometry' \n" +
			"solid='false' \n" +
			"creaseAngle='" +  bioMightTransform.getCreaseAngle() + "'\n" +
			"coordIndex='" + tempIndexStr + "'>" +
			"<Coordinate DEF='Endo_Coord' \n" + 
			"containerField='coord' point='" + vertices + "'/>\n" +
			"</IndexedFaceSet>\n" +
			"</Shape>\n" +
			
			"<TouchSensor DEF='StartEndothelium' \n" +
			" description='" + componentType + "'\n" +
			" containerField='children'/> \n" +
			
			"</Transform>\n"; 
			
	
			// Store the prior set of points
			for (int l=0; l<nextPoints.length; l++)
			{
				currentPoints[l][0] = nextPoints[l][0]; 
				currentPoints[l][1] = nextPoints[l][1]; 
				currentPoints[l][2] = nextPoints[l][2]; 
			}
					
		}
			
				
		// Set up a Group that assembles the flagellum
		body += "\n\n</Transform>\n\n";
		///System.out.println("\n\n CALLING ANIMATE: " + bioGroup);
		//body += animate(bioGroup, baseTransform, transformCount);
		//System.out.println("\n\n COMPLETED ANIMATE: " + bioGroup);				
	    	
		return (body);
	}
  	
	
 	/***********************************************************************************************************************
  	 * GENERATE ANTIGEN
  	 * 
  	 * Creates an Antigen
  	 * 
  	 * @param bioMightTransform
  	 * @param currentPoints
  	 * @param bHeader
  	 * @param bFooter
  	 * @param diffColor
  	 * @return
  	 * 
  	 ***********************************************************************************************************************/
	
  	public static String generateAntigen(BioMightTransform bioMightTransform,  BioMightPosition startPos, BioMightOrientation bioMightOrientation) 	
	{		
	  	String body = "";			
		double xStartPos = startPos.getXPos(); 
		double yStartPos = startPos.getYPos(); 
		double zStartPos = startPos.getZPos();
		//System.out.println("\nGenerateAntigen() at Start Position: ");
			

		//***********************************************
		// Create the first lobe
	  	//***********************************************
	  	double[] nukStartPos = {xStartPos, yStartPos, zStartPos};
	  	double radius = 0.000625;
		double[][] nuclueiPoints = BioGraphics.createCylinderInPlane(Constants.YPLANE, nukStartPos, radius, 8);
		

		// Move the point around, and connect it, creating a wall of 
		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstructSet = new BioMightInstructSet();
		
		int numInstructions = 4;
		//BioMightOrientation bioMightOrientation = new BioMightOrientation(0.0, 0.0, 1.0, 90);
		for (int instructCount=0; instructCount<numInstructions; instructCount++)
		{
			// Create a place for an instruction 
			BioMightInstruction bioInstruct = new BioMightInstruction();
	
			// Place a transform object into each instruction set
			// Use the same one when homogenous
			bioInstruct.setBioMightTransform(bioMightTransform);
			
			
			bioMightTransform = new BioMightTransform();
			bioMightTransform.setTextureID(5);
			bioMightTransform.setTextureFile("SpeckledGreen.png");
			bioMightTransform.setComponentName("Nucleus");
			
			// Place a transform object into each instruction set
			bioInstruct.setBioMightTransform(bioMightTransform);
			
			if (instructCount==0){		
				//BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, -90);
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(2, 2, 2);
				bioInstruct.setTranslateMatrix(0.0, -0.0002, 0.0);      
			}
			else if (instructCount==1){
				bioInstruct.setTransType(Constants.TRANSLATE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.0, -0.006125, 0.00);
			}
			else if (instructCount==2){
				bioInstruct.setTransType(Constants.TRANSLATE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.0, -0.006125, 0.00);   
			}				
			else if (instructCount==3){
				bioInstruct.setTransType(Constants.TRANSLATE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.0, -0.006125, 0.0);      
			}
			else {
				bioInstruct.setTransType(Constants.TRANSLATE);
				BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, 90);
				bioInstruct.setOrientation(orientationUpd);
				bioInstruct.setTranslateMatrix(0.0, -0.05, 0.0);       
			}
	
			// Add the instruction into the instruction set
    		bioMightInstructSet.addElement(bioInstruct);
		}	
				
		// Pass the instructions to the builder
		// These data points will need to be stored in the database and be modifiable
		// based on user inputs
		body += generateIndexFacedComponents(bioMightOrientation, bioMightInstructSet, nuclueiPoints); 	
		
		return (body);		
		
	}
  	
	/***********************************************************************************************************************
  	 * GENERATE ANTIBODY
  	 * 
  	 * Creates an Antibody
  	 * 
  	 * @param bioMightTransform
  	 * @param currentPoints
  	 * @param bHeader
  	 * @param bFooter
  	 * @param diffColor
  	 * @return
  	 * 
  	 ***********************************************************************************************************************/
	
  	public static String generateAntibody(BioMightTransform bioMightTransform,  BioMightPosition startPos, BioMightOrientation bioMightOrientation) 	
	{		
	  	String body = "";			
		double xStartPos = startPos.getXPos(); 
		double yStartPos = startPos.getYPos(); 
		double zStartPos = startPos.getZPos();
		//System.out.println("\nGenerateAntigen() at Start Position: ");
			

		//***********************************************
		// Create the first lobe
	  	//***********************************************
	  	double[] nukStartPos = {xStartPos, yStartPos, zStartPos};
	  	double radius = 0.000625;
		double[][] nuclueiPoints = BioGraphics.createCylinderInPlane(Constants.YPLANE, nukStartPos, radius, 8);
		

		// Move the point around, and connect it, creating a wall of 
		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstructSet = new BioMightInstructSet();
		
		int numInstructions = 4;
		//BioMightOrientation bioMightOrientation = new BioMightOrientation(0.0, 0.0, 1.0, 90);
		for (int instructCount=0; instructCount<numInstructions; instructCount++)
		{
			// Create a place for an instruction 
			BioMightInstruction bioInstruct = new BioMightInstruction();
	
			// Place a transform object into each instruction set
			// Use the same one when homogenous
			bioInstruct.setBioMightTransform(bioMightTransform);
			
			
			bioMightTransform = new BioMightTransform();
			bioMightTransform.setTextureID(5);
			bioMightTransform.setTextureFile("SpeckledGreen.png");
			bioMightTransform.setComponentName("Nucleus");
			
			// Place a transform object into each instruction set
			bioInstruct.setBioMightTransform(bioMightTransform);
			
			if (instructCount==0){		
				//BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, -90);
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(2, 2, 2);
				bioInstruct.setTranslateMatrix(0.0, -0.0002, 0.0);      
			}
			else if (instructCount==1){
				bioInstruct.setTransType(Constants.TRANSLATE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.0, -0.006125, 0.00);
			}
			else if (instructCount==2){
				bioInstruct.setTransType(Constants.TRANSLATE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.0, -0.006125, 0.00);   
			}				
			else if (instructCount==3){
				bioInstruct.setTransType(Constants.TRANSLATE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.0, -0.006125, 0.0);      
			}
			else {
				bioInstruct.setTransType(Constants.TRANSLATE);
				BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, 90);
				bioInstruct.setOrientation(orientationUpd);
				bioInstruct.setTranslateMatrix(0.0, -0.05, 0.0);       
			}
	
			// Add the instruction into the instruction set
    		bioMightInstructSet.addElement(bioInstruct);
		}	
				
		// Pass the instructions to the builder
		// These data points will need to be stored in the database and be modifiable
		// based on user inputs
		body += generateIndexFacedComponents(bioMightOrientation, bioMightInstructSet, nuclueiPoints); 	

	
		//***********************************************
		//
		// Create the first Y-Split
		//
	  	//***********************************************
	
		yStartPos -= 0.0175;
		double[] split1StartPos = {xStartPos, yStartPos, zStartPos};
	  	radius = 0.00120;
		double[][] split1Points = BioGraphics.createCylinderInPlane(Constants.YPLANE, split1StartPos, radius, 8);
	
		
		// Move the point around, and connect it, creating a wall of 
		// Allocate an instruction set for building it
		bioMightInstructSet = new BioMightInstructSet();
		
		numInstructions = 2;
		//BioMightOrientation bioMightOrientation = new BioMightOrientation(0.0, 0.0, 1.0, 90);
		for (int instructCount=0; instructCount<numInstructions; instructCount++)
		{
			// Create a place for an instruction 
			BioMightInstruction bioInstruct = new BioMightInstruction();
	
			// Place a transform object into each instruction set
			// Use the same one when homogenous
			bioInstruct.setBioMightTransform(bioMightTransform);
			
			
			bioMightTransform = new BioMightTransform();
			bioMightTransform.setTextureID(5);
			bioMightTransform.setTextureFile("SpeckledGreen.png");
			bioMightTransform.setComponentName("Nucleus");
			
			// Place a transform object into each instruction set
			bioInstruct.setBioMightTransform(bioMightTransform);
			
			if (instructCount==0){		
				bioInstruct.setTransType(Constants.ROTATEOCTO);
				bioInstruct.setTranslateMatrix(0.0, 0.0, 0.00);
				BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, 90);
				bioInstruct.setOrientation(orientationUpd);	
				bioInstruct.setPivotPoint(0);
				//bioInstruct.setTheta(30.0);
				BioMightOrientation rotationUpd = new BioMightOrientation(0.0, 0.0, 1.0, 0.0);
				bioInstruct.setRotation(rotationUpd);	        
			}
			else if (instructCount==1){
				bioInstruct.setTransType(Constants.TRANSLATE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.00825, -0.00825, 0.00);
			}
			else if (instructCount==2){
				bioInstruct.setTransType(Constants.TRANSLATE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.00825, -0.00825, 0.00);   
			}				
			else {
				bioInstruct.setTransType(Constants.TRANSLATE);
				BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, 90);
				bioInstruct.setOrientation(orientationUpd);
				bioInstruct.setTranslateMatrix(0.0, -0.05, 0.0);       
			}
	
			// Add the instruction into the instruction set
    		bioMightInstructSet.addElement(bioInstruct);
		}	
				
		// Pass the instructions to the builder
		// These data points will need to be stored in the database and be modifiable
		// based on user inputs
		body += generateIndexFacedComponents(bioMightOrientation, bioMightInstructSet, split1Points); 	
		
		
		
		//***********************************************
		//
		// Create the second Y-Split
		//
	  	//***********************************************
	  	double[] split2StartPos = {xStartPos, yStartPos, zStartPos};
	 	radius = 0.00120;
		double[][] split2Points = BioGraphics.createCylinderInPlane(Constants.YPLANE, split2StartPos, radius, 8);
	
		// Move the point around, and connect it, creating a wall of 
		// Allocate an instruction set for building it
		bioMightInstructSet = new BioMightInstructSet();
		
		numInstructions = 2;
		//BioMightOrientation bioMightOrientation = new BioMightOrientation(0.0, 0.0, 1.0, 90);
		for (int instructCount=0; instructCount<numInstructions; instructCount++)
		{
			// Create a place for an instruction 
			BioMightInstruction bioInstruct = new BioMightInstruction();
	
			// Place a transform object into each instruction set
			// Use the same one when homogenous
			bioInstruct.setBioMightTransform(bioMightTransform);
			
			
			bioMightTransform = new BioMightTransform();
			bioMightTransform.setTextureID(5);
			bioMightTransform.setTextureFile("SpeckledGreen.png");
			bioMightTransform.setComponentName("SideChain");
			
			// Place a transform object into each instruction set
			bioInstruct.setBioMightTransform(bioMightTransform);
			
			if (instructCount==0){		
				bioInstruct.setTransType(Constants.ROTATEOCTO);
				bioInstruct.setTranslateMatrix(0.0, 0.0, 0.00);
				BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, 90);
				bioInstruct.setOrientation(orientationUpd);	
				bioInstruct.setPivotPoint(4);
				bioInstruct.setTheta(-30.0);
				BioMightOrientation rotationUpd = new BioMightOrientation(0.0, 0.0, 1.0, 0.0);
				bioInstruct.setRotation(rotationUpd);	        
			}
			else if (instructCount==1){
				bioInstruct.setTransType(Constants.TRANSLATE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(-0.00825, -0.00825, 0.00);
			}
			else if (instructCount==2){
				bioInstruct.setTransType(Constants.TRANSLATE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(-0.00825, -0.00825, 0.00);   
			}				
			else {
				bioInstruct.setTransType(Constants.TRANSLATE);
				BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, 90);
				bioInstruct.setOrientation(orientationUpd);
				bioInstruct.setTranslateMatrix(0.0, -0.05, 0.0);       
			}
	
			// Add the instruction into the instruction set
    		bioMightInstructSet.addElement(bioInstruct);
		}	
				
		// Pass the instructions to the builder
		// These data points will need to be stored in the database and be modifiable
		// based on user inputs
		body += generateIndexFacedComponents(bioMightOrientation, bioMightInstructSet, split2Points); 	

		
		return (body);		
		
	}
  	
	/***********************************************************************************************************************
  	 * GENERATE Dendrites
  	 * 
  	 * Creates Dendrites based on instruction sets.  
  	 * 
  	 * @param bioMightTransform
  	 * @param currentPoints
  	 * @param bHeader
  	 * @param bFooter
  	 * @param diffColor
  	 * @return
  	 * 
  	 ***********************************************************************************************************************/
	
  	public static String generateDendritesOld(BioMightTransform bioMightTransform,  BioMightPosition startPos, BioMightOrientation bioMightOrientation) 	
	{		
	  	String body = "";			
		//double xStartPos = startPos.getXPos(); 
		//double yStartPos = startPos.getYPos(); 
		//double zStartPos = startPos.getZPos();
		System.out.println("\nGenerateDirectedLimb(): ");
			

		//***********************************************
		// Create the first lobe
	  	//***********************************************
	  	double[] nukStartPos = {0.0, 2.10, 0.00};
	  	double radius = 0.000625;
		double[][] nuclueiPoints = BioGraphics.createCylinderInPlane(Constants.YPLANE, nukStartPos, radius, 8);
		

		// Move the point around, and connect it, creating a wall of 
		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstructSet = new BioMightInstructSet();
		
		int numInstructions = 35;
		//BioMightOrientation bioMightOrientation = new BioMightOrientation(0.0, 0.0, 1.0, 90);
		for (int instructCount=0; instructCount<numInstructions; instructCount++)
		{
			// Create a place for an instruction 
			BioMightInstruction bioInstruct = new BioMightInstruction();
			
			// Place a transform object into each instruction set
			bioInstruct.setBioMightTransform(bioMightTransform);
			
			if (instructCount==0){		
				//BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, -90);
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(15, 15, 15);
				bioInstruct.setTranslateMatrix(0.0, -0.002, 0.0);      
			}
			else if (instructCount==1){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.1, 1.1, 1.1);
				bioInstruct.setTranslateMatrix(-0.01, -0.025, 0.0); 
			}
			else if (instructCount==2){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(-0.02, -0.05, 0.00);   
			}				
			else if (instructCount==3){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(-0.01, -0.05, 0.0);      
			}
			else if (instructCount==4){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.15, 1.1, 1.15);
				bioInstruct.setTranslateMatrix(-0.02, -0.05, 0.0);      
			}
			else if (instructCount==5){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(-0.01, -0.05, 0.0);      
			}
			else if (instructCount==6){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.15, 1.0, 1.5);
				bioInstruct.setTranslateMatrix(-0.02, -0.05, 0.00);      
			}
			else if (instructCount==7){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(-0.02, -0.05, 0.00);      
			}
			else if (instructCount==8){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(-0.01, -0.05, 0.00);      
			}
			else if (instructCount==9){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.1, 1.0, 1.5);
				bioInstruct.setTranslateMatrix(0.0, -0.05, 0.00);      
			}
			else if (instructCount==10){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.01, -0.05, 0.00);        
			}
			else if (instructCount==11){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.01, -0.05, 0.00);         
			}
			else if (instructCount==12){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.15, 1.0, 1.1);
				bioInstruct.setTranslateMatrix(0.01, -0.05, 0.00);         
			}
			else if (instructCount==13){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.15, 1.1, 1.1);
				bioInstruct.setTranslateMatrix(0.01, -0.05, 0.00);         
			}
			else if (instructCount==14){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.01, -0.05, 0.00);        
			}
			else if (instructCount==15){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.15, 1.0, 1.1);
				bioInstruct.setTranslateMatrix(0.01, -0.05, 0.00);       
			}
			else if (instructCount==16){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.15, 1.0, 1.1);
				bioInstruct.setTranslateMatrix(0.01, -0.05, 0.00);        
			}
			else if (instructCount==17){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.15, 1.0, 1.1);
				bioInstruct.setTranslateMatrix(0.01, -0.05, 0.00);         
			}
			else if (instructCount==18){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.15, 1.0, 1.1);
				bioInstruct.setTranslateMatrix(0.01, -0.05, 0.00);         
			}
			else if (instructCount==19){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.15, 1.0, 1.1);
				bioInstruct.setTranslateMatrix(0.0, -0.05, 0.00);         
			}
			else if (instructCount==20){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.15, 1.0, 1.1);
				bioInstruct.setTranslateMatrix(-0.01, -0.05, 0.00);         
			}
			else if (instructCount==21){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.15, 1.0, 1.1);
				bioInstruct.setTranslateMatrix(-0.01, -0.05, 0.00);         
			}
			else if (instructCount==22){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.15, 1.0, 1.1);
				bioInstruct.setTranslateMatrix(-0.01, -0.05, 0.00);         
			}
			else if (instructCount==23){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.15, 1.0, 1.1);
				bioInstruct.setTranslateMatrix(0.0, -0.05, 0.00);         
			}
			else if (instructCount==24){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.15, 1.0, 1.1);
				bioInstruct.setTranslateMatrix(0.0, -0.05, 0.00);         
			}
			else if (instructCount==25){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.15, 1.0, 1.1);
				bioInstruct.setTranslateMatrix(0.0, -0.05, 0.00);         
			}
			else if (instructCount==26){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.15, 1.0, 1.1);
				bioInstruct.setTranslateMatrix(0.0, -0.05, 0.00);         
			}
			else if (instructCount==27){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.15, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.0, -0.05, 0.00);         
			}
			else if (instructCount==28){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.01, -0.05, 0.00);         
			}
			else if (instructCount==29){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.15, 1.0, 1.1);
				bioInstruct.setTranslateMatrix(0.0, -0.05, 0.00);         
			}
			else if (instructCount==30){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.2, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.01, -0.05, 0.00);         
			}
			else if (instructCount==31){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.15, 1.0, 1.1);
				bioInstruct.setTranslateMatrix(0.01, -0.05, 0.00);         
			}
			else if (instructCount==32){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.2, 1.0, 1.1);
				bioInstruct.setTranslateMatrix(0.0, -0.05, 0.00);         
			}
			else if (instructCount==33){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.15, 1.0, 1.1);
				bioInstruct.setTranslateMatrix(0.01, -0.05, 0.00);         
			}
			else if (instructCount==34){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.15, 1.0, 1.1);
				bioInstruct.setTranslateMatrix(0.0, -0.05, 0.00);         
			}
			else {
				bioInstruct.setTransType(Constants.TRANSLATE);
				BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, 90);
				bioInstruct.setOrientation(orientationUpd);
				bioInstruct.setTranslateMatrix(0.0, -0.05, 0.0);       
			}
	
			
			
			// Add the instruction into the instruction set
    		bioMightInstructSet.addElement(bioInstruct);
		}	
			
		// Pass the instructions to the builder
		body += generateIndexFacedComponents(bioMightOrientation, bioMightInstructSet, nuclueiPoints); 	
				
		
		//***********************************************
		//
		// Create the second lobe
		//
	  	//***********************************************
		
	  	double[] nukStartPos2 = {0.0, -1.5, 0.00};
		nuclueiPoints = BioGraphics.createCylinderInPlane(Constants.YPLANE, nukStartPos2, radius, 8);

		bioMightInstructSet = new BioMightInstructSet();
		
		numInstructions = 24;
		//BioMightOrientation bioMightOrientation = new BioMightOrientation(0.0, 0.0, 1.0, 90);
		for (int instructCount=0; instructCount<numInstructions; instructCount++)
		{
			// Create a place for an instruction 
			BioMightInstruction bioInstruct = new BioMightInstruction();
			
			// Place a transform object into each instruction set
			bioInstruct.setBioMightTransform(bioMightTransform);
			
			
			if (instructCount==0){		
				//BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, -90);
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(25, 25, 25);
				bioInstruct.setTranslateMatrix(0.0, 0.002, 0.0);      
			}
			else if (instructCount==1){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(2, 2, 2);
				bioInstruct.setTranslateMatrix(-0.01, 0.025, 0.0); 
			}
			else if (instructCount==2){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.15, 1.1, 1.1);
				bioInstruct.setTranslateMatrix(-0.02, 0.05, 0.00);   
			}				
			else if (instructCount==3){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.15, 1.1, 1.1);
				bioInstruct.setTranslateMatrix(-0.01, 0.05, 0.0);      
			}
			else if (instructCount==4){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.15, 1.1, 1.1);
				bioInstruct.setTranslateMatrix(-0.03, 0.05, 0.0);      
			}
			else if (instructCount==5){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(-0.01, 0.05, 0.0);      
			}
			else if (instructCount==6){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.15, 1.1, 1.1);
				bioInstruct.setTranslateMatrix(0.01, 0.05, 0.00);      
			}
			else if (instructCount==7){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.01, 0.05, 0.00);      
			}
			else if (instructCount==8){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.01, 0.05, 0.00);      
			}
			else if (instructCount==9){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.15, 1.1, 1.1);
				bioInstruct.setTranslateMatrix(0.0, 0.05, 0.00);      
			}
			else if (instructCount==10){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.01, 0.05, 0.00);        
			}
			else if (instructCount==11){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.0, 0.005, 0.00);         
			}
			else if (instructCount==12){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.15, 1.1, 1.1);
				bioInstruct.setTranslateMatrix(0.0, 0.05, 0.00);         
			}
			else if (instructCount==13){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.15, 1.1, 1.1);
				bioInstruct.setTranslateMatrix(0.0, 0.05, 0.00);         
			}
			else if (instructCount==14){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.0, 0.05, 0.00);        
			}
			else if (instructCount==15){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.15, 1.1, 1.1);
				bioInstruct.setTranslateMatrix(0.0, 0.05, 0.00);       
			}
			else if (instructCount==16){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.15, 1.1, 1.1);
				bioInstruct.setTranslateMatrix(0.0, 0.05, 0.00);        
			}
			else if (instructCount==17){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.15, 1.1, 1.1);
				bioInstruct.setTranslateMatrix(0.0, 0.05, 0.00);         
			}
			else if (instructCount==18){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.15, 1.1, 1.1);
				bioInstruct.setTranslateMatrix(0.0, 0.05, 0.00);         
			}
			else if (instructCount==19){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.15, 1.1, 1.1);
				bioInstruct.setTranslateMatrix(0.0, 0.05, 0.00);         
			}
			else if (instructCount==20){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.15, 1.1, 1.1);
				bioInstruct.setTranslateMatrix(0.0, 0.05, 0.00);         
			}
			else if (instructCount==21){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.15, 1.1, 1.1);
				bioInstruct.setTranslateMatrix(0.0, 0.05, 0.00);         
			}
			else if (instructCount==22){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.15, 1.1, 1.1);
				bioInstruct.setTranslateMatrix(0.0, 0.05, 0.00);         
			}
			else if (instructCount==23){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.15, 1.1, 1.1);
				bioInstruct.setTranslateMatrix(0.0, 0.05, 0.00);         
			}
			
			else {
				bioInstruct.setTransType(Constants.TRANSLATE);
				BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, 90);
				bioInstruct.setOrientation(orientationUpd);
				bioInstruct.setTranslateMatrix(0.0, -0.05, 0.0);       
			}
			
			// Add the instruction into the instruction set
    		bioMightInstructSet.addElement(bioInstruct);
		}	
			
		// Pass the instructions to the builder
		body += generateIndexFacedComponents(bioMightOrientation, bioMightInstructSet, nuclueiPoints); 	
				
		
		//***********************************************
		//
		// Create the third lobe
		//
	  	//***********************************************

		
	  	double[] nukStartPos3 = {0.0, 0.0, 0.0};
		nuclueiPoints = BioGraphics.createCylinderInPlane(Constants.YPLANE, nukStartPos3, radius, 8);

		bioMightInstructSet = new BioMightInstructSet();
		
		numInstructions = 24;
		//BioMightOrientation bioMightOrientation = new BioMightOrientation(0.0, 0.0, 1.0, 90);
		for (int instructCount=0; instructCount<numInstructions; instructCount++)
		{
			// Create a place for an instruction 
			BioMightInstruction bioInstruct = new BioMightInstruction();
			
			// Place a transform object into each instruction set
			bioInstruct.setBioMightTransform(bioMightTransform);
			
			if (instructCount==0){		
				//BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, -90);
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(25, 25, 25);
				bioInstruct.setTranslateMatrix(0.0, 0.002, 0.0);      
			}
			else if (instructCount==1){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(2, 2, 2);
				bioInstruct.setTranslateMatrix(-0.01, 0.025, 0.0); 
			}
			else if (instructCount==2){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.15, 1.1, 1.1);
				bioInstruct.setTranslateMatrix(-0.02, 0.05, 0.00);   
			}				
			else if (instructCount==3){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.15, 1.1, 1.1);
				bioInstruct.setTranslateMatrix(-0.01, 0.05, 0.0);      
			}
			else if (instructCount==4){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.15, 1.1, 1.1);
				bioInstruct.setTranslateMatrix(-0.03, 0.05, 0.0);      
			}
			else if (instructCount==5){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(-0.01, 0.05, 0.0);      
			}
			else if (instructCount==6){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.15, 1.1, 1.1);
				bioInstruct.setTranslateMatrix(0.01, 0.05, 0.00);      
			}
			else if (instructCount==7){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.01, 0.05, 0.00);      
			}
			else if (instructCount==8){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.01, 0.05, 0.00);      
			}
			else if (instructCount==9){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.15, 1.1, 1.1);
				bioInstruct.setTranslateMatrix(0.0, 0.05, 0.00);      
			}
			else if (instructCount==10){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.01, 0.05, 0.00);        
			}
			else if (instructCount==11){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.0, 0.005, 0.00);         
			}
			else if (instructCount==12){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.15, 1.1, 1.1);
				bioInstruct.setTranslateMatrix(0.0, 0.05, 0.00);         
			}
			else if (instructCount==13){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.15, 1.1, 1.1);
				bioInstruct.setTranslateMatrix(0.0, 0.05, 0.00);         
			}
			else if (instructCount==14){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.0, 0.05, 0.00);        
			}
			else if (instructCount==15){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.15, 1.1, 1.1);
				bioInstruct.setTranslateMatrix(0.0, 0.05, 0.00);       
			}
			else if (instructCount==16){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.15, 1.1, 1.1);
				bioInstruct.setTranslateMatrix(0.0, 0.05, 0.00);        
			}
			else if (instructCount==17){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.15, 1.1, 1.1);
				bioInstruct.setTranslateMatrix(0.0, 0.05, 0.00);         
			}
			else if (instructCount==18){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.15, 1.1, 1.1);
				bioInstruct.setTranslateMatrix(0.0, 0.05, 0.00);         
			}
			else if (instructCount==19){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.15, 1.1, 1.1);
				bioInstruct.setTranslateMatrix(0.0, 0.05, 0.00);         
			}
			else if (instructCount==20){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.15, 1.1, 1.1);
				bioInstruct.setTranslateMatrix(0.0, 0.05, 0.00);         
			}
			else if (instructCount==21){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.15, 1.1, 1.1);
				bioInstruct.setTranslateMatrix(0.0, 0.05, 0.00);         
			}
			else if (instructCount==22){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.15, 1.1, 1.1);
				bioInstruct.setTranslateMatrix(0.0, 0.05, 0.00);         
			}
			else if (instructCount==23){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.15, 1.1, 1.1);
				bioInstruct.setTranslateMatrix(0.0, 0.05, 0.00);         
			}
			
			else {
				bioInstruct.setTransType(Constants.TRANSLATE);
				BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, 90);
				bioInstruct.setOrientation(orientationUpd);
				bioInstruct.setTranslateMatrix(0.0, -0.05, 0.0);       
			}
			
			// Add the instruction into the instruction set
    		bioMightInstructSet.addElement(bioInstruct);
		}	
			
		body += "<Transform onmouseover=\"showComponent('Dendrite');\" DEF='TRANSFORM_" + bioMightTransform.getId() + "' \n";
	 	body += "translation='" 
	 		+ 1.5 + " " 
			+ 0.0 + " "
			+ 0.0 + "'\n";					
	
		body +=  "rotation='" 
			+ 0 + " "
			+ 0 + " "
			+ 1  + " "
			+ 1.52 + "'>\n";
		
		// Pass the instructions to the builder
		body += generateIndexFacedComponents(bioMightOrientation, bioMightInstructSet, nuclueiPoints); 	
			
		body += "</Transform>";
				
		
		
		//***********************************************
		//
		// Create the forth lobe
		//
	  	//***********************************************
		
	  	double[] nukStartPos4 = {0.0, 0.0, 0.0};
		nuclueiPoints = BioGraphics.createCylinderInPlane(Constants.YPLANE, nukStartPos3, radius, 8);

		bioMightInstructSet = new BioMightInstructSet();
		
		numInstructions = 24;
		//BioMightOrientation bioMightOrientation = new BioMightOrientation(0.0, 0.0, 1.0, 90);
		for (int instructCount=0; instructCount<numInstructions; instructCount++)
		{
			// Create a place for an instruction 
			BioMightInstruction bioInstruct = new BioMightInstruction();
			
			// Place a transform object into each instruction set
			bioInstruct.setBioMightTransform(bioMightTransform);
			
			if (instructCount==0){		
				//BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, -90);
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(25, 25, 25);
				bioInstruct.setTranslateMatrix(0.0, 0.002, 0.0);      
			}
			else if (instructCount==1){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(2, 2, 2);
				bioInstruct.setTranslateMatrix(-0.01, 0.025, 0.0); 
			}
			else if (instructCount==2){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.15, 1.1, 1.1);
				bioInstruct.setTranslateMatrix(-0.02, 0.05, 0.00);   
			}				
			else if (instructCount==3){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.15, 1.1, 1.1);
				bioInstruct.setTranslateMatrix(-0.01, 0.05, 0.0);      
			}
			else if (instructCount==4){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.15, 1.1, 1.1);
				bioInstruct.setTranslateMatrix(-0.03, 0.05, 0.0);      
			}
			else if (instructCount==5){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(-0.01, 0.05, 0.0);      
			}
			else if (instructCount==6){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.15, 1.1, 1.1);
				bioInstruct.setTranslateMatrix(0.01, 0.05, 0.00);      
			}
			else if (instructCount==7){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.01, 0.05, 0.00);      
			}
			else if (instructCount==8){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.01, 0.05, 0.00);      
			}
			else if (instructCount==9){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.15, 1.1, 1.1);
				bioInstruct.setTranslateMatrix(0.0, 0.05, 0.00);      
			}
			else if (instructCount==10){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.01, 0.05, 0.00);        
			}
			else if (instructCount==11){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.0, 0.005, 0.00);         
			}
			else if (instructCount==12){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.15, 1.1, 1.1);
				bioInstruct.setTranslateMatrix(0.0, 0.05, 0.00);         
			}
			else if (instructCount==13){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.15, 1.1, 1.1);
				bioInstruct.setTranslateMatrix(0.0, 0.05, 0.00);         
			}
			else if (instructCount==14){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.0, 0.05, 0.00);        
			}
			else if (instructCount==15){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.15, 1.1, 1.1);
				bioInstruct.setTranslateMatrix(0.0, 0.05, 0.00);       
			}
			else if (instructCount==16){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.15, 1.1, 1.1);
				bioInstruct.setTranslateMatrix(0.0, 0.05, 0.00);        
			}
			else if (instructCount==17){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.15, 1.1, 1.1);
				bioInstruct.setTranslateMatrix(0.0, 0.05, 0.00);         
			}
			else if (instructCount==18){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.15, 1.1, 1.1);
				bioInstruct.setTranslateMatrix(0.0, 0.05, 0.00);         
			}
			else if (instructCount==19){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.15, 1.1, 1.1);
				bioInstruct.setTranslateMatrix(0.0, 0.05, 0.00);         
			}
			else if (instructCount==20){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.15, 1.1, 1.1);
				bioInstruct.setTranslateMatrix(0.0, 0.05, 0.00);         
			}
			else if (instructCount==21){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.15, 1.1, 1.1);
				bioInstruct.setTranslateMatrix(0.0, 0.05, 0.00);         
			}
			else if (instructCount==22){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.15, 1.1, 1.1);
				bioInstruct.setTranslateMatrix(0.0, 0.05, 0.00);         
			}
			else if (instructCount==23){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.15, 1.1, 1.1);
				bioInstruct.setTranslateMatrix(0.0, 0.05, 0.00);         
			}
			
			else {
				bioInstruct.setTransType(Constants.TRANSLATE);
				BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, 90);
				bioInstruct.setOrientation(orientationUpd);
				bioInstruct.setTranslateMatrix(0.0, -0.05, 0.0);       
			}
			
			// Add the instruction into the instruction set
    		bioMightInstructSet.addElement(bioInstruct);
		}	
			
		body += "<Transform onmouseover=\"showComponent('Dendrite');\" DEF='TRANSFORM_" + bioMightTransform.getId() + "' \n";
	 	body += "translation='" 
	 		+ -1.5 + " " 
			+ 0.0 + " "
			+ 0.0 + "'\n";					
	
		body +=  "rotation='" 
			+ 0 + " "
			+ 0 + " "
			+ 1  + " "
			+4.712 + "'>\n";
		
		// Pass the instructions to the builder
		body += generateIndexFacedComponents(bioMightOrientation, bioMightInstructSet, nuclueiPoints); 	
			
		body += "</Transform>";

		
		
		
		//***********************************************
		//
		// Create the 5th lobe
		//
	  	//***********************************************

		
	  	double[] nukStartPos5 = {0.0, 0.0, 0.0};
		nuclueiPoints = BioGraphics.createCylinderInPlane(Constants.YPLANE, nukStartPos5, radius, 8);

		bioMightInstructSet = new BioMightInstructSet();
		
		numInstructions = 12;
		//BioMightOrientation bioMightOrientation = new BioMightOrientation(0.0, 0.0, 1.0, 90);
		for (int instructCount=0; instructCount<numInstructions; instructCount++)
		{
			// Create a place for an instruction 
			BioMightInstruction bioInstruct = new BioMightInstruction();
			
			// Place a transform object into each instruction set
			bioInstruct.setBioMightTransform(bioMightTransform);
			
			if (instructCount==0){		
				//BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, -90);
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(25, 25, 25);
				bioInstruct.setTranslateMatrix(0.0, 0.002, 0.0);      
			}
			else if (instructCount==1){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(2, 2, 2);
				bioInstruct.setTranslateMatrix(-0.01, 0.025, 0.0); 
			}
			else if (instructCount==2){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.15, 1.1, 1.1);
				bioInstruct.setTranslateMatrix(-0.02, 0.05, 0.00);   
			}				
			else if (instructCount==3){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.15, 1.1, 1.1);
				bioInstruct.setTranslateMatrix(-0.01, 0.05, 0.0);      
			}
			else if (instructCount==4){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.15, 1.1, 1.1);
				bioInstruct.setTranslateMatrix(-0.03, 0.05, 0.0);      
			}
			else if (instructCount==5){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(-0.01, 0.05, 0.0);      
			}
			else if (instructCount==6){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.15, 1.1, 1.1);
				bioInstruct.setTranslateMatrix(0.01, 0.05, 0.00);      
			}
			else if (instructCount==7){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.01, 0.05, 0.00);      
			}
			else if (instructCount==8){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.01, 0.05, 0.00);      
			}
			else if (instructCount==9){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.15, 1.1, 1.1);
				bioInstruct.setTranslateMatrix(0.0, 0.05, 0.00);      
			}
			else if (instructCount==10){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.01, 0.05, 0.00);        
			}
			else if (instructCount==11){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.0, 0.005, 0.00);         
			}
			else if (instructCount==12){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.15, 1.1, 1.1);
				bioInstruct.setTranslateMatrix(0.0, 0.05, 0.00);         
			}			
			else {
				bioInstruct.setTransType(Constants.TRANSLATE);
				BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, 90);
				bioInstruct.setOrientation(orientationUpd);
				bioInstruct.setTranslateMatrix(0.0, -0.05, 0.0);       
			}
			
			// Add the instruction into the instruction set
    		bioMightInstructSet.addElement(bioInstruct);
		}	
			
		body += "<Transform onmouseover=\"showComponent('Dendrite');\" DEF='TRANSFORM_" + bioMightTransform.getId() + "' \n";
	 	body += "translation='" 
	 		+ -1.25 + " " 
			+ -0.39 + " "
			+ 0.0 + "'\n";					
	
		body +=  "rotation='" 
			+ 0 + " "
			+ 0 + " "
			+ 1  + " "
			+ -0.52 + "'>\n";
		
		// Pass the instructions to the builder
		body += generateIndexFacedComponents(bioMightOrientation, bioMightInstructSet, nuclueiPoints); 	
			
		body += "</Transform>";

		
		
		//***********************************************
		//
		// Create the 6th lobe
		//
	  	//***********************************************

		
	  	//nukStartPos6 = {0.0, 0.0, 0.0};
		nuclueiPoints = BioGraphics.createCylinderInPlane(Constants.YPLANE, nukStartPos5, radius, 8);

		bioMightInstructSet = new BioMightInstructSet();
		
		numInstructions = 12;
		//BioMightOrientation bioMightOrientation = new BioMightOrientation(0.0, 0.0, 1.0, 90);
		for (int instructCount=0; instructCount<numInstructions; instructCount++)
		{
			// Create a place for an instruction 
			BioMightInstruction bioInstruct = new BioMightInstruction();
			
			// Place a transform object into each instruction set
			bioInstruct.setBioMightTransform(bioMightTransform);
			
			if (instructCount==0){		
				//BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, -90);
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(25, 25, 25);
				bioInstruct.setTranslateMatrix(0.0, 0.002, 0.0);      
			}
			else if (instructCount==1){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(2, 2, 2);
				bioInstruct.setTranslateMatrix(-0.01, 0.025, 0.0); 
			}
			else if (instructCount==2){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.15, 1.1, 1.1);
				bioInstruct.setTranslateMatrix(-0.02, 0.05, 0.00);   
			}				
			else if (instructCount==3){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.15, 1.1, 1.1);
				bioInstruct.setTranslateMatrix(-0.01, 0.05, 0.0);      
			}
			else if (instructCount==4){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.15, 1.1, 1.1);
				bioInstruct.setTranslateMatrix(-0.03, 0.05, 0.0);      
			}
			else if (instructCount==5){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(-0.01, 0.05, 0.0);      
			}
			else if (instructCount==6){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.15, 1.1, 1.1);
				bioInstruct.setTranslateMatrix(0.01, 0.05, 0.00);      
			}
			else if (instructCount==7){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.01, 0.05, 0.00);      
			}
			else if (instructCount==8){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.01, 0.05, 0.00);      
			}
			else if (instructCount==9){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.15, 1.1, 1.1);
				bioInstruct.setTranslateMatrix(0.0, 0.05, 0.00);      
			}
			else if (instructCount==10){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.01, 0.05, 0.00);        
			}
			else if (instructCount==11){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.0, 0.005, 0.00);         
			}
			else if (instructCount==12){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.15, 1.1, 1.1);
				bioInstruct.setTranslateMatrix(0.0, 0.05, 0.00);         
			}			
			else {
				bioInstruct.setTransType(Constants.TRANSLATE);
				BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, 90);
				bioInstruct.setOrientation(orientationUpd);
				bioInstruct.setTranslateMatrix(0.0, -0.05, 0.0);       
			}
			
			// Add the instruction into the instruction set
    		bioMightInstructSet.addElement(bioInstruct);
		}	
			
		body += "<Transform onmouseover=\"showComponent('Dendrite');\" DEF='TRANSFORM_" + bioMightTransform.getId() + "' \n";
	 	body += "translation='" 
	 		+ 1.25 + " " 
			+ -0.39 + " "
			+ 0.0 + "'\n";					
	
		body +=  "rotation='" 
			+ 0 + " "
			+ 0 + " "
			+ 1  + " "
			+ 0.5 + "'>\n";
		
		// Pass the instructions to the builder
		body += generateIndexFacedComponents(bioMightOrientation, bioMightInstructSet, nuclueiPoints); 	
	
	
		body += "</Transform>";
	
		
		
		//***********************************************
		//
		// Create the 7th lobe
		//
	  	//***********************************************

		
	  	//nukStartPos6 = {0.0, 0.0, 0.0};
		nuclueiPoints = BioGraphics.createCylinderInPlane(Constants.YPLANE, nukStartPos5, radius, 8);

		bioMightInstructSet = new BioMightInstructSet();
		
		numInstructions = 15;
		//BioMightOrientation bioMightOrientation = new BioMightOrientation(0.0, 0.0, 1.0, 90);
		for (int instructCount=0; instructCount<numInstructions; instructCount++)
		{
			// Create a place for an instruction 
			BioMightInstruction bioInstruct = new BioMightInstruction();
			
			// Place a transform object into each instruction set
			bioInstruct.setBioMightTransform(bioMightTransform);
	
			
			if (instructCount==0){		
				//BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, -90);
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(25, 25, 25);
				bioInstruct.setTranslateMatrix(0.0, 0.002, 0.0);      
			}
			else if (instructCount==1){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(2, 2, 2);
				bioInstruct.setTranslateMatrix(-0.01, 0.025, 0.0); 
			}
			else if (instructCount==2){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.15, 1.1, 1.1);
				bioInstruct.setTranslateMatrix(-0.02, 0.05, 0.00);   
			}				
			else if (instructCount==3){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.15, 1.1, 1.1);
				bioInstruct.setTranslateMatrix(-0.01, 0.05, 0.0);      
			}
			else if (instructCount==4){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.15, 1.1, 1.1);
				bioInstruct.setTranslateMatrix(-0.03, 0.05, 0.0);      
			}
			else if (instructCount==5){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(-0.02, 0.05, 0.0);      
			}
			else if (instructCount==6){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.15, 1.1, 1.1);
				bioInstruct.setTranslateMatrix(0.02, 0.05, 0.00);      
			}
			else if (instructCount==7){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.03, 0.05, 0.00);      
			}
			else if (instructCount==8){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.01, 0.05, 0.00);      
			}
			else if (instructCount==9){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.15, 1.1, 1.1);
				bioInstruct.setTranslateMatrix(0.0, 0.05, 0.00);      
			}
			else if (instructCount==10){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.01, 0.05, 0.00);        
			}
			else if (instructCount==11){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.0, 0.005, 0.00);         
			}
			else if (instructCount==12){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.15, 1.1, 1.1);
				bioInstruct.setTranslateMatrix(0.0, 0.05, 0.00);         
			}
			else if (instructCount==13){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.15, 1.1, 1.1);
				bioInstruct.setTranslateMatrix(0.0, 0.05, 0.00);         
			}
			else if (instructCount==14){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.15, 1.1, 1.1);
				bioInstruct.setTranslateMatrix(0.0, 0.05, 0.00);         
			}
			else {
				bioInstruct.setTransType(Constants.TRANSLATE);
				BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, 90);
				bioInstruct.setOrientation(orientationUpd);
				bioInstruct.setTranslateMatrix(0.0, -0.05, 0.0);       
			}
			
			// Add the instruction into the instruction set
    		bioMightInstructSet.addElement(bioInstruct);
		}	
			
		body += "<Transform onmouseover=\"showComponent('Dendrite');\" DEF='TRANSFORM_" + bioMightTransform.getId() + "' \n";
	 	body += "translation='" 
	 		+ -0.5 + " " 
			+ -1.2 + " "
			+ 0.0 + "'\n";					
	
		body +=  "rotation='" 
			+ 0 + " "
			+ 0 + " "
			+ 1  + " "
			+ -0.9 + "'>\n";
		
		// Pass the instructions to the builder
		body += generateIndexFacedComponents(bioMightOrientation, bioMightInstructSet, nuclueiPoints); 	
	
	
		body += "</Transform>";
	

		//***********************************************
		//
		// Create the 8th lobe
		//
	  	//***********************************************

	  	//nukStartPos6 = {0.0, 0.0, 0.0};
		nuclueiPoints = BioGraphics.createCylinderInPlane(Constants.YPLANE, nukStartPos5, radius, 8);

		bioMightInstructSet = new BioMightInstructSet();
		
		numInstructions = 17;
		//BioMightOrientation bioMightOrientation = new BioMightOrientation(0.0, 0.0, 1.0, 90);
		for (int instructCount=0; instructCount<numInstructions; instructCount++)
		{
			// Create a place for an instruction 
			BioMightInstruction bioInstruct = new BioMightInstruction();
			
			// Place a transform object into each instruction set
			bioInstruct.setBioMightTransform(bioMightTransform);
			
			
			if (instructCount==0){		
				//BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, -90);
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(25, 25, 25);
				bioInstruct.setTranslateMatrix(0.0, 0.002, 0.0);      
			}
			else if (instructCount==1){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(2, 2, 2);
				bioInstruct.setTranslateMatrix(-0.01, 0.025, 0.0); 
			}
			else if (instructCount==2){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.15, 1.1, 1.1);
				bioInstruct.setTranslateMatrix(-0.02, 0.05, 0.00);   
			}				
			else if (instructCount==3){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.15, 1.1, 1.1);
				bioInstruct.setTranslateMatrix(-0.01, 0.05, 0.0);      
			}
			else if (instructCount==4){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.15, 1.1, 1.1);
				bioInstruct.setTranslateMatrix(-0.03, 0.05, 0.0);      
			}
			else if (instructCount==5){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(-0.02, 0.05, 0.0);      
			}
			else if (instructCount==6){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.15, 1.1, 1.1);
				bioInstruct.setTranslateMatrix(0.02, 0.05, 0.00);      
			}
			else if (instructCount==7){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.03, 0.05, 0.00);      
			}
			else if (instructCount==8){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.01, 0.05, 0.00);      
			}
			else if (instructCount==9){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.15, 1.1, 1.1);
				bioInstruct.setTranslateMatrix(0.0, 0.05, 0.00);      
			}
			else if (instructCount==10){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.01, 0.05, 0.00);        
			}
			else if (instructCount==11){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.0, 0.005, 0.00);         
			}
			else if (instructCount==12){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.15, 1.1, 1.1);
				bioInstruct.setTranslateMatrix(0.0, 0.05, 0.00);         
			}
			else if (instructCount==13){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.15, 1.1, 1.1);
				bioInstruct.setTranslateMatrix(0.01, 0.05, 0.00);         
			}
			else if (instructCount==14){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.1, 1.1, 1.1);
				bioInstruct.setTranslateMatrix(0.0, 0.05, 0.00);         
			}
			else if (instructCount==16){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.1, 1.1, 1.1);
				bioInstruct.setTranslateMatrix(0.01, 0.05, 0.00);         
			}
			else if (instructCount==16){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.15, 1.1, 1.1);
				bioInstruct.setTranslateMatrix(0.0, 0.05, 0.00);         
			}
			
			else {
				bioInstruct.setTransType(Constants.TRANSLATE);
				BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, 90);
				bioInstruct.setOrientation(orientationUpd);
				bioInstruct.setTranslateMatrix(0.0, -0.05, 0.0);       
			}
			
			// Add the instruction into the instruction set
    		bioMightInstructSet.addElement(bioInstruct);
		}	
			
		body += "<Transform onmouseover=\"showComponent('Dendrite');\" DEF='TRANSFORM_" + bioMightTransform.getId() + "' \n";
	 	body += "translation='" 
	 		+ 0.48 + " " 
			+ 1.10 + " "
			+ 0.0 + "'\n";					
	
		body +=  "rotation='" 
			+ 0 + " "
			+ 0 + " "
			+ 1  + " "
			+ 2.20 + "'>\n";
		
		
		// Pass the instructions to the builder
		String genArm = generateIndexFacedComponents(bioMightOrientation, bioMightInstructSet, nuclueiPoints); 
		body += genArm; 	
	
		body += "</Transform>";

		//***********************************************
		//
		// Create the 9th lobe
		//
	  	//***********************************************
				
		body += "<Transform onmouseover=\"showComponent('Dendrite');\" DEF='TRANSFORM_" + bioMightTransform.getId() + "' \n";
	 	body += "translation='" 
	 		+ 0.50 + " " 
			+ -1.10 + " "
			+ 0.0 + "'\n";					
	
		body +=  "rotation='" 
			+ 0 + " "
			+ 0 + " "
			+ 1  + " "
			+ 0.80 + "'>\n";
		 
		body += genArm; 	
	
		body += "</Transform>";
		
		
		//***********************************************
		//
		// Create the 10th lobe
		//
	  	//***********************************************

	  	//nukStartPos6 = {0.0, 0.0, 0.0};
		nuclueiPoints = BioGraphics.createCylinderInPlane(Constants.YPLANE, nukStartPos5, radius, 8);

		bioMightInstructSet = new BioMightInstructSet();
		
		
		numInstructions = 17;
		//BioMightOrientation bioMightOrientation = new BioMightOrientation(0.0, 0.0, 1.0, 90);
		for (int instructCount=0; instructCount<numInstructions; instructCount++)
		{
			// Create a place for an instruction 
			BioMightInstruction bioInstruct = new BioMightInstruction();
			
			// Place a transform object into each instruction set
			bioInstruct.setBioMightTransform(bioMightTransform);
			
			
			if (instructCount==0){		
				//BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, -90);
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(25, 25, 25);
				bioInstruct.setTranslateMatrix(0.0, 0.002, 0.0);      
			}
			else if (instructCount==1){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(2, 2, 2);
				bioInstruct.setTranslateMatrix(0.01, 0.025, 0.0); 
			}
			else if (instructCount==2){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.15, 1.1, 1.1);
				bioInstruct.setTranslateMatrix(-0.02, 0.05, 0.00);   
			}				
			else if (instructCount==3){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.15, 1.1, 1.1);
				bioInstruct.setTranslateMatrix(0.01, 0.05, 0.0);      
			}
			else if (instructCount==4){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.15, 1.1, 1.1);
				bioInstruct.setTranslateMatrix(0.03, 0.05, 0.0);      
			}
			else if (instructCount==5){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.02, 0.05, 0.0);      
			}
			else if (instructCount==6){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.15, 1.1, 1.1);
				bioInstruct.setTranslateMatrix(-0.02, 0.05, 0.00);      
			}
			else if (instructCount==7){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(-0.03, 0.05, 0.00);      
			}
			else if (instructCount==8){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(-0.01, 0.05, 0.00);      
			}
			else if (instructCount==9){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.15, 1.1, 1.1);
				bioInstruct.setTranslateMatrix(0.0, 0.05, 0.00);      
			}
			else if (instructCount==10){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(-0.01, 0.05, 0.00);        
			}
			else if (instructCount==11){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.0, 0.005, 0.00);         
			}
			else if (instructCount==12){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.15, 1.1, 1.1);
				bioInstruct.setTranslateMatrix(0.0, 0.05, 0.00);         
			}
			else if (instructCount==13){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.15, 1.1, 1.1);
				bioInstruct.setTranslateMatrix(-0.02, 0.05, 0.00);         
			}
			else if (instructCount==14){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.1, 1.1, 1.1);
				bioInstruct.setTranslateMatrix(0.0, 0.05, 0.00);         
			}
			else if (instructCount==15){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.1, 1.1, 1.1);
				bioInstruct.setTranslateMatrix(0.01, 0.05, 0.00);         
			}
			else if (instructCount==16){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.15, 1.1, 1.1);
				bioInstruct.setTranslateMatrix(0.0, 0.05, 0.00);         
			}
			
			else {
				bioInstruct.setTransType(Constants.TRANSLATE);
				BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, 90);
				bioInstruct.setOrientation(orientationUpd);
				bioInstruct.setTranslateMatrix(0.0, -0.05, 0.0);       
			}
			
			// Add the instruction into the instruction set
    		bioMightInstructSet.addElement(bioInstruct);
		}	
			
		body += "<Transform  onmouseover=\"showComponent('Dendrite');\" DEF='TRANSFORM_" + bioMightTransform.getId() + "' \n";
	 	body += "translation='" 
	 		+ -0.62 + " " 
			+ 1.3 + " "
			+ 0.0 + "'\n";					
	
		body +=  "rotation='" 
			+ 0 + " "
			+ 0 + " "
			+ 1  + " "
			+ -2.3 + "'>\n";
		
		// Pass the instructions to the builder
		body += generateIndexFacedComponents(bioMightOrientation, bioMightInstructSet, nuclueiPoints); 	
	
	
		body += "</Transform>";
		
		
		//***********************************************
		//
		// Create the 11th
		//
	  	//***********************************************

	  	//nukStartPos6 = {0.0, 0.0, 0.0};
		nuclueiPoints = BioGraphics.createCylinderInPlane(Constants.YPLANE, nukStartPos5, radius, 8);

		bioMightInstructSet = new BioMightInstructSet();
		
		numInstructions = 17;
		//BioMightOrientation bioMightOrientation = new BioMightOrientation(0.0, 0.0, 1.0, 90);
		for (int instructCount=0; instructCount<numInstructions; instructCount++)
		{
			// Create a place for an instruction 
			BioMightInstruction bioInstruct = new BioMightInstruction();
		
			// Place a transform object into each instruction set
			bioInstruct.setBioMightTransform(bioMightTransform);
			
			if (instructCount==0){		
				//BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, -90);
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(15, 15, 15);
				bioInstruct.setTranslateMatrix(0.0, 0.002, 0.0);      
			}
			else if (instructCount==1){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.25, 1.25, 1.25);
				bioInstruct.setTranslateMatrix(-0.01, 0.025, 0.0); 
			}
			else if (instructCount==2){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(-0.02, 0.05, 0.00);   
			}				
			else if (instructCount==3){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(-0.01, 0.05, 0.0);      
			}
			else if (instructCount==4){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(-0.03, 0.05, 0.0);      
			}
			else if (instructCount==5){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(-0.02, 0.05, 0.0);      
			}
			else if (instructCount==6){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.02, 0.05, 0.00);      
			}
			else if (instructCount==7){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.03, 0.05, 0.00);      
			}
			else if (instructCount==8){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.01, 0.05, 0.00);      
			}
			else if (instructCount==9){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.0, 0.05, 0.00);      
			}
			else if (instructCount==10){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.01, 0.05, 0.00);        
			}
			else if (instructCount==11){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.0, 0.005, 0.00);         
			}
			else if (instructCount==12){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.1, 1.0, 1.1);
				bioInstruct.setTranslateMatrix(0.0, 0.05, 0.00);         
			}
			else if (instructCount==13){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.01, 0.05, 0.00);         
			}
			else if (instructCount==14){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.0, 0.05, 0.00);         
			}
			else if (instructCount==16){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.01, 0.05, 0.00);         
			}
			else if (instructCount==16){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.0, 0.05, 0.00);         
			}
			
			else {
				bioInstruct.setTransType(Constants.TRANSLATE);
				BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, 90);
				bioInstruct.setOrientation(orientationUpd);
				bioInstruct.setTranslateMatrix(0.0, -0.05, 0.0);       
			}
			
			// Add the instruction into the instruction set
    		bioMightInstructSet.addElement(bioInstruct);
		}	
			
		body += "<Transform onmouseover=\"showComponent('Dendrite');\" DEF='TRANSFORM_" + bioMightTransform.getId() + "' \n";
	 	body += "translation='" 
	 		+ 0.50 + " " 
			+ 1.60 + " "
			+ 0.0 + "'\n";					
	
		body +=  "rotation='" 
			+ 0 + " "
			+ 0 + " "
			+ 1  + " "
			+ 2.20 + "'>\n";
		
		
		// Pass the instructions to the builder
		genArm = generateIndexFacedComponents(bioMightOrientation, bioMightInstructSet, nuclueiPoints); 
		body += genArm; 	
	
		body += "</Transform>";
		
		

		//***********************************************
		//
		// Create the 12th
		//
	  	//***********************************************

	  	//nukStartPos6 = {0.0, 0.0, 0.0};
		nuclueiPoints = BioGraphics.createCylinderInPlane(Constants.YPLANE, nukStartPos5, radius, 8);

		bioMightInstructSet = new BioMightInstructSet();
		
		numInstructions = 17;
		//BioMightOrientation bioMightOrientation = new BioMightOrientation(0.0, 0.0, 1.0, 90);
		for (int instructCount=0; instructCount<numInstructions; instructCount++)
		{
			// Create a place for an instruction 
			BioMightInstruction bioInstruct = new BioMightInstruction();
			
			// Place a transform object into each instruction set
			bioInstruct.setBioMightTransform(bioMightTransform);
			
			if (instructCount==0){		
				//BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, -90);
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(20, 20, 20);
				bioInstruct.setTranslateMatrix(0.0, 0.002, 0.0);      
			}
			else if (instructCount==1){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(2.0, 2.0, 2.0);
				bioInstruct.setTranslateMatrix(-0.01, 0.025, 0.0); 
			}
			else if (instructCount==2){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.15, 1.0, 1.15);
				bioInstruct.setTranslateMatrix(-0.01, 0.05, 0.00);   
			}				
			else if (instructCount==3){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.15, 1.0, 1.15);
				bioInstruct.setTranslateMatrix(-0.01, 0.05, 0.0);      
			}
			else if (instructCount==4){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(-0.02, 0.05, 0.0);      
			}
			else if (instructCount==5){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(-0.01, 0.05, 0.0);      
			}
			else if (instructCount==6){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.01, 0.05, 0.00);      
			}
			else if (instructCount==7){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.02, 0.05, 0.00);      
			}
			else if (instructCount==8){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.01, 0.05, 0.00);      
			}
			else if (instructCount==9){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.15, 1.0, 1.1);
				bioInstruct.setTranslateMatrix(0.0, 0.05, 0.00);      
			}
			else if (instructCount==10){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.01, 0.05, 0.00);        
			}
			else if (instructCount==11){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.0, 0.005, 0.00);         
			}
			else if (instructCount==12){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.15, 1.0, 1.1);
				bioInstruct.setTranslateMatrix(0.0, 0.05, 0.00);         
			}
			else if (instructCount==13){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.01, 0.05, 0.00);         
			}
			else if (instructCount==14){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.1, 1.0, 1.1);
				bioInstruct.setTranslateMatrix(0.0, 0.05, 0.00);         
			}
			else if (instructCount==16){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.1, 1.0, 1.1);
				bioInstruct.setTranslateMatrix(0.01, 0.05, 0.00);         
			}
			else if (instructCount==16){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.15, 1.0, 1.1);
				bioInstruct.setTranslateMatrix(0.0, 0.05, 0.00);         
			}
			
			else {
				bioInstruct.setTransType(Constants.TRANSLATE);
				BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, 90);
				bioInstruct.setOrientation(orientationUpd);
				bioInstruct.setTranslateMatrix(0.0, -0.05, 0.0);       
			}
			
			// Add the instruction into the instruction set
    		bioMightInstructSet.addElement(bioInstruct);
		}	
			
		body += "<Transform onmouseover=\"showComponent('Dendrite');\" DEF='TRANSFORM_" + bioMightTransform.getId() + "' \n";
	 	body += "translation='" 
	 		+ 1.6 + " " 
			+ 0.5 + " "
			+ 0.0 + "'\n";					
	
		body +=  "rotation='" 
			+ 0 + " "
			+ 0 + " "
			+ 1  + " "
			+ 2.50 + "'>\n";
		
		
		// Pass the instructions to the builder
		genArm = generateIndexFacedComponents(bioMightOrientation, bioMightInstructSet, nuclueiPoints); 
		body += genArm; 	
	
		body += "</Transform>";
		
	
		//***********************************************
		//
		// Create the 13th
		//
	  	//***********************************************

	  	//nukStartPos6 = {0.0, 0.0, 0.0};
		nuclueiPoints = BioGraphics.createCylinderInPlane(Constants.YPLANE, nukStartPos5, radius, 8);

		bioMightInstructSet = new BioMightInstructSet();
		
		numInstructions = 17;
		//BioMightOrientation bioMightOrientation = new BioMightOrientation(0.0, 0.0, 1.0, 90);
		for (int instructCount=0; instructCount<numInstructions; instructCount++)
		{
			// Create a place for an instruction 
			BioMightInstruction bioInstruct = new BioMightInstruction();
			
			// Place a transform object into each instruction set
			bioInstruct.setBioMightTransform(bioMightTransform);
			
			if (instructCount==0){		
				//BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, -90);
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(15, 15, 15);
				bioInstruct.setTranslateMatrix(0.0, 0.002, 0.0);      
			}
			else if (instructCount==1){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.5, 1.5, 1.5);
				bioInstruct.setTranslateMatrix(0.01, 0.025, 0.0); 
			}
			else if (instructCount==2){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.15, 1.0, 1.1);
				bioInstruct.setTranslateMatrix(0.02, 0.05, 0.00);   
			}				
			else if (instructCount==3){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.15, 1.0, 1.1);
				bioInstruct.setTranslateMatrix(0.01, 0.05, 0.0);      
			}
			else if (instructCount==4){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.02, 0.05, 0.0);      
			}
			else if (instructCount==5){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.02, 0.05, 0.0);      
			}
			else if (instructCount==6){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(-0.02, 0.05, 0.00);      
			}
			else if (instructCount==7){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(-0.02, 0.05, 0.00);      
			}
			else if (instructCount==8){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(-0.01, 0.05, 0.00);      
			}
			else if (instructCount==9){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.15, 1.0, 1.1);
				bioInstruct.setTranslateMatrix(0.0, 0.05, 0.00);      
			}
			else if (instructCount==10){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(-0.01, 0.05, 0.00);        
			}
			else if (instructCount==11){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.0, 0.05, 0.00);         
			}
			else if (instructCount==12){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.1, 1.0, 1.1);
				bioInstruct.setTranslateMatrix(0.0, 0.05, 0.00);         
			}
			else if (instructCount==13){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.01, 0.05, 0.00);         
			}
			else if (instructCount==14){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.0, 0.05, 0.00);         
			}
			else if (instructCount==15){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.01, 0.05, 0.00);         
			}
			else if (instructCount==16){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.1, 1.0, 1.1);
				bioInstruct.setTranslateMatrix(0.0, 0.05, 0.00);         
			}
			
			else {
				bioInstruct.setTransType(Constants.TRANSLATE);
				BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, 90);
				bioInstruct.setOrientation(orientationUpd);
				bioInstruct.setTranslateMatrix(0.0, -0.05, 0.0);       
			}
			
			// Add the instruction into the instruction set
    		bioMightInstructSet.addElement(bioInstruct);
		}	
			
		body += "<Transform onmouseover=\"showComponent('Dendrite');\" DEF='TRANSFORM_" + bioMightTransform.getId() + "' \n";
	 	body += "translation='" 
		 		+ 2.2 + " " 
				+ 0.36 + " "
				+ 0.0 + "'\n";						
	
		body +=  "rotation='" 
			+ 0 + " "
			+ 0 + " "
			+ 1  + " "
			+ 2.10 + "'>\n";
		
		
		// Pass the instructions to the builder
		genArm = generateIndexFacedComponents(bioMightOrientation, bioMightInstructSet, nuclueiPoints); 
		body += genArm; 	
	
		body += "</Transform>";

		//***********************************************
		//
		// Create the 13th
		//
	  	//***********************************************

	  	//nukStartPos6 = {0.0, 0.0, 0.0};
		nuclueiPoints = BioGraphics.createCylinderInPlane(Constants.YPLANE, nukStartPos5, radius, 8);

		bioMightInstructSet = new BioMightInstructSet();
		
		numInstructions = 21;
		//BioMightOrientation bioMightOrientation = new BioMightOrientation(0.0, 0.0, 1.0, 90);
		for (int instructCount=0; instructCount<numInstructions; instructCount++)
		{
			// Create a place for an instruction 
			BioMightInstruction bioInstruct = new BioMightInstruction();
			
			// Place a transform object into each instruction set
			bioInstruct.setBioMightTransform(bioMightTransform);
			
			if (instructCount==0){		
				//BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, -90);
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(15, 15, 15);
				bioInstruct.setTranslateMatrix(0.0, 0.002, 0.0);      
			}
			else if (instructCount==1){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.5, 1.5, 1.5);
				bioInstruct.setTranslateMatrix(0.01, 0.025, 0.0); 
			}
			else if (instructCount==2){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.15, 1.0, 1.1);
				bioInstruct.setTranslateMatrix(0.02, 0.05, 0.00);   
			}				
			else if (instructCount==3){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.15, 1.0, 1.1);
				bioInstruct.setTranslateMatrix(-0.01, 0.05, 0.0);      
			}
			else if (instructCount==4){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(-0.02, 0.05, 0.0);      
			}
			else if (instructCount==5){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(-0.02, 0.05, 0.0);      
			}
			else if (instructCount==6){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.02, 0.05, 0.00);      
			}
			else if (instructCount==7){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.02, 0.05, 0.00);      
			}
			else if (instructCount==8){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.01, 0.05, 0.00);      
			}
			else if (instructCount==9){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.1);
				bioInstruct.setTranslateMatrix(0.0, 0.05, 0.00);      
			}
			else if (instructCount==10){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.01, 0.05, 0.00);        
			}
			else if (instructCount==11){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.0, 0.05, 0.00);         
			}
			else if (instructCount==12){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.0, 0.05, 0.00);         
			}
			else if (instructCount==13){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.0, 0.05, 0.00);         
			}
			else if (instructCount==14){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.0, 0.05, 0.00);         
			}
			else if (instructCount==15){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.1, 1.0, 1.1);
				bioInstruct.setTranslateMatrix(-0.01, 0.05, 0.00);         
			}
			else if (instructCount==16){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.0, 0.05, 0.00);         
			}
			else if (instructCount==17){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(-0.01, 0.05, 0.00);         
			}
			else if (instructCount==18){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.15, 1.0, 1.1);
				bioInstruct.setTranslateMatrix(0.0, 0.05, 0.00);         
			}
			else if (instructCount==19){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(-0.01, 0.05, 0.00);         
			}
			else if (instructCount==20){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.15, 1.0, 1.1);
				bioInstruct.setTranslateMatrix(0.0, 0.05, 0.00);         
			}
			else {
				bioInstruct.setTransType(Constants.TRANSLATE);
				BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, 90);
				bioInstruct.setOrientation(orientationUpd);
				bioInstruct.setTranslateMatrix(0.0, -0.05, 0.0);       
			}
			
			// Add the instruction into the instruction set
    		bioMightInstructSet.addElement(bioInstruct);
		}	
			
		body += "<Transform onmouseover=\"showComponent('Dendrite');\" DEF='TRANSFORM_" + bioMightTransform.getId() + "' \n";
	 	body += "translation='" 
		 		+ 2.4 + " " 
				+ -0.2 + " "
				+ 0.0 + "'\n";						
	
		body +=  "rotation='" 
			+ 0 + " "
			+ 0 + " "
			+ 1  + " "
			+ 1.40 + "'>\n";
		
		
		// Pass the instructions to the builder
		genArm = generateIndexFacedComponents(bioMightOrientation, bioMightInstructSet, nuclueiPoints); 
		body += genArm; 	
	
		body += "</Transform>";
	
		
		//***********************************************
		// Create the Z lobe
	  	//***********************************************
	  	double[] nukStartPosZ = {0.0, 2.10, 0.00};
		nuclueiPoints = BioGraphics.createCylinderInPlane(Constants.YPLANE, nukStartPosZ, radius, 8);
		

		// Create the Arm that has the Axon attached
		double[] nukStartPos6 = {
	    		0.0, 
	    		0, 
	    		-1.65 };
		
		nuclueiPoints = BioGraphics.createCylinderInPlane(Constants.ZPLANE, nukStartPos6, radius, 8);

		bioMightInstructSet = new BioMightInstructSet();
	
		numInstructions = 26;
		//BioMightOrientation bioMightOrientation = new BioMightOrientation(0.0, 0.0, 1.0, 90);
		for (int instructCount=0; instructCount<numInstructions; instructCount++)
		{
			// Create a place for an instruction 
			BioMightInstruction bioInstruct = new BioMightInstruction();
			
			// Place a transform object into each instruction set
			bioInstruct.setBioMightTransform(bioMightTransform);
			
			
			if (instructCount==0){		
				//BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, -90);
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(20, 20, 20);
				bioInstruct.setTranslateMatrix(0.0, 0.0, 0.002);      
			}
			else if (instructCount==1){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(2, 2, 2);
				bioInstruct.setTranslateMatrix(0.0, 0.0, 0.025); 
			}
			else if (instructCount==2){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.15, 1.1, 1.0);
				bioInstruct.setTranslateMatrix(0.0, 0.00, 0.05);   
			}				
			else if (instructCount==3){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.1, 1.1, 1.0);
				bioInstruct.setTranslateMatrix(0.01, 0.0, 0.05);      
			}
			else if (instructCount==4){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.1, 1.1, 1.0);
				bioInstruct.setTranslateMatrix(0.01, 0.0, 0.05);      
			}
			else if (instructCount==5){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.01, 0.0, 0.05);      
			}
			else if (instructCount==6){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.0, 0.00, 0.05);       
			}
			else if (instructCount==7){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.0, 0.00, 0.05);       
			}
			else if (instructCount==8){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(-0.01, 0.00, 0.05);   
			}
			else if (instructCount==9){
				bioInstruct.setTransType(Constants.TRANSLATE);
				bioInstruct.setTranslateMatrix(-0.01, 0.00, 0.05);       
			}
			else if (instructCount==10){
				bioInstruct.setTransType(Constants.TRANSLATE);
				bioInstruct.setTranslateMatrix(-0.01, 0.00, 0.05);          
			}
			else if (instructCount==11){
				bioInstruct.setTransType(Constants.TRANSLATE);
				bioInstruct.setTranslateMatrix(0.0, 0.00, 0.05);         
			}
			else if (instructCount==12){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.15, 1.15, 1.0);
				bioInstruct.setTranslateMatrix(0.0, 0.00, 0.05);            
			}
			else if (instructCount==13){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.15, 1.15, 1.0);
				bioInstruct.setTranslateMatrix(-0.01, 0.00, 0.05);          
			}
			else if (instructCount==14){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.18, 1.15, 1.0);
				bioInstruct.setTranslateMatrix(0.0, 0.00, 0.05);          
			}
			else if (instructCount==15){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.18, 1.15, 1.0);
				bioInstruct.setTranslateMatrix(0.0, 0.00, 0.05);          
			}
			else if (instructCount==16){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.18, 1.15, 1.0);
				bioInstruct.setTranslateMatrix(-0.01, 0.00, 0.05);          
			}
			else if (instructCount==17){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.18, 1.15, 1.0);
				bioInstruct.setTranslateMatrix(0.0, 0.00, 0.05);          
			}
			else if (instructCount==18){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.18, 1.15, 1.0);
				bioInstruct.setTranslateMatrix(0.0, 0.00, 0.05);          
			}
			else if (instructCount==19){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.18, 1.15, 1.0);
				bioInstruct.setTranslateMatrix(0.0, 0.00, 0.05);          
			}
			else if (instructCount==20){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.15, 1.15, 1.0);
				bioInstruct.setTranslateMatrix(0.0, 0.00, 0.05);          
			}
			else if (instructCount==21){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.15, 1.1, 1.0);
				bioInstruct.setTranslateMatrix(0.0, 0.00, 0.05);          
			}
			else if (instructCount==22){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.15, 1.15, 1.0);
				bioInstruct.setTranslateMatrix(0.0, 0.00, 0.05);          
			}
			else if (instructCount==23){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.15, 1.15, 1.0);
				bioInstruct.setTranslateMatrix(0.0, 0.00, 0.05);          
			}
			else if (instructCount==24){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.15, 1.15, 1.0);
				bioInstruct.setTranslateMatrix(0.0, 0.00, 0.05);          
			}
			else if (instructCount==25){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.15, 1.15, 1.0);
				bioInstruct.setTranslateMatrix(0.0, 0.00, 0.05);          
			}
			
			else {
				bioInstruct.setTransType(Constants.TRANSLATE);
				BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, 90);
				bioInstruct.setOrientation(orientationUpd);
				bioInstruct.setTranslateMatrix(0.0, 0.00, 0.05);       
			}
	

			// Add the instruction into the instruction set
    		bioMightInstructSet.addElement(bioInstruct);
		}	
			
		// Pass the instructions to the builder
		body += "<Transform onmouseover=\"showComponent('Dendrite');\" DEF='TRANSFORM_" + bioMightTransform.getId() + "' \n";
	 	body += "translation='" 
		 		+ 0.0 + " " 
				+ 0.0 + " "
				+ 0.0 + "'\n";						
	
		body +=  "rotation='" 
			+ 0 + " "
			+ 0 + " "
			+ 1  + " "
			+ 0.0 + "'>\n";
		
		
		// Pass the instructions to the builder
		genArm = generateIndexFacedComponents(bioMightOrientation, bioMightInstructSet, nuclueiPoints); 
		body += genArm; 	
	
		body += "</Transform>";


		//***********************************************
		// Create Arm on the Z lobe
	  	//***********************************************
	  	double[] nukStartPosZA = {0.0, 2.10, 0.00};
		nuclueiPoints = BioGraphics.createCylinderInPlane(Constants.YPLANE, nukStartPosZA, radius, 8);
		

		// Create the Arm on the Z arm
		double[] nukStartPosZB = {
	    		-0.20, 
	    		0.3, 
	    		-1.7};
		
		nuclueiPoints = BioGraphics.createCylinderInPlane(Constants.ZPLANE, nukStartPosZB, radius, 8);

		bioMightInstructSet = new BioMightInstructSet();
	
		numInstructions = 16;
		//BioMightOrientation bioMightOrientation = new BioMightOrientation(0.0, 0.0, 1.0, 90);
		for (int instructCount=0; instructCount<numInstructions; instructCount++)
		{
			// Create a place for an instruction 
			BioMightInstruction bioInstruct = new BioMightInstruction();

			// Place a transform object into each instruction set
			bioInstruct.setBioMightTransform(bioMightTransform);
			
			
			if (instructCount==0){		
				//BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, -90);
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(20, 20, 20);
				bioInstruct.setTranslateMatrix(0.0, 0.0, 0.002);      
			}
			else if (instructCount==1){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(2, 2, 2);
				bioInstruct.setTranslateMatrix(0.0, 0.0, 0.025); 
			}
			else if (instructCount==2){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.15, 1.1, 1.0);
				bioInstruct.setTranslateMatrix(0.0, 0.00, 0.05);   
			}				
			else if (instructCount==3){
				bioInstruct.setTransType(Constants.TRANSLATE);
				bioInstruct.setTranslateMatrix(0.0, -0.03, 0.05);      
			}
			else if (instructCount==4){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.1, 1.1, 1.0);
				bioInstruct.setTranslateMatrix(0.00, -0.02, 0.05);      
			}
			else if (instructCount==5){
				bioInstruct.setTransType(Constants.TRANSLATE);
				bioInstruct.setTranslateMatrix(0.03, 0.0, 0.05);      
			}
			else if (instructCount==6){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.01, -0.03, 0.05);       
			}
			else if (instructCount==7){
				bioInstruct.setTransType(Constants.TRANSLATE);
				bioInstruct.setTranslateMatrix(0.02, -0.03, 0.05);       
			}
			else if (instructCount==8){
				bioInstruct.setTransType(Constants.TRANSLATE);
				bioInstruct.setTranslateMatrix(0.0, -0.04, 0.05);   
			}
			else if (instructCount==9){
				bioInstruct.setTransType(Constants.TRANSLATE);
				bioInstruct.setTranslateMatrix(0.0, 0.00, 0.05);       
			}
			else if (instructCount==10){
				bioInstruct.setTransType(Constants.TRANSLATE);
				bioInstruct.setTranslateMatrix(0.0, 0.00, 0.05);          
			}
			else if (instructCount==11){
				bioInstruct.setTransType(Constants.TRANSLATE);
				bioInstruct.setTranslateMatrix(0.01, -0.02, 0.05);         
			}
			else if (instructCount==12){
				bioInstruct.setTransType(Constants.TRANSLATE);
				bioInstruct.setTranslateMatrix(0.03, -0.03, 0.05);            
			}
			else if (instructCount==13){
				bioInstruct.setTransType(Constants.TRANSLATE);
				bioInstruct.setTranslateMatrix(0.04, -0.02, 0.05);          
			}
			else if (instructCount==14){
				bioInstruct.setTransType(Constants.TRANSLATE);
				bioInstruct.setTranslateMatrix(0.02, -0.04, 0.05);          
			}
			else if (instructCount==15){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.03, -0.03, 0.05);          
			}
			else {
				bioInstruct.setTransType(Constants.TRANSLATE);
				BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, 90);
				bioInstruct.setOrientation(orientationUpd);
				bioInstruct.setTranslateMatrix(0.0, 0.00, 0.05);       
			}
	

			// Add the instruction into the instruction set
    		bioMightInstructSet.addElement(bioInstruct);
		}	
			
		// Pass the instructions to the builder
		body += "<Transform onmouseover=\"showComponent('Dendrite');\" DEF='TRANSFORM_" + bioMightTransform.getId() + "' \n";
	 	body += "translation='" 
		 		+ 0.0 + " " 
				+ 0.0 + " "
				+ 0.0 + "'\n";						
	
		body +=  "rotation='" 
			+ 0 + " "
			+ 0 + " "
			+ 1  + " "
			+ 0.0 + "'>\n";
		
		
		// Pass the instructions to the builder
		genArm = generateIndexFacedComponents(bioMightOrientation, bioMightInstructSet, nuclueiPoints); 
		body += genArm; 	
	
		body += "</Transform>";

		


		// Create the Arm on the Z arm
		double[] nukStartPosZC = {
	    		0.21, 
	    		-0.3, 
	    		-1.45};
		
		nuclueiPoints = BioGraphics.createCylinderInPlane(Constants.ZPLANE, nukStartPosZC, radius, 8);

		bioMightInstructSet = new BioMightInstructSet();
	
		numInstructions = 18;
		//BioMightOrientation bioMightOrientation = new BioMightOrientation(0.0, 0.0, 1.0, 90);
		for (int instructCount=0; instructCount<numInstructions; instructCount++)
		{
			// Create a place for an instruction 
			BioMightInstruction bioInstruct = new BioMightInstruction();
			
			// Place a transform object into each instruction set
			bioInstruct.setBioMightTransform(bioMightTransform);
			
			if (instructCount==0){		
				//BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, -90);
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(20, 20, 20);
				bioInstruct.setTranslateMatrix(0.0, 0.0, 0.002);      
			}
			else if (instructCount==1){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(2.2, 2.2, 2.2);
				bioInstruct.setTranslateMatrix(0.0, 0.0, 0.025); 
			}
			else if (instructCount==2){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.15, 1.1, 1.0);
				bioInstruct.setTranslateMatrix(0.0, 0.00, 0.05);   
			}				
			else if (instructCount==3){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(-0.01, 0.01, 0.05);      
			}
			else if (instructCount==4){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(-0.01, 0.02, 0.05);      
			}
			else if (instructCount==5){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(-0.01, 0.0, 0.05);      
			}
			else if (instructCount==6){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.0, 0.04, 0.05);       
			}
			else if (instructCount==7){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.0, 0.04, 0.05);       
			}
			else if (instructCount==8){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.01, 0.03, 0.05);   
			}
			else if (instructCount==9){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.01, 0.02, 0.05);       
			}
			else if (instructCount==10){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.01, 0.00, 0.05);          
			}
			else if (instructCount==11){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.0, 0.03, 0.05);         
			}
			else if (instructCount==12){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.0, 0.03, 0.05);            
			}
			else if (instructCount==13){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.1, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(-0.03, 0.04, 0.05);          
			}
			else if (instructCount==14){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);	
				bioInstruct.setTranslateMatrix(-0.02, 0.00, 0.05);          
			}
			else if (instructCount==15){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(-0.04, 0.00, 0.05);          
			}
			else if (instructCount==16){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(-0.01, 0.00, 0.05);          
			}
			else if (instructCount==17){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(-0.02, 0.00, 0.05);          
			}
			else if (instructCount==18){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(-0.03, 0.00, 0.05);          
			}
			else if (instructCount==19){
				bioInstruct.setTransType	(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(-0.04, 0.00, 0.05);          
			}

			else {
				bioInstruct.setTransType(Constants.TRANSLATE);
				BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, 90);
				bioInstruct.setOrientation(orientationUpd);
				bioInstruct.setTranslateMatrix(0.0, 0.00, 0.05);       
			}
	

			// Add the instruction into the instruction set
    		bioMightInstructSet.addElement(bioInstruct);
		}	
			
		// Pass the instructions to the builder
		body += "<Transform onmouseover=\"showComponent('Dendrite');\" DEF='TRANSFORM_" + bioMightTransform.getId() + "' \n";
	 	body += "translation='" 
		 		+ 0.0 + " " 
				+ 0.0 + " "
				+ 0.0 + "'\n";						
	
		body +=  "rotation='" 
			+ 0 + " "
			+ 0 + " "
			+ 1  + " "
			+ 0.0 + "'>\n";
		
		
		// Pass the instructions to the builder
		genArm = generateIndexFacedComponents(bioMightOrientation, bioMightInstructSet, nuclueiPoints); 
		body += genArm; 	
	
		body += "</Transform>";
		
		//**********************************
		// Create the Arm on the ZA branch
		//**********************************
		double[] nukStartPosZ2A = {
	    		0.01, 
	    		-0.055, 
	    		-2.2};
		
		nuclueiPoints = BioGraphics.createCylinderInPlane(Constants.ZPLANE, nukStartPosZ2A, radius, 8);

		bioMightInstructSet = new BioMightInstructSet();
	
		numInstructions = 14;
		//BioMightOrientation bioMightOrientation = new BioMightOrientation(0.0, 0.0, 1.0, 90);
		for (int instructCount=0; instructCount<numInstructions; instructCount++)
		{
			// Create a place for an instruction 
			BioMightInstruction bioInstruct = new BioMightInstruction();
			
			// Place a transform object into each instruction set
			bioInstruct.setBioMightTransform(bioMightTransform);
			
			if (instructCount==0){		
				//BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, -90);
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(15, 15, 15);
				bioInstruct.setTranslateMatrix(0.0, 0.0, 0.002);      
			}
			else if (instructCount==1){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.5, 1.5, 1.5);
				bioInstruct.setTranslateMatrix(0.0, 0.0, 0.025); 
			}
			else if (instructCount==2){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.15, 1.1, 1.0);
				bioInstruct.setTranslateMatrix(0.0, 0.00, 0.05);   
			}				
			else if (instructCount==3){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(-0.01, 0.0, 0.05);      
			}
			else if (instructCount==4){
				bioInstruct.setTransType(Constants.TRANSLATE);
				bioInstruct.setTranslateMatrix(-0.01, 0.0, 0.05);      
			}
			else if (instructCount==5){
				bioInstruct.setTransType(Constants.TRANSLATE);
				bioInstruct.setTranslateMatrix(-0.01, 0.0, 0.05);    
			}
			else if (instructCount==6){
				bioInstruct.setTransType(Constants.TRANSLATE);
				bioInstruct.setTranslateMatrix(0.0, 0.02, 0.05);     
			}
			else if (instructCount==7){
				bioInstruct.setTransType(Constants.TRANSLATE);
				bioInstruct.setTranslateMatrix(0.0, 0.01, 0.05);       
			}
			else if (instructCount==8){
				bioInstruct.setTransType(Constants.TRANSLATE);
				bioInstruct.setTranslateMatrix(0.01, 0.01, 0.05);   
			}
			else if (instructCount==9){
				bioInstruct.setTransType(Constants.TRANSLATE);
				bioInstruct.setTranslateMatrix(0.01, 0.00, 0.05);       
			}
			else if (instructCount==10){
				bioInstruct.setTransType(Constants.TRANSLATE);
				bioInstruct.setTranslateMatrix(0.01, 0.02, 0.05);          
			}
			else if (instructCount==11){
				bioInstruct.setTransType(Constants.TRANSLATE);
				bioInstruct.setTranslateMatrix(0.0, 0.00, 0.05);         
			}
			else if (instructCount==12){
				bioInstruct.setTransType(Constants.TRANSLATE);
				bioInstruct.setTranslateMatrix(0.0, 0.00, 0.05);            
			}
			else if (instructCount==13){
				bioInstruct.setTransType(Constants.TRANSLATE);
				bioInstruct.setTranslateMatrix(0.01, 0.00, 0.05);          
			}
			else if (instructCount==14){
				bioInstruct.setTransType(Constants.TRANSLATE);
				bioInstruct.setTranslateMatrix(0.0, 0.02, 0.05);          
			}
			else if (instructCount==15){
				bioInstruct.setTransType(Constants.TRANSLATE);
				bioInstruct.setTranslateMatrix(0.0, 0.0, 0.05);          
			}
			else if (instructCount==16){
				bioInstruct.setTransType(Constants.TRANSLATE);
				bioInstruct.setTranslateMatrix(0.01, 0.00, 0.05);          
			}
			else if (instructCount==17){
				bioInstruct.setTransType(Constants.TRANSLATE);
				bioInstruct.setTranslateMatrix(0.0, 0.00, 0.05);          
			}
			else if (instructCount==18){
				bioInstruct.setTransType(Constants.TRANSLATE);
				bioInstruct.setTranslateMatrix(-0.03, 0.00, 0.05);          
			}
			else if (instructCount==19){
				bioInstruct.setTransType	(Constants.TRANSLATE);
				bioInstruct.setTranslateMatrix(-0.04, 0.00, 0.05);          
			}
			else if (instructCount==20){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.1, 1.1, 1.0);
				bioInstruct.setTranslateMatrix(-0.04, 0.00, 0.05);          
			}
			else if (instructCount==21){
				bioInstruct.setTransType(Constants.TRANSLATE);
				bioInstruct.setTranslateMatrix(-0.03, 0.00, 0.05);          
			}
			else if (instructCount==22){
				bioInstruct.setTransType(Constants.TRANSLATE);
				bioInstruct.setTranslateMatrix(-0.01, 0.00, 0.05);          
			}
			else if (instructCount==23){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(-0.03, 0.00, 0.05);          
			}
			else if (instructCount==24){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(-0.04, 0.00, 0.05);          
			}
			else if (instructCount==25){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.0, 0.00, 0.05);          
			}
			else if (instructCount==26){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(-0.01, 0.00, 0.05);          
			}
			else if (instructCount==27){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(-0.01, 0.00, 0.05);          
			}
			else if (instructCount==28){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(-0.05, 0.00, 0.05);          
			}
			else {
				bioInstruct.setTransType(Constants.TRANSLATE);
				BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, 90);
				bioInstruct.setOrientation(orientationUpd);
				bioInstruct.setTranslateMatrix(0.0, 0.00, 0.05);       
			}
	

			// Add the instruction into the instruction set
    		bioMightInstructSet.addElement(bioInstruct);
		}	
			
		// Pass the instructions to the builder
		body += "<Transform onmouseover=\"showComponent('Dendrite');\" DEF='TRANSFORM_" + bioMightTransform.getId() + "' \n";
	 	body += "translation='" 
		 		+ 0.0 + " " 
				+ 0.0 + " "
				+ 0.0 + "'\n";						
	
		body +=  "rotation='" 
			+ 0 + " "
			+ 0 + " "
			+ 1  + " "
			+ 0.0 + "'>\n";
		
		
		// Pass the instructions to the builder
		genArm = generateIndexFacedComponents(bioMightOrientation, bioMightInstructSet, nuclueiPoints); 
		body += genArm; 	
	
		body += "</Transform>";


		//**********************************
		// Create the Arm on the ZA branch
		//**********************************
		double[] nukStartPosZ2B = {
	    		-0.2, 
	    		 0.25, 
	    		-2.2};
		
		nuclueiPoints = BioGraphics.createCylinderInPlane(Constants.ZPLANE, nukStartPosZ2B, radius, 8);

		bioMightInstructSet = new BioMightInstructSet();
	
		numInstructions = 14;
		//BioMightOrientation bioMightOrientation = new BioMightOrientation(0.0, 0.0, 1.0, 90);
		for (int instructCount=0; instructCount<numInstructions; instructCount++)
		{
			// Create a place for an instruction 
			BioMightInstruction bioInstruct = new BioMightInstruction();
			
			// Place a transform object into each instruction set
			bioInstruct.setBioMightTransform(bioMightTransform);
			
			if (instructCount==0){		
				//BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, -90);
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(15, 15, 15);
				bioInstruct.setTranslateMatrix(0.0, 0.0, 0.002);      
			}
			else if (instructCount==1){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.5, 1.5, 1.5);
				bioInstruct.setTranslateMatrix(0.0, 0.0, 0.025); 
			}
			else if (instructCount==2){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.15, 1.1, 1.0);
				bioInstruct.setTranslateMatrix(0.0, -0.03, 0.05);   
			}				
			else if (instructCount==3){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.0, -0.02, 0.05);      
			}
			else if (instructCount==4){
				bioInstruct.setTransType(Constants.TRANSLATE);
				bioInstruct.setTranslateMatrix(0.01, -0.04, 0.05);      
			}
			else if (instructCount==5){
				bioInstruct.setTransType(Constants.TRANSLATE);
				bioInstruct.setTranslateMatrix(0.02, -0.02, 0.05);    
			}
			else if (instructCount==6){
				bioInstruct.setTransType(Constants.TRANSLATE);
				bioInstruct.setTranslateMatrix(0.04, -0.02, 0.05);     
			}
			else if (instructCount==7){
				bioInstruct.setTransType(Constants.TRANSLATE);
				bioInstruct.setTranslateMatrix(0.03, -0.03, 0.05);       
			}
			else if (instructCount==8){
				bioInstruct.setTransType(Constants.TRANSLATE);
				bioInstruct.setTranslateMatrix(0.01, -0.02, 0.05);   
			}
			else if (instructCount==9){
				bioInstruct.setTransType(Constants.TRANSLATE);
				bioInstruct.setTranslateMatrix(0.0, -0.02, 0.05);       
			}
			else if (instructCount==10){
				bioInstruct.setTransType(Constants.TRANSLATE);
				bioInstruct.setTranslateMatrix(0.0, -0.02, 0.05);          
			}
			else if (instructCount==11){
				bioInstruct.setTransType(Constants.TRANSLATE);
				bioInstruct.setTranslateMatrix(0.02, -0.01, 0.05);         
			}
			else if (instructCount==12){
				bioInstruct.setTransType(Constants.TRANSLATE);
				bioInstruct.setTranslateMatrix(0.04, 0.00, 0.05);            
			}
			else if (instructCount==13){
				bioInstruct.setTransType(Constants.TRANSLATE);
				bioInstruct.setTranslateMatrix(0.03, -0.01, 0.05);          
			}
			else {
				bioInstruct.setTransType(Constants.TRANSLATE);
				BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, 90);
				bioInstruct.setOrientation(orientationUpd);
				bioInstruct.setTranslateMatrix(0.0, 0.00, 0.05);       
			}
	

			// Add the instruction into the instruction set
    		bioMightInstructSet.addElement(bioInstruct);
		}	
			
		// Pass the instructions to the builder
		body += "<Transform onmouseover=\"showComponent('Dendrite');\" DEF='TRANSFORM_" + bioMightTransform.getId() + "' \n";
	 	body += "translation='" 
		 		+ 0.0 + " " 
				+ 0.0 + " "
				+ 0.0 + "'\n";						
	
		body +=  "rotation='" 
			+ 0 + " "
			+ 0 + " "
			+ 1  + " "
			+ 0.0 + "'>\n";
		
		
		// Pass the instructions to the builder
		genArm = generateIndexFacedComponents(bioMightOrientation, bioMightInstructSet, nuclueiPoints); 
		body += genArm; 	
	
		body += "</Transform>";


		
		//**********************************
		// Create the Arm on the -XA branch
		//**********************************
		double[] nukStartPosX2C = {
	    		-2.06, 
	    		-0.18, 
	    		0.06};
		
		nuclueiPoints = BioGraphics.createCylinderInPlane(Constants.XPLANE, nukStartPosX2C, radius, 8);

		bioMightInstructSet = new BioMightInstructSet();
	
		numInstructions = 14;
		//BioMightOrientation bioMightOrientation = new BioMightOrientation(0.0, 0.0, 1.0, 90);
		for (int instructCount=0; instructCount<numInstructions; instructCount++)
		{
			// Create a place for an instruction 
			BioMightInstruction bioInstruct = new BioMightInstruction();
			
			// Place a transform object into each instruction set
			bioInstruct.setBioMightTransform(bioMightTransform);
			
			
			if (instructCount==0){		
				//BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, -90);
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(15, 15, 15);
				bioInstruct.setTranslateMatrix(0.002, 0.0, 0.0);      
			}
			else if (instructCount==1){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.5, 1.5, 1.5);
				bioInstruct.setTranslateMatrix(0.025, 0.0, 0.00); 
			}
			else if (instructCount==2){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.15, 1.1, 1.0);
				bioInstruct.setTranslateMatrix(0.05, 0.0, 0.0);   
			}				
			else if (instructCount==3){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.05, 0.0, 0.02);      
			}
			else if (instructCount==4){
				bioInstruct.setTransType(Constants.TRANSLATE);
				bioInstruct.setTranslateMatrix(0.05, 0.01, 0.01);      
			}
			else if (instructCount==5){
				bioInstruct.setTransType(Constants.TRANSLATE);
				bioInstruct.setTranslateMatrix(0.05, 0.02, 0.02);    
			}
			else if (instructCount==6){
				bioInstruct.setTransType(Constants.TRANSLATE);
				bioInstruct.setTranslateMatrix(0.05, 0.03, 0.0);     
			}
			else if (instructCount==7){
				bioInstruct.setTransType(Constants.TRANSLATE);
				bioInstruct.setTranslateMatrix(0.05, 0.0, -0.02);       
			}
			else if (instructCount==8){
				bioInstruct.setTransType(Constants.TRANSLATE);
				bioInstruct.setTranslateMatrix(0.05, 0.0, -0.02);   
			}
			else if (instructCount==9){
				bioInstruct.setTransType(Constants.TRANSLATE);
				bioInstruct.setTranslateMatrix(0.05, 0.02, -0.02);       
			}
			else if (instructCount==10){
				bioInstruct.setTransType(Constants.TRANSLATE);
				bioInstruct.setTranslateMatrix(0.05, 0.03, 0.0);          
			}
			else if (instructCount==11){
				bioInstruct.setTransType(Constants.TRANSLATE);
				bioInstruct.setTranslateMatrix(0.05, 0.03, -0.01);         
			}
			else if (instructCount==12){
				bioInstruct.setTransType(Constants.TRANSLATE);
				bioInstruct.setTranslateMatrix(0.05, 0.02, -0.03);            
			}
			else if (instructCount==13){
				bioInstruct.setTransType(Constants.TRANSLATE);
				bioInstruct.setTranslateMatrix(0.05, 0.03, -0.02);          
			}
			else {
				bioInstruct.setTransType(Constants.TRANSLATE);
				BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, 90);
				bioInstruct.setOrientation(orientationUpd);
				bioInstruct.setTranslateMatrix(0.0, 0.00, 0.05);       
			}
	

			// Add the instruction into the instruction set
    		bioMightInstructSet.addElement(bioInstruct);
		}	
			
		// Pass the instructions to the builder
		body += "<Transform onmouseover=\"showComponent('Dendrite');\" DEF='TRANSFORM_" + bioMightTransform.getId() + "' \n";
	 	body += "translation='" 
		 		+ 0.0 + " " 
				+ 0.0 + " "
				+ 0.0 + "'\n";						
	
		body +=  "rotation='" 
			+ 0 + " "
			+ 0 + " "
			+ 1  + " "
			+ 0.0 + "'>\n";
		
		
		// Pass the instructions to the builder
		genArm = generateIndexFacedComponents(bioMightOrientation, bioMightInstructSet, nuclueiPoints); 
		body += genArm; 	
	
		body += "</Transform>";


		//**********************************
		// Create the Arm on the -XA branch
		//**********************************
		double[] nukStartPosX2D = {
	    		-2.07, 
	    		0.25, 
	    		0.06};
		
		nuclueiPoints = BioGraphics.createCylinderInPlane(Constants.XPLANE, nukStartPosX2D, radius, 8);

		bioMightInstructSet = new BioMightInstructSet();
	
		numInstructions = 14;
		//BioMightOrientation bioMightOrientation = new BioMightOrientation(0.0, 0.0, 1.0, 90);
		for (int instructCount=0; instructCount<numInstructions; instructCount++)
		{
			// Create a place for an instruction 
			BioMightInstruction bioInstruct = new BioMightInstruction();
			
			// Place a transform object into each instruction set
			bioInstruct.setBioMightTransform(bioMightTransform);
			
			if (instructCount==0){		
				//BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, -90);
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(15, 15, 15);
				bioInstruct.setTranslateMatrix(0.002, 0.0, 0.0);      
			}
			else if (instructCount==1){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.5, 1.5, 1.5);
				bioInstruct.setTranslateMatrix(0.025, 0.0, 0.00); 
			}
			else if (instructCount==2){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.15, 1.1, 1.0);
				bioInstruct.setTranslateMatrix(0.05, 0.0, 0.0);   
			}				
			else if (instructCount==3){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.05, 0.0, 0.02);      
			}
			else if (instructCount==4){
				bioInstruct.setTransType(Constants.TRANSLATE);
				bioInstruct.setTranslateMatrix(0.05, -0.01, 0.01);      
			}
			else if (instructCount==5){
				bioInstruct.setTransType(Constants.TRANSLATE);
				bioInstruct.setTranslateMatrix(0.05, -0.03, 0.02);    
			}
			else if (instructCount==6){
				bioInstruct.setTransType(Constants.TRANSLATE);
				bioInstruct.setTranslateMatrix(0.05, -0.03, 0.0);     
			}
			else if (instructCount==7){
				bioInstruct.setTransType(Constants.TRANSLATE);
				bioInstruct.setTranslateMatrix(0.05, -0.04, -0.02);       
			}
			else if (instructCount==8){
				bioInstruct.setTransType(Constants.TRANSLATE);
				bioInstruct.setTranslateMatrix(0.05, 0.0, -0.02);   
			}
			else if (instructCount==9){
				bioInstruct.setTransType(Constants.TRANSLATE);
				bioInstruct.setTranslateMatrix(0.05, -0.03, -0.02);       
			}
			else if (instructCount==10){
				bioInstruct.setTransType(Constants.TRANSLATE);
				bioInstruct.setTranslateMatrix(0.05, -0.03, 0.0);          
			}
			else if (instructCount==11){
				bioInstruct.setTransType(Constants.TRANSLATE);
				bioInstruct.setTranslateMatrix(0.05, -0.03, -0.01);         
			}
			else if (instructCount==12){
				bioInstruct.setTransType(Constants.TRANSLATE);
				bioInstruct.setTranslateMatrix(0.05, -0.02, -0.03);            
			}
			else if (instructCount==13){
				bioInstruct.setTransType(Constants.TRANSLATE);
				bioInstruct.setTranslateMatrix(0.05, -0.03, -0.02);          
			}
			else {
				bioInstruct.setTransType(Constants.TRANSLATE);
				BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, 90);
				bioInstruct.setOrientation(orientationUpd);
				bioInstruct.setTranslateMatrix(0.0, 0.00, 0.05);       
			}
	

			// Add the instruction into the instruction set
    		bioMightInstructSet.addElement(bioInstruct);
		}	
			
		// Pass the instructions to the builder
		body += "<Transform onmouseover=\"showComponent('Dendrite');\" DEF='TRANSFORM_" + bioMightTransform.getId() + "' \n";
	 	body += "translation='" 
		 		+ 0.0 + " " 
				+ 0.0 + " "
				+ 0.0 + "'\n";						
	
		body +=  "rotation='" 
			+ 0 + " "
			+ 0 + " "
			+ 1  + " "
			+ 0.0 + "'>\n";
		
		
		// Pass the instructions to the builder
		genArm = generateIndexFacedComponents(bioMightOrientation, bioMightInstructSet, nuclueiPoints); 
		body += genArm; 	
	
		body += "</Transform>";
	

		//**********************************
		// Create the Arm on the -XA branch
		//**********************************
		double[] nukStartPosY2D = {
	    		0.23, 
	    		-2.1, 
	    		0.2};
		
		nuclueiPoints = BioGraphics.createCylinderInPlane(Constants.YPLANE, nukStartPosY2D, radius, 8);

		bioMightInstructSet = new BioMightInstructSet();
	
		numInstructions = 14;
		//BioMightOrientation bioMightOrientation = new BioMightOrientation(0.0, 0.0, 1.0, 90);
		for (int instructCount=0; instructCount<numInstructions; instructCount++)
		{
			// Create a place for an instruction 
			BioMightInstruction bioInstruct = new BioMightInstruction();
			
			// Place a transform object into each instruction set
			bioInstruct.setBioMightTransform(bioMightTransform);
			
			if (instructCount==0){		
				//BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, -90);
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(15, 15, 15);
				bioInstruct.setTranslateMatrix(0.00, 0.002, 0.0);      
			}
			else if (instructCount==1){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.5, 1.5, 1.5);
				bioInstruct.setTranslateMatrix(0.0, 0.025, 0.00); 
			}
			else if (instructCount==2){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.15, 1.1, 1.0);
				bioInstruct.setTranslateMatrix(0.0, 0.05, 0.0);   
			}				
			else if (instructCount==3){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(-0.01, 0.05, -0.02);      
			}
			else if (instructCount==4){
				bioInstruct.setTransType(Constants.TRANSLATE);
				bioInstruct.setTranslateMatrix(-0.03, 0.05, 0.00);      
			}
			else if (instructCount==5){
				bioInstruct.setTransType(Constants.TRANSLATE);
				bioInstruct.setTranslateMatrix(-0.02, 0.05, -0.03);    
			}
			else if (instructCount==6){
				bioInstruct.setTransType(Constants.TRANSLATE);
				bioInstruct.setTranslateMatrix(-0.03, 0.05, -0.02);      
			}
			else if (instructCount==7){
				bioInstruct.setTransType(Constants.TRANSLATE);
				bioInstruct.setTranslateMatrix(-0.04, 0.05, 0.00);       
			}
			else if (instructCount==8){
				bioInstruct.setTransType(Constants.TRANSLATE);
				bioInstruct.setTranslateMatrix(-0.03, 0.05, -0.03);  
			}
			else if (instructCount==9){
				bioInstruct.setTransType(Constants.TRANSLATE);
				bioInstruct.setTranslateMatrix(-0.04, 0.05, -0.04);        
			}
			else if (instructCount==10){
				bioInstruct.setTransType(Constants.TRANSLATE);
				bioInstruct.setTranslateMatrix(0.0, 0.05, -0.03);            
			}
			else if (instructCount==11){
				bioInstruct.setTransType(Constants.TRANSLATE);
				bioInstruct.setTranslateMatrix(-0.01, 0.05, 0.00);           
			}
			else if (instructCount==12){
				bioInstruct.setTransType(Constants.TRANSLATE);
				bioInstruct.setTranslateMatrix(-0.01, 0.05, -0.03);              
			}
			else if (instructCount==13){
				bioInstruct.setTransType(Constants.TRANSLATE);
				bioInstruct.setTranslateMatrix(-0.01, 0.05, 0.00);            
			}
			else {
				bioInstruct.setTransType(Constants.TRANSLATE);
				BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, 90);
				bioInstruct.setOrientation(orientationUpd);
				bioInstruct.setTranslateMatrix(0.0, 0.00, 0.05);       
			}
	

			// Add the instruction into the instruction set
    		bioMightInstructSet.addElement(bioInstruct);
		}	
			
		// Pass the instructions to the builder
		body += "<Transform onmouseover=\"showComponent('Dendrite');\" DEF='TRANSFORM_" + bioMightTransform.getId() + "' \n";
	 	body += "translation='" 
		 		+ 0.0 + " " 
				+ 0.0 + " "
				+ 0.0 + "'\n";						
	
		body +=  "rotation='" 
			+ 0 + " "
			+ 0 + " "
			+ 1  + " "
			+ 0.0 + "'>\n";
		
		
		// Pass the instructions to the builder
		genArm = generateIndexFacedComponents(bioMightOrientation, bioMightInstructSet, nuclueiPoints); 
		body += genArm; 	
	
		body += "</Transform>";
		
		//**********************************
		// Create the Arm on the -XA branch
		//**********************************
		double[] nukStartPosY2A = {
	    		-0.27, 
	    		-2.2, 
	    		0.20};
		
		nuclueiPoints = BioGraphics.createCylinderInPlane(Constants.YPLANE, nukStartPosY2A, radius, 8);

		bioMightInstructSet = new BioMightInstructSet();
	
		numInstructions = 17;
		//BioMightOrientation bioMightOrientation = new BioMightOrientation(0.0, 0.0, 1.0, 90);
		for (int instructCount=0; instructCount<numInstructions; instructCount++)
		{
			// Create a place for an instruction 
			BioMightInstruction bioInstruct = new BioMightInstruction();
			
			// Place a transform object into each instruction set
			bioInstruct.setBioMightTransform(bioMightTransform);
			
			// Place a transform object into each instruction set
			bioInstruct.setBioMightTransform(bioMightTransform);
			
			if (instructCount==0){		
				//BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, -90);
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(15, 15, 15);
				bioInstruct.setTranslateMatrix(0.0, 0.002, 0.0);      
			}
			else if (instructCount==1){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.5, 1.5, 1.5);
				bioInstruct.setTranslateMatrix(0.0, 0.025, 0.00); 
			}
			else if (instructCount==2){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.15, 1.1, 1.0);
				bioInstruct.setTranslateMatrix(0.0, 0.05, 0.0);   
			}				
			else if (instructCount==3){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.0, 0.05, -0.02);      
			}
			else if (instructCount==4){
				bioInstruct.setTransType(Constants.TRANSLATE);
				bioInstruct.setTranslateMatrix(0.0, 0.05, 0.00);      
			}
			else if (instructCount==5){
				bioInstruct.setTransType(Constants.TRANSLATE);
				bioInstruct.setTranslateMatrix(0.01, 0.05, -0.03);    
			}
			else if (instructCount==6){
				bioInstruct.setTransType(Constants.TRANSLATE);
				bioInstruct.setTranslateMatrix(0.01, 0.05, -0.02);      
			}
			else if (instructCount==7){
				bioInstruct.setTransType(Constants.TRANSLATE);
				bioInstruct.setTranslateMatrix(0.01, 0.05, 0.00);       
			}
			else if (instructCount==8){
				bioInstruct.setTransType(Constants.TRANSLATE);
				bioInstruct.setTranslateMatrix(0.0, 0.05, -0.03);  
			}
			else if (instructCount==9){
				bioInstruct.setTransType(Constants.TRANSLATE);
				bioInstruct.setTranslateMatrix(0.0, 0.05, -0.04);        
			}
			else if (instructCount==10){
				bioInstruct.setTransType(Constants.TRANSLATE);
				bioInstruct.setTranslateMatrix(0.04, 0.05, -0.03);            
			}
			else if (instructCount==11){
				bioInstruct.setTransType(Constants.TRANSLATE);
				bioInstruct.setTranslateMatrix(0.03, 0.05, 0.00);           
			}
			else if (instructCount==12){
				bioInstruct.setTransType(Constants.TRANSLATE);
				bioInstruct.setTranslateMatrix(0.04, 0.05, -0.03);              
			}
			else if (instructCount==13){
				bioInstruct.setTransType(Constants.TRANSLATE);
				bioInstruct.setTranslateMatrix(0.05, 0.05, 0.00);            
			}
			else if (instructCount==14){
				bioInstruct.setTransType(Constants.TRANSLATE);
				bioInstruct.setTranslateMatrix(0.03, 0.05, 0.00);            
			}
			else if (instructCount==15){
				bioInstruct.setTransType(Constants.TRANSLATE);
				bioInstruct.setTranslateMatrix(0.04, 0.05, 0.00);            
			}
			else if (instructCount==16){
				bioInstruct.setTransType(Constants.TRANSLATE);
				bioInstruct.setTranslateMatrix(0.0, 0.05, 0.00);            
			}
			else {
				bioInstruct.setTransType(Constants.TRANSLATE);
				BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, 90);
				bioInstruct.setOrientation(orientationUpd);
				bioInstruct.setTranslateMatrix(0.0, 0.00, 0.05);       
			}
	

			// Add the instruction into the instruction set
    		bioMightInstructSet.addElement(bioInstruct);
		}	
			
		// Pass the instructions to the builder
		body += "<Transform onmouseover=\"showComponent('Dendrite');\" DEF='TRANSFORM_" + bioMightTransform.getId() + "' \n";
	 	body += "translation='" 
		 		+ 0.0 + " " 
				+ 0.0 + " "
				+ 0.0 + "'\n";						
	
		body +=  "rotation='" 
			+ 0 + " "
			+ 0 + " "
			+ 1  + " "
			+ 0.0 + "'>\n";
		
		
		// Pass the instructions to the builder
		genArm = generateIndexFacedComponents(bioMightOrientation, bioMightInstructSet, nuclueiPoints); 
		body += genArm; 	
	
		body += "</Transform>";
	
		
		
		return (body);		
		
	}
  	

	/***********************************************************************************************************************
  	 * GENERATE AXON
  	 * 
  	 * Creates Axon using an Indexed Faced Set
  	 * 
  	 * @param bioMightTransform
  	 * @param currentPoints
  	 * @param bHeader
  	 * @param bFooter
  	 * @param diffColor
  	 * @return
  	 * 
  	 ***********************************************************************************************************************/
	
  	public static String generateAxon(BioMightTransform bioMightTransform,  BioMightPosition startPos, BioMightOrientation bioMightOrientation) 	
	{		
	  	String body = "";			
		//double xStartPos = startPos.getXPos(); 
		//double yStartPos = startPos.getYPos(); 
		//double zStartPos = startPos.getZPos();
		System.out.println("\nGenerateAxon(): ");
			

	  	double radius = 0.000625;
	
		// Create the Arm that has the Axon attached
		double[] axonStartPos = {
	    		0.0, 
	    		0, 
	    		3.7 };
		
		double[][] nuclueiPoints = BioGraphics.createCylinderInPlane(Constants.ZPLANE, axonStartPos, radius, 8);

		BioMightInstructSet bioMightInstructSet = new BioMightInstructSet();
	
		int numInstructions = 67;
		//BioMightOrientation bioMightOrientation = new BioMightOrientation(0.0, 0.0, 1.0, 90);
		for (int instructCount=0; instructCount<numInstructions; instructCount++)
		{
			// Create a place for an instruction 
			BioMightInstruction bioInstruct = new BioMightInstruction();
			
			// Place a transform object into each instruction set
			bioInstruct.setBioMightTransform(bioMightTransform);
			
			bioMightTransform = new BioMightTransform();
			bioMightTransform.setTextureID(5);
			bioMightTransform.setTextureFile("SpeckledAmethyst.png");
			bioMightTransform.setComponentName("Axon");
		    bioMightTransform.getMaterial().setTransparency(0.20);
		    
			// Place a transform object into each instruction set
			bioInstruct.setBioMightTransform(bioMightTransform);
			
			
			if (instructCount==0){		
				//BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, -90);
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(20, 20, 20);
				bioInstruct.setTranslateMatrix(0.0, 0.0, -0.002);      
			}
			else if (instructCount==1){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(2, 2, 2);
				bioInstruct.setTranslateMatrix(0.0, 0.0, -0.025); 
			}
			else if (instructCount==2){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.15, 1.1, 1.0);
				bioInstruct.setTranslateMatrix(0.0, 0.00, -0.05);   
			}				
			else if (instructCount==3){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.1, 1.1, 1.0);
				bioInstruct.setTranslateMatrix(0.01, 0.0, -0.05);      
			}
			else if (instructCount==4){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.1, 1.1, 1.0);
				bioInstruct.setTranslateMatrix(0.01, 0.0, -0.05);      
			}
			else if (instructCount==5){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.01, 0.0, -0.05);      
			}
			else if (instructCount==6){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.0, 0.00, -0.05);       
			}
			else if (instructCount==7){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.0, 0.00, -0.05);       
			}
			else if (instructCount==8){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(-0.01, 0.00, -0.05);   
			}
			else if (instructCount==9){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(-0.01, 0.00, -0.05);       
			}
			else if (instructCount==10){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(-0.01, 0.00, -0.05);          
			}
			else if (instructCount==11){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.0, 0.00, -0.05);         
			}
			else if (instructCount==12){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.0, 0.00, -0.05);            
			}
			else if (instructCount==13){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.0, 0.00, -0.05);          
			}
			else if (instructCount==14){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.0, 0.00, -0.05);          
			}
			else if (instructCount==15){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.01, 0.00, -0.05);       
			}
			else if (instructCount==16){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.01, 0.00, -0.05);       
			}
			else if (instructCount==17){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.02, 0.00, -0.05);       
			}
			else if (instructCount==18){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.01, 0.00, -0.05);       
			}
			else if (instructCount==19){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.02, 0.00, -0.05);       
			}
			else if (instructCount==20){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.02, 0.00, -0.05);       
			}
			else if (instructCount==21){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.01, 0.00, -0.05);       
			}
			else if (instructCount==22){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.01, 0.00, -0.05);       
			}			
			else if (instructCount==23){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.0, 0.00, -0.05);       
			}
			else if (instructCount==24){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.0, 0.00, -0.05);       
			}
			else if (instructCount==25){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(-0.01, 0.00, -0.05);       
			}
			else if (instructCount==26){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.01, 0.00, -0.05);    
			}
			else if (instructCount==27){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.01, 0.00, -0.05);       
			}
			else if (instructCount==28){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.01, 0.00, -0.05);       
			}
			else if (instructCount==29){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.1, 1.1, 1.0);
				bioInstruct.setTranslateMatrix(0.0, 0.00, -0.05);            
			}
			else if (instructCount==30){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(-0.01, 0.00, -0.05);          
			}
			else if (instructCount==31){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(-0.01, 0.00, -0.05);           
			}
			else if (instructCount==32){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(-0.02, 0.00, -0.05);        
			}
			else if (instructCount==33){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(-0.01, 0.00, -0.05);            
			}
			else if (instructCount==34){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(-0.01, 0.00, -0.05);         
			}
			else if (instructCount==35){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.0, 0.00, -0.05);         
			}
			else if (instructCount==36){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.0, 0.00, -0.05);        
			}
			else if (instructCount==37){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.0, 0.00, -0.05);          
			}
			else if (instructCount==38){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.0, 0.00, -0.05);          
			}
			else if (instructCount==39){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.0, 0.00, -0.05);          
			}
			else if (instructCount==40){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.0, 0.00, -0.05);          
			}
			else if (instructCount==41){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.0, 0.00, -0.05);          
			}
			else if (instructCount==42){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.0, 0.00, -0.05);          
			}
			else if (instructCount==43){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.0, 0.00, -0.05);          
			}
			else if (instructCount==44){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.0, 0.00, -0.05);          
			}
			else if (instructCount==45){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(-0.01, 0.00, -0.05);          
			}
			else if (instructCount==46){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(-0.01, 0.00, -0.05);          
			}
			else if (instructCount==47){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(-0.01, 0.00, -0.05);          
			}
			else if (instructCount==48){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.1, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(-0.01, 0.00, -0.05);          
			}
			else if (instructCount==48){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.1, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.0, 0.00, -0.05);          
			}
			else if (instructCount==49){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.1, 1.1, 1.0);
				bioInstruct.setTranslateMatrix(0.0, 0.00, -0.05);          
			}
			else if (instructCount==50){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.1, 1.1, 1.0);
				bioInstruct.setTranslateMatrix(-0.01, 0.00, -0.05);          
			}
			else if (instructCount==51){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.1, 1.1, 1.0);
				bioInstruct.setTranslateMatrix(0.0, 0.00, -0.05);          
			}
			else if (instructCount==52){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.1, 1.1, 1.0);
				bioInstruct.setTranslateMatrix(0.0, 0.00, -0.05);          
			}
			else if (instructCount==53){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.15, 1.1, 1.0);
				bioInstruct.setTranslateMatrix(0.0, 0.00, -0.05);          
			}
			else if (instructCount==54){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.15, 1.1, 1.0);
				bioInstruct.setTranslateMatrix(0.0, 0.00, -0.05);          
			}
			else if (instructCount==55){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.15, 1.1, 1.0);
				bioInstruct.setTranslateMatrix(0.0, 0.00, -0.05);          
			}
			else if (instructCount==56){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.15, 1.1, 1.0);
				bioInstruct.setTranslateMatrix(0.0, 0.00, -0.05);          
			}
			else if (instructCount==57){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.15, 1.1, 1.0);
				bioInstruct.setTranslateMatrix(0.0, 0.00, -0.05);   
				
				bioMightTransform.setComponentName("Axon Hilus");
				bioInstruct.setBioMightTransform(bioMightTransform);
			}
			else if (instructCount==58){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.12, 1.1, 1.0);
				bioInstruct.setTranslateMatrix(0.0, 0.00, -0.05);   
				
				bioMightTransform.setComponentName("Axon Hilus");
				bioInstruct.setBioMightTransform(bioMightTransform);
			}
			else if (instructCount==59){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.12, 1.1, 1.0);
				bioInstruct.setTranslateMatrix(0.0, 0.00, -0.05);   
				
				bioMightTransform.setComponentName("Axon Hilus");
				bioInstruct.setBioMightTransform(bioMightTransform);
			}
			else if (instructCount==60){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.12, 1.1, 1.0);
				bioInstruct.setTranslateMatrix(0.0, 0.00, -0.05);   
				
				bioMightTransform.setComponentName("Axon Hilus");
				bioInstruct.setBioMightTransform(bioMightTransform);
			}
			else if (instructCount==61){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.1, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.0, 0.00, -0.05);   
				
				bioMightTransform.setComponentName("Axon Hilus");
				bioInstruct.setBioMightTransform(bioMightTransform);
			}
			else if (instructCount==62){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.1, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.0, 0.00, -0.05);   
				
				bioMightTransform.setComponentName("Axon Hilus");
				bioInstruct.setBioMightTransform(bioMightTransform);
			}
			else if (instructCount==63){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.1, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.0, 0.00, -0.05);          

				bioMightTransform.setComponentName("Axon Hilus");
				bioInstruct.setBioMightTransform(bioMightTransform);
			}
			else if (instructCount==64){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.1, 1.1, 1.0);
				bioInstruct.setTranslateMatrix(0.0, 0.00, -0.05);   
				
				bioMightTransform.setComponentName("Axon Hilus");
				bioInstruct.setBioMightTransform(bioMightTransform);
			}
			else if (instructCount==65){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.1, 1.1, 1.0);
				bioInstruct.setTranslateMatrix(0.0, 0.00, -0.05);
				
				bioMightTransform.setComponentName("Axon Hilus");
				bioInstruct.setBioMightTransform(bioMightTransform);
			}
			else if (instructCount==66){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.15, 1.1, 1.0);
				bioInstruct.setTranslateMatrix(0.0, 0.00, -0.05);
				
				bioMightTransform.setComponentName("Axon Hilus");
				bioInstruct.setBioMightTransform(bioMightTransform);
			}
			else {
				bioInstruct.setTransType(Constants.TRANSLATE);
				BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, 90);
				bioInstruct.setOrientation(orientationUpd);
				bioInstruct.setTranslateMatrix(0.0, -0.05, 0.0);       
			}
	

			// Add the instruction into the instruction set
    		bioMightInstructSet.addElement(bioInstruct);
		}	
			
		
		// Pass the instructions to the builder
		bioMightTransform.setComponentName("Axon");
		String genArm = generateIndexFacedComponents(bioMightOrientation, bioMightInstructSet, nuclueiPoints); 
		body += genArm; 	
		
		return (body);
	}
  	
	/***********************************************************************************************************************
  	 * GENERATE MYELIN 
  	 * 
  	 * Creates Myelin using an Indexed Faced Set
  	 * 
  	 * @param bioMightTransform
  	 * @param currentPoints
  	 * @param bHeader
  	 * @param bFooter
  	 * @param diffColor
  	 * @return
  	 * 
  	 ***********************************************************************************************************************/
	
  	public static String generateMyelin(BioMightTransform bioMightTransform,  BioMightPosition startPos, BioMightOrientation bioMightOrientation) 	
	{		
	  	String body = "";			
		//double xStartPos = startPos.getXPos(); 
		//double yStartPos = startPos.getYPos(); 
		//double zStartPos = startPos.getZPos();
		System.out.println("\nGenerateMyelin(): ");
					
	  	//double radius = 0.001;
	  	double radius = 0.000625;
		
		// Create the Arm that has the Axon attached
		double[] axonStartPos = {
	    		0.0, 
	    		0, 
	    		3.7 };
		
		double[][] nuclueiPoints = BioGraphics.createCylinderInPlane(Constants.ZPLANE, axonStartPos, radius, 8);

		BioMightInstructSet bioMightInstructSet = new BioMightInstructSet();
	
		int numInstructions = 58;
		//BioMightOrientation bioMightOrientation = new BioMightOrientation(0.0, 0.0, 1.0, 90);
		for (int instructCount=0; instructCount<numInstructions; instructCount++)
		{
			// Create a place for an instruction 
			BioMightInstruction bioInstruct = new BioMightInstruction();

			// Set the color and texture back to the default value
			bioMightTransform = new BioMightTransform();
			bioMightTransform.setTextureID(5);
			bioMightTransform.setTextureFile("PowderBlue.png");
			bioMightTransform.setComponentName("Myelin Sheath");
		    bioMightTransform.getMaterial().setTransparency(0.20);
		    
			// Place a transform object into each instruction set
			bioInstruct.setBioMightTransform(bioMightTransform);
			
		
			if (instructCount==0){		
				//BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, -90);
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(20, 20, 20);
				bioInstruct.setTranslateMatrix(0.0, 0.0, -0.002);

				bioMightTransform.setTextureID(5);
				bioMightTransform.setTextureFile("StaphylococcusAureus.png");
				bioMightTransform.setComponentName("Axon");
				bioInstruct.setBioMightTransform(bioMightTransform);
			}
			else if (instructCount==1){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(2, 2, 2);
				bioInstruct.setTranslateMatrix(0.0, 0.0, -0.025); 

				bioMightTransform.setTextureID(5);
				bioMightTransform.setTextureFile("StaphylococcusAureus.png");
				bioMightTransform.setComponentName("Axon");
				bioInstruct.setBioMightTransform(bioMightTransform);
			}
			else if (instructCount==2){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.15, 1.1, 1.0);
				bioInstruct.setTranslateMatrix(0.0, 0.00, -0.05);
				
				bioMightTransform.setTextureID(5);
				bioMightTransform.setTextureFile("StaphylococcusAureus.png");
				bioMightTransform.setComponentName("Axon");
				bioInstruct.setBioMightTransform(bioMightTransform);
			}				
			else if (instructCount==3){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.1, 1.1, 1.0);
				bioInstruct.setTranslateMatrix(0.01, 0.0, -0.05);
				
				bioMightTransform.setTextureID(5);
				bioMightTransform.setTextureFile("StaphylococcusAureus.png");
				bioMightTransform.setComponentName("Axon");
				bioInstruct.setBioMightTransform(bioMightTransform);
			}
			else if (instructCount==4){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.1, 1.1, 1.0);
				bioInstruct.setTranslateMatrix(0.01, 0.0, -0.05);
				
				bioMightTransform.setTextureID(5);
				bioMightTransform.setTextureFile("StaphylococcusAureus.png");
				bioMightTransform.setComponentName("Axon");
				bioInstruct.setBioMightTransform(bioMightTransform);
			}
			else if (instructCount==5){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(2.5, 2.5, 1.0);
				bioInstruct.setTranslateMatrix(0.01, 0.0, -0.05);			
				}
			else if (instructCount==6){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.0, 0.00, -0.05);       
			}
			else if (instructCount==7){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.0, 0.00, -0.05);       
			}
			else if (instructCount==8){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(-0.01, 0.00, -0.05);   
			}
			else if (instructCount==9){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(0.45, 0.45, 1.0);
				bioInstruct.setTranslateMatrix(-0.01, 0.00, -0.05);       	
			}
			else if (instructCount==10){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(-0.01, 0.00, -0.05);          
		
				bioMightTransform.setTextureID(5);
				bioMightTransform.setTextureFile("StaphylococcusAureus.png");
				bioMightTransform.setComponentName("Node of Ranvier");
				bioInstruct.setBioMightTransform(bioMightTransform);		
			}
			else if (instructCount==11){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(2.5, 2.5, 1.0);
				bioInstruct.setTranslateMatrix(0.0, 0.00, -0.05);         
			}
			else if (instructCount==12){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.0, 0.00, -0.05);            
			}
			else if (instructCount==13){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.0, 0.00, -0.05);          
			}
			else if (instructCount==14){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.0, 0.00, -0.05);          
			}
			else if (instructCount==15){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.01, 0.00, -0.05);       
			}
			else if (instructCount==16){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(0.4, 0.4, 1.0);
				bioInstruct.setTranslateMatrix(0.01, 0.00, -0.05);
			}
			else if (instructCount==17){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.02, 0.00, -0.05);
				
				bioMightTransform.setTextureID(5);
				bioMightTransform.setTextureFile("StaphylococcusAureus.png");
				bioMightTransform.setComponentName("Node of Ranvier");
				bioInstruct.setBioMightTransform(bioMightTransform);
			}
			else if (instructCount==18){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(2.5, 2.5, 1.0);
				bioInstruct.setTranslateMatrix(0.01, 0.00, -0.05);       
			}
			else if (instructCount==19){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 3.0);
				bioInstruct.setTranslateMatrix(0.02, 0.00, -0.05);       
			}
			else if (instructCount==20){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.02, 0.00, -0.05);       
			}
			else if (instructCount==21){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.01, 0.00, -0.05);       
			}
			else if (instructCount==22){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.01, 0.00, -0.05);       
			}			
			else if (instructCount==23){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(0.4, 0.4, 1.0);
				bioInstruct.setTranslateMatrix(0.0, 0.00, -0.05);       
			}
			else if (instructCount==24){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.0, 0.00, -0.05);       
			
				bioMightTransform.setTextureID(5);
				bioMightTransform.setTextureFile("StaphylococcusAureus.png");
				bioMightTransform.setComponentName("Node of Ranvier");
				bioInstruct.setBioMightTransform(bioMightTransform);
			}
			else if (instructCount==25){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(2.5, 2.5, 1.0);
				bioInstruct.setTranslateMatrix(-0.01, 0.00, -0.05);       
			}
			else if (instructCount==26){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.01, 0.00, -0.05);    
			}
			else if (instructCount==27){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.01, 0.00, -0.05);       
			}
			else if (instructCount==28){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.01, 0.00, -0.05);       
			}
			else if (instructCount==29){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.1, 1.1, 1.0);
				bioInstruct.setTranslateMatrix(0.0, 0.00, -0.05);            
			}
			else if (instructCount==30){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(0.4, 0.4, 1.0);
				bioInstruct.setTranslateMatrix(-0.01, 0.00, -0.05);          
			}
			else if (instructCount==31){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(-0.01, 0.00, -0.05);           

				bioMightTransform.setTextureID(5);
				bioMightTransform.setTextureFile("StaphylococcusAureus.png");
				bioMightTransform.setComponentName("Node of Ranvier");
				bioInstruct.setBioMightTransform(bioMightTransform);
			}
			else if (instructCount==32){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(2.5, 2.5, 1.0);
				bioInstruct.setTranslateMatrix(-0.02, 0.00, -0.05);        
			}
			else if (instructCount==33){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(-0.01, 0.00, -0.05);            
			}
			else if (instructCount==34){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(-0.01, 0.00, -0.05);         
			}
			else if (instructCount==35){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.0, 0.00, -0.05);         
			}
			else if (instructCount==36){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.0, 0.00, -0.05);        
			}
			else if (instructCount==37){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(0.4, 0.4, 1.0);
				bioInstruct.setTranslateMatrix(0.0, 0.00, -0.05);          
			}
			else if (instructCount==38){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.0, 0.00, -0.05);
				
				bioMightTransform.setTextureID(5);
				bioMightTransform.setTextureFile("StaphylococcusAureus.png");
				bioMightTransform.setComponentName("Node of Ranvier");
				bioInstruct.setBioMightTransform(bioMightTransform);
			}
			else if (instructCount==39){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(2.25, 2.25, 4.0);
				bioInstruct.setTranslateMatrix(0.0, 0.00, -0.05);          
			}
			else if (instructCount==40){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.0, 0.00, -0.05);          
			}
			else if (instructCount==41){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.0, 0.00, -0.05);          
			}
			else if (instructCount==42){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.0, 0.00, -0.05);          
			}
			else if (instructCount==43){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.0, 0.00, -0.05);          
			}
			else if (instructCount==44){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(0.4, 0.4, 1.0);
				bioInstruct.setTranslateMatrix(0.0, 0.00, -0.05);          
			}
			else if (instructCount==45){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(-0.01, 0.00, -0.05);
				
				bioMightTransform.setTextureID(5);
				bioMightTransform.setTextureFile("StaphylococcusAureus.png");
				bioMightTransform.setComponentName("Node of Ranvier");
				bioInstruct.setBioMightTransform(bioMightTransform);
			}
			else if (instructCount==46){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(2.65, 2.65, 1.0);
				bioInstruct.setTranslateMatrix(-0.01, 0.00, -0.05);          
			}
			else if (instructCount==47){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0	, 1.0);
				bioInstruct.setTranslateMatrix(-0.01, 0.00, -0.05);          
			}
			else if (instructCount==48){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.1, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(-0.01, 0.00, -0.05);          
			}
			else if (instructCount==48){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.1, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.0, 0.00, -0.05);          
			}
			else if (instructCount==49){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.1, 1.1, 1.0);
				bioInstruct.setTranslateMatrix(0.0, 0.00, -0.05);          
			}
			else if (instructCount==50){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(0.5, 0.5, 1.0);
				bioInstruct.setTranslateMatrix(-0.01, 0.00, -0.05);          
			}
			else if (instructCount==51){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.0, 0.00, -0.05);
				
				bioMightTransform.setTextureID(5);
				bioMightTransform.setTextureFile("StaphylococcusAureus.png");
				bioMightTransform.setComponentName("Node of Ranvier");
				bioInstruct.setBioMightTransform(bioMightTransform);
			}
			else if (instructCount==52){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(2.5, 2.5, 1.0);
				bioInstruct.setTranslateMatrix(0.0, 0.00, -0.05);
			}
			else if (instructCount==53){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.0, 0.00, -0.05);          
			}
			else if (instructCount==54){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.0, 0.00, -0.05);          
			}
			else if (instructCount==55){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.0, 0.00, -0.05);          
			}
			else if (instructCount==56){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(1.0, 1.0, 1.0);
				bioInstruct.setTranslateMatrix(0.0, 0.00, -0.05);          
			}
			else if (instructCount==57){
				bioInstruct.setTransType(Constants.SCALE);
				bioInstruct.setScaleMatrix(0.65, 0.65, 1.0);
				bioInstruct.setTranslateMatrix(0.0, 0.00, -0.05);          
			}
			else {
				bioInstruct.setTransType(Constants.TRANSLATE);
				BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, 90);
				bioInstruct.setOrientation(orientationUpd);
				bioInstruct.setTranslateMatrix(0.0, -0.05, 0.0);       
			}
	
			//System.out.println("Added Transform to InstructionSet: " + instructCount + "   " + bioMightTransform.getTextureFile());

			// Add the instruction into the instruction set
    		bioMightInstructSet.addElement(bioInstruct);
		}	
			
		
		// Pass the instructions to the builder
		bioMightTransform.setComponentName("MyelinSheath");
		String genArm = generateIndexFacedComponents(bioMightOrientation, bioMightInstructSet, nuclueiPoints); 
		body += genArm; 	

			
		return (body);
	}
  	
  	
  	/***********************************************************************************************************************
  	 * GENERATE SCHWANN CELLS 
  	 * 
  	 * Creates the Schhwann Cells that are situated in the Myelin sheath
  	 * 
  	 * @param bioMightTransform
  	 * @param currentPoints
  	 * @param bHeader
  	 * @param bFooter
  	 * @param diffColor
  	 * @return
  	 * 
  	 ***********************************************************************************************************************/
	
  	public static String generateSchwannCells(BioMightTransform bioMightTransform,  BioMightPosition startPos, BioMightOrientation bioMightOrientation) 	
	{		
	  	String body = "";			
		//double xStartPos = startPos.getXPos(); 
		//double yStartPos = startPos.getYPos(); 
		//double zStartPos = startPos.getZPos();
		System.out.println("\nGenerateSchwannCells(): ");
			
	
		// Create the Arm that has the Axon attached
		double[] axonStartPos = {
	    		0.0, 
	    		0, 
	    		3.490};

		BioMightInstructSet bioMightInstructSet = new BioMightInstructSet();
	
		int numInstructions = 8;
		//BioMightOrientation bioMightOrientation = new BioMightOrientation(0.0, 0.0, 1.0, 90);
		for (int instructCount=0; instructCount<numInstructions; instructCount++)
		{
			// Create a place for an instruction 
			BioMightInstruction bioInstruct = new BioMightInstruction();
			
			bioMightTransform.setComponentName("Schwann Cell");
			bioMightTransform.setRadius(0.05);
			//BioMightScale scale = new BioMightScale(1.5, 1.0, 1.5);
			//bioMightTransform.setScale(scale);
			
			// Place a transform object into each instruction set
			bioInstruct.setBioMightTransform(bioMightTransform);
			
			if (instructCount==0){		
				bioInstruct.setTransType(Constants.TRANSLATE);
				bioInstruct.setTranslateMatrix(0.0, 0.05, -0.075);      
			}
			else if (instructCount==1){
				bioInstruct.setTransType(Constants.TRANSLATE);
				bioInstruct.setTranslateMatrix(0.0, 0.025, -0.35);
			}
			else if (instructCount==2){
				bioInstruct.setTransType(Constants.TRANSLATE);
				bioInstruct.setTranslateMatrix(0.05, -0.025, -0.35); 
			}				
			else if (instructCount==3){
				bioInstruct.setTransType(Constants.TRANSLATE);
				bioInstruct.setTranslateMatrix(0.025, -0.025, -0.35);    
			}
			else if (instructCount==4){
				bioInstruct.setTransType(Constants.TRANSLATE);
				bioInstruct.setTranslateMatrix(-0.015, 0.035, -0.35);      
			}
			else if (instructCount==5){
				bioInstruct.setTransType(Constants.TRANSLATE);
				bioInstruct.setTranslateMatrix(-0.015, 0.0, -0.35);      
			}
			else if (instructCount==6){
				bioInstruct.setTransType(Constants.TRANSLATE);
				bioInstruct.setTranslateMatrix(-0.015, 0.0, -0.35);       
			}
			else if (instructCount==7){
				bioInstruct.setTransType(Constants.TRANSLATE);
				bioInstruct.setTranslateMatrix(-0.015, 0.0, -0.35);         
			}
			
			
			else if (instructCount==8){
				bioInstruct.setTransType(Constants.TRANSLATE);
				bioInstruct.setTranslateMatrix(0.0, 0.0, -0.2);   
			}
			else if (instructCount==9){
				bioInstruct.setTransType(Constants.TRANSLATE);
				bioInstruct.setTranslateMatrix(0.0, 0.0, -0.2);       
			}
			else if (instructCount==10){
				bioInstruct.setTransType(Constants.TRANSLATE);
				bioInstruct.setTranslateMatrix(0.0, 0.0, -0.2);         
			}
			else if (instructCount==11){
				bioInstruct.setTransType(Constants.TRANSLATE);
				bioInstruct.setTranslateMatrix(0.0, 0.0, -0.2);        
			}
			else if (instructCount==12){
				bioInstruct.setTransType(Constants.TRANSLATE);
				bioInstruct.setTranslateMatrix(0.0, 0.0, -0.2);            
			}
			else if (instructCount==13){
				bioInstruct.setTransType(Constants.TRANSLATE);
				bioInstruct.setTranslateMatrix(0.0, 0.0, -0.2);          
			}
			else if (instructCount==14){
				bioInstruct.setTransType(Constants.TRANSLATE);
				bioInstruct.setTranslateMatrix(0.0, 0.0, -0.2);          
			}
			else if (instructCount==15){
				bioInstruct.setTransType(Constants.TRANSLATE);
				bioInstruct.setTranslateMatrix(0.0, 0.0, -0.2);    
			}
			else {
				bioInstruct.setTransType(Constants.TRANSLATE);
				bioInstruct.setTranslateMatrix(0.0, 0.0, -0.2);       
			}
	

			// Add the instruction into the instruction set
    		bioMightInstructSet.addElement(bioInstruct);
		}	
	

		String genArm = generateSpheres(bioMightOrientation, bioMightInstructSet, axonStartPos); 
		body += genArm; 	
		
		return (body);
		
	}
  	
  	/***********************************************************************************************************************
  	 * GENERATE GOLGI APPARATUS 
  	 * 
  	 * Creates the Golgi using attached sectionals,
  	 * 
  	 * @param bioMightTransform
  	 * @param currentPoints
  	 * @param bHeader
  	 * @param bFooter
  	 * @param diffColor
  	 * @return
  	 * 
  	 ***********************************************************************************************************************/
	
  	public static String generateGolgiApparatus(BioMightTransform bioMightTransform,  BioMightPosition startPos, BioMightOrientation bioMightOrientation) 	
	{		
	  	String body = "";			
		//double xStartPos = startPos.getXPos(); 
		//double yStartPos = startPos.getYPos(); 
		//double zStartPos = startPos.getZPos();
		//System.o ut.println("\n\nGenerateGolgi() at Start Position: " + xStartPos +   ",   " + yStartPos + ",   " + zStartPos);
			

		//***********************************************
		// Create the first wall of the Golgi
	  	// Make is short, centered and curved
	  	//***********************************************
		double[][] wallPoints1 =  
				{
					{0.70,        0.00,     0.35},
					{0.70,        0.0325,   0.35}
				};	
		
		// Move the point around, and connect it, creating a wall of 
		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstructSet = new BioMightInstructSet();
		
		int numInstructions = 3;
		//BioMightOrientation bioMightOrientation = new BioMightOrientation(0.0, 0.0, 1.0, 90);
		for (int instructCount=0; instructCount<numInstructions; instructCount++)
		{
			// Create a place for an instruction 
			BioMightInstruction bioInstruct = new BioMightInstruction();
			
			// Place a transform object into each instruction set
			bioInstruct.setBioMightTransform(bioMightTransform);
		
			if (instructCount==0){
				bioInstruct.setTransType(Constants.TRANSLATE);				
				BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, -90);
				bioInstruct.setOrientation(orientationUpd);
				bioInstruct.setTranslateMatrix(-0.02, 0.00, -0.009);      
			}
			else if (instructCount==1){
				bioInstruct.setTransType(Constants.TRANSLATE);
				BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, 90);
				bioInstruct.setOrientation(orientationUpd);
				bioInstruct.setTranslateMatrix(-0.02, 0.0, 0.0);   
			}
			else if (instructCount==2){
				bioInstruct.setTransType(Constants.TRANSLATE);
				BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, 90);
				bioInstruct.setOrientation(orientationUpd);
				bioInstruct.setTranslateMatrix(-0.02, 0.0, 0.009);   
			}				
			else {
				bioInstruct.setTransType(Constants.TRANSLATE);
				BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, 90);
				bioInstruct.setOrientation(orientationUpd);
				bioInstruct.setTranslateMatrix(-0.02, 0.0, 0.0);       
			}
	
			// Add the instruction into the instruction set
    		bioMightInstructSet.addElement(bioInstruct);
		}	
			
		// Pass the instructions to the builder
		body += generateFacedComponents(bioMightTransform,  startPos, bioMightOrientation, bioMightInstructSet, wallPoints1); 	
					 
	
		//***************************************
		// 1st Wall Backplane
		//***************************************
		double[][] wallPoints2 =  
			{ {0.70,        0.0,          0.35},
			  {0.70,        0.0325,    	  0.35}
			};	
		
		// Move the point around, and connect it, creating a wall of 
		// Allocate an instruction set for building it
		bioMightInstructSet = new BioMightInstructSet();
		
		numInstructions = 5;
		//BioMightOrientation bioMightOrientation = new BioMightOrientation(0.0, 0.0, 1.0, 90);
		for (int instructCount=0; instructCount<numInstructions; instructCount++)
		{
			// Create a place for an instruction 
			BioMightInstruction bioInstruct = new BioMightInstruction();
			
			// Place a transform object into each instruction set
			bioInstruct.setBioMightTransform(bioMightTransform);
		
			if (instructCount==0){
				bioInstruct.setTransType(Constants.ROTATETOP);
				bioInstruct.setTranslateMatrix(00.0, 0.0, 0.0);  
				BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, -90);
				bioInstruct.setOrientation(orientationUpd);	
				bioInstruct.setPivotPoint(0);
				BioMightOrientation rotationUpd = new BioMightOrientation(1.0, 0.0, 0.0, -15.0);
				bioInstruct.setRotation(rotationUpd);
			}
			else if (instructCount==1){
				bioInstruct.setTransType(Constants.TRANSLATE);				
				BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, -90);
				bioInstruct.setOrientation(orientationUpd);
				bioInstruct.setTranslateMatrix(-0.02, 0.00, -0.009);      
			}
			else if (instructCount==2){
				bioInstruct.setTransType(Constants.TRANSLATE);
				BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, 90);
				bioInstruct.setOrientation(orientationUpd);
				bioInstruct.setTranslateMatrix(-0.02, 0.0, 0.0);   
			}
			else if (instructCount==3){
				bioInstruct.setTransType(Constants.TRANSLATE);
				BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, 90);
				bioInstruct.setOrientation(orientationUpd);
				bioInstruct.setTranslateMatrix(-0.02, 0.0, 0.009);   
			}
			else if (instructCount==4){
				bioInstruct.setTransType(Constants.ROTATETOP);
				bioInstruct.setTranslateMatrix(00.0, 0.0, 0.0);  
				BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, -90);
				bioInstruct.setOrientation(orientationUpd);	
				bioInstruct.setPivotPoint(0);
				BioMightOrientation rotationUpd = new BioMightOrientation(1.0, 0.0, 0.0, 15.0);
				bioInstruct.setRotation(rotationUpd);
			}
			
			
			else {
				bioInstruct.setTransType(Constants.TRANSLATE);
				BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, 90);
				bioInstruct.setOrientation(orientationUpd);
				bioInstruct.setTranslateMatrix(-0.02, 0.0, 0.005);       
			}
	
			// Add the instruction into the instruction set
    		bioMightInstructSet.addElement(bioInstruct);
		}	
			
		// Pass the instructions to the builder
		body += generateFacedComponents(bioMightTransform,  startPos, bioMightOrientation, bioMightInstructSet, wallPoints2); 	
					 
		
		
		//**************************
		// 2nd Wall
		//**************************
		double[][] wallPoints3 =  
				{ 
					{0.72,        0.00,       0.345},
					{0.72,        0.0325,     0.345}
				};	
		
		// Move the point around, and connect it, creating a wall of 
		// Allocate an instruction set for building it
		bioMightInstructSet = new BioMightInstructSet();
		
		numInstructions = 5;
		//BioMightOrientation bioMightOrientation = new BioMightOrientation(0.0, 0.0, 1.0, 90);
		for (int instructCount=0; instructCount<numInstructions; instructCount++)
		{
			// Create a place for an instruction 
			BioMightInstruction bioInstruct = new BioMightInstruction();
			
			// Place a transform object into each instruction set
			bioInstruct.setBioMightTransform(bioMightTransform);
		
			if (instructCount==0){
				bioInstruct.setTransType(Constants.TRANSLATE);
				bioInstruct.setTranslateMatrix(-0.02, 0.0, -0.008);  
				BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, -90);
				bioInstruct.setOrientation(orientationUpd);
			}
			else if (instructCount==1){
				bioInstruct.setTransType(Constants.TRANSLATE);				
				BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, -90);
				bioInstruct.setOrientation(orientationUpd);
				bioInstruct.setTranslateMatrix(-0.02, 0.00, -0.01);      
			}
			else if (instructCount==2){
				bioInstruct.setTransType(Constants.TRANSLATE);
				BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, 90);
				bioInstruct.setOrientation(orientationUpd);
				bioInstruct.setTranslateMatrix(-0.02, 0.0, 0.00);   
			}
			else if (instructCount==3){
				bioInstruct.setTransType(Constants.TRANSLATE);
				BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, 90);
				bioInstruct.setOrientation(orientationUpd);
				bioInstruct.setTranslateMatrix(-0.02, 0.0, 0.01);   
			}	
			else if (instructCount==4){
				bioInstruct.setTransType(Constants.TRANSLATE);
				BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, 90);
				bioInstruct.setOrientation(orientationUpd);
				bioInstruct.setTranslateMatrix(-0.02, 0.0, 0.008);   
			}			
			else {	
				bioInstruct.setTransType(Constants.TRANSLATE);
				BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, 90);
				bioInstruct.setOrientation(orientationUpd);
				bioInstruct.setTranslateMatrix(-0.02, 0.0, 0.0);       
			}
	
			// Add the instruction into the instruction set
    		bioMightInstructSet.addElement(bioInstruct);
		}	
			
		// Pass the instructions to the builder
		body += generateFacedComponents(bioMightTransform,  startPos, bioMightOrientation, bioMightInstructSet, wallPoints3); 	
					 

		// The 2nd Wall backplane
		double[][] wallPoints4 =  
			{ 
				{0.72,        0.00,       0.345},
				{0.72,        0.0325,     0.345}
			};		
		
		// Move the point around, and connect it, creating a wall of 
		// Allocate an instruction set for building it
		bioMightInstructSet = new BioMightInstructSet();
		
		numInstructions = 22;
		//BioMightOrientation bioMightOrientation = new BioMightOrientation(0.0, 0.0, 1.0, 90);
		for (int instructCount=0; instructCount<numInstructions; instructCount++)
		{
			// Create a place for an instruction 
			BioMightInstruction bioInstruct = new BioMightInstruction();
	
			// Place a transform object into each instruction set
			bioInstruct.setBioMightTransform(bioMightTransform);
		
			if (instructCount==0){
				bioInstruct.setTransType(Constants.ROTATETOP);
				bioInstruct.setTranslateMatrix(-0.001, 0.0, -0.0005);  
				BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, -90);
				bioInstruct.setOrientation(orientationUpd);	
				bioInstruct.setPivotPoint(0);
				BioMightOrientation rotationUpd = new BioMightOrientation(1.0, 0.0, 0.0, -6.0);
				bioInstruct.setRotation(rotationUpd);
			}			
			else if (instructCount==1){
				bioInstruct.setTransType(Constants.ROTATETOP);
				bioInstruct.setTranslateMatrix(-0.002, 0.0, -0.0007);  
				BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, -90);
				bioInstruct.setOrientation(orientationUpd);	
				bioInstruct.setPivotPoint(0);
				BioMightOrientation rotationUpd = new BioMightOrientation(1.0, 0.0, 0.0, -5.0);
				bioInstruct.setRotation(rotationUpd);
			}
			else if (instructCount==2){
				bioInstruct.setTransType(Constants.ROTATETOP);
				bioInstruct.setTranslateMatrix(-0.002, 0.0, -0.0008);  
				BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, -90);
				bioInstruct.setOrientation(orientationUpd);	
				bioInstruct.setPivotPoint(0);
				BioMightOrientation rotationUpd = new BioMightOrientation(1.0, 0.0, 0.0, -4.0);
				bioInstruct.setRotation(rotationUpd);
			}
			else if (instructCount==3){
				bioInstruct.setTransType(Constants.ROTATETOP);
				bioInstruct.setTranslateMatrix(-0.002, 0.0, -0.0008	);  
				BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, -90);
				bioInstruct.setOrientation(orientationUpd);	
				bioInstruct.setPivotPoint(0);
				BioMightOrientation rotationUpd = new BioMightOrientation(1.0, 0.0, 0.0, -2.0);
				bioInstruct.setRotation(rotationUpd);
			}			
			else if (instructCount==4){
				bioInstruct.setTransType(Constants.ROTATETOP);
				//bioInstruct.setTranslateMatrix(-0.002, 0.0, 0.00008);
				bioInstruct.setTranslateMatrix(-0.002, 0.0, -0.0008); 
				BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, -90);
				bioInstruct.setOrientation(orientationUpd);	
				bioInstruct.setPivotPoint(0);
				BioMightOrientation rotationUpd = new BioMightOrientation(1.0, 0.0, 0.0, 0.0);
				bioInstruct.setRotation(rotationUpd);
			}			
			else if (instructCount==5){
				bioInstruct.setTransType(Constants.ROTATETOP);
				bioInstruct.setTranslateMatrix(-0.002, 0.0, -0.0008);  
				BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, -90);
				bioInstruct.setOrientation(orientationUpd);	
				bioInstruct.setPivotPoint(0);
				BioMightOrientation rotationUpd = new BioMightOrientation(1.0, 0.0, 0.0, 2.0);
				bioInstruct.setRotation(rotationUpd);
			}
			else if (instructCount==6){
				bioInstruct.setTransType(Constants.ROTATETOP);
				bioInstruct.setTranslateMatrix(-0.002, 0.0, -0.001);  
				BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, -90);
				bioInstruct.setOrientation(orientationUpd);	
				bioInstruct.setPivotPoint(0);
				BioMightOrientation rotationUpd = new BioMightOrientation(1.0, 0.0, 0.0, 2.0);
				bioInstruct.setRotation(rotationUpd);
			}
			else if (instructCount==7){
				bioInstruct.setTransType(Constants.ROTATETOP);
				bioInstruct.setTranslateMatrix(-0.002, 0.0, -0.001);  
				BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, -90);
				bioInstruct.setOrientation(orientationUpd);	
				bioInstruct.setPivotPoint(0);
				BioMightOrientation rotationUpd = new BioMightOrientation(1.0, 0.0, 0.0, 3.0);
				bioInstruct.setRotation(rotationUpd);
			}			
			else if (instructCount==8){
				bioInstruct.setTransType(Constants.ROTATETOP);
				bioInstruct.setTranslateMatrix(-0.004, 0.0, -0.002);  
				BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, -90);
				bioInstruct.setOrientation(orientationUpd);	
				bioInstruct.setPivotPoint(0);
				BioMightOrientation rotationUpd = new BioMightOrientation(1.0, 0.0, 0.0, 1.5);
				bioInstruct.setRotation(rotationUpd);
			}
			else if (instructCount==9){
				bioInstruct.setTransType(Constants.ROTATETOP);
				bioInstruct.setTranslateMatrix(-0.021, 0.0, -0.01);  
				BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, -90);
				bioInstruct.setOrientation(orientationUpd);	
				bioInstruct.setPivotPoint(0);
				BioMightOrientation rotationUpd = new BioMightOrientation(1.0, 0.0, 0.0, -5.0);
				bioInstruct.setRotation(rotationUpd);
			}			
			else if (instructCount==10){
				bioInstruct.setTransType(Constants.ROTATETOP);
				bioInstruct.setTranslateMatrix(-0.02, 0.0, 0.0004);  
				BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, -90);
				bioInstruct.setOrientation(orientationUpd);	
				bioInstruct.setPivotPoint(0);
				BioMightOrientation rotationUpd = new BioMightOrientation(1.0, 0.0, 0.0, -2.0);
				bioInstruct.setRotation(rotationUpd);
			}
			else if (instructCount==11){
				bioInstruct.setTransType(Constants.ROTATETOP);
				bioInstruct.setTranslateMatrix(-0.02, 0.0, 0.01);  
				BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, -90);
				bioInstruct.setOrientation(orientationUpd);	
				bioInstruct.setPivotPoint(0);
				BioMightOrientation rotationUpd = new BioMightOrientation(1.0, 0.0, 0.0, -2.0);
				bioInstruct.setRotation(rotationUpd);
			}
			else if (instructCount==12){
				bioInstruct.setTransType(Constants.ROTATETOP);
				bioInstruct.setTranslateMatrix(-0.002, 0.0, 0.0008);  
				BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, -90);
				bioInstruct.setOrientation(orientationUpd);	
				bioInstruct.setPivotPoint(0);
				BioMightOrientation rotationUpd = new BioMightOrientation(1.0, 0.0, 0.0, -4.0);
				bioInstruct.setRotation(rotationUpd);
			}	
			else if (instructCount==13){
				bioInstruct.setTransType(Constants.ROTATETOP);
				bioInstruct.setTranslateMatrix(-0.002, 0.0, 0.0008);  
				BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, -90);
				bioInstruct.setOrientation(orientationUpd);	
				bioInstruct.setPivotPoint(0);
				BioMightOrientation rotationUpd = new BioMightOrientation(1.0, 0.0, 0.0, -3.0);
				bioInstruct.setRotation(rotationUpd);
			}
			else if (instructCount==14){
				bioInstruct.setTransType(Constants.ROTATETOP);
				bioInstruct.setTranslateMatrix(-0.002, 0.0, 0.0008);  
				BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, -90);
				bioInstruct.setOrientation(orientationUpd);	
				bioInstruct.setPivotPoint(0);
				BioMightOrientation rotationUpd = new BioMightOrientation(1.0, 0.0, 0.0, -2.0);
				bioInstruct.setRotation(rotationUpd);
			}	
			else if (instructCount==15){
				bioInstruct.setTransType(Constants.ROTATETOP);
				bioInstruct.setTranslateMatrix(-0.002, 0.0, 0.0008);  
				BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, -90);
				bioInstruct.setOrientation(orientationUpd);		
				bioInstruct.setPivotPoint(0);
				BioMightOrientation rotationUpd = new BioMightOrientation(1.0, 0.0, 0.0, -1.0);
				bioInstruct.setRotation(rotationUpd);
			}		
			else if (instructCount==16){
				bioInstruct.setTransType(Constants.ROTATETOP);
				bioInstruct.setTranslateMatrix(-0.002, 0.0, 0.0008);  
				BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, -90);
				bioInstruct.setOrientation(orientationUpd);		
				bioInstruct.setPivotPoint(0);
				BioMightOrientation rotationUpd = new BioMightOrientation(1.0, 0.0, 0.0, 0.0);
				bioInstruct.setRotation(rotationUpd);
			}
			else if (instructCount==17){
				bioInstruct.setTransType(Constants.ROTATETOP);
				bioInstruct.setTranslateMatrix(-0.002, 0.0, 0.0008);  
				BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, -90);
				bioInstruct.setOrientation(orientationUpd);	
				bioInstruct.setPivotPoint(0);
				BioMightOrientation rotationUpd = new BioMightOrientation(1.0, 0.0, 0.0, 1.0);
				bioInstruct.setRotation(rotationUpd);
			}
			else if (instructCount==18){
				bioInstruct.setTransType(Constants.ROTATETOP);
				bioInstruct.setTranslateMatrix(-0.002, 0.0, 0.0008);  
				BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, -90);
				bioInstruct.setOrientation(orientationUpd);	
				bioInstruct.setPivotPoint(0);
				BioMightOrientation rotationUpd = new BioMightOrientation(1.0, 0.0, 0.0, 4.0);
				bioInstruct.setRotation(rotationUpd);
			}			
			else if (instructCount==19){
				bioInstruct.setTransType(Constants.ROTATETOP);
				bioInstruct.setTranslateMatrix(-0.002, 0.0, 0.0008);  
				BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, -90);
				bioInstruct.setOrientation(orientationUpd);	
				bioInstruct.setPivotPoint(0);
				BioMightOrientation rotationUpd = new BioMightOrientation(1.0, 0.0, 0.0, 6.0);
				bioInstruct.setRotation(rotationUpd);
			}
			else if (instructCount==20){
				bioInstruct.setTransType(Constants.ROTATETOP);
				bioInstruct.setTranslateMatrix(-0.002, 0.0, 0.0008);  
				BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, -90);
				bioInstruct.setOrientation(orientationUpd);	
				bioInstruct.setPivotPoint(0);
				BioMightOrientation rotationUpd = new BioMightOrientation(1.0, 0.0, 0.0, 6.0);
				bioInstruct.setRotation(rotationUpd);
			}
			else if (instructCount==21){
				bioInstruct.setTransType(Constants.ROTATETOP);
				bioInstruct.setTranslateMatrix(-0.002, 0.0, 0.0008);  
				BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, -90);
				bioInstruct.setOrientation(orientationUpd);	
				bioInstruct.setPivotPoint(0);
				BioMightOrientation rotationUpd = new BioMightOrientation(1.0, 0.0, 0.0, 11.0);
				bioInstruct.setRotation(rotationUpd);
			}
			
			
			else {	
				bioInstruct.setTransType(Constants.TRANSLATE);
				BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, 90);
				bioInstruct.setOrientation(orientationUpd);
				bioInstruct.setTranslateMatrix(-0.02, 0.0, 0.0);       
			}
			
			
			
			// Add the instruction into the instruction set
    		bioMightInstructSet.addElement(bioInstruct);
		}	
			
		// Pass the instructions to the builder
		body += generateFacedComponents(bioMightTransform,  startPos, bioMightOrientation, bioMightInstructSet, wallPoints4); 	

	
	
		// 3rd Wall
		double[][] wallPoints5 =  
				{ 
					{0.72,        0.00,       0.33},
					{0.72,        0.0325,     0.33}
				};	
		
		// Move the point around, and connect it, creating a wall of 
		// Allocate an instruction set for building it
		bioMightInstructSet = new BioMightInstructSet();
		
		numInstructions = 5;
		//BioMightOrientation bioMightOrientation = new BioMightOrientation(0.0, 0.0, 1.0, 90);
		for (int instructCount=0; instructCount<numInstructions; instructCount++)
		{
			// Create a place for an instruction 
			BioMightInstruction bioInstruct = new BioMightInstruction();
			
			// Place a transform object into each instruction set
			bioInstruct.setBioMightTransform(bioMightTransform);
		
			if (instructCount==0){
				bioInstruct.setTransType(Constants.TRANSLATE);
				bioInstruct.setTranslateMatrix(-0.02, 0.0, -0.008);  
				BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, -90);
				bioInstruct.setOrientation(orientationUpd);
			}
			else if (instructCount==1){
				bioInstruct.setTransType(Constants.TRANSLATE);				
				BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, -90);
				bioInstruct.setOrientation(orientationUpd);
				bioInstruct.setTranslateMatrix(-0.02, 0.00, -0.01);      
			}
			else if (instructCount==2){
				bioInstruct.setTransType(Constants.TRANSLATE);
				BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, 90);
				bioInstruct.setOrientation(orientationUpd);
				bioInstruct.setTranslateMatrix(-0.02, 0.0, 0.00);   
			}
			else if (instructCount==3){
				bioInstruct.setTransType(Constants.TRANSLATE);
				BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, 90);
				bioInstruct.setOrientation(orientationUpd);
				bioInstruct.setTranslateMatrix(-0.02, 0.0, 0.01);   
			}	
			else if (instructCount==4){
				bioInstruct.setTransType(Constants.TRANSLATE);
				BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, 90);
				bioInstruct.setOrientation(orientationUpd);
				bioInstruct.setTranslateMatrix(-0.02, 0.0, 0.008);   
			}			
			else {	
				bioInstruct.setTransType(Constants.TRANSLATE);
				BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, 90);
				bioInstruct.setOrientation(orientationUpd);
				bioInstruct.setTranslateMatrix(-0.02, 0.0, 0.0);       
			}
	
			// Add the instruction into the instruction set
    		bioMightInstructSet.addElement(bioInstruct);
		}	
			
		// Pass the instructions to the builder
		body += generateFacedComponents(bioMightTransform,  startPos, bioMightOrientation, bioMightInstructSet, wallPoints5); 	
					 

		// The 3rd Wall backplane
		double[][] wallPoints6 =  
			{ 
				{0.72,        0.00,       0.33},
				{0.72,        0.0325,     0.33}
			};		
		
		// Move the point around, and connect it, creating a wall of 
		// Allocate an instruction set for building it
		bioMightInstructSet = new BioMightInstructSet();
		
		numInstructions = 22;
		//BioMightOrientation bioMightOrientation = new BioMightOrientation(0.0, 0.0, 1.0, 90);
		for (int instructCount=0; instructCount<numInstructions; instructCount++)
		{
			// Create a place for an instruction 
			BioMightInstruction bioInstruct = new BioMightInstruction();
	
			// Place a transform object into each instruction set
			bioInstruct.setBioMightTransform(bioMightTransform);
		
			if (instructCount==0){
				bioInstruct.setTransType(Constants.ROTATETOP);
				bioInstruct.setTranslateMatrix(-0.001, 0.0, -0.0005);  
				BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, -90);
				bioInstruct.setOrientation(orientationUpd);	
				bioInstruct.setPivotPoint(0);
				BioMightOrientation rotationUpd = new BioMightOrientation(1.0, 0.0, 0.0, -6.0);
				bioInstruct.setRotation(rotationUpd);
			}			
			else if (instructCount==1){
				bioInstruct.setTransType(Constants.ROTATETOP);
				bioInstruct.setTranslateMatrix(-0.002, 0.0, -0.0007);  
				BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, -90);
				bioInstruct.setOrientation(orientationUpd);	
				bioInstruct.setPivotPoint(0);
				BioMightOrientation rotationUpd = new BioMightOrientation(1.0, 0.0, 0.0, -5.0);
				bioInstruct.setRotation(rotationUpd);
			}
			else if (instructCount==2){
				bioInstruct.setTransType(Constants.ROTATETOP);
				bioInstruct.setTranslateMatrix(-0.002, 0.0, -0.0008);  
				BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, -90);
				bioInstruct.setOrientation(orientationUpd);	
				bioInstruct.setPivotPoint(0);
				BioMightOrientation rotationUpd = new BioMightOrientation(1.0, 0.0, 0.0, -4.0);
				bioInstruct.setRotation(rotationUpd);
			}
			else if (instructCount==3){
				bioInstruct.setTransType(Constants.ROTATETOP);
				bioInstruct.setTranslateMatrix(-0.002, 0.0, -0.0008	);  
				BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, -90);
				bioInstruct.setOrientation(orientationUpd);	
				bioInstruct.setPivotPoint(0);
				BioMightOrientation rotationUpd = new BioMightOrientation(1.0, 0.0, 0.0, -2.0);
				bioInstruct.setRotation(rotationUpd);
			}			
			else if (instructCount==4){
				bioInstruct.setTransType(Constants.ROTATETOP);
				//bioInstruct.setTranslateMatrix(-0.002, 0.0, 0.00008);
				bioInstruct.setTranslateMatrix(-0.002, 0.0, -0.0008); 
				BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, -90);
				bioInstruct.setOrientation(orientationUpd);	
				bioInstruct.setPivotPoint(0);
				BioMightOrientation rotationUpd = new BioMightOrientation(1.0, 0.0, 0.0, 0.0);
				bioInstruct.setRotation(rotationUpd);
			}			
			else if (instructCount==5){
				bioInstruct.setTransType(Constants.ROTATETOP);
				bioInstruct.setTranslateMatrix(-0.002, 0.0, -0.0008);  
				BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, -90);
				bioInstruct.setOrientation(orientationUpd);	
				bioInstruct.setPivotPoint(0);
				BioMightOrientation rotationUpd = new BioMightOrientation(1.0, 0.0, 0.0, 2.0);
				bioInstruct.setRotation(rotationUpd);
			}
			else if (instructCount==6){
				bioInstruct.setTransType(Constants.ROTATETOP);
				bioInstruct.setTranslateMatrix(-0.002, 0.0, -0.001);  
				BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, -90);
				bioInstruct.setOrientation(orientationUpd);	
				bioInstruct.setPivotPoint(0);
				BioMightOrientation rotationUpd = new BioMightOrientation(1.0, 0.0, 0.0, 2.0);
				bioInstruct.setRotation(rotationUpd);
			}
			else if (instructCount==7){
				bioInstruct.setTransType(Constants.ROTATETOP);
				bioInstruct.setTranslateMatrix(-0.002, 0.0, -0.001);  
				BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, -90);
				bioInstruct.setOrientation(orientationUpd);	
				bioInstruct.setPivotPoint(0);
				BioMightOrientation rotationUpd = new BioMightOrientation(1.0, 0.0, 0.0, 3.0);
				bioInstruct.setRotation(rotationUpd);
			}			
			else if (instructCount==8){
				bioInstruct.setTransType(Constants.ROTATETOP);
				bioInstruct.setTranslateMatrix(-0.004, 0.0, -0.002);  
				BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, -90);
				bioInstruct.setOrientation(orientationUpd);	
				bioInstruct.setPivotPoint(0);
				BioMightOrientation rotationUpd = new BioMightOrientation(1.0, 0.0, 0.0, 1.5);
				bioInstruct.setRotation(rotationUpd);
			}
			else if (instructCount==9){
				bioInstruct.setTransType(Constants.ROTATETOP);
				bioInstruct.setTranslateMatrix(-0.021, 0.0, -0.01);  
				BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, -90);
				bioInstruct.setOrientation(orientationUpd);	
				bioInstruct.setPivotPoint(0);
				BioMightOrientation rotationUpd = new BioMightOrientation(1.0, 0.0, 0.0, -5.0);
				bioInstruct.setRotation(rotationUpd);
			}			
			else if (instructCount==10){
				bioInstruct.setTransType(Constants.ROTATETOP);
				bioInstruct.setTranslateMatrix(-0.02, 0.0, 0.0004);  
				BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, -90);
				bioInstruct.setOrientation(orientationUpd);	
				bioInstruct.setPivotPoint(0);
				BioMightOrientation rotationUpd = new BioMightOrientation(1.0, 0.0, 0.0, -2.0);
				bioInstruct.setRotation(rotationUpd);
			}
			else if (instructCount==11){
				bioInstruct.setTransType(Constants.ROTATETOP);
				bioInstruct.setTranslateMatrix(-0.02, 0.0, 0.01);  
				BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, -90);
				bioInstruct.setOrientation(orientationUpd);	
				bioInstruct.setPivotPoint(0);
				BioMightOrientation rotationUpd = new BioMightOrientation(1.0, 0.0, 0.0, -2.0);
				bioInstruct.setRotation(rotationUpd);
			}
			else if (instructCount==12){
				bioInstruct.setTransType(Constants.ROTATETOP);
				bioInstruct.setTranslateMatrix(-0.002, 0.0, 0.0008);  
				BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, -90);
				bioInstruct.setOrientation(orientationUpd);	
				bioInstruct.setPivotPoint(0);
				BioMightOrientation rotationUpd = new BioMightOrientation(1.0, 0.0, 0.0, -4.0);
				bioInstruct.setRotation(rotationUpd);
			}	
			else if (instructCount==13){
				bioInstruct.setTransType(Constants.ROTATETOP);
				bioInstruct.setTranslateMatrix(-0.002, 0.0, 0.0008);  
				BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, -90);
				bioInstruct.setOrientation(orientationUpd);	
				bioInstruct.setPivotPoint(0);
				BioMightOrientation rotationUpd = new BioMightOrientation(1.0, 0.0, 0.0, -3.0);
				bioInstruct.setRotation(rotationUpd);
			}
			else if (instructCount==14){
				bioInstruct.setTransType(Constants.ROTATETOP);
				bioInstruct.setTranslateMatrix(-0.002, 0.0, 0.0008);  
				BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, -90);
				bioInstruct.setOrientation(orientationUpd);	
				bioInstruct.setPivotPoint(0);
				BioMightOrientation rotationUpd = new BioMightOrientation(1.0, 0.0, 0.0, -2.0);
				bioInstruct.setRotation(rotationUpd);
			}	
			else if (instructCount==15){
				bioInstruct.setTransType(Constants.ROTATETOP);
				bioInstruct.setTranslateMatrix(-0.002, 0.0, 0.0008);  
				BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, -90);
				bioInstruct.setOrientation(orientationUpd);		
				bioInstruct.setPivotPoint(0);
				BioMightOrientation rotationUpd = new BioMightOrientation(1.0, 0.0, 0.0, -1.0);
				bioInstruct.setRotation(rotationUpd);
			}		
			else if (instructCount==16){
				bioInstruct.setTransType(Constants.ROTATETOP);
				bioInstruct.setTranslateMatrix(-0.002, 0.0, 0.0008);  
				BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, -90);
				bioInstruct.setOrientation(orientationUpd);		
				bioInstruct.setPivotPoint(0);
				BioMightOrientation rotationUpd = new BioMightOrientation(1.0, 0.0, 0.0, 0.0);
				bioInstruct.setRotation(rotationUpd);
			}
			else if (instructCount==17){
				bioInstruct.setTransType(Constants.ROTATETOP);
				bioInstruct.setTranslateMatrix(-0.002, 0.0, 0.0008);  
				BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, -90);
				bioInstruct.setOrientation(orientationUpd);	
				bioInstruct.setPivotPoint(0);
				BioMightOrientation rotationUpd = new BioMightOrientation(1.0, 0.0, 0.0, 1.0);
				bioInstruct.setRotation(rotationUpd);
			}
			else if (instructCount==18){
				bioInstruct.setTransType(Constants.ROTATETOP);
				bioInstruct.setTranslateMatrix(-0.002, 0.0, 0.0008);  
				BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, -90);
				bioInstruct.setOrientation(orientationUpd);	
				bioInstruct.setPivotPoint(0);
				BioMightOrientation rotationUpd = new BioMightOrientation(1.0, 0.0, 0.0, 4.0);
				bioInstruct.setRotation(rotationUpd);
			}			
			else if (instructCount==19){
				bioInstruct.setTransType(Constants.ROTATETOP);
				bioInstruct.setTranslateMatrix(-0.002, 0.0, 0.0008);  
				BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, -90);
				bioInstruct.setOrientation(orientationUpd);	
				bioInstruct.setPivotPoint(0);
				BioMightOrientation rotationUpd = new BioMightOrientation(1.0, 0.0, 0.0, 6.0);
				bioInstruct.setRotation(rotationUpd);
			}
			else if (instructCount==20){
				bioInstruct.setTransType(Constants.ROTATETOP);
				bioInstruct.setTranslateMatrix(-0.002, 0.0, 0.0008);  
				BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, -90);
				bioInstruct.setOrientation(orientationUpd);	
				bioInstruct.setPivotPoint(0);
				BioMightOrientation rotationUpd = new BioMightOrientation(1.0, 0.0, 0.0, 6.0);
				bioInstruct.setRotation(rotationUpd);
			}
			else if (instructCount==21){
				bioInstruct.setTransType(Constants.ROTATETOP);
				bioInstruct.setTranslateMatrix(-0.002, 0.0, 0.0008);  
				BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, -90);
				bioInstruct.setOrientation(orientationUpd);	
				bioInstruct.setPivotPoint(0);
				BioMightOrientation rotationUpd = new BioMightOrientation(1.0, 0.0, 0.0, 11.0);
				bioInstruct.setRotation(rotationUpd);
			}
			
			
			else {	
				bioInstruct.setTransType(Constants.TRANSLATE);
				BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, 90);
				bioInstruct.setOrientation(orientationUpd);
				bioInstruct.setTranslateMatrix(-0.02, 0.0, 0.0);       
			}
			
			
			
			// Add the instruction into the instruction set
    		bioMightInstructSet.addElement(bioInstruct);
		}	
			
		// Pass the instructions to the builder
		body += generateFacedComponents(bioMightTransform,  startPos, bioMightOrientation, bioMightInstructSet, wallPoints6); 	
		
	
		//*************************************
		// 4th Wall
		//*************************************
		double[][] wallPoints7 =  
				{ 
					{0.72,        0.00,       0.308},
					{0.72,        0.0325,     0.308}
				};	
		
		// Move the point around, and connect it, creating a wall of 
		// Allocate an instruction set for building it
		bioMightInstructSet = new BioMightInstructSet();
		
		numInstructions = 5;
		//BioMightOrientation bioMightOrientation = new BioMightOrientation(0.0, 0.0, 1.0, 90);
		for (int instructCount=0; instructCount<numInstructions; instructCount++)
		{
			// Create a place for an instruction 
			BioMightInstruction bioInstruct = new BioMightInstruction();
			
			// Place a transform object into each instruction set
			bioInstruct.setBioMightTransform(bioMightTransform);
		
			if (instructCount==0){
				bioInstruct.setTransType(Constants.TRANSLATE);
				bioInstruct.setTranslateMatrix(-0.02, 0.0, -0.003);  
				BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, -90);
				bioInstruct.setOrientation(orientationUpd);
			}
			else if (instructCount==1){
				bioInstruct.setTransType(Constants.TRANSLATE);				
				BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, -90);
				bioInstruct.setOrientation(orientationUpd);
				bioInstruct.setTranslateMatrix(-0.02, 0.00, -0.004);      
			}
			else if (instructCount==2){
				bioInstruct.setTransType(Constants.TRANSLATE);
				BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, 90);
				bioInstruct.setOrientation(orientationUpd);
				bioInstruct.setTranslateMatrix(-0.02, 0.0, 0.00);   
			}
			else if (instructCount==3){
				bioInstruct.setTransType(Constants.TRANSLATE);
				BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, 90);
				bioInstruct.setOrientation(orientationUpd);
				bioInstruct.setTranslateMatrix(-0.02, 0.0, 0.004);   
			}	
			else if (instructCount==4){
				bioInstruct.setTransType(Constants.TRANSLATE);
				BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, 90);
				bioInstruct.setOrientation(orientationUpd);
				bioInstruct.setTranslateMatrix(-0.02, 0.0, 0.003);   
			}			
			else {	
				bioInstruct.setTransType(Constants.TRANSLATE);
				BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, 90);
				bioInstruct.setOrientation(orientationUpd);
				bioInstruct.setTranslateMatrix(-0.02, 0.0, 0.0);       
			}
	
			// Add the instruction into the instruction set
    		bioMightInstructSet.addElement(bioInstruct);
		}	
			
		// Pass the instructions to the builder
		body += generateFacedComponents(bioMightTransform,  startPos, bioMightOrientation, bioMightInstructSet, wallPoints7); 	
					 
		//**********************************
		// The 4th Wall backplane
		//**********************************
		double[][] wallPoints8 =  
			{ 
				{0.72,        0.00,       0.308},
				{0.72,        0.0325,     0.308}
			};		
		
		// Move the point around, and connect it, creating a wall of 
		// Allocate an instruction set for building it
		bioMightInstructSet = new BioMightInstructSet();
		
		numInstructions = 23;
		//BioMightOrientation bioMightOrientation = new BioMightOrientation(0.0, 0.0, 1.0, 90);
		for (int instructCount=0; instructCount<numInstructions; instructCount++)
		{
			// Create a place for an instruction 
			BioMightInstruction bioInstruct = new BioMightInstruction();
	
			// Place a transform object into each instruction set
			bioInstruct.setBioMightTransform(bioMightTransform);
		
			if (instructCount==0){
				bioInstruct.setTransType(Constants.ROTATETOP);
				bioInstruct.setTranslateMatrix(-0.001, 0.0, -0.00025);  
				BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, -90);
				bioInstruct.setOrientation(orientationUpd);	
				bioInstruct.setPivotPoint(0);
				BioMightOrientation rotationUpd = new BioMightOrientation(1.0, 0.0, 0.0, -6.0);
				bioInstruct.setRotation(rotationUpd);
			}			
			else if (instructCount==1){
				bioInstruct.setTransType(Constants.ROTATETOP);
				bioInstruct.setTranslateMatrix(-0.002, 0.0, -0.00035);  
				BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, -90);
				bioInstruct.setOrientation(orientationUpd);	
				bioInstruct.setPivotPoint(0);
				BioMightOrientation rotationUpd = new BioMightOrientation(1.0, 0.0, 0.0, -5.0);
				bioInstruct.setRotation(rotationUpd);
			}
			else if (instructCount==2){
				bioInstruct.setTransType(Constants.ROTATETOP);
				bioInstruct.setTranslateMatrix(-0.002, 0.0, -0.0003);  
				BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, -90);
				bioInstruct.setOrientation(orientationUpd);	
				bioInstruct.setPivotPoint(0);
				BioMightOrientation rotationUpd = new BioMightOrientation(1.0, 0.0, 0.0, -4.0);
				bioInstruct.setRotation(rotationUpd);
			}
			else if (instructCount==3){
				bioInstruct.setTransType(Constants.ROTATETOP);
				bioInstruct.setTranslateMatrix(-0.002, 0.0, -0.0003);  
				BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, -90);
				bioInstruct.setOrientation(orientationUpd);	
				bioInstruct.setPivotPoint(0);
				BioMightOrientation rotationUpd = new BioMightOrientation(1.0, 0.0, 0.0, -3.0);
				bioInstruct.setRotation(rotationUpd);
			}			
			else if (instructCount==4){
				bioInstruct.setTransType(Constants.ROTATETOP);
				bioInstruct.setTranslateMatrix(-0.002, 0.0, -0.0004); 
				BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, -90);
				bioInstruct.setOrientation(orientationUpd);	
				bioInstruct.setPivotPoint(0);
				BioMightOrientation rotationUpd = new BioMightOrientation(1.0, 0.0, 0.0, 0.0);
				bioInstruct.setRotation(rotationUpd);
			}			
			else if (instructCount==5){
				bioInstruct.setTransType(Constants.ROTATETOP);
				bioInstruct.setTranslateMatrix(-0.002, 0.0, -0.0004);  
				BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, -90);
				bioInstruct.setOrientation(orientationUpd);	
				bioInstruct.setPivotPoint(0);
				BioMightOrientation rotationUpd = new BioMightOrientation(1.0, 0.0, 0.0, 3.0);
				bioInstruct.setRotation(rotationUpd);
			}
			else if (instructCount==6){
				bioInstruct.setTransType(Constants.ROTATETOP);
				bioInstruct.setTranslateMatrix(-0.002, 0.0, -0.0003);  
				BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, -90);
				bioInstruct.setOrientation(orientationUpd);	
				bioInstruct.setPivotPoint(0);
				BioMightOrientation rotationUpd = new BioMightOrientation(1.0, 0.0, 0.0, 4.0);
				bioInstruct.setRotation(rotationUpd);
			}
			else if (instructCount==7){
				bioInstruct.setTransType(Constants.ROTATETOP);
				bioInstruct.setTranslateMatrix(-0.002, 0.0, -0.0003);  
				BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, -90);
				bioInstruct.setOrientation(orientationUpd);	
				bioInstruct.setPivotPoint(0);
				BioMightOrientation rotationUpd = new BioMightOrientation(1.0, 0.0, 0.0, 2.0);
				bioInstruct.setRotation(rotationUpd);
			}			
			else if (instructCount==8){
				bioInstruct.setTransType(Constants.ROTATETOP);
				bioInstruct.setTranslateMatrix(-0.005, 0.0, -0.00025);  
				BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, -90);
				bioInstruct.setOrientation(orientationUpd);	
				bioInstruct.setPivotPoint(0);
				BioMightOrientation rotationUpd = new BioMightOrientation(1.0, 0.0, 0.0, -1.5);
				bioInstruct.setRotation(rotationUpd);
			}
			else if (instructCount==9){
				bioInstruct.setTransType(Constants.ROTATETOP);
				bioInstruct.setTranslateMatrix(-0.02, 0.0, -0.0045);  
				BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, -90);
				bioInstruct.setOrientation(orientationUpd);	
				bioInstruct.setPivotPoint(0);
				BioMightOrientation rotationUpd = new BioMightOrientation(1.0, 0.0, 0.0, -0.75);
				bioInstruct.setRotation(rotationUpd);
			}			
			else if (instructCount==10){
				bioInstruct.setTransType(Constants.ROTATETOP);
				bioInstruct.setTranslateMatrix(-0.02, 0.0, 0.00045);  
				BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, -90);
				bioInstruct.setOrientation(orientationUpd);	
				bioInstruct.setPivotPoint(0);
				BioMightOrientation rotationUpd = new BioMightOrientation(1.0, 0.0, 0.0, -1.0);
				bioInstruct.setRotation(rotationUpd);
			}
			else if (instructCount==11){
				bioInstruct.setTransType(Constants.ROTATETOP);
				bioInstruct.setTranslateMatrix(-0.02, 0.0, 0.004);  
				BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, -90);
				bioInstruct.setOrientation(orientationUpd);	
				bioInstruct.setPivotPoint(0);
				BioMightOrientation rotationUpd = new BioMightOrientation(1.0, 0.0, 0.0, -2.0);
				bioInstruct.setRotation(rotationUpd);
			}
			else if (instructCount==12){
				bioInstruct.setTransType(Constants.ROTATETOP);
				bioInstruct.setTranslateMatrix(-0.002, 0.0, 0.0002);  
				BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, -90);
				bioInstruct.setOrientation(orientationUpd);	
				bioInstruct.setPivotPoint(0);
				BioMightOrientation rotationUpd = new BioMightOrientation(1.0, 0.0, 0.0, -4.0);
				bioInstruct.setRotation(rotationUpd);
			}	
			else if (instructCount==13){
				bioInstruct.setTransType(Constants.ROTATETOP);	
				bioInstruct.setTranslateMatrix(-0.002, 0.0, 0.0003);
				BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, -90);
				bioInstruct.setOrientation(orientationUpd);	
				bioInstruct.setPivotPoint(0);
				BioMightOrientation rotationUpd = new BioMightOrientation(1.0, 0.0, 0.0, -3.0);
				bioInstruct.setRotation(rotationUpd);
			}
			else if (instructCount==14){
				bioInstruct.setTransType(Constants.ROTATETOP);
				bioInstruct.setTranslateMatrix(-0.002, 0.0, 0.0003);  
				BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, -90);
				bioInstruct.setOrientation(orientationUpd);	
				bioInstruct.setPivotPoint(0);
				BioMightOrientation rotationUpd = new BioMightOrientation(1.0, 0.0, 0.0, -2.0);
				bioInstruct.setRotation(rotationUpd);
			}	
			else if (instructCount==15){
				bioInstruct.setTransType(Constants.ROTATETOP);
				bioInstruct.setTranslateMatrix(-0.002, 0.0, 0.0003);  
				BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, -90);
				bioInstruct.setOrientation(orientationUpd);		
				bioInstruct.setPivotPoint(0);
				BioMightOrientation rotationUpd = new BioMightOrientation(1.0, 0.0, 0.0, -2.0);
				bioInstruct.setRotation(rotationUpd);
			}		
			else if (instructCount==16){
				bioInstruct.setTransType(Constants.ROTATETOP);
				bioInstruct.setTranslateMatrix(-0.002, 0.0, 0.0003);  
				BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, -90);
				bioInstruct.setOrientation(orientationUpd);		
				bioInstruct.setPivotPoint(0);
				BioMightOrientation rotationUpd = new BioMightOrientation(1.0, 0.0, 0.0, 0.0);
				bioInstruct.setRotation(rotationUpd);
			}
			else if (instructCount==17){
				bioInstruct.setTransType(Constants.ROTATETOP);
				bioInstruct.setTranslateMatrix(-0.002, 0.0, 0.0003);  
				BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, -90);
				bioInstruct.setOrientation(orientationUpd);	
				bioInstruct.setPivotPoint(0);
				BioMightOrientation rotationUpd = new BioMightOrientation(1.0, 0.0, 0.0, 3.0);
				bioInstruct.setRotation(rotationUpd);
			}
			else if (instructCount==18){
				bioInstruct.setTransType(Constants.ROTATETOP);
				bioInstruct.setTranslateMatrix(-0.002, 0.0, 0.0003);  
				BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, -90);
				bioInstruct.setOrientation(orientationUpd);	
				bioInstruct.setPivotPoint(0);
				BioMightOrientation rotationUpd = new BioMightOrientation(1.0, 0.0, 0.0, 3.5);
				bioInstruct.setRotation(rotationUpd);
			}			
			else if (instructCount==19){
				bioInstruct.setTransType(Constants.ROTATETOP);
				bioInstruct.setTranslateMatrix(-0.002, 0.0, 0.0003);  
				BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, -90);
				bioInstruct.setOrientation(orientationUpd);	
				bioInstruct.setPivotPoint(0);
				BioMightOrientation rotationUpd = new BioMightOrientation(1.0, 0.0, 0.0, 2.0);
				bioInstruct.setRotation(rotationUpd);
			}
			else if (instructCount==20){
				bioInstruct.setTransType(Constants.ROTATETOP);
				bioInstruct.setTranslateMatrix(-0.002, 0.0, 0.0003);  
				BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, -90);
				bioInstruct.setOrientation(orientationUpd);	
				bioInstruct.setPivotPoint(0);
				BioMightOrientation rotationUpd = new BioMightOrientation(1.0, 0.0, 0.0, 2.5);
				bioInstruct.setRotation(rotationUpd);
			}
			else if (instructCount==21){
				bioInstruct.setTransType(Constants.ROTATETOP);
				bioInstruct.setTranslateMatrix(-0.002, 0.0, 0.0003);  
				BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, -90);
				bioInstruct.setOrientation(orientationUpd);	
				bioInstruct.setPivotPoint(0);
				BioMightOrientation rotationUpd = new BioMightOrientation(1.0, 0.0, 0.0, 2.75);
				bioInstruct.setRotation(rotationUpd);
			}
			else if (instructCount==22){
				bioInstruct.setTransType(Constants.ROTATETOP);
				bioInstruct.setTranslateMatrix(0.00, 0.0, 0.0002);  
				BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, -90);
				bioInstruct.setOrientation(orientationUpd);	
				bioInstruct.setPivotPoint(0);
				BioMightOrientation rotationUpd = new BioMightOrientation(1.0, 0.0, 0.0, 7.0);
				bioInstruct.setRotation(rotationUpd);
			}
			
			
			
			else {	
				bioInstruct.setTransType(Constants.TRANSLATE);
				BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, 90);
				bioInstruct.setOrientation(orientationUpd);
				bioInstruct.setTranslateMatrix(-0.02, 0.0, 0.0);       
			}
			
			
			// Add the instruction into the instruction set
    		bioMightInstructSet.addElement(bioInstruct);
		}	
			
		// Pass the instructions to the builder
		body += generateFacedComponents(bioMightTransform,  startPos, bioMightOrientation, bioMightInstructSet, wallPoints8); 	

	
		
		// 5th Wall
		double[][] wallPoints9 =  
				{ 
					{0.715,        0.00,       0.2885},
					{0.715,        0.0325,     0.2885}
				};	
		
		// Move the point around, and connect it, creating a wall of 
		// Allocate an instruction set for building it
		bioMightInstructSet = new BioMightInstructSet();
		
		numInstructions = 5;
		//BioMightOrientation bioMightOrientation = new BioMightOrientation(0.0, 0.0, 1.0, 90);
		for (int instructCount=0; instructCount<numInstructions; instructCount++)
		{
			// Create a place for an instruction 
			BioMightInstruction bioInstruct = new BioMightInstruction();
			
			// Place a transform object into each instruction set
			bioInstruct.setBioMightTransform(bioMightTransform);
		
			if (instructCount==0){
				bioInstruct.setTransType(Constants.TRANSLATE);
				bioInstruct.setTranslateMatrix(-0.01, 0.0, 0.001);  
				BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, -90);
				bioInstruct.setOrientation(orientationUpd);
			}
			else if (instructCount==1){
				bioInstruct.setTransType(Constants.TRANSLATE);				
				BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, -90);
				bioInstruct.setOrientation(orientationUpd);
				bioInstruct.setTranslateMatrix(-0.02, 0.00, 0.003);      
			}
			else if (instructCount==2){
				bioInstruct.setTransType(Constants.TRANSLATE);
				BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, 90);
				bioInstruct.setOrientation(orientationUpd);
				bioInstruct.setTranslateMatrix(-0.02, 0.0, 0.00);   
			}
			else if (instructCount==3){
				bioInstruct.setTransType(Constants.TRANSLATE);
				BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, 90);
				bioInstruct.setOrientation(orientationUpd);
				bioInstruct.setTranslateMatrix(-0.02, 0.0, -0.003);   
			}	
			else if (instructCount==4){
				bioInstruct.setTransType(Constants.TRANSLATE);
				BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, 90);
				bioInstruct.setOrientation(orientationUpd);
				bioInstruct.setTranslateMatrix(-0.02, 0.0, -0.002);   
			}			
			else {	
				bioInstruct.setTransType(Constants.TRANSLATE);
				BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, 90);
				bioInstruct.setOrientation(orientationUpd);
				bioInstruct.setTranslateMatrix(-0.01, 0.0, 0.0);       
			}
	
			// Add the instruction into the instruction set
    		bioMightInstructSet.addElement(bioInstruct);
		}	
			
		// Pass the instructions to the builder
		body += generateFacedComponents(bioMightTransform,  startPos, bioMightOrientation, bioMightInstructSet, wallPoints9); 	
				
		
		// The 5th Wall backplane
		double[][] wallPoints10 =  
			{ 
				{0.715,        0.00,       0.2885},
				{0.715,        0.0325,     0.2885}
			};		
		
		// Move the point around, and connect it, creating a wall of 
		// Allocate an instruction set for building it
		bioMightInstructSet = new BioMightInstructSet();
		
		numInstructions = 20;
		//BioMightOrientation bioMightOrientation = new BioMightOrientation(0.0, 0.0, 1.0, 90);
		for (int instructCount=0; instructCount<numInstructions; instructCount++)
		{
			// Create a place for an instruction 
			BioMightInstruction bioInstruct = new BioMightInstruction();
	
			// Place a transform object into each instruction set
			bioInstruct.setBioMightTransform(bioMightTransform);
		
			if (instructCount==0){
				bioInstruct.setTransType(Constants.ROTATETOP);
				bioInstruct.setTranslateMatrix(-0.002, 0.0, 0.0002);  
				BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, -90);
				bioInstruct.setOrientation(orientationUpd);	
				bioInstruct.setPivotPoint(0);
				BioMightOrientation rotationUpd = new BioMightOrientation(1.0, 0.0, 0.0, -4.0);
				bioInstruct.setRotation(rotationUpd);
			}	
			else if (instructCount==1){
				bioInstruct.setTransType(Constants.ROTATETOP);
				bioInstruct.setTranslateMatrix(-0.002, 0.0, 0.0001);  
				BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, -90);
				bioInstruct.setOrientation(orientationUpd);	
				bioInstruct.setPivotPoint(0);
				BioMightOrientation rotationUpd = new BioMightOrientation(1.0, 0.0, 0.0, -5.0);
				bioInstruct.setRotation(rotationUpd);
			}
			else if (instructCount==2){
				bioInstruct.setTransType(Constants.ROTATETOP);
				bioInstruct.setTranslateMatrix(-0.002, 0.0, 0.0002);  
				BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, -90);
				bioInstruct.setOrientation(orientationUpd);	
				bioInstruct.setPivotPoint(0);
				BioMightOrientation rotationUpd = new BioMightOrientation(1.0, 0.0, 0.0, -5.0);
				bioInstruct.setRotation(rotationUpd);
			}
			else if (instructCount==3){
				bioInstruct.setTransType(Constants.ROTATETOP);
				bioInstruct.setTranslateMatrix(-0.002, 0.0, 0.0002);  
				BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, -90);
				bioInstruct.setOrientation(orientationUpd);	
				bioInstruct.setPivotPoint(0);
				BioMightOrientation rotationUpd = new BioMightOrientation(1.0, 0.0, 0.0, -3.0);
				bioInstruct.setRotation(rotationUpd);
			}			
			else if (instructCount==4){
				bioInstruct.setTransType(Constants.ROTATETOP);
				bioInstruct.setTranslateMatrix(-0.002, 0.0, 0.0002); 
				BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, -90);
				bioInstruct.setOrientation(orientationUpd);	
				bioInstruct.setPivotPoint(0);
				BioMightOrientation rotationUpd = new BioMightOrientation(1.0, 0.0, 0.0, 0.0);
				bioInstruct.setRotation(rotationUpd);
			}			
			else if (instructCount==5){
				bioInstruct.setTransType(Constants.ROTATETOP);
				bioInstruct.setTranslateMatrix(-0.002, 0.0, 0.0002);  
				BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, -90);
				bioInstruct.setOrientation(orientationUpd);	
				bioInstruct.setPivotPoint(0);
				BioMightOrientation rotationUpd = new BioMightOrientation(1.0, 0.0, 0.0, 3.0);
				bioInstruct.setRotation(rotationUpd);
			}
			else if (instructCount==6){
				bioInstruct.setTransType(Constants.ROTATETOP);
				bioInstruct.setTranslateMatrix(-0.002, 0.0, 0.0003);  
				BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, -90);
				bioInstruct.setOrientation(orientationUpd);	
				bioInstruct.setPivotPoint(0);
				BioMightOrientation rotationUpd = new BioMightOrientation(1.0, 0.0, 0.0, 4.0);
				bioInstruct.setRotation(rotationUpd);
			}
			else if (instructCount==7){
				bioInstruct.setTransType(Constants.ROTATETOP);
				bioInstruct.setTranslateMatrix(-0.002, 0.0, 0.0004);  
				BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, -90);
				bioInstruct.setOrientation(orientationUpd);	
				bioInstruct.setPivotPoint(0);
				BioMightOrientation rotationUpd = new BioMightOrientation(1.0, 0.0, 0.0, 2.0);
				bioInstruct.setRotation(rotationUpd);
			}			
			else if (instructCount==8){
				bioInstruct.setTransType(Constants.ROTATETOP);
				bioInstruct.setTranslateMatrix(-0.01, 0.0, 0.0015);  
				BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, -90);
				bioInstruct.setOrientation(orientationUpd);	
				bioInstruct.setPivotPoint(0);
				BioMightOrientation rotationUpd = new BioMightOrientation(1.0, 0.0, 0.0, -2.0);
				bioInstruct.setRotation(rotationUpd);
			}
			else if (instructCount==9){
				bioInstruct.setTransType(Constants.ROTATETOP);
				bioInstruct.setTranslateMatrix(-0.0040, 0.0, 0.0007);  
				BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, -90);
				bioInstruct.setOrientation(orientationUpd);	
				bioInstruct.setPivotPoint(0);
				BioMightOrientation rotationUpd = new BioMightOrientation(1.0, 0.0, 0.0, -2.0);
				bioInstruct.setRotation(rotationUpd);
			}			
			else if (instructCount==10){
				bioInstruct.setTransType(Constants.ROTATETOP);
				bioInstruct.setTranslateMatrix(-0.02, 0.0, 0.000);  
				BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, -90);
				bioInstruct.setOrientation(orientationUpd);	
				bioInstruct.setPivotPoint(0);
				BioMightOrientation rotationUpd = new BioMightOrientation(1.0, 0.0, 0.0, -1.0);
				bioInstruct.setRotation(rotationUpd);
			}
			else if (instructCount==11){
				bioInstruct.setTransType(Constants.ROTATETOP);
				bioInstruct.setTranslateMatrix(-0.02, 0.0, -0.003);  
				BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, -90);
				bioInstruct.setOrientation(orientationUpd);	
				bioInstruct.setPivotPoint(0);
				BioMightOrientation rotationUpd = new BioMightOrientation(1.0, 0.0, 0.0, 0.05);
				bioInstruct.setRotation(rotationUpd);
			}
			else if (instructCount==12){
				bioInstruct.setTransType(Constants.ROTATETOP);
				bioInstruct.setTranslateMatrix(-0.005, 0.0, -0.0005);  
				BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, -90);
				bioInstruct.setOrientation(orientationUpd);	
				bioInstruct.setPivotPoint(0);
				BioMightOrientation rotationUpd = new BioMightOrientation(1.0, 0.0, 0.0, -3.5);
				bioInstruct.setRotation(rotationUpd);
			}	
			else if (instructCount==13){
				bioInstruct.setTransType(Constants.ROTATETOP);	
				bioInstruct.setTranslateMatrix(-0.002, 0.0, -0.0002);
				BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, -90);
				bioInstruct.setOrientation(orientationUpd);	
				bioInstruct.setPivotPoint(0);
				BioMightOrientation rotationUpd = new BioMightOrientation(1.0, 0.0, 0.0, -3.0);
				bioInstruct.setRotation(rotationUpd);
			}
			else if (instructCount==14){
				bioInstruct.setTransType(Constants.ROTATETOP);	
				bioInstruct.setTranslateMatrix(-0.002, 0.0, -0.0002);
				BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, -90);
				bioInstruct.setOrientation(orientationUpd);	
				bioInstruct.setPivotPoint(0);
				BioMightOrientation rotationUpd = new BioMightOrientation(1.0, 0.0, 0.0, -1.0);
				bioInstruct.setRotation(rotationUpd);
			}
			else if (instructCount==15){
				bioInstruct.setTransType(Constants.ROTATETOP);
				bioInstruct.setTranslateMatrix(-0.002, 0.0, -0.0002);  
				BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, -90);
				bioInstruct.setOrientation(orientationUpd);		
				bioInstruct.setPivotPoint(0);
				BioMightOrientation rotationUpd = new BioMightOrientation(1.0, 0.0, 0.0, 1.0);
				bioInstruct.setRotation(rotationUpd);
			}		
			else if (instructCount==16){
				bioInstruct.setTransType(Constants.ROTATETOP);
				bioInstruct.setTranslateMatrix(-0.002, 0.0, -0.0002);  
				BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, -90);
				bioInstruct.setOrientation(orientationUpd);		
				bioInstruct.setPivotPoint(0);
				BioMightOrientation rotationUpd = new BioMightOrientation(1.0, 0.0, 0.0, 3.0);
				bioInstruct.setRotation(rotationUpd);
			}
			else if (instructCount==17){
				bioInstruct.setTransType(Constants.ROTATETOP);
				bioInstruct.setTranslateMatrix(-0.002, 0.0, -0.0002);  
				BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, -90);
				bioInstruct.setOrientation(orientationUpd);	
				bioInstruct.setPivotPoint(0);
				BioMightOrientation rotationUpd = new BioMightOrientation(1.0, 0.0, 0.0, 3.25);
				bioInstruct.setRotation(rotationUpd);
			}
			else if (instructCount==18){
				bioInstruct.setTransType(Constants.ROTATETOP);
				bioInstruct.setTranslateMatrix(-0.002, 0.0, -0.0002);  
				BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, -90);
				bioInstruct.setOrientation(orientationUpd);	
				bioInstruct.setPivotPoint(0);
				BioMightOrientation rotationUpd = new BioMightOrientation(1.0, 0.0, 0.0, 3.75);
				bioInstruct.setRotation(rotationUpd);
			}			
			else if (instructCount==19){
				bioInstruct.setTransType(Constants.ROTATETOP);
				bioInstruct.setTranslateMatrix(-0.002, 0.0, -0.0002);  
				BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, -90);
				bioInstruct.setOrientation(orientationUpd);	
				bioInstruct.setPivotPoint(0);
				BioMightOrientation rotationUpd = new BioMightOrientation(1.0, 0.0, 0.0, 7.0);
				bioInstruct.setRotation(rotationUpd);
			}
			
			
			
			else if (instructCount==20){
				bioInstruct.setTransType(Constants.ROTATETOP);
				bioInstruct.setTranslateMatrix(-0.002, 0.0, 0.0003);  
				BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, -90);
				bioInstruct.setOrientation(orientationUpd);	
				bioInstruct.setPivotPoint(0);
				BioMightOrientation rotationUpd = new BioMightOrientation(1.0, 0.0, 0.0, 2.5);
				bioInstruct.setRotation(rotationUpd);
			}

			
			else {	
				bioInstruct.setTransType(Constants.TRANSLATE);
				BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, 90);
				bioInstruct.setOrientation(orientationUpd);
				bioInstruct.setTranslateMatrix(-0.02, 0.0, 0.0);       
			}
			
			
			
			// Add the instruction into the instruction set
    		bioMightInstructSet.addElement(bioInstruct);
		}	
			
		// Pass the instructions to the builder
		body += generateFacedComponents(bioMightTransform,  startPos, bioMightOrientation, bioMightInstructSet, wallPoints10); 	

		
		
		// 6th Wall	
		double[][] wallPoints11 =  
				{ 
					{0.698,        0.00,       0.279},
					{0.698,        0.0325,     0.279}
				};	
		
		// Move the point around, and connect it, creating a wall of 
		// Allocate an instruction set for building it
		bioMightInstructSet = new BioMightInstructSet();
		
		numInstructions = 5;
		//BioMightOrientation bioMightOrientation = new BioMightOrientation(0.0, 0.0, 1.0, 90);
		for (int instructCount=0; instructCount<numInstructions; instructCount++)
		{
			// Create a place for an instruction 
			BioMightInstruction bioInstruct = new BioMightInstruction();
			
			// Place a transform object into each instruction set
			bioInstruct.setBioMightTransform(bioMightTransform);
		
			if (instructCount==0){
				bioInstruct.setTransType(Constants.TRANSLATE);
				bioInstruct.setTranslateMatrix(-0.01, 0.0, 0.0025);  
				BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, -90);
				bioInstruct.setOrientation(orientationUpd);
			}
			else if (instructCount==1){
				bioInstruct.setTransType(Constants.TRANSLATE);				
				BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, -90);
				bioInstruct.setOrientation(orientationUpd);
				bioInstruct.setTranslateMatrix(-0.01, 0.00, 0.003);      
			}
			else if (instructCount==2){
				bioInstruct.setTransType(Constants.TRANSLATE);
				BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, 90);
				bioInstruct.setOrientation(orientationUpd);
				bioInstruct.setTranslateMatrix(-0.01, 0.0, 0.00);   
			}
			else if (instructCount==3){
				bioInstruct.setTransType(Constants.TRANSLATE);
				BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, 90);
				bioInstruct.setOrientation(orientationUpd);
				bioInstruct.setTranslateMatrix(-0.01, 0.0, -0.003);   
			}	
			else if (instructCount==4){
				bioInstruct.setTransType(Constants.TRANSLATE);
				BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, 90);
				bioInstruct.setOrientation(orientationUpd);
				bioInstruct.setTranslateMatrix(-0.01, 0.0, -0.0025);   
			}			
			else {	
				bioInstruct.setTransType(Constants.TRANSLATE);
				BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, 90);
				bioInstruct.setOrientation(orientationUpd);
				bioInstruct.setTranslateMatrix(-0.02, 0.0, 0.0);       
			}
	
			// Add the instruction into the instruction set
    		bioMightInstructSet.addElement(bioInstruct);
		}	
			
		
		// Pass the instructions to the builder
		body += generateFacedComponents(bioMightTransform,  startPos, bioMightOrientation, bioMightInstructSet, wallPoints11); 	
					 

		// The 6th Wall backplane
		double[][] wallPoints12 =  
			{ 
				{0.698,        0.00,       0.279},
				{0.698,        0.0325,     0.279}
			};		
		
		// Move the point around, and connect it, creating a wall of 
		// Allocate an instruction set for building it
		bioMightInstructSet = new BioMightInstructSet();
		
		numInstructions = 16;
		//BioMightOrientation bioMightOrientation = new BioMightOrientation(0.0, 0.0, 1.0, 90);
		for (int instructCount=0; instructCount<numInstructions; instructCount++)
		{
			// Create a place for an instruction 
			BioMightInstruction bioInstruct = new BioMightInstruction();
		
			// Place a transform object into each instruction set
			bioInstruct.setBioMightTransform(bioMightTransform);
		
			
			if (instructCount==0){
				bioInstruct.setTransType(Constants.ROTATETOP);
				bioInstruct.setTranslateMatrix(-0.002, 0.0, 0.0004);  
				BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, -90);
				bioInstruct.setOrientation(orientationUpd);	
				bioInstruct.setPivotPoint(0);
				BioMightOrientation rotationUpd = new BioMightOrientation(1.0, 0.0, 0.0, -4.0);
				bioInstruct.setRotation(rotationUpd);
			}	
			else if (instructCount==1){
				bioInstruct.setTransType(Constants.ROTATETOP);
				bioInstruct.setTranslateMatrix(-0.002, 0.0, 0.0006);  
				BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, -90);
				bioInstruct.setOrientation(orientationUpd);	
				bioInstruct.setPivotPoint(0);
				BioMightOrientation rotationUpd = new BioMightOrientation(1.0, 0.0, 0.0, -3.0);
				bioInstruct.setRotation(rotationUpd);
			}
			else if (instructCount==2){
				bioInstruct.setTransType(Constants.ROTATETOP);
				bioInstruct.setTranslateMatrix(-0.002, 0.0, 0.0005);  
				BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, -90);
				bioInstruct.setOrientation(orientationUpd);	
				bioInstruct.setPivotPoint(0);
				BioMightOrientation rotationUpd = new BioMightOrientation(1.0, 0.0, 0.0, -2.0);
				bioInstruct.setRotation(rotationUpd);
			}
			else if (instructCount==3){
				bioInstruct.setTransType(Constants.ROTATETOP);
				bioInstruct.setTranslateMatrix(-0.002, 0.0, 0.0005);  
				BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, -90);
				bioInstruct.setOrientation(orientationUpd);	
				bioInstruct.setPivotPoint(0);
				BioMightOrientation rotationUpd = new BioMightOrientation(1.0, 0.0, 0.0, 0.0);
				bioInstruct.setRotation(rotationUpd);
			}			
			else if (instructCount==4){
				bioInstruct.setTransType(Constants.ROTATETOP);
				bioInstruct.setTranslateMatrix(-0.002, 0.0, 0.0005); 
				BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, -90);
				bioInstruct.setOrientation(orientationUpd);	
				bioInstruct.setPivotPoint(0);
				BioMightOrientation rotationUpd = new BioMightOrientation(1.0, 0.0, 0.0, 2.0);
				bioInstruct.setRotation(rotationUpd);
			}	
			else if (instructCount==5){
				bioInstruct.setTransType(Constants.ROTATETOP);
				bioInstruct.setTranslateMatrix(-0.002, 0.0, 0.0006); 
				BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, -90);
				bioInstruct.setOrientation(orientationUpd);	
				bioInstruct.setPivotPoint(0);
				BioMightOrientation rotationUpd = new BioMightOrientation(1.0, 0.0, 0.0, 4.5);
				bioInstruct.setRotation(rotationUpd);
			}
			else if (instructCount==6){
				bioInstruct.setTransType(Constants.ROTATETOP);
				bioInstruct.setTranslateMatrix(-0.004, 0.0, 0.0009);  
				BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, -90);
				bioInstruct.setOrientation(orientationUpd);	
				bioInstruct.setPivotPoint(0);
				BioMightOrientation rotationUpd = new BioMightOrientation(1.0, 0.0, 0.0, -1.5);
				bioInstruct.setRotation(rotationUpd);
			}
			else if (instructCount==7){
				bioInstruct.setTransType(Constants.ROTATETOP);
				bioInstruct.setTranslateMatrix(-0.004, 0.0, 0.0014);  
				BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, -90);
				bioInstruct.setOrientation(orientationUpd);	
				bioInstruct.setPivotPoint(0);
				BioMightOrientation rotationUpd = new BioMightOrientation(1.0, 0.0, 0.0, -1.25);
				bioInstruct.setRotation(rotationUpd);
			}			
			else if (instructCount==8){
				bioInstruct.setTransType(Constants.ROTATETOP);
				bioInstruct.setTranslateMatrix(-0.01, 0.0, 0.00);  
				BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, -90);
				bioInstruct.setOrientation(orientationUpd);	
				bioInstruct.setPivotPoint(0);
				BioMightOrientation rotationUpd = new BioMightOrientation(1.0, 0.0, 0.0, -1.00);
				bioInstruct.setRotation(rotationUpd);
			}
			else if (instructCount==9){
				bioInstruct.setTransType(Constants.ROTATETOP);
				bioInstruct.setTranslateMatrix(-0.0075, 0.0, -0.00225);
				BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, -90);
				bioInstruct.setOrientation(orientationUpd);	
				bioInstruct.setPivotPoint(0);
				BioMightOrientation rotationUpd = new BioMightOrientation(1.0, 0.0, 0.0, 1.00);
				bioInstruct.setRotation(rotationUpd);
			}			
			else if (instructCount==10){
				bioInstruct.setTransType(Constants.ROTATETOP);
				bioInstruct.setTranslateMatrix(-0.002, 0.0, -0.0005);  
				BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, -90);
				bioInstruct.setOrientation(orientationUpd);	
				bioInstruct.setPivotPoint(0);
				BioMightOrientation rotationUpd = new BioMightOrientation(1.0, 0.0, 0.0, -3.0);
				bioInstruct.setRotation(rotationUpd);
			}
			else if (instructCount==11){
				bioInstruct.setTransType(Constants.ROTATETOP);
				bioInstruct.setTranslateMatrix(-0.002, 0.0, -0.0005);  
				BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, -90);
				bioInstruct.setOrientation(orientationUpd);	
				bioInstruct.setPivotPoint(0);
				BioMightOrientation rotationUpd = new BioMightOrientation(1.0, 0.0, 0.0, -3.0);
				bioInstruct.setRotation(rotationUpd);
			}
			else if (instructCount==12){
				bioInstruct.setTransType(Constants.ROTATETOP);
				bioInstruct.setTranslateMatrix(-0.002, 0.0, -0.0005);  
				BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, -90);
				bioInstruct.setOrientation(orientationUpd);	
				bioInstruct.setPivotPoint(0);
				BioMightOrientation rotationUpd = new BioMightOrientation(1.0, 0.0, 0.0, 0.0);
				bioInstruct.setRotation(rotationUpd);
			}	
			else if (instructCount==13){
				bioInstruct.setTransType(Constants.ROTATETOP);
				bioInstruct.setTranslateMatrix(-0.002, 0.0, -0.0005);  
				BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, -90);
				bioInstruct.setOrientation(orientationUpd);	
				bioInstruct.setPivotPoint(0);
				BioMightOrientation rotationUpd = new BioMightOrientation(1.0, 0.0, 0.0, 2.0);
				bioInstruct.setRotation(rotationUpd);
			}
			else if (instructCount==14){
				bioInstruct.setTransType(Constants.ROTATETOP);
				bioInstruct.setTranslateMatrix(-0.002, 0.0, -0.0006);  
				BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, -90);
				bioInstruct.setOrientation(orientationUpd);	
				bioInstruct.setPivotPoint(0);
				BioMightOrientation rotationUpd = new BioMightOrientation(1.0, 0.0, 0.0, 5.0);
				bioInstruct.setRotation(rotationUpd);
			}	
			else if (instructCount==15){
				bioInstruct.setTransType(Constants.ROTATETOP);
				bioInstruct.setTranslateMatrix(-0.002, 0.0, -0.0006);  
				BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, -90);
				bioInstruct.setOrientation(orientationUpd);	
				bioInstruct.setPivotPoint(0);
				BioMightOrientation rotationUpd = new BioMightOrientation(1.0, 0.0, 0.0, 5.0);
				bioInstruct.setRotation(rotationUpd);
			}	
			
			
			else {	
				bioInstruct.setTransType(Constants.TRANSLATE);
				BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, 90);
				bioInstruct.setOrientation(orientationUpd);
				bioInstruct.setTranslateMatrix(-0.02, 0.0, 0.0);       
			}
			
			
			
			// Add the instruction into the instruction set
    		bioMightInstructSet.addElement(bioInstruct);
		}	
			
		// Pass the instructions to the builder
		body += generateFacedComponents(bioMightTransform,  startPos, bioMightOrientation, bioMightInstructSet, wallPoints12); 	

	
				
		return (body);		
	}
 	

	/***********************************************************************************************************************
  	 * GENERATE ION PUMPS
  	 *
  	 * Creates a sphere out of indexed faced sets. 
  	 * 
  	 * @param bioMightTransform
  	 * @param currentPoints
  	 * @param bHeader
  	 * @param bFooter
  	 * @param diffColor
  	 * @return
  	 ***********************************************************************************************************************/
	
  	public static String generateIonPumps(BioMightTransform bioMightTransform,  double[] startPoint) 	
	{	
		int numLongitude = 12;
		int numLatitude = 12;
		double rotateLatitude = 360/numLatitude;
		double rotateLongitude = 360/numLongitude;
		double angleLatitude = rotateLatitude;
		double angleLongitude = rotateLongitude;
		
		double radius = 0.65; // bioMightTransform.getRadius();
		double height = bioMightTransform.getHeight();
				
		double xOrient = 0.0;
		double yOrient = 1.0;
		double zOrient = 0.0;
			
		double spikeHeight = MathUtils.round(radius/50.0, 6);
		double spikeRadius = MathUtils.round(radius/100, 6);
		double halfSpike   = MathUtils.round(spikeHeight/2, 8);
		
		String body = "";
		String bioGroup = "FlagellaGroup";
		BioMightTransform baseTransform = bioMightTransform;
		
		double xStartPos = startPoint[0]; //bioMightTransform.getTranslation().getXPos();
		double yStartPos = startPoint[1]; //bioMightTransform.getTranslation().getYPos();
		double zStartPos = startPoint[2]; //bioMightTransform.getTranslation().getZPos();
		
		//System.out.println("GenerateCylindricalComponents()  Num Longitude: " + numLongitude + "     NumLatitude: " + numLatitude);
		//System.out.println("GenerateCylindricalComponents()  rotateLongitude: " + rotateLongitude + "   rotateLatitude: " + rotateLatitude);
		// Run from top of the sphere to the bottom (Longitude)
		
		//for (int longitude=0; longitude<numLongitude ;longitude++)
		for (int longitude=0; longitude<numLongitude; longitude++) 
		{
			// Run from left to right across the latitude separated points of the sphere
			angleLatitude = 0;
			//System.out.println("Completed Complete Rotation - Resetting Latitude");

			for (int latitude=0; latitude<numLatitude; latitude++)
			{	
				System.out.println("Spike - angleLongitude: " + angleLongitude + "    angleLatitude: " + angleLatitude);
				
				// Set the position on the surface of the sphere based on angle of latitude
				// Set the position on the surface of the sphere based on the longitude
				
				// Set up a Group around the whole spike
				bioGroup = "FlagellaGroup" + "L" + longitude + "L" + latitude;
				body += "\n<Transform DEF='" + bioGroup + "'\n";
				body += "  translation='" + "0.0  0.0  0.0" +  "'>\n\n";
				
				baseTransform = bioMightTransform;
				//body += "\n\n</Transform>\n\n";
				
				
				baseTransform = bioMightTransform;
				//body += "\n\n</Transform>\n\n";
			
				
				//********************************************************
				// Create the first spike
				//********************************************************
				double radiansLatitude =  Math.toRadians(angleLatitude);
				double radiansLongitude =  Math.toRadians(angleLongitude);
				System.out.println("radiansLatitude: " + radiansLatitude + " radiansLongitude: " + radiansLongitude);
				
				// Calculate sine and cosine
				double cosLat = MathUtils.round(Math.cos(radiansLatitude), 8);
				double cosLong = MathUtils.round(Math.cos(radiansLongitude), 8);
				double sinLong = MathUtils.round(Math.sin(radiansLongitude), 8);
				double sinLat = MathUtils.round(Math.sin(radiansLatitude), 8);
				
				// Set the position for the Spike.  Make it sit on the outside of the membrane
				double xPos = MathUtils.round(((radius+halfSpike) * (cosLat * sinLong)), 8);  
				double yPos = MathUtils.round(((radius+halfSpike) * cosLong), 8);
				double zPos = MathUtils.round(((radius+halfSpike) * (sinLat * sinLong)), 8); 
	
				// Translate to the offset position
				xPos += xStartPos;
				yPos += yStartPos;
				zPos += zStartPos;
				
				//System.out.println("Cos(Lat): " + cosLat + " Sin(Lat): " + sinLat + "            Sin(Long): " + sinLong + "  cos(Long): " + cosLong);
				//System.out.print   ln("XPOS: " + xPos + "=  Cos(Lat): " + cosLat + " Sin(Long): " + sinLong);
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
				
				double degrees = -radiansLongitude;	
				
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
				
				body +=  "scale='1.0 1.0 1.0'>\n\n" +
				
				 	"<Shape onmouseover=\"showComponent('Ion Pump');\" DEF='SHAPE_" + bioMightTransform.getId() + (longitude * latitude) + "' \n" +
				    " containerField='children'>\n" +
				    " <Appearance\n" +
				    "  containerField='appearance'>\n";

				body+= " <ImageTexture containerField='texture' " +
					    " url='../images/BacillusAnthracis.jpg'/>";
				
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

						
					
				// Set up a Group that assembles the flagellum
				body += "\n\n</Transform>\n\n";
				///System.out.println("\n\n CALLING ANIMATE: " + bioGroup);
			
				
	    		// Increase the angle on the arc that goes from left to right
	    		angleLatitude += rotateLatitude;
	    		//System.out.println("Incremented Latitude Angle: " + angleLatitude);
		
			}
			
			// Increase the angle on the Arc that goes top to bottom
			angleLongitude += rotateLongitude;
			//System.out.println("Incremented Longtitude Angle: " + angleLatitude);
		}
	
		return (body);
	}
  
  	
 	
  	/***********************************************************************************************************************
  	 * GENERATE BLOOD CELL
  	 * 
  	 * Creates the Blood Cell
  	 * 
  	 * @param bioMightTransform
  	 * @param currentPoints
  	 * @param bHeader
  	 * @param bFooter
  	 * @param diffColor
  	 * @return
  	 * 
  	 ***********************************************************************************************************************/
	
  	public static String generateBloodCell(BioMightTransform bioMightTransform,  BioMightPosition startPos, BioMightOrientation bioMightOrientation) 	
	{		
	  	String body = "";			
		//double xStartPos = startPos.getXPos(); 
		//double yStartPos = startPos.getYPos(); 
		//double zStartPos = startPos.getZPos();
			

		int numPoints = 8;
		double radius = 0.125;
	  	// Create a equilateral octogon	
		double x = startPos.getXPos();
		double y = startPos.getYPos();
		double z = startPos.getZPos();
		System.out.println("\n\nGenerateBloodCell() at Start Position: " + x +   ",   " + y + ",   " + z);
		
		double[][] currentPoints = BioGraphics.createCylinderInPlane(Constants.YPLANE, new double[] {x, y, z}, radius, numPoints);			

			
		// Move the point around, and connect it, creating a wall of 
		// Allocate an instruction set for building it
		BioMightInstructSet bioMightInstructSet = new BioMightInstructSet();
		
		int numInstructions = 3;
		//BioMightOrientation bioMightOrientation = new BioMightOrientation(0.0, 0.0, 1.0, 90);
		for (int instructCount=0; instructCount<numInstructions; instructCount++)
		{
			// Create a place for an instruction 
			BioMightInstruction bioInstruct = new BioMightInstruction();
			
			// Place a transform object into each instruction set
			bioInstruct.setBioMightTransform(bioMightTransform);
		
			if (instructCount==0){
    			bioInstruct.setTransType(Constants.SCALE);
    			bioInstruct.setScaleMatrix(150, 150, 150);
    			bioInstruct.setTranslateMatrix(0.0, -0.00025, 0.0);    
			}
			else if (instructCount==1){
				bioInstruct.setTransType(Constants.TRANSLATE);
				BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, 90);
				bioInstruct.setOrientation(orientationUpd);
				bioInstruct.setTranslateMatrix(0, 0.1, 0.0);   
			}
			else if (instructCount==2){
				bioInstruct.setTransType(Constants.TRANSLATE);
				BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, 90);
				bioInstruct.setOrientation(orientationUpd);
				bioInstruct.setTranslateMatrix(0.0, 0.1, 0.0);   
			}				
			else {
				bioInstruct.setTransType(Constants.TRANSLATE);
				BioMightOrientation orientationUpd = new BioMightOrientation(0.0, 0.0, -1.0, 90);
				bioInstruct.setOrientation(orientationUpd);
				bioInstruct.setTranslateMatrix(0, 0.1, 0.0);       
			}
	
			// Add the instruction into the instruction set
    		bioMightInstructSet.addElement(bioInstruct);
		}	
			
		// Pass the instructions to the builder
		body += generate4FacedComponents(bioMightTransform,  startPos, bioMightOrientation, bioMightInstructSet, currentPoints); 	
					 

				
		return (body);		
	}
  	
  	
  	
	/******************************************************************************************
	 * ANIMATE ELECTRONS
	 *
	 * This method will animate  the component.  The input comes in through the methods
	 * that are presented on the view.  
	 *****************************************************************************************/
	
	public static String animateElectrons(String bioGroup, BioMightTransform baseTransform, int transformCount) {

		System.out.println("In AnimateElectrons() Method");
		
		BioMightPosition bioMightPosition= baseTransform.getTranslation();
		System.out.println("Have Position");

		BioMightScale bioMightScale= baseTransform.getScale();		
		System.out.println("Have Scale");

		BioMightOrientation bioMightOrientationStart =  new BioMightOrientation("0.0, 1.0, 0.0, 0.0");
		BioMightOrientation bioMightOrientationEnd = new BioMightOrientation("0.0, 1.0, 0.0, 0.05");
		

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

		bioGroup += "_" + transformCount;
		String bioTimer = bioGroup + "_Timer";
		body += "\n<TimeSensor DEF='" + bioTimer + "'\n"
				+ " containerField='children'\n "
				+ " cycleInterval='" + 0.6 + "'\n "
				+ " loop='true' \n"
				+ " startTime='0.0'/> \n\n";


		System.out.println("\n\n SETup HEADER");
		
		// Setup a Script that will set the TimeStart for each
		// of
		// the animation events.
		String bioScript = bioGroup + "_ElectronScript";
		body += "<Script DEF='" + bioScript + "'>\n";

		String bioScriptStartTime = bioGroup + "_ElectronScriptStartTime";
		body += "<field name='ElectronScriptStartTime"
				+ "'  type='SFTime' accessType='outputOnly'/>\n";


		System.out.println("\n\n Setup START");
		
		String bioScriptEndTime = bioGroup + "_ElectronScriptEndTime";
		body += "<field name='ElectronScriptEndTime "
				+ "'  type='SFTime' accessType='outputOnly'/>\n";

		String bioScriptTimeVar = bioGroup + "_ElectronScriptTimeVar";
		//body += "\n<![CDATA[\n" + "ecmascript:\n"
		//		+ "function initialize_"   + bioGroup + "() {\n" + "var "
		//		+ bioScriptTimeVar
		//		+ "= new Date().getTime() + " + startTime
		//		+ ";\n" + bioScriptStartTime + " = "
		//		+ bioScriptTimeVar + ";	\n" + "}\n" + "]]>\n"
		body += "</Script>\n\n";


		System.out.println("\n\n SETup Group");
		
		String bioAnimation = bioGroup + "_ElectronAnimation";

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


		System.out.println("\n\n In ElectronAnimate, BODY: " + body);
		return (body);
	}

	
	/********************************************************************************************
	 * GENERATE FACED COMPONENTS
	 * 
	 * @param bioMightTransform
	 * @param startPos
	 * @param bioMightOrientation
	 * @param bSpikes
	 * @return
	 ********************************************************************************************/
	
	public static String generateFacedComponents(BioMightTransform bioMightTransform,  BioMightPosition startPos, BioMightOrientation bioMightOrientation, BioMightInstructSet bioMightInstructSet, double[][] currentPoints) 	
	{		
	  	String body = "";	
		
		int numSections = bioMightInstructSet.getSize();
		
		double xStartPos = startPos.getXPos(); 
		double yStartPos = startPos.getYPos(); 
		double zStartPos = startPos.getZPos();
		System.out.println("\n\nGenerateFacedComponents() at Start Position: " + xStartPos +   ",   " + yStartPos + ",   " + zStartPos);
			
		// Allocate arrays to hold the Latitutde Point positions	
		double[][] nextPoints = new double [numSections][3];	
			
	
		// Use the instructions to create the set
		for (int numSegs=0; numSegs<bioMightInstructSet.getSize();numSegs++) 
		{
			// Get the instruction from the set of instructions 
			BioMightInstruction bioInstruct = bioMightInstructSet.getElement(numSegs);
			System.out.println("Have FacedSet Instruction " + bioInstruct.getTransType());
			
			// Execute the Translation, Rotation, Scale,Shear, Reflect,Crop, etc on the object
			switch (bioInstruct.getTransType()) {
	
					// If we are performing a rotation we have to 
				// translate to the pivot point,perform the rotation, and translate back to origin
				// Here, we translate to the pivot point
				case Constants.ROTATE: 
					nextPoints = BioGraphics.applyRotation(currentPoints, bioInstruct.getPivotPoint(), Math.toRadians(bioInstruct.getTheta()), bioInstruct.getRotateVector());
					break;
					
				// Tis will be th real form as we hhave to account for world and individual orientation
				case Constants.ROTATEM:
					double[][] tempMPoints = BioGraphics.applyRotation(currentPoints, bioInstruct.getPivotPoint(), bioInstruct.getOrientation(), bioInstruct.getRotation());
					nextPoints = BioGraphics.applyTranslation(tempMPoints, bioInstruct.getTranslateMatrix());
					break;
	
				case Constants.ROTATETOP:
					System.out.println("Calling APPLY Rotation for ROTATETOP");
					double topPoint[][] = new double[1][3];
					double tempMovePoints[][] = new double[2][3];
					
					// isolate the top point
					topPoint[0] = currentPoints[1];
					double[][] topPoints = BioGraphics.applyRotation(topPoint, bioInstruct.getPivotPoint(), bioInstruct.getOrientation(), bioInstruct.getRotation());
					
					// Set up the points with the rotated point
					tempMovePoints[0] = currentPoints[0];
					tempMovePoints[1] = topPoints[0];
							
					nextPoints = BioGraphics.applyTranslation(tempMovePoints, bioInstruct.getTranslateMatrix());
						
					break;
					
				case Constants.ROTATEY: 
					nextPoints = BioGraphics.rotateY(currentPoints, bioInstruct.getTheta());
					break;
							
				case Constants.ROTATEYMOVE: 
					double[][] tempPoints = BioGraphics.rotateY(currentPoints, bioInstruct.getTheta());
					nextPoints = BioGraphics.applyTranslation(tempPoints, bioInstruct.getTranslateMatrix());
					break;
					
				case Constants.ROTATEX: 
					nextPoints = BioGraphics.rotateX(currentPoints, bioInstruct.getTheta());
					break;
	
				case Constants.ROTATEXMOVE: 
					tempPoints = BioGraphics.rotateX(currentPoints, bioInstruct.getTheta());
					nextPoints = BioGraphics.applyTranslation(tempPoints, bioInstruct.getTranslateMatrix());
					break;
					
				case Constants.ROTATEOCTO: 	
					nextPoints = BioGraphics.rotateOctogon(currentPoints, bioInstruct.getTheta(), bioInstruct.getRotateVector(), bioInstruct.getOrientation(), bioInstruct.getPivotPoint());
					break;
	
				case Constants.ROTATEMOVEOCTO: 	
					tempPoints = BioGraphics.rotateOctogon(currentPoints, bioInstruct.getTheta(), bioInstruct.getRotateVector(), bioInstruct.getOrientation(), bioInstruct.getPivotPoint());
					nextPoints = BioGraphics.applyTranslation(tempPoints, bioInstruct.getTranslateMatrix());
					break;
					
				case Constants.TRANSLATE: 
					// Just a regular translation.  No need for a pivot point
					// Apply the Transformation to all 8 points      			
					nextPoints = BioGraphics.applyTranslation(currentPoints, bioInstruct.getTranslateMatrix());
					break;
	
				case Constants.SCALE: 
					// Just a regular translation.  No need for a pivot point
					// Apply the Transformation to all 8 points      	
					nextPoints = BioGraphics.applyScale(currentPoints, bioInstruct.getTranslateMatrix(), bioInstruct.getScale());
					break;
	
			} 

			String currentVertices = "";
			String nextVertices = "";
			String vertices = "";
			String indexStr = "";

			
			// Set up the vertices for the current and next points
			currentVertices = 
				currentPoints[0][0]  + ","  + currentPoints[0][1]  + "," + currentPoints[0][2]  + ",   " +
				currentPoints[1][0]   + "," + currentPoints[1][1]  + "," + currentPoints[1][2];
			
			nextVertices = 
				nextPoints[0][0]  + ","  + nextPoints[0][1]  + "," + nextPoints[0][2]  + ",   " +
				nextPoints[1][0]   + "," + nextPoints[1][1]  + "," + nextPoints[1][2];
			
			vertices = currentVertices + ",  " + nextVertices;
			
			// Do not create on the first iteration as you need 2 to connect
			if (numSegs >= 0)
			{
				// On the first instance, we are creating both sections, and then a connecting session
				
				indexStr = "0, 1, 3, 2 -1";
	
				//*************************************************
				// X Direction
				// Connect to the prior section, depending upon the direction we are going
				//*************************************************
				// We are tracking in a negative X direction
			
				if ( bioInstruct.getOrientation().getZAxis() == -1.0  && bioInstruct.getOrientation().getDegrees() == 90)
				{	
					//indexStr = "0, 1, 3, 2 -1";
					//System.out.println("SWAP INDEX: " + indexStr);
				}
				// We are tracking in a positive X direction
				else if  ( bioInstruct.getOrientation().getZAxis() == 1.0  && bioInstruct.getOrientation().getDegrees() == -90.0)
				{	
					//indexStr = "0, 1, 3, 2 -1";
					//System.out.println("SWAP INDEX: " + indexStr);		
				}
			
			
				System.out.println("FACED SET INDEX: " + indexStr);
				System.out.println("FACED SET VERTS: " + vertices);
				
		
				String componentType = "Section_" + numSections;
				body += "<Transform DEF='" + componentType + "'\n";
				
				body += "translation='" 
				+ xStartPos + " " 
				+ yStartPos + " "
				+ zStartPos + "'\n";					
				
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
				
				body+= " <ImageTexture containerField='texture' " +
				" url='../images/SpeckledPink.png'/>";
				
				body+= " <Material DEF='Rust'\n" +
				"containerField='material'\n" +
				"ambientIntensity='" + bioMightTransform.getMaterial().getAmbientIntensity() + "'\n" +
				"shininess='" 		 + bioMightTransform.getMaterial().getShininess() + "'\n" +
				"transparency='" 	 + 0.0 + "'\n" +
				"diffuseColor='" + 
				0.0 + " " + 
				0.20 + " " +
				0.40 + "'/>\n" +
				"</Appearance>\n" +
				
				
				"<IndexedFaceSet DEF='EndoArcIFS' \n" +
				"containerField='geometry' \n" +
				"solid='false' \n" +
				"creaseAngle='" +  bioMightTransform.getCreaseAngle() + "'\n" +
				"coordIndex='" + indexStr + "'>" +
				"<Coordinate DEF='Endo_Coord' \n" + 
				"containerField='coord' point='" + vertices + "'/>\n" +
				"</IndexedFaceSet>\n" +
				"</Shape>\n" +
				
				"<TouchSensor DEF='StartEndothelium' \n" +
				" description='" + componentType + "'\n" +
				" containerField='children'/> \n" +
				
				"</Transform>\n"; 
			
			}		
		
			// Store the prior set of points
			for (int l=0; l<nextPoints.length; l++)
			{
				currentPoints[l][0] = nextPoints[l][0]; 
				currentPoints[l][1] = nextPoints[l][1]; 
				currentPoints[l][2] = nextPoints[l][2]; 
			}
			
		}
		
		
			return (body);		
	}


	
	
	/********************************************************************************************
	 * GENERATE FOUR FACED COMPONENTS
	 * 
	 * @param bioMightTransform
	 * @param startPos
	 * @param bioMightOrientation
	 * @param bSpikes
	 * @return
	 ********************************************************************************************/
	
	public static String generate4FacedComponents(BioMightTransform bioMightTransform,  BioMightPosition startPos, BioMightOrientation bioMightOrientation, BioMightInstructSet bioMightInstructSet, double[][] currentPoints) 	
	{		
	  	String body = "";	
		
		double xStartPos = startPos.getXPos(); 
		double yStartPos = startPos.getYPos(); 
		double zStartPos = startPos.getZPos();
		System.out.println("\n\nGenerate4FacedSetComponents() at Start Position: " + xStartPos +   ",   " + yStartPos + ",   " + zStartPos);
			
		// Allocate arrays to hold the points	
		int numPoints=currentPoints.length;	
		double[][] nextPoints = new double [numPoints][3];	
			
		// Use the instructions to create the set
		for (int numSegs=0; numSegs<bioMightInstructSet.getSize();numSegs++) 
		{
			// Get the instruction from the set of instrunctions 
			BioMightInstruction bioInstruct = bioMightInstructSet.getElement(numSegs);
			System.out.println("Have FacedSet Instruction " + bioInstruct.getTransType());
			
			// Execute the Translation, Rotation, Scale,Shear, Reflect,Crop, etc on the object
			switch (bioInstruct.getTransType()) {
	
					// If we are performing a rotation we have to 
				// translate to the pivot point,perform the rotation, and translate back to origin
				// Here, we translate to the pivot point
				case Constants.ROTATE: 
					nextPoints = BioGraphics.applyRotation(currentPoints, bioInstruct.getPivotPoint(), Math.toRadians(bioInstruct.getTheta()), bioInstruct.getRotateVector());
					break;
					
				// Tis will be th real form as we hhave to account for world and individual orientation
				case Constants.ROTATEM: 
					nextPoints = BioGraphics.applyRotation(currentPoints, bioInstruct.getPivotPoint(), bioInstruct.getOrientation(), bioInstruct.getRotation());
					break;
					
				case Constants.ROTATEY: 
					nextPoints = BioGraphics.rotateY(currentPoints, bioInstruct.getTheta());
					break;
							
				case Constants.ROTATEYMOVE: 
					double[][] tempPoints = BioGraphics.rotateY(currentPoints, bioInstruct.getTheta());
					nextPoints = BioGraphics.applyTranslation(tempPoints, bioInstruct.getTranslateMatrix());
					break;
					
				case Constants.ROTATEX: 
					nextPoints = BioGraphics.rotateX(currentPoints, bioInstruct.getTheta());
					break;
	
				case Constants.ROTATEXMOVE: 
					tempPoints = BioGraphics.rotateX(currentPoints, bioInstruct.getTheta());
					nextPoints = BioGraphics.applyTranslation(tempPoints, bioInstruct.getTranslateMatrix());
					break;
					
				case Constants.ROTATEOCTO: 	
					nextPoints = BioGraphics.rotateOctogon(currentPoints, bioInstruct.getTheta(), bioInstruct.getRotateVector(), bioInstruct.getOrientation(), bioInstruct.getPivotPoint());
					break;
	
				case Constants.ROTATEMOVEOCTO: 	
					tempPoints = BioGraphics.rotateOctogon(currentPoints, bioInstruct.getTheta(), bioInstruct.getRotateVector(), bioInstruct.getOrientation(), bioInstruct.getPivotPoint());
					nextPoints = BioGraphics.applyTranslation(tempPoints, bioInstruct.getTranslateMatrix());
					break;
					
				case Constants.TRANSLATE: 
					// Just a regular translation.  No need for a pivot point
					// Apply the Transformation to all 8 points      			
					nextPoints = BioGraphics.applyTranslation(currentPoints, bioInstruct.getTranslateMatrix());
					break;
	
				case Constants.SCALE: 
					// Just a regular translation.  No need for a pivot point
					// Apply the Transformation to all 8 points      	
					nextPoints = BioGraphics.applyScale(currentPoints, bioInstruct.getTranslateMatrix(), bioInstruct.getScale());
					break;
	
			} 

			String currentVertices = "";
			String nextVertices = "";
			String vertices = "";
			String indexStr = "";

			
			// Now that the points are generated, create the sides
			String componentID = "";
			for (int octopos=0; octopos<numPoints; octopos++)
			{					
			
				// Set up the vertices for the current and next points
				currentVertices = 
					currentPoints[octopos][0]  + ","  + currentPoints[0][1]  + "," + currentPoints[0][2]  + ",   " +
					currentPoints[octopos][0]   + "," + currentPoints[1][1]  + "," + currentPoints[1][2]  + ",   " +
					currentPoints[octopos][0]  + ","  + currentPoints[2][1]  + "," + currentPoints[2][2]  + ",   " +
					currentPoints[octopos][0]   + "," + currentPoints[3][1]  + "," + currentPoints[3][2];
	
				
				nextVertices = 
					nextPoints[0][0]  + ","  + nextPoints[0][1]  + "," + nextPoints[0][2]  + ",   " +
					nextPoints[1][0]   + "," + nextPoints[1][1]  + "," + nextPoints[1][2]  + ",   " +
					nextPoints[2][0]  + ","  + nextPoints[2][1]  + "," + nextPoints[2][2]  + ",   " +
					nextPoints[3][0]   + "," + nextPoints[3][1]  + "," + nextPoints[3][2];
				
				vertices = currentVertices + ",  " + nextVertices;
	  	
			
				/*
				if  (octopos < numPoints-1) {
	    		       				
					vertices = 
						cxBD  + "," + cyBD + "," + czBD + "," +
						xBD  + "," + yBD + "," + zBD + "," +
						xBD1  + "," + yBD1 + "," + zBD1 + "," +
						cx1BD  + "," + cy1BD + "," + cz1BD;
				} else {
	   			
				
					vertices = 
						cxBD  + "," + cyBD + "," + czBD + "," +
						xBD  + "," + yBD + "," + zBD + "," +
						xBD0  + "," + yBD0 + "," + zBD0 + "," +
						c0xBD  + "," + c0yBD + "," + c0zBD;
				}
	    		*/
	
						
					// Do not create the first block, as it will be picked up in te next iteration
					if (numSegs > 0)
					{
						// On the first instance, we are creating both sections, and then a connecting session
						indexStr = "0, 1, 2, 3 -1,  4, 5, 6, 7, -1,  3, 2, 5, 4 -1";
			
					
						System.out.println("FACED SET INDEX: " + indexStr);
						System.out.println("FACED SET VERTS: " + vertices);
						
				
						String componentType = "Section_" + numSegs;
						body += "<Transform DEF='" + componentType + "'\n";
						
						body += "translation='" 
						+ xStartPos + " " 
						+ yStartPos + " "
						+ zStartPos + "'\n";					
						
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
						
						body+= " <ImageTexture containerField='texture' " +
						" url='../images/SpeckledOrange.png'/>";
						
						body+= " <Material DEF='Rust'\n" +
						"containerField='material'\n" +
						"ambientIntensity='" + bioMightTransform.getMaterial().getAmbientIntensity() + "'\n" +
						"shininess='" 		 + bioMightTransform.getMaterial().getShininess() + "'\n" +
						"transparency='" 	 + 0.0 + "'\n" +
						"diffuseColor='" + 
						0.0 + " " + 
						0.20 + " " +
						0.40 + "'/>\n" +
						"</Appearance>\n" +
						
						
						"<IndexedFaceSet DEF='EndoArcIFS' \n" +
						"containerField='geometry' \n" +
						"solid='false' \n" +
						"creaseAngle='" +  bioMightTransform.getCreaseAngle() + "'\n" +
						"coordIndex='" + indexStr + "'>" +
						"<Coordinate DEF='Endo_Coord' \n" + 
						"containerField='coord' point='" + vertices + "'/>\n" +
						"</IndexedFaceSet>\n" +
						"</Shape>\n" +
						
						"<TouchSensor DEF='StartEndothelium' \n" +
						" description='" + componentType + "'\n" +
						" containerField='children'/> \n" +
						
						"</Transform>\n"; 
					
					}		
			}
			
			// Store the prior set of points
			for (int l=0; l<nextPoints.length; l++)
			{
				currentPoints[l][0] = nextPoints[l][0]; 
				currentPoints[l][1] = nextPoints[l][1]; 
				currentPoints[l][2] = nextPoints[l][2]; 
			}
			
		}
		
		
			return (body);		
	}

	
	/********************************************************************************************
	 * GENERATE INDEXED FACED COMPONENTS
	 * 
	 * @param bioMightTransform
	 * @param startPos
	 * @param bioMightOrientation
	 * @param bSpikes
	 * @return
	 ********************************************************************************************/
	
	public static String generateIndexFacedComponents(BioMightOrientation bioMightOrientation, BioMightInstructSet bioMightInstructSet, double[][] currentPoints) 	
	{		
		return (generateIndexFacedComponents(null, bioMightOrientation, bioMightInstructSet, currentPoints)); 	
	}	
		
	
	/********************************************************************************************
	 * GENERATE INDEXED FACED COMPONENTS
	 * 
	 * 
	 * @param bioMightTransform
	 * @param startPos
	 * @param bioMightOrientation
	 * @param bSpikes
	 * @return
	 ********************************************************************************************/
	
	
	public static String generateIndexFacedComponents(BioMightAppendage bioMightAppendageIn, BioMightOrientation bioMightOrientation, BioMightInstructSet bioMightInstructSet, double[][] currentPoints) 	
	{		
	  	String body = "";	
		
		System.out.println("\n\nGenerateIndexFacedSetComponents()");
			
		// Allocate arrays to hold the points	
		int numPoints=currentPoints.length;	
		double[][] nextPoints = new double [numPoints][3];	
			
		// Use the instructions to create the set
		for (int numSegs=0; numSegs<bioMightInstructSet.getSize();numSegs++) 
		{
			// Get the instruction from the set of instrunctions 
			BioMightInstruction bioInstruct = bioMightInstructSet.getElement(numSegs);
			//System.out.println("Have FacedSet Instruction " + bioInstruct.getTransType());
			
			//System.out.println("\nInstruction Texture in FACED: " + bioInstruct.getBioMightTransform().getTextureFile());
			
			// Execute the Translation, Rotation, Scale,Shear, Reflect,Crop, etc on the object
			switch (bioInstruct.getTransType()) {
	
					// If we are performing a rotation we have to 
				// translate to the pivot point,perform the rotation, and translate back to origin
				// Here, we translate to the pivot point
				case Constants.ROTATE: 
					nextPoints = BioGraphics.applyRotation(currentPoints, bioInstruct.getPivotPoint(), Math.toRadians(bioInstruct.getTheta()), bioInstruct.getRotateVector());
					break;
					
				// Tis will be th real form as we hhave to account for world and individual orientation
				case Constants.ROTATEM: 
					nextPoints = BioGraphics.applyRotation(currentPoints, bioInstruct.getPivotPoint(), bioInstruct.getOrientation(), bioInstruct.getRotation());
					break;
					
				case Constants.ROTATEY: 
					nextPoints = BioGraphics.rotateY(currentPoints, bioInstruct.getTheta());
					break;
							
				case Constants.ROTATEYMOVE: 
					double[][] tempPoints = BioGraphics.rotateY(currentPoints, bioInstruct.getTheta());
					nextPoints = BioGraphics.applyTranslation(tempPoints, bioInstruct.getTranslateMatrix());
					break;
					
				case Constants.ROTATEX: 
					nextPoints = BioGraphics.rotateX(currentPoints, bioInstruct.getTheta());
					break;
	
				case Constants.ROTATEXMOVE: 
					tempPoints = BioGraphics.rotateX(currentPoints, bioInstruct.getTheta());
					nextPoints = BioGraphics.applyTranslation(tempPoints, bioInstruct.getTranslateMatrix());
					break;
					
				case Constants.ROTATEOCTO: 	
					nextPoints = BioGraphics.rotateOctogon(currentPoints, bioInstruct.getTheta(), bioInstruct.getRotateVector(), bioInstruct.getOrientation(), bioInstruct.getPivotPoint());
					break;
	
				case Constants.ROTATEMOVEOCTO: 	
					tempPoints = BioGraphics.rotateOctogon(currentPoints, bioInstruct.getTheta(), bioInstruct.getRotateVector(), bioInstruct.getOrientation(), bioInstruct.getPivotPoint());
					nextPoints = BioGraphics.applyTranslation(tempPoints, bioInstruct.getTranslateMatrix());
					break;
					
				case Constants.TRANSLATE: 
					// Just a regular translation.  No need for a pivot point
					// Apply the Transformation to all 8 points      			
					nextPoints = BioGraphics.applyTranslation(currentPoints, bioInstruct.getTranslateMatrix());
					break;
	
				case Constants.SCALE: 
					// Just a regular translation.  No need for a pivot point
					// Apply the Transformation to all 8 points      	
					nextPoints = BioGraphics.applyScale(currentPoints, bioInstruct.getTranslateMatrix(), bioInstruct.getScale());
					break;
	
			} 
			

			
			// Now that the points are generated, create the sides
			// If we are creating an octogon, that would be 4 sides
			String topRowVertices = "";
			String bottomRowVertices = "";

			String componentID = "";
			double latAngle = 0;
			
			// Grab data from the instruction set
			BioMightTransform bioMightTransform = bioInstruct.getBioMightTransform();
			BioMightAppendage instructAppendage = bioInstruct.getBioMightAppendage();
			boolean bFill = bioInstruct.isFillAppendage();
			
			//**********************************************************************
			// Add Appendages to the indexed faced object that is being constructed
			//**********************************************************************
			
			// Set to the default base value
			BioMightAppendage bioMightAppendage = bioMightAppendageIn;
			if (instructAppendage != null)
			{
				//System.out.println("NOT NULL - Generating Appendage using instruction info: " + numSegs);
				bioMightAppendage = instructAppendage;
			}	
			//else
			//	System.out.println("NULL - Instruction Set Appendage is NULL: " + numSegs);
						
			
			for (int point=0; point<numPoints; point++)
			{						
				// Set up the vertices for the current and next points
				/// build the top row
				if (point==0)
					topRowVertices = "\n" + currentPoints[point][0]  + ", " +  currentPoints[point][1] + ", " + currentPoints[point][2];
				else
					topRowVertices += ",\n  " + currentPoints[point][0]  + ",  " +  currentPoints[point][1] + ",  " + currentPoints[point][2];		
		
				// Buid the bottom row
				if (point==0)
					bottomRowVertices = "\n" + nextPoints[point][0]  + ", " +  nextPoints[point][1] + ", " + nextPoints[point][2];
				else
					bottomRowVertices += ",\n  " + nextPoints[point][0]  + ",  " +  nextPoints[point][1] + ",  " + nextPoints[point][2];		


				// Now connect the points together into quadrangle 
				double sectionAngle = MathUtils.round(360/numPoints, 4);
						
				double planePoints[][] = new double[2][3];
						

				if (bioMightAppendage != null)
				{	
					String tempTexture = bioMightTransform.getTextureFile();
					// Appendage Color
					//bioMightTransform.setTextureFile("SpeckledGreen.png");
					//System.out.println("Generating Appendage using HCColor: SpeckledGreen " + "base color: " + tempTexture);
		
					//*******************************************
					// Generate an Appendage at the Point
					//*******************************************
					BioMightPosition spikePos = new BioMightPosition(currentPoints[point][0], currentPoints[point][1], currentPoints[point][2]);
					double currentRadius = bioMightTransform.getRadius() + 0.0125;
				
					bioMightTransform.setTranslation(spikePos);
					bioMightTransform.setRadius(currentRadius);
					//System.out.println("Generating Point Appendage using radius: " + currentRadius + "   LatAngle: " + latAngle);
				
					bioMightAppendage.setLatitude(latAngle);
					body += generateAppendage(bioMightAppendage, bioMightTransform);
				
					if (bFill)
					{
						// Connect up, cannot exceed the limits
						if (point < numPoints-1)
						{
							//*****************************************************
							//
							// Generate Appendages between points on the current ring
							// The top for one is the bottom for the other
							//
							//*****************************************************
	
							BioMightPosition startPosition = new BioMightPosition(
									currentPoints[point][0],
									currentPoints[point][1],
									currentPoints[point][2]);
							
							BioMightPosition endPosition = new BioMightPosition(
									currentPoints[point+1][0],
									currentPoints[point+1][1],
									currentPoints[point+1][2]);
							
							int nMaxAppendages = 4;
							double partitionAngle = MathUtils.round((sectionAngle/nMaxAppendages), 8);	
							double midAngle = latAngle+partitionAngle;
							for (int numAppendage=0; numAppendage<nMaxAppendages; numAppendage++)
							{
								double[] centerPoint = getLineDivided(startPosition, endPosition, (numAppendage+1) * 0.25);
								//double[] centerPoint = getLineDivided(planePoints, numAppendage+1, nMaxAppendages);
								
								BioMightPosition centerPeg = new BioMightPosition(centerPoint[0], centerPoint[1], centerPoint[2]);
								//System.out.println("Generating Appendage between Ring: " + numAppendage + "   partitionAngle: " + partitionAngle + "   midAngle: " + midAngle);
								//System.out.println("Generating Appendage between Ring using radius: " + currentRadius + "   Base LatAngle: " + midAngle);
								bioMightTransform.setTranslation(centerPeg);
								
								bioMightAppendage.setLatitude(midAngle);
								body += generateAppendage(bioMightAppendage, bioMightTransform);
								
								midAngle += partitionAngle;
							}
							
				
				
							//*****************************************************
							//
							// Generate Appendages between the rings
							//
							//*****************************************************
	
							// Store the positions as we create the appendages
							ArrayList bioStartPositions = new ArrayList();
							
							// Set up the 						
							startPosition = new BioMightPosition(
									currentPoints[point][0],
									currentPoints[point][1],
									currentPoints[point][2]);
									
							endPosition = new BioMightPosition(
									nextPoints[point][0],
									nextPoints[point][1],
									nextPoints[point][2]);
							
							nMaxAppendages = 4;
							partitionAngle = MathUtils.round((sectionAngle/nMaxAppendages), 8);	
							midAngle = latAngle+partitionAngle;
							for (int numAppendage=0; numAppendage<nMaxAppendages; numAppendage++)
							{
								double[] centerPoint = getLineDivided(startPosition, endPosition, (numAppendage+1) * 0.25);
								
								// Convert the double position into a BioMightPosition object
								BioMightPosition centerPeg = new BioMightPosition(centerPoint[0], centerPoint[1], centerPoint[2]);
								
								// Store the Position of the appendage as we will use later
								bioStartPositions.add(centerPeg);
								
								//System.out.println("Generating CenterAppendage AcrossRings for: " + numAppendage + "   partitionAngle: " + partitionAngle);
								//System.out.println("Generating CenterAppendage AcrossRings using radius: " + currentRadius + "   Base LatAngle: " + latAngle + "  midAngle: " + midAngle);
								bioMightTransform.setTranslation(centerPeg);
								
								bioMightAppendage.setLatitude(midAngle);
								body += generateAppendage(bioMightAppendage, bioMightTransform);
								
								midAngle += partitionAngle;
							}
							
						
							//*****************************************************
							//
							// Generate Points between the rings on the opposite side
							//
							//*****************************************************
	
							// Store the positions as we create the appendages
							ArrayList bioEndPositions = new ArrayList();
							
							// Set up the 						
							startPosition = new BioMightPosition(
									currentPoints[point+1][0],
									currentPoints[point+1][1],
									currentPoints[point+1][2]);
									
							endPosition = new BioMightPosition(
									nextPoints[point+1][0],
									nextPoints[point+1][1],
									nextPoints[point+1][2]);
							
							nMaxAppendages = 4;
							for (int numAppendage=0; numAppendage<nMaxAppendages; numAppendage++)
							{
								double[] centerPoint = getLineDivided(startPosition, endPosition, (numAppendage+1) * 0.25);
								//double[] centerPoint = getLineDivided(planePoints, numAppendage+1, nMaxAppendages);
								BioMightPosition centerPeg = new BioMightPosition(centerPoint[0], centerPoint[1], centerPoint[2]);
	
								// Store the Position of the appendage as we will use later
								bioEndPositions.add(centerPeg);
								
								//System.out.println("Generating EndAppendage for: " + numAppendage + "   partitionAngle: " + partitionAngle);
								//System.out.println("Generating EndAppendage using radius: " + currentRadius + "   Base LatAngle: " + latAngle + "  midAngle: " + midAngle);
							}
							
						
							// These are the positions on the column line
							// We cannot draw until we have two sets of columns
							for (int row=0; row<bioStartPositions.size(); row++)
							{
								nMaxAppendages = 4;
								partitionAngle = MathUtils.round((sectionAngle/nMaxAppendages), 8);	
							
								startPosition = (BioMightPosition) bioStartPositions.get(row); 
								endPosition = (BioMightPosition) bioEndPositions.get(row); 
								
								
								for (int numAppendage=0; numAppendage<nMaxAppendages; numAppendage++)
								{
									double[] centerPoint = getLineDivided(startPosition, endPosition, (numAppendage+1) * 0.25);
									//double[] centerPoint = getLineDivided(planePoints, numAppendage+1, nMaxAppendages);
									
									midAngle = latAngle+partitionAngle;
									BioMightPosition centerPeg = new BioMightPosition(centerPoint[0], centerPoint[1], centerPoint[2]);
									
									
									//System.out.println("Generating CenterAppendage for: " + numAppendage + "   partitionAngle: " + partitionAngle);
									//System.out.println("Generating CenterAppendage using radius: " + currentRadius + "   LatAngle: " + midAngle);
									bioMightTransform.setTranslation(centerPeg);
									
									bioMightAppendage.setLatitude(midAngle);
									body += generateAppendage(bioMightAppendage, bioMightTransform);
								}
								
							}	
						
						}
					}
					
					// Set the Color back to what it was
					bioMightTransform.setTextureFile(tempTexture);
					//System.out.println("Reset - Generating IFS using Color: " + tempTexture);
				}
				//else
				//	System.out.println("NOT Generating Appendage for Segment: " + numSegs);
				
				
				latAngle += sectionAngle;
			}
			String vertices = topRowVertices + "," + bottomRowVertices;
			//System.out.println("COORDS are: " + vertices);
			
			
			String tempIndexStr = "";
			for (int point=0; point<numPoints; point++)
			{
				
				if (point==0)
				{	
					tempIndexStr = " " +  
							(point+1)     	+ "  " +
							 point 			+ "  " +
							(point+numPoints) 	+ "  " +
							(point+numPoints+1) + "  -1";
				}	
				else if (point==(numPoints-1))
				{	
					tempIndexStr += ", " +  
							0    			+ "  " +
							(numPoints-1) + "  " +
							(2*numPoints-1) 	+ "  " +
							numPoints + "  -1";
				}
				else
				{	
					tempIndexStr += ", " +  
							(point+1) 		+ "  " +
							 point 			+ "  " +
							(point+numPoints) + "  " +
							(point+numPoints+1) + "  -1";			
				}	
			}
			//System.out.println("********* Index is: " + tempIndexStr);	

			
	
			String componentType = "Section_" + numSegs;
			body += "<Transform  onmouseover=\"showComponent('" + bioMightTransform.getComponentName() +  "');\"  DEF='" + componentType + "'\n";
			
			//body += "translation='" 
			//+ xStartPos + " " 
			//+ yStartPos + " "
			//+ zStartPos + "'\n";					
			
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
		
			//System.out.println("Using Transform in RetroVirusCapsid InstructionSet: " 
			//+ numSegs + "   " + bioMightTransform.getTextureFile() + "  " + bioMightTransform.getTextureID());

			
			if (bioMightTransform.getTextureID() > 0) {
				body+= " <ImageTexture containerField='texture' url='../images/" +
	    			 bioMightTransform.getTextureFile() +  "' />";
				}
			else
			{
				body+= " <ImageTexture containerField='texture' " +
						" url='../images/StaphylococcusAureus.png'/>";
			}
			
			body+= " <Material DEF='Rust'\n" +
			"containerField='material'\n" +
			"ambientIntensity='" + bioMightTransform.getMaterial().getAmbientIntensity() + "'\n" +
			"shininess='" 		 + bioMightTransform.getMaterial().getShininess() + "'\n" +
			"transparency='" 	 + 0.35 + "'\n" +
			"diffuseColor='" + 
			0.0 + " " + 
			0.20 + " " +
			0.40 + "'/>\n" +
			"</Appearance>\n" +
			
			
			"<IndexedFaceSet DEF='EndoArcIFS' \n" +
			"containerField='geometry' \n" +
			"solid='false' \n" +
			"creaseAngle='" +  bioMightTransform.getCreaseAngle() + "'\n" +
			"coordIndex='" + tempIndexStr + "'>" +
			"<Coordinate DEF='Endo_Coord' \n" + 
			"containerField='coord' point='" + vertices + "'/>\n" +
			"</IndexedFaceSet>\n" +
			"</Shape>\n" +
			
			"<TouchSensor DEF='StartEndothelium' \n" +
			" description='" + componentType + "'\n" +
			" containerField='children'/> \n" +
			
			"</Transform>\n"; 
			
	
			
			// Store the prior set of points
			for (int l=0; l<nextPoints.length; l++)
			{
				currentPoints[l][0] = nextPoints[l][0]; 
				currentPoints[l][1] = nextPoints[l][1]; 
				currentPoints[l][2] = nextPoints[l][2]; 
			}
			
		}
		
		
			return (body);		
	}


	/********************************************************************************************
	 * GENERATE SPHERES
	 * 
	 * Use an instruction set of Translations to place spheres in 3D space
	 * 
	 * @param bioMightTransform
	 * @param startPos
	 * @param bioMightOrientation
	 * @param bSpikes
	 * @return
	 ********************************************************************************************/
	
	public static String generateSpheres(BioMightOrientation bioMightOrientation, BioMightInstructSet bioMightInstructSet, double[] currentPoint) 	
	{		
	  	String body = "";	
		
		System.out.println("\n\nGenerateSpheres()");
			
		// Keep track of were we are	
		double[] nextPoint = {0,0,0};
			
		// Use the instructions to create the set
		for (int numSegs=0; numSegs<bioMightInstructSet.getSize();numSegs++) 
		{
			// Get the instruction from the set of instrunctions 
			BioMightInstruction bioInstruct = bioMightInstructSet.getElement(numSegs);
			//System.out.println("Have FacedSet Instruction " + bioInstruct.getTransType());
			
			// Execute the Translation, Rotation, Scale,Shear, Reflect,Crop, etc on the object
			switch (bioInstruct.getTransType()) {
	
				case Constants.TRANSLATE: 	
					nextPoint = BioGraphics.applyTranslation(currentPoint, bioInstruct.getTranslateMatrix());
					break;
	
			} 

			BioMightTransform bioMightTransform = bioInstruct.getBioMightTransform();
			BioMightPosition position = new BioMightPosition(nextPoint[0], nextPoint[1], nextPoint[2]);
			bioMightTransform.setTranslation(position);
			body += generateSphereSimple(bioMightTransform);
			
			currentPoint = nextPoint; 		
		}	
		
		
			return (body);		
	}
	
	
	/***********************************************************************************************************************
	 * CREATE FLAGELLATED SPHERE
	 * 
	 * @param bioMightTransform
	 * @param currentPoints
	 * @param bHeader
	 * @param bFooter
	 * @param diffColor
	 * @return
	 ***********************************************************************************************************************/
	
	public static String generateFlagellatedSphere(BioMightTransform bioMightTransform,  double[] startPos) 	
	{	
		int numLongitude = 12;
		int numLatitude = 12;
		double rotateLatitude = 360/numLatitude;
		double rotateLongitude = 360/numLongitude;
		double angleLatitude = rotateLatitude;
		double angleLongitude = rotateLongitude;
		
		double radius = bioMightTransform.getRadius();
		double height = bioMightTransform.getHeight();
				
		double xOrient = 0.0;
		double yOrient = 1.0;
		double zOrient = 0.0;
			
		double spikeHeight = MathUtils.round(radius/10, 6);
		double spikeRadius = MathUtils.round(radius/100, 6);
		double halfSpike   = MathUtils.round(spikeHeight/2, 8);
		
		String body = "";
		String bioGroup = "FlagellaGroup";
		BioMightTransform baseTransform = bioMightTransform;
		
		
		double xStartPos = startPos[0]; //bioMightTransform.getTranslation().getXPos();
		double yStartPos = startPos[1]; //bioMightTransform.getTranslation().getYPos();
		double zStartPos = startPos[2]; //bioMightTransform.getTranslation().getZPos();
		
		//***************************************************************
		// Create the Sphere that represents the Cell Membrane
		//****************************************************************
		body += "<Transform DEF='TRANSFORM_Membrane_" + bioMightTransform.getId() + "' \n";
									
		body += "translation='" 
			+ xStartPos + " " 
			+ yStartPos + " "
			+ zStartPos + "'\n";					
	
	
		 					
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
		 	"<Sphere DEF='GonococciGeoSphere'\n" +
		 	"containerField='geometry'\n" +
		 	"radius='" + radius +"'/>\n" +
		 	"</Shape>\n" +
		 	
			"\n<TouchSensor DEF='TSENSOR_" + bioMightTransform.getId() + "' \n" +
	           " description='Gonococci'\n" +
	           " containerField='children'/> \n" +
	
		 "</Transform>\n";
		
		
			
		//System.out.println("GenerateCylindricalComponents()  Num Longitude: " + numLongitude + "     NumLatitude: " + numLatitude);
		//System.out.println("GenerateCylindricalComponents()  rotateLongitude: " + rotateLongitude + "   rotateLatitude: " + rotateLatitude);
		// Run from top of the sphere to the bottom (Longitude)
		
		//for (int longitude=0; longitude<numLongitude ;longitude++)
		for (int longitude=0; longitude<numLongitude; longitude++) 
		{
			// Run from left to right across the latitude separated points of the sphere
			angleLatitude = 0;
			//System.out.println("Completed Complete Rotation - Resetting Latitude");
	
			for (int latitude=0; latitude<numLatitude; latitude++)
			{					
				//System.out.println("GenerateCylindricalComponents - angleLongitude: " + angleLongitude + "    angleLatitude: " + angleLatitude);
				
				// Set the position on the surface of the sphere based on angle of latitude
				// Set the position on the surface of the sphere based on the longitude
				
				// Set up a Group around the whole spike
				bioGroup = "FlagellaGroup" + "L" + longitude + "L" + latitude;
				body += "\n<Transform DEF='" + bioGroup + "'\n";
				body += "  translation='" + bioMightTransform.getTranslation().getPositionStr() +  "'>\n\n";
				
				baseTransform = bioMightTransform;
				//body += "\n\n</Transform>\n\n";
				
				
				baseTransform = bioMightTransform;
				//body += "\n\n</Transform>\n\n";
			
				
				//********************************************************
				// Create the first spike
				//********************************************************
				double radiansLatitude =  Math.toRadians(angleLatitude);
				double radiansLongitude =  Math.toRadians(angleLongitude);
				System.out.println("radiansLatitude: " + radiansLatitude + " radiansLongitude: " + radiansLongitude);
				
				// Calculate sine and cosine
				double cosLat = MathUtils.round(Math.cos(radiansLatitude), 8);
				double cosLong = MathUtils.round(Math.cos(radiansLongitude), 8);
				double sinLong = MathUtils.round(Math.sin(radiansLongitude), 8);
				double sinLat = MathUtils.round(Math.sin(radiansLatitude), 8);
				
				// Set the position for the Spike.  Make it sit on the outside of the membrane
				double xPos = MathUtils.round(((radius+halfSpike) * (cosLat * sinLong)), 8);  
				double yPos = MathUtils.round(((radius+halfSpike) * cosLong), 8);
				double zPos = MathUtils.round(((radius+halfSpike) * (sinLat * sinLong)), 8); 
	
				// Translate to the offset position
				xPos += xStartPos;
				yPos += yStartPos;
				zPos += zStartPos;
				
				//System.out.println("Cos(Lat): " + cosLat + " Sin(Lat): " + sinLat + "            Sin(Long): " + sinLong + "  cos(Long): " + cosLong);
				//System.out.print   ln("XPOS: " + xPos + "=  Cos(Lat): " + cosLat + " Sin(Long): " + sinLong);
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
					+ degrees + "'>\n"
							+ "\n";
				
				body +=  "scale='1 1 1'>\n" +
				 	"<Shape DEF='SHAPE_" + bioMightTransform.getId() + (longitude * latitude) + "' \n" +
				    " containerField='children'>\n" +
				    " <Appearance\n" +
				    "  containerField='appearance'>\n";
	
				body+= " <ImageTexture containerField='texture' " +
					    " url='../images/BacillusAnthracis.jpg'/>";
				
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
				System.out.println("StartPoint (SphereCenter): " + xSpikePos + "  " + xSpikePos +  "  " +  xSpikePos);
			
				
				xSpikePos += xStartPos;
				ySpikePos += yStartPos;
				zSpikePos += zStartPos;
		
				
				
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
					// Create SPHERE connector where the position is
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
	
	
					//body+= " <ImageTexture containerField='texture' " +
					//   " url='../images/BacillusAnthracis.jpg'/>";
			
					    	
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
					double calculatedPoint[][] =  BioGraphics.applyRotation(new double [][] {{0, halfSpike, 0}}, -1, MathUtils.round(Math.toDegrees(spikeDegrees), 4), new double [] {xOrient, yOrient, zOrient} );
							
					// Extract the computed values
					double xPosCalc = calculatedPoint[0][0]; 
					double yPosCalc = calculatedPoint[0][1];
					double zPosCalc = calculatedPoint[0][2]; 
	
					// The Constant Point based on the Sphere Equation
					System.out.println("Spike StartPoint (Center): " + xSpikePos + "  " + xSpikePos +  "  " +  xSpikePos);
					System.out.println("Calculated CenterPoint Translate : " + xPosCalc + "  " + yPosCalc +  "  " +  zPosCalc);
					double newPoints[] = BioGraphics.applyTranslation(new double [] {xSpikePos, ySpikePos, zSpikePos}, new double [] {xPosCalc, yPosCalc, zPosCalc});
				
					double xCurSpikePos = newPoints[0];
					double yCurSpikePos = newPoints[1];
					double zCurSpikePos = newPoints[2];
					System.out.println("New CenterPoint: " + xCurSpikePos + "  " + yCurSpikePos +  "  " +  zCurSpikePos);
					
					
					// Set up the EndPoint/BeginPoint for the next Cylinder.   We should need to displace the distance twice
					// as the endpoint is twice the distance of what we are currently at.	    
					newPoints = BioGraphics.applyTranslation(new double [] {xSpikePos, ySpikePos, zSpikePos}, new double [] {2*xPosCalc, 2*yPosCalc, 2*zPosCalc} );
					xSpikePos = newPoints[0];
					ySpikePos = newPoints[1];
					zSpikePos = newPoints[2];
				    System.out.println("X Y Z for Spike Updated: " + xSpikePos + "  " + ySpikePos +  "  " +  zSpikePos);
					
				
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
							+ spikeDegrees + "'>\n\n";
		
					 					
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
				///System.out.println("\n\n CALLING ANIMATE: " + bioGroup);
				//body += animate(bioGroup, baseTransform);
				//System.out.println("\n\n COMPLETED ANIMATE: " + bioGroup);
	
	
				
	    		// Increase the angle on the arc that goes from left to right
	    		angleLatitude += rotateLatitude;
	    		//System.out.println("Incremented Latitude Angle: " + angleLatitude);
			}
				
			// Increase the angle on the Arc that goes top to bottom
			angleLongitude += rotateLongitude;
			//System.out.println("Incremented Longtitude Angle: " + angleLatitude);
		}
	
		return (body);
	}
	

	
	
	/***********************************************************************************************************************
  	 * CREATE NEURON
  	 *
  	 * Creates a Neuron out of indexed faced sets. 
  	 * 
  	 * @param bioMightTransform
  	 * @param currentPoints
  	 * @param bHeader
  	 * @param bFooter
  	 * @param diffColor
  	 * @return
  	 ***********************************************************************************************************************/
	
  	public static String generateNeuron(BioMightTransform bioMightTransform,  double[] startPoint) 	
	{	
	
	  	String body = "";
		int numLongitude = 2;
		int numLatitude = 12;
		double rotateLatitude = 360/numLatitude;
		double rotateLongitude = 10;;
		double angleLatitude = rotateLatitude;
		double angleLongitude = 175;
		double xOrient = 0.0;
		double yOrient = 1.0;
		double zOrient = 0.0;
	
		double radius = (bioMightTransform.getRadius());
		double height =  bioMightTransform.getHeight();
	
		double spikeHeight =  0.0875;
		double spikeRadius = 0.00825;
		double halfSpike = MathUtils.round(spikeHeight/2, 8);
		 
			
		String bioGroup = "FlagellaGroup";
		BioMightTransform baseTransform = bioMightTransform;
		
		
		double[][] lastPoints = new double [numLatitude][3];
		double[][] currentPoints = new double [numLatitude][3];		
	
		for (int cells=0; cells<1; cells++)
		{
			
		
			System.out.println("GenerateCylindricalComponents()  Num Longitude: " + numLongitude + "     NumLatitude: " + numLatitude);
			System.out.println("GenerateCylindricalComponents()  rotateLongitude: " + rotateLongitude + "   rotateLatitude: " + rotateLatitude);
			
			// Run from top of the sphere to the bottom (Longitude)
			
			//for (int longitude=0; longitude<numLongitude ;longitude++)
			for (int longitude=0; longitude<numLongitude; longitude++) 
			{
				// Run from left to right across the latitude separated points of the sphere
				angleLatitude = 0;
				//System.out.println("Completed Complete Rotation - Resetting Latitude");
	
				for (int latitude=0; latitude<numLatitude; latitude++)
				{					
					//System.out.println("GenerateCylindricalComponents - angleLongitude: " + angleLongitude + "    angleLatitude: " + angleLatitude);
					
					// Set the position on the surface of the sphere based on angle of latitude
					// Set the position on the surface of the sphere based on the longitude
					
					// Set up a Group around the whole spike
					//bioGroup = "FlagellaGroup" + "L" + longitude + "L" + latitude;
					//body += "\n<Transform DEF='" + bioGroup + "'\n";
					//body += "  translation='" + bioMightTransform.getTranslation().getPositionStr() +  "'>\n\n";
					
					baseTransform = bioMightTransform;
					//body += "\n\n</Transform>\n\n";
								
					
					//********************************************************
					// Create the first spike
					//********************************************************
					double radiansLatitude =  Math.toRadians(angleLatitude);
					double radiansLongitude =  Math.toRadians(angleLongitude);
					System.out.println("radiansLatitude: " + radiansLatitude + " radiansLongitude: " + radiansLongitude);
					
					// Calculate sine and cosine
					double cosLat = MathUtils.round(Math.cos(radiansLatitude), 8);
					double cosLong = MathUtils.round(Math.cos(radiansLongitude), 8);
					double sinLong = MathUtils.round(Math.sin(radiansLongitude), 8);
					double sinLat = MathUtils.round(Math.sin(radiansLatitude), 8);
					
							
					// Set the position for the Spike.  Make it sit on the outside of the membrane
					double xPos = MathUtils.round(((radius+halfSpike) * (cosLat * sinLong)), 8);  
					double yPos = MathUtils.round(((radius+halfSpike) * cosLong), 8);
					double zPos = MathUtils.round(((radius+halfSpike) * (sinLat * sinLong)), 8); 
		
					// Store all the latitude current points for the given longitude
					currentPoints[latitude][0] = xPos;
					currentPoints[latitude][1] = yPos;
					currentPoints[latitude][2] = zPos;
									
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
					
					/*
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
	
					body+= " <ImageTexture containerField='texture' " +
						    " url='../images/BacillusAnthracis.jpg'/>";
					
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
					
					***/
	
					// Set up a Group that assembles the flagellum
					//body += "\n\n</Transform>\n\n";		
					//body += animate(bioGroup, baseTransform);
						
		    		// Increase the angle on the arc that goes from left to right
		    		angleLatitude += rotateLatitude;
		    		//System.out.println("Incremented Latitude Angle: " + angleLatitude);
				}
			
		
				// On Every Longitutde, we 
				// Connect the previous row with the current row
				// On the first instancr, there is nothing to connect to
				if (longitude < 1)
				{
					System.out.println("Not Connecting Longitude - only 1 row");
				}
				else 
				{
					// Connect up the last and current.
					String coordIndexStr = "";
					String topRowVertices = "";
					String bottomRowVertices = "";
					
					// Linearly store the Vertices
					// Load the coordinates/vertices for first row
					for (int latitude=0; latitude<numLatitude; latitude++)
					{
						/// build the top row
						if (latitude==0)
							topRowVertices = "\n" + currentPoints[latitude][0]  + ", " +  currentPoints[latitude][1] + ", " + currentPoints[latitude][2];
							//coordinateString = centerPointStr + ", \n" + cyPoints[k][0]  + ", " +  cyPoints[k][1] + ", " + cyPoints[k][2];
						else
							topRowVertices += ",\n  " + currentPoints[latitude][0]  + ",  " +  currentPoints[latitude][1] + ",  " + currentPoints[latitude][2];		
				
						// Buid the bottom row
						if (latitude==0)
							bottomRowVertices = "\n" + lastPoints[latitude][0]  + ", " +  lastPoints[latitude][1] + ", " + lastPoints[latitude][2];
							//coordinateString = centerPointStr + ", \n" + cyPoints[k][0]  + ", " +  cyPoints[k][1] + ", " + cyPoints[k][2];
						else
							bottomRowVertices += ",\n  " + lastPoints[latitude][0]  + ",  " +  lastPoints[latitude][1] + ",  " + lastPoints[latitude][2];		
					
					}
					
					
					coordIndexStr = topRowVertices + "," + bottomRowVertices;
					//System.out.println("NUM COORDS: " + currentPoints.length  + "    "  + currentPoints.length );
					//System.out.println("COORDS are: " + coordIndexStr);
					
					
	
					// Now connect the points together
					String tempIndexStr = "";
					for (int latitude=0; latitude<numLatitude; latitude++)
					{
						
						if (latitude==0)
						{	
							tempIndexStr = " " +  
									(latitude+1)     			+ "  " +
									 latitude 			+ "  " +
									(latitude+numLatitude) 	+ "  " +
									(latitude+numLatitude+1) + "  -1";
						}	
						else if (latitude==(numLatitude-1))
						{	
							tempIndexStr += ", " +  
									0    			+ "  " +
									(numLatitude-1) + "  " +
									(2*numLatitude-1) 	+ "  " +
									numLatitude + "  -1";
						}
						else
						{	
							tempIndexStr += ", " +  
									(latitude+1) 		+ "  " +
									 latitude 			+ "  " +
									(latitude+numLatitude) + "  " +
										(latitude+numLatitude+1) + "  -1";
						}
					}
					
					
					System.out.println("********* Index is: " + tempIndexStr);	
					
					
					String componentType = "AdenovirusCap";
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
					    	    "containerField='coord' point='" + coordIndexStr + "'/>" +
					    	  "</IndexedFaceSet>\n" +
					    
					    	 "</Shape>\n" +
					    	 
					    	 "<TouchSensor DEF='StartEndothelium' \n" +
			                   " description='" + componentType + "'\n" +
				               " containerField='children'/> \n" +
					    	 
					"</Transform>\n"; 
				}
				
				
				// Store all the latitude points for future use
				for (int latitude=0; latitude<numLatitude; latitude++)
				{
					lastPoints[latitude][0] = currentPoints[latitude][0];
					lastPoints[latitude][1] = currentPoints[latitude][1];
					lastPoints[latitude][2] = currentPoints[latitude][2];
			
				}
		
							
				// Increase the angle on the Arc that goes top to bottom
				angleLongitude += rotateLongitude;
				//System.out.println("Incremented Longtitude Angle: " + angleLatitude);
			}
	
		}
	
		return (body);		
	}
  
  	
  	
  	public static double[][] createCylinderInPlane(double[] orientation, double[] startPos, double radius, int numSides)  
	{
		
    	double[][] currentPoints = new double [numSides][3];	
        float angle = 360 / numSides;
      	double angleRadians = Math.toRadians(angle);
        //System.out.println("numPoints:  "  + numSides   + "  angleOfSep:  " +  angle + "  radians:  " + angleRadians + " radius: "  +  radius);
        
        
        for (int i = 0; i < numSides; i++) {
  
        	double sinRadians = MathUtils.round(Math.sin(i*angleRadians), 8);
        	double cosRadians = MathUtils.round(Math.cos(i*angleRadians), 8);
        	
        	//xPos = MathUtils.round((radius * (cosLat * sinLong)), 8);  
			//yPos = MathUtils.round((radius * cosLong), 8);
			//zPos = MathUtils.round((radius * (sinLat * sinLong)), 8);
        	
        	// Draw in the Y-Plane and then orient by rotation
        	currentPoints[i][0] = MathUtils.round(cosRadians * radius, 8);
            currentPoints[i][1] = 0;
            currentPoints[i][2] = MathUtils.round(sinRadians * radius, 8);
        }
        //BioGraphics.dumpPoints("CylinderPoints-----", currentPoints);
        
        // Rotate by Longitude
        //System.out.println("Logitude Rotation:  "  +  orientation[0]);
        currentPoints = BioGraphics.applyRotation(currentPoints, -1, orientation[0], new double[] {0, 0, 1});
        //BioGraphics.dumpPoints("CylinderPointsLong-----", currentPoints);
        
        // Rotate by Latitude
        currentPoints = BioGraphics.applyRotation(currentPoints, -1, orientation[1], new double[] {0, 1, 0});
        //BioGraphics.dumpPoints("CylinderPoints-----Lat", currentPoints);
        
        // Put it where it's wanted
		double originTranslateArray[] = {startPos[0], startPos[1], startPos[2]};     
 		double[][] resultPoints = BioGraphics.applyTranslation(currentPoints, originTranslateArray);
        
		return (resultPoints);
	}


	
	/***************************************************************************************
	 * GET CENTERPOINT DUBBLICATE
	 * 
	 * Gets the center point of the octagon so that we can translate it to zero prior
	 * to scaling.  
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/
	
	public static double[] getLineDivided(BioMightPosition startPoint,  BioMightPosition endPoint, double coK)
	{	
		double xCenter = 0.0;
    	double yCenter = 0.0;
    	double zCenter = 0.0;
		
    	
    	int numPoints = 2;	

       	// Get the Center of a Line segment 
    	if (numPoints == 2)
		{
			// Get the Midpoint between points 0 and 2
    		//xCenter = MathUtils.round( (points[0][0] + points[1][0])/2, 8);
    		//yCenter = MathUtils.round( (points[0][1] + points[1][1])/2, 8);
	    	//zCenter = MathUtils.round( (points[0][2] + points[1][2])/2, 8);
	    	
    		xCenter = MathUtils.round( startPoint.getXPos() + coK * (endPoint.getXPos() - startPoint.getXPos()), 8);
    		yCenter = MathUtils.round( startPoint.getYPos() + coK * (endPoint.getYPos() - startPoint.getYPos()), 8);
	    	zCenter = MathUtils.round( startPoint.getZPos() + coK * (endPoint.getZPos() - startPoint.getZPos()) , 8);
	    		
	    	// this will give me the 5th, wtf is this from googo on stack overflow???
	    	//xCenter = MathUtils.round( points[0][0]  +   (( (points[1][0] - points[0][0]) /  totalSegments) * segment), 8);
	    	//yCenter = MathUtils.round( points[0][1]  +   (( (points[1][1] - points[0][1]) /  totalSegments) * segment), 8);
	    	//zCenter = MathUtils.round( points[0][2]  +   (( (points[1][2] - points[0][2]) /  totalSegments) * segment), 8);
	    	
			System.out.println("Position X0: " 
					+ startPoint.getXPos() + "  "
					+ startPoint.getYPos() + "  "
					+ startPoint.getZPos());
			
			System.out.println("Position X1: " 
					+ endPoint.getXPos() + "  "
					+ endPoint.getYPos() + "  "
					+ endPoint.getZPos());
					
	    	
			System.out.println("CenterPoint is: " 
					+ xCenter + "  "
					+ yCenter + "  "
					+ zCenter);
			
  		}
		
		
		double[] centerPoint = {xCenter, yCenter, zCenter};
		return (centerPoint);
	}
	
	
}
