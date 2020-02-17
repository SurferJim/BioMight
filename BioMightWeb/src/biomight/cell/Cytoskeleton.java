/*
 * Created on Apr 26, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.cell;
import biomight.BioMightBase;

import biomight.cell.filaments.*;
import java.math.BigDecimal;

/**
 * @author SurferJim
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class Cytoskeleton extends BioMightBase {
	
	
	private BigDecimal diameter = new BigDecimal("7");
	
	private ActinFilaments actinFilaments;
	private MicroTubules microtubules;
	private IntermediateFilaments intermediateFilaments;
	
	public Cytoskeleton()
	{
		this.setImage("images/Cytoskeleton.jpg");
	}
	
}
