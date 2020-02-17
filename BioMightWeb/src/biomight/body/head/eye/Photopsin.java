/*
 * Created on Jul 2, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.body.head.eye;

import biomight.chemistry.protein.opsin.*;
import biomight.chemistry.compound.*;
/**
 * @author SurferJim
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class Photopsin extends EyeSenseOrgan {

	private Opsin opsin;
	private Retinal retinal;

	public Photopsin()
	{
		this.setImage("images/Photopsin.jpg");
		this.setImageHeight(300);
		this.setImageWidth(300);
	}	
}
