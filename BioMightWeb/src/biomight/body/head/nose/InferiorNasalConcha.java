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
 * Representation of the InferiorNasalConcha
 */

public class InferiorNasalConcha extends BioMightBase { 
	private EpitheliumTissue epithelium;


	
	public InferiorNasalConcha()
	{
		create(Constants.InferiorNasalConchaRef, null);
	}

	
	public InferiorNasalConcha(String parentID, ArrayList<BioMightMethodView> bioMightMethods)
	{
		create(parentID, bioMightMethods);
	}
	
	
	public void create(String parentID, ArrayList<BioMightMethodView> bioMightMethods)
	{
		this.setImage("images/InferiorNasalConcha.jpg");

		// Get the data for the InferiorNasalConcha that is defined for this 
		// body reference.  Read it into the matrix that is mapped 
		// to the imaging device
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Getting InferiorNasalConchaInfo for ParentID: " + parentID);
			InitialContext ctx = new InitialContext();
			BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
			bioMightTransforms = bioMightBean.getComponents(Constants.InferiorNasalConchaRef, parentID);
			System.out.println("Have InferiorNasalConcha Info from EJB");   	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - InferiorNasalConcha");
			throw new ServerException("Remote Exception getComponents():", e); 	
		}

		// Run through the collection of UpperLip and build them into the model
		// In the default case, we get one instance of the Pupil for each eye
		ArrayList transforms = bioMightTransforms.getTransforms();
		System.out.println("Have InferiorNasalConcha Info NumTransforms: " + transforms.size());
		for (int i=0; i<transforms.size(); i++)
		{
			// Get the information for the Upper Lip we are creating
			BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
			System.out.println("Creating InferiorNasalConcha (name,id): " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
			componentID = bioMightTransform.getId();
			
	
			epithelium = new EpitheliumTissue("InferiorNasalConchaEpithelium", bioMightTransform.getId(), bioMightMethods);
			initProperty("InferiorNasalConchaEpithelium", Constants.EpitheliumTissue, Constants.EpitheliumTissueRef, epithelium.getComponentID());
			System.out.println("InferiorNasalConcha Epithelium completed");		
		}		

		//initProperties();
		initMethods();
	}
	
	
	public void redraw(int parentID)
	{

		System.out.println("InferiorNasalConcha Redraw");
		init3D(parentID);
	}

	
	public void initProperties() {
	
		BioMightPropertyView property = new BioMightPropertyView();
		property.setPropertyName("InferiorNasalConcha");
		property.setCanonicalName(Constants.InferiorNasalConcha);
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
	 * This method will return the X3D for the InferiorNasalConcha.  It runs through each of its components and collects up their
	 * representations and then assembles them into one unified X3D model.
	 * 
	 ********************************************************************************************************************/
	public String getX3D(boolean snipet) {
		
		// Assemble the InferiorNasalConcha
		String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
		"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n " +
		"<X3D profile='Immersive' >\n" +
		"<head>\n" +
		 "<meta name='BioMightImage' content='InferiorNasalConcha.jpg'/>\n" +
		 "<meta name='ExportTime' content='7:45:30'/>\n" +
		 "<meta name='ExportDate' content='08/15/2008'/>\n" +
		 "<meta name='BioMight Version' content='1.0'/>\n" + 
		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='InferiorNasalConcha'\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		

		String body = epithelium.getX3D(true);
		
		//System.out.println("InferiorNasalConcha X3D: " + body);		
		String footer = "</Scene>" + "</X3D>\n";
		
		if (snipet)
			return body;			
		else	
			return header + body + footer;
	}
	
	
	
	
	public void setInferiorNasalConchaClass(int InferiorNasalConchaClass)
	{
		if (InferiorNasalConchaClass == 1)
		{
			// The Roman, or Aquiline InferiorNasalConcha
		}
		if (InferiorNasalConchaClass == 2)
		{
			// The Greek or Straight InferiorNasalConcha
		}
		if (InferiorNasalConchaClass == 3)
		{
			// The African, or Wide-nostrilled InferiorNasalConcha
		}
		if (InferiorNasalConchaClass == 4)
		{
			// The Jewish or Hawk InferiorNasalConcha
		}
		if (InferiorNasalConchaClass == 5)
		{
			// The Snub InferiorNasalConcha
		}
		if (InferiorNasalConchaClass == 6)
		{
			// The Turn-up or Celestial nos
		}		
	}

}
