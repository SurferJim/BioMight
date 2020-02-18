/*
* Created on Jul 18, 2006
* Copyright 2006 - Biomight.org
* 
* This code is the not to be used without written permission from
* BioMight.org
* 
*/
package biomight.system.skeletal.leg.tibia;
import biomight.system.tissue.connective.bone.Bone;

/**
* @author SurferJim
*
* BioMight Component Class - Feb 2007
*
*/
public class TibiaCondyles extends Bone {

	public TibiaCondyles()
	{
		this.setImage("images/TibiaCondyles.jpg");
		this.setImageHeight(300);
		this.setImageWidth(300);
	}

private LateralCondyle lateralCondyle;
private MedialCondyle medialCondyle;

}
