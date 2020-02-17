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
 * Creates a bunch of centrioles and distributes them across the Cell's cytosol
 * 
 */

public class Centrioles extends BioMightBase {
	private ArrayList<BioMightPropertyView> properties;
	private ArrayList<BioMightMethodView> methods;
	private ArrayList<Centriole> centrioles;
	
	
	/*
	 * Create default centrioles
	 */		
	public Centrioles() {
		this.setImage("images/centriole.jpg");
		initProperties();
		initMethods();
		
		//System.out.println("DEFAULT CONSTRCTOR - centrioles arrayList is allocated...");
		centrioles = new ArrayList<Centriole>();
	}

		
	/**
	 * Constructor that creates the specified number of Endosomes and distributes them 
	 * throughout the Cell
	 */		
	public Centrioles(int numElements, BioMightPositions positions) {
		this.setImage("images/Centrioles.jpg");	
		initProperties();
		initMethods();
		//System.out.println("centrioles - Properties and Methods are initialized...");
		
		centrioles = new ArrayList<Centriole>();
		//System.out.println("centrioles arrayList is allocated...");
		
		//System.out.println("centrioles Constructor - Distribution Map: " + positions.getBioMightPositions().size());
		
		// Create the centrioles and set their base positions using the
		// distribution map
		for (int i=0; i<numElements; i++)
		{
			// Create the endosomes using the generated positions
			Centriole centriole = new Centriole(positions.getBioMightPosition(i));
			System.out.println("Constr - Created centriole with PositionX: " + positions.getBioMightPosition(i).getXPos());
			System.out.println("Constr - Created centriole with PositionY: " + positions.getBioMightPosition(i).getYPos());
			System.out.println("Constr - Created centriole with PositionZ: " + positions.getBioMightPosition(i).getZPos());	
			centrioles.add(i, centriole);
		}
		//System.out.println("centrioles Constructor complete...");		
	}

	
	
	
	public void initProperties() {

		properties = new ArrayList<BioMightPropertyView>();
		
		BioMightPropertyView property = new BioMightPropertyView();
		property.setPropertyName("centriole");
		property.setCanonicalName(Constants.Centriole);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("centriole");
		property.setCanonicalName(Constants.Centriole);
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
		 "<meta name='BioMightImage' content='centrioles.jpg'/>\n" +
		 "<meta name='ExportTime' content='7:45:30'/>\n" +
		 "<meta name='ExportDate' content='7/17/2008'/>\n" +
		 "<meta name='BioMight Version' content='1.0'/>\n" + 
		 "<meta name='FluxStudioSource' content='centrioles.fxw'/>\n" +
		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='nose'\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		
		//System.out.println(header);	

		// Run Through the Collection of centrioles and get their X3D datum
		Centriole centriole;
		String body = "";
		//System.out.println("Getting X3D for centrioles: " + this.centrioles.size());
		for (int y=0; y<this.centrioles.size(); y++)
		{					
			centriole = (Centriole) centrioles.get(y);
			System.out.println("Getting X3D for centriole: " + y);			
			body += centriole.getX3D(true);
		}
		System.out.println(body);
		
			String footer = "</Scene>\n" + "</X3D>\n";
			//System.out.println(footer);

			if (snipet)
				return body;			
			else	
				return header + body + footer;
	}
	
}
