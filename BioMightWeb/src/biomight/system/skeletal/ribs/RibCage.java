/*
* Created on Apr 10, 2006
*
* BioMight Component Class - Feb 2007
*
*/
package biomight.system.skeletal.ribs;
import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.naming.InitialContext;



import biomight.Constants;
import biomight.cell.extracellularmatrixsecretion.Osteocytes;
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
* Representation of the RibCage.   It is comprised of the true ribs, the false ribs, and the floating ribs.
* They are anchored in the spine 
*
*/

public class RibCage extends Bone {
	private BioMightTransforms bioMightTransforms;
	private ArrayList<BioMightPropertyView> properties;
	private ArrayList<BioMightMethodView> methods;
	private TrueRibs trueRibs;
	private FalseRibs falseRibs;
	private FloatingRibs floatingRibs;
	

	public RibCage()
	{
		create(Constants.RibCageRef, null);
	}

	public RibCage(String parentID)
	{
		create(parentID, null);
	}

	public RibCage(String parentID, ArrayList<BioMightMethodView> bioMightMethods)
	{
		create(parentID, bioMightMethods);
	}
		
	public void create(String parentID, ArrayList<BioMightMethodView> bioMightMethods)
	{
		this.setImage("images/RibCage.jpg");
		this.setImageHeight(300);
		this.setImageWidth(300);

		System.out.println("Creating the RibCage for parent: " + parentID);
		
		// Get the information from the database via the Enterprise Bean		
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Getting RibCageInfo for ParentID: " + parentID);
			InitialContext ctx = new InitialContext();
			BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
			bioMightTransforms = bioMightBean.getComponents(Constants.RibCageRef, parentID);
			System.out.println("Have RibCage Info from EJB");   	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - RibCage");
			throw new ServerException("Remote Exception getComponents():", e); 	
		}
			
		// Run through the collection Arm Epithelium
		ArrayList transforms = bioMightTransforms.getTransforms();
		System.out.println("Have RibCage Info NumTransforms: " + transforms.size());
		for (int i=0; i<transforms.size(); i++)
		{
			// Get the information for the Upper Lip we are creating
			BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
			System.out.println("Created RibCage (name,id): " + bioMightTransform.getName() + "  " + bioMightTransform.getId());	

			System.out.println("Creating True Ribs:" + bioMightTransform.getId());	
			trueRibs = new TrueRibs(bioMightTransform.getId(), bioMightMethods);
			System.out.println("Created True Ribs:" + bioMightTransform.getId());	
			//falseRibs = new FalseRibs(bioMightTransform.getId());
			//3floatingRibs = new FloatingRibs(bioMightTransform.getId());
		
			System.out.println("Creating RibCage Osteocytes:" + bioMightTransform.getId());		
			//osteocytes = new Osteocytes(bioMightTransform.getId(), bioMightMethods);
			System.out.println("RibCage Osteocytes completed for ForeArm: " + bioMightTransform.getId());		
		}		
		
		System.out.println("Created the RibCage for parent: " + parentID);
		initProperties();
		initMethods();
	}

	
	
	
	public void initProperties() {

		properties = new ArrayList<BioMightPropertyView>();
		
		// Observable
		BioMightPropertyView property = new BioMightPropertyView();
		property.setPropertyName("Common");
		property.setCanonicalName(Constants.Title);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("True Ribs");
		property.setCanonicalName(Constants.TrueRibs);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("False Ribs");
		property.setCanonicalName(Constants.FalseRibs);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("Floating Ribs");
		property.setCanonicalName(Constants.FloatingRibs);
		properties.add(property);		
	}
	
	
	public void initMethods() {

		methods = new ArrayList<BioMightMethodView>();
		
		BioMightMethodView method = new BioMightMethodView();

		method = new BioMightMethodView();
		method.setMethodName("Crack");
		method.setHtmlType("text");
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
		
		// Assemble the RibCage
		String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
		"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n " +
		"<X3D profile='Immersive' >\n" +
		"<head>\n" +
		 "<meta name='BioMightImage' content='RibCage.jpg'/>\n" +
		 "<meta name='ExportTime' content='7:45:30'/>\n" +
		 "<meta name='ExportDate' content='08/15/2008'/>\n" +
		 "<meta name='BioMight Version' content='1.0'/>\n" + 
		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='RibCage'\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		

		String body =   
			trueRibs.getX3D(true) + 
			falseRibs.getX3D(true) +
			floatingRibs.getX3D(true);
		
		System.out.println("RibCage X3D: " + body);		
		
		String footer = "</Scene>" + "</X3D>\n";
		
		if (snipet)
			return body;			
		else	
			return header + body + footer;
	}
	

	/**
	 * @return
	 */
	public FalseRibs getFalseRibs() {
		return falseRibs;
	}

	/**
	 * @return
	 */
	public FloatingRibs getFloatingRibs() {
		return floatingRibs;
	}

	/**
	 * @return
	 */
	public TrueRibs getTrueRibs() {
		return trueRibs;
	}

	/**
	 * @param ribs
	 */
	public void setFalseRibs(FalseRibs ribs) {
		falseRibs = ribs;
	}

	/**
	 * @param ribs
	 */
	public void setFloatingRibs(FloatingRibs ribs) {
		floatingRibs = ribs;
	}

	/**
	 * @param ribs
	 */
	public void setTrueRibs(TrueRibs ribs) {
		trueRibs = ribs;
	}


	public ArrayList<BioMightMethodView> getMethods() {
		return methods;
	}


	public void setMethods(ArrayList<BioMightMethodView> methods) {
		this.methods = methods;
	}


	public ArrayList<BioMightPropertyView> getProperties() {
		return properties;
	}


	public void setProperties(ArrayList<BioMightPropertyView> properties) {
		this.properties = properties;
	}

}
