/****************************************************************************************
 * Created on Aug 26, 2014
 *
 * Represents a collection of AdenoViruses
 * 
 * 
 ****************************************************************************************/


package biomight.chemistry.elements;
import java.lang.reflect.Method;
import java.util.ArrayList;

import javax.naming.InitialContext;

import biomight.BioMightBase;
import biomight.Constants;
import biomight.ejb.BioMightBeanLocal;
import biomight.ejb.BioMightCellularBeanLocal;
import biomight.exceptions.ServerException;
import biomight.view.BioMightMethodView;
import biomight.view.BioMightPosition;
import biomight.view.BioMightPropertyView;
import biomight.view.BioMightScale;
import biomight.view.BioMightTransform;
import biomightweb.util.BioWebDNA;

/*********************************************************************************
 * @author SurferJim
 *
 * Representation of a Collection of Coppers
 * 
 ********************************************************************************/

public class Coppers extends BioMightBase {
private ArrayList coppers;

	
	/********************************************************************************************************************
	 *  Coppers
	 * 
	 * This method will instantiate the Coppers that are defined for the current model.  
	 * 
	 ********************************************************************************************************************/

	public Coppers()
	{		
		int localVP= Constants.BIO_CHILD;
		int localLOD = Constants.VIEW_HAWKEYE;
		create(localVP, localLOD, Constants.CellsRef, null, null);
	}
	
	/********************************************************************************************************************
	 *  Coppers
	 * 
	 * This method will instantiate the Coppers that are defined for the current model.  
	 * 
	 ********************************************************************************************************************/

