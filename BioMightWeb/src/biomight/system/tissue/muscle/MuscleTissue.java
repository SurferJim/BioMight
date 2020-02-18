/*
 * Created on Jul 20, 2006
 * Copyright 2006 - Biomight.org
 * 
 * This code is the not to be used without written permission from
 * BioMight.org
 * 
 */
 
package biomight.system.tissue.muscle;

import java.util.ArrayList;

import javax.naming.InitialContext;

import biomight.BioMightBase;
import biomight.Constants;
import biomight.ejb.BioMightBeanLocal;
import biomight.exceptions.ServerException;
import biomight.view.BioMightColor;
import biomight.view.BioMightMethodView;
import biomight.view.BioMightPosition;
import biomight.view.BioMightPropertyView;
import biomight.view.BioMightTransform;


/**********************************************************************************************
 * Muscle Tissue
 * 
 * @author SurferJim
 *
 * Representation of Muscle Tissue
 * 
 **********************************************************************************************/

public class MuscleTissue extends BioMightBase {
	private String tissueName = "MuscleTissue";
	private String tissueRef = "MuscleTissue";
	private BioMightPosition bioMightPosition;
	
	
	/***********************************************************************************
	 * MuscleTissue Constructor
	 *
	 * Using the DNA sequence, create a collection of Muscle cells based on its
	 * pattern
	 * 
	 * @param dnaSequence
	 **********************************************************************************/
	
	
	public MuscleTissue()
	{
		create(this.tissueRef, Constants.MuscleTissueRef, null);
	}

	public MuscleTissue(String parentID)
	{
		create(this.tissueRef, parentID, null);
	}
	
	public MuscleTissue(String parentID, BioMightPosition bioMightPosition)
	{
		create(this.tissueRef, parentID, null);
		this.bioMightPosition = bioMightPosition;
	}
	
	public MuscleTissue(String parentID, ArrayList<BioMightMethodView> bioMightMethods)
	{
		create(this.tissueRef, parentID, bioMightMethods);
	}

	public MuscleTissue(String tissueRef, String parentID, ArrayList<BioMightMethodView> bioMightMethods)
	{
		create(tissueRef, parentID, bioMightMethods);
		this.tissueRef = tissueRef;
	}
	
	
	/**********************************************************************************************
	 * CREATE
	 *  
	 * @param tissueRef
	 * @param parentID
	 * @param bioMightMethods
	 *********************************************************************************************/
	
	public void create(String tissueRef, String parentID, ArrayList<BioMightMethodView> bioMightMethods)
	{
		this.setImage("images/MuscleTissue.jpg");
		this.setImageHeight(300);
		this.setImageWidth(300);
		this.parentID = parentID;
		
		System.out.println("Getting MuscleTissue: " + tissueRef + " for parent: " + parentID);
		
		// Get the information from the database via the Enterprise Bean				
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Getting MuscleTissueInfo for ParentID: " + parentID);
			InitialContext ctx = new InitialContext();
			
			BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
			bioMightTransforms = bioMightBean.getComponents(tissueRef, parentID);
			//System.out.println("Have MuscleTissue Info from EJB");   	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - MuscleTissue");
			throw new ServerException("Remote Exception getComponents():", e); 	
		}
		
			
		// Run through the collection Muscle Tissue
		ArrayList transforms = bioMightTransforms.getTransforms();
		System.out.println(tissueName + " MuscleTissue NumTransforms: " + transforms.size());
		for (int i=0; i<transforms.size(); i++)
		{
			// Get the information for the Upper Lip we are creating
			BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
			//System.out.println("Created Muscle (name,id): " + bioMightTransform.getName() + "  " + bioMightTransform.getId());		
	
			//chondrocytes = new Chondrocytes();
			//chondrocyteExtraCellularMatrix = new ChondrocyteExtraCellularMatrix();		
		}		
		
		System.out.println("Created the MuscleTissue for parent: " + parentID);
		//initProperties();
		initMethods();
		System.out.println("MuscleTissue Initialized " + parentID);
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
		method.setMethodName("Expand");
		method.setHtmlType("checkbox");
		methods.add(method);	
		
