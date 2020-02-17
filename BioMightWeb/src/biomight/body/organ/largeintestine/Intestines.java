/*
 * Created on Jul 8, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.body.organ.largeintestine;
import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.naming.InitialContext;

import biomight.BioMightBase;
import biomight.Constants;
import biomight.body.organ.smallintestine.SmallIntestine;
import biomight.ejb.BioMightBeanLocal;
import biomight.exceptions.DataSecurityException;
import biomight.exceptions.ServerException;
import biomight.view.BioMightMethodView;
import biomight.view.BioMightPropertyView;
import biomight.view.BioMightTransform;
import biomight.view.BioMightTransforms;

/**
 * @author SurferJim
 *
 * Representation of the Intestines
 * 
 */

public class Intestines extends BioMightBase{
	private String componentID = "";
	private BioMightTransforms bioMightTransforms;
	private ArrayList<BioMightPropertyView> properties;
	private ArrayList<BioMightMethodView> methods;
	private LargeIntestine largeIntestine;
	private SmallIntestine smallIntestine;


	
	/*********************************************************************************
	 * CONSTRUCTORS
	 *
	 *********************************************************************************/
	
	public Intestines()
	{
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, Constants.LungRef, null, null);
	}

	public Intestines(String parentID)
	{
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, parentID, null, null);
	}

	public Intestines(int hierarchy, int LOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
	{
		System.out.print("Calling Lung Create");
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

		this.setImage("images/Intestines.jpg");
		this.setImageHeight(300);
		this.setImageWidth(300);

		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Getting IntestinesInfo for ParentID: " + parentID);
			InitialContext ctx = new InitialContext();
			BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
			bioMightTransforms = bioMightBean.getComponents(Constants.SmallIntestineRef, parentID);
			System.out.println("Have Intestines Info from EJB");   	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - Intestines");
			throw new ServerException("Remote Exception getComponents():", e); 	
		}
			
		int localVP = Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;

		// Run through Intestines and build them into the model
		ArrayList transforms = bioMightTransforms.getTransforms();
		System.out.println("Intestine NumTransforms: " + transforms.size());
		for (int i=0; i<transforms.size(); i++)
		{
			// Get the information for the Intestine we are creating
			BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
			System.out.println("Creating IntestineSerousCoat (name,id): " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
			componentID = bioMightTransform.getId();
			
			largeIntestine = new LargeIntestine(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);	
			System.out.println("Large Intestine completed");
			smallIntestine = new SmallIntestine(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);		
			System.out.println("Small Intestine completed");			
		}			
		initProperties();
		initMethods();
	}
	
	
	public void initProperties() {

		properties = new ArrayList<BioMightPropertyView>();
		BioMightPropertyView property;

		property = new BioMightPropertyView();
		property.setPropertyName("Large Intestine");
		property.setCanonicalName(Constants.LargeIntestine);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("Small Intestine");
		property.setCanonicalName(Constants.SmallIntestine);
		properties.add(property);
	}
	
	
	public void initMethods() {

		methods = new ArrayList<BioMightMethodView>();
		
		BioMightMethodView method = new BioMightMethodView();
		
		method = new BioMightMethodView();
		method.setMethodName("Digest");
		method.setHtmlType("checkbox");
		methods.add(method);

		method = new BioMightMethodView();
		method.setMethodName("Excrete");
		method.setHtmlType("checkbox");
		methods.add(method);

		method = new BioMightMethodView();
		method.setMethodName("Peristalisis");
		method.setHtmlType("checkbox");
		methods.add(method);
	}
	
	/********************************************************************************************************************
	 * GET X3D
	 * 
	 * This method will return the X3D for the Cell.  It runs through each of its components and collects up their
	 * representations and then assembles them into one unified X3D model.
	 * 
	 ********************************************************************************************************************/
	public String getX3D(boolean snipet) {
		
		// Assemble the Intestines
		String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
		"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n " +
		"<X3D profile='Immersive' >\n" +
		"<head>\n" +
		 "<meta name='BioMightImage' content='Intestines.jpg'/>\n" +
		 "<meta name='ExportTime' content='7:45:30'/>\n" +
		 "<meta name='ExportDate' content='08/15/2008'/>\n" +
		 "<meta name='BioMight Version' content='1.0'/>\n" + 
		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='Intestines'\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		

		String body = largeIntestine.getX3D(true) + smallIntestine.getX3D(true);  
		System.out.println("Intestines X3D: " + body);		
		
		String footer = "</Scene>" + "</X3D>\n";
		
		if (snipet)
			return body;			
		else	
			return header + body + footer;
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
	
}