	public Coppers(String parentID)
	{				
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, parentID, null, null);
	}
	
	public Coppers(int localVP, int localLOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
	{		
		create(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);
	}
		
	/********************************************************************************************************************
	 * CREATE Coppers
	 * 
	 * This method will instantiate the hips that are defined for the current model.  
	 * 
	 ********************************************************************************************************************/

	private void create(int localVP, int localLOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods) 
	{
		this.setImage("images/Coppers.jpg");
		
		coppers = new ArrayList();
	
		// This is a collection, so set the parent of the children
		// to that of the aggregation object
		this.parentID=parentID;
		this.componentID = parentID;
		this.lod = localLOD;
		this.viewPerspective = localVP;
		
		
		if (bioMightMethods != null){
			System.out.println("EXECUTING Coppers Methods: " + bioMightMethods.size());
			executeMethods(bioMightMethods);
		}
		
		// Get the information from the database via the Enterprise Bean.  This will get
		// a collection of Coppers
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Getting Coppers Transform: " + componentID + "   " +  parentID);
			InitialContext ctx = new InitialContext();
			BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
			bioMightTransforms = bioMightBean.getComponents(Constants.CopperRef, parentID);   	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - Coppers");
			throw new ServerException("Remote Exception getComponents():", e); 	
		}
		
		
		// Run through the collection of coppers and build them into the model
		ArrayList transforms = bioMightTransforms.getTransforms();
		System.out.println("Have Coppers NumTransforms: " + transforms.size());
		
		// If we are culling the data set
		int numRetreive=transforms.size();
	
		BioMightScale bioScale = new BioMightScale("0.00, 0.00, 0.00");
		BioMightPosition  bioPos = new BioMightPosition("0.00, 0.00, 0.00");
		String bioTemplate="Coppers.x3d";

		for (int i=0; i<transforms.size(); i++)
		{
			// Get the information for the copper we are creating
			BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
			System.out.println("Creating Copper: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
			
			// Create an instance of a Copper for each tranform specified
			localVP = Constants.VIEW_INTERNAL;
			localLOD = Constants.MAG1X;
			
			Copper copper = new Copper(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);		
			System.out.println("Copper Created!: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
			coppers.add(copper);
			System.out.println("Added Copper to Collection!: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());

			// initialize the Properties
			// in this case, rather than pass canonical name, we pass the name found in the collectio
			initProperty(bioMightTransform.getName(), Constants.Copper, Constants.CopperRef, bioMightTransform.getId());				
			//initProperty(bioMightTransform.getName(), Constants.Copper, Constants.CopperRef, parentID);
			
			int numElements = 50;
			if (i == numElements)
				break;
		}

		// Set up methods that will be available to the coppers
		initMethods(bioMightMethods);
	}
	
	
	public void initMethods(ArrayList<BioMightMethodView> bioMightMethodsIn) {
			
		// If we are coming in normally the methods and properties will not
		// be populated.   When processing data they will and we need to use
		// those values
		if (bioMightMethodsIn.size() == 0) {
			System.out.println("New Set of CoppersMethods: " + bioMightMethodsIn.size());
			BioMightMethodView method = new BioMightMethodView();
			method.setCanonicalName(Constants.Coppers);
			method.setMethodName("setColonySize");
			method.setDisplayName("Colony Size:");
			method.setHtmlType("text");
			method.setDataType(Constants.BIO_INT);
			methods.add(method);
		}
		else
		{
			System.out.println("Using Existing CoppersMethods: " + bioMightMethodsIn.size());
			// using the data passed in from the previous invocation
			methods = bioMightMethodsIn;
		}
	}
	
	
	/********************************************************************************************************************
	 * GET X3D
	 * 
	 * This method will return the X3D for the Cell.  It runs through each of its components and collects up their
	 * representations and then assembles them into one unified X3D model.
	 * 
	 ********************************************************************************************************************/
	public String getX3D(boolean snipet) {
		
		// Assemble the Coppers
		String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
		"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n " +
		"<X3D profile='Immersive' >\n" +
		"<head>\n" +
		 "<meta name='BioMightImage' content='Hips.jpg'/>\n" +
		 "<meta name='ExportTime' content='7:45:30'/>\n" +
		 "<meta name='ExportDate' content='08/15/2008'/>\n" +
		 "<meta name='BioMight Version' content='1.0'/>\n" + 
		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='Coppers'\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		

		String body = ""; 


		// Grab the data from the collection that we just created.
		if (viewPerspective == Constants.VIEW_HAWKEYE)
		{
			System.out.println("Assembling X3D for Coppers HawkEyeView - size: " + coppers.size());
			
			// Run through the collection of Coppers and assemble the X3D for each
			for (int i=0; i<coppers.size(); i++)
			{
				// Get the information for the copper
				//Copper copper = (Copper) coppers.get(i);
				//System.out.println("Getting X3D for Copper: " + copper.getComponentID());
				//body += copper.getX3D(true);
			}		
			
			body="";
			
			
			ArrayList transforms = bioMightTransforms.getTransforms();
			for (int i=0; i<transforms.size(); i++)
			{
				// Get the information for the capsomer we are creating
				BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
				System.out.println("Getting X3D -InternalView - for Copper: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());				

				//System.out.println("Getting X3D for CopperX: " + bioMightTransform.getTranslation().getXPos());
				//System.out.println("Getting X3D for CopperY: " + bioMightTransform.getTranslation().getYPos());
				//System.out.println("Getting X3D for CopperZ: " + bioMightTransform.getTranslation().getZPos());
				// Change the height and width based on the displacement.
				
				String elementDesc = Constants.CopperRef + "-AtomicWeight: 29, %Body: less than 0.01";	
				body += "\n<Transform onmouseover=\"showComponent('" + elementDesc + "');\" DEF='" + bioMightTransform.getId() + "'\n";

				// Set the position if we are working with the Tissue collection
				if (parentID.equals("1.10000:0"))
				{
					//body += "translation='" 
					//	+ bioMightPosition.getXPos() + " " 
			 		//	+ bioMightPosition.getYPos() + " "
			 		//	+ bioMightPosition.getZPos() + "'\n";
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
				    " url='../images/Copper.jpg'/>";
				
				
				    
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
				 	"<Sphere DEF='CopperGeoSphere'\n" +
				 	"containerField='geometry'\n" +
				 	"radius='" + bioMightTransform.getRadius() +"'/>\n" +
				 	"</Shape>\n" +
				 	
					"\n<TouchSensor DEF='TSENSOR_" + bioMightTransform.getId() + "' \n" +
	                   " description='Copper'\n" +
		               " containerField='children'/> \n" +
	
				 "</Transform>\n";
								
				// Set up the positions for the 1st ring Electrons
				// 2N*N electrons in each shell
				double electronSize = BioWebDNA.getAtomicRadius("Electron");
				int nMaxRings = 4;
				int numElectrons = 0;
				double ringSize = 0.0;
				double[][] offSets = null;
				for (int eRing=0; eRing<nMaxRings; eRing++)
				{
					// Each ring expands around the Center
					ringSize = bioMightTransform.getRadius() +  ((electronSize*2) * (eRing+1));
					
					// Holds 2 of 29
					if (eRing == 0) {
						offSets = new double[2][3];
						
						offSets[0][0] = ringSize;
						offSets[0][1] = ringSize;
						offSets[0][2] = 0;
						
						offSets[1][0] = -ringSize;
						offSets[1][1] = ringSize;
						offSets[1][2] = 0;
					
					}
					// Holds 8
					else if (eRing == 1) {
						
						offSets = new double[8][3];
						
						offSets[0][0] = ringSize;
						offSets[0][1] = ringSize;
						offSets[0][2] = 0;
						
						offSets[1][0] = -ringSize;
						offSets[1][1] = ringSize;
						offSets[1][2] = 0;		
						
						offSets[2][0] = -ringSize;
						offSets[2][1] = -ringSize;
						offSets[2][2] = 0;
						
						offSets[3][0] = ringSize;
						offSets[3][1] = -ringSize;
						offSets[3][2] = 0;
						
						// y flat
						offSets[4][0] = ringSize;
						offSets[4][1] = 0;
						offSets[4][2] = -ringSize;
						
						offSets[5][0] = ringSize;
						offSets[5][1] = 0;
						offSets[5][2] = ringSize;
						
						offSets[6][0] = -ringSize;
						offSets[6][1] = 0;
						offSets[6][2] = ringSize;
						
						offSets[7][0] = -ringSize;
						offSets[7][1] = 0;
						offSets[7][2] = -ringSize;
						
					}
					// Holds 18
					else if (eRing == 2) {
						
						offSets = new double[18][3];
						
						offSets[0][0] = 0;
						offSets[0][1] = ringSize;
						offSets[0][2] = ringSize;
						
						offSets[1][0] = 0;
						offSets[1][1] = ringSize;
						offSets[1][2] = -ringSize;		
						
						offSets[2][0] = 0;
						offSets[2][1] = -ringSize;
						offSets[2][2] = -ringSize;
						
						offSets[3][0] = 0;
						offSets[3][1] = -ringSize;
						offSets[3][2] = ringSize;
						
						// y flat
						offSets[4][0] = ringSize;
						offSets[4][1] = 0;
						offSets[4][2] = -ringSize;
						
						offSets[5][0] = ringSize;
						offSets[5][1] = 0;
						offSets[5][2] = ringSize;
						
						offSets[6][0] = -ringSize;
						offSets[6][1] = 0;
						offSets[6][2] = ringSize;
						
						offSets[7][0] = -ringSize;
						offSets[7][1] = 0;
						offSets[7][2] = -ringSize;
						
						
						// Z Flat
						offSets[8][0] = ringSize;
						offSets[8][1] = 0;
						offSets[8][2] = 0;
						
						offSets[9][0] = 0;
						offSets[9][1] = ringSize;
						offSets[9][2] = 0;
						
						offSets[10][0] = -ringSize;
						offSets[10][1] = -ringSize;
						offSets[10][2] = 0;
						
						offSets[11][0] = -ringSize;
						offSets[11][1] =  ringSize;
						offSets[11][2] = 0;
						
						offSets[12][0] = ringSize;
						offSets[12][1] = ringSize;
						offSets[12][2] = 0;
						
						offSets[13][0] = ringSize;
						offSets[13][1] = ringSize;
						offSets[13][2] = 0;
						
						// Z-Y
						offSets[14][0] = -ringSize * .707;
						offSets[14][1] = 0;
						offSets[14][2] = ringSize * .707;
						
						offSets[15][0] = -ringSize;
						offSets[15][1] = 0;
						offSets[15][2] = -ringSize;
					
						offSets[16][0] = -ringSize;
						offSets[16][1] = 0;
						offSets[16][2] = ringSize;
						
						offSets[17][0] = -ringSize;
						offSets[17][1] = 0;
						offSets[17][2] = -ringSize;
					}
					// Holds 1
					else if (eRing == 3) {
						
						offSets = new double[1][3];
						
						offSets[0][0] = ringSize;
						offSets[0][1] = 0;
						offSets[0][2] = ringSize;
						
					}
	
					
					
					for (int k=0; k<offSets.length; k++)
					{
						
						body += "<Transform DEF='TRANSFORM_" + bioMightTransform.getId() + "' \n";
						
						
				 		body += "translation='" 
				 			+ (bioMightTransform.getTranslation().getXPos()  + offSets[k][0]) + " " 
	 						+ (bioMightTransform.getTranslation().getYPos()  + offSets[k][1]) + " "
	 						+ (bioMightTransform.getTranslation().getZPos()  + offSets[k][2]) + "'\n";					
				
	
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
						 	"<Sphere DEF='CalciumGeoSphere'\n" +
						 	"containerField='geometry'\n" +
						 	"radius='" + electronSize +"'/>\n" +
						 	"</Shape>\n" +
						 	
							"\n<TouchSensor DEF='TSENSOR_" + bioMightTransform.getId() + "' \n" +
			                   " description='Copper Electron'\n" +
				               " containerField='children'/> \n" +
			
						 "</Transform>\n";
					}
				}

			}

			
		}	
		// This is for when we are going to deal with the collection data separately.  Like
		// when we do not want to access the sub components.
		else if (viewPerspective == Constants.VIEW_INTERNAL)
		{	
			System.out.println("Assembling X3D for Coppers InternalView - size: " + coppers.size());
			
			ArrayList transforms = bioMightTransforms.getTransforms();
			for (int i=0; i<transforms.size(); i++)
			{
				// Get the information for the capsomer we are creating
				BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
				System.out.println("Getting X3D -InternalView - for Copper: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());				

				//System.out.println("Getting X3D for CopperX: " + bioMightTransform.getTranslation().getXPos());
				//System.out.println("Getting X3D for CopperY: " + bioMightTransform.getTranslation().getYPos());
				//System.out.println("Getting X3D for CopperZ: " + bioMightTransform.getTranslation().getZPos());
				// Change the height and width based on the displacement.
				body += "<Transform DEF='TRANSFORM_" + bioMightTransform.getId() + "' \n";
					
					
				// Set the position if we are working with the Tissue collection
				if (parentID.equals("1.10000:0"))
				{
					//body += "translation='" 
					//	+ bioMightPosition.getXPos() + " " 
			 		//	+ bioMightPosition.getYPos() + " "
			 		//	+ bioMightPosition.getZPos() + "'\n";
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
				    " url='../images/Copper.jpg'/>";
				
				
				    
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
				 	"<Sphere DEF='CopperGeoSphere'\n" +
				 	"containerField='geometry'\n" +
				 	"radius='" + bioMightTransform.getRadius() +"'/>\n" +
				 	"</Shape>\n" +
				 	
					"\n<TouchSensor DEF='TSENSOR_" + bioMightTransform.getId() + "' \n" +
	                   " description='Copper'\n" +
		               " containerField='children'/> \n" +
	
				 "</Transform>\n";

				
				// Set up the positions for the 1st ring Electrons
				// 2N*N electrons in each shell
				double electronSize = BioWebDNA.getAtomicRadius("Electron");
				int nMaxRings = 4;
				int numElectrons = 0;
				double ringSize = 0.0;
				double[][] offSets = null;
				for (int eRing=0; eRing<nMaxRings; eRing++)
				{
					// Each ring expands around the Center
					ringSize = bioMightTransform.getRadius() +  ((electronSize*2) * (eRing+1));
					
					// Holds 2 of 29
					if (eRing == 0) {
						offSets = new double[2][3];
						
						offSets[0][0] = ringSize;
						offSets[0][1] = ringSize;
						offSets[0][2] = 0;
						
						offSets[1][0] = -ringSize;
						offSets[1][1] = ringSize;
						offSets[1][2] = 0;
					
					}
					// Holds 8
					else if (eRing == 1) {
						
						offSets = new double[8][3];
						
						offSets[0][0] = ringSize;
						offSets[0][1] = ringSize;
						offSets[0][2] = 0;
						
						offSets[1][0] = -ringSize;
						offSets[1][1] = ringSize;
						offSets[1][2] = 0;		
						
						offSets[2][0] = -ringSize;
						offSets[2][1] = -ringSize;
						offSets[2][2] = 0;
						
						offSets[3][0] = ringSize;
						offSets[3][1] = -ringSize;
						offSets[3][2] = 0;
						
						// y flat
						offSets[4][0] = ringSize;
						offSets[4][1] = 0;
						offSets[4][2] = -ringSize;
						
						offSets[5][0] = ringSize;
						offSets[5][1] = 0;
						offSets[5][2] = ringSize;
						
						offSets[6][0] = -ringSize;
						offSets[6][1] = 0;
						offSets[6][2] = ringSize;
						
						offSets[7][0] = -ringSize;
						offSets[7][1] = 0;
						offSets[7][2] = -ringSize;
						
					}
					// Holds 18
					else if (eRing == 2) {
						
						offSets = new double[18][3];
						
						offSets[0][0] = 0;
						offSets[0][1] = ringSize;
						offSets[0][2] = ringSize;
						
						offSets[1][0] = 0;
						offSets[1][1] = ringSize;
						offSets[1][2] = -ringSize;		
						
						offSets[2][0] = 0;
						offSets[2][1] = -ringSize;
						offSets[2][2] = -ringSize;
						
						offSets[3][0] = 0;
						offSets[3][1] = -ringSize;
						offSets[3][2] = ringSize;
						
						// y flat
						offSets[4][0] = ringSize;
						offSets[4][1] = 0;
						offSets[4][2] = -ringSize;
						
						offSets[5][0] = ringSize;
						offSets[5][1] = 0;
						offSets[5][2] = ringSize;
						
						offSets[6][0] = -ringSize;
						offSets[6][1] = 0;
						offSets[6][2] = ringSize;
						
						offSets[7][0] = -ringSize;
						offSets[7][1] = 0;
						offSets[7][2] = -ringSize;
						
						
						// Z Flat
						offSets[8][0] = ringSize;
						offSets[8][1] = 0;
						offSets[8][2] = 0;
						
						offSets[9][0] = 0;
						offSets[9][1] = ringSize;
						offSets[9][2] = 0;
						
						offSets[10][0] = -ringSize;
						offSets[10][1] = -ringSize;
						offSets[10][2] = 0;
						
						offSets[11][0] = -ringSize;
						offSets[11][1] =  ringSize;
						offSets[11][2] = 0;
						
						offSets[12][0] = ringSize;
						offSets[12][1] = ringSize;
						offSets[12][2] = 0;
						
						offSets[13][0] = ringSize;
						offSets[13][1] = ringSize;
						offSets[13][2] = 0;
						
						// Z-Y
						offSets[14][0] = -ringSize * .707;
						offSets[14][1] = 0;
						offSets[14][2] = ringSize * .707;
						
						offSets[15][0] = -ringSize;
						offSets[15][1] = 0;
						offSets[15][2] = -ringSize;
					
						offSets[16][0] = -ringSize;
						offSets[16][1] = 0;
						offSets[16][2] = ringSize;
						
						offSets[17][0] = -ringSize;
						offSets[17][1] = 0;
						offSets[17][2] = -ringSize;
					}
					// Holds 1
					else if (eRing == 3) {
						
						offSets = new double[1][3];
						
						offSets[0][0] = ringSize;
						offSets[0][1] = 0;
						offSets[0][2] = ringSize;
						
					}
	
					
					
					for (int k=0; k<offSets.length; k++)
					{
						
						body += "<Transform DEF='TRANSFORM_" + bioMightTransform.getId() + "' \n";
						
						
				 		body += "translation='" 
				 			+ (bioMightTransform.getTranslation().getXPos()  + offSets[k][0]) + " " 
	 						+ (bioMightTransform.getTranslation().getYPos()  + offSets[k][1]) + " "
	 						+ (bioMightTransform.getTranslation().getZPos()  + offSets[k][2]) + "'\n";					
				
	
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
						 	"<Sphere DEF='CalciumGeoSphere'\n" +
						 	"containerField='geometry'\n" +
						 	"radius='" + electronSize +"'/>\n" +
						 	"</Shape>\n" +
						 	
							"\n<TouchSensor DEF='TSENSOR_" + bioMightTransform.getId() + "' \n" +
			                   " description='Copper Electron'\n" +
				               " containerField='children'/> \n" +
			
						 "</Transform>\n";
					}
				}
			}
		}			

		body+= "<Viewpoint DEF='Viewpoint_Copper'\n" +
				 "description='Viewpoint_Copper'\n" +
				 "jump='true'\n" +
				 "fieldOfView='0.785'\n" +
				 "position='0.0 0.0 180.0'\n" +
				 "orientation='0 0 1 0'/>\n";
		
		//System.out.println("Coppers X3D: " + body);		
		String footer = "</Scene>" + "</X3D>\n";
		
		if (snipet)
			return body;			
		else	
			return header + body + footer;
	}


	/******************************************************************************************
	 * EXECUTE METHODS 
	 *
	 ******************************************************************************************/
	public void executeMethods(ArrayList<BioMightMethodView> bioMightMethods) {

		// Run through the argument list and executes the 
		// associated methods
		boolean fired = false;
		System.out.println("Coppers-Executing Methods: " + bioMightMethods.size());
		for (int j=0; j<bioMightMethods.size(); j++){
			
			// Get the parameter from the list and if it is not
			// empty execute the associated method using it
			BioMightMethodView bioMightMethod = (BioMightMethodView) bioMightMethods.get(j);
			System.out.println("Have BioMightMethod for Coppers: " + bioMightMethod.getMethodName());	
			String methodName = bioMightMethod.getMethodName();
			String canonicalName = bioMightMethod.getCanonicalName(); 
			String dataType = bioMightMethod.getDataType();
			String methodParam = bioMightMethod.getMethodParameter(); 
			if (methodParam == null)
				methodParam = "";
			
			// We only execute those methods that are targeted for the IRIS
			// If a parameter is specified then we fire the method, otherwise
			// we just jump over it
			if (canonicalName.equals(Constants.Coppers)) {				
				if (!methodParam.equals(""))
				{
					System.out.println("Execute Method " + methodName + " with Signature: "  +  dataType);
					System.out.println("with DataType: "  +  dataType  + "   value: " + methodParam);
					
					fired=true;		
					// Use the DataType parameter to convert the data into its base form
				
					if (dataType.equals("int")) {
						
						try {
							System.out.println("Locating Method(Integer)" + methodName);
							// 	Locate the method through introspection
							int numElements = Integer.parseInt(methodParam);
							Class paramsType[] = {int.class};
							Method method = this.getClass().getDeclaredMethod(methodName, paramsType);
							System.out.println("Before Execute Method(Integer)" + methodName);
							Object result = method.invoke(this, numElements);
							System.out.println("After Execute Method(Integer)" + methodName);	
						}
						catch (NumberFormatException e)
						{
							System.out.println("Could not Convert to int: " + methodParam);						
						}
						catch (NoSuchMethodException e)
						{
							System.out.println("Method with int param not found: " + e);						
						}	
						catch (Exception e)
						{
							System.out.println("General Exception occurred: " + e);						
						}										
					}
					else if (dataType.equals("double")) {
					
						try {
							System.out.println("Locating Method(Double)" + methodName);
							// Locate the method through introspection
							double numElements = Double.parseDouble(methodParam);
							if (numElements > 0.0)
							{
								Class paramsType[] = {double.class};
								Method method = this.getClass().getDeclaredMethod(methodName, paramsType);
								System.out.println("Before Execute Method(Double)" + methodName);
								Object result = method.invoke(this, numElements);
								System.out.println("After Execute Method(Double)" + methodName);
							}
							else
								System.out.println("Not Executing Double - 0.0"); 
							}
							catch (NumberFormatException e)
							{
								System.out.println("Could not Convert to double: " + methodParam);						
							}
							catch (NoSuchMethodException e)
							{
								System.out.println("Method with double param not found: " + e);						
							}	
							catch (Exception e)
							{
								System.out.println("General Exception: " + e);						
							}										
					}
					else if (dataType.equals("String")) {
						
						
						try {
							System.out.println("Locating Method(String)");
							
							Class paramsType[] = {String.class};
							Method method = this.getClass().getDeclaredMethod(methodName, paramsType );
							System.out.println("Method with String Param: " + methodName);
							
							System.out.println("Before Execute Method(String)" + methodName);
							Object result = method.invoke(this, methodParam);
							System.out.println("After Execute Method(String)" + methodName);
									
						}
						catch (NoSuchMethodException e)
						{
							System.out.println("Method with String param not found!");						
						}	
						catch (Exception e)
						{
							System.out.println("General Exception: " + e);						
						}	
						
					}
					else if (dataType.equals("")) {
						System.out.println("Data Type not found!!!");	
					}	
				}	
			}
			if (fired)
			{	
				System.out.println("Coppers - Methods have fired.   Calling Coppers Save method!");
			}
		}
	}

	

	/******************************************************************************************
	 * SET COLONY SIZE 
	 *
	 * This method will set the Colony size for the Coppers.  
	 *****************************************************************************************/
	public void setColonySize(int size) {

		// Run through the argument list and executes the 
		// associated methods
		boolean fired = false;
		System.out.println("Coppers-SetColony Size: " + size);
		
		// Generate the Copper		
		BioMightCellularBeanLocal bioMightBean;
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Generating the Copper Colony: " + componentID + "    " + parentID);
			InitialContext ctx = new InitialContext();
			//bioMightBean = (BioMightCellularBeanLocal) ctx.lookup("biomight.ejb.BioMightCellularBeanLocal");
			bioMightBean = (BioMightCellularBeanLocal) ctx.lookup("java:global/BioMightWeb/BioMightCellularBean!biomight.ejb.BioMightCellularBeanLocal");
	
			double currentPoints[][] = null;
		//	int success = bioMightBean.generateCoppers(size, "Copper:00001", "Copper", 
		//		"Copper", this.componentID, this.parentID, currentPoints);
			
			System.out.println("Created Copper Info using EJB");   	
		}catch (Exception e) { 
			System.out.println("Exception Creating Colony - Copper");
			throw new ServerException("Remote Exception CopperEpithelium():", e); 	
		}
	}
	
}
