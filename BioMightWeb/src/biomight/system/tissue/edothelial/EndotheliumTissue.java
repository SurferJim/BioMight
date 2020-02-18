
package biomight.system.tissue.edothelial;

/*
 * Created on Dec 22, 2009
 * Copyright 2006 - Biomight.org
 * 
 * This code is the not to be used without written permission from
 * BioMight.org
 * 
 */


import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.naming.InitialContext;



import biomight.Constants;
import biomight.ejb.BioMightBeanLocal;
import biomight.exceptions.DataSecurityException;
import biomight.exceptions.ServerException;
import biomight.system.tissue.Tissue;
import biomight.view.BioMightColor;
import biomight.view.BioMightMethodView;
import biomight.view.BioMightPosition;
import biomight.view.BioMightPropertyView;
import biomight.view.BioMightSphere;
import biomight.view.BioMightTransform;
import biomight.view.BioMightTransforms;

/**********************************************************************************************
 * Representation of Endothelial Tissue
 * 
 * @author SurferJim
 *
 **********************************************************************************************/

public class EndotheliumTissue extends Tissue {
	private BioMightPosition bioMightPosition;
	private String tissueName = "EndotheliumTissue";
	private String tissueRef = "EndotheliumTissue";
	

	/***********************************************************************************
	 * EndotheliumTissue Constructor
	 *
	 * Using the DNA sequence, create a collection of Endothelium cells based on its
	 * instruction set
	 * 
	 * @param dnaSequence
	 **********************************************************************************/
	
	
	public EndotheliumTissue()
	{
		create(this.tissueRef, Constants.EndotheliumTissueRef, null);
	}

	public EndotheliumTissue(String parentID)
	{
		create(this.tissueRef, parentID, null);
	}

	public EndotheliumTissue(String parentID, BioMightPosition bioMightPosition)
	{
		create(this.tissueRef, parentID, null);
		this.bioMightPosition = bioMightPosition;
	}
	
	public EndotheliumTissue(String parentID, ArrayList<BioMightMethodView> bioMightMethods)
	{
		create(this.tissueRef, parentID, bioMightMethods);
	}

	public EndotheliumTissue(String tissueRef, String parentID, ArrayList<BioMightMethodView> bioMightMethods)
	{
		create(tissueRef, parentID, bioMightMethods);
		this.tissueRef = tissueRef;
	}
	
	
	/***********************************************************************************************
	 * CREATE
	 *  
	 * @param tissueRef
	 * @param parentID
	 * @param bioMightMethods
	 * 
	 **********************************************************************************************/
	
	public void create(String tissueRef, String parentID, ArrayList<BioMightMethodView> bioMightMethods)
	{
		this.setImage("images/Endothelium.jpg");
		this.setImageHeight(300);
		this.setImageWidth(300);
		this.parentID = parentID;
		
		System.out.println("Creating the Endothelium for parent: " + parentID);
		
		// Get the information from the database via the Enterprise Bean				
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Getting EndotheliumInfo for ParentID: " + parentID);
			InitialContext ctx = new InitialContext();
			BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
			bioMightTransforms = bioMightBean.getComponents(tissueRef, parentID);   	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - Endothelium");
			throw new ServerException("Remote Exception getComponents():", e); 	
		}
	
		// Run through the collection of Endothelium Tissue
		ArrayList transforms = bioMightTransforms.getTransforms();
		System.out.println("Have " + tissueRef + " Info NumTransforms: "  + transforms.size());
		for (int i=0; i<transforms.size(); i++)
		{
			BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
			//System.out.println("Created Endothelium (name,id): " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
		}		
		
		System.out.println("Created the Endothelium for parent: " + parentID);
		//initProperties();
		initMethods();
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
	 * This method will return the X3D for the Endothelium Tissue.  It runs through each of its components and collects up their
	 * representations and then assembles them into one unified X3D model.
	 * 
 nb	 ********************************************************************************************************************/

