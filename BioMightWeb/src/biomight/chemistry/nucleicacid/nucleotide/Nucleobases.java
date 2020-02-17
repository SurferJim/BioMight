/*
 * Created on Jun 3, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
 
package biomight.chemistry.nucleicacid.nucleotide;
import java.lang.reflect.Method;
import java.util.ArrayList;

import javax.naming.InitialContext;






import biomight.Constants;
import biomight.chemistry.nucleicacid.NucleicAcid;
import biomight.ejb.BioMightBeanLocal;
import biomight.ejb.BioMightDNABeanLocal;
import biomight.exceptions.ServerException;
import biomight.util.BioGraphicsDNA;
import biomight.view.BioMightMethodView;
import biomight.view.BioMightPropertyView;
import biomight.view.BioMightTransform;


/***************************************************************************
 * @author SurferJim
 *
 * Representation for Nucleobases
 * 
 ***************************************************************************/

public class Nucleobases extends NucleicAcid {
private ArrayList nucleobases;

	
	/********************************************************************************************************************
	 *  Nucleobases
	 * 
	 * This method will instantiate the Nucleobases that are defined for the current model.  
	 * 
	 ********************************************************************************************************************/

	public Nucleobases()
	{		
		int localVP= Constants.BIO_CHILD;
		int localLOD = Constants.VIEW_HAWKEYE;
		create(localVP, localLOD, Constants.NucleobasesRef, null, null);
	}
	
	/********************************************************************************************************************
	 *  NUCLEOTIDES
	 * 
	 * This method will instantiate the Nucleobases that are defined for the current model.  
	 * 
	 ********************************************************************************************************************/

