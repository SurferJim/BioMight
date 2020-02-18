/*
 * Created on Jul 8, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.system;
import biomight.BioMightBase;

import biomight.body.organ.liver.*;
import biomight.body.organ.pancreas.*;
import biomight.body.gland.thyroid.*;
import biomight.body.gland.pineal.*;
import biomight.body.gland.pituitary.*;
import biomight.body.gland.adrenal.*;
import biomight.body.gland.ovary.*;
import biomight.body.male.*;
import biomight.body.brain.prosencephalon.diencephalon.*;
import biomight.chemistry.compound.GonadotropinReleasingHormone;
import biomight.chemistry.hormones.aminederived.catecholamines.Dopamine;

import java.math.BigDecimal;


/**
 * @author SurferJim
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class EndocrineSystem extends BioMightBase {
	
	/** Hypothalamus produced hormones */
	// TRH - Parvocellular neurosecretory neurons
	private BigDecimal thyrotropinReleasingHormone;
	// GnRH - Neuroendocine cells of the Preoptic area
	private BigDecimal gonadotropinReleasingHormone;
	// GHRH - Neuroendocrine neurons of the Arcuate nucleus
	private BigDecimal growthHormoneReleasingHormone;
	// CRH - Parvocellular neurosecretory neurons
	private BigDecimal corticotropinReleasingHormone;
	// Vasopressin - Parvocellular neurosecretory neurons
	private BigDecimal vasopressin;
 	// growth hormone-inhibiting hormone - Neuroendocrince cells of the Periventricular nucleus
	private BigDecimal somatostatin;
	// Dopamine - neurons of the arcuate nucleus
	private BigDecimal dopamine; 

	// Pineal body produced hormones
	private BigDecimal melatonin;

	// Pituitary gland (hypophysis) 
	// Anterior pituitary lobe (adenohypophysis)
	
	// Growth hormone (GH) Somatotropes
	private BigDecimal growthHormone;
	// Prolactin (PRL) Lactotropes
	private BigDecimal prolactin;
	// ACTH, corticotropin) Corticotropes
	private BigDecimal AdrenocorticotropicHormone;
	// Corticotropes
	private BigDecimal lipotropin;
	// (TSH, thyrotropin) Thyrotropes 
	private BigDecimal thyroidStimulatingHormone; 
	// (FSH) Gonadotropes
	private BigDecimal follicleStimulatingHormone;
	// (LH) Gonadotropes 
	private BigDecimal LuteinizingHormone; 
	
	// Posterior pituitary lobe (neurohypophysis)
	// Magnocellular neurosecretory cells
	private BigDecimal Oxytocin; 
	// Magnocellular neurosecretory cells
	//Intermediate pituitary lobe (pars intermedia)
	// (MSH) Melanotroph
	private BigDecimal melanocyteStimulatingHormone; 

	
	private HypoThalamus hypoThalamus;
	private AdrenalGland adrenal;
	private PinealGland pinealGland;
	private ThyroidGland thyroidGland;
	private Ovaries ovaries;
	private Testis testis;	
	private Pancreas pancreas;
	private PituitaryGland PituitaryGland;
	private boolean isFightorFlight;
	

	public EndocrineSystem()
	{
		this.setImage("images/EndocrineSystem.jpg");	
	}



	/**
	 * @return
	 */
	public BigDecimal getCorticotropinReleasingHormone() {
		return corticotropinReleasingHormone;
	}

	/**
	 * @return
	 */
	public BigDecimal getDopamine() {
		return dopamine;
	}

	/**
	 * @return
	 */
	public BigDecimal getGrowthHormoneReleasingHormone() {
		return growthHormoneReleasingHormone;
	}

	/**
	 * @return
	 */
	public BigDecimal getSomatostatin() {
		return somatostatin;
	}

	/**
	 * @return
	 */
	public BigDecimal getThyrotropinReleasingHormone() {
		return thyrotropinReleasingHormone;
	}

	/**
	 * @return
	 */
	public BigDecimal getVasopressin() {
		return vasopressin;
	}

	/**
	 * @param hormone
	 */
	public void setCorticotropinReleasingHormone(BigDecimal hormone) {
		corticotropinReleasingHormone = hormone;
	}

	/**
	 * @param dopamine
	 */
	public void setDopamine(BigDecimal hormone) {
		dopamine = hormone;
	}

	/**
	 * @param hormone
	 */
	public void setGrowthHormoneReleasingHormone(BigDecimal hormone) {
		growthHormoneReleasingHormone = hormone;
	}

	/**
	 * @param somatostatin
	 */
	public void setSomatostatin(BigDecimal somatostatin) {
		this.somatostatin = somatostatin;
	}

	/**
	 * @param hormone
	 */
	public void setThyrotropinReleasingHormone(BigDecimal hormone) {
		thyrotropinReleasingHormone = hormone;
	}

	/**
	 * @param vasopressin
	 */
	public void setVasopressin(BigDecimal hormone) {
		this.vasopressin = hormone;
	}

	/**
	 * @return
	 */
	public BigDecimal getAdrenocorticotropicHormone() {
		return AdrenocorticotropicHormone;
	}

	/**
	 * @return
	 */
	public BigDecimal getFollicleStimulatingHormone() {
		return follicleStimulatingHormone;
	}

	/**
	 * @return
	 */
	public BigDecimal getGrowthHormone() {
		return growthHormone;
	}

	/**
	 * @return
	 */
	public BigDecimal getLipotropin() {
		return lipotropin;
	}

	/**
	 * @return
	 */
	public BigDecimal getLuteinizingHormone() {
		return LuteinizingHormone;
	}

	/**
	 * @return
	 */
	public BigDecimal getMelanocyteStimulatingHormone() {
		return melanocyteStimulatingHormone;
	}

	/**
	 * @return
	 */
	public BigDecimal getMelatonin() {
		return melatonin;
	}

	/**
	 * @return
	 */
	public BigDecimal getOxytocin() {
		return Oxytocin;
	}

	/**
	 * @return
	 */
	public BigDecimal getProlactin() {
		return prolactin;
	}

	/**
	 * @return
	 */
	public BigDecimal getThyroidStimulatingHormone() {
		return thyroidStimulatingHormone;
	}

	/**
	 * @param decimal
	 */
	public void setAdrenocorticotropicHormone(BigDecimal decimal) {
		AdrenocorticotropicHormone = decimal;
	}

	/**
	 * @param decimal
	 */
	public void setFollicleStimulatingHormone(BigDecimal decimal) {
		follicleStimulatingHormone = decimal;
	}

	/**
	 * @param decimal
	 */
	public void setGrowthHormone(BigDecimal decimal) {
		growthHormone = decimal;
	}

	/**
	 * @param decimal
	 */
	public void setLipotropin(BigDecimal decimal) {
		lipotropin = decimal;
	}

	/**
	 * @param decimal
	 */
	public void setLuteinizingHormone(BigDecimal decimal) {
		LuteinizingHormone = decimal;
	}

	/**
	 * @param decimal
	 */
	public void setMelanocyteStimulatingHormone(BigDecimal decimal) {
		melanocyteStimulatingHormone = decimal;
	}

	/**
	 * @param decimal
	 */
	public void setMelatonin(BigDecimal decimal) {
		melatonin = decimal;
	}

	/**
	 * @param decimal
	 */
	public void setOxytocin(BigDecimal decimal) {
		Oxytocin = decimal;
	}

	/**
	 * @param decimal
	 */
	public void setProlactin(BigDecimal decimal) {
		prolactin = decimal;
	}

	/**
	 * @param decimal
	 */
	public void setThyroidStimulatingHormone(BigDecimal decimal) {
		thyroidStimulatingHormone = decimal;
	}

}
