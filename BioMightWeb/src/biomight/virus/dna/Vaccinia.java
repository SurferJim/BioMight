/*
* Created on Oct 15, 2004
*
* BioMight Component Class - May 2007
*
*/
package biomight.virus.dna;
import biomight.virus.dna.DNAVirus;
import biomight.virus.*;


/**
* @author Administrator
*
* BioMight Component Class - May 2007
*
*/
public class Vaccinia extends DNAVirus {

	public Vaccinia()
	{
		this.setImage("images/Vaccinia.jpg");
		this.setImageHeight(300);
		this.setImageWidth(300);
	}

public String name 	= null;
public String symbol 	= null;
public int atomicNumber = 0;
public double atomicMass = 0.0;
public double meltingPtK = 0.0;
public double boilinggPtK = 0.0;

}
