/*
 * Created on Jul 2, 2007
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.chemistry.compound;

import biomight.chemistry.elements.*;
import biomight.chemistry.compound.*;

/**
 * @author SurferJim
 *
 * Main Cations: 
 * 	Sodium (140 mM) 
 * 	Potassium (4 mM) 
 * 	Calcium (2 mM)
 * Main Anions: 
 * 	Chloride (110 mM) 
 * 	Hydrogen Carbonate (26 mM)
 * 
 * It is poorer in proteins compared to intracellular fluid
 * 
 */

public class ExtraCellularFluid extends Compound {
	private Sodium sodium;
	private Potassium potassium;
	private Calcium calcium;
	private Chlorine chlorine;
	private HydrogenCarbonate hydrogenCarbonate;
	
	public ExtraCellularFluid()
	{
		this.setImage("images/ExtraCellularFluid.gif");
		this.setImageWidth(320);
		this.setImageHeight(400);

		sodium = new Sodium();
		potassium = new Potassium();  
		calcium = new Calcium(); 
		chlorine = new Chlorine(); 
		hydrogenCarbonate = new	HydrogenCarbonate();

	}
}
