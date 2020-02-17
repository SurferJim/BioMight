/*
 * Created on Jul 5, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.body;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;

import javax.naming.InitialContext;

import biomight.BioMightBase;
import biomight.Constants;
import biomight.ejb.BioMightBeanLocal;
import biomight.exceptions.ServerException;
import biomight.system.muscular.back.IliocostalisCervicisMuscles;
import biomight.system.muscular.back.IliocostalisDorsiMuscles;
import biomight.system.muscular.back.IliocostalisLumborumMuscles;
import biomight.system.muscular.back.InterSpinalesMuscles;
import biomight.system.muscular.back.InterTransversariiAnterioresMuscles;
import biomight.system.muscular.back.LongissimusCapitisMuscles;
import biomight.system.muscular.back.LongissimusCervicisMuscles;
import biomight.system.muscular.back.LongissimusDorsiMuscles;
import biomight.system.muscular.back.RotatoresSpinaeMuscles;
import biomight.system.muscular.back.SacroSpinalisMuscles;
import biomight.system.muscular.back.SemiSpinalisCapitisMuscles;
import biomight.system.muscular.back.SemiSpinalisCervicisMuscles;
import biomight.system.muscular.back.SemiSpinalisDorsiMuscles;
import biomight.system.muscular.back.SemiSpinalisMuscles;
import biomight.system.muscular.back.SpinalisCapitisMuscles;
import biomight.system.muscular.back.SpinalisCervicisMuscles;
import biomight.system.muscular.back.SpinalisDorsiMuscles;
import biomight.system.muscular.back.SpleniusCapitisMuscles;
import biomight.system.muscular.back.SpleniusCervicisMuscles;
import biomight.system.nervous.nerves.spinal.lumbarplexus.LumbarNerveLeftL1;
import biomight.system.nervous.nerves.spinal.lumbarplexus.LumbarNerveLeftL2;
import biomight.system.nervous.nerves.spinal.lumbarplexus.LumbarNerveLeftL3;
import biomight.system.nervous.nerves.spinal.lumbarplexus.LumbarNerveLeftL4;
import biomight.system.nervous.nerves.spinal.lumbarplexus.LumbarNerveLeftL5;
import biomight.system.nervous.nerves.spinal.lumbarplexus.LumbarNerveRightL1;
import biomight.system.nervous.nerves.spinal.lumbarplexus.LumbarNerveRightL2;
import biomight.system.nervous.nerves.spinal.lumbarplexus.LumbarNerveRightL3;
import biomight.system.nervous.nerves.spinal.lumbarplexus.LumbarNerveRightL4;
import biomight.system.nervous.nerves.spinal.lumbarplexus.LumbarNerveRightL5;
import biomight.system.nervous.nerves.spinal.thoracic.ThoracicNerveT1;
import biomight.system.nervous.nerves.spinal.thoracic.ThoracicNerveT10;
import biomight.system.nervous.nerves.spinal.thoracic.ThoracicNerveT11;
import biomight.system.nervous.nerves.spinal.thoracic.ThoracicNerveT2;
import biomight.system.nervous.nerves.spinal.thoracic.ThoracicNerveT3;
import biomight.system.nervous.nerves.spinal.thoracic.ThoracicNerveT4;
import biomight.system.nervous.nerves.spinal.thoracic.ThoracicNerveT5;
import biomight.system.nervous.nerves.spinal.thoracic.ThoracicNerveT6;
import biomight.system.nervous.nerves.spinal.thoracic.ThoracicNerveT7;
import biomight.system.nervous.nerves.spinal.thoracic.ThoracicNerveT8;
import biomight.system.nervous.nerves.spinal.thoracic.ThoracicNerveT9;
import biomight.system.skeletal.spine.CoccygealVertebrae;
import biomight.system.skeletal.spine.LumbarVertebrae;
import biomight.system.skeletal.spine.SacralVertebrae;
import biomight.system.skeletal.spine.ThoracicVertebrae;
import biomight.system.tissue.epithelial.EpitheliumTissue;
import biomight.system.vascular.arteries.pelvis.CommonIliacArtery;
import biomight.util.BioGraphics;
import biomight.view.BioMightBoundBox;
import biomight.view.BioMightBoundBoxes;
import biomight.view.BioMightConnector;
import biomight.view.BioMightConnectors;
import biomight.view.BioMightConstruct;
import biomight.view.BioMightGenerate;
import biomight.view.BioMightMethodView;
import biomight.view.BioMightPosition;
import biomight.view.BioMightPropertyView;
import biomight.view.BioMightScale;
import biomight.view.BioMightTransform;

/**
 * @author SurferJim
 *
 * Representation of the Back
 * 
 */

public class Back extends BioMightBase {
	private EpitheliumTissue epithelium; 
	
	
	// Muscles of the Back
	private IliocostalisCervicisMuscles iliocostalisCervicisMuscles;
	//private IliocostalisCervicisLeftMuscle iliocostalisCervicisLeftMuscle;
	//private IliocostalisCervicisRightMuscle iliocostalisCervicisRightMuscle;
	
	private IliocostalisDorsiMuscles iliocostalisDorsiMuscles;
	//private IliocostalisDorsiLeftMuscle iliocostalisDorsiLeftMuscle;
	//private IliocostalisDorsiRightMuscle iliocostalisDorsiRightMuscle;
	
	private IliocostalisLumborumMuscles iliocostalisLumborumMuscles;
	//private IliocostalisLumborumLeftMuscle iliocostalisLumborumMuscle;
	//private IliocostalisLumborumRightMuscle iliocostalisLumborumMuscle;
	
	private InterSpinalesMuscles interSpinalesMuscles;
	
	private InterTransversariiAnterioresMuscles interTransversariiAnterioresMuscles;
	//private InterTransversariiAnterioresLeftMuscle interTransversariiAnterioresLeftMuscle;
	//private InterTransversariiAnterioresRightMuscle interTransversariiAnterioresRightMuscle;
	
	private LongissimusCapitisMuscles longissimusCapitisMuscles;
	//private LongissimusCapitisLeftMuscle longissimusCapitisLeftMuscle;
	//private LongissimusCapitisRightMuscle longissimusCapitisRightMuscle;

	private LongissimusCervicisMuscles longissimusCervicisMuscles;
	//private LongissimusCervicisLeftMuscle longissimusCervicisLeftMuscle;
	//private LongissimusCervicisRightMuscle longissimusCervicisRightMuscle;

	private LongissimusDorsiMuscles longissimusDorsiMuscles;
	//private LongissimusDorsiLeftMuscle longissimusDorsiLeftMuscle;
	//private LongissimusDorsiRightMuscle LongissimusDorsiRightMuscle;
	
