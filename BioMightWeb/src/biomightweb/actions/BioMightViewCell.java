package biomightweb.actions;

import java.util.ArrayList;

import biomight.BioMightKey;
import biomight.BioMightKeys;
import biomight.Constants;
import biomight.cell.Cell;
import biomight.cell.CellMembrane;
import biomight.cell.Cells;
import biomight.cell.Centriole;
import biomight.cell.Cytoskeleton;
import biomight.cell.Cytosol;
import biomight.cell.EndoPlasmicReticulumRough;
import biomight.cell.EndoPlasmicReticulumSmooth;
import biomight.cell.Endosome;
import biomight.cell.Endosomes;
import biomight.cell.GolgiApparatus;
import biomight.cell.IonChannel;
import biomight.cell.IonChannels;
import biomight.cell.IonPump;
import biomight.cell.IonPumps;
import biomight.cell.Lysosome;
import biomight.cell.Lysosomes;
import biomight.cell.Melanosome;
import biomight.cell.Melanosomes;
import biomight.cell.Mitochondria;
import biomight.cell.Mitochondrion;
import biomight.cell.Peroxisome;
import biomight.cell.Peroxisomes;
import biomight.cell.Ribosome;
import biomight.cell.Ribosomes;
import biomight.cell.SecretoryVesicle;
import biomight.cell.bloodandimmune.Antibody;
import biomight.cell.bloodandimmune.Antibodies;
import biomight.cell.bloodandimmune.B1Cell;
import biomight.cell.bloodandimmune.BCell;
import biomight.cell.bloodandimmune.BCells;
import biomight.cell.bloodandimmune.Basophil;
import biomight.cell.bloodandimmune.AnimalCell;
import biomight.cell.bloodandimmune.Basophils;
import biomight.cell.bloodandimmune.AnimalCells;
import biomight.cell.bloodandimmune.Eosinophil;
import biomight.cell.bloodandimmune.Eosinophils;
import biomight.cell.bloodandimmune.Erythrocyte;
import biomight.cell.bloodandimmune.Erythrocytes;
import biomight.cell.bloodandimmune.Lymphocyte;
import biomight.cell.bloodandimmune.Lymphocytes;
import biomight.cell.bloodandimmune.Macrophage;
import biomight.cell.bloodandimmune.Macrophages;
import biomight.cell.bloodandimmune.Monocyte;
import biomight.cell.bloodandimmune.Monocytes;
import biomight.cell.bloodandimmune.Neutrophil;
import biomight.cell.bloodandimmune.Neutrophils;
import biomight.cell.neuronglial.nueron.Neuron;
import biomight.cell.neuronglial.nueron.Neurons;
import biomight.cell.nucleus.Chromatin;
import biomight.cell.nucleus.Nuclei;
import biomight.cell.nucleus.Nucleus;
import biomightweb.view.BioMightComponent;

/**
 * Maps BioMight Cell Components into the associated Java class.
 * 
 * SurferJim
 * 
 */

public class BioMightViewCell {

	
	public void BioMightViewCell() {
		
	}
	
