package biomightweb.actions;

import biomight.BioMightKey;
import biomight.BioMightKeys;
import biomight.Constants;
import biomight.virus.CacheValleyVirus;
import biomight.virus.Capsid;
import biomight.virus.CapsidNeck;
import biomight.virus.CapsidTail;
import biomight.virus.rna.EnteroVirus;
import biomight.virus.CoreMembrane;
import biomight.virus.GlycoProteinSpike;
import biomight.virus.GlycoProteinSpikes;
import biomight.virus.HendraVirus;
import biomight.virus.InfluenzaAVirus;
import biomight.virus.InfluenzaAViruses;
import biomight.virus.LassaFeverVirus;
import biomight.virus.LymphocyticChorioMeningitisVirus;
import biomight.virus.MolluscumContagiosumVirus;
import biomight.virus.NipahVirus;
import biomight.virus.OuterMembrane;
import biomight.virus.rna.NoroVirus;
import biomight.virus.Virus;
import biomight.virus.VirusBasePlate;
import biomight.virus.VirusTailFiberSegment;
import biomight.virus.VirusTailFiberSegments;
import biomight.virus.VirusTailFibers;
import biomight.virus.Viruses;
import biomight.virus.WhitewaterArroyoVirus;
import biomight.virus.astroviridae.AstroVirus;
import biomight.virus.caliciviridae.Calicivirus;
import biomight.virus.circoviridae.CircoVirus;
import biomight.virus.dna.Adenoviridae;
import biomight.virus.dna.Adenovirus;
import biomight.virus.dna.Adenoviruses;
import biomight.virus.dna.Bacteriophage;
import biomight.virus.dna.Bacteriophages;
import biomight.virus.dna.PoxVirus;
import biomight.virus.dna.PoxViruses;
import biomight.virus.rna.AIDSVirus;
import biomight.virus.rna.AIDSViruses;
import biomight.virus.rna.EnteroViruses;
import biomight.virus.rna.NoroViruses;
import biomight.virus.rna.ReoVirus;
import biomight.virus.rna.ReoViruses;
import biomight.virus.rna.RetroVirus;
import biomight.virus.rna.RetroViruses;
import biomight.virus.rna.RotaVirus;
import biomight.virus.rna.RotaViruses;
import biomightweb.view.BioMightComponent;

/**
 * Maps BioMight Chemistry Component into the associated Java class.
 * 
 * SurferJim
 * 
 */

public class BioMightViewVirus {

	
	public void BioMightViewVirus() {
		
	}
	

