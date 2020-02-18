/*
 * Created on Feb 11, 2007
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.system.tissue;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;

import biomight.BioMightBase;
import biomight.Constants;
import biomight.ejb.BioMightBeanLocal;
import biomight.exceptions.ServerException;
import biomight.system.tissue.connective.AdiposeTissue;
import biomight.system.tissue.connective.AreolarConnectiveTissue;
import biomight.system.tissue.connective.ConnectiveTissue;
import biomight.system.tissue.connective.DenseConnectiveTissue;
import biomight.system.tissue.connective.ExtraCellularMatrix;
import biomight.system.tissue.connective.FibrousConnectiveTissue;
import biomight.system.tissue.connective.GallBladderConnectiveTissue;
import biomight.system.tissue.connective.LaminaPropriaTissue;
import biomight.system.tissue.connective.LooseConnectiveTissue;
import biomight.system.tissue.connective.ReticularConnectiveTissue;
import biomight.system.tissue.connective.blood.Blood;
import biomight.system.tissue.connective.bone.BoneTissue;
import biomight.system.tissue.edothelial.EndotheliumTissue;
import biomight.system.tissue.epithelial.EpitheliumTissue;
import biomight.system.tissue.epithelial.PseudoStratifiedEpithelialTissue;
import biomight.system.tissue.epithelial.RespiratoryEpitheliumTissue;
import biomight.system.tissue.epithelial.RespiratoryMucosa;
import biomight.system.tissue.epithelial.SimpleEpithelialTissue;
import biomight.system.tissue.epithelial.StratifiedEpithelialTissue;
import biomight.system.tissue.epithelial.TransitionalEpitheliumTissue;
import biomight.system.tissue.fibers.ElasticFibers;
import biomight.view.BioMightConstruct;
import biomight.view.BioMightMethodView;
import biomight.view.BioMightPosition;
import biomight.view.BioMightPropertyView;
import biomight.view.BioMightScale;
import biomight.view.BioMightTransform;


/**
 * @author SurferJim
 *
 *  This is a collection of the various tissues in the human body
 */

public class Tissues extends BioMightBase {
	private ArrayList colors;

	private Blood blood;
	private BoneTissue bone;
	private EpitheliumTissue epitheliumTissue;
	private EndotheliumTissue endotheliumTissue; 
	private ConnectiveTissue connectiveTissue;
	
