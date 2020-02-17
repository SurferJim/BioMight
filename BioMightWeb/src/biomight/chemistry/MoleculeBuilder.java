/*
 * Created on Jun 8, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.chemistry;

import java.util.ArrayList;







import biomight.BioMightBase;
import biomight.Constants;
import biomight.chemistry.aminoacid.Alanine;
import biomight.chemistry.aminoacid.Arginine;
import biomight.chemistry.aminoacid.Asparagine;
import biomight.chemistry.aminoacid.AsparticAcid;
import biomight.chemistry.aminoacid.Cysteine;
import biomight.chemistry.aminoacid.GlutamicAcid;
import biomight.chemistry.aminoacid.Glutamine;
import biomight.chemistry.aminoacid.Glycine;
import biomight.chemistry.aminoacid.Histidine;
import biomight.chemistry.aminoacid.IsoLeucine;
import biomight.chemistry.aminoacid.Leucine;
import biomight.chemistry.aminoacid.Lysine;
import biomight.chemistry.aminoacid.Methionine;
import biomight.chemistry.aminoacid.Phenylalanine;
import biomight.chemistry.aminoacid.Proline;
import biomight.chemistry.compound.*;
import biomight.chemistry.elements.*;
import biomight.view.BioMightMethodView;
import biomight.view.BioMightPosition;
import biomight.view.BioMightScale;

/**
 * @author SurferJim
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class MoleculeBuilder extends BioMightBase {

	private Carboxyl carboxyl;
	private Amine amine;
	private Calcium calcium;
	private Carbon carbon;
	private Hydrogen hydrogen;
	private Nitrogen nitrogen;
	private Oxygen oxygen;
	private Sulfur sulfur;
	private Object base;


	public MoleculeBuilder()
	{
	}
	
	
	public MoleculeBuilder(String formula, String parentID, ArrayList<BioMightMethodView> bioMightMethods){
		
		// Run through the forumla string
		// Use introspection to get the associated Java Object
		//  Store it in the chain.  The chain is a mathematical probable relationship
		// given the right soup
		
		int localVP = Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;

		BioMightScale bioScale = new BioMightScale("0.00, 0.00, 0.00");
		BioMightPosition  bioPos = new BioMightPosition("0.00, 0.00, 0.00");
		String bioTemplate="Molecules.x3d";

	
		
		String[] myAtoms = formula.split("-");
		for (int i=0; i<myAtoms.length; i++){	
		
			if (myAtoms[i].equals("C")) {
				
				//carbon = new Carbon(parentID, bioMightMethods);
				
				carbon = new Carbon(localVP, localLOD, null, null, bioMightMethods);	
				initProperty(Constants.CarbonRef, Constants.Carbon, Constants.CarbonRef, carbon.getComponentID(), bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);								
				System.out.println("In Elements - Carbon is complete");
			
			}
			if (myAtoms[i].equals("Ca")) {
				//Calcium calcium = new Calcium(parentID, bioMightMethods);	
			}
			else if (myAtoms[i].equals("H")) {
				//Hydrogen hydrogen = new Hydrogen(parentID, bioMightMethods);	
			}
			else if (myAtoms[i].equals("N")) {
				//Nitrogen nitrogen = new Nitrogen(parentID, bioMightMethods);
			}		
			else if (myAtoms[i].equals("O")) {
				//Oxygen oxygen = new Oxygen(parentID, bioMightMethods);
			}
			else
			{}
		
		}		
		
	}
}
