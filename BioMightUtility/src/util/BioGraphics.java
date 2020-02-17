package biomight.util;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

import org.apache.openejb.math.util.MathUtils;

import biomight.Constants;
import biomight.exceptions.DataException;
import biomight.exceptions.DataSecurityException;
import biomight.view.BioMightInstructSet;
import biomight.view.BioMightInstruction;
import biomight.view.BioMightOrientation;
import biomight.view.BioMightPosition;
import biomight.view.BioMightPositions;
import biomight.view.BioMightScale;
import biomight.view.BioMightTransform;


/********************************************************************************
 * BIO GRAPHICS
 * 
 * Routines for generating common Graphic objects and processes
 * 
 * @param point1
 * @param point2
 * @return
 ********************************************************************************/


public class BioGraphics {

		
	/***************************************************************
	 * Returns the distance between two points in 3D space
	 * 
	 * @param point1
	 * @param point2
	 * @return
	 ***************************************************************/

	public static double distance(BioMightPosition point1,  BioMightPosition point2){
		
		double distance = Math.sqrt( ((point2.getXPos() - point1.getXPos()) * (point2.getXPos() - point1.getXPos())) +
									 ((point2.getYPos() - point1.getYPos()) * (point2.getYPos() - point1.getYPos())) +
									 ((point2.getZPos() - point1.getZPos()) * (point2.getZPos() - point1.getZPos())) );
		return distance;
	}
	
	/**************************************************************************************
	 *  Determines the angle of a straight line drawn between point one and two. 
	 *  The number returned, which is a double in degrees, tells us how much we 
	 *  have to rotate a horizontal line clockwise for it to match the line 
	 *  between the two points. * If you prefer to deal with angles using 
	 *  radians instead of degrees, just change the last line to: 
	 *  "return Math.atan2(yDiff, xDiff);" 
	 **************************************************************************************/ 
	
	public static double getPointsAngle(BioMightPosition point1, BioMightPosition point2) 
	{ 
		double xDiff = point1.getXPos() - point2.getXPos(); 
		double yDiff = point1.getYPos() - point2.getYPos(); 
		
		//int angleInRadian = atan2((double)Y,(double)X); //angle in radian
		//int angleInDegree = angleInRadian * 180 / PI;
		
		return Math.toDegrees(Math.atan2(yDiff, xDiff));
		
	} 
	
	
	/*************************************************************************
	 *  GET SPHERE POSITION
	 *  
	 *  There are two methods for taking a dot product. 
	 *  
	 ************************************************************************/ 
	
	
	public static double[] getPosition(double radius, double angleLatitude, double angleLongitude) 
	{ 
		
		double[] nextPoint = {0.0, 0.0, 0.0};

		
		// Get a Random # in the range
		double xDisplacement = 0.0; // (Math.random() * 10)/2;
		double yDisplacement = 0.0; // (Math.random() * 10)/2;
		double zDisplacement = 0.0; //  (Math.random() * 10)/2;
		
		double radiansLatitude =  Math.toRadians(angleLatitude+xDisplacement);
		double radiansLongitude =  Math.toRadians(angleLongitude+zDisplacement);
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
		
		double xOrient =  MathUtils.round(Math.cos(perpindickRadians), 8);
		double yOrient =  0;  
		double zOrient =  MathUtils.round(Math.sin(perpindickRadians), 8); ;// MathUtils.round(Math.sin(perpindick) * -1, 8);  //MathUtils.round(1 * Math.cos(angleLongitude), 8); 
		
		//System.out.println("X-AXIS: " + xOrient);
		//System.out.println("Y-AXIS: " + yOrient);
		//System.out.println("Z-AXIS: " + zOrient);

	
		return(nextPoint);
	}
	
	
	/*************************************************************************
	 *  DOT PRODUCT
	 *  
	 *  There are two methods for taking a dot product. 
	 *  
	 ************************************************************************/ 
	
	
	public static double dotProduct(BioVector vectorA, BioVector vectorB) 
	{ 
	
		double sum = 0.0;  
		sum += vectorA.getxStartPos() *  vectorB.getxStartPos() +
			   vectorA.getyStartPos() *  vectorB.getyStartPos()  + 
			   vectorA.getzStartPos() *  vectorB.getzStartPos();   
		return(sum);
	}
	

	/*************************************************************************
	 *  CROSS PRODUCT
	 *  
	 *  There are two methods for taking a cross product.   
	 *  
	 ************************************************************************/ 
	
	
	public static BioVector crossProduct(BioVector vectorA, BioVector vectorB) 
	{  
		double i =  MathUtils.round(vectorA.getyEndPos() *  vectorB.getzEndPos() - vectorA.getzEndPos() *  vectorB.getyEndPos(), 8);
		//System.out.println("Cross Product X: " + vectorA.getyEndPos() + " * " +  vectorB.getzEndPos() 
		//		                          + " - " + vectorA.getzEndPos() + " * " +  vectorB.getyEndPos());
				
		
		double j =	MathUtils.round(vectorA.getzEndPos() *  vectorB.getxEndPos() - vectorA.getxEndPos() *  vectorB.getzEndPos(), 8);

		//System.out.println("Cross Product Y: " + vectorA.getzEndPos() + " * " +  vectorB.getxEndPos() 
        //       + " - " + vectorA.getxEndPos() + " * " +  vectorB.getzEndPos());
		
		double k =	MathUtils.round(vectorA.getxEndPos() *  vectorB.getyEndPos() - vectorA.getyEndPos() *  vectorB.getxEndPos(), 8);
		
		//System.out.println("Cross Product Z: " + vectorA.getxEndPos() + " * " +  vectorB.getyEndPos() 
        //        + " - " + vectorA.getyEndPos() + " * " +  vectorB.getxEndPos());
		
		//System.out.println("Cross Product: " + i + "  " + j + "  " + k);
		
		BioVector bioVector = new BioVector(0,0,0, i,j,k); 
		return(bioVector);
	}
	


	/*************************************************************************
	 *  GET POSITION KEY VALUES
	 *  
	 *  Get Position Key Values   
	 *  
	 ************************************************************************/ 
	
	public static String  getPositionKeyVals(int cadence, BioMightPosition startPos, BioMightPosition endPos, int numPoints) 
	{ 
		// Allocate the array of points that will be returned
		String vectorPoints[]= new  String[numPoints];
		String keyValues = "";	

		// Get the Difference or Slope
		double diffX = endPos.getXPos() - startPos.getXPos();
		double diffY = endPos.getYPos() - startPos.getYPos();
		double diffZ = endPos.getZPos() - startPos.getZPos();
		//System.out.println("Diffs-----        x: " + diffX +  "    y: "  +  diffY + "     z: " + diffZ);
		
		//  Start at Begin Position & 
		//  End at Destination Position 
		// Generate numPoint increments.	
		BigDecimal xIncrement = new BigDecimal(diffX/numPoints);
		BigDecimal yIncrement = new BigDecimal(diffY/numPoints);
		BigDecimal zIncrement = new BigDecimal(diffZ/numPoints);
		//System.out.println("Increment----   x: " + xIncrement +  "    y: "  +  yIncrement + "     z: " + zIncrement);
		
		
		// Start at Start Position
		BigDecimal xCurrent = new BigDecimal(startPos.getXPos()).setScale(6, BigDecimal.ROUND_CEILING);
		BigDecimal yCurrent = new BigDecimal(startPos.getYPos()).setScale(6, BigDecimal.ROUND_CEILING);
		BigDecimal zCurrent = new BigDecimal(startPos.getZPos()).setScale(6, BigDecimal.ROUND_CEILING);

		// Form the Interpolator String based on the points
		for (int i=0; i<numPoints; i++)
		{
			vectorPoints[i] = xCurrent + " " +  yCurrent + " " + zCurrent + " ";
			//System.out.println("VectorPoinsts " + xCurrent +  " "  +  yCurrent + "  " + zCurrent);
			
			if (i==0) {
				keyValues = "keyValue='"+ xCurrent +  " "  +  yCurrent + " " + zCurrent;
			}
			else {
				keyValues += "  " + xCurrent +  " "  +  yCurrent + " " + zCurrent + " ";
			}
		
			// Increment x, y,and Z
			xCurrent = xCurrent.add(xIncrement).setScale(6,  BigDecimal.ROUND_CEILING);
			yCurrent = yCurrent.add(yIncrement).setScale(6,  BigDecimal.ROUND_CEILING);
			zCurrent = zCurrent.add(zIncrement).setScale(6,  BigDecimal.ROUND_CEILING);
		}
		// Add the last quote
		keyValues += "'\n";
			
		
		return(keyValues);
	}


	/*************************************************************************
	 *  GET SCALAR KEY VALUES
	 *  
	 *  Get Position Key Values   
	 *  
	 ************************************************************************/ 
	
	public static String  getScalarKeyVals(int cadence, BioMightScale startScale, BioMightScale endScale, int numPoints) 
	{ 
		// Allocate the array of points that will be returned
		String vectorPoints[]= new  String[numPoints];
		String keyValues = "";	

		// Get the Difference or Slope
		double diffX = endScale.getXScale() - startScale.getXScale();
		double diffY = endScale.getYScale() - startScale.getYScale();
		double diffZ = endScale.getZScale() - startScale.getZScale();
		//System.out.println("DiffScale-----        x: " + diffX +  "    y: "  +  diffY + "     z: " + diffZ);
		
		//  Start at Begin Position & 
		//  End at Destination Position 
		// Generate numPoint increments.	
		BigDecimal xIncrement = new BigDecimal(diffX/numPoints);
		BigDecimal yIncrement = new BigDecimal(diffY/numPoints);
		BigDecimal zIncrement = new BigDecimal(diffZ/numPoints);
		//System.out.println("Increment----   x: " + xIncrement +  "    y: "  +  yIncrement + "     z: " + zIncrement);
		
		
		// Start at Start Position
		BigDecimal xCurrent = new BigDecimal(startScale.getXScale()).setScale(6, BigDecimal.ROUND_CEILING);
		BigDecimal yCurrent = new BigDecimal(startScale.getYScale()).setScale(6, BigDecimal.ROUND_CEILING);
		BigDecimal zCurrent = new BigDecimal(startScale.getZScale()).setScale(6, BigDecimal.ROUND_CEILING);

		// Form the Interpolator String based on the points
		for (int i=0; i<numPoints; i++)
		{
			vectorPoints[i] = xCurrent + " " +  yCurrent + " " + zCurrent + " ";
			//System.out.println("VectorPoinsts " + xCurrent +  " "  +  yCurrent + "  " + zCurrent);
			
			if (i==0) {
				keyValues = "keyValue='"+ xCurrent +  " "  +  yCurrent + " " + zCurrent;
			}
			else {
				keyValues += "  " + xCurrent +  " "  +  yCurrent + " " + zCurrent + " ";
			}
		
			// Increment x, y,and Z
			xCurrent = xCurrent.add(xIncrement).setScale(6,  BigDecimal.ROUND_CEILING);
			yCurrent = yCurrent.add(yIncrement).setScale(6,  BigDecimal.ROUND_CEILING);
			zCurrent = zCurrent.add(zIncrement).setScale(6,  BigDecimal.ROUND_CEILING);
		}
		// Add the last quote
		keyValues += "'\n";
			
		
		return(keyValues);
	}
	
	/*************************************************************************
	 *  GET ROTATION KEY VALS
	 *  
	 *  Given a startpoint and endpoint, determine num points on the line that
	 *  are equidistant from one another   
	 *  
	 ************************************************************************/ 
	
	public static String  getRotationKeyVals(int cadence, BioMightOrientation startOrientation, BioMightOrientation endOrientation, int numPoints) 
	{ 
		// Allocate the array of points that will be returned
		String vectorPoints[]= new  String[numPoints];
		String keyValues = "";
		
		// Based on the start and end point we will need to make point to point Euler jumps 
		// We need to perform Eueler rotations to get the object where it needs to be.
		// For now we should assume one axis of rotation and at a given angle
		//double diffOrientationX = endOrientation.getDegrees() -  startOrientation.getDegrees();
		//double diffOrientationY = endOrientation.getDegrees() -  startOrientation.getDegrees();
		//double diffOrientationZ = endOrientation.getDegrees() -  startOrientation.getDegrees();
		//double diffOrientationW = endOrientation.getDegrees() -  startOrientation.getDegrees();
		double diffOrientationW = Math.toRadians(endOrientation.getDegrees()) -  Math.toRadians(startOrientation.getDegrees());
		//System.out.println("Rotate By: " + diffOrientationW);
			
		if (startOrientation.getXAxis() == 1.0)
		{
			// We are doing a rotation around the X-axis
			//System.out.println("Rotate around X");
		}
		else if (startOrientation.getYAxis() == 1.0)	
		{	
			// We are doing a rotation around the Y-axis
			//System.out.println("Rotate around Y");
		}
		else if (startOrientation.getZAxis() == 1.0)	
		{	
			// We are doing a rotation around the Z-axis
			//System.out.println("Rotate around Z");
		}		
			
		//  Start at Begin Position & 
		//  End at Destination Position 
		// Generate numPoint increments.	
		BigDecimal xIncrement = new BigDecimal(0);
		BigDecimal yIncrement = new BigDecimal(0);
		BigDecimal zIncrement = new BigDecimal(0);
		BigDecimal wIncrement = new BigDecimal(diffOrientationW/numPoints);
		//System.out.println("Increment----   x: " + xIncrement +  "    y: "  +  yIncrement + "     z: " + zIncrement + "    w: " + wIncrement);
		
		
		// Start at Start Orientation
		BigDecimal xCurrent = new BigDecimal(startOrientation.getXAxis()).setScale(6, BigDecimal.ROUND_CEILING);
		BigDecimal yCurrent = new BigDecimal(startOrientation.getYAxis()).setScale(6, BigDecimal.ROUND_CEILING);
		BigDecimal zCurrent = new BigDecimal(startOrientation.getZAxis()).setScale(6, BigDecimal.ROUND_CEILING);
		BigDecimal wCurrent = new BigDecimal(startOrientation.getDegrees()).setScale(6, BigDecimal.ROUND_CEILING);
		
		// Form the Interpolator String based on the points
		for (int i=0; i<numPoints; i++)
		{
			vectorPoints[i] = xCurrent + " " +  yCurrent + " " + zCurrent + " "+  wCurrent + " ";
			//System.out.println("RotatePoints " + xCurrent +  " "  +  yCurrent + "  " + zCurrent+ "  " + wCurrent);
			
			if (i==0) {
				keyValues = "keyValue='"+ xCurrent +  " "  +  yCurrent + " " + zCurrent+ " " + wCurrent;
			}
			else {
				keyValues += "  " + xCurrent +  " "  +  yCurrent + " " + zCurrent + " " + wCurrent + " ";
			}
		
			// Increment x, y,and Z
			xCurrent = xCurrent.add(xIncrement).setScale(6,  BigDecimal.ROUND_CEILING);
			yCurrent = yCurrent.add(yIncrement).setScale(6,  BigDecimal.ROUND_CEILING);
			zCurrent = zCurrent.add(zIncrement).setScale(6,  BigDecimal.ROUND_CEILING);
			wCurrent = wCurrent.add(wIncrement).setScale(6,  BigDecimal.ROUND_CEILING);
		}
		// Add the last quote
		keyValues += "'\n";
			
		
		return(keyValues);
	}
	
	
	/*************************************************************************
	 *  GET VECTOR KEYS
	 *  
	 *  Given a startpoint and endpoint, determine num points on the line that
	 *  are equidistant from one another   
	 *  
	 ************************************************************************/ 
	
	
	public static String  getVectorKeys(int cadence, int numPoints) 
	{
		String keys="";
		
		
		if (cadence == Constants.SLOW) {
			String key[] = {"0.00", "0.10", "0.20", "0.30", "0.40", "0.50", "0.60", "0.70", "0.80", "0.90", "1.00"};
			
			keys = 
			"key='" + key[0] +" "+ key[1] +" "+ key[2] +" "+ key[3] +" "+ key[4] +" "+ 
			          key[5] +" "+ key[6] +" "+ key[7] +" "+ key[8] +" "+ key[9] + "'\n";
	
		}
		else if (cadence == Constants.MEDIUM)
		{			
			String key[] = {"0.00", "0.20", "0.40", "0.60", "0.80"};
	
			keys +=
			"key='" + key[0] + " " + key[1] + " " + key[2] + " " + key[3] + " " + key[4] + "'\n";	
		}
		else if (cadence == Constants.SLOW)
		{
		
			String key[] = {"0.00", "0.50"};
			
			keys +=
				"key='" + key[0] + " " + key[1] + "'\n";	
		}
		
		return(keys);
	}
	

	public static double[][] octogonYPlane(double[] startPos, double circumference)  
	{
		
		// Create a equilateral octogon in the Y-plane
    	double x =  startPos[0];
    	double y =  startPos[1];
    	double z =  startPos[2];
   
		double [][] currentPoints = { 
    			{x, y, z},
    	 		{x-circumference,     y, z-circumference},
    	   		{x-circumference,     y, z-circumference*2},
    	   		{x,                   y, z-circumference*3},
    	   		{x+circumference,     y, z-circumference*3},
    	   		{x+(circumference*2), y, z-circumference*2},
    	   		{x+(circumference*2),     y, z-circumference},
    	  		{x+circumference, y, z}
    	   		};
		
		
		return (currentPoints);
	}

	
	public static double[][] createCylinderInPlane(int plane, double[] startPos, double radius, int numSides)  
	{
		
    	double[][] currentPoints = new double [numSides][3];	
        float angle = 360 / numSides;
      	double angleRadians = Math.toRadians(angle);
        //System.out.println("currentPoints:  "  + numSides   + "  angle:  " +  angle + "  radians:  " + angleRadians + " radius: "  +  radius);
        
        
        for (int i = 0; i < numSides; i++) {
  
        	double sinRadians = MathUtils.round(Math.sin(i*angleRadians), 8);
        	double cosRadians = MathUtils.round(Math.cos(i*angleRadians), 8);
        	
        	//xPos = MathUtils.round((radius * (cosLat * sinLong)), 8);  
			//yPos = MathUtils.round((radius * cosLong), 8);
			//zPos = MathUtils.round((radius * (sinLat * sinLong)), 8);
        	
           	if (plane == Constants.XPLANE){
        		currentPoints[i][0] = 0;
            	currentPoints[i][1] = MathUtils.round(sinRadians * radius, 8);
            	currentPoints[i][2] = MathUtils.round(cosRadians * radius, 8);
          	}
        	else if (plane == Constants.YPLANE) {
        		currentPoints[i][0] = MathUtils.round(cosRadians * radius, 8);
            	currentPoints[i][1] = 0;
            	currentPoints[i][2] = MathUtils.round(sinRadians * radius, 8);
        	}     	
			else if (plane == Constants.ZPLANE) {
				currentPoints[i][0] = MathUtils.round(cosRadians * radius, 8);
				currentPoints[i][1] = MathUtils.round(sinRadians * radius, 8);
				currentPoints[i][2] = 0;
    		}
            
        }
        
        // Put it where it's wanted
		double originTranslateArray[] = {startPos[0], startPos[1], startPos[2]};     
 		double[][] resultPoints = applyTranslation(currentPoints, originTranslateArray);
        
		return (resultPoints);
	}


	/******************************************************************************************
	 * 
	 * CREATE RECTANGLE
	 * 
	 * @param orientation
	 * @param startPos
	 * @param length
	 * @param height
	 * @return
	 ******************************************************************************************/
	public static double[][] createRectangle(double[] orientation, double[] startPos, double length, double height)  
	{
    	double[][] currentPoints = new double [4][3];	
       
     	// Set up the 4 points
    	
    	// Top Right Corner
        currentPoints[0][0] = startPos[0] + (length * 0.5) ;
        currentPoints[0][1] = startPos[1] + (height * 0.5);
        currentPoints[0][2] = startPos[2];
   
        // Top left corner
        currentPoints[1][0] = startPos[0] - (length * 0.5);
        currentPoints[1][1] = startPos[1] + (height * 0.5);
        currentPoints[1][2] = startPos[2];
        
        // Bottom Right Corner
        currentPoints[2][0] = startPos[0] + (length * 0.5);;
        currentPoints[2][1] = startPos[1] - (height * 0.5);
        currentPoints[2][2] = startPos[2];
        
        // Bottom Left Corner
        currentPoints[3][0] = startPos[0] - (length * 0.5);;
        currentPoints[3][1] = startPos[1] - (height * 0.5);
        currentPoints[3][2] = startPos[2];
       
        // Put it where it's wanted based upon the startpoint
		//double originTranslateArray[] = {startPos[0], startPos[1], startPos[2]};     
 		//double[][] resultPoints = applyTranslation(currentPoints, originTranslateArray);
        
		return (currentPoints);
	}


