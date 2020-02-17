/*
 * Created on Apr 24, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.cell.hormonesecreting;
import java.util.ArrayList;

/**
 * @author SurferJim
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class ThyroidEpithelialCells extends  HormoneSecretingCell {
	private ArrayList thyroidEpithelialCells;
	
	public ThyroidEpithelialCells()
	{
		setImage("images/ThyroidEpithelialCells.gif");
		setImageWidth(250);
		setImageHeight(250);
	}
			
	/**
	 * Create a bunch of Thyroid epitheilial cells and distribute along the inside of the
	 * thyroid gland
	 * 
	 */		
	public ThyroidEpithelialCells(int numThyroidEpithelialCells) {
		thyroidEpithelialCells = new ArrayList();
		
		for (int i=0; i<numThyroidEpithelialCells; i++)
		{
			ThyroidEpithelialCell thyroidEpithelialCell = new ThyroidEpithelialCell();
			thyroidEpithelialCells.add(i, thyroidEpithelialCell);
		}
			
	}
	
	
	
}
