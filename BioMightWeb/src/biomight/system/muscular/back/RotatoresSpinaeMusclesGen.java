/*
 * Created on Sep 19, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.system.muscular.back;
import java.util.ArrayList;

import biomight.Constants;
import biomight.system.tissue.muscle.Muscle;
import biomight.view.BioMightMethodView;
import biomight.view.BioMightPropertyView;

/**
 * @author SurferJim
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class RotatoresSpinaeMusclesGen extends Muscle {

	//	 Left Side
	private RotatoresSpinaeMuscleLeft1 rotatoresSpinaeMuscleLeft1;
	private RotatoresSpinaeMuscleLeft2 rotatoresSpinaeMuscleLeft2;
	private RotatoresSpinaeMuscleLeft3 rotatoresSpinaeMuscleLeft3;
	private RotatoresSpinaeMuscleLeft4 rotatoresSpinaeMuscleLeft4;
	private RotatoresSpinaeMuscleLeft5 rotatoresSpinaeMuscleLeft5;
	private RotatoresSpinaeMuscleLeft6 rotatoresSpinaeMuscleLeft6;
	private RotatoresSpinaeMuscleLeft7 rotatoresSpinaeMuscleLeft7;
	private RotatoresSpinaeMuscleLeft8 rotatoresSpinaeMuscleLeft8;
	private RotatoresSpinaeMuscleLeft9 RotatoresSpinaeMuscleLeft9;
	private RotatoresSpinaeMuscleLeft10 rotatoresSpinaeMuscleLeft10;
	private RotatoresSpinaeMuscleLeft11 rotatoresSpinaeMuscleLeft11;
	
	// Right Side
	private RotatoresSpinaeMuscleRight1 rotatoresSpinaeMuscleRight1;
	private RotatoresSpinaeMuscleRight2 rotatoresSpinaeMuscleRight2;
	private RotatoresSpinaeMuscleRight3 rotatoresSpinaeMuscleRight3;
	private RotatoresSpinaeMuscleRight4 rotatoresSpinaeMuscleRight4;
	private RotatoresSpinaeMuscleRight5 rotatoresSpinaeMuscleRight5;
	private RotatoresSpinaeMuscleRight6 rotatoresSpinaeMuscleRight6;
	private RotatoresSpinaeMuscleRight7 rotatoresSpinaeMuscleRight7;
	private RotatoresSpinaeMuscleRight8 rotatoresSpinaeMuscleRight8;
	private RotatoresSpinaeMuscleRight9 rotatoresSpinaeMuscleRight9;
	private RotatoresSpinaeMuscleRight10 rotatoresSpinaeMuscleRight10;
	private RotatoresSpinaeMuscleRight11 rotatoresSpinaeMuscleRight11;


	public RotatoresSpinaeMusclesGen()
	{
		this.setImage("images/RotatoresSpinaeMuscle.jpg");
		this.setImageHeight(300);
		this.setImageWidth(300);
	}
	
	
	public ArrayList getProperties() {

		ArrayList<BioMightPropertyView> properties = new ArrayList<BioMightPropertyView>();

		BioMightPropertyView property;
		
		// LEFT SIDE
		property = new BioMightPropertyView();
		property.setPropertyName("Rotatores Spinae Left Side");
		property.setCanonicalName(Constants.Title);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("Rotatores Spinae Muscle Left1");
		property.setCanonicalName(Constants.RotatoresSpinaeMuscleLeft1);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("Rotatores Spinae Muscle Left2");
		property.setCanonicalName(Constants.RotatoresSpinaeMuscleLeft2);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("Rotatores Spinae Muscle Left3");
		property.setCanonicalName(Constants.RotatoresSpinaeMuscleLeft3);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("Rotatores Spinae Muscle Left4");
		property.setCanonicalName(Constants.RotatoresSpinaeMuscleLeft4);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("Rotatores Spinae Muscle Left5");
		property.setCanonicalName(Constants.RotatoresSpinaeMuscleLeft5);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("Rotatores Spinae Muscle Left6");
		property.setCanonicalName(Constants.RotatoresSpinaeMuscleLeft6);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("Rotatores Spinae Muscle Left7");
		property.setCanonicalName(Constants.RotatoresSpinaeMuscleLeft7);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("Rotatores Spinae Muscle Left8");
		property.setCanonicalName(Constants.RotatoresSpinaeMuscleLeft8);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("Rotatores Spinae Muscle Left9");
		property.setCanonicalName(Constants.RotatoresSpinaeMuscleLeft9);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("Rotatores Spinae Muscle Left10");
		property.setCanonicalName(Constants.RotatoresSpinaeMuscleLeft10);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("Rotatores Spinae Muscle Left11");
		property.setCanonicalName(Constants.RotatoresSpinaeMuscleLeft11);
		properties.add(property);		
		
		// RIGHT SIDE
		property = new BioMightPropertyView();
		property.setPropertyName("Rotatores Spinae Right Side");
		property.setCanonicalName(Constants.Title);
		properties.add(property);
		
		/**
		property = new BioMightPropertyView();
		property.setPropertyName("Rotatores Spinae Muscle Right1");
		property.setCanonicalName(Constants.RotatoresSpinaeMuscleRight1);
		properties.add(property);	

		property = new BioMightPropertyView();
		property.setPropertyName("Rotatores Spinae Muscle Right2");
		property.setCanonicalName(Constants.RotatoresSpinaeMuscleRight2);
		properties.add(property);	
		
		property = new BioMightPropertyView();
		property.setPropertyName("Rotatores Spinae Muscle Right3");
		property.setCanonicalName(Constants.RotatoresSpinaeMuscleRight3);
		properties.add(property);	
		
		property = new BioMightPropertyView();
		property.setPropertyName("Rotatores Spinae Muscle Right4");
		property.setCanonicalName(Constants.RotatoresSpinaeMuscleRight4);
		properties.add(property);	
		
		property = new BioMightPropertyView();
		property.setPropertyName("Rotatores Spinae Muscle Right5");
		property.setCanonicalName(Constants.RotatoresSpinaeMuscleRight5);
		properties.add(property);	
		
		property = new BioMightPropertyView();
		property.setPropertyName("Rotatores Spinae Muscle Right6");
		property.setCanonicalName(Constants.RotatoresSpinaeMuscleRight6);
		properties.add(property);	
		
		property = new BioMightPropertyView();
		property.setPropertyName("Rotatores Spinae Muscle Right7");
		property.setCanonicalName(Constants.RotatoresSpinaeMuscleRight7);
		properties.add(property);	
		
		property = new BioMightPropertyView();
		property.setPropertyName("Rotatores Spinae Muscle Right8");
		property.setCanonicalName(Constants.RotatoresSpinaeMuscleRight8);
		properties.add(property);	
		
		property = new BioMightPropertyView();
		property.setPropertyName("Rotatores Spinae Muscle Right9");
		property.setCanonicalName(Constants.RotatoresSpinaeMuscleRight9);
		properties.add(property);	
		
		property = new BioMightPropertyView();
		property.setPropertyName("Rotatores Spinae Muscle Right10");
		property.setCanonicalName(Constants.RotatoresSpinaeMuscleRight10);
		properties.add(property);	
		
		property = new BioMightPropertyView();
		property.setPropertyName("Rotatores Spinae Muscle Right11");
		property.setCanonicalName(Constants.RotatoresSpinaeMuscleRight11);
		properties.add(property);
		*/
		
		return properties;
	}
	
	
	public ArrayList getMethods() {

		ArrayList<BioMightMethodView> methods = new ArrayList<BioMightMethodView>();
		BioMightMethodView method;
		
		method = new BioMightMethodView();
		method.setMethodName("Constrict");
		method.setHtmlType("checkbox");
		methods.add(method);

		method = new BioMightMethodView();
		method.setMethodName("Relax");
		method.setHtmlType("checkbox");
		methods.add(method);

		method = new BioMightMethodView();
		method.setMethodName("Muscle Density");
		method.setHtmlType("text");
		methods.add(method);
		
		return methods;
	}
		
	
}
