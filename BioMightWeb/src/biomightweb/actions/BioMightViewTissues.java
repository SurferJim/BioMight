package biomightweb.actions;

import biomight.BioMightKey;
import biomight.BioMightKeys;
import biomight.Constants;
import biomight.system.tissue.Tissues;
import biomight.system.tissue.connective.AdiposeTissue;
import biomight.system.tissue.connective.ConnectiveTissue;
import biomight.system.tissue.connective.blood.Blood;
import biomight.system.tissue.connective.bone.BoneTissue;
import biomight.system.tissue.edothelial.EndotheliumTissue;
import biomight.system.tissue.epithelial.EpitheliumTissue;
import biomight.system.tissue.muscle.MuscleTissue;
import biomight.text.BioArrow;
import biomight.text.BioArrows;
import biomight.text.BioSymbols;
import biomight.text.BioText;
import biomight.text.BioTexts;
import biomightweb.view.BioMightComponent;

/**************************************************************************
 * 
 * Maps BioMight Tissues Components into the associated Java class.
 * 
 * SurferJim
 * 
 *************************************************************************/

public class BioMightViewTissues {

	
	
	public void BioMightViewTissues() {
		
	}
	
	public BioMightComponent mapComponent(BioMightComponent bioMightComponent, Object bioMightInstance, boolean snippet) {

		BioMightKeys bioMightKeys = bioMightComponent.getBioMightKeys();
		String bioMightComponentRef = bioMightComponent.getBioMightComponentRef();
		String bioMightComponentName = bioMightComponent.getBioMightComponentName();
		BioMightKey bioMightKey = new BioMightKey();
		boolean executeMethods = false;
	
		
		if (bioMightComponentRef.equals(Constants.Tissues))
		{
			Tissues tissues = (Tissues) bioMightInstance;
			bioMightComponent.setImage(tissues.getImage());
			bioMightComponent.setBioMightMethods(tissues.getMethods());
			bioMightComponent.setBioMightProperties(tissues.getProperties());
			
			// Assooiate the component and ID.
			bioMightKey = new BioMightKey();
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(tissues.getComponentID());			
			System.out.println("Storing TissuesKey: " + bioMightComponent + "   ID: " + tissues.getComponentID());
			bioMightKeys.setKey(bioMightKey);
					
			// On the post of data, we map the web data back
			// into the methodView object.  
			//if (executeMethods) { 
			//	System.out.println("Executing Body Methods!");
			//	body.executeMethods(methodParams);
			//}
			
			//System.out.println("Getting X3D for Tissues");
			bioMightComponent.setX3D(tissues.getX3D(snippet));	
		}
		else if (bioMightComponentRef.equals(Constants.EpitheliumTissue))
		{
			EpitheliumTissue epitheliumTissue = (EpitheliumTissue) bioMightInstance;
			bioMightComponent.setImage(epitheliumTissue.getImage());
			bioMightComponent.setWidth(epitheliumTissue.getImageWidth());
			bioMightComponent.setHeight(epitheliumTissue.getImageHeight());
			bioMightComponent.setBioMightProperties(epitheliumTissue.getProperties());
			bioMightComponent.setBioMightMethods(epitheliumTissue.getMethods());

			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for EpitheliumTissue: "  + bioMightComponent +  "  ID: " + epitheliumTissue.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(epitheliumTissue.getComponentID());
			bioMightKeys.setKey(bioMightKey);

			bioMightComponent.setX3D(epitheliumTissue.getX3D(snippet));			
		}
		else if (bioMightComponentRef.equals(Constants.MuscleTissue))
		{
			MuscleTissue muscleTissue = (MuscleTissue) bioMightInstance;
			bioMightComponent.setImage(muscleTissue.getImage());
			bioMightComponent.setWidth(muscleTissue.getImageWidth());
			bioMightComponent.setHeight(muscleTissue.getImageHeight());
			bioMightComponent.setBioMightProperties(muscleTissue.getProperties());
			bioMightComponent.setBioMightMethods(muscleTissue.getMethods());

			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for MuscleTissue: "  + bioMightComponent +  "  ID: " + muscleTissue.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(muscleTissue.getComponentID());
			bioMightKeys.setKey(bioMightKey);

			bioMightComponent.setX3D(muscleTissue.getX3D(snippet));			
		}
		else if (bioMightComponentRef.equals(Constants.EndotheliumTissue))
		{
			EndotheliumTissue endotheliumTissue = (EndotheliumTissue) bioMightInstance;
			bioMightComponent.setImage(endotheliumTissue.getImage());
			bioMightComponent.setWidth(endotheliumTissue.getImageWidth());
			bioMightComponent.setHeight(endotheliumTissue.getImageHeight());
			bioMightComponent.setBioMightProperties(endotheliumTissue.getProperties());
			bioMightComponent.setBioMightMethods(endotheliumTissue.getMethods());

			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for EndotheliumTissue: "  + bioMightComponent +  "  ID: " + endotheliumTissue.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(endotheliumTissue.getComponentID());
			bioMightKeys.setKey(bioMightKey);

			bioMightComponent.setX3D(endotheliumTissue.getX3D(snippet));			
		}
		else if (bioMightComponentRef.equals(Constants.ConnectiveTissue))
		{
			ConnectiveTissue connectiveTissue = (ConnectiveTissue) bioMightInstance;
			bioMightComponent.setImage(connectiveTissue.getImage());
			bioMightComponent.setWidth(connectiveTissue.getImageWidth());
			bioMightComponent.setHeight(connectiveTissue.getImageHeight());
			bioMightComponent.setBioMightProperties(connectiveTissue.getProperties());
			bioMightComponent.setBioMightMethods(connectiveTissue.getMethods());

			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database.
			System.out.println("Storing Key for ConnectiveTissue: "  + bioMightComponent +  "  ID: " + connectiveTissue.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(connectiveTissue.getComponentID());
			bioMightKeys.setKey(bioMightKey);

			bioMightComponent.setX3D(connectiveTissue.getX3D(snippet));			
		}
		else if (bioMightComponentRef.equals(Constants.Blood))
		{
			Blood blood = (Blood) bioMightInstance;
			bioMightComponent.setImage(blood.getImage());
			bioMightComponent.setWidth(blood.getImageWidth());
			bioMightComponent.setHeight(blood.getImageHeight());
			bioMightComponent.setBioMightProperties(blood.getProperties());
			bioMightComponent.setBioMightMethods(blood.getMethods());

			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database
			System.out.println("Storing Key for ConnectiveTissue: "  + bioMightComponent +  "  ID: " + blood.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(blood.getComponentID());
			bioMightKeys.setKey(bioMightKey);

			bioMightComponent.setX3D(blood.getX3D(snippet));
		}			
		else if (bioMightComponentRef.equals(Constants.BoneTissue))
		{
			BoneTissue boneTissue = (BoneTissue) bioMightInstance;
			bioMightComponent.setImage(boneTissue.getImage());
			bioMightComponent.setWidth(boneTissue.getImageWidth());
			bioMightComponent.setHeight(boneTissue.getImageHeight());
			bioMightComponent.setBioMightProperties(boneTissue.getProperties());
			bioMightComponent.setBioMightMethods(boneTissue.getMethods());

			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database
			System.out.println("Storing Key for BoneTissue: "  + bioMightComponent +  "  ID: " + boneTissue.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(boneTissue.getComponentID());
			bioMightKeys.setKey(bioMightKey);

			bioMightComponent.setX3D(boneTissue.getX3D(snippet));
		}
		else if (bioMightComponentRef.equals(Constants.AdiposeTissue))
		{
			AdiposeTissue adiposeTissue = (AdiposeTissue) bioMightInstance;
			bioMightComponent.setImage(adiposeTissue.getImage());
			bioMightComponent.setWidth(adiposeTissue.getImageWidth());
			bioMightComponent.setHeight(adiposeTissue.getImageHeight());
			bioMightComponent.setBioMightProperties(adiposeTissue.getProperties());
			bioMightComponent.setBioMightMethods(adiposeTissue.getMethods());

			// Based on the parent ID that was passed in, the component will be
			// retrieved from the BioMight components database
			System.out.println("Storing Key for AdiposeTissue: "  + bioMightComponent +  "  ID: " + adiposeTissue.getComponentID());				
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(adiposeTissue.getComponentID());
			bioMightKeys.setKey(bioMightKey);

			bioMightComponent.setX3D(adiposeTissue.getX3D(snippet));
		}
		else
		{
			System.out.println("BioMightView Tissue Component NOT MATCHED: " + bioMightComponentRef + "  " + bioMightComponentName);
		}
	
		
		
	return bioMightComponent;
	}
}
