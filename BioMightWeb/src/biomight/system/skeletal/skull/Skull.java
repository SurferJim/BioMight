/*
* Created on Oct 15, 2004
*
* BioMight Component Class - Feb 2007
*
*/
package biomight.system.skeletal.skull;
import biomight.BioMightBase;
import biomight.Constants;
import biomight.ejb.BioMightBeanLocal;
import biomight.exceptions.DataSecurityException;
import biomight.exceptions.ServerException;
import biomight.system.tissue.connective.bone.Bone;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Collection;

import javax.naming.InitialContext;

import biomight.system.skeletal.skull.cranial.*;
import biomight.system.skeletal.skull.facial.*;
import biomight.view.BioMightMethodView;
import biomight.view.BioMightPosition;
import biomight.view.BioMightPropertyView;
import biomight.view.BioMightTransform;
import biomight.view.BioMightTransforms;

/**************************************************************************************
* @author SurferJim
*
* BioMight Component Class - Feb 2007
* 
* Representation of the Skull
*
**************************************************************************************/

public class Skull extends BioMightBase {
	private CranialBones cranialBones;
	private FacialBones facialBones;

	
	/*********************************************************************************
	 * CONSTRUCTORS
	 *
	 *********************************************************************************/
	
	public Skull()
	{
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, Constants.SkullRef, null, null);
	}

	public Skull(String parentID)
	{
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, parentID, null, null);
	}

	public Skull(int hierarchy, int LOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
	{
		create(hierarchy, LOD, parentID, bioMightProperties, bioMightMethods);
	}

	/*****************************************************************
	 * CREATE
	 * 
	 * @param parentID
	 * @param bioMightMethods
	 ******************************************************************/
	public void create(int hierarchy, int LOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
	{
		this.setImage("images/Skull.jpg");
		this.setImageWidth(300);
		this.setImageHeight(325);
		
		// Get the information from the database via the Enterprise Bean		
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Getting SkullInfo for ParentID: " + parentID);
			InitialContext ctx = new InitialContext();
			BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
			bioMightTransforms = bioMightBean.getComponents(Constants.SkullRef, parentID);
			System.out.println("Have Skull Info from EJB");   	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - Skull");
			throw new ServerException("Remote Exception getComponents():", e); 	
		}
			
		// Run through the collection of Pupils and build them into the model
		// In the default case, we get one instance of the Pupil for each eye
		ArrayList transforms = bioMightTransforms.getTransforms();
		System.out.println("Have SkullInfo NumTransforms: " + transforms.size());
		for (int i=0; i<transforms.size(); i++)
		{
			// Get the information for the eye we are creating
			BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
			System.out.println("Creating Skull (name,id): " + bioMightTransform.getName() + "  " + bioMightTransform.getId());

			componentID = bioMightTransform.getId();
			
			cranialBones = new CranialBones(bioMightTransform.getId(), bioMightMethods);
			initProperty(bioMightTransform.getName(), Constants.CranialBones, Constants.CranialBonesRef, cranialBones.getComponentID());
			System.out.println("Created CranialBones in Skull");
		
			facialBones = new FacialBones(bioMightTransform.getId(), bioMightMethods);
			initProperty(bioMightTransform.getName(), Constants.FacialBones, Constants.FacialBonesRef, facialBones.getComponentID());
			System.out.println("Created FacialBones in Skull");		
		}		

		
		//initProperties();
		initMethods();
	
	}
	

	public void redraw(int parentID)
	{		
		cranialBones.redraw(parentID);	
		//facialBones.redraw(parentID);
		System.out.println("Facial-Cranial Bones Redraw");
	}

	
	public void initProperties() {

		BioMightPropertyView property = new BioMightPropertyView();
		property.setPropertyName("Cranial Bones");
		property.setCanonicalName(Constants.CranialBones);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("Facial Bones");
		property.setCanonicalName(Constants.FacialBones);
		properties.add(property);

	}
	
	
	public void initMethods() {

		BioMightMethodView method = new BioMightMethodView();
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
		
		
		// Assembe the Skull
		String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
		"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n " +
		"<X3D profile='Immersive' >\n" +
		"<head>\n" +
		 "<meta name='BioMightImage' content='Skull.jpg'/>\n" +
		 "<meta name='ExportTime' content='7:45:30'/>\n" +
		 "<meta name='ExportDate' content='08/15/2008'/>\n" +
		 "<meta name='BioMight Version' content='1.0'/>\n" + 
		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='Skull'\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		

		String body = cranialBones.getX3D(true) + facialBones.getX3D(true);
		//System.out.println("Skull X3D: " + body);		
		
		String footer = "</Scene>" + "</X3D>\n";
		
		if (snipet)
			return body;			
		else	
			return header + body + footer;

	}
	
}


