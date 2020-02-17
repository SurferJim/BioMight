/*
 * Created on Feb 4, 2007
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomightweb.view;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import biomight.BioMightKeys;
import biomight.Constants;
import biomight.view.BioMightAnimation;
import biomight.view.BioMightMethodView;
import biomight.view.BioMightOrientation;
import biomight.view.BioMightPosition;
import biomight.view.BioMightPropertyView;
import biomight.view.BioMightScale;


/******************************************************************************
 * @author SurferJim
 *
 * BioMight Component Object
 * 
 *****************************************************************************/
public class BioMightComponent implements Serializable {

	private String bioMightComponentID = "";	
	private String bioMightComponentType = "";
	private String bioMightComponentName = "";
	private String bioMightComponentRef = "";
	private String bioMightComponentDesc ="";
	private String bioMightComponentParent = "";
	private String bioMightComponentParentID = "";
	private String bioMightComponentParentRef = "";
	private String bioMightBuildComponentType = "";
	private boolean bioMightCollection = false;

	private BioMightPosition position;
	private BioMightOrientation orientation;
	private BioMightScale scale;
	
	private String bioMightConfigObject = "";
	private String image = "";
	private String x3D = "";
	private ArrayList<String> images;
	private String bioMightTemplate = "";
	private BioMightKeys bioMightKeys;
	
	
	// These are used in the visual interface to determine if
	// these components are expanded or contracted view
	//private boolean tissueExpand = false;
	//private boolean muscleExpand = false;
	//private boolean bonesExpand = false;
	
	private int width = 0;
	private int height = 0;

	private String bioMightPropertyTitle;
	private List<BioMightPropertyView> bioMightProperties = null;
	private List<BioMightMethodView> bioMightMethods = null;
	
	// Each object can move around through time.
	private List<BioMightAnimation> bioMightAnimations;

