/*
 * Created on Jul 7, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.body.head.mouth.tongue;
import java.util.ArrayList;

import biomight.BioMightBase;
import biomight.Constants;
import biomight.system.muscular.head.mouth.tongue.InferiorLongitudinalMuscle;
import biomight.system.muscular.head.mouth.tongue.SuperiorLongitudinalMuscle;
import biomight.system.muscular.head.mouth.tongue.TransversusMuscle;
import biomight.view.BioMightMethodView;
import biomight.view.BioMightPropertyView;


/**
 * @autthor SurferJim
 * 
 *  Representation of a Gustatory Pore
 *
 */


public class GustatoryPore extends BioMightBase {
	private ArrayList<BioMightPropertyView> properties;
	private ArrayList<BioMightMethodView> methods;



	public GustatoryPore()
	{
		this.setImage("images/GustatoryPore.jpg");
		this.setImageHeight(300);
		this.setImageWidth(300);
		initProperties();
		initMethods();
	}	
	

	public void initProperties() {

		properties = new ArrayList<BioMightPropertyView>();
		
		BioMightPropertyView property = new BioMightPropertyView();
		property.setPropertyName("Taste Buds");
		property.setCanonicalName(Constants.TasteBuds);
		properties.add(property);
	
		property = new BioMightPropertyView();
		property.setPropertyName("SuperiorLongitudinalMuscle");
		property.setCanonicalName(Constants.SuperiorLongitudinalMuscle);
		properties.add(property);				

		property = new BioMightPropertyView();
		property.setPropertyName("InferiorLongitudinalMuscle");
		property.setCanonicalName(Constants.InferiorLongitudinalMuscle);
		properties.add(property);		

		property = new BioMightPropertyView();
		property.setPropertyName("TransversusMuscle");
		property.setCanonicalName(Constants.TransversusMuscle);
		properties.add(property);
				
	}
	
	
	public void initMethods() {

		methods = new ArrayList<BioMightMethodView>();
		
		BioMightMethodView method;

		method = new BioMightMethodView();
		method.setMethodName("Flick");
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
		
		// Assembe the Head
		String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
		"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n " +
		"<X3D profile='Immersive' >\n" +
		"<head>\n" +
		 "<meta name='BioMightImage' content='Tongue.jpg'/>\n" +
		 "<meta name='ExportTime' content='7:45:30'/>\n" +
		 "<meta name='ExportDate' content='08/15/2008'/>\n" +
		 "<meta name='BioMight Version' content='1.0'/>\n" + 
		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='GustatoryPore'\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		

		String body = "";//leftEar.getX3D(true) + rightEar.getX3D(true);  
		System.out.println("GustatoryPore X3D: " + body);		
		
		String footer = "</Scene>" + "</X3D>\n";
		
		if (snipet)
			return body;			
		else	
			return header + body + footer;
	}

}
