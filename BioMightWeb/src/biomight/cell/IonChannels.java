/*
 * Created on Nov 10, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
 
package biomight.cell;
import java.util.ArrayList;

import biomight.BioMightBase;
import biomight.Constants;
import biomight.view.BioMightMethodView;
import biomight.view.BioMightPositions;
import biomight.view.BioMightPropertyView;

/**
 * @author SurferJim
 *
 * Creates a bunch of IonChannels and distributes them within the Cell's membrane
 * 
 */

public class IonChannels extends BioMightBase {
	private ArrayList<BioMightPropertyView> properties;
	private ArrayList<BioMightMethodView> methods;
	private ArrayList<IonChannel> ionChannels;
	
	
	/*
	 * Create default IonChannels
	 */		
	public IonChannels() {
		this.setImage("images/IonChannel.jpg");
		initProperties();
		initMethods();
		
		//System.out.println("DEFAULT CONSTRCTOR - IonChannels arrayList is allocated...");
		ionChannels = new ArrayList<IonChannel>();
	}

		
	/**
	 * Constructor that creates the specified number of Endosomes and distributes them 
	 * throughout the Cell
	 */		
	public IonChannels(int numElements, BioMightPositions positions) {
		this.setImage("images/IonChannels.jpg");	
		initProperties();
		initMethods();
		//System.out.println("Ribosomes - Properties and Methods are initialized...");
		
		ionChannels = new ArrayList<IonChannel>();
		//System.out.println("IonChannels arrayList is allocated...");
		
		//System.out.println("IonChannels Constructor - Distribution Map: " + positions.getBioMightPositions().size());
		
		// Create the IonChannels and set their base positions using the
		// distribution map
		for (int i=0; i<numElements; i++)
		{
			// Create the endosomes using the generated positions
			IonChannel ionPump = new IonChannel(positions.getBioMightPosition(i));
			System.out.println("Constr - Created IonChannels with PositionX: " + positions.getBioMightPosition(i).getXPos());
			System.out.println("Constr - Created IonChannels with PositionY: " + positions.getBioMightPosition(i).getYPos());
			System.out.println("Constr - Created IonChannels with PositionZ: " + positions.getBioMightPosition(i).getZPos());	
			ionChannels.add(i, ionPump);
		}
		//System.out.println("IonChannels Constructor complete...");		
	}

	
	
	
	public void initProperties() {

		properties = new ArrayList<BioMightPropertyView>();
		
		BioMightPropertyView property = new BioMightPropertyView();
		property.setPropertyName("IonChannel");
		property.setCanonicalName(Constants.IonChannel);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("IonChannel");
		property.setCanonicalName(Constants.IonChannel);
		properties.add(property);
	}
	
	
	public void initMethods() {

		methods = new ArrayList<BioMightMethodView>();
		
		BioMightMethodView method;
		method = new BioMightMethodView();
		method.setMethodName("Set Membrane Width");
		method.setHtmlType("text");
		methods.add(method);
	}	

	
	
	public String getX3D(boolean snipet)
	{
		
		String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
		"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n" +
		"<X3D profile='Immersive' >\n" +
		"<head>\n" +
		 "<meta name='BioMightImage' content='IonChannels.jpg'/>\n" +
		 "<meta name='ExportTime' content='7:45:30'/>\n" +
		 "<meta name='ExportDate' content='7/17/2008'/>\n" +
		 "<meta name='BioMight Version' content='1.0'/>\n" + 
		 "<meta name='FluxStudioSource' content='IonChannels.fxw'/>\n" +
		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='nose'\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		
		//System.out.println(header);	

		// Run Through the Collection of IonChannels and get their X3D datum
		IonChannel ionPump;
		String body = "";
		//System.out.println("Getting X3D for IonChannels: " + this.ionChannels.size());
		for (int y=0; y<this.ionChannels.size(); y++)
		{					
			ionPump = (IonChannel) ionChannels.get(y);
			System.out.println("Getting X3D for IonChannel: " + y);			
			body += ionPump.getX3D(true);
		}
		System.out.println(body);
		
			String footer = "</Scene>\n" + "</X3D>\n";
			//System.out.println(footer);

			if (snipet)
				return body;			
			else	
				return header + body + footer;
	}


	public ArrayList<BioMightMethodView> getMethods() {
		return methods;
	}


	public void setMethods(ArrayList<BioMightMethodView> methods) {
		this.methods = methods;
	}


	public ArrayList<BioMightPropertyView> getProperties() {
		return properties;
	}


	public void setProperties(ArrayList<BioMightPropertyView> properties) {
		this.properties = properties;
	}
	
}