	private SemiSpinalisCapitisMuscles semiSpinalisCapitisMuscles;
	//private SemiSpinalisCapitisLeftMuscle semiSpinalisCapitisLeftMuscle;
	//private SemiSpinalisCapitisRightMuscle semiSpinalisCapitisRightMuscle;
	
	private SemiSpinalisCervicisMuscles semiSpinalisCervicisMuscles;
	//private SemiSpinalisCervicisLeftMuscle semiSpinalisCervicisLeftMuscle;
	//private SemiSpinalisCervicisRightMuscle semiSpinalisCervicisRightMuscle;
	
	private SemiSpinalisDorsiMuscles semiSpinalisDorsiMuscles;
	//private SemiSpinalisDorsiLeftMuscle semiSpinalisDorsiLeftMuscle;
	//private SemiSpinalisDorsiRightMuscle semiSpinalisDorsiRightMuscle;
	
	private SpinalisCapitisMuscles spinalisCapitisMuscles;
	//private SpinalisCapitisLeftMuscle spinalisCapitisLeftMuscle;
	//private SpinalisCapitisRightMuscle spinalisCapitisRightMuscle;
	
	private SpinalisCervicisMuscles spinalisCervicisMuscles;
	//private SpinalisCervicisLeftMuscle spinalisCervicisLeftMuscle;
	//private SpinalisCervicisRightMuscle spinalisCervicisRightMuscle;	
	
	private SpinalisDorsiMuscles spinalisDorsiMuscles;	
	//private SpinalisDorsiLeftMuscle spinalisDorsiLeftMuscle;
	//private SpinalisDorsiRightMuscle spinalisDorsiRightMuscle;
	
	private SpleniusCapitisMuscles spleniusCapitisMuscles;
	
	private SpleniusCervicisMuscles spleniusCervicisMuscles;
	
	private SacroSpinalisMuscles sacroSpinalisMuscles;
	
	private SemiSpinalisMuscles semiSpinalisMuscles;

	private RotatoresSpinaeMuscles rotatoresSpinaeMuscles;
	

	/*
	private RotatoresSpinaeMuscleLeft1 rotatoresSpinaeLeft1;
	private RotatoresSpinaeMuscleLeft2 rotatoresSpinaeLeft2;
	private RotatoresSpinaeMuscleLeft3 rotatoresSpinaeLeft3;
	private RotatoresSpinaeMuscleLeft4 rotatoresSpinaeLeft4;
	private RotatoresSpinaeMuscleLeft5 rotatoresSpinaeLeft5;
	private RotatoresSpinaeMuscleLeft6 rotatoresSpinaeLeft6;
	private RotatoresSpinaeMuscleLeft7 rotatoresSpinaeLeft7;
	private RotatoresSpinaeMuscleLeft8 rotatoresSpinaeLeft8;
	private RotatoresSpinaeMuscleLeft9 rotatoresSpinaeLeft9;
	private RotatoresSpinaeMuscleLeft10 rotatoresSpinaeLeft10;
	private RotatoresSpinaeMuscleLeft11 rotatoresSpinaeLeft11;
	private RotatoresSpinaeMuscleRight1 rotatoresSpinaeRight1;
	private RotatoresSpinaeMuscleRight2 rotatoresSpinaeRight2;
	private RotatoresSpinaeMuscleRight3 rotatoresSpinaeRight3;
	private RotatoresSpinaeMuscleRight4 rotatoresSpinaeRight4;
	private RotatoresSpinaeMuscleRight5 rotatoresSpinaeRight5;
	private RotatoresSpinaeMuscleRight6 rotatoresSpinaeRight6;
	private RotatoresSpinaeMuscleRight7 rotatoresSpinaeRight7;
	private RotatoresSpinaeMuscleRight8 rotatoresSpinaeRight8;
	private RotatoresSpinaeMuscleRight9 rotatoresSpinaeRight9;
	private RotatoresSpinaeMuscleRight10 rotatoresSpinaeRight10;
	private RotatoresSpinaeMuscleRight11 rotatoresSpinaeRight11;
	*/
	
	// SKELETAL
	private ThoracicVertebrae thoracicVertebrae;
	private LumbarVertebrae lumbarVertebrae;
	private SacralVertebrae sacralVertebrae;
	private CoccygealVertebrae coccygealVertebrae;
	
	// VASCULAR
	//private VertebralArtery vertebralArtery;


	// INNERVATIOBN
	private ThoracicNerveT1 thoracicNerveT1;
	private ThoracicNerveT2 ThoracicNerveT2;
	private ThoracicNerveT3 ThoracicNerveT3;
	private ThoracicNerveT4 ThoracicNerveT4;
	private ThoracicNerveT5 ThoracicNerveT5;
	private ThoracicNerveT6 ThoracicNerveT6;
	private ThoracicNerveT7 ThoracicNerveT7;
	private ThoracicNerveT8 ThoracicNerveT8;
	private ThoracicNerveT9 ThoracicNerveT9;
	private ThoracicNerveT10 ThoracicNerveT10;
	private ThoracicNerveT11 ThoracicNerveT11;

