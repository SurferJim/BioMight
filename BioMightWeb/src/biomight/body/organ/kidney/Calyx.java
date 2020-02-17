/*
 * Created on Jul 10, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.body.organ.kidney;
import java.util.ArrayList;

import javax.naming.InitialContext;



import biomight.Constants;
import biomight.body.BodyPart;
import biomight.cell.contractile.PaceMakerCells;
import biomight.ejb.BioMightBeanLocal;
import biomight.exceptions.ServerException;
import biomight.system.tissue.edothelial.EndotheliumTissue;
import biomight.view.BioMightMethodView;
import biomight.view.BioMightPropertyView;

/**
 * @author SurferJim
 *
 * Representation of a Kidney Clayx
 */

public class Calyx extends BodyPart {
	private ArrayList<BioMightPropertyView> properties;
	private ArrayList<BioMightMethodView> methods;
	//private PaceMakerCells paceMakerCells;
	protected EndotheliumTissue endothelium;
	
	
	public Calyx()
	{		
		// Create hte base Calyx
		create(Constants.CalyxRef, null);
	}
	
	
	public Calyx(String parentID)
	{				
		create(parentID, null);	
	}
	

	public Calyx(String parentID, ArrayList<BioMightMethodView> bioMightMethods)
	{				
		create(parentID, bioMightMethods);	
	}

	/************************************************************************************
	 * 
	 * CREATE HIP
	 * @param CalyxReference
	 ***********************************************************************************/
	
	public void create(String parentID, ArrayList<BioMightMethodView> bioMightMethods)
	{		
		this.setImage("images/Calyx.gif");
		setImageWidth(200);
		setImageHeight(150);
		
		viewPerspective = Constants.VIEW_FLOATING;
		if (viewPerspective == Constants.VIEW_FLOATING) {
			
			// If we have initialization parameters from the form, 
			//  then apply them before constructing the objects.
			if (bioMightMethods != null){
				//System.out.println("NEED TO EXECUTE Calyx METHODS: " + bioMightMethods.size());
			}
			
			componentID=parentID;
			
			// Generate the Kidney Epihelium if needed 
			boolean bGenerate = false;
			if (bGenerate) {
				generate(parentID, componentID);
			}
		
			
			System.out.println("Creating Calyx Endothelium: " + parentID);				
			endothelium = new EndotheliumTissue("KidneyEndothelium", parentID, bioMightMethods);
			
			//paceMakerCells = new PaceMakerCells(parentID);				
			System.out.println("Calyx Instance is created : " + parentID);
		} 
		else if (viewPerspective == Constants.VIEW_INTERNAL) {
	
		}

		initProperties();
		initMethods();
	
	}
	
	/****************************************************
	 * GENERATE CALYX
	 * 
	 * 
	 * @param parentID
	 * @param componentID
	 ***************************************************/
	public void generate(String parentID, String componentID)
	{
		// Generate the Palm		
		BioMightBeanLocal bioMightBean;
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Generating the Kidney Epithelium: " + componentID + "    " + parentID);
			InitialContext ctx = new InitialContext();
			bioMightBean = (BioMightBeanLocal) ctx.lookup("java:global/BioMightWeb/BioMightBean!biomight.ejb.BioMightBeanLocal");
	
		
			double circumference = 0.125;
			
			if (componentID.equals("Calyx:1")) {
				
				// Generate the Palm
				double[] startPos = {3.75,-25.0,-6.0};
				
				// Create a equilateral octogon
	    		double x =  startPos[0];
	    		double y =  startPos[1];
	    		double z =  startPos[2];
	
	    		double[][] currentPoints = { 
	    		 		{x, y, z},
	    		 		{x-circumference,     y, z-circumference},
	    		   		{x-circumference,     y, z-circumference*2},
	    		   		{x,                   y, z-circumference*3},
	    		   		{x+circumference,     y, z-circumference*3},
	    		   		{x+(circumference*2), y, z-circumference*2},
	    		   		{x+(circumference*2),     y, z-circumference},
	    		   		{x+circumference, y, z}
	    		   		};
					
				
				//int success = bioMightBean.generateKidney("KidneyEpithelium:00001", "KidneyEpithelium", 
				//		"KidneyEpithelium", componentID, parentID, currentPoints);			
				
			}
			else if (componentID.equals("Calyx:2"))
			{
				// Generate the Elbow
				double[] startPos = {-3.75,-25.0,-6.0};
				
				// Create a equilateral octogon
	    		double x =  startPos[0];
	    		double y =  startPos[1];
	    		double z =  startPos[2];
	    		 
	    		double[][] currentPoints = { 
	    		 		{x, y, z},
	    		 		{x-circumference,     y, z-circumference},
	    		   		{x-circumference,     y, z-circumference*2},
	    		   		{x,                   y, z-circumference*3},
	    		   		{x+circumference,     y, z-circumference*3},
	    		   		{x+(circumference*2), y, z-circumference*2},
	    		   		{x+(circumference*2),     y, z-circumference},
	    		   		{x+circumference, y, z}
	    		   		};
				
				
				//int success = bioMightBean.generateKidney("KidneyEpithelium:00160", "KidneyEpithelium", 
				//	"KidneyEpithelium",  componentID, parentID, currentPoints);			
			}
			else if (parentID.equals("")) 
			{	
				System.out.println("Calling Generate KidneyEpithelium NoParent");		
			}

			
			System.out.println("Created KidneyEpithelium Info using EJB");   	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - KidneyEpithelium");
			throw new ServerException("Remote Exception KidneyEpithelium():", e); 	
		}
	}
	
	
	public void initProperties() {

		properties = new ArrayList<BioMightPropertyView>();
		
		BioMightPropertyView property = new BioMightPropertyView();
		property.setPropertyName("Acetabulum");
		property.setCanonicalName(Constants.Acetabulum);
		properties.add(property);			
	}
	
	
	public void initMethods() {

		methods = new ArrayList<BioMightMethodView>();
		
		BioMightMethodView method = new BioMightMethodView();

		method = new BioMightMethodView();
		method.setMethodName("Crack");
		method.setHtmlType("checkbox");
		methods.add(method);	
		
		method = new BioMightMethodView();
		method.setMethodName("Gyrate");
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
		
		// Assemble the Calyx
		String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
		"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n " +
		"<X3D profile='Immersive' >\n" +
		"<head>\n" +
		 "<meta name='BioMightImage' content='Calyx.jpg'/>\n" +
		 "<meta name='ExportTime' content='7:45:30'/>\n" +
		 "<meta name='ExportDate' content='08/15/2008'/>\n" +
		 "<meta name='BioMight Version' content='1.0'/>\n" + 
		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='Calyx'\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		

		
		
		
		
		String body = endothelium.getX3D(true);  
		//System.out.println("Calyx X3D: " + body);		
		
		String footer = "</Scene>" + "</X3D>\n";
		
		if (snipet)
			return body;			
		else	
			return header + body + footer;
	}
	


}
