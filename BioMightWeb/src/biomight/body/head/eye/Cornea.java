/*
 * Created on May 19, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.body.head.eye;

import java.util.ArrayList;

import biomight.BioMightBase;
import biomight.Constants;
import biomight.cell.epithelial.AmacrineCell;
import biomight.cell.neuron.BiPolarCell;
import biomight.cell.neuron.HorizontalCell;
import biomight.cell.neuronglial.GanglionicCell;
import biomight.system.ligament.SuspensoryLigament;
import biomight.system.muscular.head.eye.LateralRectusMuscle;
import biomight.view.BioMightMethodView;
import biomight.view.BioMightPropertyView;
import biomight.view.BioMightTransform;

/**
 * @author SurferJim
 * 
 * The cornea is the transparent front part of the eye that covers the iris, pupil, 
 * and anterior chamber, providing most of an eye's optical power.[1] 
 * The human cornea has five layers
 * 
 */
public class Cornea extends BioMightBase {
	private ArrayList<BioMightPropertyView> properties;
	private ArrayList<BioMightMethodView> methods;
	private BioMightTransform bioMightTransform;
	private String componentID;
	protected int viewPerspective;
	
	private CornealEpithelium cornealEpithelium;
	private BowmansLayer bowmansLayer;
	private SubstantiaPropria  substantiaPropria; 
	private DescemetsMembrane descemetsMembrane;
	private CornealEndothelium cornealEndothelium;
	


	
	public Cornea()
	{		
		// Create hte base Eye
		create(Constants.CorneaRef, null);
	}
	
	
	public Cornea(String parentID)
	{				
		create(parentID, null);	
	}
	

	public Cornea(String parentID, ArrayList<BioMightMethodView> bioMightMethods)
	{				
		create(parentID, bioMightMethods);	
	}


	/************************************************************************************
	 * 
	 * CREATE EYE
	 * @param eyeReference
	 ***********************************************************************************/
	
	public void create(String parentID, ArrayList<BioMightMethodView> bioMightMethods)
	{		
		this.setImage("images/LeftEye.jpg");
		
		viewPerspective = Constants.VIEW_FLOATING;
		if (viewPerspective == Constants.VIEW_FLOATING) {
			
			// If we have initialization parameters from the form, 
			//  then apply them before constructing the objects.
			if (bioMightMethods != null){
				System.out.println("NEED TO EXECUTE EYE METHODS: " + bioMightMethods.size());
			}
			
			bowmansLayer  = new BowmansLayer(parentID, bioMightMethods);
			//initProperty("Chest", Constants.Chest, Constants.ChestRef, chest.getComponentID());
			System.out.println("Cornea - BowmansLayer is created");	

			substantiaPropria  = new SubstantiaPropria(parentID, bioMightMethods);
			//initProperty("Chest", Constants.Chest, Constants.ChestRef, chest.getComponentID());
			System.out.println("Cornea - SubstantiaPropria is created");	

			descemetsMembrane  = new DescemetsMembrane(parentID, bioMightMethods);
			//initProperty("Chest", Constants.Chest, Constants.ChestRef, chest.getComponentID());
			System.out.println("Cornea - DescemetsMembrane is created");	

			//cornealEndothelium  = new CornealEndothelium(parentID, bioMightMethods);
			//initProperty("Chest", Constants.Chest, Constants.ChestRef, chest.getComponentID());
			System.out.println("Cornea - CornealEndothelium is created");	
		

			
		} 
		else if (viewPerspective == Constants.VIEW_INTERNAL) {

		}

		initProperties();
		initMethods();
	
	}
	
	
	
	
	public void initProperties() {

		properties = new ArrayList<BioMightPropertyView>();
		
		BioMightPropertyView property = new BioMightPropertyView();
		property.setPropertyName("CornealEpithelium");
		property.setCanonicalName(Constants.CornealEpithelium);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("BowmansLayer");
		property.setCanonicalName(Constants.BowmansLayer);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("SubstantiaPropria");
		property.setCanonicalName(Constants.SubstantiaPropria);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("DescemetsMembrane");
		property.setCanonicalName(Constants.DescemetsMembrane);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("CornealEndothelium");
		property.setCanonicalName(Constants.CornealEndothelium);
		properties.add(property);
	}
	
	
	public void initMethods() {

		methods = new ArrayList<BioMightMethodView>();
		
		BioMightMethodView method = new BioMightMethodView();

		method = new BioMightMethodView();
		method.setMethodName("Deafness");
		method.setHtmlType("checkbox");
		methods.add(method);	
		
		method = new BioMightMethodView();
		method.setMethodName("Hear");
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
		
		// Assembe the Head
		String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
		"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n " +
		"<X3D profile='Immersive' >\n" +
		"<head>\n" +
		 "<meta name='BioMightImage' content='Cornea.jpg'/>\n" +
		 "<meta name='ExportTime' content='7:45:30'/>\n" +
		 "<meta name='ExportDate' content='08/15/2008'/>\n" +
		 "<meta name='BioMight Version' content='1.0'/>\n" + 
		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='Cornea'\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		

		String body = "";//
		/*cornealEpithelium.getX3D(true) +
		bowmansLayer.getX3D(true) +
		substantiaPropria.getX3D(true) + 
		descemetsMembrane.getX3D(true) +
		cornealEndothelium.getX3D(true);*/
		System.out.println("Cornea X3D: " + body);		
		
		String footer = "</Scene>" + "</X3D>\n";
		
		if (snipet)
			return body;			
		else	
			return header + body + footer;
	}	
	

}
