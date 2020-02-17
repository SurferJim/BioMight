/*
 * Created on Apr 25, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.cell.metabolismstorage;
import biomight.chemistry.carbohydrate.polysaccharide.Glycogen;
import biomight.chemistry.secretion.*;
import biomight.chemistry.compound.*;
import biomight.chemistry.carbohydrate.polysaccharide.*;

/**
 * @author SurferJim
 *
 * Carbohydrates are stored in the hepatic cells in the form of glycogen which 
 * is secreted in the form of sugar directly into the blood stream
 * 
 * In the male it weighs from 1.4 to 1.6 kilogm., in the female from 1.2 to 1.4 kilogm
 * 
 */
public class Hepatocyte {
	private Glycogen glycogen;
	private Bile bile;
	private AlkalinePhosphatase alkalinePhosphatase;
	private AspartateAminoTransferase aspartateAminoTransferase;	
	private Bilirubin bilirubin;
	
	/**
	 * Method that instructs cell to secrete Glycogen
	 */
	public void secreteGlycogen()
	{
	}
	
}
