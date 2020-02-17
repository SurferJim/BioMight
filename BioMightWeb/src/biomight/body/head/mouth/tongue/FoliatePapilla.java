/*
 * Created on Jul 5, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.body.head.mouth.tongue;
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
import biomight.system.tissue.connective.ConnectiveTissue;
import biomight.system.tissue.epithelial.EpitheliumTissue;
import biomight.system.tissue.nervous.Nerves;
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

/**
 * @author SurferJim
 *
 * Representation of a FoliatePapilla
 * 
 */


public class FoliatePapilla extends BioMightBase {
	// The components of a FoliatePapilla
	private ConnectiveTissue connectiveTissue;
	private Nerves nerves;
	
	
	/********************************************************************
	 * Constructtors
	 * 
	 *******************************************************************/
	public FoliatePapilla()
	{
		create(Constants.FoliatePapillaRef, null);
	}

	
	public FoliatePapilla(String parentID, ArrayList<BioMightMethodView> bioMightMethods)
	{
		create(parentID, bioMightMethods);
	}
	
	
	public void create(String parentID, ArrayList<BioMightMethodView> bioMightMethods)
	{
		this.setImage("images/FoliatePapilla.jpg");
		properties = new ArrayList<BioMightPropertyView>();;
		componentID=parentID;
			
		//connectiveTissue = new ConnectiveTissue("PapillaConnectiveTissue", parentID, bioMightMethods);
		//initProperty("PapillaConnectiveTissue", Constants.ConnectiveTissue, Constants.ConnectiveTissueRef, connectiveTissue.getComponentID());
		//System.out.println("FoliatePapilla completed");		

		//initProperties();
		initMethods();
	}
	
	
	public void redraw(int parentID)
	{
		System.out.println("FoliatePapilla Redraw");
		init3D(parentID);
	}
	
	
	public void initProperties() {
	
		BioMightPropertyView property = new BioMightPropertyView();
		property.setPropertyName("TasteBud");
		property.setCanonicalName(Constants.TasteBud);
		properties.add(property);
	
		property = new BioMightPropertyView();
		property.setPropertyName("EthmoidalCell");
		property.setCanonicalName(Constants.EthmoidalCell);
		properties.add(property);				

				
	}
	
	
	public void initMethods() {
		BioMightMethodView method = new BioMightMethodView();
		method.setMethodName("Twitch");
		method.setHtmlType("checkbox");
		methods.add(method);
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
	
	}
	
	
	/********************************************************************************************************************
	 * GET X3D
	 * 
	 * This method will return the X3D for the Cell.  It runs through each of its components and collects up their
	 * representations and then assembles them into one unified X3D model.
	 * 
	 ********************************************************************************************************************/
	public String getX3D(boolean snipet) {
		
		// Assemble the FoliatePapilla
		String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
		"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n " +
		"<X3D profile='Immersive' >\n" +
		"<head>\n" +
		 "<meta name='BioMightImage' content='FoliatePapilla.jpg'/>\n" +
		 "<meta name='ExportTime' content='7:45:30'/>\n" +
		 "<meta name='ExportDate' content='08/15/2008'/>\n" +
		 "<meta name='BioMight Version' content='1.0'/>\n" + 
		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='FoliatePapilla'\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		

		String body = connectiveTissue.getX3D(true);
		
		//System.out.println("FoliatePapilla  X3D: " + body);		
		String footer = "</Scene>" + "</X3D>\n";
		
		if (snipet)
			return body;			
		else	
			return header + body + footer;
	}
	
	
	
	
	public void setFoliatePapillaClass(int FoliatePapillaClass)
	{
		if (FoliatePapillaClass == 1)
		{
			// The Roman, or Aquiline FoliatePapilla
		}
		else if (FoliatePapillaClass == 6)
		{
			// The Turn-up or Celestial nos
		}		
	}
	
}
