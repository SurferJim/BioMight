/*
 * Created on Jul 7, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.system.skeletal.skull.cranial;
import java.util.ArrayList;



import biomight.Constants;
import biomight.body.BodyPart;
import biomight.cell.extracellularmatrixsecretion.Osteocytes;
import biomight.system.ligament.knee.*;
import biomight.system.skeletal.leg.Patella;
import biomight.system.skeletal.leg.tibia.Tibia;
import biomight.system.tissue.connective.bone.Bone;
import biomight.system.tissue.epithelial.EpitheliumTissue;
import  biomight.system.cartilage.ArticularCartilage;
import biomight.view.BioMightMethodView;
import biomight.view.BioMightPropertyView;

/**
 * @author SurferJim
 *
 * Representation of a ParietalBone
 */
public class ParietalBone extends Bone {
	private Osteocytes osteocytes;
	

	public ParietalBone()
	{		
		// Create hte base Eye
		create(Constants.ParietalBoneRef, null);
	}
	
	
	public ParietalBone(String parentID)
	{				
		create(parentID, null);	
	}
	

	public ParietalBone(String parentID, ArrayList<BioMightMethodView> bioMightMethods)
	{				
		create(parentID, bioMightMethods);	
	}

	
	/************************************************************************************
	 * 
	 * CREATE LEG
	 * @param HipReference
	 ***********************************************************************************/
	
	public void create(String parentID, ArrayList<BioMightMethodView> bioMightMethods)
	{		
		this.setImage("images/ParietalBone.gif");
		setImageWidth(200);
		setImageHeight(150);
		
		componentID=parentID;
		properties = new ArrayList<BioMightPropertyView>();

		
		int viewPerspective = Constants.VIEW_FLOATING;
		if (viewPerspective == Constants.VIEW_FLOATING) {
			
			// If we have initialization parameters from the form, 
			//  then apply them before constructing the objects.
			if (bioMightMethods != null){
				System.out.println("NEED TO EXECUTE ParietalBone METHODS: " + bioMightMethods.size());
			}
			
			System.out.println("Creating ParietalBoneOsteocytes:" + parentID);		
			osteocytes = new Osteocytes("ParietalBoneOsteocyte", parentID, bioMightMethods);
			initProperty("ParietalBoneOsteocyte", Constants.Osteocytes, Constants.OsteocytesRef, osteocytes.getComponentID());
	
			System.out.println("ParietalBone Instance is created : " + parentID);
		} 
		else if (viewPerspective == Constants.VIEW_INTERNAL) {
	
		}

		//initProperties();
		initMethods();
	}
		
	
	
	public void initProperties() {

		properties = new ArrayList<BioMightPropertyView>();
		
		BioMightPropertyView property = new BioMightPropertyView();
		property.setPropertyName("AnteriorCruciateLigament");
		property.setCanonicalName(Constants.AnteriorCruciateLigament);
		properties.add(property);
	
		property = new BioMightPropertyView();
		property.setPropertyName("PosteriorCruciateLigament");
		property.setCanonicalName(Constants.PosteriorCruciateLigament);
		properties.add(property);		

	}
	
	
	public void initMethods() {

		methods = new ArrayList<BioMightMethodView>();
		
		BioMightMethodView method = new BioMightMethodView();

		method = new BioMightMethodView();
		method.setMethodName("Bend");
		method.setHtmlType("text");
		methods.add(method);		

		method = new BioMightMethodView();
		method.setMethodName("Dislocate");
		method.setHtmlType("checkbox");
		methods.add(method);
	}

	
	/********************************************************************************************************************
	 * GET X3D
	 * 
	 * This method will return the X3D for the ParietalBone.  It runs through each of its components and collects up their
	 * representations and then assembles them into one unified X3D model.
	 * 
	 ********************************************************************************************************************/
	public String getX3D(boolean snipet) {
		
		// Assemble the ParietalBone
		String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
		"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n " +
		"<X3D profile='Immersive' >\n" +
		"<head>\n" +
		 "<meta name='BioMightImage' content='ParietalBone.jpg'/>\n" +
		 "<meta name='ExportTime' content='7:45:30'/>\n" +
		 "<meta name='ExportDate' content='08/15/2008'/>\n" +
		 "<meta name='BioMight Version' content='1.0'/>\n" + 
		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='ParietalBone'\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		

		String body = osteocytes.getX3D(true);  
		//System.out.println("ParietalBone X3D: " + body);		
		
		String footer = "</Scene>" + "</X3D>\n";
		
		if (snipet)
			return body;			
		else	
			return header + body + footer;
	}	
	
}