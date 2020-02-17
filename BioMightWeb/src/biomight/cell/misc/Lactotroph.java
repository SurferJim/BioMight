/*
 * Created on Oct 24, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.cell.misc;
import biomight.chemistry.hormones.aminederived.catecholamines.*;
import biomight.chemistry.hormones.steroid.sex.estrogens.*;
import biomight.chemistry.hormones.protein.Prolactin;

/**
 * @author SurferJim
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class Lactotroph {
	private Prolactin prolactin;
	
	
	public void onContact(Object obj)
	{	
		// Check if a virus is making contact with
		// the GastroIntestinal components

		if (obj instanceof Dopamine)
		{
			// Inhibit release of Prolactin
		}

		if (obj instanceof Estrogen)
		{
			// Produce Prolactin
		}
	}

	public void createProlactin()
	{
	}
}