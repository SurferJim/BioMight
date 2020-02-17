/*
 * Created on Jul 22, 2006
 * Copyright 2006 - Biomight.org
 * 
 * This code is the not to be used without written permission from
 * BioMight.org
 * 
 */
 
package biomight.cell.epithelial;

import java.lang.reflect.Method;
import java.util.ArrayList;

import biomight.BioMightBase;
import biomight.Constants;
import biomight.cell.CellMembrane;
import biomight.view.BioMightMethodView;
import biomight.view.BioMightPropertyView;
import biomight.view.BioMightTransform;

/**
 * Representation of an Epithelial Cell
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */

public class EpithelialCell extends BioMightBase {
	protected int viewPerspective;
	// Inner Components
	//private Choroid choroid;
	//private ParsPlana parsPlana;
	private CellMembrane cellMembrane;

		
	public EpithelialCell()
	{		
		// Create the base epithelialCell
		create(Constants.EpithelialCellRef, null);
	}
	
	
	public EpithelialCell(String parentID)
	{				
		create(parentID, null);	
	}
	

	public EpithelialCell(String parentID, ArrayList<BioMightMethodView> bioMightMethods)
	{				
		this.parentID = parentID;
		create(parentID, bioMightMethods);	
	}
	
	
	/************************************************************************************
	 * 
	 * CREATE EpithelialCell
	 * @param EpithelialCellReference
	 ***********************************************************************************/
	
	public void create(String parentID, ArrayList<BioMightMethodView> bioMightMethods)
	{		
		this.setImage("images/EpithelialCell.jpg");
		
		viewPerspective = Constants.VIEW_FLOATING;
		if (viewPerspective == Constants.VIEW_FLOATING) {
			
			// If we have initialization parameters from the form, 
			//  then apply them before constructing the objects.
			if (bioMightMethods != null){
				System.out.println("NEED TO EXECUTE EpithelialCell METHODS: " + bioMightMethods.size());
			}
			
			cellMembrane  = new CellMembrane(parentID, bioMightMethods);
			initProperty("CellMembrane", Constants.CellMembrane, Constants.CellMembraneRef, cellMembrane.getComponentID());
			System.out.println("EpithelialCell - CellMembrane is created");	

		} 
		else if (viewPerspective == Constants.VIEW_INTERNAL) {
			//cellMembrane  = new CellMembrane(parentID, bioMightMethods);
			//initProperty("Pupil", Constants.Chest, Constants.ChestRef, chest.getComponentID());
			System.out.println("EpithelialCell - CellMembrane is created");	
		}
		initProperties();
		initMethods();
	
	}
	
	
	public void initProperties() {

		properties = new ArrayList<BioMightPropertyView>();
		
		BioMightPropertyView property = new BioMightPropertyView();
		property.setPropertyName("MedialCommissure");
		property.setCanonicalName(Constants.MedialCommissure);
		properties.add(property);	

		property = new BioMightPropertyView();
		property.setPropertyName("BiPolarCell");
		property.setCanonicalName(Constants.BiPolarCell);
		properties.add(property);	

	}
	
	
	public void initMethods() {

		methods = new ArrayList<BioMightMethodView>();
		
		BioMightMethodView method = new BioMightMethodView();

		method = new BioMightMethodView();
		method.setCanonicalName(Constants.EpithelialCell);
		method.setMethodName("setMaterial");
		method.setDisplayName("Material");
		method.setHtmlType(Constants.BIO_DROPDOWN);
		method.setDataType(Constants.BIO_TEXT);
	 	method.setValueMap(materialDDMap);
		methods.add(method);
		
		method = new BioMightMethodView();
		method.setCanonicalName(Constants.EpithelialCell);
		method.setMethodName("setTexture");
		method.setDisplayName("Texture");
		method.setHtmlType(Constants.BIO_DROPDOWN);
		method.setDataType(Constants.BIO_TEXT);
	 	method.setValueMap(textureDDMap);
		methods.add(method);	}
	

	
	public void redraw(int parentID)
	{
		viewPerspective = Constants.VIEW_FLOATING;
		if (viewPerspective == Constants.VIEW_FLOATING) {
			System.out.println("EpithelialCell Redraw");
		} 
			
		this.setImage("images/LeftEpithelialCell.jpg");
	}
	
	
	/********************************************************************************************************************
	 * GET X3D
	 * 
	 * This method will return the X3D for the Cell.  It runs through each of its components and collects up their
	 * representations and then assembles them into one unified X3D model.
	 * 
	 ********************************************************************************************************************/
	public String getX3D(boolean snipet) {
		
		// Assembe the EpithelialCell
		String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
		"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n " +
		"<X3D profile='Immersive' >\n" +
		"<head>\n" +
		 "<meta name='BioMightImage' content='EpithelialCell.jpg'/>\n" +
		 "<meta name='ExportTime' content='7:45:30'/>\n" +
		 "<meta name='ExportDate' content='08/15/2008'/>\n" +
		 "<meta name='BioMight Version' content='1.0'/>\n" + 
		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='EpithelialCell'\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		

		String body = "";
		
		int view = Constants.VIEW_FLOATING;
		if (view == Constants.VIEW_FLOATING)
		{
			System.out.println("Getting composite X3D for EpithelialCell");
			body = cellMembrane.getX3D(true); 					
		}
		else
		{
		body = "";
			/*
			cone.getX3D(true) +
			cornea.getX3D(true);
			*/
		}	
		System.out.println("EpithelialCell X3D: " + body);		
		
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
	public void executeMethods(ArrayList<String> methodParams) {

		// Run through the argument list and executes the 
		// associated methods
		System.out.println("HEAD-Executing Methods");
		for (int j=0; j<methodParams.size(); j++){
			
			// Get the parameter from the list and if it is not
			// empty execute the associated method using it
			String methodParam = methodParams.get(j);
			if (methodParam != null) {
				if (!methodParam.equals("")) {

					String methodName = (String) methods.get(j).getMethodName(); 
					String htmlType = (String) methods.get(j).getHtmlType();
					String dataType = (String) methods.get(j).getDataType();
					System.out.println("Execute Method " + methodName + " Arg: "  +  methodParam);
					System.out.println("HtmlType " + htmlType + " with DataType: "  +  dataType);
										
					// Use the DataType parameter to convert the data into its base form
					if (dataType.equals("int")) {
						
						try {
							System.out.println("Locating Method(Integer)" + methodName);
							// Locate the method through introspection
							int numElements = Integer.parseInt(methodParam);
							Class paramsType[] = {int.class};
							Method method = this.getClass().getDeclaredMethod(methodName, paramsType);
							System.out.println("Before Execute Method(Integer)" + methodName);
							Object result = method.invoke(this, numElements);
							System.out.println("Before Execute Method(Integer)" + methodName);
							
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
					
					else if (dataType.equals("String")) {
						
						
						try {
							System.out.println("Locating Method(String)");
							
							Class paramsType[] = {String.class};
							
							Method method = this.getClass().getDeclaredMethod(methodName, paramsType );
							System.out.println("Method with String Param: " + method.getName());
							
							System.out.println("Before Execute Method(Integer)" + methodName);
							Object result = method.invoke(this, methodParam);
							System.out.println("After Execute Method(Integer)" + methodName);
									
						}
						catch (NoSuchMethodException e)
						{
							System.out.println("Method with int param not found!");						
						}	
						catch (Exception e)
						{
							System.out.println("General Exception occurred!");						
						}	
						
					}
				
					else if (dataType.equals("double")) {
						
					}
					else if (dataType.equals("")) {
						
					}			
				}
			}
		}
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
