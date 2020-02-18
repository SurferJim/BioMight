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



import biomight.Constants;
import biomight.exceptions.DataSecurityException;
import biomight.exceptions.ServerException;
import biomight.system.cartilage.Cartilage;
import biomight.system.tissue.connective.EndosteumTissue;
import biomight.system.tissue.connective.PeriosteumTissue;
import biomight.system.tissue.connective.blood.Blood;
import biomight.system.tissue.connective.bone.BoneMarrow;
import biomight.system.tissue.connective.bone.BoneTissue;
import biomight.system.tissue.connective.bone.HaversianCanal;
import biomight.system.tissue.connective.bone.Lacunae;
import biomight.system.tissue.connective.bone.Osteons;
import biomight.system.tissue.connective.bone.ResorptionSpaces;
import biomight.system.tissue.nervous.Nerves;
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
	 * Representation of the CoccygealVertebra
	 * 
	 */
	public class CoccygealVertebra extends Vertebra {
		private String name;
		private ArrayList<BioMightPropertyView> properties;
		private ArrayList<BioMightMethodView> methods;

	
		public CoccygealVertebra()
		{
			create(Constants.CoccygealVertebraeRef, null);
		}

		
		public CoccygealVertebra(String parentID)
		{
			create(parentID, null);
		}

		public CoccygealVertebra(String parentID, ArrayList<BioMightMethodView> bioMightMethods)
		{
			create(parentID, bioMightMethods);
		}
		
		/*******************************************************
		 * createCoccygealVertebra
		 * 
		 * Create a 3D model of the Coccygeal Vertebra based upon the
		 * properties of the object.
		 * 
		 *******************************************************/

		public void create(String parentID, ArrayList<BioMightMethodView> bioMightMethods)
		{
			this.setImage("images/CoccygealVertebra.jpg");
			this.setImageHeight(300);
			this.setImageWidth(300);

			// Construct its boneTissue
			boneTissue = null;
			osteons =  null;
			resorptionSpaces = null;
			lacunae = null;
			haversianCanal = null;
			boneMarrow = null;
			endosteumTissue = null; 
			periosteumTissue = null;
			nerves = null;
			//vessels = null;
			cartilage = null;

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
		 * This method will return the X3D for the Cell.  It runs through each of its components and collects up their
		 * representations and then assembles them into one unified X3D model.
		 * 
		 ********************************************************************************************************************/
		public String getX3D(boolean snipet) {
			
			// Assemble the CoccygealVertebra
			String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
			"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n " +
			"<X3D profile='Immersive' >\n" +
			"<head>\n" +
			 "<meta name='BioMightImage' content='CoccygealVertebra.jpg'/>\n" +
			 "<meta name='ExportTime' content='7:45:30'/>\n" +
			 "<meta name='ExportDate' content='08/15/2008'/>\n" +
			 "<meta name='BioMight Version' content='1.0'/>\n" + 
			"</head>\n" +
			"<Scene>\n" +
			"<WorldInfo\n" +
			"title='CoccygealVertebra'\n" +
			"info='\"BioMight Generated X3D\"'/>\n";		

			String body = "";		
			/*boneTissue.getX3D(true);
			osteons =  null;
			resorptionSpaces = null;
			lacunae = null;
			haversianCanal = null;
			boneMarrow = null;
			endosteumTissue = null; 
			periosteumTissue = null;
			nerves = null;
			vessels = null;
			cartilage = null; */
			
			System.out.println("CoccygealVertebra X3D: " + body);		
			String footer = "</Scene>" + "</X3D>\n";
			
			if (snipet)
				return body;			
			else	
				return header + body + footer;
		}


		public String getName() {
			return name;
		}


		public void setName(String name) {
			this.name = name;
		}

	}