	public BioMightComponent mapComponent(BioMightComponent bioMightComponent, Object bioMightInstance, boolean snippet) {
		
		BioMightKeys bioMightKeys = bioMightComponent.getBioMightKeys();
		String bioMightComponentRef = bioMightComponent.getBioMightComponentRef();
		String bioMightComponentName = bioMightComponent.getBioMightComponentName();
		String bioMightComponentID = bioMightComponent.getBioMightComponentID();
		BioMightKey bioMightKey = new BioMightKey();
		boolean executeMethods = false;
	
			
		/**************************************************************************
		*
		* VIRUSES
		* 
		***************************************************************************/

		if (bioMightComponentRef.equals(Constants.Viruses))
		{
			Viruses viruses = (Viruses) bioMightInstance;
			bioMightComponent.setImage(viruses.getImage());
			bioMightComponent.setBioMightProperties(viruses.getProperties());
			bioMightComponent.setBioMightMethods(viruses.getMethods());
			bioMightComponent.setX3D(viruses.getX3D(snippet));
		
			// Assooiate the component and ID
			bioMightKey = new BioMightKey();
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(viruses.getComponentID());			
			System.out.println("Storing VirusKey: " + bioMightComponent + "   ID: " + viruses.getComponentID());
			bioMightKeys.setKey(bioMightKey);

			// On the post of data, we map the web data back
			// into the methodView object.  
			if (executeMethods) {
				//virus.executeMethods(bioMightMethods);
				//bioMightComponent.setX3D(viruses.getX3D(snippet));
			}

		}	
		else if (bioMightComponentRef.equals(Constants.Virus))
		{
			Virus virus = (Virus) bioMightInstance;
			bioMightComponent.setImage(virus.getImage());
			bioMightComponent.setBioMightProperties(virus.getProperties());
			bioMightComponent.setBioMightMethods(virus.getMethods());
			bioMightComponent.setX3D(virus.getX3D(snippet));
		
			// Assooiate the component and ID
			bioMightKey = new BioMightKey();
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(virus.getComponentID());			
			System.out.println("Storing VirusKey: " + bioMightComponent + "   ID: " + virus.getComponentID());
			bioMightKeys.setKey(bioMightKey);

			// On the post of data, we map the web data back
			// into the methodView object.  
			if (executeMethods) {
				//virus.executeMethods(bioMightMethods);
				bioMightComponent.setX3D(virus.getX3D(snippet));
			}
		}
		else if (bioMightComponentRef.equals(Constants.Capsid))
		{
			Capsid capsid = (Capsid) bioMightInstance;
			bioMightComponent.setImage(capsid.getImage());
			bioMightComponent.setBioMightProperties(capsid.getProperties());
			bioMightComponent.setBioMightMethods(capsid.getMethods());
			bioMightComponent.setX3D(capsid.getX3D(snippet));
			bioMightComponent.setBioMightCollection(false);
			
			// Assooiate the component and ID
			bioMightKey = new BioMightKey();
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(capsid.getComponentID());			
			System.out.println("Storing CapsidKey: " + bioMightComponent + "   ID: " + capsid.getComponentID());
			bioMightKeys.setKey(bioMightKey);

			// On the post of data, we map the web data back
			// into the methodView object.  
			if (executeMethods) {
				capsid.executeMethods(bioMightComponent.getBioMightMethods());
				bioMightComponent.setX3D(capsid.getX3D(snippet));
			}
		}
		else if (bioMightComponentRef.equals(Constants.CoreMembrane))
		{
			CoreMembrane coreMembrane = (CoreMembrane) bioMightInstance;
			bioMightComponent.setImage(coreMembrane.getImage());
			bioMightComponent.setBioMightProperties(coreMembrane.getProperties());
			bioMightComponent.setBioMightMethods(coreMembrane.getMethods());
			bioMightComponent.setX3D(coreMembrane.getX3D(snippet));
			bioMightComponent.setBioMightCollection(false);
			
			// Assooiate the component and ID
			bioMightKey = new BioMightKey();
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(coreMembrane.getComponentID());			
			System.out.println("Storing CoreMembraneKey: " + bioMightComponent + "   ID: " + coreMembrane.getComponentID());
			bioMightKeys.setKey(bioMightKey);

			// On the post of data, we map the web data back
			// into the methodView object.  
			if (executeMethods) {
				coreMembrane.executeMethods(bioMightComponent.getBioMightMethods());
				bioMightComponent.setX3D(coreMembrane.getX3D(snippet));
			}
		}
		else if (bioMightComponentRef.equals(Constants.OuterMembrane))
		{
			OuterMembrane outerMembrane = (OuterMembrane) bioMightInstance;
			bioMightComponent.setImage(outerMembrane.getImage());
			bioMightComponent.setBioMightProperties(outerMembrane.getProperties());
			bioMightComponent.setBioMightMethods(outerMembrane.getMethods());
			bioMightComponent.setX3D(outerMembrane.getX3D(snippet));
			bioMightComponent.setBioMightCollection(false);
			
			// Assooiate the component and ID
			bioMightKey = new BioMightKey();
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(outerMembrane.getComponentID());			
			System.out.println("Storing OuterMembraneKey: " + bioMightComponent + "   ID: " + outerMembrane.getComponentID());
			bioMightKeys.setKey(bioMightKey);

			// On the post of data, we map the web data back
			// into the methodView object.  
			if (executeMethods) {
				outerMembrane.executeMethods(bioMightComponent.getBioMightMethods());
				bioMightComponent.setX3D(outerMembrane.getX3D(snippet));
			}
		}
		else if (bioMightComponentRef.equals(Constants.CapsidNeck))
		{
			CapsidNeck capsidNeck = (CapsidNeck) bioMightInstance;
			bioMightComponent.setImage(capsidNeck.getImage());
			bioMightComponent.setBioMightProperties(capsidNeck.getProperties());
			bioMightComponent.setBioMightMethods(capsidNeck.getMethods());
			bioMightComponent.setX3D(capsidNeck.getX3D(snippet));
			bioMightComponent.setBioMightCollection(false);
			
			// Assooiate the component and ID
			bioMightKey = new BioMightKey();
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(capsidNeck.getComponentID());			
			System.out.println("Storing CapsidNeck Key: " + bioMightComponent + "   ID: " + capsidNeck.getComponentID());
			bioMightKeys.setKey(bioMightKey);

			// On the post of data, we map the web data back
			// into the methodView object.  
			if (executeMethods) {
				capsidNeck.executeMethods(bioMightComponent.getBioMightMethods());
				bioMightComponent.setX3D(capsidNeck.getX3D(snippet));
			}
		}
		else if (bioMightComponentRef.equals(Constants.CapsidTail))
		{
			CapsidTail capsidTail = (CapsidTail) bioMightInstance;
			bioMightComponent.setImage(capsidTail.getImage());
			bioMightComponent.setBioMightProperties(capsidTail.getProperties());
			bioMightComponent.setBioMightMethods(capsidTail.getMethods());
			bioMightComponent.setX3D(capsidTail.getX3D(snippet));
			bioMightComponent.setBioMightCollection(false);
			
			// Assooiate the component and ID
			bioMightKey = new BioMightKey();
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(capsidTail.getComponentID());			
			System.out.println("Storing CapsidTail Key: " + bioMightComponent + "   ID: " + capsidTail.getComponentID());
			bioMightKeys.setKey(bioMightKey);

			// On the post of data, we map the web data back
			// into the methodView object.  
			if (executeMethods) {
				capsidTail.executeMethods(bioMightComponent.getBioMightMethods());
				bioMightComponent.setX3D(capsidTail.getX3D(snippet));
			}
		}
		else if (bioMightComponentRef.equals(Constants.VirusBasePlate))
		{
			VirusBasePlate virusBasePlate = (VirusBasePlate) bioMightInstance;
			bioMightComponent.setImage(virusBasePlate.getImage());
			bioMightComponent.setBioMightProperties(virusBasePlate.getProperties());
			bioMightComponent.setBioMightMethods(virusBasePlate.getMethods());
			bioMightComponent.setX3D(virusBasePlate.getX3D(snippet));
			bioMightComponent.setBioMightCollection(false);
			
			// Associate the component and ID
			bioMightKey = new BioMightKey();
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(virusBasePlate.getComponentID());			
			System.out.println("Storing VirusBasePlate Key: " + bioMightComponent + "   ID: " + virusBasePlate.getComponentID());
			bioMightKeys.setKey(bioMightKey);

			// On the post of data, we map the web data back
			// into the methodView object.  
			if (executeMethods) {
				virusBasePlate.executeMethods(bioMightComponent.getBioMightMethods());
				bioMightComponent.setX3D(virusBasePlate.getX3D(snippet));
			}
		}
		else if (bioMightComponentRef.equals(Constants.VirusTailFibers))
		{
			VirusTailFibers virusTailFibers = (VirusTailFibers) bioMightInstance;
			bioMightComponent.setImage(virusTailFibers.getImage());
			bioMightComponent.setBioMightProperties(virusTailFibers.getProperties());
			bioMightComponent.setBioMightMethods(virusTailFibers.getMethods());
			bioMightComponent.setX3D(virusTailFibers.getX3D(snippet));
			bioMightComponent.setBioMightCollection(false);
			
			// Associate the component and ID
			bioMightKey = new BioMightKey();
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(virusTailFibers.getComponentID());			
			System.out.println("Storing VirusTailFibers Key: " + bioMightComponent + "   ID: " + virusTailFibers.getComponentID());
			bioMightKeys.setKey(bioMightKey);

			// On the post of data, we map the web data back
			// into the methodView object.  
			if (executeMethods) {
				virusTailFibers.executeMethods(bioMightComponent.getBioMightMethods());
				bioMightComponent.setX3D(virusTailFibers.getX3D(snippet));
			}
		}
		else if (bioMightComponentRef.equals(Constants.VirusTailFiberSegments))
		{
			VirusTailFiberSegments virusTailFiberSegments = (VirusTailFiberSegments) bioMightInstance;
			bioMightComponent.setImage(virusTailFiberSegments.getImage());
			bioMightComponent.setBioMightProperties(virusTailFiberSegments.getProperties());
			bioMightComponent.setBioMightMethods(virusTailFiberSegments.getMethods());
			bioMightComponent.setX3D(virusTailFiberSegments.getX3D(snippet));
			bioMightComponent.setBioMightCollection(false);
			
			// Associate the component and ID
			bioMightKey = new BioMightKey();
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(virusTailFiberSegments.getComponentID());			
			System.out.println("Storing VirusTailFiberSegments Key: " + bioMightComponent + "   ID: " + virusTailFiberSegments.getComponentID());
			bioMightKeys.setKey(bioMightKey);

			// On the post of data, we map the web data back
			// into the methodView object.  
			if (executeMethods) {
				virusTailFiberSegments.executeMethods(bioMightComponent.getBioMightMethods());
				bioMightComponent.setX3D(virusTailFiberSegments.getX3D(snippet));
			}
		}
		else if (bioMightComponentRef.equals(Constants.VirusTailFiberSegment))
		{
			VirusTailFiberSegment virusTailFiberSegment = (VirusTailFiberSegment) bioMightInstance;
			bioMightComponent.setImage(virusTailFiberSegment.getImage());
			bioMightComponent.setBioMightProperties(virusTailFiberSegment.getProperties());
			bioMightComponent.setBioMightMethods(virusTailFiberSegment.getMethods());
			bioMightComponent.setX3D(virusTailFiberSegment.getX3D(snippet));
			bioMightComponent.setBioMightCollection(false);
			
			// Associate the component and ID
			bioMightKey = new BioMightKey();
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(virusTailFiberSegment.getComponentID());			
			System.out.println("Storing VirusTailFiberSegment Key: " + bioMightComponent + "   ID: " + virusTailFiberSegment.getComponentID());
			bioMightKeys.setKey(bioMightKey);

			// On the post of data, we map the web data back
			// into the methodView object.  
			if (executeMethods) {
				virusTailFiberSegment.executeMethods(bioMightComponent.getBioMightMethods());
				bioMightComponent.setX3D(virusTailFiberSegment.getX3D(snippet));
			}
		}		
		else if (bioMightComponentRef.equals(Constants.CacheValleyVirus))
		{
			CacheValleyVirus cacheValleyVirus = (CacheValleyVirus) bioMightInstance;
			bioMightComponent.setImage(cacheValleyVirus.getImage());
		}
		else if (bioMightComponentRef.equals(Constants.HendraVirus))
		{
			HendraVirus hendraVirus = (HendraVirus) bioMightInstance;
			bioMightComponent.setImage(hendraVirus.getImage());
		}				
		else if (bioMightComponentRef.equals(Constants.LassaFeverVirus))
		{
			LassaFeverVirus lassaFeverVirus = (LassaFeverVirus) bioMightInstance;
			bioMightComponent.setImage(lassaFeverVirus.getImage());
		}							
		else if (bioMightComponentRef.equals(Constants.LymphocyticChorioMeningitisVirus))
		{
			LymphocyticChorioMeningitisVirus lymphoChorioMeningVirus = (LymphocyticChorioMeningitisVirus) bioMightInstance;
			bioMightComponent.setImage(lymphoChorioMeningVirus.getImage());
		}
		else if (bioMightComponentRef.equals(Constants.MolluscumContagiosumVirus))
		{
			MolluscumContagiosumVirus molluscumContagiosumVirus = (MolluscumContagiosumVirus) bioMightInstance;
			bioMightComponent.setImage(molluscumContagiosumVirus.getImage());
		}
		else if (bioMightComponentRef.equals(Constants.NipahVirus))
		{
			NipahVirus nipahVirus = (NipahVirus) bioMightInstance;
			bioMightComponent.setImage(nipahVirus.getImage());
		}	
		else if (bioMightComponentRef.equals(Constants.WhitewaterArroyoVirus))
		{
			WhitewaterArroyoVirus whitewaterArroyoVirus = (WhitewaterArroyoVirus) bioMightInstance;
			bioMightComponent.setImage(whitewaterArroyoVirus.getImage());
		}	
		else if (bioMightComponentRef.equals(Constants.AstroVirus))
		{
			AstroVirus astroVirus = (AstroVirus) bioMightInstance;
			bioMightComponent.setImage(astroVirus.getImage());
		}				
		else if (bioMightComponentRef.equals(Constants.Calicivirus))
		{
			Calicivirus calicivirus = (Calicivirus) bioMightInstance;
			bioMightComponent.setImage(calicivirus.getImage());
		}			
		else if (bioMightComponentRef.equals(Constants.CircoVirus))
		{
			CircoVirus circoVirus = (CircoVirus) bioMightInstance;
			bioMightComponent.setImage(circoVirus.getImage());
		}	
		else if (bioMightComponentRef.equals(Constants.Adenoviridae))
		{
			Adenoviridae adenoviridae = (Adenoviridae) bioMightInstance;
			bioMightComponent.setImage(adenoviridae.getImage());
		}
		else if (bioMightComponentRef.equals(Constants.Adenoviruses))
		{
			Adenoviruses adenoviruses = (Adenoviruses) bioMightInstance;
			bioMightComponent.setImage(adenoviruses.getImage());
			bioMightComponent.setBioMightProperties(adenoviruses.getProperties());
			bioMightComponent.setBioMightMethods(adenoviruses.getMethods());
			bioMightComponent.setBioMightCollection(true);
		
			// Assooiate the component and ID.
			bioMightKey = new BioMightKey();
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(adenoviruses.getComponentID());			
			System.out.println("Storing adenoviruses: " + bioMightComponentRef + "   ID: " + adenoviruses.getComponentID());
			bioMightKeys.setKey(bioMightKey);

			// On the post of data, we map the web data back
			// into the methodView object.  
			if (executeMethods) {
				//bacillusAnthracis.executeMethods(bioMightMethods);
				//bioMightComponent.setX3D(bacillusAnthracis.getX3D(snippet));
			}
			
			bioMightComponent.setX3D(adenoviruses.getX3D(snippet));
		}	
		else if (bioMightComponentRef.equals(Constants.Adenovirus))
		{
			Adenovirus adenovirus = (Adenovirus) bioMightInstance;
			bioMightComponent.setImage(adenovirus.getImage());
			bioMightComponent.setBioMightProperties(adenovirus.getProperties());
			bioMightComponent.setBioMightMethods(adenovirus.getMethods());
			bioMightComponent.setBioMightCollection(false);
		
			// Assooiate the component and ID.
			bioMightKey = new BioMightKey();
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(adenovirus.getComponentID());			
			System.out.println("Storing adenovirus: " + bioMightComponentRef + "   ID: " + adenovirus.getComponentID());
			bioMightKeys.setKey(bioMightKey);

			// On the post of data, we map the web data back
			// into the methodView object.  
			if (executeMethods) {
				//bacillusAnthracis.executeMethods(bioMightMethods);
				//bioMightComponent.setX3D(bacillusAnthracis.getX3D(snippet));
			}
			
			bioMightComponent.setX3D(adenovirus.getX3D(snippet));
		}	

		else if (bioMightComponentRef.equals(Constants.Bacteriophages))
		{
			Bacteriophages bacteriophages = (Bacteriophages) bioMightInstance;
			bioMightComponent.setImage(bacteriophages.getImage());
			bioMightComponent.setBioMightProperties(bacteriophages.getProperties());
			bioMightComponent.setBioMightMethods(bacteriophages.getMethods());
			bioMightComponent.setBioMightCollection(true);
		
			// Assooiate the component and ID.
			bioMightKey = new BioMightKey();
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(bacteriophages.getComponentID());			
			System.out.println("Storing bacteriophages: " + bioMightComponentRef + "   ID: " + bacteriophages.getComponentID());
			bioMightKeys.setKey(bioMightKey);

			// On the post of data, we map the web data back
			// into the methodView object.  
			if (executeMethods) {
				//bacillusAnthracis.executeMethods(bioMightMethods);
				//bioMightComponent.setX3D(bacillusAnthracis.getX3D(snippet));
			}
			
			bioMightComponent.setX3D(bacteriophages.getX3D(snippet));
		}	
		else if (bioMightComponentRef.equals(Constants.Bacteriophage))
		{
			Bacteriophage bacteriophage = (Bacteriophage) bioMightInstance;
			bioMightComponent.setImage(bacteriophage.getImage());
			bioMightComponent.setBioMightProperties(bacteriophage.getProperties());
			bioMightComponent.setBioMightMethods(bacteriophage.getMethods());
			bioMightComponent.setBioMightCollection(false);
		
			// Assooiate the component and ID.
			bioMightKey = new BioMightKey();
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(bacteriophage.getComponentID());			
			System.out.println("Storing bacteriophage: " + bioMightComponentRef + "   ID: " + bacteriophage.getComponentID());
			bioMightKeys.setKey(bioMightKey);

			// On the post of data, we map the web data back
			// into the methodView object.  
			if (executeMethods) {
				//bacillusAnthracis.executeMethods(bioMightMethods);
				//bioMightComponent.setX3D(bacillusAnthracis.getX3D(snippet));
			}
			
			bioMightComponent.setX3D(bacteriophage.getX3D(snippet));
		}
		
		
		else if (bioMightComponentRef.equals(Constants.InfluenzaAViruses))
		{
			InfluenzaAViruses influenzaAViruses = (InfluenzaAViruses) bioMightInstance;
			bioMightComponent.setImage(influenzaAViruses.getImage());
			bioMightComponent.setBioMightProperties(influenzaAViruses.getProperties());
			bioMightComponent.setBioMightMethods(influenzaAViruses.getMethods());
			bioMightComponent.setBioMightCollection(true);
		
			// Assooiate the component and ID.
			bioMightKey = new BioMightKey();
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(influenzaAViruses.getComponentID());			
			System.out.println("Storing influenzaAViruses: " + bioMightComponentRef + "   ID: " + influenzaAViruses.getComponentID());
			bioMightKeys.setKey(bioMightKey);

			// On the post of data, we map the web data back
			// into the methodView object.  
			if (executeMethods) {
				//bacillusAnthracis.executeMethods(bioMightMethods);
				//bioMightComponent.setX3D(bacillusAnthracis.getX3D(snippet));
			}
			
			bioMightComponent.setX3D(influenzaAViruses.getX3D(snippet));
		}	
		else if (bioMightComponentRef.equals(Constants.InfluenzaAVirus))
		{
			InfluenzaAVirus influenzaAVirus = (InfluenzaAVirus) bioMightInstance;
			bioMightComponent.setImage(influenzaAVirus.getImage());
			bioMightComponent.setBioMightProperties(influenzaAVirus.getProperties());
			bioMightComponent.setBioMightMethods(influenzaAVirus.getMethods());
			bioMightComponent.setBioMightCollection(false);
		
			// Assooiate the component and ID.
			bioMightKey = new BioMightKey();
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(influenzaAVirus.getComponentID());			
			System.out.println("Storing influenzaAVirus: " + bioMightComponentRef + "   ID: " + influenzaAVirus.getComponentID());
			bioMightKeys.setKey(bioMightKey);

			// On the post of data, we map the web data back
			// into the methodView object.  
			if (executeMethods) {
				//bacillusAnthracis.executeMethods(bioMightMethods);
				//bioMightComponent.setX3D(bacillusAnthracis.getX3D(snippet));
			}
			
			bioMightComponent.setX3D(influenzaAVirus.getX3D(snippet));
		}		
		else if (bioMightComponentRef.equals(Constants.GlycoProteinSpikes))
		{
			GlycoProteinSpikes glycoProteinSpikes = (GlycoProteinSpikes) bioMightInstance;
			bioMightComponent.setImage(glycoProteinSpikes.getImage());
			bioMightComponent.setBioMightProperties(glycoProteinSpikes.getProperties());
			bioMightComponent.setBioMightMethods(glycoProteinSpikes.getMethods());
			bioMightComponent.setBioMightCollection(false);
		
			// Assooiate the component and ID.
			bioMightKey = new BioMightKey();
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(glycoProteinSpikes.getComponentID());			
			System.out.println("Storing GlycoProteinSpikes: " + bioMightComponentRef + "   ID: " + glycoProteinSpikes.getComponentID());
			bioMightKeys.setKey(bioMightKey);

			// On the post of data, we map the web data back
			// into the methodView object.  
			if (executeMethods) {
				//glycoProteinSpikes.executeMethods(bioMightMethods);
				//bioMightComponent.setX3D(glycoProteinSpikes.getX3D(snippet));
			}
			
			bioMightComponent.setX3D(glycoProteinSpikes.getX3D(snippet));
		}		
		else if (bioMightComponentRef.equals(Constants.GlycoProteinSpike))
		{
			GlycoProteinSpike glycoProteinSpike = (GlycoProteinSpike) bioMightInstance;
			bioMightComponent.setImage(glycoProteinSpike.getImage());
			bioMightComponent.setBioMightProperties(glycoProteinSpike.getProperties());
			bioMightComponent.setBioMightMethods(glycoProteinSpike.getMethods());
			bioMightComponent.setBioMightCollection(false);
		
			// Assooiate the component and ID.
			bioMightKey = new BioMightKey();
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(glycoProteinSpike.getComponentID());			
			System.out.println("Storing GlycoProteinSpike: " + bioMightComponentRef + "   ID: " + glycoProteinSpike.getComponentID());
			bioMightKeys.setKey(bioMightKey);

			// On the post of data, we map the web data back
			// into the methodView object.  
			if (executeMethods) {
				//bacillusAnthracis.executeMethods(bioMightMethods);
				//bioMightComponent.setX3D(bacillusAnthracis.getX3D(snippet));
			}
			
			bioMightComponent.setX3D(glycoProteinSpike.getX3D(snippet));
		}

		else if (bioMightComponentRef.equals(Constants.EnteroViruses))
		{
			EnteroViruses enteroViruses = (EnteroViruses) bioMightInstance;
			bioMightComponent.setImage(enteroViruses.getImage());
			bioMightComponent.setBioMightProperties(enteroViruses.getProperties());
			bioMightComponent.setBioMightMethods(enteroViruses.getMethods());
			bioMightComponent.setBioMightCollection(true);
		
			// Assooiate the component and ID.
			bioMightKey = new BioMightKey();
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(enteroViruses.getComponentID());			
			System.out.println("Storing enteroViruses: " + bioMightComponentRef + "   ID: " + enteroViruses.getComponentID());
			bioMightKeys.setKey(bioMightKey);

			// On the post of data, we map the web data back
			// into the methodView object.  
			if (executeMethods) {
				//enteroViruses.executeMethods(bioMightMethods);
				//bioMightComponent.setX3D(enteroViruses.getX3D(snippet));
			}
			
			bioMightComponent.setX3D(enteroViruses.getX3D(snippet));
		}	
		else if (bioMightComponentRef.equals(Constants.EnteroVirus))
		{
			EnteroVirus enteroVirus = (EnteroVirus) bioMightInstance;
			bioMightComponent.setImage(enteroVirus.getImage());
			bioMightComponent.setBioMightProperties(enteroVirus.getProperties());
			bioMightComponent.setBioMightMethods(enteroVirus.getMethods());
			bioMightComponent.setBioMightCollection(false);
		
			// Assooiate the component and ID.
			bioMightKey = new BioMightKey();
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(enteroVirus.getComponentID());			
			System.out.println("Storing enteroVirus: " + bioMightComponentRef + "   ID: " + enteroVirus.getComponentID());
			bioMightKeys.setKey(bioMightKey);

			// On the post of data, we map the web data back
			// into the methodView object.  
			if (executeMethods) {
				//enteroVirus.executeMethods(bioMightMethods);
				//bioMightComponent.setX3D(enteroVirus.getX3D(snippet));
			}
			
			bioMightComponent.setX3D(enteroVirus.getX3D(snippet));
		}
		else if (bioMightComponentRef.equals(Constants.AIDSViruses))
		{
			AIDSViruses aidsViruses = (AIDSViruses) bioMightInstance;
			bioMightComponent.setImage(aidsViruses.getImage());
			bioMightComponent.setBioMightProperties(aidsViruses.getProperties());
			bioMightComponent.setBioMightMethods(aidsViruses.getMethods());
			bioMightComponent.setBioMightCollection(true);
		
			// Assooiate the component and ID.
			bioMightKey = new BioMightKey();
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(aidsViruses.getComponentID());			
			System.out.println("Storing aidsViruses: " + bioMightComponentRef + "   ID: " + aidsViruses.getComponentID());
			bioMightKeys.setKey(bioMightKey);

			// On the post of data, we map the web data back
			// into the methodView object.  
			if (executeMethods) {
				//aidsViruses.executeMethods(bioMightMethods);
				//bioMightComponent.setX3D(aidsViruses.getX3D(snippet));
			}
			
			bioMightComponent.setX3D(aidsViruses.getX3D(snippet));
		}	
		else if (bioMightComponentRef.equals(Constants.AIDSVirus))
		{
			AIDSVirus aidsVirus = (AIDSVirus) bioMightInstance;
			bioMightComponent.setImage(aidsVirus.getImage());
			bioMightComponent.setBioMightProperties(aidsVirus.getProperties());
			bioMightComponent.setBioMightMethods(aidsVirus.getMethods());
			bioMightComponent.setBioMightCollection(false);
		
			// Assooiate the component and ID.
			bioMightKey = new BioMightKey();
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(aidsVirus.getComponentID());			
			System.out.println("Storing aidsVirus: " + bioMightComponentRef + "   ID: " + aidsVirus.getComponentID());
			bioMightKeys.setKey(bioMightKey);

			// On the post of data, we map the web data back
			// into the methodView object.  
			if (executeMethods) {
				//aidsVirus.executeMethods(bioMightMethods);
				//bioMightComponent.setX3D(aidsVirus.getX3D(snippet));
			}
			
			bioMightComponent.setX3D(aidsVirus.getX3D(snippet));
		}
		else if (bioMightComponentRef.equals(Constants.NoroViruses))
		{
			NoroViruses noroViruses = (NoroViruses) bioMightInstance;
			bioMightComponent.setImage(noroViruses.getImage());
			bioMightComponent.setBioMightProperties(noroViruses.getProperties());
			bioMightComponent.setBioMightMethods(noroViruses.getMethods());
			bioMightComponent.setBioMightCollection(true);
		
			// Assooiate the component and ID.
			bioMightKey = new BioMightKey();
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(noroViruses.getComponentID());			
			System.out.println("Storing noroViruses: " + bioMightComponentRef + "   ID: " + noroViruses.getComponentID());
			bioMightKeys.setKey(bioMightKey);

			// On the post of data, we map the web data back
			// into the methodView object.  
			if (executeMethods) {
				//noroViruses.executeMethods(bioMightMethods);
				//bioMightComponent.setX3D(noroViruses.getX3D(snippet));
			}
			
			bioMightComponent.setX3D(noroViruses.getX3D(snippet));
		}	
		else if (bioMightComponentRef.equals(Constants.NoroVirus))
		{
			NoroVirus noroVirus = (NoroVirus) bioMightInstance;
			bioMightComponent.setImage(noroVirus.getImage());
			bioMightComponent.setBioMightProperties(noroVirus.getProperties());
			bioMightComponent.setBioMightMethods(noroVirus.getMethods());
			bioMightComponent.setBioMightCollection(false);
		
			// Assooiate the component and ID.
			bioMightKey = new BioMightKey();
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(noroVirus.getComponentID());			
			System.out.println("Storing noroVirus: " + bioMightComponentRef + "   ID: " + noroVirus.getComponentID());
			bioMightKeys.setKey(bioMightKey);

			// On the post of data, we map the web data back
			// into the methodView object.  
			if (executeMethods) {
				//noroVirus.executeMethods(bioMightMethods);
				//bioMightComponent.setX3D(noroVirus.getX3D(snippet));
			}
			
			bioMightComponent.setX3D(noroVirus.getX3D(snippet));
		}
		else if (bioMightComponentRef.equals(Constants.PoxViruses))
		{
			PoxViruses poxViruses = (PoxViruses) bioMightInstance;
			bioMightComponent.setImage(poxViruses.getImage());
			bioMightComponent.setBioMightProperties(poxViruses.getProperties());
			bioMightComponent.setBioMightMethods(poxViruses.getMethods());
			bioMightComponent.setBioMightCollection(true);
		
			// Assooiate the component and ID.
			bioMightKey = new BioMightKey();
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(poxViruses.getComponentID());			
			System.out.println("Storing poxViruses: " + bioMightComponentRef + "   ID: " + poxViruses.getComponentID());
			bioMightKeys.setKey(bioMightKey);

			// On the post of data, we map the web data back
			// into the methodView object.  
			if (executeMethods) {
				//poxViruses.executeMethods(bioMightMethods);
				//bioMightComponent.setX3D(poxViruses.getX3D(snippet));
			}
			
			bioMightComponent.setX3D(poxViruses.getX3D(snippet));
		}	
		else if (bioMightComponentRef.equals(Constants.PoxVirus))
		{
			PoxVirus poxVirus = (PoxVirus) bioMightInstance;
			bioMightComponent.setImage(poxVirus.getImage());
			bioMightComponent.setBioMightProperties(poxVirus.getProperties());
			bioMightComponent.setBioMightMethods(poxVirus.getMethods());
			bioMightComponent.setBioMightCollection(false);
		
			// Assooiate the component and ID.
			bioMightKey = new BioMightKey();
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(poxVirus.getComponentID());			
			System.out.println("Storing poxVirus: " + bioMightComponentRef + "   ID: " + poxVirus.getComponentID());
			bioMightKeys.setKey(bioMightKey);

			// On the post of data, we map the web data back
			// into the methodView object.  
			if (executeMethods) {
				//poxVirus.executeMethods(bioMightMethods);
				//bioMightComponent.setX3D(poxVirus.getX3D(snippet));
			}
			
			bioMightComponent.setX3D(poxVirus.getX3D(snippet));
		}
		else if (bioMightComponentRef.equals(Constants.ReoViruses))
		{
			ReoViruses reoViruses = (ReoViruses) bioMightInstance;
			bioMightComponent.setImage(reoViruses.getImage());
			bioMightComponent.setBioMightProperties(reoViruses.getProperties());
			bioMightComponent.setBioMightMethods(reoViruses.getMethods());
			bioMightComponent.setBioMightCollection(true);
		
			// Assooiate the component and ID.
			bioMightKey = new BioMightKey();
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(reoViruses.getComponentID());			
			System.out.println("Storing reoViruses: " + bioMightComponentRef + "   ID: " + reoViruses.getComponentID());
			bioMightKeys.setKey(bioMightKey);

			// On the post of data, we map the web data back
			// into the methodView object.  
			if (executeMethods) {
				//reoViruses.executeMethods(bioMightMethods);
				//bioMightComponent.setX3D(reoViruses.getX3D(snippet));
			}
			
			bioMightComponent.setX3D(reoViruses.getX3D(snippet));
		}	
		else if (bioMightComponentRef.equals(Constants.ReoVirus))
		{
			ReoVirus reoVirus = (ReoVirus) bioMightInstance;
			bioMightComponent.setImage(reoVirus.getImage());
			bioMightComponent.setBioMightProperties(reoVirus.getProperties());
			bioMightComponent.setBioMightMethods(reoVirus.getMethods());
			bioMightComponent.setBioMightCollection(false);
		
			// Assooiate the component and ID.
			bioMightKey = new BioMightKey();
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(reoVirus.getComponentID());			
			System.out.println("Storing reoVirus: " + bioMightComponentRef + "   ID: " + reoVirus.getComponentID());
			bioMightKeys.setKey(bioMightKey);

			// On the post of data, we map the web data back
			// into the methodView object.  
			if (executeMethods) {
				//reoVirus.executeMethods(bioMightMethods);
				//bioMightComponent.setX3D(reoVirus.getX3D(snippet));
			}
			
			bioMightComponent.setX3D(reoVirus.getX3D(snippet));
		}
		else if (bioMightComponentRef.equals(Constants.RetroViruses))
		{
			RetroViruses retroViruses = (RetroViruses) bioMightInstance;
			bioMightComponent.setImage(retroViruses.getImage());
			bioMightComponent.setBioMightProperties(retroViruses.getProperties());
			bioMightComponent.setBioMightMethods(retroViruses.getMethods());
			bioMightComponent.setBioMightCollection(true);
		
			// Assooiate the component and ID.
			bioMightKey = new BioMightKey();
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(retroViruses.getComponentID());			
			System.out.println("Storing retroViruses: " + bioMightComponentRef + "   ID: " + retroViruses.getComponentID());
			bioMightKeys.setKey(bioMightKey);

			// On the post of data, we map the web data back
			// into the methodView object.  
			if (executeMethods) {
				//retroViruses.executeMethods(bioMightMethods);
				//bioMightComponent.setX3D(retroViruses.getX3D(snippet));
			}
			
			bioMightComponent.setX3D(retroViruses.getX3D(snippet));
		}	
		else if (bioMightComponentRef.equals(Constants.RetroVirus))
		{
			RetroVirus retroVirus = (RetroVirus) bioMightInstance;
			bioMightComponent.setImage(retroVirus.getImage());
			bioMightComponent.setBioMightProperties(retroVirus.getProperties());
			bioMightComponent.setBioMightMethods(retroVirus.getMethods());
			bioMightComponent.setBioMightCollection(false);
		
			// Assooiate the component and ID.
			bioMightKey = new BioMightKey();
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(retroVirus.getComponentID());			
			System.out.println("Storing retroVirus: " + bioMightComponentRef + "   ID: " + retroVirus.getComponentID());
			bioMightKeys.setKey(bioMightKey);

			// On the post of data, we map the web data back
			// into the methodView object.  
			if (executeMethods) {
				//retroVirus.executeMethods(bioMightMethods);
				//bioMightComponent.setX3D(retroVirus.getX3D(snippet));
			}
			
			bioMightComponent.setX3D(retroVirus.getX3D(snippet));
		}
		else if (bioMightComponentRef.equals(Constants.RotaViruses))
		{
			RotaViruses rotaViruses = (RotaViruses) bioMightInstance;
			bioMightComponent.setImage(rotaViruses.getImage());
			bioMightComponent.setBioMightProperties(rotaViruses.getProperties());
			bioMightComponent.setBioMightMethods(rotaViruses.getMethods());
			bioMightComponent.setBioMightCollection(true);
		
			// Assooiate the component and ID.
			bioMightKey = new BioMightKey();
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(rotaViruses.getComponentID());			
			System.out.println("Storing rotaViruses: " + bioMightComponentRef + "   ID: " + rotaViruses.getComponentID());
			bioMightKeys.setKey(bioMightKey);

			// On the post of data, we map the web data back
			// into the methodView object.  
			if (executeMethods) {
				//rotaViruses.executeMethods(bioMightMethods);
				//bioMightComponent.setX3D(rotaViruses.getX3D(snippet));
			}
			
			bioMightComponent.setX3D(rotaViruses.getX3D(snippet));
		}	
		else if (bioMightComponentRef.equals(Constants.RotaVirus))
		{
			RotaVirus rotaVirus = (RotaVirus) bioMightInstance;
			bioMightComponent.setImage(rotaVirus.getImage());
			bioMightComponent.setBioMightProperties(rotaVirus.getProperties());
			bioMightComponent.setBioMightMethods(rotaVirus.getMethods());
			bioMightComponent.setBioMightCollection(false);
		
			// Assooiate the component and ID.
			bioMightKey = new BioMightKey();
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(rotaVirus.getComponentID());			
			System.out.println("Storing rotaVirus: " + bioMightComponentRef + "   ID: " + rotaVirus.getComponentID());
			bioMightKeys.setKey(bioMightKey);

			// On the post of data, we map the web data back
			// into the methodView object.  
			if (executeMethods) {
				//rotaVirus.executeMethods(bioMightMethods);
				//bioMightComponent.setX3D(rotaVirus.getX3D(snippet));
			}
			
			bioMightComponent.setX3D(rotaVirus.getX3D(snippet));
		}
		
		else
		{
			System.out.println("BioMightView Component NOT MATCHED: " + bioMightComponentRef + " " + bioMightComponentName);
		}
	
	
		
		
		return bioMightComponent;
	}
}
