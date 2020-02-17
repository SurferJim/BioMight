/*
 * Created on Apr 26, 2006
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
 * Configuration object for creating a Eucaryote.
 * 
 */

public class EucaryoteConfig extends BioMightMethodView {
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
}
