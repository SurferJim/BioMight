package biomightweb.actions;

import java.util.ArrayList;

import biomight.BioMightKey;
import biomight.BioMightKeys;
import biomight.Constants;
import biomight.bacteria.Bacteria;
import biomight.bacteria.BacterialCell;
import biomight.bacteria.Bacterias;
import biomight.bacteria.cocci.gramnegative.Gonococci;
import biomight.bacteria.cocci.gramnegative.Gonococcus;
import biomight.bacteria.cocci.gramnegative.Meningococci;
import biomight.bacteria.cocci.gramnegative.Meningococcus;
import biomight.bacteria.cocci.grampositive.StaphylococciAureus;
import biomight.bacteria.cocci.grampositive.StaphylococciEpidermidis;
import biomight.bacteria.cocci.grampositive.StaphylococciSaprophyticus;
import biomight.bacteria.cocci.grampositive.Staphylococcus;
import biomight.bacteria.cocci.grampositive.StaphylococcusAureus;
import biomight.bacteria.cocci.grampositive.StaphylococcusEpidermidis;
import biomight.bacteria.cocci.grampositive.StaphylococcusSaprophyticus;
import biomight.bacteria.cocci.grampositive.StreptococciAgalactiae;
import biomight.bacteria.cocci.grampositive.StreptococciAnginosus;
import biomight.bacteria.cocci.grampositive.StreptococciGordoni;
import biomight.bacteria.cocci.grampositive.StreptococciIntermedius;
import biomight.bacteria.cocci.grampositive.StreptococciSanguinis;
import biomight.bacteria.cocci.grampositive.StreptococciBovis;
import biomight.bacteria.cocci.grampositive.StreptococciFaecalis;
import biomight.bacteria.cocci.grampositive.StreptococciMitis;
import biomight.bacteria.cocci.grampositive.StreptococciMutans;
import biomight.bacteria.cocci.grampositive.StreptococciPneumoniae;
import biomight.bacteria.cocci.grampositive.StreptococciPyogenes;
import biomight.bacteria.cocci.grampositive.StreptococciSalivarius;
import biomight.bacteria.cocci.grampositive.StreptococciViridans;
import biomight.bacteria.cocci.grampositive.StreptococcusAgalactiae;
import biomight.bacteria.cocci.grampositive.StreptococcusAnginosus;
import biomight.bacteria.cocci.grampositive.StreptococcusSanguinis;
import biomight.bacteria.cocci.grampositive.StreptococcusBovis;
import biomight.bacteria.cocci.grampositive.StreptococcusFaecalis;
import biomight.bacteria.cocci.grampositive.StreptococcusGordoni;
import biomight.bacteria.cocci.grampositive.StreptococcusIntermedius;
import biomight.bacteria.cocci.grampositive.StreptococcusMitis;
import biomight.bacteria.cocci.grampositive.StreptococcusMutans;
import biomight.bacteria.cocci.grampositive.StreptococcusPneumoniae;
import biomight.bacteria.cocci.grampositive.StreptococcusPyogenes;
import biomight.bacteria.cocci.grampositive.StreptococcusSalivarius;
import biomight.bacteria.cocci.grampositive.StreptococcusViridans;
import biomight.bacteria.coccobacillus.gramnegative.BordetellaPertussis;
import biomight.bacteria.coccobacillus.gramnegative.BordetellaPertussises;
import biomight.bacteria.misc.AcinetobacterBaumannii;
import biomight.bacteria.misc.AcinetobacterBaumanniis;
import biomight.bacteria.misc.Actinobacillus;
import biomight.bacteria.misc.Aeromonas;
import biomight.bacteria.misc.Alcaligenes;
import biomight.bacteria.misc.ArizonaHinshawii;
import biomight.bacteria.misc.CorynebacteriumMinutissimum;
import biomight.bacteria.misc.CoxiellaBurnetii;
import biomight.bacteria.misc.ErysipelothrixRhusiopathiae;
import biomight.bacteria.misc.KlebsiellaPneumoniae;
import biomight.bacteria.misc.LegionellaPneumophila;
import biomight.bacteria.misc.LeptospiraInterrogans;
import biomight.bacteria.pleomorphic.gramnegative.FrancisellaTularensis;
import biomight.bacteria.pleomorphic.gramnegative.HaemophilusInfluenzae;
import biomight.bacteria.pleomorphic.grampositive.ActinomycesGerencseriae;
import biomight.bacteria.pleomorphic.grampositive.ActinomycesIsraelii;
import biomight.bacteria.pleomorphic.grampositive.MycobacteriumAviumIntracellulareComplex;
import biomight.bacteria.pleomorphic.grampositive.MycobacteriumBovis;
import biomight.bacteria.pleomorphic.grampositive.MycobacteriumKansasii;
import biomight.bacteria.pleomorphic.grampositive.MycobacteriumLeprae;
import biomight.bacteria.pleomorphic.grampositive.MycobacteriumMarinum;
import biomight.bacteria.pleomorphic.grampositive.MycobacteriumTuberculosis;
import biomight.bacteria.pleomorphic.grampositive.PropioniBacteriumPropionicus;
import biomight.bacteria.rods.gramnegative.AeromonasHydrophilia;
import biomight.bacteria.rods.gramnegative.AeromonasHydrophilias;
import biomight.bacteria.rods.gramnegative.AlcaligenesFaecalis;
import biomight.bacteria.rods.gramnegative.AlcaligenesFaecalises;
import biomight.bacteria.rods.gramnegative.ArachniaPropionica;
import biomight.bacteria.rods.gramnegative.SalmonellaEnterica;
import biomight.bacteria.rods.gramnegative.SalmonellaEntericas;
import biomight.bacteria.rods.gramnegative.SalmonellaTyphi;
import biomight.bacteria.rods.gramnegative.SalmonellaTyphimurium;
import biomight.bacteria.rods.gramnegative.SalmonellaTyphimuriums;
import biomight.bacteria.rods.gramnegative.SalmonellaTyphis;
import biomight.bacteria.rods.gramnegative.VibrioCholerae;
import biomight.bacteria.rods.gramnegative.VibrioCholeraes;
import biomight.bacteria.rods.grampositive.BacilliAnthracis;
import biomight.bacteria.rods.grampositive.BacillusAnthracis;
import biomight.bacteria.rods.grampositive.ClostridiumTetani;
import biomight.bacteria.rods.grampositive.ClostridiumTetanis;
import biomight.bacteria.rods.grampositive.CorynebacteriumJeikeium;
import biomight.bacteria.rods.grampositive.CorynebacteriumJeikeiums;
import biomight.bacteria.spirillum.CampylobacterJejuni;
import biomight.bacteria.spirillum.CampylobacterJejunis;
import biomight.bacteria.spirochete.TreponemaPallidum;
import biomight.bacteria.spirochete.TreponemaPallidums;
import biomightweb.view.BioMightComponent;

/**
 * Maps BioMight Bacteria Components into the associated Java class.
 * 
 * SurferJim
 * 
 */

public class BioMightViewBacteria {

	
	public void BioMightViewBacteria() {
		
	}
	
