/*
 * Created on Sep 5, 2007
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.cell;


import java.math.BigDecimal;

import biomight.view.BioMightMethodView;

/**
 * @author SurferJim
 *
 * The Configuration Object for the cell.
 */

public class CellConfig extends BioMightMethodView {
	private boolean isBacterialInfected;
	private boolean isViralInfected;
	private boolean isFungalInfected;
	private boolean isParasiteInfected;
	private BigDecimal surfaceCharge;
	private BigDecimal setContactInhibition;
	private BigDecimal osmoticPressure;
	private BigDecimal cytosolVolume;
	private BigDecimal cellDiameter;
	private BigDecimal cellMembraneWidth;
	private BigDecimal numIonChannels;
	private BigDecimal numIonPumps;
	private BigDecimal numLysosomes;
	private BigDecimal numMitochondrian;
	private BigDecimal numRibosomes;
	private BigDecimal numVoltageGatedPotassiumChannels;
	private BigDecimal numVoltageGatedSodiumChannels;
	private BigDecimal numVoltageGatedCalciumChannels;
	
	
	/**
	 * @return
	 */
	public BigDecimal getCellDiameter() {
		return cellDiameter;
	}

	/**
	 * @return
	 */
	public BigDecimal getCellMembraneWidth() {
		return cellMembraneWidth;
	}

	/**
	 * @return
	 */
	public BigDecimal getCytosolVolume() {
		return cytosolVolume;
	}

	/**
	 * @return
	 */
	public boolean isBacterialInfected() {
		return isBacterialInfected;
	}

	/**
	 * @return
	 */
	public boolean isFungalInfected() {
		return isFungalInfected;
	}

	/**
	 * @return
	 */
	public boolean isParasiteInfected() {
		return isParasiteInfected;
	}

	/**
	 * @return
	 */
	public boolean isViralInfected() {
		return isViralInfected;
	}

	/**
	 * @return
	 */
	public BigDecimal getNumIonChannels() {
		return numIonChannels;
	}

	/**
	 * @return
	 */
	public BigDecimal getNumIonPumps() {
		return numIonPumps;
	}

	/**
	 * @return
	 */
	public BigDecimal getNumLysosomes() {
		return numLysosomes;
	}

	/**
	 * @return
	 */
	public BigDecimal getNumMitochondrian() {
		return numMitochondrian;
	}

	/**
	 * @return
	 */
	public BigDecimal getNumRibosomes() {
		return numRibosomes;
	}

	/**
	 * @return
	 */
	public BigDecimal getNumVoltageGatedCalciumChannels() {
		return numVoltageGatedCalciumChannels;
	}

	/**
	 * @return
	 */
	public BigDecimal getNumVoltageGatedPotassiumChannels() {
		return numVoltageGatedPotassiumChannels;
	}

	/**
	 * @return
	 */
	public BigDecimal getNumVoltageGatedSodiumChannels() {
		return numVoltageGatedSodiumChannels;
	}

	/**
	 * @return
	 */
	public BigDecimal getOsmoticPressure() {
		return osmoticPressure;
	}

	/**
	 * @return
	 */
	public BigDecimal getSetContactInhibition() {
		return setContactInhibition;
	}

	/**
	 * @return
	 */
	public BigDecimal getSurfaceCharge() {
		return surfaceCharge;
	}

	/**
	 * @param decimal
	 */
	public void setCellDiameter(BigDecimal decimal) {
		cellDiameter = decimal;
	}

	/**
	 * @param decimal
	 */
	public void setCellMembraneWidth(BigDecimal decimal) {
		cellMembraneWidth = decimal;
	}

	/**
	 * @param decimal
	 */
	public void setCytosolVolume(BigDecimal decimal) {
		cytosolVolume = decimal;
	}

	/**
	 * @param b
	 */
	public void setBacterialInfected(boolean b) {
		isBacterialInfected = b;
	}

	/**
	 * @param b
	 */
	public void setFungalInfected(boolean b) {
		isFungalInfected = b;
	}

	/**
	 * @param b
	 */
	public void setParasiteInfected(boolean b) {
		isParasiteInfected = b;
	}

	/**
	 * @param b
	 */
	public void setViralInfected(boolean b) {
		isViralInfected = b;
	}

	/**
	 * @param decimal
	 */
	public void setNumIonChannels(BigDecimal decimal) {
		numIonChannels = decimal;
	}

	/**
	 * @param decimal
	 */
	public void setNumIonPumps(BigDecimal decimal) {
		numIonPumps = decimal;
	}

	/**
	 * @param decimal
	 */
	public void setNumLysosomes(BigDecimal decimal) {
		numLysosomes = decimal;
	}

	/**
	 * @param decimal
	 */
	public void setNumMitochondrian(BigDecimal decimal) {
		numMitochondrian = decimal;
	}

	/**
	 * @param decimal
	 */
	public void setNumRibosomes(BigDecimal decimal) {
		numRibosomes = decimal;
	}

	/**
	 * @param decimal
	 */
	public void setNumVoltageGatedCalciumChannels(BigDecimal decimal) {
		numVoltageGatedCalciumChannels = decimal;
	}

	/**
	 * @param decimal
	 */
	public void setNumVoltageGatedPotassiumChannels(BigDecimal decimal) {
		numVoltageGatedPotassiumChannels = decimal;
	}

	/**
	 * @param decimal
	 */
	public void setNumVoltageGatedSodiumChannels(BigDecimal decimal) {
		numVoltageGatedSodiumChannels = decimal;
	}

	/**
	 * @param decimal
	 */
	public void setOsmoticPressure(BigDecimal decimal) {
		osmoticPressure = decimal;
	}

	/**
	 * @param decimal
	 */
	public void setSetContactInhibition(BigDecimal decimal) {
		setContactInhibition = decimal;
	}

	/**
	 * @param decimal
	 */
	public void setSurfaceCharge(BigDecimal decimal) {
		surfaceCharge = decimal;
	}

}
