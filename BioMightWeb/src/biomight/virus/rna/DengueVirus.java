/*
* Created on Oct 14, 2006
*
* BioMight Component Class - Mar 2007
*
*/
package biomight.virus.rna;
import java.util.ArrayList;

import javax.naming.InitialContext;

import biomight.BioMightBase;
import biomight.Constants;
import biomight.ejb.BioMightBeanLocal;
import biomight.exceptions.ServerException;
import biomight.view.BioMightMethodView;
import biomight.view.BioMightPosition;
import biomight.view.BioMightPropertyView;
import biomight.view.BioMightTransform;
import biomight.view.BioMightTransforms;

/**
* @author SurferJim
*
* BioMight Component Class - Mar 2007
*
*/
public class DengueVirus extends BioMightBase {
	private String virusName = "DengueVirus";
	private BioMightTransforms bioMightTransforms;
	private ArrayList<BioMightPropertyView> properties;
	private ArrayList<BioMightMethodView> methods;
	private String componentID;
	private String parentID;
	private ArrayList colors;
	private BioMightPosition bioMightPosition;
	
	
	/************************************************************************
	 * DengueVirus Constructor 
	 *
	 ***********************************************************************/
	public DengueVirus()
	{
		create("0",null);
	}

	/************************************************************************
	 * DengueVirus Constructor 
	 *
	 ***********************************************************************/
	public DengueVirus(String parentID)
	{
		System.out.print("Calling parameterized DengueVirus Constructor!");
		create(parentID, null);
	}
	
	

	public DengueVirus(String parentID, BioMightPosition bioMightPosition)
	{
		create(parentID, null);
		this.bioMightPosition = bioMightPosition;
	}
	
	
	/************************************************************************
	 * DengueVirus Constructor 
	 *
	 ***********************************************************************/
	public DengueVirus(String parentID, ArrayList<BioMightMethodView> bioMightMethods)
	{
		System.out.print("Calling DengueVirus with MethodParams!");
		create(parentID, bioMightMethods);
	}
	
	
	/************************************************************************
	 * Create DengueVirus
	 *
	 ***********************************************************************/

	public void create(String parentID, ArrayList<BioMightMethodView> bioMightMethods)
	{
		this.setImage("images/DengueVirus.jpg");
		this.setImageHeight(300);
		this.setImageWidth(300);
		this.parentID = parentID;
		
		System.out.println("Creating DengueVirus for: " + parentID);

		// Get the data for the DengueVirus that is defined for this 
		// DengueVirus reference
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Getting DengueVirusInfo for ParentID: " + parentID);
			InitialContext ctx = new InitialContext();
			BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
			bioMightTransforms = bioMightBean.getComponents(Constants.DengueVirusRef, parentID);
			System.out.println("Have DengueVirus Info from EJB");   	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - DengueVirus");
			throw new ServerException("Remote Exception getComponents():", e); 	
		}

		// If we have initialization parameters from the form, 
		//  then apply them before constructing the objects.
		if (bioMightMethods != null){
			System.out.println("NEED TO EXECUTE DengueVirus METHODS: " + bioMightMethods.size());
			//executeMethods(bioMightMethods);
		}

		// Create a properties list for the client to use for interaction
		properties = new ArrayList<BioMightPropertyView>();
		
		// Run through the collection of Bodys and build them into the model
		// In the default case, we get one instance of the Body for each eye
		ArrayList transforms = bioMightTransforms.getTransforms();
		System.out.println("Have DengueVirus NumTransforms: " + transforms.size());

