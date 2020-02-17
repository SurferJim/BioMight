package biomight.view;

import java.io.Serializable;

import biomight.Constants;
import biomight.util.BioGraphics;


/**
 * @author SurferJim
 *
 *  Represents Properties that are associated with a component
 *   
 */

public class BioMightPropertyView implements Serializable {
	
	private String propertyType = Constants.SINGLE_COMPONENT;
	private String propertyName = "";
	private String canonicalName = "";
	private String propertyRef = "";
	private String propertyID = "";
	private String propertyDesc = "";
	
	
	private BioMightPosition propertyPosition;
	private BioMightOrientation propertyOrientation;
	private BioMightScale propertyScale; 
	
		
	// Template 
	private String bioTemplates = "";
	
	
	// Are we shoing this item in the visual interface or hiding
	private boolean viewEnabled = true;	

	public BioMightPropertyView()
	{
		//setPropertyName(componentName);
		//setCanonicalName(canonicalName); 
		//setPropertyRef(componentRef);
		//setPropertyID(componentID);
		this.propertyPosition = new BioMightPosition(0.0, 0.0, 0.0);
		this.propertyOrientation = new BioMightOrientation(0.0, 0.0, 0.0, 0.00);
		this.propertyScale = new BioMightScale(1.0, 1.0, 1.0);
	
		setPropertyType(Constants.SINGLE_COMPONENT);
		setViewEnabled(true);
	}
	
	public BioMightPropertyView(String componentName, String canonicalName, String componentRef, String compDesc, String componentID, BioMightPosition bioPos, BioMightScale dimensions, BioMightOrientation bioOrient, String propType, String templates, boolean viewEnabled)
	{
		setPropertyName(componentName);
		setCanonicalName(canonicalName); 
		setPropertyRef(componentRef);
		setPropertyID(componentID);
		setPropertyDesc(compDesc);
		this.propertyPosition = bioPos;
		this.propertyOrientation = bioOrient;
		this.propertyScale = dimensions;
		setBioTemplates(templates);
		setPropertyType(propType);
		setViewEnabled(viewEnabled);
	}
	
	public BioMightPropertyView(String componentName, String canonicalName, String componentRef,  String componentID, BioMightPosition bioPos, BioMightScale dimensions, BioMightOrientation bioOrient, String propType, String templates, boolean viewEnabled)
	{
		setPropertyName(componentName);
		setCanonicalName(canonicalName); 
		setPropertyRef(componentRef);
		setPropertyID(componentID);
		this.propertyPosition = bioPos;
		this.propertyOrientation = bioOrient;
		this.propertyScale = dimensions;

		setBioTemplates(templates);
		setPropertyType(propType);
		setViewEnabled(viewEnabled);
	}

	public BioMightPropertyView(String componentName, String canonicalName, String componentRef, String componentID, BioMightPosition bioPos, BioMightScale dimensions, String propType, String templates, boolean viewEnabled)
	{
		setPropertyName(componentName);
		setCanonicalName(canonicalName); 
		setPropertyRef(componentRef);
		setPropertyID(componentID);
		this.propertyPosition = bioPos;
		this.propertyOrientation = new BioMightOrientation(0.0, 0.0, 0.0, 0.00);
		this.propertyScale = dimensions;
		
		setBioTemplates(templates);
		setPropertyType(propType);
		setViewEnabled(viewEnabled);
	}
	

	
	public BioMightPropertyView(String componentName, String canonicalName, String componentRef, String componentID, String bioPos, String dimensions, String propType, String templates, boolean viewEnabled)
	{
		setPropertyName(componentName);
		setCanonicalName(canonicalName); 
		setPropertyRef(componentRef);
		setPropertyID(componentID);
		this.propertyPosition = new BioMightPosition(bioPos);
		this.propertyOrientation = new BioMightOrientation(0.0, 0.0, 0.0, 0.00);
		this.propertyScale = new BioMightScale(dimensions);
		
		setBioTemplates(templates);
		setPropertyType(propType);
		setViewEnabled(viewEnabled);
	}
	
	public BioMightPropertyView(String componentName, String canonicalName, String componentRef, String componentID, String bioPos, String dimensions, String propType, boolean viewEnabled)
	{
		setPropertyName(componentName);
		setCanonicalName(canonicalName); 
		setPropertyRef(componentRef);
		setPropertyID(componentID);
		this.propertyPosition = new BioMightPosition(bioPos);
		this.propertyOrientation = new BioMightOrientation(0.0, 0.0, 0.0, 0.00);
		this.propertyScale = new BioMightScale(dimensions);
		
		setPropertyType(propType);
		setViewEnabled(viewEnabled);
	}
		
	
	public String getCanonicalName() {
		return canonicalName;
	}
	
	public void setCanonicalName(String canonicalName) {
		this.canonicalName = canonicalName;
	}

	public String getPropertyName() {
		return propertyName;
	}

	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}

	public boolean isViewEnabled() {
		//System.out.println("Arg - Getting Enabled: " + viewEnabled);
		return viewEnabled;
	}

	public void setViewEnabled(boolean viewEnabled) {
		//System.out.println("Arg - Setting Enabled: " + viewEnabled);
		this.viewEnabled = viewEnabled;
	}

	public String getPropertyRef() {
		return propertyRef;
	}

	public void setPropertyRef(String propertyRef) {
		this.propertyRef = propertyRef;
	}

	public String getPropertyID() {
		return propertyID;
	}

	public void setPropertyID(String propertyID) {
		this.propertyID = propertyID;
	}

	public String getPropertyType() {
		return propertyType;
	}

	public void setPropertyType(String propertyType) {
		this.propertyType = propertyType;
	}

	public String getBioTemplates() {
		return bioTemplates;
	}

	public void setBioTemplates(String bioTemplates) {
		this.bioTemplates = bioTemplates;
	}

	public BioMightPosition getPropertyPosition() {
		return propertyPosition;
	}

	public void setPropertyPosition(BioMightPosition properyPosition) {
		this.propertyPosition = properyPosition;
	}

	public BioMightOrientation getPropertyOrientation() {
		return propertyOrientation;
	}

	public void setPropertyOrientation(BioMightOrientation propertyOrientation) {
		this.propertyOrientation = propertyOrientation;
	}

	public BioMightScale getPropertyScale() {
		return propertyScale;
	}

	public void setPropertyScale(BioMightScale propertyScale) {
		this.propertyScale = propertyScale;
	}

	public String getPropertyDesc() {
		return propertyDesc;
	}

	public void setPropertyDesc(String propertyDesc) {
		this.propertyDesc = propertyDesc;
	}

	
	
}
