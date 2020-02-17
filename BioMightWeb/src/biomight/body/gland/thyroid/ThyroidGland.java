/*
 * Created on May 8, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.body.gland.thyroid;

import biomight.Constants;
import biomight.body.organ.Organ;
import biomight.chemistry.compound.Tetraiodothyronine5Deiodinase;
import biomight.chemistry.hormones.aminederived.tyrosine.*;
import biomight.cell.hormonesecreting.*;
import biomight.ejb.BioMightBeanLocal;
import biomight.exceptions.DataSecurityException;
import biomight.exceptions.ServerException;
import biomight.system.tissue.epithelial.EpitheliumTissue;
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


/**
 * @author SurferJim
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 * It is 10-20 grams in adults 
 */

public class ThyroidGland extends Organ {	
	private ThyroidEpithelialCells thyroidEpithelialCells;  // Thyrocytes
	private ParaFollicularCells paraFollicularCells;
	private ThyroidFollicles thyroidFollicles;
	private Tetraiodothyronine5Deiodinase tetraiodothyronine5Deiodinase;
	private Thyroxine thyroxine;
	private Triiodothyronine triiodothyronine;
	protected EpitheliumTissue epithelium;
	
	
	public ThyroidGland()
	{
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, Constants.ThyroidGlandRef, null, null);
	}

	public ThyroidGland(String parentID)
	{
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, parentID, null, null);
	}

	public ThyroidGland(int vp, int LOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
	{
		System.out.print("Calling ThyroidGland Create");
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

		this.setImage("images/ThyroidGland.jpg");
		this.setImageHeight(300);
		this.setImageWidth(300);
	
		
		// Get the information from the database via the Enterprise Bean		
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Getting ThyroidGlandInfo for ParentID: " + parentID);
			Context ctx = new InitialContext(); 
			BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
			bioMightTransforms = bioMightBean.getComponents(Constants.ThyroidGlandRef, parentID);
			System.out.println("Have ThyroidGland Info from EJB");   	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - ThyroidGland");
			throw new ServerException("Remote Exception getComponents():", e); 	
		}
		
		int localVP = Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;

		BioMightScale bioScale = new BioMightScale("0.00, 0.00, 0.00");
		BioMightPosition  bioPos = new BioMightPosition("0.00, 0.00, 0.00");
		String bioTemplate="Bacterias.x3d";

		
		// Run through the collection of ThyroidGlands and build them into the model
		// In the default case, we get one instance of the ThyroidGland for each eye
		ArrayList transforms = bioMightTransforms.getTransforms();
		System.out.println("ThyroidGland NumTransforms: " + transforms.size());
		for (int i=0; i<transforms.size(); i++)
		{
			// Get the information for the eye we are creating
			BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
			System.out.println("Created ThyroidGland: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
			this.componentID = bioMightTransform.getId();
			
			// Generate the Thyroid Epithelium if needed 
			boolean bGenerate = false;
			if (bGenerate) {
				generate(parentID, componentID);
			}
			
			System.out.println("Creating ThyroidGland Epithelium: " + bioMightTransform.getId());				
			String startID = "ThyroidGlandEpithelium:00001";
			epithelium = new EpitheliumTissue(localVP, localLOD, startID, "ThyroidGlandEpithelium",  Constants.EpitheliumTissueRef, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
			initProperty(bioMightTransform.getName(), Constants.EpitheliumTissue, Constants.EpitheliumTissueRef, epithelium.getComponentID());

			/*int viewPerspective = Constants.VIEW_DETACHED;
			if (viewPerspective == Constants.VIEW_DETACHED)
			{				
				// Create the components of the curvature

			}*/
		}
		initProperties();
		initMethods();
		
		System.out.println("CreateThyroidGland Completed");
		
		// First, get all the data from the database
		// Apply the methods to it
		// Save its state
		this.parentID = parentID;
		if (bioMightMethods != null){
			System.out.println("EXECUTING ThyroidGland METHODS: " + bioMightMethods.size());
			//executeMethods(bioMightMethods);
		}
	}
	
	public void initProperties() {
		
		BioMightScale bioScale = new BioMightScale("0.00, 0.00, 0.00");
		BioMightPosition bioPos = new BioMightPosition("0.00, 0.00, 0.00");	
		String bioTemplate =""; 

		initProperty("Not Available", Constants.Title, Constants.Title, "AdrenalGland:0", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		initProperty(Constants.ThyroxineRef, Constants.Thyroxine, Constants.ThyroxineRef, "AdrenalGland:0", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		//initProperty(Constants.TriiodothyronineRef, Constants.Triiodothyronine, Constants.TriiodothyronineRef, "Organs:0", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
	}
		
			
	
	public void initMethods() {
	
		methods = new ArrayList<BioMightMethodView>();
		
		BioMightMethodView method = new BioMightMethodView();
	
		method = new BioMightMethodView();
		method.setMethodName("Produce Thyroxine");
		method.setHtmlType("checkbox");
		methods.add(method);	
		
		method = new BioMightMethodView();
		method.setMethodName("Produce Triiodothyronine");
		method.setHtmlType("checkbox");
		methods.add(method);
	}
	
	/****************************************************************************
	 * GENERATE THYROID GLAND
	 * 
	 * @param parentID
	 * @param componentID
	 ***************************************************************************/
	
	public void generate(String parentID, String componentID)
	{
		// Generate the ThyroidGland Epithelium		
		BioMightBeanLocal bioMightBean;
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Generating the ThyroidGland ParentID: " + parentID);
			InitialContext ctx = new InitialContext();
			bioMightBean = (BioMightBeanLocal) ctx.lookup("java:global/BioMightWeb/BioMightBean!biomight.ejb.BioMightBeanLocal");
	
			double circumference = 0.125;
		
		
		 if (parentID.equals("Neck:01")) 
			{	
				// Generate the ThyroidGland
				//  seven sections
				double[] startPos = {0.0, -6.50, -3.50};
				
				// Create a equilateral octogon
				double x =  startPos[0];
				double y =  startPos[1];
				double z =  startPos[2];

				double[][] currentPoints = { 
	    	 		{x, y, z},
	    	 		{x-circumference,     y, z-circumference},
	    	   		{x-circumference,     y, z-circumference*2},
	    	   		{x,                   y, z-circumference*3},
	    	   		{x+circumference,     y, z-circumference*3},
	    	   		{x+(circumference*2), y, z-circumference*2},
	    	   		{x+(circumference*2),     y, z-circumference},
	    	  		{x+circumference, y, z}
	    	   		};
				
	    	int success = bioMightBean.generateThyroidGland("ThyroidGlandEpithelium:00001", "ThyroidGlandEpithelium", 
					"ThyroidGlandEpithelium", componentID, parentID, currentPoints);			
		}
		 // Physical Abnoramility
		else  if (parentID.equals("Chest:01")) 
		{	
			// Generate the ThyroidGland
			double[] startPos = {0.0,-9.0, -2.0};
				
			// Create a equilateral octogon
	    	double x =  startPos[0];
	    	double y =  startPos[1];
	    	double z =  startPos[2];

	    	double[][] currentPoints = { 
	    	 		{x, y, z},
	    	 		{x-circumference,     y, z-circumference},
	    	   		{x-circumference,     y, z-circumference*2},
	    	   		{x,                   y, z-circumference*3},
	    	   		{x+circumference,     y, z-circumference*3},
	    	   		{x+(circumference*2), y, z-circumference*2},
	    	   		{x+(circumference*2),     y, z-circumference},
	    	  		{x+circumference, y, z}
	    	   		};
			
	    	int success = bioMightBean.generateThyroidGland("ThyroidGlandEpithelium:00001", "ThyroidGlandEpithelium", 
					"ThyroidGlandEpithelium", componentID, parentID, currentPoints);			
		}
			
			System.out.println("Created ThyroidGlandEpithelium Info using EJB");   	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - ThyroidGlandEpithelium");
			throw new ServerException("Remote Exception getComponents():", e); 	
		}
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
		 "<meta name='BioMightImage' content='ThyroidGland.jpg'/>\n" +
		 "<meta name='ExportTime' content='7:45:30'/>\n" +
		 "<meta name='ExportDate' content='08/15/2008'/>\n" +
		 "<meta name='BioMight Version' content='1.0'/>\n" + 
		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='ThyroidGland'\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		

		String body = epithelium.getX3D(true);  
		//System.out.println("ThyroidGland X3D: " + body);		
		
		String footer = "</Scene>" + "</X3D>\n";
		
		body+= "<Viewpoint DEF='Viewpoint_Thyroid'\n" +
				 "description='Viewpoint1'\n" +
				 "jump='true'\n" +
				 "fieldOfView='0.785'\n" +
				 "position='0.0 -7.0 15.0'\n" +
				 "orientation='0 0 1 0'/>\n";
		
		
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
		 "<meta name='BioMightImage' content='ThyroidGland .jpg'/>\n" +
		 "<meta name='ExportTime' content='7:45:30'/>\n" +
		 "<meta name='ExportDate' content='08/15/2008'/>\n" +
		 "<meta name='BioMight Version' content='1.0'/>\n" + 
		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='ThyroidGland '\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		


		String body = "";
		
		// Run through the collection of ThyroidGland  and build them into the model
		// In the default case, we get one instance of the ThyroidGland  for each Stomach
		ArrayList transforms = bioMightTransforms.getTransforms();
		for (int i=0; i<transforms.size(); i++)
		{
			// Get the information for the ThyroidGland we are creating
			BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
			System.out.println("Getting ThyroidGland X3D: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
		
			int view = Constants.VIEW_FLOATING;
			if (view == Constants.VIEW_FLOATING)
			{
				//System.out.println("Getting X3D for ThyroidGland X: " + bioMightSphere.getTranslation().getXPos());
				//System.out.println("Getting X3D for ThyroidGland Y: " + bioMightSphere.getTranslation().getYPos());
				//System.out.println("Getting X3D for ThyroidGland Z: " + bioMightSphere.getTranslation().getZPos());
				// Change the height and width based on the displacement.
				body += "<Transform DEF='ThyroidGland '\n" +
		 			"translation='" + bioMightTransform.getTranslation().getXPos() + " " 
			 					+ bioMightTransform.getTranslation().getYPos() + " "
			 					+ bioMightTransform.getTranslation().getZPos() + "'\n" +
			 		"scale='" 	+ bioMightTransform.getScale().getXPos() + " "
			 				+ bioMightTransform.getScale().getYPos() + " "
			 				+ bioMightTransform.getScale().getZPos() + "'>\n" +
					"<Shape DEF='ThyroidGland Shape'\n" +
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
						 	"<IndexedFaceSet DEF='ThyroidGland IFS' \n" +
						    	   "containerField='geometry' \n" +
						    	   "creaseAngle='" +  bioMightTransform.getCreaseAngle() + "'\n" +
						    	   "coordIndex='" + bioMightTransform.getCoordindexStr() + "'>" +
						    	   "<Coordinate DEF='ThyroidGland _Coord' \n" +
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
			 "<ROUTE fromNode='StomachBeatAnim' fromField='value_changed' toNode='ThyroidGland' toField='set_scale'/>\n";
		}
		else
		{
			body = "";//						
		}
		
		}
		
		//System.out.println("ThyroidGland X3D: " + body);		
		String footer = "</Scene>" + "</X3D>\n";
		
		if (snipet)
			return body;			
		else	
			return header + body + footer;
	}	

	
	/**
	 * @return
	 */
	public Thyroxine getThyroxine() {
		return thyroxine;
	}

	/**
	 * @return
	 */
	public Triiodothyronine getTriiodothyronine() {
		return triiodothyronine;
	}

	/**
	 * @param thyroxine
	 */
	public void setThyroxine(Thyroxine thyroxine) {
		this.thyroxine = thyroxine;
	}

	/**
	 * @param triiodothyronine
	 */
	public void setTriiodothyronine(Triiodothyronine triiodothyronine) {
		this.triiodothyronine = triiodothyronine;
	}

	/**
	 * @return
	 */
	public ThyroidEpithelialCells getThyroidEpithelialCells() {
		return thyroidEpithelialCells;
	}

	/**
	 * @return
	 */
	public ThyroidFollicles getThyroidFollicles() {
		return thyroidFollicles;
	}

	/**
	 * @param cells
	 */
	public void setThyroidEpithelialCells(ThyroidEpithelialCells cells) {
		thyroidEpithelialCells = cells;
	}

	/**
	 * @param follicles
	 */
	public void setThyroidFollicles(ThyroidFollicles follicles) {
		thyroidFollicles = follicles;
	}

}
