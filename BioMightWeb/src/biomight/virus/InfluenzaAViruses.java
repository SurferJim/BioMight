/****************************************************************************************
 * Created on Sep 26, 2006
 *
 * Represents a collection of AdenoViruses
 * 
 * 
 ****************************************************************************************/


package biomight.virus;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

import javax.naming.InitialContext;

import org.apache.openejb.math.util.MathUtils;

import biomight.BioMightBase;
import biomight.Constants;
import biomight.ejb.BioMightBeanLocal;
import biomight.ejb.BioMightCellularBeanLocal;
import biomight.ejb.DBUtils;
import biomight.exceptions.ServerException;
import biomight.view.BioMightMethodView;
import biomight.view.BioMightPosition;
import biomight.view.BioMightPropertyView;
import biomight.view.BioMightScale;
import biomight.view.BioMightTransform;

/*********************************************************************************
 * @author SurferJim
 *
 * Representation of InfluenzaAViruses
 ********************************************************************************/

public class InfluenzaAViruses extends BioMightBase {
private ArrayList influenzaAViruses;

	
	/********************************************************************************************************************
	 *  InfluenzaAViruses
	 * 
	 * This method will instantiate the InfluenzaAViruses that are defined for the current model.  
	 * 
	 ********************************************************************************************************************/

	public InfluenzaAViruses()
	{		
		int localVP= Constants.BIO_CHILD;
		int localLOD = Constants.VIEW_HAWKEYE;
		create(localVP, localLOD, Constants.CellsRef, null, null);
	}
	
	/********************************************************************************************************************
	 *  InfluenzaAViruses
	 * 
	 * This method will instantiate the InfluenzaAViruses that are defined for the current model.  
	 * 
	 ********************************************************************************************************************/

