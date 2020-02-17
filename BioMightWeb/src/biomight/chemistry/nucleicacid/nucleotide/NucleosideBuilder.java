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
public class NucleosideBuilder {
 
	private Object heterocyclicBase;
	private Object sugar;
	
	
	public NucleosideBuilder(String baseName, String sugarName) {
		
		this.setHeteroCyclicBase(baseName);
		this.setSugar(sugarName);
	}
	
	
	public void setHeteroCyclicBase(String baseName)
	{
		if (baseName.equals(Constants.Adenine))
		{heterocyclicBase = new Adenine();}
		if (baseName.equals(Constants.Cytosine))
		{heterocyclicBase = new Cytosine();}
		else if (baseName.equals(Constants.Guanine))
		{heterocyclicBase = new Guanine();}
		else if (baseName.equals(Constants.Thymine))
		{heterocyclicBase = new Thymine();}
		else if (baseName.equals(Constants.Uracil))
		{heterocyclicBase = new Uracil();}
	}
	

	public void setSugar(String sugarName)
	{
		if (sugarName.equals(Constants.DeOxyRibose))
		{sugar = new DeOxyRibose();}
		if (sugarName.equals(Constants.Ribose))
		{sugar = new Ribose();}
	}



}
