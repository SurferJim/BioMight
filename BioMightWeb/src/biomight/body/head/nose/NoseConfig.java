/*
 * Created on Jul 14, 2007
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.body.head.nose;

import java.math.BigDecimal;

import biomight.view.BioMightMethodView;

/**
 * @author SurferJim
 *
 * Config Object used for constructing a nose
 * 
 */

public class NoseConfig extends BioMightMethodView {
	private BigDecimal length;
	private BigDecimal width;
	private BigDecimal height;
	private BigDecimal nostrilLength;
	private BigDecimal nostrilHeight;
		
	// ethnic type

	private BigDecimal numNoseHairs;
	private BigDecimal numSecretion;

	
	/**
	 * @return
	 */
	public BigDecimal getHeight() {
		return height;
	}

	/**
	 * @return
	 */
	public BigDecimal getLength() {
		return length;
	}

	/**
	 * @return
	 */
	public BigDecimal getNostrilHeight() {
		return nostrilHeight;
	}

	/**
	 * @return
	 */
	public BigDecimal getNostrilLength() {
		return nostrilLength;
	}

	/**
	 * @return
	 */
	public BigDecimal getNumNoseHairs() {
		return numNoseHairs;
	}

	/**
	 * @return
	 */
	public BigDecimal getNumSecretion() {
		return numSecretion;
	}

	/**
	 * @return
	 */
	public BigDecimal getWidth() {
		return width;
	}

	/**
	 * @param decimal
	 */
	public void setHeight(BigDecimal decimal) {
		height = decimal;
	}

	/**
	 * @param decimal
	 */
	public void setLength(BigDecimal decimal) {
		length = decimal;
	}

	/**
	 * @param decimal
	 */
	public void setNostrilHeight(BigDecimal decimal) {
		nostrilHeight = decimal;
	}

	/**
	 * @param decimal
	 */
	public void setNostrilLength(BigDecimal decimal) {
		nostrilLength = decimal;
	}

	/**
	 * @param decimal
	 */
	public void setNumNoseHairs(BigDecimal decimal) {
		numNoseHairs = decimal;
	}

	/**
	 * @param decimal
	 */
	public void setNumSecretion(BigDecimal decimal) {
		numSecretion = decimal;
	}

	/**
	 * @param decimal
	 */
	public void setWidth(BigDecimal decimal) {
		width = decimal;
	}

}
