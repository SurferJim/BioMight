/*
 * Created on Jul 7, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.body.head.tooth;
import java.util.ArrayList;

import biomight.chemistry.compound.*;
import biomight.view.BioMightMethodView;
import biomight.view.BioMightPropertyView;
import biomight.BioMightBase;
import biomight.Constants;

/**
 * @author SurferJim
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class Tooth2 extends BioMightBase {
	private ArrayList<BioMightPropertyView> properties;
	private ArrayList<BioMightMethodView> methods;

	
	public Tooth2()
	{
		this.setImage("images/Tooth.gif");
		this.setImageWidth(320);
		this.setImageHeight(400);
	}
	
	
	public ArrayList getProperties() {

		ArrayList<BioMightPropertyView> properties = new ArrayList<BioMightPropertyView>();
		
		BioMightPropertyView property = new BioMightPropertyView();
		property.setPropertyName("Enamel");
		property.setCanonicalName(Constants.Enamel);
		properties.add(property);
	
		property = new BioMightPropertyView();
		property.setPropertyName("Dentin");
		property.setCanonicalName(Constants.Dentin);
		properties.add(property);				

		property = new BioMightPropertyView();
		property.setPropertyName("Root");
		property.setCanonicalName(Constants.Root);
		properties.add(property);				
		
		return properties;
	}
	
	
	public ArrayList getMethods() {

		ArrayList<BioMightMethodView> methods = new ArrayList<BioMightMethodView>();
		
		BioMightMethodView method;

		method = new BioMightMethodView();
		method.setMethodName("Chip");
		method.setHtmlType("checkbox");
		methods.add(method);	
			
		return methods;
	
	}	
	

}
