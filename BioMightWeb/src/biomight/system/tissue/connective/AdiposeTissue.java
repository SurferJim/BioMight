/*
 * Created on May 1, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.system.tissue.connective;
import java.util.ArrayList;

import javax.naming.InitialContext;



import biomight.Constants;
import biomight.chemistry.hormones.peptide.Leptin;
import biomight.ejb.BioMightBeanLocal;
import biomight.exceptions.ServerException;
import biomight.system.tissue.Tissue;
import biomight.view.BioMightColor;
import biomight.view.BioMightMethodView;
import biomight.view.BioMightPosition;
import biomight.view.BioMightPropertyView;
import biomight.view.BioMightTransform;

/**********************************************************************************************
 * Adipose Tissue
 * 
 * @author SurferJim
 *
 * Representation of Adipose Tissue
 * 
 **********************************************************************************************/


public class AdiposeTissue extends Tissue {
	private Leptin leptin;
	private String tissueName = "AdiposeTissue";
	private String tissueRef = "AdiposeTissue";
	private BioMightPosition bioMightPosition;
	
	
	
	/***********************************************************************************
	 * AdiposeTissue Constructor
	 *
	 * Using the DNA sequence, create a collection of Connective cells based on its
	 * pattern
	 * 
	 * @param dnaSequence
	 **********************************************************************************/
	
	
	public AdiposeTissue()
	{
		create(this.tissueRef, Constants.AdiposeTissueRef, null);
	}

	public AdiposeTissue(String parentID)
	{
		create(this.tissueRef, parentID, null);
	}
	
	public AdiposeTissue(String parentID, BioMightPosition bioMightPosition)
	{
		create(this.tissueRef, parentID, null);
		this.bioMightPosition = bioMightPosition;
	}
	
	public AdiposeTissue(String parentID, ArrayList<BioMightMethodView> bioMightMethods)
	{
		create(this.tissueRef, parentID, bioMightMethods);
	}

	public AdiposeTissue(String tissueRef, String parentID, ArrayList<BioMightMethodView> bioMightMethods)
	{
		create(tissueRef, parentID, bioMightMethods);
		this.tissueRef = tissueRef;
	}
	

	/****************************************************************************
	 * CREATE
	 * 
	 * @param tissueRef
	 * @param parentID
	 * @param bioMightMethods
	 ***************************************************************************/
	
	public void create(String tissueRef, String parentID, ArrayList<BioMightMethodView> bioMightMethods)
	{
		this.setImage("images/AdiposeTissue.jpg");
		this.setImageHeight(300);
		this.setImageWidth(300);
		this.parentID = parentID;
		
		
		System.out.println("Creating the AdiposeTissue for parent: " + parentID);
		componentID=parentID;
		
		
		if (!tissueRef.equals(""))
			this.tissueName = tissueRef;
		
		// Get the data for the Back that is defined for this 
		// body reference.    	
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Getting " + tissueName + " for ParentID: " + parentID);
			InitialContext ctx = new InitialContext();
			BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
			bioMightTransforms = bioMightBean.getComponents(tissueRef, parentID);  	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - AdiposeTissue");
			throw new ServerException("Remote Exception getComponents():", e); 	
		}
		
			
		// Run through the collection Back Connective
		ArrayList transforms = bioMightTransforms.getTransforms();
		System.out.println(tissueName + " AdiposeTissue NumTransforms: " + transforms.size());
		for (int i=0; i<transforms.size(); i++)
		{
			// Get the information for the Upper Lip we are creating
			BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
			componentID=bioMightTransform.getId();
			//System.out.println("Created Connective (name,id): " + bioMightTransform.getName() + "  " + bioMightTransform.getId());		
			//chondrocytes = new Chondrocytes();
			//chondrocyteExtraCellularMatrix = new ChondrocyteExtraCellularMatrix();
			//initProperty(bioMightTransform.getName(), Constants.FungiformPapilla, Constants.FungiformPapillaRef, bioMightTransform.getId());		
		}		
		
