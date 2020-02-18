/*
 * Created on Jul 11, 2007
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.system.skeletal.pelvis;
import biomight.system.muscular.perineum.*;
import biomight.body.BodyPart;

/**
 * @author SurferJim
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class Perineum extends BodyPart {
	private IschiorectalFossa ischiorectalFossa;
	private FasciaOfColles fasciaOfColles;
	
	// Muscles
	private BulboCavernosusMuscle bulbocavernosusMuscle;
	private BulboSpongiosusMuscle bulboSpongiosusMuscle;
	private CorrugatorCutisAniMuscle corrugatorCutisAniMuscle;
	private IschiocavernosusMuscle IschiocavernosusMuscle;
	private TransversusPerineiProfundusMuscle transversusPerineiProfundusMuscle;
	private SphincterAniExternusMuscle sphincterAniExternusMuscle;
	private SphincterAniInternusMuscle sphincterAniInternusMuscle;
	private SphincterUrethraeMembranaceaeMuscle sphincterUrethraeMembranaceaeMuscle;
	private TransversusPerineiSuperficialisMuscle transversusPerineiSuperficialisMuscle;
	
	
	public Perineum()
	{
		this.setImage("images/Perineum.jpg");
		this.setImageHeight(300);
		this.setImageWidth(300);
	}
}