		method = new BioMightMethodView();
		method.setMethodName("Contract");
		method.setHtmlType("checkbox");
		methods.add(method);
	}
	
	
	/********************************************************************************************************************
	 * GET X3D
	 * 
	 * This method will return the X3D for the Tissue.  It runs through each of its components and collects up their
	 * representations and then assembles them into one unified X3D model.
	 * 
	 ********************************************************************************************************************/

	public String getX3D(boolean snipet) {
		
		// Assemble the MuscleTissue
		String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
		"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n " +
		"<X3D profile='Immersive' >\n" +
		"<head>\n" +
		 "<meta name='BioMightImage' content='MuscleTissue.jpg'/>\n" +
		 "<meta name='ExportTime' content='7:45:30'/>\n" +
		 "<meta name='ExportDate' content='08/15/2008'/>\n" +
		 "<meta name='BioMight Version' content='1.0'/>\n" + 
		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='MuscleTissue'\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		

		String body = "";
		String annotate = "";
		
		
		int view = Constants.VIEW_FLOATING;
		if (view == Constants.VIEW_HAWKEYE)
		{
			//muscleFiber.getX3D(true);
		}
		else if (view == Constants.VIEW_FLOATING)
		{	
			// Run through the collection of MuscleTissue Muscle and build them into the model
			// In the default case, we get one instance of the Pupil for each eye
			ArrayList transforms = bioMightTransforms.getTransforms();
			for (int i=0; i<transforms.size(); i++)
			{
				// Get the information for the PinnaAntiHelix we are creating
				BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
				//System.out.println("Getting Muscle X3D: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
				componentID = bioMightTransform.getId();
				String componentType = bioMightTransform.getComponentType(); 
		
				//System.out.println("Getting X3D for MuscleTissue: " + bioMightSphere.getTranslation().getXPos());
				//System.out.println("Getting X3D for MuscleTissue: " + bioMightSphere.getTranslation().getYPos());
				//System.out.println("Getting X3D for MuscleTissue: " + bioMightSphere.getTranslation().getZPos());
				// Change the height and width based on the displacement.
				body += "<Transform  onmouseover=\"showComponent('" + componentID +  "');\"  DEF='" + bioMightTransform.getId() + "'\n";
				
				body += "translation='" 
					+ bioMightTransform.getTranslation().getXPos() + " " 
 					+ bioMightTransform.getTranslation().getYPos() + " "
 					+ bioMightTransform.getTranslation().getZPos() + "'\n";					
						
			 	body+= "scale='" 	
			 		+ bioMightTransform.getScale().getXPos() + " "
			 		+ bioMightTransform.getScale().getYPos() + " "
			 		+ bioMightTransform.getScale().getZPos() + "'>\n" +
			 			"<Shape DEF='" + tissueRef +  "'\n" +
						    " containerField='children'>\n" +
						    " <Appearance\n" +
						    "  containerField='appearance'>\n";    
				
			 	
				// We are looking at the base tissue collection
			    //if (parentID.startsWith("Muscle"))
			    //{
				    body+= " <ImageTexture containerField='texture' " +
				    " url='../images/MuscleTissue.gif'/>";
				//}
			
		 	
				 body += " <Material DEF='Rust'\n" +
						    "containerField='material'\n" +
						    "ambientIntensity='" + bioMightTransform.getMaterial().getAmbientIntensity() + "'\n" +
						    "shininess='" 		 + bioMightTransform.getMaterial().getShininess() + "'\n" +
						    "transparency='" 	 + bioMightTransform.getMaterial().getTransparency() + "'\n" +
						    "diffuseColor='" + 
						    bioMightTransform.getMaterial().getDiffuseColor().getRed() + " " + 
						    bioMightTransform.getMaterial().getDiffuseColor().getGreen() + " " +
						    bioMightTransform.getMaterial().getDiffuseColor().getBlue() + "'/>\n" +
						 	"</Appearance>\n" +			    
						 	"<IndexedFaceSet DEF='MuscleTissueIFS' \n" +
						    	   "containerField='geometry' \n" +
						    	   "creaseAngle='" +  bioMightTransform.getCreaseAngle() + "'\n" +
						    	   "coordIndex='" + bioMightTransform.getCoordindexStr() + "'>" +
						    	   "<Coordinate DEF='MuscleTissue_Coord' \n" +
						    	    "containerField='coord' point='" +  bioMightTransform.getCoordpointStr() + "'/>" +
						    	  "</IndexedFaceSet>\n" +
					"</Shape>\n" +
					
				
					
					"<TouchSensor DEF='StartMuscle' \n" +
	                   " description='" + tissueRef + "'\n" +
		               " containerField='children'/> \n" +
					
					"</Transform>\n"; 
			}
		
		}	
			
		//System.out.println("MuscleTissue X3D: " + body);		
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
