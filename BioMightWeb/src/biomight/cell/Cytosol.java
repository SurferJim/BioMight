/*
 * Created on Apr 26, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.cell;
import java.util.ArrayList;

import biomight.BioMightBase;
import biomight.Constants;
import biomight.chemistry.compound.*;
import biomight.chemistry.elements.*;
import biomight.chemistry.protein.*;
import biomight.view.BioMightMethodView;
import biomight.view.BioMightPosition;
import biomight.view.BioMightPropertyView;
import biomight.view.BioMightSphere;

/**
 * @author SurferJim*
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class Cytosol extends BioMightBase{
	private ArrayList<BioMightPropertyView> properties;
	private ArrayList<BioMightMethodView> methods;
	private H20 h20;
	private Sodium sodium;
	private Potassium potassium;
	private HeatShockProtein90 hsp90;
	private HeatShockProtein40 hsp40;
		
	public Cytosol()
	{

		// Set up the Distribution for the water molecules		
		BioMightPosition h20Position = new BioMightPosition();
		h20Position.setXPos(0.1);
		h20Position.setYPos(0.1);
		h20Position.setZPos(0.0);
		
		// Create the water molecule
		h20 = new H20(h20Position);

		
		
		
		this.setImage("images/Cytosol.jpg");
		initProperties();
		initMethods();
	}
	
	
	public void initProperties() {

		properties = new ArrayList<BioMightPropertyView>();
		
		BioMightPropertyView property = new BioMightPropertyView();
		property.setPropertyName("H20");
		property.setCanonicalName(Constants.H20);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("Sodium");
		property.setCanonicalName(Constants.Sodium);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("Potassium");
		property.setCanonicalName(Constants.Potassium);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("HeatShockProtein90");
		property.setCanonicalName(Constants.HeatShockProtein90);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("HeatShockProtein40");
		property.setCanonicalName(Constants.HeatShockProtein40);
		properties.add(property);
	}
	
	
	public void initMethods() {

		methods = new ArrayList<BioMightMethodView>();
		BioMightMethodView method;
		
		method = new BioMightMethodView();
		method.setMethodName("DisAssocaite");
		method.setHtmlType("text");
		methods.add(method);

	}
	
	
	/*********************************************************************************
	 * INIT 3D
	 * 
	 *
	 ********************************************************************************/
	public void init3D(BioMightPosition position) {
	}

	public ArrayList getProperties() {
		return properties;
	}
	

	public ArrayList getMethods() {		
		return methods;
	}

	/********************************************************************************************************************
	 * GET X3D
	 * 
	 * This method will return the X3D for the Cell.  It runs through each of its components and collects up their
	 * representations and then assembles them into one unified X3D model.
	 * 
	 ********************************************************************************************************************/

	public String getX3D(boolean snipet) {
		
		// Assemble the Cytosol
		System.out.println("Getting Cytosol X3D from components");
		String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
		"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n " +
		"<X3D profile='Immersive' >\n" +
		"<head>\n" +
		 "<meta name='BioMightImage' content='Cytosol.jpg'/>\n" +
		 "<meta name='ExportTime' content='7:45:30'/>\n" +
		 "<meta name='ExportDate' content='08/15/2008'/>\n" +
		 "<meta name='BioMight Version' content='1.0'/>\n" + 
		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='Cytosol'\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		

		String body = h20.getX3D(true);
			//sodium.getX3D() +
			//potassium.getX3D() +
			//hsp90.getX3D() + 
			//hsp40.getX3D();
		
		System.out.println("Have Cytosol X3D: " + body);		
		
		String footer = "</Scene>" + "</X3D>\n";
		
		if (snipet)
			return body;			
		else	
			return header + body + footer;
	}
		
	
	
}
