/*
 * Created on Jul 7, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.body.head.mouth.tongue;
import java.util.ArrayList;

import javax.naming.InitialContext;

import biomight.BioMightBase;
import biomight.Constants;
import biomight.ejb.BioMightBeanLocal;
import biomight.exceptions.ServerException;
import biomight.system.muscular.head.mouth.tongue.InferiorLongitudinalMuscle;
import biomight.system.muscular.head.mouth.tongue.SuperiorLongitudinalMuscle;
import biomight.system.muscular.head.mouth.tongue.TransversusMuscle;
import biomight.system.tissue.epithelial.EpitheliumTissue;
import biomight.util.BioGraphics;
import biomight.view.BioMightMethodView;
import biomight.view.BioMightPosition;
import biomight.view.BioMightPropertyView;
import biomight.view.BioMightScale;
import biomight.view.BioMightSphere;
import biomight.view.BioMightTransform;
import biomight.view.BioMightTransforms;


/***********************************************************************
 * @autthor SurferJim
 * 
 *  Representation of a Tongue
 *
 **********************************************************************/

public class Tongue extends BioMightBase {
	protected EpitheliumTissue epithelium;
	private FungiformPapillae fungiformPapillae;
	private FiliformPapillae filiformPapillae;
	private FoliatePapillae foliatePapillae;
	private CircumvallatePapillae circumvallatePapillae;
	private TasteBuds tasteBuds;
	
	// Muscles
	private SuperiorLongitudinalMuscle superiorLongitudinalMuscle;
	private InferiorLongitudinalMuscle inferiorLongitudinalMuscle;
	private TransversusMuscle transversusMuscle;
	
	private static final String CONTACT = "";
	String messageType = "";
	

