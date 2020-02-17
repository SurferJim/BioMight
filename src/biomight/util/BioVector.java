package biomight.util;

/**************************************************************************
 * A Mathematical Vector is defined by magnitude and direction.   It can
 * be defined like a line segment,having a starting and ending point. 
 * 
 * It can also be defined by a startpoint and a direction, in 
 * relation to 0,0,0,W=1  
 * 
 * @author SurferJim
 *
 *************************************************************************/

public class BioVector {

	// Start Point
	double xStartPos = 0.0;
	double yStartPos = 0.0;
	double zStartPos = 0.0;

	// End Point
	double xEndPos = 0.0;
	double yEndPos = 0.0;
	double zEndPos = 0.0;
	
	// Angle of Declination/Inclination off the three major ais points
	double xTheta = 0.0;
	double yTheta = 0.0;
	double zTheta = 0.0;

	// Direction unit of circle
	double direction = 0.0;
	
	
	
	public BioVector(double xs,double ys,double zs, double xe,double ye,double ze)
	{
		// Define the start point for the vector 
		xStartPos = xs;
		yStartPos = ys;
		zStartPos = zs;
		
		// Define the end point for the vector
		xEndPos = xe;
		yEndPos = ye;
		zEndPos = ze;
	}
	
	public BioVector(double xs,double ys,double zs, double theta)
	{
		// Define the start point for the vector 
		xStartPos = xs;
		yStartPos = ys;
		zStartPos = zs;
		
		// Define direction for the vector
		xEndPos = theta;
	}
	
	
	public void setBioVector(double xs,double ys,double zs, double xe,double ye,double ze)
	{
		// Define the start point for the vector 
		xStartPos = xs;
		yStartPos = ys;
		zStartPos = zs;
		
		// Define the end point for the vector
		xEndPos = xe;
		yEndPos = ye;
		zEndPos = ze;
	}
	
	
	public BioVector getBioVector()
	{
		BioVector bioVector = 
			new BioVector(this.xStartPos,this.yStartPos,this.zStartPos, 
				this.xEndPos,this.yEndPos,this.zEndPos);
		return (bioVector);
	}


	public double getxStartPos() {
		return xStartPos;
	}


	public void setxStartPos(double xStartPos) {
		this.xStartPos = xStartPos;
	}


	public double getyStartPos() {
		return yStartPos;
	}


	public void setyStartPos(double yStartPos) {
		this.yStartPos = yStartPos;
	}


	public double getzStartPos() {
		return zStartPos;
	}


	public void setzStartPos(double zStartPos) {
		this.zStartPos = zStartPos;
	}


	public double getxEndPos() {
		return xEndPos;
	}


	public void setxEndPos(double xEndPos) {
		this.xEndPos = xEndPos;
	}


	public double getyEndPos() {
		return yEndPos;
	}


	public void setyEndPos(double yEndPos) {
		this.yEndPos = yEndPos;
	}


	public double getzEndPos() {
		return zEndPos;
	}


	public void setzEndPos(double zEndPos) {
		this.zEndPos = zEndPos;
	}

	public double getTheta() {
		return xTheta;
	}

	public void setTheta(double theta) {
		this.xTheta = theta;
	}

	public double getDirection() {
		return direction;
	}

	public void setDirection(double direction) {
		this.direction = direction;
	}	
	
	
	
	
	
	
}
