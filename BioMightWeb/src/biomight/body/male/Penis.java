/*
 * Created on May 9, 2006
 *
 * Representation of a penis
 * 
 */

package biomight.body.male;
import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.naming.InitialContext;



import biomight.Constants;
import  biomight.body.organ.Organ;
import biomight.chemistry.compound.NitricOxide;
import biomight.ejb.BioMightBeanLocal;
import biomight.exceptions.DataSecurityException;
import biomight.exceptions.ServerException;
import biomight.system.tissue.edothelial.EndotheliumTissue;
import biomight.system.tissue.epithelial.EpitheliumTissue;
import biomight.system.vascular.veins.pelvis.DeepDorsalVein;
import biomight.system.vascular.arteries.pelvis.DorsalArtery;
import biomight.view.BioMightMethodView;
import biomight.view.BioMightPosition;
import biomight.view.BioMightPropertyView;
import biomight.view.BioMightTransform;
import biomight.view.BioMightTransforms;
import  biomight.body.organ.kidney.MembranousUrethra;
import  biomight.body.organ.kidney.SpongyUrethra;

/**
 * @author SurferJim
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class Penis extends Organ {
	private String componentID = "";
	private BioMightTransforms bioMightTransforms;
	private ArrayList<BioMightPropertyView> properties;
	private ArrayList<BioMightMethodView> methods;
	//private EpitheliumTissue epithelium;
	private EndotheliumTissue endothelium;
	private CorpusCavernosum corpusCavernosum;
	private CorpusSpongiosum corpusSpongiosum;
	private SpongyUrethra spongyUrethra;
	private MembranousUrethra membranousUrethra;
	private GlansPenis glansPenis;
	private TunicaAlbuginea tunicaAlbuginea;
	private NitricOxide nitricOxide;
	private UrethralBulb urethralBulb;
	private Foreskin foreskin;
	private DeepDorsalVein deepDorsalVein;
	private DorsalArtery dorsalArtery;
		

	public Penis()
	{
		create(Constants.PenisRef, null);
	}

	
	public Penis(String parentID)
	{
		create(parentID, null);
	}
	
	public Penis(String parentID, ArrayList<BioMightMethodView> bioMightMethods)
	{
		create(parentID, bioMightMethods);
	}

	
	public void create(String parentID, ArrayList<BioMightMethodView> bioMightMethods)
	{
		this.setImage("images/Penis.gif");
		setImageWidth(400);
		setImageHeight(375);	

		// Get the information from the database via the Enterprise Bean			
		// Generate a penis based on the preferences selected in the browser
		/*
		System.out.println("Creating the Penis for parent: " + Constants.PenisRef+":0");
		try {
			int insertFlag = bioMight.generatePenis(Constants.PenisRef+":0"); 
			System.out.println("Created Penis");
		}catch (RemoteException e) { 
			System.out.println("Exception Creating Penis");
			throw new ServerException("Remote Exception getComponents():", e); 	
		}catch (DataSecurityException  e) {
			System.out.println("Exception Getting Penis Component");
			throw new ServerException("Remote Exception getComponents():", e); 	
		}
		*/
		
		
		// Get the data for the Penis that is defined for this 
		// body reference.  Read it into the matrix that is mapped 
		// to the imaging device
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Getting PenisInfo for ParentID: " + parentID);
			InitialContext ctx = new InitialContext();
			BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
			bioMightTransforms = bioMightBean.getComponents(Constants.PenisRef, parentID);
			System.out.println("Have Penis Info from EJB");   	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - Penis");
			throw new ServerException("Remote Exception getComponents():", e); 	
		}

		properties = new ArrayList<BioMightPropertyView>();
		
		// Run through the collection of UpperLip and build them into the model
		// In the default case, we get one instance of the Pupil for each eye
		ArrayList transforms = bioMightTransforms.getTransforms();
		System.out.println("Have Penis Info NumTransforms: " + transforms.size());
		for (int i=0; i<transforms.size(); i++)
		{
			// Get the information for the Upper Lip we are creating
			BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
			System.out.println("Creating Penis (name,id): " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
			componentID = bioMightTransform.getId();
			
			endothelium = new EndotheliumTissue("PenisEndothelium", bioMightTransform.getId(), bioMightMethods);
			//initProperty("Penis Epithelium", Constants.Epithelium, Constants.EpitheliumRef, bioMightTransform.getId());
			System.out.println("Penis Endothelium completed");		
		}		

		initProperties();
		initMethods();
	}
	
	
	public void redraw(int parentID)
	{
		System.out.println("Penis Redraw");
		init3D(parentID);
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


		
		BioMightPropertyView property = new BioMightPropertyView();
		property.setPropertyName("Head");
		property.setCanonicalName(Constants.NasalSeptum);
		properties.add(property);
	
		property = new BioMightPropertyView();
		property.setPropertyName("Shaft");
		property.setCanonicalName(Constants.EthmoidalCell);
		properties.add(property);				
	}
	
	
	public void initMethods() {

		methods = new ArrayList<BioMightMethodView>();
		
		BioMightMethodView method = new BioMightMethodView();
		method.setMethodName("Twitch");
		method.setHtmlType("checkbox");
		methods.add(method);
	}
	
	/*********************************************************************************
	 * INIT 3D
	 * 
	 * This method will be executed when we can see cartilage with our regular
	 * perception.  This is not at the cellular level, but as if one were looking
	 * at the ear.
	 *
	 ********************************************************************************/
	public void init3D(int parentID) {
	
	}
	
	
	/********************************************************************************************************************
	 * GET X3D
	 * 
	 * This method will return the X3D for the Cell.  It runs through each of its components and collects up their
	 * representations and then assembles them into one unified X3D model.
	 * 
	 ********************************************************************************************************************/
	public String getX3D(boolean snipet) {
		
		// Assemble the Penis
		String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
		"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n " +
		"<X3D profile='Immersive' >\n" +
		"<head>\n" +
		 "<meta name='BioMightImage' content='Penis.jpg'/>\n" +
		 "<meta name='ExportTime' content='7:45:30'/>\n" +
		 "<meta name='ExportDate' content='08/15/2008'/>\n" +
		 "<meta name='BioMight Version' content='1.0'/>\n" + 
		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='Penis'\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		

		//endothelium.setTissueName("Penis");
		
		BioMightPosition bioMightPosition = new BioMightPosition(0.0, 0.0, 0.0);
		BioMightPosition bioMightScale = new BioMightPosition(1.0, 1.0, 1.0);
		
		String body = "<Transform DEF='LargePenis'\n" +
			"translation='" + bioMightPosition.getXPos() + " " 
 					+ bioMightPosition.getYPos() + " "
 					+ bioMightPosition.getZPos() + "'\n" +
 			"scale='" 	+ bioMightScale.getXPos() + " "
 					+ bioMightScale.getYPos() + " "
 					+ bioMightScale.getZPos() + "'>\n" 
 					+ endothelium.getX3D(true) + 		
		
 			"<TimeSensor DEF='PenisErectTimer'\n" +
 				" containerField='children'\n " +
 				" cycleInterval='1.000'\n " + 
 				" loop='false' \n" +
 				" startTime='-1.000'/> \n" +
 			"<TouchSensor DEF='StartPenisErect' \n" +
 				" containerField='children'/> \n" +
 		"</Transform>\n" +
 		
 		"<PositionInterpolator DEF='PenisErectAnim'\n" + 
 		"key='0 .5 1 1.5'\n" +
 		"keyValue='1 1 1.25  1 1 1.50   1 1 1.75   1 1 2.00'/>\n" + 
 		"<ROUTE fromNode='StartPenisErect' fromField='touchTime' toNode='PenisErectTimer' toField='startTime'/>\n" +
 		"<ROUTE fromNode='PenisErectTimer' fromField='fraction_changed' toNode='PenisErectAnim' toField='set_fraction'/>\n" +
 		"<ROUTE fromNode='PenisErectAnim' fromField='value_changed' toNode='LargePenis' toField='set_scale'/>\n";
		
		//System.out.println("Penis X3D: " + body);		
		String footer = "</Scene>" + "</X3D>\n";
		
		if (snipet)
			return body;			
		else	
			return header + body + footer;
	}
	
	
	
	
	
	
	
	public void setErectness() {
	}

	public void setEjaculate() {
	}
	
}
