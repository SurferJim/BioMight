/*
 * Created on Apr 26, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.cell;
import java.util.ArrayList;

import javax.naming.InitialContext;

import biomight.BioMightBase;
import biomight.Constants;
import biomight.cell.autonomicneuron.AndrenergicNeuralCell;
import biomight.cell.autonomicneuron.CholinergicNeuralCell;
import biomight.cell.autonomicneuron.PeptidergicNeuralCell;
import biomight.cell.barrierfunction.DuctCell;
import biomight.cell.barrierfunction.KidneyCollectingDuctCell;
import biomight.cell.barrierfunction.KidneyGlomerulusParietalCell;
import biomight.cell.barrierfunction.KidneyGlomerulusPodocyte;
import biomight.cell.barrierfunction.LoopOfHenleThinSegmentCell;
import biomight.cell.barrierfunction.LungPneumocyte;
import biomight.cell.barrierfunction.NonStraitedDuctCell;
import biomight.cell.barrierfunction.PancreaticDuctCell;
import biomight.cell.bloodandimmune.Agranulocyte;
import biomight.cell.bloodandimmune.AlveolarMacrophage;
import biomight.cell.bloodandimmune.B1Cell;
import biomight.cell.bloodandimmune.B2Cell;
import biomight.cell.bloodandimmune.BasophilGranulocyte;
import biomight.cell.bloodandimmune.AnimalCells;
import biomight.cell.bloodandimmune.CytotoxicTCell;
import biomight.cell.bloodandimmune.Eosinophils;
import biomight.cell.bloodandimmune.Erythrocyte;
import biomight.cell.bloodandimmune.Macrophages;
import biomight.ejb.BioMightBeanLocal;
import biomight.exceptions.ServerException;
import biomight.view.BioMightMethodView;
import biomight.view.BioMightPosition;
import biomight.view.BioMightPropertyView;
import biomight.view.BioMightScale;
import biomight.view.BioMightTransform;


/**********************************************************************************************
 * @author SurferJim
 *
 * Represntation of a Cell Collection
 * 
 *********************************************************************************************/

public class Cells extends BioMightBase {
	BioMightTransform gbioMightTransform; 
	private ArrayList colors;
	
	
	private AndrenergicNeuralCell andrenergicNeuralCell;
	private CholinergicNeuralCell cholinergicNeuralCell;
	private PeptidergicNeuralCell peptidergicNeuralCell;
	
	private DuctCell ductCell;
	private KidneyCollectingDuctCell kidneyCollectingDuctCell;
	private KidneyGlomerulusParietalCell kidneyGlomerulusParietalCell;
	private KidneyGlomerulusPodocyte kidneyGlomerulusPodocyte;
	private LoopOfHenleThinSegmentCell loopOfHenleThinSegmentCelll;
	private LungPneumocyte lungPneumocyte;
	private NonStraitedDuctCell NonStraitedDuctCell;
	private PancreaticDuctCell PancreaticDuctCell;
	