		System.out.println("Created the AdiposeTissue for parent: " + parentID);
		//initProperties();
		initMethods();
	}


	public void initProperties() {
	
		BioMightPropertyView property = new BioMightPropertyView();
		property.setPropertyName("Stapes ---");
		property.setCanonicalName(Constants.LeftEar);
		properties.add(property);
				
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
	 * This method will return the X3D for the Cartilage.  It runs through each of its components and collects up their
	 * representations and then assembles them into one unified X3D model.
	 * 
	 ********************************************************************************************************************/

	public String getX3D(boolean snipet) {
		
		// Assemble the AdiposeTissue
		String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
		"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n " +
		"<X3D profile='Immersive' >\n" +
		"<head>\n" +
		 "<meta name='BioMightImage' content='AdiposeTissue.jpg'/>\n" +
		 "<meta name='ExportTime' content='7:45:30'/>\n" +
		 "<meta name='ExportDate' content='08/15/2008'/>\n" +
		 "<meta name='BioMight' content='001'/>\n" + 
		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='AdiposeTissue'\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		

		String body = "";
		String annotate = "";
		
		// Run through the collection of AdiposeTissue Connective and build them into the model
		// In the default case, we get one instance of the Pupil for each eye
		ArrayList transforms = bioMightTransforms.getTransforms();
		for (int i=0; i<transforms.size(); i++)
		{
			// Get the information for the PinnaAntiHelix we are creating
			BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
			//System.out.println("Getting Connective X3D: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
		
			int view = Constants.VIEW_FLOATING;
			if (view == Constants.VIEW_FLOATING)
			{
				//System.out.println("Getting X3D for AdiposeTissue: " + bioMightSphere.getTranslation().getXPos());
				//System.out.println("Getting X3D for AdiposeTissue: " + bioMightSphere.getTranslation().getYPos());
				//System.out.println("Getting X3D for AdiposeTissue: " + bioMightSphere.getTranslation().getZPos());
				// Change the height and width based on the displacement.
				body += "<Transform DEF='AdiposeTissue'\n";
							
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
					"<Shape DEF='AdiposeTissue'\n" +
						    " containerField='children'>\n" +
						    " <Appearance\n" +
						    "  containerField='appearance'>\n";
						    
							// We are looking at the base tissue collection
						    if (componentID.contains("Nerve"))
						    {
							    body+= " <ImageTexture containerField='texture' " +
							    " url='../images/AdiposeTissue.jpg'/>";
							}
						    else if (componentID.contains("Adipose"))
						    {
							    body+= " <ImageTexture containerField='texture' " +
							    " url='../images/AdiposeTissue.jpg'/>";
							}					    
						    
				 body += " <Material DEF='Rust'\n" +
						    "containerField='material'\n" +
						    "ambientIntensity='" + bioMightTransform.getMaterial().getAmbientIntensity() + "'\n" +
						    "shininess='" 		 + bioMightTransform.getMaterial().getShininess() + "'\n" +
						    "transparency='" 	 + bioMightTransform.getMaterial().getTransparency() + "'\n" +
						    "diffuseColor='" + 
						    bioMightTransform.getMaterial().getDiffuseColor().getRed() + " " + 
						    bioMightTransform.getMaterial().getDiffuseColor().getGreen() + " " +
						    bioMightTransform.getMaterial().getDiffuseColor().getBlue() + "'/>\n" +
						 	"</Appearance>\n" +			    
						 	"<IndexedFaceSet DEF='AdiposeTissueIFS' \n" +
						    	   "containerField='geometry' \n" +
						    	   "creaseAngle='" +  bioMightTransform.getCreaseAngle() + "'\n" +
						    	   "coordIndex='" + bioMightTransform.getCoordindexStr() + "'>" +
						    	   "<Coordinate DEF='AdiposeTissue_Coord' \n" +
						    	    "containerField='coord' point='" +  bioMightTransform.getCoordpointStr() + "'/>" +
						    	  "</IndexedFaceSet>\n" +
					"</Shape>\n" +
					
					
					"<TouchSensor DEF='StartTissue' \n" +
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
					"string='\"Connective Tissue\"'\n" +
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
		
		//System.out.println("AdiposeTissue X3D: " + body);		
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



	
}
