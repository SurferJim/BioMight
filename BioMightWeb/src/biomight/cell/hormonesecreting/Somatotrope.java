/*
 * Created on Apr 24, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.cell.hormonesecreting;
import biomight.chemistry.hormones.protein.GrowthHormone;
import biomight.chemistry.hormones.protein.GrowthHormoneReleasingHormone;

/**
 * @author SurferJim
 *
 * Somatotropes are cells in the anterior pituitary which produce growth hormone. 
 * These cells constitute 40-50% of anterior pituitary cells. They respond by releasing 
 * HGH in response to GHRH (somatocrinin) or are inhibited by GHIH (somatostatin), both 
 * received from the hypothalamus via the hypophyseal portal system vein and the secondary plexus.
 * Somatotrope cells are classified as acidophilic cells.
 * 
 */

public class Somatotrope extends HormoneSecretingCell {
	private GrowthHormone growthHormone;
	private GrowthHormoneReleasingHormone growthHormoneReleasingHormone;
	
	
	public Somatotrope()
	{
		setImage("images/Somatotropes.gif");
		setImageWidth(250);
		setImageHeight(250);
	}
	
	

	/**
	 * When the Somatotrpope come in contact with ----- what happens.
	 */	
	
	public void onContact(Object obj)
	{
		
		if (obj instanceof GrowthHormoneReleasingHormone)
		{
			// 
		}

	}
	
}
