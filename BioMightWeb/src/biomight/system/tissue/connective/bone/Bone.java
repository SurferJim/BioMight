/*
 * Created on Oct 15, 2004
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.system.tissue.connective.bone;
import java.rmi.RemoteException;
import java.util.ArrayList;

import biomight.BioMightBase;
import biomight.Constants;
import biomight.exceptions.DataSecurityException;
import biomight.exceptions.ServerException;
import biomight.system.cartilage.Cartilage;
import biomight.system.tissue.connective.EndosteumTissue;
import biomight.system.tissue.connective.PeriosteumTissue;
import biomight.system.tissue.connective.blood.Blood;
import biomight.system.tissue.nervous.Nerves;
import biomight.view.BioMightMethodView;
import biomight.view.BioMightPosition;
import biomight.view.BioMightPropertyView;
import biomight.view.BioMightTransform;
import biomight.view.BioMightTransforms;


/**
 * @author Administrator
 *
 * Representation of Bone Tissue.
 * 
 */

public class Bone extends BioMightBase {
	private String tissueName = "Bone";
	protected BoneTissue boneTissue;
	protected Osteons osteons;
	protected ResorptionSpaces resorptionSpaces;
	protected Lacunae lacunae;
	protected HaversianCanal haversianCanal;
	protected BoneMarrow boneMarrow;
	protected EndosteumTissue endosteumTissue; 
	protected PeriosteumTissue periosteumTissue;
	protected Nerves nerves;
	//protected Blood vessels;
	protected Cartilage cartilage;
	

	public Bone()
	{
		create(Constants.BoneRef, null);
	}

	public Bone(String parentID)
	{
		create(parentID, null);
	}

	public Bone(String parentID, BioMightPosition bioMightPosition)
	{
		create(parentID, null);
	}
	
	public Bone(String parentID, ArrayList<BioMightMethodView> bioMightMethods)
	{
		create(parentID, bioMightMethods);
	}

	public void create(String parentID, ArrayList<BioMightMethodView> bioMightMethods)
	{
		this.setImage("images/Bone.jpg");
		this.setImageHeight(300);
		this.setImageWidth(300);
		this.parentID = parentID;
		
		
		//System.out.println("Creating the Bone for parent: " + parentID);
		
		// Get the information from the database via the Enterprise Bean
		/*
		BioMight bioMight;
		try {
		   bioMight = BioMightEJBFactory.createBioMight();
		}  catch (ServerException e) {
			System.out.println("Could not Find Bean!");
			throw new ServerException("Remote Exception:", e); 	
		}		
		 */
		
		// Get the data for the Back that is defined for this 
		// body reference.
		
		
		/*****
		
		try {
			bioMightTransforms = bioMight.getComponents(Constants.BoneRef, parentID);
			System.out.println("Have Bone Info from EJB");
		}catch (RemoteException e) { 
			System.out.println("Exception Getting Components - BackBone");
			throw new ServerException("Remote Exception getComponents():", e); 	
		}catch (DataSecurityException  e) {
			System.out.println("Exception Getting Component");
			throw new ServerException("Remote Exception getComponents():", e); 	
		}
			
		// Run through the collection Back Bone
		ArrayList transforms = bioMightTransforms.getTransforms();
		System.out.println("Have bone Info NumTransforms: " + transforms.size());
		for (int i=0; i<transforms.size(); i++)
		{
			// Get the information for the Upper Lip we are creating
			BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
			System.out.println("Created Bone (name,id): " + bioMightTransform.getName() + "  " + bioMightTransform.getId());		
	
			//chondrocytes = new Chondrocytes();
			//chondrocyteExtraCellularMatrix = new ChondrocyteExtraCellularMatrix();		
		}		
		******/
		
		
		
		//System.out.println("Created the Bone for parent: " + parentID);
		initProperties();
		initMethods();
	}


	public void initProperties() {

		BioMightPropertyView property = new BioMightPropertyView();
		property.setPropertyName("BoneTissue");
		property.setCanonicalName(Constants.BoneTissue);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("Osteons");
		property.setCanonicalName(Constants.Osteons);
		properties.add(property);		

		property = new BioMightPropertyView();
		property.setPropertyName("ResorptionSpaces");
		property.setCanonicalName(Constants.ResorptionSpaces);
		
	}
		
	public void initMethods() {

		BioMightMethodView method = new BioMightMethodView();
		method.setMethodName("Crack");
		method.setHtmlType("checkbox");
		methods.add(method);

		method = new BioMightMethodView();
		method.setMethodName("Bruise");
		method.setHtmlType("checkbox");
		methods.add(method);
	}
	
	
	/********************************************************************************************************************
	 * GET X3D
	 * 
	 * This method will return the X3D for the Bone.  It runs through each of its components and collects up their
	 * representations and then assembles them into one unified X3D model.
	 * 
	 ********************************************************************************************************************/

