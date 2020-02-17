/*
 * Created on Sep 19, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.system.muscular.back;
import java.util.ArrayList;

import biomight.BioMightBase;
import biomight.Constants;
import biomight.system.tissue.epithelial.EpitheliumTissue;
import biomight.system.tissue.muscle.MuscleTissue;
import biomight.view.BioMightMethodView;
import biomight.view.BioMightPropertyView;


/**
 * @author SurferJim
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class RotatoresSpinaeMuscle extends BioMightBase {
	private ArrayList<BioMightPropertyView> properties;
	private ArrayList<BioMightMethodView> methods;
	protected EpitheliumTissue epithelium;
	protected MuscleTissue muscleTissue;
	
	
	public RotatoresSpinaeMuscle()
	{		
		// Create hte base Eye
		create(Constants.RotatoresSpinaeMuscleRef, null);
	}
	
	
	public RotatoresSpinaeMuscle(String parentID)
	{				
		create(parentID, null);	
	}
	

	public RotatoresSpinaeMuscle(String parentID, ArrayList<BioMightMethodView> bioMightMethods)
	{				
		create(parentID, bioMightMethods);	
	}

	
	/************************************************************************************
	 * 
	 * CREATE ARM
	 * @param RotatoresSpinaeMuscleReference
	 ***********************************************************************************/
	
	public void create(String parentID, ArrayList<BioMightMethodView> bioMightMethods)
	{		
		this.setImage("images/RotatoresSpinaeMuscle.gif");
		setImageWidth(200);
		setImageHeight(150);
		
		viewPerspective = Constants.VIEW_FLOATING;
		if (viewPerspective == Constants.VIEW_FLOATING) {
			
			// If we have initialization parameters from the form, 
			//  then apply them before constructing the objects.
			if (bioMightMethods != null){
				System.out.println("NEED TO EXECUTE RotatoresSpinaeMuscle METHODS: " + bioMightMethods.size());
			}
			
			// Muscle Endothelium
			//System.out.println("Creating RotatoresSpinaeMuscle Epithelium: " + parentID);				
			//epithelium = new EpitheliumTissue("RotatoresSpinaeMuscleEpithelium", parentID, bioMightMethods);
			//System.out.println("RotatoresSpinaeMuscle Epithelium is created : " + parentID);	
		
			// Tissue
			System.out.println("Creating RotatoresSpinaeMuscle MuscleTissue: " + parentID);				
			muscleTissue = new MuscleTissue("RotatoresSpinaeMuscleTissue", parentID, bioMightMethods);
			System.out.println("RotatoresSpinaeMuscle MuscleTissue is created : " + parentID);		
		} 
		else if (viewPerspective == Constants.VIEW_INTERNAL) {
	
		}

		initProperties();
		initMethods();
	
	}
	

	public void initProperties() {

		properties = new ArrayList<BioMightPropertyView>();
		
		BioMightPropertyView property = new BioMightPropertyView();
		property.setPropertyName("Bones");
		property.setCanonicalName(Constants.Title);
		properties.add(property);
		
		// BONES
		property = new BioMightPropertyView();
		property.setPropertyName("Humerus");
		property.setCanonicalName(Constants.Humerus);
		properties.add(property);		
		
		property = new BioMightPropertyView();
		property.setPropertyName("Ulna");
		property.setCanonicalName(Constants.Ulna);
		properties.add(property);	

		property = new BioMightPropertyView();
		property.setPropertyName("Radius");
		property.setCanonicalName(Constants.Radius);
		properties.add(property);	
		
		// MUSCLES		
		property = new BioMightPropertyView();
		property.setPropertyName("Extensor Carpi Radialis Brevis Muscle");
		property.setCanonicalName(Constants.ExtensorCarpiRadialisBrevisMuscle);
		properties.add(property);			
	
		property = new BioMightPropertyView();
		property.setPropertyName("BrachioCephalic Artery");
		property.setCanonicalName(Constants.BrachioCephalicArtery);
		properties.add(property);		

		property = new BioMightPropertyView();
		property.setPropertyName("Cephalic Vein");
		property.setCanonicalName(Constants.CephalicVein);
		properties.add(property);		
	}
	
	
	public void initMethods() {
  
		methods = new ArrayList<BioMightMethodView>();

		BioMightMethodView method = new BioMightMethodView();
		method = new BioMightMethodView();
		method.setMethodName("Flex");
		method.setHtmlType("text");
		method.setDataType("int");
		methods.add(method);

		method = new BioMightMethodView();
		method.setMethodName("Punch");
		method.setHtmlType("text");
		method.setDataType("int");
		methods.add(method);

		method = new BioMightMethodView();
		method.setMethodName("Block");
		method.setHtmlType("text");
		method.setDataType("int");
		methods.add(method);

		method = new BioMightMethodView();
		method.setMethodName("Swing");
		method.setHtmlType("text");
		method.setDataType("int");
		methods.add(method);	
	}
		
	
	/********************************************************************************************************************
	 * GET X3D
	 * 
	 * This method will return the X3D for the RotatoresSpinaeMuscle.  It runs through each of its components and collects up their
	 * representations and then assembles them into one unified X3D model.
	 * 
	 ********************************************************************************************************************/
	public String getX3D(boolean snipet) {
		
		// Assemble the RotatoresSpinaeMuscle
		String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
		"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n " +
		"<X3D profile='Immersive' >\n" +
		"<head>\n" +
		 "<meta name='BioMightImage' content='RotatoresSpinaeMuscle.jpg'/>\n" +
		 "<meta name='ExportTime' content='7:45:30'/>\n" +
		 "<meta name='ExportDate' content='08/15/2008'/>\n" +
		 "<meta name='BioMight Version' content='1.0'/>\n" + 
		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='RotatoresSpinaeMuscle'\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		

		String body = muscleTissue.getX3D(true);
		
		
			/*
			brachialArtery.getX3D(true) +
			 +
			 +
			annularLigament.getX3D(true) + 
			brachialArtery.getX3D(true) +
			brachioCephalicArtery.getX3D(true) +
			brachialVein.getX3D(true) +
			basilicVein.getX3D(true); */
	
		//System.out.println("RotatoresSpinaeMuscle X3D: " + body);		
	
		String footer = "</Scene>" + "</X3D>\n";
		
		if (snipet)
			return body;			
		else	
			return header + body + footer;
	}
	
	
	
	
}
