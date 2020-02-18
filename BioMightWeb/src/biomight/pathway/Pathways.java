/*
 * Created on Feb 10, 2007
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.pathway;

import java.util.ArrayList;

import javax.naming.InitialContext;

import biomight.BioMightBase;
import biomight.Constants;
import biomight.ejb.BioMightBeanLocal;
import biomight.exceptions.ServerException;
import biomight.view.BioMightMethodView;
import biomight.view.BioMightPosition;
import biomight.view.BioMightPropertyView;
import biomight.view.BioMightScale;
import biomight.view.BioMightTransform;


/************************************************************************************************
 * @author SurferJim
 *
 * Represents a collection of Pathways that are commonly used in organics
 * 
 ************************************************************************************************/

public class Pathways extends BioMightBase {
	BioMightTransform gbioMightTransform; 
	private ArrayList colors;
		
	
	/************************************************************************
	 * Pathways Constructor 
	 *
	 ***********************************************************************/
	public Pathways()
	{
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, Constants.PathwaysRef, null, null);
	}

	/************************************************************************
	 * Pathways Constructor 
	 *
	 ***********************************************************************/
	public Pathways(String parentID)
	{
		System.out.print("Calling parameterized Pathways Constructor!");
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, parentID, null, null);
	}
	
	
	public Pathways(int hierarchy, int LOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
	{
		System.out.println("Calling Molecules with LOD!");
		create(hierarchy, LOD, parentID, bioMightProperties, bioMightMethods);
	}
	
	
	/************************************************************************
	 * Create Pathways
	 *
	 ***********************************************************************/

	public void create(int hierarchy, int LOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
	{
		this.setImage("images/Pathways.jpg");
		this.setImageHeight(300);
		this.setImageWidth(300);

		System.out.println("Creating Pathways for: " + parentID);
		
		// Get the data for the Pathways that is defined for this 
		// Cell reference
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Getting PathwaysInfo for ParentID: " + parentID);
			InitialContext ctx = new InitialContext();
			BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
			bioMightTransforms = bioMightBean.getComponents(Constants.PathwaysRef, parentID);
			System.out.println("Have Pathways Info from EJB");   	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - Pathways");
			throw new ServerException("Remote Exception getComponents():", e); 	
		}

		// If we have initialization parameters from the form, 
		//  then apply them before constructing the objects.
		if (bioMightMethods != null){
			System.out.println("NEED TO EXECUTE Pathways METHODS: " + bioMightMethods.size());
			//executeMethods(bioMightMethods);
		}

		// Create a properties list for the client to use for interaction
		properties = new ArrayList<BioMightPropertyView>();
		
		// Run through the collection of Bodys and build them into the model
		// In the default case, we get one instance of the Body for each eye
		ArrayList transforms = bioMightTransforms.getTransforms();
		System.out.println("Have Pathways, NumTransforms : " + transforms.size());

		// Run through the body instances and build the bodies.
		// The model should be able to support siamese twins whereas the 
		// bodies are conjoined.
		for (int i=0; i<transforms.size(); i++)
		{
			// Get the information for the eye we are creating
			BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
		
			// A hack, I am using the values down below in the X3D method to set some appearance  and material values
			gbioMightTransform  = bioMightTransform;
			
			componentID = bioMightTransform.getId();
			System.out.println("Creating Pathways: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
				
			int viewpoint = Constants.VIEW_INTERNAL;
			if (viewpoint == Constants.VIEW_INTERNAL)
			{
				// Just create an internal representation 
				// using the data from the default properties
				//initProperties();
			}
			else if (viewpoint == Constants.VIEW_HAWKEYE)
			{
				//componentID = bioMightTransform.getId();
				//System.out.println("Creating Body - Setting ComponentID: " + componentID);
				
				System.out.println("Creating Pathways: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
				System.out.println("Creating Pathways at Position: " + bioMightTransform.getTranslation().getXPos() + ",  " + 
						bioMightTransform.getTranslation().getYPos() + ",  " +
						bioMightTransform.getTranslation().getZPos());
		
				
				int localVP = Constants.VIEW_HAWKEYE;
				int localLOD = Constants.MAG1X;
		
				BioMightPosition bioMightPosition = new BioMightPosition(0.0, 0.0, 0.0);
				
				System.out.println("In Pathways - Creating Krebs");
				//krebs = new Krebs(bioMightTransform.getId(), null, null);
				System.out.println("In Pathways - Krebs is complete");
				//initProperty(Constants.CarbonRef, Constants.CellMembrane, Constants.CellRef, capsomer.getComponentID());
	
				}
		
		}
		
			
		initProperties();
		initMethods();
		System.out.println("Created Pathways");				
	}
	
	
	
	
	public void initProperties() {
		
		BioMightScale bioScale = new BioMightScale("0.00, 0.00, 0.00");
		BioMightPosition bioPos = new BioMightPosition("0.00, 0.00, 0.00");	
		String bioTemplate =""; 

		initProperty(Constants.cAMPPathwayRef, Constants.cAMPPathway, Constants.cAMPPathwayRef, "Pathways:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
		initProperty(Constants.MAPKSignalTransductionPathwayRef, Constants.MAPKSignalTransductionPathway, Constants.MAPKSignalTransductionPathway, "Pathways:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
		initProperty(Constants.Tax1SignalingPathwayRef, Constants.Tax1SignalingPathway, Constants.Tax1SignalingPathwayRef, "Pathways:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
		initProperty(Constants.ImmuneResponseSignalingPathwaysRef, Constants.ImmuneResponseSignalingPathways, Constants.ImmuneResponseSignalingPathwaysRef, "Pathways:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
		
		/***
		BioMightPropertyView property = new BioMightPropertyView();
		property.setPropertyName("Aluminum");
		property.setCanonicalName(Constants.Aluminum);
		properties.add(property);
	
		property = new BioMightPropertyView();
		property.setPropertyName("Calcium");
		property.setCanonicalName(Constants.Calcium);
		properties.add(property);		
		
		property = new BioMightPropertyView();
		property.setPropertyName("Carbon");
		property.setCanonicalName(Constants.Carbon);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("Cobalt");
		property.setCanonicalName(Constants.Cobalt);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("Copper");
		property.setCanonicalName(Constants.Copper);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("Flourine");
		property.setCanonicalName(Constants.Flourine);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("Hydrogen");
		property.setCanonicalName(Constants.Hydrogen);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("Iodine");
		property.setCanonicalName(Constants.Iodine);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("Iron");
		property.setCanonicalName(Constants.Iron);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("Magnesium");
		property.setCanonicalName(Constants.Magnesium);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("Nickel");
		property.setCanonicalName(Constants.Nickel);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("Nitrogen");
		property.setCanonicalName(Constants.Nitrogen);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("Oxygen");
		property.setCanonicalName(Constants.Oxygen);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("Phosphorus");
		property.setCanonicalName(Constants.Phosphorus);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("Potassium");
		property.setCanonicalName(Constants.Potassium);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("Selenium");
		property.setCanonicalName(Constants.Selenium);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("Sulfur");
		property.setCanonicalName(Constants.Sulfur);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("Sodium");
		property.setCanonicalName(Constants.Sodium);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("Zinc");
		property.setCanonicalName(Constants.Zinc);
		properties.add(property);
		***/
	}
	
	
	public void initMethods() {

		ArrayList<BioMightMethodView> methods = new ArrayList<BioMightMethodView>();
		
		BioMightMethodView method = new BioMightMethodView();

		method = new BioMightMethodView();
		method.setMethodName("Create Molecule");
		method.setHtmlType("text");
		methods.add(method);		

		method = new BioMightMethodView();
		method.setMethodName("Ionize");
		method.setHtmlType("checkbox");
		methods.add(method);	

		method = new BioMightMethodView();
		method.setMethodName("deIonize");
		method.setHtmlType("checkbox");
		methods.add(method);	
	}
	
	
	/********************************************************************************************************************
	 * GET X3D
	 * 
	 * This method will return the X3D for the Molecules.  It runs through each of its components and collects up their
	 * representations and then assembles them into one unified X3D model.
	 * 
	 ********************************************************************************************************************/
	public String getX3D(boolean snipet) {
		
		// Assemble the Molecules
		String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
		"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n " +
		"<X3D profile='Immersive' >\n" +
		"<head>\n" +
		 "<meta name='BioMightImage' content='Molecules.jpg'/>\n" +
		 "<meta name='ExportTime' content='7:45:30'/>\n" +
		 "<meta name='ExportDate' content='08/15/2008'/>\n" +
		 "<meta name='BioMight Version' content='1.0'/>\n" + 
		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='Molecules'\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		

		String body = ""; 		
		int viewpoint = Constants.VIEW_INTERNAL;
		if (viewpoint == Constants.VIEW_INTERNAL)
		{
			double xPos = 0.0;
			double yPos = 0.0;
			double zPos = 0.0;
			
			double xScale = 1.0;
			double yScale = 1.0;
			double zScale = 1.0;
			
			String molecules[] = {Constants.cAMPPathwayRef,Constants.MAPKSignalTransductionPathwayRef,Constants.Tax1SignalingPathwayRef, Constants.ImmuneResponseSignalingPathwaysRef};
			for (int i=0; i<molecules.length; i++)
			{
				//System.out.println("Creating X3D for : " + molecules[i]);				
				
				// Change the height and width based on the displacement.
				body += "\n<Transform DEF='" + molecules[i] + "'\n";
						
			 	body += "translation='" 
			 			+ xPos + " " 
 						+ (yPos - i) + " "
 						+ zPos + "'\n";					
				
				//System.out.println("Set Translation: ");				

				body +=  "scale='" 	+ xScale + " "
				 					+ yScale + " "
				 					+ zScale + "'>\n" +
	
				 "\n<Shape DEF='" + molecules[i] + "Shape'\n" +
				    " containerField='children'>\n" +
				    " <Appearance\n" +
				    "  containerField='appearance'>\n";

			
				body+= " <ImageTexture containerField='texture' " +
				    " url='../images/" + molecules[i] + ".jpg'/>";
					
				    
				body+= " <Material DEF='Rust'\n" +
				    "containerField='material'\n" +
				    "ambientIntensity='" 	+ gbioMightTransform.getMaterial().getAmbientIntensity() + "'\n" +
				    "shininess='" 			+ gbioMightTransform.getMaterial().getShininess() + "'\n" +
				    "transparency='" 		+ gbioMightTransform.getMaterial().getTransparency() + "'\n" +
				    "diffuseColor='" + 
				 	    gbioMightTransform.getMaterial().getDiffuseColor().getRed() + " " + 
				 	    gbioMightTransform.getMaterial().getDiffuseColor().getGreen() + " " +
				 	    gbioMightTransform.getMaterial().getDiffuseColor().getBlue() + "'/>\n" +
				 	"</Appearance>\n" +
				 	"<Sphere DEF='" + molecules[i] + "Sphere'\n" +
				 	"containerField='geometry'\n" +
				 	"radius='" + gbioMightTransform.getRadius() +"'/>\n" +
				 	"</Shape>\n" +
				 	
					"\n<TouchSensor DEF='"+molecules[i]+"Touch' \n" +
	                   " description='"+molecules[i]+"'\n" +
		               " containerField='children'/> \n" +
	
				 "</Transform>\n";
						
				//System.out.println("Set Transform: ");				

			}
		
		}
		else  if (viewpoint == Constants.VIEW_HAWKEYE)
		{
			// We could create an 1 instance of each Cell types by passing in the
			// numPathways into the Create method.  Or we can just make a represention of
			// each cell type.
			body = ""; 
					//carbon.getX3D(true) +
					//oxygen.getX3D(true);
		}
		
		
		//System.out.println("Cell Collection X3D: " + body);
		String footer = "</Scene>" + "</X3D>\n";
		
		if (snipet)
			return body;			
		else	
			return header + body + footer;
	}

}
