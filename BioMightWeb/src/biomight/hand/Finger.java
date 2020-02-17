/*
 * Created on Jul 12, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.body.hand;
import java.util.ArrayList;

import javax.naming.InitialContext;






import biomight.Constants;
import biomight.body.BodyPart;
import biomight.body.hip.Acetabulum;
import biomight.body.hip.Labrum;
import biomight.ejb.BioMightBeanLocal;
import biomight.exceptions.ServerException;
import biomight.system.skeletal.hand.*;
import biomight.system.skeletal.pelvis.Pelvis;
import biomight.system.tissue.epithelial.EpitheliumTissue;
//import biomight.system.nervous.nerves.arm.*;
import biomight.system.cartilage.ArticularHyalineCartilage;
import biomight.system.ligament.hip.IlioFemoralLigament;
import biomight.system.ligament.hip.LigamentumTeresFemoris;
import biomight.system.muscular.hand.*;
import biomight.system.nervous.nerves.brachialplexus.medial.MedianNerve;
import biomight.system.nervous.nerves.brachialplexus.medial.UlnarNerve;
import biomight.system.nervous.nerves.brachialplexus.posterior.RadialNerve;
import biomight.view.BioMightMethodView;
import biomight.view.BioMightPropertyView;

/**
 * @author SurferJim
 *
 * Representation of a  finger
 * 
 */

public class Finger extends BodyPart {
	protected EpitheliumTissue epithelium;
	

	// Nails
	FingerNail fingerNail;
	
	
	// Bones
	private Carpals carpals;
	private MetaCarpals metacarpals;
	private HandDistalPhalanges phalanges;
	private DistalPhalanx distalPhalanx;
	private MiddlePhalanx middlePhalanx;
	private ProximalPhalanx proximalPhalanx;
	private RadialStyloidProcess radialStyloidProcess;
	private UlnarStyloidProcess ulnarStyloidProcess;
	private HypothenarEminence hypothenarEminence;
	
	
	// Ligaments
	//private VolarCarpalLigament volarCarpalLigament;
	//private NatatoryLigament natatoryLigament;
	
	
	// Nerves
	private UlnarNerve ulnarNerve;
	private RadialNerve radialNerve;
	private MedianNerve medianNerve;
	
	


	public Finger()
	{		
		// Create hte base Eye
		create(Constants.FingerRef, null);
	}
	
	
	public Finger(String parentID)
	{				
		this.parentID= parentID;
		create(parentID, null);	
	}
	

	public Finger(String parentID, ArrayList<BioMightMethodView> bioMightMethods)
	{	
		this.parentID= parentID;
		create(parentID, bioMightMethods);	
	}

	
	/************************************************************************************
	 * 
	 * CREATE FINGER
	 * @param FingerReference
	 ***********************************************************************************/
	
