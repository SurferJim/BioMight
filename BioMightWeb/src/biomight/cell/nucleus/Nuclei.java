/*
 * Created on Nov 11, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.cell.nucleus;
import java.lang.reflect.Method;
import java.util.ArrayList;

import javax.naming.InitialContext;

import biomight.BioMightBase;
import biomight.Constants;
import biomight.ejb.BioMightBeanLocal;
import biomight.ejb.BioMightCellularBeanLocal;
import biomight.exceptions.ServerException;
import biomight.view.BioMightMethodView;
import biomight.view.BioMightPosition;
import biomight.view.BioMightPropertyView;
import biomight.view.BioMightTransform;


/***************************************************************************************
 * @author SurferJim
 *
 * Nuclei
 * 
 * Creates a collection of Nuclei that are scattered throughout the cell
 * using a random distribution pattern.
 * 
 **************************************************************************************/


public class Nuclei  extends BioMightBase{
	private BioMightPosition bioMightPosition;
	private ArrayList<Nucleus> nuclei;	
	
	
	
	/********************************************************************************************************************
	 *  Nuclei
	 * 
	 * This method will instantiate the Nuclei that are defined for the current model.  
	 * 
	 ********************************************************************************************************************/

	public Nuclei()
	{		
		int localVP= Constants.BIO_CHILD;
		int localLOD = Constants.VIEW_HAWKEYE;
		create(localVP, localLOD, Constants.CellsRef, null, null);
	}
	
	/********************************************************************************************************************
	 *  Nuclei
	 * 
	 * This method will instantiate the Nuclei that are defined for the current model.  
	 * 
	 ********************************************************************************************************************/

