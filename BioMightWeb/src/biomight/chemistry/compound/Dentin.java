/*
 * Created on Jul 22, 2006
 * Copyright 2006 - Biomight.org
 * 
 * This code is the not to be used without written permission from
 * BioMight.org
 * 
 */

package biomight.chemistry.compound;

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
import biomight.view.BioMightTransforms;

/**********************************************************************************************
 * Representation of Dentin 
 * 
 * @author SurferJim
 *
 * Representation of Dentin
 *
 **********************************************************************************************/

public class Dentin extends BioMightBase {
	private String dentinName = "Dentin";
	private String dentinRef = "Dentin";
	private BioMightTransforms bioMightTransforms;
	private ArrayList<BioMightPropertyView> properties;
	private ArrayList<BioMightMethodView> methods;
	private String componentID;
	private String parentID;
	private BioMightPosition bioMightPosition;
	

	public String getComponentID() {
		return componentID;
	}

	public void setComponentID(String componentID) {
		this.componentID = componentID;
	}

	public String getParentID() {
		return parentID;
	}

	public void setParentID(String parentID) {
		this.parentID = parentID;
	}

	/***********************************************************************************
	 * Dentin Constructor
	 *
	 * Using the DNA sequence, create a collection of Dentin cells based on its
	 * pattern
	 * 
	 * @param dnaSequence
	 **********************************************************************************/
	
	
	public Dentin()
	{
		create(this.dentinRef, Constants.DentinRef, null);
	}

	public Dentin(String parentID)
	{
		create(this.dentinRef, parentID, null);
	}

	public Dentin(String parentID, BioMightPosition bioMightPosition)
	{
		create(this.dentinRef, parentID, null);
		this.bioMightPosition = bioMightPosition;
	}
	
	public Dentin(String parentID, ArrayList<BioMightMethodView> bioMightMethods)
	{
		create(this.dentinRef, parentID, bioMightMethods);
	}

	public Dentin(String tissueRef, String parentID, ArrayList<BioMightMethodView> bioMightMethods)
	{
		create(tissueRef, parentID, bioMightMethods);
		this.dentinRef = tissueRef;
	}
	
	
	public void create(String tissueRef, String parentID, ArrayList<BioMightMethodView> bioMightMethods)
	{
		this.setImage("images/Dentin");
		this.setImageHeight(300);
		this.setImageWidth(300);
		this.parentID = parentID;
		
		
		System.out.println("Creating the Dentin for parent: " + parentID);
		
		if (!dentinRef.equals(""))
			this.dentinName = dentinRef;
		
		// Get the data for the Back that is defined for this 
		// body reference.    	
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Getting DentinInfo for ParentID: " + parentID);
			InitialContext ctx = new InitialContext();
			BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
			bioMightTransforms = bioMightBean.getComponents(tissueRef, parentID);
			//System.out.println("Have Dentin Info from EJB");   	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - Dentin");
			throw new ServerException("Remote Exception getComponents():", e); 	
		}
		
			
		// Run through the collection of Dentin
		ArrayList transforms = bioMightTransforms.getTransforms();
		System.out.println(dentinName + " Dentin NumTransforms: " + transforms.size());
		for (int i=0; i<transforms.size(); i++)
		{
			// Get the information for the Upper Lip we are creating
			BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
			//System.out.println("Created Dentin (name,id): " + bioMightTransform.getName() + "  " + bioMightTransform.getId());		
	
			//chondrocytes = new Chondrocytes();
			//chondrocyteExtraCellularMatrix = new ChondrocyteExtraCellularMatrix();		
		}		
		
		//System.out.println("Created the Dentin for parent: " + parentID);
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
	
	
	/********************************************************************************************************************
	 * GET X3D
	 * 
	 * This method will return the X3D for the Dentin.  It runs through each of its components and collects up their
	 * representations and then assembles them into one unified X3D model.
	 * 
	 ********************************************************************************************************************/

	public String getX3D(boolean snipet) {
		
		// Assemble the Dentin
		String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
		"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n " +
		"<X3D profile='Immersive' >\n" +
		"<head>\n" +
		 "<meta name='BioMightImage' content='Dentin.jpg'/>\n" +
		 "<meta name='ExportTime' content='7:45:30'/>\n" +
		 "<meta name='ExportDate' content='08/15/2008'/>\n" +
		 "<meta name='BioMight Version' content='1.0'/>\n" + 
		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='Dentin'\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		

		String body = "";
		String annotate = "";
		
		// Run through the collection of Dentin and build them into the model
		ArrayList transforms = bioMightTransforms.getTransforms();
		//System.out.println(dentinName + " Dentin X3D Elements: " + transforms.size());
		
		for (int i=0; i<transforms.size(); i++)
		{
			// Get the information for the Dentin we are creating
			BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
			//System.out.println("Getting Dentin X3D: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
		
			int view = Constants.VIEW_FLOATING;
			if (view == Constants.VIEW_FLOATING)
			{
				//System.out.println("Getting X3D for Dentin: " + bioMightSphere.getTranslation().getXPos());
				//System.out.println("Getting X3D for Dentin: " + bioMightSphere.getTranslation().getYPos());
				//System.out.println("Getting X3D for Dentin: " + bioMightSphere.getTranslation().getZPos());
				// Change the height and width based on the displacement.
				
				body += "<Transform DEF='" + dentinName + "'\n";
				
				
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
					"<Shape DEF='" + dentinName + "'\n" +
						    " containerField='children'>\n" +
						    " <Appearance\n" +
						    "  containerField='appearance'>\n";
						    
				// We are looking at the base tissue collection
			    if (parentID.equals("1.1000:0"))
			    {
				    body+= " <ImageTexture containerField='texture' " +
				    " url='../images/Dentin.jpg'/>";
				}
						    
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
				 	"<IndexedFaceSet DEF='DentinIFS' \n" +
				    	   "containerField='geometry' \n" +
				    	   "creaseAngle='" +  bioMightTransform.getCreaseAngle() + "'\n" +
				    	   "coordIndex='" + bioMightTransform.getCoordindexStr() + "'>" +
				    	   "<Coordinate DEF='Dentin_Coord' \n" +
				    	    "containerField='coord' point='" +  bioMightTransform.getCoordpointStr() + "'/>" +
				    	  "</IndexedFaceSet>\n" +
				    	 "</Shape>\n" +
				"</Transform>\n"; 
		

				//	Add the text to the Tissue sample
				if (parentID.equals("1.1000:0"))
				{
					annotate = 
					"<Transform DEF='DentinText' \n" +
					"translation='" + (bioMightPosition.getXPos() + 1.25) + " "  
					+ bioMightPosition.getYPos() + " "
					+ bioMightPosition.getZPos() + "'>\n" +
						"<Shape DEF='Tisssuesn'>\n" +
						"<Appearance\n" +
						"containerField='appearance'>\n" +
						"<Material containerField='material' USE='Red'/>\n" +
						"</Appearance>\n" +
						"<Text DEF='GeoText2'\n" +
						"containerField='geometry'\n" +
						"string='\"Dentin\"'\n" +
						"maxExtent='0.000'>\n" +
						"<FontStyle\n" +
						"containerField='fontStyle'\n" +
						"family='SERIF'\n" +
						"style='PLAIN'\n" +
						"justify='\"BEGIN\" \"BEGIN\"'\n" +
						"size='0.500'\n" +
						"spacing='0.50'/>\n" +
						"</Text>\n" +
						"</Shape>\n" +
					"</Transform>\n";
				}
			}
		else
		{
			body = "";//						
		}
		
		}	
		
			
		//System.out.println("Dentin X3D: " + body);		
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
