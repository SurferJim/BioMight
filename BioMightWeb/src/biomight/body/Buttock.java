/*
 * Created on Jul 7, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.body;
import java.util.ArrayList;

import biomight.Constants;
import biomight.view.BioMightMethodView;
import biomight.view.BioMightPropertyView;

/**
 * @author SurferJim
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class Buttock extends BodyPart {
	

	public Buttock()
	{
		this.setImageHeight(300);
		this.setImageWidth(300);
	}	
	
	
	public ArrayList getProperties() {

		ArrayList<BioMightPropertyView> properties = new ArrayList<BioMightPropertyView>();
		
		BioMightPropertyView property = new BioMightPropertyView();
		property.setPropertyName("Fat Tissue");
		property.setCanonicalName(Constants.AnteriorLigament);
		properties.add(property);
		
		return properties;
	}
	
	
	public ArrayList getMethods() {

		ArrayList<BioMightMethodView> methods = new ArrayList<BioMightMethodView>();
		
		BioMightMethodView method = new BioMightMethodView();

		method = new BioMightMethodView();
		method.setMethodName("Squeeze");
		method.setHtmlType("text");
		method.setDataType("boolean");
		methods.add(method);	
			
		return methods;
	
	}
	
}
