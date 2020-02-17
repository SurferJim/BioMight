/*
 * Created on Jul 18, 2006
 * Copyright 2006 - Biomight.org
 * 
 * This code is the not to be used without written permission from
 * BioMight.org
 * 
 */

package biomight.body.organ.heart;


import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.naming.InitialContext;

import biomight.BioMightBase;
import biomight.Constants;
import biomight.ejb.BioMightBeanLocal;
import biomight.exceptions.DataSecurityException;
import biomight.exceptions.ServerException;
import biomight.view.BioMightColor;
import biomight.view.BioMightMethodView;
import biomight.view.BioMightPolygon;
import biomight.view.BioMightPolygons;
import biomight.view.BioMightPosition;
import biomight.view.BioMightPositions;
import biomight.view.BioMightPropertyView;
import biomight.view.BioMightTransform;
import biomight.view.BioMightTransforms;

	/**
	 * @author SurferJim
	 *
	 * Representation of the Ventricles.  It contains a collection of 
	 * CervicalVertebra that support the head.
	 * 
	 */
	public class Ventricles extends BioMightBase {
		private BioMightTransforms bioMightTransforms;
		private ArrayList<BioMightPropertyView> properties;
		private ArrayList<BioMightMethodView> methods;
		private Ventricle ventricle;
		private ArrayList ventricles;
	
				
		public Ventricles()
		{
			create(Constants.NeckRef, null);
		}

		
		public Ventricles(String parentID)
		{
			create(parentID, null);
		}

		public Ventricles(String parentID, ArrayList<BioMightMethodView> bioMightMethods)
		{
			create(parentID, bioMightMethods);
		}
		
		/*******************************************************
		 * createVentricles
		 * 
		 * Create a 3D model of the Heart Ventricle based upon the
		 * properties of the object.
		 * 
		 *******************************************************/

		public void create(String parentID, ArrayList<BioMightMethodView> bioMightMethods)
		{
			this.setImage("images/Ventricles.jpg");
			this.setImageHeight(300);
			this.setImageWidth(300);
			ventricles = new ArrayList();
			
			// Get the information from the database via the Enterprise Bean		
			try {
				// Get the information from the database via the Enterprise Bean		
				System.out.println("Getting VentriclesInfo for ParentID: " + parentID);
				InitialContext ctx = new InitialContext();
				BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
				bioMightTransforms = bioMightBean.getComponents(Constants.VentricleRef, parentID);
				System.out.println("Have Ventricles Info from EJB");   	
			}catch (Exception e) { 
				System.out.println("Exception Getting Components - Ventricles");
				throw new ServerException("Remote Exception getComponents():", e); 	
			}
				
			// Run through Forehead and build them into the model
			ArrayList transforms = bioMightTransforms.getTransforms();
			System.out.println("Ventricles NumTransforms: " + transforms.size());
			for (int i=0; i<transforms.size(); i++)
			{
				// Get the information for the Forehead we are creating
				BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
				System.out.println("Creating Ventricles (name,id): " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
				
				// Create an instance of the Vertebra based on information in the repository
				ventricle = new Ventricle(bioMightTransform.getId());
				System.out.println("Ventricle created");	
				ventricles.add(i,ventricle);
				System.out.println("Ventricle added to Collection: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
			}	
			

			initProperties();
			initMethods();
		}
		
		
		
		public void initProperties() {

			properties = new ArrayList<BioMightPropertyView>();
			
			BioMightPropertyView property = new BioMightPropertyView();
			property.setPropertyName("Stapes ---");
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
		 * This method will return the X3D for the Ventricles.  It runs through each of its components and collects up their
		 * representations and then assembles them into one unified X3D model.
		 * 
		 ********************************************************************************************************************/
		public String getX3D(boolean snipet) {
			
			// Assemble the Ventricles
			String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
			"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n " +
			"<X3D profile='Immersive' >\n" +
			"<head>\n" +
			 "<meta name='BioMightImage' content='Ventricles.jpg'/>\n" +
			 "<meta name='ExportTime' content='7:45:30'/>\n" +
			 "<meta name='ExportDate' content='08/15/2008'/>\n" +
			 "<meta name='BioMight Version' content='1.0'/>\n" + 
			"</head>\n" +
			"<Scene>\n" +
			"<WorldInfo\n" +
			"title='Ventricles'\n" +
			"info='\"BioMight Generated X3D\"'/>\n";		

			String body = ""; 
			System.out.println("Assembling X3D for Ventricles");
			
			// Run through the collection of Ventricles and assemble the X3D for each
			for (int i=0; i<ventricles.size(); i++)
			{
				// Get the information for the eye
				Ventricle ventricle = (Ventricle) ventricles.get(i);
				System.out.println("Getting X3D for Ventricle");
				body += ventricle.getX3D(true);
			}		
			

			//System.out.println("Ventricles X3D: " + body);		
			String footer = "</Scene>" + "</X3D>\n";
			
			if (snipet)
				return body;			
			else	
				return header + body + footer;
		}
		
		
		/********************************************************************************************************************
		 * GET X3D
		 * 
		 * This method will return the X3D for the Cell.  It runs through each of its components and collects up their
		 * representations and then assembles them into one unified X3D model.
		 * 
		 ********************************************************************************************************************/
		public String getX3D2(boolean snipet) {
			
			// Assemble the Ventricles
			String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
			"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n " +
			"<X3D profile='Immersive' >\n" +
			"<head>\n" +
			 "<meta name='BioMightImage' content='Ventricles.jpg'/>\n" +
			 "<meta name='ExportTime' content='7:45:30'/>\n" +
			 "<meta name='ExportDate' content='08/15/2008'/>\n" +
			 "<meta name='BioMight Version' content='1.0'/>\n" + 
			"</head>\n" +
			"<Scene>\n" +
			"<WorldInfo\n" +
			"title='CervicalVertebraC1'\n" +
			"info='\"BioMight Generated X3D\"'/>\n";		


			String body = "";
			
			// Run through the collection of Pupils and build them into the model
			// In the default case, we get one instance of the Pupil for each eye
			ArrayList transforms = bioMightTransforms.getTransforms();
			for (int i=0; i<transforms.size(); i++)
			{
				// Get the information for the PinnaAntiHelix we are creating
				BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
				System.out.println("Getting Ventricles X3D: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
			
				int view = Constants.VIEW_FLOATING;
				if (view == Constants.VIEW_FLOATING)
				{
					//System.out.println("Getting X3D for VentriclesX: " + bioMightSphere.getTranslation().getXPos());
					//System.out.println("Getting X3D for VentriclesY: " + bioMightSphere.getTranslation().getYPos());
					//System.out.println("Getting X3D for VentriclesZ: " + bioMightSphere.getTranslation().getZPos());
					// Change the height and width based on the displacement.
					body += "<Transform DEF='CervicalVertebra'\n" +
			 			"translation='" + bioMightTransform.getTranslation().getXPos() + " " 
				 					+ bioMightTransform.getTranslation().getYPos() + " "
				 					+ bioMightTransform.getTranslation().getZPos() + "'\n" +
				 		"scale='" 	+ bioMightTransform.getScale().getXPos() + " "
				 				+ bioMightTransform.getScale().getYPos() + " "
				 				+ bioMightTransform.getScale().getZPos() + "'>\n" +
						"<Shape DEF='CervicalVertebra'\n" +
							    " containerField='children'>\n" +
							    " <Appearance\n" +
							    "  containerField='appearance'>\n" +
							    " <Material DEF='Rust'\n" +
							    "containerField='material'\n" +
							    "ambientIntensity='" + bioMightTransform.getMaterial().getAmbientIntensity() + "'\n" +
							    "shininess='" 		 + bioMightTransform.getMaterial().getShininess() + "'\n" +
							    "transparency='" 	 + bioMightTransform.getMaterial().getTransparency() + "'\n" +
							    "diffuseColor='" + 
							    bioMightTransform.getMaterial().getDiffuseColor().getRed() + " " + 
							    bioMightTransform.getMaterial().getDiffuseColor().getGreen() + " " +
							    bioMightTransform.getMaterial().getDiffuseColor().getBlue() + "'/>\n" +
							 	"</Appearance>\n" +			    
							 	"<IndexedFaceSet DEF='CervicalVertebraIFS' \n" +
							    	   "containerField='geometry' \n" +
							    	   "creaseAngle='" +  bioMightTransform.getCreaseAngle() + "'\n" +
							    	   "coordIndex='" + bioMightTransform.getCoordindexStr() + "'>" +
							    	   "<Coordinate DEF='CervicalVertebra_Coord' \n" +
							    	    "containerField='coord' point='" +  bioMightTransform.getCoordpointStr() + "'/>" +
							    	  "</IndexedFaceSet>\n" +
						"</Shape>\n" +
				 "</Transform>\n"; 
			}
			else
			{
				body = "";//						
			}
			
			}
			
			//System.out.println("CervicalVertebra X3D: " + body);		
			String footer = "</Scene>" + "</X3D>\n";
			
			if (snipet)
				return body;			
			else	
				return header + body + footer;
		}

	}