/*
 * Created on May 8, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.body.head.ear;
import java.util.ArrayList;

import biomight.BioMightBase;
import biomight.Constants;
import biomight.system.cartilage.Cartilage;
import biomight.system.tissue.epithelial.EpitheliumTissue;
import biomight.view.BioMightColor;
import biomight.view.BioMightMethodView;
import biomight.view.BioMightPolygon;
import biomight.view.BioMightPolygons;
import biomight.view.BioMightPosition;
import biomight.view.BioMightPositions;
import biomight.view.BioMightPropertyView;
import biomight.view.BioMightSphere;

/**
 * @author SurferJim
 *
 * Representation of the RightPinnaAntiHelix.  Comprised of cartilage
 * 
 */

public class RightPinnaAntiHelix  extends BioMightBase {
	private ArrayList<BioMightPropertyView> properties;
	private ArrayList<BioMightMethodView> methods;
	private BioMightPolygons bioMightPolygons;
	
	// Set up a block of Cartilage that comprises the AntiHelix
	//Cartilage[][][] cartilage;
	
	// Hold the DNA Sequence that describes how to Build the AnitHelix
	private String dnaSequence; 
	
	public RightPinnaAntiHelix()
	{		
		this.setImage("images/RightPinnaAntiHelix.jpg");
		//cartilage = new Cartilage(dnaSequence);
		initProperties();
		initMethods();
	}

	/****
	 * 
	 * This position is delivered from the Auricle and will be a displacement from its center point
	 * @param bioMightPosition
	 */
	
	public RightPinnaAntiHelix(BioMightPosition bioMightPosition)
	{		
		this.setImage("images/RightPinnaAntiHelix.jpg");
		
		// Create a colony of Cartilage and arrange them
		// based upon the DNA sequence.  
		//cartilage = new Cartilage(dnaSequence);
		
		System.out.println("Creating the Pinna AnitHelix at Position: " + bioMightPosition.getXPos());
		init3D(bioMightPosition);
		initProperties();
		initMethods();
	}

