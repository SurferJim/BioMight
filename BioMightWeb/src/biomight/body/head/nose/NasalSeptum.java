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
public class NasalSeptum extends BioMightBase { 
	private EpitheliumTissue epithelium;


	
	
	public NasalSeptum()
	{
		create(Constants.NasalSeptumRef, null);
	}

	
	public NasalSeptum(String parentID, ArrayList<BioMightMethodView> bioMightMethods)
	{
		create(parentID, bioMightMethods);
	}
	
	
	public void create(String parentID, ArrayList<BioMightMethodView> bioMightMethods)
	{
		this.setImage("images/NasalSeptum.jpg");

		// Get the data for the NasalSeptum that is defined for this 
		// body reference.  Read it into the matrix that is mapped 
		// to the imaging device
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Getting NasalSeptumInfo for ParentID: " + parentID);
			InitialContext ctx = new InitialContext();
			BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
			bioMightTransforms = bioMightBean.getComponents(Constants.NasalSeptumRef, parentID);
			System.out.println("Have NasalSeptum Info from EJB");   	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - NasalSeptum");
			throw new ServerException("Remote Exception getComponents():", e); 	
		}
	
		// Run through the collection of UpperLip and build them into the model
		// In the default case, we get one instance of the Pupil for each eye
		ArrayList transforms = bioMightTransforms.getTransforms();
		System.out.println("Have NasalSeptum Info NumTransforms: " + transforms.size());
		for (int i=0; i<transforms.size(); i++)
		{
			// Get the information for the Upper Lip we are creating
			BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
			System.out.println("Creating NasalSeptum (name,id): " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
			componentID = bioMightTransform.getId();
				
			epithelium = new EpitheliumTissue("NasalSeptumEpithelium", bioMightTransform.getId(), bioMightMethods);
			//initProperty("NasalSeptum Epithelium", Constants.Epithelium, Constants.EpitheliumRef, bioMightTransform.getId());
			System.out.println("NasalSeptum Epithelium completed");		
		}		

		//initProperties();
		initMethods();
	}
	
	
	public void redraw(int parentID)
	{

		System.out.println("NasalSeptum Redraw");
		init3D(parentID);
	}

	
	public void initProperties() {
	
		BioMightPropertyView property = new BioMightPropertyView();
		property.setPropertyName("NasalSeptum");
		property.setCanonicalName(Constants.NasalSeptum);
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
	 * This method will return the X3D for the NasalSeptum.  It runs through each of its components and collects up their
	 * representations and then assembles them into one unified X3D model.
	 * 
	 ********************************************************************************************************************/
	public String getX3D(boolean snipet) {
		
		// Assemble the NasalSeptum
		String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
		"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n " +
		"<X3D profile='Immersive' >\n" +
		"<head>\n" +
		 "<meta name='BioMightImage' content='NasalSeptum.jpg'/>\n" +
		 "<meta name='ExportTime' content='7:45:30'/>\n" +
		 "<meta name='ExportDate' content='08/15/2008'/>\n" +
		 "<meta name='BioMight Version' content='1.0'/>\n" + 
		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='NasalSeptum'\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		

		String body = epithelium.getX3D(true);
		
		//System.out.println("NasalSeptum X3D: " + body);		
		String footer = "</Scene>" + "</X3D>\n";
		
		if (snipet)
			return body;			
		else	
			return header + body + footer;
	}
	
	
	
	public void setNasalSeptumClass(int NasalSeptumClass)
	{
		if (NasalSeptumClass == 1)
		{
			// The Roman, or Aquiline NasalSeptum
		}
		if (NasalSeptumClass == 2)
		{
			// The Greek or Straight NasalSeptum
		}
		if (NasalSeptumClass == 3)
		{
			// The African, or Wide-nostrilled NasalSeptum
		}
		if (NasalSeptumClass == 4)
		{
			// The Jewish or Hawk NasalSeptum
		}
		if (NasalSeptumClass == 5)
		{
			// The Snub NasalSeptum
		}
		if (NasalSeptumClass == 6)
		{
			// The Turn-up or Celestial nos
		}		
	}


}
