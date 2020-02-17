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
public class Purines extends NucleicAcid{
	
	private Adenine adenine;
	private Guanine guanine;


	public Purines()
	{
		this.setImage("images/Purines.jpg");
	}


	/**
	 * @return
	 */
	public Adenine getAdenine() {
		return adenine;
	}

	/**
	 * @return
	 */
	public Guanine getGuanine() {
		return guanine;
	}

	/**
	 * @param adenine
	 */
	public void setAdenine(Adenine adenine) {
		this.adenine = adenine;
	}

	/**
	 * @param guanine
	 */
	public void setGuanine(Guanine guanine) {
		this.guanine = guanine;
	}

}