	private Agranulocyte agranulocyte;
	private AlveolarMacrophage alveolarMacrophage;
	private B1Cell b1Cell;
	private B2Cell b2Cell;
	private AnimalCells basophils;
	private BasophilGranulocyte basophilGranulocyte;
	private Eosinophils eosinophils;
	private Erythrocyte erythrocyte;
	private Macrophages macrophages;

	
	/************************************************************************
	 * Cells Constructor 
	 *
	 ***********************************************************************/
	public Cells()
	{
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, Constants.CellsRef, null, null);
	}

	/************************************************************************
	 * Cells Constructor 
	 *
	 ***********************************************************************/
	public Cells(String parentID)
	{
		//System.out.println("Calling parameterized Cells Constructor!");
		int localVP= Constants.VIEW_HAWKEYE;
		int localLOD = Constants.MAG1X;
		create(localVP, localLOD, parentID, null, null);
	}
	
	/************************************************************************
	 * Cells Constructor 
	 *
	 ***********************************************************************/
	public Cells(int hierarchy, int LOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
	{
		System.out.println("Calling Cells with LOD!");
		create(hierarchy, LOD, parentID, bioMightProperties, bioMightMethods);
	}
	
	
	/************************************************************************
	 * Create Cells
	 *
	 ***********************************************************************/

	public void create(int hierarchy, int LOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
	{
		this.setImage("images/Cell.jpg");
		this.setImageHeight(300);
		this.setImageWidth(300);

		System.out.println("Creating Cells (Library View): " + parentID);
						
		// Get the data for the Cell that is defined for this 
		// Cell reference
		try {
			// Get the information from the database via the Enterprise Bean		
			//System.out.println("Getting CellsInfo for ParentID: " + parentID);
			InitialContext ctx = new InitialContext();
			BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
			bioMightTransforms = bioMightBean.getComponents(Constants.CellsRef, parentID);
			//System.out.println("Have Cells Info from EJB");   	
		}catch (Exception e) { 
			System.out.println("Exception Getting Components - Cells");
			throw new ServerException("Remote Exception getComponents():", e); 	
		}
		
		
		// Create a properties list for the client to use for interaction
		properties = new ArrayList<BioMightPropertyView>();
		
		// Run through the collection of Bodys and build them into the model
		// In the default case, we get one instance of the Body for each eye
		ArrayList transforms = bioMightTransforms.getTransforms();
		System.out.println("Have Cells, NumTransforms: " + transforms.size());

	
		// There will be only 1 instance of the Cell Library in the database
		for (int i=0; i<transforms.size(); i++)
		{
			// Get the information for the eye we are creating
			BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
			
			// A hack, I am using the values down below in the X3D method to set some appearance  and material values
			gbioMightTransform  = bioMightTransform;
			componentID = bioMightTransform.getId();
			
			System.out.println("Creating Cells: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
	
			int viewpoint = Constants.VIEW_INTERNAL;
			if (viewpoint == Constants.VIEW_INTERNAL)
			{
				// Just create an internal representation 
				// using the data from the default properties
				initProperties();
			}
			else  if (viewpoint == Constants.VIEW_HAWKEYE)
			{
				//String dimensions = "0.00, 0.00, 0.00";
				//String bioPos = "0.00, 0.00, 0.00";
				BioMightScale bioScale = new BioMightScale("0.00, 0.00, 0.00");
				BioMightPosition bioPos = new BioMightPosition("0.00, 0.00, 0.00");

				String bioTemplate="Cell.x3d";
				
				System.out.println("In Cells - Creating Erythrocyte Cell");
				//erythrocyte = new Erythrocyte(bioMightTransform.getId(), bioMightMethods);
				System.out.println("In Cells - Erythrocyte is complete");
				//initProperty("Erythrocyte" Constants.Erythrocyte, Constants.ErythrocyteRef, erythrocyte.getComponentID());
		
				System.out.println("In Cells - Creating Basophils");		
				int localVP = Constants.VIEW_HAWKEYE;
				int localLOD = Constants.MAG1X;
				basophils = new AnimalCells(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
				System.out.println("In Cells - Basophils are complete");
				initProperty("Basophils", Constants.Basophils, Constants.BasophilsRef, basophils.getComponentID(), bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
						
				System.out.println("In Cells - Creating Eosinophils");
				eosinophils = new Eosinophils(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
				System.out.println("In Cells - Eosinophils are complete");
				initProperty("Eosinophils", Constants.Eosinophils, Constants.EosinophilsRef, eosinophils.getComponentID(), bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
				
				System.out.println("In Cells - Creating Macrophage");
				macrophages = new Macrophages(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
				System.out.println("In Cells - Macrophage is complete");		
				initProperty("Macrophages", Constants.Macrophages, Constants.MacrophagesRef, macrophages.getComponentID(), bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
				
				System.out.println("In Cells - Creating B1Cell");
				b1Cell = new B1Cell(localVP, localLOD, bioMightTransform.getId(), bioMightProperties, bioMightMethods);
				System.out.println("In Cells - B1Cell is complete");
				initProperty("B1Cell", Constants.B1Cell, Constants.B1CellRef, b1Cell.getComponentID());
			}
			
		}
		
	
		//System.out.println("Init Methods");
		initMethods();
		System.out.println("Created Cells (Library View)");				
	}
	
	
	
	public void initProperties() {
		BioMightScale bioScale = new BioMightScale("0.00, 0.00, 0.00");
		BioMightPosition bioPos = new BioMightPosition("0.00, 0.00, 0.00");	
		String bioTemplate =""; 

		initProperty(Constants.BasophilsRef, Constants.Basophils, Constants.BasophilsRef, "Cells:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
		initProperty(Constants.EosinophilsRef, Constants.Eosinophils, Constants.EosinophilsRef, "Cells:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
		initProperty(Constants.ErythrocytesRef, Constants.Erythrocytes, Constants.ErythrocytesRef, "Cells:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
		initProperty(Constants.MacrophagesRef, Constants.Macrophages, Constants.MacrophagesRef, "Cells:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
		initProperty(Constants.NeutrophilsRef, Constants.Neutrophils, Constants.NeutrophilsRef, "Cells:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
		initProperty(Constants.LymphocytesRef, Constants.Lymphocytes, Constants.LymphocytesRef, "Cells:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
		initProperty(Constants.MonocytesRef, Constants.Monocytes, Constants.MonocytesRef, "Cells:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
		initProperty(Constants.NeuronsRef, Constants.Neurons, Constants.NeuronsRef, "Cells:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
		initProperty(Constants.BCellsRef, Constants.BCells, Constants.BCellsRef, "Cells:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
		initProperty(Constants.AnimalCellsRef, Constants.AnimalCells, Constants.AnimalCellsRef, "Cells:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
			
		initProperty(Constants.NOT_ACTIVATED, Constants.Title, Constants.Title, "Cells:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
		initProperty(Constants.AgranulocyteRef, Constants.Agranulocyte, Constants.Agranulocyte, "Cells:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
		initProperty(Constants.AlveolarMacrophageRef, Constants.AlveolarMacrophage, Constants.AlveolarMacrophageRef, "Cells:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
		initProperty(Constants.CholinergicNeuralCellRef, Constants.CholinergicNeuralCell, Constants.CholinergicNeuralCellRef, "Cells:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
		initProperty(Constants.PeptidergicNeuralCellRef, Constants.PeptidergicNeuralCell, Constants.PeptidergicNeuralCellRef, "Cells:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
		initProperty(Constants.DuctCellRef, Constants.DuctCell, Constants.DuctCellRef, "Cells:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
		initProperty(Constants.KidneyCollectingDuctCellRef, Constants.KidneyCollectingDuctCell, Constants.KidneyCollectingDuctCellRef, "Cells:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
		initProperty(Constants.KidneyGlomerulusParietalCellRef, Constants.KidneyGlomerulusParietalCell, Constants.KidneyGlomerulusParietalCellRef, "Cells:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
		initProperty(Constants.KidneyGlomerulusPodocyteRef, Constants.KidneyGlomerulusPodocyte, Constants.KidneyGlomerulusPodocyteRef, "Cells:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
		initProperty(Constants.LoopOfHenleThinSegmentCellRef, Constants.LoopOfHenleThinSegmentCell, Constants.LoopOfHenleThinSegmentCellRef, "Cells:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
		initProperty(Constants.LungPneumocyteRef, Constants.LungPneumocyte, Constants.LungPneumocyteRef, "Cells:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
		initProperty(Constants.NonStraitedDuctCellRef, Constants.NonStraitedDuctCell, Constants.NonStraitedDuctCellRef, "Cells:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
		initProperty(Constants.PancreaticDuctCellRef, Constants.PancreaticDuctCell, Constants.PancreaticDuctCellRef, "Cells:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
		initProperty(Constants.B2CellRef, Constants.B2Cell, Constants.B2CellRef, "Cells:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
		//initProperty(Constants.BasophilGranulocyteRef, Constants.BasophilGranulocyte, Constants.BasophilGranulocyteRef, "Cells:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);

		initProperty(Constants.ChrondocytesRef, Constants.Chrondocytes, Constants.ChrondocytesRef, "Cells:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
		
		initProperty(Constants.HelperTCellRef, Constants.HelperTCell, Constants.HelperTCellRef, "Cells:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
		initProperty(Constants.HelperTh1CellRef, Constants.HelperTh1Cell, Constants.HelperTh1CellRef, "Cells:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
		initProperty(Constants.HelperTh2CellsRef, Constants.HelperTh2Cells, Constants.HelperTh2CellsRef, "Cells:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
	
		initProperty(Constants.HematopoieticStemCellRef, Constants.HematopoieticStemCell, Constants.HematopoieticStemCellRef, "Cells:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
		initProperty(Constants.KuppferCellsRef, Constants.KuppferCells, Constants.KuppferCellsRef, "Cells:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
		initProperty(Constants.LeukocytesRef, Constants.Leukocytes, Constants.LeukocytesRef, "Cells:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
		initProperty(Constants.LymphoidStemCellRef, Constants.LymphoidStemCell, Constants.LymphoidStemCellRef, "Cells:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
	
		initProperty(Constants.MastCellsRef, Constants.MastCells, Constants.MastCellsRef, "Cells:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
		initProperty(Constants.MegaKaryocytesRef, Constants.MegaKaryocytes, Constants.MegaKaryocytesRef, "Cells:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
		initProperty(Constants.MemoryBCellsRef, Constants.MemoryBCells, Constants.MemoryBCellsRef, "Cells:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
		initProperty(Constants.MicroglialCellsRef, Constants.MicroglialCells, Constants.MicroglialCellsRef, "Cells:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
		initProperty(Constants.MonoblastsRef, Constants.Monoblasts, Constants.MonoblastsRef, "Cells:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
		initProperty(Constants.MyeloErythoidProgenitorsRef, Constants.MyeloErythoidProgenitors, Constants.MyeloErythoidProgenitorsRef, "Cells:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
		initProperty(Constants.MyeloidProgenitorsRef, Constants.MyeloidProgenitors, Constants.MyeloidProgenitorsRef, "Cells:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
		initProperty(Constants.NaturalKillerCellsRef, Constants.NaturalKillerCells, Constants.NaturalKillerCellsRef, "Cells:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
		initProperty(Constants.OsteoclastsRef, Constants.Osteoclasts, Constants.OsteoclastsRef, "Cells:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
		initProperty(Constants.PhagocyticCellsRef, Constants.PhagocyticCells, Constants.PhagocyticCellsRef, "Cells:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
		initProperty(Constants.PlasmaBCellsRef, Constants.PlasmaBCells, Constants.PlasmaBCellsRef, "Cells:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
		initProperty(Constants.PlateletsRef, Constants.Platelets, Constants.PlateletsRef, "Cells:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
		initProperty(Constants.PleuralMacrophagesRef, Constants.PleuralMacrophages, Constants.PleuralMacrophagesRef, "Cells:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
		initProperty(Constants.PreBCellsRef, Constants.PreBCells, Constants.PreBCellsRef, "Cells:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
		initProperty(Constants.ProMonocytesRef, Constants.ProMonocytes, Constants.ProMonocytesRef, "Cells:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
		initProperty(Constants.RedBloodCorpusclesRef, Constants.RedBloodCorpuscles, Constants.RedBloodCorpusclesRef, "Cells:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
		initProperty(Constants.RegulatoryTCellsRef, Constants.RegulatoryTCells, Constants.RegulatoryTCellsRef, "Cells:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
		initProperty(Constants.ReticulocytesRef, Constants.Reticulocytes, Constants.ReticulocytesRef, "Cells:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
		initProperty(Constants.StemCellsRef, Constants.StemCells, Constants.StemCellsRef, "Cells:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
		initProperty(Constants.ThrombocytesRef, Constants.Thrombocytes, Constants.ThrombocytesRef, "Cells:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
		initProperty(Constants.ThymocytesRef, Constants.Thymocytes, Constants.ThymocytesRef, "Cells:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);
		initProperty(Constants.ThyrotropesRef, Constants.Thyrotropes, Constants.ThyrotropesRef, "Cells:0", bioPos, bioScale, Constants.SINGLE_COMPONENT, bioTemplate, false);


		
	
		/*
			
		property = new BioMightPropertyView();
		property.setPropertyName("");
		property.setCanonicalName(Constants.Erythrocyte);
		properties.add(property);
		*/
		
	}
	

	public void initMethods() {
		
		BioMightMethodView method;

		method = new BioMightMethodView();
		method.setCanonicalName(Constants.Cells);
		method.setMethodName("setMaterial");
		method.setDisplayName("Material");
		method.setHtmlType(Constants.BIO_DROPDOWN);
		method.setDataType(Constants.BIO_TEXT);
	 	method.setValueMap(materialDDMap);
		methods.add(method);
		
		method = new BioMightMethodView();
		method.setCanonicalName(Constants.Cells);
		method.setMethodName("setTexture");
		method.setDisplayName("Texture");
		method.setHtmlType(Constants.BIO_DROPDOWN);
		method.setDataType(Constants.BIO_TEXT);
	 	method.setValueMap(textureDDMap);
		methods.add(method);

		/*
		method = new BioMightMethodView();
		method.setCanonicalName(Constants.Cells);
		method.setMethodName("setSpatial");
		method.setDisplayName("Spatial:");
		method.setHtmlType("dropdown");
		method.setDataType("String");
     	ArrayList<String> spacialType = new ArrayList<String>();
     	spacialType.add("Top to Bottom");
     	spacialType.add("Left to Right");
     	spacialType.add("Diagonal");
     	spacialType.add("Random Cluster");
    	method.setValues(spacialType);
		method.setDataType("String");
		methods.add(method);
		*/
	}
	
	

	/********************************************************************************************************************
	 * GET X3D
	 * 
	 * This method will return the X3D for the Cells.  It runs through each of its components and collects up their
	 * representations and then assembles them into one unified X3D model.
	 * 
	 ********************************************************************************************************************/
	public String getX3D(boolean snipet) {
		
		// Assemble the Cells
		String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
		"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n " +
		"<X3D profile='Immersive' >\n" +
		"<head>\n" +
		 "<meta name='BioMightImage' content='Cells.jpg'/>\n" +
		 "<meta name='ExportTime' content='7:45:30'/>\n" +
		 "<meta name='ExportDate' content='08/15/2008'/>\n" +
		 "<meta name='BioMight Version' content='1.0'/>\n" + 
		"</head>\n" +
		"<Scene>\n" +
		"<WorldInfo\n" +
		"title='Cells'\n" +
		"info='\"BioMight Generated X3D\"'/>\n";		

		String body = ""; 		
		int viewpoint = Constants.VIEW_INTERNAL;
		if (viewpoint == Constants.VIEW_INTERNAL)
		{
			double xPos = 0.0;
			double yPos = 0.0;
			double zPos = 0.0;
			
			double xScale = 1.0;
			double yScale = 1.0;
			double zScale = 1.0;
			
			String cells[] = {"Basophils","Eosinophils","Macrophages", "B1Cells"};
			for (int i=0; i<cells.length; i++)
			{
				//System.out.println("Creating X3D for : " + cells[i]);				
				
				// Change the height and width based on the displacement.
				body += "\n<Transform DEF='" + cells[i] + "'\n";
						
			 	body += "translation='" 
			 			+ xPos + " " 
 						+ (yPos - i) + " "
 						+ zPos + "'\n";					
				
				//System.out.println("Set Translation: ");				

				body +=  "scale='" 	+ xScale + " "
				 					+ yScale + " "
				 					+ zScale + "'>\n" +
	
				 "\n<Shape DEF='" + cells[i] + "Shape'\n" +
				    " containerField='children'>\n" +
				    " <Appearance\n" +
				    "  containerField='appearance'>\n";

			
				body+= " <ImageTexture containerField='texture' " +
				    " url='../images/" + cells[i] + ".jpg'/>";
					
				    
				body+= " <Material DEF='Rust'\n" +
				    "containerField='material'\n" +
				    "ambientIntensity='" 	+ gbioMightTransform.getMaterial().getAmbientIntensity() + "'\n" +
				    "shininess='" 			+ gbioMightTransform.getMaterial().getShininess() + "'\n" +
				    "transparency='" 		+ gbioMightTransform.getMaterial().getTransparency() + "'\n" +
				    "diffuseColor='" + 
				 	    gbioMightTransform.getMaterial().getDiffuseColor().getRed() + " " + 
				 	    gbioMightTransform.getMaterial().getDiffuseColor().getGreen() + " " +
				 	    gbioMightTransform.getMaterial().getDiffuseColor().getBlue() + "'/>\n" +
				 	"</Appearance>\n" +
				 	"<Sphere DEF='" + cells[i] + "Sphere'\n" +
				 	"containerField='geometry'\n" +
				 	"radius='" + gbioMightTransform.getRadius() +"'/>\n" +
				 	"</Shape>\n" +
				 	
					"\n<TouchSensor DEF='"+cells[i]+"Touch' \n" +
	                   " description='"+cells[i]+"'\n" +
		               " containerField='children'/> \n" +
	
				 "</Transform>\n";
						
				//System.out.println("Set Transform: ");				

			}
	
			
			
			
		}
		else  if (viewpoint == Constants.VIEW_HAWKEYE)
		{
			// We could create an 1 instance of each Cell types by passing in the
			// numElements into the Create method.  Or we can just make a represention of
			// each cell type.
			body =  
					//erythrocyte.getX3D(true) + 
					basophils.getX3D(true) +
					eosinophils.getX3D(true) +
					macrophages.getX3D(true) +
					b1Cell.getX3D(true);
		}
		
		
		//System.out.println("Cell Collection X3D: " + body);
		String footer = "</Scene>" + "</X3D>\n";
		
		if (snipet)
			return body;			
		else	
			return header + body + footer;
	}

	
	
	public void onContact(Object obj)
	{	
		if (obj instanceof CytotoxicTCell)
		{
			// Cytotoxic T Cells will interact strongly
			// if the cell is virus infected.	
		}
	}



}
