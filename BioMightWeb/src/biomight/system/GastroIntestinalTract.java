/*
 * Created on Jul 22, 2006
 * Copyright 2006 - Biomight.org
 * 
 * This code is the not to be used without written permission from
 * BioMight.org
 * 
 */
 
package biomight.system;
import biomight.bacteria.rods.gramnegative.*;
import biomight.bacteria.misc.*;
import biomight.bacteria.rods.gramnegative.*;
import biomight.virus.picornaviridae.enteroviridae.*;
import biomight.protozoa.*;
import biomight.bacteria.rods.grampositive.*;
import biomight.virus.rna.*;
import biomight.system.tissue.membranes.*;


/**
 * @author SurferJim
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class GastroIntestinalTract extends DigestiveSystem {

	private Mucosa Mucosa;
	private SubMucosa Submucosa;
	private MuscularisExterna muscularisExterna;
	private Serosa serosa;
	private LumenOfDigestiveTract lumenOfDigestiveTract;
	
	
	public void onContact(Object obj)
	{	
		// Check if a virus is making contact with
		// the GastroIntestinal components

		if (obj instanceof ClostridiumDifficile)
		{
			// Dysentery
		}

		if (obj instanceof ShigellaDysenteriae)
		{
			// Dysentery
		}

		if (obj instanceof SalmonellaTyphi)
		{
			// Typhoid Fever
		}

		if (obj instanceof SalmonellaEnteritidis)
		{
			// Diarrhea?
		}
		
		if (obj instanceof SalmonellaTyphimurium)
		{
			// 
		}

		if (obj instanceof VibrioCholerae)
		{
			// Cholera
		}


		if (obj instanceof HepatitisAVirus)
		{
			// Infectious Hepatitus
		}

		if (obj instanceof RotaVirus)
		{
			// PolioMyelitis
		}
		
		if (obj instanceof PolioVirus)
		{
			// PolioMyelitis
		}
		
		

		if (obj instanceof GiardiaLamblia)
		{
			// Trichinosis
		}
		
		
		if (obj instanceof TrichinellaSpiralis)
		{
			// Trichinosis
		}

		if (obj instanceof CryptosporidiumParvum)
		{
			// Diarrhea
		}
		
		if (obj instanceof LeptospiraInterrogans)
		{
			// Diarrhea
		}		
	
	}
	
	public void setMucous()
	{		
	}
	
}
