package biomightweb.util;

import java.io.*;
import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;


public class TamParse extends DefaultHandler {

	
	public static void main (String args[]) throws Exception
	{
		XMLReader xr = XMLReaderFactory.createXMLReader();
		TamParse handler = new TamParse();
		xr.setContentHandler(handler);
		xr.setErrorHandler(handler);

		// Parse each file provided on the
		// command line.
		for (int i = 0; i < args.length; i++) {
		    FileReader r = new FileReader(args[i]);
		    xr.parse(new InputSource(r));
		}
	}


	public TamParse()
	{
		super();
	}

}