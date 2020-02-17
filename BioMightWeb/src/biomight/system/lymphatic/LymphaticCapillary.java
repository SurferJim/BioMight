/*
 * Created on Jul 21, 2006
 * Copyright 2006 - Biomight.org
 * 
 * A lymphatic capillary that absorbs dietary fats in the villi of the small intestine.
 * 
 */
 
package biomight.system.lymphatic;
import biomight.BioMightBase;

/**
 * @author SurferJim
 *
 * A lymphatic capillary that absorbs dietary fats in the villi of the small intestine.
 * 
 */
public class LymphaticCapillary extends BioMightBase {
	private Chyle chyle; 
	
	
	public LymphaticCapillary()
	{
		this.setImage("images/LymphaticCapillary.gif");
		this.setImageWidth(320);
		this.setImageHeight(400);
	}
}
