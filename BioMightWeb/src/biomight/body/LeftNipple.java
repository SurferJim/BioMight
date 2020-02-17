/*
 * Created on Feb 18, 2007
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.body;
import biomight.Constants;
import biomight.BioMightBase;
import biomight.body.hair.NippleHair;


/**
 * @author SurferJim
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class LeftNipple extends Nipple {
	private NippleHair nippleHair;
	
	public LeftNipple()
	{
		this.setImage("images/LeftNipple.gif");
		this.setMesh("");
	}

	public NippleHair getNippleHair() {
		return nippleHair;
	}

	public void setNippleHair(NippleHair nippleHair) {
		this.nippleHair = nippleHair;
	}
	
}
