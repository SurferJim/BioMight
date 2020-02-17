/*
 * Created on Oct 24, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.body.gland.pituitary;
import java.util.ArrayList;

import biomight.BioMightBase;
import biomight.Constants;
import biomight.cell.bloodandimmune.AnimalCells;
import biomight.cell.misc.Acidophils;
import biomight.cell.misc.Chromophobes;
import biomight.cell.misc.Gonadotrophs;
import biomight.cell.misc.Lactotrophs;
import biomight.view.BioMightMethodView;
import biomight.view.BioMightPropertyView;

/**
 * @author SurferJim
 *
 * This class represents the AdenoHypophysis, the anterior portion of the pituatary gland
 * 
 */

public class AdenoHypophysis extends BioMightBase {
	private ArrayList<BioMightPropertyView> properties;
	private ArrayList<BioMightMethodView> methods;
	
	private ParsDistalis ParsDistalis;
	private ParsIntermedia parsIntermedia;
	private ParsTuberalis parsTuberalis;
	private Chromophobes chromophobes;
	private AnimalCells basophils;
	private Acidophils acidophils;
	private Lactotrophs lactotrophs;;
	private RathkesPouch rathkesPouch;

	// a basophilic cell of the anterior pituitary specialized to secrete 
	// follicle-stimulating hormone and luteinizing hormone.
	private Gonadotrophs gonadotrophs;


	
	public AdenoHypophysis()
	{
		this.setImage("images/Chin.jpg");
		this.setImageHeight(300);
		this.setImageWidth(300);
		chromophobes = new Chromophobes();
		basophils = new AnimalCells();
		acidophils = new Acidophils();
		lactotrophs = new Lactotrophs();
		initProperties();
		initMethods();
	}

	
	
	public void initProperties() {

		properties = new ArrayList<BioMightPropertyView>();
		
		BioMightPropertyView property = new BioMightPropertyView();
		property.setPropertyName("Stapes ---");
		property.setCanonicalName(Constants.LeftEar);
		properties.add(property);
				
	}
	
	
	public void initMethods() {

		methods = new ArrayList<BioMightMethodView>();
		
		BioMightMethodView method = new BioMightMethodView();

		method = new BioMightMethodView();
		method.setMethodName("Deafness");
		method.setHtmlType("checkbox");
		methods.add(method);	
		
		method = new BioMightMethodView();
		method.setMethodName("Hear");
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
		
		// Assemble the Chin
		String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
		"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n " +
		"<X3D profile='Immersive' >\n" +
		"<head>\n" +
		 "<meta name='BioMightImage' content='Chin.jpg'/>\n" +
		 "<meta name='ExportTime' content='7:45:30'/>\n" +
		 "<meta name='ExportDate' content='08/15/2008'/>\n" +
		 "<meta name='BioMight Version' content='1.0'/>\n" + 
		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='Chin'\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		

		String body = "";//leftEar.getX3D(true) + rightEar.getX3D(true);  
		System.out.println("Chin X3D: " + body);		
		
		String footer = "</Scene>" + "</X3D>\n";
		
		if (snipet)
			return body;			
		else	
			return header + body + footer;
	}


	// Stress, Growth, and reproduction
	public void SecretePeptideHormone()
	{
	}
	
	public void setChromophobes()
	{
		// 50% of total
	}

	public void setBasophils()
	{
		// 10%
	}	
	
	public void setAcidophiles()
	{
		// 40%
	}

	
	public void secreteThyroidStimulatingHormone()
	{
	}
	
	public void secreteLuteinizingHormone()
	{
	}


}	
