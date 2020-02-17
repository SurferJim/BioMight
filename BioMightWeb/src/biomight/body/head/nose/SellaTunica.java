/*
 * Created on Jul 5, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.body.head.nose;

import java.util.ArrayList;

import javax.naming.InitialContext;

import biomight.BioMight3D;
import biomight.BioMightBase;
import biomight.Constants;
import biomight.cell.epithelial.EthmoidalCell;
import biomight.ejb.BioMightBeanLocal;
import biomight.exceptions.ServerException;
import biomight.system.tissue.epithelial.EpitheliumTissue;
import biomight.view.BioMightMethodView;
import biomight.view.BioMightPropertyView;
import biomight.view.BioMightTransform;
import biomight.view.BioMightTransforms;

/**
 * @author SurferJim
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class SellaTunica extends BioMightBase { 
	private BioMightTransforms bioMightTransforms;
	private EpitheliumTissue epithelium;
	private String componentID = "";
	
	private ArrayList<BioMightPropertyView> properties;
	private ArrayList<BioMightMethodView> methods;
	
	
	public SellaTunica()
	{
		create(Constants.SellaTunicaRef, null);
	}

	
	public SellaTunica(String parentID, ArrayList<BioMightMethodView> bioMightMethods)
	{
		create(parentID, bioMightMethods);
	}
	
	
	public void create(String parentID, ArrayList<BioMightMethodView> bioMightMethods)
	{
		this.setImage("images/SellaTunica.jpg");

		// Get the data for the SellaTunica that is defined for this 
		// body reference.  Read it into the matrix that is mapped 
		// to the imaging device
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Getting SellaTunicaInfo for ParentID: " + parentID);
			InitialContext ctx = new InitialContext();
			BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
			bioMightTransforms = bioMightBean.getComponents(Constants.SellaTunicaRef, parentID);
			System.out.println("Have SellaTunica Info from EJB");   	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - SellaTunica");
			throw new ServerException("Remote Exception getComponents():", e); 	
		}

		properties = new ArrayList<BioMightPropertyView>();
		
		// Run through the collection of UpperLip and build them into the model
		// In the default case, we get one instance of the Pupil for each eye
		ArrayList transforms = bioMightTransforms.getTransforms();
		System.out.println("Have SellaTunica Info NumTransforms: " + transforms.size());
		for (int i=0; i<transforms.size(); i++)
		{
			// Get the information for the Upper Lip we are creating
			BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
			System.out.println("Creating SellaTunica (name,id): " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
			componentID = bioMightTransform.getId();
			
	
			epithelium = new EpitheliumTissue("SellaTunicaEpithelium", bioMightTransform.getId(), bioMightMethods);
			//initProperty("SellaTunica Epithelium", Constants.Epithelium, Constants.EpitheliumRef, bioMightTransform.getId());
			System.out.println("SellaTunica Epithelium completed");		
		}		

		initProperties();
		initMethods();
	}
	
	
	public void redraw(int parentID)
	{

		System.out.println("SellaTunica Redraw");
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
		property.setPropertyName("SellaTunica");
		property.setCanonicalName(Constants.SellaTunica);
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
	 * This method will return the X3D for the SellaTunica.  It runs through each of its components and collects up their
	 * representations and then assembles them into one unified X3D model.
	 * 
	 ********************************************************************************************************************/
	public String getX3D(boolean snipet) {
		
		// Assemble the SellaTunica
		String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
		"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n " +
		"<X3D profile='Immersive' >\n" +
		"<head>\n" +
		 "<meta name='BioMightImage' content='SellaTunica.jpg'/>\n" +
		 "<meta name='ExportTime' content='7:45:30'/>\n" +
		 "<meta name='ExportDate' content='08/15/2008'/>\n" +
		 "<meta name='BioMight Version' content='1.0'/>\n" + 
		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='SellaTunica'\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		

		String body = epithelium.getX3D(true);
		
		//System.out.println("SellaTunica X3D: " + body);		
		String footer = "</Scene>" + "</X3D>\n";
		
		if (snipet)
			return body;			
		else	
			return header + body + footer;
	}
	
	
	
	
	public void setSellaTunicaClass(int SellaTunicaClass)
	{
		if (SellaTunicaClass == 1)
		{
			// The Roman, or Aquiline SellaTunica
		}
		if (SellaTunicaClass == 2)
		{
			// The Greek or Straight SellaTunica
		}
		if (SellaTunicaClass == 3)
		{
			// The African, or Wide-nostrilled SellaTunica
		}
		if (SellaTunicaClass == 4)
		{
			// The Jewish or Hawk SellaTunica
		}
		if (SellaTunicaClass == 5)
		{
			// The Snub SellaTunica
		}
		if (SellaTunicaClass == 6)
		{
			// The Turn-up or Celestial nos
		}		
	}



	
	public String getX3D() {
		
		System.out.println("Reading SellaTunica X3D");
		BioMight3D bioMight3D = new BioMight3D();
		bioMight3D.loadX3D("SellaTunica");
		System.out.println("Loaded SellaTunica X3D");				
		
		return "";
	}


	public ArrayList<BioMightMethodView> getMethods() {
		return methods;
	}


	public void setMethods(ArrayList<BioMightMethodView> methods) {
		this.methods = methods;
	}


	public ArrayList<BioMightPropertyView> getProperties() {
		return properties;
	}


	public void setProperties(ArrayList<BioMightPropertyView> properties) {
		this.properties = properties;
	}


	public String getComponentID() {
		return componentID;
	}


	public void setComponentID(String componentID) {
		this.componentID = componentID;
	}
	
	

}
