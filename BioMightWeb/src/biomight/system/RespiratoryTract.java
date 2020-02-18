/*
 * Created on Jul 8, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.system;
import biomight.bacteria.pleomorphic.gramnegative.*;
import biomight.body.*;
import biomight.body.organ.Trachea;
import biomight.body.organ.lung.*;

import java.math.BigDecimal;

import biomight.bacteria.cocci.gramnegative.*;
import biomight.bacteria.cocci.grampositive.*;
import biomight.bacteria.pleomorphic.grampositive.*;
import biomight.virus.rna.picornaviridae.*;
import biomight.virus.rna.*;
import biomight.virus.dna.*;

/**
 * @author SurferJim
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class RespiratoryTract {

	private Lungs lungs;
	private Trachea trachea;
	

	public void setLungCapacity(BigDecimal percent)
	{
	}
	

	public void onContact(Object obj)
	{
		

		/**
		 *  Bacteria
		 */	
	
		if (obj instanceof StreptococcusPneumoniae)
		{
			// Pneumonia
		}
		

		
		if (obj instanceof HaemophilusInfluenzae)
		{
		}
		
		if (obj instanceof MycobacteriumTuberculosis)
		{
		}

		/**
		 *  Bacteria
		 */	
		
		if (obj instanceof RhinoVirus)
		{
		}


		if (obj instanceof RespiratorySyncytialVirus)
		{
		}
		
		if (obj instanceof MeaslesVirus)
		{
		}		

		if (obj instanceof MumpsVirus)
		{
		}
		
		if (obj instanceof RubellaVirus)
		{
		}

		if (obj instanceof HantaVirus)
		{
		}				

		if (obj instanceof Adenovirus)
		{
		}	
	}


	public void setMucous()
	{		
	}		
	
}

