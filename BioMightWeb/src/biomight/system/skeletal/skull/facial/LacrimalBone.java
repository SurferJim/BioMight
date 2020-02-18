/*
* Created on Apr 10, 2006
*
* BioMight Component Class - Feb 2007
*
*/
package biomight.system.skeletal.skull.facial;
import java.util.ArrayList;

import javax.naming.InitialContext;



import biomight.Constants;
import biomight.cell.extracellularmatrixsecretion.Osteocyte;
import biomight.cell.extracellularmatrixsecretion.Osteocytes;
import biomight.ejb.BioMightBeanLocal;
import biomight.exceptions.ServerException;
import biomight.system.tissue.connective.bone.Bone;
import biomight.view.BioMightMethodView;
import biomight.view.BioMightPosition;
import biomight.view.BioMightPropertyView;
import biomight.view.BioMightTransform;

/**
* @author SurferJim
*
* BioMight Component Class - Feb 2007
* Representation of the LacrimalBone
*
*/
public class LacrimalBone extends Bone {
private Osteocytes osteocytes;

	
	public LacrimalBone()
	{
		//create(Constants.SkullRef, null);
	}

	public LacrimalBone(String parentID)
	{
		create(parentID, null);

	}

	public LacrimalBone(String parentID, ArrayList<BioMightMethodView> bioMightMethods)
	{
		create(parentID, bioMightMethods);

	}
	
	public void create(String parentID, ArrayList<BioMightMethodView> bioMightMethods)
	{
		this.setImage("images/LacrimalBone.jpg");
		this.setImageHeight(300);
		this.setImageWidth(300);
		
		properties = new ArrayList<BioMightPropertyView>();
		
		
		int view = Constants.VIEW_FLOATING;
		
		// We are looking at the Bone from a parent perspective
		if (view == Constants.VIEW_FLOATING)
		{
			componentID=parentID;
		
			System.out.println("Creating LacrimalBoneOsteocytes:" + parentID);		
			osteocytes = new Osteocytes("LacrimalBoneOsteocyte", parentID, bioMightMethods);
			initProperty("LacrimalBoneOsteocyte", Constants.Osteocytes, Constants.OsteocytesRef, osteocytes.getComponentID());
			System.out.println("LacrimalBoneOsteocyte completed: " + parentID);		
		}
		else
		{
			// Get the information from the database via the Enterprise Bean		
			try {
				// Get the information from the database via the Enterprise Bean		
				System.out.println("Getting LacrimalBoneInfo for ParentID: " + parentID);
				InitialContext ctx = new InitialContext();
				BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
				bioMightTransforms = bioMightBean.getComponents(Constants.LacrimalBoneRef, parentID);
				System.out.println("Have LacrimalBone Info from EJB");   	
			}catch (Exception e) { 
				System.out.println("Exception Getting Components - LacrimalBone");
				throw new ServerException("Remote Exception getComponents():", e); 	
			}

		
			// Run through the collection of Pupils and build them into the model
			// In the default case, we get one instance of the Pupil for each eye
			ArrayList transforms = bioMightTransforms.getTransforms();
			System.out.println("Have LacrimalBone Info NumTransforms: " + transforms.size());
			for (int i=0; i<transforms.size(); i++)
			{
				// Get the information for the Tibia we are creating
				BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
				System.out.println("Created LacrimalBone (name,id): " + bioMightTransform.getName() + "  " + bioMightTransform.getId());	
				componentID=bioMightTransform.getId();
			
				System.out.println("Creating LacrimalBoneOsteocytes:" + bioMightTransform.getId());		
				osteocytes = new Osteocytes("LacrimalBoneOsteocyte", bioMightTransform.getId(), bioMightMethods);
				initProperty("LacrimalBoneOsteocyte", Constants.Osteocytes, Constants.OsteocytesRef, osteocytes.getComponentID());
			
				System.out.println("LacrimalBoneOsteocyte completed: " + bioMightTransform.getId());		
			}
		}	

		System.out.println("Creating the LacrimalBone for: " + parentID);
		//initProperties();
		initMethods();
		
		System.out.println("Create LacrimalBone complete");
	}
	
	
	protected void initProperty(String componentName, String canonicalName, String componentRef, String componentID) {
		BioMightPropertyView property = new BioMightPropertyView();
		property.setPropertyName(componentName);
		property.setCanonicalName(canonicalName);
		property.setPropertyRef(componentRef);
		property.setPropertyID(componentID);
		properties.add(property);
	}
	
	
	public void initProperties() {

		properties = new ArrayList<BioMightPropertyView>();

		BioMightPropertyView property = new BioMightPropertyView();
		property.setPropertyName("Osteocytes");
		property.setCanonicalName(Constants.Osteocytes);
		properties.add(property);		
	}
	
	
	public void initMethods() {

		methods = new ArrayList<BioMightMethodView>();
		BioMightMethodView method;
		
		method = new BioMightMethodView();
		method.setMethodName("Fracture");
		method.setHtmlType("checkbox");
		methods.add(method);
	}
											

