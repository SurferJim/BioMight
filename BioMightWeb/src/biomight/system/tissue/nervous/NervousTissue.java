/*
 * Created on Sep 23, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.system.tissue.nervous;
import java.util.ArrayList;

import javax.naming.InitialContext;



import biomight.Constants;
import biomight.cell.neuronglial.nueron.*;
import biomight.ejb.BioMightBeanLocal;
import biomight.exceptions.ServerException;
import biomight.system.tissue.Tissue;
import biomight.view.BioMightColor;
import biomight.view.BioMightMethodView;
import biomight.view.BioMightPosition;
import biomight.view.BioMightPropertyView;
import biomight.view.BioMightTransform;
import biomight.view.BioMightTransforms;


/*************************************************************************************
 * NERVOUS TISSUE
 *
 * 
 ************************************************************************************/
public class NervousTissue extends Tissue {
	private String tissueName = "NervousTissue";
	private String tissueRef = "NervousTissue";
	private BioMightTransforms bioMightTransforms;
	private ArrayList<BioMightPropertyView> properties;
	private ArrayList<BioMightMethodView> methods;
	private String componentID;
	private String parentID;
	private BioMightPosition bioMightPosition;

	private Neurons neurons;
	private Neuroglia neuroglia;


	/***********************************************************************************
	 * NervousTissue Constructor
	 *
	 * Using the DNA sequence, create a collection of Epithelial cells based on its
	 * pattern
	 * 
	 * @param dnaSequence
	 **********************************************************************************/
	
	
	public NervousTissue()
	{
		create(this.tissueRef, Constants.NervousTissueRef, null);
	}

	public NervousTissue(String parentID)
	{
		create(this.tissueRef, parentID, null);
	}

	public NervousTissue(String parentID, BioMightPosition bioMightPosition)
	{
		create(this.tissueRef, parentID, null);
		this.bioMightPosition = bioMightPosition;
	}
	
	public NervousTissue(String parentID, ArrayList<BioMightMethodView> bioMightMethods)
	{
		create(this.tissueRef, parentID, bioMightMethods);
	}

	public NervousTissue(String tissueRef, String parentID, ArrayList<BioMightMethodView> bioMightMethods)
	{
		create(tissueRef, parentID, bioMightMethods);
		this.tissueRef = tissueRef;
	}
	
	/****************************************************************************************
	 * CREATE
	 * @param tissueRef
	 * @param parentID
	 * @param bioMightMethods
	 ****************************************************************************************/
	public void create(String tissueRef, String parentID, ArrayList<BioMightMethodView> bioMightMethods)
	{
		this.setImage("images/Nervous.jpg");
		this.setImageHeight(300);
		this.setImageWidth(300);
		this.parentID = parentID;
		
		
		System.out.println("Creating the Nervous for parent: " + parentID);
		
		if (!tissueRef.equals(""))
			this.tissueName = tissueRef;
		
		// Get the data for the Back that is defined for this 
		// body reference.    	
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Getting NervousInfo for ParentID: " + parentID);
			InitialContext ctx = new InitialContext();
			BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
			bioMightTransforms = bioMightBean.getComponents(tissueRef, parentID);
			System.out.println("Have Nervous Info from EJB");   	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - Nervous");
			throw new ServerException("Remote Exception getComponents():", e); 	
		}
		
			
		// Run through the collection Back Nervous
		ArrayList transforms = bioMightTransforms.getTransforms();
		System.out.println(tissueName + " Nervous NumTransforms: " + transforms.size());
		for (int i=0; i<transforms.size(); i++)
		{
			// Get the information for the Upper Lip we are creating
			BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
			//System.out.println("Created Nervous (name,id): " + bioMightTransform.getName() + "  " + bioMightTransform.getId());		
	
			componentID = bioMightTransform.getId();
			
			//chondrocytes = new Chondrocytes();
			//chondrocyteExtraCellularMatrix = new ChondrocyteExtraCellularMatrix();		
		}		
		
