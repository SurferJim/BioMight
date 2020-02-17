/*
 * Created on May 21, 2007
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.view;
import java.math.BigDecimal;

/**
 * @author SurferJim
 *
 * Everything in BioMight can be constructed by attaching cubes.  
 * 
 */

public class BioMightCube {
	private BigDecimal xPos;
	private BigDecimal yPos;
	private BigDecimal zPos;
	
	
	/**
	 * @return
	 */
	public BigDecimal getXPos() {
		return xPos;
	}

	/**
	 * @return
	 */
	public BigDecimal getYPos() {
		return yPos;
	}

	/**
	 * @return
	 */
	public BigDecimal getZPos() {
		return zPos;
	}

	/**
	 * @param decimal
	 */
	public void setXPos(BigDecimal decimal) {
		xPos = decimal;
	}

	/**
	 * @param decimal
	 */
	public void setYPos(BigDecimal decimal) {
		yPos = decimal;
	}

	/**
	 * @param decimal
	 */
	public void setZPos(BigDecimal decimal) {
		zPos = decimal;
	}

}
