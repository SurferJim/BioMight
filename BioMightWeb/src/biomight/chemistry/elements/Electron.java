/*
 * Created on Jun 8, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.chemistry.elements;
import java.util.ArrayList;

import javax.naming.InitialContext;

import biomight.BioMightBase;
import biomight.Constants;
import biomight.ejb.BioMightBeanLocal;
import biomight.exceptions.ServerException;
import biomight.view.BioMightMethodView;
import biomight.view.BioMightPosition;
import biomight.view.BioMightPropertyView;
import biomight.view.BioMightTransform;
import biomight.view.BioMightTransforms;


/************************************************************************
* @author SurferJim
*
* Representation of an Electron
*
*************************************************************************/
public class Electron  extends BioMightBase {
	private ArrayList colors;
	private BioMightPosition bioMightPosition;

	
	public Electron()
	{
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, Constants.ElectronRef, null, null);
	}

	public Electron(String parentID)
	{
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, parentID, null, null);
	}

	public Electron(int hierarchy, int LOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
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
		this.setImage("images/Electron.jpg");
		this.setImageHeight(300);
		this.setImageWidth(300);
		this.parentID = parentID;
		this.componentID = parentID;
		this.lod = localLOD;
		this.viewPerspective = localVP;
		
		System.out.println("Creating Electron for: " + parentID);

		if (localVP == Constants.VIEW_INTERNAL)			
		{
			// Do nothing.  We are instantiating as part of a collection  
			// There is no drill down, so we use the transforms that the
			// parent has already collected
			System.out.println("In Electron Create() - ViewInternal - Already Set: " + parentID);				

			// We already have the data for the current instance of Electron,
			// Go get the details for the current Electron is LOD is set
			if (localLOD == Constants.MAG2X)
			{
				// Go get the finer details of the Electron				
				System.out.println("Getting the Electron MAG2X : " + parentID);
				localVP = Constants.VIEW_INTERNAL; 
				localLOD = Constants.MAG1X;		
			
				//System.out.println("Creating Capsid MAG ViewInternal - 1X : " + parentID);
				//electrons = new Electrons(localVP, localLOD, componentID, bioMightProperties, bioMightMethods);
				//initProperty(Constants.CapsidRef, Constants.Capsid, Constants.CapsidRef, electrons.getComponentID());
				//System.out.println("In Electron - Capsid is complete");

			}
		
		}	
		else if (localVP == Constants.VIEW_HAWKEYE)
		{
			
			//***************************************************************
			//***************************************************************
			// ON the drill down go into the detail for now on a single cell
			// HACK
			localLOD = Constants.MAG2X;
			//***************************************************************
			//***************************************************************
		
			// This is when one is accessing a Electron directly
			// Get the information from the database via the Enterprise Bean		
			try {
				// Get the information from the database via the Enterprise Bean		
				System.out.println("Getting HawkEye ElectronInfo for ParentID: " + parentID);
				InitialContext ctx = new InitialContext();
				BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
				bioMightTransforms = bioMightBean.getComponent(parentID);
				
				System.out.println("Have Electron Info from EJB");   	
			}catch (Exception e) { 
				System.out.println("Exception Getting Components - Electron");
				throw new ServerException("Remote Exception getComponents():", e); 	
			}
				
			// Run through the collection of BacilliAnthracis and build them into the model
			// In the default case, we get one instance of the Electron for each eye
			ArrayList transforms = bioMightTransforms.getTransforms();
			System.out.println("Electron NumTransforms: " + transforms.size());
			for (int i=0; i<transforms.size(); i++)
			{
				// Get the information for the Electron
				BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
				System.out.println("Creating Electron: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
				this.componentID = bioMightTransform.getId();

		
				if (localLOD == Constants.MAG1X)
				{
					System.out.println("Creating Electron at HawkEye MAG1X - Just Init Properties: " + parentID);
					// initialize the Properties
					initProperties();
				}
				if (localLOD == Constants.MAG2X)
				{
					// Go get the finer details of the Electron				
					System.out.println("Creating Electron at HawkEye MAG2X : " + parentID);
					localVP = Constants.VIEW_INTERNAL; 
					localLOD = Constants.MAG1X;

					//System.out.println("Creating Capsid MAG 1X : " + parentID);
					//capsid = new Capsid(localVP, localLOD, componentID, bioMightProperties, bioMightMethods);
					//initProperty(Constants.CapsidRef, Constants.Capsid, Constants.CapsidRef, capsid.getComponentID());
					//System.out.println("In Electron - Capsid is complete");

					//System.out.println("Creating Capsid MAG ViewInternal - 1X : " + parentID);
					//electrons = new Electrons(localVP, localLOD, componentID, bioMightProperties, bioMightMethods);
					//initProperty(Constants.CapsidRef, Constants.Capsid, Constants.CapsidRef, electrons.getComponentID());
					//System.out.println("In Electron - Capsid is complete");

					
				}
				
			}
		}		
		else
		{
			
		}
			
		initMethods();
		
		System.out.println("CreateElectron Completed");
		
		// First, get all the data from the database
		// Apply the methods to it
		// Save its state
		this.parentID = parentID;
		if (bioMightMethods != null){
			System.out.println("EXECUTING Electron Methods: " + bioMightMethods.size());
			//executeMethods(bioMightMethods);
		}
			
	}
	
	

	public void initProperties() {
		
		BioMightPropertyView property;
		
		// Observable
		property = new BioMightPropertyView();
		property.setPropertyName("Common");
		property.setCanonicalName(Constants.Title);
		properties.add(property);
			
	}
	

	public void initMethods() {

		methods = new ArrayList<BioMightMethodView>();
			
		BioMightMethodView method;
		methods = new ArrayList<BioMightMethodView>();

		method = new BioMightMethodView();
		method.setDisplayName("UnCoat");
		method.setMethodName("UnCoat");
		method.setHtmlType("checkbox");
		method.setDataType("boolean");
		methods.add(method);
	}

	
	/**********************************************************************
	 * GENERATE 
	 * 
	 * 
	 * @param parentID
	 * @param componentID
	 **********************************************************************/
	public void generate(String parentID, String componentID)
	{
		// Generate the Electron		
		BioMightBeanLocal bioMightBean;
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Generating the Electron : " + componentID + "    " + parentID);
			InitialContext ctx = new InitialContext();
			bioMightBean = (BioMightBeanLocal) ctx.lookup("java:global/BioMightWeb/BioMightBean!biomight.ejb.BioMightBeanLocal");
	
			double circumference = 0.125;
			
			if (componentID.equals("Electron:01")) {
				
				// Generate the Palm
				double[] startPos = {3.75,-23.0,-6.0};
				
				// Create a equilateral octogon
	    		double x =  startPos[0];
	    		double y =  startPos[1];
	    		double z =  startPos[2];
	
	    		double[][] currentPoints = { 
		   				 {x, y, z},
		     				 {x, y-circumference,     z-circumference},
		     				 {x, y-(circumference*2), z-circumference},
		     				 {x, y-(circumference*3), z},
		     				 {x, y-(circumference*3), z+(circumference)},
		     				 {x, y-(circumference*2), z+(circumference*2)},
		     				 {x, y-circumference,     z+(circumference*2)},
		     				 {x, y, z+circumference}
		      		};

					
				//int success = bioMightBean.generateElectron("Electron:00001", "Electron", 
				//		"Electron", componentID, parentID, currentPoints);			
				
			}
			else if (componentID.equals("Electron:02"))
			{
				// Generate the Elbow
				double[] startPos = {-3.75,-23.0,-6.0};
				
				// Create a equilateral octogon
	    		double x =  startPos[0];
	    		double y =  startPos[1];
	    		double z =  startPos[2];
	    		 
	    		
				double[][] currentPoints = { 
	   				 {x, y, z},
	     				 {x, y-circumference,     z-circumference},
	     				 {x, y-(circumference*2), z-circumference},
	     				 {x, y-(circumference*3), z},
	     				 {x, y-(circumference*3), z+(circumference)},
	     				 {x, y-(circumference*2), z+(circumference*2)},
	     				 {x, y-circumference,     z+(circumference*2)},
	     				 {x, y, z+circumference}
	      		};

				
				
				//int success = bioMightBean.generateElectron("Electron:00160", "Electron", 
				//	"Electron", componentID, parentID, currentPoints);
		
				
			}
			else if (parentID.equals("")) 
			{	
				System.out.println("Calling Generate Electron NoParent");		
			}

			
			System.out.println("Created Electron Info using EJB");   	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - Electron");
			throw new ServerException("Remote Exception Electron():", e); 	
		}
	}
	
	

	
	/********************************************************************************************************************
	 * GET X3D
	 * 
	 * This method will return the X3D for the Electron.  It runs through each of its components and collects up their
	 * representations and then assembles them into one unified X3D model.
	 * 
	 ********************************************************************************************************************/
	public String getX3D(boolean snipet) {
		
		// Assembe the Electron
		String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
		"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n " +
		"<X3D profile='Immersive' >\n" +
		"<head>\n" +
		 "<meta name='BioMightImage' content='Electron.jpg'/>\n" +
		 "<meta name='ExportTime' content='7:45:30'/>\n" +
		 "<meta name='ExportDate' content='08/15/2008'/>\n" +
		 "<meta name='BioMight Version' content='1.0'/>\n" + 
		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='Electron'\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		

		String body = "";
		String annotate = "";
		

		System.out.println("Getting X3D for Electron!!!!!!!!");

		
		// Only when the database retrieval has been locally, do we do this??
		if (viewPerspective == Constants.VIEW_INTERNAL) 
		{	
			
			//************************************************************888
			//**************************************************************8
			// HACK
			lod = Constants.MAG2X;
			//************************************************************
			//************************************************************

			
			System.out.println("Get X3D Electron - View Internal");
			// We do nada as the Electron Data is retrieved in the collection object
			// and the X3D is generated there
			if (lod == Constants.MAG2X)		
			{
				System.out.println("Get X3D Electron - View Internal - 2X");
				//We are going to get the X3D from the aggregation objects
				body += ""; //electrons.getX3D(true);	
			}
			else if (lod == Constants.MAG1X)
			{			
				// We went to the database to get data.  There will be 1 Transform record
			
				/*
				System.out.println("Creating Electron: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
				System.out.println("Creating Electron at Position: " + 
						bioMightTransform.getTranslation().getXPos() + "  " +
						bioMightTransform.getTranslation().getYPos() + "  " +
						bioMightTransform.getTranslation().getZPos());
	
				body += "<Transform DEF= 'TRANSFORM_" + bioMightTransform.getId() + "' \n";
					
					
	
		 		body += "translation='" 
					+ bioMightTransform.getTranslation().getXPos() + " " 
	 				+ bioMightTransform.getTranslation().getYPos() + " "
	 				+ bioMightTransform.getTranslation().getZPos() + "'\n";					
			
					 					
					 					
				body +=  "scale='" 	+ bioMightTransform.getScale().getXPos() + " "
				 				+ bioMightTransform.getScale().getYPos() + " "
				 				+ bioMightTransform.getScale().getZPos() + "'>\n" +
				 	"<Shape DEF='SHAPE_" + bioMightTransform.getId() + "' \n" +
				    " containerField='children'>\n" +
				    " <Appearance\n" +
				    "  containerField='appearance'>\n";
					    
				body+= " <ImageTexture containerField='texture' " +
				    " url='../images/Electron.jpg'/>";
				
				body+= " <Material DEF='Rust'\n" +
				    "containerField='material'\n" +
				    "ambientIntensity='" 	+ bioMightTransform.getMaterial().getAmbientIntensity() + "'\n" +
				    "shininess='" 			+ bioMightTransform.getMaterial().getShininess() + "'\n" +
				    "transparency='" 		+ bioMightTransform.getMaterial().getTransparency() + "'\n" +
				    "diffuseColor='" + 
				 	    bioMightTransform.getMaterial().getDiffuseColor().getRed() + " " + 
				 	    bioMightTransform.getMaterial().getDiffuseColor().getGreen() + " " +
				 	    bioMightTransform.getMaterial().getDiffuseColor().getBlue() + "'/>\n" +
				 	"</Appearance>\n" +
				 	"<Sphere DEF='ElectronGeoSphere'\n" +
				 	"containerField='geometry'\n" +
				 	"radius='" + bioMightTransform.getRadius() +"'/>\n" +
				 	"</Shape>\n" +
				 	
					"\n<TouchSensor DEF='TSENSOR_"+ bioMightTransform.getId()+ "' \n" +
	                   " description='Electron'\n" +
		               " containerField='children'/> \n" +
	
				 "</Transform>\n";
				*/
			}
		
		}
		else if (viewPerspective == Constants.VIEW_HAWKEYE) 
		{
			System.out.println("Get X3D Electron - View Hawkeye");
			
			//************************************************************888
			//**************************************************************8
			// HACK
			lod = Constants.MAG2X;
			//************************************************************
			//************************************************************

			if (lod == Constants.MAG2X)		
			{
				System.out.println("Get X3D Electron - View Hawkeye -- 2X");
				//We are going to get the X3D from the aggregation objects
				body += "";	
			}
			else
			{			
				// We went to the database to get data.  There will be 1 Transform record
				System.out.println("Get X3D Electron - View Hawkeye  1X");
			
				ArrayList transforms = bioMightTransforms.getTransforms();
				for (int i=0; i<transforms.size(); i++)
				{
					// Get the information for the capsomer we are creating
					BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
					System.out.println("Creating Electron: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
					System.out.println("Creating Electron at Position: " + 
							bioMightTransform.getTranslation().getXPos() + "  " +
							bioMightTransform.getTranslation().getYPos() + "  " +
							bioMightTransform.getTranslation().getZPos());

					body += "<Transform DEF= 'TRANSFORM_" + bioMightTransform.getId() + "' \n";
						
						
					// Set the position if we are working with the Tissue collection
					if (parentID.equals("1.10000:0"))
					{
						body += "translation='" 
							+ bioMightPosition.getXPos() + " " 
				 			+ bioMightPosition.getYPos() + " "
				 			+ bioMightPosition.getZPos() + "'\n";
					}
					else
					{
				 		body += "translation='" 
				 			+ bioMightTransform.getTranslation().getXPos() + " " 
		 					+ bioMightTransform.getTranslation().getYPos() + " "
		 					+ bioMightTransform.getTranslation().getZPos() + "'\n";					
					}
						 					
						 					
					body +=  "scale='" 	+ bioMightTransform.getScale().getXPos() + " "
					 				+ bioMightTransform.getScale().getYPos() + " "
					 				+ bioMightTransform.getScale().getZPos() + "'>\n" +
					 	"<Shape DEF='SHAPE_" + bioMightTransform.getId() + "' \n" +
					    " containerField='children'>\n" +
					    " <Appearance\n" +
					    "  containerField='appearance'>\n";
						    
					body+= " <ImageTexture containerField='texture' " +
					    " url='../images/Electron.jpg'/>";
					
					body+= " <Material DEF='Rust'\n" +
					    "containerField='material'\n" +
					    "ambientIntensity='" 	+ bioMightTransform.getMaterial().getAmbientIntensity() + "'\n" +
					    "shininess='" 			+ bioMightTransform.getMaterial().getShininess() + "'\n" +
					    "transparency='" 		+ bioMightTransform.getMaterial().getTransparency() + "'\n" +
					    "diffuseColor='" + 
					 	    bioMightTransform.getMaterial().getDiffuseColor().getRed() + " " + 
					 	    bioMightTransform.getMaterial().getDiffuseColor().getGreen() + " " +
					 	    bioMightTransform.getMaterial().getDiffuseColor().getBlue() + "'/>\n" +
					 	"</Appearance>\n" +
					 	"<Sphere DEF='ElectronGeoSphere'\n" +
					 	"containerField='geometry'\n" +
					 	"radius='" + bioMightTransform.getRadius() +"'/>\n" +
					 	"</Shape>\n" +
					 	
						"\n<TouchSensor DEF='TSENSOR_"+ bioMightTransform.getId()+ "' \n" +
		                   " description='Electron'\n" +
			               " containerField='children'/> \n" +
		
					 "</Transform>\n";
				}
				
			}
		}
		else 
		{			
			// Issue
		}	
			
		
		String footer = "</Scene>" + "</X3D>\n";		
		if (snipet)
			return body;			
		else	
			return header + body + annotate + footer;				
	}


	

	public void unCoat()
	{
	}

	public void penetrate()
	{
	}
	
	public void transcribe()
	{
	}
		
	public void assemble()
	{
		// 
	}

}
