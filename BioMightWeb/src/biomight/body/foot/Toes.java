/*
 * Created on Jul 7, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.body.foot;

import java.util.ArrayList;

import biomight.Constants;
import biomight.body.BodyPart;
import biomight.system.ligament.radius.AnnularLigaments;
import biomight.view.BioMightMethodView;
import biomight.view.BioMightPropertyView;

/**
 * @author SurferJim
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class Toes extends BodyPart {

	private BigToe ToeBig;
	private PinkyToe toePinky;
	private IndexToe toeMiddle;
	private RingToe ringToe;
	private MiddleToe middleToe;
	private AnnularLigaments annularLigaments;
	
	
	public ArrayList getProperties() {

		ArrayList<BioMightPropertyView> properties = new ArrayList<BioMightPropertyView>();
		
		// Observable
		BioMightPropertyView property = new BioMightPropertyView();
		property.setPropertyName("Common");
		property.setCanonicalName(Constants.Title);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("BigToe");
		property.setCanonicalName(Constants.BigToe);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("PinkyToe");
		property.setCanonicalName(Constants.PinkyToe);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("IndexToe");
		property.setCanonicalName(Constants.IndexToe);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("MiddleToe");
		property.setCanonicalName(Constants.MiddleToe);
		properties.add(property);
	
		property = new BioMightPropertyView();
		property.setPropertyName("Ligaments");
		property.setCanonicalName(Constants.Title);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("Annular Ligaments");
		property.setCanonicalName(Constants.AnnularLigament);
		properties.add(property);
			
		return properties;	
	}
	
	
	public ArrayList getMethods() {

		ArrayList<BioMightMethodView> methods = new ArrayList<BioMightMethodView>();
		
		BioMightMethodView method = new BioMightMethodView();

		method = new BioMightMethodView();
		method.setMethodName("Penetrate Cell");
		method.setHtmlType("text");
		method.setDataType("boolean");
		methods.add(method);
		
		method = new BioMightMethodView();
		method.setMethodName("Transcribe");
		method.setHtmlType("text");
		method.setDataType("boolean");
		methods.add(method);	
			
		method = new BioMightMethodView();
		method.setMethodName("UnCoat");
		method.setHtmlType("text");
		method.setDataType("boolean");
		methods.add(method);
		return methods;
	
	}
		
	
}
