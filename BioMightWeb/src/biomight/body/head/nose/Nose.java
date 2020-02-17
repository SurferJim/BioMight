/*
 * Created on Jul 5, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.body.head.nose;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.naming.InitialContext;

import biomight.BioMight3D;
import biomight.BioMightBase;
import biomight.Constants;
import biomight.cell.epithelial.EthmoidalCell;
import biomight.ejb.BioMightBeanLocal;
import biomight.exceptions.DataSecurityException;
import biomight.exceptions.ServerException;
import biomight.system.cartilage.Cartilage;
import biomight.system.tissue.epithelial.EpitheliumTissue;
import biomight.util.BioGraphics;
import biomight.view.BioMightColor;
import biomight.view.BioMightMaterial;
import biomight.view.BioMightMethodView;
import biomight.view.BioMightPolygon;
import biomight.view.BioMightPolygons;
import biomight.view.BioMightPosition;
import biomight.view.BioMightPositions;
import biomight.view.BioMightPositionsIndex;
import biomight.view.BioMightPropertyView;
import biomight.view.BioMightScale;
import biomight.view.BioMightTransform;
import biomight.view.BioMightTransforms;

/***************************************************************************************
 * @author SurferJim
 *
 * Representation of the Nose
 * 
 ***************************************************************************************/


