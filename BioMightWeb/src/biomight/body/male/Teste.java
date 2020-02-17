/*
 * Created on Oct 15, 2004
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.body.male;
import biomight.system.vascular.veins.pelvis.SpermaticVeins;
import biomight.body.BodyPart;

/**
 * @author Administrator
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class Teste extends BodyPart {

	private DartosTunic bartosTunic;
	private InterCruralFascia interCruralFascia;
	private CremastericFascia cremastericFascia;
	private InfundibuliformFascia infundibuliformFascia;
	private ParietalTunicaVaginalis parietalTunicaVaginalis;
	private VisceralTunicaVaginalis visceralTunicaVaginalis;
	private TunicaAlbuginea tunicaAlbuginea;
	private SpermaticVeins spermaticVeins;
	private DuctusDeferens ductusDeferens;
	private SeminiferousTubules seminiferousTubules;
	private TesticularSepta testicularSepta;
	private TesticularLobules testicularLobules;
	private EfferentDuctules efferentDuctules;
	private ReteTestis reteTestis;
	private MediastinumTestis mediastinumTestis;
	
	public Teste()
	{
		this.setImage("images/Teste.jpg");
		this.setImageHeight(300);
		this.setImageWidth(300);

		bartosTunic = new DartosTunic();
		interCruralFascia = new InterCruralFascia();
		cremastericFascia = new CremastericFascia();
		infundibuliformFascia = new InfundibuliformFascia();
		parietalTunicaVaginalis = new ParietalTunicaVaginalis();
		visceralTunicaVaginalis = new VisceralTunicaVaginalis();
		tunicaAlbuginea = new TunicaAlbuginea();
		spermaticVeins = new SpermaticVeins();
		ductusDeferens = new DuctusDeferens();
		seminiferousTubules = new SeminiferousTubules();
		testicularSepta = new TesticularSepta();
		testicularLobules = new TesticularLobules();
		efferentDuctules = new EfferentDuctules();
		reteTestis = new ReteTestis();
		mediastinumTestis = new MediastinumTestis();	
	
	}

	
	/****
	 *  This method  
	 *
	 */
	public void produceSperm()
	{}
	

	/****
	 *  This method  
	 *
	 */
	public void produceTestosterone()
	{}
	
	
}
