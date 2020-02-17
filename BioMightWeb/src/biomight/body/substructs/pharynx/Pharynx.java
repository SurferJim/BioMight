/*
 * Created on Jul 9, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.body.substructs.pharynx;
import java.util.ArrayList;

import biomight.Constants;
import biomight.misc.*;
import biomight.view.BioMightMethodView;
import biomight.view.BioMightPropertyView;
import biomight.body.organ.Organ;


/**
 * @author SurferJim
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class Pharynx extends Organ {
	
	private Nasopharynx Nasopharynx;
	
	public Pharynx()
	{
		this.setImage("images/Pharynx.jpg");	
	}
	
	
	public ArrayList getProperties() {

		ArrayList<BioMightPropertyView> properties = new ArrayList<BioMightPropertyView>();
		BioMightPropertyView property;

		property = new BioMightPropertyView();
		property.setPropertyName("Nasopharynx");
		//property.setCanonicalName(Constants.Nasopharynx);
		properties.add(property);
	
		
		return properties;
	}
	
	
	public ArrayList getMethods() {

		ArrayList<BioMightMethodView> methods = new ArrayList<BioMightMethodView>();
		
		BioMightMethodView method = new BioMightMethodView();
		
		method = new BioMightMethodView();
		method.setMethodName("Swallow");
		method.setHtmlType("checkbox");
		methods.add(method);
		
		return methods;
	}
	

	
	public void onContact(Object obj)
	{
	
		if (obj instanceof Bolus)
		{
			// There are touch receptors that trigger peristalis
		}
	}
	
	
	
	
}
