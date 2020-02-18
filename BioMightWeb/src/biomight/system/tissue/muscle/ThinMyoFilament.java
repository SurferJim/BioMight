/*
 * Created on May 7, 2007
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.system.tissue.muscle;
import biomight.chemistry.protein.*;
/**
 * @author SurferJim
 *
 * To change the template for this generated type comment go to
 * Window&gt
 * ;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class ThinMyoFilament extends MyoFilament {
	private Actin actin;	
	private Troponin troponin;
	private Tropomyosin tropomyosin;
	
	public ThinMyoFilament()
	{
	this.setImage("images/ThinMyoFilament.jpg");
	this.setImageHeight(300);
	this.setImageWidth(300);
	}
}
