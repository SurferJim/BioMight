/*
 * Created on May 10, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.body.leg;

/**
 * @author SurferJim
 *
 * Representation of the Left Leg
 * 
 */

import java.util.ArrayList;

import biomight.Constants;
import biomight.body.arm.LeftArmSkin;
import biomight.view.BioMightColor;
import biomight.view.BioMightMethodView;
import biomight.view.BioMightPolygon;
import biomight.view.BioMightPolygons;
import biomight.view.BioMightPosition;
import biomight.view.BioMightPositions;
import biomight.view.BioMightPropertyView;


public class LeftLeg extends Leg {
		private BioMightPolygons bioMightPolygons;
		private ArrayList<BioMightPropertyView> properties;
		private ArrayList<BioMightMethodView> methods;
		
		private LeftLegSkin skin;
		//private LeftFemur femur;
		
		public LeftLeg()
		{
			this.setImage("images/LeftLeg.jpg");
			this.setImageHeight(300);
			this.setImageWidth(300);
			initProperties();
			initMethods();
		}

		
		public LeftLeg(BioMightPosition bioMightPosition)
		{
			this.setImage("images/LeftLeg.jpg");
			this.setImageHeight(300);
			this.setImageWidth(300);
			initProperties();
			initMethods();
			
			// Create the Skin
			skin = new LeftLegSkin(bioMightPosition);
			System.out.println("Creating the LeftLegSkin at Position: " + bioMightPosition.getXPos());	

			//femur = new LeftFemur(bioMightPosition);
			System.out.println("Creating the LeftFemur at Position: " + bioMightPosition.getXPos());	
			
			System.out.println("Creating the LeftLeg at Position: " + bioMightPosition.getXPos());
		}
		
		
		public void initProperties() {

			properties = new ArrayList<BioMightPropertyView>();
			
			BioMightPropertyView property = new BioMightPropertyView();
			property.setPropertyName("Bicep ---");
			property.setCanonicalName(Constants.LeftEar);
			properties.add(property);
					
		}
		
		public void initMethods() {

			methods = new ArrayList<BioMightMethodView>();
			
			BioMightMethodView method = new BioMightMethodView();

			method = new BioMightMethodView();
			method.setMethodName("Deafness");
			method.setHtmlType("checkbox");
			methods.add(method);	
			
			method = new BioMightMethodView();
			method.setMethodName("Hear");
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
			
			// Assemble the LeftLeg
			String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
			"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n " +
			"<X3D profile='Immersive' >\n" +
			"<head>\n" +
			 "<meta name='BioMightImage' content='LeftLeg.jpg'/>\n" +
			 "<meta name='ExportTime' content='7:45:30'/>\n" +
			 "<meta name='ExportDate' content='08/15/2008'/>\n" +
			 "<meta name='BioMight Version' content='1.0'/>\n" + 
			"</head>\n" +
			"<Scene>\n" +
			"<WorldInfo\n" +
			"title='LeftLeg'\n" +
			"info='\"BioMight Generated X3D\"'/>\n";		


			String body = "";
			int view = Constants.VIEW_DETACHED;
			if (view == Constants.VIEW_DETACHED)
			{				
					body = skin.getX3D(true); // + femur.getX3D(true);
			}
			
			System.out.println("LeftLeg X3D: " + body);		
			String footer = "</Scene>" + "</X3D>\n";
			
			if (snipet)
				return body;			
			else	
				return header + body + footer;
		}
}
	