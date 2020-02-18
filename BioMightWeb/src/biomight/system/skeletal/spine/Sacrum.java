/*
 * Created on Oct 15, 2004
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.system.skeletal.spine;

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
 * Representation of the Sacrum
 * 
 ******************************************************************************************/

public class Sacrum extends Bone {
	private Osteocytes osteocytes;
	private SacralVertebrae sacralVertebrae;
	
	
	
	public Sacrum()
	{
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, Constants.BasilarArteryRef, null, null);
	}

	public Sacrum(String parentID)
	{
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, parentID, null, null);
	}

	public Sacrum(int localVP, int localLOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
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
		this.setImage("images/Sacrum.jpg");
		this.setImageWidth(300);
		this.setImageHeight(325);

		// Get the information from the database via the Enterprise Bean		
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Getting SacrumInfo for ParentID: " + parentID);
			InitialContext ctx = new InitialContext();
			BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
			bioMightTransforms = bioMightBean.getComponents(Constants.SacrumRef, parentID);
			System.out.println("Have Sacrum Info from EJB");   	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - Sacrum");
			throw new ServerException("Remote Exception getComponents():", e); 	
		}
		
		localVP = Constants.VIEW_HAWKEYE;
		localLOD = Constants.MAG1X;

		BioMightScale bioScale = new BioMightScale("0.00, 0.00, 0.00");
		BioMightPosition  bioPos = new BioMightPosition("0.00, 0.00, 0.00");
		String bioTemplate="Sacrum.x3d";
			
		// Run through the collection of Sacrums and build them into the model
		// In the default case, we get one instance of the Sacrum for each eye
		ArrayList transforms = bioMightTransforms.getTransforms();
		System.out.println("Sacrum NumTransforms: " + transforms.size());
		for (int i=0; i<transforms.size(); i++)
		{			
			// Get the information for the Sacrum we are creating
			BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
			System.out.println("Created Sacrum: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
			this.componentID = bioMightTransform.getId();
			
			if (localVP == Constants.VIEW_HAWKEYE) {
				
				// Generate the Sacrum Epihelium if needed 
				boolean bGenerate = false;
				if (bGenerate) {
					generate(parentID, componentID);
				}
		
				localVP = Constants.VIEW_HAWKEYE;;
				localLOD = Constants.MAG1X;

				// Go get the finer details of the Sacrum				
				System.out.println("Getting the Sacrum MAG2X : " + parentID);
				localVP = Constants.VIEW_INTERNAL; 
				localLOD = Constants.MAG1X;			
				
				System.out.println("Creating Sacrum Osteocytes for:" + parentID);		
				osteocytes = new Osteocytes("SacrumOsteocyte", parentID, bioMightMethods);
				initProperty("SacrumOsteocyte", Constants.Osteocytes, Constants.OsteocytesRef, osteocytes.getComponentID());				
				System.out.println("Sacrum Osteocytes completed: " + parentID);
								
				//paceMakerCells = new PaceMakerCells(parentID);				
				System.out.println("Sacrum Instance is created : " + componentID + "    parent: " +  parentID);
			} 
			else if (localVP == Constants.VIEW_FLOATING) {
				

			
			}
				
		}
		//initProperties();
		initMethods();
		
		System.out.println("Create Sacrum Completed");
		
		// First, get all the data from the database
		// Apply the methods to it
		// Save its state
		if (bioMightMethods != null){
			System.out.println("EXECUTING Sacrum METHODS: " + bioMightMethods.size());
			//executeMethods(bioMightMethods);
		}
	}
		
		/*******************************************************************
		 * generate the Sacrum
		 * 
		 * @param parentID
		 * @param componentID
		 ****************************************************************/
		
		public void generate(String parentID, String componentID)
		{
			// Generate the SacrumOsteocytes		
			BioMightSkeletalBeanLocal bioMightBean;
			try {
				// Get the information from the database via the Enterprise Bean		
				System.out.println("Generating the SacrumOsteocytes: " + componentID + "    " + parentID);
				InitialContext ctx = new InitialContext();
				bioMightBean = (BioMightSkeletalBeanLocal) ctx.lookup(Constants.SkeletalBeanRef);
		
				double radius = 0.15;
			
				if (parentID.equals("Abdomen:01")) 
				{	
					// Generate the Left SacrumOsteocytes
					double[] startPos = {1.0, -29.75, -7.5};
					double[][] currentPoints = BioGraphics.createCylinderInPlane(Constants.XPLANE, startPos, radius, 8);
				
					System.out.println("Calling Generate SacrumOsteocyte: " + componentID + "    " + parentID);	
					int success = bioMightBean.generateSacrum("SacrumOsteocyte:00001", "SacrumOsteocyte", 
							"IliumLeft", componentID, parentID, currentPoints);								

				}			
	
				else if (parentID.equals("")) 
				{	
					System.out.println("Calling Generate SacrumOsteocytes NoParent");
								
				}
				
				System.out.println("Created SacrumOsteocytes Info using EJB");   	
			}catch (Exception e) { 
				System.out.println("Exception Getting Components - SacrumOsteocytes");
				throw new ServerException("Remote Exception getComponents():", e); 	
			}
		}
		
	
	
	public void redraw(String parentID)
	{
		/*int viewPerspective = Constants.VIEW_FLOATING;
		if (viewPerspective == Constants.VIEW_FLOATING) {
			System.out.println("Sclera Eye is created");
		} 
		else if (viewPerspective == Constants.VIEW_INTERNAL) {
		}
		*/
		
		System.out.println("Sacrum Redraw");
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
	 * This method will return the X3D for the Cell.  It runs through each of its components and collects up their
	 * representations and then assembles them into one unified X3D model.
	 * 
	 ********************************************************************************************************************/
	public String getX3D(boolean snipet) {
		
		// Assemble the Sacrum
		String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
		"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n " +
		"<X3D profile='Immersive' >\n" +
		"<head>\n" +
		 "<meta name='BioMightImage' content='Nose.jpg'/>\n" +
		 "<meta name='ExportTime' content='7:45:30'/>\n" +
		 "<meta name='ExportDate' content='08/15/2008'/>\n" +
		 "<meta name='BioMight Version' content='1.0'/>\n" + 
		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='Sacrum'\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		

		String body = osteocytes.getX3D(true);
		
		//System.out.println("Sacrum X3D: " + body);		
		String footer = "</Scene>" + "</X3D>\n";
		
		if (snipet)
			return body;			
		else	
			return header + body + footer;
	}
	
}
