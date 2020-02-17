package biomight;

import java.io.Serializable;

/*
 * Created on Jun 5, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */

/**************************************************************************
 * @author SurferJim
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 * 
 **************************************************************************/

public class Constants implements Serializable {
	
	public final static String BIO_INT = "int";
	public final static String BIO_DOUBLE = "double";
	public final static String BIO_FLOAT = "float";
	public final static String BIO_TEXT = "text";
	public final static String BIO_DROPDOWN = "DropDown";
	public final static String BIO_CHECKBOX = "CheckBox";
	public final static String NOT_ACTIVATED = "--Not Activated-----------------";
	
	public final static int TRIANGLE 	= 3;
	public final static int QUADRANGLE 	= 4;
	public final static int PENTAGON 	= 5;
	public final static int HEXAGON 	= 6;
	public final static int HEPTAGON 	= 7;
	public final static int OCTAGON 	= 8;	
	public final static int ENNEAGON 	= 9;	
	public final static int DECAGON 	= 10;	
	
	public final static int BIO_SINGLE   	= 0; // Currently looking at root element
	public final static int BIO_PARENT  	= 1; // Currently looking at STANDARD
	public final static int BIO_CHILD 		= 2; // Looking at LEAF
	
	public static final int ROTATE     		= 1;
	public static final int TRANSLATE  		= 2;
	public static final int SCALE	  	   	= 3;
	public static final int ROTATEY    		= 4;
	public static final int ROTATEYMOVE    	= 5;
	public static final int ROTATEX    		= 6;
	public static final int ROTATEXMOVE    	= 7;
	public static final int ROTATEZ    		= 8;
	public static final int ROTATEZMOVE    	= 9;
	public static final int ROTATEOCTO  	= 10;
	
	public static final int ROTATEMOVEOCTO  = 11;
	public static final int ROTATEM    		= 12;
	public static final int ROTATETOP  		= 13;
	public static final int ENDCAP     		= 14;
	public static final int ROTATEOCTOSCALE = 15;
	public static final int OCTOMOVESCALE   = 16;
	public static final int ROTATEMOVESCALE = 17;
	
	public final static int SLOW = 10;
	public final static int MEDIUM = 20;
	public final static int FAST = 50;
	
	public final static String MONO  = "MONO";
	public final static String DI = "DI";
	public final static String TRI  = "TRI";

	public final static String TEXT = "TEXT"; 
	public final static String TEXTRef = "TEXT";

	public final static int EAST = 1;
	public final static int NORTH = 1;
	public final static int WEST = -1;
	public final static int SOUTH = -1;
	
	public final static int UP   = 1;
	public final static int DOWN = -1;
	public final static int RIGHT = 1;
	public final static int LEFT = -1;
	public final static int FRONT = 1;
	public final static int BACK = -1;

	
	public final static int XPLANE = 0;
	public final static int YPLANE = 1;
	public final static int ZPLANE = 2;
	public final static int WPLANE = 3;
	
	
	// Level of Detail Definitions		
	public final static int MAG1X   = 1;	// whole bodyeed
	public final static int MAG2X   = 10;	// top level - arms legs, heart, veins, arteries, Tissues
	public final static int MAG3X   = 100;	// Tissue, Substructure
	public final static int MAG4X   = 1000; // Cellular level
	public final static int MAG5X  	= 10000;	//Cell component level
	public final static int MAG6X 	= 100000; // Proteins, Amino Acids, Molecules	
	public final static double OFFSET = 0.00001;
	
	// View Perspective
	public final static int VIEW_FLOATING = 0;
	public final static int VIEW_CROSS_SECTION = 1;
	public final static int VIEW_INTERNAL = 2;	
	public final static int VIEW_DETACHED = 3;	
	public final static int VIEW_BIRDSEYE = 4;	
	public final static int VIEW_HAWKEYE = 5;	
	
	// Orientation
	public final static int RIGHTSIDE_UP = 0;
	public final static int UPSIDE_DOWN = 0;
	
	
	public final static int OCTOGON_REGULAR = 0;
	public final static int OCTOGON_X2 	= 1;
	public final static int OCTOGON_X4 	= 2;
	public final static int OCTOGON_X8 	= 3;
	public final static int OCTOGON_X16 = 4;
	
	public final static int OCTOGON_Z2 	= 5;
	public final static int OCTOGON_Z4 	= 6;
	public final static int OCTOGON_Z8 	= 7;
	public final static int OCTOGON_Z16 = 8;
	
	public final static int OCTOGON_Y2 	= 9;
	public final static int OCTOGON_Y4 	= 10;
	public final static int OCTOGON_Y8 	= 11;
	public final static int OCTOGON_Y16 = 12;


	public final static String Title  = "TITLE";

	public final static String ElementsLibrary = "biomight.chemistry";
	public final static String ChemistryLibrary = "biomight.chemistry";
	public final static String VascularLibrary  = "biomight.system.vascular";
	
	public final static String MuscularLibrary  = "biomight.system.muscular";
	public final static String SkeletalLibrary  = "biomight.system.skeletal";
	public final static String DesmosLibrary  = "biomight.system.ligament";
	public final static String BioAssembliesLibrary  = "biomight.chemistry.";
	
	public final static String BioAssemblies  = "biomight.chemistry.BioAssemblies";
	public final static String BioAssembliesRef  = "BioAssemblies";
	
	public final static String SINGLE_COMPONENT  = "0";
	public final static String PARENT_COMPONENT  = "1";
	public final static String CHILD_COMPONENT  = "2";

	public final static String VascularBeanRef   = "java:global/BioMightWeb/BioMightVascularBean!biomight.ejb.BioMightVascularBeanLocal";	
	public final static String MuscularBeanRef   = "java:global/BioMightWeb/BioMightMuscularBean!biomight.ejb.BioMightMuscularBeanLocal";
	public final static String SkeletalBeanRef   = "java:global/BioMightWeb/BioMightSkeletalBean!biomight.ejb.BioMightSkeletalBeanLocal";
	public final static String TissueBeanRef     = "java:global/BioMightWeb/BioMightTissueBean!biomight.ejb.BioMightTissueBeanLocal";
	public final static String BioSymbolsBeanRef = "java:global/BioMightWeb/BioMightSymbolsBean!biomight.ejb.BioMightSymbolsBeanLocal";
	
	public final static String CellularBeanRef  = "java:global/BioMightWeb/BioMightCellularBean!biomight.ejb.BioMightCellularBeanLocal";	
	public final static String ChemistryBeanRef  = "java:global/BioMightWeb/BioMightChemistryBean!biomight.ejb.BioMightChemmistryBeanLocal";	
	public final static String DNABeanRef  = "java:global/BioMightWeb/BioMightDNABean!biomight.ejb.BioMightDNABeanLocal";		
	public final static String BioMightBeanRef  = "java:global/BioMightWeb/BioMightBean!biomight.ejb.BioMightBeanLocal";		
	public final static String BioMightLigamentBeanRef  = "java:global/BioMightWeb/BioMightLigamentBean!biomight.ejb.BioMightLigamentBeanLocal";	
	
	/********************************************************************************
	 * 
	 * SYMBOLS
	 * 
	 ********************************************************************************/ 

	public final static String BioSymbolsLibrary = "biomight.text.";
		
	public final static String BioSymbols = "biomight.text.BioSymbols";
	public final static String BioSymbolsRef = "BioSymbols";

	public final static String BioTexts = "biomight.text.BioTexts";
	public final static String BioTextsRef = "BioTexts";
	
	public final static String BioText = "biomight.text.BioText";
	public final static String BioTextRef = "BioText";

	public final static String BioArrows = "biomight.text.BioArrows";
	public final static String BioArrowsRef = "BioArrows";
	
	public final static String BioArrow = "biomight.text.BioArrow";
	public final static String BioArrowRef = "BioArrow";
	
	/********************************************************************************
	 * 
	 * ELEMENTS
	 * 
	 ********************************************************************************/ 
			
	public final static String Elements  = "biomight.chemistry.elements.Elements";
	public final static String ElementsRef  = "Elements";
	
	public final static String Element  = "biomight.chemistry.elements.Element";	
	public final static String ElementRef  = "Element";

	public final static String Aluminums  = "biomight.chemistry.elements.Aluminums";
	public final static String AluminumsRef  = "Aluminums";

	public final static String Aluminum  = "biomight.chemistry.elements.Aluminum";
	public final static String AluminumRef  = "Aluminum";

	public final static String Borons  = "biomight.chemistry.elements.Borons";
	public final static String BoronsRef  = "Borons";

	public final static String Boron  = "biomight.chemistry.elements.Boron";
	public final static String BoronRef  = "Boron";
	
	public final static String Calciums  = "biomight.chemistry.elements.Calciums";
	public final static String CalciumsRef  = "Calciums";

	public final static String Calcium  = "biomight.chemistry.elements.Calcium";
	public final static String CalciumRef  = "Calcium";
	
	public final static String Carbons  = "biomight.chemistry.elements.Carbons";
	public final static String CarbonsRef  = "Carbons";

	public final static String Carbon  = "biomight.chemistry.elements.Carbon";
	public final static String CarbonRef  = "Carbon";

	public final static String Cobalts  = "biomight.chemistry.elements.Cobalts";
	public final static String CobaltsRef  = "Cobalts";

	public final static String Cobalt  = "biomight.chemistry.elements.Cobalt";
	public final static String CobaltRef  = "Cobalt";
	
	public final static String Coppers  = "biomight.chemistry.elements.Coppers";
	public final static String CoppersRef  = "Coppers";

	public final static String Copper  = "biomight.chemistry.elements.Copper";
	public final static String CopperRef  = "Copper";

	public final static String Chlorines  = "biomight.chemistry.elements.Chlorines";
	public final static String ChlorinesRef  = "Chlorines";

	public final static String Chlorine  = "biomight.chemistry.elements.Chlorine";
	public final static String ChlorineRef  = "Chlorine";

	public final static String Chromiums  = "biomight.chemistry.elements.Chromiums";
	public final static String ChromiumsRef  = "Chromiums";

	public final static String Chromium  = "biomight.chemistry.elements.Chromium";
	public final static String ChromiumRef  = "Chromium";

	public final static String Flourines  = "biomight.chemistry.elements.Flourines";
	public final static String FlourinesRef  = "Flourines";

	public final static String Flourine  = "biomight.chemistry.elements.Flourine";
	public final static String FlourineRef  = "Flourine";
	
	public final static String Hydrogens  = "biomight.chemistry.elements.Hydrogens";
	public final static String HydrogensRef  = "Hydrogens";

	public final static String Hydrogen  = "biomight.chemistry.elements.Hydrogen";
	public final static String HydrogenRef  = "Hydrogen";

	public final static String Irons  = "biomight.chemistry.elements.Irons";
	public final static String IronsRef  = "Irons";

	public final static String Iron  = "biomight.chemistry.elements.Iron";
	public final static String IronRef  = "Iron";
	
	public final static String Iodines  = "biomight.chemistry.elements.Iodines";
	public final static String IodinesRef  = "Iodines";

	public final static String Iodine  = "biomight.chemistry.elements.Iodine";
	public final static String IodineRef  = "Iodine";

	public final static String Magnesiums = "biomight.chemistry.elements.Magnesiums";
	public final static String MagnesiumsRef = "Magnesiums";

	public final static String Magnesium = "biomight.chemistry.elements.Magnesium";
	public final static String MagnesiumRef = "Magnesium";
	
	public final static String Manganeses = "biomight.chemistry.elements.Manganeses";
	public final static String ManganesesRef = "Manganeses";

	public final static String Manganese = "biomight.chemistry.elements.Manganese";
	public final static String ManganeseRef = "Manganese";

	public final static String Molybdenums = "biomight.chemistry.elements.Molybdenums";
	public final static String MolybdenumsRef = "Molybdenums";

	public final static String Molybdenum = "biomight.chemistry.elements.Molybdenum";
	public final static String MolybdenumRef = "Molybdenum";
	
	public final static String Nickels = "biomight.chemistry.elements.Nickels";
	public final static String NickelsRef = "Nickels";

	public final static String Nickel = "biomight.chemistry.elements.Nickel";
	public final static String NickelRef = "Nickel";
	
	public final static String Nitrogens = "biomight.chemistry.elements.Nitrogens";
	public final static String NitrogensRef = "Nitrogens";

	public final static String Nitrogen = "biomight.chemistry.elements.Nitrogen";
	public final static String NitrogenRef = "Nitrogen";

	public final static String Oxygens = "biomight.chemistry.elements.Oxygens";
	public final static String OxygensRef  = "Oxygens";
	
	public final static String Oxygen = "biomight.chemistry.elements.Oxygen";
	public final static String OxygenRef  = "Oxygen";

	public final static String Phosphoruses = "biomight.chemistry.elements.Phosphoruses";
	public final static String PhosphorusesRef = "Phosphoruses";
	
	public final static String Phosphorus = "biomight.chemistry.elements.Phosphorus";
	public final static String PhosphorusRef = "Phosphorus";
	
	public final static String Potassiums = "biomight.chemistry.elements.Potassiums";
	public final static String PotassiumsRef = "Potassiums";
	
	public final static String Potassium = "biomight.chemistry.elements.Potassium";
	public final static String PotassiumRef = "Potassium";
	
	public final static String Silicons = "biomight.chemistry.elements.Silicons";
	public final static String SiliconsRef = "Silicons";

	public final static String Silicon = "biomight.chemistry.elements.Silicon";
	public final static String SiliconRef = "Silicon";

	public final static String Sodiums = "biomight.chemistry.elements.Sodiums";
	public final static String SodiumsRef = "Sodiums";
	
	public final static String Sodium = "biomight.chemistry.elements.Sodium";
	public final static String SodiumRef = "Sodium";
	
	public final static String Seleniums = "biomight.chemistry.elements.Seleniums";
	public final static String SeleniumsRef = "Seleniums";
	
	public final static String Selenium = "biomight.chemistry.elements.Selenium";
	public final static String SeleniumRef = "Selenium";
	
	public final static String Sulfurs = "biomight.chemistry.elements.Sulfurs";
	public final static String SulfursRef = "Sulfurs";

	public final static String Sulfur = "biomight.chemistry.elements.Sulfur";
	public final static String SulfurRef = "Sulfur";

	public final static String Vanadiums = "biomight.chemistry.elements.Vanadiums";
	public final static String VanadiumsRef = "Vanadiums";

	public final static String Vanadium = "biomight.chemistry.elements.Vanadium";
	public final static String VanadiumRef = "Vanadium";
	
	public final static String Zincs = "biomight.chemistry.elements.Zincs";
	public final static String ZincsRef = "Zincs";

	public final static String Zinc = "biomight.chemistry.elements.Zinc";
	public final static String ZincRef = "Zinc";

	public final static String Electrons  = "biomight.chemistry.elements.Electrons";	
	public final static String ElectronsRef  = "Electrons";

	public final static String Electron  = "biomight.chemistry.elements.Electron";	
	public final static String ElectronRef  = "Electron";
	
	
	// biomight.chemistry.aminoacids	 
	 public final static String AminoAcids = "biomight.chemistry.aminoacid.AminoAcids";
	 public final static String AminoAcidsRef = "AminoAcids";
	 
	 public final static String AminoAcid = "biomight.chemistry.aminoacid.AminoAcid";  
	 public final static String AminoAcidRef = "AminoAcid";

	 public final static String Alanines = "biomight.chemistry.aminoacid.Alanines";
	 public final static String AlaninesRef = "Alanines";
	 
	 public final static String Alanine = "biomight.chemistry.aminoacid.Alanine";
	 public final static String AlanineRef = "Alanine";

	 public final static String Arginines = "biomight.chemistry.aminoacid.Arginines";
	 public final static String ArgininesRef = "Arginines";

	 public final static String Arginine = "biomight.chemistry.aminoacid.Arginine";
	 public final static String ArginineRef = "Arginine";

	 public final static String Asparagines = "biomight.chemistry.aminoacid.Asparagines";
	 public final static String AsparaginesRef = "Asparagines";

	 public final static String Asparagine = "biomight.chemistry.aminoacid.Asparagine";
	 public final static String AsparagineRef = "Asparagine";

	 public final static String AsparticAcids = "biomight.chemistry.aminoacid.AsparticAcids";
	 public final static String AsparticAcidsRef  = "AsparticAcids";

	 public final static String AsparticAcid = "biomight.chemistry.aminoacid.AsparticAcid";
	 public final static String AsparticAcidRef  = "AsparticAcid";

	 public final static String Cysteines = "biomight.chemistry.aminoacid.Cysteines";
	 public final static String CysteinesRef  = "Cysteines";

	 public final static String Cysteine = "biomight.chemistry.aminoacid.Cysteine";
	 public final static String CysteineRef  = "Cysteine";

	 public final static String DGlutamates = "biomight.chemistry.aminoacid.DGlutamates";
	 public final static String DGlutamatesRef  = "DGlutamates";

	 public final static String DGlutamate = "biomight.chemistry.aminoacid.DGlutamate";
	 public final static String DGlutamateRef  = "DGlutamate";

	 public final static String GlutamicAcids = "biomight.chemistry.aminoacid.GlutamicAcids";
	 public final static String GlutamicAcidsRef  = "GlutamicAcids";

	 public final static String GlutamicAcid = "biomight.chemistry.aminoacid.GlutamicAcid";
	 public final static String GlutamicAcidRef  = "GlutamicAcid";

	 public final static String Glutamines = "biomight.chemistry.aminoacid.Glutamines";
	 public final static String GlutaminesRef  = "Glutamines";
 
	 public final static String Glutamine = "biomight.chemistry.aminoacid.Glutamine";
	 public final static String GlutamineRef  = "Glutamine";
 
	 public final static String Glycines = "biomight.chemistry.aminoacid.Glycines";
	 public final static String GlycinesRef  = "Glycines";
 
	 public final static String Glycine = "biomight.chemistry.aminoacid.Glycine";
	 public final static String GlycineRef  = "Glycine";
 
	 public final static String Histidines = "biomight.chemistry.aminoacid.Histidines";
	 public final static String HistidinesRef  = "Histidines";
 
	 public final static String Histidine = "biomight.chemistry.aminoacid.Histidine";
	 public final static String HistidineRef  = "Histidine";
 
	 public final static String IsoLeucines = "biomight.chemistry.aminoacid.IsoLeucines";
	 public final static String IsoLeucinesRef  = "IsoLeucines";
 
	 public final static String IsoLeucine = "biomight.chemistry.aminoacid.IsoLeucine";
	 public final static String IsoLeucineRef  = "IsoLeucine";
 
	 public final static String Leucine = "biomight.chemistry.aminoacid.Leucine";
	 public final static String LeucineRef  = "Leucine";
 
	 public final static String Leucines = "biomight.chemistry.aminoacid.Leucines";
	 public final static String LeucinesRef  = "Leucines";
 
	 public final static String Lysines = "biomight.chemistry.aminoacid.Lysines";
	 public final static String LysinesRef  = "Lysines";
 
	 public final static String Lysine = "biomight.chemistry.aminoacid.Lysine";
	 public final static String LysineRef  = "Lysine";
 
	 public final static String Methionine = "biomight.chemistry.aminoacid.Methionine";
	 public final static String MethionineRef  = "Methionine";
 
	 public final static String Methionines = "biomight.chemistry.aminoacid.Methionines";
	 public final static String MethioninesRef  = "Methionines";
 
	 public final static String Phenylalanines = "biomight.chemistry.aminoacid.Phenylalanines";
	 public final static String PhenylalaninesRef  = "Phenylalanines";
 
	 public final static String Phenylalanine = "biomight.chemistry.aminoacid.Phenylalanine";
	 public final static String PhenylalanineRef  = "Phenylalanine";

	 public final static String Prolines = "biomight.chemistry.aminoacid.Prolines";
	 public final static String ProlinesRef  = "Prolines";
 
	 public final static String Proline = "biomight.chemistry.aminoacid.Proline";
	 public final static String ProlineRef  = "Proline";
 
	 public final static String Serines = "biomight.chemistry.aminoacid.Serines";
	 public final static String SerinesRef = "Serines";
 
	 public final static String Serine = "biomight.chemistry.aminoacid.Serine";
	 public final static String SerineRef = "Serine";
 
	 public final static String Threonines = "biomight.chemistry.aminoacid.Threonines";
	 public final static String ThreoninesRef = "Threonines";
  
	 public final static String Threonine = "biomight.chemistry.aminoacid.Threonine";
	 public final static String ThreonineRef = "Threonine";
  
	 public final static String Tryptophans = "biomight.chemistry.aminoacid.Tryptophans";
	 public final static String TryptophansRef = "Tryptophans";
	 
	 public final static String Tryptophan = "biomight.chemistry.aminoacid.Tryptophan";
	 public final static String TryptophanRef = "Tryptophan";
	 
	 public final static String Tyrosines = "biomight.chemistry.aminoacid.Tyrosines";
	 public final static String TyrosinesRef = "Tyrosines";
	 
	 public final static String Tyrosine = "biomight.chemistry.aminoacid.Tyrosine";
	 public final static String TyrosineRef = "Tyrosine";
	 
	 public final static String Valines = "biomight.chemistry.aminoacid.Valines";
	 public final static String ValinesRef = "Valines";

	 public final static String Valine = "biomight.chemistry.aminoacid.Valine";
	 public final static String ValineRef = "Valine";

	// biomight.chemistry.bonds
	public final static String Covalent = "biomight.chemistry.bonds.Covalent";
	public final static String Ionic = "biomight.chemistry.bonds.Ionic";
	public final static String PeptideBone = "biomight.chemistry.bonds.PeptideBone";
	public final static String VanDerWaals = "biomight.chemistry.bonds.VanDerWaals";

	// biomight.chemistry.carbohydrate
	public final static String Carbohydrate = "biomight.chemistry.carbohydrate.Carbohydrate";
	
	public final static String Carbohydrates = "biomight.chemistry.carbohydrate.Carbohydrates";
	public final static String CarbohydratesRef = "Carbohydrates";
	
	public final static String Dextrin = "biomight.chemistry.carbohydrate.Dextrin";
	public final static String Dextrins = "biomight.chemistry.carbohydrate.Dextrins";
	public final static String MaltoDextrin = "biomight.chemistry.carbohydrate.MaltoDextrin";

	// biomight.chemistry.carbohydrate.disaccharide
	public final static String Cellobiose = "biomight.chemistry.carbohydrate.disaccharide.Cellobiose";
	public final static String Disaccharide = "biomight.chemistry.carbohydrate.disaccharide.Disaccharide";
	public final static String Lactose = "biomight.chemistry.carbohydrate.disaccharide.Lactose";
	public final static String Maltose = "biomight.chemistry.carbohydrate.disaccharide.Maltose";
	public final static String Sucrose = "biomight.chemistry.carbohydrate.disaccharide.Sucrose";
	public final static String Trehalose = "biomight.chemistry.carbohydrate.disaccharide.Trehalose";

	// biomight.chemistry.carbohydrate.monosaccharide
	public final static String Monosaccharide = "biomight.chemistry.carbohydrate.monosaccharide.Monosaccharide";
	public final static String Monosaccharides = "biomight.chemistry.carbohydrate.monosaccharide.Monosaccharides";

	// biomight.chemistry.carbohydrate.monosaccharide.monose
	public final static String Formaldehyde = "biomight.chemistry.carbohydrate.monosaccharide.monose.Formaldehyde";
	public final static String Monose = "biomight.chemistry.carbohydrate.monosaccharide.monose.Monose";
	
	// biomight.chemistry.carbohydrate.monosaccharide.pentose
	//public final static String DeOxyRibose = "biomight.chemistry.carbohydrate.monosaccharide.pentose.DeOxyRibose";
	public final static String Pentose = "biomight.chemistry.carbohydrate.monosaccharide.pentose.Pentose";
	//public final static String Ribose = "biomight.chemistry.carbohydrate.monosaccharide.pentose.Ribose";
	
	public final static String Ribulose = "biomight.chemistry.carbohydrate.monosaccharide.pentose.Ribulose";

	// biomight.chemistry.carbohydrate.monosaccharide.tetroses
	public final static String Erythrose = "biomight.chemistry.carbohydrate.monosaccharide.tetrose.Erythrose";
	public final static String Threose = "biomight.chemistry.carbohydrate.monosaccharide.tetrose.Threose";

	// biomight.chemistry.carbohydrate.monosaccharide.trioses
	public final static String DiHydroxyAcetone = "biomight.chemistry.carbohydrate.monosaccharide.triose.DiHydroxyAcetone";
	public final static String Glyceraldehyde = "biomight.chemistry.carbohydrate.monosaccharide.triose.Glyceraldehyde";
	
	// biomight.chemistry.carbohydrate.mucopolysaccharides
	public final static String ChondroitinSulfate = "biomight.chemistry.carbohydrate.mucopolysaccharide.ChondroitinSulfate";
	public final static String DermatanSulfate = "biomight.chemistry.carbohydrate.mucopolysaccharide.DermatanSulfate";
	public final static String Glycosaminoglycans = "biomight.chemistry.carbohydrate.mucopolysaccharide.Glycosaminoglycans";
	public final static String Heparin = "biomight.chemistry.carbohydrate.mucopolysaccharide.Heparin";
	public final static String HeparinSulfate = "biomight.chemistry.carbohydrate.mucopolysaccharide.HeparinSulfate";
	public final static String HyaluronicAcid = "biomight.chemistry.carbohydrate.mucopolysaccharide.HyaluronicAcid";
	public final static String KeratanSulfate = "biomight.chemistry.carbohydrate.mucopolysaccharide.KeratanSulfate";

	// biomight.chemistry.carbohydrate.polysaccharides
	public final static String Cellulose = "biomight.chemistry.carbohydrate.polysaccharide.Cellulose";
	public final static String Chitin = "biomight.chemistry.carbohydrate.polysaccharide.Chitin";
	public final static String Glycogen = "biomight.chemistry.carbohydrate.polysaccharide.Glycogen";

	// biomight.chemistry.carbohydrate.polysaccharides.starches
	public final static String Amylopectin = "biomight.chemistry.carbohydrate.polysaccharide.starch.Amylopectin";
	public final static String Amylose = "biomight.chemistry.carbohydrate.polysaccharide.starch.Amylose";
	
	// biomight.chemistry.carbohydrate.simple
	public final static String Fructose = "biomight.chemistry.carbohydrate.simple.Fructose";
	public final static String Fucose = "biomight.chemistry.carbohydrate.simple.Fucose";
	public final static String Galactosamine = "biomight.chemistry.carbohydrate.simple.Galactosamine";
	public final static String Galactose = "biomight.chemistry.carbohydrate.simple.Galactose";
	public final static String Glucosamine = "biomight.chemistry.carbohydrate.simple.Glucosamine";
	public final static String Glucose = "biomight.chemistry.carbohydrate.simple.Glucose";
	public final static String Mannose = "biomight.chemistry.carbohydrate.simple.Mannose";

	
	public final static String Proteins = "biomight.chemistry.protein.Proteins";
	public final static String ProteinsRef = "Proteins";

	
	//	biomight.chemistry.compound
	 public final static String _12LipoOxygenase = "biomight.chemistry.compound._12LipoOxygenase";
	 public final static String _5LipoOxygenase = "biomight.chemistry.compound._5LipoOxygenase";
	 public final static String Acetylcholine = "biomight.chemistry.compound.Acetylcholine";
	 public final static String AcidHydrolase = "biomight.chemistry.compound.AcidHydrolase";
	 public final static String AcidPhosphatase = "biomight.chemistry.compound.AcidPhosphatase";
	 public final static String ActivatorProteins = "biomight.chemistry.compound.ActivatorProteins";
	 public final static String AdenylateCyclase = "biomight.chemistry.compound.AdenylateCyclase";
	 public final static String AdenylylCyclaseIsoform1 = "biomight.chemistry.compound.AdenylylCyclaseIsoform1";
	 public final static String AdenylylCyclaseIsoform2 = "biomight.chemistry.compound.AdenylylCyclaseIsoform2";
	 public final static String AdenylylCyclaseIsoform3 = "biomight.chemistry.compound.AdenylylCyclaseIsoform3";
	 public final static String AdenylylCyclaseIsoform4 = "biomight.chemistry.compound.AdenylylCyclaseIsoform4";
	 public final static String AdenylylCyclaseIsoform5 = "biomight.chemistry.compound.AdenylylCyclaseIsoform5";
	 public final static String AdenylylCyclaseIsoform6 = "biomight.chemistry.compound.AdenylylCyclaseIsoform6";
	 public final static String AdenylylCyclaseIsoform7 = "biomight.chemistry.compound.AdenylylCyclaseIsoform7";
	 public final static String AdenylylCyclaseIsoform8 = "biomight.chemistry.compound.AdenylylCyclaseIsoform8";
	 public final static String AdenylylCyclaseIsoform9 = "biomight.chemistry.compound.AdenylylCyclaseIsoform9";
	 public final static String AlanineAminoTransferase = "biomight.chemistry.compound.AlanineAminoTransferase";
	 public final static String AlkalinePhosphatase = "biomight.chemistry.compound.AlkalinePhosphatase";
	 public final static String Amantadine = "biomight.chemistry.compound.Amantadine";
	 public final static String AngiotensinConvertingEnzyme = "biomight.chemistry.compound.AngiotensinConvertingEnzyme";
	 
		 
	 public final static String AnorecticPeptides = "biomight.chemistry.compound.AnorecticPeptides";
	 public final static String AntiPorter = "biomight.chemistry.compound.AntiPorter";
	 public final static String APOBEC3G = "biomight.chemistry.compound.APOBEC3G";
	 public final static String Apoptosome = "biomight.chemistry.compound.Apoptosome";
	 public final static String ArachidonateMetabolites = "biomight.chemistry.compound.ArachidonateMetabolites";
	 public final static String AspartateAminoTransferase = "biomight.chemistry.compound.AspartateAminoTransferase";
	 public final static String BetaAdrenergicReceptorKinase = "biomight.chemistry.compound.BetaAdrenergicReceptorKinase";
	 public final static String BetaLipoTropin = "biomight.chemistry.compound.BetaLipoTropin";
	 public final static String Bromocriptine = "biomight.chemistry.compound.Bromocriptine";
	 public final static String CalcitoninGeneRelatedHormone = "biomight.chemistry.compound.CalcitoninGeneRelatedHormone";
	 public final static String Calnexin = "biomight.chemistry.compound.Calnexin";
	 public final static String cAMP = "biomight.chemistry.compound.cAMP";
	 public final static String Capase = "biomight.chemistry.compound.Capase";
	 public final static String Capase10 = "biomight.chemistry.compound.Capase10";
	 public final static String Capase3 = "biomight.chemistry.compound.Capase3";
	 public final static String Capase8 = "biomight.chemistry.compound.Capase8";
	 public final static String Capase9 = "biomight.chemistry.compound.Capase9";
	 public final static String Capases = "biomight.chemistry.compound.Capases";
	 public final static String CARTNueroPeptide = "biomight.chemistry.compound.CARTNueroPeptide";
	 public final static String CatecholOMethylTransferase = "biomight.chemistry.compound.CatecholOMethylTransferase";
	 public final static String CD40Ligand = "biomight.chemistry.compound.CD40Ligand";
	 public final static String Ceruloplasmin = "biomight.chemistry.compound.Ceruloplasmin";
	 public final static String Cerumen = "biomight.chemistry.compound.Cerumen";
	 public final static String ChorionicGonadotropin = "biomight.chemistry.compound.ChorionicGonadotropin";
	 public final static String CitricAcid = "biomight.chemistry.compound.CitricAcid";
	 public final static String Collagenase = "biomight.chemistry.compound.Collagenase";
	 public final static String ColonyStimulatingFactors = "biomight.chemistry.compound.ColonyStimulatingFactors";
	 public final static String ConcanavalinA = "biomight.chemistry.compound.ConcanavalinA";
	 public final static String CorticoSteroidBindingProtein = "biomight.chemistry.compound.CorticoSteroidBindingProtein";
	 public final static String Cortrosyn = "biomight.chemistry.compound.Cortrosyn";
	 public final static String CPeptide = "biomight.chemistry.compound.CPeptide";
	 public final static String CReactiveProtein = "biomight.chemistry.compound.CReactiveProtein";
	 public final static String CyclicAdenosineMonophosphate = "biomight.chemistry.compound.CyclicAdenosineMonophosphate";
	 public final static String CycoSpasm = "biomight.chemistry.compound.CycoSpasm";
	 public final static String CytochromeC = "biomight.chemistry.compound.CytochromeC";
	 public final static String Cytokine = "biomight.chemistry.compound.Cytokine";
	 public final static String Cytokines = "biomight.chemistry.compound.Cytokines";

	 public final static String Dentin = "biomight.chemistry.compound.Dentin";
	 public final static String DentinRef = "Dentin";
	 
	 public final static String DiIodoTyrosine = "biomight.chemistry.compound.DiIodoTyrosine";
	 public final static String DiThioThreitol = "biomight.chemistry.compound.DiThioThreitol";
	 public final static String DnaBindingDomain = "biomight.chemistry.compound.DnaBindingDomain";
	 public final static String DnaBindingProtein = "biomight.chemistry.compound.DnaBindingProtein";
	 public final static String Dolichols = "biomight.chemistry.compound.Dolichols";
	 public final static String EffectorCaspase = "biomight.chemistry.compound.EffectorCaspase";
	 public final static String EffectorCaspases = "biomight.chemistry.compound.EffectorCaspases";
	 public final static String Elastase = "biomight.chemistry.compound.Elastase";
	 
	 public final static String Enamel = "biomight.chemistry.compound.Enamel";
	 public final static String EnamelRef = "Enamel";

	 public final static String Lipids = "biomight.chemistry.hormones.lipid.Lipids";
	 public final static String LipidsRef = "Lipids";
	 
	 public final static String Lipid = "biomight.chemistry.hormones.lipid.Lipid";
	 public final static String LipidRef = "Lipid";
	 
	 public final static String EndogenousPyrogen = "biomight.chemistry.compound.EndogenousPyrogen";
	 public final static String EndoPeptidase = "biomight.chemistry.compound.EndoPeptidase";
	 public final static String EndoToxinBindingProtein = "biomight.chemistry.compound.EndoToxinBindingProtein";
	 public final static String Enfuvirtide = "biomight.chemistry.compound.Enfuvirtide";
	 public final static String Enkaphalin = "biomight.chemistry.compound.Enkaphalin";
	 public final static String EnteroKinase = "biomight.chemistry.compound.EnteroKinase";
	 public final static String FasProteinLigand = "biomight.chemistry.compound.FasProteinLigand";
	 public final static String Fat = "biomight.chemistry.compound.Fat";
	 public final static String Fibrinolysin = "biomight.chemistry.compound.Fibrinolysin";
	 public final static String FibroblastGrowthFactor = "biomight.chemistry.compound.FibroblastGrowthFactor";
	 public final static String Fibronectin = "biomight.chemistry.compound.Fibronectin";
	 public final static String Galanin = "biomight.chemistry.compound.Galanin";
	 public final static String GalaninLikePeptide = "biomight.chemistry.compound.GalaninLikePeptide";
	 public final static String GammaGlutamylTranspeptidase = "biomight.chemistry.compound.GammaGlutamylTranspeptidase";
	 public final static String GammaInterferon = "biomight.chemistry.compound.GammaInterferon";
	 public final static String GastricJuice = "biomight.chemistry.compound.GastricJuice";
	 public final static String GlomerularFiltrate = "biomight.chemistry.compound.GlomerularFiltrate";
	 public final static String GlucoseTransporterType4 = "biomight.chemistry.compound.GlucoseTransporterType4";
	 public final static String GlutamicAcidDehoxylase = "biomight.chemistry.compound.GlutamicAcidDeCarboxylase";
	 public final static String GlutaThione = "biomight.chemistry.compound.GlutaThione";
	 public final static String GlycogenSynthaseKinase3 = "biomight.chemistry.compound.GlycogenSynthaseKinase3";
	 public final static String Glycophorin = "biomight.chemistry.compound.Glycophorin";
	 public final static String GlycoSidase = "biomight.chemistry.compound.GlycoSidase";
	 public final static String GonadotropinReleasingHormone = "biomight.chemistry.compound.GonadotropinReleasingHormone";
	 public final static String GranzymeB = "biomight.chemistry.compound.GranzymeB";
	 public final static String Granzymes = "biomight.chemistry.compound.Granzymes";
	 public final static String GrBComplex = "biomight.chemistry.compound.GrBComplex";
	 public final static String GTPBindingProteins = "biomight.chemistry.compound.GTPBindingProteins";
	 public final static String HemiCholiniums = "biomight.chemistry.compound.HemiCholiniums";
	 public final static String HomoCysteine = "biomight.chemistry.compound.HomoCysteine";
	 public final static String Hyaluronidase = "biomight.chemistry.compound.Hyaluronidase";
	 public final static String HydrogenPeroxide = "biomight.chemistry.compound.HydrogenPeroxide";
	 public final static String HydroxyEicoSatetraenoicAcid = "biomight.chemistry.compound.HydroxyEicoSatetraenoicAcid";
	 public final static String HydroxyPeroxyEicoSatetraenoicAcid = "biomight.chemistry.compound.HydroxyPeroxyEicoSatetraenoicAcid";
	 public final static String ICAMProtein = "biomight.chemistry.compound.ICAMProtein";
	 public final static String ICAMProteins = "biomight.chemistry.compound.ICAMProteins";
	 public final static String IgAProtease = "biomight.chemistry.compound.IgAProtease";
	 public final static String IGFBindingProtein = "biomight.chemistry.compound.IGFBindingProtein";
	 public final static String IGFBindingProtein1 = "biomight.chemistry.compound.IGFBindingProtein1";
	 public final static String IGFBindingProtein2 = "biomight.chemistry.compound.IGFBindingProtein2";
	 public final static String IgGReceptor = "biomight.chemistry.compound.IgGReceptor";
	 public final static String IgGReceptors = "biomight.chemistry.compound.IgGReceptors";
	 public final static String ImmunoGlobulinBindingProtein = "biomight.chemistry.compound.ImmunoGlobulinBindingProtein";
	 public final static String InhibitorProteins = "biomight.chemistry.compound.InhibitorProteins";
	 public final static String InitiatorCaspase = "biomight.chemistry.compound.InitiatorCaspase";
	 public final static String InitiatorCaspases = "biomight.chemistry.compound.InitiatorCaspases";
	 public final static String IntegralMembraneProtein = "biomight.chemistry.compound.IntegralMembraneProtein";
	 public final static String IntegralMonotopicProtein = "biomight.chemistry.compound.IntegralMonotopicProtein";
	 public final static String Ketodeoxyoctulonate = "biomight.chemistry.compound.Ketodeoxyoctulonate";
	 //public final static String Lipase = "biomight.chemistry.compound.Lipase";
	 public final static String LipidA = "biomight.chemistry.compound.LipidA";
	 public final static String MajorHistocompatibilityComplex = "biomight.chemistry.compound.MajorHistocompatibilityComplex";
	 public final static String MannoseBindingProtein = "biomight.chemistry.compound.MannoseBindingProtein";
	 public final static String MetalCofactor = "biomight.chemistry.compound.MetalCofactor";
	 public final static String MICA = "biomight.chemistry.compound.MICA";
	 public final static String MonoIodoTyrosine = "biomight.chemistry.compound.MonoIodoTyrosine";
	 public final static String Monokines = "biomight.chemistry.compound.Monokines";
	 public final static String Motilin = "biomight.chemistry.compound.Motilin";
	 public final static String NeuromedinU = "biomight.chemistry.compound.NeuromedinU";
	 public final static String NeuroModulator = "biomight.chemistry.compound.NeuroModulator";
	 public final static String NeuroPeptide = "biomight.chemistry.compound.NeuroPeptide";
	 public final static String Neurotensin = "biomight.chemistry.compound.Neurotensin";
	 public final static String Nuclease = "biomight.chemistry.compound.Nuclease";
	 public final static String NueroPeptideAGRP = "biomight.chemistry.compound.NueroPeptideAGRP";
	 public final static String OrexigenicPeptides = "biomight.chemistry.compound.OrexigenicPeptides";
	 public final static String OsteoProtegerin = "biomight.chemistry.compound.OsteoProtegerin";
	 public final static String Peptidoglycan = "biomight.chemistry.compound.Peptidoglycan";
	 public final static String Perforin = "biomight.chemistry.compound.Perforin";
	 public final static String Perforins = "biomight.chemistry.compound.Perforins";
	 public final static String Perlecan = "biomight.chemistry.compound.Perlecan";
	 public final static String Phosphatase = "biomight.chemistry.compound.Phosphatase";
	 public final static String Phosphodiesterase = "biomight.chemistry.compound.Phosphodiesterase";
	 public final static String PhosphoKinase = "biomight.chemistry.compound.PhosphoKinase";
	 public final static String PhosphoLamban = "biomight.chemistry.compound.PhosphoLamban";
	 
	 public final static String PhosphoLipid = "biomight.chemistry.compound.PhosphoLipid";
	 public final static String PhosphoLipidRef = "PhosphoLipid";
	 
	 public final static String PhosphoLipids = "biomight.chemistry.compound.PhosphoLipids";
	 public final static String PhosphoLipidsRef = "PhosphoLipids";
	 
	 public final static String Phytohemagglutinin = "biomight.chemistry.compound.Phytohemagglutinin";
	 public final static String PlasminogenActivator = "biomight.chemistry.compound.PlasminogenActivator";
	 public final static String PlateletActivatingFactor = "biomight.chemistry.compound.PlateletActivatingFactor";
	 public final static String PlateletDerivedGrowthFactor = "biomight.chemistry.compound.PlateletDerivedGrowthFactor";
	 public final static String ProOpioMelanocortin = "biomight.chemistry.compound.ProOpioMelanocortin";
	 public final static String ProstateSpecificAntigen = "biomight.chemistry.compound.ProstateSpecificAntigen";
	 public final static String Protease = "biomight.chemistry.compound.Protease";
	 public final static String ProteinKinaseA = "biomight.chemistry.compound.ProteinKinaseA";
	 public final static String ProteinKinaseB = "biomight.chemistry.compound.ProteinKinaseB";
	 public final static String ProteinKinaseC = "biomight.chemistry.compound.ProteinKinaseC";
	 public final static String SalivaryAmylase = "biomight.chemistry.compound.SalivaryAmylase";
	 public final static String Sarcolipin = "biomight.chemistry.compound.Sarcolipin";
	 public final static String Somatomedins = "biomight.chemistry.compound.Somatomedins";
	 public final static String Stannin = "biomight.chemistry.compound.Stannin";
	 public final static String StemCellGrowthFactor = "biomight.chemistry.compound.StemCellGrowthFactor";
	 public final static String Streptodornase = "biomight.chemistry.compound.Streptodornase";
	 public final static String SuperOxideAnion = "biomight.chemistry.compound.SuperOxideAnion";
	 public final static String TeichoicAcid = "biomight.chemistry.compound.TeichoicAcid";
	 public final static String Thromboplastin = "biomight.chemistry.compound.Thromboplastin";
	 public final static String ThymoPoietins = "biomight.chemistry.compound.ThymoPoietins";
	 public final static String Thymosins = "biomight.chemistry.compound.Thymosins";
	 public final static String TRAMProtein = "biomight.chemistry.compound.TRAMProtein";
	 public final static String TransMembraneProtein = "biomight.chemistry.compound.TransMembraneProtein";
	 public final static String TransmembraneSegment = "biomight.chemistry.compound.TransmembraneSegment";
	 public final static String TuboCurarine = "biomight.chemistry.compound.TuboCurarine";
	 public final static String Urea = "biomight.chemistry.compound.Urea";
	 public final static String Urine = "biomight.chemistry.compound.Urine";
	 public final static String VasoActiveIntestinalPeptide = "biomight.chemistry.compound.VasoActiveIntestinalPeptide";
	 public final static String Vesamicol = "biomight.chemistry.compound.Vesamicol";

	 // Immune system juices
	 public final static String Thymosin = "biomight.chemistry.compound.Thymosin";
	 public final static String ComplementProteinsC3B = "biomight.chemistry.protein.ComplementProteinsC3B";
	 public final static String ComplementProteinsC6 = "biomight.chemistry.protein.ComplementProteinsC6";
	 public final static String ComplementProteinsC7 = "biomight.chemistry.protein.ComplementProteinsC7";
	 public final static String ComplementProteinsC8 = "biomight.chemistry.protein.ComplementProteinsC8";
	 
	 
	// biomight.chemistry.compound.adrenoceptors
	public final static String Alpha1Adrenoceptor = "biomight.chemistry.compound.adrenoceptors.Alpha1Adrenoceptor";
	public final static String Alpha2Adrenoceptor = "biomight.chemistry.compound.adrenoceptors.Alpha2Adrenoceptor";
	public final static String Beta1Adrenoceptor = "biomight.chemistry.compound.adrenoceptors.Beta1Adrenoceptor";
	public final static String Beta2Adrenoceptor = "biomight.chemistry.compound.adrenoceptors.Beta2Adrenoceptor";
	public final static String Beta3Adrenoceptor = "biomight.chemistry.compound.adrenoceptors.Beta3Adrenoceptor";

	// biomight.chemistry.compound.cholinoceptor
	public final static String MuscarinicM1Cholinoceptor = "biomight.chemistry.compound.cholinoceptor.MuscarinicM1Cholinoceptor";
	public final static String MuscarinicM2Cholinoceptor = "biomight.chemistry.compound.cholinoceptor.MuscarinicM2Cholinoceptor";
	public final static String MuscarinicM3Cholinoceptor = "biomight.chemistry.compound.cholinoceptor.MuscarinicM3Cholinoceptor";
	public final static String NicotinicMCholinoceptor = "biomight.chemistry.compound.cholinoceptor.NicotinicMCholinoceptor";
	public final static String NicotinicNCholinoceptor = "biomight.chemistry.compound.cholinoceptor.NicotinicNCholinoceptor";

	// biomight.chemistry.compound.dopaminereceptors
	public final static String D1DA1DopamineReceptor = "biomight.chemistry.compound.dopaminereceptors.D1DA1DopamineReceptor";
	public final static String D2DA2DopamineReceptor = "biomight.chemistry.compound.dopaminereceptors.D2DA2DopamineReceptor";
	public final static String D3DopamineReceptor = "biomight.chemistry.compound.dopaminereceptors.D3DopamineReceptor";
	public final static String D4DopamineReceptor = "biomight.chemistry.compound.dopaminereceptors.D4DopamineReceptor";
	public final static String D5DopamineReceptor = "biomight.chemistry.compound.dopaminereceptors.D5DopamineReceptor";

	// biomight.chemistry.compound.lipoprotein
	public final static String ApolipoProtein = "biomight.chemistry.compound.lipoprotein.ApolipoProtein";
	public final static String ApolipoProteins = "biomight.chemistry.compound.lipoprotein.ApolipoProteins";
	public final static String Chylomicrons = "biomight.chemistry.compound.lipoprotein.Chylomicrons";


	// biomight.chemistry.compound.microbiology
	public final static String BasicHelixLoopHelix = "biomight.chemistry.compound.microbiology.BasicHelixLoopHelix";
	public final static String GeneralTranscriptionFactors = "biomight.chemistry.compound.microbiology.GeneralTranscriptionFactors";
	public final static String HelixLoopHelix = "biomight.chemistry.compound.microbiology.HelixLoopHelix";
	public final static String HeptadRepeat = "biomight.chemistry.compound.microbiology.HeptadRepeat";
	public final static String InducibleTranscriptionFactors = "biomight.chemistry.compound.microbiology.InducibleTranscriptionFactors";
	public final static String LeucineZipper = "biomight.chemistry.compound.microbiology.LeucineZipper";
	public final static String PreInitiationComplex = "biomight.chemistry.compound.microbiology.PreInitiationComplex";
	public final static String StructuralMotif = "biomight.chemistry.compound.microbiology.StructuralMotif";
	public final static String TranscriptionFactor = "biomight.chemistry.compound.microbiology.TranscriptionFactor";
	public final static String UpstreamTranscriptionFactors = "biomight.chemistry.compound.microbiology.UpstreamTranscriptionFactors";
	public final static String ZincFinger = "biomight.chemistry.compound.microbiology.ZincFinger";

	// biomight.chemistry.compound.neurotoxin
	public final static String BotulinumToxin = "biomight.chemistry.compound.neurotoxin.BotulinumToxin";
	public final static String BotulinumToxinA = "biomight.chemistry.compound.neurotoxin.BotulinumToxinA";
	public final static String BotulinumToxinB = "biomight.chemistry.compound.neurotoxin.BotulinumToxinB";
	public final static String BotulinumToxinC = "biomight.chemistry.compound.neurotoxin.BotulinumToxinC";
	public final static String BotulinumToxinD = "biomight.chemistry.compound.neurotoxin.BotulinumToxinD";
	public final static String BotulinumToxinE = "biomight.chemistry.compound.neurotoxin.BotulinumToxinE";
	public final static String BotulinumToxinF = "biomight.chemistry.compound.neurotoxin.BotulinumToxinF";
	public final static String TetanusToxin = "biomight.chemistry.compound.neurotoxin.TetanusToxin";

	// biomight.chemistry.compound.receptors
	public final static String AMPAReceptor = "biomight.chemistry.compound.receptors.AMPAReceptor";
	public final static String BetaAdrenergicReceptor = "biomight.chemistry.compound.receptors.BetaAdrenergicReceptor";
	public final static String CalciumSensingSensor = "biomight.chemistry.compound.receptors.CalciumSensingSensor";
	public final static String CellSurfaceReceptor = "biomight.chemistry.compound.receptors.CellSurfaceReceptor";
	public final static String ComplimentReceptorC3b = "biomight.chemistry.compound.receptors.ComplimentReceptorC3b";
	//public final static String EstrogenReceptor = "biomight.chemistry.compound.receptors.EstrogenReceptor";
	public final static String FCReceptor = "biomight.chemistry.compound.receptors.FCReceptor";
	public final static String FCReceptors = "biomight.chemistry.compound.receptors.FCReceptors";
	public final static String FibroblastGrowthFactorReceptor = "biomight.chemistry.compound.receptors.FibroblastGrowthFactorReceptor";
	public final static String GProteinCoupledReceptor = "biomight.chemistry.compound.receptors.GProteinCoupledReceptor";
	public final static String GProteinCoupledReceptors = "biomight.chemistry.compound.receptors.GProteinCoupledReceptors";
	public final static String Interlukin1Receptor = "biomight.chemistry.compound.receptors.Interlukin1Receptor";
	public final static String Interlukin6Receptor = "biomight.chemistry.compound.receptors.Interlukin6Receptor";
	public final static String IonotropicGlutamateReceptors = "biomight.chemistry.compound.receptors.IonotropicGlutamateReceptors";
	public final static String IonotropicReceptors = "biomight.chemistry.compound.receptors.IonotropicReceptors";
	public final static String KainateReceptor = "biomight.chemistry.compound.receptors.KainateReceptor";
	public final static String LiverXReceptor = "biomight.chemistry.compound.receptors.LiverXReceptor";
	public final static String Mano6PhosphateReceptor = "biomight.chemistry.compound.receptors.Mano6PhosphateReceptor";
	public final static String MelatoninReceptorsMel1A = "biomight.chemistry.compound.receptors.MelatoninReceptorsMel1A";
	public final static String MelatoninReceptorsMel1B = "biomight.chemistry.compound.receptors.MelatoninReceptorsMel1B";
	public final static String MetabotropicGlutamateReceptor = "biomight.chemistry.compound.receptors.MetabotropicGlutamateReceptor";
	public final static String MetabotropicReceptor = "biomight.chemistry.compound.receptors.MetabotropicReceptor";
	public final static String NicotinicAcetylCholineReceptors = "biomight.chemistry.compound.receptors.NicotinicAcetylCholineReceptors";
	public final static String NMDAReceptor = "biomight.chemistry.compound.receptors.NMDAReceptor";
	public final static String NuclearReceptor = "biomight.chemistry.compound.receptors.NuclearReceptor";
	public final static String P2XReceptor = "biomight.chemistry.compound.receptors.P2XReceptor";
	public final static String Receptor5HT = "biomight.chemistry.compound.receptors.Receptor5HT";
	public final static String Receptor5HT1A = "biomight.chemistry.compound.receptors.Receptor5HT1A";
	public final static String Receptor5HT1B = "biomight.chemistry.compound.receptors.Receptor5HT1B";
	public final static String Receptor5HT1D = "biomight.chemistry.compound.receptors.Receptor5HT1D";
	public final static String Receptor5HT2A = "biomight.chemistry.compound.receptors.Receptor5HT2A";
	public final static String Receptor5HT2B = "biomight.chemistry.compound.receptors.Receptor5HT2B";
	public final static String Receptor5HT2C = "biomight.chemistry.compound.receptors.Receptor5HT2C";
	public final static String Receptor5HT3 = "biomight.chemistry.compound.receptors.Receptor5HT3";
	public final static String Receptor5HT4 = "biomight.chemistry.compound.receptors.Receptor5HT4";
	public final static String Receptor5HT5A = "biomight.chemistry.compound.receptors.Receptor5HT5A";
	public final static String Receptor5HT6 = "biomight.chemistry.compound.receptors.Receptor5HT6";
	public final static String Receptor5HT7 = "biomight.chemistry.compound.receptors.Receptor5HT7";
	public final static String ReceptorSubUnitGluR1 = "biomight.chemistry.compound.receptors.ReceptorSubUnitGluR1";
	public final static String ReceptorSubUnitGluR2 = "biomight.chemistry.compound.receptors.ReceptorSubUnitGluR2";
	public final static String ReceptorSubUnitGluR3 = "biomight.chemistry.compound.receptors.ReceptorSubUnitGluR3";
	public final static String ReceptorSubUnitGluR4 = "biomight.chemistry.compound.receptors.ReceptorSubUnitGluR4";
	public final static String ReceptorSubUnitGluR5 = "biomight.chemistry.compound.receptors.ReceptorSubUnitGluR5";
	public final static String ReceptorSubUnitGluR6 = "biomight.chemistry.compound.receptors.ReceptorSubUnitGluR6";
	public final static String ReceptorSubUnitGluR7 = "biomight.chemistry.compound.receptors.ReceptorSubUnitGluR7";
	public final static String ReceptorSubUnitKA1 = "biomight.chemistry.compound.receptors.ReceptorSubUnitKA1";
	public final static String ReceptorSubUnitKA2 = "biomight.chemistry.compound.receptors.ReceptorSubUnitKA2";
	public final static String ReceptorSubUnitNR1 = "biomight.chemistry.compound.receptors.ReceptorSubUnitNR1";
	public final static String ReceptorSubUnitNR2 = "biomight.chemistry.compound.receptors.ReceptorSubUnitNR2";
	public final static String ReceptorSubUnitNR2A = "biomight.chemistry.compound.receptors.ReceptorSubUnitNR2A";
	public final static String ReceptorSubUnitNR2B = "biomight.chemistry.compound.receptors.ReceptorSubUnitNR2B";
	public final static String ReceptorSubUnitNR2C = "biomight.chemistry.compound.receptors.ReceptorSubUnitNR2C";
	public final static String ReceptorSubUnitNR2D = "biomight.chemistry.compound.receptors.ReceptorSubUnitNR2D";
	public final static String ThyrotropinReceptor = "biomight.chemistry.compound.receptors.ThyrotropinReceptor";
	public final static String TollLikeReceptor2 = "biomight.chemistry.compound.receptors.TollLikeReceptor2";
	public final static String TollLikeReceptor4 = "biomight.chemistry.compound.receptors.TollLikeReceptor4";
	public final static String TransMembraneReceptor = "biomight.chemistry.compound.receptors.TransMembraneReceptor";
	
	// biomight.chemistry.compound.toxin
	public final static String DiphtheriaToxin = "biomight.chemistry.compound.toxin.DiphtheriaToxin";
	public final static String EdemaFactor = "biomight.chemistry.compound.toxin.EdemaFactor";
	public final static String LabileToxin = "biomight.chemistry.compound.toxin.LabileToxin";
	public final static String LethalFactor = "biomight.chemistry.compound.toxin.LethalFactor";
	public final static String PertussisToxin = "biomight.chemistry.compound.toxin.PertussisToxin";

	// biomight.chemistry.cytokine
	
	// biomight.chemistry.cytokine.chemokine
	public final static String AlphaChemokine = "biomight.chemistry.cytokine.chemokine.AlphaChemokine";
	public final static String AlphaChemokines = "biomight.chemistry.cytokine.chemokine.AlphaChemokines";
	public final static String BCA1 = "biomight.chemistry.cytokine.chemokine.BCA1";
	public final static String BetaChemokine = "biomight.chemistry.cytokine.chemokine.BetaChemokine";
	public final static String BetaChemokines = "biomight.chemistry.cytokine.chemokine.BetaChemokines";
	public final static String BRAK = "biomight.chemistry.cytokine.chemokine.BRAK";
	public final static String CCChemokine = "biomight.chemistry.cytokine.chemokine.CCChemokine";
	public final static String CChemokine = "biomight.chemistry.cytokine.chemokine.CChemokine";
	public final static String CCL10Chemokine = "biomight.chemistry.cytokine.chemokine.CCL10Chemokine";
	public final static String CCL11Chemokine = "biomight.chemistry.cytokine.chemokine.CCL11Chemokine";
	public final static String CCL12Chemokine = "biomight.chemistry.cytokine.chemokine.CCL12Chemokine";
	public final static String CCL13Chemokine = "biomight.chemistry.cytokine.chemokine.CCL13Chemokine";
	public final static String CCL14Chemokine = "biomight.chemistry.cytokine.chemokine.CCL14Chemokine";
	public final static String CCL15Chemokine = "biomight.chemistry.cytokine.chemokine.CCL15Chemokine";
	public final static String CCL16Chemokine = "biomight.chemistry.cytokine.chemokine.CCL16Chemokine";
	public final static String CCL17Chemokine = "biomight.chemistry.cytokine.chemokine.CCL17Chemokine";
	public final static String CCL18Chemokine = "biomight.chemistry.cytokine.chemokine.CCL18Chemokine";
	public final static String CCL19Chemokine = "biomight.chemistry.cytokine.chemokine.CCL19Chemokine";
	public final static String CCL1Chemokine = "biomight.chemistry.cytokine.chemokine.CCL1Chemokine";
	public final static String CCL20Chemokine = "biomight.chemistry.cytokine.chemokine.CCL20Chemokine";
	public final static String CCL21Chemokine = "biomight.chemistry.cytokine.chemokine.CCL21Chemokine";
	public final static String CCL22Chemokine = "biomight.chemistry.cytokine.chemokine.CCL22Chemokine";
	public final static String CCL23Chemokine = "biomight.chemistry.cytokine.chemokine.CCL23Chemokine";
	public final static String CCL24Chemokine = "biomight.chemistry.cytokine.chemokine.CCL24Chemokine";
	public final static String CCL25Chemokine = "biomight.chemistry.cytokine.chemokine.CCL25Chemokine";
	public final static String CCL26Chemokine = "biomight.chemistry.cytokine.chemokine.CCL26Chemokine";
	public final static String CCL27Chemokine = "biomight.chemistry.cytokine.chemokine.CCL27Chemokine";
	public final static String CCL28Chemokine = "biomight.chemistry.cytokine.chemokine.CCL28Chemokine";
	public final static String CCL2Chemokine = "biomight.chemistry.cytokine.chemokine.CCL2Chemokine";
	public final static String CCL3Chemokine = "biomight.chemistry.cytokine.chemokine.CCL3Chemokine";
	public final static String CCL4Chemokine = "biomight.chemistry.cytokine.chemokine.CCL4Chemokine";
	public final static String CCL5Chemokine = "biomight.chemistry.cytokine.chemokine.CCL5Chemokine";
	public final static String CCL6Chemokine = "biomight.chemistry.cytokine.chemokine.CCL6Chemokine";
	public final static String CCL7Chemokine = "biomight.chemistry.cytokine.chemokine.CCL7Chemokine";
	public final static String CCL8Chemokine = "biomight.chemistry.cytokine.chemokine.CCL8Chemokine";
	public final static String CCL9Chemokine = "biomight.chemistry.cytokine.chemokine.CCL9Chemokine";
	public final static String Chemokine = "biomight.chemistry.cytokine.chemokine.Chemokine";
	public final static String ChemokineMCAF = "biomight.chemistry.cytokine.chemokine.ChemokineMCAF";
	public final static String ChemokineRANTES = "biomight.chemistry.cytokine.chemokine.ChemokineRANTES";
	public final static String Chemokines = "biomight.chemistry.cytokine.chemokine.Chemokines";
	public final static String CL1Chemokine = "biomight.chemistry.cytokine.chemokine.CL1Chemokine";
	public final static String CL2Chemokine = "biomight.chemistry.cytokine.chemokine.CL2Chemokine";
	public final static String CTACK = "biomight.chemistry.cytokine.chemokine.CTACK";
	public final static String CX3CChemokine = "biomight.chemistry.cytokine.chemokine.CX3CChemokine";
	public final static String CX3CLChemokine = "biomight.chemistry.cytokine.chemokine.CX3CLChemokine";
	public final static String CXCChemokine = "biomight.chemistry.cytokine.chemokine.CXCChemokine";
	public final static String CXCL10Chemokine = "biomight.chemistry.cytokine.chemokine.CXCL10Chemokine";
	public final static String CXCL11Chemokine = "biomight.chemistry.cytokine.chemokine.CXCL11Chemokine";
	public final static String CXCL12Chemokine = "biomight.chemistry.cytokine.chemokine.CXCL12Chemokine";
	public final static String CXCL13Chemokine = "biomight.chemistry.cytokine.chemokine.CXCL13Chemokine";
	public final static String CXCL14Chemokine = "biomight.chemistry.cytokine.chemokine.CXCL14Chemokine";
	public final static String CXCL15Chemokine = "biomight.chemistry.cytokine.chemokine.CXCL15Chemokine";
	public final static String CXCL16Chemokine = "biomight.chemistry.cytokine.chemokine.CXCL16Chemokine";
	public final static String CXCL17Chemokine = "biomight.chemistry.cytokine.chemokine.CXCL17Chemokine";
	public final static String CXCL1Chemokine = "biomight.chemistry.cytokine.chemokine.CXCL1Chemokine";
	public final static String CXCL2Chemokine = "biomight.chemistry.cytokine.chemokine.CXCL2Chemokine";
	public final static String CXCL3Chemokine = "biomight.chemistry.cytokine.chemokine.CXCL3Chemokine";
	public final static String CXCL4Chemokine = "biomight.chemistry.cytokine.chemokine.CXCL4Chemokine";
	public final static String CXCL5Chemokine = "biomight.chemistry.cytokine.chemokine.CXCL5Chemokine";
	public final static String CXCL6Chemokine = "biomight.chemistry.cytokine.chemokine.CXCL6Chemokine";
	public final static String CXCL7Chemokine = "biomight.chemistry.cytokine.chemokine.CXCL7Chemokine";
	public final static String CXCL8Chemokine = "biomight.chemistry.cytokine.chemokine.CXCL8Chemokine";
	public final static String CXCL9Chemokine = "biomight.chemistry.cytokine.chemokine.CXCL9Chemokine";
	public final static String DopamineReceptor = "biomight.chemistry.cytokine.chemokine.DopamineReceptor";
	public final static String ELC = "biomight.chemistry.cytokine.chemokine.ELC";
	public final static String ENA = "biomight.chemistry.cytokine.chemokine.ENA";
	public final static String Eotaxin = "biomight.chemistry.cytokine.chemokine.Eotaxin";
	public final static String Exodus2 = "biomight.chemistry.cytokine.chemokine.Exodus2";
	public final static String Fractalkine = "biomight.chemistry.cytokine.chemokine.Fractalkine";
	public final static String GCP2 = "biomight.chemistry.cytokine.chemokine.GCP2";
	public final static String GRO = "biomight.chemistry.cytokine.chemokine.GRO";
	public final static String HCC1 = "biomight.chemistry.cytokine.chemokine.HCC1";
	public final static String HCC4 = "biomight.chemistry.cytokine.chemokine.HCC4";
	public final static String I309 = "biomight.chemistry.cytokine.chemokine.I309";
	public final static String IP10 = "biomight.chemistry.cytokine.chemokine.IP10";
	public final static String ITAC = "biomight.chemistry.cytokine.chemokine.ITAC";
	public final static String LAG1 = "biomight.chemistry.cytokine.chemokine.LAG1";
	public final static String LD78Beta = "biomight.chemistry.cytokine.chemokine.LD78Beta";
	public final static String LEC = "biomight.chemistry.cytokine.chemokine.LEC";
	public final static String LL37 = "biomight.chemistry.cytokine.chemokine.LL37";
	public final static String Lymphotactin = "biomight.chemistry.cytokine.chemokine.Lymphotactin";
	public final static String MCP = "biomight.chemistry.cytokine.chemokine.MCP";
	public final static String MDC = "biomight.chemistry.cytokine.chemokine.MDC";
	public final static String MEC = "biomight.chemistry.cytokine.chemokine.MEC";
	public final static String MIG = "biomight.chemistry.cytokine.chemokine.MIG";
	public final static String MIP = "biomight.chemistry.cytokine.chemokine.MIP";
	public final static String NAP2 = "biomight.chemistry.cytokine.chemokine.NAP2";
	public final static String PARC = "biomight.chemistry.cytokine.chemokine.PARC";
	public final static String PF4 = "biomight.chemistry.cytokine.chemokine.PF4";
	public final static String SDF = "biomight.chemistry.cytokine.chemokine.SDF";
	public final static String TARC = "biomight.chemistry.cytokine.chemokine.TARC";
	public final static String TECK = "biomight.chemistry.cytokine.chemokine.TECK";
	
	// biomight.chemistry.cytokines.interlukin
	public final static String Interlukin10 = "biomight.chemistry.cytokines.interlukin.Interlukin10";
	public final static String Interlukin11 = "biomight.chemistry.cytokines.interlukin.Interlukin11";
	public final static String Interlukin12 = "biomight.chemistry.cytokines.interlukin.Interlukin12";
	public final static String Interlukin17 = "biomight.chemistry.cytokines.interlukin.Interlukin17";
	public final static String Interlukin18 = "biomight.chemistry.cytokines.interlukin.Interlukin18";
	public final static String Interlukin1Alpha = "biomight.chemistry.cytokines.interlukin.Interlukin1Alpha";
	public final static String Interlukin1Beta = "biomight.chemistry.cytokines.interlukin.Interlukin1Beta";
	public final static String Interlukin2 = "biomight.chemistry.cytokines.interlukin.Interlukin2";
	public final static String Interlukin4 = "biomight.chemistry.cytokines.interlukin.Interlukin4";
	public final static String Interlukin5 = "biomight.chemistry.cytokines.interlukin.Interlukin5";
	public final static String Interlukin6 = "biomight.chemistry.cytokines.interlukin.Interlukin6";
	public final static String Interlukin7 = "biomight.chemistry.cytokines.interlukin.Interlukin7";
	public final static String Interlukin8 = "biomight.chemistry.cytokines.interlukin.Interlukin8";

	// biomight.chemistry.enzymes
	public final static String Enzymes = "biomight.chemistry.enzyme.Enzymes";
	public final static String EnzymesRef = "Enzymes";
	
	public final static String Enzyme = "biomight.chemistry.enzyme.Enzyme";
	public final static String EnzymeRef = "Enzyme";
		
	public final static String Amylase = "biomight.chemistry.enzyme.Amylase";
	public final static String AmylaseRef = "Amylase";
	
	public final static String Amylases = "Amylase";
	public final static String AmylasesRef = "Amylases";
	
	public final static String AutoLyticEnzymes = "biomight.chemistry.enzyme.AutoLyticEnzymes";
	public final static String AutoLyticEnzymesRef = "AutoLyticEnzymes";
	
	public final static String AutoLyticEnzyme = "biomight.chemistry.enzyme.AutoLyticEnzyme";
	public final static String AutoLyticEnzymeRef = "biomight.chemistry.enzyme.AutoLyticEnzyme";

	public final static String Chymotrypsins = "biomight.chemistry.enzyme.Chymotrypsins";
	public final static String ChymotrypsinsRef = "Chymotrypsins";

	public final static String Chymotrypsin = "biomight.chemistry.enzyme.Chymotrypsin";
	public final static String ChymotrypsinRef = "Chymotrypsin";
	
	public final static String ChymoTrypsinogen = "biomight.chemistry.enzyme.ChymoTrypsinogen";
	public final static String ChymoTrypsinogenRef = "ChymoTrypsinogen";

	public final static String Hydrolases = "biomight.chemistry.enzyme.Hydrolases";
	public final static String HydrolasesRef = "Hydrolases";

	public final static String Hydrolase = "biomight.chemistry.enzyme.Hydrolase";
	public final static String HydrolaseRef = "Hydrolase";
	
	public final static String Isomerase = "biomight.chemistry.enzyme.Isomerase";
	public final static String IsomeraseRef = "Isomerase";

	public final static String Ligases = "biomight.chemistry.enzyme.Ligases";
	public final static String LigasesRef = "Ligases";

	public final static String Ligase = "biomight.chemistry.enzyme.Ligase";
	public final static String LigaseRef = "Ligase";
	
	public final static String LingualLipase = "biomight.chemistry.enzyme.LingualLipase";
	public final static String LingualLipaseRef = "LingualLipase";
	
	public final static String Lipase = "biomight.chemistry.enzyme.Lipase";
	public final static String LipaseRef = "Lipase";
	
	public final static String Lyase = "biomight.chemistry.enzyme.Lyase";
	public final static String LyaseRef = "Lyase";
	
	public final static String Maltase = "biomight.chemistry.enzyme.Maltase";
	public final static String MaltaseRef = "Maltase";
	
	public final static String MureinHydrolases = "biomight.chemistry.enzyme.MureinHydrolases";
	public final static String MureinHydrolasesRef = "MureinHydrolases";
	
	public final static String Oxidoreductase = "biomight.chemistry.enzyme.Oxidoreductase";
	public final static String OxidoreductaseRef = "Oxidoreductase";
	
	public final static String Peroxidase = "biomight.chemistry.enzyme.Peroxidase";
	public final static String PeroxidaseRef = "Peroxidase";
	
	public final static String Reductase = "biomight.chemistry.enzyme.Reductase";
	public final static String ReductaseRef = "Reductase";
	
	public final static String SuperOxideDismutase = "biomight.chemistry.enzyme.SuperOxideDismutase";
	public final static String SuperOxideDismutaseRef = "SuperOxideDismutase";
	
	public final static String ThyroPeroxidase = "biomight.chemistry.enzyme.ThyroPeroxidase";
	public final static String ThyroPeroxidaseRef = "ThyroPeroxidase";
	
	public final static String Transferase = "biomight.chemistry.enzyme.Transferase";
	public final static String TransferaseRef = "Transferase";
	
	public final static String Trypsins = "biomight.chemistry.enzyme.Trypsins";
	public final static String TrypsinsRef = "Trypsins";
	
	public final static String Trypsin = "biomight.chemistry.enzyme.Trypsin";
	public final static String TrypsinRef = "Trypsin";
	
	public final static String Trypsinogen = "biomight.chemistry.enzyme.Trypsinogen";
	public final static String TrypsinogenRef = "Trypsinogen";
	
	// biomight.chemistry.enzymes.nucleolytic
	public final static String DeOxyRiboNuclease = "biomight.chemistry.enzymes.nucleolytic.DeOxyRiboNuclease";
	public final static String DeOxyRiboNucleaseRef = "DeOxyRiboNuclease";
	
	public final static String RiboNuclease = "biomight.chemistry.enzymes.nucleolytic.RiboNuclease";
	public final static String RiboNucleaseRef = "RiboNuclease";

	// biomight.chemistry.glycoprotein
	public final static String GlycoProtein = "biomight.chemistry.glycoprotein.GlycoProtein";
	public final static String GlycoProteinRef = "GlycoProtein";

	public final static String GlycoProteins = "biomight.chemistry.glycoprotein.GlycoProteins";
	public final static String GlycoProteinsRef = "GlycoProteins";
	
	public final static String Laminin = "biomight.chemistry.glycoprotein.Laminin";

	// biomight.chemistry.glycoprotein.proteoglycan
	public final static String HeparanSulfate = "biomight.chemistry.glycoprotein.proteoglycan.HeparanSulfate";
	public final static String ProteoGlycan = "biomight.chemistry.glycoprotein.proteoglycan.ProteoGlycan";
	public final static String ProteoGlycans = "biomight.chemistry.glycoprotein.proteoglycan.ProteoGlycans";

	// biomight.chemistry.heterocyclic.macrocycle
	public final static String Porphyrin = "biomight.chemistry.heterocyclic.macrocycle.Porphyrin";


	public final static String HeatShockProtein90 = "biomight.chemistry.protein.HeatShockProtein90";
	public final static String HeatShockProtein40 = "biomight.chemistry.protein.HeatShockProtein40";
	
	
	/********************************************************************************
	 * 
	 * HORMONES
	 * 
	 ********************************************************************************/ 
	//biomight.chemistry.hormones
	
	public final static String Hormones = "biomight.chemistry.hormones.Hormones";
	public final static String HormonesRef = "Hormones";
	
	public final static String ADP = "biomight.chemistry.hormones.ADP";
	public final static String ADPRef = "ADP";

	public final static String AP1 = "biomight.chemistry.hormones.AP1";
	public final static String AP1Ref = "AP1";
	
	public final static String BetaEndorphin = "biomight.chemistry.hormones.BetaEndorphin";
	public final static String BetaEndorphinRef = "BetaEndorphin";
	
	public final static String Bombesin = "biomight.chemistry.hormones.Bombesin";
	public final static String BombesinRef = "Bombesin";
	
	public final static String Cholecytoskinin = "biomight.chemistry.hormones.Cholecytoskinin";
	public final static String CholecytoskininRef = "Cholecytoskinin";
	
	public final static String Endorphin = "biomight.chemistry.hormones.Endorphin";
	public final static String EndorphinRef = "Endorphin";
	
	public final static String GABA = "biomight.chemistry.hormones.GABA";
	public final static String GABARef = "GABA";
	
	public final static String HypoCretin = "biomight.chemistry.hormones.HypoCretin";
	public final static String HypoCretinRef = "HypoCretin";

	public final static String NeuroHormones = "biomight.chemistry.hormones.NeuroHormones";
	public final static String NeuroHormonesRef = "NeuroHormones";
	
	public final static String SecretinTriiodothyronine = "biomight.chemistry.hormones.SecretinTriiodothyronine";
	public final static String SecretinTriiodothyronineRef = "SecretinTriiodothyronine";

	// biomight.chemistry.hormones.aminederived.catecholamines
	public final static String Catecholamines = "biomight.chemistry.hormones.aminederived.catecholamines.Catecholamines";
	public final static String CatecholaminesRef = "Catecholamines";

	public final static String Catecholamine = "biomight.chemistry.hormones.aminederived.catecholamines.Catecholamines";
	public final static String CatecholamineRef = "Catecholamine";
	
	public final static String Adrenaline = "biomight.chemistry.hormones.aminederived.catecholamines.Adrenaline";
	public final static String AdrenalineRef = "Adrenaline";
	
	public final static String Dobutamine = "biomight.chemistry.hormones.aminederived.catecholamines.Dobutamine";
	public final static String DobutamineRef = "Dobutamine";
	
	public final static String Dopamine = "biomight.chemistry.hormones.aminederived.catecholamines.Dopamine";
	public final static String DopamineRef = ".Dopamine";
	
	public final static String Enkephalin = "biomight.chemistry.hormones.aminederived.catecholamines.Enkephalin";
	public final static String EnkephalinRef = "Enkephalin";
	
	public final static String Ephedrine = "biomight.chemistry.hormones.aminederived.catecholamines.Ephedrine";
	public final static String EphedrineRef = "Ephedrine";
	
	public final static String Epinephrine = "biomight.chemistry.hormones.aminederived.catecholamines.Epinephrine";
	public final static String EpinephrineRef = "Epinephrine";

	public final static String Fenoldopam = "biomight.chemistry.hormones.aminederived.catecholamines.Fenoldopam";
	public final static String FenoldopamRef = "Fenoldopam";
	
	public final static String HomoVanillicAcid = "biomight.chemistry.hormones.aminederived.catecholamines.HomoVanillicAcid";
	public final static String HomoVanillicAcidRef = "HomoVanillicAcid";
	
	public final static String IsoProterenol = "biomight.chemistry.hormones.aminederived.catecholamines.IsoProterenol";
	public final static String IsoProterenolRef = "IsoProterenol";
	
	public final static String MetaNephrine = "biomight.chemistry.hormones.aminederived.catecholamines.MetaNephrine";
	public final static String MetaNephrineRef = "MetaNephrine";
	
	public final static String Methoxamine = "biomight.chemistry.hormones.aminederived.catecholamines.Methoxamine";
	public final static String MethoxamineRef = "Methoxamine";
	
	public final static String Midodrine = "biomight.chemistry.hormones.aminederived.catecholamines.Midodrine";
	public final static String MidodrineRef = "Midodrine";
	
	public final static String NorAdrenaline = "biomight.chemistry.hormones.aminederived.catecholamines.NorAdrenaline";
	
	public final static String NorMetaNephrine = "biomight.chemistry.hormones.aminederived.catecholamines.NorMetaNephrine";
	
	public final static String Tryamine = "biomight.chemistry.hormones.aminederived.catecholamines.Tryamine";

	// biomight.chemistry.hormones.aminederived.tryptophan
	public final static String Melatonin = "biomight.chemistry.hormones.aminederived.tryptophan.Melatonin";
	public final static String Seratonin = "biomight.chemistry.hormones.aminederived.tryptophan.Seratonin";
	
	// biomight.chemistry.hormones.aminederived.tyrosine
	public final static String Triiodothyronine = "biomight.chemistry.hormones.aminederived.tyrosine.Triiodothyronine";

	// biomight.chemistry.hormones.lipid
	public final static String Cholesterols = "biomight.chemistry.hormones.lipid.Cholesterols";
	public final static String CholesterolsRef = "Cholesterols";

	public final static String Cholesterol = "biomight.chemistry.hormones.lipid.Cholesterol";
	public final static String CholesterolRef = "Cholesterol";
		
	public final static String Eicosanoids = "biomight.chemistry.hormones.lipid.Eicosanoids";
	public final static String EicosanoidsRef = "Eicosanoids";
	
	public final static String Eicosanoid = "biomight.chemistry.hormones.lipid.Eicosanoid";
	public final static String EicosanoidRef = "Eicosanoid";

	public final static String Leukotrienes = "biomight.chemistry.hormones.lipid.Leukotrienes";
	public final static String LeukotrienesRef = "Leukotrienes";
	
	public final static String Leukotriene = "biomight.chemistry.hormones.lipid.Leukotriene";
	public final static String LeukotrieneRef = "Leukotriene";

	public final static String Prostacyclins = "biomight.chemistry.hormones.lipid.Prostacyclins";
	public final static String ProstacyclinsRef = "Prostacyclins";

	public final static String Prostacyclin = "biomight.chemistry.hormones.lipid.Prostacyclin";
	public final static String ProstacyclinRef = "Prostacyclin";
	
	public final static String ProstaglandinEs = "biomight.chemistry.hormones.lipid.ProstaglandinEs";
	public final static String ProstaglandinEsRef = "ProstaglandinEs";
	
	public final static String ProstaglandinE = "biomight.chemistry.hormones.lipid.ProstaglandinE";
	public final static String ProstaglandinERef = "ProstaglandinE";
	
	public final static String Prostaglandins = "biomight.chemistry.hormones.lipid.Prostaglandins";
	public final static String ProstaglandinsRef = "Prostaglandins";

	public final static String Prostaglandin = "biomight.chemistry.hormones.lipid.Prostaglandins";
	public final static String ProstaglandinRef = "Prostaglandin";

	public final static String Thromboxane = "biomight.chemistry.hormones.lipid.Thromboxane";
	public final static String ThromboxaneRef = "Thromboxane";

	public final static String Thromboxanes = "biomight.chemistry.hormones.lipid.Thromboxanes";
	public final static String ThromboxanesRef = "Thromboxanes";

	public final static String AutoLyticPeptides = "biomight.chemistry.enzyme.AutoLyticEnzymes";
	public final static String AutoLyticPeptidesRef = "AutoLyticPeptides";
	
	// biomight.chemistry.hormones.peptide
	public final static String Peptides = "biomight.chemistry.hormones.peptide.Peptides";
	public final static String PeptidesRef = "Peptides";

	public final static String Peptide = "biomight.chemistry.hormones.peptide.Peptide";
	public final static String PeptideRef = "Peptide";

	public final static String Activin = "biomight.chemistry.hormones.peptide.Activin";
	public final static String ActivinRef = "ActivinRef";
	
	public final static String ActivtingProteinI = "biomight.chemistry.hormones.peptide.ActivtingProteinI";
	public final static String ActivtingProteinIRef = "ActivtingProteinI";
	
	public final static String AdenosineDiPhosphate = "biomight.chemistry.hormones.peptide.AdenosineDiPhosphate";
	public final static String AdenosineDiPhosphateRef = "AdenosineDiPhosphate";
	
	public final static String AdenosineTriPhosphate = "biomight.chemistry.hormones.peptide.AdenosineTriPhosphate";
	public final static String AdenosineTriPhosphateRef = "AdenosineTriPhosphate";
	
	public final static String ADH = "biomight.chemistry.hormones.peptide.ADH";
	public final static String ADHRef = "ADH";
	
	public final static String Adiponectin = "biomight.chemistry.hormones.peptide.Adiponectin";
	public final static String AdiponectinRef = "Adiponectin";
	
	public final static String AdrenoCorticotropicHormone = "biomight.chemistry.hormones.peptide.AdrenoCorticotropicHormone";
	public final static String AdrenoCorticotropicHormoneRef = "AdrenoCorticotropicHormone";
	
	public final static String AlphaDefensins = "biomight.chemistry.hormones.peptide.AlphaDefensins";
	public final static String AlphaDefensinsRef = "AlphaDefensins";
	
	public final static String AMH = "biomight.chemistry.hormones.peptide.AMH";
	public final static String AMHRef = "AMH";
	
	public final static String Angiotensin = "biomight.chemistry.hormones.peptide.Angiotensin";
	public final static String AngiotensinRef = "Angiotensin";
	
	public final static String Angiotensinogen = "biomight.chemistry.hormones.peptide.Angiotensinogen";
	public final static String AngiotensinogenRef = "Angiotensinogen";
	
	public final static String ANP = "biomight.chemistry.hormones.peptide.ANP";
	public final static String ANPRef = "ANP";
	
	public final static String AntidiureticHormone = "biomight.chemistry.hormones.peptide.AntidiureticHormone";
	public final static String AntidiureticHormoneRef = "AntidiureticHormone";
	
	public final static String ArginineVasopressin = "biomight.chemistry.hormones.peptide.ArginineVasopressin";
	public final static String ArginineVasopressinRef = "ArginineVasopressin";
	
	public final static String AtrialNatriureticPeptide = "biomight.chemistry.hormones.peptide.AtrialNatriureticPeptide";
	public final static String AtrialNatriureticPeptideRef = "AtrialNatriureticPeptide";
	
	public final static String BetaDefensinHDB1 = "biomight.chemistry.hormones.peptide.BetaDefensinHDB1";
	public final static String BetaDefensinHDB1Ref = "BetaDefensinHDB1";
	
	public final static String BetaDefensinHDB2 = "biomight.chemistry.hormones.peptide.BetaDefensinHDB2";
	public final static String BetaDefensinHDB2Ref = "BetaDefensinHDB2";
	
	public final static String BetaDefensins = "biomight.chemistry.hormones.peptide.BetaDefensins";
	public final static String BetaDefensinsRef = "BetaDefensins";
	
	public final static String Calcitonin = "biomight.chemistry.hormones.peptide.Calcitonin";
	public final static String CalcitoninRef = "Calcitonin";
	
	public final static String CCK = "biomight.chemistry.hormones.peptide.CCK";
	public final static String CCKRef = "CCK";
	
	public final static String Cholecystokinin = "biomight.chemistry.hormones.peptide.Cholecystokinin";
	public final static String CholecystokininRef = "Cholecystokinin";
	
	public final static String CoatAssociatedProtein = "biomight.chemistry.hormones.peptide.CoatAssociatedProtein";
	public final static String CoatAssociatedProteinRef = "CoatAssociatedProtein";
	
	public final static String CoatAssociatedProteinI = "biomight.chemistry.hormones.peptide.CoatAssociatedProteinI";
	public final static String CoatAssociatedProteinIRef = "CoatAssociatedProteinI";
	
	public final static String CoatAssociatedProteinII = "biomight.chemistry.hormones.peptide.CoatAssociatedProteinII";
	public final static String CoatAssociatedProteinIIRef = "CoatAssociatedProteinII";
	
	public final static String ConstitutiveAndrostaneReceptor = "biomight.chemistry.hormones.peptide.ConstitutiveAndrostaneReceptor";
	public final static String ConstitutiveAndrostaneReceptorRef = "ConstitutiveAndrostaneReceptor";
	
	public final static String CorticotropinReleasingHormone = "biomight.chemistry.hormones.peptide.CorticotropinReleasingHormone";
	public final static String CorticotropinReleasingHormoneRef = "CorticotropinReleasingHormone";
	
	public final static String CRH = "biomight.chemistry.hormones.peptide.CRH";
	public final static String CRHRef = "CRH";
	
	public final static String Defensins = "biomight.chemistry.hormones.peptide.Defensins";
	public final static String DefensinsRef = "Defensins";

	public final static String Defensin = "biomight.chemistry.hormones.peptide.Defensin";
	public final static String DefensinRef = "Defensin";
	
	public final static String EpidermalGrowthFactor = "biomight.chemistry.hormones.peptide.EpidermalGrowthFactor";
	public final static String EpidermalGrowthFactorRef = "EpidermalGrowthFactor";
	
	public final static String Erythropoietin = "biomight.chemistry.hormones.peptide.Erythropoietin";
	public final static String ErythropoietinRef = "Erythropoietin";
	
	public final static String EstrogenReceptor = "biomight.chemistry.hormones.peptide.EstrogenReceptor";
	public final static String EstrogenReceptorRef = "EstrogenReceptor";
	
	public final static String FollicleStimulatingHormone = "biomight.chemistry.hormones.peptide.FollicleStimulatingHormone";
	public final static String FollicleStimulatingHormoneRef = "FollicleStimulatingHormone";
	
	public final static String Follistatin = "biomight.chemistry.hormones.peptide.Follistatin";
	public final static String FollistatinRef = "Follistatin";

	public final static String Gastrins = "biomight.chemistry.hormones.peptide.Gastrin";
	public final static String GastrinsRef = "Gastrin";

	public final static String Gastrin = "biomight.chemistry.hormones.peptide.Gastrin";
	public final static String GastrinRef = "Gastrin";
	
	public final static String Ghrelin = "biomight.chemistry.hormones.peptide.Ghrelin";
	public final static String GhrelinRef = "Ghrelin";
	
	public final static String GHRH = "biomight.chemistry.hormones.peptide.GHRH";
	public final static String GHRHRef = "GHRH";
	
	public final static String Glucagons = "biomight.chemistry.hormones.peptide.Glucagons";
	public final static String GlucagonsRef = "Glucagons";
	
	public final static String Glucagon = "biomight.chemistry.hormones.peptide.Glucagon";
	public final static String GlucagonRef = "Glucagon";
	
	public final static String GnRH = "biomight.chemistry.hormones.peptide.GnRH";
	public final static String GnRHRef = "GnRH";
	
	public final static String GuanosineDiPhosphate = "biomight.chemistry.hormones.peptide.GuanosineDiPhosphate";
	public final static String GuanosineDiPhosphateRef = "GuanosineDiPhosphate";
	
	public final static String GuanosineTriPhosphate = "biomight.chemistry.hormones.peptide.GuanosineTriPhosphate";
	public final static String GuanosineTriPhosphateRef = "GuanosineTriPhosphate";
	
	public final static String HCG = "biomight.chemistry.hormones.peptide.HCG";
	public final static String HCGRef = "HCG";
	
	public final static String HighDensityLipoProtein = "biomight.chemistry.hormones.peptide.HighDensityLipoProtein";
	public final static String HighDensityLipoProteinRef = "HighDensityLipoProtein";

	public final static String Inhibins = "biomight.chemistry.hormones.peptide.Inhibins";
	public final static String InhibinsRef = "Inhibin";

	public final static String Inhibin = "biomight.chemistry.hormones.peptide.Inhibin";
	public final static String InhibinRef = "Inhibin";

	public final static String Insulins = "biomight.chemistry.hormones.peptide.Insulins";
	public final static String InsulinsRef = "Insulins";

	public final static String Insulin = "biomight.chemistry.hormones.peptide.Insulin";
	public final static String InsulinRef = "Insulin";
	
	public final static String InsulinGrowthFactorI = "biomight.chemistry.hormones.peptide.InsulinGrowthFactorI";
	public final static String InsulinGrowthFactorIRef = "InsulinGrowthFactorI";
	
	public final static String InsulinGrowthFactorII = "biomight.chemistry.hormones.peptide.InsulinGrowthFactorII";
	public final static String InsulinGrowthFactorIIRef = "InsulinGrowthFactorII";
	
	public final static String IpanoicAcid = "biomight.chemistry.hormones.peptide.IpanoicAcid";
	public final static String IpanoicAcidRef = "IpanoicAcid";
	
	public final static String JanusKinase = "biomight.chemistry.hormones.peptide.JanusKinase";
	public final static String JanusKinaseRef = "JanusKinase";
	
	public final static String Leptin = "biomight.chemistry.hormones.peptide.Leptin";
	public final static String LeptinRef = "Leptin";
	
	public final static String LowDensityLipoProtein = "biomight.chemistry.hormones.peptide.LowDensityLipoProtein";
	public final static String LowDensityLipoProteinRef = "LowDensityLipoProtein";

	public final static String LuteinizingHormone = "biomight.chemistry.hormones.peptide.LuteinizingHormone";
	public final static String LuteinizingHormoneRef = "LuteinizingHormone";
	
	public final static String MelanoCortinReceptor = "biomight.chemistry.hormones.peptide.MelanoCortinReceptor";
	public final static String MelanoCortinReceptorRef = "MelanoCortinReceptor";
	
	public final static String MelanocyteStimulatingHormone = "biomight.chemistry.hormones.peptide.MelanocyteStimulatingHormone";
	public final static String MelanocyteStimulatingHormoneRef = "MelanocyteStimulatingHormone";
	
	public final static String MitosisAssociatedProteinKinase = "biomight.chemistry.hormones.peptide.MitosisAssociatedProteinKinase";
	public final static String MitosisAssociatedProteinKinaseRef = "MitosisAssociatedProteinKinase";
	
	public final static String Amine = "biomight.chemistry.compound.Amine";
	public final static String AmineRef = "Amine";

	public final static String Carboxyl = "biomight.chemistry.compound.Carboxyl";
	public final static String CarboxylRef = "Carboxyl";

	public final static String SideChain = "biomight.chemistry.compound.SideChain";
	public final static String SideChainRef = "SideChain";
	
	public final static String MonoAmineOxidase = "biomight.chemistry.hormones.peptide.MonoAmineOxidase";
	public final static String MonoAmineOxidaseRef = "MonoAmineOxidase";
	
	public final static String NethylMaleimideSensitiveFactor = "biomight.chemistry.hormones.peptide.NethylMaleimideSensitiveFactor";
	public final static String NethylMaleimideSensitiveFactorRef = "NethylMaleimideSensitiveFactor";
	
	public final static String NeuropeptideY = "biomight.chemistry.hormones.peptide.NeuropeptideY";
	public final static String NeuropeptideYRef = "NeuropeptideY";
	
	public final static String Oxytocin = "biomight.chemistry.hormones.peptide.Oxytocin";
	public final static String OxytocinRef = "Oxytocin";
	
	public final static String Oxytoxin = "biomight.chemistry.hormones.peptide.Oxytoxin";
	public final static String OxytoxinRef = "peptide.Oxytoxin";
	
	public final static String PeptideHormone = "biomight.chemistry.hormones.peptide.PeptideHormone";
	public final static String PeptideHormoneRef = "PeptideHormone";
	
	public final static String ProInsulin = "biomight.chemistry.hormones.peptide.ProInsulin";
	public final static String ProInsulinRef = "ProInsulin";
	
	public final static String PTH = "biomight.chemistry.hormones.peptide.PTH";
	public final static String PTHRef = "PTH";
	
	public final static String Relaxin = "biomight.chemistry.hormones.peptide.Relaxin";
	public final static String RelaxinRef = "Relaxin";
	
	public final static String Renin = "biomight.chemistry.hormones.peptide.Renin";
	public final static String ReninRef = "Renin";
	
	public final static String Resistin = "biomight.chemistry.hormones.peptide.Resistin";
	public final static String ResistinRef = "bResistin";
	
	public final static String Secretin = "biomight.chemistry.hormones.peptide.Secretin";
	public final static String SecretinRef = "Secretin";
	
	public final static String SH2ProteinDomain = "biomight.chemistry.hormones.peptide.SH2ProteinDomain";
	public final static String SH2ProteinDomainRef = "SH2ProteinDomain";
	
	public final static String SignalRecognitionParticle = "biomight.chemistry.hormones.peptide.SignalRecognitionParticle";
	public final static String SignalRecognitionParticleRef = "SignalRecognitionParticle";
	
	public final static String SignalRecognitionParticleReceptor = "biomight.chemistry.hormones.peptide.SignalRecognitionParticleReceptor";
	public final static String SignalRecognitionParticleReceptorRef = "SignalRecognitionParticleReceptor";
	
	public final static String Somatostatin = "biomight.chemistry.hormones.peptide.Somatostatin";
	public final static String SomatostatinRef = "Somatostatin";
	
	public final static String Somatotropin = "biomight.chemistry.hormones.peptide.Somatotropin";
	public final static String SomatotropinRef = "Somatotropin";
	
	public final static String SrcFamilyKinases = "biomight.chemistry.hormones.peptide.SrcFamilyKinases";
	public final static String SrcFamilyKinasesRef = "SrcFamilyKinases";
	
	public final static String SterolCarrierProtein2 = "biomight.chemistry.hormones.peptide.SterolCarrierProtein2";
	public final static String SterolCarrierProtein2Ref = "SterolCarrierProtein2";
	
	public final static String Thrombopoietin = "biomight.chemistry.hormones.peptide.Thrombopoietin";
	public final static String ThrombopoietinRef = "Thrombopoietin";
	
	public final static String ThyroGlobulin = "biomight.chemistry.hormones.peptide.ThyroGlobulin";
	public final static String ThyroGlobulinRef = "biomight.chemistry.hormones.peptide.ThyroGlobulin";
	
	public final static String ThyroPeriOxidase = "biomight.chemistry.hormones.peptide.ThyroPeriOxidase";
	public final static String ThyroPeriOxidaseRef = "ThyroPeriOxidase";
	
	public final static String ThyrotropinReleasingHormone = "biomight.chemistry.hormones.peptide.ThyrotropinReleasingHormone";
	public final static String ThyrotropinReleasingHormoneRef = "ThyrotropinReleasingHormone";
	
	public final static String ThyroxineBindingGlobulin = "biomight.chemistry.hormones.peptide.ThyroxineBindingGlobulin";
	public final static String ThyroxineBindingGlobulinRef = "ThyroxineBindingGlobulin";
	
	public final static String ThyroxinStimulatingHormone = "biomight.chemistry.hormones.peptide.ThyroxinStimulatingHormone";
	public final static String ThyroxinStimulatingHormoneRef = "ThyroxinStimulatingHormone";
	
	public final static String TransformingGrowthFactor = "biomight.chemistry.hormones.peptide.TransformingGrowthFactor";
	public final static String TransformingGrowthFactorRef = "TransformingGrowthFactor";
	
	public final static String TransformingGrowthFactorAlpha = "biomight.chemistry.hormones.peptide.TransformingGrowthFactorAlpha";
	public final static String TransformingGrowthFactorAlphaRef = "TransformingGrowthFactorAlpha";
	
	public final static String TransformingGrowthFactorBeta = "biomight.chemistry.hormones.peptide.TransformingGrowthFactorBeta";
	public final static String TransformingGrowthFactorBetaRef = "TransformingGrowthFactorBeta";
	
	public final static String TransThyretin = "biomight.chemistry.hormones.peptide.TransThyretin";
	public final static String TransThyretinRef = "biomight.chemistry.hormones.peptide.TransThyretin";
	
	public final static String TriIodoThyroAceticAcid = "biomight.chemistry.hormones.peptide.TriIodoThyroAceticAcid";
	public final static String TriIodoThyroAceticAcidRef = "TriIodoThyroAceticAcid";
	
	public final static String TSH = "biomight.chemistry.hormones.peptide.TSH";
	public final static String TSHRef = "TSH";
	
	public final static String TumorNecrosisFactor = "TumorNecrosisFactor";
	public final static String TumorNecrosisFactorRef = "TumorNecrosisFactor";
	
	public final static String VanillylmandelicAcid = "biomight.chemistry.hormones.peptide.VanillylmandelicAcid";
	public final static String VanillylmandelicAcidRef = "VanillylmandelicAcid";

	public final static String Vasopressins = "biomight.chemistry.hormones.peptide.Vasopressins";
	public final static String VasopressinsRef = "Vasopressins";
	
	public final static String Vasopressin = "biomight.chemistry.hormones.peptide.Vasopressin";
	public final static String VasopressinRef = "Vasopressin";

	// biomight.chemistry.hormones.protein
	//public final static String Angiotensinogen = "biomight.chemistry.hormones.protein.Angiotensinogen";
	
	//public final static String Erythropoietin = "biomight.chemistry.hormones.protein.Erythropoietin";
	public final static String GrowthHormone = "biomight.chemistry.hormones.protein.GrowthHormone";
	public final static String GrowthHormoneRef = "GrowthHormone";
	
	public final static String GrowthHormoneBindingProtein = "biomight.chemistry.hormones.protein.GrowthHormoneBindingProtein";
	public final static String GrowthHormoneBindingProteinRef = "GrowthHormoneBindingProtein";
	
	public final static String GrowthHormoneReleasingHormone = "biomight.chemistry.hormones.protein.GrowthHormoneReleasingHormone";
	public final static String GrowthHormoneReleasingHormoneRef = "GrowthHormoneReleasingHormone";
	
	//public final static String HCG = "biomight.chemistry.hormones.protein.HCG";
	public final static String IGF1 = "biomight.chemistry.hormones.protein.IGF1";
	public final static String IGF1Ref = "bIGF1";
	
	public final static String LH = "biomight.chemistry.hormones.protein.LH";
	public final static String LHRef = "LH";
	
	public final static String ParaThyroidHormone = "biomight.chemistry.hormones.protein.ParaThyroidHormone";
	public final static String ParaThyroidHormoneRef = "ParaThyroidHormone";
	
	public final static String Prolactin = "biomight.chemistry.hormones.protein.Prolactin";
	public final static String ProlactinRef = "Prolactin";
	
	//public final static String Thrombopoietin = "biomight.chemistry.hormones.protein.Thrombopoietin";
	
	public final static String Thyroglobin = "biomight.chemistry.hormones.protein.Thyroglobin";
	public final static String ThyroglobinRef = "Thyroglobin";

	public final static String ThyroidStimulatingImmunoglobin = "biomight.chemistry.hormones.protein.ThyroidStimulatingImmunoglobin";
	public final static String ThyroidStimulatingImmunoglobinRef = "ThyroidStimulatingImmunoglobin";
	
	public final static String Thyroxine = "biomight.chemistry.hormones.protein.Thyroxine";
	public final static String ThyroxineRef = "Thyroxine";

	public final static String ThyroxineBindingProtein = "biomight.chemistry.hormones.protein.ThyroxineBindingProtein";
	public final static String ThyroxineBindingProteinRef = "ThyroxineBindingProtein";

	public final static String Steroids = "biomight.chemistry.hormones.steroid.Steroids";
	public final static String SteroidsRef = "Steroids";

	public final static String Steroid = "biomight.chemistry.hormones.steroid.Steroid";
	public final static String SteroiddRef = "Steroid";
	
	// biomight.chemistry.hormones.steroid
	
	
	public final static String AlloPregnenolones = "biomight.chemistry.hormones.steroid.AlloPregnenolones";
	public final static String AlloPregnenolonesRef = "AlloPregnenolones";
	
	public final static String AlloPregnenolone = "biomight.chemistry.hormones.steroid.AlloPregnenolone";
	public final static String AlloPregnenoloneRef = "AlloPregnenolone";
	
	public final static String BetaMethasone = "biomight.chemistry.hormones.steroid.BetaMethasone";
	public final static String BetaMethasoneRef = "BetaMethasone";

	public final static String CorticoSterones = "biomight.chemistry.hormones.steroid.CorticoSterones";
	public final static String CorticoSteronesRef = "CorticoSterones";
	
	public final static String CorticoSterone = "biomight.chemistry.hormones.steroid.CorticoSterone";
	public final static String CorticoSteroneRef = "CorticoSterone";

	public final static String Cortisones = "biomight.chemistry.hormones.steroid.Cortisones";
	public final static String CortisonesRef = "Cortisones";
	
	public final static String Cortisone = "biomight.chemistry.hormones.steroid.Cortisone";
	public final static String CortisoneRef = "Cortisone";
	
	public final static String DeOxyCorticoSterone = "biomight.chemistry.hormones.steroid.DeOxyCorticoSterone";
	public final static String DeOxyCorticoSteroneRef = "DeOxyCorticoSterone";

	public final static String DexaMethasone = "biomight.chemistry.hormones.steroid.DexaMethasone";
	public final static String DexaMethasoneRef = "DexaMethasone";

	public final static String Prednisolone = "biomight.chemistry.hormones.steroid.Prednisolone";
	public final static String PrednisoloneRef = "Prednisolone";
	
	public final static String Prednisone = "biomight.chemistry.hormones.steroid.Prednisone";
	public final static String PrednisoneRef = "Prednisone";
	
	public final static String Pregnenolone = "biomight.chemistry.hormones.steroid.Pregnenolone";
	public final static String PregnenoloneRef = "Pregnenolone";
	
	public final static String Serotonin = "biomight.chemistry.hormones.steroid.Serotonin";
	public final static String SerotoninRef = "Serotonin";
	
	public final static String Spironolactone = "biomight.chemistry.hormones.steroid.Spironolactone";
	public final static String SpironolactoneRef = "Spironolactone";
	
	public final static String SteriodHormones = "biomight.chemistry.hormones.steroid.SteriodHormones";
	public final static String SteriodHormonesRef = "SteriodHormones";

	public final static String SteriodHormone = "biomight.chemistry.hormones.steroid.SteriodHormone";
	public final static String SteriodHormoneRef = "SteriodHormone";
	
	public final static String SteroidHormone = "biomight.chemistry.hormones.steroid.SteroidHormone";
	public final static String SteroidHormoneRef = "SteroidHormone";
	
	public final static String Triamcinolone = "biomight.chemistry.hormones.steroid.Triamcinolone";
	public final static String TriamcinoloneRef = "Triamcinolone";

	
	// biomight.chemistry.hormones.steroid.glucocorticoids
	public final static String Glucocorticoids = "biomight.chemistry.hormones.steriod.glucocorticoids.Glucocorticoids";
	public final static String GlucocorticoidsRef = "Glucocorticoids";

	public final static String Glucocorticoid = "biomight.chemistry.hormones.steriod.glucocorticoids.Glucocorticoid";
	public final static String GlucocorticoidRef = "Glucocorticoids";
	
	public final static String Cortisol = "biomight.chemistry.hormones.steriod.glucocorticoids.Cortisol";
	public final static String CortisolRef = "Cortisol";
	
	// biomight.chemistry.hormones.steroid.mineralocorticoids
	public final static String Aldosterone = "biomight.chemistry.hormones.steriod.mineralocorticoids.Aldosterone";
	public final static String AldosteroneRef = "Aldosterone";
	
	// biomight.chemistry.hormones.steroid.sex.androgens
	public final static String _17AlphaHydroxyPregnenolone = "biomight.chemistry.hormones.steriod.sex.androgens._17AlphaHydroxyPregnenolone";

	public final static String _17AlphaHydroxyProgesterone = "biomight.chemistry.hormones.steriod.sex.androgens._17AlphaHydroxyProgesterone";
	
	public final static String Androgen = "biomight.chemistry.hormones.steriod.sex.androgens.Androgen";
	public final static String AndrogenRef = "Androgen";
	
	public final static String AndrogenBindingProtein = "biomight.chemistry.hormones.steriod.sex.androgens.AndrogenBindingProtein";
	public final static String AndrogenBindingProteinRef = "AndrogenBindingProtein";
	
	public final static String Androstenedione = "biomight.chemistry.hormones.steriod.sex.androgens.Androstenedione";
	public final static String AndrostenedioneRef = "Androstenedione";
	
	public final static String DeHydroEpiAndrosterone = "biomight.chemistry.hormones.steriod.sex.androgens.DeHydroEpiAndrosterone";
	public final static String DeHydroEpiAndrosteroneRef = "DeHydroEpiAndrosterone";
	
	public final static String DeHydroEpiAndrosteroneSulfate = "biomight.chemistry.hormones.steriod.sex.androgens.DeHydroEpiAndrosteroneSulfate";
	public final static String DeHydroEpiAndrosteroneSulfateRef = "DeHydroEpiAndrosteroneSulfate";
	
	public final static String DHEA = "biomight.chemistry.hormones.steriod.sex.androgens.DHEA";
	public final static String DHEARef = "DHEARef";
	
	public final static String DHEAS = "biomight.chemistry.hormones.steriod.sex.androgens.DHEAS";
	public final static String DHEASRef = "DHEAS";
	
	public final static String Dihydrotestosterone = "biomight.chemistry.hormones.steriod.sex.androgens.Dihydrotestosterone";
	public final static String DihydrotestosteroneRef = "Dihydrotestosterone";
	
	public final static String Dynorphin = "biomight.chemistry.hormones.steriod.sex.androgens.Dynorphin";
	public final static String DynorphinRef = "Dynorphin";
	
	public final static String SexHormoneBindingGlobulin = "biomight.chemistry.hormones.steriod.sex.androgens.SexHormoneBindingGlobulin";
	public final static String SexHormoneBindingGlobulinRef = "SexHormoneBindingGlobulin";

	public final static String Testosterones = "biomight.chemistry.hormones.steriod.sex.androgens.Testosterones";
	public final static String TestosteronesRef = "Testosterones";

	public final static String Testosterone = "biomight.chemistry.hormones.steriod.sex.androgens.Testosterone";
	public final static String TestosteroneRef = "Testosterone";

	// biomight.chemistry.hormones.steroid.sex.estrogens
	public final static String Estradiol = "biomight.chemistry.hormones.steriod.sex.estrogens.Estradiol";
	public final static String EstradiolRef = "Estradiol";

	public final static String Estrogen = "biomight.chemistry.hormones.steriod.sex.estrogens.Estrogen";
	public final static String EstrogenRef = "Estrogen";

	public final static String Estrone = "biomight.chemistry.hormones.steriod.sex.estrogens.Estrone";
	public final static String EstroneRef = "Estrone";
	
	// biomight.chemistry.hormones.steroid.sex.progestagens
	public final static String Progesterone = "biomight.chemistry.hormones.steriod.sex.progestagens.Progesterone";
	public final static String ProgesteroneRef = "Progesterone";
	
	public final static String Progestin = "biomight.chemistry.hormones.steriod.sex.progestagens.Progestin";
	public final static String ProgestinRef = "Progestin";

	public final static String Progestins = "biomight.chemistry.hormones.steriod.sex.progestagens.Progestins";
	public final static String ProgestinsRef = "Progestins";

	// biomight.chemistry.hormones.sterol
	public final static String Calciferols = "biomight.chemistry.hormones.sterol.Calciferols";
	public final static String CalciferolsRef = "Calciferols";
	
	public final static String Calciferol = "biomight.chemistry.hormones.sterol.Calciferol";
	public final static String CalciferolRef = "Calciferol";
	
	public final static String Calcitriol = "biomight.chemistry.hormones.sterol.Calcitriol";
	public final static String CalcitriolRef = "Calcitriol";

	// biomight.chemistry.ions
	public final static String Ions = "biomight.chemistry.ions.Ions";
	public final static String IonsRef = "Ions";
	
	public final static String Ion = "biomight.chemistry.ions.Ion";
	public final static String IonRef = "Ion";

	public final static String CalciumIon = "biomight.chemistry.ions.CalciumIon";
	public final static String CalciumIonRef = "CalciumIon";

	public final static String CalciumIons = "biomight.chemistry.ions.CalciumIons";
	public final static String CalciumIonsRef = "CalciumIons";
	
	public final static String DiPhosphate = "biomight.chemistry.ions.DiPhosphate";
	public final static String DiPhosphateRef = "DiPhosphate";

	public final static String MonoPhosphate = "biomight.chemistry.ions.MonoPhosphate";
	public final static String MonoPhosphateRef = "MonoPhosphate";

	public final static String Phosphate = "biomight.chemistry.ions.Phosphate";
	public final static String PhosphateRef = "Phosphate";
	
	public final static String TriPhosphate = "biomight.chemistry.ions.TriPhosphate";
	public final static String TriPhosphateRef = "TriPhosphate";

	// biomight.chemistry.metalloproteins
	public final static String Cytochrome = "biomight.chemistry.metalloproteins.Cytochrome";
	public final static String CytochromeRef = "Cytochrome";
	
	public final static String HemoProtein = "biomight.chemistry.metalloproteins.HemoProtein";
	public final static String HemoProteinRef = "HemoProtein";
	
	public final static String MetalloProtein = "biomight.chemistry.metalloproteins.MetalloProtein";

	// biomight.chemistry.misc
	public final static String Lecithin = "biomight.chemistry.misc.Lecithin";
	public final static String LecithinRef = "biomight.chemistry.misc.Lecithin";
	
	public final static String StemCellFactor = "biomight.chemistry.misc.StemCellFactor";
	public final static String StemCellFactorRef = "StemCellFactor";
	
	public final static String SubstanceP = "biomight.chemistry.misc.SubstanceP";
	public final static String SubstancePRef = "SubstanceP";
	
	// biomight.chemistry.molecule
	
	
	
	public final static String Acervuli = "biomight.chemistry.molecule.Acervuli";
	public final static String AcervuliRef = "Acervuli";

	public final static String AmmoniumPhosphate = "biomight.chemistry.molecule.AmmoniumPhosphate";
	public final static String AmmoniumPhosphateRef = "AmmoniumPhosphate";

	public final static String Bicarbonate = "biomight.chemistry.molecule.Bicarbonate";
	public final static String BicarbonateRef = "Bicarbonate";

	public final static String Bilirubin = "biomight.chemistry.molecule.Bilirubin";
	public final static String BilirubinRef = "Bilirubin";

	public final static String Biliverdin = "biomight.chemistry.molecule.Biliverdin"; 
	public final static String BiliverdinRef = "Biliverdin"; 
	
	public final static String Calcite = "biomight.chemistry.molecule.Calcite";
	public final static String CalciteRef = "Calcite";
	
	public final static String CalciumCarbonate = "biomight.chemistry.molecule.CalciumCarbonate";
	public final static String CalciumCarbonateRef = "CalciumCarbonate";
	
	public final static String CalciumPhosphate = "biomight.chemistry.molecule.CalciumPhosphate";
	public final static String CalciumPhosphateRef = "CalciumPhosphate";
	
	public final static String DeoxyCholicAcid = "biomight.chemistry.molecule.DeoxyCholicAcid";
	public final static String DeoxyCholicAcidRef = "DeoxyCholicAcid";
	
	public final static String DiaminobutyricAcid = "biomight.chemistry.molecule.DiaminobutyricAcid";
	public final static String DiaminobutyricAcidRef = "DiaminobutyricAcid";
	
	public final static String DihydroxyindoleCarboxylicAcid = "biomight.chemistry.molecule.DihydroxyindoleCarboxylicAcid";
	public final static String DihydroxyindoleCarboxylicAcidRef = "DihydroxyindoleCarboxylicAcid";

	public final static String ErgoSterol = "biomight.chemistry.molecule.ErgoSterol";
	public final static String ErgoSterolRef = "ErgoSterol";
	
	public final static String GlycoCalyx = "biomight.chemistry.molecule.GlycoCalyx";
	public final static String GlycoCalyxRef = "GlycoCalyx";
	
	public final static String H20 = "biomight.chemistry.molecule.H20";
	public final static String H20Ref = "biomight.chemistry.molecule.H20";
	
	public final static String Heme = "biomight.chemistry.molecule.Heme";
	public final static String HemeRef = "Heme";
	
	public final static String Hemoglobin = "biomight.chemistry.molecule.Hemoglobin";
	public final static String HemoglobinRef = "Hemoglobin";
	
	public final static String Indolequinone = "biomight.chemistry.molecule.Indolequinone";
	public final static String IndolequinoneRef = "Indolequinone";
	
	public final static String Lysozyme = "biomight.chemistry.molecule.Lysozyme";
	public final static String LysozymeRef = "Lysozyme";
	
	public final static String Lysozymes = "biomight.chemistry.molecule.Lysozymes";
	public final static String LysozymesRef = "Lysozymes";
	
	public final static String MagnesiumPhosphate = "biomight.chemistry.molecule.MagnesiumPhosphate";
	public final static String MagnesiumPhosphateRef = "MagnesiumPhosphate";
	
	public final static String Molecule = "biomight.chemistry.molecule.Molecule";
	public final static String MoleculeRef = "Molecule";
	
	public final static String Molecules = "biomight.chemistry.molecule.Molecules";
	public final static String MoleculesRef  = "Molecules";
	
	public final static String Nephrin = "biomight.chemistry.molecule.Nephrin";
	public final static String NephrinRef = "Nephrin";
	
	public final static String PCadherin = "biomight.chemistry.molecule.PCadherin";
	public final static String PCadherinRef = "PCadherin";

	public final static String Pilin = "biomight.chemistry.molecule.Pilin";
	public final static String PilinRef = "Pilin";
	
	public final static String Podocalyxin = "biomight.chemistry.molecule.Podocalyxin";
	public final static String PodocalyxinRef = "Podocalyxin";

	public final static String Retinal = "biomight.chemistry.molecule.Retinal";
	public final static String RetinalRef = "Retinal";
	
	public final static String Salt = "biomight.chemistry.molecule.Salt";
	public final static String SaltRef = "Salt";

	public final static String SodiumGlycoCholate = "biomight.chemistry.molecule.SodiumGlycoCholate";
	public final static String SodiumGlycoCholateRef = "SodiumGlycoCholate";
	
	public final static String SodiumTauroCholate = "biomight.chemistry.molecule.SodiumTauroCholate";
	public final static String SodiumTauroCholateRef = "SodiumTauroCholate";
	
	public final static String TauroCholicAcid = "biomight.chemistry.molecule.TauroCholicAcid";
	public final static String TauroCholicAcidRef = "TauroCholicAcid";
	
	public final static String Thiocyanate = "biomight.chemistry.molecule.Thiocyanate";
	public final static String ThiocyanateRef = "Thiocyanate";
	
	public final static String TransPeptidase = "biomight.chemistry.molecule.TransPeptidase";
	public final static String TransPeptidaseRef = "TransPeptidase";
	
	public final static String Curlin = "biomight.chemistry.secretion.Curlin";
	public final static String CurlinRef = "Curlin";

	public final static String Curlins = "biomight.chemistry.secretion.Curlins";
	public final static String CurlinsRef = "Curlins";

	// biomight.chemistry.molecule.electrolyte
	public final static String Electrolyte = "biomight.chemistry.molecule.electrolyte.Electrolyte";
	public final static String Electrolytes = "biomight.chemistry.molecule.electrolyte.Electrolytes";

	// biomight.chemistry.molecule.neurotransmitter
	public final static String Neurotransmitters = "biomight.chemistry.molecule.neurotransmitter.Neurotransmitters";
	public final static String NeurotransmittersRef = "Neurotransmitters";

	public final static String Neurotransmitter = "biomight.chemistry.molecule.neurotransmitter.Neurotransmitter";
	public final static String NeurotransmitterRef = "Neurotransmitter";
	
	// biomight.chemistry.molecule.polymer
	public final static String Eumelanin = "biomight.chemistry.molecule.polymer.Eumelanin";
	
	public final static String Melanin = "biomight.chemistry.molecule.polymer.Melanin";
	
	public final static String Neuromelanin = "biomight.chemistry.molecule.polymer.Neuromelanin";
	
	public final static String Pheomelanin = "biomight.chemistry.molecule.polymer.Pheomelanin";
	
	public final static String Polymers = "biomight.chemistry.molecule.polymer.Polymers";

	// biomight.chemistry.nucleicacid
	public final static String DNA = "biomight.chemistry.nucleicacid.DNA";
	public final static String DNARef = "DNA";

	public final static String DNAs = "biomight.chemistry.nucleicacid.DNAs";
	public final static String DNAsRef = "DNAs";
	
	public final static String DNABuilder = "biomight.chemistry.nucleicacid.DNABuilder";
	public final static String NucleicAcid = "biomight.chemistry.nucleicacid.NucleicAcid";
	
	public final static String RNAs = "biomight.chemistry.nucleicacid.RNAs";
	public final static String RNAsRef = "RNAs";
	
	public final static String RNA = "biomight.chemistry.nucleicacid.RNA";
	public final static String RNARef = "RNA";

	public final static String RNABuilder = "biomight.chemistry.nucleicacid.RNABuilder";

	public final static String NucleotideBuilder = "biomight.chemistry.nucleicacid.nucleotide.NucleotideBuilder";

	public final static String Nucleotides  = "biomight.chemistry.nucleicacid.nucleotide.Nucleotides";
	public final static String NucleotidesRef  = "Nucleotides";

	public final static String Nucleotide = "biomight.chemistry.nucleicacid.nucleotide.Nucleotide";
	public final static String NucleotideRef  = "Nucleotide";

	public final static String Nucleobases = "biomight.chemistry.nucleicacid.nucleotide.Nucleobases";
	public final static String NucleobasesRef  = "Nucleobases";
	
	public final static String Nucleobase = "biomight.chemistry.nucleicacid.nucleotide.Nucleobase";
	public final static String NucleobaseRef  = "Nucleobase";

	// biomight.chemistry.nucleicacid.nucleotide
	public final static String Adenine  = "biomight.chemistry.nucleicacid.nucleotide.Adenine";
	public final static String AdenineRef  = "Adenine";

	public final static String Cytosine = "biomight.chemistry.nucleicacid.nucleotide.Cytosine";
	public final static String CytosineRef = "Cytosine";
	
	public final static String Guanine  = "biomight.chemistry.nucleicacid.nucleotide.Guanine";
	public final static String GuanineRef  = "Guanine";

	public final static String Thymine  = "biomight.chemistry.nucleicacid.nucleotide.Thymine";
	public final static String ThymineRef  = "Thymine";

	public final static String Uracil   = "biomight.chemistry.nucleicacid.nucleotide.Uracil";
	public final static String UracilRef   = "Uracil";

	public final static String NucleosideBuilder = "biomight.chemistry.nucleicacid.nucleotide.NucleosideBuilder";
	
	public final static String Nucleosides = "biomight.chemistry.nucleicacid.nucleotide.Nucleosides";
	public final static String NucleosidesRef = "Nucleosides";
	
	public final static String Nucleoside = "biomight.chemistry.nucleicacid.nucleotide.Nucleoside";
	public final static String NucleosideRef = "Nucleoside";
	
	public final static String Prymadines = "biomight.chemistry.nucleicacid.nucleotide.Prymadines";
	public final static String Purines = "biomight.chemistry.nucleicacid.nucleotide.Purines";

	// biomight.chemistry.nucleicacid.nucleotide.rna
	//public final static String RNA = "biomight.chemistry.nucleicacid.nucleotide.rna.RNA";
	public final static String RnaFactory = "biomight.chemistry.nucleicacid.nucleotide.rna.RnaFactory";
	
	// biomight.chemistry.pharma
	public final static String Alprenolol = "biomight.chemistry.pharma.Alprenolol";
	public final static String AlprenololRef = "Alprenolol";

	public final static String Amitriptyline = "biomight.chemistry.pharma.Amitriptyline";
	public final static String AmitriptylineRef = "Amitriptyline";

	public final static String Desipramine = "biomight.chemistry.pharma.Desipramine";
	public final static String DesipramineRef = "Desipramine";
	
	// biomight.chemistry.pharma.antihelminths
	public final static String Albendazole = "biomight.chemistry.pharma.antihelminths.Albendazole";
	public final static String AlbendazoleRef = "Albendazole";

	public final static String Mebendazole = "biomight.chemistry.pharma.antihelminths.Mebendazole";
	public final static String MebendazoleRef = "Mebendazole";

	// biomight.chemistry.pharma
	public final static String AminoGlycosides = "biomight.chemistry.pharma.antimicrobial.AminoGlycosides";
	public final static String AminoGlycosidesRef = "AminoGlycosides";

	public final static String Amoxicillin = "biomight.chemistry.pharma.antimicrobial.Amoxicillin";
	public final static String AmoxicillinRef = "Amoxicillin";
	
	public final static String AmphotericinB = "biomight.chemistry.pharma.antimicrobial.AmphotericinB";
	public final static String AmphotericinBRef = "AmphotericinB";
	
	public final static String Ampicillin = "biomight.chemistry.pharma.antimicrobial.Ampicillin";
	public final static String AmpicillinRef = "Ampicillin";
	
	public final static String AqueousPenicillinG = "biomight.chemistry.pharma.antimicrobial.AqueousPenicillinG";
	public final static String AqueousPenicillinGRef = "AqueousPenicillinG";
	
	public final static String Aziocillin = "biomight.chemistry.pharma.antimicrobial.Aziocillin";
	public final static String AziocillinRef = "Aziocillin";
	
	public final static String Azithromycin = "biomight.chemistry.pharma.antimicrobial.Azithromycin";
	public final static String AzithromycinRef = "Azithromycin";
	
	public final static String Azoles = "biomight.chemistry.pharma.antimicrobial.Azoles";
	public final static String AzolesRef = "Azoles";
	
	public final static String Bacitracin = "biomight.chemistry.pharma.antimicrobial.Bacitracin";
	public final static String BacitracinRef = "Bacitracin";
	
	public final static String BenzathinePenicillinG = "biomight.chemistry.pharma.antimicrobial.BenzathinePenicillinG";
	public final static String BenzathinePenicillinGRef = "BenzathinePenicillinG";
	
	public final static String Carbapenems = "biomight.chemistry.pharma.antimicrobial.Carbapenems";
	public final static String CarbapenemsRef = "Carbapenems";
	
	public final static String Carbenicillin = "biomight.chemistry.pharma.antimicrobial.Carbenicillin";
	public final static String CarbenicillinRef = "Carbenicillin";

	public final static String Caspofungin = "biomight.chemistry.pharma.antimicrobial.Caspofungin";
	public final static String CaspofunginRef = "Caspofungin";
	
	public final static String Cefaclor = "biomight.chemistry.pharma.antimicrobial.Cefaclor";
	public final static String CefaclorRef = "biomight.chemistry.pharma.antimicrobial.Cefaclor";
	
	public final static String Cefadroxil = "biomight.chemistry.pharma.antimicrobial.Cefadroxil";
	public final static String CefadroxilRef = "Cefadroxil";
	
	public final static String Cefamandole = "biomight.chemistry.pharma.antimicrobial.Cefamandole";
	
	public final static String Cefazolin = "biomight.chemistry.pharma.antimicrobial.Cefazolin";
	
	public final static String Cefdinir = "biomight.chemistry.pharma.antimicrobial.Cefdinir";
	
	public final static String Cefepim = "biomight.chemistry.pharma.antimicrobial.Cefepim";
	
	public final static String Cefixime = "biomight.chemistry.pharma.antimicrobial.Cefixime";
	
	public final static String Cefmetazole = "biomight.chemistry.pharma.antimicrobial.Cefmetazole";
	
	public final static String Cefonicid = "biomight.chemistry.pharma.antimicrobial.Cefonicid";
	
	public final static String Cefoperazone = "biomight.chemistry.pharma.antimicrobial.Cefoperazone";
	
	public final static String Cefotetan = "biomight.chemistry.pharma.antimicrobial.Cefotetan";
	
	public final static String Cefoxitin = "biomight.chemistry.pharma.antimicrobial.Cefoxitin";
	
	public final static String Ceftazidime = "biomight.chemistry.pharma.antimicrobial.Ceftazidime";
	
	public final static String Ceftibuten = "biomight.chemistry.pharma.antimicrobial.Ceftibuten";
	public final static String Ceftizoxime = "biomight.chemistry.pharma.antimicrobial.Ceftizoxime";
	public final static String Ceftriaxone = "biomight.chemistry.pharma.antimicrobial.Ceftriaxone";
	public final static String Cefuroxime = "biomight.chemistry.pharma.antimicrobial.Cefuroxime";
	public final static String Cephalexin = "biomight.chemistry.pharma.antimicrobial.Cephalexin";
	public final static String Cephalosporins = "biomight.chemistry.pharma.antimicrobial.Cephalosporins";
	public final static String Cephalothin = "biomight.chemistry.pharma.antimicrobial.Cephalothin";
	public final static String Cephapirin = "biomight.chemistry.pharma.antimicrobial.Cephapirin";
	public final static String Cephradine = "biomight.chemistry.pharma.antimicrobial.Cephradine";
	public final static String Chloramphenicol = "biomight.chemistry.pharma.antimicrobial.Chloramphenicol";
	public final static String Ciprofloxacin = "biomight.chemistry.pharma.antimicrobial.Ciprofloxacin";
	public final static String Clindamycin = "biomight.chemistry.pharma.antimicrobial.Clindamycin";
	public final static String Clotrimazole = "biomight.chemistry.pharma.antimicrobial.Clotrimazole";
	public final static String Cloxacillin = "biomight.chemistry.pharma.antimicrobial.Cloxacillin";
	public final static String Cotrimoxazole = "biomight.chemistry.pharma.antimicrobial.Cotrimoxazole";
	public final static String Cycloserine = "biomight.chemistry.pharma.antimicrobial.Cycloserine";
	public final static String DiCloxacillin = "biomight.chemistry.pharma.antimicrobial.DiCloxacillin";
	public final static String Erythromycin = "biomight.chemistry.pharma.antimicrobial.Erythromycin";
	public final static String Fluconazole = "biomight.chemistry.pharma.antimicrobial.Fluconazole";
	public final static String Flucytosine = "biomight.chemistry.pharma.antimicrobial.Flucytosine";
	public final static String Isonaizid = "biomight.chemistry.pharma.antimicrobial.Isonaizid";
	public final static String Linezolid = "biomight.chemistry.pharma.antimicrobial.Linezolid";
	public final static String Methacillin = "biomight.chemistry.pharma.antimicrobial.Methacillin";
	public final static String Mezlocillin = "biomight.chemistry.pharma.antimicrobial.Mezlocillin";
	public final static String Monobactams = "biomight.chemistry.pharma.antimicrobial.Monobactams";
	public final static String Moxalactam = "biomight.chemistry.pharma.antimicrobial.Moxalactam";
	public final static String Nafcillin = "biomight.chemistry.pharma.antimicrobial.Nafcillin";
	public final static String Nystatin = "biomight.chemistry.pharma.antimicrobial.Nystatin";
	public final static String Oxacillin = "biomight.chemistry.pharma.antimicrobial.Oxacillin";
	public final static String Penicillin = "biomight.chemistry.pharma.antimicrobial.Penicillin";
	public final static String PenicillinG = "biomight.chemistry.pharma.antimicrobial.PenicillinG";
	public final static String PenicillinV = "biomight.chemistry.pharma.antimicrobial.PenicillinV";
	public final static String PentAmidine = "biomight.chemistry.pharma.antimicrobial.PentAmidine";
	public final static String Piperacillin = "biomight.chemistry.pharma.antimicrobial.Piperacillin";
	public final static String PolymixinE = "biomight.chemistry.pharma.antimicrobial.PolymixinE";
	public final static String Polymyxins = "biomight.chemistry.pharma.antimicrobial.Polymyxins";
	public final static String ProcainePenicillinG = "biomight.chemistry.pharma.antimicrobial.ProcainePenicillinG";
	public final static String Quinolones = "biomight.chemistry.pharma.antimicrobial.Quinolones";
	public final static String Rifampin = "biomight.chemistry.pharma.antimicrobial.Rifampin";
	public final static String Spectinomycin = "biomight.chemistry.pharma.antimicrobial.Spectinomycin";
	public final static String Streptomycin = "biomight.chemistry.pharma.antimicrobial.Streptomycin";
	public final static String SulfonAmides = "biomight.chemistry.pharma.antimicrobial.SulfonAmides";
	public final static String Tetracycline = "biomight.chemistry.pharma.antimicrobial.Tetracycline";
	public final static String Tetracyclines = "biomight.chemistry.pharma.antimicrobial.Tetracyclines";
	public final static String Ticarcillin = "biomight.chemistry.pharma.antimicrobial.Ticarcillin";
	public final static String Trimethoprim = "biomight.chemistry.pharma.antimicrobial.Trimethoprim";
	public final static String Vancomycin = "biomight.chemistry.pharma.antimicrobial.Vancomycin";

	// biomight.chemistry.pharma.antiprotozoan
	public final static String PraziQuantel = "biomight.chemistry.pharma.antiprotozoan.PraziQuantel";
	
	// biomight.chemistry.pharma.antiviral
	public final static String Abacavir = "biomight.chemistry.pharma.antiviral.Abacavir";
	public final static String Acyclovir = "biomight.chemistry.pharma.antiviral.Acyclovir";
	public final static String AzidoThymidine = "biomight.chemistry.pharma.antiviral.AzidoThymidine";
	public final static String Delavirdine = "biomight.chemistry.pharma.antiviral.Delavirdine";
	public final static String Didanosine = "biomight.chemistry.pharma.antiviral.Didanosine";
	public final static String DideOxyCytidine = "biomight.chemistry.pharma.antiviral.DideOxyCytidine";
	public final static String DideOxyInosine = "biomight.chemistry.pharma.antiviral.DideOxyInosine";
	public final static String Efavirenz = "biomight.chemistry.pharma.antiviral.Efavirenz";
	public final static String Foscarnet = "biomight.chemistry.pharma.antiviral.Foscarnet";
	public final static String FusionInhibitor = "biomight.chemistry.pharma.antiviral.FusionInhibitor";
	public final static String Ganciclovir = "biomight.chemistry.pharma.antiviral.Ganciclovir";
	public final static String IdoxUridine = "biomight.chemistry.pharma.antiviral.IdoxUridine";
	public final static String InterferonAlpha = "biomight.chemistry.pharma.antiviral.InterferonAlpha";
	public final static String IodoDeoxyUridine = "biomight.chemistry.pharma.antiviral.IodoDeoxyUridine";
	public final static String Lamivudine = "biomight.chemistry.pharma.antiviral.Lamivudine";
	public final static String Lopinavir = "biomight.chemistry.pharma.antiviral.Lopinavir";
	public final static String Nelfinavir = "biomight.chemistry.pharma.antiviral.Nelfinavir";
	public final static String Nevirapine = "biomight.chemistry.pharma.antiviral.Nevirapine";
	public final static String ProteaseInhibitor = "biomight.chemistry.pharma.antiviral.ProteaseInhibitor";
	public final static String RibaVirin = "biomight.chemistry.pharma.antiviral.RibaVirin";
	public final static String Ritonavir = "biomight.chemistry.pharma.antiviral.Ritonavir";
	public final static String Saquinavar = "biomight.chemistry.pharma.antiviral.Saquinavar";
	public final static String Stavudine = "biomight.chemistry.pharma.antiviral.Stavudine";
	public final static String Tenofovir = "biomight.chemistry.pharma.antiviral.Tenofovir";
	public final static String TriFluoroThymidine = "biomight.chemistry.pharma.antiviral.TriFluoroThymidine";
	public final static String Vidarabine = "biomight.chemistry.pharma.antiviral.Vidarabine";
	public final static String Zalcitabine = "biomight.chemistry.pharma.antiviral.Zalcitabine";
	public final static String ZidoVudine = "biomight.chemistry.pharma.antiviral.ZidoVudine";

	// biomight.chemistry.pharma.cholinergicagonist
	public final static String Carbachol = "biomight.chemistry.pharma.cholinergicagonist.Carbachol";
	public final static String Hemicholinium = "biomight.chemistry.pharma.cholinergicagonist.Hemicholinium";
	public final static String Pralidoxime = "biomight.chemistry.pharma.cholinergicagonist.Pralidoxime";

	// biomight.chemistry.pharma.diuretic
	public final static String Acetazolamide = "biomight.chemistry.pharma.diuretic.Acetazolamide";
	public final static String Amiloride = "biomight.chemistry.pharma.diuretic.Amiloride";
	public final static String Bumetanide = "biomight.chemistry.pharma.diuretic.Bumetanide";
	public final static String ChlorThalidone = "biomight.chemistry.pharma.diuretic.ChlorThalidone";
	public final static String EthacrynicAcid = "biomight.chemistry.pharma.diuretic.EthacrynicAcid";
	public final static String Furosemide = "biomight.chemistry.pharma.diuretic.Furosemide";
	public final static String HydroCholoroThiazide = "biomight.chemistry.pharma.diuretic.HydroCholoroThiazide";
	public final static String Indapamide = "biomight.chemistry.pharma.diuretic.Indapamide";
	public final static String Mannitol = "biomight.chemistry.pharma.diuretic.Mannitol";
	public final static String Metolazone = "biomight.chemistry.pharma.diuretic.Metolazone";
	public final static String Torsemide = "biomight.chemistry.pharma.diuretic.Torsemide";
	
	// biomight.chemistry.pharma.drugs
	
	// biomight.chemistry.pharma.laxatives
	public final static String Lactulose = "biomight.chemistry.pharma.laxative.Lactulose";
	public final static String MagnesiumSulfate = "biomight.chemistry.pharma.laxatives.MagnesiumSulfate";

	
	// biomight.chemistry.pharma.lipidemic
	public final static String Atorvastatin = "biomight.chemistry.pharma.lipidemic.Atorvastatin";
	public final static String Cerivastatin = "biomight.chemistry.pharma.lipidemic.Cerivastatin";
	public final static String Cholestyramine = "biomight.chemistry.pharma.lipidemic.Cholestyramine";
	public final static String Clofibrate = "biomight.chemistry.pharma.lipidemic.Clofibrate";
	public final static String Colestipol = "biomight.chemistry.pharma.lipidemic.Colestipol";
	public final static String Fluvastatin = "biomight.chemistry.pharma.lipidemic.Fluvastatin";
	public final static String Gemfibrozil = "biomight.chemistry.pharma.lipidemic.Gemfibrozil";
	public final static String Lovastatin = "biomight.chemistry.pharma.lipidemic.Lovastatin";
	public final static String Niacin = "biomight.chemistry.pharma.lipidemic.Niacin";
	public final static String Pravastatin = "biomight.chemistry.pharma.lipidemic.Pravastatin";
	public final static String Probucol = "biomight.chemistry.pharma.lipidemic.Probucol";
	public final static String Simvastatin = "biomight.chemistry.pharma.lipidemic.Simvastatin";

	// biomight.chemistry.pharma.nueromuscular
	public final static String Atracurium = "biomight.chemistry.pharma.nueromuscular.Atracurium";
	public final static String Doxacurium = "biomight.chemistry.pharma.nueromuscular.Doxacurium";
	public final static String Metocurine = "biomight.chemistry.pharma.nueromuscular.Metocurine";
	public final static String Mivacurium = "biomight.chemistry.pharma.nueromuscular.Mivacurium";
	public final static String Pancuronium = "biomight.chemistry.pharma.nueromuscular.Pancuronium";
	public final static String Pipercuronium = "biomight.chemistry.pharma.nueromuscular.Pipercuronium";
	public final static String Rocuronium = "biomight.chemistry.pharma.nueromuscular.Rocuronium";
	public final static String Succinylcholine = "biomight.chemistry.pharma.nueromuscular.Succinylcholine";
	public final static String Tubocurarine = "biomight.chemistry.pharma.nueromuscular.Tubocurarine";
	public final static String Vecuronium = "biomight.chemistry.pharma.nueromuscular.Vecuronium";
		
	// biomight.chemistry.protein
	public final static String Actin = "biomight.chemistry.protein.Actin";
	public final static String B7Protein = "biomight.chemistry.protein.B7Protein";
	public final static String Collagen = "biomight.chemistry.protein.Collagen";
	public final static String ComplementProtein = "biomight.chemistry.protein.ComplementProtein";
	public final static String ComplementProteinC1 = "biomight.chemistry.protein.ComplementProteinC1";
	public final static String ComplementProteinC1q = "biomight.chemistry.protein.ComplementProteinC1q";
	public final static String ComplementProteinC1r = "biomight.chemistry.protein.ComplementProteinC1r";
	public final static String ComplementProteinC1s = "biomight.chemistry.protein.ComplementProteinC1s";
	public final static String ComplementProteinC2 = "biomight.chemistry.protein.ComplementProteinC2";
	public final static String ComplementProteinC3 = "biomight.chemistry.protein.ComplementProteinC3";
	public final static String ComplementProteinC4 = "biomight.chemistry.protein.ComplementProteinC4";
	public final static String ComplementProteinC5 = "biomight.chemistry.protein.ComplementProteinC5";
	public final static String ComplementProteinC6 = "biomight.chemistry.protein.ComplementProteinC6";
	public final static String ComplementProteinC7 = "biomight.chemistry.protein.ComplementProteinC7";
	public final static String ComplementProteinC8 = "biomight.chemistry.protein.ComplementProteinC8";
	public final static String ComplementProteinC9 = "biomight.chemistry.protein.ComplementProteinC9";
	public final static String ComplementSystem = "biomight.chemistry.protein.ComplementSystem";
	public final static String Elastin = "biomight.chemistry.protein.Elastin";
	public final static String FasProtein = "biomight.chemistry.protein.FasProtein";

	public final static String Fibrins = "biomight.chemistry.protein.Fibrins";
	public final static String FibrinsRef = "Fibrins";

	public final static String Fibrin = "biomight.chemistry.protein.Fibrin";
	public final static String FibrinRef = "Fibrin";
	
	public final static String GProtein = "biomight.chemistry.protein.GProtein";
	public final static String Histone = "biomight.chemistry.protein.Histone";
	public final static String HistoneH1 = "biomight.chemistry.protein.HistoneH1";
	public final static String HistoneH2A = "biomight.chemistry.protein.HistoneH2A";
	public final static String HistoneH2B = "biomight.chemistry.protein.HistoneH2B";
	public final static String HistoneH3 = "biomight.chemistry.protein.HistoneH3";
	public final static String HistoneH4 = "biomight.chemistry.protein.HistoneH4";
	public final static String Integrin = "biomight.chemistry.protein.Integrin";
	public final static String IntegrinAlpha1Beta1 = "biomight.chemistry.protein.IntegrinAlpha1Beta1";
	public final static String IntegrinAlpha2Beta1 = "biomight.chemistry.protein.IntegrinAlpha2Beta1";
	public final static String IntegrinAlpha4Beta1 = "biomight.chemistry.protein.IntegrinAlpha4Beta1";
	public final static String IntegrinAlpha5Beta1 = "biomight.chemistry.protein.IntegrinAlpha5Beta1";
	public final static String IntegrinAlpha6Beta1 = "biomight.chemistry.protein.IntegrinAlpha6Beta1";
	public final static String Integrins = "biomight.chemistry.protein.Integrins";
	public final static String Keratin = "biomight.chemistry.protein.Keratin";
	public final static String Lamin = "biomight.chemistry.protein.Lamin";
	public final static String LeukocyteFunctionAssociatedAntigen1 = "biomight.chemistry.protein.LeukocyteFunctionAssociatedAntigen1";
	public final static String LSelectin = "biomight.chemistry.protein.LSelectin";
	public final static String MannanBindingLectin = "biomight.chemistry.protein.MannanBindingLectin";
	public final static String Mucins = "biomight.chemistry.protein.Mucins";
	public final static String MyoGlobin = "biomight.chemistry.protein.MyoGlobin";
	public final static String Myosin = "biomight.chemistry.protein.Myosin";
	public final static String Osteopontin = "biomight.chemistry.protein.Osteopontin";
	public final static String PenicillinBindingProteins = "biomight.chemistry.protein.PenicillinBindingProteins";
	public final static String Properdin = "biomight.chemistry.protein.Properdin";
	public final static String Protein = "biomight.chemistry.protein.Protein";
	public final static String ProteinFactorB = "biomight.chemistry.protein.ProteinFactorB";
	public final static String ProteinFactorD = "biomight.chemistry.protein.ProteinFactorD";
	public final static String ProteinFactorH = "biomight.chemistry.protein.ProteinFactorH";
	public final static String ProteinFactorI = "biomight.chemistry.protein.ProteinFactorI";
	public final static String ProteinFactorIX = "biomight.chemistry.protein.ProteinFactorIX";
	public final static String ProteinFactorV = "biomight.chemistry.protein.ProteinFactorV";
	public final static String ProteinFactorVII = "biomight.chemistry.protein.ProteinFactorVII";
	public final static String ProteinFactorX = "biomight.chemistry.protein.ProteinFactorX";
	public final static String ProteinMASP1 = "biomight.chemistry.protein.ProteinMASP1";
	public final static String ProteinMASP2 = "biomight.chemistry.protein.ProteinMASP2";
	public final static String Selectins = "biomight.chemistry.protein.Selectins";
	public final static String SLCChemokine = "biomight.chemistry.protein.SLCChemokine";
	public final static String SNAREs = "biomight.chemistry.protein.SNAREs";
	public final static String SOCS1Protein = "biomight.chemistry.protein.SOCS1Protein";
	public final static String Thrombospondin = "biomight.chemistry.protein.Thrombospondin";
	public final static String Tubulin = "biomight.chemistry.protein.Tubulin";
	public final static String TubulinAlpha = "biomight.chemistry.protein.TubulinAlpha";
	public final static String TubulinBeta = "biomight.chemistry.protein.TubulinBeta";
	public final static String VascularAddressins = "biomight.chemistry.protein.VascularAddressins";
	public final static String Vimentin = "biomight.chemistry.protein.Vimentin";
	public final static String Vitronectin = "biomight.chemistry.protein.Vitronectin";

	// biomight.chemistry.protein.adhesion
	public final static String AdhesionProteins = "biomight.chemistry.protein.adhesion.AdhesionProteins";
	
	// biomight.chemistry.protein.immunity
	public final static String CD152Protein = "biomight.chemistry.protein.immunity.CD152Protein";
	public final static String CD25Protein = "biomight.chemistry.protein.immunity.CD25Protein";
	public final static String CD28Protein = "biomight.chemistry.protein.immunity.CD28Protein";
	public final static String CD34Protein = "biomight.chemistry.protein.immunity.CD34Protein";
	public final static String CD3Protein = "biomight.chemistry.protein.immunity.CD3Protein";
	public final static String CD45Protein = "biomight.chemistry.protein.immunity.CD45Protein";
	public final static String CD4Protein = "biomight.chemistry.protein.immunity.CD4Protein";
	public final static String CD5Protein = "biomight.chemistry.protein.immunity.CD5Protein";
	public final static String CD72Protein = "biomight.chemistry.protein.immunity.CD72Protein";
	public final static String CD80Protein = "biomight.chemistry.protein.immunity.CD80Protein";
	public final static String CD86Protein = "biomight.chemistry.protein.immunity.CD86Protein";
	public final static String CD8Protein = "biomight.chemistry.protein.immunity.CD8Protein";
	public final static String ClusterOfDifferentiation = "biomight.chemistry.protein.immunity.ClusterOfDifferentiation";

	// biomight.chemistry.protein.opsin
	public final static String Cyanopsin = "biomight.chemistry.opsin.Cyanopsin";
	public final static String Iodopsin = "biomight.chemistry.opsin.Iodopsin";
	public final static String LWSOpsin = "biomight.chemistry.opsin.LWSOpsin";
	public final static String MWSOpsin = "biomight.chemistry.opsin.MWSOpsin";
	public final static String Opsin = "biomight.chemistry.opsin.Opsin";
	public final static String Porphyropsin = "biomight.chemistry.opsin.Porphyropsin";
	public final static String SWS1Opsin = "biomight.chemistry.opsin.SWS1Opsin";
	public final static String SWS2Opsin = "biomight.chemistry.opsin.SWS2Opsin";

	// biomight.chemistry.protein.plasma
	public final static String Fibrinogen = "biomight.chemistry.plasma.Fibrinogen";
	public final static String Plasma = "biomight.chemistry.plasma.Plasma";
	public final static String ProThrombin = "biomight.chemistry.plasma.ProThrombin";
	public final static String SerumAlbumin = "biomight.chemistry.plasma.SerumAlbumin";
	public final static String SerumGlobulin = "biomight.chemistry.plasma.SerumGlobulin";

	// biomight.chemistry.secretion
	public final static String Bile = "biomight.chemistry.secretion.Bile";
	public final static String BilePigments = "biomight.chemistry.secretion.BilePigments";
	public final static String BileSalts = "biomight.chemistry.secretion.BileSalts";
	public final static String IsosmoticFluid = "biomight.chemistry.secretion.IsosmoticFluid";
	public final static String Mucus = "biomight.chemistry.secretion.Mucus";
	public final static String PleuralFluid = "biomight.chemistry.secretion.PleuralFluid";
	public final static String Saliva = "biomight.chemistry.secretion.Saliva";
	public final static String SalivaryLactoPeroxidase = "biomight.chemistry.secretion.SalivaryLactoPeroxidase";
	public final static String SerousFluid = "biomight.chemistry.secretion.SerousFluid";
	public final static String Sweat = "biomight.chemistry.secretion.Sweat";

	
	// biomight.chemistry.aminoacids.antibodies
	public final static String Antibodies = "biomight.cell.bloodandimmune.Antibodies";
	public final static String AntibodiesRef = "Antibodies";
	
	public final static String Antibody = "biomight.cell.bloodandimmune.Antibody";
	public final static String AntibodyRef = "Antibody";
	 
	 public final static String IgA = "biomight.antibodies.IgA";	
	 public final static String IgD = "biomight.antibodies.IgD";	
	 public final static String IgE = "biomight.antibodies.IgE";	
	 public final static String IgG = "biomight.antibodies.IgG";	
	 public final static String IgM = "biomight.antibodies.IgM";	
	 public final static String MonoclonalAntibody = "biomight.antibodies.MonoclonalAntibody";
	 public final static String PolyclonalAntibody = "biomight.antibodies.PolyclonalAntibody";
	 public final static String AntibodyHeavyChain = "biomight.antibodies.AntibodyHeavyChain";
	 public final static String AntibodyLightChain = "biomight.antibodies.AntibodyLightChain";
	 public final static String AntibodyLambdaLightChain = "biomight.antibodies.AntibodyLambdaLightChain";
	 public final static String AntibodyKappaLightChain = "biomight.antibodies.AntibodyKappaLightChain";		 
	 
	// SUGARS
	public final static String Ribosen   = "biomight.chemistry.carbohydrate.monosaccharide.pentose.Ribosen";
	public final static String RibosenRef   = "Ribosen";

	public final static String Riboses   = "biomight.chemistry.carbohydrate.monosaccharide.pentose.Riboses";
	public final static String RibosesRef   = "Riboses";
	
	public final static String Ribose   = "biomight.chemistry.carbohydrate.monosaccharide.pentose.Ribose";
	public final static String RiboseRef   = "Ribose";

	public final static String DeOxyRibose = "biomight.chemistry.carbohydrate.monosaccharide.pentose.DeOxyRibose";	
	public final static String DeOxyRiboseRef = "DeOxyRibose";	
	
	// DNA & RNA
	
	// Cascades
	public final static String Cascades  = "biomight.cascades.Cascades";

	// Pathwways
	public final static String PathwaysLibrary  = "biomight.pathway";
	public final static String PathwaysLibraryRef  = "PathwaysLibrary";
	
	public final static String Pathway  = "biomight.pathway.Pathway";
	public final static String PathwayRef  = "Pathway";
	
	public final static String Pathways  = "biomight.pathway.Pathways";
	public final static String PathwaysRef  = "Pathways";
	
	public final static String cAMPPathway = "biomight.pathways.Camp";
	public final static String cAMPPathwayRef = "CampPathway";
	
	public final static String MAPKSignalTransductionPathway = "biomight.pathways.MAPKSignalTransductionPathway";
	public final static String MAPKSignalTransductionPathwayRef = "MAPKSignalTransductionPathway";
	
	public final static String Tax1SignalingPathway = "biomight.pathways.Tax1SignalingPathway";
	public final static String Tax1SignalingPathwayRef = "Tax1SignalingPathway";
	
	public final static String ImmuneResponseSignalingPathways = "biomight.pathways.ImmuneResponseSignalingPathways";
	public final static String ImmuneResponseSignalingPathwaysRef = "ImmuneResponseSignalingPathways";

	
	/********************************************************************************
	 * 
	 * VIRUS
	 * 
	 ********************************************************************************/ 
	public final static String VirusLibrary = "biomight.virus.";
	
	public final static String Virus = "biomight.virus.Virus";
	public final static String VirusRef = "Virus";
	
	public final static String Capsid = "biomight.virus.Capsid";
	public final static String CapsidRef = "Capsid";

	public final static String CapsidNeck = "biomight.virus.CapsidNeck";
	public final static String CapsidNeckRef = "CapsidNeck";
	
	public final static String CapsidTail = "biomight.virus.CapsidTail";
	public final static String CapsidTailRef = "CapsidTail";

	public final static String CoreMembrane = "biomight.virus.CoreMembrane";
	public final static String CoreMembraneRef = "CoreMembrane";

	public final static String OuterMembrane = "biomight.virus.OuterMembrane";
	public final static String OuterMembraneRef = "OuterMembrane";
	
	public final static String VirusTail = "biomight.virus.VirusTail";
	public final static String VirusTailRef = "VirusTail";

	public final static String VirusBasePlate = "biomight.virus.VirusBasePlate";
	public final static String VirusBasePlateRef = "VirusBasePlate";

	public final static String VirusTailFibers = "biomight.virus.VirusTailFibers";
	public final static String VirusTailFibersRef = "VirusTailFibers";

	public final static String VirusTailFiber = "biomight.virus.VirusTailFiber";
	public final static String VirusTailFiberRef = "VirusTailFiber";

	public final static String LateralBodies = "biomight.virus.LateralBodies";
	public final static String LateralBodiesRef = "LateralBodies";

	public final static String LateralBody = "biomight.virus.LateralBody";
	public final static String LateralBodyRef = "LateralBody";

	public final static String MembraneTubules = "biomight.virus.MembraneTubules";
	public final static String MembraneTubulesRef = "MembraneTubules";

	public final static String MembraneTubule = "biomight.virus.MembraneTubule";
	public final static String MembraneTubuleRef = "MembraneTubule";	
	
	public final static String VirusTailFiberSegments = "biomight.virus.VirusTailFiberSegments";
	public final static String VirusTailFiberSegmentsRef = "VirusTailFiberSegments";

	public final static String VirusTailFiberSegment = "biomight.virus.VirusTailFiberSegment";
	public final static String VirusTailFiberSegmentRef = "VirusTailFiberSegment";
		
	public final static String Capsomer = "biomight.virus.Capsomer";
	public final static String CapsomerRef = "VIRUS.CAPSOMERE";
	
	public final static String Capsomeres = "biomight.virus.Capsomeres";
	public final static String CapsomeresRef = "VIRUS.CAPSOMERES";
	
	public final static String DNAPolymerase = "biomight.virus.DNAPolymerase";

	public final static String GlycoProteinSpikes = "biomight.virus.GlycoProteinSpikes";
	public final static String GlycoProteinSpikesRef = "GlycoProteinSpikes";
	
	public final static String GlycoProteinSpike = "biomight.virus.GlycoProteinSpike";
	public final static String GlycoProteinSpikeRef = "GlycoProteinSpike";
	
	public final static String HelicalNucleoCapsid = "biomight.virus.HelicalNucleoCapsid";
	
	public final static String HumanImmunoDeficiencyVirus = "biomight.virus.HumanImmunoDeficiencyVirus";
	
	public final static String IcosahedralNucleoCapsid = "biomight.virus.IcosahedralNucleoCapsid";
	
	public final static String LipidEnvelope = "biomight.virus.LipidEnvelope";
	public final static String LipidEnvelopeRef = "LipidEnvelope";
	
	public final static String MatrixProtein = "biomight.virus.MatrixProtein";
	
	public final static String NucleoCapsid = "biomight.virus.NucleoCapsid";
	public final static String NucleoCapsidRef = "NucleoCapsid";
	
	public final static String Prions = "biomight.virus.Prions";
	
	public final static String PseudoVirions = "biomight.virus.PseudoVirions";
	
	public final static String Viroids = "biomight.virus.Viroids";
	

	/********************************************************************************
	 * 
	 * VIRUSES
	 * 
	 ********************************************************************************/ 
	
	public final static String Viruses = "biomight.virus.Viruses";	
	public final static String VirusesRef = "Viruses";	

	public final static String CacheValleyVirus = "biomight.virus.CacheValleyVirus";	
	public final static String CacheValleyVirusRef = "CacheValleyVirus";	
	
	public final static String EnteroVirus = "biomight.virus.rna.EnteroVirus";		
	public final static String EnteroVirusRef = "EnteroVirus";

	public final static String EnteroViruses = "biomight.virus.rna.EnteroViruses";		
	public final static String EnteroVirusesRef = "EnteroViruses";
	
	public final static String HendraVirus = "biomight.virus.HendraVirus";	
	public final static String HendraVirusRef = "HendraVirus";	

	public final static String InfluenzaAViruses = "biomight.virus.InfluenzaAViruses";	
	public final static String InfluenzaAVirusesRef = "InfluenzaAViruses";
	
	public final static String InfluenzaAVirus = "biomight.virus.InfluenzaAVirus";	
	public final static String InfluenzaAVirusRef = "InfluenzaAVirus";
	
	public final static String LassaFeverVirus = "biomight.virus.LassaFeverVirus";	
	public final static String LassaFeverVirusRef = "LassaFeverVirus";	
	
	public final static String LymphocyticChorioMeningitisVirus = "biomight.virus.LymphocyticChorioMeningitisVirus";	
	public final static String LymphocyticChorioMeningitisVirusRef = "LymphocyticChorioMeningitisVirus";	
	
	public final static String MolluscumContagiosumVirus = "biomight.virus.MolluscumContagiosumVirus";	
	public final static String MolluscumContagiosumVirusRef = "MolluscumContagiosumVirus";	
	
	public final static String NipahVirus = "biomight.virus.NipahVirus";	
	public final static String NipahVirusRef = "NipahVirus";	

	public final static String NipahViruses = "biomight.virus.NipahViruses";	
	public final static String NipahVirusesRef = "NipahViruses";	
	
	public final static String WhitewaterArroyoVirus = "biomight.virus.WhitewaterArroyoVirus";	
	public final static String WhitewaterArroyoVirusRef = "WhitewaterArroyoVirus";	

	public final static String AstroViruses = "biomight.virus.AstroViruses";	
	public final static String AstroVirusesRef = "AstroViruses";
	
	public final static String AstroVirus = "biomight.virus.AstroVirus";	
	public final static String AstroVirusRef = "AstroVirus";	
	
	public final static String Calicivirus = "biomight.virus.Calicivirus";	
	public final static String CalicivirusRef = "Calicivirus";	
	
	public final static String CircoVirus = "biomight.virus.CircoVirus";	
	public final static String CircoVirusRef = "CircoVirus";	
		
	public final static String Adenoviridae = "biomight.virus.Adenoviridae";	
	public final static String AdenoviridaeRef = "Adenoviridae";	
	
	public final static String Adenoviruses = "biomight.virus.dna.Adenoviruses";	
	public final static String AdenovirusesRef = "Adenoviruses";

	public final static String Adenovirus = "biomight.virus.dna.Adenovirus";	
	public final static String AdenovirusRef = "Adenovirus";

	public final static String Bacteriophages = "biomight.virus.dna.Bacteriophages";	
	public final static String BacteriophagesRef = "Bacteriophages";

	public final static String Bacteriophage = "biomight.virus.dna.Bacteriophage";	
	public final static String BacteriophageRef = "Bacteriophage";
	
	// DNA VIRUSES
	public final static String CytoMegaloVirus = "biomight.virus.dna.CytoMegaloVirus";		
	public final static String CytoMegaloVirusRef = "CytoMegaloVirus";		
	
	public final static String EpsteinBarrVirus = "biomight.virus.dna.EpsteinBarrVirus";
	public final static String EpsteinBarrVirusRef = "EpsteinBarrVirus";
	
	public final static String HepadnaVirus = "biomight.virus.dna.HepadnaVirus";		
	public final static String HepadnaVirusRef = "HepadnaVirus";		
	
	public final static String HerpesSimplexVirus1 = "biomight.virus.dna.HerpesSimplexVirus1";		
	public final static String HerpesSimplexVirus1Ref = "HerpesSimplexVirus1";		
	
	public final static String HerpesSimplexVirus2 = "biomight.virus.dna.HerpesSimplexVirus2";		
	public final static String HerpesSimplexVirus2Ref = "HerpesSimplexVirus2";		
	
	public final static String HerpesVirus = "biomight.virus.dna.HerpesVirus";		
	public final static String HerpesVirusRef = "HerpesVirus";		
	
	public final static String HumanHerpesVirus6 = "biomight.virus.dna.HumanHerpesVirus6";		
	public final static String HumanHerpesVirus6Ref = "HumanHerpesVirus6";		
	
	public final static String HumanHerpesVirus8 = "biomight.virus.dna.HumanHerpesVirus8";		
	public final static String HumanHerpesVirus8Ref = "HumanHerpesVirus8";		

	public final static String NoroVirus = "biomight.virus.rna.NoroVirus";		
	public final static String NoroVirusRef = "NoroVirus";		
	
	public final static String NoroViruses = "biomight.virus.rna.NoroViruses";		
	public final static String NoroVirusesRef = "NoroViruses";
	
	public final static String PapovaViridae = "biomight.virus.dna.PapovaViridae";		
	public final static String PapovaViridaeRef = "PapovaViridae";		
	
	public final static String PapoViruses = "biomight.virus.dna.PapoViruses";		
	public final static String PapoVirusesRef = "PapoViruses";		
	
	public final static String ParvoVirus = "biomight.virus.dna.ParvoVirus";		
	public final static String ParvoVirusRef = "ParvoVirus";		
	
	public final static String ParvoViruses = "biomight.virus.dna.ParvoViruses";		
	public final static String ParvoVirusesRef = "ParvoViruses";		

	public final static String PoxViruses = "biomight.virus.dna.PoxViruses";		
	public final static String PoxVirusesRef = "PoxViruses";
	
	public final static String PoxVirus = "biomight.virus.dna.PoxVirus";		
	public final static String PoxVirusRef = "PoxVirus";		
	
	public final static String PalisadeLayer = "biomight.virus.dna.PalisadeLayer";		
	public final static String PalisadeLayerRef = "PalisadeLayer";

	public final static String PalisadeProteins = "biomight.chemistry.protein.PalisadeProteins";		
	public final static String PalisadeProteinsRef = "PalisadeProteins";
	
	public final static String PalisadeProtein = "biomight.chemistry.protein.PalisadeProtein";		
	public final static String PalisadeProteinRef = "PalisadeProtein";
	
	public final static String PoxViridae = "biomight.virus.dna.PoxViridae";		
	public final static String PoxViridaeRef = "PoxViridae";		
	
	public final static String Vaccinia = "biomight.virus.dna.Vaccinia";
	public final static String VacciniaRef = "Vaccinia";
	
	public final static String VaricellaZosterVirus = "biomight.virus.dna.VaricellaZosterVirus";
	public final static String VaricellaZosterViruRefs = "VaricellaZosterVirus";
	
	public final static String Echovirus = "biomight.virus.dna.Echovirus";
	public final static String EchovirusRef = "biomight.virus.dna.Echovirus";
		
	public final static String PapillomaVirus = "biomight.virus.dna.PapillomaVirus";
	public final static String PapillomaVirusRef = "PapillomaVirus";
	
	public final static String CoxsackieA = "biomight.virus.dna.CoxsackieA";
	public final static String CoxsackieARef = "CoxsackieA";
	
	public final static String HepatitisAVirus = "biomight.virus.dna.HepatitisAVirus";		
	public final static String HepatitisAVirusRef = "HepatitisAVirus";		
	
	public final static String HepatitisBVirus = "biomight.virus.dna.HepatitisBVirus";	
	public final static String HepatitisBVirusRef = "HepatitisBVirus";	
	
	public final static String HepatitisDVirus = "biomight.virus.dna.HepatitisDVirus";	
	public final static String HepatitisDVirusRef = "HepatitisDVirus";	
	
	public final static String HepatitisEVirus = "biomight.virus.dna.HepatitisEVirus";	
	public final static String HepatitisEVirusRef = "HepatitisEVirus";	
	
	public final static String PolioVirus = "biomight.virus.dna.PolioVirus";	
	public final static String PolioVirusRef = "PolioVirus";	
	
	public final static String BKVirus = "biomight.virus.dna.BKVirus";	
	public final static String BKVirusRef = "BKVirus";	
	
	public final static String JCVirus = "biomight.virus.dna.JCVirus";	
	public final static String JCVirusRef = "JCVirus";	
	
	
	// RNA VIRUSES
	public final static String ArenaVirus = "biomight.virus.rna.ArenaVirus";	
	public final static String ArenaVirusRef = "ArenaVirus";	
	
	public final static String BunyaVirus = "biomight.virus.rna.BunyaVirus";
	public final static String BunyaVirusRef = "BunyaVirus";
	
	public final static String CaliciViruses = "biomight.virus.rna.CaliciViruses";
	public final static String CaliciVirusesRef = "CaliciViruses";
	
	public final static String CoronaVirus = "biomight.virus.rna.CoronaVirus";
	public final static String CoronaVirusRef = "CoronaVirus";
	
	public final static String DeltaVirus = "biomight.virus.rna.DeltaVirus";
	public final static String DeltaVirusRef = "DeltaVirus";
	
	public final static String DengueVirus = "biomight.virus.rna.DengueVirus";
	public final static String DengueVirusRef = "DengueVirus";
	
	public final static String EbolaVirus = "biomight.virus.rna.EbolaVirus";
	public final static String EbolaVirusRef = "EbolaVirus";
	
	public final static String Filoviridae = "biomight.virus.rna.Filoviridae";
	public final static String FiloviridaeRef = "Filoviridae";
	
	public final static String FiloVirus = "biomight.virus.rna.FiloVirus";
	public final static String FiloVirusRef = "FiloVirus";
	
	public final static String FlaviVirus = "biomight.virus.rna.FlaviVirus";
	public final static String FlaviVirusRef = "FlaviVirus";
	
	public final static String HantaVirus= "biomight.virus.rna.HantaVirus";
	public final static String HantaVirusRef = "biomight.virus.rna.HantaVirus";
	
	public final static String HepatitisCVirus = "biomight.virus.rna.HepatitisCVirus";
	public final static String HepatitisCVirusRef  = "HepatitisCVirus";
	
	public final static String HepatitisDeltaVirus = "biomight.virus.rna.HepatitisDeltaVirus";
	public final static String HepatitisDeltaVirusRef  = "HepatitisDeltaVirus";
	
	public final static String JapaneseEncephalitisVirus = "biomight.virus.rna.JapaneseEncephalitisVirus";
	public final static String JapaneseEncephalitisVirusRef  = "JapaneseEncephalitisVirus";
	
	public final static String LentiVirus = "biomight.virus.rna.LentiVirus";
	public final static String LentiVirusRef  = "LentiVirus";
	
	public final static String LeukemiaViruses = "biomight.virus.rna.LeukemiaViruses";
	public final static String LeukemiaVirusesRef  = "LeukemiaViruses";
	
	public final static String MarburgVirus = "biomight.virus.rna.MarburgVirus";
	public final static String MarburgVirusRef  = "MarburgVirus";
	
	public final static String MeaslesVirus = "biomight.virus.rna.MeaslesVirus";
	public final static String MeaslesVirusRef  = "MeaslesVirus";
	
	public final static String MumpsVirus = "biomight.virus.rna.MumpsVirus";
	public final static String MumpsVirusRef  = "MumpsVirus";
	
	public final static String OncoVirus = "biomight.virus.rna.OncoVirus";
	public final static String OncoVirusRef  = "OncoVirus";
	
	public final static String OrthomyxoViruses = "biomight.virus.rna.OrthomyxoViruses";
	public final static String OrthomyxoVirusesRef  = "OrthomyxoViruses";
	
	public final static String ParamyxoViruses = "biomight.virus.rna.ParamyxoViruses";
	public final static String ParamyxoVirusesRef  = "ParamyxoViruses";

	public final static String ReoVirus = "biomight.virus.rna.ReoVirus";
	public final static String ReoVirusRef = "ReoVirus";

	public final static String ReoViruses = "biomight.virus.rna.ReoViruses";
	public final static String ReoVirusesRef = "ReoViruses";
	
	public final static String RespiratorySyncytialVirus = "biomight.virus.rna.RespiratorySyncytialVirus";
	public final static String RespiratorySyncytialVirusRef  = "RespiratorySyncytialVirus";
	
	public final static String RetroVirus = "biomight.virus.rna.RetroVirus";
	public final static String RetroVirusRef  = "RetroVirus";
	
	public final static String RetroViruses = "biomight.virus.rna.RetroViruses";
	public final static String RetroVirusesRef  = "RetroViruses";
	
	public final static String Rhabdoviridae = "biomight.virus.rna.Rhabdoviridae";
	public final static String RhabdoviridaeRef  = "Rhabdoviridae";
	
	public final static String RhabdoVirus = "biomight.virus.rna.RhabdoVirus";
	public final static String RhabdoVirusRef = "RhabdoVirus";
	
	public final static String RotaViruses = "biomight.virus.rna.RotaViruses";
	public final static String RotaVirusesRef = "RotaViruses";
	
	public final static String RotaVirus = "biomight.virus.rna.RotaVirus";
	public final static String RotaVirusRef = "RotaVirus";
	
	public final static String RubellaVirus = "biomight.virus.rna.RubellaVirus";
	public final static String RubellaVirusRef = "RubellaVirus";

	public final static String SarcomaVirus = "biomight.virus.rna.SarcomaVirus";
	public final static String SarcomaVirusRef = "SarcomaVirus";
	
	public final static String StLouisEncephalitisVirus = "biomight.virus.rna.StLouisEncephalitisVirus";		
	public final static String StLouisEncephalitisVirusRef = "StLouisEncephalitisVirus";		
	
	public final static String TogaViruses = "biomight.virus.rna.TogaViruses";
	public final static String TogaVirusesRef = "bTogaViruses";
	
	public final static String WestNileVirus = "biomight.virus.rna.WestNileVirus";
	public final static String WestNileVirusRef = "WestNileVirus";
	
	public final static String YellowFeverVirus = "biomight.virus.rna.YellowFeverVirus";
	public final static String YellowFeverVirusRef = "YellowFeverVirus";
	
	// // RNA PICORNAVIRIDAE
	public final static String AphthoVirus = "biomight.virus.rna.picornaviridae.AphthoVirus";
	public final static String AphthoVirusRef = "AphthoVirus";
	
	public final static String CardioVirus = "biomight.virus.rna.picornaviridae.CardioVirus";
	public final static String CardioVirusRef = "CardioVirus";
	
	public final static String CoxsackieBVirus = "biomight.virus.rna.picornaviridae.CoxsackieBVirus";
	public final static String CoxsackieBVirusRef = "CoxsackieBVirus";
	
	public final static String EncephalomyocarditisVirus = "biomight.virus.rna.picornaviridae.EncephalomyocarditisVirus";
	public final static String EncephalomyocarditisVirusRef = "EncephalomyocarditisVirus";
	
	public final static String HepatoVirus = "biomight.virus.rna.picornaviridae.HepatoVirus";
	public final static String HepatoVirusRef = "HepatoVirus";
	
	public final static String MengoVirus = "biomight.virus.rna.picornaviridae.MengoVirus";
	public final static String MengoVirusRef = "MengoVirus";
	
	public final static String RhinoVirus = "biomight.virus.rna.picornaviridae.RhinoVirus";
	public final static String RhinoVirusRef = "RhinoVirus";
	
	public final static String RhinoVirus14 = "biomight.virus.rna.picornaviridae.RhinoVirus14";
	public final static String RhinoVirus14Ref = "RhinoVirus14";
	
	public final static String RhinoVirus1A = "biomight.virus.rna.picornaviridae.RhinoVirus1A";
	public final static String RhinoVirus1ARef = "RhinoVirus1A";

	public final static String AIDSViruses = "biomight.virus.rna.AIDSViruses";
	public final static String AIDSVirusesRef = "AIDSViruses";
	
	public final static String AIDSVirus = "biomight.virus.rna.AIDSVirus";
	public final static String AIDSVirusRef = "AIDSVirus";

	public final static String PicornaVirus = "biomight.virus.rna.PicornaVirus";
	public final static String PicornaVirusRef = "PicornaVirus";

	
	
	/********************************************************************************
	 * 
	 * BACTERIA
	 * 
	 ********************************************************************************/ 	
	
	public final static String BacteriaLibrary = "biomight.bacteria.";

	public final static String BacterialCells = "biomight.bacteria.BacterialCells";
	public final static String BacterialCellsRef = "BacterialCells";
	
	public final static String BacterialCell = "biomight.bacteria.BacterialCell";
	public final static String BacterialCellRef = "BacterialCell";
	
	public final static String Bacteria = "biomight.bacteria.Bacteria";
	public final static String BacteriaRef = "Bacteria";
	
	public final static String Bacterias  = "biomight.bacteria.Bacterias";	
	public final static String BacteriasRef = "Bacterias";
	
	public final static String AeroTolerantOrganisms = "biomight.bacteria.AeroTolerantOrganisms";
	public final static String BacterialCapsule = "biomight.bacteria.BacterialCapsule";
	public final static String BacterialGranule = "biomight.bacteria.BacterialGranule";
	public final static String BacterialPolymerase = "biomight.bacteria.BacterialPolymerase";
	public final static String BacterialRibosome = "biomight.bacteria.BacterialRibosome";
	public final static String BacterialRibosomes = "biomight.bacteria.BacterialRibosomes";
	public final static String BetaLactamase = "biomight.bacteria.BetaLactamase";
	public final static String BetaLactamases = "biomight.bacteria.BetaLactamases";
	
	public final static String BacterialCellWall = "biomight.bacteria.BacterialCellWall";
	public final static String BacterialCellWallRef = "BacterialCellWall";
	
	public final static String ChlamydiaTrachomatis = "biomight.bacteria.ChlamydiaTrachomatis";
	public final static String ChlamydiaTrachomatisRef = "";
	
	public final static String CytoplasmicMembrane = "biomight.bacteria.CytoplasmicMembrane";
	public final static String CytoplasmicMembraneRef = "";
	
	public final static String FacultativeAnaerobes = "biomight.bacteria.FacultativeAnaerobes";
	public final static String FacultativeAnaerobesRef = "";
	
	public final static String FertilityPlasmid = "biomight.bacteria.FertilityPlasmid";
	public final static String FertilityPlasmidRef = "";
	
	public final static String Fimbria = "biomight.bacteria.Fimbria";
	public final static String FimbriaRef = "Fimbria";

	public final static String Fimbriae = "biomight.bacteria.Fimbriae";
	public final static String FimbriaeRef = "Fimbriae";
	
	public final static String Flagellum = "biomight.bacteria.Flagellum";
	public final static String FlagellumRef = "Flagellum";
	
	public final static String Flagella = "biomight.bacteria.Flagella";
	public final static String FlagellaRef = "Flagella";
	
	public final static String GardnerellaVaginalis = "biomight.bacteria.GardnerellaVaginalis";
	public final static String GardnerellaVaginalisRef = "GardnerellaVaginalis";

	public final static String Mesosomes = "biomight.bacteria.Mesosomes";
	public final static String MesosomesRef = "Mesosomes";

	public final static String Mesosome = "biomight.bacteria.Mesosome";
	public final static String MesosomeRef = "Mesosome";
	
	public final static String MicroAerophiles = "biomight.bacteria.MicroAerophiles";
	public final static String MicroAerophilesRef = "MicroAerophiles";
	
	public final static String Morphology = "biomight.bacteria.Morphology";
	public final static String MorphologyRef = "";

	public final static String Nucleoids = "biomight.bacteria.Nucleoids";
	public final static String NucleoidsRef = "Nucleoids";

	public final static String Nucleoid = "biomight.bacteria.Nucleoid";
	public final static String NucleoidRef = "Nucleoid";
	
	public final static String ObligateAerobes = "biomight.bacteria.ObligateAerobes";
	public final static String ObligateAerobesRef = "ObligateAerobes";
	
	public final static String ObligateAnaerobes = "biomight.bacteria.ObligateAnaerobes";
	public final static String ObligateAnaerobesRef = "ObligateAnaerobes";
	
	public final static String Periplasm = "biomight.bacteria.Periplasm";
	public final static String PeriplasmRef = "Periplasm";
	
	public final static String PeriplasmicSpace = "biomight.bacteria.PeriplasmicSpace";
	public final static String PeriplasmicSpaceRef = "PeriplasmicSpace";

	public final static String Pili = "biomight.bacteria.Pili";
	public final static String PiliRef = "Pili";
			
	public final static String Pilus = "biomight.bacteria.Pilus";
	public final static String PilusRef = "Pilus";

	public final static String Plasmids = "biomight.bacteria.Plasmids";
	public final static String PlasmidsRef = "Plasmids";
	
	public final static String Plasmid = "biomight.bacteria.Plasmid";
	public final static String PlasmidRef = "Plasmid";
	
	public final static String PropionBacteriumAcnes = "biomight.bacteria.PropionBacteriumAcnes";
	public final static String PropionBacteriumAcnesRef = "";
	
	public final static String Spore = "biomight.bacteria.Spore";
	public final static String SporeRef = "Spore";
	
	public final static String SubUnit30s = "biomight.bacteria.SubUnit30s";
	public final static String SubUnit30sRef = "";
	
	public final static String SubUnit50s = "biomight.bacteria.SubUnit50s";
	public final static String SubUnit50sRef = "Transposons";
	
	public final static String Transposons = "biomight.bacteria.Transposons";
	public final static String TransposonsRef = "";
	
	public final static String TreponemaPallidums = "biomight.bacteria.spirochete.TreponemaPallidums";
	public final static String TreponemaPallidumsRef = "TreponemaPallidums";
	
	public final static String TreponemaPallidum = "biomight.bacteria.spirochete.TreponemaPallidum";
	public final static String TreponemaPallidumRef = "TreponemaPallidum";
	
	// Bacteria 
	public final static String AcinetobacterBaumanniis = "biomight.bacteria.misc.AcinetobacterBaumanniis";
	public final static String AcinetobacterBaumanniisRef = "AcinetobacterBaumanniis";
	
	public final static String AcinetobacterBaumannii = "biomight.bacteria.misc.AcinetobacterBaumannii";
	public final static String AcinetobacterBaumanniiRef = "AcinetobacterBaumannii";
		
	
	public final static String Actinobacillus = "biomight.bacteria.misc.Actinobacillus";
	public final static String ActinobacillusRef  = "Actinobacillus";
	
	public final static String Aeromonas = "biomight.bacteria.misc.Aeromonas";
	public final static String AeromonasRef  = "Aeromonas";

	public final static String AeromonasHydrophilias = "biomight.bacteria.rods.gramnegative.AeromonasHydrophilias";
	public final static String AeromonasHydrophiliasRef  = "AeromonasHydrophilias";
	
	public final static String AeromonasHydrophilia = "biomight.bacteria.rods.gramnegative.AeromonasHydrophilia";
	public final static String AeromonasHydrophiliaRef  = "AeromonasHydrophilia";
	
	public final static String Alcaligenes = "biomight.bacteria.misc.Alcaligenes";
	public final static String AlcaligenesRef  = "Alcaligenes";

	public final static String AlcaligenesFaecalises = "biomight.bacteria.rods.gramnegative.AlcaligenesFaecalises";
	public final static String AlcaligenesFaecalisesRef  = "AlcaligenesFaecalises";
	
	public final static String AlcaligenesFaecalis = "biomight.bacteria.rods.gramnegative.AlcaligenesFaecalis";
	public final static String AlcaligenesFaecalisRef  = "AlcaligenesFaecalis";
	
	public final static String CorynebacteriumJeikeiums = "biomight.bacteria.rods.grampositive.CorynebacteriumJeikeiums";
	public final static String CorynebacteriumJeikeiumsRef  = "CorynebacteriumJeikeiums";
	
	public final static String CorynebacteriumJeikeium = "biomight.bacteria.rods.grampositive.CorynebacteriumJeikeium";
	public final static String CorynebacteriumJeikeiumRef  = "CorynebacteriumJeikeium";

	public final static String CorynebacteriumMinutissimums = "biomight.bacteria.rods.gramnegative.CorynebacteriumMinutissimums";
	public final static String CorynebacteriumMinutissimumsRef  = "CorynebacteriumMinutissimums";
	
	public final static String CorynebacteriumMinutissimum = "biomight.bacteria.rods.gramnegative.CorynebacteriumMinutissimum";
	public final static String CorynebacteriumMinutissimumRef  = "CorynebacteriumMinutissimum";
	
	public final static String CoxiellaBurnetiis = "biomight.bacteria.rods.gramnegative.CoxiellaBurnetiis";
	public final static String CoxiellaBurnetiisRef  = "CoxiellaBurnetiis";

	public final static String CoxiellaBurnetii = "biomight.bacteria.rods.gramnegative.CoxiellaBurnetii";
	public final static String CoxiellaBurnetiiRef  = "CoxiellaBurnetii";
	
	public final static String ErysipelothrixRhusiopathiae = "biomight.bacteria.misc.ErysipelothrixRhusiopathiae";
	public final static String ErysipelothrixRhusiopathiaeRef  = "ErysipelothrixRhusiopathiae";

	public final static String KlebsiellaPneumoniaes = "biomight.bacteria.misc.KlebsiellaPneumoniaes";
	public final static String KlebsiellaPneumoniaesRef  = "KlebsiellaPneumoniaes";
	
	public final static String KlebsiellaPneumoniae = "biomight.bacteria.misc.KlebsiellaPneumoniae";
	public final static String KlebsiellaPneumoniaeRef  = "KlebsiellaPneumoniae";

	public final static String LegionellaPneumophilas = "biomight.bacteria.misc.LegionellaPneumophilas";
	public final static String LegionellaPneumophilasRef  = "LegionellaPneumophilas";
	
	public final static String LegionellaPneumophila = "biomight.bacteria.misc.LegionellaPneumophila";
	public final static String LegionellaPneumophilaRef  = "LegionellaPneumophila";

	public final static String LeptospiraInterroganses = "biomight.bacteria.misc.LeptospiraInterroganses";
	public final static String LeptospiraInterrogansesRef  = "LeptospiraInterroganses";
	
	public final static String LeptospiraInterrogans = "biomight.bacteria.misc.LeptospiraInterrogans";
	public final static String LeptospiraInterrogansRef  = "LeptospiraInterrogans";
	
	public final static String OrientiaTsutsugamushi = "biomight.bacteria.misc.OrientiaTsutsugamushi";
	public final static String OrientiaTsutsugamushiRef = "OrientiaTsutsugamushi";
	
	public final static String PorphyromonasGingivalis = "biomight.bacteria.misc.PorphyromonasGingivalis";
	public final static String PorphyromonasGingivalisRef  = "PorphyromonasGingivalis";
	
	public final static String PseudomonasPseudomallei = "biomight.bacteria.misc.PseudomonasPseudomallei";
	public final static String PseudomonasPseudomalleiRef  = "PseudomonasPseudomallei";
	
	public final static String RhodococcusEqui = "biomight.bacteria.misc.RhodococcusEqui";
	public final static String RhodococcusEquiRef  = "RhodococcusEqui";
	
	public final static String RickettsiaProwazekii = "biomight.bacteria.misc.RickettsiaProwazekii";
	public final static String RickettsiaProwazekiiRef  = "RickettsiaProwazekii";
	
	public final static String RickettsiaRickettsii = "biomight.bacteria.misc.RickettsiaRickettsii";
	public final static String RickettsiaRickettsiiRef  = "RickettsiaRickettsii";
	
	public final static String SalmonellaEntericas = "biomight.bacteria.rods.gramnegative.SalmonellaEntericas";
	public final static String SalmonellaEntericasRef  = "SalmonellaEntericas";
	
	public final static String SalmonellaEnterica = "biomight.bacteria.rods.gramnegative.SalmonellaEnterica";
	public final static String SalmonellaEntericaRef  = "SalmonellaEnterica";

	public final static String SalmonellaTyphis = "biomight.bacteria.rods.gramnegative.SalmonellaTyphis";
	public final static String SalmonellaTyphisRef  = "SalmonellaTyphis";
	
	public final static String SalmonellaTyphi = "biomight.bacteria.rods.gramnegative.SalmonellaTyphi";
	public final static String SalmonellaTyphiRef  = "SalmonellaTyphi";
	
	public final static String SalmonellaTyphimuriums = "biomight.bacteria.rods.gramnegative.SalmonellaTyphimuriums";
	public final static String SalmonellaTyphimuriumsRef  = "SalmonellaTyphimuriums";
	
	public final static String SalmonellaTyphimurium = "biomight.bacteria.rods.gramnegative.SalmonellaTyphimurium";
	public final static String SalmonellaTyphimuriumRef  = "SalmonellaTyphimurium";
	
	public final static String TropherymaWhippelii = "biomight.bacteria.misc.TropherymaWhippelii";
	public final static String TropherymaWhippeliiRef  = "TropherymaWhippelii";
	
	public final static String YersinaOuterProteins = "biomight.bacteria.misc.YersinaOuterProteins";
	public final static String YersinaOuterProteinsRef  = "YersinaOuterProteins";
	
	public final static String YersiniaEnterocolitica = "biomight.bacteria.misc.YersiniaEnterocolitica";
	public final static String YersiniaEnterocoliticaRef  = "YersiniaEnterocolitica";
	
	public final static String YersiniaPestis = "biomight.bacteria.misc.YersiniaPestis";
	public final static String YersiniaPestisRef  = "YersiniaPestis";
	
	public final static String YersiniaPseudoTuberculosis = "biomight.bacteria.misc.YersiniaPseudoTuberculosis";
	public final static String YersiniaPseudoTuberculosisRef  = "YersiniaPseudoTuberculosis";
	
	public final static String YopJ = "biomight.bacteria.misc.YopJ";
	public final static String YopJRef  = "YopJ";

	
	// biomight.bacteria.pleomorphic.gramnegative
	public final static String BordetellaPertussises = "biomight.bacteria.coccobacillus.gramnegative.BordetellaPertussises";
	public final static String BordetellaPertussisesRef = "BordetellaPertussises";
	
	public final static String BordetellaPertussis = "biomight.bacteria.coccobacillus.gramnegative.BordetellaPertussis";
	public final static String BordetellaPertussisRef = "BordetellaPertussis";

	public final static String FrancisellaTularensis = "biomight.bacteria.cocci.grampositive.FrancisellaTularensis";
	public final static String FrancisellaTularensisRef = "FrancisellaTularensis";
	
	public final static String HaemophilusInfluenzae = "biomight.bacteria.cocci.grampositive.HaemophilusInfluenzae";
	public final static String HaemophilusInfluenzaeRef = "HaemophilusInfluenzae";
		
	// biomight.bacteria.pleomorphic.grampositive
	public final static String Staphylococci = "biomight.bacteria.cocci.grampositive.Staphylococci";
	public final static String StaphylococciRef = "Staphylococci";

	public final static String Staphylococcus = "biomight.bacteria.cocci.grampositive.Staphylococcus";
	public final static String StaphylococcusRef = "Staphylococcus";

	public final static String StaphylococciAureus = "biomight.bacteria.cocci.grampositive.StaphylococciAureus";
	public final static String StaphylococciAureusRef = "StaphylococciAureus";

	public final static String StaphylococcusAureus = "biomight.bacteria.cocci.grampositive.StaphylococcusAureus";
	public final static String StaphylococcusAureusRef = "StaphylococcusAureus";
	
	public final static String StaphylococciEpidermidis = "biomight.bacteria.cocci.grampositive.StaphylococciEpidermidis";
	public final static String StaphylococciEpidermidisRef = "StaphylococciEpidermidis";

	public final static String StaphylococcusEpidermidis = "biomight.bacteria.cocci.grampositive.StaphylococcusEpidermidis";
	public final static String StaphylococcusEpidermidisRef = "StaphylococcusEpidermidis";

	public final static String StaphylococciSaprophyticus = "biomight.bacteria.cocci.grampositive.StaphylococciSaprophyticus";
	public final static String StaphylococciSaprophyticusRef  = "StaphylococciSaprophyticus";

	public final static String StaphylococcusSaprophyticus = "biomight.bacteria.cocci.grampositive.StaphylococcusSaprophyticus";
	public final static String StaphylococcusSaprophyticusRef  = "StaphylococcusSaprophyticus";
	
	public final static String StreptococciAgalactiae = "biomight.bacteria.cocci.grampositive.StreptococciAgalactiae";
	public final static String StreptococciAgalactiaeRef  = "StreptococciAgalactiae";
	
	public final static String StreptococcusAgalactiae = "biomight.bacteria.cocci.grampositive.StreptococcusAgalactiae";
	public final static String StreptococcusAgalactiaeRef  = "StreptococcusAgalactiae";

	public final static String StreptococciAnginosus = "biomight.bacteria.cocci.grampositive.StreptococciAnginosus";
	public final static String StreptococciAnginosusRef  = "StreptococciAnginosus";

	public final static String StreptococcusAnginosus = "biomight.bacteria.cocci.grampositive.StreptococcusAnginosus";
	public final static String StreptococcusAnginosusRef  = "StreptococcusAnginosus";

	public final static String StreptococciSanguinis = "biomight.bacteria.cocci.grampositive.StreptococciSanguinis";
	public final static String StreptococciSanguinisRef = "StreptococciSanguinis";

	public final static String StreptococcusSanguinis = "biomight.bacteria.cocci.grampositive.StreptococcusSanguinis";
	public final static String StreptococcusSanguinisRef = "StreptococcusSanguinis";
	
	public final static String StreptococciBovis = "biomight.bacteria.cocci.grampositive.StreptococciBovis";
	public final static String StreptococciBovisRef = "StreptococciBovis";
	
	public final static String StreptococcusBovis = "biomight.bacteria.cocci.grampositive.StreptococcusBovis";
	public final static String StreptococcusBovisRef = "StreptococcusBovis";
	
	public final static String StreptococciFaecalis = "biomight.bacteria.cocci.grampositive.StreptococciFaecalis";
	public final static String StreptococciFaecalisRef = "StreptococciFaecalis";

	public final static String StreptococcusFaecalis = "biomight.bacteria.cocci.grampositive.StreptococcusFaecalis";
	public final static String StreptococcusFaecalisRef = "StreptococcusFaecalis";

	public final static String StreptococciGordoni = "biomight.bacteria.cocci.grampositive.StreptococciGordoni";
	public final static String StreptococciGordoniRef = "StreptococciGordoni";

	public final static String StreptococcusGordoni = "biomight.bacteria.cocci.grampositive.StreptococcusGordoni";
	public final static String StreptococcusGordoniRef = "StreptococcusGordoni";

	public final static String StreptococciIntermedius = "biomight.bacteria.cocci.grampositive.StreptococciIntermedius";
	public final static String StreptococciIntermediusRef = "StreptococciIntermedius";
	
	public final static String StreptococcusIntermedius = "biomight.bacteria.cocci.grampositive.StreptococcusIntermedius";
	public final static String StreptococcusIntermediusRef = "StreptococcusIntermedius";

	public final static String StreptococciMilleri = "biomight.bacteria.cocci.grampositive.StreptococciMilleri";
	public final static String StreptococciMilleriRef = "StreptococciMilleri";
	
	public final static String StreptococcusMilleri = "biomight.bacteria.cocci.grampositive.StreptococcusMilleri";
	public final static String StreptococcusMilleriRef = "StreptococcusMilleri";

	public final static String StreptococciMitis = "biomight.bacteria.cocci.grampositive.StreptococciMitis";
	public final static String StreptococciMitisRef = "StreptococciMitis";
	
	public final static String StreptococcusMitis = "biomight.bacteria.cocci.grampositive.StreptococcusMitis";
	public final static String StreptococcusMitisRef = "StreptococcusMitis";

	public final static String StreptococciMutans = "biomight.bacteria.cocci.grampositive.StreptococciMutans";
	public final static String StreptococciMutansRef = "StreptococciMutans";

	public final static String StreptococcusMutans = "biomight.bacteria.cocci.grampositive.StreptococcusMutans";
	public final static String StreptococcusMutansRef = "StreptococcusMutans";

	public final static String StreptococciPneumoniae = "biomight.bacteria.cocci.grampositive.StreptococciPneumoniae";
	public final static String StreptococciPneumoniaeRef = "StreptococciPneumoniae";
	
	public final static String StreptococcusPneumoniae = "biomight.bacteria.cocci.grampositive.StreptococcusPneumoniae";
	public final static String StreptococcusPneumoniaeRef = "StreptococcusPneumoniae";

	public final static String StreptococciPyogenes = "biomight.bacteria.cocci.grampositive.StreptococciPyogenes";
	public final static String StreptococciPyogenesRef = "StreptococciPyogenes";
	
	public final static String StreptococcusPyogenes = "biomight.bacteria.cocci.grampositive.StreptococcusPyogenes";
	public final static String StreptococcusPyogenesRef = "StreptococcusPyogenes";
	
	public final static String StreptococciSalivarius = "biomight.bacteria.cocci.grampositive.StreptococciSalivarius";
	public final static String StreptococciSalivariusRef = "StreptococciSalivarius";
	
	public final static String StreptococcusSalivarius = "biomight.bacteria.cocci.grampositive.StreptococcusSalivarius";
	public final static String StreptococcusSalivariusRef = "StreptococcusSalivarius";

	public final static String StreptococciViridans = "biomight.bacteria.cocci.grampositive.StreptococciViridans";
	public final static String StreptococciViridansRef = "StreptococciViridans";
	
	public final static String StreptococcusViridans = "biomight.bacteria.cocci.grampositive.StreptococcusViridans";
	public final static String StreptococcusViridansRef = "StreptococcusViridans";
	
	public final static String Gonococci = "biomight.bacteria.cocci.gramnegative.Gonococci";
	public final static String GonococciRef = "Gonococci";
	
	public final static String Gonococcus = "biomight.bacteria.cocci.gramnegative.Gonococcus";
	public final static String GonococcusRef = "Gonococcus";
	
	public final static String Meningococci = "biomight.bacteria.cocci.gramnegative.Meningococci";
	public final static String MeningococciRef = "Meningococci";
	
	public final static String Meningococcus = "biomight.bacteria.cocci.gramnegative.Meningococcus";
	public final static String MeningococcusRef = "Meningococcus";
	
	// biomight.bacteria.rods.gramnegative
	public final static String CampylobacterJejunis = "biomight.bacteria.spirillum.CampylobacterJejunis";
	public final static String CampylobacterJejunisRef = "CampylobacterJejunis";
	
	public final static String CampylobacterJejuni = "biomight.bacteria.spirillum.CampylobacterJejuni";
	public final static String CampylobacterJejuniRef = "CampylobacterJejuni";

	public final static String eColiStrain0157H7 = "biomight.bacteria.rods.gramnegative.eColiStrain0157H7";
	public final static String eColiStrain0157H7Ref = "eColiStrain0157H7";
	
	public final static String EscherichiaColi = "biomight.bacteria.rods.gramnegative.EscherichiaColi";
	public final static String EscherichiaColiRef = "EscherichiaColi";
	
	public final static String PasteurellaMulticoda = "biomight.bacteria.rods.gramnegative.PasteurellaMulticoda";
	public final static String PasteurellaMulticodaRef = "PasteurellaMulticoda";
	
	public final static String PseudomonasAeruginosa = "biomight.bacteria.rods.gramnegative.PseudomonasAeruginosa";
	public final static String PseudomonasAeruginosaRef = "PseudomonasAeruginosa";
	
	public final static String SalmonellaEnteritidis = "biomight.bacteria.rods.gramnegative.SalmonellaEnteritidis";
	public final static String SalmonellaEnteritidisRef = "SalmonellaEnteritidis";
	
	public final static String Shigella = "biomight.bacteria.rods.gramnegative.Shigella";
	public final static String ShigellaRef = "Shigella";
	
	public final static String ShigellaDysenteriae = "biomight.bacteria.rods.gramnegative.ShigellaDysenteriae";
	public final static String ShigellaDysenteriaeRef = "ShigellaDysenteriae";

	public final static String VibrioCholeraes = "biomight.bacteria.rods.gramnegative.VibrioCholeraes";
	public final static String VibrioCholeraesRef = "VibrioCholeraes";
	
	public final static String VibrioCholerae = "biomight.bacteria.rods.gramnegative.VibrioCholerae";
	public final static String VibrioCholeraeRef = "VibrioCholerae";
	
	public final static String VibrioParahaemolyticus = "biomight.bacteria.rods.gramnegative.VibrioParahaemolyticus";
	public final static String VibrioParahaemolyticusRef = "VibrioParahaemolyticus";
	
	public final static String YerseniaEnterocolitica = "biomight.bacteria.rods.gramnegative.YerseniaEnterocolitica";
	public final static String YerseniaEnterocoliticaRef = "YerseniaEnterocolitica";

	// biomight.bacteria.rods.grampositive
	public final static String AnthraxSpore = "biomight.bacteria.rods.grampositive.AnthraxSpore";
	public final static String AnthraxSporeRef = "AnthraxSpore";

	public final static String AnthraxSpores = "biomight.bacteria.rods.grampositive.AnthraxSpores";
	public final static String AnthraxSporesRef = "AnthraxSpores";
	
	public final static String BacilliAnthracis = "biomight.bacteria.rods.grampositive.BacilliAnthracis";
	public final static String BacilliAnthracisRef = "BacilliAnthracis";
	
	public final static String BacillusAnthracis = "biomight.bacteria.rods.grampositive.BacillusAnthracis";
	public final static String BacillusAnthracisRef = "BacillusAnthracis";

	public final static String BacillICereus = "biomight.bacteria.rods.grampositive.BacillisCereus";
	public final static String BacillICereusRef = "BacillISCereus";
	
	public final static String BacillusCereus = "biomight.bacteria.rods.grampositive.BacillusCereus";
	public final static String BacillusCereusRef = "BacillusCereus";

	public final static String ClostridiumBotulinum = "biomight.bacteria.rods.grampositive.ClostridiumBotulinum";
	public final static String ClostridiumBotulinumRef = "ClostridiumBotulinum";
	
	public final static String ClostridiumDifficile = "biomight.bacteria.rods.grampositive.ClostridiumDifficile";
	public final static String ClostridiumDifficileRef = "ClostridiumDifficile";
	
	public final static String ClostridiumPerfringens = "biomight.bacteria.rods.grampositive.ClostridiumPerfringens";
	public final static String ClostridiumPerfringensRef = "ClostridiumPerfringens";
	
	public final static String ClostridiumTetanis = "biomight.bacteria.rods.grampositive.ClostridiumTetanis";
	public final static String ClostridiumTetanisRef = "ClostridiumTetanis";
	
	public final static String ClostridiumTetani = "biomight.bacteria.rods.grampositive.ClostridiumTetani";
	public final static String ClostridiumTetaniRef = "ClostridiumTetani";
	
	public final static String CoryneBacteriumDiphtheriae = "biomight.bacteria.rods.grampositive.CoryneBacteriumDiphtheriae";
	public final static String CoryneBacteriumDiphtheriaeRef = "CoryneBacteriumDiphtheriae";
	
	public final static String CutaneousAnthrax = "biomight.bacteria.rods.grampositive.CutaneousAnthrax";
	public final static String CutaneousAnthraxRef = "CutaneousAnthrax";
	
	public final static String GastroIntestinalAntrax = "biomight.bacteria.rods.grampositive.GastroIntestinalAntrax";
	public final static String GastroIntestinalAntraxRef = "GastroIntestinalAntrax";
	
	public final static String ListeriaMonocytogenes = "biomight.bacteria.rods.grampositive.ListeriaMonocytogenes";
	public final static String ListeriaMonocytogenesRef = "ListeriaMonocytogenes";
	
	public final static String PulmonaryAnthrax = "biomight.bacteria.rods.grampositive.PulmonaryAnthrax";
	public final static String PulmonaryAnthraxRef = "PulmonaryAnthrax";

	
	// biomight.bacteria.pleomorphs.grampositive	
	public final static String ActinomycesGerencseriae = "biomight.bacteria.pleomorphic.grampositive.ActinomycesGerencseriae";
	public final static String ActinomycesGerencseriaeRef = "ActinomycesGerencseriae";
	
	public final static String MycobacteriumAviumIntracellulareComplex = "biomight.bacteria.pleomorphic.grampositive.MycobacteriumAviumIntracellulareComplex";
	public final static String MycobacteriumAviumIntracellulareComplexRef = "MycobacteriumAviumIntracellulareComplex";
	
	public final static String MycobacteriumBovis = "biomight.bacteria.pleomorphic.grampositive.MycobacteriumBovis";
	public final static String MycobacteriumBovisRef = "MycobacteriumBovis";
	
	public final static String MycobacteriumKansasii = "biomight.bacteria.pleomorphic.grampositive.MycobacteriumKansasii";
	public final static String MycobacteriumKansasiiRef = "MycobacteriumKansasii";
	
	public final static String MycobacteriumLeprae = "biomight.bacteria.pleomorphic.grampositive.MycobacteriumLeprae";
	public final static String MycobacteriumLepraeRef = "MycobacteriumLeprae";
	
	public final static String ActinomycesIsraelii = "biomight.bacteria.pleomorphic.grampositive.ActinomycesIsraelii";
	public final static String ActinomycesIsraeliiRef = "ActinomycesIsraelii";
	
	public final static String MycobacteriumKansasiile = "biomight.bacteria.pleomorphic.grampositive.MycobacteriumKansasiile";
	public final static String MycobacteriumKansasiileRef = "MycobacteriumKansasiile";
	
	public final static String MycobacteriumMarinum = "biomight.bacteria.pleomorphic.grampositive.MycobacteriumMarinum";
	public final static String MycobacteriumMarinumRef = "MycobacteriumMarinum";
	
	public final static String MycobacteriumTuberculosis = "biomight.bacteria.pleomorphic.grampositive.MycobacteriumTuberculosis";
	public final static String MycobacteriumTuberculosisRef = "MycobacteriumTuberculosis";
	
	public final static String PropioniBacteriumPropionicus = "biomight.bacteria.pleomorphic.grampositive.PropioniBacteriumPropionicus";
	public final static String PropioniBacteriumPropionicusRef = "PropioniBacteriumPropionicus";
	
	
	/********************************************************************************
	 * 
	 * MYCOPLASMAS
	 * 
	 ********************************************************************************/ 

	public final static String MycoPlasmaPneumoniae = "biomight.mycoplasma.MycoPlasmaPneumoniae";
	public final static String MycoPlasmaPneumoniaeRef = "MycoPlasmaPneumoniae";
	public final static String MycoPlasmas = "biomight.mycoplasma.MycoPlasmas";
	public final static String MycoPlasma = "biomight.mycoplasma.MycoPlasma";
	
	/********************************************************************************
	 * 
	 * PROTOZOA
	 * 
	 ********************************************************************************/ 

	// biomight.protozoa
	public final static String AcanthamoebaCastellanii = "biomight.protozoa.AcanthamoebaCastellanii";
	public final static String AscarisLumbricoides = "biomight.protozoa.AscarisLumbricoides";
	public final static String BabesiaMicroti = "biomight.protozoa.BabesiaMicroti";
	public final static String BalantidiumColi = "biomight.protozoa.BalantidiumColi";
	public final static String CryptosporidiumParvum = "biomight.protozoa.CryptosporidiumParvum";
	public final static String CyclosporaCayetanensis = "biomight.protozoa.CyclosporaCayetanensis";
	public final static String DiphyllobotriumLatum = "biomight.protozoa.DiphyllobotriumLatum";
	public final static String EntamoebaHistolytica = "biomight.protozoa.EntamoebaHistolytica";
	public final static String EnterobiusVermicularis = "biomight.protozoa.EnterobiusVermicularis";
	public final static String EnterocytozoonBieneusi = "biomight.protozoa.EnterocytozoonBieneusi";
	public final static String GiardiaLamblia = "biomight.protozoa.GiardiaLamblia";
	public final static String IsosporaBelli = "biomight.protozoa.IsosporaBelli";
	public final static String LeishmaniaBraziliensis = "biomight.protozoa.LeishmaniaBraziliensis";
	public final static String LeishmaniaDonovani = "biomight.protozoa.LeishmaniaDonovani";
	public final static String LeishmaniaMexicana = "biomight.protozoa.LeishmaniaMexicana";
	public final static String LeishmaniaTropica = "biomight.protozoa.LeishmaniaTropica";
	public final static String Merozoites = "biomight.protozoa.Merozoites";
	public final static String NaegleriaFowleri = "biomight.protozoa.NaegleriaFowleri";
	public final static String Ookinete = "biomight.protozoa.Ookinete";
	public final static String PlasmodiumFalciparum = "biomight.protozoa.PlasmodiumFalciparum";
	public final static String PlasmodiumMalariae = "biomight.protozoa.PlasmodiumMalariae";
	public final static String PlasmodiumOvale = "biomight.protozoa.PlasmodiumOvale";
	public final static String Protozoa = "biomight.protozoa.Protozoa";
	public final static String SeptataIntestinalis = "biomight.protozoa.SeptataIntestinalis";
	public final static String Sporozoites = "biomight.protozoa.Sporozoites";
	public final static String StrongyloidesStercoralis = "biomight.protozoa.StrongyloidesStercoralis";
	public final static String TaxoplasmaGondii = "biomight.protozoa.TaxoplasmaGondii";
	public final static String TrichinellaSpiralis = "biomight.protozoa.TrichinellaSpiralis";
	public final static String TrichomonasVaginalis = "biomight.protozoa.TrichomonasVaginalis";
	public final static String TrichurisTrichiura = "biomight.protozoa.TrichurisTrichiura";
	public final static String TrypanosomaCruzi = "biomight.protozoa.TrypanosomaCruzi";
	public final static String TrypanosomaGambiense = "biomight.protozoa.TrypanosomaGambiense";
	public final static String TrypanosomaRhodesiense = "biomight.protozoa.TrypanosomaRhodesiense";
	
	/********************************************************************************
	 * 
	 * FUNGUS
	 * 
	 ********************************************************************************/ 
	public final static String AscoSpores = "biomight.fungus.AscoSpores";
	public final static String AspergillusFumigatus = "biomight.fungus.AspergillusFumigatus";
	public final static String BasidioSpores = "biomight.fungus.BasidioSpores";
	public final static String BlastoMycesDermatitidis = "biomight.fungus.BlastoMycesDermatitidis";
	public final static String CandidaAlbicans = "biomight.fungus.CandidaAlbicans";
	public final static String ChromoMycosis = "biomight.fungus.ChromoMycosis";
	public final static String CladosporiumWerneckii = "biomight.fungus.CladosporiumWerneckii";
	public final static String CoccidioidesImmitis = "biomight.fungus.CoccidioidesImmitis";
	public final static String Conidia = "biomight.fungus.Conidia";
	public final static String CryptoCoccusNeoformans = "biomight.fungus.CryptoCoccusNeoformans";
	public final static String Dermatophytoses = "biomight.fungus.Dermatophytoses";
	public final static String Fonsecaea = "biomight.fungus.Fonsecaea";
	public final static String FungiImperfecti = "biomight.fungus.FungiImperfecti";
	public final static String Fungus = "biomight.fungus.Fungus";
	public final static String FusariumSolani = "biomight.fungus.FusariumSolani";
	public final static String HistoplasmaCapsulatum = "biomight.fungus.HistoplasmaCapsulatum";
	public final static String Hyphae = "biomight.fungus.Hyphae";
	public final static String MalasseziaFurfur = "biomight.fungus.MalasseziaFurfur";
	public final static String Molds = "biomight.fungus.Molds";
	public final static String Mycelium = "biomight.fungus.Mycelium";
	public final static String NonSeptateHyphae = "biomight.fungus.NonSeptateHyphae";
	public final static String ParaCoccidioidesBrasiliensis = "biomight.fungus.ParaCoccidioidesBrasiliensis";
	public final static String PenicilliumMarneffei = "biomight.fungus.PenicilliumMarneffei";
	public final static String Phialophora = "biomight.fungus.Phialophora";
	public final static String PneumocystisCarinii = "biomight.fungus.PneumocystisCarinii";
	public final static String PseudallEscheriaBoydii = "biomight.fungus.PseudallEscheriaBoydii";
	public final static String SeptateHyphae = "biomight.fungus.SeptateHyphae";
	public final static String SporothrixSchenckii = "biomight.fungus.SporothrixSchenckii";
	public final static String Sporotrichosis = "biomight.fungus.Sporotrichosis";
	public final static String TineaNigra = "biomight.fungus.TineaNigra";
	public final static String TineaVersicolor = "biomight.fungus.TineaVersicolor";
	public final static String TrichophytonRubrum = "biomight.fungus.TrichophytonRubrum";
	public final static String TuberculateMacroConidia = "biomight.fungus.TuberculateMacroConidia";
	public final static String Yeasts = "biomight.fungus.Yeasts";
	public final static String ZygoSpores = "biomight.fungus.ZygoSpores";

	/********************************************************************************
	 * 
	 * HUMAN CELL
	 * 
	 ********************************************************************************/ 
	
	// biomight.cell
	public final static String CellLibrary = "biomight.cell.";
	public final static String Cell  = "biomight.cell.Cell";	
	public final static String CellRef = "Cell";
	
	public final static String ATPGatedChannel = "biomight.cell.ATPGatedChannel";
	public final static String ATPGatedChannelRef = "";
	
	public final static String BoneMarrowStromalCell = "biomight.cell.BoneMarrowStromalCell";
	public final static String BoneMarrowStromalCellRef = "";
	
	public final static String BoneMarrowStromalCells = "biomight.cell.BoneMarrowStromalCells";
	public final static String BoneMarrowStromalCellsRef = "";
	
	public final static String CalciumActivatedPotassiumChannel = "biomight.cell.CalciumActivatedPotassiumChannel";
	public final static String CalciumActivatedPotassiumChannelRef = "";
	
	public final static String CellMembrane = "biomight.cell.CellMembrane";
	public final static String CellMembraneRef = "CellMembrane";
		
	public final static String CellWall = "biomight.cell.CellWall";
	public final static String CellWallRef = "CellWall";
		
	public final static String ChlorideIonChannel = "biomight.cell.ChlorideIonChannel";
	public final static String ChlorideIonChannelRef = "";
	
	public final static String CyclicNucleotideGatedChannels = "biomight.cell.CyclicNucleotideGatedChannels";
	public final static String CyclicNucleotideGatedChannelsRef = "";
	
	public final static String Cytoskeleton = "biomight.cell.Cytoskeleton";
	public final static String CytoskeletonRef = "";
	
	public final static String Cytosol = "biomight.cell.Cytosol";
	public final static String CytosolRef = "";
	
	public final static String EndoPlasmicReticulum = "biomight.cell.EndoPlasmicReticulum";
	public final static String EndoPlasmicReticulumRef = "EndoPlasmicReticulum";
	
	public final static String EndoPlasmicReticulumRough = "biomight.cell.EndoPlasmicReticulumRough";
	public final static String EndoPlasmicReticulumRoughRef = "EndoPlasmicReticulumRough";
	
	public final static String EndoPlasmicReticulumSmooth = "biomight.cell.EndoPlasmicReticulumSmooth";
	public final static String EndoPlasmicReticulumSmoothRef = "EndoPlasmicReticulumSmooth";
	
	public final static String Endosome = "biomight.cell.Endosome";
	public final static String EndosomeRef = "Endosome";
	
	public final static String Endosomes = "biomight.cell.Endosomes";
	public final static String EndosomesRef = "Endosomes";	

	public final static String GolgiApparatus = "biomight.cell.GolgiApparatus";
	public final static String GolgiApparatusRef = "GolgiApparatus";
	
	public final static String GolgiApparatusFolds = "biomight.cell.GolgiApparatusFolds";
	public final static String GolgiApparatusFoldsRef = "GolgiApparatusFolds";
	
	public final static String GolgiApparatusFold = "biomight.cell.GolgiApparatusFold";
	public final static String GolgiApparatusFoldRef = "GolgiApparatusFold";
	
	public final static String IntermediateCompartment = "biomight.cell.IntermediateCompartment";
	
	public final static String InternalCavityEpith = "biomight.cell.InternalCavityEpith";
	
	public final static String InwardRectifierPotassiumChannel = "biomight.cell.InwardRectifierPotassiumChannel";
	
	public final static String IonChannel = "biomight.cell.IonChannel";
	public final static String IonChannelRef = "IonChannel";
	
	public final static String IonChannels = "biomight.cell.IonChannels";
	public final static String IonChannelsRef = "IonChannels";
	
	public final static String IonPump = "biomight.cell.IonPump";
	public final static String IonPumpRef = "IonPump";
	
	public final static String IonPumps = "biomight.cell.IonPumps";
	public final static String IonPumpsRef = "IonPumps";
	
	public final static String Lysosome = "biomight.cell.Lysosome";
	public final static String LysosomeRef = "Lysosome";
	
	public final static String Lysosomes = "biomight.cell.Lysosomes";
	public final static String LysosomesRef = "Lysosomes";
	
	public final static String Melanosome = "biomight.cell.Melanosome";
	public final static String MelanosomeRef = "Melanosome";
	
	public final static String Melanosomes = "biomight.cell.Melanosomes";
	public final static String MelanosomesRef = "Melanosomes";
	
	public final static String Mitochondria = "biomight.cell.Mitochondria";
	public final static String MitochondriaRef = "Mitochondria";
	
	public final static String Mitochondrion = "biomight.cell.Mitochondrion";
	public final static String MitochondrionRef = "Mitochondrion";
	
	public final static String OlfactoryBasalCells = "biomight.cell.OlfactoryBasalCells";
	public final static String OlfactoryBasalCellsRef = "OlfactoryBasalCells";
	
	public final static String OlfactoryReceptorNeurons = "biomight.cell.OlfactoryReceptorNeurons";
	public final static String OlfactoryReceptorNeuronsRef = "OlfactoryReceptorNeurons";
	
	public final static String OlfactorySupportingCells = "biomight.cell.OlfactorySupportingCells";
	public final static String OlfactorySupportingCellsRef = "OlfactorySupportingCells";
	
	public final static String Peroxisome = "biomight.cell.Peroxisome";
	public final static String PeroxisomeRef = "Peroxisome";
	
	public final static String Peroxisomes = "biomight.cell.Peroxisomes";
	public final static String PeroxisomesRef = "Peroxisomes";
	
	public final static String PontineNuclei = "biomight.cell.PontineNuclei";
	public final static String PontineNucleiRef = "PontineNuclei";
	
	public final static String PotassiumIonChannel = "biomight.cell.PotassiumIonChannel";
	public final static String PotassiumIonChannelRef = "PotassiumIonChannel";
	
	public final static String Ribosome = "biomight.cell.Ribosome";
	public final static String RibosomeRef = "Ribosome";
	
	public final static String Ribosomes = "biomight.cell.Ribosomes";
	public final static String RibosomesRef = "Ribosomes";
	
	public final static String SecretoryVesicle = "biomight.cell.SecretoryVesicle";
	public final static String SecretoryVesicleRef = "SecretoryVesicle";
	
	public final static String SodiumSelectiveIonChannel = "biomight.cell.SodiumSelectiveIonChannel";
	public final static String SodiumSelectiveIonChannelRef = "SodiumSelectiveIonChannel";
	
	public final static String SynapticRibbon = "biomight.cell.SynapticRibbon";
	public final static String SynapticRibbonRef = "SynapticRibbon";
	
	public final static String TandemPoreDomainPotassiumChannel = "biomight.cell.TandemPoreDomainPotassiumChannel";
	public final static String TandemPoreDomainPotassiumChannelRef = "";
	
	public final static String TransientReceptorPotentialChannel = "biomight.cell.TransientReceptorPotentialChannel";
	public final static String TransientReceptorPotentialChannelRef = "";
	
	public final static String TransientReceptorPotentialChannels = "biomight.cell.TransientReceptorPotentialChannels";
	public final static String TransientReceptorPotentialChannelsRef = "";
	
	public final static String VoltageGatedCalciumChannel = "biomight.cell.VoltageGatedCalciumChannel";
	public final static String VoltageGatedCalciumChannelRef = "";
	
	public final static String VoltageGatedIonChannel = "biomight.cell.VoltageGatedIonChannel";
	public final static String VoltageGatedIonChannelRef = "VoltageGatedIonChannel";
	
	public final static String VoltageGatedIonChannels = "biomight.cell.VoltageGatedIonChannels";
	public final static String VoltageGatedIonChannelsRef = "VoltageGatedIonChannels";
	
	public final static String VoltageGatedPotassiumChannel = "biomight.cell.VoltageGatedPotassiumChannel";
	public final static String VoltageGatedPotassiumChannelRef = "VoltageGatedPotassiumChannel";
	
	public final static String VoltageGatedSodiumChannel = "biomight.cell.VoltageGatedSodiumChannel";
	public final static String VoltageGatedSodiumChannelRef = "VoltageGatedSodiumChannel";

	// biomight.cell.nuclei
	public final static String Nuclei = "biomight.cell.nucleus.Nuclei";
	public final static String NucleiRef = "Nuclei";

	public final static String Nucleus = "biomight.cell.nucleus.Nucleus";
	public final static String NucleusRef = "Nucleus";
	
	public final static String Centriole = "biomight.cell.nucleus.Centriole";
	public final static String CentrioleRef = "";
	
	public final static String Centrioles = "biomight.cell.nucleus.Centrioles";
	public final static String CentriolesRef = "";
	
	public final static String Centrosome = "biomight.cell.nucleus.Centrosome";
	public final static String CentrosomeRef = "";
	
	public final static String Chromatin = "biomight.cell.nucleus.Chromatin";
	public final static String ChromatinRef = "";
	
	public final static String EuChromatin = "biomight.cell.nucleus.EuChromatin";
	public final static String EuChromatinRef = "";
	
	public final static String Gene = "biomight.cell.nucleus.Gene";
	public final static String GeneRef = "";
	
	public final static String HeteroChromatin = "biomight.cell.nucleus.HeteroChromatin";
	public final static String HeteroChromatinRef = "";
	
	public final static String Histones = "biomight.cell.nucleus.Histones";
	public final static String HistonesRef = "";
	
	public final static String HistoneTail = "biomight.cell.nucleus.HistoneTail";
	public final static String HistoneTailRef = "";
	
	public final static String HistoneTails = "biomight.cell.nucleus.HistoneTails";
	public final static String HistoneTailsRef = "";
	
	public final static String MitoticSpindel = "biomight.cell.nucleus.MitoticSpindel";
	public final static String MitoticSpindelRef = "";
	
	public final static String MitoticSpindels = "biomight.cell.nucleus.MitoticSpindels";
	public final static String MitoticSpindelsRef = "";
	
	public final static String NuclearEnvelope = "biomight.cell.nucleus.NuclearEnvelope";
	public final static String NuclearEnvelopeRef = "";
	
	public final static String NuclearPore = "biomight.cell.nucleus.NuclearPore";
	public final static String NuclearPoreRef = "";
	
	public final static String NuclearPores = "biomight.cell.nucleus.NuclearPores";
	public final static String NuclearPoresRef = "";
	
	public final static String Nucleolus = "biomight.cell.nucleus.Nucleolus";
	public final static String NucleolusRef = "";
	
	//public final static String Nucleosome = "biomight.cell.nucleus.Nucleosome";
	
	public final static String Nucleosomes = "biomight.cell.nucleus.Nucleosomes";
	public final static String NucleosomesRef = "";
	
	public final static String MicroTubuleBlade = "biomight.cell.filaments.MicroTubuleBlade;";
	public final static String MicroTubuleBladeRef = "";
	

	//  biomight.cell.nucleus.chromosome
	public final static String Centromere = "biomight.cell.nucleus.chromosome.Centromere";
	public final static String CentromereRef = "";
	
	//public final static String Centrosome = "biomight.cell.nucleus.chromosome.Centrosome";
	
	public final static String Chromosome = "biomight.cell.nucleus.chromosome.Chromosome";
	
	public final static String Chromosome1 = "biomight.cell.nucleus.chromosome.Chromosome1";
	public final static String Chromosome1Ref = "";
	
	public final static String Chromosome10 = "biomight.cell.nucleus.chromosome.Chromosome10";
	public final static String Chromosome10Ref = "";
	
	public final static String Chromosome11 = "biomight.cell.nucleus.chromosome.Chromosome11";
	public final static String Chromosome11Ref = "";
	
	public final static String Chromosome12 = "biomight.cell.nucleus.chromosome.Chromosome12";
	public final static String Chromosome12Ref = "";
	
	public final static String Chromosome13 = "biomight.cell.nucleus.chromosome.Chromosome13";
	public final static String Chromosome13Ref = "";
	
	public final static String Chromosome14 = "biomight.cell.nucleus.chromosome.Chromosome14";
	public final static String Chromosome14Ref = "";
	
	public final static String Chromosome15 = "biomight.cell.nucleus.chromosome.Chromosome15";
	public final static String Chromosome15Ref = "";
	
	public final static String Chromosome16 = "biomight.cell.nucleus.chromosome.Chromosome16";
	public final static String Chromosome16Ref = "";
	
	public final static String Chromosome17 = "biomight.cell.nucleus.chromosome.Chromosome17";
	public final static String Chromosome17Ref = "";
	
	public final static String Chromosome18 = "biomight.cell.nucleus.chromosome.Chromosome18";
	public final static String Chromosome18Ref = "";
	
	public final static String Chromosome19 = "biomight.cell.nucleus.chromosome.Chromosome19";
	public final static String Chromosome19Ref = "";
	
	public final static String Chromosome2 = "biomight.cell.nucleus.chromosome.Chromosome2";
	public final static String Chromosome2Ref = "";
	
	public final static String Chromosome20 = "biomight.cell.nucleus.chromosome.Chromosome20";
	public final static String Chromosome20Ref = "";
	
	public final static String Chromosome21 = "biomight.cell.nucleus.chromosome.Chromosome21";
	public final static String Chromosome21Ref = "";
	
	public final static String Chromosome22 = "biomight.cell.nucleus.chromosome.Chromosome22";
	public final static String Chromosome22Ref = "";
	
	public final static String Chromosome3 = "biomight.cell.nucleus.chromosome.Chromosome3";
	public final static String Chromosome3Ref = "";
	
	public final static String Chromosome4 = "biomight.cell.nucleus.chromosome.Chromosome4";
	public final static String Chromosome4Ref = "";
	
	public final static String Chromosome5 = "biomight.cell.nucleus.chromosome.Chromosome5";
	public final static String Chromosome5Ref = "";
	
	public final static String Chromosome6 = "biomight.cell.nucleus.chromosome.Chromosome6";
	public final static String Chromosome6Ref = "";
	
	public final static String Chromosome7 = "biomight.cell.nucleus.chromosome.Chromosome7";
	public final static String Chromosome7Ref = "";
	
	public final static String Chromosome8 = "biomight.cell.nucleus.chromosome.Chromosome8";
	public final static String Chromosome8Ref = "";
	
	public final static String Chromosome9 = "biomight.cell.nucleus.chromosome.Chromosome9";
	public final static String Chromosome9Ref = "";
	
	public final static String Nucleosome = "biomight.cell.nucleus.chromosome.Nucleosome";
	public final static String NucleosomeRef = "";
		
	
	/********************************************************************************
	 * 
	 * CELLS
	 * 
	 ********************************************************************************/ 


	public final static String Cells  = "biomight.cell.Cells";	
	public final static String CellsRef = "Cells";	

	// biomight.cell.autonomicneuron		
	public final static String AdrenergicNeuralCell = "biomight.cell.autonomicneuron.AdrenergicNeuralCell";
	public final static String AdrenergicNeuralCellRef = "AdrenergicNeuralCell";
	
	public final static String CholinergicNeuralCell = "biomight.cell.autonomicneuron.CholinergicNeuralCell";
	public final static String CholinergicNeuralCellRef = "CholinergicNeuralCell";

	public final static String PeptidergicNeuralCell = "biomight.cell.autonomicneuron.PeptidergicNeuralCell";
	public final static String PeptidergicNeuralCellRef = "PeptidergicNeuralCell";
	
	// biomight.cell.barrierfunction
	public final static String DuctCell = "biomight.cell.barrierfunction.DuctCell";
	public final static String DuctCellRef = "DuctCell";

	public final static String KidneyCollectingDuctCell = "biomight.cell.barrierfunction.KidneyCollectingDuctCell";
	public final static String KidneyCollectingDuctCellRef = "KidneyCollectingDuctCell";
	
	public final static String KidneyGlomerulusParietalCell = "biomight.cell.barrierfunction.KidneyGlomerulusParietalCell";
	public final static String KidneyGlomerulusParietalCellRef = "KidneyGlomerulusParietalCell";
	
	public final static String KidneyGlomerulusPodocyte = "biomight.cell.barrierfunction.KidneyGlomerulusPodocyte";
	public final static String KidneyGlomerulusPodocyteRef = "KidneyGlomerulusPodocyte";
	
	public final static String LoopOfHenleThinSegmentCell = "biomight.cell.barrierfunction.LoopOfHenleThinSegmentCell";
	public final static String LoopOfHenleThinSegmentCellRef = "LoopOfHenleThinSegmentCell";
	
	public final static String LungPneumocyte = "biomight.cell.barrierfunction.LungPneumocyte";
	public final static String LungPneumocyteRef = "LungPneumocyte";

	public final static String NonStraitedDuctCell = "biomight.cell.barrierfunction.NonStraitedDuctCell";
	public final static String NonStraitedDuctCellRef = "NonStraitedDuctCell";
	
	public final static String PancreaticDuctCell = "biomight.cell.barrierfunction.PancreaticDuctCell";
	public final static String PancreaticDuctCellRef = "PancreaticDuctCell";

	// biomight.cell.bloodandimmune
	public final static String Agranulocyte = "biomight.cell.bloodandimmune.Agranulocyte";
	public final static String AgranulocyteRef = "Agranulocyte";

	public final static String AlveolarMacrophage = "biomight.cell.bloodandimmune.AlveolarMacrophage";
	public final static String AlveolarMacrophageRef = "AlveolarMacrophage";

	public final static String Antigens = "biomight.cell.bloodandimmune.Antigens";
	public final static String AntigensRef = "Antigens";
	
	public final static String Antigen = "biomight.cell.bloodandimmune.Antigen";
	public final static String AntigenRef = "Antigen";
	
	public final static String BCells = "biomight.cell.bloodandimmune.BCells";
	public final static String BCellsRef = "BCells";
	
	public final static String BCell = "biomight.cell.bloodandimmune.BCell";
	public final static String BCellRef = "BCell";
	
	public final static String B1Cells = "biomight.cell.bloodandimmune.B1Cells";
	public final static String B1CellsRef = "B1Cells";
	
	public final static String B1Cell = "biomight.cell.bloodandimmune.B1Cell";
	public final static String B1CellRef = "B1Cell";
	
	public final static String B2Cells = "biomight.cell.bloodandimmune.B2Cell";
	public final static String B2CellsRef = "B2Cell";
	
	public final static String B2Cell = "biomight.cell.bloodandimmune.B2Cell";
	public final static String B2CellRef = "B2Cell";
	
	public final static String BandCell = "biomight.cell.bloodandimmune.BandCell";
	public final static String BandCellRef = "BandCell";
		
	public final static String BasophilGranulocyte = "biomight.cell.bloodandimmune.BasophilGranulocyte";
	public final static String BasophilphilGranulocyteRef = "BasophilGranulocyte";
	
	public final static String AnimalCell = "biomight.cell.bloodandimmune.AnimalCell";
	public final static String AnimalCellRef = "AnimalCell";
	
	public final static String AnimalCells = "biomight.cell.bloodandimmune.AnimalCells";
	public final static String AnimalCellsRef = "AnimalCells";
	
	public final static String Basophil = "biomight.cell.bloodandimmune.Basophil";
	public final static String BasophilRef = "Basophil";
	
	public final static String Basophils = "biomight.cell.bloodandimmune.Basophils";
	public final static String BasophilsRef = "Basophils";
	
	public final static String BCellReceptor = "biomight.cell.bloodandimmune.BCellReceptor";
	public final static String BCellReceptorRef = "BCellReceptor";
	
	public final static String CytotoxicTCell = "biomight.cell.bloodandimmune.CytotoxicTCell";
	public final static String CytotoxicTCellRef = "CytotoxicTCell";
	
	public final static String DendriticCell = "biomight.cell.bloodandimmune.DendriticCell";
	public final static String DendriticCellRef = "DendriticCell";
	
	public final static String EosinophilGranulocyte = "biomight.cell.bloodandimmune.EosinophilGranulocyte";
	public final static String EosinophilGranulocyteRef = "EosinophilGranulocyte";

	public final static String Granules = "biomight.cell.bloodandimmune.Granules";
	public final static String GranulesRef = "Granules";
	
	public final static String Granule = "biomight.cell.bloodandimmune.Granule";
	public final static String GranuleRef = "Granule";
	
	public final static String Eosinophil = "biomight.cell.bloodandimmune.Eosinophil";
	public final static String EosinophilRef = "Eosinophil";
	
	public final static String Eosinophils = "biomight.cell.bloodandimmune.Eosinophils";
	public final static String EosinophilsRef = "Eosinophils";
	
	public final static String EpidermalLangerhansCell = "biomight.cell.bloodandimmune.EpidermalLangerhansCell";
	public final static String EpidermalLangerhansCellRef = "EpidermalLangerhansCell";
	
	public final static String ErythoidProgenitor = "biomight.cell.bloodandimmune.ErythoidProgenitor";
	public final static String ErythoidProgenitorRef = "ErythoidProgenitor";

	public final static String Erythrocytes = "biomight.cell.bloodandimmune.Erythrocytes";
	public final static String ErythrocytesRef = "Erythrocytes";

	public final static String Erythrocyte = "biomight.cell.bloodandimmune.Erythrocyte";
	public final static String ErythrocyteRef = "Erythrocyte";
		
	public final static String ExudateMacrophage = "biomight.cell.bloodandimmune.ExudateMacrophage";
	
	public final static String GlycineReceptor = "biomight.cell.bloodandimmune.GlycineReceptor";
	
	public final static String GranulocyteMonocyteProgenitorCell = "biomight.cell.bloodandimmune.GranulocyteMonocyteProgenitorCell";
	public final static String GranulocyteMonocyteProgenitorCellRef = "GranulocyteMonocyteProgenitorCell";

	public final static String HaploTypes = "biomight.cell.bloodandimmune.HaploTypes";
	
	public final static String HelperTCell = "biomight.cell.bloodandimmune.HelperTCell";
	public final static String HelperTCellRef = "HelperTCell";
	
	public final static String HelperTh1Cell = "biomight.cell.bloodandimmune.HelperTh1Cell";
	public final static String HelperTh1CellRef = "HelperTh1Cell";
	
	public final static String HelperTh2Cells = "biomight.cell.bloodandimmune.HelperTh2Cells";
	public final static String HelperTh2CellsRef = "HelperTh2Cells";
	
	public final static String HelperTh2Cell = "biomight.cell.bloodandimmune.HelperTh2Cell";
	public final static String HelperTh2CellRef = "HelperTh2Cell";
	
	public final static String HematopoieticStemCell = "biomight.cell.bloodandimmune.HematopoieticStemCell";
	public final static String HematopoieticStemCellRef = "HematopoieticStemCell";
	
	public final static String HumanLeukocyteAntigens = "biomight.cell.bloodandimmune.HumanLeukocyteAntigens";
	public final static String HumanLeukocyteAntigensRef = "HumanLeukocyteAntigens";
	
	public final static String KuppferCells = "biomight.cell.bloodandimmune.KuppferCells";
	public final static String KuppferCellsRef = "KuppferCells";
	
	public final static String KuppferCell = "biomight.cell.bloodandimmune.KuppferCell";
	public final static String KuppferCellRef = "KuppferCell";
	
	public final static String Leukocyte = "biomight.cell.bloodandimmune.Leukocyte";
	public final static String LeukocyteRef = "Leukocyte";
	
	public final static String Leukocytes = "biomight.cell.bloodandimmune.Leukocytes";
	public final static String LeukocytesRef = "Leukocytes";
	
	public final static String Lymphocyte = "biomight.cell.bloodandimmune.Lymphocyte";
	public final static String LymphocyteRef = "Lymphocyte";
	
	public final static String Lymphocytes = "biomight.cell.bloodandimmune.Lymphocytes";
	public final static String LymphocytesRef = "Lymphocytes";
	
	public final static String LymphoidStemCell = "biomight.cell.bloodandimmune.LymphoidStemCell";
	public final static String LymphoidStemCellRef = "LymphoidStemCell";
	
	public final static String Macrophage = "biomight.cell.bloodandimmune.Macrophage";
	public final static String MacrophageRef = "Macrophage";	
	
	public final static String Macrophages = "biomight.cell.bloodandimmune.Macrophages";
	public final static String MacrophagesRef = "Macrophages";
	
	public final static String MastCell = "biomight.cell.bloodandimmune.MastCell";
	public final static String MastCellRef = "MastCell";
	
	public final static String MastCells = "biomight.cell.bloodandimmune.MastCells";
	public final static String MastCellsRef = "MastCells";
	
	public final static String MegaKaryocytes = "biomight.cell.bloodandimmune.MegaKaryocytes";
	public final static String MegaKaryocytesRef = "MegaKaryocytes";

	public final static String MegaKaryocyte = "biomight.cell.bloodandimmune.MegaKaryocyte";
	public final static String MegaKaryocyteRef = "MegaKaryocyte";
	
	public final static String MemoryBCell = "biomight.cell.bloodandimmune.MemoryBCell";
	public final static String MemoryBCellRef = "MemoryBCellRef";
	
	public final static String MemoryBCells = "biomight.cell.bloodandimmune.MemoryBCells";
	public final static String MemoryBCellsRef = "MemoryBCellsRef";

	public final static String MicroglialCell = "biomight.cell.bloodandimmune.MicroglialCell";
	public final static String MicroglialCellRef = "MicroglialCell";
	
	public final static String MicroglialCells = "biomight.cell.bloodandimmune.MicroglialCell";
	public final static String MicroglialCellsRef = "MicroglialCells";
	
	public final static String Monoblast = "biomight.cell.bloodandimmune.Monoblast";
	public final static String MonoblastRef = "Monoblast";

	public final static String Monoblasts = "biomight.cell.bloodandimmune.Monoblasts";
	public final static String MonoblastsRef = "Monoblasts";

	public final static String Monocyte = "biomight.cell.bloodandimmune.Monocyte";
	public final static String MonocyteRef = "Monocyte";

	public final static String Monocytes = "biomight.cell.bloodandimmune.Monocytes";
	public final static String MonocytesRef = "Monocytes";
	
	public final static String MyeloErythoidProgenitor = "biomight.cell.bloodandimmune.MyeloErythoidProgenitor";
	public final static String MyeloErythoidProgenitorRef = "MyeloErythoidProgenitor";
	
	public final static String MyeloErythoidProgenitors = "biomight.cell.bloodandimmune.MyeloErythoidProgenitors";
	public final static String MyeloErythoidProgenitorsRef = "MyeloErythoidProgenitors";

	public final static String MyeloidProgenitor = "biomight.cell.bloodandimmune.MyeloidProgenitor";
	public final static String MyeloidProgenitorRef = "MyeloidProgenitor";

	public final static String MyeloidProgenitors = "biomight.cell.bloodandimmune.MyeloidProgenitors";
	public final static String MyeloidProgenitorsRef = "MyeloidProgenitors";
	
	public final static String NaturalKillerCell = "biomight.cell.bloodandimmune.NaturalKillerCell";
	public final static String NaturalKillerCellRef = "NaturalKillerCell";

	public final static String NaturalKillerCells = "biomight.cell.bloodandimmune.NaturalKillerCells";
	public final static String NaturalKillerCellsRef = "NaturalKillerCells";

	public final static String NeutrophilGranulocyte = "biomight.cell.bloodandimmune.NeutrophilGranulocyte";
	public final static String NeutrophilGranulocyteRef = "NeutrophilGranulocyte";
	
	public final static String NeutrophilGranulocytes = "biomight.cell.bloodandimmune.NeutrophilGranulocytes";
	public final static String NeutrophilGranulocytesRef = "NeutrophilGranulocytes";
	
	public final static String Neutrophil = "biomight.cell.bloodandimmune.Neutrophil";
	public final static String NeutrophilRef = "Neutrophil";
	
	public final static String Neutrophils = "biomight.cell.bloodandimmune.Neutrophils";
	public final static String NeutrophilsRef = "Neutrophils";
	
	public final static String Osteoclast = "biomight.cell.bloodandimmune.Osteoclast";
	public final static String OsteoclastRef = "Osteoclast";
	
	public final static String Osteoclasts = "biomight.cell.bloodandimmune.Osteoclasts";
	public final static String OsteoclastsRef = "Osteoclasts";
	
	public final static String PhagocyticCell = "biomight.cell.bloodandimmune.PhagocyticCell";
	public final static String PhagocyticCellRef = "PhagocyticCell";
	
	public final static String PhagocyticCells = "biomight.cell.bloodandimmune.PhagocyticCells";
	public final static String PhagocyticCellsRef = "PhagocyticCells";
	
	public final static String PlasmaBCell = "biomight.cell.bloodandimmune.PlasmaBCell";
	public final static String PlasmaBCellRef = "PlasmaBCell";

	public final static String PlasmaBCells = "biomight.cell.bloodandimmune.PlasmaBCells";
	public final static String PlasmaBCellsRef = "PlasmaBCells";

	public final static String Platelet = "biomight.cell.bloodandimmune.Platelet";
	public final static String PlateletRef = "";

	public final static String Platelets = "biomight.cell.bloodandimmune.Platelets";
	public final static String PlateletsRef = "Platelets";
	
	public final static String PleuralMacrophage = "biomight.cell.bloodandimmune.PleuralMacrophage";
	public final static String PleuralMacrophageRef = "PleuralMacrophage";
	
	public final static String PleuralMacrophages = "biomight.cell.bloodandimmune.PleuralMacrophages";
	public final static String PleuralMacrophagesRef = "PleuralMacrophages";

	public final static String PreBCell = "biomight.cell.bloodandimmune.PreBCell";
	public final static String PreBCellRef = "PreBCell";
	
	public final static String PreBCells = "biomight.cell.bloodandimmune.PreBCells";
	public final static String PreBCellsRef = "PreBCells";

	public final static String ProcessedAntigen = "biomight.cell.bloodandimmune.ProcessedAntigen";
	public final static String ProcessedAntigenRef = "ProcessedAntigen";
	
	public final static String ProMonocyte = "biomight.cell.bloodandimmune.ProMonocyte";
	public final static String ProMonocyteRef = "ProMonocyte";
	
	public final static String ProMonocytes = "biomight.cell.bloodandimmune.ProMonocytes";
	public final static String ProMonocytesRef = "ProMonocytes";

	public final static String RedBloodCorpuscle = "biomight.cell.bloodandimmune.RedBloodCorpuscle";
	public final static String RedBloodCorpuscleRef = "RedBloodCorpuscle";
		
	public final static String RedBloodCorpuscles = "biomight.cell.bloodandimmune.RedBloodCorpuscles";
	public final static String RedBloodCorpusclesRef = "RedBloodCorpuscles";

	public final static String RegulatoryTCell = "biomight.cell.bloodandimmune.RegulatoryTCell";
	public final static String RegulatoryTCellRef = "RegulatoryTCell";
	
	public final static String RegulatoryTCells = "biomight.cell.bloodandimmune.RegulatoryTCells";
	public final static String RegulatoryTCellsRef = "RegulatoryTCells";
	
	public final static String Reticulocytes = "biomight.cell.bloodandimmune.Reticulocytes";
	public final static String ReticulocytesRef = "Reticulocytes";

	public final static String Reticulocyte = "biomight.cell.bloodandimmune.Reticulocyte";
	public final static String ReticulocyteRef = "Reticulocyte";
	
	public final static String StemCells = "biomight.cell.bloodandimmune.StemCells";
	public final static String StemCellsRef = "StemCells";
	
	public final static String StemCell = "biomight.cell.bloodandimmune.StemCell";
	public final static String StemCellRef = "StemCell";

	public final static String SuppressorTCell = "biomight.cell.bloodandimmune.SuppressorTCell";
	public final static String SuppressorTCellRef = "SuppressorTCell";

	public final static String SuppressorTCells = "biomight.cell.bloodandimmune.SuppressorTCells";
	public final static String SuppressorTCellsRef = "SuppressorTCells";

	public final static String TCellAlphaReceptor = "biomight.cell.bloodandimmune.TCellAlphaReceptor";
	public final static String TCellAlphaReceptorRef = "TCellAlphaReceptor";
	
	public final static String TCellAlphaReceptors = "biomight.cell.bloodandimmune.TCellAlphaReceptor";
	public final static String TCellAlphaReceptorsRef = "TCellAlphaReceptors";

	public final static String TCellBetaReceptor = "biomight.cell.bloodandimmune.TCellBetaReceptor";
	
	public final static String TCellReceptor = "biomight.cell.bloodandimmune.TCellReceptor";
	
	public final static String Thrombocytes = "biomight.cell.bloodandimmune.Thrombocytes";
	public final static String ThrombocytesRef = "Thrombocytes";
	
	public final static String Thrombocyte = "biomight.cell.bloodandimmune.Thrombocyte";
	public final static String ThrombocyteRef = "Thrombocyte";
	
	public final static String Thymocyte = "biomight.cell.bloodandimmune.Thymocyte";
	public final static String ThymocyteRef = "Thymocyte";

	public final static String Thymocytes = "biomight.cell.bloodandimmune.Thymocytes";
	public final static String ThymocytesRef = "Thymocytes";
	
	public final static String Thyrotropes = "biomight.cell.bloodandimmune.Thyrotropes";
	public final static String ThyrotropesRef = "Thyrotropes";

	public final static String Chrondocyte = "biomight.cell.misc.Chrondocyte";
	public final static String ChrondocyteRef = "Chrondocyte";
	
	public final static String Chrondocytes = "biomight.cell.misc.Chrondocytes";
	public final static String ChrondocytesRef = "Chrondocytes";
	
	
	
	// 
	
	// biomight.cell.cancer
	//public final static String CancerCell = "biomight.cell.cancer.CancerCell";
	//public final static String TumorCell = "biomight.cell.cancer.TumorCell";

	// biomight.cell.ciliatedpropulsive
	public final static String OviductCiliatedCell = "biomight.cell.ciliatedpropulsive.OviductCiliatedCell";
	public final static String RepiratoryTractCliliatedCell = "biomight.cell.ciliatedpropulsive.RepiratoryTractCliliatedCell";
	public final static String ReteTestisCiliatedCell = "biomight.cell.ciliatedpropulsive.ReteTestisCiliatedCell";
	public final static String UterineEndometrialCiliatedCell = "biomight.cell.ciliatedpropulsive.UterineEndometrialCiliatedCell";

	// biomight.cell.contractile
	public final static String ExocrineGlandMyoEpithelialCell = "biomight.cell.contractile.ExocrineGlandMyoEpithelialCell";
	public final static String HeartMuscleCell = "biomight.cell.contractile.HeartMuscleCell";
	public final static String HeartMuscleNodalCell = "biomight.cell.contractile.HeartMuscleNodalCell";
	public final static String IrisMyoEpithelialCell = "biomight.cell.contractile.IrisMyoEpithelialCell";
	public final static String MuscleSpindleNuclearBagCell = "biomight.cell.contractile.MuscleSpindleNuclearBagCell";
	public final static String MuscleSpindleNuclearChainCell = "biomight.cell.contractile.MuscleSpindleNuclearChainCell";
	public final static String PaceMakerCells = "biomight.cell.contractile.PaceMakerCells";
	public final static String PurkinjeFiberCell = "biomight.cell.contractile.PurkinjeFiberCell";
	public final static String RedBloodCell = "biomight.cell.contractile.RedBloodCell";
	public final static String SatelliteCell = "biomight.cell.contractile.SatelliteCell";
	public final static String Schistocyte = "biomight.cell.contractile.Schistocyte";
	public final static String SkeletalMuscleIntermediateCell = "biomight.cell.contractile.SkeletalMuscleIntermediateCell";
	public final static String SkeletalMuscleRedCell = "biomight.cell.contractile.SkeletalMuscleRedCell";
	public final static String SkeletalMuscleWhiteCell = "biomight.cell.contractile.SkeletalMuscleWhiteCell";
	public final static String SmoothMuscleCell = "biomight.cell.contractile.SmoothMuscleCell";
		
	// biomight.cell.epithelial
	public final static String AmacrineCells = "biomight.cell.epithelial.AmacrineCells";
	public final static String AmacrineCellsRef = "AmacrineCells";

	public final static String AmacrineCell = "biomight.cell.epithelial.AmacrineCell";
	public final static String AmacrineCellRef = "AmacrineCell";
	
	public final static String BasalLamina = "biomight.cell.epithelial.BasalLamina";
	
	public final static String BasementMembrane = "biomight.cell.epithelial.BasementMembrane";
	
	public final static String CuboidalSimpleEpithelialCell = "biomight.cell.epithelial.CuboidalSimpleEpithelialCell";
	
	public final static String CuboidalStratifiedEpithelialCell = "biomight.cell.epithelial.CuboidalStratifiedEpithelialCell";
	
	public final static String Enterocyte = "biomight.cell.epithelial.Enterocyte";
	
	public final static String Enterocytes = "biomight.cell.epithelial.Enterocytes";
	
	public final static String EpithelioidCell = "biomight.cell.epithelial.EpithelioidCell";
	
	public final static String EthmoidalCell = "biomight.cell.epithelial.EthmoidalCell";
	
	public final static String LaminaDensa = "biomight.cell.epithelial.LaminaDensa";
	
	public final static String LaminaLucida = "biomight.cell.epithelial.LaminaLucida";
	
	public final static String LaminaReticularis = "biomight.cell.epithelial.LaminaReticularis";
	
	public final static String Podocyte = "biomight.cell.epithelial.Podocyte";
	
	public final static String Podocytes = "biomight.cell.epithelial.Podocytes";
	
	public final static String SquamousEpithelialCell = "biomight.cell.epithelial.SquamousEpithelialCell";
	
	public final static String SquamousEpithelialCells = "biomight.cell.epithelial.SquamousEpithelialCells";
	
	public final static String SquamousSimpleEpithelialCell = "biomight.cell.epithelial.SquamousSimpleEpithelialCell";
	
	public final static String SquamousStratifiedEpithelialCell = "biomight.cell.epithelial.SquamousStratifiedEpithelialCell";
	
	public final static String TransitionalEpithelialCell = "biomight.cell.epithelial.TransitionalEpithelialCell";
	
	
	
	public final static String EpithelialCell = "biomight.cell.epithelial.EpithelialCell";
	
	public final static String EpithelialCellRef = "EpithelialCell";

	public final static String EpithelialCells = "biomight.cell.epithelial.EpithelialCells";
	public final static String EpithelialCellsRef = "EpithelialCells";
	
	
	// biomight.cell.epithelial.columnar
	public final static String ColumnarEpitheliaCell = "biomight.cell.epithelial.columnar.ColumnarEpitheliaCell";
	public final static String ColumnarEpitheliaCells = "biomight.cell.epithelial.columnar.ColumnarEpitheliaCells";

	// biomight.cell.epithelial.columnar.simple
	public final static String SimpleColumnarCiliatedEpithelialCell = "biomight.cell.epithelial.columnar.simple.SimpleColumnarCiliatedEpithelialCell";
	public final static String SimpleColumnarCiliatedEpithelialCells = "biomight.cell.epithelial.columnar.simple.SimpleColumnarCiliatedEpithelialCells";
	public final static String SimpleColumnarEpithelialCell = "biomight.cell.epithelial.columnar.simple.SimpleColumnarEpithelialCell";
	public final static String SimpleColumnarEpithelialCells = "biomight.cell.epithelial.columnar.simple.SimpleColumnarEpithelialCells";
	public final static String SimpleColumnarNonCiliatedEpithelialCell = "biomight.cell.epithelial.columnar.simple.SimpleColumnarNonCiliatedEpithelialCell";
	public final static String SimpleColumnarNonCiliatedEpithelialCells = "biomight.cell.epithelial.columnar.simple.SimpleColumnarNonCiliatedEpithelialCells";
	public final static String SimpleSquamousEpithelialCells = "biomight.cell.epithelial.columnar.simple.SimpleSquamousEpithelialCells";

	// biomight.cell.epithelial.columnar.stratified
	public final static String StratifiedColumnarEpithelialCell = "biomight.cell.epithelial.columnar.stratified.StratifiedColumnarEpithelialCell";

	// biomight.cell.epithelial.exocrinesecretory
	public final static String ApocrineSwaetGlandCell = "biomight.cell.epithelial.exocrinesecretory.ApocrineSwaetGlandCell";
	public final static String BartholinsGlandCell = "biomight.cell.epithelial.exocrinesecretory.BartholinsGlandCell";
	public final static String BowmansGlandCell = "biomight.cell.epithelial.exocrinesecretory.BowmansGlandCell";
	public final static String BrunnersGlandCell = "biomight.cell.epithelial.exocrinesecretory.BrunnersGlandCell";
	public final static String BulbourethralGlandCell = "biomight.cell.epithelial.exocrinesecretory.BulbourethralGlandCell";
	public final static String CeruminousGlandCell = "biomight.cell.epithelial.exocrinesecretory.CeruminousGlandCell";
	public final static String EccrineSweatGlandClearCell = "biomight.cell.epithelial.exocrinesecretory.EccrineSweatGlandClearCell";
	public final static String EccrineSweatGlandDarkCell = "biomight.cell.epithelial.exocrinesecretory.EccrineSweatGlandDarkCell";
	public final static String GastricGlandOxynticCell = "biomight.cell.epithelial.exocrinesecretory.GastricGlandOxynticCell";
	public final static String GastricGlandZymogenicCell = "biomight.cell.epithelial.exocrinesecretory.GastricGlandZymogenicCell";
	public final static String GlandOfLittreCell = "biomight.cell.epithelial.exocrinesecretory.GlandOfLittreCell";
	public final static String GlandOfMoleCell = "biomight.cell.epithelial.exocrinesecretory.GlandOfMoleCell";
	public final static String GobletCell = "biomight.cell.epithelial.exocrinesecretory.GobletCell";
	public final static String GobletCellOfDigestiveTract = "biomight.cell.epithelial.exocrinesecretory.GobletCellOfDigestiveTract";
	public final static String GobletCellsOfRespiratoryTract = "biomight.cell.epithelial.exocrinesecretory.GobletCellsOfRespiratoryTract";
	public final static String LacrimalGlandCell = "biomight.cell.epithelial.exocrinesecretory.LacrimalGlandCell";
	public final static String LungClaraCell = "biomight.cell.epithelial.exocrinesecretory.LungClaraCell";
	public final static String LungPneumocyteCell = "biomight.cell.epithelial.exocrinesecretory.LungPneumocyteCell";
	public final static String MammaryGlandCell = "biomight.cell.epithelial.exocrinesecretory.MammaryGlandCell";
	public final static String PancreaticAcinarCell = "biomight.cell.epithelial.exocrinesecretory.PancreaticAcinarCell";
	public final static String PanethCellofSmallIntestine = "biomight.cell.epithelial.exocrinesecretory.PanethCellofSmallIntestine";
	public final static String ProstateGlandCell = "biomight.cell.epithelial.exocrinesecretory.ProstateGlandCell";
	public final static String SalivaryGlandMucousCell = "biomight.cell.epithelial.exocrinesecretory.SalivaryGlandMucousCell";
	public final static String SalivaryGlandSerousCell = "biomight.cell.epithelial.exocrinesecretory.SalivaryGlandSerousCell";
	public final static String SebaceousGlandCell = "biomight.cell.epithelial.exocrinesecretory.SebaceousGlandCell";
	public final static String SecretoryGranule = "biomight.cell.epithelial.exocrinesecretory.SecretoryGranule";
	public final static String SecretoryGranules = "biomight.cell.epithelial.exocrinesecretory.SecretoryGranules";
	public final static String SeminalVesicleCell = "biomight.cell.epithelial.exocrinesecretory.SeminalVesicleCell";
	public final static String StomachLiningMucousCell = "biomight.cell.epithelial.exocrinesecretory.StomachLiningMucousCell";
	public final static String UterusEndometriumCell = "biomight.cell.epithelial.exocrinesecretory.UterusEndometriumCell";
	public final static String VonEbnerGlandCell = "biomight.cell.epithelial.exocrinesecretory.VonEbnerGlandCell";
	

	// biomight.cell.extracellularmatrixsecretion
	public final static String AmeloblastEpithelialCell = "biomight.cell.extracellularmatrixsecretion.AmeloblastEpithelialCell";
	public final static String Cementoblast = "biomight.cell.extracellularmatrixsecretion.Cementoblast";
	public final static String Cementocyte = "biomight.cell.extracellularmatrixsecretion.Cementocyte";
	public final static String ChondrocyteElasticCartilage = "biomight.cell.extracellularmatrixsecretion.ChondrocyteElasticCartilage";
	public final static String ChondrocyteFibrocartilage = "biomight.cell.extracellularmatrixsecretion.ChondrocyteFibrocartilage";
	public final static String ChondrocyteHyalineCartilage = "biomight.cell.extracellularmatrixsecretion.ChondrocyteHyalineCartilage";
	public final static String EarPlanumSemilunatumEpithelialCell = "biomight.cell.extracellularmatrixsecretion.EarPlanumSemilunatumEpithelialCell";
	public final static String EyeHylocyte = "biomight.cell.extracellularmatrixsecretion.EyeHylocyte";
	public final static String Fibroblast = "biomight.cell.extracellularmatrixsecretion.Fibroblast";
	public final static String FibroblastsBoneMarrow = "biomight.cell.extracellularmatrixsecretion.FibroblastsBoneMarrow";
	public final static String FibroblastsCorneal = "biomight.cell.extracellularmatrixsecretion.FibroblastsCorneal";
	public final static String FibroblastsLooseConnectiveTiisue = "biomight.cell.extracellularmatrixsecretion.FibroblastsLooseConnectiveTiisue";
	public final static String FibroblastsNonEpithelial = "biomight.cell.extracellularmatrixsecretion.FibroblastsNonEpithelial";
	public final static String FibroblastsTendon = "biomight.cell.extracellularmatrixsecretion.FibroblastsTendon";
	public final static String NucleusPulposusCell = "biomight.cell.extracellularmatrixsecretion.NucleusPulposusCell";
	public final static String Odontoblast = "biomight.cell.extracellularmatrixsecretion.Odontoblast";
	public final static String Odontocyte = "biomight.cell.extracellularmatrixsecretion.Odontocyte";
	public final static String OrganOfCortiInterDentalEpitheilialCell = "biomight.cell.extracellularmatrixsecretion.OrganOfCortiInterDentalEpitheilialCell";
	public final static String Osteoblast = "biomight.cell.extracellularmatrixsecretion.Osteoblast";
	
	public final static String Osteocyte = "biomight.cell.extracellularmatrixsecretion.Osteocyte";
	public final static String OsteocyteRef = "Osteocyte";
	
	public final static String Osteocytes = "biomight.cell.extracellularmatrixsecretion.Osteocytes";
	public final static String OsteocytesRef = "Osteocytes";
	
	public final static String OsteoprogenitorCell = "biomight.cell.extracellularmatrixsecretion.OsteoprogenitorCell";
	public final static String Pericyte = "biomight.cell.extracellularmatrixsecretion.Pericyte";
	
	public final static String Pinealocyte = "biomight.cell.extracellularmatrixsecretion.Pinealocyte";
	public final static String PinealocyteRef = "Pinealocyte";
	
	public final static String Pinealocytes = "biomight.cell.extracellularmatrixsecretion.Pinealocytes";
	public final static String PinealocytesRef = "Pinealocytes";
	
	public final static String StellateCell = "biomight.cell.extracellularmatrixsecretion.StellateCell";
	public final static String StellateCells = "biomight.cell.extracellularmatrixsecretion.StellateCells";

	// biomight.cell.germ
	public final static String Oocyte = "biomight.cell.germ.Oocyte";
	public final static String Oogonium = "biomight.cell.germ.Oogonium";
	public final static String Spermatid = "biomight.cell.germ.Spermatid";
	public final static String Spermatocyte = "biomight.cell.germ.Spermatocyte";
	public final static String SpermatogoniumCell = "biomight.cell.germ.SpermatogoniumCell";
	public final static String Spermatozoon = "biomight.cell.germ.Spermatozoon";
	public final static String ThymusEpithelialCell = "biomight.cell.germ.ThymusEpithelialCell";
	
	// biomight.cell.germlayers
	public final static String Ectoderm = "biomight.cell.germlayers.Ectoderm";
	public final static String Endoderm = "biomight.cell.germlayers.Endoderm";
	public final static String GermLayers = "biomight.cell.germlayers.GermLayers";
	public final static String Mesoderm = "biomight.cell.germlayers.Mesoderm";
	
	// biomight.cell.hormonesecreting
	public final static String AdrenalChromaffinCell = "biomight.cell.hormonesecreting.AdrenalChromaffinCell";
	public final static String AdrenalChromaffinCells = "biomight.cell.hormonesecreting.AdrenalChromaffinCells";
	public final static String ChromaffinCell = "biomight.cell.hormonesecreting.ChromaffinCell";
	public final static String CorpusLuteumCell = "biomight.cell.hormonesecreting.CorpusLuteumCell";
	public final static String CorticalCell = "biomight.cell.hormonesecreting.CorticalCell";
	public final static String CorticalCells = "biomight.cell.hormonesecreting.CorticalCells";
	public final static String Corticotropes = "biomight.cell.hormonesecreting.Corticotropes";
	public final static String Gonadotropes = "biomight.cell.hormonesecreting.Gonadotropes";
	public final static String GutRespiratoryTractCell = "biomight.cell.hormonesecreting.GutRespiratoryTractCell";
	public final static String IntermediatePituitary = "biomight.cell.hormonesecreting.IntermediatePituitary";
	public final static String KidneyJuxtaGlomerularApparatusCell = "biomight.cell.hormonesecreting.KidneyJuxtaGlomerularApparatusCell";
	public final static String KidneyMaculaDensaCell = "biomight.cell.hormonesecreting.KidneyMaculaDensaCell";
	public final static String KidneyPeripolarCell = "biomight.cell.hormonesecreting.KidneyPeripolarCell";
	public final static String LacisCells = "biomight.cell.hormonesecreting.LacisCells";
	public final static String Lactrotropes = "biomight.cell.hormonesecreting.Lactrotropes";
	public final static String LeydigCell = "biomight.cell.hormonesecreting.LeydigCell";
	public final static String MagnoCellularNueroSecretoryCell = "biomight.cell.hormonesecreting.MagnoCellularNueroSecretoryCell";
	public final static String MesangialCell = "biomight.cell.hormonesecreting.MesangialCell";
	public final static String MesangialCells = "biomight.cell.hormonesecreting.MesangialCells";
	public final static String ParaThyroidChief = "biomight.cell.hormonesecreting.ParaThyroidChief";
	public final static String ParaThyroidOxyphil = "biomight.cell.hormonesecreting.ParaThyroidOxyphil";
	public final static String Somatotropes = "biomight.cell.hormonesecreting.Somatotropes";
	public final static String ThecaInternaCell = "biomight.cell.hormonesecreting.ThecaInternaCell";
	public final static String ThyroidEpithelial = "biomight.cell.hormonesecreting.ThyroidEpithelial";
	public final static String ThyroidParafollicular = "biomight.cell.hormonesecreting.ThyroidParafollicular";
	public final static String Thytrotropes = "biomight.cell.hormonesecreting.Thytrotropes";
	
	// biomight.cell.InternalCavityEpithelial
	public final static String ChoroidPlexusCell = "biomight.cell.InternalCavityEpithelial.ChoroidPlexusCell";
	public final static String CornealEndothelial = "biomight.cell.InternalCavityEpithelial.CornealEndothelial";
	public final static String EarEndolymphaticColumnarCell = "biomight.cell.InternalCavityEpithelial.EarEndolymphaticColumnarCell";
	public final static String EarEndolymphaticColumnarVilliCell = "biomight.cell.InternalCavityEpithelial.EarEndolymphaticColumnarVilliCell";
	public final static String EarEndolymphaticDarkCell = "biomight.cell.InternalCavityEpithelial.EarEndolymphaticDarkCell";
	public final static String EarEndolymphaticSquamousCell = "biomight.cell.InternalCavityEpithelial.EarEndolymphaticSquamousCell";
	public final static String EarEndolymphaticStriaVascularisBasalCell = "biomight.cell.InternalCavityEpithelial.EarEndolymphaticStriaVascularisBasalCell";
	public final static String EarEndolymphaticStriaVascularisMarginalCell = "biomight.cell.InternalCavityEpithelial.EarEndolymphaticStriaVascularisMarginalCell";
	public final static String EarEndolymphaticVestibularMembraneCell = "biomight.cell.InternalCavityEpithelial.EarEndolymphaticVestibularMembraneCell";
	public final static String EarPerilymphaticSquamousCell = "biomight.cell.InternalCavityEpithelial.EarPerilymphaticSquamousCell";
	public final static String SerosalCell = "biomight.cell.InternalCavityEpithelial.SerosalCell";
	public final static String SquamousCell = "biomight.cell.InternalCavityEpithelial.SquamousCell";
	public final static String SynovialCell = "biomight.cell.InternalCavityEpithelial.SynovialCell";
	
	// biomight.cell.kerantinepithelial
	public final static String CorticalHairShaftCell = "biomight.cell.kerantinepithelial.CorticalHairShaftCell";
	public final static String CorticalHairShaftCells = "biomight.cell.kerantinepithelial.CorticalHairShaftCells";
	public final static String CuticularHairRootSheathCell = "biomight.cell.kerantinepithelial.CuticularHairRootSheathCell";
	public final static String CuticularHairShaftCell = "biomight.cell.kerantinepithelial.CuticularHairShaftCell";
	public final static String EpidermalBasalCell = "biomight.cell.kerantinepithelial.EpidermalBasalCell";
	public final static String EpidermalKeratinocyte = "biomight.cell.kerantinepithelial.EpidermalKeratinocyte";
	public final static String ExternalHairRootSheathCell = "biomight.cell.kerantinepithelial.ExternalHairRootSheathCell";
	public final static String FingerToeNailBedBasalCell = "biomight.cell.kerantinepithelial.FingerToeNailBedBasalCell";
	public final static String FingerToeNailKeratinocyte = "biomight.cell.kerantinepithelial.FingerToeNailKeratinocyte";
	public final static String HairMatrixCell = "biomight.cell.kerantinepithelial.HairMatrixCell";
	public final static String HenlesLayerHairRootSheathCell = "biomight.cell.kerantinepithelial.HenlesLayerHairRootSheathCell";
	public final static String HuxleysLayerHairRootSheathCell = "biomight.cell.kerantinepithelial.HuxleysLayerHairRootSheathCell";
	public final static String MedullaryHairShaftCell = "biomight.cell.kerantinepithelial.MedullaryHairShaftCell";
	
	// biomight.cell.metabolismstorage
	public final static String Adipocytes = "biomight.cell.metabolismstorage.Adipocytes";
	public final static String AdiposeCell = "biomight.cell.metabolismstorage.AdiposeCell";
	public final static String BrownFatCell = "biomight.cell.metabolismstorage.BrownFatCell";
	public final static String Cholangiocytes = "biomight.cell.metabolismstorage.Cholangiocytes";
	public final static String Hepatocyte = "biomight.cell.metabolismstorage.Hepatocyte";
	public final static String Hepatocytes = "biomight.cell.metabolismstorage.Hepatocytes";
	public final static String LiverLipocyte = "biomight.cell.metabolismstorage.LiverLipocyte";
	public final static String WhiteFatCell = "biomight.cell.metabolismstorage.WhiteFatCell";

	// biomight.cell.misc
	public final static String Acidophils = "biomight.cell.misc.Acidophils";
	public final static String Acini = "biomight.cell.misc.Acini";
	public final static String AstrocyticGlialCell = "biomight.cell.misc.AstrocyticGlialCell";
	public final static String Chondrocyte = "biomight.cell.misc.Chondrocyte";
	public final static String Chondrocytes = "biomight.cell.misc.Chondrocytes";
	public final static String Chromophobe = "biomight.cell.misc.Chromophobe";
	public final static String Chromophobes = "biomight.cell.misc.Chromophobes";
	public final static String Clasmatocytes = "biomight.cell.misc.Clasmatocytes";
	public final static String Corticotroph = "biomight.cell.misc.Corticotroph";
	public final static String Corticotrophs = "biomight.cell.misc.Corticotrophs";
	public final static String Dendrons = "biomight.cell.misc.Dendrons";
	public final static String EndothelialCell = "biomight.cell.misc.EndothelialCell";
	public final static String EndothelialCells = "biomight.cell.misc.EndothelialCells";
	public final static String EnteroEndocrineCell = "biomight.cell.misc.EnteroEndocrineCell";
	public final static String EnteroEndocrineCells = "biomight.cell.misc.EnteroEndocrineCells";
	
	public final static String FenestratedEndothelialCell = "biomight.cell.misc.FenestratedEndothelialCell";
	
	public final static String FenestratedEndothelialCells = "biomight.cell.misc.FenestratedEndothelialCells";
	
	public final static String FolliculostellateCells = "biomight.cell.misc.FolliculostellateCells";
	
	public final static String GlialCell = "biomight.cell.misc.GlialCell";
	
	public final static String GlialCells = "biomight.cell.misc.GlialCells";
	
	public final static String Gonadotroph = "biomight.cell.misc.Gonadotroph";
	
	public final static String Gonadotrophs = "biomight.cell.misc.Gonadotrophs";
	
	public final static String InterstitialCell = "biomight.cell.misc.InterstitialCell";
	public final static String InterstitialCellRef = "InterstitialCell";
	
	public final static String InterstitialCells = "biomight.cell.misc.InterstitialCells";
	public final static String InterstitialCellsRef = "nterstitialCells";

	public final static String PinealNeurons = " biomight.cell.neuronglial.nueron.PinealNeurons";
	public final static String PinealNeuronsRef = "PinealNeurons";
	
	public final static String PinealNeuron = " biomight.cell.neuronglial.nueron.PinealNeuron";
	public final static String PinealNeuronRef = "PinealNeuron";

	public final static String PeptidergicNeuronLikeCells = "PeptidergicNeuronLikeCells";
	public final static String PeptidergicNeuronLikeCellsRef = "PeptidergicNeuronLikeCells";
	
	public final static String PialCapsule = " PialCapsule";
	public final static String PialCapsuleRef = "PialCapsule";
	
	
	public final static String Lactotroph = "biomight.cell.misc.Lactotroph";
	
	public final static String Lactotrophs = "biomight.cell.misc.Lactotrophs";
	
	public final static String LamellarCells = "biomight.cell.misc.LamellarCells";
	
	public final static String MammoSomatotroph = "biomight.cell.misc.MammoSomatotroph";
	
	public final static String MammoSomatotrophs = "biomight.cell.misc.MammoSomatotrophs";
	
	public final static String NeuroEndocrineCells = "biomight.cell.misc.NeuroEndocrineCells";
	
	public final static String OvalCell = "biomight.cell.misc.OvalCell";
	
	public final static String OvalCells = "biomight.cell.misc.OvalCells";
	
	public final static String PancreasBetaCell = "biomight.cell.misc.PancreasBetaCell";
	
	public final static String PancreaticDeltaCells = "biomight.cell.misc.PancreaticDeltaCells";
	
	public final static String PancreaticPolypeptideCells = "biomight.cell.misc.PancreaticPolypeptideCells";
	
	public final static String PerivascularPhagocytes = "biomight.cell.misc.PerivascularPhagocytee";
	public final static String PerivascularPhagocytesRef = "PerivascularPhagocytee";
	
	public final static String PerivascularPhagocyte = "biomight.cell.misc.PerivascularPhagocyte";
	public final static String PerivascularPhagocyteRef = "PerivascularPhagocyte";

	public final static String Pituicytes = "biomight.cell.misc.Pituicytes";
	
	public final static String Somatotroph = "biomight.cell.misc.Somatotroph";
	
	public final static String Somatotrophs = "biomight.cell.misc.Somatotrophs";
	
	public final static String Thyrotroph = "biomight.cell.misc.Thyrotroph";
	
	public final static String Thyrotrophs = "biomight.cell.misc.Thyrotrophs";	

	public final static String SustentacularCells = "biomight.cell.misc.SustentacularCells";

	public final static String GustatoryCells = "biomight.cell.misc.GustatoryCells";
	
	// biomight.cell.neuron
	public final static String BiPolarCells = "biomight.cell.neuron.BiPolarCells";
	public final static String BiPolarCellsRef = "BiPolarCells";

	public final static String BiPolarCell = "biomight.cell.neuron.BiPolarCell";
	public final static String BiPolarCellRef = "BiPolarCell";
	
	public final static String GranuleCells = "biomight.cell.neuron.GranuleCells";
	public final static String GranuleCellsRef = "GranuleCells";

	public final static String GranuleCell = "biomight.cell.neuron.GranuleCell";
	public final static String GranuleCellRef = "GranuleCell";

	public final static String HorizontalCells = "biomight.cell.neuron.HorizontalCells";
	public final static String HorizontalCellsRef = "HorizontalCell";
	
	public final static String HorizontalCell = "biomight.cell.neuron.HorizontalCell";
	public final static String HorizontalCellRef = "HorizontalCell";
	
	public final static String HypoPhysioTropicNeurons = "biomight.cell.neuron.HypoPhysioTropicNeurons";
	public final static String HypoPhysioTropicNeuronsRef = "HypoPhysioTropicNeurons";
	
	public final static String HypoPhysioTropicNeuron = "biomight.cell.neuron.HypoPhysioTropicNeuron";
	public final static String HypoPhysioTropicNeuronRef = "HypoPhysioTropicNeuron";
	
	
	public final static String ParviCellularNeurons = "biomight.cell.neuron.ParviCellularNeurons";

	
	// biomight.cell.neuronglial
	public final static String Astrocytes = "biomight.cell.neuronglial.Astrocytes";
	public final static String AstrocytesRef = "Astrocytes";
	
	public final static String Astrocyte = "biomight.cell.neuronglial.Astrocyte";
	public final static String AstrocyteRef = "Astrocyte";
	
	public final static String BasketCell = "biomight.cell.neuronglial.BasketCell";
	public final static String BasketCellRef = "BasketCell";
	
	public final static String BasketCells = "biomight.cell.neuronglial.BasketCells";
	public final static String BasketCellsRef = "BasketCells";
		
	public final static String CholinergicInterneurons = "biomight.cell.neuronglial.CholinergicInterneurons";
	public final static String CholinergicInterneuronsRef = "CholinergicInterneurons";
	
	public final static String GanglionicCells = "biomight.cell.neuronglial.GanglionicCells";
	public final static String GanglionicCellsRef = "GanglionicCell";
	
	public final static String GanglionicCell = "biomight.cell.neuronglial.GanglionicCell";
	public final static String GanglionicCellRef = "GanglionicCell";
	
	public final static String GanglionPostganglionicSympatheticCell = "biomight.cell.neuronglial.GanglionPostganglionicSympatheticCell";
	
	public final static String MediumSpinyNeuron = "biomight.cell.neuronglial.MediumSpinyNeuron";
	
	public final static String Oligodendrocyte = "biomight.cell.neuronglial.Oligodendrocyte";
	
	public final static String SpindleNeuron = "biomight.cell.neuronglial.SpindleNeuron";

	// biomight.cell.neuronglial.nueron
	public final static String ActiveZones = "biomight.cell.neuronglial.nueron.ActiveZones";
	public final static String Axon = "biomight.cell.neuronglial.nueron.Axon";
	public final static String Axons = "biomight.cell.neuronglial.nueron.Axons";
	public final static String AxonTerminal = "biomight.cell.neuronglial.nueron.AxonTerminal";
	public final static String BiPolarNeuron = "biomight.cell.neuronglial.nueron.BiPolarNeuron";
	public final static String ChemicalSynapse = "biomight.cell.neuronglial.nueron.ChemicalSynapse";
	public final static String ConeOfOrigin = "biomight.cell.neuronglial.nueron.ConeOfOrigin";
	public final static String Cyton = "biomight.cell.neuronglial.nueron.Cyton";
	public final static String Dendrite = "biomight.cell.neuronglial.nueron.Dendrite";
	public final static String DendriticSpines = "biomight.cell.neuronglial.nueron.DendriticSpines";
	public final static String DepolarizingCurrents = "biomight.cell.neuronglial.nueron.DepolarizingCurrents";
	public final static String FrommannLines = "biomight.cell.neuronglial.nueron.FrommannLines";
	public final static String HyperpolarizingCurrents = "biomight.cell.neuronglial.nueron.HyperpolarizingCurrents";
	public final static String MedullarySheath = "biomight.cell.neuronglial.nueron.MedullarySheath";
	public final static String MedullatedFibers = "biomight.cell.neuronglial.nueron.MedullatedFibers";
	public final static String MotorEndPlate = "biomight.cell.neuronglial.nueron.MotorEndPlate";
	public final static String MotorNerve = "biomight.cell.neuronglial.nueron.MotorNerve";
	public final static String MotorNerves = "biomight.cell.neuronglial.nueron.MotorNerves";
	public final static String MultiPolarNeuron = "biomight.cell.neuronglial.nueron.MultiPolarNeuron";
	
	public final static String NeuromuscularJunction = "biomight.cell.neuronglial.nueron.NeuromuscularJunction";
	
	public final static String Neuron = "biomight.cell.neuronglial.nueron.Neuron";
	public final static String NeuronRef = "Neuron";
	
	public final static String Neurons = "biomight.cell.neuronglial.nueron.Neurons";
	public final static String NeuronsRef = "Neurons";	
	
	public final static String NisslsGranule = "biomight.cell.neuronglial.nueron.NisslsGranule";
	public final static String NisslsGranules = "biomight.cell.neuronglial.nueron.NisslsGranules";
	public final static String NodeOfRanvier = "biomight.cell.neuronglial.nueron.NodeOfRanvier";
	public final static String NonMedullatedFibers = "biomight.cell.neuronglial.nueron.NonMedullatedFibers";
	public final static String NucleatedSheath = "biomight.cell.neuronglial.nueron.NucleatedSheath";
	public final static String OrgansOfGolgi = "biomight.cell.neuronglial.nueron.OrgansOfGolgi";	
	public final static String PostSynapticDensity = "biomight.cell.neuronglial.nueron.PostSynapticDensity";
	public final static String PrimitiveFibrillaeOfSchultze = "biomight.cell.neuronglial.nueron.PrimitiveFibrillaeOfSchultze";
	public final static String RanvierCross = "biomight.cell.neuronglial.nueron.RanvierCross";
	public final static String ReddishGreySubstance = "biomight.cell.neuronglial.nueron.ReddishGreySubstance";
	public final static String SchwannCell = "biomight.cell.neuronglial.nueron.SchwannCell";
	public final static String SegmentsOfLantermann = "biomight.cell.neuronglial.nueron.SegmentsOfLantermann";
	public final static String SynapticButton = "biomight.cell.neuronglial.nueron.SynapticButton";
	public final static String SynapticCleft = "biomight.cell.neuronglial.nueron.SynapticCleft";
	public final static String UniPolarNeuron = "biomight.cell.neuronglial.nueron.UniPolarNeuron";

	// biomight.cell.nurse
	public final static String OvarianFollicleCell = "biomight.cell.nurse.OvarianFollicleCell";
	public final static String OvarianFollicles = "biomight.cell.nurse.OvarianFollicles";
	public final static String SertoliCell = "biomight.cell.nurse.SertoliCell";
	public final static String SertoliCells = "biomight.cell.nurse.SertoliCells";

	// biomight.cell.pigment
	public final static String Melanocyte = "biomight.cell.pigment.Melanocyte";
	public final static String Melanocytes = "biomight.cell.pigment.Melanocytes";
	public final static String RetinalPigmentedEpithelialCell = "biomight.cell.pigment.RetinalPigmentedEpithelialCell";

	// biomight.cell.secreting
	public final static String AcinarCell = "biomight.cell.secreting.AcinarCell";
	public final static String ZonaFasciculataCell = "biomight.cell.secreting.ZonaFasciculataCell";
	public final static String ZonaFasciculataCells = "biomight.cell.secreting.ZonaFasciculataCells";
	public final static String ZonaGlomerulosaCell = "biomight.cell.secreting.ZonaGlomerulosaCell";
	public final static String ZonaGlomerulosaCells = "biomight.cell.secreting.ZonaGlomerulosaCells";
	public final static String ZonaReticularisCell = "biomight.cell.secreting.ZonaReticularisCell";
	public final static String ZonaReticularisCells = "biomight.cell.secreting.ZonaReticularisCells";

	// biomight.cell.sensorytransducer
	public final static String EyePhotoreceptorBlueSenseConeCell = "biomight.cell.sensorytransducer.EyePhotoreceptorBlueSenseConeCell";
	public final static String EyePhotoreceptorGreenSenseConeCell = "biomight.cell.sensorytransducer.EyePhotoreceptorGreenSenseConeCell";
	public final static String EyePhotoreceptorRedSenseConeCell = "biomight.cell.sensorytransducer.EyePhotoreceptorRedSenseConeCell";
	public final static String EyePhotoreceptorRodCell = "biomight.cell.sensorytransducer.EyePhotoreceptorRodCell";
	public final static String TasteBudType1Cell = "biomight.cell.sensorytransducer.TasteBudType1Cell";


	// biomight.cell.wetstratifiedbarrierepithelial
	public final static String BasalEpithelialAnalCanalCell = "biomight.cell.wetstratifiedbarrierepithelial.BasalEpithelialAnalCanalCell";
	public final static String BasalEpithelialCorneaCell = "biomight.cell.wetstratifiedbarrierepithelial.BasalEpithelialCorneaCell";
	public final static String BasalEpithelialEsophagusCell = "biomight.cell.wetstratifiedbarrierepithelial.BasalEpithelialEsophagusCell";
	public final static String BasalEpithelialOralCavityCell = "biomight.cell.wetstratifiedbarrierepithelial.BasalEpithelialOralCavityCell";
	public final static String BasalEpithelialTongueCell = "biomight.cell.wetstratifiedbarrierepithelial.BasalEpithelialTongueCell";
	public final static String BasalEpithelialUrethraCell = "biomight.cell.wetstratifiedbarrierepithelial.BasalEpithelialUrethraCell";
	public final static String BasalEpithelialVaginaCell = "biomight.cell.wetstratifiedbarrierepithelial.BasalEpithelialVaginaCell";
	public final static String SurfaceEpithelialAnalCanalCell = "biomight.cell.wetstratifiedbarrierepithelial.SurfaceEpithelialAnalCanalCell";
	public final static String SurfaceEpithelialCorneaCell = "biomight.cell.wetstratifiedbarrierepithelial.SurfaceEpithelialCorneaCell";
	public final static String SurfaceEpithelialEsophagusCell = "biomight.cell.wetstratifiedbarrierepithelial.SurfaceEpithelialEsophagusCell";
	public final static String SurfaceEpithelialOralCavityCell = "biomight.cell.wetstratifiedbarrierepithelial.SurfaceEpithelialOralCavityCell";
	public final static String SurfaceEpithelialTongueCell = "biomight.cell.wetstratifiedbarrierepithelial.SurfaceEpithelialTongueCell";
	public final static String SurfaceEpithelialUrethraCell = "biomight.cell.wetstratifiedbarrierepithelial.SurfaceEpithelialUrethraCell";
	public final static String SurfaceEpithelialVaginaCell = "biomight.cell.wetstratifiedbarrierepithelial.SurfaceEpithelialVaginaCell";
	public final static String UrinaryEpitheliumCell = "biomight.cell.wetstratifiedbarrierepithelial.UrinaryEpitheliumCell";

	

	

	/********************************************************************************
	 * 
	 * HELMINTHS
	 * 
	 ********************************************************************************/
	
	// biomight.helminths.cestodes
	public final static String Cestode = "biomight.helminths.cestodes.Cestode";
	public final static String DiphyllobothriumLatum = "biomight.helminths.cestodes.DiphyllobothriumLatum";
	public final static String DipilidiumCaninum = "biomight.helminths.cestodes.DipilidiumCaninum";
	public final static String EchinoCoccusGranulosus = "biomight.helminths.cestodes.EchinoCoccusGranulosus";
	public final static String EchinoCoccusMultiLocularis = "biomight.helminths.cestodes.EchinoCoccusMultiLocularis";
	public final static String HymenoLepisNana = "biomight.helminths.cestodes.HymenoLepisNana";
	public final static String Operculum = "biomight.helminths.cestodes.Operculum";
	public final static String PlasmodiumVivax = "biomight.helminths.cestodes.PlasmodiumVivax";
	public final static String Proglottids = "biomight.helminths.cestodes.Proglottids";
	public final static String Scolex = "biomight.helminths.cestodes.Scolex";
	public final static String TaeniaSaginata = "biomight.helminths.cestodes.TaeniaSaginata";
	public final static String TaeniaSolium = "biomight.helminths.cestodes.TaeniaSolium";
	public final static String Tapeworm = "biomight.helminths.cestodes.Tapeworm";

	// biomight.helminths.nematodes
	public final static String AncylostomaBraziliense = "biomight.helminths.nematodes.AncylostomaBraziliense";
	public final static String AncylostomaCaninum = "biomight.helminths.nematodes.AncylostomaCaninum";
	public final static String AncylostomaDuodenale = "biomight.helminths.nematodes.AncylostomaDuodenale";
	public final static String AngiostrongylusCantonensis = "biomight.helminths.nematodes.AngiostrongylusCantonensis";
	public final static String AnisakisSimplex = "biomight.helminths.nematodes.AnisakisSimplex";
	//public final static String AscarisLumbricoides = "biomight.helminths.nematodes.AscarisLumbricoides";
	public final static String DracunculusMedinensis = "biomight.helminths.nematodes.DracunculusMedinensis";
	//public final static String EnterobiusVermicularis = "biomight.helminths.nematodes.EnterobiusVermicularis";
	public final static String LoaLoa = "biomight.helminths.nematodes.LoaLoa";
	public final static String NecatorAmericanus = "biomight.helminths.nematodes.NecatorAmericanus";
	public final static String Nematode = "biomight.helminths.nematodes.Nematode";
	public final static String Nematodes = "biomight.helminths.nematodes.Nematodes";
	public final static String OnchocercaVolvulus = "biomight.helminths.nematodes.OnchocercaVolvulus";
	public final static String PseudoterranovaDecepiens = "biomight.helminths.nematodes.PseudoterranovaDecepiens";
	//public final static String StrongyloidesStercoralis = "biomight.helminths.nematodes.StrongyloidesStercoralis";
	public final static String ToxocaraCanii = "biomight.helminths.nematodes.ToxocaraCanii";
	public final static String ToxocaraCati = "biomight.helminths.nematodes.ToxocaraCati";
	//public final static String TrichurisTrichiura = "biomight.helminths.nematodes.TrichurisTrichiura";
	public final static String WuchereriaBancrofti = "biomight.helminths.nematodes.WuchereriaBancrofti";

	// biomight.helminths.trematodes
	public final static String ClonorchrisSinensis = "biomight.helminths.trematodes.ClonorchrisSinensis";
	public final static String FasciolaHepatica = "biomight.helminths.trematodes.FasciolaHepatica";
	public final static String FasciolopsisBuski = "biomight.helminths.trematodes.FasciolopsisBuski";
	public final static String HeterophyesHeterophyes = "biomight.helminths.trematodes.HeterophyesHeterophyes";
	public final static String ParagonimusWestermani = "biomight.helminths.trematodes.ParagonimusWestermani";
	public final static String SchistosomaHaematobium = "biomight.helminths.trematodes.SchistosomaHaematobium";
	public final static String SchistosomaJaponicum = "biomight.helminths.trematodes.SchistosomaJaponicum";
	public final static String SchistosomaMansoni = "biomight.helminths.trematodes.SchistosomaMansoni";
	public final static String Trematode = "biomight.helminths.trematodes.Trematode";
	public final static String Trematodes = "biomight.helminths.trematodes.Trematodes";
	
	
	/********************************************************************************
	 * 
	 * TISSUES
	 * 
	 ********************************************************************************/

	public final static String TissueLibrary = "biomight.system.tissue.";

	// biomight.system.tissue
	public final static String Tissue = "biomight.system.tissue.Tissue";
	public final static String TissueRef = "Tissue";
	
	public final static String Tissues = "biomight.system.tissue.Tissues";		
	public final static String TissuesRef = "Tissues";
	
	public final static String AreolarTissue = "biomight.system.tissue.connective.AreolarTissue";
	public final static String AreolarTissueRef = "AreolarTissue";
	
	public final static String AdiposeTissue = "biomight.system.tissue.connective.AdiposeTissue";
	public final static String AdiposeTissueRef = "AdiposeTissue";
	
	// biomight.system.tissue.connective		
	public final static String AreolarConnectiveTissue = "biomight.system.tissue.connective.AreolarConnectiveTissue";	
	public final static String AreolarConnectiveTissueRef = "AreolarConnectiveTissue";

	public final static String ConnectiveTissues = "biomight.system.tissue.connective.ConnectiveTissues;";
	public final static String ConnectiveTissuesRef = "ConnectiveTissues";

	public final static String ConnectiveTissue = "biomight.system.tissue.connective.ConnectiveTissue";	
	public final static String ConnectiveTissueRef = "ConnectiveTissue";
	
	public final static String CostalCartilages = "biomight.system.cartilage.CostalCartilages;";
	public final static String CostalCartilagesRef = "CostalCartilages";
	
	public final static String CostalCartilage = "biomight.system.cartilage.CostalCartilage;";
	public final static String CostalCartilageRef = "CostalCartilage";
	
	
	//public final static String ConnectiveTissue = "biomight.system.tissue.connective.CostalCartilage;";
	//public final static String ConnectiveTissueRef = "ConnectiveTissue";
	
	public final static String DenseConnectiveTissue = "biomight.system.tissue.connective.DenseConnectiveTissue";
	public final static String DenseConnectiveTissueRef = "TDenseConnectiveTissue";
	
	public final static String ExtraCellularMatrix = "biomight.system.tissue.connective.ExtraCellularMatrix";
	public final static String ExtraCellularMatrixRef = "ExtraCellularMatrix";
	
	public final static String FibrousConnectiveTissue = "biomight.system.tissue.connective.FibrousConnectiveTissue";
	public final static String FibrousConnectiveTissueRef = "FibrousConnectiveTissue";
	
	public final static String GallBladderConnectiveTissue = "biomight.system.tissue.connective.GallBladderConnectiveTissue";
	public final static String GallBladderConnectiveTissueRef = "GallBladderConnectiveTissue";
	
	public final static String LaminaPropriaTissue = "biomight.system.tissue.connective.LaminaPropriaTissue";
	public final static String LaminaPropriaTissueRef = "LaminaPropriaTissue";
	
	public final static String LooseConnectiveTissue = "biomight.system.tissue.connective.LooseConnectiveTissue";
	public final static String LooseConnectiveTissueRef = "LooseConnectiveTissue";
	
	public final static String ReticularConnectiveTissue = "biomight.system.tissue.connective.ReticularConnectiveTissue";
	public final static String ReticularConnectiveTissueRef = "ReticularConnectiveTissue";
	
	// biomight.system.tissue.connective.blood	
	public final static String Blood = "biomight.system.tissue.connective.blood.Blood";	
	public final static String BloodRef = "Blood";
	
	
	// biomight.system.tissue.connective.bone	
	public final static String Bone = "biomight.system.tissue.connective.bone.Bone";
	public final static String BoneRef = "Bone";
	
	public final static String BoneMarrow = "biomight.system.tissue.connective.bone.BoneMarrow";
	public final static String BoneMarrowRef = "";
	
	public final static String BoneTissue = "biomight.system.tissue.connective.bone.BoneTissue";
	public final static String BoneTissueRef = "BoneTissue";
	
	public final static String Osteons = "biomight.system.tissue.connective.bone.Osteons";
	public final static String OsteonsRef = "Osteons";
	
	public final static String ResorptionSpaces = "biomight.system.tissue.connective.bone.ResorptionSpaces";	
	public final static String ResorptionSpacesRef = "";
	
	// biomight.system.tissue.edothelial
	public final static String EndotheliumTissue = "biomight.system.tissue.edothelial.EndotheliumTissue";	
	public final static String EndotheliumTissueRef = "EndotheliumTissue";
			
	// biomight.system.tissue.epithelial	
	// There is a generalized routine for EpitheliumTissue,so set up some refernences
	public final static String NeckEpithelium = "biomight.system.tissue.epithelial.EpitheliumTissue";
	public final static String NeckEpitheliumRef = "NeckEpithelium";

	public final static String BackEpithelium = "biomight.system.tissue.epithelial.EpitheliumTissue";
	public final static String BackEpitheliumRef = "BackEpithelium";

	public final static String ChestEpithelium = "biomight.system.tissue.epithelial.EpitheliumTissue";
	public final static String ChestEpitheliumRef = "ChestEpithelium";

	public final static String ShoulderEpithelium = "biomight.system.tissue.epithelial.EpitheliumTissue";
	public final static String ShoulderEpitheliumRef = "ShoulderEpithelium";

	public final static String ArmEpithelium = "biomight.system.tissue.epithelial.EpitheliumTissue";
	public final static String ArmEpitheliumRef = "ArmEpithelium";

	public final static String ForeArmEpithelium = "biomight.system.tissue.epithelial.EpitheliumTissue";
	public final static String ForeArmEpitheliumRef = "ForeArmEpithelium";

	public final static String ElbowEpithelium = "biomight.system.tissue.epithelial.EpitheliumTissue";
	public final static String ElbowEpitheliumRef = "ElbowEpithelium";

	public final static String WristEpithelium = "biomight.system.tissue.epithelial.EpitheliumTissue";
	public final static String WristEpitheliumRef = "WristEpithelium";

	public final static String HandEpithelium = "biomight.system.tissue.epithelial.EpitheliumTissue";
	public final static String HandEpitheliumRef = "HandEpithelium";
	
	public final static String AbdomenEpithelium = "biomight.system.tissue.epithelial.EpitheliumTissue";
	public final static String AbdomenEpitheliumRef = "AbdomenEpithelium";
	
	public final static String HipEpithelium = "biomight.system.tissue.epithelial.EpitheliumTissue";
	public final static String HipEpitheliumRef = "HipEpithelium";
	
	public final static String ThighEpithelium = "biomight.system.tissue.epithelial.EpitheliumTissue";
	public final static String ThighEpitheliumRef = "ThighEpithelium";

	public final static String KneeEpithelium = "biomight.system.tissue.epithelial.EpitheliumTissue";
	public final static String KneeEpitheliumRef = "KneeEpithelium";

	public final static String CnemisEpithelium = "biomight.system.tissue.epithelial.EpitheliumTissue";
	public final static String CnemisEpitheliumRef = "CnemisEpithelium";

	public final static String FootEpithelium = "biomight.system.tissue.epithelial.EpitheliumTissue";
	public final static String FootEpitheliumRef = "FootEpithelium";
	
	public final static String TracheaEpithelium = "biomight.system.tissue.epithelial.EpitheliumTissue";
	public final static String TracheaEpitheliumRef = "TracheaEpithelium";

	public final static String EsophagusEpithelium = "biomight.system.tissue.epithelial.EpitheliumTissue";
	public final static String EsophagusEpitheliumRef = "EsophagusEpithelium";

	public final static String BronchusEpithelium = "biomight.system.tissue.epithelial.EpitheliumTissue";
	public final static String BronchusEpitheliumRef = "BronchusEpithelium";

	public final static String LobarBronchusEpithelium = "biomight.system.tissue.epithelial.EpitheliumTissue";
	public final static String LobarBronchusEpitheliumRef = "LobarBronchusEpithelium";
	
	public final static String SegmentalinicBronchusEpithelium = "biomight.system.tissue.epithelial.EpitheliumTissue";
	public final static String SegmentalinicBronchusEpitheliumRef = "SegmentalinicBronchusEpithelium";
	
	public final static String EpitheliumTissue = "biomight.system.tissue.epithelial.EpitheliumTissue";
	public final static String EpitheliumTissueRef = "EpitheliumTissue";
	
	
	public final static String PseudoStratifiedEpithelialTissue = "biomight.system.tissue.epithelial.PseudoStratifiedEpithelialTissue";
	public final static String PseudoStratifiedEpithelialTissueRef = "TISSUE.EPI.PSEUDOSTRAT";
	
	public final static String RespiratoryEpitheliumTissue = "biomight.system.tissue.epithelial.RespiratoryEpitheliumTissue";
	public final static String RespiratoryEpitheliumTissueRef = "TISSUE.EPI.RESP";
	
	public final static String RespiratoryMucosa = "biomight.system.tissue.epithelial.RespiratoryMucosa";
	public final static String RespiratoryMucosaRef = "TISSUE.EPI.RESPMUCOSA";
	
	public final static String SimpleEpithelialTissue = "biomight.system.tissue.epithelial.SimpleEpithelialTissue";	
	public final static String SimpleEpithelialTissueRef = "TISSUE.EPI.SIMPLE";
	
	public final static String StratifiedEpithelialTissue = "biomight.system.tissue.epithelial.StratifiedEpithelialTissue";	
	public final static String StratifiedEpithelialTissueRef = "TISSUE.EPI.STRAT";
	
	public final static String TransitionalEpitheliumTissue = "biomight.system.tissue.epithelial.TransitionalEpitheliumTissue";
	public final static String TransitionalEpitheliumTissueRef = "TISSUE.EPI.TRANS";
	
	// biomight.system.tissue.fibers
	public final static String AnteriorExternalArcuateFibers = "biomight.system.tissue.fibers.AnteriorExternalArcuateFibers";
	public final static String ArcuateFibers = "biomight.system.tissue.fibers.ArcuateFibers";
	public final static String CerebellarFibers = "biomight.system.tissue.fibers.CerebellarFibers";
	public final static String CerebrospinalFibers = "biomight.system.tissue.fibers.CerebrospinalFibers";
	public final static String CommissureFibers = "biomight.system.tissue.fibers.CommissureFibers";
	public final static String DeepTransverseFibers = "biomight.system.tissue.fibers.DeepTransverseFibers";
	public final static String ElasticFibers = "biomight.system.tissue.fibers.ElasticFibers";
	public final static String Fibraepropriae = "biomight.system.tissue.fibers.Fibraepropriae";
	public final static String FrontopontineFibers = "biomight.system.tissue.fibers.FrontopontineFibers";
	public final static String LongitudinalFasciculi = "biomight.system.tissue.fibers.LongitudinalFasciculi";
	public final static String OlivoCerebellarFibers = "biomight.system.tissue.fibers.OlivoCerebellarFibers";
	public final static String Peduncle = "biomight.system.tissue.fibers.Peduncle";
	public final static String Peduncles = "biomight.system.tissue.fibers.Peduncles";
	public final static String PosteriorExternalArcuateFibers = "biomight.system.tissue.fibers.PosteriorExternalArcuateFibers";
	public final static String ProjectionFibers = "biomight.system.tissue.fibers.ProjectionFibers";
	public final static String SuperficialTransverseFibers = "biomight.system.tissue.fibers.SuperficialTransverseFibers";
	public final static String TemporopontineFibers = "biomight.system.tissue.fibers.TemporopontineFibers";
	public final static String TendrilFibers = "biomight.system.tissue.fibers.TendrilFibers";
	
	// biomight.system.tissue.germ
	public final static String GermTissue = "biomight.system.tissue.germ.GermTissue";
	
	// biomight.system.tissue.membranes
	public final static String LumenOfDigestiveTract = "biomight.system.tissue.membranes.LumenOfDigestiveTract";
	public final static String MossyFibers = "biomight.system.tissue.membranes.MossyFibers";
	public final static String Mucosa = "biomight.system.tissue.membranes.Mucosa";
	public final static String MuscularisExterna = "biomight.system.tissue.membranes.MuscularisExterna";
	public final static String MuscularisMucosae = "biomight.system.tissue.membranes.MuscularisMucosae";
	public final static String PeritonealCavity = "biomight.system.tissue.membranes.PeritonealCavity";
	public final static String PurkinjeLayer = "biomight.system.tissue.membranes.PurkinjeLayer";
	public final static String SemiPermeableMembrane = "biomight.system.tissue.membranes.SemiPermeableMembrane";
	public final static String Serosa = "biomight.system.tissue.membranes.Serosa";
	public final static String SerousCavities = "biomight.system.tissue.membranes.SerousCavities";
	public final static String SerousMembrane = "biomight.system.tissue.membranes.SerousMembrane";
	public final static String SubMucosa = "biomight.system.tissue.membranes.SubMucosa";
	
	// biomight.system.tissue.membranes.pericardium
	public final static String FibrousPericardium = "biomight.system.tissue.membranes.pericardium.FibrousPericardium";
	public final static String Pericardium = "biomight.system.tissue.membranes.pericardium.Pericardium";
	public final static String SerousPericardium = "biomight.system.tissue.membranes.pericardium.SerousPericardium";

	// biomight.system.tissue.membranes.peritoneum
	public final static String EpiploicForamen = "biomight.system.tissue.membranes.peritoneum.EpiploicForamen";

	public final static String GreaterSac = "biomight.system.tissue.membranes.peritoneum.GreaterSac";
	
	public final static String LesserSac = "biomight.system.tissue.membranes.peritoneum.LesserSac";
	
	public final static String Mesentery = "biomight.system.tissue.membranes.peritoneum.Mesentery";
	public final static String MesenteryRef = "Mesentery";
	
	public final static String ParietalPeritoneum = "biomight.system.tissue.membranes.peritoneum.ParietalPeritoneum";
	
	public final static String Peritoneum = "biomight.system.tissue.membranes.peritoneum.Peritoneum";
	public final static String PeritoneumRef = "Peritoneum";
	
	public final static String VisceralPeritoneum = "biomight.system.tissue.membranes.peritoneum.VisceralPeritoneum";
	public final static String VisceralPeritoneumRef = "VisceralPeritoneum";

	// biomight.system.tissue.membranes.pleurae
	public final static String ParietalPleuraMembrane = "biomight.system.tissue.membranes.pleurae.ParietalPleuraMembrane";
	public final static String Pleurae = "biomight.system.tissue.membranes.pleurae.Pleurae";
	public final static String PleuralCavity = "biomight.system.tissue.membranes.pleurae.PleuralCavity";
	public final static String VisceralPleura = "biomight.system.tissue.membranes.pleurae.VisceralPleura";
	
	// biomight.system.tissue.mesenchyme
	public final static String MesenchymeTissue = "biomight.system.tissue.mesenchyme.MesenchymeTissue";
	public final static String MesenchymeTissueRef = "MesenchymeTissue";
	
	// biomight.system.tissue.mesothelium
	public final static String MesotheliumTissue = "biomight.system.tissue.mesothelium.MesotheliumTissue";
	public final static String MesotheliumTissueRef = "MesotheliumTissue";
	
	// biomight.system.tissue.muscle
	public final static String Endomysium = "biomight.system.tissue.muscle.Endomysium";
	public final static String EndomysiumRef = "Endomysium";

	public final static String Epimysium = "biomight.system.tissue.muscle.Epimysium";
	public final static String EpimysiumRef = "Epimysium";

	public final static String Fascicles = "biomight.system.tissue.muscle.Fascicles";
	public final static String FasciclesRef = "Fascicles";
	
	public final static String Muscle = "biomight.system.tissue.muscle.Muscle";
	public final static String MuscleRef = "Muscle";

	public final static String MuscleFiber = "biomight.system.tissue.muscle.MuscleFiber";
	public final static String MuscleFiberRef = "MuscleFiber";
	
	public final static String Myofibril = "biomight.system.tissue.muscle.Myofibril";
	public final static String MyofibrilRef = "Myofibril";

	public final static String Perimysium = "biomight.system.tissue.muscle.Perimysium";
	public final static String Sacromere = "biomight.system.tissue.muscle.Sacromere";
		
	public final static String Sarcoplasm = "biomight.system.tissue.muscle.Sarcoplasm";
	public final static String SarcoplasmRef = "Sarcoplasm";

	public final static String MuscleTissue = "biomight.system.tissue.muscle.MuscleTissue";
	public final static String MuscleTissueRef = "MuscleTissue";

	public final static String SmoothMuscleTissue = "biomight.system.tissue.muscle.SmoothMuscleTissue";
	public final static String SmoothMuscleTissueRef = "SmoothMuscleTissue";
	
	// biomight.system.tissue.muscle.cardiac
	public final static String CardiacMuscle = "biomight.system.tissue.muscle.cardiac.CardiacMuscle";
	public final static String CardiacMuscleRef = "CardiacMuscle";
	
	public final static String Muscles = "biomight.system.MuscularSystem";
	public final static String MusclesRef = "MuscularSystem";
	
	// biomight.system.tissue.muscle.skeletal	
	public final static String SkeletalMuscle = "biomight.system.tissue.muscle.skeletal.SkeletalMuscle";
	public final static String SkeletalMuscleRef = "SkeletalMuscle";
	
	public final static String TypeIIbMuscle = "biomight.system.tissue.muscle.skeletal.TypeIIbMuscle";
	public final static String TypeIIMuscle = "biomight.system.tissue.muscle.skeletal.TypeIIMuscle";
	public final static String TypeIIxMuscle = "biomight.system.tissue.muscle.skeletal.TypeIIxMuscle";
	public final static String TypeIMuscle = "biomight.system.tissue.muscle.skeletal.TypeIMuscle";

	// biomight.system.tissue.nervous
	public final static String Endoneurium = "biomight.system.tissue.nervous.Endoneurium";
	public final static String Epineurium = "biomight.system.tissue.nervous.Epineurium";
	public final static String Exteroreceptors = "biomight.system.tissue.nervous.Exteroreceptors";
	public final static String Fasciculi = "biomight.system.tissue.nervous.Fasciculi";
	public final static String Funiculus = "biomight.system.tissue.nervous.Funiculus";
	public final static String InteroReceptors = "biomight.system.tissue.nervous.InteroReceptors";
	//public final static String Nerve = "biomight.system.tissue.nervous.Nerve";
	public final static String NerveFibers = "biomight.system.tissue.nervous.NerveFibers";
	
	public final static String NervousTissue = "biomight.system.tissue.nervous.NervousTissue";
	public final static String NervousTissueRef = "NervousTissue";
	
	public final static String NervousTissues = "biomight.system.tissue.nervous.NervousTissues";
	public final static String NervousTissuesRef = "NervousTissues";
	
	public final static String Neuroglia = "biomight.system.tissue.nervous.Neuroglia";
	public final static String Neurokeratin = "biomight.system.tissue.nervous.Neurokeratin";
	public final static String NueronTissue = "biomight.system.tissue.nervous.NueronTissue";
	public final static String Perineurium = "biomight.system.tissue.nervous.Perineurium";
	public final static String Receptors = "biomight.system.tissue.nervous.Receptors";
	public final static String SpheroidalTactileCorpuscles = "biomight.system.tissue.nervous.SpheroidalTactileCorpuscles";
	public final static String VasomotorFibers = "biomight.system.tissue.nervous.VasomotorFibers";
	

	// biomight.system.tissue.placenta
	public final static String PlacentalTissue = "biomight.system.tissue.placenta.PlacentalTissue";

	
	
	public final static String Skin = "biomight.body.organ.skin.Skin";
	public final static String Epidermis = "biomight.body.organ.skin.epidermis.Epidermis";
	public final static String StratumCorneum = "biomight.body.organ.skin.epidermis.StratumCorneum";
	public final static String StratumLucidum = "biomight.body.organ.skin.epidermis.StratumLucidum";
	public final static String StratumGranulosum = "biomight.body.organ.skin.epidermis.Epidermis";
	public final static String StratumSpinosum = "biomight.body.organ.skin.epidermis.Epidermis";
	public final static String StratumBasale = "biomight.body.organ.skin.epidermis.Epidermis";


	
	/********************************************************************************
	 * 
	 * ORGANS
	 * 
	 ********************************************************************************/ 

	 // Organs
	 public final static String Organs = "biomight.body.organ.Organs";
	 public final static String OrgansRef = "Organs";
	 
	 public final static String Trachea = "biomight.body.organ.Trachea";
	 public final static String TracheaRef = "Trachea";
	 
	 public final static String Bladder = "biomight.body.organ.bladder.Bladder";
	 public final static String BladderRef = "Bladder";
	 
	 public final static String Spleen = "biomight.body.gland.spleen.Spleen";
	 public final static String SpleenRef = "Spleen";
	 
	 public final static String SplenicChord = "biomight.body.gland.spleen.SplenicChord";
	 public final static String SplenicChordRef = "SplenicChord";
	 
	 public final static String SplenicSinus = "biomight.body.gland.spleen.SplenicSinus";
	 public final static String SplenicSinusRef = "SplenicSinus";
	 
	 public final static String SplenicPulp = "biomight.body.gland.spleen.SplenicPulp";
	 public final static String SplenicPulpRef = "SplenicPulp";
	 
	 public final static String SpleenPosteriorBorder = "biomight.body.gland.spleen.SpleenPosteriorBorder";
	 public final static String SpleenPosteriorBorderRef = "SpleenPosteriorBorder";
	 
	 public final static String MalpighianBodies = "biomight.body.gland.spleen.MalpighianBodies";
	 public final static String MalpighianBodiesRef = "SpleenPosteriorBorder";
	 
	 public final static String SpleenGastricSurface = "biomight.body.gland.spleen.SpleenGastricSurface";
	 public final static String SpleenGastricSurfaceRef = "SpleenGastricSurface";
	 
	 public final static String SpleenFibroelasticCoat = "biomight.body.gland.spleen.SpleenFibroelasticCoat";
	 public final static String SpleenFibroelasticCoatRef = "SpleenFibroelasticCoat";
	 
	 public final static String SpleenExternalSerousCoat = "biomight.body.gland.spleen.SpleenExternalSerousCoat"; 
	 public final static String SpleenExternalSerousCoatRef = "SpleenExternalSerousCoat"; 
	 
	 public final static String SpleenAreolae = "biomight.body.gland.spleen.SpleenAreolae"; 
	 public final static String SpleenAnteriorBorder = "biomight.body.gland.spleen.SpleenAnteriorBorder"; 
	 
	 
	// BRAIN	 
	public final static String Brain = "biomight.body.brain.Brain";
	public final static String BrainRef = "Brain";

	public final static String Cerebrums = "biomight.body.brain.Cerebrums";
	public final static String CerebrumsRef = "Cerebrums";
	
	public final static String Cerebrum = "biomight.body.brain.Cerebrum";
	public final static String CerebrumRef = "Cerebrum";
	
	public final static String Cerebellums = "biomight.body.brain.Cerebellums";
	public final static String CerebellumsRef = "Cerebellums";
	
	public final static String Cerebellum = "biomight.body.brain.Cerebellum";
	public final static String CerebellumRef = "Cerebellum";
	
	//public final static String Cerebellum = "biomight.body.brain.rhombencephalon.metencephalon.cerebellum.Cerebellum";
	//public final static String Cerebellum = "biomight.body.brain.rhombencephalon.metencephalon.cerebellum.Cerebellum";
	//public final static String cerebrums = "Cerebellum";

	
	public final static String AnteriorCornu = "biomight.body.brain.AnteriorCornu";
	//public final static String ArachnoidGranulations = "biomight.body.brain.ArachnoidGranulations";
	public final static String ArachnoidMater = "biomight.body.brain.ArachnoidMater";
	public final static String BrainStem = "biomight.body.brain.BrainStem";
	public final static String CentralMedullaCanal = "biomight.body.brain.CentralMedullaCanal";
	public final static String CerebelloMedullaryCistern = "biomight.body.brain.CerebelloMedullaryCistern";
	public final static String CerebralAqueduct = "biomight.body.brain.CerebralAqueduct";
	public final static String ChoroidPlexus = "biomight.body.brain.ChoroidPlexus";
	//public final static String Cingulum = "biomight.body.brain.Cingulum";
	public final static String DentateGyri = "biomight.body.brain.DentateGyri";
	public final static String DiaphragmaSellae = "biomight.body.brain.DiaphragmaSellae";
	public final static String DienCephalon = "biomight.body.brain.DienCephalon";
	public final static String DuraMater = "biomight.body.brain.DuraMater";
	public final static String DuraMaterCranial = "biomight.body.brain.DuraMaterCranial";
	public final static String DuraMaterSpinal = "biomight.body.brain.DuraMaterSpinal";
	public final static String EpiduralSpace = "biomight.body.brain.EpiduralSpace";
	public final static String FalxCerebelli = "biomight.body.brain.FalxCerebelli";
	public final static String FalxCerebri = "biomight.body.brain.FalxCerebri";
	public final static String FilumTerminaleExternum = "biomight.body.brain.FilumTerminaleExternum";
	public final static String FilumTerminaleInternum = "biomight.body.brain.FilumTerminaleInternum";
	public final static String HabenularCommissure = "biomight.body.brain.HabenularCommissure";
	//public final static String HippocampalFissure = "biomight.body.brain.HippocampalFissure";
	//public final static String IncisuraTemporalis = "biomight.body.brain.IncisuraTemporalis";
	public final static String InternalCapsule = "biomight.body.brain.InternalCapsule";
	public final static String InterPeduncularCistern = "biomight.body.brain.InterPeduncularCistern";
	public final static String InterVentricularForamina = "biomight.body.brain.InterVentricularForamina";
	public final static String LateralAperature = "biomight.body.brain.LateralAperature";
	public final static String LumbarCistern = "biomight.body.brain.LumbarCistern";
	public final static String MedianAperature = "biomight.body.brain.MedianAperature";
	public final static String Meninges = "biomight.body.brain.Meninges";
	public final static String MentenCephalon = "biomight.body.brain.MentenCephalon";
	public final static String MiddleCommissure = "biomight.body.brain.MiddleCommissure";
	public final static String MotorCortex = "biomight.body.brain.MotorCortex";
	public final static String PiaMater = "biomight.body.brain.PiaMater";
	public final static String PontineCistern = "biomight.body.brain.PontineCistern";
	public final static String RhombenCephalon = "biomight.body.brain.RhombenCephalon";
	public final static String SensoryCortex = "biomight.body.brain.SensoryCortex";
	public final static String StriaMedullaris = "biomight.body.brain.StriaMedullaris";
	public final static String SubArachnoidSpace = "biomight.body.brain.SubArachnoidSpace";
	public final static String SuperiorColliculus = "biomight.body.brain.SuperiorColliculus";
	public final static String TelaChoroidea = "biomight.body.brain.TelaChoroidea";
	public final static String TentoriumCerebelli = "biomight.body.brain.TentoriumCerebelli";
	public final static String VentricalFourth = "biomight.body.brain.VentricalFourth";
	public final static String VentricleLateral = "biomight.body.brain.VentricleLateral";
	public final static String VentricleThird = "biomight.body.brain.VentricleThird";
	public final static String WernickesArea = "biomight.body.brain.WernickesArea";
	 
	// biomight.body.brain.mesencephalon
	public final static String CentralGrayStratum = "biomight.body.brain.mesencephalon.CentralGrayStratum";
	public final static String CentralNuclei = "biomight.body.brain.mesencephalon.CentralNuclei";
	//public final static String CerebralAqueduct = "biomight.body.brain.mesencephalon.CerebralAqueduct";
	public final static String CerebralPeduncle = "biomight.body.brain.mesencephalon.CerebralPeduncle";
	public final static String CerebralPeduncles = "biomight.body.brain.mesencephalon.CerebralPeduncles";
	public final static String CorporaQuadrigemina = "biomight.body.brain.mesencephalon.CorporaQuadrigemina";
	public final static String CrusCerebri = "biomight.body.brain.mesencephalon.CrusCerebri";
	public final static String Crusta = "biomight.body.brain.mesencephalon.Crusta";
	public final static String DeitersNucleus = "biomight.body.brain.mesencephalon.DeitersNucleus";
	public final static String DorsalNucleus = "biomight.body.brain.mesencephalon.DorsalNucleus";
	public final static String EdingerWestphalNucleus = "biomight.body.brain.mesencephalon.EdingerWestphalNucleus";
	public final static String FrenulumVeli = "biomight.body.brain.mesencephalon.FrenulumVeli";
	public final static String GanglionHabenulae = "biomight.body.brain.mesencephalon.GanglionHabenulae";
	public final static String InferiorColliculi = "biomight.body.brain.mesencephalon.InferiorColliculi";
	public final static String InferiorColliculus = "biomight.body.brain.mesencephalon.InferiorColliculus";
	public final static String InterPeduncularFossa = "biomight.body.brain.mesencephalon.InterPeduncularFossa";
	public final static String InterPeduncularGanglion = "biomight.body.brain.mesencephalon.InterPeduncularGanglion";
	public final static String InterPeduncularSpace = "biomight.body.brain.mesencephalon.InterPeduncularSpace";
	public final static String LateralLemniscus = "biomight.body.brain.mesencephalon.LateralLemniscus";
	public final static String LateralSulcus = "biomight.body.brain.mesencephalon.LateralSulcus";
	public final static String MedialLemniscus = "biomight.body.brain.mesencephalon.MedialLemniscus";
	//public final static String MedialLongitudinalFasciculus = "biomight.body.brain.mesencephalon.MedialLongitudinalFasciculus";
	public final static String MesencephalicDuct = "biomight.body.brain.mesencephalon.MesencephalicDuct";
	
	public final static String Mesencephalon = "biomight.body.brain.mesencephalon.Mesencephalon";
	public final static String MesencephalonRef = "Mesencephalon";
	
	public final static String MidbrainTegmentum = "biomight.body.brain.mesencephalon.MidbrainTegmentum";
	public final static String OculomotorSulcus = "biomight.body.brain.mesencephalon.OculomotorSulcus";
	public final static String PosteriorPerforatedSubstance = "biomight.body.brain.mesencephalon.PosteriorPerforatedSubstance";
	public final static String Pretectum = "biomight.body.brain.mesencephalon.Pretectum";
	public final static String RedNucleus = "biomight.body.brain.mesencephalon.RedNucleus";
	public final static String RubroSpinalTract = "biomight.body.brain.mesencephalon.RubroSpinalTract";
	public final static String StratumCinereum = "biomight.body.brain.mesencephalon.StratumCinereum";
	public final static String StratumLemnisc = "biomight.body.brain.mesencephalon.StratumLemnisc";
	public final static String StratumOpticum = "biomight.body.brain.mesencephalon.StratumOpticum";
	public final static String SubstantiaNigra = "biomight.body.brain.mesencephalon.SubstantiaNigra";
	public final static String SuperiorBrachium = "biomight.body.brain.mesencephalon.SuperiorBrachium";
	public final static String SuperiorColliculi = "biomight.body.brain.mesencephalon.SuperiorColliculi";
	public final static String Tectum = "biomight.body.brain.mesencephalon.Tectum";
	public final static String Tegmenta = "biomight.body.brain.mesencephalon.Tegmenta";
	public final static String Tegmentum = "biomight.body.brain.mesencephalon.Tegmentum";
	public final static String VentralNucleus = "biomight.body.brain.mesencephalon.VentralNucleus";
	public final static String VestibuloSpinalFasciculus = "biomight.body.brain.mesencephalon.VestibuloSpinalFasciculus";
	
	// biomight.body.brain.misc.occipitallobe
	//public final static String LingualGyrus = "";

	// biomight.body.brain.prosencephalon
	public final static String Diencephalon = "biomight.body.brain.prosencephalon.Diencephalon";
	public final static String DiencephalonRef = "Diencephalon";

	public final static String Prosencephalon = "biomight.body.brain.prosencephalon.Prosencephalon";
	public final static String ProsencephalonRef = "Prosencephalon";
	
	// biomight.body.brain.prosencephalon.diencephalon
	public final static String AnteriorCommissure = "biomight.body.brain.prosencephalon.diencephalon.AnteriorCommissure";
	public final static String AnteriorHypoThalamicArea = "biomight.body.brain.prosencephalon.diencephalon.AnteriorHypoThalamicArea";
	public final static String ArcuateNucleus = "biomight.body.brain.prosencephalon.diencephalon.ArcuateNucleus";
	public final static String CorporaGeniculata = "biomight.body.brain.prosencephalon.diencephalon.CorporaGeniculata";
	public final static String CorpusSubthalamicum = "biomight.body.brain.prosencephalon.diencephalon.CorpusSubthalamicum";
	//public final static String Diencephalon = "biomight.body.brain.prosencephalon.diencephalon.Diencephalon";
	public final static String DorsalHypoThalamicArea = "biomight.body.brain.prosencephalon.diencephalon.DorsalHypoThalamicArea";
	public final static String DorsomedialNucleus = "biomight.body.brain.prosencephalon.diencephalon.DorsomedialNucleus";
	public final static String Epithalamus = "biomight.body.brain.prosencephalon.diencephalon.Epithalamus";
	public final static String Hypophysis = "biomight.body.brain.prosencephalon.diencephalon.Hypophysis";
	public final static String HypoThalamus = "biomight.body.brain.prosencephalon.diencephalon.HypoThalamus";
	public final static String Infundibulum = "biomight.body.brain.prosencephalon.diencephalon.Infundibulum";
	public final static String LateralMamillaryNucleus = "biomight.body.brain.prosencephalon.diencephalon.LateralMamillaryNucleus";
	public final static String MamillaryBody = "biomight.body.brain.prosencephalon.diencephalon.MamillaryBody";
	public final static String MedialMamillaryNucleus = "biomight.body.brain.prosencephalon.diencephalon.MedialMamillaryNucleus";
	public final static String MetaThalamus = "biomight.body.brain.prosencephalon.diencephalon.MetaThalamus";
	public final static String NucleusOfDarkschewitsch = "biomight.body.brain.prosencephalon.diencephalon.NucleusOfDarkschewitsch";
	public final static String OpticChiasm = "biomight.body.brain.prosencephalon.diencephalon.OpticChiasm";
	public final static String ParaVentricularNucleus = "biomight.body.brain.prosencephalon.diencephalon.ParaVentricularNucleus";
	public final static String ParsMamillarisHypoThalami = "biomight.body.brain.prosencephalon.diencephalon.ParsMamillarisHypoThalami";
	public final static String PeriventricularNucleus = "biomight.body.brain.prosencephalon.diencephalon.PeriventricularNucleus";
	public final static String PinealBody = "biomight.body.brain.prosencephalon.diencephalon.PinealBody";
	public final static String PosteriorCommissure = "biomight.body.brain.prosencephalon.diencephalon.PosteriorCommissure";
	public final static String PreMamillaryNucleus = "biomight.body.brain.prosencephalon.diencephalon.PreMamillaryNucleus";
	public final static String PreOpticHypoThalamicArea = "biomight.body.brain.prosencephalon.diencephalon.PreOpticHypoThalamicArea";
	public final static String Pulvinar = "biomight.body.brain.prosencephalon.diencephalon.Pulvinar";
	public final static String SubfornicalOrgan = "biomight.body.brain.prosencephalon.diencephalon.SubfornicalOrgan";
	public final static String SubThalamus = "biomight.body.brain.prosencephalon.diencephalon.SubThalamus";
	public final static String SulcusOfMonro = "biomight.body.brain.prosencephalon.diencephalon.SulcusOfMonro";
	public final static String SuprachiasmaticNucleus = "biomight.body.brain.prosencephalon.diencephalon.SuprachiasmaticNucleus";
	public final static String SupraopticNucleus = "biomight.body.brain.prosencephalon.diencephalon.SupraopticNucleus";
	public final static String Thalamencephalon = "biomight.body.brain.prosencephalon.diencephalon.Thalamencephalon";
	public final static String ThirdVentricle = "biomight.body.brain.prosencephalon.diencephalon.ThirdVentricle";
	public final static String TuberCinereum = "biomight.body.brain.prosencephalon.diencephalon.TuberCinereum";
	public final static String VentroMedialNucleus = "biomight.body.brain.prosencephalon.diencephalon.VentroMedialNucleus";
	public final static String ZonaIncerta = "biomight.body.brain.prosencephalon.diencephalon.ZonaIncerta";

	// biomight.body.brain.prosencephalon.telencephalon
	public final static String AnteriorAscendingRamus = "biomight.body.brain.prosencephalon.telencephalon.AnteriorAscendingRamus";
	public final static String AnteriorCentralGyus = "biomight.body.brain.prosencephalon.telencephalon.AnteriorCentralGyus";
	public final static String AnteriorHorizontalRamus = "biomight.body.brain.prosencephalon.telencephalon.AnteriorHorizontalRamus";
	public final static String AnteriorOrbitalBorder = "biomight.body.brain.prosencephalon.telencephalon.AnteriorOrbitalBorder";
	public final static String AnteriorOrbitalGyrus = "biomight.body.brain.prosencephalon.telencephalon.AnteriorOrbitalGyrus";
	public final static String ArcuateFasciculus = "biomight.body.brain.prosencephalon.telencephalon.ArcuateFasciculus";
	public final static String CalcarineFissure = "biomight.body.brain.prosencephalon.telencephalon.CalcarineFissure";
	public final static String CentralSulcus = "biomight.body.brain.prosencephalon.telencephalon.CentralSulcus";
	public final static String CentralSulcusInferiorGenu = "biomight.body.brain.prosencephalon.telencephalon.CentralSulcusInferiorGenu";
	public final static String CentralSulcusSuperiorGenu = "biomight.body.brain.prosencephalon.telencephalon.CentralSulcusSuperiorGenu";
	public final static String CentrumOvaleMinus = "biomight.body.brain.prosencephalon.telencephalon.CentrumOvaleMinus";
	public final static String CerebralHemispheres = "biomight.body.brain.prosencephalon.telencephalon.CerebralHemispheres";
	public final static String CingulateSulcus = "biomight.body.brain.prosencephalon.telencephalon.CingulateSulcus";
	public final static String CollateralFissure = "biomight.body.brain.prosencephalon.telencephalon.CollateralFissure";
	public final static String CoronaRadiata = "biomight.body.brain.prosencephalon.telencephalon.CoronaRadiata";
	public final static String CorpusCallosum = "biomight.body.brain.prosencephalon.telencephalon.CorpusCallosum";
	public final static String CorpusStriatum = "biomight.body.brain.prosencephalon.telencephalon.CorpusStriatum";
	public final static String Genu = "biomight.body.brain.prosencephalon.telencephalon.Genu";
	public final static String InferiorFrontalSulcus = "biomight.body.brain.prosencephalon.telencephalon.InferiorFrontalSulcus";
	public final static String InferiorOccipitalGyrus = "biomight.body.brain.prosencephalon.telencephalon.InferiorOccipitalGyrus";
	public final static String InferoLateral = "biomight.body.brain.prosencephalon.telencephalon.InferoLateral";
	public final static String InsulaLobe = "biomight.body.brain.prosencephalon.telencephalon.InsulaLobe";
	public final static String LateralCerebralFissure = "biomight.body.brain.prosencephalon.telencephalon.LateralCerebralFissure";
	public final static String LateralOrbitalBorder = "biomight.body.brain.prosencephalon.telencephalon.LateralOrbitalBorder";
	public final static String LateralOrbitalGyrus = "biomight.body.brain.prosencephalon.telencephalon.LateralOrbitalGyrus";
	public final static String LateralVentricles = "biomight.body.brain.prosencephalon.telencephalon.LateralVentricles";
	public final static String LeftCerebralHemisphere = "biomight.body.brain.prosencephalon.telencephalon.LeftCerebralHemisphere";
	public final static String LeftCerebralHemisphereInferiorSurface = "biomight.body.brain.prosencephalon.telencephalon.LeftCerebralHemisphereInferiorSurface";
	public final static String LeftCerebralHemisphereInferiorSurfaceAnterior = "biomight.body.brain.prosencephalon.telencephalon.LeftCerebralHemisphereInferiorSurfaceAnterior";
	public final static String LeftCerebralHemisphereInferiorSurfaceMiddle = "biomight.body.brain.prosencephalon.telencephalon.LeftCerebralHemisphereInferiorSurfaceMiddle";
	public final static String LeftCerebralHemisphereInferiorSurfacePosterior = "biomight.body.brain.prosencephalon.telencephalon.LeftCerebralHemisphereInferiorSurfacePosterior";
	public final static String LeftCerebralHemisphereLateralSurface = "biomight.body.brain.prosencephalon.telencephalon.LeftCerebralHemisphereLateralSurface";
	public final static String LeftCerebralHemisphereMedialSurface = "biomight.body.brain.prosencephalon.telencephalon.LeftCerebralHemisphereMedialSurface";
	public final static String LongitudinalCerebralFissure = "biomight.body.brain.prosencephalon.telencephalon.LongitudinalCerebralFissure";
	public final static String LongitudinalFissure = "biomight.body.brain.prosencephalon.telencephalon.LongitudinalFissure";
	public final static String MedialFrontalSulcus = "biomight.body.brain.prosencephalon.telencephalon.MedialFrontalSulcus";
	public final static String MedialOccipitalBorder = "biomight.body.brain.prosencephalon.telencephalon.MedialOccipitalBorder";
	public final static String MedialOrbitalBorder = "biomight.body.brain.prosencephalon.telencephalon.MedialOrbitalBorder";
	public final static String MedialOrbitalGyrus = "biomight.body.brain.prosencephalon.telencephalon.MedialOrbitalGyrus";
	public final static String Neopallium = "biomight.body.brain.prosencephalon.telencephalon.Neopallium";
	public final static String OccipitalLobe = "biomight.body.brain.prosencephalon.telencephalon.OccipitalLobe";
	public final static String OlfactorySulcus = "biomight.body.brain.prosencephalon.telencephalon.OlfactorySulcus";
	public final static String ParamedialSulcus = "biomight.body.brain.prosencephalon.telencephalon.ParamedialSulcus";
	public final static String ParietoOccipitalFissure = "biomight.body.brain.prosencephalon.telencephalon.ParietoOccipitalFissure";
	public final static String ParsOpticaHypothalami = "biomight.body.brain.prosencephalon.telencephalon.ParsOpticaHypothalami";
	public final static String PosteriorOrbitalGyri = "biomight.body.brain.prosencephalon.telencephalon.PosteriorOrbitalGyri";
	public final static String PosteriorRamus = "biomight.body.brain.prosencephalon.telencephalon.PosteriorRamus";
	public final static String PreOccipitalNotch = "biomight.body.brain.prosencephalon.telencephalon.PreOccipitalNotch";
	public final static String PunctaVasculosa = "biomight.body.brain.prosencephalon.telencephalon.PunctaVasculosa";
	public final static String RightCerebralHemisphere = "biomight.body.brain.prosencephalon.telencephalon.RightCerebralHemisphere";
	public final static String RightCerebralHemisphereInferiorSurface = "biomight.body.brain.prosencephalon.telencephalon.RightCerebralHemisphereInferiorSurface";
	public final static String RightCerebralHemisphereLateralSurface = "biomight.body.brain.prosencephalon.telencephalon.RightCerebralHemisphereLateralSurface";
	public final static String RightCerebralHemisphereMedialSurface = "biomight.body.brain.prosencephalon.telencephalon.RightCerebralHemisphereMedialSurface";
	public final static String Rostrum = "biomight.body.brain.prosencephalon.telencephalon.Rostrum";
	public final static String Splenium = "biomight.body.brain.prosencephalon.telencephalon.Splenium";
	public final static String SulcusCircularis = "biomight.body.brain.prosencephalon.telencephalon.SulcusCircularis";
	public final static String SulcusHabenulae = "biomight.body.brain.prosencephalon.telencephalon.SulcusHabenulae";
	public final static String SuperiorFrontalGyrus = "biomight.body.brain.prosencephalon.telencephalon.SuperiorFrontalGyrus";
	public final static String SuperiorFrontalSulcus = "biomight.body.brain.prosencephalon.telencephalon.SuperiorFrontalSulcus";
	public final static String SuperoMedialBorder = "biomight.body.brain.prosencephalon.telencephalon.SuperoMedialBorder";
	public final static String Telencephalon = "biomight.body.brain.prosencephalon.telencephalon.Telencephalon";
	public final static String TentorialSurface = "biomight.body.brain.prosencephalon.telencephalon.TentorialSurface";
	public final static String ThalamomammillaryFasciculus = "biomight.body.brain.prosencephalon.telencephalon.ThalamomammillaryFasciculus";
	public final static String TrigonumHabenulae = "biomight.body.brain.prosencephalon.telencephalon.TrigonumHabenulae";
	public final static String UncinateFasciculus = "biomight.body.brain.prosencephalon.telencephalon.UncinateFasciculus";
	public final static String WhiteMatter = "biomight.body.brain.prosencephalon.telencephalon.WhiteMatter";

	// biomight.body.brain.prosencephalon.telencephalon.amygdala
	public final static String Amygdala = "biomight.body.brain.prosencephalon.telencephalon.amygdala.Amygdala";

	// biomight.body.brain.prosencephalon.telencephalon.basalganglia
	public final static String BasalGanglia = "biomight.body.brain.prosencephalon.telencephalon.basalganglia.BasalGanglia";
	public final static String Claustrum = "biomight.body.brain.prosencephalon.telencephalon.basalganglia.Claustrum";
	public final static String NucleusAccumbens = "biomight.body.brain.prosencephalon.telencephalon.basalganglia.NucleusAccumbens";
	public final static String VentralStriatum = "biomight.body.brain.prosencephalon.telencephalon.basalganglia.VentralStriatum";

	// biomight.body.brain.prosencephalon.telencephalon.frontallobe
	public final static String AnteriorSuperiorInsularCortices = "biomight.body.brain.prosencephalon.telencephalon.frontallobe.AnteriorSuperiorInsularCortices";
	public final static String FrontalLobe = "biomight.body.brain.prosencephalon.telencephalon.frontallobe.FrontalLobe";
	public final static String HeschlsGyrus = "biomight.body.brain.prosencephalon.telencephalon.frontallobe.HeschlsGyrus";
	public final static String InferiorFrontalGyrus = "biomight.body.brain.prosencephalon.telencephalon.frontallobe.InferiorFrontalGyrus";
	public final static String InferiorFrontalGyrusBasilar = "biomight.body.brain.prosencephalon.telencephalon.frontallobe.InferiorFrontalGyrusBasilar";
	public final static String InferiorFrontalGyrusOrbital = "biomight.body.brain.prosencephalon.telencephalon.frontallobe.InferiorFrontalGyrusOrbital";
	public final static String InferiorFrontalGyrusTraingular = "biomight.body.brain.prosencephalon.telencephalon.frontallobe.InferiorFrontalGyrusTraingular";
	public final static String MiddleFrontalGyrus = "biomight.body.brain.prosencephalon.telencephalon.frontallobe.MiddleFrontalGyrus";
	public final static String MiddleFrontalSulcus = "biomight.body.brain.prosencephalon.telencephalon.frontallobe.MiddleFrontalSulcus";
	public final static String MotorArea = "biomight.body.brain.prosencephalon.telencephalon.frontallobe.MotorArea";
	public final static String OrbitalSulcus = "biomight.body.brain.prosencephalon.telencephalon.frontallobe.OrbitalSulcus";
	public final static String PlanumPolare = "biomight.body.brain.prosencephalon.telencephalon.frontallobe.PlanumPolare";
	public final static String PlanumTemporale = "biomight.body.brain.prosencephalon.telencephalon.frontallobe.PlanumTemporale";
	public final static String PreCentralSulcus = "biomight.body.brain.prosencephalon.telencephalon.frontallobe.PreCentralSulcus";
	public final static String PreFrontalCortex = "biomight.body.brain.prosencephalon.telencephalon.frontallobe.PreFrontalCortex";
	public final static String PreMotorArea = "biomight.body.brain.prosencephalon.telencephalon.frontallobe.PreMotorArea";
	public final static String SuperiorTemporalSulcus = "biomight.body.brain.prosencephalon.telencephalon.frontallobe.SuperiorTemporalSulcus";
	
	// biomight.body.brain.prosencephalon.telencephalon.limbiclobe
	public final static String CingulateGyrus = "biomight.body.brain.prosencephalon.telencephalon.limbiclobe.CingulateGyrus";
	public final static String HippocampalGyrus = "biomight.body.brain.prosencephalon.telencephalon.limbiclobe.HippocampalGyrus";
	public final static String LimbicLobe = "biomight.body.brain.prosencephalon.telencephalon.limbiclobe.LimbicLobe";
	
	// biomight.body.brain.prosencephalon.telencephalon.misc
	public final static String BasalRegionB = "biomight.body.brain.prosencephalon.telencephalon.misc.BasalRegionB";
	public final static String DeepLemniscalTerritory = "biomight.body.brain.prosencephalon.telencephalon.misc.DeepLemniscalTerritory";
	public final static String FornicateGyrus = "biomight.body.brain.prosencephalon.telencephalon.misc.FornicateGyrus";
	public final static String GeniculateRegion = "biomight.body.brain.prosencephalon.telencephalon.misc.GeniculateRegion";
	public final static String GustatoryTerritory = "biomight.body.brain.prosencephalon.telencephalon.misc.GustatoryTerritory";
	public final static String IsoThalamus = "biomight.body.brain.prosencephalon.telencephalon.misc.IsoThalamus";
	public final static String LimbicSystem = "biomight.body.brain.prosencephalon.telencephalon.misc.LimbicSystem";
	public final static String MicroNeurons = "biomight.body.brain.prosencephalon.telencephalon.misc.MicroNeurons";
	public final static String NigralTerritory = "biomight.body.brain.prosencephalon.telencephalon.misc.NigralTerritory";
	public final static String NucleusGeniculatusLateralis = "biomight.body.brain.prosencephalon.telencephalon.misc.NucleusGeniculatusLateralis";
	public final static String NucleusGeniculatusMedialis = "biomight.body.brain.prosencephalon.telencephalon.misc.NucleusGeniculatusMedialis";
	public final static String PallidalTerritory = "biomight.body.brain.prosencephalon.telencephalon.misc.PallidalTerritory";
	public final static String ParaHippocampalGyrus = "biomight.body.brain.prosencephalon.telencephalon.misc.ParaHippocampalGyrus";
	public final static String SuperiorRegionS = "biomight.body.brain.prosencephalon.telencephalon.misc.SuperiorRegionS";
	public final static String ThalamoCorticalNeurons = "biomight.body.brain.prosencephalon.telencephalon.misc.ThalamoCorticalNeurons";
	public final static String Thalamus = "biomight.body.brain.prosencephalon.telencephalon.misc.Thalamus";
	
	// biomight.body.brain.prosencephalon.telencephalon.neocortex
	public final static String NeoCortex = "biomight.body.brain.prosencephalon.telencephalon.neocortex.NeoCortex";

	// biomight.body.brain.prosencephalon.telencephalon.occipitallobe
	public final static String LingualGyrus = "biomight.body.brain.prosencephalon.telencephalon.occipitallobe.LingualGyrus";
	
	// biomight.body.brain.prosencephalon.telencephalon.parietallobe
	public final static String InferiorParietalLobule = "biomight.body.brain.prosencephalon.telencephalon.parietallobe.InferiorParietalLobule";
	public final static String IntraparietalSulcus = "biomight.body.brain.prosencephalon.telencephalon.parietallobe.IntraparietalSulcus";
	public final static String OccipitalRamus = "biomight.body.brain.prosencephalon.telencephalon.parietallobe.OccipitalRamus";
	public final static String ParietalLobe = "biomight.body.brain.prosencephalon.telencephalon.parietallobe.ParietalLobe";
	public final static String PostCentralSulcus = "biomight.body.brain.prosencephalon.telencephalon.parietallobe.PostCentralSulcus";
	public final static String SuperiorParietalLobule = "biomight.body.brain.prosencephalon.telencephalon.parietallobe.SuperiorParietalLobule";
	public final static String TransverseOccipitalSulcus = "biomight.body.brain.prosencephalon.telencephalon.parietallobe.TransverseOccipitalSulcus";

	// biomight.body.brain.prosencephalon.telencephalon.rhinencephalon
	public final static String ColumnsOfFornix = "biomight.body.brain.prosencephalon.telencephalon.rhinencephalon.ColumnsOfFornix";
	public final static String DentateGyrus = "biomight.body.brain.prosencephalon.telencephalon.rhinencephalon.DentateGyrus";
	public final static String FasciaDentataHippocampi = "biomight.body.brain.prosencephalon.telencephalon.rhinencephalon.FasciaDentataHippocampi";
	public final static String Fornix = "biomight.body.brain.prosencephalon.telencephalon.rhinencephalon.Fornix";
	public final static String Hippocampus = "biomight.body.brain.prosencephalon.telencephalon.rhinencephalon.Hippocampus";
	public final static String MammillaryBody = "biomight.body.brain.prosencephalon.telencephalon.rhinencephalon.MammillaryBody";
	public final static String Rhinencenphalon = "biomight.body.brain.prosencephalon.telencephalon.rhinencephalon.Rhinencenphalon";
	public final static String SeptumPellucidum = "biomight.body.brain.prosencephalon.telencephalon.rhinencephalon.SeptumPellucidum";
	public final static String SeptumPellucidumCavity = "biomight.body.brain.prosencephalon.telencephalon.rhinencephalon.SeptumPellucidumCavity";
	public final static String SubCallosalGyrus = "biomight.body.brain.prosencephalon.telencephalon.rhinencephalon.SubCallosalGyrus";
	public final static String SupraCallosalGyrus = "biomight.body.brain.prosencephalon.telencephalon.rhinencephalon.SupraCallosalGyrus";
	
	// biomight.body.brain.prosencephalon.telencephalon.rhinencephalon.olfactorylobe
	public final static String AnteriorPerforatedSubstance = "biomight.body.brain.prosencephalon.telencephalon.rhinencephalon.olfactorylobe.AnteriorPerforatedSubstance";
	public final static String OlfactoryBulb = "biomight.body.brain.prosencephalon.telencephalon.rhinencephalon.olfactorylobe.OlfactoryBulb";
	public final static String OlfactoryLobe = "biomight.body.brain.prosencephalon.telencephalon.rhinencephalon.olfactorylobe.OlfactoryLobe";
	public final static String OlfactoryTract = "biomight.body.brain.prosencephalon.telencephalon.rhinencephalon.olfactorylobe.OlfactoryTract";
	public final static String OlfactoryTrigone = "biomight.body.brain.prosencephalon.telencephalon.rhinencephalon.olfactorylobe.OlfactoryTrigone";
	public final static String ParolfactoryAreaOfBroca = "biomight.body.brain.prosencephalon.telencephalon.rhinencephalon.olfactorylobe.ParolfactoryAreaOfBroca";

	// biomight.body.brain.prosencephalon.telencephalon.rhinencephalon.subcallosal
	public final static String SubCallosal = "biomight.body.brain.prosencephalon.telencephalon.rhinencephalon.subcallosal.SubCallosal";
	
	// biomight.body.brain.prosencephalon.telencephalon.rhinencephalon.uncus
	public final static String Uncus = "biomight.body.brain.prosencephalon.telencephalon.rhinencephalon.uncus.Uncus";
	
	// biomight.body.brain.prosencephalon.telencephalon.temporallobe
	public final static String CallosalFissure = "biomight.body.brain.prosencephalon.telencephalon.temporallobe.CallosalFissure";
	public final static String Cingulum = "biomight.body.brain.prosencephalon.telencephalon.temporallobe.Cingulum";
	public final static String CircularSulcus = "biomight.body.brain.prosencephalon.telencephalon.temporallobe.CircularSulcus";
	public final static String FrontalOperculum = "biomight.body.brain.prosencephalon.telencephalon.temporallobe.FrontalOperculum";
	public final static String FrontoParietalOperculum = "biomight.body.brain.prosencephalon.telencephalon.temporallobe.FrontoParietalOperculum";
	public final static String FusiformGyrus = "biomight.body.brain.prosencephalon.telencephalon.temporallobe.FusiformGyrus";
	public final static String GlobusPallidus = "biomight.body.brain.prosencephalon.telencephalon.temporallobe.GlobusPallidus";
	//public final static String HippocampalFissure = "biomight.body.brain.prosencephalon.telencephalon.temporallobe.HippocampalFissure";
	//public final static String IncisuraTemporalis = "biomight.body.brain.prosencephalon.telencephalon.temporallobe.IncisuraTemporalis";
	public final static String InferiorTemporalGyrus = "biomight.body.brain.prosencephalon.telencephalon.temporallobe.InferiorTemporalGyrus";
	public final static String InferiorTemporalSulcus = "biomight.body.brain.prosencephalon.telencephalon.temporallobe.InferiorTemporalSulcus";
	public final static String Insula = "biomight.body.brain.prosencephalon.telencephalon.temporallobe.Insula";
	public final static String LongGyrus = "biomight.body.brain.prosencephalon.telencephalon.temporallobe.LongGyrus";
	public final static String MiddleTemporalGyrus = "biomight.body.brain.prosencephalon.telencephalon.temporallobe.MiddleTemporalGyrus";
	public final static String MiddleTemporalSulcus = "biomight.body.brain.prosencephalon.telencephalon.temporallobe.MiddleTemporalSulcus";
	public final static String OperculaOfTheInsula = "biomight.body.brain.prosencephalon.telencephalon.temporallobe.OperculaOfTheInsula";
	public final static String OrbitalOperculum = "biomight.body.brain.prosencephalon.telencephalon.temporallobe.OrbitalOperculum";
	public final static String ParacentralLobule = "biomight.body.brain.prosencephalon.telencephalon.temporallobe.ParacentralLobule";
	public final static String ParallelSulcus = "biomight.body.brain.prosencephalon.telencephalon.temporallobe.ParallelSulcus";
	public final static String SuperiorTemporalGyrus = "biomight.body.brain.prosencephalon.telencephalon.temporallobe.SuperiorTemporalGyrus";
	//public final static String SuperiorTemporalSulcus = "biomight.body.brain.prosencephalon.telencephalon.temporallobe.SuperiorTemporalSulcus";
	public final static String TemporalLobe = "biomight.body.brain.prosencephalon.telencephalon.temporallobe.TemporalLobe";
	public final static String TemporalLobeInferior = "biomight.body.brain.prosencephalon.telencephalon.temporallobe.TemporalLobeInferior";
	public final static String TemporalLobeLateral = "biomight.body.brain.prosencephalon.telencephalon.temporallobe.TemporalLobeLateral";
	public final static String TemporalLobeSuperior = "biomight.body.brain.prosencephalon.telencephalon.temporallobe.TemporalLobeSuperior";
	public final static String TemporalOperculum = "biomight.body.brain.prosencephalon.telencephalon.temporallobe.TemporalOperculum";
	public final static String TransverseTemporalGyrus = "biomight.body.brain.prosencephalon.telencephalon.temporallobe.TransverseTemporalGyrus";

	// biomight.body.brain.prosencephalon.telencephalon.thalami
	public final static String LateralMedullaryLamina = "biomight.body.brain.prosencephalon.telencephalon.thalami.LateralMedullaryLamina";
	public final static String MassaIntermedia = "biomight.body.brain.prosencephalon.telencephalon.thalami.MassaIntermedia";
	public final static String MedialGeniculateBody = "biomight.body.brain.prosencephalon.telencephalon.thalami.MedialGeniculateBody";
	public final static String OpticThalamus = "biomight.body.brain.prosencephalon.telencephalon.thalami.OpticThalamus";
	public final static String StratumZonale = "biomight.body.brain.prosencephalon.telencephalon.thalami.StratumZonale";
	public final static String SubstantiaInnominataOfMeynert = "biomight.body.brain.prosencephalon.telencephalon.thalami.SubstantiaInnominataOfMeynert";
	public final static String TaeniaThalami = "biomight.body.brain.prosencephalon.telencephalon.thalami.TaeniaThalami";
	public final static String ThalamiAnteriorExtremity = "biomight.body.brain.prosencephalon.telencephalon.thalami.ThalamiAnteriorExtremity";
	public final static String ThalamiInferiorSurface = "biomight.body.brain.prosencephalon.telencephalon.thalami.ThalamiInferiorSurface";
	public final static String ThalamiPosteriorExtremity = "biomight.body.brain.prosencephalon.telencephalon.thalami.ThalamiPosteriorExtremity";
	public final static String ThalamiSuperiorSurface = "biomight.body.brain.prosencephalon.telencephalon.thalami.ThalamiSuperiorSurface";
	public final static String ThalamusAnteriorStalk = "biomight.body.brain.prosencephalon.telencephalon.thalami.ThalamusAnteriorStalk";
	public final static String ThalamusInferiorStalk = "biomight.body.brain.prosencephalon.telencephalon.thalami.ThalamusInferiorStalk";
	public final static String ThalamusParietalStalk = "biomight.body.brain.prosencephalon.telencephalon.thalami.ThalamusParietalStalk";
	public final static String ThalamusPosteriorStalk = "biomight.body.brain.prosencephalon.telencephalon.thalami.ThalamusPosteriorStalk";
	
	// biomight.body.brain.rhombencephalon
	public final static String AlaCinerea = "biomight.body.brain.rhombencephalon.AlaCinerea";
	public final static String AnteriorMedianFissure = "biomight.body.brain.rhombencephalon.AnteriorMedianFissure";
	public final static String AnteriorMedullaryVelum = "biomight.body.brain.rhombencephalon.AnteriorMedullaryVelum";
	public final static String AnteroLateralSulcus = "biomight.body.brain.rhombencephalon.AnteroLateralSulcus";
	public final static String ArchiCerebellum = "biomight.body.brain.rhombencephalon.ArchiCerebellum";
	public final static String BrachiumPontisCerebelli = "biomight.body.brain.rhombencephalon.BrachiumPontisCerebelli";
	public final static String CaudateNucleus = "biomight.body.brain.rhombencephalon.CaudateNucleus";
		
	public final static String CerebroSpinalFasciculus = "biomight.body.brain.rhombencephalon.CerebroSpinalFasciculus";
	public final static String Clava = "biomight.body.brain.rhombencephalon.Clava";
	public final static String CochlearNucleus = "biomight.body.brain.rhombencephalon.CochlearNucleus";
	public final static String ConusMedullaris = "biomight.body.brain.rhombencephalon.ConusMedullaris";
	public final static String Cornucopia = "biomight.body.brain.rhombencephalon.Cornucopia";
	public final static String CorticoBulbarFibers = "biomight.body.brain.rhombencephalon.CorticoBulbarFibers";
	public final static String CorticospinalFibers = "biomight.body.brain.rhombencephalon.CorticospinalFibers";
	public final static String CuneateNucleus = "biomight.body.brain.rhombencephalon.CuneateNucleus";
	public final static String DorsalAccessoryOlivaryNuclei = "biomight.body.brain.rhombencephalon.DorsalAccessoryOlivaryNuclei";
	public final static String DorsalExternalArcuateFibers = "biomight.body.brain.rhombencephalon.DorsalExternalArcuateFibers";
	public final static String DorsalSpinoCerebellarFasciculus = "biomight.body.brain.rhombencephalon.DorsalSpinoCerebellarFasciculus";
	public final static String FasciculusCuneatus = "biomight.body.brain.rhombencephalon.FasciculusCuneatus";
	public final static String FasciculusGracilis = "biomight.body.brain.rhombencephalon.FasciculusGracilis";
	public final static String FasciculusSolitarius = "biomight.body.brain.rhombencephalon.FasciculusSolitarius";
	public final static String FilumTerminale = "biomight.body.brain.rhombencephalon.FilumTerminale";
	public final static String ForamenCecum = "biomight.body.brain.rhombencephalon.ForamenCecum";
	public final static String FormatioReticularis = "biomight.body.brain.rhombencephalon.FormatioReticularis";
	public final static String FormatioReticularisAlba = "biomight.body.brain.rhombencephalon.FormatioReticularisAlba";
	public final static String FormatioReticularisGrisea = "biomight.body.brain.rhombencephalon.FormatioReticularisGrisea";
	public final static String Funiculi = "biomight.body.brain.rhombencephalon.Funiculi";
	public final static String GrayReticularFormation = "biomight.body.brain.rhombencephalon.GrayReticularFormation";
	public final static String HypoGlossalNucleus = "biomight.body.brain.rhombencephalon.HypoGlossalNucleus";
	public final static String InferiorOlivaryNucleus = "biomight.body.brain.rhombencephalon.InferiorOlivaryNucleus";
	public final static String InferiorPeduncle = "biomight.body.brain.rhombencephalon.InferiorPeduncle";
	public final static String IsthmusRhombencephali = "biomight.body.brain.rhombencephalon.IsthmusRhombencephali";
	public final static String Lemniscus = "biomight.body.brain.rhombencephalon.Lemniscus";
	public final static String LigamentumDenticulatum = "biomight.body.brain.rhombencephalon.LigamentumDenticulatum";
	public final static String Ligula = "biomight.body.brain.rhombencephalon.Ligula";
	public final static String LocusCaeruleus = "biomight.body.brain.rhombencephalon.LocusCaeruleus";
	public final static String MedialAccessoryOlivaryNuclei = "biomight.body.brain.rhombencephalon.MedialAccessoryOlivaryNuclei";
	public final static String MedialLongitudinalFasciculus = "biomight.body.brain.rhombencephalon.MedialLongitudinalFasciculus";
	public final static String MedianFillet = "biomight.body.brain.rhombencephalon.MedianFillet";
	public final static String MedianRaphe = "biomight.body.brain.rhombencephalon.MedianRaphe";
	public final static String MedullaSpinalis = "biomight.body.brain.rhombencephalon.MedullaSpinalis";

	
	public final static String NeoCerebellum = "biomight.body.brain.rhombencephalon.NeoCerebellum";
	public final static String NucleusAmbiguus = "biomight.body.brain.rhombencephalon.NucleusAmbiguus";
	public final static String NucleusArcuatus = "biomight.body.brain.rhombencephalon.NucleusArcuatus";
	public final static String NucleusGracilis = "biomight.body.brain.rhombencephalon.NucleusGracilis";
	public final static String NucleusInterealatus = "biomight.body.brain.rhombencephalon.NucleusInterealatus";
	public final static String NucleusLateralis = "biomight.body.brain.rhombencephalon.NucleusLateralis";
	public final static String NucleusOfRoller = "biomight.body.brain.rhombencephalon.NucleusOfRoller";
	public final static String NucleusOfVegas = "biomight.body.brain.rhombencephalon.NucleusOfVegas";
	public final static String Obex = "biomight.body.brain.rhombencephalon.Obex";
	public final static String OlivaryNuclei = "biomight.body.brain.rhombencephalon.OlivaryNuclei";
	public final static String Olive = "biomight.body.brain.rhombencephalon.Olive";
	public final static String PaleoCerebellum = "biomight.body.brain.rhombencephalon.PaleoCerebellum";
	public final static String PosteriorMedianSulcus = "biomight.body.brain.rhombencephalon.PosteriorMedianSulcus";
	public final static String ProperFasciculi = "biomight.body.brain.rhombencephalon.ProperFasciculi";
	public final static String PyramidalDecussation = "biomight.body.brain.rhombencephalon.PyramidalDecussation";
	public final static String RestiformBodies = "biomight.body.brain.rhombencephalon.RestiformBodies";
	
	public final static String RestiformBody = "biomight.body.brain.rhombencephalon.RestiformBody";
	
	public final static String Rhombencephalon = "biomight.body.brain.rhombencephalon.Rhombencephalon";
	public final static String RhombencephalonRef = "Rhombencephalon";
	
	public final static String RhomboidFossa = "biomight.body.brain.rhombencephalon.RhomboidFossa";
	public final static String SpinothalamicFasciculus = "biomight.body.brain.rhombencephalon.SpinothalamicFasciculus";
	public final static String StriaTerminalis = "biomight.body.brain.rhombencephalon.StriaTerminalis";
	public final static String SubduralCavity = "biomight.body.brain.rhombencephalon.SubduralCavity";
	//public final static String TentoriumCerebelli = "biomight.body.brain.rhombencephalon.TentoriumCerebelli";
	public final static String TerminalSensoryNuclei = "biomight.body.brain.rhombencephalon.TerminalSensoryNuclei";
	public final static String TtrigonumHypoGlossi = "biomight.body.brain.rhombencephalon.TtrigonumHypoGlossi";
	public final static String TubercleOfRolando = "biomight.body.brain.rhombencephalon.TubercleOfRolando";
	public final static String VentralSpinoCerebellarFasciculus = "biomight.body.brain.rhombencephalon.VentralSpinoCerebellarFasciculus";
	public final static String WhiteReticularFormation = "biomight.body.brain.rhombencephalon.WhiteReticularFormation";
	
	// biomight.body.brain.rhombencephalon.metencephalon
	public final static String Metencephalon = "biomight.body.brain.rhombencephalon.metencephalon.Metencephalon";
	
	// biomight.body.brain.rhombencephalon.metencephalon.cerebellum
	public final static String AlaLobuliCentralis = "biomight.body.brain.rhombencephalon.metencephalon.cerebellum.AlaLobuliCentralis";
	public final static String AnteriorCerebellarNotch = "biomight.body.brain.rhombencephalon.metencephalon.cerebellum.AnteriorCerebellarNotch";
	//public final static String AnteriorMedullaryVelum = "biomight.body.brain.rhombencephalon.metencephalon.cerebellum.AnteriorMedullaryVelum";
	public final static String ArborVitae = "biomight.body.brain.rhombencephalon.metencephalon.cerebellum.ArborVitae";
	public final static String Archicerebellum = "biomight.body.brain.rhombencephalon.metencephalon.cerebellum.Archicerebellum";
	public final static String AreaAcustica = "biomight.body.brain.rhombencephalon.metencephalon.cerebellum.AreaAcustica";
	public final static String AreaPostrema = "biomight.body.brain.rhombencephalon.metencephalon.cerebellum.AreaPostrema";
	public final static String BiventralLobule = "biomight.body.brain.rhombencephalon.metencephalon.cerebellum.BiventralLobule";
	public final static String CalamusScriptorius = "biomight.body.brain.rhombencephalon.metencephalon.cerebellum.CalamusScriptorius";

	public final static String CerebralCortex = "biomight.body.brain.rhombencephalon.metencephalon.cerebellum.CerebralCortex";
	public final static String Clivus = "biomight.body.brain.rhombencephalon.metencephalon.cerebellum.Clivus";
	public final static String CortexMolecularLayer = "biomight.body.brain.rhombencephalon.metencephalon.cerebellum.CortexMolecularLayer";
	public final static String CortexNuclearLayer = "biomight.body.brain.rhombencephalon.metencephalon.cerebellum.CortexNuclearLayer";
	public final static String Culmen = "biomight.body.brain.rhombencephalon.metencephalon.cerebellum.Culmen";
	public final static String DeepFasciculus = "biomight.body.brain.rhombencephalon.metencephalon.cerebellum.DeepFasciculus";
	public final static String DentateNucleus = "biomight.body.brain.rhombencephalon.metencephalon.cerebellum.DentateNucleus";
	public final static String Flocculus = "biomight.body.brain.rhombencephalon.metencephalon.cerebellum.Flocculus";
	public final static String Folia = "biomight.body.brain.rhombencephalon.metencephalon.cerebellum.Folia";
	public final static String FoliumVermis = "biomight.body.brain.rhombencephalon.metencephalon.cerebellum.FoliumVermis";
	public final static String ForamenMajendii = "biomight.body.brain.rhombencephalon.metencephalon.cerebellum.ForamenMajendii";
	public final static String ForaminaOfLuschka = "biomight.body.brain.rhombencephalon.metencephalon.cerebellum.ForaminaOfLuschka";
	public final static String FraenulumVeli = "biomight.body.brain.rhombencephalon.metencephalon.cerebellum.FraenulumVeli";
	public final static String FuniculusSeparans = "biomight.body.brain.rhombencephalon.metencephalon.cerebellum.FuniculusSeparans";
	public final static String FurrowedBand = "biomight.body.brain.rhombencephalon.metencephalon.cerebellum.FurrowedBand";
	public final static String HorizontalSulcus = "biomight.body.brain.rhombencephalon.metencephalon.cerebellum.HorizontalSulcus";
	public final static String InferiorCerebellarPeduncles = "biomight.body.brain.rhombencephalon.metencephalon.cerebellum.InferiorCerebellarPeduncles";
	public final static String InferiorFasciculus = "biomight.body.brain.rhombencephalon.metencephalon.cerebellum.InferiorFasciculus";
	public final static String InferiorOccipitalFossae = "biomight.body.brain.rhombencephalon.metencephalon.cerebellum.InferiorOccipitalFossae";
	public final static String InferiorSemiLunarLobule = "biomight.body.brain.rhombencephalon.metencephalon.cerebellum.InferiorSemiLunarLobule";
	public final static String InferiorVermis = "biomight.body.brain.rhombencephalon.metencephalon.cerebellum.InferiorVermis";
	public final static String LingulaCerebelli = "biomight.body.brain.rhombencephalon.metencephalon.cerebellum.LingulaCerebelli";
	public final static String LobulusCentralis = "biomight.body.brain.rhombencephalon.metencephalon.cerebellum.LobulusCentralis";
	public final static String LobusClivi = "biomight.body.brain.rhombencephalon.metencephalon.cerebellum.LobusClivi";
	public final static String LobusCulminis = "biomight.body.brain.rhombencephalon.metencephalon.cerebellum.LobusCulminis";
	public final static String LobusNoduli = "biomight.body.brain.rhombencephalon.metencephalon.cerebellum.LobusNoduli";
	public final static String LobusPyramidis = "biomight.body.brain.rhombencephalon.metencephalon.cerebellum.LobusPyramidis";
	public final static String LobusSemilunaris = "biomight.body.brain.rhombencephalon.metencephalon.cerebellum.LobusSemilunaris";
	public final static String LobusTuberus = "biomight.body.brain.rhombencephalon.metencephalon.cerebellum.LobusTuberus";
	public final static String LobusUvulae = "biomight.body.brain.rhombencephalon.metencephalon.cerebellum.LobusUvulae";
	//public final static String LocusCaeruleus = "biomight.body.brain.rhombencephalon.metencephalon.cerebellum.LocusCaeruleus";
	public final static String MiddleCerebellarPeduncles = "biomight.body.brain.rhombencephalon.metencephalon.cerebellum.MiddleCerebellarPeduncles";
	public final static String Monticulus = "biomight.body.brain.rhombencephalon.metencephalon.cerebellum.Monticulus";
	public final static String Neocerebellum = "biomight.body.brain.rhombencephalon.metencephalon.cerebellum.Neocerebellum";
	public final static String NidusAvis = "biomight.body.brain.rhombencephalon.metencephalon.cerebellum.NidusAvis";
	public final static String NodulusVermis = "biomight.body.brain.rhombencephalon.metencephalon.cerebellum.NodulusVermis";
	public final static String NucleusDentatus = "biomight.body.brain.rhombencephalon.metencephalon.cerebellum.NucleusDentatus";
	public final static String NucleusEmboliformis = "biomight.body.brain.rhombencephalon.metencephalon.cerebellum.NucleusEmboliformis";
	public final static String NucleusFastigii = "biomight.body.brain.rhombencephalon.metencephalon.cerebellum.NucleusFastigii";
	public final static String NucleusGlobosus = "biomight.body.brain.rhombencephalon.metencephalon.cerebellum.NucleusGlobosus";
	public final static String NucleusIintercalatus = "biomight.body.brain.rhombencephalon.metencephalon.cerebellum.NucleusIintercalatus";
	public final static String Paleocerebellum = "biomight.body.brain.rhombencephalon.metencephalon.cerebellum.Paleocerebellum";
	public final static String PostcentralFissure = "biomight.body.brain.rhombencephalon.metencephalon.cerebellum.PostcentralFissure";
	public final static String PosteriorCerebellarNotch = "biomight.body.brain.rhombencephalon.metencephalon.cerebellum.PosteriorCerebellarNotch";
	public final static String PosteriorMedullaryVelum = "biomight.body.brain.rhombencephalon.metencephalon.cerebellum.PosteriorMedullaryVelum";
	public final static String PostNodularFissure = "biomight.body.brain.rhombencephalon.metencephalon.cerebellum.PostNodularFissure";
	public final static String PostPyramidalFissure = "biomight.body.brain.rhombencephalon.metencephalon.cerebellum.PostPyramidalFissure";
	public final static String PreclivalFissure = "biomight.body.brain.rhombencephalon.metencephalon.cerebellum.PreclivalFissure";
	public final static String PrePyramidalFissure = "biomight.body.brain.rhombencephalon.metencephalon.cerebellum.PrePyramidalFissure";
	public final static String QuadrangularLobule = "biomight.body.brain.rhombencephalon.metencephalon.cerebellum.QuadrangularLobule";
	public final static String QuadrangularLobules = "biomight.body.brain.rhombencephalon.metencephalon.cerebellum.QuadrangularLobules";
	public final static String StriaeMedullares = "biomight.body.brain.rhombencephalon.metencephalon.cerebellum.StriaeMedullares";
	public final static String SubarAchnoidCavity = "biomight.body.brain.rhombencephalon.metencephalon.cerebellum.SubarAchnoidCavity";
	public final static String SubstantiaFerruginea = "biomight.body.brain.rhombencephalon.metencephalon.cerebellum.SubstantiaFerruginea";
	public final static String SulcusLimitans = "biomight.body.brain.rhombencephalon.metencephalon.cerebellum.SulcusLimitans";
	public final static String SulcusValleculae = "biomight.body.brain.rhombencephalon.metencephalon.cerebellum.SulcusValleculae";
	public final static String SuperiorCerebellarPeduncles = "biomight.body.brain.rhombencephalon.metencephalon.cerebellum.SuperiorCerebellarPeduncles";
	public final static String SuperiorFasciculus = "biomight.body.brain.rhombencephalon.metencephalon.cerebellum.SuperiorFasciculus";
	public final static String SuperiorSemilunarLobule = "biomight.body.brain.rhombencephalon.metencephalon.cerebellum.SuperiorSemilunarLobule";
	public final static String SuperiorVermis = "biomight.body.brain.rhombencephalon.metencephalon.cerebellum.SuperiorVermis";
	public final static String TelaChorioidea = "biomight.body.brain.rhombencephalon.metencephalon.cerebellum.TelaChorioidea";
	//public final static String TentoriumCerebelli = "biomight.body.brain.rhombencephalon.metencephalon.cerebellum.TentoriumCerebelli";
	public final static String TonsillaCerebelli = "biomight.body.brain.rhombencephalon.metencephalon.cerebellum.TonsillaCerebelli";
	public final static String TuberculumAcusticum = "biomight.body.brain.rhombencephalon.metencephalon.cerebellum.TuberculumAcusticum";
	public final static String TuberVermis = "biomight.body.brain.rhombencephalon.metencephalon.cerebellum.TuberVermis";
	public final static String UvulaVermis = "biomight.body.brain.rhombencephalon.metencephalon.cerebellum.UvulaVermis";
	public final static String Vallecula = "biomight.body.brain.rhombencephalon.metencephalon.cerebellum.Vallecula";
	public final static String ValleculaCerebelli = "biomight.body.brain.rhombencephalon.metencephalon.cerebellum.ValleculaCerebelli";
	public final static String VentralSpinocerebellarFasciculus = "biomight.body.brain.rhombencephalon.metencephalon.cerebellum.VentralSpinocerebellarFasciculus";
	public final static String Vermis = "biomight.body.brain.rhombencephalon.metencephalon.cerebellum.Vermis";
	public final static String WhiteSubstance = "biomight.body.brain.rhombencephalon.metencephalon.cerebellum.WhiteSubstance";
	
	// biomight.body.brain.rhombencephalon.metencephalon.pons
	public final static String ColliculusFacialis = "biomight.body.brain.rhombencephalon.metencephalon.pons.ColliculusFacialis";
	public final static String LateralCochlearNucleus = "biomight.body.brain.rhombencephalon.metencephalon.pons.LateralCochlearNucleus";
	public final static String MesencephalicRoot = "biomight.body.brain.rhombencephalon.metencephalon.pons.MesencephalicRoot";
	public final static String MotorNucleus = "biomight.body.brain.rhombencephalon.metencephalon.pons.MotorNucleus";
	public final static String NucleiPontis = "biomight.body.brain.rhombencephalon.metencephalon.pons.NucleiPontis";
	public final static String NucleusOfAbducentNerve = "biomight.body.brain.rhombencephalon.metencephalon.pons.NucleusOfAbducentNerve";
	public final static String NucleusOfBechterew = "biomight.body.brain.rhombencephalon.metencephalon.pons.NucleusOfBechterew";

	public final static String Pons = "biomight.body.brain.rhombencephalon.metencephalon.pons.Pons";
	public final static String PonsRef = "Pons";

	public final static String SensoryNucleus = "biomight.body.brain.rhombencephalon.metencephalon.pons.SensoryNucleus";
	public final static String SulcusBasilaris = "biomight.body.brain.rhombencephalon.metencephalon.pons.SulcusBasilaris";
	public final static String SuperiorOlivaryNucleus = "biomight.body.brain.rhombencephalon.metencephalon.pons.SuperiorOlivaryNucleus";
	public final static String TaeniaPontis = "biomight.body.brain.rhombencephalon.metencephalon.pons.TaeniaPontis";
	public final static String TrapezoidBody = "biomight.body.brain.rhombencephalon.metencephalon.pons.TrapezoidBody";
	public final static String TrapezoidNucleus = "biomight.body.brain.rhombencephalon.metencephalon.pons.TrapezoidNucleus";
	public final static String VentralCochlearNucleus = "biomight.body.brain.rhombencephalon.metencephalon.pons.VentralCochlearNucleus";

	// biomight.body.brain.rhombencephalon.myelencephalon
	public final static String MedullaOblongata = "biomight.body.brain.rhombencephalon.myelencephalon.MedullaOblongata";
	public final static String MedullaOblongataRef = "MedullaOblongata";
	
	public final static String Myelencephalon = "biomight.body.brain.rhombencephalon.myelencephalon.Myelencephalon";

	// HEART
	public final static String Heart = "biomight.body.organ.heart.Heart";
	public final static String HeartRef = "Heart";
	
	public final static String AorticArch = "biomight.body.organ.heart.AorticArch";
	public final static String AorticArchRef = "AorticArch";
	
	public final static String LeftAtrium = "biomight.body.organ.heart.LeftAtrium";
	public final static String LeftAtriumRef = "LeftAtrium";
			
	public final static String Ventricles = "biomight.body.organ.heart.Ventricles";
	public final static String VentriclesRef = "Ventricles";

	public final static String Ventricle = "biomight.body.organ.heart.Ventricle";
	public final static String VentricleRef = "Ventricle";
	
	public final static String LeftVentricle = "biomight.body.organ.heart.LeftVentricle";
	public final static String LeftVentricleRef = "LeftVentricle";

	public final static String Atriums = "biomight.body.organ.heart.Atriums";
	public final static String AtriumsRef = "Atriums";

	public final static String Atrium = "biomight.body.organ.heart.Atrium";
	public final static String AtriumRef = "Atrium";
	
	
	public final static String RightAtrium = "biomight.body.organ.heart.RightAtrium";
	public final static String RightAtriumRef = "RightAtrium";
	
	public final static String RightVentricle = "biomight.body.organ.heart.RightVentricle";
	public final static String RightVentricleRef = "RightVentricle";
	 
	
	 // KIDNEYS
	public final static String Kidney = "biomight.body.organ.kidney.Kidney";
	public final static String KidneyRef = "Kidney";
	
	public final static String Kidneys = "biomight.body.organ.kidney.Kidneys";
	public final static String KidneysRef = "Kidneys";
	
	public final static String Adventitia = "biomight.body.organ.kidney.Adventitia";
	public final static String AdventitiaRef = "";
	
	public final static String BowmansCapsule = "biomight.body.organ.kidney.BowmansCapsule";
	public final static String BowmansCapsuleRef = "";
	
	public final static String BowmansCapsuleParietalLayer = "biomight.body.organ.kidney.BowmansCapsuleParietalLayer";
	public final static String BowmansCapsuleParietalLayerRef = "";
	
	public final static String BowmansCapsuleViseralLayer = "biomight.body.organ.kidney.BowmansCapsuleViseralLayer";
	public final static String BowmansCapsuleViseralLayerRef = "";
			
	public final static String Calyx = "biomight.body.organ.kidney.Calyx";
	public final static String CalyxRef = "KidneyCalyx";

	public final static String Calyces = "biomight.body.organ.kidney.Calyces";
	public final static String CalycesRef ="KidneyCalyces";
	
	public final static String RenalFibrousCapsule = "biomight.body.organ.kidney.RenalFibrousCapsule";
	public final static String RenalFibrousCapsuleRef = "";
			
	public final static String FiltrationSlits = "biomight.body.organ.kidney.FiltrationSlits";
	public final static String FiltrationSlitsRef = "";
	
	public final static String GlomerularCapillaries = "biomight.body.organ.kidney.GlomerularCapillaries";
	public final static String GlomerularCapillariesRef = "";
	
	public final static String GlomerularFiltrationBarrier = "biomight.body.organ.kidney.GlomerularFiltrationBarrier";
	public final static String GlomerularFiltrationBarrierRef = "";
	
	public final static String GlomerularFiltrationRate = "biomight.body.organ.kidney.GlomerularFiltrationRate";
	public final static String GlomerularFiltrationRateRef = "";
	
	public final static String Glomerus = "biomight.body.organ.kidney.Glomerus";
	public final static String GlomerusRef = "";
	
	public final static String InnerLooseSpiralMucle = "biomight.body.organ.kidney.InnerLooseSpiralMucle";
	public final static String InnerLooseSpiralMucleRef = "";
			
	public final static String KidneyVisceralEpithelium = "biomight.body.organ.kidney.KidneyVisceralEpithelium";
	public final static String KidneyVisceralEpitheliumRef = "";
	
	public final static String MaculaDensa = "biomight.body.organ.kidney.MaculaDensa";
	public final static String MaculaDensaRef = "";
	
	public final static String MalpighianPyramids = "biomight.body.organ.kidney.MalpighianPyramids";
	public final static String MalpighianPyramidsRef = "";
	
	public final static String MinorCalyx = "biomight.body.organ.kidney.MinorCalyx";
	public final static String MinorCalyxRef = "";
	
	public final static String Nephron = "biomight.body.organ.kidney.Nephron";
	public final static String NephronRef = "Nephron";
	
	public final static String OuterTightSpiralMucle = "biomight.body.organ.kidney.OuterTightSpiralMucle";
	public final static String OuterTightSpiralMucleRef = "";
			
	public final static String RenalPapilla = "biomight.body.organ.kidney.RenalPapilla";
	public final static String RenalPapillaRef = "";
	
	public final static String RenalCorpuscle = "biomight.body.organ.kidney.RenalCorpuscle";
	public final static String RenalCorpuscleRef = "";
	
	public final static String RenalPelvis = "biomight.body.organ.kidney.RenalPelvis";
	public final static String RenalPelvisRef = "";
	
	public final static String RenalSinus = "biomight.body.organ.kidney.RenalSinus";
	public final static String RenalSinusRef = "";
			
	public final static String RenalTubule = "biomight.body.organ.kidney.RenalTubule";
	public final static String RenalTubuleRef = "";
	
	public final static String SlitDiaphragms = "biomight.body.organ.kidney.SlitDiaphragms";
	public final static String SlitDiaphragmsRef = "";
	
	public final static String Ureter = "biomight.body.organ.kidney.Ureter";
	public final static String UreterRef = "Ureter";
	
	public final static String Ureters = "biomight.body.organ.kidney.Ureters";
	public final static String UretersRef = "Ureters";
	
	public final static String Urethra = "biomight.body.organ.kidney.Urethra";
	public final static String UrethraRef = "Urethra";
	
	public final static String VasaRecta = "biomight.body.organ.kidney.VasaRecta";
	public final static String VasaRectaRef = "VasaRecta";
	
	 
	// LARGE INTESTINE  
	public final static String Intestines = "biomight.body.organ.largeintestine.Intestines";
	public final static String IntestineRef = "Intestines";
	
	public final static String LargeIntestine = "biomight.body.organ.largeintestine.LargeIntestine";
	public final static String LargeIntestineRef = "LargeIntestine";
	
	public final static String AscendingColon = "biomight.body.organ.largeintestine.AscendingColon";
	public final static String AscendingColonRef = "AscendingColon";
	
	public final static String Caecum = "biomight.body.organ.largeintestine.Caecum";
	public final static String CaecumRef = "Caecum";
	
	public final static String Colon = "biomight.body.organ.largeintestine.Colon";
	public final static String ColonRef = "Colon";
	
	public final static String DescendingColon = "biomight.body.organ.largeintestine.DescendingColon";
	public final static String DescendingColonRef = "DescendingColon";

	public final static String Rectum = "biomight.body.organ.largeintestine.Rectum";
	public final static String RectumRef = "Rectum";

	public final static String SigmoidFlexure = "biomight.body.organ.largeintestine.SigmoidFlexure";
	public final static String SigmoidFlexureRef = "SigmoidFlexure";
	
	public final static String TransverseColon = "biomight.body.organ.largeintestine.TransverseColon";
	public final static String TransverseColonRef = "TransverseColon";
	
	// LIVER
	public final static String Liver = "biomight.body.organ.liver.Liver";
	public final static String LiverRef = "Liver";
	
	public final static String BileCanaliculi = "biomight.body.organ.liver.BileCanaliculi";
	public final static String BileCanaliculiRef = "BileCanaliculi";
	
	public final static String BileDucts = "biomight.body.organ.BileDucts";
	public final static String BileDuctsRef = "BileDucts";

	public final static String BileDuct = "biomight.body.organ.BileDuct";
	public final static String BileDuctRef = "BileDuct";
	
	public final static String HepaticDucts = "biomight.body.organ.HepaticDucts";
	public final static String HepaticDuctsRef = "HepaticDucts";
	
	public final static String HepaticDuct = "biomight.body.organ.HepaticDuct";
	public final static String HepaticDuctRef = "HepaticDuct";

	public final static String CysticDuct = "biomight.body.organ.CysticDuct";
	public final static String CysticDuctRef = "CysticDuct";

	public final static String CommonHepaticDuct = "biomight.body.organ.CommonHepaticDuct";
	public final static String CommonHepaticDuctRef = "CommonHepaticDuct";

	public final static String CommonBileDuct = "biomight.body.organ.CommonBileDuct";
	public final static String CommonBileDuctRef = "CommonBileDuct";

	public final static String CoronaryLigament = "biomight.body.organ.liver.CoronaryLigament";
	public final static String CoronaryLigamentRef = "CoronaryLigament";
	
	public final static String DuodenalImpression = "biomight.body.organ.liver.DuodenalImpression";
	public final static String DuodenalImpressionRef = "DuodenalImpression";
		
	public final static String FalciformLigament = "biomight.body.organ.liver.FalciformLigament";
	public final static String FalciformLigamentRef = "FalciformLigament";
			
	public final static String LiverLeftLateralLobe = "biomight.body.organ.liver.LiverLeftLateralLobe";
	public final static String LiverLeftLateralLobeRef = "LiverLeftLateralLobe";
	
	public final static String LeftSagittalFossa = "biomight.body.organ.liver.LeftSagittalFossa";
	public final static String LeftSagittalFossaRef = "LeftSagittalFossa";
	
	public final static String LeftTriangularLigaments = "biomight.body.organ.liver.LeftTriangularLigaments";
	public final static String LeftTriangularLigamentsRef = "LeftTriangularLigaments";
	
	public final static String LigamentumTeres = "biomight.body.organ.liver.LigamentumTeres";
	public final static String LigamentumTeresRef = "LigamentumTeres";
	
	public final static String LigamentumVenosum = "biomight.body.organ.liver.LigamentumVenosum";
	public final static String LigamentumVenosumRef = "LigamentumVenosum";
	
	// LOBES
	public final static String LiverLobule = "biomight.body.organ.liver.LiverLobule";
	public final static String LiverLobuleRef = "LiverLobule";

	public final static String LiverLobules = "biomight.body.organ.liver.LiverLobules";
	public final static String LiverLobulesRef = "LiverLobules";
	
	public final static String LiverQuadrateLobe = "biomight.body.organ.liver.LiverQuadrateLobe";
	public final static String LiverQuadrateLobeRef = "LiverQuadrateLobe";
	
	// SURFACES
	public final static String LiverInferiorSurface = "biomight.body.organ.liver.LiverInferiorSurface";	
	public final static String LiverInferiorSurfaceRef = "LiverInferiorSurface";
	
	public final static String LiverPosteriorSurface = "biomight.body.organ.liver.LiverPosteriorSurface";
	public final static String LiverPosteriorSurfaceRef = "LiverPosteriorSurface";
	
	public final static String LiverSuperiorSurface = "biomight.body.organ.liver.LiverSuperiorSurface";	
	public final static String LiverSuperiorSurfaceRef = "LiverSuperiorSurface";
	
	public final static String CaudateLobe = "biomight.body.organ.liver.CaudateLobe";
	public final static String CaudateLobeRef = "CaudateLobe";
	
	public final static String CaudateProcess = "biomight.body.organ.liver.CaudateProcess";	
	public final static String CaudateProcessRef = "CaudateProcess";
	
	public final static String PapillaryProcess = "biomight.body.organ.liver.PapillaryProcess";	
	public final static String PapillaryProcessRef = "PapillaryProcess";
	
	public final static String LiverTransverseFissure = "biomight.body.organ.liver.LiverTransverseFissure";	
	public final static String LiverTransverseFissureRef = "LiverTransverseFissure";
	
	public final static String LiverGastricImpression = "biomight.body.organ.liver.LiverGastricImpression";
	public final static String LiverGastricImpressionRef = "LiverGastricImpression";
	
	public final static String LiverColicImpression = "iomight.body.organ.liver.LiverColicImpression";
	public final static String LiverColicImpressionRef = "LiverColicImpression";
	
	public final static String LiverRenalImpression = "biomight.body.organ.liver.LiverRenalImpression";
	public final static String LiverRenalImpressionRef = "LiverRenalImpression";
	
	public final static String LiverSupraRenalImpression = "biomight.body.organ.liver.LiverRenalImpression";
	public final static String LiverSupraRenalImpressionRef = "LiverSupraRenalImpression";
		
	public final static String RightHepaticDuct = "biomight.body.organ.liver.RightHepaticDuct";
	public final static String RightHepaticDuctRef = "RightHepaticDuct";
			
	public final static String LiverRightLateralLobe = "biomight.body.organ.liver.LiverRightLateralLobe";
	public final static String LiverRightLateralLobeRef = "";
	
	public final static String LiverRightMedialLobe = "biomight.body.organ.liver.LiverRightMedialLobe";
	public final static String LiverRightMedialLobeRef = "LiverRightLateralLobe";
	
	public final static String RightTriangularLigaments = "biomight.body.organ.liver.RightTriangularLigaments";
	public final static String RightTriangularLigamentsRef = "RightTriangularLigaments";
	
	public final static String RoundLigament = "biomight.body.organ.liver.RoundLigament";
	public final static String RoundLigamentRef = "RoundLigament";
	
	public final static String Sinusoid = "biomight.body.organ.liver.Sinusoid";
	public final static String SinusoidRef = "Sinusoid";
	
	public final static String Sinusoids = "biomight.body.organ.liver.Sinusoids";
	public final static String SinusoidsRef = "Sinusoids";
	
	public final static String SpaceOfDisse = "biomight.body.organ.liver.SpaceOfDisse";
	public final static String SpaceOfDisseRef = "Sinusoids";
	
	public final static String TuberOmentale = "biomight.body.organ.liver.TuberOmentale";
	public final static String TuberOmentaleRef = "TuberOmentale"; 
	
	// LUNG
	public final static String Lung = "biomight.body.organ.lung.Lung";	
	public final static String LungRef = "Lung";
	
	public final static String Lungs = "biomight.body.organ.lung.Lungs";
	public final static String LungsRef = "Lungs";
	
	public final static String Alveoli = "biomight.body.organ.lung.Alveoli";
	public final static String AlveoliRef = "Alveoli";
	
	public final static String Bronchi = "biomight.body.organ.lung.Bronchi";
	public final static String BronchiRef = "Bronchi";
	
	public final static String Bronchus = "biomight.body.organ.lung.Bronchus";
	public final static String BronchusRef = "Bronchus";
	
	public final static String LobarBronchi = "biomight.body.organ.lung.LobarBronchi";
	public final static String LobarBronchiRef = "LobarBronchi";
	
	public final static String LobarBronchus = "biomight.body.organ.lung.LobarBronchus";
	public final static String LobarBronchusRef = "LobarBronchus";

	
	// Left Secondary Brounchus
	public final static String LeftSuperiorLobeBronchus = "biomight.body.organ.lung.LeftLobarBronchus";
	public final static String LeftSuperiorLobeBronchusRef = "LobarBronchus:01";
		
	public final static String LeftInferiorLobeBronchus = "biomight.body.organ.lung.LeftLobarBronchus";
	public final static String LeftInferiorLobeBronchusRef = "LobarBronchus:02";

	// Right Secondary Brounchus	
	public final static String RightSuperiorLobarBronchus = "biomight.body.organ.lung.RightSuperiorLobarBronchus";
	public final static String RightSuperiorLobeBronchusRef = "LobarBronchus:03";

	public final static String RightMiddleLobarBronchus = "biomight.body.organ.lung.RightMiddleLobarBronchus";
	public final static String RightMiddleLobeBronchusRef = "LobarBronchus:04";

	public final static String RightInferiorLobarBronchus = "biomight.body.organ.lung.RightInferiorLobarBronchus";
	public final static String RightInferiorLobeBronchusRef = "LobarBronchus:05";
	
	public final static String SegmentalinicBronchi = "biomight.body.organ.lung.SegmentalinicBronchi";
	public final static String SegmentalinicBronchiRef = "SegmentalinicBronchi";
	
	public final static String SegmentalinicBronchus = "biomight.body.organ.lung.SegmentalinicBronchus";
	public final static String SegmentalinicBronchusRef = "SegmentalinicBronchus";


	// Left Tertiary Brounchus - 8 of them (should be 10, but two are fused)
	public final static String LeftSuperiorApicoPosteriorBronchus = "biomight.body.organ.lung.SegmentalinicBronchus";
	public final static String LeftSuperiorApicoPosteriorBronchusRef = "SegmentalinicBronchus:01";

	public final static String LeftSuperiorAnteriorBronchus = "biomight.body.organ.lung.SegmentalinicBronchus";
	public final static String LeftSuperiorAnteriorBronchusRef = "SegmentalinicBronchus:02";

	public final static String LeftSuperiorInferiorLingularBronchus = "biomight.body.organ.lung.SegmentalinicBronchus";
	public final static String LeftSuperiorInferiorLingularBronchusRef = "SegmentalinicBronchus:03";
	
	public final static String LeftSuperiorSuperiorLingularBronchus = "biomight.body.organ.lung.SegmentalinicBronchus";
	public final static String LeftSuperiorSuperiorLingularBronchusRef = "SegmentalinicBronchus:04";
	
	public final static String LeftInferiorSuperiorBronchus = "biomight.body.organ.lung.SegmentalinicBronchus";
	public final static String LeftInferiorSuperiorBronchusRef = "SegmentalinicBronchus:05";

	public final static String LeftInferiorAnteroMedialBasalBronchus = "biomight.body.organ.lung.SegmentalinicBronchus";
	public final static String LeftInferiorAnteroMedialBasalBronchusRef = "SegmentalinicBronchus:06";

	public final static String LeftInferiorPosteriorBasalBronchus = "biomight.body.organ.lung.SegmentalinicBronchus";
	public final static String LeftInferiorPosteriorBasalBronchusRef = "SegmentalinicBronchus:07";

	public final static String LeftInferiorLateralBasalBronchus = "biomight.body.organ.lung.SegmentalinicBronchus";
	public final static String LeftInferiorLateralBasalBronchusRef = "SegmentalinicBronchus:08";

	// Right Tertiary Brounchus 10 of them	
	public final static String RightSuperiorApicalBronchus = "biomight.body.organ.lung.SegmentalinicBronchus";
	public final static String RightSuperiorApicalBronchusRef = "SegmentalinicBronchus:09";
	
	public final static String RightSuperiorPosteriorBronchus = "biomight.body.organ.lung.SegmentalinicBronchus";
	public final static String RightSuperiorPosteriorBronchusRef = "SegmentalinicBronchus:10";

	public final static String RightSuperiorAnteriorBronchus = "biomight.body.organ.lung.SegmentalinicBronchus";
	public final static String RightSuperiorAnteriorBronchusRef = "SegmentalinicBronchus:11";
	
	public final static String RightMiddleLateralBronchus = "biomight.body.organ.lung.SegmentalinicBronchus";
	public final static String RightMiddleLateralBronchusRef = "SegmentalinicBronchus:12";
	
	public final static String RightMiddleMedialBronchus = "biomight.body.organ.lung.SegmentalinicBronchus";
	public final static String RightMiddleMedialBronchusRef = "SegmentalinicBronchus:13";

	public final static String RightInferiorSuperiorBronchus = "biomight.body.organ.lung.SegmentalinicBronchus";
	public final static String RightInferiorSuperiorBronchusRef = "SegmentalinicBronchus:14";

	public final static String RightInferiorMedialBasalBronchus = "biomight.body.organ.lung.SegmentalinicBronchus";
	public final static String RightInferiorMedialBasalBronchusRef = "SegmentalinicBronchus:15";

	public final static String RightInferiorAnteriorBasalBronchus = "biomight.body.organ.lung.SegmentalinicBronchus";
	public final static String RightInferiorAnteriorBasalBronchusRef = "SegmentalinicBronchus:16";

	public final static String RightInferiorLateralBasalBronchus = "biomight.body.organ.lung.SegmentalinicBronchus";
	public final static String RightInferiorLateralBasalBronchusRef = "SegmentalinicBronchus:17";

	public final static String RightInferiorPosteriorBasalBronchus = "biomight.body.organ.lung.SegmentalinicBronchus";
	public final static String RightInferiorPosteriorBasalBronchusRef = "SegmentalinicBronchus:18";
	
	public final static String Bronchiole = "biomight.body.organ.lung.Bronchiole";
	public final static String BronchioleRef = "Bronchiole";
	
	public final static String Bronchioles = "biomight.body.organ.lung.Bronchioles";
	public final static String BronchiolesRef = "Bronchioles";
	
	public final static String LeftBronchus = "biomight.body.organ.lung.LeftBronchus";
	public final static String LeftBronchusRef = "Bronchus:01";
	
	public final static String RightBronchus = "biomight.body.organ.lung.RightBronchus";
	public final static String RightBronchusRef = "Bronchus:02";
	
	public final static String LungApexPulmonis = "biomight.body.organ.lung.ApexPulmonis";
	public final static String LungApexPulmonisRef = "";
	
	public final static String LungBasisPulmonis = "biomight.body.organ.lung.ApexPulmonis";
	public final static String LungBasisPulmonisRef = "";

	// SURFACES
	public final static String LungCostalSurface = "biomight.body.organ.lung.LungCostalSurface";
	public final static String LungCostalSurfaceRef = "LCS";
	public final static String LungMediastinalSurface = "biomight.body.organ.lung.LungMediastinalSurface";
	
	public final static String LungCardiacImpression = "biomight.body.organ.lung.LungCardiacImpression";
	public final static String LungCardiacImpressionRef = "";
	
	public final static String LungHilum = "biomight.body.organ.lung.LungHilum";
	public final static String LungHilumRef = "";
	
	public final static String LeftLungHilum = "biomight.body.organ.lung.LeftLungHilum";
	public final static String RightLungHilum = "biomight.body.organ.lung.RightLungHilum";
	
	// BORDERS
	public final static String LungInferiorBorder = "biomight.body.organ.lung.LungInferiorBorder";
	public final static String LungInferiorBorderRef = "LIB";
	
	public final static String LungPosteriorBorder = "biomight.body.organ.lung.LungPosteriorBorder";
	public final static String LeftLungPosteriorBorderRef = "";
	
	public final static String LungAnteriorBorder = "biomight.body.organ.lung.LungAnteriorBorder";
	public final static String LungAnteriorBorderRef = "LungAnteriorBorder";
	
	// LOBES
	public final static String LungSuperiorLobe = "biomight.body.organ.lung.LeftLungSuperiorLobe";
	public final static String LungSuperiorLobeRef = "LungSuperiorLobe";
	
	public final static String LungInferiorLobe = "biomight.body.organ.lung.RightLungInferiorLobe";
	public final static String LungInferiorLobeRef = "LungInferiorLobe";
	
	public final static String LungMiddleLobe = "biomight.body.organ.lung.RightLungMiddleLobe";
	public final static String LungMiddleLobeRef = "LungMiddleLobe";
	
	
	
	// PANCREAS
	public final static String Pancreas = "biomight.body.organ.pancreas.Pancreas";
	public final static String PancreasRef = "Pancreas";
	
	public final static String IntralobularDuct = "biomight.body.organ.pancreas.IntralobularDuct";
	public final static String IntralobularDuctRef = "IntralobularDuct";
	
	public final static String IsletsOfLangerhans = "biomight.body.organ.pancreas.IsletsOfLangerhans";
	public final static String IsletsOfLangerhansRef = "IsletsOfLangerhans";

	public final static String PancreaticDucts = "biomight.body.organ.pancreas.PancreaticDucts";
	public final static String PancreaticDuctsRef = "PancreaticDucts";

	public final static String PancreaticDuct = "biomight.body.organ.pancreas.PancreaticDuct";
	public final static String PancreaticDuctRef = "PancreaticDuct";

	public final static String AccessoryPancreaticDuct = "biomight.body.organ.pancreas.AccessoryPancreaticDuct";
	public final static String AccessoryPancreaticDuctRef = "AccessoryPancreaticDuct";
	
	// SMALL INTESTINE	 
	public final static String SmallIntestine = "biomight.body.organ.smallintestine.SmallIntestine";
	public final static String SmallIntestineRef = "SmallIntestine";
	
	public final static String AmpullaOfVater = "biomight.body.organ.smallintestine.AmpullaOfVater";
	public final static String AmpullaOfVaterRef = "AmpullaOfVater";
	
	public final static String CryptsOfLieberkuhn = "biomight.body.organ.smallintestine.CryptsOfLieberkuhn";
	public final static String CryptsOfLieberkuhnRef = "CryptsOfLieberkuhn";
	
	public final static String DuodenalMucosa = "biomight.body.organ.smallintestine.DuodenalMucosa";
	public final static String DuodenalMucosaRef = "DuodenalMucosa";
	
	public final static String Duodenum = "biomight.body.organ.smallintestine.Duodenum";
	public final static String DuodenumRef = "Duodenum";
	
	public final static String Ileum = "biomight.body.organ.smallintestine.Ileum";
	public final static String IleumRef = "Ileum";
	
	public final static String Jejunum = "biomight.body.organ.smallintestine.Jejunum";
	public final static String JejunumRef = "Jejunum";
	
	public final static String MicroVilli = "biomight.body.organ.smallintestine.MicroVilli";
	public final static String MicroVilliRef = "MicroVilli";
	
	public final static String MucosalFold = "biomight.body.organ.smallintestine.MucosalFold";
	public final static String MucosalFoldRef = "MicroVilli";
	
	public final static String MucosalFolds = "biomight.body.organ.smallintestine.MucosalFolds";
	public final static String MucosalFoldsRef = "MucosalFolds";
	
	public final static String Villi = "biomight.body.organ.smallintestine.Villi";
	public final static String VilliRef = "Villi";
	
	
	// STOMACH
	public final static String Stomach = "biomight.body.organ.stomach.Stomach";
	public final static String StomachRef = "Stomach";
	
	public final static String Antrum = "biomight.body.organ.stomach.Antrum";
	public final static String AntrumRef = "";
	
	public final static String StomachCardiacNotch = "biomight.body.organ.stomach.StomachCardiacNotch";
	public final static String StomachCardiacNotchRef = "";
	
	public final static String StomachGreaterCurvature = "biomight.body.organ.stomach.GreaterCurvature";
	public final static String StomachGreaterCurvatureRef = "StomachGreaterCurvature";
	
	public final static String StomachLesserCurvature = "biomight.body.organ.stomach.LesserCurvature";
	public final static String StomachLesserCurvatureRef =  "StomachLesserCurvature"; 
	
	public final static String LowerEsophagealSphincter = "biomight.body.organ.stomach.LowerEsophagealSphincter";
	public final static String LowerEsophagealSphincterRef = "";
	
	public final static String PyloricAntrum = "biomight.body.organ.stomach.PyloricAntrum";
	public final static String PyloricAntrumRef = "";
	
	public final static String PyloricCanal = "biomight.body.organ.stomach.PyloricCanal";
	public final static String PyloricCanalRef = "";
	
	public final static String Pylorus = "biomight.body.organ.stomach.Pylorus";
	public final static String PylorusRef = "Pylorus";
	
	// THYMUS	 
	public final static String Thymus = "biomight.body.organ.thymus.Thymus";
	public final static String ThymusRef = "Thymus";
	
	public final static String HassallCorpuscles = "biomight.body.organ.thymus.HassallCorpuscles";
	public final static String HassallCorpusclesRef = "HassallCorpuscles";
	
	public final static String ThymicCortex = "biomight.body.organ.thymus.ThymicCortex";
	public final static String ThymicCortexRef = "ThymicCortex";
	
	public final static String ThymicMedulla = "biomight.body.organ.thymus.ThymicMedulla";
	public final static String ThymicMedullaRef = "ThymicMedulla";
			
	public final static String ThymusLeftLateralLobe = "biomight.body.organ.thymus.ThymusLeftLateralLobe";
	public final static String ThymusLeftLateralLobeRef = "ThymusLeftLateralLobe";
	
	public final static String ThymusLobuleFollicle = "biomight.body.organ.thymus.ThymusLobuleFollicle";
	public final static String ThymusLobuleFollicleRef = "ThymusLobuleFollicle";
	
	public final static String ThymusLobuleFollicleCortical = "biomight.body.organ.thymus.ThymusLobuleFollicleCortical";
	public final static String ThymusLobuleFollicleCorticalRef = "ThymusLobuleFollicleCortical";
	
	public final static String ThymusLobuleFollicleMedullary = "biomight.body.organ.thymus.ThymusLobuleFollicleMedullary";
	public final static String ThymusLobuleFollicleMedullaryRef = "ThymusLobuleFollicleMedullary";
	
	public final static String ThymusLobuleFollicles = "biomight.body.organ.thymus.ThymusLobuleFollicles";
	public final static String ThymusLobuleFolliclesRef = "";
	
	public final static String ThymusLobules = "biomight.body.organ.thymus.ThymusLobules";
	public final static String ThymusLobulesRef = "";
	
	public final static String ThymusRightLateralLobe = "biomight.body.organ.thymus.ThymusRightLateralLobe";
	public final static String ThymusRightLateralLobeRef = ""; 

	public final static String Pharynx = "biomight.body.substructs.pharynx.Pharynx";	
	public final static String PharynxRef = "";
	
	public final static String Nasopharynx = "biomight.body.substructs.pharynx.Nasopharynx";	
	public final static String NasopharynxRef = "";
	
	public final static String Esophagus = "biomight.body.Esophagus";
	public final static String EsophagusRef = "Esophagus";
	
	public final static String Cardia = "biomight.body.substructs.cardia.Cardia";
	public final static String CardiaRef = "";
	
		
	/********************************************************************************
	 * 
	 * Glands
	 * 
	 ********************************************************************************/ 

	// GALL BLADDER
	public final static String GallBladder = "biomight.body.gland.gallbladder.GallBladder";
	public final static String GallBladderRef = "GallBladder";
	
	public final static String GallBladderFundus = "biomight.body.gland.gallbladder.GallBladderFundus";
	public final static String GallBladderFundusRef = "GallBladderFundus";
	
	public final static String GallBladderBody = "biomight.body.gland.gallbladder.GallBladderBody";
	public final static String GallBladderBodyRef = "GallBladderBody";
	
	public final static String GallBladderNeck = "biomight.body.gland.gallbladder.GallBladderNeck";
	public final static String GallBladderNeckRef = "GallBladderNeck";
	
	public final static String GallBladderSerousCoat = "biomight.body.gland.gallbladder.GallBladderSerousCoat";
	public final static String GallBladderSerousCoatRef = "GallBladderSerousCoat";
	
	public final static String GallBladderFibroMuscularCoat = "biomight.body.gland.gallbladder.GallBladderFibroMuscularCoat";
	public final static String GallBladderFibroMuscularCoatRef = "GallBladderFibroMuscularCoat";
	
	public final static String GallBladderMucousCoat = "biomight.body.gland.gallbladder.GallBladderMucousCoat";
	
	public final static String AschoffsRecesses = "biomight.body.gland.gallbladder.AschoffsRecesses";	 
	public final static String AschoffsRecessesRef = "0AschoffsRecesses";	 	
	 
	public final static String Ovaries = "biomight.body.gland.ovary.Ovaries";
	public final static String LeftOvary = "biomight.body.gland.ovary.Ovaries";

	public final static String PinealGland = "biomight.body.gland.pineal.PinealGland";
	public final static String PinealGlandRef = "PinealGland";
	
	public final static String PituitaryGland = "biomight.body.gland.pituitary.PituitaryGland";
	public final static String PituitaryGlandRef = "PituitaryGland";	

	public final static String AdenoHypophysis = "biomight.body.gland.pituitary.AdenoHypophysis";
	public final static String AdenoHypophysisRef = "AdenoHypophysis";
	
	public final static String NeuroHypophysis = "biomight.body.gland.pituitary.NeuroHypophysis";
	public final static String NeuroHypophysisRef = "NeuroHypophysis";
	
	public final static String ThyroidGland = "biomight.body.gland.thyroid.ThyroidGland";
	public final static String ThyroidGlandRef = "ThyroidGland";

	public final static String ParaThyroidGlands = "biomight.body.gland.thyroid.ParaThyroidGlands";
	public final static String ParaThyroidGlandsRef = "ParaThyroidGlands";

	public final static String ParaThyroidGland = "biomight.body.gland.thyroid.ParaThyroidGland";
	public final static String ParaThyroidGlandRef = "ParaThyroidGland";

	public final static String AdrenalGlands = "biomight.body.gland.adrenal.AdrenalGlands";
	public final static String AdrenalGlandsRef = "AdrenalGlands";
	
	public final static String AdrenalGland = "biomight.body.gland.adrenal.AdrenalGland";
	public final static String AdrenalGlandRef = "AdrenalGland";

	public final static String AdrenalCortex = "biomight.body.gland.adrenal.AdrenalCortex";
	public final static String AdrenalCortexRef = "AdrenalCortex";

	public final static String AdrenalMedulla = "biomight.body.gland.adrenal.AdrenalMedulla";
	public final static String AdrenalMedullaRef = "AdrenalMedulla";
	
	public final static String ZonaReticularis = "biomight.body.gland.adrenal.ZonaReticularis";
	public final static String ZonaReticularisRef = "ZonaReticularis";
	
	
	
	/********************************************************************************
	 * 
	 * SYSTEMS
	 * 
	 ********************************************************************************/ 

	 public final static String BioMightSystems = "biomight.system.BioMightSystems";
	 public final static String BioMightSystemsRef = "BioMightSystems";

	 final static String BioMightSystem = "biomight.system.BioMightSystem";
	 
	 public final static String BillarySystem = "biomight.system.BillarySystem";
	 public final static String BillarySystemRef = "BillarySystem";
	 
	 public final static String DigestiveSystem = "biomight.system.DigestiveSystem";
	 public final static String DigestiveSystemRef = "DigestiveSystem";
	 
	 public final static String UrinarySystem = "biomight.system.UrinarySystem";
	 public final static String UrinarySystemRef = "UrinarySystem";
	 
	 public final static String LigamentSystem = "biomight.system.LigamentSystem";
	 public final static String LigamentSystemRef = "LigamentSystem";
	 
	 public final static String ReproductiveSystem = "biomight.system.ReproductiveSystem";
	 public final static String ReproductiveSystemRef = "ReproductiveSystem";
	 
	 public final static String RespiratorySystem = "biomight.system.RespiratorySystem";
	 public final static String RespiratorySystemRef = "RespiratorySystem";

	 public final static String TissueSystem = "biomight.system.TissueSystem";
	 public final static String TissueSystemRef = "TissueSystem";
	 
	 public final static String CirculatorySystem = "biomight.system.CirculatorySystem";
	 public final static String CirculatorySystemRef = "CirculatorySystem";
	 
	 public final static String VascularSystem = "biomight.system.VascularSystem";
	 public final static String VascularSystemRef = "VascularSystem";
	 
	/********************************************************************************
	 * 
	 * VASCULAR SYSTEM
	 * 
	 ********************************************************************************/ 
	
	// biomight.system.vascular.arteries
		
	public final static String AcuteMarginalArtery = "biomight.system.vascular.arteries.AcuteMarginalArtery";
	public final static String AcuteMarginalArteryRef = "AcuteMarginalArtery";
	
	public final static String AngularArtery = "biomight.system.vascular.arteries.head.AngularArtery";
	public final static String AngularArteryRef = "AngularArtery";

	public final static String AngularArteries = "biomight.system.vascular.arteries.head.AngularArteries";
	public final static String AngularArteriesRef = "AngularArteries";

	public final static String AnteriorCecalArtery = "biomight.system.vascular.arteries.AnteriorCecalArtery";
	public final static String AnteriorCecalArteryRef = "AnteriorCecalArtery";

	public final static String Arteries = "biomight.system.vascular.arteries.Arteries";
	public final static String ArteriesRef = "Arteries";
	
	public final static String Artery = "biomight.system.vascular.arteries.Artery";
	public final static String ArteryRef = "Artery";
	
	public final static String BrachiocephaticTrunk = "biomight.system.vascular.arteries.BrachiocephaticTrunk";
	public final static String BrachiocephaticTrunkRef = "";
	
	public final static String CecalBranches = "biomight.system.vascular.arteries.CecalBranches";
	public final static String CecalBranchesRef = "";
	
	public final static String CeliacArtery = "biomight.system.vascular.arteries.CeliacArtery";
	public final static String CeliacArteryRef = "CeliacArtery";
	
	public final static String CircumflexArtery = "biomight.system.vascular.arteries.CircumflexArtery";
	public final static String CircumflexArteryRef = "";
	
	public final static String CircumflexScapularArtery = "biomight.system.vascular.arteries.CircumflexScapularArtery";
	public final static String CircumflexScapularArteryRef = "";
	
	public final static String CostocervicalTrunkArtery = "biomight.system.vascular.arteries.CostocervicalTrunkArtery";
	public final static String CostocervicalTrunkArteryRef = "";
	
	public final static String DiagonalArtery = "biomight.system.vascular.arteries.DiagonalArtery";
	public final static String DiagonalArteryRef = "";
	
	public final static String DiagonalCoronaryArtery = "biomight.system.vascular.arteries.DiagonalCoronaryArtery";
	public final static String DiagonalCoronaryArteryRef = "";
	
	public final static String ExternalPudendalArtery = "biomight.system.vascular.arteries.ExternalPudendalArtery";
	public final static String ExternalPudendalArteryRef = "ExternalPudendalArtery";
	
	public final static String IleocolicArtery = "biomight.system.vascular.arteries.IleocolicArtery";
	public final static String IleocolicArteryRef = "";
	
	public final static String IliolumbarArtery = "biomight.system.vascular.arteries.IliolumbarArtery";
	public final static String IliolumbarArteryRef = "";
		
	public final static String LabyrinthineArtery = "biomight.system.vascular.arteries.LabyrinthineArtery";
	public final static String LabyrinthineArteryRef = "";
	
	public final static String LeftAnteriorDescendingArtery = "biomight.system.vascular.arteries.LeftAnteriorDescendingArtery";
	public final static String LeftAnteriorDescendingArteryRef = "";
	
	public final static String PeriCardiaCophrenicArtery = "biomight.system.vascular.arteries.PeriCardiaCophrenicArtery";
	public final static String PeriCardiaCophrenicArteryRef = "";
	
	public final static String PosteriorDescendingArtery = "biomight.system.vascular.arteries.PosteriorDescendingArtery";
	public final static String PosteriorDescendingArteryRef = "";
	
	public final static String PosteriorLateralArtery = "biomight.system.vascular.arteries.PosteriorLateralArtery";
	public final static String PosteriorLateralArteryRef = "";
	
	// biomight.system.vascular.arteries.abdomen	 
	public final static String AdrenalArteries = "biomight.system.vascular.arteries.abdomen.AdrenalArteries";
	public final static String AdrenalArteriesRef = "AdrenalArteries";
	
	public final static String AdrenalArtery = "biomight.system.vascular.arteries.abdomen.AdrenalArtery";
	public final static String AdrenalArteryRef = "AdrenalArtery";
	
	public final static String AppendicularArtery = "biomight.system.vascular.arteries.abdomen.AppendicularArtery";
	public final static String AppendicularArteryRef = "AppendicularArtery";

	public final static String GastroDuodenalArtery = "biomight.system.vascular.arteries.abdomen.GastroDuodenalArtery";
	public final static String GastroDuodenalArteryRef = "GastroDuodenalArtery";

	public final static String SplenicArtery = "biomight.system.vascular.arteries.abdomen.SplenicArtery";
	public final static String SplenicArteryRef = "SplenicArtery";

	public final static String GastricArteries = "biomight.system.vascular.arteries.abdomen.GastricArteries";
	public final static String GastricArteriesRef = "GastricArteries";

	public final static String GastricArtery = "biomight.system.vascular.arteries.abdomen.GastricArtery";
	public final static String GastricArteryRef = "GastricArtery";

	public final static String SpleenCentralArteries = "biomight.system.vascular.arteries.abdomen.SpleenCentralArteries";
	public final static String SpleenCentralArteriesRef = "SpleenCentralArteries";

	public final static String SpleenCentralArtery = "biomight.system.vascular.arteries.abdomen.SpleenCentralArtery";
	public final static String SpleenCentralArteryRef = "SpleenCentralArtery";
	
	public final static String CysticArtery = "biomight.system.vascular.arteries.abdomen.CysticArtery";
	public final static String CysticArteryRef = "CysticArtery";

	public final static String HepaticArteries = "biomight.system.vascular.arteries.abdomen.HepaticArteries";
	public final static String HepaticArteriesRef = "HepaticArteries";

	public final static String HepaticArtery = "biomight.system.vascular.arteries.abdomen.HepaticArtery";
	public final static String HepaticArteryRef = "HepaticArtery";

	public final static String CommonHepaticArtery = "biomight.system.vascular.arteries.abdomen.CommonHepaticArtery";
	public final static String CommonHepaticArteryRef = "CommonHepaticArtery";

	public final static String ProperHepaticArtery = "biomight.system.vascular.arteries.abdomen.ProperHepaticArtery";
	public final static String ProperHepaticArteryRef = "ProperHepaticArtery";

	public final static String InferiorEpigastricArteries = "biomight.system.vascular.arteries.abdomen.InferiorEpigastricArteries";
	public final static String InferiorEpigastricArteriesRef = "InferiorEpigastricArteries";

	public final static String InferiorEpigastricArtery = "biomight.system.vascular.arteries.abdomen.InferiorEpigastricArtery";
	public final static String InferiorEpigastricArteryRef = "InferiorEpigastricArtery";

	public final static String SuperficialEpigastricArteries = "biomight.system.vascular.arteries.abdomen.SuperficialEpigastricArteries";
	public final static String SuperficialEpigastricArteriesRef = "InferiorEpigastricArteries";

	public final static String SuperficialEpigastricArtery = "biomight.system.vascular.arteries.abdomen.SuperficialEpigastricArtery";
	public final static String SuperficialEpigastricArteryRef = "SuperficialEpigastricArtery";

	public final static String InferiorLateralSacralArteries = "biomight.system.vascular.arteries.abdomen.InferiorLateralSacralArteries";
	public final static String InferiorLateralSacralArteriesRef = "InferiorEpigastricArteries";

	public final static String InferiorLateralSacralArtery = "biomight.system.vascular.arteries.abdomen.InferiorLateralSacralArtery";
	public final static String InferiorLateralSacralArteryRef = "InferiorLateralSacralArtery";

	public final static String SuperiorLateralSacralArteries = "biomight.system.vascular.arteries.abdomen.SuperiorLateralSacralArteries";
	public final static String SuperiorLateralSacralArteriesRef = "SuperiorEpigastricArteries";

	public final static String SuperiorLateralSacralArtery = "biomight.system.vascular.arteries.abdomen.SuperiorLateralSacralArtery";
	public final static String SuperiorLateralSacralArteryRef = "SuperiorLateralSacralArtery";

	public final static String MedianSacralArteries = "biomight.system.vascular.arteries.abdomen.MedianSacralArteries";
	public final static String MedianSacralArteriesRef = "MedianSacralArteries";

	public final static String MedianSacralArtery = "biomight.system.vascular.arteries.abdomen.MedianSacralArtery";
	public final static String MedianSacralArteryRef = "MedianSacralArtery";

	
	public final static String InferiorMesentericArteris = "biomight.system.vascular.arteries.abdomen.InferiorMesentericArteries";
	public final static String InferiorMesentericArteriesRef = "InferiorMesentericArteries";

	public final static String InferiorMesentericArtery = "biomight.system.vascular.arteries.abdomen.InferiorMesentericArtery";
	public final static String InferiorMesentericArteryRef = "InferiorMesentericArtery";
	
	public final static String InferiorPhrenicArteries = "biomight.system.vascular.arteries.abdomen.InferiorPhrenicArteries";
	public final static String InferiorPhrenicArteriesRef = "InferiorPhrenicArteries";
	
	public final static String InferiorPhrenicArtery = "biomight.system.vascular.arteries.abdomen.InferiorPhrenicArtery";
	public final static String InferiorPhrenicArteryRef = "InferiorPhrenicArtery";
	
	public final static String InferiorSupraRenalArteries = "biomight.system.vascular.arteries.abdomen.InferiorSupraRenalArteries";
	public final static String InferiorSupraRenalArteriesRef = "InferiorSupraRenalArteries";
	
	public final static String InferiorSupraRenalArtery = "biomight.system.vascular.arteries.abdomen.InferiorSupraRenalArtery";
	public final static String InferiorSupraRenalArteryRef = "InferiorSupraRenalArtery";
	
	public final static String LeftColicArtery = "biomight.system.vascular.arteries.abdomen.LeftColicArtery";
	public final static String LeftColicArteryRef = "";
	
	public final static String GastroEpiploicArtery = "biomight.system.vascular.arteries.abdomen.LeftGastroEpiploicArtery";
	public final static String GastroEpiploicArteryRef = "GastroEpiploicArtery";

	public final static String GastroEpiploicArteries = "biomight.system.vascular.arteries.abdomen.LeftGastroEpiploicArteries";
	public final static String GastroEpiploicArteriesRef = "GastroEpiploicArteries";

	public final static String LeftGastroEpiploicArtery = "biomight.system.vascular.arteries.abdomen.LeftGastroEpiploicArtery";
	public final static String LeftGastroEpiploicArteryRef = "";

	public final static String LienalArtery = "biomight.system.vascular.arteries.abdomen.LienalArtery";
	public final static String LienalArteryRef = "LienalArtery";

	public final static String MiddleSupraRenalArteries = "biomight.system.vascular.arteries.abdomen.MiddleSupraRenalArteries";
	public final static String MiddleSupraRenalArteriesRef = "MiddleSupraRenalArteries";

	public final static String MiddleSupraRenalArtery = "biomight.system.vascular.arteries.abdomen.MiddleSupraRenalArtery";
	public final static String MiddleSupraRenalArteryRef = "MiddleSupraRenalArtery";

	public final static String PenicillarArteries = "biomight.system.vascular.arteries.abdomen.PenicillarArteries";
	public final static String PenicillarArteriesRef = "PenicillarArteries";

	public final static String PenicillarArtery = "biomight.system.vascular.arteries.abdomen.PenicillarArtery";
	public final static String PenicillarArteryRef = "PenicillarArtery";

	public final static String PancreaticoDuodenalArteries = "biomight.system.vascular.arteries.abdomen.PancreaticoDuodenalArteries";
	public final static String PancreaticoDuodenalArteriesRef = "PancreaticoDuodenalArteries";

	public final static String PancreaticoDuodenalArtery = "biomight.system.vascular.arteries.abdomen.PancreaticoDuodenalArtery";
	public final static String PancreaticoDuodenalArteryRef = "PancreaticoDuodenalArtery";

	public final static String InferiorPancreaticoDuodenalArtery = "biomight.system.vascular.arteries.abdomen.InferiorPancreaticoDuodenalArtery";
	public final static String InferiorPancreaticoDuodenalArteryRef = "InferiorPancreaticoDuodenalArtery";

	public final static String SuperiorPancreaticoDuodenalArtery = "biomight.system.vascular.arteries.abdomen.SuperiorPancreaticoDuodenalArtery";
	public final static String SuperiorPancreaticoDuodenalArteryRef = "SuperiorPancreaticoDuodenalArtery";

	public final static String RenalArteries = "biomight.system.vascular.arteries.abdomen.RenalArteries";
	public final static String RenalArteriesRef = "RenalArteries";
	
	public final static String RenalArtery = "biomight.system.vascular.arteries.abdomen.RenalArtery";
	public final static String RenalArteryRef = "RenalArtery";
	
	public final static String RightGastroEpiploicArtery = "biomight.system.vascular.arteries.abdomen.RightGastroEpiploicArtery";
	public final static String RightGastroEpiploicArteryRef = "";

	public final static String SuperiorEpigastricArteries = "biomight.system.vascular.arteries.abdomen.InferiorEpigastricArteries";
	public final static String SuperiorEpigastricArteriesRef = "SuperiorEpigastricArteries";

	public final static String SuperiorEpigastricArtery = "biomight.system.vascular.arteries.abdomen.SuperiorEpigastricArtery";
	public final static String SuperiorEpigastricArteryRef = "SuperiorEpigastricArtery";

	public final static String SuperiorMesentericArtery = "biomight.system.vascular.arteries.abdomen.SuperiorMesentericArtery";
	public final static String SuperiorMesentericArteryRef = "SuperiorMesentericArtery";

	public final static String SuperiorSupraRenalArteries = "biomight.system.vascular.arteries.abdomen.SuperiorSupraRenalArteries";
	public final static String SuperiorSupraRenalArteriesRef = "SuperiorSupraRenalArteries";

	public final static String SuperiorSupraRenalArtery = "biomight.system.vascular.arteries.abdomen.SuperiorSupraRenalArtery";
	public final static String SuperiorSupraRenalArteryRef = "SuperiorSupraRenalArtery";

	public final static String TrabecularArtery = "biomight.system.vascular.arteries.abdomen.TrabecularArtery";
	public final static String TrabecularArteryRef = "TrabecularArtery";
	
	public final static String TrabecularArteries = "biomight.system.vascular.arteries.abdomen.TrabecularArteries";
	public final static String TrabecularArteriesRef = "TrabecularArteries";
	
	public final static String CommonIliacArteries = "biomight.system.vascular.arteries.pelvis.CommonIliacArteries";
	public final static String CommonIliacArteriesRef = "CommonIliacArteries";
	
	public final static String CommonIliacArtery = "biomight.system.vascular.arteries.pelvis.CommonIliacArtery";
	public final static String CommonIliacArteryRef = "CommonIliacArtery";
	
	public final static String ExternalIliacArteries = "biomight.system.vascular.arteries.abdomen.ExternalIliacArteries";
	public final static String ExternalIliacArteriesRef = "ExternalIliacArteries";
	
	public final static String ExternalIliacArtery = "biomight.system.vascular.arteries.abdomen.ExternalIliacArtery";
	public final static String ExternalIliacArteryRef = "ExternalIliacArtery";
	
	public final static String InternalIliacArteries = "biomight.system.vascular.arteries.abdomen.InternalIliacArteries";
	public final static String InternalIliacArteriesRef = "InternalIliacArteries";
	
	public final static String InternalIliacArtery = "biomight.system.vascular.arteries.abdomen.InternalIliacArtery";
	public final static String InternalIliacArteryRef = "InternalIliacArtery";
	
	public final static String GonadalArtery = "biomight.system.vascular.arteries.abdomen.GonadalArtery";
	public final static String GonadalArteryRef = "GonadalArtery";
	
	public final static String LateralEpiphysealArtery = "biomight.system.vascular.arteries.abdomen.LateralEpiphysealArtery";
	public final static String LateralEpiphysealArteryRef = "LateralEpiphysealArtery";
	
	public final static String OvarianArtery = "biomight.system.vascular.arteries.abdomen.OvarianArtery";
	public final static String OvarianArteryRef = "OvarianArtery";
	
	public final static String RectalArtery = "biomight.system.vascular.arteries.abdomen.RectalArtery";
	public final static String RectalArteryRef = "RectalArtery";

	public final static String SuperiorThyroidArteries = "biomight.system.vascular.arteries.neck.SuperiorThyroidArteries";
	public final static String SuperiorThyroidArteriesRef = "SuperiorThyroidArteries";

	public final static String SuperiorThyroidArtery = "biomight.system.vascular.arteries.neck.SuperiorThyroidArtery";
	public final static String SuperiorThyroidArteryRef = "SuperiorThyroidArtery";
	
	public final static String InternalPubicArtery = "biomight.system.vascular.arteries.pelvis.InternalPubicArtery";
	public final static String InternalPubicArteryRef = "InternalPubicArtery";

	public final static String VaginalArtery = "biomight.system.vascular.arteries.pelvis.VaginalArtery";
	public final static String VaginalArteryRef = "VaginalArtery";
	
	// biomight.system.vascular.arteries.arm
	public final static String AnteriorCircumflexHumeralArteries = "biomight.system.vascular.arteries.arm.AnteriorCircumflexHumeralArteries";
	public final static String AnteriorCircumflexHumeralArteriesRef = "AnteriorCircumflexHumeralArteries";
	
	public final static String AnteriorCircumflexHumeralArtery = "biomight.system.vascular.arteries.arm.AnteriorCircumflexHumeralArtery";
	public final static String AnteriorCircumflexHumeralArteryRef = "AnteriorCircumflexHumeralArtery";

	public final static String PosteriorCircumflexHumeralArteries = "biomight.system.vascular.arteries.arm.PosteriorCircumflexHumeralArteries";
	public final static String PosteriorCircumflexHumeralArteriesRef = "PosteriorCircumflexHumeralArteries";
	
	public final static String PosteriorCircumflexHumeralArtery = "biomight.system.vascular.arteries.arm.PosteriorCircumflexHumeralArtery";
	public final static String PosteriorCircumflexHumeralArteryRef = "PosteriorCircumflexHumeralArtery";

	public final static String BrachialArteries = "biomight.system.vascular.arteries.arm.BrachialArteries";
	public final static String BrachialArteriesRef = "BrachialArteries";

	public final static String BrachialArtery = "biomight.system.vascular.arteries.arm.BrachialArtery";
	public final static String BrachialArteryRef = "BrachialArtery";

	public final static String DeepBrachialArteries = "biomight.system.vascular.arteries.arm.DeepBrachialArteries";
	public final static String DeepBrachialArteriesRef = "DeepBrachialArteries";
	
	public final static String DeepBrachialArtery = "biomight.system.vascular.arteries.arm.DeepBrachialArtery";
	public final static String DeepBrachialArteryRef = "DeepBrachialArtery";
	
	public final static String SuperiorUlnarCollateralArteries = "biomight.system.vascular.arteries.arm.SuperiorUlnarCollateralArteries";
	public final static String SuperiorUlnarCollateralArteriesRef = "SuperiorUlnarCollateralArteries";

	public final static String SuperiorUlnarCollateralArtery = "biomight.system.vascular.arteries.arm.SuperiorUlnarCollateralArtery";
	public final static String SuperiorUlnarCollateralArteryRef = "SuperiorUlnarCollateralArtery";

	public final static String InferiorUlnarCollateralArteries = "biomight.system.vascular.arteries.arm.InferiorUlnarCollateralArteries";
	public final static String InferiorUlnarCollateralArteriesRef = "InferiorUlnarCollateralArteries";

	public final static String InferiorUlnarCollateralArtery = "biomight.system.vascular.arteries.arm.InferiorUlnarCollateralArtery";
	public final static String InferiorUlnarCollateralArteryRef = "InferiorUlnarCollateralArtery";

	public final static String MiddleCollateralArteries = "biomight.system.vascular.arteries.arm.MiddleCollateralArteries";
	public final static String MiddleCollateralArteriesRef = "MiddleCollateralArteries";

	public final static String MiddleCollateralArtery = "biomight.system.vascular.arteries.arm.MiddleCollateralArtery";
	public final static String MiddleCollateralArteryRef = "MiddleCollateralArtery";

	public final static String RadialCollateralArteries = "biomight.system.vascular.arteries.arm.RadialCollateralArteries";
	public final static String RadialCollateralArteriesRef = "RadialCollateralArteries";

	public final static String RadialCollateralArtery = "biomight.system.vascular.arteries.arm.RadialCollateralArtery";
	public final static String RadialCollateralArteryRef = "RadialCollateralArtery";

	
	public final static String DorsalMetacarpalArtery = "biomight.system.vascular.arteries.arm.DorsalMetacarpalArtery";
	public final static String DorsalMetacarpalArteryRef = "";

	public final static String RadialArteries = "biomight.system.vascular.arteries.arm.RadialArteries";
	public final static String RadialArteriesRef = "RadialArteries";

	public final static String RadialArtery = "biomight.system.vascular.arteries.arm.RadialArtery";
	public final static String RadialArteryRef = "RadialArtery";

	public final static String UlnarArteries = "biomight.system.vascular.arteries.arm.UlnarArteries";
	public final static String UlnarArteriesRef = "UlnarArteries";
	
	public final static String UlnarArtery = "biomight.system.vascular.arteries.arm.UlnarArtery";
	public final static String UlnarArteryRef = "UlnarArtery";

	public final static String AnteriorUlnarRecurrentArteries = "biomight.system.vascular.arteries.arm.AnteriorUlnarRecurrentArteries";
	public final static String AnteriorUlnarRecurrentArteriesRef = "AnteriorUlnarRecurrentArteries";
	
	public final static String AnteriorUlnarRecurrentArtery = "biomight.system.vascular.arteries.arm.AnteriorUlnarRecurrentArtery";
	public final static String AnteriorUlnarRecurrentArteryRef = "AnteriorUlnarRecurrentArtery";

	public final static String AnteriorInterosseousArteries = "biomight.system.vascular.arteries.arm.AnteriorInterosseousArteries";
	public final static String AnteriorInterosseousArteriesRef = "AnteriorInterosseousArteries";
	
	public final static String AnteriorInterosseousArtery = "biomight.system.vascular.arteries.arm.AnteriorInterosseousArtery";
	public final static String AnteriorInterosseousArteryRef = "AnteriorInterosseousArtery";

	public final static String InterosseousRecurrentArteries = "biomight.system.vascular.arteries.arm.InterosseousRecurrentArteries";
	public final static String InterosseousRecurrentArteriesRef = "InterosseousRecurrentArteries";
	
	public final static String InterosseousRecurrentArtery = "biomight.system.vascular.arteries.arm.InterosseousRecurrentArtery";
	public final static String InterosseousRecurrentArteryRef = "InterosseousRecurrentArtery";

	public final static String PosteriorInterosseousArteries = "biomight.system.vascular.arteries.arm.PosteriorInterosseousArteries";
	public final static String PosteriorInterosseousArteriesRef = "PosteriorInterosseousArteries";
	
	public final static String PosteriorInterosseousArtery = "biomight.system.vascular.arteries.arm.PosteriorInterosseousArtery";
	public final static String PosteriorInterosseousArteryRef = "PosteriorInterosseousArtery";

	public final static String PosteriorUlnarRecurrentArteries = "biomight.system.vascular.arteries.arm.PosteriorUlnarRecurrentArteries";
	public final static String PosteriorUlnarRecurrentArteriesRef = "PosteriorUlnarRecurrentArteries";
	
	public final static String PosteriorUlnarRecurrentArtery = "biomight.system.vascular.arteries.arm.PosteriorUlnarRecurrentArtery";
	public final static String PosteriorUlnarRecurrentArteryRef = "PosteriorUlnarRecurrentArtery";

	public final static String RadialRecurrentArteries = "biomight.system.vascular.arteries.arm.RadialRecurrentArteries";
	public final static String RadialRecurrentArteriesRef = "RadialRecurrentArteries";

	public final static String RadialRecurrentArtery = "biomight.system.vascular.arteries.arm.RadialRecurrentArtery";
	public final static String RadialRecurrentArteryRef = "RadialRecurrentArtery";
	
	// biomight.system.vascular.arteries.back
	public final static String VertebralArtery = "biomight.system.vascular.arteries.head.VertebralArtery";
	public final static String VertebralArteryRef = "VertebralArtery";

	public final static String VertebralArteries = "biomight.system.vascular.arteries.head.VertebralArteries";
	public final static String VertebralArteriesRef = "VertebralArteries";

	public final static String AnteriorRadicularArtery = "biomight.system.vascular.arteries.back.VertebralArtery";
	public final static String AnteriorRadicularArteryRef = "AnteriorRadicularArtery";
	
	public final static String AnteriorRadicularArteries = "biomight.system.vascular.arteries.back.VertebralArteries";
	public final static String AnteriorRadicularArteriesRef = "AnteriorRadicularArteries";
	
	public final static String GreatAnteriorRadicularArtery = "biomight.system.vascular.arteries.back.GreatAnteriorRadicularArtery";
	public final static String GreatAnteriorRadicularArteryRef = "GreatAnteriorRadicularArtery";
	
	public final static String GreatAnteriorRadicularArteries = "biomight.system.vascular.arteries.back.GreatAnteriorRadicularArteries";
	public final static String GreatAnteriorRadicularArteriesRef = "GreatAnteriorRadicularArteries";

	public final static String AnteriorSpinalArtery = "biomight.system.vascular.arteries.back.AnteriorSpinalArtery";
	public final static String AnteriorSpinalArteryRef = "AnteriorSpinalArtery";
	
	public final static String AnteriorSpinalArteries = "biomight.system.vascular.arteries.back.AnteriorSpinalArteries";
	public final static String AnteriorSpinalArteriesRef = "AnteriorSpinalArteries";
	
	public final static String AscendingCervicalArtery = "biomight.system.vascular.arteries.back.AscendingCervicalArtery";
	public final static String AscendingCervicalArteryRef = "AscendingCervicalArtery";
	
	public final static String AscendingCervicalArteries = "biomight.system.vascular.arteries.back.AscendingCervicalArteries";
	public final static String AscendingCervicalArteriesRef = "AscendingCervicalArteries";
	
	
	
	// biomight.system.vascular.arteries.brain	
	public final static String ArterialCircleOfWillis = "biomight.system.vascular.arteries.brain.ArterialCircleOfWillis";
	public final static String ArterialCircleOfWillisRef = "";
	
	public final static String CallosoMarginalArtery = "biomight.system.vascular.arteries.brain.CallosoMarginalArtery";
	public final static String CallosoMarginalArteryRef = "";
	
	// biomight.system.vascular.arteries.brain.cortical
	public final static String CorticalShortArteries = "biomight.system.vascular.arteries.brain.cortical.CorticalShortArteries";
	public final static String CorticalShortArteriesRef = "";
	
	public final static String MedullaryArteries = "biomight.system.vascular.arteries.brain.cortical.MedullaryArteries";
	public final static String MedullaryArteriesRef = "";
	
	// biomight.system.vascular.arteries.brain.ganglionic
	public final static String AnteroMedialArterialGroup = "biomight.system.vascular.arteries.brain.ganglionic.AnteroMedialGroup";
	public final static String AnteroMedialGroupRef = "";
	
	public final static String GanglionicArterialSystem = "biomight.system.vascular.arteries.brain.ganglionic.GanglionicSystem";
	public final static String GanglionicArterialSystemRef = "";
	
	public final static String LeftAnteroLateralArterialGroup = "biomight.system.vascular.arteries.brain.ganglionic.LeftAnteroLateralGroup";
	public final static String LeftAnteroLateralArterialGroupRef = "";
	
	public final static String LeftPosteroLateralArterialGroup = "biomight.system.vascular.arteries.brain.ganglionic.LeftPosteroLateralGroup";
	public final static String LeftPosteroLateralArterialGroupRef = "";
	
	public final static String PosteroMedialArterialGroup = "biomight.system.vascular.arteries.brain.ganglionic.PosteroMedialGroup";
	public final static String PosteroMedialArterialGroupRef = "";
	
	public final static String RightAnteroLateralArterialGroup = "biomight.system.vascular.arteries.brain.ganglionic.RightAnteroLateralGroup";
	public final static String RightAnteroLateralArterialGroupRef = "";
	
	public final static String RightPosteroLateralArterialGroup = "biomight.system.vascular.arteries.brain.ganglionic.RightPosteroLateralGroup";
	public final static String RightPosteroLateralArterialGroupRef = "";
	
	public final static String TerminalArteries = "biomight.system.vascular.arteries.brain.ganglionic.TerminalArteries";
	public final static String TerminalArteriesRef = "TerminalArteries";
	
	public final static String CavernousSinus = "biomight.system.vascular.veins.brain.CavernousSinus";
	public final static String CavernousSinusRef = "CavernousSinus";
	
	
	
	// biomight.system.vascular.arteries.chest
	public final static String AortaArtery = "biomight.system.vascular.arteries.chest.AortaArtery";
	public final static String AortaArteryRef = "AortaArtery";
	
	public final static String AscendingAortaArtery = "biomight.system.vascular.arteries.chest.AscendingAortaArtery";
	public final static String AscendingAortaArteryRef = "AscendingAortaArtery";

	public final static String AxillaryArteries = "biomight.system.vascular.arteries.chest.AxillaryArteries";
	public final static String AxillaryArteriesRef = "AxillaryArteries";

	public final static String AxillaryArtery = "biomight.system.vascular.arteries.chest.AxillaryArtery";
	public final static String AxillaryArteryRef = "AxillaryArtery";
	
	public final static String BronchialArtery = "biomight.system.vascular.arteries.chest.BronchialArtery";
	public final static String BronchialArteryRef = "BronchialArtery";
	
	public final static String BronchialArteries = "biomight.system.vascular.arteries.chest.BronchialArteries";
	public final static String BronchialArteriesRef = "BronchialArteries";

	public final static String ConusArtery = "biomight.system.vascular.arteries.chest.ConusArtery";
	public final static String ConusArteryRef = "ConusArtery";

	public final static String DescendingAortaArtery = "biomight.system.vascular.arteries.chest.DescendingAortaArtery";
	public final static String DescendingAortaArteryRef = "DescendingAortaArtery";
	
	public final static String AbdominalAortaArtery = "biomight.system.vascular.arteries.chest.AbdominalAortaArtery";
	public final static String AbdominalAortaArteryRef = "AbdominalAortaArtery";
	
	public final static String InferiorAlveolarArtery = "biomight.system.vascular.arteries.chest.InferiorAlveolarArtery";
	public final static String InferiorAlveolarArteryRef = "InferiorAlveolarArtery";
	
	public final static String LeftCoronaryArtery = "biomight.system.vascular.arteries.chest.LeftCoronaryArtery";
	public final static String LeftCoronaryArteryRef = "LeftCoronaryArtery";
	
	public final static String CoronaryArtery = "biomight.system.vascular.arteries.chest.CoronaryArtery";
	public final static String CoronaryArteryRef = "CoronaryArtery";

	public final static String CoronaryArteries = "biomight.system.vascular.arteries.chest.CoronaryArteries";
	public final static String CoronaryArteriesRef = "CoronaryArteries";
	
	public final static String LeftMainCoronaryArtery = "biomight.system.vascular.arteries.chest.LeftMainCoronaryArtery";
	
	public final static String ObtuseMarginalArtery = "biomight.system.vascular.arteries.chest.ObtuseMarginalArtery";
	public final static String ObtuseMarginalArteryRef = "ObtuseMarginalArtery";
	
	public final static String PulmonaryArteries = "biomight.system.vascular.arteries.chest.PulmonaryArteries";
	public final static String PulmonaryArteriesRef = "PulmonaryArteries";
	
	public final static String PosteriorSuperiorAlveolarArteries = "biomight.system.vascular.arteries.chest.PosteriorSuperiorAlveolarArteries";
	public final static String PosteriorSuperiorAlveolarArteriesRef = "PosteriorSuperiorAlveolarArteries";

	public final static String PosteriorSuperiorAlveolarArtery= "biomight.system.vascular.arteries.chest.PosteriorSuperiorAlveolarArtery";
	public final static String PosteriorSuperiorAlveolarArteryRef = "PosteriorSuperiorAlveolarArtery";	
	
	public final static String PulmonaryArtery = "biomight.system.vascular.arteries.chest.PulmonaryArtery";
	public final static String PulmonaryArteryRef = "PulmonaryArtery";
	
	public final static String RightCoronaryArtery = "biomight.system.vascular.arteries.chest.RightCoronaryArtery";
	public final static String RightCoronaryArteryRef = "RightCoronaryArtery";
	
	public final static String SubclavianArtery = "biomight.system.vascular.arteries.chest.SubclavianArtery";
	public final static String SubclavianArteryRef = "SubclavianArtery";

	public final static String SubclavianArteries = "biomight.system.vascular.arteries.chest.SubclavianArteries";
	public final static String SubclavianArteriesRef = "SubclavianArteries";

	public final static String ThoracicArteries = "biomight.system.vascular.arteries.chest.ThoracicArteries";
	public final static String ThoracicArteriesRef = "ThoracicArteries";

	public final static String ThoracicArtery = "biomight.system.vascular.arteries.chest.ThoracicArtery";
	public final static String ThoracicArteryRef = "ThoracicArtery";
	
	// biomight.system.vascular.arteries.foot
	public final static String LateralCalcanealArtery = "biomight.system.vascular.arteries.foot.LateralCalcanealArtery";
	public final static String LateralCalcanealArteryRef = "LateralCalcanealArtery";

	public final static String PalmarDigitalFootArtery = "biomight.system.vascular.arteries.foot.PalmarDigitalFootArtery";
	public final static String PalmarDigitalFootArteryRef = "PalmarDigitalFootArtery";

	public final static String MedialCalcanealArtery = "biomight.system.vascular.arteries.foot.MedialCalcanealArtery";
	public final static String MedialCalcanealArteryRef = "MedialCalcanealArtery";
	
	public final static String DeepPalmarArterialArch = "biomight.system.vascular.arteries.foot.DeepPalmarArterialArch";
	public final static String DeepPalmarArterialArchRef = "DeepPalmarArterialArch";
	
	public final static String LateralPlantarArtery = "biomight.system.vascular.arteries.foot.LateralPlantarArtery";
	public final static String LateralPlantarArteryRef = "LateralPlantarArtery";
	
	public final static String MedialPlantarArtery = "biomight.system.vascular.arteries.foot.MedialPlantarArtery";
	public final static String MedialPlantarArteryRef = "MedialPlantarArtery";
	
	public final static String PalmarDigitalArtery = "biomight.system.vascular.arteries.foot.PalmarDigitalArtery";
	public final static String PalmarDigitalArteryRef = "MedialPlantarArtery";
	
	public final static String PlantarDigitalArtery = "biomight.system.vascular.arteries.foot.PlantarDigitalArtery";
	public final static String PlantarDigitalArteryRef = "PlantarDigitalArtery";
	
	public final static String PlantarDigitalArteries = "biomight.system.vascular.arteries.foot.PlantarDigitalArteries";
	public final static String PlantarDigitalArteriesRef = "PlantarDigitalArteries";
	
	//public final static String PosteriorTibialArtery = "biomight.system.vascular.arteries.foot.PosteriorTibialArtery";
	public final static String TibialArteries = "biomight.system.vascular.arteries.foot.TibialArteries";
	public final static String TibialArteriesRef = "TibialArteries";
	
	public final static String TibialArtery = "biomight.system.vascular.arteries.foot.TibialArtery";
	public final static String TibialArteryRef = "TibialArtery";

		public final static String SuperficialPalmerArterialArch = "biomight.system.vascular.arteries.foot.SuperficialPalmerArterialArch";
	public final static String SuperficialPalmerArterialArchRef = "";
	
	// biomight.system.vascular.arteries.hand
	public final static String DigitalArteries = "biomight.system.vascular.arteries.DigitalArteries";
	public final static String DigitalArteriesRef = "DigitalArteries";

	public final static String DigitalArtery = "biomight.system.vascular.arteries.DigitalArtery";
	public final static String DigitalArteryRef = "DigitalArtery";

	public final static String DeepPalmarArchArteries = "biomight.system.vascular.arteries.DeepPalmarArchArteries";
	public final static String DeepPalmarArchArteriesRef = "DeepPalmarArchArteries";

	public final static String DeepPalmarArchArtery = "biomight.system.vascular.arteries.DeepPalmarArchArtery";
	public final static String DeepPalmarArchArteryRef = "DeepPalmarArchArtery";
	
	public final static String SuperficialPalmarArchArteries = "biomight.system.vascular.arteries.SuperficialPalmarArchArteries";
	public final static String SuperficialPalmarArchArteriesRef = "SuperficialPalmarArchArteries";

	public final static String SuperficialPalmarArchArtery = "biomight.system.vascular.arteries.SuperficialPalmarArchArtery";
	public final static String SuperficialPalmarArchArteryRef = "SuperficialPalmarArchArtery";

	public final static String PalmarCarpalBranchArteries = "biomight.system.vascular.arteries.PalmarCarpalBranchArteries";
	public final static String PalmarCarpalBranchArteriesRef = "PalmarCarpalBranchArteries";
	
	public final static String PalmarCarpalBranchArtery = "biomight.system.vascular.arteries.PalmarCarpalBranchArtery";
	public final static String PalmarCarpalBranchArteryRef = "PalmarCarpalBranchArtery";
	
	public final static String PalmarMetacarpalArteries = "biomight.system.vascular.arteries.PalmarMetacarpalArteries";
	public final static String PalmarMetacarpalArteriesRef = "PalmarMetacarpalArteries";

	public final static String PalmarMetacarpalArtery = "biomight.system.vascular.arteries.PalmarMetacarpalArtery";
	public final static String PalmarMetacarpalArteryRef = "PalmarMetacarpalArtery";
	
	public final static String PrincepsPollicisArteries = "biomight.system.vascular.arteries.PrincepsPollicisArteries";
	public final static String PrincepsPollicisArteriesRef = "PrincepsPollicisArteries";
	
	public final static String PrincepsPollicisArtery = "biomight.system.vascular.arteries.PrincepsPollicisArtery";
	public final static String PrincepsPollicisArteryRef = "PrincepsPollicisArtery";
	
	public final static String RadialisIndicisArteries = "biomight.system.vascular.arteries.RadialisIndicisArteries";
	public final static String RadialisIndicisArteriesRef = "RadialisIndicisArteries";

	public final static String RadialisIndicisArtery = "biomight.system.vascular.arteries.RadialisIndicisArtery";
	public final static String RadialisIndicisArteryRef = "RadialisIndicisArtery";

	
	public final static String AnteriorChoroidalArtery = "biomight.system.vascular.arteries.head.AnteriorChoroidalArtery";
	public final static String AnteriorChoroidalArteryRef = "AnteriorChoroidalArtery";
	
	public final static String ChoroidalArtery = "biomight.system.vascular.arteries.head.AnteriorChoroidalArtery";
	public final static String ChoroidalArteryRef = "AnteriorChoroidalArtery";
	
	public final static String ChoroidalArteries = "biomight.system.vascular.arteries.head.AnteriorChoroidalArtery";
	public final static String ChoroidalArteriesRef = "ChoroidalArteries";

	public final static String AnteriorCommunicatingArteries = "biomight.system.vascular.arteries.head.AnteriorCommunicatingArteries";
	public final static String AnteriorCommunicatingArteriesRef = "AnteriorCommunicatingArteries";

	public final static String AnteriorCommunicatingArtery = "biomight.system.vascular.arteries.head.AnteriorCommunicatingArtery";
	public final static String AnteriorCommunicatingArteryRef = "AnteriorCommunicatingArtery";

	public final static String DeepAnteriorCommunicatingArteries = "biomight.system.vascular.arteries.head.DeepAnteriorCommunicatingArteries";
	public final static String DeepAnteriorCommunicatingArteriesRef = "DeepAnteriorCommunicatingArteries";

	public final static String DeepAnteriorCommunicatingArtery = "biomight.system.vascular.arteries.head.DeepAnteriorCommunicatingArtery";
	public final static String DeepAnteriorCommunicatingArteryRef = "DeepAnteriorCommunicatingArtery";

	public final static String DorsalAnteriorCommunicatingArteries = "biomight.system.vascular.arteries.head.DorsalAnteriorCommunicatingArteries";
	public final static String DorsalAnteriorCommunicatingArteriesRef = "DorsalAnteriorCommunicatingArteries";

	public final static String DorsalAnteriorCommunicatingArtery = "biomight.system.vascular.arteries.head.DorsalAnteriorCommunicatingArtery";
	public final static String DorsalAnteriorCommunicatingArteryRef = "DorsalAnteriorCommunicatingArtery";

	public final static String AnteriorDeepTemporalArtery = "biomight.system.vascular.arteries.head.AnteriorDeepTemporalArtery";
	public final static String AnteriorDeepTemporalArteryRef = "AnteriorDeepTemporalArtery";
	
	public final static String AnteriorEthmoidalArtery = "biomight.system.vascular.arteries.head.AnteriorEthmoidalArtery";
	public final static String AnteriorEthmoidalArteryRef = "AnteriorEthmoidalArtery";

	public final static String CerebellarArtery = "biomight.system.vascular.arteries.head.CerebellarArtery";
	public final static String CerebellarArteryRef = "CerebellarArtery";

	public final static String CerebellarArteries = "biomight.system.vascular.arteries.head.CerebellarArteries";
	public final static String CerebellarArteriesRef = "CerebellarArteries";

	public final static String SuperiorCerebellarArteries = "biomight.system.vascular.arteries.head.SuperiorCerebellarArteries";
	public final static String SuperiorCerebellarArteriesRef = "SuperiorCerebellarArteries";

	public final static String SuperiorCerebellarArtery = "biomight.system.vascular.arteries.head.SuperiorCerebellarArtery";
	public final static String SuperiorCerebellarArteryRef = "SuperiorCerebellarArtery";

	public final static String PosteriorInferiorCerebellarArteries = "biomight.system.vascular.arteries.head.PosteriorInferiorCerebellarArteries";
	public final static String PosteriorInferiorCerebellarArteriesRef = "PosteriorInferiorCerebellarArteries";

	public final static String PosteriorInferiorCerebellarArtery = "biomight.system.vascular.arteries.head.PosteriorInferiorCerebellarArtery";
	public final static String PosteriorInferiorCerebellarArteryRef = "PosteriorInferiorCerebellarArtery";

	public final static String AnteriorInferiorCerebellarArteries = "biomight.system.vascular.arteries.head.AnteriorInferiorCerebellarArteries";
	public final static String AnteriorInferiorCerebellarArteriesRef = "AnteriorInferiorCerebellarArteries";

	public final static String AnteriorInferiorCerebellarArtery = "biomight.system.vascular.arteries.head.AnteriorInferiorCerebellarArtery";
	public final static String AnteriorInferiorCerebellarArteryRef = "AnteriorInferiorCerebellarArtery";

	public final static String AccessoryMeningealArteries = "biomight.system.vascular.arteries.head.AccessoryMeningealArteries";
	public final static String AccessoryMeningealArteriesRef = "AccessoryMeningealArteries";

	public final static String AccessoryMeningealArtery = "biomight.system.vascular.arteries.brain.AccessoryMeningealArtery";
	public final static String AccessoryMeningealArteryRef = "AccessoryMeningealArtery";
	
	public final static String MiddleMeningealArteries = "biomight.system.vascular.arteries.head.MiddleMeningealArteries";
	public final static String MiddleMeningealArteriesRef = "MiddleMeningealArteries";

	public final static String MiddleMeningealArtery = "biomight.system.vascular.arteries.head.MiddleMeningealArtery";
	public final static String MiddleMeningealArteryRef = "MiddleMeningealArtery";
		
	public final static String PosteriorMeningealArteries = "biomight.system.vascular.arteries.head.PosteriorMeningealArteries";
	public final static String PosteriorMeningealArteriesRef = "PosteriorMeningealArteries";

	public final static String PosteriorMeningealArtery = "biomight.system.vascular.arteries.head.PosteriorMeningealArtery";
	public final static String PosteriorMeningealArteryRef = "PosteriorMeningealArtery";

	public final static String AscendingPharyngealArteries = "biomight.system.vascular.arteries.head.AscendingPharyngealArteries";
	public final static String AscendingPharyngealArteriesRef = "AscendingPharyngealArteries";

	public final static String AscendingPharyngealArtery = "biomight.system.vascular.arteries.head.AscendingPharyngealArtery";
	public final static String AscendingPharyngealArteryRef = "AscendingPharyngealArtery";

	public final static String AnteriorMeningealArterialBranch = "biomight.system.vascular.arteries.head.AnteriorMeningealBranch";
	public final static String AnteriorMeningealArterialBranchRef = "AnteriorInferiorCerebellarArtery";

	public final static String AscendingPalatineArteries = "biomight.system.vascular.arteries.head.AscendingPalatineArteries";
	public final static String AscendingPalatineArteriesRef = "AscendingPalatineArteries";
	
	public final static String AscendingPalatineArtery = "biomight.system.vascular.arteries.head.AscendingPalatineArtery";
	public final static String AscendingPalatineArteryRef = "AscendingPalatineArtery";

	public final static String PalatineArtery = "biomight.system.vascular.arteries.head.PalatineArtery";
	public final static String PalatineArteryRef = "PalatineArtery";

	public final static String PalatineArteries = "biomight.system.vascular.arteries.head.PalatineArteries";
	public final static String PalatineArteriesRef = "PalatineArteries";

	public final static String ExternalMaxillaryArteries = "biomight.system.vascular.arteries.head.ExternalMaxillaryArteries";
	public final static String ExternalMaxillaryArteriesRef = "ExternalMaxillaryArteries";
	
	public final static String ExternalMaxillaryArtery = "biomight.system.vascular.arteries.head.ExternalMaxillaryArtery";
	public final static String ExternalMaxillaryArteryRef = "ExternalMaxillaryArtery";

	public final static String InternalMaxillaryArteries = "biomight.system.vascular.arteries.head.InternalMaxillaryArteries";
	public final static String InternalMaxillaryArteriesRef = "InternalMaxillaryArteries";
	
	public final static String InternalMaxillaryArtery = "biomight.system.vascular.arteries.head.InternalMaxillaryArtery";
	public final static String InternalMaxillaryArteryRef = "InternalMaxillaryArtery";

	                           
	public final static String SuperficialTemporalArteries = "biomight.system.vascular.arteries.head.SuperficialTemporalArteries";
	public final static String SuperficialTemporalArteriesRef = "SuperficialTemporalArteries";
	
	
	public final static String SuperficialTemporalArtery = "biomight.system.vascular.arteries.head.SuperficialTemporalArtery";
	public final static String SuperficialTemporalArteryRef = "SuperficialTemporalArtery";

	public final static String DescendingPalatineArteries = "biomight.system.vascular.arteries.head.DescendingPalatineArteries";
	public final static String DescendingPalatineArteriesRef = "DescendingPalatineArteries";
	
	public final static String DescendingPalatineArtery = "biomight.system.vascular.arteries.head.DescendingPalatineArtery";
	public final static String DescendingPalatineArteryRef = "DescendingPalatineArtery";

	public final static String BuccalArteries = "biomight.system.vascular.arteries.head.BuccalArteries";
	public final static String BuccalArteriesRef = "BuccalArteries";

	public final static String BasilarArtery = "biomight.system.vascular.arteries.head.BasilarArtery";
	public final static String BasilarArteryRef = "BasilarArtery";
	
	public final static String BasilarArteries = "biomight.system.vascular.arteries.head.BasilarArteries";
	public final static String BasilarArteriesRef = "BasilarArteries";
	
	public final static String BuccalArtery = "biomight.system.vascular.arteries.head.BuccalArtery";
	public final static String BuccalArteryRef = "BuccalArtery";
	
	public final static String CaroticoTympanicArterialBranch = "biomight.system.vascular.arteries.head.CaroticoTympanicBranch";
	public final static String CaroticoTympanicArterialBranchRef = "CaroticoTympanicArterialBranch";
	
	public final static String CarotidArteries = "biomight.system.vascular.arteries.head.CarotidArteries";
	public final static String CarotidArteriesRef = "CarotidArteries";
	
	public final static String CarotidArtery = "biomight.system.vascular.arteries.head.CarotidArtery";
	public final static String CarotidArteryRef = "CarotidArtery";
	
	
	public final static String CarotidArteryCavernous = "biomight.system.vascular.arteries.head.CarotidArteryCavernous";
	public final static String CarotidArteryCavernousRef = "CarotidArteryCavernous";
	
	public final static String CarotidArteryCerebral = "biomight.system.vascular.arteries.head.CarotidArteryCerebral";
	public final static String CarotidArteryCerebralRef = "";
	
	public final static String CarotidArteryCervical = "biomight.system.vascular.arteries.head.CarotidArteryCervical";
	public final static String CarotidArteryCervicalRef = "";
	
	public final static String CarotidArteryPetrous = "biomight.system.vascular.arteries.head.CarotidArteryPetrous";
	public final static String CarotidArteryPetrousRef = "";
	
	public final static String CavernousBranches = "biomight.system.vascular.arteries.head.CavernousBranches";
	public final static String CavernousBranchesRef = "";
	
	public final static String CiliaryArtery = "biomight.system.vascular.arteries.head.CiliaryArtery";
	public final static String CiliaryArteryRef = "";
	
	public final static String CiliaryArteries = "biomight.system.vascular.arteries.head.CiliaryArteries";
	public final static String CiliaryArteriesRef = "CiliaryArteries";
	

	public final static String CirculusArteriosusMajor = "biomight.system.vascular.arteries.head.CirculusArteriosusMajor";
	public final static String CirculusArteriosusMajorRef = "";
	
	public final static String CirculusArteriosusMinor = "biomight.system.vascular.arteries.head.CirculusArteriosusMinor";
	public final static String CirculusArteriosusMinorRef = "";
	
	public final static String CommonCarotidArtery = "biomight.system.vascular.arteries.head.CommonCarotidArtery";
	public final static String CommonCarotidArteryRef = "CommonCarotidArtery";

	public final static String CommonCarotidArteries = "biomight.system.vascular.arteries.head.CommonCarotidArteries";
	public final static String CommonCarotidArteriesRef = "CommonCarotidArteries";

	public final static String ConjunctivalArtery = "biomight.system.vascular.arteries.head.AnteriorChoroidalArtery";
	public final static String ConjunctivalArteryRef = "ConjunctivalArtery";
	
	public final static String ConjunctivalArteries = "biomight.system.vascular.arteries.head.ConjunctivalArteries";
	public final static String ConjunctivalArteriesRef = "ConjunctivalArteries";

	public final static String DeepLingualArtery = "biomight.system.vascular.arteries.head.DeepLingualArtery";
	public final static String DeepLingualArteryRef = "";

	public final static String LingualArtery = "biomight.system.vascular.arteries.head.LingualArtery";
	public final static String LingualArteryRef = "LingualArtery";

	public final static String LingualArteries = "biomight.system.vascular.arteries.head.LingualArteries";
	public final static String LingualArteriesRef = "LingualArteries";
	
	public final static String DorsalLingualArtery = "biomight.system.vascular.arteries.head.DorsalLingualArtery";
	public final static String DorsalLingualArteryRef = "DorsalLingualArtery";
	
	public final static String DorsalNasalArtery = "biomight.system.vascular.arteries.head.DorsalNasalArtery";
	public final static String DorsalNasalArteryRef = "DorsalNasalArtery";
	
	public final static String DorsalNasalArteries = "biomight.system.vascular.arteries.head.DorsalNasalArteries";
	public final static String DorsalNasalArteriesRef = "DorsalNasalArteries";

	public final static String ExternalCarotidArtery = "biomight.system.vascular.arteries.head.ExternalCarotidArtery";
	public final static String ExternalCarotidArteryRef = "ExternalCarotidArtery";

	public final static String ExternalCarotidArteries = "biomight.system.vascular.arteries.head.ExternalCarotidArteries";
	public final static String ExternalCarotidArteriesRef = "ExternalCarotidArteries";

	public final static String FacialArtery = "biomight.system.vascular.arteries.head.FacialArtery";
	public final static String FacialArteryRef = "FacialArtery";

	public final static String FacialArteries = "biomight.system.vascular.arteries.head.FacialArteries";
	public final static String FacialArteriesRef = "FacialArteries";
	
	public final static String TransverseFacialArtery = "biomight.system.vascular.arteries.head.TransverseFacialArtery";
	public final static String TransverseFacialArteryRef = "TransverseFacialArtery";

	public final static String TransverseFacialArteries = "biomight.system.vascular.arteries.head.TransverseFacialArteries";
	public final static String TransverseFacialArteriesRef = "TransverseFacialArteries";
	
	
	public final static String FirstSeptalArtery = "biomight.system.vascular.arteries.head.FirstSeptalArtery";
	public final static String FirstSeptalArteryRef = "FirstSeptalArtery";
	
	public final static String FrontalArtery = "biomight.system.vascular.arteries.head.FrontalArtery";
	public final static String FrontalArteryRef = "FrontalArtery";

	public final static String FrontalArteries = "biomight.system.vascular.arteries.head.FrontalArteries";
	public final static String FrontalArteriesRef = "FrontalArteries";
	
	public final static String GlomusCaroticum = "biomight.system.vascular.arteries.head.GlomusCaroticum";
	public final static String GlomusCaroticumRef = "GlomusCaroticum";
	
	public final static String GlomusCoccygeum = "biomight.system.vascular.arteries.head.GlomusCoccygeum";
	public final static String GlomusCoccygeumRef = "GlomusCoccygeum";
	
	public final static String HypophysealBranches = "biomight.system.vascular.arteries.head.HypophysealBranches";
	public final static String HypophysealBranchesRef = "";

	public final static String HypophysealArteries = "biomight.system.vascular.arteries.head.HypophysealArteries";
	public final static String HypophysealArteriesRef = "HypophysealArteries";

	public final static String HypophysealArtery = "biomight.system.vascular.arteries.head.HypophysealArtery";
	public final static String HypophysealArteryRef = "HypophysealArtery";

	public final static String SuperiorHypophysealArteries = "biomight.system.vascular.arteries.head.SuperiorHypophysealArteries";
	public final static String SuperiorHypophysealArteriesRef = "SuperiorHypophysealArteries";

	public final static String SuperiorHypophysealArtery = "biomight.system.vascular.arteries.head.SuperiorHypophysealArtery";
	public final static String SuperiorHypophysealArteryRef = "SuperiorHypophysealArtery";

	public final static String InferiorHypophysealArteries = "biomight.system.vascular.arteries.head.InferiorHypophysealArteries";
	public final static String InferiorHypophysealArteriesRef = "InferiorHypophysealArteries";

	public final static String InferiorHypophysealArtery = "biomight.system.vascular.arteries.head.InferiorHypophysealArtery";
	public final static String InferiorHypophysealArteryRef = "InferiorHypophysealArtery";
		
	public final static String InferiorLabialArteries = "biomight.system.vascular.arteries.head.InferiorLabialArteries";
	public final static String InferiorLabialArteriesRef = "InferiorLabialArteries";
	
	public final static String InferiorLabialArtery = "biomight.system.vascular.arteries.head.InferiorLabialArtery";
	public final static String InferiorLabialArteryRef = "InferiorLabialArtery";
	
	public final static String InferiorLateralPalpebralArteries = "biomight.system.vascular.arteries.head.InferiorLateralPalpebralArteries";
	public final static String InferiorLateralPalpebralArteriesRef = "";
	
	public final static String InferiorMedialPalpebralArtery = "biomight.system.vascular.arteries.head.InferiorMedialPalpebralArtery";
	public final static String InferiorMedialPalpebralArteryRef = "InferiorMedialPalpebralArtery";
	
	public final static String InferiorTympanicArtery = "biomight.system.vascular.arteries.head.InferiorTympanicArtery";
	public final static String InferiorTympanicArteryRef = "InternalCarotidArtery";
	
	public final static String InfraOrbitalArteries = "biomight.system.vascular.arteries.head.InfraOrbitalArteries";
	public final static String InfraOrbitalArteriesRef = "InfraOrbitalArteries";
	
	public final static String InfraOrbitalArtery = "biomight.system.vascular.arteries.head.InfraOrbitalArtery";
	public final static String InfraOrbitalArteryRef = "InfraOrbitalArtery";
	
	public final static String SupraOrbitalArteries = "biomight.system.vascular.arteries.head.SupraOrbitalArteries";
	public final static String SupraOrbitalArteriesRef = "SupraOrbitalArteries";
	
	public final static String SupraOrbitalArtery = "biomight.system.vascular.arteries.head.SupraOrbitalArtery";
	public final static String SupraOrbitalArteryRef = "SupraOrbitalArtery";
	
	public final static String SupraTrochlearArteries = "biomight.system.vascular.arteries.head.SupraTrochlearArteries";
	public final static String SupraTrochlearArteriesRef = "SupraTrochlearArteries";
	
	public final static String SupraTrochlearArtery = "biomight.system.vascular.arteries.head.SupraTrochlearArtery";
	public final static String SupraTrochlearArteryRef = "SupraTrochlearArtery";
	
	public final static String InternalCarotidArtery = "biomight.system.vascular.arteries.head.InternalCarotidArtery";
	public final static String InternalCarotidArteryRef = "InternalCarotidArtery";

	public final static String InternalCarotidArteries = "biomight.system.vascular.arteries.head.InternalCarotidArteries";
	public final static String InternalCarotidArteriesRef = "InternalCarotidArteries";

	public final static String LacrimalArtery = "biomight.system.vascular.arteries.head.LacrimalArtery";
	public final static String LacrimalArteryRef = "LacrimalArtery";
	
	public final static String LacrimalArteries = "biomight.system.vascular.arteries.head.LacrimalArteries";
	public final static String LacrimalArteriesRef = "LacrimalArteries";

	public final static String LacrimalZygomaticArterialBranches = "biomight.system.vascular.arteries.head.LacrimalZygomaticBranches";
	public final static String LacrimalZygomaticBArterialranchesRef = "";
	
	public final static String LateralPalpebralArteries = "biomight.system.vascular.arteries.head.LateralPalpebralArteries";
	public final static String LateralPalpebralArteriesRef = "LateralPalpebralArteries";
	
	public final static String LongPosteriorCiliaryArteries = "biomight.system.vascular.arteries.head.LongPosteriorCiliaryArteries";
	public final static String LongPosteriorCiliaryArteriesRef = "LongPosteriorCiliaryArteries";
	
	public final static String MedialPalpebralArtery = "biomight.system.vascular.arteries.head.MedialPalpebralArteries";
	public final static String MedialPalpebralArteryRef = "MedialPalpebralArtery";

	public final static String MedialPalpebralArteries = "biomight.system.vascular.arteries.head.MedialPalpebralArteries";
	public final static String MedialPalpebralArteriesRef = "MedialPalpebralArteries";

	public final static String MentalArtery = "biomight.system.vascular.arteries.head.MentalArtery";
	public final static String MentalArteryRef = "MentalArtery";
	
	public final static String MentalArteries = "biomight.system.vascular.arteries.head.MentalArteries";
	public final static String MentalArteriesRef = "MentalArteries";

	public final static String CerebralArtery = "biomight.system.vascular.arteries.head.CerebralArtery";
	public final static String CerebralArteryRef = "CerebralArtery";

	public final static String CerebralArteries = "biomight.system.vascular.arteries.head.CerebralArteries";
	public final static String CerebralArteriesRef = "CerebralArteries";

	// biomight.system.vascular.arteries.head
	public final static String AnteriorCerebralArtery = "biomight.system.vascular.arteries.head.AnteriorCerebralArtery";
	public final static String AnteriorCerebralArteryRef = "AnteriorCerebralArtery";

	public final static String AnteriorCerebralArteries = "biomight.system.vascular.arteries.head.AnteriorCerebralArteries";
	public final static String AnteriorCerebralArteriesRef = "AnteriorCerebralArteries";
		
	public final static String MiddleCerebralArteries = "biomight.system.vascular.arteries.head.MiddleCerebralArteries";
	public final static String MiddleCerebralArteriesRef = "MiddleCerebralArteries";
	
	public final static String MiddleCerebralArtery = "biomight.system.vascular.arteries.head.MiddleCerebralArtery";
	public final static String MiddleCerebralArteryRef = "MiddleCerebralArtery";

	public final static String PosteriorCerebralArteries = "biomight.system.vascular.arteries.head.PosteriorCerebralArteries";
	public final static String PosteriorCerebralArteriesRef = "PosteriorCerebralArteries";
	
	public final static String PosteriorCerebralArtery = "biomight.system.vascular.arteries.head.PosteriorCerebralArtery";
	public final static String PosteriorCerebralArteryRef = "PosteriorCerebralArtery";
	
	public final static String OccipitalArtery = "biomight.system.vascular.arteries.head.OccipitalArtery";
	public final static String OccipitalArteryRef = "OccipitalArtery";
	
	public final static String OccipitalArteries = "biomight.system.vascular.arteries.head.OccipitalArteries";
	public final static String OccipitalArteriesRef = "OccipitalArteries";

	public final static String OccipitalArteryAuricularBranch = "biomight.system.vascular.arteries.head.OccipitalArteryAuricularBranch";
	public final static String OccipitalArteryAuricularBranchRef = "";
	
	public final static String OccipitalArteryDescendingBranch = "biomight.system.vascular.arteries.head.OccipitalArteryDescendingBranch";
	public final static String OccipitalArteryDescendingBranchRef = "";
	
	public final static String OccipitalArteryDigastricusBranch = "biomight.system.vascular.arteries.head.OccipitalArteryDigastricusBranch";
	public final static String OccipitalArteryDigastricusBranchRef = "";
	
	public final static String OccipitalArteryLongissimusCapitisBranch = "biomight.system.vascular.arteries.head.OccipitalArteryLongissimusCapitisBranch";
	public final static String OccipitalArteryLongissimusCapitisBranchRef = "";
	
	public final static String OccipitalArteryMeningealBranch = "biomight.system.vascular.arteries.head.OccipitalArteryMeningealBranch";
	public final static String OccipitalArteryMeningealBranchRef = "";
	
	public final static String OccipitalArteryMuscularBranches = "biomight.system.vascular.arteries.head.OccipitalArteryMuscularBranches";
	public final static String OccipitalArteryMuscularBranchesRef = "";
	
	public final static String OccipitalArterySpleniusBranch = "biomight.system.vascular.arteries.head.OccipitalArterySpleniusBranch";
	public final static String OccipitalArterySpleniusBranchRef = "";
	
	public final static String OccipitalArteryStylohyoideusBranch = "biomight.system.vascular.arteries.head.OccipitalArteryStylohyoideusBranch";
	public final static String OccipitalArteryStylohyoideusBranchRef = "";
	
	public final static String OphthalmicArtery = "biomight.system.vascular.arteries.head.OphthalmicArtery";
	public final static String OphthalmicArteryRef = "OphthalmicArtery";

	public final static String OphthalmicArteries = "biomight.system.vascular.arteries.head.OphthalmicArteries";
	public final static String OphthalmicArteriesRef = "OphthalmicArteries";

	public final static String PosteriorAuricularArtery = "biomight.system.vascular.arteries.head.PosteriorAuricularArtery";
	public final static String PosteriorAuricularArteryRef = "PosteriorAuricularArtery";
	
	public final static String PosteriorCommunicatingArtery = "biomight.system.vascular.arteries.head.PosteriorCommunicatingArtery";
	public final static String PosteriorCommunicatingArteryRef = "PosteriorCommunicatingArtery";
	
	public final static String PosteriorCommunicatingArteries = "biomight.system.vascular.arteries.head.PosteriorCommunicatingArteries";
	public final static String PosteriorCommunicatingArteriesRef = "PosteriorDeepTemporalArteries";
	
	public final static String PosteriorDeepTemporalArtery = "biomight.system.vascular.arteries.head.PosteriorDeepTemporalArtery";
	public final static String PosteriorDeepTemporalArteryRef = "PosteriorDeepTemporalArtery";
	
	public final static String EthmoidalArtery = "biomight.system.vascular.arteries.head.EthmoidalArtery";
	public final static String EthmoidalArteryRef = "EthmoidalArtery";
	
	public final static String EthmoidalArteries = "biomight.system.vascular.arteries.head.PosteriorEthmoidalArteries";
	public final static String EthmoidalArteriesRef = "EthmoidalArteries";
	
	public final static String PosteriorEthmoidalArtery = "biomight.system.vascular.arteries.head.PosteriorEthmoidalArtery";
	public final static String PosteriorEthmoidalArteryRef = "PosteriorEthmoidalArtery";

	public final static String RanineArtery = "biomight.system.vascular.arteries.head.RanineArtery";
	public final static String RanineArteryRef = "RanineArtery";

	public final static String RanineArteries = "biomight.system.vascular.arteries.head.RanineArteries";
	public final static String RanineArteriesRef = "RanineArteries";

	public final static String PontineArtery = "biomight.system.vascular.arteries.head.PontineArtery";
	public final static String PontineArteryRef = "PontineArtery";

	public final static String PontineArteries = "biomight.system.vascular.arteries.head.PontineArteries";
	public final static String PontineArteriesRef = "PontineArteries";

	public final static String RetinaCentralArtery = "biomight.system.vascular.arteries.head.RetinaCentralArtery";
	public final static String RetinaCentralArteryRef = "RetinaCentralArtery";
	
	public final static String SemilunarBranches = "biomight.system.vascular.arteries.head.SemilunarBranches";
	public final static String SemilunarBranchesRef = "";
	
	public final static String ShortPosteriorCiliaryArteries = "biomight.system.vascular.arteries.head.ShortPosteriorCiliaryArteries";
	public final static String ShortPosteriorCiliaryArteriesRef = "";
	
	public final static String SternocleidomastoidArtery = "biomight.system.vascular.arteries.head.SternocleidomastoidArtery";
	public final static String SternocleidomastoidArteryRef = "SternocleidomastoidArtery";
	
	public final static String StylomastoidArtery = "biomight.system.vascular.arteries.head.StylomastoidArtery";
	public final static String StylomastoidArteryRef = "StylomastoidArtery";

	public final static String StylomastoidArteries = "biomight.system.vascular.arteries.head.StylomastoidArteries";
	public final static String StylomastoidArteriesRef = "StylomastoidArteries";

	public final static String SubLingualArtery = "biomight.system.vascular.arteries.head.SubLingualArtery";
	public final static String SubLingualArteryRef = "SubLingualArtery";
	
	public final static String SubmentalArtery = "biomight.system.vascular.arteries.head.SubmentalArtery";
	public final static String SubmentalArteryRef = "SubmentalArtery";
	
	public final static String SuperiorLabialArteries = "biomight.system.vascular.arteries.head.SuperiorLabialArteries";
	public final static String SuperiorLabialArteriesRef = "SuperiorLabialArteries";

	public final static String SuperiorLabialArtery = "biomight.system.vascular.arteries.head.SuperiorLabialArtery";
	public final static String SuperiorLabialArteryRef = "SuperiorLabialArtery";
	
	public final static String SuperiorLateralPalpebralArteries = "biomight.system.vascular.arteries.head.SuperiorLateralPalpebralArteries";
	public final static String SuperiorLateralPalpebralArteriesRef = "SuperiorMedialPalpebralArtery";
	
	public final static String SuperiorMedialPalpebralArtery = "biomight.system.vascular.arteries.head.SuperiorMedialPalpebralArtery";
	public final static String SuperiorMedialPalpebralArteryRef = "SuperiorMedialPalpebralArtery";
	
	public final static String ThyroidArtery = "biomight.system.vascular.arteries.head.ThyroidArtery";
	public final static String ThyroidArteryRef = "ThyroidArtery";
	

	
	// biomight.system.vascular.arteries.leg

	public final static String GenicularArteries = "biomight.system.vascular.arteries.leg.GenicularArteries";
	public final static String GenicularArteriesRef = "GenicularArteries";
	
	public final static String GenicularArtery = "biomight.system.vascular.arteries.leg.GenicularArtery";
	public final static String GenicularArteryRef = "GenicularArtery";

	public final static String DorsalArtery = "biomight.system.vascular.arteries.pelvis.DorsalArtery";
	public final static String DorsalArteryRef = "DorsalArtery";

	public final static String BulboUrethralArtery = "biomight.system.vascular.arteries.pelvis.BulboUrethralArtery";
	public final static String BulboUrethralArteryRef = "BulboUrethralArtery";
	
	public final static String AnteriorTibialArteries = "biomight.system.vascular.arteries.leg.AnteriorTibialArteries";
	public final static String AnteriorTibialArteriesRef = "AnteriorTibialArteries";

	public final static String AnteriorTibialArtery = "biomight.system.vascular.arteries.leg.AnteriorTibialArtery";
	public final static String AnteriorTibialArteryRef = "AnteriorTibialArtery";
	
	public final static String ArcuateArtery = "biomight.system.vascular.arteries.leg.ArcuateArtery";
	public final static String ArcuateArteryRef = "ArcuateArtery";

	public final static String CommonFemoralArteries = "biomight.system.vascular.arteries.leg.CommonFemoralArteries";
	public final static String CommonFemoralArteriesRef = "CommonFemoralArteries";

	public final static String CommonFemoralArtery = "biomight.system.vascular.arteries.leg.CommonFemoralArtery";
	public final static String CommonFemoralArteryRef = "CommonFemoralArtery";

	public final static String DeepFemoralArteries = "biomight.system.vascular.arteries.leg.DeepFemoralArteries";
	public final static String DeepFemoralArteriesRef = "DeepFemoralArteries";

	public final static String DeepFemoralArtery = "biomight.system.vascular.arteries.leg.DeepFemoralArtery";
	public final static String DeepFemoralArteryRef = "DeepFemoralArtery";

	public final static String DescendingGenicularArteries = "biomight.system.vascular.arteries.leg.DescendingGenicularArteries";
	public final static String DescendingGenicularArteriesRef = "DescendingGenicularArteries";

	public final static String DescendingGenicularArtery = "biomight.system.vascular.arteries.leg.DescendingGenicularArtery";
	public final static String DescendingGenicularArteryRef = "DescendingGenicularArtery";
	
	public final static String DescendingGenicularArticularArteries = "biomight.system.vascular.arteries.leg.DescendingGenicularArticularArteries";
	public final static String DescendingGenicularArticularArteriesRef = "DescendingGenicularArticularArteries";

	public final static String DescendingGenicularArticularArtery = "biomight.system.vascular.arteries.leg.DescendingGenicularArticularArtery";
	public final static String DescendingGenicularArticularArteryRef = "DescendingGenicularArticularArtery";

	public final static String DescendingGenicularSaphenousArteries = "biomight.system.vascular.arteries.leg.DescendingGenicularSaphenousArteries";
	public final static String DescendingGenicularSaphenousArteriesRef = "DescendingGenicularSaphenousArteries";

	public final static String DescendingGenicularSaphenousArtery = "biomight.system.vascular.arteries.leg.DescendingGenicularSaphenousArtery";
	public final static String DescendingGenicularSaphenousArteryRef = "DescendingGenicularSaphenousArtery";
	
	public final static String DorsalisPedisArteries = "biomight.system.vascular.arteries.leg.DorsalisPedisArteries";
	public final static String DorsalisPedisArteriesRef = "DorsalisPedisArteries";
	
	public final static String DorsalisPedisArtery = "biomight.system.vascular.arteries.leg.DorsalisPedisArtery";
	public final static String DorsalisPedisArteryRef = "DorsalisPedisArtery";

	public final static String InferiorGlutealArteries = "biomight.system.vascular.arteries.leg.InferiorGlutealArteries";
	public final static String InferiorGlutealArteriesRef = "InferiorGlutealArteries";

	public final static String InferiorGlutealArtery = "biomight.system.vascular.arteries.leg.InferiorGlutealArtery";
	public final static String InferiorGlutealArteryRef = "InferiorGlutealArtery";

	public final static String LateralCircumflexFemoralArteries = "biomight.system.vascular.arteries.leg.LateralCircumflexFemoralArteries";
	public final static String LateralCircumflexFemoralArteriesRef = "LateralCircumflexFemoralArteries";

	public final static String LateralCircumflexFemoralArtery = "biomight.system.vascular.arteries.leg.LateralCircumflexFemoralArtery";
	public final static String LateralCircumflexFemoralArteryRef = "LateralCircumflexFemoralArtery";

	public final static String LateralSuperiorGenicularArteries = "biomight.system.vascular.arteries.leg.LateralSuperiorGenicularArteries";
	public final static String LateralSuperiorGenicularArteriesRef = "LateralSuperiorGenicularArteries";

	public final static String LateralSuperiorGenicularArtery = "biomight.system.vascular.arteries.leg.LateralSuperiorGenicularArtery";
	public final static String LateralSuperiorGenicularArteryRef = "LateralSuperiorGenicularArtery";
	
	public final static String MedialCircumflexFemoralArteries = "biomight.system.vascular.arteries.leg.MedialCircumflexFemoralArteries";
	public final static String MedialCircumflexFemoralArteriesRef = "MedialCircumflexFemoralArteries";
	
	public final static String MedialCircumflexFemoralArtery = "biomight.system.vascular.arteries.leg.MedialCircumflexFemoralArtery";
	public final static String MedialCircumflexFemoralArteryRef = "MedialCircumflexFemoralArtery";
	
	public final static String ObturatorArteries = "biomight.system.vascular.arteries.leg.ObturatorArteries";
	public final static String ObturatorArteriesRef = "ObturatorArteries";
	
	public final static String ObturatorArtery = "biomight.system.vascular.arteries.leg.ObturatorArtery";
	public final static String ObturatorArteryRef = "ObturatorArtery";
	
	public final static String PeronealArteries = "biomight.system.vascular.arteries.leg.PeronealArteries";
	public final static String PeronealArteriesRef = "PeronealArteries";
	
	public final static String PeronealArtery = "biomight.system.vascular.arteries.leg.PeronealArtery";
	public final static String PeronealArteryRef = "PeronealArtery";
	
	public final static String PoplitealArteries = "biomight.system.vascular.arteries.leg.PoplitealArteries";
	public final static String PoplitealArteriesRef = "PoplitealArteries";
	
	public final static String PoplitealArtery = "biomight.system.vascular.arteries.leg.PoplitealArtery";
	public final static String PoplitealArteryRef = "PoplitealArtery";
	
	public final static String PosteriorTibialArteries = "biomight.system.vascular.arteries.leg.PosteriorTibialArteries";	
	public final static String PosteriorTibialArteriesRef = "PosteriorTibialArteries";
	
	public final static String PosteriorTibialArtery = "biomight.system.vascular.arteries.leg.PosteriorTibialArtery";	
	public final static String PosteriorTibialArteryRef = "PosteriorTibialArtery";
	
	public final static String ProfundaFemorisArtery = "biomight.system.vascular.arteries.leg.ProfundaFemorisArtery";
	public final static String ProfundaFemorisArteryRef = "ProfundaFemorisArtery";
	
	public final static String SuperficialFemoralArteries = "biomight.system.vascular.arteries.leg.SuperficialFemoralArteries";
	public final static String SuperficialFemoralArteriesRef = "SuperficialFemoralArteries";
	
	public final static String SuperficialFemoralArtery = "biomight.system.vascular.arteries.leg.SuperficialFemoralArtery";
	public final static String SuperficialFemoralArteryRef = "SuperficialFemoralArtery";
	
	// biomight.system.vascular.arteries.neck
	public final static String AnteriorArterialTriangle = "biomight.system.vascular.arteries.neck.AnteriorTriangle";
	public final static String AnteriorArterialTriangleRef = "AnteriorArterialTriangle";
		
	public final static String DeepCervicalArtery = "biomight.system.vascular.arteries.neck.DeepCervicalArtery";
	public final static String DeepCervicalArteryRef = "DeepCervicalArtery";
	
	public final static String InferiorCarotidArterialTriangle = "biomight.system.vascular.arteries.neck.InferiorCarotidTriangle";
	public final static String InferiorCarotidArterialTriangleRef = "InferiorCarotidArterialTriangle";

	public final static String InferiorThyroidAteries = "biomight.system.vascular.arteries.neck.InferiorThyroidAteries";
	public final static String InferiorThyroidAteriesRef = "InferiorThyroidAteries";
	
	public final static String InferiorThyroidAtery = "biomight.system.vascular.arteries.neck.InferiorThyroidAtery";
	public final static String InferiorThyroidAteryRef = "InferiorThyroidAtery";
	
	public final static String PosteriorArterialTriangle = "biomight.system.vascular.arteries.neck.PosteriorTriangle";
	public final static String PosteriorArterialTriangleRef = "";
	
	public final static String SubMaxillaryArterialTriangle = "biomight.system.vascular.arteries.neck.SubMaxillaryTriangle";
	public final static String SubMaxillaryArterialTriangleRef = "";
	
	public final static String SuperiorCarotidArterialTriangle = "biomight.system.vascular.arteries.neck.SuperiorCarotidTriangle";
	public final static String SuperiorCarotidArterialTriangleRef = "";
	
	public final static String SuperiorThyroidAtery = "biomight.system.vascular.arteries.neck.SuperiorThyroidAtery";
	public final static String SuperiorThyroidAteryRef = "";
	
	// biomight.system.vascular.arteries.pelvis
	
	public final static String ColicArteries = "biomight.system.vascular.arteries.abdomen.ColicArteries";
	public final static String ColicArteriesRef = "ColicArteries";

	public final static String ColicArtery = "biomight.system.vascular.arteries.abdomen.ColicArtery";
	public final static String ColicArteryRef = "ColicArtery";
	

	/********************************************************************************
	 * 
	 * VEINS
	 * 
	 ********************************************************************************/ 

	// biomight.system.vascular.veins
	public final static String DoralVenousArterialArch = "biomight.system.vascular.veins.DoralVenousArch";
	public final static String DoralVenousArterialArchRef = "";
	
	public final static String EmbryonicUmbilicalVein = "biomight.system.vascular.veins.EmbryonicUmbilicalVein";
	public final static String EmbryonicUmbilicalVeinRef = "";
	
	public final static String Veins = "biomight.system.vascular.veins.Veins";
	public final static String VeinsRef = "Veins";
	
	public final static String Vein = "biomight.system.vascular.veins.Vein";
	public final static String VeinRef = "Vein";
	
	// biomight.system.vascular.veins.abdomen
	public final static String CysticVein = "biomight.system.vascular.veins.abdomen.CysticVein";
	public final static String CysticVeinRef = "";
	
	public final static String HemiazygosVein = "biomight.system.vascular.veins.abdomen.HemiazygosVein";
	public final static String HemiazygosVeinRef = "";
	
	public final static String HepaticPortalVein = "biomight.system.vascular.veins.abdomen.HepaticPortalVein";
	public final static String HepaticPortalVeinRef = "";
	
	public final static String HepaticVein = "biomight.system.vascular.veins.abdomen.HepaticVein";
	public final static String HepaticVeinRef = "";
	
	public final static String IleocolicVein = "biomight.system.vascular.veins.abdomen.IleocolicVein";
	public final static String IleocolicVeinRef = "";
	
	public final static String IliolumbarVein = "biomight.system.vascular.veins.abdomen.IliolumbarVein";
	public final static String IliolumbarVeinRef = "";
	
	public final static String InferiorEpigastricVein = "biomight.system.vascular.veins.abdomen.InferiorEpigastricVein";
	public final static String InferiorEpigastricVeinRef = "InferiorEpigastricVein";

	public final static String InferiorEpigastricVeins = "biomight.system.vascular.veins.abdomen.InferiorEpigastricVeins";
	public final static String InferiorEpigastricVeinsRef = "InferiorEpigastricVeins";
	
	public final static String ColicVein = "biomight.system.vascular.veins.abdomen.ColicVein";
	public final static String ColicVeinRef = "ColicVein";

	public final static String ColicVeins = "biomight.system.vascular.veins.abdomen.ColicVeins";
	public final static String ColicVeinsRef = "ColicVeins";
	
	public final static String LeftColicVein = "biomight.system.vascular.veins.abdomen.LeftColicVein";
	public final static String LeftColicVeinRef = "LeftColicVein";

	public final static String MiddleColicVein = "biomight.system.vascular.veins.abdomen.MiddleColicVein";
	public final static String MiddleColicVeinRef = "MiddleColicVein";
	
	public final static String RenalVeins = "biomight.system.vascular.veins.abdomen.RenalVeins";
	public final static String RenalVeinsRef = "RenalVeins";
	
	public final static String RenalVein = "biomight.system.vascular.veins.abdomen.RenalVein";
	public final static String RenalVeinRef = "RenalVein";
	
	public final static String LeftRenalVein = "biomight.system.vascular.veins.abdomen.LeftRenalVein";
	public final static String LeftRenalVeinRef = "LeftRenalVein";
	
	public final static String RightRenalVein = "biomight.system.vascular.veins.abdomen.RightRenalVein";
	public final static String RightRenalVeinRef = "RightRenalVein";
	
	public final static String LiverCentralVein = "biomight.system.vascular.veins.abdomen.LiverCentralVein";
	public final static String LiverCentralVeinRef = "LiverCentralVein";
	
	public final static String LiverCentralVeins = "biomight.system.vascular.veins.abdomen.LiverCentralVeins";
	public final static String LiverCentralVeinsRef = "LiverCentralVeins";
	
	public final static String OvarianVein = "biomight.system.vascular.veins.abdomen.OvarianVein";
	public final static String OvarianVeinRef = "OvarianVein";
	
	public final static String PancreaticoDuodenalVeins = "biomight.system.vascular.veins.abdomen.PancreaticoDuodenalVeins";
	public final static String PancreaticoDuodenalVeinsRef = "PancreaticoDuodenalVeins";

	public final static String PancreaticoDuodenalVein = "biomight.system.vascular.veins.abdomen.PancreaticoDuodenalVein";
	public final static String PancreaticoDuodenalVeinRef = "PancreaticoDuodenalVein";
	
	public final static String PulpVein = "biomight.system.vascular.veins.abdomen.PulpVein";
	public final static String PulpVeinRef = "";
	
	public final static String RetroperitonealVein = "biomight.system.vascular.veins.abdomen.RetroperitonealVein";
	public final static String RetroperitonealVeinRef = "RetroperitonealVein";

	public final static String RetroperitonealVeins = "biomight.system.vascular.veins.abdomen.RetroperitonealVeins";
	public final static String RetroperitonealVeinsRef = "RetroperitonealVeins";

	public final static String GastroEpiploicVein = "biomight.system.vascular.veins.abdomen.GastroEpiploicVein";
	public final static String GastroEpiploicVeinRef = "GastroEpiploicVein";
	
	public final static String GastroEpiploicVeins = "biomight.system.vascular.veins.abdomen.GastroEpiploicVeins";
	public final static String GastroEpiploicVeinsRef = "GastroEpiploicVeins";

	public final static String RightGastroEpiploicVein = "biomight.system.vascular.veins.abdomen.RightGastroEpiploicVein";
	public final static String RightGastroEpiploicVeinRef = "RightGastroEpiploicVein";

	public final static String SuperiorEpigastricVein = "biomight.system.vascular.veins.abdomen.SuperiorEpigastricVein";
	public final static String SuperiorEpigastricVeinRef = "SuperiorEpigastricVein";

	public final static String SuperiorEpigastricVeins = "biomight.system.vascular.veins.abdomen.SuperiorEpigastricVeins";
	public final static String SuperiorEpigastricVeinsRef = "SuperiorEpigastricVeinss";
	
	public final static String TrabecularVeins = "biomight.system.vascular.veins.abdomen.TrabecularVeins"; 
	public final static String TrabecularVeinsRef = "TrabecularVeins";
	
	public final static String TrabecularVein = "biomight.system.vascular.veins.abdomen.TrabecularVein"; 
	public final static String TrabecularVeinRef = "TrabecularVein";
	
	// biomight.system.vascular.veins.arm
	public final static String AccessoryCephalicVeins = "biomight.system.vascular.veins.arm.AccessoryCephalicVeins";
	public final static String AccessoryCephalicVeinsRef = "AccessoryCephalicVeins";

	public final static String AccessoryCephalicVein = "biomight.system.vascular.veins.arm.AccessoryCephalicVein";
	public final static String AccessoryCephalicVeinRef = "AccessoryCephalicVein";

	public final static String BasilicVeins = "biomight.system.vascular.veins.arm.BasilicVeins";
	public final static String BasilicVeinsRef = "BasilicVeins";

	public final static String BasilicVein = "biomight.system.vascular.veins.arm.BasilicVein";
	public final static String BasilicVeinRef = "BasilicVein";

	public final static String BrachialVeins = "biomight.system.vascular.veins.arm.BrachialVeins";
	public final static String BrachialVeinsRef = "BrachialVeins";

	public final static String BrachialVein = "biomight.system.vascular.veins.arm.BrachialVein";
	public final static String BrachialVeinRef = "BrachialVein";
	
	public final static String BrachioCephalicArtery = "biomight.system.vascular.veins.arm.BrachioCephalicArtery";
	public final static String BrachioCephalicArteryRef = "BrachioCephalicArtery";

	public final static String CephalicVeins = "biomight.system.vascular.veins.arm.CephalicVeins";
	public final static String CephalicVeinsRef = "CephalicVeins";

	public final static String CephalicVein = "biomight.system.vascular.veins.arm.CephalicVein";
	public final static String CephalicVeinRef = "CephalicVein";
	
	// biomight.system.vascular.veins.back
	public final static String AccessoryVertebralVein = "biomight.system.vascular.veins.back.AccessoryVertebralVein";
	public final static String AccessoryVertebralVeinRef = "AccessoryVertebralVein";
	
	public final static String BasivertebralVein = "biomight.system.vascular.veins.back.BasivertebralVein";
	public final static String BasivertebralVeinRef = "BasivertebralVein";
	
	public final static String MedianCubitalVein = "biomight.system.vascular.veins.back.MedianCubitalVein";
	public final static String MedianCubitalVeinRef = "MedianCubitalVein";
	
	// biomight.system.vascular.veins.brain
	public final static String AdrenalMedullaryVein = "biomight.system.vascular.veins.brain.AdrenalMedullaryVein";
	public final static String AdrenalMedullaryVeinRef = "MedianCubitalVein";
	
	public final static String AnteriorCerebralVein = "biomight.system.vascular.veins.brain.AnteriorCerebralVein";
	public final static String AnteriorCerebralVeinRef = "MedianCubitalVein";
	
	public final static String ArachnoidGranulations = "biomight.system.vascular.veins.brain.ArachnoidGranulations";
	public final static String ArachnoidGranulationsRef = "MedianCubitalVein";
	
	public final static String BasalVein = "biomight.system.vascular.veins.brain.BasalVein";
	public final static String BasalVeinRef = "BasalVein";
	
	public final static String BasalVeinOfRosenthal = "biomight.system.vascular.veins.brain.BasalVeinOfRosenthal";
	public final static String BasalVeinOfRosenthalRef = "BasalVeinOfRosenthal";
	
	public final static String BasilarPlexus = "biomight.system.vascular.veins.brain.BasilarPlexus";
	public final static String BasilarPlexusRef = "BasilarArtery";
	
	public final static String CavernousSinuses = "biomight.system.vascular.veins.brain.CavernousSinuses";
	public final static String CavernousSinusesRef = "CavernousSinuses";
	
	public final static String CerebralVeins = "biomight.system.vascular.veins.brain.CerebralVeins";
	public final static String CerebralVeinsRef = "CerebralVeins";
	
	public final static String ChoroidVein = "biomight.system.vascular.veins.brain.ChoroidVein";
	public final static String ChoroidVeinRef = "CerebralVeins";
	
	public final static String ConfluenceOfTheSinuses = "biomight.system.vascular.veins.brain.ConfluenceOfTheSinuses";
	public final static String ConfluenceOfTheSinusesRef = "";
	
	public final static String DeepMiddleCerebralVein = "biomight.system.vascular.veins.brain.DeepMiddleCerebralVein";
	public final static String DeepMiddleCerebralVeinRef = "";
	
	public final static String EmissaryVein = "biomight.system.vascular.veins.brain.EmissaryVein";
	public final static String EmissaryVeinRef = "EmissaryVein";
	
	public final static String EmissaryVeins = "biomight.system.vascular.veins.brain.EmissaryVeins";
	public final static String EmissaryVeinsRef = "EmissaryVeins";

	public final static String LabialVein = "biomight.system.vascular.veins.brain.EmissaryVein";
	public final static String LabialVeinRef = "EmissaryVein";
	
	public final static String LabialVeins = "biomight.system.vascular.veins.brain.EmissaryVeins";
	public final static String LabialVeinsRef = "EmissaryVeins";

	public final static String GreatAnastomoticVeinOfTrolard = "biomight.system.vascular.veins.brain.GreatAnastomoticVeinOfTrolard";
	public final static String GreatAnastomoticVeinOfTrolardRef = "";
	
	public final static String GreatCerebralVein = "biomight.system.vascular.veins.brain.GreatCerebralVein";
	public final static String GreatCerebralVeinRef = "";
	
	public final static String InferiorCerebellarVeins = "biomight.system.vascular.veins.brain.InferiorCerebellarVeins";
	public final static String InferiorCerebellarVeinsRef = "";
	
	public final static String InferiorCerebralVeins = "biomight.system.vascular.veins.brain.InferiorCerebralVeins";
	public final static String InferiorCerebralVeinsRef = "";
	
	public final static String InferiorStriateVein = "biomight.system.vascular.veins.brain.InferiorStriateVein";
	public final static String InferiorStriateVeinRef = "InferiorStriateVein";
	
	public final static String InterCavernousSinuses = "biomight.system.vascular.veins.brain.IntercavernousSinuses";
	public final static String InterCavernousSinusesRef = "IntercavernousSinuses";

	public final static String MiddleCerebralVeins = "biomight.system.vascular.veins.brain.MiddleCerebralVeins";
	public final static String MiddleCerebralVeinsRef = "MiddleCerebralVeins";


	public final static String InferiorOphthalmicVein = "biomight.system.vascular.veins.brain.InferiorOphthalmicVein";
	public final static String InferiorOphthalmicVeinRef = "";
	
	public final static String InferiorPetrosalSinus = "biomight.system.vascular.veins.brain.InferiorPetrosalSinus";
	public final static String InferiorPetrosalSinusRef = "";
	
	public final static String InferiorSagittalSinus = "biomight.system.vascular.veins.brain.InferiorSagittalSinus";
	public final static String InferiorSagittalSinusRef = "";
	
	public final static String InferiorStriateVeins = "biomight.system.vascular.veins.brain.InferiorStriateVeins";
	public final static String InferiorStriateVeinsRef = "";
	
	public final static String IntercavernousSinuses = "biomight.system.vascular.veins.brain.IntercavernousSinuses";
	public final static String IntercavernousSinusesRef = "";
	
	public final static String InternalCerebralVeins = "biomight.system.vascular.veins.brain.InternalCerebralVeins";
	public final static String InternalCerebralVeinsRef = "";
	
	public final static String MiddleCerebralVein = "biomight.system.vascular.veins.brain.MiddleCerebralVein";
	public final static String MiddleCerebralVeinRef = "";
	
	public final static String OccipitalSinus = "biomight.system.vascular.veins.brain.OccipitalSinus";
	public final static String OccipitalSinusRef = "";
	
	public final static String PetrosquamousSinus = "biomight.system.vascular.veins.brain.PetrosquamousSinus";
	public final static String PetrosquamousSinusRef = "";
	
	public final static String PosteriorAnastomoticVeinOfLabbe = "biomight.system.vascular.veins.brain.PosteriorAnastomoticVeinOfLabbe";
	public final static String PosteriorAnastomoticVeinOfLabbeRef = "";
	
	public final static String SigmoidSinus = "biomight.system.vascular.veins.brain.SigmoidSinus";
	public final static String SigmoidSinusRef = "";
	
	public final static String SphenoparietalSinus = "biomight.system.vascular.veins.brain.SphenoparietalSinus";
	public final static String SphenoparietalSinusRef = "";
	
	public final static String StraightSinus = "biomight.system.vascular.veins.brain.StraightSinus";
	public final static String StraightSinusRef = "";
	
	
	public final static String SuperiorCerebellarVeins = "biomight.system.vascular.veins.brain.SuperiorCerebellarVeins";
	public final static String SuperiorCerebellarVeinsRef = "";

	public final static String SuperiorCerebellarVein = "biomight.system.vascular.veins.brain.SuperiorCerebellarVein";
	public final static String SuperiorCerebellarVeinRef = "SuperiorCerebellarVein";

	public final static String SuperiorCerebralVeins = "biomight.system.vascular.veins.brain.SuperiorCerebralVeins";
	public final static String SuperiorCerebralVeinsRef = "SuperiorCerebralVeins";
	
	public final static String SuperiorCerebralVein = "biomight.system.vascular.veins.brain.SuperiorCerebralVein";
	public final static String SuperiorCerebralVeinRef = "SuperiorCerebralVein";
	
	public final static String SuperiorOphthalmicVein = "biomight.system.vascular.veins.brain.SuperiorOphthalmicVein";
	public final static String SuperiorOphthalmicVeinRef = "";
	
	public final static String SuperiorPetrosalSinus = "biomight.system.vascular.veins.brain.SuperiorPetrosalSinus";
	public final static String SuperiorPetrosalSinusRef = "";
	
	public final static String SuperiorSagittalSinus = "biomight.system.vascular.veins.brain.SuperiorSagittalSinus";
	public final static String SuperiorSagittalSinusRef = "";
	
	public final static String TerminalVein = "biomight.system.vascular.veins.brain.TerminalVein";
	public final static String TerminalVeinRef = "";
	
	public final static String TransverseSinuses = "biomight.system.vascular.veins.brain.TransverseSinuses";
	public final static String TransverseSinusesRef = "";
	
	// biomight.system.vascular.veins.chest
	public final static String AzygosVein = "biomight.system.vascular.veins.chest.AzygosVein";
	public final static String AzygosVeinRef = "InferiorVenaCava";
	
	public final static String GreatCardiacVein = "biomight.system.vascular.veins.chest.GreatCardiacVein";
	public final static String GreatCardiacVeinRef = "GreatCardiacVein";

	public final static String SmallCardiacVein = "biomight.system.vascular.veins.chest.SmallCardiacVein";
	public final static String SmallCardiacVeinRef = "SmallCardiacVein";

	public final static String BrachioCephaticVein = "biomight.system.vascular.veins.chest.BrachioCephaticVein";
	public final static String BrachioCephaticVeinRef = "InferiorVenaCava";
	
	public final static String InferiorVenaCava = "biomight.system.vascular.veins.chest.InferiorVenaCava";
	public final static String InferiorVenaCavaRef = "InferiorVenaCava";
	
	public final static String PulmonaryVeins = "biomight.system.vascular.veins.chest.PulmonaryVeins";
	public final static String PulmonaryVeinsRef = "PulmonaryVeins";
	
	public final static String PulmonaryVein = "biomight.system.vascular.veins.chest.PulmonaryVein";
	public final static String PulmonaryVeinRef = "PulmonaryVein";
		
	public final static String SuperiorVenaCava = "biomight.system.vascular.veins.chest.SuperiorVenaCava";
	public final static String SuperiorVenaCavaRef = "SuperiorVenaCava";

	// biomight.system.vascular.arteries.foot
	public final static String DorsalMetatarsalArteries = "biomight.system.vascular.arteries.foot.DorsalMetatarsalArteries";
	public final static String DorsalMetatarsalArteriesRef = "DorsalMetatarsalArteries";

	public final static String DorsalMetatarsalArtery = "biomight.system.vascular.arteries.foot.DorsalMetatarsalArtery";
	public final static String DorsalMetatarsalArteryRef = "DorsalMetatarsalArtery";

	
	// biomight.system.vascular.veins.foot
	public final static String IntercapitularVein = "biomight.system.vascular.veins.foot.IntercapitularVein";
	public final static String IntercapitularVeinRef = "IntercapitularVein";
	
	public final static String IntercapitularVeins = "biomight.system.vascular.veins.foot.IntercapitularVeins";
	public final static String IntercapitularVeinsRef = "IntercapitularVeins";
	
	public final static String LateralMarginalVein = "biomight.system.vascular.veins.foot.LateralMarginalVein";
	public final static String LateralMarginalVeinRef = "LateralMarginalVein";
	
	public final static String LateralPlantarVein = "biomight.system.vascular.veins.foot.LateralPlantarVein";
	public final static String LateralPlantarVeinRef = "LateralPlantarVein";
	
	public final static String MedialMarginalVein = "biomight.system.vascular.veins.foot.MedialMarginalVein";
	public final static String MedialMarginalVeinRef = "LateralPlantarVein";
	
	public final static String MedialPlantarVein = "biomight.system.vascular.veins.foot.MedialPlantarVein";
	public final static String MedialPlantarVeinRef = "MedialPlantarVein";

	public final static String MedialPlantarVeins = "biomight.system.vascular.veins.foot.MedialPlantarVeins";
	public final static String MedialPlantarVeinsRef = "MedialPlantarVeins";

	public final static String MetatarsalVeins = "biomight.system.vascular.veins.foot.MetatarsalVeins";
	public final static String MetatarsalVeinsRef = "MetatarsalVeins";
	
	public final static String DorsalMetatarsalVein = "biomight.system.vascular.veins.foot.DorsalMetatarsalVein";
	public final static String DorsalMetatarsalVeinRef = "DorsalMetatarsalVein";
	
	public final static String DorsalMetatarsalVeins = "biomight.system.vascular.veins.foot.DorsalMetatarsalVeins";
	public final static String DorsalMetatarsalVeinsRef = "DorsalMetatarsalVeins";
	
	public final static String PlantarMetatarsalVein = "biomight.system.vascular.veins.foot.PlantarMetatarsalVein";
	public final static String PlantarMetatarsalVeinRef = "PlantarMetatarsalVein";

	public final static String PlantarMetatarsalVeins = "biomight.system.vascular.veins.foot.PlantarMetatarsalVeins";
	public final static String PlantarMetatarsalVeinsRef = "PlantarMetatarsalVeins";

	public final static String PlantarVenousArch = "biomight.system.vascular.veins.foot.PlantarCutaneousVenousArch";
	public final static String PlantarVenousArchRef = "PlantarVenousArch";
	
	public final static String SuperficialPalmarArch = "biomight.system.vascular.veins.foot.PlantarCutaneousVenousArch";
	public final static String SuperficialPalmarArchRef = "SuperficialPalmarArchRef";
	
	public final static String SuperficialVenousPalmarArch = "biomight.system.vascular.veins.foot.SuperficialVenousPalmarArch";
	public final static String SuperficialVenousPalmarArchRef = "";

	public final static String SuperficialPlantarArterialArch = "biomight.system.vascular.veins.foot.SuperficialPlantarArterialArch";
	public final static String SuperficialPlantarArterialArchRef = "SuperficialPlantarArterialArch";

	
	// biomight.system.vascular.veins.hand
	
	public final static String PalmarDigitalVeins = "biomight.system.vascular.veins.hand.PalmarDigitalVeins";
	public final static String PalmarDigitalVeinsRef = "PalmarDigitalVeins";

	public final static String PalmarDigitalVein = "biomight.system.vascular.veins.hand.PalmarDigitalVein";
	public final static String PalmarDigitalVeinRef = "PalmarDigitalVein";
	 
	public final static String DigitalVein = "biomight.system.vascular.veins.hand.DigitalVein";
	public final static String DigitalVeinRef = "DigitalVein";

	public final static String DigitalVeins = "biomight.system.vascular.veins.hand.DigitalVeins";
	public final static String DigitalVeinsRef = "DigitalVeins";

	public final static String MedialAntebrachialVein = "biomight.system.vascular.veins.hand.MedialAntebrachialVein";
	public final static String MedialAntebrachialVeinRef = "";
	
	// biomight.system.vascular.veins.head
	

	public final static String AngularVein = "biomight.system.vascular.veins.head.AngularVein";
	public final static String AngularVeinRef = "AngularVein";

	public final static String AngularVeins = "biomight.system.vascular.veins.head.AngularVeins";
	public final static String AngularVeinsRef = "AngularVeins";
	
	public final static String AqueousVein = "biomight.system.vascular.veins.head.AqueousVein";
	public final static String AqueousVeinRef = "AqueousVein";

	public final static String FacialVein = "biomight.system.vascular.veins.head.FacialVein";
	public final static String FacialVeinRef = "FacialVein";

	public final static String FacialVeins = "biomight.system.vascular.veins.head.FacialVeins";
	public final static String FacialVeinsRef = "FacialVeins";
	
	public final static String MentalVein = "biomight.system.vascular.veins.head.MentalVein";
	public final static String MentalVeinRef = "MentalVein";

	public final static String MentalVeins = "biomight.system.vascular.veins.head.MentalVeins";
	public final static String MentalVeinsRef = "MentalVeins";

	public final static String OphthalmicVein = "biomight.system.vascular.veins.head.OphthalmicVein";
	public final static String OphthalmicVeinRef = "OphthalmicVein";

	public final static String OphthalmicVeins = "biomight.system.vascular.veins.head.OphthalmicVeins";
	public final static String OphthalmicVeinsRef = "OphthalmicVeins";

	public final static String MassetericVein = "biomight.system.vascular.veins.head.MassetericVein";
	public final static String MassetericVeinRef = "MassetericVein";

	public final static String MassetericVeins = "biomight.system.vascular.veins.head.MassetericVeins";
	public final static String MassetericVeinsRef = "MassetericVeins";

	public final static String SupraOrbitalVein = "biomight.system.vascular.veins.head.MassetericVein";
	public final static String SupraOrbitalVeinRef = "SupraOrbitalVein";

	public final static String SupraOrbitalVeins = "biomight.system.vascular.veins.head.SupraOrbitalVeins";
	public final static String SupraOrbitalVeinsRef = "SupraOrbitalVeins";
	
	
	
	public final static String CommonFacialVein = "biomight.system.vascular.veins.head.CommonFacialVein";
	public final static String CommonFacialVeinRef = "CommonFacialVein";
	
	public final static String DeepFacialVein = "biomight.system.vascular.veins.head.DeepFacialVein";
	public final static String DeepFacialVeinRef = "CommonFacialVein";
	
	public final static String HypophysealVein = "biomight.system.vascular.veins.head.HypophysealVein";
	public final static String HypophysealVeinRef = "HypophysealVein";
	
	public final static String RetroMandibularVein = "biomight.system.vascular.veins.head.RetroMandibularVein";
	public final static String RetroMandibularVeinRef = "RetroMandibularVein";
	
	public final static String SuperficialTemporalVein = "biomight.system.vascular.veins.head.SuperficialTemporalVein";
	public final static String SuperficialTemporalVeinRef = "SuperficialTemporalVein";

	public final static String DeepTemporalVeins = "biomight.system.vascular.veins.head.DeepTemporalVeins";
	public final static String DeepTemporalVeinsRef = "DeepTemporalVeins";

	public final static String DeepTemporalVein = "biomight.system.vascular.veins.head.DeepTemporalVein";
	public final static String DeepTemporalVeinRef = "DeepTemporalVein";
	
	//**********************************************
	// biomight.system.vascular.veins.leg	
	//**********************************************
	public final static String CommonFemoralVeins = "biomight.system.vascular.arteries.leg.CommonFemoralVeins";
	public final static String CommonFemoralVeinsRef = "CommonFemoralVeins";

	public final static String CommonFemoralVein = "biomight.system.vascular.arteries.leg.CommonFemoralVein";
	public final static String CommonFemoralVeinRef = "CommonFemoralVein";
	
	public final static String AnteriorTibialVeins = "biomight.system.vascular.veins.leg.AnteriorTibialVeins";
	public final static String AnteriorTibialVeinsRef = "AnteriorTibialVeins";
	
	public final static String AnteriorTibialVein = "biomight.system.vascular.veins.leg.AnteriorTibialVein";
	public final static String AnteriorTibialVeinRef = "AnteriorTibialVein";

	public final static String DeepFemoralVeins = "biomight.system.vascular.veins.leg.DeepFemoralVeins";
	public final static String DeepFemoralVeinsRef = "DeepFemoralVeins";

	public final static String DeepFemoralVein = "biomight.system.vascular.veins.leg.DeepFemoralVein";
	public final static String DeepFemoralVeinRef = "DeepFemoralVein";

	public final static String SuperficialFemoralVeins = "biomight.system.vascular.veins.leg.SuperficialFemoralVeins";
	public final static String SuperficialFemoralVeinsRef = "SuperficialFemoralVeins";

	public final static String SuperficialFemoralVein = "biomight.system.vascular.veins.leg.SuperficialFemoralVein";
	public final static String SuperficialFemoralVeinRef = "SuperficialFemoralVein";
	
	public final static String DorsalisPedisVeins = "biomight.system.vascular.veins.leg.DorsalisPedisVeins";
	public final static String DorsalisPedisVeinsRef = "DorsalisPedisVeins";
	
	public final static String DorsalisPedisVein = "biomight.system.vascular.veins.leg.DorsalisPedisVein";
	public final static String DorsalisPedisVeinRef = "DorsalisPedisVein";
	
	public final static String FemoralVein = "biomight.system.vascular.veins.leg.FemoralVein";
	public final static String FemoralVeinRef = "FemoralVein";
	
	public final static String GreatSaphenousVeins = "biomight.system.vascular.veins.leg.GreatSaphenousVeins";
	public final static String GreatSaphenousVeinsRef = "GreatSaphenousVeins";
	
	public final static String GreatSaphenousVein = "biomight.system.vascular.veins.leg.GreatSaphenousVein";
	public final static String GreatSaphenousVeinRef = "GreatSaphenousVein";

	public final static String LateralCircumflexFemoralVeins = "biomight.system.vascular.veins.leg.LateralCircumflexFemoralVeins";
	public final static String LateralCircumflexFemoralVeinsRef = "LateralCircumflexFemoralVeins";
	
	public final static String LateralCircumflexFemoralVein = "biomight.system.vascular.veins.leg.LateralCircumflexFemoralVein";
	public final static String LateralCircumflexFemoralVeinRef = "LateralCircumflexFemoralVein";
	
	public final static String PeronealVeins = "biomight.system.vascular.veins.leg.PeronealVeins";
	public final static String PeronealVeinsRef = "PeronealVeins";
	
	public final static String PeronealVein = "biomight.system.vascular.veins.leg.PeronealVein";
	public final static String PeronealVeinRef = "PeronealVein";

	public final static String PoplitealVeins = "biomight.system.vascular.veins.leg.PoplitealVeins";
	public final static String PoplitealVeinsRef = "PoplitealVeins";
	
	public final static String PoplitealVein = "biomight.system.vascular.veins.leg.PoplitealVein";
	public final static String PoplitealVeinRef = "PoplitealVein";

	public final static String PosteriorTibialVeins = "biomight.system.vascular.veins.leg.PosteriorTibialVeins";
	public final static String PosteriorTibialVeinsRef = "PosteriorTibialVeins";
	
	public final static String PosteriorTibialVein = "biomight.system.vascular.veins.leg.PosteriorTibialVein";
	public final static String PosteriorTibialVeinRef = "PosteriorTibialVein";
	
	public final static String SaphenousArterialBranch = "biomight.system.vascular.veins.leg.SaphenousBranch";
	public final static String SaphenousArterialBranchRef = "SaphenousArterialBranch";

	public final static String SmallSaphenousVeins = "biomight.system.vascular.veins.leg.SmallSaphenousVeins";
	public final static String SmallSaphenousVeinsRef = "SmallSaphenousVeins";
	
	public final static String SmallSaphenousVein = "biomight.system.vascular.veins.leg.SmallSaphenousVein";
	public final static String SmallSaphenousVeinRef = "SmallSaphenousVein";
			
	public final static String SaphenousBranch = "biomight.system.vascular.veins.leg.SaphenousBranch";
	public final static String SaphenousBranchRef = "SaphenousBranch";
	
	// biomight.system.vascular.veins.neck
	public final static String AxillaryVein = "biomight.system.vascular.veins.neck.AxillaryVein";
	public final static String AxillaryVeinRef = "AxillaryVein";
	
	public final static String DeepCervicalVein = "biomight.system.vascular.veins.neck.DeepCervicalVein";
	public final static String DeepCervicalVeinRef = "AxillaryVein";
		
	public final static String ExternalJugularVein = "biomight.system.vascular.veins.neck.ExternalJugularVein";
	public final static String ExternalJugularVeinRef = "ExternalJugularVein";

	public final static String ExternalJugularVeins = "biomight.system.vascular.veins.neck.ExternalJugularVeins";
	public final static String ExternalJugularVeinsRef = "ExternalJugularVeins";

	public final static String InferiorThyroidVein = "biomight.system.vascular.veins.neck.InferiorThyroidVein";
	public final static String InferiorThyroidVeinRef = "InferiorThyroidVein";

	public final static String InferiorThyroidVeins = "biomight.system.vascular.veins.neck.InferiorThyroidVeins";
	public final static String InferiorThyroidVeinsRef = "InferiorThyroidVeins";

	public final static String InternalJugularVein = "biomight.system.vascular.veins.neck.InternalJugularVein";
	public final static String InternalJugularVeinRef = "InternalJugularVein";

	public final static String InternalJugularVeins = "biomight.system.vascular.veins.neck.InternalJugularVeins";
	public final static String InternalJugularVeinsRef = "InternalJugularVeins";
	
	public final static String InnominateVein = "biomight.system.vascular.veins.neck.InnominateVein";
	public final static String InnominateVeinRef = "InnominateVein";
	
	public final static String InnominateVeins = "biomight.system.vascular.veins.neck.InnominateVeins";
	public final static String InnominateVeinsRef = "InnominateVeins";
	
	public final static String LeftInnominateVein = "biomight.system.vascular.veins.neck.LeftInnominateVein";
	public final static String LeftInnominateVeinRef = "LeftInnominateVein";
	
	public final static String MiddleThyroidVein = "biomight.system.vascular.veins.neck.MiddleThyroidVein";
	public final static String MiddleThyroidVeinRef = "MiddleThyroidVein";

	public final static String MiddleThyroidVeins = "biomight.system.vascular.veins.neck.MiddleThyroidVein";
	public final static String MiddleThyroidVeinsRef = "MiddleThyroidVeins";

	public final static String RightInnominateVein = "biomight.system.vascular.veins.neck.RightInnominateVein";
	public final static String RightInnominateVeinRef = "RightInnominateVein";
	
	public final static String SuperiorThyroidVein = "biomight.system.vascular.veins.neck.SuperiorThyroidVein";
	public final static String SuperiorThyroidVeinRef = "SuperiorThyroidVein";
	
	public final static String SuperiorThyroidVeins = "biomight.system.vascular.veins.neck.SuperiorThyroidVeins";
	public final static String SuperiorThyroidVeinsRef = "SuperiorThyroidVeins";

	public final static String SubclavianVein = "biomight.system.vascular.veins.chest.SubclavianVein";
	public final static String SubclavianVeinRef = "SubclavianVein";
	
	public final static String SubclavianVeins = "biomight.system.vascular.veins.chest.SubclavianVeins";
	public final static String SubclavianVeinsRef = "SubclavianVeins";

	// biomight.system.vascular.veins.pelvis
	public final static String CommonIliacVeins = "biomight.system.vascular.veins.pelvis.CommonIliacVeins";
	public final static String CommonIliacVeinsRef = "CommonIliacVeins";
	
	public final static String CommonIliacVein = "biomight.system.vascular.veins.pelvis.CommonIliacVein";
	public final static String CommonIliacVeinRef = "CommonIliacVein";

	public final static String DeepDorsalVeins = "biomight.system.vascular.veins.pelvis.DeepDorsalVeins";
	public final static String DeepDorsalVeinsRef = "DeepDorsalVeins";

	public final static String DeepDorsalVein = "biomight.system.vascular.veins.pelvis.DeepDorsalVein";
	public final static String DeepDorsalVeinRef = "DeepDorsalVein";

	public final static String ExternalIliacVeins = "biomight.system.vascular.veins.pelvis.ExternalIliacVeins";
	public final static String ExternalIliacVeinsRef = "ExternalIliacVeins";
	
	public final static String ExternalIliacVein = "biomight.system.vascular.veins.pelvis.ExternalIliacVein";
	public final static String ExternalIliacVeinRef = "ExternalIliacVein";
	
	public final static String DeepIliacCircumflexVein = "biomight.system.vascular.veins.pelvis.DeepIliacCircumflexVein";
	public final static String DeepIliacCircumflexVeinRef = "DeepIliacCircumflexVein";
	
	public final static String ExternalPudendalVein = "biomight.system.vascular.veins.pelvis.ExternalPudendalVein";
	public final static String ExternalPudendalVeinRef = "ExternalPudendalVein";
	
	public final static String GonadalVein = "biomight.system.vascular.veins.pelvis.GonadalVein";
	public final static String GonadalVeinRef = "GonadalVein";
	
	public final static String HypogastricVein = "biomight.system.vascular.veins.pelvis.HypogastricVein";
	public final static String HypogastricVeinRef = "HypogastricVein";
	
	public final static String InferiorGlutealVein = "biomight.system.vascular.veins.pelvis.InferiorGlutealVein";
	public final static String InferiorGlutealVeinRef = "InferiorGlutealVein";
	
	public final static String InferiorGlutealVeins = "biomight.system.vascular.veins.pelvis.InferiorGlutealVeins";
	public final static String InferiorGlutealVeinsRef = "";
	
	public final static String InferiorHemorrhoidalVein = "biomight.system.vascular.veins.pelvis.InferiorHemorrhoidalVein";
	public final static String InferiorHemorrhoidalVeinRef = "";
	
	public final static String InferiorPhrenicVeins = "biomight.system.vascular.veins.pelvis.InferiorPhrenicVeins";
	public final static String InferiorPhrenicVeinsRef = "InferiorPhrenicVeins";

	public final static String InternalIliacVeins = "biomight.system.vascular.veins.pelvis.InternalIliacVeins";
	public final static String InternalIliacVeinsRef = "InternalIliacVeins";
	
	public final static String InternalIliacVein = "biomight.system.vascular.veins.pelvis.InternalIliacVein";
	public final static String InternalIliacVeinRef = "InternalIliacVein";
	
	public final static String LumbarVeins = "biomight.system.vascular.veins.pelvis.LumbarVeins";
	public final static String LumbarVeinsRef = "LumbarVeins";
	
	public final static String MiddleHemorrhoidalVein = "biomight.system.vascular.veins.pelvis.MiddleHemorrhoidalVein";
	public final static String MiddleHemorrhoidalVeinRef = "MiddleHemorrhoidalVein";
	
	public final static String PerinealVein = "biomight.system.vascular.veins.pelvis.PerinealVein";
	public final static String PerinealVeinRef = "PerinealVein";
	
	public final static String PubicVein = "biomight.system.vascular.veins.pelvis.PubicVein";
	public final static String PubicVeinRef = "PubicVein";
	
	public final static String RightInferiorPhrenicVein = "biomight.system.vascular.veins.pelvis.RightInferiorPhrenicVein";
	public final static String RightInferiorPhrenicVeinRef = "";
	
	public final static String SpermaticVeins = "biomight.system.vascular.veins.pelvis.SpermaticVeins";
	public final static String SpermaticVeinsRef = "";
	
	public final static String SuperficialDorsalVein = "biomight.system.vascular.veins.pelvis.SuperficialDorsalVein";
	public final static String SuperficialDorsalVeinRef = "";
	
	public final static String SuperiorGlutealVeins = "biomight.system.vascular.veins.pelvis.SuperiorGlutealVeins";
	public final static String SuperiorGlutealVeinsRef = "SuperiorGlutealVeins";
	
	public final static String SuperiorGlutealVein = "biomight.system.vascular.veins.pelvis.SuperiorGlutealVeins";
	public final static String SuperiorGlutealVeinRef = "SuperiorGlutealVein";
	
	public final static String UterineVeins = "biomight.system.vascular.veins.pelvis.UterineVeins";
	public final static String UterineVeinsRef = "";
	
	public final static String VaginalVein = "biomight.system.vascular.veins.pelvis.VaginalVein";
	public final static String VaginalVeinRef = "";
	
	public final static String VesicalVein = "biomight.system.vascular.veins.pelvis.VesicalVein";
	public final static String VesicalVeinRef = "";

	public final static String InferiorPhrenicVein = "biomight.system.vascular.veins.pelvis.InferiorPhrenicVein";
	public final static String InferiorPhrenicVeinRef = "InferiorPhrenicVein";

	public final static String LumbarVein = "biomight.system.vascular.veins.pelvis.LumbarVein";
	public final static String LumbarVeinRef = "LumbarVein";

	public final static String MiddleHermorrhoidalVein = "biomight.system.vascular.veins.pelvis.MiddleHermorrhoidalVein";
	public final static String MiddleHermorrhoidalVeinRef = "MiddleHermorrhoidalVein";

	public final static String SpermaticVein = "biomight.system.vascular.veins.pelvis.SpermaticVein";
	public final static String SpermaticVeinRef = "SpermaticVein";

	public final static String UterineVein = "biomight.system.vascular.veins.pelvis.UterineVein";
	public final static String UterineVeinRef = "UterineVein";
		
	
	// biomight.system.vascular.capillary
	public final static String Capillary = "biomight.system.vascular.veins.capillary.Capillary";
	public final static String CapillaryRef = "";
	
	public final static String Capillaries = "biomight.system.vascular.veins.capillary.Capillaries";
	public final static String CapillariesRef = "";
		

	/********************************************************************************
	 * 
	 * NERVOUS SYSTEM 
	 * 
	 ********************************************************************************/ 

	public final static String NervousSystem = "biomight.system.NervousSystem";
	public final static String NervousSystemRef = "NervousSystem";
	
	// biomight.system.nervous.enteric
	public final static String MyentericPlexus = "biomight.system.nervous.nerves.MyentericPlexus";
	public final static String MyentericPlexusRef = "MyentericPlexus";
	
	public final static String SubMucosalPlexus = "biomight.system.nervous.nerves.SubMucosalPlexus";
	public final static String SubMucosalPlexusRef = "MyentericPlexus";
	
	// biomight.system.nervous.nerves
	public final static String AlveolarInferiorNerve = "biomight.system.nervous.nerves.AlveolarInferiorNerve";
	public final static String AlveolarInferiorNerveRef = "";
	
	public final static String AlveolarSuperiorNerve = "biomight.system.nervous.nerves.AlveolarSuperiorNerve";
	public final static String AlveolarSuperiorNerveRef = "";
	
	public final static String AortiCorenalGanglion = "biomight.system.nervous.nerves.AortiCorenalGanglion";
	public final static String AortiCorenalGanglionRef = "";
	
	public final static String AorticorRenalGanglion = "biomight.system.nervous.nerves.AorticorRenalGanglion";
	public final static String AorticorRenalGanglionRef = "";
	
	public final static String AorticPlexus = "biomight.system.nervous.nerves.AorticPlexus";
	public final static String AorticPlexusRef = "";
	
	public final static String AuriculoTemporalNerve = "biomight.system.nervous.nerves.AuriculoTemporalNerve";
	public final static String AuriculoTemporalNerveRef = "";
	
	public final static String CardiacPlexus = "biomight.system.nervous.nerves.CardiacPlexus";
	public final static String CardiacPlexusRef = "";
	
	public final static String CeliacGanglion = "biomight.system.nervous.nerves.CeliacGanglion";
	public final static String CeliacGanglionRef = "";
	
	public final static String CeliacPlexus = "biomight.system.nervous.nerves.CeliacPlexus";
	public final static String CeliacPlexusRef = "";
	
	public final static String DiaphragmaticGanglion = "biomight.system.nervous.nerves.DiaphragmaticGanglion";
	public final static String DiaphragmaticGanglionRef = "";
	
	public final static String Ganglia = "biomight.system.nervous.nerves.Ganglia";
	public final static String GangliaRef = "";
	
	public final static String GastricPlexis = "biomight.system.nervous.nerves.GastricPlexis";
	public final static String GastricPlexisRef = "";
	
	public final static String InferiorCervicalGanglion = "biomight.system.nervous.nerves.InferiorCervicalGanglion";
	public final static String InferiorCervicalGanglionRef = "";
	
	public final static String InferiorMesentericGanglion = "biomight.system.nervous.nerves.InferiorMesentericGanglion";
	public final static String InferiorMesentericGanglionRef = "";
	
	public final static String LeftCeliacGanglion = "biomight.system.nervous.nerves.LeftCeliacGanglion";
	public final static String LeftCeliacGanglionRef = "";
	
	public final static String LowestThoracicGanglion = "biomight.system.nervous.nerves.LowestThoracicGanglion";
	public final static String LowestThoracicGanglionRef = "";
	
	public final static String LumbarGanglia = "biomight.system.nervous.nerves.LumbarGanglia";
	public final static String LumbarGangliaRef = "LumbarGanglia";
	
	public final static String MaxillaryNerve = "biomight.system.nervous.nerves.MaxillaryNerve";
	public final static String MaxillaryNerveRef = "MaxillaryNerve";

	public final static String MaxillaryNerves = "biomight.system.nervous.nerves.MaxillaryNerves";
	public final static String MaxillaryNervesRef = "MaxillaryNerves";
	
	public final static String Nerve = "biomight.system.nervous.nerves.Nerve";
	public final static String NerveRef = "Nerve";
	
	public final static String Nerves = "biomight.system.nervous.nerves.Nerves";
	public final static String NervesRef = "Nerves";
	
	public final static String Neuroblasts = "biomight.system.nervous.nerves.Neuroblasts";
	public final static String NeuroblastsRef = "";
	
	public final static String PhrenicGanglion = "biomight.system.nervous.nerves.PhrenicGanglion";
	public final static String PhrenicGanglionRef = "";
	
	public final static String Plexus = "biomight.system.nervous.nerves.Plexus";
	public final static String PlexusRef = "Plexus";
	
	public final static String PudendalNerve = "biomight.system.nervous.nerves.PudendalNerve";
	public final static String PudendalNerveRef = "PudendalNerve";
	
	public final static String RecurrentLaryngealNerve = "biomight.system.nervous.nerves.RecurrentLaryngealNerve";
	public final static String RecurrentLaryngealNerveRef = "";
	
	public final static String RightCeliacGanglion = "biomight.system.nervous.nerves.RightCeliacGanglion";
	public final static String RightCeliacGanglionRef = "";
	
	public final static String SciaticNerve = "biomight.system.nervous.nerves.SciaticNerve";
	public final static String SciaticNerveRef = "SciaticNerve";
	
	public final static String SomaticMotorFibers = "biomight.system.nervous.nerves.SomaticMotorFibers";
	public final static String SomaticMotorFibersRef = "";
	
	public final static String SpinalAccessoryNerve = "biomight.system.nervous.nerves.SpinalAccessoryNerve";
	public final static String SpinalAccessoryNerveRef = "";
	
	public final static String Spongioblasts = "biomight.system.nervous.nerves.Spongioblasts";
	public final static String SpongioblastsRef = "";
	
	public final static String SuperiorGanglion = "biomight.system.nervous.nerves.SuperiorGanglion";
	public final static String SuperiorGanglionRef = "";
	
	public final static String SuperiorLaryngealNerve = "biomight.system.nervous.nerves.SuperiorLaryngealNerve";
	public final static String SuperiorLaryngealNerveRef = "";
	
	public final static String SympatheticEfferentFibers = "biomight.system.nervous.nerves.SympatheticEfferentFibers";
	public final static String SympatheticEfferentFibersRef = "";
	
	public final static String SympatheticTrunk = "biomight.system.nervous.nerves.SympatheticTrunk";
	public final static String SympatheticTrunkRef = "";
	
	public final static String UpperLumbarGanglion = "biomight.system.nervous.nerves.UpperLumbarGanglion";
	public final static String UpperLumbarGanglionRef = "";
	
	public final static String UpperSacralGanglion = "biomight.system.nervous.nerves.UpperSacralGanglion";
	public final static String UpperSacralGanglionRef = "";
	
	public final static String VidianNerve = "biomight.system.nervous.nerves.VidianNerve";
	public final static String VidianNerveRef = "VidianNerve";
	
	// biomight.system.nervous.nerves.brachialplexus
	public final static String BrachialPlexus = "biomight.system.nervous.nerves.brachialplexus.BrachialPlexus";
	public final static String BrachialPlexusRef = "";
	
	public final static String DorsalScapularNerve = "biomight.system.nervous.nerves.brachialplexus.DorsalScapularNerve";
	public final static String DorsalScapularNerveRef = "DorsalScapularNerve";
	
	public final static String LongThoracicNerve = "biomight.system.nervous.nerves.brachialplexus.LongThoracicNerve";
	public final static String LongThoracicNerveRef = "LongThoracicNerve";
	
	public final static String SupraScapularNerve = "biomight.system.nervous.nerves.brachialplexus.SupraScapularNerve";
	public final static String SupraScapularNerveRef = "SupraScapularNerve";
	
	// biomight.system.nervous.nerves.brachialplexus.lateral
	public final static String LateralCord = "biomight.system.nervous.nerves.brachialplexus.lateral.LateralCord";
	public final static String LateralCordRef = "";
	
	public final static String LateralPectoralNerve = "biomight.system.nervous.nerves.brachialplexus.lateral.LateralPectoralNerve";
	public final static String LateralPectoralNerveRef = "";
	
	public final static String MusculoCutaneousNerve = "biomight.system.nervous.nerves.brachialplexus.lateral.MusculoCutaneousNerve";
	public final static String MusculoCutaneousNerveRef = "";
	
	// biomight.system.nervous.nerves.brachialplexus.medial
	public final static String MedialAnteBrachialCutaneousNerve = "biomight.system.nervous.nerves.brachialplexus.medial.MedialAnteBrachialCutaneousNerve";
	public final static String MedialAnteBrachialCutaneousNerveRef = "";
	
	public final static String MedialBrachialCutaneousNerve = "biomight.system.nervous.nerves.brachialplexus.medial.MedialBrachialCutaneousNerve";
	public final static String MedialBrachialCutaneousNerveRef = "";
	
	public final static String MedialCord = "biomight.system.nervous.nerves.brachialplexus.medial.MedialCord";
	public final static String MedialCordRef = "";
	
	public final static String MedianNerve = "biomight.system.nervous.nerves.brachialplexus.medial.MedianNerve";
	public final static String MedianNerveRef = "MedianNerve";
	
	public final static String MedianPectoralNerve = "biomight.system.nervous.nerves.brachialplexus.medial.MedianPectoralNerve";
	public final static String MedianPectoralNerveRef = "MedianPectoralNerve";
	
	public final static String UlnarNerve = "biomight.system.nervous.nerves.brachialplexus.medial.UlnarNerve";
	public final static String UlnarNerveRef = "UlnarNerve";
	
	// biomight.system.nervous.nerves.brachialplexus.posterior	
	public final static String AxillaryNerve = "biomight.system.nervous.nerves.brachialplexus.posterior.AxillaryNerve";
	public final static String AxillaryNerveRef = "AxillaryNerve";
	
	public final static String LowerSubScapularNerve = "biomight.system.nervous.nerves.brachialplexus.posterior.LowerSubScapularNerve";
	public final static String LowerSubScapularNerveRef = "LowerSubScapularNerve";
	
	public final static String PosteriorCord = "biomight.system.nervous.nerves.brachialplexus.posterior.PosteriorCord";
	public final static String PosteriorCordRef = "";
	
	public final static String RadialNerve = "biomight.system.nervous.nerves.brachialplexus.posterior.RadialNerve";
	public final static String RadialNerveRef = "RadialNerve";
	
	public final static String ThoracodorsalNerve = "biomight.system.nervous.nerves.brachialplexus.posterior.ThoracodorsalNerve";
	public final static String ThoracodorsalNerveRef = "ThoracodorsalNerve";
	
	public final static String UpperSubscapularNerve = "biomight.system.nervous.nerves.brachialplexus.posterior.UpperSubscapularNerve";
	public final static String UpperSubscapularNerveRef = "";
	
	// biomight.system.nervous.nerves.cardiacplexus
	public final static String AnteriorCoronaryPlexus = "biomight.system.nervous.nerves.cardiacplexus.AnteriorCoronaryPlexus";
	public final static String AnteriorCoronaryPlexusRef = "";
	
	public final static String CardiacGangloinOfWrisberg = "biomight.system.nervous.nerves.cardiacplexus.CardiacGangloinOfWrisberg";
	public final static String CardiacGangloinOfWrisbergRef = "";
	
	public final static String PosteriorCoronaryPlexus = "biomight.system.nervous.nerves.cardiacplexus.PosteriorCoronaryPlexus";
	public final static String PosteriorCoronaryPlexusRef = "";
	
	// biomight.system.nervous.nerves.celiacplexus
	public final static String AbdominalAorticPlexus = "biomight.system.nervous.nerves.celiacplexus.AbdominalAorticPlexus";
	public final static String AbdominalAorticPlexusRef = "";
	
	public final static String CeliacGanglia = "biomight.system.nervous.nerves.celiacplexus.CeliacGanglia";
	public final static String CeliacGangliaRef = "CeliacGanglia";
	
	public final static String HepaticPlexus = "biomight.system.nervous.nerves.celiacplexus.HepaticPlexus";
	public final static String HepaticPlexusRef = "";
	
	public final static String InferiorMesentericPlexus = "biomight.system.nervous.nerves.celiacplexus.InferiorMesentericPlexus";
	public final static String InferiorMesentericPlexusRef = "";
	
	public final static String LeftColicPlexus = "biomight.system.nervous.nerves.celiacplexus.LeftColicPlexus";
	public final static String LeftColicPlexusRef = "";
	
	public final static String LinealPlexus = "biomight.system.nervous.nerves.celiacplexus.LinealPlexus";
	public final static String LinealPlexusRef = "";
	
	public final static String PhrenicPlexus = "biomight.system.nervous.nerves.celiacplexus.PhrenicPlexus";
	public final static String PhrenicPlexusRef = "";
	
	public final static String RenalPlexus = "biomight.system.nervous.nerves.celiacplexus.RenalPlexus";
	public final static String RenalPlexusRef = "";
	
	public final static String SigmoidPlexus = "biomight.system.nervous.nerves.celiacplexus.SigmoidPlexus";
	public final static String SigmoidPlexusRef = "";
	
	public final static String SpermaticPlexus = "biomight.system.nervous.nerves.celiacplexus.SpermaticPlexus";
	public final static String SpermaticPlexusRef = "";
	
	public final static String SuperiorGastricPlexus = "biomight.system.nervous.nerves.celiacplexus.SuperiorGastricPlexus";
	public final static String SuperiorGastricPlexusRef = "";
	
	public final static String SuperiorHemorrhoidalPlexus = "biomight.system.nervous.nerves.celiacplexus.SuperiorHemorrhoidalPlexus";
	public final static String SuperiorHemorrhoidalPlexusRef = "";
	
	public final static String SuperiorMesentericPlexus = "biomight.system.nervous.nerves.celiacplexus.SuperiorMesentericPlexus";
	public final static String SuperiorMesentericPlexusRef = "SuperiorMesentericPlexus";
	
	public final static String SuprarenalPlexus = "biomight.system.nervous.nerves.celiacplexus.SuprarenalPlexus";
	public final static String SuprarenalPlexusRef = "SuprarenalPlexus";
	
	// biomight.system.nervous.nerves.cervicalspinal
	public final static String GreatAuricularNerve = "biomight.system.nervous.nerves.cervicalspinal.GreatAuricularNerve";
	public final static String GreatAuricularNerveRef = "";
	
	public final static String GreatOccipitalNerve = "biomight.system.nervous.nerves.cervicalspinal.GreatOccipitalNerve";
	public final static String GreatOccipitalNerveRef = "";
	
	public final static String LesserOccipitalNerve = "biomight.system.nervous.nerves.cervicalspinal.LesserOccipitalNerve";
	public final static String LesserOccipitalNerveRef = "LesserOccipitalNerve";
	
	public final static String PhrenicNerve = "biomight.system.nervous.nerves.cervicalspinal.PhrenicNerve";
	public final static String PhrenicNerveRef = "PhrenicNerve";
	
	public final static String PhrenicNerves = "biomight.system.nervous.nerves.cervicalspinal.PhrenicNerves";
	public final static String PhrenicNervesRef = "PhrenicNerves";
	
	public final static String PosteriorAuricularNerve = "biomight.system.nervous.nerves.cervicalspinal.PosteriorAuricularNerve";
	public final static String PosteriorAuricularNerveRef = "PosteriorAuricularNerve";
	
	public final static String SubOccipitalNerve = "biomight.system.nervous.nerves.cervicalspinal.SubOccipitalNerve";
	public final static String SubOccipitalNerveRef = "";
	
	// biomight.system.nervous.nerves.cranial
	public final static String AbducentNerve = "biomight.system.nervous.nerves.cranial.AbducentNerve";
	public final static String AbducentNerveRef = "";
	
	public final static String AccessoryNerve = "biomight.system.nervous.nerves.cranial.AccessoryNerve";
	public final static String AccessoryNerveRef = "";
	
	public final static String AcousticNerve = "biomight.system.nervous.nerves.cranial.AcousticNerve";
	public final static String AcousticNerveRef = "";
	
	public final static String FacialNerve = "biomight.system.nervous.nerves.cranial.FacialNerve";
	public final static String FacialNerveRef = "";
	
	public final static String GlossopharyngealNerve = "biomight.system.nervous.nerves.cranial.GlossopharyngealNerve";
	public final static String GlossopharyngealNerveRef = "";
	
	public final static String HypoglossalNerve = "biomight.system.nervous.nerves.cranial.HypoglossalNerve";
	public final static String HypoglossalNerveRef = "";
	
	public final static String OculomotorNerve = "biomight.system.nervous.nerves.cranial.OculomotorNerve";
	public final static String OculomotorNerveRef = "";
	
	public final static String OlfactoryNerve = "biomight.system.nervous.nerves.cranial.OlfactoryNerve";
	public final static String OlfactoryNerveRef = "";
	
	public final static String OpticNerve = "biomight.system.nervous.nerves.cranial.OpticNerve";
	public final static String OpticNerveRef = "OpticNerve";

	public final static String OpticNerves = "biomight.system.nervous.nerves.cranial.OpticNerves";
	public final static String OpticNervesRef = "OpticNerves";

	public final static String TrigeminalNerve = "biomight.system.nervous.nerves.cranial.TrigeminalNerve";
	public final static String TrigeminalNerveRef = "";
	
	public final static String TrochlearNerve = "biomight.system.nervous.nerves.cranial.TrochlearNerve";
	public final static String TrochlearNerveRef = "";
	
	public final static String VagusNerve = "biomight.system.nervous.nerves.cranial.VagusNerve";
	public final static String VagusNerveRef = "";
	
	
	// biomight.system.nervous.nerves.foot
	public final static String LateralPlantar = "biomight.system.nervous.nerves.foot.LateralPlantar";
	public final static String LateralPlantarRef = "";
	
	public final static String MedialPlantar = "biomight.system.nervous.nerves.foot.MedialPlantar";
	public final static String MedialPlantarRef = "";
	
	// biomight.system.nervous.nerves.head
	public final static String BuccalNerve = "biomight.system.nervous.nerves.head.BuccalNerve";
	public final static String BuccalNerveRef = "";
	
	public final static String ChordaTympaniNerve = "biomight.system.nervous.nerves.head.ChordaTympaniNerve";
	public final static String ChordaTympaniNerveRef = "";
	
	public final static String LongCiliaryNerve = "biomight.system.nervous.nerves.head.LongCiliaryNerve";
	public final static String LongCiliaryNerveRef = "";
	
	public final static String ShortCiliaryNerve = "biomight.system.nervous.nerves.head.ShortCiliaryNerve";
	public final static String ShortCiliaryNerveRef = "";
	
	// biomight.system.nervous.nerves.head.ear
	public final static String AuditoryNerve = "biomight.system.nervous.nerves.head.ear.AuditoryNerve";
	public final static String AuditoryNerveRef = "";
	
	public final static String CochlearNerve = "biomight.system.nervous.nerves.head.ear.CochlearNerve";
	public final static String CochlearNerveRef = "";
	
	public final static String VestibularNerve = "biomight.system.nervous.nerves.head.ear.VestibularNerve";
	public final static String VestibularNerveRef = "";
	
	// biomight.system.nervous.nerves.hypogastricplexus
	public final static String HypogastricPlexus = "biomight.system.nervous.nerves.hypogastricplexus.HypogastricPlexus";
	public final static String HypogastricPlexusRef = "";
	
	public final static String MiddleHemorrhoidalPlexus = "biomight.system.nervous.nerves.hypogastricplexus.MiddleHemorrhoidalPlexus";
	public final static String MiddleHemorrhoidalPlexusRef = "";
	
	public final static String PelvicPlexus = "biomight.system.nervous.nerves.hypogastricplexus.PelvicPlexus";
	public final static String PelvicPlexusRef = "";
	
	public final static String ProstaticPlexus = "biomight.system.nervous.nerves.hypogastricplexus.ProstaticPlexus";
	public final static String ProstaticPlexusRef = "";
	
	public final static String UterinePlexus = "biomight.system.nervous.nerves.hypogastricplexus.UterinePlexus";
	public final static String UterinePlexusRef = "";
	
	public final static String VaginalPlexus = "biomight.system.nervous.nerves.hypogastricplexus.VaginalPlexus";
	public final static String VaginalPlexusRef = "";
	
	public final static String VesicalPlexus = "biomight.system.nervous.nerves.hypogastricplexus.VesicalPlexus";
	public final static String VesicalPlexusRef = "";
	
	// biomight.system.nervous.nerves.leg.cnemus
	public final static String TibialNerve = "biomight.system.nervous.nerves.leg.cnemus.TibialNerve";
	public final static String TibialNerveRef = "";
	
	// biomight.system.nervous.nerves.leg.thigh
	public final static String FemoralNerve = "biomight.system.nervous.nerves.leg.thigh.FemoralNerve";
	public final static String FemoralNerveRef = "";
	
	public final static String ObturatorNerve = "biomight.system.nervous.nerves.leg.thigh.ObturatorNerve";
	public final static String ObturatorNerveRef = "";
	
	public final static String SuperiorGlutealNerve = "biomight.system.nervous.nerves.leg.thigh.SuperiorGlutealNerve";
	public final static String SuperiorGlutealNerveRef = "";

	// biomight.system.nervous.nerves.neck
	public final static String SuperficialCervicalNerve = "biomight.system.nervous.nerves.neck.SuperficialCervicalNerve";
	public final static String SuperficialCervicalNerveRef = "";
	
	// biomight.system.nervous.shoulder
	public final static String CoccygealNerve = "biomight.system.nervous.nerves.shoulder.CoccygealNerve";
	public final static String CoccygealNerveRef = "";
	
	// biomight.system.nervous.nerves.spinal.lumbarplexus
	public final static String GenitoFemoralNerve = "biomight.system.nervous.nerves.spinal.lumbarplexus.GenitoFemoralNerve";
	public final static String GenitoFemoralNerveRef = "";
	
	public final static String IlioHypoGastricNerve = "biomight.system.nervous.nerves.spinal.lumbarplexus.IlioHypoGastricNerve";
	public final static String IlioHypoGastricNerveRef = "";
	
	public final static String IlioinguinalNerve = "biomight.system.nervous.nerves.spinal.lumbarplexus.IlioinguinalNerve";
	public final static String IlioinguinalNerveRef = "";
	
	public final static String LateralFemoralCutaneousNerve = "biomight.system.nervous.nerves.spinal.lumbarplexus.LateralFemoralCutaneousNerve";
	public final static String LateralFemoralCutaneousNerveRef = "";
	
	public final static String LumbarPlexis = "biomight.system.nervous.nerves.spinal.lumbarplexus.LumbarPlexis";
	public final static String LumbarPlexisRef = "";

	// biomight.system.nervous.nerves.spinal.thoracic
	public final static String AnteriorBranches = "biomight.system.nervous.nerves.spinal.thoracic.AnteriorBranches";
	public final static String AnteriorBranchesRef = "";
	
	public final static String GreaterSplanchnicNerve = "biomight.system.nervous.nerves.spinal.thoracic.GreaterSplanchnicNerve";
	public final static String GreaterSplanchnicNerveRef = "";
	
	public final static String InterCostalNerves = "biomight.system.nervous.nerves.spinal.thoracic.InterCostalNerves";
	public final static String InterCostalNervesRef = "";
	
	public final static String InterCostoBrachialNerve = "biomight.system.nervous.nerves.spinal.thoracic.InterCostoBrachialNerve";
	public final static String InterCostoBrachialNerveRef = "";
	
	public final static String LateralCutaneousBranches = "biomight.system.nervous.nerves.spinal.thoracic.LateralCutaneousBranches";
	public final static String LateralCutaneousBranchesRef = "";
	
	public final static String LesserSplanchnicNerve = "biomight.system.nervous.nerves.spinal.thoracic.LesserSplanchnicNerve";
	public final static String LesserSplanchnicNerveRef = "";
	
	public final static String LowestSplanchnicNerve = "biomight.system.nervous.nerves.spinal.thoracic.LowestSplanchnicNerve";
	public final static String LowestSplanchnicNerveRef = "";
	
	public final static String PosteriorBranches = "biomight.system.nervous.nerves.spinal.thoracic.PosteriorBranches";
	public final static String PosteriorBranchesRef = "";
	
	public final static String RamiCutaneiLaterales = "biomight.system.nervous.nerves.spinal.thoracic.RamiCutaneiLaterales";
	public final static String RamiCutaneiLateralesRef = "";
	
	public final static String ThoracicNerveT1 = "biomight.system.nervous.nerves.spinal.thoracic.ThoracicNerveT1";
	public final static String ThoracicNerveT1Ref = "";
	
	public final static String ThoracicNerveT10 = "biomight.system.nervous.nerves.spinal.thoracic.ThoracicNerveT10";
	public final static String ThoracicNerveT10Ref = "";
	
	public final static String ThoracicNerveT11 = "biomight.system.nervous.nerves.spinal.thoracic.ThoracicNerveT11";
	public final static String ThoracicNerveT11Ref = "";
	
	public final static String ThoracicNerveT12 = "biomight.system.nervous.nerves.spinal.thoracic.ThoracicNerveT12";
	public final static String ThoracicNerveT12Ref = "";
	
	public final static String ThoracicNerveT2 = "biomight.system.nervous.nerves.spinal.thoracic.ThoracicNerveT2";
	public final static String ThoracicNerveT2Ref = "";
	
	public final static String ThoracicNerveT3 = "biomight.system.nervous.nerves.spinal.thoracic.ThoracicNerveT3";
	public final static String ThoracicNerveT3Ref = "";
	
	public final static String ThoracicNerveT4 = "biomight.system.nervous.nerves.spinal.thoracic.ThoracicNerveT4";
	public final static String ThoracicNerveT4Ref = "";
	
	public final static String ThoracicNerveT5 = "biomight.system.nervous.nerves.spinal.thoracic.ThoracicNerveT5";
	public final static String ThoracicNerveT5Ref = "";
	
	public final static String ThoracicNerveT6 = "biomight.system.nervous.nerves.spinal.thoracic.ThoracicNerveT6";
	public final static String ThoracicNerveT6Ref = "";
	
	public final static String ThoracicNerveT7 = "biomight.system.nervous.nerves.spinal.thoracic.ThoracicNerveT7";
	public final static String ThoracicNerveT7Ref = "";
	
	public final static String ThoracicNerveT8 = "biomight.system.nervous.nerves.spinal.thoracic.ThoracicNerveT8";
	public final static String ThoracicNerveT8Ref = "";
	
	public final static String ThoracicNerveT9 = "biomight.system.nervous.nerves.spinal.thoracic.ThoracicNerveT9";
	public final static String ThoracicNerveT9Ref = "";
	
	public final static String ThoracicoAbdominalIntercostalNerves = "biomight.system.nervous.nerves.spinal.thoracic.ThoracicoAbdominalIntercostalNerves";
	public final static String ThoracicoAbdominalIntercostalNervesRef = "";
	
	// biomight.system.nervous.nerves.sympathetic.cephalic
	public final static String Caroticotympanic = "biomight.system.nervous.nerves.sympathetic.cephalic.Caroticotympanic";
	public final static String CaroticotympanicRef = "";
	
	public final static String CarotidInternalNerve = "biomight.system.nervous.nerves.sympathetic.cephalic.CarotidInternalNerve";
	public final static String CarotidInternalNerveRef = "";
	
	public final static String CarotidInternalPlexus = "biomight.system.nervous.nerves.sympathetic.cephalic.CarotidInternalPlexus";
	public final static String CarotidInternalPlexusRef = "";
	
	public final static String CavernousPlexus = "biomight.system.nervous.nerves.sympathetic.cephalic.CavernousPlexus";
	public final static String CavernousPlexusRef = "";
	
	public final static String DeepPetrosal = "biomight.system.nervous.nerves.sympathetic.cephalic.DeepPetrosal";
	public final static String DeepPetrosalRef = "";
		
	// biomight.system.nervous.nerves.sympathetic.cervical
	public final static String AnteriorBranch = "biomight.system.nervous.nerves.sympathetic.cervical.AnteriorBranch";
	public final static String AnteriorBranchRef = "";
	
	public final static String CardiacInferiorNerve = "biomight.system.nervous.nerves.sympathetic.cervical.CardiacInferiorNerve";
	public final static String CardiacInferiorNerveRef = "";
	
	public final static String CardiacSuperiorNerve = "biomight.system.nervous.nerves.sympathetic.cervical.CardiacSuperiorNerve";
	public final static String CardiacSuperiorNerveRef = "";
	
	public final static String InferiorBranch = "biomight.system.nervous.nerves.sympathetic.cervical.InferiorBranch";
	public final static String InferiorBranchRef = "";
	
	public final static String JugularNerve = "biomight.system.nervous.nerves.sympathetic.cervical.JugularNerve";
	public final static String JugularNerveRef = "";
	
	public final static String LaryngopharyngealBranch = "biomight.system.nervous.nerves.sympathetic.cervical.LaryngopharyngealBranch";
	public final static String LaryngopharyngealBranchRef = "";
	
	public final static String LateralBranch = "biomight.system.nervous.nerves.sympathetic.cervical.LateralBranch";
	public final static String LateralBranchRef = "";
	
	public final static String MedialBranch = "biomight.system.nervous.nerves.sympathetic.cervical.MedialBranch";
	public final static String MedialBranchRef = "";
	
	public final static String PharyngealPlexus = "biomight.system.nervous.nerves.sympathetic.cervical.PharyngealPlexus";
	public final static String PharyngealPlexusRef = "";
	
	// biomight.system.nervous.nerves.tongue
	public final static String GlossoPharyngealNerve = "biomight.system.nervous.nerves.tongue.GlossoPharyngealNerve";
	public final static String GlossoPharyngealNerveRef = "";
	
	// biomight.system.nervous.nerves.upperextremtiy
	public final static String DeepBranchOfRadial = "biomight.system.nervous.nerves.upperextremity.DeepBranchOfRadial";
	public final static String DeepBranchOfRadialRef = "";
	
	public final static String DorsalBranch = "biomight.system.nervous.nerves.upperextremity.DorsalBranch";
	public final static String DorsalBranchRef = "";
	
	public final static String LateralAnteriorThoracic = "biomight.system.nervous.nerves.upperextremity.LateralAnteriorThoracic";
	public final static String LateralAnteriorThoracicRef = "LateralAnteriorThoracic";
	
	public final static String MedialAnteriorThoracic = "biomight.system.nervous.nerves.upperextremity.MedialAnteriorThoracic";
	public final static String MedialAnteriorThoracicRef = "MedialAnteriorThoracic";
	
	//public final static String MedianNerve = "biomight.system.nervous.nerves.upperextremity.MedianNerve";
	//public final static String RadialNerve = "biomight.system.nervous.nerves.upperextremity.RadialNerve";
	public final static String SuperficialBranchOfRadial = "biomight.system.nervous.nerves.upperextremity.SuperficialBranchOfRadial";
	public final static String SuperficialBranchOfRadialRef = "";
	
	public final static String UlnaNerve = "biomight.system.nervous.nerves.upperextremity.UlnaNerve";
	public final static String UlnaNerveRef = "UlnaNerve";
	
	public final static String VolarInterosseous = "biomight.system.nervous.nerves.upperextremity.VolarInterosseous";
	public final static String VolarInterosseousRef = "VolarInterosseous";
	
	public final static String ImmuneSystem = "biomight.system.ImmuneSystem";
	public final static String ImmuneSystemRef = "ImmuneSystem";
	
	public final static String ExecretorySystem = "biomight.system.ExecretorySystem";
	public final static String ExecretorySystemRef = "ExecretorySystem";
	
	public final static String IntegumentarySystem = "biomight.system.IntegumentarySystem";
	public final static String IntegumentarySystemRef = "IntegumentarySystem";
	
	public final static String EndocrineSystem = "biomight.system.EndocrineSystem";
	public final static String EndocrineSystemRef = "EndocrineSystem";
	
	
	/********************************************************************************
	 * 
	 * LYMPHATIC SYSTEM 
	 * 
	 ********************************************************************************/ 	 
	
	public final static String LymphaticSystem = "biomight.system.LymphaticSystem";
	public final static String LymphaticSystemRef = "LymphaticSystem";
	
	public final static String Chyle = "biomight.system.lymphatic.Chyle";
	public final static String ChyleRef = "Chyle";
	
	public final static String CisternaChyli = "biomight.system.lymphatic.CisternaChyli";
	public final static String CisternaChyliRef = "CisternaChyli";
	
	public final static String IntestinalTrunk = "biomight.system.lymphatic.IntestinalTrunk";
	public final static String IntestinalTrunkRef = "";
	
	public final static String LeftJugularTrunk = "biomight.system.lymphatic.LeftJugularTrunk";
	public final static String LeftJugularTrunkRef = "";
	
	public final static String LeftSubClavianTrunk = "biomight.system.lymphatic.LeftSubClavianTrunk";
	public final static String LeftSubClavianTrunkRef = "";
	
	public final static String LumbarTrunk = "biomight.system.lymphatic.LumbarTrunk";
	public final static String LumbarTrunkRef = "";
	
	public final static String Lymph = "biomight.system.lymphatic.Lymph";
	public final static String LymphRef = "Lymph";
	
	public final static String LymphaticCapillaries = "biomight.system.lymphatic.LymphaticCapillaries";
	public final static String LymphaticCapillariesRef = "";
	
	public final static String LymphaticCapillary = "biomight.system.lymphatic.LymphaticCapillary";
	public final static String LymphaticCapillaryRef = "";
	
	public final static String LymphaticVessel = "biomight.system.lymphatic.LymphaticVessel";
	public final static String LymphaticVesselRef = "";
	
	public final static String LymphaticVessels = "biomight.system.lymphatic.LymphaticVessels";
	public final static String LymphaticVesselsRef = "";
	
	public final static String RightJugularTrunk = "biomight.system.lymphatic.RightJugularTrunk";
	public final static String RightJugularTrunkRef = "";
	
	public final static String RightLympahticDuct = "biomight.system.lymphatic.RightLympahticDuct";
	public final static String RightLympahticDuctRef = "";
	
	public final static String RightSubClavianTrunk = "biomight.system.lymphatic.RightSubClavianTrunk";
	public final static String RightSubClavianTrunkRef = "";
	
	public final static String ThoracicDuct = "biomight.system.lymphatic.ThoracicDuct";
	public final static String ThoracicDuctRef = "";
	
	public final static String Tributaries = "biomight.system.lymphatic.Tributaries";
	public final static String TributariesRef = "";
	
	// biomight.system.lymphatic.abdomen.parietal
	public final static String CommonIliacGlands = "biomight.system.lymphatic.abdomen.parietal.CommonIliacGlands";
	public final static String CommonIliacGlandsRef = "";
	
	public final static String EpigastricGlands = "biomight.system.lymphatic.abdomen.parietal.EpigastricGlands";
	public final static String EpigastricGlandsRef = "";
	
	public final static String ExternalIliacGlands = "biomight.system.lymphatic.abdomen.parietal.ExternalIliacGlands";
	public final static String ExternalIliacGlandsRef = "";
	
	public final static String HypogastricGlands = "biomight.system.lymphatic.abdomen.parietal.HypogastricGlands";
	public final static String HypogastricGlandsRef = "";
	
	public final static String IliacCircumflexGlands = "biomight.system.lymphatic.abdomen.parietal.IliacCircumflexGlands";
	public final static String IliacCircumflexGlandsRef = "";
	
	public final static String LateralAorticGlands = "biomight.system.lymphatic.abdomen.parietal.LateralAorticGlands";
	public final static String LateralAorticGlandsRef = "";
	
	public final static String LeftLateralAorticGlands = "biomight.system.lymphatic.abdomen.parietal.LeftLateralAorticGlands";
	public final static String LeftLateralAorticGlandsRef = "";
	
	public final static String PreaorticGlands = "biomight.system.lymphatic.abdomen.parietal.PreaorticGlands";
	public final static String PreaorticGlandsRef = "";
	
	public final static String SacralGlands = "biomight.system.lymphatic.abdomen.parietal.SacralGlands";
	public final static String SacralGlandsRef = "";
	
	// biomight.system.lymphatic.chest.deep
	public final static String AxillaryGlandsIntermediateGroup = "biomight.system.lymphatic.chest.deep.AxillaryGlandsIntermediateGroup";
	public final static String AxillaryGlandsIntermediateGroupRef = "";
	
	public final static String AxillaryGlandsSubClavicularG = "biomight.system.lymphatic.chest.deep.AxillaryGlandsSubClavicularG";
	public final static String AxillaryGlandsSubClavicularGRef = "";
	
	public final static String AxillaryGlandsSubScapularGroup = "biomight.system.lymphatic.chest.deep.AxillaryGlandsSubScapularGroup";
	public final static String AxillaryGlandsSubScapularGroupRef = "";
	
	public final static String LateralAxillaryGlands = "biomight.system.lymphatic.chest.deep.LateralAxillaryGlands";
	public final static String LateralAxillaryGlandsRef = "";
	
	public final static String PectoralAxillaryGlands = "biomight.system.lymphatic.chest.deep.PectoralAxillaryGlands";
	public final static String PectoralAxillaryGlandsRef = "";
	
	// biomight.system.lymphatic.chest.superficial
	public final static String DeltoideopectoralGlands = "biomight.system.lymphatic.chest.superficial.DeltoideopectoralGlands";
	public final static String DeltoideopectoralGlandsRef = "";
	
	public final static String SupratrochlearGlands = "biomight.system.lymphatic.chest.superficial.SupratrochlearGlands";
	public final static String SupratrochlearGlandsRef = "";
	
	// biomight.system.lymphatic.head
	public final static String AnteriorAuricularGlands = "biomight.system.lymphatic.head.AnteriorAuricularGlands";
	public final static String AnteriorAuricularGlandsRef = "";
	
	public final static String BuccinatorGlands = "biomight.system.lymphatic.head.BuccinatorGlands";
	public final static String BuccinatorGlandsRef = "";
	
	public final static String DeepFacialGlands = "biomight.system.lymphatic.head.DeepFacialGlands";
	public final static String DeepFacialGlandsRef = "";
	
	public final static String FacialGlands = "biomight.system.lymphatic.head.FacialGlands";
	public final static String FacialGlandsRef = "";
	
	public final static String InfraorbitalGlands = "biomight.system.lymphatic.head.InfraorbitalGlands";
	public final static String InfraorbitalGlandsRef = "";
	
	public final static String LingualGlands = "biomight.system.lymphatic.head.LingualGlands";
	public final static String LymphaticVesselsFace = "biomight.system.lymphatic.head.LymphaticVesselsFace";
	public final static String LymphaticVesselsMouth = "biomight.system.lymphatic.head.LymphaticVesselsMouth";
	public final static String LymphaticVesselsNasalCavity = "biomight.system.lymphatic.head.LymphaticVesselsNasalCavity";
	public final static String LymphaticVesselsPalatineTonsil = "biomight.system.lymphatic.head.LymphaticVesselsPalatineTonsil";
	public final static String LymphaticVesselsScalp = "biomight.system.lymphatic.head.LymphaticVesselsScalp";
	public final static String LymphaticVesselsToungeApical = "biomight.system.lymphatic.head.LymphaticVesselsToungeApical";
	public final static String LymphaticVesselsToungeBasal = "biomight.system.lymphatic.head.LymphaticVesselsToungeBasal";
	public final static String LymphaticVesselsToungeLateral = "biomight.system.lymphatic.head.LymphaticVesselsToungeLateral";
	public final static String LymphaticVesselsToungeMedian = "biomight.system.lymphatic.head.LymphaticVesselsToungeMedian";
	public final static String LyphaticVesselsAuriculaMeatusAnterior = "biomight.system.lymphatic.head.LyphaticVesselsAuriculaMeatusAnterior";
	public final static String LyphaticVesselsAuriculaMeatusInferior = "biomight.system.lymphatic.head.LyphaticVesselsAuriculaMeatusInferior";
	public final static String LyphaticVesselsAuriculaMeatusPosterior = "biomight.system.lymphatic.head.LyphaticVesselsAuriculaMeatusPosterior";
	public final static String OccipitalGlands = "biomight.system.lymphatic.head.OccipitalGlands";
	public final static String PalatineTonsil = "biomight.system.lymphatic.head.PalatineTonsil";
	
	public final static String ParotidGland = "biomight.system.lymphatic.head.ParotidGland";
	public final static String ParotidGlandRef = "ParotidGland";
	
	public final static String ParotidGlands = "biomight.system.lymphatic.head.ParotidGlands";
	public final static String ParotidGlandsRef = "ParotidGlands";
	
	public final static String PosteriorAuricularGlands = "biomight.system.lymphatic.head.PosteriorAuricularGlands";
	public final static String RetropharyngealGlands = "biomight.system.lymphatic.head.RetropharyngealGlands";
	
	public final static String SupraMandibularGlands = "biomight.system.lymphatic.head.SupraMandibularGlands";
	public final static String SupraMandibularGlandsRef = "SupraMandibularGlands";

	public final static String SupraMandibularGland = "biomight.system.lymphatic.head.SupraMandibularGland";
	public final static String SupraMandibularGlandRef = "SupraMandibularGland";
	
	
	// biomight.system.lymphatic.leg
	public final static String AnteriorTibialDeepLymphaticVessels = "biomight.system.lymphatic.leg.AnteriorTibialDeepLymphaticVessels";
	public final static String AnteriorTibialGland = "biomight.system.lymphatic.leg.AnteriorTibialGland";
	public final static String DeepSubInguinalGlands = "biomight.system.lymphatic.leg.DeepSubInguinalGlands";
	public final static String GlandOfCloquetRosenmüller = "biomight.system.lymphatic.leg.GlandOfCloquetRosenmüller";
	public final static String LateralSuperficialLymphaticVessels = "biomight.system.lymphatic.leg.LateralSuperficialLymphaticVessels";
	public final static String MedialSuperficialLymphaticVessels = "biomight.system.lymphatic.leg.MedialSuperficialLymphaticVessels";
	public final static String PeronealLymphaticVessels = "biomight.system.lymphatic.leg.PeronealLymphaticVessels";
	public final static String PoplitealGlands = "biomight.system.lymphatic.leg.PoplitealGlands";
	public final static String PosteriorTibialDeepLymphaticVessels = "biomight.system.lymphatic.leg.PosteriorTibialDeepLymphaticVessels";
	
	public final static String SubLinguinalGlands = "biomight.system.lymphatic.leg.SubLinguinalGlands";
	public final static String SubLinguinalGlandsRef = "SubLinguinalGlands";
	
	
	public final static String SuperficalInguinalGlands = "biomight.system.lymphatic.leg.SuperficalInguinalGlands";
	public final static String SuperficalSubInguinalGlands = "biomight.system.lymphatic.leg.SuperficalSubInguinalGlands";

	// biomight.system.lymphatic.lymphnode
	public final static String GerminalCenter = "biomight.system.lymphatic.lymphnode.GerminalCenter";
	public final static String Hilus = "biomight.system.lymphatic.lymphnode.Hilus";
	public final static String LymphaticNodules = "biomight.system.lymphatic.lymphnode.LymphaticNodules";
	public final static String LymphNode = "biomight.system.lymphatic.lymphnode.LymphNode";
	public final static String LymphNodes = "biomight.system.lymphatic.lymphnode.LymphNodes";
	public final static String MedullaryCord = "biomight.system.lymphatic.lymphnode.MedullaryCord";
	public final static String MedullarySinus = "biomight.system.lymphatic.lymphnode.MedullarySinus";
	public final static String Trabecula = "biomight.system.lymphatic.lymphnode.Trabecula";

	// biomight.system.lymphatic.neck
	public final static String SubMaxillaryGland = "biomight.system.lymphatic.neck.SubMaxillaryGland";
	public final static String SupraSternalNotch = "biomight.system.lymphatic.neck.SupraSternalNotch";
	
	// biomight.system.lymphatic.organ.smallIntestine
	public final static String ChyliferousVessel = "biomight.system.lymphatic.neck.ChyliferousVessel";
	public final static String ChyliferousVessels = "biomight.system.lymphatic.neck.ChyliferousVessels";
	
	// biomight.system.lymphatic.thorax
	public final static String DiaphragmaticGlandsAnterior = "biomight.system.lymphatic.thorax.DiaphragmaticGlandsAnterior";
	public final static String DiaphragmaticGlandsMiddle = "biomight.system.lymphatic.thorax.DiaphragmaticGlandsMiddle";
	public final static String DiaphragmaticGlandsPosterior = "biomight.system.lymphatic.thorax.DiaphragmaticGlandsPosterior";
	public final static String IntercostalGlands = "biomight.system.lymphatic.thorax.IntercostalGlands";
	public final static String SternalGlands = "biomight.system.lymphatic.thorax.SternalGlands";
	
	// biomight.system.lymphatic.thorax.deep
	public final static String AnteriorMediastinalGland = "biomight.system.lymphatic.thorax.deep.AnteriorMediastinalGland";
	public final static String BronchopulmonaryGlands = "biomight.system.lymphatic.thorax.deep.BronchopulmonaryGlands";
	public final static String MediastinalLymphNodes = "biomight.system.lymphatic.thorax.deep.MediastinalLymphNodes";
	public final static String PosteriorMediastinalGlands = "biomight.system.lymphatic.thorax.deep.PosteriorMediastinalGlands";
	public final static String PulmonaryGlands = "biomight.system.lymphatic.thorax.deep.PulmonaryGlands";
	public final static String TracheobronchialGlands = "biomight.system.lymphatic.thorax.deep.TracheobronchialGlands";


	/********************************************************************************
	 * 
	 * LIGAMENTS 
	 * 
	 ********************************************************************************/ 	

	// biomight.system.ligament
	public final static String Ligament = "biomight.system.ligament.Ligament";
	public final static String LigamentRef = "";
	
	public final static String Ligaments = "biomight.system.ligament.Ligaments";
	public final static String LigamentsRef = "";
	
	public final static String AnteriorSacrococcygealLigament = "biomight.system.ligament.AnteriorSacrococcygealLigament";
	public final static String AnteriorSacrococcygealLigamentRef = "";
	
	public final static String AnteriorSacroiliacLigament = "biomight.system.ligament.AnteriorSacroiliacLigament";
	public final static String AnteriorSacroiliacLigamentRef = "";
	
	public final static String GastrolienalLigament = "biomight.system.ligament.GastrolienalLigament";
	public final static String GastrolienalLigamentRef = "";
	
	public final static String IliolumbarLigament = "biomight.system.ligament.IliolumbarLigament";
	public final static String IliolumbarLigamentRef = "";
	
	public final static String InterosseousSacroiliacLigament = "biomight.system.ligament.InterosseousSacroiliacLigament";
	public final static String InterosseousSacroiliacLigamentRef = "";
	
	public final static String LateralSacrococcygealLigament = "biomight.system.ligament.LateralSacrococcygealLigament";
	public final static String LateralSacrococcygealLigamentRef = "";
	
	public final static String LigamentumPubicumInferius = "biomight.system.ligament.LigamentumPubicumInferius";
	public final static String LigamentumPubicumInferiusRef = "";
	
	public final static String PhrenicolienalLigament = "biomight.system.ligament.PhrenicolienalLigament";
	public final static String PhrenicolienalLigamentRef = "";
	
	public final static String PosteriorLongitudinalLigament = "biomight.system.ligament.PosteriorLongitudinalLigament";
	public final static String PosteriorLongitudinalLigamentRef = "";
	
	public final static String PosteriorSacrococcygealLigament = "biomight.system.ligament.PosteriorSacrococcygealLigament";
	public final static String PosteriorSacrococcygealLigamentRef = "";
	
	public final static String PosteriorSacroiliacLigament = "biomight.system.ligament.PosteriorSacroiliacLigament";
	public final static String PosteriorSacroiliacLigamentRef = "";
	
	public final static String RetinaculumMusculorumFlexorumPedis = "biomight.system.ligament.RetinaculumMusculorumFlexorumPedis";
	public final static String RetinaculumMusculorumFlexorumPedisRef = "";
	
	public final static String SacrospinousLigament = "biomight.system.ligament.SacrospinousLigament";
	public final static String SacrospinousLigamentRef = "";
	
	public final static String SacrotuberousLigament = "biomight.system.ligament.SacrotuberousLigament";
	public final static String SacrotuberousLigamentRef = "";
	
	// biomight.system.ligament.ankle
	public final static String AnteriorTalofibularLigament = "biomight.system.ligament.ankle.AnteriorTalofibularLigament";
	public final static String CalcaneofibularLigament = "biomight.system.ligament.ankle.CalcaneofibularLigament";
	public final static String DeltoidLigament = "biomight.system.ligament.ankle.DeltoidLigament";
	public final static String LongPlantarLigament = "biomight.system.ligament.ankle.LongPlantarLigament";
	public final static String PosteriorTalofibularLigament = "biomight.system.ligament.ankle.PosteriorTalofibularLigament";
	 
	// biomight.system.ligament.elbow
	public final static String AnteriorLigament = "biomight.system.ligament.elbow.AnteriorLigament";
	public final static String PosteriorLigament = "biomight.system.ligament.elbow.PosteriorLigament";
	public final static String RadialCollateralLigament = "biomight.system.ligament.elbow.RadialCollateralLigament";
	public final static String UlnarCollateralLigament = "biomight.system.ligament.elbow.UlnarCollateralLigament";

	// biomight.system.ligament.hand
	public final static String NatatoryLigament = "biomight.system.ligament.hand.NatatoryLigament";
	public final static String VolarCarpalLigament = "biomight.system.ligament.hand.VolarCarpalLigament";

	// biomight.system.ligament.hand.metacarpals
	public final static String DorsalLigaments = "biomight.system.ligament.hand.metacarpals.DorsalLigaments";
	public final static String InterosseousLigaments = "biomight.system.ligament.hand.metacarpals.InterosseousLigaments";
	public final static String VolarLigaments = "biomight.system.ligament.hand.metacarpals.VolarLigaments";
	
	// biomight.system.ligament.head.mouth
	public final static String PeriodontalLigament = "biomight.system.ligament.hand.metacarpals.PeriodontalLigament";
	
	// head.eye
	public final static String SuspensoryLigament = "biomight.system.ligament.hand.metacarpals.SuspensoryLigament";
	public final static String SuspensoryLigamentRef = "SuspensoryLigament";
	
	
	// biomight.system.ligament.hip
	public final static String ArticularCapsuleLigament = "biomight.system.ligament.hip.ArticularCapsuleLigament";
	public final static String ArticularCapsuleLigamentRef = "";
	
	public final static String GlenoidalLabrumLigament = "biomight.system.ligament.hip.GlenoidalLabrumLigament";
	public final static String GlenoidalLabrumLigamentRef = "";
	
	public final static String IlioFemoralLigament = "biomight.system.ligament.hip.IlioFemoralLigament";
	public final static String IlioFemoralLigamentRef = "";
	
	public final static String IschioCapsularLigament = "biomight.system.ligament.hip.IschioCapsularLigament";
	public final static String IschioCapsularLigamentRef = "";
	
	public final static String IschiofemoralLigament = "biomight.system.ligament.hip.IschiofemoralLigament";
	public final static String IschiofemoralLigamentRef = "";
	
	public final static String LigamentOfBigelow = "biomight.system.ligament.hip.LigamentOfBigelow";
	public final static String LigamentOfBigelowRef = "";
	
	public final static String LigamentumTeresFemoris = "biomight.system.ligament.hip.LigamentumTeresFemoris";
	public final static String LigamentumTeresFemorisRef = "";
	
	public final static String PubocapsularLigament = "biomight.system.ligament.hip.PubocapsularLigament";
	public final static String PubocapsularLigamentRef = "";
	
	public final static String PubofemoralLigament = "biomight.system.ligament.hip.PubofemoralLigament";
	public final static String PubofemoralLigamentRef = "";
	
	public final static String TransverseAcetabularLigament = "biomight.system.ligament.hip.TransverseAcetabularLigament";
	public final static String TransverseAcetabularLigamentRef = "";
	
	// biomight.system.ligament.intertarsal
	public final static String AnteriorTalocalcanealLigament = "biomight.system.ligament.intertarsal.AnteriorTalocalcanealLigament";
	public final static String AnteriorTalocalcanealLigamentRef = "";
	
	public final static String BifurcatedLigament = "biomight.system.ligament.intertarsal.BifurcatedLigament";
	public final static String BifurcatedLigamentRef = "";
	
	public final static String DorsalCalcaneocuboidLigament = "biomight.system.ligament.intertarsal.DorsalCalcaneocuboidLigament";
	public final static String DorsalTalonavicularLigament = "biomight.system.ligament.intertarsal.DorsalTalonavicularLigament";
	public final static String InterosseousTalocalcanealLigament = "biomight.system.ligament.intertarsal.InterosseousTalocalcanealLigament";
	public final static String LateralTalocalcanealLigament = "biomight.system.ligament.intertarsal.LateralTalocalcanealLigament";
	//public final static String LongPlantarLigament = "biomight.system.ligament.intertarsal.LongPlantarLigament";
	public final static String MedialTalocalcanealLigament = "biomight.system.ligament.intertarsal.MedialTalocalcanealLigament";
	public final static String PlantarCalcaneocuboidLigament = "biomight.system.ligament.intertarsal.PlantarCalcaneocuboidLigament";
	public final static String PlantarCalcaneonavicularLigament = "biomight.system.ligament.intertarsal.PlantarCalcaneonavicularLigament";
	public final static String PosteriorTalocalcanealLigament = "biomight.system.ligament.intertarsal.PosteriorTalocalcanealLigament";
	public final static String TalocalcanealArticulation = "biomight.system.ligament.intertarsal.TalocalcanealArticulation";

	
	// biomight.system.ligament.knee
	public final static String AnteriorCruciateLigament = "biomight.system.ligament.knee.AnteriorCruciateLigament";
	public final static String AnteriorCruciateLigamentRef = "";
	
	public final static String ArticularCartilage = "biomight.system.ligament.knee.ArticularCartilage";
	public final static String ArticularCartilageRef = "";
	
	public final static String Bursae = "biomight.system.ligament.knee.Bursae";
	public final static String BursaeRef = "";
	
	public final static String PrePatellarBursa = "biomight.system.ligament.knee.PrePatellarBursa";
	public final static String PrePatellarBursaRef = "";
	
	public final static String SupraPatellarBursa = "biomight.system.ligament.knee.SupraPatellarBursa";
	public final static String SupraPatellarBursaRef = "";
	
	//public final static String CoronaryLigament = "biomight.system.ligament.knee.CoronaryLigament";
	public final static String FibularCollateralLigament = "biomight.system.ligament.knee.FibularCollateralLigament";
	public final static String FibularCollateralLigamentRef = "";
	
	//public final static String Knee = "biomight.system.ligament.knee.Knee";
	public final static String KneeSynovium = "biomight.system.ligament.knee.KneeSynovium";
	public final static String KneeSynoviumRef = "";
	
	public final static String LateralCollateralLigament = "biomight.system.ligament.knee.LateralCollateralLigament";
	public final static String LateralCollateralLigamentRef = "";
	
	public final static String LateralMenisci = "biomight.system.ligament.knee.LateralMenisci";
	public final static String LateralMenisciRef = "";
	
	public final static String LateralMeniscus = "biomight.system.ligament.knee.LateralMeniscus";
	public final static String LateralMeniscusRef = "";
	
	public final static String LigamentOfWrisberg = "biomight.system.ligament.knee.LigamentOfWrisberg";
	public final static String LigamentOfWrisbergRef = "";
	
	public final static String LigamentumPatellae = "biomight.system.ligament.knee.LigamentumPatellae";
	public final static String LigamentumPatellaeRef = "";
	
	public final static String MedialCollateralLigament = "biomight.system.ligament.knee.MedialCollateralLigament";
	public final static String MedialCollateralLigamentRef = "";
	
	public final static String MedialMeniscus = "biomight.system.ligament.knee.MedialMeniscus";
	public final static String MedialMeniscusRef = "";
	
	public final static String ObliquePoplitealLigament = "biomight.system.ligament.knee.ObliquePoplitealLigament";
	public final static String ObliquePoplitealLigamentRef = "";
	
	public final static String PosteriorCruciateLigament = "biomight.system.ligament.knee.PosteriorCruciateLigament";
	public final static String PosteriorCruciateLigamentRef = "";
	
	public final static String ShortFibularCollateralLigament = "biomight.system.ligament.knee.ShortFibularCollateralLigament";
	public final static String ShortFibularCollateralLigamentRef = "";
	
	public final static String SynovialMembrane = "biomight.system.ligament.knee.SynovialMembrane";
	public final static String SynovialMembraneRef = "";
	
	public final static String TibialCollateralLigament = "biomight.system.ligament.knee.TibialCollateralLigament";
	public final static String TibialCollateralLigamentRef = "";
	
	// biomight.system.ligament.mandible
	//public final static String ArticularCapsuleLigament = "biomight.system.ligament.mandible.ArticularCapsuleLigament";
	
	public final static String MandibleArticularDisk = "biomight.system.ligament.mandible.ArticularDisk";
	public final static String MandibleArticularDiskRef = "";
	
	public final static String SphenomandibularLigament = "biomight.system.ligament.mandible.SphenomandibularLigament";
	public final static String SphenomandibularLigamentRef = "";
	
	public final static String StylomandibularLigament = "biomight.system.ligament.mandible.StylomandibularLigament";
	public final static String StylomandibularLigamentRef = "TemporomandibularLigament";
	
	public final static String TemporomandibularLigament = "biomight.system.ligament.mandible.TemporomandibularLigament";
	public final static String TemporomandibularLigamentRef = "TemporomandibularLigament";
	
	// biomight.system.ligament.neck
	public final static String CricoThyroidLigament = "biomight.system.ligament.neck.CricoThyroidLigament";
	public final static String CricoThyroidLigamentRef = "VocalLigament";
	
	public final static String VocalLigament = "biomight.system.ligament.neck.VocalLigament";
	public final static String VocalLigamentRef = "VocalLigament";
	
	public final static String VocalLigaments = "biomight.system.ligament.neck.VocalLigaments";
	public final static String VocalLigamentsRef = "VocalLigaments";
	
	// biomight.system.ligament.radius
	public final static String AnnularLigament = "biomight.system.ligament.raduis.AnnularLigament";
	public final static String AnnularLigamentRef = "AnnularLigament";
	
	public final static String RadiusArticularDisk = "biomight.system.ligament.raduis.RadiusArticularDisk";
	public final static String RadiusArticularDiskRef = "RadiusArticularDisk";
	
	public final static String DorsalRadioulnarLigament = "biomight.system.ligament.raduis.DorsalRadioulnarLigament";
	public final static String DorsalRadioulnarLigamentRef = "DorsalRadioulnarLigament";
	
	public final static String VolarRadioulnarLigament = "biomight.system.ligament.raduis.VolarRadioulnarLigament";
	public final static String VolarRadioulnarLigamentRef = "VolarRadioulnarLigament";
	
	// biomight.system.ligament.ribs
	public final static String CapsularLigament = "biomight.system.ligament.ribs.CapsularLigament";
	public final static String CapsularLigamentRef = "CapsularLigament";
	
	public final static String InterarticularLigament = "biomight.system.ligament.ribs.InterarticularLigament";
	public final static String InterarticularLigamentRef = "CapsularLigament";
	
	public final static String RadiateLigament = "biomight.system.ligament.ribs.RadiateLigament";
	public final static String RadiateLigamentRef = "RadiateLigament";

	// biomight.system.ligament.shoulder
	public final static String ShoulderArticularCapsuleLigament = "biomight.system.ligament.shoulder.ShoulderArticularCapsuleLigament";
	public final static String ShoulderArticularCapsuleLigamentRef = "";
	
	public final static String CoracohumeralLigament = "biomight.system.ligament.shoulder.CoracohumeralLigament";
	public final static String CoracohumeralLigamentRef = "CoracohumeralLigament";
	
	public final static String GlenohumeralLigament = "biomight.system.ligament.shoulder.GlenohumeralLigament";
	public final static String GlenohumeralLigamentRef = "GlenohumeralLigament";
	
	//public final static String GlenoidalLabrumLigament = "biomight.system.ligament.shoulder.GlenoidalLabrumLigament";
	public final static String TransverseHumeralLigament = "biomight.system.ligament.shoulder.TransverseHumeralLigament";
	public final static String TransverseHumeralLigamentRef = "TransverseHumeralLigament";
	
	// biomight.system.ligament.spinal
	public final static String AlarLigament = "biomight.system.ligament.spinal.AlarLigament";
	public final static String AlarLigamentRef = "AlarLigament";
	
	public final static String AnteriorAtlantoaxialLigament = "biomight.system.ligament.spinal.AnteriorAtlantoaxialLigament";
	public final static String AnteriorAtlantoaxialLigamentRef = "AnteriorAtlantoaxialLigament";
	
	public final static String AnteriorLongitudinalLigament = "biomight.system.ligament.spinal.AnteriorLongitudinalLigament";
	public final static String AnteriorLongitudinalLigamentRef = "AnteriorLongitudinalLigament";
	
	public final static String InterspinousLigament = "biomight.system.ligament.spinal.InterspinousLigament";
	public final static String InterspinousLigamentRef = "InterspinousLigament";
	
	public final static String IntertransverseLigament = "biomight.system.ligament.spinal.IntertransverseLigament";
	public final static String IntertransverseLigamentRef = "IntertransverseLigament";
	
	public final static String LigamentumCoracohumerale = "biomight.system.ligament.spinal.LigamentumCoracohumerale";
	public final static String LigamentumCoracohumeraleRef = "IntertransverseLigament";
	
	public final static String LigamentumFlavumLigament = "biomight.system.ligament.spinal.LigamentumFlavumLigament";
	public final static String LigamentumFlavumLigamentRef = "IntertransverseLigament";
	
	public final static String LigamentumNuchaeLigament = "biomight.system.ligament.spinal.LigamentumNuchaeLigament";
	public final static String LigamentumNuchaeLigamentRef = "IntertransverseLigament";
	
	public final static String LliolumbarLigament = "biomight.system.ligament.spinal.LliolumbarLigament";
	public final static String LliolumbarLigamentRef = "LliolumbarLigament";
	
	public final static String PosteriorAtlantoaxialLigament = "biomight.system.ligament.spinal.PosteriorAtlantoaxialLigament";
	public final static String PosteriorAtlantoaxialLigamentRef = "PosteriorAtlantoaxialLigament";
	
	//public final static String PosteriorLongitudinalLigament = "biomight.system.ligament.spinal.PosteriorLongitudinalLigament";
	
	public final static String SacroiliacLigament = "biomight.system.ligament.spinal.SacroiliacLigament";
	public final static String SacroiliacLigamentRef = "SacroiliacLigament";
	
	//public final static String SacrospinousLigament = "biomight.system.ligament.spinal.SacrospinousLigament";
	//public final static String SacrotuberousLigament = "biomight.system.ligament.spinal.SacrotuberousLigament";
	public final static String SupraspinousLigament = "biomight.system.ligament.spinal.SupraspinousLigament";
	public final static String SupraspinousLigamentRef = "SupraspinousLigament";
	
	// biomight.system.ligament.sternum
	public final static String CostoxiphoidLigament = "biomight.system.ligament.sternum.CostoxiphoidLigament";
	public final static String CostoxiphoidLigamentRef = "CostoxiphoidLigament";
	
	public final static String InterarticularSternocostalLigament = "biomight.system.ligament.sternum.InterarticularSternocostalLigament";
	public final static String InterarticularSternocostalLigamentRef = "SupraspinousLigament";
	
	public final static String RadiateSternocostalLigament = "biomight.system.ligament.sternum.RadiateSternocostalLigament";
	public final static String RadiateSternocostalLigamentRef = "RadiateSternocostalLigament";
	
	// biomight.system.ligament.tibiafibula
	
	//public final static String AnteriorLigament = "biomight.system.ligament.tibiafibula.AnteriorLigament";
	//public final static String ArticularCapsuleLigament = "biomight.system.ligament.tibiafibula.ArticularCapsuleLigament";
	
	public final static String InferiorTransverseLigament = "biomight.system.ligament.tibiafibula.InferiorTransverseLigament";
	
	public final static String InterosseousLigament = "biomight.system.ligament.tibiafibula.InterosseousLigament";
	
	//public final static String PosteriorLigament = "biomight.system.ligament.tibiafibula.PosteriorLigament";

	// biomight.system.ligament.vertebral
	//public final static String AnteriorAtlantoaxialLigament = "biomight.system.ligament.vertebral.AnteriorAtlantoaxialLigament";
	//public final static String AnteriorLongitudinalLigament = "biomight.system.ligament.vertebral.AnteriorLongitudinalLigament";
	public final static String InterspinalLigaments = "biomight.system.ligament.vertebral.InterspinalLigaments";
	public final static String IntertransverseLigaments = "biomight.system.ligament.vertebral.IntertransverseLigaments";
	public final static String LigamentaFlava = "biomight.system.ligament.vertebral.LigamentaFlava";
	public final static String MedialMenisci = "biomight.system.ligament.vertebral.MedialMenisci";
	public final static String NuchaeLigament = "biomight.system.ligament.vertebral.NuchaeLigament";
	public final static String PosteriorAtlantoAxialLigament = "biomight.system.ligament.vertebral.PosteriorAtlantoAxialLigament";
	//public final static String PosteriorLongitudinalLigament = "biomight.system.ligament.vertebral.PosteriorLongitudinalLigament";
	public final static String SupraspinalLigament = "biomight.system.ligament.vertebral.SupraspinalLigament";
	public final static String TransverseOfAtlasLigament = "biomight.system.ligament.vertebral.TransverseOfAtlasLigament";
	
	

	/********************************************************************************
	 * 
	 * MYOLOGY 
	 * 
	 ********************************************************************************/
	 
	// biomight.system.myology.aponeuroses
	public final static String Aponeuroses = "biomight.system.myology.aponeuroses.Aponeuroses";
	public final static String GaleaAponeurosis = "biomight.system.myology.aponeuroses.head.GaleaAponeurosis";

	// biomight.system.myology.fasciae
	public final static String DeepFascia = "biomight.system.myology.fasciae.DeepFascia";
	public final static String Fascia = "biomight.system.myology.fasciae.Fascia";
	public final static String PreVertebralFascia = "biomight.system.myology.fasciae.PreVertebralFascia";
	//public final static String SuperficialFascia = "biomight.system.myology.fasciae.SuperficialFascia";


	/********************************************************************************
	 * 
	 * SKELTAL SYSTEM 
	 * 
	 ********************************************************************************/ 
	public final static String BonesTitle = "Bones";	
	public final static String SkeletalSystem = "biomight.system.SkeletalSystem";
	public final static String SkeletalSystemRef = "SkeletalSystem";

	// biomight.body.spine
	public final static String Spine = "biomight.body.spine.Spine";	
	
	public final static String Vertebrae = "biomight.body.spine.Vertebrae.java";	
	public final static String VertebraeRef = "Vertebrae";
	
	public final static String SpineLumbarRegion = "biomight.body.spine.SpineLumbarRegion";	
	public final static String SpinePelvicRegion = "biomight.body.spine.SpinePelvicRegion";	
	public final static String SpineThoracicRegion = "biomight.body.spine.SpineThoracicRegion";	
	public final static String SpinousProcess = "biomight.body.spine.SpinousProcess";	
	
	public final static String CervicalVertebrae = "biomight.system.skeletal.spine.CervicalVertebrae";
	public final static String CervicalVertebraeRef = "CervicalVertebrae";
	
	public final static String CervicalVertebra = "biomight.system.skeletal.spine.CervicalVertebra";
	public final static String CervicalVertebraRef = "CervicalVertebra";

	public final static String ThoracicVertebrae = "biomight.system.skeletal.spine.ThoracicVertebrae";
	public final static String ThoracicVertebraeRef = "ThoracicVertebrae";
	
	public final static String ThoracicVertebra = "biomight.system.skeletal.spine.ThoracicVertebra";
	public final static String ThoracicVertebraRef = "ThoracicVertebra";

	public final static String LumbarVertebrae = "biomight.system.skeletal.spine.LumbarVertebrae";
	public final static String LumbarVertebraeRef = "LumbarVertebrae";
	
	public final static String LumbarVertebra = "biomight.system.skeletal.spine.LumbarVertebra";
	public final static String LumbarVertebraRef = "LumbarVertebra";

	public final static String Sacrum = "biomight.system.skeletal.spine.Sacrum";
	public final static String SacrumRef = "Sacrum";
	
	public final static String SacralVertebrae = "biomight.system.skeletal.spine.SacralVertebrae";
	public final static String SacralVertebraeRef = "SacralVertebrae";
	
	public final static String SacralVertebra = "biomight.system.skeletal.spine.SacralVertebra";
	public final static String SacralVertebraRef = "SacralVertebra";

	public final static String CoccygealVertebrae = "biomight.system.skeletal.spine.CoccygealVertebrae";
	public final static String CoccygealVertebraeRef = "CoccygealVertebrae";
	
	public final static String CoccygealVertebra = "biomight.system.skeletal.spine.CoccygealVertebra";
	public final static String CoccygealVertebraRef = "CoccygealVertebra";
	
	public final static String NucleusPulposus = "biomight.system.nervous.spinalchord.NucleusPulposus";
	
	public final static String DiscAnnulus = "biomight.system.skeletal.spine.DiscAnnulus";
	
	public final static String SuperiorArticularProcess = "biomight.system.nervous.spinalchord.SuperiorArticularProcess";
	
	public final static String ForamenTransversium = "biomight.systm.nervous.spinalchord.ForamenTransversium";
	
	public final static String CostaFovea = "biomight.system.nervous.spinalchord.CostaFovea";
	public final static String CostaFoveaRef = "";
	
	public final static String Coccyx = "biomight.system.skeletal.spine.Coccyx";	
	public final static String CoccyxRef = "";
	
	// biomight.system.skeletal.arm
	public final static String Humeri = "biomight.system.skeletal.arm.Humeri";
	public final static String HumeriRef = "Humeri";
	
	public final static String Humerus = "biomight.system.skeletal.arm.Humerus";
	public final static String HumerusRef = "Humerus";

	public final static String Radii = "biomight.system.skeletal.arm.Radii";
	public final static String RadiiRef = "Radii";

	public final static String Radius = "biomight.system.skeletal.arm.Radius";
	public final static String RadiusRef = "Radius";

	
	public final static String Ulnae = "biomight.system.skeletal.arm.Ulnae";
	public final static String UlnaeRef = "Ulnae";
	
	public final static String Ulna = "biomight.system.skeletal.arm.Ulna";
	public final static String UlnaRef = "Ulna";	
	
	// biomight.system.skeletal.chest
	public final static String Clavicle = "biomight.system.skeletal.chest.Clavicle";
	public final static String ClavicleRef = "";
	
	public final static String Scapula = "biomight.system.skeletal.chest.Scapula";
	public final static String ScapulaRef = "";
	
	public final static String Sternum = "biomight.system.skeletal.chest.Sternum";
	public final static String SternumRef = "Sternum";
	
	public final static String XiphoidProcess = "biomight.system.skeletal.chest.XiphoidProcess";
	public final static String XiphoidProcessRef = "XiphoidProcess";

	
	//***********************************
	// FOOT
	// biomight.system.skeletal.foot
	//**********************************
	public final static String CalcaneusBone = "biomight.system.skeletal.foot.CalcaneusBone";
	public final static String CalcaneusBoneRef = "CalcaneusBone";
	
	public final static String CuboidBone = "biomight.system.skeletal.foot.CuboidBone";
	public final static String CuboidBoneRef = "CuboidBone";
	
	
	public final static String LateralCuneiformBone = "biomight.system.skeletal.foot.LateralCuneiformBone";
	public final static String LateralCuneiformBoneRef = "";
	
	public final static String NavicularCuneiforms = "biomight.system.skeletal.foot.NavicularCuneiforms";
	public final static String NavicularCuneiformsRef = "";
		
	public final static String MetaTarsalsBone = "biomight.system.skeletal.foot.MetaTarsalsBone";
	public final static String MetaTarsalsBoneRef = "";

	public final static String FootProximalPhalanges = "biomight.system.skeletal.hand.FootProximalPhalanges";
	public final static String FootProximalPhalangesRef = "FootProximalPhalanges";

	public final static String FootProximalPhalange = "biomight.system.skeletal.hand.FootProximalPhalange";
	public final static String FootProximalPhalangeRef = "FootProximalPhalange";

	public final static String FootMiddlePhalanges = "biomight.system.skeletal.hand.FootMiddlePhalanges";
	public final static String FootMiddlePhalangesRef = "FootMiddlePhalanges";

	public final static String FootMiddlePhalange = "biomight.system.skeletal.hand.FootMiddlePhalange";
	public final static String FootMiddlePhalangeRef = "FootMiddlePhalange";

	public final static String FootDistalPhalanges = "biomight.system.skeletal.hand.FootDistalPhalanges";
	public final static String FootDistalPhalangesRef = "FootDistalPhalanges";

	public final static String FootDistalPhalange = "biomight.system.skeletal.hand.FootDistalPhalange";
	public final static String FootDistalPhalangeRef = "FootDistalPhalange";
	
	public final static String TalusBone = "biomight.system.skeletal.foot.TalusBone";
	public final static String TalusBoneRef = "";
	
	public final static String Tarsals = "biomight.system.skeletal.foot.Tarsals";
	public final static String TarsalsRef = "Tarsals";
	
	public final static String Tarsal = "biomight.system.skeletal.foot.Tarsal";
	public final static String TarsalRef = "Tarsal";

	//***********************************
	// HAND
	// biomight.system.skeletal.hand
	//***********************************
	public final static String MetaCarpals = "biomight.system.skeletal.hand.MetaCarpals";
	public final static String MetaCarpalsRef = "MetaCarpals";
	
	public final static String MetaCarpal = "biomight.system.skeletal.hand.MetaCarpal";
	public final static String MetaCarpalRef = "MetaCarpal";
	
	public final static String HandProximalPhalanges = "biomight.system.skeletal.hand.HandProximalPhalanges";
	public final static String HandProximalPhalangesRef = "HandProximalPhalanges";

	public final static String HandProximalPhalange = "biomight.system.skeletal.hand.HandProximalPhalange";
	public final static String HandProximalPhalangeRef = "HandProximalPhalange";

	public final static String HandMiddlePhalanges = "biomight.system.skeletal.hand.HandMiddlePhalanges";
	public final static String HandMiddlePhalangesRef = "HandMiddlePhalanges";

	public final static String HandMiddlePhalange = "biomight.system.skeletal.hand.HandMiddlePhalange";
	public final static String HandMiddlePhalangeRef = "HandMiddlePhalange";

	public final static String HandDistalPhalanges = "biomight.system.skeletal.hand.HandDistalPhalanges";
	public final static String HandDistalPhalangesRef = "HandDistalPhalanges";

	public final static String HandDistalPhalange = "biomight.system.skeletal.hand.HandDistalPhalange";
	public final static String HandDistalPhalangeRef = "HandDistalPhalange";

	public final static String MiddlePhalanx = "biomight.system.skeletal.hand.MiddlePhalanx";
	public final static String MiddlePhalanxRef = "";
	
	public final static String CapitateBone = "biomight.system.skeletal.hand.CapitateBone";
	public final static String CapitateBoneRef = "";
	
	public final static String Carpals = "biomight.system.skeletal.hand.Carpals";
	public final static String CarpalsRef = "Carpals";
	
	public final static String Carpal = "biomight.system.skeletal.hand.Carpal";
	public final static String CarpalRef = "Carpal";
	
	public final static String DipJoint = "biomight.system.skeletal.hand.DipJoint";
	public final static String DipJointRef = "";
	
	public final static String DistalPhalanx = "biomight.system.skeletal.hand.DistalPhalanx";
	public final static String DistalPhalanxRef = "";
	
	public final static String HamateCapitateBone = "biomight.system.skeletal.hand.HamateCapitateBone";
	public final static String HamateCapitateBoneRef = "";
	
	public final static String LunateBone = "biomight.system.skeletal.hand.LunateBone";
	public final static String LunateBoneRef = "";
	
	public final static String PipJoint = "biomight.system.skeletal.hand.PipJoint";
	public final static String PipJointRef = "";
	
	public final static String PisiformTriquetrumBone = "biomight.system.skeletal.hand.PisiformTriquetrumBone";
	public final static String PisiformTriquetrumBoneRef = "";
	
	public final static String ProximalPhalanx = "biomight.system.skeletal.hand.ProximalPhalanx";
	public final static String ProximalPhalanxRef = "";
	
	public final static String RadialStyloidProcess = "biomight.system.skeletal.hand.RadialStyloidProcess";
	public final static String RadialStyloidProcessRef = "";
	
	public final static String ScaphoidBone = "biomight.system.skeletal.hand.ScaphoidBone";
	public final static String ScaphoidBoneRef = "";
	
	public final static String TrapeziumBone = "biomight.system.skeletal.hand.TrapeziumBone";
	public final static String TrapeziumBoneRef = "";
	
	public final static String TriquetralBone = "biomight.system.skeletal.hand.TriquetralBone";
	public final static String TriquetralBoneRef = "";
	
	public final static String UlnarStyloidProcess = "biomight.system.skeletal.hand.UlnarStyloidProcess";
	public final static String UlnarStyloidProcessRef = "";
	
	public final static String FoveaCapiti = "biomight.system.skeletal.leg.femur.FoveaCapiti";
	public final static String FoveaCapitiRef = "FoveaCapiti";
	
	public final static String FoveaCapitis = "biomight.system.skeletal.leg.femur.FoveaCapitis";
	public final static String FoveaCapitisRef = "FoveaCapitis";

	public final static String GreaterTrochanters = "biomight.system.skeletal.leg.femur.GreaterTrochanters";
	public final static String GreaterTrochantersRef = "GreaterTrochanter";

	public final static String GreaterTrochanter = "biomight.system.skeletal.leg.femur.GreaterTrochanter";
	public final static String GreaterTrochanterRef = "GreaterTrochanter";
	
	public final static String LesserTrochanters = "biomight.system.skeletal.leg.femur.LesserTrochanters";
	public final static String LesserTrochantersRef = "LesserTrochanters";
	
	public final static String LesserTrochanter = "biomight.system.skeletal.leg.femur.LesserTrochanter";
	public final static String LesserTrochanterRef = "LesserTrochanter";
	
	public final static String PiriFormis = "biomight.system.skeletal.leg.femur.PiriFormis";
	public final static String PiriFormisRef = "PiriFormis";

	public final static String TrochanterHeads = "biomight.system.skeletal.leg.femur.TrochanterHeads";
	public final static String TrochanterHeadsRef = "TrochanterHeads";

	public final static String TrochanterHead = "biomight.system.skeletal.leg.femur.TrochanterHead";
	public final static String TrochanterHeadRef = "TrochanterHead";
	
	public final static String TrochantericFossa = "biomight.system.skeletal.leg.femur.TrochantericFossa";
	public final static String TrochantericFossaRef = "";
	
	public final static String TrochanterLateralSurface = "biomight.system.skeletal.leg.femur.TrochanterLateralSurface";
	public final static String TrochanterLateralSurfaceRef = "";
	
	public final static String TrochanterMedialSurface = "biomight.system.skeletal.leg.femur.TrochanterMedialSurface";
	public final static String TrochanterMedialSurfaceRef = "";

	public final static String TrochanterNecks = "biomight.system.skeletal.leg.femur.TrochanterNecks";
	public final static String TrochanterNecksRef = "TrochanterNecks";

	public final static String TrochanterNeck = "biomight.system.skeletal.leg.femur.TrochanterNeck";
	public final static String TrochanterNeckRef = "TrochanterNeck";

	// biomight.system.skeletal.pelvis
	public final static String Iliums = "biomight.system.skeletal.pelvis.Iliums";
	public final static String IliumsRef = "Iliums";
	
	public final static String Ilium = "biomight.system.skeletal.pelvis.Ilium";
	public final static String IliumRef = "Ilium";
	
	public final static String Ischium = "biomight.system.skeletal.pelvis.Ischium";
	public final static String IschiumRef = "Ischium";
	
	public final static String Pelvis = "biomight.system.skeletal.pelvis.Pelvis";
	public final static String PelvisRef = "Pelvis";
	
	public final static String Pubis = "biomight.system.skeletal.pelvis.Pubis";
	public final static String PubisRef = "Pubis";
	
	public final static String SacrumBone = "biomight.system.skeletal.pelvis.SacrumBone";
	public final static String SacrumBoneRef = "SacrumBone";
	
	public final static String SymphysisPubis = "biomight.system.skeletal.pelvis.SymphysisPubis";
	public final static String SymphysisPubisRef = "SymphysisPubis";
	
	// biomight.system.skeletal.ribs
	public final static String FalseRibs = "biomight.system.skeletal.ribs.FalseRibs";
	public final static String FalseRibsRef = "FalseRibs";
	
	public final static String FloatingRibs = "biomight.system.skeletal.ribs.FloatingRibs";
	public final static String FloatingRibsRef = "FloatingRibs";
	
	public final static String LeftRib = "biomight.system.skeletal.ribs.LeftRib";
	
	public final static String LeftRib1 = "biomight.system.skeletal.ribs.LeftRib1";
	
	public final static String LeftRib10 = "biomight.system.skeletal.ribs.LeftRib10";
	
	public final static String LeftRib11 = "biomight.system.skeletal.ribs.LeftRib11";
	public final static String LeftRib12 = "biomight.system.skeletal.ribs.LeftRib12";
	public final static String LeftRib2 = "biomight.system.skeletal.ribs.LeftRib2";
	public final static String LeftRib3 = "biomight.system.skeletal.ribs.LeftRib3";
	public final static String LeftRib4 = "biomight.system.skeletal.ribs.LeftRib4";
	public final static String LeftRib5 = "biomight.system.skeletal.ribs.LeftRib5";
	public final static String LeftRib6 = "biomight.system.skeletal.ribs.LeftRib6";
	public final static String LeftRib7 = "biomight.system.skeletal.ribs.LeftRib7";
	public final static String LeftRib8 = "biomight.system.skeletal.ribs.LeftRib8";
	public final static String LeftRib9 = "biomight.system.skeletal.ribs.LeftRib9";
	
	public final static String Rib = "biomight.system.skeletal.ribs.Rib";
	public final static String RibRef = "Rib";
	public final static String Ribs = "biomight.system.skeletal.ribs.Ribs";
	public final static String RibsRef = "Ribs";
	
	public final static String RibCage = "biomight.system.skeletal.ribs.RibCage";
	public final static String RibCageRef = "RibCage";
	
	public final static String RightRib = "biomight.system.skeletal.ribs.RightRib";
	public final static String RightRib1 = "biomight.system.skeletal.ribs.RightRib1";
	public final static String RightRib10 = "biomight.system.skeletal.ribs.RightRib10";
	public final static String RightRib11 = "biomight.system.skeletal.ribs.RightRib11";
	public final static String RightRib12 = "biomight.system.skeletal.ribs.RightRib12";
	public final static String RightRib2 = "biomight.system.skeletal.ribs.RightRib2";
	public final static String RightRib3 = "biomight.system.skeletal.ribs.RightRib3";
	public final static String RightRib4 = "biomight.system.skeletal.ribs.RightRib4";
	public final static String RightRib5 = "biomight.system.skeletal.ribs.RightRib5";
	public final static String RightRib6 = "biomight.system.skeletal.ribs.RightRib6";
	public final static String RightRib7 = "biomight.system.skeletal.ribs.RightRib7";
	public final static String RightRib8 = "biomight.system.skeletal.ribs.RightRib8";
	public final static String RightRib9 = "biomight.system.skeletal.ribs.RightRib9";
	
	public final static String TrueRibs = "biomight.system.skeletal.ribs.TrueRibs";
	public final static String TrueRibsRef = "TrueRibs";
	
	// biomight.system.skeletal.skull
	public final static String Skull = "biomight.system.skeletal.skull.Skull";	
	public final static String SkullRef = "Skull";
	
	// biomight.system.skeletal.skull.cranial
	public final static String CranialBones = "biomight.system.skeletal.skull.cranial.CranialBones";
	public final static String CranialBonesRef = "CranialBones";
	
	public final static String EthmoidBone = "biomight.system.skeletal.skull.cranial.EthmoidBone";
	public final static String EthmoidBoneRef = "EthmoidBone";
	
	public final static String FrontalBone = "biomight.system.skeletal.skull.cranial.FrontalBone";
	public final static String FrontalBoneRef = "FrontalBone";
	
	public final static String OccipitalBone = "biomight.system.skeletal.skull.cranial.OccipitalBone";	
	public final static String OccipitalBoneRef = "OccipitalBone";
	
	public final static String ParietalBone = "biomight.system.skeletal.skull.cranial.ParietalBone";
	public final static String ParietalBoneRef = "ParietalBone";

	public final static String ParietalBones = "biomight.system.skeletal.skull.cranial.ParietalBones";
	public final static String ParietalBonesRef = "ParietalBones";

	public final static String LeftParietalBone = "biomight.system.skeletal.skull.cranial.LeftParietalBone";
	public final static String LeftParietalBoneRef = "LeftParietalBone";
	
	public final static String RightParietalBone = "biomight.system.skeletal.skull.cranial.RightParietalBone";
	public final static String RightParietalBoneRef = "LeftParietalBone";
	
	public final static String SphenoidBone = "biomight.system.skeletal.skull.cranial.SphenoidBone";
	public final static String SphenoidBoneRef = "SphenoidBone";
	
	public final static String TemporalBone = "biomight.system.skeletal.skull.cranial.TemporalBone";
	public final static String TemporalBoneRef = "TemporalBone";

	public final static String TemporalBones = "biomight.system.skeletal.skull.cranial.TemporalBones";
	public final static String TemporalBonesRef = "TemporalBones";

	
	// biomight.system.skeletal.skull.facial
	public final static String FacialBones = "biomight.system.skeletal.skull.facial.FacialBones";
	public final static String FacialBonesRef = "FacialBones";
	
	public final static String HyoidBone = "biomight.system.skeletal.skull.facial.HyoidBone";
	public final static String HyoidBoneRef = "HyoidBone";
	
	public final static String InferiorNasalConchaBone = "biomight.system.skeletal.skull.facial.InferiorNasalConchaBone";
	public final static String InferiorNasalConchaBoneRef = "InferiorNasalConchaBone";

	public final static String InferiorNasalConchaBones = "biomight.system.skeletal.skull.facial.InferiorNasalConchaBones";
	public final static String InferiorNasalConchaBonesRef = "InferiorNasalConchaBones";

	public final static String LacrimalBone = "biomight.system.skeletal.skull.facial.LacrimalBone";
	public final static String LacrimalBoneRef = "LacrimalBone";

	public final static String LacrimalBones = "biomight.system.skeletal.skull.facial.LacrimalBones";
	public final static String LacrimalBonesRef = "LacrimalBones";

	public final static String MandibleBone = "biomight.system.skeletal.skull.facial.MandibleBone";
	public final static String MandibleBoneRef = "MandibleBone";
	
	public final static String MaxillaeBone = "biomight.system.skeletal.skull.facial.MaxillaeBone";
	public final static String MaxillaeBoneRef = "MaxillaeBone";

	public final static String MaxillaeBones = "biomight.system.skeletal.skull.facial.MaxillaeBoness";
	public final static String MaxillaeBonesRef = "MaxillaeBones";

	public final static String PalatineBone = "biomight.system.skeletal.skull.facial.PalatineBone";
	public final static String PalatineBoneRef = "PalatineBone";

	public final static String PalatineBones = "biomight.system.skeletal.skull.facial.PalatineBone";
	public final static String PalatineBonesRef = "PalatineBones";

	public final static String VomerBone = "biomight.system.skeletal.skull.facial.VomerBone";
	public final static String VomerBoneRef = "VomerBone";
	
	public final static String ZygomaticBone = "biomight.system.skeletal.skull.facial.ZygomaticBone";
	public final static String ZygomaticBoneRef = "ZygomaticBone";

	public final static String ZygomaticBones = "biomight.system.skeletal.skull.facial.ZygomaticBones";
	public final static String ZygomaticBonesRef = "ZygomaticBones";
	
	// 	biomight.system.skeletal.wrist
	public final static String WristDistalRow = "biomight.system.skeletal.wrist.WristDistalRow";
	public final static String WristProximalRow = "biomight.system.skeletal.wrist.WristProximalRow";
	
	 
 
	/********************************************************************************
	 * 
	 * MUSCULAR SYSTEM
	 * 
	 ********************************************************************************/ 

	public final static String MusclesTitle = "Muscles";
	
	public final static String MuscularSystem = "biomight.system.MuscularSystem";	
	public final static String MuscularSystemRef = "MuscularSystem";
	
	public final static String FlexorDigitorumProfundusMuscles = "biomight.system.muscular.FlexorDigitorumProfundusMuscles";
	public final static String FlexorDigitorumProfundusMusclesRef = "FlexorDigitorumProfundusMuscles";

	public final static String FlexorDigitorumProfundusMuscle = "biomight.system.muscular.FlexorDigitorumProfundusMuscle";
	public final static String FlexorDigitorumProfundusMuscleRef = "FlexorDigitorumProfundusMuscle";
	
	public final static String FlexorDigitorumSuperficialisMuscles = "biomight.system.muscular.FlexorDigitorumSuperficialisMuscles";
	public final static String FlexorDigitorumSuperficialisMusclesRef = "FlexorDigitorumSuperficialisMuscles";

	public final static String FlexorDigitorumSuperficialisMuscle = "biomight.system.muscular.FlexorDigitorumSuperficialisMuscle";
	public final static String FlexorDigitorumSuperficialisMuscleRef = "FlexorDigitorumSuperficialisMuscle";
	
	public final static String FlexorPollicisBrevisMuscles = "biomight.system.muscular.FlexorPollicisBrevisMuscles";
	public final static String FlexorPollicisBrevisMusclesRef = "FlexorPollicisBrevisMuscles";

	public final static String FlexorPollicisBrevisMuscle = "biomight.system.muscular.FlexorPollicisBrevisMuscle";
	public final static String FlexorPollicisBrevisMuscleRef = "FlexorPollicisBrevisMuscle";
	
	public final static String FlexorPollicisLongusMuscles = "biomight.system.muscular.FlexorPollicisLongusMuscles";
	public final static String FlexorPollicisLongusMusclesRef = "FlexorPollicisLongusMuscles";

	public final static String FlexorPollicisLongusMuscle = "biomight.system.muscular.FlexorPollicisLongusMuscle";
	public final static String FlexorPollicisLongusMuscleRef = "FlexorPollicisLongusMuscle";
	
	public final static String LongusColliMuscles = "biomight.system.muscular.LongusColliMuscle";
	public final static String LongusColliMusclesRef = "LongusColliMuscle";
	
	public final static String LongusColliMuscle = "biomight.system.muscular.LongusColliMuscles";
	public final static String LongusColliMuscleRef = "LongusColliMuscles";
	
	public final static String PalmarisLongusMuscles = "biomight.system.muscular.PalmarisLongusMuscles";
	public final static String PalmarisLongusMusclesRef = "PalmarisLongusMuscles";
	
	public final static String PalmarisLongusMuscle = "biomight.system.muscular.PalmarisLongusMuscle";
	public final static String PalmarisLongusMuscleRef = "PalmarisLongusMuscle";
	
	public final static String PlatysmaMuscles = "biomight.system.muscular.PlatysmaMuscles";
	public final static String PlatysmaMusclesRef = "PlatysmaMuscles";
	
	public final static String PlatysmaMuscle = "biomight.system.muscular.PlatysmaMuscle";
	public final static String PlatysmaMuscleRef = "PlatysmaMuscle";
	
	public final static String PronatorQuadratusMuscles = "biomight.system.muscular.PronatorQuadratusMuscles";
	public final static String PronatorQuadratusMusclesRef = "PronatorQuadratusMuscles";
	
	public final static String PronatorQuadratusMuscle = "biomight.system.muscular.PronatorQuadratusMuscle";
	public final static String PronatorQuadratusMuscleRef = "PronatorQuadratusMuscle";
	
	public final static String PronatorTeresMuscles = "biomight.system.muscular.PronatorTeresMuscles";
	public final static String PronatorTeresMusclesRef = "PronatorTeresMuscles";
	
	public final static String PronatorTeresMuscle = "biomight.system.muscular.PronatorTeresMuscle";
	public final static String PronatorTeresMuscleRef = "PronatorTeresMuscle";

	public final static String SupinatorMuscles = "biomight.system.muscular.SupinatorMuscles";
	public final static String SupinatorMusclesRef = "SupinatorMuscles";
	
	public final static String SupinatorMuscle = "biomight.system.muscular.SupinatorMuscle";
	public final static String SupinatorMuscleRef = "SupinatorMuscle";
	
	public final static String TrapeziusMuscles = "biomight.system.muscular.TrapeziusMuscles";
	public final static String TrapeziusMusclesRef = "TrapeziusMuscles";
	
	public final static String TrapeziusMuscle = "biomight.system.muscular.TrapeziusMuscle";
	public final static String TrapeziusMuscleRef = "TrapeziusMuscle";
	
	//biomight.system.muscular.head

	public final static String SuperficialFasciaMuscles = "biomight.system.muscular.head.ASuperficialFasciaMuscles";
	public final static String SuperficialFasciaMusclesRef = "SuperficialFasciaMuscles";

	public final static String SuperficialFasciaMuscle = "biomight.system.muscular.head.ASuperficialFasciaMuscle";
	public final static String SuperficialFasciaMuscleRef = "SuperficialFasciaMuscle";
	
	public final static String AuricularisAnteriorMuscles = "biomight.system.muscular.head.AuricularisAnteriorMuscles";
	public final static String AuricularisAnteriorMusclesRef = "AuricularisAnteriorMuscles";

	public final static String AuricularisAnteriorMuscle = "biomight.system.muscular.head.AuricularisAnteriorMuscle";
	public final static String AuricularisAnteriorMuscleRef = "AuricularisAnteriorMuscle";
	
	public final static String EpicraniusMuscles = "biomight.system.muscular.head.EpicraniusMuscles";
	public final static String EpicraniusMusclesRef = "EpicraniusMuscles";
			
	public final static String EpicraniusMuscle = "biomight.system.muscular.head.EpicraniusMuscle";
	public final static String EpicraniusMuscleRef = "EpicraniusMuscle";

	public final static String FrontalisMuscles = "biomight.system.muscular.head.FrontalisMuscles";
	public final static String FrontalisMusclesRef = "FrontalisMuscles";
	
	public final static String FrontalisMuscle = "biomight.system.muscular.head.FrontalisMuscle";
	public final static String FrontalisMuscleRef = "FrontalisMuscle";
	
	public final static String GaleaAponeuroticaMuscles = "biomight.system.muscular.head.GaleaAponeuroticaMuscles";
	public final static String GaleaAponeuroticaMusclesRef = "GaleaAponeuroticaMuscles";
	
	public final static String GaleaAponeuroticaMuscle = "biomight.system.muscular.head.GaleaAponeuroticaMuscle";
	public final static String GaleaAponeuroticaMuscleRef = "GaleaAponeuroticaMuscle";

	public final static String OccipitalisMuscles = "biomight.system.muscular.head.OccipitalisMuscles";
	public final static String OccipitalisMusclesRef = "OccipitalisMuscles";

	public final static String OccipitalisMuscle = "biomight.system.muscular.head.OccipitalisMuscle";
	public final static String OccipitalisMuscleRef = "OccipitalisMuscle";
	
	public final static String SuperficialFascias = "biomight.system.muscular.head.SuperficialFascias";
	public final static String SuperficialFasciasRef = "SuperficialFascias";

	public final static String SuperficialFascia = "biomight.system.muscular.head.SuperficialFascia";
	public final static String SuperficialFasciaRef = "SuperficialFascia";

	// biomight.system.muscular.head.facial
	public final static String CorrugatorSuperciliiMuscles = "biomight.system.muscular.head.facial.CorrugatorSuperciliiMuscles";
	public final static String CorrugatorSuperciliiMusclesRef = "CorrugatorSuperciliiMuscle";
	
	public final static String CorrugatorSuperciliiMuscle = "biomight.system.muscular.head.facial.CorrugatorSuperciliiMuscle";
	public final static String CorrugatorSuperciliiMuscleRef = "CorrugatorSuperciliiMuscle";
	
	public final static String LevatorLabiiSuperiorisAlaequeNasiMuscle = "biomight.system.muscular.head.facial.LevatorLabiiSuperiorisAlaequeNasiMuscle";
	public final static String LevatorLabiiSuperiorisAlaequeNasiMuscleRef = "LevatorLabiiSuperiorisAlaequeNasiMuscle";
	
	public final static String LevatorLabiiSuperiorisMuscle = "biomight.system.muscular.head.facial.LevatorLabiiSuperiorisMuscle";
	public final static String LevatorLabiiSuperiorisMuscleRef = "LevatorLabiiSuperiorisMuscle";
	
	public final static String OrbicularisOculiMuscle = "biomight.system.muscular.head.facial.OrbicularisOculiMuscle";
	public final static String OrbicularisOculiMuscleRef = "OrbicularisOculiMuscle";
	
	public final static String OrbicularisOrisMuscle = "biomight.system.muscular.head.facial.OrbicularisOrisMuscle";
	public final static String OrbicularisOrisMuscleRef = "OrbicularisOrisMuscle";
			
	// biomight.system.muscular.head.eye
	public final static String InferiorObliqueMuscle = "biomight.system.muscular.head.eye.InferiorObliqueMuscle";
	public final static String InferiorObliqueMuscleRef = "InferiorObliqueMuscle";
	
	public final static String IrisSphincterMuscle = "biomight.system.muscular.head.eye.IrisSphincterMuscle";
	public final static String IrisSphincterMuscleRef = "IrisSphincterMuscle";
	
	public final static String InferiorRectusMuscle = "biomight.system.muscular.head.eye.InferiorRectusMuscle";
	public final static String InferiorRectusMuscleRef = "InferiorRectusMuscle";
	
	public final static String LateralRectusMuscle = "biomight.system.muscular.head.eye.LateralRectusMuscle";
	public final static String LateralRectusMuscleRef = "LateralRectusMuscle";
	
	public final static String MediallRectusMuscle = "biomight.system.muscular.head.eye.MediallRectusMuscle";
	public final static String MediallRectusMuscleRef = "MediallRectusMuscle";
	
	public final static String SuperiorObliqueMuscle = "biomight.system.muscular.head.eye.SuperiorObliqueMuscle";
	public final static String SuperiorObliqueMuscleRef = "SuperiorObliqueMuscle";
	
	public final static String SuperiorRectusMuscle = "biomight.system.muscular.head.eye.SuperiorRectusMuscle";
	public final static String SuperiorRectusMuscleRef = "SuperiorRectusMuscle";
	
	// biomight.system.muscular.head.eyelid
	public final static String CorrugatorMuscle = "biomight.system.muscular.head.eyelid.CorrugatorMuscle";
	public final static String CorrugatorMuscleRef = "CorrugatorMuscle";
	
	public final static String LevatorPalpebraeSuperiorisMuscle = "biomight.system.muscular.head.eyelid.LevatorPalpebraeSuperiorisMuscle";
	public final static String LevatorPalpebraeSuperiorisMuscleRef = "LevatorPalpebraeSuperiorisMuscle";
	
	public final static String SuperiorisMuscle = "biomight.system.muscular.head.eyelid.SuperiorisMuscle";
	public final static String SuperiorisMuscleRef = "SuperiorisMuscle";
	
	// biomight.system.muscular.head.mastication
	public final static String MasseterMuscle = "biomight.system.muscunemular.head.mastication.MasseterMuscle";
	public final static String MasseterMuscleRef = "MasseterMuscle";
	
	public final static String PterygoideusExternusMuscle = "biomight.system.muscular.head.mastication.PterygoideusExternusMuscle";
	public final static String PterygoideusExternusMuscleRef = "PterygoideusExternusMuscle";
	
	public final static String PterygoideusInternusMuscle = "biomight.system.muscular.head.mastication.PterygoideusInternusMuscle";
	public final static String PterygoideusInternusMuscleRef = "PterygoideusInternusMuscle";
	
	public final static String TemporalisMuscle = "biomight.system.muscular.head.mastication.TemporalisMuscle";
	public final static String TemporalisMuscleRef = "TemporalisMuscle";
	
	// biomight.system.muscular.head.mouth
	public final static String BuccinatorMuscle = "biomight.system.muscular.head.mouth.BuccinatorMuscle";
	public final static String BuccinatorMuscleRef = "BuccinatorMuscle";
	
	public final static String CaninusMuscle = "biomight.system.muscular.head.mouth.CaninusMuscle";
	public final static String CaninusMuscleRef = "CaninusMuscle";
	
	public final static String DepressorAnguliOrisMuscle = "biomight.system.muscular.head.mouth.DepressorAnguliOrisMuscle";
	public final static String DepressorAnguliOrisMuscleRef = "DepressorAnguliOrisMuscle";
	
	public final static String DepressorLabiiInferiorisMuscle = "biomight.system.muscular.head.mouth.DepressorLabiiInferiorisMuscle";
	public final static String DepressorLabiiInferiorisMuscleRef = "DepressorLabiiInferiorisMuscle";
	
	public final static String LevatorAnguliOrisMuscle = "biomight.system.muscular.head.mouth.LevatorAnguliOrisMuscle";
	public final static String LevatorAnguliOrisMuscleRef = "LevatorAnguliOrisMuscle";
	
	public final static String MentalisMuscle = "biomight.system.muscular.head.mouth.MentalisMuscle";
	public final static String MentalisMuscleRef = "MentalisMuscle";
	
	public final static String QuadratusLabiiInferiorisMuscle = "biomight.system.muscular.head.mouth.QuadratusLabiiInferiorisMuscle";
	public final static String QuadratusLabiiInferiorisMuscleRef = "QuadratusLabiiInferioris";
	
	public final static String QuadratusLabiiSuperiorisMuscle = "biomight.system.muscular.head.mouth.QuadratusLabiiSuperiorisMuscle";
	public final static String QuadratusLabiiSuperiorisMuscleRef = "QuadratusLabiiSuperiorisMuscle";
	
	public final static String RisoriusMuscle = "biomight.system.muscular.head.mouth.RisoriusMuscle";
	public final static String RisoriusMuscleRef = "RisoriusMuscle";
	
	public final static String TriangularisMuscle = "biomight.system.muscular.head.mouth.TriangularisMuscle";
	public final static String TriangularisMuscleRef = "TriangularisMuscle";
	
	public final static String ZygomaticusMajorMuscle = "biomight.system.muscular.head.mouth.ZygomaticusMajorMuscle";
	public final static String ZygomaticusMajorMuscleRef = "ZygomaticusMajorMuscle";
	
	public final static String ZygomaticusMinorMuscle = "biomight.system.muscular.head.mouth.ZygomaticusMinorMuscle";
	public final static String ZygomaticusMinorMuscleRef = "ZygomaticusMinorMuscle";
	
	public final static String ZygomaticusMuscle = "biomight.system.muscular.head.mouth.ZygomaticusMuscle";
	public final static String ZygomaticusMuscleRef = "ZygomaticusMuscle";
	
	//	biomight.system.muscular.head.mouth.tongue
	public final static String InferiorLongitudinalMuscle = "biomight.system.muscular.head.mouth.tongue.InferiorLongitudinalMuscle";
	public final static String InferiorLongitudinalMuscleRef = "InferiorLongitudinalMuscle";

	public final static String SuperiorLongitudinalMuscle = "biomight.system.muscular.head.mouth.tongue.SuperiorLongitudinalMuscle";
	public final static String SuperiorLongitudinalMuscleRef = "SuperiorLongitudinalMuscle";

	public final static String TransversusMuscle = "biomight.system.muscular.head.mouth.tongue.TransversusMuscle";
	public final static String TransversusMuscleRef = "ransversusMuscle";

	public final static String VerticalisMuscle = "biomight.system.muscular.head.mouth.tongue.VerticalisMuscle";
	public final static String VerticalisMuscleRef = "VerticalisMuscle";

	// biomight.system.muscular.head.nose	
	public final static String DepressorSeptiNasiMuscle = "biomight.system.muscular.head.nose.DepressorSeptiNasiMuscle";
	public final static String DepressorSeptiNasiMuscleRef = "DepressorSeptiNasiMuscle";

	public final static String DilatatorNarisPosterior = "biomight.system.muscular.head.nose.DilatatorNarisPosterior";
	public final static String DilatatorNarisPosteriorRef = "DilatatorNarisPosterior";

	public final static String NasalisMuscle = "biomight.system.muscular.head.nose.NasalisMuscle";
	public final static String NasalisMuscleRef = "NasalisMuscle";

	public final static String ProcerusMuscle = "biomight.system.muscular.head.nose.ProcerusMuscle";
	public final static String ProcerusMuscleRef = "ProcerusMuscle";


	// biomight.system.muscular.neck
	public final static String AnteriorScaleneMuscle = "biomight.system.muscular.neck.AnteriorScaleneMuscle";
	public final static String AnteriorScaleneMuscleRef = "AnteriorScaleneMuscle";
	
	public final static String MusculusUvulaeMuscle = "biomight.system.muscular.neck.MusculusUvulaeMuscle";
	public final static String MusculusUvulaeMuscleRef = "MusculusUvulaeMuscle";

	
	public final static String AnteriorVeterbralMuscle = "biomight.system.muscular.neck.AnteriorVeterbralMuscle";
	public final static String AnteriorVeterbralMuscleRef = "AnteriorVeterbralMuscle";
	
	public final static String CricoArytenoidMuscle = "biomight.system.muscular.neck.CricoArytenoidMuscle";
	public final static String CricoArytenoidMuscleRef = "CricoArytenoidMuscle";
	
	public final static String CricoThyroidMuscle = "biomight.system.muscular.neck.CricoThyroidMuscle";
	public final static String CricoThyroidMuscleRef = "CricoThyroidMuscle";
	
	public final static String DigastricMuscle = "biomight.system.muscular.neck.DigastricMuscle";
	public final static String DigastricMuscleRef = "biomight.system.muscular.neck.DigastricMuscle";
	
	public final static String GenioHyoidMuscle = "biomight.system.muscular.neck.GenioHyoidMuscle";
	public final static String GenioHyoidMuscleRef = "GenioHyoidMuscle";
	
	public final static String LateralCervicleMuscle = "biomight.system.muscular.neck.LateralCervicleMuscle";
	public final static String LateralCervicleMuscleRef = "LateralCervicleMuscle";
	
	public final static String LateralCricoarytenoidMuscle = "biomight.system.muscular.neck.LateralCricoarytenoidMuscle";
	public final static String LateralCricoarytenoidMuscleRef = "LateralCricoarytenoidMuscle";

	public final static String LateralVeterbralMuscle = "biomight.system.muscular.neck.LateralVeterbralMuscle";
	public final static String LateralVeterbralMuscleRef = "LateralVeterbralMuscle";
	
	public final static String LongusCapitisMuscle = "biomight.system.muscular.neck.LongusCapitisMuscle";
	public final static String LongusCapitisMuscleRef = "LongusCapitisMuscle";
	
	public final static String MusculusUvulae = "biomight.system.muscular.neck.MusculusUvulae";
	public final static String MusculusUvulaeRef = "MusculusUvulae";
	
	public final static String MylohyoidMuscle = "biomight.system.muscular.neck.MylohyoidMuscle";
	public final static String MylohyoidMuscleRef = "MylohyoidMuscle";
	
	public final static String OmoHyoidMuscle = "biomight.system.muscular.neck.OmoHyoidMuscle";
	public final static String OmoHyoidMuscleRef = "OmoHyoidMuscle";
	
	public final static String RectusCapitisAnteriorMuscle = "biomight.system.muscular.neck.RectusCapitisAnteriorMuscle";
	public final static String RectusCapitisAnteriorMuscleRef = "RectusCapitisAnteriorMuscle";
	
	public final static String RectusCapitisLateralisMuscle = "biomight.system.muscular.neck.RectusCapitisLateralisMuscle";
	public final static String RectusCapitisLateralisMuscleRef = "RectusCapitisLateralisMuscle";

	public final static String ScalenusAnteriorMuscle = "biomight.system.muscular.neck.ScalenusAnteriorMuscle";
	public final static String ScalenusAnteriorMuscleRef = "biomight.system.muscular.neck.ScalenusAnteriorMuscle";
	
	public final static String ScalenusMediusMuscle = "biomight.system.muscular.neck.ScalenusMediusMuscle";
	public final static String ScalenusMediusMuscleRef = "ScalenusMediusMuscle";
	
	public final static String ScalenusMinimusMuscle = "biomight.system.muscular.neck.ScalenusMinimusMuscle";
	public final static String ScalenusMinimusMuscleRef = "ScalenusMinimusMuscle";

	public final static String ScalenusPosteriorMuscle = "biomight.system.muscular.neck.ScalenusPosteriorMuscle";
	public final static String ScalenusPosteriorMuscleRef = "ScalenusPosteriorMuscle";
		
	public final static String SternoCleidoMastoidMuscle = "biomight.system.muscular.neck.SternoCleidoMastoidMuscle";
	public final static String SternoCleidoMastoidMuscleRef = "SternoCleidoMastoidMuscle";
		
	public final static String SternoHyoidMuscle = "biomight.system.muscular.neck.SternoHyoidMuscle";
	public final static String SternoHyoidMuscleRef = "SternoHyoidMuscle";
	
	public final static String SternoMastoidMuscle = "biomight.system.muscular.neck.SternoMastoidMuscle";
	public final static String SternoMastoidMuscleRef = "SternoMastoidMuscle";
	
	public final static String SternoThyroidMuscle = "biomight.system.muscular.neck.SternoThyroidMuscle";
	public final static String SternoThyroidMuscleRef = "biomight.system.muscular.neck.SternoThyroidMuscle";
	
	public final static String StyloHyoidMuscle = "biomight.system.muscular.neck.StyloHyoidMuscle";
	public final static String StyloHyoidMuscleRef = "StyloHyoidMuscle";

	public final static String SuperficialCervicalMuscle = "biomight.system.muscular.neck.SuperficialCervicalMuscle";
	public final static String SuperficialCervicalMuscleRef = "SuperficialCervicalMuscle";
	
	public final static String SupraInfrahyoidMuscle = "biomight.system.muscular.neck.SupraInfrahyoidMuscle";
	public final static String SupraInfrahyoidMuscleRef = "SupraInfrahyoidMuscle";
	
	public final static String ThyroArytenoidMuscle = "biomight.system.muscular.neck.ThyroArytenoidMuscle";
	public final static String ThyroArytenoidMuscleRef = "ThyroArytenoidMuscle";

	public final static String ThyroHyoidMuscle = "biomight.system.muscular.neck.ThyroHyoidMuscle";
	public final static String ThyroHyoidMuscleRef = "ThyroHyoidMuscle";

	public final static String DigrasticMuscle = "biomight.system.muscular.neck.DigrasticMuscle";
	public final static String DigrasticMuscleRef = "DigrasticMuscle";

	
	// biomight.system.muscular.foot
	public final static String AbductorDigitiMinimiMuscle = "biomight.system.muscular.foot.AbductorDigitiMinimiMuscle";
	public final static String AbductorDigitiMinimiMuscleRef = "AbductorDigitiMinimiMuscle";
	public final static String AbductorHallucisMuscle = "biomight.system.muscular.foot.AbductorHallucisMuscle";
	public final static String AbductorHallucisMuscleRef = "AbductorHallucisMuscle";
	public final static String AbductorOssisMetatarsiQuintiMuscle = "biomight.system.muscular.foot.AbductorOssisMetatarsiQuintiMuscle";
	public final static String AbductorOssisMetatarsiQuintiMuscleRef = "AbductorOssisMetatarsiQuintiMuscle";
	public final static String AdductorHallucisMuscle = "biomight.system.muscular.foot.AdductorHallucisMuscle";
	public final static String AdductorHallucisMuscleRef = "AdductorHallucisMuscle";

	public final static String DorsalInterosseiMuscle = "biomight.system.muscular.foot.DorsalInterosseiMuscle";
	public final static String DorsalInterosseiMuscleRef = "DorsalInterosseiMuscle";

	public final static String DorsalInterosseiMuscles = "biomight.system.muscular.foot.DorsalInterosseiMuscles";
	public final static String DorsalInterosseiMusclesRef = "DorsalInterosseiMuscles";
	
	public final static String ExtensorDigitorumBrevis = "biomight.system.muscular.foot.ExtensorDigitorumBrevis";
	public final static String ExtensorDigitorumBrevisRef = "ExtensorDigitorumBrevis";
	public final static String ExtensorHallucisBrevisMuscle = "biomight.system.muscular.foot.ExtensorHallucisBrevisMuscle";
	public final static String ExtensorHallucisBrevisMuscleRef = "ExtensorHallucisBrevisMuscle";
	public final static String FlexorDigitiMinimiBrevis = "biomight.system.muscular.foot.FlexorDigitiMinimiBrevis";
	public final static String FlexorDigitiMinimiBrevisRef = "FlexorDigitiMinimiBrevis";
	public final static String FlexorDigitorumBrevisMuscle = "biomight.system.muscular.foot.FlexorDigitorumBrevisMuscle";
	public final static String FlexorDigitorumBrevisMuscleRef = "FlexorDigitorumBrevisMuscle";
	public final static String FlexorHallucisBrevisMuscle = "biomight.system.muscular.foot.FlexorHallucisBrevisMuscle";
	public final static String FlexorHallucisBrevisMuscleRef = "FlexorHallucisBrevisMuscle";
	public final static String InterosselMuscle = "biomight.system.muscular.foot.InterosselMuscle";
	public final static String InterosselMuscleRef = "InterosselMuscle";
	public final static String LumbriclesMuscle = "biomight.system.muscular.foot.LumbriclesMuscle";
	public final static String LumbriclesMuscleRef = "LumbriclesMuscle";
	public final static String PlantarInterosseiMuscle = "biomight.system.muscular.foot.PlantarInterosseiMuscle";
	public final static String PlantarInterosseiMuscleRef = "PlantarInterosseiMuscle";
	public final static String QuadratusPlantaeMuscle = "biomight.system.muscular.foot.QuadratusPlantaeMuscle";
	public final static String QuadratusPlantaeMuscleRef = "QuadratusPlantaeMuscle";

	// biomight.system.muscular.foot
	public final static String AbductorPollicisBrevisMuscle = "biomight.system.muscular.foot.AbductorPollicisBrevisMuscle";
	public final static String AbductorPollicisBrevisMuscleRef = "AbductorPollicisBrevisMuscle";

	public final static String FlexorDigitiMinimiBrevisMuscle = "biomight.system.muscular.foot.FlexorDigitiMinimiBrevisMuscle";
	public final static String FlexorDigitiMinimiBrevisMuscleRef = "FlexorDigitiMinimiBrevisMuscle";

	
	// biomight.system.muscular.hand	
	public final static String AbductorPollicisLongusFootMuscle = "biomight.system.muscular.hand.AbductorPollicisLongusMuscle";
	public final static String AbductorPollicisLongusFootMuscleRef = "AbductorPollicisLongusFootMuscle";
	
	public final static String AbductorPollicisLongusMuscle = "biomight.system.muscular.hand.AbductorPollicisLongusMuscle";
	public final static String AbductorPollicisLongusMuscleRef = "AbductorPollicisLongusFootMuscle";

	public final static String AdductorPollicisMuscle = "biomight.system.muscular.hand.AdductorPollicisMuscle";
	public final static String AdductorPollicisMuscleRef = "AdductorPollicisMuscle";

	public final static String ExtensorPollicisBrevisMuscle = "biomight.system.muscular.hand.ExtensorPollicisBrevisMuscle";
	public final static String ExtensorPollicisBrevisMuscleRef = "ExtensorPollicisBrevisMuscle";
	
	public final static String LumbricalMuscle = "biomight.system.muscular.hand.LumbricalMuscle";
	public final static String LumbricalMuscleRef = "LumbricalMuscle";

	public final static String LumbricalMuscles = "biomight.system.muscular.hand.LumbricalMuscles";
	public final static String LumbricalMusclesRef = "LumbricalMuscles";
	
	public final static String OpponensDigitiMinimiMuscle = "biomight.system.muscular.hand.OpponensDigitiMinimiMuscle";
	public final static String OpponensDigitiMinimiMuscleRef = "OpponensDigitiMinimiMuscle";
	
	public final static String OpponensPollicisMuscle = "biomight.system.muscular.hand.OpponensPollicisMuscle";
	public final static String OpponensPollicisMuscleRef = "OpponensPollicisMuscle";

	public final static String PalmarInterosseiMuscle = "biomight.system.muscular.hand.PalmarInterosseiMuscle";
	public final static String PalmarInterosseiMuscleRef = "PalmarInterosseiMuscle";

	public final static String PalmarInterosseiMuscles = "biomight.system.muscular.hand.PalmarInterosseiMuscles";
	public final static String PalmarInterosseiMusclesRef = "PalmarInterosseiMuscles";
	
	public final static String PalmarisBrevisMuscle = "biomight.system.muscular.hand.PalmarisBrevisMuscle";
	public final static String PalmarisBrevisMuscleRef = "PalmarisBrevisMuscle";

	// biomight.system.muscular.perineum
	public final static String BulboSpongiosusMuscle = "biomight.system.muscular.perineum.BulboSpongiosusMuscle";
	public final static String BulboSpongiosusMuscleRef = "BulboSpongiosusMuscle";

	public final static String IschiocavernosusMuscle = "biomight.system.muscular.perineum.IschiocavernosusMuscle";
	public final static String IschiocavernosusMuscleRef = "IschiocavernosusMuscle";
	
	
	public final static String CorrugatorCutisAniMuscle = "biomight.system.muscular.perineum.CorrugatorCutisAniMuscle";
	public final static String CorrugatorCutisAniMuscleRef = "CorrugatorCutisAniMuscle";
		
	public final static String TransversusPerineiProfundusMuscle = "biomight.system.muscular.perineum.TransversusPerineiProfundusMuscle";
	public final static String TransversusPerineiProfundusMuscleRef = "TransversusPerineiProfundusMuscle";
	
	public final static String SphincterAniExternusMuscle = "biomight.system.muscular.perineum.SphincterAniExternusMuscle";
	public final static String SphincterAniExternusMuscleRef = "phincterAniExternusMuscle";
	
	public final static String SphincterAniInternusMuscle = "biomight.system.muscular.perineum.SphincterAniInternusMuscle";
	public final static String SphincterAniInternusMuscleRef = "SphincterAniInternusMuscle";
	
	public final static String SphincterUrethraeMembranaceaeMuscle = "biomight.system.muscular.perineum.SphincterUrethraeMembranaceaeMuscle";
	public final static String SphincterUrethraeMembranaceaeMuscleRef = "SphincterUrethraeMembranaceaeMuscle";
	
	public final static String TransversusPerineiSuperficialisMuscle = "biomight.system.muscular.perineum.TransversusPerineiSuperficialisMuscle";
	public final static String TransversusPerineiSuperficialisMuscleRef = "TransversusPerineiSuperficialisMuscle";
	

	//	biomight.system.muscular.shoulder
	public final static String DeltoideusMuscle = "biomight.system.muscular.shoulder.DeltoideusMuscle";
	public final static String DeltoideusMuscleRef = "DeltoideusMuscle";

	public final static String InfraSpinatusMuscles = "biomight.system.muscular.shoulder.InfraSpinatusMuscles";
	public final static String InfraSpinatusMusclesRef = "InfraSpinatusMuscles";
	
	public final static String InfraSpinatusMuscle = "biomight.system.muscular.shoulder.InfraSpinatusMuscle";
	public final static String InfraSpinatusMuscleRef = "InfraSpinatusMuscle";
	
	public final static String InterSpinatusMuscles = "biomight.system.muscular.shoulder.InterSpinatusMuscles";
	public final static String InterSpinatusMusclesRef = "InterSpinatusMuscles";

	public final static String InterSpinatusMuscle = "biomight.system.muscular.shoulder.InterSpinatusMuscle";
	public final static String InterSpinatusMuscleRef = "InterSpinatusMuscle";

	public final static String SubScapularisMuscles = "biomight.system.muscular.shoulder.SubScapularisMuscles";
	public final static String SubScapularisMusclesRef = "SubScapularisMuscles";

	public final static String SubScapularisMuscle = "biomight.system.muscular.shoulder.SubScapularisMuscle";
	public final static String SubScapularisMuscleRef = "SubScapularisMuscle";
	
	public final static String SupraSpinatusMuscles = "biomight.system.muscular.shoulder.SupraSpinatusMuscles";
	public final static String SupraSpinatusMusclesRef = "SupraSpinatusMuscles";
	
	public final static String SupraSpinatusMuscle = "biomight.system.muscular.shoulder.SupraSpinatusMuscle";
	public final static String SupraSpinatusMuscleRef = "SupraSpinatusMuscle";

	public final static String TeresMajorMuscles = "biomight.system.muscular.shoulder.TeresMajorMuscles";
	public final static String TeresMajorMusclesRef = "TeresMajorMuscles";

	public final static String TeresMajorMuscle = "biomight.system.muscular.shoulder.TeresMajorMuscle";
	public final static String TeresMajorMuscleRef = "TeresMajorMuscle";

	public final static String TeresMinorMuscles = "biomight.system.muscular.shoulder.TeresMinorMuscles";
	public final static String TeresMinorMusclesRef = "TeresMinorMuscle";

	public final static String TeresMinorMuscle = "biomight.system.muscular.shoulder.TeresMinorMuscle";
	public final static String TeresMinorMuscleRef = "TeresMinorMuscle";
	


	// MUSCULAR - ABDOMEN
	public final static String CremasterMuscles = "biomight.system.muscular.abdomen.CremasterMuscles";
	public final static String CremasterMusclesRef = "CremasterMuscles";

	public final static String CremasterMuscle = "biomight.system.muscular.abdomen.CremasterMuscle";
	public final static String CremasterMuscleRef = "CremasterMuscle";

	public final static String ObliquusExternusAbdominisMuscle = "biomight.system.muscular.abdomen.ObliquusExternusAbdominisMuscle";
	public final static String ObliquusExternusAbdominisMuscleRef = "ObliquusExternusAbdominisMuscle";
	
	public final static String ObliquusExternusAbdominisMuscles = "biomight.system.muscular.abdomen.ObliquusExternusAbdominisMuscles";
	public final static String ObliquusExternusAbdominisMusclesRef = "ObliquusExternusAbdominisMuscles";
	
	public final static String ObliquusInternusAbdominisMuscle = "biomight.system.muscular.abdomen.ObliquusInternusAbdominisMuscle";
	public final static String ObliquusInternusAbdominisMuscleRef = "ObliquusInternusAbdominisMuscle";
	
	public final static String ObliquusInternusAbdominisMuscles = "biomight.system.muscular.abdomen.ObliquusInternusAbdominisMuscles";
	public final static String ObliquusInternusAbdominisMusclesRef = "ObliquusInternusAbdominisMuscles";
	
	public final static String PsoasMajorMuscle = "biomight.system.muscular.abdomen.PsoasMajorMuscle";
	public final static String PsoasMajorMuscleRef = "PsoasMajorMuscle";
	
	public final static String PsoasMajorMuscles = "biomight.system.muscular.abdomen.PsoasMajorMuscles";
	public final static String PsoasMajorMusclesRef = "PsoasMajorMuscles";
	
	public final static String PsoasMinorMuscle = "biomight.system.muscular.abdomen.PsoasMinorMuscle";
	public final static String PsoasMinorMuscleRef = "PsoasMinorMuscle";
	public final static String PsoasMinorMuscles = "biomight.system.muscular.abdomen.PsoasMinorMuscle";
	public final static String PsoasMinorMusclesRef = "PsoasMinorMuscle";
	
	public final static String PyramidalisMuscle = "biomight.system.muscular.abdomen.PyramidalisMuscle";
	public final static String PyramidalisMuscleRef = "PyramidalisMuscle";
	public final static String PyramidalisMuscles = "biomight.system.muscular.abdomen.PyramidalisMuscles";
	public final static String PyramidalisMusclesRef = "PyramidalisMuscles";
	
	public final static String QuadratusLumborumMuscle = "biomight.system.muscular.abdomen.QuadratusLumborumMuscle";
	public final static String QuadratusLumborumMuscleRef = "QuadratusLumborumMuscle";
	
	public final static String QuadratusLumborumMuscles = "biomight.system.muscular.abdomen.QuadratusLumborumMuscles";
	public final static String QuadratusLumborumMusclesRef = "QuadratusLumborumMuscles";
	
	public final static String RectusAdominisMuscle = "biomight.system.muscular.abdomen.RectusAdominisMuscle";
	public final static String RectusAdominisMuscleRef = "RectusAdominisMuscle";
	
	public final static String RectusAdominisMuscles = "biomight.system.muscular.abdomen.RectusAdominisMuscles";
	public final static String RectusAdominisMusclesRef = "RectusAdominisMuscles";
	
	public final static String TransversusAbdominisMuscle = "biomight.system.muscular.abdomen.TransversusAbdominisMuscle";
	public final static String TransversusAbdominisMuscleRef = "TransversusAbdominisMuscle";
	
	public final static String TransversusAbdominisMuscles = "biomight.system.muscular.abdomen.TransversusAbdominisMuscles";
	public final static String TransversusAbdominisMusclesRef = "TransversusAbdominisMuscles";

	
	// MUSCULAR - ARM
	public final static String AnconeusMuscles = "biomight.system.muscular.arm.AnconeusMuscles";
	public final static String AnconeusMusclesRef = "AnconeusMuscles";
	public final static String AnconeusMuscle = "biomight.system.muscular.arm.AnconeusMuscle";
	public final static String AnconeusMuscleRef = "AnconeusMuscle";

	public final static String BicepsBrachiiMuscles = "biomight.system.muscular.arm.BicepsBrachiiMuscles";
	public final static String BicepsBrachiiMusclesRef = "BicepsBrachiiMuscles";
	public final static String BicepsBrachiiMuscle = "biomight.system.muscular.arm.BicepsBrachiiMuscle";
	public final static String BicepsBrachiiMuscleRef = "BicepsBrachiiMuscle";

	public final static String BrachialisMuscles = "biomight.system.muscular.arm.BrachialisMuscles";
	public final static String BrachialisMusclesRef = "BrachialisMuscles";
	public final static String BrachialisMuscle = "biomight.system.muscular.arm.BrachialisMuscles";
	public final static String BrachialisMuscleRef = "BrachialisMuscle";
	
	public final static String BrachioradialisMuscles = "biomight.system.muscular.arm.BrachioradialisMuscles";
	public final static String BrachioradialisMusclesRef = "BrachioradialisMuscles";
	public final static String BrachioradialisMuscle = "biomight.system.muscular.arm.BrachioradialisMuscle";
	public final static String BrachioradialisMuscleRef = "BrachioradialisMuscle";
	
	
	//public final static String CoracoBrachialisMuscle = "biomight.system.muscular.arm.CoracoBrachialisMuscle";
	public final static String ExtensorCarpiRadialisBrevisMuscles = "biomight.system.muscular.arm.ExtensorCarpiRadialisBrevisMuscles";
	public final static String ExtensorCarpiRadialisBrevisMusclesRef = "ExtensorCarpiRadialisBrevisMuscles";
	public final static String ExtensorCarpiRadialisBrevisMuscle = "biomight.system.muscular.arm.ExtensorCarpiRadialisBrevisMuscle";
	public final static String ExtensorCarpiRadialisBrevisMuscleRef = "ExtensorCarpiRadialisBrevisMuscle";
	
	public final static String ExtensorCarpiRadialisLongusMuscles = "biomight.system.muscular.arm.ExtensorCarpiRadialisLongusMuscles";
	public final static String ExtensorCarpiRadialisLongusMusclesRef = "ExtensorCarpiRadialisLongusMuscles";
	public final static String ExtensorCarpiRadialisLongusMuscle = "biomight.system.muscular.arm.ExtensorCarpiRadialisLongusMuscle";
	public final static String ExtensorCarpiRadialisLongusMuscleRef = "ExtensorCarpiRadialisLongusMuscle";

	public final static String ExtensorCarpiUlnarisMuscles = "biomight.system.muscular.arm.ExtensorCarpiUlnarisMuscles";
	public final static String ExtensorCarpiUlnarisMusclesRef = "ExtensorCarpiUlnarisMuscles";
	public final static String ExtensorCarpiUlnarisMuscle = "biomight.system.muscular.arm.ExtensorCarpiUlnarisMuscle";
	public final static String ExtensorCarpiUlnarisMuscleRef = "ExtensorCarpiUlnarisMuscle";
	
	public final static String ExtensorDigitiMinimiMuscles = "biomight.system.muscular.arm.ExtensorDigitiMinimiMuscles";
	public final static String ExtensorDigitiMinimiMusclesRef = "ExtensorDigitiMinimiMuscles";
	public final static String ExtensorDigitiMinimiMuscle = "biomight.system.muscular.arm.ExtensorDigitiMinimiMuscle";
	public final static String ExtensorDigitiMinimiMuscleRef = "ExtensorDigitiMinimiMuscle";
	
	public final static String ExtensorDigitorumMuscles = "biomight.system.muscular.arm.ExtensorDigitorumMuscles";
	public final static String ExtensorDigitorumMusclesRef = "ExtensorDigitorumMuscles";
	public final static String ExtensorDigitorumMuscle = "biomight.system.muscular.arm.ExtensorDigitorumMuscle";
	public final static String ExtensorDigitorumMuscleRef = "ExtensorDigitorumMuscle";
	
	public final static String ExtensorPollicisLongusMuscles = "biomight.system.muscular.arm.ExtensorPollicisLongusMuscles";
	public final static String ExtensorPollicisLongusMusclesRef = "ExtensorPollicisLongusMuscles";
	public final static String ExtensorPollicisLongusMuscle = "biomight.system.muscular.arm.ExtensorPollicisLongusMuscle";
	public final static String ExtensorPollicisLongusMuscleRef = "ExtensorPollicisLongusMuscle";
	
	public final static String FlexorCarpiRadialisMuscles = "biomight.system.muscular.arm.FlexorCarpiRadialisMuscles";
	public final static String FlexorCarpiRadialisMusclesRef = "FlexorCarpiRadialisMuscles";
	public final static String FlexorCarpiRadialisMuscle = "biomight.system.muscular.arm.FlexorCarpiRadialisMuscle";
	public final static String FlexorCarpiRadialisMuscleRef = "FlexorCarpiRadialisMuscle";
	
	public final static String FlexorCarpiUlnarisMuscles = "biomight.system.muscular.arm.FlexorCarpiUlnarisMuscles";
	public final static String FlexorCarpiUlnarisMusclesRef = "FlexorCarpiUlnarisMuscles";
	public final static String FlexorCarpiUlnarisMuscle = "biomight.system.muscular.arm.FlexorCarpiUlnarisMuscle";
	public final static String FlexorCarpiUlnarisMuscleRef = "FlexorCarpiUlnarisMuscle";

	public final static String TricepsBrachiiMuscles = "biomight.system.muscular.arm.TricepsBrachiiMuscles";
	public final static String TricepsBrachiiMusclesRef = "TricepsBrachiiMuscles";
	public final static String TricepsBrachiiMuscle = "biomight.system.muscular.arm.TricepsBrachiiMuscle";
	public final static String TricepsBrachiiMuscleRef = "TricepsBrachiiMuscle";
				
	public final static String AntiBrachialFasciaMuscles = "biomight.system.muscular.forearm.TricepsBrachiiMuscles";
	public final static String AntiBrachialFasciaMusclesRef = "AntiBrachialFasciaMuscles";
	public final static String AntiBrachialFasciaMuscle = "biomight.system.muscular.forearm.TricepsBrachiiMuscle";
	public final static String AntiBrachialFasciaMuscleRef = "AntiBrachialFasciaMuscle";
	
	public final static String ExtensorDigitorumBrevisMuscles = "biomight.system.muscular.foot.AntiBrachialFasciaMuscles";
	public final static String ExtensorDigitorumBrevisMusclesRef = "AntiBrachialFasciaMuscles";
	public final static String ExtensorDigitorumBrevisMuscle = "biomight.system.muscular.foot.AntiBrachialFasciaMuscle";
	public final static String ExtensorDigitorumBrevisMuscleRef = "AntiBrachialFasciaMuscle";

	public final static String AnteriorFacialVeins = "biomight.system.vascular.veins.head.AnteriorFacialVeins";
	public final static String AnteriorFacialVeinsRef = "AnteriorFacialVeins";
	public final static String AnteriorFacialVein = "biomight.system.vascular.veins.head.AnteriorFacialVein";
	public final static String AnteriorFacialVeinRef = "AnteriorFacialVein";

	public final static String ArachnoidGranulation = "biomight.system.vascular.veins.brain.ArachnoidGranulation";
	public final static String ArachnoidGranulationRef = "ArachnoidGranulation";

	public final static String MiddleTemporalVein = "biomight.system.vascular.veins.head.MiddleTemporalVein";
	public final static String MiddleTemporalVeinRef = "MiddleTemporalVein";

	public final static String InferiorCerebellarVein = "biomight.system.vascular.veins.brain.InferiorCerebellarVein";
	public final static String InferiorCerebellarVeinRef = "InferiorCerebellarVein";
	
	public final static String InferiorCerebralVein = "biomight.system.vascular.veins.brain.InferiorCerebralVein";
	public final static String InferiorCerebralVeinRef = "InferiorCerebralVein";
	
	public final static String InternalCerebralVein = "biomight.system.vascular.veins.brain.InternalCerebralVein";
	public final static String InternalCerebralVeinRef = "InferiorCerebralVein";

	public final static String TransverseSinus = "biomight.system.vascular.veins.head.TransverseSinus";
	public final static String TransverseSinusRef = "TransverseSinus";

	public final static String InterCavernousSinus = "biomight.system.vascular.veins.head.InterCavernousSinus";
	public final static String InterCavernousSinusRef = "InterCavernousSinus";
	
	public final static String BulboCavernosusMuscle = "biomight.system.muscular.perineum.BulboCavernosusMuscle";
	public final static String BulboCavernosusMuscleRef = "BulboCavernosusMuscle";


	// MUSCULAR - BACK
	public final static String InterSpinalesMuscle = "biomight.system.muscular.back.InterSpinalesMuscle";
	public final static String InterSpinalesMuscleRef = "InterSpinalesMuscle";
	public final static String InterSpinalesMuscles = "biomight.system.muscular.back.InterSpinalesMuscles";
	public final static String InterSpinalesMusclesRef = "InterSpinalesMuscles";
	
	public final static String InterTransversariiMuscle = "biomight.system.muscular.back.InterTransversariiMuscle";
	public final static String InterTransversariiMuscleRef = "InterTransversariiMuscle";
	public final static String InterTransversariiMuscles = "biomight.system.muscular.back.InterTransversariiMuscles";
	public final static String InterTransversariiMusclesRef = "InterTransversariiMuscles";

	public final static String MultifidusMuscle = "biomight.system.muscular.back.MultifidusMuscle";
	public final static String MultifidusMuscleRef = "MultifidusMuscle";
	public final static String MultifidusMuscles = "biomight.system.muscular.back.MultifidusMuscles";
	public final static String MultifidusMusclesRef = "MultifidusMuscles";

	public final static String RotatoresMuscle = "biomight.system.muscular.back.RotatoresMuscle";
	public final static String RotatoresMuscleRef = "RotatoresMuscle";
	public final static String RotatoresMuscles = "biomight.system.muscular.back.RotatoresMuscles";
	public final static String RotatoresMusclesRef = "RotatoresMuscles";

	public final static String SacroSpinalisMuscle = "biomight.system.muscular.back.SacroSpinalisMuscle";
	public final static String SacroSpinalisMuscleRef = "SacroSpinalisMuscle";
	public final static String SacroSpinalisMuscles = "biomight.system.muscular.back.SacroSpinalisMuscles";
	public final static String SacroSpinalisMusclesRef = "SacroSpinalisMuscles";

	public final static String SemiSpinalisMuscle = "biomight.system.muscular.back.SemiSpinalisMuscle";
	public final static String SemiSpinalisMuscleRef = "SemiSpinalisMuscle";
	public final static String SemiSpinalisMuscles = "biomight.system.muscular.back.SemiSpinalisMuscles";
	public final static String SemiSpinalisMusclesRef = "SemiSpinalisMuscles";

	public final static String SemiSpinalisCervicisMuscle = "biomight.system.muscular.back.SemiSpinalisCervicisMuscle";
	public final static String SemiSpinalisCervicisMuscleRef = "SemiSpinalisCervicisMuscle";
	public final static String SemiSpinalisCervicisMuscles = "biomight.system.muscular.back.SemiSpinalisCervicisMuscles";
	public final static String SemiSpinalisCervicisMusclesRef = "SemiSpinalisCervicisMuscles";

	
	public final static String SpleniusCapitisMuscle = "biomight.system.muscular.back.SpleniusCapitisMuscle";
	public final static String SpleniusCapitisMuscleRef = "SpleniusCapitisMuscle";
	public final static String SpleniusCapitisMuscles = "biomight.system.muscular.back.SpleniusCapitisMuscles";
	public final static String SpleniusCapitisMusclesRef = "SpleniusCapitisMuscles";

	public final static String SpleniusCervicisMuscle = "biomight.system.muscular.back.SpleniusCervicisMuscle";
	public final static String SpleniusCervicisMuscleRef = "SpleniusCervicisMuscle";
	public final static String SpleniusCervicisMuscles = "biomight.system.muscular.back.SpleniusCervicisMuscles";
	public final static String SpleniusCervicisMusclesRef = "SpleniusCervicisMuscles";
	
	public final static String SpinalisCapitisMuscle = "biomight.system.muscular.back.SpinalisCapitisMuscle";
	public final static String SpinalisCapitisMuscleRef = "SpinalisCapitisMuscle";
	public final static String SpinalisCapitisMuscles = "biomight.system.muscular.back.SpinalisCapitisMuscles";
	public final static String SpinalisCapitisMusclesRef = "SpinalisCapitisMuscles";
	
	public final static String SpinalisCervicisMuscle = "biomight.system.muscular.back.SpinalisCervicisMuscle";
	public final static String SpinalisCervicisMuscleRef = "SpinalisCervicisMuscle";
	public final static String SpinalisCervicisMuscles = "biomight.system.muscular.back.SpinalisCervicisMuscles";
	public final static String SpinalisCervicisMusclesRef = "SpinalisCervicisMuscles";
	
	public final static String SpinalisDorsiMuscle = "biomight.system.muscular.back.SpinalisDorsiMuscle";
	public final static String SpinalisDorsiMuscleRef = "SpinalisDorsiMuscle";
	public final static String SpinalisDorsiMuscles = "biomight.system.muscular.back.SpinalisDorsiMuscles";
	public final static String SpinalisDorsiMusclesRef = "SpinalisDorsiMuscles";
	
	public final static String SemiSpinalisDorsiMuscle = "biomight.system.muscular.back.SemiSpinalisDorsiMuscle";
	public final static String SemiSpinalisDorsiMuscleRef = "SemiSpinalisDorsiMuscle";
	public final static String SemiSpinalisDorsiMuscles = "biomight.system.muscular.back.SemiSpinalisDorsiMuscles";
	public final static String SemiSpinalisDorsiMusclesRef = "SemiSpinalisDorsiMuscles";
	
	public final static String SemiSpinalisCapitisMuscle = "biomight.system.muscular.back.SemiSpinalisCapitisMuscle";
	public final static String SemiSpinalisCapitisMuscleRef = "SemiSpinalisCapitisMuscle";
	public final static String SemiSpinalisCapitisMuscles = "biomight.system.muscular.back.SemiSpinalisCapitisMuscles";
	public final static String SemiSpinalisCapitisMusclesRef = "SemiSpinalisCapitisMuscles";
	
	
	
	
	public final static String LongissimusDorsiMuscle = "biomight.system.muscular.back.LongissimusDorsiMuscle";
	public final static String LongissimusDorsiMuscleRef = "LongissimusDorsiMuscle";
	public final static String LongissimusDorsiMuscles = "biomight.system.muscular.back.LongissimusDorsiMuscles";
	public final static String LongissimusDorsiMusclesRef = "LongissimusDorsiMuscles";
	
	
	public final static String RotatoresSpinaeMuscle = "biomight.system.muscular.back.RotatoresSpinaeMuscle";
	public final static String RotatoresSpinaeMuscleRef = "RotatoresSpinaeMuscle";
	public final static String RotatoresSpinaeMuscles = "biomight.system.muscular.back.RotatoresSpinaeMuscles";
	public final static String RotatoresSpinaeMusclesRef = "RotatoresSpinaeMusclesRef";

	// There are 11 pair of Rotatores
	public final static String RotatoresSpinaeMuscleLeft1 = "biomight.system.muscular.back.RotatoresSpinaeMuscleLeft1";
	public final static String RotatoresSpinaeMuscleLeft2 = "biomight.system.muscular.back.RotatoresSpinaeMuscleLeft2";
	public final static String RotatoresSpinaeMuscleLeft3 = "biomight.system.muscular.back.RotatoresSpinaeMuscleLeft3";
	public final static String RotatoresSpinaeMuscleLeft4 = "biomight.system.muscular.back.RotatoresSpinaeMuscleLeft4";
	public final static String RotatoresSpinaeMuscleLeft5 = "biomight.system.muscular.back.RotatoresSpinaeMuscleLeft5";
	public final static String RotatoresSpinaeMuscleLeft6 = "biomight.system.muscular.back.RotatoresSpinaeMuscleLeft6";
	public final static String RotatoresSpinaeMuscleLeft7 = "biomight.system.muscular.back.RotatoresSpinaeMuscleLeft7";
	public final static String RotatoresSpinaeMuscleLeft8 = "biomight.system.muscular.back.RotatoresSpinaeMuscleLeft8";
	public final static String RotatoresSpinaeMuscleLeft9 = "biomight.system.muscular.back.RotatoresSpinaeMuscleLeft9";
	public final static String RotatoresSpinaeMuscleLeft10 = "biomight.system.muscular.back.RotatoresSpinaeMuscleLeft10";
	public final static String RotatoresSpinaeMuscleLeft11 = "biomight.system.muscular.back.RotatoresSpinaeMuscleLeft11";
	public final static String RotatoresSpinaeMuscleRight1 = "biomight.system.muscular.back.RotatoresSpinaeMuscleRight1";
	public final static String RotatoresSpinaeMuscleRight2 = "biomight.system.muscular.back.RotatoresSpinaeMuscleRight2";
	public final static String RotatoresSpinaeMuscleRight3 = "biomight.system.muscular.back.RotatoresSpinaeMuscleRight3";
	public final static String RotatoresSpinaeMuscleRight4 = "biomight.system.muscular.back.RotatoresSpinaeMuscleRight4";
	public final static String RotatoresSpinaeMuscleRight5 = "biomight.system.muscular.back.RotatoresSpinaeMuscleRight5";
	public final static String RotatoresSpinaeMuscleRight6 = "biomight.system.muscular.back.RotatoresSpinaeMuscleRight6";
	public final static String RotatoresSpinaeMuscleRight7 = "biomight.system.muscular.back.RotatoresSpinaeMuscleRight7";
	public final static String RotatoresSpinaeMuscleRight8 = "biomight.system.muscular.back.RotatoresSpinaeMuscleRight8";
	public final static String RotatoresSpinaeMuscleRight9 = "biomight.system.muscular.back.RotatoresSpinaeMuscleRight9";
	public final static String RotatoresSpinaeMuscleRight10 = "biomight.system.muscular.back.RotatoresSpinaeMuscleRight10";
	public final static String RotatoresSpinaeMuscleRight11 = "biomight.system.muscular.back.RotatoresSpinaeMuscleRight11";
	

	public final static String IliocostalisDorsiMuscle = "biomight.system.muscular.back.IliocostalisDorsiMuscle";
	public final static String IliocostalisDorsiMuscleRef = "IliocostalisDorsiMuscle";
	public final static String IliocostalisDorsiMuscles = "biomight.system.muscular.back.IliocostalisDorsiMuscles";
	public final static String IliocostalisDorsiMusclesRef = "IliocostalisDorsiMuscles";
	public final static String IliocostalisDorsiRightMuscle = "biomight.system.muscular.back.IliocostalisDorsiRightMuscle";
	public final static String IliocostalisDorsiRightMuscleRef = "IliocostalisDorsiRightMuscle";
	//public final static String IliocostalisDorsiRightMuscles = "biomight.system.muscular.back.IliocostalisDorsiRightMuscles";
	//public final static String IliocostalisDorsiRightMusclesRef = "IliocostalisDorsiRightMuscles";

	public final static String IliocostalisDorsiLeftMuscle = "biomight.system.muscular.back.IliocostalisDorsiLeftMuscle";
	public final static String IliocostalisDorsiLeftMuscleRef = "IliocostalisDorsiLeftMuscle";
	//public final static String IliocostalisDorsiLeftMuscles = "biomight.system.muscular.back.IliocostalisDorsiLeftMuscles";
	//public final static String IliocostalisDorsiLeftMusclesRef = "IliocostalisDorsiLeftMuscles";

	public final static String IliocostalisLumborumMuscle = "biomight.system.muscular.back.IliocostalisLumborumMuscle";
	public final static String IliocostalisLumborumMuscleRef = "IliocostalisLumborumMuscle";
	public final static String IliocostalisLumborumMuscles = "biomight.system.muscular.back.IliocostalisLumborumMuscles";
	public final static String IliocostalisLumborumMusclesRef = "IliocostalisLumborumMuscles";
	public final static String IliocostalisLumborumLeftMuscle = "biomight.system.muscular.back.IliocostalisLumborumMuscle";
	public final static String IliocostalisLumborumRightMuscle = "biomight.system.muscular.back.IliocostalisCervicisMuscle";

	public final static String IliocostalisCervicisMuscle = "biomight.system.muscular.back.IliocostalisCervicisMuscle";
	public final static String IliocostalisCervicisMuscleRef = "IliocostalisCervicisMuscle";
	public final static String IliocostalisCervicisMuscles = "biomight.system.muscular.back.IliocostalisCervicisMuscles";
	public final static String IliocostalisCervicisMusclesRef = "IliocostalisCervicisMuscles";
	public final static String IliocostalisCervicisRightMuscle = "biomight.system.muscular.back.IliocostalisCervicisRightMuscle";
	public final static String IliocostalisCervicisLeftMuscle = "biomight.system.muscular.back.IliocostalisCervicisLeftMuscle";

	public final static String InterTransversariiAnterioresMuscle = "biomight.system.muscular.back.InterTransversariiAnterioresMuscle";
	public final static String InterTransversariiAnterioresMuscleRef = "InterTransversariiAnterioresMuscle";
	public final static String InterTransversariiAnterioresMuscles = "biomight.system.muscular.back.InterTransversariiAnterioresMuscles";
	public final static String InterTransversariiAnterioresMusclesRef = "InterTransversariiAnterioresMuscles";
	public final static String InterTransversariiAnterioresLeftMuscle = "biomight.system.muscular.back.InterTransversariiAnterioresLeftMuscle";
	public final static String InterTransversariiAnterioresRightMuscle = "biomight.system.muscular.back.InterTransversariiAnterioresRightMuscle";

	public final static String LongissimusCapitisMuscle = "biomight.system.muscular.LongissimusCapitisMuscle";
	public final static String LongissimusCapitisMuscleRef = "LongissimusCapitisMuscle";
	public final static String LongissimusCapitisMuscles = "biomight.system.muscular.back.LongissimusCapitisLeftMuscle";
	public final static String LongissimusCapitisMusclesRef = "LongissimusCapitisLeftMuscle";
	public final static String LongissimusCapitisLeftMuscle = "biomight.system.muscular.back.LongissimusCapitisLeftMuscle";
	public final static String LongissimusCapitisRightMuscle = "biomight.system.muscular.back.LongissimusCapitisRightMuscle";
	
	public final static String LongissimusCervicisMuscle = "biomight.system.muscular.LongissimusCervicisMuscle";
	public final static String LongissimusCervicisMuscleRef = "LongissimusCervicisMuscle";
	public final static String LongissimusCervicisMuscles = "biomight.system.muscular.LongissimusCervicisMuscles";
	public final static String LongissimusCervicisMusclesRef = "LongissimusCervicisMuscles";
	public final static String LongissimusCervicisLeftMuscle = "biomight.system.muscular.back.LongissimusCervicisLeftMuscle";
	public final static String LongissimusCervicisRightMuscle = "biomight.system.muscular.back.LongissimusCervicisRightMuscle";
	
	public final static String LongissimusDorsiLeftMuscle = "biomight.system.muscular.back.LongissimusDorsiLeftMuscle";
	public final static String LongissimusDorsiRightMuscle = "biomight.system.muscular.back.LongissimusDorsiRightMuscle";
	
	public final static String LongissimusThoracisMuscles = "biomight.system.muscular.back.LongissimusThoracisMuscles";
	public final static String LongissimusThoracisMusclesRef = "LongissimusThoracisMuscles";

	public final static String LongissimusThoracisMuscle = "biomight.system.muscular.back.LongissimusThoracisMuscle";
	public final static String LongissimusThoracisMuscleRef = "LongissimusThoracisMuscle";

	public final static String LongRotatorsMuscle = "biomight.system.muscular.LongRotatorsMuscle";
	public final static String LongRotatorsMuscleRef = "LongRotatorsMuscle";

	
	// MUSCULAR - CHEST
	public final static String CoracoBrachialisMuscle = "biomight.system.muscular.chest.CoracoBrachialisMuscle";
	public final static String CoracoBrachialisMuscleRef = "CoracoBrachialisMuscle";
	
	public final static String DiaphragmMuscle = "biomight.system.muscular.chest.DiaphragmMuscle";
	public final static String DiaphragmMuscleRef = "DiaphragmMuscle";

	public final static String DiaphragmMuscles = "biomight.system.muscular.chest.DiaphragmMuscles";
	public final static String DiaphragmMusclesRef = "DiaphragmMuscles";

	public final static String PectoralisMajorMuscle = "biomight.system.muscular.chest.PectoralisMajorMuscle";
	public final static String PectoralisMajorMuscleRef = "PectoralisMajorMuscle";
	
	public final static String PectoralisMajorMuscles = "biomight.system.muscular.chest.PectoralisMajorMuscles";
	public final static String PectoralisMajorMusclesRef = "PectoralisMajorMuscles";
	
	public final static String PectoralisMinorMuscle = "biomight.system.muscular.chest.PectoralisMajorMuscle";
	public final static String PectoralisMinorMuscleRef = "PectoralisMinorMuscle";
	
	public final static String PectoralisMinorMuscles = "biomight.system.muscular.chest.PectoralisMajorMuscles";
	public final static String PectoralisMinorMusclesRef = "PectoralisMinorMuscles";
	
	public final static String IntercostalesExterniMuscle = "biomight.system.muscular.chest.IntercostalesExterniMuscle";
	public final static String IntercostalesExterniMuscleRef = "IntercostalesExterniMuscle";
	public final static String IntercostalesExterniMuscles = "biomight.system.muscular.chest.IntercostalesExterniMuscles";
	public final static String IntercostalesExterniMusclesRef = "IntercostalesExterniMuscles";

	// When accessing the individual elements in a normalized model
	public final static String IntercostalesExterniMuscleLeft1 = "biomight.system.muscular.chest.IntercostalesExterniMuscleLeft1";
	public final static String IntercostalesExterniMuscleLeft2 = "biomight.system.muscular.chest.IntercostalesExterniMuscleLeft2";
	public final static String IntercostalesExterniMuscleLeft3 = "biomight.system.muscular.chest.IntercostalesExterniMuscleLeft3";
	public final static String IntercostalesExterniMuscleLeft4 = "biomight.system.muscular.chest.IntercostalesExterniMuscleLeft4";
	public final static String IntercostalesExterniMuscleLeft5 = "biomight.system.muscular.chest.IntercostalesExterniMuscleLeft5";
	public final static String IntercostalesExterniMuscleLeft6 = "biomight.system.muscular.chest.IntercostalesExterniMuscleLeft6";
	public final static String IntercostalesExterniMuscleLeft7 = "biomight.system.muscular.chest.IntercostalesExterniMuscleLeft7";
	public final static String IntercostalesExterniMuscleLeft8 = "biomight.system.muscular.chest.IntercostalesExterniMuscleLeft8";
	public final static String IntercostalesExterniMuscleLeft9 = "biomight.system.muscular.chest.IntercostalesExterniMuscleLeft9";
	public final static String IntercostalesExterniMuscleLeft10 = "biomight.system.muscular.chest.IntercostalesExterniMuscleLeft10";
	public final static String IntercostalesExterniMuscleLeft11 = "biomight.system.muscular.chest.IntercostalesExterniMuscleLeft11";
	public final static String IntercostalesExterniMuscleRight1 = "biomight.system.muscular.chest.IntercostalesExterniMuscleRight1";
	public final static String IntercostalesExterniMuscleRight2 = "biomight.system.muscular.chest.IntercostalesExterniMuscleRight2";
	public final static String IntercostalesExterniMuscleRight3 = "biomight.system.muscular.chest.IntercostalesExterniMuscleRight3";
	public final static String IntercostalesExterniMuscleRight4 = "biomight.system.muscular.chest.IntercostalesExterniMuscleRight4";
	public final static String IntercostalesExterniMuscleRight5 = "biomight.system.muscular.chest.IntercostalesExterniMuscleRight5";
	public final static String IntercostalesExterniMuscleRight6 = "biomight.system.muscular.chest.IntercostalesExterniMuscleRight6";
	public final static String IntercostalesExterniMuscleRight7 = "biomight.system.muscular.chest.IntercostalesExterniMuscleRight7";
	public final static String IntercostalesExterniMuscleRight8 = "biomight.system.muscular.chest.IntercostalesExterniMuscleRight8";
	public final static String IntercostalesExterniMuscleRight9 = "biomight.system.muscular.chest.IntercostalesExterniMuscleRight9";
	public final static String IntercostalesExterniMuscleRight10 = "biomight.system.muscular.chest.IntercostalesExterniMuscleRight10";
	public final static String IntercostalesExterniMuscleRight11 = "biomight.system.muscular.chest.IntercostalesExterniMuscle11";
	

	public final static String IntercostalesInterniMuscle = "biomight.system.muscular.chest.IntercostalesInterniMuscle";
	public final static String IntercostalesInterniMuscleRef = "IntercostalesInterniMuscle";
	public final static String IntercostalesInterniMuscles = "biomight.system.muscular.chest.IntercostalesInterniMuscles";
	public final static String IntercostalesInterniMusclesRef = "IntercostalesInterniMuscles";
	
	
	public final static String IntercostalesInterniMuscleLeft1 = "biomight.system.muscular.chest.IntercostalesInterniMuscleLeft1";
	public final static String IntercostalesInterniMuscleLeft2 = "biomight.system.muscular.chest.IntercostalesInterniMuscleLeft2";
	public final static String IntercostalesInterniMuscleLeft3 = "biomight.system.muscular.chest.IntercostalesInterniMuscleLeft3";
	public final static String IntercostalesInterniMuscleLeft4 = "biomight.system.muscular.chest.IntercostalesInterniMuscleLeft4";
	public final static String IntercostalesInterniMuscleLeft5 = "biomight.system.muscular.chest.IntercostalesInterniMuscleLeft5";
	public final static String IntercostalesInterniMuscleLeft6 = "biomight.system.muscular.chest.IntercostalesInterniMuscleLeft6";
	public final static String IntercostalesInterniMuscleLeft7 = "biomight.system.muscular.chest.IntercostalesInterniMuscleLeft7";
	public final static String IntercostalesInterniMuscleLeft8 = "biomight.system.muscular.chest.IntercostalesInterniMuscleLeft8";
	public final static String IntercostalesInterniMuscleLeft9 = "biomight.system.muscular.chest.IntercostalesInterniMuscleLeft9";
	public final static String IntercostalesInterniMuscleLeft10 = "biomight.system.muscular.chest.IntercostalesInterniMuscleLeft10";
	public final static String IntercostalesInterniMuscleLeft11 = "biomight.system.muscular.chest.IntercostalesInterniMuscleLeft11";
	public final static String IntercostalesInterniMuscleRight1 = "biomight.system.muscular.chest.IntercostalesInterniMuscleRight1";
	public final static String IntercostalesInterniMuscleRight2 = "biomight.system.muscular.chest.IntercostalesInterniMuscleRight2";
	public final static String IntercostalesInterniMuscleRight3 = "biomight.system.muscular.chest.IntercostalesInterniMuscleRight3";
	public final static String IntercostalesInterniMuscleRight4 = "biomight.system.muscular.chest.IntercostalesInterniMuscleRight4";
	public final static String IntercostalesInterniMuscleRight5 = "biomight.system.muscular.chest.IntercostalesInterniMuscleRight5";
	public final static String IntercostalesInterniMuscleRight6 = "biomight.system.muscular.chest.IntercostalesInterniMuscleRight6";
	public final static String IntercostalesInterniMuscleRight7 = "biomight.system.muscular.chest.IntercostalesInterniMuscleRight7";
	public final static String IntercostalesInterniMuscleRight8 = "biomight.system.muscular.chest.IntercostalesInterniMuscleRight8";
	public final static String IntercostalesInterniMuscleRight9 = "biomight.system.muscular.chest.IntercostalesInterniMuscleRight9";
	public final static String IntercostalesInterniMuscleRight10 = "biomight.system.muscular.chest.IntercostalesInterniMuscleRight10";
	public final static String IntercostalesInterniMuscleRight11 = "biomight.system.muscular.chest.IntercostalesInterniMuscle11";
	
	
	public final static String LevatoresCostarumMuscle = "biomight.system.muscular.chest.LevatoresCostarumMuscle";
	public final static String LevatoresCostarumMuscleRef = "LevatoresCostarumMuscle";
	public final static String LevatoresCostarumMuscles = "biomight.system.muscular.chest.LevatoresCostarumMuscles";
	public final static String LevatoresCostarumMusclesRef = "LevatoresCostarumMuscles";
	
	
	public final static String LevatoresCostarumMuscleLeft1 = "biomight.system.muscular.chest.LevatoresCostarumMuscleLeft1";
	public final static String LevatoresCostarumMuscleLeft2 = "biomight.system.muscular.chest.LevatoresCostarumMuscleLeft2";
	public final static String LevatoresCostarumMuscleLeft3 = "biomight.system.muscular.chest.LevatoresCostarumMuscleLeft3";
	public final static String LevatoresCostarumMuscleLeft4 = "biomight.system.muscular.chest.LevatoresCostarumMuscleLeft4";
	public final static String LevatoresCostarumMuscleLeft5 = "biomight.system.muscular.chest.LevatoresCostarumMuscleLeft5";
	public final static String LevatoresCostarumMuscleLeft6 = "biomight.system.muscular.chest.LevatoresCostarumMuscleLeft6";
	public final static String LevatoresCostarumMuscleLeft7 = "biomight.system.muscular.chest.LevatoresCostarumMuscleLeft7";
	public final static String LevatoresCostarumMuscleLeft8 = "biomight.system.muscular.chest.LevatoresCostarumMuscleLeft8";
	public final static String LevatoresCostarumMuscleLeft9 = "biomight.system.muscular.chest.LevatoresCostarumMuscleLeft9";
	public final static String LevatoresCostarumMuscleLeft10 = "biomight.system.muscular.chest.LevatoresCostarumMuscleLeft10";
	public final static String LevatoresCostarumMuscleLeft11 = "biomight.system.muscular.chest.LevatoresCostarumMuscleLeft11";
	public final static String LevatoresCostarumMuscleLeft12 = "biomight.system.muscular.chest.LevatoresCostarumMuscleLeft12";
	public final static String LevatoresCostarumMuscleRight1 = "biomight.system.muscular.chest.LevatoresCostarumMuscleRight1";
	public final static String LevatoresCostarumMuscleRight2 = "biomight.system.muscular.chest.LevatoresCostarumMuscleRight2";
	public final static String LevatoresCostarumMuscleRight3 = "biomight.system.muscular.chest.LevatoresCostarumMuscleRight3";
	public final static String LevatoresCostarumMuscleRight4 = "biomight.system.muscular.chest.LevatoresCostarumMuscleRight4";
	public final static String LevatoresCostarumMuscleRight5 = "biomight.system.muscular.chest.LevatoresCostarumMuscleRight5";
	public final static String LevatoresCostarumMuscleRight6 = "biomight.system.muscular.chest.LevatoresCostarumMuscleRight6";
	public final static String LevatoresCostarumMuscleRight7 = "biomight.system.muscular.chest.LevatoresCostarumMuscleRight7";
	public final static String LevatoresCostarumMuscleRight8 = "biomight.system.muscular.chest.LevatoresCostarumMuscleRight8";
	public final static String LevatoresCostarumMuscleRight9 = "biomight.system.muscular.chest.LevatoresCostarumMuscleRight9";
	public final static String LevatoresCostarumMuscleRight10 = "biomight.system.muscular.chest.LevatoresCostarumMuscleRight10";
	public final static String LevatoresCostarumMuscleRight11 = "biomight.system.muscular.chest.LevatoresCostarumMuscle11";
	public final static String LevatoresCostarumMuscleRight12 = "biomight.system.muscular.chest.LevatoresCostarumMuscle12";
	
	
	public final static String SerratusPosteriorInferiorMuscle = "biomight.system.muscular.chest.SerratusPosteriorInferiorMuscle";
	public final static String SerratusPosteriorInferiorMuscleRef = "SerratusPosteriorInferiorMuscle";
	public final static String SerratusPosteriorInferiorMuscles = "biomight.system.muscular.chest.SerratusPosteriorInferiorMuscles";
	public final static String SerratusPosteriorInferiorMusclesRef = "SerratusPosteriorInferiorMuscles";

	public final static String SerratusPosteriorSuperiorMuscle = "biomight.system.muscular.chest.SerratusPosteriorSuperiorMuscle";
	public final static String SerratusPosteriorSuperiorMuscleRef = "SerratusPosteriorSuperiorMuscle";
	public final static String SerratusPosteriorSuperiorMuscles = "biomight.system.muscular.chest.SerratusPosteriorSuperiorMuscles";
	public final static String SerratusPosteriorSuperiorMusclesRef = "SerratusPosteriorSuperiorMuscles";

	public final static String SubcostalisMuscle = "biomight.system.muscular.chest.SubcostalisMuscle";
	public final static String SubcostalisMuscleRef = "SubcostalisMuscle";
	public final static String SubcostalisMuscles = "biomight.system.muscular.chest.SubcostalisMuscles";
	public final static String SubcostalisMusclesRef = "SubcostalisMuscles";
	
	public final static String TransversusThoracisMuscle = "biomight.system.muscular.chest.TransversusThoracisMuscle";
	public final static String TransversusThoracisMuscleRef = "TransversusThoracisMuscle";
	public final static String TransversusThoracisMuscles = "biomight.system.muscular.chest.TransversusThoracisMuscles";
	public final static String TransversusThoracisMusclesRef = "TransversusThoracisMuscles";


	// MUSCULAR - HIP
	public final static String AdductorBrevisMuscles = "biomight.system.muscular.leg.thigh.AdductorBrevisMuscles";
	public final static String AdductorBrevisMusclesRef = "AdductorBrevisMuscles";

	public final static String AdductorBrevisMuscle = "biomight.system.muscular.leg.thigh.AdductorBrevisMuscle";
	public final static String AdductorBrevisMuscleRef = "AdductorBrevisMuscle";
	
	public final static String AdductorMagnusMuscles = "biomight.system.muscular.leg.thigh.AdductorMagnusMuscles";
	public final static String AdductorMagnusMusclesRef = "AdductorMagnusMuscles";

	public final static String AdductorMagnusMuscle = "biomight.system.muscular.leg.thigh.AdductorMagnusMuscle";
	public final static String AdductorMagnusMuscleRef = "AdductorMagnusMuscle";

	public final static String ArticularisGenusMuscles = "biomight.system.muscular.hip.ArticularisGenusMuscles";
	public final static String ArticularisGenusMusclesRef = "ArticularisGenusMuscles";

	public final static String ArticularisGenusMuscle = "biomight.system.muscular.hip.ArticularisGenusMuscle";
	public final static String ArticularisGenusMuscleRef = "ArticularisGenusMuscle";

	public final static String CoccygeusMuscles = "biomight.system.muscular.hip.CoccygeusMuscles";
	public final static String CoccygeusMusclesRef = "CoccygeusMuscles";

	public final static String CoccygeusMuscle = "biomight.system.muscular.hip.CoccygeusMuscle";
	public final static String CoccygeusMuscleRef = "CoccygeusMuscle";

	public final static String GemelliMuscles = "biomight.system.muscular.hip.GemelliMuscles";
	public final static String GemelliMusclesRef = "GemelliMuscles";

	public final static String GemelliMuscle = "biomight.system.muscular.hip.GemelliMuscle";
	public final static String GemelliMuscleRef = "GemelliMuscle";

	public final static String GluteusMaximusMuscles = "biomight.system.muscular.hip.GluteusMaximusMuscles";
	public final static String GluteusMaximusMusclesRef = "GluteusMaximusMuscles";

	public final static String GluteusMaximusMuscle = "biomight.system.muscular.hip.GluteusMaximusMuscle";
	public final static String GluteusMaximusMuscleRef = "GluteusMaximusMuscle";
	
	
	public final static String IliacusMuscle = "biomight.system.muscular.hip.IliacusMuscle";
	public final static String IliacusMuscleRef = "IliacusMuscle";
	public final static String IliopsoasMuscle = "biomight.system.muscular.hip.IliopsoasMuscle";
	public final static String IliopsoasMuscleRef = "IliopsoasMuscle";
	public final static String IlotibialTractMuscle = "biomight.system.muscular.hip.IlotibialTractMuscle";
	public final static String IlotibialTractMuscleRef = "IlotibialTractMuscle";
	public final static String InferiorGemelliMuscle = "biomight.system.muscular.hip.InferiorGemelliMuscle";
	public final static String InferiorGemelliMuscleRef = ".InferiorGemelliMuscle";
	public final static String PiriformisMuscle = "biomight.system.muscular.hip.PiriformisMuscle";
	public final static String PiriformisMuscleRef = "PiriformisMuscle";
	public final static String SuperiorGemelliMuscle = "biomight.system.muscular.hip.SuperiorGemelliMuscle";
	public final static String SuperiorGemelliMuscleRef = "SuperiorGemelliMuscle";
	public final static String TensorFasciaeLataMuscle = "biomight.system.muscular.hip.TensorFasciaeLataMuscle";
	public final static String TensorFasciaeLataMuscleRef = "TensorFasciaeLataMuscle";
		
	// biomight.system.muscular.leg.cnemus
	public final static String ExtensorDigitorumLongusMuscles = "biomight.system.muscular.leg.cnemus.ExtensorDigitorumLongusMuscles";
	public final static String ExtensorDigitorumLongusMusclesRef = "ExtensorDigitorumLongusMuscles";

	public final static String ExtensorDigitorumLongusMuscle = "biomight.system.muscular.leg.cnemus.ExtensorDigitorumLongusMuscle";
	public final static String ExtensorDigitorumLongusMuscleRef = "ExtensorDigitorumLongusMuscle";

	public final static String ExtensorHallicusLongusMuscles = "biomight.system.muscular.leg.cnemus.ExtensorHallicusLongusMuscles";
	public final static String ExtensorHallicusLongusMusclesRef = "ExtensorHallicusLongusMuscles";

	public final static String ExtensorHallicusLongusMuscle = "biomight.system.muscular.leg.cnemus.ExtensorHallicusLongusMuscle";
	public final static String ExtensorHallicusLongusMuscleRef = "ExtensorHallicusLongusMuscle";

	public final static String FlexorDigitorumLongusMuscles = "biomight.system.muscular.leg.cnemus.FlexorDigitorumLongusMuscles";
	public final static String FlexorDigitorumLongusMusclesRef = "FlexorDigitorumLongusMuscles";

	public final static String FlexorDigitorumLongusMuscle = "biomight.system.muscular.leg.cnemus.FlexorDigitorumLongusMuscle";
	public final static String FlexorDigitorumLongusMuscleRef = "FlexorDigitorumLongusMuscle";

	public final static String FlexorHallicusLongusMuscles = "biomight.system.muscular.leg.cnemus.FlexorHallicusLongusMuscles";
	public final static String FlexorHallicusLongusMusclesRef = "FlexorHallicusLongusMuscles";

	public final static String FlexorHallicusLongusMuscle = "biomight.system.muscular.leg.cnemus.FlexorHallicusLongusMuscle";
	public final static String FlexorHallicusLongusMuscleRef = "FlexorHallicusLongusMuscle";

	public final static String GastrocnemiusMuscles = "biomight.system.muscular.leg.cnemus.GastrocnemiusMuscles";
	public final static String GastrocnemiusMusclesRef = "GastrocnemiusMuscles";

	public final static String GastrocnemiusMuscle = "biomight.system.muscular.leg.cnemus.GastrocnemiusMuscle";
	public final static String GastrocnemiusMuscleRef = "GastrocnemiusMuscle";

	public final static String PeroneusLongusMuscles = "biomight.system.muscular.leg.cnemus.PeroneusLongusMuscles";
	public final static String PeroneusLongusMusclesRef = "PeroneusLongusMuscles";
	
	public final static String PeroneusLongusMuscle = "biomight.system.muscular.leg.cnemus.PeroneusLongusMuscle";
	public final static String PeroneusLongusMuscleRef = "PeroneusLongusMuscle";
	
	public final static String PeroneusTertiusMuscles = "biomight.system.muscular.leg.cnemus.PeroneusTertiusMuscles";
	public final static String PeroneusTertiusMusclesRef = "PeroneusTertiusMuscles";
	
	public final static String PeroneusTertiusMuscle = "biomight.system.muscular.leg.cnemus.PeroneusTertiusMuscle";
	public final static String PeroneusTertiusMuscleRef = "PeroneusTertiusMuscle";
	
	public final static String PeroneusBrevisMuscles = "biomight.system.muscular.leg.cnemus.PeroneusBrevisMuscles";
	public final static String PeroneusBrevisMusclesRef = "PeroneusBrevisMuscles";
	
	public final static String PeroneusBrevisMuscle = "biomight.system.muscular.leg.cnemus.PeroneusBrevisMuscle";
	public final static String PeroneusBrevisMuscleRef = "PeroneusBrevisMuscle";
	
	public final static String PlantarisMuscles = "biomight.system.muscular.leg.cnemus.PlantarisMuscles";
	public final static String PlantarisMusclesRef = "PlantarisMuscles";

	public final static String PlantarisMuscle = "biomight.system.muscular.leg.cnemus.PlantarisMuscle";
	public final static String PlantarisMuscleRef = "PlantarisMuscle";

	public final static String SoleusMuscles = "biomight.system.muscular.leg.cnemus.SoleusMuscles";
	public final static String SoleusMusclesRef = "SoleusMuscles";
	
	public final static String SoleusMuscle = "biomight.system.muscular.leg.cnemus.SoleusMuscle";
	public final static String SoleusMuscleRef = "SoleusMuscle";
	
	public final static String TibialisAnteriorMuscles = "biomight.system.muscular.leg.cnemus.TibialisAnteriorMuscles";
	public final static String TibialisAnteriorMusclesRef = "TibialisAnteriorMuscles";

	public final static String TibialisAnteriorMuscle = "biomight.system.muscular.leg.cnemus.TibialisAnteriorMuscle";
	public final static String TibialisAnteriorMuscleRef = "TibialisAnteriorMuscle";

	public final static String TibialisPosteriorMuscles = "biomight.system.muscular.leg.cnemus.TibialisPosteriorMuscles";
	public final static String TibialisPosteriorMusclesRef = "TibialisPosteriorMuscles";

	public final static String TibialisPosteriorMuscle = "biomight.system.muscular.leg.cnemus.TibialisPosteriorMuscle";
	public final static String TibialisPosteriorMuscleRef = "TibialisPosteriorMuscle";

	// biomight.system.muscular.leg.thigh
	public final static String AdductorLongusMuscles = "biomight.system.muscular.leg.thigh.AdductorLongusMuscles";
	public final static String AdductorLongusMusclesRef = "AdductorLongusMuscles";

	public final static String AdductorLongusMuscle = "biomight.system.muscular.leg.thigh.AdductorLongusMuscle";
	public final static String AdductorLongusMuscleRef = "AdductorLongusMuscle";
	
	public final static String BicepsFemorisMuscles = "biomight.system.muscular.leg.thigh.BicepsFemorisMuscles";
	public final static String BicepsFemorisMusclesRef = "BicepsFemorisMuscles";

	public final static String BicepsFemorisMuscle = "biomight.system.muscular.leg.thigh.BicepsFemorisMuscle";
	public final static String BicepsFemorisMuscleRef = "BicepsFemorisMuscle";
			
	//public final static String GluteusMaximusMuscle = "biomight.system.muscular.leg.thigh.GluteusMaximusMuscle";
	
	public final static String GluteusMediusMuscles = "biomight.system.muscular.leg.thigh.GluteusMediusMuscles";
	public final static String GluteusMediusMusclesRef = "GluteusMediusMuscles";
	
	public final static String GluteusMediusMuscle = "biomight.system.muscular.leg.thigh.GluteusMediusMuscle";
	public final static String GluteusMediusMuscleRef = "GluteusMediusMuscle";

	public final static String GluteusMinimusMuscles = "biomight.system.muscular.leg.thigh.GluteusMinimusMuscles";
	public final static String GluteusMinimusMusclesRef = "GluteusMinimusMuscles";

	public final static String GluteusMinimusMuscle = "biomight.system.muscular.leg.thigh.GluteusMinimusMuscle";
	public final static String GluteusMinimusMuscleRef = "GluteusMinimusMuscle";
	
	public final static String GracilisMuscles = "biomight.system.muscular.leg.thigh.GracilisMuscles";
	public final static String GracilisMusclesRef = "GracilisMuscles";
	
	public final static String GracilisMuscle = "biomight.system.muscular.leg.thigh.GracilisMuscle";
	public final static String GracilisMuscleRef = "GracilisMuscle";
	
	public final static String ObturatorExternusMuscles = "biomight.system.muscular.leg.thigh.ObturatorExternusMuscles";
	public final static String ObturatorExternusMusclesRef = "ObturatorExternusMuscles";

	public final static String ObturatorExternusMuscle = "biomight.system.muscular.leg.thigh.ObturatorExternusMuscle";
	public final static String ObturatorExternusMuscleRef = "ObturatorExternusMuscle";
	
	public final static String ObturatorInternusMuscles = "biomight.system.muscular.leg.thigh.ObturatorInternusMuscles";
	public final static String ObturatorInternusMusclesRef = "ObturatorInternusMuscles";

	public final static String ObturatorInternusMuscle = "biomight.system.muscular.leg.thigh.ObturatorInternusMuscle";
	public final static String ObturatorInternusMuscleRef = "ObturatorInternusMuscle";

	public final static String PectineusMuscles = "biomight.system.muscular.leg.thigh.PectineusMuscles";
	public final static String PectineusMusclesRef = "PectineusMuscles";
	
	public final static String PectineusMuscle = "biomight.system.muscular.leg.thigh.PectineusMuscle";
	public final static String PectineusMuscleRef = "PectineusMuscle";
	
	public final static String PopliteusMuscles = "biomight.system.muscular.leg.thigh.PopliteusMuscles";
	public final static String PopliteusMusclesRef = "PopliteusMuscles";
	
	public final static String PopliteusMuscle = "biomight.system.muscular.leg.thigh.PopliteusMuscle";
	public final static String PopliteusMuscleRef = "PopliteusMuscle";
	
	public final static String QuadricepsFemorisMuscles = "biomight.system.muscular.leg.thigh.QuadricepsFemorisMuscles";
	public final static String QuadricepsFemorisMusclesRef = "QuadricepsFemorisMuscles";

	public final static String QuadricepsFemorisMuscle = "biomight.system.muscular.leg.thigh.QuadricepsFemorisMuscle";
	public final static String QuadricepsFemorisMuscleRef = "QuadricepsFemorisMuscle";
	
	public final static String RectusFemorisMuscles = "biomight.system.muscular.leg.thigh.RectusFemorisMuscles";
	public final static String RectusFemorisMusclesRef = "RectusFemorisMuscles";
	
	public final static String RectusFemorisMuscle = "biomight.system.muscular.leg.thigh.RectusFemorisMuscle";
	public final static String RectusFemorisMuscleRef = "RectusFemorisMuscle";
	
	public final static String SartoriusMuscles = "biomight.system.muscular.leg.thigh.SartoriusMuscles";
	public final static String SartoriusMusclesRef = "SartoriusMuscles";
	
	public final static String SartoriusMuscle = "biomight.system.muscular.leg.thigh.SartoriusMuscle";
	public final static String SartoriusMuscleRef = "SartoriusMuscle";
	
	public final static String SemiMembranosusMuscles = "biomight.system.muscular.leg.thigh.SemiMembranosusMuscles";
	public final static String SemiMembranosusMusclesRef = "SemiMembranosusMuscles";
	
	public final static String SemiMembranosusMuscle = "biomight.system.muscular.leg.thigh.SemiMembranosusMuscle";
	public final static String SemiMembranosusMuscleRef = "SemiMembranosusMuscle";

	public final static String SemitendinosusMuscles = "biomight.system.muscular.leg.thigh.SemitendinosusMuscles";
	public final static String SemitendinosusMusclesRef = "SemitendinosusMuscles";
	
	public final static String SemitendinosusMuscle = "biomight.system.muscular.leg.thigh.SemitendinosusMuscle";
	public final static String SemitendinosusMuscleRef = "SemitendinosusMuscle";

	public final static String TensorFasciaLataMuscles = "biomight.system.muscular.leg.thigh.TensorFasciaLataMuscles";
	public final static String TensorFasciaLataMusclesRef = "TensorFasciaLataMuscles";
	
	public final static String TensorFasciaLataMuscle = "biomight.system.muscular.leg.thigh.TensorFasciaLataMuscle";
	public final static String TensorFasciaLataMuscleRef = "TensorFasciaLataMuscle";

	public final static String VastusInterMediusMuscles = "biomight.system.muscular.leg.thigh.VastusInterMediusMuscles";
	public final static String VastusInterMediusMusclesRef = "VastusInterMediusMuscles";

	public final static String VastusInterMediusMuscle = "biomight.system.muscular.leg.thigh.VastusInterMediusMuscle";
	public final static String VastusInterMediusMuscleRef = "VastusInterMediusMuscle";

	public final static String VastusLateralisMuscles = "biomight.system.muscular.leg.thigh.VastusLateralisMuscles";
	public final static String VastusLateralisMusclesRef = "VastusLateralisMuscles";
	
	public final static String VastusLateralisMuscle = "biomight.system.muscular.leg.thigh.VastusLateralisMuscle";
	public final static String VastusLateralisMuscleRef = "VastusLateralisMuscle";
	
	public final static String VastusMedialisMuscles = "biomight.system.muscular.leg.thigh.VastusMedialisMuscles";
	public final static String VastusMedialisMusclesRef = "VastusMedialisMuscles";

	public final static String VastusMedialisMuscle = "biomight.system.muscular.leg.thigh.VastusMedialisMuscle";
	public final static String VastusMedialisMuscleRef = "VastusMedialisMuscle";
	
	public final static String DilatatorNarisPosteriorMuscles = "biomight.system.muscular.head.nose.DilatatorNarisPosteriorMuscles";
	public final static String DilatatorNarisPosteriorMusclesRef = "DilatatorNarisPosteriorMuscles";

	public final static String DilatatorNarisPosteriorMuscle = "biomight.system.muscular.head.nose.DilatatorNarisPosteriorMuscle";
	public final static String DilatatorNarisPosteriorMuscleRef = "DilatatorNarisPosteriorMuscle";

	public final static String HipMuscles = "biomight.system.muscular.hip.HipMuscles";
	public final static String HipMusclesRef = "HipMuscles";
	
	public final static String HipMuscle = "biomight.system.muscular.hip.HipMuscle";
	public final static String HipMuscleRef = "HipMuscle";

	/********************************************************************************
	 * 
	 * BODY
	 * 
	 ********************************************************************************/ 
		
	public final static String Body = "biomight.body.Body";
	public final static String BodyRef = "Body";		
	
	// HEAD		
	public final static String Chin = "biomight.body.head.Chin";
	public final static String ChinRef = "Chin";
	public final static String Forehead = "biomight.body.head.Forehead";
	public final static String ForeheadRef = "Forehead";
	public final static String Head = "biomight.body.head.Head";
	public final static String HeadRef = "Head";
	public final static String Jaw = "biomight.body.head.Jaw";
	public final static String JawRef = "Jaw";	
	public final static String Scalp= "biomight.body.head.Scalp";
	public final static String ScalpRef= "Scalp";
	
	
	// HAIR
	public final static String BackHair = "biomight.body.hair.BackHair";
	public final static String ChestHair = "biomight.body.hair.ChestHair";
	public final static String EarHair = "biomight.body.hair.EarHair";
	public final static String FacialHair = "biomight.body.hair.FacialHair";
	public final static String ScalpHair = "biomight.body.hair.ScalpHair";
	public final static String ScalpHairRef = "ScalpHair";
	public final static String LegHair = "biomight.body.hair.LegHair";
	public final static String NoseHair = "biomight.body.hair.NoseHair";
	public final static String Hair = "biomight.body.hair.Hair";
	public final static String HairRef = "Hair";
	public final static String HairShaft = "biomight.body.hair.HairShaft";
	public final static String HairShaftRef = "HairShaft";
	


	// EAR
	public final static String Auricle = "biomight.body.head.ear.Auricle";
	public final static String AuricleRef = "Auricle";
	
		
	// Cochlea
	public final static String Cochlea = "biomight.body.head.ear.Cochlea";
	public final static String CochleaRef = "Cochlea";
	
	public final static String ScalaVestibuli = "biomight.body.head.ear.ScalaVestibuli";
	public final static String ScalaVestibuliRef = "ScalaVestibuli";
	
	public final static String ScalaTympani = "biomight.body.head.ear.ScalaTympani";
	public final static String ScalaTympaniRef = "ScalaTympani";
	
	public final static String ScalaMedia = "biomight.body.head.ear.ScalaMedia";
	public final static String ScalaMediaRef = "ScalaMedia";

	public final static String Helicotrema = "biomight.body.head.ear.Helicotrema";
	public final static String HelicotremaRef = "Helicotrema";
	
	public final static String ReissnersMembrane = "biomight.body.head.ear.ReissnersMembrane";
	public final static String ReissnersMembraneRef = "ReissnersMembrane";
	
	public final static String BasilarMembrane = "biomight.body.head.ear.BasilarMembrane";
	public final static String BasilarMembraneRef = "BasilarMembrane";

	public final static String OrganOfCorti = "biomight.body.head.ear.OrganOfCorti";
	public final static String OrganOfCortiRef = "OrganOfCorti";

	public final static String CochleaHairCells = "biomight.body.head.ear.CochleaHairCells";
	public final static String CochleaHairCellsRef = "CochleaHairCells";

	public final static String CochleaHairCell = "biomight.body.head.ear.CochleaHairCell";
	public final static String CochleaHairCellRef = "CochleaHairCell";
	
	public final static String Stereocilia = "biomight.body.head.ear.Stereocilia";
	public final static String StereociliasRef = "StereociliaCells";
	
	public final static String Ear = "biomight.body.head.ear.Ear";
	public final static String EarRef = "Ear";
	
	public final static String Ears = "biomight.body.head.ear.Ears";
	public final static String EarsRef = "Ears";
	
	public final static String ExternalCanal = "biomight.body.head.ear.ExternalCanal";
	public final static String ExternalCanalRef = "ExternalCanal";
	
	public final static String Incus = "biomight.body.head.ear.Incus";
	public final static String IncusRef = "Incus";
	
	public final static String Malleus = "biomight.body.head.ear.Malleus";
	public final static String MalleusRef = "Malleus";
	
	public final static String RightEar = "biomight.body.head.ear.RightEar";
	public final static String RightEarRef = "RightEar";
	
	public final static String LeftEar = "biomight.body.head.ear.LeftEar";
	public final static String LeftEarRef = "LeftEar";

	public final static String LeftCheek = "biomight.body.head.face.LeftCheek";
	public final static String LeftCheekRef = "LeftCheek";
	
	public final static String Cheek = "biomight.body.head.face.Cheek";
	public final static String CheekRef = "Cheek";
	
	public final static String Cheeks = "biomight.body.head.face.Cheeks";
	public final static String CheeksRef = "Cheeks";
	
	public final static String Saccule = "biomight.body.head.ear.Saccule";
	public final static String SacculeRef = "Saccule";
	
	public final static String SemiCircularCanals = "biomight.body.head.ear.SemiCircularCanals";	
	public final static String SemiCircularCanalsRef = "SemiCircularCanals";
	
	public final static String SemiCircularCanal = "biomight.body.head.ear.SemiCircularCanal";	
	public final static String SemiCircularCanalRef = "SemiCircularCanal";
	
	public final static String Stapes = "biomight.body.head.ear.Stapes";
	public final static String StapesRef = "Stapes";
	
	public final static String TympanicMembrane = "biomight.body.head.ear.TympanicMembrane";
	public final static String TympanicMembraneRef = "TympanicMembrane";
	
	public final static String Utricle = "biomight.body.head.ear.Utricle";	
	public final static String UtricleRef = "Utricle";
	
	public final static String PinnaAntiHelix = "biomight.body.head.ear.PinnaAntiHelix";	
	public final static String PinnaAntiHelixRef = "PinnaAntiHelix";
	
	public final static String PinnaSuperiorCrux = "biomight.body.head.ear.PinnaSuperiorCrux";
	public final static String PinnaSuperiorCruxRef = "";
	
	public final static String PinnaInferiorCrux = "biomight.body.head.ear.PinnaInferiorCrux";
	public final static String PinnaInferiorCruxRef = "";
	
	public final static String AuricularSulcus = "biomight.body.head.ear.AuricularSulcus";
	public final static String AuricularSulcusRef = "";
	
	public final static String PinnaConcha = "biomight.body.head.ear.PinnaConcha";
	public final static String PinnaConchaRef = "";
	
	public final static String PinnaConchalAngle = "biomight.body.head.ear.PinnaConchalAngle";
	public final static String PinnaConchalAngleRef = "";
	
	public final static String PinnaCrusOfHelix = "biomight.body.head.ear.PinnaCrusOfHelix";
	public final static String PinnaCrusOfHelixRef = "";
	
	public final static String PinnaCymbaConchae = "biomight.body.head.ear.PinnaCymbaConchae";	
	public final static String PinnaCymbaConchaeRef = "";
	
	public final static String ExternalAuditoryMeatus = "biomight.body.head.ear.ExternalAuditoryMeatus";	
	public final static String ExternalAuditoryMeatusRef = "";
	
	public final static String PinnaFossaTriangularis = "biomight.body.head.ear.PinnaFossaTriangularis";	
	public final static String PinnaFossaTriangularisRef = "";
	
	public final static String PinnaHelix = "biomight.body.head.ear.PinnaHelix";	
	public final static String PinnaHelixRef = "";
	
	public final static String PinnaIncisuraAnterior = "biomight.body.head.ear.PinnaIncisuraAnterior";	
	public final static String PinnaIncisuraAnteriorRef = "";
	
	public final static String PinnaLobe = "biomight.body.head.ear.PinnaLobe";	
	public final static String PinnaLobeRef = "";
	
	public final static String Scapha = "biomight.body.head.ear.Scapha";
	public final static String ScaphaRef = "";
	
	public final static String Tragus = "biomight.body.head.ear.Tragus";	
	public final static String TragusRef = "";
	
	public final static String Antitragus = "biomight.body.head.ear.Antitragus";		
	public final static String AntitragusRef = "";
	
	// EYE
	public final static String Eyes = "biomight.body.head.eye.Eyes";
	public final static String EyesRef = "Eyes";
	
	public final static String Eye = "biomight.body.head.eye.Eye";
	public final static String EyeRef = "Eye";
	
	public final static String AnteriorChamber = "biomight.body.head.eye.AnteriorChamber";
	public final static String AnteriorChamberRef = "";
	
	public final static String CanalOfSchlemm = "biomight.body.head.eye.CanalOfSchlemm";
	public final static String CanalOfSchlemmRef = "";
	
	public final static String Choroid = "biomight.body.head.eye.Choroid";
	public final static String ChoroidRef = "Choroid";
	
	public final static String CiliaryBody = "biomight.body.head.eye.CiliaryBody";
	public final static String CiliaryBodyRef = "CiliaryMuscle";
	
	public final static String CiliaryMuscle = "biomight.body.head.eye.CiliaryMuscle";
	public final static String CiliaryMuscleRef = "CiliaryMuscle";
	
	public final static String CiliaryProcess = "biomight.body.head.eye.CiliaryProcess";
	public final static String CiliaryProcessRef = "CiliaryProcess";
	
	public final static String Cone = "biomight.body.head.eye.Cone";
	public final static String ConeRef = "Cone";

	
	public final static String Cones = "biomight.body.head.eye.Cones";
	public final static String ConesRef = "";
	
	public final static String Conjunctiva = "biomight.body.head.eye.Conjunctiva";
	public final static String ConjunctivaRef = "";
	
	public final static String Cornea = "biomight.body.head.eye.Cornea";
	public final static String CorneaRef = "Cornea";
	
	
	public final static String EyeLashes = "biomight.body.head.eye.EyeLashes";
	
	public final static String EyeLens = "biomight.body.head.eye.EyeLens";
	
	public final static String LowerEyeLid = "biomight.body.head.eye.EyelidLower";
	public final static String LowerEyeLidRef = "LowerEyeLid";

	public final static String EyeLid = "biomight.body.head.eye.Eyelid";
	public final static String EyeLidRef = "EyeLid";

	public final static String EyeLids = "biomight.body.head.eye.Eyelids";
	public final static String EyeLidsRef = "EyeLids";
	
	public final static String UpperEyeLid = "biomight.body.head.eye.EyelidUpper";
	public final static String UpperEyeLidRef = "UpperEyeLid";
	
	public final static String Fovea = "biomight.body.head.eye.Fovea";
	public final static String FoveaRef = "Fovea";
	
	public final static String HyaloidCanal = "biomight.body.head.eye.HyaloidCanal";
	public final static String HyaloidCanalRef = "HyaloidCanal";
	
	public final static String Iris = "biomight.body.head.eye.Iris";
	public final static String IrisRef = "Iris";

	public final static String IrisStroma = "biomight.body.head.eye.IrisStorma";
	public final static String IrisStromaRef = "IrisStroma";
	
	public final static String Lens = "biomight.body.head.eye.Lens";
	public final static String LensRef = "Lens";
	
	public final static String Macula = "biomight.body.head.eye.Macula";
	public final static String MaculaRef = "Macula";
	
	public final static String LateralCommissure = "biomight.body.head.eye.LateralCommissure";
	public final static String LateralCommissureRef = "LateralCommissure";

	public final static String MedialCommissure = "biomight.body.head.eye.MedialCommissure";
	public final static String MedialCommissureRef = "MedialCommissure";
	
	public final static String LateralCanthus = "biomight.body.head.eye.LateralCanthus";
	public final static String LateralCanthusRef = "LateralCanthus";
	
	public final static String MedialCanthus = "biomight.body.head.eye.MedialCanthus";
	public final static String MedialCanthusRef = "MedialCanthus";
	
	public final static String MobomiumGland = "biomight.body.head.eye.MobomiumGland";
	public final static String MobomiumGlandRef = "MobomiumGland";
	
	public final static String OpticDisc = "biomight.body.head.eye.OpticDisc";
	public final static String OpticDiscRef = "biomight.body.head.eye.OpticDisc";
	
	public final static String ParsPlana = "biomight.body.head.eye.ParsPlana";
	public final static String ParsPlanaRef = "ParsPlana";
	
	public final static String Photopsin = "biomight.body.head.eye.Photopsin";	
	public final static String PhotopsinRef = "Photopsin";
	
	public final static String PosteriorChamber = "biomight.body.head.eye.PosteriorChamber";
	public final static String PosteriorChamberRef = "PosteriorChamber";
	
	public final static String Pupil = "biomight.body.head.eye.Pupil";
	public final static String PupilRef = "Pupil";
	
	public final static String PupilMargin = "biomight.body.head.eye.PupilMargin";
	public final static String PupilMarginRef = "PupilMargin";
	
	public final static String PupilSphincter = "biomight.body.head.eye.PupilSphincter";
	public final static String PupilSphincterRef = "PupilSphincter";
	
	public final static String Retina = "biomight.body.head.eye.Retina";
	public final static String RetinaRef = "Retina";
	
	public final static String Rod = "biomight.body.head.eye.Rod";
	public final static String RodRef = "Rod";

	public final static String Rods = "biomight.body.head.eye.Rods";
	public final static String RodsRef = "Rods";
	
	public final static String Sclera = "biomight.body.head.eye.Sclera";
	public final static String ScleraRef = "Sclera";
	
	public final static String SebaciousCyst = "biomight.body.head.eye.SebaciousCyst";
	public final static String SebaciousCystRef = "SebaciousCyst";
	
	public final static String Trabeculum = "biomight.body.head.eye.Trabeculum";
	public final static String TrabeculumRef = "Trabeculum";
	
	public final static String UpperEyeLidCrease = "biomight.body.head.eye.UpperEyeLidCrease";
	public final static String UpperEyeLidCreaseRef = "UpperEyeLidCrease";
	
	public final static String Uvea = "biomight.body.head.eye.Uvea";
	public final static String UveaRef = "Uvea";
	
	public final static String VitreousHumor = "biomight.body.head.eye.VitreousHumor";
	public final static String VitreousHumorRef = "VitreousHumor";
	
	public final static String ZonularFibers = "biomight.body.head.eye.ZonularFibers";
	public final static String ZonularFibersRef = "ZonularFibers";
	
	public final static String CornealEpithelium = "biomight.body.head.eye.CornealEpithelium";
	public final static String CornealEpitheliumRef = "CornealEpithelium";

	public final static String BowmansLayer = "biomight.body.head.eye.BowmansLayer";
	public static final String BowmansLayerRef = "BowmansLayer";

	public final static String SubstantiaPropria = "biomight.body.head.eye.SubstantiaPropria";
	public final static String SubstantiaPropriaRef = "SubstantiaPropria";
	
	
	public final static String DescemetsMembrane = "biomight.body.head.eye.DescemetsMembrane";
	public final static String DescemetsMembraneRef = "DescemetsMembrane";

	
	public final static String CornealEndothelium = "biomight.body.head.eye.CornealEndothelium";
	public final static String CornealEndotheliumRef = "CornealEndothelium";

	

	// MOUTH
	public final static String Mouth = "biomight.body.head.mouth.Mouth";
	public final static String MouthRef = "Mouth";
	
	public final static String Lips = "biomight.body.head.mouth.Lips";
	public final static String LipsRef = "Lips";

	public final static String Lip = "biomight.body.head.mouth.Lip";
	public final static String LipRef = "Lip";
	
	//public final static String LipsTissue = "biomight.body.head.mouth.LipsTissue;
	//public final static String LipsTissueRef = "LipsTissue";
	
	public final static String LowerLip = "biomight.body.head.mouth.LowerLip";
	public final static String LowerLipRef = "LowerLip";
	
	public final static String LowerLipTissue = "biomight.body.head.mouth.LowerLipTissue";
	public final static String LowerLipTissueRef = "LowerLip";
	
	public final static String UpperLip = "biomight.body.head.mouth.UpperLip";	
	public final static String UpperLipRef = "UpperLip";
	
	public final static String UpperLipTissue = "biomight.body.head.mouth.UpperLipTissue";	
	public final static String UpperLipTissueRef = "UpperLipTissue";
	
	public final static String Gingiva = "biomight.body.head.mouth.Gingiva";	
	public final static String GingivaRef = "Gingiva";
	
	public final static String Gums = "biomight.body.head.mouth.Gums";
	public final static String GumsRef = "Gums";
	
	public final static String HardPalate = "biomight.body.head.mouth.HardPalate";
	public final static String HardPalateRef = "LingualFrenulum";
	
	public final static String LingualFrenulum = "biomight.body.head.mouth.LingualFrenulum";
	public final static String LingualFrenulumRef = "LingualFrenulum";
	
	public final static String LingualTonsil = "biomight.body.head.mouth.LingualTonsil";
	public final static String LingualTonsilRef = "LingualTonsil";
	
	public final static String OralCavity = "biomight.body.head.mouth.OralCavity";
	public final static String OralCavityRef = "";
	
	public final static String Papillae = "biomight.body.head.mouth.Gingiva";
	public final static String PapillaeRef = "Papillae";
		
	public final static String SalivaryGland = "biomight.body.head.mouth.SalivaryGland";
	public final static String SalivaryGlandRef = "SalivaryGland";
	
	public final static String SalivaryGlands = "biomight.body.head.mouth.SalivaryGlands";
	public final static String SalivaryGlandsRef = "SalivaryGlands";
	
	public final static String SoftPalate = "biomight.body.head.mouth.SoftPalate";
	public final static String SoftPalateRef = "SoftPalate";
	
	public final static String TasteBud = "biomight.body.head.mouth.TasteBud";
	public final static String TasteBudRef = "TasteBud";
	
	public final static String TasteBuds = "biomight.body.head.mouth.TasteBuds";
	public final static String TasteBudsRef = "TasteBuds";
	
	public final static String TerminalSulcus = "biomight.body.head.mouth.TerminalSulcus";
	public final static String TerminalSulcusRef = "TerminalSulcus";
	
	public final static String Tongue = "biomight.body.head.mouth.tongue.Tongue";
	public final static String TongueRef = "Tongue";
	
	public final static String TonguePharyngeal = "biomight.body.head.mouth.TonguePharyngeal";
	public final static String TonguePharyngealRef = "TonguePharyngeal";
	
	public final static String GustatoryPore = "biomight.body.head.mouth.GustatoryPore";
	public final static String GustatoryPoreRef = "GustatoryPore";
	
	public final static String GustatoryHair = "biomight.body.head.mouth.GustatoryHair";	
	public final static String GustatoryHairRef = "GustatoryHair";

	public final static String FungiformPapillae = "biomight.body.head.mouth.tongue.FungiformPapillae";
	public final static String FungiformPapillaeRef = "FungiformPapillae";

	public final static String FungiformPapilla = "biomight.body.head.mouth.tongue.FungiformPapilla";
	public final static String FungiformPapillaRef = "FungiformPapilla";

	public final static String FiliformPapillae = "biomight.body.head.mouth.tongue.FiliformPapillae";
	public final static String FiliformPapillaeRef = "FiliformPapillae";

	public final static String FiliformPapilla = "biomight.body.head.mouth.tongue.FiliiformPapilla";
	public final static String FiliformPapillaRef = "FiliformPapilla";

	public final static String FoliatePapillae = "biomight.body.head.mouth.tongue.FoliatePapillae";
	public final static String FoliatePapillaeRef = "FoliatePapillae";

	public final static String FoliatePapilla = "biomight.body.head.mouth.tongue.FoliatePapilla";
	public final static String FoliatePapillaRef = "FoliatePapilla";
	
	public final static String CircumvallatePapillae = "biomight.body.head.mouth.tongue.FoliatePapillae";
	public final static String CircumvallatePapillaeRef = "CircumvallatePapillae";

	public final static String CircumvallatePapilla = "biomight.body.head.mouth.tongue.FoliatePapilla";
	public final static String CircumvallatePapillaRef = "CircumvallatePapilla";


	
	// MOUTH.TEETH
	public final static String BiCuspids = "biomight.body.head.tooth.BiCuspids";
	public final static String Carnassials = "biomight.body.head.tooth.Carnassials";
	public final static String Crown = "biomight.body.head.tooth.Crown";
	public final static String Cuspids = "biomight.body.head.tooth.Cuspids";
	public final static String DeciduousTeeth = "biomight.body.head.tooth.DeciduousTeeth";
	public final static String Incisors = "biomight.body.head.tooth.Incisors";
	public final static String Molars = "biomight.body.head.tooth.Molars";
	
	public final static String Pulp = "biomight.body.head.tooth.Pulp";
	public final static String PulpRef = "Pulp";
	
	public final static String Root = "biomight.body.head.tooth.Root";
	public final static String RootRef = "Root";
	
	public final static String Teeth = "biomight.body.head.tooth.Teeth";
	public final static String TeethRef = "Teeth";
	
	public final static String Tooth = "biomight.body.head.tooth.Tooth";
	public final static String ToothRef = "Tooth";
	
	public final static String RightLowerCentralIncisor = "biomight.body.head.tooth.RightLowerCentralIncisor";
	public final static String RightLowerLateralIncisor = "biomight.body.head.tooth.RightLowerLateralIncisor";
	public final static String RightLowerCanine = "biomight.body.head.tooth.RightLowerCanine";
	public final static String RightLower1stPreMolar = "biomight.body.head.tooth.RightLower1stPreMolar";
	public final static String RightLower2ndPreMolar = "biomight.body.head.tooth.RightLower2ndPreMolar";
	public final static String RightLower1stMolar = "biomight.body.head.tooth.RightLower1stMolar";
	public final static String RightLower2ndMolar = "biomight.body.head.tooth.RightLower2ndMolar";
	public final static String RightLower3rdMolar = "biomight.body.head.tooth.RightLower3rdMolar";
	public final static String RightLowerWisdomTooth = "biomight.body.head.tooth.RightLowerWisdomTooth";
	public final static String LeftLowerCentralIncisor = "biomight.body.head.tooth.LeftLowerCentralIncisor";
	public final static String LeftLowerLateralIncisor = "biomight.body.head.tooth.LeftLowerLateralIncisor";
	public final static String LeftLowerCanine = "biomight.body.head.tooth.LeftLowerCanine";
	public final static String LeftLower1stPreMolar = "biomight.body.head.tooth.LeftLower1stPreMolar";
	public final static String LeftLower2ndPreMolar = "biomight.body.head.tooth.LeftLower2ndPreMolar";
	public final static String LeftLower1stMolar = "biomight.body.head.tooth.LeftLower1stMolar";
	public final static String LeftLower2ndMolar = "biomight.body.head.tooth.LeftLower2ndMolar";
	public final static String LeftLower3rdMolar = "biomight.body.head.tooth.LeftLower3rdMolar";
	public final static String LeftLowerWisdomTooth = "biomight.body.head.tooth.LeftLowerWisdomTooth";
	public final static String RightUpperCentralIncisor = "biomight.body.head.tooth.RightUpperCentralIncisor";
	public final static String RightUpperLateralIncisor = "biomight.body.head.tooth.RightUpperLateralIncisor";
	public final static String RightUpperCanine = "biomight.body.head.tooth.RightUpperCanine";
	public final static String RightUpper1stPreMolar = "biomight.body.head.tooth.RightUpper1stPreMolar";
	public final static String RightUpper2ndPreMolar = "biomight.body.head.tooth.RightUpper2ndPreMolar";
	public final static String RightUpper1stMolar = "biomight.body.head.tooth.RightUpper1stMolar";
	public final static String RightUpper2ndMolar = "biomight.body.head.tooth.RightUpper2ndMolar";
	public final static String RightUpper3rdMolar = "biomight.body.head.tooth.RightUpper3rdMolar";
	public final static String RightUpperWisdomTooth = "biomight.body.head.tooth.RightUpperWisdomTooth";
	public final static String LeftUpperCentralIncisor = "biomight.body.head.tooth.LeftUpperCentralIncisor";
	public final static String LeftUpperLateralIncisor = "biomight.body.head.tooth.LeftUpperLateralIncisor";
	public final static String LeftUpperCanine = "biomight.body.head.tooth.LeftUpperCanine";
	public final static String LeftUpper1stPreMolar = "biomight.body.head.tooth.LeftUpper1stPreMolar";
	public final static String LeftUpper2ndPreMolar = "biomight.body.head.tooth.LeftUpper2ndPreMolar";
	public final static String LeftUpper1stMolar = "biomight.body.head.tooth.LeftUpper1stMolar";
	public final static String LeftUpper2ndMolar = "biomight.body.head.tooth.LeftUpper2ndMolar";
	public final static String LeftUpper3rdMolar = "biomight.body.head.tooth.LeftUpper3rdMolar";
	public final static String LeftUpperWisdomTooth = "biomight.body.head.tooth.LeftUpperWisdomTooth";
	public final static String WisdomTeeth = "biomight.body.head.tooth.WisdomTeeth";
	//public final static String Incisors = "biomight.body.head.tooth.Incisors";
	
	
	// NOSE
	public final static String Nose = "biomight.body.head.nose.Nose";
	public final static String NoseRef = "Nose";
	
	public final static String FrontalSinuses = "biomight.body.head.nose.FrontalSinuses";
	public final static String FrontalSinusesRef = "FrontalSinuses";

	public final static String FrontalSinus = "biomight.body.head.nose.FrontalSinus";
	public final static String FrontalSinusRef = "FrontalSinus";
	
	public final static String InferiorNasalConcha = "biomight.body.head.nose.InferiorNasalConcha";
	public final static String InferiorNasalConchaRef = "InferiorNasalConcha";
	
	public final static String MaxillarySinus = "biomight.body.head.nose.MaxillarySinus";
	public final static String MaxillarySinusRef = "biomight.body.head.nose.MaxillarySinus";

	public final static String MiddleNasalConcha = "biomight.body.head.nose.MiddleNasalConcha";
	public final static String MiddleNasalConchaRef = "MiddleNasalConcha";

	public final static String NasalCavity = "biomight.body.head.nose.NasalCavity";
	public final static String NasalCavityRef = "NasalCavityRef";
	
	public final static String NasalSeptum = "biomight.body.head.nose.NasalSeptum";
	public final static String NasalSeptumRef = "NasalSeptum";
	
	public final static String NasoLacrimalDuct = "biomight.body.head.nose.NasoLacrimalDuct";
	public final static String NasoLacrimalDuctRef = "NasoLacrimalDuct";

	public final static String Nostril = "biomight.body.head.nose.Nostril";
	public final static String NostrilRef = "Nostril";
	
	public final static String Nostrils = "biomight.body.head.nose.Nostrils";
	public final static String NostrilsRef = "Nostrils";
	
	public final static String LeftNostril = "biomight.body.head.nose.LeftNostril";
	public final static String leftNostrilRef = "LeftNostril";
	
	public final static String RightNostril = "biomight.body.head.nose.RightNostril";	
	public final static String RightNostrilRef = "RightNostril";

	public final static String SellaTunica = "biomight.body.head.nose.SellaTunica";
	public final static String SellaTunicaRef = "SellaTunica";

	public final static String SphenoidSinus = "biomight.body.head.nose.SphenoidSinus";
	public final static String SphenoidSinusRef = "SphenoidSinus";

	public final static String SuperiorNasalConcha = "biomight.body.head.nose.SuperiorNasalConcha";
	public final static String SuperiorNasalConchaRef = "SuperiorNasalConcha";

	public final static String Turbinate = "biomight.body.head.nose.Turbinate";
	public final static String TurbinateRef = "Turbinate";

	public final static String Turbinates = "biomight.body.head.nose.Turbinates";
	public final static String TurbinatesRef = "Turbinates";

	public final static String Sinus = "biomight.body.head.nose.Sinus";
	public final static String SinusRef = "Sinus";
		
	// NECK
	public final static String Neck = "biomight.body.neck.Neck";
	public final static String NeckRef = "Neck";

	
	public final static String AdamsApple = "biomight.body.neck.AdamsApple";
	public final static String AdamsAppleRef = "AdamsApple";
	
	public final static String AryepiglottalFolds = "biomight.body.neck.AryepiglottalFolds";
	public final static String AryepiglottalFoldsRef = "";
	
	public final static String Epiglottis = "biomight.body.neck.Epiglottis";
	public final static String EpiglottisRef = "";
	
	public final static String Glottis = "biomight.body.neck.Glottis";
	public final static String GlottisRef = "";
	
	public final static String Larynx = "biomight.body.neck.Larynx";
	public final static String LarynxRef = "";
	
						
	// BODY	
	public final static String Torso = "biomight.body.Torso";
	public final static String TorsoRef = "";
	
	public final static String Waist = "biomight.body.Waist";
	public final static String WaistRef = "";
	
	
	// ARMS & SHOULDERS
	public final static String Arm = "biomight.body.arm.Arm";
	public final static String ArmRef = "Arm";

	public final static String Arms = "biomight.body.arm.Arms";
	public final static String ArmsRef = "Arms";

	public final static String LeftArm = "biomight.body.arm.LeftArm";
	public final static String LeftArmRef = "Arm:01";
	
	public final static String RightArm = "biomight.body.arm.RightArm";
	public final static String RightArmRef = "Arm:02";
	
	public final static String Shoulder = "biomight.body.Shoulder";
	public final static String ShoulderRef = "Shoulder";
	
	public final static String Shoulders = "biomight.body.Shoulders";
	public final static String ShouldersRef = "Shoulders";

	public final static String LeftShoulder  = "biomight.body.LeftShoulder";
	public final static String LeftShoulderRef  = "Shoulder:01";

	public final static String RightShoulder = "biomight.body.RightShoulder";
	public final static String RightShoulderRef = "Shoulder:02";
		
	public final static String ForeArm = "biomight.body.arm.ForeArm";
	public final static String ForeArmRef = "ForeArm";
	
	public final static String ForeArms = "biomight.body.arm.ForeArms";
	public final static String ForeArmsRef = "ForeArms";

	public final static String LeftForeArm = "biomight.body.arm.LeftForeArm";	
	public final static String LeftForeArmRef = "ForeArm:01";	

	public final static String RightForeArm = "biomight.body.arm.RightForeArms";
	public final static String RightForeArmRef = "ForeArm:02";	

	public final static String Elbow = "biomight.body.Elbow";
	public final static String ElbowRef = "Elbow";
	public final static String Elbows = "biomight.body.Elbows";
	public final static String ElbowsRef = "Elbows";
	public final static String LeftElbow = "biomight.body.LeftElbow";
	public final static String LeftElbowRef = "Elbow:01";
	public final static String RightElbow = "biomight.body.RightElbow";
	public final static String RightElbowRef = "Elbow:02";
	
	public final static String Wrist = "biomight.body.Wrist";
	public final static String WristRef = "Wrist";
	public final static String Wrists = "biomight.body.Wrists";
	public final static String WristsRef = "Wrists";
	public final static String LeftWrist = "biomight.body.LeftWrist";
	public final static String LeftWristRef = "Wrist:01";
	public final static String RightWrist = "biomight.body.RightWrist";
	public final static String RightWristRef = "Wrist:02";
	
	// HAND
	public final static String Hand = "biomight.body.hand.Hand";
	public final static String HandRef = "Hand";
	public final static String Hands = "biomight.body.hand.Hands";
	public final static String HandsRef = "Hands";	
	public final static String LeftHand = "biomight.body.hand.LeftHand";
	public final static String LeftHandRef = "Hand:01";
	public final static String RightHand = "biomight.body.hand.RightHand";
	public final static String RightHandRef = "Hand:02";
	
	public final static String Finger = "biomight.body.hand.Finger";	
	public final static String FingerRef = "Finger";
	public final static String Fingers = "biomight.body.hand.Fingers";	
	public final static String FingersRef = "Fingers";	
	
	public final static String FingerNail = "biomight.body.hand.FingerNail";	
	public final static String FingerNailRef = "FingerNail";	
	

	public final static String IndexFinger = "biomight.body.hand.IndexFinger";	
	public final static String LittleFinger = "biomight.body.hand.LittleFinger";	
	public final static String MiddleFinger = "biomight.body.hand.MiddleFinger";
	
	public final static String Palm = "biomight.body.hand.Palm";	
	public final static String PalmRef = "Palm";	
	
	public final static String RingFinger = "biomight.body.hand.RingFinger";	
	
	public final static String ThenarEminence = "biomight.body.hand.ThenarEminence";	
	public final static String ThenarEminenceRef = "ThenarEminence";	
	
	public final static String Thumb = "biomight.body.hand.Thumb";	
	public final static String ThumbRef = "Thumb";	

	public final static String LeftIndexFinger = "biomight.body.hand.LeftIndexFinger";	
	public final static String LeftLittleFinger = "biomight.body.hand.LeftLittleFinger";	
	public final static String LeftMiddleFinger = "biomight.body.hand.LeftMiddleFinger";
	public final static String LeftPalm = "biomight.body.hand.LeftPalm";		
	public final static String LeftRingFinger = "biomight.body.hand.LeftRingFinger";	
	public final static String LeftThenarEminence = "biomight.body.hand.LeftThenarEminence";	
	public final static String LeftThumb = "biomight.body.hand.LeftThumb";

	public final static String RightIndexFinger = "biomight.body.hand.RightIndexFinger";	
	public final static String RightLittleFinger = "biomight.body.hand.RightLittleFinger";	
	public final static String RightMiddleFinger = "biomight.body.hand.RightMiddleFinger";
	public final static String RightPalm = "biomight.body.hand.RightPalm";		
	public final static String RightRingFinger = "biomight.body.hand.RightRingFinger";	
	public final static String RightThenarEminence = "biomight.body.hand.RightThenarEminence";	
	public final static String RightThumb = "biomight.body.hand.RightThumb";
	
	public final static String Chest = "biomight.body.Chest";
	public final static String ChestRef = "Chest";

	public final static String Abdomen = "biomight.body.Abdomen";
	public final static String AbdomenRef = "Abdomen";
	
	public final static String Navel = "biomight.body.Navel";
	public final static String NavelRef = "Navel";
	
	public final static String Nipple = "biomight.body.Nipple";
	public final static String NippleRef = "Nipple";
	
	public final static String Nipples = "biomight.body.Nipples";
	public final static String NipplesRef = "Nipples";
	
	public final static String LeftNipple = "biomight.body.LeftNipple";
	public final static String RightNipple = "biomight.body.RightNipple";
	
	public final static String Back = "biomight.body.Back";	
	public final static String BackRef = "Back";
	
	public final static String Anus = "biomight.body.Anus";	
	public final static String Appendix = "biomight.body.Appendix";	
	
	// HIP
	public final static String Hips = "biomight.body.hip.Hips";
	public final static String HipsRef = "Hips";
	
	public final static String Hip = "biomight.body.hip.Hip";
	public final static String HipRef = "Hip";
	
	public final static String LeftHip = "biomight.body.hip.Hip";
	public final static String LeftHipRef = "Hip:01";
	
	public final static String RightHip = "biomight.body.hip.Hip";
	public final static String RightHipRef = "Hip:02";
	
	public final static String Acetabulum = "biomight.body.hip.Acetabulum";
	public final static String Labrum = "biomight.body.hip.Labrum";

	// THIGH	
	public final static String Thigh = "biomight.body.leg.thigh.Thigh";	
	public final static String ThighRef = "Thigh";
	
	public final static String Thighs = "biomight.body.leg.thigh.Thighs";	
	public final static String ThighsRef = "Thighs";	

	public final static String LeftThigh = "biomight.body.leg.thigh.LeftThigh";
	public final static String LeftThighRef = "Thigh:01";

	public final static String RightThigh = "biomight.body.leg.thigh.RightThigh";
	public final static String RightThighRef = "Thigh:02";
	
	public final static String AnteriorThigh = "biomight.body.leg.thigh.AnteriorThigh";
	public final static String MedialThigh = "biomight.body.leg.thigh.MedialThigh";		
	public final static String PosteriorThigh = "biomight.body.leg.thigh.PosteriorThigh";	

	// Thigh Bones
	public final static String Femurs = "biomight.system.skeletal.leg.femur.Femurs";
	public final static String FemursRef = "Femurs";	
	
	public final static String Femur = "biomight.system.skeletal.leg.femur.Femur";
	public final static String FemurRef = "Femur";	
	

	// KNEES
	public final static String Knee = "biomight.body.leg.Knee";
	public final static String KneeRef = "Knee";
	
	public final static String Knees = "biomight.body.leg.Knees";
	public final static String KneesRef = "Knees";
	
	public final static String RightKnee = "biomight.body.leg.RightKnee";
	public final static String RightKneeRef = "Knee:01";

	public final static String LeftKnee = "biomight.body.leg.LeftKnee";
	public final static String LeftKneeRef = "Knee:02";

	public final static String Patellas = "biomight.system.skeletal.leg.Patellas";
	public final static String PatellasRef = "Patellas";
	
	public final static String Patella = "biomight.system.skeletal.leg.Patella";
	public final static String PatellaRef = "Patella";
	
	
	// LEGS
	public final static String Leg = "biomight.body.leg.Leg";
	public final static String LegRef = "Leg";
	public final static String Legs = "biomight.body.leg.Legs";
	public final static String LegsRef = "Legs";
	

	// Lower Body Bones
	public final static String Fibulas = "biomight.system.skeletal.leg.Fibulas";
	public final static String FibulasRef = "Fibulas";

	public final static String Fibula = "biomight.system.skeletal.leg.Fibula";
	public final static String FibulaRef = "Fibula";
	
	public final static String RightLeg = "biomight.body.leg.RightLeg";
	public final static String LeftLeg = "biomight.body.leg.LeftLeg";	

	public final static String LateralEpiCondyles = "biomight.system.skeletal.leg.thigh.LateralCondyles";
	public final static String LateralEpiCondylesRef = "LateralEpiCondyles";
	
	public final static String LateralEpiCondyle = "biomight.system.skeletal.leg.thigh.LateralCondyle";
	public final static String LateralEpiCondyleRef = "LateralEpiCondyle";

	// biomight.system.skeletal.leg.tibia	 
	public final static String LateralCondyle = "biomight.system.skeletal.leg.tibia.LateralCondyle";
	public final static String MedialCondyle = "biomight.system.skeletal.leg.tibia.MedialCondyle";

	public final static String Tibias = "biomight.system.skeletal.leg.tibia.Tibias";
	public final static String TibiasRef = "Tibias";
	
	public final static String Tibia = "biomight.system.skeletal.leg.tibia.Tibia";
	public final static String TibiaRef = "Tibia";
	
	public final static String TibiaCondyles = "biomight.system.skeletal.leg.tibia.TibiaCondyles";

	
	// CNEMIS
	public final static String Cnemis = "biomight.body.leg.cnemis.Cnemis";
	public final static String CnemisRef = "Cnemis";
	
	public final static String Cnemes = "biomight.body.leg.cnemis.Cnemes";
	public final static String CnemesRef = "Cnemes";
	
	public final static String LeftCnemis = "biomight.body.leg.cneklmis.LeftCnemis";
	public final static String LeftCnemisRef = "Cnemis:01";
	
	public final static String RightCnemis = "biomight.body.leg.cnemis.RightCnemis";
	public final static String RightCnemisRef = "Cnemis:02";
	
	public final static String Shin = "biomight.body.leg.Shin";
	public final static String Calf = "biomight.body.Calf";
	public final static String RightCalf = "biomight.body.RightCalf";
	public final static String LeftCalf = "biomight.body.LeftCalf";

	public final static String Ankle = "biomight.body.ankle";
	public final static String RightAnkle = "biomight.body.RightAnkle";	
	public final static String LeftAnkle = "biomight.body.LeftAnkle";	
			
	// FEET
	public final static String Feet = "biomight.body.foot.Feet";		
	public final static String FeetRef = "Feet";
	public final static String Foot = "biomight.body.foot.Foot";
	public final static String FootRef = "Foot";

	
	public final static String Heel = "biomight.body.foot.Heel";
	
	public final static String LeftFoot = "biomight.body.foot.LeftFoot";	
	public final static String LeftFootRef = "Foot:01";
	
	public final static String RightFoot = "biomight.body.foot.RightFoot";
	public final static String RightFootRef = "Foot:02";	
	
	public final static String Toe = "biomight.body.foot.Toe";
	public final static String Toes = "biomight.body.foot.Toes";		
	public final static String BigToe = "biomight.body.foot.BigToe";	
	public final static String PinkyToe = "biomight.body.foot.PinkyToe";
	public final static String MiddleToe = "biomight.body.foot.MiddleToe";	
	public final static String IndexToe = "biomight.body.foot.IndexToe";
	public final static String RingToe = "biomight.body.foot.RingToe";
	public final static String ToeNail = "biomight.body.foot.ToeNail";
		

	// MALE - Reproductive
	public final static String MaleGenitals = "biomight.body.male.Genitals";
	public final static String MaleGenitalsRef = "MaleGenitals";
	public final static String CorpusCavernosum = "biomight.body.male.CorpusCavernosum";	
	public final static String CorpusSpongiosum = "biomight.body.male.CorpusSpongiosum";	
	public final static String CowpersGland = "biomight.body.male.CowpersGland";	
	public final static String CremastericFascia = "biomight.body.male.CremastericFascia";	
	public final static String DartosTunic = "biomight.body.male.DartosTunic";	
	public final static String DuctusDeferens = "biomight.body.male.DuctusDeferens";	
	public final static String EfferentDuctules = "biomight.body.male.EfferentDuctules";	
	public final static String EjaculatoryDuct = "biomight.body.male.EjaculatoryDuct";	
	public final static String Epididymis = "biomight.body.male.Epididymis";	
	public final static String Foreskin = "biomight.body.male.EpididyForeskin";	
	public final static String GlansPenis = "biomight.body.male.GlansPenis";	
	public final static String Groin = "biomight.body.male.Groin";	
	public final static String InfundibuliformFascia = "biomight.body.male.InfundibuliformFascia";	
	public final static String InterCruralFascia = "biomight.body.male.InterCruralFascia";	
	public final static String LaminaParietalis = "biomight.body.male.LaminaParietalis";	
	public final static String LaminaVisceralis = "biomight.body.male.LaminaVisceralis";	
	public final static String MediastinumTestis = "biomight.body.male.MediastinumTestis";
	public final static String Penis = "biomight.body.male.PenisRef";	
	public final static String PenisRef = "Penis";	
	public final static String ParietalTunicaVaginalis = "biomight.body.male.ParietalTunicaVaginalis";			
	public final static String ProstrateGland = "biomight.body.male.ProstrateGland";	
	public final static String ReteTestis = "biomight.body.male.ReteTestis";	
	public final static String Scrotum = "biomight.body.male.Scrotum";	
	public final static String SeminiferousTubules = "biomight.body.male.SeminiferousTubules";	
	public final static String Septum = "biomight.body.male.Septum";	
	public final static String SinusOfEpididymis = "biomight.body.male.SinusOfEpididymis";	
	public final static String Teste = "biomight.body.male.Teste";	
	public final static String TunicaAlbuginea = "biomight.body.male.TunicaAlbuginea";	
	public final static String UrethralBulb = "biomight.body.male.UrethralBulb";	
	public final static String VasDeferens = "biomight.body.male.VasDeferens";	
	public final static String VisceralTunicaVaginalis = "biomight.body.male.VisceralTunicaVaginalis";	
	public final static String TunicaVaginalis = "biomight.body.male.TunicaVaginalis";	

	public final static String Vagina = "biomight.body.female.Vagina";
	public final static String LeftBreast = "biomight.body.LeftBreast";
	public final static String RightBreast = "biomight.body.RightBreast";

	public final static String Buttocks = "biomight.body.buttock.Buttocks";
	public final static String RightButtock = "biomight.body.buttock.RightButtock";		 
	public final static String LeftButtock = "biomight.body.buttock.LeftButtock";	
	
	public final static String Backgrounds  = "biomight.grafx.Backgrounds";
	
}
