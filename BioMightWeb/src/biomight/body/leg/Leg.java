/*
 * Created on May 10, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.body.leg;
import java.util.ArrayList;

import biomight.BioMightBase;
import biomight.Constants;
import biomight.body.BodyPart;
import biomight.body.Ankle;
import biomight.body.foot.*;
import biomight.body.leg.cnemis.*;
import biomight.body.leg.thigh.*;
import biomight.system.vascular.arteries.*;
import biomight.system.vascular.arteries.leg.*;
import biomight.system.vascular.veins.*;
import biomight.system.vascular.veins.leg.*;
import biomight.system.muscular.forearm.PronatorQuadratusMuscle;
import biomight.system.muscular.leg.thigh.*;
import biomight.system.skeletal.leg.*;
import biomight.system.skeletal.leg.tibia.Tibia;
import biomight.system.tissue.epithelial.EpitheliumTissue;
import biomight.system.tissue.muscle.MuscleTissue;
import biomight.view.BioMightMethodView;
import biomight.view.BioMightPropertyView;

/**
 * @author SurferJim
 *
 * Representation of a Leg.  When one constructs the leg, and there are muscles, bones,
 * or arteries that are considered part of both, we only create one instance of them
 * and the subclasses also share them.
 * 
 */

public class Leg extends BioMightBase {
	private ArrayList<BioMightPropertyView> properties;
	private ArrayList<BioMightMethodView> methods;
	//private Thighs thighs;
	//private Cnemes cnemes;	

	
	
	public Leg()
	{		
		// Create hte base Eye
		create(Constants.LegRef, null);
	}
	
	
	public Leg(String parentID)
	{				
		create(parentID, null);	
	}
	

	public Leg(String parentID, ArrayList<BioMightMethodView> bioMightMethods)
	{				
		create(parentID, bioMightMethods);	
	}

	
	/************************************************************************************
	 * 
	 * CREATE LEG
	 * @param HipReference
	 ***********************************************************************************/
	
	public void create(String parentID, ArrayList<BioMightMethodView> bioMightMethods)
	{		
		this.setImage("images/Leg.gif");
		setImageWidth(200);
		setImageHeight(150);
		
		viewPerspective = Constants.VIEW_FLOATING;
		if (viewPerspective == Constants.VIEW_FLOATING) {
			
			// If we have initialization parameters from the form, 
			//  then apply them before constructing the objects.
			if (bioMightMethods != null){
				System.out.println("NEED TO EXECUTE Leg METHODS: " + bioMightMethods.size());
			}

			
			//cnemis = new Cnemis();
		
			System.out.println("Leg Instance is completed : " + parentID);
		} 
		else if (viewPerspective == Constants.VIEW_INTERNAL) {
	
		}

		initProperties();
		initMethods();
	
	}
	
	
	
