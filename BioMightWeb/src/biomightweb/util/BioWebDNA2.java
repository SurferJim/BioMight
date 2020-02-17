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


public class BioWebDNA2 {

	
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
		//System.out.println("getDeOxyRibose()    x:" + x + " y: "   + y + "  z:" + z);			
		System.out.println("getDeOxyRibose() at rotated angle: " + angle + "  with radius: " + radius);	
		
		double xScale = 1.0;
		double yScale = 1.0;
		double zScale = 1.0;

		// Make a 5 point ribose sugar molecule
		double[] startPos = {x, y, z};
		String riboseElements[] = {"Carbon", "Carbon", "Oxygen", "Carbon", "Carbon"};
		//double[][] ribosePoints = BioGraphics.createCylinderInPlane(Constants.YPLANE,  startPos,  1.0, displaceAngle);
		double[][] ribosePoints = BioGraphics.createCylinderInPlane(Constants.YPLANE,  startPos,  0.25, riboseElements.length);
		//BioGraphics.dumpPoints("ribosePoints", ribosePoints);


		if (angle > 0.0)
		{
			System.out.println("Rotating DeOxyRibose at angle: " + angle);			
			ribosePoints = BioGraphics.rotateY(ribosePoints, angle);
			//System.out.println("Rotated DeOxyRibose: " + angle);			
		}
		
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
		String riboseActivators[] = 
			{
				
				"(Hydrogen) (Hydrogen)",	
				
				"(Oxygen Hydrogen) (Hydrogen)",   
				
				 // There is nada on the Oxygen molecule
				 "",
				 
				"((Hydrogen Oxygen) (Carbon Hydrogen Hydrogen)) (Hydrogen)", 
				
				"(Hydrogen) (Oxygen Hydrogen)"
			};
		
		
		
	
		// Run through each point of the Pentose and lay in the orbits of the atoms
		System.out.println("ribosePoints length is: " + ribosePoints.length);
		
		for (int j=0; j<ribosePoints.length; j++)
		//for (int j=0; j<2; j++)
		{
			double displaceAngle = 90;	
			double atomRadius = getAtomicRadius(riboseElements[j]);
				
			
			String formula = riboseActivators[j];
	
			
			if (!formula.equals(""))
			{
				//System.out.println("Total CoAtoms in list: " + currentList.length);	
				Stack<Character> stack = new Stack<Character>();
				char c;
				
				// We have to move the arc distance of the base atom
				double totalRadius = atomRadius;
			
		
				for (int i=0; i<formula.length(); i++)
				{						
					c = formula.charAt(i);
					
					
					// Push until we get a closing parenthesis
					while (c!= ')' && i < formula.length())
					{
						stack.push(c);
						System.out.println("Pushing: " + i + " value " + c);
						i++;
						// get the next symbol 
						c = formula.charAt(i); 
					}
					
					// jump by the current character, we do not want to push or pop it
					i++;
			
					// Pop until we get a closing parenthesis
					while (c!= ')')
					{
						c = stack.pop();
						System.out.println("Popping: " + i +  "  value: " +  c);
					}
					
					
				}
	
				
				
				
				
			}
			
		}
		

