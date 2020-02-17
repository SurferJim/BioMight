/*
 * Created on Jun 10, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.virus;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;

import biomight.BioMightBase;
import biomight.Constants;
import biomight.ejb.BioMightBeanLocal;
import biomight.exceptions.ServerException;
import biomight.view.BioMightMethodView;
import biomight.view.BioMightPropertyView;
import biomight.view.BioMightSphere;
import biomight.view.BioMightTransform;

/**
 * @author SurferJim
 *
 * Representation of a base virus.
 * 
 */

public class Virus extends BioMightBase {
	private BioMightSphere bioMightSphere1;
	private ArrayList colors;
	private Capsid capsid; 
	private DNAPolymerase dnaPolymerase;
	private GlycoProteinSpikes glycoProteinSpikes;
	private LipidEnvelope lipidEnvelope;
	private MatrixProtein matrixProtein;
	private NucleoCapsid NucleoCapsid;
	
	/************************************************************************
	 * VIRUS Constructor 
	 *
	 ***********************************************************************/
	public Virus()
	{
		create("0",null);
	}

	/************************************************************************
	 * VIRUS Constructor 
	 *
	 ***********************************************************************/
	public Virus(String parentID)
	{
		System.out.print("Calling parameterized CELL Constructor!");
		create(parentID, null);
	}
	
	
	/************************************************************************
	 * Cell Constructor 
	 *
	 ***********************************************************************/
	public Virus(String parentID, ArrayList<BioMightMethodView> bioMightMethods)
	{
		System.out.print("Calling CELL with MethodParams!");
		create(parentID, bioMightMethods);
	}
	
	
	/************************************************************************
	 * Create Vyrus
	 *
	 ***********************************************************************/

	public void create(String parentID, ArrayList<BioMightMethodView> bioMightMethods)
	{
		this.setImage("images/Virus.jpg");
		this.setImageHeight(300);
		this.setImageWidth(300);

		System.out.println("Creating Virus for: " + parentID);
				
		// Get the data for the Virus that is defined for this 
		// Virus reference
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Getting VirusInfo for ParentID: " + parentID);
			Context ctx = new InitialContext(); 
			BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
			bioMightTransforms = bioMightBean.getComponents(Constants.VirusRef, parentID);
			System.out.println("Have Virus Info from EJB");   	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - Virus");
			throw new ServerException("Remote Exception getComponents():", e); 	
		}

		// If we have initialization parameters from the form, 
		//  then apply them before constructing the objects.
		if (bioMightMethods != null){
			System.out.println("NEED TO EXECUTE CELL METHODS: " + bioMightMethods.size());
			//executeMethods(bioMightMethods);
		}

		
		// Run through the collection of Bodys and build them into the model
		// In the default case, we get one instance of the Body for each eye
		ArrayList transforms = bioMightTransforms.getTransforms();
		System.out.println("Have Virus Transforms : " + transforms.size());

		// Run through the body instances and build the bodies.
		// The model should be able to support siamese twins whereas the 
		// bodies are conjoined.
		for (int i=0; i<transforms.size(); i++)
		{
			// Get the information for the eye we are creating
			BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
		
			//componentID = bioMightTransform.getId();
			//System.out.println("Creating Body - Setting ComponentID: " + componentID);
			
			System.out.println("Creating Virus: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
			System.out.println("Creating Virus at Position: " + bioMightTransform.getTranslation().getXPos() + ",  " + 
					bioMightTransform.getTranslation().getYPos() + ",  " +
					bioMightTransform.getTranslation().getZPos());
					// Create the components
			//capsomer = new Capsomer();
			//glycoProteinSpikes = new GlycoProteinSpikes();
			//matrixProtein = new MatrixProtein();
			//lipidEnvelope = new LipidEnvelope();
						
		}
		
		System.out.println("Init Properties");	
		initProperties();
		System.out.println("Init Methods");
		initMethods();
		System.out.println("Created Virus");				
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
		method.setDisplayName("Penetrate Virus");
		method.setMethodName("Penetrate Virus");
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
	 * This method will return the X3D for the Virus.  It runs through each of its components and collects up their
	 * representations and then assembles them into one unified X3D model.
	 * 
	 ********************************************************************************************************************/
	public String getX3D(boolean snipet) {
		
		// Assemble the Virus
		String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
		"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n " +
		"<X3D profile='Immersive' >\n" +
		"<head>\n" +
		 "<meta name='BioMightImage' content='Virus.jpg'/>\n" +
		 "<meta name='ExportTime' content='7:45:30'/>\n" +
		 "<meta name='ExportDate' content='08/15/2008'/>\n" +
		 "<meta name='BioMight Version' content='1.0'/>\n" + 
		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='Virus'\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		
		
		String body = capsid.getX3D(true);
	
		String footer = "</Scene>" + "</X3D>\n";
		
		if (snipet)
			return body;			
		else	
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

