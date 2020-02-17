/*
 * Created on Jul 22, 2006
 * Copyright 2006 - Biomight.org
 * 
 * This code is the not to be used without written permission from
 * BioMight.org
 * 
 */
 
package biomight.cell.epithelial;

import java.lang.reflect.Method;
import java.util.ArrayList;

import javax.naming.InitialContext;

import biomight.BioMightBase;
import biomight.Constants;
import biomight.cell.CellMembrane;
import biomight.ejb.BioMightBeanLocal;
import biomight.exceptions.ServerException;
import biomight.view.BioMightMethodView;
import biomight.view.BioMightPropertyView;
import biomight.view.BioMightTransform;
import biomight.view.BioMightTransforms;

/**
 * Representation of a collection of Epithelial Cells
 *
 * SurferJim
 */

public class EpithelialCells extends BioMightBase {
	private String cellName = "EpithelialCell";
	private String cellRef = "EpithelialCell";
	private ArrayList epithelialCells;
	
	/********************************************************************************************************************
	 *  EARS
	 * 
	 * This method will instantiate the EpithelialCells that are defined for the current model.  
	 * 
	 ********************************************************************************************************************/

	
	public EpithelialCells()
	{		
		create(this.cellRef, Constants.HeadRef, null);
	}
	

	/********************************************************************************************************************
	 *  EARS
	 * 
	 * This method will instantiate the Eyes that are defined for the current model.  
	 * 
	 ********************************************************************************************************************/

	
	public EpithelialCells(String parentID)
	{		
		create(this.cellRef, parentID, null);
	}
	

	public EpithelialCells(String parentID, ArrayList<BioMightMethodView> bioMightMethods)
	{		
		create(this.cellRef, parentID, bioMightMethods);
	}

	public EpithelialCells(String cellRef, String parentID, ArrayList<BioMightMethodView> bioMightMethods)
	{		
		create(cellRef, parentID, bioMightMethods);
		this.cellRef = cellRef;
		
	}
	
	/********************************************************************************************************************
	 * CREATE EARS
	 * 
	 * This method will instantiate the Eyes that are defined for the current model.  
	 * 
	 ********************************************************************************************************************/

	private void create(String cellRef, String parentID, ArrayList<BioMightMethodView> bioMightMethods) {

		// Allocate space for the collection of epithelialCells
		epithelialCells = new ArrayList();
		
		
		if (!cellRef.equals(""))
			this.cellName = cellRef;
		
		// Get the information from the database via the Enterprise Bean		
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Getting EpithelialCellsInfo for ParentID: " + parentID);
			InitialContext ctx = new InitialContext();
			BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
			bioMightTransforms = bioMightBean.getComponents(cellRef, parentID);
			System.out.println("Have EpithelialCells Info from EJB");   	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - EpithelialCells");
			throw new ServerException("Remote Exception getComponents():", e); 	
		}

		
		// This is a collection, so set the parent of the children
		// to that of the aggregation object
		componentID = parentID;
	
		// Run through the collection of EpithelialCells and build them into the model
		// In the Default case, we get two instances of the epithelialCell, one
		// positioned on the right and one positioned on the left
		ArrayList transforms = bioMightTransforms.getTransforms();
		System.out.println("Creating EpithelialCells NumTransforms: " + transforms.size());

		for (int i=0; i<transforms.size(); i++)
		{
			// Get the information for the eye we are creating
			BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
			System.out.println("Creating EpithelialCell: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
		
			// Create an instance of the EpithelialCell for each tranform brought
			// EpithelialCells from the model.  We grabbed the component ID during this fetch
			// so pass it to the EAR creator so that it can be used as a parent reference
			EpithelialCell epithelialCell = new EpithelialCell(bioMightTransform.getId(), bioMightMethods);			
			epithelialCells.add(epithelialCell);
			System.out.println("Added EpithelialCell to Collection!: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
			
			// initialize the Properties
			// in this case, rather than pass canonical name, we pass the name found in the collection
			initProperty(bioMightTransform.getName(), Constants.EpithelialCell, Constants.EpithelialCellRef, bioMightTransform.getId());
		}
		
		// Set up methods that will be available to the epithelialCells
		initMethods();
	}
			

	
	public void initMethods() {
	
		BioMightMethodView method = new BioMightMethodView();
		method.setCanonicalName(Constants.EpithelialCells);
		method.setMethodName("setMaterial");
		method.setDisplayName("Color");
		method.setHtmlType(Constants.BIO_DROPDOWN);
		method.setDataType(Constants.BIO_TEXT);
	 	method.setValueMap(materialDDMap);
		methods.add(method);
		
		method = new BioMightMethodView();
		method.setCanonicalName(Constants.EpithelialCells);
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
	 * This method will return the X3D for the EpithelialCells.  It runs through each of its components and collects up their
	 * representations and then assembles them into one unified X3D model.
	 * 
	 ********************************************************************************************************************/
	public String getX3D(boolean snipet) {
		
		// Assembe the EpithelialCells
		String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
		"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n " +
		"<X3D profile='Immersive' >\n" +
		"<head>\n" +
		 "<meta name='BioMightImage' content='EpithelialCells.jpg'/>\n" +
		 "<meta name='ExportTime' content='7:45:30'/>\n" +
		 "<meta name='ExportDate' content='08/15/2008'/>\n" +
		 "<meta name='BioMight Version' content='1.0'/>\n" + 
		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='EpithelialCells'\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		

		String body = ""; 
		System.out.println("Assembling X3D for EpithelialCells");
		
		// Run through the collection of eyes and assemble the X3D for each
		for (int i=0; i<epithelialCells.size(); i++)
		{
			// Get the information for the eye
			EpithelialCell epithelialCell = (EpithelialCell) epithelialCells.get(i);
			System.out.println("Getting X3D for EpithelialCell");
			body += epithelialCell.getX3D(true);
		}		
		

		//System.out.println("EpithelialCells X3D: " + body);		
		
		String footer = "</Scene>" + "</X3D>\n";
		
		if (snipet)
			return body;			
		else	
			return header + body + footer;
	}



	
	
	public String getCellName() {
		return cellName;
	}


	public void setCellName(String cellName) {
		this.cellName = cellName;
	}


	public String getCellRef() {
		return cellRef;
	}


	public void setCellRef(String cellRef) {
		this.cellRef = cellRef;
	}
	
}


