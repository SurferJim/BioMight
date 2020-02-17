/*
 * Created on Jun 5, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.bacteria;
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

public class Bacteria extends BioMightBase {
	private BacterialCellWall bacterialCellWall;
	private Flagellum flagellum;
	private Nucleoid nucleoid;	
	private Fimbria fimbria;
	private Mesosome mesosome;
	private Periplasm periplasm;
	private PeriplasmicSpace periplasmicSpace;
	private Pilus pilus;
	private Plasmid plasmid;
	private Transposons transposons;
	private CytoplasmicMembrane cytoplasmicMembrane;
	private BacterialRibosomes bacterialRibosomes;
	private BacterialGranule bacterialGranule;
	private BacterialPolymerase bacterialPolymerase;

	
	
	public Bacteria()
	{
		setImage("images/Bacteria.jpg");
	}

	
	public ArrayList getProperties() {

		ArrayList<BioMightPropertyView> properties = new ArrayList<BioMightPropertyView>();
		
		// LOBES
		BioMightPropertyView property = new BioMightPropertyView();
		property.setPropertyName("BacterialCellWall");
		property.setCanonicalName(Constants.BacterialCellWall);
		properties.add(property);
	
		property = new BioMightPropertyView();
		property.setPropertyName("Flagellum");
		property.setCanonicalName(Constants.Flagellum);
		properties.add(property);		

		property = new BioMightPropertyView();
		property.setPropertyName("Nucleoid");
		property.setCanonicalName(Constants.Nucleoid);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("Fimbria");
		property.setCanonicalName(Constants.Fimbria);
		properties.add(property);			

			
		property = new BioMightPropertyView();
		property.setPropertyName("Mesosome");
		property.setCanonicalName(Constants.Mesosome);
		properties.add(property);		

			
		property = new BioMightPropertyView();
		property.setPropertyName("Periplasm");
		property.setCanonicalName(Constants.Periplasm);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("Periplasmic Space");
		property.setCanonicalName(Constants.PeriplasmicSpace);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("Pilus");
		property.setCanonicalName(Constants.Pilus);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("Plasmid");
		property.setCanonicalName(Constants.Plasmid);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("Transposons");
		property.setCanonicalName(Constants.Transposons);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("Cytoplasmic Membrane");
		property.setCanonicalName(Constants.CytoplasmicMembrane);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("Bacterial Ribosomes");
		property.setCanonicalName(Constants.BacterialRibosomes);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("Bacterial Granule");
		property.setCanonicalName(Constants.BacterialGranule);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("Bacterial Polymerase");
		property.setCanonicalName(Constants.BacterialPolymerase);
		properties.add(property);		
		
		return properties;
	}
	
	public ArrayList getMethods() {

		ArrayList<BioMightMethodView> methods = new ArrayList<BioMightMethodView>();
		
		BioMightMethodView method = new BioMightMethodView();

		method = new BioMightMethodView();
		method.setMethodName("Reproduce");
		method.setHtmlType("checkbox");
		method.setDataType("boolean");
		methods.add(method);	
		
		method = new BioMightMethodView();
		method.setMethodName("Mate");
		method.setHtmlType("text");
		method.setDataType("boolean");
		methods.add(method);	


		method = new BioMightMethodView();
		method.setMethodName("Lyse");
		method.setHtmlType("text");
		method.setDataType("boolean");
		methods.add(method);	
		return methods;
	
	}
}
