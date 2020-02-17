/*
 * Created on Dec 1, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.cell.misc;
import java.util.ArrayList;

import biomight.BioMightBase;
import biomight.Constants;
import biomight.view.BioMightMethodView;
import biomight.view.BioMightPropertyView;

/**
 * @author SurferJim
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class Chondrocytes extends BioMightBase {
	private ArrayList<BioMightPropertyView> properties;
	private ArrayList<BioMightMethodView> methods;
	private ArrayList<Chondrocyte> chondrocytes;
	
	/*
	 * Create default Thymocytes
	 */
	public Chondrocytes() {
		this.setImage("images/Chrondocytes.jpg");
		initProperties();
		initMethods();
		
		//System.out.println("DEFAULT CONSTRCTOR - Ribosomes arrayList is allocated...");
		chondrocytes = new ArrayList<Chondrocyte>();
	}
		
	/**
	 * Create a cluster of Chrondocytes and shape into the structure
	 * defined by the position map
	 */		
	public Chondrocytes(int numChondrocytes) {
		chondrocytes = new ArrayList<Chondrocyte>();
		
		for (int i=0; i<numChondrocytes; i++)
		{
			Chondrocyte chondrocyte = new Chondrocyte();
			chondrocytes.add(i, chondrocyte);
		}
			
	}

		
	public void initProperties() {

		properties = new ArrayList<BioMightPropertyView>();
		
		BioMightPropertyView property = new BioMightPropertyView();
		property.setPropertyName("Chrondocyte");
		property.setCanonicalName(Constants.Chrondocyte);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("Ribosome");
		property.setCanonicalName(Constants.Chrondocyte);
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
	
}
