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
	public class LeftKidney extends Kidney {
		private BioMightPolygons bioMightPolygons;
		private ArrayList<BioMightPropertyView> properties;
		private ArrayList<BioMightMethodView> methods;
		
		
		public LeftKidney()
		{
			this.setImage("images/LeftKidney.jpg");
			this.setImageHeight(300);
			this.setImageWidth(300);
			initProperties();
			initMethods();
		}

		
		public LeftKidney(BioMightPosition bioMightPosition)
		{
			this.setImage("images/LeftKidney.jpg");
			this.setImageHeight(300);
			this.setImageWidth(300);
			initProperties();
			initMethods();
			
			System.out.println("Creating the LeftKidney at Position: " + bioMightPosition.getXPos());
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
		/* -5.5, -20.0, -4.5, -2.5, -20.0, -4.5, -2.5, -24.0, -4.5, -5.5, -24.0, -4.5 */
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
			"title='LeftKidney'\n" +
			"info='\"BioMight Generated X3D\"'/>\n";		

			String body = "";
			int view = Constants.VIEW_DETACHED;
			if (view == Constants.VIEW_DETACHED)
			{				

				for (int alpha=0; alpha<1; alpha++)
				{	
					BioMightPolygon bioMightPolygon = bioMightPolygons.getbioMightPolygon(alpha);
					System.out.println("Getting X3D PolyGon: " + alpha);
					
					System.out.println("Getting X3D for LeftKidneyX: " + bioMightPolygon.getTranslation().getXPos());
					System.out.println("Getting X3D for LeftKidneyY: " + bioMightPolygon.getTranslation().getYPos());
					System.out.println("Getting X3D for LeftKidneyZ: " + bioMightPolygon.getTranslation().getZPos());
					// Change the height and width based on the displacement.
				
				body += "<Transform DEF='LeftKidney'\n" +
			 		"translation='" + bioMightPolygon.getTranslation().getXPos() + " " 
				 					+ bioMightPolygon.getTranslation().getYPos() + " "
				 					+ bioMightPolygon.getTranslation().getZPos() + "'\n" +
				 	"scale='" 	+ bioMightPolygon.getScale().getXPos() + " "
				 				+ bioMightPolygon.getScale().getYPos() + " "
				 				+ bioMightPolygon.getScale().getZPos() + "'>\n" +
				 	"<Shape DEF='LeftKidney'\n" +
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
				 	"<IndexedFaceSet DEF='LeftKidneyPolygon' \n" +
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
			
			System.out.println("LeftKidney X3D: " + body);		
			String footer = "</Scene>" + "</X3D>\n";
			
			if (snipet)
				return body;			
			else	
				return header + body + footer;
		}


}
