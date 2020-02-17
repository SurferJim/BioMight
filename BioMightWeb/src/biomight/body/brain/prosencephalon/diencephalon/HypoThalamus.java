/*
 * Created on May 8, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.body.brain.prosencephalon.diencephalon;
import java.util.ArrayList;

import biomight.Constants;
import biomight.body.BodyPart;
import biomight.cell.neuron.HypoPhysioTropicNeurons;
import biomight.chemistry.hormones.peptide.AdrenoCorticotropicHormone;
import biomight.chemistry.hormones.peptide.FollicleStimulatingHormone;
import biomight.chemistry.hormones.peptide.Oxytoxin;
import biomight.chemistry.hormones.peptide.ThyroxinStimulatingHormone;
import biomight.chemistry.hormones.peptide.Vasopressin;
import biomight.chemistry.hormones.protein.GrowthHormone;
import biomight.chemistry.hormones.protein.Prolactin;
import biomight.view.BioMightMethodView;
import biomight.view.BioMightPropertyView;

/**
 * @author SurferJim
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class HypoThalamus extends BodyPart {

	private ParaVentricularNucleus paraVentricularNucleus;
	
	private Hypophysis hypophysis;
	private OpticChiasm opticChiasma;
	private SupraopticNucleus supraopticNucleus;
	private SuprachiasmaticNucleus suprachiasmaticNucleus;
	
	private Vasopressin vasopressin;
	private Oxytoxin oxytoxin;
	private Prolactin prolactin;
	private GrowthHormone growthHormone;
	private AdrenoCorticotropicHormone acth;
	private ThyroxinStimulatingHormone thyroidStimHormone;
	private FollicleStimulatingHormone follicleStimHormone;
	
	private HypoPhysioTropicNeurons HypoPhysioTropicNeurons;
	
	
	public HypoThalamus()
	{
		this.setImage("images/HypoThalamus.jpg");
		setImageWidth(200);
		setImageHeight(250);	
	}
	
	
	public ArrayList getProperties() {

		ArrayList<BioMightPropertyView> properties = new ArrayList<BioMightPropertyView>();

		
		BioMightPropertyView property = new BioMightPropertyView();
		property.setPropertyName("Hypophysis");
		property.setCanonicalName(Constants.Hypophysis);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("OpticChiasm");
		property.setCanonicalName(Constants.OpticChiasm);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("SupraopticNucleus");
		property.setCanonicalName(Constants.SupraopticNucleus);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("SuprachiasmaticNucleus");
		property.setCanonicalName(Constants.SuprachiasmaticNucleus);
		properties.add(property);
		

		return properties;
	}
	
	
	public ArrayList getMethods() {

		ArrayList<BioMightMethodView> methods = new ArrayList<BioMightMethodView>();

		
		BioMightMethodView method = new BioMightMethodView();
		
		method = new BioMightMethodView();
		method.setMethodName("Execrete Vasopressin");
		method.setHtmlType("checkbox");
		method.setDataType("double");
		methods.add(method);

		method = new BioMightMethodView();
		method.setMethodName("Execrete Oxytoxin");
		method.setHtmlType("checkbox");
		method.setDataType("double");
		methods.add(method);

		method = new BioMightMethodView();
		method.setMethodName("Reproduce");
		method.setHtmlType("checkbox");
		method.setDataType("double");
		methods.add(method);
		
		return methods;
	}

	
	
	
	public void setACTH()
	{
		// Setting it at the gland level will
		// instruct the cells within the HypoThalamus to
		// produce AdrenoCorticoTropinHormone
	}

	public void setTSH()
	{
		// 
	}
	
	
	public void setFSH()
	{
		// 
	}
	
	public void setVassopressin()
	{
		// 
	}
	
	public void setBodyTemperature()
	{
	}
	
	public void setHunger()
	{
	}
	
	public void setThirst()
	{
	}
	
	public void setCircadianRhythm()
	{
	}
	
	public void setHypoCretin()
	{
	}
	
}
