/*
 * Created on Jul 26, 2006
 * Copyright 2006 - Biomight.org
 * 
 * This code is the not to be used without written permission from
 * BioMight.org
 * 
 */
 
package biomight.cell.extracellularmatrixsecretion;
import biomight.chemistry.hormones.aminederived.tryptophan.*;
import biomight.cell.Eucaryote;
import java.math.BigDecimal;

/**
 * @author SurferJim
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class Pinealocyte extends Eucaryote {
	private BigDecimal numMelatonin;
	private Melatonin melatonin;	 
		
	/**
	 * @return
	 */
	public Melatonin getMelatonin() {
		return melatonin;
	}

	/**
	 * @return
	 */
	public BigDecimal getNumMelatonin() {
		return numMelatonin;
	}

	/**
	 * @param melatonin
	 */
	public void setMelatonin(Melatonin melatonin) {
		this.melatonin = melatonin;
	}

	/**
	 * @param decimal
	 */
	public void setNumMelatonin(BigDecimal decimal) {
		numMelatonin = decimal;
	}

}
