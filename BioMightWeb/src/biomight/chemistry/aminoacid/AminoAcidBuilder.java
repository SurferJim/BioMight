/*
 * Created on Jun 8, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.chemistry.aminoacid;

import biomight.Constants;
import biomight.chemistry.compound.*;
import biomight.chemistry.elements.*;

/**
 * @author SurferJim
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class AminoAcidBuilder {

	private Carboxyl carboxyl;
	private Amine amine;
	private Carbon carbon1;
	private Hydrogen hydrogen1;
	private Object base;


	public AminoAcidBuilder()
	{
	}
	
	
	public AminoAcidBuilder(String baseName){
		
		if (baseName.equals(Constants.Alanine)){
			base = new Alanine();
		}
		if (baseName.equals(Constants.Arginine)){
			base = new Arginine();
		}		
		if (baseName.equals(Constants.Asparagine)){
			base = new Asparagine();
		}
		if (baseName.equals(Constants.AsparticAcid)){
			base = new AsparticAcid();
		}
		if (baseName.equals(Constants.Cysteine)){
			base = new Cysteine();
		}
		if (baseName.equals(Constants.GlutamicAcid)){
			base = new GlutamicAcid();
		}
		if (baseName.equals(Constants.Glutamine)){
			base = new Glutamine();
		}
		if (baseName.equals(Constants.Glycine)){
			base = new Glycine();
		}
		if (baseName.equals(Constants.Histidine)){
			base = new Histidine();
		}
		if (baseName.equals(Constants.IsoLeucine)){
			base = new IsoLeucine();
		}
		if (baseName.equals(Constants.Leucine)){
			base = new Leucine();
		}
		if (baseName.equals(Constants.Lysine)){
			base = new Lysine();
		}
		if (baseName.equals(Constants.Methionine)){
			base = new Methionine();
		}
		if (baseName.equals(Constants.Phenylalanine)){
			base = new Phenylalanine();
		}
		if (baseName.equals(Constants.Proline)){
			base = new Proline();
		}
		if (baseName.equals(Constants.Serine)){
			base = new Arginine();
		}
		if (baseName.equals(Constants.Threonine)){
			base = new Arginine();
		}
		if (baseName.equals(Constants.Tryptophan)){
			base = new Arginine();
		}
		if (baseName.equals(Constants.Tyrosine)){
			base = new Arginine();
		}
		if (baseName.equals(Constants.Valine)){
			base = new Arginine();
		}
	}

}
