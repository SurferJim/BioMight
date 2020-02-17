package biomightweb.actions;

import biomight.BioMightKey;
import biomight.BioMightKeys;
import biomight.Constants;
import biomight.system.CirculatorySystem;
import biomight.system.vascular.arteries.Arteries;
import biomight.system.vascular.arteries.DigitalArtery;
import biomight.system.vascular.arteries.abdomen.AdrenalArteries;
import biomight.system.vascular.arteries.abdomen.AdrenalArtery;
import biomight.system.vascular.arteries.abdomen.InferiorSupraRenalArtery;
import biomight.system.vascular.arteries.abdomen.MiddleSupraRenalArtery;
import biomight.system.vascular.arteries.abdomen.SpleenCentralArteries;
import biomight.system.vascular.arteries.abdomen.SpleenCentralArtery;
import biomight.system.vascular.arteries.abdomen.SuperiorSupraRenalArtery;
import biomight.system.vascular.arteries.arm.BrachialArtery;
import biomight.system.vascular.arteries.arm.RadialArtery;
import biomight.system.vascular.arteries.arm.UlnarArtery;
import biomight.system.vascular.arteries.chest.AortaArtery;
import biomight.system.vascular.arteries.chest.AscendingAortaArtery;
import biomight.system.vascular.arteries.chest.AxillaryArteries;
import biomight.system.vascular.arteries.chest.AxillaryArtery;
import biomight.system.vascular.arteries.chest.BrachioCephalicArtery;
import biomight.system.vascular.arteries.chest.BronchialArteries;
import biomight.system.vascular.arteries.chest.BronchialArtery;
import biomight.system.vascular.arteries.chest.ConusArtery;
import biomight.system.vascular.arteries.chest.CoronaryArteries;
import biomight.system.vascular.arteries.chest.CoronaryArtery;
import biomight.system.vascular.arteries.chest.DescendingAortaArtery;
import biomight.system.vascular.arteries.chest.InferiorAlveolarArtery;
import biomight.system.vascular.arteries.chest.LeftCoronaryArtery;
import biomight.system.vascular.arteries.chest.ObtuseMarginalArtery;
import biomight.system.vascular.arteries.chest.PulmonaryArteries;
import biomight.system.vascular.arteries.chest.PulmonaryArtery;
import biomight.system.vascular.arteries.chest.RightCoronaryArtery;
import biomight.system.vascular.arteries.chest.SubclavianArteries;
import biomight.system.vascular.arteries.chest.SubclavianArtery;
import biomight.system.vascular.arteries.chest.ThoracicArteries;
import biomight.system.vascular.arteries.chest.ThoracicArtery;
import biomight.system.vascular.arteries.head.AngularArteries;
import biomight.system.vascular.arteries.head.AngularArtery;
import biomight.system.vascular.arteries.head.AnteriorInferiorCerebellarArteries;
import biomight.system.vascular.arteries.head.AnteriorInferiorCerebellarArtery;
import biomight.system.vascular.arteries.head.AnteriorSpinalArteries;
import biomight.system.vascular.arteries.head.AnteriorSpinalArtery;
import biomight.system.vascular.arteries.head.BasilarArteries;
import biomight.system.vascular.arteries.head.BasilarArtery;
import biomight.system.vascular.arteries.head.BuccalArteries;
import biomight.system.vascular.arteries.head.CerebellarArteries;
import biomight.system.vascular.arteries.head.CerebellarArtery;
import biomight.system.vascular.arteries.head.CerebralArteries;
import biomight.system.vascular.arteries.head.CerebralArtery;
import biomight.system.vascular.arteries.head.CiliaryArteries;
import biomight.system.vascular.arteries.head.CiliaryArtery;
import biomight.system.vascular.arteries.head.ConjunctivalArteries;
import biomight.system.vascular.arteries.head.ConjunctivalArtery;
import biomight.system.vascular.arteries.head.DorsalNasalArteries;
import biomight.system.vascular.arteries.head.DorsalNasalArtery;
import biomight.system.vascular.arteries.head.ExternalCarotidArteries;
import biomight.system.vascular.arteries.head.ExternalCarotidArtery;
import biomight.system.vascular.arteries.head.ExternalMaxillaryArteries;
import biomight.system.vascular.arteries.head.ExternalMaxillaryArtery;
import biomight.system.vascular.arteries.head.FacialArteries;
import biomight.system.vascular.arteries.head.FacialArtery;
import biomight.system.vascular.arteries.head.FrontalArteries;
import biomight.system.vascular.arteries.head.FrontalArtery;
import biomight.system.vascular.arteries.head.HypophysealArtery;
import biomight.system.vascular.arteries.head.InfraOrbitalArteries;
import biomight.system.vascular.arteries.head.InfraOrbitalArtery;
import biomight.system.vascular.arteries.head.InternalCarotidArteries;
import biomight.system.vascular.arteries.head.InternalCarotidArtery;
import biomight.system.vascular.arteries.head.InternalMaxillaryArteries;
import biomight.system.vascular.arteries.head.InternalMaxillaryArtery;
import biomight.system.vascular.arteries.head.LacrimalArteries;
import biomight.system.vascular.arteries.head.LacrimalArtery;
import biomight.system.vascular.arteries.head.LingualArteries;
import biomight.system.vascular.arteries.head.LingualArtery;
import biomight.system.vascular.arteries.head.MedialPalpebralArteries;
import biomight.system.vascular.arteries.head.MedialPalpebralArtery;
import biomight.system.vascular.arteries.head.MentalArteries;
import biomight.system.vascular.arteries.head.MentalArtery;
import biomight.system.vascular.arteries.head.OccipitalArteries;
import biomight.system.vascular.arteries.head.OccipitalArtery;
import biomight.system.vascular.arteries.head.OphthalmicArteries;
import biomight.system.vascular.arteries.head.OphthalmicArtery;
import biomight.system.vascular.arteries.head.PalatineArteries;
import biomight.system.vascular.arteries.head.PalatineArtery;
import biomight.system.vascular.arteries.head.PosteriorInferiorCerebellarArteries;
import biomight.system.vascular.arteries.head.PosteriorInferiorCerebellarArtery;
import biomight.system.vascular.arteries.head.RanineArteries;
import biomight.system.vascular.arteries.head.RanineArtery;
import biomight.system.vascular.arteries.head.StylomastoidArteries;
import biomight.system.vascular.arteries.head.StylomastoidArtery;
import biomight.system.vascular.arteries.head.SuperficialTemporalArteries;
import biomight.system.vascular.arteries.head.SuperficialTemporalArtery;
import biomight.system.vascular.arteries.head.SuperiorCerebellarArteries;
import biomight.system.vascular.arteries.head.SuperiorCerebellarArtery;
import biomight.system.vascular.arteries.head.SupraOrbitalArteries;
import biomight.system.vascular.arteries.head.SupraOrbitalArtery;
import biomight.system.vascular.arteries.head.TransverseFacialArteries;
import biomight.system.vascular.arteries.head.TransverseFacialArtery;
import biomight.system.vascular.arteries.leg.AnteriorTibialArtery;
import biomight.system.vascular.arteries.leg.ArcuateArtery;
import biomight.system.vascular.arteries.leg.PeronealArtery;
import biomight.system.vascular.arteries.leg.PoplitealArtery;
import biomight.system.vascular.arteries.leg.PosteriorTibialArtery;
import biomight.system.vascular.arteries.leg.SuperficialFemoralArtery;
import biomight.system.vascular.veins.Veins;
import biomight.system.vascular.veins.abdomen.ColicVein;
import biomight.system.vascular.veins.abdomen.ColicVeins;
import biomight.system.vascular.veins.abdomen.CysticVein;
import biomight.system.vascular.veins.abdomen.GastroEpiploicVein;
import biomight.system.vascular.veins.abdomen.GastroEpiploicVeins;
import biomight.system.vascular.veins.abdomen.HemiazygosVein;
import biomight.system.vascular.veins.abdomen.HepaticPortalVein;
import biomight.system.vascular.veins.abdomen.HepaticVein;
import biomight.system.vascular.veins.abdomen.IleocolicVein;
import biomight.system.vascular.veins.abdomen.IliolumbarVein;
import biomight.system.vascular.veins.abdomen.InferiorEpigastricVein;
import biomight.system.vascular.veins.abdomen.InferiorEpigastricVeins;
import biomight.system.vascular.veins.abdomen.LiverCentralVein;
import biomight.system.vascular.veins.abdomen.LiverCentralVeins;
import biomight.system.vascular.veins.abdomen.OvarianVein;
import biomight.system.vascular.veins.abdomen.PancreaticoDuodenalVein;
import biomight.system.vascular.veins.abdomen.PancreaticoDuodenalVeins;
import biomight.system.vascular.veins.abdomen.RenalVein;
import biomight.system.vascular.veins.abdomen.RenalVeins;
import biomight.system.vascular.veins.abdomen.RetroperitonealVein;
import biomight.system.vascular.veins.abdomen.RetroperitonealVeins;
import biomight.system.vascular.veins.abdomen.SuperiorEpigastricVein;
import biomight.system.vascular.veins.abdomen.SuperiorEpigastricVeins;
import biomight.system.vascular.veins.abdomen.TrabecularVein;
import biomight.system.vascular.veins.abdomen.TrabecularVeins;
import biomight.system.vascular.veins.arm.AccessoryCephalicVein;
import biomight.system.vascular.veins.arm.BasilicVein;
import biomight.system.vascular.veins.arm.BrachialVein;
import biomight.system.vascular.veins.arm.CephalicVein;
import biomight.system.vascular.veins.chest.GreatCardiacVein;
import biomight.system.vascular.veins.chest.InferiorVenaCava;
import biomight.system.vascular.veins.chest.PulmonaryVein;
import biomight.system.vascular.veins.chest.PulmonaryVeins;
import biomight.system.vascular.veins.chest.SmallCardiacVein;
import biomight.system.vascular.veins.chest.SubclavianVein;
import biomight.system.vascular.veins.chest.SubclavianVeins;
import biomight.system.vascular.veins.chest.SuperiorVenaCava;
import biomight.system.vascular.veins.foot.DorsalMetatarsalVein;
import biomight.system.vascular.veins.foot.DorsalMetatarsalVeins;
import biomight.system.vascular.veins.foot.IntercapitularVein;
import biomight.system.vascular.veins.foot.LateralMarginalVein;
import biomight.system.vascular.veins.foot.LateralPlantarVein;
import biomight.system.vascular.veins.foot.MedialMarginalVein;
import biomight.system.vascular.veins.foot.MedialPlantarVein;
import biomight.system.vascular.veins.foot.PlantarMetatarsalVein;
import biomight.system.vascular.veins.foot.PlantarMetatarsalVeins;
import biomight.system.vascular.veins.foot.PlantarVenousArch;
import biomight.system.vascular.veins.foot.SuperficialPalmarArch;
import biomight.system.vascular.veins.hand.PalmarDigitalVein;
import biomight.system.vascular.veins.hand.PalmarDigitalVeins;
import biomight.system.vascular.veins.leg.AnteriorTibialVein;
import biomight.system.vascular.veins.leg.DeepFemoralVein;
import biomight.system.vascular.veins.leg.DorsalisPedisVein;
import biomight.system.vascular.veins.leg.FemoralVein;
import biomight.system.vascular.veins.leg.GreatSaphenousVein;
import biomight.system.vascular.veins.leg.LateralCircumflexFemoralVein;
import biomight.system.vascular.veins.leg.PeronealVein;
import biomight.system.vascular.veins.leg.PoplitealVein;
import biomight.system.vascular.veins.leg.PosteriorTibialVein;
import biomight.system.vascular.veins.leg.SmallSaphenousVein;
import biomight.system.vascular.veins.neck.InnominateVein;
import biomight.system.vascular.veins.neck.InnominateVeins;
import biomightweb.view.BioMightComponent;

/**
 * Maps BioMight Vascular Components into the associated Java class.
 * 
 * SurferJim
 * 
 */

public class BioMightViewVascular {

	
	public void BioMightViewVacular() {
		
	}
	
