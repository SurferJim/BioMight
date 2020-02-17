/*
 * Created on Oct 12, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.system.lymphatic.thorax.deep;
import biomight.bacteria.rods.grampositive.*;
import biomight.disease.noninfectious.*;

/**
 * @author SurferJim
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class MediastinalLymphNodes {
	
	
	public void onContact(Object obj)
	{
		
		// Check if a virus is making contact with
		// the GastroIntestinal components
		if (obj instanceof BacillusAnthracis)
		{
			// Invoke Disease of HemorrhagicMediastinitis
			HemorrhagicMediastinitis hemorrhagicMediastinitis = new HemorrhagicMediastinitis();
		}
	}	
	
	
	public void Hemorrhage()
	{
	}

}
