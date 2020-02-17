/*
 * Created on Jul 7, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.body.foot;
import biomight.Constants;

/**
 * @author SurferJim
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class BigToe extends Toe {

	public BigToe(String leftRight)
	{
		if (leftRight.equals(Constants.LEFT))
			this.setImage("images/LeftBigToe.jpg");
		else
			this.setImage("images/RightBigToe.jpg");	
	}
}
