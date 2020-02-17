/*
 * Created on Apr 24, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.body.organ.smallintestine;
import java.util.ArrayList;

import javax.naming.InitialContext;

import biomight.BioMightBase;
import biomight.Constants;
import biomight.cell.extracellularmatrixsecretion.Osteocytes;
import biomight.ejb.BioMightBeanLocal;
import biomight.exceptions.ServerException;
import biomight.system.tissue.edothelial.EndotheliumTissue;
import biomight.system.tissue.epithelial.EpitheliumTissue;
import biomight.util.BioGraphics;
import biomight.view.BioMightMethodView;
import biomight.view.BioMightPosition;
import biomight.view.BioMightPropertyView;
import biomight.view.BioMightScale;
import biomight.view.BioMightTransform;

/*************************************************************
 * @author SurferJim
 *
 * Representation of the Small Intestine
 * 
 *************************************************************/

public class SmallIntestine extends BioMightBase {
	private BioMightTransform gbioMightTransform; 
	private Ileum ileum;
	private Jejunum jejunum;
	private Duodenum duodenum;
	private EpitheliumTissue epithelium;
	protected EndotheliumTissue endothelium;	
		
	/*********************************************************************************
	 * CONSTRUCTORS
	 *
	 *********************************************************************************/
	
	public SmallIntestine()
	{
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, Constants.SmallIntestineRef, null, null);
	}

	public SmallIntestine(String parentID)
	{
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, parentID, null, null);
	}

	public SmallIntestine(int hierarchy, int LOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
	{
		create(hierarchy, LOD, parentID, bioMightProperties, bioMightMethods);
	}
	
	/*****************************************************************
	 * CREATE
	 * 
	 * @param parentID
	 * @param bioMightMethods
	 ******************************************************************/
	public void create(int localVP, int localLOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
	{
		this.setImage("images/SmallIntestine.jpg");
		this.setImageWidth(300);
		this.setImageHeight(325);
		this.viewPerspective = localVP;
		this.lod = localLOD;
		this.parentID = parentID;
		this.componentID = parentID;
	
		
		if (viewPerspective == Constants.VIEW_DETACHED)			
		{
			System.out.println("In Create SmallIntestine - DETACHED VIEW");   	
		
			
			// Get the information from the database via the Enterprise Bean		
			try {
				// Get the information from the database via the Enterprise Bean		
				System.out.println("Getting SmallIntestineInfo for ParentID: " + parentID);
				InitialContext ctx = new InitialContext();
				BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
				bioMightTransforms = bioMightBean.getComponents(Constants.SmallIntestineRef, parentID);
				System.out.println("Have SmallIntestine Info from EJB");   	
			}catch (Exception e) { 
				System.out.println("Exception Getting Components - SmallIntestine");
				throw new ServerException("Remote Exception getComponents():", e); 	
			}
				
			// Run through the collection of SmallIntestines and build them into the model
			// In the default case, we get one instance of the SmallIntestine for each eye
			ArrayList transforms = bioMightTransforms.getTransforms();
			System.out.println("SmallIntestine NumTransforms: " + transforms.size());
			for (int i=0; i<transforms.size(); i++)
			{
				// Get the information for the eye we are creating
				BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
				System.out.println("Created SmallIntestine: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
				this.componentID = bioMightTransform.getId();
				
				// Generate the component 
				boolean bGenerate = false;
				if (bGenerate) {
					generate(componentID, componentID);
				}
				
				if (localLOD == Constants.MAG1X)
				{
					System.out.println("Creating SmallIntestine at DETACHED MAG1X - Just Init Properties: " + parentID);
					// initialize the Properties
										
					String startID = "SmallIntestineEpithelium:00001";
					System.out.println("HawkEye 1x - Creating SmallIntestine Epithelium using Parent: " + bioMightTransform.getId() + "    startID: " + startID);				
					epithelium = new EpitheliumTissue(localVP, localLOD, startID, "SmallIntestineEpithelium",  Constants.EpitheliumTissueRef, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
					initProperty("SmallIntestineEpithelium", Constants.EpitheliumTissue, Constants.EpitheliumTissueRef, bioMightTransform.getId());
					
					//System.out.println("Creating SmallIntestine Endothelium: " + bioMightTransform.getId());				
					//endothelium = new EndotheliumTissue("SmallIntestineEndothelium", bioMightTransform.getId(), bioMightMethods);
					//initProperty("SmallIntestineEndothelium", Constants.EpitheliumTissue, Constants.EpitheliumTissueRef, bioMightTransform.getId());


					initProperties();
				}
				if (localLOD == Constants.MAG2X)
				{
					// Go get the finer details of the SmallIntestine				
					System.out.println("Creating SmallIntestine at DETACHED MAG2X : " + parentID);
					localVP = Constants.VIEW_INTERNAL; 
					localLOD = Constants.MAG1X;
					
					System.out.println("Creating Ileum: " + bioMightTransform.getId());				
					ileum = new Ileum(bioMightTransform.getId(), bioMightMethods);
					initProperty("ileum", Constants.Ileum, Constants.IleumRef, bioMightTransform.getId());
				
					System.out.println("Creating Jejunum: " + bioMightTransform.getId());				
					jejunum = new Jejunum(bioMightTransform.getId(), bioMightMethods);
					initProperty("Jejunum", Constants.Jejunum, Constants.JejunumRef, bioMightTransform.getId());
				
					System.out.println("Creating 	: " + bioMightTransform.getId());				
					duodenum = new Duodenum(bioMightTransform.getId(), bioMightMethods);
					initProperty("Duodenum", Constants.Duodenum, Constants.DuodenumRef, bioMightTransform.getId());

					System.out.println("SmallIntestine Instance is created : " + componentID + "    parent: " +  parentID);		
					//System.out.println("Creating SmallIntestine Endothelium: " + bioMightTransform.getId());				
					//endothelium = new EndotheliumTissue("SmallIntestineEndothelium", bioMightTransform.getId(), bioMightMethods);
					//initProperty("SmallIntestineEndothelium", Constants.EpitheliumTissue, Constants.EpitheliumTissueRef, bioMightTransform.getId());
				}

			}
		}
		//
		else if (viewPerspective == Constants.VIEW_INTERNAL)
		{
			// Do nothing.  We are instantiating as part of a collection  
			// There is no drill down, so we use the transforms that the
			// parent has already collected
			System.out.println("In SmallIntestine Create() - ViewInternal - Already Set from: " + parentID);				

			componentID=parentID;
			
			// Generate the component 
			boolean bGenerate = false;
			if (bGenerate) {
				generate(parentID, componentID);
			}
			
			// We already have the data for the current instance of SmallIntestine,
			// Go get the details for the current SmallIntestine is LOD is set
			if (localLOD == Constants.MAG1X)
			{
				// Go get the finer details of the SmallIntestine				
				System.out.println("Getting the SmallIntestine MAG1X : " + parentID);
				localVP = Constants.VIEW_INTERNAL; 
				localLOD = Constants.MAG1X;		
				
				String startID = "SmallIntestineEpithelium:00001";
				System.out.println("Internal 2X - Creating SmallIntestine Epithelium: " + parentID + "  startID: " + startID);				
				epithelium = new EpitheliumTissue(localVP, localLOD, startID, "SmallIntestineEpithelium",  Constants.EpitheliumTissueRef, componentID, bioMightProperties, bioMightMethods);
				initProperty("SmallIntestineEpithelium", Constants.EpitheliumTissue, Constants.EpitheliumTissueRef, componentID);
			}
			else if (localLOD == Constants.MAG2X)
			{
				// Go get the finer details of the SmallIntestine				
				System.out.println("Getting the SmallIntestine MAG2X : " + parentID);
				localVP = Constants.VIEW_INTERNAL; 
				localLOD = Constants.MAG1X;		
					
				System.out.println("Creating Ileum: " + parentID);				
				ileum = new Ileum(parentID, bioMightMethods);
				initProperty("ileum", Constants.Ileum, Constants.IleumRef, parentID);
			
				System.out.println("Creating Jejunum: " + parentID);				
				jejunum = new Jejunum(parentID, bioMightMethods);
				initProperty("Jejunum", Constants.Jejunum, Constants.JejunumRef, parentID);
			
				System.out.println("Creating 	: " + parentID);				
				duodenum = new Duodenum(parentID, bioMightMethods);
				initProperty("Duodenum", Constants.Duodenum, Constants.DuodenumRef, parentID);

				System.out.println("SmallIntestine Instance is created : " + componentID + "    parent: " +  parentID);					}

			
		}
		else if (viewPerspective == Constants.VIEW_HAWKEYE)
		{

			System.out.println("In Create SmallIntestine - VIEW HAWKEYEW");   	
		
			
			// Get the information from the database via the Enterprise Bean		
			try {
				// Get the information from the database via the Enterprise Bean		
				System.out.println("Getting SmallIntestineInfo for ParentID: " + parentID);
				InitialContext ctx = new InitialContext();
				BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
				bioMightTransforms = bioMightBean.getComponents(Constants.SmallIntestineRef, parentID);
				System.out.println("Have SmallIntestine Info from EJB");   	
			}catch (Exception e) { 
				System.out.println("Exception Getting Components - SmallIntestine");
				throw new ServerException("Remote Exception getComponents():", e); 	
			}
				
			// Run through the collection of SmallIntestines and build them into the model
			// In the default case, we get one instance of the SmallIntestine for each eye
			ArrayList transforms = bioMightTransforms.getTransforms();
			System.out.println("SmallIntestine NumTransforms: " + transforms.size());
			for (int i=0; i<transforms.size(); i++)
			{
				// Get the information for the eye we are creating
				BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
				System.out.println("Created SmallIntestine: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
				this.componentID = bioMightTransform.getId();
				
				// Generate the component 
				boolean bGenerate = false;
				if (bGenerate) {
					generate(componentID, componentID);
				}
				
				if (localLOD == Constants.MAG1X)
				{
					System.out.println("Creating SmallIntestine at DETACHED MAG1X - Just Init Properties: " + parentID);
					// initialize the Properties
										
					String startID = "SmallIntestineEpithelium:00001";
					System.out.println("HawkEye 1x - Creating SmallIntestine Epithelium using Parent: " + bioMightTransform.getId() + "    startID: " + startID);				
					epithelium = new EpitheliumTissue(localVP, localLOD, startID, "SmallIntestineEpithelium",  Constants.EpitheliumTissueRef, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
					initProperty("SmallIntestineEpithelium", Constants.EpitheliumTissue, Constants.EpitheliumTissueRef, bioMightTransform.getId());
					
					//System.out.println("Creating SmallIntestine Endothelium: " + bioMightTransform.getId());				
					//endothelium = new EndotheliumTissue("SmallIntestineEndothelium", bioMightTransform.getId(), bioMightMethods);
					//initProperty("SmallIntestineEndothelium", Constants.EpitheliumTissue, Constants.EpitheliumTissueRef, bioMightTransform.getId());


					initProperties();
				}
				if (localLOD == Constants.MAG2X)
				{
					// Go get the finer details of the SmallIntestine				
					System.out.println("Creating SmallIntestine at DETACHED MAG2X : " + parentID);
					localVP = Constants.VIEW_INTERNAL; 
					localLOD = Constants.MAG1X;
					
					System.out.println("Creating Ileum: " + bioMightTransform.getId());				
					ileum = new Ileum(bioMightTransform.getId(), bioMightMethods);
					initProperty("ileum", Constants.Ileum, Constants.IleumRef, bioMightTransform.getId());
				
					System.out.println("Creating Jejunum: " + bioMightTransform.getId());				
					jejunum = new Jejunum(bioMightTransform.getId(), bioMightMethods);
					initProperty("Jejunum", Constants.Jejunum, Constants.JejunumRef, bioMightTransform.getId());
				
					System.out.println("Creating 	: " + bioMightTransform.getId());				
					duodenum = new Duodenum(bioMightTransform.getId(), bioMightMethods);
					initProperty("Duodenum", Constants.Duodenum, Constants.DuodenumRef, bioMightTransform.getId());

					System.out.println("SmallIntestine Instance is created : " + componentID + "    parent: " +  parentID);		
					//System.out.println("Creating SmallIntestine Endothelium: " + bioMightTransform.getId());				
					//endothelium = new EndotheliumTissue("SmallIntestineEndothelium", bioMightTransform.getId(), bioMightMethods);
					//initProperty("SmallIntestineEndothelium", Constants.EpitheliumTissue, Constants.EpitheliumTissueRef, bioMightTransform.getId());
				}

			}

			
		}
		
		
		initProperties();
		//initMethods();
		
		System.out.println("CreateSmallIntestine Completed");
		
		// First, get all the data from the database
		// Apply the methods to it
		// Save its state
		if (bioMightMethods != null){
			System.out.println("EXECUTING SmallIntestine METHODS: " + bioMightMethods.size());
			//executeMethods(bioMightMethods);
		}
	}
	
	
	
	public void initProperties() {

		BioMightScale bioScale = new BioMightScale("0.00, 0.00, 0.00");
		BioMightPosition bioPos = new BioMightPosition("0.00, 0.00, 0.00");	
		String bioTemplate =""; 

		initProperty("Not Available", Constants.Title, Constants.Title, "SmallIntestine:01", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		initProperty(Constants.IleumRef, Constants.Ileum, Constants.IleumRef, "SmallIntestine:01", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		initProperty(Constants.JejunumRef, Constants.Jejunum, Constants.JejunumRef, "SmallIntestine:01", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		initProperty(Constants.DuodenumRef, Constants.Duodenum, Constants.DuodenumRef, "SmallIntestine:01", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
	}
	
	
	public void initMethods() {

		
		BioMightMethodView method;
		
		method = new BioMightMethodView();
		method.setMethodName("Digest");
		method.setHtmlType("checkbox");
		methods.add(method);

		method = new BioMightMethodView();
		method.setMethodName("Excrete");
		method.setHtmlType("checkbox");
		methods.add(method);

		method = new BioMightMethodView();
		method.setMethodName("Peristalisis");
		method.setHtmlType("checkbox");
	}

	
	
	
	/****************************************************************************
	 * GENERATE 
	 * 
	 * @param parentID
	 * @param componentID
	 ***************************************************************************/
	
	public void generate(String parentID, String componentID)
	{

		// Generate the SmallIntestine Epithelium		
		BioMightBeanLocal bioMightBean;
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Generating the SmallIntestine ParentID: " + parentID);
			InitialContext ctx = new InitialContext();
			bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
			
			// Generate the large intestine
			double circumference = 0.60;
			double[] startPos = {-1.75,-22.15,-4.25};
			double[][] currentPoints = BioGraphics.createCylinderInPlane(Constants.XPLANE, startPos, circumference, 8);
				
			int success = bioMightBean.generateSmallIntestine("SmallIntestineEpithelium:00001", "SmallIntestineEpithelium", 
					"SmallIntestineEpithelium", parentID, currentPoints);			
			System.out.println("Created SmallIntestine Info using EJB");   	
			
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - SmallIntestine");
			throw new ServerException("Remote Exception getComponents():", e); 	
		}
	
	}

	/********************************************************************************************************************
	 * GET X3D
	 * 
	 * This method will return the X3D for the SmallIntestine.  It runs through each of its 
	 * components and collects up their representations and then assembles them into one unified X3D model.
	 * 
	 ********************************************************************************************************************/

	public String getX3D(boolean snipet) {
		
		// Assemble the SmallIntestine
		String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
		"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n " +
		"<X3D profile='Immersive' >\n" +
		"<head>\n" +
		 "<meta name='BioMightImage' content='SmallIntestine .jpg'/>\n" +
		 "<meta name='ExportTime' content='7:45:30'/>\n" +
		 "<meta name='ExportDate' content='08/15/2008'/>\n" +
		 "<meta name='BioMight Version' content='1.0'/>\n" + 
		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='SmallIntestine '\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		

		System.out.println("Getting SmallIntestine X3D: ");	
		
		String body = "";

		if (viewPerspective == Constants.VIEW_DETACHED){
			System.out.println("Getting SmallIntestine X3D: VIEW_DETACHED ");
			String sensor= "<TouchSensor DEF='StartSmallIntestine' \n" +
		                   " description='Radial Artery'\n" +
			               " containerField='children'/> \n";
			
			//body = "<GROUP>" +
			//	osteocytes.getX3D(true) + 	sensor +
			//	"</GROUP>";
			
			body =
					epithelium.getX3D(true);
			
		}
		else if (viewPerspective == Constants.VIEW_INTERNAL){
			System.out.println("Getting SmallIntestine X3D:   VIEW_INTERNAL  ");
			String sensor= "<TouchSensor DEF='StartSmallIntestine' \n" +
		                   " description='Radial Artery'\n" +
			               " containerField='children'/> \n";
			
			body =
					epithelium.getX3D(true);
			
		}
		else if (viewPerspective == Constants.VIEW_HAWKEYE){
			
			String sensor= "<TouchSensor DEF='StartSmallIntestine' \n" +
		                   " description='Radial Artery'\n" +
			               " containerField='children'/> \n";
			
			body =
					epithelium.getX3D(true);
			
		}
		// We draw at this level -- need to add an algorithm that draws it as cylinders interlocking
		else if (viewPerspective == Constants.VIEW_FLOATING)
		{
			// Run through the collection of SmallIntestine  and build them into the model
			// In the default case, we get one instance of the SmallIntestine  for each Stomach
			ArrayList transforms = bioMightTransforms.getTransforms();
			for (int i=0; i<transforms.size(); i++)
			{
				// Get the information for the SmallIntestine we are creating
				BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
				System.out.println("Getting SmallIntestine X3D: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
				
				//System.out.println("Getting X3D for SmallIntestine X: " + bioMightSphere.getTranslation().getXPos());
				//System.out.println("Getting X3D for SmallIntestine Y: " + bioMightSphere.getTranslation().getYPos());
				//System.out.println("Getting X3D for SmallIntestine Z: " + bioMightSphere.getTranslation().getZPos());
				// Change the height and width based on the displacement.
				body += "<Transform DEF='SmallIntestine '\n" +
		 			"translation='" + bioMightTransform.getTranslation().getXPos() + " " 
			 					+ bioMightTransform.getTranslation().getYPos() + " "
			 					+ bioMightTransform.getTranslation().getZPos() + "'\n" +
			 		"scale='" 	+ bioMightTransform.getScale().getXPos() + " "
			 				+ bioMightTransform.getScale().getYPos() + " "
			 				+ bioMightTransform.getScale().getZPos() + "'>\n" +
					"<Shape DEF='SmallIntestine Shape'\n" +
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
						 	"<IndexedFaceSet DEF='SmallIntestine IFS' \n" +
						    	   "containerField='geometry' \n" +
						    	   "creaseAngle='" +  bioMightTransform.getCreaseAngle() + "'\n" +
						    	   "coordIndex='" + bioMightTransform.getCoordindexStr() + "'>" +
						    	   "<Coordinate DEF='SmallIntestine _Coord' \n" +
						    	    "containerField='coord' point='" +  bioMightTransform.getCoordpointStr() + "'/>" +
						    	  "</IndexedFaceSet>\n" +
					"</Shape>\n" +
	
				
					"<TouchSensor DEF='StartSmallIntestine' \n" +
					      " description='Radial Artery'\n" +
						  " containerField='children'/> \n" +
				 "</Transform>\n";
			}
		}
		else
		{
			body = "";//						
		}
		
		// We should do this on detached view only
		body+= "<Viewpoint DEF='Viewpoint_SmallIntestine'\n" +
				 "description='Viewpoint1'\n" +
				 "jump='true'\n" +
				 "fieldOfView='0.785'\n" +
				 "position='0.0 -27.0 20.0'\n" +
				 "orientation='0 0 1 0'/>\n";
		
		
		//System.out.println("SmallIntestine X3D: " + body);		
		String footer = "</Scene>" + "</X3D>\n";
		
		if (snipet)
			return body;			
		else	
			return header + body + footer;
	}
		
	
	public void onContact(Object obj)
	{
	}

	public void setAminoAcids()
	{
	}
	
	
	public void setMonosaccharides()
	{
	}

	public Duodenum getDuodenum() {
		return duodenum;
	}

	public void setDuodenum(Duodenum duodenum) {
		this.duodenum = duodenum;
	}

	public Ileum getIleum() {
		return ileum;
	}

	public void setIleum(Ileum ileum) {
		this.ileum = ileum;
	}

	public Jejunum getJejunum() {
		return jejunum;
	}

	public void setJejunum(Jejunum jejunum) {
		this.jejunum = jejunum;
	}
	
}
