/*
 * Created on May 21, 2007
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.view;
import java.io.Serializable;
import java.math.BigDecimal;

/***************************************************************************
 * @author SurferJim
 *
 * Everything in BioMight can be constructed by attaching cubes.  This
 * object will wrap a bound box around a compoent and descirbe the
 * boundaries for where it can lie in the map    
 * 
 ***************************************************************************/

public class BioMightBoundBox implements Serializable {
	
	// The basic box is bound by 8 vertices, 
	private BioMightPositions bioMightPositions;
	
	// The point in 3D space that this Box is centered upon
	private BigDecimal xPos;
	private BigDecimal yPos;
	private BigDecimal zPos;
	
	
	// The Vector that the bo extends from in the given plane
	private BigDecimal xVector;
	private BigDecimal yVector;
	private BigDecimal zVector;

	// The Vectors Magnitude
	private BigDecimal xVectorMag;
	private BigDecimal yVectorMag;
	private BigDecimal zVectorMag;	

	// The Vectors Direction, a angle and a rotation vector
	// Angle of rotation
	double theta = -Math.toRadians(45.0);
	
	// What Vector are we rotating about
	double rotateVector[] = {0.0, 0.0 ,1.0};
	
	// The connectors that are associated with the Bounding Box
	BioMightConnectors 	bioMightConnectors;

	
	/******************************************************************************
	 * BOUNDBOX
	 * 
	 * @param xPos
	 * @param yPos
	 * @param zPos
	 * @param xVector
	 * @param yVector
	 * @param zVector
	 ******************************************************************************/
	public BioMightBoundBox(BigDecimal xPos, BigDecimal yPos, BigDecimal zPos, 
			BigDecimal xVectorMag, BigDecimal yVectorMag, BigDecimal zVectorMag,
			BigDecimal xVectorDir, BigDecimal yVectorDir, BigDecimal zVectorDir, double theta) 
	{
		this.xPos= xPos;
		this.yPos = yPos;
		this.zPos = zPos; 
		
		this.xVector = xVector;
		this.yVector =  yVector;
		this.zVector = zVector;

		// Set the magnitude of the vector
		this.xVectorMag = xVectorMag;
		this.yVectorMag =  yVectorMag;
		this.zVectorMag = zVectorMag;
		
		// set the rotation the vector
		setRotateVector(xVectorDir, yVectorDir, zVectorDir);
		
		// Set the angle of rotation
		this.theta = theta;
			
		BioMightConnectors bioMightConnectors = new BioMightConnectors();
	}
	
	
	/******************************************************************************
	 * BOUNDBOX
	 * 
	 * @param xPos
	 * @param yPos
	 * @param zPos
	 * @param xVector
	 * @param yVector
	 * @param zVector
	 ******************************************************************************/
	public BioMightBoundBox(BigDecimal xPos, BigDecimal yPos, BigDecimal zPos, 
			BigDecimal xVector, BigDecimal yVector, BigDecimal zVector) 
	{
		this.xPos= xPos;
		this.yPos = yPos;
		this.zPos = zPos; 
		this.xVector = xVector;
		this.yVector =  yVector;
		this.zVector = zVector;

		BioMightConnectors bioMightConnectors = new BioMightConnectors();
	}


	public BioMightBoundBox(String bioMightPoStr) 
	{
		this.xPos= new BigDecimal(0);
		this.yPos = new BigDecimal(0);
		this.zPos = new BigDecimal(0);
		this.xVector = new BigDecimal(1.0);
		this.yVector =  new BigDecimal(1.0);
		this.zVector = new BigDecimal(1.0);
		
		BioMightConnectors bioMightConnectors = new BioMightConnectors();
	
	}
	
	public BioMightBoundBox() 
	{
		this.xPos= new BigDecimal(0);
		this.yPos = new BigDecimal(0);
		this.zPos = new BigDecimal(0);
		this.xVector = new BigDecimal(1.0);
		this.yVector =  new BigDecimal(1.0);
		this.zVector = new BigDecimal(1.0);
		
		BioMightConnectors bioMightConnectors = new BioMightConnectors();
	
	}
	
	
	public BioMightConnectors getBioMightConnectors() {
		return bioMightConnectors;
	}


	public void setBioMightConnectors(BioMightConnectors bioMightConnectors) {
		this.bioMightConnectors = bioMightConnectors;
	}

		
	public double getTheta() {
		return theta;
	}


	public void setTheta(double theta) {
		this.theta = theta;
	}


	public double[] getRotateVector() {
		return rotateVector;
	}


	public void setRotateVector(double[] rotateVector) {
		this.rotateVector = rotateVector;
	}

	
	// Set the Rotate Vector
	public void setRotateVector(BigDecimal x, BigDecimal y, BigDecimal z) {
		rotateVector[0] = x.doubleValue();
		rotateVector[1] = y.doubleValue();
		rotateVector[2] = z.doubleValue();
	}
	

	// Set the Rotate Vector
	public void setRotateV1ector(double x,double y,double z) {
		rotateVector[0] = x;
		rotateVector[1] = y;
		rotateVector[2] = z;
	}

	/**
	 * @return
	 */
	public BigDecimal getxPos() {
		return (xPos.setScale(2, BigDecimal.ROUND_CEILING));
	}

	public void setxPos(BigDecimal xPos) {
		this.xPos = xPos;
	}

	public BigDecimal getyPos() {
		return (yPos.setScale(2, BigDecimal.ROUND_CEILING));
	}

	public void setyPos(BigDecimal yPos) {
		this.yPos = yPos;
	}

	public BigDecimal getzPos() {
		return (zPos.setScale(2, BigDecimal.ROUND_CEILING));
	}

	public void setzPos(BigDecimal zPos) {
		this.zPos = zPos;
	}

	public BigDecimal getXVector() {
		return xVector;
	}

	public void setXVector(BigDecimal xVector) {
		this.xVector = xVector;
	}

	public BigDecimal getYVector() {
		return yVector;
	}

	public void setYVector(BigDecimal yVector) {
		this.yVector = yVector;
	}

	public BigDecimal getZVector() {
		return zVector;
	}

	public void setZVector(BigDecimal zVector) {
		this.zVector = zVector;
	}

	/**
	 * @return
	 */
	public BigDecimal getXPos() {
		return (xPos.setScale(2, BigDecimal.ROUND_CEILING));
	}
	
	/**
	 * @return
	 */
	public BigDecimal getYPos() {
		return (yPos.setScale(2, BigDecimal.ROUND_CEILING));
	}

	/**
	 * @return
	 */
	public BigDecimal getZPos() {
		return (zPos.setScale(2, BigDecimal.ROUND_CEILING));
	}

	/**
	 * @param decimal
	 */
	public void setXPos(BigDecimal decimal) {
		xPos = decimal;
	}

	/**
	 * @param decimal
	 */
	public void setYPos(BigDecimal decimal) {
		yPos = decimal;
	}

	/**
	 * @param decimal
	 */
	public void setZPos(BigDecimal decimal) {
		zPos = decimal;
	}

}