	public void initProperties() {

		properties = new ArrayList<BioMightPropertyView>();

		BioMightPropertyView property = new BioMightPropertyView();
		property.setPropertyName("Thigh");
		property.setCanonicalName(Constants.Thigh);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("Knee");
		property.setCanonicalName(Constants.Knee);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("Cnemus");
		property.setCanonicalName(Constants.Cnemis);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("Bones");
		property.setCanonicalName(Constants.Title);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("Fibula");
		property.setCanonicalName(Constants.Fibula);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("Patella");
		//property.setCanonicalName(Constants.Patella);
		properties.add(property);
		

		property = new BioMightPropertyView();
		property.setPropertyName("Muscles");
		property.setCanonicalName(Constants.Title);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("AdductorLongusMuscle");
		property.setCanonicalName(Constants.AdductorLongusMuscle);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("BicepsFemorisMuscle");
		property.setCanonicalName(Constants.BicepsFemorisMuscle);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("GluteusMediusMuscle");
		property.setCanonicalName(Constants.GluteusMediusMuscle);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("GracilisMuscle");
		property.setCanonicalName(Constants.GracilisMuscle);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("IlliacusMuscle");
		property.setCanonicalName(Constants.IliacusMuscle);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("ObturatorExternusMuscle");
		property.setCanonicalName(Constants.ObturatorExternusMuscle);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("ObturatorInternusMuscle");
		property.setCanonicalName(Constants.ObturatorInternusMuscle);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("PectineusMuscle");
		property.setCanonicalName(Constants.PectineusMuscle);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("PopliteusMuscle");
		property.setCanonicalName(Constants.PopliteusMuscle);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("QuadricepsFemorisMuscle");
		property.setCanonicalName(Constants.QuadricepsFemorisMuscle);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("RectusFemorisMuscle");
		property.setCanonicalName(Constants.RectusFemorisMuscle);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("SartoriusMuscle");
		property.setCanonicalName(Constants.SartoriusMuscle);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("SemiMembranosusMuscle");
		property.setCanonicalName(Constants.SemiMembranosusMuscle);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("SemitendinosusMuscle");
		property.setCanonicalName(Constants.SemitendinosusMuscle);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("TensorFasciaLataMuscle");
		property.setCanonicalName(Constants.TensorFasciaLataMuscle);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("VastusInterMediusMuscle");
		property.setCanonicalName(Constants.VastusInterMediusMuscle);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("VastusLateralisMuscle");
		property.setCanonicalName(Constants.VastusLateralisMuscle);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("VastusMedialisMuscle");
		property.setCanonicalName(Constants.VastusMedialisMuscle);
		properties.add(property);

		// ARTERIES
		property = new BioMightPropertyView();
		property.setPropertyName("Arteries");
		property.setCanonicalName(Constants.Title);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("CommonFemoralArtery");
		property.setCanonicalName(Constants.CommonFemoralArtery);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("DeepFemoralArtery");
		property.setCanonicalName(Constants.DeepFemoralArtery);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("SuperficialFemoralArtery");
		property.setCanonicalName(Constants.SuperficialFemoralArtery);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("PoplitealArtery");
		property.setCanonicalName(Constants.PoplitealArtery);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("AnteriorTibialArtery");
		property.setCanonicalName(Constants.AnteriorTibialArtery);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("PosteriorTibialArtery");
		property.setCanonicalName(Constants.PosteriorTibialArtery);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("PeronealArtery");
		property.setCanonicalName(Constants.PeronealArtery);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("ArcuateArtery");
		property.setCanonicalName(Constants.ArcuateArtery);
		properties.add(property);
		
		// VEINS
		property = new BioMightPropertyView();
		property.setPropertyName("Veins");
		property.setCanonicalName(Constants.Title);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("GreatSaphenousVein");
		property.setCanonicalName(Constants.GreatSaphenousVein);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("SmallSaphenousVein");
		property.setCanonicalName(Constants.SmallSaphenousVein);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("FemoralVein");
		property.setCanonicalName(Constants.FemoralVein);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("PoplitealVein");
		property.setCanonicalName(Constants.PoplitealVein);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("AnteriorTibialVein");
		property.setCanonicalName(Constants.AnteriorTibialVein);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("PosteriorTibialVein");
		property.setCanonicalName(Constants.PosteriorTibialVein);
		properties.add(property);				
		
		property = new BioMightPropertyView();
		property.setPropertyName("PeronealVein");
		property.setCanonicalName(Constants.PeronealVein);
		properties.add(property);
				
		/**
		private  poplitealVein;
		private  anteriorTibialVein;
		private  posteriorTibialVein;
		private  peronealVein;
		**/
		
	}
	
	
	public void initMethods() {

		methods = new ArrayList<BioMightMethodView>();
		
		BioMightMethodView method = new BioMightMethodView();
		
		method = new BioMightMethodView();
		method.setMethodName("Kick");
		method.setHtmlType("checkbox");
		methods.add(method);

		method = new BioMightMethodView();
		method.setMethodName("Quiver");
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
		
		// Assemble the Leg
		String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
		"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n " +
		"<X3D profile='Immersive' >\n" +
		"<head>\n" +
		 "<meta name='BioMightImage' content='Leg.jpg'/>\n" +
		 "<meta name='ExportTime' content='7:45:30'/>\n" +
		 "<meta name='ExportDate' content='08/15/2008'/>\n" +
		 "<meta name='BioMight Version' content='1.0'/>\n" + 
		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='Leg'\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		
		
		
		String body = ""; 
			//thighs.getX3D(true) +
			//cnemises.getX3D(true);
	
		//System.out.println("Leg X3D: " + body);			
		String footer = "</Scene>" + "</X3D>\n";
		
		if (snipet)
			return body;			
		else	
			return header + body + footer;
	}
	
	

	

	
	
}
