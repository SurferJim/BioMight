/*
 * Created on Jul 8, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.system;

import java.util.ArrayList;

import javax.naming.InitialContext;

import biomight.BioMightBase;
import biomight.Constants;
import biomight.body.Esophagus;
import biomight.body.gland.gallbladder.GallBladder;
import biomight.body.head.mouth.Mouth;
import biomight.body.organ.largeintestine.LargeIntestine;
import biomight.body.organ.CommonBileDuct;
import biomight.body.organ.CommonHepaticDuct;
import biomight.body.organ.CysticDuct;
import biomight.body.organ.HepaticDucts;
import biomight.body.organ.liver.Liver;
import biomight.body.organ.pancreas.Pancreas;
import biomight.body.organ.smallintestine.SmallIntestine;
import biomight.body.organ.stomach.Stomach;
import biomight.body.substructs.cardia.Cardia;
import biomight.body.substructs.pharynx.Pharynx;
import biomight.ejb.BioMightBeanLocal;
import biomight.ejb.BioMightVascularBeanLocal;
import biomight.exceptions.ServerException;
import biomight.view.BioMightGenerate;
import biomight.view.BioMightMethodView;
import biomight.view.BioMightPosition;
import biomight.view.BioMightPropertyView;
import biomight.view.BioMightScale;
import biomight.view.BioMightTransform;
import biomightweb.util.BioWebUtils;


/**************************************************************************
 * @author SurferJim
 *
 * Representation of the Digestive System
 * 
 **************************************************************************/

public class DigestiveSystem extends BioMightBase {
	private Cardia cardia;
	private Esophagus esophagus;
	private Liver liver;
	private Mouth mouth;
	private Pharynx pharynx;
	private Pancreas pancreas;
	private SmallIntestine  smallIntestine;
	private Stomach stomach;
	private LargeIntestine largeIntestine;
	private GallBladder gallBladder;
	private CysticDuct cysticDuct;
	private CommonBileDuct commonBileDuct;
	private HepaticDucts hepaticDucts;
	private CommonHepaticDuct commonHepaticDuct;
	
	
	/************************************************************************
	 * DIGESTIVE SYSTEM Constructor 
	 *
	 ***********************************************************************/

