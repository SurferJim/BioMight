package biomightweb.actions;

import biomight.BioMightKey;
import biomight.BioMightKeys;
import biomight.Constants;
import biomight.antibodies.Antibodies;
import biomight.antibodies.Antibody;
import biomight.antibodies.AntibodyHeavyChain;
import biomight.chemistry.BioAssemblies;
import biomight.chemistry.aminoacid.Alanine;
import biomight.chemistry.aminoacid.Alanines;
import biomight.chemistry.aminoacid.AminoAcid;
import biomight.chemistry.aminoacid.AminoAcids;
import biomight.chemistry.aminoacid.Arginine;
import biomight.chemistry.aminoacid.Arginines;
import biomight.chemistry.aminoacid.Asparagine;
import biomight.chemistry.aminoacid.Asparagines;
import biomight.chemistry.aminoacid.AsparticAcid;
import biomight.chemistry.aminoacid.AsparticAcids;
import biomight.chemistry.aminoacid.Cysteine;
import biomight.chemistry.aminoacid.Cysteines;
import biomight.chemistry.aminoacid.GlutamicAcid;
import biomight.chemistry.aminoacid.GlutamicAcids;
import biomight.chemistry.aminoacid.Glutamine;
import biomight.chemistry.aminoacid.Glutamines;
import biomight.chemistry.aminoacid.Glycine;
import biomight.chemistry.aminoacid.Glycines;
import biomight.chemistry.aminoacid.Histidine;
import biomight.chemistry.aminoacid.Histidines;
import biomight.chemistry.aminoacid.IsoLeucine;
import biomight.chemistry.aminoacid.IsoLeucines;
import biomight.chemistry.aminoacid.Leucine;
import biomight.chemistry.aminoacid.Leucines;
import biomight.chemistry.aminoacid.Lysine;
import biomight.chemistry.aminoacid.Lysines;
import biomight.chemistry.aminoacid.Methionine;
import biomight.chemistry.aminoacid.Methionines;
import biomight.chemistry.aminoacid.Phenylalanine;
import biomight.chemistry.aminoacid.Phenylalanines;
import biomight.chemistry.aminoacid.Proline;
import biomight.chemistry.aminoacid.Prolines;
import biomight.chemistry.aminoacid.Serine;
import biomight.chemistry.aminoacid.Serines;
import biomight.chemistry.aminoacid.Threonine;
import biomight.chemistry.aminoacid.Threonines;
import biomight.chemistry.aminoacid.Tryptophan;
import biomight.chemistry.aminoacid.Tryptophans;
import biomight.chemistry.aminoacid.Tyrosine;
import biomight.chemistry.aminoacid.Tyrosines;
import biomight.chemistry.aminoacid.Valine;
import biomight.chemistry.aminoacid.Valines;
import biomight.chemistry.bonds.Peptide;
import biomight.chemistry.carbohydrate.monosaccharide.pentose.DeOxyRibose;
import biomight.chemistry.carbohydrate.monosaccharide.pentose.Ribose;
import biomight.chemistry.carbohydrate.monosaccharide.pentose.Ribosen;
import biomight.chemistry.compound.Acervuli;
import biomight.chemistry.compound.Amine;
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
import biomight.chemistry.elements.Aluminums;
import biomight.chemistry.elements.Boron;
import biomight.chemistry.elements.Borons;
import biomight.chemistry.elements.Calcium;
import biomight.chemistry.elements.Calciums;
import biomight.chemistry.elements.Carbon;
import biomight.chemistry.elements.Carbons;
import biomight.chemistry.elements.Chlorine;
import biomight.chemistry.elements.Chlorines;
import biomight.chemistry.elements.Chromium;
import biomight.chemistry.elements.Chromiums;
import biomight.chemistry.elements.Cobalt;
import biomight.chemistry.elements.Cobalts;
import biomight.chemistry.elements.Copper;
import biomight.chemistry.elements.Coppers;
import biomight.chemistry.elements.Element;
import biomight.chemistry.elements.Elements;
import biomight.chemistry.elements.Flourine;
import biomight.chemistry.elements.Flourines;
import biomight.chemistry.elements.Hydrogen;
import biomight.chemistry.elements.Hydrogens;
import biomight.chemistry.elements.Iodine;
import biomight.chemistry.elements.Iodines;
import biomight.chemistry.elements.Iron;
import biomight.chemistry.elements.Irons;
import biomight.chemistry.elements.Magnesium;
import biomight.chemistry.elements.Magnesiums;
import biomight.chemistry.elements.Manganese;
import biomight.chemistry.elements.Manganeses;
import biomight.chemistry.elements.Molybdenum;
import biomight.chemistry.elements.Molybdenums;
import biomight.chemistry.elements.Nickel;
import biomight.chemistry.elements.Nickels;
import biomight.chemistry.elements.Nitrogen;
import biomight.chemistry.elements.Nitrogens;
import biomight.chemistry.elements.Oxygen;
import biomight.chemistry.elements.Oxygens;
import biomight.chemistry.elements.Phosphorus;
import biomight.chemistry.elements.Phosphoruses;
import biomight.chemistry.elements.Potassium;
import biomight.chemistry.elements.Potassiums;
import biomight.chemistry.elements.Selenium;
import biomight.chemistry.elements.Seleniums;
import biomight.chemistry.elements.Silicon;
import biomight.chemistry.elements.Silicons;
import biomight.chemistry.elements.Sodium;
import biomight.chemistry.elements.Sodiums;
import biomight.chemistry.elements.Sulfur;
import biomight.chemistry.elements.Sulfurs;
import biomight.chemistry.elements.Vanadium;
import biomight.chemistry.elements.Vanadiums;
import biomight.chemistry.elements.Zinc;
import biomight.chemistry.elements.Zincs;
import biomight.chemistry.enzyme.Enzyme;
import biomight.chemistry.enzyme.Enzymes;
import biomight.chemistry.hormones.Hormones;
import biomight.chemistry.hormones.lipid.Lipids;
import biomight.chemistry.hormones.peptide.Peptides;
import biomight.chemistry.hormones.steroid.Steroids;
import biomight.chemistry.ions.Phosphate;
import biomight.chemistry.ions.Phosphates;
import biomight.chemistry.molecule.Molecules;
import biomight.chemistry.nucleicacid.DNA;
import biomight.chemistry.nucleicacid.DNAs;
import biomight.chemistry.nucleicacid.RNA;
import biomight.chemistry.nucleicacid.RNAs;
import biomight.chemistry.nucleicacid.nucleotide.Adenine;
import biomight.chemistry.nucleicacid.nucleotide.Cytosine;
import biomight.chemistry.nucleicacid.nucleotide.Guanine;
import biomight.chemistry.nucleicacid.nucleotide.Nucleobase;
import biomight.chemistry.nucleicacid.nucleotide.Nucleotide;
import biomight.chemistry.nucleicacid.nucleotide.Nucleotides;
import biomight.chemistry.nucleicacid.nucleotide.Thymine;
import biomight.chemistry.nucleicacid.nucleotide.Uracil;
import biomightweb.view.BioMightComponent;

/**
 * Maps BioMight Chemistry Component into the associated Java class.
 * 
 * SurferJim
 * 
 */

public class BioMightViewChemistry {
	// All objects in the palette should be generated as snippets
	// they will be combines into 1 world scene
	
	
	
