/*
 * Created on May 23, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.body.gland.spleen;


import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.naming.InitialContext;

import biomight.BioMightBase;
import biomight.Constants;
import biomight.ejb.BioMightBeanLocal;
import biomight.exceptions.DataSecurityException;
import biomight.exceptions.ServerException;
import biomight.system.tissue.epithelial.EpitheliumTissue;
import biomight.util.BioGraphics;
import biomight.view.BioMightGenerate;
import biomight.view.BioMightMethodView;
import biomight.view.BioMightPosition;
import biomight.view.BioMightPropertyView;
import biomight.view.BioMightScale;
import biomight.view.BioMightTransform;
import biomight.view.BioMightTransforms;

/******************************************************************************
 * @author SurferJim
 *
 * Representation of the SpleenExternalSerousCoat
 * 
 *****************************************************************************/

public class SpleenExternalSerousCoat extends BioMightBase {
	private BioMightTransforms bioMightTransforms;
	private ArrayList<BioMightPropertyView> properties;
	private ArrayList<BioMightMethodView> methods;
	protected EpitheliumTissue epithelium;
	
	
	
	/************************************************************************
	 * SpleenExternalSerousCoat Constructor 
	 *
	 ***********************************************************************/
	public SpleenExternalSerousCoat()
	{
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, Constants.SpleenExternalSerousCoatRef, null, null);
	}

	/************************************************************************
	 * SpleenExternalSerousCoat Constructor 
	 *
	 ***********************************************************************/
	public SpleenExternalSerousCoat(String parentID)
	{
		System.out.print("Calling parameterized SpleenExternalSerousCoat Constructor!");
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, parentID, null, null);
	}
	
	
	/************************************************************************
	 * SpleenExternalSerousCoat Constructor 
	 *
	 ***********************************************************************/
	public SpleenExternalSerousCoat(int hierarchy, int LOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
	{
		System.out.print("Calling Spleen with MethodParams!");
		create(hierarchy, LOD, parentID, bioMightProperties, bioMightMethods);
	}
	
	
	/************************************************************************
	 * Create Spleen
	 *
	 ***********************************************************************/

	public void create(int hierarchy, int LOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
	{
		this.setImage("images/SpleenExternalSerousCoat.jpg");
		this.setImageHeight(300);
		this.setImageWidth(300);
	
		System.out.println("Creating the SpleenExternalSerousCoat for parent: " + parentID);
		
		// Get the information from the database via the Enterprise Bean		
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Getting SpleenExternalSerousCoatInfo for ParentID: " + parentID);
			InitialContext ctx = new InitialContext();
			BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
			bioMightTransforms = bioMightBean.getComponents(Constants.SpleenExternalSerousCoatRef, parentID);
			System.out.println("Have SpleenExternalSerousCoat Info from EJB");   	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - SpleenExternalSerousCoat");
			throw new ServerException("Remote Exception getComponents():", e); 	
		}
		
		int localVP = Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;

		BioMightScale bioScale = new BioMightScale("0.00, 0.00, 0.00");
		BioMightPosition  bioPos = new BioMightPosition("0.00, 0.00, 0.00");
		String bioTemplate="Bacterias.x3d";

			
		// Run through the collection of UpperLip and build them into the model
		// In the default case, we get one instance of the Pupil for each eye
		ArrayList transforms = bioMightTransforms.getTransforms();
		System.out.println("Have SpleenExternalSerousCoat Info NumTransforms: " + transforms.size());
		for (int i=0; i<transforms.size(); i++)
		{
			// Get the information for the Upper Lip we are creating
			BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
			System.out.println("Created SpleenExternalSerousCoat (name,id): " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
			componentID=bioMightTransform.getId();
			
			// Generate the Epithelium
			boolean bGenerate = false;
			if (bGenerate) {
				generate(parentID, componentID);
			}
			
			String startID = "SpleenEpithelium:00320";
			System.out.println("Creating Spleen Epithelium: " + bioMightTransform.getId());							
			epithelium = new EpitheliumTissue(localVP, localLOD, startID, "SpleenEpithelium", "SpleenEpithelium", bioMightTransform.getId(), bioMightProperties, bioMightMethods);
			BioMightGenerate generatedEpithelium = epithelium.getBioMightGenerate(); 		
			initProperty("SpleenEpithelium", Constants.EpitheliumTissue, Constants.EpitheliumTissueRef, epithelium.getComponentID(), bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);					
		
		}		
		
		initProperties();
		initMethods();
		
		System.out.println("Creating the SpleenExternalSerousCoat: " + parentID);
	}
	
	/*******************************************************************
	 * generate the Spleen
	 * 
	 * @param parentID
	 * @param componentID
	 ****************************************************************/
	
	public void generate(String parentID, String componentID)
	{
		// Generate the SpleenEpithelium		
		BioMightBeanLocal bioMightBean;
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Generating the SpleenEpithelium: " + componentID + "    " + parentID);
			InitialContext ctx = new InitialContext();
			bioMightBean = (BioMightBeanLocal) ctx.lookup("java:global/BioMightWeb/BioMightBean!biomight.ejb.BioMightBeanLocal");
	
			double radius = 0.0025;
		
			if (parentID.equals("Spleen:01")) 
			{	
				// Generate the SpleenEpithelium 
				// Create 5 sections
				double[] startPos = {3.75, -18.5, -4.65};
				double[][] currentPoints = BioGraphics.createCylinderInPlane(Constants.YPLANE, startPos, radius, 8);
				
	
				System.out.println("Calling Generate SpleenEpithelium: " + componentID + "    " + parentID);
				
				int success = bioMightBean.generateSpleen("SpleenEpithelium:00001", "SpleenEpithelium", 
						"SpleenEpithelium", componentID, currentPoints);			
					
			}			
			else if (parentID.equals("Chest:01")) 
			{	
				// This is a mutant case
				double[] startPos = {4.0, -16.5, -4.5};
				double[][] currentPoints = BioGraphics.createCylinderInPlane(Constants.YPLANE, startPos, radius, 8);
				
	
				System.out.println("Calling Generate SpleenEpithelium: " + componentID + "    " + parentID);
				
				int success = bioMightBean.generateSpleen("SpleenEpithelium:00180", "SpleenEpithelium", 
						"SpleenEpithelium", componentID, currentPoints);			
			
			}
			else if (parentID.equals("")) 
			{	
				System.out.println("Calling Generate SpleenEpithelium NoParent");
							
			}
			
			System.out.println("Created SpleenEpithelium Info using EJB");   	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - SpleenEpithelium");
			throw new ServerException("Remote Exception getComponents():", e); 	
		}
	}
	
	public void initProperties() {

		properties = new ArrayList<BioMightPropertyView>();
		
		BioMightPropertyView property = new BioMightPropertyView();
		property.setPropertyName("Stapes ---");
		property.setCanonicalName(Constants.LeftEar);
		properties.add(property);
	}
	
	
	public void initMethods() {

		methods = new ArrayList<BioMightMethodView>();
		
		BioMightMethodView method = new BioMightMethodView();

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
	 * This method will return the X3D for the Spleen.  It runs through each of its components and collects up their
	 * representations and then assembles them into one unified X3D model.
	 * 
	 ********************************************************************************************************************/
	

	public String getX3D(boolean snipet) {
		
		// Assemble the Spleen Serous Coat
		String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
		"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n " +
		"<X3D profile='Immersive' >\n" +
		"<head>\n" +
		 "<meta name='BioMightImage' content='Spleen.jpg'/>\n" +
		 "<meta name='ExportTime' content='7:45:30'/>\n" +
		 "<meta name='ExportDate' content='08/15/2008'/>\n" +
		 "<meta name='BioMight Version' content='1.0'/>\n" + 
		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='Spleen'\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		

		String body = epithelium.getX3D(true);  
		
		// We should do this on detached view only
		body+= "\n<Viewpoint DEF='Viewpoint_SpleenSerousCoat'\n" +
				 "description='Viewpoint1'\n" +
				 "jump='true'\n" +
				 "fieldOfView='0.785'\n" +
				 "position='2.0 -18.0 5.0'\n" +
				 "orientation='0 0 1 0'/>\n";
		
		//System.out.println("Spleen X3D: " + body);		
		
		String footer = "</Scene>" + "</X3D>\n";
		
		if (snipet)
			return body;			
		else	
			return header + body + footer;
	}
	
		

	
	public String getX3DExternal(boolean snipet) {
		
		// Assemble the SpleenSerousCoat
		String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
		"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n " +
		"<X3D profile='Immersive' >\n" +
		"<head>\n" +
		 "<meta name='BioMightImage' content='SpleenSerousCoat.jpg'/>\n" +
		 "<meta name='ExportTime' content='7:45:30'/>\n" +
		 "<meta name='ExportDate' content='08/15/2008'/>\n" +
		 "<meta name='BioMight Version' content='1.0'/>\n" + 
		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='SpleenSerousCoat'\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		

		String body = "";
		
		// Run through the collection of  SpleenSerousCoat and build them into the model
		ArrayList transforms = bioMightTransforms.getTransforms();
		for (int i=0; i<transforms.size(); i++)
		{
			// Get the information for the PinnaAntiHelix we are creating
			BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
			System.out.println("Getting SpleenSerousCoat X3D: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
		
			int view = Constants.VIEW_FLOATING;
			if (view == Constants.VIEW_FLOATING)
			{
				//System.out.println("Getting X3D for SpleenSerousCoatX: " + bioMightSphere.getTranslation().getXPos());
				//System.out.println("Getting X3D for SpleenSerousCoatY: " + bioMightSphere.getTranslation().getYPos());
				//System.out.println("Getting X3D for SpleenSerousCoatZ: " + bioMightSphere.getTranslation().getZPos());
				// Change the height and width based on the displacement.
				body += "<Transform DEF='SpleenSerousCoat'\n" +
		 			"translation='" + bioMightTransform.getTranslation().getXPos() + " " 
			 					+ bioMightTransform.getTranslation().getYPos() + " "
			 					+ bioMightTransform.getTranslation().getZPos() + "'\n" +
			 		"scale='" 	+ bioMightTransform.getScale().getXPos() + " "
			 				+ bioMightTransform.getScale().getYPos() + " "
			 				+ bioMightTransform.getScale().getZPos() + "'>\n" +
					"<Shape DEF='SpleenSerousCoat'\n" +
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
						 	"<IndexedFaceSet DEF='SpleenSerousCoatIFS' \n" +
						    	   "containerField='geometry' \n" +
						    	   "creaseAngle='" +  bioMightTransform.getCreaseAngle() + "'\n" +
						    	   "coordIndex='" + bioMightTransform.getCoordindexStr() + "'>" +
						    	   "<Coordinate DEF='SpleenSerousCoat_Coord' \n" +
						    	    "containerField='coord' point='" +  bioMightTransform.getCoordpointStr() + "'/>" +
						    	  "</IndexedFaceSet>\n" +
					"</Shape>\n" +
			 "</Transform>\n"; 
		}
		else
		{
			body = "";//						
		}
		
		}
		
		System.out.println("SpleenSerousCoat X3D: " + body);		
		String footer = "</Scene>" + "</X3D>\n";
		
		if (snipet)
			return body;			
		else	
			return header + body + footer;
	}
}

