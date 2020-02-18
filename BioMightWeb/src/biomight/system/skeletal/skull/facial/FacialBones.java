/*
* Created on Jul 10, 2006
*
* BioMight Component Class - Feb 2007
*
*/
package biomight.system.skeletal.skull.facial;
import java.util.ArrayList;

import javax.naming.InitialContext;



import biomight.Constants;
import biomight.ejb.BioMightBeanLocal;
import biomight.exceptions.ServerException;
import biomight.system.skeletal.skull.cranial.CranialBones;
import biomight.system.tissue.connective.bone.Bone;
import biomight.view.BioMightMethodView;
import biomight.view.BioMightPosition;
import biomight.view.BioMightPropertyView;
import biomight.view.BioMightTransform;

/**
* @author SurferJim
*
* BioMight Component Class - Feb 2007
*
*/
public class FacialBones extends Bone {
	private HyoidBone hyoidBone;
	private InferiorNasalConchaBones inferiorNasalConchaBones;
	private LacrimalBones lacrimalBones;
	private MandibleBone mandibleBone;
	private MaxillaeBones maxillaeBones;
	private PalatineBones palatineBones;
	private VomerBone vomerBone;
	private ZygomaticBones zygomaticBones;
	
	
	
	public FacialBones()
	{
		create(Constants.FacialBonesRef, null);
	}

	public FacialBones(String parentID)
	{
		create(parentID, null);
	}

	public FacialBones(String parentID, ArrayList<BioMightMethodView> bioMightMethods)
	{
		create(parentID, bioMightMethods);
	}
	
	
	public void create(String parentID, ArrayList<BioMightMethodView> bioMightMethods)
	{
		this.setImage("images/FacialBones.jpg");
		this.setImageHeight(300);
		this.setImageWidth(300);
		
		// Get the information from the database via the Enterprise Bean		
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Getting FacialBonesInfo for ParentID: " + parentID);
			InitialContext ctx = new InitialContext();
			BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
			bioMightTransforms = bioMightBean.getComponents(Constants.FacialBonesRef, parentID);
			System.out.println("Have FacialBones Info from EJB");   	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - FacialBones");
			throw new ServerException("Remote Exception getComponents():", e); 	
		}
			
