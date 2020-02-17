/*
 * Created on May 3, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.body.organ.smallintestine;

import biomight.BioMightBase;
import biomight.cell.epithelial.Enterocytes;
import biomight.cell.epithelial.exocrinesecretory.GobletCellOfDigestiveTract;
import biomight.system.lymphatic.Lacteal;
import biomight.system.vascular.capillary.Capillary;

/**
 * @author SurferJim
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class Villi extends BioMightBase {

	private Enterocytes enterocytes; 
	private Capillary capillary;
	private GobletCellOfDigestiveTract gobletCellOfDigestiveTract;
	private Lacteal lacteal;
	
	public Villi()
	{
		this.setImage("images/Villi.gif");
		this.setImageWidth(320);
		this.setImageHeight(400);
		
	}
}
