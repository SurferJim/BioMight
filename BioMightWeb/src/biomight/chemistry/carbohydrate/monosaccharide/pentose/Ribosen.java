/*
 * Created on May 2, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.chemistry.carbohydrate.monosaccharide.pentose;

import java.lang.reflect.Method;
import java.util.ArrayList;

import javax.naming.InitialContext;




import biomight.Constants;
import biomight.chemistry.elements.Carbon;
import biomight.ejb.BioMightBeanLocal;
import biomight.ejb.BioMightCellularBeanLocal;
import biomight.exceptions.ServerException;
import biomight.util.BioGraphics;
import biomight.view.BioMightMethodView;
import biomight.view.BioMightPropertyView;
import biomight.view.BioMightTransform;

/***********************************************************************
 * @author SurferJim
 *
 * Representation of Ribosen
 ***********************************************************************
 */
public class Ribosen extends Pentose {
	Carbon carbon1;
	private ArrayList ribosen;

	
	/********************************************************************************************************************
	 *  Ribosen
	 * 
	 * This method will instantiate the Ribosen that are defined for the current model.  
	 * 
	 ********************************************************************************************************************/

	public Ribosen()
	{		
		int localVP= Constants.BIO_CHILD;
		int localLOD = Constants.VIEW_HAWKEYE;
		create(localVP, localLOD, Constants.CellsRef, null, null);
	}
	
	/********************************************************************************************************************
	 *  NUCLEOTIDES
	 * 
	 * This method will instantiate the Ribosen that are defined for the current model.  
	 * 
	 ********************************************************************************************************************/

