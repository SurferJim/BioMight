/*
 * Created on Apr 24, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.body.gland.gallbladder;
import java.util.ArrayList;

import javax.naming.InitialContext;

import biomight.Constants;
import biomight.cell.epithelial.columnar.simple.*;
import biomight.ejb.BioMightBeanLocal;
import biomight.exceptions.ServerException;
import biomight.system.vascular.arteries.abdomen.*;
import biomight.system.vascular.veins.abdomen.*;
import biomight.system.tissue.connective.*;
import biomight.system.tissue.edothelial.EndotheliumTissue;
import biomight.system.tissue.epithelial.EpitheliumTissue;
import biomight.util.BioGraphics;
import biomight.view.BioMightMethodView;
import biomight.view.BioMightPropertyView;
import biomight.view.BioMightTransform;
import biomight.view.BioMightTransforms;
import biomight.body.organ.CysticDuct;
import biomight.body.organ.Organ;


/**
 * @author SurferJim
 *
 *  The gall-bladder is a conical or pear-shaped musculomembranous sac, lodged in a fossa on the under 
 *  surface of the right lobe of the GallBladder, and extending from near the right extremity of the porta to 
 *  the anterior border of the organ. It is from 7 to 10 cm. in length, 2.5 cm. in breadth at its widest 
 *  part, and holds from 30 to 35 c.c. It is divided into a fundus, body, and neck.
 *
 */

public class GallBladder extends Organ {
	private EpitheliumTissue epithelium;

	// External Body of Gall Bladder
	private GallBladderFundus gallBladderFundus;
	private GallBladderBody gallBladderBody;
	private GallBladderNeck gallBladderNeck;

	// Coats
	private GallBladderSerousCoat gallBladderSerousCoat;
	private GallBladderFibroMuscularCoat gallBladderFibroMuscularCoat;
	private GallBladderMucousCoat gallBladderMucousCoat;
	
	private SimpleColumnarNonCiliatedEpithelialCells columnarSimpleNonCiliatedEpithelialCells;
	
	private CysticDuct cysticDuct;
	private CysticArtery cysticArtery;
	private CysticVein cysticVein;
	private GallBladderConnectiveTissue gallBladderConnectiveTissue;
	private AschoffsRecesses aschoffsRecesses;
	//private SmootheMuscle smootheMuscle
	
	
	
	/*********************************************************************************
	 * CONSTRUCTORS
	 *
	 *********************************************************************************/
	
