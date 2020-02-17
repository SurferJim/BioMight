
package biomight.body.organ.thymus;

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
import biomight.system.tissue.AreolarTissue;
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
 * Rwpresentation of the Thymus
 * 
 *******************************************************************/

public class Thymus extends Organ {	
	protected EpitheliumTissue epithelium;
	private ThymusRightLateralLobe thymusRightLateralLobe;
	private ThymusLeftLateralLobe thymusLeftLateralLobe;
	private AreolarTissue areolarTissue;
	private ThymicMedulla thymicMedulla;
	private ThymicCortex thymicCortex;
	
	
	public Thymus()
	{
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, Constants.ThymusRef, null, null);
	}

	public Thymus(String parentID)
	{
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, parentID, null, null);
	}

	public Thymus(int vp, int LOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
	{
		System.out.print("Calling Thymus Create");
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

		this.setImage("images/Thymus.jpg");
		this.setImageHeight(300);
		this.setImageWidth(300);
	
		
		// Get the information from the database via the Enterprise Bean		
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Getting ThymusInfo for ParentID: " + parentID);
			Context ctx = new InitialContext(); 
			BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
			bioMightTransforms = bioMightBean.getComponents(Constants.ThymusRef, parentID);
			System.out.println("Have Thymus Info from EJB");   	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - Thymus");
			throw new ServerException("Remote Exception getComponents():", e); 	
		}
		
		int localVP = Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;

		BioMightScale bioScale = new BioMightScale("0.00, 0.00, 0.00");
		BioMightPosition  bioPos = new BioMightPosition("0.00, 0.00, 0.00");
		String bioTemplate="Bacterias.x3d";

		
		// Run through the collection of Thymuss and build them into the model
		// In the default case, we get one instance of the Thymus for each eye
		ArrayList transforms = bioMightTransforms.getTransforms();
		System.out.println("Thymus NumTransforms: " + transforms.size());
		for (int i=0; i<transforms.size(); i++)
		{
			// Get the information for the eye we are creating
			BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
			System.out.println("Created Thymus: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
			this.componentID = bioMightTransform.getId();
			
			// Generate the Pineal Epithelium if needed 
			boolean bGenerate = false;
			if (bGenerate) {
				generate(parentID, componentID);
			}
			
			System.out.println("Creating Thymus Epithelium: " + bioMightTransform.getId());				
			String startID = "ThymusEpithelium:00001";
			epithelium = new EpitheliumTissue(localVP, localLOD, startID, "ThymusEpithelium",  Constants.EpitheliumTissueRef, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
			initProperty(bioMightTransform.getName(), Constants.EpitheliumTissue, Constants.EpitheliumTissueRef, epithelium.getComponentID());

			/*int viewPerspective = Constants.VIEW_DETACHED;
			if (viewPerspective == Constants.VIEW_DETACHED)
			{				
				// Create the components of the curvature
				
			thymusRightLateralLobe = new ThymusRightLateralLobe();
			thymusLeftLateralLobe = new ThymusLeftLateralLobe();
			areolarTissue = new AreolarTissue();
			thymicMedulla = new ThymicMedulla();
			thymicCortex = new ThymicCortex();

			}*/
		}
		
		initProperties();
		initMethods();
		
		System.out.println("CreateThymus Completed");
		
		// First, get all the data from the database
		// Apply the methods to it
		// Save its state
		this.parentID = parentID;
		if (bioMightMethods != null){
			System.out.println("EXECUTING Thymus METHODS: " + bioMightMethods.size());
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
		// Generate the Thymus Epithelium		
		BioMightBeanLocal bioMightBean;
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Generating the Thymus ParentID: " + parentID);
			InitialContext ctx = new InitialContext();
			bioMightBean = (BioMightBeanLocal) ctx.lookup("java:global/BioMightWeb/BioMightBean!biomight.ejb.BioMightBeanLocal");
	
			double circumference = 0.0625;
		
			// Generate the Thymus
			//  seven sections
			double[] startPos = {0.0, -11.00, -1.5};
			
			
			// Create a equilateral octogon
			double x =  startPos[0];
			double y =  startPos[1];
			double z =  startPos[2];

			double[][] currentPoints = BioGraphics.octogonYPlane(startPos, circumference);	
			
			int success = bioMightBean.generateThymus("ThymusEpithelium:00001", "ThymusEpithelium", 
				"ThymusEpithelium", componentID, parentID, currentPoints);			
	
				
			System.out.println("Created ThymusEpithelium Info using EJB");   	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - ThymusEpithelium");
			throw new ServerException("Remote Exception getComponents():", e); 	
		}
	}
	
	

	
	public void initProperties() {
	
		BioMightScale bioScale = new BioMightScale("0.00, 0.00, 0.00");
		BioMightPosition bioPos = new BioMightPosition("0.00, 0.00, 0.00");	
		String bioTemplate =""; 

		initProperty("----Not Available---", Constants.Title, Constants.Title, "AdrenalGland:0", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
			
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
		 "<meta name='BioMightImage' content='Thymus.jpg'/>\n" +
		 "<meta name='ExportTime' content='7:45:30'/>\n" +
		 "<meta name='ExportDate' content='08/15/2008'/>\n" +
		 "<meta name='BioMight Version' content='1.0'/>\n" + 
		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='Thymus'\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		

		String body = epithelium.getX3D(true);  
		//System.out.println("Thymus X3D: " + body);		
		
		body+= "<Viewpoint DEF='Viewpoint_Thymus'\n" +
				 "description='Viewpoint1'\n" +
				 "jump='true'\n" +
				 "fieldOfView='0.785'\n" +
				 "position='0.0 -14.0 15.0'\n" +
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
		 "<meta name='BioMightImage' content='Thymus .jpg'/>\n" +
		 "<meta name='ExportTime' content='7:45:30'/>\n" +
		 "<meta name='ExportDate' content='08/15/2008'/>\n" +
		 "<meta name='BioMight Version' content='1.0'/>\n" + 
		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='Thymus '\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		


		String body = "";
		
		// Run through the collection of Thymus  and build them into the model
		// In the default case, we get one instance of the Thymus  for each Stomach
		ArrayList transforms = bioMightTransforms.getTransforms();
		for (int i=0; i<transforms.size(); i++)
		{
			// Get the information for the Thymus we are creating
			BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
			System.out.println("Getting Thymus X3D: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
		
			int view = Constants.VIEW_FLOATING;
			if (view == Constants.VIEW_FLOATING)
			{
				//System.out.println("Getting X3D for Thymus X: " + bioMightSphere.getTranslation().getXPos());
				//System.out.println("Getting X3D for Thymus Y: " + bioMightSphere.getTranslation().getYPos());
				//System.out.println("Getting X3D for Thymus Z: " + bioMightSphere.getTranslation().getZPos());
				// Change the height and width based on the displacement.
				body += "<Transform DEF='Thymus '\n" +
		 			"translation='" + bioMightTransform.getTranslation().getXPos() + " " 
			 					+ bioMightTransform.getTranslation().getYPos() + " "
			 					+ bioMightTransform.getTranslation().getZPos() + "'\n" +
			 		"scale='" 	+ bioMightTransform.getScale().getXPos() + " "
			 				+ bioMightTransform.getScale().getYPos() + " "
			 				+ bioMightTransform.getScale().getZPos() + "'>\n" +
					"<Shape DEF='Thymus Shape'\n" +
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
						 	"<IndexedFaceSet DEF='Thymus IFS' \n" +
						    	   "containerField='geometry' \n" +
						    	   "creaseAngle='" +  bioMightTransform.getCreaseAngle() + "'\n" +
						    	   "coordIndex='" + bioMightTransform.getCoordindexStr() + "'>" +
						    	   "<Coordinate DEF='Thymus _Coord' \n" +
						    	    "containerField='coord' point='" +  bioMightTransform.getCoordpointStr() + "'/>" +
						    	  "</IndexedFaceSet>\n" +
					"</Shape>\n" +
	
					"<TimeSensor DEF='StomachBeatTimer'\n" +
						  " containerField='children'\n " +
						  " cycleInterval='1.000'\n " + 
						  " loop='true' \n" +
						  " startTime='-1.000'/> \n" +
					"<TouchSensor DEF='StartStomachBeat' \n" +
						  " containerField='children'/> \n" +
			 "</Transform>\n" +
			 "<PositionInterpolator DEF='StomachBeatAnim'\n" + 
			 "key='0 .5 1'\n" +
			 "keyValue='1 1 1 .9 .9 .9 1 1 1'/>\n" + 
			 "<ROUTE fromNode='StartStomachBeat' fromField='touchTime' toNode='StomachBeatTimer' toField='startTime'/>\n" +
			 "<ROUTE fromNode='StomachBeatTimer' fromField='fraction_changed' toNode='StomachBeatAnim' toField='set_fraction'/>\n" +
			 "<ROUTE fromNode='StomachBeatAnim' fromField='value_changed' toNode='Thymus' toField='set_scale'/>\n";
		}
		else
		{
			body = "";//						
		}
		
		}
		
		//System.out.println("Thymus X3D: " + body);		
		String footer = "</Scene>" + "</X3D>\n";
		
		if (snipet)
			return body;			
		else	
			return header + body + footer;
	}	



}

