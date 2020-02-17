/*
 * Created on Oct 15, 2004
 *
 *  Each kidney is about 11.25 cm. in length, 5 to 7.5 cm. in breadth, 
 * and rather more than 2.5 cm. in thickness. The left is somewhat longer, and 
 * narrower, than the right. The weight of the kidney in the adult male varies 
 * from 125 to 170 gm., in the adult female from 115 to 155 gm. The combined weight 
 * of the two kidneys in proportion to that of the body is about 1 to 240.
 * 
 */
 
package biomight.body.organ.kidney;

import java.util.ArrayList;


/**
* @author Administrator
*
* To change the template for this generated type comment go to
* Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
*/

import java.util.ArrayList;

import biomight.BioMightBase;
import biomight.Constants;
import biomight.view.BioMightColor;
import biomight.view.BioMightMethodView;
import biomight.view.BioMightPolygon;
import biomight.view.BioMightPolygons;
import biomight.view.BioMightPosition;
import biomight.view.BioMightPositions;
import biomight.view.BioMightPropertyView;

	/**
	 * @author SurferJim
	 *
	 * Representation of the LiverQuadrateLobe
	 * 
	 */
	public class RightKidney extends Kidney {
		private BioMightPolygons bioMightPolygons;
		private ArrayList<BioMightPropertyView> properties;
		private ArrayList<BioMightMethodView> methods;
		
		
		public RightKidney()
		{
			this.setImage("images/RightKidney.jpg");
			this.setImageHeight(300);
			this.setImageWidth(300);
			initProperties();
			initMethods();
		}

		
		public RightKidney(BioMightPosition bioMightPosition)
		{
			this.setImage("images/RightKidney.jpg");
			this.setImageHeight(300);
			this.setImageWidth(300);
			initProperties();
			initMethods();
			
			System.out.println("Creating the RightKidney at Position: " + bioMightPosition.getXPos());
			init3D(bioMightPosition);
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
			
			// Create a group of polygons to represent the RightKidney
			bioMightPolygons = new BioMightPolygons();

			double xPos = -8.0;
			double thickness = 0.02;
			double heightStart = 1.0;
			double heightEnd = 4.0;
			double length = 1.0;
			
			String coordinateString = "";
			String translationString = "";
			String rotationString = "";
			
				
			double yPos = -20.5;
			for (int alpha=0; alpha<1; alpha++)
			{	
				// Allocate the Coordinate-Point Array for Polygon 
				BioMightPositions coordpoint = new BioMightPositions();
				
				// Liver
				yPos = -20.0;
				heightStart = 4.5;
				coordinateString = 				
					"5.5, " + yPos + ", -4.5," +
					"7.5, " + yPos + ", -4.5," +
					"7.5, " + -24.0 + ", -4.5," +
					"5.5, " + -24.0 + ", -4.5";		
				
				System.out.println("RightKidneyCoordStr: " + coordinateString); 
				String[] coords = coordinateString.split(",", 24);
				System.out.println("After Split: " + coords[0]+coords[1]+coords[2]+coords[3]); 
				
				// Store the Coordinate Points in BioMightPosition objects
				int j=0;
				for (int i=0;i<=11;i+=3)
				{
					BioMightPosition vertex = new BioMightPosition();
					
					vertex.setXPos(Double.valueOf(coords[i]));
					vertex.setYPos(Double.valueOf(coords[i+1]));
					vertex.setZPos(Double.valueOf(coords[i+2]));
					System.out.println("Storing Coordinates: " + j +    "  x: " + coords[i] + " y: " + coords[i+1] + " z: " + coords[i+2]);	
					coordpoint.setBioMightPosition(j++, vertex);
				}

				// Store the lower plane
				for (int i=0;i<=11;i+=3)
				{
					BioMightPosition vertex = new BioMightPosition();
					
					vertex.setXPos(Double.valueOf(coords[i]));
					vertex.setYPos(Double.valueOf(coords[i+1]));
					vertex.setZPos(Double.valueOf(coords[i+2])-4.25);
					System.out.println("Storing Coordinates: " + j +    "  x: " + coords[i] + " y: " + coords[i+1] + " z: " + coords[i+2]);	
					coordpoint.setBioMightPosition(j++, vertex);
				}
				
				// Allocate the Coordinate-Index Array for Polygon 
				int tempInd[] = {
					    0, 1, 3, -1, 
					    3, 1, 2, -1,
					    2, 1, 6, -1,
					    1, 5, 6, -1,
					    5, 4, 6, -1,
					    6, 4, 7, -1,
					    4, 0, 7, -1,
					    7, 0, 3, -1,
					    1, 5, 4, -1,
					    4, 0, 1, -1,
					    1, 5, 4, -1,
					    4, 0, 1, -1,
					    2, 6, 7, -1,
					    7, 3, 2, -1};
				// Store the Coordinate Points
				BioMightPolygon bioMightPolygon = new BioMightPolygon();
				System.out.println("Created RightKidney Polygon");		
				
				bioMightPolygon.setCoordpoint(coordpoint);
				System.out.println("Storing Polygon Coords: " + bioMightPolygon.getCoordpointStr());		
				
				bioMightPolygon.setCoordIndex(tempInd);		
				System.out.println("Stored CoordIndex: " + bioMightPolygon.getCoordindexStr());
				
				double creaseAngle= 0.524;
				bioMightPolygon.setCreaseAngle(creaseAngle);
				//System.out.println("Set CreaseAngle");		
				
				if (position != null)
				{
					// Set up the origin - translation
					bioMightPolygon.getTranslation().setXPos(position.getXPos());
					bioMightPolygon.getTranslation().setYPos(position.getYPos());
					bioMightPolygon.getTranslation().setZPos(position.getZPos());
					System.out.println("Init3D - Set RightKidney TranslationX: " + position.getXPos());
					//System.out.println("Init3D - Set EpitheliumTissue TranslationY: " + position.getYPos());
				    //System.out.println("Init3D - Set EpitheliumTissue TranslationZ: " + position.getZPos());
				}
				else
					System.out.println("RightKidney Polygon - init3d - position is null!");
				
				// Set up the scale
				bioMightPolygon.getScale().setXPos(1);
				bioMightPolygon.getScale().setYPos(1);
				bioMightPolygon.getScale().setZPos(1);
				System.out.println("Init3D - Set RightKidney Scale...");
				
				// Set up the material information 
				bioMightPolygon.getMaterial().setAmbientIntensity(0.200);
				bioMightPolygon.getMaterial().setShininess(0.100);
				bioMightPolygon.getMaterial().setTransparency(0.0);
				System.out.println("Init3D - Set RightKidney Transparency...");

				bioMightColor = new BioMightColor();
				if (alpha == 0){
				// Set up the color of the material
				bioMightColor.setRed(.70);
				bioMightColor.setBlue(0.39);
				bioMightColor.setGreen(0.30);
				}

					
				if (bioMightColor != null)
				{
					bioMightPolygon.getMaterial().getDiffuseColor().setRed(bioMightColor.getRed());
					bioMightPolygon.getMaterial().getDiffuseColor().setGreen(bioMightColor.getGreen());
					bioMightPolygon.getMaterial().getDiffuseColor().setBlue(bioMightColor.getBlue());
				}
				else
				{
					System.out.println("It is NULL COLOR - choosing default from BioMightBase");
					bioMightPolygon.getMaterial().getDiffuseColor().setRed(this.bioMightColor.getRed());
					bioMightPolygon.getMaterial().getDiffuseColor().setGreen(this.bioMightColor.getGreen());
					bioMightPolygon.getMaterial().getDiffuseColor().setBlue(this.bioMightColor.getBlue());			
				}
				System.out.println("Init3D - Set RightKidney EpitheliumTissue Color...");

				
				System.out.println("Adding Polygon...");
				bioMightPolygons.setbioMightPolygon(alpha, bioMightPolygon);
				
				xPos += 0.4;
			}			
		
		}	
		
		/********************************************************************************************************************
		 * GET X3D
		 * 
		 * This method will return the X3D for the Cell.  It runs through each of its components and collects up their
		 * representations and then assembles them into one unified X3D model.
		 * 
		 ********************************************************************************************************************/
		public String getX3D(boolean snipet) {
			
			// Assemble the Nose
			String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
			"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n " +
			"<X3D profile='Immersive' >\n" +
			"<head>\n" +
			 "<meta name='BioMightImage' content='Nose.jpg'/>\n" +
			 "<meta name='ExportTime' content='7:45:30'/>\n" +
			 "<meta name='ExportDate' content='08/15/2008'/>\n" +
			 "<meta name='BioMight Version' content='1.0'/>\n" + 
			"</head>\n" +
			"<Scene>\n" +
			"<WorldInfo\n" +
			"title='RightKidney'\n" +
			"info='\"BioMight Generated X3D\"'/>\n";		

			String body = "";
			int view = Constants.VIEW_DETACHED;
			if (view == Constants.VIEW_DETACHED)
			{				

				for (int alpha=0; alpha<1; alpha++)
				{	
					BioMightPolygon bioMightPolygon = bioMightPolygons.getbioMightPolygon(alpha);
					System.out.println("Getting X3D PolyGon: " + alpha);
					
					System.out.println("Getting X3D for RightKidneyX: " + bioMightPolygon.getTranslation().getXPos());
					System.out.println("Getting X3D for RightKidneyY: " + bioMightPolygon.getTranslation().getYPos());
					System.out.println("Getting X3D for RightKidneyZ: " + bioMightPolygon.getTranslation().getZPos());
					// Change the height and width based on the displacement.
				
				body += "<Transform DEF='RightKidney'\n" +
			 		"translation='" + bioMightPolygon.getTranslation().getXPos() + " " 
				 					+ bioMightPolygon.getTranslation().getYPos() + " "
				 					+ bioMightPolygon.getTranslation().getZPos() + "'\n" +
				 	"scale='" 	+ bioMightPolygon.getScale().getXPos() + " "
				 				+ bioMightPolygon.getScale().getYPos() + " "
				 				+ bioMightPolygon.getScale().getZPos() + "'>\n" +
				 	"<Shape DEF='RightKidney'\n" +
				    " containerField='children'>\n" +
				    " <Appearance\n" +
				    "  containerField='appearance'>\n" +
				    " <Material DEF='Rust'\n" +
				    "containerField='material'\n" +
				    "ambientIntensity='" + bioMightPolygon.getMaterial().getAmbientIntensity() + "'\n" +
				    "shininess='" 		 + bioMightPolygon.getMaterial().getShininess() + "'\n" +
				    "transparency='" 	 + bioMightPolygon.getMaterial().getTransparency() + "'\n" +
				    "diffuseColor='" + 
				    bioMightPolygon.getMaterial().getDiffuseColor().getRed() + " " + 
				    bioMightPolygon.getMaterial().getDiffuseColor().getGreen() + " " +
				    bioMightPolygon.getMaterial().getDiffuseColor().getBlue() + "'/>\n" +
				 	"</Appearance>\n" +			    
				 	"<IndexedFaceSet DEF='RightKidneyPolygon' \n" +
				    	   "containerField='geometry' \n" +
				    	   "creaseAngle='" +  bioMightPolygon.getCreaseAngle() + "'\n" +
				    	   "coordIndex='" + bioMightPolygon.getCoordindexStr() + "'>" +
				    	   "<Coordinate DEF='Box1_Coord' \n" +
				    	    "containerField='coord' point='" +  bioMightPolygon.getCoordpointStr() + "'/>" +
				    	  "</IndexedFaceSet>\n" +
				 	"</Shape>\n" +
				 "</Transform>\n"; 
			}
			
			}
			
			System.out.println("RightKidney X3D: " + body);		
			String footer = "</Scene>" + "</X3D>\n";
			
			if (snipet)
				return body;			
			else	
				return header + body + footer;
		}
		
}
