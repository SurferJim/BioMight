/*
 * Created on May 2, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.system.tissue.connective;

import java.util.ArrayList;

import biomight.BioMightBase;
import biomight.Constants;
import biomight.cell.CellMembrane;
import biomight.view.BioMightMethodView;
import biomight.view.BioMightPropertyView;
import biomight.view.BioMightSphere;

/**
 * @author SurferJim
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class Osteocyte extends BioMightBase {
	private BioMightSphere bioMightSphere;
	CellMembrane cellMembrane;
	
		
	public Osteocyte()
	{		
		// Create hte base Eye
		create(Constants.ArmRef, null);
	}
	
	public Osteocyte(String parentID)
	{				
		create(parentID, null);	
	}
	

	public Osteocyte(String parentID, ArrayList<BioMightMethodView> bioMightMethods)
	{				
		create(parentID, bioMightMethods);	
	}
	

	/************************************************************************************
	 * 
	 * CREATE Osteocyte
	 * 
	 * @param ArmReference
	 ***********************************************************************************/
	
	public void create(String parentID, ArrayList<BioMightMethodView> bioMightMethods)
	{		
		this.setImage("images/Osteocyte.gif");
		setImageWidth(200);
		setImageHeight(150);
		
		viewPerspective = Constants.VIEW_FLOATING;
		if (viewPerspective == Constants.VIEW_FLOATING) {
			
			// If we have initialization parameters from the form, 
			//  then apply them before constructing the objects.
			if (bioMightMethods != null){
				//System.out.println("NEED TO EXECUTE Osteocyte METHODS: " + bioMightMethods.size());
			}		
	
			//cellMembrane  = new CellMembrane(parentID, bioMightMethods);
			
			//initProperty("Humerus", Constants.Humerus, Constants.HumerusRef, humerus.getComponentID());
			
			//System.out.println("Shell Created for Osteocyte");		
		} 
		else if (viewPerspective == Constants.VIEW_INTERNAL) {
	
		}	
		
		//initProperties();
		initMethods();
	
	}


	public void initProperties() {
	
		BioMightPropertyView property = new BioMightPropertyView();
		property.setPropertyName("Osteocyte");
		property.setCanonicalName(Constants.Osteocyte);
		properties.add(property);
	}
	

	public void initMethods() {
	
		BioMightMethodView method = new BioMightMethodView();
		method.setMethodName("Set Membrane Width");
		method.setHtmlType("text");
		methods.add(method);

		method = new BioMightMethodView();
		method.setMethodName("Set Volumme");
		method.setHtmlType("text");
		methods.add(method);
	}

	
	/********************************************************************************************************************
	 * GET X3D
	 * 
	 * This method will return the X3D for the Arm.  It runs through each of its components and collects up their
	 * representations and then assembles them into one unified X3D model.
	 * 
	 ********************************************************************************************************************/
	public String getX3D(boolean snipet) {
		
		// Assemble the Osteocyte
		String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
		"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n " +
		"<X3D profile='Immersive' >\n" +
		"<head>\n" +
		 "<meta name='BioMightImage' content='Osteocyte.jpg'/>\n" +
		 "<meta name='ExportTime' content='7:45:30'/>\n" +
		 "<meta name='ExportDate' content='08/15/2008'/>\n" +
		 "<meta name='BioMight Version' content='1.0'/>\n" + 
		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='Osteocyte'\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		

		String body = "";	//cellMembrane.getX3D(true);  
		//System.out.println("Osteocyte X3D: " + body);		
		
		String footer = "</Scene>" + "</X3D>\n";
		
		if (snipet)
			return body;			
		else	
			return header + body + footer;
	}
	
}
