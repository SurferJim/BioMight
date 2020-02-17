/*
 * Created on Jul 23, 2006
 * Copyright 2006 - Biomight.org
 * 
 * This code is the not to be used without written permission from
 * BioMight.org
 * 
 */
 
package biomight.cell.hormonesecreting;
import biomight.chemistry.hormones.steroid.glucocorticoids.*;
import biomight.chemistry.hormones.aminederived.catecholamines.*;

/**
 * @author SurferJim
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class CorticalCell extends HormoneSecretingCell {
	private Cortisol cortisol;
	private Adrenaline adrenaline;
	

	public CorticalCell()
	{
		setImage("images/CorticalCell.gif");
		setImageWidth(250);
		setImageHeight(250);
	}
	
}
