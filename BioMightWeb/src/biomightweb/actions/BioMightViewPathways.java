package biomightweb.actions;

import biomight.BioMightKey;
import biomight.BioMightKeys;
import biomight.Constants;
import biomight.antibodies.Antibodies;
import biomight.antibodies.Antibody;
import biomight.antibodies.AntibodyHeavyChain;
import biomight.chemistry.BioAssemblies;
import biomight.chemistry.aminoacid.Alanine;
import biomight.chemistry.aminoacid.AminoAcid;
import biomight.chemistry.aminoacid.AminoAcids;
import biomight.chemistry.aminoacid.Arginine;
import biomight.chemistry.aminoacid.Asparagine;
import biomight.chemistry.aminoacid.AsparticAcid;
import biomight.chemistry.aminoacid.Cysteine;
import biomight.chemistry.aminoacid.GlutamicAcid;
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
import biomight.chemistry.aminoacid.Serine;
import biomight.chemistry.aminoacid.Threonine;
import biomight.chemistry.aminoacid.Tryptophan;
import biomight.chemistry.aminoacid.Tyrosine;
import biomight.chemistry.aminoacid.Valine;
import biomight.chemistry.carbohydrate.monosaccharide.pentose.DeOxyRibose;
import biomight.chemistry.carbohydrate.monosaccharide.pentose.Ribose;
import biomight.chemistry.carbohydrate.monosaccharide.pentose.Ribosen;
import biomight.chemistry.compound.Acervuli;
import biomight.chemistry.compound.AmmoniumPhosphate;
import biomight.chemistry.compound.Bicarbonate;
import biomight.chemistry.compound.Bilirubin;
import biomight.chemistry.compound.Biliverdin;
import biomight.chemistry.compound.Calcite;
import biomight.chemistry.compound.CalciumCarbonate;
import biomight.chemistry.compound.CalciumPhosphate;
import biomight.chemistry.compound.DeoxyCholicAcid;
import biomight.chemistry.compound.DiaminobutyricAcid;
import biomight.chemistry.compound.DihydroxyindoleCarboxylicAcid;
import biomight.chemistry.compound.ErgoSterol;
import biomight.chemistry.compound.GlycoCalyx;
import biomight.chemistry.compound.H20;
import biomight.chemistry.compound.Heme;
import biomight.chemistry.compound.Hemoglobin;
import biomight.chemistry.compound.Indolequinone;
import biomight.chemistry.compound.Lysozyme;
import biomight.chemistry.compound.Lysozymes;
import biomight.chemistry.compound.MagnesiumPhosphate;
import biomight.chemistry.compound.Molecule;
import biomight.chemistry.compound.Nephrin;
import biomight.chemistry.compound.PCadherin;
import biomight.chemistry.compound.Pilin;
import biomight.chemistry.compound.Podocalyxin;
import biomight.chemistry.compound.Retinal;
import biomight.chemistry.compound.Salt;
import biomight.chemistry.compound.SodiumGlycoCholate;
import biomight.chemistry.compound.SodiumTauroCholate;
import biomight.chemistry.compound.TauroCholicAcid;
import biomight.chemistry.compound.Thiocyanate;
import biomight.chemistry.compound.TransPeptidase;
import biomight.chemistry.elements.Aluminum;
import biomight.chemistry.elements.Calcium;
import biomight.chemistry.elements.Carbon;
import biomight.chemistry.elements.Cobalt;
import biomight.chemistry.elements.Copper;
import biomight.chemistry.elements.Element;
import biomight.chemistry.elements.Elements;
import biomight.chemistry.elements.Flourine;
import biomight.chemistry.elements.Hydrogen;
import biomight.chemistry.elements.Iodine;
import biomight.chemistry.elements.Iron;
import biomight.chemistry.elements.Magnesium;
import biomight.chemistry.elements.Nickel;
import biomight.chemistry.elements.Nitrogen;
import biomight.chemistry.elements.Oxygen;
import biomight.chemistry.elements.Phosphorus;
import biomight.chemistry.elements.Potassium;
import biomight.chemistry.elements.Selenium;
import biomight.chemistry.elements.Sodium;
import biomight.chemistry.elements.Sulfur;
import biomight.chemistry.elements.Zinc;
import biomight.chemistry.ions.Phosphate;
import biomight.chemistry.molecule.Molecules;
import biomight.chemistry.nucleicacid.DNA;
import biomight.chemistry.nucleicacid.DNAs;
import biomight.chemistry.nucleicacid.nucleotide.Adenine;
import biomight.chemistry.nucleicacid.nucleotide.Cytosine;
import biomight.chemistry.nucleicacid.nucleotide.Guanine;
import biomight.chemistry.nucleicacid.nucleotide.Nucleobase;
import biomight.chemistry.nucleicacid.nucleotide.Nucleotide;
import biomight.chemistry.nucleicacid.nucleotide.Nucleotides;
import biomight.chemistry.nucleicacid.nucleotide.Thymine;
import biomight.chemistry.nucleicacid.nucleotide.Uracil;
import biomight.pathway.Pathways;
import biomightweb.view.BioMightComponent;

/**
 * Maps BioMight Chemistry Component into the associated Java class.
 * 
 * SurferJim
 * 
 */

public class BioMightViewPathways {
	// All objects in the palette should be generated as snippets
	// they will be combines into 1 world scene
	
	
	
	public BioMightViewPathways() {
		
	}
	
	
	public BioMightComponent mapComponent(BioMightComponent bioMightComponent, Object bioMightInstance, boolean snipet) {

		BioMightKeys bioMightKeys = bioMightComponent.getBioMightKeys();
		String bioMightComponentRef = bioMightComponent.getBioMightComponentRef();
		String bioMightComponentName = bioMightComponent.getBioMightComponentName();
		BioMightKey bioMightKey = new BioMightKey();
		boolean executeMethods = false;
		
			
		/**************************************************************************
		*
		* ELEMENTS
		* 
		***************************************************************************/
		
			if (bioMightComponentRef.equals(Constants.Element))
			{
				Element element = (Element) bioMightInstance;
				bioMightComponent.setImage(element.getImage());
			}
			else if (bioMightComponentRef.equals(Constants.Pathways))
			{	
				Pathways pathways = (Pathways) bioMightInstance;
				bioMightComponent.setImage(pathways.getImage());
				bioMightComponent.setBioMightProperties(pathways.getProperties());
				bioMightComponent.setBioMightMethods(pathways.getMethods());
				bioMightComponent.setBioMightCollection(false);
				
				// Assooiate the component and ID.
				bioMightKey = new BioMightKey();
				bioMightKey.setComponentName(bioMightComponentName);
				bioMightKey.setComponentID(pathways.getComponentID());			
				System.out.println("Storing Elements Key: " + bioMightComponentRef+ "   ID: " + pathways.getComponentID());
				bioMightKeys.setKey(bioMightKey);
		
				// On the post of data, we map the web data back
				// into the methodView object.  
				if (executeMethods) {
					//elements.executeMethods(bioMightMethods);
					//bioMightComponent.setX3D(elements.getX3D());
				}
				bioMightComponent.setX3D(pathways.getX3D(snipet));
			}			
			else
			{
				System.out.println("BioMightViewChemistry Component NOT MATCHED: " + bioMightComponentRef + "  " +  bioMightComponentName);
			}
	
		
		return bioMightComponent;
		}
}
