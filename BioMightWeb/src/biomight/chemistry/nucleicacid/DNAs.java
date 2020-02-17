/*
 * Created on Jun 3, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
 
package biomight.chemistry.nucleicacid;
import java.lang.reflect.Method;
import java.util.ArrayList;

import javax.naming.InitialContext;

import biomight.BioMightBase;
import biomight.Constants;
import biomight.ejb.BioMightBeanLocal;
import biomight.ejb.BioMightDNABeanLocal;
import biomight.exceptions.ServerException;
import biomight.util.BioGraphicsDNA;
import biomight.view.BioMightMethodView;
import biomight.view.BioMightOrientation;
import biomight.view.BioMightPosition;
import biomight.view.BioMightPropertyView;
import biomight.view.BioMightScale;
import biomight.view.BioMightTransform;
import biomightweb.util.BioWebDNA;


/***************************************************************************
 * @author SurferJim
 *
 * Representation for DNAs  
 * 
 ***************************************************************************/

public class DNAs extends BioMightBase {
private ArrayList dnas;

	
	/********************************************************************************************************************
	 *  DNAs
	 * 
	 * This method will instantiate the DNAs that are defined for the current model.  
	 * 
	 ********************************************************************************************************************/

	public DNAs()
	{		
		int localVP= Constants.BIO_CHILD;
		int localLOD = Constants.VIEW_HAWKEYE;
		create(localVP, localLOD, Constants.DNARef, null, null);
	}
	
	/********************************************************************************************************************
	 *  DNAs
	 * 
	 * This method will instantiate the DNAs that are defined for the current model.  
	 * 
	 ********************************************************************************************************************/

