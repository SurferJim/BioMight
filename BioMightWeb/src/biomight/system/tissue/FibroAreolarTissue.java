/*
 * Created on Jul 6, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.system.tissue;
import biomight.cell.misc.*;

/**
 * @author SurferJim
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class FibroAreolarTissue extends Tissue {
	
	private LamellarCells lamellarCells;
	private Clasmatocytes clasmatocytes;
	private GranuleCells granuleCells;
	
	public FibroAreolarTissue()
	{
		this.setImage("images/FibroAreolarTissue.jpg");
		setImageHeight(250);
		setImageWidth(200);
	}	
}
