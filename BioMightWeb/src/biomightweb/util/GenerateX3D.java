package biomightweb.util;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;

/*********************************************************************************************************
 * 
 * @author SurferJim
 * 
 * This class generates assemblies of various types, from linear non undulating sections, to 
 * consistent rising plateus, to curvatures and loops.   These sections assist in the creation of 
 * each part.  Rather thatn assembling the BioMight Components block by block, this assemblyine
 * constructs various blockable peices that are assmebled to make what you want.
 *
 *********************************************************************************************************/


// Set up a mesh for this object.  This is what will be stored in the BioMight database
// The  key data points used to contruct a model.  These will be used to generate the 
// X3D that will bring BioMight to life.


public class GenerateX3D {
	
	
	
	/********************************************************************************************************
	 * INJECT OBJECT 
	 * 
	 * This method will add an external 'agent' to the X3D scene
	 * 
	 * ******************************************************************************************************/
	
	public String injectObject(double radius)
	{
		
		// Get the object from the database and then assemble the 3D
		
		String x3d = "";
	    try {
 	        BufferedWriter out = new BufferedWriter(new FileWriter("c:\\3DWork\\abc123.x3d"));
	        out.write(x3d);
					
		
		String footer = "</Scene>\n" + "</X3D>\n";
		//System.out.println(footer);
        out.write(footer);
		
	        out.close();
	    } catch (IOException e) {
		
	    }
		
		return ("");
	}
	
	
	
	public String createSphere(double radius)
	{
		ArrayList meshGroup = new ArrayList(10);
		
		Mesh mesh = new Mesh();
		mesh.setId("base0");
		mesh.setX(0.0);
		
		double[] yDisplace = {5.0, 5.0, 5.0, 3.0, 3.0 };
		//mesh.setY(yValues);
			
		double[] zDisplace = {0.0, 5.0, -5.0, 7.0, -7.0};
		//mesh.setY(zValues);
			
		double[] arc = {0.1, 0.1, 0.1, 0.0, 0.0};
		//meshGroup.add(0,mesh);
	
		String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
		"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n" +
		"<X3D profile='Immersive' >\n" +
		"<head>\n" +
		 "<meta name='BioMightImage' content='Thumb_noseX3D_x3d20259921204721130.jpg'/>\n" +
		 "<meta name='ExportTime' content='7:45:30'/>\n" +
		 "<meta name='ExportDate' content='3/5/2008'/>\n" +
		 "<meta name='BioMight Version' content='1.0'/>\n" + 
		 "<meta name='FluxStudioSource' content='nose.fxw'/>\n" +
		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='nose'\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		
		//System.out.println(header);	

		
	    try {
	        BufferedWriter out = new BufferedWriter(new FileWriter("c:\\3DWork\\abc123.x3d"));
	        out.write(header);
					
		
		String footer = "</Scene>\n" + "</X3D>\n";
		//System.out.println(footer);
        out.write(footer);
		
	        out.close();
	    } catch (IOException e) {
		
	    }
		
		return ("");
	}
	
	

	/***********************************************************************************************************
	 * CreateSection
	 * 
	 * This creates a section or wall of blocks.  It can be shaped through parameters.  Each one starts
	 * at base 0.0.  We can apply a translation to bring them to a different place in the model.
	 *  
	 * @param height
	 * @param width
	 * @param length
	 * @param hDisplace
	 * @param wDisplace
	 * @param lDisplace
	 * @return
	 ***********************************************************************************************************/

	public String createSection(double height, double width, double length, 
			                    double hDisplace, double wDisplace, double lDisplace)
	{

		String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
		"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n" +
		"<X3D profile='Immersive' >\n" +
		"<head>\n" +
		 "<meta name='BioMightImage' content='Thumb_noseX3D_x3d20259921204721130.jpg'/>\n" +
		 "<meta name='ExportTime' content='7:45:30'/>\n" +
		 "<meta name='ExportDate' content='3/5/2008'/>\n" +
		 "<meta name='BioMight Version' content='1.0'/>\n" + 
		 "<meta name='FluxStudioSource' content='nose.fxw'/>\n" +
		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='nose'\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		
		//System.out.println(header);	


		int blockNumber;
		double xDispPos = 0.0;
		double xBasePos = 0.0;
		double yDispPos = 0.0;
		double yBasePos = 0.0;
		double zDispPos = 0.0;
		double zBasePos = 0.0;
		
	    try {
	        BufferedWriter out = new BufferedWriter(new FileWriter("c:\\3DWork\\section.x3d"));
	        out.write(header);
	        
		for (int y=0; y<height; y++)
		{		
			// Cause a repeat of the row of boxes constructed below.  This causes depth.  
			// Set Y back at the beginning mark so that each row increments at the same rate.
			// It has to be offset by the thickness so we can build layers		
			yDispPos=y;
			for (int z=0; z<width; z++)
			{
				// X starts at 0 and we run the line for the specified length.  This gives one row of boxes that runs the x axis
				// It increments at height if specified so that we can add inclination/declination to the row.  
				// It increments at width so that we can taper the width along the row, moving across the z dimension
				// at height where first row started.
				yDispPos=y;
				zDispPos=z;
				for (int x=0; x<length; x++)
				{
					// Increment the x displacement, this can set the steepness of a curve
					xDispPos = x + lDisplace;

					// Change the height and width based on the displacement.
					String blockStr = ""+x+""+y+""+z+"";
				    DecimalFormat df = new DecimalFormat("000.00000");
					//System.out.println(blockStr+ ":  " + df.format(xDispPos)+ "   " +   df.format(yDispPos) + "  " + df.format(zDispPos));
				    String body = "<Transform DEF='genSkin" + blockStr + "'\n" +
						"translation='" + df.format(xDispPos) + " " + df.format(yDispPos) + " " + df.format(zDispPos) + "'>\n" +
						"<Shape DEF='Box"+blockStr+"'\n" +
						"containerField='children'>\n" +
						"<Appearance \n" +
						"containerField='appearance'>\n" +
						"<Material DEF='Shiny_Green'\n" +
						"containerField='material'\n" +
						"ambientIntensity='0.200'\n" +
						"shininess='0.100'\n" +
						"diffuseColor='0 1 0'\n" +
						"specularColor='0 1 0'/>\n" +
						"</Appearance>\n" +
						"<Box DEF='GeoBox" + blockStr + "'\n" +
						"containerField='geometry'\n"+
						"size='1 1 1'/>\n" +	
						"</Shape>\n" +
						"</Transform>\n";
					out.write(body);

					// increment the height by the height + displacement as we create the row
					// This creates a steady slope or declination
					yDispPos += hDisplace;
					
					// increment the width by the displacement
					zDispPos +=  wDisplace;
					
				
				
				}
			}
		}
		
		String footer = "</Scene>\n" + "</X3D>\n";
		//System.out.println(footer);
        out.write(footer);
		
	        out.close();
	    } catch (IOException e) {
		
	    }
		
		return ("");
	}