	public BioMightComponent mapComponent(BioMightComponent bioMightComponent, Object bioMightInstance, boolean snippet) {

		BioMightKeys bioMightKeys = bioMightComponent.getBioMightKeys();
		String bioMightComponentRef = bioMightComponent.getBioMightComponentRef();
		String bioMightComponentName = bioMightComponent.getBioMightComponentName();
		BioMightKey bioMightKey = new BioMightKey();
		boolean executeMethods = false;
	
		/**************************************************************************
		*
		* CELLS SYSTEM
		*
		* This section maps the data in the biomight object into the presentation 
		* layer.  
		*  
		***************************************************************************/
		
		if (bioMightComponentRef.equals(Constants.Cells))
		{
			Cells cells = (Cells) bioMightInstance;
			bioMightComponent.setImage(cells.getImage());
			bioMightComponent.setBioMightProperties(cells.getProperties());
			bioMightComponent.setBioMightMethods(cells.getMethods());		
			bioMightComponent.setX3D(cells.getX3D(true));
			bioMightComponent.setBioMightCollection(true);
			
			// Assooiate the component and ID.
			bioMightKey = new BioMightKey();
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(cells.getComponentID());			
			System.out.println("Storing CellKey: " + bioMightComponentName + "   ID: " + cells.getComponentID());
			bioMightKeys.setKey(bioMightKey);

			// On the post of data, we map the web data back
			// into the methodView object.  
			if (executeMethods) {
				//cells.executeMethods(bioMightComponent.getBioMightMethods());
				bioMightComponent.setX3D(cells.getX3D(true));
			}	
			
		}	
		else if (bioMightComponentRef.equals(Constants.Cell))
		{
			Cell cell = (Cell) bioMightInstance;
			bioMightComponent.setImage(cell.getImage());
			bioMightComponent.setBioMightProperties(cell.getProperties());
			bioMightComponent.setBioMightMethods(cell.getMethods());
			bioMightComponent.setX3D(cell.getX3D(snippet));
		
			// Assooiate the component and ID.
			bioMightKey = new BioMightKey();
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(cell.getComponentID());			
			System.out.println("Storing CellKey: " + bioMightComponentName + "   ID: " + cell.getComponentID());
			bioMightKeys.setKey(bioMightKey);

			// On the post of data, we map the web data back
			// into the methodView object.  
			if (executeMethods) {
				cell.executeMethods(bioMightComponent.getBioMightMethods());
				bioMightComponent.setX3D(cell.getX3D(snippet));
			}
		}
		
		// CELL TYPES
		else if (bioMightComponentRef.equals(Constants.AnimalCell))
		{
			AnimalCell basophil = (AnimalCell) bioMightInstance;
			bioMightComponent.setImage(basophil.getImage());
			bioMightComponent.setBioMightProperties(basophil.getProperties());
			bioMightComponent.setBioMightMethods(basophil.getMethods());
			bioMightComponent.setX3D(basophil.getX3D(snippet));
		
			// Assooiate the component and ID.
			bioMightKey = new BioMightKey();
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(basophil.getComponentID());			
			System.out.println("Storing AnimalCellKey: " + bioMightComponent + "   ID: " + basophil.getComponentID());
			bioMightKeys.setKey(bioMightKey);

			// On the post of data, we map the web data back
			// into the methodView object.  
			if (executeMethods) {
				basophil.executeMethods(bioMightComponent.getBioMightMethods());
				bioMightComponent.setX3D(basophil.getX3D(snippet));
			}
		}
		else if (bioMightComponentRef.equals(Constants.AnimalCells))
		{
			AnimalCells basophils = (AnimalCells) bioMightInstance;
			bioMightComponent.setImage(basophils.getImage());
			bioMightComponent.setBioMightProperties(basophils.getProperties());
			bioMightComponent.setBioMightMethods(basophils.getMethods());
			bioMightComponent.setX3D(basophils.getX3D(snippet));
			bioMightComponent.setBioMightCollection(true);
			
			// Assooiate the component and ID.
			bioMightKey = new BioMightKey();
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(basophils.getComponentID());			
			System.out.println("Storing AnimalCellsKey: " + bioMightComponent + "   ID: " + basophils.getComponentID());
			bioMightKeys.setKey(bioMightKey);

			// On the post of data, we map the web data back
			// into the methodView object.  
			if (executeMethods) {
				basophils.executeMethods(bioMightComponent.getBioMightMethods());
				bioMightComponent.setX3D(basophils.getX3D(snippet));
			}
		}
		else if (bioMightComponentRef.equals(Constants.Basophil))
		{
			Basophil basophil = (Basophil) bioMightInstance;
			bioMightComponent.setImage(basophil.getImage());
			bioMightComponent.setBioMightProperties(basophil.getProperties());
			bioMightComponent.setBioMightMethods(basophil.getMethods());
			bioMightComponent.setX3D(basophil.getX3D(snippet));
		
			// Assooiate the component and ID.
			bioMightKey = new BioMightKey();
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(basophil.getComponentID());			
			System.out.println("Storing BasophilKey: " + bioMightComponent + "   ID: " + basophil.getComponentID());
			bioMightKeys.setKey(bioMightKey);

			// On the post of data, we map the web data back
			// into the methodView object.  
			if (executeMethods) {
				basophil.executeMethods(bioMightComponent.getBioMightMethods());
				bioMightComponent.setX3D(basophil.getX3D(snippet));
			}
		}
		else if (bioMightComponentRef.equals(Constants.Basophils))
		{
			Basophils basophils = (Basophils) bioMightInstance;
			bioMightComponent.setImage(basophils.getImage());
			bioMightComponent.setBioMightProperties(basophils.getProperties());
			bioMightComponent.setBioMightMethods(basophils.getMethods());
			bioMightComponent.setX3D(basophils.getX3D(snippet));
			bioMightComponent.setBioMightCollection(true);
			
			// Assooiate the component and ID.
			bioMightKey = new BioMightKey();
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(basophils.getComponentID());			
			System.out.println("Storing BasophilsKey: " + bioMightComponent + "   ID: " + basophils.getComponentID());
			bioMightKeys.setKey(bioMightKey);

			// On the post of data, we map the web data back
			// into the methodView object.  
			if (executeMethods) {
				basophils.executeMethods(bioMightComponent.getBioMightMethods());
				bioMightComponent.setX3D(basophils.getX3D(snippet));
			}
		}
		else if (bioMightComponentRef.equals(Constants.Erythrocyte))
		{
			Erythrocyte erythrocyte = (Erythrocyte) bioMightInstance;
			bioMightComponent.setImage(erythrocyte.getImage());
			bioMightComponent.setBioMightProperties(erythrocyte.getProperties());
			bioMightComponent.setBioMightMethods(erythrocyte.getMethods());
			bioMightComponent.setX3D(erythrocyte.getX3D(snippet));
		
			// Assooiate the component and ID.
			bioMightKey = new BioMightKey();
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(erythrocyte.getComponentID());			
			System.out.println("Storing ErythrocyteKey: " + bioMightComponent + "   ID: " + erythrocyte.getComponentID());
			bioMightKeys.setKey(bioMightKey);

			// On the post of data, we map the web data back
			// into the methodView object.  
			if (executeMethods) {
				erythrocyte.executeMethods(bioMightComponent.getBioMightMethods());
				bioMightComponent.setX3D(erythrocyte.getX3D(snippet));
			}
		}
		else if (bioMightComponentRef.equals(Constants.Erythrocytes))
		{
			Erythrocytes erythrocytes = (Erythrocytes) bioMightInstance;
			bioMightComponent.setImage(erythrocytes.getImage());
			bioMightComponent.setBioMightProperties(erythrocytes.getProperties());
			bioMightComponent.setBioMightMethods(erythrocytes.getMethods());
			bioMightComponent.setX3D(erythrocytes.getX3D(snippet));
			bioMightComponent.setBioMightCollection(true);
			
			// Assooiate the component and ID.
			bioMightKey = new BioMightKey();
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(erythrocytes.getComponentID());			
			System.out.println("Storing ErythrocytesKey: " + bioMightComponent + "   ID: " + erythrocytes.getComponentID());
			bioMightKeys.setKey(bioMightKey);

			// On the post of data, we map the web data back
			// into the methodView object.  
			if (executeMethods) {
				erythrocytes.executeMethods(bioMightComponent.getBioMightMethods());
				bioMightComponent.setX3D(erythrocytes.getX3D(snippet));
			}
		}
		else if (bioMightComponentRef.equals(Constants.Lymphocyte))
		{
			Lymphocyte lymphocyte = (Lymphocyte) bioMightInstance;
			bioMightComponent.setImage(lymphocyte.getImage());
			bioMightComponent.setBioMightProperties(lymphocyte.getProperties());
			bioMightComponent.setBioMightMethods(lymphocyte.getMethods());
			bioMightComponent.setX3D(lymphocyte.getX3D(snippet));
		
			// Assooiate the component and ID.
			bioMightKey = new BioMightKey();
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(lymphocyte.getComponentID());			
			System.out.println("Storing LymphocyteKey: " + bioMightComponent + "   ID: " + lymphocyte.getComponentID());
			bioMightKeys.setKey(bioMightKey);

			// On the post of data, we map the web data back
			// into the methodView object.  
			if (executeMethods) {
				lymphocyte.executeMethods(bioMightComponent.getBioMightMethods());
				bioMightComponent.setX3D(lymphocyte.getX3D(snippet));
			}
		}
		else if (bioMightComponentRef.equals(Constants.Lymphocytes))
		{
			Lymphocytes lymphocytes = (Lymphocytes) bioMightInstance;
			bioMightComponent.setImage(lymphocytes.getImage());
			bioMightComponent.setBioMightProperties(lymphocytes.getProperties());
			bioMightComponent.setBioMightMethods(lymphocytes.getMethods());
			bioMightComponent.setX3D(lymphocytes.getX3D(snippet));
			bioMightComponent.setBioMightCollection(true);
			
			// Assooiate the component and ID.
			bioMightKey = new BioMightKey();
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(lymphocytes.getComponentID());			
			System.out.println("Storing LymphocytesKey: " + bioMightComponent + "   ID: " + lymphocytes.getComponentID());
			bioMightKeys.setKey(bioMightKey);

			// On the post of data, we map the web data back
			// into the methodView object.  
			if (executeMethods) {
				lymphocytes.executeMethods(bioMightComponent.getBioMightMethods());
				bioMightComponent.setX3D(lymphocytes.getX3D(snippet));
			}
		}
		else if (bioMightComponentRef.equals(Constants.Monocyte))
		{
			Monocyte monocyte = (Monocyte) bioMightInstance;
			bioMightComponent.setImage(monocyte.getImage());
			bioMightComponent.setBioMightProperties(monocyte.getProperties());
			bioMightComponent.setBioMightMethods(monocyte.getMethods());
			bioMightComponent.setX3D(monocyte.getX3D(snippet));
			bioMightComponent.setBioMightCollection(true);
			
			// Assooiate the component and ID.
			bioMightKey = new BioMightKey();
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(monocyte.getComponentID());			
			System.out.println("Storing MonocyteKey: " + bioMightComponent + "   ID: " + monocyte.getComponentID());
			bioMightKeys.setKey(bioMightKey);

			// On the post of data, we map the web data back
			// into the methodView object.  
			if (executeMethods) {
				monocyte.executeMethods(bioMightComponent.getBioMightMethods());
				bioMightComponent.setX3D(monocyte.getX3D(snippet));
			}
		}
		else if (bioMightComponentRef.equals(Constants.Monocytes))
		{
			Monocytes monocytes = (Monocytes) bioMightInstance;
			bioMightComponent.setImage(monocytes.getImage());
			bioMightComponent.setBioMightProperties(monocytes.getProperties());
			bioMightComponent.setBioMightMethods(monocytes.getMethods());
			bioMightComponent.setX3D(monocytes.getX3D(snippet));
			bioMightComponent.setBioMightCollection(true);
			
			// Assooiate the component and ID.
			bioMightKey = new BioMightKey();
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(monocytes.getComponentID());			
			System.out.println("Storing MonocytesKey: " + bioMightComponent + "   ID: " + monocytes.getComponentID());
			bioMightKeys.setKey(bioMightKey);

			// On the post of data, we map the web data back
			// into the methodView object.  
			if (executeMethods) {
				monocytes.executeMethods(bioMightComponent.getBioMightMethods());
				bioMightComponent.setX3D(monocytes.getX3D(snippet));
			}
		}
		else if (bioMightComponentRef.equals(Constants.Eosinophils))
		{
			Eosinophils eosinophils = (Eosinophils) bioMightInstance;
			bioMightComponent.setImage(eosinophils.getImage());
			bioMightComponent.setBioMightProperties(eosinophils.getProperties());
			bioMightComponent.setBioMightMethods(eosinophils.getMethods());
			bioMightComponent.setX3D(eosinophils.getX3D(snippet));
			bioMightComponent.setBioMightCollection(true);
			
			// Assooiate the component and ID.
			bioMightKey = new BioMightKey();
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(eosinophils.getComponentID());			
			System.out.println("Storing EosinophilsKey: " + bioMightComponent + "   ID: " + eosinophils.getComponentID());
			bioMightKeys.setKey(bioMightKey);

			// On the post of data, we map the web data back
			// into the methodView object.  
			if (executeMethods) {
				eosinophils.executeMethods(bioMightComponent.getBioMightMethods());
				bioMightComponent.setX3D(eosinophils.getX3D(snippet));
			}
		}		
		else if (bioMightComponentRef.equals(Constants.Eosinophil))
		{
			Eosinophil eosinophil = (Eosinophil) bioMightInstance;
			bioMightComponent.setImage(eosinophil.getImage());
			bioMightComponent.setBioMightProperties(eosinophil.getProperties());
			bioMightComponent.setBioMightMethods(eosinophil.getMethods());
			bioMightComponent.setX3D(eosinophil.getX3D(snippet));
		
			// Assooiate the component and ID.
			bioMightKey = new BioMightKey();
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(eosinophil.getComponentID());			
			System.out.println("Storing EosinophilKey: " + bioMightComponent + "   ID: " + eosinophil.getComponentID());
			bioMightKeys.setKey(bioMightKey);

			// On the post of data, we map the web data back
			// into the methodView object.  
			if (executeMethods) {
				eosinophil.executeMethods(bioMightComponent.getBioMightMethods());
				bioMightComponent.setX3D(eosinophil.getX3D(snippet));
			}
		}
		else if (bioMightComponentRef.equals(Constants.Neutrophils))
		{
			Neutrophils neutrophils = (Neutrophils) bioMightInstance;
			bioMightComponent.setImage(neutrophils.getImage());
			bioMightComponent.setBioMightProperties(neutrophils.getProperties());
			bioMightComponent.setBioMightMethods(neutrophils.getMethods());
			bioMightComponent.setX3D(neutrophils.getX3D(snippet));
			bioMightComponent.setBioMightCollection(true);
			
			// Assooiate the component and ID.
			bioMightKey = new BioMightKey();
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(neutrophils.getComponentID());			
			System.out.println("Storing NeutrophilsKey: " + bioMightComponent + "   ID: " + neutrophils.getComponentID());
			bioMightKeys.setKey(bioMightKey);

			// On the post of data, we map the web data back
			// into the methodView object.  
			if (executeMethods) {
				neutrophils.executeMethods(bioMightComponent.getBioMightMethods());
				bioMightComponent.setX3D(neutrophils.getX3D(snippet));
			}
		}		
		else if (bioMightComponentRef.equals(Constants.Neuron))
		{
			Neuron neuron = (Neuron) bioMightInstance;
			bioMightComponent.setImage(neuron.getImage());
			bioMightComponent.setBioMightProperties(neuron.getProperties());
			bioMightComponent.setBioMightMethods(neuron.getMethods());
			bioMightComponent.setX3D(neuron.getX3D(snippet));
		
			// Assooiate the component and ID.
			bioMightKey = new BioMightKey();
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(neuron.getComponentID());			
			System.out.println("Storing NeuronKey: " + bioMightComponent + "   ID: " + neuron.getComponentID());
			bioMightKeys.setKey(bioMightKey);

			// On the post of data, we map the web data back
			// into the methodView object.  
			if (executeMethods) {
				neuron.executeMethods(bioMightComponent.getBioMightMethods());
				bioMightComponent.setX3D(neuron.getX3D(snippet));
			}
		}
		else if (bioMightComponentRef.equals(Constants.Neurons))
		{
			Neurons neurons = (Neurons) bioMightInstance;
			bioMightComponent.setImage(neurons.getImage());
			bioMightComponent.setBioMightProperties(neurons.getProperties());
			bioMightComponent.setBioMightMethods(neurons.getMethods());
			bioMightComponent.setX3D(neurons.getX3D(snippet));
			bioMightComponent.setBioMightCollection(true);
			
			// Assooiate the component and ID.
			bioMightKey = new BioMightKey();
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(neurons.getComponentID());			
			System.out.println("Storing NeuronsKey: " + bioMightComponent + "   ID: " + neurons.getComponentID());
			bioMightKeys.setKey(bioMightKey);

			// On the post of data, we map the web data back
			// into the methodView object.  
			if (executeMethods) {
				neurons.executeMethods(bioMightComponent.getBioMightMethods());
				bioMightComponent.setX3D(neurons.getX3D(snippet));
			}
		}		
		else if (bioMightComponentRef.equals(Constants.Neutrophil))
		{
			Neutrophil neutrophil = (Neutrophil) bioMightInstance;
			bioMightComponent.setImage(neutrophil.getImage());
			bioMightComponent.setBioMightProperties(neutrophil.getProperties());
			bioMightComponent.setBioMightMethods(neutrophil.getMethods());
			bioMightComponent.setX3D(neutrophil.getX3D(snippet));
		
			// Assooiate the component and ID.
			bioMightKey = new BioMightKey();
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(neutrophil.getComponentID());			
			System.out.println("Storing NeutrophilKey: " + bioMightComponent + "   ID: " + neutrophil.getComponentID());
			bioMightKeys.setKey(bioMightKey);

			// On the post of data, we map the web data back
			// into the methodView object.  
			if (executeMethods) {
				neutrophil.executeMethods(bioMightComponent.getBioMightMethods());
				bioMightComponent.setX3D(neutrophil.getX3D(snippet));
			}
		}
		else if (bioMightComponentRef.equals(Constants.Macrophages))
		{
			Macrophages macrophages = (Macrophages) bioMightInstance;
			bioMightComponent.setImage(macrophages.getImage());
			bioMightComponent.setBioMightProperties(macrophages.getProperties());
			bioMightComponent.setBioMightMethods(macrophages.getMethods());
			bioMightComponent.setX3D(macrophages.getX3D(snippet));
			bioMightComponent.setBioMightCollection(true);
			
			// Assooiate the component and ID.
			bioMightKey = new BioMightKey();
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(macrophages.getComponentID());			
			System.out.println("Storing macrophagesKey: " + bioMightComponent + "   ID: " + macrophages.getComponentID());
			bioMightKeys.setKey(bioMightKey);

			// On the post of data, we map the web data back
			// into the methodView object.  
			if (executeMethods) {
				macrophages.executeMethods(bioMightComponent.getBioMightMethods());
				bioMightComponent.setX3D(macrophages.getX3D(snippet));
			}
		}		
		else if (bioMightComponentRef.equals(Constants.Macrophage))
		{
			Macrophage macrophage = (Macrophage) bioMightInstance;
			bioMightComponent.setImage(macrophage.getImage());
			bioMightComponent.setBioMightProperties(macrophage.getProperties());
			bioMightComponent.setBioMightMethods(macrophage.getMethods());
			bioMightComponent.setX3D(macrophage.getX3D(snippet));
		
			// Assooiate the component and ID.
			bioMightKey = new BioMightKey();
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(macrophage.getComponentID());			
			System.out.println("Storing macrophageKey: " + bioMightComponent + "   ID: " + macrophage.getComponentID());
			bioMightKeys.setKey(bioMightKey);

			// On the post of data, we map the web data back
			// into the methodView object.  
			if (executeMethods) {
				macrophage.executeMethods(bioMightComponent.getBioMightMethods());
				bioMightComponent.setX3D(macrophage.getX3D(snippet));
			}
		}
		else if (bioMightComponentRef.equals(Constants.BCells))
		{
			BCells bCells = (BCells) bioMightInstance;
			bioMightComponent.setImage(bCells.getImage());
			bioMightComponent.setBioMightProperties(bCells.getProperties());
			bioMightComponent.setBioMightMethods(bCells.getMethods());
			bioMightComponent.setX3D(bCells.getX3D(snippet));
		
			// Assooiate the component and ID.
			bioMightKey = new BioMightKey();
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(bCells.getComponentID());			
			System.out.println("Storing bCellKey: " + bioMightComponent + "   ID: " + bCells.getComponentID());
			bioMightKeys.setKey(bioMightKey);

			// On the post of data, we map the web data back
			// into the methodView object.  
			if (executeMethods) {
				bCells.executeMethods(bioMightComponent.getBioMightMethods());
				bioMightComponent.setX3D(bCells.getX3D(snippet));
			}
		}
		else if (bioMightComponentRef.equals(Constants.BCell))
		{
			BCell bCell = (BCell) bioMightInstance;
			bioMightComponent.setImage(bCell.getImage());
			bioMightComponent.setBioMightProperties(bCell.getProperties());
			bioMightComponent.setBioMightMethods(bCell.getMethods());
			bioMightComponent.setX3D(bCell.getX3D(snippet));
		
			// Assooiate the component and ID.
			bioMightKey = new BioMightKey();
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(bCell.getComponentID());			
			System.out.println("Storing bCellKey: " + bioMightComponent + "   ID: " + bCell.getComponentID());
			bioMightKeys.setKey(bioMightKey);

			// On the post of data, we map the web data back
			// into the methodView object.  
			if (executeMethods) {
				bCell.executeMethods(bioMightComponent.getBioMightMethods());
				bioMightComponent.setX3D(bCell.getX3D(snippet));
			}
		}	
		else if (bioMightComponentRef.equals(Constants.Antigens))
		{
			Antibodies antigens = (Antibodies) bioMightInstance;
			bioMightComponent.setImage(antigens.getImage());
			bioMightComponent.setBioMightProperties(antigens.getProperties());
			bioMightComponent.setBioMightMethods(antigens.getMethods());
			bioMightComponent.setX3D(antigens.getX3D(snippet));
		
			// Associate the component and ID.2
			bioMightKey = new BioMightKey();
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(antigens.getComponentID());			
			System.out.println("Storing antigensKey: " + bioMightComponent + "   ID: " + antigens.getComponentID());
			bioMightKeys.setKey(bioMightKey);

			// On the post of data, we map the web data back
			// into the methodView object.  
			if (executeMethods) {
				antigens.executeMethods(bioMightComponent.getBioMightMethods());
				bioMightComponent.setX3D(antigens.getX3D(snippet));
			}
		}
		else if (bioMightComponentRef.equals(Constants.Antigen))
		{
			Antibody antigen = (Antibody) bioMightInstance;
			bioMightComponent.setImage(antigen.getImage());
			bioMightComponent.setBioMightProperties(antigen.getProperties());
			bioMightComponent.setBioMightMethods(antigen.getMethods());
			bioMightComponent.setX3D(antigen.getX3D(snippet));
		
			// Assooiate the component and ID.
			bioMightKey = new BioMightKey();
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(antigen.getComponentID());			
			System.out.println("Storing antigenKey: " + bioMightComponent + "   ID: " + antigen.getComponentID());
			bioMightKeys.setKey(bioMightKey);

			// On the post of data, we map the web data back
			// into the methodView object.  
			if (executeMethods) {
				antigen.executeMethods(bioMightComponent.getBioMightMethods());
				bioMightComponent.setX3D(antigen.getX3D(snippet));
			}
		}	
		else if (bioMightComponentRef.equals(Constants.Antibodies))
		{
			Antibodies antibodies = (Antibodies) bioMightInstance;
			bioMightComponent.setImage(antibodies.getImage());
			bioMightComponent.setBioMightProperties(antibodies.getProperties());
			bioMightComponent.setBioMightMethods(antibodies.getMethods());
			bioMightComponent.setX3D(antibodies.getX3D(snippet));
		
			// Associate the component and ID.2
			bioMightKey = new BioMightKey();
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(antibodies.getComponentID());			
			System.out.println("Storing antibodies: " + bioMightComponent + "   ID: " + antibodies.getComponentID());
			bioMightKeys.setKey(bioMightKey);

			// On the post of data, we map the web data back
			// into the methodView object.  
			if (executeMethods) {
				antibodies.executeMethods(bioMightComponent.getBioMightMethods());
				bioMightComponent.setX3D(antibodies.getX3D(snippet));
			}
		}
		else if (bioMightComponentRef.equals(Constants.Antibody))
		{
			Antibody antibody = (Antibody) bioMightInstance;
			bioMightComponent.setImage(antibody.getImage());
			bioMightComponent.setBioMightProperties(antibody.getProperties());
			bioMightComponent.setBioMightMethods(antibody.getMethods());
			bioMightComponent.setX3D(antibody.getX3D(snippet));
		
			// Assooiate the component and ID.
			bioMightKey = new BioMightKey();
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(antibody.getComponentID());			
			System.out.println("Storing antigenKey: " + bioMightComponent + "   ID: " + antibody.getComponentID());
			bioMightKeys.setKey(bioMightKey);

			// On the post of data, we map the web data back
			// into the methodView object.  
			if (executeMethods) {
				antibody.executeMethods(bioMightComponent.getBioMightMethods());
				bioMightComponent.setX3D(antibody.getX3D(snippet));
			}
		}	
		else if (bioMightComponentRef.equals(Constants.CellMembrane))
		{
			CellMembrane cellMembrane = (CellMembrane) bioMightInstance;
			bioMightComponent.setImage(cellMembrane.getImage());
			bioMightComponent.setBioMightProperties(cellMembrane.getProperties());
			bioMightComponent.setBioMightMethods(cellMembrane.getMethods());
			bioMightComponent.setX3D(cellMembrane.getX3D(snippet));
		
			// Assooiate the component and ID.
			bioMightKey = new BioMightKey();
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(cellMembrane.getComponentID());			
			System.out.println("Storing CellMembraneKey: " + bioMightComponent + "   ID: " + cellMembrane.getComponentID());
			bioMightKeys.setKey(bioMightKey);

			// On the post of data, we map the web data back
			// into the methodView object.  
			if (executeMethods) {
				cellMembrane.executeMethods(bioMightComponent.getBioMightMethods());
				bioMightComponent.setX3D(cellMembrane.getX3D(snippet));
			}
		}
		//else if (bioMightComponentRef.equals(Constants.CellWall))
		//{
	//		CellWall cellWall = (CellWall) bioMightInstance;
	//		bioMightComponent.setImage(cellWall.getImage());
	//	}			
		else if (bioMightComponentRef.equals(Constants.Centriole))
		{
			Centriole centriole = (Centriole) bioMightInstance;
			bioMightComponent.setImage(centriole.getImage());
			bioMightComponent.setBioMightProperties(centriole.getProperties());
			bioMightComponent.setBioMightMethods(centriole.getMethods());	
		}	
		else if (bioMightComponentRef.equals(Constants.Chromatin))
		{
			Chromatin chromatin = (Chromatin) bioMightInstance;
			bioMightComponent.setImage(chromatin.getImage());
		}			
		else if (bioMightComponentRef.equals(Constants.Cytoskeleton))
		{
			Cytoskeleton cytoskeleton = (Cytoskeleton) bioMightInstance;
			bioMightComponent.setImage(cytoskeleton.getImage());
		}
		else if (bioMightComponentRef.equals(Constants.Cytosol))
		{
			Cytosol cytosol = (Cytosol) bioMightInstance;
			bioMightComponent.setImage(cytosol.getImage());
		}
		else if (bioMightComponentRef.equals(Constants.EndoPlasmicReticulumRough))
		{
			EndoPlasmicReticulumRough endoPlasmicReticulumRough = (EndoPlasmicReticulumRough) bioMightInstance;
			bioMightComponent.setImage(endoPlasmicReticulumRough.getImage());
		}
		else if (bioMightComponentRef.equals(Constants.EndoPlasmicReticulumSmooth))
		{
			EndoPlasmicReticulumSmooth endoPlasmicReticulumSmooth = (EndoPlasmicReticulumSmooth) bioMightInstance;
			bioMightComponent.setImage(endoPlasmicReticulumSmooth.getImage());
		}
		else if (bioMightComponentRef.equals(Constants.Endosome))
		{
			Endosome endosome = (Endosome) bioMightInstance;
			bioMightComponent.setImage(endosome.getImage());
			bioMightComponent.setBioMightProperties(endosome.getProperties());
			bioMightComponent.setBioMightMethods(endosome.getMethods());
			bioMightComponent.setX3D(endosome.getX3D(snippet));
			
			// Assooiate the component and ID.
			bioMightKey = new BioMightKey();
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(endosome.getComponentID());			
			System.out.println("Storing endosomeKey: " + bioMightComponent + "   ID: " + endosome.getComponentID());
			bioMightKeys.setKey(bioMightKey);

			// On the post of data, we map the web data back
			// into the methodView object.  
			if (executeMethods) {
				endosome.executeMethods(bioMightComponent.getBioMightMethods());
				bioMightComponent.setX3D(endosome.getX3D(snippet));
			}
		}
		else if (bioMightComponentRef.equals(Constants.Endosomes))
		{
			Endosomes endosomes = (Endosomes) bioMightInstance;
			bioMightComponent.setImage(endosomes.getImage());
			bioMightComponent.setBioMightProperties(endosomes.getProperties());
			bioMightComponent.setBioMightMethods(endosomes.getMethods());
			bioMightComponent.setX3D(endosomes.getX3D(snippet));
			bioMightComponent.setBioMightCollection(true);
			
			// Assooiate the component and ID.
			bioMightKey = new BioMightKey();
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(endosomes.getComponentID());			
			System.out.println("Storing EndosomesKey: " + bioMightComponent + "   ID: " + endosomes.getComponentID());
			bioMightKeys.setKey(bioMightKey);

			// On the post of data, we map the web data back
			// into the methodView object.  
			if (executeMethods) {
				endosomes.executeMethods(bioMightComponent.getBioMightMethods());
				bioMightComponent.setX3D(endosomes.getX3D(snippet));
			}	
		}
		else if (bioMightComponentRef.equals(Constants.GolgiApparatus))
		{
			GolgiApparatus golgiApparatus = (GolgiApparatus) bioMightInstance;
			bioMightComponent.setImage(golgiApparatus.getImage());
			bioMightComponent.setBioMightProperties(golgiApparatus.getProperties());
			bioMightComponent.setBioMightMethods(golgiApparatus.getMethods());
			bioMightComponent.setX3D(golgiApparatus.getX3D(snippet));
			bioMightComponent.setBioMightCollection(false);
			
			// Assooiate the component and ID.
			bioMightKey = new BioMightKey();
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(golgiApparatus.getComponentID());			
			System.out.println("Storing GolgiApparatusKey: " + bioMightComponent + "   ID: " + golgiApparatus.getComponentID());
			bioMightKeys.setKey(bioMightKey);

			// On the post of data, we map the web data back
			// into the methodView object.  
			if (executeMethods) {
				golgiApparatus.executeMethods(bioMightComponent.getBioMightMethods());
				bioMightComponent.setX3D(golgiApparatus.getX3D(snippet));
			}	

		}
		else if (bioMightComponentRef.equals(Constants.Lysosome))
		{
			Lysosome lysosome = (Lysosome) bioMightInstance;
			bioMightComponent.setImage(lysosome.getImage());
			bioMightComponent.setBioMightProperties(lysosome.getProperties());
			bioMightComponent.setBioMightMethods(lysosome.getMethods());
			bioMightComponent.setX3D(lysosome.getX3D(snippet));
			
			// Assooiate the component and ID.
			bioMightKey = new BioMightKey();
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(lysosome.getComponentID());			
			System.out.println("Storing lysosomeKey: " + bioMightComponent + "   ID: " + lysosome.getComponentID());
			bioMightKeys.setKey(bioMightKey);

			// On the post of data, we map the web data back
			// into the methodView object.  
			if (executeMethods) {
				lysosome.executeMethods(bioMightComponent.getBioMightMethods());
				bioMightComponent.setX3D(lysosome.getX3D(snippet));
			}
		}			
		else if (bioMightComponentRef.equals(Constants.Lysosomes))
		{
			Lysosomes lysosomes = (Lysosomes) bioMightInstance;
			bioMightComponent.setImage(lysosomes.getImage());
			bioMightComponent.setBioMightProperties(lysosomes.getProperties());
			bioMightComponent.setBioMightMethods(lysosomes.getMethods());
			bioMightComponent.setX3D(lysosomes.getX3D(snippet));
			
			// Assooiate the component and ID.
			bioMightKey = new BioMightKey();
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(lysosomes.getComponentID());			
			System.out.println("Storing lysosomesKey: " + bioMightComponent + "   ID: " + lysosomes.getComponentID());
			bioMightKeys.setKey(bioMightKey);

			// On the post of data, we map the web data back
			// into the methodView object.  
			if (executeMethods) {
				lysosomes.executeMethods(bioMightComponent.getBioMightMethods());
				bioMightComponent.setX3D(lysosomes.getX3D(snippet));
			}
		}		
		else if (bioMightComponentRef.equals(Constants.Mitochondrion))
		{
			Mitochondrion mitochondrion = (Mitochondrion) bioMightInstance;
			bioMightComponent.setImage(mitochondrion.getImage());
			bioMightComponent.setBioMightProperties(mitochondrion.getProperties());
			bioMightComponent.setBioMightMethods(mitochondrion.getMethods());
			bioMightComponent.setX3D(mitochondrion.getX3D(snippet));
		
			// Assooiate the component and ID.
			bioMightKey = new BioMightKey();
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(mitochondrion.getComponentID());			
			System.out.println("Storing MitochondriaKey: " + bioMightComponent + "   ID: " + mitochondrion.getComponentID());
			bioMightKeys.setKey(bioMightKey);

			// On the post of data, we map the web data back
			// into the methodView object.  
			if (executeMethods) {
				mitochondrion.executeMethods(bioMightComponent.getBioMightMethods());
				bioMightComponent.setX3D(mitochondrion.getX3D(snippet));
			}
		}	
		else if (bioMightComponentRef.equals(Constants.Mitochondria))
		{
			Mitochondria mitochondria = (Mitochondria) bioMightInstance;
			bioMightComponent.setImage(mitochondria.getImage());
			bioMightComponent.setBioMightProperties(mitochondria.getProperties());
			bioMightComponent.setBioMightMethods(mitochondria.getMethods());
			bioMightComponent.setX3D(mitochondria.getX3D(snippet));
		
			// Assooiate the component and ID.
			bioMightKey = new BioMightKey();
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(mitochondria.getComponentID());			
			System.out.println("Storing MitochondriaKey: " + bioMightComponent + "   ID: " + mitochondria.getComponentID());
			bioMightKeys.setKey(bioMightKey);

			// On the post of data, we map the web data back
			// into the methodView object.  
			if (executeMethods) {
				mitochondria.executeMethods(bioMightComponent.getBioMightMethods());
				bioMightComponent.setX3D(mitochondria.getX3D(snippet));
			}
		}
		else if (bioMightComponentRef.equals(Constants.Nucleus))
		{
			Nucleus nucleus = (Nucleus) bioMightInstance;
			bioMightComponent.setImage(nucleus.getImage());
			bioMightComponent.setBioMightProperties(nucleus.getProperties());
			bioMightComponent.setBioMightMethods(nucleus.getMethods());
			bioMightComponent.setX3D(nucleus.getX3D(snippet));
		
			// Assooiate the component and ID.
			bioMightKey = new BioMightKey();
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(nucleus.getComponentID());			
			System.out.println("Storing NucleusKey: " + bioMightComponent + "   ID: " + nucleus.getComponentID());
			bioMightKeys.setKey(bioMightKey);

			// On the post of data, we map the web data back
			// into the methodView object.  
			if (executeMethods) {
				//nucleus.executeMethods(bioMightComponent.getBioMightMethods());
				bioMightComponent.setX3D(nucleus.getX3D(snippet));
			}				
		}
		else if (bioMightComponentRef.equals(Constants.Nuclei))
		{
			Nuclei nuclei = (Nuclei) bioMightInstance;
			bioMightComponent.setImage(nuclei.getImage());
			bioMightComponent.setBioMightProperties(nuclei.getProperties());
			bioMightComponent.setBioMightMethods(nuclei.getMethods());
			bioMightComponent.setX3D(nuclei.getX3D(snippet));
		
			// Assooiate the component and ID.
			bioMightKey = new BioMightKey();
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(nuclei.getComponentID());			
			System.out.println("Storing NucleiKey: " + bioMightComponent + "   ID: " + nuclei.getComponentID());
			bioMightKeys.setKey(bioMightKey);

			// On the post of data, we map the web data back
			// into the methodView object.  
			if (executeMethods) {
				//nucleus.executeMethods(bioMightComponent.getBioMightMethods());
				bioMightComponent.setX3D(nuclei.getX3D(snippet));
			}				
		}
		else if (bioMightComponentRef.equals(Constants.Peroxisome))
		{
			Peroxisome peroxisome = (Peroxisome) bioMightInstance;
			bioMightComponent.setImage(peroxisome.getImage());
			bioMightComponent.setBioMightProperties(peroxisome.getProperties());
			bioMightComponent.setBioMightMethods(peroxisome.getMethods());
			bioMightComponent.setX3D(peroxisome.getX3D(snippet));
		
			// Assooiate the component and ID.
			bioMightKey = new BioMightKey();
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(peroxisome.getComponentID());			
			System.out.println("Storing PeroxisomeKey: " + bioMightComponent + "   ID: " + peroxisome.getComponentID());
			bioMightKeys.setKey(bioMightKey);

			// On the post of data, we map the web data back
			// into the methodView object.  
			if (executeMethods) {
				//nucleus.executeMethods(bioMightComponent.getBioMightMethods());
				bioMightComponent.setX3D(peroxisome.getX3D(snippet));
			}
		}
		else if (bioMightComponentRef.equals(Constants.Peroxisomes))
		{
			Peroxisomes peroxisomes = (Peroxisomes) bioMightInstance;
			bioMightComponent.setImage(peroxisomes.getImage());
			bioMightComponent.setBioMightProperties(peroxisomes.getProperties());
			bioMightComponent.setBioMightMethods(peroxisomes.getMethods());
			bioMightComponent.setX3D(peroxisomes.getX3D(snippet));
		
			// Assooiate the component and ID.
			bioMightKey = new BioMightKey();
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(peroxisomes.getComponentID());			
			System.out.println("Storing PeroxisomeKey: " + bioMightComponent + "   ID: " + peroxisomes.getComponentID());
			bioMightKeys.setKey(bioMightKey);

			// On the post of data, we map the web data back
			// into the methodView object.  
			if (executeMethods) {
				//nucleus.executeMethods(bioMightComponent.getBioMightMethods());
				bioMightComponent.setX3D(peroxisomes.getX3D(snippet));
			}
		}
		else if (bioMightComponentRef.equals(Constants.SecretoryVesicle))
		{
			SecretoryVesicle secretoryVesicle = (SecretoryVesicle) bioMightInstance;
			bioMightComponent.setImage(secretoryVesicle.getImage());
		}			
		else if (bioMightComponentRef.equals(Constants.IonPump))
		{
			IonPump ionPump = (IonPump) bioMightInstance;
			bioMightComponent.setImage(ionPump.getImage());
			bioMightComponent.setBioMightProperties(ionPump.getProperties());
			bioMightComponent.setBioMightMethods(ionPump.getMethods());
			bioMightComponent.setX3D(ionPump.getX3D(snippet));
		
			// Assooiate the component and ID.
			bioMightKey = new BioMightKey();
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(ionPump.getComponentID());			
			System.out.println("Storing IonPumpKey: " + bioMightComponent + "   ID: " + ionPump.getComponentID());
			bioMightKeys.setKey(bioMightKey);

			// On the post of data, we map the web data back
			// into the methodView object.  
			if (executeMethods) {
				//nucleus.executeMethods(bioMightComponent.getBioMightMethods());
				bioMightComponent.setX3D(ionPump.getX3D(snippet));
			}
		}
		else if (bioMightComponentRef.equals(Constants.IonPumps))
		{
			IonPumps ionPumps = (IonPumps) bioMightInstance;
			bioMightComponent.setImage(ionPumps.getImage());
			bioMightComponent.setBioMightProperties(ionPumps.getProperties());
			bioMightComponent.setBioMightMethods(ionPumps.getMethods());
			bioMightComponent.setX3D(ionPumps.getX3D(snippet));
		
			// Assooiate the component and ID.
			bioMightKey = new BioMightKey();
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(ionPumps.getComponentID());			
			System.out.println("Storing IonPumpsKey: " + bioMightComponent + "   ID: " + ionPumps.getComponentID());
			bioMightKeys.setKey(bioMightKey);

			// On the post of data, we map the web data back
			// into the methodView object.  
			if (executeMethods) {
				//nucleus.executeMethods(bioMightComponent.getBioMightMethods());
				bioMightComponent.setX3D(ionPumps.getX3D(snippet));
			}
		}
		else if (bioMightComponentRef.equals(Constants.Melanosome))
		{
			Melanosome melanosome = (Melanosome) bioMightInstance;
			bioMightComponent.setImage(melanosome.getImage());
		}
		else if (bioMightComponentRef.equals(Constants.Melanosomes))
		{
			Melanosomes melanosomes = (Melanosomes) bioMightInstance;
			bioMightComponent.setImage(melanosomes.getImage());
		}
		else if (bioMightComponentRef.equals(Constants.IonChannel))
		{
			IonChannel ionChannel = (IonChannel) bioMightInstance;
			bioMightComponent.setImage(ionChannel.getImage());
		}			
		else if (bioMightComponentRef.equals(Constants.IonChannels))
		{
			IonChannels ionChannels = (IonChannels) bioMightInstance;
			bioMightComponent.setImage(ionChannels.getImage());
		}	
		else if (bioMightComponentRef.equals(Constants.Ribosome))
		{
			Ribosome ribosome = (Ribosome) bioMightInstance;
			bioMightComponent.setImage(ribosome.getImage());
			bioMightComponent.setBioMightProperties(ribosome.getProperties());
			bioMightComponent.setBioMightMethods(ribosome.getMethods());
			bioMightComponent.setX3D(ribosome.getX3D(snippet));
		
			// Assooiate the component and ID.
			bioMightKey = new BioMightKey();
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(ribosome.getComponentID());			
			System.out.println("Storing RibosomeKey: " + bioMightComponent + "   ID: " + ribosome.getComponentID());
			bioMightKeys.setKey(bioMightKey);

			// On the post of data, we map the web data back
			// into the methodView object.  
			if (executeMethods) {
				//nucleus.executeMethods(bioMightComponent.getBioMightMethods());
				bioMightComponent.setX3D(ribosome.getX3D(snippet));
			}
		}	
		else if (bioMightComponentRef.equals(Constants.Ribosomes))
		{
			Ribosomes ribosomes = (Ribosomes) bioMightInstance;
			bioMightComponent.setImage(ribosomes.getImage());
			bioMightComponent.setBioMightProperties(ribosomes.getProperties());
			bioMightComponent.setBioMightMethods(ribosomes.getMethods());
			bioMightComponent.setX3D(ribosomes.getX3D(snippet));
		
			// Assooiate the component and ID.
			bioMightKey = new BioMightKey();
			bioMightKey.setComponentName(bioMightComponentName);
			bioMightKey.setComponentID(ribosomes.getComponentID());			
			System.out.println("Storing RibosomeKey: " + bioMightComponent + "   ID: " + ribosomes.getComponentID());
			bioMightKeys.setKey(bioMightKey);

			// On the post of data, we map the web data back
			// into the methodView object.  
			if (executeMethods) {
				//nucleus.executeMethods(bioMightComponent.getBioMightMethods());
				bioMightComponent.setX3D(ribosomes.getX3D(snippet));
			}
		}	
		else
		{
			System.out.println("BioMightView Component NOT MATCHED: " + bioMightComponentRef + " "  + bioMightComponentName);
		}
	
		
		
	return bioMightComponent;
	}
}
