/*
 * Created on Oct 15, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.virus;

/************************************************************************************
 * @author SurferJim
 *
 * Representation of a OuterMembrane.
 * 
 ************************************************************************************/

import java.lang.reflect.Method;
import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.naming.InitialContext;

import biomight.BioMightBase;
import biomight.Constants;
import biomight.cell.Endosomes;
import biomight.chemistry.compound.Granzymes;
import biomight.chemistry.compound.Perforins;
import biomight.ejb.BioMightBeanLocal;
import biomight.ejb.BioMightCellularBeanLocal;
import biomight.exceptions.DataSecurityException;
import biomight.exceptions.ServerException;
import biomight.util.BioGraphics;
import biomight.view.BioMightColor;
import biomight.view.BioMightMethodView;
import biomight.view.BioMightOrientation;
import biomight.view.BioMightPosition;
import biomight.view.BioMightPropertyView;
import biomight.view.BioMightScale;
import biomight.view.BioMightSphere;
import biomight.view.BioMightTransform;
import biomight.view.BioMightTransforms;
import biomight.chemistry.compound.LipidA;
import biomight.chemistry.compound.Peptidoglycan;
import biomight.chemistry.compound.TeichoicAcid;
import biomightweb.util.BioWebUtils;
import biomightweb.util.BioWebX3DUtils;
import biomightweb.view.BioMightViewPoint;


