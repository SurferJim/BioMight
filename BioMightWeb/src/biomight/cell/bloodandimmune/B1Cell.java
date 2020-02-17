/*
 * Created on Nov 12, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.cell.bloodandimmune;
import java.util.ArrayList;

import javax.naming.InitialContext;

import biomight.BioMightBase;
import biomight.Constants;
import biomight.chemistry.protein.immunity.CD5Protein;
import biomight.chemistry.protein.immunity.CD72Protein;
import biomight.ejb.BioMightBeanLocal;
import biomight.exceptions.ServerException;
import biomight.view.BioMightMethodView;
import biomight.view.BioMightPosition;
import biomight.view.BioMightPropertyView;
import biomight.view.BioMightTransform;
import biomight.view.BioMightTransforms;

/************************************************************************************
 * @author SurferJim
 *
 * Representation of a B1 Cell. 
 * 
 ************************************************************************************/

public class B1Cell extends BioMightBase {
	private BioMightPosition bioMightPosition;	
	private CD5Protein cd5Protein;
	private CD72Protein cd72Protein;
	
			
	public B1Cell()
	{		
		int localVP= Constants.BIO_CHILD;
		int localLOD = Constants.VIEW_HAWKEYE;
		create(localVP, localLOD, Constants.CellsRef, null, null);
	}
	
	/********************************************************************************************************************
	 *  B1Cell
	 * 
	 * This method will instantiate the B1Cell that are defined for the current model.  
	 * 
	 ********************************************************************************************************************/

