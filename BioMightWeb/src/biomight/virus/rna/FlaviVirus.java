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
import biomight.virus.DNAPolymerase;
import biomight.virus.GlycoProteinSpikes;
import biomight.virus.IcosahedralNucleoCapsid;
import biomight.virus.LipidEnvelope;
import biomight.virus.MatrixProtein;
import biomight.virus.NucleoCapsid;

/**
* @author SurferJim
*
* Representation of a Flavivirus
*
*/
public class FlaviVirus extends BioMightBase {

private String virusName = "FlaviVirus";
private BioMightTransforms bioMightTransforms;
private ArrayList<BioMightPropertyView> properties;
private ArrayList<BioMightMethodView> methods;
private String componentID;
private String parentID;
private ArrayList colors;
private BioMightPosition bioMightPosition;

// This is view provides a targeted viewpoint of the object
int view = Constants.VIEW_HAWKEYE;

private IcosahedralNucleoCapsid icosahedralNucleoCapsid;
private DNAPolymerase dnaPolymerase;
private GlycoProteinSpikes glycoProteinSpikes;
private LipidEnvelope lipidEnvelope;
private MatrixProtein matrixProtein;
private NucleoCapsid NucleoCapsid;


/************************************************************************
 * Flavivirus Constructor 
 *
 ***********************************************************************/
public FlaviVirus()
{
	create("0",null);
}

/************************************************************************
 * Flavivirus Constructor 
 *
 ***********************************************************************/
public FlaviVirus(String parentID)
{
	System.out.print("Calling parameterized FlaviVirus Constructor!");
	create(parentID, null);
}



public FlaviVirus(String parentID, BioMightPosition bioMightPosition)
{
	create(parentID, null);
	this.bioMightPosition = bioMightPosition;
}


/************************************************************************
 * Flavivirus Constructor 
 *
 ***********************************************************************/
public FlaviVirus(String parentID, BioMightPosition bioMightPosition, int view)
{
	System.out.print("Calling FlaviVirus with View: " + view);
	create(parentID, null);

	// Set to the default vide
	this.view = view;
}

/************************************************************************
 * Flavivirus Constructor 
 *
 ***********************************************************************/
public FlaviVirus(String parentID, ArrayList<BioMightMethodView> bioMightMethods)
{
	System.out.print("Calling FlaviVirus with MethodParams!");
	create(parentID, bioMightMethods);
}


/************************************************************************
 * Create Flavivirus
 *
 ***********************************************************************/

public void create(String parentID, ArrayList<BioMightMethodView> bioMightMethods)
{
	this.setImage("images/FlaviVirus.jpg");
	this.setImageHeight(300);
	this.setImageWidth(300);
	this.parentID = parentID;
	
	System.out.println("Creating Flavivirus for: " + parentID);

	// Get the data for the EnteroVirus that is defined for this 
	// EnteroVirus reference
	try {
		// Get the information from the database via the Enterprise Bean		
		System.out.println("Getting FlaviVirusInfo for ParentID: " + parentID);
		InitialContext ctx = new InitialContext();
		BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
		bioMightTransforms = bioMightBean.getComponents(Constants.FlaviVirusRef, parentID);
		System.out.println("Have FlaviVirus Info from EJB");   	
	}catch (Exception e) { 
		System.out.println("Exception Getting Components - FlaviVirus");
		throw new ServerException("Remote Exception getComponents():", e); 	
	}

	// If we have initialization parameters from the form, 
	//  then apply them before constructing the objects.
	if (bioMightMethods != null){
		System.out.println("NEED TO EXECUTE FlaviVirus METHODS: " + bioMightMethods.size());
		//executeMethods(bioMightMethods);
	}
	
	// Run through the collection of Bodys and build them into the model
	// In the default case, we get one instance of the Body for each eye
	ArrayList transforms = bioMightTransforms.getTransforms();
	System.out.println("Have Flavivirus NumTransforms: " + transforms.size());

	// Run through the database trasforms in to get the Default view of the component.
	// If we are looking at a composite view, grab the Visual data from each of the
	// components.  
	for (int i=0; i<transforms.size(); i++)
	{
		// Get the information for the eye we are creating
		BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
	
		componentID = bioMightTransform.getId();
		System.out.println("Creating Flavivirus - Set ComponentID: " + componentID);
		
		System.out.println("Creating Flavivirus: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
		System.out.println("Creating Flavivirus at Position: " + bioMightTransform.getTranslation().getXPos() + ",  " + 
				bioMightTransform.getTranslation().getYPos() + ",  " +
				bioMightTransform.getTranslation().getZPos());
		
		if (view == Constants.VIEW_BIRDSEYE)
		{
			// we are going to use the data collected at the component level
		}
		else if (view == Constants.VIEW_HAWKEYE)
		{
			//System.out.println("In Flavivirus - Creating Flavivirus Membrane");
			//capsid = new Capsid(bioMightTransform.getId(), bioMightMethods);
			//System.out.println("In Flavivirus - Flavivirus Membrane is complete");
			//initProperty("FlavivirusMembrane", Constants.FlavivirusMembrane, Constants.FlavivirusRef, capsomer.getComponentID());
		}
		
		// Create the components
		//capsomer = new Capsomer();
		//glycoProteinSpikes = new GlycoProteinSpikes();
		//matrixProtein = new MatrixProtein();
		//lipidEnvelope = new LipidEnvelope();
					
	}
	//initProperties();
	initMethods();
	System.out.println("Created FlaviVirus");				
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
		
	BioMightMethodView method;
	methods = new ArrayList<BioMightMethodView>();
	method = new BioMightMethodView();
	method.setDisplayName("Transcribe");
	method.setMethodName("Transcribe");
	method.setHtmlType("checkbox");
	method.setDataType("boolean");
	methods.add(method);

	method = new BioMightMethodView();
	method.setDisplayName("Penetrate Flavivirus");
	method.setMethodName("Penetrate Flavivirus");
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
 * Get the X3D model based upon the view that we are currently looking at.
 * 
 * 
 ********************************************************************************************************************/
public String getX3D(boolean snipet) {

	// If we are doing a detailed view, build the view from the subcomponents
	String X3D = "";
	if (view == Constants.VIEW_HAWKEYE)
	{			
		X3D = getBaseX3D(snipet);
	}
	else if (view == Constants.VIEW_BIRDSEYE)
	{
		X3D = getComponentsX3D();
	}
	return (X3D);
}

/********************************************************************************************************************
 * GET X3D
 * 
 * This method will return the X3D for the Cell.  It runs through each of its components and collects up their
 * representations and then assembles them into one unified X3D model.
 * 
 ********************************************************************************************************************/
public String getBaseX3D(boolean snipet) {
	
	// Assembe the Erythrocyte
	String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
	"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n " +
	"<X3D profile='Immersive' >\n" +
	"<head>\n" +
	 "<meta name='BioMightImage' content='Flavivirus.jpg'/>\n" +
	 "<meta name='ExportTime' content='7:45:30'/>\n" +
	 "<meta name='ExportDate' content='08/15/2008'/>\n" +
	 "<meta name='BioMight Version' content='1.0'/>\n" + 
	"</head>\n" +
	"<Scene>\n" +
	"<WorldInfo\n" +
	"title='Flavivirus'\n" +
	"info='\"BioMight Generated X3D\"'/>\n";		

	String body = "";
	String annotate = "";
	
	// Run through the collection of Flaviviruss and build them into the model
	// In the default case, we get one instance of the Flavivirus for each eye
	ArrayList transforms = bioMightTransforms.getTransforms();
	for (int i=0; i<transforms.size(); i++)
	{
		// Get the information for the capsomer we are creating
		BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
		System.out.println("Creating Flavivirus: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
		System.out.println("Creating Flavivirus at Position: " + 
				bioMightTransform.getTranslation().getXPos() + "  " +
				bioMightTransform.getTranslation().getYPos() + "  " +
				bioMightTransform.getTranslation().getZPos());
		
		int view = Constants.VIEW_FLOATING;
		if (view == Constants.VIEW_FLOATING)
		{
			//System.out.println("Getting X3D for FlavivirusX: " + bioMightTransform.getTranslation().getXPos());
			//System.out.println("Getting X3D for FlavivirusY: " + bioMightTransform.getTranslation().getYPos());
			//System.out.println("Getting X3D for FlavivirusZ: " + bioMightTransform.getTranslation().getZPos());
			// Change the height and width based on the displacement.
			body += "<Transform DEF='Flavivirus'\n";
			
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
			 	"<Shape DEF='Flavivirus'\n" +
			    " containerField='children'>\n" +
			    " <Appearance\n" +
			    "  containerField='appearance'>\n";
			    
			// We are looking at the base tissue collection
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
			 	"<Sphere DEF='FlavivirusGeoSphere'\n" +
			 	"containerField='geometry'\n" +
			 	"radius='" + bioMightTransform.getRadius() +"'/>\n" +
			 	"</Shape>\n" +
			 	
			 	"<TouchSensor DEF='StartMuscle' \n" +
                " description='Flavivirus'\n" +
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
					"<Shape DEF='Flavivirus'>\n" +
					"<Appearance\n" +
					"containerField='appearance'>\n" +
					"<Material containerField='material' USE='Red'/>\n" +
					"</Appearance>\n" +
					"<Text DEF='GeoText2'\n" +
					"containerField='geometry'\n" +
					"string='\"Flavivirus\"'\n" +
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
	
	System.out.println("Flavivirus X3D: " + body);		
	String footer = "</Scene>" + "</X3D>\n";
	
	if (snipet)
		return body + annotate;			
	else	
		return header + body + annotate + footer;				
}



/********************************************************************************************************************
 * GET X3D
 * 
 * This method will return the X3D for the Flavivirus.  It runs through each of its components and collects up their
 * representations and then assembles them into one unified X3D model.
 * 
 ********************************************************************************************************************/
public String getComponentsX3D() {
	
	// Assemble the AdenoFlavivirus
	String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
	"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n " +
	"<X3D profile='Immersive' >\n" +
	"<head>\n" +
	 "<meta name='BioMightImage' content='AdenoFlavivirus.jpg'/>\n" +
	 "<meta name='ExportTime' content='7:45:30'/>\n" +
	 "<meta name='ExportDate' content='08/15/2008'/>\n" +
	 "<meta name='BioMight Version' content='1.0'/>\n" + 
	"</head>\n" +
	"<Scene>\n" +
	"<WorldInfo\n" +
	"title='AdenoFlavivirus'\n" +
	"info='\"BioMight Generated X3D\"'/>\n";		
	
	String body = "";//capsid.getX3D(true);

	String footer = "</Scene>" + "</X3D>\n";
	
	return header + body + footer;
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

public DNAPolymerase getDnaPolymerase() {
	return dnaPolymerase;
}

public void setDnaPolymerase(DNAPolymerase dnaPolymerase) {
	this.dnaPolymerase = dnaPolymerase;
}

public GlycoProteinSpikes getGlycoProteinSpikes() {
	return glycoProteinSpikes;
}

public void setGlycoProteinSpikes(GlycoProteinSpikes glycoProteinSpikes) {
	this.glycoProteinSpikes = glycoProteinSpikes;
}

public LipidEnvelope getLipidEnvelope() {
	return lipidEnvelope;
}

public void setLipidEnvelope(LipidEnvelope lipidEnvelope) {
	this.lipidEnvelope = lipidEnvelope;
}

public MatrixProtein getMatrixProtein() {
	return matrixProtein;
}

public void setMatrixProtein(MatrixProtein matrixProtein) {
	this.matrixProtein = matrixProtein;
}

public NucleoCapsid getNucleoCapsid() {
	return NucleoCapsid;
}

public void setNucleoCapsid(NucleoCapsid nucleoCapsid) {
	NucleoCapsid = nucleoCapsid;
}

}
