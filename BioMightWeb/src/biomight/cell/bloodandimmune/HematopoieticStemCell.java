/*
 * Created on Sep 26, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.cell.bloodandimmune;
import biomight.chemistry.protein.immunity.*;
import biomight.chemistry.cytokine.interlukin.*;
import biomight.chemistry.compound.*;

/**
 * @author SurferJim
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class HematopoieticStemCell {


	private CD34Protein cd34;



	public void onContact(Object obj)
	{	
		// Check if a virus is making contact with
		// the GastroIntestinal components

		if (obj instanceof Interlukin6)
		{
			// 
		}
		
		if (obj instanceof Interlukin11)
		{
			// 
		}		
		
		// SCF
		if (obj instanceof StemCellGrowthFactor)
		{
			// 
		}			
		
	}

	public void setTerminallyDifferentiated(){
	
	}

}
