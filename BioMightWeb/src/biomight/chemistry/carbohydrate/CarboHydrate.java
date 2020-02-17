/*
 * Created on May 2, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.chemistry.carbohydrate;
import biomight.BioMightBase;
import biomight.chemistry.elements.*;
import biomight.chemistry.compound.*;

/**
 * @author SurferJim
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class CarboHydrate extends BioMightBase {
	
	private Oxygen oxygen;
	private Hydrogen hydrogen;
	private Carbon carbon;

	public CarboHydrate()
	{
		this.setImage("images/CarboHydrate.jpg");
		this.setImageWidth(300);
		this.setImageHeight(325);
	}

	public void onContact(Object obj)
	{
	
		if (obj instanceof SalivaryAmylase)
		{
			// Start Breaking down the carbos
		}
	}
}
