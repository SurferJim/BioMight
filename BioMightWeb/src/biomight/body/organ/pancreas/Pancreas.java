/*
 * Created on Apr 24, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.body.organ.pancreas;

import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.naming.InitialContext;









import biomight.Constants;
import biomight.cell.neuronglial.*;
import biomight.cell.misc.*;
import biomight.cell.neuron.*;
import biomight.cell.secreting.*;
import biomight.system.tissue.edothelial.EndotheliumTissue;
import biomight.system.tissue.epithelial.EpitheliumTissue;
import biomight.system.vascular.arteries.*;
import biomight.system.vascular.arteries.abdomen.*;
import biomight.system.vascular.veins.*;
import biomight.system.vascular.veins.abdomen.*;
import biomight.util.BioGraphics;
import biomight.view.BioMightMethodView;
import biomight.view.BioMightPolygons;
import biomight.view.BioMightPosition;
import biomight.view.BioMightPropertyView;
import biomight.view.BioMightScale;
import biomight.view.BioMightTransform;
import biomight.view.BioMightTransforms;
import biomight.chemistry.misc.*;
import biomight.chemistry.secretion.*;
import biomight.ejb.BioMightBeanLocal;
import biomight.ejb.BioMightVascularBeanLocal;
import biomight.exceptions.DataSecurityException;
import biomight.exceptions.ServerException;
import biomight.body.organ.CysticDuct;
import biomight.body.organ.Organ;
import biomightweb.util.BioWebUtils;




/**
 * @author SurferJim
 *
 * The pancreas is a compound racemose gland, analogous in its structures to the salivary glands, 
 * though softer and less compactly arranged than those organs. Its secretion, the pancreatic juice, 
 * carried by the pancreatic duct to the duodenum, is an important digestive fluid. The pancreas has 
 * an important internal secretion, probably elaborated by the cells of Langerhans, which is taken 
 * up by the blood stream and is concerned with sugar metabolism. It is long and irregularly 
 * prismatic in shape; its right extremity, being broad, is called the head, and is connected to 
 * the main portion of the organ, or body, by a slight constriction, the neck; while its left 
 * extremity gradually tapers to form the tail. It is situated transversely across the posterior 
 * wall of the abdomen, at the Pancreas of the epigastric and left hypochondriac 
 * regions. Its length varies from 12.5 to 15 cm., and its weight from 60 to 100 gm.
 * 
 */

public class Pancreas extends Organ {
	private String componentID = "";
	private BioMightTransforms bioMightTransforms;
	private ArrayList<BioMightPropertyView> properties;
	private ArrayList<BioMightMethodView> methods;
	protected EndotheliumTissue endothelium;
	protected EpitheliumTissue epithelium;
	
	
	// Pancreas Parts
	private PancreasHead pancreasHead;
	private PancreasBody pancreasBody;
	private PancreasNeck pancreasNeck;
	private PancreasTail pancreasTail;
	
	// Surfaces
	private PancreasPosteriorSurface pancreasPosteriorSurface;
	private PancreasInferiorSurface pancreasInferiorSurface;
	
	// Borders
	private PancreasAnteriorBorder pancreasAnteriorBorder;
	private PancreasInferiorBorder pancreasInferiorBorder;
	private PancreasSuperiorBorder pancreasSuperiorBorder;
	
	private Acini acini;
	private BasketCell basketCell;
	private AcinarCell acinarCell;
	private IntralobularDuct intralobularDuct;
	private PancreaticDucts pancreaticDucts;
	private AccessoryPancreaticDuct accessoryPancreaticDuct;
	private IsletsOfLangerhans isletsOfLangerhans;
	
	// Arteries
	private PancreaticoDuodenalArteries pancreaticoDuodenalArteries;
	private PancreaticoDuodenalVeins pancreaticoDuodenalVeins;

	private IsosmoticFluid isosmoticFluid;

	
	/*********************************************************************************
	 * CONSTRUCTORS
	 *
	 *********************************************************************************/
	