	/***********************************************************************************************************
	 * CreateV
	 * 
	 * This creates a section or wall of blocks.  It can be shaped through parameters.  Each one starts
	 * at base 0.0. We go for X positions, staying on the y axis, but changing the displacement of Z so
	 * that it creates a symmetrical curve.  It increases in X until the disected middle, and then decreases
	 * in X until it comes back to start point.
	 *  
	 * @param height
	 * @param width
	 * @param length
	 * @param hDisplace
	 * @param wDisplace
	 * @param lDisplace
	 * @return
	 ***********************************************************************************************************/

	public String createV(double height, double width, double length, double wDisplace)
	{

		String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
		"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n" +
		"<X3D profile='Immersive' >\n" +
		"<head>\n" +
		 "<meta name='BioMightImage' content='Thumb_noseX3D_x3d20259921204721130.jpg'/>\n" +
		 "<meta name='ExportTime' content='7:45:30'/>\n" +
		 "<meta name='ExportDate' content='3/5/2008'/>\n" +
		 "<meta name='BioMight Version' content='1.0'/>\n" + 
		 "<meta name='FluxStudioSource' content='nose.fxw'/>\n" +
		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='nose'\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		
		//System.out.println(header);	


		double zDispPos = 0.0;

		
	    try {
	        BufferedWriter out = new BufferedWriter(new FileWriter("c:\\3DWork\\section.x3d"));
	        out.write(header);
	        
		for (int y=0; y<height; y++)
		{		
			// Cause a repeat of the row of boxes constructed below.  This causes depth.  
			// Set Y back at the beginning mark so that each row increments at the same rate.
			// It has to be offset by the thickness so we can build layers		

			for (int z=0; z<width; z++)
			{
				// X starts at 0 and we run the line for the specified length.  This gives one row of boxes that runs the x axis
				// It increments at height if specified so that we can add inclination/declination to the row.  
				// It increments at width so that we can taper the width along the row, moving across the z dimension
				// at height where first row started.
			
				zDispPos=z;
				for (int x=0; x<length; x++)
				{
					
					// Shift the displacement to the negative to make it symmetrical at the middle point.
					int middle = x/2;
					if (x == middle)
						wDisplace = -1 * wDisplace; 
					
					// Change the height and width based on the displacement.
					String blockStr = ""+x+""+y+""+z+"";
				    DecimalFormat df = new DecimalFormat("000.00000");
				    //System.out.println(blockStr+ ":  " + df.format(x)+ "   " +   df.format(y) + "  " + df.format(zDispPos));
				    String body = "<Transform DEF='genSkin" + blockStr + "'\n" +
						"translation='" + df.format(x) + " " + df.format(y) + " " + df.format(zDispPos) + "'>\n" +
						"<Shape DEF='Box"+blockStr+"'\n" +
						"containerField='children'>\n" +
						"<Appearance \n" +
						"containerField='appearance'>\n" +
						"<Material DEF='Shiny_Green'\n" +
						"containerField='material'\n" +
						"ambientIntensity='0.200'\n" +
						"shininess='0.100'\n" +
						"diffuseColor='0 1 0'\n" +
						"specularColor='0 1 0'/>\n" +
						"</Appearance>\n" +
						"<Box DEF='GeoBox" + blockStr + "'\n" +
						"containerField='geometry'\n"+
						"size='1 1 1'/>\n" +	
						"</Shape>\n" +
						"</Transform>\n";
					out.write(body);
					
					// increment the width by the displacement
					zDispPos +=  wDisplace;
				}
			}
		}
		
		String footer = "</Scene>\n" + "</X3D>\n";
		//System.out.println(footer);
        out.write(footer);
		
	        out.close();
	    } catch (IOException e) {
		
	    }
		
		return ("");
	}
	
	
	/***********************************************************************************************************
	 * CreateBarrel
	 * 
	 * This creates a section or wall of blocks.  It can be shaped through parameters.  Each one starts
	 * at base 0.0. We go for X positions, staying on the y axis, but changing the displacement of Z so
	 * that it creates a symmetrical curve.  It increases in X until the disected middle, and then decreases
	 * in X until it comes back to start point.
	 *  
	 * @param height
	 * @param width
	 * @param length
	 * @param hDisplace
	 * @param wDisplace
	 * @param lDisplace
	 * @return
	 ***********************************************************************************************************/

