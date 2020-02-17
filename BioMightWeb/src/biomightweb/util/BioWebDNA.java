package biomightweb.util;

import java.util.Stack;

import biomight.Constants;
import biomight.util.BioGraphics;
import biomight.view.BioMightTransform;


/***************************************************************
 * BIO GRAPHICS
 * Routines for 
 * 
 * @param point1
 * @param point2
 * @return
 ***************************************************************/


public class BioWebDNA {

	
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
		//System.out.println("getDeOxyRibose()    x:" + x + " y: "   + y + "  z:" + z);			
		System.out.println("getDeOxyRibose() at rotated angle: " + angle + "  with radius: " + radius);	
		
		double xScale = 1.0;
		double yScale = 1.0;
		double zScale = 1.0;

		// Make a 5 point ribose sugar molecule
		double[] startPos = {x, y, z};
		double radiansAngle = Math.toRadians(angle);
		String riboseElements[] = {"Carbon", "Carbon", "Oxygen", "Carbon", "Carbon"};	
		double[][] ribosePoints = BioGraphics.createCylinderInPlane(Constants.YPLANE,  startPos,  0.25, riboseElements.length, radiansAngle);
		//BioGraphics.dumpPoints("ribosePoints", ribosePoints);

		
		// Create the Ribose X3D
		for (int i=0; i<riboseElements.length; i++)
		{
			System.out.println("Creating X3D for : " + riboseElements[i]);				
			
			double atomRadius = getAtomicRadius(riboseElements[i]);
			System.out.println("Atom Radius Size : " + atomRadius);	
			
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
			 	"radius='" + atomRadius +"'/>\n" +
			 	"</Shape>\n" +
			 	
				"\n<TouchSensor DEF='"+riboseElements[i]+"Touch' \n" +
                   " description='"+riboseElements[i]+"'\n" +
	               " containerField='children'/> \n" +

			 "</Transform>\n";
					
			//System.out.println("DeOxyRibose - Set Transform: ");				
		}
		
		// Add the Activators and Stabilizers for the Pentose
		String coAtomList[] = 
		{
			
			"(H) (H)",	
			
			"(H)",   
			
			 // There is nada on the Oxygen molecule
			 "",
			 
			"((H O) (H C H)) (H)", 
			
			"(H) (O H)"
		};

		body+=getCoAtoms(bioMightTransform, ribosePoints, riboseElements, coAtomList); 