	public Nucleobases(String parentID)
	{				
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, parentID, null, null);
	}

	public Nucleobases(String parentID, ArrayList<BioMightMethodView> bioMightMethods)
	{	
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, parentID, null, bioMightMethods);
	}
	
	public Nucleobases(String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
	{	
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);
	}
	
	
	public Nucleobases(int localVP, int localLOD, String parentID,  ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
	{		
		create(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);
	}
	
	
	/********************************************************************************************************************
	 * CREATE NUCLEOTIDES
	 * 
	 * This method will instantiate the Nucleobases that are defined for the current model.  
	 * 
	 ********************************************************************************************************************/

	private void create(int localVP, int localLOD, String parentID,  ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods) {
		this.setImage("images/Nucleobases.jpg");
		
		nucleobases = new ArrayList();
	
		// This is a collection, so set the parent of the children
		// to that of the aggregation object
		this.parentID=parentID;
		this.componentID = parentID;
		this.lod = localLOD;
		this.viewPerspective = localVP;
		
		if (bioMightMethods != null){
			System.out.println("EXECUTING Nucleobases Methods: " + bioMightMethods.size());
			executeMethods(bioMightMethods);
		}
		
		// Get the information from the database via the Enterprise Bean.  This will get
		// a collection of Nucleobases
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Getting Nucleobases Transform: " + componentID + "   " +  parentID);
			InitialContext ctx = new InitialContext();
			BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
			bioMightTransforms = bioMightBean.getComponents(Constants.NucleobaseRef, parentID);   	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - Nucleobases");
			throw new ServerException("Remote Exception getComponents():", e); 	
		}
				
		// Run through the collection of nucleobases and build them into the model
		ArrayList transforms = bioMightTransforms.getTransforms();
		System.out.println("Have Nucleobases NumTransforms: " + transforms.size());
		
		// If we are culling the data set
		int numRetreive=transforms.size();
		//if (parentID.equals("Cells"))
		
		for (int i=0; i<transforms.size(); i++)
		{
			// Get the information for the nucleobase we are creating
			BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
			System.out.println("Creating Nucleobase: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
			
			// Create an instance of a Nucleobase for each tranform specified
			localVP = Constants.VIEW_INTERNAL;
			localLOD = Constants.MAG1X;
			Nucleobase nucleobase = new Nucleobase(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);		
			System.out.println("Nucleobase Created!: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
			nucleobases.add(nucleobase);
			System.out.println("Add Nucleobase to Collection!: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());

			// initialize the Properties
			// in this case, rather than pass canonical name, we pass the name found in the collectio
			initProperty(bioMightTransform.getName(), Constants.Nucleobase, Constants.NucleobaseRef, bioMightTransform.getId());				
			
			int numElements = 50;
			if (i == numElements)
				break;
		}

		// Set up methods that will be available to the nucleobases
		initMethods();
	}
	
	
	public void initMethods() {
			
		BioMightMethodView method = new BioMightMethodView();
		method.setCanonicalName(Constants.Nucleobases);
		method.setMethodName("setDNA");
		method.setDisplayName("DNA:");
		method.setDataType(Constants.BIO_TEXT);
		method.setHtmlType("text");
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
		
		// Assemble the Nucleobases
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
		"title='Nucleobases'\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		

		String body = ""; 
		System.out.println("Assembling X3D for Nucleobases - size: " + nucleobases.size());

		// Grab the information from what we already retreived from the database
		// Another method  would be to pass that transform object down to the
		// child object, or have it re-retrieve from the database
		viewPerspective = Constants.VIEW_INTERNAL;
		if (viewPerspective == Constants.VIEW_INTERNAL)			
		{	
			ArrayList transforms = bioMightTransforms.getTransforms();
			for (int i=0; i<transforms.size(); i++)
			{
				// Get the information for the Nucleobase we are creating
				BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
				System.out.println("Getting X3D for Nucleobase at LOD (0): " + bioMightTransform.getName() + "  " + bioMightTransform.getId());				

				//System.out.println("Getting X3D for NucleobaseX: " + bioMightTransform.getTranslation().getXPos());
				//System.out.println("Getting X3D for NucleobaseY: " + bioMightTransform.getTranslation().getYPos());
				//System.out.println("Getting X3D for NucleobaseZ: " + bioMightTransform.getTranslation().getZPos());
				// Change the height and width based on the displacement.
				body += getLocalX3DZ(bioMightTransform, angle);
				angle = angle + 10;
			}
		}			
		else
		{
			// Run through the collection of Nucleobases and assemble the X3D for each
			for (int i=0; i<nucleobases.size(); i++)
			{
				// Get the information for the nucleobase
				Nucleobase nucleobase = (Nucleobase) nucleobases.get(i);
				System.out.println("Getting X3D for Nucleobase: " + nucleobase.getComponentID());
				body += nucleobase.getX3D(true);
			}		
		
		}
		
		
		//System.out.println("Nucleobases X3D: " + body);		
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
		System.out.println("DNAs-Executing Methods: " + bioMightMethods.size());
		for (int j=0; j<bioMightMethods.size(); j++){
			
			// Get the parameter from the list and if it is not
			// empty execute the associated method using it
			BioMightMethodView bioMightMethod = (BioMightMethodView) bioMightMethods.get(j);
			System.out.println("Have BioMightMethod for DNAs: " + bioMightMethod.getMethodName());	
			String methodName = bioMightMethod.getMethodName();
			String canonicalName = bioMightMethod.getCanonicalName(); 
			String dataType = bioMightMethod.getDataType();
			String methodParam = bioMightMethod.getMethodParameter(); 
			if (methodParam == null)
				methodParam = "";
			
		
			if (canonicalName.equals(Constants.Nucleobases)) {				
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
					else if (dataType.equals(Constants.BIO_TEXT)) {
						
						
						try {
							System.out.println("Locating Method(BIOTEXT)");
							
							Class paramsType[] = {String.class};
							Method method = this.getClass().getDeclaredMethod(methodName, paramsType );
							System.out.println("Method with BIOTEXT Param: " + methodName);
							
							System.out.println("Before Execute Method(BIOTEXT)" + methodName);
							Object result = method.invoke(this, methodParam);
							System.out.println("After Execute Method(BIOTEXT)" + methodName);
									
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
				System.out.println("DNAs - Methods have fired.   Calling DNAs Save method!");
			}
		}
	}



	
	

	/********************************************************************************************************************
	 * GET LOCAL X3D
	 * 
	 * This method will return the X3D for the Nucleobases.  Each Nucleobase record from the database will yield
	 * a representation of the entire structure at the current level.
	 * 
	 ********************************************************************************************************************/
	public String getLocalX3DZ(BioMightTransform bioMightTransform, double angle) 
	{

		double x = bioMightTransform.getTranslation().getXPos();
		double y = bioMightTransform.getTranslation().getYPos();
		double z = bioMightTransform.getTranslation().getZPos();
		System.out.println("Nucleobases.getLocalX3DZ()    x:" + x + " y: "   + y + "  z:" + z);			

		double xScale = 1.0;
		double yScale = 1.0;
		double zScale = 1.0;

		double circumference = 0.25;
		String body = BioGraphicsDNA.getDeOxyRibose(bioMightTransform, circumference, angle);
	
		body += BioGraphicsDNA.getPhosphate(bioMightTransform, circumference, angle);
					
		//body += BioGraphicsDNA.getPentose(bioMightTransform, circumference, angle);
		
		//body += BioGraphicsDNA.getHexose(bioMightTransform, circumference, angle);
				
		return (body);
	}

	
	
	/******************************************************************************************
	 * SET DNA
	 *
	 * This method will create a chain of DNA 
	 *   
	 *****************************************************************************************/
	public void setDNA(String chain) {

		// Run through the argument list and executes the 
		// associated methods
		boolean fired = false;
		System.out.println("In SetDNA() chain is: " + chain);
		
		// Generate the DNA Chain
		
		BioMightDNABeanLocal bioMightBean;
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Generating the DNA Chain: " + componentID + "    " + parentID);
			InitialContext ctx = new InitialContext();
			bioMightBean = (BioMightDNABeanLocal) ctx.lookup("java:global/BioMightWeb/BioMightDNABean!biomight.ejb.BioMightDNABeanLocal");
		    		 					
			double currentPoints[][] = null;
			int success = bioMightBean.generateNucleotides(chain, Constants.NucleobaseRef+":00001", "Nucleobase", 
					Constants.NucleobaseRef, this.componentID, this.parentID, currentPoints);
			
			System.out.println("Created DNAChain Info using EJB");   	
		}catch (Exception e) { 
			System.out.println("Exception Creating Chain - DNA");
			throw new ServerException("Remote Exception setDNA():", e); 	
		}
	}
	
}
