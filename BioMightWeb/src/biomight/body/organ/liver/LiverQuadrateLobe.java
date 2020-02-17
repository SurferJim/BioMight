/*
 * Created on May 3, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.body.organ.liver;

import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.naming.InitialContext;

import biomight.BioMightBase;
import biomight.Constants;
import biomight.ejb.BioMightBeanLocal;
import biomight.exceptions.DataSecurityException;
import biomight.exceptions.ServerException;
import biomight.system.tissue.edothelial.EndotheliumTissue;
import biomight.view.BioMightColor;
import biomight.view.BioMightMethodView;
import biomight.view.BioMightPolygon;
import biomight.view.BioMightPolygons;
import biomight.view.BioMightPosition;
import biomight.view.BioMightPositions;
import biomight.view.BioMightPropertyView;
import biomight.view.BioMightTransform;
import biomight.view.BioMightTransforms;

/**
 * @author SurferJim
 *
 * Representation of the LiverQuadrateLobe
 * 
 */
public class LiverQuadrateLobe extends BioMightBase {
	private BioMightTransforms bioMightTransforms;
	private String componentID;
	private String parentID;
	private ArrayList<BioMightPropertyView> properties;
	private ArrayList<BioMightMethodView> methods;
	protected EndotheliumTissue endothelium;
	
	
	public LiverQuadrateLobe()
	{
		create(Constants.LiverQuadrateLobeRef, null);
	}

	public LiverQuadrateLobe(String parentID)
	{
		create(parentID, null);
	}

	public LiverQuadrateLobe(String parentID, ArrayList<BioMightMethodView> bioMightMethods)
	{
		create(parentID, bioMightMethods);
	}


	public void create(String parentID, ArrayList<BioMightMethodView> bioMightMethods)
	{
		this.setImage("images/LiverQuadrateLobe.jpg");
		this.setImageHeight(300);
		this.setImageWidth(300);
	
		
		// Get the information from the database via the Enterprise Bean		
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Getting LiverQuadrateLobeInfo for ParentID: " + parentID);
			InitialContext ctx = new InitialContext();
			BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
			bioMightTransforms = bioMightBean.getComponents(Constants.LiverQuadrateLobeRef, parentID);
			System.out.println("Have LiverQuadrateLobe Info from EJB");   	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - LiverQuadrateLobe");
			throw new ServerException("Remote Exception getComponents():", e); 	
		}
			
		// Run through the collection of LiverQuadrateLobes and build them into the model
		// In the default case, we get one instance of the LiverQuadrateLobe for each eye
		ArrayList transforms = bioMightTransforms.getTransforms();
		System.out.println("LiverQuadrateLobe NumTransforms: " + transforms.size());
		for (int i=0; i<transforms.size(); i++)
		{
			// Get the information for the eye we are creating
			BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
			System.out.println("Creating LiverQuadrateLobe: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
			this.componentID = bioMightTransform.getId();
			
			/*int viewPerspective = Constants.VIEW_DETACHED;
			if (viewPerspective == Constants.VIEW_DETACHED)
			{				
				// Create the components of the quadrate lobe

			}*/
			
			// Generate the GreaterCurvature Endothelium if needed 
			boolean bGenerate = false;
			if (bGenerate) {
				generate(parentID, componentID);
			}
					
			System.out.println("Creating LiverQuadrateLobe Endothelium: " + bioMightTransform.getId());				
			endothelium = new EndotheliumTissue("LiverEndothelium", bioMightTransform.getId(), bioMightMethods);
			
		}
		initProperties();
		initMethods();
		
		System.out.println("CreateLiverQuadrateLobe Completed");
		
		// First, get all the data from the database
		// Apply the methods to it
		// Save its state
		this.parentID = parentID;
		if (bioMightMethods != null){
			System.out.println("EXECUTING LiverQuadrateLobe METHODS: " + bioMightMethods.size());
			//executeMethods(bioMightMethods);
		}
	}
	
	
	public void generate(String parentID, String componentID)
	{
		// Generate the Liver Edothelium		
		BioMightBeanLocal bioMightBean;
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Generating the LiverEndothelium: " + componentID + "    " + parentID);
			InitialContext ctx = new InitialContext();
			bioMightBean = (BioMightBeanLocal) ctx.lookup("java:global/BioMightWeb/BioMightBean!biomight.ejb.BioMightBeanLocal");
	
			double circumference = 0.6;
		
		
			if (parentID.equals("Liver:01")) 
			{	
				// Generate the GreaterCurvature of the stomach
				// Create 5 sections
				double[] startPos = {-0.3,-17.0, -3.0};
				
				// Create a equilateral octogon
				double x =  startPos[0];
				double y =  startPos[1];
				double z =  startPos[2];

				double[][] currentPoints = { 
		   				 {x, y, z},
		     				 {x, y-circumference,     z-circumference},
		     				 {x, y-(circumference*2), z-circumference},
		     				 {x, y-(circumference*3), z},
		     				 {x, y-(circumference*3), z+(circumference)},
		     				 {x, y-(circumference*2), z+(circumference*2)},
		     				 {x, y-circumference,     z+(circumference*2)},
		     				 {x, y, z+circumference}
		      		};
	
				
				System.out.println("Calling Generate Liver: " + componentID + "    " + parentID);
				
				int success = bioMightBean.generateLiver("LiverEndothelium:00001", "LiverEndothelium", 
					"LiverEndothelium", componentID, parentID, currentPoints);			
						
		
			}			
			else if (parentID.equals("")) 
			{	
					
			}

			
			System.out.println("Created LiverEndothelium Info using EJB");   	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - LiverEndothelium");
			throw new ServerException("Remote Exception getComponents():", e); 	
		}
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
	
