/*
 * Created on Oct 15, 2004
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.system.tissue.connective.bone;
import biomight.BioMightBase;
import biomight.chemistry.protein.MineralizedCollagen;

/**
 * @author SurferJim
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class CorticalBone extends Bone {
	
	private MineralizedCollagen mineralizedCollagen;

	public CorticalBone()
	{
		this.setImage("images/CorticalBone.jpg");
		this.setImageHeight(300);
		this.setImageWidth(300);
	}
	
}