	public DigestiveSystem()
	{
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, Constants.DigestiveSystem, null, null);
	}

	public DigestiveSystem(String parentID)
	{
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, parentID, null, null);
	}

	
	public DigestiveSystem(int hierarchy, int LOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
	{
		create(hierarchy, LOD, parentID, bioMightProperties, bioMightMethods);
	}
	
	
	/**********************************************************************************
	 * CREATE
	 * 
	 * @param parentID
	 * @param bioMightMethods
	 *********************************************************************************/
	
	public void create(int hierarchy, int LOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
	{
		this.setImage("images/DigestiveSystem.jpg");
		this.setImageHeight(300);
		this.setImageWidth(300);
		
		
		// Get the information from the database via the Enterprise Bean		
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Getting DigestiveSystemInfo for ParentID: " + parentID);
			InitialContext ctx = new InitialContext();
			BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
			bioMightTransforms = bioMightBean.getComponents(Constants.DigestiveSystemRef, parentID);
			//System.out.println("Have DigestiveSystem Info from EJB");   	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - DigestiveSystem");
			throw new ServerException("Remote Exception getComponents():", e); 	
		}
		
		int localVP = Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		boolean bStored = false;
		
		BioMightScale bioScale = new BioMightScale("0.00, 0.00, 0.00");
		BioMightPosition  bioPos = new BioMightPosition("0.00, 0.00, 0.00");
		String bioTemplate="DigestiveSystem.x3d";

		// Run through the collection of DigestiveSystems and build them into the model
		// In the default case, we get one instance of the DigestiveSystem for each eye
		ArrayList transforms = bioMightTransforms.getTransforms();
		System.out.println("DigestiveSystem NumTransforms: " + transforms.size());
		for (int i=0; i<transforms.size(); i++)
		{
			// Get the information for the DigestiveSystem we are creating
			BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
			//System.out.println("Created DigestiveSystem: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
			componentID = bioMightTransform.getId();
			System.out.println("Creating DigestiveSystem: " + bioMightTransform.getName() + "  " + bioMightTransform.getId() + "  " + componentID);
					
	
			// Get the Properties that the user set in the page last time we were in	
			// We will use the enable flag to see what should be turned on/off
			if (bioMightProperties == null ||bioMightProperties.size() == 0)
			{
				try {
					// Get the information from the database via the Enterprise Bean		
					//System.out.println("Getting Property info for DigestiveSystem: " + bioMightTransform.getId());
					InitialContext ctx = new InitialContext();
					BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
					// overwrite the structure that was passed in, as they are empty
					bioMightProperties = bioMightBean.getComponentProps(bioMightTransform.getId());
					System.out.println("Have DigestiveSystem Property Info from EJB - NumProps: " + bioMightProperties.size());   	
				}catch (Exception e) { 
					System.out.println("Exception Getting Components Properties - DigestiveSystem");
					throw new ServerException("Remote Exception getComponents():", e); 	
				} 

				//System.out.println("DigestiveSystem: Using Properties from Datastore");
				bStored = true;
			}
			else
			{
				//System.out.println("DigestiveSystem - Using LocalProperties...");
			}
			System.out.println("DigestiveSystem Properties Size: " + bioMightProperties.size());
			dumpProperties();
			
			if (BioWebUtils.isViewEnabled(Constants.MouthRef, bioMightProperties)) {	
				//System.out.println("Creating Mouth using ParentID: " + bioMightTransform.getId());
				mouth = new Mouth(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
				initProperty(Constants.MouthRef, Constants.Mouth, Constants.MouthRef, mouth.getComponentID(), bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, true);					
				System.out.println("Mouth is created");
			}
			else
				initProperty(Constants.MouthRef, Constants.Mouth, Constants.MouthRef, BioWebUtils.getPropertyID(Constants.MouthRef, bioMightProperties), bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);					
	
			if (BioWebUtils.isViewEnabled(Constants.EsophagusRef, bioMightProperties)) {
				//System.out.println("Creating the Esophagus for ParentID: " + bioMightTransform.getId());			
				esophagus = new Esophagus(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
				BioMightGenerate generatedEsophagus = esophagus.getBioMightGenerate(); 
				initProperty(Constants.EsophagusRef, Constants.Esophagus, Constants.EsophagusRef, esophagus.getComponentID(), bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, true);								
				System.out.println("Created the Esophagus");
			}
			else
				initProperty(Constants.EsophagusRef, Constants.Esophagus, Constants.EsophagusRef, BioWebUtils.getPropertyID(Constants.EsophagusRef, bioMightProperties), bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);								
	
			if (BioWebUtils.isViewEnabled(Constants.StomachRef, bioMightProperties)) {
				//System.out.println("Creating Stomach: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
				stomach = new Stomach(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
				BioMightGenerate generatedStomach = stomach.getBioMightGenerate();
				initProperty(Constants.StomachRef, Constants.Stomach, Constants.StomachRef, stomach.getComponentID(), bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, true);								
				System.out.println("Created the Stomach");
			}
			else
				initProperty(Constants.StomachRef, Constants.Stomach, Constants.StomachRef, BioWebUtils.getPropertyID(Constants.StomachRef, bioMightProperties), bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);								

			if (BioWebUtils.isViewEnabled(Constants.LiverRef, bioMightProperties)) {
				//System.out.println("Creating Liver: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
				liver = new Liver(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
				BioMightGenerate generatedLiver = liver.getBioMightGenerate(); 								
				initProperty(Constants.LiverRef, Constants.Liver, Constants.LiverRef, liver.getComponentID(), bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, true);								
				System.out.println("Created the Liver");
			}
			else
				initProperty(Constants.LiverRef, Constants.Liver, Constants.LiverRef, BioWebUtils.getPropertyID(Constants.LiverRef, bioMightProperties), bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);								

			if (BioWebUtils.isViewEnabled(Constants.GallBladderRef, bioMightProperties)) {
				//System.out.println("Creating the GallBladder for parent: " + bioMightTransform.getId());
				gallBladder = new GallBladder(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
				initProperty(Constants.GallBladderRef, Constants.GallBladder, Constants.GallBladderRef, gallBladder.getComponentID(), bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, true);								
				System.out.println("Created the GallBladder");	
			}
			else
				initProperty(Constants.GallBladderRef, Constants.GallBladder, Constants.GallBladderRef, BioWebUtils.getPropertyID(Constants.GallBladderRef, bioMightProperties), bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);								
				
			//System.out.println("Creating the BileDuct for parent: " + bioMightTransform.getId());
			//bileDucts = new BileDucts(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
			//initProperty(Constants.BileDuctsRef, Constants.BileDucts, Constants.BileDuctsRef, bileDucts.getComponentID(), bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, BioWebUtils.isViewEnabled(Constants.BileDuctsRef, bioMightProperties));							
			//System.out.println("Created the BileDucts");	

			if (BioWebUtils.isViewEnabled(Constants.CysticDuctRef, bioMightProperties)) {
				//System.out.println("Creating the CysticDuct for parent: " + bioMightTransform.getId());
				cysticDuct = new CysticDuct(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
				initProperty(Constants.CysticDuctRef, Constants.CysticDuct, Constants.CysticDuctRef, cysticDuct.getComponentID(), bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, true);							
				System.out.println("Created the CysticDuct");	
			}
			else
				initProperty(Constants.CysticDuctRef, Constants.CysticDuct, Constants.CysticDuctRef, BioWebUtils.getPropertyID(Constants.CysticDuctRef, bioMightProperties), bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);							

			if (BioWebUtils.isViewEnabled(Constants.CommonBileDuctRef, bioMightProperties)) {
				//System.out.println("Creating the CommonBileDuct for parent: " + bioMightTransform.getId());
				commonBileDuct = new CommonBileDuct(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
				initProperty(Constants.CommonBileDuctRef, Constants.CommonBileDuct, Constants.CommonBileDuctRef, commonBileDuct.getComponentID(), bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, true);							
				System.out.println("Created the CommonBileDuct");	
			}
			else
				initProperty(Constants.CommonBileDuctRef, Constants.CommonBileDuct, Constants.CommonBileDuctRef, BioWebUtils.getPropertyID(Constants.CommonBileDuctRef, bioMightProperties), bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);							

			if (BioWebUtils.isViewEnabled(Constants.CommonHepaticDuctRef, bioMightProperties)) {
				//System.out.println("Creating the CommonHepaticDuct for parent: " + bioMightTransform.getId());
				commonHepaticDuct = new CommonHepaticDuct(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
				initProperty(Constants.CommonHepaticDuctRef, Constants.CommonHepaticDuct, Constants.CommonHepaticDuctRef, commonHepaticDuct.getComponentID(), bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, true);							
				System.out.println("Created the CommonHepaticDuct");	
			}
			else
				initProperty(Constants.CommonHepaticDuctRef, Constants.CommonHepaticDuct, Constants.CommonHepaticDuctRef, BioWebUtils.getPropertyID(Constants.CommonHepaticDuctRef, bioMightProperties), bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);							
				
			if (BioWebUtils.isViewEnabled(Constants.HepaticDuctsRef, bioMightProperties)) {		
				//System.out.println("Creating the HepaticDucts for parent: " + bioMightTransform.getId());
				hepaticDucts = new HepaticDucts(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
				initProperty(Constants.HepaticDuctsRef, Constants.HepaticDucts, Constants.HepaticDuctsRef, hepaticDucts.getComponentID(), bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, true);							
				System.out.println("Created the HepaticDucts");	
			}
			else
				initProperty(Constants.HepaticDuctsRef, Constants.HepaticDucts, Constants.HepaticDuctsRef, BioWebUtils.getPropertyID(Constants.HepaticDuctsRef, bioMightProperties), bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);							
			
			if (BioWebUtils.isViewEnabled(Constants.PancreasRef, bioMightProperties)) {
				//System.out.println("Creating Pancreas: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
				pancreas = new Pancreas(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);								
				initProperty(Constants.PancreasRef, Constants.Pancreas, Constants.PancreasRef, pancreas.getComponentID(), bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, true);								
				System.out.println("Created the Pancreas");	
			}
			else
				initProperty(Constants.PancreasRef, Constants.Pancreas, Constants.PancreasRef, BioWebUtils.getPropertyID(Constants.PancreasRef, bioMightProperties), bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);								
	
			if (BioWebUtils.isViewEnabled(Constants.SmallIntestineRef, bioMightProperties)) {
				//System.out.println("Creating SmallIntestine: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
				smallIntestine = new SmallIntestine(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);							
				initProperty(Constants.SmallIntestineRef, Constants.SmallIntestine, Constants.SmallIntestineRef, smallIntestine.getComponentID(), bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, true);								
				System.out.println("Created the SmallIntestine");	
			}
			else
				initProperty(Constants.SmallIntestineRef, Constants.SmallIntestine, Constants.SmallIntestineRef, BioWebUtils.getPropertyID(Constants.SmallIntestineRef, bioMightProperties), bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);								

			if (BioWebUtils.isViewEnabled(Constants.LargeIntestineRef, bioMightProperties)) {
				//System.out.println("Creating LargeIntestine: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
				largeIntestine = new LargeIntestine(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);	
				initProperty(Constants.LargeIntestineRef, Constants.LargeIntestine, Constants.LargeIntestineRef, largeIntestine.getComponentID(), bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, true);								
				System.out.println("Created the LargeIntestine");	
			}
			else
				initProperty(Constants.LargeIntestineRef, Constants.LargeIntestine, Constants.LargeIntestineRef, BioWebUtils.getPropertyID(Constants.LargeIntestineRef, bioMightProperties), bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);								
				
				
			// Store the new set of properties based on the init Property methods called above	
			// This means the user set properties
			if (properties != null && !bStored) {
				if (properties.size()>0) {
				// Store the Properties that the user set in the page	
				// We will use the enable flag to see what should be turned on/off
					try {
						// Get the information from the database via the Enterprise Bean		
						//System.out.println("Setting Property info for DigestiveSystem: " + bioMightTransform.getId());
						InitialContext ctx = new InitialContext();
						BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
						int propSave = bioMightBean.insertComponentProps(bioMightTransform.getId(),
								Constants.DigestiveSystemRef, bioMightTransform.getComponentName(), properties);      
						System.out.println("Stored DigestiveSystem Property Info into EJB: " + propSave);   	
					}catch (Exception e) { 
						System.out.println("Exception Storing Components Properties - DigestiveSystem");
						throw new ServerException("Remote Exception insertComponentProps():", e); 	
					} 
				}
			}
			dumpProperties();
		}
		//initProperties();
		initMethods();
		
		System.out.println("CreateDigestiveSystem Completed");
		
		// First, get all the data from the database
		// Apply the methods to it
		// Save its state
		this.parentID = parentID;
	}
	
	
	/*******************************************************************
	 * GENERATE the DigestiveSystem
	 * 
	 * @param parentID
	 * @param componentID
	 ****************************************************************/
	
	public void generate(String parentID, String componentID)
	{
		// Generate the DescendingDigestiveSystemEndothelium		
		BioMightVascularBeanLocal bioMightBean;
		try {
			// Get the information from the database via the Enterprise Bean		
			//System.out.println("Generating the DigestiveSystemEndothelium: " + componentID + "    " + parentID);
			InitialContext ctx = new InitialContext();
			bioMightBean = (BioMightVascularBeanLocal) ctx.lookup("java:global/BioMightWeb/BioMightVacularBean!biomight.ejb.BioMightVascularBeanLocal");
	
			double circumference = 0.25;
		
			if (parentID.equals("Chest:01")) 
			{	
				// Generate the DescendingDigestiveSystemEndothelium of the stomach
				// Create 5 sections
				double[] startPos = {-0.3,-8.0, -6.0};
			
				//System.out.println("Calling Generate DigestiveSystemEndothelium: " + componentID + "    " + parentID);
				
				//int success = bioMightBean.generateDigestiveSystem("DigestiveSystemEndothelium:00001", "DigestiveSystemEndothelium", 
				//	"DigestiveSystemEndothelium", componentID, parentID, currentPoints);			
	
				//success = bioMightBean.generateBlood("DigestiveSystemEndothelium:00001", "DigestiveSystemEndothelium", 
				//		"DigestiveSystemEndothelium", componentID, parentID, currentPoints);			
				
			}			
			else if (parentID.equals("Abdomen:01")) 
			{	
				// Generate the DescendingDigestiveSystemEndothelium of the stomach
				// Create 5 sections
				double[] startPos = {-0.3,-14.0, -6.0};
	
				System.out.println("Calling Generate DigestiveSystemEndothelium: " + componentID + "    " + parentID);
				
				//int success = bioMightBean.generateDigestiveSystem("DigestiveSystemEndothelium:00080", "DigestiveSystemEndothelium", 
				//	"DigestiveSystemEndothelium", componentID, parentID, currentPoints);			
					
			}
			else if (parentID.equals("")) 
			{	
				System.out.println("Calling Generate DigestiveSystemEndothelium NoParent");
							
			}
			
			System.out.println("Created DigestiveSystemEndothelium Info using EJB");   	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - DigestiveSystemEndothelium");
			throw new ServerException("Remote Exception getComponents():", e); 	
		}
	}
	
	
	
	public ArrayList initProperties() {

		BioMightPropertyView property = new BioMightPropertyView();
		property.setPropertyName("Mouth");
		property.setCanonicalName(Constants.Mouth);
		properties.add(property);
	
		property = new BioMightPropertyView();
		property.setPropertyName("Esophagus");
		property.setCanonicalName(Constants.Esophagus);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("Stomach");
		property.setCanonicalName(Constants.Stomach);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("Liver");
		property.setCanonicalName(Constants.Liver);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("Gall Bladder");
		property.setCanonicalName(Constants.GallBladder);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("Pancreas");
		property.setCanonicalName(Constants.Pancreas);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("Intestines");
		property.setCanonicalName(Constants.Intestines);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("SmallIntestine");
		property.setCanonicalName(Constants.SmallIntestine);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("LargeIntestine");
		property.setCanonicalName(Constants.LargeIntestine);
		properties.add(property);
				
		return properties;
	}


	
	public void initMethods() {
	
		BioMightMethodView method;

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
	 * This method will return the X3D for the BioMightSystems.  It runs through each of its components and collects up their
	 * representations and then assembles them into one unified X3D model.
	 * 
	 ********************************************************************************************************************/
	public String getX3D(boolean snipet) {
		
		// Assemble the Abdomen
		String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
		"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n " +
		"<X3D profile='Immersive' >\n" +
		"<head>\n" +
		 "<meta name='BioMightImage' content='Abdomen.jpg'/>\n" +
		 "<meta name='ExportTime' content='7:45:30'/>\n" +
		 "<meta name='ExportDate' content='08/15/2008'/>\n" +
		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='DigestiveSystem'\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		

		String body = "";
		if (BioWebUtils.isViewEnabled(Constants.MouthRef, properties)) {
			body += mouth.getX3D(true);
		}
		if (BioWebUtils.isViewEnabled(Constants.EsophagusRef, properties)) {
			body += esophagus.getX3D(true);
		}
		if (BioWebUtils.isViewEnabled(Constants.StomachRef, properties)) {
			body += stomach.getX3D(true);
		}
		if (BioWebUtils.isViewEnabled(Constants.LiverRef, properties)) {
			body += liver.getX3D(true);
		}
		
		if (BioWebUtils.isViewEnabled(Constants.CysticDuctRef, properties)) {
			body += cysticDuct.getX3D(true);
		}
		if (BioWebUtils.isViewEnabled(Constants.CommonBileDuctRef, properties)) {
			body += commonBileDuct.getX3D(true);
		}
		if (BioWebUtils.isViewEnabled(Constants.CommonHepaticDuctRef, properties)) {
			body += commonHepaticDuct.getX3D(true);
		}	
		if (BioWebUtils.isViewEnabled(Constants.HepaticDuctsRef, properties)) {
			body += hepaticDucts.getX3D(true);
		}	
		if (BioWebUtils.isViewEnabled(Constants.GallBladderRef, properties)) {
			body += gallBladder.getX3D(true);
		}	
		if (BioWebUtils.isViewEnabled(Constants.PancreasRef, properties)) {
			body += pancreas.getX3D(true);
		}		
		if (BioWebUtils.isViewEnabled(Constants.SmallIntestineRef, properties)) {
			body += smallIntestine.getX3D(true);
		}
		if (BioWebUtils.isViewEnabled(Constants.LargeIntestineRef, properties)) {
			body += largeIntestine.getX3D(true);
		}
					
		//System.out.println("DigestiveSystem X3D: " + body);		
		String footer = "</Scene>" + "</X3D>\n";
		
		if (snipet)
			return body;			
		else	
			return header + body + footer;
	}
	
	
	
	public void digest()
	{
	}

	public void peristalisis()
	{
	}	
		
	public void churn()
	{
	}		
			
	public void setDisease()
	{
	}


	public Cardia getCardia() {
		return cardia;
	}


	public void setCardia(Cardia cardia) {
		this.cardia = cardia;
	}


	public Esophagus getEsophagus() {
		return esophagus;
	}


	public void setEsophagus(Esophagus esophagus) {
		this.esophagus = esophagus;
	}


	public LargeIntestine getLargeIntestine() {
		return largeIntestine;
	}


	public void setLargeIntestine(LargeIntestine largeIntestine) {
		this.largeIntestine = largeIntestine;
	}


	public Liver getLiver() {
		return liver;
	}


	public void setLiver(Liver liver) {
		this.liver = liver;
	}


	public Mouth getMouth() {
		return mouth;
	}


	public void setMouth(Mouth mouth) {
		this.mouth = mouth;
	}


	public Pancreas getPancreas() {
		return pancreas;
	}


	public void setPancreas(Pancreas pancreas) {
		this.pancreas = pancreas;
	}


	public Pharynx getPharynx() {
		return pharynx;
	}


	public void setPharynx(Pharynx pharynx) {
		this.pharynx = pharynx;
	}


	public SmallIntestine getSmallIntestine() {
		return smallIntestine;
	}


	public void setSmallIntestine(SmallIntestine smallIntestine) {
		this.smallIntestine = smallIntestine;
	}


	public Stomach getStomach() {
		return stomach;
	}


	public void setStomach(Stomach stomach) {
		this.stomach = stomach;
	}

}