		// Run through the collection of Pupils and build them into the model
		// In the default case, we get one instance of the Pupil for each eye
		ArrayList transforms = bioMightTransforms.getTransforms();
		System.out.println("Have FacialBonesInfo NumTransforms: " + transforms.size());
		for (int i=0; i<transforms.size(); i++)
		{
			// Get the information for the eye we are creating
			BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
			System.out.println("Creating FacialBones (name,id): " + bioMightTransform.getName() + "  " + bioMightTransform.getId());

			componentID = bioMightTransform.getId();
		
			hyoidBone = new HyoidBone(bioMightTransform.getId(), bioMightMethods);
			initProperty(bioMightTransform.getName(), Constants.HyoidBone, Constants.HyoidBoneRef, hyoidBone.getComponentID());
			System.out.println("FacialBones - Created HyoidBone");
	
			inferiorNasalConchaBones = new InferiorNasalConchaBones(bioMightTransform.getId(), bioMightMethods);
			initProperty(bioMightTransform.getName(), Constants.InferiorNasalConchaBones, Constants.InferiorNasalConchaBonesRef, inferiorNasalConchaBones.getComponentID());
			System.out.println("FacialBones - Created InferiorNasalConchaBones");
	
			lacrimalBones = new LacrimalBones(bioMightTransform.getId(), bioMightMethods);
			initProperty(bioMightTransform.getName(), Constants.LacrimalBones, Constants.LacrimalBonesRef, lacrimalBones.getComponentID());
			System.out.println("FacialBones - Created LacrimalBones");
	
			mandibleBone = new MandibleBone(bioMightTransform.getId(), bioMightMethods);
			initProperty(bioMightTransform.getName(), Constants.MandibleBone, Constants.MandibleBoneRef, mandibleBone.getComponentID());
			System.out.println("FacialBones - Created MandibleBone");
		
			maxillaeBones = new MaxillaeBones(bioMightTransform.getId(), bioMightMethods);
			initProperty(bioMightTransform.getName(), Constants.MaxillaeBones, Constants.MaxillaeBonesRef, maxillaeBones.getComponentID());
			System.out.println("FacialBones - Created MaxillaeBones");
	
			palatineBones = new PalatineBones(bioMightTransform.getId(), bioMightMethods);
			initProperty(bioMightTransform.getName(), Constants.PalatineBones, Constants.PalatineBoneRef, palatineBones.getComponentID());
			System.out.println("FacialBones - Created PalatineBones");
	
			vomerBone = new VomerBone(bioMightTransform.getId(), bioMightMethods);
			initProperty(bioMightTransform.getName(), Constants.VomerBone, Constants.VomerBoneRef, vomerBone.getComponentID());
			System.out.println("FacialBones - Created VomerBonel");

			zygomaticBones = new ZygomaticBones(bioMightTransform.getId(), bioMightMethods);
			initProperty(bioMightTransform.getName(), Constants.ZygomaticBones, Constants.ZygomaticBonesRef, zygomaticBones.getComponentID());
			System.out.println("FacialBones - Created ZygomaticBones");

		}		

		
		//initProperties();
		initMethods();
	
	}
	
	public void redraw(BioMightPosition bioMightPosition)
	{			
		/*hyoidBone.redraw(bioMightPosition);
		inferiorNasalConchaBone.redraw(bioMightPosition);
		lacrimalBone.redraw(bioMightPosition);
		mandibleBone.redraw(bioMightPosition);
		maxillaeBone.redraw(bioMightPosition);
		palatineBone.redraw(bioMightPosition);
		vomerBone.redraw(bioMightPosition);
		zygomaticBone.redraw(bioMightPosition);*/
	}
	
	
	public void initProperties() {

		properties = new ArrayList<BioMightPropertyView>();

		BioMightPropertyView property = new BioMightPropertyView();
		property.setPropertyName("Hyoid Bone");
		property.setCanonicalName(Constants.HyoidBone);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("Inferior Nasal Concha Bone");
		property.setCanonicalName(Constants.InferiorNasalConchaBone);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("Lacrimal Bone");
		property.setCanonicalName(Constants.LacrimalBone);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("Mandible Bone");
		property.setCanonicalName(Constants.MandibleBone);
		properties.add(property);		
		
		property = new BioMightPropertyView();
		property.setPropertyName("Maxillae Bone");
		property.setCanonicalName(Constants.MaxillaeBone);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("Palatine Bone");
		property.setCanonicalName(Constants.PalatineBone);
		properties.add(property);
	}
	
	
	public void initMethods() {

		methods = new ArrayList<BioMightMethodView>();
		BioMightMethodView method;
		
		method = new BioMightMethodView();
		method.setMethodName("Crack");
		method.setHtmlType("checkbox");
		methods.add(method);

		method = new BioMightMethodView();
		method.setMethodName("Bruise");
		method.setHtmlType("checkbox");
		methods.add(method);

	}
	

	/********************************************************************************************************************
	 * GET X3D
	 * 
	 * This method will return the X3D for the Cell.  It runs through each of its components and collects up their
	 * representations and then assembles them into one unified X3D model.
	 * 
	 ********************************************************************************************************************/
	public String getX3D(boolean snipet) {
		
		// Assembe the FacialBones
		String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
		"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n " +
		"<X3D profile='Immersive' >\n" +
		"<head>\n" +
		 "<meta name='BioMightImage' content='FacialBones.jpg'/>\n" +
		 "<meta name='ExportTime' content='7:45:30'/>\n" +
		 "<meta name='ExportDate' content='08/15/2008'/>\n" +
		 "<meta name='BioMight Version' content='1.0'/>\n" + 
		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='Facial Bones'\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		

		String body = 
		hyoidBone.getX3D(true) +
		inferiorNasalConchaBones.getX3D(true) + 
		lacrimalBones.getX3D(true) +
		mandibleBone.getX3D(true) +
		maxillaeBones.getX3D(true) +
		palatineBones.getX3D(true) +
		vomerBone.getX3D(true) +
		zygomaticBones.getX3D(true);
		
		//System.out.println("Facial Bones X3D: " + body);		
		
		String footer = "</Scene>" + "</X3D>\n";
		
		if (snipet)
			return body;			
		else	
			return header + body + footer;

	}


}
