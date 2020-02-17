
package biomight.chemistry.hormones.lipid;

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
import biomight.view.BioMightTransforms;

/************************************************************************************************
 * @author SurferJim
 *
 * Represents a collection of Lipids that are commonly
 * used in organics
 * 
 ************************************************************************************************/

public class Lipids extends BioMightBase {
	BioMightTransform gbioMightTransform; 
	private ArrayList colors;
	//private Aluminum aluminum;

		

	/************************************************************************
	 * Lipids Constructor 
	 *
	 ***********************************************************************/
	public Lipids()
	{
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, Constants.LipidsRef, null, null);
	}

	/************************************************************************
	 * Lipids Constructor 
	 *
	 ***********************************************************************/
	public Lipids(String parentID)
	{
		System.out.print("Calling parameterized Lipids Constructor!");
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, parentID, null, null);
	}
	
	
	public Lipids(int hierarchy, int LOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
	{
		System.out.println("Calling Molecules with LOD!");
		create(hierarchy, LOD, parentID, bioMightProperties, bioMightMethods);
	}
	
	
	/************************************************************************
	 * Create Lipids
	 *
	 ***********************************************************************/

	public void create(int hierarchy, int LOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
	{
		this.setImage("images/Lipids.jpg");
		this.setImageHeight(300);
		this.setImageWidth(300);

		System.out.println("Creating Lipids for: " + parentID);
	
		// Get the data for the Lipids that is defined for this 
		// Cell reference
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Getting LipidsInfo for ParentID: " + parentID);
			InitialContext ctx = new InitialContext();
			BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
			bioMightTransforms = bioMightBean.getComponents(Constants.LipidsRef, parentID);
			System.out.println("Have Lipids Info from EJB");   	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - Lipids");
			throw new ServerException("Remote Exception getComponents():", e); 	
		}

		// If we have initialization parameters from the form, 
		//  then apply them before constructing the objects.
		if (bioMightMethods != null){
			System.out.println("NEED TO EXECUTE Lipids METHODS: " + bioMightMethods.size());
			//executeMethods(bioMightMethods);
		}

		// Create a properties list for the client to use for interaction
		properties = new ArrayList<BioMightPropertyView>();
		
		// Run through the collection of Bodys and build them into the model
		// In the default case, we get one instance of the Body for each eye
		ArrayList transforms = bioMightTransforms.getTransforms();
		System.out.println("Have Lipids, NumTransforms : " + transforms.size());

		
		int localVP = Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;

		BioMightScale bioScale = new BioMightScale("0.00, 0.00, 0.00");
		BioMightPosition  bioPos = new BioMightPosition("0.00, 0.00, 0.00");
		String bioTemplate="Enymes.x3d";
		
		// Run through the body instances and build the bodies.
		// The model should be able to support siamese twins whereas the 
		// bodies are conjoined.
		for (int i=0; i<transforms.size(); i++)
		{
			// Get the information for the eye we are creating
			BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
		
			// A hack, I am using the values down below in the X3D method to set some appearance  and material values
			gbioMightTransform  = bioMightTransform;
			System.out.println("Set Global: " + gbioMightTransform.getComponentID());
					
			componentID = bioMightTransform.getId();
			System.out.println("Creating Lipids: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
				
			int viewpoint = Constants.VIEW_INTERNAL;
			if (viewpoint == Constants.VIEW_INTERNAL)
			{
				// Just create an internal representation 
				// using the data from the default properties
				System.out.println("Creating Lipids - ViewInternal - Just initProperties!");
				initProperties();
			}
			else if (viewpoint == Constants.VIEW_HAWKEYE)
			{
				//componentID = bioMightTransform.getId();
				//System.out.println("Creating Body - Setting ComponentID: " + componentID);
				
				System.out.println("Creating Lipids: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
				System.out.println("Creating Lipids at Position: " + bioMightTransform.getTranslation().getXPos() + ",  " + 
						bioMightTransform.getTranslation().getYPos() + ",  " +
						bioMightTransform.getTranslation().getZPos());
		
				BioMightPosition bioMightPosition = new BioMightPosition(0.0, 0.0, 0.0);
				
				//System.out.println("In Lipids - Creating Carbon");
				//carbon = new Carbon(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);	
				//initProperty(Constants.CarbonRef, Constants.Carbon, Constants.CarbonRef, carbon.getComponentID(), bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);								
				//System.out.println("In Lipids - Carbon is complete");
			
				initProperty(Constants.NOT_ACTIVATED, Constants.Title, Constants.Title,"", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
				
				initProperty(Constants.CholesterolsRef, Constants.Cholesterols, Constants.CholesterolsRef, "Lipids:0", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
				initProperty(Constants.EicosanoidsRef, Constants.Eicosanoids, Constants.EicosanoidsRef, "Lipids:0", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
				initProperty(Constants.LeukotrienesRef, Constants.Leukotrienes, Constants.LeukotrienesRef, "Lipids:0", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
				initProperty(Constants.ProstacyclinsRef, Constants.Prostacyclin, Constants.ProstacyclinRef, "Lipids:0", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
				initProperty(Constants.ProstaglandinEsRef, Constants.ProstaglandinE, Constants.ProstaglandinERef, "Lipids:0", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
				initProperty(Constants.ProstaglandinsRef, Constants.Prostaglandins, Constants.ProstaglandinsRef, "Lipids:0", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
				initProperty(Constants.ThromboxanesRef, Constants.Thromboxanes, Constants.ThromboxanesRef, "Lipids:0", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
							
			}
		
		}
		
			
	
		initMethods();
		System.out.println("Created Lipids");				
	}
	
	
		
	public void initProperties() {
		
		BioMightScale bioScale = new BioMightScale("0.00, 0.00, 0.00");
		BioMightPosition bioPos = new BioMightPosition("0.00, 0.00, 0.00");	
		String bioTemplate =""; 

		initProperty(Constants.NOT_ACTIVATED, Constants.Title, Constants.Title,"", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
		
		initProperty(Constants.CholesterolsRef, Constants.Cholesterols, Constants.CholesterolsRef, "Lipids:0", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		initProperty(Constants.EicosanoidsRef, Constants.Eicosanoids, Constants.EicosanoidsRef, "Lipids:0", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		initProperty(Constants.LeukotrienesRef, Constants.Leukotrienes, Constants.LeukotrienesRef, "Lipids:0", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		initProperty(Constants.ProstacyclinsRef, Constants.Prostacyclin, Constants.ProstacyclinRef, "Lipids:0", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		initProperty(Constants.ProstaglandinEsRef, Constants.ProstaglandinE, Constants.ProstaglandinERef, "Lipids:0", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		initProperty(Constants.ProstaglandinsRef, Constants.Prostaglandins, Constants.ProstaglandinsRef, "Lipids:0", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		initProperty(Constants.ThromboxanesRef, Constants.Thromboxanes, Constants.ThromboxanesRef, "Lipids:0", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		
		/*
		initProperty(Constants.x, Constants.x, Constants.x, "Lipids:0", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		initProperty(Constants.x, Constants.x, Constants.x, "Lipids:0", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		initProperty(Constants.x, Constants.x, Constants.x, "Lipids:0", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		initProperty(Constants.x, Constants.x, Constants.x, "Lipids:0", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		initProperty(Constants.x, Constants.x, Constants.x, "Lipids:0", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		initProperty(Constants.x, Constants.x, Constants.x, "Lipids:0", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		initProperty(Constants.x, Constants.x, Constants.x, "Lipids:0", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		initProperty(Constants.x, Constants.x, Constants.x, "Lipids:0", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		initProperty(Constants.x, Constants.x, Constants.x, "Lipids:0", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		initProperty(Constants.x, Constants.x, Constants.x, "Lipids:0", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		initProperty(Constants.x, Constants.x, Constants.x, "Lipids:0", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		initProperty(Constants.x, Constants.x, Constants.x, "Lipids:0", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
	
		*/	
					
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

		System.out.println("Creating X3D for Lipids----");	
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
			
			String lipids[] = 
			{
				Constants.CholesterolsRef, Constants.EicosanoidsRef, Constants.LeukotrienesRef, Constants.ProstacyclinsRef, Constants.ProstaglandinEsRef, 
				Constants.ProstaglandinsRef, Constants.ThromboxanesRef
			};
			
		
			String lipidNames[] = 
			{
				Constants.CholesterolsRef, Constants.EicosanoidsRef, Constants.LeukotrienesRef, Constants.ProstacyclinsRef, Constants.ProstaglandinEsRef, 
				Constants.ProstaglandinsRef, Constants.ThromboxanesRef				
			};
			
			String lipidDesc[] = 
			{
				Constants.CholesterolsRef, Constants.EicosanoidsRef, Constants.LeukotrienesRef, Constants.ProstacyclinsRef, Constants.ProstaglandinEsRef, 
				Constants.ProstaglandinsRef, Constants.ThromboxanesRef
			};
					
			System.out.println("Creating X3D for : " + lipids.length);	
			for (int i=0; i<lipids.length; i++)
			{
				System.out.println("Creating X3D for : " + lipids[i]);				
				
				if (i==15) {
					yPos = -0.5;
					xPos = 1.50;
				}
				
				// Change the height and width based on the displacement.
				body += "\n<Transform DEF='" + lipids[i] + "'\n";
						
			 	body += "translation='" 
			 			+ xPos + " " 
 						+ yPos + " "
 						+ zPos + "'\n";					
				
			 	yPos--;
			 	
				System.out.println("Set Translation: ");				

				body +=  "scale='" 	+ xScale + " "
				 					+ yScale + " "
				 					+ zScale + "'>\n" +
	
				 "\n<Shape DEF='" + lipids[i] + "Shape'\n" +
				    " containerField='children'>\n" +
				    " <Appearance\n" +
				    "  containerField='appearance'>\n";


				body+= " <ImageTexture containerField='texture' " +
				    " url='../images/" + lipidNames[i] + ".jpg'/>";
					
		
				// HACKY
				System.out.println("Retreiving Global: " + gbioMightTransform.getComponentID());
				
				
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
				 	"<Sphere DEF='" + lipids[i] + "Sphere'\n" +
				 	"containerField='geometry'\n" +
				 	"radius='" + gbioMightTransform.getRadius() +"'/>\n" +
				 	"</Shape>\n" +
				 	
					"\n<TouchSensor DEF='"+lipids[i]+"Touch' \n" +
	                   " description='"+lipidDesc[i]+"'\n" +
		               " containerField='children'/> \n" +
	
				 "</Transform>\n";
						
				System.out.println("Set Transform: ");				

			}
	
			
			
		}
		else  if (viewpoint == Constants.VIEW_HAWKEYE)
		{
			// We could create an 1 instance of each Cell types by passing in the
			// numLipids into the Create method.  Or we can just make a represention of
			// each cell type.
			body =  "";
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
