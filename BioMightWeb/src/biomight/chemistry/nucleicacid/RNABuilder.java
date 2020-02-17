/*
 * Created on May 5, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.chemistry.nucleicacid;

import biomight.chemistry.nucleicacid.nucleotide.*;
import biomight.Constants;

/**
 * @author SurferJim
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class RNABuilder {


	/***********************************************************************************
	 * buildChain()
	 * 
	 * This method creates a DNA chain based on the sequence specified in the string
	 * 
	 * @param chainSequence
	 * @return
	 ***********************************************************************************/
	public RNA buildChain(String chainSequence)
	{
		RNA rnaChain = new RNA();

		/*
		// Run through the string and create objects of each type
		// and place them into a DNAChain.
		int chainLength = chainSequence.length();
		for (int i=0; i<chainLength; i++)
		{
			if (chainSequence.charAt(i) == 'A')
			{
				Nucleotide adenineNucleotide = 
					new NucleotideBuilder(Constants.Adenine, Constants.Ribose, Constants.MONO);
				rnaChain.add(adenineNucleotide);
			}
			else if (chainSequence.charAt(i) == 'C')
			{
				Nucleotide cytosineNucleotide = 
					new NucleotideBuilder(Constants.Cytosine, Constants.Ribose, Constants.MONO);
				rnaChain.add(cytosineNucleotide);
			}
			else if (chainSequence.charAt(i) == 'U')
			{
				Nucleotide uracilNucleotide = 
					new NucleotideBuilder(Constants.Uracil, Constants.Ribose, Constants.MONO);
				rnaChain.add(uracilNucleotide);
			}			
			else if (chainSequence.charAt(i) == 'G')
			{
				Nucleotide guanineNucleotide = 
					new NucleotideBuilder(Constants.Guanine, Constants.Ribose, Constants.MONO);
				rnaChain.add(guanineNucleotide);
			}
		}
		*/
		
		return rnaChain;
	}

}