	public void redraw(BioMightPosition bioMightPosition)
	{				
		System.out.println("Right Pinna AnitHelix Redraw");
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
	

	public void init3D(BioMightPosition position) {
		
		// Create a group of polygons to represent the nose
		bioMightPolygons = new BioMightPolygons();


		for (int alpha=0; alpha<1; alpha++)
		{	
			// Allocate the Coordinate-Point Array for Polygon 
			BioMightPositions coordpoint = new BioMightPositions();
			
			String coordinateString = "";
			String translationString = "";
			String rotationString = "";
			
			// Left AntiHelix
			if (alpha==0)
			{	
				//translationString = "3.29639 8.97793 1.08734";
				//rotationString = ".411 -.905 .108 .568";
				coordinateString = 				
					"4.0, 0.0, -2.0," +
					"4.25,  0.0, -2.0, " +
					"4.25, -2.5, -2.0," +
					"4.0, -2.5, -2.0";
			}

			String[] coords = coordinateString.split(",", 24);
			System.out.println("After Split: " + coords); 
			
			// Store the Coordinate Points in BioMightPosition objects
			int j=0;
			for (int i=0;i<=11;i+=3)
			{
				BioMightPosition vertex = new BioMightPosition();
				
				vertex.setXPos(Double.valueOf(coords[i]));
				vertex.setYPos(Double.valueOf(coords[i+1]));
				vertex.setZPos(Double.valueOf(coords[i+2]));
				//System.out.println("Storing Coordinates: " + j +    "  x: " + coords[i] + " y: " + coords[i+1] + " z: " + coords[i+2]);	
				coordpoint.setBioMightPosition(j++, vertex);
			}

			// Store the lower plane
			for (int i=0;i<=11;i+=3)
			{
				BioMightPosition vertex = new BioMightPosition();
				
				vertex.setXPos(Double.valueOf(coords[i]));
				vertex.setYPos(Double.valueOf(coords[i+1]));
				vertex.setZPos(Double.valueOf(coords[i+2])-0.125);
				//System.out.println("Storing Coordinates: " + j +    "  x: " + coords[i] + " y: " + coords[i+1] + " z: " + coords[i+2]);	
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
			System.out.println("Created RightPinnaAntiHelix Polygon");		
			
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
				System.out.println("Init3D - Set RightPinnaAntiHelix TranslationX: " + position.getXPos());
				//System.out.println("Init3D - Set EpitheliumTissue TranslationY: " + position.getYPos());
			    //System.out.println("Init3D - Set EpitheliumTissue TranslationZ: " + position.getZPos());
			}
			else
				System.out.println("RightPinnaAntiHelix Polygon - init3d - position is null!");
			
			// Set up the scale
			bioMightPolygon.getScale().setXPos(1);
			bioMightPolygon.getScale().setYPos(1);
			bioMightPolygon.getScale().setZPos(1);
			System.out.println("Init3D - Set RightPinnaAntiHelix Scale...");
			
			
			// Set up the material information 
			bioMightPolygon.getMaterial().setAmbientIntensity(0.200);
			bioMightPolygon.getMaterial().setShininess(0.100);
			bioMightPolygon.getMaterial().setTransparency(0.0);
			System.out.println("Init3D - Set RightPinnaAntiHelix Transparency...");
			
			// Set up the color of the material
			bioMightColor = new BioMightColor();
			bioMightColor.setRed(1.0);
			bioMightColor.setBlue(0.4);
			bioMightColor.setGreen(0.65);
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
			System.out.println("Init3D - Set RightPinnaAntiHelix EpitheliumTissue Color...");

			
			System.out.println("Adding Polygon...");
			bioMightPolygons.setbioMightPolygon(alpha, bioMightPolygon);
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
		
		// Assemble the RightPinnaAntiHelix
		String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
		"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n " +
		"<X3D profile='Immersive' >\n" +
		"<head>\n" +
		 "<meta name='BioMightImage' content='RightPinnaAntiHelix.jpg'/>\n" +
		 "<meta name='ExportTime' content='7:45:30'/>\n" +
		 "<meta name='ExportDate' content='08/15/2008'/>\n" +
		 "<meta name='BioMight Version' content='1.0'/>\n" + 
		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='RightPinnaAntiHelix'\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		

		String body = "";
		int view = Constants.VIEW_DETACHED;
		if (view == Constants.VIEW_DETACHED)
		{				

			for (int alpha=0; alpha<1; alpha++)
			{	
				BioMightPolygon bioMightPolygon = bioMightPolygons.getbioMightPolygon(alpha);
				System.out.println("Getting X3D PolyGon: " + alpha);
				
				System.out.println("Getting X3D for RightPinnaAntiHelixX: " + bioMightPolygon.getTranslation().getXPos());
				System.out.println("Getting X3D for RightPinnaAntiHelixY: " + bioMightPolygon.getTranslation().getYPos());
				System.out.println("Getting X3D for RightPinnaAntiHelixZ: " + bioMightPolygon.getTranslation().getZPos());
				// Change the height and width based on the displacement.
			
			body += "<Transform DEF='RightPinnaAntiHelix'\n" +
		 		"translation='" + bioMightPolygon.getTranslation().getXPos() + " " 
			 					+ bioMightPolygon.getTranslation().getYPos() + " "
			 					+ bioMightPolygon.getTranslation().getZPos() + "'\n" +
			 	"scale='" 	+ bioMightPolygon.getScale().getXPos() + " "
			 				+ bioMightPolygon.getScale().getYPos() + " "
			 				+ bioMightPolygon.getScale().getZPos() + "'>\n" +
			 	"<Shape DEF='RightPinnaAntiHelix'\n" +
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
			 	"<IndexedFaceSet DEF='RightPinnaAntiHelixPolygon' \n" +
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
		
		System.out.println("RightPinnaAntiHelix X3D: " + body);		
		String footer = "</Scene>" + "</X3D>\n";
		
		if (snipet)
			return body;			
		else	
			return header + body + footer;
	}
	
}
