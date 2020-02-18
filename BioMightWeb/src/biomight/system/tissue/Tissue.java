/*
 * Created on Feb 11, 2007
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.system.tissue;
import java.util.ArrayList;

import biomight.BioMightBase;
import biomight.Constants;
import biomight.view.BioMightMethodView;
import biomight.view.BioMightPropertyView;

/**
 * @author SurferJim
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class Tissue extends BioMightBase {

	private Tissue tissue;

	public Tissue()
	{
		this.setImage("images/Tissues.gif");	
	}
	
	public ArrayList getProperties() {

		ArrayList<BioMightPropertyView> properties = new ArrayList<BioMightPropertyView>();

		BioMightPropertyView property = new BioMightPropertyView();
		property.setPropertyName("Mitochondria");
		property.setCanonicalName(Constants.Mitochondria);
		properties.add(property);
	
		return properties;
	}
	
	
	public ArrayList getMethods() {

		ArrayList<BioMightMethodView> methods = new ArrayList<BioMightMethodView>();
		BioMightMethodView method;
		
		method = new BioMightMethodView();
		method.setMethodName("Mitosis");
		method.setHtmlType("text");
		methods.add(method);

		method = new BioMightMethodView();
		method.setMethodName("Anaphase");
		method.setHtmlType("text");
		methods.add(method);
		
		method = new BioMightMethodView();
		method.setMethodName("ATP");
		method.setHtmlType("text");
		methods.add(method);
		
		
		return methods;
	}
		
	
}
