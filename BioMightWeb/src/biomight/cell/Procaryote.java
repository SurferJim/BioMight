/*
 * Created on Apr 26, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.cell;
import biomight.BioMightBase;
import biomight.cell.nucleus.*;
import biomight.chemistry.compound.*;
import java.math.BigDecimal;
import biomight.cell.bloodandimmune.*;


/**
 * @author SurferJim
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class Procaryote extends BioMightBase {


	public Procaryote()
	{
		this.setImage("images/Procaryote.jpg");
	}

	public void onContact(Object obj)
	{	


		if (obj instanceof CytotoxicTCell)
		{
			// Cytotoxic T Cells will interact strongly
			// if the cell is virus infected.
			
		}
	}
}
