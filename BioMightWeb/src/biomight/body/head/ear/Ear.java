/*
5 * Created on May 8, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.body.head.ear;
import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.naming.InitialContext;

import biomight.BioMightBase;
import biomight.Constants;
import biomight.body.organ.skin.Skin;
import biomight.ejb.BioMightBeanLocal;
import biomight.exceptions.DataSecurityException;
import biomight.exceptions.ServerException;
import biomight.system.cartilage.Cartilage;
import biomight.system.nervous.nerves.head.ear.AuditoryNerve;
import biomight.system.nervous.nerves.head.ear.CochlearNerve;
import biomight.system.nervous.nerves.head.ear.VestibularNerve;
import biomight.system.tissue.edothelial.EndotheliumTissue;
import biomight.view.BioMightMethodView;
import biomight.view.BioMightPosition;
import biomight.view.BioMightPropertyView;
import biomight.view.BioMightTransform;
import biomight.view.BioMightTransforms;

/**
 * @author SurferJim8u
 *
 * Create a Representation of the Human Ear.
 * 
 *
 */

public class Ear extends BioMightBase {	
	// Exterior Ear
	protected Auricle auricle;	
	
	// Interior Ear
	protected Cochlea cochlea;
	protected ExternalCanal externalCanal;
	protected Malleus malleus;
	protected Incus incus;
	protected SemiCircularCanals semiCircularCanals;
	protected Stapes stapes;
	protected TympanicMembrane earDrum;
	protected Saccule saccule;
	protected VestibularNerve vestibularNerve;	
	protected AuditoryNerve auditoryNerve;
	protected CochlearNerve CochlearNerve;
	
	
	/********************************************************************************************************************
	 *  EAR
	 * 
	 * This method will instantiate the Ears that are defined for the current model.  
	 * 
	 ********************************************************************************************************************/

	
	public Ear()
	{
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, Constants.EarsRef, null, null);
	}
	

	/********************************************************************************************************************
	 *  EAR
	 * 
	 * This method will instantiate the Eyes that are defined for the current model.  
	 * 
	 ********************************************************************************************************************/

	
	public Ear(String parentID)
	{		
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, parentID, null, null);
	}
	

	public Ear(int hierarchy, int LOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
	{
		create(hierarchy, LOD, parentID, bioMightProperties, bioMightMethods);
	}

	/*****************************************************************
	 * CREATE
	 * 
	 * @param parentID
	 * @param bioMightMethods
	 ******************************************************************/
	public void create(int hierarchy, int LOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
	{
		this.setImage("images/Ears.jpg");
		this.setImageWidth(300);
		this.setImageHeight(325);
	
			
			properties = new ArrayList<BioMightPropertyView>();
			
			System.out.println("Creating Auricle for Ear using parent: " + parentID);
			
			
			auricle = new Auricle(parentID, bioMightMethods);
			initProperty("Auricle", Constants.Auricle, Constants.AuricleRef, auricle.getComponentID());
			System.out.println("Ear - Auricle is created");
			
			System.out.println("Cochlea: " + parentID);
			
			cochlea = new Cochlea(parentID, bioMightMethods);	
			initProperty("Cochlea", Constants.Cochlea, Constants.CochleaRef, cochlea.getComponentID());
			System.out.println("Cochlea is created");
			
			externalCanal  = new ExternalCanal(parentID, bioMightMethods);
			initProperty("ExternalCanal", Constants.ExternalCanal, Constants.ExternalCanalRef, externalCanal.getComponentID());
			System.out.println("External Canal is created");
			
			incus = new Incus(parentID, bioMightMethods);
			initProperty("Incus", Constants.Incus, Constants.IncusRef, incus.getComponentID());
			System.out.println("Ear - Incus is created");
			
			malleus  = new Malleus(parentID, bioMightMethods);
			initProperty("Malleus", Constants.Malleus, Constants.MalleusRef, malleus.getComponentID());
			System.out.println("Malleus is created");
			
			semiCircularCanals  = new SemiCircularCanals(parentID, bioMightMethods);
			initProperty("SemiCircularCanals", Constants.Malleus, Constants.MalleusRef, malleus.getComponentID());
			System.out.println("SemiCircular Canal is created");
			
			stapes  = new Stapes(parentID, bioMightMethods);
			initProperty("Malleus", Constants.Malleus, Constants.MalleusRef, malleus.getComponentID());
			System.out.println("Stapes is created");
			
			earDrum  = new TympanicMembrane(parentID, bioMightMethods);
			initProperty("EarDrum", Constants.TympanicMembrane, Constants.TympanicMembraneRef, earDrum.getComponentID());
			System.out.println("Ear Drum is created");
			
			saccule  = new Saccule(parentID, bioMightMethods);
			initProperty("Saccule", Constants.Saccule, Constants.SacculeRef, saccule.getComponentID());
			System.out.println("Saccule is created");
			
			/*int viewPerspective = Constants.VIEW_DETACHED;
			if (viewPerspective == Constants.VIEW_DETACHED)
			{				
				// Create the components of the curvature

			}*/
		
			//initProperties();
			initMethods();
		
		System.out.println("Create Ear Completed");
		
		// First, get all the data from the database
		// Apply the methods to it
		// Save its state
		this.parentID = parentID;
		if (bioMightMethods != null){
			System.out.println("EXECUTING Ear METHODS: " + bioMightMethods.size());
			//executeMethods(bioMightMethods);
		}
	}
	
	

	
	public void create2(String parentID, ArrayList<BioMightMethodView> bioMightMethods)
	{
		this.setImage("images/Ear.jpg");
		this.setImageHeight(300);
		this.setImageWidth(300);
	
		
		// Get the information from the database via the Enterprise Bean		
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Getting EarInfo for ParentID: " + parentID);
			InitialContext ctx = new InitialContext();
			BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
			bioMightTransforms = bioMightBean.getComponents(Constants.EarRef, parentID);
			System.out.println("Have Ear Info from EJB");   	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - Ear");
			throw new ServerException("Remote Exception getComponents():", e); 	
		}

		
		// 
		ArrayList transforms = bioMightTransforms.getTransforms();
		System.out.println("Ear NumTransforms: " + transforms.size());
		for (int i=0; i<transforms.size(); i++)
		{
			// Get the information for the eye we are creating
			BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
			System.out.println("Created Ear: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
			this.componentID = bioMightTransform.getId();
			
			System.out.println("Creating Auricle for Ear");
			auricle = new Auricle(bioMightTransform.getId(), bioMightMethods);
			initProperty("Auricle", Constants.Auricle, Constants.AuricleRef, auricle.getComponentID());
			System.out.println("Ear - Auricle is created");
			
			cochlea  = new Cochlea(bioMightTransform.getId(), bioMightMethods);	
			initProperty("Cochlea", Constants.Cochlea, Constants.CochleaRef, cochlea.getComponentID());
			System.out.println("Cochlea is created");
			
			//externalCanal  = new ExternalCanal(bioMightTransform.getId(), bioMightMethods);
			//System.out.println("External Canal is created");
			
			//malleus  = new Malleus(bioMightTransform.getId(), bioMightMethods);
			//System.out.println("Malleus is created");
			
			//semiCircularCanals  = new SemiCircularCanals();
			//System.out.println("SemiCircular Canal is created");
			
			//stapes  = new Stapes(bioMightTransform.getId(), bioMightMethods);
			//System.out.println("Stapes is created");
			
			//earDrum  = new TympanicMembrane(bioMightTransform.getId(), bioMightMethods);
			//System.out.println("Ear Drum is created");
			
			//saccule  = new Saccule(bioMightTransform.getId(), bioMightMethods);
			//System.out.println("Saccule is created");
			
			/*int viewPerspective = Constants.VIEW_DETACHED;
			if (viewPerspective == Constants.VIEW_DETACHED)
			{				
				// Create the components of the curvature

			}*/
		}
		initProperties();
		initMethods();
		
		System.out.println("Create Ear Completed");
		
		// First, get all the data from the database
		// Apply the methods to it
		// Save its state
		this.parentID = parentID;
		if (bioMightMethods != null){
			System.out.println("EXECUTING Ear METHODS: " + bioMightMethods.size());
			//executeMethods(bioMightMethods);
		}
	}

	
	public void initProperties() {

		BioMightPropertyView property = new BioMightPropertyView();
		
		property.setPropertyName("Outer Ear");
		property.setCanonicalName(Constants.Title);
		properties.add(property);
		

		property.setPropertyName("Inner Ear");
		property.setCanonicalName(Constants.Title);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("VestibularNerve");
		property.setCanonicalName(Constants.VestibularNerve);
		properties.add(property);
	
		property = new BioMightPropertyView();
		property.setPropertyName("Cochlea");
		property.setCanonicalName(Constants.Cochlea);
		properties.add(property);		
	
		property = new BioMightPropertyView();
		property.setPropertyName("ExternalCanal");
		property.setCanonicalName(Constants.ExternalCanal);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("Malleus");
		property.setCanonicalName(Constants.Malleus);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("SemiCircularCanals");
		property.setCanonicalName(Constants.SemiCircularCanals);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("Stapes");
		property.setCanonicalName(Constants.Stapes);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("TympanicMembrane");
		property.setCanonicalName(Constants.TympanicMembrane);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("Saccule");
		property.setCanonicalName(Constants.Saccule);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("Utricle");
		property.setCanonicalName(Constants.Utricle);
		properties.add(property);
		

	}
	
	
	public void initMethods() {

		
		BioMightMethodView method;

		method = new BioMightMethodView();
		method.setMethodName("Deaf");
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
	 * This method will return the X3D for the Ear.  It runs through each of its components and collects up their
	 * representations and then assembles them into one unified X3D model.
	 * 
	 *******************************************************************************************************************/
	public String getX3D(boolean snipet) {
		
		// Assembe the Ear
		String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
		"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n " +
		"<X3D profile='Immersive' >\n" +
		"<head>\n" +
		 "<meta name='BioMightImage' content='Ear.jpg'/>\n" +
		 "<meta name='ExportTime' content='7:45:30'/>\n" +
		 "<meta name='ExportDate' content='08/15/2008'/>\n" +
		 "<meta name='BioMight Version' content='1.0'/>\n" + 
		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='Ear'\n" +
		"info='\"BioMight Generated X3D\"'/>\n";			
		
		viewPerspective = Constants.VIEW_FLOATING;
		// Construct the ear based on the View Perspective. We only want to 
		// activate those components that comprise the view
		String body = "";
		if (viewPerspective == Constants.VIEW_FLOATING) {
			System.out.println("Getting X3D for Auricle");
			body = auricle.getX3D(true);
		} else if (viewPerspective == Constants.VIEW_INTERNAL) {
			body = 
			vestibularNerve.getX3D(true) +
			cochlea.getX3D(true) +
			externalCanal.getX3D(true) +
			malleus.getX3D(true) +
			semiCircularCanals.getX3D(true) +
			stapes.getX3D(true) +
			earDrum.getX3D(true) +
			saccule.getX3D(true);
		} else if (viewPerspective == Constants.VIEW_DETACHED) {
			body = 
			auricle.getX3D(true) +
			vestibularNerve.getX3D(true) +
			cochlea.getX3D(true) +
			externalCanal.getX3D(true) +
			malleus.getX3D(true) +
			semiCircularCanals.getX3D(true) +
			stapes.getX3D(true) +
			earDrum.getX3D(true) +
			saccule.getX3D(true);
		}
		
		//System.out.println("Ear X3D: " + body);		
		
		String footer = "</Scene>" + "</X3D>\n";
		
		if (snipet)
			return body;			
		else	
			return header + body + footer;
	}
	
	

	public Cochlea getCochlea() {
		return cochlea;
	}


	public void setCochlea(Cochlea cochlea) {
		this.cochlea = cochlea;
	}


	public TympanicMembrane getEarDrum() {
		return earDrum;
	}


	public void setEarDrum(TympanicMembrane earDrum) {
		this.earDrum = earDrum;
	}


	public ExternalCanal getExternalCanal() {
		return externalCanal;
	}


	public void setExternalCanal(ExternalCanal externalCanal) {
		this.externalCanal = externalCanal;
	}


	public Malleus getMalleus() {
		return malleus;
	}


	public void setMalleus(Malleus malleus) {
		this.malleus = malleus;
	}


	public Saccule getSaccule() {
		return saccule;
	}


	public void setSaccule(Saccule saccule) {
		this.saccule = saccule;
	}


	public SemiCircularCanals getSemiCircularCanals() {
		return semiCircularCanals;
	}


	public void setSemiCircularCanals(SemiCircularCanals semiCircularCanals) {
		this.semiCircularCanals = semiCircularCanals;
	}


	public Stapes getStapes() {
		return stapes;
	}


	public void setStapes(Stapes stapes) {
		this.stapes = stapes;
	}


	public VestibularNerve getVestibularNerve() {
		return vestibularNerve;
	}


	public void setVestibularNerve(VestibularNerve vestibularNerve) {
		this.vestibularNerve = vestibularNerve;
	}


	public void setViewPerspective(int viewPerspective) {
		this.viewPerspective = viewPerspective;
	}

}

