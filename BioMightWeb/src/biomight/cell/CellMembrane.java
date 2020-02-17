/*
 * Created on Apr 26, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.cell;

import java.lang.reflect.Method;
import java.util.ArrayList;

import javax.naming.InitialContext;

import biomight.BioMightBase;
import biomight.Constants;
import biomight.chemistry.compound.Granzymes;
import biomight.chemistry.compound.Perforins;
import biomight.chemistry.compound.PhosphoLipids;
import biomight.chemistry.hormones.lipid.Cholesterols;
import biomight.chemistry.hormones.lipid.Thromboxanes;
import biomight.chemistry.protein.Fibrin;
import biomight.ejb.BioMightBeanLocal;
import biomight.ejb.BioMightCellularBeanLocal;
import biomight.exceptions.ServerException;
import biomight.system.tissue.connective.ReticularConnectiveTissue;
import biomight.util.BioGraphics;
import biomight.view.BioMightColor;
import biomight.view.BioMightMethodView;
import biomight.view.BioMightPosition;
import biomight.view.BioMightPropertyView;
import biomight.view.BioMightScale;
import biomight.view.BioMightTexture;
import biomight.view.BioMightTransform;
import biomightweb.util.BioWebUtils;
import biomightweb.view.BioMightViewPoint;

/**********************************************************************************
 * @author SurferJim
 *
 * Representation of the Cell Membrane.  The simple version just creates a 
 * sphere with scaling applied to oblong and slim the sphere into a cellular
 * shape.  The detailed version is made from slices of ploygonal faces that
 * can be individually manuipulated as each portion of sphere is an indexed
 * face set in a database component that can be manipulated.
 * 
 **********************************************************************************/

public class CellMembrane extends BioMightBase{
	private Fibrin fibrin;
	private ReticularConnectiveTissue reticularConnectiveTissue;
	private Cholesterols cholesterols;
	private Thromboxanes thromboxanes;
	private PhosphoLipids phosphoLipids;
	ArrayList textures = null;
	
		
	public CellMembrane()
	{
		int localVP =  Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG2X;
		create(localVP, localLOD, Constants.CellMembraneRef, null);
	}

