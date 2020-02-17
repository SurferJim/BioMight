/*
 * Created on Jul 13, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.body.gland.prostate;
import java.util.ArrayList;

import biomight.Constants;
import biomight.body.organ.Organ;
import biomight.body.secretions.Semen;
import biomight.system.tissue.epithelial.TransitionalEpitheliumTissue;
import biomight.view.BioMightMethodView;
import biomight.view.BioMightPropertyView;

/**
 * @author SurferJim
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class ProstrateGland extends Organ {
	private ArrayList<BioMightPropertyView> properties;
	private ArrayList<BioMightMethodView> methods;
	
	private Semen semen;
	private ProstaticUrethra prostaticUrethra;
	private TransitionalEpitheliumTissue transitionalEpitheliumTissue;
	
	private PeripheralZone peripheralZone;
	private CentralZone centralZone;
	private TransitionZone transitionZone;
	private AnteriorFibroMuscularZone anteriorFibroMuscularZone;
	
	private ProstateAnteriorLobe prostateAnteriorLobe;
	
	
	public ProstrateGland()
	{
		setImage("images/ProstrateGland.jpg");
		setImageHeight(300);
		setImageWidth(300);

	
		
		initProperties();
		initMethods();
		System.out.println("Created Mouth");
	} 
	
	
	public void initProperties() {

		properties = new ArrayList<BioMightPropertyView>();

		BioMightPropertyView property = new BioMightPropertyView();
		property.setPropertyName("Lips");
		property.setCanonicalName(Constants.Lips);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("Teeth");
		property.setCanonicalName(Constants.Teeth);
		properties.add(property);

	}
	

	public void initMethods() {

		methods = new ArrayList<BioMightMethodView>();
		
		BioMightMethodView method = new BioMightMethodView();

		method = new BioMightMethodView();
		method.setMethodName("Reproduce");
		method.setHtmlType("checkbox");
		methods.add(method);	
		
		method = new BioMightMethodView();
		method.setMethodName("Mate");
		method.setHtmlType("text");
		methods.add(method);	

		method = new BioMightMethodView();
		method.setMethodName("Lyse");
		method.setHtmlType("text");
		methods.add(method);	
	
	}	
	
}
