/*
 * Created on May 1, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.system.tissue.connective.blood;

import java.math.BigDecimal;
import java.util.ArrayList;

import javax.naming.InitialContext;











import biomight.Constants;
import biomight.cell.bloodandimmune.Erythrocytes;
import biomight.cell.bloodandimmune.Leukocytes;
import biomight.cell.bloodandimmune.Thrombocytes;
import biomight.chemistry.protein.plasma.Plasma;
import biomight.ejb.BioMightBeanLocal;
import biomight.ejb.BioMightCellularBeanLocal;
import biomight.ejb.BioMightTissueBeanLocal;
import biomight.exceptions.ServerException;
import biomight.system.tissue.Tissue;
import biomight.util.BioGraphics;
import biomight.view.BioMightMethodView;
import biomight.view.BioMightOrientation;
import biomight.view.BioMightPosition;
import biomight.view.BioMightPropertyView;
import biomight.view.BioMightTransform;
import biomight.view.BioMightTransforms;
import biomightweb.util.BioWebX3DUtils;

/**************************************************************************
 * @author SurferJim
 *
 * Representation for Blood
 * 
 **************************************************************************/

public class Blood extends Tissue {
	private String tissueRef = "Blood";
	private String componentType = "BloodTissue";
	private String componentName = "BloodTissue";
	private BioMightTransforms bioMightTransforms;
	private BioMightPosition bioMightPosition;
	private Plasma plasma;
	private Erythrocytes erythrocytes;
	private Leukocytes Leukocytes;
	private Thrombocytes thrombocytes;
	

	/***********************************************************************************
	 * Blood Constructor
	 *
	 * Create Blood
	 * 
	 * @param dnaSequence
	 **********************************************************************************/

	/************************************************************************
	 * Blood Constructor 
	 *
	 ***********************************************************************/
	public Blood()
	{
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create("Blood", localVP, localLOD, Constants.BloodRef, null, null);
	}

	/************************************************************************
	 * Blood Constructor 
	 *
	 ***********************************************************************/
	public Blood(String parentID)
	{
		//System.out.println("Calling parameterized Blood Constructor!");
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create("Blood", localVP, localLOD, parentID, null, null);
	}
	
