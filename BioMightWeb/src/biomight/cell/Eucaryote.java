/*
 * Created on Apr 26, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.cell;
import biomight.BioMightBase;
import biomight.cell.nucleus.*;
import biomight.chemistry.compound.*;
import java.math.BigDecimal;
import biomight.cell.bloodandimmune.*;


/**
 * @author SurferJim
 *
 * This Class represents a base cell. It contains characteristics that are common to all cells.
 * 
 */
public class Eucaryote extends Cell {


	public Eucaryote()
	{
		this.setImage("images/Eucaryote.jpg");
		
	}
	
		public Eucaryote(EucaryoteConfig cellConfig)
		{
			this.setImage("images/Cell.jpg");

			// Create thc components of the Cell
			/*		
			cellMembrane = new CellMembrane();
			cellWall = new CellWall();
			centriole = new Centriole();
			chromatin = new Chromatin();
			cytoskeleton = new Cytoskeleton();
			cytosol = new Cytosol();
			endoPlasmicReticulumRough = new EndoPlasmicReticulumRough();
			endoPlasmicReticulumSmooth = new EndoPlasmicReticulumSmooth();
			golgiApparatus = new GolgiApparatus();
			lysosome = new Lysosome();
			mitochondrian = new Mitochondrian();
			nucleus = new Nucleus();
			peroxisome = new Peroxisome(); 
			secretoryVesicle = new SecretoryVesicle();
			ionPump = new IonPump();
			melanosome = new Melanosome();
			ionChannel = new IonChannel();
			ribosome = new Ribosome();
			*/
		}

		

	public void onContact(Object obj)
	{	


		if (obj instanceof CytotoxicTCell)
		{
			// Cytotoxic T Cells will interact strongly
			// if the cell is virus infected.
			
		}
	}
	
}
