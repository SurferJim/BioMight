/*
* Created on Jul 10, 2006
*
* BioMight Component Class - Feb 2007
*
*/
package biomight.system.skeletal.skull.cranial;
import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.naming.InitialContext;

import biomight.BioMightBase;
import biomight.Constants;
import biomight.ejb.BioMightBeanLocal;
import biomight.exceptions.DataSecurityException;
import biomight.exceptions.ServerException;
import biomight.system.tissue.connective.bone.Bone;
import biomight.view.BioMightMethodView;
import biomight.view.BioMightPosition;
import biomight.view.BioMightPropertyView;
import biomight.view.BioMightTransform;
import biomight.view.BioMightTransforms;

/**
* @author SurferJim
*
* BioMight Component Class - Feb 2007
*
*/
public class CranialBones extends BioMightBase {
	private EthmoidBone ethmoidBone;
	private FrontalBone frontalBone;
	private OccipitalBone occipitalBone;
	private ParietalBones parietalBones;
	private SphenoidBone sphenoidBone;
	private TemporalBones temporalBones;
	
	public CranialBones()
	{
		//createCranialBones(Constants.CranialBoneRef);
	}
	
	public CranialBones(String parentID)
	{
		create(parentID, null);
	}
	

	public CranialBones(String parentID, ArrayList<BioMightMethodView> bioMightMethods)
	{
		create(parentID, bioMightMethods);
	}
	
	public void create(String parentID, ArrayList<BioMightMethodView> bioMightMethods)
	{
		this.setImage("images/CranialBones.jpg");
		this.setImageHeight(300);
		this.setImageWidth(300);

		
		// Get the information from the database via the Enterprise Bean		
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Getting CranialBonesInfo for ParentID: " + parentID);
			InitialContext ctx = new InitialContext();
			BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
			bioMightTransforms = bioMightBean.getComponents(Constants.CranialBonesRef, parentID);
			System.out.println("Have CranialBones Info from EJB");   	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - CranialBones");
			throw new ServerException("Remote Exception getComponents():", e); 	
		}
		
		// Run through the collection of Pupils and build them into the model
		// In the default case, we get one instance of the Pupil for each eye
		ArrayList transforms = bioMightTransforms.getTransforms();
		System.out.println("Have CranialBonesInfo NumTransforms: " + transforms.size());
		for (int i=0; i<transforms.size(); i++)
		{
			// Get the information for the CranialBones we are creating
			BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
			System.out.println("Creating CranialBones (name,id): " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
			componentID=bioMightTransform.getId();
			
			ethmoidBone = new EthmoidBone(bioMightTransform.getId(), bioMightMethods);
			initProperty("EthmoidBone", Constants.EthmoidBone, Constants.EthmoidBoneRef, ethmoidBone.getComponentID());
			System.out.println("Cranial Bones - Created EthmoidBone");
			
			frontalBone = new FrontalBone(bioMightTransform.getId(), bioMightMethods);
			initProperty("FrontalBone", Constants.FrontalBone, Constants.FrontalBoneRef, frontalBone.getComponentID());
			System.out.println("Cranial Bones - Created FrontalBone");
		
			occipitalBone = new OccipitalBone(bioMightTransform.getId(), bioMightMethods);
			initProperty("OccipitalBone", Constants.OccipitalBone, Constants.OccipitalBoneRef, occipitalBone.getComponentID());
			System.out.println("Cranial Bones - Created OccipitalBone");
		
			parietalBones = new ParietalBones(bioMightTransform.getId(), bioMightMethods);
			initProperty("ParietalBones", Constants.ParietalBones, Constants.ParietalBonesRef, parietalBones.getComponentID());
			System.out.println("Cranial Bones - Created ParietalBones");
		
			temporalBones = new TemporalBones(bioMightTransform.getId(), bioMightMethods);
			initProperty("TemporalBones", Constants.TemporalBones, Constants.TemporalBonesRef, parietalBones.getComponentID());
			System.out.println("Cranial Bones - Created TemporalBones");
		
			sphenoidBone = new SphenoidBone(bioMightTransform.getId(), bioMightMethods);
			initProperty("SphenoidBone", Constants.SphenoidBone, Constants.SphenoidBoneRef, sphenoidBone.getComponentID());
			System.out.println("Sphenoid Bones - Created TemporalBones");
		
			
			/* = new ();
			System.out.println("Created FrontalBone");
			 = new ();
			System.out.println("Created OccipitalBone");
			parietalBone = new ParietalBones();
			System.out.println("Created ParietalBones");
			sphenoidBone = new SphenoidBone();
			System.out.println("Created SphenoidBone");
			temporalBone = new TemporalBone();
			System.out.println("Created TemporalBone"); */
				
			//facialBones = new FacialBones();
			//System.out.println("Created Facial Bones");			
		}		
		
		//initProperties();
		initMethods();
	}

	
	public void redraw(int parentID)
	{
		ethmoidBone.redraw(parentID);
		//frontalBone.redraw(bioMightPosition);
		//occipitalBone.redraw(bioMightPosition);
		//parietalBone.redraw(bioMightPosition);
		//sphenoidBone.redraw(bioMightPosition);
		//temporalBone.redraw(bioMightPosition);
		System.out.println("Cranial Bones - Redraw");
	}
	
	public void initProperties() {


		BioMightPropertyView property = new BioMightPropertyView();
		property.setPropertyName("Ethmoid Bone");
		property.setCanonicalName(Constants.CranialBones);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("Frontal Bone");
		property.setCanonicalName(Constants.FacialBones);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("Occipital Bone");
		property.setCanonicalName(Constants.OccipitalBone);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("Parietal Bone");
		property.setCanonicalName(Constants.ParietalBone);
		properties.add(property);		
		
		property = new BioMightPropertyView();
		property.setPropertyName("Sphenoid Bone");
		property.setCanonicalName(Constants.SphenoidBone);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("TemporalBone");
		property.setCanonicalName(Constants.TemporalBone);
		properties.add(property);
	}
	
	
	public void initMethods() {

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
		
		// Assembe the CranialBones
		String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
		"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n " +
		"<X3D profile='Immersive' >\n" +
		"<head>\n" +
		 "<meta name='BioMightImage' content='Cranial Bones.jpg'/>\n" +
		 "<meta name='ExportTime' content='7:45:30'/>\n" +
		 "<meta name='ExportDate' content='08/15/2008'/>\n" +
		 "<meta name='BioMight Version' content='1.0'/>\n" + 
		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='Cranial Bones'\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		

		String body = 
			ethmoidBone.getX3D(true) + 
			occipitalBone.getX3D(true) +
			frontalBone.getX3D(true)  +
			parietalBones.getX3D(true) +
			sphenoidBone.getX3D(true) +
			temporalBones.getX3D(true);
		
		//System.out.println("Cranial Bones X3D: " + body);		
		
		String footer = "</Scene>" + "</X3D>\n";
		
		if (snipet)
			return body;			
		else	
			return header + body + footer;

	}


}
