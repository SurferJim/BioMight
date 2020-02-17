/*
 * Created on Oct 15, 2004
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.antibodies;
import biomight.BioMightBase;


/**
 * @author Administrator
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class Antibody extends BioMightBase {

	// Consist of four polypeptide chains, two Heavy and two Light
	private AntibodyLightChain antibodyLightChain;
	private AntibodyHeavyChain antibodyHeavyChain;	
		
	
	public Antibody()
	{
		this.setImage("images/Antibody.jpg");
		
	}	
	
	public void NeutralizeToxin()
	{
	}

	public void NeutralizeVirus()
	{
	}	
	
	public void Opsinize()
	{
	}		
	
}
