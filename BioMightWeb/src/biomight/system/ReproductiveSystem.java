/*
 * Created on Jul 8, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.system;
import java.util.ArrayList;

import biomight.BioMightBase;
import biomight.Constants;
import biomight.body.gland.prostate.*;
import biomight.body.female.*;
import biomight.body.male.*;
import biomight.body.gland.ovary.*;
import biomight.view.BioMightMethodView;
import biomight.view.BioMightPropertyView;


/**
 * @author SurferJim
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class ReproductiveSystem  extends BioMightBase {

	//private Prostate prostrate;	
	private Penis penis;
	private Teste teste;
	private Vagina vagina;
	private Ovaries ovaries;
	
	
	public ReproductiveSystem()
	{
		setImage("images/ReproductiveSystem.jpg");
	}

	public ArrayList getProperties() {

		ArrayList<BioMightPropertyView> properties = new ArrayList<BioMightPropertyView>();
		BioMightPropertyView property;

		property = new BioMightPropertyView();
		property.setPropertyName("Man");
		property.setCanonicalName(Constants.Title);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("Prostate Gland");
		property.setCanonicalName(Constants.ProstrateGland);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("Penis");
		property.setCanonicalName(Constants.Penis);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("Teste");
		property.setCanonicalName(Constants.ReteTestis);
		properties.add(property);

	
		property = new BioMightPropertyView();
		property.setPropertyName("Woman");
		property.setCanonicalName(Constants.Title);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("Vagina");
		property.setCanonicalName(Constants.Vagina);
		properties.add(property);
		
		return properties;
	}
	
	
	public ArrayList getMethods() {

		ArrayList<BioMightMethodView> methods = new ArrayList<BioMightMethodView>();

		BioMightMethodView method;
		
		method = new BioMightMethodView();
		method.setMethodName("Reproduce");
		method.setHtmlType("checkbox");
		methods.add(method);
		
		
		return methods;
	}

	
	
	public void setFertility()
	{	
	}

	public void setPathogenesis()
	{	
	}

}
