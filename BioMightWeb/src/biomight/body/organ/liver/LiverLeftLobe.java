/*
 * Created on May 3, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.body.organ.liver;

import biomight.BioMightBase;

/**
 * @author SurferJim
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class LiverLeftLobe extends BioMightBase {
	private CaudateLobe caudateLobe;
	private LiverQuadrateLobe liverQuadrateLobe;
	
	public LiverLeftLobe()
	{
		this.setImage("images/LiverRightLateralLobe.jpg");
		setImageHeight(250);
		setImageWidth(200);
	}	

}
