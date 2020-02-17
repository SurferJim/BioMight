/*
 * Created on May 1, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.chemistry.hormones.lipid;

import java.util.ArrayList;

import javax.naming.InitialContext;

import biomight.BioMightBase;
import biomight.Constants;
import biomight.chemistry.elements.Carbons;
import biomight.chemistry.elements.Hydrogens;
import biomight.chemistry.elements.Oxygens;
import biomight.ejb.BioMightBeanLocal;
import biomight.exceptions.ServerException;
import biomight.view.BioMightMethodView;
import biomight.view.BioMightPosition;
import biomight.view.BioMightPropertyView;
import biomight.view.BioMightScale;
import biomight.view.BioMightTransform;

/**
 * @author SurferJim
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class Thromboxane extends BioMightBase {
	protected ArrayList moleculeChain = new ArrayList(37);
	protected Carbons carbons;  // 27
	protected Hydrogens hydrogens; // 4
	protected Oxygens oxygens;  // 6
	

	public Thromboxane()
	{		
		// Create hte base Eye
		create(Constants.ThromboxaneRef, null);
	}
	
	
	public Thromboxane(String parentID)
	{				
		create(parentID, null);	
	}
	

	public Thromboxane(String parentID, ArrayList<BioMightMethodView> bioMightMethods)
	{				
		create(parentID, bioMightMethods);	
	}

	
	/************************************************************************************
	 * 
	 * CREATE CHOLESTEROL
	 * @param ThromboxaneReference
	 ***********************************************************************************/
	
	public void create(String parentID, ArrayList<BioMightMethodView> bioMightMethods)
	{		
		this.setImage("images/Thromboxane.gif");
		setImageWidth(200);
		setImageHeight(150);
		
		
		int localVP = Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;

		BioMightScale bioScale = new BioMightScale("0.00, 0.00, 0.00");
		BioMightPosition  bioPos = new BioMightPosition("0.00, 0.00, 0.00");
		String bioTemplate="Thromboxane.x3d";

	
		
		// Either down a level of more detail or render now.
		viewPerspective = Constants.VIEW_FLOATING;
		if (viewPerspective == Constants.VIEW_FLOATING) {
			
			// If we have initialization parameters from the form, 
			//  then apply them before constructing the objects.
			if (bioMightMethods != null){
				System.out.println("NEED TO EXECUTE Thromboxane METHODS: " + bioMightMethods.size());
			}
	
			componentID = parentID;
			
			// Thromboxane
			System.out.println("Creating Thromboxane Chain: " + parentID);
			//MoleculaBuilder molecularBuilder = new MoleculaBuilder(""); 
			
			
			System.out.println("In Thromboxane - Creating Carbon");
			carbons = new Carbons(localVP, localLOD, null, null, bioMightMethods);	
			initProperty(Constants.CarbonRef, Constants.Carbon, Constants.CarbonRef, carbons.getComponentID(), bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);								
			System.out.println("In Elements - Carbon is complete");

			//carbons = new Carbons(parentID, bioMightMethods);
			//initProperty("CarbonAtoms", Constants.Carbons, Constants.CarbonsRef, carbons.getComponentID());
			//System.out.println("Carbon atoms are created : " + parentID);

			//hydrogens = new Hydrogens(parentID, null, bioMightMethods);
			initProperty("HydrogensAtoms", Constants.Hydrogens, Constants.HydrogensRef, hydrogens.getComponentID());
			System.out.println("Hydrogen atoms are created : " + parentID);
			
			System.out.println("In Thromboxane - Creating Oxygen Cell");
			oxygens = new Oxygens(localVP, localLOD, parentID, null, bioMightMethods);	
			System.out.println("In Thromboxane - Oxygen is complete");
			//initProperty("CellMembrane", Constants.CellMembrane, Constants.CellRef, capsomer.getComponentID());
		
			//oxygens = new Oxygens(parentID, bioMightMethods);
			//initProperty("OxygenAtoms", Constants.Oxygens, Constants.OxygensRef, oxygens.getComponentID());
			//System.out.println("Oxygen atoms are created : " + parentID);
		} 
		else if (viewPerspective == Constants.VIEW_INTERNAL) {
	
			// Get the information from the database via the Enterprise Bean		
			try {
				// Get the information from the database via the Enterprise Bean		
				System.out.println("Getting ThromboxaneInfo for ParentID: " + parentID);
				InitialContext ctx = new InitialContext();
				BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
				bioMightTransforms = bioMightBean.getComponents(Constants.ThromboxaneRef, parentID);
				System.out.println("Have Thromboxane Info from EJB");   	
			}catch (Exception e) { 
				System.out.println("Exception Getting Components - Thromboxane");
				throw new ServerException("Remote Exception getComponents():", e); 	
			}
		
			// Run through the collection of Pupils and build them into the model
			// In the default case, we get one instance of the Pupil for each Cell
			ArrayList transforms = bioMightTransforms.getTransforms();
			System.out.println("Have Thromboxane NumTransforms: " + transforms.size());
			for (int i=0; i<transforms.size(); i++)
			{
				// Get the information for the Thromboxane we are creating
				BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
				System.out.println("Creating Thromboxane: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
				this.componentID = bioMightTransform.getId();
				
			}			
			
		}

		//initProperties();
		initMethods();
	
	}

	public void initProperties() {
		
		BioMightPropertyView property = new BioMightPropertyView();
		property.setPropertyName("Bones");
		property.setCanonicalName(Constants.Title);
		properties.add(property);
	
		property = new BioMightPropertyView();
		property.setPropertyName("Cephalic Vein");
		property.setCanonicalName(Constants.CephalicVein);
		properties.add(property);		
	}
	
	
	public void initMethods() {
  
	
		BioMightMethodView method;
		method = new BioMightMethodView();
		method.setMethodName("Flex");
		method.setHtmlType("text");
		method.setDataType("int");
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
		
		// Assembe the Thromboxane
		String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
		"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n " +
		"<X3D profile='Immersive' >\n" +
		"<head>\n" +
		 "<meta name='BioMightImage' content='Thromboxane.jpg'/>\n" +
		 "<meta name='ExportTime' content='7:45:30'/>\n" +
		 "<meta name='ExportDate' content='08/15/2008'/>\n" +
		 "<meta name='BioMight Version' content='1.0'/>\n" + 
		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='Thromboxane'\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		

		String body = "";
		String annotate = "";
		
		int view = Constants.VIEW_FLOATING;
		if (view == Constants.VIEW_FLOATING)
		{
			 body = carbons.getX3D(true);  		
		}
		else if (view == Constants.VIEW_DETACHED)
		{
			// Run through the collection of Thromboxanes and build them into the model
			// In the default case, we get one instance of the Thromboxane for each eye
			ArrayList transforms = bioMightTransforms.getTransforms();
			for (int i=0; i<transforms.size(); i++)
			{
				// Get the information for the capsomer we are creating
				BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
				System.out.println("Creating Thromboxane: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
				System.out.println("Creating Thromboxane at Position: " + 
					bioMightTransform.getTranslation().getXPos() + "  " +
					bioMightTransform.getTranslation().getYPos() + "  " +
					bioMightTransform.getTranslation().getZPos());
			
				//System.out.println("Getting X3D for ThromboxaneX: " + bioMightTransform.getTranslation().getXPos());
				//System.out.println("Getting X3D for ThromboxaneY: " + bioMightTransform.getTranslation().getYPos());
				//System.out.println("Getting X3D for ThromboxaneZ: " + bioMightTransform.getTranslation().getZPos());
				// Change the height and width based on the displacement.
				body += "<Transform DEF='Thromboxane'\n";
				
				
				// Set the position if we are working with the Tissue collection
				if (parentID.equals("Elements:0"))
				{
					body += "translation='"; 
						//+ bioMightPosition.getXPos() + " " 
			 			//+ bioMightPosition.getYPos() + " "
			 			//+ bioMightPosition.getZPos() + "'\n";
				}
				else
				{
			 		body += "translation='" 
			 			+ bioMightTransform.getTranslation().getXPos() + " " 
 						+ bioMightTransform.getTranslation().getYPos() + " "
 						+ bioMightTransform.getTranslation().getZPos() + "'\n";					
				}
				 					
				 					
				body +=  "scale='" 	+ bioMightTransform.getScale().getXPos() + " "
				 				+ bioMightTransform.getScale().getYPos() + " "
				 				+ bioMightTransform.getScale().getZPos() + "'>\n" +
				 	"<Shape DEF='Thromboxane'\n" +
				    " containerField='children'>\n" +
				    " <Appearance\n" +
				    "  containerField='appearance'>\n";
				    
				// We are looking at the base tissue collection
				if (parentID.equals("1.1000000:0"))
			    {
				    body+= " <ImageTexture containerField='texture' " +
				    " url='../images/Thromboxane.jpg'/>";
				}
				
				    
				body+= " <Material DEF='Rust'\n" +
				    "containerField='material'\n" +
				    "ambientIntensity='" 	+ bioMightTransform.getMaterial().getAmbientIntensity() + "'\n" +
				    "shininess='" 			+ bioMightTransform.getMaterial().getShininess() + "'\n" +
				    "transparency='" 		+ bioMightTransform.getMaterial().getTransparency() + "'\n" +
				    "diffuseColor='" + 
				 	    bioMightTransform.getMaterial().getDiffuseColor().getRed() + " " + 
				 	    bioMightTransform.getMaterial().getDiffuseColor().getGreen() + " " +
				 	    bioMightTransform.getMaterial().getDiffuseColor().getBlue() + "'/>\n" +
				 	"</Appearance>\n" +
				 	"<Sphere DEF='ThromboxaneGeoSphere'\n" +
				 	"containerField='geometry'\n" +
				 	"radius='" + bioMightTransform.getRadius() +"'/>\n" +
				 	"</Shape>\n" +
				 "</Transform>\n";	
			}				
		}
		else
		{
			body = "";// no defined view			
		}
			
		System.out.println("Thromboxane X3D: " + body);		
		String footer = "</Scene>" + "</X3D>\n";
		
		if (snipet)
			return body + annotate;			
		else	
			return header + body + annotate + footer;				
	}

}
