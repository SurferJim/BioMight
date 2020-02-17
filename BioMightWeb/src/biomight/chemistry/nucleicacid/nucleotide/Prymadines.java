/*
 * Created on Jun 3, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.chemistry.nucleicacid.nucleotide;
import biomight.chemistry.nucleicacid.*;

/**
 * @author SurferJim
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class Prymadines extends NucleicAcid {
	
	private Cytosine cytosine;
	private Thymine thymine;
	private Uracil uracil;
	
	
	public Prymadines()
	{
		this.setImage("images/Prymadines.jpg");
	}

	/**
	 * @return
	 */
	public Cytosine getCytosine() {
		return cytosine;
	}

	/**
	 * @return
	 */
	public Thymine getThymine() {
		return thymine;
	}

	/**
	 * @return
	 */
	public Uracil getUracil() {
		return uracil;
	}

	/**
	 * @param cytosine
	 */
	public void setCytosine(Cytosine cytosine) {
		this.cytosine = cytosine;
	}

	/**
	 * @param thymine
	 */
	public void setThymine(Thymine thymine) {
		this.thymine = thymine;
	}

	/**
	 * @param uracil
	 */
	public void setUracil(Uracil uracil) {
		this.uracil = uracil;
	}

}
