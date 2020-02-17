/*
 * Created on May 8, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.body.head.ear;
import java.util.ArrayList;

import javax.naming.InitialContext;

import biomight.BioMightBase;
import biomight.Constants;
import biomight.ejb.BioMightBeanLocal;
import biomight.exceptions.ServerException;
import biomight.view.BioMightMethodView;
import biomight.view.BioMightPropertyView;
import biomight.view.BioMightTransform;
import biomight.view.BioMightTransforms;

/**
 * @author SurferJim
 *
 * Representation of CochleaHairCells
 * 
 */

public class CochleaHairCells extends BioMightBase {
	private ArrayList cochleaHairCells;
	
	
	/********************************************************************************************************************
	 *  CochleaHairCells
	 * 
	 * This method will instantiate the CochleaHairCells that are defined for the current model.  
	 * 
	 ********************************************************************************************************************/

	
	public CochleaHairCells()
	{		
		create(Constants.HeadRef, null);
	}
	

	/********************************************************************************************************************
	 *  CochleaHairCells
	 * 
	 * This method will instantiate the Eyes that are defined for the current model.  
	 * 
	 ********************************************************************************************************************/

	
	public CochleaHairCells(String parentID)
	{		
		create(parentID, null);
	}
	

	public CochleaHairCells(String parentID, ArrayList<BioMightMethodView> bioMightMethods)
	{		
		create(parentID, bioMightMethods);
	}
	
	
	/********************************************************************************************************************
	 * CREATE CochleaHairCells
	 * 
	 * This method will instantiate the Eyes that are defined for the current model.  
	 * 
	 ********************************************************************************************************************/

	private void create(String parentID, ArrayList<BioMightMethodView> bioMightMethods) {

		// Allocate space for the collection of cochleaHairCells
		cochleaHairCells = new ArrayList();
		
		
		// Get the information from the database via the Enterprise Bean		
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Getting CochleaHairCells Info for ParentID: " + parentID);
			InitialContext ctx = new InitialContext();
			BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
			bioMightTransforms = bioMightBean.getComponents(Constants.CochleaHairCellRef, parentID);
			System.out.println("Have CochleaHairCell Info from EJB");   	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - CochleaHairCells");
			throw new ServerException("Remote Exception getComponents():", e); 	
		}

		
		// This is a collection, so set the parent of the children
		// to that of the aggregation object
		componentID = parentID;
	
		// Run through the collection of CochleaHairCells and build them into the model
		// In the Default case, we get two instances of the cochleaHairCell, one
		// positioned on the right and one positioned on the left
		ArrayList transforms = bioMightTransforms.getTransforms();
		System.out.println("Creating CochleaHairCells NumTransforms: " + transforms.size());

		for (int i=0; i<transforms.size(); i++)
		{
			// Get the information for the eye we are creating
			BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
			System.out.println("Creating CochleaHairCell: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
		
			// Create an instance of the CochleaHairCell for each tranform brought
			// CochleaHairCells from the model.  We grabbed the component ID during this fetch
			// so pass it to the EAR creator so that it can be used as a parent reference
			CochleaHairCell cochleaHairCell = new CochleaHairCell(bioMightTransform.getId(), bioMightMethods);			
			cochleaHairCells.add(cochleaHairCell);
			System.out.println("Added CochleaHairCell to Collection!: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
			
			// initialize the Properties
			// in this case, rather than pass canonical name, we pass the name found in the collection
			initProperty(bioMightTransform.getName(), Constants.CochleaHairCell, Constants.CochleaHairCellRef, bioMightTransform.getId());
		}
		
		// Set up methods that will be available to the cochleaHairCells
		initMethods();
	}
			
	
	
	public void initMethods() {
	
		BioMightMethodView method = new BioMightMethodView();
		method.setCanonicalName(Constants.CochleaHairCells);
		method.setMethodName("setMaterial");
		method.setDisplayName("Color");
		method.setHtmlType(Constants.BIO_DROPDOWN);
		method.setDataType(Constants.BIO_TEXT);
	 	method.setValueMap(materialDDMap);
		methods.add(method);
		
		method = new BioMightMethodView();
		method.setCanonicalName(Constants.CochleaHairCells);
		method.setMethodName("setTexture");
		method.setDisplayName("Texture");
		method.setHtmlType(Constants.BIO_DROPDOWN);
		method.setDataType(Constants.BIO_TEXT);
	 	method.setValueMap(textureDDMap);
		methods.add(method);	
	}
	
	/********************************************************************************************************************
	 * GET X3D
	 * 
	 * This method will return the X3D for the CochleaHairCells.  It runs through each of its components and collects up their
	 * representations and then assembles them into one unified X3D model.
	 * 
	 ********************************************************************************************************************/
	public String getX3D(boolean snipet) {
		
		// Assembe the CochleaHairCells
		String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
		"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n " +
		"<X3D profile='Immersive' >\n" +
		"<head>\n" +
		 "<meta name='BioMightImage' content='CochleaHairCells.jpg'/>\n" +
		 "<meta name='ExportTime' content='7:45:30'/>\n" +
		 "<meta name='ExportDate' content='08/15/2008'/>\n" +
		 "<meta name='BioMight Version' content='1.0'/>\n" + 
		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='CochleaHairCells'\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		

		String body = ""; 
		System.out.println("Assembling X3D for CochleaHairCells");
		
		// Run through the collection of eyes and assemble the X3D for each
		for (int i=0; i<cochleaHairCells.size(); i++)
		{
			// Get the information for the eye
			CochleaHairCells cochleaHairCell = (CochleaHairCells) cochleaHairCells.get(i);
			System.out.println("Getting X3D for CochleaHairCell");
			body += cochleaHairCell.getX3D(true);
		}		
		

		System.out.println("CochleaHairCells X3D: " + body);		
		
		String footer = "</Scene>" + "</X3D>\n";
		
		if (snipet)
			return body;			
		else	
			return header + body + footer;
	}

}