	public static double[][] createCylinderInPlane(double[] orientation, double[] startPos, double radius, int numSides)  
	{
		
    	double[][] currentPoints = new double [numSides][3];	
        float angle = 360 / numSides;
      	double angleRadians = Math.toRadians(angle);
        //System.out.println("currentPoints:  "  + numSides   + "  angle:  " +  angle + "  radians:  " + angleRadians + " radius: "  +  radius);
       
        
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
        
        // Rotate by X
        //currentPoints = BioGraphics.applyRotation(currentPoints, 0, orientation[0], new double[] {1, 0, 0});
        if (orientation[0] > 0.0)
        	currentPoints = BioGraphics.rotateX(currentPoints, orientation[0]);
        
        // Rotate by Y
        //currentPoints = BioGraphics.applyRotation(currentPoints, 0, orientation[1], new double[] {0, 1, 0});
        if (orientation[1] > 0.0)
        	currentPoints = BioGraphics.rotateY(currentPoints, orientation[1]); 
        
        // Rotate by Z
        //currentPoints = BioGraphics.applyRotation(currentPoints, 0, orientation[2], new double[] {0, 0, 1});
        if (orientation[2] > 0.0)
        	currentPoints = BioGraphics.rotateZ(currentPoints, orientation[2]);
           
        // Put it where it's wanted based upon the startpoint
		double originTranslateArray[] = {startPos[0], startPos[1], startPos[2]};     
 		double[][] resultPoints = applyTranslation(currentPoints, originTranslateArray);
        
		return (resultPoints);
	}

	
	public static double[][] createCylinderInPlane(int plane, double[] startPos, double radius, int numSides, double displace)  
	{
		
    	double[][] currentPoints = new double [numSides][3];	
        float angle = 360 / numSides;
      	double angleRadians = Math.toRadians(angle);
        //System.out.println("currentPoints:  "  + numSides   + "  angle:  " +  angle + "  radians:  " + angleRadians + " radius: "  +  radius);
        
        
        for (int i = 0; i < numSides; i++) {
  
        	double sinRadians = MathUtils.round(Math.sin(i*angleRadians+displace), 8);
        	double cosRadians = MathUtils.round(Math.cos(i*angleRadians+displace), 8);
        	
        	//xPos = MathUtils.round((radius * (cosLat * sinLong)), 8);  
			//yPos = MathUtils.round((radius * cosLong), 8);
			//zPos = MathUtils.round((radius * (sinLat * sinLong)), 8);
        	
           	if (plane == Constants.XPLANE){
        		currentPoints[i][0] = 0;
            	currentPoints[i][1] = MathUtils.round(sinRadians * radius, 8);
            	currentPoints[i][2] = MathUtils.round(cosRadians * radius, 8);
          	}
        	else if (plane == Constants.YPLANE) {
        		currentPoints[i][0] = MathUtils.round(cosRadians * radius, 8);
            	currentPoints[i][1] = 0;
            	currentPoints[i][2] = MathUtils.round(sinRadians * radius, 8);
        	}     	
			else if (plane == Constants.ZPLANE) {
				currentPoints[i][0] = MathUtils.round(cosRadians * radius, 8);
				currentPoints[i][1] = MathUtils.round(sinRadians * radius, 8);
				currentPoints[i][2] = 0;
    		}
            
        }
        
        // Put it where it's wanted
		double originTranslateArray[] = {startPos[0], startPos[1], startPos[2]};     
 		double[][] resultPoints = applyTranslation(currentPoints, originTranslateArray);
        
		return (resultPoints);
	}

	
	public static double[][] createCylinderInPlane(int plane, double[] startPos, double radius, double[] displaceAngle)  
	{
		
		int numSides = displaceAngle.length;
    	double[][] currentPoints = new double [numSides][3];	

        //System.out.println("CreateCylnder:  "  + numSides  + " radius: "  +  radius);
        for (int i = 0; i < numSides; i++) {
  
          	double angleRadians = Math.toRadians(displaceAngle[i]);
          	//System.out.println("Placing CylinderPoint at Angle:  " + displaceAngle[i]);
          	
        	double sinRadians = MathUtils.round(Math.sin(angleRadians), 8);
        	double cosRadians = MathUtils.round(Math.cos(angleRadians), 8);
        	
        	//xPos = MathUtils.round((radius * (cosLat * sinLong)), 8);  
			//yPos = MathUtils.round((radius * cosLong), 8);
			//zPos = MathUtils.round((radius * (sinLat * sinLong)), 8);
        	
           	if (plane == Constants.XPLANE){
        		currentPoints[i][0] = 0;
            	currentPoints[i][1] = MathUtils.round(sinRadians * radius, 8);
            	currentPoints[i][2] = MathUtils.round(cosRadians * radius, 8);
          	}
        	else if (plane == Constants.YPLANE) {
        		currentPoints[i][0] = MathUtils.round(cosRadians * radius, 8);
            	currentPoints[i][1] = 0;
            	currentPoints[i][2] = MathUtils.round(sinRadians * radius, 8);
        	}     	
			else if (plane == Constants.ZPLANE) {
				currentPoints[i][0] = MathUtils.round(cosRadians * radius, 8);
				currentPoints[i][1] = MathUtils.round(sinRadians * radius, 8);
				currentPoints[i][2] = 0;
    		}
            
        }
        
        // Put it where it's wanted
		double originTranslateArray[] = {startPos[0], startPos[1], startPos[2]};     
 		double[][] resultPoints = applyTranslation(currentPoints, originTranslateArray);
        
		return (resultPoints);
	}
	
	public static double[][] createCylinderInPlaneScaled(int plane, double[] startPos, double radius, double[] tubeScale, int numSides)  
	{
		
    	double[][] currentPoints = new double [numSides][3];	
        float angle = 360 / numSides;
      	double angleRadians = Math.toRadians(angle);
        //System.out.println("CylinderCreate - currentPoints:  "  + numSides   + "  angle:  " +  angle + "  radians:  " + angleRadians + " radius: "  +  radius);
        
        
        for (int i = 0; i < numSides; i++) {
  
        	double sinRadians = MathUtils.round(Math.sin(i*angleRadians), 8);
        	double cosRadians = MathUtils.round(Math.cos(i*angleRadians), 8);
        	
        	//xPos = MathUtils.round((radius * (cosLat * sinLong)), 8);  
			//yPos = MathUtils.round((radius * cosLong), 8);
			//zPos = MathUtils.round((radius * (sinLat * sinLong)), 8);
        	
           	if (plane == Constants.XPLANE){
        		currentPoints[i][0] = 0;
            	currentPoints[i][1] = MathUtils.round(sinRadians * radius, 8);
            	currentPoints[i][2] = MathUtils.round(cosRadians * radius, 8);
          	}
        	else if (plane == Constants.YPLANE) {
        		currentPoints[i][0] = MathUtils.round(cosRadians * radius, 8);
            	currentPoints[i][1] = 0;
            	currentPoints[i][2] = MathUtils.round(sinRadians * radius, 8);
        	}     	
			else if (plane == Constants.ZPLANE) {
				currentPoints[i][0] = MathUtils.round(cosRadians * radius, 8);
				currentPoints[i][1] = MathUtils.round(sinRadians * radius, 8);
				currentPoints[i][2] = 0;
    		}
            
        }
        
  		//dumpPoints("Cylinder OriginPoints", currentPoints); 
        
        double[] translate = {0, 0, 0};
       	double[] scale = {tubeScale[0], tubeScale[1], tubeScale[2]};
    	double[][] scaledPoints = applyScale(currentPoints, translate, scale);
  		//dumpPoints("Cylinder ScaledPoints", scaledPoints); 
  		
        // Put it where it's wanted
		double originTranslateArray[] = {startPos[0], startPos[1], startPos[2]};     
 		double[][] resultPoints = applyTranslation(scaledPoints, originTranslateArray);
  		//dumpPoints("Cylinder ResultPoints", resultPoints); 
  		
		return (resultPoints);
	}
	
 
	public static double[][] createHalfPipeInPlane(int plane, double[] startPos, double radius, int numSides)  
	{
		
    	double[][] currentPoints = new double [numSides][3];	
        float angle = 180 / numSides;
      	double angleRadians = Math.toRadians(angle);
        System.out.println("currentPoints:  "  + numSides   + "  angle:  " +  angle + "  radians:  " + angleRadians + " radius: "  +  radius);
        
        
        for (int i = 0; i < numSides; i++) {
  
        	double sinRadians = MathUtils.round(Math.sin(i*angleRadians), 8);
        	double cosRadians = MathUtils.round(Math.cos(i*angleRadians), 8);
        	
        	//xPos = MathUtils.round((radius * (cosLat * sinLong)), 8);  
			//yPos = MathUtils.round((radius * cosLong), 8);
			//zPos = MathUtils.round((radius * (sinLat * sinLong)), 8);
        	
           	if (plane == Constants.XPLANE){
        		currentPoints[i][0] = 0;
            	currentPoints[i][1] = MathUtils.round(sinRadians * radius, 8);
            	currentPoints[i][2] = MathUtils.round(cosRadians * radius, 8);
          	}
        	else if (plane == Constants.YPLANE) {
        		currentPoints[i][0] = MathUtils.round(cosRadians * radius, 8);
            	currentPoints[i][1] = 0;
            	currentPoints[i][2] = MathUtils.round(sinRadians * radius, 8);
        	}     	
			else if (plane == Constants.ZPLANE) {
				currentPoints[i][0] = MathUtils.round(cosRadians * radius, 8);
				currentPoints[i][1] = MathUtils.round(sinRadians * radius, 8);
				currentPoints[i][2] = 0;
    		}
            
        }
        
        // Put it where it's wanted
		double originTranslateArray[] = {startPos[0], startPos[1], startPos[2]};     
 		double[][] resultPoints = applyTranslation(currentPoints, originTranslateArray);
        
		return (resultPoints);
	}
	

	/************************************************************************************
	 * 
	 * 
	 ***********************************************************************************/
	
	public static double[][] octogonYPlaneSlanted(double[] startPos, double circumference)  
	{
		
		// Create a equilateral octogon in the Y-plane
    	double x =  startPos[0];
    	double y =  startPos[1];
    	double z =  startPos[2];
   
		double [][] currentPoints = { 
    			{x, y, z},
    	 		{x-circumference,     y, z-circumference},
    	   		{x-circumference,     y, z-circumference*2},
    	   		{x,                   y, z-circumference*3},
    	   		{x+circumference,     y, z-circumference*3},
    	   		{x+(circumference*2), y, z-circumference*2},
    	   		{x+(circumference*2),     y, z-circumference},
    	  		{x+circumference, y, z}
    	   		};
		
		
		return (currentPoints);
	}
	
	
	
	

	public static double[][] octogonSlantedYPlane(double[] startPos, double circumference)  
	{
		
		// Create a equilateral octogon in the Y-plane
    	double x =  startPos[0];
    	double y =  startPos[1];
    	double z =  startPos[2];
   	
    	//double circumference = 1.8;
		double circLen = 2.2;
	
    	// In this model, the base of the neck drops 1-inch from back to front
    	double ySlant = 1.0;
    	// Each set of points will rise a 1/3 of the way
    	double yInc = ySlant/3;
    	
    	// Set the start in the front of the neck
    	double ySlantStart = y - ySlant;
  
      	// the first set of points will rise a 1/3 of the way
    	double slantMid1 = ySlantStart + yInc;
    	// the second set of points will rise 2/3 of the way
    	double slantMid2  = ySlantStart + (yInc*2); 
  
    	
    	double [][] currentPoints = { 
    			{x, y, z},
    	 		{x-circumference,     y, z-circumference},
    	   		{x-circumference,     y, z-circumference*2},
    	   		{x,                   y, z-circumference*3},
    	   		{x+circumference,     y, z-circumference*3},
    	   		{x+(circumference*2), y, z-circumference*2},
    	   		{x+(circumference*2),     y, z-circumference},
    	  		{x+circumference, y, z}
    	   		};
	

		// Create a equilateral octogon	
		currentPoints[0][0] =  x;
		currentPoints[0][1] =  ySlantStart;
		currentPoints[0][2] =  z;
		
		currentPoints[1][0] =  x-circumference;
		currentPoints[1][1] =  slantMid1;
		currentPoints[1][2] =  z-circLen;
		
		currentPoints[2][0] =  x-circumference;
		currentPoints[2][1] =  slantMid2;
		currentPoints[2][2] =  z-circLen*2;
		
		currentPoints[3][0] =  x;
		currentPoints[3][1] =  y;
		currentPoints[3][2] =  z-circLen*3;

		
		currentPoints[4][0] =  x+circumference;
		currentPoints[4][1] =  y;
		currentPoints[4][2] =  z-circLen*3;
		
		currentPoints[5][0] =  x+circumference*2;
		currentPoints[5][1] =  slantMid2;
		currentPoints[5][2] =  z-circLen*2;

		currentPoints[6][0] =  x+circumference*2;
		currentPoints[6][1] =  slantMid1;
		currentPoints[6][2] =  z-circLen;

		currentPoints[7][0] =  x+circumference;
		currentPoints[7][1] =  ySlantStart;
		currentPoints[7][2] =  z;

		
		
		return (currentPoints);
	}

	
	
	public static double[][] octogonXPlane(double[] startPos, double circumference)  
	{
		
		// Create a equilateral octogon in the y-plane
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
		
		return (currentPoints);
	}

	public static double[][] octogonXPlaneZ2(double[] startPos, double circumference)  
	{
		
		// Create a equilateral octogon in the y-plane
    	double x =  startPos[0];
    	double y =  startPos[1];
    	double z =  startPos[2];
   
    	
		double[][] currentPoints = { 
				 {x, y, z},
 				 {x, y-circumference,     z-circumference/2},
 				 {x, y-(circumference*2), z-circumference/2},
 				 {x, y-(circumference*3), z},
 				 {x, y-(circumference*3), z+(circumference/2)},
 				 {x, y-(circumference*2), z+(circumference)},
 				 {x, y-circumference,     z+(circumference)},
 				 {x, y, z+circumference/2}
  		};
		
		return (currentPoints);
	}

	public static double[][] octogonXPlaneZ4(double[] startPos, double circumference)  
	{	
		// Create a equilateral octogon in the y-plane
    	double x =  startPos[0];
    	double y =  startPos[1];
    	double z =  startPos[2];
   
		double[][] currentPoints = { 
				 {x, y, z},
 				 {x, y-circumference,     z-circumference/4},
 				 {x, y-(circumference*2), z-circumference/4},
 				 {x, y-(circumference*3), z},
 				 {x, y-(circumference*3), z+(circumference/4)},
 				 {x, y-(circumference*2), z+(circumference/2)},
 				 {x, y-circumference,     z+(circumference/2)},
 				 {x, y, z+circumference/4}
  		};
		
		return (currentPoints);
	}
	
	// Will be a flattened octogon
	public static double[][] octogonXPlaneX2(double[] startPos, double circumference)  
	{
		
		// Create a equilateral octogon in the y-plane
    	double x =  startPos[0];
    	double y =  startPos[1];
    	double z =  startPos[2];
   
    	
		double[][] currentPoints = { 
				 {x, y, z},
 				 {x, y-(circumference/2),   	z-circumference},
 				 {x, y-(circumference), 		z-circumference},
 				 {x, y-(circumference*1.5), 	z},
 				 {x, y-(circumference*1.5), 	z+(circumference)},
 				 {x, y-(circumference), 		z+(circumference*2)},
 				 {x, y-(circumference/2),   	z+(circumference*2)},
 				 {x, y, z+circumference}
  		};
		
		return (currentPoints);
	}
	
	
	public static double[][] octogonZPlane(double[] startPos, double segmentLength)  
	{
		// Create a equilateral octogon in the y-plane
    	double x =  startPos[0];
    	double y =  startPos[1];
    	double z =  startPos[2];
   
		double [][] currentPoints = { 
    			{x, y, z},
    	 		{x+segmentLength,     y,                   z},
    	   		{x+(segmentLength*2), y+(segmentLength),   z},
    	   		{x+(segmentLength*2), y+(segmentLength*2), z},
    	   		{x+segmentLength,     y+(segmentLength*3), z},
    	   		{x,                   y+(segmentLength*3), z},
    	   		{x-segmentLength,     y+(segmentLength*2), z},
    	  		{x-segmentLength,     y+(segmentLength),   z}
    	   		};
		
		
		return (currentPoints);
	}


	
	public static double[][] octogonSlantedPlane(double[] startPos, double circumference)  
	{
		
		// Create a equilateral octogon in the Y-plane
    	double x =  startPos[0];
    	double y =  startPos[1];
    	double z =  startPos[2];
   
		double [][] currentPoints = { 
    			{x, y, z},
    	 		{x-circumference,     y, z-circumference},
    	   		{x-circumference,     y, z-circumference*2},
    	   		{x,                   y, z-circumference*3},
    	   		{x+circumference,     y, z-circumference*3},
    	   		{x+(circumference*2), y, z-circumference*2},
    	   		{x+(circumference*2),     y, z-circumference},
    	  		{x+circumference, y, z}
    	   		};
		
		
		return (currentPoints);
	}
	
	/***************************************************************************************
	 * CREATE X HALF PIPE
	 * 
	 * Create a Half Pipe
	 * 
	 ***************************************************************************************/
	public static double[][] createXHalfPipe(double[] startPos, double circumference)  
	{
		// Create a equilateral octogon in the y-plane
    	double x =  startPos[0];
    	double y =  startPos[1];
    	double z =  startPos[2];
   
		double[][] currentPoints = {
				 {x,                 	y, 						z},
 				 {x,                 	y-circumference, 		z},
 				 {x+circumference, 		(y-(circumference*2)),  z},
 				 {x+(circumference*2), 	(y-(circumference*2)), 	z},
 				 {x+(circumference*3), 	(y-circumference), 		z},
 				 {x+(circumference*3),	y, 						z}
  		};
		
		return (currentPoints);
	}

	
	/**************************************************************************
	 * GET POSITIONS FROM COORDINATE STRING
	 * 
	 * Return an double array of positions based upon the string that is passed
	 * in.  Parse out YYZ positions until the end of the string is reached 
	 * 
	 * @return
	 *************************************************************************/
	
	public static double[][] getPositionsFromString(String coordStr) {
		
		if (coordStr==null){
			System.out.println("getPositionsFromString() - Bad Coordinates");
			return null;
		}
		if (coordStr.length() < 3) {
			System.out.println("getPositionsFromString()  - Bad Coordinates: |" + coordStr + "|");
			return null;
		}
			
		String[] coords = coordStr.split(",", 5); 
		double[][] bioPositions = {
				                  {0.00,0.00,0.00},
		                          {0.00,0.00,0.00} };
		
		//System.out.println("Parsing Coords: " + coords.length + "    " + coordStr );
		// Store the Coordinate Points in BioMightPosition objects
		int numCoords = coords.length/3;
		int i = 0;
		for (int j=0; j<numCoords; j++)
		{
			bioPositions[j][0] = Double.valueOf(coords[i*j]);
			bioPositions[j][1] = Double.valueOf(coords[i*j+1]);
			bioPositions[j][2] = Double.valueOf(coords[i*j+2]);
			//System.out.println("Storing Coordinates: " + j +    "  x: " + coords[i] + " y: " + coords[i+1] + " z: " + coords[i+2]);
			i++;
		}
		
		//System.out.println("CoordPoints are parsed!");
		return bioPositions;
	}
	
	
	
	/**************************************************************************
	 * GET POSITIONS FROM COORDINATE STRING
	 * 
	 * Return an double array of positions based upon the string that is passed
	 * in.  Parse out YYZ positions until the end of the string is reached 
	 * 
	 * @return
	 *************************************************************************/
	
	public static double[][] getOrientationFromString(String coordStr) {
		
		if (coordStr==null){
			System.out.println("BAD Coordinates - NULL");
			return null;
		}
		if (coordStr.length() < 4) {
			System.out.println("BAD Coordinates: |" + coordStr + "|");
			return null;
		}
			
		String[] coords = coordStr.split(",", 5); 
		double[][] bioPositions = {
				                  {0.00,0.00,0.00,0.00},
		                          {0.00,0.00,0.00,0.00} };
		
		//System.out.println("Parsing Coords: " + coords.length + "    " + coordStr );
		// Store the Coordinate Points in BioMightPosition objects
		int numCoords = coords.length/4;
		int i = 0;
		for (int j=0; j<numCoords; j++)
		{
			bioPositions[j][0] = Double.valueOf(coords[i*j]);
			bioPositions[j][1] = Double.valueOf(coords[i*j+1]);
			bioPositions[j][2] = Double.valueOf(coords[i*j+2]);
			bioPositions[j][3] = Double.valueOf(coords[i*j+3]);
			//System.out.println("Storing Orientation Coordinates: " + j +    "  x: " + bioPositions[j][0] + " y: " + bioPositions[j][1] + " z: " + bioPositions[j][2] + " w: " + bioPositions[j][3]);
			i++;
		}
		
		//System.out.println("CoordPoints are parsed!");
		return bioPositions;
	}