		System.out.println("Created the Nervous for parent: " + parentID);
		//initProperties();
		initMethods();
	}

	

	public void initProperties() {

		properties = new ArrayList<BioMightPropertyView>();
		
		BioMightPropertyView property = new BioMightPropertyView();
		property.setPropertyName("Stapes ---");
		property.setCanonicalName(Constants.LeftEar);
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
	 * This method will return the X3D for the Cartilage.  It runs through each of its components and collects up their
	 * representations and then assembles them into one unified X3D model.
	 * 
	 ********************************************************************************************************************/

	public String getX3D(boolean snipet) {
		
		// Assemble the NervousTissue
		String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
		"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n " +
		"<X3D profile='Immersive' >\n" +
		"<head>\n" +
		 "<meta name='BioMightImage' content='NervousTissue.jpg'/>\n" +
		 "<meta name='ExportTime' content='7:45:30'/>\n" +
		 "<meta name='ExportDate' content='08/15/2008'/>\n" +
		 "<meta name='BioMight Version' content='1.0'/>\n" + 
		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='NervousTissue'\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		

		String body = "";
		String annotate = "";
		
		// Run through the collection of Nervous and build them into the model
		// In the default case, we get one instance of the Pupil for each eye
		ArrayList transforms = bioMightTransforms.getTransforms();
		//System.out.println(tissueName + " Nervous X3D Elements: " + transforms.size());
		
		for (int i=0; i<transforms.size(); i++)
		{
			// Get the information for the PinnaAntiHelix we are creating
			BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
			//System.out.println("Getting Nervous X3D: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
		
			int view = Constants.VIEW_FLOATING;
			if (view == Constants.VIEW_FLOATING)
			{
				//System.out.println("Getting X3D for NervousTissue: " + bioMightSphere.getTranslation().getXPos());
				//System.out.println("Getting X3D for NervousTissue: " + bioMightSphere.getTranslation().getYPos());
				//System.out.println("Getting X3D for NervousTissue: " + bioMightSphere.getTranslation().getZPos());
				// Change the height and width based on the displacement.
				
				body += "<Transform DEF='" + tissueRef + "'\n";
				
				
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
					"<Shape DEF='" + tissueRef + "'\n" +
						    " containerField='children'>\n" +
						    " <Appearance\n" +
						    "  containerField='appearance'>\n";
						    
				// We are looking at the base tissue collection
			    if (parentID.equals("Arm:01") || parentID.equals("Arm:02"))
			    {
				    body+= " <ImageTexture containerField='texture' " +
				    " url='../images/NervousTissue.jpg'/>";
				}
			    // We are looking at the base tissue collection
			    else if (parentID.equals("Pancreas:01"))
			    {
				    body+= " <ImageTexture containerField='texture' " +
				    " url='../images/PancreasTissue.gif'/>";
				}		
			    else if (parentID.equals("Liver:01"))
			    {
				    body+= " <ImageTexture containerField='texture' " +
				    " url='../images/LiverHepa.jpg'/>";
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
				 	"<IndexedFaceSet DEF='NervousTissueIFS' \n" +
				    	   "containerField='geometry' \n" +
				    	   "creaseAngle='" +  bioMightTransform.getCreaseAngle() + "'\n" +
				    	   "coordIndex='" + bioMightTransform.getCoordindexStr() + "'>" +
				    	   "<Coordinate DEF='NervousTissue_Coord' \n" +
				    	    "containerField='coord' point='" +  bioMightTransform.getCoordpointStr() + "'/>" +
				    	  "</IndexedFaceSet>\n" +
				    	 "</Shape>\n" +
				    	 
				    	 
				    	 "<TouchSensor DEF='StartEndothelium' \n" +
		                   " description='" + tissueRef + "'\n" +
			               " containerField='children'/> \n" +
				    	 
				"</Transform>\n"; 
		

				//	Add the text to the Tissue sample
				if (parentID.equals("1.1000:0"))
				{
					annotate = 
					"<Transform DEF='TissueText' \n" +
					"translation='" + (bioMightPosition.getXPos() + 1.25) + " "  
					+ bioMightPosition.getYPos() + " "
					+ bioMightPosition.getZPos() + "'>\n" +
						"<Shape DEF='Tisssuesn'>\n" +
						"<Appearance\n" +
						"containerField='appearance'>\n" +
						"<Material containerField='material' USE='Red'/>\n" +
						"</Appearance>\n" +
						"<Text DEF='GeoText2'\n" +
						"containerField='geometry'\n" +
						"string='\"Nervous Tissue\"'\n" +
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
		
			
		//System.out.println("NervousTissue X3D: " + body);		
		String footer = "</Scene>" + "</X3D>\n";
		
		if (snipet)
			return body + annotate;			
		else	
			return header + body + annotate + footer;
	}


	public BioMightColor getBioMightColor() {
		return bioMightColor;
	}



	public void setBioMightColor(BioMightColor bioMightColor) {
		this.bioMightColor = bioMightColor;
	}

	public String getTissueName() {
		return tissueName;
	}

	public void setTissueName(String tissueName) {
		this.tissueName = tissueName;
	}

	public String getTissueRef() {
		return tissueRef;
	}

	public void setTissueRef(String tissueRef) {
		this.tissueRef = tissueRef;
	}
	

	public String getComponentID() {
		return componentID;
	}

	public void setComponentID(String componentID) {
		this.componentID = componentID;
	}

	public String getParentID() {
		return parentID;
	}

	public void setParentID(String parentID) {
		this.parentID = parentID;
	}
}
