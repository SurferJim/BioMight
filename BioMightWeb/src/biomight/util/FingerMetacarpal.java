package biomight.util;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FingerMetacarpal {


	public String createX3D()
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


		double xPos = 0.0;
		double yPos = 0.0;
		double zPos = 0.0;
		
	    try {
	        BufferedWriter out = new BufferedWriter(new FileWriter("c:\\3DWork\\abc123.x3d"));
	        out.write(header);
	        
		for (int k=1; k<2; k++)
		{
			xPos = 0.0;
			yPos = 0.0;			
			
			for (int j=1; j<6; j++)
			{
				xPos=0;
				for (int i=0; i<30; i++)
				{
					String body = "<Transform DEF='genSkin" + i*j*k + "'\n" +
						"translation='" + xPos + " " + yPos + " " + zPos + "'>\n" +
						"<Shape DEF='Box" + i*j*k + "'\n" +
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
						"<Box DEF='GeoBox" + i*j*k + "'\n" +
						"containerField='geometry'\n"+
						"size='1 1 1'/>\n" +	
						"</Shape>\n" +
						"</Transform>\n";
					//System.out.println(body);
					out.write(body);
					xPos++;
				}
				yPos++;
			}
			zPos++;
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

		FingerMetacarpal myObj = new FingerMetacarpal();
		myObj.createX3D();
	}

}
