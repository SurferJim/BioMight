/*
 * Created on Jul 11, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.body.leg.cnemis;

/**
 * @author SurferJim
 *
 * Representation of the Left Cnemis
 * 
 */

import java.util.ArrayList;

import biomight.Constants;
import biomight.system.skeletal.leg.tibia.LeftTibia;
import biomight.view.BioMightColor;
import biomight.view.BioMightMethodView;
import biomight.view.BioMightPolygon;
import biomight.view.BioMightPolygons;
import biomight.view.BioMightPosition;
import biomight.view.BioMightPositions;
import biomight.view.BioMightPropertyView;


public class LeftCnemis extends Cnemis {
		private BioMightPolygons bioMightPolygons;
		private ArrayList<BioMightPropertyView> properties;
		private ArrayList<BioMightMethodView> methods;
		
		private LeftTibia tibia;
		private LeftCnemisSkin skin;
		
		
		public LeftCnemis()
		{
			this.setImage("images/LeftCnemis.jpg");
			this.setImageHeight(300);
			this.setImageWidth(300);
			initProperties();
			initMethods();
		}

		
		public LeftCnemis(BioMightPosition bioMightPosition)
		{
			this.setImage("images/LeftCnemis.jpg");
			this.setImageHeight(300);
			this.setImageWidth(300);
			initProperties();
			initMethods();
			
			tibia = new LeftTibia(bioMightPosition);
			System.out.println("Creating the LeftTibia at Position: " + bioMightPosition.getXPos());
			
			skin = new LeftCnemisSkin(bioMightPosition);
			System.out.println("Creating the LeftCnemisSkin at Position: " + bioMightPosition.getXPos());

			System.out.println("Creating the LeftCnemis at Position: " + bioMightPosition.getXPos());
;
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
			
			// Assemble the LeftCnemis
			String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
			"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n " +
			"<X3D profile='Immersive' >\n" +
			"<head>\n" +
			 "<meta name='BioMightImage' content='LeftCnemis.jpg'/>\n" +
			 "<meta name='ExportTime' content='7:45:30'/>\n" +
			 "<meta name='ExportDate' content='08/15/2008'/>\n" +
			 "<meta name='BioMight Version' content='1.0'/>\n" + 
			"</head>\n" +
			"<Scene>\n" +
			"<WorldInfo\n" +
			"title='LeftCnemis'\n" +
			"info='\"BioMight Generated X3D\"'/>\n";		


			System.out.println("*******Getting X3D for ThoracicVertebraeT2*****");
			String body = "";
			int view = Constants.VIEW_DETACHED;
			if (view == Constants.VIEW_DETACHED)
			{				
				body = skin.getX3D(true) + tibia.getX3D(true);
			}
			
			
			System.out.println("LeftCnemis X3D: " + body);		
			String footer = "</Scene>" + "</X3D>\n";
			
			if (snipet)
				return body;			
			else	
				return header + body + footer;
		}
}

