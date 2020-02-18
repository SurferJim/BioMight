/*
 * Created on May 3, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.system.vascular.arteries;
import biomight.BioMightBase;
import biomight.system.tissue.connective.blood.Blood;
import biomight.system.vascular.BloodVessel;
import java.math.BigDecimal;

/**
 * @author SurferJim
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class Artery extends BioMightBase {
	private boolean isRupture;
	private Blood blood;
	private ArterialPlaque arterialPlaque;
	
	public Artery()
	{
		setImage("images/Artery.jpg");
		setImageWidth(200);
		setImageHeight(300);
	}


	
	
}
