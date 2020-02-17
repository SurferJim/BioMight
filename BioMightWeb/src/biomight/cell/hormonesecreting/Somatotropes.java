/*
 * Created on Apr 24, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.cell.hormonesecreting;
import java.util.ArrayList;
import java.math.BigDecimal;

/**
 * @author SurferJim
 *
 * Represents a bunch of Somatotropes
 */

public class Somatotropes extends HormoneSecretingCell {
	private ArrayList somatotropes;
	private BigDecimal numSomatotropes;
		
		
	public Somatotropes()
	{
		setImage("images/Somatotropes.gif");
		setImageWidth(250);
		setImageHeight(250);
	}
	
	/**
	 * Create a bunch of Somatotropes based in the iniit parameter
	 * @param initSomatotropes 
	 */
	public Somatotropes(int initSomatotropes)
	{
		for (int i=0; i<initSomatotropes; i++)
		{
			Somatotrope somatotrope = new Somatotrope();
			somatotropes.add(somatotrope);
		}
	}
}
