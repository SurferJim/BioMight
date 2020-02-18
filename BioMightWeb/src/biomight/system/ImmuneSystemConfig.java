/*
 * Created on Aug 13, 2007
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.system;


import java.math.BigDecimal;

import biomight.view.BioMightMethodView;

/**
 * @author SurferJim
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */

public class ImmuneSystemConfig extends BioMightMethodView {

	private BigDecimal thymosin;
	private BigDecimal anitbodyTiter;
	private BigDecimal complementC3b;
	private BigDecimal complementC6;
	private BigDecimal complementC7;
	private BigDecimal complementC8;
	private BigDecimal neutrophilTiter;
	private BigDecimal cd4Titer;
	
	private int numLeukocytes;
	private int numMonocytes;
	private int numMacrophages;
	private int numBasophils;
	private int numEosinophils;
	private int numNeutrophils;
	private int numLymphocytes;
		

	/**
	 * @return
	 */
	public BigDecimal getAnitbodyTiter() {
		return anitbodyTiter;
	}

	/**
	 * @return
	 */
	public BigDecimal getCd4Titer() {
		return cd4Titer;
	}

	/**
	 * @return
	 */
	public BigDecimal getComplementC3b() {
		return complementC3b;
	}

	/**
	 * @return
	 */
	public BigDecimal getComplementC6() {
		return complementC6;
	}

	/**
	 * @return
	 */
	public BigDecimal getComplementC7() {
		return complementC7;
	}

	/**
	 * @return
	 */
	public BigDecimal getComplementC8() {
		return complementC8;
	}

	/**
	 * @return
	 */
	public BigDecimal getNeutrophilTiter() {
		return neutrophilTiter;
	}

	/**
	 * @return
	 */
	public int getNumBasophils() {
		return numBasophils;
	}

	/**
	 * @return
	 */
	public int getNumEosinophils() {
		return numEosinophils;
	}

	/**
	 * @return
	 */
	public int getNumLeukocytes() {
		return numLeukocytes;
	}

	/**
	 * @return
	 */
	public int getNumLymphocytes() {
		return numLymphocytes;
	}

	/**
	 * @return
	 */
	public int getNumMacrophages() {
		return numMacrophages;
	}

	/**
	 * @return
	 */
	public int getNumMonocytes() {
		return numMonocytes;
	}

	/**
	 * @return
	 */
	public int getNumNeutrophils() {
		return numNeutrophils;
	}

	/**
	 * @return
	 */
	public BigDecimal getThymosin() {
		return thymosin;
	}

	/**
	 * @param decimal
	 */
	public void setAnitbodyTiter(BigDecimal decimal) {
		anitbodyTiter = decimal;
	}

	/**
	 * @param decimal
	 */
	public void setCd4Titer(BigDecimal decimal) {
		cd4Titer = decimal;
	}

	/**
	 * @param decimal
	 */
	public void setComplementC3b(BigDecimal decimal) {
		complementC3b = decimal;
	}

	/**
	 * @param decimal
	 */
	public void setComplementC6(BigDecimal decimal) {
		complementC6 = decimal;
	}

	/**
	 * @param decimal
	 */
	public void setComplementC7(BigDecimal decimal) {
		complementC7 = decimal;
	}

	/**
	 * @param decimal
	 */
	public void setComplementC8(BigDecimal decimal) {
		complementC8 = decimal;
	}

	/**
	 * @param decimal
	 */
	public void setNeutrophilTiter(BigDecimal decimal) {
		neutrophilTiter = decimal;
	}

	/**
	 * @param i
	 */
	public void setNumBasophils(int i) {
		numBasophils = i;
	}

	/**
	 * @param i
	 */
	public void setNumEosinophils(int i) {
		numEosinophils = i;
	}

	/**
	 * @param i
	 */
	public void setNumLeukocytes(int i) {
		numLeukocytes = i;
	}

	/**
	 * @param i
	 */
	public void setNumLymphocytes(int i) {
		numLymphocytes = i;
	}

	/**
	 * @param i
	 */
	public void setNumMacrophages(int i) {
		numMacrophages = i;
	}

	/**
	 * @param i
	 */
	public void setNumMonocytes(int i) {
		numMonocytes = i;
	}

	/**
	 * @param i
	 */
	public void setNumNeutrophils(int i) {
		numNeutrophils = i;
	}

	/**
	 * @param decimal
	 */
	public void setThymosin(BigDecimal decimal) {
		thymosin = decimal;
	}

}