	public B1Cell(String parentID)
	{				
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, parentID, null, null);
	}
	
	public B1Cell(int localVP, int localLOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
	{		
		create(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);
	}
	
	
	/********************************************************************************************************************
	 * CREATE B1Cell
	 * 
	 * This method will instantiate the BCELL that are defined for the current model.  
	 * 
	 ********************************************************************************************************************/

	private void create(int localVP, int localLOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods) 
	{
		this.setImage("images/B1Cell.jpg");
		this.setImageHeight(300);
		this.setImageWidth(300);
		this.parentID = parentID;
		
		// Get the information from the database via the Enterprise Bean		
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Getting B1CellInfo for ParentID: " + parentID);
			InitialContext ctx = new InitialContext();
			BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
			bioMightTransforms = bioMightBean.getComponents(Constants.B1CellRef, parentID);
			System.out.println("Have B1Cell Info from EJB");   	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - B1Cell");
			throw new ServerException("Remote Exception getComponents():", e); 	
		}
			
		// Run through the collection of B1Cells and build them into the model
		// In the default case, we get one instance of the B1Cell for each eye
		ArrayList transforms = bioMightTransforms.getTransforms();
		System.out.println("B1Cell NumTransforms: " + transforms.size());
		for (int i=0; i<transforms.size(); i++)
		{
			// Get the information for the eye we are creating
			BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
			System.out.println("Creating B1Cell: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
			this.componentID = bioMightTransform.getId();
			
			/*int viewPerspective = Constants.VIEW_DETACHED;
			if (viewPerspective == Constants.VIEW_DETACHED)
			{				
				// Create an instance of the Eye for each tranform specified for the organism
				System.out.println("Creating Eyes using ParentID: " + bioMightTransform.getId());
				eye = new Eye(bioMightTransform.getId());
				System.out.println("Eyes are created");
			}*/
		}
		initProperties();
		initMethods();
		
		System.out.println("CreateB1Cell Completed");
		
		// First, get all the data from the database
		// Apply the methods to it
		// Save its state
		this.parentID = parentID;
		if (bioMightMethods != null){
			System.out.println("EXECUTING PUPIL METHODS: " + bioMightMethods.size());
			//executeMethods(bioMightMethods);
		}
	}
			
			
			


	private void initProperties() {

		properties = new ArrayList<BioMightPropertyView>();
		
		BioMightPropertyView property = new BioMightPropertyView();
		property.setPropertyName("B1Cell");
		property.setCanonicalName(Constants.B1Cell);
		properties.add(property);
	}
	

	private void initMethods() {

		methods = new ArrayList<BioMightMethodView>();	
		
		BioMightMethodView method = new BioMightMethodView();
		method.setMethodName("Set Membrane Width");
		method.setHtmlType("text");
		methods.add(method);

		method = new BioMightMethodView();
		method.setMethodName("Set Volumme");
		method.setHtmlType("text");
		methods.add(method);
	}


	public ArrayList getProperties() {
		return properties;
	}
	

	public ArrayList getMethods() {		
		return methods;
	}
	
	/******************************************************************************************
	 * EXECUTE METHODS 
	 *
	 ******************************************************************************************/
	public void executeMethods(ArrayList<String> methodParams) {

		// Run through the argument list and execute the 
		// associated methods
		System.out.println("B1Cell Executing Methods");
		for (int j=0; j<methodParams.size(); j++){
			
			// Get the parameter from the list and if it is not
			// empty execute the associated method using it
			String methodParam = methodParams.get(j);
			if (methodParam != null) {
				if (!methodParam.equals("")) {
					//String methodName = (String) methods.get[j]; 
					//System.out.println("Applying " + methods.get(j) + " with arg: "  +  methodParam);
				}
			}
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
		
		// Assembe the B1Cell
		String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
		"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n " +
		"<X3D profile='Immersive' >\n" +
		"<head>\n" +
		 "<meta name='BioMightImage' content='B1Cell.jpg'/>\n" +
		 "<meta name='ExportTime' content='7:45:30'/>\n" +
		 "<meta name='ExportDate' content='08/15/2008'/>\n" +
		 "<meta name='BioMight Version' content='1.0'/>\n" + 
		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='B1Cell'\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		

		String body = "";
		String annotate = "";
		
		// Run through the collection of B1Cells and build them into the model
		// In the default case, we get one instance of the B1Cell for each eye
		ArrayList transforms = bioMightTransforms.getTransforms();
		for (int i=0; i<transforms.size(); i++)
		{
			// Get the information for the capsomer we are creating
			BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
			System.out.println("Creating B1Cell: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
			System.out.println("Creating B1Cell at Position: " + 
					bioMightTransform.getTranslation().getXPos() + "  " +
					bioMightTransform.getTranslation().getYPos() + "  " +
					bioMightTransform.getTranslation().getZPos());
			

			int view = Constants.VIEW_FLOATING;

			if (view == Constants.VIEW_FLOATING)
			{
				//System.out.println("Getting X3D for B1CellX: " + bioMightTransform.getTranslation().getXPos());
				//System.out.println("Getting X3D for B1CellY: " + bioMightTransform.getTranslation().getYPos());
				//System.out.println("Getting X3D for B1CellZ: " + bioMightTransform.getTranslation().getZPos());
				// Change the height and width based on the displacement.
				body += "<Transform DEF='B1Cell'\n";
				
				// Set the position if we are working with the Tissue collection
				if (parentID.equals("1.10000:0"))
				{
					body += "translation='" 
						+ bioMightPosition.getXPos() + " " 
			 			+ bioMightPosition.getYPos() + " "
			 			+ bioMightPosition.getZPos() + "'\n";
				}
				else
				{
			 		body += "translation='" 
			 			+ bioMightTransform.getTranslation().getXPos() + " " 
 						+ bioMightTransform.getTranslation().getYPos() + " "
 						+ bioMightTransform.getTranslation().getZPos() + "'\n";					
				}

				
				 body += "scale='" 	+ bioMightTransform.getScale().getXPos() + " "
				 				+ bioMightTransform.getScale().getYPos() + " "
				 				+ bioMightTransform.getScale().getZPos() + "'>\n" +
				 	"<Shape DEF='B1Cell'\n" +
				    " containerField='children'>\n" +
				    " <Appearance\n" +
				    "  containerField='appearance'>\n";
				    
			
				  body+= " <ImageTexture containerField='texture' " +
				  " url='../images/B1Cell.jpg'/>";
				
				    
				body+= " <Material DEF='Rust'\n" +
				    "containerField='material'\n" +
				    "ambientIntensity='" 	+ bioMightTransform.getMaterial().getAmbientIntensity() + "'\n" +
				    "shininess='" 			+ bioMightTransform.getMaterial().getShininess() + "'\n" +
				    "transparency='" 		+ bioMightTransform.getMaterial().getTransparency() + "'\n" +
				    "diffuseColor='" + 
				 	    bioMightTransform.getMaterial().getDiffuseColor().getRed() + " " + 
				 	    bioMightTransform.getMaterial().getDiffuseColor().getGreen() + " " +
				 	    bioMightTransform.getMaterial().getDiffuseColor().getBlue() + "'/>\n" +
				 	"</Appearance>\n" +
				 	"<Sphere DEF='B1CellGeoSphere'\n" +
				 	"containerField='geometry'\n" +
				 	"radius='" + bioMightTransform.getRadius() +"'/>\n" +
				 	"</Shape>\n" +
				 	
					"<TouchSensor DEF='StartMuscle' \n" +
	                   " description='B1 Cell'\n" +
		               " containerField='children'/> \n" +
				 	
				 "</Transform>\n";
				
						
			}
			else
			{
				body = "";//						
			}
		
	}
		
		//System.out.println("B1Cell X3D: " + body);		
		String footer = "</Scene>" + "</X3D>\n";
		
		if (snipet)
			return body + annotate;			
		else	
			return header + body + annotate + footer;				
	}


	public String getComponentID() {
		return componentID;
	}


	public void setComponentID(String componentID) {
		this.componentID = componentID;
	}


	public String getParentID() {
		return parentID;
	}


	public void setParentID(String parentID) {
		this.parentID = parentID;
	}


	public void setMethods(ArrayList<BioMightMethodView> methods) {
		this.methods = methods;
	}


	public void setProperties(ArrayList<BioMightPropertyView> properties) {
		this.properties = properties;
	}
	

}
