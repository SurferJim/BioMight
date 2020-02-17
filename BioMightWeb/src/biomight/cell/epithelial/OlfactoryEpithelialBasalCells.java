/*
 * Created on Jul 20, 2006
 * Copyright 2006 - Biomight.org
 * 
 * This code is the not to be used without written permission from
 * BioMight.org
 * 
 */
 
package biomight.cell.epithelial;
import java.util.ArrayList;

/**
 * @author SurferJim
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class OlfactoryEpithelialBasalCells {
	private ArrayList olfactoryEpithelialBasalCells;
	
	/*
	 * Create default Thymocytes
	 */
	public OlfactoryEpithelialBasalCells() {
	}
		
	/**
	 * Create a bunch of Lymphocytes and distribute them throughout the body
	 * 
	 */		
	public OlfactoryEpithelialBasalCells(int numOlfactoryBasalCells) {
		olfactoryEpithelialBasalCells = new ArrayList();
		
		for (int i=0; i<numOlfactoryBasalCells; i++)
		{
			OlfactoryEpithelialBasalCell olfactoryEpithelialBasalCell = new OlfactoryEpithelialBasalCell();
			olfactoryEpithelialBasalCells.add(i, olfactoryEpithelialBasalCells);
		}
			
	}

}