	public BioMightComponent mapComponent(BioMightComponent bioMightComponent, Object bioMightInstance, boolean snippet) {

		BioMightKeys bioMightKeys = bioMightComponent.getBioMightKeys();
		String bioMightComponentRef = bioMightComponent.getBioMightComponentRef();
		String bioMightComponentName = bioMightComponent.getBioMightComponentName();
		BioMightKey bioMightKey = new BioMightKey();
		boolean executeMethods = false;
	
		
		if (bioMightComponentRef.equals(Constants.Arteries))
		{
			Arteries arteries = (Arteries) bioMightInstance;
			bioMightComponent.setImage(arteries.getImage());
			bioMightComponent.setWidth(arteries.getImageWidth());
			bioMightComponent.setHeight(arteries.getImageHeight());
			bioMightComponent.setBioMightProperties(arteries.getProperties());
			bioMightComponent.setBioMightMethods(arteries.getMethods());
			bioMightComponent.setBioMightCollection(false);	
			
			
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for Arteries: "  + bioMightComponentName +  "     ID: " + arteries.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(arteries.getComponentID());
			bioMightKeys.setKey(bioMightKey);
				
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing Arteries Methods!");
			//	arteries(methodParams);
			//	arteries.redraw(0);
			//}
			bioMightComponent.setX3D(arteries.getX3D(snippet));			
		}			
		else if (bioMightComponentRef.equals(Constants.Veins))
		{
			Veins veins = (Veins) bioMightInstance;
			bioMightComponent.setImage(veins.getImage());
			bioMightComponent.setWidth(veins.getImageWidth());
			bioMightComponent.setHeight(veins.getImageHeight());
			bioMightComponent.setBioMightProperties(veins.getProperties());
			bioMightComponent.setBioMightMethods(veins.getMethods());
			bioMightComponent.setBioMightCollection(false);	
			
			
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for veins: "  + bioMightComponent +  "     ID: " + veins.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(veins.getComponentID());
			bioMightKeys.setKey(bioMightKey);
				
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing Veins Methods!");
			//	veins(methodParams);
			//	veins.redraw(0);
			//}
			bioMightComponent.setX3D(veins.getX3D(snippet));			
		}		
		/**************************************************************************
		*
		* VASCULATURE OF THEE HEAD 
		*
		* This section maps the data in the biomight object into the presentation 
		* layer.  
		*  
		***************************************************************************/
		
		
		else if (bioMightComponentRef.equals(Constants.AngularArteries))
		{
			AngularArteries angularArteries = (AngularArteries) bioMightInstance;
			bioMightComponent.setImage(angularArteries.getImage());
			bioMightComponent.setWidth(angularArteries.getImageWidth());
			bioMightComponent.setHeight(angularArteries.getImageHeight());
			bioMightComponent.setBioMightProperties(angularArteries.getProperties());
			bioMightComponent.setBioMightMethods(angularArteries.getMethods());
			bioMightComponent.setBioMightCollection(true);	
			
			
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for angularArteries: "  + bioMightComponent +  "     ID: " + angularArteries.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(angularArteries.getComponentID());
			bioMightKeys.setKey(bioMightKey);
				
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing AngularArteries Methods!");
			//	angularArteries(methodParams);
			//	angularArteries.redraw(0);
			//}
			System.out.println("Getting X3D for angularArteries!");
			bioMightComponent.setX3D(angularArteries.getX3D(snippet));			
		}			
		else if (bioMightComponentRef.equals(Constants.AngularArtery))
		{
			AngularArtery angularArtery = (AngularArtery) bioMightInstance;
			bioMightComponent.setImage(angularArtery.getImage());
			bioMightComponent.setWidth(angularArtery.getImageWidth());
			bioMightComponent.setHeight(angularArtery.getImageHeight());
			bioMightComponent.setBioMightProperties(angularArtery.getProperties());
			bioMightComponent.setBioMightMethods(angularArtery.getMethods());
				
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for angularArtery: "  + bioMightComponent +  "     ID: " + angularArtery.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(angularArtery.getComponentID());
			bioMightKeys.setKey(bioMightKey);
				
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing AngularArtery Methods!");
			//	angularArtery(methodParams);
			//	angularArtery(0);
			//}
			System.out.println("Getting X3D for angularArtery!");
			bioMightComponent.setX3D(angularArtery.getX3D(snippet));			
		}
		else if (bioMightComponentRef.equals(Constants.BasilarArteries))
		{
			BasilarArteries basilarArteries = (BasilarArteries) bioMightInstance;
			bioMightComponent.setImage(basilarArteries.getImage());
			bioMightComponent.setWidth(basilarArteries.getImageWidth());
			bioMightComponent.setHeight(basilarArteries.getImageHeight());
			bioMightComponent.setBioMightProperties(basilarArteries.getProperties());
			bioMightComponent.setBioMightMethods(basilarArteries.getMethods());
			bioMightComponent.setBioMightCollection(true);
			
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for BasilarArteries: "  + bioMightComponent +  "     ID: " + basilarArteries.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(basilarArteries.getComponentID());
			bioMightKeys.setKey(bioMightKey);
				
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing BasilarArteries Methods!");
			//	angularArtery(methodParams);
			//	angularArtery(0);
			//}
			System.out.println("Getting X3D for BasilarArteries!");
			bioMightComponent.setX3D(basilarArteries.getX3D(snippet));			
		}	
		else if (bioMightComponentRef.equals(Constants.BasilarArtery))
		{
			BasilarArtery basilarArtery = (BasilarArtery) bioMightInstance;
			bioMightComponent.setImage(basilarArtery.getImage());
			bioMightComponent.setWidth(basilarArtery.getImageWidth());
			bioMightComponent.setHeight(basilarArtery.getImageHeight());
			bioMightComponent.setBioMightProperties(basilarArtery.getProperties());
			bioMightComponent.setBioMightMethods(basilarArtery.getMethods());
				
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for BasilarArtery: "  + bioMightComponent +  "     ID: " + basilarArtery.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(basilarArtery.getComponentID());
			bioMightKeys.setKey(bioMightKey);
				
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing BasilarArteries Methods!");
			//	angularArtery(methodParams);
			//	angularArtery(0);
			//}
			System.out.println("Getting X3D for BasilarArtery!");
			bioMightComponent.setX3D(basilarArtery.getX3D(snippet));			
		}	
		else if (bioMightComponentRef.equals(Constants.BuccalArteries))
		{
			BuccalArteries  buccalArteries = (BuccalArteries) bioMightInstance;
			bioMightComponent.setImage(buccalArteries.getImage());
			bioMightComponent.setWidth(buccalArteries.getImageWidth());
			bioMightComponent.setHeight(buccalArteries.getImageHeight());
			bioMightComponent.setBioMightProperties(buccalArteries.getProperties());
			bioMightComponent.setBioMightMethods(buccalArteries.getMethods());
			bioMightComponent.setBioMightCollection(true);
			
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for BuccalArteries: "  + bioMightComponent +  "     ID: " + buccalArteries.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(buccalArteries.getComponentID());
			bioMightKeys.setKey(bioMightKey);
				
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing BuccalArteries Methods!");
			//	angularArtery(methodParams);
			//	angularArtery(0);
			//}
			System.out.println("Getting X3D for BuccalArteries!");
			bioMightComponent.setX3D(buccalArteries.getX3D(snippet));			
		}	
		else if (bioMightComponentRef.equals(Constants.BuccalArtery))
		{
			BasilarArtery basilarArtery = (BasilarArtery) bioMightInstance;
			bioMightComponent.setImage(basilarArtery.getImage());
			bioMightComponent.setWidth(basilarArtery.getImageWidth());
			bioMightComponent.setHeight(basilarArtery.getImageHeight());
			bioMightComponent.setBioMightProperties(basilarArtery.getProperties());
			bioMightComponent.setBioMightMethods(basilarArtery.getMethods());
				
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for BuccalArtery: "  + bioMightComponent +  "     ID: " + basilarArtery.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(basilarArtery.getComponentID());
			bioMightKeys.setKey(bioMightKey);
				
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing BuccalArtery Methods!");
			//	angularArtery(methodParams);
			//	angularArtery(0);
			//}
			System.out.println("Getting X3D for BuccalArtery!");
			bioMightComponent.setX3D(basilarArtery.getX3D(snippet));			
		}	
		else if (bioMightComponentRef.equals(Constants.FacialArteries))
		{
			FacialArteries  facialArteries = (FacialArteries) bioMightInstance;
			bioMightComponent.setImage(facialArteries.getImage());
			bioMightComponent.setWidth(facialArteries.getImageWidth());
			bioMightComponent.setHeight(facialArteries.getImageHeight());
			bioMightComponent.setBioMightProperties(facialArteries.getProperties());
			bioMightComponent.setBioMightMethods(facialArteries.getMethods());
			bioMightComponent.setBioMightCollection(true);
			
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for FacialArteries: "  + bioMightComponent +  "     ID: " + facialArteries.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(facialArteries.getComponentID());
			bioMightKeys.setKey(bioMightKey);
				
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing facialArteries Methods!");
			//	angularArtery(methodParams);
			//	angularArtery(0);
			//}
			System.out.println("Getting X3D for facialArteries!");
			bioMightComponent.setX3D(facialArteries.getX3D(snippet));			
		}	
		else if (bioMightComponentRef.equals(Constants.FacialArtery))
		{
			FacialArtery  facialArtery = (FacialArtery) bioMightInstance;
			bioMightComponent.setImage(facialArtery.getImage());
			bioMightComponent.setWidth(facialArtery.getImageWidth());
			bioMightComponent.setHeight(facialArtery.getImageHeight());
			bioMightComponent.setBioMightProperties(facialArtery.getProperties());
			bioMightComponent.setBioMightMethods(facialArtery.getMethods());
			
			
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for FacialArtery: "  + bioMightComponent +  "     ID: " + facialArtery.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(facialArtery.getComponentID());
			bioMightKeys.setKey(bioMightKey);
				
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing FacialArtery Methods!");
			//	angularArtery(methodParams);
			//	angularArtery(0);
			//}
			System.out.println("Getting X3D for FacialArtery!");
			bioMightComponent.setX3D(facialArtery.getX3D(snippet));			
		}	
		else if (bioMightComponentRef.equals(Constants.InferiorSupraRenalArtery))
		{
			InferiorSupraRenalArtery  inferiorSupraRenalArtery = (InferiorSupraRenalArtery) bioMightInstance;
			bioMightComponent.setImage(inferiorSupraRenalArtery.getImage());
			bioMightComponent.setWidth(inferiorSupraRenalArtery.getImageWidth());
			bioMightComponent.setHeight(inferiorSupraRenalArtery.getImageHeight());
			bioMightComponent.setBioMightProperties(inferiorSupraRenalArtery.getProperties());
			bioMightComponent.setBioMightMethods(inferiorSupraRenalArtery.getMethods());
			
			
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for InferiorSupraRenalArtery: "  + bioMightComponent +  "     ID: " + inferiorSupraRenalArtery.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(inferiorSupraRenalArtery.getComponentID());
			bioMightKeys.setKey(bioMightKey);
				
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing InferiorSupraRenalArtery Methods!");
			//	inferiorSupraRenalArtery(methodParams);
			//	inferiorSupraRenalArtery(0);
			//}
			System.out.println("Getting X3D for InferiorSupraRenalArtery!");
			bioMightComponent.setX3D(inferiorSupraRenalArtery.getX3D(snippet));			
		}	
		else if (bioMightComponentRef.equals(Constants.MiddleSupraRenalArtery))
		{
			MiddleSupraRenalArtery  middleSupraRenalArtery = (MiddleSupraRenalArtery) bioMightInstance;
			bioMightComponent.setImage(middleSupraRenalArtery.getImage());
			bioMightComponent.setWidth(middleSupraRenalArtery.getImageWidth());
			bioMightComponent.setHeight(middleSupraRenalArtery.getImageHeight());
			bioMightComponent.setBioMightProperties(middleSupraRenalArtery.getProperties());
			bioMightComponent.setBioMightMethods(middleSupraRenalArtery.getMethods());
			
			
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for MiddleSupraRenalArtery: "  + bioMightComponent +  "     ID: " + middleSupraRenalArtery.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(middleSupraRenalArtery.getComponentID());
			bioMightKeys.setKey(bioMightKey);
				
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing MiddleSupraRenalArtery Methods!");
			//	middleSupraRenalArtery(methodParams);
			//	middleSupraRenalArtery(0);
			//}
			System.out.println("Getting X3D for MiddleSupraRenalArtery!");
			bioMightComponent.setX3D(middleSupraRenalArtery.getX3D(snippet));			
		}
		else if (bioMightComponentRef.equals(Constants.SuperiorSupraRenalArtery))
		{
			SuperiorSupraRenalArtery  superiorSupraRenalArtery = (SuperiorSupraRenalArtery) bioMightInstance;
			bioMightComponent.setImage(superiorSupraRenalArtery.getImage());
			bioMightComponent.setWidth(superiorSupraRenalArtery.getImageWidth());
			bioMightComponent.setHeight(superiorSupraRenalArtery.getImageHeight());
			bioMightComponent.setBioMightProperties(superiorSupraRenalArtery.getProperties());
			bioMightComponent.setBioMightMethods(superiorSupraRenalArtery.getMethods());
			
			
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for SuperiorSupraRenalArtery: "  + bioMightComponent +  "     ID: " + superiorSupraRenalArtery.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(superiorSupraRenalArtery.getComponentID());
			bioMightKeys.setKey(bioMightKey);
				
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing SuperiorSupraRenalArtery Methods!");
			//	superiorSupraRenalArtery(methodParams);
			//	superiorSupraRenalArtery(0);
			//}
			System.out.println("Getting X3D for SuperiorSupraRenalArtery!");
			bioMightComponent.setX3D(superiorSupraRenalArtery.getX3D(snippet));			
		}		
		
		else if (bioMightComponentRef.equals(Constants.TransverseFacialArteries))
		{
			TransverseFacialArteries  transverseFacialArteries = (TransverseFacialArteries) bioMightInstance;
			bioMightComponent.setImage(transverseFacialArteries.getImage());
			bioMightComponent.setWidth(transverseFacialArteries.getImageWidth());
			bioMightComponent.setHeight(transverseFacialArteries.getImageHeight());
			bioMightComponent.setBioMightProperties(transverseFacialArteries.getProperties());
			bioMightComponent.setBioMightMethods(transverseFacialArteries.getMethods());
			bioMightComponent.setBioMightCollection(true);
			
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for TransverseFacialArteries: "  + bioMightComponent +  "     ID: " + transverseFacialArteries.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(transverseFacialArteries.getComponentID());
			bioMightKeys.setKey(bioMightKey);
				
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing transverseFacialArteries Methods!");
			//	angularArtery(methodParams);
			//	angularArtery(0);
			//}
			System.out.println("Getting X3D for TransverseFacialArteries!");
			bioMightComponent.setX3D(transverseFacialArteries.getX3D(snippet));			
		}	
		else if (bioMightComponentRef.equals(Constants.TransverseFacialArtery))
		{
			TransverseFacialArtery  transverseFacialArtery = (TransverseFacialArtery) bioMightInstance;
			bioMightComponent.setImage(transverseFacialArtery.getImage());
			bioMightComponent.setWidth(transverseFacialArtery.getImageWidth());
			bioMightComponent.setHeight(transverseFacialArtery.getImageHeight());
			bioMightComponent.setBioMightProperties(transverseFacialArtery.getProperties());
			bioMightComponent.setBioMightMethods(transverseFacialArtery.getMethods());
			
			
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for TransverseFacialArtery: "  + bioMightComponent +  "     ID: " + transverseFacialArtery.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(transverseFacialArtery.getComponentID());
			bioMightKeys.setKey(bioMightKey);
				
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing TransverseFacialArtery Methods!");
			//	angularArtery(methodParams);
			//	angularArtery(0);
			//}
			System.out.println("Getting X3D for TransverseFacialArtery!");
			bioMightComponent.setX3D(transverseFacialArtery.getX3D(snippet));			
		}	
		
		else if (bioMightComponentRef.equals(Constants.DorsalNasalArteries))
		{
			DorsalNasalArteries  dorsalNasalArteries = (DorsalNasalArteries) bioMightInstance;
			bioMightComponent.setImage(dorsalNasalArteries.getImage());
			bioMightComponent.setWidth(dorsalNasalArteries.getImageWidth());
			bioMightComponent.setHeight(dorsalNasalArteries.getImageHeight());
			bioMightComponent.setBioMightProperties(dorsalNasalArteries.getProperties());
			bioMightComponent.setBioMightMethods(dorsalNasalArteries.getMethods());
			bioMightComponent.setBioMightCollection(true);
			
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for DorsalNasalArteries: "  + bioMightComponent +  "     ID: " + dorsalNasalArteries.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(dorsalNasalArteries.getComponentID());
			bioMightKeys.setKey(bioMightKey);
				
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing facialArteries Methods!");
			//	angularArtery(methodParams);
			//	angularArtery(0);
			//}
			//System.out.println("Getting X3D for DorsalNasalArteries!");
			bioMightComponent.setX3D(dorsalNasalArteries.getX3D(snippet));			
		}	
		else if (bioMightComponentRef.equals(Constants.DorsalNasalArtery))
		{
			DorsalNasalArtery  dorsalNasalArtery = (DorsalNasalArtery) bioMightInstance;
			bioMightComponent.setImage(dorsalNasalArtery.getImage());
			bioMightComponent.setWidth(dorsalNasalArtery.getImageWidth());
			bioMightComponent.setHeight(dorsalNasalArtery.getImageHeight());
			bioMightComponent.setBioMightProperties(dorsalNasalArtery.getProperties());
			bioMightComponent.setBioMightMethods(dorsalNasalArtery.getMethods());
		
			
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for DorsalNasalArtery: "  + bioMightComponent +  "     ID: " + dorsalNasalArtery.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(dorsalNasalArtery.getComponentID());
			bioMightKeys.setKey(bioMightKey);
				
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing DorsalNasalArtery Methods!");
			//	angularArtery(methodParams);
			//	angularArtery(0);
			//}
			//System.out.println("Getting X3D for DorsalNasalArtery!");
			bioMightComponent.setX3D(dorsalNasalArtery.getX3D(snippet));			
		}	
		else if (bioMightComponentRef.equals(Constants.DorsalNasalArtery))
		{
			DorsalNasalArtery  dorsalNasalArtery = (DorsalNasalArtery) bioMightInstance;
			bioMightComponent.setImage(dorsalNasalArtery.getImage());
			bioMightComponent.setWidth(dorsalNasalArtery.getImageWidth());
			bioMightComponent.setHeight(dorsalNasalArtery.getImageHeight());
			bioMightComponent.setBioMightProperties(dorsalNasalArtery.getProperties());
			bioMightComponent.setBioMightMethods(dorsalNasalArtery.getMethods());
		
			
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for DorsalNasalArtery: "  + bioMightComponent +  "     ID: " + dorsalNasalArtery.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(dorsalNasalArtery.getComponentID());
			bioMightKeys.setKey(bioMightKey);
				
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing DorsalNasalArtery Methods!");
			//	angularArtery(methodParams);
			//	angularArtery(0);
			//}
			//System.out.println("Getting X3D for DorsalNasalArtery!");
			bioMightComponent.setX3D(dorsalNasalArtery.getX3D(snippet));			
		}	
		else if (bioMightComponentRef.equals(Constants.LacrimalArteries))
		{
			LacrimalArteries  lacrimalArteries = (LacrimalArteries) bioMightInstance;
			bioMightComponent.setImage(lacrimalArteries.getImage());
			bioMightComponent.setWidth(lacrimalArteries.getImageWidth());
			bioMightComponent.setHeight(lacrimalArteries.getImageHeight());
			bioMightComponent.setBioMightProperties(lacrimalArteries.getProperties());
			bioMightComponent.setBioMightMethods(lacrimalArteries.getMethods());
			bioMightComponent.setBioMightCollection(true);
			
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for LacrimalArteries: "  + bioMightComponent +  "     ID: " + lacrimalArteries.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(lacrimalArteries.getComponentID());
			bioMightKeys.setKey(bioMightKey);
				
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing lacrimalArteries Methods!");
			//	angularArtery(methodParams);
			//	angularArtery(0);
			//}
			//System.out.println("Getting X3D for LacrimalArteries!");
			bioMightComponent.setX3D(lacrimalArteries.getX3D(snippet));			
		}	
		else if (bioMightComponentRef.equals(Constants.LacrimalArtery))
		{
			LacrimalArtery  lacrimalArtery = (LacrimalArtery) bioMightInstance;
			bioMightComponent.setImage(lacrimalArtery.getImage());
			bioMightComponent.setWidth(lacrimalArtery.getImageWidth());
			bioMightComponent.setHeight(lacrimalArtery.getImageHeight());
			bioMightComponent.setBioMightProperties(lacrimalArtery.getProperties());
			bioMightComponent.setBioMightMethods(lacrimalArtery.getMethods());
		
			
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for LacrimalArtery: "  + bioMightComponent +  "     ID: " + lacrimalArtery.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(lacrimalArtery.getComponentID());
			bioMightKeys.setKey(bioMightKey);
				
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing LacrimalArtery Methods!");
			//	angularArtery(methodParams);
			//	angularArtery(0);
			//}
			//System.out.println("Getting X3D for DorsalNasalArtery!");
			bioMightComponent.setX3D(lacrimalArtery.getX3D(snippet));			
		}
		else if (bioMightComponentRef.equals(Constants.OphthalmicArteries))
		{
			OphthalmicArteries  ophthalmicArteries = (OphthalmicArteries) bioMightInstance;
			bioMightComponent.setImage(ophthalmicArteries.getImage());
			bioMightComponent.setWidth(ophthalmicArteries.getImageWidth());
			bioMightComponent.setHeight(ophthalmicArteries.getImageHeight());
			bioMightComponent.setBioMightProperties(ophthalmicArteries.getProperties());
			bioMightComponent.setBioMightMethods(ophthalmicArteries.getMethods());
			bioMightComponent.setBioMightCollection(true);
			
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for OphthalmicArteries: "  + bioMightComponent +  "     ID: " + ophthalmicArteries.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(ophthalmicArteries.getComponentID());
			bioMightKeys.setKey(bioMightKey);
				
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing ophthalmicArteries Methods!");
			//	angularArtery(methodParams);
			//	angularArtery(0);
			//}
			//System.out.println("Getting X3D for OphthalmicArteries!");
			bioMightComponent.setX3D(ophthalmicArteries.getX3D(snippet));			
		}	
		else if (bioMightComponentRef.equals(Constants.OphthalmicArtery))
		{
			OphthalmicArtery  ophthalmicArtery = (OphthalmicArtery) bioMightInstance;
			bioMightComponent.setImage(ophthalmicArtery.getImage());
			bioMightComponent.setWidth(ophthalmicArtery.getImageWidth());
			bioMightComponent.setHeight(ophthalmicArtery.getImageHeight());
			bioMightComponent.setBioMightProperties(ophthalmicArtery.getProperties());
			bioMightComponent.setBioMightMethods(ophthalmicArtery.getMethods());
		
			
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for OphthalmicArtery: "  + bioMightComponent +  "     ID: " + ophthalmicArtery.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(ophthalmicArtery.getComponentID());
			bioMightKeys.setKey(bioMightKey);
				
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing LacrimalArtery Methods!");
			//	angularArtery(methodParams);
			//	angularArtery(0);
			//}
			//System.out.println("Getting X3D for OphthalmicArtery!");
			bioMightComponent.setX3D(ophthalmicArtery.getX3D(snippet));			
		}
		else if (bioMightComponentRef.equals(Constants.OccipitalArteries))
		{
			OccipitalArteries  occipitalArteries = (OccipitalArteries) bioMightInstance;
			bioMightComponent.setImage(occipitalArteries.getImage());
			bioMightComponent.setWidth(occipitalArteries.getImageWidth());
			bioMightComponent.setHeight(occipitalArteries.getImageHeight());
			bioMightComponent.setBioMightProperties(occipitalArteries.getProperties());
			bioMightComponent.setBioMightMethods(occipitalArteries.getMethods());
			bioMightComponent.setBioMightCollection(true);
			
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for OccipitalArteries: "  + bioMightComponent +  "     ID: " + occipitalArteries.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(occipitalArteries.getComponentID());
			bioMightKeys.setKey(bioMightKey);
				
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing ophthalmicArteries Methods!");
			//	angularArtery(methodParams);
			//	angularArtery(0);
			//}
			//System.out.println("Getting X3D for OphthalmicArteries!");
			bioMightComponent.setX3D(occipitalArteries.getX3D(snippet));			
		}	
		else if (bioMightComponentRef.equals(Constants.OccipitalArtery))
		{
			OccipitalArtery  occipitalArtery = (OccipitalArtery) bioMightInstance;
			bioMightComponent.setImage(occipitalArtery.getImage());
			bioMightComponent.setWidth(occipitalArtery.getImageWidth());
			bioMightComponent.setHeight(occipitalArtery.getImageHeight());
			bioMightComponent.setBioMightProperties(occipitalArtery.getProperties());
			bioMightComponent.setBioMightMethods(occipitalArtery.getMethods());
			bioMightComponent.setBioMightCollection(true);
			
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for OccipitalArtery: "  + bioMightComponent +  "     ID: " + occipitalArtery.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(occipitalArtery.getComponentID());
			bioMightKeys.setKey(bioMightKey);
				
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing OccipitalArtery Methods!");
			//	angularArtery(methodParams);
			//	angularArtery(0);
			//}
			//System.out.println("Getting X3D for OccipitalArtery!");
			bioMightComponent.setX3D(occipitalArtery.getX3D(snippet));			
		}	
		else if (bioMightComponentRef.equals(Constants.MentalArteries))
		{
			MentalArteries  mentalArteries = (MentalArteries) bioMightInstance;
			bioMightComponent.setImage(mentalArteries.getImage());
			bioMightComponent.setWidth(mentalArteries.getImageWidth());
			bioMightComponent.setHeight(mentalArteries.getImageHeight());
			bioMightComponent.setBioMightProperties(mentalArteries.getProperties());
			bioMightComponent.setBioMightMethods(mentalArteries.getMethods());
			bioMightComponent.setBioMightCollection(true);
			
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for MentalArteries: "  + bioMightComponent +  "     ID: " + mentalArteries.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(mentalArteries.getComponentID());
			bioMightKeys.setKey(bioMightKey);
				
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing MentalArteries Methods!");
			//	angularArtery(methodParams);
			//	angularArtery(0);
			//}
			//System.out.println("Getting X3D for MentalArteries!");
			bioMightComponent.setX3D(mentalArteries.getX3D(snippet));			
		}	
		else if (bioMightComponentRef.equals(Constants.MentalArtery))
		{
			MentalArtery  mentalArtery = (MentalArtery) bioMightInstance;
			bioMightComponent.setImage(mentalArtery.getImage());
			bioMightComponent.setWidth(mentalArtery.getImageWidth());
			bioMightComponent.setHeight(mentalArtery.getImageHeight());
			bioMightComponent.setBioMightProperties(mentalArtery.getProperties());
			bioMightComponent.setBioMightMethods(mentalArtery.getMethods());
			
			
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for MentalArtery: "  + bioMightComponent +  "     ID: " + mentalArtery.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(mentalArtery.getComponentID());
			bioMightKeys.setKey(bioMightKey);
				
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing MentalArtery Methods!");
			//	mentalArtery(methodParams);
			//	mentalArtery(0);
			//}
			//System.out.println("Getting X3D for MentalArtery!");
			bioMightComponent.setX3D(mentalArtery.getX3D(snippet));			
		}	
		else if (bioMightComponentRef.equals(Constants.FrontalArteries))
		{
			FrontalArteries  frontalArteries = (FrontalArteries) bioMightInstance;
			bioMightComponent.setImage(frontalArteries.getImage());
			bioMightComponent.setWidth(frontalArteries.getImageWidth());
			bioMightComponent.setHeight(frontalArteries.getImageHeight());
			bioMightComponent.setBioMightProperties(frontalArteries.getProperties());
			bioMightComponent.setBioMightMethods(frontalArteries.getMethods());
			bioMightComponent.setBioMightCollection(true);
			
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for FrontalArteries: "  + bioMightComponent +  "     ID: " + frontalArteries.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(frontalArteries.getComponentID());
			bioMightKeys.setKey(bioMightKey);
				
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing FrontalArteries Methods!");
			//	angularArtery(methodParams);
			//	angularArtery(0);
			//}
			//System.out.println("Getting X3D for FrontalArteries!");
			bioMightComponent.setX3D(frontalArteries.getX3D(snippet));			
		}	
		else if (bioMightComponentRef.equals(Constants.FrontalArtery))
		{
			FrontalArtery  frontalArtery = (FrontalArtery) bioMightInstance;
			bioMightComponent.setImage(frontalArtery.getImage());
			bioMightComponent.setWidth(frontalArtery.getImageWidth());
			bioMightComponent.setHeight(frontalArtery.getImageHeight());
			bioMightComponent.setBioMightProperties(frontalArtery.getProperties());
			bioMightComponent.setBioMightMethods(frontalArtery.getMethods());
			
			
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for FrontalArtery: "  + bioMightComponent +  "     ID: " + frontalArtery.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(frontalArtery.getComponentID());
			bioMightKeys.setKey(bioMightKey);
				
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing FrontalArtery Methods!");
			//	frontalArtery(methodParams);
			//	frontalArtery(0);
			//}
			//System.out.println("Getting X3D for FrontalArtery!");
			bioMightComponent.setX3D(frontalArtery.getX3D(snippet));			
		}
		else if (bioMightComponentRef.equals(Constants.CerebralArteries))
		{
			CerebralArteries  cerebralArteries = (CerebralArteries) bioMightInstance;
			bioMightComponent.setImage(cerebralArteries.getImage());
			bioMightComponent.setWidth(cerebralArteries.getImageWidth());
			bioMightComponent.setHeight(cerebralArteries.getImageHeight());
			bioMightComponent.setBioMightProperties(cerebralArteries.getProperties());
			bioMightComponent.setBioMightMethods(cerebralArteries.getMethods());
			bioMightComponent.setBioMightCollection(true);
			
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for CerebralArteries: "  + bioMightComponent +  "     ID: " + cerebralArteries.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(cerebralArteries.getComponentID());
			bioMightKeys.setKey(bioMightKey);
				
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing CerebralArteries Methods!");
			//	angularArtery(methodParams);
			//	angularArtery(0);
			//}
			//System.out.println("Getting X3D for CerebralArteries!");
			bioMightComponent.setX3D(cerebralArteries.getX3D(snippet));			
		}	
		else if (bioMightComponentRef.equals(Constants.CerebralArtery))
		{
			CerebralArtery  cerebralArtery = (CerebralArtery) bioMightInstance;
			bioMightComponent.setImage(cerebralArtery.getImage());
			bioMightComponent.setWidth(cerebralArtery.getImageWidth());
			bioMightComponent.setHeight(cerebralArtery.getImageHeight());
			bioMightComponent.setBioMightProperties(cerebralArtery.getProperties());
			bioMightComponent.setBioMightMethods(cerebralArtery.getMethods());
			
			
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for CerebralArtery: "  + bioMightComponent +  "     ID: " + cerebralArtery.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(cerebralArtery.getComponentID());
			bioMightKeys.setKey(bioMightKey);
				
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing cerebralArtery Methods!");
			//	cerebralArtery(methodParams);
			//	cerebralArtery(0);
			//}
			//System.out.println("Getting X3D for CerebralArtery!");
			bioMightComponent.setX3D(cerebralArtery.getX3D(snippet));			
		}			
		else if (bioMightComponentRef.equals(Constants.InternalCarotidArteries))
		{
			InternalCarotidArteries  internalCarotidArteries = (InternalCarotidArteries) bioMightInstance;
			bioMightComponent.setImage(internalCarotidArteries.getImage());
			bioMightComponent.setWidth(internalCarotidArteries.getImageWidth());
			bioMightComponent.setHeight(internalCarotidArteries.getImageHeight());
			bioMightComponent.setBioMightProperties(internalCarotidArteries.getProperties());
			bioMightComponent.setBioMightMethods(internalCarotidArteries.getMethods());
			bioMightComponent.setBioMightCollection(true);
			
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for InternalCarotidArteries: "  + bioMightComponent +  "     ID: " + internalCarotidArteries.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(internalCarotidArteries.getComponentID());
			bioMightKeys.setKey(bioMightKey);
				
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing InternalCarotidArteries Methods!");
			//	angularArtery(methodParams);
			//	angularArtery(0);
			//}
			//System.out.println("Getting X3D for InternalCarotidArteries!");
			bioMightComponent.setX3D(internalCarotidArteries.getX3D(snippet));			
		}	
		else if (bioMightComponentRef.equals(Constants.InternalCarotidArtery))
		{
			InternalCarotidArtery  internalCarotidArtery = (InternalCarotidArtery) bioMightInstance;
			bioMightComponent.setImage(internalCarotidArtery.getImage());
			bioMightComponent.setWidth(internalCarotidArtery.getImageWidth());
			bioMightComponent.setHeight(internalCarotidArtery.getImageHeight());
			bioMightComponent.setBioMightProperties(internalCarotidArtery.getProperties());
			bioMightComponent.setBioMightMethods(internalCarotidArtery.getMethods());
		
			
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for InternalCarotidArtery: "  + bioMightComponent +  "     ID: " + internalCarotidArtery.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(internalCarotidArtery.getComponentID());
			bioMightKeys.setKey(bioMightKey);
				
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing InternalCarotidArteries Methods!");
			//	angularArtery(methodParams);
			//	angularArtery(0);
			//}
			//System.out.println("Getting X3D for InternalCarotidArtery!");
			bioMightComponent.setX3D(internalCarotidArtery.getX3D(snippet));			
		}
		else if (bioMightComponentRef.equals(Constants.ExternalCarotidArteries))
		{
			ExternalCarotidArteries  externalCarotidArteries = (ExternalCarotidArteries) bioMightInstance;
			bioMightComponent.setImage(externalCarotidArteries.getImage());
			bioMightComponent.setWidth(externalCarotidArteries.getImageWidth());
			bioMightComponent.setHeight(externalCarotidArteries.getImageHeight());
			bioMightComponent.setBioMightProperties(externalCarotidArteries.getProperties());
			bioMightComponent.setBioMightMethods(externalCarotidArteries.getMethods());
			bioMightComponent.setBioMightCollection(true);
			
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for ExternalCarotidArteries: "  + bioMightComponent +  "     ID: " + externalCarotidArteries.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(externalCarotidArteries.getComponentID());
			bioMightKeys.setKey(bioMightKey);
				
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing ExternalCarotidArteries Methods!");
			//	angularArtery(methodParams);
			//	angularArtery(0);
			//}
			//System.out.println("Getting X3D for ExternalCarotidArteries!");
			bioMightComponent.setX3D(externalCarotidArteries.getX3D(snippet));			
		}
		else if (bioMightComponentRef.equals(Constants.ExternalCarotidArtery))
		{
			ExternalCarotidArtery  externalCarotidArtery = (ExternalCarotidArtery) bioMightInstance;
			bioMightComponent.setImage(externalCarotidArtery.getImage());
			bioMightComponent.setWidth(externalCarotidArtery.getImageWidth());
			bioMightComponent.setHeight(externalCarotidArtery.getImageHeight());
			bioMightComponent.setBioMightProperties(externalCarotidArtery.getProperties());
			bioMightComponent.setBioMightMethods(externalCarotidArtery.getMethods());
			//bioMightComponent.setBioMightCollection(true);
			
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for ExternalCarotidArtery: "  + bioMightComponent +  "     ID: " + externalCarotidArtery.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(externalCarotidArtery.getComponentID());
			bioMightKeys.setKey(bioMightKey);
				
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing ExternalCarotidArtery Methods!");
			//	angularArtery(methodParams);
			//	angularArtery(0);
			//}
			//System.out.println("Getting X3D for ExternalCarotidArteries!");
			bioMightComponent.setX3D(externalCarotidArtery.getX3D(snippet));			
		}			
		else if (bioMightComponentRef.equals(Constants.RanineArteries))
		{
			RanineArteries  ranineArteries = (RanineArteries) bioMightInstance;
			bioMightComponent.setImage(ranineArteries.getImage());
			bioMightComponent.setWidth(ranineArteries.getImageWidth());
			bioMightComponent.setHeight(ranineArteries.getImageHeight());
			bioMightComponent.setBioMightProperties(ranineArteries.getProperties());
			bioMightComponent.setBioMightMethods(ranineArteries.getMethods());
			bioMightComponent.setBioMightCollection(true);
			
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for RanineArteries: "  + bioMightComponent +  "     ID: " + ranineArteries.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(ranineArteries.getComponentID());
			bioMightKeys.setKey(bioMightKey);
				
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing RanineArteries Methods!");
			//	ranineArteries(methodParams);
			//	ranineArteries(0);
			//}
			//System.out.println("Getting X3D for RanineArteries!");
			bioMightComponent.setX3D(ranineArteries.getX3D(snippet));			
		}	
		else if (bioMightComponentRef.equals(Constants.RanineArtery))
		{
			RanineArtery  ranineArtery = (RanineArtery) bioMightInstance;
			bioMightComponent.setImage(ranineArtery.getImage());
			bioMightComponent.setWidth(ranineArtery.getImageWidth());
			bioMightComponent.setHeight(ranineArtery.getImageHeight());
			bioMightComponent.setBioMightProperties(ranineArtery.getProperties());
			bioMightComponent.setBioMightMethods(ranineArtery.getMethods());
			bioMightComponent.setBioMightCollection(true);
			
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for RanineArtery: "  + bioMightComponent +  "     ID: " + ranineArtery.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(ranineArtery.getComponentID());
			bioMightKeys.setKey(bioMightKey);
				
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing RanineArtery Methods!");
			//	ranineArteries(methodParams);
			//	ranineArteries(0);
			//}
			//System.out.println("Getting X3D for RanineArtery!");
			bioMightComponent.setX3D(ranineArtery.getX3D(snippet));			
		}	
		else if (bioMightComponentRef.equals(Constants.StylomastoidArteries))
		{
			StylomastoidArteries  stylomastoidArteries = (StylomastoidArteries) bioMightInstance;
			bioMightComponent.setImage(stylomastoidArteries.getImage());
			bioMightComponent.setWidth(stylomastoidArteries.getImageWidth());
			bioMightComponent.setHeight(stylomastoidArteries.getImageHeight());
			bioMightComponent.setBioMightProperties(stylomastoidArteries.getProperties());
			bioMightComponent.setBioMightMethods(stylomastoidArteries.getMethods());
			bioMightComponent.setBioMightCollection(true);
			
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for StylomastoidArteries: "  + bioMightComponent +  "     ID: " + stylomastoidArteries.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(stylomastoidArteries.getComponentID());
			bioMightKeys.setKey(bioMightKey);
				
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing StylomastoidArteries Methods!");
			//	ranineArteries(methodParams);
			//	ranineArteries(0);
			//}
			//System.out.println("Getting X3D for StylomastoidArteries!");
			bioMightComponent.setX3D(stylomastoidArteries.getX3D(snippet));			
		}
		else if (bioMightComponentRef.equals(Constants.StylomastoidArtery))
		{
			StylomastoidArtery  stylomastoidArtery = (StylomastoidArtery) bioMightInstance;
			bioMightComponent.setImage(stylomastoidArtery.getImage());
			bioMightComponent.setWidth(stylomastoidArtery.getImageWidth());
			bioMightComponent.setHeight(stylomastoidArtery.getImageHeight());
			bioMightComponent.setBioMightProperties(stylomastoidArtery.getProperties());
			bioMightComponent.setBioMightMethods(stylomastoidArtery.getMethods());
			
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for StylomastoidArtery: "  + bioMightComponent +  "     ID: " + stylomastoidArtery.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(stylomastoidArtery.getComponentID());
			bioMightKeys.setKey(bioMightKey);
				
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing StylomastoidArtery Methods!");
			//	StylomastoidArtery(methodParams);
			//	StylomastoidArtery(0);
			//}
			//System.out.println("Getting X3D for StylomastoidArtery!");
			bioMightComponent.setX3D(stylomastoidArtery.getX3D(snippet));			
		}
		else if (bioMightComponentRef.equals(Constants.MedialPalpebralArteries))
		{
			MedialPalpebralArteries  medialPalpebralArteries = (MedialPalpebralArteries) bioMightInstance;
			bioMightComponent.setImage(medialPalpebralArteries.getImage());
			bioMightComponent.setWidth(medialPalpebralArteries.getImageWidth());
			bioMightComponent.setHeight(medialPalpebralArteries.getImageHeight());
			bioMightComponent.setBioMightProperties(medialPalpebralArteries.getProperties());
			bioMightComponent.setBioMightMethods(medialPalpebralArteries.getMethods());
			bioMightComponent.setBioMightCollection(true);
			
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for MedialPalpebralArteries: "  + bioMightComponent +  "     ID: " + medialPalpebralArteries.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(medialPalpebralArteries.getComponentID());
			bioMightKeys.setKey(bioMightKey);
				
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing MedialPalpebralArteries Methods!");
			//	MedialPalpebralArteries(methodParams);
			//	MedialPalpebralArteries(0);
			//}
			//System.out.println("Getting X3D for MedialPalpebralArteries!");
			bioMightComponent.setX3D(medialPalpebralArteries.getX3D(snippet));			
		}
		else if (bioMightComponentRef.equals(Constants.MedialPalpebralArtery))
		{
			MedialPalpebralArtery  medialPalpebralArtery = (MedialPalpebralArtery) bioMightInstance;
			bioMightComponent.setImage(medialPalpebralArtery.getImage());
			bioMightComponent.setWidth(medialPalpebralArtery.getImageWidth());
			bioMightComponent.setHeight(medialPalpebralArtery.getImageHeight());
			bioMightComponent.setBioMightProperties(medialPalpebralArtery.getProperties());
			bioMightComponent.setBioMightMethods(medialPalpebralArtery.getMethods());
			bioMightComponent.setBioMightCollection(true);
			
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for MedialPalpebralArtery: "  + bioMightComponent +  "     ID: " + medialPalpebralArtery.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(medialPalpebralArtery.getComponentID());
			bioMightKeys.setKey(bioMightKey);
				
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing MedialPalpebralArtery Methods!");
			//	MedialPalpebralArtery(methodParams);
			//	MedialPalpebralArtery(0);
			//}
			//System.out.println("Getting X3D for MedialPalpebralArtery!");
			bioMightComponent.setX3D(medialPalpebralArtery.getX3D(snippet));			
		}
		else if (bioMightComponentRef.equals(Constants.HypophysealArteries))
		{
			MedialPalpebralArteries  hypophysealArteries = (MedialPalpebralArteries) bioMightInstance;
			bioMightComponent.setImage(hypophysealArteries.getImage());
			bioMightComponent.setWidth(hypophysealArteries.getImageWidth());
			bioMightComponent.setHeight(hypophysealArteries.getImageHeight());
			bioMightComponent.setBioMightProperties(hypophysealArteries.getProperties());
			bioMightComponent.setBioMightMethods(hypophysealArteries.getMethods());
			bioMightComponent.setBioMightCollection(true);
			
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for HypophysealArteries: "  + bioMightComponent +  "     ID: " + hypophysealArteries.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(hypophysealArteries.getComponentID());
			bioMightKeys.setKey(bioMightKey);
				
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing HypophysealArteries Methods!");
			//	HypophysealArteries(methodParams);
			//	HypophysealArteries(0);
			//}
			//System.out.println("Getting X3D for HypophysealArteries!");
			bioMightComponent.setX3D(hypophysealArteries.getX3D(snippet));			
		}
		else if (bioMightComponentRef.equals(Constants.HypophysealArtery))
		{
			HypophysealArtery  hypophysealArtery = (HypophysealArtery) bioMightInstance;
			bioMightComponent.setImage(hypophysealArtery.getImage());
			bioMightComponent.setWidth(hypophysealArtery.getImageWidth());
			bioMightComponent.setHeight(hypophysealArtery.getImageHeight());
			bioMightComponent.setBioMightProperties(hypophysealArtery.getProperties());
			bioMightComponent.setBioMightMethods(hypophysealArtery.getMethods());
			
	
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for HypophysealArtery: "  + bioMightComponent +  "     ID: " + hypophysealArtery.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(hypophysealArtery.getComponentID());
			bioMightKeys.setKey(bioMightKey);
				
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing HypophysealArtery Methods!");
			//	hypophysealArtery(methodParams);
			//	hypophysealArtery(0);
			//}
			//System.out.println("Getting X3D for HypophysealArtery!");
			bioMightComponent.setX3D(hypophysealArtery.getX3D(snippet));			
		}
		else if (bioMightComponentRef.equals(Constants.CerebellarArteries))
		{
			CerebellarArteries  cerebellarArteries = (CerebellarArteries) bioMightInstance;
			bioMightComponent.setImage(cerebellarArteries.getImage());
			bioMightComponent.setWidth(cerebellarArteries.getImageWidth());
			bioMightComponent.setHeight(cerebellarArteries.getImageHeight());
			bioMightComponent.setBioMightProperties(cerebellarArteries.getProperties());
			bioMightComponent.setBioMightMethods(cerebellarArteries.getMethods());
			bioMightComponent.setBioMightCollection(true);
			
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for CerebellarArteries: "  + bioMightComponent +  "     ID: " + cerebellarArteries.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(cerebellarArteries.getComponentID());
			bioMightKeys.setKey(bioMightKey);
				
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing CerebellarArteries Methods!");
			//	cerebellarArteries(methodParams);
			//	cerebellarArteries(0);
			//}
			//System.out.println("Getting X3D for CerebellarArteries!");
			bioMightComponent.setX3D(cerebellarArteries.getX3D(snippet));			
		}
		else if (bioMightComponentRef.equals(Constants.CerebellarArtery))
		{
			CerebellarArtery  cerebellarArtery = (CerebellarArtery) bioMightInstance;
			bioMightComponent.setImage(cerebellarArtery.getImage());
			bioMightComponent.setWidth(cerebellarArtery.getImageWidth());
			bioMightComponent.setHeight(cerebellarArtery.getImageHeight());
			bioMightComponent.setBioMightProperties(cerebellarArtery.getProperties());
			bioMightComponent.setBioMightMethods(cerebellarArtery.getMethods());
			
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for CerebellarArtery: "  + bioMightComponent +  "     ID: " + cerebellarArtery.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(cerebellarArtery.getComponentID());
			bioMightKeys.setKey(bioMightKey);
				
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing CerebellarArtery Methods!");
			//	cerebellarArtery(methodParams);
			//	cerebellarArtery(0);
			//}
			//System.out.println("Getting X3D for CerebellarArtery!");
			bioMightComponent.setX3D(cerebellarArtery.getX3D(snippet));			
		}
		else if (bioMightComponentRef.equals(Constants.SuperiorCerebellarArteries))
		{
			SuperiorCerebellarArteries  superiorCerebellarArteries = (SuperiorCerebellarArteries) bioMightInstance;
			bioMightComponent.setImage(superiorCerebellarArteries.getImage());
			bioMightComponent.setWidth(superiorCerebellarArteries.getImageWidth());
			bioMightComponent.setHeight(superiorCerebellarArteries.getImageHeight());
			bioMightComponent.setBioMightProperties(superiorCerebellarArteries.getProperties());
			bioMightComponent.setBioMightMethods(superiorCerebellarArteries.getMethods());
			bioMightComponent.setBioMightCollection(true);
			
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for SuperiorCerebellarArteries: "  + bioMightComponent +  "     ID: " + superiorCerebellarArteries.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(superiorCerebellarArteries.getComponentID());
			bioMightKeys.setKey(bioMightKey);
				
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing SuperiorCerebellarArteries Methods!");
			//	superiorCerebellarArteries(methodParams);
			//	superiorCerebellarArteries(0);
			//}
			//System.out.println("Getting X3D for SuperiorCerebellarArteries!");
			bioMightComponent.setX3D(superiorCerebellarArteries.getX3D(snippet));			
		}
		else if (bioMightComponentRef.equals(Constants.SuperiorCerebellarArtery))
		{
			SuperiorCerebellarArtery  superiorCerebellarArtery = (SuperiorCerebellarArtery) bioMightInstance;
			bioMightComponent.setImage(superiorCerebellarArtery.getImage());
			bioMightComponent.setWidth(superiorCerebellarArtery.getImageWidth());
			bioMightComponent.setHeight(superiorCerebellarArtery.getImageHeight());
			bioMightComponent.setBioMightProperties(superiorCerebellarArtery.getProperties());
			bioMightComponent.setBioMightMethods(superiorCerebellarArtery.getMethods());
			
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for SuperiorCerebellarArtery: "  + bioMightComponent +  "     ID: " + superiorCerebellarArtery.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(superiorCerebellarArtery.getComponentID());
			bioMightKeys.setKey(bioMightKey);
				
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing SuperiorCerebellarArtery Methods!");
			//	superiorCerebellarArtery(methodParams);
			//	superiorCerebellarArtery(0);
			//}
			//System.out.println("Getting X3D for SuperiorCerebellarArtery!");
			bioMightComponent.setX3D(superiorCerebellarArtery.getX3D(snippet));			
		}
		else if (bioMightComponentRef.equals(Constants.AnteriorInferiorCerebellarArteries))
		{
			AnteriorInferiorCerebellarArteries  anteriorInferiorCerebellarArteries = (AnteriorInferiorCerebellarArteries) bioMightInstance;
			bioMightComponent.setImage(anteriorInferiorCerebellarArteries.getImage());
			bioMightComponent.setWidth(anteriorInferiorCerebellarArteries.getImageWidth());
			bioMightComponent.setHeight(anteriorInferiorCerebellarArteries.getImageHeight());
			bioMightComponent.setBioMightProperties(anteriorInferiorCerebellarArteries.getProperties());
			bioMightComponent.setBioMightMethods(anteriorInferiorCerebellarArteries.getMethods());
			bioMightComponent.setBioMightCollection(true);
			
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for AnteriorInferiorCerebellarArteries: "  + bioMightComponent +  "     ID: " + anteriorInferiorCerebellarArteries.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(anteriorInferiorCerebellarArteries.getComponentID());
			bioMightKeys.setKey(bioMightKey);
				
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing AnteriorInferiorCerebellarArteries Methods!");
			//	anteriorInferiorCerebellarArteries(methodParams);
			//	anteriorInferiorCerebellarArteries(0);
			//}
			//System.out.println("Getting X3D for AnteriorInferiorCerebellarArteries!");
			bioMightComponent.setX3D(anteriorInferiorCerebellarArteries.getX3D(snippet));			
		}
		else if (bioMightComponentRef.equals(Constants.AnteriorInferiorCerebellarArtery))
		{
			AnteriorInferiorCerebellarArtery  anteriorInferiorCerebellarArtery = (AnteriorInferiorCerebellarArtery) bioMightInstance;
			bioMightComponent.setImage(anteriorInferiorCerebellarArtery.getImage());
			bioMightComponent.setWidth(anteriorInferiorCerebellarArtery.getImageWidth());
			bioMightComponent.setHeight(anteriorInferiorCerebellarArtery.getImageHeight());
			bioMightComponent.setBioMightProperties(anteriorInferiorCerebellarArtery.getProperties());
			bioMightComponent.setBioMightMethods(anteriorInferiorCerebellarArtery.getMethods());
			
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for AnteriorInferiorCerebellarArtery: "  + bioMightComponent +  "     ID: " + anteriorInferiorCerebellarArtery.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(anteriorInferiorCerebellarArtery.getComponentID());
			bioMightKeys.setKey(bioMightKey);
				
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing AnteriorInferiorCerebellarArtery Methods!");
			//	anteriorInferiorCerebellarArtery(methodParams);
			//	anteriorInferiorCerebellarArtery(0);
			//}
			//System.out.println("Getting X3D for AnteriorInferiorCerebellarArtery!");
			bioMightComponent.setX3D(anteriorInferiorCerebellarArtery.getX3D(snippet));			
		}
		else if (bioMightComponentRef.equals(Constants.PosteriorInferiorCerebellarArteries))
		{
			PosteriorInferiorCerebellarArteries  posteriorInferiorCerebellarArteries = (PosteriorInferiorCerebellarArteries) bioMightInstance;
			bioMightComponent.setImage(posteriorInferiorCerebellarArteries.getImage());
			bioMightComponent.setWidth(posteriorInferiorCerebellarArteries.getImageWidth());
			bioMightComponent.setHeight(posteriorInferiorCerebellarArteries.getImageHeight());
			bioMightComponent.setBioMightProperties(posteriorInferiorCerebellarArteries.getProperties());
			bioMightComponent.setBioMightMethods(posteriorInferiorCerebellarArteries.getMethods());
			bioMightComponent.setBioMightCollection(true);
			
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for PosteriorInferiorCerebellarArteries: "  + bioMightComponent +  "     ID: " + posteriorInferiorCerebellarArteries.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(posteriorInferiorCerebellarArteries.getComponentID());
			bioMightKeys.setKey(bioMightKey);
				
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing PosteriorInferiorCerebellarArteries Methods!");
			//	posteriorInferiorCerebellarArteries(methodParams);
			//	posteriorInferiorCerebellarArteries(0);
			//}
			//System.out.println("Getting X3D for PosteriorInferiorCerebellarArteries!");
			bioMightComponent.setX3D(posteriorInferiorCerebellarArteries.getX3D(snippet));			
		}
		else if (bioMightComponentRef.equals(Constants.PosteriorInferiorCerebellarArtery))
		{
			PosteriorInferiorCerebellarArtery  posteriorInferiorCerebellarArtery = (PosteriorInferiorCerebellarArtery) bioMightInstance;
			bioMightComponent.setImage(posteriorInferiorCerebellarArtery.getImage());
			bioMightComponent.setWidth(posteriorInferiorCerebellarArtery.getImageWidth());
			bioMightComponent.setHeight(posteriorInferiorCerebellarArtery.getImageHeight());
			bioMightComponent.setBioMightProperties(posteriorInferiorCerebellarArtery.getProperties());
			bioMightComponent.setBioMightMethods(posteriorInferiorCerebellarArtery.getMethods());
			
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for PosteriorInferiorCerebellarArtery: "  + bioMightComponent +  "     ID: " + posteriorInferiorCerebellarArtery.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(posteriorInferiorCerebellarArtery.getComponentID());
			bioMightKeys.setKey(bioMightKey);
				
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing PosteriorInferiorCerebellarArtery Methods!");
			//	posteriorInferiorCerebellarArtery(methodParams);
			//	posteriorInferiorCerebellarArtery(0);
			//}
			//System.out.println("Getting X3D for PosteriorInferiorCerebellarArtery!");
			bioMightComponent.setX3D(posteriorInferiorCerebellarArtery.getX3D(snippet));			
		}
		else if (bioMightComponentRef.equals(Constants.PalatineArteries))
		{
			PalatineArteries  palatineArteries = (PalatineArteries) bioMightInstance;
			bioMightComponent.setImage(palatineArteries.getImage());
			bioMightComponent.setWidth(palatineArteries.getImageWidth());
			bioMightComponent.setHeight(palatineArteries.getImageHeight());
			bioMightComponent.setBioMightProperties(palatineArteries.getProperties());
			bioMightComponent.setBioMightMethods(palatineArteries.getMethods());
			bioMightComponent.setBioMightCollection(true);
			
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for PalatineArteries: "  + bioMightComponent +  "     ID: " + palatineArteries.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(palatineArteries.getComponentID());
			bioMightKeys.setKey(bioMightKey);
				
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing PalatineArteries Methods!");
			//	palatineArteries(methodParams);
			//	palatineArteries(0);
			//}
			//System.out.println("Getting X3D for PalatineArteries!");
			bioMightComponent.setX3D(palatineArteries.getX3D(snippet));			
		}			
		else if (bioMightComponentRef.equals(Constants.PalatineArtery))
		{
			PalatineArtery  palatineArtery = (PalatineArtery) bioMightInstance;
			bioMightComponent.setImage(palatineArtery.getImage());
			bioMightComponent.setWidth(palatineArtery.getImageWidth());
			bioMightComponent.setHeight(palatineArtery.getImageHeight());
			bioMightComponent.setBioMightProperties(palatineArtery.getProperties());
			bioMightComponent.setBioMightMethods(palatineArtery.getMethods());
			bioMightComponent.setBioMightCollection(true);
			
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for PalatineArtery: "  + bioMightComponent +  "     ID: " + palatineArtery.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(palatineArtery.getComponentID());
			bioMightKeys.setKey(bioMightKey);
				
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing PalatineArtery Methods!");
			//	palatineArteries(methodParams);
			//	palatineArteries(0);
			//}
			//System.out.println("Getting X3D for PalatineArtery!");
			bioMightComponent.setX3D(palatineArtery.getX3D(snippet));			
		}
		else if (bioMightComponentRef.equals(Constants.AnteriorSpinalArteries))
		{
			AnteriorSpinalArteries  palatineArteries = (AnteriorSpinalArteries) bioMightInstance;
			bioMightComponent.setImage(palatineArteries.getImage());
			bioMightComponent.setWidth(palatineArteries.getImageWidth());
			bioMightComponent.setHeight(palatineArteries.getImageHeight());
			bioMightComponent.setBioMightProperties(palatineArteries.getProperties());
			bioMightComponent.setBioMightMethods(palatineArteries.getMethods());
			bioMightComponent.setBioMightCollection(true);
			
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for AnteriorSpinalArteries: "  + bioMightComponent +  "     ID: " + palatineArteries.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(palatineArteries.getComponentID());
			bioMightKeys.setKey(bioMightKey);
				
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing AnteriorSpinalArteries Methods!");
			//	palatineArteries(methodParams);
			//	palatineArteries(0);
			//}
			//System.out.println("Getting X3D for AnteriorSpinalArteries!");
			bioMightComponent.setX3D(palatineArteries.getX3D(snippet));			
		}			
		else if (bioMightComponentRef.equals(Constants.AnteriorSpinalArtery))
		{
			AnteriorSpinalArtery  palatineArtery = (AnteriorSpinalArtery) bioMightInstance;
			bioMightComponent.setImage(palatineArtery.getImage());
			bioMightComponent.setWidth(palatineArtery.getImageWidth());
			bioMightComponent.setHeight(palatineArtery.getImageHeight());
			bioMightComponent.setBioMightProperties(palatineArtery.getProperties());
			bioMightComponent.setBioMightMethods(palatineArtery.getMethods());
			bioMightComponent.setBioMightCollection(true);
			
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for AnteriorSpinalArtery: "  + bioMightComponent +  "     ID: " + palatineArtery.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(palatineArtery.getComponentID());
			bioMightKeys.setKey(bioMightKey);
				
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing AnteriorSpinalArtery Methods!");
			//	palatineArteries(methodParams);
			//	palatineArteries(0);
			//}
			//System.out.println("Getting X3D for AnteriorSpinalArtery!");
			bioMightComponent.setX3D(palatineArtery.getX3D(snippet));			
		}		
		
		else if (bioMightComponentRef.equals(Constants.ExternalMaxillaryArteries))
		{
			ExternalMaxillaryArteries  externalMaxillaryArteries = (ExternalMaxillaryArteries) bioMightInstance;
			bioMightComponent.setImage(externalMaxillaryArteries.getImage());
			bioMightComponent.setWidth(externalMaxillaryArteries.getImageWidth());
			bioMightComponent.setHeight(externalMaxillaryArteries.getImageHeight());
			bioMightComponent.setBioMightProperties(externalMaxillaryArteries.getProperties());
			bioMightComponent.setBioMightMethods(externalMaxillaryArteries.getMethods());
			bioMightComponent.setBioMightCollection(true);
			
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for ExternalMaxillaryArteries: "  + bioMightComponent +  "     ID: " + externalMaxillaryArteries.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(externalMaxillaryArteries.getComponentID());
			bioMightKeys.setKey(bioMightKey);
				
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing ExternalMaxillaryArteries Methods!");
			//	externalMaxillaryArteries(methodParams);
			//	externalMaxillaryArteries(0);
			//}
			//System.out.println("Getting X3D for ExternalMaxillaryArteries!");
			bioMightComponent.setX3D(externalMaxillaryArteries.getX3D(snippet));			
		}			
		else if (bioMightComponentRef.equals(Constants.ExternalMaxillaryArtery))
		{
			ExternalMaxillaryArtery  externalMaxillaryArtery = (ExternalMaxillaryArtery) bioMightInstance;
			bioMightComponent.setImage(externalMaxillaryArtery.getImage());
			bioMightComponent.setWidth(externalMaxillaryArtery.getImageWidth());
			bioMightComponent.setHeight(externalMaxillaryArtery.getImageHeight());
			bioMightComponent.setBioMightProperties(externalMaxillaryArtery.getProperties());
			bioMightComponent.setBioMightMethods(externalMaxillaryArtery.getMethods());
			bioMightComponent.setBioMightCollection(true);
			
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for ExternalMaxillaryArtery: "  + bioMightComponent +  "     ID: " + externalMaxillaryArtery.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(externalMaxillaryArtery.getComponentID());
			bioMightKeys.setKey(bioMightKey);
				
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing ExternalMaxillaryArtery Methods!");
			//	externalMaxillaryArteries(methodParams);
			//	externalMaxillaryArteries(0);
			//}
			//System.out.println("Getting X3D for ExternalMaxillaryArtery!");
			bioMightComponent.setX3D(externalMaxillaryArtery.getX3D(snippet));			
		}			
		else if (bioMightComponentRef.equals(Constants.InternalMaxillaryArteries))
		{
			InternalMaxillaryArteries  internalMaxillaryArteries = (InternalMaxillaryArteries) bioMightInstance;
			bioMightComponent.setImage(internalMaxillaryArteries.getImage());
			bioMightComponent.setWidth(internalMaxillaryArteries.getImageWidth());
			bioMightComponent.setHeight(internalMaxillaryArteries.getImageHeight());
			bioMightComponent.setBioMightProperties(internalMaxillaryArteries.getProperties());
			bioMightComponent.setBioMightMethods(internalMaxillaryArteries.getMethods());
			bioMightComponent.setBioMightCollection(true);
			
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for InternalMaxillaryArteries: "  + bioMightComponent +  "     ID: " + internalMaxillaryArteries.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(internalMaxillaryArteries.getComponentID());
			bioMightKeys.setKey(bioMightKey);
				
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing InternalMaxillaryArteries Methods!");
			//	internalMaxillaryArteries(methodParams);
			//	internalMaxillaryArteries(0);
			//}
			//System.out.println("Getting X3D for InternalMaxillaryArteries!");
			bioMightComponent.setX3D(internalMaxillaryArteries.getX3D(snippet));			
		}			
		else if (bioMightComponentRef.equals(Constants.InternalMaxillaryArtery))
		{
			InternalMaxillaryArtery  internalMaxillaryArtery = (InternalMaxillaryArtery) bioMightInstance;
			bioMightComponent.setImage(internalMaxillaryArtery.getImage());
			bioMightComponent.setWidth(internalMaxillaryArtery.getImageWidth());
			bioMightComponent.setHeight(internalMaxillaryArtery.getImageHeight());
			bioMightComponent.setBioMightProperties(internalMaxillaryArtery.getProperties());
			bioMightComponent.setBioMightMethods(internalMaxillaryArtery.getMethods());
			bioMightComponent.setBioMightCollection(true);
			
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for InternalMaxillaryArtery: "  + bioMightComponent +  "     ID: " + internalMaxillaryArtery.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(internalMaxillaryArtery.getComponentID());
			bioMightKeys.setKey(bioMightKey);
				
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing InternalMaxillaryArtery Methods!");
			//	internalMaxillaryArteries(methodParams);
			//	internalMaxillaryArteries(0);
			//}
			//System.out.println("Getting X3D for InternalMaxillaryArtery!");
			bioMightComponent.setX3D(internalMaxillaryArtery.getX3D(snippet));			
		}	
		
		
		else if (bioMightComponentRef.equals(Constants.SuperficialTemporalArteries))
		{
			SuperficialTemporalArteries  palatineArteries = (SuperficialTemporalArteries) bioMightInstance;
			bioMightComponent.setImage(palatineArteries.getImage());
			bioMightComponent.setWidth(palatineArteries.getImageWidth());
			bioMightComponent.setHeight(palatineArteries.getImageHeight());
			bioMightComponent.setBioMightProperties(palatineArteries.getProperties());
			bioMightComponent.setBioMightMethods(palatineArteries.getMethods());
			bioMightComponent.setBioMightCollection(true);
			
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for SuperficialTemporalArteries: "  + bioMightComponent +  "     ID: " + palatineArteries.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(palatineArteries.getComponentID());
			bioMightKeys.setKey(bioMightKey);
				
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing SuperficialTemporalArteries Methods!");
			//	palatineArteries(methodParams);
			//	palatineArteries(0);
			//}
			//System.out.println("Getting X3D for SuperficialTemporalArteries!");
			bioMightComponent.setX3D(palatineArteries.getX3D(snippet));			
		}			
		else if (bioMightComponentRef.equals(Constants.SuperficialTemporalArtery))
		{
			SuperficialTemporalArtery  palatineArtery = (SuperficialTemporalArtery) bioMightInstance;
			bioMightComponent.setImage(palatineArtery.getImage());
			bioMightComponent.setWidth(palatineArtery.getImageWidth());
			bioMightComponent.setHeight(palatineArtery.getImageHeight());
			bioMightComponent.setBioMightProperties(palatineArtery.getProperties());
			bioMightComponent.setBioMightMethods(palatineArtery.getMethods());
			bioMightComponent.setBioMightCollection(true);
			
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for SuperficialTemporalArtery: "  + bioMightComponent +  "     ID: " + palatineArtery.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(palatineArtery.getComponentID());
			bioMightKeys.setKey(bioMightKey);
				
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing SuperficialTemporalArtery Methods!");
			//	palatineArteries(methodParams);
			//	palatineArteries(0);
			//}
			//System.out.println("Getting X3D for SuperficialTemporalArtery!");
			bioMightComponent.setX3D(palatineArtery.getX3D(snippet));			
		}
		
		else if (bioMightComponentRef.equals(Constants.LingualArteries))
		{
			LingualArteries  lingualArteries = (LingualArteries) bioMightInstance;
			bioMightComponent.setImage(lingualArteries.getImage());
			bioMightComponent.setWidth(lingualArteries.getImageWidth());
			bioMightComponent.setHeight(lingualArteries.getImageHeight());
			bioMightComponent.setBioMightProperties(lingualArteries.getProperties());
			bioMightComponent.setBioMightMethods(lingualArteries.getMethods());
			bioMightComponent.setBioMightCollection(true);
			
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for LingualArteries: "  + bioMightComponent +  "     ID: " + lingualArteries.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(lingualArteries.getComponentID());
			bioMightKeys.setKey(bioMightKey);
				
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing PalatineArteries Methods!");
			//	lingualArteries(methodParams);
			//	lingualArteries(0);
			//}
			//System.out.println("Getting X3D for LingualArteries!");
			bioMightComponent.setX3D(lingualArteries.getX3D(snippet));			
		}		
		else if (bioMightComponentRef.equals(Constants.LingualArtery))
		{
			LingualArtery  lingualArtery = (LingualArtery) bioMightInstance;
			bioMightComponent.setImage(lingualArtery.getImage());
			bioMightComponent.setWidth(lingualArtery.getImageWidth());
			bioMightComponent.setHeight(lingualArtery.getImageHeight());
			bioMightComponent.setBioMightProperties(lingualArtery.getProperties());
			bioMightComponent.setBioMightMethods(lingualArtery.getMethods());
			
			
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for LingualArtery: "  + bioMightComponent +  "     ID: " + lingualArtery.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(lingualArtery.getComponentID());
			bioMightKeys.setKey(bioMightKey);
				
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing LingualArtery Methods!");
			//	lingualArtery(methodParams);
			//	lingualArtery(0);
			//}
			//System.out.println("Getting X3D for LingualArtery!");
			bioMightComponent.setX3D(lingualArtery.getX3D(snippet));			
		}
		else if (bioMightComponentRef.equals(Constants.ConjunctivalArteries))
		{
			ConjunctivalArteries  conjunctivalArteries = (ConjunctivalArteries) bioMightInstance;
			bioMightComponent.setImage(conjunctivalArteries.getImage());
			bioMightComponent.setWidth(conjunctivalArteries.getImageWidth());
			bioMightComponent.setHeight(conjunctivalArteries.getImageHeight());
			bioMightComponent.setBioMightProperties(conjunctivalArteries.getProperties());
			bioMightComponent.setBioMightMethods(conjunctivalArteries.getMethods());
			bioMightComponent.setBioMightCollection(true);
			
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for ConjunctivalArteries: "  + bioMightComponent +  "     ID: " + conjunctivalArteries.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(conjunctivalArteries.getComponentID());
			bioMightKeys.setKey(bioMightKey);
				
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing ConjunctivalArteries Methods!");
			//	conjunctivalArteries(methodParams);
			//	conjunctivalArteries(0);
			//}
			//System.out.println("Getting X3D for ConjunctivalArteries!");
			bioMightComponent.setX3D(conjunctivalArteries.getX3D(snippet));			
		}		
		else if (bioMightComponentRef.equals(Constants.ConjunctivalArtery))
		{
			ConjunctivalArtery  conjunctivalArtery = (ConjunctivalArtery) bioMightInstance;
			bioMightComponent.setImage(conjunctivalArtery.getImage());
			bioMightComponent.setWidth(conjunctivalArtery.getImageWidth());
			bioMightComponent.setHeight(conjunctivalArtery.getImageHeight());
			bioMightComponent.setBioMightProperties(conjunctivalArtery.getProperties());
			bioMightComponent.setBioMightMethods(conjunctivalArtery.getMethods());
							
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for ConjunctivalArtery: "  + bioMightComponent +  "     ID: " + conjunctivalArtery.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(conjunctivalArtery.getComponentID());
			bioMightKeys.setKey(bioMightKey);
				
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing ConjunctivalArtery Methods!");
			//	conjunctivalArtery(methodParams);
			//	conjunctivalArtery(0);
			//}
			//System.out.println("Getting X3D for ConjunctivalArtery!");
			bioMightComponent.setX3D(conjunctivalArtery.getX3D(snippet));			
		}
		else if (bioMightComponentRef.equals(Constants.CiliaryArteries))
		{
			CiliaryArteries ciliaryArteries = (CiliaryArteries) bioMightInstance;
			bioMightComponent.setImage(ciliaryArteries.getImage());
			bioMightComponent.setWidth(ciliaryArteries.getImageWidth());
			bioMightComponent.setHeight(ciliaryArteries.getImageHeight());
			bioMightComponent.setBioMightProperties(ciliaryArteries.getProperties());
			bioMightComponent.setBioMightMethods(ciliaryArteries.getMethods());
			bioMightComponent.setBioMightCollection(true);
			
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for CiliaryArteries: "  + bioMightComponent +  "     ID: " + ciliaryArteries.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(ciliaryArteries.getComponentID());
			bioMightKeys.setKey(bioMightKey);
				
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing CiliaryArteries Methods!");
			//	conjunctivalArteries(methodParams);
			//	conjunctivalArteries(0);
			//}
			//System.out.println("Getting X3D for CiliaryArteries!");
			ciliaryArteries.setX3D(ciliaryArteries.getX3D(snippet));			
		}
		else if (bioMightComponentRef.equals(Constants.CiliaryArtery))
		{
			CiliaryArtery ciliaryArtery = (CiliaryArtery) bioMightInstance;
			bioMightComponent.setImage(ciliaryArtery.getImage());
			bioMightComponent.setWidth(ciliaryArtery.getImageWidth());
			bioMightComponent.setHeight(ciliaryArtery.getImageHeight());
			bioMightComponent.setBioMightProperties(ciliaryArtery.getProperties());
			bioMightComponent.setBioMightMethods(ciliaryArtery.getMethods());
			
			
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for CiliaryArtery: "  + bioMightComponent +  "     ID: " + ciliaryArtery.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(ciliaryArtery.getComponentID());
			bioMightKeys.setKey(bioMightKey);
				
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing CiliaryArtery Methods!");
			//	ciliaryArtery(methodParams);
			//	ciliaryArtery(0);
			//}
			//System.out.println("Getting X3D for CiliaryArtery!");
			bioMightComponent.setX3D(ciliaryArtery.getX3D(snippet));			
		}
		else if (bioMightComponentRef.equals(Constants.InfraOrbitalArteries))
		{
			InfraOrbitalArteries infraOrbitalArteries = (InfraOrbitalArteries) bioMightInstance;
			bioMightComponent.setImage(infraOrbitalArteries.getImage());
			bioMightComponent.setWidth(infraOrbitalArteries.getImageWidth());
			bioMightComponent.setHeight(infraOrbitalArteries.getImageHeight());
			bioMightComponent.setBioMightProperties(infraOrbitalArteries.getProperties());
			bioMightComponent.setBioMightMethods(infraOrbitalArteries.getMethods());
			bioMightComponent.setBioMightCollection(true);
			
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for InfraOrbitalArteries: "  + bioMightComponent +  "     ID: " + infraOrbitalArteries.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(infraOrbitalArteries.getComponentID());
			bioMightKeys.setKey(bioMightKey);
				
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing InfraOrbitalArteries Methods!");
			//	conjunctivalArteries(methodParams);
			//	conjunctivalArteries(0);
			//}
			//System.out.println("Getting X3D for InfraOrbitalArteries!");
			infraOrbitalArteries.setX3D(infraOrbitalArteries.getX3D(snippet));			
		}
		else if (bioMightComponentRef.equals(Constants.InfraOrbitalArtery))
		{
			InfraOrbitalArtery infraOrbitalArtery = (InfraOrbitalArtery) bioMightInstance;
			bioMightComponent.setImage(infraOrbitalArtery.getImage());
			bioMightComponent.setWidth(infraOrbitalArtery.getImageWidth());
			bioMightComponent.setHeight(infraOrbitalArtery.getImageHeight());
			bioMightComponent.setBioMightProperties(infraOrbitalArtery.getProperties());
			bioMightComponent.setBioMightMethods(infraOrbitalArtery.getMethods());
			
			
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for InfraOrbitalArtery: "  + bioMightComponent +  "     ID: " + infraOrbitalArtery.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(infraOrbitalArtery.getComponentID());
			bioMightKeys.setKey(bioMightKey);
				
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing InfraOrbitalArtery Methods!");
			//	infraOrbitalArtery(methodParams);
			//	infraOrbitalArtery(0);
			//}
			//System.out.println("Getting X3D for InfraOrbitalArtery!");
			bioMightComponent.setX3D(infraOrbitalArtery.getX3D(snippet));			
		}
		else if (bioMightComponentRef.equals(Constants.SupraOrbitalArteries))
		{
			SupraOrbitalArteries supraOrbitalArteries = (SupraOrbitalArteries) bioMightInstance;
			bioMightComponent.setImage(supraOrbitalArteries.getImage());
			bioMightComponent.setWidth(supraOrbitalArteries.getImageWidth());
			bioMightComponent.setHeight(supraOrbitalArteries.getImageHeight());
			bioMightComponent.setBioMightProperties(supraOrbitalArteries.getProperties());
			bioMightComponent.setBioMightMethods(supraOrbitalArteries.getMethods());
			bioMightComponent.setBioMightCollection(true);
			
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for SupraOrbitalArteries: "  + bioMightComponent +  "     ID: " + supraOrbitalArteries.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(supraOrbitalArteries.getComponentID());
			bioMightKeys.setKey(bioMightKey);
				
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing SupraOrbitalArteries Methods!");
			//	conjunctivalArteries(methodParams);
			//	conjunctivalArteries(0);
			//}
			//System.out.println("Getting X3D for SupraOrbitalArteries!");
			supraOrbitalArteries.setX3D(supraOrbitalArteries.getX3D(snippet));			
		}
		else if (bioMightComponentRef.equals(Constants.SupraOrbitalArtery))
		{
			SupraOrbitalArtery supraOrbitalArtery = (SupraOrbitalArtery) bioMightInstance;
			bioMightComponent.setImage(supraOrbitalArtery.getImage());
			bioMightComponent.setWidth(supraOrbitalArtery.getImageWidth());
			bioMightComponent.setHeight(supraOrbitalArtery.getImageHeight());
			bioMightComponent.setBioMightProperties(supraOrbitalArtery.getProperties());
			bioMightComponent.setBioMightMethods(supraOrbitalArtery.getMethods());
			
			
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for SupraOrbitalArtery: "  + bioMightComponent +  "     ID: " + supraOrbitalArtery.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(supraOrbitalArtery.getComponentID());
			bioMightKeys.setKey(bioMightKey);
				
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing SupraOrbitalArtery Methods!");
			//	supraOrbitalArtery(methodParams);
			//	supraOrbitalArtery(0);
			//}
			//System.out.println("Getting X3D for SupraOrbitalArtery!");
			bioMightComponent.setX3D(supraOrbitalArtery.getX3D(snippet));			
		}		
		
		
		
		/**************************************************************************
		*
		* VASCULATURE OF THEE CHEST 
		*
		* This section maps the data in the biomight object into the presentation 
		* layer.  
		*  
		***************************************************************************/
	
		else if (bioMightComponentRef.equals(Constants.SuperiorVenaCava))
		{
			SuperiorVenaCava superiorVenaCava = (SuperiorVenaCava) bioMightInstance;
			bioMightComponent.setImage(superiorVenaCava.getImage());
			bioMightComponent.setWidth(superiorVenaCava.getImageWidth());
			bioMightComponent.setHeight(superiorVenaCava.getImageHeight());
			bioMightComponent.setBioMightProperties(superiorVenaCava.getProperties());
			bioMightComponent.setBioMightMethods(superiorVenaCava.getMethods());
			
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for SuperiorVenaCava: "  + bioMightComponent +  "     ID: " + superiorVenaCava.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(superiorVenaCava.getComponentID());
			bioMightKeys.setKey(bioMightKey);
				
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing SuperiorVenaCava Methods!");
			//	superiorVenaCava(methodParams);
			//	superiorVenaCava(0);
			//}
			//System.out.println("Getting X3D for SuperiorVenaCava!");
			bioMightComponent.setX3D(superiorVenaCava.getX3D(snippet));			
		}	
		else if (bioMightComponentRef.equals(Constants.InferiorVenaCava))
		{
			InferiorVenaCava inferiorVenaCava = (InferiorVenaCava) bioMightInstance;
			bioMightComponent.setImage(inferiorVenaCava.getImage());
			bioMightComponent.setWidth(inferiorVenaCava.getImageWidth());
			bioMightComponent.setHeight(inferiorVenaCava.getImageHeight());
			bioMightComponent.setBioMightProperties(inferiorVenaCava.getProperties());
			bioMightComponent.setBioMightMethods(inferiorVenaCava.getMethods());
							
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for InferiorVenaCava: "  + bioMightComponent +  "     ID: " + inferiorVenaCava.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(inferiorVenaCava.getComponentID());
			bioMightKeys.setKey(bioMightKey);
				
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing InferiorVenaCava Methods!");
			//	inferiorVenaCava(methodParams);
			//	inferiorVenaCava(0);
			//}
			//System.out.println("Getting X3D for InferiorVenaCava!");
			bioMightComponent.setX3D(inferiorVenaCava.getX3D(snippet));			
		}	
		else if (bioMightComponentRef.equals(Constants.AortaArtery))
		{
			AortaArtery aortaArtery = (AortaArtery) bioMightInstance;
			bioMightComponent.setImage(aortaArtery.getImage());
			bioMightComponent.setWidth(aortaArtery.getImageWidth());
			bioMightComponent.setHeight(aortaArtery.getImageHeight());
			bioMightComponent.setBioMightProperties(aortaArtery.getProperties());
			bioMightComponent.setBioMightMethods(aortaArtery.getMethods());
							
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for AortaArtery: "  + bioMightComponent +  "     ID: " + aortaArtery.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(aortaArtery.getComponentID());
			bioMightKeys.setKey(bioMightKey);
				
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing AortaArtery Methods!");
			//	aortaArtery(methodParams);
			//	aortaArtery(0);
			//}
			//System.out.println("Getting X3D for AortaArtery!");
			bioMightComponent.setX3D(aortaArtery.getX3D(snippet));			
		}			
		else if (bioMightComponentRef.equals(Constants.AscendingAortaArtery))
		{
			AscendingAortaArtery ascendingAortaArtery = (AscendingAortaArtery) bioMightInstance;
			bioMightComponent.setImage(ascendingAortaArtery.getImage());
			bioMightComponent.setWidth(ascendingAortaArtery.getImageWidth());
			bioMightComponent.setHeight(ascendingAortaArtery.getImageHeight());
			bioMightComponent.setBioMightProperties(ascendingAortaArtery.getProperties());
			bioMightComponent.setBioMightMethods(ascendingAortaArtery.getMethods());
							
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for AscendingAortaArtery: "  + bioMightComponent +  "     ID: " + ascendingAortaArtery.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(ascendingAortaArtery.getComponentID());
			bioMightKeys.setKey(bioMightKey);
			bioMightComponent.setBioMightCollection(false);
			
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing AscendingAortaArtery Methods!");
			//	ascendingAortaArtery(methodParams);
			//	ascendingAortaArtery(0);
			//}
			//System.out.println("Getting X3D for AscendingAortaArtery!");
			bioMightComponent.setX3D(ascendingAortaArtery.getX3D(snippet));			
		}		
		else if (bioMightComponentRef.equals(Constants.AxillaryArteries))
		{
			AxillaryArteries axillaryArteries = (AxillaryArteries) bioMightInstance;
			bioMightComponent.setImage(axillaryArteries.getImage());
			bioMightComponent.setWidth(axillaryArteries.getImageWidth());
			bioMightComponent.setHeight(axillaryArteries.getImageHeight());
			bioMightComponent.setBioMightProperties(axillaryArteries.getProperties());
			bioMightComponent.setBioMightMethods(axillaryArteries.getMethods());
			bioMightComponent.setBioMightCollection(true);
								
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for AxillaryArteries: "  + bioMightComponent +  "     ID: " + axillaryArteries.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(axillaryArteries.getComponentID());
			bioMightKeys.setKey(bioMightKey);
				
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing AxillaryArteries Methods!");
			//	axillaryArteries(methodParams);
			//	axillaryArteries(0);
			//}
			//System.out.println("Getting X3D for AxillaryArteries!");
			bioMightComponent.setX3D(axillaryArteries.getX3D(snippet));			
		}	
		else if (bioMightComponentRef.equals(Constants.AxillaryArtery))
		{
			AxillaryArtery axillaryArtery = (AxillaryArtery) bioMightInstance;
			bioMightComponent.setImage(axillaryArtery.getImage());
			bioMightComponent.setWidth(axillaryArtery.getImageWidth());
			bioMightComponent.setHeight(axillaryArtery.getImageHeight());
			bioMightComponent.setBioMightProperties(axillaryArtery.getProperties());
			bioMightComponent.setBioMightMethods(axillaryArtery.getMethods());
								
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for AxillaryArtery: "  + bioMightComponent +  "     ID: " + axillaryArtery.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(axillaryArtery.getComponentID());
			bioMightKeys.setKey(bioMightKey);
				
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing AxillaryArtery Methods!");
			//	axillaryArtery(methodParams);
			//	axillaryArtery(0);
			//}
			//System.out.println("Getting X3D for AxillaryArtery!");
			bioMightComponent.setX3D(axillaryArtery.getX3D(snippet));			
		}
		else if (bioMightComponentRef.equals(Constants.BronchialArteries))
		{
			BronchialArteries bronchialArteries = (BronchialArteries) bioMightInstance;
			bioMightComponent.setImage(bronchialArteries.getImage());
			bioMightComponent.setWidth(bronchialArteries.getImageWidth());
			bioMightComponent.setHeight(bronchialArteries.getImageHeight());
			bioMightComponent.setBioMightProperties(bronchialArteries.getProperties());
			bioMightComponent.setBioMightMethods(bronchialArteries.getMethods());
			bioMightComponent.setBioMightCollection(true);
			
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for BronchialArteries: "  + bioMightComponent +  "     ID: " + bronchialArteries.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(bronchialArteries.getComponentID());
			bioMightKeys.setKey(bioMightKey);
				
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing BronchialArteries Methods!");
			//	bronchialArteries(methodParams);
			//	bronchialArteries(0);
			//}
			//System.out.println("Getting X3D for BronchialArteries!");
			bioMightComponent.setX3D(bronchialArteries.getX3D(snippet));			
		}
		else if (bioMightComponentRef.equals(Constants.BronchialArtery))
		{
			BronchialArtery bronchialArtery = (BronchialArtery) bioMightInstance;
			bioMightComponent.setImage(bronchialArtery.getImage());
			bioMightComponent.setWidth(bronchialArtery.getImageWidth());
			bioMightComponent.setHeight(bronchialArtery.getImageHeight());
			bioMightComponent.setBioMightProperties(bronchialArtery.getProperties());
			bioMightComponent.setBioMightMethods(bronchialArtery.getMethods());
			
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for BronchialArtery: "  + bioMightComponent +  "     ID: " + bronchialArtery.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(bronchialArtery.getComponentID());
			bioMightKeys.setKey(bioMightKey);
				
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing BronchialArtery Methods!");
			//	bronchialArteries(methodParams);
			//	bronchialArteries(0);
			//}
			//System.out.println("Getting X3D for BronchialArtery!");
			bioMightComponent.setX3D(bronchialArtery.getX3D(snippet));			
		}
		else if (bioMightComponentRef.equals(Constants.DescendingAortaArtery))
		{
			DescendingAortaArtery descendingAortaArtery = (DescendingAortaArtery) bioMightInstance;
			bioMightComponent.setImage(descendingAortaArtery.getImage());
			bioMightComponent.setWidth(descendingAortaArtery.getImageWidth());
			bioMightComponent.setHeight(descendingAortaArtery.getImageHeight());
			bioMightComponent.setBioMightProperties(descendingAortaArtery.getProperties());
			bioMightComponent.setBioMightMethods(descendingAortaArtery.getMethods());
			
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for DescendingAortaArtery: "  + bioMightComponent +  "     ID: " + descendingAortaArtery.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(descendingAortaArtery.getComponentID());
			bioMightKeys.setKey(bioMightKey);
				
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing DescendingAortaArtery Methods!");
			//	descendingAortaArtery(methodParams);
			//	descendingAortaArtery(0);
			//}
			//System.out.println("Getting X3D for DescendingAortaArtery!");
			bioMightComponent.setX3D(descendingAortaArtery.getX3D(snippet));			
		}
		else if (bioMightComponentRef.equals(Constants.ConusArtery))
		{
			ConusArtery conusArtery = (ConusArtery) bioMightInstance;
			bioMightComponent.setImage(conusArtery.getImage());
			bioMightComponent.setWidth(conusArtery.getImageWidth());
			bioMightComponent.setHeight(conusArtery.getImageHeight());
			bioMightComponent.setBioMightProperties(conusArtery.getProperties());
			bioMightComponent.setBioMightMethods(conusArtery.getMethods());
			
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for ConusArtery: "  + bioMightComponent +  "     ID: " + conusArtery.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(conusArtery.getComponentID());
			bioMightKeys.setKey(bioMightKey);
				
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing ConusArtery Methods!");
			//	conusArtery(methodParams);
			//	conusArtery(0);
			//}
			//System.out.println("Getting X3D for ConusArtery!");
			bioMightComponent.setX3D(conusArtery.getX3D(snippet));			
		}
		else if (bioMightComponentRef.equals(Constants.InferiorAlveolarArtery))
		{
			InferiorAlveolarArtery inferiorAlveolarArtery = (InferiorAlveolarArtery) bioMightInstance;
			bioMightComponent.setImage(inferiorAlveolarArtery.getImage());
			bioMightComponent.setWidth(inferiorAlveolarArtery.getImageWidth());
			bioMightComponent.setHeight(inferiorAlveolarArtery.getImageHeight());
			bioMightComponent.setBioMightProperties(inferiorAlveolarArtery.getProperties());
			bioMightComponent.setBioMightMethods(inferiorAlveolarArtery.getMethods());
			
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for InferiorAlveolarArtery: "  + bioMightComponent +  "     ID: " + inferiorAlveolarArtery.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(inferiorAlveolarArtery.getComponentID());
			bioMightKeys.setKey(bioMightKey);
				
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing InferiorAlveolarArtery Methods!");
			//	inferiorAlveolarArtery(methodParams);
			//	inferiorAlveolarArtery(0);
			//}
			//System.out.println("Getting X3D for InferiorAlveolarArtery!");
			bioMightComponent.setX3D(inferiorAlveolarArtery.getX3D(snippet));			
		}
		else if (bioMightComponentRef.equals(Constants.CoronaryArteries))
		{
			CoronaryArteries coronaryArteries = (CoronaryArteries) bioMightInstance;
			bioMightComponent.setImage(coronaryArteries.getImage());
			bioMightComponent.setWidth(coronaryArteries.getImageWidth());
			bioMightComponent.setHeight(coronaryArteries.getImageHeight());
			bioMightComponent.setBioMightProperties(coronaryArteries.getProperties());
			bioMightComponent.setBioMightMethods(coronaryArteries.getMethods());
			bioMightComponent.setBioMightCollection(true);
			
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for CoronaryArteries: "  + bioMightComponent +  "     ID: " + coronaryArteries.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(coronaryArteries.getComponentID());
			bioMightKeys.setKey(bioMightKey);
				
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing CoronaryArteries Methods!");
			//	coronaryArteries(methodParams);
			//	coronaryArteries(0);
			//}
			//System.out.println("Getting X3D for CoronaryArteries!");
			bioMightComponent.setX3D(coronaryArteries.getX3D(snippet));			
		}		
		else if (bioMightComponentRef.equals(Constants.CoronaryArtery))
		{
			CoronaryArtery coronaryArtery = (CoronaryArtery) bioMightInstance;
			bioMightComponent.setImage(coronaryArtery.getImage());
			bioMightComponent.setWidth(coronaryArtery.getImageWidth());
			bioMightComponent.setHeight(coronaryArtery.getImageHeight());
			bioMightComponent.setBioMightProperties(coronaryArtery.getProperties());
			bioMightComponent.setBioMightMethods(coronaryArtery.getMethods());

			
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for CoronaryArtery: "  + bioMightComponent +  "     ID: " + coronaryArtery.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(coronaryArtery.getComponentID());
			bioMightKeys.setKey(bioMightKey);
				
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing CoronaryArtery Methods!");
			//	coronaryArtery(methodParams);
			//	coronaryArtery(0);
			//}
			//System.out.println("Getting X3D for CoronaryArtery!");
			bioMightComponent.setX3D(coronaryArtery.getX3D(snippet));			
		}
		else if (bioMightComponentRef.equals(Constants.SubclavianArteries))
		{
			SubclavianArteries subclavianArteries = (SubclavianArteries) bioMightInstance;
			bioMightComponent.setImage(subclavianArteries.getImage());
			bioMightComponent.setWidth(subclavianArteries.getImageWidth());
			bioMightComponent.setHeight(subclavianArteries.getImageHeight());
			bioMightComponent.setBioMightProperties(subclavianArteries.getProperties());
			bioMightComponent.setBioMightMethods(subclavianArteries.getMethods());
			bioMightComponent.setBioMightCollection(true);
			
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for SubclavianArteries: "  + bioMightComponent +  "     ID: " + subclavianArteries.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(subclavianArteries.getComponentID());
			bioMightKeys.setKey(bioMightKey);
				
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing SubclavianArteries Methods!");
			//	subclavianArteries(methodParams);
			//	subclavianArteries(0);
			//}
			//System.out.println("Getting X3D for SubclavianArteries!");
			bioMightComponent.setX3D(subclavianArteries.getX3D(snippet));			
		}
		else if (bioMightComponentRef.equals(Constants.SubclavianArtery))
		{
			SubclavianArtery subclavianArtery = (SubclavianArtery) bioMightInstance;
			bioMightComponent.setImage(subclavianArtery.getImage());
			bioMightComponent.setWidth(subclavianArtery.getImageWidth());
			bioMightComponent.setHeight(subclavianArtery.getImageHeight());
			bioMightComponent.setBioMightProperties(subclavianArtery.getProperties());
			bioMightComponent.setBioMightMethods(subclavianArtery.getMethods());
			
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for SubclavianArtery: "  + bioMightComponent +  "     ID: " + subclavianArtery.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(subclavianArtery.getComponentID());
			bioMightKeys.setKey(bioMightKey);
				
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing SubclavianArtery Methods!");
			//	subclavianArtery(methodParams);
			//	subclavianArtery(0);
			//}
			//System.out.println("Getting X3D for SubclavianArtery!");
			bioMightComponent.setX3D(subclavianArtery.getX3D(snippet));			
		}
		else if (bioMightComponentRef.equals(Constants.PulmonaryArteries))
		{
			PulmonaryArteries pulmonaryArteries = (PulmonaryArteries) bioMightInstance;
			bioMightComponent.setImage(pulmonaryArteries.getImage());
			bioMightComponent.setWidth(pulmonaryArteries.getImageWidth());
			bioMightComponent.setHeight(pulmonaryArteries.getImageHeight());
			bioMightComponent.setBioMightProperties(pulmonaryArteries.getProperties());
			bioMightComponent.setBioMightMethods(pulmonaryArteries.getMethods());
			bioMightComponent.setBioMightCollection(true);
			
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for PulmonaryArteries: "  + bioMightComponent +  "     ID: " + pulmonaryArteries.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(pulmonaryArteries.getComponentID());
			bioMightKeys.setKey(bioMightKey);
				
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing PulmonaryArteries Methods!");
			//	subclavianArteries(methodParams);
			//	subclavianArteries(0);
			//}
			//System.out.println("Getting X3D for PulmonaryArteries!");
			bioMightComponent.setX3D(pulmonaryArteries.getX3D(snippet));			
		}
		else if (bioMightComponentRef.equals(Constants.PulmonaryArtery))
		{
			PulmonaryArtery pulmonaryArteries = (PulmonaryArtery) bioMightInstance;
			bioMightComponent.setImage(pulmonaryArteries.getImage());
			bioMightComponent.setWidth(pulmonaryArteries.getImageWidth());
			bioMightComponent.setHeight(pulmonaryArteries.getImageHeight());
			bioMightComponent.setBioMightProperties(pulmonaryArteries.getProperties());
			bioMightComponent.setBioMightMethods(pulmonaryArteries.getMethods());
			bioMightComponent.setBioMightCollection(true);
			
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for PulmonaryArtery: "  + bioMightComponent +  "     ID: " + pulmonaryArteries.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(pulmonaryArteries.getComponentID());
			bioMightKeys.setKey(bioMightKey);
				
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing PulmonaryArtery Methods!");
			//	subclavianArteries(methodParams);
			//	subclavianArteries(0);
			//}
			//System.out.println("Getting X3D for PulmonaryArtery!");
			bioMightComponent.setX3D(pulmonaryArteries.getX3D(snippet));			
		}
		else if (bioMightComponentRef.equals(Constants.ObtuseMarginalArtery))
		{
			ObtuseMarginalArtery obtuseMarginalArtery = (ObtuseMarginalArtery) bioMightInstance;
			bioMightComponent.setImage(obtuseMarginalArtery.getImage());
			bioMightComponent.setWidth(obtuseMarginalArtery.getImageWidth());
			bioMightComponent.setHeight(obtuseMarginalArtery.getImageHeight());
			bioMightComponent.setBioMightProperties(obtuseMarginalArtery.getProperties());
			bioMightComponent.setBioMightMethods(obtuseMarginalArtery.getMethods());
			bioMightComponent.setBioMightCollection(true);
			
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for ObtuseMarginalArtery: "  + bioMightComponent +  "     ID: " + obtuseMarginalArtery.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(obtuseMarginalArtery.getComponentID());
			bioMightKeys.setKey(bioMightKey);
				
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing ObtuseMarginalArtery Methods!");
			//	obtuseMarginalArtery(methodParams);
			//	obtuseMarginalArtery(0);
			//}
			//System.out.println("Getting X3D for ObtuseMarginalArtery!");
			bioMightComponent.setX3D(obtuseMarginalArtery.getX3D(snippet));			
		}
		else if (bioMightComponentRef.equals(Constants.SmallCardiacVein))
		{
			SmallCardiacVein smallCardiacVein = (SmallCardiacVein) bioMightInstance;
			bioMightComponent.setImage(smallCardiacVein.getImage());
			bioMightComponent.setWidth(smallCardiacVein.getImageWidth());
			bioMightComponent.setHeight(smallCardiacVein.getImageHeight());
			bioMightComponent.setBioMightProperties(smallCardiacVein.getProperties());
			bioMightComponent.setBioMightMethods(smallCardiacVein.getMethods());
			
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for SmallCardiacVein: "  + bioMightComponent +  "     ID: " + smallCardiacVein.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(smallCardiacVein.getComponentID());
			bioMightKeys.setKey(bioMightKey);
				
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing SmallCardiacVein Methods!");
			//	smallCardiacVein(methodParams);
			//	smallCardiacVein(0);
			//}
			//System.out.println("Getting X3D for SmallCardiacVein!");
			bioMightComponent.setX3D(smallCardiacVein.getX3D(snippet));			
		}
		
		else if (bioMightComponentRef.equals(Constants.BrachioCephalicArtery))
		{
			BrachioCephalicArtery brachioCephalicArtery = (BrachioCephalicArtery) bioMightInstance;
			bioMightComponent.setImage(brachioCephalicArtery.getImage());
			bioMightComponent.setWidth(brachioCephalicArtery.getImageWidth());
			bioMightComponent.setHeight(brachioCephalicArtery.getImageHeight());
			bioMightComponent.setBioMightProperties(brachioCephalicArtery.getProperties());
			bioMightComponent.setBioMightMethods(brachioCephalicArtery.getMethods());
			
			
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for BrachioCephalicArtery: "  + bioMightComponent +  "     ID: " + brachioCephalicArtery.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(brachioCephalicArtery.getComponentID());
			bioMightKeys.setKey(bioMightKey);
				
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing BrachioCephalicArtery Methods!");
			//	BrachioCephalicArtery(methodParams);
			//	BrachioCephalicArtery(0);
			//}
			//System.out.println("Getting X3D for BrachioCephalicArtery!");
			bioMightComponent.setX3D(brachioCephalicArtery.getX3D(snippet));			
		}
		else if (bioMightComponentRef.equals(Constants.RightCoronaryArtery))
		{
			RightCoronaryArtery rightCoronaryArtery = (RightCoronaryArtery) bioMightInstance;
			bioMightComponent.setImage(rightCoronaryArtery.getImage());
			//bioMightComponent.setBioMightProperties(rightCoronaryArtery.getProperties());
			//bioMightComponent.setBioMightMethods(rightCoronaryArtery.getMethods());
		}				
		else if (bioMightComponentRef.equals(Constants.LeftCoronaryArtery))
		{
			LeftCoronaryArtery leftCoronaryArtery = (LeftCoronaryArtery) bioMightInstance;
			bioMightComponent.setImage(leftCoronaryArtery.getImage());
			//bioMightComponent.setBioMightProperties(leftCoronaryArtery.getProperties());
			//bioMightComponent.setBioMightMethods(leftCoronaryArtery.getMethods());
		}

		else if (bioMightComponentRef.equals(Constants.GreatCardiacVein))
		{
			GreatCardiacVein greatCardiacVein = (GreatCardiacVein) bioMightInstance;
			bioMightComponent.setImage(greatCardiacVein.getImage());
			bioMightComponent.setWidth(greatCardiacVein.getImageWidth());
			bioMightComponent.setHeight(greatCardiacVein.getImageHeight());
			bioMightComponent.setBioMightProperties(greatCardiacVein.getProperties());
			bioMightComponent.setBioMightMethods(greatCardiacVein.getMethods());
			
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for GreatCardiacVein: "  + bioMightComponent +  "     ID: " + greatCardiacVein.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(greatCardiacVein.getComponentID());
			bioMightKeys.setKey(bioMightKey);
				
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing GreatCardiacVein Methods!");
			//	greatCardiacVein(methodParams);
			//	greatCardiacVein(0);
			//}
			//System.out.println("Getting X3D for GreatCardiacVein!");
			bioMightComponent.setX3D(greatCardiacVein.getX3D(snippet));			
		}
		else if (bioMightComponentRef.equals(Constants.SmallCardiacVein))
		{
			SmallCardiacVein smallCardiacVein = (SmallCardiacVein) bioMightInstance;
			bioMightComponent.setImage(smallCardiacVein.getImage());
			bioMightComponent.setWidth(smallCardiacVein.getImageWidth());
			bioMightComponent.setHeight(smallCardiacVein.getImageHeight());
			bioMightComponent.setBioMightProperties(smallCardiacVein.getProperties());
			bioMightComponent.setBioMightMethods(smallCardiacVein.getMethods());
			
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for SmallCardiacVein: "  + bioMightComponent +  "     ID: " + smallCardiacVein.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(smallCardiacVein.getComponentID());
			bioMightKeys.setKey(bioMightKey);
				
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing SmallCardiacVein Methods!");
			//	smallCardiacVein(methodParams);
			//	smallCardiacVein(0);
			//}
			//System.out.println("Getting X3D for SmallCardiacVein!");
			bioMightComponent.setX3D(smallCardiacVein.getX3D(snippet));			
		}			
		else if (bioMightComponentRef.equals(Constants.ThoracicArteries))
		{
			ThoracicArteries thoracicArteries = (ThoracicArteries) bioMightInstance;
			bioMightComponent.setImage(thoracicArteries.getImage());
			bioMightComponent.setWidth(thoracicArteries.getImageWidth());
			bioMightComponent.setHeight(thoracicArteries.getImageHeight());
			bioMightComponent.setBioMightProperties(thoracicArteries.getProperties());
			bioMightComponent.setBioMightMethods(thoracicArteries.getMethods());
			bioMightComponent.setBioMightCollection(true);
			
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for ThoracicArteries: "  + bioMightComponent +  "     ID: " + thoracicArteries.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(thoracicArteries.getComponentID());
			bioMightKeys.setKey(bioMightKey);
				
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing ThoracicArteries Methods!");
			//	subclavianArteries(methodParams);
			//	subclavianArteries(0);
			//}
			//System.out.println("Getting X3D for ThoracicArteries!");
			bioMightComponent.setX3D(thoracicArteries.getX3D(snippet));			
		}
		else if (bioMightComponentRef.equals(Constants.ThoracicArtery))
		{
			ThoracicArtery thoracicArtery = (ThoracicArtery) bioMightInstance;
			bioMightComponent.setImage(thoracicArtery.getImage());
			bioMightComponent.setWidth(thoracicArtery.getImageWidth());
			bioMightComponent.setHeight(thoracicArtery.getImageHeight());
			bioMightComponent.setBioMightProperties(thoracicArtery.getProperties());
			bioMightComponent.setBioMightMethods(thoracicArtery.getMethods());
		
			
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for ThoracicArteries: "  + bioMightComponent +  "     ID: " + thoracicArtery.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(thoracicArtery.getComponentID());
			bioMightKeys.setKey(bioMightKey);
				
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing ThoracicArteries Methods!");
			//	thoracicArtery(methodParams);
			//	thoracicArtery(0);
			//}
			//System.out.println("Getting X3D for ThoracicArteries!");
			bioMightComponent.setX3D(thoracicArtery.getX3D(snippet));			
		}
		else if (bioMightComponentRef.equals(Constants.DigitalArtery))
		{
			DigitalArtery digitalArtery = (DigitalArtery) bioMightInstance;
			bioMightComponent.setImage(digitalArtery.getImage());
			bioMightComponent.setBioMightProperties(digitalArtery.getProperties());
			bioMightComponent.setBioMightMethods(digitalArtery.getMethods());
			bioMightComponent.setBioMightCollection(false);
		
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for DigitalArtery: "  + bioMightComponent +  "  ID: " + digitalArtery.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(digitalArtery.getComponentID());
			bioMightKeys.setKey(bioMightKey);
		
			// On the post of data, we map the web data back
			// into the methodView object.  
			if (executeMethods) {
				//System.out.println("Executing Ulna Methods!");
				//digitalArtery.executeMethods(methodParams);
				//System.out.println("Redrawing Ulna!");
				//digitalArtery.redraw(0);
			}
			bioMightComponent.setX3D(digitalArtery.getX3D(snippet));
		}
		else if (bioMightComponentRef.equals(Constants.InnominateVeins))
		{
			InnominateVeins innominateVeins = (InnominateVeins) bioMightInstance;
			bioMightComponent.setImage(innominateVeins.getImage());
			bioMightComponent.setWidth(innominateVeins.getImageWidth());
			bioMightComponent.setHeight(innominateVeins.getImageHeight());
			bioMightComponent.setBioMightProperties(innominateVeins.getProperties());
			bioMightComponent.setBioMightMethods(innominateVeins.getMethods());
			bioMightComponent.setBioMightCollection(true);
			
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for InnominateVeins: "  + bioMightComponent +  "     ID: " + innominateVeins.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(innominateVeins.getComponentID());
			bioMightKeys.setKey(bioMightKey);
				
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing InnominateVeins Methods!");
			//	innominateVeins(methodParams);
			//	innominateVeins(0);
			//}
			//System.out.println("Getting X3D for InnominateVeins!");
			bioMightComponent.setX3D(innominateVeins.getX3D(snippet));			
		}
		else if (bioMightComponentRef.equals(Constants.InnominateVein))
		{
			InnominateVein innominateVein = (InnominateVein) bioMightInstance;
			bioMightComponent.setImage(innominateVein.getImage());
			bioMightComponent.setWidth(innominateVein.getImageWidth());
			bioMightComponent.setHeight(innominateVein.getImageHeight());
			bioMightComponent.setBioMightProperties(innominateVein.getProperties());
			bioMightComponent.setBioMightMethods(innominateVein.getMethods());
			bioMightComponent.setBioMightCollection(true);
			
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for InnominateVein: "  + bioMightComponent +  "     ID: " + innominateVein.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(innominateVein.getComponentID());
			bioMightKeys.setKey(bioMightKey);
				
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing InnominateVein Methods!");
			//	innominateVein(methodParams);
			//	innominateVein(0);
			//}
			//System.out.println("Getting X3D for InnominateVein!");
			bioMightComponent.setX3D(innominateVein.getX3D(snippet));			
		}
		else if (bioMightComponentRef.equals(Constants.PulmonaryVeins))
		{
			PulmonaryVeins pulmonaryVeins = (PulmonaryVeins) bioMightInstance;
			bioMightComponent.setImage(pulmonaryVeins.getImage());
			bioMightComponent.setWidth(pulmonaryVeins.getImageWidth());
			bioMightComponent.setHeight(pulmonaryVeins.getImageHeight());
			bioMightComponent.setBioMightProperties(pulmonaryVeins.getProperties());
			bioMightComponent.setBioMightMethods(pulmonaryVeins.getMethods());
			bioMightComponent.setBioMightCollection(true);
			
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for PulmonaryVeins: "  + bioMightComponent +  "     ID: " + pulmonaryVeins.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(pulmonaryVeins.getComponentID());
			bioMightKeys.setKey(bioMightKey);
				
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing PulmonaryVeins Methods!");
			//	pulmonaryVeins(methodParams);
			//	pulmonaryVeins(0);
			//}
			//System.out.println("Getting X3D for PulmonaryVeins!");
			bioMightComponent.setX3D(pulmonaryVeins.getX3D(snippet));			
		}	
		else if (bioMightComponentRef.equals(Constants.PulmonaryVein))
		{
			PulmonaryVein pulmonaryVein = (PulmonaryVein) bioMightInstance;
			bioMightComponent.setImage(pulmonaryVein.getImage());
			bioMightComponent.setWidth(pulmonaryVein.getImageWidth());
			bioMightComponent.setHeight(pulmonaryVein.getImageHeight());
			bioMightComponent.setBioMightProperties(pulmonaryVein.getProperties());
			bioMightComponent.setBioMightMethods(pulmonaryVein.getMethods());
			bioMightComponent.setBioMightCollection(true);
			
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for PulmonaryVein: "  + bioMightComponent +  "     ID: " + pulmonaryVein.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(pulmonaryVein.getComponentID());
			bioMightKeys.setKey(bioMightKey);
				
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing PulmonaryVeins Methods!");
			//	pulmonaryVein(methodParams);
			//	pulmonaryVein(0);
			//}
			//System.out.println("Getting X3D for PulmonaryVein!");
			bioMightComponent.setX3D(pulmonaryVein.getX3D(snippet));			
		}
		else if (bioMightComponentRef.equals(Constants.SubclavianVeins))
		{
			SubclavianVeins subclavianVeins = (SubclavianVeins) bioMightInstance;
			bioMightComponent.setImage(subclavianVeins.getImage());
			bioMightComponent.setWidth(subclavianVeins.getImageWidth());
			bioMightComponent.setHeight(subclavianVeins.getImageHeight());
			bioMightComponent.setBioMightProperties(subclavianVeins.getProperties());
			bioMightComponent.setBioMightMethods(subclavianVeins.getMethods());
			bioMightComponent.setBioMightCollection(true);
			
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for SubclavianVeins: "  + bioMightComponent +  "     ID: " + subclavianVeins.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(subclavianVeins.getComponentID());
			bioMightKeys.setKey(bioMightKey);
				
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing SubclavianVeins Methods!");
			//	subclavianVeins(methodParams);
			//	subclavianVeins(0);
			//}
			//System.out.println("Getting X3D for SubClavianVeins!");
			bioMightComponent.setX3D(subclavianVeins.getX3D(snippet));			
		}
		else if (bioMightComponentRef.equals(Constants.SubclavianVein))
		{
			SubclavianVein subclavianVein = (SubclavianVein) bioMightInstance;
			bioMightComponent.setImage(subclavianVein.getImage());
			bioMightComponent.setWidth(subclavianVein.getImageWidth());
			bioMightComponent.setHeight(subclavianVein.getImageHeight());
			bioMightComponent.setBioMightProperties(subclavianVein.getProperties());
			bioMightComponent.setBioMightMethods(subclavianVein.getMethods());
			bioMightComponent.setBioMightCollection(true);
			
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for SubClavianVeins: "  + bioMightComponent +  "     ID: " + subclavianVein.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(subclavianVein.getComponentID());
			bioMightKeys.setKey(bioMightKey);
				
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing SubClavianVeins Methods!");
			//	subClavianVeins(methodParams);
			//	subClavianVeins(0);
			//}
			//System.out.println("Getting X3D for SubClavianVeins!");
			bioMightComponent.setX3D(subclavianVein.getX3D(snippet));			
		}
		
/*
//private LeftCoronaryArtery leftCoronaryArtery;
//private LeftMainCoronaryArtery leftMainCoronaryArtery;
private RightCoronaryArtery rightCoronaryArtery;
*/
		
		/**************************************************************************
		*
		* VASCULATURE OF THEE ABDOMEN 
		*
		* This section maps the data in the biomight object into the presentation 
		* layer.  
		*  
		***************************************************************************/


		else if (bioMightComponentRef.equals(Constants.AdrenalArteries))
		{
			AdrenalArteries adrenalArteries = (AdrenalArteries) bioMightInstance;
			bioMightComponent.setImage(adrenalArteries.getImage());
			bioMightComponent.setWidth(adrenalArteries.getImageWidth());
			bioMightComponent.setHeight(adrenalArteries.getImageHeight());
			bioMightComponent.setBioMightProperties(adrenalArteries.getProperties());
			bioMightComponent.setBioMightMethods(adrenalArteries.getMethods());
			bioMightComponent.setBioMightCollection(true);
			
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for AdrenalArteries: "  + bioMightComponent +  "     ID: " + adrenalArteries.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(adrenalArteries.getComponentID());
			bioMightKeys.setKey(bioMightKey);
				
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing AdrenalArteries Methods!");
			//	adrenalArteries(methodParams);
			//	adrenalArteries(0);
			//}
			//System.out.println("Getting X3D for AdrenalArteries!");
			bioMightComponent.setX3D(adrenalArteries.getX3D(snippet));			
		}
		else if (bioMightComponentRef.equals(Constants.AdrenalArtery))
		{
			AdrenalArtery adrenalArtery = (AdrenalArtery) bioMightInstance;
			bioMightComponent.setImage(adrenalArtery.getImage());
			bioMightComponent.setWidth(adrenalArtery.getImageWidth());
			bioMightComponent.setHeight(adrenalArtery.getImageHeight());
			bioMightComponent.setBioMightProperties(adrenalArtery.getProperties());
			bioMightComponent.setBioMightMethods(adrenalArtery.getMethods());
			bioMightComponent.setBioMightCollection(true);
			
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for AdrenalArtery: "  + bioMightComponent +  "     ID: " + adrenalArtery.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(adrenalArtery.getComponentID());
			bioMightKeys.setKey(bioMightKey);
				
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing AdrenalArtery Methods!");
			//	adrenalArtery(methodParams);
			//	adrenalArtery(0);
			//}
			//System.out.println("Getting X3D for AdrenalArtery!");
			bioMightComponent.setX3D(adrenalArtery.getX3D(snippet));			
		}		
		else if (bioMightComponentRef.equals(Constants.ColicVeins))
		{
			ColicVeins colicVeins = (ColicVeins) bioMightInstance;
			bioMightComponent.setImage(colicVeins.getImage());
			bioMightComponent.setWidth(colicVeins.getImageWidth());
			bioMightComponent.setHeight(colicVeins.getImageHeight());
			bioMightComponent.setBioMightProperties(colicVeins.getProperties());
			bioMightComponent.setBioMightMethods(colicVeins.getMethods());
			bioMightComponent.setBioMightCollection(true);
			
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for ColicVeins: "  + bioMightComponent +  "     ID: " + colicVeins.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(colicVeins.getComponentID());
			bioMightKeys.setKey(bioMightKey);
				
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing CysticVeins Methods!");
			//	colicVeins(methodParams);
			//	colicVeins(0);
			//}
			//System.out.println("Getting X3D for ColicVeins!");
			bioMightComponent.setX3D(colicVeins.getX3D(snippet));			
		}
		else if (bioMightComponentRef.equals(Constants.ColicVein))
		{
			ColicVein colicVein = (ColicVein) bioMightInstance;
			bioMightComponent.setImage(colicVein.getImage());
			bioMightComponent.setWidth(colicVein.getImageWidth());
			bioMightComponent.setHeight(colicVein.getImageHeight());
			bioMightComponent.setBioMightProperties(colicVein.getProperties());
			bioMightComponent.setBioMightMethods(colicVein.getMethods());
			bioMightComponent.setBioMightCollection(true);
			
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for ColicVeins: "  + bioMightComponent +  "     ID: " + colicVein.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(colicVein.getComponentID());
			bioMightKeys.setKey(bioMightKey);
				
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing CysticVeins Methods!");
			//	colicVein(methodParams);
			//	colicVein(0);
			//}
			//System.out.println("Getting X3D for ColicVein!");
			bioMightComponent.setX3D(colicVein.getX3D(snippet));			
		}
		else if (bioMightComponentRef.equals(Constants.CysticVein))
		{
			CysticVein cysticVein = (CysticVein) bioMightInstance;
			bioMightComponent.setImage(cysticVein.getImage());
			bioMightComponent.setWidth(cysticVein.getImageWidth());
			bioMightComponent.setHeight(cysticVein.getImageHeight());
			bioMightComponent.setBioMightProperties(cysticVein.getProperties());
			bioMightComponent.setBioMightMethods(cysticVein.getMethods());
			bioMightComponent.setBioMightCollection(true);
			
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for CysticVein: "  + bioMightComponent +  "     ID: " + cysticVein.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(cysticVein.getComponentID());
			bioMightKeys.setKey(bioMightKey);
				
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing CysticVein Methods!");
			//	cysticVein(methodParams);
			//	cysticVein(0);
			//}
			//System.out.println("Getting X3D for CysticVein!");
			bioMightComponent.setX3D(cysticVein.getX3D(snippet));			
		}
		else if (bioMightComponentRef.equals(Constants.GastroEpiploicVein))
		{
			GastroEpiploicVein gastroEpiploicVein = (GastroEpiploicVein) bioMightInstance;
			bioMightComponent.setImage(gastroEpiploicVein.getImage());
			bioMightComponent.setWidth(gastroEpiploicVein.getImageWidth());
			bioMightComponent.setHeight(gastroEpiploicVein.getImageHeight());
			bioMightComponent.setBioMightProperties(gastroEpiploicVein.getProperties());
			bioMightComponent.setBioMightMethods(gastroEpiploicVein.getMethods());
			bioMightComponent.setBioMightCollection(true);
			
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for GastroEpiploicVein: "  + bioMightComponent +  "     ID: " + gastroEpiploicVein.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(gastroEpiploicVein.getComponentID());
			bioMightKeys.setKey(bioMightKey);
				
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing GastroEpiploicVein Methods!");
			//	gastroEpiploicVein(methodParams);
			//	gastroEpiploicVein(0);
			//}
			//System.out.println("Getting X3D for GastroEpiploicVein!");
			bioMightComponent.setX3D(gastroEpiploicVein.getX3D(snippet));			
		}
		else if (bioMightComponentRef.equals(Constants.GastroEpiploicVeins))
		{
			GastroEpiploicVeins gastroEpiploicVeins = (GastroEpiploicVeins) bioMightInstance;
			bioMightComponent.setImage(gastroEpiploicVeins.getImage());
			bioMightComponent.setWidth(gastroEpiploicVeins.getImageWidth());
			bioMightComponent.setHeight(gastroEpiploicVeins.getImageHeight());
			bioMightComponent.setBioMightProperties(gastroEpiploicVeins.getProperties());
			bioMightComponent.setBioMightMethods(gastroEpiploicVeins.getMethods());
			bioMightComponent.setBioMightCollection(true);
			
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for GastroEpiploicVeins: "  + bioMightComponent +  "     ID: " + gastroEpiploicVeins.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(gastroEpiploicVeins.getComponentID());
			bioMightKeys.setKey(bioMightKey);
				
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing GastroEpiploicVein Methods!");
			//	gastroEpiploicVeins(methodParams);
			//	gastroEpiploicVeins(0);
			//}
			//System.out.println("Getting X3D for GastroEpiploicVein!");
			bioMightComponent.setX3D(gastroEpiploicVeins.getX3D(snippet));			
		}
		else if (bioMightComponentRef.equals(Constants.HemiazygosVein))
		{
			HemiazygosVein hemiazygosVein = (HemiazygosVein) bioMightInstance;
			bioMightComponent.setImage(hemiazygosVein.getImage());
			bioMightComponent.setWidth(hemiazygosVein.getImageWidth());
			bioMightComponent.setHeight(hemiazygosVein.getImageHeight());
			bioMightComponent.setBioMightProperties(hemiazygosVein.getProperties());
			bioMightComponent.setBioMightMethods(hemiazygosVein.getMethods());
			bioMightComponent.setBioMightCollection(true);
			
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for HemiazygosVein: "  + bioMightComponent +  "     ID: " + hemiazygosVein.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(hemiazygosVein.getComponentID());
			bioMightKeys.setKey(bioMightKey);
				
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing HemiazygosVein Methods!");
			//	hemiazygosVein(methodParams);
			//	hemiazygosVein(0);
			//}
			//System.out.println("Getting X3D for HemiazygosVein!");
			bioMightComponent.setX3D(hemiazygosVein.getX3D(snippet));			
		}
		else if (bioMightComponentRef.equals(Constants.HepaticPortalVein))
		{
			HepaticPortalVein hepaticPortalVein = (HepaticPortalVein) bioMightInstance;
			bioMightComponent.setImage(hepaticPortalVein.getImage());
			bioMightComponent.setWidth(hepaticPortalVein.getImageWidth());
			bioMightComponent.setHeight(hepaticPortalVein.getImageHeight());
			bioMightComponent.setBioMightProperties(hepaticPortalVein.getProperties());
			bioMightComponent.setBioMightMethods(hepaticPortalVein.getMethods());
			
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for HepaticPortalVein: "  + bioMightComponent +  "     ID: " + hepaticPortalVein.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(hepaticPortalVein.getComponentID());
			bioMightKeys.setKey(bioMightKey);
				
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing HepaticPortalVein Methods!");
			//	hepaticPortalVein(methodParams);
			//	hepaticPortalVein(0);
			//}
			//System.out.println("Getting X3D for HepaticPortalVein!");
			bioMightComponent.setX3D(hepaticPortalVein.getX3D(snippet));			
		}
		else if (bioMightComponentRef.equals(Constants.HepaticVein))
		{
			HepaticVein hepaticVein = (HepaticVein) bioMightInstance;
			bioMightComponent.setImage(hepaticVein.getImage());
			bioMightComponent.setWidth(hepaticVein.getImageWidth());
			bioMightComponent.setHeight(hepaticVein.getImageHeight());
			bioMightComponent.setBioMightProperties(hepaticVein.getProperties());
			bioMightComponent.setBioMightMethods(hepaticVein.getMethods());
			bioMightComponent.setBioMightCollection(true);
			
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for HepaticVein: "  + bioMightComponent +  "     ID: " + hepaticVein.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(hepaticVein.getComponentID());
			bioMightKeys.setKey(bioMightKey);
				
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing HepaticVein Methods!");
			//	hepaticVein(methodParams);
			//	hepaticVein(0);
			//}
			//System.out.println("Getting X3D for HepaticVein!");
			bioMightComponent.setX3D(hepaticVein.getX3D(snippet));			
		}
		else if (bioMightComponentRef.equals(Constants.IleocolicVein))
		{
			IleocolicVein ileocolicVein = (IleocolicVein) bioMightInstance;
			bioMightComponent.setImage(ileocolicVein.getImage());
			bioMightComponent.setWidth(ileocolicVein.getImageWidth());
			bioMightComponent.setHeight(ileocolicVein.getImageHeight());
			bioMightComponent.setBioMightProperties(ileocolicVein.getProperties());
			bioMightComponent.setBioMightMethods(ileocolicVein.getMethods());
			bioMightComponent.setBioMightCollection(true);
			
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for IleocolicVein: "  + bioMightComponent +  "     ID: " + ileocolicVein.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(ileocolicVein.getComponentID());
			bioMightKeys.setKey(bioMightKey);
				
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing IleocolicVein Methods!");
			//	ileocolicVein(methodParams);
			//	ileocolicVein(0);
			//}
			//System.out.println("Getting X3D for IleocolicVein!");
			bioMightComponent.setX3D(ileocolicVein.getX3D(snippet));			
		}
		else if (bioMightComponentRef.equals(Constants.IliolumbarVein))
		{
			IliolumbarVein iliolumbarVein = (IliolumbarVein) bioMightInstance;
			bioMightComponent.setImage(iliolumbarVein.getImage());
			bioMightComponent.setWidth(iliolumbarVein.getImageWidth());
			bioMightComponent.setHeight(iliolumbarVein.getImageHeight());
			bioMightComponent.setBioMightProperties(iliolumbarVein.getProperties());
			bioMightComponent.setBioMightMethods(iliolumbarVein.getMethods());
			bioMightComponent.setBioMightCollection(true);
			
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for IliolumbarVein: "  + bioMightComponent +  "     ID: " + iliolumbarVein.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(iliolumbarVein.getComponentID());
			bioMightKeys.setKey(bioMightKey);
				
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing IliolumbarVein Methods!");
			//	iliolumbarVein(methodParams);
			//	iliolumbarVein(0);
			//}
			//System.out.println("Getting X3D for IliolumbarVein!");
			bioMightComponent.setX3D(iliolumbarVein.getX3D(snippet));			
		}
		else if (bioMightComponentRef.equals(Constants.InferiorEpigastricVeins))
		{
			InferiorEpigastricVeins inferiorEpigastricVeins = (InferiorEpigastricVeins) bioMightInstance;
			bioMightComponent.setImage(inferiorEpigastricVeins.getImage());
			bioMightComponent.setWidth(inferiorEpigastricVeins.getImageWidth());
			bioMightComponent.setHeight(inferiorEpigastricVeins.getImageHeight());
			bioMightComponent.setBioMightProperties(inferiorEpigastricVeins.getProperties());
			bioMightComponent.setBioMightMethods(inferiorEpigastricVeins.getMethods());
			bioMightComponent.setBioMightCollection(true);
			
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for InferiorEpigastricVeins: "  + bioMightComponent +  "     ID: " + inferiorEpigastricVeins.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(inferiorEpigastricVeins.getComponentID());
			bioMightKeys.setKey(bioMightKey);
				
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing InferiorEpigastricVeins Methods!");
			//	inferiorEpigastricVeins(methodParams);
			//	inferiorEpigastricVeins(0);
			//}
			//System.out.println("Getting X3D for InferiorEpigastricVeins!");
			bioMightComponent.setX3D(inferiorEpigastricVeins.getX3D(snippet));			
		}
		else if (bioMightComponentRef.equals(Constants.InferiorEpigastricVein))
		{
			InferiorEpigastricVein inferiorEpigastricVein = (InferiorEpigastricVein) bioMightInstance;
			bioMightComponent.setImage(inferiorEpigastricVein.getImage());
			bioMightComponent.setWidth(inferiorEpigastricVein.getImageWidth());
			bioMightComponent.setHeight(inferiorEpigastricVein.getImageHeight());
			bioMightComponent.setBioMightProperties(inferiorEpigastricVein.getProperties());
			bioMightComponent.setBioMightMethods(inferiorEpigastricVein.getMethods());
			
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for InferiorEpigastricVeins: "  + bioMightComponent +  "     ID: " + inferiorEpigastricVein.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(inferiorEpigastricVein.getComponentID());
			bioMightKeys.setKey(bioMightKey);
				
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing InferiorEpigastricVeins Methods!");
			//	inferiorEpigastricVeins(methodParams);
			//	inferiorEpigastricVeins(0);
			//}
			//System.out.println("Getting X3D for InferiorEpigastricVein!");
			bioMightComponent.setX3D(inferiorEpigastricVein.getX3D(snippet));			
		}		
		else if (bioMightComponentRef.equals(Constants.LiverCentralVeins))
		{
			LiverCentralVeins liverCentralVeins = (LiverCentralVeins) bioMightInstance;
			bioMightComponent.setImage(liverCentralVeins.getImage());
			bioMightComponent.setWidth(liverCentralVeins.getImageWidth());
			bioMightComponent.setHeight(liverCentralVeins.getImageHeight());
			bioMightComponent.setBioMightProperties(liverCentralVeins.getProperties());
			bioMightComponent.setBioMightMethods(liverCentralVeins.getMethods());
			bioMightComponent.setBioMightCollection(true);
			
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for LiverCentralVeins: "  + bioMightComponent +  "     ID: " + liverCentralVeins.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(liverCentralVeins.getComponentID());
			bioMightKeys.setKey(bioMightKey);
				
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing LiverCentralVeins Methods!");
			//	liverCentralVeins(methodParams);
			//	liverCentralVeins(0);
			//}
			//System.out.println("Getting X3D for LiverCentralVeins!");
			bioMightComponent.setX3D(liverCentralVeins.getX3D(snippet));			
		}

		else if (bioMightComponentRef.equals(Constants.LiverCentralVein))
		{
			LiverCentralVein liverCentralVein = (LiverCentralVein) bioMightInstance;
			bioMightComponent.setImage(liverCentralVein.getImage());
			bioMightComponent.setWidth(liverCentralVein.getImageWidth());
			bioMightComponent.setHeight(liverCentralVein.getImageHeight());
			bioMightComponent.setBioMightProperties(liverCentralVein.getProperties());
			bioMightComponent.setBioMightMethods(liverCentralVein.getMethods());
			bioMightComponent.setBioMightCollection(true);
			
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for LiverCentralVein: "  + bioMightComponent +  "     ID: " + liverCentralVein.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(liverCentralVein.getComponentID());
			bioMightKeys.setKey(bioMightKey);
				
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing LiverCentralVein Methods!");
			//	liverCentralVein(methodParams);
			//	liverCentralVein(0);
			//}
			//System.out.println("Getting X3D for LiverCentralVein!");
			bioMightComponent.setX3D(liverCentralVein.getX3D(snippet));			
		}	
		else if (bioMightComponentRef.equals(Constants.OvarianVein))
		{
			OvarianVein ovarianVein = (OvarianVein) bioMightInstance;
			bioMightComponent.setImage(ovarianVein.getImage());
			bioMightComponent.setWidth(ovarianVein.getImageWidth());
			bioMightComponent.setHeight(ovarianVein.getImageHeight());
			bioMightComponent.setBioMightProperties(ovarianVein.getProperties());
			bioMightComponent.setBioMightMethods(ovarianVein.getMethods());
			
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for OvarianVein: "  + bioMightComponent +  "     ID: " + ovarianVein.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(ovarianVein.getComponentID());
			bioMightKeys.setKey(bioMightKey);
				
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing OvarianVein Methods!");
			//	cysticVein(methodParams);
			//	cysticVein(0);
			//}
			//System.out.println("Getting X3D for OvarianVein!");
			bioMightComponent.setX3D(ovarianVein.getX3D(snippet));			
		}
		else if (bioMightComponentRef.equals(Constants.PancreaticoDuodenalVeins))
		{
			PancreaticoDuodenalVeins pancreaticoDuodenalVeins = (PancreaticoDuodenalVeins) bioMightInstance;
			bioMightComponent.setImage(pancreaticoDuodenalVeins.getImage());
			bioMightComponent.setWidth(pancreaticoDuodenalVeins.getImageWidth());
			bioMightComponent.setHeight(pancreaticoDuodenalVeins.getImageHeight());
			bioMightComponent.setBioMightProperties(pancreaticoDuodenalVeins.getProperties());
			bioMightComponent.setBioMightMethods(pancreaticoDuodenalVeins.getMethods());
			bioMightComponent.setBioMightCollection(true);
			
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for PancreaticoDuodenalVeins: "  + bioMightComponent +  "     ID: " + pancreaticoDuodenalVeins.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(pancreaticoDuodenalVeins.getComponentID());
			bioMightKeys.setKey(bioMightKey);
				
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing PancreaticoDuodenalVeins Methods!");
			//	pancreaticoDuodenalVeins(methodParams);
			//	pancreaticoDuodenalVeins(0);
			//}
			//System.out.println("Getting X3D for PancreaticoDuodenalVeins!");
			bioMightComponent.setX3D(pancreaticoDuodenalVeins.getX3D(snippet));			
		}
		else if (bioMightComponentRef.equals(Constants.PancreaticoDuodenalVein))
		{
			PancreaticoDuodenalVein pancreaticoDuodenalVein = (PancreaticoDuodenalVein) bioMightInstance;
			bioMightComponent.setImage(pancreaticoDuodenalVein.getImage());
			bioMightComponent.setWidth(pancreaticoDuodenalVein.getImageWidth());
			bioMightComponent.setHeight(pancreaticoDuodenalVein.getImageHeight());
			bioMightComponent.setBioMightProperties(pancreaticoDuodenalVein.getProperties());
			bioMightComponent.setBioMightMethods(pancreaticoDuodenalVein.getMethods());
			bioMightComponent.setBioMightCollection(true);
			
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for PancreaticoDuodenalVein: "  + bioMightComponent +  "     ID: " + pancreaticoDuodenalVein.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(pancreaticoDuodenalVein.getComponentID());
			bioMightKeys.setKey(bioMightKey);
				
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing PancreaticoDuodenalVein Methods!");
			//	pancreaticoDuodenalVein(methodParams);
			//	pancreaticoDuodenalVein(0);
			//}
			//System.out.println("Getting X3D for PancreaticoDuodenalVein!");
			bioMightComponent.setX3D(pancreaticoDuodenalVein.getX3D(snippet));			
		}
		else if (bioMightComponentRef.equals(Constants.RenalVeins))
		{
			RenalVeins renalVeins = (RenalVeins) bioMightInstance;
			bioMightComponent.setImage(renalVeins.getImage());
			bioMightComponent.setWidth(renalVeins.getImageWidth());
			bioMightComponent.setHeight(renalVeins.getImageHeight());
			bioMightComponent.setBioMightProperties(renalVeins.getProperties());
			bioMightComponent.setBioMightMethods(renalVeins.getMethods());
			
			
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for RenalVeins: "  + bioMightComponent +  "     ID: " + renalVeins.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(renalVeins.getComponentID());
			bioMightKeys.setKey(bioMightKey);
				
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing RenalVeins Methods!");
			//	renalVeins(methodParams);
			//	renalVeins(0);
			//}
			//System.out.println("Getting X3D for RenalVeins!");
			bioMightComponent.setX3D(renalVeins.getX3D(snippet));			
		}
		else if (bioMightComponentRef.equals(Constants.RenalVein))
		{
			RenalVein renalVein = (RenalVein) bioMightInstance;
			bioMightComponent.setImage(renalVein.getImage());
			bioMightComponent.setWidth(renalVein.getImageWidth());
			bioMightComponent.setHeight(renalVein.getImageHeight());
			bioMightComponent.setBioMightProperties(renalVein.getProperties());
			bioMightComponent.setBioMightMethods(renalVein.getMethods());
			
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for RenalVein: "  + bioMightComponent +  "     ID: " + renalVein.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(renalVein.getComponentID());
			bioMightKeys.setKey(bioMightKey);
				
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing RenalVein Methods!");
			//	renalVein(methodParams);
			//	renalVein(0);
			//}
			//System.out.println("Getting X3D for RenalVein!");
			bioMightComponent.setX3D(renalVein.getX3D(snippet));			
		}
		else if (bioMightComponentRef.equals(Constants.RetroperitonealVeins))
		{
			RetroperitonealVeins retroperitonealVeins = (RetroperitonealVeins) bioMightInstance;
			bioMightComponent.setImage(retroperitonealVeins.getImage());
			bioMightComponent.setWidth(retroperitonealVeins.getImageWidth());
			bioMightComponent.setHeight(retroperitonealVeins.getImageHeight());
			bioMightComponent.setBioMightProperties(retroperitonealVeins.getProperties());
			bioMightComponent.setBioMightMethods(retroperitonealVeins.getMethods());
			bioMightComponent.setBioMightCollection(true);
			
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for RetroperitonealVeins: "  + bioMightComponent +  "     ID: " + retroperitonealVeins.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(retroperitonealVeins.getComponentID());
			bioMightKeys.setKey(bioMightKey);
				
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing RetroperitonealVeins Methods!");
			//	retroperitonealVeins(methodParams);
			//	retroperitonealVeins(0);
			//}
			//System.out.println("Getting X3D for RetroperitonealVeins!");
			bioMightComponent.setX3D(retroperitonealVeins.getX3D(snippet));			
		}
		else if (bioMightComponentRef.equals(Constants.RetroperitonealVein))
		{
			RetroperitonealVein retroperitonealVein = (RetroperitonealVein) bioMightInstance;
			bioMightComponent.setImage(retroperitonealVein.getImage());
			bioMightComponent.setWidth(retroperitonealVein.getImageWidth());
			bioMightComponent.setHeight(retroperitonealVein.getImageHeight());
			bioMightComponent.setBioMightProperties(retroperitonealVein.getProperties());
			bioMightComponent.setBioMightMethods(retroperitonealVein.getMethods());
			bioMightComponent.setBioMightCollection(true);
			
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for RetroperitonealVein: "  + bioMightComponent +  "     ID: " + retroperitonealVein.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(retroperitonealVein.getComponentID());
			bioMightKeys.setKey(bioMightKey);
				
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing RetroperitonealVeins Methods!");
			//	retroperitonealVein(methodParams);
			//	retroperitonealVein(0);
			//}
			//System.out.println("Getting X3D for RetroperitonealVeins!");
			bioMightComponent.setX3D(retroperitonealVein.getX3D(snippet));			
		}
		else if (bioMightComponentRef.equals(Constants.SpleenCentralArteries))
		{
			SpleenCentralArteries spleenCentralArteries = (SpleenCentralArteries) bioMightInstance;
			bioMightComponent.setImage(spleenCentralArteries.getImage());
			bioMightComponent.setWidth(spleenCentralArteries.getImageWidth());
			bioMightComponent.setHeight(spleenCentralArteries.getImageHeight());
			bioMightComponent.setBioMightProperties(spleenCentralArteries.getProperties());
			bioMightComponent.setBioMightMethods(spleenCentralArteries.getMethods());
			bioMightComponent.setBioMightCollection(true);
			
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for SpleenCentralArteries: "  + bioMightComponent +  "     ID: " + spleenCentralArteries.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(spleenCentralArteries.getComponentID());
			bioMightKeys.setKey(bioMightKey);
				
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing SpleenCentralArteries Methods!");
			//	spleenCentralArteries(methodParams);
			//	spleenCentralArteries(0);
			//}
			//System.out.println("Getting X3D for SpleenCentralArteries!");
			bioMightComponent.setX3D(spleenCentralArteries.getX3D(snippet));			
		}
		else if (bioMightComponentRef.equals(Constants.SpleenCentralArtery))
		{
			SpleenCentralArtery spleenCentralArtery = (SpleenCentralArtery) bioMightInstance;
			bioMightComponent.setImage(spleenCentralArtery.getImage());
			bioMightComponent.setWidth(spleenCentralArtery.getImageWidth());
			bioMightComponent.setHeight(spleenCentralArtery.getImageHeight());
			bioMightComponent.setBioMightProperties(spleenCentralArtery.getProperties());
			bioMightComponent.setBioMightMethods(spleenCentralArtery.getMethods());
			bioMightComponent.setBioMightCollection(true);
			
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for SpleenCentralArtery: "  + bioMightComponent +  "     ID: " + spleenCentralArtery.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(spleenCentralArtery.getComponentID());
			bioMightKeys.setKey(bioMightKey);
				
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing SpleenCentralArtery Methods!");
			//	spleenCentralArtery(methodParams);
			//	spleenCentralArtery(0);
			//}
			//System.out.println("Getting X3D for SpleenCentralArtery!");
			bioMightComponent.setX3D(spleenCentralArtery.getX3D(snippet));			
		}
		
		
		
		
		else if (bioMightComponentRef.equals(Constants.SuperiorEpigastricVeins))
		{
			SuperiorEpigastricVeins superiorEpigastricVeins = (SuperiorEpigastricVeins) bioMightInstance;
			bioMightComponent.setImage(superiorEpigastricVeins.getImage());
			bioMightComponent.setWidth(superiorEpigastricVeins.getImageWidth());
			bioMightComponent.setHeight(superiorEpigastricVeins.getImageHeight());
			bioMightComponent.setBioMightProperties(superiorEpigastricVeins.getProperties());
			bioMightComponent.setBioMightMethods(superiorEpigastricVeins.getMethods());
			bioMightComponent.setBioMightCollection(true);
			
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for SuperiorEpigastricVeins: "  + bioMightComponent +  "     ID: " + superiorEpigastricVeins.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(superiorEpigastricVeins.getComponentID());
			bioMightKeys.setKey(bioMightKey);
				
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing SuperiorEpigastricVeins Methods!");
			//	superiorEpigastricVeins(methodParams);
			//	superiorEpigastricVeins(0);
			//}
			//System.out.println("Getting X3D for SuperiorEpigastricVeins!");
			bioMightComponent.setX3D(superiorEpigastricVeins.getX3D(snippet));			
		}
		else if (bioMightComponentRef.equals(Constants.SuperiorEpigastricVein))
		{
			SuperiorEpigastricVein superiorEpigastricVein = (SuperiorEpigastricVein) bioMightInstance;
			bioMightComponent.setImage(superiorEpigastricVein.getImage());
			bioMightComponent.setWidth(superiorEpigastricVein.getImageWidth());
			bioMightComponent.setHeight(superiorEpigastricVein.getImageHeight());
			bioMightComponent.setBioMightProperties(superiorEpigastricVein.getProperties());
			bioMightComponent.setBioMightMethods(superiorEpigastricVein.getMethods());
			
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for SuperiorEpigastricVein: "  + bioMightComponent +  "     ID: " + superiorEpigastricVein.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(superiorEpigastricVein.getComponentID());
			bioMightKeys.setKey(bioMightKey);
				
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing SuperiorEpigastricVein Methods!");
			//	superiorEpigastricVein(methodParams);
			//	superiorEpigastricVein(0);
			//}
			//System.out.println("Getting X3D for SuperiorEpigastricVein!");
			bioMightComponent.setX3D(superiorEpigastricVein.getX3D(snippet));			
		}

		else if (bioMightComponentRef.equals(Constants.TrabecularVeins))
		{
			TrabecularVeins trabecularVeins = (TrabecularVeins) bioMightInstance;
			bioMightComponent.setImage(trabecularVeins.getImage());
			bioMightComponent.setWidth(trabecularVeins.getImageWidth());
			bioMightComponent.setHeight(trabecularVeins.getImageHeight());
			bioMightComponent.setBioMightProperties(trabecularVeins.getProperties());
			bioMightComponent.setBioMightMethods(trabecularVeins.getMethods());
			bioMightComponent.setBioMightCollection(true);
			
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for TrabecularVeins: "  + bioMightComponent +  "     ID: " + trabecularVeins.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(trabecularVeins.getComponentID());
			bioMightKeys.setKey(bioMightKey);
				
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing TrabecularVeins Methods!");
			//	trabecularVeins(methodParams);
			//	trabecularVeins(0);
			//}
			//System.out.println("Getting X3D for TrabecularVeins!");
			bioMightComponent.setX3D(trabecularVeins.getX3D(snippet));			
		}
		else if (bioMightComponentRef.equals(Constants.TrabecularVein))
		{
			TrabecularVein trabecularVein = (TrabecularVein) bioMightInstance;
			bioMightComponent.setImage(trabecularVein.getImage());
			bioMightComponent.setWidth(trabecularVein.getImageWidth());
			bioMightComponent.setHeight(trabecularVein.getImageHeight());
			bioMightComponent.setBioMightProperties(trabecularVein.getProperties());
			bioMightComponent.setBioMightMethods(trabecularVein.getMethods());
			bioMightComponent.setBioMightCollection(true);
			
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for TrabecularVein: "  + bioMightComponent +  "     ID: " + trabecularVein.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(trabecularVein.getComponentID());
			bioMightKeys.setKey(bioMightKey);
				
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing TrabecularVein Methods!");
			//	trabecularVein(methodParams);
			//	trabecularVein(0);
			//}
			//System.out.println("Getting X3D for TrabecularVein!");
			bioMightComponent.setX3D(trabecularVein.getX3D(snippet));			
		}
		
		
		
		
		
		/**************************************************************************
		*
		* VASCULATURE OF THEE ARM
		*
		* This section maps the data in the biomight object into the presentation 
		* layer.  
		*  
		***************************************************************************/


		else if (bioMightComponentRef.equals(Constants.BrachialArtery))
		{
			BrachialArtery brachialArtery = (BrachialArtery) bioMightInstance;
			bioMightComponent.setImage(brachialArtery.getImage());
			bioMightComponent.setWidth(brachialArtery.getImageWidth());
			bioMightComponent.setHeight(brachialArtery.getImageHeight());
			bioMightComponent.setBioMightProperties(brachialArtery.getProperties());
			bioMightComponent.setBioMightMethods(brachialArtery.getMethods());
			bioMightComponent.setBioMightCollection(true);
			
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for BrachialArtery: "  + bioMightComponent +  "     ID: " + brachialArtery.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(brachialArtery.getComponentID());
			bioMightKeys.setKey(bioMightKey);
				
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing BrachialArtery Methods!");
			//	brachialArtery(methodParams);
			//	brachialArtery(0);
			//}
			//System.out.println("Getting X3D for BrachialArtery!");
			bioMightComponent.setX3D(brachialArtery.getX3D(snippet));			
		}
		else if (bioMightComponentRef.equals(Constants.AccessoryCephalicVein))
		{
			AccessoryCephalicVein accessoryCephalicVein = (AccessoryCephalicVein) bioMightInstance;
			bioMightComponent.setImage(accessoryCephalicVein.getImage());
			bioMightComponent.setWidth(accessoryCephalicVein.getImageWidth());
			bioMightComponent.setHeight(accessoryCephalicVein.getImageHeight());
			bioMightComponent.setBioMightProperties(accessoryCephalicVein.getProperties());
			bioMightComponent.setBioMightMethods(accessoryCephalicVein.getMethods());
			bioMightComponent.setBioMightCollection(true);
			
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for AccessoryCephalicVein: "  + bioMightComponent +  "     ID: " + accessoryCephalicVein.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(accessoryCephalicVein.getComponentID());
			bioMightKeys.setKey(bioMightKey);
				
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing AccessoryCephalicVein Methods!");
			//	subClavianVeins(methodParams);
			//	subClavianVeins(0);
			//}
			//System.out.println("Getting X3D for AccessoryCephalicVein!");
			bioMightComponent.setX3D(accessoryCephalicVein.getX3D(snippet));			
		}
		else if (bioMightComponentRef.equals(Constants.BasilicVein))
		{
			BasilicVein basilicVein = (BasilicVein) bioMightInstance;
			bioMightComponent.setImage(basilicVein.getImage());
			bioMightComponent.setWidth(basilicVein.getImageWidth());
			bioMightComponent.setHeight(basilicVein.getImageHeight());
			bioMightComponent.setBioMightProperties(basilicVein.getProperties());
			bioMightComponent.setBioMightMethods(basilicVein.getMethods());
			bioMightComponent.setBioMightCollection(true);
			
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for BasilicVein: "  + bioMightComponent +  "     ID: " + basilicVein.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(basilicVein.getComponentID());
			bioMightKeys.setKey(bioMightKey);
				
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing BasilicVein Methods!");
			//	basilicVein(methodParams);
			//	basilicVein(0);
			//}
			//System.out.println("Getting X3D for BasilicVein!");
			bioMightComponent.setX3D(basilicVein.getX3D(snippet));			
		}
		else if (bioMightComponentRef.equals(Constants.CephalicVein))
		{
			CephalicVein cephalicVein = (CephalicVein) bioMightInstance;
			bioMightComponent.setImage(cephalicVein.getImage());
			bioMightComponent.setWidth(cephalicVein.getImageWidth());
			bioMightComponent.setHeight(cephalicVein.getImageHeight());
			bioMightComponent.setBioMightProperties(cephalicVein.getProperties());
			bioMightComponent.setBioMightMethods(cephalicVein.getMethods());
			
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for CephalicVein: "  + bioMightComponent +  "     ID: " + cephalicVein.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(cephalicVein.getComponentID());
			bioMightKeys.setKey(bioMightKey);
				
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing CephalicVein Methods!");
			//	cephalicVein(methodParams);
			//	cephalicVein(0);
			//}
			//System.out.println("Getting X3D for CephalicVein!");
			bioMightComponent.setX3D(cephalicVein.getX3D(snippet));			
		}
		else if (bioMightComponentRef.equals(Constants.BrachialVein))
		{
			BrachialVein brachialVein = (BrachialVein) bioMightInstance;
			bioMightComponent.setImage(brachialVein.getImage());
			bioMightComponent.setWidth(brachialVein.getImageWidth());
			bioMightComponent.setHeight(brachialVein.getImageHeight());
			bioMightComponent.setBioMightProperties(brachialVein.getProperties());
			bioMightComponent.setBioMightMethods(brachialVein.getMethods());
			bioMightComponent.setBioMightCollection(true);
			
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for BrachialVein: "  + bioMightComponent +  "     ID: " + brachialVein.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(brachialVein.getComponentID());
			bioMightKeys.setKey(bioMightKey);
				
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing BrachialArtery Methods!");
			//	brachialVein(methodParams);
			//	brachialVein(0);
			//}
			//System.out.println("Getting X3D for BrachialVein!");
			bioMightComponent.setX3D(brachialVein.getX3D(snippet));			
		}
		
		
		/**************************************************************************
		*
		* VASCULATURE OF THEE FOREARM 
		*
		* This section maps the data in the biomight object into the presentation 
		* layer.  
		*  
		***************************************************************************/
	
		
		else if (bioMightComponentRef.equals(Constants.UlnarArtery))
		{
			UlnarArtery ulnarArtery = (UlnarArtery) bioMightInstance;
			bioMightComponent.setImage(ulnarArtery.getImage());
			bioMightComponent.setWidth(ulnarArtery.getImageWidth());
			bioMightComponent.setHeight(ulnarArtery.getImageHeight());
			bioMightComponent.setBioMightProperties(ulnarArtery.getProperties());
			bioMightComponent.setBioMightMethods(ulnarArtery.getMethods());
			
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for UlnarArtery: "  + bioMightComponent +  "     ID: " + ulnarArtery.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(ulnarArtery.getComponentID());
			bioMightKeys.setKey(bioMightKey);
				
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing UlnarArtery Methods!");
			//	ulnarArtery(methodParams);
			//	ulnarArtery(0);
			//}
			//System.out.println("Getting X3D for UlnarArtery!");
			bioMightComponent.setX3D(ulnarArtery.getX3D(snippet));			
		}		
		else if (bioMightComponentRef.equals(Constants.UlnarArtery))
		{
			UlnarArtery ulnarArtery = (UlnarArtery) bioMightInstance;
			bioMightComponent.setImage(ulnarArtery.getImage());
			bioMightComponent.setWidth(ulnarArtery.getImageWidth());
			bioMightComponent.setHeight(ulnarArtery.getImageHeight());
			bioMightComponent.setBioMightProperties(ulnarArtery.getProperties());
			bioMightComponent.setBioMightMethods(ulnarArtery.getMethods());
			
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for UlnarArtery: "  + bioMightComponent +  "     ID: " + ulnarArtery.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(ulnarArtery.getComponentID());
			bioMightKeys.setKey(bioMightKey);
				
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing UlnarArtery Methods!");
			//	ulnarArtery(methodParams);
			//	ulnarArtery(0);
			//}
			//System.out.println("Getting X3D for UlnarArtery!");
			bioMightComponent.setX3D(ulnarArtery.getX3D(snippet));			
		}
		else if (bioMightComponentRef.equals(Constants.RadialArtery))
		{
			RadialArtery radialArtery = (RadialArtery) bioMightInstance;
			bioMightComponent.setImage(radialArtery.getImage());
			bioMightComponent.setWidth(radialArtery.getImageWidth());
			bioMightComponent.setHeight(radialArtery.getImageHeight());
			bioMightComponent.setBioMightProperties(radialArtery.getProperties());
			bioMightComponent.setBioMightMethods(radialArtery.getMethods());
			
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for RadialArtery: "  + bioMightComponent +  "     ID: " + radialArtery.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(radialArtery.getComponentID());
			bioMightKeys.setKey(bioMightKey);
				
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing RadialArtery Methods!");
			//	radialArtery(methodParams);
			//	radialArtery(0);
			//}
			//System.out.println("Getting X3D for RadialArtery!");
			//bioMightComponent.setX3D(radialArtery.getX3D(snippet));			
		}	
	
		/**************************************************************************
		*
		* VASCULATURE OF THEE THIGH 
		*
		* This section maps the data in the biomight object into the presentation 
		* layer.  
		*  
		***************************************************************************/
	
		else if (bioMightComponentRef.equals(Constants.SmallSaphenousVein))
		{
			SmallSaphenousVein smallSaphenousVein = (SmallSaphenousVein) bioMightInstance;
			bioMightComponent.setImage(smallSaphenousVein.getImage());
			bioMightComponent.setWidth(smallSaphenousVein.getImageWidth());
			bioMightComponent.setHeight(smallSaphenousVein.getImageHeight());
			bioMightComponent.setBioMightProperties(smallSaphenousVein.getProperties());
			bioMightComponent.setBioMightMethods(smallSaphenousVein.getMethods());
			
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for SmallSaphenousVein: "  + bioMightComponent +  "     ID: " + smallSaphenousVein.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(smallSaphenousVein.getComponentID());
			bioMightKeys.setKey(bioMightKey);
				
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing SmallSaphenousVein Methods!");
			//	smallSaphenousVein(methodParams);
			//	smallSaphenousVein(0);
			//}
			//System.out.println("Getting X3D for SmallSaphenousVein!");
			//bioMightComponent.setX3D(smallSaphenousVein(false));			
		}	
		else if (bioMightComponentRef.equals(Constants.AnteriorTibialVein))
		{
			AnteriorTibialVein anteriorTibialVein = (AnteriorTibialVein) bioMightInstance;
			bioMightComponent.setImage(anteriorTibialVein.getImage());
			bioMightComponent.setWidth(anteriorTibialVein.getImageWidth());
			bioMightComponent.setHeight(anteriorTibialVein.getImageHeight());
			bioMightComponent.setBioMightProperties(anteriorTibialVein.getProperties());
			bioMightComponent.setBioMightMethods(anteriorTibialVein.getMethods());
			
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for AnteriorTibialVein: "  + bioMightComponent +  "     ID: " + anteriorTibialVein.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(anteriorTibialVein.getComponentID());
			bioMightKeys.setKey(bioMightKey);
				
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing AnteriorTibialVein Methods!");
			//	anteriorTibialVein(methodParams);
			//	anteriorTibialVein(0);
			//}
			//System.out.println("Getting X3D for AnteriorTibialVein!");
			bioMightComponent.setX3D(anteriorTibialVein.getX3D(snippet));			
		}	
		else if (bioMightComponentRef.equals(Constants.DeepFemoralVein))
		{
			DeepFemoralVein deepFemoralVein = (DeepFemoralVein) bioMightInstance;
			bioMightComponent.setImage(deepFemoralVein.getImage());
			bioMightComponent.setWidth(deepFemoralVein.getImageWidth());
			bioMightComponent.setHeight(deepFemoralVein.getImageHeight());
			bioMightComponent.setBioMightProperties(deepFemoralVein.getProperties());
			bioMightComponent.setBioMightMethods(deepFemoralVein.getMethods());
			
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for DeepFemoralVein: "  + bioMightComponent +  "     ID: " + deepFemoralVein.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(deepFemoralVein.getComponentID());
			bioMightKeys.setKey(bioMightKey);
				
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing DeepFemoralVein Methods!");
			//	deepFemoralVein(methodParams);
			//	deepFemoralVein(0);
			//}
			//System.out.println("Getting X3D for DeepFemoralVein!");
			bioMightComponent.setX3D(deepFemoralVein.getX3D(snippet));			
		}			
		else if (bioMightComponentRef.equals(Constants.FemoralVein))
		{
			FemoralVein femoralVein = (FemoralVein) bioMightInstance;
			bioMightComponent.setImage(femoralVein.getImage());
			bioMightComponent.setWidth(femoralVein.getImageWidth());
			bioMightComponent.setHeight(femoralVein.getImageHeight());
			bioMightComponent.setBioMightProperties(femoralVein.getProperties());
			bioMightComponent.setBioMightMethods(femoralVein.getMethods());
			
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for FemoralVein: "  + bioMightComponent +  "     ID: " + femoralVein.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(femoralVein.getComponentID());
			bioMightKeys.setKey(bioMightKey);
				
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing FemoralVein Methods!");
			//	femoralVein(methodParams);
			//	femoralVein(0);
			//}
			//System.out.println("Getting X3D for FemoralVein!");
			bioMightComponent.setX3D(femoralVein.getX3D(snippet));			
		}
		else if (bioMightComponentRef.equals(Constants.DorsalisPedisVein))
		{
			DorsalisPedisVein dorsalisPedisVein = (DorsalisPedisVein) bioMightInstance;
			bioMightComponent.setImage(dorsalisPedisVein.getImage());
			bioMightComponent.setWidth(dorsalisPedisVein.getImageWidth());
			bioMightComponent.setHeight(dorsalisPedisVein.getImageHeight());
			bioMightComponent.setBioMightProperties(dorsalisPedisVein.getProperties());
			bioMightComponent.setBioMightMethods(dorsalisPedisVein.getMethods());
			
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for FemoralVein: "  + bioMightComponent +  "     ID: " + dorsalisPedisVein.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(dorsalisPedisVein.getComponentID());
			bioMightKeys.setKey(bioMightKey);
				
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing FemoralVein Methods!");
			//	dorsalisPedisVein(methodParams);
			//	dorsalisPedisVein(0);
			//}
			//System.out.println("Getting X3D for FemoralVein!");
			bioMightComponent.setX3D(dorsalisPedisVein.getX3D(snippet));			
		}		
		else if (bioMightComponentRef.equals(Constants.GreatSaphenousVein))
		{
			GreatSaphenousVein greatSaphenousVein = (GreatSaphenousVein) bioMightInstance;
			bioMightComponent.setImage(greatSaphenousVein.getImage());
			bioMightComponent.setWidth(greatSaphenousVein.getImageWidth());
			bioMightComponent.setHeight(greatSaphenousVein.getImageHeight());
			bioMightComponent.setBioMightProperties(greatSaphenousVein.getProperties());
			bioMightComponent.setBioMightMethods(greatSaphenousVein.getMethods());
			
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for GreatSaphenousVein: "  + bioMightComponent +  "     ID: " + greatSaphenousVein.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(greatSaphenousVein.getComponentID());
			bioMightKeys.setKey(bioMightKey);
				
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing GreatSaphenousVein Methods!");
			//	greatSaphenousVein(methodParams);
			//	greatSaphenousVein(0);
			//}
			//System.out.println("Getting X3D for GreatSaphenousVein!");
			bioMightComponent.setX3D(greatSaphenousVein.getX3D(snippet));			
		}			
		else if (bioMightComponentRef.equals(Constants.PeronealVein))
		{
			PeronealVein peronealVein = (PeronealVein) bioMightInstance;
			bioMightComponent.setImage(peronealVein.getImage());
			bioMightComponent.setWidth(peronealVein.getImageWidth());
			bioMightComponent.setHeight(peronealVein.getImageHeight());
			bioMightComponent.setBioMightProperties(peronealVein.getProperties());
			bioMightComponent.setBioMightMethods(peronealVein.getMethods());
			
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for PeronealVein: "  + bioMightComponent +  "     ID: " + peronealVein.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(peronealVein.getComponentID());
			bioMightKeys.setKey(bioMightKey);
				
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing PeronealVein Methods!");
			//	peronealVein(methodParams);
			//	peronealVein(0);
			//}
			//System.out.println("Getting X3D for PeronealVein!");
			bioMightComponent.setX3D(peronealVein.getX3D(snippet));			
		}		
		else if (bioMightComponentRef.equals(Constants.PoplitealVein))
		{
			PoplitealVein poplitealVein = (PoplitealVein) bioMightInstance;
			bioMightComponent.setImage(poplitealVein.getImage());
			bioMightComponent.setWidth(poplitealVein.getImageWidth());
			bioMightComponent.setHeight(poplitealVein.getImageHeight());
			bioMightComponent.setBioMightProperties(poplitealVein.getProperties());
			bioMightComponent.setBioMightMethods(poplitealVein.getMethods());
			
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for PoplitealVein: "  + bioMightComponent +  "     ID: " + poplitealVein.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(poplitealVein.getComponentID());
			bioMightKeys.setKey(bioMightKey);
				
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing PoplitealVein Methods!");
			//	poplitealVein(methodParams);
			//	poplitealVein(0);
			//}
			//System.out.println("Getting X3D for PoplitealVein!");
			bioMightComponent.setX3D(poplitealVein.getX3D(snippet));			
		}
		else if (bioMightComponentRef.equals(Constants.PosteriorTibialVein))
		{
			PosteriorTibialVein posteriorTibialVein = (PosteriorTibialVein) bioMightInstance;
			bioMightComponent.setImage(posteriorTibialVein.getImage());
			bioMightComponent.setWidth(posteriorTibialVein.getImageWidth());
			bioMightComponent.setHeight(posteriorTibialVein.getImageHeight());
			bioMightComponent.setBioMightProperties(posteriorTibialVein.getProperties());
			bioMightComponent.setBioMightMethods(posteriorTibialVein.getMethods());
			
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for PosteriorTibialVein: "  + bioMightComponent +  "     ID: " + posteriorTibialVein.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(posteriorTibialVein.getComponentID());
			bioMightKeys.setKey(bioMightKey);
				
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing PosteriorTibialVein Methods!");
			//	poplitealVein(methodParams);
			//	poplitealVein(0);
			//}
			//System.out.println("Getting X3D for PosteriorTibialVein!");
			bioMightComponent.setX3D(posteriorTibialVein.getX3D(snippet));			
		}
		else if (bioMightComponentRef.equals(Constants.LateralCircumflexFemoralVein))
		{
			LateralCircumflexFemoralVein lateralCircumflexFemoralVein = (LateralCircumflexFemoralVein) bioMightInstance;
			bioMightComponent.setImage(lateralCircumflexFemoralVein.getImage());
			bioMightComponent.setWidth(lateralCircumflexFemoralVein.getImageWidth());
			bioMightComponent.setHeight(lateralCircumflexFemoralVein.getImageHeight());
			bioMightComponent.setBioMightProperties(lateralCircumflexFemoralVein.getProperties());
			bioMightComponent.setBioMightMethods(lateralCircumflexFemoralVein.getMethods());
			
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for LateralCircumflexFemoralVein: "  + bioMightComponent +  "     ID: " + lateralCircumflexFemoralVein.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(lateralCircumflexFemoralVein.getComponentID());
			bioMightKeys.setKey(bioMightKey);
				
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing LateralCircumflexFemoralVein Methods!");
			//	poplitealVein(methodParams);
			//	poplitealVein(0);
			//}
			//System.out.println("Getting X3D for LateralCircumflexFemoralVein!");
			bioMightComponent.setX3D(lateralCircumflexFemoralVein.getX3D(snippet));			
		}	
		/*
		else if (bioMightComponentRef.equals(Constants.SaphenousBranch))
		{
			SaphenousBranch saphenousBranch = (SaphenousBranch) bioMightInstance;
			bioMightComponent.setImage(saphenousBranch.getImage());
			bioMightComponent.setWidth(saphenousBranch.getImageWidth());
			bioMightComponent.setHeight(saphenousBranch.getImageHeight());
			bioMightComponent.setBioMightProperties(saphenousBranch.getProperties());
			bioMightComponent.setBioMightMethods(saphenousBranch.getMethods());
			
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for SaphenousBranch: "  + bioMightComponent +  "     ID: " + saphenousBranch.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(saphenousBranch.getComponentID());
			bioMightKeys.setKey(bioMightKey);
				
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing SaphenousBranch Methods!");
			//	saphenousBranch(methodParams);
			//	saphenousBranch(0);
			//}
			//System.out.println("Getting X3D for SaphenousBranch!");
			bioMightComponent.setX3D(saphenousBranch.getX3D(snippet));			
		}
		*/
	
		
		/**************************************************************************
		*
		* VASCULATURE OF THEE CNEMIS 
		*
		* This section maps the data in the biomight object into the presentation 
		* layer.  
		*  
		***************************************************************************/
		
	
		else if (bioMightComponentRef.equals(Constants.SuperficialFemoralArtery))
		{
			SuperficialFemoralArtery superficialFemoralArtery = (SuperficialFemoralArtery) bioMightInstance;
			bioMightComponent.setImage(superficialFemoralArtery.getImage());
			bioMightComponent.setWidth(superficialFemoralArtery.getImageWidth());
			bioMightComponent.setHeight(superficialFemoralArtery.getImageHeight());
			bioMightComponent.setBioMightProperties(superficialFemoralArtery.getProperties());
			bioMightComponent.setBioMightMethods(superficialFemoralArtery.getMethods());
			
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for SuperficialFemoralArtery: "  + bioMightComponent +  "     ID: " + superficialFemoralArtery.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(superficialFemoralArtery.getComponentID());
			bioMightKeys.setKey(bioMightKey);
				
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing SuperficialFemoralArtery Methods!");
			//	superficialFemoralArtery(methodParams);
			//	superficialFemoralArtery(0);
			//}
			//System.out.println("Getting X3D for SuperficialFemoralArtery!");
			bioMightComponent.setX3D(superficialFemoralArtery.getX3D(snippet));			
		}	
		else if (bioMightComponentRef.equals(Constants.PoplitealArtery))
		{
			PoplitealArtery poplitealArtery = (PoplitealArtery) bioMightInstance;
			bioMightComponent.setImage(poplitealArtery.getImage());
			bioMightComponent.setWidth(poplitealArtery.getImageWidth());
			bioMightComponent.setHeight(poplitealArtery.getImageHeight());
			bioMightComponent.setBioMightProperties(poplitealArtery.getProperties());
			bioMightComponent.setBioMightMethods(poplitealArtery.getMethods());
			
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for PoplitealArtery: "  + bioMightComponent +  "     ID: " + poplitealArtery.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(poplitealArtery.getComponentID());
			bioMightKeys.setKey(bioMightKey);
				
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing PoplitealArtery Methods!");
			//	poplitealArtery(methodParams);
			//	poplitealArtery(0);
			//}
			//System.out.println("Getting X3D for PoplitealArtery!");
			bioMightComponent.setX3D(poplitealArtery.getX3D(snippet));			
		}	
		else if (bioMightComponentRef.equals(Constants.AnteriorTibialArtery))
		{
			AnteriorTibialArtery anteriorTibialArtery = (AnteriorTibialArtery) bioMightInstance;
			bioMightComponent.setImage(anteriorTibialArtery.getImage());
			bioMightComponent.setWidth(anteriorTibialArtery.getImageWidth());
			bioMightComponent.setHeight(anteriorTibialArtery.getImageHeight());
			bioMightComponent.setBioMightProperties(anteriorTibialArtery.getProperties());
			bioMightComponent.setBioMightMethods(anteriorTibialArtery.getMethods());
			
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for AnteriorTibialArtery: "  + bioMightComponent +  "     ID: " + anteriorTibialArtery.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(anteriorTibialArtery.getComponentID());
			bioMightKeys.setKey(bioMightKey);
				
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing AnteriorTibialArtery Methods!");
			//	anteriorTibialArtery(methodParams);
			//	anteriorTibialArtery(0);
			//}
			//System.out.println("Getting X3D for AnteriorTibialArtery!");
			bioMightComponent.setX3D(anteriorTibialArtery.getX3D(snippet));			
		}	
		else if (bioMightComponentRef.equals(Constants.PosteriorTibialArtery))
		{
			PosteriorTibialArtery posteriorTibialArtery = (PosteriorTibialArtery) bioMightInstance;
			bioMightComponent.setImage(posteriorTibialArtery.getImage());
			bioMightComponent.setWidth(posteriorTibialArtery.getImageWidth());
			bioMightComponent.setHeight(posteriorTibialArtery.getImageHeight());
			bioMightComponent.setBioMightProperties(posteriorTibialArtery.getProperties());
			bioMightComponent.setBioMightMethods(posteriorTibialArtery.getMethods());
			
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for PosteriorTibialArtery: "  + bioMightComponent +  "     ID: " + posteriorTibialArtery.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(posteriorTibialArtery.getComponentID());
			bioMightKeys.setKey(bioMightKey);
				
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing PosteriorTibialArtery Methods!");
			//	posteriorTibialArtery(methodParams);
			//	posteriorTibialArtery(0);
			//}
			//System.out.println("Getting X3D for PosteriorTibialArtery!");
			bioMightComponent.setX3D(posteriorTibialArtery.getX3D(snippet));			
		}	
		else if (bioMightComponentRef.equals(Constants.PeronealArtery))
		{
			PeronealArtery peronealArtery = (PeronealArtery) bioMightInstance;
			bioMightComponent.setImage(peronealArtery.getImage());
			bioMightComponent.setWidth(peronealArtery.getImageWidth());
			bioMightComponent.setHeight(peronealArtery.getImageHeight());
			bioMightComponent.setBioMightProperties(peronealArtery.getProperties());
			bioMightComponent.setBioMightMethods(peronealArtery.getMethods());
			
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for PeronealArtery: "  + bioMightComponent +  "     ID: " + peronealArtery.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(peronealArtery.getComponentID());
			bioMightKeys.setKey(bioMightKey);
				
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing PeronealArtery Methods!");
			//	peronealArtery(methodParams);
			//	peronealArtery(0);
			//}
			//System.out.println("Getting X3D for PeronealArtery!");
			bioMightComponent.setX3D(peronealArtery.getX3D(snippet));			
		}	
		else if (bioMightComponentRef.equals(Constants.ArcuateArtery))
		{
			ArcuateArtery arcuateArtery = (ArcuateArtery) bioMightInstance;
			bioMightComponent.setImage(arcuateArtery.getImage());
			bioMightComponent.setWidth(arcuateArtery.getImageWidth());
			bioMightComponent.setHeight(arcuateArtery.getImageHeight());
			bioMightComponent.setBioMightProperties(arcuateArtery.getProperties());
			bioMightComponent.setBioMightMethods(arcuateArtery.getMethods());
			
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for ArcuateArtery: "  + bioMightComponent +  "     ID: " + arcuateArtery.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(arcuateArtery.getComponentID());
			bioMightKeys.setKey(bioMightKey);
				
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing ArcuateArtery Methods!");
			//	arcuateArtery(methodParams);
			//	arcuateArtery(0);
			//}
			//System.out.println("Getting X3D for ArcuateArtery!");
			bioMightComponent.setX3D(arcuateArtery.getX3D(snippet));			
		}	
		
		// VEINS OF THE CNEMUS
		else if (bioMightComponentRef.equals(Constants.GreatSaphenousVein))
		{
			GreatSaphenousVein greatSaphenousVein = (GreatSaphenousVein) bioMightInstance;
			bioMightComponent.setImage(greatSaphenousVein.getImage());
			bioMightComponent.setWidth(greatSaphenousVein.getImageWidth());
			bioMightComponent.setHeight(greatSaphenousVein.getImageHeight());
			bioMightComponent.setBioMightProperties(greatSaphenousVein.getProperties());
			bioMightComponent.setBioMightMethods(greatSaphenousVein.getMethods());
			
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for GreatSaphenousVein: "  + bioMightComponent +  "     ID: " + greatSaphenousVein.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(greatSaphenousVein.getComponentID());
			bioMightKeys.setKey(bioMightKey);
				
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing GreatSaphenousVein Methods!");
			//	greatSaphenousVein(methodParams);
			//	greatSaphenousVein(0);
			//}
			//System.out.println("Getting X3D for GreatSaphenousVein!");
			bioMightComponent.setX3D(greatSaphenousVein.getX3D(snippet));			
		}
			
	
		/**************************************************************************
		*
		* VASCULATURE OF THEE FOOT 
		*
		* This section maps the data in the biomight object into the presentation 
		* layer.  
		*  
		***************************************************************************/
		
		else if (bioMightComponentRef.equals(Constants.LateralMarginalVein))
		{
			LateralMarginalVein lateralMarginalVein = (LateralMarginalVein) bioMightInstance;
			bioMightComponent.setImage(lateralMarginalVein.getImage());
			bioMightComponent.setWidth(lateralMarginalVein.getImageWidth());
			bioMightComponent.setHeight(lateralMarginalVein.getImageHeight());
			bioMightComponent.setBioMightProperties(lateralMarginalVein.getProperties());
			bioMightComponent.setBioMightMethods(lateralMarginalVein.getMethods());
			
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for LateralMarginalVein: "  + bioMightComponent +  "     ID: " + lateralMarginalVein.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(lateralMarginalVein.getComponentID());
			bioMightKeys.setKey(bioMightKey);
				
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing LateralMarginalVein Methods!");
			//	saphenousBranch(methodParams);
			//	saphenousBranch(0);
			//}
			//System.out.println("Getting X3D for LateralMarginalVein!");
			bioMightComponent.setX3D(lateralMarginalVein.getX3D(snippet));			
		}	
		else if (bioMightComponentRef.equals(Constants.LateralPlantarVein))
		{
			LateralPlantarVein lateralPlantarVein = (LateralPlantarVein) bioMightInstance;
			bioMightComponent.setImage(lateralPlantarVein.getImage());
			bioMightComponent.setWidth(lateralPlantarVein.getImageWidth());
			bioMightComponent.setHeight(lateralPlantarVein.getImageHeight());
			bioMightComponent.setBioMightProperties(lateralPlantarVein.getProperties());
			bioMightComponent.setBioMightMethods(lateralPlantarVein.getMethods());
			
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for LateralPlantarVein: "  + bioMightComponent +  "     ID: " + lateralPlantarVein.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(lateralPlantarVein.getComponentID());
			bioMightKeys.setKey(bioMightKey);
				
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing LateralPlantarVein Methods!");
			//	lateralPlantarVein(methodParams);
			//	lateralPlantarVein(0);
			//}
			//System.out.println("Getting X3D for LateralPlantarVein!");
			bioMightComponent.setX3D(lateralPlantarVein.getX3D(snippet));			
		}
		else if (bioMightComponentRef.equals(Constants.MedialMarginalVein))
		{
			MedialMarginalVein medialMarginalVein = (MedialMarginalVein) bioMightInstance;
			bioMightComponent.setImage(medialMarginalVein.getImage());
			bioMightComponent.setWidth(medialMarginalVein.getImageWidth());
			bioMightComponent.setHeight(medialMarginalVein.getImageHeight());
			bioMightComponent.setBioMightProperties(medialMarginalVein.getProperties());
			bioMightComponent.setBioMightMethods(medialMarginalVein.getMethods());
			
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for MedialMarginalVein: "  + bioMightComponent +  "     ID: " + medialMarginalVein.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(medialMarginalVein.getComponentID());
			bioMightKeys.setKey(bioMightKey);
				
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing MedialMarginalVein Methods!");
			//	medialMarginalVein(methodParams);
			//	medialMarginalVein(0);
			//}
			//System.out.println("Getting X3D for MedialMarginalVein!");
			bioMightComponent.setX3D(medialMarginalVein.getX3D(snippet));			
		}
		else if (bioMightComponentRef.equals(Constants.MedialPlantarVein))
		{
			MedialPlantarVein medialPlantarVein = (MedialPlantarVein) bioMightInstance;
			bioMightComponent.setImage(medialPlantarVein.getImage());
			bioMightComponent.setWidth(medialPlantarVein.getImageWidth());
			bioMightComponent.setHeight(medialPlantarVein.getImageHeight());
			bioMightComponent.setBioMightProperties(medialPlantarVein.getProperties());
			bioMightComponent.setBioMightMethods(medialPlantarVein.getMethods());
			
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for MedialMarginalVein: "  + bioMightComponent +  "     ID: " + medialPlantarVein.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(medialPlantarVein.getComponentID());
			bioMightKeys.setKey(bioMightKey);
				
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing MedialPlantarVein Methods!");
			//	medialPlantarVein(methodParams);
			//	medialPlantarVein(0);
			//}
			//System.out.println("Getting X3D for MedialPlantarVein!");
			bioMightComponent.setX3D(medialPlantarVein.getX3D(snippet));			
		}
		else if (bioMightComponentRef.equals(Constants.IntercapitularVeins))
		{
			IntercapitularVein intercapitularVeins = (IntercapitularVein) bioMightInstance;
			bioMightComponent.setImage(intercapitularVeins.getImage());
			bioMightComponent.setWidth(intercapitularVeins.getImageWidth());
			bioMightComponent.setHeight(intercapitularVeins.getImageHeight());
			bioMightComponent.setBioMightProperties(intercapitularVeins.getProperties());
			bioMightComponent.setBioMightMethods(intercapitularVeins.getMethods());
			
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for IntercapitularVeins: "  + bioMightComponent +  "     ID: " + intercapitularVeins.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(intercapitularVeins.getComponentID());
			bioMightKeys.setKey(bioMightKey);
				
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing IntercapitularVeins Methods!");
			//	intercapitularVeins(methodParams);
			//	intercapitularVeins(0);
			//}
			//System.out.println("Getting X3D for IntercapitularVeins!");
			bioMightComponent.setX3D(intercapitularVeins.getX3D(snippet));			
		}
		
		
		/**************************************************************************
		*
		* VASCULATURE OF THEE HAND 
		*
		* This section maps the data in the biomight object into the presentation 
		* layer.  
		*  
		***************************************************************************/
	
		
		
		
		/**************************************************************************
		*
		* VASCULATURE OF THEE FOOT 
		*
		* This section maps the data in the biomight object into the presentation 
		* layer.  
		*  
		***************************************************************************/
		
		else if (bioMightComponentRef.equals(Constants.PalmarDigitalVeins))
		{
			PalmarDigitalVeins palmarDigitalVeins = (PalmarDigitalVeins) bioMightInstance;
			bioMightComponent.setImage(palmarDigitalVeins.getImage());
			bioMightComponent.setWidth(palmarDigitalVeins.getImageWidth());
			bioMightComponent.setHeight(palmarDigitalVeins.getImageHeight());
			bioMightComponent.setBioMightProperties(palmarDigitalVeins.getProperties());
			bioMightComponent.setBioMightMethods(palmarDigitalVeins.getMethods());
			
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for PalmarDigitalVeins: "  + bioMightComponent +  "     ID: " + palmarDigitalVeins.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(palmarDigitalVeins.getComponentID());
			bioMightKeys.setKey(bioMightKey);
				
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing PalmarDigitalVeins Methods!");
			//	palmarDigitalVeins(methodParams);
			//	palmarDigitalVeins(0);
			//}
			//System.out.println("Getting X3D for PalmarDigitalVeins!");
			bioMightComponent.setX3D(palmarDigitalVeins.getX3D(snippet));			
		}
		else if (bioMightComponentRef.equals(Constants.PalmarDigitalVein))
		{
			PalmarDigitalVein palmarDigitalVein = (PalmarDigitalVein) bioMightInstance;
			bioMightComponent.setImage(palmarDigitalVein.getImage());
			bioMightComponent.setWidth(palmarDigitalVein.getImageWidth());
			bioMightComponent.setHeight(palmarDigitalVein.getImageHeight());
			bioMightComponent.setBioMightProperties(palmarDigitalVein.getProperties());
			bioMightComponent.setBioMightMethods(palmarDigitalVein.getMethods());
			
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for PalmarDigitalVein: "  + bioMightComponent +  "     ID: " + palmarDigitalVein.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(palmarDigitalVein.getComponentID());
			bioMightKeys.setKey(bioMightKey);
				
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing PalmarDigitalVein Methods!");
			//	palmarDigitalVein(methodParams);
			//	palmarDigitalVein(0);
			//}
			//System.out.println("Getting X3D for PalmarDigitalVein!");
			bioMightComponent.setX3D(palmarDigitalVein.getX3D(snippet));			
		}
		else if (bioMightComponentRef.equals(Constants.PalmarDigitalVein))
		{
			PalmarDigitalVein palmarDigitalVein = (PalmarDigitalVein) bioMightInstance;
			bioMightComponent.setImage(palmarDigitalVein.getImage());
			bioMightComponent.setWidth(palmarDigitalVein.getImageWidth());
			bioMightComponent.setHeight(palmarDigitalVein.getImageHeight());
			bioMightComponent.setBioMightProperties(palmarDigitalVein.getProperties());
			bioMightComponent.setBioMightMethods(palmarDigitalVein.getMethods());
			
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for PalmarDigitalVein: "  + bioMightComponent +  "     ID: " + palmarDigitalVein.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(palmarDigitalVein.getComponentID());
			bioMightKeys.setKey(bioMightKey);
				
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing PalmarDigitalVein Methods!");
			//	palmarDigitalVein(methodParams);
			//	palmarDigitalVein(0);
			//}
			//System.out.println("Getting X3D for PalmarDigitalVein!");
			bioMightComponent.setX3D(palmarDigitalVein.getX3D(snippet));			
		}
		else if (bioMightComponentRef.equals(Constants.DorsalMetatarsalVeins))
		{
			DorsalMetatarsalVeins dorsalMetatarsalVeins = (DorsalMetatarsalVeins) bioMightInstance;
			bioMightComponent.setImage(dorsalMetatarsalVeins.getImage());
			bioMightComponent.setWidth(dorsalMetatarsalVeins.getImageWidth());
			bioMightComponent.setHeight(dorsalMetatarsalVeins.getImageHeight());
			bioMightComponent.setBioMightProperties(dorsalMetatarsalVeins.getProperties());
			bioMightComponent.setBioMightMethods(dorsalMetatarsalVeins.getMethods());
			
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for DorsalMetatarsalVeins: "  + bioMightComponent +  "     ID: " + dorsalMetatarsalVeins.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(dorsalMetatarsalVeins.getComponentID());
			bioMightKeys.setKey(bioMightKey);
				
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing DorsalMetatarsalVeins Methods!");
			//	dorsalMetatarsalVeins(methodParams);
			//	dorsalMetatarsalVeins(0);
			//}
			//System.out.println("Getting X3D for DorsalMetatarsalVein!");
			bioMightComponent.setX3D(dorsalMetatarsalVeins.getX3D(snippet));			
		}		
		else if (bioMightComponentRef.equals(Constants.DorsalMetatarsalVein))
		{
			DorsalMetatarsalVein dorsalMetatarsalVein = (DorsalMetatarsalVein) bioMightInstance;
			bioMightComponent.setImage(dorsalMetatarsalVein.getImage());
			bioMightComponent.setWidth(dorsalMetatarsalVein.getImageWidth());
			bioMightComponent.setHeight(dorsalMetatarsalVein.getImageHeight());
			bioMightComponent.setBioMightProperties(dorsalMetatarsalVein.getProperties());
			bioMightComponent.setBioMightMethods(dorsalMetatarsalVein.getMethods());
			
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for DorsalMetatarsalVein: "  + bioMightComponent +  "     ID: " + dorsalMetatarsalVein.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(dorsalMetatarsalVein.getComponentID());
			bioMightKeys.setKey(bioMightKey);
				
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing DorsalMetatarsalVein Methods!");
			//	dorsalMetatarsalVein(methodParams);
			//	dorsalMetatarsalVein(0);
			//}
			//System.out.println("Getting X3D for DorsalMetatarsalVein!");
			bioMightComponent.setX3D(dorsalMetatarsalVein.getX3D(snippet));			
		}		
		else if (bioMightComponentRef.equals(Constants.PlantarMetatarsalVeins))
		{
			PlantarMetatarsalVeins plantarMetatarsalVeins = (PlantarMetatarsalVeins) bioMightInstance;
			bioMightComponent.setImage(plantarMetatarsalVeins.getImage());
			bioMightComponent.setWidth(plantarMetatarsalVeins.getImageWidth());
			bioMightComponent.setHeight(plantarMetatarsalVeins.getImageHeight());
			bioMightComponent.setBioMightProperties(plantarMetatarsalVeins.getProperties());
			bioMightComponent.setBioMightMethods(plantarMetatarsalVeins.getMethods());
			
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for PlantarMetatarsalVeins: "  + bioMightComponent +  "     ID: " + plantarMetatarsalVeins.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(plantarMetatarsalVeins.getComponentID());
			bioMightKeys.setKey(bioMightKey);
				
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing DorsalMetatarsalVeins Methods!");
			//	plantarMetatarsalVeins(methodParams);
			//	plantarMetatarsalVeins(0);
			//}
			//System.out.println("Getting X3D for PlantarMetatarsalVeins!");
			bioMightComponent.setX3D(plantarMetatarsalVeins.getX3D(snippet));			
		}		
		else if (bioMightComponentRef.equals(Constants.PlantarMetatarsalVein))
		{
			PlantarMetatarsalVein plantarMetatarsalVein = (PlantarMetatarsalVein) bioMightInstance;
			bioMightComponent.setImage(plantarMetatarsalVein.getImage());
			bioMightComponent.setWidth(plantarMetatarsalVein.getImageWidth());
			bioMightComponent.setHeight(plantarMetatarsalVein.getImageHeight());
			bioMightComponent.setBioMightProperties(plantarMetatarsalVein.getProperties());
			bioMightComponent.setBioMightMethods(plantarMetatarsalVein.getMethods());
			
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for PlantarMetatarsalVein: "  + bioMightComponent +  "     ID: " + plantarMetatarsalVein.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(plantarMetatarsalVein.getComponentID());
			bioMightKeys.setKey(bioMightKey);
				
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing DorsalMetatarsalVein Methods!");
			//	plantarMetatarsalVein(methodParams);
			//	plantarMetatarsalVein(0);
			//}
			//System.out.println("Getting X3D for PlantarMetatarsalVein!");
			bioMightComponent.setX3D(plantarMetatarsalVein.getX3D(snippet));			
		}
		else if (bioMightComponentRef.equals(Constants.SuperficialPalmarArch))
		{
			SuperficialPalmarArch superficialPalmarArch = (SuperficialPalmarArch) bioMightInstance;
			bioMightComponent.setImage(superficialPalmarArch.getImage());
			bioMightComponent.setWidth(superficialPalmarArch.getImageWidth());
			bioMightComponent.setHeight(superficialPalmarArch.getImageHeight());
			bioMightComponent.setBioMightProperties(superficialPalmarArch.getProperties());
			bioMightComponent.setBioMightMethods(superficialPalmarArch.getMethods());
			
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for SuperficialPalmarArch: "  + bioMightComponent +  "     ID: " + superficialPalmarArch.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(superficialPalmarArch.getComponentID());
			bioMightKeys.setKey(bioMightKey);
				
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing SuperficialPalmarArch Methods!");
			//	plantarMetatarsalVein(methodParams);
			//	plantarMetatarsalVein(0);
			//}
			//System.out.println("Getting X3D for SuperficialPalmarArch!");
			bioMightComponent.setX3D(superficialPalmarArch.getX3D(snippet));			
		}
		else if (bioMightComponentRef.equals(Constants.PlantarVenousArch))
		{
			PlantarVenousArch plantarVenousArch = (PlantarVenousArch) bioMightInstance;
			bioMightComponent.setImage(plantarVenousArch.getImage());
			bioMightComponent.setWidth(plantarVenousArch.getImageWidth());
			bioMightComponent.setHeight(plantarVenousArch.getImageHeight());
			bioMightComponent.setBioMightProperties(plantarVenousArch.getProperties());
			bioMightComponent.setBioMightMethods(plantarVenousArch.getMethods());
			
			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for PlantarVenousArch: "  + bioMightComponent +  "     ID: " + plantarVenousArch.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(plantarVenousArch.getComponentID());
			bioMightKeys.setKey(bioMightKey);
				
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) {
			//	System.out.println("Executing PlantarVenousArch Methods!");
			//	plantarVenousArch(methodParams);
			//	plantarVenousArch(0);
			//}
			//System.out.println("Getting X3D for PlantarVenousArch!");
			bioMightComponent.setX3D(plantarVenousArch.getX3D(snippet));			
		}
		else
		{
			System.out.println("BioMightView Component NOT MATCHED: " + bioMightComponentRef + " " + bioMightComponentName);
		}
	
		
		
	return bioMightComponent;
	}
}
