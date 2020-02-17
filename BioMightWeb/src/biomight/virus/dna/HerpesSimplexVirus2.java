/*
* Created on May 14, 2006
*
* BioMight Component Class - May 2007
*
*/
package biomight.virus.dna;
import biomight.virus.dna.DNAVirus;
import biomight.chemistry.pharma.antiviral.*;

/**
* @author SurferJim
*
* BioMight Component Class - May 2007
*
*/
public class HerpesSimplexVirus2 extends DNAVirus {

	public HerpesSimplexVirus2()
	{
		this.setImage("images/HerpesSimplexVirus2.jpg");
		this.setImageHeight(300);
		this.setImageWidth(300);
	}


public void onContact(Object obj)
{	

if (obj instanceof Acyclovir)
{
// 
}
}


}
