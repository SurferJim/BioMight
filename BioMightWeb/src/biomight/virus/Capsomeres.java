package biomight.virus;

import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.naming.InitialContext;

import biomight.BioMightBase;
import biomight.Constants;
import biomight.ejb.BioMightBeanLocal;
import biomight.exceptions.DataSecurityException;
import biomight.exceptions.ServerException;
import biomight.view.BioMightMethodView;
import biomight.view.BioMightPropertyView;
import biomight.view.BioMightTransform;
import biomight.view.BioMightTransforms;



/***************************************************************************************
 * @author SurferJim
 *
 * CAPSOMERES
 * 
 * Creates a collection of Capsomeres that are arranged to compose a capsid.  The capsid
 * is the protein shell that of a virus.
 * 
 **************************************************************************************/

public class Capsomeres  extends BioMightBase{
	private ArrayList<Capsomer> capsomeres;	
	
	
	/********************************************************************************************************************
	 *  Capsomeres
	 * 
	 * This method will instantiate the Capsomeres that are defined for the current model.  
	 * 
	 ********************************************************************************************************************/

	public Capsomeres()
	{		
		create(Constants.CellRef, null);
	}
	
	/********************************************************************************************************************
	 *  Capsomeres
	 * 
	 * This method will instantiate the Capsomeres that are defined for the current model.  
	 * 
	 ********************************************************************************************************************/

	public Capsomeres(String parentID)
	{		
		create(parentID, null);
	}

	
	public Capsomeres(String parentID, ArrayList<BioMightMethodView> bioMightMethods)
	{		
		create(parentID, bioMightMethods);
	}
	
	
	/********************************************************************************************************************
	 * CREATE Capsomeres
	 * 
	 * This method will instantiate the Capsomeres that are defined for the current model.  
	 * 
	 ********************************************************************************************************************/

	private void create(String parentID, ArrayList<BioMightMethodView> bioMightMethods) {

		capsomeres = new ArrayList();
		
		// Get the information from the database via the Enterprise Bean		
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Getting CapsomeresInfo for ParentID: " + parentID);
			InitialContext ctx = new InitialContext();
			BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
			bioMightTransforms = bioMightBean.getComponents(Constants.CapsomeresRef, parentID);
			System.out.println("Have Capsomeres Info from EJB");   	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - Capsomeres");
			throw new ServerException("Remote Exception getComponents():", e); 	
		}
		
		// This is a collection, so set the parent of the children
		// to that of the aggregation object
		componentID = parentID;
		
