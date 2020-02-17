/*
 * Created on Apr 26, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.cell.epithelial.exocrinesecretory;
import biomight.irritants.*;

/**
 * @author SurferJim
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class GobletCell {
	private SecretoryGranules secretoryGranules;
	

	public void onContact(Object obj)
	{
		if (obj instanceof Smoke || obj instanceof Dust)
		{
			// Call upon the Secretory Granules to carry out Exocytosis
			
		}
	}
	
	/**
	 * Tell the Goblet cell to secrete Mucus on a continous, steady flow
	 */
	public void basalSecretion()
	{
	}

	/**
	 * Tell the Goblet cell to secrete Mucus in response to stimlation
	 */
	public void stimulatedSecretion()
	{
	}
	
	
	
}
