/*
 * Created on Jul 20, 2006
 * Copyright 2006 - Biomight.org
 * 
 * This code is the not to be used without written permission from
 * BioMight.org
 * 
 */
 
package biomight.body.head.nose;
import biomight.body.BodyPart;
import biomight.Constants;


/**
 * @author SurferJim
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class Nostril extends BodyPart {

	public Nostril(String leftRight)
	{
		if (leftRight.equals(Constants.LEFT))
			this.setImage("images/LeftNostril.jpg");
		else
			this.setImage("images/RightNostril.jpg");	
	}
	
}
