/*
 * Created on Jul 7, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.body.spine;
import java.math.BigDecimal;
import java.util.ArrayList;

import biomight.BioMightBase;
import biomight.Constants;
import biomight.system.nervous.spinalchord.CostaFovea;
import biomight.system.nervous.spinalchord.ForamenTransversium;
import biomight.system.nervous.spinalchord.MedullaSpinalis;
import biomight.system.nervous.spinalchord.NucleusPulposus;
import biomight.system.nervous.spinalchord.SuperiorArticularProcess;
import biomight.system.skeletal.spine.CervicalVertebrae;
import biomight.view.BioMightMethodView;
import biomight.view.BioMightPosition;
import biomight.view.BioMightPropertyView;

/**
 * @author SurferJim
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class Spine extends BioMightBase {
	private ArrayList<BioMightPropertyView> properties;
	private ArrayList<BioMightMethodView> methods;
	
	private BigDecimal CervicalCurve;
	private BigDecimal ThoracicCurve;
	private BigDecimal lumbarCurve;
	private BigDecimal sacralCurve;
		
	private CervicalVertebrae cervicalVertebrae;
	private SpineThoracicRegion thoracicRegion;
	private SpineLumbarRegion lumbarRegion;
	private MedullaSpinalis spinalChord;
	private NucleusPulposus nucleusPulposus;
	private DiscAnnulus discAnnulus;
	private SpinousProcess spinousProcess;
	private SuperiorArticularProcess superiorArticularProcess;
	private ForamenTransversium foramenTransversium;
	private CostaFovea costaFovea;
	private Coccyx coccyx;
	
	
	
	public Spine ()
	{
		this.setImage("images/Spine.jpg");
		
		cervicalVertebrae = new CervicalVertebrae();
		thoracicRegion = new SpineThoracicRegion();
		lumbarRegion = new SpineLumbarRegion();
		coccyx = new Coccyx();
		spinalChord = new MedullaSpinalis();
		nucleusPulposus = new NucleusPulposus();
		discAnnulus = new DiscAnnulus();
		spinousProcess = new SpinousProcess();
		superiorArticularProcess = new SuperiorArticularProcess();
		foramenTransversium = new ForamenTransversium();
		costaFovea = new CostaFovea();
		coccyx = new Coccyx();		
		
	}

	public Spine (BioMightPosition bioMightPosition)
	{
		this.setImage("images/Spine.jpg");
		
		cervicalVertebrae = new CervicalVertebrae("");
		thoracicRegion = new SpineThoracicRegion(bioMightPosition);
		lumbarRegion = new SpineLumbarRegion(bioMightPosition);
		coccyx = new Coccyx(bioMightPosition);
		spinalChord = new MedullaSpinalis();
		nucleusPulposus = new NucleusPulposus();
		discAnnulus = new DiscAnnulus();
		spinousProcess = new SpinousProcess();
		superiorArticularProcess = new SuperiorArticularProcess();
		foramenTransversium = new ForamenTransversium();
		costaFovea = new CostaFovea();
		coccyx = new Coccyx();		
		
	}
	
	
	public void initProperties() {

		properties = new ArrayList<BioMightPropertyView>();

		BioMightPropertyView property = new BioMightPropertyView();
		property.setPropertyName("SpineCervicalRegion");
		property.setCanonicalName(Constants.CervicalVertebrae);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("SpineThoracicRegion");
		property.setCanonicalName(Constants.SpineThoracicRegion);
		properties.add(property);		

		property = new BioMightPropertyView();
		property.setPropertyName("SpineLumbarRegion");
		property.setCanonicalName(Constants.SpineLumbarRegion);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("SpinePelvicRegion");
		property.setCanonicalName(Constants.SpinePelvicRegion);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("MedullaSpinalis");
		property.setCanonicalName(Constants.MedullaSpinalis);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("NucleusPulposus");
		property.setCanonicalName(Constants.NucleusPulposus);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("DiscAnnulus");
		property.setCanonicalName(Constants.DiscAnnulus);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("SpinousProcess");
		property.setCanonicalName(Constants.SpinousProcess);
		properties.add(property);
				
		property = new BioMightPropertyView();
		property.setPropertyName("SuperiorArticularProcess");
		property.setCanonicalName(Constants.SuperiorArticularProcess);
		properties.add(property);
		
		property = new BioMightPropertyView();
		property.setPropertyName("ForamenTransversium");
		property.setCanonicalName(Constants.ForamenTransversium);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("CostaFovea");
		property.setCanonicalName(Constants.CostaFovea);
		properties.add(property);

		property = new BioMightPropertyView();
		property.setPropertyName("Coccyx");
		property.setCanonicalName(Constants.Coccyx);
		properties.add(property);	
	}
	
	
	public void initMethods() {

		methods = new ArrayList<BioMightMethodView>();
		
		BioMightMethodView method = new BioMightMethodView();
		
		method = new BioMightMethodView();
		method.setMethodName("Set Curvature");
		method.setHtmlType("checkbox");
		methods.add(method);
	}

	
	/********************************************************************************************************************
	 * GET X3D
	 * 
	 * This method will return the X3D for the Cell.  It runs through each of its components and collects up their
	 * representations and then assembles them into one unified X3D model.
	 * 
	 ********************************************************************************************************************/
	public String getX3D(boolean snipet) {
		
		// Assemble the Spine
		String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
		"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n " +
		"<X3D profile='Immersive' >\n" +
		"<head>\n" +
		 "<meta name='BioMightImage' content='Spine.jpg'/>\n" +
		 "<meta name='ExportTime' content='7:45:30'/>\n" +
		 "<meta name='ExportDate' content='08/15/2008'/>\n" +
		 "<meta name='BioMight Version' content='1.0'/>\n" + 
		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='Spine'\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		

		String body =  
			cervicalVertebrae.getX3D(true) +
			thoracicRegion.getX3D(true) +
			lumbarRegion.getX3D(true) +
			coccyx.getX3D(true) +
			spinalChord.getX3D(true) +
			nucleusPulposus.getX3D(true) +
			discAnnulus.getX3D(true) +
			spinousProcess.getX3D(true) +
			superiorArticularProcess.getX3D(true) +
			foramenTransversium.getX3D(true) +
			costaFovea.getX3D(true) +
			coccyx.getX3D(true);
		
		
		System.out.println("Spine X3D: " + body);		
		
		String footer = "</Scene>" + "</X3D>\n";
		
		if (snipet)
			return body;			
		else	
			return header + body + footer;
	}
	
}
