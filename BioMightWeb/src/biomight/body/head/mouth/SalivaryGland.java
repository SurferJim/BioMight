/*
 * Created on Oct 10, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.body.head.mouth;
import java.util.ArrayList;

import biomight.BioMightBase;
import biomight.Constants;
import biomight.system.lymphatic.head.*;
import biomight.system.tissue.epithelial.EpitheliumTissue;
import biomight.view.BioMightMethodView;
import biomight.view.BioMightPosition;
import biomight.view.BioMightPropertyView;
import biomight.view.BioMightTransforms;
/**
 * @author SurferJim
 *
 * Representation of a Salivary Gland  
 */

public class SalivaryGland extends BioMightBase {
	private BioMightTransforms bioMightTransforms;
	private String componentID = "";
	private ArrayList<BioMightPropertyView> properties;
	private ArrayList<BioMightMethodView> methods;
	private String parentID;
	private BioMightPosition bioMightPosition;
	private EpitheliumTissue epithelium;
	
	
	
	public SalivaryGland()
	{
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, Constants.SalivaryGlandRef, null, null);
	}

	public SalivaryGland(String parentID)
	{
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, parentID, null, null);
	}

	public SalivaryGland(int hierarchy, int LOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
	{
		System.out.print("Calling SalivaryGland Create");
		create(hierarchy, LOD, parentID, bioMightProperties, bioMightMethods);
	}

	/*****************************************************************
	 * CREATE
	 * 
	 * @param parentID
	 * @param bioMightMethods
	 ******************************************************************/
	public void create(int hierarchy, int LOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
	{
		this.setImage("images/SalivaryGland.jpg");

		// The ID being passed in, is the real parent, not the virtual collection object
		componentID=parentID;
		
		// Set up the properties array that is returned to the UI
		properties = new ArrayList<BioMightPropertyView>();;	
					
		System.out.println("Creating SalivaryGland Epithelium: " + parentID);			
		epithelium = new EpitheliumTissue("SalivaryGlandEpithelium", parentID, bioMightMethods);		
		initProperty("SalivaryGland Epithelium", Constants.EpitheliumTissue, Constants.EpitheliumTissueRef, epithelium.getComponentID());
		
		//initProperties();
		initMethods();
	}
	
	
	public void redraw(int parentID)
	{
		/*nasalSeptum = new NasalSeptum();
		ethmoidalCell = new EthmoidalCell();
		frontalSinuses = new FrontalSinuses();
		inferiorNasalConcha = new InferiorNasalConcha();
		superiorNasalConcha = new SuperiorNasalConcha();
		middleNasalConcha = new MiddleNasalConcha();
		sphenoidSinus = new SphenoidSinus();
		sellaTunica = new SellaTunica();
		*/
		System.out.println("SalivaryGland Redraw");
		init3D(parentID);
	}
	
	
	
	protected void initProperty(String componentName, String canonicalName, String componentRef, String componentID) {
		BioMightPropertyView property = new BioMightPropertyView();
		property.setPropertyName(componentName);
		property.setCanonicalName(canonicalName);
		property.setPropertyRef(componentRef);
		property.setPropertyID(componentID);
		properties.add(property);
	}
	
	
	public void initProperties() {
	
		properties = new ArrayList<BioMightPropertyView>();

		BioMightPropertyView property = new BioMightPropertyView();
		
		property = new BioMightPropertyView();
		property.setPropertyName("EthmoidalCell");
		property.setCanonicalName(Constants.EthmoidalCell);
		properties.add(property);				
		
	}
	
	
	public void initMethods() {

		methods = new ArrayList<BioMightMethodView>();
		
		BioMightMethodView method = new BioMightMethodView();
		method.setMethodName("Twitch");
		method.setHtmlType("checkbox");
		methods.add(method);
		
		method.setMethodName("Salivate");
		method.setHtmlType("checkbox");
		methods.add(method);
		
		method.setMethodName("Excrete");
		method.setHtmlType("checkbox");
		methods.add(method);		
	}
	
	/*********************************************************************************
	 * INIT 3D
	 * 
	 * This method will be executed when we can see cartilage with our regular
	 * perception.  This is not at the cellular level, but as if one were looking
	 * at the ear.
	 *
	 ********************************************************************************/
	public void init3D(int parentID) {
	
	}
	
	
	/********************************************************************************************************************
	 * GET X3D
	 * 
	 * This method will return the X3D for the Cell.  It runs through each of its components and collects up their
	 * representations and then assembles them into one unified X3D model.
	 * 
	 ********************************************************************************************************************/
	public String getX3D(boolean snipet) {
		
		// Assemble the SalivaryGland
		String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
		"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n " +
		"<X3D profile='Immersive' >\n" +
		"<head>\n" +
		 "<meta name='BioMightImage' content='SalivaryGland.jpg'/>\n" +
		 "<meta name='ExportTime' content='7:45:30'/>\n" +
		 "<meta name='ExportDate' content='08/15/2008'/>\n" +
		 "<meta name='BioMight Version' content='1.0'/>\n" + 
		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='SalivaryGland'\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		

		String body = epithelium.getX3D(true);
		
		//System.out.println("SalivaryGland  X3D: " + body);		
		String footer = "</Scene>" + "</X3D>\n";
		
		if (snipet)
			return body;			
		else	
			return header + body + footer;
	}
	
	
	
	
	public void setSalivaryGlandClass(int SalivaryGlandClass)
	{
		if (SalivaryGlandClass == 1)
		{
			// The Roman, or Aquiline SalivaryGland
		}
		else if (SalivaryGlandClass == 6)
		{
			// The Turn-up or Celestial nos
		}		
	}



	public String getComponentID() {
		return componentID;
	}


	public void setComponentID(String componentID) {
		this.componentID = componentID;
	}

	
	public ArrayList<BioMightPropertyView> getProperties() {
		return properties;
	}


	public void setProperties(ArrayList<BioMightPropertyView> properties) {
		this.properties = properties;
	}


	public ArrayList<BioMightMethodView> getMethods() {
		return methods;
	}


	public void setMethods(ArrayList<BioMightMethodView> methods) {
		this.methods = methods;
	}
}
