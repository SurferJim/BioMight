/*
 * Created on Jul 22, 2006
 * Copyright 2006 - Biomight.org
 * 
 * This code is the not to be used without written permission from
 * BioMight.org
 * 
 */
 
package biomight;

import java.util.ArrayList;

import javax.naming.InitialContext;




import biomight.Constants;
import biomight.ejb.BioMightBeanLocal;
import biomight.ejb.BioMightVascularBeanLocal;
import biomight.exceptions.ServerException;
import biomight.system.tissue.edothelial.EndotheliumTissue;
import biomight.system.vascular.arteries.Artery;
import biomight.view.BioMightInstructSet;
import biomight.view.BioMightMethodView;
import biomight.view.BioMightPosition;
import biomight.view.BioMightPropertyView;
import biomight.view.BioMightTransform;

/**
 * @author SurferJim
 *
 * BioBuilder
 * 
 */

public class BioBuilder {

	
	// Default Constructor
	public BioBuilder()
	{
	}

	
	// Get the Builder Code
	public BioMightInstructSet getBioCode(String compType, String parentID)
	{
		// Generate the CysticArtery Edothelium		
		BioMightBeanLocal bioMightBean;
		BioMightInstructSet instructSet = null;
		
		try {
			// Get the information from the database via the Enterprise Bean		
			InitialContext ctx = new InitialContext();
			bioMightBean = (BioMightBeanLocal) ctx.lookup("java:global/BioMightWeb/BioMightBean!biomight.ejb.BioMightBeanLocal");
			instructSet = bioMightBean.getBioCode(compType, parentID);			   	
			
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - CysticArteryEndothelium");
			throw new ServerException("Remote Exception CysticArteryEndothelium():", e); 	
		}
		
		return instructSet;
	}
	
	
		 
	
}
