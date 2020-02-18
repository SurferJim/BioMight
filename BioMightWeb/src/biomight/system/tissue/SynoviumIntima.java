/*
 * Created on May 20, 2007
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.system.tissue;

import biomight.BioMightBase;
import biomight.cell.extracellularmatrixsecretion.Fibroblasts;

/**
 * @author SurferJim
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class SynoviumIntima extends BioMightBase {
	private Fibroblasts fibroBlasts;
	 
	public SynoviumIntima()
	{
		this.setImage("images/SynoviumSubintima.jpg");
		this.setImageHeight(300);
		this.setImageWidth(300);
	}
}
