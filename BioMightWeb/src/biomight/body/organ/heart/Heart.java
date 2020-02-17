/*
 * Created on May 14, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.body.organ.heart;

import biomight.Constants;
import biomight.body.organ.Organ;
import biomight.ejb.BioMightBeanLocal;
import biomight.exceptions.DataSecurityException;
import biomight.exceptions.ServerException;
import biomight.system.vascular.arteries.*;
import biomight.system.vascular.arteries.chest.*;
import biomight.system.vascular.veins.*;
import biomight.system.vascular.veins.chest.*;
import biomight.system.tissue.epithelial.EpitheliumTissue;
import biomight.system.tissue.muscle.cardiac.*;
import biomight.util.BioGraphics;
import biomight.view.BioMightMethodView;
import biomight.view.BioMightPosition;
import biomight.view.BioMightPropertyView;
import biomight.view.BioMightTransform;
import biomight.view.BioMightTransforms;

import java.math.BigDecimal;
import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.naming.InitialContext;

/**
 * @author SurferJim
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */

public class Heart extends Organ {
	protected EpitheliumTissue epithelium;
	private int beatsPerMinute;
	private int healthMark;
	private int intraVascularPressure;
	private int intraCatdiacPressure;
	private BigDecimal EjectionFraction;
	private boolean isContracted;
	private boolean isExpanded;
	private int elastance;
	private BigDecimal ESPVR;
	private BigDecimal EDPVR;
	private int StrokeVolume;
	private boolean systole;
	private boolean isIsovolumicContraction;
	private int preLoad;
	private int afterLoad;
	private int endSystolicElastance;
	private int diastole;
	
	private AscendingAortaArtery ascendingAorta;
	private DescendingAortaArtery descendingAorta;
	private PulmonaryArtery pulmonaryArtery;
	private PulmonaryVein pulmonaryVein;
	private InferiorVenaCava inferiorVenaCava;
	private SuperiorVenaCava superiorVenaCava;
	private RightCoronaryArtery rightCoronaryArtery;
	private LeftCoronaryArtery leftCoronaryArtery;
	private AorticArch aorticArch;
	private Atriums atriums;
	private Ventricles ventricles;

	//private RightAtrium rightAtrium;
	//private LeftAtrium leftAtrium;
	//private LeftVentricle leftVentricle;
	//private RightVentricle rightVentricle;

	private CardiacMuscle cardiacMuscle;


