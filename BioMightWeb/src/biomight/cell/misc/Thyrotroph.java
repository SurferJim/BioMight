/*
 * Created on Oct 29, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.cell.misc;
import biomight.BioMightBase;
import biomight.chemistry.hormones.peptide.ThyroxinStimulatingHormone;

/**
 * @author SurferJim
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class Thyrotroph extends BioMightBase {
	private ThyroxinStimulatingHormone thyroxinStimulatingHormone;
	
	
	public Thyrotroph()
	{
		this.setImage("images/Thyrotroph.jpg");
		this.setImageHeight(300);
		this.setImageWidth(300);
	}
	
	public void setTSH()
	{
	}
}
