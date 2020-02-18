/*
 * Created on Aug 16, 2011
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
 
package biomight.system.skeletal.ribs;

import java.util.ArrayList;

import javax.naming.InitialContext;

import biomight.BioMightBase;
import biomight.Constants;
import biomight.cell.extracellularmatrixsecretion.Osteocytes;
import biomight.ejb.BioMightBeanLocal;
import biomight.ejb.BioMightSkeletalBeanLocal;
import biomight.exceptions.ServerException;
import biomight.system.tissue.epithelial.EpitheliumTissue;
import biomight.util.BioGraphics;
import biomight.view.BioMightMethodView;
import biomight.view.BioMightPosition;
import biomight.view.BioMightPropertyView;
import biomight.view.BioMightScale;
import biomight.view.BioMightTransform;


/**
 * @author SurferJim
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */

public class Rib extends BioMightBase {
	private ArrayList<BioMightPropertyView> properties;
	private ArrayList<BioMightMethodView> methods;
	protected Osteocytes osteocytes;

	public Rib()
	{
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, Constants.BasilarArteryRef, null, null);
	}
	
	public Rib(String parentID)
	{
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, parentID, null, null);
	}
	
	public Rib(int localVP, int localLOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
	{
		create(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);
	}
	
	/*****************************************************************
	 * CREATE
	 * 
	 * @param parentID
	 * @param bioMightMethods
	 ******************************************************************/
	public void create(int localVP, int localLOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
	{
		BioMightScale bioScale = new BioMightScale("0.00, 0.00, 0.00");
		BioMightPosition  bioPos = new BioMightPosition("0.00, 0.00, 0.00");
		String bioTemplate="Rib.x3d";
		
		// We are running through the collection, the child is passed
		// into this method
		componentID=parentID;
		
		//System.out.println("Creating Rib for: " + parentID);
		componentID = parentID;
		if (localVP == Constants.VIEW_INTERNAL)	
		{
			// Do nothing.  We are instantiating as part of a collection  
			// There is no drill down, so we use the transforms that the
			// parent has already collected
			//System.out.println("In Rib Create() - ViewInternal - Already Set: " + parentID);				
			
			// We already have the data for the current instance of Rib,
			// Go get the details for the current Rib is LOD is set
			if (localLOD == Constants.MAG1X)
			{
				
				// Generate the Rib Epithelium if needed 
				boolean bGenerate = false;
				if (bGenerate) {
					generate(parentID, componentID);
				}
			
				//System.out.println("Creating Rib Osteocytes Objects: " + parentID);				
				osteocytes = new Osteocytes("RibOsteocyte", parentID, bioMightMethods);
				//System.out.println("Rib Instance is created : " + parentID);
			}
			else if (localLOD == Constants.MAG2X)
			{
				// Go get the finer details of the Rib				
				//System.out.println("Getting the Rib MAG2X : " + parentID);
				localVP = Constants.VIEW_INTERNAL; 
				localLOD = Constants.MAG1X;		
			
				// If we have initialization parameters from the form, 
				//  then apply them before constructing the objects.
				if (bioMightMethods != null){
					//System.out.println("NEED TO EXECUTE Calyx METHODS: " + bioMightMethods.size());
				}
				
				// Generate the Rib Epithelium if needed 
				boolean bGenerate = false;
				if (bGenerate) {
					generate(parentID, componentID);
				}
			
				//System.out.println("Creating Rib Osteocytes Objects: " + parentID);				
				osteocytes = new Osteocytes("RibOsteocyte", parentID, bioMightMethods);
				//System.out.println("Rib Instance is created : " + parentID);


			}
			
			//paceMakerCells = new PaceMakerCells(parentID);				
			//System.out.println("Rib Instance is created : " + parentID);
		} 
		else if (localVP == Constants.VIEW_DETACHED  || localVP == Constants.VIEW_HAWKEYE)
		{
			
			//***************************************************************
			//***************************************************************
			// ON the drill down go into the detail for now on a single cell
			// HACK
			localLOD = Constants.MAG1X;
			//***************************************************************
			//***************************************************************
		
			// This is when one is accessing a Rib directly
			// Get the information from the database via the Enterprise Bean		
			try {
				// Get the information from the database via the Enterprise Bean		
				//System.out.println("Getting HawkEye RibInfo for ParentID: " + parentID);
				InitialContext ctx = new InitialContext();
				BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
				bioMightTransforms = bioMightBean.getComponent(parentID);
				
				//System.out.println("Have Rib Info from EJB");   	
			}catch (Exception e) { 
				System.out.println("Exception Getting Components - Rib");
				throw new ServerException("Remote Exception getComponents():", e); 	
			}
			
			if (bioMightMethods != null){
				//executeMethods(bioMightMethods);
			}
			
			// Run through the collection of BacilliAnthracis and build them into the model
			// In the default case, we get one instance of the Rib for each eye
			ArrayList transforms = bioMightTransforms.getTransforms();
			//System.out.println("Rib NumTransforms: " + transforms.size());
			for (int i=0; i<transforms.size(); i++)
			{
				// Get the information for the Rib
				BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
		
				// A hack, I am using the values down below in the X3D method to set some appearance  and material values
				//gbioMightTransform  = bioMightTransform;
			
				//System.out.println("Creating Rib: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
				this.componentID = bioMightTransform.getId();

		
				if (localLOD == Constants.MAG1X)
				{
					//System.out.println("Creating Rib at HawkEye MAG1X - Just Init Properties: " + parentID);
					// initialize the Properties

					// Go get the finer details of the Rib				
					//System.out.println("Creating Rib at HawkEye MAG2X : " + parentID);
					localVP = Constants.VIEW_INTERNAL; 
					localLOD = Constants.MAG1X;

					// Do the Epithelial layer
					localLOD = Constants.MAG2X;
			
					//System.out.println("Creating Rib Osteocytes Objects: " + parentID);				
					osteocytes = new Osteocytes("RibOsteocyte", parentID, bioMightMethods);
					//System.out.println("Rib Instance is created : " + parentID);
				}
				if (localLOD == Constants.MAG2X)
				{
					// Go get the finer details of the Rib				
					//System.out.println("Creating Rib at HawkEye MAG2X : " + parentID);
					localVP = Constants.VIEW_INTERNAL; 
					localLOD = Constants.MAG1X;

					// Do the Epithelial layer
					localLOD = Constants.MAG2X;
					//System.out.println("Creating Rib Osteocytes Objects: " + parentID);				
					osteocytes = new Osteocytes("RibOsteocyte", parentID, bioMightMethods);
					//System.out.println("Rib Instance is created : " + parentID);
				}
				
			}
		}		
		else 
		{
	
		}

		//initProperties();
		//initMethods();
	
	}
	
	
	/******************************************************************
	 * GENERATE RIB
	 *  
	 *  In the default mapping Ribs01-Rib11 map to the left side
	 *  while Ribs12-23 map to the right side
	 *   
	 * @param parentID
	 * @param componentID
	 ******************************************************************/

	public void generate(String parentID, String componentID)
	{
		// Generate the Ventricle Endothelium		
		BioMightSkeletalBeanLocal bioMightBean;
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Generating the Rib - Osteocytes: " + componentID + "    " + parentID);
			InitialContext ctx = new InitialContext();
			bioMightBean = (BioMightSkeletalBeanLocal) ctx.lookup("java:global/BioMightWeb/BioMightSkeletalBean!biomight.ejb.BioMightSkeletalBeanLocal");
	
			double radius = 0.25;
		
			/*
			if (parentID.equals("Rib:01")) 
			{	
				// Generate the Rib Osteocytes
				double[] startPos = {0.50, -7.75, -5.0};		
				double[][] currentPoints = BioGraphics.createCylinderInPlane(Constants.XPLANE, startPos, radius, 8);
	
				System.out.println("Calling Generate RibOsteocyte: " + componentID + "    " + parentID);				
				int success = bioMightBean.generateRib("RibOsteocyte:00001", "RibOsteocyte", 
					"RibOsteocyte", componentID, parentID, currentPoints);			
					
			}
			else if (parentID.equals("Rib:02")) 
			{	
				// Generate the Rib
				double[] startPos = {0.50, -8.75, -5.20};
				double[][] currentPoints = BioGraphics.createCylinderInPlane(Constants.XPLANE, startPos, radius, 8);
				
				System.out.println("Calling Generate Rib Osteocyte: " + componentID + "    " + parentID);
				int success = bioMightBean.generateRib("RibOsteocyte:00360", "RibOsteocyte", 
					"RibOsteocyte", componentID, parentID, currentPoints);			
					
			}
			else if (parentID.equals("Rib:03")) 
			{	
				// Generate the Rib
				double[] startPos = {0.50, -9.75, -5.60};
				double[][] currentPoints = BioGraphics.createCylinderInPlane(Constants.XPLANE, startPos, radius, 8);
				
				System.out.println("Calling Generate Rib Osteocyte: " + componentID + "    " + parentID);
				int success = bioMightBean.generateRib("RibOsteocyte:00620", "RibOsteocyte", 
					"RibOsteocyte", componentID, parentID, currentPoints);			
			}
			*/
			if (parentID.equals("Rib:04")) 
			{	
				// Generate the Rib
				double[] startPos = {0.50, -10.8, -6.05};
				double[][] currentPoints = BioGraphics.createCylinderInPlane(Constants.XPLANE, startPos, radius, 8);
				
				
				//System.out.println("Calling Generate Rib Osteocyte: " + componentID + "    " + parentID);
				int success = bioMightBean.generateRib("RibOsteocyte:00980", "RibOsteocyte", 
					"RibOsteocyte", componentID, parentID, currentPoints);			
					
			}
			if (parentID.equals("Rib:05")) 
			{	
				// Generate the Rib
				double[] startPos = {0.50,-12.0, -6.10};	
				double[][] currentPoints = BioGraphics.createCylinderInPlane(Constants.XPLANE, startPos, radius, 8);
				
	
				//System.out.println("Calling Generate Rib Osteocyte: " + componentID + "    " + parentID);
				int success = bioMightBean.generateRib("RibOsteocyte:01240", "RibOsteocyte", 
					"RibOsteocyte", componentID, parentID, currentPoints);			
					
			}
			else if (parentID.equals("Rib:06")) 
			{	
				// Generate the Rib
				double[] startPos = {0.50,-13.0, -6.10};
				double[][] currentPoints = BioGraphics.createCylinderInPlane(Constants.XPLANE, startPos, radius, 8);
				
	
				//System.out.println("Calling Generate Rib Osteocyte: " + componentID + "    " + parentID);
				int success = bioMightBean.generateRib("RibOsteocyte:01500", "RibOsteocyte", 
					"RibOsteocyte", componentID, parentID, currentPoints);			
					
			}
			
			else if (parentID.equals("Rib:07")) 
			{	
				// Generate the Rib
				double[] startPos = {0.50,-14.0, -6.35};
				double[][] currentPoints = BioGraphics.createCylinderInPlane(Constants.XPLANE, startPos, radius, 8);
				
	
				//System.out.println("Calling Generate Rib Osteocyte: " + componentID + "    " + parentID);
				int success = bioMightBean.generateRib("RibOsteocyte:01880", "RibOsteocyte", 
					"RibOsteocyte", componentID, parentID, currentPoints);			
					
			}
			/*
			else if (parentID.equals("Rib:08")) 
			{	
				// Generate the Rib
				double[] startPos = {0.50, -15.15, -5.80};
				double[][] currentPoints = BioGraphics.createCylinderInPlane(Constants.XPLANE, startPos, radius, 8);
				
	
				//System.out.println("Calling Generate Rib Osteocyte: " + componentID + "    " + parentID);
				int success = bioMightBean.generateRib("RibOsteocyte:02120", "RibOsteocyte", 
					"RibOsteocyte", componentID, parentID, currentPoints);			
					
			}
			else if (parentID.equals("Rib:09")) 
			{	
				// Generate the Rib
				double[] startPos = {0.50, -16.2, -6.05};
				double[][] currentPoints = BioGraphics.createCylinderInPlane(Constants.XPLANE, startPos, radius, 8);
				
	
				//System.out.println("Calling Generate Rib Osteocyte: " + componentID + "    " + parentID);
				int success = bioMightBean.generateRib("RibOsteocyte:02380", "RibOsteocyte", 
					"RibOsteocyte", componentID, parentID, currentPoints);			
					
			}
			else if (parentID.equals("Rib:10")) 
			{	
				// Generate the Rib
				double[] startPos = {0.50,-17.35, -6.0};
				double[][] currentPoints = BioGraphics.createCylinderInPlane(Constants.XPLANE, startPos, radius, 8);
				
				//System.out.println("Calling Generate Rib Osteocyte: " + componentID + "    " + parentID);
				int success = bioMightBean.generateRib("RibOsteocyte:02640", "RibOsteocyte", 
					"RibOsteocyte", componentID, parentID, currentPoints);			
					
			}
			else if (parentID.equals("Rib:11")) 
			{	
				// Generate the Rib
				double[] startPos = {0.50, -18.5, -5.65};
				double[][] currentPoints = BioGraphics.createCylinderInPlane(Constants.XPLANE, startPos, radius, 8);

	
				//System.out.println("Calling Generate Rib Osteocyte: " + componentID + "    " + parentID);
				int success = bioMightBean.generateRib("RibOsteocyte:02900", "RibOsteocyte", 
					"RibOsteocyte", componentID, parentID, currentPoints);			
					
			}
			

			if (parentID.equals("Rib:12")) 
			{	
				// Generate the Rib Osteocytes
				double[] startPos = {0.50,-19.5, -5.45};
				double[][] currentPoints = BioGraphics.createCylinderInPlane(Constants.XPLANE, startPos, radius, 8);
				
				//System.out.println("Calling Generate RibOsteocyte: " + componentID + "    " + parentID);
				int success = bioMightBean.generateRib("RibOsteocyte:03260", "RibOsteocyte", 
					"RibOsteocyte", componentID, parentID, currentPoints);			
					
			}			
			
			
			/**************************************************
			 * Do the Right side
			 * 
			 ************************************************/
			/*
			else if (parentID.equals("Rib:13")) 
			{	
				// Generate the Rib
				double[] startPos = {-0.50, -7.75, -5.0};	
				double[][] currentPoints = BioGraphics.createCylinderInPlane(Constants.XPLANE, startPos, radius, 8);
				//System.out.println("Calling Generate Rib Osteocyte: " + componentID + "    " + parentID);
				
				int success = bioMightBean.generateRib("RibOsteocyte:05000", "RibOsteocyte", 
					"RibOsteocyte", componentID, parentID, currentPoints);			
					
			}
			else if (parentID.equals("Rib:14")) 
			{	
				// Generate the Rib
				double[] startPos = {-0.50, -8.75, -5.20};
				double[][] currentPoints = BioGraphics.createCylinderInPlane(Constants.XPLANE, startPos, radius, 8);
				
				//System.out.println("Calling Generate Rib Osteocyte: " + componentID + "    " + parentID);
			
				
				int success = bioMightBean.generateRib("RibOsteocyte:05400", "RibOsteocyte", 
					"RibOsteocyte", componentID, parentID, currentPoints);			
					
			}
			else if (parentID.equals("Rib:15")) 
			{	
				// Generate the Rib
				double[] startPos = {-0.50, -9.75, -5.60};
				double[][] currentPoints = BioGraphics.createCylinderInPlane(Constants.XPLANE, startPos, radius, 8);
				
				//System.out.println("Calling Generate Rib Osteocyte: " + componentID + "    " + parentID);
				
				int success = bioMightBean.generateRib("RibOsteocyte:05800", "RibOsteocyte", 
					"RibOsteocyte", componentID, parentID, currentPoints);			
					
			}
			else if (parentID.equals("Rib:16")) 
			{	
				// Generate the Rib
				double[] startPos = {-0.50, -10.8, -6.05};
				double[][] currentPoints = BioGraphics.createCylinderInPlane(Constants.XPLANE, startPos, radius, 8);
	
				//System.out.println("Calling Generate Rib Osteocyte: " + componentID + "    " + parentID);
				
				int success = bioMightBean.generateRib("RibOsteocyte:06200", "RibOsteocyte", 
					"RibOsteocyte", componentID, parentID, currentPoints);			
					
			}		
			else if (parentID.equals("Rib:17")) 
			{	
				// Generate the Rib
				double[] startPos = {-0.50,-12.0, -6.10};
				double[][] currentPoints = BioGraphics.createCylinderInPlane(Constants.XPLANE, startPos, radius, 8);
	
				//System.out.println("Calling Generate Rib Osteocyte: " + componentID + "    " + parentID);
				
				int success = bioMightBean.generateRib("RibOsteocyte:06600", "RibOsteocyte", 
					"RibOsteocyte", componentID, parentID, currentPoints);			
					
			}
			else if (parentID.equals("Rib:18")) 
			{	
				// Generate the Rib
				double[] startPos = {-0.50,-13.0, -6.10};
				double[][] currentPoints = BioGraphics.createCylinderInPlane(Constants.XPLANE, startPos, radius, 8);
	
				//System.out.println("Calling Generate Rib Osteocyte: " + componentID + "    " + parentID);
				
				int success = bioMightBean.generateRib("RibOsteocyte:07000", "RibOsteocyte", 
					"RibOsteocyte", componentID, parentID, currentPoints);			
					
			}		
			else if (parentID.equals("Rib:19")) 
			{	
				// Generate the Rib
				double[] startPos = {-0.50,-14.0, -6.35};
				double[][] currentPoints = BioGraphics.createCylinderInPlane(Constants.XPLANE, startPos, radius, 8);
	
				//System.out.println("Calling Generate Rib Osteocyte: " + componentID + "    " + parentID);
				
				int success = bioMightBean.generateRib("RibOsteocyte:07400", "RibOsteocyte", 
					"RibOsteocyte", componentID, parentID, currentPoints);			
					
			}
			else if (parentID.equals("Rib:20")) 
			{	
				// Generate the Rib
				double[] startPos = {-0.50, -15.15, -5.80};
				double[][] currentPoints = BioGraphics.createCylinderInPlane(Constants.XPLANE, startPos, radius, 8);
	
				//System.out.println("Calling Generate Rib Osteocyte: " + componentID + "    " + parentID);
				
				int success = bioMightBean.generateRib("RibOsteocyte:07800", "RibOsteocyte", 
					"RibOsteocyte", componentID, parentID, currentPoints);			
					
			}
			else if (parentID.equals("Rib:21")) 
			{	
				// Generate the Rib
				double[] startPos = {-0.50, -16.2, -6.05};
				double[][] currentPoints = BioGraphics.createCylinderInPlane(Constants.XPLANE, startPos, radius, 8);
	
				//System.out.println("Calling Generate Rib Osteocyte: " + componentID + "    " + parentID);
				
				int success = bioMightBean.generateRib("RibOsteocyte:08200", "RibOsteocyte", 
					"RibOsteocyte", componentID, parentID, currentPoints);			
					
			}
			else if (parentID.equals("Rib:22")) 
			{	
				// Generate the Rib
				double[] startPos = {-0.50,-17.35, -6.0};
				double[][] currentPoints = BioGraphics.createCylinderInPlane(Constants.XPLANE, startPos, radius, 8);
	
				//System.out.println("Calling Generate Rib Osteocyte: " + componentID + "    " + parentID);
				
				int success = bioMightBean.generateRib("RibOsteocyte:08600", "RibOsteocyte", 
					"RibOsteocyte", componentID, parentID, currentPoints);			
					
			}		
			else if (parentID.equals("Rib:23")) 
			{	
				// Generate the Rib
				double[] startPos = {-0.50, -18.5, -5.65};
				double[][] currentPoints = BioGraphics.createCylinderInPlane(Constants.XPLANE, startPos, radius, 8);
	
				//System.out.println("Calling Generate Rib Osteocyte: " + componentID + "    " + parentID);
				
				int success = bioMightBean.generateRib("RibOsteocyte:09000", "RibOsteocyte", 
					"RibOsteocyte", componentID, parentID, currentPoints);			
					
			}
			*/
			else if (parentID.equals("Rib:24")) 
			{	
				// Generate the Rib
				double[] startPos = {-0.50,-19.5, -5.45};
				double[][] currentPoints = BioGraphics.createCylinderInPlane(Constants.XPLANE, startPos, radius, 8);
	
				//System.out.println("Calling Generate Rib Osteocyte: " + componentID + "    " + parentID);
				
				int success = bioMightBean.generateRib("RibOsteocyte:09400", "RibOsteocyte", 
					"RibOsteocyte", componentID, parentID, currentPoints);			
					
			}				
			else if (parentID.equals("")) 
			{	
				System.out.println("RibOsteocyte NoParent");
							
			}
			else 
			{	
				System.out.println("Skipping Rib ");
							
			}
			
			//System.out.println("Created Ventricle Rib Osteocyte Info using EJB");   	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - RibOsteocyte");
			throw new ServerException("Remote Exception RibOsteocyte():", e); 	
		}
	}

	
	
	
	
	public void initProperties() {

		properties = new ArrayList<BioMightPropertyView>();
		
		BioMightPropertyView property = new BioMightPropertyView();
		property.setPropertyName("AnteriorLigament");
		property.setCanonicalName(Constants.AnteriorLigament);
		properties.add(property);
	
		property = new BioMightPropertyView();
		property.setPropertyName("PosteriorLigament");
		property.setCanonicalName(Constants.PosteriorLigament);
		properties.add(property);		
	}
	
	
	public void initMethods() {
		
		BioMightMethodView method = new BioMightMethodView();
		method = new BioMightMethodView();
		method.setCanonicalName(Constants.Rib);
		method.setMethodName("setRibColor");
		method.setDisplayName("Color");
		method.setHtmlType(Constants.BIO_DROPDOWN);
		method.setDataType(Constants.BIO_INT);
	 	method.setValueMap(materialDDMap);
		methods.add(method);
		
		method = new BioMightMethodView();
		method.setCanonicalName(Constants.Rib);
		method.setMethodName("setRibTexture");
		method.setDisplayName("Texture");
		method.setHtmlType(Constants.BIO_DROPDOWN);
		method.setDataType(Constants.BIO_INT);
	 	method.setValueMap(textureDDMap);
		methods.add(method);		
	}
	
	
	/********************************************************************************************************************
	 * GET X3D
	 * 
	 * This method will return the X3D for the Rib.  It runs through each of its components and collects up their
	 * representations and then assembles them into one unified X3D model.
	 * 
	 ********************************************************************************************************************/
	public String getX3D(boolean snipet) {
		
		// Assemble the Rib
		String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
		"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n " +
		"<X3D profile='Immersive' >\n" +
		"<head>\n" +
		 "<meta name='BioMightImage' content='Rib.jpg'/>\n" +
		 "<meta name='ExportTime' content='7:45:30'/>\n" +
		 "<meta name='ExportDate' content='08/15/2008'/>\n" +
		 "<meta name='BioMight Version' content='1.0'/>\n" + 
		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='Rib'\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		

		String body = "";	
		//System.out.println("Getting Rib X3D");
		if (viewPerspective == Constants.VIEW_INTERNAL) {
			//System.out.println("Getting Rib Osteocytes X3D");
			body = osteocytes.getX3D(true); 
		}
		else if (viewPerspective == Constants.VIEW_DETACHED) {
			//System.out.println("Getting Rib Osteocytes X3D");
			body = osteocytes.getX3D(true); 

			body+= "<Viewpoint DEF='Viewpoint_Rib'\n" +
					 "description='Viewpoint1'\n" +
					 "jump='true'\n" +
					 "fieldOfView='0.785'\n" +
					 "position='0.0 -12.0 20.0'\n" +
					 "orientation='0 0 1 0'/>\n";
		}
		else if (viewPerspective == Constants.VIEW_HAWKEYE) {
			//System.out.println("Getting Rib Osteocytes X3D");
			body = osteocytes.getX3D(true); 
			
			body+= "<Viewpoint DEF='Viewpoint_Rib'\n" +
					 "description='Viewpoint1'\n" +
					 "jump='true'\n" +
					 "fieldOfView='0.785'\n" +
					 "position='0.0 -12.0 20.0'\n" +
					 "orientation='0 0 1 0'/>\n";
		}
		else
		{
			body = osteocytes.getX3D(true); 
		}
		
		String footer = "</Scene>" + "</X3D>\n";
		
		if (snipet)
			return body;			
		else	
			return header + body + footer;
	}	
	
	
	
	
	/*****************************************************************************
	 * SET LUNG COLOR
	 * 
	 * Set the color of the Ribs
	 * 
	 *****************************************************************************/
	public void setRibColor(int material) {
		System.out.println("Setting Color for Rib: " + parentID + "  " + material);
		setMaterial(material, parentID); 
	}

	/*****************************************************************************
	 * SET LUNG TEXTURE
	 * 
	 * Set the color of the Texture
	 * 
	 *****************************************************************************/
	public void setRibTexture(int material) {
		System.out.println("Setting Texture for Rib: " + parentID + "  " + material);
		setTexture(material, parentID); 
	}
}