	public GallBladder()
	{
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, Constants.GallBladderRef, null, null);
	}

	public GallBladder(String parentID)
	{
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, parentID, null, null);
	}

	public GallBladder(int vp, int LOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
	{
		System.out.print("Calling GallBladder Create");
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
		this.setImage("images/GallBladder.jpg");
				
	
		// Get the information from the database via the Enterprise Bean		
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Getting GallBladderInfo for ParentID: " + parentID);
			InitialContext ctx = new InitialContext();
			BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
			bioMightTransforms = bioMightBean.getComponents(Constants.GallBladderRef, parentID);
			System.out.println("Have GallBladder Info from EJB");   	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - GallBladder");
			throw new ServerException("Remote Exception getComponents():", e); 	
		}
		
		int localVP = Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
	
		// Run through GallBladder and build its components into the model
		ArrayList transforms = bioMightTransforms.getTransforms();
		System.out.println("Gall Bladder NumTransforms: " + transforms.size());
		for (int i=0; i<transforms.size(); i++)
		{
			// Get the information for the GallBladder we are creating
			BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
			System.out.println("Have GallBladder (name,id): " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
			componentID=bioMightTransform.getId();
	
			// Build the model based on what you are looking based on LOD
			viewPerspective = Constants.VIEW_HAWKEYE;
			if (viewPerspective == Constants.VIEW_HAWKEYE)
			{			
				// Generate the GallBladder Epithelium if needed 
				boolean bGenerate = false;
				if (bGenerate) {
					generate(parentID, componentID);
				}
			
				
				String startID = "GallBladderEpithelium:00001";
				System.out.println("HawkEye - Creating GallBladder Epithelium: " + parentID + "  startID: " + startID);				
				epithelium = new EpitheliumTissue(localVP, localLOD, startID, "GallBladderEpithelium",  Constants.EpitheliumTissueRef, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
				initProperty(bioMightTransform.getName(), Constants.EpitheliumTissue, Constants.EpitheliumTissueRef, epithelium.getComponentID());
			}
			else if (viewPerspective == Constants.VIEW_INTERNAL)
			{	
				gallBladderFundus = new GallBladderFundus(bioMightTransform.getId(), bioMightMethods);
				initProperty(bioMightTransform.getName(), Constants.GallBladderFundus, Constants.GallBladderFundusRef, epithelium.getComponentID());
	
				gallBladderBody = new GallBladderBody(bioMightTransform.getId(), bioMightMethods);
				initProperty(bioMightTransform.getName(), Constants.GallBladderBody, Constants.GallBladderBodyRef, epithelium.getComponentID());
	
				gallBladderNeck = new GallBladderNeck(bioMightTransform.getId(), bioMightMethods);
				initProperty(bioMightTransform.getName(), Constants.GallBladderNeck, Constants.GallBladderNeckRef, epithelium.getComponentID());				
			}
			else
			{
				System.out.println("UnMatched Perspective.... ");
			}
			
			
			System.out.println("GallBladder Epithelium completed");			
		}		

	
		//initProperties();
		initMethods();
	}
	

	
	
	public void generate(String parentID, String componentID)
	{
		// Generate the GallBladder Epithelium		
		BioMightBeanLocal bioMightBean;
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Generating the GallBladder ParentID: " + parentID);
			InitialContext ctx = new InitialContext();
			bioMightBean = (BioMightBeanLocal) ctx.lookup("java:global/BioMightWeb/BioMightBean!biomight.ejb.BioMightBeanLocal");
	
			double radius = 0.00125;
		
	
			if (componentID.equals("GallBladder:01")) 
			{	
				// Generate the GallBladder
				//  seven sections
				double[] startPos = {-2.0, -20.5, -3.25};
				double[] orient = {10.00, 0.0, 0.05};
				double[][] currentPoints = BioGraphics.createCylinderInPlane(Constants.YPLANE, startPos, radius, 8);
				
				int success = bioMightBean.generateGallBladder("GallBladderEpithelium:00001", "GallBladderEpithelium", 
					"GallBladderEpithelium", componentID, parentID, currentPoints);			
			}
			else if (parentID.equals("Abdomen:01")) 
			{	
				// Generate the GallBladder
				//  seven sections
				double[] startPos = {-3.0, -19.5, -2.75};
				double[][] currentPoints = BioGraphics.createCylinderInPlane(Constants.XPLANE, startPos, radius, 8);
				
				
	    	int success = bioMightBean.generateGallBladder("GallBladderEpithelium:00001", "GallBladderEpithelium", 
					"GallBladderEpithelium", componentID, parentID, currentPoints);			
			}
			else  if (parentID.equals("Chest:01")) 
			{	
			// Generate the GallBladder
			double[] startPos = {-3.0, -19.5, -2.75};
			double[][] currentPoints = BioGraphics.createCylinderInPlane(Constants.XPLANE, startPos, radius, 8);
	
			
	    	int success = bioMightBean.generateGallBladder("GallBladderEpithelium:00096", "GallBladderEpithelium", 
					"GallBladderEpithelium", componentID, parentID, currentPoints);			
		}
		

			
			System.out.println("Created GallBladderEpithelium Info using EJB");   	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - GallBladderEpithelium");
			throw new ServerException("Remote Exception getComponents():", e); 	
		}
	}
	
	
	public ArrayList getProperties() {

	
		// SURFACES
		BioMightPropertyView property = new BioMightPropertyView();
		property.setPropertyName("Surfaces");
		property.setCanonicalName(Constants.Title);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("Fundus");
		property.setCanonicalName(Constants.GallBladderFundus);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("Body");
		property.setCanonicalName(Constants.GallBladderBody);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("Neck");
		property.setCanonicalName(Constants.GallBladderNeck);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("Serous Coat");
		property.setCanonicalName(Constants.GallBladderSerousCoat);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("Fibromuscular Coat");
		property.setCanonicalName(Constants.GallBladderFibroMuscularCoat);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("Mucous Coat");
		property.setCanonicalName(Constants.GallBladderMucousCoat);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("SimpleColumnarNonCiliatedEpithelialCells");
		property.setCanonicalName(Constants.SimpleColumnarNonCiliatedEpithelialCells);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("CysticDuct");
		property.setCanonicalName(Constants.CysticDuct);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("CysticArtery");
		property.setCanonicalName(Constants.CysticArtery);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("CysticVein");
		property.setCanonicalName(Constants.CysticVein);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("GallBladderConnectiveTissue");
		property.setCanonicalName(Constants.GallBladderConnectiveTissue);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("AschoffsRecesses");
		property.setCanonicalName(Constants.AschoffsRecesses);
		properties.add(property);


		return properties;
	}
	
	
	public ArrayList getMethods() {

		
		BioMightMethodView method;
		
		method = new BioMightMethodView();
		method.setMethodName("Excrete Bile");
		method.setHtmlType("checkbox");
		method.setDataType("boolean");
		methods.add(method);

		method = new BioMightMethodView();
		method.setMethodName("Produce Bile");
		method.setHtmlType("text");
		method.setDataType("double");
		methods.add(method);

		method = new BioMightMethodView();
		method.setMethodName("Rupture");
		method.setHtmlType("boolean");
		methods.add(method);

		method = new BioMightMethodView();
		method.setMethodName("Rupture Size");
		method.setHtmlType("double");
		methods.add(method);
		
		return methods;
	}

	
	public void initMethods() {

		methods = new ArrayList<BioMightMethodView>();
		
		BioMightMethodView method;

		method = new BioMightMethodView();
		method.setMethodName("Secrete");
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
		
		// Assemble the Gall Bladder
		String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
		"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n " +
		"<X3D profile='Immersive' >\n" +
		"<head>\n" +
		 "<meta name='BioMightImage' content='GallBladder.jpg'/>\n" +
		 "<meta name='ExportTime' content='7:45:30'/>\n" +
		 "<meta name='ExportDate' content='08/15/2008'/>\n" +
		 "<meta name='BioMight Version' content='1.0'/>\n" + 
		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='GallBladder'\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		

		
		String body = "";
		int viewPerspective = Constants.VIEW_HAWKEYE;
		if (viewPerspective == Constants.VIEW_HAWKEYE)
		{			
			body = epithelium.getX3D(true);
		}
		else if (viewPerspective == Constants.VIEW_INTERNAL)
		{	
			body = 
			gallBladderFundus.getX3D(true) +
			gallBladderBody.getX3D(true) +
			gallBladderNeck.getX3D(true);
		}
		else
		{}
	
		
		body+= "<Viewpoint DEF='Viewpoint_GallBladder'\n" +
				 "description='Viewpoint1'\n" +
				 "jump='true'\n" +
				 "fieldOfView='0.785'\n" +
				 "position='0.0 -19.0 15.0'\n" +
				 "orientation='0 0 1 0'/>\n";
		
		
		//System.out.println("GallBladder X3D: " + body);		
		String footer = "</Scene>" + "</X3D>\n";
		
		
		if (snipet)
			return body;			
		else	
			return header + body + footer;
	}


	/***
	 * 
	 * Set the number of Aschoff Recesses on the bladder surface
	 *
	 */
	public void setAschoffRecessLevel()
	{
	}
	
	
	public void createGallStone()
	{
	}
	/**
	 * @return
	 */
	public AschoffsRecesses getAschoffsRecesses() {
		return aschoffsRecesses;
	}

	/**
	 * @return
	 */
	public SimpleColumnarNonCiliatedEpithelialCells getColumnarSimpleNonCiliatedEpithelialCells() {
		return columnarSimpleNonCiliatedEpithelialCells;
	}

	/**
	 * @return
	 */
	public CysticArtery getCysticArtery() {
		return cysticArtery;
	}

	/**
	 * @return
	 */
	public CysticDuct getCysticDuct() {
		return cysticDuct;
	}

	/**
	 * @return
	 */
	public CysticVein getCysticVein() {
		return cysticVein;
	}

	/**
	 * @return
	 */
	public GallBladderConnectiveTissue getGallBladderConnectiveTissue() {
		return gallBladderConnectiveTissue;
	}

	/**
	 * @param recesses
	 */
	public void setAschoffsRecesses(AschoffsRecesses recesses) {
		aschoffsRecesses = recesses;
	}

	/**
	 * @param cells
	 */
	public void setColumnarSimpleNonCiliatedEpithelialCells(SimpleColumnarNonCiliatedEpithelialCells cells) {
		columnarSimpleNonCiliatedEpithelialCells = cells;
	}

	/**
	 * @param artery
	 */
	public void setCysticArtery(CysticArtery artery) {
		cysticArtery = artery;
	}

	/**
	 * @param duct
	 */
	public void setCysticDuct(CysticDuct duct) {
		cysticDuct = duct;
	}

	/**
	 * @param vein
	 */
	public void setCysticVein(CysticVein vein) {
		cysticVein = vein;
	}

	/**
	 * @param tissue
	 */
	public void setGallBladderConnectiveTissue(GallBladderConnectiveTissue tissue) {
		gallBladderConnectiveTissue = tissue;
	}


}


