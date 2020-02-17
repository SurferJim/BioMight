/*
 * Created on Aug 16, 2011
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
 
package biomight.system.cartilage;

import java.util.ArrayList;

import javax.naming.InitialContext;

import biomight.BioMightBase;
import biomight.Constants;
import biomight.ejb.BioMightTissueBeanLocal;
import biomight.exceptions.ServerException;
import biomight.system.tissue.Tissues;
import biomight.system.tissue.connective.ConnectiveTissue;
import biomight.util.BioGraphics;
import biomight.view.BioMightMethodView;
import biomight.view.BioMightPosition;
import biomight.view.BioMightPropertyView;
import biomight.view.BioMightScale;


/**
 * @author SurferJim
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */

public class CostalCartilage extends BioMightBase {
	protected ConnectiveTissue connectiveTissue;

	
	public CostalCartilage()
	{
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, Constants.ConnectiveTissueRef, null, null);
	}

	public CostalCartilage(String parentID)
	{
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, parentID, null, null);
	}

	public CostalCartilage(int hierarchy, int LOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
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
		
		this.setImage("images/CostalCartilage.gif");
		setImageWidth(200);
		setImageHeight(150);
		
		BioMightScale bioScale = new BioMightScale("0.00, 0.00, 0.00");
		BioMightPosition bioPos = new BioMightPosition("0.00, 0.00, 0.00");

		String bioTemplate="CostalCartilage.x3d";
		
		
		// We are running through the collection, the child is passed
		// into this method
		componentID=parentID;
		
		viewPerspective = Constants.VIEW_FLOATING;
		if (viewPerspective == Constants.VIEW_FLOATING) {
			
			// If we have initialization parameters from the form, 
			//  then apply them before constructing the objects.
			if (bioMightMethods != null){
				System.out.println("NEED TO EXECUTE CostalCartilage METHODS: " + bioMightMethods.size());
			}
			
			// Generate the Heart Ventricle Endothelium if needed 
			boolean bGenerate = false;
			if (bGenerate) {
				generate(parentID, componentID);
			}
	
			System.out.println("Creating CostalCartilage Tissues: " + parentID);				
			connectiveTissue = new ConnectiveTissue("CostalCartilageTissue", localVP, localLOD, parentID, bioMightProperties, bioMightMethods);
			//System.out.println("CostalCartilage Instance is created : " + parentID);
		} 
		else if (viewPerspective == Constants.VIEW_INTERNAL) {
	
		}

		//initProperties();
		initMethods();
	
	}
	
	
	/******************************************************************
	 * GENERATE COSTAL CARTILAGE
	 *  
	 *  In the default mapping CostalCartilages01-CostalCartilage11 map to the left side
	 *  while CostalCartilages12-23 map to the right side
	 *   
	 * @param parentID
	 * @param componentID
	 ******************************************************************/

	public void generate(String parentID, String componentID)
	{
		// Generate the Ventricle Endothelium		
		BioMightTissueBeanLocal bioMightBean;
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Generating the CostalCartilage - Tissues: " + componentID + "    " + parentID);
			InitialContext ctx = new InitialContext();
			bioMightBean = (BioMightTissueBeanLocal) ctx.lookup(Constants.TissueBeanRef);
	
			double radius = 0.25;
		
			
			if (parentID.equals("CostalCartilage:01")) 
			{	
				// Generate the CostalCartilage s
				double[] startPos = {1.5, -10.15, -0.35};		
				double[][] currentPoints = BioGraphics.createCylinderInPlane(Constants.XPLANE, startPos, radius, 8);
	
				System.out.println("Calling Generate CostalCartilage: " + componentID + "    " + parentID);				
				int success = bioMightBean.generateCostalCartilage("CostalCartilageTissue:00001", "CostalCartilageTissue", 
					"CostalCartilageTissue", componentID, parentID, currentPoints);			
					
			}
			else if (parentID.equals("CostalCartilage:02")) 
			{	
				// Generate the CostalCartilage
				double[] startPos = {1.650, -11.90, -0.07};
				double[][] currentPoints = BioGraphics.createCylinderInPlane(Constants.XPLANE, startPos, radius, 8);
				
				System.out.println("Calling Generate CostalCartilage : " + componentID + "    " + parentID);
				int success = bioMightBean.generateCostalCartilage("CostalCartilageTissue:00360", "CostalCartilageTissue", 
					"CostalCartilageTissue", componentID, parentID, currentPoints);			
					
			}
			else if (parentID.equals("CostalCartilage:03")) 
			{	
				// Generate the CostalCartilage
				double[] startPos = {2.25, -13.48, 0.45};
				double[][] currentPoints = BioGraphics.createCylinderInPlane(Constants.XPLANE, startPos, radius, 8);
				
				System.out.println("Calling Generate CostalCartilage : " + componentID + "    " + parentID);
				int success = bioMightBean.generateCostalCartilage("CostalCartilageTissue:00620", "CostalCartilageTissue", 
					"CostalCartilageTissue", componentID, parentID, currentPoints);			
			}
			else if (parentID.equals("CostalCartilage:04")) 
			{	
				// Generate the CostalCartilage
				double[] startPos = {2.60, -14.5, 0.25};
				double[][] currentPoints = BioGraphics.createCylinderInPlane(Constants.XPLANE, startPos, radius, 8);
				
				
				System.out.println("Calling Generate CostalCartilage : " + componentID + "    " + parentID);
				int success = bioMightBean.generateCostalCartilage("CostalCartilageTissue:00980", "CostalCartilageTissue", 
					"CostalCartilageTissue", componentID, parentID, currentPoints);			
					
			}
			else if (parentID.equals("CostalCartilage:05")) 
			{	
				// Generate the CostalCartilage
				double[] startPos = {3.0,-16.0, 0.2};	
				double[][] currentPoints = BioGraphics.createCylinderInPlane(Constants.XPLANE, startPos, radius, 8);
				
	
				System.out.println("Calling Generate CostalCartilage : " + componentID + "    " + parentID);
				int success = bioMightBean.generateCostalCartilage("CostalCartilageTissue:01240", "CostalCartilageTissue", 
					"CostalCartilageTissue", componentID, parentID, currentPoints);			
					
			}
			else if (parentID.equals("CostalCartilage:06")) 
			{	
				// Generate the CostalCartilage
				double[] startPos = {3.5,-16.95, 0.50};
				double[][] currentPoints = BioGraphics.createCylinderInPlane(Constants.XPLANE, startPos, radius, 8);
				
	
				System.out.println("Calling Generate CostalCartilage : " + componentID + "    " + parentID);
				int success = bioMightBean.generateCostalCartilage("CostalCartilageTissue:01500", "CostalCartilageTissue", 
					"CostalCartilageTissue", componentID, parentID, currentPoints);			
					
			}
			else if (parentID.equals("CostalCartilage:07")) 
			{	
				// Generate the CostalCartilage
				double[] startPos = {4.65,-18.0, -0.20};
				double[][] currentPoints = BioGraphics.createCylinderInPlane(Constants.XPLANE, startPos, radius, 8);
				
	
				System.out.println("Calling Generate CostalCartilage : " + componentID + "    " + parentID);
				int success = bioMightBean.generateCostalCartilage("CostalCartilageTissue:01880", "CostalCartilageTissue", 
					"CostalCartilageTissue", componentID, parentID, currentPoints);			
					
			}
			
			else if (parentID.equals("CostalCartilage:08")) 
			{	
				// Generate the CostalCartilage
				double[] startPos = {6.0, -18.70, -0.756};
				double[][] currentPoints = BioGraphics.createCylinderInPlane(Constants.XPLANE, startPos, radius, 8);
				
	
				System.out.println("Calling Generate CostalCartilage : " + componentID + "    " + parentID);
				int success = bioMightBean.generateCostalCartilage("CostalCartilageTissue:02120", "CostalCartilageTissue", 
					"CostalCartilageTissue", componentID, parentID, currentPoints);			
					
			}
			else if (parentID.equals("CostalCartilage:09")) 
			{	
				// Generate the CostalCartilage
				double[] startPos = {6.250, -19.35, -1.25};
				double[][] currentPoints = BioGraphics.createCylinderInPlane(Constants.XPLANE, startPos, radius, 8);
				
	
				System.out.println("Calling Generate CostalCartilage : " + componentID + "    " + parentID);
				int success = bioMightBean.generateCostalCartilage("CostalCartilageTissue:02380", "CostalCartilageTissue", 
					"CostalCartilageTissue", componentID, parentID, currentPoints);			
					
			}
			else if (parentID.equals("CostalCartilage:10")) 
			{	
				// Generate the CostalCartilage
				double[] startPos = {6.150, -20.30, -1.76};
				double[][] currentPoints = BioGraphics.createCylinderInPlane(Constants.XPLANE, startPos, radius, 8);
				
				System.out.println("Calling Generate CostalCartilageTissue : " + componentID + "    " + parentID);
				int success = bioMightBean.generateCostalCartilage("CostalCartilageTissue:02640", "CostalCartilageTissue", 
					"CostalCartilageTissue", componentID, parentID, currentPoints);			
					
			}
			
			/*
			else if (parentID.equals("CostalCartilage:11")) 
			{	
				// Generate the CostalCartilage
				double[] startPos = {0.50, -18.5, -2.5};
				double[][] currentPoints = BioGraphics.createCylinderInPlane(Constants.XPLANE, startPos, radius, 8);

	
				System.out.println("Calling Generate CostalCartilage : " + componentID + "    " + parentID);
				int success = bioMightBean.generateCostalCartilage("CostalCartilageTissue:02900", "CostalCartilageTissue", 
					"CostalCartilageTissue", componentID, parentID, currentPoints);			
					
			}
			else if (parentID.equals("CostalCartilage:12")) 
			{	
				// Generate the CostalCartilage s
				double[] startPos = {0.50,-19.5, -2.5};
				double[][] currentPoints = BioGraphics.createCylinderInPlane(Constants.XPLANE, startPos, radius, 8);
				
				System.out.println("Calling Generate CostalCartilage: " + componentID + "    " + parentID);
				int success = bioMightBean.generateCostalCartilage("CostalCartilageTissue:03260", "CostalCartilageTissue", 
					"CostalCartilageTissue", componentID, parentID, currentPoints);			
					
			}			
			
		
			else if (parentID.equals("CostalCartilage:13")) 
			{	
				// Generate the CostalCartilage
				double[] startPos = {-1.5, -10.15, -0.35};	
				double[][] currentPoints = BioGraphics.createCylinderInPlane(Constants.XPLANE, startPos, radius, 8);
				System.out.println("Calling Generate CostalCartilage : " + componentID + "    " + parentID);
				
				int success = bioMightBean.generateCostalCartilage("CostalCartilageTissue:05000", "CostalCartilageTissue", 
					"CostalCartilageTissue", componentID, parentID, currentPoints);			
					
			}
			else if (parentID.equals("CostalCartilage:14")) 
			{	
				// Generate the CostalCartilage
				double[] startPos =  {-1.650, -11.90, -0.07};
				double[][] currentPoints = BioGraphics.createCylinderInPlane(Constants.XPLANE, startPos, radius, 8);
				
				System.out.println("Calling Generate CostalCartilageTissue : " + componentID + "    " + parentID);
			
				
				int success = bioMightBean.generateCostalCartilage("CostalCartilageTissue:05400", "CostalCartilageTissue", 
					"CostalCartilageTissue", componentID, parentID, currentPoints);			
					
			}
			else if (parentID.equals("CostalCartilage:15")) 
			{	
				// Generate the CostalCartilage
				double[] startPos = {-2.25, -13.48, 0.45};
				double[][] currentPoints = BioGraphics.createCylinderInPlane(Constants.XPLANE, startPos, radius, 8);
				
				System.out.println("Calling Generate CostalCartilageTissue : " + componentID + "    " + parentID);
				
				int success = bioMightBean.generateCostalCartilage("CostalCartilageTissue:05800", "CostalCartilageTissue", 
					"CostalCartilageTissue", componentID, parentID, currentPoints);			
					
			}
			else if (parentID.equals("CostalCartilage:16")) 
			{	
				// Generate the CostalCartilage
				double[] startPos = {-2.60, -14.5, 0.25};
				double[][] currentPoints = BioGraphics.createCylinderInPlane(Constants.XPLANE, startPos, radius, 8);
	
				System.out.println("Calling Generate CostalCartilageTissue : " + componentID + "    " + parentID);
				
				int success = bioMightBean.generateCostalCartilage("CostalCartilageTissue:06200", "CostalCartilageTissue", 
					"CostalCartilageTissue", componentID, parentID, currentPoints);			
					
			}		
			else if (parentID.equals("CostalCartilage:17")) 
			{	
				// Generate the CostalCartilage
				double[] startPos = {-3.0,-16.0, 0.2};
				double[][] currentPoints = BioGraphics.createCylinderInPlane(Constants.XPLANE, startPos, radius, 8);
	
				System.out.println("Calling Generate CostalCartilageTissue : " + componentID + "    " + parentID);
				
				int success = bioMightBean.generateCostalCartilage("CostalCartilageTissue:06600", "CostalCartilageTissue", 
					"CostalCartilageTissue", componentID, parentID, currentPoints);			
					
			}
			else if (parentID.equals("CostalCartilage:18")) 
			{	
				// Generate the CostalCartilageTissue
				double[] startPos = {-3.5,-16.95, 0.50};
				double[][] currentPoints = BioGraphics.createCylinderInPlane(Constants.XPLANE, startPos, radius, 8);
	
				System.out.println("Calling Generate CostalCartilageTissue : " + componentID + "    " + parentID);
				
				int success = bioMightBean.generateCostalCartilage("CostalCartilageTissue:07000", "CostalCartilageTissue", 
					"CostalCartilageTissue", componentID, parentID, currentPoints);			
					
			}		
			else if (parentID.equals("CostalCartilage:19")) 
			{	
				// Generate the CostalCartilage
				double[] startPos = {-4.50,-18.025, 0.0};
				double[][] currentPoints = BioGraphics.createCylinderInPlane(Constants.XPLANE, startPos, radius, 8);
	
				System.out.println("Calling Generate CostalCartilageTissue : " + componentID + "    " + parentID);
				
				int success = bioMightBean.generateCostalCartilage("CostalCartilageTissue:07400", "CostalCartilageTissue", 
					"CostalCartilageTissue", componentID, parentID, currentPoints);			
					
			}
			else if (parentID.equals("CostalCartilage:20")) 
			{	
				// Generate the CostalCartilage
				double[] startPos = {-6.0, -18.86, -0.25};
				double[][] currentPoints = BioGraphics.createCylinderInPlane(Constants.XPLANE, startPos, radius, 8);
	
				System.out.println("Calling Generate CostalCartilageTissue : " + componentID + "    " + parentID);
				
				int success = bioMightBean.generateCostalCartilage("CostalCartilageTissue:07800", "CostalCartilageTissue", 
					"CostalCartilageTissue", componentID, parentID, currentPoints);			
					
			}
			else if (parentID.equals("CostalCartilage:21")) 
			{	
				// Generate the CostalCartilage
				double[] startPos = {-6.250, -20.0, -0.75};
				double[][] currentPoints = BioGraphics.createCylinderInPlane(Constants.XPLANE, startPos, radius, 8);
	
				System.out.println("Calling Generate CostalCartilageTissue : " + componentID + "    " + parentID);
				
				int success = bioMightBean.generateCostalCartilage("CostalCartilageTissue:08200", "CostalCartilageTissue", 
					"CostalCartilageTissue", componentID, parentID, currentPoints);			
					
			}
			else if (parentID.equals("CostalCartilage:22")) 
			{	
				// Generate the CostalCartilage
				double[] startPos = {-6.50, -21.35, -2.5};
				double[][] currentPoints = BioGraphics.createCylinderInPlane(Constants.XPLANE, startPos, radius, 8);
	
				System.out.println("Calling Generate CostalCartilage : " + componentID + "    " + parentID);
				
				int success = bioMightBean.generateCostalCartilage("CostalCartilageTissue:08600", "CostalCartilageTissue", 
					"CostalCartilageTissue", componentID, parentID, currentPoints);			
					
			}		
			else if (parentID.equals("CostalCartilage:23")) 
			{	
				// Generate the CostalCartilage
				double[] startPos = {-0.50, -18.5, -2.5};
				double[][] currentPoints = BioGraphics.createCylinderInPlane(Constants.XPLANE, startPos, radius, 8);
	
				System.out.println("Calling Generate CostalCartilage : " + componentID + "    " + parentID);
				
				int success = bioMightBean.generateCostalCartilage("CostalCartilageTissue:09000", "CostalCartilageTissue", 
					"CostalCartilageTissue", componentID, parentID, currentPoints);			
					
			}
			else if (parentID.equals("CostalCartilage:24")) 
			{	
				// Generate the CostalCartilage
				double[] startPos = {-0.50,-19.5, -2.5};
				double[][] currentPoints = BioGraphics.createCylinderInPlane(Constants.XPLANE, startPos, radius, 8);
	
				System.out.println("Calling Generate CostalCartilage : " + componentID + "    " + parentID);
				
				int success = bioMightBean.generateCostalCartilage("CostalCartilage:09400", "CostalCartilageTissue", 
					"CostalCartilageTissue", componentID, parentID, currentPoints);			
					
			}	
			*/
			
			else if (parentID.equals("")) 
			{	
				System.out.println("CostalCartilage NoParent");
							
			}
			else 
			{	
				System.out.println("Skipping CostalCartilage ");
							
			}
		
			
			
			System.out.println("Created Ventricle CostalCartilage  Info using EJB");   	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - CostalCartilage");
			throw new ServerException("Remote Exception CostalCartilage():", e); 	
		}
	}

	
	
	public void initProperties() {

		properties = new ArrayList<BioMightPropertyView>();
		
		BioMightPropertyView property = new BioMightPropertyView();
		property.setPropertyName("AnteriorCartilage");
		property.setCanonicalName(Constants.CostalCartilage);
		properties.add(property);
			
	}
	
	
	public void initMethods() {

		methods = new ArrayList<BioMightMethodView>();
		
		BioMightMethodView method = new BioMightMethodView();

		method = new BioMightMethodView();
		method.setMethodName("Bend");
		method.setHtmlType("text");
		method.setDataType("boolean");
		methods.add(method);		
	}
	
	
	/********************************************************************************************************************
	 * GET X3D
	 * 
	 * This method will return the X3D for the CostalCartilage.  It runs through each of its components and collects up their
	 * representations and then assembles them into one unified X3D model.
	 * 
	 ********************************************************************************************************************/
	public String getX3D(boolean snipet) {
		
		// Assemble the CostalCartilage
		String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
		"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n " +
		"<X3D profile='Immersive' >\n" +
		"<head>\n" +
		 "<meta name='BioMightImage' content='CostalCartilage.jpg'/>\n" +
		 "<meta name='ExportTime' content='7:45:30'/>\n" +
		 "<meta name='ExportDate' content='08/15/2008'/>\n" +
		 "<meta name='BioMight Version' content='1.0'/>\n" + 
		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='CostalCartilage'\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		

		String body = connectiveTissue.getX3D(true);  
		//System.out.println("CostalCartilage X3D: " + body);		
		
		String footer = "</Scene>" + "</X3D>\n";
		
		if (snipet)
			return body;			
		else	
			return header + body + footer;
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

	
	
	
}