	public Nuclei(String parentID)
	{				
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, parentID, null, null);
	}

	public Nuclei(String parentID, ArrayList<BioMightMethodView> bioMightMethods)
	{	
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, parentID, null, bioMightMethods);
	}
	
	public Nuclei(int localVP, int localLOD, String parentID, ArrayList<BioMightMethodView> bioMightMethods)
	{		
		create(localVP, localLOD, parentID, null, bioMightMethods);
	}

	public Nuclei(int localVP, int localLOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
	{		
		create(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);
	}
	
	/********************************************************************************************************************
	 * CREATE Nuclei
	 * 
	 * This method will instantiate the hips that are defined for the current model.  
	 * 
	 ********************************************************************************************************************/

	private void create(int localVP, int localLOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods) 
	{ 
		this.setImage("images/Nuclei.jpg");
		
		nuclei = new ArrayList();
	
		// This is a collection, so set the parent of the children
		// to that of the aggregation object
		this.parentID=parentID;
		this.componentID = parentID;
		this.lod = localLOD;
		this.viewPerspective = localVP;
		
		
		if (bioMightMethods != null){
			System.out.println("EXECUTING Nuclei Methods: " + bioMightMethods.size());
			executeMethods(bioMightMethods);
		}
		
		// Get the information from the database via the Enterprise Bean.  This will get
		// a collection of Nuclei
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Getting Nuclei Transform: " + componentID + "   " +  parentID);
			InitialContext ctx = new InitialContext();
			BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
			bioMightTransforms = bioMightBean.getComponents(Constants.NucleusRef, parentID);   	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - Nuclei");
			throw new ServerException("Remote Exception getComponents():", e); 	
		}
				
		// Run through the collection of Nuclei and build them into the model
		ArrayList transforms = bioMightTransforms.getTransforms();
		System.out.println("Have Nuclei NumTransforms: " + transforms.size());
		
		// If we are culling the data set
		int numRetreive=transforms.size();
		//if (parentID.equals("Cells"))
		
		for (int i=0; i<transforms.size(); i++)
		{
			// Get the information for the Nucleus we are creating
			BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
			System.out.println("Creating Nucleus: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
			
			// Create an instance of a Nucleus for each tranform specified
			localVP = Constants.VIEW_INTERNAL;
			localLOD = Constants.MAG1X;
			Nucleus nucleus = new Nucleus(localVP, localLOD, bioMightTransform.getId(), bioMightMethods);		
			System.out.println("Nucleus Created!: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
			nuclei.add(nucleus);
			System.out.println("Add Nucleus to Collection!: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());

			// initialize the Properties
			// in this case, rather than pass canonical name, we pass the name found in the collectio
			initProperty(bioMightTransform.getName(), Constants.Nucleus, Constants.NucleusRef, bioMightTransform.getId());				
			//initProperty(bioMightTransform.getName(), Constants.Nucleus, Constants.NucleusRef, parentID);
			
			int numElements = 50;
			if (i == numElements)
				break;
		}

		// Set up methods that will be available to the Nuclei
		initMethods();
	}
	
	
	public void initMethods() {
			
		BioMightMethodView method = new BioMightMethodView();
		method.setCanonicalName(Constants.Nuclei);
		method.setMethodName("setColonySize");
		method.setDisplayName("Colony Size:");
		method.setHtmlType("text");
		method.setDataType(Constants.BIO_INT);
		methods.add(method);

	}
	
	
	/********************************************************************************************************************
	 * GET X3D
	 * 
	 * This method will return the X3D for the Nuclei.  It runs through each of its components and collects up their
	 * representations and then assembles them into one unified X3D model.
	 * 
	 ********************************************************************************************************************/
	public String getX3D(boolean snipet) {
		
		// Assemble the Nuclei
		String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
		"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n " +
		"<X3D profile='Immersive' >\n" +
		"<head>\n" +
		 "<meta name='BioMightImage' content='Hips.jpg'/>\n" +
		 "<meta name='ExportTime' content='7:45:30'/>\n" +
		 "<meta name='ExportDate' content='08/15/2008'/>\n" +
		 "<meta name='BioMight Version' content='1.0'/>\n" + 
		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='Nuclei'\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		

		String body = ""; 
		System.out.println("Assembling X3D for Nuclei - size: " + nuclei.size());

		// Grab the information from what we already retreived from the database
		// Another method  would be to pass that transform object down to the
		// child object, or have it re-retrieve from the database
		viewPerspective = Constants.VIEW_INTERNAL;
		if (viewPerspective == Constants.VIEW_INTERNAL)			
		{	
			ArrayList transforms = bioMightTransforms.getTransforms();
			for (int i=0; i<transforms.size(); i++)
			{
				// Get the information for the capsomer we are creating
				BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
				System.out.println("Getting X3D Internal for Nucleus: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());				

				 body+= "<Group>";

				
				//System.out.println("Getting X3D for NucleusX: " + bioMightTransform.getTranslation().getXPos());
				//System.out.println("Getting X3D for NucleusY: " + bioMightTransform.getTranslation().getYPos());
				//System.out.println("Getting X3D for NucleusZ: " + bioMightTransform.getTranslation().getZPos());
				// Change the height and width based on the displacement.
	
					body += "\n<Transform DEF='def"+ bioMightTransform.getId() +"'\n" +
							"translation='" + bioMightTransform.getTranslation().getXPos() + " " 
							+ bioMightTransform.getTranslation().getYPos() + " "
							+ bioMightTransform.getTranslation().getZPos() + "'\n" +
					 	"scale='" 	+ bioMightTransform.getScale().getXPos() + " "
					 				+ bioMightTransform.getScale().getYPos() + " "
					 				+ bioMightTransform.getScale().getZPos() + "'>\n" +
						 	"\n<Shape onmouseover=\"showComponent('Nucleur Envelope');\" DEF='shape"+ bioMightTransform.getId() + "'\n" +
						    " containerField='children'>\n" +
						    " <Appearance\n" +
						    "  containerField='appearance'>\n" +
						    
							" <ImageTexture containerField='texture' " +
							    " url='../images/SpeckledEmerald.png'/>"+
						    
						    " <Material DEF='Rust'\n" +
						    "containerField='material'\n" +
						    "ambientIntensity='" 	+ bioMightTransform.getMaterial().getAmbientIntensity() + "'\n" +
						    "shininess='" 			+ bioMightTransform.getMaterial().getShininess() + "'\n" +
						    "transparency='" 		+ bioMightTransform.getMaterial().getTransparency() + "'\n" +
						    "diffuseColor='" + 
						    bioMightTransform.getMaterial().getDiffuseColor().getRed() + " " + 
						    bioMightTransform.getMaterial().getDiffuseColor().getGreen() + " " +
						    bioMightTransform.getMaterial().getDiffuseColor().getBlue() + "'/>\n" +
						 	"</Appearance>\n" +
						 	"<Sphere DEF='" + bioMightTransform.getId() + "Sphere'\n" +
						 	"containerField='geometry'\n" +
						 	"radius='" + (bioMightTransform.getRadius() + 0.01) + "'/>\n" +
						 	"</Shape>\n" +
						 	
							"\n<TouchSensor DEF='"+bioMightTransform.getId()+"' \n" +
			                   " description='Nucleus'\n" +
				               " containerField='children'/> \n" +
	   
					 	"</Transform>\n"; 
						

						
						body += "\n<Transform DEF='def"+ bioMightTransform.getId() +"'\n" +
								"translation='" + bioMightTransform.getTranslation().getXPos() + " " 
								+ bioMightTransform.getTranslation().getYPos() + " "
								+ bioMightTransform.getTranslation().getZPos() + "'\n" +
						 	"scale='" 	+ bioMightTransform.getScale().getXPos() + " "
						 				+ bioMightTransform.getScale().getYPos() + " "
						 				+ bioMightTransform.getScale().getZPos() + "'>\n" +
							 	"\n<Shape onmouseover=\"showComponent('Nucleus');\" DEF='shape"+ bioMightTransform.getId() + "'\n" +
							    " containerField='children'>\n" +
							    " <Appearance\n" +
							    "  containerField='appearance'>\n" +
							    
								" <ImageTexture containerField='texture' " +
								    " url='../images/SpeckledSlateBlue.png'/>"+
							    
							    " <Material DEF='Rust'\n" +
							    "containerField='material'\n" +
							    "ambientIntensity='" 	+ bioMightTransform.getMaterial().getAmbientIntensity() + "'\n" +
							    "shininess='" 			+ bioMightTransform.getMaterial().getShininess() + "'\n" +
							    "transparency='" 		+ bioMightTransform.getMaterial().getTransparency() + "'\n" +
							    "diffuseColor='" + 
							    bioMightTransform.getMaterial().getDiffuseColor().getRed() + " " + 
							    bioMightTransform.getMaterial().getDiffuseColor().getGreen() + " " +
							    bioMightTransform.getMaterial().getDiffuseColor().getBlue() + "'/>\n" +
							 	"</Appearance>\n" +
							 	"<Sphere DEF='" + bioMightTransform.getId() + "Sphere'\n" +
							 	"containerField='geometry'\n" +
							 	"radius='" + (bioMightTransform.getRadius() - 0.02) + "'/>\n" +
							 	"</Shape>\n" +
							 	
								"\n<TouchSensor DEF='"+bioMightTransform.getId()+"' \n" +
				                   " description='Nucleus'\n" +
					               " containerField='children'/> \n" +
		   
						 	"</Transform>\n"; 
						
						body += "\n<Transform DEF='def"+ bioMightTransform.getId() +"'\n" +
								"translation='" + bioMightTransform.getTranslation().getXPos() + " " 
								+ (bioMightTransform.getTranslation().getYPos() + 0.02) + " "
								+ bioMightTransform.getTranslation().getZPos() + "'\n" +
						 	"scale='" 	+ bioMightTransform.getScale().getXPos() + " "
						 				+ bioMightTransform.getScale().getYPos() + " "
						 				+ bioMightTransform.getScale().getZPos() + "'>\n" +
							 	"\n<Shape onmouseover=\"showComponent('Nucleolus');\" DEF='shape"+ bioMightTransform.getId() + "'\n" +
							    " containerField='children'>\n" +
							    " <Appearance\n" +
							    "  containerField='appearance'>\n" +
							    
								" <ImageTexture containerField='texture' " +
								    " url='../images/Nucleus.png'/>"+
							    
							    " <Material DEF='Rust'\n" +
							    "containerField='material'\n" +
							    "ambientIntensity='" 	+ bioMightTransform.getMaterial().getAmbientIntensity() + "'\n" +
							    "shininess='" 			+ bioMightTransform.getMaterial().getShininess() + "'\n" +
							    "transparency='" 		+ bioMightTransform.getMaterial().getTransparency() + "'\n" +
							    "diffuseColor='" + 
							    bioMightTransform.getMaterial().getDiffuseColor().getRed() + " " + 
							    bioMightTransform.getMaterial().getDiffuseColor().getGreen() + " " +
							    bioMightTransform.getMaterial().getDiffuseColor().getBlue() + "'/>\n" +
							 	"</Appearance>\n" +
							 	"<Sphere DEF='" + bioMightTransform.getId() + "Sphere'\n" +
							 	"containerField='geometry'\n" +
							 	"radius='" + (bioMightTransform.getRadius()/5) + "'/>\n" +
							 	"</Shape>\n" +
							 	
								"\n<TouchSensor DEF='"+bioMightTransform.getId()+"' \n" +
				                   " description='Nucleus'\n" +
					               " containerField='children'/> \n" +
		   
						 	"</Transform>\n"
				 + "</Group>";
						
			}
		}			
		else
		{
			// Run through the collection of Nuclei and assemble the X3D for each
			for (int i=0; i<nuclei.size(); i++)
			{
				// Get the information for the Nuclei
				Nucleus nucleus = (Nucleus) nuclei.get(i);
				System.out.println("Getting X3D for Nucleus: " + nucleus.getComponentID());
				body += nucleus.getX3D(true);
			}		
		
		}
		
		
		body+= "<Viewpoint DEF='Viewpoint_Nuclei'\n" +
				 "description='Viewpoint_Nuclei'\n" +
				 "jump='true'\n" +
				 "fieldOfView='0.785'\n" +
				 "position='0.0 0.0 5.0'\n" +
				 "orientation='0 0 1 0'/>\n";
		
		
		//System.out.println("Nuclei X3D: " + body);		
		String footer = "</Scene>" + "</X3D>\n";
		
		if (snipet)
			return body;			
		else	
			return header + body + footer;
	}


	/******************************************************************************************
	 * EXECUTE METHODS 
	 *
	 ******************************************************************************************/
	public void executeMethods(ArrayList<BioMightMethodView> bioMightMethods) {

		// Run through the argument list and executes the 
		// associated methods
		boolean fired = false;
		System.out.println("Nuclei-Executing Methods: " + bioMightMethods.size());
		for (int j=0; j<bioMightMethods.size(); j++){
			
			// Get the parameter from the list and if it is not
			// empty execute the associated method using it
			BioMightMethodView bioMightMethod = (BioMightMethodView) bioMightMethods.get(j);
			System.out.println("Have BioMightMethod for Nuclei: " + bioMightMethod.getMethodName());	
			String methodName = bioMightMethod.getMethodName();
			String canonicalName = bioMightMethod.getCanonicalName(); 
			String dataType = bioMightMethod.getDataType();
			String methodParam = bioMightMethod.getMethodParameter(); 
			if (methodParam == null)
				methodParam = "";
			
			// We only execute those methods that are targeted for the IRIS
			// If a parameter is specified then we fire the method, otherwise
			// we just jump over it
			if (canonicalName.equals(Constants.Nuclei)) {				
				if (!methodParam.equals(""))
				{
					System.out.println("Execute Method " + methodName + " with Signature: "  +  dataType);
					System.out.println("with DataType: "  +  dataType  + "   value: " + methodParam);
					
					fired=true;		
					// Use the DataType parameter to convert the data into its base form
				
					if (dataType.equals("int")) {
						
						try {
							System.out.println("Locating Method(Integer)" + methodName);
							// 	Locate the method through introspection
							int numElements = Integer.parseInt(methodParam);
							Class paramsType[] = {int.class};
							Method method = this.getClass().getDeclaredMethod(methodName, paramsType);
							System.out.println("Before Execute Method(Integer)" + methodName);
							Object result = method.invoke(this, numElements);
							System.out.println("After Execute Method(Integer)" + methodName);	
						}
						catch (NumberFormatException e)
						{
							System.out.println("Could not Convert to int: " + methodParam);						
						}
						catch (NoSuchMethodException e)
						{
							System.out.println("Method with int param not found: " + e);						
						}	
						catch (Exception e)
						{
							System.out.println("General Exception occurred: " + e);						
						}										
					}
					else if (dataType.equals("double")) {
					
						try {
							System.out.println("Locating Method(Double)" + methodName);
							// Locate the method through introspection
							double numElements = Double.parseDouble(methodParam);
							if (numElements > 0.0)
							{
								Class paramsType[] = {double.class};
								Method method = this.getClass().getDeclaredMethod(methodName, paramsType);
								System.out.println("Before Execute Method(Double)" + methodName);
								Object result = method.invoke(this, numElements);
								System.out.println("After Execute Method(Double)" + methodName);
							}
							else
								System.out.println("Not Executing Double - 0.0"); 
							}
							catch (NumberFormatException e)
							{
								System.out.println("Could not Convert to double: " + methodParam);						
							}
							catch (NoSuchMethodException e)
							{
								System.out.println("Method with double param not found: " + e);						
							}	
							catch (Exception e)
							{
								System.out.println("General Exception: " + e);						
							}										
					}
					else if (dataType.equals("String")) {
						
						
						try {
							System.out.println("Locating Method(String)");
							
							Class paramsType[] = {String.class};
							Method method = this.getClass().getDeclaredMethod(methodName, paramsType );
							System.out.println("Method with String Param: " + methodName);
							
							System.out.println("Before Execute Method(String)" + methodName);
							Object result = method.invoke(this, methodParam);
							System.out.println("After Execute Method(String)" + methodName);
									
						}
						catch (NoSuchMethodException e)
						{
							System.out.println("Method with String param not found!");						
						}	
						catch (Exception e)
						{
							System.out.println("General Exception: " + e);						
						}	
						
					}
					else if (dataType.equals("")) {
						System.out.println("Data Type not found!!!");	
					}	
				}	
			}
			if (fired)
			{	
				System.out.println("Nuclei - Methods have fired.   Calling Nuclei Save method!");
			}
		}
	}

	

	/******************************************************************************************
	 * SET COLONY SIZE 
	 *
	 * This method will set the Colony size for the Nuclei.  
	 *****************************************************************************************/
	public void setColonySize(int size) {

		// Run through the argument list and executes the 
		// associated methods
		boolean fired = false;
		System.out.println("Nuclei-SetColony Size: " + size);
		
		// Generate the Nucleus		
		BioMightCellularBeanLocal bioMightBean;
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Generating the Nucleus Colony: " + componentID + "    " + parentID);
			InitialContext ctx = new InitialContext();
			bioMightBean = (BioMightCellularBeanLocal) ctx.lookup("java:global/BioMightWeb/BioMightCellularBean!biomight.ejb.BioMightCellularBeanLocal");
			
		    		 					
			double currentPoints[][] = null;
			//int success = bioMightBean.generateEndosomes(size, "Nucleus:00001", "Nucleus", 
			//	"Nucleus", this.componentID, this.parentID, currentPoints);
			
			System.out.println("Created Nucleus Info using EJB");   	
		}catch (Exception e) { 
			System.out.println("Exception Creating Colony - Nucleus");
			throw new ServerException("Remote Exception NucleusEpithelium():", e); 	
		}
	}

		
}