		return(body);
	}


	/*************************************************************************
	 *  GET DE-OXY-RIBOSE
	 *  
	 *  Creates a Representation of Ribose molecule
	 *  
	 ************************************************************************/ 		

	public static String getDeOxyRibose2(BioMightTransform bioMightTransform, double radius, double angle)  
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
		String riboseElements[] = {"Carbon", "Carbon", "Oxygen", "Carbon", "Carbon"};
		//double[][] ribosePoints = BioGraphics.createCylinderInPlane(Constants.YPLANE,  startPos,  1.0, displaceAngle);
		double[][] ribosePoints = BioGraphics.createCylinderInPlane(Constants.YPLANE,  startPos,  0.25, riboseElements.length);
		//BioGraphics.dumpPoints("ribosePoints", ribosePoints);


		if (angle > 0.0)
		{
			System.out.println("Rotating DeOxyRibose at angle: " + angle);			
			ribosePoints = BioGraphics.rotateY(ribosePoints, angle);
			//System.out.println("Rotated DeOxyRibose: " + angle);			
		}
		
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
		String riboseActivators[][] = {
				
				{"Hydrogen",  "-1",  // H, H
				 "Hydrogen"
				},	
					
				 {"Oxygen", "Hydrogen", "-1", // OH, H	 
				  "Hydrogen"
				},   
				
				 // There is nada on the Oxygen molecule
				 {""},
				 
				
				{"Hydrogen", "Oxygen", "Carbon", "Hydrogen", "Hydrogen", "-1", // HO CH2
				 "Hydrogen"
				}, 
				
				{"Hydrogen",  "-1", // H, OH
				 "Oxygen", "Hydrogen"
				}
		};

		
			
		// Run through each point of the Pentose and lay in the orbits of the atoms
		System.out.println("ribosePoints length is: " + ribosePoints.length);
		
		for (int j=0; j<ribosePoints.length; j++)
		//for (int j=0; j<2; j++)
		{
			double displaceAngle = 90;	
			double atomRadius = getAtomicRadius(riboseElements[j]);
				
			
			String[] currentList = riboseActivators[j];
			
			if (!currentList[0].equals(""))
			{
				System.out.println("Total CoAtoms in list: " + currentList.length);	
			
				// Have to remove the -1 separator
				
				// We have to move the arc distance of the base atom
				double totalRadius = atomRadius;
				for (int i=0; i<currentList.length; i++)
				{						
					// Get the radius of the coAtom
					double coAtomRadius = getAtomicRadius(currentList[i]);
					
					// The ChemBreaks are signified by a -1
					if (currentList[i].equals("-1")) 
					{
						System.out.println("Jumping Atoms: ");
						displaceAngle = 270;	
						
						// Reset the radius to the base atom
						totalRadius = atomRadius;
					}
					else
					{
						System.out.println("Creating X3D for Atom: " + currentList[i] + " with coRadius: " + coAtomRadius + " radius:"  + atomRadius + " at angle: " + displaceAngle);
						totalRadius += coAtomRadius;
						System.out.println("Creating X3D for Radius: " + totalRadius);				
						
						// We are getting two points and then placing the atoms there
						// Have to calculate this orbital 
						double[] displaceAngles = {displaceAngle};
						double[][] alignedPoints = BioGraphics.createCylinderInPlane(Constants.ZPLANE,  ribosePoints[j],  totalRadius, displaceAngles);
						
						// Move to the outside of the current atom
						totalRadius += coAtomRadius;
						
						// Change the height and width based on the displacement.
						body += "\n<Transform DEF='" + currentList[i] + "'\n";
						
			
					 	body += "translation='" 
					 		 	+ (alignedPoints[0][0]) + " " 
					 		 	+ (alignedPoints[0][1]) + " "
								+ (alignedPoints[0][2]) + "'\n";					
						
						
						body +=  "scale='" 	+ xScale + " "
						 					+ yScale + " "
						 					+ zScale + "'>\n" +
			
						 "\n<Shape DEF='" + currentList[i] + "Shape'\n" +
						    " containerField='children'>\n" +
						    " <Appearance\n" +
						    "  containerField='appearance'>\n";
			
					
						body+= " <ImageTexture containerField='texture' " +
						    " url='../images/" + currentList[i] + ".jpg'/>";
													    
						
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
						 	"<Sphere DEF='" + currentList[i] + "Sphere'\n" +
						 	"containerField='geometry'\n" +
						 	"radius='" + coAtomRadius +"'/>\n" +
						 	"</Shape>\n" +
						 	
							"\n<TouchSensor DEF='"+currentList[i]+"Touch' \n" +
			                   " description='"+currentList[i]+"'\n" +
				               " containerField='children'/> \n" +
			
						 "</Transform>\n";
					}
				}
			}
			
		}
		
		


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
	

	/*************************************************************************
	 *  GET ATOM RADIUS
	 *  
	 *  Get the radius for the atom.
	 *  
	 ************************************************************************/ 		
	
	public static double getAtomicRadius(String atom)  
	{
		
	double atomRadius = 0.001;

	if (atom.equals("Hydrogen"))
	{
		atomRadius = 0.01;	
	}
	else if (atom.equals("Carbon"))
	{
		atomRadius = 0.06;	
	}
	else if (atom.equals("Oxygen"))
	{
		atomRadius = 0.08;	
	}
	else 
	{
		atomRadius = 0.01;	
	}	
	
		return(atomRadius);
	}
	
	
}