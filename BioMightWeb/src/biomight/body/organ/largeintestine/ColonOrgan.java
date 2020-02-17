/*
 * Created on Jul 9, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.body.organ.largeintestine;
import biomight.bacteria.cocci.grampositive.*;
import biomight.system.tissue.epithelial.*;

/**
 * @author SurferJim *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class ColonOrgan {
	
	private StratifiedEpithelialTissue stratifiedEpithelialTissue;
	
	public void onContact(Object obj)
	{	
		// Check if a bacteria is making contact with
		// the GastroIntestinal components
		if (obj instanceof StreptococcusFaecalis)
		{
			// 
		}
	}

}
