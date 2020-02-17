/*
 * Created on Feb 12, 2007
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.chemistry.elements;

import biomight.BioMightBase;

/**
 * @author SurferJim
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class Element extends BioMightBase {

	public String name 	= null;
	public String symbol 	= null;
	public int atomicNumber = 0;
	public double atomicMass = 0.0;
	public double meltingPtK = 0.0;
	public double boilinggPtK = 0.0;

	public Element()
	{
		this.setImage("images/Atoms.jpg");
		this.setImageHeight(300);
		this.setImageWidth(300);
	}

	/**
	 * @return
	 */
	public int getAtomicNumber() {
		return atomicNumber;
	}

	/**
	 * @return
	 */
	public double getBoilinggPtK() {
		return boilinggPtK;
	}

	/**
	 * @return
	 */
	public double getMeltingPtK() {
		return meltingPtK;
	}

	/**
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return
	 */
	public String getSymbol() {
		return symbol;
	}

}
