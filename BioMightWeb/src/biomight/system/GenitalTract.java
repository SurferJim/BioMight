/*
 * Created on Oct 9, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.system;
import biomight.bacteria.cocci.gramnegative.*;
import biomight.bacteria.spirochete.TreponemaPallidum;
import biomight.bacteria.*;
import biomight.virus.papillomaviridae.*;
import biomight.fungus.*;

/**
 * @author SurferJim
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class GenitalTract {


	public void onContact(Object obj)
	{	
		// Check if a virus is making contact with
		// the GastroIntestinal components


		if (obj instanceof TreponemaPallidum)
		{
			// Syphillis
		}		

		if (obj instanceof ChlamydiaTrachomatis)
		{
			// Urethritis
		}			

		if (obj instanceof PapillomaVirus)
		{
			// Genital warts
		}	

		if (obj instanceof CandidaAlbicans)
		{
			// Vaginitis
		}	
		
	}

	public void setMucous()
	{		
	}

}
