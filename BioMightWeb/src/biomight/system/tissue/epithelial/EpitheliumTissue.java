/*
 * Created on Jul 22, 2006
 * Copyright 2006 - Biomight.org
 * 
 * This code is the not to be used without written permission from
 * BioMight.org
 * 
 */

package biomight.system.tissue.epithelial;

import java.io.File;
import java.util.ArrayList;

import javax.naming.InitialContext;






import biomight.Constants;
import biomight.ejb.BioMightBeanLocal;
import biomight.ejb.BioMightTissueBeanLocal;
import biomight.exceptions.ServerException;
import biomight.system.tissue.Tissue;
import biomight.view.BioMightBoundBox;
import biomight.view.BioMightColor;
import biomight.view.BioMightConstruct;
import biomight.view.BioMightGenerate;
import biomight.view.BioMightMethodView;
import biomight.view.BioMightPosition;
import biomight.view.BioMightPropertyView;
import biomight.view.BioMightTransform;
import biomight.view.BioMightTransforms;

/**********************************************************************************************
 * Representation of Epithelial Tissue.  
 * 
 * @author SurferJim
 *
 **********************************************************************************************/

public class EpitheliumTissue extends Tissue {
	private String componentType = "EpitheliumTissue";
	private String componentName = "EpitheliumTissue";
	private BioMightTransforms bioMightTransforms;
	private BioMightPosition bioMightPosition;
	


	/***********************************************************************************
	 * EpitheliumTissue Constructor
	 *
	 * Generalized routine for creating Epithelial tissue.  The type of tissue being
	 * created is passed into the routine.
	 *
	 * Release 3 - take this data from scans
	 *
	 * Release 5 - Using the DNA sequence, create a collection of Epithelial 
	 * cells based on its pattern
	 * 
	 * @param dnaSequence
	 **********************************************************************************/