	private LumbarNerveLeftL1 lumbarNerveLeftL1;
	private LumbarNerveLeftL2 lumbarNerveLeftL2;
	private LumbarNerveLeftL3 lumbarNerveLeftL3;
	private LumbarNerveLeftL4 lumbarNerveLeftL4;
	private LumbarNerveLeftL5 lumbarNerveLeftL5;	
	private LumbarNerveRightL1 lumbarNerveRightL1;
	private LumbarNerveRightL2 lumbarNerveRightL2;
	private LumbarNerveRightL3 lumbarNerveRightL3;
	private LumbarNerveRightL4 lumbarNerveRightL4;
	private LumbarNerveRightL5 lumbarNerveRightL5;	
	
	
	/************************************************************************
	 * Back Constructor 
	 *
	 ***********************************************************************/
	public Back()
	{
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, Constants.BackRef, null, null);
	}

	/************************************************************************
	 * Back Constructor 
	 *
	 ***********************************************************************/
	public Back(String parentID)
	{
		System.out.print("Calling parameterized Back Constructor!");
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, parentID, null, null);
	}
	
	
	/************************************************************************
	 * Back Constructor 
	 *
	 ***********************************************************************/
	public Back(int hierarchy, int LOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
	{
		System.out.println("Calling Back with MethodParams!");
		create(hierarchy, LOD, parentID, bioMightProperties, bioMightMethods);
	}
	
	
	/************************************************************************
	 * Create Back
	 *
	 ***********************************************************************/

	public void create(int hierarchy, int LOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
	{

		this.setImage("images/Back.jpg");
		this.setImageHeight(300);
		this.setImageWidth(300);
		
		BioMightScale bioScale = new BioMightScale("0.00, 0.00, 0.00");
		BioMightPosition  bioPos = new BioMightPosition("0.00, 0.00, 0.00");
		String bioTemplate="Back.x3d";

	
		// Get the Bounding Box from the Constructor that defines the Back
		HashMap boundingBoxesMap = null;
		// Get the Bounding Box from the Constructor that defines 
		// the perimeter of Back  Pass that into the BoundingBoxes 
		// method so it can be divied up.
		
		//System.out.println("Back - Getting BoundBox & Connectors!");
		//BioMightBoundBox componentBoundBox = null;
		
		//BioMightConstruct bioMightConstruct = new BioMightConstruct(); 
		//if (bioMightConstruct == null)
		//{
			// Its null, so set up default boundbox with connectors 
		//	componentBoundBox = setupDefaultBoundBox();
		//}
		//else
		//{
		//	// Use the incoming
		//	componentBoundBox = bioMightConstruct.getBoundingBox(Constants.BackRef);	
		//}
		
		//BioMightConnectors componentConnectors = componentBoundBox.getBioMightConnectors();
		//if (componentConnectors == null)
		//	System.out.println("Back - ComponentConnectors are NULL!!");
		
		//System.out.println("Back - Setting up internal Bounding Boxes!");
		//boundingBoxesMap = setupBoundBoxes(componentBoundBox);

		// Set up a Constructor that will be used to pass informatino into the components
		BioMightConstruct bioConstruct = null; 

		
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Getting BackInfo for ParentID: " + parentID);
			InitialContext ctx = new InitialContext();
			BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
			bioMightTransforms = bioMightBean.getComponents(Constants.BackRef, parentID);  	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - Back");
			throw new ServerException("Remote Exception getComponents():", e); 	
		}
	
		properties = new ArrayList<BioMightPropertyView>();
		
		int localVP = Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
	
		// Get the Back
		ArrayList transforms = bioMightTransforms.getTransforms();
		System.out.println("Have BackInfo NumTransforms: " + transforms.size());
		for (int i=0; i<transforms.size(); i++)
		{
			// Get the information for the eye we are creating
			BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
			System.out.println("Creating Back(name,id): " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
			componentID = bioMightTransform.getId();
		
			//System.out.println("In Back - Getting the BoundBox: " + parentID);			
			//BioMightBoundBox tempBoundBox = bioMightConstruct.getBoundingBox(parentID);
			//if (tempBoundBox != null)
			//	System.out.println("In Back - Constructor Loaded with: " + parentID + " BoundBox");
			//else
			//	System.out.println("In Back - Constructor NOT Loaded with: " + parentID + "BoundBox");
					
			// EPITHELIUM 
			//System.out.println("In Back - Setting up Epithelium Constructor for: " + parentID);
			//bioConstruct = new BioMightConstruct();
				
			//bioConstruct.setBoundingBox(Constants.BackEpitheliumRef, tempBoundBox);		
			//System.out.println("In Back - Epithelium Constructor Set");
				
			// Create the 'skin' for the portion of the Back we are looking at 
			String startID="BackEpithelium:00001";
					
			System.out.println("Creating Back Epithelium: " + parentID);				
			epithelium = new EpitheliumTissue(localVP, localLOD, "BackEpithelium:00001", Constants.BackEpitheliumRef,  Constants.BackEpitheliumRef, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
			BioMightGenerate generatedEpithelium = epithelium.getBioMightGenerate();
			
			// For now, we will just stick the epithelium here.   We will need a 
			// map for each component,just like the constructor going in,we will
			// replicate that hierarchy coming out
			this.bioMightGenerate.setMapComponent(componentID, generatedEpithelium);
			System.out.println("Back - Stored generateEpithelium in: " + componentID);
			
			initProperty(Constants.BackEpitheliumRef, Constants.EpitheliumTissue, Constants.EpitheliumTissueRef, epithelium.getComponentID());
			System.out.println("BackEpithelium is created");			

			localVP = Constants.VIEW_HAWKEYE;;
			localLOD = Constants.MAG1X;
			
			System.out.println("Creating the LumbarVertebrae:" + bioMightTransform.getId());		
			lumbarVertebrae = new LumbarVertebrae(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);
			initProperty("LumbarVertebrae", Constants.LumbarVertebrae, Constants.LumbarVertebraeRef, lumbarVertebrae.getComponentID());
				
			System.out.println("Creating the ThoracicVetebrae: "  + bioMightTransform.getId());
			thoracicVertebrae = new ThoracicVertebrae(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
			initProperty("ThoracicVertebrae", Constants.ThoracicVertebrae, Constants.ThoracicVertebraeRef, thoracicVertebrae.getComponentID());
			
			System.out.println("Creating the SacralVertebrae:" + bioMightTransform.getId());		
			sacralVertebrae = new SacralVertebrae(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);
			initProperty("SacralVertebrae", Constants.SacralVertebrae, Constants.SacralVertebraeRef, sacralVertebrae.getComponentID());
			
			System.out.println("Creating the SacralVertebrae:" + bioMightTransform.getId());		
			coccygealVertebrae = new CoccygealVertebrae(bioMightTransform.getId(), bioMightMethods);
			initProperty("CoccygealVertebrae", Constants.CoccygealVertebrae, Constants.CoccygealVertebraeRef, coccygealVertebrae.getComponentID());
			
			// Muscles
			System.out.println("Creating the RotatoresSpinaeMuscles for parent: " + parentID);
			rotatoresSpinaeMuscles = new RotatoresSpinaeMuscles(bioMightTransform.getId(), bioMightMethods);
			initProperty("RotatoresSpinaeMuscles", Constants.RotatoresSpinaeMuscles, Constants.RotatoresSpinaeMusclesRef, rotatoresSpinaeMuscles.getComponentID());
			System.out.println("Created the RotatoresSpinaeMuscles");
			
			System.out.println("Creating the SpleniusCapitisMuscles for parent: " + parentID);
			spleniusCapitisMuscles = new SpleniusCapitisMuscles(bioMightTransform.getId(), bioMightMethods);
			initProperty("SpleniusCapitisMuscles", Constants.SpleniusCapitisMuscles, Constants.SpleniusCapitisMusclesRef, spleniusCapitisMuscles.getComponentID());
			System.out.println("Created the SpleniusCapitisMuscle");
	
			System.out.println("Creating the SpleniusCervicisMuscles for parent: " + parentID);
			spleniusCervicisMuscles = new SpleniusCervicisMuscles(bioMightTransform.getId(), bioMightMethods);
			initProperty("SpleniusCervicisMuscles", Constants.SpleniusCervicisMuscles, Constants.SpleniusCervicisMusclesRef, spleniusCervicisMuscles.getComponentID());
			System.out.println("Created the SpleniusCervicisMuscles");
			
			System.out.println("Creating the SpinalisDorsiMuscles for parent: " + parentID);
			spinalisDorsiMuscles = new SpinalisDorsiMuscles(bioMightTransform.getId(), bioMightMethods);
			initProperty("SpinalisDorsiMuscles", Constants.SpinalisDorsiMuscles, Constants.SpinalisDorsiMusclesRef, spinalisDorsiMuscles.getComponentID());
			System.out.println("Created the SpinalisDorsiMuscles");
			
			System.out.println("Creating the SpinalisCapitisMuscles for parent: " + parentID);
			spinalisCapitisMuscles = new SpinalisCapitisMuscles(bioMightTransform.getId(), bioMightMethods);
			initProperty("SpinalisCapitisMuscles", Constants.SpinalisCapitisMuscles, Constants.SpinalisCapitisMusclesRef, spinalisCapitisMuscles.getComponentID());
			System.out.println("Created the SpinalisCapitisMuscles");
		
			System.out.println("Creating the SpinalisCervicisMuscles for parent: " + parentID);
			spinalisCervicisMuscles = new SpinalisCervicisMuscles(bioMightTransform.getId(), bioMightMethods);
			initProperty("SpinalisCervicisMuscles", Constants.SpinalisCervicisMuscles, Constants.SpinalisCervicisMusclesRef, spinalisCervicisMuscles.getComponentID());
			System.out.println("Created the SpinalisCervicisMuscles");
			
			System.out.println("Creating the IliocostalisCervicisMuscles for parent: " + parentID);
			iliocostalisCervicisMuscles = new IliocostalisCervicisMuscles(bioMightTransform.getId(), bioMightMethods);
			initProperty("IliocostalisCervicisMuscles", Constants.IliocostalisCervicisMuscles, Constants.IliocostalisCervicisMusclesRef, iliocostalisCervicisMuscles.getComponentID());
			System.out.println("Created the IliocostalisCervicisMuscles");
			
			System.out.println("Creating the IliocostalisDorsiMuscles for parent: " + parentID);
			iliocostalisDorsiMuscles = new IliocostalisDorsiMuscles(bioMightTransform.getId(), bioMightMethods);
			initProperty("IliocostalisDorsiMuscles", Constants.IliocostalisDorsiMuscles, Constants.IliocostalisDorsiMusclesRef, iliocostalisDorsiMuscles.getComponentID());
			System.out.println("Created the IliocostalisDorsiMuscles");
		
			System.out.println("Creating the IliocostalisLumborumMuscles for parent: " + parentID);
			iliocostalisLumborumMuscles = new IliocostalisLumborumMuscles(bioMightTransform.getId(), bioMightMethods);
			initProperty("IliocostalisLumborumMuscles", Constants.IliocostalisLumborumMuscles, Constants.IliocostalisLumborumMusclesRef, iliocostalisLumborumMuscles.getComponentID());
			System.out.println("Created the IliocostalisLumborumMuscles");
			
			System.out.println("Creating the InterSpinalesMuscles for parent: " + parentID);
			interSpinalesMuscles = new InterSpinalesMuscles(bioMightTransform.getId(), bioMightMethods);
			initProperty("InterSpinalesMuscles", Constants.InterSpinalesMuscles, Constants.InterSpinalesMusclesRef, interSpinalesMuscles.getComponentID());
			System.out.println("Created the InterSpinalesMuscles");
		
			//System.out.println("Creating the InterTransversariiAnterioresMuscles for parent: " + parentID);
			//interTransversariiAnterioresMuscles = new InterTransversariiAnterioresMuscles(bioMightTransform.getId(), bioMightMethods);
			//System.out.println("Created the InterTransversariiAnterioresMuscles");
		
			// LONGISSIMUS
			System.out.println("Creating the LongissimusCapitisMuscles for parent: " + parentID);
			longissimusCapitisMuscles = new LongissimusCapitisMuscles(bioMightTransform.getId(), bioMightMethods);
			initProperty("LongissimusCapitisMuscles", Constants.LongissimusCapitisMuscles, Constants.LongissimusCapitisMusclesRef, longissimusCapitisMuscles.getComponentID());
			System.out.println("Created the LongissimusCapitisMuscles");
			
			System.out.println("Creating the LongissimusCervicisMuscles for parent: " + parentID);
			longissimusCervicisMuscles = new LongissimusCervicisMuscles(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
			initProperty("LongissimusCervicisMuscles", Constants.LongissimusCervicisMuscles, Constants.LongissimusCervicisMusclesRef, longissimusCervicisMuscles.getComponentID());
			System.out.println("Created the LongissimusCervicisMuscles");
			
			System.out.println("Creating the LongissimusDorsiMuscles for parent: " + parentID);
			longissimusDorsiMuscles = new LongissimusDorsiMuscles(bioMightTransform.getId(), bioMightMethods);
			initProperty("LongissimusDorsiMuscles", Constants.LongissimusDorsiMuscles, Constants.LongissimusDorsiMusclesRef, longissimusDorsiMuscles.getComponentID());
			System.out.println("Created the LongissimusDorsiMuscles");
	
			// SEMI SPINALIS
			System.out.println("Creating the SemiSpinalisMuscles for parent: " + parentID);
			semiSpinalisMuscles = new SemiSpinalisMuscles(bioMightTransform.getId(), bioMightMethods);
			initProperty("SemiSpinalisMuscles", Constants.SemiSpinalisMuscles, Constants.SemiSpinalisMusclesRef, semiSpinalisMuscles.getComponentID());
			System.out.println("Created the SemiSpinalisMuscles");
		
			System.out.println("Creating the SemiSpinalisCapitisMuscles for parent: " + parentID);
			semiSpinalisCapitisMuscles = new SemiSpinalisCapitisMuscles(bioMightTransform.getId(), bioMightMethods);
			initProperty("SemiSpinalisCapitisMuscles", Constants.SemiSpinalisCapitisMuscles, Constants.SemiSpinalisCapitisMusclesRef, semiSpinalisCapitisMuscles.getComponentID());
			System.out.println("Created the SemiSpinalisCapitisMuscles");
			
			System.out.println("Creating the SemiSpinalisCervicisMuscles for parent: " + parentID);
			semiSpinalisCervicisMuscles = new SemiSpinalisCervicisMuscles(bioMightTransform.getId(), bioMightMethods);
			initProperty("SemiSpinalisCervicisMuscles", Constants.SemiSpinalisCervicisMuscles, Constants.SemiSpinalisCervicisMusclesRef, semiSpinalisCervicisMuscles.getComponentID());
			System.out.println("Created the SemiSpinalisCervicisMuscles");
		
			System.out.println("Creating the SemiSpinalisDorsiMuscles for parent: " + parentID);
			semiSpinalisDorsiMuscles = new SemiSpinalisDorsiMuscles(bioMightTransform.getId(), bioMightMethods);
			initProperty("SemiSpinalisDorsiMuscles", Constants.SemiSpinalisDorsiMuscles, Constants.SemiSpinalisDorsiMusclesRef, semiSpinalisDorsiMuscles.getComponentID());
			System.out.println("Created the SemiSpinalisDorsiMuscles");
			
			// SACRO SPINALIS
			System.out.println("Creating the SacroSpinalisMuscles for parent: " + parentID);
			sacroSpinalisMuscles = new SacroSpinalisMuscles(bioMightTransform.getId(), bioMightMethods);
			initProperty("SacroSpinalisMuscles", Constants.SacroSpinalisMuscles, Constants.SacroSpinalisMusclesRef, sacroSpinalisMuscles.getComponentID());
			System.out.println("Created the SacroSpinalisMuscles");
			
			/*int viewPerspective = Constants.VIEW_FLOATING;
			if (viewPerspective == Constants.VIEW_FLOATING) {
				System.out.println("BackEye is created");
			
			} 
			else if (viewPerspective == Constants.VIEW_INTERNAL) {
			}
			*/
		}		
	
		//initProperties();
		initMethods();
		
		System.out.println("Create BackCompleted: " + parentID);
	
		// First, get all the data from the database
		// Apply the methods to it
		// Save its state
		this.parentID = parentID;
		if (bioMightMethods != null){
			//System.out.println("EXECUTING BackMETHODS: " + bioMightMethods.size());
			//executeMethods(bioMightMethods);
		}	
	}
	

	public void initProperties() {

		BioMightPropertyView property;

		property = new BioMightPropertyView();
		property.setPropertyName("Bones");
		property.setCanonicalName(Constants.Title);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("SpineThoracicRegion");
		property.setCanonicalName(Constants.SpineThoracicRegion);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("SpineLumbarRegion");
		property.setCanonicalName(Constants.SpineLumbarRegion);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("Muscles");
		property.setCanonicalName(Constants.Title);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("IliocostalisCervicisLeftMuscle");
		property.setCanonicalName(Constants.IliocostalisCervicisLeftMuscle);
		properties.add(property);
	
		property = new BioMightPropertyView();
		property.setPropertyName("IliocostalisCervicisRightMuscle");
		property.setCanonicalName(Constants.IliocostalisCervicisRightMuscle);
		properties.add(property);		
		
		property = new BioMightPropertyView();
		property.setPropertyName("IliocostalisDorsiLeftMuscle");
		property.setCanonicalName(Constants.IliocostalisDorsiLeftMuscle);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("IliocostalisDorsiRightMuscle");
		property.setCanonicalName(Constants.IliocostalisDorsiRightMuscle);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("IliocostalisLumborumLeftMuscle");
		property.setCanonicalName(Constants.IliocostalisLumborumLeftMuscle);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("IliocostalisLumborumRightMuscle");
		property.setCanonicalName(Constants.IliocostalisLumborumRightMuscle);
		properties.add(property);		
				
		property = new BioMightPropertyView();
		property.setPropertyName("InterSpinalesMuscle");
		property.setCanonicalName(Constants.InterSpinalesMuscle);
		properties.add(property);		
		
		property = new BioMightPropertyView();
		property.setPropertyName("InterTransversariiAnterioresLeftMuscle");
		property.setCanonicalName(Constants.InterTransversariiAnterioresLeftMuscle);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("InterTransversariiAnterioresRightMuscle");
		property.setCanonicalName(Constants.InterTransversariiAnterioresRightMuscle);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("LongissimusCapitisLeftMuscle");
		property.setCanonicalName(Constants.LongissimusCapitisLeftMuscle);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("LongissimusCapitisRightMuscle");
		property.setCanonicalName(Constants.LongissimusCapitisRightMuscle);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("LongissimusCervicisLeftMuscle");
		property.setCanonicalName(Constants.LongissimusCervicisLeftMuscle);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("LongissimusCervicisRightMuscle");
		property.setCanonicalName(Constants.LongissimusCervicisRightMuscle);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("LongissimusDorsiLeftMuscle");
		property.setCanonicalName(Constants.LongissimusDorsiLeftMuscle);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("LongissimusDorsiRightMuscle");
		property.setCanonicalName(Constants.LongissimusDorsiRightMuscle);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("InterTransversariiAnterioresLeftMuscle");
		property.setCanonicalName(Constants.GallBladder);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("Nerves");
		property.setCanonicalName(Constants.Title);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("ThoracicNerveT1");
		property.setCanonicalName(Constants.ThoracicNerveT1);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("ThoracicNerveT2");
		property.setCanonicalName(Constants.ThoracicNerveT2);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("ThoracicNerveT3");
		property.setCanonicalName(Constants.ThoracicNerveT3);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("ThoracicNerveT4");
		property.setCanonicalName(Constants.ThoracicNerveT4);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("ThoracicNerveT5");
		property.setCanonicalName(Constants.ThoracicNerveT5);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("ThoracicNerveT6");
		property.setCanonicalName(Constants.ThoracicNerveT6);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("ThoracicNerveT7");
		property.setCanonicalName(Constants.ThoracicNerveT7);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("ThoracicNerveT8");
		property.setCanonicalName(Constants.ThoracicNerveT8);
		properties.add(property);
	}
	
	
	public void initMethods() {
	
		BioMightMethodView method;

		method = new BioMightMethodView();
		method.setMethodName("Flex");
		method.setHtmlType("text");
		method.setDataType("int");
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
		
		// Assemble the Back
		String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
		"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n " +
		"<X3D profile='Immersive' >\n" +
		"<head>\n" +
		 "<meta name='BioMightImage' content='Back.jpg'/>\n" +
		 "<meta name='ExportTime' content='7:45:30'/>\n" +
		 "<meta name='ExportDate' content='08/15/2008'/>\n" +
		 "<meta name='BioMight Version' content='1.0'/>\n" + 
		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='Back'\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		

		System.out.println("Getting X3D for Back");
		String body = lumbarVertebrae.getX3D(true) +
			thoracicVertebrae.getX3D(true) + 
			sacralVertebrae.getX3D(true) + 
			coccygealVertebrae.getX3D(true) +  
			rotatoresSpinaeMuscles.getX3D(true) +
			iliocostalisCervicisMuscles.getX3D(true) +
			iliocostalisDorsiMuscles.getX3D(true) +
			iliocostalisLumborumMuscles.getX3D(true) +	
			interSpinalesMuscles.getX3D(true) +
			//interTransversariiAnterioresMuscles.getX3D(true) +
			longissimusCapitisMuscles.getX3D(true) +
			longissimusCervicisMuscles.getX3D(true) +
			longissimusDorsiMuscles.getX3D(true) +
			semiSpinalisCapitisMuscles.getX3D(true) +
			semiSpinalisCervicisMuscles.getX3D(true) +
			semiSpinalisDorsiMuscles.getX3D(true) +
			spinalisCapitisMuscles.getX3D(true) +
			spinalisCervicisMuscles.getX3D(true) +
			spinalisDorsiMuscles.getX3D(true) +
			spleniusCapitisMuscles.getX3D(true) +
			spleniusCervicisMuscles.getX3D(true) +
			sacroSpinalisMuscles.getX3D(true) +
			semiSpinalisMuscles.getX3D(true) +
			rotatoresSpinaeMuscles.getX3D(true) +
			epithelium.getX3D(true);
		//System.out.println("Back X3D: " + body);		
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
	public void executeMethods(ArrayList<BioMightMethodView> bioMightMethods) {

		// Run through the argument list and executes the 
		// associated methods
		boolean fired = false;
		System.out.println("BACK-Executing Methods: " + bioMightMethods.size());
		for (int j=0; j<bioMightMethods.size(); j++){
			
			// Get the parameter from the list and if it is not
			// empty execute the associated method using it
			BioMightMethodView bioMightMethod = (BioMightMethodView) bioMightMethods.get(j);
			System.out.println("Have BioMightMethod for BACK: " + bioMightMethod.getMethodName());	
			String methodName = bioMightMethod.getMethodName();
			String canonicalName = bioMightMethod.getCanonicalName(); 
			String dataType = bioMightMethod.getDataType();
			String methodParam = bioMightMethod.getMethodParameter(); 
			if (methodParam == null)
				methodParam = "";
			
			// We only execute those methods that are targeted for the BACK
			// If a parameter is specified then we fire the method, otherwise
			// we just jump over it
			if (canonicalName.equals(Constants.Back)) {				
				if (!methodParam.equals(""))
				{
					System.out.println("Execute Method " + methodName + " with Signature: "  +  dataType);
					System.out.println("with DataType: "  +  dataType  + "   value: " + methodParam);
					
					fired=true;		
					// Use the DataType parameter to convert the data into its base form
				
					if (dataType.equals("int")) {
						
						try {
							System.out.println("Locating Method(Integer)" + methodName);
							// 	Locate the method through introspection
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
					else if (dataType.equals("double")) {
					
						try {
							System.out.println("Locating Method(Double)" + methodName);
						// Locate the method through introspection
							double numElements = Double.parseDouble(methodParam);
							if (numElements > 0.0)
							{
								Class paramsType[] = {double.class};
								Method method = this.getClass().getDeclaredMethod(methodName, paramsType);
								System.out.println("Before Execute Method(Double)" + methodName);
								Object result = method.invoke(this, numElements);
								System.out.println("Before Execute Method(Double)" + methodName);
							}
							else
								System.out.println("Not Executing Double - 0.0"); 
						}
							catch (NumberFormatException e)
							{
								System.out.println("Could not Convert to double: " + methodParam);						
							}
							catch (NoSuchMethodException e)
							{
								System.out.println("Method with double param not found: " + e);						
							}	
							catch (Exception e)
							{
								System.out.println("General Exception: " + e);						
							}										
					}
					else if (dataType.equals("String")) {
						
						
						try {
							System.out.println("Locating Method(String)");
							
							Class paramsType[] = {String.class};
							Method method = this.getClass().getDeclaredMethod(methodName, paramsType );
							System.out.println("Method with String Param: " + methodName);
							
							System.out.println("Before Execute Method(String)" + methodName);
							Object result = method.invoke(this, methodParam);
							System.out.println("After Execute Method(String)" + methodName);
									
						}
						catch (NoSuchMethodException e)
						{
							System.out.println("Method with String param not found!");						
						}	
						catch (Exception e)
						{
							System.out.println("General Exception: " + e);						
						}	
						
					}
					else if (dataType.equals("")) {
					}			
				}	
			}
			if (fired)
			{	
				System.out.println("Methods have fired.   Calling BACK Save method!");
				save();
			}
		}
	}
	
	
	/*****************************************************************************
	 * SAVE 
	 * 
	 * This mmethod writes the Transform information back into the database.
	 * This is called after a series of methods are executed against the 
	 * existing object
	 * 
	 *****************************************************************************/
	private void save() {		

		String x3d = getX3D(true);
		
		BioMightTransform bioMightTransform = null;
		ArrayList transforms = bioMightTransforms.getTransforms();
		System.out.println("Saving Tranforms: " +  transforms.size());
		for (int i=0; i<transforms.size(); i++) {
			// Get the information for the pupil we are creating
			bioMightTransform = (BioMightTransform) transforms.get(i);
			System.out.println("Updating Back Tranforms: " + bioMightTransform.getName() + "  " + bioMightTransform.getId()); 
			System.out.println("Back Tranforms Radius is: " + bioMightTransform.getName() + "  " + bioMightTransform.getRadius());
			System.out.println("Back Tranforms Material is: " + bioMightTransform.getName() + "  " + bioMightTransform.getMaterialID());
		}

		try {
			// Save via way of the bean		
			System.out.println("Saving Back Data");
			InitialContext ctx = new InitialContext();
			BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
			int returnCode = bioMightBean.updateComponent(Constants.BackRef, parentID, bioMightTransform);
			System.out.println("Saved Back Data!");  	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - Back");
			throw new ServerException("Remote Exception getComponents():", e); 	
		}
		
	}

	/********************************************************************
	 * SETUP DEFAULT BOUNDBOX
	 * 
	 * Setup the Default Bounding Box and External Connectors for the Back.  
	 *
	 * @return
	 ********************************************************************/
	private BioMightBoundBox setupDefaultBoundBox() 
	{
		// Initialize the position of the bounding box vars
		BigDecimal xPos = new BigDecimal(0.0);
		BigDecimal yPos = new BigDecimal(0.0);
		BigDecimal zPos= new BigDecimal(0.0);
		
		// Set to base 1x1x1 magnitude
		BigDecimal xVectorMag= new BigDecimal(1.0);
		BigDecimal yVectorMag= new BigDecimal(1.0); 
		BigDecimal zVectorMag= new BigDecimal(1.0);
	
		// Set to base 1x1x1 direction resulting in cube
		BigDecimal xVectorDir= new BigDecimal(1.0);
		BigDecimal yVectorDir= new BigDecimal(1.0); 
		BigDecimal zVectorDir= new BigDecimal(1.0);
	
		double theta = 45.0;
	
		// Initialize the BoundBox
		BioMightBoundBox bioBoundBox = null;
	
		// Initialize the Connectors  
		BioMightConnectors bioMightConnectors = null; 

		// Initialize the Connector  
		BioMightConnector bioMightConnector= null;
	
		double circumference = 0.0;
		double[] startPos = {0.0, 0.0, 0.0};
		double[][] startPoints = BioGraphics.octogonYPlane(startPos, circumference);
		
		
		//**********************************************************************
		// BACK BOUND BOX		
		//
		// Set up the Bounding Box for the Back
		// For default model, length of back is 4.5
		//**********************************************************************
		xPos = new BigDecimal(0.0);
		yPos = new BigDecimal(-15.0);
		zPos= new BigDecimal(-5.0);
	
		xVectorMag= new BigDecimal(11.5);
		yVectorMag= new BigDecimal(6.0); 
		zVectorMag= new BigDecimal(5.0);
		
		// Setuo the boundbox
		bioBoundBox = new BioMightBoundBox(xPos, yPos, zPos, xVectorMag, yVectorMag, zVectorMag);
		// Set up its connectors
		bioMightConnectors = new BioMightConnectors();
		
		//********************************************
		// BACK - ORGAN CONNECTORS
		//********************************************
	
		// EpitheliumTissue Connector
		circumference = 0.3;
		startPos = getStartPoints(0.0, -5.0, -1.0);
		startPoints = BioGraphics.octogonYPlane(startPos, circumference);
		bioMightConnector = new BioMightConnector(startPoints, Constants.BackEpitheliumRef,"connType");
		bioMightConnectors.setBioMightConnector(Constants.BackEpitheliumRef, bioMightConnector);
	
		
		//********************************************	
		// BACK - VASCULAR CONNECTORS  
		//********************************************
	
		// InternalCarotidArteryEpithelium
		circumference = 0.3;
		startPos = getStartPoints(0.0, -5.0, -1.0);
		startPoints = BioGraphics.octogonYPlane(startPos, circumference);
		bioMightConnector = new BioMightConnector(startPoints, "InternalCarotidArteryEpithelium","connType");
		bioMightConnectors.setBioMightConnector("InternalCarotidArteryEpithelium", bioMightConnector);
	
		// ExternalCarotidArteryEpithelium 
		circumference = 0.3;
		startPos = getStartPoints(0.0, -5.0, -1.0);
		startPoints = BioGraphics.octogonYPlane(startPos, circumference);
		bioMightConnector  = new BioMightConnector(startPoints, "ExternalCarotidArteryEpithelium","connType");
		bioMightConnectors.setBioMightConnector("ExternalCarotidArteryEpithelium", bioMightConnector);
	
		//********************************************
		// BACK - MUSCULAR CONNECTORS
		//********************************************

	
		//********************************************
		// BACK - SKELETAL CONNECTORS
		//********************************************

		// ThoracicVertebrae T6 
		circumference = 0.3;
		startPos = getStartPoints(0.0, -5.0, -1.0);
		startPoints = BioGraphics.octogonYPlane(startPos, circumference);
		bioMightConnector  = new BioMightConnector(startPoints, "CervicalVertebrae","connType");
		bioMightConnectors.setBioMightConnector("CervicalVertebrae", bioMightConnector);
		
		
		// Stuff the Connectors into the Bounding Box 
		bioBoundBox.setBioMightConnectors(bioMightConnectors);
		
		return (bioBoundBox);	
	}	
	
	/********************************************************************
	 * SETUP BOUND BOXES
	 * 
	 * Setup the Bounding Boxes for the Back.   These boxes will define
	 *  the local coordinate system for the component, and also
	 * set the parameters in LxWxH that the component and its contents
	 * are confined to.
	 *
	 * @return
	 ********************************************************************/
	private HashMap setupBoundBoxes(BioMightBoundBox bioMightBoundBoxIn) 
	{
		// Set up the bounding boxes for the various components
		// The various components locations will be driven by the
		// bounding boxes
		HashMap boundingBoxMap = new HashMap();
		
		// Initialize the position of the bounding box vars
		BigDecimal xPos = new BigDecimal(0.0);
		BigDecimal yPos = new BigDecimal(0.0);
		BigDecimal zPos= new BigDecimal(0.0);
			
		// Set to base 1x1x1 cube
		BigDecimal xVectorMag= new BigDecimal(1.0);
		BigDecimal yVectorMag= new BigDecimal(1.0); 
		BigDecimal zVectorMag= new BigDecimal(1.0);

		// Rotation Vector
		BigDecimal xVectorDir= new BigDecimal(1.0);
		BigDecimal yVectorDir= new BigDecimal(1.0); 
		BigDecimal zVectorDir= new BigDecimal(1.0);

		// direction anlgle
		double theta = 30.0;
		
		// Initialize the BoundBoxes. This is used for
		// collections such as arms, legs,lungs,etc
		BioMightBoundBoxes bioBoundBoxes = null;
	
		// Initialize the BoundBox
		BioMightBoundBox bioBoundBox = null;

		// Initialize the Connectors  
		BioMightConnectors bioMightConnectors = null; 

		// Initialize the Connector  
		BioMightConnector bioMightConnector= null;
		
		double circumference = 0.0;
		double[] startPos = {0.0, 0.0, 0.0};
		double[][] startPoints = BioGraphics.octogonYPlane(startPos, circumference);

		double[] endPos = {0.0, 0.0, 0.0};
		double[][] endPoints = BioGraphics.octogonYPlane(endPos, circumference);

		
		// Use the information in the incomiing Bound Box
		// to orientate the inner bound boxes
		if (bioMightBoundBoxIn != null)
		{
			System.out.println("Back - SetupBoundBoxes - Incoming BoundBox: " + 
					bioMightBoundBoxIn.getXPos() + " " +
					bioMightBoundBoxIn.getYPos() + " " +
					bioMightBoundBoxIn.getZPos());
		}
		
		
		//********************************************************************* 
		// EPITHELIUM BOUNDBOX
		// Set up the Bounding Box for the Back
		// The connector for this will come from the incoming Bound Box
		// Both are defined like and bolt and they lock into position at the
		// interestion of both connectors
		//**********************************************************************
		xPos = new BigDecimal(0.0);
		yPos = new BigDecimal(-9.0);
		zPos= new BigDecimal(-1.0);
		
		xVectorMag= new BigDecimal(9.0);
		yVectorMag= new BigDecimal(8.0); 
		zVectorMag= new BigDecimal(4.0);

		bioBoundBox = new BioMightBoundBox(xPos, yPos, zPos, xVectorMag, yVectorMag, zVectorMag);
		bioMightConnectors = new BioMightConnectors();
		
		// Back Epithelium Connector
		circumference = 0.3;
		startPos = getStartPoints(0.0, -9.0, -1.0);
		startPoints = BioGraphics.octogonYPlane(startPos, circumference);
		endPos = getEndPoints(0.0, -17.0, -1.0);
		endPoints = BioGraphics.octogonYPlane(endPos, circumference);
	
		bioMightConnector  = new BioMightConnector(startPoints, endPoints, "BackEpithelialCell","connType");
		bioMightConnectors.setBioMightConnector("BackEpithelialCell", bioMightConnector);
			
		bioBoundBox.setBioMightConnectors(bioMightConnectors);
		
		boundingBoxMap.put(Constants.BackEpitheliumRef, bioBoundBox);
		
		
		return (boundingBoxMap);
	}
		
	
	
	public LumbarNerveLeftL1 getLumbarNerveLeftL1() {
		return lumbarNerveLeftL1;
	}

	public void setLumbarNerveLeftL1(LumbarNerveLeftL1 lumbarNerveLeftL1) {
		this.lumbarNerveLeftL1 = lumbarNerveLeftL1;
	}

	public LumbarNerveLeftL2 getLumbarNerveLeftL2() {
		return lumbarNerveLeftL2;
	}

	public void setLumbarNerveLeftL2(LumbarNerveLeftL2 lumbarNerveLeftL2) {
		this.lumbarNerveLeftL2 = lumbarNerveLeftL2;
	}

	public LumbarNerveLeftL3 getLumbarNerveLeftL3() {
		return lumbarNerveLeftL3;
	}

	public void setLumbarNerveLeftL3(LumbarNerveLeftL3 lumbarNerveLeftL3) {
		this.lumbarNerveLeftL3 = lumbarNerveLeftL3;
	}

	public LumbarNerveLeftL4 getLumbarNerveLeftL4() {
		return lumbarNerveLeftL4;
	}

	public void setLumbarNerveLeftL4(LumbarNerveLeftL4 lumbarNerveLeftL4) {
		this.lumbarNerveLeftL4 = lumbarNerveLeftL4;
	}

	public LumbarNerveLeftL5 getLumbarNerveLeftL5() {
		return lumbarNerveLeftL5;
	}

	public void setLumbarNerveLeftL5(LumbarNerveLeftL5 lumbarNerveLeftL5) {
		this.lumbarNerveLeftL5 = lumbarNerveLeftL5;
	}

	public LumbarNerveRightL1 getLumbarNerveRightL1() {
		return lumbarNerveRightL1;
	}

	public void setLumbarNerveRightL1(LumbarNerveRightL1 lumbarNerveRightL1) {
		this.lumbarNerveRightL1 = lumbarNerveRightL1;
	}

	public LumbarNerveRightL2 getLumbarNerveRightL2() {
		return lumbarNerveRightL2;
	}

	public void setLumbarNerveRightL2(LumbarNerveRightL2 lumbarNerveRightL2) {
		this.lumbarNerveRightL2 = lumbarNerveRightL2;
	}

	public LumbarNerveRightL3 getLumbarNerveRightL3() {
		return lumbarNerveRightL3;
	}

	public void setLumbarNerveRightL3(LumbarNerveRightL3 lumbarNerveRightL3) {
		this.lumbarNerveRightL3 = lumbarNerveRightL3;
	}

	public LumbarNerveRightL4 getLumbarNerveRightL4() {
		return lumbarNerveRightL4;
	}

	public void setLumbarNerveRightL4(LumbarNerveRightL4 lumbarNerveRightL4) {
		this.lumbarNerveRightL4 = lumbarNerveRightL4;
	}

	public LumbarNerveRightL5 getLumbarNerveRightL5() {
		return lumbarNerveRightL5;
	}

	public void setLumbarNerveRightL5(LumbarNerveRightL5 lumbarNerveRightL5) {
		this.lumbarNerveRightL5 = lumbarNerveRightL5;
	}


	
	public ThoracicNerveT1 getThoracicNerveT1() {
		return thoracicNerveT1;
	}

	public void setThoracicNerveT1(ThoracicNerveT1 thoracicNerveT1) {
		this.thoracicNerveT1 = thoracicNerveT1;
	}

	public ThoracicNerveT10 getThoracicNerveT10() {
		return ThoracicNerveT10;
	}

	public void setThoracicNerveT10(ThoracicNerveT10 thoracicNerveT10) {
		ThoracicNerveT10 = thoracicNerveT10;
	}

	public ThoracicNerveT11 getThoracicNerveT11() {
		return ThoracicNerveT11;
	}

	public void setThoracicNerveT11(ThoracicNerveT11 thoracicNerveT11) {
		ThoracicNerveT11 = thoracicNerveT11;
	}

	public ThoracicNerveT2 getThoracicNerveT2() {
		return ThoracicNerveT2;
	}

	public void setThoracicNerveT2(ThoracicNerveT2 thoracicNerveT2) {
		ThoracicNerveT2 = thoracicNerveT2;
	}

	public ThoracicNerveT3 getThoracicNerveT3() {
		return ThoracicNerveT3;
	}

	public void setThoracicNerveT3(ThoracicNerveT3 thoracicNerveT3) {
		ThoracicNerveT3 = thoracicNerveT3;
	}

	public ThoracicNerveT4 getThoracicNerveT4() {
		return ThoracicNerveT4;
	}

	public void setThoracicNerveT4(ThoracicNerveT4 thoracicNerveT4) {
		ThoracicNerveT4 = thoracicNerveT4;
	}

	public ThoracicNerveT5 getThoracicNerveT5() {
		return ThoracicNerveT5;
	}

	public void setThoracicNerveT5(ThoracicNerveT5 thoracicNerveT5) {
		ThoracicNerveT5 = thoracicNerveT5;
	}

	public ThoracicNerveT6 getThoracicNerveT6() {
		return ThoracicNerveT6;
	}

	public void setThoracicNerveT6(ThoracicNerveT6 thoracicNerveT6) {
		ThoracicNerveT6 = thoracicNerveT6;
	}

	public ThoracicNerveT7 getThoracicNerveT7() {
		return ThoracicNerveT7;
	}

	public void setThoracicNerveT7(ThoracicNerveT7 thoracicNerveT7) {
		ThoracicNerveT7 = thoracicNerveT7;
	}

	public ThoracicNerveT8 getThoracicNerveT8() {
		return ThoracicNerveT8;
	}

	public void setThoracicNerveT8(ThoracicNerveT8 thoracicNerveT8) {
		ThoracicNerveT8 = thoracicNerveT8;
	}

	public ThoracicNerveT9 getThoracicNerveT9() {
		return ThoracicNerveT9;
	}

	public void setThoracicNerveT9(ThoracicNerveT9 thoracicNerveT9) {
		ThoracicNerveT9 = thoracicNerveT9;
	}

	public void shrug(){
	}


}
