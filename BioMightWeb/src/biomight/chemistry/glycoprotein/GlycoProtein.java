/*
 * Created on Jul 20, 2006
 * Copyright 2006 - Biomight.org
 * 
 * This code is the not to be used without written permission from
 * BioMight.org
 * 
 */
 
package biomight.chemistry.glycoprotein;
import biomight.chemistry.carbohydrate.*;
import biomight.chemistry.compound.Compound;
import biomight.chemistry.protein.*;

/**
 * @author SurferJim
 *
 * Creates a representation of a GlycoProtein
 */

public class GlycoProtein extends Compound {
	private Protein protein;
	private CarboHydrate carboHydrate;
}
