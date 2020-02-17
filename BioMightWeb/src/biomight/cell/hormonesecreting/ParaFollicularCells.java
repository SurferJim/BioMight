/*
 * Created on Apr 29, 2007
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.cell.hormonesecreting;
import biomight.cell.Eucaryote;
import biomight.chemistry.hormones.peptide.Calcitonin;

/**
 * @author SurferJim
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */

public class ParaFollicularCells extends Eucaryote {
	private Calcitonin calcitonin;
	
	public ParaFollicularCells()
	{
		this.setImage("images/Uvea.jpg");
		this.setImageHeight(300);
		this.setImageWidth(300);
	}
	
}
