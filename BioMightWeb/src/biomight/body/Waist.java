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
public class Waist extends BodyPart {


	public Waist()
	{
		this.setImage("images/Waist.jpg");
	}
	
	
	public ArrayList getProperties() {

		ArrayList<BioMightPropertyView> properties = new ArrayList<BioMightPropertyView>();
		
		BioMightPropertyView property = new BioMightPropertyView();
		property.setPropertyName("Stomach");
		property.setCanonicalName(Constants.Stomach);
		properties.add(property);
	
		property = new BioMightPropertyView();
		property.setPropertyName("Large Intestine");
		property.setCanonicalName(Constants.LargeIntestine);
		properties.add(property);		
				
		property = new BioMightPropertyView();
		property.setPropertyName("Small Intestine");
		property.setCanonicalName(Constants.SmallIntestine);
		properties.add(property);		
	
		return properties;
	}
	
	
	public ArrayList getMethods() {

		ArrayList<BioMightMethodView> methods = new ArrayList<BioMightMethodView>();
		
		BioMightMethodView method = new BioMightMethodView();

		method = new BioMightMethodView();
		method.setMethodName("Set Girth");
		method.setHtmlType("text");
		method.setDataType("double");
		methods.add(method);	
			
		return methods;
	
	}	
}