		// Run through the collection of Capsomeres and build them into the model
		// In the Default case, we get two instances of the eys, one
		// positioned on the right and one positioned on the left
		ArrayList transforms = bioMightTransforms.getTransforms();
		System.out.println("Have Capsomeres Transforms : " + transforms.size());
		for (int i=0; i<transforms.size(); i++)
		{
			// Get the information for the endosome we are creating
			BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
			System.out.println("Creating Capsomere: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
			
			// Create an instance of the Capsomere for each tranform specified for the organism
			Capsomer capsomer = new Capsomer(Constants.CapsomerRef+":0", bioMightMethods);		
			System.out.println("Capsomer Created!: " + bioMightTransform.getName() + "  " + Constants.CapsomerRef+":0");
			capsomeres.add(capsomer);
			//String tempID = endosome.getComponentID();
			System.out.println("Add to Collection!: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());

			// initialize the Properties
			// in this case, rather than pass canonical name, we pass the name found in the collection
			initProperty(bioMightTransform.getName(), Constants.Capsomer, Constants.CapsomerRef, bioMightTransform.getId());
		}

		// Set up methods that will be available to the capsomeres
		initMethods();
	}
			

	public void initProperties() {
	
		BioMightPropertyView property = new BioMightPropertyView();
		property.setPropertyName("Capsomere");
		property.setCanonicalName(Constants.Capsomer);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("Capsomere");
		property.setCanonicalName(Constants.Capsomer);
		properties.add(property);
	}
	
	
	public void initMethods() {

		BioMightMethodView method;
		method = new BioMightMethodView();
		method.setMethodName("Set Membrane Width");
		method.setHtmlType("text");
		methods.add(method);
	}	

	/********************************************************************************************************************
	 * GET X3D
	 * 
	 * This method will return the X3D for the Capsomeres.  It runs through each of its components and collects up their
	 * representations and then assembles them into one unified X3D model.
	 * 
	 ********************************************************************************************************************/
		
	public String getX3D(boolean snipet)
	{
		
		String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
		"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n" +
		"<X3D profile='Immersive' >\n" +
		"<head>\n" +
		 "<meta name='BioMightImage' content='Capsomeres.jpg'/>\n" +
		 "<meta name='ExportTime' content='7:45:30'/>\n" +
		 "<meta name='ExportDate' content='7/17/2008'/>\n" +
		 "<meta name='BioMight Version' content='1.0'/>\n" + 
		 "<meta name='FluxStudioSource' content='Capsomeres.fxw'/>\n" +
		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='Capsomeres'\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		
		//System.out.println(header);	

		// Run Through the Collection of Capsomeres and get their X3D datum
		Capsomer capsomer;
		String body = "";
		System.out.println("Getting X3D for Capsomeres: " + this.capsomeres.size());
		for (int y=0; y<this.capsomeres.size(); y++)
		{					
			capsomer = (Capsomer) capsomeres.get(y);
			System.out.println("Getting X3D for Capsomere: " + y);
			body += capsomer.getX3D(true);
		}
		System.out.println("Capsomeres: " + body);
		
			String footer = "</Scene>\n" + "</X3D>\n";
			//System.out.println(footer);

			if (snipet)
				return body;			
			else	
				return header + body + footer;
	}
	
	
	/*
	 * Returns the collection of Capsomeres for
	 */
	public ArrayList getCapsomeres() {
		return capsomeres;
	}


	/*
	 * Increase or decrease the number of capsomeres in the collection
	 * based on the number of elements specified.
	 * 
	 */
	
	/***********************************************************************
	 * Constructor that creates the specified number of Capsomeres and distributes them 
	 * throughout the Cell
	
	 	public void setCapsomeres(int numElements, BioMightPositions positions) {
		
		System.out.println("Creating a collection of Capsomeres: " + numElements);
		System.out.println("Current Size is : " + numElements);
		System.out.println("Collection Size is : " + capsomeres.size());
		this.numElements = capsomeres.size();
		System.out.println("Current Size is : " + numElements);
		
		// If the number requested equals the current number of elements, just return
		//if (numElements == this.numElements)
		//	return;
		
		// If more are requested, then increase the number of Capsomeres
		// by that amount.  We always add or subtract from the group, we do
		// not wipe out an regenerate.
		if (numElements > this.numElements)
		{
			System.out.println("Need to create more");
			// Create a distribution pattern for the collection of capsomeres
			int numCapsomeres = numElements;
				
			// Create the Capsomeres and set their base positions using the
			// distribution map
			System.out.println("Creating New Ones : " + numCapsomeres);
			for (int i=0; i<numCapsomeres; i++)
			{
				Capsomere endosome = new Capsomere();
				endosome.setBioMightPosition(positions.getBioMightPosition(i));
				this.capsomeres.add(i, endosome);
				System.out.println("Created Capsomere: " + i);
			}
			// increment the current count of capsomeres
			numElements += numCapsomeres;			
			
		}
		else
		{
			System.out.println("We have to subtract!");
		}
	}
	 	
	 	
	public Capsomeres(int numElements, BioMightPositions positions) {
		this.setImage("images/Capsomeres.jpg");
		properties = new ArrayList<BioMightPropertyView>();
		methods = new ArrayList<BioMightMethodView>();;	
		initProperties();
		initMethods();
		System.out.println("Capsomeres - Properties and Methods are initialized...");
		
		// Create the Capsomeres and set their base positions using the
		// distribution map
		capsomeres = new ArrayList<Capsomere>();
		for (int i=0; i<numElements; i++)
		{
			// Create the capsomeres using the generated positions
			Capsomere endosome = new Capsomere(positions.getBioMightPosition(i));
			System.out.println("Constr - Created Capsomere with PositionX: " + positions.getBioMightPosition(i).getXPos());
			System.out.println("Constr - Created Capsomere with PositionY: " + positions.getBioMightPosition(i).getYPos());
			System.out.println("Constr - Created Capsomere with PositionZ: " + positions.getBioMightPosition(i).getZPos());
			capsomeres.add(i, capsomere);
		}
		
		this.numElements=numElements;
		System.out.println("Capsomeres Constructor complete...");		
	}
	******************************************************/
	
}