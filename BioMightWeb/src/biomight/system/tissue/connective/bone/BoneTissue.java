/*
 * Created on May 1, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.system.tissue.connective.bone;
import java.util.ArrayList;

import javax.naming.InitialContext;



import biomight.Constants;
import biomight.cell.extracellularmatrixsecretion.Osteocytes;
import biomight.ejb.BioMightBeanLocal;
import biomight.exceptions.ServerException;
import biomight.system.tissue.Tissue;
import biomight.view.BioMightColor;
import biomight.view.BioMightMethodView;
import biomight.view.BioMightPosition;
import biomight.view.BioMightPropertyView;
import biomight.view.BioMightTransform;
import biomight.view.BioMightTransforms;

/**
 * @author SurferJim
 *
 * Representation of BoneTissue
 */

public class BoneTissue extends Tissue {
	private String tissueName = "BoneTissue";
	private String tissueRef = "BoneTissue";
	private BioMightTransforms bioMightTransforms;
	private Osteocytes osteocytes;
	private BioMightPosition bioMightPosition;
	

	/***********************************************************************************
	 * BoneTissue Constructor
	 *
	 * Using the DNA sequence, create a collection of Epithelial cells based on its
	 * pattern
	 * 
	 * @param dnaSequence
	 **********************************************************************************/
	
	
	public BoneTissue()
	{
		create(this.tissueRef, Constants.BoneTissueRef, null);
	}

	public BoneTissue(String parentID)
	{
		create(this.tissueRef, parentID, null);
	}

	public BoneTissue(String parentID, BioMightPosition bioMightPosition)
	{
		create(this.tissueRef, parentID, null);
		this.bioMightPosition = bioMightPosition;
	}
	
	public BoneTissue(String parentID, ArrayList<BioMightMethodView> bioMightMethods)
	{
		create(this.tissueRef, parentID, bioMightMethods);
	}

	public BoneTissue(String tissueRef, String parentID, ArrayList<BioMightMethodView> bioMightMethods)
	{
		create(tissueRef, parentID, bioMightMethods);
		this.tissueRef = tissueRef;
	}
	
	
	public void create(String tissueRef, String parentID, ArrayList<BioMightMethodView> bioMightMethods)
	{
		this.setImage("images/Bone.jpg");
		this.setImageHeight(300);
		this.setImageWidth(300);
		this.parentID = parentID;
		
		
		System.out.println("Creating the Bone for parent: " + parentID);
		
		if (!tissueRef.equals(""))
			this.tissueName = tissueRef;
		
		// Get the data for the Back that is defined for this 
		// body reference.    	
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Getting BoneInfo for ParentID: " + parentID);
			InitialContext ctx = new InitialContext();
			BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
			bioMightTransforms = bioMightBean.getComponents(tissueRef, parentID);
			System.out.println("Have Bone Info from EJB");   	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - Bone");
			throw new ServerException("Remote Exception getComponents():", e); 	
		}
		
			
		// Run through the collection Back Bone
		ArrayList transforms = bioMightTransforms.getTransforms();
		System.out.println(tissueName + " Bone NumTransforms: " + transforms.size());
		for (int i=0; i<transforms.size(); i++)
		{
			// Get the information for the Upper Lip we are creating
			BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
			//System.out.println("Created Bone (name,id): " + bioMightTransform.getName() + "  " + bioMightTransform.getId());		
	
			componentID = bioMightTransform.getId();
			
			//chondrocytes = new Chondrocytes();
			//chondrocyteExtraCellularMatrix = new ChondrocyteExtraCellularMatrix();		
		}		
		
		System.out.println("Created the Bone for parent: " + parentID);
		initProperties();
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
		
		// Assemble the BoneTissue
		String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
		"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n " +
		"<X3D profile='Immersive' >\n" +
		"<head>\n" +
		 "<meta name='BioMightImage' content='BoneTissue.jpg'/>\n" +
		 "<meta name='ExportTime' content='7:45:30'/>\n" +
		 "<meta name='ExportDate' content='08/15/2008'/>\n" +
		 "<meta name='BioMight Version' content='1.0'/>\n" + 
		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='BoneTissue'\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		

		String body = "";
		String annotate = "";
		
		// Run through the collection of Bone and build them into the model
		// In the default case, we get one instance of the Pupil for each eye
		ArrayList transforms = bioMightTransforms.getTransforms();
		//System.out.println(tissueName + " Bone X3D Elements: " + transforms.size());
		
		for (int i=0; i<transforms.size(); i++)
		{
			// Get the information for the PinnaAntiHelix we are creating
			BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
			//System.out.println("Getting Bone X3D: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
		
			int view = Constants.VIEW_FLOATING;
			if (view == Constants.VIEW_FLOATING)
			{
				//System.out.println("Getting X3D for BoneTissue: " + bioMightSphere.getTranslation().getXPos());
				//System.out.println("Getting X3D for BoneTissue: " + bioMightSphere.getTranslation().getYPos());
				//System.out.println("Getting X3D for BoneTissue: " + bioMightSphere.getTranslation().getZPos());
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
						    
				// Add a teture based upon the BoneTissue we are looking at
			    if (parentID.equals("Arm:01") || parentID.equals("Arm:02"))
			    {
				    body+= " <ImageTexture containerField='texture' " +
				    " url='../images/BoneTissue.jpg'/>";
				}
			    else
			    {
				    body+= " <ImageTexture containerField='texture' " +
				    " url='../images/BoneTissue.jpg'/>";
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
				 	"<IndexedFaceSet DEF='BoneTissueIFS' \n" +
				    	   "containerField='geometry' \n" +
				    	   "creaseAngle='" +  bioMightTransform.getCreaseAngle() + "'\n" +
				    	   "solid='false' \n" +
				    	   "coordIndex='" + bioMightTransform.getCoordindexStr() + "'>" +
				    	   "<Coordinate DEF='BoneTissue_Coord' \n" +
				    	    "containerField='coord' point='" +  bioMightTransform.getCoordpointStr() + "'/>" +
				    	  "</IndexedFaceSet>\n" +
				    	 "</Shape>\n" +
				    	 
				    	 "<TouchSensor DEF='"+ tissueRef +"' \n" +
		                   " description='" + tissueRef + "'\n" +
			               " containerField='children'/> \n" +
				
				"</Transform>\n"; 
		
			
			}
		else
		{
			body = "";//						
		}
		
		}	
		
			
		//System.out.println("BoneTissue X3D: " + body);		
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
	

}
