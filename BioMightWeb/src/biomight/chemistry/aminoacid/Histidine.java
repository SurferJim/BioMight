
package biomight.chemistry.aminoacid;
import java.util.ArrayList;

import javax.naming.InitialContext;

import biomight.BioMightBase;
import biomight.Constants;
import biomight.chemistry.elements.Carbons;
import biomight.ejb.BioMightBeanLocal;
import biomight.exceptions.ServerException;
import biomight.util.BioGraphics;
import biomight.view.BioMightMethodView;
import biomight.view.BioMightPosition;
import biomight.view.BioMightPropertyView;
import biomight.view.BioMightTransform;
import biomight.view.BioMightTransforms;
import biomightweb.util.BioWebDNA;


/************************************************************************
* @author SurferJim
*
* Representation of Histidine
*
*************************************************************************/
public class Histidine  extends BioMightBase {
	BioMightTransform gbioMightTransform; 
	private ArrayList colors;
	private BioMightPosition bioMightPosition;
	private Carbons carbons;
	
	public Histidine()
	{
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, Constants.HistidineRef, null, null);
	}

	public Histidine(String parentID)
	{
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, parentID, null, null);
	}

	public Histidine(int hierarchy, int LOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
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
		this.setImage("images/Histidine.jpg");
		this.setImageHeight(300);
		this.setImageWidth(300);
		this.parentID = parentID;
		this.componentID = parentID;
		this.lod = localLOD;
		this.viewPerspective = localVP;
		
		System.out.println("Creating Histidine for: " + parentID);
					
		if (localVP == Constants.VIEW_INTERNAL)			
		{
			// Do nothing.  We are instantiating as part of a collection  
			// There is no drill down, so we use the transforms that the
			// parent has already collected
			System.out.println("In Histidine Create() - ViewInternal - Already Set: " + parentID);				

			// We already have the data for the current instance of Histidine,
			// Go get the details for the current Histidine is LOD is set
			if (localLOD == Constants.MAG2X)
			{
				// Go get the finer details of the Histidine				
				System.out.println("Getting the Histidine MAG2X : " + parentID);
				localVP = Constants.VIEW_INTERNAL; 
				localLOD = Constants.MAG1X;		
			
				System.out.println("Creating Histidine MAG ViewInternal - 2X : " + parentID);
				carbons = new Carbons(localVP, localLOD, componentID, bioMightProperties, bioMightMethods);
				initProperty(Constants.CarbonsRef, Constants.Carbons, Constants.CarbonsRef, carbons.getComponentID());
				System.out.println("In Histidine - CarbonsRef is complete");

				//System.out.println("Creating Hydrogens MAG ViewInternal - 1X : " + parentID);
				//hydrogens = new Hydrogens(localVP, localLOD, componentID, bioMightProperties, bioMightMethods);
				//initProperty(Constants.HydrogensRef, Constants.Hydrogens, Constants.HydrogensRef, hydrogens.getComponentID());
				//System.out.println("In Histidine - Hydrogens is complete");

			}
		
		}	
		else if (localVP == Constants.VIEW_HAWKEYE)
		{
			
			//***************************************************************
			//***************************************************************
			// ON the drill down go into the detail for now on a single cell
			// HACK
			localLOD = Constants.MAG1X;
			//***************************************************************
			//***************************************************************
		
			// This is when one is accessing a Histidine directly
			// Get the information from the database via the Enterprise Bean		
			try {
				// Get the information from the database via the Enterprise Bean		
				System.out.println("Getting HawkEye HistidineInfo for ParentID: " + parentID);
				InitialContext ctx = new InitialContext();
				BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
				bioMightTransforms = bioMightBean.getComponent(parentID);
				
				System.out.println("Have Histidine Info from EJB");   	
			}catch (Exception e) { 
				System.out.println("Exception Getting Components - Histidine");
				throw new ServerException("Remote Exception getComponents():", e); 	
			}
				
			// Run through the collection of BacilliAnthracis and build them into the model
			// In the default case, we get one instance of the Histidine for each eye
			ArrayList transforms = bioMightTransforms.getTransforms();
			System.out.println("Histidine NumTransforms: " + transforms.size());
			for (int i=0; i<transforms.size(); i++)
			{
				// Get the information for the Histidine
				BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
			
				// A hack, I am using the values down below in the X3D method to set some appearance  and material values
				gbioMightTransform  = bioMightTransform;
			
				System.out.println("Creating Histidine: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
				this.componentID = bioMightTransform.getId();

		
				if (localLOD == Constants.MAG1X)
				{
					System.out.println("Creating Histidine at HawkEye MAG1X - Just Init Properties: " + parentID);
					// initialize the Properties
					initProperties();
				}
				if (localLOD == Constants.MAG2X)
				{
					// Go get the finer details of the Histidine				
					System.out.println("Creating Histidine at HawkEye MAG2X : " + parentID);
					localVP = Constants.VIEW_INTERNAL; 
					localLOD = Constants.MAG1X;

					System.out.println("Creating Histidine HawkEye - 2X : " + parentID);
					carbons = new Carbons(localVP, localLOD, componentID, bioMightProperties, bioMightMethods);
					initProperty(Constants.CarbonsRef, Constants.Carbons, Constants.CarbonsRef, carbons.getComponentID());
					System.out.println("In Histidine - CarbonsRef is complete");

					//System.out.println("Creating Hydrogens MAG ViewInternal - 1X : " + parentID);
					//hydrogens = new Hydrogens(localVP, localLOD, componentID, bioMightProperties, bioMightMethods);
					//initProperty(Constants.HydrogensRef, Constants.Hydrogens, Constants.HydrogensRef, hydrogens.getComponentID());
					//System.out.println("In Histidine - Hydrogens is complete");					
				}
				
			}
		}		
		else
		{
			
		}
			
		initMethods();
		
		System.out.println("CreateHistidine Completed");
		
		// First, get all the data from the database
		// Apply the methods to it
		// Save its state
		this.parentID = parentID;
		if (bioMightMethods != null){
			System.out.println("EXECUTING Histidine Methods: " + bioMightMethods.size());
			//executeMethods(bioMightMethods);
		}
			
	}
	
	

	//CH3-CH(NH2)-COOH
	
	public void initProperties() {
		
		BioMightPropertyView property;
		
		// Observable
		property = new BioMightPropertyView();
		property.setPropertyName("Amine");
		property.setCanonicalName(Constants.Title);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("CarboxylGroup");
		property.setCanonicalName(Constants.Title);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("SideChain");
		property.setCanonicalName(Constants.Carbons);
		properties.add(property);
			
	}
	

	public void initMethods() {

		methods = new ArrayList<BioMightMethodView>();
			
		BioMightMethodView method;
		methods = new ArrayList<BioMightMethodView>();
		method = new BioMightMethodView();
		method.setDisplayName("Transcribe");
		method.setMethodName("Transcribe");
		method.setHtmlType("checkbox");
		method.setDataType("boolean");
		methods.add(method);

		method = new BioMightMethodView();
		method.setDisplayName("Penetrate Histidine");
		method.setMethodName("Penetrate Histidine");
		method.setHtmlType("checkbox");
		method.setDataType("boolean");
		methods.add(method);	
			
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
	 * @param parentID
	 * @param componentID
	 **********************************************************************/
	public void generate(String parentID, String componentID)
	{
		// Generate the Histidine		
		BioMightBeanLocal bioMightBean;
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Generating the Histidine : " + componentID + "    " + parentID);
			InitialContext ctx = new InitialContext();
			bioMightBean = (BioMightBeanLocal) ctx.lookup("java:global/BioMightWeb/BioMightBean!biomight.ejb.BioMightBeanLocal");
	
			double circumference = 0.125;
			
			if (componentID.equals("Histidine:01")) {
				
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

					
				//int success = bioMightBean.generateHistidine("Histidine:00001", "Histidine", 
				//		"Histidine", componentID, parentID, currentPoints);			
				
			}
			else if (componentID.equals("Histidine:02"))
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

				
				
				//int success = bioMightBean.generateHistidine("Histidine:00160", "Histidine", 
				//	"Histidine", componentID, parentID, currentPoints);
		
				
			}
			else if (parentID.equals("")) 
			{	
				System.out.println("Calling Generate Histidine NoParent");		
			}

			
			System.out.println("Created Histidine Info using EJB");   	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - Histidine");
			throw new ServerException("Remote Exception Histidine():", e); 	
		}
	}
	
	

	
	/********************************************************************************************************************
	 * GET X3D
	 * 
	 * This method will return the X3D for the Histidine.  It runs through each of its components and collects up their
	 * representations and then assembles them into one unified X3D model.
	 * 
	 ********************************************************************************************************************/
	public String getX3D(boolean snipet) {
		
		// Assembe the Histidine
		String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
		"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n " +
		"<X3D profile='Immersive' >\n" +
		"<head>\n" +
		 "<meta name='BioMightImage' content='Histidine.jpg'/>\n" +
		 "<meta name='ExportTime' content='7:45:30'/>\n" +
		 "<meta name='ExportDate' content='08/15/2008'/>\n" +
		 "<meta name='BioMight Version' content='1.0'/>\n" + 
		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='Histidine'\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		

		String body = "";
		String annotate = "";
		

		System.out.println("Getting X3D for Histidine!!!!!!!!");

		
		// Only when the database retrieval has been locally, do we do this??
		if (viewPerspective == Constants.VIEW_INTERNAL) 
		{	
			
			//************************************************************888
			//**************************************************************8
			// HACK
			lod = Constants.MAG2X;
			//************************************************************
			//************************************************************

			
			System.out.println("Get X3D Histidine - View Internal");
			// We do nada as the Histidine Data is retrieved in the collection object
			// and the X3D is generated there
			if (lod == Constants.MAG2X)		
			{
				System.out.println("Get X3D Histidine - View Internal - 2X");
				//We are going to get the X3D from the aggregation objects
				body += carbons.getX3D(true);	
			}
			else if (lod == Constants.MAG1X)
			{			
				// We went to the database to get data.  There will be 1 Transform record
			
				/*
				System.out.println("Creating Histidine: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
				System.out.println("Creating Histidine at Position: " + 
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
				    " url='../images/Histidine.jpg'/>";
				
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
				 	"<Sphere DEF='HistidineGeoSphere'\n" +
				 	"containerField='geometry'\n" +
				 	"radius='" + bioMightTransform.getRadius() +"'/>\n" +
				 	"</Shape>\n" +
				 	
					"\n<TouchSensor DEF='TSENSOR_"+ bioMightTransform.getId()+ "' \n" +
	                   " description='Histidine'\n" +
		               " containerField='children'/> \n" +
	
				 "</Transform>\n";
				*/
			}
		
		}
		else if (viewPerspective == Constants.VIEW_HAWKEYE) 
		{
			System.out.println("Get X3D Histidine - View Hawkeye");
			
			//************************************************************888
			//**************************************************************8
			// HACK
			lod = Constants.MAG1X;
			//************************************************************
			//************************************************************

			if (lod == Constants.MAG2X)		
			{
				System.out.println("Get X3D Histidine - View Hawkeye -- 2X");
				//We are going to get the X3D from the aggregation objects
				body += carbons.getX3D(true);	
			}
			else if (lod == Constants.MAG1X)	
			{			
				// We went to the database to get data.  There will be 1 Transform record
				System.out.println("Get X3D Histidine - View Hawkeye  1X");
					
				// Set up the base position
				double xBase = gbioMightTransform.getTranslation().getXPos();
				double yBase = gbioMightTransform.getTranslation().getYPos();
				double zBase = gbioMightTransform.getTranslation().getZPos();
				
				double x = xBase + 0.0;
				double y = yBase - 0.10;
				double z = zBase + 0.0;

				gbioMightTransform.getTranslation().setXPos(x);
				gbioMightTransform.getTranslation().setYPos(y);
				gbioMightTransform.getTranslation().setZPos(z);

				body+= BioWebDNA.getAmine(gbioMightTransform, 0, 0);
						
				// Create the Connect Carbon
				x = xBase - 0.25;
				y = yBase + 0.0;
				z = zBase + 0.0;
			
				gbioMightTransform.getTranslation().setXPos(x);
				gbioMightTransform.getTranslation().setYPos(y);
				gbioMightTransform.getTranslation().setZPos(z);

				String[] coAtoms = {"Hydrogen"};
				double[] coOrientation = {270};
				body+= BioWebDNA.getSimpleMolecule(gbioMightTransform, "Carbon", coAtoms, coOrientation);  
	
				
				//*********************************************************************************
				// Create the Histidine Side Chain 
				//*********************************************************************************
				
				// CH2
				x = xBase - 0.30;
				y = yBase + 0.15;
				z = zBase + 0.0;
			
				gbioMightTransform.getTranslation().setXPos(x);
				gbioMightTransform.getTranslation().setYPos(y);
				gbioMightTransform.getTranslation().setZPos(z);

				String[] coAtoms3 = {"Hydrogen", "Hydrogen"};
				double[] coOrientation3 = {0, 180};
				body+= BioWebDNA.getSimpleMolecule(gbioMightTransform, "Carbon", coAtoms3, coOrientation3);  
	
				
				// C C N C N
				x = xBase - 0.25;
				y = yBase + 0.50;
				z = zBase + 0.0;
	
				double[] startPos = {x, y, z};
				double radiansAngle = Math.toRadians(-20.0);	
				String ring1Elements[] = {"Nitrogen", "Carbon", "Carbon", "Carbon", "Carbon"};
				double[][] ring1Points = BioGraphics.createCylinderInPlane(Constants.ZPLANE,  startPos,  0.2, ring1Elements.length, radiansAngle);

				for (int i=0; i<ring1Elements.length; i++)
				{
					//System.out.println("Creating X3D for : " + phosphateElements[i]);				
										
					gbioMightTransform.getTranslation().setXPos(ring1Points[i][0]);
					gbioMightTransform.getTranslation().setYPos(ring1Points[i][1]);
					gbioMightTransform.getTranslation().setZPos(ring1Points[i][2]);
	
					if (i == 0)
					{
						String[] coAtoms1 = {};
						double[] coOrientation1 = {0};
						body+= BioWebDNA.getSimpleMolecule(gbioMightTransform, "Nitrogen", coAtoms1, coOrientation1);  
					}
					else if (i == 1)
					{
						String[] coAtoms1 = {"Hydrogen"};
						double[] coOrientation1 = {0, 330};
						body+= BioWebDNA.getSimpleMolecule(gbioMightTransform, "Carbon", coAtoms1, coOrientation1);  
					}
					else if (i == 2)
					{
						String[] coAtoms1 = {"Hydrogen"};
						double[] coOrientation1 = {0, 180};
						body+= BioWebDNA.getSimpleMolecule(gbioMightTransform, "Nitrogen", coAtoms1, coOrientation1);  
					}
					else if (i == 3)
					{
						String[] coAtoms1 = {"Hydrogen"};
						double[] coOrientation1 = {0, 330};
						body+= BioWebDNA.getSimpleMolecule(gbioMightTransform, "Carbon", coAtoms1, coOrientation1);  
					}
					else if (i == 4)
					{
						String[] coAtoms1 = {};
						double[] coOrientation4 = {0, 180};
						body+= BioWebDNA.getSimpleMolecule(gbioMightTransform, "Carbon", coAtoms1, coOrientation4);  
					}
			
				}
			
				
				//*************************************************
				// Create the Carboxyl
				//*************************************************
				x = xBase - 0.5;
				y = yBase - 0.10;
				z = zBase + 0.0;
			
				gbioMightTransform.getTranslation().setXPos(x);
				gbioMightTransform.getTranslation().setYPos(y);
				gbioMightTransform.getTranslation().setZPos(z);
				
				body+= BioWebDNA.getCarboxylGroup(gbioMightTransform, 0, 0);	
						
			}
		}
		else 
		{			
			// Issue
		}	
			
		
		body+= "<Viewpoint DEF='Viewpoint_Glutamine'\n" +
				 "description='Viewpoint_Glutamine'\n" +
				 "jump='true'\n" +
				 "fieldOfView='0.785'\n" +
				 "position='0.0 0.0 5.0'\n" +
				 "orientation='0 0 1 0'/>\n";
		
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