public class OuterMembrane extends BioMightBase {
	private BioMightSphere bioMightSphere1;
	private Capsomeres capsomeres; 
	private Peptidoglycan peptidoglycan;
	private LipidA lipidA;
	private TeichoicAcid teichoicAcid;

	
	/************************************************************************
	 * OuterMembrane Constructor 
	 *
	 ***********************************************************************/
	public OuterMembrane()
	{
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, Constants.OuterMembraneRef, null, null);
	}

	/************************************************************************
	 * OuterMembrane Constructor 
	 *
	 ***********************************************************************/
	public OuterMembrane(String parentID)
	{
		System.out.print("Calling parameterized OuterMembrane Constructor!");
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, parentID, null, null);
	}
	
	
	/************************************************************************
	 * OuterMembrane Constructor 
	 *
	 ***********************************************************************/
	public OuterMembrane(int hierarchy, int LOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
	{
		create(hierarchy, LOD, parentID, bioMightProperties, bioMightMethods);
	}
	
	
	/************************************************************************
	 * Create OuterMembrane
	 *
	 ***********************************************************************/

	public void create(int localVP, int localLOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
	{		
		this.setImage("images/OuterMembrane.jpg");
		this.setImageHeight(300);
		this.setImageWidth(300);
		this.parentID = parentID;
		this.componentID = parentID;
		this.lod = localLOD;
		this.viewPerspective = localVP;
		

		BioMightScale bioScale = new BioMightScale("0.00, 0.00, 0.00");
		BioMightPosition  bioPos = new BioMightPosition("0.00, 0.00, 0.00");
		String bioTemplate="OuterMembrane.x3d";

		// Execute the actions
		if (bioMightMethods != null){
			executeMethods(bioMightMethods);
		}
		
		if (localVP == Constants.VIEW_INTERNAL)			
		{			
			// Generate the Component if needed 
			boolean bGenerate = true;
			if (bGenerate) {
				generate(parentID, componentID);
			}

			// The component is being called from within another component.  We
			// have a parent ID and know what type it is.
			// Get the information from the database via the Enterprise Bean		
			try {
				// Get the information from the database via the Enterprise Bean		
				System.out.println("Getting OuterMembraneInfo for ParentID: " + parentID);
				InitialContext ctx = new InitialContext();
				BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
				bioMightTransforms = bioMightBean.getComponents(Constants.OuterMembraneRef, parentID);
				System.out.println("Have OuterMembrane Info from EJB");   	
			}catch (Exception e) { 
				System.out.println("Exception Getting Components - OuterMembrane");
				throw new ServerException("Remote Exception getComponents():", e); 	
			}
				
			// Run through the collection of Pupils and build them into the model
			// In the default case, we get one instance of the Pupil for each eye
			ArrayList transforms = bioMightTransforms.getTransforms();
			System.out.println("Have OuterMembrane Transforms : " + transforms.size());
			for (int i=0; i<transforms.size(); i++)
			{	
				// Get the information for the eye we are creating
				BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
				System.out.println("Creating OuterMembrane: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
				this.componentID = bioMightTransform.getId();
				

				if (localLOD == Constants.MAG1X)
				{
					System.out.println("Creating OuterMembrane INTERNAL - MAG1X : " + parentID);
					// initialize the Properties
					initProperties();
				}
				else if (localLOD == Constants.MAG2X)
				{
					// Go get the finer details of the OuterMembrane				
					System.out.println("Creating OuterMembrane INTERNAL - MAG2X : " + parentID);
					localVP = Constants.VIEW_HAWKEYE; 
					localLOD = Constants.MAG1X;

					System.out.println("In OuterMembrane - Creating Capsomeres");
					capsomeres = new Capsomeres(bioMightTransform.getId(), bioMightMethods);
					System.out.println("In Capsiod - Capsomeres is complete");
					//initProperty("Endosomes", Constants.Endosomes, Constants.EndosomesRef, endosomes.getComponentID());						}
				}
			}
		}
		else if (localVP == Constants.VIEW_HAWKEYE)
		{
			
			// Generate the Component if needed 
			boolean bGenerate = true;
			if (bGenerate) {
				generate(parentID, componentID);
			}

			// This is when one is accessing a OuterMembrane directly
			// We have the ID of the component through the Drill-down
			// Get the information from the database via the Enterprise Bean		
			try {
				// Get the information from the database via the Enterprise Bean		
				System.out.println("Getting HawkEye OuterMembraneInfo for ParentID: " + parentID);
				InitialContext ctx = new InitialContext();
				BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);

				//bioMightTransforms = bioMightBean.getComponent(parentID);
				bioMightTransforms = bioMightBean.getComponents(Constants.OuterMembraneRef, parentID);

				System.out.println("Have OuterMembrane Info from EJB");   	
			}catch (Exception e) { 
				System.out.println("Exception Getting Components - OuterMembrane");
				throw new ServerException("Remote Exception getComponents():", e); 	
			}
				
			// Run through the collection of OuterMembranes and build them into the model
			// In the default case, we get one instance of the OuterMembrane for each eye
			ArrayList transforms = bioMightTransforms.getTransforms();
			System.out.println("OuterMembrane NumTransforms: " + transforms.size());
			for (int i=0; i<transforms.size(); i++)
			{
				// Get the information for the OuterMembrane
				BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
				System.out.println("Creating OuterMembrane: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
				this.componentID = bioMightTransform.getId();


				if (localLOD == Constants.MAG1X)
				{
					System.out.println("Creating OuterMembrane HAWKEYE - MAG1X: " + parentID);
					// initialize the Properties
					//initProperties();
				}
				else if (localLOD == Constants.MAG2X)
				{
					// Go get the finer details of the OuterMembrane				
					System.out.println("Creating OuterMembrane MAG2X : " + parentID);
					localVP = Constants.VIEW_INTERNAL; 
					localLOD = Constants.MAG1X;

					
					//BioMightScale bioScale = new BioMightScale("0.00, 0.00, 0.00");
					//BioMightPosition  bioPos = new BioMightPosition("0.00, 0.00, 0.00");
					BioMightOrientation  bioOrient = new BioMightOrientation("0.00, 0.00, 1.00, 0.0");
					//String bioTemplate="Bacterias.x3d";
						
					//public BioMightPropertyView(String componentName, String canonicalName, String componentRef, String compDesc, String componentID, BioMightPosition bioPos, BioMightScale dimensions, BioMightOrientation bioOrient, String propType, String templates, boolean viewEnabled)
					initProperty(Constants.NOT_ACTIVATED, Constants.Title, Constants.Title,"", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
					initProperty("Protein I", "Protein 1", "Protein 1", "Protein 1", componentID, bioPos, bioScale, bioOrient, Constants.SINGLE_COMPONENT, bioTemplate, false);
					initProperty("Protein III", "Protein 1", "Protein 1", "Protein 1", componentID, bioPos, bioScale, bioOrient, Constants.SINGLE_COMPONENT, bioTemplate, false);
					initProperty("Pilin", "Protein 1", "Protein 1", "Protein 1", componentID, bioPos, bioScale, bioOrient, Constants.SINGLE_COMPONENT, bioTemplate, false);
					initProperty("H-8 Protein", "Protein 1", "Protein 1", "Protein 1", componentID, bioPos, bioScale, bioOrient, Constants.SINGLE_COMPONENT, bioTemplate, false);
					
					
					//System.out.println("In OuterMembrane - Creating Capsomeres");
					//capsomeres = new Capsomeres(bioMightTransform.getId(), bioMightMethods);
					//System.out.println("In OuterMembrane - Capsomeres is complete");
					//initProperty(Constants.CapsomeresRef, Constants.Capsomeres, Constants.CapsomeresRef, capsomeres.getComponentID(), bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);					
				}
				
			}
		}		
		else
		{
				
		}
				
		
		
				
		//initProperties();
		
		//BioMightScale bioScale = new BioMightScale("0.00, 0.00, 0.00");
		//BioMightPosition  bioPos = new BioMightPosition("0.00, 0.00, 0.00");
		BioMightOrientation  bioOrient = new BioMightOrientation("0.00, 0.00, 1.00, 0.0");
		//String bioTemplate="Bacterias.x3d";
			
		//public BioMightPropertyView(String componentName, String canonicalName, String componentRef, String compDesc, String componentID, BioMightPosition bioPos, BioMightScale dimensions, BioMightOrientation bioOrient, String propType, String templates, boolean viewEnabled)
		initProperty(Constants.NOT_ACTIVATED, Constants.Title, Constants.Title,"", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
		initProperty("Protein I", "Protein 1", "Protein 1", "Protein 1", componentID, bioPos, bioScale, bioOrient, Constants.SINGLE_COMPONENT, bioTemplate, false);
		initProperty("Protein III", "Protein 1", "Protein 1", "Protein 1", componentID, bioPos, bioScale, bioOrient, Constants.SINGLE_COMPONENT, bioTemplate, false);
		initProperty("Pilin", "Protein 1", "Protein 1", "Protein 1", componentID, bioPos, bioScale, bioOrient, Constants.SINGLE_COMPONENT, bioTemplate, false);
		initProperty("H-8 Protein", "Protein 1", "Protein 1", "Protein 1", componentID, bioPos, bioScale, bioOrient, Constants.SINGLE_COMPONENT, bioTemplate, false);

		
		initMethods();
		
		System.out.println("Create OuterMembrane Complete: " + parentID);
		
		// First, get all the data from the database
		// Apply the methods to it
		// Save its state
		this.parentID = parentID;
	
	
	}
			
	public void initProperties() {

		properties = new ArrayList<BioMightPropertyView>();
		
		BioMightPropertyView property = new BioMightPropertyView();
		property.setPropertyName("Capsomere");
		property.setCanonicalName(Constants.Cholesterol);
		properties.add(property);
		
	}
	
	
	public void initMethods() {
	
			
			BioMightMethodView method;
			method = new BioMightMethodView();
			method.setCanonicalName(Constants.OuterMembrane);
			method.setMethodName("setMaterial");
			method.setDisplayName("Color");
			method.setHtmlType(Constants.BIO_DROPDOWN);
			method.setDataType(Constants.BIO_TEXT);
		 	method.setValueMap(materialDDMap);
			methods.add(method);
			
			method = new BioMightMethodView();
			method.setCanonicalName(Constants.OuterMembrane);
			method.setMethodName("setTexture");
			method.setDisplayName("Texture");
			method.setHtmlType(Constants.BIO_DROPDOWN);
			method.setDataType(Constants.BIO_TEXT);
		 	method.setValueMap(textureDDMap);
			methods.add(method);

	}

	
	/***************************************************************************************
	 * GENERATE 
	 * 
	 * @param parentID
	 * @param componentID
	 ***************************************************************************************/
	
	public void generate(String parentID, String componentID)
	{
		// Generate the OuterMembrane		
		BioMightCellularBeanLocal bioMightBean;
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Generating the OuterMembrane: " + componentID + "    " + parentID);
			InitialContext ctx = new InitialContext();
			bioMightBean = (BioMightCellularBeanLocal) ctx.lookup("java:global/BioMightWeb/BioMightCellularBean!biomight.ejb.BioMightCellularBeanLocal");
	

			if (componentID.startsWith(Constants.PoxVirusRef)) {
				double radius = 0.000625;
				// Generate the GreaterCurvature of the stomach
				// Create 5 sections
				double[] startPos = {0.0, 0.250, 0.0};
				//double[][] currentPoints = BioGraphics.octogonYPlane(startPos, circumference);
				double[][] currentPoints = BioGraphics.createCylinderInPlane(Constants.YPLANE, startPos, radius, 6);
		
				System.out.println("Calling Generate PoxVirus OuterMembrane: " + componentID + "    " + parentID);
				int success = bioMightBean.generateOuterMembrane("", "OuterMembrane", 
					"OuterMembrane", componentID, parentID, currentPoints);			
			}
			else if (componentID.startsWith(Constants.AdenovirusRef)) {
				double radius = 0.0025;
				// Generate the GreaterCurvature of the stomach
				// Create 5 sections
				double[] startPos = {0.00125, 0.0, -0.0025};
				//double[][] currentPoints = BioGraphics.octogonYPlane(startPos, circumference);
				double[][] currentPoints = BioGraphics.createCylinderInPlane(Constants.YPLANE, startPos, radius, 6);
		
				System.out.println("Calling Generate Adenovirus OuterMembrane: " + componentID + "    " + parentID);
				//int success = bioMightBean.generateOuterMembrane("", "OuterMembrane", 
				//	"OuterMembrane", componentID, parentID, currentPoints);			
			}
			else if (componentID.startsWith(Constants.BacteriophageRef)) {
				double radius = 0.0025;
				// Generate the GreaterCurvature of the stomach
				// Create 5 sections
				double[] startPos = {0.00125, 0.0, -0.0025};
				//double[][] currentPoints = BioGraphics.octogonYPlane(startPos, circumference);
				double[][] currentPoints = BioGraphics.createCylinderInPlane(Constants.YPLANE, startPos, radius, 6);
		
				System.out.println("Calling Generate Bacteriophage OuterMembrane: " + componentID + "    " + parentID);
				int success = bioMightBean.generateOuterMembrane("", "OuterMembrane", 
					"OuterMembrane", componentID, parentID, currentPoints);			
			}
			else if (componentID.startsWith(Constants.InfluenzaAVirusRef)) 
			{
				double radius = 0.25;
				// Generate the GreaterCurvature of the stomach
				// Create 5 sections
				double[] startPos = {0.0, 0.0, 0.0};
				//double[][] currentPoints = BioGraphics.octogonYPlane(startPos, circumference);
				double[][] currentPoints = BioGraphics.createCylinderInPlane(Constants.YPLANE, startPos, radius, 8);
		
				if (lod == Constants.MAG1X)
				{
					System.out.println("Calling Generate InfluenzaAVirus MAG1X OuterMembrane: " + componentID + "    " + parentID);
					int success = bioMightBean.generateCapsidSphere(startPos, radius, "OuterMembrane", "OuterMembrane", componentID, parentID);
				}
				else if (lod == Constants.MAG2X)
				{
					System.out.println("Calling Generate InfluenzaAVirus MAG2X OuterMembrane: " + componentID + "    " + parentID);
					String startID="";
					int success = bioMightBean.generateOuterMembrane(startID, "OuterMembrane", "OuterMembrane", componentID, parentID, currentPoints);
				}				
			}
			else
			{
				double radius = 0.0025;
				// Generate the GreaterCurvature of the stomach
				// Create 5 sections
				double[] startPos = {0.00125, 0.0, -0.0025};
				//double[][] currentPoints = BioGraphics.octogonYPlane(startPos, circumference);
				double[][] currentPoints = BioGraphics.createCylinderInPlane(Constants.YPLANE, startPos, radius, 6);
		
				System.out.println("Calling Generate OuterMembrane: " + componentID + "    " + parentID);
				String startID="";
				int success = bioMightBean.generateOuterMembrane(startID, "OuterMembrane", 
					"OuterMembrane", componentID, parentID, currentPoints);	
			}
			
			System.out.println("Created OuterMembrane Info using EJB");   	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - OuterMembrane");
			throw new ServerException("Remote Exception generateOuterMembrane():", e); 	
		}
	}
	
	
	
	
	/********************************************************************************************************************
	 * GET X3D
	 * 
	 * This method will return the X3D for the OuterMembrane.  It runs through each of its components and collects up their
	 * representations and then assembles them into one unified X3D model.
	 * 
	 ********************************************************************************************************************/
	public String getX3D(boolean snipet) {
		
		// Assembe the OuterMembrane
		String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
		"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n " +
		"<X3D profile='Immersive' >\n" +
		"<head>\n" +
		 "<meta name='BioMightImage' content='OuterMembrane.jpg'/>\n" +
		 "<meta name='ExportTime' content='7:45:30'/>\n" +
		 "<meta name='ExportDate' content='08/15/2008'/>\n" +
		 "<meta name='BioMight Version' content='1.0'/>\n" + 
		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='OuterMembrane'\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		

		
		String body = "";
			
		if (viewPerspective == Constants.VIEW_INTERNAL)
		{	
			if (lod == Constants.MAG1X)
			{
				
				//body+= BioWebX3DUtils.generatePoxVirusOuterMembrane(bioMightTransform,  bioMightPosition, bioMightOrientation); 	
				
				// Go get the X3D from the subcomponents

				// Run through the collection of OuterMembranes and build them into the model
				// In the default case, we get one instance of the OuterMembrane for each eye
				ArrayList transforms = bioMightTransforms.getTransforms();
				System.out.println("In OuterMembrane - Getting X3D - INTERNAL - MAG1X: " + parentID + "   numTransforms: "  + transforms.size());
				System.out.println("In OuterMembrane - Getting X3D - INTERNAL - MAG1X componentID: " + componentID);
				for (int i=0; i<transforms.size(); i++)
				{
					// Get the information for the sclera we are creating
					BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
					//System.out.println("Getting OuterMembrane X3D: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
			
					//System.out.println("Getting X3D for PupilX: " + bioMightSphere.getTranslation().getXPos());
					//System.out.println("Getting X3D for PupilY: " + bioMightSphere.getTranslation().getYPos());
					//System.out.println("Getting X3D for PupilZ: " + bioMightSphere.getTranslation().getZPos());
					// Change the height and width based on the displacement.
	
					System.out.println("In OuterMembrane - INTERNAL - MAG1X - Getting X3D parent:" + parentID + "  " + componentID);
			
					if (parentID.startsWith(Constants.PoxVirusRef))
					{
						System.out.println("In OuterMembrane - Creating PoxVirus OuterMembrane:" + parentID);
						BioMightPosition bioMightPosition = new BioMightPosition(0.0, 0, 0);
						BioMightOrientation bioMightOrientation = new BioMightOrientation(0, 0, 1, 90);
				
						// HACK - passing in the one BioMightTransform record that was retrieved above
							
						body += "<Transform DEF='OuterMembrane'\n" +
								"translation='" + bioMightTransform.getTranslation().getXPos() + " " 
					 			+ bioMightTransform.getTranslation().getYPos() + " "
					 			+ bioMightTransform.getTranslation().getZPos() + "'\n" 
					 			+ "scale='" 	+ bioMightTransform.getScale().getXPos() + " "
					 			+ bioMightTransform.getScale().getYPos() + " "
					 			+ bioMightTransform.getScale().getZPos() + "'>\n" +
					 				
						"<Shape DEF='" + "OuterMembrane" + "'\n" +
							    " containerField='children'>\n" +
							    " <Appearance\n" +
							    "  containerField='appearance'>\n";
		
						 body+= " <Material DEF='Rust'\n" +
							    "containerField='material'\n" +
							    "ambientIntensity='" + bioMightTransform.getMaterial().getAmbientIntensity() + "'\n" +
							    "shininess='" 		 + bioMightTransform.getMaterial().getShininess() + "'\n" +
							    "transparency='" 	 + bioMightTransform.getMaterial().getTransparency() + "'\n" +
							    "diffuseColor='" + 
							    bioMightTransform.getMaterial().getDiffuseColor().getRed() + " " + 
							    bioMightTransform.getMaterial().getDiffuseColor().getGreen() + " " +
							    bioMightTransform.getMaterial().getDiffuseColor().getBlue() + "'/>\n" +
							 	"</Appearance>\n" +			    
						
							 	"<IndexedFaceSet DEF='EpitheliumTissueIFS' \n" +
							    	   "containerField='geometry' \n" +
							    	   "creaseAngle='" +  bioMightTransform.getCreaseAngle() + "'\n" +
							    	   "coordIndex='" + bioMightTransform.getCoordindexStr() + "'>" +
							    	   "<Coordinate DEF='EpitheliumTissue_Coord' \n" +
							    	    "containerField='coord' point='" +  bioMightTransform.getCoordpointStr() + "'/>" +
							    	  "</IndexedFaceSet>\n" +
							    	 "</Shape>\n" +
							    	 
								    	 
						    "<TouchSensor DEF='StartEndothelium' \n" +
						    " description='" + "OuterMembrane" + "'\n" +
				           " containerField='children'/> \n" +
								    	 
						"</Transform>\n"; 
						
						
					}
					else 
					{
						String componentType = "ViralEnvelope";
						body += "<Transform  onmouseover=\"showComponent('" + "Viral Envelope" +  "');\"  DEF='" + componentType + "'\n" +
								"translation='" + bioMightTransform.getTranslation().getXPos() + " " 
					 			+ bioMightTransform.getTranslation().getYPos() + " "
					 			+ bioMightTransform.getTranslation().getZPos() + "'\n" 
					 			+ "scale='" 	+ bioMightTransform.getScale().getXPos() + " "
					 			+ bioMightTransform.getScale().getYPos() + " "
					 			+ bioMightTransform.getScale().getZPos() + "'>\n" +
					 				
						"<Shape DEF='" + "OuterMembrane" + "'\n" +
							    " containerField='children'>\n" +
							    " <Appearance\n" +
							    	"  containerField='appearance'>\n";
		
						if (bioMightTransform.getTextureID() > 0) {
							body+= " <ImageTexture containerField='texture' url='../images/" +
				    			 bioMightTransform.getTextureFile() +  "' />";
							}
						else
						{
							body+= " <ImageTexture containerField='texture' " +
									" url='../images/StaphylococcusAureus.png'/>";
						}
						
						 body+= " <Material DEF='Rust'\n" +
							    "containerField='material'\n" +
							    "ambientIntensity='" + bioMightTransform.getMaterial().getAmbientIntensity() + "'\n" +
							    "shininess='" 		 + bioMightTransform.getMaterial().getShininess() + "'\n" +
							    "transparency='" 	 + bioMightTransform.getMaterial().getTransparency() + "'\n" +
							    "diffuseColor='" + 
							    bioMightTransform.getMaterial().getDiffuseColor().getRed() + " " + 
							    bioMightTransform.getMaterial().getDiffuseColor().getGreen() + " " +
							    bioMightTransform.getMaterial().getDiffuseColor().getBlue() + "'/>\n" +
							 	"</Appearance>\n" +			    

							 	"<Sphere DEF='OuterMembraneGeoSphere'\n" +
							 	"containerField='geometry'\n" +
							 	"radius='" +   bioMightTransform.getRadius() +"'/>\n" +
							 	"</Shape>\n" +
	 	     	 
						    "<TouchSensor DEF='StartEndothelium' \n" +
						    " description='" + "OuterMembrane" + "'\n" +
				           " containerField='children'/> \n" +
								    	 
						"</Transform>\n"; 
					}
						//System.out.println("OuterMembrane Interim X3D: " + body);	
				}
			}

			else if (lod == Constants.MAG2X)
			{
				// Run through the collection of OuterMembranes and build them into the model
				// In the default case, we get one instance of the OuterMembrane for each eye
				ArrayList transforms = bioMightTransforms.getTransforms();
				System.out.println("In OuterMembrane - Getting X3D - MAG2X - INTERNAL: " + parentID + "   numTransforms: " + transforms.size());
				
				for (int i=0; i<transforms.size(); i++)
				{
					// Get the information for the sclera we are creating
					BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
					//System.out.println("Getting OuterMembrane X3D: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
			
					//System.out.println("Getting X3D for PupilX: " + bioMightSphere.getTranslation().getXPos());
					//System.out.println("Getting X3D for PupilY: " + bioMightSphere.getTranslation().getYPos());
					//System.out.println("Getting X3D for PupilZ: " + bioMightSphere.getTranslation().getZPos());
					// Change the height and width based on the displacement.
					body += "<Transform DEF='OuterMembrane'\n" +
							"translation='" + bioMightTransform.getTranslation().getXPos() + " " 
				 			+ bioMightTransform.getTranslation().getYPos() + " "
				 			+ bioMightTransform.getTranslation().getZPos() + "'\n" 
				 			+ "scale='" 	+ bioMightTransform.getScale().getXPos() + " "
				 			+ bioMightTransform.getScale().getYPos() + " "
				 			+ bioMightTransform.getScale().getZPos() + "'>\n" +
				 				
					"<Shape DEF='" + "OuterMembrane" + "'\n" +
						    " containerField='children'>\n" +
						    " <Appearance\n" +
						    "  containerField='appearance'>\n";
	
					 body+= " <Material DEF='Rust'\n" +
						    "containerField='material'\n" +
						    "ambientIntensity='" + bioMightTransform.getMaterial().getAmbientIntensity() + "'\n" +
						    "shininess='" 		 + bioMightTransform.getMaterial().getShininess() + "'\n" +
						    "transparency='" 	 + bioMightTransform.getMaterial().getTransparency() + "'\n" +
						    "diffuseColor='" + 
						    bioMightTransform.getMaterial().getDiffuseColor().getRed() + " " + 
						    bioMightTransform.getMaterial().getDiffuseColor().getGreen() + " " +
						    bioMightTransform.getMaterial().getDiffuseColor().getBlue() + "'/>\n" +
						 	"</Appearance>\n" +			    
					
						 	"<IndexedFaceSet DEF='EpitheliumTissueIFS' \n" +
						    	   "containerField='geometry' \n" +
						    	   "creaseAngle='" +  bioMightTransform.getCreaseAngle() + "'\n" +
						    	   "coordIndex='" + bioMightTransform.getCoordindexStr() + "'>" +
						    	   "<Coordinate DEF='EpitheliumTissue_Coord' \n" +
						    	    "containerField='coord' point='" +  bioMightTransform.getCoordpointStr() + "'/>" +
						    	  "</IndexedFaceSet>\n" +
						    	 "</Shape>\n" +
						    	 
							    	 
					    "<TouchSensor DEF='StartEndothelium' \n" +
					    " description='" + "OuterMembrane" + "'\n" +
			           " containerField='children'/> \n" +
							    	 
					"</Transform>\n"; 
					 //System.out.println("OuterMembrane Interim X3D: " + body);	
				}
			}
			
		}
		else if (viewPerspective == Constants.VIEW_HAWKEYE)
		{
			if (lod== Constants.MAG1X)
			{
				// Go get the X3D from the subcomponents

				// Run through the collection of OuterMembranes and build them into the model
				// In the default case, we get one instance of the OuterMembrane for each eye
				ArrayList transforms = bioMightTransforms.getTransforms();
				System.out.println("In OuterMembrane - HawkEye - 1X Getting X3D: " + transforms.size() + "  " + componentID + "   " + parentID);
				
				for (int i=0; i<transforms.size(); i++)
				{
					// Get the information for the sclera we are creating
					BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
					//System.out.println("Getting OuterMembrane X3D: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
			
					
					if (parentID.startsWith(Constants.PoxVirusRef))
					{
						if  (i==0) {
						System.out.println("In OuterMembrane - Creating PoxVirus OuterMembrane:" + parentID);
						BioMightPosition bioMightPosition = new BioMightPosition(0.0, 0, 0);
						BioMightOrientation bioMightOrientation = new BioMightOrientation(0, 0, 1, 90);
				
						// HACK - passing in the one BioMightTransform record that was retrieved above
						body+= BioWebX3DUtils.generatePoxVirusOuterMembrane(bioMightTransform,  bioMightPosition, bioMightOrientation);
						}
					}
					else 
					{
						System.out.println("In OuterMembrane - HAWKEYE - MAG1X - Getting X3D for NON FLU:" + parentID);
						body += "<Transform DEF='OuterMembrane'\n" +
								"translation='" + bioMightTransform.getTranslation().getXPos() + " " 
					 			+ bioMightTransform.getTranslation().getYPos() + " "
					 			+ bioMightTransform.getTranslation().getZPos() + "'\n" 
					 			+ "scale='" 	+ bioMightTransform.getScale().getXPos() + " "
					 			+ bioMightTransform.getScale().getYPos() + " "
					 			+ bioMightTransform.getScale().getZPos() + "'>\n" +
					 				
						"<Shape DEF='" + "OuterMembrane" + "'\n" +
							    " containerField='children'>\n" +
							    " <Appearance\n" +
							    "  containerField='appearance'>\n";
		
						 body+= " <Material DEF='Rust'\n" +
							    "containerField='material'\n" +
							    "ambientIntensity='" + bioMightTransform.getMaterial().getAmbientIntensity() + "'\n" +
							    "shininess='" 		 + bioMightTransform.getMaterial().getShininess() + "'\n" +
							    "transparency='" 	 + bioMightTransform.getMaterial().getTransparency() + "'\n" +
							    "diffuseColor='" + 
							    bioMightTransform.getMaterial().getDiffuseColor().getRed() + " " + 
							    bioMightTransform.getMaterial().getDiffuseColor().getGreen() + " " +
							    bioMightTransform.getMaterial().getDiffuseColor().getBlue() + "'/>\n" +
							 	"</Appearance>\n" +			    
						
							 	"<IndexedFaceSet DEF='EpitheliumTissueIFS' \n" +
							    	   "containerField='geometry' \n" +
							    	   "creaseAngle='" +  bioMightTransform.getCreaseAngle() + "'\n" +
							    	   "coordIndex='" + bioMightTransform.getCoordindexStr() + "'>" +
							    	   "<Coordinate DEF='EpitheliumTissue_Coord' \n" +
							    	    "containerField='coord' point='" +  bioMightTransform.getCoordpointStr() + "'/>" +
							    	  "</IndexedFaceSet>\n" +
							    	 "</Shape>\n" +
							    	 
								    	 
						    "<TouchSensor DEF='StartEndothelium' \n" +
						    " description='" + "OuterMembrane" + "'\n" +
				           " containerField='children'/> \n" +
								    	 
						"</Transform>\n"; 
						}
		
					
					 
					 //System.out.println("OuterMembrane Interim X3D: " + body);	
				}
			}
			else if (lod == Constants.MAG2X)
			{
				// Run through the collection of OuterMembranes and build them into the model
				// In the default case, we get one instance of the OuterMembrane for each eye
				ArrayList transforms = bioMightTransforms.getTransforms();
				System.out.println("In OuterMembrane - HawkEye - MAG2X Getting X3D: " + transforms.size());
				
				for (int i=0; i<transforms.size(); i++)
				{
					// Get the information for the sclera we are creating
					BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
					//System.out.println("Getting OuterMembrane X3D: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
			
				
					if (componentID.startsWith(Constants.PoxVirusRef) && i==0)
					{
						if  (i==0) {
						System.out.println("In OuterMembrane - Creating PoxVirus OuterMembrane:" + parentID);
						BioMightPosition bioMightPosition = new BioMightPosition(0.0, 0, 0);
						BioMightOrientation bioMightOrientation = new BioMightOrientation(0, 0, 1, 90);
				
						// HACK - passing in the one BioMightTransform record that was retrieved above
						body+= BioWebX3DUtils.generatePoxVirusOuterMembrane(bioMightTransform,  bioMightPosition, bioMightOrientation);
						}				
					}
					else
					{
					
						//System.out.println("Getting X3D for PupilX: " + bioMightSphere.getTranslation().getXPos());
						//System.out.println("Getting X3D for PupilY: " + bioMightSphere.getTranslation().getYPos());
						//System.out.println("Getting X3D for PupilZ: " + bioMightSphere.getTranslation().getZPos());
						// Change the height and width based on the displacement.
						body += "<Transform DEF='OuterMembrane'\n" +
								"translation='" + bioMightTransform.getTranslation().getXPos() + " " 
					 			+ bioMightTransform.getTranslation().getYPos() + " "
					 			+ bioMightTransform.getTranslation().getZPos() + "'\n" 
					 			+ "scale='" 	+ bioMightTransform.getScale().getXPos() + " "
					 			+ bioMightTransform.getScale().getYPos() + " "
					 			+ bioMightTransform.getScale().getZPos() + "'>\n" +
					 				
						"<Shape DEF='" + "OuterMembrane" + "'\n" +
							    " containerField='children'>\n" +
							    " <Appearance\n" +
							    "  containerField='appearance'>\n";
		
						 body+= " <Material DEF='Rust'\n" +
							    "containerField='material'\n" +
							    "ambientIntensity='" + bioMightTransform.getMaterial().getAmbientIntensity() + "'\n" +
							    "shininess='" 		 + bioMightTransform.getMaterial().getShininess() + "'\n" +
							    "transparency='" 	 + bioMightTransform.getMaterial().getTransparency() + "'\n" +
							    "diffuseColor='" + 
							    bioMightTransform.getMaterial().getDiffuseColor().getRed() + " " + 
							    bioMightTransform.getMaterial().getDiffuseColor().getGreen() + " " +
							    bioMightTransform.getMaterial().getDiffuseColor().getBlue() + "'/>\n" +
							 	"</Appearance>\n" +			    
							 	"<IndexedFaceSet DEF='OuterMembraneIFS' \n" +
							    	   "containerField='geometry' \n" +
							    	   "creaseAngle='" +  bioMightTransform.getCreaseAngle() + "'\n" +
							    	   "coordIndex='" + bioMightTransform.getCoordindexStr() + "'>" +
							    	   "<Coordinate DEF='OuterMembrane_Coord' \n" +
							    	    "containerField='coord' point='" +  bioMightTransform.getCoordpointStr() + "'/>" +
							    	  "</IndexedFaceSet>\n" +
							    	 "</Shape>\n" +
							    	 
								    	 
						    "<TouchSensor DEF='StartEndothelium' \n" +
						    " description='" + "OuterMembrane" + "'\n" +
				           " containerField='children'/> \n" +
								    	 
						"</Transform>\n"; 
						 //System.out.println("OuterMembrane Interim X3D: " + body);
					}
				}
			}
						
		}
		
		
		
		body+= "<Viewpoint DEF='Viewpoint_OuterMembrane'\n" +
				 "description='Viewpoint1'\n" +
				 "jump='true'\n" +
				 "fieldOfView='0.785'\n" +
				 "position='0.0 0.0 0.75'\n" +
				 "orientation='0 0 1 0'/>\n";
		
		//System.out.println("OuterMembrane X3D: " + body);	
		String footer = "</Scene>" + "</X3D>\n";
		
		if (snipet)
			return body;			
		else	
			return header + body + footer;
	}
	
	
	/******************************************************************************************
	 * EXECUTE METHODS 
	 *
	 ******************************************************************************************/
	public void executeMethods(ArrayList<BioMightMethodView> bioMightMethods) {

		// Run through the argument list and executes the 
		// associated methods
		boolean fired = false;
		System.out.println("OuterMembrane-Executing Methods: " + bioMightMethods.size());
		for (int j=0; j<bioMightMethods.size(); j++){
			
			// Get the parameter from the list and if it is not
			// empty execute the associated method using it
			BioMightMethodView bioMightMethod = (BioMightMethodView) bioMightMethods.get(j);
			System.out.println("Have BioMightMethod for OuterMembrane: " + bioMightMethod.getMethodName());	
			String methodName = bioMightMethod.getMethodName();
			String canonicalName = bioMightMethod.getCanonicalName(); 
			String dataType = bioMightMethod.getDataType();
			String methodParam = bioMightMethod.getMethodParameter(); 
			if (methodParam == null)
				methodParam = "";
			
			// We only execute those methods that are targeted for the OuterMembrane
			// If a parameter is specified then we fire the method, otherwise
			// we just jump over it
			if (canonicalName.equals(Constants.OuterMembrane)) {				
				if (!methodParam.equals(""))
				{
					System.out.println("Execute Method " + methodName + " with Signature: "  +  dataType);
					System.out.println("with DataType: "  +  dataType  + "   value: " + methodParam);
					
					fired=true;		
					// Use the DataType parameter to convert the data into its base form
				
					if (dataType.equals(Constants.BIO_INT)) {
						
						try {
							System.out.println("Locating Method(Integer)" + methodName);
							// 	Locate the method through introspection
							int numElements = Integer.parseInt(methodParam);
							Class paramsType[] = {int.class};
							Method method = this.getClass().getDeclaredMethod(methodName, paramsType);
							System.out.println("Before Execute Method(Integer)" + methodName);
							Object result = method.invoke(this, numElements);
							System.out.println("Before Execute Method(Integer)" + methodName);	
						}
						catch (NumberFormatException e)
						{
							System.out.println("Could not Convert to int: " + methodParam);						
						}
						catch (NoSuchMethodException e)
						{
							System.out.println("Method with int param not found: " + e);						
						}	
						catch (Exception e)
						{
							System.out.println("General Exception occurred: " + e);						
						}										
					}
					else if (dataType.equals("double")) {
					
						try {
							System.out.println("Locating Method(Double)" + methodName);
						// Locate the method through introspection
							double numElements = Double.parseDouble(methodParam);
							if (numElements > 0.0)
							{
								Class paramsType[] = {double.class};
								Method method = this.getClass().getDeclaredMethod(methodName, paramsType);
								System.out.println("Before Execute Method(Double)" + methodName);
								Object result = method.invoke(this, numElements);
								System.out.println("Before Execute Method(Double)" + methodName);
							}
							System.out.println("Not Executing Double - 0.0"); 
						
							
						}
							catch (NumberFormatException e)
							{
								System.out.println("Could not Convert to double: " + methodParam);						
							}
							catch (NoSuchMethodException e)
							{
								System.out.println("Method with double param not found: " + e);						
							}	
							catch (Exception e)
							{
								System.out.println("General Exception: " + e);						
							}										
					}
					else if (dataType.equals(Constants.BIO_TEXT)) {
						
						
						try {
							System.out.println("Locating Method(String)");
							
							Class paramsType[] = {String.class};
							Method method = this.getClass().getDeclaredMethod(methodName, paramsType );
							System.out.println("Method with String Param: " + methodName);
							
							System.out.println("Before Execute Method(String)" + methodName);
							Object result = method.invoke(this, methodParam);
							System.out.println("After Execute Method(String)" + methodName);
									
						}
						catch (NoSuchMethodException e)
						{
							System.out.println("Method with String param not found!");						
						}	
						catch (Exception e)
						{
							System.out.println("General Exception: " + e);						
						}	
						
					}
					else if (dataType.equals("")) {
					}			
				}	
			}
			if (fired)
			{	
				//System.out.println("Methods have fired.   Calling OuterMembrane Save method!");
				//save();
			}
		}
	}
	
	
	
	/*****************************************************************************
	 * SET Radius
	 * 
	 * Set the size of the OuterMembrane
	 * 
	 *****************************************************************************/
	public void setRadius(double size) {

		if (size == 0.0)
			size = 0.5;
		
		System.out.println("Setting OuterMembrane Radius: " + size);
		ArrayList transforms = bioMightTransforms.getTransforms();
		for (int i=0; i<transforms.size(); i++)
		{
			// Get the information for the pupil we are creating
			BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
			System.out.println("Updating OuterMembrane Radius: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
			bioMightTransform.setRadius(size);
			
			// Store the updated information OuterMembrane into the transformation
			transforms.set(i,bioMightTransform);
			System.out.println("Updated OuterMembrane Radius");
		}		
		
	}


	/*****************************************************************************
	 * SET COLOR - Sets the color of the OuterMembrane
	 * 
	 * Set the color of the OuterMembrane
	 * 
	 *****************************************************************************/
	public void setColor(String color) {

		int numColor = BioWebUtils.mapColor(color);
		
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Setting OuterMembrane Color to: " + color + " for: " + parentID);
			InitialContext ctx = new InitialContext();
			BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
			int returnCode = bioMightBean.setMaterial(Constants.OuterMembraneRef, parentID, numColor);
			System.out.println("OuterMembrane Color is set: " + returnCode);   	
		}catch (Exception e) { 
			System.out.println("Exception Setting OuterMembrane Color");
			throw new ServerException("Remote Exception setColor():", e); 	
		}
		
	}

	/*****************************************************************************
	 * SAVE 
	 * 
	 * This mmethod writes the Transform information OuterMembrane into the database.
	 * This is called after a series of methods are executed against the 
	 * existing object
	 * 
	 *****************************************************************************/
	private void save() {		
		
		BioMightTransform bioMightTransform = null;
		ArrayList transforms = bioMightTransforms.getTransforms();
		System.out.println("Saving Tranforms for OuterMembrane: " +  transforms.size());
		for (int i=0; i<transforms.size(); i++) {
			// Get the information for the pupil we are creating
			bioMightTransform = (BioMightTransform) transforms.get(i);
			System.out.println("Updating OuterMembrane Tranforms: " + bioMightTransform.getName() + "  " + bioMightTransform.getId()); 
			//System.out.println("OuterMembrane Tranforms Radius is: " + bioMightTransform.getName() + "  " + bioMightTransform.getRadius());
		}
		
		// Get the information from the database via the Enterprise Bean				
		try {
			// Save the information via the update call	
			System.out.println("Saving OuterMembrane Data");
			InitialContext ctx = new InitialContext();
			BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
			int returnCode = bioMightBean.updateComponent(Constants.OuterMembraneRef, parentID, bioMightTransform);
			System.out.println("Saved OuterMembrane Data!");  	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - Back");
			throw new ServerException("Remote Exception getComponents():", e); 	
		}
		
		
		
	}

	/*************************************************************************
	 * OnContact
	 * 
	 * When the cell membrane comes in contact with an object, they exchange
	 * the exchange is reflected here.
	 ************************************************************************/
	
	public void onContact(Object obj)
	{	
		// Check if a virus is making contact with
		// the GastroIntestinal components

		if (obj instanceof Perforins)
		{
			// Form a channel through the cell membrane
			// this leads to loss of cell contents and death
		}

		if (obj instanceof Granzymes)
		{
			// Protease that degrades the proteins in the cell membrane
			// leading to rupture and loss of cell contents
			// If there are enough of them, a=]nd the time is sustained, then
			// theoretically, the reactions should take place.
			// Lyse the membrane
		}
	}

	
	public void rupture()
	{
		// Rupture open a hole in the membrane at the point of most weakness
		
	}
	
	public void setVoltageGradient()
	{
	}


}