	// Default Constructor
	public BioMightComponent() 
	{
		System.out.println("Constructor - BioMightComponent");
		position = new BioMightPosition(0.0, 0.0, 0.0);		
		orientation = new BioMightOrientation(0.0, 0.0, 0.0, 0.0);
		scale = new BioMightScale(1.0, 1.0, 1.0);
		bioMightAnimations = new ArrayList();
	
		BioMightAnimation bioMightAnimation = null;
		int startTime = 0;
		int endTime = 0;
		double startPOV =  0.50;
		double endPOV = 0.50;
		
		BioMightPosition startPosition = new BioMightPosition("0.0, 0.0, 0.0");
		BioMightPosition endPosition = new BioMightPosition("0.0, 0.0, 0.0");
		BioMightOrientation startOrientation = new BioMightOrientation("0.0, 0.0, 0.0, 0.0");
		BioMightOrientation endOrientation = new BioMightOrientation("0.0, 0.0, 0.0, 0.0");
		BioMightScale startScale = new BioMightScale("1.0, 1.0, 1.0");
		BioMightScale endScale = new BioMightScale("1.0, 1.0, 1.0");
		bioMightAnimation = new BioMightAnimation("Component:0", "Animate1", Constants.TRANSLATE,  startTime,  endTime,   
					startPosition, endPosition, startOrientation, endOrientation, startScale, endScale, startPOV, endPOV);
		bioMightAnimations.add(bioMightAnimation);
		
		startPosition = new BioMightPosition("0.0, 0.0, 0.0");
		endPosition = new BioMightPosition("0.0, 0.0, 0.0");
		startOrientation = new BioMightOrientation("0.0, 0.0, 0.0, 0.0");
		endOrientation = new BioMightOrientation("0.0, 0.0, 0.0, 0.0");
		startScale = new BioMightScale("1.0, 1.0, 1.0");
		endScale = new BioMightScale("1.0, 1.0, 1.0");
		bioMightAnimation = new BioMightAnimation("Component:0", "Animate2", Constants.TRANSLATE,  startTime,  endTime,   
					startPosition, endPosition, startOrientation, endOrientation, startScale, endScale, startPOV, endPOV);
		bioMightAnimations.add(bioMightAnimation);

		startPosition = new BioMightPosition("0.0, 0.0, 0.0");
		endPosition = new BioMightPosition("0.0, 0.0, 0.0");
		startOrientation = new BioMightOrientation("0.0, 0.0, 0.0, 0.0");
		endOrientation = new BioMightOrientation("0.0, 0.0, 0.0, 0.0");
		startScale = new BioMightScale("1.0, 1.0, 1.0");
		endScale = new BioMightScale("1.0, 1.0, 1.0");
		bioMightAnimation = new BioMightAnimation("Component:0", "Animate3", Constants.TRANSLATE,  startTime,  endTime,   
					startPosition, endPosition, startOrientation, endOrientation, startScale, endScale, startPOV, endPOV);
		bioMightAnimations.add(bioMightAnimation);
		
		// Allocate so thy are not null
		bioMightProperties = new ArrayList<BioMightPropertyView>(0);
		bioMightMethods = new ArrayList<BioMightMethodView>(0);
		
		//System.out.println("Constructor - BioMightComponent - Completed");
	}
	
	
	// Set up a Base BioMightView Object
	public BioMightComponent(String bioMightComponentID, String bioMightComponentName,  String bioMightComponentRef, 
							 String bioMightComponentParent, String bioMightComponentParentID, String bioMightBuildComponentType) 
	{	
			this.bioMightComponentID = bioMightComponentID;	
			this.bioMightComponentName = bioMightComponentName;
			this.bioMightComponentRef = bioMightComponentRef;
			this.bioMightComponentParent = bioMightComponentParent;
			this.bioMightComponentParentID = bioMightComponentParentID;	
			this.bioMightBuildComponentType = bioMightBuildComponentType;	
			
			// Allows the user to set Palette Position, Scale, and Orientation
			this.position = new BioMightPosition(0.0, 0.0, 0.0);
			this.orientation = new BioMightOrientation(0.0, 0.0, 0.0, 0.00);
			this.scale = new BioMightScale(1.0, 1.0, 1.0);
			
			int startTime = 0;
			int endTime = 4;
			double startPOV =  0.50;
			double endPOV = 0.50;
			
			bioMightAnimations = new ArrayList();
			BioMightAnimation bioMightAnimation = null;
			
			BioMightPosition startPosition = new BioMightPosition("0.0, 0.0, 0.0");
			BioMightPosition endPosition = new BioMightPosition("0.0, 0.0, 0.0");
			BioMightOrientation startOrientation = new BioMightOrientation("0.0, 0.0, 0.0, 0.0");
			BioMightOrientation endOrientation = new BioMightOrientation("0.0, 0.0, 0.0, 0.0");
			BioMightScale startScale = new BioMightScale("1.0, 1.0, 1.0");
			BioMightScale endScale = new BioMightScale("1.0, 1.0, 1.0");
			bioMightAnimation = new BioMightAnimation("Component:0", "Animate1", Constants.TRANSLATE,  startTime,  endTime,   
						startPosition, endPosition, startOrientation, endOrientation, startScale, endScale, startPOV, endPOV);
			bioMightAnimations.add(bioMightAnimation);
			
			startPosition = new BioMightPosition("0.0, 0.0, 0.0");
			endPosition = new BioMightPosition("0.0, 0.0, 0.0");
			startOrientation = new BioMightOrientation("0.0, 0.0, 0.0, 0.0");
			endOrientation = new BioMightOrientation("0.0, 0.0, 0.0, 0.0");
			startScale = new BioMightScale("1.0, 1.0, 1.0");
			endScale = new BioMightScale("1.0, 1.0, 1.0");
			bioMightAnimation = new BioMightAnimation("Component:0", "Animate2", Constants.TRANSLATE,  startTime,  endTime,   
						startPosition, endPosition, startOrientation, endOrientation, startScale, endScale, startPOV, endPOV);
			bioMightAnimations.add(bioMightAnimation);

			startPosition = new BioMightPosition("0.0, 0.0, 0.0");
			endPosition = new BioMightPosition("0.0, 0.0, 0.0");
			startOrientation = new BioMightOrientation("0.0, 0.0, 0.0, 0.0");
			endOrientation = new BioMightOrientation("0.0, 0.0, 0.0, 0.0");
			startScale = new BioMightScale("1.0, 1.0, 1.0");
			endScale = new BioMightScale("1.0, 1.0, 1.0");
			bioMightAnimation = new BioMightAnimation("Component:0", "Animate3", Constants.TRANSLATE,  startTime,  endTime,   
						startPosition, endPosition, startOrientation, endOrientation, startScale, endScale, startPOV, endPOV);
			bioMightAnimations.add(bioMightAnimation);

			
			bioMightProperties = new ArrayList<BioMightPropertyView>(0);
			bioMightMethods = new ArrayList<BioMightMethodView>(0);
	}
		
	
		

