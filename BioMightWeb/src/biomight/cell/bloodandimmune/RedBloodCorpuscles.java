/*
 * Created on Jul 21, 2006
 * Copyright 2006 - Biomight.org
 * 
 * This code is the not to be used without written permission from
 * BioMight.org
 * 
 */
 
package biomight.cell.bloodandimmune;
import java.util.ArrayList;

/**
 * @author SurferJim
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class RedBloodCorpuscles {

	private ArrayList redBloodCorpuscles;
	
	/*
	 * Create default Thymocytes
	 */
	public RedBloodCorpuscles() {

	}
		
	/**
	 * Create a bunch of Lymphocytes and distribute them throughout the body
	 * 
	 */		
	public RedBloodCorpuscles(int numRedBloodCorpuscles) {
		redBloodCorpuscles = new ArrayList();
		
		for (int i=0; i<numRedBloodCorpuscles; i++)
		{
			RedBloodCorpuscle redBloodCorpuscle = new RedBloodCorpuscle();
			redBloodCorpuscles.add(i, redBloodCorpuscle);
		}
			
	}
}