	public CellMembrane(String parentID)
	{
		int localVP =  Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, parentID, null);
	}
	
	public CellMembrane(String parentID, ArrayList<BioMightMethodView> bioMightMethods) 
	{
		int localVP =  Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, parentID, bioMightMethods);
	}

	public CellMembrane(int lod, String parentID, ArrayList<BioMightMethodView> bioMightMethods) 
	{
		int localVP =  Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, parentID, bioMightMethods);
	}
	
	public CellMembrane(int localVP, int localLOD, String parentID, ArrayList<BioMightMethodView> bioMightMethods)
	{				
		create(localVP, localLOD, parentID, bioMightMethods);	
	}

	public CellMembrane(int localVP, int localLOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
	{				
		create(localVP, localLOD, parentID, bioMightMethods);	
	}
	
	/*****************************************************************************************
	 * CREATE CELL MEMBRANE
	 * 
	 * Create the Cell Membrane
	 * 
	 * ***************************************************************************************/
	
	public void create(int localVP, int localLOD, String parentID, ArrayList<BioMightMethodView> bioMightMethods)
	{
		this.setImage("images/CellMembrane.jpg");
		this.setImageHeight(300);
		this.setImageWidth(300);
		this.parentID = parentID;
	
		this.viewPerspective = localVP;
		this.lod = localLOD;

		System.out.println("CREATE CELL MEMBRANE: " + componentID + "    " + parentID);
		
		if (bioMightMethods != null){
			executeMethods(bioMightMethods);
		}
		
		
		if (localVP == Constants.VIEW_INTERNAL)
		{	
			// Generate the component 
			componentID = parentID;
			
			boolean bGenerate = false;
			if (bGenerate) {
				generate(parentID, componentID);
			}
			
			// Get the information from the database via the Enterprise Bean		
			try {
				// Get the information from the database via the Enterprise Bean		
				System.out.println("Getting CellMembraneInfo - InternalView - for ParentID: " + parentID);
				InitialContext ctx = new InitialContext();
				BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup("java:global/BioMightWeb/BioMightBean!biomight.ejb.BioMightBeanLocal");
				bioMightTransforms = bioMightBean.getComponents(Constants.CellMembraneRef, parentID);  	
			}catch (Exception e) { 
				System.out.println("Exception Getting Components - CellMembrane");
				throw new ServerException("Remote Exception getComponents():", e); 	
			}
		
			
			// Build the membrane from its constituent components
			// Run through the collection of ---- and build them into the model
			ArrayList transforms = bioMightTransforms.getTransforms();
			System.out.println("Have CellMembrane -InteralView- NumTransforms: " + transforms.size());
	
			for (int i=0; i<transforms.size(); i++)
			{
				// Get the information for the CellMembrane we are creating
				BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
				System.out.println("Creating CellMembrane: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
				this.componentID = bioMightTransform.getId();
	
				if  (localLOD == Constants.MAG1X)
				{
					// We are grabbing our data for the Cell Membrane at this level
					// It will be represented by a simple sphere
					System.out.println("Using CellMembrane at MAG1X - Internal");
				}	
				else if (localLOD == Constants.MAG2X)
				{
					System.out.println("Using CellMembrane at MAG2X - Internal");					
					System.out.println("Creating Cholesterol Collection: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());			
					//cholesterols = new Cholesterols("CellMembraneCholesterol", bioMightTransform.getId(), bioMightMethods);
					
					cholesterols = new Cholesterols("Cholesterol", bioMightTransform.getId(), bioMightMethods);
					initProperty("CellMembraneChloresterol", Constants.Cholesterol, Constants.CholesterolRef, cholesterols.getComponentID());	
						
					//System.out.println("Creating Thromboxanes Collection: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());			
					//thromboxanes = new Thromboxanes(nColonyStrength, "CellMembraneThromboxanes", bioMightTransform.getId(), bioMightMethods);
					//initProperty("CellMembraneThromboxanes", Constants.Thromboxanes, Constants.ThromboxanesRef, thromboxanes.getComponentID());	
					
					//phosphoLipids = new PhosphoLipids();
					//initProperty("PhosphoLipids", Constants.PhosphoLipids, Constants.PhosphoLipidsRef, bioMightTransform.getId());
				}
										
			}
		}
		else if  (localVP == Constants.VIEW_HAWKEYE)
		{
			// Get the information from the database via the Enterprise Bean		
			try {
				// Get the information from the database via the Enterprise Bean		
				System.out.println("Getting CellMembraneInfo - HawkEye - for ComponentID: " + parentID);
				InitialContext ctx = new InitialContext();
				BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup("java:global/BioMightWeb/BioMightBean!biomight.ejb.BioMightBeanLocal");
				bioMightTransforms = bioMightBean.getComponent(parentID);
				System.out.println("Have CellMembrane Info from EJB");   	
			}catch (Exception e) { 
				System.out.println("Exception Getting Components - CellMembrane");
				throw new ServerException("Remote Exception getComponents():", e); 	
			}
		
			
			// Build the membrane from its constituent components
			// Run through the collection of ---- and build them into the model
			ArrayList transforms = bioMightTransforms.getTransforms();
			System.out.println("Have CellMembrane -HawkEye- NumTransforms: " + transforms.size());
	
			for (int i=0; i<transforms.size(); i++)
			{
				// Get the information for the CellMembrane we are creating
				BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
				System.out.println("Creating CellMembrane: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
				this.componentID = bioMightTransform.getId();
	
				if  (localLOD == Constants.MAG1X)
				{
					// We are grabbing our data for the Cell Membrane at this level
					// It will be represented by a simple sphere
					System.out.println("Using CellMembrane MAG1X - HawkEye");
				}	
				else if (localLOD == Constants.MAG2X)
				{
					System.out.println("Using CellMembrane at MAG2X - HawkEye");					
					System.out.println("Creating Cholesterol Collection: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());			
					//cholesterols = new Cholesterols("CellMembraneCholesterol", bioMightTransform.getId(), bioMightMethods);
					
					cholesterols = new Cholesterols("Cholesterol", bioMightTransform.getId(), bioMightMethods);
					initProperty("CellMembraneChloresterol", Constants.Cholesterol, Constants.CholesterolRef, cholesterols.getComponentID());	
						
					//System.out.println("Creating Thromboxanes Collection: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());			
					//thromboxanes = new Thromboxanes(nColonyStrength, "CellMembraneThromboxanes", bioMightTransform.getId(), bioMightMethods);
					//initProperty("CellMembraneThromboxanes", Constants.Thromboxanes, Constants.ThromboxanesRef, thromboxanes.getComponentID());	
					
					//phosphoLipids = new PhosphoLipids();
					//init?Property("PhosphoLipids", Constants.PhosphoLipids, Constants.PhosphoLipidsRef, bioMightTransform.getId());
				}
										
			}
		}
		
		initProperties();
		initMethods();
		
		System.out.println("Create CellMembrane Complete: " + parentID);
		
		// First, get all the data from the database
		// Apply the methods to it
		// Save its state
		if (bioMightMethods != null){
			System.out.println("EXECUTING Cell Membrane METHODS: " + bioMightMethods.size());
			//executeMethods(bioMightMethods);
		}
		
	}
	
		
	
	public void initProperties() {
		
		BioMightScale bioScale = new BioMightScale("0.00, 0.00, 0.00");
		BioMightPosition bioPos = new BioMightPosition("0.00, 0.00, 0.00");		
		String bioTemplate =""; 

		initProperty("--Not Activated-----", Constants.Title, Constants.Title, "", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, true);
		initProperty(Constants.CholesterolsRef, Constants.Cholesterols, Constants.CholesterolsRef, "CellMembrane:0", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, true);
		initProperty(Constants.FibrinRef, Constants.Fibrin, Constants.FibrinRef, "CellMembrane:0", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, true);
		initProperty(Constants.PhosphoLipidsRef, Constants.PhosphoLipids, Constants.PhosphoLipidsRef, "CellMembrane:0", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, true);
		//initProperty(Constants.ReticularConnectiveTissueRef, Constants.ReticularConnectiveTissue, Constants.ReticularConnectiveTissueRef, "CellMembrane:0", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, true);
		initProperty(Constants.ThromboxanesRef, Constants.Thromboxanes, Constants.ThromboxanesRef, "CellMembrane:0", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, true);
	}
	
	
	public void initMethods() {
	
		BioMightMethodView method;
		
		method = new BioMightMethodView();
		method.setCanonicalName(Constants.CellMembrane);
		method.setMethodName("setMaterial");
		method.setDisplayName("Material");
		method.setHtmlType(Constants.BIO_DROPDOWN);
		method.setDataType(Constants.BIO_TEXT);
	 	method.setValueMap(materialDDMap);
		methods.add(method);
		
		method = new BioMightMethodView();
		method.setCanonicalName(Constants.CellMembrane);
		method.setMethodName("setTexture");
		method.setDisplayName("Texture");
		method.setHtmlType(Constants.BIO_DROPDOWN);
		method.setDataType(Constants.BIO_TEXT);
	 	method.setValueMap(textureDDMap);
		methods.add(method);

	}

	
	/*********************************************************************************************
	 * GENERATE 
	 * 
	 * 
	 * @param parentID
	 * @param componentID
	 ********************************************************************************************/
	public void generate(String parentID, String componentID)
	{
		// Generate the CellMembrane
		BioMightCellularBeanLocal bioMightBean;
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Generating the CellMembrane: " + componentID + "    " + parentID);
			InitialContext ctx = new InitialContext();
			//bioMightBean = (BioMightCellularBeanLocal) ctx.lookup("biomight.ejb.BioMightCellularBeanLocal");
			bioMightBean = (BioMightCellularBeanLocal) ctx.lookup("java:global/BioMightWeb/BioMightCellularBean!biomight.ejb.BioMightCellularBeanLocal");
	
			
			double radius = 0.50;

			if (parentID.contains(Constants.ErythrocyteRef))
	   		{
				radius = 0.00125;
				System.out.println("Creating CellMembrane for Erythrocyte: " + radius);
	   		}
			else if (parentID.contains(Constants.TreponemaPallidumRef))
	   		{
	   			radius = 0.0125;
				System.out.println("Created CellMembrane for TreponemaPallidum");
	   		}
			else if (parentID.contains(Constants.VibrioCholeraeRef))
	   		{
	   			radius = 0.0125;
				System.out.println("Created CellMembrane for VibrioCholerae");
	   		}
			else if (parentID.contains(Constants.ClostridiumTetaniRef))
	   		{
	   			radius = 0.0125;
				System.out.println("Created CellMembrane for ClostridiumTetani");
	   		}		
			else if (parentID.contains(Constants.BacillusAnthracisRef))
	   		{
				radius = 0.125;
				System.out.println("Creating CellMembrane for BacillusAnthracis with radius: " + radius);
	   		}
			else if (parentID.contains(Constants.BasophilRef))
	   		{
				radius = 0.95;
				System.out.println("Creating CellMembrane for Basophil with radius: " + radius);
	   		}
			else if (parentID.contains(Constants.AnimalCellRef))
	   		{
				radius = 0.95;
				System.out.println("Creating CellMembrane for AnimalCell with radius: " + radius);
	   		}
			else
			{
				radius = 0.75;
			}
		
			System.out.println("Creating Cell Membrane with Rad : " + radius);
			double[] startPos = {0.0, 0.25, 0.0};
			double[][] currentPoints = BioGraphics.createCylinderInPlane(Constants.XPLANE, startPos, radius, 8);
	
			
			String startID="";
			int success = bioMightBean.generateCellMembrane(1, startID, "CellMembrane", 
						"CellMembrane", componentID, parentID, radius, currentPoints);						
			
			System.out.println("Created CellMembrane Info using EJB : " + radius );   	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - CellMembrane");
			throw new ServerException("Remote Exception CellMembrane():", e); 	
		}
	}
	

	/********************************************************************************************************************
	 * GET X3D
	 * 
	 * This method will return the X3D for the Cell.  It runs through each of its components and collects up their
	 * representations and then assembles them into one unified X3D model.
	 * 
	 ********************************************************************************************************************/
	public String getX3D(boolean snipet) {
		
		// Assembe the CellMembrane
		String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
		"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n " +
		"<X3D profile='Immersive' >\n" +
		"<head>\n" +
		 "<meta name='BioMightImage' content='CellMembrane.jpg'/>\n" +
		 "<meta name='ExportTime' content='7:45:30'/>\n" +
		 "<meta name='ExportDate' content='08/15/2008'/>\n" +
		 "<meta name='BioMight Version' content='1.0'/>\n" + 
		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='CellMembrane'\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		
		
		String body = "";
		if (viewPerspective == Constants.VIEW_INTERNAL) 
		{
			// Run through the collection of CellMembranes and build them into the model
			// In the default case, we get one instance of the CellMembrane for each Cell
			ArrayList transforms = bioMightTransforms.getTransforms();
			System.out.println("In CellMembrane - INTERNAL - Getting X3D: " + transforms.size());
		
			for (int i=0; i<transforms.size(); i++)
			{
				// Get the information for the sclera we are creating
				BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
				//System.out.println("Creating CellMembrane: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());

				if (lod == Constants.MAG1X)
				{		
					
					if (parentID.contains(Constants.ErythrocyteRef)	|| 
						parentID.contains(Constants.TreponemaPallidumRef)	|| 
						parentID.contains(Constants.VibrioCholeraeRef)		||
						parentID.contains(Constants.ClostridiumTetaniRef)		//||
						)
			   		{
					
						System.out.println("Getting MAG1X - Internal - X3D for IFS CellMembrane: " + bioMightTransform.getComponentID());
						//+ bioMightSphere.getTranslation().getYPos());
						//+ bioMightSphere.getTranslation().getZPos());
						// Change the height and width based on the displacement.
				
					 	
						body += "\n<Transform DEF='def"+ bioMightTransform.getId() +"'\n" +
							"translation='" + bioMightTransform.getTranslation().getXPos() + " " 
							+ bioMightTransform.getTranslation().getYPos() + " "
							+ bioMightTransform.getTranslation().getZPos() + "'\n" +
					 	"scale='" 	+ bioMightTransform.getScale().getXPos() + " "
					 				+ bioMightTransform.getScale().getYPos() + " "
					 				+ bioMightTransform.getScale().getZPos() + "'>\n" +
						 	
							"\n<Shape onmouseover=\"showComponent('Cell Membrane');\"  DEF='shape"+ bioMightTransform.getId() + "'\n" +
							" containerField='children'>\n" +
						 	
						    " <Appearance\n" +
						    "  containerField='appearance'>\n";
						    
							
						// 
						if (bioMightTransform.getTextureID() > 0) {
							body+= " <ImageTexture containerField='texture' url='../images/" +
				    			 bioMightTransform.getTextureFile() +  "' />";
		   				}
						else if (parentID.contains(Constants.TreponemaPallidumRef))
						{
						    body+= " <ImageTexture containerField='texture' " +
						    " url='../images/TreponemaPallidum.jpg'/>";
						}
						else if (parentID.contains(Constants.ErythrocyteRef))
						{
						    body+= " <ImageTexture containerField='texture' " +
						    " url='../images/SpeckledFuchsia.png'/>";
						}
						else 
						{
						    body+= " <ImageTexture containerField='texture' " +
								    " url='../images/TreponemaPallidum.jpg'/>";
						}	
						
						
						body+= " <Material DEF='Rust'\n" +
							    "containerField='material'\n" +
							    "ambientIntensity='" + bioMightTransform.getMaterial().getAmbientIntensity() + "'\n" +
							    "shininess='" 		 + bioMightTransform.getMaterial().getShininess() + "'\n" +
							    "transparency='" 	 + bioMightTransform.getMaterial().getTransparency() + "'\n" +
							    "diffuseColor='" + 
							    bioMightTransform.getMaterial().getDiffuseColor().getRed() + " " + 
							    bioMightTransform.getMaterial().getDiffuseColor().getGreen() + " " +
							    bioMightTransform.getMaterial().getDiffuseColor().getBlue() + "'/>\n" +
							 	"</Appearance>\n" +			    
							 	"<IndexedFaceSet DEF='EpitheliumTissueIFS' \n" +
							    	   "containerField='geometry' \n" +
							    	   "creaseAngle='" +  3.12 + "'\n" +
							    	   //"creaseAngle='" +  bioMightTransform.getCreaseAngle() + "'\n" +
			
							    	   "coordIndex='" + bioMightTransform.getCoordindexStr() + "'>" +
							    	   "<Coordinate DEF='EpitheliumTissue_Coord' \n" +
							    	    "containerField='coord' point='" +  bioMightTransform.getCoordpointStr() + "'/>" +
							    	  "</IndexedFaceSet>\n" +
							    	 "</Shape>\n" +
							    	 
							    	 
							"</Transform>\n"; 
						   
			   		}
					else
					{
						System.out.println("Getting MAG1X - Internal - X3D for CellMembrane: " + bioMightTransform.getComponentID());
						//+ bioMightSphere.getTranslation().getYPos());
						//+ bioMightSphere.getTranslation().getZPos());
						// Change the height and width based on the displacement.
						body = "\n<Transform DEF='def"+ bioMightTransform.getId() +"'\n" +
							"translation='" + bioMightTransform.getTranslation().getXPos() + " " 
							+ bioMightTransform.getTranslation().getYPos() + " "
							+ bioMightTransform.getTranslation().getZPos() + "'\n" +
					 	"scale='" 	+ bioMightTransform.getScale().getXPos() + " "
					 				+ bioMightTransform.getScale().getYPos() + " "
					 				+ bioMightTransform.getScale().getZPos() + "'>\n" +
						 	"\n<Shape onmouseover=\"showComponent('Cell Membrane');\"  DEF='shape"+ bioMightTransform.getId() + "'\n" +
						    " containerField='children'>\n" +
						    " <Appearance\n" +
						    "  containerField='appearance'>\n";
						    
						if (bioMightTransform.getTextureID() > 0) {
							body+= " <ImageTexture containerField='texture' url='../images/" +
				    			 bioMightTransform.getTextureFile() +  "' />";
		   				}
										    
						   body += " <Material DEF='Rust'\n" +
						    "containerField='material'\n" +
						    "ambientIntensity='" 	+ bioMightTransform.getMaterial().getAmbientIntensity() + "'\n" +
						    "shininess='" 			+ bioMightTransform.getMaterial().getShininess() + "'\n" +
						    "transparency='" 		+ bioMightTransform.getMaterial().getTransparency() + "'\n" +
						    "diffuseColor='" + 
						    bioMightTransform.getMaterial().getDiffuseColor().getRed() + " " + 
						    bioMightTransform.getMaterial().getDiffuseColor().getGreen() + " " +
						    bioMightTransform.getMaterial().getDiffuseColor().getBlue() + "'/>\n" +
						 	"</Appearance>\n" +
						 	"<Sphere DEF='" + bioMightTransform.getId() + "Sphere'\n" +
						 	"containerField='geometry'\n" +
						 	"radius='" + bioMightTransform.getRadius() +"'/>\n" +
						 	"</Shape>\n" +
					 	"</Transform>\n";						
					}
					
				}
				else if (lod == Constants.MAG2X)
				{
					// Build from the constituent components
					System.out.println("Getting Cholesterols X3D for Cell Membrane:  " + parentID);
					body = cholesterols.getX3D(true);
					System.out.println("Have Cholesterols X3D for Cell Membrane:  " + body);
				}
						
			}
		}	
		else if (viewPerspective == Constants.VIEW_HAWKEYE) 
		{
			// Run through the collection of CellMembranes and build them into the model
			// In the default case, we get one instance of the CellMembrane for each Cell
			ArrayList transforms = bioMightTransforms.getTransforms();
			System.out.println("In CellMembrane - HawkEye - Getting X3D: " + transforms.size());
		
			for (int i=0; i<transforms.size(); i++)
			{
				// Get the information for the sclera we are creating
				BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
				//System.out.println("Creating CellMembrane: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());

				if (lod == Constants.MAG1X)
				{	
					System.out.println("Getting MAG1X - X3D for CellMembrane: " + bioMightTransform.getComponentID());
					//+ bioMightSphere.getTranslation().getYPos());
					//+ bioMightSphere.getTranslation().getZPos());
					// Change the height and width based on the displacement.
					body = "\n<Transform DEF='def"+ bioMightTransform.getId() +"'\n" +
						"translation='" + bioMightTransform.getTranslation().getXPos() + " " 
						+ bioMightTransform.getTranslation().getYPos() + " "
						+ bioMightTransform.getTranslation().getZPos() + "'\n" +
				 	"scale='" 	+ bioMightTransform.getScale().getXPos() + " "
				 				+ bioMightTransform.getScale().getYPos() + " "
				 				+ bioMightTransform.getScale().getZPos() + "'>\n" +
					 	"\n<Shape onmouseover=\"showComponent('Cell Membrane');\" DEF='shape"+ bioMightTransform.getId() + "'\n" +
					    " containerField='children'>\n" +
					    " <Appearance\n" +
					    "  containerField='appearance'>\n";
					    
					// 
					if (bioMightTransform.getTextureID() > 0) {
						body+= " <ImageTexture containerField='texture' url='../images/" +
			    			 bioMightTransform.getTextureFile() +  "' />";
	   				}
					else if (parentID.contains(Constants.TreponemaPallidumRef))
					{
					    body+= " <ImageTexture containerField='texture' " +
					    " url='../images/TreponemaPallidum.jpg'/>";
					}
					else if (parentID.contains(Constants.ErythrocyteRef))
					{
					    body+= " <ImageTexture containerField='texture' " +
					    " url='../images/SpeckledFuchsia.png'/>";
					}
					else 
					{
					    body+= " <ImageTexture containerField='texture' " +
							    " url='../images/TreponemaPallidum.jpg'/>";
					}	
									    
					   body += " <Material DEF='Rust'\n" +
					    "containerField='material'\n" +
					    "ambientIntensity='" 	+ bioMightTransform.getMaterial().getAmbientIntensity() + "'\n" +
					    "shininess='" 			+ bioMightTransform.getMaterial().getShininess() + "'\n" +
					    "transparency='" 		+ bioMightTransform.getMaterial().getTransparency() + "'\n" +
					    "diffuseColor='" + 
					    bioMightTransform.getMaterial().getDiffuseColor().getRed() + " " + 
					    bioMightTransform.getMaterial().getDiffuseColor().getGreen() + " " +
					    bioMightTransform.getMaterial().getDiffuseColor().getBlue() + "'/>\n" +
					 	"</Appearance>\n" +
					 	"<Sphere DEF='" + bioMightTransform.getId() + "Sphere'\n" +
					 	"containerField='geometry'\n" +
					 	"radius='" + bioMightTransform.getRadius() +"'/>\n" +
					 	"</Shape>\n" +
				 	"</Transform>\n"; 
				}
				else if (lod == Constants.MAG2X)
				{
					// Build from the constituent components
					System.out.println("Getting Cholesterols X3D for Cell Membrane:  " + parentID);
					body = cholesterols.getX3D(true);
					System.out.println("Have Cholesterols X3D for Cell Membrane:  " + body);
				}
			}
		}		

		else
		{
			body = "";//						
		}
		
		//System.out.println("CellMembrane X3D: " + body);	
		String footer = "</Scene>" + "</X3D>\n";
		
		if (snipet)
			return body;			
		else	
			return header + body + footer;
	}

	/******************************************************************************************
	 * EXECUTE METHODS 
	 *
	 ******************************************************************************************/
	public void executeMethods(ArrayList<BioMightMethodView> bioMightMethods) {

		// Run through the argument list and executes the 
		// associated methods
		boolean fired = false;
		System.out.println("CellMembrane-Executing Methods: " + bioMightMethods.size());
		for (int j=0; j<bioMightMethods.size(); j++){
			
			// Get the parameter from the list and if it is not
			// empty execute the associated method using it
			BioMightMethodView bioMightMethod = (BioMightMethodView) bioMightMethods.get(j);
			System.out.println("Have BioMightMethod for CellMembrane: " + bioMightMethod.getMethodName());	
			String methodName = bioMightMethod.getMethodName();
			String canonicalName = bioMightMethod.getCanonicalName(); 
			String dataType = bioMightMethod.getDataType();
			String methodParam = bioMightMethod.getMethodParameter(); 
			if (methodParam == null)
				methodParam = "";
			
			// We only execute those methods that are targeted for the CellMembrane
			// If a parameter is specified then we fire the method, otherwise
			// we just jump over it
			if (canonicalName.equals(Constants.CellMembrane)) {				
				if (!methodParam.equals(""))
				{
					System.out.println("Execute Method " + methodName + " with Signature: "  +  dataType);
					System.out.println("with DataType: "  +  dataType  + "   value: " + methodParam);
					
					fired=true;		
					// Use the DataType parameter to convert the data into its base form
				
					if (dataType.equals(Constants.BIO_INT)) {
						
						try {
							System.out.println("Locating Method(Integer)" + methodName);
							// 	Locate the method through introspection
							int numElements = Integer.parseInt(methodParam);
							Class paramsType[] = {int.class};
							Method method = this.getClass().getDeclaredMethod(methodName, paramsType);
							System.out.println("Before Execute Method(Integer)" + methodName);
							Object result = method.invoke(this, numElements);
							System.out.println("Before Execute Method(Integer)" + methodName);	
						}
						catch (NumberFormatException e)
						{
							System.out.println("Could not Convert to int: " + methodParam);						
						}
						catch (NoSuchMethodException e)
						{
							System.out.println("Method with int param not found: " + e);						
						}	
						catch (Exception e)
						{
							System.out.println("General Exception occurred: " + e);						
						}										
					}
					else if (dataType.equals("double")) {
					
						try {
							System.out.println("Locating Method(Double)" + methodName);
						// Locate the method through introspection
							double numElements = Double.parseDouble(methodParam);
							if (numElements > 0.0)
							{
								Class paramsType[] = {double.class};
								Method method = this.getClass().getDeclaredMethod(methodName, paramsType);
								System.out.println("Before Execute Method(Double)" + methodName);
								Object result = method.invoke(this, numElements);
								System.out.println("Before Execute Method(Double)" + methodName);
							}
							System.out.println("Not Executing Double - 0.0"); 
						
							
						}
							catch (NumberFormatException e)
							{
								System.out.println("Could not Convert to double: " + methodParam);						
							}
							catch (NoSuchMethodException e)
							{
								System.out.println("Method with double param not found: " + e);						
							}	
							catch (Exception e)
							{
								System.out.println("General Exception: " + e);						
							}										
					}
					else if (dataType.equals(Constants.BIO_TEXT)) {
						
						
						try {
							System.out.println("Locating Method(String)");
							
							Class paramsType[] = {String.class};
							Method method = this.getClass().getDeclaredMethod(methodName, paramsType );
							System.out.println("Located Method with StringParam: " + methodName + "   " + methodParam);
							
							System.out.println("Before Execute Method(String)" + methodName);
							Object result = method.invoke(this, methodParam);
							System.out.println("After Execute Method(String)" + methodName);
									
						}
						catch (NoSuchMethodException e)
						{
							System.out.println("Method with String param not found!");						
						}	
						catch (Exception e)
						{
							System.out.println("General Exception: " + e.toString());						
						}	
						
					}
					else if (dataType.equals("")) {
					}			
				}	
			}
			if (fired)
			{	
				System.out.println("Methods have fired.");
				//save();
			}
		}
	}
	
	
	/*****************************************************************************
	 * SET Radius
	 * 
	 * Set the size of the CellMembrane
	 * 
	 *****************************************************************************/
	public void setRadius(double size) {

		if (size == 0.0)
			size = 0.5;
		
		System.out.println("Setting CellMembrane Radius: " + size);
		ArrayList transforms = bioMightTransforms.getTransforms();
		for (int i=0; i<transforms.size(); i++)
		{
			// Get the information for the pupil we are creating
			BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
			System.out.println("Updating CellMembrane Radius: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
			bioMightTransform.setRadius(size);
			
			// Store the updated information back into the transformation
			transforms.set(i,bioMightTransform);
			System.out.println("Updated CellMembrane Radius");
		}		
		
	}


	/*****************************************************************************
	 * SET COLOR - Sets the color of the CellMembrane
	 * 
	 * Set the color of the CellMembrane
	 * 
	 *****************************************************************************/
	public void setMembraneColor(String color) {

		int numColor = BioWebUtils.mapColor(color);
		if (numColor > 0)
		{
			try {
				// Get the information from the database via the Enterprise Bean		
				System.out.println("Setting Membrane Color to: " + color + " for: " + parentID);
				InitialContext ctx = new InitialContext();
				BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
				int returnCode = bioMightBean.setMaterial(parentID, numColor);
				System.out.println("Color is set: " + returnCode);   	
			}catch (Exception e) { 
				System.out.println("Exception Setting Cell Membrane Color");
				throw new ServerException("Remote Exception setColor():", e); 	
			}
		}
	}
	

	/*****************************************************************************
	 * SET TEXTURE - Sets the color of the CellMembrane
	 * 
	 * Set the color of the CellMembrane
	 * 
	 *****************************************************************************/
	public void setMembraneTexture(String textureName) {

		System.out.println("Setting Membrane Texture to: " + textureName);
		int textureId = 0;
		for (int i=0; i<textures.size(); i++)
		{
			BioMightTexture texture = (BioMightTexture) textures.get(i);
			if (textureName.equals(texture.getTextureName()))
				textureId = texture.getTextureId();
		}
		System.out.println("Setting Membrane Texture to ID: " + textureId);
		
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Setting Membrane Texture to: " + textureId + " for: " + parentID);
			InitialContext ctx = new InitialContext();
			BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
			
			int returnCode = bioMightBean.setTexture(parentID, textureId);
			System.out.println("Texture is set: " + returnCode);   	
			
		}catch (Exception e) { 
			System.out.println("Exception Setting Cell Membrane Texture");
			throw new ServerException("Remote Exception Texture():", e); 	
		}

	}
	

	/*****************************************************************************
	 * SAVE 
	 * 
	 * This mmethod writes the Transform information back into the database.
	 * This is called after a series of methods are executed against the 
	 * existing object
	 * 
	 *****************************************************************************/
	private void save() {		
		
		BioMightTransform bioMightTransform = null;
		ArrayList transforms = bioMightTransforms.getTransforms();
		System.out.println("Saving Tranforms for CellMembrane: " +  transforms.size());
		for (int i=0; i<transforms.size(); i++) {
			// Get the information for the pupil we are creating
			bioMightTransform = (BioMightTransform) transforms.get(i);
			System.out.println("Updating CellMembrane Tranforms: " + bioMightTransform.getName() + "  " + bioMightTransform.getId()); 
			//System.out.println("CellMembrane Tranforms Radius is: " + bioMightTransform.getName() + "  " + bioMightTransform.getRadius());
		}
		
				
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Saving CellMembrane Data");
			InitialContext ctx = new InitialContext();
			BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
			int returnCode = bioMightBean.updateComponent(Constants.CellMembraneRef, parentID, bioMightTransform);;
			System.out.println("Have BioMight EJB");  	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - Back");
			throw new ServerException("Remote Exception getComponents():", e); 	
		}
		
	}

	/*************************************************************************
	 * OnContact
	 * 
	 * When the cell membrane comes in contact with an object, they exchange
	 * the exchange is reflected here.
	 ************************************************************************/
	
	public void onContact(Object obj)
	{	
		// Check if a virus is making contact with
		// the GastroIntestinal components

		if (obj instanceof Perforins)
		{
			// Form a channel through the cell membrane
			// this leads to loss of cell contents and death
		}

		if (obj instanceof Granzymes)
		{
			// Protease that degrades the proteins in the cell membrane
			// leading to rupture and loss of cell contents
			// If there are enough of them, a=]nd the time is sustained, then
			// theoretically, the reactions should take place.
			// Lyse the membrane
		}
	}

	
	public void rupture()
	{
		// Rupture open a hole in the membrane at the point of most weakness
		
	}
	
	public void setVoltageGradient()
	{
	}



	
}