	/*********************************************************************************
	 * INIT 3D
	 * 
	 * This method will be executed when we can see cartilage with our regular
	 * perception.  This is not at the cellular level, but as if one were looking
	 * at the ear.
	 *
	 ********************************************************************************/
	public void init3D(BioMightPosition position) {
		
	}
			
	/********************************************************************************************************************
	 * GET X3D
	 * 
	 * This method will return the X3D for the LiverQuadrateLobe.  It runs through each of its components and collects up their
	 * representations and then assembles them into one unified X3D model.
	 * 
	 ********************************************************************************************************************/
	

	public String getX3D(boolean snipet) {
		
		// Assemble the LiverQuadrateLobe
		String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
		"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n " +
		"<X3D profile='Immersive' >\n" +
		"<head>\n" +
		 "<meta name='BioMightImage' content='LiverQuadrateLobe.jpg'/>\n" +
		 "<meta name='ExportTime' content='7:45:30'/>\n" +
		 "<meta name='ExportDate' content='08/15/2008'/>\n" +
		 "<meta name='BioMight Version' content='1.0'/>\n" + 
		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='LiverQuadrateLobe'\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		

		String body = endothelium.getX3D(true);  
		
		System.out.println("LiverQuadrateLobe X3D: " + body);		
		
		String footer = "</Scene>" + "</X3D>\n";
		
		if (snipet)
			return body;			
		else	
			return header + body + footer;
	}
	

	
	public String getX3DExternal(boolean snipet) {
				
				// Assemble the Stomach Liver Quadrate Lobe 
				String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
				"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n " +
				"<X3D profile='Immersive' >\n" +
				"<head>\n" +
				 "<meta name='BioMightImage' content='LiverQuadrateLobe .jpg'/>\n" +
				 "<meta name='ExportTime' content='7:45:30'/>\n" +
				 "<meta name='ExportDate' content='08/15/2008'/>\n" +
				 "<meta name='BioMight Version' content='1.0'/>\n" + 
				"</head>\n" +
				"<Scene>\n" +
				"<WorldInfo\n" +
				"title='LiverQuadrateLobe '\n" +
				"info='\"BioMight Generated X3D\"'/>\n";		


				String body = "";
				
				// Run through the collection of LiverQuadrateLobe  and build them into the model
				// In the default case, we get one instance of the LiverQuadrateLobe  for each Stomach
				ArrayList transforms = bioMightTransforms.getTransforms();
				for (int i=0; i<transforms.size(); i++)
				{
					// Get the information for the LiverQuadrateLobe we are creating
					BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
					System.out.println("Getting LiverQuadrateLobe X3D: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
				
					int view = Constants.VIEW_FLOATING;
					if (view == Constants.VIEW_FLOATING)
					{
						//System.out.println("Getting X3D for LiverQuadrateLobe X: " + bioMightSphere.getTranslation().getXPos());
						//System.out.println("Getting X3D for LiverQuadrateLobe Y: " + bioMightSphere.getTranslation().getYPos());
						//System.out.println("Getting X3D for LiverQuadrateLobe Z: " + bioMightSphere.getTranslation().getZPos());
						// Change the height and width based on the displacement.
						body += "<Transform DEF='LiverQuadrateLobe '\n" +
				 			"translation='" + bioMightTransform.getTranslation().getXPos() + " " 
					 					+ bioMightTransform.getTranslation().getYPos() + " "
					 					+ bioMightTransform.getTranslation().getZPos() + "'\n" +
					 		"scale='" 	+ bioMightTransform.getScale().getXPos() + " "
					 				+ bioMightTransform.getScale().getYPos() + " "
					 				+ bioMightTransform.getScale().getZPos() + "'>\n" +
							"<Shape DEF='LiverQuadrateLobe Shape'\n" +
								    " containerField='children'>\n" +
								    " <Appearance\n" +
								    "  containerField='appearance'>\n" +
								    " <Material DEF='Rust'\n" +
								    "containerField='material'\n" +
								    "ambientIntensity='" + bioMightTransform.getMaterial().getAmbientIntensity() + "'\n" +
								    "shininess='" 		 + bioMightTransform.getMaterial().getShininess() + "'\n" +
								    "transparency='" 	 + bioMightTransform.getMaterial().getTransparency() + "'\n" +
								    "diffuseColor='" + 
								    bioMightTransform.getMaterial().getDiffuseColor().getRed() + " " + 
								    bioMightTransform.getMaterial().getDiffuseColor().getGreen() + " " +
								    bioMightTransform.getMaterial().getDiffuseColor().getBlue() + "'/>\n" +
								 	"</Appearance>\n" +			    
								 	"<IndexedFaceSet DEF='LiverQuadrateLobe IFS' \n" +
								    	   "containerField='geometry' \n" +
								    	   "creaseAngle='" +  bioMightTransform.getCreaseAngle() + "'\n" +
								    	   "coordIndex='" + bioMightTransform.getCoordindexStr() + "'>" +
								    	   "<Coordinate DEF='LiverQuadrateLobe _Coord' \n" +
								    	    "containerField='coord' point='" +  bioMightTransform.getCoordpointStr() + "'/>" +
								    	  "</IndexedFaceSet>\n" +
							"</Shape>\n" +
							"</Transform>\n";
				}
				else
				{
					body = "";//						
				}
				
				}
				
				System.out.println("LiverQuadrateLobe X3D: " + body);		
				String footer = "</Scene>" + "</X3D>\n";
				
				if (snipet)
					return body;			
				else	
					return header + body + footer;
			}


}