	public String createGrip(double height, double width, double length, double wDisplace)
	{

		String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
		"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n" +
		"<X3D profile='Immersive' >\n" +
		"<head>\n" +
		 "<meta name='BioMightImage' content='Thumb_noseX3D_x3d20259921204721130.jpg'/>\n" +
		 "<meta name='ExportTime' content='7:45:30'/>\n" +
		 "<meta name='ExportDate' content='3/5/2008'/>\n" +
		 "<meta name='BioMight Version' content='1.0'/>\n" + 
		 "<meta name='FluxStudioSource' content='nose.fxw'/>\n" +
		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='nose'\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		
		//System.out.println(header);	


		double zDispPos = 0.0;

		
	    try {
	        BufferedWriter out = new BufferedWriter(new FileWriter("c:\\3DWork\\section.x3d"));
	        out.write(header);

		Double middle = new Double(height/2);
		for (int y=0; y<height; y++)
		{		
			// Cause a repeat of the row of boxes constructed below.  This causes depth.  
			// Set Y back at the beginning mark so that each row increments at the same rate.
			// It has to be offset by the thickness so we can build layers		

			for (int z=0; z<width; z++)
			{
				// X starts at 0 and we run the line for the specified length.  This gives one row of boxes that runs the x axis
				// It increments at height if specified so that we can add inclination/declination to the row.  
				// It increments at width so that we can taper the width along the row, moving across the z dimension
				// at height where first row started.
			
				zDispPos=z;
				for (int x=0; x<length; x++)
				{
					// Shift the displacement to the negative to make it symmetrical at the middle point.
					if (y == middle)
						wDisplace = -1 * wDisplace; 
					
					// Change the height and width based on the displacement.
					String blockStr = ""+x+""+y+""+z+"";
				    DecimalFormat df = new DecimalFormat("000.00000");
				    //System.out.println(blockStr+ ":  " + df.format(x)+ "   " +   df.format(y) + "  " + df.format(zDispPos));
				    String body = "<Transform DEF='genSkin" + blockStr + "'\n" +
						"translation='" + df.format(x) + " " + df.format(y) + " " + df.format(zDispPos) + "'>\n" +
						"<Shape DEF='Box"+blockStr+"'\n" +
						"containerField='children'>\n" +
						"<Appearance \n" +
						"containerField='appearance'>\n" +
						"<Material DEF='Shiny_Green'\n" +
						"containerField='material'\n" +
						"ambientIntensity='0.200'\n" +
						"shininess='0.100'\n" +
						"diffuseColor='0 1 0'\n" +
						"specularColor='0 1 0'/>\n" +
						"</Appearance>\n" +
						"<Box DEF='GeoBox" + blockStr + "'\n" +
						"containerField='geometry'\n"+
						"size='1 1 1'/>\n" +	
						"</Shape>\n" +
						"</Transform>\n";
					out.write(body);
					
					// increment the width by the displacement
					zDispPos +=  wDisplace;
				}
			}
		}
		
		String footer = "</Scene>\n" + "</X3D>\n";
		//System.out.println(footer);
        out.write(footer);
		
	        out.close();
	    } catch (IOException e) {
		
	    }
		
		return ("");
	}
	
	
	/***********************************************************************************************************
	 * CreateBarrel
	 * 
	 * This creates a section or wall of blocks.  It can be shaped through parameters.  Each one starts
	 * at base 0.0. We go for X positions, staying on the y axis, but changing the displacement of Z so
	 * that it creates a symmetrical curve.  It increases in X until the disected middle, and then decreases
	 * in X until it comes back to start point.
	 *  
	 * @param height
	 * @param width
	 * @param length
	 * @param hDisplace
	 * @param wDisplace
	 * @param lDisplace
	 * @return
	 ***********************************************************************************************************/

	public String createSequence(double height, double width, double length, double wDisplace)
	{

		String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
		"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n" +
		"<X3D profile='Immersive' >\n" +
		"<head>\n" +
		 "<meta name='BioMightImage' content='Thumb_noseX3D_x3d20259921204721130.jpg'/>\n" +
		 "<meta name='ExportTime' content='7:45:30'/>\n" +
		 "<meta name='ExportDate' content='3/5/2008'/>\n" +
		 "<meta name='BioMight Version' content='1.0'/>\n" + 
		 "<meta name='FluxStudioSource' content='nose.fxw'/>\n" +
		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='nose'\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		
		//System.out.println(header);	


		double zDispPos = 0.0;

	    try {
	        BufferedWriter out = new BufferedWriter(new FileWriter("c:\\3DWork\\section.x3d"));
	        out.write(header);

		Double middle = new Double(height/2);
		for (int y=0; y<height; y++)
		{		
			// Cause a repeat of the row of boxes constructed below.  This causes depth.  
			// Set Y back at the beginning mark so that each row increments at the same rate.
			// It has to be offset by the thickness so we can build layers		
			

				for (int x=0; x<length; x++)
				{
					// Shift the displacement to the negative to make it symmetrical at the middle point.
					if (y == middle)
						wDisplace = -1 * wDisplace; 
					
					// Change the height and width based on the displacement.
					String blockStr = ""+x+""+y+""+"1";
				    DecimalFormat df = new DecimalFormat("000.00000");
				    //System.out.println(blockStr+ ":  " + df.format(x)+ "   " +   df.format(y) + "  " + df.format(zDispPos));
				    String body = "<Transform DEF='genSkin" + blockStr + "'\n" +
						"translation='" + df.format(x) + " " + df.format(y) + " " + df.format(zDispPos) + "'>\n" +
						"<Shape DEF='Box"+blockStr+"'\n" +
						"containerField='children'>\n" +
						"<Appearance \n" +
						"containerField='appearance'>\n" +
						"<Material DEF='Shiny_Green'\n" +
						"containerField='material'\n" +
						"ambientIntensity='0.200'\n" +
						"shininess='0.100'\n" +
						"diffuseColor='0 1 0'\n" +
						"specularColor='0 1 0'/>\n" +
						"</Appearance>\n" +
						"<Box DEF='GeoBox" + blockStr + "'\n" +
						"containerField='geometry'\n"+
						"size='1 1 1'/>\n" +	
						"</Shape>\n" +
						"</Transform>\n";
					out.write(body);
					
					// increment the width by the displacement
					zDispPos +=  wDisplace;
				}
			}
		
		String footer = "</Scene>\n" + "</X3D>\n";
		//System.out.println(footer);
        out.write(footer);
		
	        out.close();
	    } catch (IOException e) {
		
	    }
		
		return ("");
	}
	
	
	/***********************************************************************************************************
	 * CreateBarrel
	 * 
	 * This creates a section or wall of blocks.  It can be shaped through parameters.  Each one starts
	 * at base 0.0. We go for X positions, staying on the y axis, but changing the displacement of Z so
	 * that it creates a symmetrical curve.  It increases in X until the disected middle, and then decreases
	 * in X until it comes back to start point.
	 *  
	 * @param height
	 * @param width
	 * @param length
	 * @param hDisplace
	 * @param wDisplace
	 * @param lDisplace
	 * @return
	 ***********************************************************************************************************/