public class Nose extends BioMightBase {
	private EpitheliumTissue epithelium;
	private NasalSeptum nasalSeptum;
	private EthmoidalCell ethmoidalCell;
	private FrontalSinuses frontalSinuses;
	private InferiorNasalConcha inferiorNasalConcha;
	private SuperiorNasalConcha superiorNasalConcha;
	private MiddleNasalConcha middleNasalConcha;
	private SphenoidSinus sphenoidSinus;
	private SellaTunica sellaTunica;
	
	
	public Nose()
	{
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, Constants.NoseRef, null, null);
	}

	public Nose(String parentID)
	{
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, parentID, null, null);
	}

	public Nose(int hierarchy, int LOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
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
		this.setImage("images/Nose.jpg");
		this.setImageWidth(300);
		this.setImageHeight(325);

		// Get the information from the database via the Enterprise Bean		
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Getting NoseInfo for ParentID: " + parentID);
			InitialContext ctx = new InitialContext();
			BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
			bioMightTransforms = bioMightBean.getComponents(Constants.NoseRef, parentID);
			System.out.println("Have Nose Info from EJB");   	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - Nose");
			throw new ServerException("Remote Exception getComponents():", e); 	
		}
		
		int localVP = Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
	
		
		// Get the data for the Nose that is defined for this 
		// body reference.  Read it into the matrix that is mapped 
		// to the imaging device
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Getting NoseInfo for ParentID: " + parentID);
			InitialContext ctx = new InitialContext();
			BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
			bioMightTransforms = bioMightBean.getComponents(Constants.NoseRef, parentID);
			System.out.println("Have Nose Info from EJB");   	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - Nose");
			throw new ServerException("Remote Exception getComponents():", e); 	
		}

	
		ArrayList transforms = bioMightTransforms.getTransforms();
		System.out.println("Have Nose Info NumTransforms: " + transforms.size());
		for (int i=0; i<transforms.size(); i++)
		{
			// Get the information for the Upper Lip we are creating
			BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
			System.out.println("Creating Nose (name,id): " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
			componentID = bioMightTransform.getId();
			
			nasalSeptum = new NasalSeptum(bioMightTransform.getId(), bioMightMethods);
			initProperty("NasalSeptum", Constants.NasalSeptum, Constants.NasalSeptumRef, nasalSeptum.getComponentID());
			System.out.println("NasalSeptum is created");
		
			sellaTunica = new SellaTunica(bioMightTransform.getId(), bioMightMethods);
			initProperty("SellaTunica", Constants.SellaTunica, Constants.SellaTunicaRef, sellaTunica.getComponentID());
			System.out.println("SellaTunica is created");
	
			superiorNasalConcha = new SuperiorNasalConcha(bioMightTransform.getId(), bioMightMethods);
			initProperty("SuperiorNasalConcha", Constants.SuperiorNasalConcha, Constants.SuperiorNasalConchaRef, superiorNasalConcha.getComponentID());
			System.out.println("SuperiorNasalConcha is created");
	
			inferiorNasalConcha = new InferiorNasalConcha(bioMightTransform.getId(), bioMightMethods);
			initProperty("InferiorNasalConcha", Constants.InferiorNasalConcha, Constants.InferiorNasalConchaRef, inferiorNasalConcha.getComponentID());
			System.out.println("InferiorNasalConcha is created");
	
			middleNasalConcha = new MiddleNasalConcha(bioMightTransform.getId(), bioMightMethods);
			initProperty("MiddleNasalConcha", Constants.MiddleNasalConcha, Constants.MiddleNasalConchaRef, middleNasalConcha.getComponentID());
			System.out.println("MiddleNasalConcha is created");
	
			//sphenoidSinus = new SphenoidSinus(bioMightTransform.getId(), bioMightMethods);
			//frontalSinuses = new FrontalSinuses(bioMightTransform.getId(), bioMightMethods);
			
			/*
			ethmoidalCell = new EthmoidalCell();
			*/
			
			epithelium = new EpitheliumTissue("NoseEpithelium", bioMightTransform.getId(), bioMightMethods);
			//initProperty("Nose Epithelium", Constants.Epithelium, Constants.EpitheliumRef, bioMightTransform.getId());
			System.out.println("Nose Epithelium completed");		
		}		

		//initProperties();
		initMethods();
	}

		
	public void initProperties() {
		
		BioMightScale bioScale = new BioMightScale("0.00, 0.00, 0.00");
		BioMightPosition bioPos = new BioMightPosition("0.00, 0.00, 0.00");	
		String bioTemplate =""; 
		
		initProperty("---Not Activated---", Constants.Title, Constants.Title, "ParaThyroidGland:0", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		
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
		method.setMethodName("Twitch");
		method.setHtmlType("checkbox");
		methods.add(method);
	}
	
	
	/***************************************************************************
	 * GENERATE NOSE
	 * 
	 * @param parentID
	 * @param componentID
	 **************************************************************************/
	
	public void generate(String parentID, String componentID)
	{
		// Generate the Nose Edothelium		
		BioMightBeanLocal bioMightBean;
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Generating the Nose: " + componentID + "    " + parentID);
			InitialContext ctx = new InitialContext();
			bioMightBean = (BioMightBeanLocal) ctx.lookup("java:global/BioMightWeb/BioMightBean!biomight.ejb.BioMightBeanLocal");
	
			double circumference = 0.25;
		
			if (componentID.equals("Nose:01")) 
			{	
				// Generate the GreaterCurvature of the stomach
				// Create 5 sections
				double[] startPos = {3.5,-17.5, -1.75};
				double[][] currentPoints = BioGraphics.octogonXPlane(startPos, circumference);

				System.out.println("Calling Generate Nose: " + componentID + "    " + parentID);
				//int success = bioMightBean.generateNose("NoseEpithelium:00001", "NoseEpithelium", 
				//	"NoseEpithelium", componentID, parentID, currentPoints);									
		
			}			
			else if (parentID.equals("")) 
			{	
					
			}

			
			System.out.println("Created NoseEpithelium Info using EJB");   	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - NoseEpithelium");
			throw new ServerException("Remote Exception getComponents():", e); 	
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
		
		// Assemble the Nose
		String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
		"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n " +
		"<X3D profile='Immersive' >\n" +
		"<head>\n" +
		 "<meta name='BioMightImage' content='Nose.jpg'/>\n" +
		 "<meta name='ExportTime' content='7:45:30'/>\n" +
		 "<meta name='ExportDate' content='08/15/2008'/>\n" +
		 "<meta name='BioMight Version' content='1.0'/>\n" + 
		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='Nose'\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		

		String body = epithelium.getX3D(true) + 
		nasalSeptum.getX3D(true) +
		sellaTunica.getX3D(true) +
		superiorNasalConcha.getX3D(true) +
		inferiorNasalConcha.getX3D(true) +
		middleNasalConcha.getX3D(true);
		//sphenoidSinus.getX3D(true) +
		//frontalSinuses.getX3D(true);
		
		//System.out.println("Nose X3D: " + body);		
		String footer = "</Scene>" + "</X3D>\n";
		
		if (snipet)
			return body;			
		else	
			return header + body + footer;
	}
	
	
	
	
	public void setNoseClass(int noseClass)
	{
		if (noseClass == 1)
		{
			// The Roman, or Aquiline nose
		}
		if (noseClass == 2)
		{
			// The Greek or Straight nose
		}
		if (noseClass == 3)
		{
			// The African, or Wide-nostrilled nose
		}
		if (noseClass == 4)
		{
			// The Jewish or Hawk nose
		}
		if (noseClass == 5)
		{
			// The Snub nose
		}
		if (noseClass == 6)
		{
			// The Turn-up or Celestial nos
		}		
	}


	public EthmoidalCell getEthmoidalCell() {
		return ethmoidalCell;
	}


	public void setEthmoidalCell(EthmoidalCell ethmoidalCell) {
		this.ethmoidalCell = ethmoidalCell;
	}


	public FrontalSinuses getFrontalSinuses() {
		return frontalSinuses;
	}


	public void setFrontalSinuses(FrontalSinuses frontalSinuses) {
		this.frontalSinuses = frontalSinuses;
	}


	public InferiorNasalConcha getInferiorNasalConcha() {
		return inferiorNasalConcha;
	}


	public void setInferiorNasalConcha(InferiorNasalConcha inferiorNasalConcha) {
		this.inferiorNasalConcha = inferiorNasalConcha;
	}


	public MiddleNasalConcha getMiddleNasalConcha() {
		return middleNasalConcha;
	}


	public void setMiddleNasalConcha(MiddleNasalConcha middleNasalConcha) {
		this.middleNasalConcha = middleNasalConcha;
	}


	public NasalSeptum getNasalSeptum() {
		return nasalSeptum;
	}


	public void setNasalSeptum(NasalSeptum nasalSeptum) {
		this.nasalSeptum = nasalSeptum;
	}


	public SellaTunica getSellaTunica() {
		return sellaTunica;
	}


	public void setSellaTunica(SellaTunica sellaTunica) {
		this.sellaTunica = sellaTunica;
	}


	public SphenoidSinus getSphenoidSinus() {
		return sphenoidSinus;
	}


	public void setSphenoidSinus(SphenoidSinus sphenoidSinus) {
		this.sphenoidSinus = sphenoidSinus;
	}


	public SuperiorNasalConcha getSuperiorNasalConcha() {
		return superiorNasalConcha;
	}


	public void setSuperiorNasalConcha(SuperiorNasalConcha superiorNasalConcha) {
		this.superiorNasalConcha = superiorNasalConcha;
	}
	
}
