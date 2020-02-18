package biomight.util;

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


public class GenerateX3DClient {
	
	
	
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
					System.out.println(blockStr+ ":  " + df.format(xDispPos)+ "   " +   df.format(yDispPos) + "  " + df.format(zDispPos));
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
				    System.out.println(blockStr+ ":  " + df.format(x)+ "   " +   df.format(y) + "  " + df.format(zDispPos));
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
				    System.out.println(blockStr+ ":  " + df.format(x)+ "   " +   df.format(y) + "  " + df.format(zDispPos));
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
				    System.out.println(blockStr+ ":  " + df.format(x)+ "   " +   df.format(y) + "  " + df.format(zDispPos));
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
				    System.out.println(blockStr+ ":  " + df.format(x)+ "   " +   df.format(y) + "  " + df.format(zDispPos));
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
	
	
	
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		GenerateX3DClient myObj = new GenerateX3DClient();
		// height, width, length
		//myObj.createSection(1.0, 10.0, 40.0, 0.90, 0.0, 0.0);

		//myObj.createGrip(6, 5, 20, 0.5);
		
		
		myObj.createBarrel(10, 1, 20, 0.5);

	
	}

}
