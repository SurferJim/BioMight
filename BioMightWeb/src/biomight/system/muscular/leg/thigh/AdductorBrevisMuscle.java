/*
 * Created on May 13, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.system.muscular.leg.thigh;
import biomight.system.tissue.muscle.Muscle; 
import java.util.ArrayList; 
import javax.naming.InitialContext;
import biomight.Constants;
import biomight.ejb.BioMightBeanLocal;
import biomight.ejb.BioMightMuscularBeanLocal;
import biomight.exceptions.ServerException;
import biomight.system.tissue.muscle.MuscleTissue;
import biomight.util.BioGraphics;
import biomight.view.BioMightMethodView;
import biomight.view.BioMightPosition;
import biomight.view.BioMightPropertyView;
import biomight.view.BioMightScale;
import biomight.view.BioMightTransform;
import biomight.view.BioMightTransforms;

/*****************************************************************
 * @author SurferJim
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
/*************************************************************
 * AdductorBrevis Muscle
 * @author SurferJim
 *
 * Representation of the AdductorBrevisMuscle
 ************************************************************/

public class AdductorBrevisMuscle extends Muscle {
	protected MuscleTissue muscleTissue;
	
	
	/******************************************************************************
	 * CONSTRUCTUORS
	 *****************************************************************************/

