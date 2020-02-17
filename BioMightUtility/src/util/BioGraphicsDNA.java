package biomight.util;

import biomight.Constants;
import biomight.view.BioMightTransform;


/***************************************************************
 * BIO GRAPHICS
 * Routines for 
 * 
 * @param point1
 * @param point2
 * @return
 ***************************************************************/


public class BioGraphicsDNA {

	
	/*************************************************************************
	 *  GET RIBOSE
	 *  
	 *  Creates a Representation of Ribose molecule
	 *  
	 ************************************************************************/ 		

	public static String getRibose(BioMightTransform bioMightTransform, double radius, double angle)  
	{
		
		String body = "";
		
		double x = bioMightTransform.getTranslation().getXPos();
		double y = bioMightTransform.getTranslation().getYPos();
		double z = bioMightTransform.getTranslation().getZPos();
		System.out.println("getRibose()    x:" + x + " y: "   + y + "  z:" + z);			

		double xScale = 1.0;
		double yScale = 1.0;
		double zScale = 1.0;

		
		// Make a 5 pointed ribose sugar molecule
		double[] startPos = {0.0, 0.0, 0.0};
		double[] displaceAngle = {0.15, 0.50, 90.0, 130.0, 180.0};
		String riboseElements[] = {"Carbon", "Carbon", "Oygen", "Carbon", "Carbon"};
		double[][] ribosePoints = BioGraphics.createCylinderInPlane(Constants.YPLANE,  startPos,  radius, displaceAngle);
				
 
		if (angle > 0.0)
		{
			System.out.println("Rotating Nucleotide: " + angle);			
			ribosePoints = BioGraphics.rotateY(ribosePoints, angle);
			//System.out.println("Rotated Nucleotide: " + angle);			
		}
		
		// Create the Ribose X3D
		for (int i=0; i<riboseElements.length; i++)
		{
			//System.out.println("Creating X3D for : " + riboseElements[i]);				
			
			// Change the height and width based on the displacement.
			body += "\n<Transform DEF='" + riboseElements[i] + "'\n";
					
		 	body += "translation='" 
		 		 	+ ribosePoints[i][0] + " " 
		 		 	+ ribosePoints[i][1] + " "
					+ ribosePoints[i][2]+ "'\n";					
			
			body +=  "scale='" 	+ xScale + " "
			 					+ yScale + " "
			 					+ zScale + "'>\n" +

			 "\n<Shape DEF='" + riboseElements[i] + "Shape'\n" +
			    " containerField='children'>\n" +
			    " <Appearance\n" +
			    "  containerField='appearance'>\n";

		
			body+= " <ImageTexture containerField='texture' " +
			    " url='../images/" + riboseElements[i] + ".jpg'/>";
				
			    
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
			 	"<Sphere DEF='" + riboseElements[i] + "Sphere'\n" +
			 	"containerField='geometry'\n" +
			 	"radius='" + bioMightTransform.getRadius() +"'/>\n" +
			 	"</Shape>\n" +
			 	
				"\n<TouchSensor DEF='"+riboseElements[i]+"Touch' \n" +
                   " description='"+riboseElements[i]+"'\n" +
	               " containerField='children'/> \n" +

			 "</Transform>\n";
					
			//System.out.println("Nuceotides - Set Transform: ");				
		}

		return(body);
	}


	/*************************************************************************
	 *  GET DE-OXY-RIBOSE
	 *  
	 *  Creates a Representation of Ribose molecule
	 *  
	 ************************************************************************/ 		

