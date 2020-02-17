/*
 * Created on Jul 5, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.body.head.mouth;
import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;

import biomight.BioMightBase;
import biomight.Constants;
import biomight.ejb.BioMightBeanLocal;
import biomight.exceptions.DataSecurityException;
import biomight.exceptions.ServerException;
import biomight.system.cartilage.Cartilage;
import biomight.system.tissue.edothelial.EndotheliumTissue;
import biomight.system.tissue.epithelial.EpitheliumTissue;
import biomight.view.BioMightColor;
import biomight.view.BioMightMethodView;
import biomight.view.BioMightPolygon;
import biomight.view.BioMightPolygons;
import biomight.view.BioMightPosition;
import biomight.view.BioMightPositions;
import biomight.view.BioMightPropertyView;
import biomight.view.BioMightTransform;


/**************************************************************************************************************************
 * UPPER LIP
 *
 * Representation of the upper lip
 * 
 * @author SurferJim
 *
 *************************************************************************************************************************/


public class UpperLip extends Lip {
	private EndotheliumTissue endotheliumTissue;
	
	public UpperLip()
	{
		create(Constants.UpperLipRef, null);
	}

	public UpperLip(String parentID)
	{
		create(parentID, null);
	}

	
	public UpperLip(String parentID, ArrayList<BioMightMethodView> bioMightMethods)
	{
		create(parentID, bioMightMethods);
	}
	
	
	public void create(String parentID, ArrayList<BioMightMethodView> bioMightMethods)
	{
		setImage("images/UpperLip.jpg");
		setImageHeight(300);
		setImageWidth(300);
		
		// Get the information from the database via the Enterprise Bean		
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Getting UpperLipInfo for ParentID: " + parentID);
			Context ctx = new InitialContext(); 
			BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
			bioMightTransforms = bioMightBean.getComponents(Constants.UpperLipRef, parentID);
			System.out.println("Have UpperLip Info from EJB");   	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - UpperLip");
			throw new ServerException("Remote Exception getComponents():", e); 	
		}
			
		// Run through the collection of UpperLip and build them into the model
		// In the default case, we get one instance of the Pupil for each eye
		ArrayList transforms = bioMightTransforms.getTransforms();
		System.out.println("UpperLip NumTransforms: " + transforms.size());
		for (int i=0; i<transforms.size(); i++)
		{
			// Get the information for the Upper Lip we are creating
			BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
			System.out.println("Creating UpperLip (name,id): " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
			
			endotheliumTissue = new EndotheliumTissue("UpperLipEndothelium", bioMightTransform.getId(), bioMightMethods);
			System.out.println("Created UpperLipTissue for UpperLip");			
		}		
	
		System.out.println("Created Upper Lip for: " + parentID);
	}
	
	
	public void redraw(String parentID)
	{
		System.out.println("Upper Lip Redraw");
		//init3D(parentID);
	}
	
	
	/*********************************************************************************
	 * INIT 3D
	 * 
	 * This method will be executed when we can see cartilage with our regular
	 * perception.  This is not at the cellular level, but as if one were looking
	 * at the ear.
	 *
	 ********************************************************************************/
	public void init3D(int parentID) {
		
			/*
				-1.25, -3.20, 0.5, 0.00, -3.00, 0.5, 0.00, -3.23, 0.5, -1.25, -3.25, 0.5
				0.00, -3.00, 0.5, 1.25, -3.20, 0.5, 1.25, -3.25, 0.5, 0.0, -3.23, 0.5			
			*/
			//vertex.setZPos(Double.valueOf(coords[i+2])-0.20);
	}
	
	
	/********************************************************************************************************************
	 * GET X3D
	 * 
	 * This method will return the X3D for the Cell.  It runs through each of its components and collects up their
	 * representations and then assembles them into one unified X3D model.
	 * 
	 ********************************************************************************************************************/
	public String getX3D(boolean snipet) {
		
		// Assemble the UpperLip
		String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
		"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n " +
		"<X3D profile='Immersive' >\n" +
		"<head>\n" +
		 "<meta name='BioMightImage' content='UpperLip.jpg'/>\n" +
		 "<meta name='ExportTime' content='7:45:30'/>\n" +
		 "<meta name='ExportDate' content='08/15/2008'/>\n" +
		 "<meta name='BioMight Version' content='1.0'/>\n" + 
		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='UpperLip'\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		


		String body = endotheliumTissue.getX3D(true);
		
		
		System.out.println("UpperLip X3D: " + body);		
		String footer = "</Scene>" + "</X3D>\n";
		
		if (snipet)
			return body;			
		else	
			return header + body + footer;
	}
		
}