	public BioMightViewChemistry() {
		
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
		* Map the Basic Elements and Element Goups
		***************************************************************************/
		
			if (bioMightComponentRef.equals(Constants.Element))
			{
				Element element = (Element) bioMightInstance;
				bioMightComponent.setImage(element.getImage());
			}
			else if (bioMightComponentRef.equals(Constants.Elements))
			{	
				Elements elements = (Elements) bioMightInstance;
				bioMightComponent.setImage(elements.getImage());
				bioMightComponent.setBioMightProperties(elements.getProperties());
				bioMightComponent.setBioMightMethods(elements.getMethods());
				bioMightComponent.setBioMightCollection(false);
				
				// Assooiate the component and ID.
				bioMightKey = new BioMightKey();
				bioMightKey.setComponentName(bioMightComponentName);
				bioMightKey.setComponentID(elements.getComponentID());			
				System.out.println("Storing Elements Key: " + bioMightComponentRef+ "   ID: " + elements.getComponentID());
				bioMightKeys.setKey(bioMightKey);
		
				// On the post of data, we map the web data back
				// into the methodView object.  
				if (executeMethods) {
					//elements.executeMethods(bioMightMethods);
					//bioMightComponent.setX3D(elements.getX3D());
				}
				bioMightComponent.setX3D(elements.getX3D(snipet));
			}
			else if (bioMightComponentRef.equals(Constants.Aluminums))
			{
				Aluminums aluminums = (Aluminums) bioMightInstance;
				bioMightComponent.setImage(aluminums.getImage());
				bioMightComponent.setBioMightProperties(aluminums.getProperties());
				bioMightComponent.setBioMightMethods(aluminums.getMethods());
				bioMightComponent.setBioMightCollection(true);
				
				// Assooiate the component and ID.
				bioMightKey = new BioMightKey();
				bioMightKey.setComponentName(bioMightComponentName);
				bioMightKey.setComponentID(aluminums.getComponentID());			
				System.out.println("Storing Aluminums Key: " + bioMightComponentRef+ "   ID: " + aluminums.getComponentID());
				bioMightKeys.setKey(bioMightKey);
		
				// On the post of data, we map the web data back
				// into the methodView object.  
				if (executeMethods) {
					//elements.executeMethods(bioMightMethods);
					//bioMightComponent.setX3D(aluminums.getX3D());
				}
				bioMightComponent.setX3D(aluminums.getX3D(snipet));

			}	
			else if (bioMightComponentRef.equals(Constants.Aluminum))
			{
				Aluminum aluminum = (Aluminum) bioMightInstance;
				bioMightComponent.setImage(aluminum.getImage());
				bioMightComponent.setBioMightProperties(aluminum.getProperties());
				bioMightComponent.setBioMightMethods(aluminum.getMethods());
				bioMightComponent.setBioMightCollection(false);
				
				// Assooiate the component and ID.
				bioMightKey = new BioMightKey();
				bioMightKey.setComponentName(bioMightComponentName);
				bioMightKey.setComponentID(aluminum.getComponentID());			
				System.out.println("Storing Aluminum Key: " + bioMightComponentRef+ "   ID: " + aluminum.getComponentID());
				bioMightKeys.setKey(bioMightKey);
		
				// On the post of data, we map the web data back
				// into the methodView object.  
				if (executeMethods) {
					//elements.executeMethods(bioMightMethods);
					//bioMightComponent.setX3D(aluminum.getX3D());
				}
				bioMightComponent.setX3D(aluminum.getX3D(snipet));

			}
			else if (bioMightComponentRef.equals(Constants.Amine))
			{
				Amine amine = (Amine) bioMightInstance;
				bioMightComponent.setImage(amine.getImage());
				bioMightComponent.setBioMightMethods(amine.getMethods());
				bioMightComponent.setBioMightProperties(amine.getProperties());
				bioMightComponent.setBioMightCollection(true);
				
				// Assooiate the component and ID.
				bioMightKey = new BioMightKey();
				bioMightKey.setComponentName(bioMightComponentName);
				bioMightKey.setComponentID(amine.getComponentID());			
				System.out.println("Storing AmineKey: " + bioMightComponentRef+ "   ID: " + amine.getComponentID());
				bioMightKeys.setKey(bioMightKey);
						
				// On the post of data, we map the web data back
				// into the methodView object.  
				//if (executeMethods) { 
				//	System.out.println("Executing Amine Methods!");
				//	amine.executeMethods(methodParams);
				//}
				
				//System.out.println("Getting X3D for Amine");
				bioMightComponent.setX3D(amine.getX3D(snipet));
				System.out.println("Setup X3D for Amine");			
			}
			
			else if (bioMightComponentRef.equals(Constants.Borons))
			{
				Borons borons = (Borons) bioMightInstance;
				bioMightComponent.setImage(borons.getImage());
				bioMightComponent.setBioMightProperties(borons.getProperties());
				bioMightComponent.setBioMightMethods(borons.getMethods());
				bioMightComponent.setBioMightCollection(true);
				
				// Assooiate the component and ID.
				bioMightKey = new BioMightKey();
				bioMightKey.setComponentName(bioMightComponentName);
				bioMightKey.setComponentID(borons.getComponentID());			
				System.out.println("Storing Borons Key: " + bioMightComponentRef+ "   ID: " + borons.getComponentID());
				bioMightKeys.setKey(bioMightKey);
		
				// On the post of data, we map the web data back
				// into the methodView object.  
				if (executeMethods) {
					//elements.executeMethods(bioMightMethods);
					//bioMightComponent.setX3D(borons.getX3D());
				}
				bioMightComponent.setX3D(borons.getX3D(snipet));

			}
			else if (bioMightComponentRef.equals(Constants.Boron))
			{
				Boron boron = (Boron) bioMightInstance;
				bioMightComponent.setImage(boron.getImage());
				bioMightComponent.setBioMightProperties(boron.getProperties());
				bioMightComponent.setBioMightMethods(boron.getMethods());
				bioMightComponent.setBioMightCollection(false);
				
				// Assooiate the component and ID.
				bioMightKey = new BioMightKey();
				bioMightKey.setComponentName(bioMightComponentName);
				bioMightKey.setComponentID(boron.getComponentID());			
				System.out.println("Storing Boron Key: " + bioMightComponentRef+ "   ID: " + boron.getComponentID());
				bioMightKeys.setKey(bioMightKey);
		
				// On the post of data, we map the web data back
				// into the methodView object.  
				if (executeMethods) {
					//elements.executeMethods(bioMightMethods);
					//bioMightComponent.setX3D(borons.getX3D());
				}
				bioMightComponent.setX3D(boron.getX3D(snipet));
			}
			else if (bioMightComponentRef.equals(Constants.Calciums))
			{
				Calciums calciums = (Calciums) bioMightInstance;
				bioMightComponent.setImage(calciums.getImage());
				bioMightComponent.setBioMightProperties(calciums.getProperties());
				bioMightComponent.setBioMightMethods(calciums.getMethods());
				bioMightComponent.setBioMightCollection(true);
				
				// Assooiate the component and ID.
				bioMightKey = new BioMightKey();
				bioMightKey.setComponentName(bioMightComponentName);
				bioMightKey.setComponentID(calciums.getComponentID());			
				System.out.println("Storing Calciums Key: " + bioMightComponentRef+ "   ID: " + calciums.getComponentID());
				bioMightKeys.setKey(bioMightKey);
		
				// On the post of data, we map the web data back
				// into the methodView object.  
				if (executeMethods) {
					//elements.executeMethods(bioMightMethods);
					//bioMightComponent.setX3D(calciums.getX3D());
				}
				bioMightComponent.setX3D(calciums.getX3D(snipet));
			}	
			else if (bioMightComponentRef.equals(Constants.Calcium))
			{
				Calcium calcium = (Calcium) bioMightInstance;
				bioMightComponent.setImage(calcium.getImage());
				bioMightComponent.setBioMightProperties(calcium.getProperties());
				bioMightComponent.setBioMightMethods(calcium.getMethods());
				bioMightComponent.setBioMightCollection(false);
				
				// Assooiate the component and ID.
				bioMightKey = new BioMightKey();
				bioMightKey.setComponentName(bioMightComponentName);
				bioMightKey.setComponentID(calcium.getComponentID());			
				System.out.println("Storing Calcium Key: " + bioMightComponentRef+ "   ID: " + calcium.getComponentID());
				bioMightKeys.setKey(bioMightKey);
		
				// On the post of data, we map the web data back
				// into the methodView object.  
				if (executeMethods) {
					//elements.executeMethods(bioMightMethods);
					//bioMightComponent.setX3D(calcium.getX3D());
				}
				bioMightComponent.setX3D(calcium.getX3D(snipet));
			}	
			else if (bioMightComponentRef.equals(Constants.Carbons))
			{
				Carbons carbons = (Carbons) bioMightInstance;
				bioMightComponent.setImage(carbons.getImage());
				bioMightComponent.setBioMightMethods(carbons.getMethods());
				bioMightComponent.setBioMightProperties(carbons.getProperties());
				bioMightComponent.setBioMightCollection(true);
				
				// Assooiate the component and ID.
				bioMightKey = new BioMightKey();
				bioMightKey.setComponentName(bioMightComponentName);
				bioMightKey.setComponentID(carbons.getComponentID());			
				System.out.println("Storing CarbonsKey: " + bioMightComponentRef+ "   ID: " + carbons.getComponentID());
				bioMightKeys.setKey(bioMightKey);
						
				// On the post of data, we map the web data back
				// into the methodView object.  
				//if (executeMethods) { 
				//	System.out.println("Executing Carbons Methods!");
				//	carbon.executeMethods(methodParams);
				//}
				
				bioMightComponent.setX3D(carbons.getX3D(snipet));
				System.out.println("Setup X3D for Carbons");
			}			
			else if (bioMightComponentRef.equals(Constants.Carbon))
			{
				Carbon carbon = (Carbon) bioMightInstance;
				bioMightComponent.setImage(carbon.getImage());
				bioMightComponent.setBioMightMethods(carbon.getMethods());
				bioMightComponent.setBioMightProperties(carbon.getProperties());
				bioMightComponent.setBioMightCollection(false);
				
				// Assooiate the component and ID.
				bioMightKey = new BioMightKey();
				bioMightKey.setComponentName(bioMightComponentName);
				bioMightKey.setComponentID(carbon.getComponentID());			
				System.out.println("Storing CarbonKey: " + bioMightComponentRef+ "   ID: " + carbon.getComponentID());
				bioMightKeys.setKey(bioMightKey);
						
				// On the post of data, we map the web data back
				// into the methodView object.  
				//if (executeMethods) { 
				//	System.out.println("Executing Carbon Methods!");
				//	carbon.executeMethods(methodParams);
				//}
				
				bioMightComponent.setX3D(carbon.getX3D(snipet));
				System.out.println("Setup X3D for Carbon");
			}				
			else if (bioMightComponentRef.equals(Constants.Chlorines))
			{
				Chlorines chlorines = (Chlorines) bioMightInstance;
				bioMightComponent.setImage(chlorines.getImage());
				bioMightComponent.setBioMightMethods(chlorines.getMethods());
				bioMightComponent.setBioMightProperties(chlorines.getProperties());
				bioMightComponent.setBioMightCollection(true);
				
				// Assooiate the component and ID.
				bioMightKey = new BioMightKey();
				bioMightKey.setComponentName(bioMightComponentName);
				bioMightKey.setComponentID(chlorines.getComponentID());			
				System.out.println("Storing ChlorinesKey: " + bioMightComponentRef+ "   ID: " + chlorines.getComponentID());
				bioMightKeys.setKey(bioMightKey);
						
				// On the post of data, we map the web data back
				// into the methodView object.  
				//if (executeMethods) { 
				//	System.out.println("Executing Chlorines Methods!");
				//	chlorine.executeMethods(methodParams);
				//}
				
				bioMightComponent.setX3D(chlorines.getX3D(snipet));
				System.out.println("Setup X3D for Chlorines");
			}			
			else if (bioMightComponentRef.equals(Constants.Chlorine))
			{
				Chlorine chlorine = (Chlorine) bioMightInstance;
				bioMightComponent.setImage(chlorine.getImage());
				bioMightComponent.setBioMightMethods(chlorine.getMethods());
				bioMightComponent.setBioMightProperties(chlorine.getProperties());
				bioMightComponent.setBioMightCollection(false);
				
				// Assooiate the component and ID.
				bioMightKey = new BioMightKey();
				bioMightKey.setComponentName(bioMightComponentName);
				bioMightKey.setComponentID(chlorine.getComponentID());			
				System.out.println("Storing ChlorineKey: " + bioMightComponentRef+ "   ID: " + chlorine.getComponentID());
				bioMightKeys.setKey(bioMightKey);
						
				// On the post of data, we map the web data back
				// into the methodView object.  
				//if (executeMethods) { 
				//	System.out.println("Executing Chlorine Methods!");
				//	chlorine.executeMethods(methodParams);
				//}
				
				bioMightComponent.setX3D(chlorine.getX3D(snipet));
				System.out.println("Setup X3D for Chlorine");
			}	
			else if (bioMightComponentRef.equals(Constants.Cobalts))
			{
				Cobalts cobalts = (Cobalts) bioMightInstance;
				bioMightComponent.setImage(cobalts.getImage());
				bioMightComponent.setBioMightMethods(cobalts.getMethods());
				bioMightComponent.setBioMightProperties(cobalts.getProperties());
				bioMightComponent.setBioMightCollection(true);
				
				// Assooiate the component and ID.
				bioMightKey = new BioMightKey();
				bioMightKey.setComponentName(bioMightComponentName);
				bioMightKey.setComponentID(cobalts.getComponentID());			
				System.out.println("Storing CobaltsKey: " + bioMightComponentRef+ "   ID: " + cobalts.getComponentID());
				bioMightKeys.setKey(bioMightKey);
						
				// On the post of data, we map the web data back
				// into the methodView object.  
				//if (executeMethods) { 
				//	System.out.println("Executing Cobalts Methods!");
				//	cobalts.executeMethods(methodParams);
				//}
				
				bioMightComponent.setX3D(cobalts.getX3D(snipet));
				System.out.println("Setup X3D for Cobalts");
			}
			else if (bioMightComponentRef.equals(Constants.Cobalt))
			{
				Cobalt cobalt = (Cobalt) bioMightInstance;
				bioMightComponent.setImage(cobalt.getImage());
				bioMightComponent.setBioMightMethods(cobalt.getMethods());
				bioMightComponent.setBioMightProperties(cobalt.getProperties());
				bioMightComponent.setBioMightCollection(false);
				
				// Assooiate the component and ID.
				bioMightKey = new BioMightKey();
				bioMightKey.setComponentName(bioMightComponentName);
				bioMightKey.setComponentID(cobalt.getComponentID());			
				System.out.println("Storing CobaltKey: " + bioMightComponentRef+ "   ID: " + cobalt.getComponentID());
				bioMightKeys.setKey(bioMightKey);
						
				// On the post of data, we map the web data back
				// into the methodView object.  
				//if (executeMethods) { 
				//	System.out.println("Executing Cobalt Methods!");
				//	cobalt.executeMethods(methodParams);
				//}
				
				bioMightComponent.setX3D(cobalt.getX3D(snipet));
				System.out.println("Setup X3D for Cobalt");
			}
			else if (bioMightComponentRef.equals(Constants.Coppers))
			{
				Coppers coppers = (Coppers) bioMightInstance;
				bioMightComponent.setImage(coppers.getImage());
				bioMightComponent.setBioMightMethods(coppers.getMethods());
				bioMightComponent.setBioMightProperties(coppers.getProperties());
				bioMightComponent.setBioMightCollection(true);
				
				// Assooiate the component and ID.
				bioMightKey = new BioMightKey();
				bioMightKey.setComponentName(bioMightComponentName);
				bioMightKey.setComponentID(coppers.getComponentID());			
				System.out.println("Storing CopperKey: " + bioMightComponentRef+ "   ID: " + coppers.getComponentID());
				bioMightKeys.setKey(bioMightKey);
						
				// On the post of data, we map the web data back
				// into the methodView object.  
				//if (executeMethods) { 
				//	System.out.println("Executing Copper Methods!");
				//	carbon.executeMethods(methodParams);
				//}
				
				bioMightComponent.setX3D(coppers.getX3D(snipet));
				System.out.println("Setup X3D for Coppers");
			}	
			else if (bioMightComponentRef.equals(Constants.Copper))
			{
				Copper copper = (Copper) bioMightInstance;
				bioMightComponent.setImage(copper.getImage());
				bioMightComponent.setBioMightMethods(copper.getMethods());
				bioMightComponent.setBioMightProperties(copper.getProperties());
				bioMightComponent.setBioMightCollection(false);
				
				// Assooiate the component and ID.
				bioMightKey = new BioMightKey();
				bioMightKey.setComponentName(bioMightComponentName);
				bioMightKey.setComponentID(copper.getComponentID());			
				System.out.println("Storing CopperKey: " + bioMightComponentRef+ "   ID: " + copper.getComponentID());
				bioMightKeys.setKey(bioMightKey);
						
				// On the post of data, we map the web data back
				// into the methodView object.  
				//if (executeMethods) { 
				//	System.out.println("Executing Copper Methods!");
				//	carbon.executeMethods(methodParams);
				//}
				
				bioMightComponent.setX3D(copper.getX3D(snipet));
				System.out.println("Setup X3D for Copper");
			}
			else if (bioMightComponentRef.equals(Constants.Chromiums))
			{
				Chromiums chromiums = (Chromiums) bioMightInstance;
				bioMightComponent.setImage(chromiums.getImage());
				bioMightComponent.setBioMightMethods(chromiums.getMethods());
				bioMightComponent.setBioMightProperties(chromiums.getProperties());
				bioMightComponent.setBioMightCollection(true);
				
				// Assooiate the component and ID.
				bioMightKey = new BioMightKey();
				bioMightKey.setComponentName(bioMightComponentName);
				bioMightKey.setComponentID(chromiums.getComponentID());			
				System.out.println("Storing ChromiumKey: " + bioMightComponentRef+ "   ID: " + chromiums.getComponentID());
				bioMightKeys.setKey(bioMightKey);
						
				// On the post of data, we map the web data back
				// into the methodView object.  
				//if (executeMethods) { 
				//	System.out.println("Executing Chromium Methods!");
				//	carbon.executeMethods(methodParams);
				//}
				
				bioMightComponent.setX3D(chromiums.getX3D(snipet));
				System.out.println("Setup X3D for Chromiums");
			}	
			else if (bioMightComponentRef.equals(Constants.Chromium))
			{
				Chromium chromium = (Chromium) bioMightInstance;
				bioMightComponent.setImage(chromium.getImage());
				bioMightComponent.setBioMightMethods(chromium.getMethods());
				bioMightComponent.setBioMightProperties(chromium.getProperties());
				bioMightComponent.setBioMightCollection(false);
				
				// Assooiate the component and ID.
				bioMightKey = new BioMightKey();
				bioMightKey.setComponentName(bioMightComponentName);
				bioMightKey.setComponentID(chromium.getComponentID());			
				System.out.println("Storing ChromiumKey: " + bioMightComponentRef+ "   ID: " + chromium.getComponentID());
				bioMightKeys.setKey(bioMightKey);
						
				// On the post of data, we map the web data back
				// into the methodView object.  
				//if (executeMethods) { 
				//	System.out.println("Executing Chromium Methods!");
				//	carbon.executeMethods(methodParams);
				//}
				
				bioMightComponent.setX3D(chromium.getX3D(snipet));
				System.out.println("Setup X3D for Chromium");
			}
			else if (bioMightComponentRef.equals(Constants.Flourines))
			{
				Flourines flourines = (Flourines) bioMightInstance;
				bioMightComponent.setImage(flourines.getImage());
				bioMightComponent.setBioMightMethods(flourines.getMethods());
				bioMightComponent.setBioMightProperties(flourines.getProperties());
				bioMightComponent.setBioMightCollection(true);
				
				// Assooiate the component and ID.
				bioMightKey = new BioMightKey();
				bioMightKey.setComponentName(bioMightComponentName);
				bioMightKey.setComponentID(flourines.getComponentID());			
				System.out.println("Storing FlourinesKey: " + bioMightComponentRef+ "   ID: " + flourines.getComponentID());
				bioMightKeys.setKey(bioMightKey);
						
				// On the post of data, we map the web data back
				// into the methodView object.  
				//if (executeMethods) { 
				//	System.out.println("Executing Flourine Methods!");
				//	flourines.executeMethods(methodParams);
				//}
				
				bioMightComponent.setX3D(flourines.getX3D(snipet));
				System.out.println("Setup X3D for Flourines");
			}
			else if (bioMightComponentRef.equals(Constants.Flourine))
			{
				Flourine flourine = (Flourine) bioMightInstance;
				bioMightComponent.setImage(flourine.getImage());
				bioMightComponent.setBioMightMethods(flourine.getMethods());
				bioMightComponent.setBioMightProperties(flourine.getProperties());
				bioMightComponent.setBioMightCollection(false);
				
				// Assooiate the component and ID.
				bioMightKey = new BioMightKey();
				bioMightKey.setComponentName(bioMightComponentName);
				bioMightKey.setComponentID(flourine.getComponentID());			
				System.out.println("Storing FlourineKey: " + bioMightComponentRef+ "   ID: " + flourine.getComponentID());
				bioMightKeys.setKey(bioMightKey);
						
				// On the post of data, we map the web data back
				// into the methodView object.  
				//if (executeMethods) { 
				//	System.out.println("Executing Flourine Methods!");
				//	flourine.executeMethods(methodParams);
				//}
				
				bioMightComponent.setX3D(flourine.getX3D(snipet));
				System.out.println("Setup X3D for Flourine");
			}
			else if (bioMightComponentRef.equals(Constants.Hydrogens))
			{
				Hydrogens hydrogens = (Hydrogens) bioMightInstance;
				bioMightComponent.setImage(hydrogens.getImage());
				bioMightComponent.setBioMightMethods(hydrogens.getMethods());
				bioMightComponent.setBioMightProperties(hydrogens.getProperties());
				bioMightComponent.setBioMightCollection(true);
				
				// Assooiate the component and ID.
				bioMightKey = new BioMightKey();
				bioMightKey.setComponentName(bioMightComponentName);
				bioMightKey.setComponentID(hydrogens.getComponentID());			
				System.out.println("Storing HydrogensKey: " + bioMightComponentRef+ "   ID: " + hydrogens.getComponentID());
				bioMightKeys.setKey(bioMightKey);
						
				// On the post of data, we map the web data back
				// into the methodView object.  
				//if (executeMethods) { 
				//	System.out.println("Executing Hydrogens Methods!");
				//	hydrogens.executeMethods(methodParams);
				//}
				
				bioMightComponent.setX3D(hydrogens.getX3D(snipet));
				System.out.println("Setup X3D for Hydrogens");
			}
			else if (bioMightComponentRef.equals(Constants.Hydrogen))
			{
				Hydrogen hydrogen = (Hydrogen) bioMightInstance;
				bioMightComponent.setImage(hydrogen.getImage());
				bioMightComponent.setBioMightMethods(hydrogen.getMethods());
				bioMightComponent.setBioMightProperties(hydrogen.getProperties());
				bioMightComponent.setBioMightCollection(false);
				
				// Assooiate the component and ID.
				bioMightKey = new BioMightKey();
				bioMightKey.setComponentName(bioMightComponentName);
				bioMightKey.setComponentID(hydrogen.getComponentID());			
				System.out.println("Storing HydrogenKey: " + bioMightComponentRef+ "   ID: " + hydrogen.getComponentID());
				bioMightKeys.setKey(bioMightKey);
						
				// On the post of data, we map the web data back
				// into the methodView object.  
				//if (executeMethods) { 
				//	System.out.println("Executing Hydrogen Methods!");
				//	hydrogen.executeMethods(methodParams);
				//}
				
				bioMightComponent.setX3D(hydrogen.getX3D(snipet));
				System.out.println("Setup X3D for Hydrogen");
			}
			else if (bioMightComponentRef.equals(Constants.Iodines))
			{
				Iodines iodines = (Iodines) bioMightInstance;
				bioMightComponent.setImage(iodines.getImage());
				bioMightComponent.setBioMightMethods(iodines.getMethods());
				bioMightComponent.setBioMightProperties(iodines.getProperties());
				bioMightComponent.setBioMightCollection(true);
				
				// Assooiate the component and ID.
				bioMightKey = new BioMightKey();
				bioMightKey.setComponentName(bioMightComponentName);
				bioMightKey.setComponentID(iodines.getComponentID());			
				System.out.println("Storing IodinesKey: " + bioMightComponentRef+ "   ID: " + iodines.getComponentID());
				bioMightKeys.setKey(bioMightKey);
						
				// On the post of data, we map the web data back
				// into the methodView object.  
				//if (executeMethods) { 
				//	System.out.println("Executing IodinesKey Methods!");
				//	hydrogen.executeMethods(methodParams);
				//}
				
				bioMightComponent.setX3D(iodines.getX3D(snipet));
				System.out.println("Setup X3D for IodinesKey");
			}
			else if (bioMightComponentRef.equals(Constants.Iodine))
			{
				Iodine iodine = (Iodine) bioMightInstance;
				bioMightComponent.setImage(iodine.getImage());
				bioMightComponent.setBioMightMethods(iodine.getMethods());
				bioMightComponent.setBioMightProperties(iodine.getProperties());
				bioMightComponent.setBioMightCollection(false);
				
				// Assooiate the component and ID.
				bioMightKey = new BioMightKey();
				bioMightKey.setComponentName(bioMightComponentName);
				bioMightKey.setComponentID(iodine.getComponentID());			
				System.out.println("Storing IodineKey: " + bioMightComponentRef+ "   ID: " + iodine.getComponentID());
				bioMightKeys.setKey(bioMightKey);
						
				// On the post of data, we map the web data back
				// into the methodView object.  
				//if (executeMethods) { 
				//	System.out.println("Executing IodineKey Methods!");
				//	hydrogen.executeMethods(methodParams);
				//}
				
				bioMightComponent.setX3D(iodine.getX3D(snipet));
				System.out.println("Setup X3D for IodineKey");
			}
			else if (bioMightComponentRef.equals(Constants.Irons))
			{
				Irons irons = (Irons) bioMightInstance;
				bioMightComponent.setImage(irons.getImage());
				bioMightComponent.setBioMightMethods(irons.getMethods());
				bioMightComponent.setBioMightProperties(irons.getProperties());
				bioMightComponent.setBioMightCollection(true);
				
				// Assooiate the component and ID.
				bioMightKey = new BioMightKey();
				bioMightKey.setComponentName(bioMightComponentName);
				bioMightKey.setComponentID(irons.getComponentID());			
				System.out.println("Storing IronsKey: " + bioMightComponentRef+ "   ID: " + irons.getComponentID());
				bioMightKeys.setKey(bioMightKey);
						
				// On the post of data, we map the web data back
				// into the methodView object.  
				//if (executeMethods) { 
				//	System.out.println("Executing IronsKey Methods!");
				//	iron.executeMethods(methodParams);
				//}
				
				bioMightComponent.setX3D(irons.getX3D(snipet));
				System.out.println("Setup X3D for Irons");
			}	
			else if (bioMightComponentRef.equals(Constants.Iron))
			{
				Iron iron = (Iron) bioMightInstance;
				bioMightComponent.setImage(iron.getImage());
				bioMightComponent.setBioMightMethods(iron.getMethods());
				bioMightComponent.setBioMightProperties(iron.getProperties());
				bioMightComponent.setBioMightCollection(false);
				
				// Assooiate the component and ID.
				bioMightKey = new BioMightKey();
				bioMightKey.setComponentName(bioMightComponentName);
				bioMightKey.setComponentID(iron.getComponentID());			
				System.out.println("Storing IronKey: " + bioMightComponentRef+ "   ID: " + iron.getComponentID());
				bioMightKeys.setKey(bioMightKey);
						
				// On the post of data, we map the web data back
				// into the methodView object.  
				//if (executeMethods) { 
				//	System.out.println("Executing IronKey Methods!");
				//	iron.executeMethods(methodParams);
				//}
				
				bioMightComponent.setX3D(iron.getX3D(snipet));
				System.out.println("Setup X3D for Iron");
			}	
			else if (bioMightComponentRef.equals(Constants.Magnesiums))
			{
				Magnesiums magnesiums = (Magnesiums) bioMightInstance;
				bioMightComponent.setImage(magnesiums.getImage());
				bioMightComponent.setBioMightMethods(magnesiums.getMethods());
				bioMightComponent.setBioMightProperties(magnesiums.getProperties());
				bioMightComponent.setBioMightCollection(true);
				
				// Assooiate the component and ID.
				bioMightKey = new BioMightKey();
				bioMightKey.setComponentName(bioMightComponentName);
				bioMightKey.setComponentID(magnesiums.getComponentID());			
				System.out.println("Storing MagnesiumsKey: " + bioMightComponentRef+ "   ID: " + magnesiums.getComponentID());
				bioMightKeys.setKey(bioMightKey);
						
				// On the post of data, we map the web data back
				// into the methodView object.  
				//if (executeMethods) { 
				//	System.out.println("Executing MagnesiumsKey Methods!");
				//	magnesiums.executeMethods(methodParams);
				//}
				
				bioMightComponent.setX3D(magnesiums.getX3D(snipet));
				System.out.println("Setup X3D for Magnesiums");
			}	
			else if (bioMightComponentRef.equals(Constants.Magnesium))
			{
				Magnesium magnesium = (Magnesium) bioMightInstance;
				bioMightComponent.setImage(magnesium.getImage());
				bioMightComponent.setBioMightMethods(magnesium.getMethods());
				bioMightComponent.setBioMightProperties(magnesium.getProperties());
				bioMightComponent.setBioMightCollection(false);
				
				// Assooiate the component and ID.
				bioMightKey = new BioMightKey();
				bioMightKey.setComponentName(bioMightComponentName);
				bioMightKey.setComponentID(magnesium.getComponentID());			
				System.out.println("Storing MagnesiumKey: " + bioMightComponentRef+ "   ID: " + magnesium.getComponentID());
				bioMightKeys.setKey(bioMightKey);
						
				// On the post of data, we map the web data back
				// into the methodView object.  
				//if (executeMethods) { 
				//	System.out.println("Executing MagnesiumKey Methods!");
				//	magnesium.executeMethods(methodParams);
				//}
				
				bioMightComponent.setX3D(magnesium.getX3D(snipet));
				System.out.println("Setup X3D for Magnesium");
			}	
			else if (bioMightComponentRef.equals(Constants.Manganeses))
			{
				Manganeses manganeses = (Manganeses) bioMightInstance;
				bioMightComponent.setImage(manganeses.getImage());
				bioMightComponent.setBioMightMethods(manganeses.getMethods());
				bioMightComponent.setBioMightProperties(manganeses.getProperties());
				bioMightComponent.setBioMightCollection(true);
				
				// Assooiate the component and ID.
				bioMightKey = new BioMightKey();
				bioMightKey.setComponentName(bioMightComponentName);
				bioMightKey.setComponentID(manganeses.getComponentID());			
				System.out.println("Storing ManganesesKey: " + bioMightComponentRef+ "   ID: " + manganeses.getComponentID());
				bioMightKeys.setKey(bioMightKey);
						
				// On the post of data, we map the web data back
				// into the methodView object.  
				//if (executeMethods) { 
				//	System.out.println("Executing ManganesesKey Methods!");
				//	manganeses.executeMethods(methodParams);
				//}
				
				bioMightComponent.setX3D(manganeses.getX3D(snipet));
				System.out.println("Setup X3D for Manganeses");
			}	
			else if (bioMightComponentRef.equals(Constants.Manganese))
			{
				Manganese manganese = (Manganese) bioMightInstance;
				bioMightComponent.setImage(manganese.getImage());
				bioMightComponent.setBioMightMethods(manganese.getMethods());
				bioMightComponent.setBioMightProperties(manganese.getProperties());
				bioMightComponent.setBioMightCollection(false);
				
				// Assooiate the component and ID.
				bioMightKey = new BioMightKey();
				bioMightKey.setComponentName(bioMightComponentName);
				bioMightKey.setComponentID(manganese.getComponentID());			
				System.out.println("Storing ManganeseKey: " + bioMightComponentRef+ "   ID: " + manganese.getComponentID());
				bioMightKeys.setKey(bioMightKey);
						
				// On the post of data, we map the web data back
				// into the methodView object.  
				//if (executeMethods) { 
				//	System.out.println("Executing ManganeseKey Methods!");
				//	manganese.executeMethods(methodParams);
				//}
				
				bioMightComponent.setX3D(manganese.getX3D(snipet));
				System.out.println("Setup X3D for Manganese");
			}	
	
			
			else if (bioMightComponentRef.equals(Constants.Molybdenums))
			{
				Molybdenums molybdenums = (Molybdenums) bioMightInstance;
				bioMightComponent.setImage(molybdenums.getImage());
				bioMightComponent.setBioMightMethods(molybdenums.getMethods());
				bioMightComponent.setBioMightProperties(molybdenums.getProperties());
				bioMightComponent.setBioMightCollection(true);
				
				// Assooiate the component and ID.
				bioMightKey = new BioMightKey();
				bioMightKey.setComponentName(bioMightComponentName);
				bioMightKey.setComponentID(molybdenums.getComponentID());			
				System.out.println("Storing MolybdenumsKey: " + bioMightComponentRef+ "   ID: " + molybdenums.getComponentID());
				bioMightKeys.setKey(bioMightKey);
						
				// On the post of data, we map the web data back
				// into the methodView object.  
				//if (executeMethods) { 
				//	System.out.println("Executing MolybdenumsKey Methods!");
				//	molybdenums.executeMethods(methodParams);
				//}
				
				bioMightComponent.setX3D(molybdenums.getX3D(snipet));
				System.out.println("Setup X3D for Molybdenums");
			}
			else if (bioMightComponentRef.equals(Constants.Molybdenum))
			{
				Molybdenum molybdenum = (Molybdenum) bioMightInstance;
				bioMightComponent.setImage(molybdenum.getImage());
				bioMightComponent.setBioMightMethods(molybdenum.getMethods());
				bioMightComponent.setBioMightProperties(molybdenum.getProperties());
				bioMightComponent.setBioMightCollection(false);
				
				// Assooiate the component and ID.
				bioMightKey = new BioMightKey();
				bioMightKey.setComponentName(bioMightComponentName);
				bioMightKey.setComponentID(molybdenum.getComponentID());			
				System.out.println("Storing MolybdenumKey: " + bioMightComponentRef+ "   ID: " + molybdenum.getComponentID());
				bioMightKeys.setKey(bioMightKey);
						
				// On the post of data, we map the web data back
				// into the methodView object.  
				//if (executeMethods) { 
				//	System.out.println("Executing MolybdenumKey Methods!");
				//	molybdenum.executeMethods(methodParams);
				//}
				
				bioMightComponent.setX3D(molybdenum.getX3D(snipet));
				System.out.println("Setup X3D for Molybdenum");
			}
			else if (bioMightComponentRef.equals(Constants.Nickels))
			{
				Nickels nickels = (Nickels) bioMightInstance;
				bioMightComponent.setImage(nickels.getImage());
				bioMightComponent.setBioMightMethods(nickels.getMethods());
				bioMightComponent.setBioMightProperties(nickels.getProperties());
				bioMightComponent.setBioMightCollection(true);
				
				// Assooiate the component and ID.
				bioMightKey = new BioMightKey();
				bioMightKey.setComponentName(bioMightComponentName);
				bioMightKey.setComponentID(nickels.getComponentID());			
				System.out.println("Storing NickelsKey: " + bioMightComponentRef+ "   ID: " + nickels.getComponentID());
				bioMightKeys.setKey(bioMightKey);
						
				// On the post of data, we map the web data back
				// into the methodView object.  
				//if (executeMethods) { 
				//	System.out.println("Executing NickelsKey Methods!");
				//	nickels.executeMethods(methodParams);
				//}
				
				bioMightComponent.setX3D(nickels.getX3D(snipet));
				System.out.println("Setup X3D for Nickels");		
			}	
			else if (bioMightComponentRef.equals(Constants.Nickel))
			{
				Nickel nickel = (Nickel) bioMightInstance;
				bioMightComponent.setImage(nickel.getImage());
				bioMightComponent.setBioMightMethods(nickel.getMethods());
				bioMightComponent.setBioMightProperties(nickel.getProperties());
				bioMightComponent.setBioMightCollection(false);
				
				// Assooiate the component and ID.
				bioMightKey = new BioMightKey();
				bioMightKey.setComponentName(bioMightComponentName);
				bioMightKey.setComponentID(nickel.getComponentID());			
				System.out.println("Storing NickelKey: " + bioMightComponentRef+ "   ID: " + nickel.getComponentID());
				bioMightKeys.setKey(bioMightKey);
						
				// On the post of data, we map the web data back
				// into the methodView object.  
				//if (executeMethods) { 
				//	System.out.println("Executing NickelKey Methods!");
				//	nickel.executeMethods(methodParams);
				//}
				
				bioMightComponent.setX3D(nickel.getX3D(snipet));
				System.out.println("Setup X3D for Nickel");		
			}
			else if (bioMightComponentRef.equals(Constants.Nitrogens))
			{
				Nitrogens nitrogens = (Nitrogens) bioMightInstance;
				bioMightComponent.setImage(nitrogens.getImage());
				bioMightComponent.setBioMightMethods(nitrogens.getMethods());
				bioMightComponent.setBioMightProperties(nitrogens.getProperties());
				bioMightComponent.setBioMightCollection(true);
				
				// Assooiate the component and ID.
				bioMightKey = new BioMightKey();
				bioMightKey.setComponentName(bioMightComponentName);
				bioMightKey.setComponentID(nitrogens.getComponentID());			
				System.out.println("Storing NitrogenKey: " + bioMightComponentRef+ "   ID: " + nitrogens.getComponentID());
				bioMightKeys.setKey(bioMightKey);
						
				// On the post of data, we map the web data back
				// into the methodView object.  
				//if (executeMethods) { 
				//	System.out.println("Executing NitrogenKey Methods!");
				//	nitrogen.executeMethods(methodParams);
				//}
				
				bioMightComponent.setX3D(nitrogens.getX3D(snipet));
				System.out.println("Setup X3D for Nitrogen");
			}
			else if (bioMightComponentRef.equals(Constants.Nitrogen))
			{
				Nitrogen nitrogen = (Nitrogen) bioMightInstance;
				bioMightComponent.setImage(nitrogen.getImage());
				bioMightComponent.setBioMightMethods(nitrogen.getMethods());
				bioMightComponent.setBioMightProperties(nitrogen.getProperties());
				bioMightComponent.setBioMightCollection(false);
				
				// Assooiate the component and ID.
				bioMightKey = new BioMightKey();
				bioMightKey.setComponentName(bioMightComponentName);
				bioMightKey.setComponentID(nitrogen.getComponentID());			
				System.out.println("Storing NitrogenKey: " + bioMightComponentRef+ "   ID: " + nitrogen.getComponentID());
				bioMightKeys.setKey(bioMightKey);
						
				// On the post of data, we map the web data back
				// into the methodView object.  
				//if (executeMethods) { 
				//	System.out.println("Executing NitrogenKey Methods!");
				//	nitrogen.executeMethods(methodParams);
				//}
				
				bioMightComponent.setX3D(nitrogen.getX3D(snipet));
				System.out.println("Setup X3D for Nitrogen");
			}
			else if (bioMightComponentRef.equals(Constants.Oxygens))
			{
				Oxygens oxygens = (Oxygens) bioMightInstance;
				bioMightComponent.setImage(oxygens.getImage());
				bioMightComponent.setBioMightMethods(oxygens.getMethods());
				bioMightComponent.setBioMightProperties(oxygens.getProperties());
				bioMightComponent.setBioMightCollection(true);
				
				// Assooiate the component and ID.
				bioMightKey = new BioMightKey();
				bioMightKey.setComponentName(bioMightComponentName);
				bioMightKey.setComponentID(oxygens.getComponentID());			
				System.out.println("Storing OxygensKey: " + bioMightComponentRef+ "   ID: " + oxygens.getComponentID());
				bioMightKeys.setKey(bioMightKey);
						
				// On the post of data, we map the web data back
				// into the methodView object.  
				//if (executeMethods) { 
				//	System.out.println("Executing Oxygens Methods!");
				//	oxygen.executeMethods(methodParams);
				//}
				
				bioMightComponent.setX3D(oxygens.getX3D(snipet));
				System.out.println("Setup X3D for Oxygens");
			}
			else if (bioMightComponentRef.equals(Constants.Oxygen))
			{
				Oxygen oxygen = (Oxygen) bioMightInstance;
				bioMightComponent.setImage(oxygen.getImage());
				bioMightComponent.setBioMightMethods(oxygen.getMethods());
				bioMightComponent.setBioMightProperties(oxygen.getProperties());
				bioMightComponent.setBioMightCollection(false);
				
				// Assooiate the component and ID.
				bioMightKey = new BioMightKey();
				bioMightKey.setComponentName(bioMightComponentName);
				bioMightKey.setComponentID(oxygen.getComponentID());			
				System.out.println("Storing OxygenKey: " + bioMightComponentRef+ "   ID: " + oxygen.getComponentID());
				bioMightKeys.setKey(bioMightKey);
						
				// On the post of data, we map the web data back
				// into the methodView object.  
				//if (executeMethods) { 
				//	System.out.println("Executing Oxygen Methods!");
				//	oxygen.executeMethods(methodParams);
				//}
				
				bioMightComponent.setX3D(oxygen.getX3D(snipet));
				System.out.println("Setup X3D for Oxygen");
			}	
			else if (bioMightComponentRef.equals(Constants.Phosphate))
			{
				Phosphate phosphate = (Phosphate) bioMightInstance;
				bioMightComponent.setImage(phosphate.getImage());
				bioMightComponent.setBioMightMethods(phosphate.getMethods());
				bioMightComponent.setBioMightProperties(phosphate.getProperties());
				bioMightComponent.setBioMightCollection(false);
				
				// Assooiate the component and ID.
				bioMightKey = new BioMightKey();
				bioMightKey.setComponentName(bioMightComponentName);
				bioMightKey.setComponentID(phosphate.getComponentID());			
				System.out.println("Storing PhosphateKey: " + bioMightComponentRef+ "   ID: " + phosphate.getComponentID());
				bioMightKeys.setKey(bioMightKey);
						
				// On the post of data, we map the web data back
				// into the methodView object.  
				//if (executeMethods) { 
				//	System.out.println("Executing Phosphate Methods!");
				//	phosphate.executeMethods(methodParams);
				//}
				
				//System.out.println("Getting X3D for Phosphate");
				bioMightComponent.setX3D(phosphate.getX3D(snipet));
				System.out.println("Setup X3D for Phosphate");			
			}			
			else if (bioMightComponentRef.equals(Constants.Phosphoruses))
			{
				Phosphoruses phosphoruses = (Phosphoruses) bioMightInstance;
				bioMightComponent.setImage(phosphoruses.getImage());
				bioMightComponent.setBioMightMethods(phosphoruses.getMethods());
				bioMightComponent.setBioMightProperties(phosphoruses.getProperties());
				bioMightComponent.setBioMightCollection(true);
				
				// Assooiate the component and ID.
				bioMightKey = new BioMightKey();
				bioMightKey.setComponentName(bioMightComponentName);
				bioMightKey.setComponentID(phosphoruses.getComponentID());			
				System.out.println("Storing PhosphorusesKey: " + bioMightComponentRef+ "   ID: " + phosphoruses.getComponentID());
				bioMightKeys.setKey(bioMightKey);
						
				// On the post of data, we map the web data back
				// into the methodView object.  
				//if (executeMethods) { 
				//	System.out.println("Executing Phosphorus Methods!");
				//	phosphoruses.executeMethods(methodParams);
				//}
				
				//System.out.println("Getting X3D for Phosphoruses");
				bioMightComponent.setX3D(phosphoruses.getX3D(snipet));
				System.out.println("Setup X3D for Phosphoruses");			
			}
			else if (bioMightComponentRef.equals(Constants.Phosphorus))
			{
				Phosphorus phosphorus = (Phosphorus) bioMightInstance;
				bioMightComponent.setImage(phosphorus.getImage());
				bioMightComponent.setBioMightMethods(phosphorus.getMethods());
				bioMightComponent.setBioMightProperties(phosphorus.getProperties());
				bioMightComponent.setBioMightCollection(true);
				
				// Assooiate the component and ID.
				bioMightKey = new BioMightKey();
				bioMightKey.setComponentName(bioMightComponentName);
				bioMightKey.setComponentID(phosphorus.getComponentID());			
				System.out.println("Storing PhosphorusKey: " + bioMightComponentRef+ "   ID: " + phosphorus.getComponentID());
				bioMightKeys.setKey(bioMightKey);
						
				// On the post of data, we map the web data back
				// into the methodView object.  
				//if (executeMethods) { 
				//	System.out.println("Executing Phosphorus Methods!");
				//	phosphorus.executeMethods(methodParams);
				//}
				
				//System.out.println("Getting X3D for Phosphorus");
				bioMightComponent.setX3D(phosphorus.getX3D(snipet));
				System.out.println("Setup X3D for Phosphorus");			
			}			
			else if (bioMightComponentRef.equals(Constants.Potassiums))
			{
				Potassiums potassiums = (Potassiums) bioMightInstance;
				bioMightComponent.setImage(potassiums.getImage());
				bioMightComponent.setBioMightMethods(potassiums.getMethods());
				bioMightComponent.setBioMightProperties(potassiums.getProperties());
				bioMightComponent.setBioMightCollection(true);
				
				// Assooiate the component and ID.
				bioMightKey = new BioMightKey();
				bioMightKey.setComponentName(bioMightComponentName);
				bioMightKey.setComponentID(potassiums.getComponentID());			
				System.out.println("Storing PotassiumsKey: " + bioMightComponentRef+ "   ID: " + potassiums.getComponentID());
				bioMightKeys.setKey(bioMightKey);
						
				// On the post of data, we map the web data back
				// into the methodView object.  
				//if (executeMethods) { 
				//	System.out.println("Executing Potassiums Methods!");
				//	potassiums.executeMethods(methodParams);
				//}
				
				//System.out.println("Getting X3D for Potassiums");
				bioMightComponent.setX3D(potassiums.getX3D(snipet));
				System.out.println("Setup X3D for Potassiums");	
			}
			else if (bioMightComponentRef.equals(Constants.Potassium))
			{
				Potassium potassium = (Potassium) bioMightInstance;
				bioMightComponent.setImage(potassium.getImage());
				bioMightComponent.setBioMightMethods(potassium.getMethods());
				bioMightComponent.setBioMightProperties(potassium.getProperties());
				bioMightComponent.setBioMightCollection(false);
				
				// Assooiate the component and ID.
				bioMightKey = new BioMightKey();
				bioMightKey.setComponentName(bioMightComponentName);
				bioMightKey.setComponentID(potassium.getComponentID());			
				System.out.println("Storing PotassiumKey: " + bioMightComponentRef+ "   ID: " + potassium.getComponentID());
				bioMightKeys.setKey(bioMightKey);
						
				// On the post of data, we map the web data back
				// into the methodView object.  
				//if (executeMethods) { 
				//	System.out.println("Executing Potassium Methods!");
				//	potassium.executeMethods(methodParams);
				//}
				
				//System.out.println("Getting X3D for Potassium");
				bioMightComponent.setX3D(potassium.getX3D(snipet));
				System.out.println("Setup X3D for Potassium");	
			}
			else if (bioMightComponentRef.equals(Constants.Seleniums))
			{
				Seleniums seleniums = (Seleniums) bioMightInstance;
				bioMightComponent.setImage(seleniums.getImage());
				bioMightComponent.setBioMightMethods(seleniums.getMethods());
				bioMightComponent.setBioMightProperties(seleniums.getProperties());
				bioMightComponent.setBioMightCollection(true);
				
				// Assooiate the component and ID.
				bioMightKey = new BioMightKey();
				bioMightKey.setComponentName(bioMightComponentName);
				bioMightKey.setComponentID(seleniums.getComponentID());			
				System.out.println("Storing SeleniumsKey: " + bioMightComponentRef+ "   ID: " + seleniums.getComponentID());
				bioMightKeys.setKey(bioMightKey);
						
				// On the post of data, we map the web data back
				// into the methodView object.  
				//if (executeMethods) { 
				//	System.out.println("Executing Seleniums Methods!");
				//	seleniums.executeMethods(methodParams);
				//}
				
				//System.out.println("Getting X3D for Seleniums");
				bioMightComponent.setX3D(seleniums.getX3D(snipet));
				System.out.println("Setup X3D for Seleniums");	
			}
			else if (bioMightComponentRef.equals(Constants.Selenium))
			{
				Selenium selenium = (Selenium) bioMightInstance;
				bioMightComponent.setImage(selenium.getImage());
				bioMightComponent.setBioMightMethods(selenium.getMethods());
				bioMightComponent.setBioMightProperties(selenium.getProperties());
				bioMightComponent.setBioMightCollection(false);
				
				// Assooiate the component and ID.
				bioMightKey = new BioMightKey();
				bioMightKey.setComponentName(bioMightComponentName);
				bioMightKey.setComponentID(selenium.getComponentID());			
				System.out.println("Storing SeleniumKey: " + bioMightComponentRef+ "   ID: " + selenium.getComponentID());
				bioMightKeys.setKey(bioMightKey);
						
				// On the post of data, we map the web data back
				// into the methodView object.  
				//if (executeMethods) { 
				//	System.out.println("Executing Selenium Methods!");
				//	selenium.executeMethods(methodParams);
				//}
				
				//System.out.println("Getting X3D for Selenium");
				bioMightComponent.setX3D(selenium.getX3D(snipet));
				System.out.println("Setup X3D for Selenium");	
			}
			else if (bioMightComponentRef.equals(Constants.Silicons))
			{
				Silicons silicons = (Silicons) bioMightInstance;
				bioMightComponent.setImage(silicons.getImage());
				bioMightComponent.setBioMightMethods(silicons.getMethods());
				bioMightComponent.setBioMightProperties(silicons.getProperties());
				bioMightComponent.setBioMightCollection(true);
				
				// Assooiate the component and ID.
				bioMightKey = new BioMightKey();
				bioMightKey.setComponentName(bioMightComponentName);
				bioMightKey.setComponentID(silicons.getComponentID());			
				System.out.println("Storing SiliconsKey: " + bioMightComponentRef+ "   ID: " + silicons.getComponentID());
				bioMightKeys.setKey(bioMightKey);
						
				// On the post of data, we map the web data back
				// into the methodView object.  
				//if (executeMethods) { 
				//	System.out.println("Executing Silicons Methods!");
				//	silicons.executeMethods(methodParams);
				//}
				
				//System.out.println("Getting X3D for Silicons");
				bioMightComponent.setX3D(silicons.getX3D(snipet));
				System.out.println("Setup X3D for Silicons");					
			}	
			else if (bioMightComponentRef.equals(Constants.Silicon))
			{
				Silicon silicon = (Silicon) bioMightInstance;
				bioMightComponent.setImage(silicon.getImage());
				bioMightComponent.setBioMightMethods(silicon.getMethods());
				bioMightComponent.setBioMightProperties(silicon.getProperties());
				bioMightComponent.setBioMightCollection(false);
				
				// Assooiate the component and ID.
				bioMightKey = new BioMightKey();
				bioMightKey.setComponentName(bioMightComponentName);
				bioMightKey.setComponentID(silicon.getComponentID());			
				System.out.println("Storing SiliconKey: " + bioMightComponentRef+ "   ID: " + silicon.getComponentID());
				bioMightKeys.setKey(bioMightKey);
						
				// On the post of data, we map the web data back
				// into the methodView object.  
				//if (executeMethods) { 
				//	System.out.println("Executing Silicon Methods!");
				//	silicon.executeMethods(methodParams);
				//}
				
				//System.out.println("Getting X3D for Silicon");
				bioMightComponent.setX3D(silicon.getX3D(snipet));
				System.out.println("Setup X3D for Silicon");					
			}					

			else if (bioMightComponentRef.equals(Constants.Sodiums))
			{
				Sodiums sodiums = (Sodiums) bioMightInstance;
				bioMightComponent.setImage(sodiums.getImage());
				bioMightComponent.setBioMightMethods(sodiums.getMethods());
				bioMightComponent.setBioMightProperties(sodiums.getProperties());
				bioMightComponent.setBioMightCollection(true);
				
				// Assooiate the component and ID.
				bioMightKey = new BioMightKey();
				bioMightKey.setComponentName(bioMightComponentName);
				bioMightKey.setComponentID(sodiums.getComponentID());			
				System.out.println("Storing SodiumsKey: " + bioMightComponentRef+ "   ID: " + sodiums.getComponentID());
				bioMightKeys.setKey(bioMightKey);
						
				// On the post of data, we map the web data back
				// into the methodView object.  
				//if (executeMethods) { 
				//	System.out.println("Executing Sodiums Methods!");
				//	sodiums.executeMethods(methodParams);
				//}
				
				//System.out.println("Getting X3D for Sodiums");
				bioMightComponent.setX3D(sodiums.getX3D(snipet));
				System.out.println("Setup X3D for Sodiums");					
			}	
			else if (bioMightComponentRef.equals(Constants.Sodium))
			{
				Sodium sodium = (Sodium) bioMightInstance;
				bioMightComponent.setImage(sodium.getImage());
				bioMightComponent.setBioMightMethods(sodium.getMethods());
				bioMightComponent.setBioMightProperties(sodium.getProperties());
				bioMightComponent.setBioMightCollection(false);
				
				// Assooiate the component and ID.
				bioMightKey = new BioMightKey();
				bioMightKey.setComponentName(bioMightComponentName);
				bioMightKey.setComponentID(sodium.getComponentID());			
				System.out.println("Storing SodiumKey: " + bioMightComponentRef+ "   ID: " + sodium.getComponentID());
				bioMightKeys.setKey(bioMightKey);
						
				// On the post of data, we map the web data back
				// into the methodView object.  
				//if (executeMethods) { 
				//	System.out.println("Executing Sodium Methods!");
				//	sodium.executeMethods(methodParams);
				//}
				
				//System.out.println("Getting X3D for Sodium");
				bioMightComponent.setX3D(sodium.getX3D(snipet));
				System.out.println("Setup X3D for Sodium");					
			}					
			else if (bioMightComponentRef.equals(Constants.Sulfurs))
			{
				Sulfurs sulfurs = (Sulfurs) bioMightInstance;
				bioMightComponent.setImage(sulfurs.getImage());
				bioMightComponent.setBioMightMethods(sulfurs.getMethods());
				bioMightComponent.setBioMightProperties(sulfurs.getProperties());
				bioMightComponent.setBioMightCollection(true);
				
				// Assooiate the component and ID.
				bioMightKey = new BioMightKey();
				bioMightKey.setComponentName(bioMightComponentName);
				bioMightKey.setComponentID(sulfurs.getComponentID());			
				System.out.println("Storing SulfursKey: " + bioMightComponentRef+ "   ID: " + sulfurs.getComponentID());
				bioMightKeys.setKey(bioMightKey);
						
				// On the post of data, we map the web data back
				// into the methodView object.  
				//if (executeMethods) { 
				//	System.out.println("Executing Sulfurs Methods!");
				//	sulfurs.executeMethods(methodParams);
				//}
				
				//System.out.println("Getting X3D for Sulfurs");
				bioMightComponent.setX3D(sulfurs.getX3D(snipet));
				System.out.println("Setup X3D for Sulfurs");	
			}	
			else if (bioMightComponentRef.equals(Constants.Sulfur))
			{
				Sulfur sulfur = (Sulfur) bioMightInstance;
				bioMightComponent.setImage(sulfur.getImage());
				bioMightComponent.setBioMightMethods(sulfur.getMethods());
				bioMightComponent.setBioMightProperties(sulfur.getProperties());
				bioMightComponent.setBioMightCollection(false);
				
				// Assooiate the component and ID.
				bioMightKey = new BioMightKey();
				bioMightKey.setComponentName(bioMightComponentName);
				bioMightKey.setComponentID(sulfur.getComponentID());			
				System.out.println("Storing SulfurKey: " + bioMightComponentRef+ "   ID: " + sulfur.getComponentID());
				bioMightKeys.setKey(bioMightKey);
						
				// On the post of data, we map the web data back
				// into the methodView object.  
				//if (executeMethods) { 
				//	System.out.println("Executing Sulfur Methods!");
				//	sulfur.executeMethods(methodParams);
				//}
				
				//System.out.println("Getting X3D for Sulfur");
				bioMightComponent.setX3D(sulfur.getX3D(snipet));
				System.out.println("Setup X3D for Sulfur");	
			}	
			else if (bioMightComponentRef.equals(Constants.Vanadiums))
			{
				Vanadiums vanadiums = (Vanadiums) bioMightInstance;
				bioMightComponent.setImage(vanadiums.getImage());
				bioMightComponent.setBioMightMethods(vanadiums.getMethods());
				bioMightComponent.setBioMightProperties(vanadiums.getProperties());
				bioMightComponent.setBioMightCollection(true);
				
				// Assooiate the component and ID.
				bioMightKey = new BioMightKey();
				bioMightKey.setComponentName(bioMightComponentName);
				bioMightKey.setComponentID(vanadiums.getComponentID());			
				System.out.println("Storing VanadiumsKey: " + bioMightComponentRef+ "   ID: " + vanadiums.getComponentID());
				bioMightKeys.setKey(bioMightKey);
						
				// On the post of data, we map the web data back
				// into the methodView object.  
				//if (executeMethods) { 
				//	System.out.println("Executing Vanadiums Methods!");
				//	vanadiums.executeMethods(methodParams);
				//}
				
				//System.out.println("Getting X3D for Vanadiums");
				bioMightComponent.setX3D(vanadiums.getX3D(snipet));
				System.out.println("Setup X3D for Vanadiums");	
			}	
			else if (bioMightComponentRef.equals(Constants.Vanadium))
			{
				Vanadium vanadium = (Vanadium) bioMightInstance;
				bioMightComponent.setImage(vanadium.getImage());
				bioMightComponent.setBioMightMethods(vanadium.getMethods());
				bioMightComponent.setBioMightProperties(vanadium.getProperties());
				bioMightComponent.setBioMightCollection(false);
				
				// Assooiate the component and ID.
				bioMightKey = new BioMightKey();
				bioMightKey.setComponentName(bioMightComponentName);
				bioMightKey.setComponentID(vanadium.getComponentID());			
				System.out.println("Storing VanadiumKey: " + bioMightComponentRef+ "   ID: " + vanadium.getComponentID());
				bioMightKeys.setKey(bioMightKey);
						
				// On the post of data, we map the web data back
				// into the methodView object.  
				//if (executeMethods) { 
				//	System.out.println("Executing Vanadium Methods!");
				//	vanadium.executeMethods(methodParams);
				//}
				
				//System.out.println("Getting X3D for Vanadium");
				bioMightComponent.setX3D(vanadium.getX3D(snipet));
				System.out.println("Setup X3D for Vanadium");	
			}
			else if (bioMightComponentRef.equals(Constants.Zincs))
			{
				Zincs zincs = (Zincs) bioMightInstance;
				bioMightComponent.setImage(zincs.getImage());
				bioMightComponent.setBioMightMethods(zincs.getMethods());
				bioMightComponent.setBioMightProperties(zincs.getProperties());
				bioMightComponent.setBioMightCollection(true);
				
				// Assooiate the component and ID.
				bioMightKey = new BioMightKey();
				bioMightKey.setComponentName(bioMightComponentName);
				bioMightKey.setComponentID(zincs.getComponentID());			
				System.out.println("Storing ZincsKey: " + bioMightComponentRef+ "   ID: " + zincs.getComponentID());
				bioMightKeys.setKey(bioMightKey);
						
				// On the post of data, we map the web data back
				// into the methodView object.  
				//if (executeMethods) { 
				//	System.out.println("Executing Zincs Methods!");
				//	zincs.executeMethods(methodParams);
				//}
				
				//System.out.println("Getting X3D for Zincs");
				bioMightComponent.setX3D(zincs.getX3D(snipet));
				System.out.println("Setup X3D for Zincs");	
			}
			else if (bioMightComponentRef.equals(Constants.Zinc))
			{
				Zinc zinc = (Zinc) bioMightInstance;
				bioMightComponent.setImage(zinc.getImage());
				bioMightComponent.setBioMightMethods(zinc.getMethods());
				bioMightComponent.setBioMightProperties(zinc.getProperties());
				bioMightComponent.setBioMightCollection(false);
				
				// Assooiate the component and ID.
				bioMightKey = new BioMightKey();
				bioMightKey.setComponentName(bioMightComponentName);
				bioMightKey.setComponentID(zinc.getComponentID());			
				System.out.println("Storing ZincKey: " + bioMightComponentRef+ "   ID: " + zinc.getComponentID());
				bioMightKeys.setKey(bioMightKey);
						
				// On the post of data, we map the web data back
				// into the methodView object.  
				//if (executeMethods) { 
				//	System.out.println("Executing Zinc Methods!");
				//	zinc.executeMethods(methodParams);
				//}
				
				//System.out.println("Getting X3D for Zinc");
				bioMightComponent.setX3D(zinc.getX3D(snipet));
				System.out.println("Setup X3D for Zinc");	
			}
						
			
			/**************************************************************************
			*
			* MOLECULES
			* 
			***************************************************************************/				

			else if (bioMightComponentRef.equals(Constants.Enzymes))
			{
				Enzymes enzymes = (Enzymes) bioMightInstance;
				bioMightComponent.setImage(enzymes.getImage());
				bioMightComponent.setBioMightMethods(enzymes.getMethods());
				bioMightComponent.setBioMightProperties(enzymes.getProperties());
				bioMightComponent.setBioMightCollection(true);
				
				// Assooiate the component and ID.
				bioMightKey = new BioMightKey();
				bioMightKey.setComponentName(bioMightComponentName);
				bioMightKey.setComponentID(enzymes.getComponentID());			
				System.out.println("Storing EnzymesKey: " + bioMightComponentRef+ "   ID: " + enzymes.getComponentID());
				bioMightKeys.setKey(bioMightKey);
						
				// On the post of data, we map the web data back
				// into the methodView object.  
				//if (executeMethods) { 
				//	System.out.println("Executing Enzyme Methods!");
				//	enzymes.executeMethods(methodParams);
				//}
				
				//System.out.println("Getting X3D for Enzymes");
				bioMightComponent.setX3D(enzymes.getX3D(snipet));
				System.out.println("Setup X3D for Enzymes");	
			}
			else if (bioMightComponentRef.equals(Constants.Enzyme))
			{
				Enzyme enzyme = (Enzyme) bioMightInstance;
				bioMightComponent.setImage(enzyme.getImage());
				bioMightComponent.setBioMightMethods(enzyme.getMethods());
				bioMightComponent.setBioMightProperties(enzyme.getProperties());
				bioMightComponent.setBioMightCollection(true);
				
				// Assooiate the component and ID.
				bioMightKey = new BioMightKey();
				bioMightKey.setComponentName(bioMightComponentName);
				bioMightKey.setComponentID(enzyme.getComponentID());			
				System.out.println("Storing EnzymeKey: " + bioMightComponentRef+ "   ID: " + enzyme.getComponentID());
				bioMightKeys.setKey(bioMightKey);
						
				// On the post of data, we map the web data back
				// into the methodView object.  
				//if (executeMethods) { 
				//	System.out.println("Executing Enzyme Methods!");
				//	enzyme.executeMethods(methodParams);
				//}
				
				//System.out.println("Getting X3D for Enzyme");
				bioMightComponent.setX3D(enzyme.getX3D(snipet));
				System.out.println("Setup X3D for Enzyme");	
			}			
			else if (bioMightComponentRef.equals(Constants.Hormones))
			{
				Hormones hormones = (Hormones) bioMightInstance;
				bioMightComponent.setImage(hormones.getImage());
				bioMightComponent.setBioMightMethods(hormones.getMethods());
				bioMightComponent.setBioMightProperties(hormones.getProperties());
				bioMightComponent.setBioMightCollection(true);
				
				// Assooiate the component and ID.
				bioMightKey = new BioMightKey();
				bioMightKey.setComponentName(bioMightComponentName);
				bioMightKey.setComponentID(hormones.getComponentID());			
				System.out.println("Storing HormonesKey: " + bioMightComponentRef+ "   ID: " + hormones.getComponentID());
				bioMightKeys.setKey(bioMightKey);
						
				// On the post of data, we map the web data back
				// into the methodView object.  
				//if (executeMethods) { 
				//	System.out.println("Executing Hormone Methods!");
				//	hormones.executeMethods(methodParams);
				//}
				
				//System.out.println("Getting X3D for Hormones");
				bioMightComponent.setX3D(hormones.getX3D(snipet));
				System.out.println("Setup X3D for Hormones");	
			}
			else if (bioMightComponentRef.equals(Constants.Lipids))
			{
				Lipids lipids = (Lipids) bioMightInstance;
				bioMightComponent.setImage(lipids.getImage());
				bioMightComponent.setBioMightMethods(lipids.getMethods());
				bioMightComponent.setBioMightProperties(lipids.getProperties());
				bioMightComponent.setBioMightCollection(true);
				
				// Assooiate the component and ID.
				bioMightKey = new BioMightKey();
				bioMightKey.setComponentName(bioMightComponentName);
				bioMightKey.setComponentID(lipids.getComponentID());			
				System.out.println("Storing LipidsKey: " + bioMightComponentRef+ "   ID: " + lipids.getComponentID());
				bioMightKeys.setKey(bioMightKey);
						
				// On the post of data, we map the web data back
				// into the methodView object.  
				//if (executeMethods) { 
				//	System.out.println("Executing Lipid Methods!");
				//	lipids.executeMethods(methodParams);
				//}
				
				//System.out.println("Getting X3D for Lipids");
				bioMightComponent.setX3D(lipids.getX3D(snipet));
				System.out.println("Setup X3D for Lipids");	
			}
			else if (bioMightComponentRef.equals(Constants.Peptides))
			{
				Peptides peptides = (Peptides) bioMightInstance;
				bioMightComponent.setImage(peptides.getImage());
				bioMightComponent.setBioMightMethods(peptides.getMethods());
				bioMightComponent.setBioMightProperties(peptides.getProperties());
				bioMightComponent.setBioMightCollection(true);
				
				// Assooiate the component and ID.
				bioMightKey = new BioMightKey();
				bioMightKey.setComponentName(bioMightComponentName);
				bioMightKey.setComponentID(peptides.getComponentID());			
				System.out.println("Storing PeptidesKey: " + bioMightComponentRef+ "   ID: " + peptides.getComponentID());
				bioMightKeys.setKey(bioMightKey);
						
				// On the post of data, we map the web data back
				// into the methodView object.  
				//if (executeMethods) { 
				//	System.out.println("Executing Peptide Methods!");
				//	peptides.executeMethods(methodParams);
				//}
				
				//System.out.println("Getting X3D for Peptides");
				bioMightComponent.setX3D(peptides.getX3D(snipet));
				System.out.println("Setup X3D for Peptides");	
			}
			else if (bioMightComponentRef.equals(Constants.Peptide))
			{
				Peptide peptide = (Peptide) bioMightInstance;
				bioMightComponent.setImage(peptide.getImage());
				bioMightComponent.setBioMightMethods(peptide.getMethods());
				bioMightComponent.setBioMightProperties(peptide.getProperties());
				bioMightComponent.setBioMightCollection(true);
				
				// Assooiate the component and ID.
				bioMightKey = new BioMightKey();
				bioMightKey.setComponentName(bioMightComponentName);
				bioMightKey.setComponentID(peptide.getComponentID());			
				System.out.println("Storing PeptideKey: " + bioMightComponentRef+ "   ID: " + peptide.getComponentID());
				bioMightKeys.setKey(bioMightKey);
						
				// On the post of data, we map the web data back
				// into the methodView object.  
				//if (executeMethods) { 
				//	System.out.println("Executing Peptide Methods!");
				//	peptide.executeMethods(methodParams);
				//}
				
				//System.out.println("Getting X3D for Peptide");
				//bioMightComponent.setX3D(peptide.getX3D(snipet));
				System.out.println("Setup X3D for Peptide");	
			}	
			else if (bioMightComponentRef.equals(Constants.Steroids))
			{
				Steroids steroids = (Steroids) bioMightInstance;
				bioMightComponent.setImage(steroids.getImage());
				bioMightComponent.setBioMightMethods(steroids.getMethods());
				bioMightComponent.setBioMightProperties(steroids.getProperties());
				bioMightComponent.setBioMightCollection(true);
				
				// Assooiate the component and ID.
				bioMightKey = new BioMightKey();
				bioMightKey.setComponentName(bioMightComponentName);
				bioMightKey.setComponentID(steroids.getComponentID());			
				System.out.println("Storing SteroidsKey: " + bioMightComponentRef+ "   ID: " + steroids.getComponentID());
				bioMightKeys.setKey(bioMightKey);
						
				// On the post of data, we map the web data back
				// into the methodView object.  
				//if (executeMethods) { 
				//	System.out.println("Executing Steroid Methods!");
				//	steroids.executeMethods(methodParams);
				//}
				
				//System.out.println("Getting X3D for Steroids");
				bioMightComponent.setX3D(steroids.getX3D(snipet));
				System.out.println("Setup X3D for Steroids");	
			}	
			
			else if (bioMightComponentRef.equals(Constants.Acervuli))
			{
				Acervuli acervuli = (Acervuli) bioMightInstance;
				bioMightComponent.setImage(acervuli.getImage());
				bioMightComponent.setWidth(acervuli.getImageWidth());
				bioMightComponent.setHeight(acervuli.getImageHeight());
			}
			else if (bioMightComponentRef.equals(Constants.AmmoniumPhosphate))
			{
				AmmoniumPhosphate ammoniumPhosphate = (AmmoniumPhosphate) bioMightInstance;
				bioMightComponent.setImage(ammoniumPhosphate.getImage());
				bioMightComponent.setWidth(ammoniumPhosphate.getImageWidth());
				bioMightComponent.setHeight(ammoniumPhosphate.getImageHeight());
			}
			else if (bioMightComponentRef.equals(Constants.Bicarbonate))
			{
				Bicarbonate bicarbonate = (Bicarbonate) bioMightInstance;
				bioMightComponent.setImage(bicarbonate.getImage());
				bioMightComponent.setWidth(bicarbonate.getImageWidth());
				bioMightComponent.setHeight(bicarbonate.getImageHeight());
			}
			else if (bioMightComponentRef.equals(Constants.Bilirubin))
			{
				Bilirubin bilirubin = (Bilirubin) bioMightInstance;
				bioMightComponent.setImage(bilirubin.getImage());
				bioMightComponent.setWidth(bilirubin.getImageWidth());
				bioMightComponent.setHeight(bilirubin.getImageHeight());
			}
			else if (bioMightComponentRef.equals(Constants.Biliverdin))
			{
				Biliverdin biliverdin = (Biliverdin) bioMightInstance;
				bioMightComponent.setImage(biliverdin.getImage());
				bioMightComponent.setWidth(biliverdin.getImageWidth());
				bioMightComponent.setHeight(biliverdin.getImageHeight());
			}
			else if (bioMightComponentRef.equals(Constants.Calcite))
			{
				Calcite calcite = (Calcite) bioMightInstance;
				bioMightComponent.setImage(calcite.getImage());
				bioMightComponent.setWidth(calcite.getImageWidth());
				bioMightComponent.setHeight(calcite.getImageHeight());
			}
			else if (bioMightComponentRef.equals(Constants.CalciumCarbonate))
			{
				CalciumCarbonate calciumCarbonate = (CalciumCarbonate) bioMightInstance;
				bioMightComponent.setImage(calciumCarbonate.getImage());
				bioMightComponent.setWidth(calciumCarbonate.getImageWidth());
				bioMightComponent.setHeight(calciumCarbonate.getImageHeight());
			}
			else if (bioMightComponentRef.equals(Constants.CalciumPhosphate))
			{
				CalciumPhosphate calciumPhosphate = (CalciumPhosphate) bioMightInstance;
				bioMightComponent.setImage(calciumPhosphate.getImage());
				bioMightComponent.setWidth(calciumPhosphate.getImageWidth());
				bioMightComponent.setHeight(calciumPhosphate.getImageHeight());
			}
			else if (bioMightComponentRef.equals(Constants.DeoxyCholicAcid))
			{
				DeoxyCholicAcid deoxyCholicAcid = (DeoxyCholicAcid) bioMightInstance;
				bioMightComponent.setImage(deoxyCholicAcid.getImage());
				bioMightComponent.setWidth(deoxyCholicAcid.getImageWidth());
				bioMightComponent.setHeight(deoxyCholicAcid.getImageHeight());
			}
			else if (bioMightComponentRef.equals(Constants.DiaminobutyricAcid))
			{
				DiaminobutyricAcid diaminobutyricAcid = (DiaminobutyricAcid) bioMightInstance;
				bioMightComponent.setImage(diaminobutyricAcid.getImage());
				bioMightComponent.setWidth(diaminobutyricAcid.getImageWidth());
				bioMightComponent.setHeight(diaminobutyricAcid.getImageHeight());
			}
			else if (bioMightComponentRef.equals(Constants.DihydroxyindoleCarboxylicAcid))
			{
				DihydroxyindoleCarboxylicAcid dihydroxyindoleCarboxylicAcid = (DihydroxyindoleCarboxylicAcid) bioMightInstance;
				bioMightComponent.setImage(dihydroxyindoleCarboxylicAcid.getImage());
				bioMightComponent.setWidth(dihydroxyindoleCarboxylicAcid.getImageWidth());
				bioMightComponent.setHeight(dihydroxyindoleCarboxylicAcid.getImageHeight());
			}
			else if (bioMightComponentRef.equals(Constants.ErgoSterol))
			{
				ErgoSterol ergoSterol = (ErgoSterol) bioMightInstance;
				bioMightComponent.setImage(ergoSterol.getImage());
				bioMightComponent.setWidth(ergoSterol.getImageWidth());
				bioMightComponent.setHeight(ergoSterol.getImageHeight());
			}
			else if (bioMightComponentRef.equals(Constants.GlycoCalyx))
			{
				GlycoCalyx glycoCalyx = (GlycoCalyx) bioMightInstance;
				bioMightComponent.setImage(glycoCalyx.getImage());
				bioMightComponent.setWidth(glycoCalyx.getImageWidth());
				bioMightComponent.setHeight(glycoCalyx.getImageHeight());
			}
			else if (bioMightComponentRef.equals(Constants.H20))
			{
				H20 h20 = (H20) bioMightInstance;
				bioMightComponent.setImage(h20.getImage());
				bioMightComponent.setWidth(h20.getImageWidth());
				bioMightComponent.setHeight(h20.getImageHeight());
			}
			else if (bioMightComponentRef.equals(Constants.Heme))
			{
				Heme heme = (Heme) bioMightInstance;
				bioMightComponent.setImage(heme.getImage());
				bioMightComponent.setWidth(heme.getImageWidth());
				bioMightComponent.setHeight(heme.getImageHeight());
			}
			else if (bioMightComponentRef.equals(Constants.Hemoglobin))
			{
				Hemoglobin hemoglobin = (Hemoglobin) bioMightInstance;
				bioMightComponent.setImage(hemoglobin.getImage());
				bioMightComponent.setWidth(hemoglobin.getImageWidth());
				bioMightComponent.setHeight(hemoglobin.getImageHeight());
			}
			else if (bioMightComponentRef.equals(Constants.Indolequinone))
			{
				Indolequinone indolequinone = (Indolequinone) bioMightInstance;
				bioMightComponent.setImage(indolequinone.getImage());
				bioMightComponent.setWidth(indolequinone.getImageWidth());
				bioMightComponent.setHeight(indolequinone.getImageHeight());
			}
			else if (bioMightComponentRef.equals(Constants.Lysozyme))
			{
				Lysozyme lysozyme = (Lysozyme) bioMightInstance;
				bioMightComponent.setImage(lysozyme.getImage());
				bioMightComponent.setWidth(lysozyme.getImageWidth());
				bioMightComponent.setHeight(lysozyme.getImageHeight());
			}
			else if (bioMightComponentRef.equals(Constants.Lysozymes))
			{
				Lysozymes lysozymes = (Lysozymes) bioMightInstance;
				bioMightComponent.setImage(lysozymes.getImage());
				bioMightComponent.setWidth(lysozymes.getImageWidth());
				bioMightComponent.setHeight(lysozymes.getImageHeight());
			}
			else if (bioMightComponentRef.equals(Constants.MagnesiumPhosphate))
			{
				MagnesiumPhosphate magnesiumPhosphate = (MagnesiumPhosphate) bioMightInstance;
				bioMightComponent.setImage(magnesiumPhosphate.getImage());
				bioMightComponent.setWidth(magnesiumPhosphate.getImageWidth());
				bioMightComponent.setHeight(magnesiumPhosphate.getImageHeight());
			}
			else if (bioMightComponentRef.equals(Constants.Molecule))
			{
				Molecule molecule = (Molecule) bioMightInstance;
				bioMightComponent.setImage(molecule.getImage());
				bioMightComponent.setWidth(molecule.getImageWidth());
				bioMightComponent.setHeight(molecule.getImageHeight());
			}
			else if (bioMightComponentRef.equals(Constants.Molecules))
			{
				Molecules molecules = (Molecules) bioMightInstance;
				bioMightComponent.setImage(molecules.getImage());
				bioMightComponent.setBioMightProperties(molecules.getProperties());
				bioMightComponent.setBioMightMethods(molecules.getMethods());
				
				// Assooiate the component and ID.
				bioMightKey = new BioMightKey();
				bioMightKey.setComponentName(bioMightComponentName);
				bioMightKey.setComponentID(molecules.getComponentID());			
				//System.out.println("Storing Molecule Key: " + bioMightComponentRef+ "   ID: " + molecules.getComponentID());
				bioMightKeys.setKey(bioMightKey);
		
				// On the post of data, we map the web data back
				// into the methodView object.  
				if (executeMethods) {
					//bacterias.executeMethods(bioMightMethods);
					//bioMightComponent.setX3D(cell.getX3D());
				}
				bioMightComponent.setX3D(molecules.getX3D(snipet));
			}
			else if (bioMightComponentRef.equals(Constants.Nephrin))
			{
				Nephrin nephrin = (Nephrin) bioMightInstance;
				bioMightComponent.setImage(nephrin.getImage());
				bioMightComponent.setWidth(nephrin.getImageWidth());
				bioMightComponent.setHeight(nephrin.getImageHeight());
			}
			else if (bioMightComponentRef.equals(Constants.PCadherin))
			{
				PCadherin pCadherin = (PCadherin) bioMightInstance;
				bioMightComponent.setImage(pCadherin.getImage());
				bioMightComponent.setWidth(pCadherin.getImageWidth());
				bioMightComponent.setHeight(pCadherin.getImageHeight());
			}
			else if (bioMightComponentRef.equals(Constants.Pilin))
			{
				Pilin pilin = (Pilin) bioMightInstance;
				bioMightComponent.setImage(pilin.getImage());
				bioMightComponent.setWidth(pilin.getImageWidth());
				bioMightComponent.setHeight(pilin.getImageHeight());
			}
			else if (bioMightComponentRef.equals(Constants.Podocalyxin))
			{
				Podocalyxin podocalyxin = (Podocalyxin) bioMightInstance;
				bioMightComponent.setImage(podocalyxin.getImage());
				bioMightComponent.setWidth(podocalyxin.getImageWidth());
				bioMightComponent.setHeight(podocalyxin.getImageHeight());
			}
			else if (bioMightComponentRef.equals(Constants.Retinal))
			{
				Retinal retinal = (Retinal) bioMightInstance;
				bioMightComponent.setImage(retinal.getImage());
				bioMightComponent.setWidth(retinal.getImageWidth());
				bioMightComponent.setHeight(retinal.getImageHeight());
			}
			else if (bioMightComponentRef.equals(Constants.Salt))
			{
				Salt salt = (Salt) bioMightInstance;
				bioMightComponent.setImage(salt.getImage());
				bioMightComponent.setWidth(salt.getImageWidth());
				bioMightComponent.setHeight(salt.getImageHeight());
			}
			else if (bioMightComponentRef.equals(Constants.SodiumGlycoCholate))
			{
				SodiumGlycoCholate sodiumGlycoCholate = (SodiumGlycoCholate) bioMightInstance;
				bioMightComponent.setImage(sodiumGlycoCholate.getImage());
				bioMightComponent.setWidth(sodiumGlycoCholate.getImageWidth());
				bioMightComponent.setHeight(sodiumGlycoCholate.getImageHeight());
			}
			else if (bioMightComponentRef.equals(Constants.SodiumTauroCholate))
			{
				SodiumTauroCholate sodiumTauroCholate = (SodiumTauroCholate) bioMightInstance;
				bioMightComponent.setImage(sodiumTauroCholate.getImage());
				bioMightComponent.setWidth(sodiumTauroCholate.getImageWidth());
				bioMightComponent.setHeight(sodiumTauroCholate.getImageHeight());
			}
			else if (bioMightComponentRef.equals(Constants.TauroCholicAcid))
			{
				TauroCholicAcid tauroCholicAcid = (TauroCholicAcid) bioMightInstance;
				bioMightComponent.setImage(tauroCholicAcid.getImage());
				bioMightComponent.setWidth(tauroCholicAcid.getImageWidth());
				bioMightComponent.setHeight(tauroCholicAcid.getImageHeight());
			}
			else if (bioMightComponentRef.equals(Constants.Thiocyanate))
			{
				Thiocyanate thiocyanate = (Thiocyanate) bioMightInstance;
				bioMightComponent.setImage(thiocyanate.getImage());
				bioMightComponent.setWidth(thiocyanate.getImageWidth());
				bioMightComponent.setHeight(thiocyanate.getImageHeight());
			}
			else if (bioMightComponentRef.equals(Constants.TransPeptidase))
			{
				TransPeptidase transPeptidase = (TransPeptidase) bioMightInstance;
				bioMightComponent.setImage(transPeptidase.getImage());
				bioMightComponent.setWidth(transPeptidase.getImageWidth());
				bioMightComponent.setHeight(transPeptidase.getImageHeight());
			}

			// AMINO ACIDS
			else if (bioMightComponentRef.equals(Constants.AminoAcids))
			{
				AminoAcids aminoAcids = (AminoAcids) bioMightInstance;
				bioMightComponent.setImage(aminoAcids.getImage());
				bioMightComponent.setBioMightProperties(aminoAcids.getProperties());
				bioMightComponent.setBioMightMethods(aminoAcids.getMethods());
				
				// Assooiate the component and ID.
				bioMightKey = new BioMightKey();
				bioMightKey.setComponentName(bioMightComponentName);
				bioMightKey.setComponentID(aminoAcids.getComponentID());			
				System.out.println("Storing AminoAcid Key: " + bioMightComponentRef+ "   ID: " + aminoAcids.getComponentID());
				bioMightKeys.setKey(bioMightKey);
		
				// On the post of data, we map the web data back
				// into the methodView object.  
				if (executeMethods) {
					//bacterias.executeMethods(bioMightMethods);
					//aminoAcids.setX3D(cell.getX3D());
				}
				bioMightComponent.setX3D(aminoAcids.getX3D(snipet));
			}
			else if (bioMightComponentRef.equals(Constants.AminoAcid))
			{
				AminoAcid aminoAcid = (AminoAcid) bioMightInstance;
				bioMightComponent.setImage(aminoAcid.getImage());
				bioMightComponent.setBioMightProperties(aminoAcid.getProperties());
				bioMightComponent.setBioMightMethods(aminoAcid.getMethods());
				
				// Assooiate the component and ID.
				bioMightKey = new BioMightKey();
				bioMightKey.setComponentName(bioMightComponentName);
				bioMightKey.setComponentID(aminoAcid.getComponentID());			
				System.out.println("Storing AminoAcid Key: " + bioMightComponentRef+ "   ID: " + aminoAcid.getComponentID());
				bioMightKeys.setKey(bioMightKey);
		
				// On the post of data, we map the web data back
				// into the methodView object.  
				if (executeMethods) {
					//bacterias.executeMethods(bioMightMethods);
					//bioMightComponent.setX3D(cell.getX3D());
				}
				//bioMightComponent.setX3D(aminoAcid.getX3D(snipet));
			}
			else if (bioMightComponentRef.equals(Constants.Alanines))
			{
				Alanines allanines = (Alanines) bioMightInstance;
				bioMightComponent.setImage(allanines.getImage());
				bioMightComponent.setBioMightMethods(allanines.getMethods());
				bioMightComponent.setBioMightProperties(allanines.getProperties());
				bioMightComponent.setBioMightCollection(true);
				
				// Assooiate the component and ID.
				bioMightKey = new BioMightKey();
				bioMightKey.setComponentName(bioMightComponentName);
				bioMightKey.setComponentID(allanines.getComponentID());			
				System.out.println("Storing AlaninesKey: " + bioMightComponentRef+ "   ID: " + allanines.getComponentID());
				bioMightKeys.setKey(bioMightKey);
						
				// On the post of data, we map the web data back
				// into the methodView object.  
				//if (executeMethods) { 
				//	System.out.println("Executing Alaninesa Methods!");
				//	allanines.executeMethods(methodParams);
				//}
				
				//System.out.println("Getting X3D for Alanines");
				bioMightComponent.setX3D(allanines.getX3D(snipet));
				System.out.println("Setup X3D for Alanines!!!");
			}	
			else if (bioMightComponentRef.equals(Constants.Alanine))
			{
				Alanine alanine = (Alanine) bioMightInstance;
				bioMightComponent.setImage(alanine.getImage());
				bioMightComponent.setBioMightMethods(alanine.getMethods());
				bioMightComponent.setBioMightProperties(alanine.getProperties());
				bioMightComponent.setBioMightCollection(true);
				
				// Assooiate the component and ID.
				bioMightKey = new BioMightKey();
				bioMightKey.setComponentName(bioMightComponentName);
				bioMightKey.setComponentID(alanine.getComponentID());			
				System.out.println("Storing AlanineKey: " + bioMightComponentRef+ "   ID: " + alanine.getComponentID());
				bioMightKeys.setKey(bioMightKey);
						
				// On the post of data, we map the web data back
				// into the methodView object.  
				//if (executeMethods) { 
				//	System.out.println("Executing Alaninea Methods!");
				//	alanine.executeMethods(methodParams);
				//}
				
				//System.out.println("Getting X3D for Alanine");
				bioMightComponent.setX3D(alanine.getX3D(snipet));
				System.out.println("Setup X3D for Alanine!!!");
			}			
			else if (bioMightComponentRef.equals(Constants.Arginines))
			{
				Arginines arginines = (Arginines) bioMightInstance;
				bioMightComponent.setImage(arginines.getImage());
				bioMightComponent.setBioMightMethods(arginines.getMethods());
				bioMightComponent.setBioMightProperties(arginines.getProperties());
				bioMightComponent.setBioMightCollection(true);
				
				// Assooiate the component and ID.
				bioMightKey = new BioMightKey();
				bioMightKey.setComponentName(bioMightComponentName);
				bioMightKey.setComponentID(arginines.getComponentID());			
				System.out.println("Storing ArgininesKey: " + bioMightComponentRef+ "   ID: " + arginines.getComponentID());
				bioMightKeys.setKey(bioMightKey);
						
				// On the post of data, we map the web data back
				// into the methodView object.  
				//if (executeMethods) { 
				//	System.out.println("Executing Argininesa Methods!");
				//	arginines.executeMethods(methodParams);
				//}
				
				//System.out.println("Getting X3D for Arginines");
				bioMightComponent.setX3D(arginines.getX3D(snipet));
				System.out.println("Setup X3D for Arginines!!!");
			}	
			else if (bioMightComponentRef.equals(Constants.Arginine))
			{
				Arginine arginine = (Arginine) bioMightInstance;
				bioMightComponent.setImage(arginine.getImage());
				bioMightComponent.setBioMightMethods(arginine.getMethods());
				bioMightComponent.setBioMightProperties(arginine.getProperties());
				bioMightComponent.setBioMightCollection(true);
				
				// Assooiate the component and ID.
				bioMightKey = new BioMightKey();
				bioMightKey.setComponentName(bioMightComponentName);
				bioMightKey.setComponentID(arginine.getComponentID());			
				System.out.println("Storing ArginineKey: " + bioMightComponentRef+ "   ID: " + arginine.getComponentID());
				bioMightKeys.setKey(bioMightKey);
						
				// On the post of data, we map the web data back
				// into the methodView object.  
				//if (executeMethods) { 
				//	System.out.println("Executing Arginine Methods!");
				//	arginine.executeMethods(methodParams);
				//}
				
				//System.out.println("Getting X3D for Arginine");
				bioMightComponent.setX3D(arginine.getX3D(snipet));
				System.out.println("Setup X3D for Arginine!!!");
			}		
			else if (bioMightComponentRef.equals(Constants.Asparagines))
			{
				Asparagines asparagines = (Asparagines) bioMightInstance;
				bioMightComponent.setImage(asparagines.getImage());
				bioMightComponent.setBioMightMethods(asparagines.getMethods());
				bioMightComponent.setBioMightProperties(asparagines.getProperties());
				bioMightComponent.setBioMightCollection(true);
				
				// Assooiate the component and ID.
				bioMightKey = new BioMightKey();
				bioMightKey.setComponentName(bioMightComponentName);
				bioMightKey.setComponentID(asparagines.getComponentID());			
				System.out.println("Storing AsparaginesKey: " + bioMightComponentRef+ "   ID: " + asparagines.getComponentID());
				bioMightKeys.setKey(bioMightKey);
						
				// On the post of data, we map the web data back
				// into the methodView object.  
				//if (executeMethods) { 
				//	System.out.println("Executing Asparaginesa Methods!");
				//	asparagines.executeMethods(methodParams);
				//}
				
				//System.out.println("Getting X3D for Asparagines");
				bioMightComponent.setX3D(asparagines.getX3D(snipet));
				System.out.println("Setup X3D for Asparagines!!!");
			}	
			else if (bioMightComponentRef.equals(Constants.Asparagine))
			{
				Asparagine asparagine = (Asparagine) bioMightInstance;
				bioMightComponent.setImage(asparagine.getImage());
				bioMightComponent.setBioMightMethods(asparagine.getMethods());
				bioMightComponent.setBioMightProperties(asparagine.getProperties());
				bioMightComponent.setBioMightCollection(true);
				
				// Assooiate the component and ID.
				bioMightKey = new BioMightKey();
				bioMightKey.setComponentName(bioMightComponentName);
				bioMightKey.setComponentID(asparagine.getComponentID());			
				System.out.println("Storing AsparagineKey: " + bioMightComponentRef+ "   ID: " + asparagine.getComponentID());
				bioMightKeys.setKey(bioMightKey);
						
				// On the post of data, we map the web data back
				// into the methodView object.  
				//if (executeMethods) { 
				//	System.out.println("Executing Asparaginea Methods!");
				//	asparagine.executeMethods(methodParams);
				//}
				
				//System.out.println("Getting X3D for Asparagine");
				bioMightComponent.setX3D(asparagine.getX3D(snipet));
				System.out.println("Setup X3D for Asparagine!!!");
			}
			
			else if (bioMightComponentRef.equals(Constants.AsparticAcids))
			{
				AsparticAcids asparticAcids = (AsparticAcids) bioMightInstance;
				bioMightComponent.setImage(asparticAcids.getImage());
				bioMightComponent.setBioMightMethods(asparticAcids.getMethods());
				bioMightComponent.setBioMightProperties(asparticAcids.getProperties());
				bioMightComponent.setBioMightCollection(true);
				
				// Assooiate the component and ID.
				bioMightKey = new BioMightKey();
				bioMightKey.setComponentName(bioMightComponentName);
				bioMightKey.setComponentID(asparticAcids.getComponentID());			
				System.out.println("Storing AsparticAcidsKey: " + bioMightComponentRef+ "   ID: " + asparticAcids.getComponentID());
				bioMightKeys.setKey(bioMightKey);
						
				// On the post of data, we map the web data back
				// into the methodView object.  
				//if (executeMethods) { 
				//	System.out.println("Executing AsparticAcids Methods!");
				//	asparticAcids.executeMethods(methodParams);
				//}
				
				//System.out.println("Getting X3D for AsparticAcids");
				bioMightComponent.setX3D(asparticAcids.getX3D(snipet));
				System.out.println("Setup X3D for AsparticAcids");
			}	
			else if (bioMightComponentRef.equals(Constants.AsparticAcid))
			{
				AsparticAcid asparticAcid = (AsparticAcid) bioMightInstance;
				bioMightComponent.setImage(asparticAcid.getImage());
				bioMightComponent.setBioMightMethods(asparticAcid.getMethods());
				bioMightComponent.setBioMightProperties(asparticAcid.getProperties());
				bioMightComponent.setBioMightCollection(true);
				
				// Assooiate the component and ID.
				bioMightKey = new BioMightKey();
				bioMightKey.setComponentName(bioMightComponentName);
				bioMightKey.setComponentID(asparticAcid.getComponentID());			
				System.out.println("Storing AsparticAcidKey: " + bioMightComponentRef+ "   ID: " + asparticAcid.getComponentID());
				bioMightKeys.setKey(bioMightKey);
						
				// On the post of data, we map the web data back
				// into the methodView object.  
				//if (executeMethods) { 
				//	System.out.println("Executing AsparticAcid Methods!");
				//	asparticAcid.executeMethods(methodParams);
				//}
				
				//System.out.println("Getting X3D for AsparticAcid");
				bioMightComponent.setX3D(asparticAcid.getX3D(snipet));
				System.out.println("Setup X3D for AsparticAcid");
			}
			else if (bioMightComponentRef.equals(Constants.Cysteines))
			{
				Cysteines cysteines = (Cysteines) bioMightInstance;
				bioMightComponent.setImage(cysteines.getImage());
				bioMightComponent.setBioMightMethods(cysteines.getMethods());
				bioMightComponent.setBioMightProperties(cysteines.getProperties());
				bioMightComponent.setBioMightCollection(true);
				
				// Assooiate the component and ID.
				bioMightKey = new BioMightKey();
				bioMightKey.setComponentName(bioMightComponentName);
				bioMightKey.setComponentID(cysteines.getComponentID());			
				System.out.println("Storing CysteinesKey: " + bioMightComponentRef+ "   ID: " + cysteines.getComponentID());
				bioMightKeys.setKey(bioMightKey);
						
				// On the post of data, we map the web data back
				// into the methodView object.  
				//if (executeMethods) { 
				//	System.out.println("Executing Cysteines Methods!");
				//	cysteines.executeMethods(methodParams);
				//}
				
				//System.out.println("Getting X3D for Cysteines");
				bioMightComponent.setX3D(cysteines.getX3D(snipet));
				System.out.println("Setup X3D for Cysteines");
			}
			else if (bioMightComponentRef.equals(Constants.Cysteine))
			{
				Cysteine cysteine = (Cysteine) bioMightInstance;
				bioMightComponent.setImage(cysteine.getImage());
				bioMightComponent.setBioMightMethods(cysteine.getMethods());
				bioMightComponent.setBioMightProperties(cysteine.getProperties());
				bioMightComponent.setBioMightCollection(true);
				
				// Assooiate the component and ID.
				bioMightKey = new BioMightKey();
				bioMightKey.setComponentName(bioMightComponentName);
				bioMightKey.setComponentID(cysteine.getComponentID());			
				System.out.println("Storing CysteineKey: " + bioMightComponentRef+ "   ID: " + cysteine.getComponentID());
				bioMightKeys.setKey(bioMightKey);
						
				// On the post of data, we map the web data back
				// into the methodView object.  
				//if (executeMethods) { 
				//	System.out.println("Executing Cysteine Methods!");
				//	cysteine.executeMethods(methodParams);
				//}
				
				//System.out.println("Getting X3D for Cysteine");
				bioMightComponent.setX3D(cysteine.getX3D(snipet));
				System.out.println("Setup X3D for Cysteine");
			}
			else if (bioMightComponentRef.equals(Constants.GlutamicAcids))
			{
				GlutamicAcids cysteines = (GlutamicAcids) bioMightInstance;
				bioMightComponent.setImage(cysteines.getImage());
				bioMightComponent.setBioMightMethods(cysteines.getMethods());
				bioMightComponent.setBioMightProperties(cysteines.getProperties());
				bioMightComponent.setBioMightCollection(true);
				
				// Assooiate the component and ID.
				bioMightKey = new BioMightKey();
				bioMightKey.setComponentName(bioMightComponentName);
				bioMightKey.setComponentID(cysteines.getComponentID());			
				System.out.println("Storing GlutamicAcidsKey: " + bioMightComponentRef+ "   ID: " + cysteines.getComponentID());
				bioMightKeys.setKey(bioMightKey);
						
				// On the post of data, we map the web data back
				// into the methodView object.  
				//if (executeMethods) { 
				//	System.out.println("Executing GlutamicAcids Methods!");
				//	cysteines.executeMethods(methodParams);
				//}
				
				//System.out.println("Getting X3D for GlutamicAcids");
				bioMightComponent.setX3D(cysteines.getX3D(snipet));
				System.out.println("Setup X3D for GlutamicAcids");
			}
			else if (bioMightComponentRef.equals(Constants.GlutamicAcid))
			{
				GlutamicAcid cysteine = (GlutamicAcid) bioMightInstance;
				bioMightComponent.setImage(cysteine.getImage());
				bioMightComponent.setBioMightMethods(cysteine.getMethods());
				bioMightComponent.setBioMightProperties(cysteine.getProperties());
				bioMightComponent.setBioMightCollection(true);
				
				// Assooiate the component and ID.
				bioMightKey = new BioMightKey();
				bioMightKey.setComponentName(bioMightComponentName);
				bioMightKey.setComponentID(cysteine.getComponentID());			
				System.out.println("Storing GlutamicAcidKey: " + bioMightComponentRef+ "   ID: " + cysteine.getComponentID());
				bioMightKeys.setKey(bioMightKey);
						
				// On the post of data, we map the web data back
				// into the methodView object.  
				//if (executeMethods) { 
				//	System.out.println("Executing GlutamicAcid Methods!");
				//	cysteine.executeMethods(methodParams);
				//}
				
				//System.out.println("Getting X3D for GlutamicAcid");
				bioMightComponent.setX3D(cysteine.getX3D(snipet));
				System.out.println("Setup X3D for GlutamicAcid");
			}
			else if (bioMightComponentRef.equals(Constants.Glutamines))
			{
				Glutamines glutamines = (Glutamines) bioMightInstance;
				bioMightComponent.setImage(glutamines.getImage());
				bioMightComponent.setBioMightMethods(glutamines.getMethods());
				bioMightComponent.setBioMightProperties(glutamines.getProperties());
				bioMightComponent.setBioMightCollection(true);
				
				// Assooiate the component and ID.
				bioMightKey = new BioMightKey();
				bioMightKey.setComponentName(bioMightComponentName);
				bioMightKey.setComponentID(glutamines.getComponentID());			
				System.out.println("Storing GlutaminesKey: " + bioMightComponentRef+ "   ID: " + glutamines.getComponentID());
				bioMightKeys.setKey(bioMightKey);
						
				// On the post of data, we map the web data back
				// into the methodView object.  
				//if (executeMethods) { 
				//	System.out.println("Executing Glutamines Methods!");
				//	glutamines.executeMethods(methodParams);
				//}
				
				//System.out.println("Getting X3D for Glutamines");
				bioMightComponent.setX3D(glutamines.getX3D(snipet));
				System.out.println("Setup X3D for Glutamines");
			}
			else if (bioMightComponentRef.equals(Constants.Glutamine))
			{
				Glutamine glutamine = (Glutamine) bioMightInstance;
				bioMightComponent.setImage(glutamine.getImage());
				bioMightComponent.setBioMightMethods(glutamine.getMethods());
				bioMightComponent.setBioMightProperties(glutamine.getProperties());
				bioMightComponent.setBioMightCollection(true);
				
				// Assooiate the component and ID.
				bioMightKey = new BioMightKey();
				bioMightKey.setComponentName(bioMightComponentName);
				bioMightKey.setComponentID(glutamine.getComponentID());			
				System.out.println("Storing GlutamineKey: " + bioMightComponentRef+ "   ID: " + glutamine.getComponentID());
				bioMightKeys.setKey(bioMightKey);
						
				// On the post of data, we map the web data back
				// into the methodView object.  
				//if (executeMethods) { 
				//	System.out.println("Executing Glutamine Methods!");
				//	glutamine.executeMethods(methodParams);
				//}
				
				//System.out.println("Getting X3D for Glutamine");
				bioMightComponent.setX3D(glutamine.getX3D(snipet));
				System.out.println("Setup X3D for Glutamine");
			}
			else if (bioMightComponentRef.equals(Constants.Glycines))
			{
				Glycines glycines = (Glycines) bioMightInstance;
				bioMightComponent.setImage(glycines.getImage());
				bioMightComponent.setBioMightMethods(glycines.getMethods());
				bioMightComponent.setBioMightProperties(glycines.getProperties());
				bioMightComponent.setBioMightCollection(true);
				
				// Assooiate the component and ID.
				bioMightKey = new BioMightKey();
				bioMightKey.setComponentName(bioMightComponentName);
				bioMightKey.setComponentID(glycines.getComponentID());			
				System.out.println("Storing GlycinesKey: " + bioMightComponentRef+ "   ID: " + glycines.getComponentID());
				bioMightKeys.setKey(bioMightKey);
						
				// On the post of data, we map the web data back
				// into the methodView object.  
				//if (executeMethods) { 
				//	System.out.println("Executing Glycines Methods!");
				//	glycines.executeMethods(methodParams);
				//}
				
				//System.out.println("Getting X3D for Glycines");
				bioMightComponent.setX3D(glycines.getX3D(snipet));
				System.out.println("Setup X3D for Glycines");
			}
			else if (bioMightComponentRef.equals(Constants.Glycine))
			{
				Glycine glycine = (Glycine) bioMightInstance;
				bioMightComponent.setImage(glycine.getImage());
				bioMightComponent.setBioMightMethods(glycine.getMethods());
				bioMightComponent.setBioMightProperties(glycine.getProperties());
				bioMightComponent.setBioMightCollection(true);
				
				// Assooiate the component and ID.
				bioMightKey = new BioMightKey();
				bioMightKey.setComponentName(bioMightComponentName);
				bioMightKey.setComponentID(glycine.getComponentID());			
				System.out.println("Storing GlycineKey: " + bioMightComponentRef+ "   ID: " + glycine.getComponentID());
				bioMightKeys.setKey(bioMightKey);
						
				// On the post of data, we map the web data back
				// into the methodView object.  
				//if (executeMethods) { 
				//	System.out.println("Executing Glycine Methods!");
				//	glycine.executeMethods(methodParams);
				//}
				
				//System.out.println("Getting X3D for Glycine");
				bioMightComponent.setX3D(glycine.getX3D(snipet));
				System.out.println("Setup X3D for Glycine");
			}
			else if (bioMightComponentRef.equals(Constants.Histidines))
			{
				Histidines histidines = (Histidines) bioMightInstance;
				bioMightComponent.setImage(histidines.getImage());
				bioMightComponent.setBioMightMethods(histidines.getMethods());
				bioMightComponent.setBioMightProperties(histidines.getProperties());
				bioMightComponent.setBioMightCollection(true);
				
				// Assooiate the component and ID.
				bioMightKey = new BioMightKey();
				bioMightKey.setComponentName(bioMightComponentName);
				bioMightKey.setComponentID(histidines.getComponentID());			
				System.out.println("Storing HistidinesKey: " + bioMightComponentRef+ "   ID: " + histidines.getComponentID());
				bioMightKeys.setKey(bioMightKey);
						
				// On the post of data, we map the web data back
				// into the methodView object.  
				//if (executeMethods) { 
				//	System.out.println("Executing Histidines Methods!");
				//	histidines.executeMethods(methodParams);
				//}
				
				//System.out.println("Getting X3D for Histidines");
				bioMightComponent.setX3D(histidines.getX3D(snipet));
				System.out.println("Setup X3D for Histidines");
			}
			else if (bioMightComponentRef.equals(Constants.Histidine))
			{
				Histidine histidine = (Histidine) bioMightInstance;
				bioMightComponent.setImage(histidine.getImage());
				bioMightComponent.setBioMightMethods(histidine.getMethods());
				bioMightComponent.setBioMightProperties(histidine.getProperties());
				bioMightComponent.setBioMightCollection(true);
				
				// Assooiate the component and ID.
				bioMightKey = new BioMightKey();
				bioMightKey.setComponentName(bioMightComponentName);
				bioMightKey.setComponentID(histidine.getComponentID());			
				System.out.println("Storing HistidineKey: " + bioMightComponentRef+ "   ID: " + histidine.getComponentID());
				bioMightKeys.setKey(bioMightKey);
						
				// On the post of data, we map the web data back
				// into the methodView object.  
				//if (executeMethods) { 
				//	System.out.println("Executing Histidine Methods!");
				//	histidine.executeMethods(methodParams);
				//}
				
				//System.out.println("Getting X3D for Histidine");
				bioMightComponent.setX3D(histidine.getX3D(snipet));
				System.out.println("Setup X3D for Histidine");
			}
			else if (bioMightComponentRef.equals(Constants.IsoLeucines))
			{
				IsoLeucines isoLeucines = (IsoLeucines) bioMightInstance;
				bioMightComponent.setImage(isoLeucines.getImage());
				bioMightComponent.setBioMightMethods(isoLeucines.getMethods());
				bioMightComponent.setBioMightProperties(isoLeucines.getProperties());
				bioMightComponent.setBioMightCollection(true);
				
				// Assooiate the component and ID.
				bioMightKey = new BioMightKey();
				bioMightKey.setComponentName(bioMightComponentName);
				bioMightKey.setComponentID(isoLeucines.getComponentID());			
				System.out.println("Storing IsoLeucinesKey: " + bioMightComponentRef+ "   ID: " + isoLeucines.getComponentID());
				bioMightKeys.setKey(bioMightKey);
						
				// On the post of data, we map the web data back
				// into the methodView object.  
				//if (executeMethods) { 
				//	System.out.println("Executing IsoLeucines Methods!");
				//	isoLeucines.executeMethods(methodParams);
				//}
				
				//System.out.println("Getting X3D for IsoLeucines");
				bioMightComponent.setX3D(isoLeucines.getX3D(snipet));
				System.out.println("Setup X3D for IsoLeucines");
			}
			else if (bioMightComponentRef.equals(Constants.IsoLeucine))
			{
				IsoLeucine isoLeucine = (IsoLeucine) bioMightInstance;
				bioMightComponent.setImage(isoLeucine.getImage());
				bioMightComponent.setBioMightMethods(isoLeucine.getMethods());
				bioMightComponent.setBioMightProperties(isoLeucine.getProperties());
				bioMightComponent.setBioMightCollection(true);
				
				// Assooiate the component and ID.
				bioMightKey = new BioMightKey();
				bioMightKey.setComponentName(bioMightComponentName);
				bioMightKey.setComponentID(isoLeucine.getComponentID());			
				System.out.println("Storing IsoLeucineKey: " + bioMightComponentRef+ "   ID: " + isoLeucine.getComponentID());
				bioMightKeys.setKey(bioMightKey);
						
				// On the post of data, we map the web data back
				// into the methodView object.  
				//if (executeMethods) { 
				//	System.out.println("Executing IsoLeucine Methods!");
				//	isoLeucine.executeMethods(methodParams);
				//}
				
				//System.out.println("Getting X3D for IsoLeucine");
				bioMightComponent.setX3D(isoLeucine.getX3D(snipet));
				System.out.println("Setup X3D for IsoLeucine");
			}
			else if (bioMightComponentRef.equals(Constants.Leucines))
			{
				Leucines leucines = (Leucines) bioMightInstance;
				bioMightComponent.setImage(leucines.getImage());
				bioMightComponent.setBioMightMethods(leucines.getMethods());
				bioMightComponent.setBioMightProperties(leucines.getProperties());
				bioMightComponent.setBioMightCollection(true);
				
				// Assooiate the component and ID.
				bioMightKey = new BioMightKey();
				bioMightKey.setComponentName(bioMightComponentName);
				bioMightKey.setComponentID(leucines.getComponentID());			
				System.out.println("Storing LeucinesKey: " + bioMightComponentRef+ "   ID: " + leucines.getComponentID());
				bioMightKeys.setKey(bioMightKey);
						
				// On the post of data, we map the web data back
				// into the methodView object.  
				//if (executeMethods) { 
				//	System.out.println("Executing Leucines Methods!");
				//	leucines.executeMethods(methodParams);
				//}
				
				//System.out.println("Getting X3D for Leucines");
				bioMightComponent.setX3D(leucines.getX3D(snipet));
				System.out.println("Setup X3D for Leucines");
			}
			else if (bioMightComponentRef.equals(Constants.Leucine))
			{
				Leucine leucine = (Leucine) bioMightInstance;
				bioMightComponent.setImage(leucine.getImage());
				bioMightComponent.setBioMightMethods(leucine.getMethods());
				bioMightComponent.setBioMightProperties(leucine.getProperties());
				bioMightComponent.setBioMightCollection(true);
				
				// Assooiate the component and ID.
				bioMightKey = new BioMightKey();
				bioMightKey.setComponentName(bioMightComponentName);
				bioMightKey.setComponentID(leucine.getComponentID());			
				System.out.println("Storing LeucineKey: " + bioMightComponentRef+ "   ID: " + leucine.getComponentID());
				bioMightKeys.setKey(bioMightKey);
						
				// On the post of data, we map the web data back
				// into the methodView object.  
				//if (executeMethods) { 
				//	System.out.println("Executing Leucine Methods!");
				//	leucine.executeMethods(methodParams);
				//}
				
				//System.out.println("Getting X3D for Leucine");
				bioMightComponent.setX3D(leucine.getX3D(snipet));
				System.out.println("Setup X3D for Leucine");
			}		
			else if (bioMightComponentRef.equals(Constants.Lysines))
			{
				Lysines lysines = (Lysines) bioMightInstance;
				bioMightComponent.setImage(lysines.getImage());
				bioMightComponent.setBioMightMethods(lysines.getMethods());
				bioMightComponent.setBioMightProperties(lysines.getProperties());
				bioMightComponent.setBioMightCollection(true);
				
				// Assooiate the component and ID.
				bioMightKey = new BioMightKey();
				bioMightKey.setComponentName(bioMightComponentName);
				bioMightKey.setComponentID(lysines.getComponentID());			
				System.out.println("Storing LysinesKey: " + bioMightComponentRef+ "   ID: " + lysines.getComponentID());
				bioMightKeys.setKey(bioMightKey);
						
				// On the post of data, we map the web data back
				// into the methodView object.  
				//if (executeMethods) { 
				//	System.out.println("Executing Lysines Methods!");
				//	lysines.executeMethods(methodParams);
				//}
				
				//System.out.println("Getting X3D for Lysines");
				bioMightComponent.setX3D(lysines.getX3D(snipet));
				System.out.println("Setup X3D for Lysines");
			}
			else if (bioMightComponentRef.equals(Constants.Lysine))
			{
				Lysine lysine = (Lysine) bioMightInstance;
				bioMightComponent.setImage(lysine.getImage());
				bioMightComponent.setBioMightMethods(lysine.getMethods());
				bioMightComponent.setBioMightProperties(lysine.getProperties());
				bioMightComponent.setBioMightCollection(true);
				
				// Assooiate the component and ID.
				bioMightKey = new BioMightKey();
				bioMightKey.setComponentName(bioMightComponentName);
				bioMightKey.setComponentID(lysine.getComponentID());			
				System.out.println("Storing LysineKey: " + bioMightComponentRef+ "   ID: " + lysine.getComponentID());
				bioMightKeys.setKey(bioMightKey);
						
				// On the post of data, we map the web data back
				// into the methodView object.  
				//if (executeMethods) { 
				//	System.out.println("Executing Lysine Methods!");
				//	lysine.executeMethods(methodParams);
				//}
				
				//System.out.println("Getting X3D for Lysine");
				bioMightComponent.setX3D(lysine.getX3D(snipet));
				System.out.println("Setup X3D for Lysine");
			}		
			else if (bioMightComponentRef.equals(Constants.Methionines))
			{
				Methionines methionines = (Methionines) bioMightInstance;
				bioMightComponent.setImage(methionines.getImage());
				bioMightComponent.setBioMightMethods(methionines.getMethods());
				bioMightComponent.setBioMightProperties(methionines.getProperties());
				bioMightComponent.setBioMightCollection(true);
				
				// Assooiate the component and ID.
				bioMightKey = new BioMightKey();
				bioMightKey.setComponentName(bioMightComponentName);
				bioMightKey.setComponentID(methionines.getComponentID());			
				System.out.println("Storing MethioninesKey: " + bioMightComponentRef+ "   ID: " + methionines.getComponentID());
				bioMightKeys.setKey(bioMightKey);
						
				// On the post of data, we map the web data back
				// into the methodView object.  
				//if (executeMethods) { 
				//	System.out.println("Executing Methionines Methods!");
				//	methionines.executeMethods(methodParams);
				//}
				
				//System.out.println("Getting X3D for Methionines");
				bioMightComponent.setX3D(methionines.getX3D(snipet));
				System.out.println("Setup X3D for Methionines");
			}
			else if (bioMightComponentRef.equals(Constants.Methionine))
			{
				Methionine methionine = (Methionine) bioMightInstance;
				bioMightComponent.setImage(methionine.getImage());
				bioMightComponent.setBioMightMethods(methionine.getMethods());
				bioMightComponent.setBioMightProperties(methionine.getProperties());
				bioMightComponent.setBioMightCollection(true);
				
				// Assooiate the component and ID.
				bioMightKey = new BioMightKey();
				bioMightKey.setComponentName(bioMightComponentName);
				bioMightKey.setComponentID(methionine.getComponentID());			
				System.out.println("Storing MethionineKey: " + bioMightComponentRef+ "   ID: " + methionine.getComponentID());
				bioMightKeys.setKey(bioMightKey);
						
				// On the post of data, we map the web data back
				// into the methodView object.  
				//if (executeMethods) { 
				//	System.out.println("Executing Methionine Methods!");
				//	methionine.executeMethods(methodParams);
				//}
				
				//System.out.println("Getting X3D for Methionine");
				bioMightComponent.setX3D(methionine.getX3D(snipet));
				System.out.println("Setup X3D for Methionine");
			}
			

			else if (bioMightComponentRef.equals(Constants.Phenylalanines))
			{
				Phenylalanines phenylalanines = (Phenylalanines) bioMightInstance;
				bioMightComponent.setImage(phenylalanines.getImage());
				bioMightComponent.setBioMightMethods(phenylalanines.getMethods());
				bioMightComponent.setBioMightProperties(phenylalanines.getProperties());
				bioMightComponent.setBioMightCollection(true);
				
				// Assooiate the component and ID.
				bioMightKey = new BioMightKey();
				bioMightKey.setComponentName(bioMightComponentName);
				bioMightKey.setComponentID(phenylalanines.getComponentID());			
				System.out.println("Storing PhenylalaninesKey: " + bioMightComponentRef+ "   ID: " + phenylalanines.getComponentID());
				bioMightKeys.setKey(bioMightKey);
						
				// On the post of data, we map the web data back
				// into the methodView object.  
				//if (executeMethods) { 
				//	System.out.println("Executing Phenylalanines Methods!");
				//	phenylalanines.executeMethods(methodParams);
				//}
				
				//System.out.println("Getting X3D for Phenylalanines");
				bioMightComponent.setX3D(phenylalanines.getX3D(snipet));
				System.out.println("Setup X3D for Phenylalanines");
			}
			else if (bioMightComponentRef.equals(Constants.Phenylalanine))
			{
				Phenylalanine phenylalanine = (Phenylalanine) bioMightInstance;
				bioMightComponent.setImage(phenylalanine.getImage());
				bioMightComponent.setBioMightMethods(phenylalanine.getMethods());
				bioMightComponent.setBioMightProperties(phenylalanine.getProperties());
				bioMightComponent.setBioMightCollection(true);
				
				// Assooiate the component and ID.
				bioMightKey = new BioMightKey();
				bioMightKey.setComponentName(bioMightComponentName);
				bioMightKey.setComponentID(phenylalanine.getComponentID());			
				System.out.println("Storing PhenylalanineKey: " + bioMightComponentRef+ "   ID: " + phenylalanine.getComponentID());
				bioMightKeys.setKey(bioMightKey);
						
				// On the post of data, we map the web data back
				// into the methodView object.  
				//if (executeMethods) { 
				//	System.out.println("Executing Phenylalanine Methods!");
				//	phenylalanine.executeMethods(methodParams);
				//}
				
				//System.out.println("Getting X3D for Phenylalanine");
				bioMightComponent.setX3D(phenylalanine.getX3D(snipet));
				System.out.println("Setup X3D for Phenylalanine");
			}
			else if (bioMightComponentRef.equals(Constants.Prolines))
			{
				Prolines prolines = (Prolines) bioMightInstance;
				bioMightComponent.setImage(prolines.getImage());
				bioMightComponent.setBioMightMethods(prolines.getMethods());
				bioMightComponent.setBioMightProperties(prolines.getProperties());
				bioMightComponent.setBioMightCollection(true);
				
				// Assooiate the component and ID.
				bioMightKey = new BioMightKey();
				bioMightKey.setComponentName(bioMightComponentName);
				bioMightKey.setComponentID(prolines.getComponentID());			
				System.out.println("Storing ProlinesKey: " + bioMightComponentRef+ "   ID: " + prolines.getComponentID());
				bioMightKeys.setKey(bioMightKey);
						
				// On the post of data, we map the web data back
				// into the methodView object.  
				//if (executeMethods) { 
				//	System.out.println("Executing Prolines Methods!");
				//	prolines.executeMethods(methodParams);
				//}
				
				//System.out.println("Getting X3D for Prolines");
				bioMightComponent.setX3D(prolines.getX3D(snipet));
				System.out.println("Setup X3D for Prolines");
			}
			else if (bioMightComponentRef.equals(Constants.Proline))
			{
				Proline proline = (Proline) bioMightInstance;
				bioMightComponent.setImage(proline.getImage());
				bioMightComponent.setBioMightMethods(proline.getMethods());
				bioMightComponent.setBioMightProperties(proline.getProperties());
				bioMightComponent.setBioMightCollection(true);
				
				// Assooiate the component and ID.
				bioMightKey = new BioMightKey();
				bioMightKey.setComponentName(bioMightComponentName);
				bioMightKey.setComponentID(proline.getComponentID());			
				System.out.println("Storing ProlineKey: " + bioMightComponentRef+ "   ID: " + proline.getComponentID());
				bioMightKeys.setKey(bioMightKey);
						
				// On the post of data, we map the web data back
				// into the methodView object.  
				//if (executeMethods) { 
				//	System.out.println("Executing Proline Methods!");
				//	proline.executeMethods(methodParams);
				//}
				
				//System.out.println("Getting X3D for Proline");
				bioMightComponent.setX3D(proline.getX3D(snipet));
				System.out.println("Setup X3D for Proline");
			}
			else if (bioMightComponentRef.equals(Constants.Serines))
			{
				Serines serines = (Serines) bioMightInstance;
				bioMightComponent.setImage(serines.getImage());
				bioMightComponent.setBioMightMethods(serines.getMethods());
				bioMightComponent.setBioMightProperties(serines.getProperties());
				bioMightComponent.setBioMightCollection(true);
				
				// Assooiate the component and ID.
				bioMightKey = new BioMightKey();
				bioMightKey.setComponentName(bioMightComponentName);
				bioMightKey.setComponentID(serines.getComponentID());			
				System.out.println("Storing SerinesKey: " + bioMightComponentRef+ "   ID: " + serines.getComponentID());
				bioMightKeys.setKey(bioMightKey);
						
				// On the post of data, we map the web data back
				// into the methodView object.  
				//if (executeMethods) { 
				//	System.out.println("Executing Serines Methods!");
				//	serines.executeMethods(methodParams);
				//}
				
				//System.out.println("Getting X3D for Serines");
				bioMightComponent.setX3D(serines.getX3D(snipet));
				System.out.println("Setup X3D for Serines");
			}
			else if (bioMightComponentRef.equals(Constants.Serine))
			{
				Serine serine = (Serine) bioMightInstance;
				bioMightComponent.setImage(serine.getImage());
				bioMightComponent.setBioMightMethods(serine.getMethods());
				bioMightComponent.setBioMightProperties(serine.getProperties());
				bioMightComponent.setBioMightCollection(true);
				
				// Assooiate the component and ID.
				bioMightKey = new BioMightKey();
				bioMightKey.setComponentName(bioMightComponentName);
				bioMightKey.setComponentID(serine.getComponentID());			
				System.out.println("Storing SerineKey: " + bioMightComponentRef+ "   ID: " + serine.getComponentID());
				bioMightKeys.setKey(bioMightKey);
						
				// On the post of data, we map the web data back
				// into the methodView object.  
				//if (executeMethods) { 
				//	System.out.println("Executing Serine Methods!");
				//	serine.executeMethods(methodParams);
				//}
				
				//System.out.println("Getting X3D for Serine");
				bioMightComponent.setX3D(serine.getX3D(snipet));
				System.out.println("Setup X3D for Serine");
			}
						
			else if (bioMightComponentRef.equals(Constants.Threonines))
			{
				Threonines threonines = (Threonines) bioMightInstance;
				bioMightComponent.setImage(threonines.getImage());
				bioMightComponent.setBioMightMethods(threonines.getMethods());
				bioMightComponent.setBioMightProperties(threonines.getProperties());
				bioMightComponent.setBioMightCollection(true);
				
				// Assooiate the component and ID.
				bioMightKey = new BioMightKey();
				bioMightKey.setComponentName(bioMightComponentName);
				bioMightKey.setComponentID(threonines.getComponentID());			
				System.out.println("Storing ThreoninesKey: " + bioMightComponentRef+ "   ID: " + threonines.getComponentID());
				bioMightKeys.setKey(bioMightKey);
						
				// On the post of data, we map the web data back
				// into the methodView object.  
				//if (executeMethods) { 
				//	System.out.println("Executing Threonines Methods!");
				//	threonines.executeMethods(methodParams);
				//}
				
				//System.out.println("Getting X3D for Threonines");
				bioMightComponent.setX3D(threonines.getX3D(snipet));
				System.out.println("Setup X3D for Threonines");
			}
			else if (bioMightComponentRef.equals(Constants.Threonine))
			{
				Threonine threonine = (Threonine) bioMightInstance;
				bioMightComponent.setImage(threonine.getImage());
				bioMightComponent.setBioMightMethods(threonine.getMethods());
				bioMightComponent.setBioMightProperties(threonine.getProperties());
				bioMightComponent.setBioMightCollection(true);
				
				// Assooiate the component and ID.
				bioMightKey = new BioMightKey();
				bioMightKey.setComponentName(bioMightComponentName);
				bioMightKey.setComponentID(threonine.getComponentID());			
				System.out.println("Storing ThreonineKey: " + bioMightComponentRef+ "   ID: " + threonine.getComponentID());
				bioMightKeys.setKey(bioMightKey);
						
				// On the post of data, we map the web data back
				// into the methodView object.  
				//if (executeMethods) { 
				//	System.out.println("Executing Threonine Methods!");
				//	threonine.executeMethods(methodParams);
				//}
				
				//System.out.println("Getting X3D for Threonine");
				bioMightComponent.setX3D(threonine.getX3D(snipet));
				System.out.println("Setup X3D for Threonine");
			}
			else if (bioMightComponentRef.equals(Constants.Tryptophans))
			{
				Tryptophans tryptophans = (Tryptophans) bioMightInstance;
				bioMightComponent.setImage(tryptophans.getImage());
				bioMightComponent.setBioMightMethods(tryptophans.getMethods());
				bioMightComponent.setBioMightProperties(tryptophans.getProperties());
				bioMightComponent.setBioMightCollection(true);
				
				// Assooiate the component and ID.
				bioMightKey = new BioMightKey();
				bioMightKey.setComponentName(bioMightComponentName);
				bioMightKey.setComponentID(tryptophans.getComponentID());			
				System.out.println("Storing TryptophansKey: " + bioMightComponentRef+ "   ID: " + tryptophans.getComponentID());
				bioMightKeys.setKey(bioMightKey);
						
				// On the post of data, we map the web data back
				// into the methodView object.  
				//if (executeMethods) { 
				//	System.out.println("Executing Tryptophans Methods!");
				//	tryptophans.executeMethods(methodParams);
				//}
				
				//System.out.println("Getting X3D for Tryptophans");
				bioMightComponent.setX3D(tryptophans.getX3D(snipet));
				System.out.println("Setup X3D for Tryptophans");
			}
			else if (bioMightComponentRef.equals(Constants.Tryptophan))
			{
				Tryptophan tryptophan = (Tryptophan) bioMightInstance;
				bioMightComponent.setImage(tryptophan.getImage());
				bioMightComponent.setBioMightMethods(tryptophan.getMethods());
				bioMightComponent.setBioMightProperties(tryptophan.getProperties());
				bioMightComponent.setBioMightCollection(true);
				
				// Assooiate the component and ID.
				bioMightKey = new BioMightKey();
				bioMightKey.setComponentName(bioMightComponentName);
				bioMightKey.setComponentID(tryptophan.getComponentID());			
				System.out.println("Storing TryptophanKey: " + bioMightComponentRef+ "   ID: " + tryptophan.getComponentID());
				bioMightKeys.setKey(bioMightKey);
						
				// On the post of data, we map the web data back
				// into the methodView object.  
				//if (executeMethods) { 
				//	System.out.println("Executing Tryptophan Methods!");
				//	tryptophan.executeMethods(methodParams);
				//}
				
				//System.out.println("Getting X3D for Tryptophan");
				bioMightComponent.setX3D(tryptophan.getX3D(snipet));
				System.out.println("Setup X3D for Tryptophan");
			}
			else if (bioMightComponentRef.equals(Constants.Tyrosines))
			{
				Tyrosines tyrosines = (Tyrosines) bioMightInstance;
				bioMightComponent.setImage(tyrosines.getImage());
				bioMightComponent.setBioMightMethods(tyrosines.getMethods());
				bioMightComponent.setBioMightProperties(tyrosines.getProperties());
				bioMightComponent.setBioMightCollection(true);
				
				// Assooiate the component and ID.
				bioMightKey = new BioMightKey();
				bioMightKey.setComponentName(bioMightComponentName);
				bioMightKey.setComponentID(tyrosines.getComponentID());			
				System.out.println("Storing TyrosinesKey: " + bioMightComponentRef+ "   ID: " + tyrosines.getComponentID());
				bioMightKeys.setKey(bioMightKey);
						
				// On the post of data, we map the web data back
				// into the methodView object.  
				//if (executeMethods) { 
				//	System.out.println("Executing Tyrosines Methods!");
				//	tyrosines.executeMethods(methodParams);
				//}
				
				//System.out.println("Getting X3D for Tyrosines");
				bioMightComponent.setX3D(tyrosines.getX3D(snipet));
				System.out.println("Setup X3D for Tyrosines");
			}
			else if (bioMightComponentRef.equals(Constants.Tyrosine))
			{
				Tyrosine tyrosine = (Tyrosine) bioMightInstance;
				bioMightComponent.setImage(tyrosine.getImage());
				bioMightComponent.setBioMightMethods(tyrosine.getMethods());
				bioMightComponent.setBioMightProperties(tyrosine.getProperties());
				bioMightComponent.setBioMightCollection(true);
				
				// Assooiate the component and ID.
				bioMightKey = new BioMightKey();
				bioMightKey.setComponentName(bioMightComponentName);
				bioMightKey.setComponentID(tyrosine.getComponentID());			
				System.out.println("Storing TyrosineKey: " + bioMightComponentRef+ "   ID: " + tyrosine.getComponentID());
				bioMightKeys.setKey(bioMightKey);
						
				// On the post of data, we map the web data back
				// into the methodView object.  
				//if (executeMethods) { 
				//	System.out.println("Executing Tyrosine Methods!");
				//	tyrosine.executeMethods(methodParams);
				//}
				
				//System.out.println("Getting X3D for Tyrosine");
				bioMightComponent.setX3D(tyrosine.getX3D(snipet));
				System.out.println("Setup X3D for Tyrosine");
			}
			else if (bioMightComponentRef.equals(Constants.Valines))
			{
				Valines valines = (Valines) bioMightInstance;
				bioMightComponent.setImage(valines.getImage());
				bioMightComponent.setBioMightMethods(valines.getMethods());
				bioMightComponent.setBioMightProperties(valines.getProperties());
				bioMightComponent.setBioMightCollection(true);
				
				// Assooiate the component and ID.
				bioMightKey = new BioMightKey();
				bioMightKey.setComponentName(bioMightComponentName);
				bioMightKey.setComponentID(valines.getComponentID());			
				System.out.println("Storing ValinesKey: " + bioMightComponentRef+ "   ID: " + valines.getComponentID());
				bioMightKeys.setKey(bioMightKey);
						
				// On the post of data, we map the web data back
				// into the methodView object.  
				//if (executeMethods) { 
				//	System.out.println("Executing Valines Methods!");
				//	valines.executeMethods(methodParams);
				//}
				
				//System.out.println("Getting X3D for Valines");
				bioMightComponent.setX3D(valines.getX3D(snipet));
				System.out.println("Setup X3D for Valines");
			}
			else if (bioMightComponentRef.equals(Constants.Valine))
			{
				Valine valine = (Valine) bioMightInstance;
				bioMightComponent.setImage(valine.getImage());
				bioMightComponent.setBioMightMethods(valine.getMethods());
				bioMightComponent.setBioMightProperties(valine.getProperties());
				bioMightComponent.setBioMightCollection(true);
				
				// Assooiate the component and ID.
				bioMightKey = new BioMightKey();
				bioMightKey.setComponentName(bioMightComponentName);
				bioMightKey.setComponentID(valine.getComponentID());			
				System.out.println("Storing ValineKey: " + bioMightComponentRef+ "   ID: " + valine.getComponentID());
				bioMightKeys.setKey(bioMightKey);
						
				// On the post of data, we map the web data back
				// into the methodView object.  
				//if (executeMethods) { 
				//	System.out.println("Executing Valine Methods!");
				//	valine.executeMethods(methodParams);
				//}
				
				//System.out.println("Getting X3D for Valine");
				bioMightComponent.setX3D(valine.getX3D(snipet));
				System.out.println("Setup X3D for Valine");
			}
			
			/**************************************************************************
			*
			* ANTIBODIES - IMMUNE FACTORS
			* 
			***************************************************************************/
			
			else if (bioMightComponentRef.equals(Constants.Antibodies))
			{
				Antibodies antibodies = (Antibodies) bioMightInstance;
				bioMightComponent.setImage(antibodies.getImage());
			}			
			else if (bioMightComponentRef.equals(Constants.Antibody))
			{
				Antibody antibody = (Antibody) bioMightInstance;
				bioMightComponent.setImage(antibody.getImage());
			}	
			else if (bioMightComponentRef.equals(Constants.AntibodyHeavyChain))
			{
				AntibodyHeavyChain antibodyHeavyChain = (AntibodyHeavyChain) bioMightInstance;
				bioMightComponent.setImage(antibodyHeavyChain.getImage());
				bioMightComponent.setWidth(antibodyHeavyChain.getImageWidth());
				bioMightComponent.setHeight(antibodyHeavyChain.getImageHeight());	
				bioMightComponent.setBioMightProperties(antibodyHeavyChain.getProperties());
				bioMightComponent.setBioMightMethods(antibodyHeavyChain.getMethods());
				
			}
			
		
			/**************************************************************************
			*
			* DNA & RNA BASES
			* 
			***************************************************************************/
			else if (bioMightComponentRef.equals(Constants.BioAssemblies))
			{
				BioAssemblies bioAssemblies = (BioAssemblies) bioMightInstance;
				bioMightComponent.setImage(bioAssemblies.getImage());
				bioMightComponent.setBioMightProperties(bioAssemblies.getProperties());
				bioMightComponent.setBioMightMethods(bioAssemblies.getMethods());
				bioMightComponent.setBioMightCollection(false);
				
				// Based on the parent ID that was passed in, the component will be
				// retrieved from the BioMight components database.
				System.out.println("Storing Key for BioAssemblies: "  + bioMightComponentRef+  "     ID: " +bioAssemblies.getComponentID());				
				bioMightKey.setComponentName(bioMightComponentName);
				bioMightKey.setComponentID(bioAssemblies.getComponentID());
				bioMightKeys.setKey(bioMightKey);
				
				// On the post of data, we map the web data back
				// into the methodView object.  
				//if (executeMethods) {
				//	System.out.println("Executing BioAssemblies Methods!");
				//	bioAssemblies////(methodParams);
				//	BioAssemblies.redraw(0);
				//}
				bioMightComponent.setX3D(bioAssemblies.getX3D(snipet));												
			}
			else if (bioMightComponentRef.equals(Constants.DNAs))
			{
				DNAs dnas = (DNAs) bioMightInstance;
				bioMightComponent.setImage(dnas.getImage());
				bioMightComponent.setBioMightMethods(dnas.getMethods());
				bioMightComponent.setBioMightProperties(dnas.getProperties());
				bioMightComponent.setBioMightCollection(true);
				
				// Assooiate the component and ID.
				bioMightKey = new BioMightKey();
				bioMightKey.setComponentName(bioMightComponentName);
				bioMightKey.setComponentID(dnas.getComponentID());			
				System.out.println("Storing DNAsKey: " + bioMightComponentRef+ "   ID: " + dnas.getComponentID());
				bioMightKeys.setKey(bioMightKey);
						
				// On the post of data, we map the web data back
				// into the methodView object.  
				//if (executeMethods) { 
				//	System.out.println("Executing DNAa Methods!");
				//	bioSymbols.executeMethods(methodParams);
				//}
				
				//System.out.println("Getting X3D for Tissues");
				bioMightComponent.setX3D(dnas.getX3D(snipet));
				System.out.println("Setup X3D for DNA!!!");
			}
			else if (bioMightComponentRef.equals(Constants.DNA))
			{
				DNA dna = (DNA) bioMightInstance;
				bioMightComponent.setImage(dna.getImage());
				bioMightComponent.setBioMightMethods(dna.getMethods());
				bioMightComponent.setBioMightProperties(dna.getProperties());
				bioMightComponent.setBioMightCollection(true);
				
				// Assooiate the component and ID.
				bioMightKey = new BioMightKey();
				bioMightKey.setComponentName(bioMightComponentName);
				bioMightKey.setComponentID(dna.getComponentID());			
				System.out.println("Storing DNAKey: " + bioMightComponentRef+ "   ID: " + dna.getComponentID());
				bioMightKeys.setKey(bioMightKey);
						
				// On the post of data, we map the web data back
				// into the methodView object.  
				//if (executeMethods) { 
				//	System.out.println("Executing Body Methods!");
				//	bioSymbols.executeMethods(methodParams);
				//}
				
				//System.out.println("Getting X3D for Tissues");
				bioMightComponent.setX3D(dna.getX3D(snipet));
				System.out.println("Setup X3D for DNA!!!");
			}
			else if (bioMightComponentRef.equals(Constants.RNAs))
			{
				RNAs rnas = (RNAs) bioMightInstance;
				bioMightComponent.setImage(rnas.getImage());
				bioMightComponent.setBioMightMethods(rnas.getMethods());
				bioMightComponent.setBioMightProperties(rnas.getProperties());
				bioMightComponent.setBioMightCollection(true);
				
				// Assooiate the component and ID.
				bioMightKey = new BioMightKey();
				bioMightKey.setComponentName(bioMightComponentName);
				bioMightKey.setComponentID(rnas.getComponentID());			
				System.out.println("Storing RNAsKey: " + bioMightComponentRef+ "   ID: " + rnas.getComponentID());
				bioMightKeys.setKey(bioMightKey);
						
				// On the post of data, we map the web data back
				// into the methodView object.  
				//if (executeMethods) { 
				//	System.out.println("Executing RNAa Methods!");
				//	bioSymbols.executeMethods(methodParams);
				//}
				
				//System.out.println("Getting X3D for Tissues");
				bioMightComponent.setX3D(rnas.getX3D(snipet));
				System.out.println("Setup X3D for RNA!!!");
			}
			else if (bioMightComponentRef.equals(Constants.RNA))
			{
				RNA rna = (RNA) bioMightInstance;
				bioMightComponent.setImage(rna.getImage());
				bioMightComponent.setBioMightMethods(rna.getMethods());
				bioMightComponent.setBioMightProperties(rna.getProperties());
				bioMightComponent.setBioMightCollection(false);
				
				// Assooiate the component and ID.
				bioMightKey = new BioMightKey();
				bioMightKey.setComponentName(bioMightComponentName);
				bioMightKey.setComponentID(rna.getComponentID());			
				System.out.println("Storing RNAKey: " + bioMightComponentRef+ "   ID: " + rna.getComponentID());
				bioMightKeys.setKey(bioMightKey);
						
				// On the post of data, we map the web data back
				// into the methodView object.  
				//if (executeMethods) { 
				//	System.out.println("Executing Body Methods!");
				//	bioSymbols.executeMethods(methodParams);
				//}
				
				//System.out.println("Getting X3D for Tissues");
				bioMightComponent.setX3D(rna.getX3D(snipet));
				System.out.println("Setup X3D for RNA!!!");
			}
			else if (bioMightComponentRef.equals(Constants.Nucleotides))
			{
				Nucleotides nucleotides = (Nucleotides) bioMightInstance;
				bioMightComponent.setImage(nucleotides.getImage());
				bioMightComponent.setBioMightMethods(nucleotides.getMethods());
				bioMightComponent.setBioMightProperties(nucleotides.getProperties());
				bioMightComponent.setBioMightCollection(true);
				
				// Assooiate the component and ID.
				bioMightKey = new BioMightKey();
				bioMightKey.setComponentName(bioMightComponentName);
				bioMightKey.setComponentID(nucleotides.getComponentID());			
				System.out.println("Storing NucleotidesKey: " + bioMightComponentRef+ "   ID: " + nucleotides.getComponentID());
				bioMightKeys.setKey(bioMightKey);
						
				// On the post of data, we map the web data back
				// into the methodView object.  
				//if (executeMethods) { 
				//	System.out.println("Executing Body Methods!");
				//	bioSymbols.executeMethods(methodParams);
				//}
				
				//System.out.println("Getting X3D for Tissues");
				bioMightComponent.setX3D(nucleotides.getX3D(snipet));
				System.out.println("Setup X3D for Nucleotides");
			}
			else if (bioMightComponentRef.equals(Constants.Nucleotide))
			{
				Nucleotide nucleotide = (Nucleotide) bioMightInstance;
				bioMightComponent.setImage(nucleotide.getImage());
				bioMightComponent.setBioMightMethods(nucleotide.getMethods());
				bioMightComponent.setBioMightProperties(nucleotide.getProperties());
				bioMightComponent.setBioMightCollection(true);
				
				// Assooiate the component and ID.
				bioMightKey = new BioMightKey();
				bioMightKey.setComponentName(bioMightComponentName);
				bioMightKey.setComponentID(nucleotide.getComponentID());			
				System.out.println("Storing NucleotideKey: " + bioMightComponentRef+ "   ID: " + nucleotide.getComponentID());
				bioMightKeys.setKey(bioMightKey);
						
				// On the post of data, we map the web data back
				// into the methodView object.  
				//if (executeMethods) { 
				//	System.out.println("Executing Body Methods!");
				//	bioSymbols.executeMethods(methodParams);
				//}
				
				//System.out.println("Getting X3D for Tissues");
				bioMightComponent.setX3D(nucleotide.getX3D(snipet));
				System.out.println("Setup X3D for Nucleotide");
			}
			else if (bioMightComponentRef.equals(Constants.Nucleobase))
			{
				Nucleobase nucleobase = (Nucleobase) bioMightInstance;
				bioMightComponent.setImage(nucleobase.getImage());
				bioMightComponent.setBioMightMethods(nucleobase.getMethods());
				bioMightComponent.setBioMightProperties(nucleobase.getProperties());
				bioMightComponent.setBioMightCollection(true);
				
				// Assooiate the component and ID.
				bioMightKey = new BioMightKey();
				bioMightKey.setComponentName(bioMightComponentName);
				bioMightKey.setComponentID(nucleobase.getComponentID());			
				System.out.println("Storing NucleobaseKey: " + bioMightComponentRef+ "   ID: " + nucleobase.getComponentID());
				bioMightKeys.setKey(bioMightKey);
						
				// On the post of data, we map the web data back
				// into the methodView object.  
				//if (executeMethods) { 
				//	System.out.println("Executing Body Methods!");
				//	bioSymbols.executeMethods(methodParams);
				//}
				
				//System.out.println("Getting X3D for Tissues");
				bioMightComponent.setX3D(nucleobase.getX3D(snipet));
				System.out.println("Setup X3D for Nucleobase");
			}
			else if (bioMightComponentRef.equals(Constants.DNABuilder))
			{
				DNAs dnas = (DNAs) bioMightInstance;
				bioMightComponent.setImage(dnas.getImage());
			}
			else if (bioMightComponentRef.equals(Constants.Adenine))
			{
				Adenine adenine = (Adenine) bioMightInstance;
				bioMightComponent.setImage(adenine.getImage());
				bioMightComponent.setBioMightMethods(adenine.getMethods());
				bioMightComponent.setBioMightProperties(adenine.getProperties());
				bioMightComponent.setBioMightCollection(true);
				
				// Assooiate the component and ID.
				bioMightKey = new BioMightKey();
				bioMightKey.setComponentName(bioMightComponentName);
				bioMightKey.setComponentID(adenine.getComponentID());			
				System.out.println("Storing AdenineKey: " + bioMightComponentRef+ "   ID: " + adenine.getComponentID());
				bioMightKeys.setKey(bioMightKey);
						
				// On the post of data, we map the web data back
				// into the methodView object.  
				//if (executeMethods) { 
				//	System.out.println("Executing Adenine Methods!");
				//	adenine.executeMethods(methodParams);
				//}
				
				bioMightComponent.setX3D(adenine.getX3D(snipet));
				System.out.println("Setup X3D for Adenine");	
			}
			else if (bioMightComponentRef.equals(Constants.Cytosine))
			{
				Cytosine cytosine = (Cytosine) bioMightInstance;
				bioMightComponent.setImage(cytosine.getImage());
				bioMightComponent.setBioMightMethods(cytosine.getMethods());
				bioMightComponent.setBioMightProperties(cytosine.getProperties());
				bioMightComponent.setBioMightCollection(true);
				
				// Assooiate the component and ID.
				bioMightKey = new BioMightKey();
				bioMightKey.setComponentName(bioMightComponentName);
				bioMightKey.setComponentID(cytosine.getComponentID());			
				System.out.println("Storing CytosineKey: " + bioMightComponentRef+ "   ID: " + cytosine.getComponentID());
				bioMightKeys.setKey(bioMightKey);
						
				// On the post of data, we map the web data back
				// into the methodView object.  
				//if (executeMethods) { 
				//	System.out.println("Executing Cytosine Methods!");
				//	cytosine.executeMethods(methodParams);
				//}
				
				bioMightComponent.setX3D(cytosine.getX3D(snipet));
				System.out.println("Setup X3D for Cytosine");
			}	
			else if (bioMightComponentRef.equals(Constants.Guanine))
			{
				Guanine guanine = (Guanine) bioMightInstance;
				bioMightComponent.setImage(guanine.getImage());
				bioMightComponent.setBioMightMethods(guanine.getMethods());
				bioMightComponent.setBioMightProperties(guanine.getProperties());
				bioMightComponent.setBioMightCollection(true);
				
				// Assooiate the component and ID.
				bioMightKey = new BioMightKey();
				bioMightKey.setComponentName(bioMightComponentName);
				bioMightKey.setComponentID(guanine.getComponentID());			
				System.out.println("Storing GuanineKey: " + bioMightComponentRef+ "   ID: " + guanine.getComponentID());
				bioMightKeys.setKey(bioMightKey);
						
				// On the post of data, we map the web data back
				// into the methodView object.  
				//if (executeMethods) { 
				//	System.out.println("Executing Guanine Methods!");
				//	guanine.executeMethods(methodParams);
				//}
				
				bioMightComponent.setX3D(guanine.getX3D(snipet));
				System.out.println("Setup X3D for Guanine");
			}	
			else if (bioMightComponentRef.equals(Constants.Thymine))
			{
				Thymine thymine = (Thymine) bioMightInstance;
				bioMightComponent.setImage(thymine.getImage());
				bioMightComponent.setBioMightMethods(thymine.getMethods());
				bioMightComponent.setBioMightProperties(thymine.getProperties());
				bioMightComponent.setBioMightCollection(true);
				
				// Assooiate the component and ID.
				bioMightKey = new BioMightKey();
				bioMightKey.setComponentName(bioMightComponentName);
				bioMightKey.setComponentID(thymine.getComponentID());			
				System.out.println("Storing ThymineKey: " + bioMightComponentRef+ "   ID: " + thymine.getComponentID());
				bioMightKeys.setKey(bioMightKey);
						
				// On the post of data, we map the web data back
				// into the methodView object.  
				//if (executeMethods) { 
				//	System.out.println("Executing Thymine Methods!");
				//	thymine.executeMethods(methodParams);
				//}
				
				bioMightComponent.setX3D(thymine.getX3D(snipet));
				System.out.println("Setup X3D for Thymine");
			}				
			else if (bioMightComponentRef.equals(Constants.Uracil))
			{
				Uracil uracil = (Uracil) bioMightInstance;
				bioMightComponent.setImage(uracil.getImage());
			}
			else if (bioMightComponentRef.equals(Constants.Ribosen))
			{
				Ribosen ribosen = (Ribosen) bioMightInstance;
				bioMightComponent.setImage(ribosen.getImage());
				bioMightComponent.setBioMightMethods(ribosen.getMethods());
				bioMightComponent.setBioMightProperties(ribosen.getProperties());
				bioMightComponent.setBioMightCollection(true);
				
				// Assooiate the component and ID.
				bioMightKey = new BioMightKey();
				bioMightKey.setComponentName(bioMightComponentName);
				bioMightKey.setComponentID(ribosen.getComponentID());			
				System.out.println("Storing RibosenKey: " + bioMightComponentRef+ "   ID: " + ribosen.getComponentID());
				bioMightKeys.setKey(bioMightKey);
						
				// On the post of data, we map the web data back
				// into the methodView object.  
				//if (executeMethods) { 
				//	System.out.println("Executing Ribosen Methods!");
				//	ribose.executeMethods(methodParams);
				//}
				
				bioMightComponent.setX3D(ribosen.getX3D(snipet));
				System.out.println("Setup X3D for Ribosen");
			}	
			else if (bioMightComponentRef.equals(Constants.Ribose))
			{
				Ribose ribose = (Ribose) bioMightInstance;
				bioMightComponent.setImage(ribose.getImage());
				bioMightComponent.setBioMightMethods(ribose.getMethods());
				bioMightComponent.setBioMightProperties(ribose.getProperties());
				bioMightComponent.setBioMightCollection(true);
				
				// Assooiate the component and ID.
				bioMightKey = new BioMightKey();
				bioMightKey.setComponentName(bioMightComponentName);
				bioMightKey.setComponentID(ribose.getComponentID());			
				System.out.println("Storing RiboseKey: " + bioMightComponentRef+ "   ID: " + ribose.getComponentID());
				bioMightKeys.setKey(bioMightKey);
						
				// On the post of data, we map the web data back
				// into the methodView object.  
				//if (executeMethods) { 
				//	System.out.println("Executing Ribose Methods!");
				//	ribose.executeMethods(methodParams);
				//}
				
				bioMightComponent.setX3D(ribose.getX3D(snipet));
				System.out.println("Setup X3D for Ribose");
			}	
			else if (bioMightComponentRef.equals(Constants.DeOxyRibose))
			{
				DeOxyRibose deOxyRibose = (DeOxyRibose) bioMightInstance;
				bioMightComponent.setImage(deOxyRibose.getImage());
				bioMightComponent.setBioMightMethods(deOxyRibose.getMethods());
				bioMightComponent.setBioMightProperties(deOxyRibose.getProperties());
				bioMightComponent.setBioMightCollection(true);
				
				// Assooiate the component and ID.
				bioMightKey = new BioMightKey();
				bioMightKey.setComponentName(bioMightComponentName);
				bioMightKey.setComponentID(deOxyRibose.getComponentID());			
				System.out.println("Storing DeOxyRiboseKey: " + bioMightComponentRef+ "   ID: " + deOxyRibose.getComponentID());
				bioMightKeys.setKey(bioMightKey);
						
				// On the post of data, we map the web data back
				// into the methodView object.  
				//if (executeMethods) { 
				//	System.out.println("Executing deOxyRibose Methods!");
				//	deOxyRibose.executeMethods(methodParams);
				//}
				
				bioMightComponent.setX3D(deOxyRibose.getX3D(snipet));
				System.out.println("Setup X3D for DeOxyRibose");
			}
			else
			{
				System.out.println("BioMightViewChemistry Component NOT MATCHED: " + bioMightComponentRef + "  " +  bioMightComponentName);
			}
	
		
		return bioMightComponent;
		}
}
