/*
 * Created on Jul 8, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.chemistry;

import java.util.ArrayList;

import javax.naming.InitialContext;

import org.apache.openejb.math.util.MathUtils;

import biomight.BioMightBase;
import biomight.Constants;
import biomight.chemistry.nucleicacid.DNA;
import biomight.chemistry.nucleicacid.DNAs;
import biomight.chemistry.nucleicacid.RNA;
import biomight.ejb.BioMightBeanLocal;
import biomight.ejb.BioMightVascularBeanLocal;
import biomight.exceptions.ServerException;
import biomight.util.BioGraphics;
import biomight.view.BioMightConstruct;
import biomight.view.BioMightMethodView;
import biomight.view.BioMightPosition;
import biomight.view.BioMightPropertyView;
import biomight.view.BioMightScale;
import biomight.view.BioMightTransform;
import biomightweb.util.BioWebDNA;


/**************************************************************************
 * @author SurferJim
 *
 * Representation of the BioAssmblies
 * 
 **************************************************************************/

public class BioAssemblies extends BioMightBase {
	private DNAs dnas;
	private RNA rna;
	private BioMightTransform gbioMightTransform; 
	
	
	/************************************************************************
	 * BIOASSMBLIES SYSTEM Constructor 
	 *
	 ***********************************************************************/

	public BioAssemblies()
	{
		int localVP =  Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG2X;
		create(localVP, localLOD, Constants.BioAssemblies, null, null);
	}

	public BioAssemblies(String parentID)
	{
		int localVP =  Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG2X;
		create(localVP, localLOD, parentID, null, null);
	}
	