	/**
	 * @return
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * @return
	 */
	public String getImage() {
		return image;
	}

	/**
	 * @return
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * @param i
	 */
	public void setHeight(int i) {
		height = i;
	}

	/**
	 * @param string
	 */
	public void setImage(String string) {
		image = string;
	}

	/**
	 * @param i
	 */
	public void setWidth(int i) {
		width = i;
	}

	public String getBioMightConfigObject() {
		return bioMightConfigObject;
	}

	public void setBioMightConfigObject(String biomightConfigObject) {
		this.bioMightConfigObject = biomightConfigObject;
	}

	
	public String getX3D() {
		return x3D;
	}

	public void setX3D(String x3d) {
		x3D = x3d;
	}
	
	
	
	public void collapseProperties(String propertyTitle)
	{
		boolean bFound = false;
		for (int i=0; i< bioMightProperties.size(); i++)
		{
			BioMightPropertyView property = (BioMightPropertyView) bioMightProperties.get(i);
			
			if (bFound && property.getCanonicalName().equals(Constants.Title))
				bFound=false;
		
			if (property.getCanonicalName().equals(Constants.Title) && property.getPropertyName().equals(propertyTitle))
				bFound=true;
	
			if (bFound)
			{
				property.setViewEnabled(true);
				bioMightProperties.set(i, (BioMightPropertyView) property);
			}
		}
	}

	
	public void expandProperties(String propertyTitle)
	{
		boolean bFound = false;
		for (int i=0; i< bioMightProperties.size(); i++)
		{
			BioMightPropertyView property = (BioMightPropertyView) bioMightProperties.get(i);
			
			if (bFound && property.getCanonicalName().equals(Constants.Title))
				bFound=false;
		
			if (property.getCanonicalName().equals(Constants.Title) && property.getPropertyName().equals(propertyTitle))
				bFound=true;
	
			if (bFound)
			{
				property.setViewEnabled(false);
				bioMightProperties.set(i, (BioMightPropertyView) property);
			}
		}
	}
	

	public ArrayList getImages() {
		return images;
	}

	public void setImages(ArrayList images) {
		this.images = images;
	}

	public String getBioMightTemplate() {
		return bioMightTemplate;
	}

	public void setBioMightTemplate(String bioMightTemplate) {
		this.bioMightTemplate = bioMightTemplate;
	}

	public BioMightKeys getBioMightKeys() {
		return bioMightKeys;
	}

	public void setBioMightKeys(BioMightKeys bioMightKeys) {
		this.bioMightKeys = bioMightKeys;
	}

	public String getBioMightComponentID() {
		return bioMightComponentID;
	}

	public void setBioMightComponentID(String bioMightComponentID) {
		this.bioMightComponentID = bioMightComponentID;
	}

	public String getBioMightComponentRef() {
		return bioMightComponentRef;
	}

	public void setBioMightComponentRef(String bioMightComponentRef) {
		this.bioMightComponentRef = bioMightComponentRef;
	}

	public String getBioMightComponentParent() {
		return bioMightComponentParent;
	}

	public void setBioMightComponentParent(String bioMightComponentParent) {
		this.bioMightComponentParent = bioMightComponentParent;
	}

	public String getBioMightComponentParentID() {
		return bioMightComponentParentID;
	}

	public void setBioMightComponentParentID(String bioMightComponentParentID) {
		this.bioMightComponentParentID = bioMightComponentParentID;
	}


	public String getBioMightComponentName() {
		return bioMightComponentName;
	}

	public void setBioMightComponentName(String bioMightComponentName) {
		this.bioMightComponentName = bioMightComponentName;
	}

