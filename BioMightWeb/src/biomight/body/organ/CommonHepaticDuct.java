/*
 * Created on Apr 24, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.body.organ;
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

public class CommonHepaticDuct extends Organ {
	private EpitheliumTissue epithelium;
	
	
	/*********************************************************************************
	 * CONSTRUCTORS
	 *
	 *********************************************************************************/
	
	public CommonHepaticDuct()
	{
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, Constants.CommonHepaticDuctRef, null, null);
	}

	public CommonHepaticDuct(String parentID)
	{
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, parentID, null, null);
	}

	public CommonHepaticDuct(int vp, int LOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
	{
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
		this.setImage("images/CommonHepaticDuct.jpg");
				
	
		// Get the information from the database via the Enterprise Bean		
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Getting CommonHepaticDuctInfo for ParentID: " + parentID);
			InitialContext ctx = new InitialContext();
			BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
			bioMightTransforms = bioMightBean.getComponents(Constants.CommonHepaticDuctRef, parentID);
			System.out.println("Have CommonHepaticDuct Info from EJB");   	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - CommonHepaticDuct");
			throw new ServerException("Remote Exception getComponents():", e); 	
		}
		
		int localVP = Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
	
		// Run through CommonHepaticDuct and build its components into the model
		ArrayList transforms = bioMightTransforms.getTransforms();
		System.out.println("CommonHepaticDuct NumTransforms: " + transforms.size());
		for (int i=0; i<transforms.size(); i++)
		{
			// Get the information for the CommonHepaticDuct we are creating
			BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
			System.out.println("Have CommonHepaticDuct (name,id): " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
			componentID=bioMightTransform.getId();
	
			// Build the model based on what you are looking based on LOD
			viewPerspective = Constants.VIEW_HAWKEYE;
			if (viewPerspective == Constants.VIEW_HAWKEYE)
			{			
				// Generate the CommonHepaticDuct Epithelium if needed 
				boolean bGenerate = false;
				if (bGenerate) {
					generate(parentID, componentID);
				}
			
				String startID = "CommonHepaticDuctEpithelium:00001";
				System.out.println("HawkEye - Creating CommonHepaticDuct Epithelium: " + parentID + "  startID: " + startID);				
				epithelium = new EpitheliumTissue(localVP, localLOD, startID, "CommonHepaticDuctEpithelium",  Constants.EpitheliumTissueRef, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
				initProperty(bioMightTransform.getName(), Constants.EpitheliumTissue, Constants.EpitheliumTissueRef, epithelium.getComponentID());
			}
			else if (viewPerspective == Constants.VIEW_INTERNAL)
			{	
				String startID = "CommonHepaticDuctEpithelium:00001";
				System.out.println("Internal - Creating CommonHepaticDuct Epithelium: " + parentID + "  startID: " + startID);				
				epithelium = new EpitheliumTissue(localVP, localLOD, startID, "CommonHepaticDuctEpithelium",  Constants.EpitheliumTissueRef, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
				initProperty(bioMightTransform.getName(), Constants.EpitheliumTissue, Constants.EpitheliumTissueRef, epithelium.getComponentID());
				
				//gallBladderFundus = new CommonHepaticDuctFundus(bioMightTransform.getId(), bioMightMethods);
				//initProperty(bioMightTransform.getName(), Constants.CommonHepaticDuctFundus, Constants.CommonHepaticDuctFundusRef, epithelium.getComponentID());
				}
			else
			{
				System.out.println("UnMatched Perspective.... ");
			}
			
			
			System.out.println("CommonHepaticDuct Epithelium completed");			
		}		

	
		//initProperties();
		//initMethods();
	}
	

	
	
	public void generate(String parentID, String componentID)
	{
		// Generate the CommonHepaticDuct Epithelium		
		BioMightBeanLocal bioMightBean;
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Generating the CommonHepaticDuct ParentID: " + parentID);
			InitialContext ctx = new InitialContext();
			bioMightBean = (BioMightBeanLocal) ctx.lookup("java:global/BioMightWeb/BioMightBean!biomight.ejb.BioMightBeanLocal");
	
			double radius = 0.080;
		
				
			// Generate the CommonHepaticDuct
			//  seven sections
			double[] startPos = {-1.4, -20.45, -3.15};
			double[] orient = {0.0, 0.0, 0.05};
			double[][] currentPoints = BioGraphics.createCylinderInPlane(Constants.YPLANE, startPos, radius, 8);
			
			int success = bioMightBean.generateCommonHepaticDuct("CommonHepaticDuctEpithelium:00001", "CommonHepaticDuctEpithelium", 
				"CommonHepaticDuctEpithelium", componentID, parentID, currentPoints);			
			
			System.out.println("Created CommonHepaticDuctEpithelium Info using EJB");   	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - CommonHepaticDuctEpithelium");
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
		BioMightMethodView method = new BioMightMethodView();
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
		 "<meta name='BioMightImage' content='CommonHepaticDuct.jpg'/>\n" +
		 "<meta name='ExportTime' content='7:45:30'/>\n" +
		 "<meta name='ExportDate' content='08/15/2008'/>\n" +
		 "<meta name='BioMight Version' content='1.0'/>\n" + 
		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='CommonHepaticDuct'\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		

		
		String body = "";
		int viewPerspective = Constants.VIEW_HAWKEYE;
		if (viewPerspective == Constants.VIEW_HAWKEYE)
		{			
			body = epithelium.getX3D(true);
		}
		else if (viewPerspective == Constants.VIEW_INTERNAL)
		{	
			body = epithelium.getX3D(true);
		}
		else
		{}
	
		
		body+= "<Viewpoint DEF='Viewpoint_CommonHepaticDuct'\n" +
				 "description='Viewpoint1'\n" +
				 "jump='true'\n" +
				 "fieldOfView='0.785'\n" +
				 "position='0.0 -19.0 15.0'\n" +
				 "orientation='0 0 1 0'/>\n";
		
		
		//System.out.println("CommonHepaticDuct X3D: " + body);		
		String footer = "</Scene>" + "</X3D>\n";
		
		
		if (snipet)
			return body;			
		else	
			return header + body + footer;
	}


}


