/*
 * Created on Apr 24, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.body.organ.pancreas;
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
import biomight.body.organ.Organ;


/**
 * @author SurferJim
 *
 *  The Common Bile Duck
 *
 */

public class AccessoryPancreaticDuct extends Organ {
	private EpitheliumTissue epithelium;
	
	
	/*********************************************************************************
	 * CONSTRUCTORS
	 *
	 *********************************************************************************/
	
	public AccessoryPancreaticDuct()
	{
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, Constants.AccessoryPancreaticDuctRef, null, null);
	}

	public AccessoryPancreaticDuct(String parentID)
	{
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, parentID, null, null);
	}

	public AccessoryPancreaticDuct(int vp, int LOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
	{
		System.out.print("Calling AccessoryPancreaticDuct Create");
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
		this.setImage("images/PancreaticDuct.jpg");
				
	
		// Get the information from the database via the Enterprise Bean		
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Getting AccessoryPancreaticDuctInfo for ParentID: " + parentID);
			InitialContext ctx = new InitialContext();
			BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
			bioMightTransforms = bioMightBean.getComponents(Constants.AccessoryPancreaticDuctRef, parentID);
			System.out.println("Have AccessoryPancreaticDuct Info from EJB");   	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - AccessoryPancreaticDuct");
			throw new ServerException("Remote Exception getComponents():", e); 	
		}
		
		int localVP = Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
	
		// Run through AccessoryPancreaticDuct and build its components into the model
		ArrayList transforms = bioMightTransforms.getTransforms();
		System.out.println("AccessoryPancreaticDuct NumTransforms: " + transforms.size());
		for (int i=0; i<transforms.size(); i++)
		{
			// Get the information for the AccessoryPancreaticDuct we are creating
			BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
			System.out.println("Have AccessoryPancreaticDuct (name,id): " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
			componentID=bioMightTransform.getId();
	
			// Build the model based on what you are looking based on LOD
			viewPerspective = Constants.VIEW_HAWKEYE;
			if (viewPerspective == Constants.VIEW_HAWKEYE)
			{			
				// Generate the AccessoryPancreaticDuct Epithelium if needed 
				boolean bGenerate = false;
				if (bGenerate) {
					generate(parentID, componentID);
				}
			
				
				String startID = "PancreaticDuctEpithelium:00001";
				System.out.println("HawkEye - Creating AccessoryPancreaticDuct Epithelium: " + parentID + "  startID: " + startID);				
				epithelium = new EpitheliumTissue(localVP, localLOD, startID, "AccessoryPancreaticDuctEpithelium",  Constants.EpitheliumTissueRef, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
				initProperty(bioMightTransform.getName(), Constants.EpitheliumTissue, Constants.EpitheliumTissueRef, epithelium.getComponentID());
			}
			else if (viewPerspective == Constants.VIEW_INTERNAL)
			{	
				//gallBladderFundus = new AccessoryPancreaticDuctFundus(bioMightTransform.getId(), bioMightMethods);
				//initProperty(bioMightTransform.getName(), Constants.PancreaticDuctFundus, Constants.PancreaticDuctFundusRef, epithelium.getComponentID());
				}
			else
			{
				System.out.println("UnMatched Perspective.... ");
			}
			
			
			System.out.println("AccessoryPancreaticDuct Epithelium completed");			
		}		

	
		//initProperties();
		initMethods();
	}
	

	
	
	public void generate(String parentID, String componentID)
	{
		// Generate the AccessoryPancreaticDuct Epithelium		
		BioMightBeanLocal bioMightBean;
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Generating the AccessoryPancreaticDuct ParentID: " + parentID);
			InitialContext ctx = new InitialContext();
			bioMightBean = (BioMightBeanLocal) ctx.lookup("java:global/BioMightWeb/BioMightBean!biomight.ejb.BioMightBeanLocal");
			
			double radius = 0.078;
				
			// Generate the AccessoryPancreaticDuct
			double[] startPos = {-3.350, -23.5, -4.70};
			double[] orient = {0.0, 0.0, 0.05};
			double[][] currentPoints = BioGraphics.createCylinderInPlane(Constants.XPLANE, startPos, radius, 8);
			
			int success = bioMightBean.generateAccessoryPancreaticDuct("AccessoryPancreaticDuctEpithelium:00001", 
				"AccessoryPancreaticDuctEpithelium", 
				"AccessoryPancreaticDuctEpithelium", componentID, parentID, currentPoints);			
			
			System.out.println("Created AccessoryPancreaticDuctEpithelium Info using EJB");   	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - AccessoryPancreaticDuctEpithelium");
			throw new ServerException("Remote Exception getComponents():", e); 	
		}
	}
	
	
	public ArrayList getProperties() {

		// SURFACES
		BioMightPropertyView property = new BioMightPropertyView();
		property.setPropertyName("Surfaces");
		property.setCanonicalName(Constants.Title);
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
		 "<meta name='BioMightImage' content='PancreaticDuct.jpg'/>\n" +
		 "<meta name='ExportTime' content='7:45:30'/>\n" +
		 "<meta name='ExportDate' content='08/15/2008'/>\n" +
		 "<meta name='BioMight Version' content='1.0'/>\n" + 
		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='PancreaticDuct'\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		

		
		String body = "";
		int viewPerspective = Constants.VIEW_HAWKEYE;
		if (viewPerspective == Constants.VIEW_HAWKEYE)
		{			
			body = epithelium.getX3D(true);
		}
		else if (viewPerspective == Constants.VIEW_INTERNAL)
		{	
			body = "";
		}
		else
		{}
				
		//System.out.println("PancreaticDuct X3D: " + body);		
		String footer = "</Scene>" + "</X3D>\n";
		
		
		if (snipet)
			return body;			
		else	
			return header + body + footer;
	}


	


}


