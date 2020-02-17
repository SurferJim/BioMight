
package biomight.body.gland.pituitary;

import biomight.Constants;
import biomight.body.organ.Organ;
import biomight.chemistry.compound.Tetraiodothyronine5Deiodinase;
import biomight.chemistry.hormones.aminederived.tyrosine.*;
import biomight.cell.hormonesecreting.*;
import biomight.ejb.BioMightBeanLocal;
import biomight.exceptions.DataSecurityException;
import biomight.exceptions.ServerException;
import biomight.system.tissue.epithelial.EpitheliumTissue;
import biomight.system.vascular.veins.head.HypophysealVein;
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
 * Rwpresentation of the Pituitary Gland
 * 
 *******************************************************************/

public class PituitaryGland extends Organ {	
	protected EpitheliumTissue epithelium;

	// Anterior Pituitary
	private AdenoHypophysis adenohypophysis;

	// Posterior Pituitary
	private NeuroHypophysis neuroHypophysis;

	private HypophysealVein hypophysealVein;
	
	
	public PituitaryGland()
	{
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, Constants.PituitaryGlandRef, null, null);
	}

	public PituitaryGland(String parentID)
	{
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, parentID, null, null);
	}

	public PituitaryGland(int vp, int LOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
	{
		System.out.print("Calling PituitaryGland Create");
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

		this.setImage("images/PituitaryGland.jpg");
		this.setImageHeight(300);
		this.setImageWidth(300);
	
		
		// Get the information from the database via the Enterprise Bean		
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Getting PituitaryGlandInfo for ParentID: " + parentID);
			Context ctx = new InitialContext(); 
			BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
			bioMightTransforms = bioMightBean.getComponents(Constants.PituitaryGlandRef, parentID);
			System.out.println("Have PituitaryGland Info from EJB");   	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - PituitaryGland");
			throw new ServerException("Remote Exception getComponents():", e); 	
		}
		
		int localVP = Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;

		BioMightScale bioScale = new BioMightScale("0.00, 0.00, 0.00");
		BioMightPosition  bioPos = new BioMightPosition("0.00, 0.00, 0.00");
		String bioTemplate="Bacterias.x3d";

		
		// Run through the collection of PituitaryGlands and build them into the model
		// In the default case, we get one instance of the PituitaryGland for each eye
		ArrayList transforms = bioMightTransforms.getTransforms();
		System.out.println("PituitaryGland NumTransforms: " + transforms.size());
		for (int i=0; i<transforms.size(); i++)
		{
			// Get the information for the eye we are creating
			BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
			System.out.println("Created PituitaryGland: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
			this.componentID = bioMightTransform.getId();
			
			// Generate the Pituitary Epithelium if needed 
			boolean bGenerate = false;
			if (bGenerate) {
				generate(parentID, componentID);
			}
			
			System.out.println("Creating PituitaryGland Epithelium: " + bioMightTransform.getId());				
			String startID = "PituitaryGlandEpithelium:00001";
			epithelium = new EpitheliumTissue(localVP, localLOD, startID, "PituitaryGlandEpithelium",  Constants.EpitheliumTissueRef, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
			initProperty(bioMightTransform.getName(), Constants.EpitheliumTissue, Constants.EpitheliumTissueRef, epithelium.getComponentID());

			/*int viewPerspective = Constants.VIEW_DETACHED;
			if (viewPerspective == Constants.VIEW_DETACHED)
			{				
				// Create the components of the curvature

			}*/
		}
		
		initProperties();
		initMethods();
		
		System.out.println("CreatePituitaryGland Completed");
		
		// First, get all the data from the database
		// Apply the methods to it
		// Save its state
		this.parentID = parentID;
		if (bioMightMethods != null){
			System.out.println("EXECUTING PituitaryGland METHODS: " + bioMightMethods.size());
			//executeMethods(bioMightMethods);
		}
	}
	
	
	/****************************************************************************
	 * GENERATE PITUITARY GLAND
	 * 
	 * @param parentID
	 * @param componentID
	 ***************************************************************************/
	
	public void generate(String parentID, String componentID)
	{
		// Generate the PituitaryGland Epithelium		
		BioMightBeanLocal bioMightBean;
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Generating the PituitaryGland ParentID: " + parentID);
			InitialContext ctx = new InitialContext();
			bioMightBean = (BioMightBeanLocal) ctx.lookup("java:global/BioMightWeb/BioMightBean!biomight.ejb.BioMightBeanLocal");
	
			double circumference = 0.125;
		
			// Generate the PituitaryGland
			//  seven sections
			double[] startPos = {0.0, 0.85, -2.75};
			
			// Create a equilateral octogon
			double x =  startPos[0];
			double y =  startPos[1];
			double z =  startPos[2];

			double[][] currentPoints = BioGraphics.octogonYPlane(startPos, circumference);	
			
			int success = bioMightBean.generatePituitaryGland("PituitaryGlandEpithelium:00001", "PituitaryGlandEpithelium", 
				"PituitaryGlandEpithelium", componentID, parentID, currentPoints);			
	
				
			System.out.println("Created PituitaryGlandEpithelium Info using EJB");   	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - PituitaryGlandEpithelium");
			throw new ServerException("Remote Exception getComponents():", e); 	
		}
	}
	
	

	
	public void initProperties() {
	
		BioMightScale bioScale = new BioMightScale("0.00, 0.00, 0.00");
		BioMightPosition bioPos = new BioMightPosition("0.00, 0.00, 0.00");	
		String bioTemplate =""; 

		initProperty("----Not Available---", Constants.Title, Constants.Title, "AdrenalGland:0", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		initProperty(Constants.AdenoHypophysisRef, Constants.AdenoHypophysis, Constants.AdenoHypophysisRef, "PituitaryGland:0", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		initProperty(Constants.NeuroHypophysisRef, Constants.NeuroHypophysis, Constants.NeuroHypophysisRef, "PituitaryGland:0", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		initProperty(Constants.HypophysealVeinRef, Constants.HypophysealVein, Constants.HypophysealVeinRef, "PituitaryGland:0", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
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
		 "<meta name='BioMightImage' content='PituitaryGland.jpg'/>\n" +
		 "<meta name='ExportTime' content='7:45:30'/>\n" +
		 "<meta name='ExportDate' content='08/15/2008'/>\n" +
		 "<meta name='BioMight Version' content='1.0'/>\n" + 
		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='PituitaryGland'\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		

		String body = epithelium.getX3D(true);  
		//System.out.println("PituitaryGland X3D: " + body);		
		
		body+= "<Viewpoint DEF='Viewpoint_PituitaryGland'\n" +
				 "description='Viewpoint1'\n" +
				 "jump='true'\n" +
				 "fieldOfView='0.785'\n" +
				 "position='0.0 00.0 5.0'\n" +
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
		 "<meta name='BioMightImage' content='PituitaryGland .jpg'/>\n" +
		 "<meta name='ExportTime' content='7:45:30'/>\n" +
		 "<meta name='ExportDate' content='08/15/2008'/>\n" +
		 "<meta name='BioMight Version' content='1.0'/>\n" + 
		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='PituitaryGland '\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		


		String body = "";
		
		// Run through the collection of PituitaryGland  and build them into the model
		// In the default case, we get one instance of the PituitaryGland  for each Stomach
		ArrayList transforms = bioMightTransforms.getTransforms();
		for (int i=0; i<transforms.size(); i++)
		{
			// Get the information for the PituitaryGland we are creating
			BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
			System.out.println("Getting PituitaryGland X3D: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
		
			int view = Constants.VIEW_FLOATING;
			if (view == Constants.VIEW_FLOATING)
			{
				//System.out.println("Getting X3D for PituitaryGland X: " + bioMightSphere.getTranslation().getXPos());
				//System.out.println("Getting X3D for PituitaryGland Y: " + bioMightSphere.getTranslation().getYPos());
				//System.out.println("Getting X3D for PituitaryGland Z: " + bioMightSphere.getTranslation().getZPos());
				// Change the height and width based on the displacement.
				body += "<Transform DEF='PituitaryGland '\n" +
		 			"translation='" + bioMightTransform.getTranslation().getXPos() + " " 
			 					+ bioMightTransform.getTranslation().getYPos() + " "
			 					+ bioMightTransform.getTranslation().getZPos() + "'\n" +
			 		"scale='" 	+ bioMightTransform.getScale().getXPos() + " "
			 				+ bioMightTransform.getScale().getYPos() + " "
			 				+ bioMightTransform.getScale().getZPos() + "'>\n" +
					"<Shape DEF='PituitaryGland Shape'\n" +
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
						 	"<IndexedFaceSet DEF='PituitaryGland IFS' \n" +
						    	   "containerField='geometry' \n" +
						    	   "creaseAngle='" +  bioMightTransform.getCreaseAngle() + "'\n" +
						    	   "coordIndex='" + bioMightTransform.getCoordindexStr() + "'>" +
						    	   "<Coordinate DEF='PituitaryGland _Coord' \n" +
						    	    "containerField='coord' point='" +  bioMightTransform.getCoordpointStr() + "'/>" +
						    	  "</IndexedFaceSet>\n" +
					"</Shape>\n" +
			 "</Transform>\n";
		}
		else
		{
			body = "";//						
		}
		
		}
		
		body+= "<Viewpoint DEF='Viewpoint_PituitaryGland'\n" +
				 "description='Viewpoint1'\n" +
				 "jump='true'\n" +
				 "fieldOfView='0.785'\n" +
				 "position='0.0 -8.0 3.0'\n" +
				 "orientation='0 0 1 0'/>\n";
		
		
		//System.out.println("PituitaryGland X3D: " + body);		
		String footer = "</Scene>" + "</X3D>\n";
		
		if (snipet)
			return body;			
		else	
			return header + body + footer;
	}	



}
