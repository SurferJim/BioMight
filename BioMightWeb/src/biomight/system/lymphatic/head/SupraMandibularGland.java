/*
 * Created on May 19, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.system.lymphatic.head;

import java.util.ArrayList;

import biomight.BioMightBase;
import biomight.Constants;
import biomight.view.BioMightMethodView;
import biomight.view.BioMightPosition;
import biomight.view.BioMightPropertyView;
import biomight.view.BioMightTransforms;

/**
 * @author SurferJim
 *
 * Representation of a Paratoid Gland
 * 
 */

public class SupraMandibularGland extends BioMightBase  {
	private BioMightTransforms bioMightTransforms;
	private String componentID = "";
	private ArrayList<BioMightPropertyView> properties;
	private ArrayList<BioMightMethodView> methods;
	private String parentID;
	private BioMightPosition bioMightPosition;
	

	
	
	public SupraMandibularGland()
	{
		create(Constants.SupraMandibularGlandRef, null);
	}

	
	public SupraMandibularGland(String parentID, ArrayList<BioMightMethodView> bioMightMethods)
	{
		create(parentID, bioMightMethods);
	}
	
	
	public void create(String parentID, ArrayList<BioMightMethodView> bioMightMethods)
	{
		this.setImage("images/SupraMandibularGland.jpg");
		properties = new ArrayList<BioMightPropertyView>();;	
			
		//enamel = new Enamel("Enamel", parentID, bioMightMethods);
		//initProperty("SupraMandibularGland Enamel", Constants.Epithelium, Constants.EpitheliumRef, bioMightTransform.getId());
		System.out.println("SupraMandibularGland Enamel completed");		

		initProperties();
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
		System.out.println("SupraMandibularGland Redraw");
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
	
		BioMightPropertyView property = new BioMightPropertyView();
		property.setPropertyName("NasalSeptum");
		property.setCanonicalName(Constants.NasalSeptum);
		properties.add(property);
	
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
		
		// Assemble the SupraMandibularGland
		String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
		"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n " +
		"<X3D profile='Immersive' >\n" +
		"<head>\n" +
		 "<meta name='BioMightImage' content='SupraMandibularGland.jpg'/>\n" +
		 "<meta name='ExportTime' content='7:45:30'/>\n" +
		 "<meta name='ExportDate' content='08/15/2008'/>\n" +
		 "<meta name='BioMight Version' content='1.0'/>\n" + 
		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='SupraMandibularGland'\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		

		String body = "";//enamel.getX3D(true);
		
		System.out.println("SupraMandibularGland  X3D: " + body);		
		String footer = "</Scene>" + "</X3D>\n";
		
		if (snipet)
			return body;			
		else	
			return header + body + footer;
	}
	
	
	
	
	public void setSupraMandibularGlandClass(int SupraMandibularGlandClass)
	{
		if (SupraMandibularGlandClass == 1)
		{
			// The Roman, or Aquiline SupraMandibularGland
		}
		else if (SupraMandibularGlandClass == 6)
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
	
}