	public BioMightComponent mapComponent(BioMightComponent bioMightView, Object bioMightInstance, boolean snippet) {

		BioMightKeys bioMightKeys = bioMightView.getBioMightKeys();
		String bioMightComponentRef = bioMightView.getBioMightComponentRef();
		String bioMightComponentName = bioMightView.getBioMightComponentName();
		System.out.println("BioMightViewBacteria - Mapping Component: " + bioMightComponentRef);
		BioMightKey bioMightKey = new BioMightKey();
		boolean executeMethods = false;
				
		/**************************************************************************
		*
		* BACTERIA
		* 
		***************************************************************************/


		if (bioMightComponentRef.equals(Constants.Bacterias))
		{		
			Bacterias bacterias = (Bacterias) bioMightInstance;
			
			bioMightView.setImage(bacterias.getImage());
			bioMightView.setBioMightProperties(bacterias.getProperties());
			bioMightView.setBioMightMethods(bacterias.getMethods());
			bioMightView.setX3D(bacterias.getX3D(snippet));
			
			// Assooiate the component and ID.
			bioMightKey = new BioMightKey();
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(bacterias.getComponentID());
			
			System.out.println("Matched - BacteriasKey: " + bioMightComponentRef + "   ID: " + bacterias.getComponentID());
			bioMightKeys.setKey(bioMightKey);
			System.out.println("Matched BacteriasKey: " + bioMightComponentRef + "   ID: " + bacterias.getComponentID());
			
			// On the post of data, we map the web data back
			// into the methodView object.  
			if (executeMethods) {
				//bacterias.executeMethods(bioMightMethods);
				//bioMightView.setX3D(cell.getX3D(true));
			}
		}
		else if (bioMightComponentRef.equals(Constants.Bacteria))
		{
			Bacteria bacteria = (Bacteria) bioMightInstance;
			
			bioMightView.setImage(bacteria.getImage());
			bioMightView.setBioMightProperties(bacteria.getProperties());
			bioMightView.setBioMightMethods(bacteria.getMethods());
			//bioMightView.setX3D(bacteria.getX3D(snippet));
			
			// Assooiate the component and ID.
			bioMightKey = new BioMightKey();
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(bacteria.getComponentID());
			
			System.out.println("Matched - BacteriaKey: " + bioMightComponentRef + "   ID: " + bacteria.getComponentID());
			bioMightKeys.setKey(bioMightKey);
			System.out.println("Matched BacteriaKey: " + bioMightComponentRef + "   ID: " + bacteria.getComponentID());
			
			// On the post of data, we map the web data back
			// into the methodView object.  
			if (executeMethods) {
				//bacterias.executeMethods(bioMightMethods);
				//bioMightView.setX3D(cell.getX3D(true));
			}
			
		}
		else if (bioMightComponentRef.equals(Constants.BacterialCells))
		{
			BacterialCell cell = (BacterialCell) bioMightInstance;
			bioMightView.setImage(cell.getImage());
			bioMightView.setBioMightProperties(cell.getProperties());
			bioMightView.setBioMightMethods(cell.getMethods());
			
			// Assooiate the component and ID.
			bioMightKey = new BioMightKey();
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(cell.getComponentID());			
			System.out.println("Storing CellKey: " + bioMightComponentRef + "   ID: " + cell.getComponentID());
			bioMightKeys.setKey(bioMightKey);

			// On the post of data, we map the web data back
			// into the methodView object.  
			if (executeMethods) {
				//cell.executeMethods(bioMightView.getMethods());
				//bioMightView.setX3D(cell.getX3D());
			}
			
			bioMightView.setX3D(cell.getX3D(false));

		}
		else if (bioMightComponentRef.equals(Constants.BacterialCell))
		{
			BacterialCell cell = (BacterialCell) bioMightInstance;
			bioMightView.setImage(cell.getImage());
			bioMightView.setBioMightProperties(cell.getProperties());
			bioMightView.setBioMightMethods(cell.getMethods());
			
			// Assooiate the component and ID.
			bioMightKey = new BioMightKey();
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(cell.getComponentID());			
			System.out.println("Storing CellKey: " + bioMightComponentRef + "   ID: " + cell.getComponentID());
			bioMightKeys.setKey(bioMightKey);

			// On the post of data, we map the web data back
			// into the methodView object.  
			if (executeMethods) {
				//cell.executeMethods(bioMightView.getMethods());
				//bioMightView.setX3D(cell.getX3D());
			}
			
			bioMightView.setX3D(cell.getX3D(false));

		}
		else if (bioMightComponentRef.equals(Constants.AcinetobacterBaumanniis))
		{
			AcinetobacterBaumanniis acinetobacterBaumanniis = (AcinetobacterBaumanniis) bioMightInstance;
			bioMightView.setImage(acinetobacterBaumanniis.getImage());
			bioMightView.setBioMightProperties(acinetobacterBaumanniis.getProperties());
			bioMightView.setBioMightMethods(acinetobacterBaumanniis.getMethods());
			bioMightView.setBioMightCollection(true);
		
			// Assooiate the component and ID.
			bioMightKey = new BioMightKey();
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(acinetobacterBaumanniis.getComponentID());			
			System.out.println("Storing acinetobacterBaumanniis key: " + bioMightComponentRef + "   ID: " + acinetobacterBaumanniis.getComponentID());
			bioMightKeys.setKey(bioMightKey);

			// On the post of data, we map the web data back
			// into the methodView object.  
			if (executeMethods) {
				//bacillusAnthracis.executeMethods(bioMightMethods);
				//bioMightView.setX3D(bacillusAnthracis.getX3D(snippet));
			}
			
			bioMightView.setX3D(acinetobacterBaumanniis.getX3D(snippet));
		}	
		else if (bioMightComponentRef.equals(Constants.AcinetobacterBaumannii))
		{
			AcinetobacterBaumannii acinetobacterBaumannii = (AcinetobacterBaumannii) bioMightInstance;
			bioMightView.setImage(acinetobacterBaumannii.getImage());
			bioMightView.setBioMightProperties(acinetobacterBaumannii.getProperties());
			bioMightView.setBioMightMethods(acinetobacterBaumannii.getMethods());
			bioMightView.setBioMightCollection(true);
		
			// Assooiate the component and ID.
			bioMightKey = new BioMightKey();
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(acinetobacterBaumannii.getComponentID());			
			System.out.println("Storing acinetobacterBaumannii key: " + bioMightComponentRef + "   ID: " + acinetobacterBaumannii.getComponentID());
			bioMightKeys.setKey(bioMightKey);

			// On the post of data, we map the web data back
			// into the methodView object.  
			if (executeMethods) {
				//bacillusAnthracis.executeMethods(bioMightMethods);
				//bioMightView.setX3D(bacillusAnthracis.getX3D(snippet));
			}
			
			bioMightView.setX3D(acinetobacterBaumannii.getX3D(snippet));
		}
		else if (bioMightComponentRef.equals(Constants.Actinobacillus))
		{
			Actinobacillus actinobacillus = (Actinobacillus) bioMightInstance;
			bioMightView.setImage(actinobacillus.getImage());
		}	
		else if (bioMightComponentRef.equals(Constants.Actinobacillus))
		{
			Actinobacillus actinobacillus = (Actinobacillus) bioMightInstance;
			bioMightView.setImage(actinobacillus.getImage());
		}						
		else if (bioMightComponentRef.equals(Constants.Aeromonas))
		{
			Aeromonas aeromonas = (Aeromonas) bioMightInstance;
			bioMightView.setImage(aeromonas.getImage());
		}	
		else if (bioMightComponentRef.equals(Constants.AeromonasHydrophilias))
		{		
			AeromonasHydrophilias aeromonasHydrophilias = (AeromonasHydrophilias) bioMightInstance;
			bioMightView.setImage(aeromonasHydrophilias.getImage());
			bioMightView.setBioMightProperties(aeromonasHydrophilias.getProperties());
			bioMightView.setBioMightMethods(aeromonasHydrophilias.getMethods());
			bioMightView.setBioMightCollection(true);
		
			// Assooiate the component and ID.
			bioMightKey = new BioMightKey();
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(aeromonasHydrophilias.getComponentID());			
			System.out.println("Storing AeromonasHydrophilia Key: " + bioMightComponentRef + "   ID: " + aeromonasHydrophilias.getComponentID());
			bioMightKeys.setKey(bioMightKey);

			// On the post of data, we map the web data back
			// into the methodView object.  
			if (executeMethods) {
				//bacillusAnthracis.executeMethods(bioMightMethods);
				//bioMightView.setX3D(bacillusAnthracis.getX3D(snippet));
			}
			
			bioMightView.setX3D(aeromonasHydrophilias.getX3D(snippet));
			
		}	
		else if (bioMightComponentRef.equals(Constants.AeromonasHydrophilia))
		{		
			AeromonasHydrophilia aeromonasHydrophilia = (AeromonasHydrophilia) bioMightInstance;
			bioMightView.setImage(aeromonasHydrophilia.getImage());
			bioMightView.setBioMightProperties(aeromonasHydrophilia.getProperties());
			bioMightView.setBioMightMethods(aeromonasHydrophilia.getMethods());
			bioMightView.setBioMightCollection(true);
		
			// Assooiate the component and ID.
			bioMightKey = new BioMightKey();
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(aeromonasHydrophilia.getComponentID());			
			System.out.println("Storing AeromonasHydrophilia Key: " + bioMightComponentRef + "   ID: " + aeromonasHydrophilia.getComponentID());
			bioMightKeys.setKey(bioMightKey);

			// On the post of data, we map the web data back
			// into the methodView object.  
			if (executeMethods) {
				//bacillusAnthracis.executeMethods(bioMightMethods);
				//bioMightView.setX3D(bacillusAnthracis.getX3D(snippet));
			}
			
			bioMightView.setX3D(aeromonasHydrophilia.getX3D(snippet));
			
		}				
		else if (bioMightComponentRef.equals(Constants.Alcaligenes))
		{
			Alcaligenes alcaligenes = (Alcaligenes) bioMightInstance;
			bioMightView.setImage(alcaligenes.getImage());
		}					
		else if (bioMightComponentRef.equals(Constants.AlcaligenesFaecalises))
		{
			AlcaligenesFaecalises alcaligenesFaecalises = (AlcaligenesFaecalises) bioMightInstance;
			bioMightView.setImage(alcaligenesFaecalises.getImage());
			bioMightView.setBioMightProperties(alcaligenesFaecalises.getProperties());
			bioMightView.setBioMightMethods(alcaligenesFaecalises.getMethods());
			bioMightView.setBioMightCollection(true);
		
			// Assooiate the component and ID.
			bioMightKey = new BioMightKey();
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(alcaligenesFaecalises.getComponentID());			
			System.out.println("Storing AeromonasHydrophilia Key: " + bioMightComponentRef + "   ID: " + alcaligenesFaecalises.getComponentID());
			bioMightKeys.setKey(bioMightKey);

			// On the post of data, we map the web data back
			// into the methodView object.  
			if (executeMethods) {
				//bacillusAnthracis.executeMethods(bioMightMethods);
				//bioMightView.setX3D(bacillusAnthracis.getX3D(snippet));
			}
			
			bioMightView.setX3D(alcaligenesFaecalises.getX3D(snippet));
		}		
		else if (bioMightComponentRef.equals(Constants.AlcaligenesFaecalis))
		{
			AlcaligenesFaecalis alcaligenesFaecalis = (AlcaligenesFaecalis) bioMightInstance;
			bioMightView.setImage(alcaligenesFaecalis.getImage());
			bioMightView.setBioMightProperties(alcaligenesFaecalis.getProperties());
			bioMightView.setBioMightMethods(alcaligenesFaecalis.getMethods());
			bioMightView.setBioMightCollection(true);
		
			// Assooiate the component and ID.
			bioMightKey = new BioMightKey();
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(alcaligenesFaecalis.getComponentID());			
			System.out.println("Storing AlcaligenesFaecalis Key: " + bioMightComponentRef + "   ID: " + alcaligenesFaecalis.getComponentID());
			bioMightKeys.setKey(bioMightKey);

			// On the post of data, we map the web data back
			// into the methodView object.  
			if (executeMethods) {
				//alcaligenesFaecalis.executeMethods(bioMightMethods);
				//bioMightView.setX3D(alcaligenesFaecalis.getX3D(snippet));
			}
			
			bioMightView.setX3D(alcaligenesFaecalis.getX3D(snippet));
		}

		else if (bioMightComponentRef.equals(Constants.BacilliAnthracis))
		{
			BacilliAnthracis bacilliAnthracis = (BacilliAnthracis) bioMightInstance;
			bioMightView.setImage(bacilliAnthracis.getImage());
			bioMightView.setBioMightProperties(bacilliAnthracis.getProperties());
			bioMightView.setBioMightMethods(bacilliAnthracis.getMethods());
			bioMightView.setBioMightCollection(true);
		
			// Assooiate the component and ID.
			bioMightKey = new BioMightKey();
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(bacilliAnthracis.getComponentID());			
			System.out.println("Storing bacillusAnthracisKey: " + bioMightComponentRef + "   ID: " + bacilliAnthracis.getComponentID());
			bioMightKeys.setKey(bioMightKey);

			// On the post of data, we map the web data back
			// into the methodView object.  
			if (executeMethods) {
				//bacillusAnthracis.executeMethods(bioMightMethods);
				//bioMightView.setX3D(bacillusAnthracis.getX3D(snippet));
			}
			
			bioMightView.setX3D(bacilliAnthracis.getX3D(snippet));

		}
		else if (bioMightComponentRef.equals(Constants.BacillusAnthracis))
		{
			BacillusAnthracis bacillusAnthracis = (BacillusAnthracis) bioMightInstance;
			bioMightView.setImage(bacillusAnthracis.getImage());
			bioMightView.setBioMightProperties(bacillusAnthracis.getProperties());
			bioMightView.setBioMightMethods(bacillusAnthracis.getMethods());
			bioMightView.setBioMightCollection(true);
		
			// Assooiate the component and ID.
			bioMightKey = new BioMightKey();
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(bacillusAnthracis.getComponentID());			
			System.out.println("Storing BacillusAnthracisKey: " + bioMightComponentRef + "   ID: " + bacillusAnthracis.getComponentID());
			bioMightKeys.setKey(bioMightKey);

			// On the post of data, we map the web data back
			// into the methodView object.  
			if (executeMethods) {
				//bacillusAnthracis.executeMethods(bioMightMethods);
				//bioMightView.setX3D(bacillusAnthracis.getX3D(snippet));
			}
			
			bioMightView.setX3D(bacillusAnthracis.getX3D(snippet));

		}
		
		else if (bioMightComponentRef.equals(Constants.CampylobacterJejunis))
		{
			CampylobacterJejunis campylobacterJejunis = (CampylobacterJejunis) bioMightInstance;
			bioMightView.setImage(campylobacterJejunis.getImage());
			bioMightView.setBioMightProperties(campylobacterJejunis.getProperties());
			bioMightView.setBioMightMethods(campylobacterJejunis.getMethods());
			bioMightView.setBioMightCollection(true);
		
			// Assooiate the component and ID.
			bioMightKey = new BioMightKey();
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(campylobacterJejunis.getComponentID());			
			System.out.println("Storing campylobacterJejunis Key: " + bioMightComponentRef + "   ID: " + campylobacterJejunis.getComponentID());
			bioMightKeys.setKey(bioMightKey);

			// On the post of data, we map the web data back
			// into the methodView object.  
			if (executeMethods) {
				//bacillusAnthracis.executeMethods(bioMightMethods);
				//bioMightView.setX3D(bacillusAnthracis.getX3D(snippet));
			}
			
			bioMightView.setX3D(campylobacterJejunis.getX3D(snippet));

		}
		else if (bioMightComponentRef.equals(Constants.CampylobacterJejuni))
		{
			CampylobacterJejuni campylobacterJejuni = (CampylobacterJejuni) bioMightInstance;
			bioMightView.setImage(campylobacterJejuni.getImage());
			bioMightView.setBioMightProperties(campylobacterJejuni.getProperties());
			bioMightView.setBioMightMethods(campylobacterJejuni.getMethods());
			bioMightView.setBioMightCollection(true);
		
			// Assooiate the component and ID.
			bioMightKey = new BioMightKey();
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(campylobacterJejuni.getComponentID());			
			System.out.println("Storing BacillusAnthracisKey: " + bioMightComponentRef + "   ID: " + campylobacterJejuni.getComponentID());
			bioMightKeys.setKey(bioMightKey);

			// On the post of data, we map the web data back
			// into the methodView object.  
			if (executeMethods) {
				//bacillusAnthracis.executeMethods(bioMightMethods);
				//bioMightView.setX3D(bacillusAnthracis.getX3D(snippet));
			}
			
			bioMightView.setX3D(campylobacterJejuni.getX3D(snippet));

		}

		
		else if (bioMightComponentRef.equals(Constants.SalmonellaEntericas))
		{
			SalmonellaEntericas salmonellaEntericas = (SalmonellaEntericas) bioMightInstance;
			bioMightView.setImage(salmonellaEntericas.getImage());
			bioMightView.setBioMightProperties(salmonellaEntericas.getProperties());
			bioMightView.setBioMightMethods(salmonellaEntericas.getMethods());
			bioMightView.setBioMightCollection(true);
		
			// Assooiate the component and ID.
			bioMightKey = new BioMightKey();
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(salmonellaEntericas.getComponentID());			
			System.out.println("Storing SalmonellaEntericas Key: " + bioMightComponentRef + "   ID: " + salmonellaEntericas.getComponentID());
			bioMightKeys.setKey(bioMightKey);

			// On the post of data, we map the web data back
			// into the methodView object.  
			if (executeMethods) {
				//salmonellaEntericas.executeMethods(bioMightMethods);
				//bioMightView.setX3D(salmonellaEntericas.getX3D(snippet));
			}
			
			bioMightView.setX3D(salmonellaEntericas.getX3D(snippet));
		}
		else if (bioMightComponentRef.equals(Constants.SalmonellaEnterica))
		{
			SalmonellaEnterica salmonellaEnterica = (SalmonellaEnterica) bioMightInstance;
			bioMightView.setImage(salmonellaEnterica.getImage());
			bioMightView.setBioMightProperties(salmonellaEnterica.getProperties());
			bioMightView.setBioMightMethods(salmonellaEnterica.getMethods());
			bioMightView.setBioMightCollection(true);
		
			// Assooiate the component and ID.
			bioMightKey = new BioMightKey();
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(salmonellaEnterica.getComponentID());			
			System.out.println("Storing SalmonellaEnterica Key: " + bioMightComponentRef + "   ID: " + salmonellaEnterica.getComponentID());
			bioMightKeys.setKey(bioMightKey);

			// On the post of data, we map the web data back
			// into the methodView object.  
			if (executeMethods) {
				//salmonellaEnterica.executeMethods(bioMightMethods);
				//bioMightView.setX3D(salmonellaEnterica.getX3D(snippet));
			}
			
			bioMightView.setX3D(salmonellaEnterica.getX3D(snippet));
		}
		else if (bioMightComponentRef.equals(Constants.SalmonellaTyphis))
		{
			SalmonellaTyphis salmonellaTyphis = (SalmonellaTyphis) bioMightInstance;
			bioMightView.setImage(salmonellaTyphis.getImage());
			bioMightView.setBioMightProperties(salmonellaTyphis.getProperties());
			bioMightView.setBioMightMethods(salmonellaTyphis.getMethods());
			bioMightView.setBioMightCollection(true);
		
			// Assooiate the component and ID.
			bioMightKey = new BioMightKey();
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(salmonellaTyphis.getComponentID());			
			System.out.println("Storing SalmonellaTyphis Key: " + bioMightComponentRef + "   ID: " + salmonellaTyphis.getComponentID());
			bioMightKeys.setKey(bioMightKey);

			// On the post of data, we map the web data back
			// into the methodView object.  
			if (executeMethods) {
				//salmonellaTyphis.executeMethods(bioMightMethods);
				//bioMightView.setX3D(salmonellaTyphis.getX3D(snippet));
			}
			
			bioMightView.setX3D(salmonellaTyphis.getX3D(snippet));
		}
		else if (bioMightComponentRef.equals(Constants.SalmonellaTyphi))
		{
			SalmonellaTyphi salmonellaTyphi = (SalmonellaTyphi) bioMightInstance;
			bioMightView.setImage(salmonellaTyphi.getImage());
			bioMightView.setBioMightProperties(salmonellaTyphi.getProperties());
			bioMightView.setBioMightMethods(salmonellaTyphi.getMethods());
			bioMightView.setBioMightCollection(true);
		
			// Assooiate the component and ID.
			bioMightKey = new BioMightKey();
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(salmonellaTyphi.getComponentID());			
			System.out.println("Storing SalmonellaTyphi Key: " + bioMightComponentRef + "   ID: " + salmonellaTyphi.getComponentID());
			bioMightKeys.setKey(bioMightKey);

			// On the post of data, we map the web data back
			// into the methodView object.  
			if (executeMethods) {
				//salmonellaTyphi.executeMethods(bioMightMethods);
				//bioMightView.setX3D(salmonellaTyphi.getX3D(snippet));
			}
			
			bioMightView.setX3D(salmonellaTyphi.getX3D(snippet));
		}
		else if (bioMightComponentRef.equals(Constants.SalmonellaTyphimuriums))
		{
			SalmonellaTyphimuriums salmonellaTyphimuriums = (SalmonellaTyphimuriums) bioMightInstance;
			bioMightView.setImage(salmonellaTyphimuriums.getImage());
			bioMightView.setBioMightProperties(salmonellaTyphimuriums.getProperties());
			bioMightView.setBioMightMethods(salmonellaTyphimuriums.getMethods());
			bioMightView.setBioMightCollection(true);
		
			// Assooiate the component and ID.
			bioMightKey = new BioMightKey();
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(salmonellaTyphimuriums.getComponentID());			
			System.out.println("Storing SalmonellaTyphimuriums Key: " + bioMightComponentRef + "   ID: " + salmonellaTyphimuriums.getComponentID());
			bioMightKeys.setKey(bioMightKey);

			// On the post of data, we map the web data back
			// into the methodView object.  
			if (executeMethods) {
				//salmonellaTyphimuriums.executeMethods(bioMightMethods);
				//bioMightView.setX3D(salmonellaTyphimuriums.getX3D(snippet));
			}
			
			bioMightView.setX3D(salmonellaTyphimuriums.getX3D(snippet));
		}
		else if (bioMightComponentRef.equals(Constants.SalmonellaTyphimurium))
		{
			SalmonellaTyphimurium salmonellaTyphimurium = (SalmonellaTyphimurium) bioMightInstance;
			bioMightView.setImage(salmonellaTyphimurium.getImage());
			bioMightView.setBioMightProperties(salmonellaTyphimurium.getProperties());
			bioMightView.setBioMightMethods(salmonellaTyphimurium.getMethods());
			bioMightView.setBioMightCollection(true);
		
			// Assooiate the component and ID.
			bioMightKey = new BioMightKey();
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(salmonellaTyphimurium.getComponentID());			
			System.out.println("Storing SalmonellaTyphimurium Key: " + bioMightComponentRef + "   ID: " + salmonellaTyphimurium.getComponentID());
			bioMightKeys.setKey(bioMightKey);

			// On the post of data, we map the web data back
			// into the methodView object.  
			if (executeMethods) {
				//salmonellaTyphimurium.executeMethods(bioMightMethods);
				//bioMightView.setX3D(salmonellaTyphimurium.getX3D(snippet));
			}
			
			bioMightView.setX3D(salmonellaTyphimurium.getX3D(snippet));
		}
		else if (bioMightComponentRef.equals(Constants.StreptococciPneumoniae))
		{
			StreptococciPneumoniae streptococciPneumoniae = (StreptococciPneumoniae) bioMightInstance;
			bioMightView.setImage(streptococciPneumoniae.getImage());
			bioMightView.setBioMightProperties(streptococciPneumoniae.getProperties());
			bioMightView.setBioMightMethods(streptococciPneumoniae.getMethods());

		
			// Assooiate the component and ID.
			bioMightKey = new BioMightKey();
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(streptococciPneumoniae.getComponentID());			
			System.out.println("Storing StreptococciPneumoniae: " + bioMightComponentRef + "   ID: " + streptococciPneumoniae.getComponentID());
			bioMightKeys.setKey(bioMightKey);

			// On the post of data, we map the web data back
			// into the methodView object.  
			if (executeMethods) {
				//streptococciPneumoniae.executeMethods(bioMightMethods);
				//bioMightView.setX3D(streptococciPneumoniae.getX3D(snippet));
			}
			
			bioMightView.setX3D(streptococciPneumoniae.getX3D(snippet));

		}
		else if (bioMightComponentRef.equals(Constants.StreptococcusPneumoniae))
		{
			StreptococcusPneumoniae streptococcusPneumoniae = (StreptococcusPneumoniae) bioMightInstance;
			bioMightView.setImage(streptococcusPneumoniae.getImage());
			bioMightView.setBioMightProperties(streptococcusPneumoniae.getProperties());
			bioMightView.setBioMightMethods(streptococcusPneumoniae.getMethods());

		
			// Assooiate the component and ID.
			bioMightKey = new BioMightKey();
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(streptococcusPneumoniae.getComponentID());			
			System.out.println("Storing StreptococciPneumoniae: " + bioMightComponentRef + "   ID: " + streptococcusPneumoniae.getComponentID());
			bioMightKeys.setKey(bioMightKey);

			// On the post of data, we map the web data back
			// into the methodView object.  
			if (executeMethods) {
				//streptococciPneumoniae.executeMethods(bioMightMethods);
				//bioMightView.setX3D(streptococciPneumoniae.getX3D(snippet));
			}
			
			bioMightView.setX3D(streptococcusPneumoniae.getX3D(snippet));

		}		
		else if (bioMightComponentRef.equals(Constants.VibrioCholeraes))
		{
			VibrioCholeraes vibrioCholeraes = (VibrioCholeraes) bioMightInstance;
			bioMightView.setImage(vibrioCholeraes.getImage());
			bioMightView.setBioMightProperties(vibrioCholeraes.getProperties());
			bioMightView.setBioMightMethods(vibrioCholeraes.getMethods());

		
			// Assooiate the component and ID.
			bioMightKey = new BioMightKey();
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(vibrioCholeraes.getComponentID());			
			System.out.println("Storing VibrioCholeraes: " + bioMightComponentRef + "   ID: " + vibrioCholeraes.getComponentID());
			bioMightKeys.setKey(bioMightKey);

			// On the post of data, we map the web data back
			// into the methodView object.  
			if (executeMethods) {
				//streptococciPneumoniae.executeMethods(bioMightMethods);
				//bioMightView.setX3D(streptococciPneumoniae.getX3D(snippet));
			}
			
			bioMightView.setX3D(vibrioCholeraes.getX3D(snippet));

		}
		else if (bioMightComponentRef.equals(Constants.VibrioCholerae))
		{
			VibrioCholerae vibrioCholerae = (VibrioCholerae) bioMightInstance;
			bioMightView.setImage(vibrioCholerae.getImage());
			bioMightView.setBioMightProperties(vibrioCholerae.getProperties());
			bioMightView.setBioMightMethods(vibrioCholerae.getMethods());

			// Assooiate the component and ID.
			bioMightKey = new BioMightKey();
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(vibrioCholerae.getComponentID());			
			System.out.println("Storing VibrioCholerae: " + bioMightComponentRef + "   ID: " + vibrioCholerae.getComponentID());
			bioMightKeys.setKey(bioMightKey);

			// On the post of data, we map the web data back
			// into the methodView object.  
			if (executeMethods) {
				//streptococciPneumoniae.executeMethods(bioMightMethods);
				//bioMightView.setX3D(streptococciPneumoniae.getX3D(snippet));
			}
			
			bioMightView.setX3D(vibrioCholerae.getX3D(snippet));

		}
		else if (bioMightComponentRef.equals(Constants.ClostridiumTetanis))
		{
			ClostridiumTetanis clostridiumTetanis = (ClostridiumTetanis) bioMightInstance;
			bioMightView.setImage(clostridiumTetanis.getImage());
			bioMightView.setBioMightProperties(clostridiumTetanis.getProperties());
			bioMightView.setBioMightMethods(clostridiumTetanis.getMethods());

		
			// Assooiate the component and ID.
			bioMightKey = new BioMightKey();
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(clostridiumTetanis.getComponentID());			
			System.out.println("Storing ClostridiumTetanis: " + bioMightComponentRef + "   ID: " + clostridiumTetanis.getComponentID());
			bioMightKeys.setKey(bioMightKey);

			// On the post of data, we map the web data back
			// into the methodView object.  
			if (executeMethods) {
				//clostridiumTetanis.executeMethods(bioMightMethods);
				//bioMightView.setX3D(clostridiumTetanis.getX3D(snippet));
			}
			
			bioMightView.setX3D(clostridiumTetanis.getX3D(snippet));

		}
		else if (bioMightComponentRef.equals(Constants.ClostridiumTetani))
		{
			ClostridiumTetani clostridiumTetani = (ClostridiumTetani) bioMightInstance;
			bioMightView.setImage(clostridiumTetani.getImage());
			bioMightView.setBioMightProperties(clostridiumTetani.getProperties());
			bioMightView.setBioMightMethods(clostridiumTetani.getMethods());

			// Assooiate the component and ID.
			bioMightKey = new BioMightKey();
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(clostridiumTetani.getComponentID());			
			System.out.println("Storing ClostridiumTetanis: " + bioMightComponentRef + "   ID: " + clostridiumTetani.getComponentID());
			bioMightKeys.setKey(bioMightKey);

			// On the post of data, we map the web data back
			// into the methodView object.  
			if (executeMethods) {
				//clostridiumTetanis.executeMethods(bioMightMethods);
				//bioMightView.setX3D(clostridiumTetanis.getX3D(snippet));
			}
			
			bioMightView.setX3D(clostridiumTetani.getX3D(snippet));
		}
		else if (bioMightComponentRef.equals(Constants.CorynebacteriumJeikeiums))
		{
			CorynebacteriumJeikeiums corynebacteriumJeikeiums = (CorynebacteriumJeikeiums) bioMightInstance;
			bioMightView.setImage(corynebacteriumJeikeiums.getImage());
			bioMightView.setBioMightProperties(corynebacteriumJeikeiums.getProperties());
			bioMightView.setBioMightMethods(corynebacteriumJeikeiums.getMethods());

			// Assooiate the component and ID.
			bioMightKey = new BioMightKey();
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(corynebacteriumJeikeiums.getComponentID());			
			System.out.println("Storing CorynebacteriumJeikeiums: " + bioMightComponentRef + "   ID: " + corynebacteriumJeikeiums.getComponentID());
			bioMightKeys.setKey(bioMightKey);

			// On the post of data, we map the web data back
			// into the methodView object.  
			if (executeMethods) {
				//clostridiumTetanis.executeMethods(bioMightMethods);
				//bioMightView.setX3D(clostridiumTetanis.getX3D(snippet));
			}
			
			bioMightView.setX3D(corynebacteriumJeikeiums.getX3D(snippet));
		}	
		else if (bioMightComponentRef.equals(Constants.CorynebacteriumJeikeium))
		{
			CorynebacteriumJeikeium corynebacteriumJeikeium = (CorynebacteriumJeikeium) bioMightInstance;
			bioMightView.setImage(corynebacteriumJeikeium.getImage());
			bioMightView.setBioMightProperties(corynebacteriumJeikeium.getProperties());
			bioMightView.setBioMightMethods(corynebacteriumJeikeium.getMethods());

			// Assooiate the component and ID.
			bioMightKey = new BioMightKey();
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(corynebacteriumJeikeium.getComponentID());			
			System.out.println("Storing CorynebacteriumJeikeium: " + bioMightComponentRef + "   ID: " + corynebacteriumJeikeium.getComponentID());
			bioMightKeys.setKey(bioMightKey);

			// On the post of data, we map the web data back
			// into the methodView object.  
			if (executeMethods) {
				//corynebacteriumJeikeium.executeMethods(bioMightMethods);
				//bioMightView.setX3D(corynebacteriumJeikeium.getX3D(snippet));
			}
			
			bioMightView.setX3D(corynebacteriumJeikeium.getX3D(snippet));
		}	
		else if (bioMightComponentRef.equals(Constants.CorynebacteriumMinutissimum))
		{
			CorynebacteriumMinutissimum CorynebacteriumMinutissimum = (CorynebacteriumMinutissimum) bioMightInstance;
			bioMightView.setImage(CorynebacteriumMinutissimum.getImage());
		}	
		else if (bioMightComponentRef.equals(Constants.CoxiellaBurnetii))
		{
			CoxiellaBurnetii coxiellaBurnetii = (CoxiellaBurnetii) bioMightInstance;
			bioMightView.setImage(coxiellaBurnetii.getImage());
		}			
		else if (bioMightComponentRef.equals(Constants.ErysipelothrixRhusiopathiae))
		{
			ErysipelothrixRhusiopathiae erysipelothrixRhusiopathiae = (ErysipelothrixRhusiopathiae) bioMightInstance;
			bioMightView.setImage(erysipelothrixRhusiopathiae.getImage());
		}				
		else if (bioMightComponentRef.equals(Constants.KlebsiellaPneumoniae))
		{
			KlebsiellaPneumoniae klebsiellaPneumoniae = (KlebsiellaPneumoniae) bioMightInstance;
			bioMightView.setImage(klebsiellaPneumoniae.getImage());
		}
		else if (bioMightComponentRef.equals(Constants.LegionellaPneumophila))
		{
			LegionellaPneumophila legionellaPneumophila = (LegionellaPneumophila) bioMightInstance;
			bioMightView.setImage(legionellaPneumophila.getImage());
		}				
		else if (bioMightComponentRef.equals(Constants.LeptospiraInterrogans))
		{
			LeptospiraInterrogans leptospiraInterrogans = (LeptospiraInterrogans) bioMightInstance;
			bioMightView.setImage(leptospiraInterrogans.getImage());
		}	

		// COCCI - GRAM POSITIVE
		else if (bioMightComponentRef.equals(Constants.Staphylococcus))
		{
			Staphylococcus staphylococcus = (Staphylococcus) bioMightInstance;
			bioMightView.setImage(staphylococcus.getImage());
			bioMightView.setBioMightProperties(staphylococcus.getProperties());
			bioMightView.setBioMightMethods(staphylococcus.getMethods());
		}	
		else if (bioMightComponentRef.equals(Constants.StaphylococciAureus))
		{
			StaphylococciAureus staphylococciAureus = (StaphylococciAureus) bioMightInstance;
			bioMightView.setImage(staphylococciAureus.getImage());
			bioMightView.setBioMightProperties(staphylococciAureus.getProperties());
			bioMightView.setBioMightMethods(staphylococciAureus.getMethods());
			bioMightView.setX3D(staphylococciAureus.getX3D(snippet));
		
			// Assooiate the component and ID.
			bioMightKey = new BioMightKey();
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(staphylococciAureus.getComponentID());			
			System.out.println("Storing staphylococciAureus Key: " + bioMightComponentRef + "   ID: " + staphylococciAureus.getComponentID());
			bioMightKeys.setKey(bioMightKey);

			// On the post of data, we map the web data back
			// into the methodView object.  
			if (executeMethods) {
				//staphylococcusAureus.executeMethods(bioMightMethods);
				bioMightView.setX3D(staphylococciAureus.getX3D(snippet));
			}

		}	
		else if (bioMightComponentRef.equals(Constants.StaphylococcusAureus))
		{
			StaphylococcusAureus staphylococcusAureus = (StaphylococcusAureus) bioMightInstance;
			bioMightView.setImage(staphylococcusAureus.getImage());
			bioMightView.setBioMightProperties(staphylococcusAureus.getProperties());
			bioMightView.setBioMightMethods(staphylococcusAureus.getMethods());
			bioMightView.setX3D(staphylococcusAureus.getX3D(snippet));
		
			// Assooiate the component and ID.
			bioMightKey = new BioMightKey();
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(staphylococcusAureus.getComponentID());			
			System.out.println("Storing staphylococcusAureusKey: " + bioMightComponentRef + "   ID: " + staphylococcusAureus.getComponentID());
			bioMightKeys.setKey(bioMightKey);

			// On the post of data, we map the web data back
			// into the methodView object.  
			if (executeMethods) {
				//staphylococcusAureus.executeMethods(bioMightMethods);
				bioMightView.setX3D(staphylococcusAureus.getX3D(snippet));
			}

		}			
		else if (bioMightComponentRef.equals(Constants.StaphylococciEpidermidis))
		{
			StaphylococciEpidermidis staphylococciEpidermidis = (StaphylococciEpidermidis) bioMightInstance;
			bioMightView.setImage(staphylococciEpidermidis.getImage());
			bioMightView.setBioMightProperties(staphylococciEpidermidis.getProperties());
			bioMightView.setBioMightMethods(staphylococciEpidermidis.getMethods());
			bioMightView.setX3D(staphylococciEpidermidis.getX3D(snippet));
		
			// Assooiate the component and ID.
			bioMightKey = new BioMightKey();
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(staphylococciEpidermidis.getComponentID());			
			System.out.println("Storing StaphylococciEpidermidis Key: " + bioMightComponentRef + "   ID: " + staphylococciEpidermidis.getComponentID());
			bioMightKeys.setKey(bioMightKey);

			// On the post of data, we map the web data back
			// into the methodView object.  
			if (executeMethods) {
				//staphylococcusEpidermidis.executeMethods(bioMightMethods);
				//bioMightView.setX3D(staphylococcusEpidermidis.getX3D(snippet));
			}

		}
		else if (bioMightComponentRef.equals(Constants.StaphylococcusEpidermidis))
		{
			StaphylococcusEpidermidis staphylococcusEpidermidis = (StaphylococcusEpidermidis) bioMightInstance;
			bioMightView.setImage(staphylococcusEpidermidis.getImage());
			bioMightView.setBioMightProperties(staphylococcusEpidermidis.getProperties());
			bioMightView.setBioMightMethods(staphylococcusEpidermidis.getMethods());
			bioMightView.setX3D(staphylococcusEpidermidis.getX3D(snippet));
		
			// Assooiate the component and ID.
			bioMightKey = new BioMightKey();
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(staphylococcusEpidermidis.getComponentID());			
			System.out.println("Storing b1CellKey: " + bioMightComponentRef + "   ID: " + staphylococcusEpidermidis.getComponentID());
			bioMightKeys.setKey(bioMightKey);

			// On the post of data, we map the web data back
			// into the methodView object.  
			if (executeMethods) {
				//staphylococcusEpidermidis.executeMethods(bioMightMethods);
				//bioMightView.setX3D(staphylococcusEpidermidis.getX3D(snippet));
			}

		}			
		else if (bioMightComponentRef.equals(Constants.StaphylococciSaprophyticus))
		{
			StaphylococciSaprophyticus staphylococciSaprophyticus = (StaphylococciSaprophyticus) bioMightInstance;
			bioMightView.setImage(staphylococciSaprophyticus.getImage());
			bioMightView.setBioMightProperties(staphylococciSaprophyticus.getProperties());
			bioMightView.setBioMightMethods(staphylococciSaprophyticus.getMethods());
			bioMightView.setX3D(staphylococciSaprophyticus.getX3D(snippet));
		
			// Assooiate the component and ID.
			bioMightKey = new BioMightKey();
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(staphylococciSaprophyticus.getComponentID());			
			System.out.println("Storing StaphylococciSaprophyticus Key: " + bioMightComponentRef + "   ID: " + staphylococciSaprophyticus.getComponentID());
			bioMightKeys.setKey(bioMightKey);

			// On the post of data, we map the web data back
			// into the methodView object.  
			if (executeMethods) {
				//staphylococcusSaprophyticus.executeMethods(bioMightMethods);
				//bioMightView.setX3D(staphylococcusSaprophyticus.getX3D(snippet));
			}

		}
		else if (bioMightComponentRef.equals(Constants.StaphylococcusSaprophyticus))
		{
			StaphylococcusSaprophyticus staphylococcusSaprophyticus = (StaphylococcusSaprophyticus) bioMightInstance;
			bioMightView.setImage(staphylococcusSaprophyticus.getImage());
			bioMightView.setBioMightProperties(staphylococcusSaprophyticus.getProperties());
			bioMightView.setBioMightMethods(staphylococcusSaprophyticus.getMethods());
			bioMightView.setX3D(staphylococcusSaprophyticus.getX3D(snippet));
		
			// Assooiate the component and ID.
			bioMightKey = new BioMightKey();
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(staphylococcusSaprophyticus.getComponentID());			
			System.out.println("Storing b1CellKey: " + bioMightComponentRef + "   ID: " + staphylococcusSaprophyticus.getComponentID());
			bioMightKeys.setKey(bioMightKey);

			// On the post of data, we map the web data back
			// into the methodView object.  
			if (executeMethods) {
				//staphylococcusSaprophyticus.executeMethods(bioMightMethods);
				//bioMightView.setX3D(staphylococcusSaprophyticus.getX3D(snippet));
			}

		}			
		else if (bioMightComponentRef.equals(Constants.StreptococciAgalactiae))
		{
			StreptococciAgalactiae streptococciAgalactiae = (StreptococciAgalactiae) bioMightInstance;
			bioMightView.setImage(streptococciAgalactiae.getImage());
			bioMightView.setBioMightProperties(streptococciAgalactiae.getProperties());
			bioMightView.setBioMightMethods(streptococciAgalactiae.getMethods());

		
			// Assooiate the component and ID.
			bioMightKey = new BioMightKey();
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(streptococciAgalactiae.getComponentID());			
			System.out.println("Storing StreptococciAgalactiae: " + bioMightComponentRef + "   ID: " + streptococciAgalactiae.getComponentID());
			bioMightKeys.setKey(bioMightKey);

			// On the post of data, we map the web data back
			// into the methodView object.  
			if (executeMethods) {
				//streptococciAgalactiae.executeMethods(bioMightMethods);
				//bioMightView.setX3D(streptococciAgalactiae.getX3D(snippet));
			}
			
			bioMightView.setX3D(streptococciAgalactiae.getX3D(snippet));
		}	
		else if (bioMightComponentRef.equals(Constants.StreptococcusAgalactiae))
		{
			StreptococcusAgalactiae streptococcusAgalactiae = (StreptococcusAgalactiae) bioMightInstance;
			bioMightView.setImage(streptococcusAgalactiae.getImage());
			bioMightView.setBioMightProperties(streptococcusAgalactiae.getProperties());
			bioMightView.setBioMightMethods(streptococcusAgalactiae.getMethods());

		
			// Assooiate the component and ID.
			bioMightKey = new BioMightKey();
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(streptococcusAgalactiae.getComponentID());			
			System.out.println("Storing StreptococcusAgalactiae: " + bioMightComponentRef + "   ID: " + streptococcusAgalactiae.getComponentID());
			bioMightKeys.setKey(bioMightKey);

			// On the post of data, we map the web data back
			// into the methodView object.  
			if (executeMethods) {
				//streptococciPneumoniae.executeMethods(bioMightMethods);
				//bioMightView.setX3D(streptococciPneumoniae.getX3D(snippet));
			}
			
			bioMightView.setX3D(streptococcusAgalactiae.getX3D(snippet));
		}		
		else if (bioMightComponentRef.equals(Constants.StreptococciAnginosus))
		{
			StreptococciAnginosus streptococciAnginosus = (StreptococciAnginosus) bioMightInstance;
			bioMightView.setImage(streptococciAnginosus.getImage());
			bioMightView.setBioMightProperties(streptococciAnginosus.getProperties());
			bioMightView.setBioMightMethods(streptococciAnginosus.getMethods());

		
			// Assooiate the component and ID.
			bioMightKey = new BioMightKey();
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(streptococciAnginosus.getComponentID());			
			System.out.println("Storing StreptococciAnginosus: " + bioMightComponentRef + "   ID: " + streptococciAnginosus.getComponentID());
			bioMightKeys.setKey(bioMightKey);

			// On the post of data, we map the web data back
			// into the methodView object.  
			if (executeMethods) {
				//streptococciAnginosus.executeMethods(bioMightMethods);
				//bioMightView.setX3D(streptococciAnginosus.getX3D(snippet));
			}
			
			bioMightView.setX3D(streptococciAnginosus.getX3D(snippet));
		}	
		else if (bioMightComponentRef.equals(Constants.StreptococcusAnginosus))
		{
			StreptococcusAnginosus streptococcusAnginosus = (StreptococcusAnginosus) bioMightInstance;
			bioMightView.setImage(streptococcusAnginosus.getImage());
			bioMightView.setBioMightProperties(streptococcusAnginosus.getProperties());
			bioMightView.setBioMightMethods(streptococcusAnginosus.getMethods());

		
			// Assooiate the component and ID.
			bioMightKey = new BioMightKey();
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(streptococcusAnginosus.getComponentID());			
			System.out.println("Storing StreptococcusAnginosus: " + bioMightComponentRef + "   ID: " + streptococcusAnginosus.getComponentID());
			bioMightKeys.setKey(bioMightKey);

			// On the post of data, we map the web data back
			// into the methodView object.  
			if (executeMethods) {
				//streptococciPneumoniae.executeMethods(bioMightMethods);
				//bioMightView.setX3D(streptococciPneumoniae.getX3D(snippet));
			}
			
			bioMightView.setX3D(streptococcusAnginosus.getX3D(snippet));
		}		
		else if (bioMightComponentRef.equals(Constants.StreptococciSanguinis))
		{
			StreptococciSanguinis streptococciSanguinis = (StreptococciSanguinis) bioMightInstance;
			bioMightView.setImage(streptococciSanguinis.getImage());
			bioMightView.setBioMightProperties(streptococciSanguinis.getProperties());
			bioMightView.setBioMightMethods(streptococciSanguinis.getMethods());

		
			// Assooiate the component and ID.
			bioMightKey = new BioMightKey();
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(streptococciSanguinis.getComponentID());			
			System.out.println("Storing StreptococciSanguinis: " + bioMightComponentRef + "   ID: " + streptococciSanguinis.getComponentID());
			bioMightKeys.setKey(bioMightKey);

			// On the post of data, we map the web data back
			// into the methodView object.  
			if (executeMethods) {
				//streptococciSanguinis.executeMethods(bioMightMethods);
				//bioMightView.setX3D(streptococciSanguinis.getX3D(snippet));
			}
			
			bioMightView.setX3D(streptococciSanguinis.getX3D(snippet));
		}	
		else if (bioMightComponentRef.equals(Constants.StreptococcusSanguinis))
		{
			StreptococcusSanguinis streptococcusSanguinis = (StreptococcusSanguinis) bioMightInstance;
			bioMightView.setImage(streptococcusSanguinis.getImage());
			bioMightView.setBioMightProperties(streptococcusSanguinis.getProperties());
			bioMightView.setBioMightMethods(streptococcusSanguinis.getMethods());

		
			// Assooiate the component and ID.
			bioMightKey = new BioMightKey();
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(streptococcusSanguinis.getComponentID());			
			System.out.println("Storing StreptococcusSanguinis: " + bioMightComponentRef + "   ID: " + streptococcusSanguinis.getComponentID());
			bioMightKeys.setKey(bioMightKey);

			// On the post of data, we map the web data back
			// into the methodView object.  
			if (executeMethods) {
				//streptococciPneumoniae.executeMethods(bioMightMethods);
				//bioMightView.setX3D(streptococciPneumoniae.getX3D(snippet));
			}
			
			bioMightView.setX3D(streptococcusSanguinis.getX3D(snippet));
		}				
		else if (bioMightComponentRef.equals(Constants.StreptococciBovis))
		{
			StreptococciBovis streptococciBovis = (StreptococciBovis) bioMightInstance;
			bioMightView.setImage(streptococciBovis.getImage());
			bioMightView.setBioMightProperties(streptococciBovis.getProperties());
			bioMightView.setBioMightMethods(streptococciBovis.getMethods());
		
			// Assooiate the component and ID.
			bioMightKey = new BioMightKey();
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(streptococciBovis.getComponentID());			
			System.out.println("Storing StreptococciBovis: " + bioMightComponentRef + "   ID: " + streptococciBovis.getComponentID());
			bioMightKeys.setKey(bioMightKey);

			// On the post of data, we map the web data back
			// into the methodView object.  
			if (executeMethods) {
				//streptococciBovis.executeMethods(bioMightMethods);
				//bioMightView.setX3D(streptococciBovis.getX3D(snippet));
			}
			
			bioMightView.setX3D(streptococciBovis.getX3D(snippet));
		}	
		else if (bioMightComponentRef.equals(Constants.StreptococcusBovis))
		{
			StreptococcusBovis streptococcusBovis = (StreptococcusBovis) bioMightInstance;
			bioMightView.setImage(streptococcusBovis.getImage());
			bioMightView.setBioMightProperties(streptococcusBovis.getProperties());
			bioMightView.setBioMightMethods(streptococcusBovis.getMethods());

		
			// Assooiate the component and ID.
			bioMightKey = new BioMightKey();
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(streptococcusBovis.getComponentID());			
			System.out.println("Storing StreptococcusBovis: " + bioMightComponentRef + "   ID: " + streptococcusBovis.getComponentID());
			bioMightKeys.setKey(bioMightKey);

			// On the post of data, we map the web data back
			// into the methodView object.  
			if (executeMethods) {
				//streptococciPneumoniae.executeMethods(bioMightMethods);
				//bioMightView.setX3D(streptococciPneumoniae.getX3D(snippet));
			}
			
			bioMightView.setX3D(streptococcusBovis.getX3D(snippet));
		}	
		else if (bioMightComponentRef.equals(Constants.StreptococciFaecalis))
		{
			StreptococciFaecalis streptococciFaecalis = (StreptococciFaecalis) bioMightInstance;
			bioMightView.setImage(streptococciFaecalis.getImage());
			bioMightView.setBioMightProperties(streptococciFaecalis.getProperties());
			bioMightView.setBioMightMethods(streptococciFaecalis.getMethods());

		
			// Assooiate the component and ID.
			bioMightKey = new BioMightKey();
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(streptococciFaecalis.getComponentID());			
			System.out.println("Storing StreptococciFaecalis: " + bioMightComponentRef + "   ID: " + streptococciFaecalis.getComponentID());
			bioMightKeys.setKey(bioMightKey);

			// On the post of data, we map the web data back
			// into the methodView object.  
			if (executeMethods) {
				//streptococciFaecalis.executeMethods(bioMightMethods);
				//bioMightView.setX3D(streptococciFaecalis.getX3D(snippet));
			}
			
			bioMightView.setX3D(streptococciFaecalis.getX3D(snippet));
		}	
		else if (bioMightComponentRef.equals(Constants.StreptococcusFaecalis))
		{
			StreptococcusFaecalis streptococcusFaecalis = (StreptococcusFaecalis) bioMightInstance;
			bioMightView.setImage(streptococcusFaecalis.getImage());
			bioMightView.setBioMightProperties(streptococcusFaecalis.getProperties());
			bioMightView.setBioMightMethods(streptococcusFaecalis.getMethods());

		
			// Assooiate the component and ID.
			bioMightKey = new BioMightKey();
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(streptococcusFaecalis.getComponentID());			
			System.out.println("Storing StreptococcusFaecalis: " + bioMightComponentRef + "   ID: " + streptococcusFaecalis.getComponentID());
			bioMightKeys.setKey(bioMightKey);

			// On the post of data, we map the web data back
			// into the methodView object.  
			if (executeMethods) {
				//streptococciPneumoniae.executeMethods(bioMightMethods);
				//bioMightView.setX3D(streptococciPneumoniae.getX3D(snippet));
			}
			
			bioMightView.setX3D(streptococcusFaecalis.getX3D(snippet));
		}			
		else if (bioMightComponentRef.equals(Constants.StreptococciGordoni))
		{
			StreptococciGordoni streptococciGordoni = (StreptococciGordoni) bioMightInstance;
			bioMightView.setImage(streptococciGordoni.getImage());
			bioMightView.setBioMightProperties(streptococciGordoni.getProperties());
			bioMightView.setBioMightMethods(streptococciGordoni.getMethods());

		
			// Assooiate the component and ID.
			bioMightKey = new BioMightKey();
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(streptococciGordoni.getComponentID());			
			System.out.println("Storing StreptococciGordoni: " + bioMightComponentRef + "   ID: " + streptococciGordoni.getComponentID());
			bioMightKeys.setKey(bioMightKey);

			// On the post of data, we map the web data back
			// into the methodView object.  
			if (executeMethods) {
				//streptococciGordoni.executeMethods(bioMightMethods);
				//bioMightView.setX3D(streptococciGordoni.getX3D(snippet));
			}
			
			bioMightView.setX3D(streptococciGordoni.getX3D(snippet));
		}	
		else if (bioMightComponentRef.equals(Constants.StreptococcusGordoni))
		{
			StreptococcusGordoni streptococcusGordoni = (StreptococcusGordoni) bioMightInstance;
			bioMightView.setImage(streptococcusGordoni.getImage());
			bioMightView.setBioMightProperties(streptococcusGordoni.getProperties());
			bioMightView.setBioMightMethods(streptococcusGordoni.getMethods());

		
			// Assooiate the component and ID.
			bioMightKey = new BioMightKey();
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(streptococcusGordoni.getComponentID());			
			System.out.println("Storing StreptococcusGordoni: " + bioMightComponentRef + "   ID: " + streptococcusGordoni.getComponentID());
			bioMightKeys.setKey(bioMightKey);

			// On the post of data, we map the web data back
			// into the methodView object.  
			if (executeMethods) {
				//streptococciPneumoniae.executeMethods(bioMightMethods);
				//bioMightView.setX3D(streptococciPneumoniae.getX3D(snippet));
			}
			
			bioMightView.setX3D(streptococcusGordoni.getX3D(snippet));
		}
		else if (bioMightComponentRef.equals(Constants.StreptococciIntermedius))
		{
			StreptococciIntermedius streptococciIntermedius = (StreptococciIntermedius) bioMightInstance;
			bioMightView.setImage(streptococciIntermedius.getImage());
			bioMightView.setBioMightProperties(streptococciIntermedius.getProperties());
			bioMightView.setBioMightMethods(streptococciIntermedius.getMethods());

		
			// Assooiate the component and ID.
			bioMightKey = new BioMightKey();
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(streptococciIntermedius.getComponentID());			
			System.out.println("Storing StreptococciIntermedius: " + bioMightComponentRef + "   ID: " + streptococciIntermedius.getComponentID());
			bioMightKeys.setKey(bioMightKey);

			// On the post of data, we map the web data back
			// into the methodView object.  
			if (executeMethods) {
				//streptococciIntermedius.executeMethods(bioMightMethods);
				//bioMightView.setX3D(streptococciIntermedius.getX3D(snippet));
			}
			
			bioMightView.setX3D(streptococciIntermedius.getX3D(snippet));
		}	
		else if (bioMightComponentRef.equals(Constants.StreptococcusIntermedius))
		{
			StreptococcusIntermedius streptococcusIntermedius = (StreptococcusIntermedius) bioMightInstance;
			bioMightView.setImage(streptococcusIntermedius.getImage());
			bioMightView.setBioMightProperties(streptococcusIntermedius.getProperties());
			bioMightView.setBioMightMethods(streptococcusIntermedius.getMethods());

		
			// Assooiate the component and ID.
			bioMightKey = new BioMightKey();
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(streptococcusIntermedius.getComponentID());			
			System.out.println("Storing StreptococcusIntermedius: " + bioMightComponentRef + "   ID: " + streptococcusIntermedius.getComponentID());
			bioMightKeys.setKey(bioMightKey);

			// On the post of data, we map the web data back
			// into the methodView object.  
			if (executeMethods) {
				//streptococciPneumoniae.executeMethods(bioMightMethods);
				//bioMightView.setX3D(streptococciPneumoniae.getX3D(snippet));
			}
			
			bioMightView.setX3D(streptococcusIntermedius.getX3D(snippet));
		}			
		else if (bioMightComponentRef.equals(Constants.StreptococciMitis))
		{
			StreptococciMitis streptococciMitis = (StreptococciMitis) bioMightInstance;
			bioMightView.setImage(streptococciMitis.getImage());
			bioMightView.setBioMightProperties(streptococciMitis.getProperties());
			bioMightView.setBioMightMethods(streptococciMitis.getMethods());

		
			// Assooiate the component and ID.
			bioMightKey = new BioMightKey();
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(streptococciMitis.getComponentID());			
			System.out.println("Storing StreptococciMitis: " + bioMightComponentRef + "   ID: " + streptococciMitis.getComponentID());
			bioMightKeys.setKey(bioMightKey);

			// On the post of data, we map the web data back
			// into the methodView object.  
			if (executeMethods) {
				//streptococciMitis.executeMethods(bioMightMethods);
				//bioMightView.setX3D(streptococciMitis.getX3D(snippet));
			}
			
			bioMightView.setX3D(streptococciMitis.getX3D(snippet));
		}	
		else if (bioMightComponentRef.equals(Constants.StreptococcusMitis))
		{
			StreptococcusMitis streptococcusMitis = (StreptococcusMitis) bioMightInstance;
			bioMightView.setImage(streptococcusMitis.getImage());
			bioMightView.setBioMightProperties(streptococcusMitis.getProperties());
			bioMightView.setBioMightMethods(streptococcusMitis.getMethods());

		
			// Assooiate the component and ID.
			bioMightKey = new BioMightKey();
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(streptococcusMitis.getComponentID());			
			System.out.println("Storing StreptococcusMitis: " + bioMightComponentRef + "   ID: " + streptococcusMitis.getComponentID());
			bioMightKeys.setKey(bioMightKey);

			// On the post of data, we map the web data back
			// into the methodView object.  
			if (executeMethods) {
				//streptococciPneumoniae.executeMethods(bioMightMethods);
				//bioMightView.setX3D(streptococciPneumoniae.getX3D(snippet));
			}
			
			bioMightView.setX3D(streptococcusMitis.getX3D(snippet));
		}
		else if (bioMightComponentRef.equals(Constants.StreptococciMutans))
		{
			StreptococciMutans streptococciMutans = (StreptococciMutans) bioMightInstance;
			bioMightView.setImage(streptococciMutans.getImage());
			bioMightView.setBioMightProperties(streptococciMutans.getProperties());
			bioMightView.setBioMightMethods(streptococciMutans.getMethods());

		
			// Assooiate the component and ID.
			bioMightKey = new BioMightKey();
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(streptococciMutans.getComponentID());			
			System.out.println("Storing StreptococciMutans: " + bioMightComponentRef + "   ID: " + streptococciMutans.getComponentID());
			bioMightKeys.setKey(bioMightKey);

			// On the post of data, we map the web data back
			// into the methodView object.  
			if (executeMethods) {
				//streptococciMutans.executeMethods(bioMightMethods);
				//bioMightView.setX3D(streptococciMutans.getX3D(snippet));
			}
			
			bioMightView.setX3D(streptococciMutans.getX3D(snippet));
		}	

		else if (bioMightComponentRef.equals(Constants.StreptococcusMutans))
		{
			StreptococcusMutans streptococcusMutans = (StreptococcusMutans) bioMightInstance;
			bioMightView.setImage(streptococcusMutans.getImage());
			bioMightView.setBioMightProperties(streptococcusMutans.getProperties());
			bioMightView.setBioMightMethods(streptococcusMutans.getMethods());

		
			// Assooiate the component and ID.
			bioMightKey = new BioMightKey();
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(streptococcusMutans.getComponentID());			
			System.out.println("Storing StreptococcusMutans: " + bioMightComponentRef + "   ID: " + streptococcusMutans.getComponentID());
			bioMightKeys.setKey(bioMightKey);

			// On the post of data, we map the web data back
			// into the methodView object.  
			if (executeMethods) {
				//streptococciPneumoniae.executeMethods(bioMightMethods);
				//bioMightView.setX3D(streptococciPneumoniae.getX3D(snippet));
			}
			
			bioMightView.setX3D(streptococcusMutans.getX3D(snippet));
		}
		else if (bioMightComponentRef.equals(Constants.StreptococcusPneumoniae))
		{
			StreptococcusPneumoniae streptococcusPneumoniae = (StreptococcusPneumoniae) bioMightInstance;
			bioMightView.setImage(streptococcusPneumoniae.getImage());
			bioMightView.setBioMightProperties(streptococcusPneumoniae.getProperties());
			bioMightView.setBioMightMethods(streptococcusPneumoniae.getMethods());
			bioMightView.setX3D(streptococcusPneumoniae.getX3D(snippet));
		
			// Assooiate the component and ID.
			bioMightKey = new BioMightKey();
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(streptococcusPneumoniae.getComponentID());			
			System.out.println("Storing b1CellKey: " + bioMightComponentRef + "   ID: " + streptococcusPneumoniae.getComponentID());
			bioMightKeys.setKey(bioMightKey);

			// On the post of data, we map the web data back
			// into the methodView object.  
			if (executeMethods) {
				//streptococcusPneumoniae.executeMethods(bioMightMethods);
				bioMightView.setX3D(streptococcusPneumoniae.getX3D(snippet));
			}

		}				
		else if (bioMightComponentRef.equals(Constants.StreptococciPyogenes))
		{
			StreptococciPyogenes streptococciPyogenes = (StreptococciPyogenes) bioMightInstance;
			bioMightView.setImage(streptococciPyogenes.getImage());
			bioMightView.setBioMightProperties(streptococciPyogenes.getProperties());
			bioMightView.setBioMightMethods(streptococciPyogenes.getMethods());

		
			// Assooiate the component and ID.
			bioMightKey = new BioMightKey();
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(streptococciPyogenes.getComponentID());			
			System.out.println("Storing StreptococciPyogenes: " + bioMightComponentRef + "   ID: " + streptococciPyogenes.getComponentID());
			bioMightKeys.setKey(bioMightKey);

			// On the post of data, we map the web data back
			// into the methodView object.  
			if (executeMethods) {
				//streptococciPyogenes.executeMethods(bioMightMethods);
				//bioMightView.setX3D(streptococciPyogenes.getX3D(snippet));
			}
			
			bioMightView.setX3D(streptococciPyogenes.getX3D(snippet));
		}	
		else if (bioMightComponentRef.equals(Constants.StreptococcusPyogenes))
		{
			StreptococcusPyogenes streptococcusPyogenes = (StreptococcusPyogenes) bioMightInstance;
			bioMightView.setImage(streptococcusPyogenes.getImage());
			bioMightView.setBioMightProperties(streptococcusPyogenes.getProperties());
			bioMightView.setBioMightMethods(streptococcusPyogenes.getMethods());

		
			// Assooiate the component and ID.
			bioMightKey = new BioMightKey();
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(streptococcusPyogenes.getComponentID());			
			System.out.println("Storing StreptococcusPyogenes: " + bioMightComponentRef + "   ID: " + streptococcusPyogenes.getComponentID());
			bioMightKeys.setKey(bioMightKey);

			// On the post of data, we map the web data back
			// into the methodView object.  
			if (executeMethods) {
				//streptococciPneumoniae.executeMethods(bioMightMethods);
				//bioMightView.setX3D(streptococciPneumoniae.getX3D(snippet));
			}
			
			bioMightView.setX3D(streptococcusPyogenes.getX3D(snippet));
		}	

		else if (bioMightComponentRef.equals(Constants.StreptococciViridans))
		{
			StreptococciViridans streptococciViridans = (StreptococciViridans) bioMightInstance;
			bioMightView.setImage(streptococciViridans.getImage());
			bioMightView.setBioMightProperties(streptococciViridans.getProperties());
			bioMightView.setBioMightMethods(streptococciViridans.getMethods());

		
			// Assooiate the component and ID.
			bioMightKey = new BioMightKey();
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(streptococciViridans.getComponentID());			
			System.out.println("Storing StreptococciViridans: " + bioMightComponentRef + "   ID: " + streptococciViridans.getComponentID());
			bioMightKeys.setKey(bioMightKey);

			// On the post of data, we map the web data back
			// into the methodView object.  
			if (executeMethods) {
				//streptococciViridans.executeMethods(bioMightMethods);
				//bioMightView.setX3D(streptococciViridans.getX3D(snippet));
			}
			
			bioMightView.setX3D(streptococciViridans.getX3D(snippet));
		}	
		else if (bioMightComponentRef.equals(Constants.StreptococcusViridans))
		{
			StreptococcusViridans streptococcusViridans = (StreptococcusViridans) bioMightInstance;
			bioMightView.setImage(streptococcusViridans.getImage());
			bioMightView.setBioMightProperties(streptococcusViridans.getProperties());
			bioMightView.setBioMightMethods(streptococcusViridans.getMethods());

		
			// Assooiate the component and ID.
			bioMightKey = new BioMightKey();
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(streptococcusViridans.getComponentID());			
			System.out.println("Storing StreptococcusViridans: " + bioMightComponentRef + "   ID: " + streptococcusViridans.getComponentID());
			bioMightKeys.setKey(bioMightKey);

			// On the post of data, we map the web data back
			// into the methodView object.  
			if (executeMethods) {
				//streptococciPneumoniae.executeMethods(bioMightMethods);
				//bioMightView.setX3D(streptococciPneumoniae.getX3D(snippet));
			}
			
			bioMightView.setX3D(streptococcusViridans.getX3D(snippet));
		}

		else if (bioMightComponentRef.equals(Constants.StreptococciSalivarius))
		{
			StreptococciSalivarius streptococciSalivarius = (StreptococciSalivarius) bioMightInstance;
			bioMightView.setImage(streptococciSalivarius.getImage());
			bioMightView.setBioMightProperties(streptococciSalivarius.getProperties());
			bioMightView.setBioMightMethods(streptococciSalivarius.getMethods());

		
			// Assooiate the component and ID.
			bioMightKey = new BioMightKey();
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(streptococciSalivarius.getComponentID());			
			System.out.println("Storing StreptococciSalivarius: " + bioMightComponentRef + "   ID: " + streptococciSalivarius.getComponentID());
			bioMightKeys.setKey(bioMightKey);

			// On the post of data, we map the web data back
			// into the methodView object.  
			if (executeMethods) {
				//streptococciSalivarius.executeMethods(bioMightMethods);
				//bioMightView.setX3D(streptococciSalivarius.getX3D(snippet));
			}
			
			bioMightView.setX3D(streptococciSalivarius.getX3D(snippet));
		}	
		else if (bioMightComponentRef.equals(Constants.StreptococcusSalivarius))
		{
			StreptococcusSalivarius streptococcusSalivarius = (StreptococcusSalivarius) bioMightInstance;
			bioMightView.setImage(streptococcusSalivarius.getImage());
			bioMightView.setBioMightProperties(streptococcusSalivarius.getProperties());
			bioMightView.setBioMightMethods(streptococcusSalivarius.getMethods());

		
			// Assooiate the component and ID.
			bioMightKey = new BioMightKey();
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(streptococcusSalivarius.getComponentID());			
			System.out.println("Storing StreptococcusSalivarius: " + bioMightComponentRef + "   ID: " + streptococcusSalivarius.getComponentID());
			bioMightKeys.setKey(bioMightKey);

			// On the post of data, we map the web data back
			// into the methodView object.  
			if (executeMethods) {
				//streptococciPneumoniae.executeMethods(bioMightMethods);
				//bioMightView.setX3D(streptococciPneumoniae.getX3D(snippet));
			}
			
			bioMightView.setX3D(streptococcusSalivarius.getX3D(snippet));
		}	
	
		
		// COCCI BACILLUS - GRAM NEGATIVE
		else if (bioMightComponentRef.equals(Constants.BordetellaPertussises))
		{
			BordetellaPertussises bordetellaPertussises = (BordetellaPertussises) bioMightInstance;
			bioMightView.setImage(bordetellaPertussises.getImage());
			bioMightView.setBioMightProperties(bordetellaPertussises.getProperties());
			bioMightView.setBioMightMethods(bordetellaPertussises.getMethods());

		
			// Assooiate the component and ID.
			bioMightKey = new BioMightKey();
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(bordetellaPertussises.getComponentID());			
			System.out.println("Storing bordetellaPertussises Key: " + bioMightComponentRef + "   ID: " + bordetellaPertussises.getComponentID());
			bioMightKeys.setKey(bioMightKey);

			// On the post of data, we map the web data back
			// into the methodView object.  
			if (executeMethods) {
				//streptococciPneumoniae.executeMethods(bioMightMethods);
				//bioMightView.setX3D(streptococciPneumoniae.getX3D(snippet));
			}
			
			bioMightView.setX3D(bordetellaPertussises.getX3D(snippet));
		}	
		else if (bioMightComponentRef.equals(Constants.BordetellaPertussis))
		{
			BordetellaPertussis bordetellaPertussis = (BordetellaPertussis) bioMightInstance;
			bioMightView.setImage(bordetellaPertussis.getImage());
			bioMightView.setBioMightProperties(bordetellaPertussis.getProperties());
			bioMightView.setBioMightMethods(bordetellaPertussis.getMethods());

		
			// Assooiate the component and ID.
			bioMightKey = new BioMightKey();
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(bordetellaPertussis.getComponentID());			
			System.out.println("Storing BordetellaPertussis Key: " + bioMightComponentRef + "   ID: " + bordetellaPertussis.getComponentID());
			bioMightKeys.setKey(bioMightKey);

			// On the post of data, we map the web data back
			// into the methodView object.  
			if (executeMethods) {
				//streptococciPneumoniae.executeMethods(bioMightMethods);
				//bioMightView.setX3D(streptococciPneumoniae.getX3D(snippet));
			}
			
			bioMightView.setX3D(bordetellaPertussis.getX3D(snippet));
		}	
		else if (bioMightComponentRef.equals(Constants.FrancisellaTularensis))
		{
			FrancisellaTularensis francisellaTularensis = (FrancisellaTularensis) bioMightInstance;
			bioMightView.setImage(francisellaTularensis.getImage());
			bioMightView.setBioMightProperties(francisellaTularensis.getProperties());
			bioMightView.setBioMightMethods(francisellaTularensis.getMethods());
		}		
		else if (bioMightComponentRef.equals(Constants.HaemophilusInfluenzae))
		{
			HaemophilusInfluenzae haemophilusInfluenzae = (HaemophilusInfluenzae) bioMightInstance;
			bioMightView.setImage(haemophilusInfluenzae.getImage());
			bioMightView.setBioMightProperties(haemophilusInfluenzae.getProperties());
			bioMightView.setBioMightMethods(haemophilusInfluenzae.getMethods());
		}		
		

		// PLEOMORHPHIC - GRAM POSITIVE			
		
		else if (bioMightComponentRef.equals(Constants.ActinomycesGerencseriae))
		{
			ActinomycesGerencseriae actinomycesGerencseriae = (ActinomycesGerencseriae) bioMightInstance;
			bioMightView.setImage(actinomycesGerencseriae.getImage());
			bioMightView.setBioMightProperties(actinomycesGerencseriae.getProperties());
			bioMightView.setBioMightMethods(actinomycesGerencseriae.getMethods());
		}				
		else if (bioMightComponentRef.equals(Constants.ActinomycesIsraelii))
		{
			ActinomycesIsraelii actinomycesIsraelii = (ActinomycesIsraelii) bioMightInstance;
			bioMightView.setImage(actinomycesIsraelii.getImage());
			bioMightView.setBioMightProperties(actinomycesIsraelii.getProperties());
			bioMightView.setBioMightMethods(actinomycesIsraelii.getMethods());
		}
		else if (bioMightComponentRef.equals(Constants.MycobacteriumAviumIntracellulareComplex))
		{
			MycobacteriumAviumIntracellulareComplex mycobacteriumAIComplex = (MycobacteriumAviumIntracellulareComplex) bioMightInstance;
			bioMightView.setImage(mycobacteriumAIComplex.getImage());
			bioMightView.setBioMightProperties(mycobacteriumAIComplex.getProperties());
			bioMightView.setBioMightMethods(mycobacteriumAIComplex.getMethods());
		}
		else if (bioMightComponentRef.equals(Constants.MycobacteriumBovis))
		{
			MycobacteriumBovis mycobacteriumBovis = (MycobacteriumBovis) bioMightInstance;
			bioMightView.setImage(mycobacteriumBovis.getImage());
			bioMightView.setBioMightProperties(mycobacteriumBovis.getProperties());
			bioMightView.setBioMightMethods(mycobacteriumBovis.getMethods());
		}			
		else if (bioMightComponentRef.equals(Constants.MycobacteriumKansasii))
		{
			MycobacteriumKansasii mycobacteriumKansasii = (MycobacteriumKansasii) bioMightInstance;
			bioMightView.setImage(mycobacteriumKansasii.getImage());
			bioMightView.setBioMightProperties(mycobacteriumKansasii.getProperties());
			bioMightView.setBioMightMethods(mycobacteriumKansasii.getMethods());
		}			
		else if (bioMightComponentRef.equals(Constants.MycobacteriumLeprae))
		{
			MycobacteriumLeprae mycobacteriumLeprae = (MycobacteriumLeprae) bioMightInstance;
			bioMightView.setImage(mycobacteriumLeprae.getImage());
			bioMightView.setBioMightProperties(mycobacteriumLeprae.getProperties());
			bioMightView.setBioMightMethods(mycobacteriumLeprae.getMethods());
		}				
		else if (bioMightComponentRef.equals(Constants.MycobacteriumMarinum))
		{
			MycobacteriumMarinum mycobacteriumMarinum = (MycobacteriumMarinum) bioMightInstance;
			bioMightView.setImage(mycobacteriumMarinum.getImage());
			bioMightView.setBioMightProperties(mycobacteriumMarinum.getProperties());
			bioMightView.setBioMightMethods(mycobacteriumMarinum.getMethods());
		}
		else if (bioMightComponentRef.equals(Constants.MycobacteriumTuberculosis))
		{
			MycobacteriumTuberculosis mycobacteriumTuberculosis = (MycobacteriumTuberculosis) bioMightInstance;
			bioMightView.setImage(mycobacteriumTuberculosis.getImage());
			bioMightView.setBioMightProperties(mycobacteriumTuberculosis.getProperties());
			bioMightView.setBioMightMethods(mycobacteriumTuberculosis.getMethods());
		}
		else if (bioMightComponentRef.equals(Constants.PropioniBacteriumPropionicus))
		{
			PropioniBacteriumPropionicus propioniBacteriumPropionicus = (PropioniBacteriumPropionicus) bioMightInstance;
			bioMightView.setImage(propioniBacteriumPropionicus.getImage());
			bioMightView.setBioMightProperties(propioniBacteriumPropionicus.getProperties());
			bioMightView.setBioMightMethods(propioniBacteriumPropionicus.getMethods());
		}
		else if (bioMightComponentRef.equals(Constants.Gonococci))
		{
			Gonococci gonococci = (Gonococci) bioMightInstance;
			bioMightView.setImage(gonococci.getImage());
			bioMightView.setBioMightProperties(gonococci.getProperties());
			bioMightView.setBioMightMethods(gonococci.getMethods());
		
			// Assooiate the component and ID.
			bioMightKey = new BioMightKey();
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(gonococci.getComponentID());			
			System.out.println("Storing Gonococci Key: " + bioMightComponentRef + "   ID: " + gonococci.getComponentID());
			bioMightKeys.setKey(bioMightKey);

			// On the post of data, we map the web data back
			// into the methodView object.  
			if (executeMethods) {
				//streptococciMutans.executeMethods(bioMightMethods);
				//bioMightView.setX3D(streptococciMutans.getX3D(snippet));
			}
			
			bioMightView.setX3D(gonococci.getX3D(snippet));
		}	
		else if (bioMightComponentRef.equals(Constants.Gonococcus))
		{
			Gonococcus gonococcus = (Gonococcus) bioMightInstance;
			bioMightView.setImage(gonococcus.getImage());
			bioMightView.setBioMightProperties(gonococcus.getProperties());
			bioMightView.setBioMightMethods(gonococcus.getMethods());

			// Assooiate the component and ID.
			bioMightKey = new BioMightKey();
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(gonococcus.getComponentID());			
			System.out.println("Storing Gonococcus: " + bioMightComponentRef + "   ID: " + gonococcus.getComponentID());
			bioMightKeys.setKey(bioMightKey);

			// On the post of data, we map the web data back
			// into the methodView object.  
			if (executeMethods) {
				//streptococciPneumoniae.executeMethods(bioMightMethods);
				//bioMightView.setX3D(streptococciPneumoniae.getX3D(snippet));
			}
			
			bioMightView.setX3D(gonococcus.getX3D(snippet));
		}
		else if (bioMightComponentRef.equals(Constants.Meningococci))
		{
			Meningococci meningococci = (Meningococci) bioMightInstance;
			bioMightView.setImage(meningococci.getImage());
			bioMightView.setBioMightProperties(meningococci.getProperties());
			bioMightView.setBioMightMethods(meningococci.getMethods());
		
			// Assooiate the component and ID.
			bioMightKey = new BioMightKey();
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(meningococci.getComponentID());			
			System.out.println("Storing Meningococci Key: " + bioMightComponentRef + "   ID: " + meningococci.getComponentID());
			bioMightKeys.setKey(bioMightKey);

			// On the post of data, we map the web data back
			// into the methodView object.  
			if (executeMethods) {
				//meningococci.executeMethods(bioMightMethods);
				//bioMightView.setX3D(meningococci.getX3D(snippet));
			}
			
			bioMightView.setX3D(meningococci.getX3D(snippet));
		}	
		else if (bioMightComponentRef.equals(Constants.Meningococcus))
		{
			Meningococcus meningococcus = (Meningococcus) bioMightInstance;
			bioMightView.setImage(meningococcus.getImage());
			bioMightView.setBioMightProperties(meningococcus.getProperties());
			bioMightView.setBioMightMethods(meningococcus.getMethods());

			// Assooiate the component and ID.
			bioMightKey = new BioMightKey();
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(meningococcus.getComponentID());			
			System.out.println("Storing Meningococcus: " + bioMightComponentRef + "   ID: " + meningococcus.getComponentID());
			bioMightKeys.setKey(bioMightKey);

			// On the post of data, we map the web data back
			// into the methodView object.  
			if (executeMethods) {
				//meningococcus.executeMethods(bioMightMethods);
				//bioMightView.setX3D(meningococcus.getX3D(snippet));
			}
			
			bioMightView.setX3D(meningococcus.getX3D(snippet));
		}
		else if (bioMightComponentRef.equals(Constants.TreponemaPallidums))
		{
			TreponemaPallidums treponemaPallidums = (TreponemaPallidums) bioMightInstance;
			bioMightView.setImage(treponemaPallidums.getImage());
			bioMightView.setBioMightProperties(treponemaPallidums.getProperties());
			bioMightView.setBioMightMethods(treponemaPallidums.getMethods());
		
			// Assooiate the component and ID.
			bioMightKey = new BioMightKey();
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(treponemaPallidums.getComponentID());			
			System.out.println("Storing TreponemaPallidums Key: " + bioMightComponentRef + "   ID: " + treponemaPallidums.getComponentID());
			bioMightKeys.setKey(bioMightKey);

			// On the post of data, we map the web data back
			// into the methodView object.  
			if (executeMethods) {
				//meningococci.executeMethods(bioMightMethods);
				//bioMightView.setX3D(treponemaPallidums.getX3D(snippet));
			}
			
			bioMightView.setX3D(treponemaPallidums.getX3D(snippet));
		}	
		else if (bioMightComponentRef.equals(Constants.TreponemaPallidum))
		{
			TreponemaPallidum treponemaPallidum = (TreponemaPallidum) bioMightInstance;
			bioMightView.setImage(treponemaPallidum.getImage());
			bioMightView.setBioMightProperties(treponemaPallidum.getProperties());
			bioMightView.setBioMightMethods(treponemaPallidum.getMethods());
		
			// Assooiate the component and ID.
			bioMightKey = new BioMightKey();
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(treponemaPallidum.getComponentID());			
			System.out.println("Storing TreponemaPallidum Key: " + bioMightComponentRef + "   ID: " + treponemaPallidum.getComponentID());
			bioMightKeys.setKey(bioMightKey);

			// On the post of data, we map the web data back
			// into the methodView object.  
			if (executeMethods) {
				//meningococci.executeMethods(bioMightMethods);
				//bioMightView.setX3D(treponemaPallidum.getX3D(snippet));
			}
			
			bioMightView.setX3D(treponemaPallidum.getX3D(snippet));
		}		
		else
		{
			System.out.println("BioMightViewBacteria Component NOT MATCHED: " + bioMightComponentRef + "  " + bioMightComponentName);
		}
	
		
	System.out.println("Returning from BacteriaView");		
	return bioMightView;
	}
}
