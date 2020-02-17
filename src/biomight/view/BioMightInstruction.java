package biomight.view;


import biomight.Constants;

public class BioMightInstruction {

	// Build # segments to build the intestine
	int transType = Constants.TRANSLATE;
	
	BioMightTransform bioMightTransform;
	
	// Translation Vector in 3D space {x,y,z}
	double[] translateMatrix = {0, 0, 0};	

	// Angle of rotation
	double theta = 45.0;
	
	
	// Scale that will be applied
	double[] scale = {1,1,1};
	


	// What point on are we rotating about
	int pivotPoint = -1;
	
	// What Vector are we rotating about
	double rotateVector[] = {0.0, 0.0 ,1.0};

	// Current object orientation
	BioMightOrientation orientation = new BioMightOrientation(0.0, -1.0, 0.0, 90.0);
	
	// The Vector are we rotating about and the angle
	BioMightOrientation rotation = new BioMightOrientation(0.0, -1.0, 0.0, 90.0);
	
	BioMightAppendage bioMightAppendage = null;
	
	boolean bFillAppendage = false;

	// Set of points that participate in a graphic operation
	int pointSet[] = {};
	
	  
	public int[] getPointSet() {
		return pointSet;
	}


	public void setPointSet(int[] pointSet) {
		this.pointSet = pointSet;
	}

	
	public boolean isFillAppendage() {
		return bFillAppendage;
	}

	public int isFillAppendageInt() {
		if (bFillAppendage)
			return 1;
		else 
			return 0;
	}

	public void setFillAppendage(boolean bFillAppendage) {
		this.bFillAppendage = bFillAppendage;
	}


	public BioMightTransform getBioMightTransform() {
		return bioMightTransform;
	}


	public void setBioMightTransform(BioMightTransform bioMightTransform) {
		this.bioMightTransform = bioMightTransform;
	}

	

	public BioMightAppendage getBioMightAppendage() {
		return bioMightAppendage;
	}


	public void setBioMightAppendage(BioMightAppendage bioMightAppendage) {
		this.bioMightAppendage = bioMightAppendage;
	}


	// Set the Rotate Vector
	public void setRotateVector(double x,double y,double z) {
		rotateVector[0] = x;
		rotateVector[1] = y;
		rotateVector[2] = z;
	}

		
	public double[] getTranslateMatrix() {
		return translateMatrix;
	}

	public void setTranslateMatrix(double x, double y, double z) {
		translateMatrix[0] = x; 
		translateMatrix[1] = y;
		translateMatrix[2] = z;
	}
	
	public void setScaleMatrix(double x, double y, double z) {
		scale[0] = x; 
		scale[1] = y;
		scale[2] = z;
	}
	
	public double getTheta() {
		return theta;
	}

	public void setTheta(double theta) {
		this.theta = theta;
	}
	
	
	public void setTheta(String thetaStr) {
		
		try {
			double thetaIn = Double.parseDouble(thetaStr);
			this.theta = thetaIn;
			
		} catch (Exception e)
		{
			this.theta = 0;
		}
		
	}
	

	public double[] getScale() {
		return scale;
	}

	public void setScale(double[] scale) {
		this.scale = scale;
	}

	
	public void setScale(String scaleMatrix) {
		
		String[] coords = scaleMatrix.split(",");
		
		try {
			double x = Double.parseDouble(coords[0]);
			double y = Double.parseDouble(coords[1]);
			double z = Double.parseDouble(coords[2]);
			double[] scaleMatrixIn = {x, y, z};
			this.scale = scaleMatrixIn;
			
		} catch (Exception e)
		{
			double[] scaleMatrixIn = {0.0, 0.0, 0.0};
			this.scale = scaleMatrixIn;
		}
		
	}
	
	public int getTransType() {
		return transType;
	}

	public void setTransType(int transType) {
		this.transType = transType;
	}

	public void setTransType(String transTypeStr) {
		
		try {
			transType = Integer.parseInt(transTypeStr);
		} catch (Exception e)
		{
			transType = Constants.TRANSLATE;
		}
	}
	
	
	public int getPivotPoint() {
		return pivotPoint;
	}