	private AreolarTissue areolarTissue;
	private ElasticFibers elasticFibers;
	private AdiposeTissue adiposeTissue;
	private AreolarConnectiveTissue areolarConnectiveTissue;
	private DenseConnectiveTissue denseConnectiveTissue;
	private ExtraCellularMatrix extraCellularMatrix;
	private FibrousConnectiveTissue fibrousConnectiveTissue;
	private GallBladderConnectiveTissue gallBladderConnectiveTissue;
	private LaminaPropriaTissue laminaPropriaTissue;
	private LooseConnectiveTissue looseConnectiveTissue;
	private ReticularConnectiveTissue reticularConnectiveTissue;
	private PseudoStratifiedEpithelialTissue pseudoStratifiedEpithelialTissue;
	private RespiratoryEpitheliumTissue respiratoryEpitheliumTissue;
	private RespiratoryMucosa respiratoryMucosa;
	private SimpleEpithelialTissue simpleEpithelialTissue;
	private StratifiedEpithelialTissue stratifiedEpithelialTissue;
	private TransitionalEpitheliumTissue transitionalEpitheliumTissue;

	
	/************************************************************************
	 * Tissues Constructor 
	 *
	 ***********************************************************************/
	public Tissues()
	{
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, Constants.TissuesRef, null, null);
	}

	/************************************************************************
	 * Tissues Constructor 
	 *
	 ***********************************************************************/
	public Tissues(String parentID)
	{
		System.out.print("Calling parameterized Tissues Constructor!");
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, parentID, null, null);
	}
	
	
	/************************************************************************
	 * Tissues Constructor 
	 *
	 ***********************************************************************/
	public Tissues(int hierarchy, int LOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
	{
		System.out.println("Calling Tissues with LOD!");
		create(hierarchy, LOD, parentID, bioMightProperties, bioMightMethods);
	}
	
	
	/************************************************************************
	 * Create Tissues
	 *
	 ***********************************************************************/

	public void create(int hierarchy, int LOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
	{
		this.setImage("images/Tissue.jpg");
		this.setImageHeight(300);
		this.setImageWidth(300);

		System.out.println("Creating Tissue for: " + parentID);
		// Get the data for the Tissue that is defined for this 
		// Tissue reference
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Getting TissuesInfo for ParentID: " + parentID);
			Context ctx = new InitialContext(); 
			BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
			bioMightTransforms = bioMightBean.getComponents(Constants.TissuesRef, parentID);
			System.out.println("Have Tissues Info from EJB");   	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - Tissues");
			throw new ServerException("Remote Exception getComponents():", e); 	
		}

		// If we have initialization parameters from the form, 
		//  then apply them before constructing the objects.
		if (bioMightMethods != null){
			System.out.println("NEED TO EXECUTE CELL METHODS: " + bioMightMethods.size());
			//executeMethods(bioMightMethods);
		}

		
		// Run through the collection of Bodys and build them into the model
		// In the default case, we get one instance of the Body for each eye
		ArrayList transforms = bioMightTransforms.getTransforms();
		System.out.println("Have Tissue NumTransforms: " + transforms.size());

		// There will be one instance of the Tissues class that serves as a collection
		// for the children tissues that are created here
		//String dimensions = "0.00, 0.00, 0.00";
		//String bioPos = "0.00, 0.00, 0.00";
		BioMightScale bioScale = new BioMightScale("0.00, 0.00, 0.00");
		BioMightPosition bioPos = new BioMightPosition("0.00, 0.00, 0.00");

		String bioTemplate="Tissue.x3d";

		int localVP = Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
	
		for (int i=0; i<transforms.size(); i++)
		{
			// Get the information for the eye we are creating
			BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
		
			componentID = bioMightTransform.getId();
			System.out.println("Creating Tissues Collection - ComponentID: " + componentID);
			
			System.out.println("Creating Tissue: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
			System.out.println("Creating Tissue at Position: " + bioMightTransform.getTranslation().getXPos() + ",  " + 
					bioMightTransform.getTranslation().getYPos() + ",  " +
					bioMightTransform.getTranslation().getZPos());
			
			System.out.println("In Tissue - Creating Epithelium Tissue");
			String startID="EpitheliumTissue:00001";
			BioMightConstruct bioConstruct = null;
			epitheliumTissue = new EpitheliumTissue(startID, Constants.EpitheliumTissueRef,  Constants.EpitheliumTissueRef, parentID, bioConstruct, bioMightMethods);
			System.out.println("In Tissue - EpitheliumTissue is complete");
			initProperty("EpitheliumTissue", Constants.EpitheliumTissue, Constants.EpitheliumTissueRef, epitheliumTissue.getComponentID(), bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
			
			System.out.println("In Tissue - Creating Endothelium Tissue");
			endotheliumTissue = new EndotheliumTissue(bioMightTransform.getId(), bioMightMethods);
			System.out.println("In Tissue - Endothelium Tissue is complete");
			initProperty("EndotheliumTissue", Constants.EndotheliumTissue, Constants.EndotheliumTissueRef, endotheliumTissue.getComponentID(), bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);

			System.out.println("In Tissue - Creating Blood Tissue");
			blood = new Blood("Blood", localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
			System.out.println("In Tissue - Blood is complete");
			initProperty("Blood", Constants.Blood, Constants.BloodRef, "Tissues:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
	
			System.out.println("In Tissue - Creating Bone Tissue");
			bone = new BoneTissue("BoneTissue", bioMightTransform.getId(), bioMightMethods);
			System.out.println("In Tissue - Bone is complete");
			initProperty("Bone", Constants.BoneTissue, Constants.BoneTissueRef, bone.getComponentID(), bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
			
			System.out.println("In Tissue - Creating Connective Tissue");
			connectiveTissue = new ConnectiveTissue("ConnectiveTissue", bioMightTransform.getId(), bioMightProperties, bioMightMethods);
			System.out.println("In Tissue - Connective Tissue is complete");
			initProperty("ConnectiveTissue", Constants.ConnectiveTissue, Constants.ConnectiveTissueRef, connectiveTissue.getComponentID(), bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
	
			System.out.println("In Tissue - Creating Adipose Tissue");
			adiposeTissue = new AdiposeTissue("AdiposeTissue", bioMightTransform.getId(), bioMightMethods);
			System.out.println("In Tissue - Adipose Tissue is complete");
			initProperty("AdiposeTissue", Constants.AdiposeTissue, Constants.AdiposeTissueRef, adiposeTissue.getComponentID(), bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
						
		}
		
		System.out.println("Init Properties");	
		initProperties();
		System.out.println("Init Methods");
		initMethods();
		System.out.println("Created Tissue");				
	}


	public void initProperties() {
		
		BioMightPropertyView property;
		
		property = new BioMightPropertyView();
		property.setPropertyName("AreolarTissue");
		property.setCanonicalName(Constants.AreolarTissue);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("AdiposeTissue");
		property.setCanonicalName(Constants.AdiposeTissue);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("AreolarConnectiveTissue");
		property.setCanonicalName(Constants.AreolarConnectiveTissue);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("Blood");
		property.setCanonicalName(Constants.Blood);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("DenseConnectiveTissue");
		property.setCanonicalName(Constants.DenseConnectiveTissue);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("FibrousConnectiveTissue");
		property.setCanonicalName(Constants.FibrousConnectiveTissue);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("GallBladderConnectiveTissue");
		property.setCanonicalName(Constants.GallBladderConnectiveTissue);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("LaminaPropriaTissue");
		property.setCanonicalName(Constants.LaminaPropriaTissue);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("LooseConnectiveTissue");
		property.setCanonicalName(Constants.LooseConnectiveTissue);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("ReticularConnectiveTissue");
		property.setCanonicalName(Constants.ReticularConnectiveTissue);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("EpitheliumTissue");
		property.setCanonicalName(Constants.EpitheliumTissue);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("StratifiedEpithelialTissue");
		property.setCanonicalName(Constants.StratifiedEpithelialTissue);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("TransitionalEpitheliumTissue");
		property.setCanonicalName(Constants.TransitionalEpitheliumTissue);
		properties.add(property);	
	}
	

	public void initMethods() {
		BioMightMethodView method;
		methods = new ArrayList<BioMightMethodView>();
		method = new BioMightMethodView();
		method.setDisplayName("Metabolize");
		method.setMethodName("Metabolize");
		method.setHtmlType("checkbox");
		method.setDataType("boolean");
		methods.add(method);

	}
	

	/********************************************************************************************************************
	 * GET X3D
	 * 
	 * This method will return the X3D for the Tissues.  It runs through each of its components and collects up their
	 * representations and then assembles them into one unified X3D model.
	 * 
	 ********************************************************************************************************************/
	public String getX3D(boolean snipet) {
		
		// Assemble the Tissues
		String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
		
		"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n " +
		"<X3D profile='Immersive' >\n" +
		"<head>\n" +
		 "<meta name='BioMightImage' content='Tissues.jpg'/>\n" +
		 "<meta name='ExportTime' content='7:45:30'/>\n" +
		 "<meta name='ExportDate' content='08/15/2008'/>\n" +

		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='Tissues'\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		
		
		String body = 
			epitheliumTissue.getX3D(true) + 
			endotheliumTissue.getX3D(true) +
			blood.getX3D(true) +
			bone.getX3D(true) +
			connectiveTissue.getX3D(true) +
			adiposeTissue.getX3D(true);
		
		System.out.println("Tissue Collection X3D: " + body);
		
		
		String footer = "</Scene>" + "</X3D>\n";
		
		if (snipet)
			return body;			
		else	
			return header + body + footer;
	}
	
}
