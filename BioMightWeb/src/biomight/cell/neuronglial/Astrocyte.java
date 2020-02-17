/*
 * Created on Apr 28, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.cell.neuronglial;
import biomight.chemistry.compound.ArachidonicAcid;

/**
 * @author SurferJim
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class Astrocyte extends GlialCell {
	private ArachidonicAcid arachidonicAcid;
	private boolean isCalciumSignal;

	public Astrocyte()
	{
		this.setImage("images/Astrocyte.jpg");
		this.setImageHeight(300);
		this.setImageWidth(300);
	}

}
