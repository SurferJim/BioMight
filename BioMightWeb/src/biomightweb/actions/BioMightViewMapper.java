package biomightweb.actions;

import java.util.ArrayList;

import biomight.BioMightKey;
import biomight.BioMightKeys;
import biomight.Constants;
import biomightweb.view.BioMightComponent;

/*******************************************************************************************************
 * The main action class for biomight. 
 * 
 * SurferJim
 ******************************************************************************************************/

public class BioMightViewMapper {
	

	/****************************************************************************
	 * MAP COMPONENT
	 * 
	 * Process the form
	 * 
	 ***************************************************************************/
	public BioMightComponent mapComponent(BioMightComponent bioMightComponent, Object bioMightInstance, boolean snippet) {

		String bioMightComponentRef = bioMightComponent.getBioMightComponentRef();
		
		
		/**************************************************************************
		*
		* CHEMISTRY
		* 
		***************************************************************************/				
		if (bioMightComponentRef.startsWith(Constants.ChemistryLibrary))
		{
			System.out.println("Going to BioMightViewChemistry");
			BioMightViewChemistry bioMightViewChemistry = new BioMightViewChemistry();
			bioMightComponent = bioMightViewChemistry.mapComponent(bioMightComponent,  bioMightInstance, snippet);
			System.out.println("Back from to BioMightViewChemistry");
		}
		
		/**************************************************************************
		*
		* VIRUS
		* 
		***************************************************************************/				
		else if (bioMightComponentRef.startsWith(Constants.VirusLibrary))
		{
			BioMightViewVirus bioMightViewVirus = new BioMightViewVirus();
			bioMightComponent = bioMightViewVirus.mapComponent(bioMightComponent,  bioMightInstance, snippet);
		}
			
		/**************************************************************************
		*
		* BACTERIA
		* 
		***************************************************************************/				
		else if (bioMightComponentRef.startsWith(Constants.BacteriaLibrary))
		{
			BioMightViewBacteria bioMightViewBacteria = new BioMightViewBacteria();
			bioMightComponent = bioMightViewBacteria.mapComponent(bioMightComponent,  bioMightInstance, snippet);
		}			
		/**************************************************************************
		*
		* CELLS
		* 
		***************************************************************************/				
		else if (bioMightComponentRef.startsWith(Constants.CellLibrary))
		{
			BioMightViewCell bioMightViewCell = new BioMightViewCell();
			bioMightComponent = bioMightViewCell.mapComponent(bioMightComponent,  bioMightInstance, snippet);
		}
		/**************************************************************************
		*
		* PATHWAYW
		* 
		***************************************************************************/				
		else if (bioMightComponentRef.startsWith(Constants.PathwaysLibrary))
		{
			System.out.println("Drilling into Pathways System");
			BioMightViewPathways bioMightViewPathways = new BioMightViewPathways();
			bioMightComponent = bioMightViewPathways.mapComponent(bioMightComponent,  bioMightInstance, snippet);
		}
		/**************************************************************************
		*
		* VASCULAR
		* 
		***************************************************************************/				
		else if (bioMightComponentRef.startsWith(Constants.VascularLibrary))
		{
			System.out.println("Drilling into Vascular System");
			BioMightViewVascular bioMightViewVascular = new BioMightViewVascular();
			bioMightComponent = bioMightViewVascular.mapComponent(bioMightComponent,  bioMightInstance, snippet);
		}
		/**************************************************************************
		*
		* MUSCULAR
		* 
		***************************************************************************/				
		else if (bioMightComponentRef.startsWith(Constants.MuscularLibrary))
		{
			System.out.println("Drilling into Muscular System");
			BioMightViewMuscular bioMightViewMuscular = new BioMightViewMuscular();
			bioMightComponent = bioMightViewMuscular.mapComponent(bioMightComponent,  bioMightInstance, snippet);
		}
		/**************************************************************************
		*
		* SKELETAL
		* 
		***************************************************************************/				
		else if (bioMightComponentRef.startsWith(Constants.SkeletalLibrary))
		{
			System.out.println("Drilling into Skeletal System");
			BioMightViewSkeletal bioMightViewSkeletal = new BioMightViewSkeletal();
			bioMightComponent = bioMightViewSkeletal.mapComponent(bioMightComponent,  bioMightInstance, snippet);
		}
		/**************************************************************************
		*
		* LIGAMENT
		* 
		***************************************************************************/				
		else if (bioMightComponentRef.startsWith(Constants.DesmosLibrary))
		{
			System.out.println("Drilling into Ligament System");
			BioMightViewLigament bioMightViewLigament = new BioMightViewLigament();
			bioMightComponent = bioMightViewLigament.mapComponent(bioMightComponent,  bioMightInstance, snippet);
		}
		/**************************************************************************
		*
		* SYMBOLS
		* 
		***************************************************************************/				

		else if (bioMightComponentRef.startsWith(Constants.BioSymbolsLibrary))
		{

			System.out.println("Drilling into Symbols System");
			BioMightViewSymbols bioMightViewSymbols = new BioMightViewSymbols();
			bioMightComponent = bioMightViewSymbols.mapComponent(bioMightComponent,  bioMightInstance, snippet);
		}	
	
		/**************************************************************************
		*
		* TISSUES
		* 
		***************************************************************************/			
		
		else if (bioMightComponentRef.startsWith(Constants.TissueLibrary))
		{
			System.out.println("Drilling into Tissues System");
			BioMightViewTissues bioMightViewTissues = new BioMightViewTissues();
			bioMightComponent = bioMightViewTissues.mapComponent(bioMightComponent,  bioMightInstance, snippet);
		}	
		/**************************************************************************
		*
		* BODY
		* 
		***************************************************************************/			
		else
		{
			System.out.println("Drilling into the Body Systems");
			BioMightViewBody bioMightViewBody = new BioMightViewBody();
			bioMightComponent = bioMightViewBody.mapComponent(bioMightComponent,  bioMightInstance, snippet);
		}
	
		return bioMightComponent;
		}
	
}
