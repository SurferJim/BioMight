/*
 * Created on Jul 5, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.body.head.nose;

import java.util.ArrayList;

import javax.naming.InitialContext;

import biomight.BioMight3D;
import biomight.BioMightBase;
import biomight.Constants;
import biomight.cell.epithelial.EthmoidalCell;
import biomight.ejb.BioMightBeanLocal;
import biomight.exceptions.ServerException;
import biomight.system.tissue.epithelial.EpitheliumTissue;
import biomight.view.BioMightMethodView;
import biomight.view.BioMightPropertyView;
import biomight.view.BioMightTransform;
import biomight.view.BioMightTransforms;

/**
 * @author SurferJim
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class FrontalSinus extends BioMightBase { 
	private EpitheliumTissue epithelium;
	
	
	public FrontalSinus()
	{
		create(Constants.FrontalSinusRef, null);
	}

	
	public FrontalSinus(String parentID, ArrayList<BioMightMethodView> bioMightMethods)
	{
		create(parentID, bioMightMethods);
	}
	
	
	public void create(String parentID, ArrayList<BioMightMethodView> bioMightMethods)
	{
		this.setImage("images/FrontalSinus.jpg");
				
		//epithelium = new EpitheliumTissue("FrontalSinusEpithelium", parentID, bioMightMethods);
		//initProperty("FrontalSinus Epithelium", Constants.Epithelium, Constants.EpitheliumRef, bioMightTransform.getId());
		System.out.println("FrontalSinus Epithelium completed");		
				
		initProperties();
		initMethods();
	}
	
	
	public void redraw(int parentID)
	{

		System.out.println("FrontalSinus Redraw");
		init3D(parentID);
	}
	
	
	
	public void initProperties() {
	
		BioMightPropertyView property = new BioMightPropertyView();
		property.setPropertyName("FrontalSinus");
		property.setCanonicalName(Constants.FrontalSinus);
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
	 * This method will return the X3D for the FrontalSinus.  It runs through each of its components and collects up their
	 * representations and then assembles them into one unified X3D model.
	 * 
	 ********************************************************************************************************************/
	public String getX3D(boolean snipet) {
		
		// Assemble the FrontalSinus
		String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
		"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n " +
		"<X3D profile='Immersive' >\n" +
		"<head>\n" +
		 "<meta name='BioMightImage' content='FrontalSinus.jpg'/>\n" +
		 "<meta name='ExportTime' content='7:45:30'/>\n" +
		 "<meta name='ExportDate' content='08/15/2008'/>\n" +
		 "<meta name='BioMight Version' content='1.0'/>\n" + 
		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='FrontalSinus'\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		

		String body = ""; //epithelium.getX3D(true);
		
		System.out.println("FrontalSinus X3D: " + body);		
		String footer = "</Scene>" + "</X3D>\n";
		
		if (snipet)
			return body;			
		else	
			return header + body + footer;
	}
	
	
	
	
	public void setFrontalSinusClass(int FrontalSinusClass)
	{
		if (FrontalSinusClass == 1)
		{
			// The Roman, or Aquiline FrontalSinus
		}
		if (FrontalSinusClass == 2)
		{
			// The Greek or Straight FrontalSinus
		}
		if (FrontalSinusClass == 3)
		{
			// The African, or Wide-nostrilled FrontalSinus
		}
		if (FrontalSinusClass == 4)
		{
			// The Jewish or Hawk FrontalSinus
		}
		if (FrontalSinusClass == 5)
		{
			// The Snub FrontalSinus
		}
		if (FrontalSinusClass == 6)
		{
			// The Turn-up or Celestial nos
		}		
	}


}
