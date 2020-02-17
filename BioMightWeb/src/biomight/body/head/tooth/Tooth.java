/*
 * Created on Jul 5, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.body.head.tooth;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.naming.InitialContext;

import biomight.BioMight3D;
import biomight.BioMightBase;
import biomight.Constants;
import biomight.cell.epithelial.EthmoidalCell;
import biomight.chemistry.compound.Dentin;
import biomight.chemistry.compound.Enamel;
import biomight.ejb.BioMightBeanLocal;
import biomight.exceptions.DataSecurityException;
import biomight.exceptions.ServerException;
import biomight.system.cartilage.Cartilage;
import biomight.system.tissue.epithelial.EpitheliumTissue;
import biomight.view.BioMightColor;
import biomight.view.BioMightMaterial;
import biomight.view.BioMightMethodView;
import biomight.view.BioMightPolygon;
import biomight.view.BioMightPolygons;
import biomight.view.BioMightPosition;
import biomight.view.BioMightPositions;
import biomight.view.BioMightPositionsIndex;
import biomight.view.BioMightPropertyView;
import biomight.view.BioMightTransform;
import biomight.view.BioMightTransforms;

/***************************************************************************************
 * @author SurferJim
 *
 * Representation of a Tooth
 * 
 ***************************************************************************************/

public class Tooth extends BioMightBase {	
	// The components of a tooth
	private Enamel enamel;
	private Dentin dentin;
	private Root root;
	
	
	public Tooth()
	{
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, Constants.ToothRef, null, null);
	}

	public Tooth(String parentID)
	{
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, parentID, null, null);
	}

	public Tooth(int hierarchy, int LOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
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
		this.setImage("images/Tooth.jpg");
		componentID=parentID;
		
		enamel = new Enamel("Enamel", parentID, bioMightMethods);
		initProperty("Tooth Enamel", Constants.Enamel, Constants.EnamelRef, "Tooth:032");
		//System.out.println("Tooth Enamel completed");		

		dentin = new Dentin("Enamel", parentID, bioMightMethods);
		initProperty("Tooth Dentin", Constants.Dentin, Constants.DentinRef, "Tooth:032");
		//System.out.println("Tooth Enamel completed");		

		//initProperties();
		initMethods();
	}
	
	
	public void initProperties() {
	
		BioMightPropertyView property = new BioMightPropertyView();
		property.setPropertyName("NasalSeptum");
		property.setCanonicalName(Constants.NasalSeptum);
		properties.add(property);
	
		property = new BioMightPropertyView();
		property.setPropertyName("EthmoidalCell");
		property.setCanonicalName(Constants.EthmoidalCell);
		properties.add(property);				

		property = new BioMightPropertyView();
		property.setPropertyName("FrontalSinuses");
		property.setCanonicalName(Constants.FrontalSinuses);
		properties.add(property);		

		property = new BioMightPropertyView();
		property.setPropertyName("InferiorNasalConcha");
		property.setCanonicalName(Constants.InferiorNasalConcha);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("SuperiorNasalConcha");
		property.setCanonicalName(Constants.SuperiorNasalConcha);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("MiddleNasalConcha");
		property.setCanonicalName(Constants.MiddleNasalConcha);
		properties.add(property);
				
	}
	
	
	public void initMethods() {

		BioMightMethodView method = new BioMightMethodView();
		method.setMethodName("Erode");
		method.setHtmlType("checkbox");
		methods.add(method);
		method.setMethodName("Decay");
		method.setHtmlType("checkbox");
		methods.add(method);
		method.setMethodName("Tarnish");
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
		
		// Assemble the Tooth
		String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
		"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n " +
		"<X3D profile='Immersive' >\n" +
		"<head>\n" +
		 "<meta name='BioMightImage' content='Tooth.jpg'/>\n" +
		 "<meta name='ExportTime' content='7:45:30'/>\n" +
		 "<meta name='ExportDate' content='08/15/2008'/>\n" +
		 "<meta name='BioMight Version' content='1.0'/>\n" + 
		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='Tooth'\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		

		String body = enamel.getX3D(true);
		
		//System.out.println("Tooth  X3D: " + body);		
		String footer = "</Scene>" + "</X3D>\n";
		
		if (snipet)
			return body;			
		else	
			return header + body + footer;
	}



	public String getComponentID() {
		return componentID;
	}

	
}
