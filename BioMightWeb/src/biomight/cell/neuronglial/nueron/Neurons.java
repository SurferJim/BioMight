/*
 * Created on Sep 26, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.cell.neuronglial.nueron;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;

import javax.naming.InitialContext;

import biomight.BioMightBase;
import biomight.Constants;
import biomight.ejb.BioMightBeanLocal;
import biomight.ejb.BioMightCellularBeanLocal;
import biomight.exceptions.ServerException;
import biomight.view.BioMightMaterial;
import biomight.view.BioMightMethodView;
import biomight.view.BioMightOrientation;
import biomight.view.BioMightPosition;
import biomight.view.BioMightPropertyView;
import biomight.view.BioMightTransform;
import biomightweb.util.BioWebX3DUtils;
import biomightweb.view.BioMightRange;

/*************************************************************************************
 * @author SurferJim
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 *************************************************************************************/

public class Neurons  extends BioMightBase {
	private ArrayList neurons;
	
		
	/********************************************************************************************************************
	 *  Neurons
	 * 
	 * This method will instantiate the Neurons that are defined for the current model.  
	 * 
	 ********************************************************************************************************************/
	
	public Neurons()
	{		
		int localVP= Constants.BIO_CHILD;
		int localLOD = Constants.VIEW_HAWKEYE;
		create(localVP, localLOD, Constants.CellsRef, null, null);
	}
	
	/********************************************************************************************************************
	 *  Neurons
	 * 
	 * This method will instantiate the Neurons that are defined for the current model.  
	 * 
	 ********************************************************************************************************************/
	