	public AdductorBrevisMuscle()
	{
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, Constants.AdductorBrevisMuscleRef, null, null);
	}

	public AdductorBrevisMuscle(String parentID)
	{
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, parentID, null, null);
	}
	public AdductorBrevisMuscle(String parentID, ArrayList<BioMightMethodView> bioMightMethods)
	{
		int localVP = Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, parentID, null, bioMightMethods);
	}
	
	public AdductorBrevisMuscle(int localVP, int localLOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
	{
		create(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);
	}
	
	/*****************************************************************************
	 * CREATE
	 * 
	 * Create an instance of the AdductorBrevisMuscle
	 * 
	 * @param parentID
	 * @param bioMightMethods
	 ****************************************************************************/
	
	public void create(int localVP, int localLOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
	{
		this.setImage("images/AdductorBrevisMuscle.jpg");
		this.setImageHeight(300);
		this.setImageWidth(300);
		this.lod = localLOD;
		this.viewPerspective = localVP;
		
		BioMightScale bioScale = new BioMightScale("0.00, 0.00, 0.00");
		BioMightPosition  bioPos = new BioMightPosition("0.00, 0.00, 0.00");
		String bioTemplate="AdductorBrevisMuscle.x3d";
			
		//this.parentID = parentID;
		if (bioMightMethods != null){
			System.out.println("EXECUTING AdductorBrevisMuscle METHODS: " + bioMightMethods.size());
			//executeMethods(bioMightMethods);
		}

		// Build the model based on what you are looking based on LOD
		componentID = parentID;
		if (localVP == Constants.VIEW_INTERNAL)
		{	
			System.out.println("Getting the AdductorBrevisMuscle - VIEW_INTERNAL : " + parentID);
			
			// Do the Epithelial layer
			localLOD = Constants.MAG2X;
			
			if (localLOD == Constants.MAG2X)
			{
				// Go get the finer details of the Kidney				
				System.out.println("Getting the AdductorBrevisMuscle MAG2X : " + parentID);
				localVP = Constants.VIEW_INTERNAL; 
				localLOD = Constants.MAG1X;		
	
				System.out.println("Calling generate AdductorBrevisMuscle Osteocytes: " + parentID);	
				// Generate
				boolean bGenerate = false;
				if (bGenerate) {
					generate(parentID, componentID);
				}
			
				// Create the tissue for the muscle
				System.out.println("Creating AdductorBrevisMuscleTissue: " +  parentID);				
				muscleTissue = new MuscleTissue("AdductorBrevisMuscleTissue", parentID, bioMightMethods);
				initProperty("AdductorBrevisMuscleTissue", Constants.MuscleTissue, Constants.MuscleTissueRef, muscleTissue.getComponentID());
				System.out.println("AdductorBrevisMuscle MuscleTissue is created : " + parentID);		

			}
		}
		else if (localVP == Constants.VIEW_HAWKEYE)
		{			
			// Get the information from the database via the Enterprise Bean		
			try {
				// Get the information from the database via the Enterprise Bean		
				System.out.println("Getting AdductorBrevisMuscleInfo for ParentID: " + parentID);
				InitialContext ctx = new InitialContext();
				BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
				bioMightTransforms = bioMightBean.getComponents(Constants.AdductorBrevisMuscleRef, parentID);
				System.out.println("Have AdductorBrevisMuscle Info from EJB");   	
			}catch (Exception e) { 
				System.out.println("Exception Getting Components - AdductorBrevisMuscle");
				throw new ServerException("Remote Exception getComponents():", e); 	
			}
				
			// Run through the collection of AdductorBrevisMuscles and build them into the model
			// In the default case, we get one instance of the AdductorBrevisMuscle for each eye
			ArrayList transforms = bioMightTransforms.getTransforms();
			System.out.println("AdductorBrevisMuscle NumTransforms: " + transforms.size());
			for (int i=0; i<transforms.size(); i++)
			{
				// Get the information for the eye we are creating
				BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
				System.out.println("Created AdductorBrevisMuscle: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
				this.componentID = bioMightTransform.getId();
				
				// Generate the Endothelium if needed 
				boolean bGenerate = false;
				if (bGenerate) {
					generate(parentID, componentID);
				}
				
				// Create the tissue for the muscle
				System.out.println("Creating AdductorBrevisMuscleTissue Objects: " +  componentID);				
				muscleTissue = new MuscleTissue("AdductorBrevisMuscleTissue", componentID, bioMightMethods);
				initProperty("AdductorBrevisMuscleTissue", Constants.MuscleTissue, Constants.MuscleTissueRef, muscleTissue.getComponentID());
				System.out.println("AdductorBrevisMuscle MuscleTissue is created : " + componentID);		
			
				localVP = Constants.VIEW_HAWKEYE;;
				localLOD = Constants.MAG1X;

				//System.out.println("Creating the TrochanterHead for ParentID: " + bioMightTransform.getId());
				//trochanterHead = new TrochanterHead(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
				//initProperty("TrochanterHead", Constants.TrochanterHead, Constants.TrochanterHeadRef, trochanterHead.getComponentID());
				//System.out.println("Created the TrochanterHead");
	
			}
		}
		
		//initProperties();
		initMethods();
		
		System.out.println("CreateAdductorBrevisMuscle Completed");
		
		// First, get all the data from the database
		// Apply the methods to it
		// Save its state
		}

		
	
	/**********************************************************************
	 * GENERATE 
	 * 
	 * @param parentID
	 * @param componentID
	 ********************************************************************/
	
	public void generate(String parentID, String componentID)
	{
		// Generate the AdductorBrevisMuscle Epithelium		
		BioMightMuscularBeanLocal bioMightBean;
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Generating the AdductorBrevisMuscle ParentID: " + parentID + "  compID: " + componentID);
			InitialContext ctx = new InitialContext();
			bioMightBean = (BioMightMuscularBeanLocal) ctx.lookup(Constants.MuscularBeanRef); 
	
			double radius = 0.25;
		
		// Left AdductorBrevis
		 if (componentID.equals("AdductorBrevisMuscle:01")) 
			{	
				// Generate the AdductorBrevisMuscle
				//  seven sections
				double[] startPos = {1.25, -31.0, -4.75};
				double[][] currentPoints = BioGraphics.createCylinderInPlane(Constants.YPLANE, startPos, radius, 8);

				int success = bioMightBean.generateAdductorBrevisMuscle("AdductorBrevisMuscleTissue:00001", "AdductorBrevisMuscleTissue", 
					"AdductorBrevisMuscleTissue", componentID, parentID, currentPoints);			
		}
		// Right AdductorBrevis
		else  if (componentID.equals("AdductorBrevisMuscle:02")) 
		{	
			// Generate the GallBladder
			double[] startPos = {-1.25, -31.0, -4.75};
	    	double[][] currentPoints =  BioGraphics.createCylinderInPlane(Constants.YPLANE, startPos, radius, 8);
	      		
			int success = bioMightBean.generateAdductorBrevisMuscle("AdductorBrevisMuscleTissue:00640", "AdductorBrevisMuscleTissue", 
					"AdductorBrevisMuscleTissue", componentID, parentID, currentPoints);			
		}
		
			
			System.out.println("Created AdductorBrevisMuscleTissue Info using EJB");   	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - AdductorBrevisMuscleTissue");
			throw new ServerException("Remote Exception getComponents():", e); 	
		}
	}


	/*****************************************
	 * INITIALIZE METHODS
	 * 
	 ****************************************/
	
	public void initProperties() {

		properties = new ArrayList<BioMightPropertyView>();
		
		BioMightPropertyView property = new BioMightPropertyView();
		property.setPropertyName("Muscle Tissue");
		property.setCanonicalName(Constants.MuscleTissue);
		properties.add(property);
				
		property = new BioMightPropertyView();
		property.setPropertyName("Veins");
		property.setCanonicalName(Constants.Vein);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("Arteries");
		property.setCanonicalName(Constants.Artery);
		properties.add(property);
	}
	
	
	/*****************************************
	 * INITIALIZE METHODS
	 * 
	 ****************************************/
	public void initMethods() {

		methods = new ArrayList<BioMightMethodView>();
		
		BioMightMethodView method = new BioMightMethodView();

		method = new BioMightMethodView();
		method.setMethodName("Expand");
		method.setHtmlType("checkbox");
		methods.add(method);	
		
		method = new BioMightMethodView();
		method.setMethodName("Constrict");
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
	 * This method will return the X3D for the AdductorBrevisMuscle.  It runs through each of its 
	 * components and collects up their representations and then assembles them into one unified X3D model.
	 * 
	 ********************************************************************************************************************/
	
	
	public String getX3D(boolean snipet) {
		
		// Assemble the Greater Curvature
		String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
		"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n " +
		"<X3D profile='Immersive' >\n" +
		"<head>\n" +
		 "<meta name='BioMightImage' content='AdductorBrevisMuscle.jpg'/>\n" +
		 "<meta name='ExportTime' content='7:45:30'/>\n" +
		 "<meta name='ExportDate' content='08/15/2008'/>\n" +
		 "<meta name='BioMight Version' content='1.0'/>\n" + 
		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='AdductorBrevisMuscle'\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		

	
		String body = "";
		if (viewPerspective == Constants.VIEW_HAWKEYE) {
			body = muscleTissue.getX3D(true);
		}
		else if (viewPerspective == Constants.VIEW_INTERNAL) 
		{		
			body = muscleTissue.getX3D(true);
		}
		else
		{
			body = "";						
		}	
			
		
		//System.out.println("AdductorBrevisMuscle X3D: " + body);		
		String footer = "</Scene>" + "</X3D>\n";
		
		if (snipet)
			return body;			
		else	
			return header + body + footer;
		}
	
	
}
