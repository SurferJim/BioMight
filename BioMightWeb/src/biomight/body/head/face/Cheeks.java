/*
 * Created on Jul 7, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.body.head.face;

import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.naming.InitialContext;

import biomight.BioMightBase;
import biomight.Constants;
import biomight.ejb.BioMightBeanLocal;
import biomight.exceptions.DataSecurityException;
import biomight.exceptions.ServerException;
import biomight.view.BioMightMethodView;
import biomight.view.BioMightPropertyView;
import biomight.view.BioMightTransform;
import biomight.view.BioMightTransforms;

/***********************************************************************************************
 * @author SurferJim
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 ***********************************************************************************************/

public class Cheeks extends BioMightBase {
	private ArrayList cheeks;
	private BioMightTransforms bioMightTransforms; 
	private String componentID = "";
	
	
	/*********************************************************************************
	 * CONSTRUCTORS
	 *
	 *********************************************************************************/
	
	public Cheeks()
	{
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, Constants.CheeksRef, null, null);
	}

	public Cheeks(String parentID)
	{
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, parentID, null, null);
	}

	public Cheeks(int hierarchy, int LOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
	{
		create(hierarchy, LOD, parentID, bioMightProperties, bioMightMethods);
	}

	/*****************************************************************
	 * CREATE Cheeks
	 * 
	 * @param parentID
	 * @param bioMightMethods
	 ******************************************************************/
	public void create(int hierarchy, int LOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
	{
		cheeks = new ArrayList();
		
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Getting CheekInfo for ParentID: " + parentID);
			InitialContext ctx = new InitialContext();
			BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
			bioMightTransforms = bioMightBean.getComponents(Constants.CheekRef, parentID);
			System.out.println("Have Cheek Info from EJB");   	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - Cheeks");
			throw new ServerException("Remote Exception getComponents():", e); 	
		}
	
		componentID = Constants.CheeksRef+":0"; 
	
		// Run through the collection of Cheeks and build them into the model
		// In the Default case, we get two instances of the eys, one
		// positioned on the right and one positioned on the left
		ArrayList transforms = bioMightTransforms.getTransforms();
		System.out.println("Have Cheeks Num Transforms: " + transforms.size());
		for (int i=0; i<transforms.size(); i++)
		{
			// Get the information for the cheek we are creating
			BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
			System.out.println("Creating Cheek: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
			
			
			// Create an instance of the Cheek for each transform specified for the organism
			Cheek cheek = new Cheek(bioMightTransform.getId(), bioMightMethods);		
			cheek.setComponentID(bioMightTransform.getId());
			System.out.println("Cheek Created!: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
			cheeks.add(cheek);
			System.out.println("Add to Collection!: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());

		}

	}
			
	
	/********************************************************************************************************************
	 * GET X3D
	 * 
	 * This method will return the X3D for the Cell.  It runs through each of its components and collects up their
	 * representations and then assembles them into one unified X3D model.
	 * 
	 ********************************************************************************************************************/
	public String getX3D(boolean snipet) {
		
		// Assemble the Cheeks
		String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
		"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n " +
		"<X3D profile='Immersive' >\n" +
		"<head>\n" +
		 "<meta name='BioMightImage' content='Cheeks.jpg'/>\n" +
		 "<meta name='ExportTime' content='7:45:30'/>\n" +
		 "<meta name='ExportDate' content='08/15/2008'/>\n" +
		 "<meta name='BioMight Version' content='1.0'/>\n" + 
		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='Cheeks'\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		

		String body = ""; 
		System.out.println("Assembling X3D for Cheeks");
		
		// Run through the collection of cheeks and assemble the X3D for each
		for (int i=0; i<cheeks.size(); i++)
		{
			// Get the information for the cheek
			Cheek cheek = (Cheek) cheeks.get(i);
			System.out.println("Getting X3D for Cheek("+i+") " + cheek.getComponentID());
			body += cheek.getX3D(true);
		}		
		
		//System.out.println("Combined Cheeks X3D: " + body);		
		String footer = "</Scene>" + "</X3D>\n";
		
		if (snipet)
			return body;			
		else	
			return header + body + footer;
	}	
	

	public String getComponentID() {
		return componentID;
	}


	public void setComponentID(String componentID) {
		this.componentID = componentID;
	}

	
}