	public static String getDeOxyRibose(BioMightTransform bioMightTransform, double radius, double angle)  
	{
		
		String body = "";
		
		double x = bioMightTransform.getTranslation().getXPos();
		double y = bioMightTransform.getTranslation().getYPos();
		double z = bioMightTransform.getTranslation().getZPos();
		System.out.println("getDeOxyRibose()    x:" + x + " y: "   + y + "  z:" + z);			

		double xScale = 1.0;
		double yScale = 1.0;
		double zScale = 1.0;

		
		
		// Make a 5 pointed ribose sugar molecule
		double[] startPos = {0.0, 0.0, 0.0};
		double[] displaceAngle = {0.30, 0.60, 90.0, 120.0, 150.0};
		String riboseElements[] = {"Carbon", "Carbon", "Oygen", "Carbon", "Carbon"};
		double[][] ribosePoints = BioGraphics.createCylinderInPlane(Constants.YPLANE,  startPos,  radius, displaceAngle);



		if (angle > 0.0)
		{
			System.out.println("Rotating Nucleotide: " + angle);			
			ribosePoints = BioGraphics.rotateY(ribosePoints, angle);
			//System.out.println("Rotated Nucleotide: " + angle);			
		}
		
		// Create the Ribose X3D
		for (int i=0; i<riboseElements.length; i++)
		{
			System.out.println("Creating X3D for : " + riboseElements[i]);				
			
			// Change the height and width based on the displacement.
			body += "\n<Transform DEF='" + riboseElements[i] + "'\n";
					
		 	body += "translation='" 
		 		 	+ ribosePoints[i][0] + " " 
		 		 	+ ribosePoints[i][1] + " "
					+ ribosePoints[i][2]+ "'\n";					
			
			body +=  "scale='" 	+ xScale + " "
			 					+ yScale + " "
			 					+ zScale + "'>\n" +

			 "\n<Shape DEF='" + riboseElements[i] + "Shape'\n" +
			    " containerField='children'>\n" +
			    " <Appearance\n" +
			    "  containerField='appearance'>\n";

		
			body+= " <ImageTexture containerField='texture' " +
			    " url='../images/" + riboseElements[i] + ".jpg'/>";
				
			    
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
			 	"<Sphere DEF='" + riboseElements[i] + "Sphere'\n" +
			 	"containerField='geometry'\n" +
			 	"radius='" + bioMightTransform.getRadius() +"'/>\n" +
			 	"</Shape>\n" +
			 	
				"\n<TouchSensor DEF='"+riboseElements[i]+"Touch' \n" +
                   " description='"+riboseElements[i]+"'\n" +
	               " containerField='children'/> \n" +

			 "</Transform>\n";
					
			//System.out.println("DeOxyRibose - Set Transform: ");				
		}
		
		
		/*
		
		// Add the Activators and Stabilizers
		String riboseActivators[] = {
					"Hydrogen",    
					"Oxygen", "Hydrogen",	
					
					"Oxygen", "Hydrogen",	 
					"Hydrogen",   
					//
					"Hydrogen", "Oygen", "Carbon", "Hydrogen", "Hydrogen",
					"Hydrogen", 
					
					"Hydrogen", 
					"Oxygen", "Hydrogen"};
		double[][] riboseActivatorPoints = {
				 {x-radius,             	y+(1.5*radius), 						 z+(1.5*radius)},
				 
				 {x-radius,             	y, 						 z},
				 
 				 {x+radius,             	y, 	    	z},
 				 {x+(radius * 1.5), 		y,  		z+radius},
 				 {x, 							y, 		z+(radius * 1.5)},
 				 {x-(radius * 1.5), 		y, 			z+radius}	
  		};


		if (angle > 0.0)
		{
			//System.out.println("Rotating Nucleotide: " + angle);			
			ribosePoints = BioGraphics.rotateY(riboseActivatorPoints, angle);
			//System.out.println("Rotated Nucleotide: " + angle);			
		}
		
		// Create the Ribose X3D
		for (int i=0; i<1; i++)
		//for (int i=0; i<riboseActivators.length; i++)
		{
			//System.out.println("Creating X3D for : " + riboseElements[i]);				
			
			// Change the height and width based on the displacement.
			body += "\n<Transform DEF='" + riboseActivators[i] + "'\n";
					
		 	body += "translation='" 
		 		 	+ riboseActivatorPoints[i][0] + " " 
		 		 	+ riboseActivatorPoints[i][1] + " "
					+ riboseActivatorPoints[i][2]+ "'\n";					
			
			body +=  "scale='" 	+ xScale + " "
			 					+ yScale + " "
			 					+ zScale + "'>\n" +

			 "\n<Shape DEF='" + riboseActivators[i] + "Shape'\n" +
			    " containerField='children'>\n" +
			    " <Appearance\n" +
			    "  containerField='appearance'>\n";

		
			body+= " <ImageTexture containerField='texture' " +
			    " url='../images/" + riboseActivators[i] + ".jpg'/>";
				
			    
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
			 	"<Sphere DEF='" + riboseActivators[i] + "Sphere'\n" +
			 	"containerField='geometry'\n" +
			 	"radius='" + bioMightTransform.getRadius() +"'/>\n" +
			 	"</Shape>\n" +
			 	
				"\n<TouchSensor DEF='"+riboseActivators[i]+"Touch' \n" +
                   " description='"+riboseActivators[i]+"'\n" +
	               " containerField='children'/> \n" +

			 "</Transform>\n";
					
			//System.out.println("DeOxyRibose - Set Transform: ");				
		}
		*/

		return(body);
	}


	
	/*************************************************************************
	 *  GET PHOSPHATE
	 *  
	 *  Creates a Representation of Phosphate
	 *  
	 ************************************************************************/ 		

