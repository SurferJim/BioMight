/*
* Created on Jul 11, 2006
*
* BioMight Component Class - Feb 2007
*
*/
package biomight.system.skeletal.ribs;
import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;



import biomight.Constants;
import biomight.ejb.BioMightBeanLocal;
import biomight.exceptions.DataSecurityException;
import biomight.exceptions.ServerException;
import biomight.system.skeletal.spine.LumbarVertebra;
import biomight.system.tissue.connective.bone.Bone;
import biomight.view.BioMightMethodView;
import biomight.view.BioMightPosition;
import biomight.view.BioMightPropertyView;
import biomight.view.BioMightTransform;
import biomight.view.BioMightTransforms;

/**
* @author SurferJim
*
* BioMight Component Class - Feb 2007
*
*/
public class TrueRibs extends Bone {
	private BioMightTransforms bioMightTransforms;
	private ArrayList<BioMightPropertyView> properties;
	private ArrayList<BioMightMethodView> methods;
	
	
	private Rib rib; 
	private ArrayList trueRibs;
	
	
	private LeftRib1 leftRib1;
	private LeftRib2 leftRib2;
	private LeftRib3 leftRib3;
	private LeftRib4 leftRib4;
	private LeftRib5 leftRib5;
	private LeftRib6 leftRib6;	
	private LeftRib7 leftRib7;	

	private RightRib1 rightRib1;
	private RightRib2 rightRib2;
	private RightRib3 rightRib3;
	private RightRib4 rightRib4;
	private RightRib5 rightRib5;
	private RightRib6 rightRib6;
	private RightRib7 rightRib7;
	
	
		
	public TrueRibs()
	{
		create(Constants.LumbarVertebraeRef, null);
	}

	
	public TrueRibs(String parentID)
	{
		create(parentID, null);
	}
	
	
	public TrueRibs(String parentID, ArrayList<BioMightMethodView> bioMightMethods)
	{
		create(parentID, bioMightMethods);
	}
	
	
	/*******************************************************
	 * CREATE
	 * 
	 * Create a 3D model of the True Ribs
	 * 
	 *******************************************************/

	public void create(String parentID, ArrayList<BioMightMethodView> bioMightMethods)
	{
		this.setImage("images/LumbarVertebra.jpg");
		this.setImageHeight(300);
		this.setImageWidth(300);
		trueRibs = new ArrayList();
		
		// Get the information from the database via the Enterprise Bean		
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Getting TrueRibsInfo for ParentID: " + parentID);
			Context ctx = new InitialContext(); 
			BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
			bioMightTransforms = bioMightBean.getComponents(Constants.TrueRibsRef, parentID);
			System.out.println("Have TrueRibs Info from EJB");   	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - TrueRibs");
			throw new ServerException("Remote Exception getComponents():", e); 	
		}
			
		// Run through Forehead and build them into the model
		ArrayList transforms = bioMightTransforms.getTransforms();
		System.out.println("TrueRibs NumTransforms: " + transforms.size());
		for (int i=0; i<transforms.size(); i++)
		{
			// Get the information for the Forehead we are creating
			BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
			System.out.println("Creating TrueRibs (name,id): " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
			
			
			/*
			// Create the Left ribs
			leftRib1 = new LeftRib1(bioMightPosition);
			leftRib2 = new LeftRib2(bioMightPosition);
			leftRib3 = new LeftRib3(bioMightPosition);
			leftRib4 = new LeftRib4(bioMightPosition);
			leftRib5 = new LeftRib5(bioMightPosition);
			leftRib6 = new LeftRib6(bioMightPosition);
			leftRib7 = new LeftRib7(bioMightPosition);	
		
			// Create the Left ribs
			rightRib1 = new RightRib1(bioMightPosition);
			rightRib2 = new RightRib2(bioMightPosition);
			rightRib3 = new RightRib3(bioMightPosition);
			rightRib4 = new RightRib4(bioMightPosition);
			rightRib5 = new RightRib5(bioMightPosition);
			rightRib6 = new RightRib6(bioMightPosition);
			rightRib7 = new RightRib7(bioMightPosition);	
			*/
			
			
			// Create an instance of the Vertebra based on information in the repository
			rib = null;  // new LumbarVertebra(bioMightTransform.getId());
			System.out.println("LumbarVertebra created");	
			trueRibs.add(i, rib);
			System.out.println("LumbarVertebra added to Collection");			
		}	
		

		initProperties();
		initMethods();
	}
	
	
	public void initProperties() {

		properties = new ArrayList<BioMightPropertyView>();
		
		// Observable
		BioMightPropertyView property = new BioMightPropertyView();
		property.setPropertyName("Common");
		property.setCanonicalName(Constants.Title);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("True Ribs");
		property.setCanonicalName(Constants.TrueRibs);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("False Ribs");
		property.setCanonicalName(Constants.FalseRibs);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("Floating Ribs");
		property.setCanonicalName(Constants.FloatingRibs);
		properties.add(property);		
	}
	
	
	public void initMethods() {

		methods = new ArrayList<BioMightMethodView>();
		
		BioMightMethodView method = new BioMightMethodView();

		method = new BioMightMethodView();
		method.setMethodName("Crack");
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
		
		// Assemble the RibCage
		String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
		"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n " +
		"<X3D profile='Immersive' >\n" +
		"<head>\n" +
		 "<meta name='BioMightImage' content='RibCage.jpg'/>\n" +
		 "<meta name='ExportTime' content='7:45:30'/>\n" +
		 "<meta name='ExportDate' content='08/15/2008'/>\n" +
		 "<meta name='BioMight Version' content='1.0'/>\n" + 
		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='RibCage'\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		

		String body =   
			leftRib1.getX3D(true) + 
			leftRib2.getX3D(true) + 
			leftRib3.getX3D(true) + 
			leftRib4.getX3D(true) + 
			leftRib5.getX3D(true) + 
			leftRib6.getX3D(true) + 
			leftRib7.getX3D(true) + 
			rightRib1.getX3D(true) +
			rightRib2.getX3D(true) +
			rightRib3.getX3D(true) +
			rightRib4.getX3D(true) +
			rightRib5.getX3D(true) +
			rightRib6.getX3D(true) +
			rightRib7.getX3D(true);
		
		System.out.println("True Ribs X3D: " + body);		
		
		String footer = "</Scene>" + "</X3D>\n";
		
		if (snipet)
			return body;			
		else	
			return header + body + footer;
	}
	
	
}
