/*
 * Created on Apr 28, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.cell.bloodandimmune;
import biomight.chemistry.compound.*;
import biomight.chemistry.protein.*;
import biomight.antibodies.*;

/**
 * @author SurferJim
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class PreBCell {

	private MajorHistocompatibilityComplex mHC;
	private B7Protein Bb7Protein;
	private IgM immunoglobinM;

	//private ProteinCD40 proteinCD40;


	public void onContact(Object obj)
	{
		

		if (obj instanceof Antibody)
		{
			// Engulf the Antigen and Digest
			// 		
		}

		if (obj instanceof HelperTCell)
		{
	
			
		}

	}



	public void setBCellReceptor()
	{
		
	}
	
	
	public void setImmunoglobulinHeavyChainGenes()
	{
	}
	
	public void setImmunoglobulinLightChainGenes()
	{
	}	

}
