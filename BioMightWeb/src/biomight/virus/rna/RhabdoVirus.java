/*
* Created on May 15, 2006
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
* Represntation of a RhabdoVirus
* 
*
*/

public class RhabdoVirus extends BioMightBase {
	private String virusName = "RotaVirus";
	private BioMightTransforms bioMightTransforms;
	private ArrayList<BioMightPropertyView> properties;
	private ArrayList<BioMightMethodView> methods;
	private String componentID;
	private String parentID;
	private ArrayList colors;
	private BioMightPosition bioMightPosition;
	
	
	/************************************************************************
	 * RhabdoVirus Constructor 
	 *
	 ***********************************************************************/
	public RhabdoVirus()
	{
		create("0",null);
	}

	/************************************************************************
	 * RhabdoVirus Constructor 
	 *
	 ***********************************************************************/
	public RhabdoVirus(String parentID)
	{
		System.out.print("Calling parameterized RhabdoVirus Constructor!");
		create(parentID, null);
	}
	
	

	public RhabdoVirus(String parentID, BioMightPosition bioMightPosition)
	{
		create(parentID, null);
		this.bioMightPosition = bioMightPosition;
	}
	
	
	/************************************************************************
	 * RhabdoVirus Constructor 
	 *
	 ***********************************************************************/
	public RhabdoVirus(String parentID, ArrayList<BioMightMethodView> bioMightMethods)
	{
		System.out.print("Calling RhabdoVirus with MethodParams!");
		create(parentID, bioMightMethods);
	}
	
	
	/************************************************************************
	 * Create RhabdoVirus
	 *
	 ***********************************************************************/

	public void create(String parentID, ArrayList<BioMightMethodView> bioMightMethods)
	{
		this.setImage("images/RhabdoVirus.jpg");
		this.setImageHeight(300);
		this.setImageWidth(300);
		this.parentID = parentID;
		
		System.out.println("Creating RhabdoVirus for: " + parentID);		
		
		// Get the data for the RhabdoVirus that is defined for this 
		// RhabdoVirus reference
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Getting RhabdoVirusInfo for ParentID: " + parentID);
			InitialContext ctx = new InitialContext();
			BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
			bioMightTransforms = bioMightBean.getComponents(Constants.RhabdoVirusRef, parentID);
			System.out.println("Have RhabdoVirus Info from EJB");   	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - RhabdoVirus");
			throw new ServerException("Remote Exception getComponents():", e); 	
		}

		// If we have initialization parameters from the form, 
		//  then apply them before constructing the objects.
		if (bioMightMethods != null){
			System.out.println("NEED TO EXECUTE RhabdoVirus METHODS: " + bioMightMethods.size());
			//executeMethods(bioMightMethods);
		}

		// Create a properties list for the client to use for interaction
		properties = new ArrayList<BioMightPropertyView>();
		
		// Run through the collection of Bodys and build them into the model
		// In the default case, we get one instance of the Body for each eye
		ArrayList transforms = bioMightTransforms.getTransforms();
		System.out.println("Have RhabdoVirus NumTransforms: " + transforms.size());

		// Run through the body instances and build the bodies.
		// The model should be able to support siamese twins whereas the 
		// bodies are conjoined.
		for (int i=0; i<transforms.size(); i++)
		{
			// Get the information for the eye we are creating
			BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
		
			//componentID = bioMightTransform.getId();
			//System.out.println("Creating Body - Setting ComponentID: " + componentID);
			
			System.out.println("Creating RhabdoVirus: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
			System.out.println("Creating RhabdoVirus at Position: " + bioMightTransform.getTranslation().getXPos() + ",  " + 
					bioMightTransform.getTranslation().getYPos() + ",  " +
					bioMightTransform.getTranslation().getZPos());
					
			//System.out.println("In RhabdoVirus - Creating RhabdoVirus Membrane");
			//capsid = new Capsid(bioMightTransform.getId(), bioMightMethods);
			//System.out.println("In RhabdoVirus - RhabdoVirus Membrane is complete");
			//initProperty("RhabdoVirusMembrane", Constants.RhabdoVirusMembrane, Constants.RhabdoVirusRef, capsomer.getComponentID());

			// Create the components
			//capsomer = new Capsomer();
			//glycoProteinSpikes = new GlycoProteinSpikes();
			//matrixProtein = new MatrixProtein();
			//lipidEnvelope = new LipidEnvelope();
						
		}
		initProperties();
		initMethods();
		System.out.println("Created RhabdoVirus");				
	}
	
	
	protected void initProperty(String componentName, String canonicalName, String componentRef, String componentID) {
		BioMightPropertyView property = new BioMightPropertyView();
		property.setPropertyName(componentName);
		property.setCanonicalName(canonicalName);
		property.setPropertyRef(componentRef);
		property.setPropertyID(componentID);
		properties.add(property);
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
		method.setDisplayName("Penetrate RhabdoVirus");
		method.setMethodName("Penetrate RhabdoVirus");
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
		
		// Assembe the RhabdoVirus
		String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
		"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n " +
		"<X3D profile='Immersive' >\n" +
		"<head>\n" +
		 "<meta name='BioMightImage' content='RhabdoVirus.jpg'/>\n" +
		 "<meta name='ExportTime' content='7:45:30'/>\n" +
		 "<meta name='ExportDate' content='08/15/2008'/>\n" +
		 "<meta name='BioMight Version' content='1.0'/>\n" + 
		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='RhabdoVirus'\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		

		String body = "";
		String annotate = "";
		
		// Run through the collection of RhabdoViruss and build them into the model
		// In the default case, we get one instance of the RhabdoVirus for each eye
		ArrayList transforms = bioMightTransforms.getTransforms();
		for (int i=0; i<transforms.size(); i++)
		{
			// Get the information for the capsomer we are creating
			BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
			System.out.println("Creating RhabdoVirus: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
			System.out.println("Creating RhabdoVirus at Position: " + 
					bioMightTransform.getTranslation().getXPos() + "  " +
					bioMightTransform.getTranslation().getYPos() + "  " +
					bioMightTransform.getTranslation().getZPos());
			
			int view = Constants.VIEW_FLOATING;
			if (view == Constants.VIEW_FLOATING)
			{
				//System.out.println("Getting X3D for RhabdoVirusX: " + bioMightTransform.getTranslation().getXPos());
				//System.out.println("Getting X3D for RhabdoVirusY: " + bioMightTransform.getTranslation().getYPos());
				//System.out.println("Getting X3D for RhabdoVirusZ: " + bioMightTransform.getTranslation().getZPos());
				// Change the height and width based on the displacement.
				body += "<Transform DEF='RhabdoVirus'\n";
				
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
				 	"<Shape DEF='RhabdoVirus'\n" +
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
				 	"<Sphere DEF='RhabdoVirusGeoSphere'\n" +
				 	"containerField='geometry'\n" +
				 	"radius='" + bioMightTransform.getRadius() +"'/>\n" +
				 	"</Shape>\n" +
				 	
				 	"<TouchSensor DEF='StartMuscle' \n" +
	                   " description='Rhabdovirus'\n" +
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
						"<Shape DEF='RhabdoVirus'>\n" +
						"<Appearance\n" +
						"containerField='appearance'>\n" +
						"<Material containerField='material' USE='Red'/>\n" +
						"</Appearance>\n" +
						"<Text DEF='GeoText2'\n" +
						"containerField='geometry'\n" +
						"string='\"RhabdoVirus\"'\n" +
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
		
		System.out.println("RhabdoVirus X3D: " + body);		
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
