/*
 * Created on Jul 2, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.body.head.eye;
import biomight.system.vascular.BloodVessel;

/**
 * @author SurferJim
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class Choroid extends EyeSenseOrgan {
	private BloodVessel bloodVessel;
	
	public Choroid()
	{
		this.setImage("images/Choroid.jpg");
		this.setImageHeight(300);
		this.setImageWidth(300);
	}
	
}
