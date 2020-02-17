/*
 * Created on Oct 15, 2007
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.cell.nucleus;
import java.util.ArrayList;

import javax.naming.InitialContext;

import biomight.BioMightBase;
import biomight.Constants;
import biomight.ejb.BioMightBeanLocal;
import biomight.exceptions.ServerException;
import biomight.view.BioMightMethodView;
import biomight.view.BioMightPropertyView;
import biomight.view.BioMightTransform;
import biomightweb.util.BioWebX3DUtils;


/**********************************************************
 * @author SurferJim
 *
 * Create a representation of a Nuclueus
 ***********************************************************/

public class Nucleus extends BioMightBase{
	private NuclearPores nuclearPores; 
	private Nucleolus  nucleolus;
	private NuclearEnvelope nuclearEnvelope;
	private MitoticSpindels mitoticSpindels;
	

	public Nucleus()
	{
		int localVP =  Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG2X;
		create(localVP, localLOD, Constants.NucleusRef, null, null);
	}

	public Nucleus(String parentID)
	{
		int localVP =  Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, parentID, null, null);
	}
	
	public Nucleus(String parentID, ArrayList<BioMightMethodView> bioMightMethods) 
	{
		int localVP =  Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, parentID, null, bioMightMethods);
	}

	public Nucleus(int lod, String parentID, ArrayList<BioMightMethodView> bioMightMethods) 
	{
		int localVP =  Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, parentID, null, bioMightMethods);
	}
	
	public Nucleus(int localVP, int localLOD, String parentID, ArrayList<BioMightMethodView> bioMightMethods)
	{				
		create(localVP, localLOD, parentID, null, bioMightMethods);	
	}
	
	public Nucleus(int localVP, int localLOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
	{		
		create(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);
	}
	
	/*****************************************************************************************
	 * CREATE CELL NUCLEUS
	 * 
	 * Create the Nucleus
	 * 
	 * ***************************************************************************************/
	
	private void create(int localVP, int localLOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods) 
	{
		this.setImage("images/Nucleus.jpg");
		this.setImageHeight(300);
		this.setImageWidth(300);
		this.parentID = parentID;
		
		this.viewPerspective = localVP;
		this.lod = localLOD;

		
		// At this momment, there is one Nucleus per Cell
		if (localVP == Constants.VIEW_DETACHED)
		{	
		
		}
		// Get the data from the database
		else if (localVP == Constants.VIEW_HAWKEYE)
		{
			// Get the information from the database via the Enterprise Bean		
			try {
				// Get the information from the database via the Enterprise Bean		
				System.out.println("Getting NucleusInfo - HawkEye - for ParentID: " + parentID);
				InitialContext ctx = new InitialContext();
				BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
				bioMightTransforms = bioMightBean.getComponents(Constants.NucleusRef, parentID);
				System.out.println("Have Nucleus Info from EJB");   	
			}catch (Exception e) { 
				System.out.println("Exception Getting Components - Nucleus");
				throw new ServerException("Remote Exception getComponents():", e); 	
			}
		
			
			// Build the membrane from its constituent components
			// Run through the collection of ---- and build them into the model
			ArrayList transforms = bioMightTransforms.getTransforms();
			System.out.println("Have Nucleus NumTransforms: " + transforms.size());
	
			for (int i=0; i<transforms.size(); i++)
			{
				// Get the information for the Nucleus we are creating
				BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
				System.out.println("Creating Nucleus: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
				this.componentID = bioMightTransform.getId();
	
				if  (localLOD == Constants.MAG1X)
				{
					// We are grabbing our data for the Nucleus at this level
					// It will be represented by a simple sphere
					System.out.println("Using Nucleus at LOD: " + localLOD);
					initProperties();
				}	
				else if (localLOD == Constants.MAG2X)
				{
					System.out.println("Using Nucleus at LOD: " + localLOD);					
					System.out.println("Creating NuclearEnvelope: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());			
					//nuclearEnvelope = new NuclearEnvelope("NucleusCholesterol", bioMightTransform.getId(), bioMightMethods);		
					//initProperty("Constants.NuclearEnvelopeRef", Constants.NuclearEnvelope, Constants.NuclearEnvelopeRef, nuclearEnvelope.getComponentID());						
					System.out.println("Nucleus - NuclearEnvelop is created");
				}					
			}
		}
		
		initMethods();
		
		System.out.println("Create Nucleus Complete: " + parentID);
		
		// First, get all the data from the database
		// Apply the methods to it
		// Save its state
		if (bioMightMethods != null){
			System.out.println("EXECUTING Nucleus METHODS: " + bioMightMethods.size());
			//executeMethods(bioMightMethods);
		}
		
	}
	
	
	public void initProperties() {
		
		BioMightPropertyView property = new BioMightPropertyView();
		property.setPropertyName("NuclearPores");
		property.setCanonicalName(Constants.NuclearPores);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("Nucleolus");
		property.setCanonicalName(Constants.Nucleolus);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("NuclearEnvelope");
		property.setCanonicalName(Constants.NuclearEnvelope);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("MitoticSpindels");
		property.setCanonicalName(Constants.MitoticSpindels);
		properties.add(property);
	}
	
	
	public void initMethods() {
	
		BioMightMethodView method = new BioMightMethodView();
		method.setMethodName("Transcribe");
		method.setHtmlType("checkbox");
		methods.add(method);

		method = new BioMightMethodView();
		method.setMethodName("Close Pores");
		method.setHtmlType("checkbox");
		methods.add(method);

		method = new BioMightMethodView();
		method.setMethodName("Open Pores");
		method.setHtmlType("checkbox");
		methods.add(method);
	}



	/********************************************************************************************************************
	 * GET X3D
	 * 
	 * This method will return the X3D for the Cell.  It runs through each of its components and collects up their
	 * representations and then assembles them into one unified X3D model.
	 * 
	 ********************************************************************************************************************/
	public String getX3D(boolean snipet) {
		
		// Assembe the Nucleus
		String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
		"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n " +
		"<X3D profile='Immersive' >\n" +
		"<head>\n" +
		 "<meta name='BioMightImage' content='Nucleus.jpg'/>\n" +
		 "<meta name='ExportTime' content='7:45:30'/>\n" +
		 "<meta name='ExportDate' content='08/15/2008'/>\n" +
		 "<meta name='BioMight Version' content='1.0'/>\n" + 
		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='Nucleus'\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		

		
		String body = "";
		if (viewPerspective == Constants.VIEW_HAWKEYE) 
		{
			// Run through the collection of Nucleuss and build them into the model
			// In the default case, we get one instance of the Nucleus for each Cell
			ArrayList transforms = bioMightTransforms.getTransforms();
			System.out.println("In Nucleus - Getting X3D: " + transforms.size());
		
			for (int i=0; i<transforms.size(); i++)
			{
				// Get the information for the sclera we are creating
				BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
				//System.out.println("Creating Nucleus: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());

				if (lod == Constants.MAG1X)
				{	
					//System.out.println("Getting X3D for PupilX: " + bioMightSphere.getTranslation().getXPos());
					//System.out.println("Getting X3D for PupilY: " + bioMightSphere.getTranslation().getYPos());
					//System.out.println("Getting X3D for PupilZ: " + bioMightSphere.getTranslation().getZPos());
					// Change the height and width based on the displacement.

					
					body += "\n<Transform DEF='def"+ bioMightTransform.getId() +"'\n" +
						"translation='" + bioMightTransform.getTranslation().getXPos() + " " 
						+ bioMightTransform.getTranslation().getYPos() + " "
						+ bioMightTransform.getTranslation().getZPos() + "'\n" +
				 	"scale='" 	+ bioMightTransform.getScale().getXPos() + " "
				 				+ bioMightTransform.getScale().getYPos() + " "
				 				+ bioMightTransform.getScale().getZPos() + "'>\n" +
					 	"\n<Shape onmouseover=\"showComponent('Nucleur Envelope');\" DEF='shape"+ bioMightTransform.getId() + "'\n" +
					    " containerField='children'>\n" +
					    " <Appearance\n" +
					    "  containerField='appearance'>\n" +
					    
						" <ImageTexture containerField='texture' " +
						    " url='../images/SpeckledEmerald.png'/>"+
					    
					    " <Material DEF='Rust'\n" +
					    "containerField='material'\n" +
					    "ambientIntensity='" 	+ bioMightTransform.getMaterial().getAmbientIntensity() + "'\n" +
					    "shininess='" 			+ bioMightTransform.getMaterial().getShininess() + "'\n" +
					    "transparency='" 		+ bioMightTransform.getMaterial().getTransparency() + "'\n" +
					    "diffuseColor='" + 
					    bioMightTransform.getMaterial().getDiffuseColor().getRed() + " " + 
					    bioMightTransform.getMaterial().getDiffuseColor().getGreen() + " " +
					    bioMightTransform.getMaterial().getDiffuseColor().getBlue() + "'/>\n" +
					 	"</Appearance>\n" +
					 	"<Sphere DEF='" + bioMightTransform.getId() + "Sphere'\n" +
					 	"containerField='geometry'\n" +
					 	"radius='" + (bioMightTransform.getRadius() + 0.01) + "'/>\n" +
					 	"</Shape>\n" +
					 	
						"\n<TouchSensor DEF='"+bioMightTransform.getId()+"' \n" +
		                   " description='Nucleus'\n" +
			               " containerField='children'/> \n" +
   
				 	"</Transform>\n"; 
					

					
					body += "\n<Transform DEF='def"+ bioMightTransform.getId() +"'\n" +
							"translation='" + bioMightTransform.getTranslation().getXPos() + " " 
							+ bioMightTransform.getTranslation().getYPos() + " "
							+ bioMightTransform.getTranslation().getZPos() + "'\n" +
					 	"scale='" 	+ bioMightTransform.getScale().getXPos() + " "
					 				+ bioMightTransform.getScale().getYPos() + " "
					 				+ bioMightTransform.getScale().getZPos() + "'>\n" +
						 	"\n<Shape onmouseover=\"showComponent('Nucleus');\" DEF='shape"+ bioMightTransform.getId() + "'\n" +
						    " containerField='children'>\n" +
						    " <Appearance\n" +
						    "  containerField='appearance'>\n" +
						    
							" <ImageTexture containerField='texture' " +
							    " url='../images/SpeckledSlateBlue.png'/>"+
						    
						    " <Material DEF='Rust'\n" +
						    "containerField='material'\n" +
						    "ambientIntensity='" 	+ bioMightTransform.getMaterial().getAmbientIntensity() + "'\n" +
						    "shininess='" 			+ bioMightTransform.getMaterial().getShininess() + "'\n" +
						    "transparency='" 		+ bioMightTransform.getMaterial().getTransparency() + "'\n" +
						    "diffuseColor='" + 
						    bioMightTransform.getMaterial().getDiffuseColor().getRed() + " " + 
						    bioMightTransform.getMaterial().getDiffuseColor().getGreen() + " " +
						    bioMightTransform.getMaterial().getDiffuseColor().getBlue() + "'/>\n" +
						 	"</Appearance>\n" +
						 	"<Sphere DEF='" + bioMightTransform.getId() + "Sphere'\n" +
						 	"containerField='geometry'\n" +
						 	"radius='" + (bioMightTransform.getRadius() - 0.02) + "'/>\n" +
						 	"</Shape>\n" +
						 	
							"\n<TouchSensor DEF='"+bioMightTransform.getId()+"' \n" +
			                   " description='Nucleus'\n" +
				               " containerField='children'/> \n" +
	   
					 	"</Transform>\n"; 
					
					body += "\n<Transform DEF='def"+ bioMightTransform.getId() +"'\n" +
							"translation='" + bioMightTransform.getTranslation().getXPos() + " " 
							+ (bioMightTransform.getTranslation().getYPos() + 0.02) + " "
							+ bioMightTransform.getTranslation().getZPos() + "'\n" +
					 	"scale='" 	+ bioMightTransform.getScale().getXPos() + " "
					 				+ bioMightTransform.getScale().getYPos() + " "
					 				+ bioMightTransform.getScale().getZPos() + "'>\n" +
						 	"\n<Shape onmouseover=\"showComponent('Nucleolus');\" DEF='shape"+ bioMightTransform.getId() + "'\n" +
						    " containerField='children'>\n" +
						    " <Appearance\n" +
						    "  containerField='appearance'>\n" +
						    
							" <ImageTexture containerField='texture' " +
							    " url='../images/Nucleus.png'/>"+
						    
						    " <Material DEF='Rust'\n" +
						    "containerField='material'\n" +
						    "ambientIntensity='" 	+ bioMightTransform.getMaterial().getAmbientIntensity() + "'\n" +
						    "shininess='" 			+ bioMightTransform.getMaterial().getShininess() + "'\n" +
						    "transparency='" 		+ bioMightTransform.getMaterial().getTransparency() + "'\n" +
						    "diffuseColor='" + 
						    bioMightTransform.getMaterial().getDiffuseColor().getRed() + " " + 
						    bioMightTransform.getMaterial().getDiffuseColor().getGreen() + " " +
						    bioMightTransform.getMaterial().getDiffuseColor().getBlue() + "'/>\n" +
						 	"</Appearance>\n" +
						 	"<Sphere DEF='" + bioMightTransform.getId() + "Sphere'\n" +
						 	"containerField='geometry'\n" +
						 	"radius='" + (bioMightTransform.getRadius()/5) + "'/>\n" +
						 	"</Shape>\n" +
						 	
							"\n<TouchSensor DEF='"+bioMightTransform.getId()+"' \n" +
			                   " description='Nucleus'\n" +
				               " containerField='children'/> \n" +
	   
					 	"</Transform>\n"; 
				}
				else if (lod == Constants.MAG2X)
				{
					// Build from the constituent components
					System.out.println("Getting NuclearEnvelope X3D for Nucleus:  " + parentID);
					body = ""; //nuclearEnvelope.getX3D(true);
					System.out.println("Have NclearEnvelope X3D for Nucleus:  " + body);
				}
			}
		}		
		else
		{
			body = "";//						
		}
		
		//System.out.println("Nucleus X3D: " + body);	
		String footer = "</Scene>" + "</X3D>\n";
		
		if (snipet)
			return body;			
		else	
			return header + body + footer;
	}

	
	
	
	
	void setMAPK()
	{
	}
}