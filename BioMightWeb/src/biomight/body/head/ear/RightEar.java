/*
 * Created on May 8, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.body.head.ear;
import java.util.ArrayList;

import biomight.Constants;
import biomight.system.nervous.nerves.head.ear.VestibularNerve;
import biomight.view.BioMightMethodView;
import biomight.view.BioMightPosition;
import biomight.view.BioMightPropertyView;

/**
 * @author SurferJim
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class RightEar extends Ear {

	// Exterior Ear
	private RightAuricle rightAuricle;	
	
	// Interior Ear
	protected Cochlea cochlea;
	protected ExternalCanal externalCanal;
	protected Malleus malleus;
	protected SemiCircularCanals semiCircularCanals;
	protected Stapes stapes;
	protected TympanicMembrane earDrum;
	protected Saccule saccule;
	protected VestibularNerve vestibularNerve;	
	
	
	public RightEar()
	{
		this.setImage("images/RightEar.jpg");
	}
	
	
	public RightEar(BioMightPosition position)
	{
		this.setImage("images/RightEar.jpg");
		
		viewPerspective = Constants.VIEW_FLOATING;
		if (viewPerspective == Constants.VIEW_FLOATING) {
			rightAuricle  = new RightAuricle(position);
			System.out.println("Right Ear - RightAuricle is created");
		} 
		else if (viewPerspective == Constants.VIEW_INTERNAL) {
			vestibularNerve = new VestibularNerve();
			System.out.println("VestibularNerve is created");
			cochlea  = new Cochlea();
			System.out.println("Cochlea is created");
			externalCanal  = new ExternalCanal();
			System.out.println("External Canal is created");
			malleus  = new Malleus();
			System.out.println("Malleus is created");
			semiCircularCanals  = new SemiCircularCanals();
			System.out.println("SemiCircular Canal is created");
			stapes  = new Stapes();
			System.out.println("Stapes is created");
			earDrum  = new TympanicMembrane();
			System.out.println("Ear Drum is created");
			saccule  = new Saccule();
			System.out.println("Saccule is created");
		}
		else if (viewPerspective == Constants.VIEW_DETACHED) {
			rightAuricle = new RightAuricle();
			System.out.println("RightAuricle is created");
			vestibularNerve = new VestibularNerve();
			System.out.println("VestibularNerve is created");
			cochlea  = new Cochlea();
			System.out.println("Cochlea is created");
			externalCanal  = new ExternalCanal();
			System.out.println("External Canal is created");
			malleus  = new Malleus();
			System.out.println("Malleus is created");
			semiCircularCanals  = new SemiCircularCanals();
			System.out.println("SemiCircular Canal is created");
			stapes  = new Stapes();
			System.out.println("Stapes is created");
			earDrum  = new TympanicMembrane();
			System.out.println("Ear Drum is created");
			saccule  = new Saccule();
			System.out.println("Saccule is created");
		}
	}

	
	public void redraw(BioMightPosition position)
	{
		this.setImage("images/RightEar.jpg");
		
		viewPerspective = Constants.VIEW_FLOATING;
		if (viewPerspective == Constants.VIEW_FLOATING) {
			rightAuricle.redraw(position);
			System.out.println("Right Ear - RightAuricle Redraw");
		} 
	}
	
	
	
	/********************************************************************************************************************
	 * GET X3D
	 * 
	 * This method will return the X3D for the Cell.  It runs through each of its components and collects up their
	 * representations and then assembles them into one unified X3D model.
	 * 
	 ********************************************************************************************************************/
	public String getX3D(boolean snipet) {
		
		// Assembe the Head
		String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
		"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n " +
		"<X3D profile='Immersive' >\n" +
		"<head>\n" +
		 "<meta name='BioMightImage' content='RightEar.jpg'/>\n" +
		 "<meta name='ExportTime' content='7:45:30'/>\n" +
		 "<meta name='ExportDate' content='08/15/2008'/>\n" +
		 "<meta name='BioMight Version' content='1.0'/>\n" + 
		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='Right Ear'\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		

		viewPerspective = Constants.VIEW_FLOATING;
		// Construct the ear based on the View Perspective. We only want to 
		// activate those components that comprise the view
		String body = "";
		if (viewPerspective == Constants.VIEW_FLOATING) {
			body = rightAuricle.getX3D(true);
		} else if (viewPerspective == Constants.VIEW_INTERNAL) {
			body = 
			vestibularNerve.getX3D(true) +
			cochlea.getX3D(true) +
			externalCanal.getX3D(true) +
			malleus.getX3D(true) +
			semiCircularCanals.getX3D(true) +
			stapes.getX3D(true) +
			earDrum.getX3D(true) +
			saccule.getX3D(true);
		} else if (viewPerspective == Constants.VIEW_DETACHED) {
			body = 
			rightAuricle.getX3D(true) +
			vestibularNerve.getX3D(true) +
			cochlea.getX3D(true) +
			externalCanal.getX3D(true) +
			malleus.getX3D(true) +
			semiCircularCanals.getX3D(true) +
			stapes.getX3D(true) +
			earDrum.getX3D(true) +
			saccule.getX3D(true);
		}
		
		
		System.out.println("RightEar X3D: " + body);		
		
		String footer = "</Scene>" + "</X3D>\n";
		
		if (snipet)
			return body;			
		else	
			return header + body + footer;
	}


	public Cochlea getCochlea() {
		return cochlea;
	}


	public void setCochlea(Cochlea cochlea) {
		this.cochlea = cochlea;
	}


	public TympanicMembrane getEarDrum() {
		return earDrum;
	}


	public void setEarDrum(TympanicMembrane earDrum) {
		this.earDrum = earDrum;
	}


	public ExternalCanal getExternalCanal() {
		return externalCanal;
	}


	public void setExternalCanal(ExternalCanal externalCanal) {
		this.externalCanal = externalCanal;
	}


	public Malleus getMalleus() {
		return malleus;
	}


	public void setMalleus(Malleus malleus) {
		this.malleus = malleus;
	}


	public Saccule getSaccule() {
		return saccule;
	}


	public void setSaccule(Saccule saccule) {
		this.saccule = saccule;
	}


	public SemiCircularCanals getSemiCircularCanals() {
		return semiCircularCanals;
	}


	public void setSemiCircularCanals(SemiCircularCanals semiCircularCanals) {
		this.semiCircularCanals = semiCircularCanals;
	}


	public Stapes getStapes() {
		return stapes;
	}


	public void setStapes(Stapes stapes) {
		this.stapes = stapes;
	}


	public VestibularNerve getVestibularNerve() {
		return vestibularNerve;
	}


	public void setVestibularNerve(VestibularNerve vestibularNerve) {
		this.vestibularNerve = vestibularNerve;
	}

}
