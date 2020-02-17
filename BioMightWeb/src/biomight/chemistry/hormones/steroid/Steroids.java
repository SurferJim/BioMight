
package biomight.chemistry.hormones.steroid;

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
 * Represents a collection of Steroids that are commonly
 * used in organics
 * 
 ************************************************************************************************/

public class Steroids extends BioMightBase {
	BioMightTransform gbioMightTransform; 
	private ArrayList colors;
	//private Aluminum aluminum;

		

	/************************************************************************
	 * Steroids Constructor 
	 *
	 ***********************************************************************/
	public Steroids()
	{
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, Constants.SteroidsRef, null, null);
	}

	/************************************************************************
	 * Steroids Constructor 
	 *
	 ***********************************************************************/
	public Steroids(String parentID)
	{
		System.out.print("Calling parameterized Steroids Constructor!");
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, parentID, null, null);
	}
	
	
	public Steroids(int hierarchy, int LOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
	{
		System.out.println("Calling Molecules with LOD!");
		create(hierarchy, LOD, parentID, bioMightProperties, bioMightMethods);
	}
	
	
	/************************************************************************
	 * Create Steroids
	 *
	 ***********************************************************************/

	public void create(int hierarchy, int LOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
	{
		this.setImage("images/Steroids.jpg");
		this.setImageHeight(300);
		this.setImageWidth(300);

		System.out.println("Creating Steroids for: " + parentID);
					
		// Get the data for the Steroids that is defined for this 
		// Cell reference
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Getting SteroidsInfo for ParentID: " + parentID);
			InitialContext ctx = new InitialContext();
			BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
			bioMightTransforms = bioMightBean.getComponents(Constants.SteroidsRef, parentID);
			System.out.println("Have Steroids Info from EJB");   	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - Steroids");
			throw new ServerException("Remote Exception getComponents():", e); 	
		}

		// If we have initialization parameters from the form, 
		//  then apply them before constructing the objects.
		if (bioMightMethods != null){
			System.out.println("NEED TO EXECUTE Steroids METHODS: " + bioMightMethods.size());
			//executeMethods(bioMightMethods);
		}

		// Create a properties list for the client to use for interaction
		properties = new ArrayList<BioMightPropertyView>();
		
		// Run through the collection of Bodys and build them into the model
		// In the default case, we get one instance of the Body for each eye
		ArrayList transforms = bioMightTransforms.getTransforms();
		System.out.println("Have Steroids, NumTransforms : " + transforms.size());

		
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
			System.out.println("Creating Steroids: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
				
			int viewpoint = Constants.VIEW_INTERNAL;
			if (viewpoint == Constants.VIEW_INTERNAL)
			{
				// Just create an internal representation 
				// using the data from the default properties
				System.out.println("Creating Steroids - ViewInternal - Just initProperties!");
				initProperties();
			}
			else if (viewpoint == Constants.VIEW_HAWKEYE)
			{
				//componentID = bioMightTransform.getId();
				//System.out.println("Creating Body - Setting ComponentID: " + componentID);
				
				System.out.println("Creating Steroids: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
				System.out.println("Creating Steroids at Position: " + bioMightTransform.getTranslation().getXPos() + ",  " + 
						bioMightTransform.getTranslation().getYPos() + ",  " +
						bioMightTransform.getTranslation().getZPos());
		
				BioMightPosition bioMightPosition = new BioMightPosition(0.0, 0.0, 0.0);
				
				//System.out.println("In Steroids - Creating Carbon");
				//carbon = new Carbon(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);	
				//initProperty(Constants.CarbonRef, Constants.Carbon, Constants.CarbonRef, carbon.getComponentID(), bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);								
				//System.out.println("In Steroids - Carbon is complete");
			
				initProperty(Constants.LyaseRef, Constants.Lyase, Constants.LyaseRef, "Steroids:0", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
				initProperty(Constants.MaltaseRef, Constants.Maltase, Constants.MaltaseRef, "Steroids:0", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
				initProperty(Constants.TrypsinRef, Constants.Trypsin, Constants.TrypsinRef, "Steroids:0", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
						
			}
		
		}
		
			
	
		initMethods();
		System.out.println("Created Steroids");				
	}
	
	
	
	
	public void initProperties() {
		
		BioMightScale bioScale = new BioMightScale("0.00, 0.00, 0.00");
		BioMightPosition bioPos = new BioMightPosition("0.00, 0.00, 0.00");	
		String bioTemplate =""; 
		initProperty(Constants.NOT_ACTIVATED, Constants.Title, Constants.Title,"", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
		
		initProperty(Constants.AlloPregnenoloneRef, Constants.AlloPregnenolone, Constants.AlloPregnenoloneRef, "Steroids:0", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		initProperty(Constants.BetaMethasoneRef, Constants.BetaMethasone, Constants.BetaMethasoneRef, "Steroids:0", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		initProperty(Constants.CorticoSteroneRef, Constants.CorticoSterone, Constants.CorticoSteroneRef, "Steroids:0", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		initProperty(Constants.CortisoneRef, Constants.CortisoneRef, Constants.CortisoneRef, "Steroids:0", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		initProperty(Constants.DeOxyCorticoSteroneRef, Constants.DeOxyCorticoSterone, Constants.DeOxyCorticoSteroneRef, "Steroids:0", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		initProperty(Constants.DexaMethasoneRef, Constants.DexaMethasone, Constants.DexaMethasoneRef, "Steroids:0", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		initProperty(Constants.PrednisoloneRef, Constants.Prednisolone, Constants.PrednisoloneRef, "Steroids:0", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		initProperty(Constants.PrednisoneRef, Constants.Prednisone, Constants.PrednisoneRef, "Steroids:0", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		initProperty(Constants.PregnenoloneRef, Constants.Pregnenolone, Constants.PregnenoloneRef, "Steroids:0", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		initProperty(Constants.SerotoninRef, Constants.Serotonin, Constants.SerotoninRef, "Steroids:0", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		initProperty(Constants.SpironolactoneRef, Constants.Spironolactone, Constants.SpironolactoneRef, "Steroids:0", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		initProperty(Constants.TriamcinoloneRef, Constants.Triamcinolone, Constants.TriamcinoloneRef, "Steroids:0", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		initProperty(Constants.CortisolRef, Constants.Cortisol, Constants.CortisolRef, "Steroids:0", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		initProperty(Constants.AldosteroneRef, Constants.Aldosterone, Constants.AldosteroneRef, "Steroids:0", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		initProperty(Constants.AndrogenRef, Constants.Androgen, Constants.AndrogenRef, "Steroids:0", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		initProperty(Constants.AndrogenBindingProteinRef, Constants.AndrogenBindingProtein, Constants.AndrogenBindingProteinRef, "Steroids:0", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		initProperty(Constants.AndrostenedioneRef, Constants.Androstenedione, Constants.AndrostenedioneRef, "Steroids:0", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		initProperty(Constants.DeHydroEpiAndrosteroneRef, Constants.DeHydroEpiAndrosterone, Constants.DeHydroEpiAndrosteroneRef, "Steroids:0", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		initProperty(Constants.DeHydroEpiAndrosteroneSulfateRef, Constants.DeHydroEpiAndrosteroneSulfate, Constants.DeHydroEpiAndrosteroneSulfateRef, "Steroids:0", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		initProperty(Constants.DHEARef, Constants.DHEA, Constants.DHEARef, "Steroids:0", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		initProperty(Constants.DHEASRef, Constants.DHEAS, Constants.DHEASRef, "Steroids:0", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		initProperty(Constants.DihydrotestosteroneRef, Constants.Dihydrotestosterone, Constants.DihydrotestosteroneRef, "Steroids:0", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		initProperty(Constants.DynorphinRef, Constants.Dynorphin, Constants.DynorphinRef, "Steroids:0", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		initProperty(Constants.SexHormoneBindingGlobulinRef, Constants.SexHormoneBindingGlobulin, Constants.SexHormoneBindingGlobulinRef, "Steroids:0", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		initProperty(Constants.TestosteroneRef, Constants.TestosteroneRef, Constants.TestosteroneRef, "Steroids:0", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		initProperty(Constants.EstradiolRef, Constants.Estradiol, Constants.EstradiolRef, "Steroids:0", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		initProperty(Constants.EstrogenRef, Constants.Estrogen, Constants.EstrogenRef, "Steroids:0", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		initProperty(Constants.EstroneRef, Constants.Estrone, Constants.EstroneRef, "Steroids:0", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		initProperty(Constants.ProgesteroneRef, Constants.Progesterone, Constants.ProgesteroneRef, "Steroids:0", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		initProperty(Constants.ProgestinsRef, Constants.Progestins, Constants.ProgestinsRef, "Steroids:0", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		
		
		/*
		initProperty(Constants.x, Constants.x, Constants.x, "Steroids:0", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		initProperty(Constants.x, Constants.x, Constants.x, "Steroids:0", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		initProperty(Constants.x, Constants.x, Constants.x, "Steroids:0", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		initProperty(Constants.x, Constants.x, Constants.x, "Steroids:0", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		initProperty(Constants.x, Constants.x, Constants.x, "Steroids:0", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		initProperty(Constants.x, Constants.x, Constants.x, "Steroids:0", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		initProperty(Constants.x, Constants.x, Constants.x, "Steroids:0", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		initProperty(Constants.x, Constants.x, Constants.x, "Steroids:0", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		initProperty(Constants.x, Constants.x, Constants.x, "Steroids:0", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
	
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

		System.out.println("Creating X3D for Steroids----");	
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
			
			String steroids[] = 
				{
					Constants.AlloPregnenoloneRef, Constants.BetaMethasoneRef, Constants.CorticoSteroneRef, Constants.CortisoneRef, 
					Constants.DeOxyCorticoSteroneRef, Constants.DexaMethasoneRef, Constants.PrednisoloneRef, Constants.PrednisoneRef, 
					Constants.PregnenoloneRef, Constants.SerotoninRef, Constants.SpironolactoneRef, Constants.TriamcinoloneRef, 
					Constants.CortisolRef, Constants.AldosteroneRef, Constants.AndrogenRef, Constants.AndrogenBindingProteinRef, 
					Constants.AndrostenedioneRef, Constants.DeHydroEpiAndrosteroneRef, Constants.DeHydroEpiAndrosteroneSulfateRef, 
					Constants.DHEARef, Constants.DHEASRef, Constants.DihydrotestosteroneRef, Constants.DynorphinRef, 
					Constants.SexHormoneBindingGlobulinRef, Constants.TestosteroneRef, Constants.EstradiolRef, Constants.EstrogenRef, 
					Constants.EstroneRef, Constants.ProgesteroneRef, Constants.ProgestinsRef 
				};
			
			
			String steroidNames[] = 
				{
					Constants.AlloPregnenoloneRef, Constants.BetaMethasoneRef, Constants.CorticoSteroneRef, Constants.CortisoneRef, 
					Constants.DeOxyCorticoSteroneRef, Constants.DexaMethasoneRef, Constants.PrednisoloneRef, Constants.PrednisoneRef, 
					Constants.PregnenoloneRef, Constants.SerotoninRef, Constants.SpironolactoneRef, Constants.TriamcinoloneRef, 
					Constants.CortisolRef, Constants.AldosteroneRef, Constants.AndrogenRef, Constants.AndrogenBindingProteinRef, 
					Constants.AndrostenedioneRef, Constants.DeHydroEpiAndrosteroneRef, Constants.DeHydroEpiAndrosteroneSulfateRef, 
					Constants.DHEARef, Constants.DHEASRef, Constants.DihydrotestosteroneRef, Constants.DynorphinRef, 
					Constants.SexHormoneBindingGlobulinRef, Constants.TestosteroneRef, Constants.EstradiolRef, Constants.EstrogenRef, 
					Constants.EstroneRef, Constants.ProgesteroneRef, Constants.ProgestinsRef 				
			};
			
			String steroidDesc[] = 
				{
					Constants.AlloPregnenoloneRef, Constants.BetaMethasoneRef, Constants.CorticoSteroneRef, Constants.CortisoneRef, 
					Constants.DeOxyCorticoSteroneRef, Constants.DexaMethasoneRef, Constants.PrednisoloneRef, Constants.PrednisoneRef, 
					Constants.PregnenoloneRef, Constants.SerotoninRef, Constants.SpironolactoneRef, Constants.TriamcinoloneRef, 
					Constants.CortisolRef, Constants.AldosteroneRef, Constants.AndrogenRef, Constants.AndrogenBindingProteinRef, 
					Constants.AndrostenedioneRef, Constants.DeHydroEpiAndrosteroneRef, Constants.DeHydroEpiAndrosteroneSulfateRef, 
					Constants.DHEARef, Constants.DHEASRef, Constants.DihydrotestosteroneRef, Constants.DynorphinRef, 
					Constants.SexHormoneBindingGlobulinRef, Constants.TestosteroneRef, Constants.EstradiolRef, Constants.EstrogenRef, 
					Constants.EstroneRef, Constants.ProgesteroneRef, Constants.ProgestinsRef 
			};
					
			System.out.println("Creating X3D for : " + steroids.length);	
			for (int i=0; i<steroids.length; i++)
			{
				System.out.println("Creating X3D for : " + steroids[i]);				
				
				if (i==15) {
					yPos = -0.5;
					xPos = 1.50;
				}
				
				// Change the height and width based on the displacement.
				body += "\n<Transform DEF='" + steroids[i] + "'\n";
						
			 	body += "translation='" 
			 			+ xPos + " " 
 						+ yPos + " "
 						+ zPos + "'\n";					
				
			 	yPos--;
			 	
				System.out.println("Set Translation: ");				

				body +=  "scale='" 	+ xScale + " "
				 					+ yScale + " "
				 					+ zScale + "'>\n" +
	
				 "\n<Shape DEF='" + steroids[i] + "Shape'\n" +
				    " containerField='children'>\n" +
				    " <Appearance\n" +
				    "  containerField='appearance'>\n";


				body+= " <ImageTexture containerField='texture' " +
				    " url='../images/" + steroidNames[i] + ".jpg'/>";
					
		
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
				 	"<Sphere DEF='" + steroids[i] + "Sphere'\n" +
				 	"containerField='geometry'\n" +
				 	"radius='" + gbioMightTransform.getRadius() +"'/>\n" +
				 	"</Shape>\n" +
				 	
					"\n<TouchSensor DEF='"+steroids[i]+"Touch' \n" +
	                   " description='"+steroidDesc[i]+"'\n" +
		               " containerField='children'/> \n" +
	
				 "</Transform>\n";
						
				System.out.println("Set Transform: ");				

			}
	
			
			
		}
		else  if (viewpoint == Constants.VIEW_HAWKEYE)
		{
			// We could create an 1 instance of each Cell types by passing in the
			// numSteroids into the Create method.  Or we can just make a represention of
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
