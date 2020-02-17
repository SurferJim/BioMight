/*
 * Created on Jul 9, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.body.organ.skin.epidermis;
import java.util.ArrayList;

import biomight.BioMightBase;
import biomight.Constants;
import biomight.view.BioMightMethodView;
import biomight.view.BioMightPropertyView;

/**
 * @author SurferJim
 *
 * Representation of the Epidermis
 * 
 */
public class Epidermis extends BioMightBase {
	private ArrayList<BioMightPropertyView> properties;
	private ArrayList<BioMightMethodView> methods;
	private StratumCorneum stratumCorneum;
	private StratumLucidum stratumLucidum;
	private StratumGranulosum stratumGranulosum;
	private StratumSpinosum stratumSpinosum;
	private StratumBasale stratumBasale;
	
	
	public Epidermis()
	{
		this.setImage("images/Epidermis.jpg");
		this.setImageHeight(300);
		this.setImageWidth(300);
		
		stratumCorneum = new StratumCorneum();
		System.out.println("Created StratumCorneum");
		stratumLucidum = new StratumLucidum();
		System.out.println("Created StratumLucidum");
		stratumGranulosum = new StratumGranulosum();
		System.out.println("Created StratumGranulosum");
		stratumSpinosum = new StratumSpinosum();
		System.out.println("Created StratumSpinosum");
		stratumBasale = new StratumBasale();
		System.out.println("Created StratumBasale");
		
		initProperties();
		initMethods();
	}

	
	public void initProperties() {

		properties = new ArrayList<BioMightPropertyView>();

		BioMightPropertyView property = new BioMightPropertyView();
		property.setPropertyName("StratumCorneum");
		property.setCanonicalName(Constants.StratumCorneum);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("StratumLucidum");
		property.setCanonicalName(Constants.StratumLucidum);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("StratumGranulosum");
		property.setCanonicalName(Constants.StratumGranulosum);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("StratumSpinosum");
		property.setCanonicalName(Constants.StratumSpinosum);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("StratumLucidum");
		property.setCanonicalName(Constants.StratumLucidum);
		properties.add(property);
	}
	
	
	public void initMethods() {

		methods = new ArrayList<BioMightMethodView>();
		BioMightMethodView method;
		
		method = new BioMightMethodView();
		method.setMethodName("Crack");
		method.setHtmlType("checkbox");
		methods.add(method);

		method = new BioMightMethodView();
		method.setMethodName("Bruise");
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
		
		// Assembe the Skull
		String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
		"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n " +
		"<X3D profile='Immersive' >\n" +
		"<head>\n" +
		 "<meta name='BioMightImage' content='Skull.jpg'/>\n" +
		 "<meta name='ExportTime' content='7:45:30'/>\n" +
		 "<meta name='ExportDate' content='08/15/2008'/>\n" +
		 "<meta name='BioMight Version' content='1.0'/>\n" + 
		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='Skull'\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		

		String body = ""; //epidermis.getX3D(true);

		System.out.println("Skull X3D: " + body);		
		
		String footer = "</Scene>" + "</X3D>\n";
		
		if (snipet)
			return body;			
		else	
			return header + body + footer;

	}
	
	

	public void onMessage(String messageType)
	{
		
		// Something is touching the tounge.  The nerves in the tounge
		// will send a message to the Brain and ----- cells will release
		// solvents.
		if (messageType.equals("CONTACT"))
		{
			
			// Send a message to the brain
			
			// Start Digestion
			 
		}

		// Flip the tounge to move the food into the
		// ready to swallow position
		if (messageType.equals("SWALLOW"))
		{
			// Send a message to the object to
			// reposition it in the model.
			// sendMessage();
		}		


		// Carry out messages delivered from the brain
		if (messageType.equals("SPIT"))
		{
			// Send a message to the brain
			// Start Digestion 
		}		


		// Carry out messages delivered from the brain
		if (messageType.equals("EXPOSE TONGUE"))
		{
			// Send a message to the brain
			// Start Digestion 
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
	
		
}
	

