/*
 * Created on Jul 9, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.system;
import biomight.Constants;
import biomight.body.organ.kidney.*;
import biomight.body.organ.bladder.*;

import java.math.BigDecimal;
import java.util.ArrayList;

import biomight.chemistry.compound.*;
import biomight.view.BioMightMethodView;
import biomight.view.BioMightPropertyView;


/**
 * @author SurferJim
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class UrinarySystem extends BioMightSystem {

	private Bladder bladder;
	private Kidneys kidneys;
	private Ureters ureters;
	private Urethra urethra;	 
	private Urine urine;

	public UrinarySystem()
	{
		this.setImage("images/UrinarySystem.jpg");
	}

	public ArrayList getProperties() {

		ArrayList<BioMightPropertyView> properties = new ArrayList<BioMightPropertyView>();

		// SURFACES
		BioMightPropertyView property = new BioMightPropertyView();
		property.setPropertyName("Bladder");
		property.setCanonicalName(Constants.Bladder);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("Kidneys");
		property.setCanonicalName(Constants.Kidneys);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("Ureters");
		property.setCanonicalName(Constants.Ureters);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("Urethra");
		property.setCanonicalName(Constants.Urethra);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("Urine");
		property.setCanonicalName(Constants.Urine);
		properties.add(property);

		return properties;
	}
	
	
	public ArrayList getMethods() {

		ArrayList<BioMightMethodView> methods = new ArrayList<BioMightMethodView>();

		
		BioMightMethodView method = new BioMightMethodView();
		
		method = new BioMightMethodView();
		method.setMethodName("Urinate");
		method.setHtmlType("checkbox");
		methods.add(method);

		method = new BioMightMethodView();
		method.setMethodName("Produce Urine");
		method.setHtmlType("checkbox");
		methods.add(method);

		method = new BioMightMethodView();
		method.setMethodName("Filter");
		method.setHtmlType("checkbox");
		methods.add(method);
		
		return methods;
	}	
	
	public void setUrinePercent(BigDecimal percent)
	{	
	
	}
}
