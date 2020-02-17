/*
 * Created on Nov 2, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.antibodies;
import java.util.ArrayList;

import biomight.Constants;
import biomight.chemistry.aminoacid.AminoAcid;
import biomight.chemistry.aminoacid.AminoAcids;
import biomight.view.BioMightMethodView;
import biomight.view.BioMightPropertyView;

/**
 * @author SurferJim
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class AntibodyHeavyChain extends AminoAcids {

	// Each Domain is approximately 110 amino acids
	public AminoAcid variableDomain;
	public AminoAcid constantDomain1;
	public AminoAcid constantDomain2;
	public AminoAcid constantDomain3;
	

	public AntibodyHeavyChain()
	{
		this.setImage("images/AntibodyHeavyChain.jpg");
		setImageHeight(250);
		setImageWidth(200);
	}
	

	public ArrayList getProperties() {

		ArrayList<BioMightPropertyView> properties = new ArrayList<BioMightPropertyView>();

		BioMightPropertyView property = new BioMightPropertyView();
		property.setPropertyName("Variable Domain");
		property.setCanonicalName(Constants.IgD);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("Constant Domain 1");
		property.setCanonicalName(Constants.IgD);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("Constant Domain 2");
		property.setCanonicalName(Constants.IgD);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("Constant Domain 3");
		property.setCanonicalName(Constants.IgD);
		properties.add(property);
		
		return properties;
	}
	
	
	public ArrayList getMethods() {

		ArrayList<BioMightMethodView> methods = new ArrayList<BioMightMethodView>();
		BioMightMethodView method;
		
		method = new BioMightMethodView();
		method.setMethodName("Activate");
		method.setHtmlType("text");
		method.setDataType("boolean");
		methods.add(method);
		
		return methods;
	}
}