		return(body);
	}


	/*************************************************************************
	 *  GET DEOXYRIBOSE
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
		//System.out.println("getDeOxyRibose()    x:" + x + " y: "   + y + "  z:" + z);			
		System.out.println("getDeOxyRibose() at rotated angle: " + angle + "  with radius: " + radius);	
		
		double xScale = 1.0;
		double yScale = 1.0;
		double zScale = 1.0;

		// Make a 5 point ribose sugar molecule
		double[] startPos = {x, y, z};
		double radiansAngle = Math.toRadians(angle);
		String riboseElements[] = {"Carbon", "Carbon", "Oxygen", "Carbon", "Carbon"};	
		double[][] ribosePoints = BioGraphics.createCylinderInPlane(Constants.YPLANE,  startPos,  0.25, riboseElements.length, radiansAngle);
		//BioGraphics.dumpPoints("ribosePoints", ribosePoints);

		
		// Create the Ribose X3D
		for (int i=0; i<riboseElements.length; i++)
		{
			System.out.println("Creating X3D for : " + riboseElements[i]);				
			
			double atomRadius = getAtomicRadius(riboseElements[i]);
			System.out.println("Atom Radius Size : " + atomRadius);	
			
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
			 	"radius='" + atomRadius +"'/>\n" +
			 	"</Shape>\n" +
			 	
				"\n<TouchSensor DEF='"+riboseElements[i]+"Touch' \n" +
                   " description='"+riboseElements[i]+"'\n" +
	               " containerField='children'/> \n" +

			 "</Transform>\n";
					
			//System.out.println("DeOxyRibose - Set Transform: ");				
		}
		
		// Add the Activators and Stabilizers for the Pentose
		String coAtomList[] = 
		{
			
			"(H) (H)",	
			
			"((H) (H O))",   
			
			 // There is nada on the Oxygen molecule
			 "",
			 
			"((H O) (H C H)) (H)", 
			
			"(H) (O H)"
		};

		body+=getCoAtoms(bioMightTransform, ribosePoints, riboseElements, coAtomList); 

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
		
		double[] startPos = {x, y, z};

		// Make a cross-shaped phosphate backbone
		// Align to the Sugar Stabilizer
		String oxygens[] = {"Oxygen", "Oxygen", "Oxygen", "Oxygen"};		
		double radiansAngle = Math.toRadians(angle);
		double[][] oxygensPoints = BioGraphics.createCylinderInPlane(Constants.YPLANE,  startPos,  0.25, oxygens.length, radiansAngle);
		//BioGraphics.dumpPoints("oxygensPoints", oxygensPoints);
		
		// Change the height and width based on the displacement.
		body += "\n<Transform DEF='" + "phosphateElem" + "'\n";
				
	 	body += "translation='" 
	 		 	+ startPos[0] + " " 
	 		 	+ startPos[1] + " "
				+ startPos[2] + "'\n";					
		
		body +=  "scale='" 	+ xScale + " "
		 					+ yScale + " "
		 					+ zScale + "'>\n" +

		 "\n<Shape DEF='" + "Phosphorous" + "Shape'\n" +
		    " containerField='children'>\n" +
		    " <Appearance\n" +
		    "  containerField='appearance'>\n";

	
		body+= " <ImageTexture containerField='texture' " +
				" url='../images/" + "Phosphorus.png'/>";
			
		    
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
		 	"<Sphere DEF='" + "Phosphorus" + "Sphere'\n" +
		 	"containerField='geometry'\n" +
		 	"radius='" + getAtomicRadius("P") +"'/>\n" +
		 	"</Shape>\n" +
		 	
			"\n<TouchSensor DEF='"+"Phosphorus"+"Touch' \n" +
               " description='"+"Phosphorus"+"'\n" +
               " containerField='children'/> \n" +

		 "</Transform>\n";

		
		// Create the Phosphate X3D
		for (int i=0; i<oxygens.length; i++)
		{
			System.out.println("Creating X3D for : " + oxygens[i]);				
			
			// Change the height and width based on the displacement.
			body += "\n<Transform DEF='" + oxygens[i] + "'\n";
					
		 	body += "translation='" 
		 		 	+ oxygensPoints[i][0] + " " 
		 		 	+ oxygensPoints[i][1] + " "
					+ oxygensPoints[i][2]+ "'\n";					
			
			body +=  "scale='" 	+ xScale + " "
			 					+ yScale + " "
			 					+ zScale + "'>\n" +

			 "\n<Shape DEF='" + oxygens[i] + "Shape'\n" +
			    " containerField='children'>\n" +
			    " <Appearance\n" +
			    "  containerField='appearance'>\n";

		
			body+= " <ImageTexture containerField='texture' " +
			    " url='../images/" + "Oxygen" + ".jpg'/>";
				
			    
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
			 	"<Sphere DEF='" + oxygens[i] + "Sphere'\n" +
			 	"containerField='geometry'\n" +
			 	"radius='" + getAtomicRadius(oxygens[i]) +"'/>\n" +
			 	"</Shape>\n" +
			 	
				"\n<TouchSensor DEF='"+oxygens[i]+"Touch' \n" +
                   " description='"+oxygens[i]+"'\n" +
	               " containerField='children'/> \n" +

			 "</Transform>\n";
			
			//System.out.println("Nuceotides - Set Transform: ");				
		}
		
		
		// Add the Activators and Stabilizers for the Pentose
		String coAtomList[] = 
		{
			
			"",	
			
			"",   
			
			"(H)",
			
			""
		};
		
		body+=getCoAtoms(bioMightTransform, oxygensPoints, oxygens, coAtomList); 
		

		
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
		System.out.println("getNucleobase()    x:" + x + " y: "   + y + "  z:" + z);			

		double xScale = 1.0;
		double yScale = 1.0;
		double zScale = 1.0;

				
		// Make a Nitrogeneous Base	- Pentose
		// Align to the Sugar Stabilizer
		

		double[] startPos = {x+0.40, y+0.11, z-0.25};
		String nitrogenElements[] = {"Carbon", "Carbon", "Nitrogen", "Carbon", "Nitrogen"};
		//double[][] ribosePoints = BioGraphics.createCylinderInPlane(Constants.YPLANE,  startPos,  1.0, displaceAngle);
		double[][] nitrogenPoints = BioGraphics.createCylinderInPlane(Constants.YPLANE,  startPos,  0.25, nitrogenElements.length, -0.6);
		//BioGraphics.dumpPoints("nitrogenElements", nitrogenPoints);

		
		
		
		if (angle > 0.0)
		{
			System.out.println("Rotating Nucleotide: " + angle);			
			nitrogenPoints = BioGraphics.rotateY(nitrogenPoints, angle);
			System.out.println("Rotated Nucleotide: " + angle);			
		}		
		
		// Create the Nitrogeneous Base	 X3D
		for (int i=0; i<nitrogenElements.length; i++)
		{
			//System.out.println("Creating X3D for : " + phosphateElements[i]);				
			
			double atomRadius = getAtomicRadius(nitrogenElements[i]);
			System.out.println("Atom Radius Size : " + atomRadius);	
	
			// Change the height and width based on the displacement.
			body += "\n<Transform DEF='" + nitrogenElements[i] + "'\n";
					
		 	body += "translation='" 
		 		 	+ nitrogenPoints[i][0] + " " 
		 		 	+ nitrogenPoints[i][1] + " "
					+ nitrogenPoints[i][2]+ "'\n";					
			
			//System.out.println("Set Translation: ");				

			body +=  "scale='" 	+ xScale + " "
			 					+ yScale + " "
			 					+ zScale + "'>\n" +

			 "\n<Shape DEF='" + nitrogenElements[i] + "Shape'\n" +
			    " containerField='children'>\n" +
			    " <Appearance\n" +
			    "  containerField='appearance'>\n";

		
			body+= " <ImageTexture containerField='texture' " +

			" url='../images/" + nitrogenElements[i] + ".jpg'/>";
				
			    
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
			 	"<Sphere DEF='" + nitrogenElements[i] + "Sphere'\n" +
			 	"containerField='geometry'\n" +
			 	"radius='" + atomRadius +"'/>\n" +
			 	"</Shape>\n" +
			 	
				"\n<TouchSensor DEF='"+nitrogenElements[i]+"Touch' \n" +
                   " description='"+nitrogenElements[i]+"'\n" +
	               " containerField='children'/> \n" +

			 "</Transform>\n";
			
			//System.out.println("Nuceotides - Set Transform: ");				
		}
	
		
		return(body);
	}
	
	
	/*************************************************************************
	 *  GET ADENINE
	 *  
	 *  Creates a Representation of Adenine
	 *  
	 ************************************************************************/ 		

	public static String getAdenine(BioMightTransform bioMightTransform, double circumference, double angle)  
	{
		String body = "";
		
		double x = bioMightTransform.getTranslation().getXPos();
		double y = bioMightTransform.getTranslation().getYPos();
		double z = bioMightTransform.getTranslation().getZPos();
		System.out.println("getAdenine()    x: " + x + " y: "   + y + "  z:" + z);			

		double xScale = 1.0;
		double yScale = 1.0;
		double zScale = 1.0;

		double[] startPos = {x, y, z};
		double radiansAngle = Math.toRadians(angle);
		String ring1Elements[] = {"Carbon", "Carbon", "Nitrogen", "Carbon", "Nitrogen"};
		double[][] ring1Points = BioGraphics.createCylinderInPlane(Constants.YPLANE,  startPos,  0.25, ring1Elements.length, radiansAngle);
		//BioGraphics.dumpPoints("ring1Elements", ring1Points);

		
		// Create the Nitrogeneous Base
		for (int i=0; i<ring1Elements.length; i++)
		{
			//System.out.println("Creating X3D for : " + phosphateElements[i]);				
			
			double atomRadius = getAtomicRadius(ring1Elements[i]);
			System.out.println("Ring1 - Atom " + ring1Elements[i] + "  Radius Size : " + atomRadius);	
	
			// Change the height and width based on the displacement.
			body += "\n<Transform DEF='" + ring1Elements[i] + "'\n";
					
		 	body += "translation='" 
		 		 	+ ring1Points[i][0] + " " 
		 		 	+ ring1Points[i][1] + " "
					+ ring1Points[i][2]+ "'\n";					
			
			//System.out.println("Set Translation: ");				

			body +=  "scale='" 	+ xScale + " "
			 					+ yScale + " "
			 					+ zScale + "'>\n" +

			 "\n<Shape DEF='" + ring1Elements[i] + "Shape'\n" +
			    " containerField='children'>\n" +
			    " <Appearance\n" +
			    "  containerField='appearance'>\n";

		
			body+= " <ImageTexture containerField='texture' " +

			" url='../images/" + ring1Elements[i] + ".jpg'/>";
				
			    
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
			 	"<Sphere DEF='" + ring1Elements[i] + "Sphere'\n" +
			 	"containerField='geometry'\n" +
			 	"radius='" + atomRadius +"'/>\n" +
			 	"</Shape>\n" +
			 	
				"\n<TouchSensor DEF='"+ring1Elements[i]+"Touch' \n" +
                   " description='"+ring1Elements[i]+"'\n" +
	               " containerField='children'/> \n" +

			 "</Transform>\n";				
		}
		
		
		// Add the Bonding Atoms
		String coAtomList[] = 
		{
			
			"",	
			
			"",   
			
			"(H)",
			 
			"(H)", 
			
			""
		};

		
		body+=getCoAtoms(bioMightTransform, ring1Points, ring1Elements, coAtomList); 
		
		
		double ring2startPos[] = {x+0.32, y, z+0.23};
		String ring2Elements[] = {"Carbon", "Nitrogen", "", "", "Carbon", "Nitrogen"};
		
		angle+=60;
		radiansAngle = Math.toRadians(angle);
		double[][] ring2Points = BioGraphics.createCylinderInPlane(Constants.YPLANE,  ring2startPos,  0.25, ring2Elements.length, radiansAngle);
		BioGraphics.dumpPoints("ring2Points", ring2Points);

			
		// Create the Nitrogeneous Ring2 
		for (int i=0; i<ring2Points.length; i++)
		{
			System.out.println("Creating X3D for : " + ring2Points[i]);				
			
			if (!ring2Elements[i].equals(""))
			{
				double atomRadius = getAtomicRadius(ring2Elements[i]);
				System.out.println("Ring2 Atom Radius Size : " + atomRadius);	
		
				// Change the height and width based on the displacement.
				body += "\n<Transform DEF='" + ring2Elements[i] + "'\n";
						
			 	body += "translation='" 
			 		 	+ ring2Points[i][0] + " " 
			 		 	+ ring2Points[i][1] + " "
						+ ring2Points[i][2]+ "'\n";					
				
				//System.out.println("Set Translation: ");				
	
				body +=  "scale='" 	+ xScale + " "
				 					+ yScale + " "
				 					+ zScale + "'>\n" +
	
				 "\n<Shape DEF='" + ring2Points[i] + "Shape'\n" +
				    " containerField='children'>\n" +
				    " <Appearance\n" +
				    "  containerField='appearance'>\n";
	
			
				body+= " <ImageTexture containerField='texture' " +
				" url='../images/" + ring2Elements[i] + ".jpg'/>";	
				    
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
				 	"<Sphere DEF='" + ring2Elements[i] + "Sphere'\n" +
				 	"containerField='geometry'\n" +
				 	"radius='" + atomRadius +"'/>\n" +
				 	"</Shape>\n" +
				 	
					"\n<TouchSensor DEF='"+ring2Elements[i]+"Touch' \n" +
	                   " description='"+ring2Elements[i]+"'\n" +
		               " containerField='children'/> \n" +
	
				 "</Transform>\n";
				
				//System.out.println("Nuceotides - Set Transform: ");				
			}
		}
		
		// Add the Activators and Stabilizers for the Pentose
		String coAtomList2[] = 
		{
			
			"(H)",	
			
			"",   
			 
			"", 
			
			"", 
			
		    "(HNH)",
			 
			""
		};

		body+=getCoAtoms(bioMightTransform, ring2Points, ring2Elements, coAtomList2); 
		
		return(body);
	}
	
	
	
	
	/*************************************************************************
	 *  GET GUANINE
	 *  
	 *  Creates a Representation of Guanine
	 *  
	 ************************************************************************/ 		

	public static String getGuanine(BioMightTransform bioMightTransform, double circumference, double angle)  
	{
		String body = "";
		
		double x = bioMightTransform.getTranslation().getXPos();
		double y = bioMightTransform.getTranslation().getYPos();
		double z = bioMightTransform.getTranslation().getZPos();
		System.out.println("getGuanine()    x: " + x + " y: "   + y + "  z:" + z);			

		double xScale = 1.0;
		double yScale = 1.0;
		double zScale = 1.0;
		
		double[] startPos = {x, y, z};
		double radiansAngle = Math.toRadians(angle);	
		String ring1Elements[] = {"Carbon", "Carbon", "Nitrogen", "Carbon", "Nitrogen"};
		double[][] ring1Points = BioGraphics.createCylinderInPlane(Constants.YPLANE,  startPos,  0.25, ring1Elements.length, radiansAngle);
		//BioGraphics.dumpPoints("ring1Elements", ring1Points);

			
		// Create the Nitrogeneous Base
		for (int i=0; i<ring1Elements.length; i++)
		{
			//System.out.println("Creating X3D for : " + phosphateElements[i]);				
			
			double atomRadius = getAtomicRadius(ring1Elements[i]);
			System.out.println("Ring1 - Atom " + ring1Elements[i] + "  Radius Size : " + atomRadius);	
	
			// Change the height and width based on the displacement.
			body += "\n<Transform DEF='" + ring1Elements[i] + "'\n";
					
		 	body += "translation='" 
		 		 	+ ring1Points[i][0] + " " 
		 		 	+ ring1Points[i][1] + " "
					+ ring1Points[i][2]+ "'\n";					
			
			//System.out.println("Set Translation: ");				

			body +=  "scale='" 	+ xScale + " "
			 					+ yScale + " "
			 					+ zScale + "'>\n" +

			 "\n<Shape DEF='" + ring1Elements[i] + "Shape'\n" +
			    " containerField='children'>\n" +
			    " <Appearance\n" +
			    "  containerField='appearance'>\n";

		
			body+= " <ImageTexture containerField='texture' " +

			" url='../images/" + ring1Elements[i] + ".jpg'/>";
				
			    
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
			 	"<Sphere DEF='" + ring1Elements[i] + "Sphere'\n" +
			 	"containerField='geometry'\n" +
			 	"radius='" + atomRadius +"'/>\n" +
			 	"</Shape>\n" +
			 	
				"\n<TouchSensor DEF='"+ring1Elements[i]+"Touch' \n" +
                   " description='"+ring1Elements[i]+"'\n" +
	               " containerField='children'/> \n" +

			 "</Transform>\n";				
		}
		
		
		// Add the Bonding Atoms
		String coAtomList[] = 
		{
			
			"",	
			
			"",   
			
			"(H)",
			 
			"(H)", 
			
			""
		};
		
		body+=getCoAtoms(bioMightTransform, ring1Points, ring1Elements, coAtomList); 
			
		
		double ring2startPos[] = {x+0.34, y, z+0.235};
		String ring2Elements[] = {"Carbon", "Nitrogen", "", "", "Carbon", "Nitrogen"};
		
		angle+=62.5;
		radiansAngle = Math.toRadians(angle);
		double[][] ring2Points = BioGraphics.createCylinderInPlane(Constants.YPLANE,  ring2startPos,  0.25, ring2Elements.length, radiansAngle);
		//BioGraphics.dumpPoints("ring2Points", ring2Points);

		
		// Create the Nitrogeneous Ring2 
		for (int i=0; i<ring2Points.length; i++)
		{
			
			if (!ring2Elements[i].equals(""))
			{
				//System.out.println("Creating X3D for : " + phosphateElements[i]);				
				
				double atomRadius = getAtomicRadius(ring2Elements[i]);
				System.out.println("Ring2 Atom Radius Size : " + atomRadius);	
		
				// Change the height and width based on the displacement.
				body += "\n<Transform DEF='" + ring2Elements[i] + "'\n";
						
			 	body += "translation='" 
			 		 	+ ring2Points[i][0] + " " 
			 		 	+ ring2Points[i][1] + " "
						+ ring2Points[i][2]+ "'\n";					
				
				//System.out.println("Set Translation: ");				
	
				body +=  "scale='" 	+ xScale + " "
				 					+ yScale + " "
				 					+ zScale + "'>\n" +
	
				 "\n<Shape DEF='" + ring2Points[i] + "Shape'\n" +
				    " containerField='children'>\n" +
				    " <Appearance\n" +
				    "  containerField='appearance'>\n";
	
			
				body+= " <ImageTexture containerField='texture' " +
				" url='../images/" + ring2Elements[i] + ".jpg'/>";	
				    
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
				 	"<Sphere DEF='" + ring2Elements[i] + "Sphere'\n" +
				 	"containerField='geometry'\n" +
				 	"radius='" + atomRadius +"'/>\n" +
				 	"</Shape>\n" +
				 	
					"\n<TouchSensor DEF='"+ring2Elements[i]+"Touch' \n" +
	                   " description='"+ring2Elements[i]+"'\n" +
		               " containerField='children'/> \n" +
	
				 "</Transform>\n";
				
				//System.out.println("Nuceotides - Set Transform: ");	
			}
		}
		
		
		// Add the Activators and Stabilizers for the Pentose
		String coAtomList2[] = 
		{
			
			"(HNH)",	
			
			"",   
			 
			"", 
			
			"", 
			
		    "(O)",
			 
			"(H)"
		};

		body+=getCoAtoms(bioMightTransform, ring2Points, ring2Elements, coAtomList2); 
		
		return(body);
	}
	
	
	/*************************************************************************
	 *  GET CYTOSINE
	 *  
	 *  Creates a Representation of Cytosine
	 *  
	 ************************************************************************/ 		

	public static String getCytosine(BioMightTransform bioMightTransform, double circumference, double angle)  
	{
		String body = "";
		
		double x = bioMightTransform.getTranslation().getXPos();
		double y = bioMightTransform.getTranslation().getYPos();
		double z = bioMightTransform.getTranslation().getZPos();
		System.out.println("getCytosine()  x: " + x + " y: "   + y + "  z:" + z);			

		double xScale = 1.0;
		double yScale = 1.0;
		double zScale = 1.0;

		double startPos[] = {x, y, z};
		double radiansAngle = Math.toRadians(angle);
		String ring1Elements[] = {"Carbon", "Nitrogen", "Carbon", "Carbon", "Carbon", "Nitrogen"};
		double[][] ring1Points = BioGraphics.createCylinderInPlane(Constants.YPLANE,  startPos,  0.25, ring1Elements.length, radiansAngle);
		//BioGraphics.dumpPoints("ring1Points", ring1Points);

	
		//if (angle > 0.0)
		//{
		//	System.out.println("Rotating Nucleotide: " + angle);			
		//	ring2Points = BioGraphics.rotateY(ring2Points, angle);
		//	System.out.println("Rotated Nucleotide: " + angle);			
		//}		
		
		// Create the Nitrogeneous Ring2 
		for (int i=0; i<ring1Points.length; i++)
		{
			//System.out.println("Creating X3D for : " + phosphateElements[i]);				
			
			double atomRadius = getAtomicRadius(ring1Elements[i]);
			System.out.println("Ring2 Atom Radius Size : " + atomRadius);	
	
			// Change the height and width based on the displacement.
			body += "\n<Transform DEF='" + ring1Elements[i] + "'\n";
					
		 	body += "translation='" 
		 		 	+ ring1Points[i][0] + " " 
		 		 	+ ring1Points[i][1] + " "
					+ ring1Points[i][2]+ "'\n";					
			
			//System.out.println("Set Translation: ");				

			body +=  "scale='" 	+ xScale + " "
			 					+ yScale + " "
			 					+ zScale + "'>\n" +

			 "\n<Shape DEF='" + ring1Points[i] + "Shape'\n" +
			    " containerField='children'>\n" +
			    " <Appearance\n" +
			    "  containerField='appearance'>\n";

		
			body+= " <ImageTexture containerField='texture' " +
			" url='../images/" + ring1Elements[i] + ".jpg'/>";	
			    
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
			 	"<Sphere DEF='" + ring1Elements[i] + "Sphere'\n" +
			 	"containerField='geometry'\n" +
			 	"radius='" + atomRadius +"'/>\n" +
			 	"</Shape>\n" +
			 	
				"\n<TouchSensor DEF='"+ring1Elements[i]+"Touch' \n" +
                   " description='"+ring1Elements[i]+"'\n" +
	               " containerField='children'/> \n" +

			 "</Transform>\n";
			
			//System.out.println("Nuceotides - Set Transform: ");				
		}
		
		
		// Add the Activators and Stabilizers for the Pentose
		String coAtomList2[] = 
		{
			
			"(O)",	
			
			"(H)",   
			 
			"(H)", 
			
			"(H)", 
			
		    "(HN (H) (H))",
			 
			""
		};

		body+=getCoAtoms(bioMightTransform, ring1Points, ring1Elements, coAtomList2); 
		
		return(body);
	}
	
	
	/*************************************************************************
	 *  GET THYMINE
	 *  
	 *  Creates a Representation of Thymine
	 *  
	 ************************************************************************/ 		

	public static String getThymine(BioMightTransform bioMightTransform, double circumference, double angle)  
	{
		String body = "";
		
		double x = bioMightTransform.getTranslation().getXPos();
		double y = bioMightTransform.getTranslation().getYPos();
		double z = bioMightTransform.getTranslation().getZPos();
		System.out.println("getThymine()    x: " + x + " y: "   + y + "  z:" + z);			

		double xScale = 1.0;
		double yScale = 1.0;
		double zScale = 1.0;

	
		double ring2startPos[] = {x, y, z};
		String ring2Elements[] = {"Carbon", "Nitrogen", "Carbon", "Carbon", "Carbon", "Nitrogen"};
		//double[][] ribosePoints = BioGraphics.createCylinderInPlane(Constants.YPLANE,  startPos,  1.0, displaceAngle);
		double radiansAngle = Math.toRadians(30.0);
		double[][] ring2Points = BioGraphics.createCylinderInPlane(Constants.YPLANE,  ring2startPos,  0.25, ring2Elements.length, radiansAngle);
		//BioGraphics.dumpPoints("ring2Points", ring2Points);	
		
		// Create the Nitrogeneous Ring2 
		for (int i=0; i<ring2Points.length; i++)
		{
			//System.out.println("Creating X3D for : " + phosphateElements[i]);				
			
			double atomRadius = getAtomicRadius(ring2Elements[i]);
			System.out.println("Ring2 Atom Radius Size : " + atomRadius);	
	
			// Change the height and width based on the displacement.
			body += "\n<Transform DEF='" + ring2Elements[i] + "'\n";
					
		 	body += "translation='" 
		 		 	+ ring2Points[i][0] + " " 
		 		 	+ ring2Points[i][1] + " "
					+ ring2Points[i][2]+ "'\n";					
			
			//System.out.println("Set Translation: ");				

			body +=  "scale='" 	+ xScale + " "
			 					+ yScale + " "
			 					+ zScale + "'>\n" +

			 "\n<Shape DEF='" + ring2Points[i] + "Shape'\n" +
			    " containerField='children'>\n" +
			    " <Appearance\n" +
			    "  containerField='appearance'>\n";

		
			body+= " <ImageTexture containerField='texture' " +
			" url='../images/" + ring2Elements[i] + ".jpg'/>";	
			    
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
			 	"<Sphere DEF='" + ring2Elements[i] + "Sphere'\n" +
			 	"containerField='geometry'\n" +
			 	"radius='" + atomRadius +"'/>\n" +
			 	"</Shape>\n" +
			 	
				"\n<TouchSensor DEF='"+ring2Elements[i]+"Touch' \n" +
                   " description='"+ring2Elements[i]+"'\n" +
	               " containerField='children'/> \n" +

			 "</Transform>\n";
			
			//System.out.println("Nuceotides - Set Transform: ");				
		}
		
		
		// Add the Activators and Stabilizers for the Pentose
		String coAtomList2[] = 
		{
			
			"(O)",	
			
			"(H)",   
			 
			"(H)", 
			
			"((H) (C H H))", 
			
		    "(O)",
			 
			"(H)"
		};

		body+=getCoAtoms(bioMightTransform, ring2Points, ring2Elements, coAtomList2); 
		
		return(body);
	}
	
	/*************************************************************************
	 *  GET URACIL
	 *  
	 *  Creates a Representation of Uracil
	 *  
	 ************************************************************************/ 		

	public static String getUracil(BioMightTransform bioMightTransform, double circumference, double angle)  
	{
		String body = "";
		
		double x = bioMightTransform.getTranslation().getXPos();
		double y = bioMightTransform.getTranslation().getYPos();
		double z = bioMightTransform.getTranslation().getZPos();
		System.out.println("getUracil()    x: " + x + " y: "   + y + "  z:" + z);			

		double xScale = 1.0;
		double yScale = 1.0;
		double zScale = 1.0;

	
		double ring2startPos[] = {x, y, z};
		String ring2Elements[] = {"Carbon", "Nitrogen", "Carbon", "Carbon", "Carbon", "Nitrogen"};
		//double[][] ribosePoints = BioGraphics.createCylinderInPlane(Constants.YPLANE,  startPos,  1.0, displaceAngle);
		double radiansAngle = Math.toRadians(30.0);
		double[][] ring2Points = BioGraphics.createCylinderInPlane(Constants.YPLANE,  ring2startPos,  0.25, ring2Elements.length, radiansAngle);
		//BioGraphics.dumpPoints("ring2Points", ring2Points);	
		
		// Create the Nitrogeneous Ring2 
		for (int i=0; i<ring2Points.length; i++)
		{
			//System.out.println("Creating X3D for : " + phosphateElements[i]);				
			
			double atomRadius = getAtomicRadius(ring2Elements[i]);
			System.out.println("Ring2 Atom Radius Size : " + atomRadius);	
	
			// Change the height and width based on the displacement.
			body += "\n<Transform DEF='" + ring2Elements[i] + "'\n";
					
		 	body += "translation='" 
		 		 	+ ring2Points[i][0] + " " 
		 		 	+ ring2Points[i][1] + " "
					+ ring2Points[i][2]+ "'\n";					
			
			//System.out.println("Set Translation: ");				

			body +=  "scale='" 	+ xScale + " "
			 					+ yScale + " "
			 					+ zScale + "'>\n" +

			 "\n<Shape DEF='" + ring2Points[i] + "Shape'\n" +
			    " containerField='children'>\n" +
			    " <Appearance\n" +
			    "  containerField='appearance'>\n";

		
			body+= " <ImageTexture containerField='texture' " +
			" url='../images/" + ring2Elements[i] + ".jpg'/>";	
			    
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
			 	"<Sphere DEF='" + ring2Elements[i] + "Sphere'\n" +
			 	"containerField='geometry'\n" +
			 	"radius='" + atomRadius +"'/>\n" +
			 	"</Shape>\n" +
			 	
				"\n<TouchSensor DEF='"+ring2Elements[i]+"Touch' \n" +
                   " description='"+ring2Elements[i]+"'\n" +
	               " containerField='children'/> \n" +

			 "</Transform>\n";
			
			//System.out.println("Nuceotides - Set Transform: ");				
		}
		
		
		// Add the Activators and Stabilizers for the Pentose
		String coAtomList2[] = 
		{
			
			"(O)",	
			
			"(H)",   
			 
			"(H)", 
			
			"(H)", 
			
		    "(O)",
			 
			"(H)"
		};

		body+=getCoAtoms(bioMightTransform, ring2Points, ring2Elements, coAtomList2); 
		
		return(body);
	}
	
	/*************************************************************************
	 *  GET AMINE 
	 *  
	 *  Creates a representation of an Amine
	 *  
	 ************************************************************************/ 		

	public static String getAmine(BioMightTransform bioMightTransform, double radius, double angle)  
	{
		String body = "";
		
		double x = bioMightTransform.getTranslation().getXPos();
		double y = bioMightTransform.getTranslation().getYPos();
		double z = bioMightTransform.getTranslation().getZPos();
		System.out.println("getAmine()    x: " + x + " y: "   + y + "  z:" + z);			

		double xScale = 1.0;
		double yScale = 1.0;
		double zScale = 1.0;
		
		double[] startPos = {x, y, z};
		double radiansAngle = Math.toRadians(angle);	

		//System.out.println("Creating X3D for : " + phosphateElements[i]);				
			
		double atomRadius = getAtomicRadius("Nitrogen");	
		// Change the height and width based on the displacement.
		body += "\n<Transform DEF='AmineNitrogen'\n";
				
	 	body += "translation='" 
	 		 	+ startPos[0] + " " 
	 		 	+ startPos[1] + " "
				+ startPos[2]+ "'\n";					
		
		//System.out.println("Set Translation: ");				

		body +=  "scale='" 	+ xScale + " "
		 					+ yScale + " "
		 					+ zScale + "'>\n" +

		 "\n<Shape DEF='" + "Nitrogen" + "Shape'\n" +
		    " containerField='children'>\n" +
		    " <Appearance\n" +
		    "  containerField='appearance'>\n";

	
		body+= " <ImageTexture containerField='texture' " +
		" url='../images/Nitrogen.jpg'/>";
			
		    
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
		 	"<Sphere DEF='" + "Nitrogen" + "Sphere'\n" +
		 	"containerField='geometry'\n" +
		 	"radius='" + atomRadius +"'/>\n" +
		 	"</Shape>\n" +
		 	
			"\n<TouchSensor DEF='"+"Nitrogen"+"Touch' \n" +
               " description='"+"Nitrogen"+"'\n" +
               " containerField='children'/> \n" +

		 "</Transform>\n";				
		
			
		//***********************************************
		// Create the Amine Grouup
		//***********************************************
		String amine[] = {"Hydrogen", "Hydrogen"};
				
		// Get the radius of the coAtom
		double coAtomRadius = getAtomicRadius("Hydrogen");
		double totalRadius = atomRadius + coAtomRadius;
		System.out.println("Ring2-Creating X3D for Radius: " + totalRadius);				
		
		// We are getting two points and then placing the atoms there
		// Have to calculate this orbital 
		double[] displaceAngles = {30, 300};
		double[][] alignedPoints = BioGraphics.createCylinderInPlane(Constants.ZPLANE,  startPos,  totalRadius, displaceAngles);


		for (int i=0; i<amine.length; i++)
		{
			System.out.println("Creating X3D for : " + amine[i]);				
			
			// Change the height and width based on the displacement.
			body += "\n<Transform DEF='" + amine[i] + "'\n";
					
		 	body += "translation='" 
		 			+ alignedPoints[i][0] + " " 
					+ alignedPoints[i][1] + " "
					+ alignedPoints[i][2] + "'\n";					
			
			// System.out.println("Set Translation: ");				

			body +=  "scale='" 	+ xScale + " "
			 					+ yScale + " "
			 					+ zScale + "'>\n" +

			 "\n<Shape DEF='" + amine[i] + "Shape'\n" +
			    " containerField='children'>\n" +
			    " <Appearance\n" +
			    "  containerField='appearance'>\n";

		
			body+= " <ImageTexture containerField='texture' " +
			    " url='../images/" + amine[i] + ".jpg'/>";
				
			atomRadius = BioWebDNA.getAtomicRadius(amine[i]);
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
			 	"<Sphere DEF='" + amine[i] + "Sphere'\n" +
			 	"containerField='geometry'\n" +
			 	"radius='" + atomRadius +"'/>\n" +
			 	"</Shape>\n" +
			 	
				"\n<TouchSensor DEF='"+amine[i]+"Touch' \n" +
                   " description='"+amine[i]+"'\n" +
	               " containerField='children'/> \n" +

			 "</Transform>\n";

		}

	
		return(body);
	}
	
	
	/*************************************************************************
	 *  GET CARBOXYL GROUP
	 *  
	 *  Creates a representation of an Carboxyl Group
	 *  
	 ************************************************************************/ 		

	public static String getCarboxylGroup(BioMightTransform bioMightTransform, double radius, double angle)  
	{
		String body = "";
		
		double x = bioMightTransform.getTranslation().getXPos();
		double y = bioMightTransform.getTranslation().getYPos();
		double z = bioMightTransform.getTranslation().getZPos();
		System.out.println("getCarboxylGroup()    x: " + x + " y: "   + y + "  z:" + z);			

		double xScale = 1.0;
		double yScale = 1.0;
		double zScale = 1.0;
		
		double[] startPos = {x, y, z};
		double radiansAngle = Math.toRadians(angle);	

		//System.out.println("Creating X3D for : " + phosphateElements[i]);				
			
		double atomRadius = getAtomicRadius("Carbon");	
		// Change the height and width based on the displacement.
		body += "\n<Transform DEF='CarboxylCarbon'\n";
				
	 	body += "translation='" 
	 		 	+ startPos[0] + " " 
	 		 	+ startPos[1] + " "
				+ startPos[2]+ "'\n";					
		
		//System.out.println("Set Translation: ");				

		body +=  "scale='" 	+ xScale + " "
		 					+ yScale + " "
		 					+ zScale + "'>\n" +

		 "\n<Shape DEF='" + "Carbon" + "Shape'\n" +
		    " containerField='children'>\n" +
		    " <Appearance\n" +
		    "  containerField='appearance'>\n";

	
		body+= " <ImageTexture containerField='texture' " +
		" url='../images/Carbon.jpg'/>";
			
		    
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
		 	"<Sphere DEF='" + "Carbon" + "Sphere'\n" +
		 	"containerField='geometry'\n" +
		 	"radius='" + atomRadius +"'/>\n" +
		 	"</Shape>\n" +
		 	
			"\n<TouchSensor DEF='"+"Carbon"+"Touch' \n" +
               " description='"+"Nitrogen"+"'\n" +
               " containerField='children'/> \n" +

		 "</Transform>\n";				
		
			
		//***********************************************
		// Create the Dual Oxygens
		//***********************************************
		String amine[] = {"Oxygen", "Oxygen"};
				
		// Get the radius of the coAtom
		double coAtomRadius = getAtomicRadius("Oxygen");
		double totalRadius = atomRadius + coAtomRadius;
		System.out.println("Ring2-Creating X3D for Radius: " + totalRadius);				
		
		// We are getting two points and then placing the atoms there
		// Have to calculate this orbital 
		double[] displaceAngles = {120, 240};
		double[][] alignedPoints = BioGraphics.createCylinderInPlane(Constants.ZPLANE,  startPos,  totalRadius, displaceAngles);


		for (int i=0; i<amine.length; i++)
		{
			System.out.println("Creating X3D for : " + amine[i]);				
			
			// Change the height and width based on the displacement.
			body += "\n<Transform DEF='" + amine[i] + "'\n";
					
		 	body += "translation='" 
		 			+ alignedPoints[i][0] + " " 
					+ alignedPoints[i][1] + " "
					+ alignedPoints[i][2] + "'\n";					
			
			// System.out.println("Set Translation: ");				

			body +=  "scale='" 	+ xScale + " "
			 					+ yScale + " "
			 					+ zScale + "'>\n" +

			 "\n<Shape DEF='" + amine[i] + "Shape'\n" +
			    " containerField='children'>\n" +
			    " <Appearance\n" +
			    "  containerField='appearance'>\n";

		
			body+= " <ImageTexture containerField='texture' " +
			    " url='../images/" + amine[i] + ".jpg'/>";
				
			atomRadius = BioWebDNA.getAtomicRadius(amine[i]);
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
			 	"<Sphere DEF='" + amine[i] + "Sphere'\n" +
			 	"containerField='geometry'\n" +
			 	"radius='" + atomRadius +"'/>\n" +
			 	"</Shape>\n" +
			 	
				"\n<TouchSensor DEF='"+amine[i]+"Touch' \n" +
                   " description='"+amine[i]+"'\n" +
	               " containerField='children'/> \n" +

			 "</Transform>\n";
		}


		//***********************************************
		// Create the Hydrogen
		//***********************************************
		String hydro[] = {"Hydrogen"};
				
		// Get the radius of the coAtom
		atomRadius = getAtomicRadius("Oxygen");
		coAtomRadius = getAtomicRadius("Hydrogen");
		totalRadius = atomRadius + coAtomRadius;
		System.out.println("SubRing-Creating X3D for Radius: " + totalRadius);				
		
		// We are getting two points and then placing the atoms there
		// Have to calculate this orbital 
		double displaceHydro[] = {90};
		alignedPoints = BioGraphics.createCylinderInPlane(Constants.ZPLANE,  alignedPoints[0],  totalRadius, displaceHydro);


		for (int i=0; i<hydro.length; i++)
		{
			System.out.println("Creating X3D for : " + hydro[i]);				
			
			// Change the height and width based on the displacement.
			body += "\n<Transform DEF='" + hydro[i] + "'\n";
					
		 	body += "translation='" 
		 			+ alignedPoints[i][0] + " " 
					+ alignedPoints[i][1] + " "
					+ alignedPoints[i][2] + "'\n";					
			
			// System.out.println("Set Translation: ");				

			body +=  "scale='" 	+ xScale + " "
			 					+ yScale + " "
			 					+ zScale + "'>\n" +

			 "\n<Shape DEF='" + hydro[i] + "Shape'\n" +
			    " containerField='children'>\n" +
			    " <Appearance\n" +
			    "  containerField='appearance'>\n";

		
			body+= " <ImageTexture containerField='texture' " +
			    " url='../images/" + hydro[i] + ".jpg'/>";
				
			atomRadius = BioWebDNA.getAtomicRadius(hydro[i]);
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
			 	"<Sphere DEF='" + hydro[i] + "Sphere'\n" +
			 	"containerField='geometry'\n" +
			 	"radius='" + atomRadius +"'/>\n" +
			 	"</Shape>\n" +
			 	
				"\n<TouchSensor DEF='"+hydro[i]+"Touch' \n" +
                   " description='"+hydro[i]+"'\n" +
	               " containerField='children'/> \n" +

			 "</Transform>\n";
		}

		
		
		return(body);
	}
	
	/*************************************************************************
	 *  GET MOLECULE
	 *  
	 *  Creates a representation of an Carboxyl Group
	 *  
	 ************************************************************************/ 		

	public static String getSimpleMolecule(BioMightTransform bioMightTransform, String molecule, String[] coAtoms, double[] coOrientation)  
	{
		String body = "";
		
		double x = bioMightTransform.getTranslation().getXPos();
		double y = bioMightTransform.getTranslation().getYPos();
		double z = bioMightTransform.getTranslation().getZPos();
		System.out.println("getSimpleMolecule()    x: " + x + " y: "   + y + "  z:" + z);			

		double xScale = 1.0;
		double yScale = 1.0;
		double zScale = 1.0;
		
		double[] startPos = {x, y, z};
		//double radiansAngle = Math.toRadians(angle);	

		//System.out.println("Creating X3D for : " + phosphateElements[i]);				
			
		double atomRadius = getAtomicRadius(molecule);	
		// Change the height and width based on the displacement.
		body += "\n<Transform DEF='" + molecule + "'\n";
				
	 	body += "translation='" 
	 		 	+ startPos[0] + " " 
	 		 	+ startPos[1] + " "
				+ startPos[2]+ "'\n";					
		

		body +=  "scale='" 	+ xScale + " "
		 					+ yScale + " "
		 					+ zScale + "'>\n" +

		 "\n<Shape DEF='" + molecule + "Shape'\n" +
		    " containerField='children'>\n" +
		    " <Appearance\n" +
		    "  containerField='appearance'>\n";

	
		body+= " <ImageTexture containerField='texture' " +
		" url='../images/" + molecule + ".jpg'/>";
			
		    
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
		 	"<Sphere DEF='" + molecule + "Sphere'\n" +
		 	"containerField='geometry'\n" +
		 	"radius='" + atomRadius +"'/>\n" +
		 	"</Shape>\n" +
		 	
			"\n<TouchSensor DEF='"+ molecule +"Touch' \n" +
               " description='"+"Nitrogen"+"'\n" +
               " containerField='children'/> \n" +

		 "</Transform>\n";				
		
			
		//***********************************************
		// Create the CoAtoms
		//***********************************************
		
		for (int i=0; i<coAtoms.length; i++)
		{
			System.out.println("Creating X3D for : " + coAtoms[i]);				
			double coAtomRadius = getAtomicRadius(coAtoms[i]);
			double totalRadius = atomRadius + coAtomRadius;
			System.out.println("Ring2-Creating X3D using Radius: " + totalRadius);				
			
			// We are getting two points and then placing the atoms there
			// Have to calculate this orbital 
		
			double[] alignment = {coOrientation[i]}; 
			double[][] alignedPoints = BioGraphics.createCylinderInPlane(Constants.ZPLANE,  startPos,  totalRadius, alignment);
		
			// Change the height and width based on the displacement.
			body += "\n<Transform DEF='" + coAtoms[i] + "'\n";
					
		 	body += "translation='" 
		 			+ alignedPoints[0][0] + " " 
					+ alignedPoints[0][1] + " "
					+ alignedPoints[0][2] + "'\n";					
			
			// System.out.println("Set Translation: ");				

			body +=  "scale='" 	+ xScale + " "
			 					+ yScale + " "
			 					+ zScale + "'>\n" +

			 "\n<Shape DEF='" + coAtoms[i] + "Shape'\n" +
			    " containerField='children'>\n" +
			    " <Appearance\n" +
			    "  containerField='appearance'>\n";

		
			body+= " <ImageTexture containerField='texture' " +
			    " url='../images/" + coAtoms[i] + ".jpg'/>";
				
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
			 	"<Sphere DEF='" + coAtoms[i] + "Sphere'\n" +
			 	"containerField='geometry'\n" +
			 	"radius='" + coAtomRadius +"'/>\n" +
			 	"</Shape>\n" +
			 	
				"\n<TouchSensor DEF='"+coAtoms[i]+"Touch' \n" +
                   " description='"+coAtoms[i]+"'\n" +
	               " containerField='children'/> \n" +

			 "</Transform>\n";
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
	
	
	/*************************************************************************
	 *  GET CO ATOMS
	 *  
	 *  Get the radius for the atom.
	 *  
	 ************************************************************************/ 		
	
	public static String getCoAtoms(BioMightTransform bioMightTransform, double[][] atomPoints, String[] atomList, String[] coAtomList)  
	{
		String body="";

		// Run through each point of the Pentose and lay in the orbits of the atoms
		System.out.println("CoAtoms Length is: " + atomPoints.length);
		
		for (int j=0; j<atomPoints.length; j++)
		//for (int j=3; j<4; j++)
		{
			double displaceAngle = 90;	
			double centerPoint[] = {atomPoints[j][0], atomPoints[j][1], atomPoints[j][2]};	
			double atomRadius = getAtomicRadius(atomList[j]);
	
			// Get the current group from the formula
			String formula = coAtomList[j];
				
			if (!formula.equals(""))
			{
				//System.out.println("Total CoAtoms in list: " + currentList.length);	
				Stack<Character> stack = new Stack<Character>();
				char c;
				
				// We have to move the arc distance of the base atom
				double totalRadius = atomRadius;
				int parenCount = 0;
				// Walk through the entire formula in linear fashion to consume it all
				for (int i=0; i<formula.length(); i++)
				{						
					// Get the character at that position in the string
					c = formula.charAt(i);
				
					
					// Push until we get a closing parenthesis
					while (c!= ')' && i < formula.length())
					{
						if (c!= ' ')
						{
							stack.push(c);
							//System.out.println("Ring2 Pushing: " + i + " value " + c);
							
							if (c== '(')
							{
								parenCount++;
								//System.out.println("Ring2 Incrementing ParenCount: " + parenCount);
								
								// Make it the next base molecule
								Character baseAtom = stack.peek();
								if (baseAtom !=  '(' )
								{
									// This is the new base molecule.  
									// We are getting two points and then placing the atoms there
									// Have to calculate this orbital 
									
									double baseRadius = getAtomicRadius(baseAtom+"");
									double[] displaceAngles = {displaceAngle};
									double[][] alignedPoints = BioGraphics.createCylinderInPlane(Constants.ZPLANE,  centerPoint,  baseRadius, displaceAngles);
									centerPoint = alignedPoints[0];
									//System.out.println("Setting Base Molecule to: " + baseAtom);
								}
							}
						}
						else
						{
							//System.out.println("Ring2 Skipping Space: " + i + " value " + c);
						}
						
						
						i++;
						// get the next symbol 
						c = formula.charAt(i); 
					} 
					//System.out.println("Ring2 - End of Group");
					
					
					// Make sure we are not here due to end of formula
					parenCount--;
			
					// Pop everything within the first sets of parenthesis
					// We are grabbing values off the stack and 
					// moving backwards towards the opening parenthesis
					char popChar = ' ';
					while (popChar!= '(')
					{
						popChar = stack.pop();
						//System.out.println("Ring2 - Popping: " + i +  "  value: " +  popChar);
						if (popChar!= '(')
						{
							
							String coAtom = "" +  popChar;
							
							// Get the radius of the coAtom
							double coAtomRadius = getAtomicRadius(coAtom);
								
							//System.out.println("Ring2-Creating X3D for CoAtom: " + coAtom + " with coRadius: " + coAtomRadius + " around radius:"  + atomRadius + " at angle: " + displaceAngle);
							totalRadius += coAtomRadius;
							//System.out.println("Ring2-Creating X3D for Radius: " + totalRadius);				
							
							// We are getting two points and then placing the atoms there
							// Have to calculate this orbital 
							double[] displaceAngles = {displaceAngle};
							double[][] alignedPoints = BioGraphics.createCylinderInPlane(Constants.ZPLANE,  centerPoint,  totalRadius, displaceAngles);
							
							// Make the atom the new base that the other atoms are centered around
							///centerPoint = alignedPoints[0];
							
							
							// Move to the outside of the current atom
							totalRadius += coAtomRadius;
							
							// Change the height and width based on the displacement.
							body += "\n<Transform DEF='" + coAtom + "'\n";
							
				
						 	body += "translation='" 
						 		 	+ (alignedPoints[0][0]) + " " 
						 		 	+ (alignedPoints[0][1]) + " "
									+ (alignedPoints[0][2]) + "'\n";					
							
							
							body +=  "scale='" 	+ bioMightTransform.getScale().getXScaleStr() + " "
							 					+ bioMightTransform.getScale().getYScaleStr() + " "
							 					+ bioMightTransform.getScale().getZScaleStr()  + "'>\n" +
				
							 "\n<Shape DEF='" + coAtom + "Shape'\n" +
							    " containerField='children'>\n" +
							    " <Appearance\n" +
							    "  containerField='appearance'>\n";
				
						
							String coAtomName = getAtomicName(coAtom);
							body+= " <ImageTexture containerField='texture' " +
							    " url='../images/" + coAtomName + ".jpg'/>";
														    
							
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
							 	"<Sphere DEF='" + coAtom + "Sphere'\n" +
							 	"containerField='geometry'\n" +
							 	"radius='" + coAtomRadius +"'/>\n" +
							 	"</Shape>\n" +
							 	
								"\n<TouchSensor DEF='"+coAtom+"Touch' \n" +
				                   " description='"+coAtom+"'\n" +
					               " containerField='children'/> \n" +
				
							 "</Transform>\n";
						}
						else
						{
							//System.out.println("Ring2-We reached the beginning!");
						}
					}
			
					// we need to see if there is another parenthesis in front of this group, and
					// if so have to stay together as a whole.   We grow away from center.
					
					
					
					// Each time we close off a group we need to move to another area of space
					if (parenCount > 0)
					{
						//System.out.println("We are in a group, so we need to grow outward at same angle: " + displaceAngle + " parenCount: " + parenCount);	
						
						// Reset the radius to the base atom
						//totalRadius = atomRadius;			
						//System.out.println("Staving Radius to grow more as we are extending the chain: " + atomRadius);
						
						//centerPoint = alignedPoints[j];  	
					
					}
					else
					{
						//System.out.println("Jumping to another location around BaseAtom: " + displaceAngle + " parenCount: " + parenCount);
						if (displaceAngle < 360)
							displaceAngle += 180;
						else
							displaceAngle += 95;
						
						// Reset the radius to the base atom
						totalRadius = atomRadius;			
						//System.out.println("Setting Radius to base Ribose Molecule: " + atomRadius);
					}
					
				}
			}
		}
	
	
		return (body);
	}
		

	
	/*************************************************************************
	 *  GET CO ATOMS
	 *  
	 *  Get the radius for the atom.
	 *  
	 ************************************************************************/ 		
	
	public static String getCoAtoms2(BioMightTransform bioMightTransform, double[][] atomPoints, String[] atomList, String[] coAtomList)  
	{
		String body="";

		// Run through each point of the Pentose and lay in the orbits of the atoms
		//System.out.println("ring2Points length is: " + atomPoints.length);
		
		for (int j=0; j<atomPoints.length; j++)
		//for (int j=3; j<4; j++)
		{
			double displaceAngle = 90;	
			double centerPoint[] = {atomPoints[j][0], atomPoints[j][1], atomPoints[j][2]};	
			double atomRadius = getAtomicRadius(atomList[j]);
	
			// Get the current group from the formula
			String formula = coAtomList[j];
				
			if (!formula.equals(""))
			{
				//System.out.println("Total CoAtoms in list: " + currentList.length);	
				Stack<Character> stack = new Stack<Character>();
				char c;
				
				// We have to move the arc distance of the base atom
				double totalRadius = atomRadius;
				int parenCount = 0;
				// Walk through the entire formula in linear fashion to consume it all
				for (int i=0; i<formula.length(); i++)
				{						
					// Get the character at that position in the string
					c = formula.charAt(i);
				
					
					// Push until we get a closing parenthesis
					while (c!= ')' && i < formula.length())
					{
						if (c!= ' ')
						{
							stack.push(c);
							//System.out.println("Ring2 Pushing: " + i + " value " + c);
							
							if (c== '(')
							{
								parenCount++;
								//System.out.println("Ring2 Incrementing ParenCount: " + parenCount);
								
								// Make it the next base molecule
								
								
							}
						}
						else
							//System.out.println("Ring2 Skipping Space: " + i + " value " + c);
						
						i++;
						// get the next symbol 
						c = formula.charAt(i); 
					} 
					//System.out.println("Ring2 - End of Group");
					
					
					// Make sure we are not here due to end of formula
					parenCount--;
			
					// Pop everything within the first sets of parenthesis
					// We are grabbing values off the stack and 
					// moving backwards towards the opening parenthesis
					char popChar = ' ';
					while (popChar!= '(')
					{
						popChar = stack.pop();
						//System.out.println("Ring2 - Popping: " + i +  "  value: " +  popChar);
						if (popChar!= '(')
						{
							
							String coAtom = "" +  popChar;
							
							// Get the radius of the coAtom
							double coAtomRadius = getAtomicRadius(coAtom);
								
							//System.out.println("Ring2-Creating X3D for CoAtom: " + coAtom + " with coRadius: " + coAtomRadius + " around radius:"  + atomRadius + " at angle: " + displaceAngle);
							totalRadius += coAtomRadius;
							//System.out.println("Ring2-Creating X3D for Radius: " + totalRadius);				
							
							// We are getting two points and then placing the atoms there
							// Have to calculate this orbital 
							double[] displaceAngles = {displaceAngle};
							double[][] alignedPoints = BioGraphics.createCylinderInPlane(Constants.ZPLANE,  centerPoint,  totalRadius, displaceAngles);
							
							// Move to the outside of the current atom
							totalRadius += coAtomRadius;
							
							// Change the height and width based on the displacement.
							body += "\n<Transform DEF='" + coAtom + "'\n";
							
				
						 	body += "translation='" 
						 		 	+ (alignedPoints[0][0]) + " " 
						 		 	+ (alignedPoints[0][1]) + " "
									+ (alignedPoints[0][2]) + "'\n";					
							
							
							body +=  "scale='" 	+ bioMightTransform.getScale().getXScaleStr() + " "
							 					+ bioMightTransform.getScale().getYScaleStr() + " "
							 					+ bioMightTransform.getScale().getZScaleStr()  + "'>\n" +
				
							 "\n<Shape DEF='" + coAtom + "Shape'\n" +
							    " containerField='children'>\n" +
							    " <Appearance\n" +
							    "  containerField='appearance'>\n";
				
						
							String coAtomName = getAtomicName(coAtom);
							body+= " <ImageTexture containerField='texture' " +
							    " url='../images/" + coAtomName + ".jpg'/>";
														    
							
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
							 	"<Sphere DEF='" + coAtom + "Sphere'\n" +
							 	"containerField='geometry'\n" +
							 	"radius='" + coAtomRadius +"'/>\n" +
							 	"</Shape>\n" +
							 	
								"\n<TouchSensor DEF='"+coAtom+"Touch' \n" +
				                   " description='"+coAtom+"'\n" +
					               " containerField='children'/> \n" +
				
							 "</Transform>\n";
						}
						else
						{
							//System.out.println("Ring2-We reached the beginning!");
						}
					}
			
					// we need to see if there is another parenthesis in front of this group, and
					// if so have to stay together as a whole.   We grow away from center.
					
					
					
					// Each time we close off a group we need to move to another area of space
					if (parenCount > 0)
					{
						//System.out.println("We are in a group, so we need to grow outward at same angle: " + displaceAngle + " parenCount: " + parenCount);	
						
						// Reset the radius to the base atom
						//totalRadius = atomRadius;			
						//System.out.println("Staving Radius to grow more as we are extending the chain: " + atomRadius);
						
						//centerPoint = alignedPoints[j];  	
					
					}
					else
					{
						//System.out.println("Jumping to another location around BaseAtom: " + displaceAngle + " parenCount: " + parenCount);
						if (displaceAngle < 360)
							displaceAngle += 180;
						else
							displaceAngle += 95;
						
						// Reset the radius to the base atom
						totalRadius = atomRadius;			
						//System.out.println("Setting Radius to base Ribose Molecule: " + atomRadius);
					}
					
				}
			}
		}
	
	
		return (body);
	}
		
	/*************************************************************************
	 *  GET ATOM RADIUS
	 *  
	 *  Get the radius for the atom.
	 *  
	 ************************************************************************/ 		
	
	public static double getAtomicRadius(String atom)  
	{
		
	double atomRadius = 0.001;

	if (atom.equals("Electron") || atom.equals("E"))
	{
		atomRadius = 0.25;	
	}
	else if (atom.equals("Hydrogen") || atom.equals("H"))
	{
		atomRadius = 0.01;	
	}
	else if (atom.equals("Carbon") || atom.equals("C"))
	{
		atomRadius = 0.06;	
	}
	else if (atom.equals("Oxygen") || atom.equals("O"))
	{
		atomRadius = 0.08;	
	}
	else if (atom.equals("Nitrogen") || atom.equals("N"))
	{
		atomRadius = 0.07;	
	}
	else if (atom.equals("Phosphorus") || atom.equals("P"))
	{
		atomRadius = 0.15;	
	}
	else if (atom.equals("Sulfur") || atom.equals("S"))
	{
		atomRadius = 0.16;	
	}
	else 
	{
		atomRadius = 0.01;	
	}	
	
		return(atomRadius);
	}
	
	
	/*************************************************************************
	 *  GET ATOM NAME
	 *  
	 *  Get the radius for the atom.
	 *  
	 ************************************************************************/ 		
	
	public static String getAtomicName(String atom)  
	{
		
	String atomicName = "";

	if (atom.equals("H"))
	{
		atomicName = "Hydrogen";	
	}
	else if (atom.equals("C"))
	{
		atomicName = "Carbon";	
	}
	else if (atom.equals("N"))
	{
		atomicName = "Nitrogen";	
	}
	else if (atom.equals("O"))
	{
		atomicName = "Oxygen";	
	}
	else if (atom.equals("P"))
	{
		atomicName = "Phosphorus";	
	}
	else if (atom.equals("S"))
	{
		atomicName = "Sulfur";	
	}
	else 
	{
		atomicName = "";	
	}	
	
		return(atomicName);
	}
	
	
}