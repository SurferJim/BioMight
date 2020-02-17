/*
 * Created on Jul 24, 2006
 * Copyright 2006 - Biomight.org
 * 
 * This code is the not to be used without written permission from
 * BioMight.org
 * 
 */
 
package biomight.chemistry.hormones.lipid;

import java.lang.reflect.Method;
import java.util.ArrayList;

import javax.naming.InitialContext;

import biomight.BioMightBase;
import biomight.Constants;
import biomight.ejb.BioMightBeanLocal;
import biomight.exceptions.ServerException;
import biomight.view.BioMightMethodView;
import biomight.view.BioMightTransform;

/**
 * @author SurferJim
 *
 * Representation of Cholesterols
 */

public class Cholesterols extends BioMightBase {
	private String cholesterolName = "Cholesterol";
	private String cholesterolRef = "Cholesterol";
	private ArrayList cholesterols;
		
	
	/********************************************************************************************************************
	 *  Cholesterols
	 * 
	 * This method will instantiate the cholesterols that are defined for the current model.  
	 * 
	 ********************************************************************************************************************/

	public Cholesterols()
	{		
		create(this.cholesterolRef,Constants.CellMembraneRef, null);
	}
	
	/********************************************************************************************************************
	 *  Cholesterols
	 * 
	 * This method will instantiate the Cholesterols that are defined for the current model.  
	 * 
	 ********************************************************************************************************************/

	public Cholesterols(String parentID)
	{		
		create(this.cholesterolRef, parentID, null);
	}

	
	public Cholesterols(String parentID, ArrayList<BioMightMethodView> bioMightMethods)
	{		
		create(this.cholesterolRef, parentID, bioMightMethods);
	}
	
	
	public Cholesterols(String cholesterolRef, String parentID, ArrayList<BioMightMethodView> bioMightMethods)
	{
		this.cholesterolRef = cholesterolRef;
		this.parentID=parentID;
		create(cholesterolRef, parentID, bioMightMethods);
	}
	
	
	/********************************************************************************************************************
	 * CREATE Cholesterols
	 * 
	 * This method will instantiate the Cholesterols that are defined for the current model.  
	 * 
	 ********************************************************************************************************************/

	private void create(String tissueRef, String parentID, ArrayList<BioMightMethodView> bioMightMethods) {

		cholesterols = new ArrayList();
		
		setImage("images/Cholesterols.jpg");
		setImageHeight(300);
		setImageWidth(300);
				
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Getting CholesterolsInfo for ParentID: " + parentID);
			InitialContext ctx = new InitialContext();
			BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
			//bioMightTransforms = bioMightBean.getComponents(Constants.CholesterolRef, Constants.CholesterolsRef+":0");
			bioMightTransforms = bioMightBean.getComponents(cholesterolRef, parentID);   	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - Cholesterols");
			throw new ServerException("Remote Exception getComponents():", e); 	
		}
		
		// This is a collection, so set the parent of the children
		// to that of the aggregation object
		componentID = parentID;
		
