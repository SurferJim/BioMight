/*
 * Created on Apr 24, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.cell.hormonesecreting;
import biomight.chemistry.hormones.peptide.*;

/**
 * @author SurferJim
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class Corticotropes {
	
	
	
	public void onContact(Object obj)
	{	
		// Check if a virus is making contact with
		// the GastroIntestinal components

		if (obj instanceof CorticotropinReleasingHormone)
		{
			// On contact
			// SecreteAdrenoCorticoTropicHormone();
		}
	}
	
	
	
	public void SecreteAdrenoCorticoTropicHormone()
	{
	}
	
	
	public void SecreteBEndorphin()
	{
	}
	
}
