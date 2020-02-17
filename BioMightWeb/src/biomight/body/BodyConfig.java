/*
 * Created on May 27, 2007
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.body;
import biomight.BioMightBase;
import biomight.Constants;


/**
 * @author SurferJim
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */

public class BodyConfig extends BioMightBase {

	// Physical Properties
	private String gender;		
	private String ethnicity;
	private String bodyClass;
	private String hairColor;
	private String eyeColor;
	private String height;
	private String weight;
	private int age;
	
	private double lengthHead;
	private double lengthNeck;
	private double girthNeck;
	private double lengthThorax;
	
	// Set the length and girth of arm parts
	private double lengthArm;
	private double lengthLeftBicep;
	private double lengthLeftForearm;
	private double lengthRighttBicep;
	private double lengthRightForearm;
	
	// Set the length and girth of leg parts
	private double lengthLeg;
	private double lengthLeftThigh;
	private double lengthRightThigh;
	private double lengthLeftCnemus;
	private double lengthRightCnemus;
	
	/**
	 * @return
	 */
	public int getAge() {
		return age;
	}

	/**
	 * @return
	 */
	public String getBodyClass() {
		return bodyClass;
	}

	/**
	 * @return
	 */
	public String getEthnicity() {
		return ethnicity;
	}

	/**
	 * @return
	 */
	public String getEyeColor() {
		return eyeColor;
	}

	/**
	 * @return
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * @return
	 */
	public String getHairColor() {
		return hairColor;
	}

	/**
	 * @return
	 */
	public String getHeight() {
		return height;
	}

	/**
	 * @return
	 */
	public String getWeight() {
		return weight;
	}

	/**
	 * @param i
	 */
	public void setAge(int i) {
		age = i;
	}

	/**
	 * @param string
	 */
	public void setBodyClass(String string) {
		bodyClass = string;
	}

	/**
	 * @param string
	 */
	public void setEthnicity(String string) {
		ethnicity = string;
	}

	/**
	 * @param string
	 */
	public void setEyeColor(String string) {
		eyeColor = string;
	}

	/**
	 * @param string
	 */
	public void setGender(String string) {
		gender = string;
	}

	/**
	 * @param string
	 */
	public void setHairColor(String string) {
		hairColor = string;
	}

	/**
	 * @param string
	 */
	public void setHeight(String string) {
		height = string;
	}

	/**
	 * @param string
	 */
	public void setWeight(String string) {
		weight = string;
	}

}
