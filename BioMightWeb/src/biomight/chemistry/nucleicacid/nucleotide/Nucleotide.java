/*
 * Created on Jun 3, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
 
package biomight.chemistry.nucleicacid.nucleotide;
import java.util.ArrayList;

import javax.naming.InitialContext;







import biomight.Constants;
import biomight.chemistry.carbohydrate.monosaccharide.pentose.DeOxyRibose;
import biomight.chemistry.carbohydrate.monosaccharide.pentose.Ribose;
import biomight.chemistry.ions.Phosphate;
import biomight.chemistry.nucleicacid.NucleicAcid;
import biomight.ejb.BioMightBeanLocal;
import biomight.ejb.BioMightDNABeanLocal;
import biomight.exceptions.ServerException;
import biomight.util.BioGraphics;
import biomight.view.BioMightMethodView;
import biomight.view.BioMightPosition;
import biomight.view.BioMightPropertyView;
import biomight.view.BioMightTransform;
import biomightweb.util.BioWebDNA;


/******************************************************************************
 * @author SurferJim
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 ******************************************************************************/
public class Nucleotide extends NucleicAcid {
	private BioMightPosition bioMightPosition;
 	private DeOxyRibose deOxyRibose;
 	private Phosphate phosphate;
 	private Nucleobase nucleobase;
	

	public Nucleotide()
	{		
		// Create the Base Nucleotide
		int localVP =  Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG2X;
		create(localVP, localLOD, Constants.NucleotideRef, null, null);
	}
	
	public Nucleotide(String parentID)
	{				
		int localVP =  Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG2X;
		create(localVP, localLOD, parentID, null, null);	
	}
		

	public Nucleotide(String parentID, BioMightPosition bioMightPosition)
	{
		int localVP =  Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG2X;
		create(localVP, localLOD, parentID, null, null);
		this.bioMightPosition = bioMightPosition;
	}
	
	
	// When we are drilling into the component from the View Page, we will set
	// the LOD to HAWK-EYE, which means fine detail.
	public Nucleotide(String parentID, ArrayList<BioMightMethodView> bioMightMethods)
	{		
		int localVP =  Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG2X;
		create(localVP, localLOD,  parentID, null, bioMightMethods);	
	}
		
	// We are looking at the object from a collection.  It was created via
	// the Nucleotides parent object and we do not have  to go to the database 
	// to get additional informaion
	
