/*
* Created on Oct 14, 2006
*
* BioMight Component Class - Mar 2007
*
*/
package biomight.virus.rna;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;

import biomight.BioMightBase;
import biomight.Constants;
import biomight.ejb.BioMightBeanLocal;
import biomight.exceptions.ServerException;
import biomight.view.BioMightMethodView;
import biomight.view.BioMightPosition;
import biomight.view.BioMightPropertyView;
import biomight.view.BioMightTransform;

/**
* @author SurferJim
*
* BioMight Component Class - Mar 2007
* Representation of the West Nile Virus
*
*/

public class WestNileVirus extends BioMightBase {
	private String virusName = "WestNileVirus";
	private ArrayList colors;
	private BioMightPosition bioMightPosition;
	
	
	/************************************************************************
	 * WestNileVirus Constructor 
	 *
	 ***********************************************************************/
	public WestNileVirus()
	{
		create("0",null);
	}

	/************************************************************************
	 * WestNileVirus Constructor 
	 *
	 ***********************************************************************/
	public WestNileVirus(String parentID)
	{
		System.out.print("Calling parameterized WestNileVirus Constructor!");
		create(parentID, null);
	}
	
	

	public WestNileVirus(String parentID, BioMightPosition bioMightPosition)
	{
		create(parentID, null);
		this.bioMightPosition = bioMightPosition;
	}
	
	
	/************************************************************************
	 * WestNileVirus Constructor 
	 *
	 ***********************************************************************/
	public WestNileVirus(String parentID, ArrayList<BioMightMethodView> bioMightMethods)
	{
		System.out.print("Calling WestNileVirus with MethodParams!");
		create(parentID, bioMightMethods);
	}
	
	
	/************************************************************************
	 * Create WestNileVirus
	 *
	 ***********************************************************************/

	public void create(String parentID, ArrayList<BioMightMethodView> bioMightMethods)
	{
		this.setImage("images/WestNileVirus.jpg");
		this.setImageHeight(300);
		this.setImageWidth(300);
		this.parentID = parentID;
		
		System.out.println("Creating WestNileVirus for: " + parentID);
		
		// Get the data for the WestNileVirus that is defined for this 
		// WestNileVirus reference
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Getting WestNileVirusInfo for ParentID: " + parentID);
			Context ctx = new InitialContext(); 
			BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
			bioMightTransforms = bioMightBean.getComponents(Constants.WestNileVirusRef, parentID);
			System.out.println("Have WestNileVirus Info from EJB");   	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - WestNileVirus");
			throw new ServerException("Remote Exception getComponents():", e); 	
		}

		// If we have initialization parameters from the form, 
		//  then apply them before constructing the objects.
		if (bioMightMethods != null){
			System.out.println("NEED TO EXECUTE WestNileVirus METHODS: " + bioMightMethods.size());
			//executeMethods(bioMightMethods);
		}

		// Create a properties list for the client to use for interaction
		properties = new ArrayList<BioMightPropertyView>();
		
		// Run through the collection of Bodys and build them into the model
		// In the default case, we get one instance of the Body for each eye
		ArrayList transforms = bioMightTransforms.getTransforms();
		System.out.println("Have WestNileVirus NumTransforms: " + transforms.size());

		// Run through the body instances and build the bodies.
		// The model should be able to support siamese twins whereas the 
		// bodies are conjoined.
		for (int i=0; i<transforms.size(); i++)
		{
			// Get the information for the eye we are creating
			BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
		
			//componentID = bioMightTransform.getId();
			//System.out.println("Creating Body - Setting ComponentID: " + componentID);
			
			System.out.println("Creating WestNileVirus: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
			System.out.println("Creating WestNileVirus at Position: " + bioMightTransform.getTranslation().getXPos() + ",  " + 
					bioMightTransform.getTranslation().getYPos() + ",  " +
					bioMightTransform.getTranslation().getZPos());
					
			//System.out.println("In WestNileVirus - Creating WestNileVirus Membrane");
			//capsid = new Capsid(bioMightTransform.getId(), bioMightMethods);
			//System.out.println("In WestNileVirus - WestNileVirus Membrane is complete");
			//initProperty("WestNileVirusMembrane", Constants.WestNileVirusMembrane, Constants.WestNileVirusRef, capsomer.getComponentID());

			// Create the components
			//capsomer = new Capsomer();
			//glycoProteinSpikes = new GlycoProteinSpikes();
			//matrixProtein = new MatrixProtein();
			//lipidEnvelope = new LipidEnvelope();
						
		}
		initProperties();
		initMethods();
		System.out.println("Created WestNileVirus");				
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
		method.setDisplayName("Penetrate WestNileVirus");
		method.setMethodName("Penetrate WestNileVirus");
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
		
		// Assembe the WestNileVirus
		String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
		"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n " +
		"<X3D profile='Immersive' >\n" +
		"<head>\n" +
		 "<meta name='BioMightImage' content='WestNileVirus.jpg'/>\n" +
		 "<meta name='ExportTime' content='7:45:30'/>\n" +
		 "<meta name='ExportDate' content='08/15/2008'/>\n" +
		 "<meta name='BioMight Version' content='1.0'/>\n" + 
		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='WestNileVirus'\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		

		String body = "";
		String annotate = "";
		
		// Run through the collection of WestNileViruss and build them into the model
		// In the default case, we get one instance of the WestNileVirus for each eye
		ArrayList transforms = bioMightTransforms.getTransforms();
		for (int i=0; i<transforms.size(); i++)
		{
			// Get the information for the capsomer we are creating
			BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
			System.out.println("Creating WestNileVirus: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
			System.out.println("Creating WestNileVirus at Position: " + 
					bioMightTransform.getTranslation().getXPos() + "  " +
					bioMightTransform.getTranslation().getYPos() + "  " +
					bioMightTransform.getTranslation().getZPos());
			
			int view = Constants.VIEW_FLOATING;
			if (view == Constants.VIEW_FLOATING)
			{
				//System.out.println("Getting X3D for WestNileVirusX: " + bioMightTransform.getTranslation().getXPos());
				//System.out.println("Getting X3D for WestNileVirusY: " + bioMightTransform.getTranslation().getYPos());
				//System.out.println("Getting X3D for WestNileVirusZ: " + bioMightTransform.getTranslation().getZPos());
				// Change the height and width based on the displacement.
				body += "<Transform DEF='WestNileVirus'\n";
				
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
				 	"<Shape DEF='WestNileVirus'\n" +
				    " containerField='children'>\n" +
				    " <Appearance\n" +
				    "  containerField='appearance'>\n";
				    
			
				    body+= " <ImageTexture containerField='texture' " +
				    " url='../images/WestNile.jpg'/>";
				
				    
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
				 	"<Sphere DEF='WestNileVirusGeoSphere'\n" +
				 	"containerField='geometry'\n" +
				 	"radius='" + bioMightTransform.getRadius() +"'/>\n" +
				 	"</Shape>\n" +
				 	
				 	"<TouchSensor DEF='StartMuscle' \n" +
	                   " description='WestNile Virus'\n" +
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
						"<Shape DEF='WestNileVirus'>\n" +
						"<Appearance\n" +
						"containerField='appearance'>\n" +
						"<Material containerField='material' USE='Red'/>\n" +
						"</Appearance>\n" +
						"<Text DEF='GeoText2'\n" +
						"containerField='geometry'\n" +
						"string='\"WestNileVirus\"'\n" +
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
		
		System.out.println(" X3D: " + body);		
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
