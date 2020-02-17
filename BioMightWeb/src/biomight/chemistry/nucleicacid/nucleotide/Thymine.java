/*
 * Created on May 5, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.chemistry.nucleicacid.nucleotide;

import java.util.ArrayList;

import javax.naming.InitialContext;

import biomight.Constants;
import biomight.chemistry.elements.*;
import biomight.ejb.BioMightBeanLocal;
import biomight.ejb.BioMightDNABeanLocal;
import biomight.exceptions.ServerException;
import biomight.view.BioMightMethodView;
import biomight.view.BioMightPosition;
import biomight.view.BioMightPropertyView;
import biomight.view.BioMightScale;
import biomight.view.BioMightTransform;
import biomightweb.util.BioWebDNA;

/**
 * @author SurferJim
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class Thymine extends Nucleotide {

	private Carbon carbon1;
	private Carbon carbon2;
	private Carbon carbon3;
	private Carbon carbon4;
	private Carbon carbon5;

	private Hydrogen hydrogen1;
	private Hydrogen hydrogen2;
	private Hydrogen hydrogen3;
	private Hydrogen hydrogen4;
	private Hydrogen hydrogen5;
	private Hydrogen hydrogen6;	
		
	private Nitrogen nitrogen1;
	private Nitrogen nitrogen2;
	
	private Oxygen oxygen1;
	private Oxygen oxygen2;	
	
	

	public Thymine()
	{		
		// Create the Base Thymine
		int localVP =  Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG2X;
		create(localVP, localLOD, Constants.ThymineRef, null, null);
	}
	
	public Thymine(String parentID)
	{				
		int localVP =  Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG2X;
		create(localVP, localLOD, parentID, null, null);	
	}
		

	public Thymine(String parentID, BioMightPosition bioMightPosition)
	{
		int localVP =  Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG2X;
		create(localVP, localLOD, parentID, null, null);
		//BioMightPosition bioMightPosition = bioMightPosition;
	}
	
	
	// When we are drilling into the component from the View Page, we will set
	// the LOD to HAWK-EYE, which means fine detail.
	public Thymine(String parentID, ArrayList<BioMightMethodView> bioMightMethods)
	{		
		int localVP =  Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG2X;
		create(localVP, localLOD,  parentID, null, bioMightMethods);	
	}
		
	// We are looking at the object from a collection.  It was created via
	// the Thymines parent object and we do not have  to go to the database 
	// to get additional informaion
	public Thymine(int localVP, int localLOD, String parentID, ArrayList<BioMightMethodView> bioMightMethods)
	{				
		create(localVP, localLOD, parentID, null, bioMightMethods);	
	}
	
	public Thymine(int localVP, int localLOD, String parentID,  ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
	{		
		localVP =  Constants.VIEW_DETACHED;
		localLOD = Constants.MAG1X;		
		create(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);
	}
	
	public void create(int localVP, int localLOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
	{
			this.setImage("images/Thymine.jpg");
			this.setImageHeight(300);
			this.setImageWidth(300);
			this.parentID = parentID;
			this.lod = localLOD;
			this.viewPerspective = localVP;
			
			// There are 4 modes in which this object will be created
			// 1 - Being instantiated as part of a collection.
			// 2 - Being instantiated when drilling down from a collection, will need to get component by ID
			// 3 - Need level of detail to determine if aggregated, or get current level
			// 4 - 
			if (localVP == Constants.VIEW_INTERNAL)			
			{
				this.componentID = parentID;

				// Do nothing.  We are instantiating as part of a collection  
				// There is no drill down, so we use the transforms that the
				// parent has already collected
				System.out.println("In Thymine Create() - ViewInternal - Gathered by parent: " + parentID);				
				
				// We already have the data for the current instance of Thymine,
				// Go get the details for the current Thymine is LOD is set
				if (localLOD == Constants.MAG2X)
				{
					// Go get the finer details of the Thymine				
					System.out.println("Thymine Create - ViewInternal - MAG2X: " + parentID);				
					localVP = Constants.VIEW_INTERNAL; 
					localLOD = Constants.MAG1X;
					
					// Create the Thymine components
					//carbon = new Carbon(localVP, localLOD, componentID, bioMightMethods);									
					//System.out.println("Thymine Instance created from SubComponents : " + parentID);
					//initProperty(bioMightTransform.getName(), Constants.Carbon, Constants.CarboneRef, bioMightTransform.getId());
				}
			
			}
			else if (localVP == Constants.VIEW_DETACHED)
			{	
				this.componentID = parentID;
				System.out.println("In Thymine Create() - ViewDetached - Gather now by parent: " + parentID);				
				
				
				// Generate the Thymine that the user desires if needed 
				boolean bGenerate = true;
				if (bGenerate) {
					generate(parentID, componentID);
				}
				
				// Get the information from the database via the Enterprise Bean.  This will get
				// a collection of Thymine
				try {
					// Get the information from the database via the Enterprise Bean		
					System.out.println("Getting Thymine -Detached - Transform: " + componentID + "   " +  parentID);
					InitialContext ctx = new InitialContext();
					BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
					bioMightTransforms = bioMightBean.getComponents(Constants.ThymineRef, parentID);   	
				}catch (Exception e) { 
					System.out.println("Exception Getting Components - Thymine");
					throw new ServerException("Remote Exception getComponents():", e); 	
				}
						
				// Run through the collection of nucleobases and build them into the model
				ArrayList transforms = bioMightTransforms.getTransforms();
				System.out.println("Have Thymine NumTransforms: " + transforms.size());
				
				// If we are culling the data set
				int numRetreive=transforms.size();
				
				// There should be only 1
				for (int i=0; i<transforms.size(); i++)
				{
					// Get the information for the nucleobase we are creating
					BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
					System.out.println("Creating Thymine: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
					this.componentID = bioMightTransform.getId();
					
				
					if (localLOD == Constants.MAG1X)
					{
						System.out.println("Thymine Detached - 1x View - parent : " + parentID + " lod: " + localLOD);
						// initialize the Properties
						initProperties();
					}
					else if (localLOD == Constants.MAG2X)
					{
						// Go get the finer details of the Thymine				
						System.out.println("Thymine Detached - 2x View Creating SubComponents : " + parentID + " lod: " + localLOD);
						localVP = Constants.VIEW_HAWKEYE; 
						localLOD = Constants.MAG1X;

						System.out.println("Creating Carbon1 : " + parentID + " lod: " + localLOD);
						carbon1 = new Carbon(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
						initProperty(Constants.CarbonRef, Constants.Carbon, Constants.CarbonRef, carbon1.getComponentID());
						System.out.println("Carbon1 is complete");
			
						System.out.println("Creating Carbon2 : " + parentID + " lod: " + localLOD);
						carbon2 = new Carbon(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
						initProperty(Constants.CarbonRef, Constants.Carbon, Constants.CarbonRef, carbon2.getComponentID());
						System.out.println("Carbon2 is complete");
		
						System.out.println("Creating Carbon3 : " + parentID + " lod: " + localLOD);
						carbon3 = new Carbon(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
						initProperty(Constants.CarbonRef, Constants.Carbon, Constants.CarbonRef, carbon3.getComponentID());
						System.out.println("Carbon3 is complete");
		
						System.out.println("Creating Carbon4 : " + parentID + " lod: " + localLOD);
						carbon4 = new Carbon(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
						initProperty(Constants.CarbonRef, Constants.Carbon, Constants.CarbonRef, carbon4.getComponentID());
						System.out.println("Carbon4 is complete");
					
						System.out.println("Creating Carbon5 : " + parentID + " lod: " + localLOD);
						carbon5 = new Carbon(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
						initProperty(Constants.CarbonRef, Constants.Carbon, Constants.CarbonRef, carbon5.getComponentID());
						System.out.println("Carbon5 is complete");
					
						System.out.println("Creating Hydrogen1 : " + parentID + " lod: " + localLOD);
						hydrogen1 = new Hydrogen(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
						initProperty(Constants.HydrogenRef, Constants.Hydrogen, Constants.HydrogenRef, hydrogen1.getComponentID());
						System.out.println("Hydrogen1 is complete");
			
						System.out.println("Creating Hydrogen2 : " + parentID + " lod: " + localLOD);
						hydrogen2 = new Hydrogen(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
						initProperty(Constants.HydrogenRef, Constants.Hydrogen, Constants.HydrogenRef, hydrogen2.getComponentID());
						System.out.println("Hydrogen2 is complete");
			
						System.out.println("Creating Hydrogen3 : " + parentID + " lod: " + localLOD);
						hydrogen3 = new Hydrogen(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
						initProperty(Constants.HydrogenRef, Constants.Hydrogen, Constants.HydrogenRef, hydrogen3.getComponentID());
						System.out.println("Hydrogen3 is complete");
			
						System.out.println("Creating Hydrogen4 : " + parentID + " lod: " + localLOD);
						hydrogen4 = new Hydrogen(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
						initProperty(Constants.HydrogenRef, Constants.Hydrogen, Constants.HydrogenRef, hydrogen4.getComponentID());
						System.out.println("Hydrogen4 is complete");
			
						System.out.println("Creating Hydrogen5 : " + parentID + " lod: " + localLOD);
						hydrogen5 = new Hydrogen(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
						initProperty(Constants.HydrogenRef, Constants.Hydrogen, Constants.HydrogenRef, hydrogen2.getComponentID());
						System.out.println("Hydrogen5 is complete");
			
						System.out.println("Creating Hydrogen6 : " + parentID + " lod: " + localLOD);
						hydrogen6 = new Hydrogen(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
						initProperty(Constants.HydrogenRef, Constants.Hydrogen, Constants.HydrogenRef, hydrogen6.getComponentID());
						System.out.println("Hydrogen6 is complete");
			
					
						System.out.println("Creating Oxygen1: " + parentID + " lod: " + localLOD);
						oxygen1 = new Oxygen(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
						initProperty(Constants.OxygenRef, Constants.Oxygen, Constants.OxygenRef, oxygen1.getComponentID());
						System.out.println("Oxygen1 is complete");
						
						System.out.println("Creating Oxygen2: " + parentID + " lod: " + localLOD);
						oxygen2 = new Oxygen(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
						initProperty(Constants.OxygenRef, Constants.Oxygen, Constants.OxygenRef, oxygen2.getComponentID());
						System.out.println("Oxygen2 is complete");

								}
					
					
				}			

				// Set up methods that will be available to the nucleobases
				initMethods();
		
			}				
			else if (localVP == Constants.VIEW_HAWKEYE)
			{
				// This is when one is accessing a Thymine directly
				// Get the information from the database via the Enterprise Bean		
				try {
					// Get the information from the database via the Enterprise Bean		
					System.out.println("Thymine Create() -HawkEye - Gather data from : " + parentID);
					InitialContext ctx = new InitialContext();
					BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
					bioMightTransforms = bioMightBean.getComponent(parentID);
					System.out.println("Have Thymine Info from EJB");   	
				}catch (Exception e) { 
					System.out.println("Exception Getting Components - Thymine");
					throw new ServerException("Remote Exception getComponents():", e); 	
				}
					
				// Run through the collection of Thymines and build them into the model
				// In the default case, we get one instance of the Thymine for each eye
				ArrayList transforms = bioMightTransforms.getTransforms();
				System.out.println("Thymine NumTransforms: " + transforms.size());
				for (int i=0; i<transforms.size(); i++)
				{
					// Get the information for the Thymine
					BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
					System.out.println("Creating Thymine: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
					this.componentID = bioMightTransform.getId();

					if (localLOD == Constants.MAG1X)
					{
						// initialize the Properties
						System.out.println("Creating Thymine at MAG1X : " + parentID);
						initProperties();
					}
					if (localLOD == Constants.MAG2X)
					{
						// Go get the finer details of the Thymine				
						System.out.println("Creating Thymine at MAG2X : " + parentID);
						localVP = Constants.VIEW_HAWKEYE; 
						localLOD = Constants.MAG1X;

						System.out.println("Creating Carbon1 : " + parentID + " lod: " + localLOD);
						carbon1 = new Carbon(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
						initProperty(Constants.CarbonRef, Constants.Carbon, Constants.CarbonRef, carbon1.getComponentID());
						System.out.println("Carbon1 is complete");
			
						System.out.println("Creating Carbon2 : " + parentID + " lod: " + localLOD);
						carbon2 = new Carbon(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
						initProperty(Constants.CarbonRef, Constants.Carbon, Constants.CarbonRef, carbon2.getComponentID());
						System.out.println("Carbon2 is complete");
		
						System.out.println("Creating Carbon3 : " + parentID + " lod: " + localLOD);
						carbon3 = new Carbon(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
						initProperty(Constants.CarbonRef, Constants.Carbon, Constants.CarbonRef, carbon3.getComponentID());
						System.out.println("Carbon3 is complete");
		
						System.out.println("Creating Carbon4 : " + parentID + " lod: " + localLOD);
						carbon4 = new Carbon(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
						initProperty(Constants.CarbonRef, Constants.Carbon, Constants.CarbonRef, carbon4.getComponentID());
						System.out.println("Carbon4 is complete");
					
						System.out.println("Creating Carbon5 : " + parentID + " lod: " + localLOD);
						carbon5 = new Carbon(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
						initProperty(Constants.CarbonRef, Constants.Carbon, Constants.CarbonRef, carbon5.getComponentID());
						System.out.println("Carbon5 is complete");
					
						System.out.println("Creating Hydrogen1 : " + parentID + " lod: " + localLOD);
						hydrogen1 = new Hydrogen(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
						initProperty(Constants.HydrogenRef, Constants.Hydrogen, Constants.HydrogenRef, hydrogen1.getComponentID());
						System.out.println("Hydrogen1 is complete");
			
						System.out.println("Creating Hydrogen2 : " + parentID + " lod: " + localLOD);
						hydrogen2 = new Hydrogen(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
						initProperty(Constants.HydrogenRef, Constants.Hydrogen, Constants.HydrogenRef, hydrogen2.getComponentID());
						System.out.println("Hydrogen2 is complete");
			
						System.out.println("Creating Hydrogen3 : " + parentID + " lod: " + localLOD);
						hydrogen3 = new Hydrogen(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
						initProperty(Constants.HydrogenRef, Constants.Hydrogen, Constants.HydrogenRef, hydrogen3.getComponentID());
						System.out.println("Hydrogen3 is complete");
			
						System.out.println("Creating Hydrogen4 : " + parentID + " lod: " + localLOD);
						hydrogen4 = new Hydrogen(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
						initProperty(Constants.HydrogenRef, Constants.Hydrogen, Constants.HydrogenRef, hydrogen4.getComponentID());
						System.out.println("Hydrogen4 is complete");
			
						System.out.println("Creating Hydrogen5 : " + parentID + " lod: " + localLOD);
						hydrogen5 = new Hydrogen(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
						initProperty(Constants.HydrogenRef, Constants.Hydrogen, Constants.HydrogenRef, hydrogen5.getComponentID());
						System.out.println("Hydrogen5 is complete");
			
						System.out.println("Creating Hydrogen6 : " + parentID + " lod: " + localLOD);
						hydrogen6 = new Hydrogen(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
						initProperty(Constants.HydrogenRef, Constants.Hydrogen, Constants.HydrogenRef, hydrogen6.getComponentID());
						System.out.println("Hydrogen6 is complete");
			
						
						System.out.println("Creating Oxygen1: " + parentID + " lod: " + localLOD);
						oxygen1 = new Oxygen(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
						initProperty(Constants.OxygenRef, Constants.Oxygen, Constants.OxygenRef, oxygen1.getComponentID());
						System.out.println("Oxygen1 is complete");
						
						System.out.println("Creating Oxygen2: " + parentID + " lod: " + localLOD);
						oxygen2 = new Oxygen(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
						initProperty(Constants.OxygenRef, Constants.Oxygen, Constants.OxygenRef, oxygen2.getComponentID());
						System.out.println("Oxygen2 is complete");
		
					}
					
				}
			}		
			else
			{
				
			}
				
			initMethods();
			
			System.out.println("CreateThymine Completed");
			
			// First, get all the data from the database
			// Apply the methods to it
			// Save its state
			this.parentID = parentID;
			if (bioMightMethods != null){
				System.out.println("EXECUTING Thymine Methods: " + bioMightMethods.size());
				//executeMethods(bioMightMethods);
			}
		}
		

	
		private void initProperties() {
			
			String dimensions = "0.00, 0.00, 0.00";
			String bioPos = "0.00, 0.00, 0.00";
			BioMightScale bioScale = new BioMightScale("0.00, 0.00, 0.00");
			BioMightPosition bioPosition = new BioMightPosition("0.00, 0.00, 0.00");	
			
			System.out.println("Thymine InitProperties: " + componentID);
			
			initProperty(Constants.NOT_ACTIVATED, Constants.Title, Constants.Title, "", bioPosition, bioScale, Constants.SINGLE_COMPONENT, "", false);

			initProperty("C1", Constants.Carbon, Constants.CarbonRef, componentID, bioPos, dimensions, Constants.SINGLE_COMPONENT, false);
			initProperty("C2", Constants.Carbon, Constants.CarbonRef, componentID, bioPos, dimensions, Constants.SINGLE_COMPONENT, false);
			initProperty("C3", Constants.Carbon, Constants.CarbonRef, componentID, bioPos, dimensions, Constants.SINGLE_COMPONENT, false);
			initProperty("C4", Constants.Carbon, Constants.CarbonRef, componentID, bioPos, dimensions, Constants.SINGLE_COMPONENT, false);
			initProperty("C5", Constants.Carbon, Constants.CarbonRef, componentID, bioPos, dimensions, Constants.SINGLE_COMPONENT, false);

			initProperty("H1", Constants.Hydrogen, Constants.HydrogenRef, componentID, bioPos, dimensions, Constants.SINGLE_COMPONENT, false);				
			initProperty("H2", Constants.Hydrogen, Constants.HydrogenRef, componentID, bioPos, dimensions, Constants.SINGLE_COMPONENT, false);				
			initProperty("H3", Constants.Hydrogen, Constants.HydrogenRef, componentID, bioPos, dimensions, Constants.SINGLE_COMPONENT, false);				
			initProperty("H4", Constants.Hydrogen, Constants.HydrogenRef, componentID, bioPos, dimensions, Constants.SINGLE_COMPONENT, false);				
			initProperty("H5", Constants.Hydrogen, Constants.HydrogenRef, componentID, bioPos, dimensions, Constants.SINGLE_COMPONENT, false);				
			initProperty("H6", Constants.Hydrogen, Constants.HydrogenRef, componentID, bioPos, dimensions, Constants.SINGLE_COMPONENT, false);				
			initProperty("H7", Constants.Hydrogen, Constants.HydrogenRef, componentID, bioPos, dimensions, Constants.SINGLE_COMPONENT, false);				
			initProperty("H8", Constants.Hydrogen, Constants.HydrogenRef, componentID, bioPos, dimensions, Constants.SINGLE_COMPONENT, false);				
			initProperty("H9", Constants.Hydrogen, Constants.HydrogenRef, componentID, bioPos, dimensions, Constants.SINGLE_COMPONENT, false);				
			initProperty("H10", Constants.Hydrogen, Constants.HydrogenRef, componentID, bioPos, dimensions, Constants.SINGLE_COMPONENT, false);				

			initProperty("O1", Constants.Oxygen, Constants.OxygenRef, componentID, bioPos, dimensions, Constants.SINGLE_COMPONENT, false);				
			initProperty("O2", Constants.Oxygen, Constants.OxygenRef, componentID, bioPos, dimensions, Constants.SINGLE_COMPONENT, false);				
			initProperty("O3", Constants.Oxygen, Constants.OxygenRef, componentID, bioPos, dimensions, Constants.SINGLE_COMPONENT, false);				
			initProperty("O4", Constants.Oxygen, Constants.OxygenRef, componentID, bioPos, dimensions, Constants.SINGLE_COMPONENT, false);				
			initProperty("O5", Constants.Oxygen, Constants.OxygenRef, componentID, bioPos, dimensions, Constants.SINGLE_COMPONENT, false);				
		}
		
		
		/****************************************************
		 * GENERATE Thymine
		 * 
		 * 
		 * @param parentID
		 * @param componentID
		 ***************************************************/
		public void generate(String parentID, String componentID)
		{
			// Generate the Thymine		
			BioMightDNABeanLocal bioMightBean;
			try {
				// Get the information from the database via the Enterprise Bean		
				System.out.println("Generating the Thymine - component: " + componentID + "  parent: " + parentID);
				InitialContext ctx = new InitialContext();
				bioMightBean = (BioMightDNABeanLocal) ctx.lookup("java:global/BioMightWeb/BioMightDNABean!biomight.ejb.BioMightDNABeanLocal");
				
				double circumference = 0.125;
				
					
				// Generate the Palm
				double[] startPos = {0.0, 0.0, 0.0};
					
				// Create a equilateral octogon
		    	double x =  startPos[0];
		    	double y =  startPos[1];
		    	double z =  startPos[2];
		
		    	double[][] currentPoints = { 
			   			 {x, y, z},
		     				 {x, y-circumference,     z-circumference},
		     				 {x, y-(circumference*2), z-circumference},
		     				 {x, y-(circumference*3), z},
		     				 {x, y-(circumference*3), z+(circumference)},
		     				 {x, y-(circumference*2), z+(circumference*2)},
		     				 {x, y-circumference,     z+(circumference*2)},
		     				 {x, y, z+circumference}
		      		};

					
				//int success = bioMightBean.generateThymine("Thymine:00001", "Thymine", 
				//		"Thymine", componentID, parentID, currentPoints);			
	
				
				System.out.println("Created Thymine Info using EJB");   	
			}catch (Exception e) { 
				System.out.println("Exception Getting Components - Thymine");
				throw new ServerException("Remote Exception Thymine():", e); 	
			}
		}
		
		
		// This method will store the method list into the 
		// BioMightBase object. 
		private void initMethods() {
			BioMightMethodView method = new BioMightMethodView();
			method.setMethodName("setCharge");
			method.setDisplayName("Set Charge:");
			method.setDataType(Constants.BIO_DOUBLE);
			method.setHtmlType("text");
			methods.add(method);
		
			method = new BioMightMethodView();
			method.setMethodName("setTexture");
			method.setDisplayName("Texture:");
			method.setDataType(Constants.BIO_TEXT);
			method.setHtmlType(Constants.BIO_TEXT);
			methods.add(method);

		}
		
		
		
		/******************************************************************************************
		 * EXECUTE METHODS 
		 *
		 ******************************************************************************************/
		public void executeMethods(ArrayList<String> methodParams) {

			// Run through the argument list and execute the 
			// associated methods
			System.out.println("Thymine Executing Methods");
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
		 * This method will return the X3D for the Thymine.  It runs through each of its components and collects up their
		 * representations and then assembles them into one unified X3D model.
		 * 
		 ********************************************************************************************************************/
		public String getX3D(boolean snipet) {
			
			// Assembe the Thymine
			String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
			"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n " +
			"<X3D profile='Immersive' >\n" +
			"<head>\n" +
			 "<meta name='BioMightImage' content='Thymine.jpg'/>\n" +
			 "<meta name='ExportTime' content='7:45:30'/>\n" +
			 "<meta name='ExportDate' content='08/15/2008'/>\n" +
			 "<meta name='BioMight Version' content='1.0'/>\n" + 
			"</head>\n" +
			"<Scene>\n" +
			"<WorldInfo\n" +
			"title='Thymine'\n" +
			"info='\"BioMight Generated X3D\"'/>\n";		

			String body = "";
			String annotate = "";
			
			System.out.println("In Thymine - Getting X3D - Using HardValue of MAG1X");
			lod = Constants.MAG1X;
			
			// Only when the database retrieval has been locally, do we do this??
			if (viewPerspective == Constants.VIEW_INTERNAL) 
			{	
				
				System.out.println("In Thymine - Getting X3D - View Internal");
				
				if (lod == Constants.MAG1X)		
				{
		
				}
				
				// We do nada as the Thymine Data is retrieved in the collection object
				// and the X3D is generated there
				else if (lod == Constants.MAG2X)		
				{
					//We are going to get the X3D from the aggregation objects
				}
			}
			else if (viewPerspective == Constants.VIEW_DETACHED) 
			{			
				
				
				System.out.println("In Thymine - Getting X3D - View Detached");
				if (lod == Constants.MAG1X)		
				{
					ArrayList transforms = bioMightTransforms.getTransforms();
					for (int i=0; i<transforms.size(); i++)
					{
						// Get the information for the capsomer we are creating
						BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
						System.out.println("In Thymine - Creating Thymine Detached: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
						System.out.println("In Thymine - Creating Thymine at Position: " + 
								bioMightTransform.getTranslation().getXPos() + "  " +
								bioMightTransform.getTranslation().getYPos() + "  " +
								bioMightTransform.getTranslation().getZPos());
						
						// Grab the data
						if (lod == Constants.MAG1X)		
						{
							//System.out.println("Getting X3D for ThymineX: " + bioMightTransform.getTranslation().getXPos());
							//System.out.println("Getting X3D for ThymineY: " + bioMightTransform.getTranslation().getYPos());
							//System.out.println("Getting X3D for ThymineZ: " + bioMightTransform.getTranslation().getZPos());
							// Change the height and width based on the displacement.
										
							// Create the Nuceotide representation
							body += getX3D(bioMightTransform);
							
						}
						else if (lod == Constants.MAG2X)		
						{
							body += ""; //nitrogen.getX3D(true) + carbon.getX3D(true);
						}
					}
		
				}
				
				// We do nada as the Nucleobase Data is retrieved in the collection object
				// and the X3D is generated there
				else if (lod == Constants.MAG2X)		
				{
					//We are going to get the X3D from the aggregation objects
				}
			}

			else if (viewPerspective == Constants.VIEW_HAWKEYE) 
			{
				// We went to the database to get data.  There will be 1 Transform record
			
				ArrayList transforms = bioMightTransforms.getTransforms();
				for (int i=0; i<transforms.size(); i++)
				{
					// Get the information for the capsomer we are creating
					BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
					System.out.println("Creating Thymine: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
					System.out.println("Creating Thymine at Position: " + 
							bioMightTransform.getTranslation().getXPos() + "  " +
							bioMightTransform.getTranslation().getYPos() + "  " +
							bioMightTransform.getTranslation().getZPos());
					
					// Grab the data
				
					if (lod == Constants.MAG1X)		
					{
						//System.out.println("Getting X3D for ThymineX: " + bioMightTransform.getTranslation().getXPos());
						//System.out.println("Getting X3D for ThymineY: " + bioMightTransform.getTranslation().getYPos());
						//System.out.println("Getting X3D for ThymineZ: " + bioMightTransform.getTranslation().getZPos());
						// Change the height and width based on the displacement.
									
						// Create the Nuceotide representation
						body += getX3D(bioMightTransform);
						
					}
					else if (lod == Constants.MAG2X)		
					{
						body += 
							carbon1.getX3D(true) +
							carbon2.getX3D(true) +
							carbon3.getX3D(true) +
							carbon4.getX3D(true) +
							carbon5.getX3D(true) +
							hydrogen1.getX3D(true) +
							hydrogen2.getX3D(true) +
							hydrogen3.getX3D(true) +
							hydrogen4.getX3D(true) +
							hydrogen5.getX3D(true) +
							hydrogen6.getX3D(true) +
							oxygen1.getX3D(true) +
							oxygen2.getX3D(true);
					}
				}
			}
			else 
			{			
				// Issue
			}	
			
			
			body+= "<Viewpoint DEF='Viewpoint_Nucleotide'\n" +
					 "description='Viewpoint1_Bucloetide'\n" +
					 "jump='true'\n" +
					 "fieldOfView='0.785'\n" +
					 "position='0.0 0.0 4.0'\n" +
					 "orientation='0 0 1 0'/>\n";
				
			
			//System.out.println("Thymine X3D: " + body);		
			String footer = "</Scene>" + "</X3D>\n";
			
			if (snipet)
				return body;			
			else	
				return header + body + annotate + footer;				
		}


		
		/********************************************************************************************************************
		 * GET X3D 
		 * 
		 * This method will return the X3D for the Thymine.  It runs through each of its components and collects up their
		 * representations and then assembles them into one unified X3D model.
		 * 
		 ********************************************************************************************************************/
		public String getX3D(BioMightTransform bioMightTransform) 
		{

			double angle=0;
			System.out.println("Thymine.getLocalX3DZ()  " + bioMightTransform.getComponentName());	
			
			double radius = 0.5;
			//double radiansAngle = Math.toRadians(nucleoAngle);
			String body = "";
		
			
			double x = 0.0;
			double y = 0.0;
			double z = 0.0;
			
			String componentTypeOut = "Thymine";
			body += "<Transform onmouseover=\"showComponent('Thymine');\" DEF='" + componentTypeOut + "'>\n";
			
			bioMightTransform.getTranslation().setXPos(x);
			bioMightTransform.getTranslation().setYPos(y);
			bioMightTransform.getTranslation().setZPos(z);
			body += BioWebDNA.getThymine(bioMightTransform, radius, angle);
		
			body += "</Transform>\n";
		
			return (body);
		}

	
}
