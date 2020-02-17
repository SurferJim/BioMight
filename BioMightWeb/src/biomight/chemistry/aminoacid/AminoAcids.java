/*
 * Created on Jun 8, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.chemistry.aminoacid;

import biomight.Constants;
import biomight.chemistry.elements.*;
import biomight.BioMightBase;

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
 * Represents a collection of AminoAcids that are commonly used in organics
 * 
 ************************************************************************************************/

public class AminoAcids extends BioMightBase {
	BioMightTransform gbioMightTransform; 
	private ArrayList colors;
	//private Aluminum aluminum;

	private Alanine alanine;
	private Arginine arginine;
	private Asparagine asparagine;
	private AsparticAcid asparticAcid;
	private Cysteine systeine;
	private GlutamicAcid glutamicAcid;
	private Glutamine glutamine;
	private Glycine glycine;
	private Histidine histidine;
	private IsoLeucine isoLeucine;
	private Leucine leucine;
	private Lysine lysine;
	private Methionine methionine;
	private Phenylalanine phenylalanine;
	private Proline proline;
	private Serine serine;
	private Threonine threonine;
	private Tryptophan tryptophan;
	private Tyrosine tyyrosine;
	private Valine valine;		

	/************************************************************************
	 * AminoAcids Constructor 
	 *
	 ***********************************************************************/
	public AminoAcids()
	{
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, Constants.AminoAcidsRef, null, null);
	}

	/************************************************************************
	 * AminoAcids Constructor 
	 *
	 ***********************************************************************/
	public AminoAcids(String parentID)
	{
		System.out.print("Calling parameterized AminoAcids Constructor!");
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, parentID, null, null);
	}
	
	
	public AminoAcids(int hierarchy, int LOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
	{
		System.out.println("Calling AminoAcids with LOD!");
		create(hierarchy, LOD, parentID, bioMightProperties, bioMightMethods);
	}
	
	
	/************************************************************************
	 * Create AminoAcids
	 *
	 ***********************************************************************/

	public void create(int hierarchy, int LOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
	{
		this.setImage("images/AminoAcids.jpg");
		this.setImageHeight(300);
		this.setImageWidth(300);

		System.out.println("Creating AminoAcids for: " + parentID);
		// If we have initialization parameters from the form, 
		//  then apply them before constructing the objects.
		if (bioMightMethods != null){
			System.out.println("NEED TO EXECUTE AminoAcids METHODS: " + bioMightMethods.size());
			//executeMethods(bioMightMethods);
		}

		
		// Get the data for the BioMightSystem that is defined for this 
		// BioMightSystem reference
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Getting AminoAcids for ParentID: " + parentID);
			InitialContext ctx = new InitialContext();
			BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
			bioMightTransforms = bioMightBean.getComponents(Constants.AminoAcidsRef, parentID);
			System.out.println("Have AminoAcids Info from EJB");   	
		}
		catch (Exception e) { 
			System.out.println("Exception Getting Components - AminoAcids");
			throw new ServerException("Remote Exception getComponents():", e); 	
		}
		
		// Run through the collection of Bodys and build them into the model
		// In the default case, we get one instance of the Body for each eye
		ArrayList transforms = bioMightTransforms.getTransforms();
		System.out.println("Have AminoAcids, NumTransforms : " + transforms.size());

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
			System.out.println("Creating AminoAcids: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
				
			int viewpoint = Constants.VIEW_INTERNAL;
			if (viewpoint == Constants.VIEW_INTERNAL)
			{
				// Just create an internal representation 
				// using the data from the default properties
				System.out.println("Creating AminoAcids - ViewInternal - Just initProperties!");
				initProperties();
			}
			else if (viewpoint == Constants.VIEW_HAWKEYE)
			{
				//componentID = bioMightTransform.getId();
				//System.out.println("Creating Body - Setting ComponentID: " + componentID);
				
				System.out.println("Creating AminoAcids: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
				System.out.println("Creating AminoAcids at Position: " + bioMightTransform.getTranslation().getXPos() + ",  " + 
						bioMightTransform.getTranslation().getYPos() + ",  " +
						bioMightTransform.getTranslation().getZPos());
		
				BioMightPosition bioMightPosition = new BioMightPosition(0.0, 0.0, 0.0);
				
				//System.out.println("In AminoAcids - Creating Carbon");
				//carbon = new Carbon(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);	
				//initProperty(Constants.CarbonRef, Constants.Carbon, Constants.CarbonRef, carbon.getComponentID(), bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);								
				//System.out.println("In AminoAcids - Carbon is complete");
			
				initProperty(Constants.LyaseRef, Constants.Lyase, Constants.LyaseRef, "AminoAcids:0", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, true);
				initProperty(Constants.MaltaseRef, Constants.Maltase, Constants.MaltaseRef, "AminoAcids:0", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, true);
				initProperty(Constants.TrypsinRef, Constants.Trypsin, Constants.TrypsinRef, "AminoAcids:0", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, true);
						
			}
		
		}
		
			
		//initMethods();
		System.out.println("Created AminoAcids");				
	}
	
	
	
	public void initProperties() {
		
		BioMightScale bioScale = new BioMightScale("0.00, 0.00, 0.00");
		BioMightPosition bioPos = new BioMightPosition("0.00, 0.00, 0.00");	
		String bioTemplate =""; 

		initProperty(Constants.AlaninesRef, Constants.Alanines, Constants.AlaninesRef, "AminoAcids:0", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, true);
		initProperty(Constants.ArgininesRef, Constants.Arginines, Constants.ArgininesRef, "AminoAcids:0", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, true);
		initProperty(Constants.AsparaginesRef, Constants.Asparagines, Constants.AsparaginesRef, "AminoAcids:0", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, true);
		initProperty(Constants.AsparticAcidsRef, Constants.AsparticAcids, Constants.AsparticAcidsRef, "AminoAcids:0", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, true);
		initProperty(Constants.CysteinesRef, Constants.Cysteines, Constants.CysteinesRef, "AminoAcids:0", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, true);
		initProperty(Constants.GlutamicAcidsRef, Constants.GlutamicAcids, Constants.GlutamicAcidsRef, "AminoAcids:0", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, true);
		initProperty(Constants.GlutaminesRef, Constants.Glutamines, Constants.GlutaminesRef, "AminoAcids:0", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, true);
		initProperty(Constants.GlycinesRef, Constants.Glycines, Constants.GlycinesRef, "AminoAcids:0", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, true);
		initProperty(Constants.HistidinesRef, Constants.Histidines, Constants.HistidinesRef, "AminoAcids:0", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, true);
		initProperty(Constants.IsoLeucinesRef, Constants.IsoLeucines, Constants.IsoLeucinesRef, "AminoAcids:0", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, true);
		initProperty(Constants.LeucinesRef, Constants.Leucines, Constants.LeucinesRef, "AminoAcids:0", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, true);
		initProperty(Constants.LysinesRef, Constants.Lysines, Constants.LysinesRef, "AminoAcids:0", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, true);
		initProperty(Constants.MethioninesRef, Constants.Methionines, Constants.MethioninesRef, "AminoAcids:0", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, true);
		initProperty(Constants.PhenylalaninesRef, Constants.Phenylalanines, Constants.PhenylalaninesRef, "AminoAcids:0", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, true);
		initProperty(Constants.ProlinesRef, Constants.Prolines, Constants.ProlinesRef, "AminoAcids:0", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, true);
		initProperty(Constants.SerinesRef, Constants.Serines, Constants.SerinesRef, "AminoAcids:0", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, true);
		initProperty(Constants.ThreoninesRef, Constants.Threonines, Constants.ThreoninesRef, "AminoAcids:0", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, true);
		initProperty(Constants.TryptophansRef, Constants.Tryptophans, Constants.TryptophansRef, "AminoAcids:0", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, true);	
		initProperty(Constants.TyrosinesRef, Constants.Tyrosines, Constants.TyrosinesRef, "AminoAcids:0", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, true);
		initProperty(Constants.ValinesRef, Constants.Valines, Constants.ValinesRef, "AminoAcids:0", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, true);

		/*
		initProperty(Constants.x, Constants.x, Constants.x, "AminoAcids:0", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
		initProperty(Constants.x, Constants.x, Constants.x, "AminoAcids:0", bioPos, bioScale, Constants.PARENT_COMPONENT, bioTemplate, false);
	
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
	 * This method will return the X3D for the AminoAcids.  It runs through each of its components and collects up their
	 * representations and then assembles them into one unified X3D model.
	 * 
	 ********************************************************************************************************************/
	public String getX3D(boolean snipet) {
		
		// Assemble the AminoAcids
		String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
		"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n " +
		"<X3D profile='Immersive' >\n" +
		"<head>\n" +
		 "<meta name='BioMightImage' content='AminoAcids.jpg'/>\n" +
		 "<meta name='ExportTime' content='7:45:30'/>\n" +
		 "<meta name='ExportDate' content='08/15/2008'/>\n" +
		 "<meta name='BioMight Version' content='1.0'/>\n" + 
		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='AminoAcids'\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		

		System.out.println("Creating X3D for AminoAcids----");	
		String body = ""; 		
		int viewpoint = Constants.VIEW_INTERNAL;
		if (viewpoint == Constants.VIEW_INTERNAL)
		{
			double xPos = -5.0;
			double yPos = 2.0;
			double zPos = 0.0;
			
			double xScale = 1.0;
			double yScale = 1.0;
			double zScale = 1.0;
			
			String aminoAcids[] = 
			{
					Constants.AlanineRef,  Constants.ArginineRef, Constants.AsparagineRef,  Constants.AsparticAcidRef, Constants.CysteineRef, Constants.DGlutamateRef, 
					Constants.GlutamicAcidRef, Constants.GlutamineRef, Constants.GlycineRef, Constants.HistidineRef, Constants.IsoLeucineRef, Constants.LeucineRef, 
					Constants.LysineRef, Constants.MethionineRef, Constants.PhenylalanineRef, Constants.ProlineRef, Constants.SerineRef, Constants.ThreonineRef, 
					Constants.TryptophanRef, Constants.TyrosineRef, Constants.ValineRef
			};
			
		
			String aminoAcidNames[] = 
			{	
					Constants.AlanineRef,  Constants.ArginineRef, Constants.AsparagineRef,  Constants.AsparticAcidRef, Constants.CysteineRef, Constants.DGlutamateRef, 
					Constants.GlutamicAcidRef, Constants.GlutamineRef, Constants.GlycineRef, Constants.HistidineRef, Constants.IsoLeucineRef, Constants.LeucineRef, 
					Constants.LysineRef, Constants.MethionineRef, Constants.PhenylalanineRef, Constants.ProlineRef, Constants.SerineRef, Constants.ThreonineRef, 
					Constants.TryptophanRef, Constants.TyrosineRef, Constants.ValineRef
			};
			
			String aminoAcidDesc[] = 
			{
					Constants.AlanineRef+": CH3-CH(NH2)-COOH",  
					Constants.ArginineRef + ": HN=C(NH2)-NH-(CH2)3-CH(NH2)-COOH", 
					Constants.AsparagineRef + ": H2N-CO-CH2-CH(NH2)-COOH",  
					Constants.AsparticAcidRef + ": HOOC-CH2-CH(NH2)-COOH", 
					Constants.CysteineRef + ": HS-CH2-CH(NH2)-COOH", 
					Constants.DGlutamateRef + ":", 
					Constants.GlutamicAcidRef + ": HOOC-(CH2)2-CH(NH2)-COOH", 
					Constants.GlutamineRef + ": H2N-CO-(CH2)2-CH(NH2)-COOH", 
					Constants.GlycineRef + ": NH2-CH2-COOH", 
					Constants.HistidineRef + ": NH-CH=N-CH=C-CH2-CH(NH2)-COOH", 
					Constants.IsoLeucineRef + ": CH3-CH2-CH(CH3)-CH(NH2)-COOH", 
					Constants.LeucineRef + ": (CH3)2-CH-CH2-CH(NH2)-COOH", 
					Constants.LysineRef + ": H2N-(CH2)4-CH(NH2)-COOH", 
					Constants.MethionineRef + ": CH3-S-(CH2)2-CH(NH2)-COOH", 
					Constants.PhenylalanineRef + ": Ph-CH2-CH(NH2)-COOH", 
					Constants.ProlineRef + ": NH-(CH2)3-CH-COOH", 
					Constants.SerineRef + ": HO-CH2-CH(NH2)-COOH", 
					Constants.ThreonineRef + ": CH3-CH(OH)-CH(NH2)-COOH", 
					Constants.TryptophanRef + ": Ph-NH-CH=C-CH2-CH(NH2)-COOH", 
					Constants.TyrosineRef + ": HO-Ph-CH2-CH(NH2)-COOH", 
					Constants.ValineRef + ": (CH3)2-CH-CH(NH2)-COOH" 
			};
					
			System.out.println("Creating X3D for : " + aminoAcids.length);	
			for (int i=0; i<aminoAcids.length; i++)
			{
				System.out.println("Creating X3D for : " + aminoAcids[i]);				
				

				if (i % 7 == 0) {
					yPos = 2.0;
					xPos += 2.50;
				}
			 
				
		
				
				// Change the height and width based on the displacement.
				body += "\n<Transform DEF='" + aminoAcids[i] + "'\n";
						
			 	body += "translation='" 
			 			+ xPos + " " 
 						+ yPos + " "
 						+ zPos + "'\n";					
				
	
				System.out.println("Set Translation: ");				

				body +=  "scale='" 	+ xScale + " "
				 					+ yScale + " "
				 					+ zScale + "'>\n" +
	
				 "\n<Shape DEF='" + aminoAcids[i] + "Shape'\n" +
				    " containerField='children'>\n" +
				    " <Appearance\n" +
				    "  containerField='appearance'>\n";


				body+= " <ImageTexture containerField='texture'\n"
				
				    + " url='../images/" + aminoAcidNames[i] + ".jpg'/>\n"
				    
				    + " <TextureTransform \n"
				    + " containerField='textureTransform' \n"
				    + " scale='1.5 1.0'/>\n\n";
				   
				  
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
				 	"<Sphere DEF='" + aminoAcids[i] + "Sphere'\n" +
				 	"containerField='geometry'\n" +
				 	"radius='" + 1 +"'/>\n" +
				 	"</Shape>\n" +
				 	
					"\n<TouchSensor DEF='"+aminoAcids[i]+"Touch' \n" +
	                   " description='"+aminoAcidDesc[i]+"'\n" +
		               " containerField='children'/> \n" +
	
				 "</Transform>\n";
						
				System.out.println("Set Transform: ");				

				yPos = yPos -2.0;
			}
	
			
			
		}
		else  if (viewpoint == Constants.VIEW_HAWKEYE)
		{
			// We could create an 1 instance of each Cell types by passing in the
			// numAminoAcids into the Create method.  Or we can just make a represention of
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