	/************************************************************************
	 * Blood Constructor 
	 *
	 ***********************************************************************/
	public Blood(int hierarchy, int LOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
	{
		System.out.println("Calling Blood with LOD!");
		create("Blood", hierarchy, LOD, parentID, bioMightProperties, bioMightMethods);
	}
	
	/************************************************************************
	 * Blood Constructor 
	 *
	 ***********************************************************************/
	public Blood(String tissueRef, int hierarchy, int LOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
	{
		System.out.println("Calling Blood with LOD!");
		create(tissueRef, hierarchy, LOD, parentID, bioMightProperties, bioMightMethods);
	}
	
	/************************************************************************
	 * Create Blood
	 *
	 ***********************************************************************/

	public void create(String tissueRef, int hierarchy, int LOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
	{
		this.setImage("images/Blood.jpg");
		this.setImageHeight(300);
		this.setImageWidth(300);
		this.parentID = parentID;
		
		
		System.out.println("Creating the Blood for parent: " + parentID  + "  " + tissueRef);
		
		// Get the information from the database via the Enterprise Bean		
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Getting BloodInfo for ParentID: " + parentID);
			InitialContext ctx = new InitialContext();
			BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
			bioMightTransforms = bioMightBean.getComponents(tissueRef, parentID);
			System.out.println("Have Blood Info from EJB");   	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - Blood");
			throw new ServerException("Remote Exception getComponents():", e); 	
		}
			
		// Run through the collection Blood 
		ArrayList transforms = bioMightTransforms.getTransforms();
		System.out.println("Have blood Info NumTransforms: " + transforms.size());
		for (int i=0; i<transforms.size(); i++)
		{
			// Get the information for the Blood we are creating
			BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
			//System.out.println("Created Blood (name,id): " + bioMightTransform.getName() + "  " + bioMightTransform.getId());		
			componentID = bioMightTransform.getId();
			
			//chondrocytes = new Chondrocytes();
			//chondrocyteExtraCellularMatrix = new ChondrocyteExtraCellularMatrix();		
		}		
		
		System.out.println("Created the Blood for parent: " + parentID);
		//initProperties();
		initMethods();
	}

	
	public void initProperties() {

		properties = new ArrayList<BioMightPropertyView>();

		BioMightPropertyView property = new BioMightPropertyView();
		property.setPropertyName("Plasma");
		property.setCanonicalName(Constants.Plasma);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("Erythrocytes");
		property.setCanonicalName(Constants.Erythrocytes);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("Leukocytes");
		property.setCanonicalName(Constants.Leukocytes);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("Thrombocytes");
		property.setCanonicalName(Constants.Thrombocytes);
		properties.add(property);
		
		
	}
	
	
	public void initMethods() {

		methods = new ArrayList<BioMightMethodView>();
		
		BioMightMethodView method = new BioMightMethodView();

		method = new BioMightMethodView();
		method.setMethodName("Set Volume: ");
		method.setHtmlType("text");
		methods.add(method);

		method = new BioMightMethodView();
		method.setMethodName("Set H20 Content:");
		method.setHtmlType("text");
		methods.add(method);
	}
	
	

	/***********************************************************************************
	 * GENERATE 
	 * 
	 * @param parentID
	 * @param componentID
	 ***********************************************************************************/
	
	public void generate(String parentID, String componentID)
	{
		// Generate the Greater Curvature Edothelium		
		BioMightCellularBeanLocal bioMightBean;
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Generating the Eurythocyte: " + componentID + "    " + parentID);
			InitialContext ctx = new InitialContext();
			bioMightBean = (BioMightCellularBeanLocal) ctx.lookup(Constants.CellularBeanRef);
	
			double radius = 0.3;
		
			// Generate the GreaterCurvature of the stomach
			// Create 5 sections
			double[] startPos = {00., -17.0, -3.0};
			double[][] currentPoints = BioGraphics.octogonYPlane(startPos, radius);

			System.out.println("Calling Generate Eurythrocyte: " + componentID + "    " + parentID);
			
			int numElelements = 1;
			int success = bioMightBean.generateEurythrocyte(numElelements, "CellMembrane:00001", "CellMembrane", 
				"EurythrocyteEndothelium", componentID, parentID, currentPoints);			
					
			System.out.println("Created EurythrocyteEndothelium Info using EJB");   	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - EurythrocyteEndothelium");
			throw new ServerException("Remote Exception getComponents():", e); 	
		}
	}
	
	
	/********************************************************************************************************************
	 * GET X3D
	 * 
	 * This method will return the X3D for the Cartilage.  It runs through each of its components and collects up their
	 * representations and then assembles them into one unified X3D model.
	 * 
	 ********************************************************************************************************************/

	public String getX3D(boolean snipet) {
		
		// Assemble the EpitheliumTissue
		String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
		"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n " +
		"<X3D profile='Immersive' >\n" +
		"<head>\n" +
		 "<meta name='BioMightImage' content='EpitheliumTissue.jpg'/>\n" +
		 "<meta name='ExportTime' content='7:45:30'/>\n" +
		 "<meta name='ExportDate' content='08/15/2008'/>\n" +
		 "<meta name='BioMight Version' content='1.0'/>\n" + 
		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='EpitheliumTissue'\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		

		String body = "";
		String annotate = "";
		
		// Run through the collection of Epithelium and build them into the model
		// In the default case, we get one instance of the Pupil for each eye
		ArrayList transforms = bioMightTransforms.getTransforms();
		//System.out.println(tissueName + " Epithelium X3D Elements: " + transforms.size());
		//System.out.println("EpitheliumTissueX3D: "+ componentType + " for parent: " + parentID);
		
		for (int i=0; i<transforms.size(); i++)
		{
			// Get the information for the PinnaAntiHelix we are creating
			BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
			//System.out.println("Getting Epithelium X3D: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
		
				
			int view = Constants.VIEW_FLOATING;
			if (view == Constants.VIEW_FLOATING)
			{
				//System.out.println("Getting X3D for EpitheliumTissue: " + bioMightSphere.getTranslation().getXPos());
				//System.out.println("Getting X3D for EpitheliumTissue: " + bioMightSphere.getTranslation().getYPos());
				//System.out.println("Getting X3D for EpitheliumTissue: " + bioMightSphere.getTranslation().getZPos());
				// Change the height and width based on the displacement.
				
				body += "<Transform DEF='" + componentType + "'\n";
				
				
				// Set the position if we are working with the Tissue collection
				if (parentID.equals("1.1000:0"))
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
				
			 	body+= "scale='" 	+ bioMightTransform.getScale().getXPos() + " "
			 				+ bioMightTransform.getScale().getYPos() + " "
			 				+ bioMightTransform.getScale().getZPos() + "'>\n" +
					"<Shape DEF='" + componentType + "'\n" +
						    " containerField='children'>\n" +
						    " <Appearance\n" +
						    "  containerField='appearance'>\n";
					    
		
			 	
					    
				// We are looking at the base tissue collection
			 	/*
			    if (parentID.equals("Arm:01") || parentID.equals("Arm:02"))
			    {
				    body+= " <ImageTexture containerField='texture' " +
				    " url='../images/EpitheliumTissue.jpg'/>";
				}
			    else if (parentID.equals("Bladder:01"))
			    {
				    body+= " <ImageTexture containerField='texture' " +
				    " url='../images/Bladder.jpg'/>";
				}	
				*/

			    body+= " <ImageTexture containerField='texture' " +
			    " url='../images/EpitheliumTissue.jpg'/>";
		
				    
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
				    	 
				    	   "creaseAngle='" + 3.14 + "'\n" +
				    	   "solid='false' \n" +
				    	   "coordIndex='" + bioMightTransform.getCoordindexStr() + "'>" +
				    	   "<Coordinate DEF='EpitheliumTissue_Coord' \n" +
				    	    "containerField='coord' point='" +  bioMightTransform.getCoordpointStr() + "'/>" +
				    	  "</IndexedFaceSet>\n" +
				    	 "</Shape>\n" +
				    	 
				    	 
				    	 "<TouchSensor DEF='StartEndothelium' \n" +
		                   " description='" + componentType + "'\n" +
			               " containerField='children'/> \n" +
				    	 
				"</Transform>\n"; 
			}
		}
	
			
		//System.out.println("EpitheliumTissue X3D: " + body);		
		String footer = "</Scene>" + "</X3D>\n";
		
		if (snipet)
			return body + annotate;			
		else	
			return header + body + annotate + footer;
	}
	
	/********************************************************************************************************************
	 * GET X3D OLD
	 * 
	 * This method will return the X3D for the Blood Tissue.  It runs through each of its components and collects up their
	 * representations and then assembles them into one unified X3D model.
	 * 
 	 ********************************************************************************************************************/

	public String getX3D2(boolean snipet) {
		
		// Assemble the BloodTissue
		String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
		"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n " +
		"<X3D profile='Immersive' >\n" +
		"<head>\n" +
		 "<meta name='BioMightImage' content='BloodTissue.jpg'/>\n" +
		 "<meta name='ExportTime' content='7:45:30'/>\n" +
		 "<meta name='ExportDate' content='08/15/2008'/>\n" +
		 "<meta name='BioMight Version' content='1.0'/>\n" + 
		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='BloodTissue'\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		

		String body = "";
		String annotate = "";
		
		// Run through the collection of Back Blood and build them into the model
		// In the default case, we get one instance of the Pupil for each eye
		ArrayList transforms = bioMightTransforms.getTransforms();
		for (int i=0; i<transforms.size(); i++)
		{
			// Get the information for the PinnaAntiHelix we are creating
			BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
			//System.out.println("Getting Blood X3D: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
			componentID = bioMightTransform.getId();
			
			int view = Constants.VIEW_FLOATING;
			if (view == Constants.VIEW_FLOATING)
			{
				//System.out.println("Getting X3D for BloodTissue: " + bioMightSphere.getTranslation().getXPos());
				//System.out.println("Getting X3D for BloodTissue: " + bioMightSphere.getTranslation().getYPos());
				//System.out.println("Getting X3D for BloodTissue: " + bioMightSphere.getTranslation().getZPos());
				// Change the height and width based on the displacement.
				
					BioMightPosition bioMightPosition = new BioMightPosition(0.125, 0, 0);
					BioMightOrientation bioMightOrientation = new BioMightOrientation(0, 0, 1, 90);
					System.out.println("GENERATE generateBloodCell: " + bioMightOrientation.getXAxis() + "  " + bioMightOrientation.getYAxis()  + "  " + bioMightOrientation.getZAxis()  + "  " + bioMightOrientation.getDegrees() );
					body += BioWebX3DUtils.generateBloodCell(bioMightTransform,  bioMightPosition, bioMightOrientation);
		
			}
			else
			{
				body = "";//						
			}
		
		}
		
		//System.out.println("BloodTissue X3D: " + body);		
		String footer = "</Scene>" + "</X3D>\n";
		
		if (snipet)
			return body + annotate;			
		else	
			return header + body + annotate + footer;
	}


	
	/************************************************************************
	 * This method sets the HemoGlobin Saturation percentage.
	 * 
	 * @param percent
	 * 
	 ***********************************************************************/
	
	public void setHemoglobinSaturationPercent(BigDecimal percent)
	{
	}

	public void setImmunoglogin()
	{
	}

	public void setImmunogloginM()
	{
	}
	
	public void setImmunogloginG()
	{
	}	
	

}
