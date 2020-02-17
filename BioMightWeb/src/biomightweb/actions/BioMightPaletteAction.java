package biomightweb.actions;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import biomight.BioMightKey;
import biomight.BioMightKeys;
import biomight.Constants;
import biomight.ejb.BioMightBeanLocal;
import biomight.util.BioGraphics;
import biomight.view.BioMightAnimation;
import biomight.view.BioMightMethodView;
import biomight.view.BioMightTransform;
import biomight.view.BioMightTransforms;
import biomightweb.view.BioMightComponent;
import biomightweb.view.BioMightViewPoint;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ParameterAware;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

/*******************************************************************
 * @version 1.0
 * 
 *          Handles Palette processing.
 * 
 * @author
 ******************************************************************/

public class BioMightPaletteAction extends ActionSupport implements
		SessionAware, ServletRequestAware, ParameterAware {
	private Map session;
	private HttpServletRequest request;
	private Map pMap;

	// Store the Core fields directly here in the Palette Action as there
	// is only one instance per person per request. It comes and goes
	private String bioMightProjectID = "";
	private String bioMightProjectName = "";
	private String pageAction = "";
	private int bioMightComponentPick = -1;

	private List<BioMightComponent> bioMightComponents;
	private BioMightComponent bioMightComponent;

	private List<BioMightViewPoint> bioMightViewPoints;
	private BioMightViewPoint bioMightViewPoint;

	private String paletteName = "";
	
	private String x3dScript = "";
	
	private InputStream fileInputStream = null;
	private String exportFile = "";
    double exportFileSize = 0.0;
    
	/************************************************************
	 * EXECUTE
	 * 
	 ***********************************************************/
	public String execute() throws Exception {
		// We will have several objects in the palette. We should probably
		// allow the user to switch between tabs and keep the data
		System.out.println("\n\nIn BioMightPaletteAction - PageAction: " + pageAction + "  pick: " + bioMightComponentPick);

		ArrayList<BioMightComponent> bioMightSessionComponents = (ArrayList<BioMightComponent>) session.get("bioMightComponents");
		ArrayList<BioMightViewPoint> bioMightSessionViewPoints = (ArrayList<BioMightViewPoint>) session.get("bioMightViewPoints");
		paletteName = (String) session.get("paletteName");
		if (paletteName == null)
			paletteName = "";
		
		// Come in from the Projects page and we will need to get and or
		// set up the project in the database
		if (pageAction.equals("projects")) 
		{
			System.out.println("Retreiving Project with ID: " + bioMightProjectID + "  Name:  " + bioMightProjectName);
			// bioMightComponents = getProject();
		} 
		else 
		{
			// These are the core values passed in from the client interface
			// that tell BioMight which component it is working on
			System.out.println("ComnponentID: |" + bioMightComponent.getBioMightComponentID() + "|");
			System.out.println("CompnonentNambe: |" + bioMightComponent.getBioMightComponentName() + "|");
			System.out.println("ComponentType: |" + bioMightComponent.getBioMightComponentType() + "|");
			System.out.println("ComponentRef: |" + bioMightComponent.getBioMightComponentRef() + "|");
			System.out.println("ParentID: |" + bioMightComponent.getBioMightComponentParentID() + "|");
			System.out.println("BuildComponentType: |" + bioMightComponent.getBioMightBuildComponentType() + "|");
			System.out.println("CollectionInfo: |" + bioMightComponent.isBioMightCollection() + "|");
			System.out.println("ProjectName: |" + getBioMightProjectName() + "|");
			System.out.println("PaletteName: |" + paletteName + "|");
			//dumpMethods();
			
			// The user has decided to add an item to the palette
			// Pick up the Components that were stored away before we left this
			// page
			if (pageAction.equals("add")) {

				if (bioMightSessionComponents == null) {

					System.out.println("FIRST TIME - Pallette is Empty!");
					bioMightSessionComponents = new ArrayList<BioMightComponent>();
					bioMightSessionViewPoints = new ArrayList<BioMightViewPoint>();

					// On the first time, add the viewpoint (camera/lens)
					BioMightViewPoint localbioMightViewPoint = new BioMightViewPoint("Camera 1", true, 0.5);

					System.out.println("Created ViewPoint - CollectionSize : " + bioMightSessionViewPoints.size());
					bioMightSessionViewPoints.add(localbioMightViewPoint);
					System.out.println("Added ViewPoint - CollectionSize : "+ bioMightSessionViewPoints.size());
				}

				System.out.println("BioMightComponent Name: " + bioMightComponent.getBioMightComponentName());
				bioMightSessionComponents.add(bioMightComponent);
				System.out.println("BioMightSessionComponent Added - Collection size: " + bioMightSessionComponents.size());

			} 
			else if (pageAction.equals("noadd")) 
			{
				System.out.println("Coming back from View - No Add!");
			} 
			else if (pageAction.equals("delete")) 
			{
				// *****************************************************
				// Get the Methods from the Session object.
				// bioMightMethods = (ArrayList)
				// session.getAttribute("bioMightMethods");
				// BioMightMethodView bioMightMethod;
				// Take the parameters from the FORM and place them into the
				// Methods array
				System.out.println("Delete Component + : "
						+ bioMightComponent.getBioMightComponentName());
				System.out.println("Deleting Component Element# : "
						+ bioMightComponentPick);
				bioMightSessionComponents.remove(bioMightComponentPick);
			}
			// The user is updating the position
			else if (getPageAction().equals("bioMethod")) 
			{
				if (bioMightSessionComponents == null)
					System.out.println("BioMethod - BioMightSessionComponents is NULL!");

				// The Components and ViewPonts were just edited in the form.  If all validates
				// these will become the new values				
				bioMightSessionComponents = (ArrayList) bioMightComponents;
				bioMightSessionViewPoints = (ArrayList) bioMightViewPoints;
				// dumpViewPoints();
				dumpComponents();
				System.out.println("PaletteAction - pageAction is bioMethod - Session Data updated");
			} 
			else if (getPageAction().equals("bioExport")) 
			{
				System.out.println("BioExport - method is executing- palette is " + paletteName);
				if (bioMightSessionComponents == null)
					System.out.println("BioExport - BioMightSessionComponents is NULL!");
			
				 if (!paletteName.equals(""))
				 {
					 exportFile = request.getSession().getServletContext().getRealPath("/") + "x3d\\" + paletteName + ".x3d";
					 //exportFile = "C:\\BioEclipse\\BioMightWeb\\WebContent\\x3d\\" + paletteName + ".x3d";
					 System.out.println("PaletteAction - Exporting file " + exportFile);
					 File fileToDownload = new File(exportFile);
					 System.out.println("PaletteAction - Have found Exporting file " + exportFile);
					 
					 fileInputStream = new FileInputStream(fileToDownload);
					 exportFileSize = fileToDownload.length();
				     System.out.println("PaletteAction - Export size is: " + exportFileSize);
					 
					return ("bioExport");
				 }
			} 
			else if (pageAction.equals("WhenWeGetMethodsWorkingHere")) {
				if (bioMightSessionComponents == null)
					System.out.println("BioProces - BioMightSessionComponents is NULL!");
				System.out.println("PaletteAction - pageAction is bioProcess");
			} 
			else 
			{
				System.out.println("ACTION not TRAPPED in Palette: "+ bioMightComponent.getBioMightComponentRef());
			}
		}

		// Stick the new data back into the current page components

		if (!getPageAction().equals("bioMethod")) 
		{
			System.out.println("No Changes on form - Placing Session Data into ActionObject to maintain state");
			bioMightComponents = bioMightSessionComponents;
			bioMightViewPoints = bioMightSessionViewPoints;
		}
		//dumpComponents();
		
		
		// No matter what operation was performed on the page, the X3D will be rendered
		String body = "";
		if (bioMightSessionComponents != null) {
			
			// Set up a Java Script function to activate the animation
			x3dScript += 
				"\n\n" +
				"function launchAnim() {\n";
			
				body = getViewPointsX3D(bioMightProjectName) + getComponentsX3D();
			
			x3dScript += " }\n\n"; 
			
			
			//System.out.println("Assembled Palette X3D - writing...");
			writeX3D(body);
		} else {
			//System.out.println("No Components - Writing empty----");
			writeX3D("");
		}

		
		
		
		System.out.println("EndOfPaletteAction - returning Success!");

		// Stick the data into the Session so we can pick it up
		// when we return from another page
		session.put("paletteName", paletteName);
		session.put("bioMightComponents", bioMightSessionComponents);
		session.put("bioMightViewPoints", bioMightSessionViewPoints);
		return ("success");
	}

	/*****************************************************************************************
	 * GET VIEWPOINTS X3D
	 * 
	 * Set up the ViewPoint in the 3Dmodel based upon the user's specifications
	 *****************************************************************************************/

	public String getViewPointsX3D(String bioMightProjectName) {

		String body = "";
		int numElem = 0;

		if (bioMightViewPoints != null) {
			System.out.println("\nIn getViewPointsX3D - Size: " +  bioMightViewPoints.size());

			// There are multiple viewpoints into the X3D world
			for (int v = 0; v < bioMightViewPoints.size(); v++) {
				
				System.out.println("Getting ViewPoint Instance: " + v);
				BioMightViewPoint bioMightViewPoint = (BioMightViewPoint) bioMightViewPoints.get(v);
				System.out.println("Assembling BioMightViewPoints: " + v + " - " + bioMightViewPoint.getViewPointName());

				// Set up the ViewPoint - we can have multiple viewpoints per scene
				String bioViewPointGroup = "bioViewPointGroup" + v;
				body += "\n<Transform DEF='" + bioViewPointGroup + "'>\n";

				String bioViewPoint = "bioViewPoint" + v;
				body += "  <Viewpoint DEF='" + bioViewPoint + "'\n"
						+ "   containerField='children'\n"
						+ "   description='Moving Camera'\n" 
						+ "  jump='" +  bioMightViewPoint.isJump() 
						+ "'\n" 
						+ "  fieldOfView='" + "  " + bioMightViewPoint.getFieldOfView() 
						+ "'\n"
						+ "   position='" + bioMightViewPoint.getPositionStr()
						+ "'\n" 
						+ "   orientation='" + bioMightViewPoint.getOrientationStr()
						+ "'/>\n";

				body += "</Transform>\n\n";


				// Run through Master Animation List and place into the individual components based on...
				// the name that is placed in the HTML type field
				ArrayList masterAnimations = (ArrayList) bioMightViewPoint.getBioMightAnimations();
	
				System.out.println("Number of Animations for ViewPoint: " + v
						+ " is " + masterAnimations.size());
				
				for (int m=0; m < masterAnimations.size(); m++) {
				
					// Grab the next animation in the master list
					BioMightAnimation currentAnimation = (BioMightAnimation) masterAnimations.get(m);
					
					// Place those animations associated with the current ViewPoint into the
					// ViewPoints animation list.
					
					System.out.println("Checking Name: " + bioMightViewPoint.getViewPointName() + "   " + currentAnimation.getAnimationName());
					
					//if (bioMightViewPoint.getViewPointName().equals(currentAnimation.getAnimationName()) ) 
					//{
				
						int duration = 5;
						int startTime = 0;
						int endTime = 0;
						int speed = Constants.SLOW;
		
						// Set up the movements for each ViewPoint/Camera
						ArrayList bioMightAnimations = (ArrayList) bioMightViewPoint.getBioMightAnimations();
						System.out.println("Number of Animations for ViewPoint: " + v
								+ " is " + bioMightAnimations.size());
						
								
						for (int a = 0; a < bioMightAnimations.size(); a++) {
							BioMightAnimation bioMightAnimation = (BioMightAnimation) bioMightAnimations
									.get(a);
							System.out.println("Assembling ViewPoint Animation: " + a);
		
							try {
								startTime = Integer.parseInt(bioMightAnimation.getStartTimeStr());
								endTime = Integer.parseInt(bioMightAnimation.getEndTimeStr());
								System.out.println("StartTime: " + startTime + "   EndTime: " + endTime);
								System.out.println("StartPos " + bioMightAnimation.getStartPositionStr() + "  EndPos: " + bioMightAnimation.getEndPositionStr());
		
								duration = endTime - startTime;
								System.out.println("ViewPoint Duration: " + a + ": "+ endTime + " - " + startTime + " = " + duration);
							} catch (Exception e) {
								System.out.println("Setting Duration Default - 0");
								duration = 0;
							}
		
							// Set up the animation elements only if the duration is > 0
							if (duration > 0) {
			
								//body += "\n<TimeSensor DEF='" + bioViewPointTimer
								//		+ "'\n" + " containerField='children'\n "
								//		+ " cycleInterval='" + duration + "'\n "
								//		+ " loop='false' \n" + " startTime='0.0'> </TimeSensor>\n\n";
		
							
								// Camera
								// Setup the Timer that will drive the camera/viewpoint events
								String bioViewPointTimer = "BioViewPointTimer" + numElem;
								body += "\n<TimeSensor DEF='" + bioViewPointTimer + "'\n"
										+ " id='" + bioViewPointTimer + "'\n"
										+ " containerField='children'\n "
										+ " cycleInterval='" + duration + "'\n "
										+ " loop='false'> \n"
										+ "</TimeSensor> \n\n";
								
								// Set up a Java Script function to activate the animation
								x3dScript +=  
									"    document.getElementById('BioPalette__" + bioViewPointTimer + "').setAttribute('startTime',(  (new Date().getTime() / 1000)  + " + startTime + ").toString());\n"; 

								
								
								//********************************************************************
								// Position Interpolator
								//
								//********************************************************************
								String bioViewPointAnimation = "BioViewPointAnimation" + numElem;
								body += "\n<PositionInterpolator DEF='"
										+ bioViewPointAnimation + "'\n";
		
								// Determine the key and key values based upon
								// the start and end position and the duration of time
								String keys = BioGraphics.getVectorKeys(speed, 10);
								System.out.println("StartPos "
										+ bioMightAnimation.getStartPositionStr());
								System.out.println("EndPos "
										+ bioMightAnimation.getEndPositionStr());
		
								String keyVals = BioGraphics.getPositionKeyVals(speed,
										bioMightAnimation.getStartPosition(),
										bioMightAnimation.getEndPosition(), 10);
		
								body += keys + keyVals + "> </PositionInterpolator>\n\n";
		
								//body += "<ROUTE fromNode='" + bioViewPointScript
								//		+ "' fromField='" + bioScriptStartTime
								//		+ "' toNode='" + bioViewPointTimer
								//		+ "' toField='startTime'>  </ROUTE>\n\n"
										
								body += 	 "<ROUTE fromNode='" + bioViewPointTimer
										+ "' fromField='fraction_changed' toNode='"
										+ bioViewPointAnimation
										+ "' toField='set_fraction'>  </ROUTE>\n\n"
										
										+ "<ROUTE fromNode='" + bioViewPointAnimation
										+ "' fromField='value_changed' toNode='"
										+ bioViewPointGroup
										+ "' toField='set_translation'> </ROUTE>\n\n";
		
								
								// *********************************************************
								// Setup the Orientation Interpolator to account for
								// rotaton
								// **********************************************************
								String bioAnimation = "rotBioViewPointAnimation" + numElem;
								body += "<OrientationInterpolator DEF='" + bioAnimation
										+ "'\n";
		
								// Determine the key and key values based upon
								// the start and end position and the duration of time
								keys = BioGraphics.getVectorKeys(speed, 10);
								keyVals = BioGraphics.getRotationKeyVals(speed,
										bioMightAnimation.getStartOrientation(),
										bioMightAnimation.getEndOrientation(), 10);
								body += keys + keyVals + "> </OrientationInterpolator>\n\n";
		
								// Script sends start and events through this route
								// statement
								body +=
								// "<ROUTE fromNode='" + bioScript +
								// "' fromField='"+bioScriptStartTime+"' toNode='"+
								// bioTimer +"' toField='startTime'/>\n\n" +
								
								//"<ROUTE fromNode='" + bioViewPointTimer
								//		+ "' fromField='fraction_changed' toNode='"
								//		+ bioAnimation
								//		+ "' toField='set_fraction'>  </ROUTE>\n\n"
										
										 "<ROUTE fromNode='" + bioAnimation
										+ "' fromField='value_changed' toNode='"
										+ bioViewPointGroup + "' toField='set_rotation'> </ROUTE>\n\n";
								
								
								
								numElem++;
							}
		
						} // animation loop
					
					//}
					
					
				} //master animation loop

			} // Viewpoint loop
		}

		return (body);
	}

	/*************************************************************************************************** 
	 * GET COMPONENTS X3D
	 * 
	 * Run through the collection of Components and assemble the X3D. This will
	 * create all the objects in memory and set them on the pallete for artist
	 * manipulation.
	 * 
	 ****************************************************************************************************/

	public String getComponentsX3D() {

		String body = "";
		String domScript = "";
		
		if (bioMightComponents != null) 
		{
			// If we are kicking off via a TouchSensor,add it into ths scene
			// String bioTouchSensor = "BioTouchSensor"+ numElem;
			boolean bStartByTouch = false;
			if (bStartByTouch) {
				// body +=
				// "<TouchSensor DEF='" + bioTouchSensor + "'\n" +
				// " description='Palette Touch Sensor1'\n" +
				// " containerField='children'/> \n" ;
			}

			// Wrap each biomight component in a separate Transform object so
			// that we can move it about rather than rebuilding the entire components
			// at a location other than 0.0, 0.0, 0.0

			// Use the data that was entered on the Clock and in the form. Write
			// this into each of
			// the outer Transform's Time Animation data

			System.out.println("GetComponentsX3D() - CollectionSize is " + bioMightComponents.size());
			dumpComponents();
			
			
			int numElem = 0;
			int duration = 5;
			int startTime = 0;
			int endTime = 0;
			int speed = Constants.SLOW;
			


			for (int k = 0; k < bioMightComponents.size(); k++) {
				System.out.println("Palette-Getting next BioMightComponentView: " + k);
				BioMightComponent localBioMightComponent = (BioMightComponent) bioMightComponents.get(k);
				System.out.println("In Palette, Building ComponentX3D -   Pos: " + k + " - RefName: " + localBioMightComponent.getBioMightComponentRef());

				String bioGroup = "bioBioMightComponentGroup" + k;
				body += "\n<Transform DEF='" + bioGroup + "'\n";
				body += "  translation='" + localBioMightComponent.getPosition().getPositionStr() + "'\n";

				body += "  scale='" + localBioMightComponent.getScale().getScaleStr() + "'\n";

				body += "  rotation='" + localBioMightComponent.getOrientation().getOrientationStr() + "'>\n\n";

				// Create the component. This will get a fresh set of data from
				// the database
				// rather than just using what was currentlu on the display.
				localBioMightComponent = createBioMightComponent(localBioMightComponent);
				body += localBioMightComponent.getX3D();

				body += "\n\n</Transform>\n\n";

				// Collect the Animation that is associated with this
				// BioMightView
				ArrayList bioMightAnimations = (ArrayList) localBioMightComponent
						.getBioMightAnimations();
				System.out.println("NumAnimations for BioMightComponent: " + k
						+ " is: " + bioMightAnimations.size());

				for (int a = 0; a < bioMightAnimations.size(); a++) {
					System.out.println("Building BioMightComponent Animation: "
							+ a);

					try {
						BioMightAnimation localBioMightAnimation = (BioMightAnimation) localBioMightComponent
								.getBioMightAnimations().get(a);
						endTime = Integer.parseInt(localBioMightAnimation
								.getEndTimeStr());
						startTime = Integer.parseInt(localBioMightAnimation
								.getStartTimeStr());
						duration = endTime - startTime;
						System.out
								.println("Duration for bioMightComponent animation: "
										+ a
										+ "  "
										+ endTime
										+ "-"
										+ startTime
										+ "=" + duration);
					} catch (Exception e) {
						System.out
								.println("Time not specified. Setting Duration to 0");
						duration = 0;
					}

					
					// Set up the animation elements only if the duration is > 0
					if (duration > 0) {	 
						
						// Components
						// Setup the Timer that will drive the animation events
						String bioTimer = "bioTimer" + numElem;
						body += "\n<TimeSensor DEF='" + bioTimer + "'\n"
								+ " id='" + bioTimer + "'\n"
								+ " containerField='children'\n "
								+ " cycleInterval='" + duration + "'\n "
								+ " loop='false'> \n"
								+ "</TimeSensor> \n\n";
						
						// Set up a Java Script function to activate the animation
						x3dScript +=  
							"    document.getElementById('BioPalette__" + bioTimer + "').setAttribute('startTime',(  (new Date().getTime() / 1000)  + " + startTime + ").toString());\n"; 

						
						String bioAnimation = "posBioAnimation" + numElem;
						// ***************************************************************
						// Setup the Position Interpolator to account for
						// movement
						// ****************************************************************
						body += "<PositionInterpolator DEF='" + bioAnimation
								+ "'\n";

						// Determine the key and key values based upon
						// the start and end position and the duration of time
						String keys = BioGraphics.getVectorKeys(speed, 10);
						BioMightAnimation localBioMightAnimation = (BioMightAnimation) localBioMightComponent
								.getBioMightAnimations().get(a);
						String keyVals = BioGraphics.getPositionKeyVals(speed,
								localBioMightAnimation.getStartPosition(),
								localBioMightAnimation.getEndPosition(), 10);
						body += keys + keyVals + "> </PositionInterpolator>\n\n";

						// Script sends start and events through this route
						// statement
						//body += "<ROUTE fromNode='" + bioScript
						//		+ "' fromField='" + bioScriptStartTime
						//		+ "' toNode='" + bioTimer
						//		+ "' toField='startTime'>  </ROUTE>\n\n"
								
						body +=	  "<ROUTE fromNode='" + bioTimer
								+ "' fromField='fraction_changed' toNode='"
								+ bioAnimation
								+ "' toField='set_fraction'>  </ROUTE>\n\n"
								
								+ "<ROUTE fromNode='" + bioAnimation
								+ "' fromField='value_changed' toNode='"
								+ bioGroup
								+ "' toField='set_translation'> </ROUTE>\n\n";

						// *********************************************************
						// Setup the Orientation Interpolator to account for
						// rotaton
						// **********************************************************
						bioAnimation = "rotBioAnimation" + numElem;
						body += "<OrientationInterpolator DEF='" + bioAnimation
								+ "'\n";

						// Determine the key and key values based upon
						// the start and end position and the duration of time
						keys = BioGraphics.getVectorKeys(speed, 10);
						keyVals = BioGraphics.getRotationKeyVals(speed,
								localBioMightAnimation.getStartOrientation(),
								localBioMightAnimation.getEndOrientation(), 10);
						body += keys + keyVals + "> </OrientationInterpolator>\n\n";

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
								+ bioGroup + "' toField='set_rotation'> </ROUTE>\n\n";

						// *********************************************************
						// Setup the Scale Interpolator to account for rotaton
						// **********************************************************
						bioAnimation = "sizBioAnimation" + numElem;

						body += "<PositionInterpolator DEF='" + bioAnimation
								+ "'\n";

						// Determine the key and key values based upon
						// the start and end position and the duration of time
						keys = BioGraphics.getVectorKeys(speed, 10);

						keyVals = BioGraphics.getScalarKeyVals(speed,
								localBioMightAnimation.getStartScale(),
								localBioMightAnimation.getEndScale(), 10);
						body += keys + keyVals + "> </PositionInterpolator>\n\n";

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
								+ bioGroup + "' toField='set_scale'> </ROUTE>\n\n";
					} else {

					}

					numElem++;

				} // for animations

				if (bStartByTouch) {
					// body+=
					// "<ROUTE fromNode='"+ bioTouchSensor
					// +"' fromField='touchTime' toNode='"+ bioTimer
					// +"' toField='startTime'/>\n\n" ;
				}

			} // for viewpoints
			
		
			
		} // null

		// System.out.println("\n\n In Palette, BODY: " + body);
		return (body);
	}

	
	/************************************************************************************
	 * DUMP VIEWPOINTS
	 * 
	 * Dump the data
	 * 
	 ***********************************************************************************/

	public void dumpViewPoints() {

		if (bioMightViewPoints != null) {

			System.out.println("\nDumpViewPoint");
			// An animation can have multiple Viewpoints. We
			// Grab the information for those viewpoints from the user here
			for (int k = 0; k < bioMightViewPoints.size(); k++) {
				BioMightViewPoint bioMightViewPoint = (BioMightViewPoint) bioMightViewPoints
						.get(k);
				System.out.println("DumpViewPoint: " + k);

				System.out.println("VP Position: "
						+ bioMightViewPoint.getPositionStr());
				System.out.println("VP Orientation: "
						+ bioMightViewPoint.getOrientationStr());
				System.out.println("VP pov: "
						+ bioMightViewPoint.getFieldOfViewStr());

				// The viewpoint can be moved around several times and at
				// different intervals.
				// We will create one Clock for each ViewPoint.
				ArrayList bioMightAnimations = (ArrayList) bioMightViewPoint
						.getBioMightAnimations();
				System.out.println("NumViewPointAnimations: "
						+ bioMightAnimations.size() + "  for ViewPoint: " + k);
				for (int a = 0; a < bioMightAnimations.size(); a++) {
					System.out.println("DumpViewPoint: " + k + " Animation: "
							+ a);

					// Stuff the values from the FORM into the ViewPoint
					// Animation object
					BioMightAnimation bioMightAnimation = (BioMightAnimation) bioMightAnimations
							.get(a);
					System.out.println("startTime: "
							+ bioMightAnimation.getStartTimeStr());
					System.out.println("endTime: "
							+ bioMightAnimation.getEndTimeStr());
					System.out.println("startPos: "
							+ bioMightAnimation.getStartPositionStr());
					System.out.println("endPos: "
							+ bioMightAnimation.getEndPositionStr());
					System.out.println("startO: "
							+ bioMightAnimation.getStartOrientationStr());
					System.out.println("endO: "
							+ bioMightAnimation.getEndOrientationStr());

				}

			} // for loop

		}

	}
	
	/************************************************************************************
	 * DUMP COMPONENTS
	 * 
	 * Dump the Components
	 * 
	 ***********************************************************************************/

	public void dumpComponents() {

		if (bioMightComponents != null) {

			System.out.println("DUMP COMPS --- NumComponentAnimations: "
					+ bioMightComponents.size());
			// An animation can have multiple Viewpoints. We
			// Grab the information for those viewpoints from the user here
			for (int k = 0; k < bioMightComponents.size(); k++) {
				BioMightComponent bioMightComponent = (BioMightComponent) bioMightComponents.get(k);
				System.out.println("DumpComponent: " + k);
				System.out.println("Component Name: " + bioMightComponent.getBioMightComponentName());
				System.out.println("Component Ref: " + bioMightComponent.getBioMightComponentRef());
				System.out.println("Component Type: " + bioMightComponent.getBioMightComponentType());
				System.out.println("Component Parent: " + bioMightComponent.getBioMightComponentParent());
				System.out.println("BuildComponentType: " + bioMightComponent.getBioMightBuildComponentType());
				System.out.println("Component ID: " + bioMightComponent.getBioMightComponentID());
				System.out.println("Component Position: "  + bioMightComponent.getPosition().getPositionStr());

				// The viewpoint can be moved around several times and at
				// different intervals.
				// We will create one Clock for each Component.
				ArrayList bioMightAnimations = (ArrayList) bioMightComponent.getBioMightAnimations();
				System.out.println("NumComponentAnimations: " + bioMightAnimations.size() + "  for Component: " + k);
				for (int a = 0; a < bioMightAnimations.size(); a++) 
				{
					System.out.println("DumpComponent : " + k + " Animation: " + a);

					// Stuff the values from the FORM into the Component
					// Animation object
					BioMightAnimation bioMightAnimation = (BioMightAnimation) bioMightAnimations
							.get(a);
					System.out.println("startTime: "
							+ bioMightAnimation.getStartTimeStr());
					System.out.println("endTime: "
							+ bioMightAnimation.getEndTimeStr());
					System.out.println("startPos: "
							+ bioMightAnimation.getStartPositionStr());
					System.out.println("endPos: "
							+ bioMightAnimation.getEndPositionStr());
					System.out.println("startOrientation: "
							+ bioMightAnimation.getStartOrientationStr());
					System.out.println("endOrientation: "
							+ bioMightAnimation.getEndOrientationStr());

				}

			} // for loop

		}

	}

	/************************************************************************************
	 * DUMP ANIMATION
	 * 
	 * Dump the data
	 * 
	 ***********************************************************************************/

	public void dumpAnimations(ArrayList bioMightAnimations) {

		System.out.println("DUMP ANIM --- NumViewPointAnimations: "
				+ bioMightAnimations.size());
		for (int a = 0; a < bioMightAnimations.size(); a++) {
			System.out.println("Dump Animation: " + a);
			BioMightAnimation bioMightAnimation = (BioMightAnimation) bioMightAnimations
					.get(a);
			System.out.println("startTime: "
					+ bioMightAnimation.getStartTimeStr());
			System.out.println("endTime: " + bioMightAnimation.getEndTimeStr());
			System.out.println("startPos: "
					+ bioMightAnimation.getStartPositionStr());
			System.out.println("endPos: "
					+ bioMightAnimation.getEndPositionStr());
			System.out.println("startO: "
					+ bioMightAnimation.getStartOrientationStr());
			System.out.println("endO: "
					+ bioMightAnimation.getEndOrientationStr());
		}
	}

	/************************************************************************************
	 * DUMP VIEWPOINT
	 * 
	 * Dump the data
	 * 
	 ***********************************************************************************/

	public void dumpViewPoint(BioMightViewPoint bioMightViewPoint) {
		System.out.println("DumpVP Position: "
				+ bioMightViewPoint.getPositionStr());
		System.out.println("VP Orientation: "
				+ bioMightViewPoint.getOrientationStr());
		System.out.println("VP pov: " + bioMightViewPoint.getFieldOfViewStr());

		// The viewpoint can be moved around several times and at different
		// intervals.
		// We will create one Clock for each ViewPoint.
		ArrayList bioMightAnimations = (ArrayList) bioMightViewPoint
				.getBioMightAnimations();
		System.out.println("NumViewPointAnimations: "
				+ bioMightAnimations.size() + "  for ViewPoint: "
				+ bioMightViewPoint.getViewPointName());
		for (int a = 0; a < bioMightAnimations.size(); a++) {
			System.out.println("Dump Animation: " + a);
			BioMightAnimation bioMightAnimation = (BioMightAnimation) bioMightAnimations
					.get(a);
			System.out.println("startTime: "
					+ bioMightAnimation.getStartTimeStr());
			System.out.println("endTime: " + bioMightAnimation.getEndTimeStr());
			System.out.println("startPos: "
					+ bioMightAnimation.getStartPositionStr());
			System.out.println("endPos: "
					+ bioMightAnimation.getEndPositionStr());
			System.out.println("startO: "
					+ bioMightAnimation.getStartOrientationStr());
			System.out.println("endO: "
					+ bioMightAnimation.getEndOrientationStr());
		}
	}

	/************************************************************************************
	 * Write X3D
	 * 
	 * Writes the X3D out to a file called palette for this pre-dev phase
	 * 
	 * 
	 ***********************************************************************************/
	private void writeX3D(String X3D) {
		
		// If the X3D is defined,
		// Dump the X3D data to a file to be rendered in the browser
		// System.out.println("Checking X3D for: " + bioMightComponentName);

		String footer = "</Scene>\n" + "</X3D>\n";
		String header = getHeader(bioMightProjectName);

		if (paletteName.equals(""))
		{
			 int myRandomNumber = (int) (Math.random() * 10000);
			 paletteName = "palette" + myRandomNumber;
		}
		 
		//String fileName =  request.getSession().getServletContext().getRealPath("/") + "x3d\\palette.x3d";
		String fileName = request.getSession().getServletContext().getRealPath("/") + "x3d\\" + paletteName + ".x3d";
		System.out.println("Writing X3D to: " + fileName);
		 
		try {
			File myFile = new File(fileName);
			boolean exists = myFile.exists();
			if (exists) {
				myFile.delete();
				//System.out.println("Deleted the Current file.");
			}
		} catch (Exception e) {
			System.out.println("There was error deleting the file.");
		}

		// Output the X3D to a file to be loaded by the browser
		try {
			X3D = header + X3D + footer;
			BufferedWriter out = new BufferedWriter(
			new FileWriter(fileName));
			out.write(X3D);
			out.flush();
			out.close();
		} catch (Exception e) {
			System.out.println("Error writing out X3D file!");
		}

		try {
			File myFile = new File(fileName);
			// System.out.println("Created post FILE object");
			boolean exists = myFile.exists();
			//System.out.println("New X3D FILE Exists:" + exists   +  "   Readable: "  + myFile.setReadable(true));
		} catch (Exception e) {
			System.out.println("There was error reading the new file.");
		}
		

	}

	/*****************************************************************************************
	 * CREATE BIOMIGHT COMPONENT
	 * 
	 * In reality - we have all the data we need to render the objects on the
	 * pallette In a multiuser usage we should always be reading the data from
	 * the database on each page refresh. This swaps the current component data
	 * with the data that was last saved to the database
	 * 
	 ****************************************************************************************/

	private BioMightComponent createBioMightComponent(
			BioMightComponent localBioMightComponent) {

		// All objects in the palette should be generated as snippets
		// they will be combines into 1 world scene
		boolean snippet = true;

		// Declare the base and configuration classes
		Class bioMightClass = null;

		// Class bioMightConfigClass = null;
		Object bioMightInstance = null;

		// Get the BioMightKeys from the session. The Keys keep track of the
		// current
		// linear path that one has taken. The keys are stored in a hashmap and
		// are
		// labeled 1,2,3....n
		BioMightKeys bioMightKeys = null;
		// Set up a holder for the current key
		BioMightKey bioMightKey;

		// If the keys are not defined, then this is the
		// first time in. Set up the keys with the default values
		if (bioMightKeys == null) {
			bioMightKeys = new BioMightKeys();
			bioMightKey = new BioMightKey();
			//System.out.println("Keys are null - First time in, Created Keys");
		} else {
			//System.out.println("There are Keys!");
			// System.out.println("Parent for : " + localBioMightComponentType +
			// "   is: " + bioMightComponentParentID);
			bioMightKey = new BioMightKey();
		}

		try {
			System.out.println("Creating BioMightComponent with ParentID: "
					+ localBioMightComponent.getBioMightComponentParentID()
					+ "   "
					+ localBioMightComponent.getBioMightComponentParent());

			// Create a Class Object the represents the biomight object
			System.out.println("Doing ClassForName: "
					+ localBioMightComponent.getBioMightComponentRef());

			bioMightClass = Class.forName(localBioMightComponent
					.getBioMightComponentRef());
			System.out.println("Created BioMight Class: "
					+ localBioMightComponent.getBioMightComponentRef());
			if (bioMightClass == null)
				System.out.println("Palette - BioMight Class is null: "
						+ localBioMightComponent.getBioMightComponentRef());
			else
				System.out.println("Palette - Class is cool: " + bioMightClass.getName());

			// Create an instance of the class
			// The class will start up using it last persistent model
			// bioMightInstance = bioMightClass.newInstance();
			System.out.println("Palette - Creating BioMight Instance: "
					+ localBioMightComponent.getBioMightComponentRef() + " "
					+ localBioMightComponent.getBioMightComponentName());
			
			Constructor constructor = bioMightClass.getConstructor(new Class[] 
					{int.class, int.class, new String().getClass(), new ArrayList().getClass(), new ArrayList().getClass() });
			
			int localVP = Constants.VIEW_HAWKEYE;
			// Only grab the parent record as we arenot going deep
			int localLOD = Constants.MAG1X;
			bioMightInstance = constructor.newInstance(new Object[] {
					localVP, localLOD, 
					localBioMightComponent.getBioMightComponentParentID(),
					localBioMightComponent.getBioMightProperties(),
					localBioMightComponent.getBioMightMethods() });	
			
			
			System.out.println("Palette - Created BioMight Instance: "
					+ localBioMightComponent.getBioMightComponentRef());
		} catch (ClassNotFoundException e) {
			System.out.println("Palette - BioMight Object not found: "
					+ localBioMightComponent.getBioMightComponentRef());
		} catch (Exception e) {
			System.out.println("Palette - BioMight Exception Creating Class: "
					+ localBioMightComponent.getBioMightComponentRef());
		}

		// Store the object and object reference in the form
		localBioMightComponent.setBioMightKeys(bioMightKeys);

		System.out.println("Storing Component Keys in the View!");
		BioMightViewMapper bioMightViewMapper = new BioMightViewMapper();
		localBioMightComponent = bioMightViewMapper.mapComponent(
				localBioMightComponent, bioMightInstance, snippet);

		System.out.println("Palette - Returning BioMightComponent! ");
		return localBioMightComponent;
	}

	/*************************************************************************************************
	 * GET BIOMIGHT COMPONENT
	 * 
	 * Get the Current data from the database
	 * 
	 ************************************************************************************************/

	private void getBioMightComponentData() {

		BioMightTransforms bioMightTransforms;

		BioMightBeanLocal bioMightBean;

		// Get the information from the database via the Enterprise Bean
		try {
			// Get the information from the database via the Enterprise Bean
			System.out.println("Getting Palette Info");
			// InitialContext ctx = new InitialContext();
			// bioMightBean = (BioMightBeanLocal)
			// ctx.lookup("java:global/BioMightWeb/BioMightBean!biomight.ejb.BioMightBeanLocal");
			// bioMightTransforms = bioMightBean.getComponentsHist("", "");
			// Context ctx = EJBContainer.createEJBContainer().getContext();
			// System.out.println("Have Context");
			// bioMightBean = (BioMightBeanLocal)
			// ctx.lookup("biomight.ejb.BioMightBeanLocal");
			System.out.println("Have Palette Objects from EJB");
		} catch (Exception e) {
			System.out.println("Exception Getting Components - Iris");
			// throw new ServerException("Remote Exception getComponents():",
			// e);
		}

		// Run through the collection of Pupils and build them into the model
		// In the default case, we get one instance of the Pupil for each eye
		ArrayList transforms = null; // bioMightTransforms.getTransforms();
		System.out.println("Have Palette NumTransforms: " + transforms.size());
		for (int i = 0; i < transforms.size(); i++) {
			// Get the information for the eye we are creating
			BioMightTransform bioMightTransform = (BioMightTransform) transforms
					.get(i);
			System.out.println("Creating (name,id): "
					+ bioMightTransform.getName() + "  "
					+ bioMightTransform.getId());
			String componentID = bioMightTransform.getId();

			System.out.println("Getting : " + bioMightTransform.getId());

		}

		System.out.println("Assembly Completed");

	}

	private String getHeader(String bioMightProjectName) {

		// Assemble the Body
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		Date date = new Date();
		String exportDate = dateFormat.format(date);
		
		dateFormat = new SimpleDateFormat("HH:mm:ss");
		date = new Date();
		String exportTime = dateFormat.format(date);
		
		String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"
				+ "<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n "
				+ "<X3D profile='Full' >\n" + "<head>\n"
				+ "<meta name='BioMightImage' content=''/>\n"
				+ "<meta name='ExportTime' content='" +  exportTime +  "'/>\n" 
				+ "<meta name='ExportDate' content='" + exportDate  +  "'/>\n" 
				+ "</head>\n" + "<Scene>\n" + "<WorldInfo\n" + "title='"
				+ bioMightProjectName + "'\n"
				+ "info='\"BioMight Generated X3D\"'/>\n\n";
				
				//+ "<Background skyColor='1 1 1'/>" + "\n\n";


		return header;
	}

	public Map getSession() {
		return session;
	}

	public void setSession(Map session) {
		this.session = session;
	}

	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	public HttpServletRequest getServletRequest() {
		return this.request;
	}

	public Map getParameters() {
		return pMap;
	}

	public void setParameters(Map inMap) {
		// System.out.println("-----Here are parameters--------");
		// Iterator iterator = inMap.entrySet().iterator();
		// while (iterator.hasNext()) {
		// Map.Entry entry = (Map.Entry) iterator.next();
		// System.out.println("Key: " + entry.getKey() + "   value: " +
		// entry.getValue());
		// }
		pMap = inMap;
		// System.out.println("-----Internal Map is Set--------");
	}

	public String getPageAction() {
		return pageAction;
	}

	public void setPageAction(String pageAction) {
		this.pageAction = pageAction;
	}

	public String getBioMightProjectName() {
		return bioMightProjectName;
	}

	public void setBioMightProjectName(String bioMightProjectName) {
		this.bioMightProjectName = bioMightProjectName;
	}

	public String getBioMightProjectID() {
		return bioMightProjectID;
	}

	public void setBioMightProjectID(String bioMightProjectID) {
		this.bioMightProjectID = bioMightProjectID;
	}

	public int getBioMightComponentPick() {
		return bioMightComponentPick;
	}

	public void setBioMightComponentPick(int componentPick) {
		this.bioMightComponentPick = componentPick;
	}

	public BioMightComponent getBioMightComponent() {
		return bioMightComponent;
	}

	public void setBioMightComponent(BioMightComponent bioMightComponent) {
		this.bioMightComponent = bioMightComponent;
	}

	public List getBioMightComponents() {
		return bioMightComponents;
	}

	public void setBioMightComponents(List bioMightComponents) {
		this.bioMightComponents = bioMightComponents;
	}

	public List getBioMightViewPoints() {
		return bioMightViewPoints;
	}

	public void setBioMightViewPoints(List bioMightViewPoints) {
		this.bioMightViewPoints = bioMightViewPoints;
	}

	public BioMightViewPoint getBioMightViewPoint() {
		return bioMightViewPoint;
	}

	public void setBioMightViewPoint(BioMightViewPoint bioMightViewPoint) {
		this.bioMightViewPoint = bioMightViewPoint;
	}

	public String getPaletteName() {
		return paletteName;
	}

	public void setPaletteName(String paletteName) {
		this.paletteName = paletteName;
	}

	public String getX3dScript() {
		return x3dScript;
	}

	public void setX3dScript(String x3dScript) {
		this.x3dScript = x3dScript;
	}
	

	public InputStream getFileInputStream() {
		return fileInputStream;
	}
	
	public void setFileInputStream(InputStream fileInputStream) {
		this.fileInputStream = fileInputStream;
	}


	public String getExportFile() {
		return exportFile;
	}

	public void setExportFile(String exportFile) {
		this.exportFile = exportFile;
	}

	public double getExportFileSize() {
		return exportFileSize;
	}

	public void setExportFileSize(double exportFileSize) {
		this.exportFileSize = exportFileSize;
	}

	/******************************************************************************************************************
	 * Dump Methods
	 * 
	 * 
	 * ****************************************************************************************************************/
	
	public void dumpMethods() 
	{
		
		if (bioMightComponent.getBioMightMethods() != null && bioMightComponent.getBioMightMethods().size() > 0)
		{
			System.out.println("Methods Are-----");
			
			for (int i=0; i<bioMightComponent.getBioMightMethods().size(); i++)
			{
				BioMightMethodView methodView = (BioMightMethodView) bioMightComponent.getBioMightMethods().get(i);
				System.out.println("Name: " + methodView.getMethodName());
				System.out.println("DisplayName: " + methodView.getDisplayName());
				System.out.println("CanonicalName: " + methodView.getCanonicalName());
				System.out.println("Parameter: " + methodView.getMethodParameter());
				System.out.println("HtmlType: " + methodView.getHtmlType());
				System.out.println("DataType: " + methodView.getDataType());
			}
		}	
		else
			System.out.println("No Methods Are Defined");
	
	}
}
