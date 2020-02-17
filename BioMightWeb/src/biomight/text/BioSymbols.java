/*
 * Created on Apr 26, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.text;
import java.util.ArrayList;
import java.util.Properties;

import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;
import javax.naming.InitialContext;

import biomight.BioMightBase;
import biomight.Constants;
import biomight.ejb.BioMightBeanLocal;
import biomight.view.BioMightMethodView;
import biomight.view.BioMightPosition;
import biomight.view.BioMightPropertyView;
import biomight.view.BioMightScale;
import biomight.view.BioMightTransform;


/**********************************************************************************************
 * @author SurferJim
 *
 * Represntation of a BioSymbol Collection.   As this is a small collection (at the moment)
 * We will grab the real instances of the object.   We do not need a psudeo-layer over the
 * top-as-yet
 * 
 *********************************************************************************************/

public class BioSymbols extends BioMightBase {
	private ArrayList colors;
	private BioTexts bioTexts;
	private BioArrows bioArrows;
	private BioMightPosition bioMightPosition;
	
	/************************************************************************
	 * BioSymbols Constructor 
	 *
	 ***********************************************************************/
	public BioSymbols()
	{
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, Constants.BioSymbolsRef, null, null);
	}

	/************************************************************************
	 * BioSymbols Constructor 
	 *
	 ***********************************************************************/
	public BioSymbols(String parentID)
	{
		System.out.print("Calling parameterized BioSymbols Constructor!");
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, parentID, null, null);
	}
	
	
	/************************************************************************
	 * BioSymbols Constructor 
	 *
	 ***********************************************************************/
	public BioSymbols(int hierarchy, int LOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
	{
		System.out.println("Calling BioSymbols with LOD!");
		create(hierarchy, LOD, parentID, bioMightProperties, bioMightMethods);
	}
	
	
	/************************************************************************
	 * Create BioSymbols
	 *
	 ***********************************************************************/

	public void create(int hierarchy, int LOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
	{
		this.setImage("images/BioSymbol.jpg");
		this.setImageHeight(300);
		this.setImageWidth(300);

		int localVP = Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		
		System.out.println("Creating BioSymbol for: " + parentID);
		
		// Get the data for the BioSymbol that is defined for this 
		// BioSymbol reference
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Getting BioSymbolsInfo for ParentID: " + parentID);
			InitialContext ctx = new InitialContext();
			BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
			bioMightTransforms = bioMightBean.getComponents(Constants.BioSymbolsRef, parentID);
			System.out.println("Have BioSymbols Info from EJB");   	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - BioSymbols");
			//throw new ServerException("Remote Exception getComponents():", e); 	
		}

		// If we have initialization parameters from the form, 
		//  then apply them before constructing the objects.
		if (bioMightMethods != null){
			System.out.println("NEED TO EXECUTE CELLs METHODS: " + bioMightMethods.size());
			//executeMethods(bioMightMethods);
		}

		// Create a properties list for the client to use for interaction
		properties = new ArrayList<BioMightPropertyView>();
		
		// Run through the collection of Bodys and build them into the model
		// In the default case, we get one instance of the Body for each eye
		ArrayList transforms = bioMightTransforms.getTransforms();
		System.out.println("Have BioSymbols, NumTransforms: " + transforms.size());


		//String dimensions = "0.00, 0.00, 0.00";
		//String bioPos = "0.00, 0.00, 0.00";
		BioMightScale bioScale = new BioMightScale("0.00, 0.00, 0.00");
		BioMightPosition bioPos = new BioMightPosition("0.00, 0.00, 0.00");

		String bioTemplate="BioSymbol.x3d";
				
		for (int i=0; i<transforms.size(); i++)
		{
			// Get the information for the eye we are creating
			BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
	
			componentID = bioMightTransform.getId();
			
			System.out.println("Creating BioSymbols: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
		
			System.out.println("In BioSymbols - Creating BioTexts");
			bioTexts = new BioTexts(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
			System.out.println("In BioSymbols - BioTexts are complete");
			initProperty("BioTexts", Constants.BioTexts, Constants.BioTextsRef, bioTexts.getComponentID(), bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);

			System.out.println("In BioSymbols - Creating BioArrows");
			bioArrows = new BioArrows(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
			System.out.println("In BioSymbols - BioArrows are complete");
			initProperty("BioArrows", Constants.BioArrows, Constants.BioArrowsRef, bioArrows.getComponentID(), bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);

			}
		
		//System.out.println("Init Properties");	
		//initProperties();
		System.out.println("Init Methods");
		initMethods();
		System.out.println("Created BioSymbol");				
	}
	

	public void initProperties() {
		
		BioMightPropertyView property;

		property = new BioMightPropertyView();
		property.setPropertyName("Text");
		property.setCanonicalName(Constants.BioText);
		properties.add(property);
		
	}
	

	public void initMethods() {

		methods = new ArrayList<BioMightMethodView>();
			
		BioMightMethodView method;
		methods = new ArrayList<BioMightMethodView>();
		method = new BioMightMethodView();
		
		method.setDisplayName("Metabolize");
		method.setMethodName("Metabolize");
		method.setHtmlType("checkbox");
		method.setDataType("boolean");
		methods.add(method);		
	}
	
	

	/********************************************************************************************************************
	 * GET X3D
	 * 
	 * This method will return the X3D for the BioSymbols.  It runs through each of its components and collects up their
	 * representations and then assembles them into one unified X3D model.
	 * 
	 ********************************************************************************************************************/
	public String getX3D(boolean snipet) {
		
		// Assemble the BioSymbols
		String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
		"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n " +
		"<X3D profile='Immersive' >\n" +
		"<head>\n" +
		 "<meta name='BioMightImage' content='BioSymbols.jpg'/>\n" +
		 "<meta name='ExportTime' content='7:45:30'/>\n" +
		 "<meta name='ExportDate' content='08/15/2008'/>\n" +
		 "<meta name='BioMight Version' content='1.0'/>\n" + 
		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='BioSymbols'\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		
		
		String body = 
				bioTexts.getX3D(true) +
				bioArrows.getX3D(true);
		
		String footer = "</Scene>" + "</X3D>\n";
			
		if (snipet)
			return body;			
		else	
			return header + body + footer;
	}

	

}
