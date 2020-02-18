/*
 * Created on Nov 10, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
 
package biomight.system.tissue.connective;
import java.util.ArrayList;

import javax.naming.InitialContext;

import biomight.BioMightBase;
import biomight.Constants;
import biomight.ejb.BioMightBeanLocal;
import biomight.exceptions.ServerException;
import biomight.view.BioMightMethodView;
import biomight.view.BioMightPropertyView;
import biomight.view.BioMightTransform;

/**
 * @author SurferJim
 *
 * Representation of Osteocytes.  
 * 
 */

public class Osteocytes extends BioMightBase {
	private ArrayList<Osteocyte> osteocytes;
	private String osteocyteName = "Osteocyte";
	private String osteocyteRef = "Osteocyte";

	
		
	public Osteocytes()
	{
		create(this.osteocyteRef, Constants.OsteocytesRef, null);
	}

	public Osteocytes(String parentID)
	{
		create(this.osteocyteRef, parentID, null);
	}

	public Osteocytes(String parentID, ArrayList<BioMightMethodView> bioMightMethods)
	{
		create(this.osteocyteRef, parentID, bioMightMethods);
	}

	
	public Osteocytes(String osteocyteRef, String parentID, ArrayList<BioMightMethodView> bioMightMethods)
	{
		this.osteocyteRef = osteocyteRef;
		this.osteocyteName = osteocyteRef;
		create(osteocyteRef, parentID, bioMightMethods);
	}
	
	public void create(String osteocyteRef, String parentID, ArrayList<BioMightMethodView> bioMightMethods)
	{
		this.setImage("images/Osteocytes.jpg");
		this.setImageHeight(300);
		this.setImageWidth(300);

		osteocytes = new ArrayList();
		//System.out.println("Creating Osteocytes: "  + osteocyteRef + "  for parent: " + parentID);
		
		// Get the information from the database via the Enterprise Bean		
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Getting OsteocytesInfo for ParentID: " + parentID);
			InitialContext ctx = new InitialContext();
			BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
			bioMightTransforms = bioMightBean.getComponents(osteocyteRef, parentID);   	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - Osteocytes");
			throw new ServerException("Remote Exception getComponents():", e); 	
		}
			
		properties = new ArrayList<BioMightPropertyView>();

		// Run through the collection ForeArm 
		ArrayList transforms = bioMightTransforms.getTransforms();
		System.out.println("Have Osteocytes Info NumTransforms: " + transforms.size());
		for (int i=0; i<transforms.size(); i++)
		{
			// Get the information for the Upper Lip we are creating
			BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
			//System.out.println("Created Osteocytes (name,id): " + bioMightTransform.getName() + "  " + bioMightTransform.getId());		
			
			Osteocyte osteocyte = new Osteocyte(bioMightTransform.getId(), bioMightMethods);
			osteocytes.add(osteocyte);
			initProperty("Osteocyte", Constants.Osteocyte, Constants.OsteocyteRef, osteocyte.getComponentID());
			//System.out.println("Add Osteocyte to Collection!: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());			
		}		
		
