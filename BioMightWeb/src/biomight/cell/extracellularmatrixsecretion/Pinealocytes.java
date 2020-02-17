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
import java.util.ArrayList;
import java.math.BigDecimal;

/**
 * @author SurferJim
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class Pinealocytes {
	private BigDecimal numPinealocytes;
	private ArrayList pinealocyte = new ArrayList();
	

	/**
	 * @return
	 */
	public BigDecimal getNumPinealocytes() {
		return numPinealocytes;
	}

	/**
	 * @param decimal
	 */
	public void setNumPinealocytes(BigDecimal decimal) {
		numPinealocytes = decimal;
	}

}
