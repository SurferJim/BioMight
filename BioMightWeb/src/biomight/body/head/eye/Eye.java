/*
 * Created on May 19, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.body.head.eye;
import java.lang.reflect.Method;
import java.rmi.RemoteException;
import java.util.ArrayList;






import biomight.Constants;
import biomight.body.BodyPart;
import biomight.cell.neuronglial.*;
import biomight.cell.epithelial.*;
import biomight.cell.neuron.*;
import biomight.exceptions.DataSecurityException;
import biomight.exceptions.ServerException;
import biomight.system.ligament.SuspensoryLigament;
import biomight.system.muscular.head.eye.*;
import biomight.system.tissue.epithelial.EpitheliumTissue;
import biomight.view.BioMightMaterial;
import biomight.view.BioMightMethodView;
import biomight.view.BioMightPosition;
import biomight.view.BioMightPropertyView;
import biomight.view.BioMightScale;
import biomight.view.BioMightTransform;

/**
 * @author SurferJim
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */

public class Eye extends BodyPart {
	private BioMightTransform bioMightTransform;
	protected int viewPerspective;
	// Inner Components
	//private Choroid choroid;
	//private ParsPlana parsPlana;
	
	protected Cornea cornea;
	protected Conjunctiva conjuctiva;
	protected HorizontalCell horizontalCell;
	protected AmacrineCell amacrineCell;
	protected BiPolarCell biPolarCell;
	protected GanglionicCell ganglionCell;
	protected Lens lens;
	protected Iris iris;
	protected Macula macula;
	protected OpticDisc opticDisc;
	protected Pupil pupil;
	protected PupilMargin pupilMargin;
	protected PupilSphincter pupilSphincter; 
	protected Retina retina;
	protected Sclera sclera;
	protected VitreousHumor vitreousHumor;
	protected LateralRectusMuscle lateralRectusMuscle;
	protected ZonularFibers zonularFibers;
	protected Uvea uvea;
	protected HyaloidCanal hyaloidCanal; 
	protected SuspensoryLigament suspensoryLigament;

	protected EyeLids eyeLids;	
	
