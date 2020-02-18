/*
 * Created on Feb 10, 2007
 *
 * Representation of Systems
 * 
 */

package biomight.system;
import java.util.ArrayList;

import javax.naming.InitialContext;

import biomight.BioMightBase;
import biomight.Constants;
import biomight.body.organ.kidney.Ureters;
import biomight.ejb.BioMightBeanLocal;
import biomight.exceptions.ServerException;
import biomight.view.BioMightGenerate;
import biomight.view.BioMightMethodView;
import biomight.view.BioMightPosition;
import biomight.view.BioMightPropertyView;
import biomight.view.BioMightScale;
import biomight.view.BioMightTransform;
import biomightweb.util.BioWebUtils;


public class BioMightSystems extends BioMightBase {
	private ArrayList colors;
	private DigestiveSystem digestiveSystem;
	private RespiratorySystem respiratorySystem;
	private UrinarySystem urinarySystem;
	private ReproductiveSystem reproductiveSystem;
	private NervousSystem nervousSystem;
	private SkeletalSystem skeletalSystem;
	private MuscularSystem muscularSystem;	
	private ExecretorySystem execretorySystem;
	private ImmuneSystem immuneSystem;
	private IntegumentarySystem integumentarySystem;
	private CirculatorySystem circulatorySystem;
	private LigamentSystem ligamentSystem;
	private LymphaticSystem lymphaticSystem;	
	private EndocrineSystem endocrineSystem;
	private BioMightTransform gBioMightTransform; 	
	private TissueSystem tissueSystem;
	
	
	/************************************************************************
	 * BioMightSystems Constructor 
	 *
	 ***********************************************************************/
	public BioMightSystems()
	{
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, "0", null, null);
	}

	/************************************************************************
	 * BioMightSystems Constructor 
	 *
	 ***********************************************************************/
	public BioMightSystems(String parentID)
	{
		System.out.println("Calling parameterized BioMightSystems Constructor!");
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, parentID, null, null);
	}

	
	/************************************************************************
	 * BioMightSystems Constructor 
	 *
	 ***********************************************************************/
	public BioMightSystems(String parentID, ArrayList<BioMightMethodView> bioMightMethods)
	{
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, parentID, null, bioMightMethods);
	}
	
	
	/************************************************************************
	 * BioMightSystems Constructor 
	 *
	 ***********************************************************************/
	public BioMightSystems(int localVP, int localLOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
	{
		create(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);
	}
	
	
	/************************************************************************
	 * Create BioMightSystems
	 *
	 ***********************************************************************/
	public void create(int localVP, int localLOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
	{
		this.setImage("images/BioMightSystem.jpg");
		this.setImageHeight(300);
		this.setImageWidth(300);
			
		// Get the data for the BioMightSystem that is defined for this 
		// BioMightSystem reference
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Getting BioMightSystemsInfo for ParentID: " + parentID);
			InitialContext ctx = new InitialContext();
			BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
			bioMightTransforms = bioMightBean.getComponents(Constants.BioMightSystemsRef, parentID);
			System.out.println("Have BioMightSystems Info from EJB");   	
		}
		catch (Exception e) { 
			System.out.println("Exception Getting Components - BioMightSystems");
			throw new ServerException("Remote Exception getComponents():", e); 	
		}
		
		//String bioPos = "0.00, 0.00, 0.00";
		BioMightScale bioScale = new BioMightScale("0.00, 0.00, 0.00");
		BioMightPosition bioPos = new BioMightPosition("0.00, 0.00, 0.00");
		String bioTemplate="BioMightSystems.x3d";
	
		// Run through the collection of Bodys and build them into the model
		// In the default case, we get one instance of the Body for each eye
		ArrayList transforms = bioMightTransforms.getTransforms();
		System.out.println("Have BioMightSystems, NumTransforms: " + transforms.size());

		// There will be only 1 instance of the BioMightSystems Library in the database
		boolean bStored = false;
		for (int i=0; i<transforms.size(); i++)
		{
			// Get the information for the eye we are creating
			BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
			componentID = bioMightTransform.getId();
			System.out.println("Creating BioMightSystems: " + bioMightTransform.getName() + "  " + bioMightTransform.getId() + "  "+ componentID);
	
			// Get the Properties that the user set in the page last time we were in	
			// We will use the enable flag to see what should be turned on/off
			if (bioMightProperties == null ||bioMightProperties.size() == 0)
			{
				try {
					// Get the information from the database via the Enterprise Bean		
					//System.out.println("Getting Property info for DigestiveSystem: " + bioMightTransform.getId());
					InitialContext ctx = new InitialContext();
					BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
					// overwrite the structure that was passed in, as they are empty
					bioMightProperties = bioMightBean.getComponentProps(bioMightTransform.getId());
					//System.out.println("Have BioMightSystems Property Info from EJB - NumProps: " + bioMightProperties.size());   	
				}catch (Exception e) { 
					System.out.println("Exception Getting Components Properties - BioMightSystems");
					throw new ServerException("Remote Exception getComponents():", e); 	
				} 

				//System.out.println("BioMightSystems: Using Properties from Datastore");
				bStored = true;
			}
			else
			{
				//System.out.println("DigestiveSystem - Using LocalProperties...");
			}
			//System.out.println("DigestiveSystem - PropertiesSize: " + bioMightProperties.size());
		

			int viewpoint = Constants.VIEW_HAWKEYE;
			if (viewpoint == Constants.VIEW_HAWKEYE)
			{
				//String dimensions = "0.00, 0.00, 0.00";
								
				if (BioWebUtils.isViewEnabled(Constants.DigestiveSystemRef, bioMightProperties)) {	
					System.out.println("In Systems View - Creating DigestiveSystem");		
					digestiveSystem = new DigestiveSystem(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
					System.out.println("In BioMightSystems - DigestiveSystem is complete");
					initProperty(Constants.DigestiveSystemRef, Constants.DigestiveSystem, Constants.DigestiveSystemRef, digestiveSystem.getComponentID(), bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, true);
				}
				else
					initProperty(Constants.DigestiveSystemRef, Constants.DigestiveSystem, Constants.DigestiveSystemRef, BioWebUtils.getPropertyID(Constants.DigestiveSystemRef, bioMightProperties), bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);								

				if (BioWebUtils.isViewEnabled(Constants.RespiratorySystemRef, bioMightProperties)) {	
					System.out.println("In Systems View - Creating RespiratorySystem");		
					respiratorySystem = new RespiratorySystem(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
					System.out.println("In BioMightSystems - RespiratorySystem is complete");
					initProperty(Constants.RespiratorySystemRef, Constants.RespiratorySystem, Constants.RespiratorySystemRef, respiratorySystem.getComponentID(), bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, true);						
				}
				else
					initProperty(Constants.RespiratorySystemRef, Constants.RespiratorySystem, Constants.RespiratorySystemRef, BioWebUtils.getPropertyID(Constants.RespiratorySystemRef, bioMightProperties), bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);						
		
				if (BioWebUtils.isViewEnabled(Constants.MuscularSystemRef, bioMightProperties)) {	
					System.out.println("In Systems View - Creating MuscularSystem");		
					muscularSystem = new MuscularSystem(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
					System.out.println("In BioMightSystems - MuscularSystem is complete");
					initProperty(Constants.MuscularSystemRef, Constants.MuscularSystem, Constants.MuscularSystemRef, muscularSystem.getComponentID(), bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, true);						
				}
				else
					initProperty(Constants.MuscularSystemRef, Constants.MuscularSystem, Constants.MuscularSystemRef, BioWebUtils.getPropertyID(Constants.MuscularSystemRef, bioMightProperties), bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);						
		
				if (BioWebUtils.isViewEnabled(Constants.SkeletalSystemRef, bioMightProperties)) {	
					System.out.println("In Systems View - Creating SkeletalSystem");		
					skeletalSystem = new SkeletalSystem(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
					System.out.println("In BioMightSystems - SkeletalSystem is complete");
					initProperty(Constants.SkeletalSystemRef, Constants.SkeletalSystem, Constants.SkeletalSystemRef, skeletalSystem.getComponentID(), bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, true);						
				}
				else
					initProperty(Constants.SkeletalSystemRef, Constants.SkeletalSystem, Constants.SkeletalSystemRef, BioWebUtils.getPropertyID(Constants.SkeletalSystemRef, bioMightProperties), bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);						
		
				if (BioWebUtils.isViewEnabled(Constants.CirculatorySystemRef, bioMightProperties)) {	
					System.out.println("In Systems View - Creating CirculatorySystem");		
					circulatorySystem = new CirculatorySystem(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
					System.out.println("In BioMightSystems - CirculatorySystem is complete");
					initProperty(Constants.CirculatorySystemRef, Constants.CirculatorySystem, Constants.CirculatorySystemRef, circulatorySystem.getComponentID(), bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, true);						
				}
				else
					initProperty(Constants.CirculatorySystemRef, Constants.CirculatorySystem, Constants.CirculatorySystemRef, BioWebUtils.getPropertyID(Constants.CirculatorySystemRef, bioMightProperties), bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);						
					
				if (BioWebUtils.isViewEnabled(Constants.TissueSystemRef, bioMightProperties)) {	
					System.out.println("In Systems View - Creating TissueSystem");		
					tissueSystem = new TissueSystem(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
					System.out.println("In BioMightSystems - TissueSystem is complete");
					initProperty(Constants.TissueSystemRef, Constants.TissueSystem, Constants.TissueSystemRef, tissueSystem.getComponentID(), bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, true);						
				}
				else
					initProperty(Constants.TissueSystemRef, Constants.TissueSystem, Constants.TissueSystemRef, BioWebUtils.getPropertyID(Constants.TissueSystemRef, bioMightProperties), bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);						
				
				
				//System.out.println("In Systems View - Creating ImmuneSystem");		
				//immuneSystem = new ImmuneSystem(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
				//System.out.println("In BioMightSystems - ImmuneSystem is complete");
				//initProperty(Constants.ImmuneSystemRef, Constants.ImmuneSystem, Constants.ImmuneSystemRef, immuneSystem.getComponentID(), bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
		
				//System.out.println("In Systems View - Creating NervousSystem");		
				//nervousSystem = new NervousSystem(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
				//System.out.println("In BioMightSystems - NervousSystem is complete");
				//initProperty(Constants.NervousSystemRef, Constants.NervousSystem, Constants.NervousSystemRef, nervousSystem.getComponentID(), bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, BioWebUtils.isViewEnabled(Constants.NervousSystemRef, localBioMightProperties));						
		
				//System.out.println("In Systems View - Creating LigamentSystem");		
				//ligamentSystem = new LigamentSystem(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
				//System.out.println("In BioMightSystems - NervousSystem is complete");
				//initProperty(Constants.LigamentSystemRef, Constants.LigamentSystem, Constants.LigamentSystemRef, ligamentSystem.getComponentID(), bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, BioWebUtils.isViewEnabled(Constants.LigamentSystemRef, localBioMightProperties));						
		
		
				/*******
				private UrinarySystem urinarySystem;
				private ReproductiveSystem reproductiveSystem;
				private ExecretorySystem execretorySystem;
				private IntegumentarySystem integumentarySystem;
				private CirculatorySystem circulatorySystem;
				private LigamentSystem ligamentSystem;
				private LymphaticSystem lymphaticSystem;	
				private EndocrineSystem endocrineSystem; 	
				******/
			}
			
			
			// Store the new set of properties based on the init Property methods called above	
			// This means the user set properties
			if (properties != null && !bStored) {
				if (properties.size()>0) {
				// Store the Properties that the user set in the page	
				// We will use the enable flag to see what should be turned on/off
					try {
						// Get the information from the database via the Enterprise Bean		
						//System.out.println("Setting Property info for BioMightSystems: " + bioMightTransform.getId());
						InitialContext ctx = new InitialContext();
						BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
						int propSave = bioMightBean.insertComponentProps(bioMightTransform.getId(),
								Constants.BioMightSystemsRef, bioMightTransform.getComponentName(), properties);      
						//System.out.println("Stored BioMightSystems Property Info into EJB: " + propSave);   	
					}catch (Exception e) { 
						System.out.println("Exception Storing Components Properties - BioMightSystems");
						throw new ServerException("Remote Exception insertComponentProps():", e); 	
					} 
				}
			}
		}
		
		
		//System.out.println("Init Properties");	
		initProperties();
		//System.out.println("Init Methods");
		initMethods();
		System.out.println("Created BioMightSystems (Library View)");				
	}
	
	
	
	public void initProperties() {

		BioMightScale bioScale = new BioMightScale("0.00, 0.00, 0.00");
		BioMightPosition bioPos = new BioMightPosition("0.00, 0.00, 0.00");	
		String bioTemplate =""; 

		initProperty("---Not Activated---", Constants.Title, Constants.Title, parentID, bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		initProperty(Constants.UrinarySystemRef, Constants.UrinarySystem, Constants.UrinarySystemRef, componentID, bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		initProperty(Constants.NervousSystemRef, Constants.NervousSystem, Constants.NervousSystemRef, componentID, bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		initProperty(Constants.ExecretorySystemRef, Constants.ExecretorySystem, Constants.ExecretorySystemRef, componentID, bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		initProperty(Constants.ImmuneSystemRef, Constants.ImmuneSystem, Constants.ImmuneSystemRef, componentID, bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		initProperty(Constants.IntegumentarySystemRef, Constants.IntegumentarySystem, Constants.IntegumentarySystemRef, componentID, bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		initProperty(Constants.LigamentSystemRef, Constants.LigamentSystem, Constants.LigamentSystemRef, componentID, bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		initProperty(Constants.LymphaticSystemRef, Constants.LymphaticSystem, Constants.LymphaticSystemRef, componentID, bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		initProperty(Constants.EndocrineSystemRef, Constants.EndocrineSystem, Constants.EndocrineSystemRef, componentID, bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		initProperty(Constants.ReproductiveSystemRef, Constants.ReproductiveSystem, Constants.ReproductiveSystemRef, componentID, bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
	}
	

	public void initMethods() {
			
		BioMightMethodView method = method = new BioMightMethodView();
		
		method.setDisplayName("Metabolize");
		method.setMethodName("Metabolize");
		method.setHtmlType("checkbox");
		method.setDataType("boolean");
		methods.add(method);		
	}
	
	

	/********************************************************************************************************************
	 * GET X3D
	 * 
	 * This method will return the X3D for the BioMightSystems.  It runs through each of its components and collects up their
	 * representations and then assembles them into one unified X3D model.
	 * 
	 ********************************************************************************************************************/
	public String getX3D(boolean snipet) {
		
		// Assemble the Systems
		String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
		"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.03.dtd\">\n " +
		"<X3D profile='Immersive' >\n" +
		"<head>\n" +
		 "<meta name='BioMightImage' content='BioMightSystems.jpg'/>\n" +
		 "<meta name='ExportTime' content='7:45:30'/>\n" +
		 "<meta name='ExportDate' content='08/15/2008'/>\n" +
		 "<meta name='BioMight Version' content='1.0'/>\n" + 
		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='BioMightSystems'\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		

		String body = ""; 		
		int viewpoint = Constants.VIEW_HAWKEYE;
		if (viewpoint == Constants.VIEW_INTERNAL)
		{
			double xPos = 0.0;
			double yPos = 0.0;
			double zPos = 0.0;
			
			double xScale = 1.0;
			double yScale = 1.0;
			double zScale = 1.0;
			
			
			String bioSystems[] = {
					"DigestiveSystem",
					"RespiratorySystem",
					"UrinarySystem", 
					"ReproductiveSystem",
					"NervousSystem",
					"SkeletalSystem",
					"MuscularSystem",
					"ExecretorySystem",
					"ImmuneSystem",
					"ImmuneSystem",
					"IntegumentarySystem",
					"CirculatorySystem",
					"LigamentSystem",
					"LymphaticSystem",
					"EndocrineSystem"
			};
			

			
			for (int i=0; i<bioSystems.length; i++)
			{
				System.out.println("Creating X3D for : " + bioSystems[i]);				
				
				// Change the height and width based on the displacement.
				body += "\n<Transform DEF='" + bioSystems[i] + "'\n";
						
			 	body += "translation='" 
			 			+ xPos + " " 
 						+ (yPos - i) + " "
 						+ zPos + "'\n";					
				
				System.out.println("Set Translation: ");				

				body +=  "scale='" 	+ xScale + " "
				 					+ yScale + " "
				 					+ zScale + "'>\n" +
	
				 "\n<Shape DEF='" + bioSystems[i] + "Shape'\n" +
				    " containerField='children'>\n" +
				    " <Appearance\n" +
				    "  containerField='appearance'>\n";

			
				body+= " <ImageTexture containerField='texture' " +
				    " url='../images/" + bioSystems[i] + ".jpg'/>";
					
				    
				body+= " <Material DEF='Rust'\n" +
				    "containerField='material'\n" +
				    "ambientIntensity='" 	+ gBioMightTransform.getMaterial().getAmbientIntensity() + "'\n" +
				    "shininess='" 			+ gBioMightTransform.getMaterial().getShininess() + "'\n" +
				    "transparency='" 		+ gBioMightTransform.getMaterial().getTransparency() + "'\n" +
				    "diffuseColor='" + 
				 	    gBioMightTransform.getMaterial().getDiffuseColor().getRed() + " " + 
				 	    gBioMightTransform.getMaterial().getDiffuseColor().getGreen() + " " +
				 	    gBioMightTransform.getMaterial().getDiffuseColor().getBlue() + "'/>\n" +
				 	"</Appearance>\n" +
				 	"<Sphere DEF='" + bioSystems[i] + "Sphere'\n" +
				 	"containerField='geometry'\n" +
				 	"radius='" + gBioMightTransform.getRadius() +"'/>\n" +
				 	"</Shape>\n" +
				 	
					"\n<TouchSensor DEF='"+bioSystems[i]+"Touch' \n" +
	                   " description='"+bioSystems[i]+"'\n" +
		               " containerField='children'/> \n" +
	
				 "</Transform>\n";
						
				System.out.println("Set Transform: ");				

			}
	
			
		}
		else  if (viewpoint == Constants.VIEW_HAWKEYE)
		{
			// We could create an 1 instance of each BioMightSystem types by passing in the
			// numElements into the Create method.  Or we can just make a represention of
			// each cell type.
			   
					if (BioWebUtils.isViewEnabled(Constants.CirculatorySystemRef, properties)) 
						body += circulatorySystem.getX3D(true);
					if (BioWebUtils.isViewEnabled(Constants.DigestiveSystemRef, properties)) 
						body += digestiveSystem.getX3D(true);
					if (BioWebUtils.isViewEnabled(Constants.RespiratorySystemRef, properties)) 
						body += respiratorySystem.getX3D(true);					
					if (BioWebUtils.isViewEnabled(Constants.MuscularSystemRef, properties)) 
						body += muscularSystem.getX3D(true);
					if (BioWebUtils.isViewEnabled(Constants.NervousSystemRef, properties)) 
						body += nervousSystem.getX3D(true);
					if (BioWebUtils.isViewEnabled(Constants.SkeletalSystemRef, properties)) 
						body += skeletalSystem.getX3D(true);
					if (BioWebUtils.isViewEnabled(Constants.TissueSystemRef, properties)) 
						body += tissueSystem.getX3D(true);
					//body +=immuneSystem.getX3D(true);
					
			System.out.println("BioMightSystem HAWKEYE X3D!");
		}
		
		
		//System.out.println("BioMightSystem Collection X3D: " + body);
		String footer = "</Scene>" + "</X3D>\n";
		
		body+= "<Viewpoint DEF='Viewpoint_PoxVirus'\n" +
				 "description='Viewpoint1'\n" +
				 "jump='true'\n" +
				 "fieldOfView='0.785'\n" +
				 "position='0.0 0.0 15.0'\n" +
				 "orientation='0 0 1 0'/>\n";
		
		
		if (snipet)
			return body;			
		else	
			return header + body + footer;
	}


}
