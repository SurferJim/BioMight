
package biomight.body.gland.pineal;

import biomight.Constants;
import biomight.body.organ.Organ;
import biomight.chemistry.compound.Tetraiodothyronine5Deiodinase;
import biomight.chemistry.hormones.aminederived.tyrosine.*;
import biomight.cell.extracellularmatrixsecretion.Pinealocytes;
import biomight.cell.hormonesecreting.*;
import biomight.cell.misc.InterstitialCells;
import biomight.cell.misc.PeptidergicNeuronLikeCells;
import biomight.cell.misc.PerivascularPhagocyte;
import biomight.cell.neuronglial.nueron.PinealNeurons;
import biomight.ejb.BioMightBeanLocal;
import biomight.exceptions.DataSecurityException;
import biomight.exceptions.ServerException;
import biomight.system.tissue.epithelial.EpitheliumTissue;
import biomight.util.BioGraphics;
import biomight.view.BioMightMethodView;
import biomight.view.BioMightPosition;
import biomight.view.BioMightPropertyView;
import biomight.view.BioMightScale;
import biomight.view.BioMightTransform;
import biomight.view.BioMightTransforms;

import java.math.BigDecimal;
import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;


/********************************************************************
 * @author SurferJim
 *
 * Rwpresentation of the Pineal Gland
 * 
 *******************************************************************/

public class PinealGland extends Organ {	
	protected EpitheliumTissue epithelium;
	//private BigDecimal melantonin;	
	private Pinealocytes pinealocytes;
	//private GlialCells glialCells;
	private PerivascularPhagocyte perivascularPhagocyte;
	private InterstitialCells interstitialCells;	
	private PinealNeurons pinealNeurons;
	private PeptidergicNeuronLikeCells peptidergicNeuronLikeCells;
	private PialCapsule pialCapsule;
	
