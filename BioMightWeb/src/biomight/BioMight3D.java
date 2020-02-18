package biomight;

import java.io.FileReader;

import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;



public class BioMight3D extends DefaultHandler {

	public BioMight3D()
	{
		super();
	}
		
	// Load an X3D file from the file system.
	public void loadX3D (String x3dFile)
	{

		try {
				
		String path = "C:\\RadSpace\\BioMight\\BioMightWeb\\WebContent\\x3d\\" + x3dFile + ".x3d";
		
		//System.out.println("Loading file: " + path);
		XMLReader xr = XMLReaderFactory.createXMLReader();
		//System.out.println("Created Reader");
		BioMight3D handler = new BioMight3D();
		xr.setContentHandler(handler);
		xr.setErrorHandler(handler);
		//System.out.println("Setup Handlers");
		FileReader r = new FileReader(path);
		//System.out.println("Setup Reader");
		xr.parse(new InputSource(r));
		
		//System.out.println("Parsed file: " + x3dFile);
		}
		catch (Exception e)
		{
			System.out.println("Parse Failed: " + e);
		}
	}
	
	
	
	public void startElement (String uri, String name, String qName, Attributes attrs)
    {
    	
    	if (name.equals("Material"))
    	{
    		System.out.println("MATERIAL: " + uri + "  " + name +  "  " + qName);
            if (attrs != null) {
                int len = attrs.getLength();
                for (int i = 0; i < len; i++) {
                	//if (attrs.getQName(i).contains("DEF"))
                	//{
                    	System.out.println(' ');
                    	System.out.println(attrs.getQName(i));
                    	System.out.println("=\"");
                    	System.out.println(attrs.getValue(i));
                    	System.out.println('"');                		
                	//}
                }
            }
    	}
    	
    }

    public void endElement (String uri, String name, String qName)
    {
    	if ("".equals (uri))
    		System.out.println("End element: " + qName);
    	else
    		System.out.println("End element:   {" + uri + "}" + name);
    }


    public static void main (String args[])
    {
    	BioMight3D bio3D = new BioMight3D();
    	bio3D.loadX3D("Nose");
    }


}