	public void redraw(int parentID)
	{
		System.out.println("Redraw LacrimalBone at Position: " + parentID);
		//init3D(bioMightPosition);
	}
	
	
	/********************************************************************************************************************
	 * GET X3D
	 * 
	 * This method will return the X3D for the Cell.  It runs through each of its components and collects up their
	 * representations and then assembles them into one unified X3D model.
	 * 
	 ********************************************************************************************************************/
	public String getX3D(boolean snipet) {
		
		// Assemble the LacrimalBone
		String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
		"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n " +
		"<X3D profile='Immersive' >\n" +
		"<head>\n" +
		 "<meta name='BioMightImage' content='Nose.jpg'/>\n" +
		 "<meta name='ExportTime' content='7:45:30'/>\n" +
		 "<meta name='ExportDate' content='08/15/2008'/>\n" +
		 "<meta name='BioMight Version' content='1.0'/>\n" + 
		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='LacrimalBone'\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		


		String body = "";
		
		int view = Constants.VIEW_FLOATING;
		
		if (view == Constants.VIEW_FLOATING)
		{
			body = osteocytes.getX3D(true);	
		}
		else if (view == Constants.VIEW_DETACHED)
		{
			
			// Run through the collection of Pupils and build them into the model
			// In the default case, we get one instance of the Pupil for each eye
			ArrayList transforms = bioMightTransforms.getTransforms();
			for (int i=0; i<transforms.size(); i++)
			{
				// Get the information for the PinnaAntiHelix we are creating
				BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
				System.out.println("Getting LacrimalBone X3D: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
		
				//System.out.println("Getting X3D for LacrimalBoneX: " + bioMightSphere.getTranslation().getXPos());
				//System.out.println("Getting X3D for LacrimalBoneY: " + bioMightSphere.getTranslation().getYPos());
				//System.out.println("Getting X3D for LacrimalBoneZ: " + bioMightSphere.getTranslation().getZPos());
				// Change the height and width based on the displacement.
				body = "<Transform DEF='LacrimalBone'\n" +
		 			"translation='" + bioMightTransform.getTranslation().getXPos() + " " 
			 					+ bioMightTransform.getTranslation().getYPos() + " "
			 					+ bioMightTransform.getTranslation().getZPos() + "'\n" +
			 		"scale='" 	+ bioMightTransform.getScale().getXPos() + " "
			 				+ bioMightTransform.getScale().getYPos() + " "
			 				+ bioMightTransform.getScale().getZPos() + "'>\n" +
					"<Shape DEF='LacrimalBone'\n" +
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
						 	"<IndexedFaceSet DEF='LacrimalBonePolygon' \n" +
						    	   "containerField='geometry' \n" +
						    	   "creaseAngle='" +  bioMightTransform.getCreaseAngle() + "'\n" +
						    	   "coordIndex='" + bioMightTransform.getCoordindexStr() + "'>" +
						    	   "<Coordinate DEF='LacrimalBone_Coord' \n" +
						    	    "containerField='coord' point='" +  bioMightTransform.getCoordpointStr() + "'/>" +
						    	  "</IndexedFaceSet>\n" +
					"</Shape>\n" +
			 "</Transform>\n"; 
			}
			
		}
		else
		{
			body = "";
		}
		
		//System.out.println("LacrimalBone X3D: " + body);		
		String footer = "</Scene>" + "</X3D>\n";
		
		if (snipet)
			return body;			
		else	
			return header + body + footer;
	}

}