	// Anatomical Features
	protected MedialCommissure medialCommissure;
	protected LateralCommissure lateralCommissure;
	protected MedialCanthus medialCanthus;
	protected LateralCanthus lateralCanthus;	
	protected UpperEyeLidCrease upperEyeLidCrease;
			
		
	public Eye()
	{
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, Constants.EyeRef, null, null);
	}

	/************************************************************************
	 * Eye Constructor 
	 *
	 ***********************************************************************/
	public Eye(String parentID)
	{
		//System.out.println("Calling parameterized Eye Constructor!");
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, parentID, null, null);
	}
	
	/************************************************************************
	 * Eye Constructor 
	 *
	 ***********************************************************************/
	public Eye(int hierarchy, int LOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
	{
		create(hierarchy, LOD, parentID, bioMightProperties, bioMightMethods);
	}
	
	
	/************************************************************************
	 * Create Eye
	 *
	 ***********************************************************************/

	public void create(int hierarchy, int LOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
	{
		this.setImage("images/Eye.gif");
		setImageWidth(200);
		setImageHeight(150);

		int localVP = Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;

		BioMightScale bioScale = new BioMightScale("0.00, 0.00, 0.00");
		BioMightPosition  bioPos = new BioMightPosition("0.00, 0.00, 0.00");
		String bioTemplate="Eye.x3d";
	
		// This is being assembled from a collection, so we need to reset the ID
		componentID=parentID;
		
		viewPerspective = Constants.VIEW_FLOATING;
		if (viewPerspective == Constants.VIEW_FLOATING) {
			
			// If we have initialization parameters from the form, 
			//  then apply them before constructing the objects.
			if (bioMightMethods != null){
				System.out.println("NEED TO EXECUTE EYE METHODS: " + bioMightMethods.size());
			}	
			
			System.out.println("Eye - Pupil is xreatin");
			
			pupil  = new Pupil(parentID, bioMightMethods);
			initProperty(Constants.PupilRef, Constants.Pupil, Constants.PupilRef, pupil.getComponentID(), bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);											
			System.out.println("Eye - Pupil is created");	
			
			sclera  = new Sclera(parentID, bioMightMethods);
			initProperty(Constants.ScleraRef, Constants.Sclera, Constants.ScleraRef, sclera.getComponentID(), bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);											
			System.out.println("Eye - Sclera is created");	
			
			iris  = new Iris(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);	
			initProperty(Constants.IrisRef, Constants.Iris, Constants.IrisRef, iris.getComponentID(), bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);											
			System.out.println("Eye - Iris is created : " + parentID);
			
			//eyeLids  = new EyeLids(parentID, bioMightMethods);
			//initProperty(Constants.EyeLidsRef, Constants.EyeLids, Constants.EyeLidsRef, eyeLids.getComponentID(), bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);											
			//System.out.println("EyeLids - EyeLids are created : " + parentID);
	
			//lowerEyeLid  = new LowerEyeLid(parentID, bioMightMethods);
			//System.out.println("Eye - LowerEyeLid is created : " + parentID);
			
			//upperEyeLid  = new UpperEyeLid(parentID, bioMightMethods);
			//System.out.println("Eye - UpperEyeLid is created : " + parentID);

			uvea  = new Uvea(parentID, bioMightMethods);
			initProperty(Constants.UveaRef, Constants.Uvea, Constants.UveaRef, uvea.getComponentID(), bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);											
			System.out.println("Eye - Uvea is created : " + parentID);

			suspensoryLigament  = new SuspensoryLigament(parentID, bioMightMethods);
			initProperty(Constants.SuspensoryLigamentRef, Constants.SuspensoryLigament, Constants.SuspensoryLigamentRef, suspensoryLigament.getComponentID(), bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);											
			System.out.println("Eye - SuspensoryLigament is created : " + parentID);
			
			
		} 
		else if (viewPerspective == Constants.VIEW_INTERNAL) {
			cornea  = new Cornea();
			conjuctiva  = new Conjunctiva();
			horizontalCell  = new HorizontalCell();
			amacrineCell  = new AmacrineCell();
			biPolarCell  = new BiPolarCell();
			ganglionCell  = new GanglionicCell();
			lens  = new Lens();
			macula  = new Macula();
			opticDisc  = new OpticDisc();
			pupil  = new Pupil();
			pupilMargin  = new PupilMargin();
			pupilSphincter  = new PupilSphincter(); 
			retina  = new Retina();
			sclera  = new Sclera();
			vitreousHumor  = new VitreousHumor();
			lateralRectusMuscle  = new LateralRectusMuscle();
			zonularFibers  = new ZonularFibers();
			uvea  = new Uvea();
			hyaloidCanal  = new HyaloidCanal(); 
			suspensoryLigament  = new SuspensoryLigament();
		}

		initProperties();
		initMethods();
	
	}
	
	
	public void initProperties() {

		
		BioMightScale bioScale = new BioMightScale("0.00, 0.00, 0.00");
		BioMightPosition bioPos = new BioMightPosition("0.00, 0.00, 0.00");	
		String bioTemplate =""; 
		
		initProperty(Constants.PupilRef, Constants.Pupil, Constants.PupilRef, "Eye:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);											
		initProperty("---Not Activated---", Constants.Title, Constants.Title, "ParaThyroidGland:0", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		initProperty(Constants.MedialCommissureRef, Constants.MedialCommissure, Constants.MedialCommissureRef, "Eye:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);											
		initProperty(Constants.LateralCommissureRef, Constants.LateralCommissure, Constants.LateralCommissureRef, "Eye:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);											
		initProperty(Constants.MedialCanthusRef, Constants.MedialCanthus, Constants.MedialCanthusRef, "Eye:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);											
		initProperty(Constants.LateralCanthusRef, Constants.LateralCanthus, Constants.LateralCanthusRef, "Eye:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);											
		initProperty(Constants.UpperEyeLidCreaseRef, Constants.UpperEyeLidCrease, Constants.UpperEyeLidCreaseRef, "Eye:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);											
		initProperty(Constants.ConeRef, Constants.Cone, Constants.ConeRef, "Eye:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);											
		initProperty(Constants.CorneaRef, Constants.Cornea, Constants.CorneaRef, "Eye:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);											
		initProperty(Constants.ConjunctivaRef, Constants.Conjunctiva, Constants.Conjunctiva, "Eye:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);											
		initProperty(Constants.HorizontalCellRef, Constants.HorizontalCell, Constants.HorizontalCellRef, "Eye:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);											
		initProperty(Constants.AmacrineCellRef, Constants.AmacrineCell, Constants.AmacrineCellRef, "Eye:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);											
		initProperty(Constants.BiPolarCellRef, Constants.BiPolarCell, Constants.BiPolarCellRef, "Eye:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);											
		initProperty(Constants.GanglionicCellRef, Constants.GanglionicCell, Constants.GanglionicCellRef, "Eye:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);											
		initProperty(Constants.Lens, Constants.Lens, Constants.Lens, "Eye:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);											
		initProperty(Constants.MaculaRef, Constants.Macula, Constants.MaculaRef, "Eye:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);											
		initProperty(Constants.OpticDiscRef, Constants.OpticDisc, Constants.OpticDiscRef, "Eye:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);											
		initProperty(Constants.PupilMarginRef, Constants.PupilMargin, Constants.PupilMarginRef, "Eye:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);											
		initProperty(Constants.PupilSphincterRef, Constants.PupilSphincter, Constants.PupilSphincterRef, "Eye:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);											
		initProperty(Constants.RetinaRef, Constants.Retina, Constants.RetinaRef, "Eye:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);											
		initProperty(Constants.RodRef, Constants.Rod, Constants.RodRef, "Eye:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);											
		initProperty(Constants.ScleraRef, Constants.Sclera, Constants.ScleraRef, "Eye:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);											
		initProperty(Constants.VitreousHumorRef, Constants.VitreousHumor, Constants.VitreousHumorRef, "Eye:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);											
		initProperty(Constants.LateralRectusMuscleRef, Constants.LateralRectusMuscle, Constants.LateralRectusMuscleRef, "Eye:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);											
		initProperty(Constants.ZonularFibersRef, Constants.ZonularFibers, Constants.ZonularFibersRef, "Eye:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);											
		initProperty(Constants.UveaRef, Constants.Uvea, Constants.UveaRef, "Eye:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);											
		initProperty(Constants.HyaloidCanalRef, Constants.HyaloidCanal, Constants.HyaloidCanalRef, "Eye:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);											
		initProperty(Constants.SuspensoryLigamentRef, Constants.SuspensoryLigament, Constants.SuspensoryLigamentRef, "Eye:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);											
					
	}
	
	
	public void initMethods() {

		BioMightMethodView method = new BioMightMethodView();
		method.setCanonicalName(Constants.Iris);
		method.setMethodName("");
		method.setDisplayName(Constants.NOT_ACTIVATED+"-see Pupil color");
		method.setHtmlType(Constants.NOT_ACTIVATED);
		method.setDataType("String");
		methods.add(method);
		
		method = new BioMightMethodView();
		method.setCanonicalName(Constants.BioText);
		method.setMethodName("setMaterial");
		method.setDisplayName("Color");
		method.setHtmlType(Constants.BIO_DROPDOWN);
		method.setDataType(Constants.BIO_TEXT);
	 	method.setValueMap(materialDDMap);
		methods.add(method);
		
		method = new BioMightMethodView();
		method.setCanonicalName(Constants.BioText);
		method.setMethodName("setTexture");
		method.setDisplayName("Texture");
		method.setHtmlType(Constants.BIO_DROPDOWN);
		method.setDataType(Constants.BIO_TEXT);
	 	method.setValueMap(textureDDMap);
		methods.add(method);
		
		method = new BioMightMethodView();
		method.setCanonicalName(Constants.Sclera);
		method.setMethodName("setRadius");
		method.setDisplayName("Sclera Radius:");
		method.setHtmlType("text");
		method.setDataType("double");
		methods.add(method);

		method = new BioMightMethodView();
		method.setCanonicalName(Constants.Iris);
		method.setMethodName("setRadius");
		method.setDisplayName("Iris Radius:");
		method.setHtmlType("text");
		method.setDataType("double");
		methods.add(method);

		method = new BioMightMethodView();
		method.setCanonicalName(Constants.Pupil);
		method.setMethodName("setRadius");
		method.setDisplayName("Pupil Radius:");
		method.setHtmlType("text");
		method.setDataType("double");
		methods.add(method);
		
		method = new BioMightMethodView();
		method.setMethodName("Winks per minute:");
		method.setHtmlType("text");
		method.setDataType("double");
		methods.add(method);
		
		
		method = new BioMightMethodView();
		method.setMethodName("Tear");
		method.setHtmlType("checkbox");
		methods.add(method);	
		
		method = new BioMightMethodView();
		method.setMethodName("Wink");
		method.setHtmlType("checkbox");
		methods.add(method);	

	}

	
	/********************************************************************************************************************
	 * GET X3D
	 * 
	 * This method will return the X3D for the Cell.  It runs through each of its components and collects up their
	 * representations and then assembles them into one unified X3D model.
	 * 
	 ********************************************************************************************************************/
	public String getX3D(boolean snipet) {
		
		// Assembe the Eye
		String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
		"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n " +
		"<X3D profile='Immersive' >\n" +
		"<head>\n" +
		 "<meta name='BioMightImage' content='Eye.jpg'/>\n" +
		 "<meta name='ExportTime' content='7:45:30'/>\n" +
		 "<meta name='ExportDate' content='08/15/2008'/>\n" +
		 "<meta name='BioMight Version' content='1.0'/>\n" + 
		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='Eye'\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		

		int view = Constants.VIEW_FLOATING;
		String body = "";
		if (view == Constants.VIEW_FLOATING)
		{
			System.out.println("Getting composite X3D for eye");
			body = 				
				pupil.getX3D(true) +
				sclera.getX3D(true) +
				iris.getX3D(true); 
		}
		else
		{
		body = "";
			/*
			cone.getX3D(true) +
			cornea.getX3D(true) +
			conjuctiva.getX3D(true) +
			horizontalCell.getX3D(true) +
			amacrineCell.getX3D(true) +
			biPolarCell.getX3D(true) +
			ganglionCell.getX3D(true) +
			lens.getX3D(true) +
			macula.getX3D(true) +
			opticDisc.getX3D(true) +
			pupil.getX3D(true) +
			pupilMargin.getX3D(true) +
			pupilSphincter.getX3D(true) + 
			retina.getX3D(true) +
			sclera.getX3D(true) +
			vitreousHumor.getX3D(true) +
			lateralRectusMuscle.getX3D(true) +
			zonularFibers.getX3D(true) +
			uvea.getX3D(true) +
			hyaloidCanal.getX3D(true) +
			suspensoryLigament.getX3D(true);
			*/
		}	
		//System.out.println("Eye X3D: " + body);		
		
		String footer = "</Scene>" + "</X3D>\n";
		
		if (snipet)
			return body;			
		else	
			return header + body + footer;
	}
	
	
	/******************************************************************************************
	 * EXECUTE METHODS 
	 *
	 ******************************************************************************************/
	public void executeMethods(ArrayList<String> methodParams) {

		// Run through the argument list and executes the 
		// associated methods
		System.out.println("HEAD-Executing Methods");
		for (int j=0; j<methodParams.size(); j++){
			
			// Get the parameter from the list and if it is not
			// empty execute the associated method using it
			String methodParam = methodParams.get(j);
			if (methodParam != null) {
				if (!methodParam.equals("")) {

					String methodName = (String) methods.get(j).getMethodName(); 
					String htmlType = (String) methods.get(j).getHtmlType();
					String dataType = (String) methods.get(j).getDataType();
					System.out.println("Execute Method " + methodName + " Arg: "  +  methodParam);
					System.out.println("HtmlType " + htmlType + " with DataType: "  +  dataType);
										
					// Use the DataType parameter to convert the data into its base form
					if (dataType.equals("int")) {
						
						try {
							System.out.println("Locating Method(Integer)" + methodName);
							// Locate the method through introspection
							int numElements = Integer.parseInt(methodParam);
							Class paramsType[] = {int.class};
							Method method = this.getClass().getDeclaredMethod(methodName, paramsType);
							System.out.println("Before Execute Method(Integer)" + methodName);
							Object result = method.invoke(this, numElements);
							System.out.println("Before Execute Method(Integer)" + methodName);
							
						}
						catch (NumberFormatException e)
						{
							System.out.println("Could not Convert to int: " + methodParam);						
						}
						catch (NoSuchMethodException e)
						{
							System.out.println("Method with int param not found: " + e);						
						}	
						catch (Exception e)
						{
							System.out.println("General Exception occurred: " + e);						
						}										
					}
					
					else if (dataType.equals("String")) {
						
						
						try {
							System.out.println("Locating Method(String)");
							
							Class paramsType[] = {String.class};
							
							Method method = this.getClass().getDeclaredMethod(methodName, paramsType );
							System.out.println("Method with String Param: " + method.getName());
							
							System.out.println("Before Execute Method(Integer)" + methodName);
							Object result = method.invoke(this, methodParam);
							System.out.println("After Execute Method(Integer)" + methodName);
									
						}
						catch (NoSuchMethodException e)
						{
							System.out.println("Method with int param not found!");						
						}	
						catch (Exception e)
						{
							System.out.println("General Exception occurred!");						
						}	
						
					}
				
					else if (dataType.equals("double")) {
						
					}
					else if (dataType.equals("")) {
						
					}			
				}
			}
		}
	}
	
	public void open()
	{
	}
	
	public void close()
	{
	}	

	public void squint()
	{
	}	
		
	public void focus()
	{
	}	

	public void tear()
	{
	}

	public void wink()
	{
	}	

	public void roll()
	{
	}	

	public void flutter()
	{
	}

	public AmacrineCell getAmacrineCell() {
		return amacrineCell;
	}

	public void setAmacrineCell(AmacrineCell amacrineCell) {
		this.amacrineCell = amacrineCell;
	}

	public BiPolarCell getBiPolarCell() {
		return biPolarCell;
	}

	public void setBiPolarCell(BiPolarCell biPolarCell) {
		this.biPolarCell = biPolarCell;
	}

	public Conjunctiva getConjuctiva() {
		return conjuctiva;
	}

	public void setConjuctiva(Conjunctiva conjuctiva) {
		this.conjuctiva = conjuctiva;
	}

	public Cornea getCornea() {
		return cornea;
	}

	public void setCornea(Cornea cornea) {
		this.cornea = cornea;
	}

	public GanglionicCell getGanglionCell() {
		return ganglionCell;
	}

	public void setGanglionCell(GanglionicCell ganglionCell) {
		this.ganglionCell = ganglionCell;
	}

	public HorizontalCell getHorizontalCell() {
		return horizontalCell;
	}

	public void setHorizontalCell(HorizontalCell horizontalCell) {
		this.horizontalCell = horizontalCell;
	}

	public HyaloidCanal getHyaloidCanal() {
		return hyaloidCanal;
	}

	public void setHyaloidCanal(HyaloidCanal hyaloidCanal) {
		this.hyaloidCanal = hyaloidCanal;
	}

	public LateralCanthus getLateralCanthus() {
		return lateralCanthus;
	}

	public void setLateralCanthus(LateralCanthus lateralCanthus) {
		this.lateralCanthus = lateralCanthus;
	}

	public LateralCommissure getLateralCommissure() {
		return lateralCommissure;
	}

	public void setLateralCommissure(LateralCommissure lateralCommissure) {
		this.lateralCommissure = lateralCommissure;
	}

	public LateralRectusMuscle getLateralRectusMuscle() {
		return lateralRectusMuscle;
	}

	public void setLateralRectusMuscle(LateralRectusMuscle lateralRectusMuscle) {
		this.lateralRectusMuscle = lateralRectusMuscle;
	}

	public Lens getLens() {
		return lens;
	}

	public void setLens(Lens lens) {
		this.lens = lens;
	}

	public Macula getMacula() {
		return macula;
	}

	public void setMacula(Macula macula) {
		this.macula = macula;
	}

	public MedialCanthus getMedialCanthus() {
		return medialCanthus;
	}

	public void setMedialCanthus(MedialCanthus medialCanthus) {
		this.medialCanthus = medialCanthus;
	}

	public MedialCommissure getMedialCommissure() {
		return medialCommissure;
	}

	public void setMedialCommissure(MedialCommissure medialCommissure) {
		this.medialCommissure = medialCommissure;
	}

	public OpticDisc getOpticDisc() {
		return opticDisc;
	}

	public void setOpticDisc(OpticDisc opticDisc) {
		this.opticDisc = opticDisc;
	}

	public Pupil getPupil() {
		return pupil;
	}

	public void setPupil(Pupil pupil) {
		this.pupil = pupil;
	}

	public PupilMargin getPupilMargin() {
		return pupilMargin;
	}

	public void setPupilMargin(PupilMargin pupilMargin) {
		this.pupilMargin = pupilMargin;
	}

	public PupilSphincter getPupilSphincter() {
		return pupilSphincter;
	}

	public void setPupilSphincter(PupilSphincter pupilSphincter) {
		this.pupilSphincter = pupilSphincter;
	}

	public Retina getRetina() {
		return retina;
	}

	public void setRetina(Retina retina) {
		this.retina = retina;
	}

	public Sclera getSclera() {
		return sclera;
	}

	public void setSclera(Sclera sclera) {
		this.sclera = sclera;
	}

	public SuspensoryLigament getSuspensoryLigament() {
		return suspensoryLigament;
	}

	public void setSuspensoryLigament(SuspensoryLigament suspensoryLigament) {
		this.suspensoryLigament = suspensoryLigament;
	}

	public UpperEyeLidCrease getUpperEyeLidCrease() {
		return upperEyeLidCrease;
	}

	public void setUpperEyeLidCrease(UpperEyeLidCrease upperEyeLidCrease) {
		this.upperEyeLidCrease = upperEyeLidCrease;
	}

	public Uvea getUvea() {
		return uvea;
	}

	public void setUvea(Uvea uvea) {
		this.uvea = uvea;
	}

	public VitreousHumor getVitreousHumor() {
		return vitreousHumor;
	}

	public void setVitreousHumor(VitreousHumor vitreousHumor) {
		this.vitreousHumor = vitreousHumor;
	}

	public ZonularFibers getZonularFibers() {
		return zonularFibers;
	}

	public void setZonularFibers(ZonularFibers zonularFibers) {
		this.zonularFibers = zonularFibers;
	}


	public ArrayList<BioMightMethodView> getMethods() {
		return methods;
	}


	public void setMethods(ArrayList<BioMightMethodView> methods) {
		this.methods = methods;
	}


	public ArrayList<BioMightPropertyView> getProperties() {
		return properties;
	}


	public void setProperties(ArrayList<BioMightPropertyView> properties) {
		this.properties = properties;
	}


	public Iris getIris() {
		return iris;
	}


	public void setIris(Iris iris) {
		this.iris = iris;
	}


	public String getComponentID() {
		return componentID;
	}


	public void setComponentID(String componentID) {
		this.componentID = componentID;
	}	

}