 	/***************************************************************************************
	 * APPLY SCALE
	 * 
	 * Carries out a translation given a set of points, returns a set of new points
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/
	
	public static double[][] applyScale(double[][] currentPoints, double translateArray[], double scaleArray[])
	{	
		//System.out.println("ApplyTranslation in Scale: " + translateArray[0] + " " + translateArray[1]);
		
		// Set up the points that will result from the translation
		int numPoints=currentPoints.length;	
		double[][] scaledPoints = new double[numPoints][3];

		// Base Scale Matrix
      	// Scale based on the vector
		double[][] scaleMatrix = { 
 				 {scaleArray[0], 0, 0, 0},
 				 {0, scaleArray[1], 0, 0},
 				 {0, 0, scaleArray[2], 0},
 				 {0, 0, 0, 1}
   		};		
    					
 		
 		// We have the Center point of the current object
		// We want to place the next object on center with the prior object
		// We expand it and when we put it back it must be
 		double centerTranslate[] = getCenterPoint(currentPoints);
		
 		double x = centerTranslate[0];
 		double y = centerTranslate[1];
 		double z = centerTranslate[2];
 		
		double originTranslateArray[] = {-x, -y, -z};
		double revOriginTranslateArray[] = {x, y, z};
 		double[][] originPoints = applyTranslation(currentPoints, originTranslateArray);	
  		//dumpPoints("Scale OriginPoints", originPoints); 
 		
		    		
		// Scale the points now that they are centered
  		// around the origin
		for (int octopos=0; octopos<numPoints; octopos++)
  		{		
  			// set up X
  			scaledPoints[octopos][0] = 
  				(scaleMatrix[0][0] * originPoints[octopos][0]) + 
    			(scaleMatrix[0][1] * originPoints[octopos][1]) + 
    			(scaleMatrix[0][2] * originPoints[octopos][2]) +
    			(scaleMatrix[0][3] * 1);
    			
  					
  			//set up Y
  			scaledPoints[octopos][1] = 
  				(scaleMatrix[1][0] * originPoints[octopos][0]) + 
  				(scaleMatrix[1][1] * originPoints[octopos][1]) + 
  				(scaleMatrix[1][2] * originPoints[octopos][2]) +
  				(scaleMatrix[1][3] * 1);
  				
      			
  			// set up Z
  			scaledPoints[octopos][2] = 
  				(scaleMatrix[2][0] * originPoints[octopos][0]) + 
  				(scaleMatrix[2][1] * originPoints[octopos][1]) + 
  				(scaleMatrix[2][2] * originPoints[octopos][2]) +
  				(scaleMatrix[2][3] * 1);
  					
  			// 	set up Direction
  			double direction = 
  				(scaleMatrix[3][0] * 1) + 
  				(scaleMatrix[3][1] * 1) + 
  				(scaleMatrix[3][2] * 1) +
  				(scaleMatrix[3][3] * 1);	  				
   		}  	
		//dumpPoints("Scale ScaledPoints", scaledPoints);
		
  	   	double[][] worldPoints = applyTranslation(scaledPoints, revOriginTranslateArray);	
  		//dumpPoints(worldPoints);
  	   	
  		// Move the points according to the passed in translation matrix
  		double[][] nextPoints = applyTranslation(worldPoints, translateArray);	
  		//dumpPoints("Completed Scale", nextPoints);
  		
  		return nextPoints;
	}

	/***************************************************************************************
	 * APPLY TRANSLATION
	 * 
	 * Carries out a translation given a set of points, returns a set of new points
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/
	
	public static double[][] applyTranslation(double[][] currentPoints, double translateArray[])
	{	
		//System.out.println("ApplyTranslation: " translateArray[0] + " " + translateArray[1]);
		
		// Set up the points that will result from the translation
		int numPoints=currentPoints.length;	
		double[][] nextPoints = new double[numPoints][3];
		
		
		// Base Transformation Matrix
      	// Translate based on the vector
		double[][] transformMatrix = { 
 				 {1, 0, 0, translateArray[0]},
 				 {0, 1, 0, translateArray[1]},
 				 {0, 0, 1, translateArray[2]},
 				 {0, 0, 0, 1}
   		};		
    			
  
		// Translate the Octogon through space
		// There are eight points. Each point has an xyz cooordinate
	
  		for (int octopos=0; octopos<numPoints; octopos++)
  		{		
  			// set up X
  			nextPoints[octopos][0] = 
  				MathUtils.round((transformMatrix[0][0] * currentPoints[octopos][0]) + 
    			(transformMatrix[0][1] * currentPoints[octopos][1]) + 
    			(transformMatrix[0][2] * currentPoints[octopos][2]) +
    			(transformMatrix[0][3] * 1), 8);
    			
  					
  			//set up Y
  			nextPoints[octopos][1] = 
  				MathUtils.round((transformMatrix[1][0] * currentPoints[octopos][0]) + 
  				(transformMatrix[1][1] * currentPoints[octopos][1]) + 
  				(transformMatrix[1][2] * currentPoints[octopos][2]) +
  				(transformMatrix[1][3] * 1), 8);
  				
      			
  			// set up Z
  			nextPoints[octopos][2] = 
  					MathUtils.round((transformMatrix[2][0] * currentPoints[octopos][0]) + 
  				(transformMatrix[2][1] * currentPoints[octopos][1]) + 
  				(transformMatrix[2][2] * currentPoints[octopos][2]) +
  				(transformMatrix[2][3] * 1), 8);
  					
  			// 	set up Direction
  			double direction = 
  				MathUtils.round((transformMatrix[3][0] * 1) + 
  				(transformMatrix[3][1] * 1) + 
  				(transformMatrix[3][2] * 1) +
  				(transformMatrix[3][3] * 1), 8);	  				
   		}  	

  		return nextPoints;
	}

	/***************************************************************************************
	 * APPLY TRANSLATION
	 * 
	 * Carries out a translation given a set of points, returns a set of new points
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/
	
	public static double[] applyTranslation(double[] currentPoint, double translateArray[])
	{	
		//System.out.println("ApplyTranslation: " translateArray[0] + " " + translateArray[1]);
		
		// Set up the points that will result from the translation
		double[] nextPoint = {0, 0, 0};
    		
		
		// Base Transformation Matrix
      	// Translate based on the vector
		double[][] transformMatrix = { 
 				 {1, 0, 0, translateArray[0]},
 				 {0, 1, 0, translateArray[1]},
 				 {0, 0, 1, translateArray[2]},
 				 {0, 0, 0, 1}
   		};		
    			
  
		// Translate the Octogon through space
		// There are eight points. Each point has an xyz cooordinate
	
		// set up X
		nextPoint[0] = 
			(transformMatrix[0][0] * currentPoint[0]) + 
			(transformMatrix[0][1] * currentPoint[1]) + 
			(transformMatrix[0][2] * currentPoint[2]) +
			(transformMatrix[0][3] * 1);
			
				
		//set up Y
		nextPoint[1] = 
			(transformMatrix[1][0] * currentPoint[0]) + 
			(transformMatrix[1][1] * currentPoint[1]) + 
			(transformMatrix[1][2] * currentPoint[2]) +
			(transformMatrix[1][3] * 1);
			
  			
		// set up Z
		nextPoint[2] = 
			(transformMatrix[2][0] * currentPoint[0]) + 
			(transformMatrix[2][1] * currentPoint[1]) + 
			(transformMatrix[2][2] * currentPoint[2]) +
			(transformMatrix[2][3] * 1);
				
		// 	set up Direction
		double direction = 
			(transformMatrix[3][0] * 1) + 
			(transformMatrix[3][1] * 1) + 
			(transformMatrix[3][2] * 1) +
			(transformMatrix[3][3] * 1);	  				
	  	

  		return nextPoint;
	}

	
		
	
	/***************************************************************************************
	 * GET CENTERPOINT  
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
	
	public static double[] getCenterPointOle(double[][] points)
	{	
		double xCenter = 0.0;
    	double yCenter = 0.0;
    	double zCenter = 0.0;
		
    	
    	int numPoints=points.length;	
    
		// Get the Magnitude of each
		BioMightPosition point0 = new BioMightPosition(0, 0, 0);
		BioMightPosition point1 = new BioMightPosition(points[0][0], points[0][1], points[0][2]);
		BioMightPosition point2 = new BioMightPosition(points[1][0], points[1][1], points[1][2]);
		
		System.out.println("Position 1: " 
				+ points[0][0] + "  "
				+ points[0][1] + "  "
				+ points[0][2]);
		
		System.out.println("Position 2: " 
				+ points[1][0] + "  "
				+ points[1][1] + "  "
				+ points[1][2]);
	
		double distance1 = BioGraphics.distance(point0, point1);
		double distance2 = BioGraphics.distance(point0, point2);
		
		System.out.println("Distance1 : " + distance1); 
		System.out.println("Distance2 : " + distance1); 
		
		// Make them unit Vectors
		double newXPoint1 = points[0][0] / distance1;
		double newYPoint1 = points[0][1] / distance1;
		double newZPoint1 = points[0][2] / distance1;
		
		double newXPoint2 = points[1][0] / distance2;
		double newYPoint2 = points[1][1] / distance2;
		double newZPoint2 = points[1][2] / distance2;		
	
		
		System.out.println("Unit Vector 1: " 
				+ newXPoint1 + "  "
				+ newYPoint1 + "  "
				+ newZPoint1);
		
		System.out.println("Unit Vector 2: " 
				+ newXPoint2 + "  "
				+ newYPoint2 + "  "
				+ newZPoint2);
		
		// Create two Vectors from the two normalized points
	 	BioVector bioVectorResult = null;
		BioVector bioVector1 = new BioVector(0, 0, 0, newXPoint1, newYPoint1, newZPoint1);
		BioVector bioVector2 = new BioVector(0, 0, 0, newXPoint2, newYPoint2, newZPoint1);

		// Get the Cross Product.   This yields a perpindicular vector to the plane of the Circle
		bioVectorResult = BioGraphics.crossProduct(bioVector1, bioVector2);
					
		// The perpendicular to the two vectors
		double xOrient =  bioVectorResult.getxEndPos();
		double yOrient =  bioVectorResult.getyEndPos();  
		double zOrient =  bioVectorResult.getzEndPos(); 
    	
    	// Get the point directly across, that is 180 degrees
    	double[][] rotPoints = BioGraphics.applyRotation(new double[][] {{newXPoint1, newYPoint1, newZPoint1}}, 0, 180, new double[] {xOrient, yOrient, zOrient});
    	
	
    	// Scale the point to where it should be
    	double xPoint = rotPoints[0][0] * distance1;
    	double yPoint = rotPoints[0][1] * distance1;
    	double zPoint = rotPoints[0][2] * distance1;
    	
		// Get the Midpoint between initial point and 180 degree rotated point.  
    	// This will yield the center
    	xCenter = MathUtils.round( (points[0][0] + xPoint)/2, 8);
    	yCenter = MathUtils.round( (points[0][1] + yPoint)/2, 8);
    	zCenter = MathUtils.round( (points[0][2] + zPoint)/2, 8);
	    	
    	
		System.out.println("CenterPoint is: " 
				+ xCenter + "  "
				+ yCenter + "  "
				+ zCenter);
		

		
		double[] centerPoint = {xCenter, yCenter, zCenter};
		return (centerPoint);
	}
	
	
	/***************************************************************************************
	 * GET CENTERPOINT OLE
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
	
	public static double[] getCenterPoint(double[][] points)
	{	
		double x1 =  0.0;
		double y1 =  0.0;
		double z1 =  0.0;
			
		double x2 =  0.0;
		double y2 =  0.0;
		double z2 =  0.0;
	
		double xCenter = 0.0;
    	double yCenter = 0.0;
    	double zCenter = 0.0;
		
    	
    	int numPoints=points.length;	

       	// Get the Center of a Line segment 
    	if (numPoints == 2)
		{
			// Get the Midpoint between points 0 and 2
	    	//MathUtils.round( (points[0][0] + points[1][0])/2, 8);
	    	//MathUtils.round( (points[0][1] + points[1][1])/2, 8);
	    	//zCenter = MathUtils.round( (points[0][2] + points[1][2])/2, 8);
	    	int totalSegments=5;
	    	int segment = 1;
	    	// this will give me the 5th
	    	xCenter = MathUtils.round( points[0][0]  +   ( (points[1][0] - points[0][0]) /  totalSegments) * segment, 8);
	    	yCenter = MathUtils.round( points[0][1]  +   ( (points[1][1] - points[0][1]) /  totalSegments) * segment, 8);
	    	zCenter = MathUtils.round( points[0][2]  +   ( (points[1][2] - points[0][1]) /  totalSegments) * segment, 8);
	    	
			System.out.println("2Points Position X0: " 
					+ points[0][0] + "  "
					+ points[0][1] + "  "
					+ points[0][2]);
			
			System.out.println("Position X1: " 
					+ points[1][0] + "  "
					+ points[1][1] + "  "
					+ points[1][2]);
					
	    	
			System.out.println("CenterPoint is: " 
					+ xCenter + "  "
					+ yCenter + "  "
					+ zCenter);
			
		}
    	// Get the Center of a Parallelogram 
    	else if (numPoints == 4)
		{
			// Get the Midpoint between points 0 and 2
    		// It will be the opposite corner
	    	xCenter = MathUtils.round( (points[0][0] + points[2][0])/2, 8);
	    	yCenter = MathUtils.round( (points[0][1] + points[2][1])/2, 8);
	    	zCenter = MathUtils.round( (points[0][2] + points[2][2])/2, 8);
	    	
	    	/*
			System.out.println("4Points Position X0: " 
					+ points[0][0] + "  "
					+ points[0][1] + "  "
					+ points[0][2]);
			
			System.out.println("Position X1: " 
					+ points[2][0] + "  "
					+ points[2][1] + "  "
					+ points[2][2]);
					
	    	
			System.out.println("CenterPoint is: " 
					+ xCenter + "  "
					+ yCenter + "  "
					+ zCenter);
			*/
			
		}
    	// Get the Center of a Hexagon
    	else if (numPoints == 6)
		{
			// Get the Midpoint between points 0 and 3
	    	xCenter = MathUtils.round( (points[0][0] + points[3][0])/2, 8);
	    	yCenter = MathUtils.round( (points[0][1] + points[3][1])/2, 8);
	    	zCenter = MathUtils.round( (points[0][2] + points[3][2])/2, 8);
	    	
	    	/*
			System.out.println("Position X0: " 
					+ points[0][0] + "  "
					+ points[0][1] + "  "
					+ points[0][2]);
			
			System.out.println("Position X1: " 
					+ points[1][0] + "  "
					+ points[1][1] + "  "
					+ points[1][2]);
			
			System.out.println("Position Between 0 and 1: " 
					+ x1 + "  "
					+ y1 + "  "
					+ z1);
	    	*/
				
	    	
			/*System.out.println("CenterPoint is: " 
					+ xCenter + "  "
					+ yCenter + "  "
					+ zCenter);
			*/
		}
    	else if (numPoints == 8)
		{
			// Get the Midpoint between points 0 and 1
	    	x1 = MathUtils.round( (points[0][0] + points[1][0])/2, 8);
	    	y1 = MathUtils.round( (points[0][1] + points[1][1])/2, 8);
	    	z1 = MathUtils.round( (points[0][2] + points[1][2])/2, 8);
	    	
	    	/*
			System.out.println("Position X0: " 
					+ points[0][0] + "  "
					+ points[0][1] + "  "
					+ points[0][2]);
			
			System.out.println("Position X1: " 
					+ points[1][0] + "  "
					+ points[1][1] + "  "
					+ points[1][2]);
			
			System.out.println("Position Between 0 and 1: " 
					+ x1 + "  "
					+ y1 + "  "
					+ z1);
	    	*/
	
			// Get the Midpoint between points 4 and 5
	    	x2 = MathUtils.round( (points[4][0] + points[5][0])/2, 8);
	    	y2 = MathUtils.round( (points[4][1] + points[5][1])/2, 8);
	    	z2 = MathUtils.round( (points[4][2] + points[5][2])/2, 8);
	    	
	    	
	    	/*
			System.out.println("Position X4: " 
					+ points[4][0] + "  "
					+ points[4][1] + "  "
					+ points[4][2]);
			
			System.out.println("Position X5: " 
					+ points[5][0] + "  "
					+ points[5][1] + "  "
					+ points[5][2]);
			
			System.out.println("Position Between 5 and 6: " 
					+ x2 + "  "
					+ y2 + "  "
					+ z2);
			*/
		
			// Get the Midpoint between two centerpoints
	    	xCenter = MathUtils.round( (x1 + x2)/2, 8);
	    	yCenter = MathUtils.round( (y1 + y2)/2, 8);
	    	zCenter = MathUtils.round( (z1 + z2)/2, 8);
			
	    	
			/*System.out.println("CenterPoint is: " 
					+ xCenter + "  "
					+ yCenter + "  "
					+ zCenter);
			*/
		}
		
		
		
		
		double[] centerPoint = {xCenter, yCenter, zCenter};
		return (centerPoint);
	}
	
	
	/***************************************************************************************
	 * GET OCTAGON DIAMETER 
	 * 
	 * Gets the diammeter of the octagon
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/
	
	public static double getOctoDiam(double[][] points)
	{	
		double x1 =  0.0;
		double y1 =  0.0;
		double z1 =  0.0;
			
		double x2 =  0.0;
		double y2 =  0.0;
		double z2 =  0.0;

		
		// 
		if (points.length == 8)
		{
			// Get the Midpoint between points 0 and 1
	    	x1 = MathUtils.round( (points[0][0] + points[1][0])/2, 8);
	    	y1 = MathUtils.round( (points[0][1] + points[1][1])/2, 8);
	    	z1 = MathUtils.round( (points[0][2] + points[1][2])/2, 8);
	    	
	  
			/*System.out.println("Position X0: " 
					+ points[0][0] + "  "
					+ points[0][1] + "  "
					+ points[0][2]);
			
			System.out.println("Position X1: " 
					+ points[1][0] + "  "
					+ points[1][1] + "  "
					+ points[1][2]);
			
			System.out.println("Position Between 0 and 1: " 
					+ x1 + "  "
					+ y1 + "  "
					+ z1);
	    	*/
	
			// Get the Midpoint between points 4 and 5
	    	x2 = MathUtils.round( (points[4][0] + points[5][0])/2, 8);
	    	y2 = MathUtils.round( (points[4][1] + points[5][1])/2, 8);
	    	z2 = MathUtils.round( (points[4][2] + points[5][2])/2, 8);
	    	
	    	/*
			System.out.println("Position X4: " 
					+ points[4][0] + "  "
					+ points[4][1] + "  "
					+ points[4][2]);
			
			System.out.println("Position X5: " 
					+ points[5][0] + "  "
					+ points[5][1] + "  "
					+ points[5][2]);
			
			System.out.println("Position Between 5 and 6: " 
					+ x2 + "  "
					+ y2 + "  "
					+ z2);
			*/
	    	
		}
		
	
		// Get the Distance between the two opposing Centerpoints
		BioMightPosition point1 = new BioMightPosition(x1, y1, z1); 
		BioMightPosition point2 = new BioMightPosition(x2, y2, z2); 
		double diameter = MathUtils.round(Math.abs(distance(point1, point2)), 8);		
   
		//System.out.println("Ocotagon Diameter is: " + diameter);
		
		return (diameter);
	}
	
	


	/***************************************************************************************
	 * GET MINIMUN X
	 * 
	 * Gets the vertex with the lowest X position
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/
	
	private static double getMinX(double[][] points)
	{
		// Assign to the X component of the first vertex
		double minX = points[0][0];
		
		int numPoints=points.length;
		for (int octopos=0; octopos<numPoints; octopos++)
		{		
				if (minX < points[octopos][0])
				{    
					minX = points[octopos][0];
				}
		}
		
		return minX;
	}

	/***************************************************************************************
	 * GET MAX X
	 * 
	 * Gets the vertex with th highest X position
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/
	
	private static double getMaxX(double[][] points)
	{
		
		// Assign to the X component of the first vertex
		double maxX = points[0][0];
		
		int numPoints=points.length;
		for (int octopos=0; octopos<numPoints; octopos++)
		{			
			if (maxX > points[octopos][0])
			{    
				maxX = points[octopos][0];
			}
						
		}
		
		return maxX;
	}
	
	/***************************************************************************************
	 * GET MINIMUN Y
	 * 
	 * Gets the vertex with the lowest Y position
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/
	
	private static double getMinY(double[][] points)
	{
		// Assign to the y component of the first vertex
		double minY = points[0][1];
		
		int numPoints=points.length;
		for (int octopos=0; octopos<numPoints; octopos++)
		{		
				if (minY < points[octopos][1])
				{    
					minY = points[octopos][1];
				}
		}
		
		return minY;
	}

	/***************************************************************************************
	 * GET MAX Y
	 * 
	 * Gets the vertex with th highest Y position
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/
	
	private static double getMaxY(double[][] points)
	{
		
		// Assign to the Y component of the first vertex
		double maxY = points[0][1];
		
		int numPoints=points.length;
		for (int octopos=0; octopos<numPoints; octopos++)
		{			
			if (maxY > points[octopos][1])
			{    
				maxY = points[octopos][1];
			}
						
		}
		
		return maxY;
	}
	

	/***************************************************************************************
	 * GET MINIMUN Z
	 * 
	 * Gets the vertex with the lowest Z position
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/
	
	private static double getMinZ(double[][] points)
	{
		// Assign to the y component of the first vertex
		double minZ = points[0][2];
		
		int numPoints=points.length;
		for (int octopos=0; octopos<numPoints; octopos++)
		{		
				if (minZ < points[octopos][2])
				{    
					minZ = points[octopos][2];
				}
		}
		
		return minZ;
	}

	/***************************************************************************************
	 * GET MAX Z
	 * 
	 * Gets the vertex with the highest Z position
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/
	
	private static double getMaxZ(double[][] points)
	{
		
		// Assign to the Y component of the first vertex
		double maxZ = points[0][1];
		
		int numPoints=points.length;
		for (int octopos=0; octopos<numPoints; octopos++)
		{			
			if (maxZ > points[octopos][1])
			{    
				maxZ = points[octopos][1];
			}
						
		}
		
		return maxZ;
	}
	
	
	/***************************************************************************************
	 * GET CENTERPOINT OLD
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
	
	private static double[] getCenterPointOld(double[][] points)
	{	
		int pivot1=0;
		int pivot2=0;    
	
		double x =  0.0;
		double y =  0.0;
		double z =  0.0;
			
		
		// Determine the plane in which we are oriented;
		// If X remains constant, then the tube is moving left to right
		// If Y remains constant then the tube is moving up and down
		// if Z remains constant the tube is moving front to back
		// If not,we are moving diagonally
	
		
		// MOVING LEFT/RIGHT
		if (points[1][0] == points[2][0] && points[2][0] == points[5][0]){
			//System.out.println("X remains constant - traveling left/right");
			// We are moving in the y-z planes as x is remaining constant
	
			// x is constant
			x = points[0][0];
			
			
			// First, get the uppermost or bottom most side, whichever ever comes first
			// We will have only two points next to each other in the same X-plane at position Y
			// We will need to adjust for rotation next
			int numPoints=points.length;
			for (int octopos=0; octopos<numPoints; octopos++)
	    	{		
	    	    // We have 2 points in a row on the same Y coordinate, 
				// get the center point
	    		if (points[octopos][1] == points[octopos+1][1])
	    		{
	    						
					// Determine if the current point is at the front or back in relation to 0,0,0
	    			// We need to look at Z
	    			if (points[octopos][2] < points[octopos+1][2])
	    			{	
	    				// The center will lie between the two top or bottom points
	    				z = points[octopos][2] + Math.abs((points[octopos+1][2] - points[octopos][2])/2);
	    			}
	    			else
	    			{
		    			z = points[octopos][2] - Math.abs((points[octopos+1][2] - points[octopos][2])/2);	
	    			}
	    			//System.out.println("Top or Bottom  Position: " + points[octopos][2] + "   "   +  points[octopos+1][2]);
	    	    	//System.out.println("Z between is: " + z);
	    			break;
	    	    	
	    		}
	    	}
		   	
			
			
			// Next, get the front or back most points.  Two points residing one the same Z plane
			// We will have two points next to each other in the same X-plane at position Z
			for (int octopos=0; octopos<numPoints; octopos++)
	    	{		
	    	    // We have 2 in a row, get the center point		
	    		if (points[octopos][2] == points[octopos+1][2])
	    		{
	
					// Determine if the current point is at the top or bottom in relation to 0,0,0
	    			// We need to look at Z
	    			if (points[octopos][1] < points[octopos+1][1])
	    			{	
	    				// The center will lie between the two top or bottom points
	    				y = points[octopos][1] + Math.abs((points[octopos][1] - points[octopos+1][1])/2);
	    			}
	    			else
	    			{
	    				y = points[octopos][1] - Math.abs((points[octopos][1] - points[octopos+1][1])/2);
	    			}    			
	    			//System.out.println("Front or Back at: " + points[octopos][1] + "   "   +  points[octopos+1][1]);
	    	    	//System.out.println("Y between is: " + y);
	    			break;
	    		}
	    		
	    	}
	    }	
		
		// MOVING UP/DOWN
	    else if (points[1][1] == points[2][1] && points[2][1] == points[5][1]){
	    	//System.out.println("Y remains constant - traveling up/down");
	    	// We are moving in the x-z planes as y is remaining constant
	    	
	    	// x is constant
	    	y = points[0][1];
	    			
	    			
	    	// First, get the leftmost or rightmost side, whichever ever comes first
	    	// We will have only two points next to each other in the same X-plane at position Y
	    	// We will need to adjust for rotation next
	    	int numPoints=points.length;
	    	for (int octopos=0; octopos<numPoints; octopos++)
	    	{		
	    		// We have 2 points in a row on the same X coordinate, 
	    		// get the center point
	    	    if (points[octopos][0] == points[octopos+1][0])
	    	    {
	    	    						
	    	    	// Determine if the current point is at the left or right in relation to 0,0,0
	       	    	// We need to look at Z
	       			if (points[octopos][2] < points[octopos+1][2])
	       			{	
	       				// The center will lie between the two top or bottom points
	       				z = points[octopos][2] + Math.abs((points[octopos+1][2] - points[octopos][2])/2);
	       			}
	       			else
	       			{
	        			z = points[octopos][2] - Math.abs((points[octopos+1][2] - points[octopos][2])/2);	
	       			}    			
	        		//System.out.println("Front or Back - Z: " + points[octopos][2] + "   "   +  points[octopos+1][2]);
		    		//System.out.println("Z middle is: " + z);
	       			break;
	       		}
	       	}	
	    			
	    			
	    	// Next, get the front or back most points.  Two points residing one the same Z plane
	    	// We will have two points next to each other in the same X-plane at position Z
	    	for (int octopos=0; octopos<numPoints; octopos++)
	       	{		
	    		// We have 2 in a row, get the center point		
	    	  	if (points[octopos][2] == points[octopos+1][2])
	    	    {
	    	
	    	  		// Determine if the current point is at the front or back
	    	    	// We need to look at Z, x is in the middke
	    	    	if (points[octopos][0] < points[octopos+1][0])
	    	    	{	
	    	    		// The center will lie between the two top or bottom points
	    	    		x = points[octopos][0] + Math.abs((points[octopos][0] - points[octopos+1][0])/2);
	    	    	}
	    	    	else
	    	    	{
	    	    		x = points[octopos][0] - Math.abs((points[octopos][0] - points[octopos+1][0])/2);
	    	    	}    			
	    	    	//System.out.println("Front or Back at: " + points[octopos][0] + "   "   +  points[octopos+1][0]);
	    	    	//System.out.println("X between is: " + x);
	    	    	break;	    		
	    	    }
	       	}
	    }
		// MOVING FRONT to BACK
	    else if (points[1][2] == points[2][2] && points[2][2] == points[5][2]){
	    	//System.out.println("Z remains constant - traveling front/back");
	    	
	    	// We are moving in the x-y planes as z is remaining constant
	    	
	    	// z is constant
	    	z = points[0][2];
	    			
	    			
	    	// First, get the leftmost or rightmost side, whichever ever comes first
	    	// We will have only two points next to each other in the same X-plane at position Y
	    	// We will need to adjust for rotation next
	    	int numPoints=points.length;
	    	for (int octopos=0; octopos<numPoints; octopos++)
	    	{		
	    		// We have 2 points in a row on the same Y coordinate, 
	    		// get the center point
	    	    if (points[octopos][1] == points[octopos+1][1])
	    	    {
	    	    						
	    	    	// Determine if the current point is at the left or right in relation to 0,0,0
	       	    	// We need to look at X
	       			if (points[octopos][0] < points[octopos+1][0])
	       			{	
	       				// The center will lie between the two top or bottom points
	       				x = points[octopos][0] + Math.abs((points[octopos+1][0] - points[octopos][0])/2);
	       			}
	       			else
	       			{
	        			x = points[octopos][0] - Math.abs((points[octopos+1][0] - points[octopos][0])/2);	
	       			}    			
	        		//System.out.println("Left or Right - X: " + points[octopos][0] + "   "   +  points[octopos+1][0]);
		    		//System.out.println("X middle is: " + x);
	       			break;
	       		}
	       	}	
	    			
	    			
	    	// Next, get the top or bottom most points.  Two points residing one the same Z plane
	    	// We will have two points next to each other in the same X-plane at position Z
	    	for (int octopos=0; octopos<numPoints; octopos++)
	       	{		
	    		// We have 2 in a row, get the center point		
	    	  	if (points[octopos][1] == points[octopos+1][1])
	    	    {
	    	
	    	  		// Determine if the current point is at the front or back
	    	    	// We need to look at Z, x is in the middke
	    	    	if (points[octopos][1] < points[octopos+1][1])
	    	    	{	
	    	    		// The center will lie between the left and right points
	    	    		y = points[octopos][1] + Math.abs((points[octopos][1] - points[octopos+1][1])/2);
	    	    	}
	    	    	else
	    	    	{
	    	    		y = points[octopos][1] - Math.abs((points[octopos][1] - points[octopos+1][1])/2);
	    	    	}    			
	    	    	//System.out.println("Top or Bottom at: " + points[octopos][1] + "   "   +  points[octopos+1][1]);
	    	    	//System.out.println("Y between is: " + x);
	    	    	break;	    		
	    	    }
	       	}
	    	
	    }
	    else
	    {
 	    	System.out.println("getCenterPoint - PLANE UNDEFINED!");
	    } 	    	
	
		
    	//System.out.println("CenterPoint between is: " + x  + "  "  + y + "  " + z);
    	
		double[] centerPoint = {x, y, z};
		return (centerPoint);
	}
	
	/***************************************************************************************
	 * GENERATE 3D
	 * 
	 * This will create the information in the database   It is called from th generate()
	 * methods that create the individual components.
	 * 
	 * @param key
	 * @param user
	 * @return
	 * @throws DataException
	 * @throws DataSecurityException
	 ***************************************************************************************/
	  	
  	public static String generate3D(double[][] currentPoints, boolean bHeader, boolean bFooter, double[] diffColor) 	
	{	
	
		int returnCode = 0;		
		double xPos = 0.0;
		double yPos = 0.0;
		double zPos = 0.0;
		double xScale = 1.0;
		double yScale = 1.0;
		double zScale = 1.0;
		double xOrient = 0.0;
		double yOrient = 1.0;
		double zOrient = 0.0;
		double wOrient = 0.0;
		double radius = 0.5;
		double height = 1.0;
		double depth = 0.00125;
		int compGroup = 0;
		int depthDirection = 90;

		
	 	String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
    			"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n " +
    			"<X3D profile='Immersive' >\n" +
    			"<head>\n" +
    			 "<meta name='BioMightImage' content='BioSample.jpg'/>\n" +
    			 "<meta name='ExportTime' content='7:45:30'/>\n" +
    			 "<meta name='ExportDate' content='08/15/2008'/>\n" +
    			 "<meta name='BioMight Version' content='1.0'/>\n" + 
    			"</head>\n" +
    			"<Scene>\n" +
    			"<WorldInfo\n" +
    			"title='Object'\n" +
    			"info='\"BioMight Generated X3D\"'/>\n";		


		String ctrMarker = "<Transform DEF='SampleDef'\n";
		ctrMarker += "translation='0 0 0 '\n";					   					
		ctrMarker+=  "scale='1 1 1'>\n" +
	 	
		"<Shape DEF='SampleShape'\n" +
			    " containerField='children'>\n" +
			    " <Appearance\n" +
			    "  containerField='appearance'>\n";
					       				    
		ctrMarker+= " <Material DEF='Rust'\n" +
		    "containerField='material'\n" +
		    "ambientIntensity='" + 0.0 + "'\n" +
		    "shininess='" 		 + 0.0 + "'\n" +
		    "transparency='" 	 + 0.5 + "'\n" +
		    "diffuseColor='" + 
		    1.0 + " " + 
		    1.0 + " " +
		    1.0 + "'/>\n" +
		 	"</Appearance>\n" +			    
		    	 
			 "<Sphere DEF='BasophilGeoSphere'\n" +
			 	"containerField='geometry'\n" +
			 	"radius='" + 0.05 +"'/>\n" +
			 "</Shape>\n" +
		    	 
			"</Transform>\n\n"; 
		ctrMarker="";
		
    			String body = "";
    			String annotate = "";
    			
    			for (int octopos=0; octopos<currentPoints.length; octopos++)
    			{
					body += "<Transform DEF='SampleDef'\n";
				 	body += "translation='" 
				 			+ currentPoints[octopos][0] 
				 			+ " " + currentPoints[octopos][1] 
				 			+ " " + currentPoints[octopos][2] + "'\n";					   					
				 	body+=  "scale='1 1 1'>\n" +
				 	
					"<Shape DEF='SampleShape'\n" +
						    " containerField='children'>\n" +
						    " <Appearance\n" +
						    "  containerField='appearance'>\n";
    							       				    
    					body+= " <Material DEF='Rust'\n" +
					    "containerField='material'\n" +
					    "ambientIntensity='" + 0.0 + "'\n" +
					    "shininess='" 		 + 0.0 + "'\n" +
					    "transparency='" 	 + 0.5 + "'\n" +
					    "diffuseColor='" + 
					    diffColor[0] + " " + 
					    diffColor[1] + " " +
					    diffColor[2] + "'/>\n" +
					 	"</Appearance>\n" +			    
				
					    	 
						 "<Sphere DEF='BasophilGeoSphere'\n" +
						 	"containerField='geometry'\n" +
						 	"radius='" + 0.025 +"'/>\n" +
						 "</Shape>\n" +
					    	 
    					"</Transform>\n"; 
    					
    			}	
    			
    	
	
		String footer = "</Scene>" + "</X3D>\n";
		
		body = ctrMarker + body;
		
		if (bHeader)
			body = header+body; 
		if (bFooter)
			body = body+footer;
		
		return body;
	}

  	
  
  	
  	/**************************************************************************
	 * GET COORDINATE STRING
	 * 
	 * This is a temp hack to allow us to see what is being generated.  
	 * This is like the method in the BioMightTransform object
	 * 
	 *************************************************************************/
	
	public String getCoordinateStr(String coordStr, double depth, int depthDirection) {
		
		//System.out.println("Get Coodinate String: " + coordStr);
		BioMightPositions vertexPositions = new BioMightPositions();
		
		String[] coords = coordStr.split(",", 24);
		//System.out.println("Using Depth: " + depth); 
		
	
		int j=0;
		for (int i=0;i<=11;i+=3)
		{
			BioMightPosition vertex = new BioMightPosition();
			
			vertex.setXPos(Double.valueOf(coords[i]));
			vertex.setYPos(Double.valueOf(coords[i+1]));
			vertex.setZPos(Double.valueOf(coords[i+2]));
			//System.out.println("Storing Coordinates: " + j +    "  x: " + coords[i] + " y: " + coords[i+1] + " z: " + coords[i+2]);	
			vertexPositions.setBioMightPosition(j++, vertex);
		}
		
		// Store the lower plane
		// Use the Depth Direction,0,90,180,270 to see where we are
		
		for (int i=0;i<=11;i+=3)
		{
			BioMightPosition vertex = new BioMightPosition();
		
			if (depthDirection == 0) {
				vertex.setXPos(Double.valueOf(coords[i]));
				vertex.setYPos(Double.valueOf(coords[i+1]));
				vertex.setZPos(Double.valueOf(coords[i+2])-depth);
			}		
			else if (depthDirection == 90) {
				vertex.setXPos(Double.valueOf(coords[i])-depth);
				vertex.setYPos(Double.valueOf(coords[i+1]));
				vertex.setZPos(Double.valueOf(coords[i+2]));
			}
			else if (depthDirection == 180) {
				vertex.setXPos(Double.valueOf(coords[i]));
				vertex.setYPos(Double.valueOf(coords[i+1]));
				vertex.setZPos(Double.valueOf(coords[i+2])+depth);
			}
			else if (depthDirection == 270) {
				vertex.setXPos(Double.valueOf(coords[i])+depth);
				vertex.setYPos(Double.valueOf(coords[i+1]));
				vertex.setZPos(Double.valueOf(coords[i+2]));
			}			
			else {
				vertex.setXPos(Double.valueOf(coords[i]));
				vertex.setYPos(Double.valueOf(coords[i+1]));
				vertex.setZPos(Double.valueOf(coords[i+2])-depth);
			}
			
			//System.out.println("Storing BackPlane Coordinates: " + j +    "  x: " + coords[i] + " y: " + coords[i+1] + " z: " + coords[i+2]);	
			vertexPositions.setBioMightPosition(j++, vertex);
		}		

		//System.out.println("Stored CoordPoints!");
		return (coordStr);
	}
	
	

	/***************************************************************************************
	 * 
	 * APPLY ROTATION
	 * 
	 * Applies a rotation of theta degrees to the set of current points 
	 * to produce and return a set of new points
	 * 
	 ***************************************************************************************/
	
	public static double[][] applyRotation(double[][] currentPoints, int pivotPoint, BioMightOrientation orientation,  BioMightOrientation rotation)
	{	
		double[][] nextPoints = BioGraphics.applyRotation(currentPoints, pivotPoint,  rotation.getDegrees(), new double[] {rotation.getXAxis(), rotation.getYAxis(), rotation.getZAxis()} );
		return nextPoints;
	}
	
	/***************************************************************************************
	 * 
	 * APPLY ROTATION
	 * 
	 * Applies a rotation of theta degrees to the set of current points 
	 * to produce and return a set of new points
	 * 
	 ***************************************************************************************/
	
	public static double[][] applyRotation(double[][] currentPoints, int pivotPoint, double thetaAngle, double[] rotateVector)
	{	
	
		// Used to translate the points to the origin so that
		// the Euler Rotation algorithm can be applied
		int numPoints = currentPoints.length;
		double theta = Math.toRadians(thetaAngle);
		
		//System.out.println("ApplyRotation()  numPoints: " + numPoints  +  "  angle: " +  thetaAngle + " radiansAngle: " + theta);

 		//dumpPoints("StartPoints: ", currentPoints);
	
		// Set up a place to store the local points
		double[][] localPoints = new double[numPoints][3];	
		
		// The points that result from the rotation
		double[][] rotatePoints = new double[numPoints][3];	;

		// Set up the points that will result from the translation
		double[][] nextPoints = new double[numPoints][3];	
		
		
		// Base Transformation Matrix
      	// Translate based on the vector
		double[][] transformMatrix = { 
 				 {1, 0, 0, 0},
 				 {0, 1, 0, 0},
 				 {0, 0, 1, 0},
 				 {0, 0, 0, 1}
   		};		
    			
		double[] translateArray = new double[3]; 
		
		// PIVOT POINT
		// Set the Pivot Point at the base of the tube, translate to it	
		// It must lie just above the line of rotation an not on the line of rotation.
		if (pivotPoint == -1) 
		{
			// These are called from the generateDome routines and need
			// to be set up here
			//System.out.println("ApplyRotation() with No Pivot: ");

			// Move into the array for rotation application
			for (int point=0; point<numPoints; point++)
	    	{		
	    		localPoints[point][0] = currentPoints[point][0];
	    		localPoints[point][1] = currentPoints[point][1];
	    		localPoints[point][2] = currentPoints[point][2];
	    	}
		}
		else 
		{
			//System.out.println("ApplyRotation() with pivot: " + pivotPoint);
			
			if ((numPoints == 1) && (pivotPoint == 0))
			{		
				translateArray[0] = -currentPoints[pivotPoint][0]; 
				translateArray[1] = 0;
				translateArray[2] = -currentPoints[pivotPoint][2];    				
				//System.out.println("Adjust Pivot Point000 " + translateArray[0]  + "   " + translateArray[1] + "  "  +  translateArray[2] );
			}	
			else if ((numPoints == 4) && (pivotPoint == 0 || pivotPoint == 3))
			{		
				translateArray[0] = -currentPoints[pivotPoint][0]; 
				translateArray[1] = -currentPoints[pivotPoint][1];
				translateArray[2] = -currentPoints[pivotPoint][2];    				
			}	
			else if (pivotPoint == 3 || pivotPoint == 7 || pivotPoint == 1)
			{		
				translateArray[0] = -currentPoints[pivotPoint][0]; 
				translateArray[1] = -currentPoints[pivotPoint][1] + 0.01;
				translateArray[2] = -currentPoints[pivotPoint][2];    	  				
			}
			else if (pivotPoint == 5 || pivotPoint == 6) 
			{
				double circumference = Math.abs(currentPoints[pivotPoint][0] - currentPoints[pivotPoint][0]);  
				translateArray[0] =  -currentPoints[pivotPoint][0]; 
				translateArray[1] = -currentPoints[pivotPoint][1];
				translateArray[2] = -currentPoints[pivotPoint][2] - circumference;    				
			}
			else if (rotateVector[2] == 1.0)
			{
				translateArray[0] = -currentPoints[pivotPoint][0]; 
				translateArray[1] = -currentPoints[pivotPoint][1] - 0.01;
				translateArray[2] = -currentPoints[pivotPoint][2];    	  				
			}		
			//System.out.println("ApplyRotation()  Set up DEFAULT points: ");

			
			//  Pivot Point6 must be  at 0,0,circumference 
			//System.out.println("Pivot Point: " + pivotPoint);
			//System.out.println("PivotPoint Position: " + currentPoints[pivotPoint][0]  + "   " + currentPoints[pivotPoint][1] + "  "  +  currentPoints[pivotPoint][2] );
			//System.out.println("Adjust Pivot Point " + translateArray[0]  + "   " + translateArray[1] + "  "  +  translateArray[2] );

		
	 		localPoints = applyTranslation(currentPoints, translateArray);	
		}		

 		//dumpPoints("Local Points: ", localPoints);
		
 		
		// ROTATION
    	// Rotation matrix for rotations about the line through point (a, b, c)
    	// with a direction vector [ u, v, w ] by the angle theta. 
    	// where u*u + v*v + w*w = 1
    			
    	// x-coordinate of a point on the line of rotation.
    	double a = rotateVector[0];
    	// y-coordinate of a point on the line of rotation
    	double b = rotateVector[1];
    	// z-coordinate of a point on the line of rotation
    	double c = rotateVector[2];

    	// uUn x-coordinate of the line's direction vector (unnormalized)
    	double uUn = rotateVector[0];
    	// vUn y-coordinate of the line's direction vector (unnormalized)
    	double vUn = rotateVector[1];
    	// wUn z-coordinate of the line's direction vector (unnormalized)
    	double wUn = rotateVector[2];
    		
    	
    	// Normalize the direction vector
    	double l = 1.0;
    	double u = uUn/l;
    	double v = vUn/l;
    	double w = wUn/l;

    	// Set some intermediate values.
    	double u2 = u*u;
    	double v2 = v*v;
    	double w2 = w*w;
   
    	// Set up some variables
    	double cosT = MathUtils.round(Math.cos(theta), 8);
    	double oneMinusCosT = MathUtils.round(1-cosT, 8);
    	double sinT = MathUtils.round(Math.sin(theta), 8);
     	//	System.out.println("Cos : " + cosT);
    	//	System.out.println("1-Cos : " + oneMinusCosT);
    	//	System.out.println("SinT : " + sinT);  
          
    	// Build the matrix entries element by element.
    	transformMatrix[0][0] = MathUtils.round((u2 + (v2 + w2) * cosT), 8);
    	transformMatrix[0][1] = MathUtils.round((u*v * oneMinusCosT - w*sinT), 8);
    	transformMatrix[0][2] = MathUtils.round((u*w * oneMinusCosT + v*sinT), 8);
		transformMatrix[0][3] = MathUtils.round((a*(v2 + w2) - u*(b*v + c*w))*oneMinusCosT
				+ (b*w / -c*v)*sinT, 8);
		
		Double dd = new Double(transformMatrix[0][3]);
		if (dd.isNaN())
		{
			//System.out.println("Reset NAN!");
			transformMatrix[0][3] = 0;
		}
    
    	
		// 	System.out.println("Transform Matrix 0 is setup: " + 
		// 	transformMatrix[0][0] + "  " +
		//  	transformMatrix[0][1] + "  " +
		// 	transformMatrix[0][2] + "  " +
		//	transformMatrix[0][3]);
    	    	
    	transformMatrix[1][0] = MathUtils.round((u*v * oneMinusCosT + w*sinT), 8);
    	transformMatrix[1][1] = MathUtils.round((v2 + (u2 + w2) * cosT), 8);
    	transformMatrix[1][2] = MathUtils.round((v*w * oneMinusCosT - u*sinT), 8);
    	transformMatrix[1][3] = MathUtils.round(((b*(u2 + w2) - v*(a*u + c*w))*oneMinusCosT
    	+ (c*u - a*w)*sinT), 8);
    	
    	transformMatrix[2][0] = MathUtils.round((u*w * oneMinusCosT - v*sinT), 8);
    	transformMatrix[2][1] = MathUtils.round((v*w * oneMinusCosT + u*sinT), 8);
    	transformMatrix[2][2] = MathUtils.round((w2 + (u2 + v2) * cosT), 8);
    	transformMatrix[2][3] = MathUtils.round(((c*(u2 + v2) - w*(a*u + b*v))*oneMinusCosT
    	+ (a*v - b*u)*sinT), 8);

          
		for (int octopos=0; octopos<numPoints; octopos++)
		{		
			// set up X
			rotatePoints[octopos][0] = 
			MathUtils.round(
				(transformMatrix[0][0] * localPoints[octopos][0]) + 
				(transformMatrix[0][1] * localPoints[octopos][1]) + 
				(transformMatrix[0][2] * localPoints[octopos][2]) +
				(transformMatrix[0][3] * 1), 8);
			
			//System.out.println("Setup X " + octopos + "   " + rotatePoints[octopos][0]);  

				
			//set up Y
			rotatePoints[octopos][1] = 
			MathUtils.round(
				(transformMatrix[1][0] * localPoints[octopos][0]) + 
				(transformMatrix[1][1] * localPoints[octopos][1]) + 
				(transformMatrix[1][2] * localPoints[octopos][2]) +
				(transformMatrix[1][3] * 1), 8);
			//System.out.println("Setup Y " + octopos + "   " + rotatePoints[octopos][1]);  
				 
		    
			
			// set up Z
			rotatePoints[octopos][2] = 
			MathUtils.round((transformMatrix[2][0] * localPoints[octopos][0]) + 
			(transformMatrix[2][1] * localPoints[octopos][1]) + 
			(transformMatrix[2][2] * localPoints[octopos][2]) +
			(transformMatrix[2][3] * 1), 8);
			//System.out.println("Setup Z " + octopos + "   " + rotatePoints[octopos][2]); 
		  	
			
			// 	set up Direction
			double direction = 
			MathUtils.round((transformMatrix[3][0] * 1) + 
			(transformMatrix[3][1] * 1) + 
			(transformMatrix[3][2] * 1) +
			(transformMatrix[3][3] * 1),8);	
			//System.out.println("Setup Direction " + octopos + "   " + direction); 
		}
		//dumpPoints("RotatedPoints: ", rotatePoints);

	
		// PIVOT POINT
		// Set the Pivot Point at the base of the tube, translate to it	
		if (pivotPoint == -1) 
		{
			// These are called from the generateDome routines and need
			// to be set up here
			//System.out.println("ApplyRotation()  No Pivot - no moveback ");
			
			// Move into th array for rotation application
			for (int point=0; point<numPoints; point++)
	    	{		
	    		nextPoints[point][0] = rotatePoints[point][0];
	    		nextPoints[point][1] = rotatePoints[point][1];
	    		nextPoints[point][2] = rotatePoints[point][2];
	    	}

		}
		else
		{
			//System.out.println("ApplyRotation()  Set up multipoints: ");

			if ((numPoints == 1) && (pivotPoint == 0))
			{		
				translateArray[0] = currentPoints[pivotPoint][0]; 
				translateArray[1] = 0;
				translateArray[2] = currentPoints[pivotPoint][2];
				//System.out.println("Adjust Pivot Point000 " + translateArray[0]  + "   " + translateArray[1] + "  "  +  translateArray[2] );
			}	
			else if ((numPoints == 4) && (pivotPoint == 0 || pivotPoint == 3))
			{		
				translateArray[0] = currentPoints[pivotPoint][0]; 
				translateArray[1] = currentPoints[pivotPoint][1];
				translateArray[2] = currentPoints[pivotPoint][2];    				
			}			
			else if (pivotPoint == 3 && numPoints == 4)
			{		
				translateArray[0] = currentPoints[pivotPoint][0]; 
				translateArray[1] = currentPoints[pivotPoint][1];
				translateArray[2] = currentPoints[pivotPoint][2];    				
			}		
			else if (pivotPoint == 3 || pivotPoint == 7 || pivotPoint == 1)
			{		
				translateArray[0] = currentPoints[pivotPoint][0]; 
				translateArray[1] = (currentPoints[pivotPoint][1]) - 0.1;
				translateArray[2] = currentPoints[pivotPoint][2];     		
				}
			else if (pivotPoint == 5 || pivotPoint == 6) {
				double circumference = Math.abs(currentPoints[pivotPoint][0] - currentPoints[pivotPoint][0]);  
			    	  
				translateArray[0] = currentPoints[pivotPoint][0]; 
				translateArray[1] = currentPoints[pivotPoint][1]; 
				translateArray[2] = currentPoints[pivotPoint][2] + circumference;    				
			}
			else if (rotateVector[2] == 1.0)
			{
				translateArray[0] = currentPoints[pivotPoint][0]; 
				translateArray[1] = (currentPoints[pivotPoint][1]);
				translateArray[2] = currentPoints[pivotPoint][2];    				
			}	
			
			
			//  Pivot Point6 must be  at 0,0,circumference 
			//System.out.println("Reverse Pivot Point: " + pivotPoint);
			//System.out.println("Rev Pivot Position: " + (currentPoints[pivotPoint][0])  + "   " + (currentPoints[pivotPoint][1]) + "  "  +  (currentPoints[pivotPoint][2]) );
			//System.out.println("Rev Pivot Adjusted: " + translateArray[0]  + "   " + translateArray[1] + "  "  +  translateArray[2] );
	
			
			nextPoints = applyTranslation(rotatePoints, translateArray);
			//dumpPoints("FinalPoints: ", nextPoints);
		}
  		
  		return nextPoints;
		}


	
	/***************************************************************************************
	 * 
	 * APPLY ROTATION
	 * 
	 * Applies a rotation of theta degrees to the set of current points 
	 * to produce and return a set of new points
	 * 
	 ***************************************************************************************/
	
	public static double[][] applyRotationOld(double[][] currentPoints, int pivotPoint, double thetaAngle, double[] rotateVector)
	{	
	
		// Used to translate the points to the origin so that
		// the Euler Rotation algorithm can be applied
		int numPoints = currentPoints.length;
		double theta = Math.toRadians(thetaAngle);
		System.out.println("ApplyRotation()  points: " + numPoints  +  "  angle: " +  thetaAngle);

	
		// Set up a place to store the local points
		double[][] localPoints = new double[numPoints][3];	
		
		// The points that result from the rotation
		double[][] rotatePoints = new double[numPoints][3];	;

		// Set up the points that will result from the translation
		double[][] nextPoints = new double[numPoints][3];	
		
		System.out.println("ApplyRotation()  Set up points: ");

		
		// Base Transformation Matrix
      	// Translate based on the vector
		double[][] transformMatrix = { 
 				 {1, 0, 0, 0},
 				 {0, 1, 0, 0},
 				 {0, 0, 1, 0},
 				 {0, 0, 0, 1}
   		};		
    			

		// PIVOT POINT
		// Set the Pivot Point at the base of the tube, translate to it	
		// It must lie just above the line of rotation an not on the line of rotation.
		if (pivotPoint == -1) 
		{
			// These are called from the generateDome routines and need
			// to be set up here
			System.out.println("ApplyRotation() with NoPivot: ");

			// Move into th array for rotation application
			for (int point=0; point<numPoints; point++)
	    	{		
	    		localPoints[point][0] = currentPoints[point][0];
	    		localPoints[point][1] = currentPoints[point][1];
	    		localPoints[point][2] = currentPoints[point][2];
	    	}
		}
		else 
		{
			System.out.println("ApplyRotation() with many points pivot: " + pivotPoint);
			
			if (pivotPoint == 0)
			{		
				transformMatrix[0][3] = -currentPoints[pivotPoint][0]; 
				transformMatrix[1][3] = -currentPoints[pivotPoint][1] + 0.01;
				transformMatrix[2][3] = -currentPoints[pivotPoint][2];    				
			}
			else if (pivotPoint == 3 || pivotPoint == 7 || pivotPoint == 1)
			{		
				transformMatrix[0][3] = -currentPoints[pivotPoint][0]; 
				transformMatrix[1][3] = -currentPoints[pivotPoint][1] + 0.01;
				transformMatrix[2][3] = -currentPoints[pivotPoint][2];    				
			}
			else if (pivotPoint == 5 || pivotPoint == 6) 
			{
				double circumference = Math.abs(currentPoints[pivotPoint][0] - currentPoints[pivotPoint][0]);  
				transformMatrix[0][3] = -currentPoints[pivotPoint][0]; 
				transformMatrix[1][3] = -currentPoints[pivotPoint][1];
				transformMatrix[2][3] = -currentPoints[pivotPoint][2] - circumference;    				
			}
			else if (rotateVector[2] == 1.0)
			{
				transformMatrix[0][3] = -currentPoints[pivotPoint][0]; 
				transformMatrix[1][3] = -(currentPoints[pivotPoint][1]) - 1.0;
				transformMatrix[2][3] = -currentPoints[pivotPoint][2];    				
			}		
			System.out.println("ApplyRotation()  Set up DEFAULT points: ");

			
			//  Pivot Point6 must be  at 0,0,circumference 
			System.out.println("Pivot Point: " + pivotPoint);
			System.out.println("Translate Column X, Y,Z : " + (-currentPoints[pivotPoint][0])  + "   " + (-currentPoints[pivotPoint][1]) + "  "  +  (-currentPoints[pivotPoint][2]) );
			System.out.println("Adj Translate Column X, Y,Z : " + transformMatrix[0][3]  + "   " + transformMatrix[1][3] + "  "  +  transformMatrix[2][3] );
			
			
			// LOCAL COORD MAPPING 
			// Apply the Transformation to all points, this is to move to Pivot Point
			// Everything shifts to zero,as that is where the rotation occurs, we are rotating around the origi
		   	//System.out.println("currentPoints: " + xBD  + "   " + yBD + "  "  +  zBD );
	    
	
			
			// LOCAL COORD MAPPING 
			// Apply the Transformation to all points, this is to move to Pivot Point
			// Everything shifts to zero,as that is where the rotation occurs, we are rotating around the origin
			for (int point=0; point<numPoints; point++)
	    	{		
	    		// set up X
	    		localPoints[point][0] = 
	    			MathUtils.round((transformMatrix[0][0] * currentPoints[point][0]) + 
	    			(transformMatrix[0][1] * currentPoints[point][1]) + 
	    			(transformMatrix[0][2] * currentPoints[point][2]) +
	    			(transformMatrix[0][3] * 1), 8);
	    			
	    		//set up Y
	    		localPoints[point][1] = 
	    			MathUtils.round((transformMatrix[1][0] * currentPoints[point][0]) + 
					(transformMatrix[1][1] * currentPoints[point][1]) + 
					(transformMatrix[1][2] * currentPoints[point][2]) +
					(transformMatrix[1][3] * 1), 8);
	      			
	    		// set up Z
	    		localPoints[point][2] = 
	    			MathUtils.round((transformMatrix[2][0] * currentPoints[point][0]) + 
					(transformMatrix[2][1] * currentPoints[point][1]) + 
					(transformMatrix[2][2] * currentPoints[point][2]) +
					(transformMatrix[2][3] * 1), 8);
	    			
	    		// set up Direction
	    		double direction = 
	    			MathUtils.round((transformMatrix[3][0] * 1) + 
					(transformMatrix[3][1] * 1) + 
					(transformMatrix[3][2] * 1) +
					(transformMatrix[3][3] * 1), 8);	
	    		
		   	//	System.out.println("LocalPoints for: " + point + "       " + xBD  + "   " + yBD + "  "  +  zBD );
	    	}
		}		

		
		
		// ROTATION
    	// Rotation matrix for rotations about the line through point (a, b, c)
    	// with a direction vector [ u, v, w ] by the angle theta. 
    	// where u*u + v*v + w*w = 1
    			
    	// x-coordinate of a point on the line of rotation.
    	double a = rotateVector[0];
    	// y-coordinate of a point on the line of rotation
    	double b = rotateVector[1];
    	// z-coordinate of a point on the line of rotation
    	double c = rotateVector[2];

    	// uUn x-coordinate of the line's direction vector (unnormalized)
    	double uUn = rotateVector[0];
    	// vUn y-coordinate of the line's direction vector (unnormalized)
    	double vUn = rotateVector[1];
    	// wUn z-coordinate of the line's direction vector (unnormalized)
    	double wUn = rotateVector[2];
    		
    	
    	// Normalize the direction vector
    	double l = 1.0;
    	double u = uUn/l;
    	double v = vUn/l;
    	double w = wUn/l;

    	// Set some intermediate values.
    	double u2 = u*u;
    	double v2 = v*v;
    	double w2 = w*w;
   
    	// Set up some variables
    	double cosT = MathUtils.round(Math.cos(theta), 8);
    	double oneMinusCosT = MathUtils.round(1-cosT, 8);
    	double sinT = MathUtils.round(Math.sin(theta), 8);
     	//	System.out.println("Cos : " + cosT);
    	//	System.out.println("1-Cos : " + oneMinusCosT);
    	//	System.out.println("SinT : " + sinT);  
          
    	// Build the matrix entries element by element.
    	transformMatrix[0][0] = MathUtils.round((u2 + (v2 + w2) * cosT), 8);
    	transformMatrix[0][1] = MathUtils.round((u*v * oneMinusCosT - w*sinT), 8);
    	transformMatrix[0][2] = MathUtils.round((u*w * oneMinusCosT + v*sinT), 8);
		transformMatrix[0][3] = MathUtils.round((a*(v2 + w2) - u*(b*v + c*w))*oneMinusCosT
				+ (b*w / -c*v)*sinT, 8);
		
		Double dd = new Double(transformMatrix[0][3]);
		if (dd.isNaN())
		{
			//System.out.println("Reset NAN!");
			transformMatrix[0][3] = 0;
		}
    
    	
		// 	System.out.println("Transform Matrix 0 is setup: " + 
		// 	transformMatrix[0][0] + "  " +
		//  	transformMatrix[0][1] + "  " +
		// 	transformMatrix[0][2] + "  " +
		//	transformMatrix[0][3]);
    	    	
    	transformMatrix[1][0] = MathUtils.round((u*v * oneMinusCosT + w*sinT), 8);
    	transformMatrix[1][1] = MathUtils.round((v2 + (u2 + w2) * cosT), 8);
    	transformMatrix[1][2] = MathUtils.round((v*w * oneMinusCosT - u*sinT), 8);
    	transformMatrix[1][3] = MathUtils.round(((b*(u2 + w2) - v*(a*u + c*w))*oneMinusCosT
    	+ (c*u - a*w)*sinT), 8);
    	


    	transformMatrix[2][0] = MathUtils.round((u*w * oneMinusCosT - v*sinT), 8);
    	transformMatrix[2][1] = MathUtils.round((v*w * oneMinusCosT + u*sinT), 8);
    	transformMatrix[2][2] = MathUtils.round((w2 + (u2 + v2) * cosT), 8);
    	transformMatrix[2][3] = MathUtils.round(((c*(u2 + v2) - w*(a*u + b*v))*oneMinusCosT
    	+ (a*v - b*u)*sinT), 8);

          
    	
        
		for (int octopos=0; octopos<numPoints; octopos++)
		{		
			// set up X
			rotatePoints[octopos][0] = 
			MathUtils.round(
				(transformMatrix[0][0] * localPoints[octopos][0]) + 
				(transformMatrix[0][1] * localPoints[octopos][1]) + 
				(transformMatrix[0][2] * localPoints[octopos][2]) +
				(transformMatrix[0][3] * 1), 8);
			
		 System.out.println("Setup X " + octopos + "   " + rotatePoints[octopos][0]);  
	    	
		    
				
			//set up Y
			rotatePoints[octopos][1] = 
			MathUtils.round(
				(transformMatrix[1][0] * localPoints[octopos][0]) + 
				(transformMatrix[1][1] * localPoints[octopos][1]) + 
				(transformMatrix[1][2] * localPoints[octopos][2]) +
				(transformMatrix[1][3] * 1), 8);
			System.out.println("Setup Y " + octopos + "   " + rotatePoints[octopos][1]);  
				 
		    
			
			// set up Z
			rotatePoints[octopos][2] = 
			MathUtils.round((transformMatrix[2][0] * localPoints[octopos][0]) + 
			(transformMatrix[2][1] * localPoints[octopos][1]) + 
			(transformMatrix[2][2] * localPoints[octopos][2]) +
			(transformMatrix[2][3] * 1), 8);
			System.out.println("Setup Z " + octopos + "   " + rotatePoints[octopos][2]); 
		  	
			
			// 	set up Direction
			double direction = 
			MathUtils.round((transformMatrix[3][0] * 1) + 
			(transformMatrix[3][1] * 1) + 
			(transformMatrix[3][2] * 1) +
			(transformMatrix[3][3] * 1),8);	
			System.out.println("Setup Direction " + octopos + "   " + direction); 
		}
		
		

		// WORLD COORD MAPPING
		// We need to translate back to World Coordinates
		// Reset Base Translation Matrix
		transformMatrix[0][0] = 1;
		transformMatrix[0][1] = 0;
		transformMatrix[0][2] = 0;
		transformMatrix[0][3] = 0;
		
  		transformMatrix[1][0] = 0;
		transformMatrix[1][1] = 1;
		transformMatrix[1][2] = 0;
		transformMatrix[1][3] = 0;
		
  		transformMatrix[2][0] = 0;
		transformMatrix[2][1] = 0;
		transformMatrix[2][2] = 1;
		transformMatrix[2][3] = 0;

  		transformMatrix[3][0] = 0;
		transformMatrix[3][1] = 0;
		transformMatrix[3][2] = 0;
		transformMatrix[3][3] = 1;

	
		// PIVOT POINT
		// Set the Pivot Point at the base of the tube, translate to it	
		if (pivotPoint == -1) 
		{
			// These are called from the generateDome routines and need
			// to be set up here
			System.out.println("ApplyRotation()  No Pivot - no moveback ");
			
			// Move into th array for rotation application
			for (int point=0; point<numPoints; point++)
	    	{		
	    		nextPoints[point][0] = rotatePoints[point][0];
	    		nextPoints[point][1] = rotatePoints[point][1];
	    		nextPoints[point][2] = rotatePoints[point][2];
	    	}

		}
		else
		{
			System.out.println("ApplyRotation()  Set up multipoints: ");

			if (pivotPoint == 0)
			{		
				transformMatrix[0][3] = -currentPoints[pivotPoint][0]; 
				transformMatrix[1][3] = -currentPoints[pivotPoint][1] + 0.01;
				transformMatrix[2][3] = -currentPoints[pivotPoint][2];    				
			}			
			else if (pivotPoint == 3 || pivotPoint == 7 || pivotPoint == 1)
			{		
				transformMatrix[0][3] = currentPoints[pivotPoint][0]; 
				transformMatrix[1][3] = (currentPoints[pivotPoint][1]) - 0.1;
				transformMatrix[2][3] = currentPoints[pivotPoint][2];     		
				}
			else if (pivotPoint == 5 || pivotPoint == 6) {
				double circumference = Math.abs(currentPoints[pivotPoint][0] - currentPoints[pivotPoint][0]);  
			    	  
				transformMatrix[0][3] = currentPoints[pivotPoint][0]; 
				transformMatrix[1][3] = currentPoints[pivotPoint][1]; 
				transformMatrix[2][3] = currentPoints[pivotPoint][2] + circumference;    				
			}
			else if (rotateVector[2] == 1.0)
			{
				transformMatrix[0][3] = -currentPoints[pivotPoint][0]; 
				transformMatrix[1][3] = -(currentPoints[pivotPoint][1]);
				transformMatrix[2][3] = -currentPoints[pivotPoint][2];    				
			}	
			
			System.out.println("ApplyRotation()  Set up multi nextpoints: ");
			// Apply the Translation to all points
			for (int octopos=0; octopos<numPoints; octopos++)
			{		
					// set up X
					nextPoints[octopos][0] = 
						MathUtils.round((transformMatrix[0][0] * rotatePoints[octopos][0]) + 
						(transformMatrix[0][1] * rotatePoints[octopos][1]) + 
						(transformMatrix[0][2] * rotatePoints[octopos][2]) +
						(transformMatrix[0][3] * 1), 8);
									
					//set up Y
					nextPoints[octopos][1] = 
						MathUtils.round((transformMatrix[1][0] * rotatePoints[octopos][0]) + 
						(transformMatrix[1][1] * rotatePoints[octopos][1]) + 
						(transformMatrix[1][2] * rotatePoints[octopos][2]) +
						(transformMatrix[1][3] * 1), 8);
				
				
					// set up Z
					nextPoints[octopos][2] = 
						MathUtils.round((transformMatrix[2][0] * rotatePoints[octopos][0]) + 
						(transformMatrix[2][1] * rotatePoints[octopos][1]) + 
						(transformMatrix[2][2] * rotatePoints[octopos][2]) +
						(transformMatrix[2][3] * 1), 8);
				
			
					// 	set up Direction
					double direction = 
					MathUtils.round(	(transformMatrix[3][0] * 1) + 
						(transformMatrix[3][1] * 1) + 
						(transformMatrix[3][2] * 1) +
						(transformMatrix[3][3] * 1), 8);	
			}

		}
  		
  		
  		return nextPoints;
		}


	/***************************************************************************************
	 * ROTATE OCTOGON
	 * 
	 * Applies a rotation to an Octogon.   We need to fix the pivot point for the length
	 * of the rotation.  We can do this like before by passing this value from the 
	 * instruction set.  
	 * 
	 ***************************************************************************************/
	
	public static double[][] rotateOctogon(double[][] currentPoints, double theta, double[] rotateVector,  BioMightOrientation orientation, int pivotPoint)
	{		
		int numPoints = currentPoints.length;

		double[][] nextPoints = new double[numPoints][3];				
		double[][] localPoints = new double[numPoints][3];

		double centerTranslate[] = getCenterPoint(currentPoints);	
		//double diameter = getOctoDiam(currentPoints);
		double revCenterTranslate[] = {0, 0, 0};
		//System.out.println("RotateOcto - CenterPoint: " +  centerTranslate[0] + " "  +  centerTranslate[1] + " "  +  centerTranslate[2] );	
		
		// In order to displace we need to get the furthest point 
		
		//******************************************
		// X-ROTATION
		//******************************************
		if (rotateVector[0] == 1.0)
		{		
			//System.out.println("Rotating around X by: " + theta);	

			if (pivotPoint == 0 || pivotPoint == 2) {
				//System.out.println("Rotating Forward: "  + theta);  

				// We will place the hinge in the SE quadrant  The Top of the
				// Octogon will align just under the Y<=0 and X=>0 and Z>=0
		
				centerTranslate[0] = -(MathUtils.round(currentPoints[pivotPoint][0] + Constants.OFFSET, 8));
				centerTranslate[1] = -(MathUtils.round(currentPoints[pivotPoint][1] + Constants.OFFSET, 8));
				centerTranslate[2] = -(MathUtils.round(currentPoints[pivotPoint][2] + Constants.OFFSET, 8));
				revCenterTranslate[0] = -centerTranslate[0];
				revCenterTranslate[1] = -centerTranslate[1];
				revCenterTranslate[2] = -centerTranslate[2];
			
				//System.out.println("FORWARD X-Displaced CenterPoint: " +  centerTranslate[0] + " "  +  centerTranslate[1] + " "  +  centerTranslate[2] );	
			}
			else if (pivotPoint == 4 || pivotPoint == 6) {
				//System.out.println("Rotating Backward: "  + theta);  
				centerTranslate[0] = -(MathUtils.round(currentPoints[pivotPoint][0] - Constants.OFFSET, 8));
				centerTranslate[1] = -(MathUtils.round(currentPoints[pivotPoint][1] - Constants.OFFSET, 8));
				centerTranslate[2] = -(MathUtils.round(currentPoints[pivotPoint][2] - Constants.OFFSET, 8));
				revCenterTranslate[0] = -centerTranslate[0];
				revCenterTranslate[1] = -centerTranslate[1];
				revCenterTranslate[2] = -centerTranslate[2];
			
				//System.out.println("BACK X-Displaced CenterPoint: " +  centerTranslate[0] + " "  +  centerTranslate[1] + " "  +  centerTranslate[2] );	
			}
			
			
			//dumpPoints("CurrentPoints", currentPoints);
	 		localPoints = applyTranslation(currentPoints, centerTranslate);	
	 		//dumpPoints("Local Points", localPoints);
			double[][] rotatedPoints = rotateX(localPoints, theta);
			//dumpPoints("X-Rotated Points", rotatedPoints);
			nextPoints = applyTranslation(rotatedPoints, revCenterTranslate);	
			//dumpPoints("World Points", nextPoints);	
		}
		//*****************************
		// Y-ROTATION
		//*****************************
		else if (rotateVector[1] == 1.0) {
			//System.out.println("Rotating around Y: " + theta);

			
			if (pivotPoint == 0 || pivotPoint == 2) {
				//System.out.println("Rotating Rightward: "  + theta);  
	
					// We will place the hinge in the SE quadrant  The Top of the
					// Octogon will align just under the Y<=0 and X=>0 and Z>=0
			
					centerTranslate[0] = -(MathUtils.round(currentPoints[pivotPoint][0] + Constants.OFFSET, 8));
					centerTranslate[1] = -(MathUtils.round(currentPoints[pivotPoint][1] + Constants.OFFSET, 8));
					centerTranslate[2] = -(MathUtils.round(currentPoints[pivotPoint][2] + Constants.OFFSET, 8));
					revCenterTranslate[0] = -centerTranslate[0];
					revCenterTranslate[1] = -centerTranslate[1];
					revCenterTranslate[2] = -centerTranslate[2];
			
				//System.out.println("RIGHT Y-Displaced CenterPoint: " +  centerTranslate[0] + " "  +  centerTranslate[1] + " "  +  centerTranslate[2] );	
			}
			else if (pivotPoint == 4 || pivotPoint == 6) {
				//System.out.println("Rotating Leftward: "  + theta);  
				centerTranslate[0] = -(MathUtils.round(currentPoints[pivotPoint][0] - Constants.OFFSET, 8));
				centerTranslate[1] = -(MathUtils.round(currentPoints[pivotPoint][1] - Constants.OFFSET, 8));
				centerTranslate[2] = -(MathUtils.round(currentPoints[pivotPoint][2] - Constants.OFFSET, 8));
				revCenterTranslate[0] = -centerTranslate[0];
				revCenterTranslate[1] = -centerTranslate[1];
				revCenterTranslate[2] = -centerTranslate[2];
			
				//System.out.println("LEFT Y-Displaced CenterPoint: " +  centerTranslate[0] + " "  +  centerTranslate[1] + " "  +  centerTranslate[2] );	
			}
			
			
			//dumpPoints("CurrentPoints", currentPoints);
	 		localPoints = applyTranslation(currentPoints, centerTranslate);	
	 		//dumpPoints("Local Points", localPoints);
			double[][] rotatedPoints = rotateY(localPoints, theta);
			//dumpPoints("Y-Rotated Points", rotatedPoints);
			
			nextPoints = applyTranslation(rotatedPoints, revCenterTranslate);	
			//dumpPoints("World Points", nextPoints);

		}
		//*****************************
		// Z-ROTATION
		//*****************************
		else if (rotateVector[2] == 1.0)
		{
			//System.out.println("Rotating around Z: "  + theta);  
			
			// If we are rotating Clockwise (negative angle) then we are heading down
			// Z can stay where it is.  X needs to come to Y axis so that it hinges at X=0
			// Y 

			// PIVOT POINT
			// Set the Pivot Point at the base of the tube, translate to it	
			// It must lie just above the line of rotation an not on the line of rotation.
			
			if (pivotPoint == 2 || pivotPoint == 4) {
				//System.out.println("Rotating Skyward: "  + theta);  

				// We will place the hinge in the SE quadrant  The Top of the
				// Octogon will align just under the Y<=0 and X=>0 and Z>=0
		
				centerTranslate[0] = -(MathUtils.round(currentPoints[pivotPoint][0] + Constants.OFFSET, 8));
				centerTranslate[1] = -(MathUtils.round(currentPoints[pivotPoint][1] + Constants.OFFSET, 8));
				centerTranslate[2] = -(MathUtils.round(currentPoints[pivotPoint][2] + Constants.OFFSET, 8));
				revCenterTranslate[0] = -centerTranslate[0];
				revCenterTranslate[1] = -centerTranslate[1];
				revCenterTranslate[2] = -centerTranslate[2];
			
				//System.out.println("UP Z-Displaced CenterPoint: " +  centerTranslate[0] + " "  +  centerTranslate[1] + " "  +  centerTranslate[2] );	
			}
			else if (pivotPoint == 6 || pivotPoint == 0) {
				//System.out.println("Rotating Downward: "  + theta);  
				centerTranslate[0] = -(MathUtils.round(currentPoints[pivotPoint][0] - Constants.OFFSET, 8));
				centerTranslate[1] = -(MathUtils.round(currentPoints[pivotPoint][1] - Constants.OFFSET, 8));
				centerTranslate[2] = -(MathUtils.round(currentPoints[pivotPoint][2] - Constants.OFFSET, 8));
				revCenterTranslate[0] = -centerTranslate[0];
				revCenterTranslate[1] = -centerTranslate[1];
				revCenterTranslate[2] = -centerTranslate[2];
			
				//System.out.println("DOWN Z-Displaced CenterPoint: " +  centerTranslate[0] + " "  +  centerTranslate[1] + " "  +  centerTranslate[2] );	
			}
			
			
			//dumpPoints("CurrentPoints", currentPoints);
	 		localPoints = applyTranslation(currentPoints, centerTranslate);	
	 		//dumpPoints("Local Points", localPoints);
			double[][] rotatedPoints = rotateZ(localPoints, theta);
			//dumpPoints("Z-Rotated Points", rotatedPoints);
			nextPoints = applyTranslation(rotatedPoints, revCenterTranslate);	
			//dumpPoints("World Points", nextPoints);
		}	
		
	
  		return nextPoints;
		}

	
	
	/***************************************************************************************
	 *  CREATE RING UP BY NS
	 * 
	 * Creates a Hexagonal ring of points that rotated around the X-axis based on the 
	 * hinge point.  When the Ring is originally drawn its aligns on Y=0. Y and Z
	 * are modified to draw it.
	 * 
	 ***************************************************************************************/
	
	public static double[][] createRingUpByNS(double[] currentPoint, int hinge, double thetaAngle, double segmentLength)
	{	
		double thetaRadians = Math.toRadians(thetaAngle);
				
		// The points that result from the rotation
		// of the points around the origin
		double[][] rotatedPoints = { 
 				{0, 0, 0},
				{0, 0, 0},
				{0, 0, 0},
				{0, 0, 0},
				{0, 0, 0},
				{0, 0, 0},
				{0, 0, 0},
				{0, 0, 0}
    		};
		
		
		// Set up the points that will result from the translation
		double[][] nextPoints = { 
				{0, 0, 0},
				{0, 0, 0},
				{0, 0, 0},
				{0, 0, 0},
				{0, 0, 0},
				{0, 0, 0},
				{0, 0, 0},
				{0, 0, 0}
    		};
		
		// Base Transformation Matrix
      	// Translate based on the vector
		double[][] transformMatrix = { 
 				 {1, 0, 0, -currentPoint[0]},
 				 {0, 1, 0, -currentPoint[1]},
 				 {0, 0, 1, -currentPoint[2]},
 				 {0, 0, 0, 1}
   		};		

	   	// Set up some variables
    	double cosT = MathUtils.round(Math.cos(thetaAngle), 8);
    	double sinT = MathUtils.round(Math.sin(thetaAngle), 8);
    	
		double[][] rotateYMatrix = { 
				 {cosT,  0,   sinT},
				 {0,     1,      0},
				 {-sinT, 0,   cosT}
  		};

		
		// Create a set a points that are near the origin 
		// offset in the proper for rotation around Y
		double[][] basePoints = null;
		if (hinge == Constants.EAST)
		{
			// The Octogon is created along the
			double xDisplace = 0.0 + segmentLength;
			double[] startPos = {xDisplace, 0.0, 0.0};
			basePoints = octogonZPlane(startPos, segmentLength);
		}
		else if (hinge == Constants.WEST)
		{
			double xDisplace = 0.0 - (3*segmentLength);
			double[] startPos = {xDisplace, 0.0, 0.0};
			basePoints = octogonZPlane(startPos, segmentLength);		
		}
		int numPoints = basePoints.length;
		
		// Dump the Points
		//dumpPoints("BasePoints", basePoints);

	
        // DO ROTATION AROUND Y
      // 	System.out.println("Rotating Around Y-AXIS");         
		for (int octopos=0; octopos<numPoints; octopos++)
		{		
			// set up X
			rotatedPoints[octopos][0] = 
			(rotateYMatrix[0][0] * basePoints[octopos][0]) + 
			(rotateYMatrix[0][1] * basePoints[octopos][1]) + 
			(rotateYMatrix[0][2] * basePoints[octopos][2]);
						
			//set up Y
			rotatedPoints[octopos][1] = 
			(rotateYMatrix[1][0] * basePoints[octopos][0]) + 
			(rotateYMatrix[1][1] * basePoints[octopos][1]) + 
			(rotateYMatrix[1][2] * basePoints[octopos][2]);
			
			// set up Z
			rotatedPoints[octopos][2] = 
			(rotateYMatrix[2][0] * basePoints[octopos][0]) + 
			(rotateYMatrix[2][1] * basePoints[octopos][1]) + 
			(rotateYMatrix[2][2] * basePoints[octopos][2]);	
		}

		// Dump the Points
		//dumpPoints("RotatedPoints", rotatedPoints);
			
		
		// Move them to the specified point
		for (int octopos=0; octopos<numPoints; octopos++)
		{		
				// set up X
				nextPoints[octopos][0] = 
				(transformMatrix[0][0] * rotatedPoints[octopos][0]) + 
				(transformMatrix[0][1] * rotatedPoints[octopos][1]) + 
				(transformMatrix[0][2] * rotatedPoints[octopos][2]) +
				(transformMatrix[0][3] * 1);
								
				//set up Y
				nextPoints[octopos][1] = 
					(transformMatrix[1][0] * rotatedPoints[octopos][0]) + 
					(transformMatrix[1][1] * rotatedPoints[octopos][1]) + 
					(transformMatrix[1][2] * rotatedPoints[octopos][2]) +
					(transformMatrix[1][3] * 1);
			
				// set up Z
				nextPoints[octopos][2] = 
					(transformMatrix[2][0] * rotatedPoints[octopos][0]) + 
					(transformMatrix[2][1] * rotatedPoints[octopos][1]) + 
					(transformMatrix[2][2] * rotatedPoints[octopos][2]) +
					(transformMatrix[2][3] * 1);
			
		
				// 	set up Direction
				double direction = 
					(transformMatrix[3][0] * 1) + 
					(transformMatrix[3][1] * 1) + 
					(transformMatrix[3][2] * 1) +
					(transformMatrix[3][3] * 1);		 	 		 
		}  		
		// Dump the Points
		//dumpPoints("NextPoints", nextPoints);

  		return nextPoints;
	}
	
	
	/***************************************************************************************
	 *  CREATE RING FORWARD By EAST/WEST
	 * 
	 * Creates a Hexagonal ring of points that rotated around the Y-axis based on the 
	 * hinge point.  The hinge point will allow be to go east or west.
	 * 
	 ***************************************************************************************/
	
	public static double[][] createRingForwardByEW(double[] currentPoint, int hinge, double thetaAngle, double segmentLength)
	{	
		double thetaRadians = Math.toRadians(thetaAngle);
				
		// The points that result from the rotation
		// of the points around the origin
		double[][] rotatedPoints = { 
 				{0, 0, 0},
				{0, 0, 0},
				{0, 0, 0},
				{0, 0, 0},
				{0, 0, 0},
				{0, 0, 0},
				{0, 0, 0},
				{0, 0, 0}
    		};
		
		
		// Set up the points that will result from the translation
		double[][] nextPoints = { 
				{0, 0, 0},
				{0, 0, 0},
				{0, 0, 0},
				{0, 0, 0},
				{0, 0, 0},
				{0, 0, 0},
				{0, 0, 0},
				{0, 0, 0}
    		};
		
		// Base Transformation Matrix
      	// Translate based on the vector
		double[][] transformMatrix = { 
 				 {1, 0, 0, -currentPoint[0]},
 				 {0, 1, 0, -currentPoint[1]},
 				 {0, 0, 1, -currentPoint[2]},
 				 {0, 0, 0, 1}
   		};		

	   	// Set up some variables
    	double cosT = MathUtils.round(Math.cos(thetaAngle), 8);
    	double sinT = MathUtils.round(Math.sin(thetaAngle), 8);
    	
		double[][] rotateYMatrix = { 
				 {cosT,  0,   sinT},
				 {0,     1,      0},
				 {-sinT, 0,   cosT}
  		};

		
		// Create a set a points that are near the origin 
		// offset in the proper for rotation around Y
		double[][] basePoints = null;
		if (hinge == Constants.EAST)
		{
			// The Octogon is created along the
			double xDisplace = 0.0 + segmentLength;
			double[] startPos = {xDisplace, 0.0, 0.0};
			basePoints = octogonZPlane(startPos, segmentLength);
		}
		else if (hinge == Constants.WEST)
		{
			double xDisplace = 0.0 - (3*segmentLength);
			double[] startPos = {xDisplace, 0.0, 0.0};
			basePoints = octogonZPlane(startPos, segmentLength);		
		}
		int numPoints = basePoints.length;
		
		// Dump the Points
		//dumpPoints("BasePoints", basePoints);

	
        // DO ROTATION AROUND Y
       //	System.out.println("Rotating Around Y-AXIS");         
		for (int octopos=0; octopos<numPoints; octopos++)
		{		
			// set up X
			rotatedPoints[octopos][0] = 
			(rotateYMatrix[0][0] * basePoints[octopos][0]) + 
			(rotateYMatrix[0][1] * basePoints[octopos][1]) + 
			(rotateYMatrix[0][2] * basePoints[octopos][2]);
						
			//set up Y
			rotatedPoints[octopos][1] = 
			(rotateYMatrix[1][0] * basePoints[octopos][0]) + 
			(rotateYMatrix[1][1] * basePoints[octopos][1]) + 
			(rotateYMatrix[1][2] * basePoints[octopos][2]);
			
			// set up Z
			rotatedPoints[octopos][2] = 
			(rotateYMatrix[2][0] * basePoints[octopos][0]) + 
			(rotateYMatrix[2][1] * basePoints[octopos][1]) + 
			(rotateYMatrix[2][2] * basePoints[octopos][2]);	
		}

		// Dump the Points
		//dumpPoints("RotatedPoints", rotatedPoints);
			
		
		// Move them to the specified point
		for (int octopos=0; octopos<numPoints; octopos++)
		{		
				// set up X
				nextPoints[octopos][0] = 
				(transformMatrix[0][0] * rotatedPoints[octopos][0]) + 
				(transformMatrix[0][1] * rotatedPoints[octopos][1]) + 
				(transformMatrix[0][2] * rotatedPoints[octopos][2]) +
				(transformMatrix[0][3] * 1);
								
				//set up Y
				nextPoints[octopos][1] = 
					(transformMatrix[1][0] * rotatedPoints[octopos][0]) + 
					(transformMatrix[1][1] * rotatedPoints[octopos][1]) + 
					(transformMatrix[1][2] * rotatedPoints[octopos][2]) +
					(transformMatrix[1][3] * 1);
			
				// set up Z
				nextPoints[octopos][2] = 
					(transformMatrix[2][0] * rotatedPoints[octopos][0]) + 
					(transformMatrix[2][1] * rotatedPoints[octopos][1]) + 
					(transformMatrix[2][2] * rotatedPoints[octopos][2]) +
					(transformMatrix[2][3] * 1);
			
		
				// 	set up Direction
				double direction = 
					(transformMatrix[3][0] * 1) + 
					(transformMatrix[3][1] * 1) + 
					(transformMatrix[3][2] * 1) +
					(transformMatrix[3][3] * 1);		 	 		 
		}  		
		// Dump the Points
		//dumpPoints("NextPoints", nextPoints);

  		return nextPoints;
	}
	
	/***************************************************************************************
	 *  CREATE RING RIGHT BY North-South
	 * 
	 * Creates a Hexagonal ring of points that rotated around the Z-axis based on the 
	 * hinge point.  When the Ring is first drawn its points align on Y=0.  X and Z
	 * change to create the shape.
	 * 
	 ***************************************************************************************/
	
	public static double[][] createRingLeftRightByNS(double[] currentPoint, int ringType, int hinge, double thetaAngle, double segmentLength)
	{
	   	System.out.println("createRingRightByNS!");         
		
		double thetaRadians = Math.toRadians(thetaAngle);
				
		// The points that result from the rotation
		// of the points around the origin
		double[][] rotatedPoints = { 
 				{0, 0, 0},
				{0, 0, 0},
				{0, 0, 0},
				{0, 0, 0},
				{0, 0, 0},
				{0, 0, 0},
				{0, 0, 0},
				{0, 0, 0}
    		};
		
		
		// Set up the points that will result from the translation
		double[][] nextPoints = { 
				{0, 0, 0},
				{0, 0, 0},
				{0, 0, 0},
				{0, 0, 0},
				{0, 0, 0},
				{0, 0, 0},
				{0, 0, 0},
				{0, 0, 0}
    		};
		
		// Base Transformation Matrix
      	// Translate based on the vector
		double[][] transformMatrix = { 
 				 {1, 0, 0, currentPoint[0]},
 				 {0, 1, 0, currentPoint[1]},
 				 {0, 0, 1, currentPoint[2]},
 				 {0, 0, 0, 1}
   		};		
	
	   	// Set up some variables
    	double cosT = MathUtils.round(Math.cos(thetaAngle), 8);
    	double sinT = MathUtils.round(Math.sin(thetaAngle), 8);
    	
		double[][] rotateZMatrix = { 
				 {cosT,  -sinT,   0},
				 {sinT,  cosT,    0},
				 {0,     0,       1}
  		};

		
		// Create a set a points that are near the origin 
		// offset in the proper for rotation around Z
		double[][] basePoints = null;
		if (hinge == Constants.NORTH)
		{
			// If we are going North, we are placing hinge at top of tube
			// and then swinging up.   The OctogonXPlane creates an Octy
			// aligned on X-Plane.  Z starts at back and comes forward counter-clckwise
			// we need to shift tube forward to bring Z ahead of axis
			double[] startPos = {0.0, 0.0, segmentLength};
			if (ringType == Constants.OCTOGON_REGULAR){
				basePoints = octogonXPlane(startPos, segmentLength);
			   	System.out.println("Regular Octogon");         	
			}
			else if (ringType == Constants.OCTOGON_Z2){
				basePoints = octogonXPlaneZ2(startPos, segmentLength);
				System.out.println("Z2-Octogon");
			}
			else if (ringType == Constants.OCTOGON_Z4){
				basePoints = octogonXPlaneZ4(startPos, segmentLength);
				System.out.println("Z4-Octogon");
			}			
			else {
				basePoints = octogonXPlane(startPos, segmentLength);
				System.out.println("ERROR - not macthedRegular Octogon");
			}
		}
		else if (hinge == Constants.SOUTH)
		{
			// We want the hinge at the bottom
			double[] startPos = {0.0, (segmentLength*3), segmentLength};
			basePoints = octogonXPlane(startPos, segmentLength);		
		}
		else
		{
		   	System.out.println("ERROR - Hinge not Defined");         	
		}	
		int numPoints = basePoints.length;
		
		
		// Dump the Points
		//dumpPoints("BasePoints", basePoints);

	
        // DO ROTATION AROUND Z
       	System.out.println("Rotating Around Z-AXIS");         
		for (int octopos=0; octopos<numPoints; octopos++)
		{		
			// set up X
			rotatedPoints[octopos][0] = 
			(rotateZMatrix[0][0] * basePoints[octopos][0]) + 
			(rotateZMatrix[0][1] * basePoints[octopos][1]) + 
			(rotateZMatrix[0][2] * basePoints[octopos][2]);
						
			//set up Y
			rotatedPoints[octopos][1] = 
			(rotateZMatrix[1][0] * basePoints[octopos][0]) + 
			(rotateZMatrix[1][1] * basePoints[octopos][1]) + 
			(rotateZMatrix[1][2] * basePoints[octopos][2]);
			
			// set up Z
			rotatedPoints[octopos][2] = 
			(rotateZMatrix[2][0] * basePoints[octopos][0]) + 
			(rotateZMatrix[2][1] * basePoints[octopos][1]) + 
			(rotateZMatrix[2][2] * basePoints[octopos][2]);	
		}

		// Dump the Points
		//dumpPoints("RotatedPoints", rotatedPoints);
			
		
		// Move them to the specified point
		for (int octopos=0; octopos<numPoints; octopos++)
		{		
				// set up X
				nextPoints[octopos][0] = 
				(transformMatrix[0][0] * rotatedPoints[octopos][0]) + 
				(transformMatrix[0][1] * rotatedPoints[octopos][1]) + 
				(transformMatrix[0][2] * rotatedPoints[octopos][2]) +
				(transformMatrix[0][3] * 1);
								
				//set up Y
				nextPoints[octopos][1] = 
					(transformMatrix[1][0] * rotatedPoints[octopos][0]) + 
					(transformMatrix[1][1] * rotatedPoints[octopos][1]) + 
					(transformMatrix[1][2] * rotatedPoints[octopos][2]) +
					(transformMatrix[1][3] * 1);
			
				// set up Z
				nextPoints[octopos][2] = 
					(transformMatrix[2][0] * rotatedPoints[octopos][0]) + 
					(transformMatrix[2][1] * rotatedPoints[octopos][1]) + 
					(transformMatrix[2][2] * rotatedPoints[octopos][2]) +
					(transformMatrix[2][3] * 1);
			
		
				// 	set up Direction
				double direction = 
					(transformMatrix[3][0] * 1) + 
					(transformMatrix[3][1] * 1) + 
					(transformMatrix[3][2] * 1) +
					(transformMatrix[3][3] * 1);		 	 		 
		}  		
		// Dump the Points
		//dumpPoints("NextPoints", nextPoints);

  		return nextPoints;
	}
	
	
	
	/***************************************************************************************
	 *  ROTATE Y
	 * 
	 * Rotates Around the Y AXIS.  When we are rotating around the Y-ais, we are 
	 * hinging right and left
	 * 
	 ***************************************************************************************/
	
	public static double[][] rotateY(double[][] currentPoints, BioMightOrientation orientation, double thetaAngle, double[] rotateVector)
	{	
		
		int numPoints=currentPoints.length;

		double theta = Math.toRadians(thetaAngle);
		
		// Used to translate the points to the origin so that
		// the Euler Rotation algorithm can be applied		
		double[][] localPoints;
		if (numPoints == 1)
			localPoints = get1point();
		else if (numPoints == 4)
			localPoints = get4points();
		else if (numPoints == 5)
			localPoints = get5points();			
		else if (numPoints == 6)
			localPoints = get6points();
		else if (numPoints == 8)
			localPoints = get8points();
		else
			localPoints = get6points();
		
		// The points that result from the rotation
		// of the points around the origin
		double[][] rotatePoints;
		if (numPoints == 1)
			rotatePoints = get1point();
		else if (numPoints == 4)
			rotatePoints = get4points();
		else if (numPoints == 5)
			rotatePoints = get5points();			
		else if (numPoints == 6)
			rotatePoints = get6points();
		else if (numPoints == 8)
			rotatePoints = get8points();
		else
			rotatePoints = get6points();
		

		// The points that result from the rotation
		// of the points around the origin
		double[][] localRotatePoints = { 
 				{0, 0, 0},
				{0, 0, 0},
				{0, 0, 0},
				{0, 0, 0},
				{0, 0, 0},
				{0, 0, 0},
				{0, 0, 0},
				{0, 0, 0}
    		};

		
		// The points that result from the rotation
		// of the points around the origin
		double[][] localRevRotatePoints = { 
 				{0, 0, 0},
				{0, 0, 0},
				{0, 0, 0},
				{0, 0, 0},
				{0, 0, 0},
				{0, 0, 0},
				{0, 0, 0},
				{0, 0, 0}
    		};
		
		// Set up the points that will result from the translation
		double[][] nextPoints = { 
				{0, 0, 0},
				{0, 0, 0},
				{0, 0, 0},
				{0, 0, 0},
				{0, 0, 0},
				{0, 0, 0},
				{0, 0, 0},
				{0, 0, 0}
    		};
		
		// Base Transformation Matrix
      	// Translate based on the vector
		double[][] transformMatrix = { 
 				 {1, 0, 0, 0},
 				 {0, 1, 0, 0},
 				 {0, 0, 1, 0},
 				 {0, 0, 0, 1}
   		};		

	   	// Set up some variables
    	double cosT = MathUtils.round(Math.cos(theta), 8);
    	double sinT = MathUtils.round(Math.sin(theta), 8);
    	
		double[][] rotateYMatrix = { 
				 {cosT, 0, sinT},
				 {0, 1, 0},
				 {-sinT, 0, cosT}
  		};

		
	   	// Set up the Local Orientation Rotation Matrix
		double thetaLocal = Math.toRadians(orientation.getYAxis());
    	double cosTLocal = MathUtils.round(Math.cos(thetaLocal), 8);
    	double sinTLocal = MathUtils.round(Math.sin(thetaLocal), 8);
    	
		double[][] rotateYLocalMatrix = { 
				 {cosTLocal, 0, sinTLocal},
				 {0, 1, 0},
				 {-sinTLocal, 0, cosTLocal}
  		};
		
		// Set up the Local Orientation Reverse Matrix
    	double cosTRevLocal = Math.cos(-thetaLocal);
    	double sinTRevLocal = Math.sin(-thetaLocal);
		double[][] rotateYLocalRevMatrix = { 
				 {cosTRevLocal, 0, sinTRevLocal},
				 {0, 1, 0},
				 {-sinTRevLocal, 0, cosTRevLocal}
 		};
		
		// Before we do the rotation, we need to send the object back to the origin and
		// world space so that the rotation is always calculated the same.   
		// 1.) Move the object to the Pivot Point 
		// 2.) Orient
		// 3.) Apply new Rotation
		// 4.) Rotate Back
		// 5.) Move Back
		// Theta   plusOrminus decides the pivot point
		// The Octogon shape will go sideways at some point.
		if (orientation.getYAxis() >= 0.0 && orientation.getYAxis() < 90.0)
		{
			//System.out.println("Y Orientation is 0-90, We are facing from W to N  : " + orientation.getYAxis());
		}
		else if (orientation.getYAxis() >= 90.0 && orientation.getYAxis() < 180.0)
		{
			//System.out.println("Y Orientation is 90-180, We are facing North to E : " + orientation.getYAxis());			
		}
		
		
		int pivotPoint = 0;	
		BioMightPosition translatePosition = new BioMightPosition(0.0, 0.0, 0.0);;
		if (theta > 0) 
		{
			//System.out.println("Theta is > 0 - Moving CounterClockwise - Use Left Hinge: " + thetaAngle);
			
			// If we rotate a normal X axis around 0,0,0, it goes
			// negative after 180 as we flipped upside down.  
			if (orientation.getXAxis() >= 0.0 && orientation.getXAxis() <= 180.0)
			{
				// RIGHTSIDE UP
				// We are above the X-axis so we are rightside up.
				// We are moving Left
				//System.out.println("X Angle is 0-180, RightSide Up : " + numPoints);
				
				
				if (numPoints == 8) {
					pivotPoint = 3;
					double circumference = Math.abs(currentPoints[pivotPoint][3] - currentPoints[pivotPoint][2]);
					translatePosition = new BioMightPosition( -(currentPoints[pivotPoint][0] + circumference), -(currentPoints[pivotPoint][1] + 0.01), -currentPoints[pivotPoint][2]);
				}
				else if (numPoints == 6) {
					pivotPoint = 2;
					// This is the distance between points 2 and 3
					// As we are rightside up, this is base of the octogon or trough
					BioMightPosition point1 = new BioMightPosition(currentPoints[pivotPoint][0], currentPoints[pivotPoint][1], currentPoints[pivotPoint][2]); 
					BioMightPosition point2 = new BioMightPosition(currentPoints[pivotPoint+1][0], currentPoints[pivotPoint+1][1], currentPoints[pivotPoint+1][2]); 
					double circumference = Math.abs(distance(point1, point2));
					//System.out.println("Circumference: " + circumference);
				
					// We want to align it to the Y-axis as we are rotating about it.
					double pivotX = 0.0; 
					if (currentPoints[pivotPoint][0] > 0)
					{
						// We are to the right of the X-AXIS, so we will put the pivot
						// just right of X=0, so we are parallel to the Y-AXIS
						pivotX = -(currentPoints[pivotPoint][0] - (circumference + .01));
						//System.out.println("To The Right of Y-AXIS");
					}
					else if (currentPoints[pivotPoint][0] == 0)
					{
						//System.out.println("On the Y-AXIS");
						pivotX = -(currentPoints[pivotPoint][0] - (circumference + .01));
					}
					else if (currentPoints[pivotPoint][0] < 0)
					{
						// We are to the left of the X-AXIS, so we will put the pivot
						// just left of X=0, so we are parallel to the Y-AXIS
						pivotX = -(currentPoints[pivotPoint][0] + (circumference + .01));
						//System.out.println("To The Left of Y-AXIS");
					}
	
						
	
					double pivotY = -currentPoints[pivotPoint][1]; // + 0.01;
					double pivotZ = -currentPoints[pivotPoint][2]; // + 0.01;
					
					translatePosition = new BioMightPosition(pivotX, pivotY, pivotZ);
					//System.out.println("PivotPoint: " + pivotPoint + "  " + currentPoints[pivotPoint][0]  + "  " + currentPoints[pivotPoint][1] + "  "  +  currentPoints[pivotPoint][2] );
					//System.out.println("Translating: " + translatePosition.getXPos()  + "   " + translatePosition.getYPos() + "   "  +  translatePosition.getZPos() );
					//System.out.println("PivotPos :  " + (currentPoints[pivotPoint][0] + translatePosition.getXPos())  + 
					//		"   y:" + (currentPoints[pivotPoint][1] + translatePosition.getYPos()) + 
					//		"   z:"  + (currentPoints[pivotPoint][2] + translatePosition.getZPos()) );

				}

			}	
			else if (orientation.getXAxis() > 180.0 && orientation.getXAxis() < 360.0)
			{
				// UPSIDE DOWN
				// We are above the X-axis so we are upside down 
				//System.out.println("RightSide Up - Moving Right - Not Covered");
			}
				
			
		}
		else // (theta < 0)  
		{
			// We are moving clockwise when theta is < 0 
			System.out.println("Theta is < 0, so we are moving clockwise - Use right hinge "  + thetaAngle);
		
			// If we rotate a normal X axis around 0,0,0, it goes
			// negative after 180 as we flipped upside down.  
			if (orientation.getXAxis() >= 0.0 && orientation.getXAxis() <= 180.0)
			{
				// RIGHTSIDE UP
				// We are above the X-axis so we are rightside up.
				// We are moving Left
				//System.out.println("RightSide Up - Moving Right : " + numPoints);
				
				if (numPoints == 8) {
					pivotPoint = 4;
					double circumference = Math.abs(currentPoints[pivotPoint][3] - currentPoints[pivotPoint][2]);
					translatePosition = new BioMightPosition( -(currentPoints[pivotPoint][0] + circumference), -(currentPoints[pivotPoint][1] + 0.01), -currentPoints[pivotPoint][2]);
				}
				else if (numPoints == 6) {
					pivotPoint = 3;
					// This is the distance between points 2 and 3
					// As we are rightside up, this is base of the octogon or trough
					BioMightPosition point1 = new BioMightPosition(currentPoints[pivotPoint][0], currentPoints[pivotPoint][1], currentPoints[pivotPoint][2]); 
					BioMightPosition point2 = new BioMightPosition(currentPoints[pivotPoint-1][0], currentPoints[pivotPoint-1][1], currentPoints[pivotPoint-1][2]); 
					double circumference = Math.abs(distance(point1, point2));
					//System.out.println("Circumference: " + circumference);
									
					// We want to align it to the Y-axis or rotation
					double pivotX = 0.0;
					if (currentPoints[pivotPoint][0] > 0)
					{
						// We are to the right of the X-AXIS, so we will put the pivot
						// just right of X=0, so we are parallel to the Y-AXIS
						pivotX = -(currentPoints[pivotPoint][0] - (circumference + .01));
						//System.out.println("To The Right of Y-AXIS");
					}
					else if (currentPoints[pivotPoint][0] == 0)
					{
						//System.out.println("On the Y-AXIS");
						pivotX = -(currentPoints[pivotPoint][0] - (circumference + .01));
					}
					else if (currentPoints[pivotPoint][0] < 0)
					{
						// We are to the left of the X-AXIS, so we will put the pivot
						// just left of X=0, so we are parallel to the Y-AXIS
						pivotX = -(currentPoints[pivotPoint][0] + (circumference + .01));
						//System.out.println("To The Left of Y-AXIS");
					}
					double pivotY = -currentPoints[pivotPoint][1]; // - 0.01;
					double pivotZ = -currentPoints[pivotPoint][2]; // - 0.01;
					
					
					translatePosition = new BioMightPosition(pivotX, pivotY, pivotZ);

					//System.out.println("PivotPoint: " + pivotPoint + "  " + currentPoints[pivotPoint][0]  + "  " + currentPoints[pivotPoint][1] + "  "  +  currentPoints[pivotPoint][2] );
					//System.out.println("Translating: " + translatePosition.getXPos()  + "   " + translatePosition.getYPos() + "   "  +  translatePosition.getZPos() );
					//System.out.println("PivotPos :  " + (currentPoints[pivotPoint][0] + translatePosition.getXPos())  + 
					//		"   y:" + (currentPoints[pivotPoint][1] + translatePosition.getYPos()) + 
					//		"   z:"  + (currentPoints[pivotPoint][2] + translatePosition.getZPos()) );

				}
			}
		}
		
	
		//  Pivot Point must be  at 0, 0, +- circumference 
		//System.out.println("Pivot Point: " + pivotPoint);  
		//System.out.println("Translate Column X, Y,Z : " + translatePosition.getXPos()  + "    " + translatePosition.getYPos() + "  "  +  translatePosition.getZPos() );
		transformMatrix[0][3] = translatePosition.getXPos(); 
		transformMatrix[1][3] = translatePosition.getYPos();
		transformMatrix[2][3] = translatePosition.getZPos(); 

		// Dump the Points
		//dumpPoints("StartPoints", currentPoints);

		
		// LOCAL COORD MAPPING 
		// Apply the Transformation to all points, this is to move to Pivot Point
		// Everything shifts to zero,as that is where the rotation occurs, we are rotating around the origin
		for (int octopos=0; octopos<numPoints; octopos++)
    	{		
    		// set up X
    		localPoints[octopos][0] = 
    			(transformMatrix[0][0] * currentPoints[octopos][0]) + 
    			(transformMatrix[0][1] * currentPoints[octopos][1]) + 
    			(transformMatrix[0][2] * currentPoints[octopos][2]) +
    			(transformMatrix[0][3] * 1);
    			
    		//set up Y
    		localPoints[octopos][1] = 
    			(transformMatrix[1][0] * currentPoints[octopos][0]) + 
				(transformMatrix[1][1] * currentPoints[octopos][1]) + 
				(transformMatrix[1][2] * currentPoints[octopos][2]) +
				(transformMatrix[1][3] * 1);
      			
    		// set up Z
    		localPoints[octopos][2] = 
    			(transformMatrix[2][0] * currentPoints[octopos][0]) + 
				(transformMatrix[2][1] * currentPoints[octopos][1]) + 
				(transformMatrix[2][2] * currentPoints[octopos][2]) +
				(transformMatrix[2][3] * 1);
    			
    		// set up Direction
    		double direction = 
    			(transformMatrix[3][0] * 1) + 
				(transformMatrix[3][1] * 1) + 
				(transformMatrix[3][2] * 1) +
				(transformMatrix[3][3] * 1);	
    		
    		    		
    		BigDecimal xBD = new BigDecimal(localPoints[octopos][0]).setScale(4, BigDecimal.ROUND_CEILING);
			BigDecimal yBD = new BigDecimal(localPoints[octopos][1]).setScale(4, BigDecimal.ROUND_CEILING);
			BigDecimal zBD = new BigDecimal(localPoints[octopos][2]).setScale(4, BigDecimal.ROUND_CEILING);
	   		//System.out.println("LocalPoints: " + xBD  + "   " + yBD + "  "  +  zBD );
    	}

		
		// LOCAL ORIENTATION
		// Rotate the object back into the World XYZ axi
       	//System.out.println("Orientating to Local Space");         
		for (int octopos=0; octopos<numPoints; octopos++)
		{		
			// set up X
			localRotatePoints[octopos][0] = 
			(rotateYLocalMatrix[0][0] * localPoints[octopos][0]) + 
			(rotateYLocalMatrix[0][1] * localPoints[octopos][1]) + 
			(rotateYLocalMatrix[0][2] * localPoints[octopos][2]);
						
			//set up Y
			localRotatePoints[octopos][1] = 
			(rotateYLocalMatrix[1][0] * localPoints[octopos][0]) + 
			(rotateYLocalMatrix[1][1] * localPoints[octopos][1]) + 
			(rotateYLocalMatrix[1][2] * localPoints[octopos][2]);
			
			
			// set up Z
			localRotatePoints[octopos][2] = 
			(rotateYLocalMatrix[2][0] * localPoints[octopos][0]) + 
			(rotateYLocalMatrix[2][1] * localPoints[octopos][1]) + 
			(rotateYLocalMatrix[2][2] * localPoints[octopos][2]);
	

	   		//System.out.println("RotatePoints: " + octopos + "  " + rotatePoints[octopos][0] +
	   		 //"   "  + rotatePoints[octopos][1]  + "   "+ rotatePoints[octopos][2]);
	   
	 		BigDecimal xBD = new BigDecimal(localRotatePoints[octopos][0]).setScale(4, BigDecimal.ROUND_CEILING);
			BigDecimal yBD = new BigDecimal(localRotatePoints[octopos][1]).setScale(4, BigDecimal.ROUND_CEILING);
			BigDecimal zBD = new BigDecimal(localRotatePoints[octopos][2]).setScale(4, BigDecimal.ROUND_CEILING);
	   		//System.out.println("LocalRotated: " + xBD  + "   " + yBD + "  "  +  zBD );
  		}
	
        // REAL WORLD ROTATION
       	//System.out.println("Orientating to World Rotation");         
		for (int octopos=0; octopos<numPoints; octopos++)
		{		
			// set up X
			localRevRotatePoints[octopos][0] = 
			(rotateYLocalRevMatrix[0][0] * localRotatePoints[octopos][0]) + 
			(rotateYLocalRevMatrix[0][1] * localRotatePoints[octopos][1]) + 
			(rotateYLocalRevMatrix[0][2] * localRotatePoints[octopos][2]);
						
			//set up Y
			localRevRotatePoints[octopos][1] = 
			(rotateYLocalRevMatrix[1][0] * localRotatePoints[octopos][0]) + 
			(rotateYLocalRevMatrix[1][1] * localRotatePoints[octopos][1]) + 
			(rotateYLocalRevMatrix[1][2] * localRotatePoints[octopos][2]);
			
			// set up Z
			localRevRotatePoints[octopos][2] = 
			(rotateYLocalRevMatrix[2][0] * localRotatePoints[octopos][0]) + 
			(rotateYLocalRevMatrix[2][1] * localRotatePoints[octopos][1]) + 
			(rotateYLocalRevMatrix[2][2] * localRotatePoints[octopos][2]);
	

	   		//System.out.println("RotatePoints: " + octopos + "  " + rotatePoints[octopos][0] +
	   		 //"   "  + rotatePoints[octopos][1]  + "   "+ rotatePoints[octopos][2]);
	   
	 		BigDecimal xBD = new BigDecimal(localRevRotatePoints[octopos][0]).setScale(4, BigDecimal.ROUND_CEILING);
			BigDecimal yBD = new BigDecimal(localRevRotatePoints[octopos][1]).setScale(4, BigDecimal.ROUND_CEILING);
			BigDecimal zBD = new BigDecimal(localRevRotatePoints[octopos][2]).setScale(4, BigDecimal.ROUND_CEILING);
	   		//System.out.println("Local Rev RotatedPoints: " + xBD  + "   " + yBD + "  "  +  zBD );
  		}
		

        // BACK TO LOCAL ROTATION - ORIENTATION
       	//System.out.println("Mapping Back to Local Orientation");         
		for (int octopos=0; octopos<numPoints; octopos++)
		{		
			// set up X
			rotatePoints[octopos][0] = 
			(rotateYMatrix[0][0] * localRevRotatePoints[octopos][0]) + 
			(rotateYMatrix[0][1] * localRevRotatePoints[octopos][1]) + 
			(rotateYMatrix[0][2] * localRevRotatePoints[octopos][2]);
						
			//set up Y
			rotatePoints[octopos][1] = 
			(rotateYMatrix[1][0] * localRevRotatePoints[octopos][0]) + 
			(rotateYMatrix[1][1] * localRevRotatePoints[octopos][1]) + 
			(rotateYMatrix[1][2] * localRevRotatePoints[octopos][2]);
			
			// set up Z
			rotatePoints[octopos][2] = 
			(rotateYMatrix[2][0] * localRevRotatePoints[octopos][0]) + 
			(rotateYMatrix[2][1] * localRevRotatePoints[octopos][1]) + 
			(rotateYMatrix[2][2] * localRevRotatePoints[octopos][2]);
	

	   		//System.out.println("RotatePoints: " + octopos + "  " + rotatePoints[octopos][0] +
	   		 //"   "  + rotatePoints[octopos][1]  + "   "+ rotatePoints[octopos][2]);
	   
	 		BigDecimal xBD = new BigDecimal(rotatePoints[octopos][0]).setScale(4, BigDecimal.ROUND_CEILING);
			BigDecimal yBD = new BigDecimal(rotatePoints[octopos][1]).setScale(4, BigDecimal.ROUND_CEILING);
			BigDecimal zBD = new BigDecimal(rotatePoints[octopos][2]).setScale(4, BigDecimal.ROUND_CEILING);
	   		//System.out.println("Final World RotatedPoints: " + xBD  + "   " + yBD + "  "  +  zBD );
  		}
		
		

		// WORLD COORD MAPPING
		// We need to translate back to World Coordinates
		// Reset Base Translation Matrix
		transformMatrix[0][0] = 1;
		transformMatrix[0][1] = 0;
		transformMatrix[0][2] = 0;
		transformMatrix[0][3] = 0;
		
  		transformMatrix[1][0] = 0;
		transformMatrix[1][1] = 1;
		transformMatrix[1][2] = 0;
		transformMatrix[1][3] = 0;
		
  		transformMatrix[2][0] = 0;
		transformMatrix[2][1] = 0;
		transformMatrix[2][2] = 1;
		transformMatrix[2][3] = 0;

  		transformMatrix[3][0] = 0;
		transformMatrix[3][1] = 0;
		transformMatrix[3][2] = 0;
		transformMatrix[3][3] = 1;

	
		// Move the Object to Back to where it was
		transformMatrix[0][3] = translatePosition.getXPos() * -1; 
		transformMatrix[1][3] = translatePosition.getYPos() * -1;
		transformMatrix[2][3] = translatePosition.getZPos() * -1;    				
			
		// Apply the Rotation to all points
		for (int octopos=0; octopos<numPoints; octopos++)
		{		
				// set up X
				nextPoints[octopos][0] = 
				(transformMatrix[0][0] * rotatePoints[octopos][0]) + 
				(transformMatrix[0][1] * rotatePoints[octopos][1]) + 
				(transformMatrix[0][2] * rotatePoints[octopos][2]) +
				(transformMatrix[0][3] * 1);
								
				//set up Y
				nextPoints[octopos][1] = 
					(transformMatrix[1][0] * rotatePoints[octopos][0]) + 
					(transformMatrix[1][1] * rotatePoints[octopos][1]) + 
					(transformMatrix[1][2] * rotatePoints[octopos][2]) +
					(transformMatrix[1][3] * 1);
			
				// set up Z
				nextPoints[octopos][2] = 
					(transformMatrix[2][0] * rotatePoints[octopos][0]) + 
					(transformMatrix[2][1] * rotatePoints[octopos][1]) + 
					(transformMatrix[2][2] * rotatePoints[octopos][2]) +
					(transformMatrix[2][3] * 1);
			
		
				// 	set up Direction
				double direction = 
					(transformMatrix[3][0] * 1) + 
					(transformMatrix[3][1] * 1) + 
					(transformMatrix[3][2] * 1) +
					(transformMatrix[3][3] * 1);	
	
				
		   		//System.out.println("NewPoints: " + octopos + "   " + nextPoints[octopos][0] );
		   		//System.out.println("NewPoints: " + nextPoints[octopos][1] );
		   		//System.out.println("NewPoints: " + nextPoints[octopos][2] );
		
		 		BigDecimal xBD = new BigDecimal(nextPoints[octopos][0]).setScale(4, BigDecimal.ROUND_CEILING);
				BigDecimal yBD = new BigDecimal(nextPoints[octopos][1]).setScale(4, BigDecimal.ROUND_CEILING);
				BigDecimal zBD = new BigDecimal(nextPoints[octopos][2]).setScale(4, BigDecimal.ROUND_CEILING);
		   		//System.out.println("NextPoints: " + xBD  + "   " + yBD + "  "  +  zBD );
	 	 		 
		}
  		
  		
  		return nextPoints;
	}
	
	
	/***************************************************************************************
	 *  ROTATE X
	 * 
	 * Rotates Around the X AXIS.  When we are rotating around the X-axis, we are 
	 * hinging right and left
	 * 
	 ***************************************************************************************/
	
	public static double[][] rotateX(double[][] currentPoints, double thetaAngle)
	{	
		
		int numPoints=currentPoints.length;
		double theta = Math.toRadians(thetaAngle);
			
		// The points that result from the rotation
		// of the points around the origin
		
		double[][] rotatePoints;
		if (numPoints == 1)
			rotatePoints = get1point();
		else if (numPoints == 4)
			rotatePoints = get4points();
		else if (numPoints == 5)
			rotatePoints = get5points();			
		else if (numPoints == 6)
			rotatePoints = get6points();
		else if (numPoints == 8)
			rotatePoints = get8points();
		else
			rotatePoints = get6points();	
		
	   	// Set up some variables
    	double cosT = MathUtils.round(Math.cos(theta), 8);
    	double sinT = MathUtils.round(Math.sin(theta), 8);
    	
		double[][] rotateXMatrix = { 
				 {1,      0,      0},
				 {0,   cosT,  -sinT},
				 {0,   sinT,   cosT}
  		};
	
		
       	//System.out.println("Performing RotateX");         
		for (int octopos=0; octopos<numPoints; octopos++)
		{		
			// set up X
			rotatePoints[octopos][0] = MathUtils.round(
			(rotateXMatrix[0][0] * currentPoints[octopos][0]) + 
			(rotateXMatrix[0][1] * currentPoints[octopos][1]) + 
			(rotateXMatrix[0][2] * currentPoints[octopos][2]), 8);
						
			//set up Y
			rotatePoints[octopos][1] = MathUtils.round( 
			(rotateXMatrix[1][0] * currentPoints[octopos][0]) + 
			(rotateXMatrix[1][1] * currentPoints[octopos][1]) + 
			(rotateXMatrix[1][2] * currentPoints[octopos][2]), 8);
			
			// set up Z
			rotatePoints[octopos][2] = MathUtils.round(
			(rotateXMatrix[2][0] * currentPoints[octopos][0]) + 
			(rotateXMatrix[2][1] * currentPoints[octopos][1]) + 
			(rotateXMatrix[2][2] * currentPoints[octopos][2]), 8);	
  		}
		
		
  		return rotatePoints;
	}
	
	/***************************************************************************************
	 *  ROTATE Y 
	 * 
	 * Rotates Around the Y AXIS.  When we are rotating around the Y-ais, we are 
	 * hinging right and left
	 * 
	 ***************************************************************************************/
	
	public static double[][] rotateY(double[][] currentPoints, double thetaAngle)
	{	
		
		int numPoints=currentPoints.length;
		double theta = Math.toRadians(thetaAngle);
		
		// The points that result from the rotation
		// of the points around the origin
		
		double[][] rotatePoints;
		if (numPoints == 1)
			rotatePoints = get1point();
		else if (numPoints == 4)
			rotatePoints = get4points();
		else if (numPoints == 5)
			rotatePoints = get5points();			
		else if (numPoints == 6)
			rotatePoints = get6points();
		else if (numPoints == 8)
			rotatePoints = get8points();
		else
			rotatePoints = get6points();
		
		
	   	// Set up some variables
    	double cosT = MathUtils.round(Math.cos(theta), 8);
    	double sinT = MathUtils.round(Math.sin(theta), 8);
    	
		double[][] rotateYMatrix = { 
				 {cosT,   0,   sinT},
				 {0,      1,      0},
				 {-sinT,  0,   cosT}
  		};
		
		
        // REAL WORLD ROTATION
       	//System.out.println("Performing RotateY");         
		for (int octopos=0; octopos<numPoints; octopos++)
		{		
			// set up X
			rotatePoints[octopos][0] = 
			(rotateYMatrix[0][0] * currentPoints[octopos][0]) + 
			(rotateYMatrix[0][1] * currentPoints[octopos][1]) + 
			(rotateYMatrix[0][2] * currentPoints[octopos][2]);
						
			//set up Y
			rotatePoints[octopos][1] = 
			(rotateYMatrix[1][0] * currentPoints[octopos][0]) + 
			(rotateYMatrix[1][1] * currentPoints[octopos][1]) + 
			(rotateYMatrix[1][2] * currentPoints[octopos][2]);
			
			// set up Z
			rotatePoints[octopos][2] = 
			(rotateYMatrix[2][0] * currentPoints[octopos][0]) + 
			(rotateYMatrix[2][1] * currentPoints[octopos][1]) + 
			(rotateYMatrix[2][2] * currentPoints[octopos][2]);
	

	   		//System.out.println("RotatePoints: " + octopos + "  " + rotatePoints[octopos][0] +
	   		 //"   "  + rotatePoints[octopos][1]  + "   "+ rotatePoints[octopos][2]);
	   
	 		BigDecimal xBD = new BigDecimal(rotatePoints[octopos][0]).setScale(4, BigDecimal.ROUND_CEILING);
			BigDecimal yBD = new BigDecimal(rotatePoints[octopos][1]).setScale(4, BigDecimal.ROUND_CEILING);
			BigDecimal zBD = new BigDecimal(rotatePoints[octopos][2]).setScale(4, BigDecimal.ROUND_CEILING);
	   		//System.out.println("RotatedPoints: " + xBD  + "   " + yBD + "  "  +  zBD );
  		}
		
		
  		return rotatePoints;
	}
	

	
	/***************************************************************************************
	 *  ROTATE Z
	 * 
	 * Rotates Around the Z AXIS.  When we are rotating around the Z-axis, we are 
	 * hinging up and down
	 * 
	 ***************************************************************************************/
	
	public static double[][] rotateZ(double[][] currentPoints, double thetaAngle)
	{	
		
		int numPoints=currentPoints.length;
		double theta = MathUtils.round(Math.toRadians(thetaAngle) , 6);
		
		// The points that result from the rotation
		// of the points around the origin
		
		double[][] rotatePoints;
		if (numPoints == 1)
			rotatePoints = get1point();
		else if (numPoints == 4)
			rotatePoints = get4points();
		else if (numPoints == 5)
			rotatePoints = get5points();			
		else if (numPoints == 6)
			rotatePoints = get6points();
		else if (numPoints == 8)
			rotatePoints = get8points();
		else
			rotatePoints = get6points();
		
		
	   	// Set up some variables
    	double cosT = MathUtils.round(Math.cos(theta), 8);
    	double sinT = MathUtils.round(Math.sin(theta), 8);
    	
		double[][] rotateZMatrix = { 
				 {cosT,   -sinT,   0},
				 {sinT,   cosT,    0},
				 {0,          0,    1}
  		};
	
        // Z-ROTATION
       	//System.out.println("Performing RotateZ");         
		for (int octopos=0; octopos<numPoints; octopos++)
		{		
			// set up X
			rotatePoints[octopos][0] = 
			MathUtils.round((rotateZMatrix[0][0] * currentPoints[octopos][0]) + 
			(rotateZMatrix[0][1] * currentPoints[octopos][1]) + 
			(rotateZMatrix[0][2] * currentPoints[octopos][2]), 8);
						
			//set up Y
			rotatePoints[octopos][1] = 
			MathUtils.round((rotateZMatrix[1][0] * currentPoints[octopos][0]) + 
			(rotateZMatrix[1][1] * currentPoints[octopos][1]) + 
			(rotateZMatrix[1][2] * currentPoints[octopos][2]), 8);
			
			// set up Z
			rotatePoints[octopos][2] = 
			MathUtils.round((rotateZMatrix[2][0] * currentPoints[octopos][0]) + 
			(rotateZMatrix[2][1] * currentPoints[octopos][1]) + 
			(rotateZMatrix[2][2] * currentPoints[octopos][2]), 8);
	

	   		//System.out.println("RotatePoints: " + octopos + "  " + rotatePoints[octopos][0] +
	   		 //"   "  + rotatePoints[octopos][1]  + "   "+ rotatePoints[octopos][2]);
	   
	 		//BigDecimal xBD = new BigDecimal(rotatePoints[octopos][0]).setScale(4, BigDecimal.ROUND_CEILING);
			//BigDecimal yBD = new BigDecimal(rotatePoints[octopos][1]).setScale(4, BigDecimal.ROUND_CEILING);
			//BigDecimal zBD = new BigDecimal(rotatePoints[octopos][2]).setScale(4, BigDecimal.ROUND_CEILING);
	   		//System.out.println("RotatedPoints: " + xBD  + "   " + yBD + "  "  +  zBD );
  		}
		
		
  		return rotatePoints;
	}
	

	
	
	public static void dumpPoints(String type, double[][] points) {
   		System.out.println("\nDumpPoints----------");
   	 
		for (int point=0; point<points.length; point++)
		{					
	   		System.out.println(type + " for " + point + ":  " + MathUtils.round(points[point][0], 8)  + "   " + MathUtils.round(points[point][1], 8) + "  "  +  MathUtils.round(points[point][2], 8) );
 
		}  
	}
	

	
	public static double[][] get1point()
	{
		double[][] rotatePoints = { 
				{0, 0, 0}
		};
		
		return rotatePoints;
	}

	
	public static double[][] get8points()
	{
		double[][] rotatePoints = { 
				{0, 0, 0},
				{0, 0, 0},
				{0, 0, 0},
				{0, 0, 0},
				{0, 0, 0},
				{0, 0, 0},
				{0, 0, 0},
				{0, 0, 0}
		};
		
		return rotatePoints;
	}
	
	
	public static double[][] get6points()
	{
		
		double[][] rotatePoints = { 
				{0, 0, 0},
				{0, 0, 0},
				{0, 0, 0},
				{0, 0, 0},
				{0, 0, 0},
				{0, 0, 0}
		};

		return rotatePoints;
	}
	
	
	public static double[][] get5points()
	{
		double[][] rotatePoints = { 
				{0, 0, 0},
				{0, 0, 0},
				{0, 0, 0},
				{0, 0, 0},
				{0, 0, 0}
		};
		
		return rotatePoints;
	}
	
	public static double[][] get4points()
	{
		double[][] rotatePoints = { 
				{0, 0, 0},
				{0, 0, 0},
				{0, 0, 0},
				{0, 0, 0}
		};
		
		return rotatePoints;
	}
	
}