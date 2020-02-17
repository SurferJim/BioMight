/*
 * Created on Sep 26, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.bacteria.spirillum;
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
import biomightweb.util.BioWebX3DUtils;

/*********************************************************************************
 * @author SurferJim
 *
 * Representation of CampylobacterJejuni
 ********************************************************************************/

public class CampylobacterJejunis extends BioMightBase {
private ArrayList campylobacterJejunis;

	
	/********************************************************************************************************************
	 *  CampylobacterJejuni
	 * 
	 * This method will instantiate the CampylobacterJejuni that are defined for the current model.  
	 * 
	 ********************************************************************************************************************/

	public CampylobacterJejunis()
	{		
		int localVP= Constants.BIO_CHILD;
		int localLOD = Constants.VIEW_HAWKEYE;
		create(localVP, localLOD, Constants.CampylobacterJejuniRef, null, null);
	}
	
	/********************************************************************************************************************
	 *  CampylobacterJejuni
	 * 
	 * This method will instantiate the CampylobacterJejuni that are defined for the current model.  
	 * 
	 ********************************************************************************************************************/

	public CampylobacterJejunis(String parentID)
	{				
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, parentID, null, null);
	}
	
	public CampylobacterJejunis(int localVP, int localLOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
	{		
		create(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);
	}
	
	
	/********************************************************************************************************************
	 * CREATE CampylobacterJejuni
	 * 
	 * This method will instantiate the CampylobacterJejuni that are defined for the current model.  
	 * 
	 ********************************************************************************************************************/

	private void create(int localVP, int localLOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods) 
	{
		this.setImage("images/CampylobacterJejuni.jpg");
		
		campylobacterJejunis = new ArrayList();
	
		// This is a collection, so set the parent of the children
		// to that of the aggregation object
		this.parentID=parentID;
		this.componentID = parentID;
		this.lod = localLOD;
		this.viewPerspective = localVP;
		
		BioMightScale bioScale = new BioMightScale("0.00, 0.00, 0.00");
		BioMightPosition  bioPos = new BioMightPosition("0.00, 0.00, 0.00");
		BioMightOrientation  bioOrient = new BioMightOrientation("0.00, 0.00, 1.00, 0.0");
		String bioTemplate="CampylobacterJejuni.x3d";

		
		if (bioMightMethods != null){
			System.out.println("EXECUTING CampylobacterJejuni Methods: " + bioMightMethods.size());
			executeMethods(bioMightMethods);
		}
		
		// Get the information from the database via the Enterprise Bean.  This will get
		// a collection of CampylobacterJejuni
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Getting CampylobacterJejuni Transform: " + componentID + "   " +  parentID);
			InitialContext ctx = new InitialContext();
			BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
			bioMightTransforms = bioMightBean.getComponents(Constants.CampylobacterJejuniRef, parentID);   	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - CampylobacterJejuni");
			throw new ServerException("Remote Exception getComponents():", e); 	
		}
		
		
		// Run through the collection of campylobacterJejuni and build them into the model
		ArrayList transforms = bioMightTransforms.getTransforms();
		System.out.println("Have CampylobacterJejuni NumTransforms: " + transforms.size());
		
		// If we are culling the data set
		int numRetreive=transforms.size();
		//if (parentID.equals("Cells"))
		
		for (int i=0; i<transforms.size(); i++)
		{
			// Get the information for the campylobacterJejuni we are creating
			BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
			System.out.println("Creating CampylobacterJejuni: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
			
			// Create an instance of a CampylobacterJejuni for each tranform specified
			localVP = Constants.VIEW_INTERNAL;
			localLOD = Constants.MAG1X;
			
			CampylobacterJejuni campylobacterJejuni = new CampylobacterJejuni(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);		
			System.out.println("CampylobacterJejuni Created!: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
			campylobacterJejunis.add(campylobacterJejuni);
			System.out.println("Added campylobacterJejuni to Collection!: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());

			// initialize the Properties
			// in this case, rather than pass canonical name, we pass the name found in the collectio
			String propDesc = Constants.CampylobacterJejuniRef + "-HelicalShaped, nonSporeForming, GramNegative, Microaerophilic";
			initProperty(bioMightTransform.getName(), Constants.CampylobacterJejuni, Constants.CampylobacterJejuniRef, propDesc,  bioMightTransform.getId(), bioPos, bioScale, bioOrient, Constants.SINGLE_COMPONENT, bioTemplate, false);
		
			
			int numElements = 50;
			if (i == numElements)
				break;
		}

		// Set up methods that will be available to the campylobacterJejuni
		initMethods(bioMightMethods);
	}
	
	
	public void initMethods(ArrayList<BioMightMethodView> bioMightMethodsIn) {
			
		// If we are coming in normally the methods and properties will not
		// be populated.   When processing data they will and we need to use
		// those values
		if (bioMightMethodsIn.size() == 0) {
			System.out.println("New Set of CampylobacterJejuniMethods: " + bioMightMethodsIn.size());
			BioMightMethodView method = new BioMightMethodView();
			method.setCanonicalName(Constants.CampylobacterJejuni);
			method.setMethodName("setColonySize");
			method.setDisplayName("Colony Size:");
			method.setHtmlType("text");
			method.setDataType(Constants.BIO_INT);
			methods.add(method);
		}
		else
		{
			System.out.println("Using Existing CampylobacterJejuniMethods: " + bioMightMethodsIn.size());
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
		
		// Assemble the CampylobacterJejuni
		String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
		"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n " +
		"<X3D profile='Immersive' >\n" +
		"<head>\n" +
		 "<meta name='BioMightImage' content='CampylobacterJejuni.jpg'/>\n" +
		 "<meta name='ExportTime' content='7:45:30'/>\n" +
		 "<meta name='ExportDate' content='08/15/2008'/>\n" +
		 "<meta name='BioMight Version' content='1.0'/>\n" + 
		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='CampylobacterJejuni'\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		

		String body = ""; 

		
		

		// Grab the data from the collection that we just created.
		if (viewPerspective == Constants.VIEW_HAWKEYE)
		{
			System.out.println("Assembling X3D for CampylobacterJejuni HawkEyeView - size: " + campylobacterJejunis.size());
			
			// Run through the collection of CampylobacterJejuni and assemble the X3D for each
			for (int i=0; i<campylobacterJejunis.size(); i++)
			{
				// Get the information for the campylobacterJejuni
				//CampylobacterJejuni campylobacterJejuni = (CampylobacterJejuni) campylobacterJejuni.get(i);
				//System.out.println("Getting X3D for CampylobacterJejuni: " + campylobacterJejuni.getComponentID());
				//body += campylobacterJejuni.getX3D(true);
			}		
			

					
			ArrayList transforms = bioMightTransforms.getTransforms();
			for (int i=0; i<transforms.size(); i++)
			{
				// Get the information for the capsomer we are creating
				BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
				System.out.println("Getting X3D -HawkEyeView - for CampylobacterJejuni: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());				

				//System.out.println("Getting X3D for CampylobacterJejuniX: " + bioMightTransform.getTranslation().getXPos());
				//System.out.println("Getting X3D for CampylobacterJejuniY: " + bioMightTransform.getTranslation().getYPos());
				//System.out.println("Getting X3D for CampylobacterJejuniZ: " + bioMightTransform.getTranslation().getZPos());
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
			
				double radius = (bioMightTransform.getRadius());
				double height =  bioMightTransform.getHeight();
			
				double spikeHeight =  0.0875;
				double spikeRadius = 0.00825;
				double halfSpike = MathUtils.round(spikeHeight/2, 8);
				 
				String bioGroup = "FlagellaGroup";
				BioMightTransform baseTransform = bioMightTransform;
				
				
				body = ""; /*BioWebX3DUtils.generateSphere(bioMightTransform,  
						new double[] {bioMightTransform.getTranslation().getXPos()+2, 
									  bioMightTransform.getTranslation().getYPos(), 
									  bioMightTransform.getTranslation().getZPos()}  ) 	;*/
				
				


				//double rodOrient[] = {0.707,     0.0,     0.707,      1.57};
			
				double rodOrient[][] = {
						{0.0,        0.0,         1,      0.707},
						{0.707,      0.0,     0.707,      0.707},
						{-0.707,     0.0,     0.707,      0.707},
						{ 0.707,     0.0,     -0.707,     0.707},
						{-0.707,     0.0,     0.707,      0.707},
						{ 0.707,     0.0,     -0.707,     0.707}
				};
				
				// Get the base values from the database
				double xStartPos = bioMightTransform.getTranslation().getXPos();  
				double yStartPos = bioMightTransform.getTranslation().getYPos();
				double zStartPos = bioMightTransform.getTranslation().getZPos();
				
				// Represents the current position
				double xPos = xStartPos; 
				double yPos = yStartPos;
				double zPos = zStartPos;
				
				System.out.println("StartPoint (Center): " + xPos + "  " + yPos +  "  " +  zPos);
				
				int collectionSize = 1; //new Double(MathUtils.round(Math.random()*8, 0)).intValue();
				//System.out.println("Collection Size: " + collectionSize);
				
				for (int jk=0; jk<1; jk++) {
					
					double xDisplace = Math.random()*3;
					double yDisplace = Math.random()*3;
					double zDisplace = Math.random()*3;
					
					//reset a new position and start a new strand
					xPos = xStartPos + xDisplace;
					yPos = yStartPos + yDisplace;
					zPos = zStartPos + zDisplace;
			
					
					// Run through the segments that make this string of cells
					int randoLength = rodOrient.length; //new Double(MathUtils.round(Math.random()*10, 0)).intValue();
					for (int v=0; v<randoLength; v++) {
	
					
						// Set up the Angle for growth path.  As this is a spirilla,
						// the angle will be fixed to allow for a nice symmetrical rotation
						//rodOrient[3] = MathUtils.round(.707, 3);
		
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
						//  Calculate position for the Cylinder and Displace it so that 
						//  its begin point
						//  moves to natural centerpoint of the cylinder
						//*************************************************************
						
						// Here are the two rotation angles
						double rotationAngle = rodOrient[v][3];
				
						// Here is the radius
						double radiusSpike = height * 0.50;
						
						// Convert the degrees to radians
						//double radiansLatitudeSpike =  MathUtils.round(Math.toRadians(angleLatitude), 8);
						double radiansLongitudeSpike = rotationAngle;
						 
						System.out.println("Longitude Angle: " + MathUtils.round(Math.toDegrees(rotationAngle), 4));
						System.out.println("radiansLongitude: " + radiansLongitudeSpike);
						double calculatedPoint[][] =  BioGraphics.applyRotation(new double [][] {{0, radiusSpike, 0}},  -1, MathUtils.round(Math.toDegrees(rotationAngle), 4), new double [] {rodOrient[v][0], rodOrient[v][1], rodOrient[v][2]} );
						
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
					    
					    System.out.println("X Y Z Updated: " + xPos + "  " + yPos +  "  " +  zPos);
						
					
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
								+ rodOrient[v][0] + " "
								+ rodOrient[v][1] + " "
								+ rodOrient[v][2]  + " "
								+ rodOrient[v][3] + "'\n";
			
						 					
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
			
			    System.out.println("USE X Y Z for Terminus: " + xPos + "  " + yPos +  "  " +  zPos);
			
			    
			    body+= BioWebX3DUtils.generateFlagellaSphere(bioMightTransform,  new double[] {xPos, yPos, zPos});
		
			    
			    //body+= BioWebX3DUtils.generateFlagellaSphere(bioMightTransform,  new double[] {xPos-1, yPos-1, zPos+1});	
			}

		}	
		// This is for when we are going to deal with the collection data separately.  Like
		// when we do not want to access the sub components.
		else if (viewPerspective == Constants.VIEW_INTERNAL)
		{	
			System.out.println("Assembling X3D for CampylobacterJejuni InternalView - size: " + campylobacterJejunis.size());
			
			ArrayList transforms = bioMightTransforms.getTransforms();
			for (int i=0; i<transforms.size(); i++)
			{
				// Get the information for the capsomer we are creating
				BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
				System.out.println("Getting X3D -InternalView - for CampylobacterJejuni: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());				

				//System.out.println("Getting X3D for CampylobacterJejuniX: " + bioMightTransform.getTranslation().getXPos());
				//System.out.println("Getting X3D for CampylobacterJejuniY: " + bioMightTransform.getTranslation().getYPos());
				//System.out.println("Getting X3D for CampylobacterJejuniZ: " + bioMightTransform.getTranslation().getZPos());
				// Change the height and width based on the displacement.
				body += "<Transform DEF='TRANSFORM_" + bioMightTransform.getId() + "' \n";

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
				    " url='../images/CampylobacterJejuni.jpg'/>";
				
				
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
				 	"<Sphere DEF='CampylobacterJejuniGeoSphere'\n" +
				 	"containerField='geometry'\n" +
				 	"radius='" + bioMightTransform.getRadius() +"'/>\n" +
				 	"</Shape>\n" +
				 	
					"\n<TouchSensor DEF='TSENSOR_" + bioMightTransform.getId() + "' \n" +
	                   " description='StreptococusPyogenes'\n" +
		               " containerField='children'/> \n" +
	
				 "</Transform>\n";
								
			}
		}			

		
		
		//System.out.println("CampylobacterJejuni X3D: " + body);		
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
		System.out.println("CampylobacterJejuni-Executing Methods: " + bioMightMethods.size());
		for (int j=0; j<bioMightMethods.size(); j++){
			
			// Get the parameter from the list and if it is not
			// empty execute the associated method using it
			BioMightMethodView bioMightMethod = (BioMightMethodView) bioMightMethods.get(j);
			System.out.println("Have BioMightMethod for CampylobacterJejuni: " + bioMightMethod.getMethodName());	
			String methodName = bioMightMethod.getMethodName();
			String canonicalName = bioMightMethod.getCanonicalName(); 
			String dataType = bioMightMethod.getDataType();
			String methodParam = bioMightMethod.getMethodParameter(); 
			if (methodParam == null)
				methodParam = "";
			
			// We only execute those methods that are targeted for the IRIS
			// If a parameter is specified then we fire the method, otherwise
			// we just jump over it
			if (canonicalName.equals(Constants.CampylobacterJejuni)) {				
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
				System.out.println("CampylobacterJejuni - Methods have fired.   Calling CampylobacterJejuni Save method!");
			}
		}
	}

	

	/******************************************************************************************
	 * SET COLONY SIZE 
	 *
	 * This method will set the Colony size for the CampylobacterJejuni.  
	 *****************************************************************************************/
	public void setColonySize(int size) {

		// Run through the argument list and executes the 
		// associated methods
		boolean fired = false;
		System.out.println("CampylobacterJejuni-SetColony Size: " + size);
		
		// Generate the CampylobacterJejuni		
		BioMightCellularBeanLocal bioMightBean;
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Generating the CampylobacterJejuni Colony: " + componentID + "    " + parentID);
			InitialContext ctx = new InitialContext();
			//bioMightBean = (BioMightCellularBeanLocal) ctx.lookup("biomight.ejb.BioMightCellularBeanLocal");
			bioMightBean = (BioMightCellularBeanLocal) ctx.lookup("java:global/BioMightWeb/BioMightCellularBean!biomight.ejb.BioMightCellularBeanLocal");
	
			double currentPoints[][] = null;
		//	int success = bioMightBean.generateCampylobacterJejuni(size, "CampylobacterJejuni:00001", "CampylobacterJejuni", 
		//		"CampylobacterJejuni", this.componentID, this.parentID, currentPoints);
			
			System.out.println("Created CampylobacterJejuni Info using EJB");   	
		}catch (Exception e) { 
			System.out.println("Exception Creating Colony - CampylobacterJejuni");
			throw new ServerException("Remote Exception CampylobacterJejuniEpithelium():", e); 	
		}
	}
	
}
