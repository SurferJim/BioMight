/*
 * Created on Apr 24, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.body;
import biomight.body.organ.Organ;
import biomight.chemistry.secretion.GastricJuice;

/**
 * @author SurferJim
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class DorsalMesogastrium extends Organ {


	public DorsalMesogastrium()
	{
		this.setImage("images/Esophagus.jpg");	
	}

	public void onContact(Object obj)
	{	
		// Gastric Juice causes 

		if (obj instanceof GastricJuice)
		{
			// Inflamation and death of epithelial cells
		}
	}
	
	public void Peristalisis()
	{
	}
}
