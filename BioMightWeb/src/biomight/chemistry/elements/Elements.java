/*
 * Created on Feb 12, 2007
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.chemistry.elements;

import java.util.ArrayList;

import javax.naming.InitialContext;

import biomight.BioMightBase;
import biomight.Constants;
import biomight.body.head.mouth.Lips;
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
 * Represents a collection of Elements that are commonly
 * used in organics
 * 
 ************************************************************************************************/

public class Elements extends BioMightBase {
	BioMightTransform gbioMightTransform; 
	private ArrayList colors;
	private Aluminum aluminum;
	private Calcium calcium; // 1.5% 
	private Carbon carbon;	// 18%
	private Cobalt cobalt;
	private Copper copper;
	private Chromium chromium; 
	private Flourine flourine;
	private Hydrogen hydrogen; // 10%
	private Iodine iodine;
	private Iron iron;
	private Magnesium magnesium; //0.05%
	private Manganese manganese; //0.05%
	private Nickel nickel;
	private Nitrogen nitrogen;
	private	Oxygen oxygen; // 65%
	private Phosphorus phosphorus; // 1.0%
	private Potassium potassium; // .35%
	private Selenium selenium;
	private Sulfur sulfur; //.25%
	private Sodium sodium; //0.15%
	private Zinc zinc;
		
	
	/************************************************************************
	 * Elements Constructor 
	 *
	 ***********************************************************************/
	public Elements()
	{
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, Constants.ElementsRef, null, null);
	}

	/************************************************************************
	 * Elements Constructor 
	 *
	 ***********************************************************************/
	public Elements(String parentID)
	{
		System.out.print("Calling parameterized Elements Constructor!");
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, parentID, null, null);
	}
	
	
	public Elements(int hierarchy, int LOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
	{
		System.out.println("Calling Molecules with LOD!");
		create(hierarchy, LOD, parentID, bioMightProperties, bioMightMethods);
	}
	
	
	/************************************************************************
	 * Create Elements
	 *
	 ***********************************************************************/

	public void create(int hierarchy, int LOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
	{
		this.setImage("images/Elements.jpg");
		this.setImageHeight(300);
		this.setImageWidth(300);

		System.out.println("Creating Elements for: " + parentID);
		
		// Get the data for the Elements that is defined for this 
		// Cell reference
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Getting ElementsInfo for ParentID: " + parentID);
			InitialContext ctx = new InitialContext();
			BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
			bioMightTransforms = bioMightBean.getComponents(Constants.ElementsRef, parentID);
			System.out.println("Have Elements Info from EJB");   	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - Elements");
			throw new ServerException("Remote Exception getComponents():", e); 	
		}

		// If we have initialization parameters from the form, 
		//  then apply them before constructing the objects.
		if (bioMightMethods != null){
			System.out.println("NEED TO EXECUTE Elements METHODS: " + bioMightMethods.size());
			//executeMethods(bioMightMethods);
		}

		// Create a properties list for the client to use for interaction
		properties = new ArrayList<BioMightPropertyView>();
		
		// Run through the collection of Bodys and build them into the model
		// In the default case, we get one instance of the Body for each eye
		ArrayList transforms = bioMightTransforms.getTransforms();
		System.out.println("Have Elements, NumTransforms : " + transforms.size());

		
		int localVP = Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;

		BioMightScale bioScale = new BioMightScale("0.00, 0.00, 0.00");
		BioMightPosition  bioPos = new BioMightPosition("0.00, 0.00, 0.00");
		String bioTemplate="Elements.x3d";
		
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
			System.out.println("Creating Elements: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
				
			int viewpoint = Constants.VIEW_INTERNAL;
			if (viewpoint == Constants.VIEW_INTERNAL)
			{
				// Just create an internal representation 
				// using the data from the default properties
				System.out.println("Creating Elements - ViewInternal - Just initProperties!");
				initProperties();
			}
			else if (viewpoint == Constants.VIEW_HAWKEYE)
			{
				//componentID = bioMightTransform.getId();
				//System.out.println("Creating Body - Setting ComponentID: " + componentID);
				
				System.out.println("Creating Elements: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
				System.out.println("Creating Elements at Position: " + bioMightTransform.getTranslation().getXPos() + ",  " + 
						bioMightTransform.getTranslation().getYPos() + ",  " +
						bioMightTransform.getTranslation().getZPos());
		
				BioMightPosition bioMightPosition = new BioMightPosition(0.0, 0.0, 0.0);
				
				System.out.println("In Elements - Creating Carbon");
				carbon = new Carbon(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);	
				initProperty(Constants.CarbonRef, Constants.Carbon, Constants.CarbonRef, carbon.getComponentID(), bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);								
				System.out.println("In Elements - Carbon is complete");
			
	
				bioMightPosition = new BioMightPosition(0.0, -1.5, 0.0);
				System.out.println("In Elements - Creating Oxygen Cell");
				oxygen = new Oxygen(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);	
				System.out.println("In Elements - Oxygen is complete");
				//initProperty("CellMembrane", Constants.CellMembrane, Constants.CellRef, capsomer.getComponentID());
				
			
				initProperty(Constants.AluminumRef, Constants.Aluminum, Constants.AluminumRef, "Elements:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
				initProperty(Constants.BoronRef, Constants.Boron, Constants.BoronRef, "Elements:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
				initProperty(Constants.CalciumRef, Constants.AminoAcids, Constants.CalciumRef, "Elements:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
				initProperty(Constants.CobaltRef, Constants.Cobalt, Constants.CobaltRef, "Elements:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
				initProperty(Constants.ChlorineRef, Constants.Chlorine, Constants.ChlorineRef,"Elements:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
				initProperty(Constants.ChromiumRef, Constants.Chromium, Constants.ChromiumRef,"Elements:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);				
				initProperty(Constants.CopperRef, Constants.Copper, Constants.CopperRef,"Elements:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
				initProperty(Constants.FlourineRef, Constants.Flourine, Constants.FlourineRef,"Elements:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
				initProperty(Constants.HydrogenRef, Constants.Hydrogen, Constants.HydrogenRef,"Elements:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
				initProperty(Constants.IodineRef, Constants.Iodine, Constants.IodineRef,"Elements:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
				initProperty(Constants.IronRef, Constants.Iron, Constants.IronRef,"Elements:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
				initProperty(Constants.MagnesiumRef, Constants.Magnesium, Constants.MagnesiumRef,"Elements:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
				initProperty(Constants.ManganesesRef, Constants.Manganeses, Constants.ManganesesRef,"Elements:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
				initProperty(Constants.MolybdenumRef, Constants.Molybdenum, Constants.MolybdenumRef,"Elements:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
				initProperty(Constants.NickelRef, Constants.Nickel, Constants.NickelRef,"Elements:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
				initProperty(Constants.NitrogenRef, Constants.Nitrogen, Constants.NitrogenRef,"Elements:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
				initProperty(Constants.PhosphorusRef, Constants.Phosphorus, Constants.PhosphorusRef,"Elements:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
				initProperty(Constants.PotassiumRef, Constants.Potassium, Constants.PotassiumRef,"Elements:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
				initProperty(Constants.SeleniumRef, Constants.Selenium, Constants.SeleniumRef,"Elements:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
				initProperty(Constants.SiliconRef, Constants.Silicon, Constants.SiliconRef,"Elements:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
				initProperty(Constants.SodiumRef, Constants.Sodium, Constants.SodiumRef,"Elements:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
				initProperty(Constants.SulfurRef, Constants.Sulfur, Constants.SulfurRef,"Elements:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
				initProperty(Constants.VanadiumRef, Constants.Vanadium, Constants.VanadiumRef, "Elements:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
				initProperty(Constants.ZincRef, Constants.Zinc, Constants.ZincRef,"Elements:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
				
			}
		
		}
		
			
	
		initMethods();
		System.out.println("Created Elements");				
	}
	
	
	
	
	public void initProperties() {
		
		BioMightScale bioScale = new BioMightScale("0.00, 0.00, 0.00");
		BioMightPosition bioPos = new BioMightPosition("0.00, 0.00, 0.00");	
		String bioTemplate =""; 

		initProperty(Constants.AluminumsRef, Constants.Aluminums, Constants.AluminumsRef, "Elements:0", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		initProperty(Constants.BoronsRef, Constants.Borons, Constants.BoronsRef, "Elements:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
		initProperty(Constants.CalciumsRef, Constants.Calciums, Constants.CalciumsRef, "Elements:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
		initProperty(Constants.CarbonsRef, Constants.Carbons, Constants.CarbonsRef, "Elements:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
		initProperty(Constants.ChlorinesRef, Constants.Chlorines, Constants.ChlorinesRef,"Elements:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
		initProperty(Constants.ChromiumsRef, Constants.Chromiums, Constants.ChromiumsRef,"Elements:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);				
		initProperty(Constants.CobaltsRef, Constants.Cobalts, Constants.CobaltsRef, "Elements:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
		initProperty(Constants.CoppersRef, Constants.Coppers, Constants.CoppersRef,"Elements:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
		initProperty(Constants.FlourinesRef, Constants.Flourines, Constants.FlourinesRef,"Elements:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
		initProperty(Constants.HydrogensRef, Constants.Hydrogens, Constants.HydrogensRef,"Elements:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
		initProperty(Constants.IodinesRef, Constants.Iodines, Constants.IodinesRef,"Elements:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
		initProperty(Constants.IronsRef, Constants.Irons, Constants.IronsRef,"Elements:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
		initProperty(Constants.MagnesiumsRef, Constants.Magnesiums, Constants.MagnesiumsRef,"Elements:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
		initProperty(Constants.ManganesesRef, Constants.Manganeses, Constants.ManganesesRef,"Elements:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
		initProperty(Constants.MolybdenumsRef, Constants.Molybdenums, Constants.MolybdenumsRef,"Elements:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
		initProperty(Constants.NickelsRef, Constants.Nickels, Constants.NickelsRef,"Elements:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
		initProperty(Constants.NitrogensRef, Constants.Nitrogens, Constants.NitrogensRef,"Elements:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
		initProperty(Constants.OxygensRef, Constants.Oxygens, Constants.OxygensRef,"Elements:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
		initProperty(Constants.PhosphorusesRef, Constants.Phosphoruses, Constants.PhosphorusesRef,"Elements:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
		initProperty(Constants.PotassiumsRef, Constants.Potassiums, Constants.PotassiumsRef,"Elements:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
		initProperty(Constants.SeleniumsRef, Constants.Seleniums, Constants.SeleniumsRef,"Elements:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
		initProperty(Constants.SiliconsRef, Constants.Silicons, Constants.SiliconsRef,"Elements:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
		initProperty(Constants.SodiumsRef, Constants.Sodiums, Constants.SodiumsRef,"Elements:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
		initProperty(Constants.SulfursRef, Constants.Sulfurs, Constants.SulfursRef,"Elements:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
		initProperty(Constants.VanadiumsRef, Constants.Vanadiums, Constants.VanadiumsRef, "Elements:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
		initProperty(Constants.ZincsRef, Constants.Zincs, Constants.ZincsRef,"Elements:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
					
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
		 "<meta name='BioMightImage' content='Elements.jpg'/>\n" +
		 "<meta name='ExportTime' content='7:45:30'/>\n" +
		 "<meta name='ExportDate' content='08/15/2008'/>\n" +
		 "<meta name='BioMight Version' content='1.0'/>\n" + 
		"</head>\n" +
		"<Scene>\n" +		
		"<WorldInfo\n" +
		"title='Elements'\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		

		String body = ""; 		
		int viewpoint = Constants.VIEW_INTERNAL;
		if (viewpoint == Constants.VIEW_INTERNAL)
		{
			double xPos = -6.0;
			double yPos = 0.0;
			double zPos = 0.0;
			
			double xScale = 1.0;
			double yScale = 1.0;
			double zScale = 1.0;
			
			String elements[] = 
				{Constants.AluminumsRef, 
				 Constants.BoronsRef, 
				 Constants.CalciumsRef, 
				 Constants.CarbonsRef, 
				 Constants.ChlorineRef,  
				 Constants.ChromiumRef,
				 Constants.CobaltsRef, 
				 Constants.CoppersRef, 
				 Constants.FlourinesRef, 
				 Constants.HydrogensRef, 
				 Constants.IodinesRef, 
				 Constants.IronsRef, 
				 Constants.MagnesiumsRef, 
				 Constants.ManganesesRef, 
				 Constants.MolybdenumsRef, 
				 Constants.NickelsRef, 
				 Constants.NitrogensRef, 
				 Constants.OxygensRef, 
				 Constants.PhosphorusesRef, 
				 Constants.PotassiumsRef, 
				 Constants.SeleniumsRef, 
				 Constants.SiliconsRef, 
				 Constants.SodiumsRef, 
				 Constants.SulfursRef,  
				 Constants.VanadiumsRef, 
				 Constants.ZincsRef
			};
			
			String elementNames[] = 
				{Constants.AluminumRef, 
				 Constants.BoronRef, 
				 Constants.CalciumRef, 
				 Constants.CarbonRef, 
				 Constants.ChlorineRef, 
				 Constants.ChromiumRef, 
				 Constants.CobaltRef, 
				 Constants.CopperRef, 
				 Constants.FlourineRef, 
				 Constants.HydrogenRef, 
				 Constants.IodineRef, 
				 Constants.IronRef, 
				 Constants.MagnesiumRef,
				 Constants.ManganeseRef, 
				 Constants.MolybdenumRef, 
				 Constants.NickelRef, 
				 Constants.NitrogenRef, 
				 Constants.OxygenRef, 
				 Constants.PhosphorusRef,
				 Constants.PotassiumRef, 
				 Constants.SeleniumRef, 
				 Constants.SiliconRef, 
				 Constants.SodiumRef, 
				 Constants.SulfurRef, 
				 Constants.VanadiumRef,
				 Constants.ZincRef
			};

			
			String elementDesc[] = 
				{Constants.AluminumRef + "-AtomicWeight: 13, %Body: less than 0.01", 	
				 Constants.BoronRef + "-AtomicWeight: 5, %Body: less than 0.01", 
				 Constants.CalciumRef + "-AtomicWeight: 20, %Body: 1.5", 
				 Constants.CarbonRef + "-AtomicWeight: 6, %Body: 18.5", 
				 Constants.ChlorineRef + "-AtomicWeight: 17, %Body: 0.2", 
				 Constants.ChromiumRef + "-AtomicWeight: 24, %Body: less than 0.01", 
				 Constants.CobaltRef + "-AtomicWeight: 27, %Body: less than 0.01", 
				 Constants.CopperRef + "-AtomicWeight: 29, %Body: less than 0.01", 
				 Constants.FlourineRef + "-AtomicWeight: 9, %Body:  less than 0.01", 
				 Constants.HydrogenRef + "-AtomicWeight: 1, %Body: 9.5", 
				 Constants.IodineRef + "-AtomicWeight: 53, %Body:  less than 0.01",  
				 Constants.IronRef + "-AtomicWeight: 26, %Body: less than 0.01",  
				 Constants.MagnesiumRef + "-AtomicWeight: 12, %Body: 0.1",
				 Constants.ManganeseRef + "-AtomicWeight: 25, %Body:  less than 0.01",  
				 Constants.MolybdenumRef + "-AtomicWeight: 42, %Body: less than 0.01", 
				 Constants.NickelRef + "-AtomicWeight: 28, %Body: less than 0.01",  
				 Constants.NitrogenRef + "-AtomicWeight: 7, %Body: 3.2", 
				 Constants.OxygenRef + "-AtomicWeight: 8, %Body: 65", 
				 Constants.PhosphorusRef + "-AtomicWeight: 15, %Body: 1.1",
				 Constants.PotassiumRef + "-AtomicWeight: 19, %Body: 0.40", 
				 Constants.SeleniumRef + "-AtomicWeight: 34, %Body: less than 0.01", 
				 Constants.SiliconRef + "-AtomicWeight: 14, %Body: less than 0.01", 
				 Constants.SodiumRef + "-AtomicWeight: 11, %Body: 0.2", 
				 Constants.SulfurRef + "-AtomicWeight: 16, %Body: 0.3", 
				 Constants.VanadiumRef + "-AtomicWeight: 23, %Body: less than 0.01",
				 Constants.ZincRef + "-AtomicWeight: 30, %Body: less than 0.01"
			};
			
			
			String elementNamePos[] = 
				{"-0.0375, 0.0",  "-0.0575, 0.0",   "0.0175, 0.0",     "-0.0475, 0.0",        "-0.0275, 0.0",   "-0.0275, 0.0",
				 "-0.0575, 0.0",  "0.0, 0.0",        "-2.0, 0.0",      "-0.025, 0.0",         "-2.05, -0.10",      
				 "-0.0375, 0.0",   "0.0250, 0.0",    "0.0175, 0.0",      "0.0175, 0.0",       "0.0, 0.0", 
				 " -0.0675, 0.0",   "-0.025, 0.0",  "-0.10, -0.05",         "0.0, 0.0",          "0.0125, 0.0", 
				 "-0.0250, 0.0",   "0.0, 0.0",       "0.0, 0.0",         "-0.0575, 0.0",      "0.0, 0.0"
			};
			
			for (int i=0; i<elements.length; i++)
			{
				System.out.println("Creating X3D for : " + elementNames[i]);				
				
				if (i==5 || i==10 || i==15 || i==20) {
					xPos += 3; 
					yPos  = 0.0;
				}
				
				
				// Change the height and width based on the displacement.
				body += "\n<Transform onmouseover=\"showComponent('" + elementDesc[i] + "');\" DEF='" + elements[i] + "'\n";
						
			 	body += "translation='" 
			 			+ xPos + " " 
 						+ yPos + " " 
 						+ zPos + "'\n";					
				
			 	
				//System.out.println("Set Translation: ");				

				body +=  "scale='" 	
						+ xScale + " "
				 		+ yScale + " "
				 		+ zScale + "'>\n" +
	
				 "\n<Shape DEF='" + elements[i] + "Shape'\n" +
				    " containerField='children'>\n" +
				    " <Appearance\n" +
				
				    
				    "  containerField='appearance'>\n";

				
				body += "<TextureTransform " +	
						"translation='" + elementNamePos[i] + "'\n" +									

				    	"scale='" 	
				    	+ 0.96 + " "
				    	+ 0.96 + "'/>\n" ;	
			
				body+= " <ImageTexture containerField='texture' \n" +
					" repeatS = 'true' \n" +
					" repeatT = 'true' \n";
				
				
				if (elementNames[i].equals(Constants.PhosphorusRef) || elementNames[i].contains(Constants.ChlorineRef)) {
					body+=  " url='../images/" + elementNames[i] + ".png'/>";
					System.out.println("Creating X3D for Chlorine or PH : " + elementNames[i]);
				}
				else
				{
				body+=  " url='../images/" + elementNames[i] + ".jpg'/>";
				}
			

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
				 	    
				 	
				 	"<Sphere DEF='" + elements[i] + "Sphere'\n" +
				 	"containerField='geometry'\n" +
				 	"radius='" + 1.25 +"'/>\n" +
				 	///radius='" + gbioMightTransform.getRadius() +"'/>\n" +
				 	"</Shape>\n" +
				 	
					"\n<TouchSensor DEF='"+elements[i]+"Touch' \n" +
	                   " description='"+elementDesc[i]+"'\n" +
		               " containerField='children'/> \n" +
	
				 "</Transform>\n";
						
			 	yPos=yPos-2.50;
				//System.out.println("Set Transform: ");				

			}
	
			
			
			
		}
		else  if (viewpoint == Constants.VIEW_HAWKEYE)
		{
			// We could create an 1 instance of each Cell types by passing in the
			// numElements into the Create method.  Or we can just make a represention of
			// each cell type.
			body =  
					carbon.getX3D(true) +
					oxygen.getX3D(true);
		}
		
		
		//System.out.println("Cell Collection X3D: " + body);
		String footer = "</Scene>" + "</X3D>\n";
		
		if (snipet)
			return body;			
		else	
			return header + body + footer;
	}


	/**
	 * @return
	 */
	public Aluminum getAluminum() {
		return aluminum;
	}

	/**
	 * @return
	 */
	public Calcium getCalcium() {
		return calcium;
	}

	/**
	 * @return
	 */
	public Carbon getCarbon() {
		return carbon;
	}

	/**
	 * @return
	 */
	public Cobalt getCobalt() {
		return cobalt;
	}

	/**
	 * @return
	 */
	public Copper getCopper() {
		return copper;
	}

	/**
	 * @return
	 */
	public Flourine getFlourine() {
		return flourine;
	}

	/**
	 * @return
	 */
	public Hydrogen getHydrogen() {
		return hydrogen;
	}

	/**
	 * @return
	 */
	public Iodine getIodine() {
		return iodine;
	}

	/**
	 * @return
	 */
	public Iron getIron() {
		return iron;
	}

	/**
	 * @return
	 */
	public Nickel getNickel() {
		return nickel;
	}

	/**
	 * @return
	 */
	public Nitrogen getNitrogen() {
		return nitrogen;
	}

	/**
	 * @return
	 */
	public Oxygen getOxygen() {
		return oxygen;
	}

	/**
	 * @return
	 */
	public Phosphorus getPhosphorus() {
		return phosphorus;
	}

	/**
	 * @return
	 */
	public Potassium getPotassium() {
		return potassium;
	}

	/**
	 * @return
	 */
	public Selenium getSelenium() {
		return selenium;
	}

	/**
	 * @return
	 */
	public Sodium getSodium() {
		return sodium;
	}


	/**
	 * @return
	 */
	public Zinc getZinc() {
		return zinc;
	}

	/**
	 * @param aluminum
	 */
	public void setAluminum(Aluminum aluminum) {
		this.aluminum = aluminum;
	}

	/**
	 * @param calcium
	 */
	public void setCalcium(Calcium calcium) {
		this.calcium = calcium;
	}

	/**
	 * @param carbon
	 */
	public void setCarbon(Carbon carbon) {
		this.carbon = carbon;
	}

	/**
	 * @param cobalt
	 */
	public void setCobalt(Cobalt cobalt) {
		this.cobalt = cobalt;
	}

	/**
	 * @param copper
	 */
	public void setCopper(Copper copper) {
		this.copper = copper;
	}

	
	public Chromium getChromium() {
		return chromium;
	}

	public void setChromium(Chromium chromium) {
		this.chromium = chromium;
	}

	/**
	 * @param flourine
	 */
	public void setFlourine(Flourine flourine) {
		this.flourine = flourine;
	}

	/**
	 * @param hydrogen
	 */
	public void setHydrogen(Hydrogen hydrogen) {
		this.hydrogen = hydrogen;
	}

	/**
	 * @param iodine
	 */
	public void setIodine(Iodine iodine) {
		this.iodine = iodine;
	}

	/**
	 * @param iron
	 */
	public void setIron(Iron iron) {
		this.iron = iron;
	}

	/**
	 * @param magnesium
	 */
	public void setMagnesium(Magnesium magnesium) {
		this.magnesium = magnesium;
	}

	/**
	 * @param nickel
	 */
	public void setNickel(Nickel nickel) {
		this.nickel = nickel;
	}

	/**
	 * @param nitrogen
	 */
	public void setNitrogen(Nitrogen nitrogen) {
		this.nitrogen = nitrogen;
	}

	/**
	 * @param oxygen
	 */
	public void setOxygen(Oxygen oxygen) {
		this.oxygen = oxygen;
	}

	/**
	 * @param phosphorus
	 */
	public void setPhosphorus(Phosphorus phosphorus) {
		this.phosphorus = phosphorus;
	}

	/**
	 * @param potassium
	 */
	public void setPotassium(Potassium potassium) {
		this.potassium = potassium;
	}

	/**
	 * @param selenium
	 */
	public void setSelenium(Selenium selenium) {
		this.selenium = selenium;
	}

	/**
	 * @param sodium
	 */
	public void setSodium(Sodium sodium) {
		this.sodium = sodium;
	}

	/**
	 * @param zinc
	 */
	public void setZinc(Zinc zinc) {
		this.zinc = zinc;
	}

}
