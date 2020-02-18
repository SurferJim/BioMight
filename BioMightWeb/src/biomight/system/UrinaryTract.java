/*
 * Created on Jul 9, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.system;
import biomight.body.organ.kidney.*;
import biomight.body.organ.bladder.*;
import java.math.BigDecimal;
import biomight.chemistry.compound.*;
import biomight.bacteria.cocci.grampositive.*;

/**
 * @author SurferJim
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class UrinaryTract {

	private Bladder bladder;
	private Kidneys kidneys;
	private Urine urine;



	public void onContact(Object obj)
	{
		
		// Check if a virus is making contact with
		// the GastroIntestinal components
		if (obj instanceof StaphylococcusSaprophyticus)
		{
			// Dysentery
		}
	}
	
	public void setMucous()
	{		
	}
	
}