	public DNAs(String parentID)
	{				
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, parentID, null, null);
	}

	public DNAs(String parentID, ArrayList<BioMightMethodView> bioMightMethods)
	{	
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, parentID, null, bioMightMethods);
	}
	
	public DNAs(String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
	{	
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);
	}
	
	
	public DNAs(int localVP, int localLOD, String parentID,  ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
	{		
		create(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);
	}
	
	
	/********************************************************************************************************************
	 * CREATE NUCLEOTIDES
	 * 
	 * This method will instantiate the DNAs that are defined for the current model.  We create a simple Nucletide to 
	 * represent the DNA molecules.
	 * 
	 ********************************************************************************************************************/

	private void create(int localVP, int localLOD, String parentID,  ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods) {
		this.setImage("images/DNAs.jpg");
		
		dnas = new ArrayList();
	
		// This is a collection, so set the parent of the children
		// to that of the aggregation object
		this.parentID=parentID;
		this.componentID = parentID;
		System.out.println("DNAs Create: " + "   compID: " +  componentID  + "  parentID: " + parentID);
		
		this.lod = localLOD;
		this.viewPerspective = localVP;
		
		if (bioMightMethods != null){
			System.out.println("EXECUTING DNAs Methods: " + bioMightMethods.size());
			executeMethods(bioMightMethods);
		}
		
		// Get the information from the database via the Enterprise Bean.  This will get
		// a collection of DNAs
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Getting DNAs Transform: " + componentID + "   " +  parentID);
			InitialContext ctx = new InitialContext();
			BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
			bioMightTransforms = bioMightBean.getComponents(Constants.DNARef, parentID);   	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - DNAs");
			throw new ServerException("Remote Exception getComponents():", e); 	
		}
				
		// Run through the collection of dnas and build them into the model
		ArrayList transforms = bioMightTransforms.getTransforms();
		System.out.println("Have DNAs NumTransforms: " + transforms.size());
		
		// If we are culling the data set
		int numRetreive=transforms.size();
		//if (parentID.equals("Cells"))
		
		
		
		for (int i=0; i<transforms.size(); i++)
		{
			// Get the information for the dna we are creating
			BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
			System.out.println("Creating DNA molecules: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
			
			// Create an instance of a Nucleotide for each tranform specified
			localVP = Constants.VIEW_HAWKEYE;
			localLOD = Constants.MAG2X;
			DNA dna = new DNA(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);		
			dnas.add(dna);
			System.out.println("Add DNA to Collection of DNAs: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());

			
			// initialize the Properties
			// in this case, rather than pass canonical name, we pass the name found in the collectio
			//initProperty(Constants.NucleotidesRef, Constants.Nucleotides, Constants.NucleotidesRef, bioMightTransform.getId());
			BioMightScale bioScale = new BioMightScale("0.00, 0.00, 0.00");
			BioMightPosition  bioPos = new BioMightPosition("0.00, 0.00, 0.00");
			BioMightOrientation  bioOrient = new BioMightOrientation("0.00, 0.00, 1.00, 0.0");
			String bioTemplate="DNAs.x3d";
			initProperty(bioMightTransform.getName(), Constants.DNA, Constants.DNARef, Constants.DNARef, bioMightTransform.getId(), bioPos, bioScale, bioOrient, Constants.SINGLE_COMPONENT, bioTemplate, false);
			
			int numElements = 50;
			if (i == numElements)
				break;
		}

		// Set up methods that will be available to the dnas
		initMethods();
	}
	
	
	public void initMethods() {
			
		//BioMightMethodView method = new BioMightMethodView();
		//method.setCanonicalName(Constants.DNAs);
		//method.setMethodName("setDNA");
		//method.setDisplayName("DNA:");
		//method.setDataType(Constants.BIO_TEXT);
		//method.setHtmlType("text");
		//methods.add(method);
	}
	
	
	/********************************************************************************************************************
	 * GET X3D
	 * 
	 * This method will return the X3D for the DNA.  It runs through each of its components and collects up their
	 * representations and then assembles them into one unified X3D model.
	 * 
	 ********************************************************************************************************************/
	public String getX3D(boolean snipet) {
		double angle = 0;
		
		// Assemble the DNAs
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
		"title='DNAs'\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		

		String body = ""; 
		System.out.println("Assembling X3D for DNAs - size: " + dnas.size());

		// Grab the information from what we already retreived from the database
		// Another method  would be to pass that transform object down to the
		// child object, or have it re-retrieve from the database
		viewPerspective = Constants.VIEW_INTERNAL;
		if (viewPerspective == Constants.VIEW_INTERNAL)			
		{	
			String componentTypeOut = "DNA";
			body += "<Transform onmouseover=\"showComponent('DNA');\" DEF='" + componentTypeOut + "  '>\n";
			
			ArrayList transforms = bioMightTransforms.getTransforms();
			for (int i=0; i<transforms.size(); i++)
			{
				// Get the information for the Nucleotide we are creating
				BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
				System.out.println("Getting X3D for DNA - VIEW_INTERNAL: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());				

				//System.out.println("Getting X3D for NucleotideX: " + bioMightTransform.getTranslation().getXPos());
				//System.out.println("Getting X3D for NucleotideY: " + bioMightTransform.getTranslation().getYPos());
				//System.out.println("Getting X3D for NucleotideZ: " + bioMightTransform.getTranslation().getZPos());
				// Change the height and width based on the displacement.
				body += getLocalX3DZ(bioMightTransform, 0, angle);
				angle = angle + 15;
			}
			
			body += "</Transform>\n";
		}			
		else
		{
			// Run through the collection of DNAs and assemble the X3D for each
			for (int i=0; i<dnas.size(); i++)
			{
				// Get the information for the dna
				DNA dna = (DNA) dnas.get(i);
				System.out.println("Getting X3D for DNA: " + dna.getComponentID());
				body += dna.getX3D(true);
			}		
		
		}
		

		body+= "<Viewpoint DEF='Viewpoint_DNAs'\n" +
				 "description='Viewpoint1'\n" +
				 "jump='true'\n" +
				 "fieldOfView='0.785'\n" +
				 "position='0.0 0.0 15.0'\n" +
				 "orientation='0 0 1 0'/>\n";
		
		
		//System.out.println("DNAs X3D: " + body);		
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
			
		
			if (canonicalName.equals(Constants.DNAs)) {				
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
	 * This method will return the X3D for the Nucleotides.  Each Nucleotide record from the database will yield
	 * a representation of the entire structure at the current level.
	 * 
	 ********************************************************************************************************************/
	public String getLocalX3DZ(BioMightTransform bioMightTransform, double angle, double nucleoAngle) 
	{
		angle=0;
		System.out.println("DNAs.getLocalX3DZ ()  " + bioMightTransform.getComponentName());	
		
		double radius = 0.5;
		double radiansAngle = Math.toRadians(nucleoAngle);
		String body = "";

		
		String componentTypeOut = "Adenine";
		body += "<Transform onmouseover=\"showComponent('Adenine');\" DEF='" + componentTypeOut + "'\n";
									
		body+= "rotation='" 	
				+ "0.00 , " + " "
				+ "1.00 , " + " "
				+ "0.00 , " + " "
				+ radiansAngle  + "'>\n";
		
		
		// Set up the base position
		double xBase = bioMightTransform.getTranslation().getXPos();
		double yBase = bioMightTransform.getTranslation().getYPos();
		double zBase = bioMightTransform.getTranslation().getZPos();
		body += BioWebDNA.getAdenine(bioMightTransform, radius, angle);

			
		// Set up the Ribose
		double x = xBase - 0.45;
		double y = yBase - 0.15;
		double z = zBase + 0.14;
	
		bioMightTransform.getTranslation().setXPos(x);
		bioMightTransform.getTranslation().setYPos(y);
		bioMightTransform.getTranslation().setZPos(z);
		body += BioWebDNA.getDeOxyRibose(bioMightTransform, radius, angle-72);
	
		
		// Set up the phosphate position
		x = xBase - 0.9;
		y = yBase + 0.33;
		z = zBase + 0.30;
	
		bioMightTransform.getTranslation().setXPos(x);
		bioMightTransform.getTranslation().setYPos(y);
		bioMightTransform.getTranslation().setZPos(z);
		body += BioWebDNA.getPhosphate(bioMightTransform, radius, angle);
		
		body += "</Transform>\n";
		

		//**************************************************
		// Draw the Bonded Pair A-T
		//*************************************************
		
		// Reset the origination point set in the data store
		bioMightTransform.getTranslation().setXPos(xBase);
		bioMightTransform.getTranslation().setYPos(yBase);
		bioMightTransform.getTranslation().setZPos(zBase);

		componentTypeOut = "Thymine";
		body += "<Transform onmouseover=\"showComponent('Thymine');\" DEF='" + componentTypeOut + "'\n";
		
		body+= "translation='" 	
				+ "1.0 , " + " "	
				+ "0.0 , " + " "
				+ "0.00   " + "'\n";
		
		body+= "rotation='" 	
				+ "0.00 , " + " "
				+ "1.00 , " + " "
				+ "0.00 , " + " "
				+ (radiansAngle+2.40)   + "'>\n";
		
		body += BioWebDNA.getThymine(bioMightTransform, radius, angle+72);
		
		
		// Set up the Ribose
		x = xBase - 0.43;
		y = yBase - 0.14;
		z = zBase + 0.17;
		
		bioMightTransform.getTranslation().setXPos(x);
		bioMightTransform.getTranslation().setYPos(y);
		bioMightTransform.getTranslation().setZPos(z);
		body += BioWebDNA.getDeOxyRibose(bioMightTransform, radius, angle-72);
	
		
		// Set up the phosphate position	
		 x = xBase - 0.87;
		 y = yBase + 0.33;
		 z = zBase + 0.35;
			
		bioMightTransform.getTranslation().setXPos(x);
		bioMightTransform.getTranslation().setYPos(y);
		bioMightTransform.getTranslation().setZPos(z);
		body += BioWebDNA.getPhosphate(bioMightTransform, radius, angle);

	
		body += "</Transform>\n";

		
		return (body);
	}

}