	public void setPivotPoint(String pivotPointStr) {
		
		try {
			pivotPoint = Integer.parseInt(pivotPointStr);
		} catch (Exception e)
		{
			pivotPoint = 0;
		}
	}
	
	public void setPivotPoint(int pivotPoint) {
		this.pivotPoint = pivotPoint;
	}

	public double[] getRotateVector() {
		return rotateVector;
	}


	public void setTranslateMatrix(double[] translateMatrix) {
		this.translateMatrix = translateMatrix;
	}

	
	public void setTranslateMatrix(String translateMatrix) {
		
		String[] coords = translateMatrix.split(",");
		
		try {
			double x = Double.parseDouble(coords[0]);
			double y = Double.parseDouble(coords[1]);
			double z = Double.parseDouble(coords[2]);
			double[] translateMatrixIn = {x, y, z};
			this.translateMatrix = translateMatrixIn;
			
		} catch (Exception e)
		{
			double[] translateMatrixIn = {0.0, 0.0, 0.0};
			this.translateMatrix = translateMatrixIn;
		}
		
	}


	public void setRotateVector(double[] rotateVector) {
		this.rotateVector = rotateVector;
	}

	public void setRotateVector(String rotateMatrix) {
		
		String[] coords = rotateMatrix.split(",");
		
		try {
			double x = Double.parseDouble(coords[0]);
			double y = Double.parseDouble(coords[1]);
			double z = Double.parseDouble(coords[2]);
	
			double[] rotateMatrixIn = {x, y, z};
			this.rotateVector = rotateMatrixIn;
			
		} catch (Exception e)
		{
			double[] rotateMatrixIn = {0.0, 0.0, 0.0};
			this.rotateVector = rotateMatrixIn;
		}
		
	}

	public BioMightOrientation getOrientation() {
		return orientation;
	}


	public void setOrientation(BioMightOrientation orientation) {
		this.orientation = orientation;
	}
	
	public void setOrientation(String orientationMatrix) {
		
		String[] coords = orientationMatrix.split(",");
		
		try {
			double x = Double.parseDouble(coords[0]);
			double y = Double.parseDouble(coords[1]);
			double z = Double.parseDouble(coords[2]);
			double angle = Double.parseDouble(coords[3]);
			BioMightOrientation orientationIn = new  BioMightOrientation(x, y, z, angle);
			this.orientation = orientationIn;
			
		} catch (Exception e)
		{
			BioMightOrientation orientationIn = new  BioMightOrientation(0.0, 0.0, 1.0, 90.0);
			this.orientation = orientationIn;
		}
		
	}


	public BioMightOrientation getRotation() {
		return rotation;
	}


	public void setRotation(BioMightOrientation rotation) {
		this.rotation = rotation;
	}		
	
	
	public String getTranslationMatrixStr() {
		
		return (translateMatrix[0] + " " + translateMatrix[1] + " " + translateMatrix[2]);
	}

	public String getTranslationMatrixStrWC() {
		
		return (translateMatrix[0]  + ",  " + translateMatrix[1] + ",  " + translateMatrix[2]);
	}
	
	public String getRotationMatrixStr() {
		
		return (rotateVector[0] + " " + rotateVector[1] + " " + rotateVector[2]);
	}

	public String getRotationMatrixStrWC() {
		
		return (rotateVector[0]  + ",  " + rotateVector[1] + ",  " + rotateVector[2]);
	}
	
	
	public String getScaleStr() {
		
		return (scale[0] + " " + scale[1] + " " + scale[2]);
	}

	public String getScaleStrWC() {
		
		return (scale[0]  + ",  " + scale[1] + ",  " + scale[2]);
	}

	
	public String getRotateVectorStr() {
		
		return (rotateVector[0] + " " + rotateVector[1] + " " + rotateVector[2]);
	}

	public String getRotateVectorStrWC() {
		
		return (rotateVector[0]  + ",  " + rotateVector[1] + ",  " + rotateVector[2]);
	}
}