	public String getX3D(boolean snipet) {
		
		// Assemble the EndotheliumTissue
		String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
		"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n " +
		"<X3D profile='Immersive' >\n" +
		"<head>\n" +
		 "<meta name='BioMightImage' content='EndotheliumTissue.jpg'/>\n" +
		 "<meta name='ExportTime' content='7:45:30'/>\n" +
		 "<meta name='ExportDate' content='08/15/2008'/>\n" +
		 "<meta name='BioMight Version' content='1.0'/>\n" + 
		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='EndotheliumTissue'\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		

		String body = "";
		String annotate = "";
		
		// Run through the collection of Back Endothelium and build them into the model
		// In the default case, we get one instance of the Pupil for each eye
		ArrayList transforms = bioMightTransforms.getTransforms();
		for (int i=0; i<transforms.size(); i++)
		{
			// Get the information for the PinnaAntiHelix we are creating
			BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
			//System.out.println("Getting Endothelium X3D: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
			componentID = bioMightTransform.getId();
			String componentType = bioMightTransform.getComponentType(); 
			
			int view = Constants.VIEW_FLOATING;
			if (view == Constants.VIEW_FLOATING)
			{
				//System.out.println("Getting X3D for EndotheliumTissue: " + bioMightSphere.getTranslation().getXPos());
				//System.out.println("Getting X3D for EndotheliumTissue: " + bioMightSphere.getTranslation().getYPos());
				//System.out.println("Getting X3D for EndotheliumTissue: " + bioMightSphere.getTranslation().getZPos());
				// Change the height and width based on the displacement.
				//body += "<Transform DEF='" + componentID + "'\n";
				
				body += "<Transform  onmouseover=\"showComponent('" + componentID +  "');\"  DEF='" + bioMightTransform.getId() + "'\n";
				
				
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
					"<Shape DEF='" + componentID +  "'\n" +
						    " containerField='children'>\n" +
						    " <Appearance\n" +
						    "  containerField='appearance'>\n";
						    
			 	
						// We are looking at the base tissue collection
			 			if (parentID.contains("LipEndothelial") || parentID.contains("LipEndothelium"))
			 			{
			 				//body+= " <ImageTexture containerField='texture' " +
			 				//		" url='../images/EndothelialTissue.jpg'/>";
			 			}
			 			else if ((parentID.contains("Endothelial") || parentID.contains("Endothelium")) && !parentID.contains("LipEndo"))
						{
							 body+= " <ImageTexture containerField='texture' " +
							 " url='../images/EndothelialTissue.jpg'/>";
						}
						// We are looking at the base tissue collection
						else if (parentID.equals("Atrium:01") || parentID.equals("Atrium:02") ||
							    parentID.equals("Ventricle:01") || parentID.equals("Ventricle:02"))
						{
						    body+= " <ImageTexture containerField='texture' " +
						    " url='../images/HeartTissue.jpg'/>";
						}
						   // We are looking at the base tissue collection
						else if (parentID.equals("Pancreas:01"))
						{
						    body+= " <ImageTexture containerField='texture' " +
						    " url='../images/PancreasTissue.gif'/>";
						}	
						else if (parentID.equals("Liver:01"))
						{
						    body+= " <ImageTexture containerField='texture' " +
						    " url='../images/LiverHepa.jpg'/>";
						}	
						else
						{}
						    
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
						 	"<IndexedFaceSet DEF='EndotheliumTissueIFS' \n" +
						    	   "containerField='geometry' \n" +
						    	   "creaseAngle='" +  bioMightTransform.getCreaseAngle() + "'\n" +
						    	   "solid='false' \n" +
						    	   "coordIndex='" + bioMightTransform.getCoordindexStr() + "'>" +
						    	   "<Coordinate DEF='EndotheliumTissue_Coord' \n" +
						    	    "containerField='coord' point='" +  bioMightTransform.getCoordpointStr() + "'/>" +
						    	  "</IndexedFaceSet>\n" +
					"</Shape>\n";
			
				 
				 	String timerName = componentID + "Timer";
					String touchName = componentID + "Touch";
					String interpName = componentID + "Animate";
					
					timerName.replace(':', '-');
					touchName.replace(':', '-');
					interpName.replace(':', '-');
				
					
					// We are looking at the base tissue collection
					if (parentID.equals("Atrium:01") || parentID.equals("Atrium:02"))
					{
							
						body+= "<TimeSensor DEF='" + timerName + "'\n" +
								  " containerField='children'\n " +
								  " cycleInterval='1.000'\n " + 
								  " loop='true' \n" +
								  " startTime='-1.000'/> \n" +
								  
							"<TouchSensor DEF='" + touchName + "' \n" +
							      " description='" + tissueRef + "'\n" +
								  " containerField='children'/> \n" +
								  
					 "</Transform>\n" +
					 
					 "<PositionInterpolator DEF='"+interpName+"'\n" + 
					 "key='0 .5 1'\n" +
					 "keyValue='1 1 1 .9 .9 .9 1 1 1'/>\n" + 
					 "<ROUTE fromNode='"+touchName+"' fromField='touchTime' toNode='"+timerName+"' toField='startTime'/>\n" +
					 "<ROUTE fromNode='"+timerName+"' fromField='fraction_changed' toNode='"+interpName+"' toField='set_fraction'/>\n" +
					 "<ROUTE fromNode='"+interpName+"' fromField='value_changed' toNode='" + componentID + "' toField='set_scale'/>\n";
					
					}
					// We are looking at the base tissue collection
					else 
					{
						body += "<TouchSensor DEF='"+ touchName +"' \n" +
		                   " description='" + tissueRef + "'\n" +
			               " containerField='children'/> \n";
			    	
						 body += "</Transform>\n";            	
					}
				
		}
		else
		{
			body = "";//						
		}
		
		}
		
		//System.out.println("EndotheliumTissue X3D: " + body);		
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