	public void create(String parentID, ArrayList<BioMightMethodView> bioMightMethods)
	{		
		this.setImage("images/Finger.gif");
		setImageWidth(200);
		setImageHeight(150);
	
		componentID=parentID;
	
		viewPerspective = Constants.VIEW_FLOATING;
		if (viewPerspective == Constants.VIEW_FLOATING) {
			
			// If we have initialization parameters from the form, 
			//  then apply them before constructing the objects.
			if (bioMightMethods != null){
				System.out.println("NEED TO EXECUTE Finger METHODS: " + bioMightMethods.size());
			}

			// In most instances,we will just be retrieving data
			// other times we will generate 
			boolean bGenerate = false;
			if (bGenerate) {
				generate(parentID);
			}
			
			epithelium = new EpitheliumTissue("FingerEpithelium", parentID, bioMightMethods);
			initProperty("FingerEpithelium", Constants.EpitheliumTissue, Constants.EpitheliumTissueRef, epithelium.getComponentID());
			System.out.println("Finger Epithelium completed for Finger: " + parentID);
								
			
			System.out.println("Finger Instance is created : " + parentID);
		} 
		else if (viewPerspective == Constants.VIEW_INTERNAL) {
	
		}

		//initProperties();
		initMethods();
	
	}
	
	
	/**************************************************************
	 * GENERATE FINGER
	 * @param parentID
	 * 
	 *************************************************************/
	public void generate(String parentID) 
	{
		String startIndex = "00001";
		double circumference = 0.25;
		double[] startPos = {9.0,-36.0, -1.0};
		
		// Generate the Finger Epithelium		
		BioMightBeanLocal bioMightBean;
		try {
			// Get the information from the database via the Enterprise Bean		
			System.out.println("Generating the Finger ParentID: " + parentID);
			InitialContext ctx = new InitialContext();
			bioMightBean = (BioMightBeanLocal) ctx.lookup("java:global/BioMightWeb/BioMightBean!biomight.ejb.BioMightBeanLocal");
	
			
			//Map into the basic human model of 8 fingers
			
			// Left Hand Fingers
			if (parentID.equals("Finger:01")) {
				startPos[0] = 8.0;
				startIndex = "00001";
			}
			else if (parentID.equals("Finger:02")) 
			{
				startPos[0] = 8.75;
				startIndex = "000064";
			}
			else if (parentID.equals("Finger:03")) 
			{
				startPos[0] = 9.75;
				startIndex = "00128";
			}		
			
			// Right Hand Figners
			else if (parentID.equals("Finger:04")) 
			{
				startPos[0] = 10.50;
				startIndex = "00192";
			}			
			
			//Now do the right hand
			else if (parentID.equals("Finger:05")) 
			{
				startPos[0] = -10.75;
				startIndex = "00256";
			}			
			else if (parentID.equals("Finger:06")) 
			{
				startPos[0] = -9.75;
				startIndex = "00320";
			}
			else if (parentID.equals("Finger:07")) 
			{
				startPos[0] = -9.00;
				startIndex = "00384";
			}
			else if (parentID.equals("Finger:08")) 
			{
				startPos[0] = -8.25;
				startIndex = "00448";
			}
			else
			{
				startPos[0] = -10.50;
				startIndex = "00448";				
				startIndex = "00448";
				
			}
			
			
			// 	Create a equilateral octogon
			double x =  startPos[0];
			double y =  startPos[1];
			double z =  startPos[2];
	 
			double[][] currentPoints = { 
	 			{x, y, z},
	 			{x-circumference,     y, z-circumference},
	 			{x-circumference,     y, z-circumference*2},
	 			{x,                   y, z-circumference*3},
	 			{x+circumference,     y, z-circumference*3},
	 			{x+(circumference*2), y, z-circumference*2},
	 			{x+(circumference*2),     y, z-circumference},
	 			{x+circumference, y, z}
	   		};
	
			
			int success = bioMightBean.generateFinger("FingerEpithelium:"+startIndex, "FingerEpithelium", 
					"FingerEpithelium", parentID, currentPoints);			
	
			
		System.out.println("Created FingerEpithelium using generateFinger");   	
		}catch (	Exception e) { 
		System.out.println("Exception Getting Components - FingerEpithelium");
		throw new ServerException("Remote Exception getComponents():", e); 	
		}

	}
	
	
	
	public void initProperties() {	
		BioMightPropertyView property = new BioMightPropertyView();
		property.setPropertyName("Acetabulum");
		property.setCanonicalName(Constants.Acetabulum);
		properties.add(property);			
	}
	
	
	public void initMethods() {

		BioMightMethodView method;

		method = new BioMightMethodView();
		method.setMethodName("Crack");
		method.setHtmlType("checkbox");
		methods.add(method);	
		
		method = new BioMightMethodView();
		method.setMethodName("Gyrate");
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
		
		// Assemble the Finger
		String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
		"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n " +
		"<X3D profile='Immersive' >\n" +
		"<head>\n" +
		 "<meta name='BioMightImage' content='Finger.jpg'/>\n" +
		 "<meta name='ExportTime' content='7:45:30'/>\n" +
		 "<meta name='ExportDate' content='08/15/2008'/>\n" +
		 "<meta name='BioMight Version' content='1.0'/>\n" + 
		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='Finger'\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		

		String body = epithelium.getX3D(true);  
		//System.out.println("Finger X3D: " + body);		
		
		String footer = "</Scene>" + "</X3D>\n";
		
		if (snipet)
			return body;			
		else	
			return header + body + footer;
	}
	

	
	// Calls upon the methods in the Ball and Socket joint
	// to change the angles of movement
	public void setRightFlexionAngle()
	{
	}
	
	public void setLeftFlexionAngle()
	{
	}
	
	public void RotationAngle()
	{
	}	
	
}