		// Run through the body instances and build the bodies.
		// The model should be able to support siamese twins whereas the 
		// bodies are conjoined.
		for (int i=0; i<transforms.size(); i++)
		{
			// Get the information for the eye we are creating
			BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
		
			//componentID = bioMightTransform.getId();
			//System.out.println("Creating Body - Setting ComponentID: " + componentID);
			
			System.out.println("Creating DengueVirus: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
			System.out.println("Creating DengueVirus at Position: " + bioMightTransform.getTranslation().getXPos() + ",  " + 
					bioMightTransform.getTranslation().getYPos() + ",  " +
					bioMightTransform.getTranslation().getZPos());
					
			//System.out.println("In DengueVirus - Creating DengueVirus Membrane");
			//capsid = new Capsid(bioMightTransform.getId(), bioMightMethods);
			//System.out.println("In DengueVirus - DengueVirus Membrane is complete");
			//initProperty("DengueVirusMembrane", Constants.DengueVirusMembrane, Constants.DengueVirusRef, capsomer.getComponentID());

			// Create the components
			//capsomer = new Capsomer();
			//glycoProteinSpikes = new GlycoProteinSpikes();
			//matrixProtein = new MatrixProtein();
			//lipidEnvelope = new LipidEnvelope();
						
		}
		initProperties();
		initMethods();
		System.out.println("Created DengueVirus");				
	}
	

	public void initProperties() {
		
		BioMightPropertyView property;
		
		// Observable
		property = new BioMightPropertyView();
		property.setPropertyName("Common");
		property.setCanonicalName(Constants.Title);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("Capsomer");
		property.setCanonicalName(Constants.Capsomer);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("DNA Polymerase");
		property.setCanonicalName(Constants.DNAPolymerase);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("GlycoProteinSpikes");
		property.setCanonicalName(Constants.GlycoProteinSpikes);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("LipidEnvelope");
		property.setCanonicalName(Constants.LipidEnvelope);
		properties.add(property);		
		
		property = new BioMightPropertyView();
		property.setPropertyName("MatrixProtein");
		property.setCanonicalName(Constants.MatrixProtein);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("NucleoCapsid");
		property.setCanonicalName(Constants.NucleoCapsid);
		properties.add(property);
	
		
	}
	