	public Heart()
	{
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, Constants.HeartRef, null, null);
	}

	public Heart(String parentID)
	{
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, parentID, null, null);
	}

	public Heart(int hierarchy, int LOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
	{
		create(hierarchy, LOD, parentID, bioMightProperties, bioMightMethods);
	}

	/*****************************************************************
	 * CREATE
	 * 
	 * @param parentID
	 * @param bioMightMethods
	 ******************************************************************/
	public void create(int hierarchy, int LOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
	{
		this.setImageWidth(300);
		this.setImageHeight(325);
		this.setImage("images/Heart.jpg");
		
		// Get the information from the database via the Enterprise Bean		
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Getting HeartInfo for ParentID: " + parentID);
			InitialContext ctx = new InitialContext();
			BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
			bioMightTransforms = bioMightBean.getComponents(Constants.HeartRef, parentID);
			System.out.println("Have Heart Info from EJB");   	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - Heart");
			throw new ServerException("Remote Exception getComponents():", e); 	
		}
		
		int localVP = Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		
		// Run through Heart and build its components into the model
		ArrayList transforms = bioMightTransforms.getTransforms();
		System.out.println("Chest NumTransforms: " + transforms.size());
		for (int i=0; i<transforms.size(); i++)
		{
			// Get the information for the Heart we are creating
			BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
			System.out.println("Have Heart (name,id): " + bioMightTransform.getName() + "  " + bioMightTransform.getId());

			componentID=bioMightTransform.getId();
			
			if (localVP == Constants.VIEW_INTERNAL) {
				
				// Generate the Heart Epihelium if needed 
				boolean bGenerate = false;
				if (bGenerate) {
					generate(parentID, componentID);
				}
			
				String startID = "HeartEpithelium:00001";
				System.out.println("HawkEye - Creating Heart Epithelium: " + parentID + "  startID: " + startID);				
				epithelium = new EpitheliumTissue(localVP, localLOD, startID, "HeartEpithelium",  Constants.EpitheliumTissueRef, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
				initProperty("HeartEpithelium", Constants.EpitheliumTissue, Constants.EpitheliumTissueRef, bioMightTransform.getId());
		
			}
			else if (localVP == Constants.VIEW_HAWKEYE)
			{				
				System.out.println("Creating Atriums using ParentID: " + bioMightTransform.getId());
				atriums = new Atriums(bioMightTransform.getId(), bioMightMethods);
				initProperty(Constants.AtriumsRef, Constants.Atriums, Constants.AtriumsRef, bioMightTransform.getId());
				System.out.println("Atriums created");
	
				System.out.println("Creating Ventricles using ParentID: " + bioMightTransform.getId());
				ventricles = new Ventricles(bioMightTransform.getId(), bioMightMethods);
				initProperty(Constants.VentriclesRef, Constants.Ventricles, Constants.VentriclesRef, bioMightTransform.getId());
				System.out.println("Ventricles are created");
						
				/*
				System.out.println("Creating AorticArch using ParentID: " + bioMightTransform.getId());
				aorticArch = new AorticArch(bioMightTransform.getId(), bioMightMethods);
				System.out.println("AorticArch is created");
				
				System.out.println("Creating InferiorVenaCava using ParentID: " + bioMightTransform.getId());
				inferiorVenaCava = new InferiorVenaCava(bioMightTransform.getId(), bioMightMethods);
				System.out.println("InferiorVenaCava is created");
	
				System.out.println("Creating SuperiorVenaCava using ParentID: " + bioMightTransform.getId());
				superiorVenaCava = new SuperiorVenaCava(bioMightTransform.getId(), bioMightMethods);
				System.out.println("SuperiorVenaCava is created");
				
				System.out.println("Creating AscendingAorta using ParentID: " + bioMightTransform.getId());
				ascendingAorta = new AscendingAorta(bioMightTransform.getId(), bioMightMethods);
				System.out.println("AscendingAorta is created");
	
				System.out.println("Creating AscendingAorta using ParentID: " + bioMightTransform.getId());
				descendingAorta = new DescendingAorta(bioMightTransform.getId(), bioMightMethods);
				System.out.println("DescendingAorta is created");
	
				System.out.println("Creating PulmonaryArtery using ParentID: " + bioMightTransform.getId());
				pulmonaryArtery = new PulmonaryArtery(bioMightTransform.getId(), bioMightMethods);
				System.out.println("PulmonaryArtery is created");
	
				System.out.println("Creating PulmonaryVein using ParentID: " + bioMightTransform.getId());
				pulmonaryVein = new PulmonaryVein(bioMightTransform.getId(), bioMightMethods);
				System.out.println("PulmonaryVein is created");
				
				System.out.println("Creating RightCoronaryArtery using ParentID: " + bioMightTransform.getId());
				rightCoronaryArtery = new RightCoronaryArtery(bioMightTransform.getId(), bioMightMethods);
				System.out.println("RightCoronaryArtery is created");
	
				System.out.println("Creating LeftCoronaryArtery using ParentID: " + bioMightTransform.getId());
				leftCoronaryArtery = new LeftCoronaryArtery(bioMightTransform.getId(), bioMightMethods);
				System.out.println("LeftCoronaryArtery is created");
				*/
				
			}
			
			/*
			int viewPerspective = Constants.VIEW_FLOATING;
			if (viewPerspective == Constants.VIEW_FLOATING) {
				System.out.println("Sclera Eye is created");
			} 
			else if (viewPerspective == Constants.VIEW_INTERNAL) {
			}
			private CardiacMuscle cardiacMuscle;
			*/
					
		}		

	
		//initProperties();
		//initMethods();
		
		System.out.println("Create Heart Completed");
		
		// First, get all the data from the database
		// Apply the methods to it
		// Save its state
		if (bioMightMethods != null){
			System.out.println("EXECUTING Heart METHODS: " + bioMightMethods.size());
			//executeMethods(bioMightMethods);
		}

	}

	
	/*****************************************************************************
	 * GENERATE Heart
	 * 
	 * @param parentID
	 * @param componentID
	 ****************************************************************************/
	
	public void generate(String parentID, String componentID)
	{
		// Generate the Heart Edothelium		
		BioMightBeanLocal bioMightBean;
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Generating the Heart: " + componentID + "    " + parentID);
			InitialContext ctx = new InitialContext();
			bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
	
			double radius = 0.001;
		
			if (componentID.equals("Heart:01")) 
			{	
				// Generate the GreaterCurvature of the stomach
				// Create 5 sections
				double[] startPos = {0.75, -12.50, -2.25};
				double[][] currentPoints = BioGraphics.createCylinderInPlane(Constants.YPLANE, startPos, radius, 8);
				
				int success = bioMightBean.generateHeart("HeartEpithelium:00001", "HeartEpithelium", 
					"HeartEpithelium", componentID, parentID, currentPoints);									
		
			}			
			else if (parentID.equals("")) 
			{	
					
			}

			
			System.out.println("Created HeartEpithelium Info using EJB");   	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - HeartEpithelium");
			throw new ServerException("Remote Exception getComponents():", e); 	
		}
	}
	
	
	public void initProperties() {

		BioMightPropertyView property = new BioMightPropertyView();
		property.setPropertyName("AscendingAorta");
		property.setCanonicalName(Constants.AscendingAortaArtery);
		properties.add(property);

	
		property = new BioMightPropertyView();
		property.setPropertyName("DescendingAorta");
		property.setCanonicalName(Constants.DescendingAortaArtery);
		properties.add(property);		
	
		property = new BioMightPropertyView();
		property.setPropertyName("PulmonaryArtery");
		property.setCanonicalName(Constants.PulmonaryArtery);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("PulmonaryVein");
		property.setCanonicalName(Constants.PulmonaryVein);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("InferiorVenaCava");
		property.setCanonicalName(Constants.InferiorVenaCava);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("SuperiorVenaCava");
		property.setCanonicalName(Constants.SuperiorVenaCava);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("RightCoronaryArtery");
		property.setCanonicalName(Constants.RightCoronaryArtery);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("LeftCoronaryArtery");
		property.setCanonicalName(Constants.LeftCoronaryArtery);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("AorticArch");
		property.setCanonicalName(Constants.AorticArch);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("RightAtrium");
		property.setCanonicalName(Constants.RightAtrium);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("LeftAtrium");
		property.setCanonicalName(Constants.LeftAtrium);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("LeftVentricle");
		property.setCanonicalName(Constants.LeftVentricle);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("CardiacMuscle");
		property.setCanonicalName(Constants.CardiacMuscle);
		properties.add(property);
		
	}

	
	public void initMethods() {
	
		BioMightMethodView method;

		method = new BioMightMethodView();
		method.setMethodName("Pulse");
		method.setHtmlType("textbox");
		methods.add(method);	
		
		method = new BioMightMethodView();
		method.setMethodName("Blood Pressure");
		method.setHtmlType("textbox");
		methods.add(method);

		method = new BioMightMethodView();
		method.setMethodName("Arythmia");
		method.setHtmlType("textbox");
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
		
		// Assemble the Heart
		String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
		"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n " +
		"<X3D profile='Immersive' >\n" +
		"<head>\n" +
		 "<meta name='BioMightImage' content='Heart.jpg'/>\n" +
		 "<meta name='ExportTime' content='7:45:30'/>\n" +
		 "<meta name='ExportDate' content='08/15/2008'/>\n" +
		 "<meta name='BioMight Version' content='1.0'/>\n" + 
		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='Heart'\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		

		
		
		String body = "";	
		
		int localVP = Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;	
		
		if (localVP == Constants.VIEW_HAWKEYE) {
			body = atriums.getX3D(true) + ventricles.getX3D(true);  
		}
		else
		{	
			body = epithelium.getX3D(true);  // atriums.getX3D(true) + ventricles.getX3D(true);  	
		}
		
		body+= "<Viewpoint DEF='Viewpoint_Heart'\n" +
				 "description='Viewpoint1'\n" +
				 "jump='true'\n" +
				 "fieldOfView='0.785'\n" +
				 "position='0.0 -14.0 10.0'\n" +
				 "orientation='0 0 1 0'/>\n";
		
		
		String footer = "</Scene>" + "</X3D>\n";
		
		if (snipet)
			return body;			
		else	
			return header + body + footer;
	}

	
	
	/**
	 * @return
	 */
	public int getAfterLoad() {
		return afterLoad;
	}

	/**
	 * @return
	 */
	public AorticArch getAorticArch() {
		return aorticArch;
	}

	/**
	 * @return
	 */
	public AscendingAortaArtery getAscendingAorta() {
		return ascendingAorta;
	}

	/**
	 * @return
	 */
	public int getBeatsPerMinute() {
		return beatsPerMinute;
	}

	/**
	 * @return
	 */
	public CardiacMuscle getCardiacMuscle() {
		return cardiacMuscle;
	}

	/**
	 * @return
	 */
	public DescendingAortaArtery getDescendingAorta() {
		return descendingAorta;
	}

	/**
	 * @return
	 */
	public int getDiastole() {
		return diastole;
	}

	/**
	 * @return
	 */
	public BigDecimal getEDPVR() {
		return EDPVR;
	}

	/**
	 * @return
	 */
	public BigDecimal getEjectionFraction() {
		return EjectionFraction;
	}

	/**
	 * @return
	 */
	public int getElastance() {
		return elastance;
	}

	/**
	 * @return
	 */
	public int getEndSystolicElastance() {
		return endSystolicElastance;
	}

	/**
	 * @return
	 */
	public BigDecimal getESPVR() {
		return ESPVR;
	}

	/**
	 * @return
	 */
	public int getHealthMark() {
		return healthMark;
	}

	/**
	 * @return
	 */
	public InferiorVenaCava getInferiorVenaCava() {
		return inferiorVenaCava;
	}

	/**
	 * @return
	 */
	public int getIntraCatdiacPressure() {
		return intraCatdiacPressure;
	}

	/**
	 * @return
	 */
	public int getIntraVascularPressure() {
		return intraVascularPressure;
	}

	/**
	 * @return
	 */
	public boolean isContracted() {
		return isContracted;
	}

	/**
	 * @return
	 */
	public boolean isExpanded() {
		return isExpanded;
	}

	/**
	 * @return
	 */
	public boolean isIsovolumicContraction() {
		return isIsovolumicContraction;
	}


	/**
	 * @return
	 */
	public LeftCoronaryArtery getLeftCoronaryArtery() {
		return leftCoronaryArtery;
	}



	/**
	 * @return
	 */
	public int getPreLoad() {
		return preLoad;
	}

	/**
	 * @return
	 */
	public PulmonaryArtery getPulmonaryArtery() {
		return pulmonaryArtery;
	}

	/**
	 * @return
	 */
	public PulmonaryVein getPulmonaryVein() {
		return pulmonaryVein;
	}

	/**
	 * @return
	 */
	public RightCoronaryArtery getRightCoronaryArtery() {
		return rightCoronaryArtery;
	}

	/**
	 * @return
	 */
	public int getStrokeVolume() {
		return StrokeVolume;
	}

	/**
	 * @return
	 */
	public SuperiorVenaCava getSuperiorVenaCava() {
		return superiorVenaCava;
	}

	/**
	 * @return
	 */
	public boolean isSystole() {
		return systole;
	}

	/**
	 * @param i
	 */
	public void setAfterLoad(int i) {
		afterLoad = i;
	}

	/**
	 * @param arch
	 */
	public void setAorticArch(AorticArch arch) {
		aorticArch = arch;
	}

	/**
	 * @param aorta
	 */
	public void setAscendingAorta(AscendingAortaArtery aorta) {
		ascendingAorta = aorta;
	}

	/**
	 * @param i
	 */
	public void setBeatsPerMinute(int i) {
		beatsPerMinute = i;
	}

	/**
	 * @param muscle
	 */
	public void setCardiacMuscle(CardiacMuscle muscle) {
		cardiacMuscle = muscle;
	}

	/**
	 * @param aorta
	 */
	public void setDescendingAorta(DescendingAortaArtery aorta) {
		descendingAorta = aorta;
	}

	/**
	 * @param i
	 */
	public void setDiastole(int i) {
		diastole = i;
	}

	/**
	 * @param decimal
	 */
	public void setEDPVR(BigDecimal decimal) {
		EDPVR = decimal;
	}

	/**
	 * @param decimal
	 */
	public void setEjectionFraction(BigDecimal decimal) {
		EjectionFraction = decimal;
	}

	/**
	 * @param i
	 */
	public void setElastance(int i) {
		elastance = i;
	}

	/**
	 * @param i
	 */
	public void setEndSystolicElastance(int i) {
		endSystolicElastance = i;
	}

	/**
	 * @param decimal
	 */
	public void setESPVR(BigDecimal decimal) {
		ESPVR = decimal;
	}

	/**
	 * @param i
	 */
	public void setHealthMark(int i) {
		healthMark = i;
	}

	/**
	 * @param cava
	 */
	public void setInferiorVenaCava(InferiorVenaCava cava) {
		inferiorVenaCava = cava;
	}

	/**
	 * @param i
	 */
	public void setIntraCatdiacPressure(int i) {
		intraCatdiacPressure = i;
	}

	/**
	 * @param i
	 */
	public void setIntraVascularPressure(int i) {
		intraVascularPressure = i;
	}

	/**
	 * @param b
	 */
	public void setContracted(boolean b) {
		isContracted = b;
	}

	/**
	 * @param b
	 */
	public void setExpanded(boolean b) {
		isExpanded = b;
	}

	/**
	 * @param b
	 */
	public void setIsovolumicContraction(boolean b) {
		isIsovolumicContraction = b;
	}


	/**
	 * @param artery
	 */
	public void setLeftCoronaryArtery(LeftCoronaryArtery artery) {
		leftCoronaryArtery = artery;
	}


	/**
	 * @param i
	 */
	public void setPreLoad(int i) {
		preLoad = i;
	}

	/**
	 * @param artery
	 */
	public void setPulmonaryArtery(PulmonaryArtery artery) {
		pulmonaryArtery = artery;
	}

	/**
	 * @param vein
	 */
	public void setPulmonaryVein(PulmonaryVein vein) {
		pulmonaryVein = vein;
	}

	/**
	 * @param artery
	 */
	public void setRightCoronaryArtery(RightCoronaryArtery artery) {
		rightCoronaryArtery = artery;
	}

	/**
	 * @param i
	 */
	public void setStrokeVolume(int i) {
		StrokeVolume = i;
	}

	/**
	 * @param cava
	 */
	public void setSuperiorVenaCava(SuperiorVenaCava cava) {
		superiorVenaCava = cava;
	}

	/**
	 * @param b
	 */
	public void setSystole(boolean b) {
		systole = b;
	}


}
