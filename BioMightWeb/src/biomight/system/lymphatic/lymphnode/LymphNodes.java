/*
 * Created on Jul 9, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.system.lymphatic.lymphnode;
import biomight.BioMightBase;

/**
 * @author SurferJim
 *
 * Humans have approximately 500-600 lymph nodes distributed throughout the body, 
 * with clusters found in the underarms, groin, neck, chest, and abdomen.
 * 
 */
public class LymphNodes extends BioMightBase {
	private LymphNode lymphNode;

	public LymphNodes()
	{
		this.setImage("images/LymphNodes.jpg");
		this.setImageHeight(300);
		this.setImageWidth(300);
	}
	
}