	public String getX3D(boolean snipet) {
		
		// Assemble the Bone
		String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
		"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n " +
		"<X3D profile='Immersive' >\n" +
		"<head>\n" +
		 "<meta name='BioMightImage' content='Bone.jpg'/>\n" +
		 "<meta name='ExportTime' content='7:45:30'/>\n" +
		 "<meta name='ExportDate' content='08/15/2008'/>\n" +
		 "<meta name='BioMight Version' content='1.0'/>\n" + 
		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='Bone'\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		

		String body = "";
		String annotate = "";
		
		/*
		// Run through the collection of Bone and build them into the model
		// In the default case, we get one instance of the Pupil for each eye
		ArrayList transforms = bioMightTransforms.getTransforms();
		for (int i=0; i<transforms.size(); i++)
		{
			// Get the information for the PinnaAntiHelix we are creating
			BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
			System.out.println("Getting Bone X3D: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
		
			int view = Constants.VIEW_FLOATING;
			if (view == Constants.VIEW_FLOATING)
			{
				//System.out.println("Getting X3D for Bone: " + bioMightSphere.getTranslation().getXPos());
				//System.out.println("Getting X3D for Bone: " + bioMightSphere.getTranslation().getYPos());
				//System.out.println("Getting X3D for Bone: " + bioMightSphere.getTranslation().getZPos());
				// Change the height and width based on the displacement.
				
				body += "<Transform DEF='" + tissueName + "'\n";
				
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
					"<Shape DEF='" + tissueName + "'\n" +
						    " containerField='children'>\n" +
						    " <Appearance\n" +
						    "  containerField='appearance'>\n";
						    
				// We are looking at the base tissue collection
			    if (parentID.equals("1.1000:0"))
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
				 	"<IndexedFaceSet DEF='BoneIFS' \n" +
				    	   "containerField='geometry' \n" +
				    	   "creaseAngle='" +  bioMightTransform.getCreaseAngle() + "'\n" +
				    	   "coordIndex='" + bioMightTransform.getCoordindexStr() + "'>" +
				    	   "<Coordinate DEF='Bone_Coord' \n" +
				    	    "containerField='coord' point='" +  bioMightTransform.getCoordpointStr() + "'/>" +
				    	  "</IndexedFaceSet>\n" +
				    	 "</Shape>\n" +
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
						"string='\"Bone Tissue\"'\n" +
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
		body = "";
		*/
		
		//System.out.println("Bone X3D: " + body);		
		String footer = "</Scene>" + "</X3D>\n";
		
		if (snipet)
			return body + annotate;			
		else	
			return header + body + annotate + footer;
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
			
	
	public void fracture()
	{
	}

	public void compoundFracture()
	{
	}

	public BoneTissue getBoneTissue() {
		return boneTissue;
	}

	public void setBoneTissue(BoneTissue boneTissue) {
		this.boneTissue = boneTissue;
	}

	public Cartilage getCartilage() {
		return cartilage;
	}

	public void setCartilage(Cartilage cartilage) {
		this.cartilage = cartilage;
	}

	public EndosteumTissue getEndosteumTissue() {
		return endosteumTissue;
	}

	public void setEndosteumTissue(EndosteumTissue endosteumTissue) {
		this.endosteumTissue = endosteumTissue;
	}

	public HaversianCanal getHaversianCanal() {
		return haversianCanal;
	}

	public void setHaversianCanal(HaversianCanal haversianCanal) {
		this.haversianCanal = haversianCanal;
	}

	public Lacunae getLacunae() {
		return lacunae;
	}

	public void setLacunae(Lacunae lacunae) {
		this.lacunae = lacunae;
	}


	public Nerves getNerves() {
		return nerves;
	}

	public void setNerves(Nerves nerves) {
		this.nerves = nerves;
	}

	public Osteons getOsteons() {
		return osteons;
	}

	public void setOsteons(Osteons osteons) {
		this.osteons = osteons;
	}

	public ResorptionSpaces getResorptionSpaces() {
		return resorptionSpaces;
	}

	public void setResorptionSpaces(ResorptionSpaces resorptionSpaces) {
		this.resorptionSpaces = resorptionSpaces;
	}


	public BoneMarrow getBoneMarrow() {
		return boneMarrow;
	}

	public void setBoneMarrow(BoneMarrow boneMarrow) {
		this.boneMarrow = boneMarrow;
	}

	public PeriosteumTissue getPeriosteumTissue() {
		return periosteumTissue;
	}

	public void setPeriosteumTissue(PeriosteumTissue periosteumTissue) {
		this.periosteumTissue = periosteumTissue;
	}

	public ArrayList<BioMightMethodView> getMethods() {
		return methods;
	}

	public void setMethods(ArrayList<BioMightMethodView> methods) {
		this.methods = methods;
	}

	public ArrayList<BioMightPropertyView> getProperties() {
		return properties;
	}

	public void setProperties(ArrayList<BioMightPropertyView> properties) {
		this.properties = properties;
	}

}
