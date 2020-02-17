/*
 * Created on Oct 19, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.cell.epithelial.exocrinesecretory;
import biomight.chemistry.secretion.*;
import biomight.BioMightBase;

/**
 * @author SurferJim
 *
 * The secretory granules are contained within Goblet Cells and
 * are filled with mucus.
 * 
 */
public class SecretoryGranule extends BioMightBase {
	private Mucus muscus;

	public SecretoryGranule()
	{
		this.setImage("images/SecretoryGranule.jpg");
	}

	// This will excrete the mucus into the
	// areas surronding the cells exterior
	public void Exocytosis()
	{
		// Release the calcuim ions and the mucus will explode out
	}
}