	public static String getPhosphate(BioMightTransform bioMightTransform, double circumference, double angle)  
	{
		
		String body = "";
		
		double x = bioMightTransform.getTranslation().getXPos();
		double y = bioMightTransform.getTranslation().getYPos();
		double z = bioMightTransform.getTranslation().getZPos();
		System.out.println("getPhosphate()    x:" + x + " y: "   + y + "  z:" + z);			

		double xScale = 1.0;
		double yScale = 1.0;
		double zScale = 1.0;

				
		// Make a cross-shaped phosphate backbone
		// Align to the Sugar Stabilizer
		String phosphateElements[] = {"Phosphorous", "Oxygen", "Oygen", "Oxygen", "Oygen"};
		x = x - circumference * 3;
		z = z + circumference * 3; 
		double[][] phosphatePoints = {
				 {x,             				y, 							z},
 				 {x-circumference,             	y, 							z},
 				 {x,					 		y,  		  z+circumference},
 				 {x+circumference, 				y, 							z},
 				 {x, 							y, 			  z-circumference}	
  		};

		if (angle > 0.0)
		{
			System.out.println("Rotating Nucleotide: " + angle);			
			phosphatePoints = BioGraphics.rotateY(phosphatePoints, angle);
			System.out.println("Rotated Nucleotide: " + angle);			
		}
		
		// Create the Phosphate X3D
		for (int i=0; i<phosphateElements.length; i++)
		{
			//System.out.println("Creating X3D for : " + phosphateElements[i]);				
			
			// Change the height and width based on the displacement.
			body += "\n<Transform DEF='" + phosphateElements[i] + "'\n";
					
		 	body += "translation='" 
		 		 	+ phosphatePoints[i][0] + " " 
		 		 	+ phosphatePoints[i][1] + " "
					+ phosphatePoints[i][2]+ "'\n";					
			
			body +=  "scale='" 	+ xScale + " "
			 					+ yScale + " "
			 					+ zScale + "'>\n" +

			 "\n<Shape DEF='" + phosphateElements[i] + "Shape'\n" +
			    " containerField='children'>\n" +
			    " <Appearance\n" +
			    "  containerField='appearance'>\n";

		
			body+= " <ImageTexture containerField='texture' " +
			    " url='../images/" + phosphateElements[i] + ".jpg'/>";
				
			    
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
			 	"<Sphere DEF='" + phosphateElements[i] + "Sphere'\n" +
			 	"containerField='geometry'\n" +
			 	"radius='" + bioMightTransform.getRadius() +"'/>\n" +
			 	"</Shape>\n" +
			 	
				"\n<TouchSensor DEF='"+phosphateElements[i]+"Touch' \n" +
                   " description='"+phosphateElements[i]+"'\n" +
	               " containerField='children'/> \n" +

			 "</Transform>\n";
			
			//System.out.println("Nuceotides - Set Transform: ");				
		}

		
		return(body);
	}

	/*************************************************************************
	 *  GET NITROBASE
	 *  
	 *  Creates a Representation of Nitrobase
	 *  
	 ************************************************************************/ 		

	public static String getNucleobase(BioMightTransform bioMightTransform, double circumference, double angle)  
	{
		
		String body = "";
		
		double x = bioMightTransform.getTranslation().getXPos();
		double y = bioMightTransform.getTranslation().getYPos();
		double z = bioMightTransform.getTranslation().getZPos();
		System.out.println("getNitroBase()    x:" + x + " y: "   + y + "  z:" + z);			

		double xScale = 1.0;
		double yScale = 1.0;
		double zScale = 1.0;

				
		// Make a Nitrogeneous Base	- Pentose
		// Align to the Sugar Stabilizer
		String nbElements[] = {"Nitrogen", "Nitrogen", "Nitrogen", "Nitrogen", "Hydrogen"};
		x = x + circumference * 3;
		z = z + circumference * 3; 
		double[][] nbPoints = {
				 {x,             			y, 							z},
 				 {x+circumference,          y, 	  z+(circumference * 1.5)},
 				 {x+circumference*2,	 	y,  		  z+circumference},
 				 {x+circumference*2, 		y, 			  z-circumference},
 				 {x+circumference, 			y, 	   z-(circumference * 1.5)}	
  		};
		
		if (angle > 0.0)
		{
			System.out.println("Rotating Nucleotide: " + angle);			
			nbPoints = BioGraphics.rotateY(nbPoints, angle);
			System.out.println("Rotated Nucleotide: " + angle);			
		}		
		
		// Create the Nitrogeneous Base	 X3D
		for (int i=0; i<nbElements.length; i++)
		{
			//System.out.println("Creating X3D for : " + phosphateElements[i]);				
			
			// Change the height and width based on the displacement.
			body += "\n<Transform DEF='" + nbElements[i] + "'\n";
					
		 	body += "translation='" 
		 		 	+ nbPoints[i][0] + " " 
		 		 	+ nbPoints[i][1] + " "
					+ nbPoints[i][2]+ "'\n";					
			
			//System.out.println("Set Translation: ");				

			body +=  "scale='" 	+ xScale + " "
			 					+ yScale + " "
			 					+ zScale + "'>\n" +

			 "\n<Shape DEF='" + nbElements[i] + "Shape'\n" +
			    " containerField='children'>\n" +
			    " <Appearance\n" +
			    "  containerField='appearance'>\n";

		
			body+= " <ImageTexture containerField='texture' " +

			" url='../images/" + nbElements[i] + ".jpg'/>";
				
			    
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
			 	"<Sphere DEF='" + nbElements[i] + "Sphere'\n" +
			 	"containerField='geometry'\n" +
			 	"radius='" + bioMightTransform.getRadius() +"'/>\n" +
			 	"</Shape>\n" +
			 	
				"\n<TouchSensor DEF='"+nbElements[i]+"Touch' \n" +
                   " description='"+nbElements[i]+"'\n" +
	               " containerField='children'/> \n" +

			 "</Transform>\n";
			
			//System.out.println("Nuceotides - Set Transform: ");				
		}
	
		
		return(body);
	}
	
	
	/*************************************************************************
	 *  GET HEXOS
	 *  
	 *  Creates a Representation of Hexose
	 *  
	 ************************************************************************/ 		

