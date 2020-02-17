
package biomight.chemistry.aminoacid;
import java.util.ArrayList;

import javax.naming.InitialContext;

import biomight.BioMightBase;
import biomight.Constants;
import biomight.chemistry.elements.Carbons;
import biomight.ejb.BioMightBeanLocal;
import biomight.exceptions.ServerException;
import biomight.view.BioMightMethodView;
import biomight.view.BioMightPosition;
import biomight.view.BioMightPropertyView;
import biomight.view.BioMightTransform;
import biomight.view.BioMightTransforms;
import biomightweb.util.BioWebDNA;


/************************************************************************
* @author SurferJim
*
* Representation of Serine
*
*************************************************************************/
public class Serine  extends BioMightBase {
	BioMightTransform gbioMightTransform; 
	private ArrayList colors;
	private BioMightPosition bioMightPosition;
	private Carbons carbons;
	
	public Serine()
	{
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, Constants.SerineRef, null, null);
	}

	public Serine(String parentID)
	{
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, parentID, null, null);
	}

	public Serine(int hierarchy, int LOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
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
		this.setImage("images/Serine.jpg");
		this.setImageHeight(300);
		this.setImageWidth(300);
		this.parentID = parentID;
		this.componentID = parentID;
		this.lod = localLOD;
		this.viewPerspective = localVP;
		
		System.out.println("Creating Serine for: " + parentID);
				
	
		if (localVP == Constants.VIEW_INTERNAL)			
		{
			// Do nothing.  We are instantiating as part of a collection  
			// There is no drill down, so we use the transforms that the
			// parent has already collected
			System.out.println("In Serine Create() - ViewInternal - Already Set: " + parentID);				

			// We already have the data for the current instance of Serine,
			// Go get the details for the current Serine is LOD is set
			if (localLOD == Constants.MAG2X)
			{
				// Go get the finer details of the Serine				
				System.out.println("Getting the Serine MAG2X : " + parentID);
				localVP = Constants.VIEW_INTERNAL; 
				localLOD = Constants.MAG1X;		
			
				System.out.println("Creating Serine MAG ViewInternal - 2X : " + parentID);
				carbons = new Carbons(localVP, localLOD, componentID, bioMightProperties, bioMightMethods);
				initProperty(Constants.CarbonsRef, Constants.Carbons, Constants.CarbonsRef, carbons.getComponentID());
				System.out.println("In Serine - CarbonsRef is complete");

				//System.out.println("Creating Hydrogens MAG ViewInternal - 1X : " + parentID);
				//hydrogens = new Hydrogens(localVP, localLOD, componentID, bioMightProperties, bioMightMethods);
				//initProperty(Constants.HydrogensRef, Constants.Hydrogens, Constants.HydrogensRef, hydrogens.getComponentID());
				//System.out.println("In Serine - Hydrogens is complete");

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
		
			// This is when one is accessing a Serine directly
			// Get the information from the database via the Enterprise Bean		
			try {
				// Get the information from the database via the Enterprise Bean		
				System.out.println("Getting HawkEye SerineInfo for ParentID: " + parentID);
				InitialContext ctx = new InitialContext();
				BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
				bioMightTransforms = bioMightBean.getComponent(parentID);
				
				System.out.println("Have Serine Info from EJB");   	
			}catch (Exception e) { 
				System.out.println("Exception Getting Components - Serine");
				throw new ServerException("Remote Exception getComponents():", e); 	
			}
				
			// Run through the collection of BacilliAnthracis and build them into the model
			// In the default case, we get one instance of the Serine for each eye
			ArrayList transforms = bioMightTransforms.getTransforms();
			System.out.println("Serine NumTransforms: " + transforms.size());
			for (int i=0; i<transforms.size(); i++)
			{
				// Get the information for the Serine
				BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
			
				// A hack, I am using the values down below in the X3D method to set some appearance  and material values
				gbioMightTransform  = bioMightTransform;
			
				System.out.println("Creating Serine: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
				this.componentID = bioMightTransform.getId();

		
				if (localLOD == Constants.MAG1X)
				{
					System.out.println("Creating Serine at HawkEye MAG1X - Just Init Properties: " + parentID);
					// initialize the Properties
					initProperties();
				}
				if (localLOD == Constants.MAG2X)
				{
					// Go get the finer details of the Serine				
					System.out.println("Creating Serine at HawkEye MAG2X : " + parentID);
					localVP = Constants.VIEW_INTERNAL; 
					localLOD = Constants.MAG1X;

					System.out.println("Creating Serine HawkEye - 2X : " + parentID);
					carbons = new Carbons(localVP, localLOD, componentID, bioMightProperties, bioMightMethods);
					initProperty(Constants.CarbonsRef, Constants.Carbons, Constants.CarbonsRef, carbons.getComponentID());
					System.out.println("In Serine - CarbonsRef is complete");

					//System.out.println("Creating Hydrogens MAG ViewInternal - 1X : " + parentID);
					//hydrogens = new Hydrogens(localVP, localLOD, componentID, bioMightProperties, bioMightMethods);
					//initProperty(Constants.HydrogensRef, Constants.Hydrogens, Constants.HydrogensRef, hydrogens.getComponentID());
					//System.out.println("In Serine - Hydrogens is complete");					
				}
				
			}
		}		
		else
		{
			
		}
			
		initMethods();
		
		System.out.println("CreateSerine Completed");
		
		// First, get all the data from the database
		// Apply the methods to it
		// Save its state
		this.parentID = parentID;
		if (bioMightMethods != null){
			System.out.println("EXECUTING Serine Methods: " + bioMightMethods.size());
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
		method.setDisplayName("Penetrate Serine");
		method.setMethodName("Penetrate Serine");
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
		// Generate the Serine		
		BioMightBeanLocal bioMightBean;
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Generating the Serine : " + componentID + "    " + parentID);
			InitialContext ctx = new InitialContext();
			bioMightBean = (BioMightBeanLocal) ctx.lookup("java:global/BioMightWeb/BioMightBean!biomight.ejb.BioMightBeanLocal");
	
			double circumference = 0.125;
			
			if (componentID.equals("Serine:01")) {
				
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

					
				//int success = bioMightBean.generateSerine("Serine:00001", "Serine", 
				//		"Serine", componentID, parentID, currentPoints);			
				
			}
			else if (componentID.equals("Serine:02"))
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

				
				
				//int success = bioMightBean.generateSerine("Serine:00160", "Serine", 
				//	"Serine", componentID, parentID, currentPoints);
		
				
			}
			else if (parentID.equals("")) 
			{	
				System.out.println("Calling Generate Serine NoParent");		
			}

			
			System.out.println("Created Serine Info using EJB");   	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - Serine");
			throw new ServerException("Remote Exception Serine():", e); 	
		}
	}
	
	

	
	/********************************************************************************************************************
	 * GET X3D
	 * 
	 * This method will return the X3D for the Serine.  It runs through each of its components and collects up their
	 * representations and then assembles them into one unified X3D model.
	 * 
	 ********************************************************************************************************************/
	public String getX3D(boolean snipet) {
		
		// Assembe the Serine
		String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
		"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n " +
		"<X3D profile='Immersive' >\n" +
		"<head>\n" +
		 "<meta name='BioMightImage' content='Serine.jpg'/>\n" +
		 "<meta name='ExportTime' content='7:45:30'/>\n" +
		 "<meta name='ExportDate' content='08/15/2008'/>\n" +
		 "<meta name='BioMight Version' content='1.0'/>\n" + 
		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='Serine'\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		

		String body = "";
		String annotate = "";
		

		System.out.println("Getting X3D for Serine!!!!!!!!");

		
		// Only when the database retrieval has been locally, do we do this??
		if (viewPerspective == Constants.VIEW_INTERNAL) 
		{	
			
			//************************************************************888
			//**************************************************************8
			// HACK
			lod = Constants.MAG2X;
			//************************************************************
			//************************************************************

			
			System.out.println("Get X3D Serine - View Internal");
			// We do nada as the Serine Data is retrieved in the collection object
			// and the X3D is generated there
			if (lod == Constants.MAG2X)		
			{
				System.out.println("Get X3D Serine - View Internal - 2X");
				//We are going to get the X3D from the aggregation objects
				body += carbons.getX3D(true);	
			}
			else if (lod == Constants.MAG1X)
			{			
				// We went to the database to get data.  There will be 1 Transform record
			
				/*
				System.out.println("Creating Serine: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
				System.out.println("Creating Serine at Position: " + 
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
				    " url='../images/Serine.jpg'/>";
				
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
				 	"<Sphere DEF='SerineGeoSphere'\n" +
				 	"containerField='geometry'\n" +
				 	"radius='" + bioMightTransform.getRadius() +"'/>\n" +
				 	"</Shape>\n" +
				 	
					"\n<TouchSensor DEF='TSENSOR_"+ bioMightTransform.getId()+ "' \n" +
	                   " description='Serine'\n" +
		               " containerField='children'/> \n" +
	
				 "</Transform>\n";
				*/
			}
		
		}
		else if (viewPerspective == Constants.VIEW_HAWKEYE) 
		{
			System.out.println("Get X3D Serine - View Hawkeye");
			
			//************************************************************888
			//**************************************************************8
			// HACK
			lod = Constants.MAG1X;
			//************************************************************
			//************************************************************

			if (lod == Constants.MAG2X)		
			{
				System.out.println("Get X3D Serine - View Hawkeye -- 2X");
				//We are going to get the X3D from the aggregation objects
				body += carbons.getX3D(true);	
			}
			else if (lod == Constants.MAG1X)	
			{			
				// We went to the database to get data.  There will be 1 Transform record
				System.out.println("Get X3D Serine - View Hawkeye  1X");
					
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
				// Create the Serine Side Chain CH2 - OH
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
	
				
				// OH
				x = xBase - 0.30;
				y = yBase + 0.32;
				z = zBase + 0.0;
			
				gbioMightTransform.getTranslation().setXPos(x);
				gbioMightTransform.getTranslation().setYPos(y);
				gbioMightTransform.getTranslation().setZPos(z);

				String[] coAtoms4 = {"Hydrogen"};
				double[] coOrientation4 = {90};
				body+= BioWebDNA.getSimpleMolecule(gbioMightTransform, "Oxygen", coAtoms4, coOrientation4);  
	
				
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
			
		
	body+= "<Viewpoint DEF='Viewpoint_Serine'\n" +
			 "description='Viewpoint_Serine'\n" +
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