	public String createBarrel(double height, double width, double length, double wDisplace)
	{

		String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
		"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n" +
		"<X3D profile='Immersive' >\n" +
		"<head>\n" +
		 "<meta name='BioMightImage' content='Thumb_noseX3D_x3d20259921204721130.jpg'/>\n" +
		 "<meta name='ExportTime' content='7:45:30'/>\n" +
		 "<meta name='ExportDate' content='3/5/2008'/>\n" +
		 "<meta name='BioMight Version' content='1.0'/>\n" + 
		 "<meta name='FluxStudioSource' content='nose.fxw'/>\n" +
		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='nose'\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		
		//System.out.println(header);	


		
	    try {
	        BufferedWriter out = new BufferedWriter(new FileWriter("c:\\3DWork\\section.x3d"));
	        out.write(header);

	    double zDispPos = 0.0;
		Double middle = new Double(height/2);
		boolean once = true;
		for (int y=0; y<height; y++)
		{		
			//zDispPos += wDisplace;
			
			// Cause a repeat of the row of boxes constructed below.  This causes depth.  
			// Set Y back at the beginning mark so that each row increments at the same rate.
			// It has to be offset by the thickness so we can build layers		
			
			// Shift the displacement to the negative to make it symmetrical at the middle point.
			if (y > middle && once)
			{
				wDisplace = -1 * wDisplace;
				once = false;
			}
			
				for (int x=0; x<length; x++)
				{					
					// Change the height and width based on the displacement.
					String blockStr = ""+x+""+y+""+"1";
				    DecimalFormat df = new DecimalFormat("000.00000");
				    //System.out.println(blockStr+ ":  " + df.format(x)+ "   " +   df.format(y) + "  " + df.format(zDispPos));
				    String body = "<Transform DEF='genSkin" + blockStr + "'\n" +
						"translation='" + df.format(x) + " " + df.format(y) + " " + df.format(zDispPos) + "'>\n" +
						"<Shape DEF='Box"+blockStr+"'\n" +
						"containerField='children'>\n" +
						"<Appearance \n" +
						"containerField='appearance'>\n" +
						"<Material DEF='Shiny_Green'\n" +
						"containerField='material'\n" +
						"ambientIntensity='0.200'\n" +
						"shininess='0.100'\n" +
						"diffuseColor='0 1 0'\n" +
						"specularColor='0 1 0'/>\n" +
						"</Appearance>\n" +
						"<Box DEF='GeoBox" + blockStr + "'\n" +
						"containerField='geometry'\n"+
						"size='1 1 1'/>\n" +	
						"</Shape>\n" +
						"</Transform>\n";
					out.write(body);
				}
				// increment the width by the displacement
				zDispPos +=  wDisplace;
		}
		
		String footer = "</Scene>\n" + "</X3D>\n";
		//System.out.println(footer);
        out.write(footer);
		
	        out.close();
	    } catch (IOException e) {
		
	    }
		
		return ("");
	}
	