	public InfluenzaAViruses(String parentID)
	{				
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, parentID, null, null);
	}
	
	public InfluenzaAViruses(int localVP, int localLOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
	{		
		create(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);
	}
		
	/********************************************************************************************************************
	 * CREATE InfluenzaAViruses
	 * 
	 * This method will instantiate the hips that are defined for the current model.  
	 * 
	 ********************************************************************************************************************/

	private void create(int localVP, int localLOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods) 
	{
		this.setImage("images/InfluenzaAViruses.jpg");
		
		influenzaAViruses = new ArrayList();
	
		// This is a collection, so set the parent of the children
		// to that of the aggregation object
		this.parentID=parentID;
		this.componentID = parentID;
		this.lod = localLOD;
		this.viewPerspective = localVP;
		
		
		if (bioMightMethods != null){
			System.out.println("EXECUTING InfluenzaAViruses Methods: " + bioMightMethods.size());
			executeMethods(bioMightMethods);
		}
		
		// Get the information from the database via the Enterprise Bean.  This will get
		// a collection of InfluenzaAViruses
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Getting InfluenzaAViruses Transform: " + componentID + "   " +  parentID);
			InitialContext ctx = new InitialContext();
			BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
			bioMightTransforms = bioMightBean.getComponents(Constants.InfluenzaAVirusRef, parentID);   	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - InfluenzaAViruses");
			throw new ServerException("Remote Exception getComponents():", e); 	
		}
		
		
		// Run through the collection of influenzaAViruses and build them into the model
		ArrayList transforms = bioMightTransforms.getTransforms();
		System.out.println("Have InfluenzaAViruses NumTransforms: " + transforms.size());
		
		// If we are culling the data set
		int numRetreive=transforms.size();
	
		BioMightScale bioScale = new BioMightScale("0.00, 0.00, 0.00");
		BioMightPosition  bioPos = new BioMightPosition("0.00, 0.00, 0.00");
		String bioTemplate="AdenoViruses.x3d";

		for (int i=0; i<transforms.size(); i++)
		{
			// Get the information for the influenzaAVirus we are creating
			BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
			System.out.println("Creating InfluenzaAVirus: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
			
			// Create an instance of a InfluenzaAVirus for each tranform specified
			localVP = Constants.VIEW_INTERNAL;
			localLOD = Constants.MAG1X;
			
			InfluenzaAVirus influenzaAVirus = new InfluenzaAVirus(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);		
			System.out.println("InfluenzaAVirus Created!: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
			influenzaAViruses.add(influenzaAVirus);
			System.out.println("Added InfluenzaAVirus to Collection!: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());

			// initialize the Properties
			// in this case, rather than pass canonical name, we pass the name found in the collectio
			initProperty(bioMightTransform.getName(), Constants.InfluenzaAVirus, Constants.InfluenzaAVirusRef, bioMightTransform.getId());				
			//initProperty(bioMightTransform.getName(), Constants.InfluenzaAVirus, Constants.InfluenzaAVirusRef, parentID);
			
			int numElements = 50;
			if (i == numElements)
				break;
		}

		// Set up methods that will be available to the influenzaAViruses
		initMethods(bioMightMethods);
	}
	
	
	public void initMethods(ArrayList<BioMightMethodView> bioMightMethodsIn) {
			
		// If we are coming in normally the methods and properties will not
		// be populated.   When processing data they will and we need to use
		// those values
		if (bioMightMethodsIn.size() == 0) {
			System.out.println("New Set of InfluenzaAVirusesMethods: " + bioMightMethodsIn.size());
			BioMightMethodView method = new BioMightMethodView();
			method.setCanonicalName(Constants.InfluenzaAViruses);
			method.setMethodName("setColonySize");
			method.setDisplayName("Colony Size:");
			method.setHtmlType("text");
			method.setDataType(Constants.BIO_INT);
			methods.add(method);
		}
		else
		{
			System.out.println("Using Existing InfluenzaAVirusesMethods: " + bioMightMethodsIn.size());
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
		
		// Assemble the InfluenzaAViruses
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
		"title='InfluenzaAViruses'\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		

		
		double radius = 0.25;
		double xPos = 0.0;
		double yPos = 0.0;
		double zPos = 0.0;
		double xScale = 1.0;
		double yScale = 1.0;
		double zScale = 1.0;
		double xOrient = 0.0;
		double yOrient = 1.0;
		double zOrient = 0.0;
		double depth = 0.00125;
		double degrees = 0.0;
		String body = ""; 

	
		// Grab the data from the collection that we just created.
		if (viewPerspective == Constants.VIEW_HAWKEYE)
		{	
			System.out.println("Assembling X3D for InfluenzaAViruses HawkEyeView - size: " + influenzaAViruses.size());
			
			// Run through the collection of InfluenzaAViruses and assemble the X3D for each
			for (int i=0; i<influenzaAViruses.size(); i++)
			{
				// Get the information for the influenzaAVirus
				//InfluenzaAVirus influenzaAVirus = (InfluenzaAVirus) influenzaAViruses.get(i);
				//System.out.println("Getting X3D for InfluenzaAVirus: " + influenzaAVirus.getComponentID());
				//body += influenzaAVirus.getX3D(true);
			}		
			
			body="";
			
			
			ArrayList transforms = bioMightTransforms.getTransforms();
			for (int i=0; i<transforms.size(); i++)
			{
				// Get the information for the capsomer we are creating
				BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
				System.out.println("Getting X3D -InternalView - for InfluenzaAVirus: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());				

				//System.out.println("Getting X3D for InfluenzaAVirusX: " + bioMightTransform.getTranslation().getXPos());
				//System.out.println("Getting X3D for InfluenzaAVirusY: " + bioMightTransform.getTranslation().getYPos());
				//System.out.println("Getting X3D for InfluenzaAVirusZ: " + bioMightTransform.getTranslation().getZPos());
				// Change the height and width based on the displacement.
				
				int numLongitude = 12;
				int numLatitude = 12;
				double rotateLatitude = 360/numLatitude;
				double rotateLongitude = 360/numLongitude;
				double angleLatitude = rotateLatitude;
				double angleLongitude = rotateLongitude;
				
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
						
						double radiansLatitude =  Math.toRadians(angleLatitude);
						double radiansLongitude =  Math.toRadians(angleLongitude);
						//System.out.println("radiansLatitude: " + radiansLatitude + " radiansLongitude: " + radiansLongitude);
						
						double cosLat = MathUtils.round(Math.cos(radiansLatitude), 8);
						double cosLong = MathUtils.round(Math.cos(radiansLongitude), 8);
						double sinLong = MathUtils.round(Math.sin(radiansLongitude), 8);
						double sinLat = MathUtils.round(Math.sin(radiansLatitude), 8);
						
						// Set the position
						xPos = MathUtils.round((radius * (cosLat * sinLong)), 8);  
						yPos = MathUtils.round((radius * cosLong), 8);
						zPos = MathUtils.round((radius * (sinLat * sinLong)), 8); 

						//System.out.println("Cos(Lat): " + cosLat + " Sin(Lat): " + sinLat + "            Sin(Long): " + sinLong + "  cos(Long): " + cosLong);
						//System.out.println("XPOS: " + xPos + "=  Cos(Lat): " + cosLat + " Sin(Long): " + sinLong);
						//System.out.println("YPOS: " + yPos + "=  Sin(Lat): " + sinLat + " Cos(Long): " + cosLong);
						//System.out.println("ZPOS: " + zPos + "=  Cos(Long): " + cosLong);
						
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
				
						degrees = -radiansLongitude;	
									       	
				
						body += "<Transform DEF='TRANSFORM_" + bioMightTransform.getId() + longitude + " " + latitude + "' \n";
					 	body += "translation='" 
					 		+ xPos + " " 
		 					+ yPos + " "
		 					+ zPos + "'\n";					
					
						body +=  "rotation='" 
								+ xOrient + " "
								+ yOrient + " "
								+ zOrient  + " "
								+ degrees + "'\n\n";
						
						body +=  "scale='1 1 1'>\n" +
						
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
				    " url='../images/InfluenzaAVirus.png'/>";
				
				
				    
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
		// This is for when we are going to deal with the collection data separately.  Like
		// when we do not want to access the sub components.
		else if (viewPerspective == Constants.VIEW_INTERNAL)
		{	
			System.out.println("Assembling X3D for InfluenzaAViruses InternalView - size: " + influenzaAViruses.size());
			
			ArrayList transforms = bioMightTransforms.getTransforms();
			for (int i=0; i<transforms.size(); i++)
			{
				// Get the information for the capsomer we are creating
				BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
				System.out.println("Getting X3D -InternalView - for InfluenzaAVirus: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());				

				//System.out.println("Getting X3D for InfluenzaAVirusX: " + bioMightTransform.getTranslation().getXPos());
				//System.out.println("Getting X3D for InfluenzaAVirusY: " + bioMightTransform.getTranslation().getYPos());
				//System.out.println("Getting X3D for InfluenzaAVirusZ: " + bioMightTransform.getTranslation().getZPos());
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
					    " url='../images/InfluenzaAVirus.png'/>";
				
				
				    
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

		body+= "<Viewpoint DEF='Viewpoint_InfluenzaAVirus'\n" +
				 "description='Viewpoint1'\n" +
				 "jump='true'\n" +
				 "fieldOfView='0.785'\n" +
				 "position='0.0 0.0 2.0'\n" +
				 "orientation='0 0 1 0'/>\n";
		
		//System.out.println("InfluenzaAViruses X3D: " + body);		
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
		System.out.println("InfluenzaAViruses-Executing Methods: " + bioMightMethods.size());
		for (int j=0; j<bioMightMethods.size(); j++){
			
			// Get the parameter from the list and if it is not
			// empty execute the associated method using it
			BioMightMethodView bioMightMethod = (BioMightMethodView) bioMightMethods.get(j);
			System.out.println("Have BioMightMethod for InfluenzaAViruses: " + bioMightMethod.getMethodName());	
			String methodName = bioMightMethod.getMethodName();
			String canonicalName = bioMightMethod.getCanonicalName(); 
			String dataType = bioMightMethod.getDataType();
			String methodParam = bioMightMethod.getMethodParameter(); 
			if (methodParam == null)
				methodParam = "";
			
			// We only execute those methods that are targeted for the IRIS
			// If a parameter is specified then we fire the method, otherwise
			// we just jump over it
			if (canonicalName.equals(Constants.InfluenzaAViruses)) {				
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
				System.out.println("InfluenzaAViruses - Methods have fired.   Calling InfluenzaAViruses Save method!");
			}
		}
	}

	

	/******************************************************************************************
	 * SET COLONY SIZE 
	 *
	 * This method will set the Colony size for the InfluenzaAViruses.  
	 *****************************************************************************************/
	public void setColonySize(int size) {

		// Run through the argument list and executes the 
		// associated methods
		boolean fired = false;
		System.out.println("InfluenzaAViruses-SetColony Size: " + size);
		
		// Generate the InfluenzaAVirus		
		BioMightCellularBeanLocal bioMightBean;
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Generating the InfluenzaAVirus Colony: " + componentID + "    " + parentID);
			InitialContext ctx = new InitialContext();
			//bioMightBean = (BioMightCellularBeanLocal) ctx.lookup("biomight.ejb.BioMightCellularBeanLocal");
			bioMightBean = (BioMightCellularBeanLocal) ctx.lookup("java:global/BioMightWeb/BioMightCellularBean!biomight.ejb.BioMightCellularBeanLocal");
	
			double currentPoints[][] = null;
		//	int success = bioMightBean.generateInfluenzaAViruses(size, "InfluenzaAVirus:00001", "InfluenzaAVirus", 
		//		"InfluenzaAVirus", this.componentID, this.parentID, currentPoints);
			
			System.out.println("Created InfluenzaAVirus Info using EJB");   	
		}catch (Exception e) { 
			System.out.println("Exception Creating Colony - InfluenzaAVirus");
			throw new ServerException("Remote Exception InfluenzaAVirusEpithelium():", e); 	
		}
	}
	
}