		// Run through the collection of Cholesterols and build them into the model
		// In the Default case, we get two instances of the hip, one
		// positioned on the right and one positioned on the left
		ArrayList transforms = bioMightTransforms.getTransforms();
		System.out.println("Cholesterols NumTransforms: " + transforms.size()  + "  " + cholesterolRef);
		for (int i=0; i<transforms.size(); i++)
		{
			// Get the information for the hip we are creating
			BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
			System.out.println("Creating Cholesterol: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
			
			// Create an instance of the Cholesterol for each tranform specified for the organism
			Cholesterol cholesterol = new Cholesterol(bioMightTransform.getId(), bioMightMethods);		
			System.out.println("Cholesterol Created!: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
			cholesterols.add(cholesterol);
			initProperty(bioMightTransform.getName(), Constants.Cholesterol, Constants.CholesterolRef, bioMightTransform.getId());		
			System.out.println("Add Cholesterol to Collection!: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
		}

		// Set up methods that will be available to the Cholesterols
		initMethods();
	}
			

	
	public void initMethods() {
	
		BioMightMethodView method;

		method = new BioMightMethodView();
		method.setCanonicalName(Constants.Iris);
		method.setMethodName("setRadius");
		method.setDisplayName("Iris Radius:");
		method.setHtmlType("text");
		method.setDataType("double");
		methods.add(method);

		method = new BioMightMethodView();
		method.setCanonicalName(Constants.Pupil);
		method.setMethodName("setRadius");
		method.setDisplayName("Pupil Radius:");
		method.setHtmlType("text");
		method.setDataType("double");
		methods.add(method);
	
	}
	
	
	/********************************************************************************************************************
	 * GET X3D
	 * 
	 * This method will return the X3D for the Cholesterol Molecules.  It runs through each of its components and 
	 * collect up their representations and then assembles them into one unified X3D model.
	 * 
	 ********************************************************************************************************************/
	public String getX3D(boolean snipet) {
		
		// Assemble the Cholesterols
		String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
		"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n " +
		"<X3D profile='Immersive' >\n" +
		"<head>\n" +
		 "<meta name='BioMightImage' content='Cholesterols.jpg'/>\n" +
		 "<meta name='ExportTime' content='7:45:30'/>\n" +
		 "<meta name='ExportDate' content='08/15/2008'/>\n" +
		 "<meta name='BioMight Version' content='1.0'/>\n" + 
		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='Cholesterols'\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		

		String body = ""; 
		
		if (viewPerspective == Constants.VIEW_HAWKEYE)
		{
		
			// Run through the collection of Cholesterols and assemble the X3D for each
			for (int i=0; i<cholesterols.size(); i++)
			{
				// Get the information
				Cholesterol cholesterol = (Cholesterol) cholesterols.get(i);
				//System.out.println("Getting X3D for Cholesterol Molecule: " + cholesterol.getComponentID() + " " + cholesterol.getParentID());
				body += cholesterol.getX3D(true);
			}		
		}
		else if (viewPerspective == Constants.VIEW_BIRDSEYE)
		{
			ArrayList transforms = bioMightTransforms.getTransforms();
			for (int i=0; i<transforms.size(); i++)
			{
				// Get the information for the capsomer we are creating
				BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
				System.out.println("Getting X3D for Cholesterol: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());				

				//System.out.println("Getting X3D for CholesterolX: " + bioMightTransform.getTranslation().getXPos());
				//System.out.println("Getting X3D for CholesterolY: " + bioMightTransform.getTranslation().getYPos());
				//System.out.println("Getting X3D for CholesterolZ: " + bioMightTransform.getTranslation().getZPos());
				// Change the height and width based on the displacement.
				body += "<Transform DEF='Cholesterol'\n";
					
					
				// Set the position if we are working with the Tissue collection
				if (parentID.equals("1.10000:0"))
				{
					//body += "translation='" 
					//	+ bioMightPosition.getXPos() + " " 
			 		//	+ bioMightPosition.getYPos() + " "
			 		//	+ bioMightPosition.getZPos() + "'\n";
				}
				else
				{
			 		body += "translation='" 
			 			+ bioMightTransform.getTranslation().getXPos() + " " 
 						+ bioMightTransform.getTranslation().getYPos() + " "
 						+ bioMightTransform.getTranslation().getZPos() + "'\n";					
				}

				System.out.println("Set Translation: ");				

				 					
				body +=  "scale='" 	+ bioMightTransform.getScale().getXPos() + " "
				 				+ bioMightTransform.getScale().getYPos() + " "
				 				+ bioMightTransform.getScale().getZPos() + "'>\n" +
				 	"<Shape DEF='Cholesterol'\n" +
				    " containerField='children'>\n" +
				    " <Appearance\n" +
				    "  containerField='appearance'>\n";

				System.out.println("Set Scale: ");				

			
				body+= " <ImageTexture containerField='texture' " +
				    " url='../images/Cholesterol.jpg'/>";
				
				
				    
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
				 	"<Sphere DEF='CholesterolGeoSphere'\n" +
				 	"containerField='geometry'\n" +
				 	"radius='" + bioMightTransform.getRadius() +"'/>\n" +
				 	"</Shape>\n" +
				 	
					"\n<TouchSensor DEF='"+bioMightTransform.getId()+"' \n" +
	                   " description='Cholesterol'\n" +
		               " containerField='children'/> \n" +
	
				 "</Transform>\n";
						
				System.out.println("Set Transform: ");				

			}		
			
		}	

		//System.out.println("All Cholesterols X3D: " + body);		
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
		System.out.println("Cholesterols-Executing Methods: " + bioMightMethods.size());
		for (int j=0; j<bioMightMethods.size(); j++){
			
			// Get the parameter from the list and if it is not
			// empty execute the associated method using it
			BioMightMethodView bioMightMethod = (BioMightMethodView) bioMightMethods.get(j);
			System.out.println("Have BioMightMethod for Cholesterols: " + bioMightMethod.getMethodName());	
			String methodName = bioMightMethod.getMethodName();
			String canonicalName = bioMightMethod.getCanonicalName(); 
			String dataType = bioMightMethod.getDataType();
			String methodParam = bioMightMethod.getMethodParameter(); 
			if (methodParam == null)
				methodParam = "";
			
			// We only execute those methods that are targeted for the IRIS
			// If a parameter is specified then we fire the method, otherwise
			// we just jump over it
			if (canonicalName.equals(Constants.Cholesterols)) {				
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
							System.out.println("Before Execute Method(Integer)" + methodName);	
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
								System.out.println("Before Execute Method(Double)" + methodName);
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
					}			
				}	
			}
			if (fired)
			{	
				System.out.println("Cholesterols - Methods have fired.   Calling Cholesterols Save method!");
				//save();
			}
		}
	}	

}