	/***********************************************************************************************************
	 * Create Frame
	 *  
	 * @param height
	 * @param width
	 * @param length
	 * @param hDisplace
	 * @param wDisplace
	 * @param lDisplace
	 * @return
	 ***********************************************************************************************************/
/*
	public String createFrame()
	{

		String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
		"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n" +
		"<X3D profile='Immersive' >\n" +
		"<head>\n" +
		 "<meta name='BioMightImage' content='Frame.jpg'/>\n" +
		 "<meta name='ExportTime' content='7:45:30'/>\n" +
		 "<meta name='ExportDate' content='3/5/2008'/>\n" +
		 "<meta name='BioMight Version' content='1.0'/>\n" + 
		 "<meta name='FluxStudioSource' content='Frame.fxw'/>\n" +
		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='Frame'\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		
		//System.out.println(header);	


		
	    try {
	        BufferedWriter out = new BufferedWriter(new FileWriter("C:\\RadSpace\\BioMight\\BioMightWeb\\WebContent\\x3d\\Frame.x3d"));
	        // Add the header
	        out.write(header);

	        String frame = "<Transform DEF='dad_Sphere1'\n" +
	        	 "translation='-.08214 -.00201 .08659'\n" +
	        	 "scale='1 1.87814 1'>\n" +
	        	 "<Shape DEF='Sphere1'\n" +
	        	  "containerField='children'>\n" +
	        	  "<Appearance\n" +
	        	   "containerField='appearance'>\n" +
	        	   "<Material DEF='Blue'\n" +
	        	    "containerField='material'\n" +
	        	    "ambientIntensity='0.200'\n" +
	        	    "shininess='0.200'\n" +
	        	    "diffuseColor='0 0 1'/>\n" +
	        	  "</Appearance>\n" +
	        	  "<IndexedFaceSet DEF='Sphere1_Geo'\n" +
	        	   "containerField='geometry'\n" +
	        	   "creaseAngle='0.524'\n" +
	        	   "coordIndex='\n" +
	        	   
	        	     //'>
	        	   
	        	   
	        	   
	        	   "<Coordinate DEF='Sphere1_Coord'\n" +
	        	    "containerField='coord'\n" +
	        	    "point='\n" +
	        	    
	        	    	
	        	   "'/>\n" +
	        	    
	        	    
	     
	        	  </IndexedFaceSet>
	        	 </Shape>
	        	</Transform>
	        	<Transform DEF='dad_Sphere2'
	        	 translation='-.08344 0 .08397'
	        	 rotation='.507 0 .862 3.142'
	        	 scale='1 1.87814 1'>
	        	 <Shape DEF='Sphere2'
	        	  containerField='children'>
	        	  <Appearance
	        	   containerField='appearance'>
	        	   <Material DEF='Shiny_White'
	        	    containerField='material'
	        	    ambientIntensity='0.200'
	        	    shininess='0.100'
	        	    diffuseColor='1 1 1'
	        	    specularColor='1 1 1'/>
	        	  </Appearance>
	        	  <IndexedFaceSet DEF='Sphere2_Geo'
	        	   containerField='geometry'
	        	   creaseAngle='0.524'
	        	   coordIndex='
	        	     0 1 2 -1
	        	     1 3 2 -1
	        	     3 4 2 -1
	        	     4 5 2 -1
	        	     5 6 2 -1
	        	     6 7 2 -1
	        	     7 8 2 -1
	        	     8 9 2 -1
	        	     9 10 2 -1
	        	     10 11 2 -1
	        	     11 12 2 -1
	        	     12 13 2 -1
	        	     13 14 2 -1
	        	     14 15 2 -1
	        	     15 16 2 -1
	        	     16 0 2 -1
	        	     0 17 18 -1
	        	     18 1 0 -1
	        	     1 18 19 -1
	        	     19 3 1 -1
	        	     3 19 20 -1
	        	     20 4 3 -1
	        	     4 20 21 -1
	        	     21 5 4 -1
	        	     5 21 22 -1
	        	     22 6 5 -1
	        	     6 22 23 -1
	        	     23 7 6 -1
	        	     7 23 24 -1
	        	     24 8 7 -1
	        	     8 24 25 -1
	        	     25 9 8 -1
	        	     9 25 26 -1
	        	     26 10 9 -1
	        	     10 26 27 -1
	        	     27 11 10 -1
	        	     11 27 28 -1
	        	     28 12 11 -1
	        	     12 28 29 -1
	        	     29 13 12 -1
	        	     13 29 30 -1
	        	     30 14 13 -1
	        	     14 30 31 -1
	        	     31 15 14 -1
	        	     15 31 32 -1
	        	     32 16 15 -1
	        	     16 32 17 -1
	        	     17 0 16 -1
	        	     17 33 34 -1
	        	     34 18 17 -1
	        	     18 34 35 -1
	        	     35 19 18 -1
	        	     19 35 36 -1
	        	     36 20 19 -1
	        	     20 36 37 -1
	        	     37 21 20 -1
	        	     21 37 38 -1
	        	     38 22 21 -1
	        	     22 38 39 -1
	        	     39 23 22 -1
	        	     23 39 40 -1
	        	     40 24 23 -1
	        	     24 40 41 -1
	        	     41 25 24 -1
	        	     25 41 42 -1
	        	     42 26 25 -1
	        	     26 42 43 -1
	        	     43 27 26 -1
	        	     27 43 44 -1
	        	     44 28 27 -1
	        	     28 44 45 -1
	        	     45 29 28 -1
	        	     29 45 46 -1
	        	     46 30 29 -1
	        	     30 46 47 -1
	        	     47 31 30 -1
	        	     31 47 48 -1
	        	     48 32 31 -1
	        	     32 48 33 -1
	        	     33 17 32 -1
	        	     33 49 50 -1
	        	     50 34 33 -1
	        	     34 50 51 -1
	        	     51 35 34 -1
	        	     35 51 52 -1
	        	     52 36 35 -1
	        	     36 52 53 -1
	        	     53 37 36 -1
	        	     37 53 54 -1
	        	     54 38 37 -1
	        	     38 54 55 -1
	        	     55 39 38 -1
	        	     39 55 56 -1
	        	     56 40 39 -1
	        	     40 56 57 -1
	        	     57 41 40 -1
	        	     41 57 58 -1
	        	     58 42 41 -1
	        	     42 58 59 -1
	        	     59 43 42 -1
	        	     43 59 60 -1
	        	     60 44 43 -1
	        	     44 60 61 -1
	        	     61 45 44 -1
	        	     45 61 62 -1
	        	     62 46 45 -1
	        	     46 62 63 -1
	        	     63 47 46 -1
	        	     47 63 64 -1
	        	     64 48 47 -1
	        	     48 64 49 -1
	        	     49 33 48 -1
	        	     49 65 66 -1
	        	     66 50 49 -1
	        	     50 66 67 -1
	        	     67 51 50 -1
	        	     51 67 68 -1
	        	     68 52 51 -1
	        	     52 68 69 -1
	        	     69 53 52 -1
	        	     53 69 70 -1
	        	     70 54 53 -1
	        	     54 70 71 -1
	        	     71 55 54 -1
	        	     55 71 72 -1
	        	     72 56 55 -1
	        	     56 72 73 -1
	        	     73 57 56 -1
	        	     57 73 74 -1
	        	     74 58 57 -1
	        	     58 74 75 -1
	        	     75 59 58 -1
	        	     59 75 76 -1
	        	     76 60 59 -1
	        	     60 76 77 -1
	        	     77 61 60 -1
	        	     61 77 78 -1
	        	     78 62 61 -1
	        	     62 78 79 -1
	        	     79 63 62 -1
	        	     63 79 80 -1
	        	     80 64 63 -1
	        	     64 80 65 -1
	        	     65 49 64 -1
	        	     65 81 82 -1
	        	     82 66 65 -1
	        	     66 82 83 -1
	        	     83 67 66 -1
	        	     67 83 84 -1
	        	     84 68 67 -1
	        	     68 84 85 -1
	        	     85 69 68 -1
	        	     69 85 86 -1
	        	     86 70 69 -1
	        	     70 86 87 -1
	        	     87 71 70 -1
	        	     71 87 88 -1
	        	     88 72 71 -1
	        	     72 88 89 -1
	        	     89 73 72 -1
	        	     73 89 90 -1
	        	     90 74 73 -1
	        	     74 90 91 -1
	        	     91 75 74 -1
	        	     75 91 92 -1
	        	     92 76 75 -1
	        	     76 92 93 -1
	        	     93 77 76 -1
	        	     77 93 94 -1
	        	     94 78 77 -1
	        	     78 94 95 -1
	        	     95 79 78 -1
	        	     79 95 96 -1
	        	     96 80 79 -1
	        	     80 96 81 -1
	        	     81 65 80 -1
	        	     81 97 98 -1
	        	     98 82 81 -1
	        	     82 98 99 -1
	        	     99 83 82 -1
	        	     83 99 100 -1
	        	     100 84 83 -1
	        	     84 100 101 -1
	        	     101 85 84 -1
	        	     85 101 102 -1
	        	     102 86 85 -1
	        	     86 102 103 -1
	        	     103 87 86 -1
	        	     87 103 104 -1
	        	     104 88 87 -1
	        	     88 104 105 -1
	        	     105 89 88 -1
	        	     89 105 106 -1
	        	     106 90 89 -1
	        	     90 106 107 -1
	        	     107 91 90 -1
	        	     91 107 108 -1
	        	     108 92 91 -1
	        	     92 108 109 -1
	        	     109 93 92 -1
	        	     93 109 110 -1
	        	     110 94 93 -1
	        	     94 110 111 -1
	        	     111 95 94 -1
	        	     95 111 112 -1
	        	     112 96 95 -1
	        	     96 112 97 -1
	        	     97 81 96 -1
	        	     97 113 114 -1
	        	     114 98 97 -1
	        	     98 114 115 -1
	        	     115 99 98 -1
	        	     99 115 116 -1
	        	     116 100 99 -1
	        	     100 116 117 -1
	        	     117 101 100 -1
	        	     101 117 118 -1
	        	     118 102 101 -1
	        	     102 118 119 -1
	        	     119 103 102 -1
	        	     103 119 120 -1
	        	     120 104 103 -1
	        	     104 120 121 -1
	        	     121 105 104 -1
	        	     105 121 122 -1
	        	     122 106 105 -1
	        	     106 122 123 -1
	        	     123 107 106 -1
	        	     107 123 124 -1
	        	     124 108 107 -1
	        	     108 124 125 -1
	        	     125 109 108 -1
	        	     109 125 126 -1
	        	     126 110 109 -1
	        	     110 126 127 -1
	        	     127 111 110 -1
	        	     111 127 128 -1
	        	     128 112 111 -1
	        	     112 128 113 -1
	        	     113 97 112 -1'>
	        	   <Coordinate DEF='Sphere2_Coord'
	        	    containerField='coord'
	        	    point='
	        	     0 -.98079 -.19509
	        	     .07466 -.98079 -.18024
	        	     0 -1 0
	        	     .13795 -.98079 -.13795
	        	     .18024 -.98079 -.07466
	        	     .19509 -.98079 0
	        	     .18024 -.98079 .07466
	        	     .13795 -.98079 .13795
	        	     .07466 -.98079 .18024
	        	     -0 -.98079 .19509
	        	     -.07466 -.98079 .18024
	        	     -.13795 -.98079 .13795
	        	     -.18024 -.98079 .07466
	        	     -.19509 -.98079 -0
	        	     -.18024 -.98079 -.07466
	        	     -.13795 -.98079 -.13795
	        	     -.07466 -.98079 -.18024
	        	     0 -.92388 -.38268
	        	     .14645 -.92388 -.35355
	        	     .2706 -.92388 -.2706
	        	     .35355 -.92388 -.14645
	        	     .38268 -.92388 0
	        	     .35355 -.92388 .14645
	        	     .2706 -.92388 .2706
	        	     .14645 -.92388 .35355
	        	     -0 -.92388 .38268
	        	     -.14645 -.92388 .35355
	        	     -.2706 -.92388 .2706
	        	     -.35355 -.92388 .14645
	        	     -.38268 -.92388 -0
	        	     -.35355 -.92388 -.14645
	        	     -.2706 -.92388 -.2706
	        	     -.14645 -.92388 -.35355
	        	     0 -.83147 -.55557
	        	     .21261 -.83147 -.51328
	        	     .39285 -.83147 -.39285
	        	     .51328 -.83147 -.21261
	        	     .55557 -.83147 0
	        	     .51328 -.83147 .21261
	        	     .39285 -.83147 .39285
	        	     .21261 -.83147 .51328
	        	     -0 -.83147 .55557
	        	     -.21261 -.83147 .51328
	        	     -.39285 -.83147 .39285
	        	     -.51328 -.83147 .21261
	        	     -.55557 -.83147 -0
	        	     -.51328 -.83147 -.21261
	        	     -.39285 -.83147 -.39285
	        	     -.21261 -.83147 -.51328
	        	     0 -.70711 -.70711
	        	     .2706 -.70711 -.65328
	        	     .5 -.70711 -.5
	        	     .65328 -.70711 -.2706
	        	     .70711 -.70711 0
	        	     .65328 -.70711 .2706
	        	     .5 -.70711 .5
	        	     .2706 -.70711 .65328
	        	     -0 -.70711 .70711
	        	     -.2706 -.70711 .65328
	        	     -.5 -.70711 .5
	        	     -.65328 -.70711 .2706
	        	     -.70711 -.70711 -0
	        	     -.65328 -.70711 -.2706
	        	     -.5 -.70711 -.5
	        	     -.2706 -.70711 -.65328
	        	     0 -.55557 -.83147
	        	     .31819 -.55557 -.76818
	        	     .58794 -.55557 -.58794
	        	     .76818 -.55557 -.31819
	        	     .83147 -.55557 0
	        	     .76818 -.55557 .31819
	        	     .58794 -.55557 .58794
	        	     .31819 -.55557 .76818
	        	     -0 -.55557 .83147
	        	     -.31819 -.55557 .76818
	        	     -.58794 -.55557 .58794
	        	     -.76818 -.55557 .31819
	        	     -.83147 -.55557 -0
	        	     -.76818 -.55557 -.31819
	        	     -.58794 -.55557 -.58794
	        	     -.31819 -.55557 -.76818
	        	     0 -.38268 -.92388
	        	     .35355 -.38268 -.85355
	        	     .65328 -.38268 -.65328
	        	     .85355 -.38268 -.35355
	        	     .92388 -.38268 0
	        	     .85355 -.38268 .35355
	        	     .65328 -.38268 .65328
	        	     .35355 -.38268 .85355
	        	     -0 -.38268 .92388
	        	     -.35355 -.38268 .85355
	        	     -.65328 -.38268 .65328
	        	     -.85355 -.38268 .35355
	        	     -.92388 -.38268 -0
	        	     -.85355 -.38268 -.35355
	        	     -.65328 -.38268 -.65328
	        	     -.35355 -.38268 -.85355
	        	     0 -.19509 -.98079
	        	     .37533 -.19509 -.90613
	        	     .69352 -.19509 -.69352
	        	     .90613 -.19509 -.37533
	        	     .98079 -.19509 0
	        	     .90613 -.19509 .37533
	        	     .69352 -.19509 .69352
	        	     .37533 -.19509 .90613
	        	     -0 -.19509 .98079
	        	     -.37533 -.19509 .90613
	        	     -.69352 -.19509 .69352
	        	     -.90613 -.19509 .37533
	        	     -.98079 -.19509 -0
	        	     -.90613 -.19509 -.37533
	        	     -.69352 -.19509 -.69352
	        	     -.37533 -.19509 -.90613
	        	     0 0 -1
	        	     .38268 0 -.92388
	        	     .70711 0 -.70711
	        	     .92388 0 -.38268
	        	     1 0 0
	        	     .92388 0 .38268
	        	     .70711 0 .70711
	        	     .38268 0 .92388
	        	     -0 0 1
	        	     -.38268 0 .92388
	        	     -.70711 0 .70711
	        	     -.92388 0 .38268
	        	     -1 0 -0
	        	     -.92388 0 -.38268
	        	     -.70711 0 -.70711
	        	     -.38268 0 -.92388'/>
	        	  </IndexedFaceSet>
	        	 </Shape>
	        	</Transform>
	        	<Transform DEF='dad_Background1'
	        	 scale='5 5 5'>
	        	 <Background DEF='Background1'
	        	  containerField='children'
	        	  skyAngle=''
	        	  skyColor='
	        	   1 1 1'
	        	  groundAngle=''
	        	  groundColor='
	        	   1 1 1'/>
	        	</Transform>	        
	        
	        
	        // Add the Footer
	        String footer = "</Scene>\n" + "</X3D>\n";
	        out.write(footer);
		
	        out.close();
	    } catch (IOException e) {
		
	    }
		
		return ("");
	}
		
	


	public String createFaceSet1()
	{
	int = {  	
	0 1 2 -1,
    1 3 2 -1,
    3 4 2 -1,
    4 5 2 -1,
    5 6 2 -1,
    6 7 2 -1,
    7 8 2 -1,
    8 9 2 -1,
    9 10 2 -1,
    10 11 2 -1,
    11 12 2 -1,
    12 13 2 -1,
    13 14 2 -1,
    14 15 2 -1,
    15 16 2 -1,
    16 0 2 -1,
    0 17 18 -1,
    18 1 0 -1,
    1 18 19 -1,
    19 3 1 -1,
    3 19 20 -1,
    20 4 3 -1,
    4 20 21 -1,
    21 5 4 -1,
    5 21 22 -1,
    22 6 5 -1,
    6 22 23 -1,
    23 7 6 -1,
    7 23 24 -1,
    24 8 7 -1,
    8 24 25 -1,
    25 9 8 -1,
    9 25 26 -1,
    26 10 9 -1,
    10 26 27 -1,
    27 11 10 -1,
    11 27 28 -1,
    28 12 11 -1,
    12 28 29 -1,
    29 13 12 -1,
    13 29 30 -1,
    30 14 13 -1,
    14 30 31 -1,
    31 15 14 -1,
    15 31 32 -1,
    32 16 15 -1,
    16 32 17 -1,
    17 0 16 -1,
    17 33 34 -1,
    34 18 17 -1,
    18 34 35 -1,
    35 19 18 -1,
    19 35 36 -1,
    36 20 19 -1,
    20 36 37 -1,
    37 21 20 -1,
    21 37 38 -1,
    38 22 21 -1,
    22 38 39 -1,
    39 23 22 -1,
    23 39 40 -1,
    40 24 23 -1,
    24 40 41 -1,
    41 25 24 -1,
    25 41 42 -1,
    42 26 25 -1,
    26 42 43 -1,
    43 27 26 -1,
    27 43 44 -1,
    44 28 27 -1,
    28 44 45 -1,
    45 29 28 -1,
    29 45 46 -1,
    46 30 29 -1,
    30 46 47 -1,
    47 31 30 -1,
    31 47 48 -1,
    48 32 31 -1,
    32 48 33 -1,
    33 17 32 -1,
    33 49 50 -1,
    50 34 33 -1,
    34 50 51 -1,
    51 35 34 -1,
    35 51 52 -1,
    52 36 35 -1,
    36 52 53 -1,
    53 37 36 -1,
    37 53 54 -1,
    54 38 37 -1,
    38 54 55 -1,
    55 39 38 -1,
    39 55 56 -1,
    56 40 39 -1,
    40 56 57 -1,
    57 41 40 -1,
    41 57 58 -1,
    58 42 41 -1,
    42 58 59 -1,
    59 43 42 -1,
    43 59 60 -1,
    60 44 43 -1,
    44 60 61 -1,
    61 45 44 -1,
    45 61 62 -1,
    62 46 45 -1,
    46 62 63 -1,
    63 47 46 -1,
    47 63 64 -1,
    64 48 47 -1,
    48 64 49 -1,
    49 33 48 -1,
    49 65 66 -1,
    66 50 49 -1,
    50 66 67 -1,
    67 51 50 -1,
    51 67 68 -1,
    68 52 51 -1,
    52 68 69 -1,
    69 53 52 -1,
    53 69 70 -1,
    70 54 53 -1,
    54 70 71 -1,
    71 55 54 -1,
    55 71 72 -1,
    72 56 55 -1,
    56 72 73 -1,
    73 57 56 -1,
    57 73 74 -1,
    74 58 57 -1,
    58 74 75 -1,
    75 59 58 -1,
    59 75 76 -1,
    76 60 59 -1,
    60 76 77 -1,
    77 61 60 -1,
    61 77 78 -1,
    78 62 61 -1,
    62 78 79 -1,
    79 63 62 -1,
    63 79 80 -1,
    80 64 63 -1,
    64 80 65 -1,
    65 49 64 -1,
    65 81 82 -1,
    82 66 65 -1,
    66 82 83 -1,
    83 67 66 -1,
    67 83 84 -1,
    84 68 67 -1,
    68 84 85 -1,
    85 69 68 -1,
    69 85 86 -1,
    86 70 69 -1,
    70 86 87 -1,
    87 71 70 -1,
    71 87 88 -1,
    88 72 71 -1,
    72 88 89 -1,
    89 73 72 -1,
    73 89 90 -1,
    90 74 73 -1,
    74 90 91 -1,
    91 75 74 -1,
    75 91 92 -1,
    92 76 75 -1,
    76 92 93 -1,
    93 77 76 -1,
    77 93 94 -1,
    94 78 77 -1,
    78 94 95 -1,
    95 79 78 -1,
    79 95 96 -1,
    96 80 79 -1,
    80 96 81 -1,
    81 65 80 -1,
    81 97 98 -1,
    98 82 81 -1,
    82 98 99 -1,
    99 83 82 -1,
    83 99 100 -1,
    100 84 83 -1,
    84 100 101 -1,
    101 85 84 -1,
    85 101 102 -1,
    102 86 85 -1,
    86 102 103 -1,
    103 87 86 -1,
    87 103 104 -1,
    104 88 87 -1,
    88 104 105 -1,
    105 89 88 -1,
    89 105 106 -1,
    106 90 89 -1,
    90 106 107 -1,
    107 91 90 -1,
    91 107 108 -1,
    108 92 91 -1,
    92 108 109 -1,
    109 93 92 -1,
    93 109 110 -1,
    110 94 93 -1,
    94 110 111 -1,
    111 95 94 -1,
    95 111 112 -1,
    112 96 95 -1,
    96 112 97 -1,
    97 81 96 -1,
    97 113 114 -1,
    114 98 97 -1,
    98 114 115 -1,
    115 99 98 -1,
    99 115 116 -1,
    116 100 99 -1,
    100 116 117 -1,
    117 101 100 -1,
    101 117 118 -1,
    118 102 101 -1,
    102 118 119 -1,
    119 103 102 -1,
    103 119 120 -1,
    120 104 103 -1,
    104 120 121 -1,
    121 105 104 -1,
    105 121 122 -1,
    122 106 105 -1,
    106 122 123 -1,
    123 107 106 -1,
    107 123 124 -1,
    124 108 107 -1,
    108 124 125 -1,
    125 109 108 -1,
    109 125 126 -1,
    126 110 109 -1,
    110 126 127 -1,
    127 111 110 -1,
    111 127 128 -1,
    128 112 111 -1,
    112 128 113 -1,
    113 97 112 -1}
	
	return "";
	}
	
	
	
	
	public String createFaceSet2()
	{
	double = { 
			 {0, -.98079, -.19509},
			 {.07466, -.98079, -.18024},
			 {0, -1, 0,}
			 {.13795, -.98079, -.13795}
			 {.18024 -.98079 -.07466
			{.19509 -.98079 0
			{.18024 -.98079 .07466
			{.13795 -.98079 .13795
			{.07466 -.98079 .18024
			{-0 -.98079 .19509
			{-.07466 -.98079 .18024
			{-.13795 -.98079 .13795
			{-.18024 -.98079 .07466
			{-.19509 -.98079 -0
			{-.18024 -.98079 -.07466
			{-.13795 -.98079 -.13795
			{-.07466 -.98079 -.18024
			{0 -.92388 -.38268
			{.14645 -.92388 -.35355
			{.2706 -.92388 -.2706
			{.35355 -.92388 -.14645
			{.38268 -.92388 0
			{.35355 -.92388 .14645
			{.2706 -.92388 .2706
			{.14645 -.92388 .35355
			{-0 -.92388 .38268
			-.14645 -.92388 .35355
			-.2706 -.92388 .2706
			-.35355 -.92388 .14645
			-.38268 -.92388 -0
			-.35355 -.92388 -.14645
			-.2706 -.92388 -.2706
			-.14645 -.92388 -.35355
			0 -.83147 -.55557
			.21261 -.83147 -.51328
			.39285 -.83147 -.39285
			.51328 -.83147 -.21261
			.55557 -.83147 0
			.51328 -.83147 .21261
			.39285 -.83147 .39285
			.21261 -.83147 .51328
			-0 -.83147 .55557
			-.21261 -.83147 .51328
			-.39285 -.83147 .39285
			-.51328 -.83147 .21261
			-.55557 -.83147 -0
			-.51328 -.83147 -.21261
			-.39285 -.83147 -.39285
			-.21261 -.83147 -.51328
			0 -.70711 -.70711
			.2706 -.70711 -.65328
			.5 -.70711 -.5
			.65328 -.70711 -.2706
			.70711 -.70711 0
			.65328 -.70711 .2706
			.5 -.70711 .5
			.2706 -.70711 .65328
			-0 -.70711 .70711
			-.2706 -.70711 .65328
			-.5 -.70711 .5
			-.65328 -.70711 .2706
			-.70711 -.70711 -0
			-.65328 -.70711 -.2706
			-.5 -.70711 -.5
			-.2706 -.70711 -.65328
			0 -.55557 -.83147
			.31819 -.55557 -.76818
			.58794 -.55557 -.58794
			.76818 -.55557 -.31819
			.83147 -.55557 0
			.76818 -.55557 .31819
			.58794 -.55557 .58794
			.31819 -.55557 .76818
			-0 -.55557 .83147
			-.31819 -.55557 .76818
			-.58794 -.55557 .58794
			-.76818 -.55557 .31819
			-.83147 -.55557 -0
			-.76818 -.55557 -.31819
			-.58794 -.55557 -.58794
			-.31819 -.55557 -.76818
			0 -.38268 -.92388
			.35355 -.38268 -.85355
			.65328 -.38268 -.65328
			.85355 -.38268 -.35355
			.92388 -.38268 0
			.85355 -.38268 .35355
			.65328 -.38268 .65328
			.35355 -.38268 .85355
			-0 -.38268 .92388
			-.35355 -.38268 .85355
			-.65328 -.38268 .65328
			-.85355 -.38268 .35355
			-.92388 -.38268 -0
			-.85355 -.38268 -.35355
			-.65328 -.38268 -.65328
			-.35355 -.38268 -.85355
			0 -.19509 -.98079
.37533 -.19509 -.90613
.69352 -.19509 -.69352
.90613 -.19509 -.37533
.98079 -.19509 0
.90613 -.19509 .37533
.69352 -.19509 .69352
.37533 -.19509 .90613
-0 -.19509 .98079
-.37533 -.19509 .90613
-.69352 -.19509 .69352
-.90613 -.19509 .37533
-.98079 -.19509 -0
-.90613 -.19509 -.37533
-.69352 -.19509 -.69352
-.37533 -.19509 -.90613
0 0 -1
.38268 0 -.92388
.70711 0 -.70711
.92388 0 -.38268
1 0 0
.92388 0 .38268
.70711 0 .70711
.38268 0 .92388
-0 0 1
-.38268 0 .92388
-.70711 0 .70711
-.92388 0 .38268
-1 0 -0
-.92388 0 -.38268
-.70711 0 -.70711
-.38268 0 -.92388
	}

	return "";
	}

*/
	        	   
	        	   
}