	public PinealGland()
	{
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, Constants.PinealGlandRef, null, null);
	}

	public PinealGland(String parentID)
	{
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, parentID, null, null);
	}

	public PinealGland(int vp, int LOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
	{
		System.out.print("Calling PinealGland Create");
		create(vp, LOD, parentID, bioMightProperties, bioMightMethods);
	}

	
	/*****************************************************************
	 * CREATE
	 * 
	 * @param parentID
	 * @param bioMightMethods
	 ******************************************************************/
	public void create(int viewPerspective, int LOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
	{

		this.setImage("images/PinealGland.jpg");
		this.setImageHeight(300);
		this.setImageWidth(300);
	
		
		// Get the information from the database via the Enterprise Bean		
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Getting PinealGlandInfo for ParentID: " + parentID);
			Context ctx = new InitialContext(); 
			BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
			bioMightTransforms = bioMightBean.getComponents(Constants.PinealGlandRef, parentID);
			System.out.println("Have PinealGland Info from EJB");   	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - PinealGland");
			throw new ServerException("Remote Exception getComponents():", e); 	
		}
		
		int localVP = Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;

		BioMightScale bioScale = new BioMightScale("0.00, 0.00, 0.00");
		BioMightPosition  bioPos = new BioMightPosition("0.00, 0.00, 0.00");
		String bioTemplate="Bacterias.x3d";

		
		// Run through the collection of PinealGlands and build them into the model
		// In the default case, we get one instance of the PinealGland for each eye
		ArrayList transforms = bioMightTransforms.getTransforms();
		System.out.println("PinealGland NumTransforms: " + transforms.size());
		for (int i=0; i<transforms.size(); i++)
		{
			// Get the information for the eye we are creating
			BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
			System.out.println("Created PinealGland: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
			this.componentID = bioMightTransform.getId();
			
			// Generate the Pineal Epithelium if needed 
			boolean bGenerate = false;
			if (bGenerate) {
				generate(parentID, componentID);
			}
			
			System.out.println("Creating PinealGland Epithelium: " + bioMightTransform.getId());				
			String startID = "PinealGlandEpithelium:00001";
			epithelium = new EpitheliumTissue(localVP, localLOD, startID, "PinealGlandEpithelium",  Constants.EpitheliumTissueRef, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
			initProperty(bioMightTransform.getName(), Constants.EpitheliumTissue, Constants.EpitheliumTissueRef, epithelium.getComponentID());

			/*int viewPerspective = Constants.VIEW_DETACHED;
			if (viewPerspective == Constants.VIEW_DETACHED)
			{				
				// Create the components of the curvature

			}*/
		}
		
		initProperties();
		initMethods();
		
		System.out.println("CreatePinealGland Completed");
		
		// First, get all the data from the database
		// Apply the methods to it
		// Save its state
		this.parentID = parentID;
		if (bioMightMethods != null){
			System.out.println("EXECUTING PinealGland METHODS: " + bioMightMethods.size());
			//executeMethods(bioMightMethods);
		}
	}
	
	
	/****************************************************************************
	 * GENERATE PINEAL GLAND
	 * 
	 * @param parentID
	 * @param componentID
	 ***************************************************************************/
	
	public void generate(String parentID, String componentID)
	{
		// Generate the PinealGland Epithelium		
		BioMightBeanLocal bioMightBean;
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Generating the PinealGland ParentID: " + parentID);
			InitialContext ctx = new InitialContext();
			bioMightBean = (BioMightBeanLocal) ctx.lookup("java:global/BioMightWeb/BioMightBean!biomight.ejb.BioMightBeanLocal");
	
			double circumference = 0.125;
		
			// Generate the PinealGland
			//  seven sections
			double[] startPos = {0.0, -0.35, -4.75};
			
			
			// Create a equilateral octogon
			double x =  startPos[0];
			double y =  startPos[1];
			double z =  startPos[2];

			double[][] currentPoints = BioGraphics.octogonYPlane(startPos, circumference);	
			
			int success = bioMightBean.generatePinealGland("PinealGlandEpithelium:00001", "PinealGlandEpithelium", 
				"PinealGlandEpithelium", componentID, parentID, currentPoints);			
	
				
			System.out.println("Created PinealGlandEpithelium Info using EJB");   	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - PinealGlandEpithelium");
			throw new ServerException("Remote Exception getComponents():", e); 	
		}
	}
	
	


	public void initProperties() {
	
		BioMightScale bioScale = new BioMightScale("0.00, 0.00, 0.00");
		BioMightPosition bioPos = new BioMightPosition("0.00, 0.00, 0.00");	
		String bioTemplate =""; 

		initProperty("----Not Available---", Constants.Title, Constants.Title, "AdrenalGland:0", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		initProperty(Constants.PinealocytesRef, Constants.Pinealocytes, Constants.PinealocytesRef, "PinealGland:0", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		initProperty(Constants.PerivascularPhagocytesRef, Constants.PerivascularPhagocytes, Constants.PerivascularPhagocytesRef, "PinealGland:0", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		initProperty(Constants.PinealNeuronsRef, Constants.PinealNeurons, Constants.PinealNeuronsRef, "PinealGland:0", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		initProperty(Constants.InterstitialCellsRef, Constants.InterstitialCells, Constants.InterstitialCellsRef, "PinealGland:0", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		initProperty(Constants.PeptidergicNeuronLikeCellsRef, Constants.PeptidergicNeuronLikeCells, Constants.PeptidergicNeuronLikeCellsRef, "PinealGland:0", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		initProperty(Constants.PialCapsuleRef, Constants.PialCapsule, Constants.PialCapsuleRef, "PinealGland:0", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		
	}
			
	
	public void initMethods() {

		methods = new ArrayList<BioMightMethodView>();
		
		BioMightMethodView method = new BioMightMethodView();

		method = new BioMightMethodView();
		method.setDisplayName("Produce Adrenocorticotropic Hormone (ACTH)");
		method.setHtmlType("checkbox");
		methods.add(method);	
		
		method = new BioMightMethodView();
		method.setDisplayName("Produce Thyroid Stimulating Hormone (TSH)");
		method.setHtmlType("checkbox");
		methods.add(method);
		
		method = new BioMightMethodView();
		method.setDisplayName("Produce Luteinizing Hormone (LH)");
		method.setHtmlType("checkbox");
		methods.add(method);
		
		method = new BioMightMethodView();
		method.setDisplayName("Produce Prolactin (PRL)");
		method.setHtmlType("checkbox");
		methods.add(method);
	}
	
	/*********************************************************************************
	 * INIT 3D
	 * 
	 * This method will be executed when we can see cartilage with our regular
	 * perception.  This is not at the cellular level, but as if one were looking
	 * at the ear.
	 *
	 ********************************************************************************/
	public void init3D(BioMightPosition position) {
	
	}
		 						

	
	/********************************************************************************************************************
	 * GET X3D
	 * 
	 * This method will return the X3D for the Stomach Greater Curvature.  It runs through each of its 
	 * components and collects up their representations and then assembles them into one unified X3D model.
	 * 
	 ********************************************************************************************************************/
	
	
	public String getX3D(boolean snipet) {
		
		// Assemble the Greater Curvature
		String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
		"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n " +
		"<X3D profile='Immersive' >\n" +
		"<head>\n" +
		 "<meta name='BioMightImage' content='PinealGland.jpg'/>\n" +
		 "<meta name='ExportTime' content='7:45:30'/>\n" +
		 "<meta name='ExportDate' content='08/15/2008'/>\n" +
		 "<meta name='BioMight Version' content='1.0'/>\n" + 
		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='PinealGland'\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		

		String body = epithelium.getX3D(true);  
		//System.out.println("PinealGland X3D: " + body);		
		
		// We should do this on detached view only
		body+= "<Viewpoint DEF='Viewpoint_PinealGland'\n" +
				 "description='Viewpoint1'\n" +
				 "jump='true'\n" +
				 "fieldOfView='0.785'\n" +
				 "position='0.0 -3.0 8.0'\n" +
				 "orientation='0 0 1 0'/>\n";
		
		String footer = "</Scene>" + "</X3D>\n";
		
		if (snipet)
			return body;			
		else	
			return header + body + footer;
	}
	
	
	
	public String getX3DExternal(boolean snipet) {
		
		// Assemble the Femoral Vein 
		String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
		"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n " +
		"<X3D profile='Immersive' >\n" +
		"<head>\n" +
		 "<meta name='BioMightImage' content='PinealGland .jpg'/>\n" +
		 "<meta name='ExportTime' content='7:45:30'/>\n" +
		 "<meta name='ExportDate' content='08/15/2008'/>\n" +
		 "<meta name='BioMight Version' content='1.0'/>\n" + 
		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='PinealGland '\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		


		String body = "";
		
		// Run through the collection of PinealGland  and build them into the model
		// In the default case, we get one instance of the PinealGland  for each Stomach
		ArrayList transforms = bioMightTransforms.getTransforms();
		for (int i=0; i<transforms.size(); i++)
		{
			// Get the information for the PinealGland we are creating
			BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
			System.out.println("Getting PinealGland X3D: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
		
			int view = Constants.VIEW_FLOATING;
			if (view == Constants.VIEW_FLOATING)
			{
				//System.out.println("Getting X3D for PinealGland X: " + bioMightSphere.getTranslation().getXPos());
				//System.out.println("Getting X3D for PinealGland Y: " + bioMightSphere.getTranslation().getYPos());
				//System.out.println("Getting X3D for PinealGland Z: " + bioMightSphere.getTranslation().getZPos());
				// Change the height and width based on the displacement.
				body += "<Transform DEF='PinealGland '\n" +
		 			"translation='" + bioMightTransform.getTranslation().getXPos() + " " 
			 					+ bioMightTransform.getTranslation().getYPos() + " "
			 					+ bioMightTransform.getTranslation().getZPos() + "'\n" +
			 		"scale='" 	+ bioMightTransform.getScale().getXPos() + " "
			 				+ bioMightTransform.getScale().getYPos() + " "
			 				+ bioMightTransform.getScale().getZPos() + "'>\n" +
					"<Shape DEF='PinealGland Shape'\n" +
						    " containerField='children'>\n" +
						    " <Appearance\n" +
						    "  containerField='appearance'>\n" +
						    " <Material DEF='Rust'\n" +
						    "containerField='material'\n" +
						    "ambientIntensity='" + bioMightTransform.getMaterial().getAmbientIntensity() + "'\n" +
						    "shininess='" 		 + bioMightTransform.getMaterial().getShininess() + "'\n" +
						    "transparency='" 	 + bioMightTransform.getMaterial().getTransparency() + "'\n" +
						    "diffuseColor='" + 
						    bioMightTransform.getMaterial().getDiffuseColor().getRed() + " " + 
						    bioMightTransform.getMaterial().getDiffuseColor().getGreen() + " " +
						    bioMightTransform.getMaterial().getDiffuseColor().getBlue() + "'/>\n" +
						 	"</Appearance>\n" +			    
						 	"<IndexedFaceSet DEF='PinealGland IFS' \n" +
						    	   "containerField='geometry' \n" +
						    	   "creaseAngle='" +  bioMightTransform.getCreaseAngle() + "'\n" +
						    	   "coordIndex='" + bioMightTransform.getCoordindexStr() + "'>" +
						    	   "<Coordinate DEF='PinealGland _Coord' \n" +
						    	    "containerField='coord' point='" +  bioMightTransform.getCoordpointStr() + "'/>" +
						    	  "</IndexedFaceSet>\n" +
					"</Shape>\n" +
				"<TouchSensor DEF='StartStomachBeat' \n" +
						  " containerField='children'/> \n" +
			 "</Transform>\n";
			
		}
		else
		{
			body = "";//						
		}
		
		}
		

		
		//System.out.println("PinealGland X3D: " + body);		
		String footer = "</Scene>" + "</X3D>\n";
		
		if (snipet)
			return body;			
		else	
			return header + body + footer;
	}	



}

