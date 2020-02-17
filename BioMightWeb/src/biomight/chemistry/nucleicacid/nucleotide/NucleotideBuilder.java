/*
 * Created on Jun 3, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
 
package biomight.chemistry.nucleicacid.nucleotide;

import biomight.chemistry.carbohydrate.monosaccharide.pentose.*;
import biomight.chemistry.elements.*;
import biomight.chemistry.ions.*;
import biomight.Constants;


/**
 * @author SurferJim
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class NucleotideBuilder {
 
	private NucleosideBuilder nucleosideBuilder;
	private Object phosphateGroup;

		
	public NucleotideBuilder(String baseName, String sugarName, String polyName)
	{
		// BaseName is Adenine, Guanine, Ctyosine, etc.
		// SugarName is Ribose, DeOxyRibose
		nucleosideBuilder = new NucleosideBuilder(baseName, sugarName);
		
		// Add the Phosphate group based on the parameter
		if (baseName.equals(Constants.MONO))
		{phosphateGroup = new MonoPhosphate();}
		if (baseName.equals(Constants.DI))
		{phosphateGroup = new DiPhosphate();}
		if (baseName.equals(Constants.TRI))
		{phosphateGroup = new TriPhosphate();}
	}
	
	
}