	public Neurons(String parentID)
	{				
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, parentID, null, null);
	}
	
	
	public Neurons(int localVP, int localLOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
	{		
		create(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);
	}
	
	
	/********************************************************************************************************************
	 * CREATE Neurons
	 * 
	 * This method will instantiate the hips that are defined for the current model.  
	 * 
	 ********************************************************************************************************************/

	private void create(int localVP, int localLOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods) 
	{		
		this.setImage("images/Neurons.jpg");
		
		neurons = new ArrayList();
	
		// This is a collection, so set the parent of the children
		// to that of the aggregation object
		this.parentID=parentID;
		this.componentID = parentID;

		
		if (bioMightMethods != null){
			System.out.println("EXECUTING Neurons Methods: " + bioMightMethods.size());
			executeMethods(bioMightMethods);
		}
		
		// Get the information from the database via the Enterprise Bean.  This will get
		// a collection of Neurons
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Getting Neurons Transform: " + componentID + "   " +  parentID);
			InitialContext ctx = new InitialContext();
			BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
			bioMightTransforms = bioMightBean.getComponents(Constants.NeuronRef, parentID);
			System.out.println("Have Neurons Info from EJB");   	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - Neurons");
			throw new ServerException("Remote Exception getComponents():", e); 	
		}
		
		
		// Run through the collection of neurons and build them into the model
		ArrayList transforms = bioMightTransforms.getTransforms();
		System.out.println("Have neurons NumTransforms: " + transforms.size());
		for (int i=0; i<transforms.size(); i++)
		{
			// Get the information for the neuron we are creating
			BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
			System.out.println("Creating Neuron: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
			
			// Create an instance of a Neuron for each tranform specified
			int LOD = Constants.VIEW_INTERNAL;
			Neuron neuron = new Neuron(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);		
			System.out.println("Neuron Created!: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
			neurons.add(neuron);
			System.out.println("Add Neuron to Collection!: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());

			// initialize the Properties
			// in this case, rather than pass canonical name, we pass the name found in the collection
			initProperty(bioMightTransform.getName(), Constants.Neuron, Constants.NeuronRef, bioMightTransform.getId());
		}

		// Set up methods that will be available to the neurons
		initMethods();
	}
	
	
	public void initMethods() {
			
		BioMightMethodView method = new BioMightMethodView();
		method.setCanonicalName(Constants.Neurons);
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
		
		// Assemble the Neurons
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
		"title='Neurons'\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		

		String body = ""; 
		System.out.println("Assembling X3D for Neurons - size: " + neurons.size());

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
				System.out.println("Getting X3D INTERNAL for Neuron: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());				

				//System.out.println("Getting X3D for NeuronX: " + bioMightTransform.getTranslation().getXPos());
				//System.out.println("Getting X3D for NeuronY: " + bioMightTransform.getTranslation().getYPos());
				//System.out.println("Getting X3D for NeuronZ: " + bioMightTransform.getTranslation().getZPos());
				// Change the height and width based on the displacement.

				double radius = bioMightTransform.getRadius();
				bioMightTransform.setComponentName("Cell Membrane");
				bioMightTransform.setTextureID(5);
				bioMightTransform.setTextureFile("SpeckledCyan.png");
				body += BioWebX3DUtils.generateSphereSimple(bioMightTransform);

				
				bioMightTransform.setComponentName("Nucleus");
				bioMightTransform.setTextureID(5);
				bioMightTransform.setTextureFile("SpeckledSlateBlue.png");
				bioMightTransform.setRadius(bioMightTransform.getRadius()/2.5);
				body += BioWebX3DUtils.generateSphereSimple(bioMightTransform);
				bioMightTransform.setRadius(radius);
				
				
				// Define the range where the Dendrites will be created
				ArrayList ranges = new ArrayList();
				BioMightPosition bioMightPosition = new BioMightPosition(0.0, 0, 0);
				BioMightOrientation bioMightOrientation = new BioMightOrientation(0, 0, 1, 90);
		
				double maxWidth = 0.035;
				double maxHeight = 0.3;
		
				BioMightRange bioRange = new BioMightRange(25, 5, 5, 5, 5,  0,  maxWidth, 0, maxHeight);
				maxWidth = 0.035;
				maxHeight = 0.3;

				bioMightTransform.setTextureID(5);
				bioMightTransform.setTextureFile("PowderBlue.png");
				bioMightTransform.setTranslation(bioMightPosition);
				bioMightTransform.setComponentName("Dendrite");
			    body+= BioWebX3DUtils.generateDendrites(bioMightTransform, bioRange);
			    
				body +=  BioWebX3DUtils.generateAxon(bioMightTransform, bioMightPosition, bioMightOrientation);	
	
				bioMightTransform.setComponentName("Myelin Sheath");
				bioMightTransform.setTextureID(5);
				bioMightTransform.setTextureFile("PowderBlue.png");
				//BioMightMaterial material = new BioMightMaterial();
				//bioMightTransform.setMaterial(material);
				body +=  BioWebX3DUtils.generateMyelin(bioMightTransform, bioMightPosition, bioMightOrientation);							
			
				bioMightTransform.setComponentName("Schwann Cell");
				bioMightTransform.setTextureID(5);
				bioMightTransform.setTextureFile("SpeckledRed.png");
				body +=  BioWebX3DUtils.generateSchwannCells(bioMightTransform, bioMightPosition, bioMightOrientation);							
			
				
				bioMightTransform.setComponentName("Terminal Bouton");
				bioMightTransform.setTextureID(5);
				bioMightTransform.setTextureFile("StaphylococcusAureus.png");
				body +=  BioWebX3DUtils.generateBoutons(bioMightTransform, bioMightPosition, bioMightOrientation);	
				    
			}
		}			
		else
		{
			// Run through the collection of Neurons and assemble the X3D for each
			for (int i=0; i<neurons.size(); i++)
			{
				// Get the information for the neuron
				Neuron neuron = (Neuron) neurons.get(i);
				System.out.println("Getting X3D for Neuron: " + neuron.getComponentID());
				body += neuron.getX3D(true);
			}		
		
		}
		
		
		
		body+= "<Viewpoint DEF='Viewpoint_Neuron'\n" +
				 "description='Viewpoint1'\n" +
				 "jump='true'\n" +
				 "fieldOfView='0.785'\n" +
				 "position='0.0 0.0 10.0'\n" +
				 "orientation='0 0 1 0'/>\n";
		
		//System.out.println("Neurons X3D: " + body);		
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
		System.out.println("Neurons-Executing Methods: " + bioMightMethods.size());
		for (int j=0; j<bioMightMethods.size(); j++){
			
			// Get the parameter from the list and if it is not
			// empty execute the associated method using it
			BioMightMethodView bioMightMethod = (BioMightMethodView) bioMightMethods.get(j);
			System.out.println("Have BioMightMethod for Neurons: " + bioMightMethod.getMethodName());	
			String methodName = bioMightMethod.getMethodName();
			String canonicalName = bioMightMethod.getCanonicalName(); 
			String dataType = bioMightMethod.getDataType();
			String methodParam = bioMightMethod.getMethodParameter(); 
			if (methodParam == null)
				methodParam = "";
			
			// We only execute those methods that are targeted for the IRIS
			// If a parameter is specified then we fire the method, otherwise
			// we just jump over it
			if (canonicalName.equals(Constants.Neurons)) {				
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
				System.out.println("Neurons - Methods have fired.   Calling Neurons Save method!");
			}
		}
	}

	

	/******************************************************************************************
	 * SET COLONY SIZE 
	 *
	 * This method will set the Colony size for the Neurons.  
	 *****************************************************************************************/
	public void setColonySize(int size) {

		// Run through the argument list and executes the 
		// associated methods
		boolean fired = false;
		System.out.println("Neurons-Executing Methods: " + size);
		
		// Generate the Neuron		
		BioMightCellularBeanLocal bioMightBean;
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Generating the Neuron Colony: " + componentID + "    " + parentID);
			InitialContext ctx = new InitialContext();
			bioMightBean = (BioMightCellularBeanLocal) ctx.lookup("java:global/BioMightWeb/BioMightCellularBean!biomight.ejb.BioMightCellularBeanLocal");
			 
			
			double currentPoints[][] = null;
			int success = 0; //bioMightBean.generateNeurons(size, "Neuron:00001", "Neuron", 
				//"Neuron", this.componentID, this.parentID, currentPoints);
			
			System.out.println("Created Neuron Info using EJB");   	
		}catch (Exception e) { 
			System.out.println("Exception Creating Colony - Neuron");
			throw new ServerException("Remote Exception NeuronEpithelium():", e); 	
		}
	}
	
}
