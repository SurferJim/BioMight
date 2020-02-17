/*
 * Created on Jun 11, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.cell.extracellularmatrixsecretion;

import biomight.cell.Eucaryote;
import biomight.chemistry.compound.Hyaluronan;

/**
 * @author SurferJim
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class Fibroblast extends Eucaryote {
	private Hyaluronan hyaluronan;
	
	public Fibroblast()
	{
		this.setImage("images/Fibroblast.jpg");
		this.setImageHeight(300);
		this.setImageWidth(300);
	}
	
}