	public BioMightPosition getPosition() {
		return position;
	}


	public void setPosition(BioMightPosition position) {
		this.position = position;
	}


	public BioMightOrientation getOrientation() {
		return orientation;
	}


	public void setOrientation(BioMightOrientation orientation) {
		this.orientation = orientation;
	}


	public BioMightScale getScale() {
		return scale;
	}


	public void setScale(BioMightScale scale) {
		this.scale = scale;
	}


	public List getBioMightAnimations() {
		return bioMightAnimations;
	}


	public void setBioMightAnimations(List bioMightAnimations) {
		this.bioMightAnimations = bioMightAnimations;
	}


	public String getBioMightComponentType() {
		return bioMightComponentType;
	}


	public void setBioMightComponentType(String bioMightComponentType) {
		this.bioMightComponentType = bioMightComponentType;
	}


	public String getBioMightComponentDesc() {
		return bioMightComponentDesc;
	}


	public void setBioMightComponentDesc(String bioMightComponentDesc) {
		this.bioMightComponentDesc = bioMightComponentDesc;
	}


	public String getBioMightComponentParentRef() {
		return bioMightComponentParentRef;
	}


	public void setBioMightComponentParentRef(String bioMightComponentParentRef) {
		this.bioMightComponentParentRef = bioMightComponentParentRef;
	}


	public boolean isBioMightCollection() {
		return bioMightCollection;
	}


	public void setBioMightCollection(boolean bioMightCollection) {
		this.bioMightCollection = bioMightCollection;
	}


	public ArrayList getBioMightProperties() {
		return (ArrayList) bioMightProperties;
	}


	public void setBioMightProperties(ArrayList bioMightProperties) {
		this.bioMightProperties = bioMightProperties;
	}


	public ArrayList getBioMightMethods() {
		return (ArrayList) bioMightMethods;
	}


	public void setBioMightMethods(ArrayList bioMightMethods) {
		this.bioMightMethods = bioMightMethods;
	}


	public String getBioMightPropertyTitle() {
		return bioMightPropertyTitle;
	}


	public void setBioMightPropertyTitle(String bioMightPropertyTitle) {
		this.bioMightPropertyTitle = bioMightPropertyTitle;
	}
	
	

	public String getBioMightBuildComponentType() {
		return bioMightBuildComponentType;
	}


	public void setBioMightBuildComponentType(String bioMightBuildComponentType) {
		this.bioMightBuildComponentType = bioMightBuildComponentType;
	}


	public void dumpProperties()
	{
		for (int i=0; i<bioMightProperties.size(); i++)
		{
			BioMightPropertyView  bioMightPropertyView = (BioMightPropertyView) bioMightProperties.get(i);
			String props =  
					  bioMightPropertyView.getPropertyID() + "', '" 
					+ bioMightPropertyView.getPropertyType() + "', '" 
					+ bioMightPropertyView.getPropertyName() + "', '"
					+ bioMightPropertyView.getCanonicalName() + "',  '"
					+ bioMightPropertyView.getPropertyRef() + "',  '"
					+ bioMightPropertyView.getPropertyDesc() + ", "
					+ bioMightPropertyView.isViewEnabled() ; 
			System.out.println("Props " + props);
		}
		
	}
	
	
	/******************************************************************************************************************
	 * Dump Methods
	 * 
	 * 
	 * ****************************************************************************************************************/
	
	public void dumpMethods() 
	{
		
		if (getBioMightMethods().size() > 0)
		{
			System.out.println("\nMethods Are-----");
			
			for (int i=0; i<getBioMightMethods().size(); i++)
			{
				BioMightMethodView methodView = (BioMightMethodView) getBioMightMethods().get(i);
				System.out.println("Name: " + methodView.getMethodName());
				System.out.println("DisplayName: " + methodView.getDisplayName());
				System.out.println("CanonicalName: " + methodView.getCanonicalName());
				System.out.println("Parameter: " + methodView.getMethodParameter());
				System.out.println("HtmlType: " + methodView.getHtmlType());
				System.out.println("DataType: " + methodView.getDataType() + "\n");
			}
		}	
		else
			System.out.println("No Methods Are Defined");
	
	}

	
	
}