		//System.out.println("Created Osteocytes for parent: " + parentID);
		//initProperties();
		initMethods();
	}
	
	
	
	public void initProperties() {

		
		BioMightPropertyView property = new BioMightPropertyView();
		property.setPropertyName("Osteocyte");
		property.setCanonicalName(Constants.Osteocyte);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("Osteocyte");
		property.setCanonicalName(Constants.Osteocyte);
		properties.add(property);
	}
	
	
	public void initMethods() {

		
		BioMightMethodView method;
		method = new BioMightMethodView();
		method.setMethodName("Set Membrane Width");
		method.setHtmlType("text");
		methods.add(method);
	}	

	
	/********************************************************************************************************************
	 * GET X3D
	 * 
	 * This method will return the X3D for the Osteocyte.  It runs through each of its components and collects up their
	 * representations and then assembles them into one unified X3D model.
	 * 
	 ********************************************************************************************************************/
	public String getX3D(boolean snipet) {
		
		// Assemble the Osteocyte
		String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
		"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n " +
		"<X3D profile='Immersive' >\n" +
		"<head>\n" +
		 "<meta name='BioMightImage' content='Osteocyte.jpg'/>\n" +
		 "<meta name='ExportTime' content='7:45:30'/>\n" +
		 "<meta name='ExportDate' content='08/15/2008'/>\n" +
		 "<meta name='BioMight Version' content='1.0'/>\n" + 
		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='Osteocyte'\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		

		String body = "";
		//System.out.println("Assembling X3D for Osteocytes");
		
		int view = Constants.VIEW_DETACHED;
		if (view == Constants.VIEW_FLOATING)
		{
			// Run through the collection of Osteocytes and assemble the X3D for each
			for (int i=0; i<osteocytes.size(); i++)
			{
				// Get the information for the eye
				Osteocyte osteocyte = (Osteocyte) osteocytes.get(i);
				body += osteocyte.getX3D(true);
			}	
		}
		else if (view == Constants.VIEW_DETACHED)
		{	
			// Take the Osteocytes from the higher, less detailed view.  
			// Run through the collection of Osteocyte and build them into the model
			// In the default case, we get one instance of the Pupil for each eye
			ArrayList transforms = bioMightTransforms.getTransforms();
			for (int i=0; i<transforms.size(); i++)
			{
				// Get the information for the PinnaAntiHelix we are creating
				BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
				//System.out.println("Getting Osteocyte X3D: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
		
		
				//System.out.println("Getting X3D for OsteocyteX: " + bioMightSphere.getTranslation().getXPos());
				//System.out.println("Getting X3D for OsteocyteY: " + bioMightSphere.getTranslation().getYPos());
				//System.out.println("Getting X3D for OsteocyteZ: " + bioMightSphere.getTranslation().getZPos());
				// Change the height and width based on the displacement.
				
				body += "<Transform  onmouseover=\"showComponent('" + bioMightTransform.getId() +  "');\"  DEF='" + bioMightTransform.getId() + "'\n" +
		 			"translation='" + bioMightTransform.getTranslation().getXPos() + " " 
			 					+ bioMightTransform.getTranslation().getYPos() + " "
			 					+ bioMightTransform.getTranslation().getZPos() + "'\n" +
			 		"scale='" 	+ bioMightTransform.getScale().getXPos() + " "
			 				+ bioMightTransform.getScale().getYPos() + " "
			 				+ bioMightTransform.getScale().getZPos() + "'>\n" +
					"<Shape DEF='Osteocyte'\n" +
						    " containerField='children'>\n" +
						    " <Appearance\n" +
						    "  containerField='appearance'>\n";
					
						    
						    // We are looking at the base tissue collection
						    //if (parentID.equals("Arm:01"))
						    //{
							    body+= " <ImageTexture containerField='texture' " +
							    " url='../images/SpeckledWhite.png'/>";
							//}
					
						    
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
						 	
						 	
						 	
						 	"<IndexedFaceSet DEF='OsteocyteIFS' \n" +
						    	   "containerField='geometry' \n" +
						    	   "creaseAngle='" +  bioMightTransform.getCreaseAngle() + "'\n" +
						    	   "solid='false' \n" +
						    	   "coordIndex='" + bioMightTransform.getCoordindexStr() + "'>" +
						    	   "<Coordinate DEF='Osteocyte_Coord' \n" +
						    	    "containerField='coord' point='" +  bioMightTransform.getCoordpointStr() + "'/>" +
						    	  "</IndexedFaceSet>\n" +
					     "</Shape>\n" +
					
					     "<TouchSensor DEF='StartMuscle' \n" +
	                        " description='" + osteocyteRef + "'\n" +
		                    " containerField='children'/> \n" +
		
			       "</Transform>\n";
			}
		}
		else
		{
			body = "";//						
		}
		
		
		//System.out.println("Osteocyte X3D: " + body);		
		String footer = "</Scene>" + "</X3D>\n";
		
		if (snipet)
			return body;			
		else	
			return header + body + footer;
	}

	
	

	
}