	public Pancreas()
	{
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, Constants.PancreasRef, null, null);
	}

	public Pancreas(String parentID)
	{
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, parentID, null, null);
	}

	public Pancreas(int hierarchy, int LOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
	{
		System.out.print("Calling Pancreas Create");
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

		this.setImage("images/Pancreas.jpg");
		this.setImageHeight(300);
		this.setImageWidth(300);

		// Get the information from the database via the Enterprise Bean		
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Getting PancreasInfo for ParentID: " + parentID);
			InitialContext ctx = new InitialContext();
			BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
			bioMightTransforms = bioMightBean.getComponents(Constants.PancreasRef, parentID);
			System.out.println("Have Pancreas Info from EJB");   	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - Pancreas");
			throw new ServerException("Remote Exception getComponents():", e); 	
		}
	
		properties = new ArrayList<BioMightPropertyView>();
		
		int localVP = Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;

		BioMightScale bioScale = new BioMightScale("0.00, 0.00, 0.00");
		BioMightPosition  bioPos = new BioMightPosition("0.00, 0.00, 0.00");
		String bioTemplate="Bacterias.x3d";
		
		// Run through Pancreas and build them into the model
		ArrayList transforms = bioMightTransforms.getTransforms();
		System.out.println("Pancreas NumTransforms: " + transforms.size());
		for (int i=0; i<transforms.size(); i++)
		{
			// Get the information for the Pancreas we are creating
			BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
			System.out.println("Creating Pancreas (name,id): " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
			componentID = bioMightTransform.getId();
					
			/*
			pancreasHead = new PancreasHead(bioMightTransform.getId(), null));
			pancreasBody = new PancreasBody(bioMightTransform.getId(), null));
			pancreasNeck = new PancreasNeck(bioMightTransform.getId(), null));
			pancreasTail = new PancreasTail(bioMightTransform.getId(), null));
			intralobularDuct = new IntralobularDuct(bioMightTransform.getId(), null));
			pancreaticDuct = new PancreaticDuct(bioMightTransform.getId(), null));
			isletsOfLangerhans = new IsletsOfLangerhans(bioMightTransform.getId(), null));
			*/
		
			
			// Generate the Liver Epihelium if needed 
			boolean bGenerate = false;
			if (bGenerate) {
				generate(parentID, componentID);
			}
	
			
			//System.out.println("Creating Pancreas Endothelium: " + bioMightTransform.getId());				
			//endothelium = new EndotheliumTissue("PancreasEndothelium", bioMightTransform.getId(), bioMightMethods);
			//initProperty("PancreasEndothelium", Constants.EndotheliumTissue, Constants.EndotheliumTissueRef, endothelium.getComponentID());
	
			String startID = "PancreasEpithelium:00001";
			System.out.println("Creating Pancreas Epithelium: " + bioMightTransform.getId());				
			epithelium = new EpitheliumTissue(localVP, localLOD, startID, "PancreasEpithelium",  Constants.EpitheliumTissueRef, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
			initProperty("PancreasEpithelium", "PancreasEpithelium", Constants.EpitheliumTissueRef, epithelium.getComponentID(), bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);					
		
			System.out.println("Creating the PancreaticDuct for parent: " + bioMightTransform.getId());
			pancreaticDucts = new PancreaticDucts(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
			initProperty(Constants.PancreaticDuctsRef, Constants.PancreaticDucts, Constants.PancreaticDuctsRef, pancreaticDucts.getComponentID(), bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
			System.out.println("Created the PancreaticDuct");	

			System.out.println("Creating the AccessoryPancreaticDuct for parent: " + bioMightTransform.getId());
			accessoryPancreaticDuct = new AccessoryPancreaticDuct(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
			initProperty(Constants.AccessoryPancreaticDuctRef, Constants.AccessoryPancreaticDuct, Constants.AccessoryPancreaticDuctRef, accessoryPancreaticDuct.getComponentID(), bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
			System.out.println("Created the AccessoryPancreaticDuct");	
		
			System.out.println("Pancreas completed");			
		}			
		//initProperties();
		initMethods();
	}
	
	
	
	/****************************************************
	 * GENERATE PANCREAS
	 * 
	 * 
	 * @param parentID
	 * @param componentID
	 ***************************************************/
	
	public void generate(String parentID, String componentID)
	{
		// Generate the Liver Edothelium		
		BioMightBeanLocal bioMightBean;
		try {
			// Get the information from the database via the Enterprise Bean			
			System.out.println("Generating the Pancreas: " + componentID + "    " + parentID);
			InitialContext ctx = new InitialContext();
			bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
	
			double radius = 0.0025;

		
			if (componentID.equals("Pancreas:01")) 
			{	
				// Generate the GreaterCurvature of the stomach
				// Create 5 sections
				double[] startPos = {-2.25, -25.0, -5.10};
				double[][] currentPoints = BioGraphics.createCylinderInPlane(Constants.YPLANE, startPos, radius, 8);
	
				System.out.println("Calling Generate Pancreas: " + componentID + "    " + parentID);
				int success = bioMightBean.generatePancreas("PancreasEpithelium:00001", "PancreasEpithelium", 
					"PancreasEpithelium", componentID, parentID, currentPoints);			
			}			
			else if (parentID.equals("")) 
			{	
					
			}

			
			System.out.println("Created PancreasEpithelium Info using EJB");   	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - PancreasEpithelium");
			throw new ServerException("Remote Exception getComponents():", e); 	
		}
	}
	
	
	

	protected void initProperty(String componentName, String canonicalName, String componentRef, String componentID) {
		BioMightPropertyView property = new BioMightPropertyView();
		property.setPropertyName(componentName);
		property.setCanonicalName(canonicalName);
		property.setPropertyRef(componentRef);
		property.setPropertyID(componentID);
		properties.add(property);
	}
	
	
	public void initProperties() {

		properties = new ArrayList<BioMightPropertyView>();
		
		BioMightPropertyView property = new BioMightPropertyView();
		property.setPropertyName("Acini");
		property.setCanonicalName(Constants.Acini);
		properties.add(property);
	
		property = new BioMightPropertyView();
		property.setPropertyName("Basket Cell");
		property.setCanonicalName(Constants.BasketCell);
		properties.add(property);		

		property = new BioMightPropertyView();
		property.setPropertyName("Acinar Cell");
		property.setCanonicalName(Constants.AcinarCell);
		properties.add(property);	
		
		property = new BioMightPropertyView();
		property.setPropertyName("Intralobular Duct");
		property.setCanonicalName(Constants.IntralobularDuct);
		properties.add(property);	
		
		property = new BioMightPropertyView();
		property.setPropertyName("Pancreatic Duct");
		property.setCanonicalName(Constants.PancreaticDuct);
		properties.add(property);	
		
		property = new BioMightPropertyView();
		property.setPropertyName("Islets Of Langerhans");
		property.setCanonicalName(Constants.IsletsOfLangerhans);
		properties.add(property);	
		
		property = new BioMightPropertyView();
		property.setPropertyName("PancreaticoDuodenal Arteries");
		property.setCanonicalName(Constants.PancreaticoDuodenalArteries);
		properties.add(property);	
		
		property = new BioMightPropertyView();
		property.setPropertyName("PancreaticoDuodenal Veins");
		property.setCanonicalName(Constants.PancreaticoDuodenalVeins);
		properties.add(property);	
		
		property = new BioMightPropertyView();
		property.setPropertyName("Isosmotic Fluid");
		property.setCanonicalName(Constants.IsosmoticFluid);
		properties.add(property);	
		
	}
	
	
	public void initMethods() {

		methods = new ArrayList<BioMightMethodView>();
		
		BioMightMethodView method = new BioMightMethodView();

		method = new BioMightMethodView();
		method.setMethodName("ExcreteIsmoticFluid");
		method.setHtmlType("text");
		methods.add(method);	
		
		method = new BioMightMethodView();
		method.setMethodName("setGlycogenLevel");
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
		
		// Assemble the Pancreas Endothelium
		String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
		"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n " +
		"<X3D profile='Immersive' >\n" +
		"<head>\n" +
		 "<meta name='BioMightImage' content='PancreasEndothelium.jpg'/>\n" +
		 "<meta name='ExportTime' content='7:45:30'/>\n" +
		 "<meta name='ExportDate' content='08/15/2016'/>\n" +
		 "<meta name='BioMight Version' content='1.0'/>\n" + 
		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='PancreasEndothelium'\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		

		String body = epithelium.getX3D(true) + 
					  pancreaticDucts.getX3D(true) +
				      accessoryPancreaticDuct.getX3D(true); 		
		//System.out.println("Pancreas X3D: " + body);		

		body+= "<Viewpoint DEF='Viewpoint_Pancreas'\n" +
				 "description='Viewpoint1'\n" +
				 "jump='true'\n" +
				 "fieldOfView='0.785'\n" +
				 "position='0.0 -21.0 20.0'\n" +
				 "orientation='0 0 1 0'/>\n";

		
		String footer = "</Scene>" + "</X3D>\n";
		
		if (snipet)
			return body;			
		else	
			return header + body + footer;
	}
	
	
		

	public String getX3DExternal(boolean snipet) {
		
		// Assemble the Pancreas
		String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
		"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n " +
		"<X3D profile='Immersive' >\n" +
		"<head>\n" +
		 "<meta name='BioMightImage' content='Pancreas.jpg'/>\n" +
		 "<meta name='ExportTime' content='7:45:30'/>\n" +
		 "<meta name='ExportDate' content='08/15/2008'/>\n" +
		 "<meta name='BioMight Version' content='1.0'/>\n" + 
		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='Pancreas'\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		

		String body = 
		pancreasHead.getX3D(true) +  
		pancreasBody.getX3D(true) + 
		pancreasNeck.getX3D(true) + 
		pancreasTail.getX3D(true) + 
		intralobularDuct.getX3D(true) + 
		pancreaticDucts.getX3D(true) + 
		isletsOfLangerhans.getX3D(true);		
		
		// We should do this on detached view only
		body+= "<Viewpoint DEF='Viewpoint_Pancreas'\n" +
				 "description='Viewpoint1'\n" +
				 "jump='true'\n" +
				 "fieldOfView='0.785'\n" +
				 "position='0.0 -22.0 20.0'\n" +
				 "orientation='0 0 1 0'/>\n";
		
		//System.out.println("Pancreas X3D: " + body);		
		
		String footer = "</Scene>" + "</X3D>\n";
		
		if (snipet)
			return body;			
		else	
			return header + body + footer;
	}
	
	
	public void setBileLevel()
	{
	}
	
	public void ExcreteIsmoticFluid()
	{
		
	}

	public void setGlycogenLevel()
	{
	}
	
	public void setPlasmaProteinSynthesis()
	{	
	}


	public AcinarCell getAcinarCell() {
		return acinarCell;
	}


	public void setAcinarCell(AcinarCell acinarCell) {
		this.acinarCell = acinarCell;
	}


	public Acini getAcini() {
		return acini;
	}


	public void setAcini(Acini acini) {
		this.acini = acini;
	}


	public BasketCell getBasketCell() {
		return basketCell;
	}


	public void setBasketCell(BasketCell basketCell) {
		this.basketCell = basketCell;
	}


	public IntralobularDuct getIntralobularDuct() {
		return intralobularDuct;
	}


	public void setIntralobularDuct(IntralobularDuct intralobularDuct) {
		this.intralobularDuct = intralobularDuct;
	}


	public IsletsOfLangerhans getIsletsOfLangerhans() {
		return isletsOfLangerhans;
	}


	public void setIsletsOfLangerhans(IsletsOfLangerhans isletsOfLangerhans) {
		this.isletsOfLangerhans = isletsOfLangerhans;
	}


	public IsosmoticFluid getIsosmoticFluid() {
		return isosmoticFluid;
	}


	public void setIsosmoticFluid(IsosmoticFluid isosmoticFluid) {
		this.isosmoticFluid = isosmoticFluid;
	}


	public PancreaticoDuodenalArteries getPancreaticoDuodenalArteries() {
		return pancreaticoDuodenalArteries;
	}


	public void setPancreaticoDuodenalArteries(
			PancreaticoDuodenalArteries pancreaticoDuodenalArteries) {
		this.pancreaticoDuodenalArteries = pancreaticoDuodenalArteries;
	}


	public PancreaticoDuodenalVeins getPancreaticoDuodenalVeins() {
		return pancreaticoDuodenalVeins;
	}


	public void setPancreaticoDuodenalVeins(
			PancreaticoDuodenalVeins pancreaticoDuodenalVeins) {
		this.pancreaticoDuodenalVeins = pancreaticoDuodenalVeins;
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

	public String getComponentID() {
		return componentID;
	}

	public void setComponentID(String componentID) {
		this.componentID = componentID;
	}
	
}


