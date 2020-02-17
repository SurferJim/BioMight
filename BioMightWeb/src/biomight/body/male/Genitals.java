/*
 * Created on Jul 5, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.body.male;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.naming.InitialContext;

import biomight.BioMight3D;
import biomight.BioMightBase;
import biomight.Constants;
import biomight.cell.epithelial.EthmoidalCell;
import biomight.ejb.BioMightBeanLocal;
import biomight.exceptions.DataSecurityException;
import biomight.exceptions.ServerException;
import biomight.system.cartilage.Cartilage;
import biomight.system.tissue.epithelial.EpitheliumTissue;
import biomight.view.BioMightColor;
import biomight.view.BioMightMaterial;
import biomight.view.BioMightMethodView;
import biomight.view.BioMightPolygon;
import biomight.view.BioMightPolygons;
import biomight.view.BioMightPosition;
import biomight.view.BioMightPositions;
import biomight.view.BioMightPositionsIndex;
import biomight.view.BioMightPropertyView;
import biomight.view.BioMightTransform;
import biomight.view.BioMightTransforms;

/**
 * @author SurferJim
 *
 * Representations of the Male Genitals
 * 
 * 
 */

public class Genitals extends BioMightBase {
	private EpitheliumTissue epithelium;
	private Penis penis;

	
	
	public Genitals()
	{
		create(Constants.MaleGenitalsRef, null);
	}

	
	public Genitals(String parentID)
	{
		create(parentID, null);
	}
	
	
	public Genitals(String parentID, ArrayList<BioMightMethodView> bioMightMethods)
	{
		create(parentID, bioMightMethods);
	}

	
	
	public void create(String parentID, ArrayList<BioMightMethodView> bioMightMethods)
	{
		this.setImage("images/Genitals.jpg");
	
	
		// Generate a genitals based on the preferences selected in the browser
		/*
		System.out.println("Creating the Genitals for parent: " + Constants.MaleGenitalsRef+":0");
		try {
			int insertFlag = bioMight.generateGenitals(Constants.MaleGenitalsRef+":0"); 
			System.out.println("Created Genitals");
		}catch (RemoteException e) { 
			System.out.println("Exception Creating Genitals");
			throw new ServerException("Remote Exception getComponents():", e); 	
		}catch (DataSecurityException  e) {
			System.out.println("Exception Getting Genitals Component");
			throw new ServerException("Remote Exception getComponents():", e); 	
		}
		*/
		
		
		// Get the data for the Genitals that is defined for this 
		// body reference.  Read it into the matrix that is mapped 
		// to the imaging device
		// Get the information from the database via the Enterprise Bean		
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Getting MaleGenitalsInfo for ParentID: " + parentID);
			InitialContext ctx = new InitialContext();
			BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
			bioMightTransforms = bioMightBean.getComponents(Constants.MaleGenitalsRef, parentID);
			System.out.println("Have MaleGenitals Info from EJB");   	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - MaleGenitals");
			throw new ServerException("Remote Exception getComponents():", e); 	
		}
	
		// Run through the collection of UpperLip and build them into the model
		// In the default case, we get one instance of the Pupil for each eye
		ArrayList transforms = bioMightTransforms.getTransforms();
		System.out.println("Have Genitals Info NumTransforms: " + transforms.size());
		for (int i=0; i<transforms.size(); i++)
		{
			// Get the information for the Upper Lip we are creating
			BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
			System.out.println("Creating Genitals (name,id): " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
			componentID = bioMightTransform.getId();
			
			penis = new Penis(bioMightTransform.getId(), bioMightMethods);
			//initProperty("Genitals Epithelium", Constants.Epithelium, Constants.EpitheliumRef, bioMightTransform.getId());
			System.out.println("Penis completed");		
		}		

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
		System.out.println("Genitals Redraw");
		init3D(parentID);
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

		property = new BioMightPropertyView();
		property.setPropertyName("FrontalSinuses");
		property.setCanonicalName(Constants.FrontalSinuses);
		properties.add(property);		

		property = new BioMightPropertyView();
		property.setPropertyName("InferiorNasalConcha");
		property.setCanonicalName(Constants.InferiorNasalConcha);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("SuperiorNasalConcha");
		property.setCanonicalName(Constants.SuperiorNasalConcha);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("MiddleNasalConcha");
		property.setCanonicalName(Constants.MiddleNasalConcha);
		properties.add(property);
				
	}
	
	
	public void initMethods() {
	
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
		
		// Assemble the Genitals
		String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
		"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n " +
		"<X3D profile='Immersive' >\n" +
		"<head>\n" +
		 "<meta name='BioMightImage' content='Genitals.jpg'/>\n" +
		 "<meta name='ExportTime' content='7:45:30'/>\n" +
		 "<meta name='ExportDate' content='08/15/2008'/>\n" +
		 "<meta name='BioMight Version' content='1.0'/>\n" + 
		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='Genitals'\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		

		System.out.println("Getting X3D for Penis");
		String body = penis.getX3D(true);
		
		//System.out.println("Genitals X3D: " + body);		
		String footer = "</Scene>" + "</X3D>\n";
		
		if (snipet)
			return body;			
		else	
			return header + body + footer;
	}
	
	
	
	
	public void setGenitalsClass(int genitalsClass)
	{
		if (genitalsClass == 1)
		{
			// The Roman, or Aquiline genitals
		}
		if (genitalsClass == 2)
		{
			// The Greek or Straight genitals
		}
		if (genitalsClass == 3)
		{
			// The African, or Wide-nostrilled genitals
		}
		if (genitalsClass == 4)
		{
			// The Jewish or Hawk genitals
		}
		if (genitalsClass == 5)
		{
			// The Snub genitals
		}
		if (genitalsClass == 6)
		{
			// The Turn-up or Celestial nos
		}		
	}


	
	public String getX3D() {
		
		System.out.println("Reading Genitals X3D");
		BioMight3D bioMight3D = new BioMight3D();
		bioMight3D.loadX3D("Genitals");
		System.out.println("Loaded Genitals X3D");				
		
		return "";
	}

	
	
}
