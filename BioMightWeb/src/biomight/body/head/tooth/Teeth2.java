/*
 * Created on Jul 7, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.body.head.tooth;
import java.util.ArrayList;

import biomight.BioMightBase;
import biomight.Constants;
import biomight.system.ligament.head.mouth.PeriodontalLigament;
import biomight.view.BioMightMethodView;
import biomight.view.BioMightPropertyView;


/**
 * @author SurferJim
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class Teeth2 extends BioMightBase {
	private ArrayList<BioMightPropertyView> properties;
	private ArrayList<BioMightMethodView> methods;
	private  PeriodontalLigament periodontalLigament;

	// LEFT UPPER TEETH
	private LeftUpperCentralIncisor leftUpperCentralIncisor;
	private LeftUpperLateralIncisor leftUpperLateralIncisor;
	private LeftUpperCanine leftUpperCanine;
	private LeftUpper1stPreMolar leftUpper1stPreMolar;
	private LeftUpper2ndPreMolar leftUpper2ndPreMolar;
	private LeftUpper1stMolar leftUpper1stMolar;
	private LeftUpper2ndMolar leftUpper2ndMolar;
	private LeftUpper3rdMolar leftUpper3rdMolar;
 	private LeftUpperWisdomTooth leftUpperwisdomTooth;
	
 	// RIGHT UPPER TEETH
	private RightUpperCentralIncisor rightUpperCentralIncisor;
	private RightUpperLateralIncisor rightUpperLateralIncisor;
	private RightUpperCanine rightUpperCanine;
	private RightUpper1stPreMolar rightUpper1stPreMolar;
	private RightUpper2ndPreMolar rightUpper2ndPreMolar;
	private RightUpper1stMolar rightUpper1stMolar;
	private RightUpper2ndMolar rightUpper2ndMolar;
	private RightUpper3rdMolar rightUpper3rdMolar;
 	private RightUpperWisdomTooth rightUpperwisdomTooth;

 	
	// LEFT LOWER TEETH
	private LeftLowerCentralIncisor leftLowerCentralIncisor;
	private LeftLowerLateralIncisor leftLowerLateralIncisor;
	private LeftLowerCanine leftLowerCanine;
	private LeftLower1stPreMolar leftLower1stPreMolar;
	private LeftLower2ndPreMolar leftLower2ndPreMolar;
	private LeftLower1stMolar leftLower1stMolar;
	private LeftLower2ndMolar leftLower2ndMolar;
	private LeftLower3rdMolar leftLower3rdMolar;
 	private LeftLowerWisdomTooth leftLowerwisdomTooth;
	
 	// RIGHT LOWER TEETH
	private RightLowerCentralIncisor rightLowerCentralIncisor;
	private RightLowerLateralIncisor rightLowerLateralIncisor;
	private RightLowerCanine rightLowerCanine;
	private RightLower1stPreMolar rightLower1stPreMolar;
	private RightLower2ndPreMolar rightLower2ndPreMolar;
	private RightLower1stMolar rightLower1stMolar;
	private RightLower2ndMolar rightLower2ndMolar;
	private RightLower3rdMolar rightLower3rdMolar;
 	private RightLowerWisdomTooth rightLowerwisdomTooth;

 
 
	// Instantiate the teeth
	public Teeth2()
	{
		setImage("images/Teeth.jpg");
		 		 
		// LEFT UPPER TEETH
		leftUpperCentralIncisor = new LeftUpperCentralIncisor();
		leftUpperLateralIncisor = new  LeftUpperLateralIncisor();
		leftUpperCanine = new  LeftUpperCanine();
		leftUpper1stPreMolar = new  LeftUpper1stPreMolar();
		leftUpper2ndPreMolar = new  LeftUpper2ndPreMolar();
		leftUpper1stMolar = new  LeftUpper1stMolar();
		leftUpper2ndMolar = new  LeftUpper2ndMolar();
		leftUpper3rdMolar = new  LeftUpper3rdMolar();
		leftUpperwisdomTooth = new LeftUpperWisdomTooth();
			
		// RIGHT UPPER TEETH
		rightUpperCentralIncisor = new RightUpperCentralIncisor();
		rightUpperLateralIncisor = new RightUpperLateralIncisor();
		rightUpperCanine = new RightUpperCanine();
		rightUpper1stPreMolar = new RightUpper1stPreMolar();
		rightUpper2ndPreMolar = new RightUpper2ndPreMolar();
		rightUpper1stMolar = new RightUpper1stMolar();
		rightUpper2ndMolar = new RightUpper2ndMolar();
		rightUpper3rdMolar = new RightUpper3rdMolar();
		rightUpperwisdomTooth = new RightUpperWisdomTooth();

		 	
		// LEFT LOWER TEETH
		leftLowerCentralIncisor = new LeftLowerCentralIncisor();
		leftLowerLateralIncisor = new LeftLowerLateralIncisor();
		leftLowerCanine = new LeftLowerCanine();
		leftLower1stPreMolar = new LeftLower1stPreMolar();
		leftLower2ndPreMolar = new LeftLower2ndPreMolar();
		leftLower1stMolar = new LeftLower1stMolar();
		leftLower2ndMolar = new LeftLower2ndMolar();
		leftLower3rdMolar = new LeftLower3rdMolar();
		leftLowerwisdomTooth = new LeftLowerWisdomTooth();
			
		// RIGHT LOWER TEETH
		rightLowerCentralIncisor = new RightLowerCentralIncisor();
		rightLowerLateralIncisor = new RightLowerLateralIncisor();
		rightLowerCanine = new RightLowerCanine();
		rightLower1stPreMolar = new RightLower1stPreMolar();
		rightLower2ndPreMolar = new RightLower2ndPreMolar();
		rightLower1stMolar = new RightLower1stMolar();
		rightLower2ndMolar = new RightLower2ndMolar();
		rightLower3rdMolar = new RightLower3rdMolar();
		rightLowerwisdomTooth = new RightLowerWisdomTooth();		 
		 
		initProperties();
		initMethods();
	}



	
	public void initProperties() {

		properties = new ArrayList<BioMightPropertyView>();
		
		
		
		// LEFT UPPER TEETH
		
		BioMightPropertyView property = new BioMightPropertyView();
		property.setPropertyName("Upper Teeth");
		property.setCanonicalName(Constants.Title);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("Left Upper Central Incisor");
		property.setCanonicalName(Constants.LeftUpperCentralIncisor);
		properties.add(property);
	
		property = new BioMightPropertyView();
		property.setPropertyName("Left Upper Lateral Tooth");
		property.setCanonicalName(Constants.LeftUpperLateralIncisor);
		properties.add(property);		

		property = new BioMightPropertyView();
		property.setPropertyName("Left Upper Canine Tooth");
		property.setCanonicalName(Constants.LeftUpperCanine);
		properties.add(property);	
		
		property = new BioMightPropertyView();
		property.setPropertyName("1st Premolar");
		property.setCanonicalName(Constants.LeftUpper1stPreMolar);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("2nd Premolar");
		property.setCanonicalName(Constants.LeftUpper2ndPreMolar);
		properties.add(property);			
	
		property = new BioMightPropertyView();
		property.setPropertyName("1st Molar");
		property.setCanonicalName(Constants.LeftUpper1stMolar);
		properties.add(property);		
			
		property = new BioMightPropertyView();
		property.setPropertyName("2nd Molar");
		property.setCanonicalName(Constants.LeftUpper2ndMolar);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("Wisdom Tooth");
		property.setCanonicalName(Constants.LeftUpperWisdomTooth);
		properties.add(property);
		
		// RIGHT UPPER TEETH
		property = new BioMightPropertyView();
		property.setPropertyName("Right Upper Central Incisor");
		property.setCanonicalName(Constants.RightUpperCentralIncisor);
		properties.add(property);
	
		property = new BioMightPropertyView();
		property.setPropertyName("Right Upper Lateral Tooth");
		property.setCanonicalName(Constants.RightUpperLateralIncisor);
		properties.add(property);		

		property = new BioMightPropertyView();
		property.setPropertyName("Right Upper Canine Tooth");
		property.setCanonicalName(Constants.RightUpperCanine);
		properties.add(property);	
		
		property = new BioMightPropertyView();
		property.setPropertyName("1st Premolar");
		property.setCanonicalName(Constants.RightUpper1stPreMolar);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("2nd Premolar");
		property.setCanonicalName(Constants.RightUpper2ndPreMolar);
		properties.add(property);			
			
		property = new BioMightPropertyView();
		property.setPropertyName("1st Molar");
		property.setCanonicalName(Constants.RightUpper1stMolar);
		properties.add(property);		

		property = new BioMightPropertyView();
		property.setPropertyName("2nd Molar");
		property.setCanonicalName(Constants.RightUpper2ndMolar);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("Wisdom Tooth");
		property.setCanonicalName(Constants.RightUpperWisdomTooth);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("Lower Teeth");
		property.setCanonicalName(Constants.Title);
		properties.add(property);
		
		
		// LEFT LOWER TEETH
		property = new BioMightPropertyView();
		property.setPropertyName("Left Lower Central Incisor");
		property.setCanonicalName(Constants.LeftLowerCentralIncisor);
		properties.add(property);
	
		property = new BioMightPropertyView();
		property.setPropertyName("Left Lower Lateral Tooth");
		property.setCanonicalName(Constants.LeftLowerLateralIncisor);
		properties.add(property);		

		property = new BioMightPropertyView();
		property.setPropertyName("Left Lower Canine Tooth");
		property.setCanonicalName(Constants.LeftLowerCanine);
		properties.add(property);	
		
		property = new BioMightPropertyView();
		property.setPropertyName("1st Premolar");
		property.setCanonicalName(Constants.LeftLower1stPreMolar);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("2nd Premolar");
		property.setCanonicalName(Constants.LeftLower2ndPreMolar);
		properties.add(property);			
	
		property = new BioMightPropertyView();
		property.setPropertyName("1st Molar");
		property.setCanonicalName(Constants.LeftLower1stMolar);
		properties.add(property);		

			
		property = new BioMightPropertyView();
		property.setPropertyName("2nd Molar");
		property.setCanonicalName(Constants.LeftLower2ndMolar);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("Wisdom Tooth");
		property.setCanonicalName(Constants.LeftLowerWisdomTooth);
		properties.add(property);

		
		// RIGHT LOWER TEETH
		property = new BioMightPropertyView();
		property.setPropertyName("Right Lower Central Incisor");
		property.setCanonicalName(Constants.RightLowerCentralIncisor);
		properties.add(property);
	
		property = new BioMightPropertyView();
		property.setPropertyName("Right Lower Lateral Tooth");
		property.setCanonicalName(Constants.RightLowerLateralIncisor);
		properties.add(property);		

		property = new BioMightPropertyView();
		property.setPropertyName("Right Lower Canine Tooth");
		property.setCanonicalName(Constants.RightLowerCanine);
		properties.add(property);	
		
		property = new BioMightPropertyView();
		property.setPropertyName("1st Premolar");
		property.setCanonicalName(Constants.RightLower1stPreMolar);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("2nd Premolar");
		property.setCanonicalName(Constants.RightLower2ndPreMolar);
		properties.add(property);			

			
		property = new BioMightPropertyView();
		property.setPropertyName("1st Molar");
		property.setCanonicalName(Constants.RightLower1stMolar);
		properties.add(property);		

			
		property = new BioMightPropertyView();
		property.setPropertyName("2nd Molar");
		property.setCanonicalName(Constants.RightLower2ndMolar);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("Wisdom Tooth");
		property.setCanonicalName(Constants.RightLowerWisdomTooth);
		properties.add(property);

	}
	
	public void initMethods() {

		methods = new ArrayList<BioMightMethodView>();
		
		BioMightMethodView method = new BioMightMethodView();

		method = new BioMightMethodView();
		method.setMethodName("Wear");
		method.setHtmlType("checkbox");
		methods.add(method);	
		
		method = new BioMightMethodView();
		method.setMethodName("Repair");
		method.setHtmlType("text");
		methods.add(method);	


		method = new BioMightMethodView();
		method.setMethodName("Chip");
		method.setHtmlType("text");
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
		 "<meta name='BioMightImage' content='Teeth.jpg'/>\n" +
		 "<meta name='ExportTime' content='7:45:30'/>\n" +
		 "<meta name='ExportDate' content='08/15/2008'/>\n" +
		 "<meta name='BioMight Version' content='1.0'/>\n" + 
		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='Teeth'\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		

		String body = 
			leftUpperCentralIncisor.getX3D(true) + 
			leftUpperLateralIncisor.getX3D(true) +
			leftUpperCanine.getX3D(true) +
			leftUpper1stPreMolar.getX3D(true) +
			leftUpper2ndPreMolar.getX3D(true) +
			leftUpper1stMolar.getX3D(true) +
			leftUpper2ndMolar.getX3D(true) +
			leftUpper3rdMolar.getX3D(true) +
			leftUpperwisdomTooth.getX3D(true) +
				
			rightUpperCentralIncisor.getX3D(true) +
			rightUpperLateralIncisor.getX3D(true) +
			rightUpperCanine.getX3D(true) +
			rightUpper1stPreMolar.getX3D(true) +
			rightUpper2ndPreMolar.getX3D(true) +
			rightUpper1stMolar.getX3D(true) +
			rightUpper2ndMolar.getX3D(true) +
			rightUpper3rdMolar.getX3D(true) +
			rightUpperwisdomTooth.getX3D(true) +

			leftLowerCentralIncisor.getX3D(true) +
			leftLowerLateralIncisor.getX3D(true) +
			leftLowerCanine.getX3D(true) +
			leftLower1stPreMolar.getX3D(true) +
			leftLower2ndPreMolar.getX3D(true) +
			leftLower1stMolar.getX3D(true) +
			leftLower2ndMolar.getX3D(true) +
			leftLower3rdMolar.getX3D(true) +
			leftLowerwisdomTooth.getX3D(true) +
				
			// RIGHT LOWER TEETH
			rightLowerCentralIncisor.getX3D(true) +
			rightLowerLateralIncisor.getX3D(true) +
			rightLowerCanine.getX3D(true) +
			rightLower1stPreMolar.getX3D(true) +
			rightLower2ndPreMolar.getX3D(true) +
			rightLower1stMolar.getX3D(true) +
			rightLower2ndMolar.getX3D(true) +
			rightLower3rdMolar.getX3D(true) +
			rightLowerwisdomTooth.getX3D(true);
		
		
		System.out.println("Teeth X3D: " + body);		
		
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
