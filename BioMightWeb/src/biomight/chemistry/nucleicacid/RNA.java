/*
 * Created on May 5, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.chemistry.nucleicacid;

import java.lang.reflect.Method;
import java.util.ArrayList;

import javax.naming.InitialContext;





import biomight.Constants;
import biomight.chemistry.nucleicacid.nucleotide.Nucleotides;
import biomight.ejb.BioMightBeanLocal;
import biomight.exceptions.ServerException;
import biomight.util.BioGraphics;
import biomight.view.BioMightMethodView;
import biomight.view.BioMightPosition;
import biomight.view.BioMightPropertyView;
import biomight.view.BioMightTransform;

/****************************************************************************
 * @author SurferJim
 *
 * Get Access to RNA and RNA assembled chains
 ***************************************************************************/

public class RNA extends NucleicAcid{
	private BioMightPosition bioMightPosition;
	
	// We should add this into the base Cell,but for now
	// will do seperately to get it working
	private Nucleotides nucleotides;

	
	public RNA()
	{		
		// Create the Base RNA
		int localVP =  Constants.VIEW_INTERNAL;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, Constants.RNARef, null, null);
	}
	
	public RNA(String parentID)
	{				
		int localVP =  Constants.VIEW_INTERNAL;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, parentID, null, null);	
	}
		

	public RNA(String parentID, BioMightPosition bioMightPosition)
	{
		int localVP =  Constants.VIEW_INTERNAL;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, parentID, null, null);
		this.bioMightPosition = bioMightPosition;
	}
	
	
	// When we are drilling into the component from the View Page, we will set
	// the LOD to HAWK-EYE, which means fine detail.
	public RNA(String parentID, ArrayList<BioMightPropertyView> bioMightProperties,  ArrayList<BioMightMethodView> bioMightMethods)
	{		
		System.out.println("RNA Drill down...doing the hawk");
		int localVP =  Constants.VIEW_INTERNAL;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD,  parentID, bioMightProperties, bioMightMethods);	
	}

	// Needs to go away
	public RNA(String parentID,  ArrayList<BioMightMethodView> bioMightMethods)
	{		
		System.out.println("RNA Drill down...doing the hawk");
		int localVP =  Constants.VIEW_INTERNAL;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD,  parentID, null, bioMightMethods);	
	}
	
	
	public RNA(int localVP, int localLOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
	{				
		create(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);	
	}
	
	public void create(int localVP, int localLOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
	{
			this.setImage("images/RNA.jpg");
			this.setImageHeight(300);
			this.setImageWidth(300);
			this.parentID = parentID;
			this.componentID = parentID;
			this.lod = localLOD;
			this.viewPerspective = localVP;
			
			
			if (bioMightMethods != null){
				//System.out.println("EXECUTING RNA Methods: " + bioMightMethods.size());
				executeMethods(bioMightMethods);
			}
			
			// There are 2 modes in which this object will be created
			// 1 - It is an aggregate of a parent object - RNA is part of Chromosome
			// 2 - Being instantiated when drilling down from the Chromosome
			// 3 - Driling down from the RNA library where it is a root. Not part of aggregate
			if (localVP == Constants.VIEW_INTERNAL)			
			{
				
				// Generate the RNA details 
				boolean bGenerate = false;
				if (bGenerate) {
					generate(parentID, componentID);
				}	
				
			
				// Get the information from the database via the Enterprise Bean		
				try {
					// Get the information from the database via the Enterprise Bean		
					System.out.println("Getting INTERNAL RNA Info for ParentID: " + parentID);
					InitialContext ctx = new InitialContext();
					BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
					bioMightTransforms = bioMightBean.getComponents(Constants.RNARef, parentID);   	
				}catch (Exception e) { 
					System.out.println("Exception Getting Components - RNA");
					throw new ServerException("Remote Exception getComponents():", e); 	
				}
				
						
				// Run through the collection of RNA data and build them into the model
				// In the default case, we get one instance of the SkeletalSystem for each eye
				ArrayList transforms = bioMightTransforms.getTransforms();
				System.out.println("RNA NumTransforms: " + transforms.size());
				for (int i=0; i<transforms.size(); i++)
				{
					// Get the information for the SkeletalSystem we are creating
					BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
					System.out.println("Retrieve RNA: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
					this.componentID = bioMightTransform.getId();
		
					if (localLOD == Constants.MAG1X)
					{ 							
						System.out.println("MAG1X - Using RNA Internal data");

						// initialize the Properties			
						localVP = Constants.VIEW_HAWKEYE; 
						localLOD = Constants.MAG1X;
						
						System.out.println("Creating Nucleotides at MAG2X: " + bioMightTransform.getId());
						nucleotides = new Nucleotides(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
						initProperty(Constants.NucleotidesRef, Constants.Nucleotides, Constants.NucleotidesRef, nucleotides.getComponentID());
						System.out.println("In RNA - Nucleotides is complete");

					}
					// Are we using current set of data or going in for a deeper look
					// We will not be doing this as this is a variety page
					else if (localLOD == Constants.MAG2X)
					{ 							
						//System.out.println("Creating the Radii for parent: " + bioMightTransform.getId());
						// Go get the finer details of the RNA				
						System.out.println("Creating RNA at MAG2X : " + bioMightTransform.getId());
						
						localVP = Constants.VIEW_HAWKEYE; 
						localLOD = Constants.MAG1X;

						System.out.println("Creating Nucleotides at MAG2X: " + bioMightTransform.getId());
						nucleotides = new Nucleotides(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
						initProperty(Constants.NucleotidesRef, Constants.Nucleotides, Constants.NucleotidesRef, nucleotides.getComponentID());
						System.out.println("In RNA - Nucleotides is complete");

					}		
				}
			
			}	
			else if (localVP == Constants.VIEW_DETACHED)			
			{			
				// Generate the Component if needed 
				boolean bGenerate = false;
				if (bGenerate) {
					generate(parentID, componentID);
				}

				// The component is being called from within another component.  We
				// have a parent ID and know what type it is.
				// Get the information from the database via the Enterprise Bean		
				try {
					// Get the information from the database via the Enterprise Bean		
					System.out.println("Getting RNAInfo DETACHED for ParentID: " + parentID);
					InitialContext ctx = new InitialContext();
					BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
					bioMightTransforms = bioMightBean.getComponents(Constants.RNARef, parentID);
					System.out.println("Have RNA from EJB");   	
				}catch (Exception e) { 
					System.out.println("Exception Getting Components - RNA");
					throw new ServerException("Remote Exception getComponents():", e); 	
				}
					
				// Run through the collection of Pupils and build them into the model
				// In the default case, we get one instance of the Pupil for each eye
				ArrayList transforms = bioMightTransforms.getTransforms();
				System.out.println("Have RNA - Transforms : " + transforms.size());
				for (int i=0; i<transforms.size(); i++)
				{	
					// Get the information for the eye we are creating
					BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
					//System.out.println("Creating GlycoProteinSpike: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
					this.componentID = bioMightTransform.getId();
					

					if (localLOD == Constants.MAG1X)
					{
						// initialize the Properties
						initProperties();
					}
					else if (localLOD == Constants.MAG2X)
					{
						// Go get the finer details of the -----
						System.out.println("Creating RNA at MAG 1X: " + bioMightTransform.getId() + "  using parent: " + parentID);
						localVP = Constants.VIEW_HAWKEYE; 
						localLOD = Constants.MAG1X;

						System.out.println("Creating Nucleotidx `es at MAG1X: " + bioMightTransform.getId());
						nucleotides = new Nucleotides(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);
						initProperty(Constants.NucleotidesRef, Constants.Nucleotides, Constants.NucleotidesRef, nucleotides.getComponentID());
						System.out.println("In RNA - Nucleotides is complete");
					}
				}
			}
			else if (localVP == Constants.VIEW_HAWKEYE)
			{
				// This is when one is accessing a RNA directly
				// Get the information from the database via the Enterprise Bean		
				try {
					// Get the information from the database via the Enterprise Bean		
					System.out.println("Getting HawkEye RNAInfo for ParentID: " + parentID);
					InitialContext ctx = new InitialContext();
					BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
					bioMightTransforms = bioMightBean.getComponent(parentID);
					System.out.println("Have RNA Info from EJB");   	
				}catch (Exception e) { 
					System.out.println("Exception Getting Components - RNA");
					throw new ServerException("Remote Exception getComponents():", e); 	
				}
					
				// Run through the collection of RNAs and build them into the model
				// In the default case, we get one instance of the RNA for each eye
				ArrayList transforms = bioMightTransforms.getTransforms();
				System.out.println("RNA NumTransforms: " + transforms.size());
				for (int i=0; i<transforms.size(); i++)
				{
					// Get the information for the RNA
					BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
					System.out.println("Creating RNA: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
					this.componentID = bioMightTransform.getId();


					if (localLOD == Constants.MAG1X)
					{
						// initialize the Properties
						System.out.println("Creating RNA at MAG1X");
						//initProperties();
						
						// Go get the finer details of the RNA				
						System.out.println("Creating RNA at MAG 1X : " + bioMightTransform.getId());
						localVP = Constants.VIEW_HAWKEYE; 
						localLOD = Constants.MAG1X;

						System.out.println("Creating Nucleotides at MAG1X: " + bioMightTransform.getId());
						nucleotides = new Nucleotides(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
						initProperty(Constants.NucleotidesRef, Constants.Nucleotides, Constants.NucleotidesRef, nucleotides.getComponentID());
						System.out.println("In RNA - Nucleotides is complete");
					}
					if (localLOD == Constants.MAG2X)
					{
						// Go get the finer details of the RNA				
						System.out.println("Creating RNA at MAG 2X : " + bioMightTransform.getId());
						localVP = Constants.VIEW_HAWKEYE; 
						localLOD = Constants.MAG1X;

						System.out.println("Creating Nucleotides at MAG2X: " + bioMightTransform.getId());
						nucleotides = new Nucleotides(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
						initProperty(Constants.NucleotidesRef, Constants.Nucleotides, Constants.NucleotidesRef, nucleotides.getComponentID());
						System.out.println("In RNA - Nucleotides is complete");
					}
				}
			}		
			else
			{
				
			}
				
				
				
			initMethods();
			
			System.out.println("Create RNA Completed");
			
			// First, get all the data from the database
			// Apply the methods to it
			// Save its state
			this.parentID = parentID;
			if (bioMightMethods != null){
				System.out.println("EXECUTING RNA Methods: " + bioMightMethods.size());
				//executeMethods(bioMightMethods);
			}
		}
		

	
		private void initProperties() {
			
			BioMightPropertyView property = new BioMightPropertyView();
			property.setPropertyName("Nucleotides");
			property.setCanonicalName(Constants.NucleotideRef);
			properties.add(property);		
		}
		
		
		/***************************************************************************
		 * GENERATE RNA
		 * 
		 * 
		 * @param parentID
		 * @param componentID
		 **************************************************************************/
		public void generate(String parentID, String componentID)
		{
			// Generate the RNA		
			BioMightBeanLocal bioMightBean;
			try {
				// Get the information from the database via the Enterprise Bean		
				System.out.println("Generating the RNA : " + componentID + "    " + parentID);
				InitialContext ctx = new InitialContext();
				bioMightBean = (BioMightBeanLocal) ctx.lookup("java:global/BioMightWeb/BioMightBean!biomight.ejb.BioMightBeanLocal");
		
				double circumference = 0.125;
				
				if (componentID.equals("RNA:01")) {
					System.out.println("Generating the RNA X3D for RNA01: " + componentID + "    " + parentID);
					
					// Generate the Palm
					double[] startPos = {3.75,-23.0,-6.0};
					
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

						
					//int success = bioMightBean.generateDNA("DNA:00001", "DNA", 
					//		"DNA", componentID, parentID, currentPoints);			
					
				}
				else if (componentID.equals("RNA:02"))
				{
					// Generate the Elbow
					double[] startPos = {-3.75,-23.0,-6.0};
					
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

					
					
					//int success = bioMightBean.generateDNA("DNA:00160", "DNA", 
					//	"DNA", componentID, parentID, currentPoints);
			
					
				}
				else if (parentID.equals("")) 
				{	
					System.out.println("Calling Generate RNA NoParent");		
				}

				
				System.out.println("Created RNA Info using EJB");   	
			}catch (Exception e) { 
				System.out.println("Exception Getting Components - RNA");
				throw new ServerException("Remote Exception RNA():", e); 	
			}
		}
		
		
		// This method will store the method list into the 
		// BioMightBase object. 
		private void initMethods() {
			/*
			BioMightMethodView method = new BioMightMethodView();
			method.setCanonicalName(Constants.DNA);
			method.setMethodName("setDNA");
			method.setDisplayName("DNA:");
			method.setDataType(Constants.BIO_TEXT);
			method.setHtmlType("text");
			methods.add(method);

			method = new BioMightMethodView();
			method.setCanonicalName(Constants.Guanine);
			method.setMethodName("setTexture");
			method.setDisplayName("Texture:");
			method.setHtmlType("dropdown");
			method.setDataType("String");
	     	ArrayList<String> texture = new ArrayList<String>();
	     	texture.add("Gold");
	     	texture.add("Silver");
	    	method.setValues(texture);
			method.setDataType("String");
			methods.add(method);
			*/
		}
			
		
		/********************************************************************************************************************
		 * GET X3D
		 * 
		 * This method will return the X3D for the RNA.  It runs through each of its components and collects up their
		 * representations and then assembles them into one unified X3D model.
		 * 
		 ********************************************************************************************************************/
		public String getX3D(boolean snipet) {
			
			// Assembe the RNA
			String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
			"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n " +
			"<X3D profile='Immersive' >\n" +
			"<head>\n" +
			 "<meta name='BioMightImage' content='RNA.jpg'/>\n" +
			 "<meta name='ExportTime' content='7:45:30'/>\n" +
			 "<meta name='ExportDate' content='08/15/2008'/>\n" +
			 "<meta name='BioMight Version' content='1.0'/>\n" + 
			"</head>\n" +
			"<Scene>\n" +
			"<WorldInfo\n" +
			"title='RNA'\n" +
			"info='\"BioMight Generated X3D\"'/>\n";		

			String body = "";
			String annotate = "";
			
			
			// Only when the database retrieval has been locally, do we do this??
			if (viewPerspective == Constants.VIEW_INTERNAL) 
			{			
				// We do nada as the RNA Data is retrieved in the collection object
				// and the X3D is generated there
				if (lod == Constants.MAG2X)		
				{
					// Get the local X3D for this components
					System.out.println("Creating RNA - INTERNAL MAG2X - getting Nucleotides "); 
					body += nucleotides.getX3D(true);						
				}
			}
			else if (viewPerspective == Constants.VIEW_DETACHED) 
			{			
				// We do nada as the RNA Data is retrieved in the collection object
				// and the X3D is generated there
				if (lod == Constants.MAG2X)		
				{
					// Get the local X3D for this components
					System.out.println("Creating RNA - DETACHED MAG2X - getting Nucleotides "); 
					body += nucleotides.getX3D(true);						
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
					System.out.println("Creating RNA: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
					System.out.println("At Position: " + 
							bioMightTransform.getTranslation().getXPos() + "  " +
							bioMightTransform.getTranslation().getYPos() + "  " +
							bioMightTransform.getTranslation().getZPos());
					
					// Grab the data
					if (lod == Constants.MAG1X)		
					{
						
						System.out.println("Creating RNA - HAWKEYE MAG1X - getting Nucleotides "); 
					
						String componentTypeOut = "Nucleotides";
						body += "<Group onmouseover=\"showComponent('Nucleotides');\" DEF='" + componentTypeOut + "'>\n";
					
						body += nucleotides.getX3D(true);	
						
						body += "</Group>\n";
					
					}
					else if (lod == Constants.MAG2X)		
					{
						System.out.println("Creating RNA - HAWKEYE MAG2X - getting Nucleotides "); 
						String componentTypeOut = "Nucleotides";
						body += "<Group onmouseover=\"showComponent('Nucleotides');\" DEF='" + componentTypeOut + "'>\n";
						body += nucleotides.getX3D(true);	
						body += "</Group>\n";				
					}
				}
			}
			else 
			{			
				// Issue
			}	
			
				
			body+= "<Viewpoint DEF='Viewpoint_RNAs'\n" +
					 "description='Viewpoint1'\n" +
					 "jump='true'\n" +
					 "fieldOfView='0.785'\n" +
					 "position='0.0 3.0 15.0'\n" +
					 "orientation='0 0 1 0'/>\n";	
			

			//System.out.println("RNA X3D: " + body);		
			String footer = "</Scene>" + "</X3D>\n";
			
			if (snipet)
				return body;			
			else	
				return header + body + annotate + footer;				
		}

	

		/********************************************************************************************************************
		 * GET X3D
		 * 
		 * This method will return the X3D for the Nucleotides.  Each Nucleotide record from the database will yield
		 * a representation of the entire structure at the current level.
		 * 
		 ********************************************************************************************************************/
		public String getX3D(BioMightTransform bioMightTransform, double angle) 
		{
			String body = "";
			
			double x = bioMightTransform.getTranslation().getXPos();
			double y = bioMightTransform.getTranslation().getYPos();
			double z = bioMightTransform.getTranslation().getZPos();
			
			double xScale = 1.0;
			double yScale = 1.0;
			double zScale = 1.0;

			double circumference = 0.25;
			
			String dnaSequence = "ACTG";
			String pentoseRibose = "RRRR";
			// Use the String Seuence passed in by the user
			
			for (int k=0; k < dnaSequence.length(); k++) 
			{
				
				// Make a 5 pointed ribose sugar molecule
				
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
					System.out.println("Rotating Nucleotide: " + angle);			
					ribosePoints = BioGraphics.rotateY(ribosePoints, angle);
					System.out.println("Rotated Nucleotide: " + angle);			
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
					System.out.println("Rotating Nucleotide: " + angle);			
					phosphatePoints = BioGraphics.rotateY(phosphatePoints, angle);
					System.out.println("Rotated Nucleotide: " + angle);			
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
					System.out.println("Rotating Nucleotide: " + angle);			
					nbPoints = BioGraphics.rotateY(nbPoints, angle);
					System.out.println("Rotated Nucleotide: " + angle);			
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
					
					//System.out.println("Set Translation: ");				
	
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
					System.out.println("Rotating Nucleotide: " + angle);			
					nbHPoints = BioGraphics.rotateY(nbHPoints, angle);
					System.out.println("Rotated Nucleotide: " + angle);			
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
			
				
			}
						
			return (body);
		}
			

		/******************************************************************************************
		 * EXECUTE METHODS 
		 *
		 ******************************************************************************************/
		public void executeMethods(ArrayList<BioMightMethodView> bioMightMethods) {

			// Run through the argument list and executes the 
			// associated methods
			boolean fired = false;
			System.out.println("RNAs-Executing Methods: " + bioMightMethods.size());
			for (int j=0; j<bioMightMethods.size(); j++){
				
				// Get the parameter from the list and if it is not
				// empty execute the associated method using it
				BioMightMethodView bioMightMethod = (BioMightMethodView) bioMightMethods.get(j);
				System.out.println("Have BioMightMethod for RNAs: " + bioMightMethod.getMethodName());	
				String methodName = bioMightMethod.getMethodName();
				String canonicalName = bioMightMethod.getCanonicalName(); 
				String dataType = bioMightMethod.getDataType();
				String methodParam = bioMightMethod.getMethodParameter(); 
				if (methodParam == null)
					methodParam = "";
				
			
				if (canonicalName.equals(Constants.RNA)) {				
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
					System.out.println("RNAs - Methods have fired.   Calling RNAs Save method!");
				}
			}
		}

		
		/******************************************************************************************
		 * SET RNA
		 *
		 * This method will create a chain of RNA 
		 *   
		 *****************************************************************************************/
		public void setRNA(String chain) {

			// Run through the argument list and executes the 
			// associated methods
			boolean fired = false;
			System.out.println("RNA - SetRNA() chain at MacroLevel : " + chain);
		}
		
}
