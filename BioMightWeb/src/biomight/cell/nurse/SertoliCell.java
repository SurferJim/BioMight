/*
 * Created on Apr 28, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.cell.nurse;
import biomight.cell.Eucaryote;
import biomight.chemistry.hormones.steroid.sex.androgens.*;

/**
 * @author SurferJim
 *
 * It is activated by follicle-stimulating hormone, and has FSH-receptor on its membranes.
 */

public class SertoliCell extends Eucaryote{
	private AndrogenBindingProtein androgenBindingProtein;

	public SertoliCell()
	{
		this.setImage("images/Head.gif");
		this.setImageWidth(320);
		this.setImageHeight(400);
		
	}

	public void onContact(Object object)
	{
		
		// If FSH, start producing
		
	}
	
	public void setAndrogenBindingProtein()
	{
	}
	
}
