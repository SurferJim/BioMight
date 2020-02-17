/*
* Created on Oct 16, 2006
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
public class VaricellaZosterVirus extends DNAVirus {

	public VaricellaZosterVirus()
	{
		this.setImage("images/VaricellaZosterVirus.jpg");
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
