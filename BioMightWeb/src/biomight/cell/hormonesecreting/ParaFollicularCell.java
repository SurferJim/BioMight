/*
 * Created on Apr 29, 2007
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.cell.hormonesecreting;
import biomight.chemistry.hormones.peptide.Calcitonin;
/**
 * @author SurferJim
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class ParaFollicularCell extends HormoneSecretingCell {
	private Calcitonin calcitonin;
	

	public ParaFollicularCell()
	{
		setImage("images/ParaFollicularCell.gif");
		setImageWidth(250);
		setImageHeight(250);
	}
}