	public Nucleotide(int localVP, int localLOD, String parentID,  ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
	{
		System.out.println("In Nucleotide Calling Create()");				
		create(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);
	}
	
	
	
	public void create(int localVP, int localLOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
	{
			this.setImage("images/Nucleotide.jpg");
			this.setImageHeight(300);
			this.setImageWidth(300);
			this.parentID = parentID;
			this.componentID = parentID;
			this.lod = localLOD;
			this.viewPerspective = localVP;
	
			
			// There are 4 modes in which this object will be created
			// 1 - Being instantiated as part of a collection.
			// 2 - Being instantiated when drilling down from a collection, will need to get component by ID
			// 3 - Need level of detail to determine if aggregated, or get current level
			// 4 - 
			if (localVP == Constants.VIEW_INTERNAL)			
			{
				// Do nothing.  We are instantiating as part of a collection  
				// There is no drill down, so we use the transforms that the
				// parent has already collected
				System.out.println("In Nucleotide Create() - ViewInternal - Gathered by parent: " + parentID);				
			
				// We already have the data for the current instance of Nucleotide,
				// Go get the details for the current Nucleotide is LOD is set
				if (localLOD == Constants.MAG2X)
				{
					// Generate the Nucleotide that the user desires if needed 
					boolean bGenerate = false;
					if (bGenerate) {
						generate(parentID, componentID);
					}
					
					// Go get the finer details of the Nucleotide				
					System.out.println("Getting the Nucleotide Details: " + parentID);
					localVP = Constants.VIEW_INTERNAL; 
					localLOD = Constants.MAG1X;
					
					System.out.println("Creating Ribose : " + parentID + " lod: " + localLOD);
					deOxyRibose = new DeOxyRibose(localVP, localLOD, componentID, bioMightProperties, bioMightMethods);
					initProperty(Constants.DeOxyRiboseRef, Constants.DeOxyRibose, Constants.DeOxyRiboseRef, deOxyRibose.getComponentID());
					System.out.println("DeOxyRibose is complete");
		
					System.out.println("Creating Phosphate : " + parentID + " lod: " + localLOD);
					phosphate = new Phosphate(localVP, localLOD, componentID, null, bioMightMethods);
					initProperty(Constants.PhosphateRef, Constants.Phosphate, Constants.PhosphateRef, phosphate.getComponentID());
					System.out.println("Phosphate is complete");

					System.out.println("Creating Nucleobase : " + parentID + " lod: " + localLOD);
					nucleobase = new Nucleobase(localVP, localLOD, componentID, null, bioMightMethods);
					initProperty(Constants.NucleobaseRef, Constants.Nucleobase, Constants.NucleobaseRef, nucleobase.getComponentID());
					System.out.println("Nucleobase is complete");	
					}
			
			}	
			else if (localVP == Constants.VIEW_HAWKEYE)
			{
				// This is when one is accessing a Nucleotide directly
				//System.out.println("In Nucleotide Create() - Getting Name from properties: " + bioMightProperties.get(0).getPropertyName());				
						
				// Get the information from the database via the Enterprise Bean		
				try {
					// Get the information from the database via the Enterprise Bean		
					System.out.println("Getting HawkEye NucleotideInfo for ParentID: " + parentID);
					InitialContext ctx = new InitialContext();
					BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
					bioMightTransforms = bioMightBean.getComponent(parentID);
					System.out.println("Have Nucleotide Info from EJB");   	
				}catch (Exception e) { 
					System.out.println("Exception Getting Components - Nucleotide");
					throw new ServerException("Remote Exception getComponents():", e); 	
				}
					
				// Run through the collection of Nucleotides and build them into the model
				ArrayList transforms = bioMightTransforms.getTransforms();
				System.out.println("Nucleotide NumTransforms: " + transforms.size());
				for (int i=0; i<transforms.size(); i++)
				{
					// Get the information for the Nucleotide
					BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
					System.out.println("Creating HawkEye Nucleotide: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
					this.componentID = bioMightTransform.getId();
					String nucleobaseName = bioMightTransform.getName();

					if (localLOD == Constants.MAG1X)
					{
						System.out.println("In Nucleotide Create() - ViewHawkEye - Just Gathered - parent: " + parentID);				
						// initialize the Properties
						initProperties(nucleobaseName);
					}
					if (localLOD == Constants.MAG2X)
					{
					
						// Generate the Nucleotide that the user desires if needed 
						boolean bGenerate = false;
						if (bGenerate) {
							generate(parentID, componentID);
						}
						
						// Go get the finer details of the Ribose				
						System.out.println("Nucleotide Hawkeye - 2x View - parent: " + parentID + " lod: " + localLOD);
						localVP = Constants.VIEW_HAWKEYE; 
						localLOD = Constants.MAG1X;

						System.out.println("Creating Ribose : " + parentID + " lod: " + localLOD);
						deOxyRibose = new DeOxyRibose(localVP, localLOD, componentID, bioMightProperties, bioMightMethods);
						initProperty(Constants.DeOxyRiboseRef, Constants.DeOxyRibose, Constants.DeOxyRiboseRef, deOxyRibose.getComponentID());
						System.out.println("DeOxyRibose is complete");
			
						System.out.println("Creating Phosphate : " + parentID + " lod: " + localLOD);
						phosphate = new Phosphate(localVP, localLOD, bioMightTransform.getId(), null, bioMightMethods);
						initProperty(Constants.PhosphateRef, Constants.Phosphate, Constants.PhosphateRef, phosphate.getComponentID());
						System.out.println("Phosphate is complete");
	
						
					
					}
					
				}
			}		
			else
			{
				
			}
				
			initMethods();
			
			System.out.println("CreateNucleotide Completed");
			
			// First, get all the data from the database
			// Apply the methods to it
			// Save its state
			this.parentID = parentID;
			if (bioMightMethods != null){
				//System.out.println("EXECUTING Nucleotide Methods: " + bioMightMethods.size());
				//executeMethods(bioMightMethods);
			}
		}
		
	
		private void initProperties(String nucleobaseName) {
			String dimensions = "0.00, 0.00, 0.00";
			String bioPos = "0.00, 0.00, 0.00";	
		
			initProperty(Constants.DeOxyRiboseRef, Constants.DeOxyRibose, Constants.DeOxyRiboseRef, componentID, bioPos, dimensions, Constants.SINGLE_COMPONENT, false);
			initProperty(Constants.PhosphateRef, Constants.Phosphate, Constants.PhosphateRef, componentID, bioPos, dimensions, Constants.SINGLE_COMPONENT, false);
			
			if (nucleobaseName.equals("Adenine"))
			{
				initProperty(Constants.AdenineRef, Constants.Adenine, Constants.AdenineRef, componentID, bioPos, dimensions, Constants.SINGLE_COMPONENT, false);			
			}	
			else if (nucleobaseName.equals("Guanine"))
			{
				initProperty(Constants.GuanineRef, Constants.Guanine, Constants.GuanineRef, componentID, bioPos, dimensions, Constants.SINGLE_COMPONENT, false);			
			}
			else if (nucleobaseName.equals("Cytosine"))
			{
				initProperty(Constants.CytosineRef, Constants.Cytosine, Constants.CytosineRef, componentID, bioPos, dimensions, Constants.SINGLE_COMPONENT, false);			
			}
			else if (nucleobaseName.equals("Thymine"))
			{
				initProperty(Constants.ThymineRef, Constants.Thymine, Constants.ThymineRef, componentID, bioPos, dimensions, Constants.SINGLE_COMPONENT, false);			
			}
			else
				initProperty(Constants.NucleobaseRef, Constants.Nucleobase, Constants.NucleobaseRef, componentID, bioPos, dimensions, Constants.SINGLE_COMPONENT, false);			
		}
	
		private void initProperties() {
			String dimensions = "0.00, 0.00, 0.00";
			String bioPos = "0.00, 0.00, 0.00";	
		
			initProperty(Constants.DeOxyRiboseRef, Constants.DeOxyRibose, Constants.DeOxyRiboseRef, componentID, bioPos, dimensions, Constants.SINGLE_COMPONENT, false);
			initProperty(Constants.PhosphateRef, Constants.Phosphate, Constants.PhosphateRef, componentID, bioPos, dimensions, Constants.SINGLE_COMPONENT, false);
			initProperty(Constants.NucleobaseRef, Constants.Nucleobase, Constants.NucleobaseRef, componentID, bioPos, dimensions, Constants.SINGLE_COMPONENT, false);			
		}
		
		/**************************************************************************
		 * GENERATE NUCLEOTIDE
		 * 
		 * @param parentID
		 * @param componentID
		 *************************************************************************/
		public void generate(String parentID, String componentID)
		{
			// Generate the Nucleotide		
			BioMightDNABeanLocal bioMightBean;
			try {
				// Get the information from the database via the Enterprise Bean		
				System.out.println("Generating the Nucleotide : " + componentID + "    " + parentID);
				InitialContext ctx = new InitialContext();
				bioMightBean = (BioMightDNABeanLocal) ctx.lookup("java:global/BioMightWeb/BioMightDNABean!biomight.ejb.BioMightDNABeanLocal");
		
				double circumference = 0.125;
				
				// We should create the Nucleotide based upon where it is in the body.
				// The position would be in the hunndred thousand trillions.  
				// We can grid off the body and then everything has an offset off the base
				// As a user will have a limited domain we allow them to have only so many per com
				
				// There will be a bunch of users all trying to find out where they are going to put their
				// rows in the database.   I believe we can number everything the same across models.  
				// They can all use the exact same numbering scheme.   When it stores in the database the
				// Body ID the Project ID will be used to isolate the insert into various parts of the database
				// no two users will every be selecting from the 
				
					
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

					
	    		// Does this deliver 1 Nucleotide record in the database or does it
	    		// create the subComponents?   - both is always the answer
				int success = bioMightBean.generateNucleotide(Constants.AdenineRef, "Nucleotide:00001", "Nucleotide", 
						"Nucleotide", componentID, parentID, currentPoints);			
					
				System.out.println("Created Nucleotide Info using EJB");   	
			}catch (Exception e) { 
				System.out.println("Exception Getting Components - Nucleotide");
				throw new ServerException("Remote Exception Nucleotide():", e); 	
			}
		}
		
		
		
		// This method will store the method list into the 
		// BioMightBase object. 
		private void initMethods() {
			/*
			BioMightMethodView method = new BioMightMethodView();
			
			method = new BioMightMethodView();
			method.setCanonicalName(Constants.Guanine);
			method.setMethodName("setSugar");
			method.setDisplayName("Sugar:");
			method.setHtmlType("dropdown");
			method.setDataType("String");
	     	ArrayList<String> sugarType = new ArrayList<String>();
	     	sugarType.add("Ribose");
	     	sugarType.add("2-DeoxyRibose");
	    	method.setValues(sugarType);
			method.setDataType("String");
			methods.add(method);

			method = new BioMightMethodView();
			method.setCanonicalName(Constants.Guanine);
			method.setMethodName("setNuceloBase");
			method.setDisplayName("Nucleobase:");
			method.setHtmlType("dropdown");
			method.setDataType("String");
	     	ArrayList<String> bodyType = new ArrayList<String>();
	     	bodyType.add("Adenine");
	     	bodyType.add("Cytosine");
	     	bodyType.add("Guanine");
	    	bodyType.add("Thymine");
	    	method.setValues(bodyType);
			method.setDataType("String");
			methods.add(method);
			*/
		}
		
		
		
		/******************************************************************************************
		 * EXECUTE METHODS 
		 *
		 ******************************************************************************************/
		public void executeMethods(ArrayList<String> methodParams) {

			// Run through the argument list and execute the 
			// associated methods
			System.out.println("Nucleotide Executing Methods");
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
		 * This method will return the X3D for the Nucleotide.  It runs through each of its components and collects up their
		 * representations and then assembles them into one unified X3D model.
		 * 
		 ********************************************************************************************************************/
		public String getX3D(boolean snipet) {
			
			// Assembe the Nucleotide
			String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
			"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n " +
			"<X3D profile='Immersive' >\n" +
			"<head>\n" +
			 "<meta name='BioMightImage' content='Nucleotide.jpg'/>\n" +
			 "<meta name='ExportTime' content='7:45:30'/>\n" +
			 "<meta name='ExportDate' content='08/15/2008'/>\n" +
			 "<meta name='BioMight Version' content='1.0'/>\n" + 
			"</head>\n" +
			"<Scene>\n" +
			"<WorldInfo\n" +
			"title='Nucleotide'\n" +
			"info='\"BioMight Generated X3D\"'/>\n";		

			String body = "";
			String annotate = "";
			
			
			// Only when the database retrieval has been locally, do we do this??
			if (viewPerspective == Constants.VIEW_INTERNAL) 
			{			
				
				if (lod == Constants.MAG1X)		
				{
		
				}
				
				// We do nada as the Nucleotide Data is retrieved in the collection object
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
					System.out.println("In Nucleotide - Creating Nucleotide Hawkeye: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
					System.out.println("In Nucleotide - Creating Nucleotide at Position: " + 
							bioMightTransform.getTranslation().getXPos() + "  " +
							bioMightTransform.getTranslation().getYPos() + "  " +
							bioMightTransform.getTranslation().getZPos());
					
					// Grab the data
					if (lod == Constants.MAG1X)		
					{
						//System.out.println("Getting X3D for NucleotideX: " + bioMightTransform.getTranslation().getXPos());
						//System.out.println("Getting X3D for NucleotideY: " + bioMightTransform.getTranslation().getYPos());
						//System.out.println("Getting X3D for NucleotideZ: " + bioMightTransform.getTranslation().getZPos());
						// Change the height and width based on the displacement.
									
						// Create the Nuceotide representation
						body += getLocalX3D(bioMightTransform, 0, 0);
						
					}
					else if (lod == Constants.MAG2X)		
					{
						System.out.println("In Nucleotide - Creating Nucleotide MAG2X ");
						body += deOxyRibose.getX3D(true) + phosphate.getX3D(true) + nucleobase.getX3D(true);
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
					 "position='0.0 0.0 5.0'\n" +
					 "orientation='0 0 1 0'/>\n";	
			
			
			//System.out.println("Nucleotide X3D: " + body);		
			String footer = "</Scene>" + "</X3D>\n";
			
			if (snipet)
				return body;			
			else	
				return header + body + annotate + footer;				
		}

	
		/********************************************************************************************************************
		 * GET LOCAL X3D
		 * 
		 * This method will return the X3D for the Nucleotides.  Each Nucleotide record from the database will yield
		 * a representation of the entire structure at the current level.
		 * 
		 ********************************************************************************************************************/
		public String getLocalX3D(BioMightTransform bioMightTransform, double angle, double nucleoAngle) 
		{
			angle=0;
			System.out.println("Nucleotide.getLocalX3DZ()  " + bioMightTransform.getComponentName());	
			
			double radius = 0.5;
			double radiansAngle = Math.toRadians(nucleoAngle);
			String body = "";
			
			// Set the position to 0/0/0 so we can deal with more easily
			bioMightTransform.getTranslation().setXPos(0.0);
			bioMightTransform.getTranslation().setYPos(0.0);
			bioMightTransform.getTranslation().setZPos(0.0);
			
			if (bioMightTransform.getComponentName().equals("Adenine"))
			{
				
				String componentTypeOut = "Adenine";
				body += "<Transform onmouseover=\"showComponent('Adenine Nucleotide');\" DEF='" + componentTypeOut + "'>\n";
						
									
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
				
		
				
			}
			else if (bioMightTransform.getComponentName().equals("Guanine"))
			{
		
				String componentTypeOut = "Guanine";
				body += "<Transform onmouseover=\"showComponent('Guanine Nucleotide');\" DEF='" + componentTypeOut + "'\n";
						
									
				body+= "rotation='" 	
						+ "0.00 , " + " "
						+ "1.00 , " + " "
						+ "0.00 , " + " "
						+ radiansAngle  + "'>\n";
		
				
				// Set up the base position
				double xBase = bioMightTransform.getTranslation().getXPos();
				double yBase = bioMightTransform.getTranslation().getYPos();
				double zBase = bioMightTransform.getTranslation().getZPos();
				
				body += BioWebDNA.getGuanine(bioMightTransform, radius, angle);
				
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
							
			}
			else if (bioMightTransform.getComponentName().equals("Cytosine"))
			{
		
				String componentTypeOut = "Cytosine";
				body += "<Transform onmouseover=\"showComponent('Cytosine Nucleotide');\" DEF='" + componentTypeOut + "'\n";
			
				body+= "rotation='" 	
						+ "0.00 , " + " "
						+ "1.00 , " + " "
						+ "0.00 , " + " "
						+ radiansAngle + "'>\n";
		
				// Set up the base position
				double xBase = bioMightTransform.getTranslation().getXPos();
				double yBase = bioMightTransform.getTranslation().getYPos();
				double zBase = bioMightTransform.getTranslation().getZPos();
					
				body += BioWebDNA.getCytosine(bioMightTransform, radius, angle+72);

				// Set up the Ribose
				double x = xBase - 0.42;
				double y = yBase - 0.13;
				double z = zBase + 0.23;
				
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
				
			}
			else if (bioMightTransform.getComponentName().equals("Thymine"))
			{
		
				String componentTypeOut = "Thymine";
				body += "<Transform onmouseover=\"showComponent('Thymine Nucleotide');\" DEF='" + componentTypeOut + "'\n";
				//body += "<Transform DEF='" + componentTypeOut + "'\n";
				
				body+= "rotation='" 	
						+ "0.00 , " + " "
						+ "1.00 , " + " "
						+ "0.00 , " + " "
						+ radiansAngle + "'>\n";
				
				
				// Set up the base position
				double xBase = bioMightTransform.getTranslation().getXPos();
				double yBase = bioMightTransform.getTranslation().getYPos();
				double zBase = bioMightTransform.getTranslation().getZPos();	
				body += BioWebDNA.getThymine(bioMightTransform, radius, angle+72);

				
				// Set up the Ribose
				double x = xBase - 0.45;
				double y = yBase - 0.13;
				double z = zBase + 0.14;
				
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

			}
			return (body);
		}

}
