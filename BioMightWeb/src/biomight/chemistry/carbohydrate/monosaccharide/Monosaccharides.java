/*
 * Created on Feb 16, 2007
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.chemistry.carbohydrate.monosaccharide;
import biomight.BioMightBase;
import biomight.chemistry.carbohydrate.monosaccharide.monose.*;
import biomight.chemistry.carbohydrate.monosaccharide.pentose.*;
import biomight.chemistry.carbohydrate.monosaccharide.tetrose.*;
import biomight.chemistry.carbohydrate.monosaccharide.triose.*;

/**
 * @author SurferJim
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class Monosaccharides extends BioMightBase {

	private Formaldehyde Formaldehyde;
	private Monose Monose;
	private DeOxyRibose DeOxyRibose;
	private Pentose Pentose;
	private Ribose Ribose;
	private Ribulose Ribulose;
	private Erythrose Erythrose;
	private Threose Threose;
	private DiHydroxyAcetone diHydroxyAcetone;
	private Glyceraldehyde Glyceraldehyde;
	
	public Monosaccharides()
	{
		this.setImage("images/Monosaccharides.jpg");
		this.setImageWidth(300);
		this.setImageHeight(325);
	}
}
