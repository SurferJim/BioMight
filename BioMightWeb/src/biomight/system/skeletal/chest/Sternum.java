/*
 * Created on Oct 15, 2004
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.system.skeletal.chest;

import biomight.Constants;
import biomight.cell.extracellularmatrixsecretion.Osteocytes;
import biomight.ejb.BioMightBeanLocal;
import biomight.ejb.BioMightSkeletalBeanLocal;
import biomight.exceptions.ServerException;
import biomight.system.tissue.connective.bone.Bone;
import biomight.util.BioGraphics;
import biomight.view.BioMightMethodView;
import biomight.view.BioMightPosition;
import biomight.view.BioMightPropertyView;
import biomight.view.BioMightScale;
import biomight.view.BioMightTransform;

import java.util.ArrayList;

import javax.naming.InitialContext;



/*******************************************************************************************
 * @author SurferJim 01/23/2017
 *
 * Representation of the Sternum
 * 
 ******************************************************************************************/

public class Sternum extends Bone {
	private Osteocytes osteocytes;
	
	
	public Sternum()
	{
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, Constants.SternumRef, null, null);
	}

	public Sternum(String parentID)
	{
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, parentID, null, null);
	}

	public Sternum(int hierarchy, int LOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
	{
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
		this.setImage("images/Sternum.jpg");
		this.setImageWidth(300);
		this.setImageHeight(325);

		// Get the information from the database via the Enterprise Bean		
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Getting SternumInfo for ParentID: " + parentID);
			InitialContext ctx = new InitialContext();
			BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
			bioMightTransforms = bioMightBean.getComponents(Constants.SternumRef, parentID);
			//System.out.println("Have Sternum Info from EJB");   	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - Sternum");
			throw new ServerException("Remote Exception getComponents():", e); 	
		}
		
		int localVP = Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;

		BioMightScale bioScale = new BioMightScale("0.00, 0.00, 0.00");
		BioMightPosition  bioPos = new BioMightPosition("0.00, 0.00, 0.00");
		String bioTemplate="Sternum.x3d";
			
		// Run through the collection of Sternums and build them into the model
		// In the default case, we get one instance of the Sternum for each eye
		ArrayList transforms = bioMightTransforms.getTransforms();
		System.out.println("Sternum NumTransforms: " + transforms.size());
		for (int i=0; i<transforms.size(); i++)
		{			
			// Get the information for the Sternum we are creating
			BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
			System.out.println("Created Sternum: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
			this.componentID = bioMightTransform.getId();
			
			if (localVP == Constants.VIEW_HAWKEYE) {
				
				// Generate the Sternum Epihelium if needed 
				boolean bGenerate = false;
				if (bGenerate) {
					generate(parentID, componentID);
				}
						
				System.out.println("Creating Sternum Osteocytes:" + bioMightTransform.getId());		
				osteocytes = new Osteocytes("SternumOsteocyte", bioMightTransform.getId(), bioMightMethods);
				initProperty("SternumOsteocyte", Constants.Osteocytes, Constants.OsteocytesRef, osteocytes.getComponentID());				
				System.out.println("Sternum Osteocytes completed: " + bioMightTransform.getId());		
	
				localVP = Constants.VIEW_HAWKEYE;;
				localLOD = Constants.MAG1X;
				
				//paceMakerCells = new PaceMakerCells(parentID);				
				System.out.println("Sternum Instance is created : " + componentID + "    parent: " +  parentID);
			}
			//else if (localVP == Constants.VIEW_FLOATING) {
			else {


				System.out.println("Creating Sternum Osteocytes:" + bioMightTransform.getId());		
				osteocytes = new Osteocytes("SternumOsteocyte", bioMightTransform.getId(), bioMightMethods);
				initProperty("SternumOsteocyte", Constants.Osteocytes, Constants.OsteocytesRef, osteocytes.getComponentID());				
				System.out.println("Sternum Osteocytes completed: " + bioMightTransform.getId());			
			}
				
		}
		//initProperties();
		initMethods();
		
		System.out.println("Create Sternum Completed");
		
		// First, get all the data from the database
		// Apply the methods to it
		// Save its state
		if (bioMightMethods != null){
			System.out.println("EXECUTING Sternum METHODS: " + bioMightMethods.size());
			//executeMethods(bioMightMethods);
		}
	}
		
		/*******************************************************************
		 * generate the Sternum
		 * 
		 * @param parentID
		 * @param componentID
		 ****************************************************************/
		
		public void generate(String parentID, String componentID)
		{
			// Generate the SternumOsteocytes		
			BioMightSkeletalBeanLocal bioMightBean;
			try {
				// Get the information from the database via the Enterprise Bean		
				System.out.println("Generating the SternumOsteocytes: " + componentID + "    " + parentID);
				InitialContext ctx = new InitialContext();
				bioMightBean = (BioMightSkeletalBeanLocal) ctx.lookup(Constants.SkeletalBeanRef);
		
				double radius = 0.025;
						
				// Generate the Right SternumOsteocytes
				double[] startPos = {0.0, -9.50, -0.65};
				double[][] currentPoints = BioGraphics.createCylinderInPlane(Constants.YPLANE, startPos, radius, 8);
				
				System.out.println("Calling Generate SternumOsteocyte Loop: " + componentID + "    " + parentID);
				int success = bioMightBean.generateSternum("SternumOsteocyte:00001", "SternumOsteocyte", 
					"SternumOsteocyte", componentID, parentID, currentPoints);	
		
			
				System.out.println("Created SternumOsteocytes Info using EJB");   	
			}catch (Exception e) { 
				System.out.println("Exception Getting Components - SternumOsteocytes");
				throw new ServerException("Remote Exception getComponents():", e); 	
			}
		}
		
		
	public void initProperties() {
		BioMightPropertyView property = new BioMightPropertyView();
		property.setPropertyName("Stapes ---");
		property.setCanonicalName(Constants.LeftEar);
		properties.add(property);			
	}
	
	
	public void initMethods() {

		BioMightMethodView method;

		method = new BioMightMethodView();
		method.setMethodName("Deafness");
		method.setHtmlType("checkbox");
		methods.add(method);	
		
		method = new BioMightMethodView();
		method.setMethodName("Hear");
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
		
		// Assemble the Sternum
		String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
		"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n " +
		"<X3D profile='Immersive' >\n" +
		"<head>\n" +
		 "<meta name='BioMightImage' content='Sternum.jpg'/>\n" +
		 "<meta name='ExportTime' content='7:45:30'/>\n" +
		 "<meta name='ExportDate' content='08/15/2008'/>\n" +
		 "<meta name='BioMight Version' content='1.0'/>\n" + 
		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='Sternum'\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		

		String body = osteocytes.getX3D(true);
		
		//System.out.println("Sternum X3D: " + body);		
		String footer = "</Scene>" + "</X3D>\n";

		body+= "<Viewpoint DEF='Viewpoint_Sternum'\n" +
				 "description='Viewpoint1'\n" +
				 "jump='true'\n" +
				 "fieldOfView='0.785'\n" +
				 "position='0.0 -14.0 25.0'\n" +
				 "orientation='0 0 1 0'/>\n";
		
		if (snipet)
			return body;			
		else	
			return header + body + footer;
	}
	
}
