/*
 * Created on Jul 18, 2006
 * Copyright 2006 - Biomight.org
 * 
 * This code is the not to be used without written permission from
 * BioMight.org
 * 
 */

package biomight.system.skeletal.spine;


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
	 * Representation of the LumbarVertebrae.  It contains a collection of 
	 * LumbarVertebra that support the head.
	 * 
	 */
	public class LumbarVertebraeOld extends BioMightBase { 
		private ArrayList lumbarVertebrae;
		
		/*
		 * Need to map database elements into base classes	
		private LumbarVertebraL1 lumbarVertebraL1;
		private LumbarVertebraL2 lumbarVertebraL2;
		private LumbarVertebraL3 lumbarVertebraL3;
		private LumbarVertebraL4 lumbarVertebraL4;
		private LumbarVertebraL5 lumbarVertebraL5;	*/	
		
		
		public LumbarVertebraeOld()
		{
			create(Constants.LumbarVertebraeRef, null);
		}

		
		public LumbarVertebraeOld(String parentID)
		{
			this.parentID = parentID;
			create(parentID, null);
		}
		
		
		public LumbarVertebraeOld(String parentID, ArrayList<BioMightMethodView> bioMightMethods)
		{
			this.parentID = parentID;
			create(parentID, bioMightMethods);
		}

		
		
		/*******************************************************
		 * createLumbarVertebrae
		 * 
		 * Create a 3D model of the Lumbar Vertebra based upon the
		 * properties of the object.
		 * 
		 *******************************************************/

		public void create(String parentID, ArrayList<BioMightMethodView> bioMightMethods)
		{
			this.setImage("images/LumbarVertebra.jpg");
			this.setImageHeight(300);
			this.setImageWidth(300);
			lumbarVertebrae = new ArrayList();
			
			// Get the information from the database via the Enterprise Bean		
			try {
				// Get the information from the database via the Enterprise Bean		
				System.out.println("Getting LumbarVertebraeInfo for ParentID: " + parentID);
				InitialContext ctx = new InitialContext();
				BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
				bioMightTransforms = bioMightBean.getComponents(Constants.LumbarVertebraRef, parentID); 	
			}catch (Exception e) { 
				System.out.println("Exception Getting Components - LumbarVertebrae");
				throw new ServerException("Remote Exception getComponents():", e); 	
			}
				
			// Run through Forehead and build them into the model
			ArrayList transforms = bioMightTransforms.getTransforms();
			System.out.println("LumbarVertebrae NumTransforms: " + transforms.size());
			for (int i=0; i<transforms.size(); i++)
			{
				// Get the information for the Forehead we are creating
				BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
				System.out.println("Creating LumbarVertebrae (name,id): " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
				
				// Create an instance of the Vertebra based on information in the repository
				LumbarVertebraOld lumbarVertebra = new LumbarVertebraOld(bioMightTransform.getId());	
				lumbarVertebrae.add(i, lumbarVertebra);
				initProperty(bioMightTransform.getName(), Constants.LumbarVertebra, Constants.LumbarVertebraRef, lumbarVertebra.getComponentID());
				
				System.out.println("LumbarVertebra added to Collection");			
			}	
			

			//initProperties();
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
		 * This method will return the X3D for the LumbarVertebrae.  It runs through each of its components and collects up their
		 * representations and then assembles them into one unified X3D model.
		 * 
		 ********************************************************************************************************************/
	public String getX3D(boolean snipet) {
			
			// Assemble the LumbarVertebrae
			String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
			"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n " +
			"<X3D profile='Immersive' >\n" +
			"<head>\n" +
			 "<meta name='BioMightImage' content='LumbarVertebrae.jpg'/>\n" +
			 "<meta name='ExportTime' content='7:45:30'/>\n" +
			 "<meta name='ExportDate' content='08/15/2008'/>\n" +
			 "<meta name='BioMight Version' content='1.0'/>\n" + 
			"</head>\n" +
			"<Scene>\n" +
			"<WorldInfo\n" +
			"title='LumbarVertebraC1'\n" +
			"info='\"BioMight Generated X3D\"'/>\n";		


			String body = "";

			// Build the model based on what you are looking based on LOD
			int viewPerspective = Constants.VIEW_DETACHED;
			if (viewPerspective == Constants.VIEW_INTERNAL)
			{			
				for (int i=0; i<lumbarVertebrae.size(); i++)
				{
					// Get the information for the eye
					LumbarVertebraOld lumbarVertebra = (LumbarVertebraOld) lumbarVertebrae.get(i);
					//System.out.println("Getting X3D for LumbarVertebra");
					body += lumbarVertebra.getX3D(true);
				}
			}
			else if (viewPerspective == Constants.VIEW_DETACHED)
			{
				// Run through the collection of Pupils and build them into the model
				// In the default case, we get one instance of the Pupil for each eye
				ArrayList transforms = bioMightTransforms.getTransforms();
				for (int i=0; i<transforms.size(); i++)
				{
					// Get the information for the PinnaAntiHelix we are creating
					BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
					System.out.println("Getting LumbarVertebrae X3D: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
			
			
					//System.out.println("Getting X3D for LumbarVertebraeX: " + bioMightSphere.getTranslation().getXPos());
					//System.out.println("Getting X3D for LumbarVertebraeY: " + bioMightSphere.getTranslation().getYPos());
					//System.out.println("Getting X3D for LumbarVertebraeZ: " + bioMightSphere.getTranslation().getZPos());
					// Change the height and width based on the displacement.
					body += "<Transform DEF='LumbarVertebra'\n" +
			 		"translation='" + bioMightTransform.getTranslation().getXPos() + " " 
				 					+ bioMightTransform.getTranslation().getYPos() + " "
				 					+ bioMightTransform.getTranslation().getZPos() + "'\n" +
				 	"scale='" 	+ bioMightTransform.getScale().getXPos() + " "
				 				+ bioMightTransform.getScale().getYPos() + " "
				 				+ bioMightTransform.getScale().getZPos() + "'>\n" +
					"<Shape DEF='LumbarVertebra'\n" +
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
							 	"<IndexedFaceSet DEF='LumbarVertebraIFS' \n" +
							    	   "containerField='geometry' \n" +
							    	   "creaseAngle='" +  bioMightTransform.getCreaseAngle() + "'\n" +
							    	   "coordIndex='" + bioMightTransform.getCoordindexStr() + "'>" +
							    	   "<Coordinate DEF='LumbarVertebra_Coord' \n" +
							    	    "containerField='coord' point='" +  bioMightTransform.getCoordpointStr() + "'/>" +
							    	  "</IndexedFaceSet>\n" +
					"</Shape>\n" +
				 "</Transform>\n"; 
				}
			}
			else
			{
				body = "";//						
			}
			
			
			
			//System.out.println("LumbarVertebra X3D: " + body);		
			String footer = "</Scene>" + "</X3D>\n";
			
			if (snipet)
				return body;			
			else	
				return header + body + footer;
		}

	}