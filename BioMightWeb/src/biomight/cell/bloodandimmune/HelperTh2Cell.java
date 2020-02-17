/*
 * Created on Apr 28, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.cell.bloodandimmune;
import biomight.chemistry.cytokine.interlukin.*;
import biomight.chemistry.protein.immunity.*;
import biomight.chemistry.compound.*;

/**
 * @author SurferJim
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class HelperTh2Cell {

	private TCellReceptor tCellReceptor;	
	
	// bcells to antibodies
	private Interlukin4 interlukin4;
	private Interlukin5 interlukin5;
	
	// activate cd4 and cd8
	private Interlukin2 interlukin2;
	
	
	// activate macrophges
	private GammaInterferon GammaInterferon;
	
	private CD4Protein cd4Protein;
	private CD28Protein cd28Protein;



	public void onContact(Object obj)
	{
		if (obj instanceof BCell)
		{
			// Check to see if the BCell is antigen bound
			// If so start secretion.
			BCell bCell = (BCell) obj;
			
			//bCell.			
		}
	}
	
	
	public void setInterlukin4()
	{
		interlukin4 = new Interlukin4();
	}

	public void setInterlukin5()
	{
	}	
}