	public void initMethods() {

		methods = new ArrayList<BioMightMethodView>();
			
		BioMightMethodView method;
		methods = new ArrayList<BioMightMethodView>();
		method = new BioMightMethodView();
		method.setDisplayName("Transcribe");
		method.setMethodName("Transcribe");
		method.setHtmlType("checkbox");
		method.setDataType("boolean");
		methods.add(method);

		method = new BioMightMethodView();
		method.setDisplayName("Penetrate DengueVirus");
		method.setMethodName("Penetrate DengueVirus");
		method.setHtmlType("checkbox");
		method.setDataType("boolean");
		methods.add(method);	
			
		method = new BioMightMethodView();
		method.setDisplayName("UnCoat");
		method.setMethodName("UnCoat");
		method.setHtmlType("checkbox");
		method.setDataType("boolean");
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
		
		// Assembe the DengueVirus
		String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
		"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n " +
		"<X3D profile='Immersive' >\n" +
		"<head>\n" +
		 "<meta name='BioMightImage' content='DengueVirus.jpg'/>\n" +
		 "<meta name='ExportTime' content='7:45:30'/>\n" +
		 "<meta name='ExportDate' content='08/15/2008'/>\n" +
		 "<meta name='BioMight Version' content='1.0'/>\n" + 
		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='DengueVirus'\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		

		String body = "";
		String annotate = "";
		
		// Run through the collection of DengueViruss and build them into the model
		// In the default case, we get one instance of the DengueVirus for each eye
		ArrayList transforms = bioMightTransforms.getTransforms();
		for (int i=0; i<transforms.size(); i++)
		{
			// Get the information for the capsomer we are creating
			BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
			System.out.println("Creating DengueVirus: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
			System.out.println("Creating DengueVirus at Position: " + 
					bioMightTransform.getTranslation().getXPos() + "  " +
					bioMightTransform.getTranslation().getYPos() + "  " +
					bioMightTransform.getTranslation().getZPos());
			
			int view = Constants.VIEW_FLOATING;
			if (view == Constants.VIEW_FLOATING)
			{
				//System.out.println("Getting X3D for DengueVirusX: " + bioMightTransform.getTranslation().getXPos());
				//System.out.println("Getting X3D for DengueVirusY: " + bioMightTransform.getTranslation().getYPos());
				//System.out.println("Getting X3D for DengueVirusZ: " + bioMightTransform.getTranslation().getZPos());
				// Change the height and width based on the displacement.
				body += "<Transform DEF='DengueVirus'\n";
				
				// Set the position if we are working with the Tissue collection
				if (parentID.equals("1.100000:0"))
				{
					body += "translation='" 
						+ bioMightPosition.getXPos() + " " 
			 			+ bioMightPosition.getYPos() + " "
			 			+ bioMightPosition.getZPos() + "'\n";
				}
				else
				{
			 		body += "translation='" 
			 			+ bioMightTransform.getTranslation().getXPos() + " " 
 						+ bioMightTransform.getTranslation().getYPos() + " "
 						+ bioMightTransform.getTranslation().getZPos() + "'\n";					
				}
				
				
				 body += "scale='" 	+ bioMightTransform.getScale().getXPos() + " "
				 				+ bioMightTransform.getScale().getYPos() + " "
				 				+ bioMightTransform.getScale().getZPos() + "'>\n" +
				 	"<Shape DEF='DengueVirus'\n" +
				    " containerField='children'>\n" +
				    " <Appearance\n" +
				    "  containerField='appearance'>\n";
				    
				// We are looking at the base virus collection
			    if (parentID.equals("1.100000:0"))
			    {
				    body+= " <ImageTexture containerField='texture' " +
				    " url='../images/Blood.jpg'/>";
				}
				    
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
				 	"<Sphere DEF='DengueVirusGeoSphere'\n" +
				 	"containerField='geometry'\n" +
				 	"radius='" + bioMightTransform.getRadius() +"'/>\n" +
				 	"</Shape>\n" +
				 	
				 	"<TouchSensor DEF='StartMuscle' \n" +
	                   " description='Dengue'\n" +
		               " containerField='children'/> \n" +

		               
				 "</Transform>\n";
				
				
				//	Add the text to the Tissue sample
				if (parentID.equals("1.100000:0"))
				{
					annotate = 
					"<Transform DEF='VirusText' \n" +
					"translation='" + (bioMightPosition.getXPos() + 1.25) + " "  
					+ (bioMightPosition.getYPos()+0.25) + " "
					+ bioMightPosition.getZPos() + "'>\n" +
						"<Shape DEF='DengueVirus'>\n" +
						"<Appearance\n" +
						"containerField='appearance'>\n" +
						"<Material containerField='material' USE='Red'/>\n" +
						"</Appearance>\n" +
						"<Text DEF='GeoText2'\n" +
						"containerField='geometry'\n" +
						"string='\"DengueVirus\"'\n" +
						"maxExtent='0.000'>\n" +
						"<FontStyle\n" +
						"containerField='fontStyle'\n" +
						"family='SERIF'\n" +
						"style='PLAIN'\n" +
						"justify='\"BEGIN\" \"BEGIN\"'\n" +
						"size='0.500'\n" +
						"spacing='0.50'/>\n" +
						"</Text>\n" +
						"</Shape>\n" +
					"</Transform>\n";
				}
						
			}
			else
			{
				body = "";//						
			}
		
	}
		
		System.out.println("DengueVirus X3D: " + body);		
		String footer = "</Scene>" + "</X3D>\n";
		
		if (snipet)
			return body + annotate;			
		else	
			return header + body + annotate + footer;				
	}

	
	public void unCoat()
	{
	}

	public void penetrate()
	{
	}
	
	public void transcribe()
	{
	}
		
	public void assemble()
	{
		// 
	}


	public String getComponentID() {
		return componentID;
	}

	public void setComponentID(String componentID) {
		this.componentID = componentID;
	}

	public ArrayList<BioMightMethodView> getMethods() {
		return methods;
	}

	public void setMethods(ArrayList<BioMightMethodView> methods) {
		this.methods = methods;
	}

	public String getParentID() {
		return parentID;
	}

	public void setParentID(String parentID) {
		this.parentID = parentID;
	}

	public ArrayList<BioMightPropertyView> getProperties() {
		return properties;
	}

	public void setProperties(ArrayList<BioMightPropertyView> properties) {
		this.properties = properties;
	}	
	
}