	public EpitheliumTissue()
	{
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, "EpitheliumTissue:00001", Constants.EpitheliumTissueRef, null, Constants.OrgansRef, null, null);
	}

	public EpitheliumTissue(String parentID)
	{
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, "EpitheliumTissue:00001", parentID, Constants.EpitheliumTissueRef, Constants.EpitheliumTissueRef, null, null);
	}
	
	// The most evolved - everything you need to create the tissue
	public EpitheliumTissue(String componentType, String parentID, ArrayList<BioMightMethodView> bioMightMethods)
	{
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;	
		create(localVP, localLOD, "EpitheliumTissue:00001", componentType, Constants.EpitheliumTissueRef, parentID, null, bioMightMethods);
	}

	// The most evolved - everything you need to create the tissue
	public EpitheliumTissue(String startID, String componentType, String componentName, String parentID, BioMightConstruct bioMightConstruct, ArrayList<BioMightMethodView> bioMightMethods)
	{
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;	
		create(localVP, localLOD, startID, componentType, componentName, parentID, null, bioMightMethods);
	}

	
	public EpitheliumTissue(int hierarchy, int LOD, String startID, String componentType, String componentName, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
	{
		create(hierarchy, LOD, startID, componentType, componentName, parentID, bioMightProperties, bioMightMethods);
	}
	
	/***********************************************************************************
	 *
	 * CREATE
	 *  
	 * @param dnaSequence
	 **********************************************************************************/
		
	
	public void create(int hierarchy, int LOD, String startID, String componentType, String componentName, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
	{
		this.setImage("images/Epithelium.jpg");
		this.setImageHeight(300);
		this.setImageWidth(300);
		this.parentID = parentID;
				
		if (!componentType.equals(""))
			this.componentType = componentType;
		if (!componentName.equals(""))
			this.componentName = componentName;
	
		// Generate the Epithelium Tissue
		//System.out.println("EpitheliumTissue: "+ componentType + " for parent: " + parentID +" at Startpos: " + startID);
		
		/*
		// Create a block of Epithelium Tisssue
		boolean bGenerate = true;
		System.out.println("Calling Generate Epithelium for parent: " + parentID);
		
		// Create the Epithelium
		BioMightGenerate bioGenerateEpi = generate(startID, componentType, componentName, parentID, bioMightConstruct);		
		this.bioMightGenerate.setMapComponent(componentID, bioGenerateEpi);
		System.out.println("EpiTissue - Stored GeneratedEpithelium for parent: " + parentID);
		*/
		
		// Get the data for the Back that is defined for this 
		// body reference.    	
		try {
			// Get the information from the database via the Enterprise Bean		
			//System.out.println("Getting EpitheliumInfo for ParentID: " + parentID);
			InitialContext ctx = new InitialContext();
			BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
			bioMightTransforms = bioMightBean.getComponents(componentType, parentID);
			//System.out.println("Have Epithelium Info from EJB");   	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - Epithelium");
			throw new ServerException("Remote Exception getComponents():", e); 	
		}
		
			
		// Run through the collection Back Epithelium
		ArrayList transforms = bioMightTransforms.getTransforms();
		System.out.println(componentType + " Epithelium NumTransforms: " + transforms.size());
		for (int i=0; i<transforms.size(); i++)
		{
			// Get the information for the Upper Lip we are creating
			BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
			//System.out.println("Created Epithelium (name,id): " + bioMightTransform.getName() + "  " + bioMightTransform.getId());		
	
			componentID = bioMightTransform.getId();
			
			//chondrocytes = new Chondrocytes();
			//chondrocyteExtraCellularMatrix = new ChondrocyteExtraCellularMatrix();		
		}		
		
		//System.out.println("Created the Epithelium for parent: " + parentID);
		initProperties();
		initMethods();
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
	
	
	/*********************************************************************************************************
	 * GENERATE EPITHELIUM
	 * 
	 * This method generates the Epithelial tissue. 
	 * 
	 *********************************************************************************************************/
				
	private BioMightGenerate generate(String startID, String componentType, String componentName, String parentID, BioMightConstruct bioMightConstruct)
	{
		// Generate the Epithelium		
		BioMightTissueBeanLocal bioMightBean;
		BioMightGenerate generatedEpithelium = null;
			
		try {
			// Get the information from the database via the Enterprise Bean		
			//System.out.println("Generating the Epithelium for ParentID: " + parentID);
			InitialContext ctx = new InitialContext();
			bioMightBean = (BioMightTissueBeanLocal) ctx.lookup("java:global/BioMightWeb/BioMightTissueBean!biomight.ejb.BioMightTissueBeanLocal");
		
			// Store information about the generation into a BioMightGenerate object
			//System.out.println("Calling generateEpitheliumEJB for ParentID: " + parentID);
			//generatedEpithelium = bioMightBean.generateEpithelium(startID, componentType, 
			//		componentName, componentID, parentID, bioMightConstruct);			
			//System.out.println("Generated Epithelium for ParentID: " + parentID);
			
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - Epithelium");
			throw new ServerException("Remote Exception getComponents():", e); 	
		}
			
		return (generatedEpithelium);	
	}
		
	
	/********************************************************************************************************************
	 * GET X3D
	 * 
	 * This method will return the X3D for the Cartilage.  It runs through each of its components and collects up their
	 * representations and then assembles them into one unified X3D model.
	 * 
	 ********************************************************************************************************************/

	public String getX3D(boolean snipet) {
		
		// Assemble the EpitheliumTissue
		String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
		"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n " +
		"<X3D profile='Immersive' >\n" +
		"<head>\n" +
		 "<meta name='BioMightImage' content='EpitheliumTissue.jpg'/>\n" +
		 "<meta name='ExportTime' content='7:45:30'/>\n" +
		 "<meta name='ExportDate' content='08/15/2008'/>\n" +
		 "<meta name='BioMight Version' content='1.0'/>\n" + 
		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='EpitheliumTissue'\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		

		String body = "";
		String annotate = "";
		
		// Run through the collection of Epithelium and build them into the model
		// In the default case, we get one instance of the Pupil for each eye
		ArrayList transforms = bioMightTransforms.getTransforms();
		//System.out.println(tissueName + " Epithelium X3D Elements: " + transforms.size());
		//System.out.println("EpitheliumTissueX3D: "+ componentType + " for parent: " + parentID);
		
		for (int i=0; i<transforms.size(); i++)
		{
			// Get the information for the PinnaAntiHelix we are creating
			BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
			//System.out.println("Getting Epithelium X3D: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
		
				
			int view = Constants.VIEW_FLOATING;
			if (view == Constants.VIEW_FLOATING)
			{
				//System.out.println("Getting X3D for EpitheliumTissue: " + bioMightSphere.getTranslation().getXPos());
				//System.out.println("Getting X3D for EpitheliumTissue: " + bioMightSphere.getTranslation().getYPos());
				//System.out.println("Getting X3D for EpitheliumTissue: " + bioMightSphere.getTranslation().getZPos());
				// Change the height and width based on the displacement.
				
				//String tempComponentType = "Section_" +i;
				//tempComponentType = "";
				body += "<Transform  onmouseover=\"showComponent('" + bioMightTransform.getComponentID() +  "');\"  DEF='" + bioMightTransform.getComponentName() + "'\n";
								
				// Set the position if we are working with the Tissue collection
				if (parentID.equals("1.1000:0"))
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
				
			 	body+= "scale='" 	+ bioMightTransform.getScale().getXPos() + " "
			 				+ bioMightTransform.getScale().getYPos() + " "
			 				+ bioMightTransform.getScale().getZPos() + "'>\n" +
					"<Shape DEF='" + componentType + "'\n" +
						    " containerField='children'>\n" +
						    " <Appearance\n" +
						    "  containerField='appearance'>\n";
					    
			 	// Set the user selected color first
			 	// then pick up one of these hacks
			 	String baseTextureFile = bioMightTransform.getTextureFile();
			 	//System.out.println("Base Texture is: " + baseTextureFile  +  "   " + bioMightTransform.getTextureID());
			 	if (baseTextureFile != null && !baseTextureFile.equals(""))
			    {
			 		// See if we can open the file
					 try {
						 File myFile = new File(baseTextureFile);
						 boolean exists = myFile.exists();		
					 }
					 catch (Exception e)
					 {
						 System.out.println("Warning: Cannot load the texture file: " + baseTextureFile);
						 baseTextureFile = "EpitheliumTissue.jpg";
					 }
				}
			    else
			    {
			   	 	System.out.println("Warning: Texture file not defined: " + baseTextureFile);
			   	 	baseTextureFile = "EpitheliumTissue.jpg";
			    }
			 	
					    
			    if (parentID.equals("Bladder:01"))
			    {
			    	baseTextureFile = "Bladder.jpg";
				}	
			    else if (parentID.contains("GallBladder:") || parentID.contains("Duct"))
			    {
			    	baseTextureFile = "SpeckledGreen.png";
				}	
			    // We are looking at the base tissue collection
			    else if (parentID.contains("Pancreas"))
			    {
			       baseTextureFile = "SpeckledSunshine.png";
				}
			    else if (parentID.contains("Stomach"))
			    {
			    	baseTextureFile = "SpeckledFuchsia.png";
				}		
			    else if (parentID.contains("Kidney:0"))
			    {
			    	baseTextureFile = "KidneyTissue.jpg";  
				}	
			    else if (parentID.equals("Liver:01"))
			    {
			    	baseTextureFile = "LiverTissue.jpg";
				}
			    else if (parentID.contains("Spleen"))
			    {
			    	baseTextureFile = "SpleenTissue.png";
				}
			    else if (parentID.contains("Bronchus") || parentID.contains("Trachea"))
			    {
			    	baseTextureFile = "Bronchus.gif";
				}			    
			    else if (parentID.contains("Esophagus"))
			    {
			    	baseTextureFile= "EsophagusTissue.gif";
				}	
			    else if ( parentID.contains("Brain") || parentID.contains("Cerebrum") )
			    {
			    	baseTextureFile= "BrainTissue.jpg";
				}	
			    else if (parentID.contains("Cerebellum"))
			    {
			    	baseTextureFile= "CerebellumTissue.jpg";
				}	
			    else if (parentID.contains("GolgiApparatus"))
				{
			    		baseTextureFile= "SpeckledGreen.png";
				}
			    else if (parentID.contains("EndoPlasmicReticulum"))
				{
			    	baseTextureFile = "SpeckledOrange.png";
				}
			    
			    
				body+= " <ImageTexture containerField='texture' " +
				       " url='../images/" + baseTextureFile +"'/>";
			    
			    
				body+= " <Material DEF='Rust'\n" +
				    "containerField='material'\n" +
				    "ambientIntensity='" + bioMightTransform.getMaterial().getAmbientIntensity() + "'\n" +
				    "shininess='" 		 + bioMightTransform.getMaterial().getShininess() + "'\n" +
				    "transparency='" 	 + bioMightTransform.getMaterial().getTransparency() + "'\n" +
				    "diffuseColor='" + 
				    bioMightTransform.getMaterial().getDiffuseColor().getRed() + " " + 
				    bioMightTransform.getMaterial().getDiffuseColor().getGreen() + " " +
				    bioMightTransform.getMaterial().getDiffuseColor().getBlue() + "'/>\n" +
				 	"</Appearance>\n" +			    
				 	"<IndexedFaceSet DEF='EpitheliumTissueIFS' \n" +
				    	 
				    	   "creaseAngle='" + 3.14 + "'\n" +
				    	   "solid='false' \n" +
				    	   "coordIndex='" + bioMightTransform.getCoordindexStr() + "'>" +
				    	   "<Coordinate DEF='EpitheliumTissue_Coord' \n" +
				    	    "containerField='coord' point='" +  bioMightTransform.getCoordpointStr() + "'/>" +
				    	  "</IndexedFaceSet>\n" +
				    	 "</Shape>\n" +
				    	 
				    	 
				    	 "<TouchSensor DEF='StartEndothelium' \n" +
		                   " description='" + componentType + "'\n" +
			               " containerField='children'/> \n" +
				    	 
				"</Transform>\n"; 
				
			    if (parentID.equals("SmallIntestine:0001") && (i % 8 == 0))
			    {
			    	
				   
					//******************************************
					// Create The Base Cylindrical Spike
					///*****************************************
					body += "<Transform DEF='TRANSFORM_" + bioMightTransform.getId() + "' \n";
					
					BioMightPosition vertex = bioMightTransform.getCoordinateZero();
				 	body += "translation='" 
				 		+ vertex.getXPos() + " " 
	 					+ vertex.getYPos() + " "
	 					+ vertex.getZPos() + "'\n";					
				 	
					body +=  "scale='1 1 1'>\n\n" +
					
					 	"<Shape DEF='SHAPE_" + 111 + "' \n" +
					    " containerField='children'>\n" +
					    " <Appearance\n" +
					    "  containerField='appearance'>\n";
	
					body+= " <ImageTexture containerField='texture' " +
						    " url='../images/BacillusAnthracis.jpg'/>";
					
					body+= " <Material DEF='Rust'\n" +
					    "containerField='material'\n" +
					    "ambientIntensity='" 	+ bioMightTransform.getMaterial().getAmbientIntensity() + "'\n" +
					    "shininess='" 			+ bioMightTransform.getMaterial().getShininess() + "'\n" +
					    "transparency='" 		+ 0.25 + "'\n" +
					    "diffuseColor='0.0  1.0  0.0'/>\n" +
					 	"</Appearance>\n" +
					
					 	"<Cylinder DEF='ZeroPointer'\n" +
					 	"containerField='geometry'\n" +
					 	"radius='" + 0.1 +"'\n" +
					 	"height='" + 0.05 +"'/>\n" +
					 	"</Shape>\n" +
					 "</Transform>\n";
			    }
			}
		}
	
			
		//System.out.println("EpitheliumTissue X3D: " + body);		
		String footer = "</Scene>" + "</X3D>\n";
		
		if (snipet)
			return body + annotate;			
		else	
			return header + body + annotate + footer;
	}


	public BioMightColor getBioMightColor() {
		return bioMightColor;
	}


	public void setBioMightColor(BioMightColor bioMightColor) {
		this.bioMightColor = bioMightColor;
	}

}
