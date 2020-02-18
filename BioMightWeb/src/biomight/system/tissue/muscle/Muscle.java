/*
 * Created on May 1, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.system.tissue.muscle;
import java.util.ArrayList;

import biomight.BioMightBase;
import biomight.Constants;
import biomight.chemistry.carbohydrate.polysaccharide.Glycogen;
import biomight.chemistry.compound.LacticAcid;
import biomight.chemistry.elements.Oxygen;
import biomight.system.tissue.Tissue;
import biomight.view.BioMightMethodView;
import biomight.view.BioMightPropertyView;

/**
 * @author SurferJim
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */


public class Muscle extends BioMightBase {

	private MuscleFiber muscleFibers;
	private Fascicles fascicles;
	private Myofibril myofibril;
	private Sarcoplasm sarcoplasm;
	private Epimysium epimysium;
	private Perimysium	perimysium;
	private Endomysium endomysium;
	private Glycogen glycogen;
	private Oxygen oxygen;
	private LacticAcid lacticAcid;
	
	
	public Muscle()
	{
		this.setImage("images/Muscle.jpg");
		this.setImageHeight(300);
		this.setImageWidth(300);
	}	
	
	public Muscle(MuscleConfig muscleConfig)
	{
		this.setImage("images/Muscle.jpg");
		this.setImageHeight(300);
		this.setImageWidth(300);
	}	
	
	
	
	public ArrayList getProperties() {

		ArrayList<BioMightPropertyView> properties = new ArrayList<BioMightPropertyView>();
	
		// Observable
		BioMightPropertyView property = new BioMightPropertyView();
		property.setPropertyName("MuscleFiber");
		property.setCanonicalName(Constants.MuscleFiber);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("Fascicles");
		property.setCanonicalName(Constants.Fascicles);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("Sarcoplasm");
		property.setCanonicalName(Constants.Sarcoplasm);
		properties.add(property);		

		property = new BioMightPropertyView();
		property.setPropertyName("Epimysium");
		property.setCanonicalName(Constants.Epimysium);
		properties.add(property);	
		
		property = new BioMightPropertyView();
		property.setPropertyName("Perimysium");
		property.setCanonicalName(Constants.Perimysium);
		properties.add(property);	

		property = new BioMightPropertyView();
		property.setPropertyName("Endomysium");
		property.setCanonicalName(Constants.Endomysium);
		properties.add(property);
		
		return properties;
	}
	
	
	public ArrayList getMethods() {

		ArrayList<BioMightMethodView> methods = new ArrayList<BioMightMethodView>();
		
		BioMightMethodView method = new BioMightMethodView();

		method = new BioMightMethodView();
		method.setMethodName("Think");
		method.setHtmlType("text");
		methods.add(method);	
			
		return methods;
	
	}
		
	
	public void contract()
	{
	}
	
	public void relax()
	{
	}	
	
	
}

