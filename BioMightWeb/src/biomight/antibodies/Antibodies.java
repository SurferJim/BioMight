/*
 * Created on Oct 15, 2004
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.antibodies;
import java.util.ArrayList;

import biomight.BioMightBase;
import biomight.Constants;
import biomight.chemistry.aminoacid.AminoAcid;
import biomight.view.BioMightMethodView;
import biomight.view.BioMightPropertyView;


/**
 * @author Administrator
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class Antibodies extends BioMightBase {
	private IgA igA;
	private IgD igD;
	private IgE igE;
	private IgG igG;
	private IgM igM;

	
	public Antibodies()
	{
		this.setImage("images/Antibodies.jpg");
		setImageHeight(250);
		setImageWidth(200);
	}	
	
	
	
	public ArrayList getProperties() {

		ArrayList<BioMightPropertyView> properties = new ArrayList<BioMightPropertyView>();

		BioMightPropertyView property = new BioMightPropertyView();
		property.setPropertyName("IGA");
		property.setCanonicalName(Constants.IgA);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("IGD");
		property.setCanonicalName(Constants.IgD);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("IGE");
		property.setCanonicalName(Constants.IgG);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("IGG");
		property.setCanonicalName(Constants.IgG);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("IGM");
		property.setCanonicalName(Constants.IgM);
		properties.add(property);
		
		
		return properties;
	}
	
	
	public ArrayList getMethods() {

		ArrayList<BioMightMethodView> methods = new ArrayList<BioMightMethodView>();
		BioMightMethodView method;
		

		method = new BioMightMethodView();
		method.setMethodName("Activate");
		method.setHtmlType("text");
		method.setHtmlType("boolean");
		methods.add(method);
		
		return methods;
	}
		
	
}
