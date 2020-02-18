/*
 * Created on Jul 20, 2006
 * Copyright 2006 - Biomight.org
 * 
 * This code is the not to be used without written permission from
 * BioMight.org
 * 
 */
 
package biomight.system.vascular;
import biomight.Constants;
import biomight.body.organ.Organ;
import biomight.view.BioMightMethodView;
import biomight.view.BioMightPropertyView;

import java.math.BigDecimal;
import java.util.ArrayList;

/**
 * @author SurferJim
 *
 * To change the template for a&gt;Code Generation&gt;Code and Comments
 */

public class BloodVessel extends Organ {
	private BigDecimal vasoconstriction;
	private BigDecimal vasodilation;
	private TunicaAdventitia tunicaAdventitia;
	private TunicaMedia tunicaMedia;
	private TunicaIntima tunicaIntima;
	
	 
	public BloodVessel()
	{
		this.setImage("images/BloodVessel.jpg");
		this.setImageHeight(300);
		this.setImageWidth(300);
	} 
	 
	
	public ArrayList getProperties() {

		ArrayList<BioMightPropertyView> properties = new ArrayList<BioMightPropertyView>();
		
		BioMightPropertyView property = new BioMightPropertyView();
		property.setPropertyName("TunicaAdventitia");
		//property.setCanonicalName(Constants.TunicaAdventitia);
		properties.add(property);
	
		property = new BioMightPropertyView();
		property.setPropertyName("TunicaMedia");
		//property.setCanonicalName(Constants.TunicaMedia);
		properties.add(property);		

		property = new BioMightPropertyView();
		property.setPropertyName("TunicaIntima");
		//property.setCanonicalName(Constants.TunicaIntima);
		properties.add(property);	
	
	
		return properties;
	}
	
	
	public ArrayList getMethods() {

		ArrayList<BioMightMethodView> methods = new ArrayList<BioMightMethodView>();
		
		BioMightMethodView method = new BioMightMethodView();

		method = new BioMightMethodView();
		method.setMethodName("Constrict");
		method.setHtmlType("text");
		methods.add(method);	
;		
		return methods;
	
	}
	
	
	
	
	
	/**
	 * @return
	 */
	public BigDecimal getVasoconstriction() {
		return vasoconstriction;
	}

	/**
	 * @return
	 */
	public BigDecimal getVasodilation() {
		return vasodilation;
	}

	/**
	 * @param decimal
	 */
	public void setVasoconstriction(BigDecimal decimal) {
		vasoconstriction = decimal;
	}

	/**
	 * @param decimal
	 */
	public void setVasodilation(BigDecimal decimal) {
		vasodilation = decimal;
	}


	public TunicaAdventitia getTunicaAdventitia() {
		return tunicaAdventitia;
	}


	public void setTunicaAdventitia(TunicaAdventitia tunicaAdventitia) {
		this.tunicaAdventitia = tunicaAdventitia;
	}


	public TunicaIntima getTunicaIntima() {
		return tunicaIntima;
	}


	public void setTunicaIntima(TunicaIntima tunicaIntima) {
		this.tunicaIntima = tunicaIntima;
	}


	public TunicaMedia getTunicaMedia() {
		return tunicaMedia;
	}


	public void setTunicaMedia(TunicaMedia tunicaMedia) {
		this.tunicaMedia = tunicaMedia;
	}

}