	public BioAssemblies(String parentID, BioMightConstruct bioMightConstruct, ArrayList<BioMightMethodView> bioMightMethods)
	{	
		int localVP =  Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG2X;
		//create(parentID, bioMightConstruct, bioMightMethods);
	}
	
	
	public BioAssemblies(String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods) {
		System.out.println("Calling BioAssemblies with Proprty & Method Params: " + parentID);
		int localVP =  Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG2X;
		//create(localVP, localLOD, parentID, bioMightProperties,  bioMightMethods);
	}
	
	
	public BioAssemblies(String parentID, ArrayList<BioMightMethodView> bioMightMethods)
	{
		System.out.println("Calling BioAssemblies : " + parentID);
		int localVP =  Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG2X;
		create(localVP, localLOD, parentID, null, bioMightMethods);
	}

	
	public BioAssemblies(int localVP, int localLOD, String parentID,  ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
	{	
		System.out.println("Calling BioAssemblies with Proprty & Method Params: " + parentID);
		create(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);
	}

	
	/**********************************************************************************
	 * CREATE
	 * 
	 * @param parentID
	 * @param bioMightMethods
	 *********************************************************************************/
	
	public void create(int localVP, int localLOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
	{
		this.setImage("images/BioAssemblies.jpg");
		this.setImageHeight(300);
		this.setImageWidth(300);
		
		// Get the information from the database via the Enterprise Bean		
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Getting BioAssembliesInfo for ParentID: " + parentID);
			InitialContext ctx = new InitialContext();
			BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
			bioMightTransforms = bioMightBean.getComponents(Constants.BioAssembliesRef, parentID);
			System.out.println("Have BioAssemblies Info from EJB");   	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - BioAssemblies");
			throw new ServerException("Remote Exception getComponents():", e); 	
		}
				
		// Run through the collection of Bodys and build them into the model
		// In the default case, we get one instance of the Body for each eye
		ArrayList transforms = bioMightTransforms.getTransforms();
		System.out.println("Have BioAssemblies, NumTransforms: " + transforms.size());

		// There will be only 1 instance of the Cell Library in the database
		for (int i=0; i<transforms.size(); i++)
		{
			// Get the information for the eye we are creating
			BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
			
			// A hack, I am using the values down below in the X3D method to set some appearance  and material values
			gbioMightTransform  = bioMightTransform;
			componentID = bioMightTransform.getId();
			
			System.out.println("Creating BioAssemblies: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
	
			int viewpoint = Constants.VIEW_INTERNAL;
			if (viewpoint == Constants.VIEW_INTERNAL)
			{
				// Just create an internal representation 
				// using the data from the properties
			}
			else  if (viewpoint == Constants.VIEW_HAWKEYE)
			{
				// Probably won't be using this as its Library entry
				String dimensions = "0.00, 0.00, 0.00";
				String bioPos = "0.00, 0.00, 0.00";
				String bioTemplate="Cell.x3d";
				
				// Generate the BioAssemblies Endothelium if needed 
				boolean bGenerate = false;
				if (bGenerate) {
					generate(parentID, componentID);
				}	
			
				localVP = Constants.VIEW_INTERNAL;
				localLOD = Constants.MAG2X;

				System.out.println("Creating the DNA for parent: " + bioMightTransform.getId());
				dnas = new DNAs(localVP, localLOD, bioMightTransform.getId(), null, bioMightMethods);
				initProperty(Constants.DNAsRef, Constants.DNAs, Constants.DNAsRef, dnas.getComponentID());
				System.out.println("Created the DNAs");								
			}
			
		}
		
		initProperties();
		initMethods();
		
		System.out.println("CreateBioAssemblies Completed");
		
		// First, get all the data from the database
		// Apply the methods to it
		// Save its state
		this.parentID = parentID;
		if (bioMightMethods != null){
			System.out.println("EXECUTING BioAssemblies METHODS: " + bioMightMethods.size());
			//executeMethods(bioMightMethods);
		}
	}
	
	
	public void initProperties() {
		BioMightScale bioScale = new BioMightScale("0.00, 0.00, 0.00");
		BioMightPosition bioPos = new BioMightPosition("0.00, 0.00, 0.00");	
		initProperty(Constants.DNAsRef, Constants.DNAs, Constants.DNAsRef, "BioAssemblies:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, "", false);
		initProperty(Constants.RNAsRef, Constants.RNAs, Constants.RNAsRef, "BioAssemblies:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, "", false);
		//initProperty(Constants.DNARef, Constants.Nucleotides, Constants.NucleotidesRef, "BioAssemblies:0", bioPos, dimensions, Constants.SINGLE_COMPONENT, false);
		}
	
	public void initMethods() {
		
		BioMightMethodView method;

		method = new BioMightMethodView();
		method.setMethodName("setTheme");
		method.setHtmlType("checkbox");
		methods.add(method);	
	
	}
	
	/*******************************************************************
	 * GENERATE the BioAssemblies
	 * 
	 * @param parentID
	 * @param componentID
	 ****************************************************************/
	
	public void generate(String parentID, String componentID)
	{
		// Generate the DescendingBioAssembliesEndothelium		
		BioMightVascularBeanLocal bioMightBean;
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Generating the BioAssembliesEndothelium: " + componentID + "    " + parentID);
			InitialContext ctx = new InitialContext();
			bioMightBean = (BioMightVascularBeanLocal) ctx.lookup("java:global/BioMightWeb/BioMightVacularBean!biomight.ejb.BioMightVascularBeanLocal");
	
			double circumference = 0.25;
		
			if (parentID.equals("Chest:01")) 
			{	
				// Generate the DescendingBioAssembliesEndothelium of the stomach
				// Create 5 sections
				double[] startPos = {-0.3,-8.0, -6.0};
				
				// Create a equilateral octogon
				double x =  startPos[0];
				double y =  startPos[1];
				double z =  startPos[2];

				double[][] currentPoints = { 
	    			{x, y, z},
	    	 		{x-circumference,     y, z-circumference},
	    	   		{x-circumference,     y, z-circumference*2},
	    	   		{x,                   y, z-circumference*3},
	    	   		{x+circumference,     y, z-circumference*3},
	    	   		{x+(circumference*2), y, z-circumference*2},
	    	   		{x+(circumference*2),     y, z-circumference},
	    	  		{x+circumference, y, z}
	    	   		};
	
				System.out.println("Calling Generate BioAssembliesEndothelium: " + componentID + "    " + parentID);
				
				//int success = bioMightBean.generateBioAssemblies("BioAssembliesEndothelium:00001", "BioAssembliesEndothelium", 
				//	"BioAssembliesEndothelium", componentID, parentID, currentPoints);			
	
				//success = bioMightBean.generateBlood("BioAssembliesEndothelium:00001", "BioAssembliesEndothelium", 
				//		"BioAssembliesEndothelium", componentID, parentID, currentPoints);			
				
			}			
			else if (parentID.equals("Abdomen:01")) 
			{	
				// Generate the DescendingBioAssembliesEndothelium of the stomach
				// Create 5 sections
				double[] startPos = {-0.3,-14.0, -6.0};
				
				// Create a equilateral octogon
				double x =  startPos[0];
				double y =  startPos[1];
				double z =  startPos[2];

				double[][] currentPoints = { 
	    			{x, y, z},
	    	 		{x-circumference,     y, z-circumference},
	    	   		{x-circumference,     y, z-circumference*2},
	    	   		{x,                   y, z-circumference*3},
	    	   		{x+circumference,     y, z-circumference*3},
	    	   		{x+(circumference*2), y, z-circumference*2},
	    	   		{x+(circumference*2),     y, z-circumference},
	    	  		{x+circumference, y, z}
	    	   		};
	
				System.out.println("Calling Generate BioAssembliesEndothelium: " + componentID + "    " + parentID);
				
				//int success = bioMightBean.generateBioAssemblies("BioAssembliesEndothelium:00080", "BioAssembliesEndothelium", 
				//	"BioAssembliesEndothelium", componentID, parentID, currentPoints);			
					
			}
			else if (parentID.equals("")) 
			{	
				System.out.println("Calling Generate BioAssembliesEndothelium NoParent");
							
			}
			
			System.out.println("Created BioAssembliesEndothelium Info using EJB");   	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - BioAssembliesEndothelium");
			throw new ServerException("Remote Exception getComponents():", e); 	
		}
	}
	
	

	/********************************************************************************************************************
	 * GET X3D
	 * 
	 * This method will return the X3D for the BioAssemblies.  It runs through each of its components and collects up their
	 * representations and then assembles them into one unified X3D model.
	 * 
	 ********************************************************************************************************************/
	public String getX3D(boolean snipet) {
		
		// Assemble the BioAssemblies
		String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
		"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n " +
		"<X3D profile='Immersive' >\n" +
		"<head>\n" +
		 "<meta name='BioMightImage' content='BioAssemblies.jpg'/>\n" +
		 "<meta name='ExportTime' content='7:45:30'/>\n" +
		 "<meta name='ExportDate' content='08/15/2008'/>\n" +
		 "<meta name='BioMight Version' content='1.0'/>\n" + 
		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='BioAssemblies'\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		

		String body = ""; 		
		int viewpoint = Constants.VIEW_INTERNAL;
		if (viewpoint == Constants.VIEW_INTERNAL)
		{					
			ArrayList transforms = bioMightTransforms.getTransforms();
			for (int i=0; i<transforms.size(); i++)
			{
				// Get the information for the capsomer we are creating
				BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
				System.out.println("Getting X3D for BioAssemblies VIEW INTERNAL: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());				

				//System.out.println("Getting X3D for NucleotideX: " + bioMightTransform.getTranslation().getXPos());
				//System.out.println("Getting X3D for NucleotideY: " + bioMightTransform.getTranslation().getYPos());
				//System.out.println("Getting X3D for NucleotideZ: " + bioMightTransform.getTranslation().getZPos());
				// Change the height and width based on the displacement.
		
				// Get the DNA/RNA Assembly representation
				body += getX3D(bioMightTransform, 0.0);
			}		
			
		}
		else  if (viewpoint == Constants.VIEW_HAWKEYE)
		{
			// We could create an 1 instance of each Cell types by passing in the
			// numElements into the Create method.  Or we can just make a represention of
			// each cell type.
			body =  dnas.getX3D(true);
		}
		
		body+= "<Viewpoint DEF='Viewpoint_DNAs'\n" +
				 "description='Viewpoint1'\n" +
				 "jump='true'\n" +
				 "fieldOfView='0.785'\n" +
				 "position='0.0 0.0 5.0'\n" +
				 "orientation='0 0 1 0'/>\n";	
		
		
		//System.out.println("BioAssemblies Collection X3D: " + body);
		String footer = "</Scene>" + "</X3D>\n";
		
		if (snipet)
			return body;			
		else	
			return header + body + footer;
	}



	/********************************************************************************************************************
	 * GET DNA X3D
	 * 
	 * This method will return the X3D for the Nucleotides.  Each Nucleotide record from the database will yield
	 * a representation of the entire structure at the current level.
	 * 
	 ********************************************************************************************************************/
	public String getX3D(BioMightTransform bioMightTransform, double angle) 
	{
		String body = "";

		String componentTypeOut = "DNA";
		body += "<Transform onmouseover=\"showComponent('DNA');\" DEF='" + componentTypeOut + "  '>\n";
		body += getDnaX3D( bioMightTransform, angle);
		body += "</Transform>\n";
		
		componentTypeOut = "RNA";
		body += "<Transform onmouseover=\"showComponent('RNA');\" DEF='" + componentTypeOut + "  '>\n";
		body += getRnaX3D( bioMightTransform, angle);
		body += "</Transform>\n";
		
		return (body);
	}

	
	/********************************************************************************************************************
	 * GET DNA X3D
	 * 
	 * This method will return the X3D for the Nucleotides.  Each Nucleotide record from the database will yield
	 * a representation of the entire structure at the current level.
	 * 
	 ********************************************************************************************************************/
	public String getDnaX3D(BioMightTransform bioMightTransform, double angle) 
	{
		String body = "";
		

		double radius = 0.5;
			
		bioMightTransform.getTranslation().setXPos(0);
		bioMightTransform.getTranslation().setYPos(0.5);
		bioMightTransform.getTranslation().setZPos(0);
		
		// Set up the base position
		double xBase = bioMightTransform.getTranslation().getXPos();
		double yBase = bioMightTransform.getTranslation().getYPos();
		double zBase = bioMightTransform.getTranslation().getZPos();


		angle += 30;
		body += BioWebDNA.getAdenine(bioMightTransform, radius, angle);
		//body += BioWebDNA.getGuanine(bioMightTransform, radius, angle);
		//body += BioWebDNA.getCytosine(bioMightTransform, radius, angle);
		//body += BioWebDNA.getThymine(bioMightTransform, radius, angle);

		// Set up the Ribose
		double x = xBase - 0.70;
		double y = yBase - 0.0;
		double z = zBase - 0.05;
	
		bioMightTransform.getTranslation().setXPos(x);
		bioMightTransform.getTranslation().setYPos(y);
		bioMightTransform.getTranslation().setZPos(z);
		body += BioWebDNA.getDeOxyRibose(bioMightTransform, radius, angle);
	
		
		// Set up te phosphate position
		 x = xBase - 1.00;
		 y = yBase + 0.475;
		 z = zBase - 0.40;
	
		bioMightTransform.getTranslation().setXPos(x);
		bioMightTransform.getTranslation().setYPos(y);
		bioMightTransform.getTranslation().setZPos(z);
		body += BioWebDNA.getPhosphate(bioMightTransform, radius, angle);

	
		return (body);
	}

	
	/********************************************************************************************************************
	 * GET RNA X3D
	 * 
	 * This method will return the X3D for the Nucleotides.  Each Nucleotide record from the database will yield
	 * a representation of the entire structure at the current level.
	 * 
	 ********************************************************************************************************************/
	public String getRnaX3D(BioMightTransform bioMightTransform, double angle) 
	{
		String body = "";
		

		double radius = 0.5;
			
		bioMightTransform.getTranslation().setXPos(0);
		bioMightTransform.getTranslation().setYPos(-1);
		bioMightTransform.getTranslation().setZPos(0);
		
		// Set up the base position
		double xBase = bioMightTransform.getTranslation().getXPos();
		double yBase = bioMightTransform.getTranslation().getYPos();
		double zBase = bioMightTransform.getTranslation().getZPos();


		angle += 30;
		body += BioWebDNA.getAdenine(bioMightTransform, radius, angle);
		//body += BioWebDNA.getGuanine(bioMightTransform, radius, angle);
		//body += BioWebDNA.getCytosine(bioMightTransform, radius, angle);
		//body += BioWebDNA.getThymine(bioMightTransform, radius, angle);

		// Set up the Ribose
		double x = xBase - 0.70;
		double y = yBase - 0.0;
		double z = zBase - 0.05;
	
		bioMightTransform.getTranslation().setXPos(x);
		bioMightTransform.getTranslation().setYPos(y);
		bioMightTransform.getTranslation().setZPos(z);
		body += BioWebDNA.getRibose(bioMightTransform, radius, angle);
	
		
		// Set up te phosphate position
		 x = xBase - 1.00;
		 y = yBase + 0.475;
		 z = zBase - 0.40;
	
		bioMightTransform.getTranslation().setXPos(x);
		bioMightTransform.getTranslation().setYPos(y);
		bioMightTransform.getTranslation().setZPos(z);
		body += BioWebDNA.getPhosphate(bioMightTransform, radius, angle);

	
		return (body);
	}	
	
	
	
	/********************************************************************************************************************
	 * GET RNA X3D OLD
	 * 
	 * This method will return the X3D for the Nucleotides.  Each Nucleotide record from the database will yield
	 * a representation of the entire structure at the current level.
	 * 
	 ********************************************************************************************************************/
	public String getRnaX3DOLD(BioMightTransform bioMightTransform, double angle) 
	{
		String body = "";
		
		
		double x = bioMightTransform.getTranslation().getXPos();
		double y = bioMightTransform.getTranslation().getYPos() -1.5;
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

		
		return (body);
	}	
	
	
}
