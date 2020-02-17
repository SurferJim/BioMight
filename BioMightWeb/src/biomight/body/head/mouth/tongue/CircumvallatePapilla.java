/*
 * Created on Jul 5, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.body.head.mouth.tongue;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.naming.InitialContext;

import biomight.BioMight3D;
import biomight.BioMightBase;
import biomight.Constants;
import biomight.cell.epithelial.EthmoidalCell;
import biomight.chemistry.compound.Dentin;
import biomight.chemistry.compound.Enamel;
import biomight.ejb.BioMightBeanLocal;
import biomight.exceptions.DataSecurityException;
import biomight.exceptions.ServerException;
import biomight.system.cartilage.Cartilage;
import biomight.system.tissue.connective.ConnectiveTissue;
import biomight.system.tissue.epithelial.EpitheliumTissue;
import biomight.system.tissue.nervous.Nerves;
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
 * Representation of a CircumvallatePapilla
 * 
 */


public class CircumvallatePapilla extends BioMightBase {
	private BioMightTransforms bioMightTransforms;
	private ArrayList<BioMightPropertyView> properties;
	private ArrayList<BioMightMethodView> methods;
	private String componentID = "";
	private String parentID;
	private BioMightPosition bioMightPosition;
	
	// The components of a CircumvallatePapilla
	private ConnectiveTissue connectiveTissue;
	private Nerves nerves;
	
	
	/********************************************************************
	 * Constructtors
	 * 
	 *******************************************************************/
	public CircumvallatePapilla()
	{
		create(Constants.CircumvallatePapillaRef, null);
	}

	
	public CircumvallatePapilla(String parentID, ArrayList<BioMightMethodView> bioMightMethods)
	{
		create(parentID, bioMightMethods);
	}
	
	
	public void create(String parentID, ArrayList<BioMightMethodView> bioMightMethods)
	{
		this.setImage("images/CircumvallatePapilla.jpg");
		
		properties = new ArrayList<BioMightPropertyView>();;
		componentID=parentID;
			
		//connectiveTissue = new ConnectiveTissue("PapillaConnectiveTissue", parentID, bioMightMethods);
		//initProperty("PapillaConnectiveTissue", Constants.ConnectiveTissue, Constants.ConnectiveTissueRef, connectiveTissue.getComponentID());
		//System.out.println("CircumvallatePapilla Enamel completed");		

		//initProperties();
		initMethods();
	}
	
	
	public void redraw(int parentID)
	{
		System.out.println("CircumvallatePapilla Redraw");
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
		property.setPropertyName("TasteBud");
		property.setCanonicalName(Constants.TasteBud);
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
		
		// Assemble the CircumvallatePapilla
		String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
		"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n " +
		"<X3D profile='Immersive' >\n" +
		"<head>\n" +
		 "<meta name='BioMightImage' content='CircumvallatePapilla.jpg'/>\n" +
		 "<meta name='ExportTime' content='7:45:30'/>\n" +
		 "<meta name='ExportDate' content='08/15/2008'/>\n" +
		 "<meta name='BioMight Version' content='1.0'/>\n" + 
		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='CircumvallatePapilla'\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		

		String body = connectiveTissue.getX3D(true);
		
		//System.out.println("CircumvallatePapilla  X3D: " + body);		
		String footer = "</Scene>" + "</X3D>\n";
		
		if (snipet)
			return body;			
		else	
			return header + body + footer;
	}
	
	
	
	public void setCircumvallatePapillaClass(int CircumvallatePapillaClass)
	{
		if (CircumvallatePapillaClass == 1)
		{
			// The Roman, or Aquiline CircumvallatePapilla
		}
		else if (CircumvallatePapillaClass == 6)
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