	public static String getHexose(BioMightTransform bioMightTransform, double circumference, double angle)  
	{
		
		String body = "";
		
		double x = bioMightTransform.getTranslation().getXPos();
		double y = bioMightTransform.getTranslation().getYPos();
		double z = bioMightTransform.getTranslation().getZPos();
		System.out.println("getNitroBase()    x:" + x + " y: "   + y + "  z:" + z);			

		double xScale = 1.0;
		double yScale = 1.0;
		double zScale = 1.0;

				
		// Make a Nitrogeneous Base	- Hexose
		// Align to the Pentanomer Nitrogen 
		String nbHElements[] = {"Nitrogen", "Nitrogen", "Nitrogen", "Nitrogen", "Hydrogen"};
		x = x + circumference * 2;
		z = z + circumference; 
		double[][] nbHPoints = {
				 {x,             			y, 							z},
 				 {x+circumference,          y,		 	z+(circumference)},
 				 {x+circumference*2,	 	y,				  			z},
 				 {x+circumference*2, 		y, 			  z-circumference},
 				 {x+circumference,	 		y, 			z-circumference*2},
 				 {x,			 			y,		 	z-(circumference)}	
  		};

		if (angle > 0.0)
		{
			System.out.println("Rotating Nucleotide: " + angle);			
			nbHPoints = BioGraphics.rotateY(nbHPoints, angle);
			System.out.println("Rotated Nucleotide: " + angle);			
		}
		
		// Create the Nitrogeneous Base	 X3D
		for (int i=0; i<nbHElements.length; i++)
		{
			//System.out.println("Creating X3D for : " + phosphateElements[i]);				
			
			// Change the height and width based on the displacement.
			body += "\n<Transform DEF='" + nbHElements[i] + "'\n";
					
		 	body += "translation='" 
		 		 	+ nbHPoints[i][0] + " " 
		 		 	+ nbHPoints[i][1] + " "
					+ nbHPoints[i][2]+ "'\n";					
			
			System.out.println("Set Translation: ");				

			body +=  "scale='" 	+ xScale + " "
			 					+ yScale + " "
			 					+ zScale + "'>\n" +

			 "\n<Shape DEF='" + nbHElements[i] + "Shape'\n" +
			    " containerField='children'>\n" +
			    " <Appearance\n" +
			    "  containerField='appearance'>\n";

		
			body+= " <ImageTexture containerField='texture' " +

			" url='../images/" + nbHElements[i] + ".jpg'/>";
				
			    
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
			 	"<Sphere DEF='" + nbHElements[i] + "Sphere'\n" +
			 	"containerField='geometry'\n" +
			 	"radius='" + bioMightTransform.getRadius() +"'/>\n" +
			 	"</Shape>\n" +
			 	
				"\n<TouchSensor DEF='"+nbHElements[i]+"Touch' \n" +
                   " description='"+nbHElements[i]+"'\n" +
	               " containerField='children'/> \n" +

			 "</Transform>\n";
			
			//System.out.println("Nuceotides - Set Transform: ");				
		}	
		
		return(body);
	}	
	
	
	
}