	public Tongue()
	{
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, Constants.TongueRef, null, null);
	}

	public Tongue(String parentID)
	{
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, parentID, null, null);
	}

	public Tongue(int hierarchy, int LOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
	{
		System.out.print("Calling Tongue Create");
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
		setImage("images/Tongue.jpg");
		setImageHeight(300);
		setImageWidth(300);

		
		// Get the information from the database via the Enterprise Bean		
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Getting TongueInfo for ParentID: " + parentID);
			InitialContext ctx = new InitialContext();
			BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
			bioMightTransforms = bioMightBean.getComponents(Constants.TongueRef, parentID);
			System.out.println("Have Tongue Info from EJB");   	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - Tongue");
			throw new ServerException("Remote Exception getComponents():", e); 	
		}
		
		int localVP = Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		
		// Run through the collection of Pupils and build them into the model
		// In the default case, we get one instance of the Pupil for each eye
		ArrayList transforms = bioMightTransforms.getTransforms();
		System.out.println("Have Tongue NumTransforms: " + transforms.size());
		for (int i=0; i<transforms.size(); i++)
		{
			// Get the information for the eye we are creating
			BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
			System.out.println("Creating Tongue (name,id): " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
			componentID = bioMightTransform.getId();
			
			if (localVP == Constants.VIEW_HAWKEYE)
			{
				// Generate the Tongue Epihelium if needed 
				boolean bGenerate = false;
				if (bGenerate) {
					generate(parentID, componentID);
				}
			
				String startID = "TongueEpithelium:00001";
				System.out.println("HawkEye - Creating Tongue Epithelium: " + parentID + "  startID: " + startID);				
				epithelium = new EpitheliumTissue(localVP, localLOD, startID, "TongueEpithelium",  Constants.EpitheliumTissueRef, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
				initProperty("TongueEpithelium", Constants.EpitheliumTissue, Constants.EpitheliumTissueRef, bioMightTransform.getId());
						
			}
			else if (localVP == Constants.VIEW_FLOATING)
			{
				fungiformPapillae = new FungiformPapillae(bioMightTransform.getId(), bioMightMethods);
				initProperty("FungiformPapillae", Constants.FungiformPapillae, Constants.FungiformPapillaeRef, bioMightTransform.getId());
				System.out.println("Created FungiformPapillae");

				filiformPapillae = new FiliformPapillae(bioMightTransform.getId(), bioMightMethods);
				initProperty("FiliformPapillae", Constants.FiliformPapillae, Constants.FiliformPapillaeRef, bioMightTransform.getId());
				System.out.println("Created FiliformPapillae");

				foliatePapillae = new FoliatePapillae(bioMightTransform.getId(), bioMightMethods);
				initProperty("FoliatePapillae", Constants.FoliatePapillae, Constants.FoliatePapillaeRef, bioMightTransform.getId());
				System.out.println("Created FoliatePapillae");

				circumvallatePapillae = new CircumvallatePapillae(bioMightTransform.getId(), bioMightMethods);
				initProperty("FungiformPapillae", Constants.CircumvallatePapillae, Constants.CircumvallatePapillaeRef, bioMightTransform.getId());
				System.out.println("Created CircumvallatePapillae");
				
				System.out.println("Created Tongue");	
			}
			else
			{
				//teeth = new  Teeth();
				//tongue = new  Tongue();
				//salivaryGlands = new  SalivaryGlands();
			}	
		}		
	
		//initProperties();
		initMethods();
		System.out.println("Created Tongue");
	}
	
	
	/************************************************************************************
	 * GENERATE
	 * 
	 * @param parentID
	 * @param componentID
	 **********************************************************************************/
	
	public void generate(String parentID, String componentID)
	{
		// Generate the Tongue Edothelium		
		BioMightBeanLocal bioMightBean;
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Generating the Tongue: " + componentID + "    " + parentID);
			InitialContext ctx = new InitialContext();
			bioMightBean = (BioMightBeanLocal) ctx.lookup("java:global/BioMightWeb/BioMightBean!biomight.ejb.BioMightBeanLocal");
	
			double circumference = 0.0125;
		
			if (componentID.equals("Tongue:01")) 
			{	
				// Create 5 sections
				double[] startPos = {0.0, -3.5, -0.5};
				double[][] currentPoints = BioGraphics.octogonZPlane(startPos, circumference);

				System.out.println("Calling Generate Tongue: " + componentID + "    " + parentID);
				int success = bioMightBean.generateTongue("TongueEpithelium:00001", "TongueEpithelium", 
					"TongueEpithelium", componentID, parentID, currentPoints);									
		
			}			
			else if (parentID.equals("")) 
			{	
					
			}

			
			System.out.println("Created TongueEpithelium Info using EJB");   	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - TongueEpithelium");
			throw new ServerException("Remote Exception getComponents():", e); 	
		}
	}
	
	
	
	public void initProperties() {
	
		BioMightScale bioScale = new BioMightScale("0.00, 0.00, 0.00");
		BioMightPosition bioPos = new BioMightPosition("0.00, 0.00, 0.00");	
		String bioTemplate =""; 

		initProperty("---Not Activated---", Constants.Title, Constants.Title, "ParaThyroidGland:0", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		initProperty(Constants.RhombencephalonRef, Constants.Rhombencephalon, Constants.RhombencephalonRef, "Tongue:01", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);

		BioMightPropertyView property = new BioMightPropertyView();
		property.setPropertyName("Taste Buds");
		property.setCanonicalName(Constants.TasteBuds);
		properties.add(property);
	
		property = new BioMightPropertyView();
		property.setPropertyName("SuperiorLongitudinalMuscle");
		property.setCanonicalName(Constants.SuperiorLongitudinalMuscle);
		properties.add(property);				

		property = new BioMightPropertyView();
		property.setPropertyName("InferiorLongitudinalMuscle");
		property.setCanonicalName(Constants.InferiorLongitudinalMuscle);
		properties.add(property);		

		property = new BioMightPropertyView();
		property.setPropertyName("TransversusMuscle");
		property.setCanonicalName(Constants.TransversusMuscle);
		properties.add(property);

	}
	

	public void initMethods() {
		BioMightMethodView method;

		method = new BioMightMethodView();
		method.setMethodName("Reproduce");
		method.setHtmlType("checkbox");
		methods.add(method);	
		
		method = new BioMightMethodView();
		method.setMethodName("Mate");
		method.setHtmlType("text");
		methods.add(method);	

		method = new BioMightMethodView();
		method.setMethodName("Lyse");
		method.setHtmlType("text");
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
		
		// Assembe the Head
		String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
		"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n " +
		"<X3D profile='Immersive' >\n" +
		"<head>\n" +
		 "<meta name='BioMightImage' content='Tongue.jpg'/>\n" +
		 "<meta name='ExportTime' content='7:45:30'/>\n" +
		 "<meta name='ExportDate' content='08/15/2008'/>\n" +
		 "<meta name='BioMight Version' content='1.0'/>\n" + 
		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='Tongue'\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		

		String body = "";
		
		viewPerspective = Constants.VIEW_HAWKEYE;
		if (viewPerspective == Constants.VIEW_HAWKEYE) {
			System.out.println("Getting Tonguue X3D - HawkEye");
			body = epithelium.getX3D(true); 
		}
		else {
			System.out.println("Getting Tongue X3D - MAG 2X");
			body = fungiformPapillae.getX3D(true) + 
					  filiformPapillae.getX3D(true) +
					  foliatePapillae.getX3D(true) +
					  circumvallatePapillae.getX3D(true);
		}
		
		String footer = "</Scene>" + "</X3D>\n";
		
		if (snipet)
			return body;			
		else	
			return header + body + footer;
	}	


	public void onMessage(String messageType)
	{
		
		// Something is touching the tounge.  The nerves in the tounge
		// will send a message to the Brain and ----- cells will release
		// solvents.
		if (messageType.equals("CHEW"))
		{
			// Send a message to the brain
			
			// Start Digestion
		}

		// Flip the tounge to move the food into the
		// ready to swallow position
		if (messageType.equals("SWALLOW"))
		{
			// Send a message to the object to
			// reposition it in the model.
			// sendMessage();
		}		


		// Carry out messages delivered from the brain
		if (messageType.equals("SPIT"))
		{
			// Send a message to the brain
			// Start Digestion 
		}		


		// Carry out messages delivered from the brain
		if (messageType.equals("EXPOSE TONGUE"))
		{
			// Send a message to the brain
			// Start Digestion 
		}	
			
	}

	public void Ingest()
	{
		// This is the first step of digestion, 
		// placing food in one's Tongue
	}

	public void Chew()
	{
		// Mastication
	}


	public void Salivate()
	{
		
	}


}