	public Ribosen(String parentID)
	{				
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, parentID, null, null);
	}

	public Ribosen(String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
	{	
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);
	}
	
	public Ribosen(int localVP, int localLOD, String parentID,  ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
	{		
		create(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);
	}
	
	
	/********************************************************************************************************************
	 * CREATE RIBOSEN
	 * 
	 * This method will instantiate the Ribosen that are defined for the current model.  
	 * 
	 ********************************************************************************************************************/

	private void create(int localVP, int localLOD, String parentID,  ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods) {
		this.setImage("images/Ribosen.jpg");
		
		ribosen = new ArrayList();
	
		// This is a collection, so set the parent of the children
		// to that of the aggregation object
		this.parentID=parentID;
		this.componentID = parentID;
		this.lod = localLOD;
		this.viewPerspective = localVP;
		
		
		if (bioMightMethods != null){
			System.out.println("EXECUTING Ribosen Methods: " + bioMightMethods.size());
			executeMethods(bioMightMethods);
		}
		
		// Get the information from the database via the Enterprise Bean.  This will get
		// a collection of Ribosen
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Getting Ribosen Transform: " + componentID + "   " +  parentID);
			InitialContext ctx = new InitialContext();
			BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
			bioMightTransforms = bioMightBean.getComponents(Constants.RiboseRef, parentID);   	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - Ribosen");
			throw new ServerException("Remote Exception getComponents():", e); 	
		}
				
		// Run through the collection of ribosen and build them into the model
		ArrayList transforms = bioMightTransforms.getTransforms();
		System.out.println("Have Ribosen NumTransforms: " + transforms.size());
		
		// If we are culling the data set
		int numRetreive=transforms.size();
		//if (parentID.equals("Cells"))
		
		for (int i=0; i<transforms.size(); i++)
		{
			// Get the information for the ribose we are creating
			BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
			System.out.println("Creating Ribose: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
			
			// Create an instance of a Ribose for each tranform specified
			localVP = Constants.VIEW_INTERNAL;
			localLOD = Constants.MAG1X;
			Ribose ribose = new Ribose(localVP, localLOD, bioMightTransform.getId(), bioMightMethods);		
			System.out.println("Ribose Created!: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
			ribosen.add(ribose);
			System.out.println("Add Ribose to Collection!: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());

			// initialize the Properties
			// in this case, rather than pass canonical name, we pass the name found in the collectio
			initProperty(bioMightTransform.getName(), Constants.Ribose, Constants.RiboseRef, bioMightTransform.getId());				
			
			int numElements = 50;
			if (i == numElements)
				break;
		}

		// Set up methods that will be available to the ribosen
		initMethods();
	}
	
	
	public void initMethods() {
			
		BioMightMethodView method = new BioMightMethodView();
		method.setCanonicalName(Constants.Ribosen);
		method.setMethodName("setColonySize");
		method.setDisplayName("Colony Size:");
		method.setHtmlType("text");
		method.setDataType(Constants.BIO_INT);
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
		double angle = 0;
		
		// Assemble the Ribosen
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
		"title='Ribosen'\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		

		String body = ""; 
		System.out.println("Assembling X3D for Ribosen - size: " + ribosen.size());

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
				System.out.println("Getting X3D for Ribose at LOD 0: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());				

				//System.out.println("Getting X3D for RiboseX: " + bioMightTransform.getTranslation().getXPos());
				//System.out.println("Getting X3D for RiboseY: " + bioMightTransform.getTranslation().getYPos());
				//System.out.println("Getting X3D for RiboseZ: " + bioMightTransform.getTranslation().getZPos());
				// Change the height and width based on the displacement.
				body += getLocalX3DZ(bioMightTransform, angle);
				angle = angle + 10;
			}
		}			
		else
		{
			// Run through the collection of Ribosen and assemble the X3D for each
			for (int i=0; i<ribosen.size(); i++)
			{
				// Get the information for the ribose
				Ribose ribose = (Ribose) ribosen.get(i);
				System.out.println("Getting X3D for Ribose: " + ribose.getComponentID());
				body += ribose.getX3D(true);
			}		
		
		}
		
		
		//System.out.println("Ribosen X3D: " + body);		
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
		System.out.println("Ribosen-Executing Methods: " + bioMightMethods.size());
		for (int j=0; j<bioMightMethods.size(); j++){
			
			// Get the parameter from the list and if it is not
			// empty execute the associated method using it
			BioMightMethodView bioMightMethod = (BioMightMethodView) bioMightMethods.get(j);
			System.out.println("Have BioMightMethod for Ribosen: " + bioMightMethod.getMethodName());	
			String methodName = bioMightMethod.getMethodName();
			String canonicalName = bioMightMethod.getCanonicalName(); 
			String dataType = bioMightMethod.getDataType();
			String methodParam = bioMightMethod.getMethodParameter(); 
			if (methodParam == null)
				methodParam = "";
			
			// We only execute those methods that are targeted for the IRIS
			// If a parameter is specified then we fire the method, otherwise
			// we just jump over it
			if (canonicalName.equals(Constants.Ribosen)) {				
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
				System.out.println("Ribosen - Methods have fired.   Calling Ribosen Save method!");
			}
		}
	}

	
	/********************************************************************************************************************
	 * GET LOCAL X3D
	 * 
	 * This method will return the X3D for the Ribosen.  Each Ribose record from the database will yield
	 * a representation of the entire structure at the current level.
	 * 
	 ********************************************************************************************************************/
	public String getLocalX3D(BioMightTransform bioMightTransform) 
	{
		String body = "";
		
		double x = bioMightTransform.getTranslation().getXPos();
		double y = bioMightTransform.getTranslation().getYPos();
		double z = bioMightTransform.getTranslation().getZPos();
		
		double xScale = 1.0;
		double yScale = 1.0;
		double zScale = 1.0;

		// Make a 5 pointed ribose sugar molecule
		double circumference = 0.25;
		String riboseElements[] = {"Carbon", "Carbon", "Oygen", "Carbon", "Carbon"};
		double[][] ribosePoints = {
				 {x-circumference,             	y, 							z},
 				 {x+circumference,             	y, 							z},
 				 {x+(circumference * 1.5), 		y+circumference,  			z},
 				 {x, 							y+(circumference * 1.5), 	z},
 				 {x-(circumference * 1.5), 		y+circumference, 			z}	
  		};

		// Create the Ribose X3D
		for (int i=0; i<riboseElements.length; i++)
		{
			//System.out.println("Creating X3D for : " + riboseElements[i]);				
			
			// Change the height and width based on the displacement.
			body += "\n<Transform DEF='" + riboseElements[i] + "'\n";
					
		 	body += "translation='" 
		 		 	+ ribosePoints[i][0] + " " 
		 		 	+ ribosePoints[i][1] + " "
					+ ribosePoints[i][2]+ "'\n";					
			
			//System.out.println("Set Translation: ");				

			body +=  "scale='" 	+ xScale + " "
			 					+ yScale + " "
			 					+ zScale + "'>\n" +

			 "\n<Shape DEF='" + riboseElements[i] + "Shape'\n" +
			    " containerField='children'>\n" +
			    " <Appearance\n" +
			    "  containerField='appearance'>\n";

		
			body+= " <ImageTexture containerField='texture' " +
			    " url='../images/" + riboseElements[i] + ".jpg'/>";
				
			    
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
			 	"<Sphere DEF='" + riboseElements[i] + "Sphere'\n" +
			 	"containerField='geometry'\n" +
			 	"radius='" + bioMightTransform.getRadius() +"'/>\n" +
			 	"</Shape>\n" +
			 	
				"\n<TouchSensor DEF='"+riboseElements[i]+"Touch' \n" +
                   " description='"+riboseElements[i]+"'\n" +
	               " containerField='children'/> \n" +

			 "</Transform>\n";
					
			//System.out.println("Nuceotides - Set Transform: ");				
		}

		
		// Make a cross-shaped phosphate backbone
		// Align to the Sugar Stabilizer
		String phosphateElements[] = {"Phosphorous", "Oxygen", "Oygen", "Oxygen", "Oygen"};
		x = x - circumference * 3;
		y = y + circumference * 3; 
		double[][] phosphatePoints = {
				 {x,             				y, 							z},
 				 {x-circumference,             	y, 							z},
 				 {x,					 		y+circumference,  			z},
 				 {x+circumference, 				y, 							z},
 				 {x, 							y-circumference, 			z}	
  		};
		
		// Create the Phosphate X3D
		for (int i=0; i<phosphateElements.length; i++)
		{
			//System.out.println("Creating X3D for : " + phosphateElements[i]);				
			
			// Change the height and width based on the displacement.
			body += "\n<Transform DEF='" + phosphateElements[i] + "'\n";
					
		 	body += "translation='" 
		 		 	+ phosphatePoints[i][0] + " " 
		 		 	+ phosphatePoints[i][1] + " "
					+ phosphatePoints[i][2]+ "'\n";					
			
			System.out.println("Set Translation: ");				

			body +=  "scale='" 	+ xScale + " "
			 					+ yScale + " "
			 					+ zScale + "'>\n" +

			 "\n<Shape DEF='" + phosphateElements[i] + "Shape'\n" +
			    " containerField='children'>\n" +
			    " <Appearance\n" +
			    "  containerField='appearance'>\n";

		
			body+= " <ImageTexture containerField='texture' " +
			    " url='../images/" + phosphateElements[i] + ".jpg'/>";
				
			    
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
			 	"<Sphere DEF='" + phosphateElements[i] + "Sphere'\n" +
			 	"containerField='geometry'\n" +
			 	"radius='" + bioMightTransform.getRadius() +"'/>\n" +
			 	"</Shape>\n" +
			 	
				"\n<TouchSensor DEF='"+phosphateElements[i]+"Touch' \n" +
                   " description='"+phosphateElements[i]+"'\n" +
	               " containerField='children'/> \n" +

			 "</Transform>\n";
			
			//System.out.println("Nuceotides - Set Transform: ");				
		}
			

		// Make a Nitrogeneous Base	- Pentose
		// Align to the Sugar Stabilizer
		String nbElements[] = {"Nitrogen", "Nitrogen", "Nitrogen", "Nitrogen", "Hydrogen"};
		x = x + circumference * 3;
		y = y + circumference * 3; 
		double[][] nbPoints = {
				 {x,             			y, 							z},
 				 {x+circumference,          y+(circumference * 1.5), 	z},
 				 {x+circumference*2,	 	y+circumference,  			z},
 				 {x+circumference*2, 		y-circumference, 			z},
 				 {x+circumference, 			y-(circumference * 1.5), 	z}	
  		};
		
		
		// Create the Nitrogeneous Base	 X3D
		for (int i=0; i<nbElements.length; i++)
		{
			//System.out.println("Creating X3D for : " + phosphateElements[i]);				
			
			// Change the height and width based on the displacement.
			body += "\n<Transform DEF='" + nbElements[i] + "'\n";
					
		 	body += "translation='" 
		 		 	+ nbPoints[i][0] + " " 
		 		 	+ nbPoints[i][1] + " "
					+ nbPoints[i][2]+ "'\n";					
			
			System.out.println("Set Translation: ");				

			body +=  "scale='" 	+ xScale + " "
			 					+ yScale + " "
			 					+ zScale + "'>\n" +

			 "\n<Shape DEF='" + nbElements[i] + "Shape'\n" +
			    " containerField='children'>\n" +
			    " <Appearance\n" +
			    "  containerField='appearance'>\n";

		
			body+= " <ImageTexture containerField='texture' " +

			" url='../images/" + nbElements[i] + ".jpg'/>";
				
			    
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
			 	"<Sphere DEF='" + nbElements[i] + "Sphere'\n" +
			 	"containerField='geometry'\n" +
			 	"radius='" + bioMightTransform.getRadius() +"'/>\n" +
			 	"</Shape>\n" +
			 	
				"\n<TouchSensor DEF='"+nbElements[i]+"Touch' \n" +
                   " description='"+nbElements[i]+"'\n" +
	               " containerField='children'/> \n" +

			 "</Transform>\n";
			
			//System.out.println("Nuceotides - Set Transform: ");				
		}
		

		// Make a Nitrogeneous Base	- Hexose
		// Align to the Pentanomer Nitrogen 
		String nbHElements[] = {"Nitrogen", "Nitrogen", "Nitrogen", "Nitrogen", "Hydrogen"};
		x = x + circumference * 2;
		y = y + circumference; 
		double[][] nbHPoints = {
				 {x,             			y, 							z},
 				 {x+circumference,          y+(circumference),		 	z},
 				 {x+circumference*2,	 	y,				  			z},
 				 {x+circumference*2, 		y-circumference, 			z},
 				 {x+circumference,	 		y-circumference*2, 			z},
 				 {x,			 			y-(circumference),		 	z}	
  		};
		
		
		// Create the Nitrogeneous Base	 X3D
		for (int i=0; i<nbElements.length; i++)
		{
			//System.out.println("Creating X3D for : " + phosphateElements[i]);				
			
			// Change the height and width based on the displacement.
			body += "\n<Transform DEF='" + nbHElements[i] + "'\n";
					
		 	body += "translation='" 
		 		 	+ nbHPoints[i][0] + " " 
		 		 	+ nbHPoints[i][1] + " "
					+ nbHPoints[i][2]+ "'\n";					
			
			System.out.println("Set Translation: ");				

			body +=  "scale='" 	+ xScale + " "
			 					+ yScale + " "
			 					+ zScale + "'>\n" +

			 "\n<Shape DEF='" + nbHElements[i] + "Shape'\n" +
			    " containerField='children'>\n" +
			    " <Appearance\n" +
			    "  containerField='appearance'>\n";

		
			body+= " <ImageTexture containerField='texture' " +

			" url='../images/" + nbHElements[i] + ".jpg'/>";
				
			    
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
			 	"<Sphere DEF='" + nbHElements[i] + "Sphere'\n" +
			 	"containerField='geometry'\n" +
			 	"radius='" + bioMightTransform.getRadius() +"'/>\n" +
			 	"</Shape>\n" +
			 	
				"\n<TouchSensor DEF='"+nbHElements[i]+"Touch' \n" +
                   " description='"+nbHElements[i]+"'\n" +
	               " containerField='children'/> \n" +

			 "</Transform>\n";
			
			//System.out.println("Nuceotides - Set Transform: ");				
		}

		
		
		return (body);
	}


	/********************************************************************************************************************
	 * GET LOCAL X3D
	 * 
	 * This method will return the X3D for the Ribosen.  Each Ribose record from the database will yield
	 * a representation of the entire structure at the current level.
	 * 
	 ********************************************************************************************************************/
	public String getLocalX3DZ(BioMightTransform bioMightTransform, double angle) 
	{
		String body = "";
		
		double x = bioMightTransform.getTranslation().getXPos();
		double y = bioMightTransform.getTranslation().getYPos();
		double z = bioMightTransform.getTranslation().getZPos();
		
		double xScale = 1.0;
		double yScale = 1.0;
		double zScale = 1.0;

		// Make a 5 pointed ribose sugar molecule
		double circumference = 0.25;
		String riboseElements[] = {"Carbon", "Carbon", "Oygen", "Carbon", "Carbon"};
		double[][] ribosePoints = {
				 {x-circumference,             	y, 						 z},
 				 {x+circumference,             	y, 						 z},
 				 {x+(circumference * 1.5), 		y,  		z+circumference},
 				 {x, 							y, 	z+(circumference * 1.5)},
 				 {x-(circumference * 1.5), 		y, 			z+circumference}	
  		};


		if (angle > 0.0)
		{
			System.out.println("Rotating Ribose: " + angle);			
			ribosePoints = BioGraphics.rotateY(ribosePoints, angle);
			System.out.println("Rotated Ribose: " + angle);			
		}
		
		// Create the Ribose X3D
		for (int i=0; i<riboseElements.length; i++)
		{
			//System.out.println("Creating X3D for : " + riboseElements[i]);				
			
			// Change the height and width based on the displacement.
			body += "\n<Transform DEF='" + riboseElements[i] + "'\n";
					
		 	body += "translation='" 
		 		 	+ ribosePoints[i][0] + " " 
		 		 	+ ribosePoints[i][1] + " "
					+ ribosePoints[i][2]+ "'\n";					
			
			System.out.println("Set Translation: ");				

			body +=  "scale='" 	+ xScale + " "
			 					+ yScale + " "
			 					+ zScale + "'>\n" +

			 "\n<Shape DEF='" + riboseElements[i] + "Shape'\n" +
			    " containerField='children'>\n" +
			    " <Appearance\n" +
			    "  containerField='appearance'>\n";

		
			body+= " <ImageTexture containerField='texture' " +
			    " url='../images/" + riboseElements[i] + ".jpg'/>";
				
			    
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
			 	"<Sphere DEF='" + riboseElements[i] + "Sphere'\n" +
			 	"containerField='geometry'\n" +
			 	"radius='" + bioMightTransform.getRadius() +"'/>\n" +
			 	"</Shape>\n" +
			 	
				"\n<TouchSensor DEF='"+riboseElements[i]+"Touch' \n" +
                   " description='"+riboseElements[i]+"'\n" +
	               " containerField='children'/> \n" +

			 "</Transform>\n";
					
			//System.out.println("Nuceotides - Set Transform: ");				
		}

		
		// Make a cross-shaped phosphate backbone
		// Align to the Sugar Stabilizer
		String phosphateElements[] = {"Phosphorous", "Oxygen", "Oygen", "Oxygen", "Oygen"};
		x = x - circumference * 3;
		z = z + circumference * 3; 
		double[][] phosphatePoints = {
				 {x,             				y, 							z},
 				 {x-circumference,             	y, 							z},
 				 {x,					 		y,  		  z+circumference},
 				 {x+circumference, 				y, 							z},
 				 {x, 							y, 			  z-circumference}	
  		};

		if (angle > 0.0)
		{
			System.out.println("Rotating Ribose: " + angle);			
			phosphatePoints = BioGraphics.rotateY(phosphatePoints, angle);
			System.out.println("Rotated Ribose: " + angle);			
		}
		
		// Create the Phosphate X3D
		for (int i=0; i<phosphateElements.length; i++)
		{
			//System.out.println("Creating X3D for : " + phosphateElements[i]);				
			
			// Change the height and width based on the displacement.
			body += "\n<Transform DEF='" + phosphateElements[i] + "'\n";
					
		 	body += "translation='" 
		 		 	+ phosphatePoints[i][0] + " " 
		 		 	+ phosphatePoints[i][1] + " "
					+ phosphatePoints[i][2]+ "'\n";					
			
			body +=  "scale='" 	+ xScale + " "
			 					+ yScale + " "
			 					+ zScale + "'>\n" +

			 "\n<Shape DEF='" + phosphateElements[i] + "Shape'\n" +
			    " containerField='children'>\n" +
			    " <Appearance\n" +
			    "  containerField='appearance'>\n";

		
			body+= " <ImageTexture containerField='texture' " +
			    " url='../images/" + phosphateElements[i] + ".jpg'/>";
				
			    
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
			 	"<Sphere DEF='" + phosphateElements[i] + "Sphere'\n" +
			 	"containerField='geometry'\n" +
			 	"radius='" + bioMightTransform.getRadius() +"'/>\n" +
			 	"</Shape>\n" +
			 	
				"\n<TouchSensor DEF='"+phosphateElements[i]+"Touch' \n" +
                   " description='"+phosphateElements[i]+"'\n" +
	               " containerField='children'/> \n" +

			 "</Transform>\n";
			
			//System.out.println("Nuceotides - Set Transform: ");				
		}
			

		// Make a Nitrogeneous Base	- Pentose
		// Align to the Sugar Stabilizer
		String nbElements[] = {"Nitrogen", "Nitrogen", "Nitrogen", "Nitrogen", "Hydrogen"};
		x = x + circumference * 3;
		z = z + circumference * 3; 
		double[][] nbPoints = {
				 {x,             			y, 							z},
 				 {x+circumference,          y, 	  z+(circumference * 1.5)},
 				 {x+circumference*2,	 	y,  		  z+circumference},
 				 {x+circumference*2, 		y, 			  z-circumference},
 				 {x+circumference, 			y, 	   z-(circumference * 1.5)}	
  		};
		
		if (angle > 0.0)
		{
			System.out.println("Rotating Ribose: " + angle);			
			nbPoints = BioGraphics.rotateY(nbPoints, angle);
			System.out.println("Rotated Ribose: " + angle);			
		}		
		
		// Create the Nitrogeneous Base	 X3D
		for (int i=0; i<nbElements.length; i++)
		{
			//System.out.println("Creating X3D for : " + phosphateElements[i]);				
			
			// Change the height and width based on the displacement.
			body += "\n<Transform DEF='" + nbElements[i] + "'\n";
					
		 	body += "translation='" 
		 		 	+ nbPoints[i][0] + " " 
		 		 	+ nbPoints[i][1] + " "
					+ nbPoints[i][2]+ "'\n";					
			
			System.out.println("Set Translation: ");				

			body +=  "scale='" 	+ xScale + " "
			 					+ yScale + " "
			 					+ zScale + "'>\n" +

			 "\n<Shape DEF='" + nbElements[i] + "Shape'\n" +
			    " containerField='children'>\n" +
			    " <Appearance\n" +
			    "  containerField='appearance'>\n";

		
			body+= " <ImageTexture containerField='texture' " +

			" url='../images/" + nbElements[i] + ".jpg'/>";
				
			    
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
			 	"<Sphere DEF='" + nbElements[i] + "Sphere'\n" +
			 	"containerField='geometry'\n" +
			 	"radius='" + bioMightTransform.getRadius() +"'/>\n" +
			 	"</Shape>\n" +
			 	
				"\n<TouchSensor DEF='"+nbElements[i]+"Touch' \n" +
                   " description='"+nbElements[i]+"'\n" +
	               " containerField='children'/> \n" +

			 "</Transform>\n";
			
			//System.out.println("Nuceotides - Set Transform: ");				
		}
		

		// Make a Nitrogeneous Base	- Hexose
		// Align to the Pentanomer Nitrogen 
		String nbHElements[] = {"Nitrogen", "Nitrogen", "Nitrogen", "Nitrogen", "Hydrogen"};
		x = x + circumference * 2;
		z = z + circumference; 
		double[][] nbHPoints = {
				 {x,             			y, 							z},
 				 {x+circumference,          y,		 	z+(circumference)},
 				 {x+circumference*2,	 	y,				  			z},
 				 {x+circumference*2, 		y, 			  z-circumference},
 				 {x+circumference,	 		y, 			z-circumference*2},
 				 {x,			 			y,		 	z-(circumference)}	
  		};

		if (angle > 0.0)
		{
			System.out.println("Rotating Ribose: " + angle);			
			nbHPoints = BioGraphics.rotateY(nbHPoints, angle);
			System.out.println("Rotated Ribose: " + angle);			
		}
		
		// Create the Nitrogeneous Base	 X3D
		for (int i=0; i<nbElements.length; i++)
		{
			//System.out.println("Creating X3D for : " + phosphateElements[i]);				
			
			// Change the height and width based on the displacement.
			body += "\n<Transform DEF='" + nbHElements[i] + "'\n";
					
		 	body += "translation='" 
		 		 	+ nbHPoints[i][0] + " " 
		 		 	+ nbHPoints[i][1] + " "
					+ nbHPoints[i][2]+ "'\n";					
			
			System.out.println("Set Translation: ");				

			body +=  "scale='" 	+ xScale + " "
			 					+ yScale + " "
			 					+ zScale + "'>\n" +

			 "\n<Shape DEF='" + nbHElements[i] + "Shape'\n" +
			    " containerField='children'>\n" +
			    " <Appearance\n" +
			    "  containerField='appearance'>\n";

		
			body+= " <ImageTexture containerField='texture' " +

			" url='../images/" + nbHElements[i] + ".jpg'/>";
				
			    
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
			 	"<Sphere DEF='" + nbHElements[i] + "Sphere'\n" +
			 	"containerField='geometry'\n" +
			 	"radius='" + bioMightTransform.getRadius() +"'/>\n" +
			 	"</Shape>\n" +
			 	
				"\n<TouchSensor DEF='"+nbHElements[i]+"Touch' \n" +
                   " description='"+nbHElements[i]+"'\n" +
	               " containerField='children'/> \n" +

			 "</Transform>\n";
			
			//System.out.println("Nuceotides - Set Transform: ");				
		}

		
		
		return (body);
	}

	
	/******************************************************************************************
	 * SET COLONY SIZE 
	 *
	 * This method will set the Colony size for the Ribosen.  
	 *****************************************************************************************/
	public void setColonySize(int size) {

		// Run through the argument list and executes the 
		// associated 	methods
		boolean fired = false;
		System.out.println("Ribosen-SetColony Size: " + size);
		
		// Generate the Ribose		
		BioMightCellularBeanLocal bioMightBean;
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Generating the Ribose Colony: " + componentID + "    " + parentID);
			InitialContext ctx = new InitialContext();
			bioMightBean = (BioMightCellularBeanLocal) ctx.lookup("java:global/BioMightWeb/BioMightCellularBean!biomight.ejb.BioMightCellularBeanLocal");
			
		    		 					
			double currentPoints[][] = null;
			//int success = bioMightBean.generateRibosen(size, "Ribose:00001", "Ribose", 
			//	"Ribose", this.componentID, this.parentID, currentPoints);
			
			System.out.println("Created Ribose Info using EJB");   	
		}catch (Exception e) { 
			System.out.println("Exception Creating Colony - Ribose");
			throw new ServerException("Remote Exception RiboseEpithelium():", e); 	
		}
	}
	
	
}
