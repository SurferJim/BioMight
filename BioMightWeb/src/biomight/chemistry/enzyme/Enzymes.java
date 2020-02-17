
package biomight.chemistry.enzyme;

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
 * Represents a collection of Enzymes that are commonly
 * used in organics
 * 
 ************************************************************************************************/

public class Enzymes extends BioMightBase {
	BioMightTransform gbioMightTransform; 
	private ArrayList colors;
	//private Aluminum aluminum;

		

	/************************************************************************
	 * Enzymes Constructor 
	 *
	 ***********************************************************************/
	public Enzymes()
	{
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, Constants.EnzymesRef, null, null);
	}

	/************************************************************************
	 * Enzymes Constructor 
	 *
	 ***********************************************************************/
	public Enzymes(String parentID)
	{
		System.out.print("Calling parameterized Enzymes Constructor!");
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, parentID, null, null);
	}
	
	
	public Enzymes(int hierarchy, int LOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
	{
		System.out.println("Calling Molecules with LOD!");
		create(hierarchy, LOD, parentID, bioMightProperties, bioMightMethods);
	}
	
	
	/************************************************************************
	 * Create Enzymes
	 *
	 ***********************************************************************/

	public void create(int hierarchy, int LOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
	{
		this.setImage("images/Enzymes.jpg");
		this.setImageHeight(300);
		this.setImageWidth(300);

		System.out.println("Creating Enzymes for: " + parentID);
		// Get the data for the Enzymes that is defined for this 
		// Cell reference
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Getting EnzymesInfo for ParentID: " + parentID);
			InitialContext ctx = new InitialContext();
			BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
			bioMightTransforms = bioMightBean.getComponents(Constants.EnzymesRef, parentID);
			System.out.println("Have Enzymes Info from EJB");   	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - Enzymes");
			throw new ServerException("Remote Exception getComponents():", e); 	
		}

		// If we have initialization parameters from the form, 
		//  then apply them before constructing the objects.
		if (bioMightMethods != null){
			System.out.println("NEED TO EXECUTE Enzymes METHODS: " + bioMightMethods.size());
			//executeMethods(bioMightMethods);
		}

		// Create a properties list for the client to use for interaction
		properties = new ArrayList<BioMightPropertyView>();
		
		// Run through the collection of Bodys and build them into the model
		// In the default case, we get one instance of the Body for each eye
		ArrayList transforms = bioMightTransforms.getTransforms();
		System.out.println("Have Enzymes, NumTransforms : " + transforms.size());

		
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
			System.out.println("Creating Enzymes: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
				
			int viewpoint = Constants.VIEW_INTERNAL;
			if (viewpoint == Constants.VIEW_INTERNAL)
			{
				// Just create an internal representation 
				// using the data from the default properties
				System.out.println("Creating Enzymes - ViewInternal - Just initProperties!");
				initProperties();
			}
			else if (viewpoint == Constants.VIEW_HAWKEYE)
			{
				//componentID = bioMightTransform.getId();
				//System.out.println("Creating Body - Setting ComponentID: " + componentID);
				
				System.out.println("Creating Enzymes: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
				System.out.println("Creating Enzymes at Position: " + bioMightTransform.getTranslation().getXPos() + ",  " + 
						bioMightTransform.getTranslation().getYPos() + ",  " +
						bioMightTransform.getTranslation().getZPos());
		
				BioMightPosition bioMightPosition = new BioMightPosition(0.0, 0.0, 0.0);
				
				//System.out.println("In Enzymes - Creating Carbon");
				//carbon = new Carbon(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);	
				//initProperty(Constants.CarbonRef, Constants.Carbon, Constants.CarbonRef, carbon.getComponentID(), bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);								
				//System.out.println("In Enzymes - Carbon is complete");
			
				initProperty(Constants.LyaseRef, Constants.Lyase, Constants.LyaseRef, "Enzymes:0", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
				initProperty(Constants.MaltaseRef, Constants.Maltase, Constants.MaltaseRef, "Enzymes:0", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
				initProperty(Constants.TrypsinRef, Constants.Trypsin, Constants.TrypsinRef, "Enzymes:0", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
						
			}
		
		}
		
			
	
		initMethods();
		System.out.println("Created Enzymes");				
	}
	
	
	
	
	public void initProperties() {
		
		BioMightScale bioScale = new BioMightScale("0.00, 0.00, 0.00");
		BioMightPosition bioPos = new BioMightPosition("0.00, 0.00, 0.00");	
		String bioTemplate =""; 
	
		initProperty(Constants.NOT_ACTIVATED, Constants.Title, Constants.Title, "Enzymes:0", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
	
		initProperty(Constants.AmylaseRef, Constants.Amylase, Constants.AmylaseRef, "Enzymes:0", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		initProperty(Constants.AutoLyticEnzymesRef, Constants.AutoLyticEnzymes, Constants.AutoLyticEnzymesRef, "Enzymes:0", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		initProperty(Constants.ChymotrypsinRef, Constants.Chymotrypsin, Constants.ChymotrypsinRef, "Enzymes:0", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		initProperty(Constants.ChymoTrypsinogenRef, Constants.ChymoTrypsinogen, Constants.ChymoTrypsinogenRef, "Enzymes:0", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		initProperty(Constants.HydrolaseRef, Constants.Hydrolase, Constants.HydrolaseRef, "Enzymes:0", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		initProperty(Constants.IsomeraseRef, Constants.Isomerase, Constants.IsomeraseRef, "Enzymes:0", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		initProperty(Constants.LigaseRef, Constants.Ligase, Constants.LigaseRef, "Enzymes:0", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		initProperty(Constants.LingualLipaseRef, Constants.LingualLipase, Constants.LingualLipaseRef, "Enzymes:0", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		initProperty(Constants.LipaseRef, Constants.Lipase, Constants.LipaseRef, "Enzymes:0", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		initProperty(Constants.LyaseRef, Constants.Lyase, Constants.LyaseRef, "Enzymes:0", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		initProperty(Constants.MaltaseRef, Constants.Maltase, Constants.MaltaseRef, "Enzymes:0", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		initProperty(Constants.MureinHydrolasesRef, Constants.MureinHydrolases, Constants.MureinHydrolasesRef, "Enzymes:0", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		initProperty(Constants.OxidoreductaseRef, Constants.Oxidoreductase, Constants.OxidoreductaseRef, "Enzymes:0", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		initProperty(Constants.PeroxidaseRef, Constants.Peroxidase, Constants.PeroxidaseRef, "Enzymes:0", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		initProperty(Constants.ReductaseRef, Constants.Reductase, Constants.ReductaseRef, "Enzymes:0", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		initProperty(Constants.SuperOxideDismutaseRef, Constants.SuperOxideDismutase, Constants.SuperOxideDismutaseRef, "Enzymes:0", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		initProperty(Constants.ThyroPeroxidaseRef, Constants.ThyroPeroxidase, Constants.ThyroPeroxidaseRef, "Enzymes:0", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		initProperty(Constants.TransferaseRef, Constants.Transferase, Constants.TransferaseRef, "Enzymes:0", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		initProperty(Constants.TrypsinRef, Constants.Trypsin, Constants.TrypsinRef, "Enzymes:0", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		initProperty(Constants.TrypsinogenRef, Constants.Trypsinogen, Constants.TrypsinogenRef, "Enzymes:0", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		//(Constants.IsomereaseRef, Constants.Isomerease, Constants.IsomereaseRef, "Enzymes:0", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);

					
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

		System.out.println("Creating X3D for Enzymes----");	
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
			
			String enzymes[] = 
				{
				Constants.AmylaseRef, Constants.AutoLyticEnzymesRef, Constants.LyaseRef, Constants.MaltaseRef, Constants.TrypsinRef,
				Constants.ChymotrypsinRef, Constants.ChymoTrypsinogenRef, Constants.HydrolaseRef, Constants.IsomeraseRef,
				Constants.LigaseRef, Constants.LingualLipaseRef, Constants.LipaseRef, Constants.LyaseRef, Constants.MaltaseRef, 
				Constants.MureinHydrolasesRef, Constants.OxidoreductaseRef, Constants.PeroxidaseRef, Constants.ReductaseRef,
				Constants.SuperOxideDismutaseRef, Constants.ThyroPeroxidaseRef, Constants.TransferaseRef, Constants.TrypsinRef,
				Constants.TrypsinogenRef 
				};
			
			
			String enzymeNames[] = 
				{
				Constants.AmylaseRef, Constants.AutoLyticEnzymesRef, Constants.LyaseRef, Constants.MaltaseRef, Constants.TrypsinRef,
				Constants.ChymotrypsinRef, Constants.ChymoTrypsinogenRef, Constants.HydrolaseRef, Constants.IsomeraseRef,
				Constants.LigaseRef, Constants.LingualLipaseRef, Constants.LipaseRef, Constants.LyaseRef, Constants.MaltaseRef, 
				Constants.MureinHydrolasesRef, Constants.OxidoreductaseRef, Constants.PeroxidaseRef, Constants.ReductaseRef,
				Constants.SuperOxideDismutaseRef, Constants.ThyroPeroxidaseRef, Constants.TransferaseRef, Constants.TrypsinRef,
				Constants.TrypsinogenRef 
				};
			
			String enzymeDesc[] = 
				{
				Constants.AmylaseRef, Constants.AutoLyticEnzymesRef, Constants.LyaseRef, Constants.MaltaseRef, Constants.TrypsinRef,
				Constants.ChymotrypsinRef, Constants.ChymoTrypsinogenRef, Constants.HydrolaseRef, Constants.IsomeraseRef,
				Constants.LigaseRef, Constants.LingualLipaseRef, Constants.LipaseRef, Constants.LyaseRef, Constants.MaltaseRef, 
				Constants.MureinHydrolasesRef, Constants.OxidoreductaseRef, Constants.PeroxidaseRef, Constants.ReductaseRef,
				Constants.SuperOxideDismutaseRef, Constants.ThyroPeroxidaseRef, Constants.TransferaseRef, Constants.TrypsinRef,
				Constants.TrypsinogenRef 
				};
					
			
			for (int i=0; i<enzymes.length; i++)
			{
				//System.out.println("Creating X3D for : " + enzymes[i]);				
				
				if (i==13) {
					yPos = -1.25;
					xPos = 1.50;
				}
				
				// Change the height and width based on the displacement.
				body += "\n<Transform DEF='" + enzymes[i] + "'\n";
						
			 	body += "translation='" 
			 			+ xPos + " " 
 						+ yPos + " "
 						+ zPos + "'\n";					
				
			 	yPos--;
			 	
				System.out.println("Set Translation: ");				

				body +=  "scale='" 	+ xScale + " "
				 					+ yScale + " "
				 					+ zScale + "'>\n" +
	
				 "\n<Shape DEF='" + enzymes[i] + "Shape'\n" +
				    " containerField='children'>\n" +
				    " <Appearance\n" +
				    "  containerField='appearance'>\n";


				body+= " <ImageTexture containerField='texture' " +
				    " url='../images/" + enzymeNames[i] + ".jpg'/>";
					
		
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
				 	"<Sphere DEF='" + enzymes[i] + "Sphere'\n" +
				 	"containerField='geometry'\n" +
				 	"radius='" + gbioMightTransform.getRadius() +"'/>\n" +
				 	"</Shape>\n" +
				 	
					"\n<TouchSensor DEF='"+enzymes[i]+"Touch' \n" +
	                   " description='"+enzymeDesc[i]+"'\n" +
		               " containerField='children'/> \n" +
	
				 "</Transform>\n";
						
				System.out.println("Set Transform: ");				

			}
	
			
			
			
		}
		else  if (viewpoint == Constants.VIEW_HAWKEYE)
		{
			// We could create an 1 instance of each Cell types by passing in the
			// numEnzymes into the Create method.  Or we can just make a represention of
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
