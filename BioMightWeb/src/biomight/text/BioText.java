/*
 * Created on Oct 25, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.text;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;

import javax.naming.InitialContext;

import biomight.BioMightBase;
import biomight.Constants;
import biomight.ejb.BioMightBeanLocal;
import biomight.ejb.BioMightSymbolsBeanLocal;
import biomight.exceptions.ServerException;
import biomight.util.BioGraphics;
import biomight.view.BioMightMethodView;
import biomight.view.BioMightPosition;
import biomight.view.BioMightPropertyView;
import biomight.view.BioMightTexture;
import biomight.view.BioMightTransform;


/************************************************************************************
 * @author SurferJim
 *
 * Representation of a BioText.  It is composed of proteins.
 * 
 ************************************************************************************/

public class BioText extends BioMightBase {	
	private BioMightPosition bioMightPosition;
	protected HashMap fontsDDMap = new HashMap();
		
	
/************************************************************************
 * BioText Constructor 
 *
 ***********************************************************************/
public BioText()
{
	int localVP= Constants.VIEW_HAWKEYE;
	int localLOD = Constants.MAG1X;
	create(localVP, localLOD, Constants.BioTextRef, null, null);
}

/************************************************************************
 * BioText Constructor 
 *
 ***********************************************************************/
public BioText(String parentID)
{
	System.out.print("Calling parameterized BioText Constructor!");
	int localVP= Constants.VIEW_HAWKEYE;
	int localLOD = Constants.MAG1X;
	create(localVP, localLOD, parentID, null, null);
}


/************************************************************************
 * BioText Constructor 
 *
 ***********************************************************************/
public BioText(int localVP, int localLOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
{
	System.out.println("Calling BioText with LOD: " + localVP + "  " + localLOD);
	create(localVP, localLOD, parentID, bioMightProperties, bioMightMethods);
}



/************************************************************************
 * Create BioText
 *
 ***********************************************************************/

public void create(int localVP, int localLOD, String parentID, ArrayList<BioMightPropertyView> bioMightProperties, ArrayList<BioMightMethodView> bioMightMethods)
{
			this.setImage("images/BioText.jpg");
			this.setImageHeight(300);
			this.setImageWidth(300);
			this.parentID = parentID;

			loadFonts();
			
			if (bioMightMethods != null){
				System.out.println("EXECUTING BioText Methods: " + bioMightMethods.size());
				executeMethods(bioMightMethods);
			}
		
			
			if (localVP == Constants.VIEW_INTERNAL)			
			{
				// Do nothing.  We are instantiating as part of a collection  
				// There is no drill down, so we use the transforms that the
				// parent has already collected
				componentID = parentID;
				System.out.println("In BioText Create() Internal - Already Set: " + parentID  + "   ComponentID: " + componentID);				
				
				// Generate the Heart Ventricle Endothelium if needed 
				boolean bGenerate = false;
				if (bGenerate) {
					generate(parentID, componentID);
				}

			}	
			else if (localVP == Constants.VIEW_HAWKEYE)
			{
				// We drilled in from the BioText Collection.  
				componentID = parentID;
				System.out.println("In BioText Create-HawkEye - Already Set: " + parentID  + "   ComponentID: " + componentID);				
				
				boolean bGenerate = false;
				if (bGenerate) {
					generate(parentID, componentID);
				}
				
				// This is when one is accessing a BioText directly
				// Get the information from the database via the Enterprise Bean		
				try {
					// Get the information from the database via the Enterprise Bean		
					System.out.println("Getting HawkEye BioTextInfo for ParentID: " + parentID);
					InitialContext ctx = new InitialContext();
					BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);
					bioMightTransforms = bioMightBean.getComponent(parentID);
					System.out.println("Have BioText Info from EJB");   	
				}catch (Exception e) { 
					System.out.println("Exception Getting Components - BioText");
					throw new ServerException("Remote Exception getComponents():", e); 	
				}
					
				// Run through the collection of BioTexts and build them into the model
				// In the default case, we get one instance of the BioText for each eye
				ArrayList transforms = bioMightTransforms.getTransforms();
				System.out.println("BioText NumTransforms: " + transforms.size());
				for (int i=0; i<transforms.size(); i++)
				{
					// Get the information for the BioText
					BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
					System.out.println("Creating BioText: " + bioMightTransform.getName() + "  " + bioMightTransform.getId());
					this.componentID = bioMightTransform.getId();
					
					
					
					// initialize the Properties
					initProperty(bioMightTransform.getName(), Constants.BioText, Constants.BioTextRef, bioMightTransform.getId());

				}
			}
			else
			{
				System.out.println("LOD was not FOUNDIE");	
			}
				
			initMethods();
			
			System.out.println("CreateBioText Completed");
			
			// First, get all the data from the database
			// Apply the methods to it
			// Save its state
			this.parentID = parentID;
		}
		

	
		private void initProperties() {

			properties = new ArrayList<BioMightPropertyView>();
			
			BioMightPropertyView property = new BioMightPropertyView();
			property.setPropertyName("BioText");
			property.setCanonicalName(Constants.BioText);
			properties.add(property);
		}
		
		
		/****************************************************
		 * GENERATE BIOTEXT
		 * 
		 * 
		 * @param parentID
		 * @param componentID
		 ***************************************************/
		public void generate(String parentID, String componentID)
		{
			// Generate the BioText		
			try {
				// Get the information from the database via the Enterprise Bean		
				System.out.println("Generating the BioText : " + componentID + "    " + parentID);
				InitialContext ctx = new InitialContext();
				BioMightSymbolsBeanLocal bioMightBean = (BioMightSymbolsBeanLocal) ctx.lookup(Constants.BioSymbolsBeanRef);
				
				
				double circumference = 0.125;
				if (componentID.equals("BioText:00001")) {
					
					// Generate the Palm
					double[] startPos = {-3.75, 2.0, 0.0};
					double[][] currentPoints = BioGraphics.createCylinderInPlane(Constants.XPLANE, startPos, circumference, 8);

					int success = bioMightBean.generateBioTexts(1, "BioText:00001", "BioText", 
							"BioText", componentID, parentID, currentPoints);								
				}
				else if (componentID.equals("BioText:00002"))
				{
					// Generate the Elbow
					double[] startPos = {-3.75, 4.0, 0.0};
					double[][] currentPoints = BioGraphics.createCylinderInPlane(Constants.XPLANE, startPos, circumference, 8);

					int success = bioMightBean.generateBioTexts(1,"BioText:00002", "BioText", 
						"BioText", componentID, parentID, currentPoints);
			
					
				}
				else if (componentID.equals("BioText:00003"))
				{
					// Generate the Elbow
					double[] startPos = {-3.75, 0.0, 0.0};
					double[][] currentPoints = BioGraphics.createCylinderInPlane(Constants.XPLANE, startPos, circumference, 8);

					int success = bioMightBean.generateBioTexts(1,"BioText:00003", "BioText", 
						"BioText", componentID, parentID, currentPoints);
			
					
				}			
				else if (componentID.equals("BioText:00004"))
				{
					// Generate the Elbow
					double[] startPos = {-3.75, -4.0, 0.0};
					double[][] currentPoints = BioGraphics.createCylinderInPlane(Constants.XPLANE, startPos, circumference, 8);

					int success = bioMightBean.generateBioTexts(1,"BioText:00004", "BioText", 
						"BioText", componentID, parentID, currentPoints);
			
					
				}	
				else if (componentID.equals("BioText:00005"))
				{
					// Generate the Elbow
					double[] startPos = {-3.75,-8.0, 0.0};
					double[][] currentPoints = BioGraphics.createCylinderInPlane(Constants.XPLANE, startPos, circumference, 8);

					int success = bioMightBean.generateBioTexts(1,"BioText:00005", "BioText", 
						"BioText", componentID, parentID, currentPoints);
			
					
				}	
				else if (parentID.equals("")) 
				{	
					System.out.println("Calling Generate BioText NoParent");		
				}
			
				
				System.out.println("Created BioText Info using EJB");   	
			}catch (Exception e) { 
				System.out.println("Exception Getting Components - BioText");
				throw new ServerException("Remote Exception BioText():", e); 	
			}
		}
		
		
		/*********************************************************************
		 * INIT METHODS
		 * 
		 * 
		 ********************************************************************/
		public void initMethods() {
				
			
			BioMightMethodView method = new BioMightMethodView();
			method.setCanonicalName(Constants.BioText);
			method.setMethodName("setText");
			method.setDisplayName("Text:");
			method.setHtmlType("text");
			method.setDataType(Constants.BIO_TEXT);
			methods.add(method);

			method = new BioMightMethodView();
			method.setCanonicalName(Constants.BioText);
			method.setMethodName("setFont");
			method.setDisplayName("Font:");
			method.setHtmlType(Constants.BIO_DROPDOWN);
			method.setDataType(Constants.BIO_INT);
		 	method.setValueMap(fontsDDMap);
			methods.add(method);
		
			method = new BioMightMethodView();
			method.setCanonicalName(Constants.BioText);
			method.setMethodName("setMaterial");
			method.setDisplayName("setColor");
			method.setHtmlType(Constants.BIO_DROPDOWN);
			method.setDataType(Constants.BIO_INT);
		 	method.setValueMap(materialDDMap);
			methods.add(method);
			
			method = new BioMightMethodView();
			method.setCanonicalName(Constants.BioText);
			method.setMethodName("setTexture");
			method.setDisplayName("setTexture");
			method.setHtmlType(Constants.BIO_DROPDOWN);
			method.setDataType(Constants.BIO_INT);
		 	method.setValueMap(textureDDMap);
			methods.add(method);
		}
		
		
		/********************************************************************************************************************
		 * GET X3D
		 * 
		 * This method will return the X3D for the Cell.  It runs through each of its components and collects up their
		 * representations and then assembles them into one unified X3D model.
		 * 
		 ********************************************************************************************************************/
		public String getX3D(boolean snipet) {
			
			// Assembe the BioText
			String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
			"<!DOCTYPE X3D PUBLIC \"ISO//Web3D//DTD X3D 3.0//EN\" \"http://www.web3d.org/specifications/x3d-3.0.dtd\">\n " +
			"<X3D profile='Immersive' >\n" +
			"<head>\n" +
			 "<meta name='BioMightImage' content='BioText.jpg'/>\n" +
			 "<meta name='ExportTime' content='7:45:30'/>\n" +
			 "<meta name='ExportDate' content='08/15/2008'/>\n" +
			 "<meta name='BioMight Version' content='1.0'/>\n" + 
			"</head>\n" +
			"<Scene>\n" +
			"<WorldInfo\n" +
			"title='BioText'\n" +
			"info='\"BioMight Generated X3D\"'/>\n";		

			String body = "";
			String annotate = "";
			
			
			// Only when the database retrieval has been locally, do we do this??
			lod = Constants.VIEW_HAWKEYE;
			if (lod == Constants.VIEW_HAWKEYE) 
			{			
				ArrayList transforms = bioMightTransforms.getTransforms();
				for (int i=0; i<transforms.size(); i++)
				{
					// Get the information for the capsomer we are creating
					BioMightTransform bioMightTransform = (BioMightTransform) transforms.get(i);
					System.out.println("Creating BioText: " + bioMightTransform.getName() + "  " + bioMightTransform.getId()  +  "  " + transforms.size());
					System.out.println("Creating BioText at Position: " + 
							bioMightTransform.getTranslation().getXPos() + "  " +
							bioMightTransform.getTranslation().getYPos() + "  " +
							bioMightTransform.getTranslation().getZPos());
					//System.out.println("Getting X3D for BioTextX: " + bioMightTransform.getTranslation().getXPos());
					//System.out.println("Getting X3D for BioTextY: " + bioMightTransform.getTranslation().getYPos());
					//System.out.println("Getting X3D for BioTextZ: " + bioMightTransform.getTranslation().getZPos());
					// Change the height and width based on the displacement.
					body += "\n<Transform DEF='BioText'\n";
					
					body += "translation='" 
				 			+ bioMightTransform.getTranslation().getXPos() + " " 
	 						+ bioMightTransform.getTranslation().getYPos() + " "
	 						+ bioMightTransform.getTranslation().getZPos() + "'\n";				
					
					body += "rotation='" 
				 			+ bioMightTransform.getOrientation().getXAxis() + " " 
	 						+ bioMightTransform.getOrientation().getYAxis() + " "
	 						+ bioMightTransform.getOrientation().getZAxis() +  " "
	 						+ bioMightTransform.getOrientation().getDegrees() + "'\n";
					 					
					body +=  "scale='" 	
						+ bioMightTransform.getScale().getXScale() + " "
					 	+ bioMightTransform.getScale().getYScale() + " "
					 	+ bioMightTransform.getScale().getZScale() + "'>\n";
				
			
					body += 
					"<SHAPE>\n" 
				    + "<Appearance>\n"; 
					
					// Texture
					body+= " <ImageTexture containerField='texture' " +
						    " url='../images/SpeckledPink.png'/>";
				
					// Material
					body+= " <Material DEF='Rust'\n" +
					    "containerField='material'\n" +
					    "ambientIntensity='" + bioMightTransform.getMaterial().getAmbientIntensity() + "'\n" +
					  
					    "shininess='" 		  + bioMightTransform.getMaterial().getShininess() + "'\n" +
					    "transparency='" 	  + bioMightTransform.getMaterial().getTransparency() + "'\n" +
					    "diffuseColor='" + 
					 	    bioMightTransform.getMaterial().getDiffuseColor().getRed() + " " + 
					 	    bioMightTransform.getMaterial().getDiffuseColor().getGreen() + " " +
					 	    bioMightTransform.getMaterial().getDiffuseColor().getBlue() + "'/>\n" +    
					 	"</Appearance>\n" +
				
					  	// Text Definition
						"<Text DEF='BioText'\n" +
						"containerField='geometry'\n" +
							"string='" + bioMightTransform.getBioText() +"'\n" +
							"maxExtent='"+ bioMightTransform.getBioMightText().getMaxEnt() +  "'>\n" +
							
							// Font Definition
							"<FontStyle\n" +
							"containerField='fontStyle'\n" +
							"family='"+ bioMightTransform.getBioMightText().getFamily() +"'\n" + 
							"style='"+ bioMightTransform.getBioMightText().getStyle() + "'\n" + 
							"justify='\"BEGIN\" \"BEGIN\"'\n" +
							"size='"+ bioMightTransform.getBioMightText().getSize() + "'\n" + 
							"spacing='"+ bioMightTransform.getBioMightText().getSpacing()  + "'/>\n" +
							
						"</Text>\n" +
					"</SHAPE>\n" +
					
					 "</Transform>\n";
					
					body+= "<Viewpoint DEF='Viewpoint_BioTexts'\n" +
							 "description='Viewpoint1'\n" +
							 "jump='true'\n" +
							 "fieldOfView='0.785'\n" +
							 "position='0.0 0.0 30.0'\n" +
							 "orientation='0 0 1 0'/>\n";

					}
			}
			else
			{
				body = "";					
			}
			
			
			//System.out.println("BioText X3D: " + body);		
			String footer = "</Scene>" + "</X3D>\n";
			
			if (snipet)
				return body;			
			else	
				return header + body + annotate + footer;				
		}
		
		/******************************************************************************************
		 * EXECUTE METHODS 
		 *
		 ******************************************************************************************/
		public void executeMethods(ArrayList<BioMightMethodView> bioMightMethods) {

			// Run through the argument list and executes the 
			// associated methods
			boolean fired = false;
			System.out.println("BioText-Executing Methods: " + bioMightMethods.size());
			for (int j=0; j<bioMightMethods.size(); j++){
				System.out.println("BioText-Executing Methods: " + j);
				
				// Get the parameter from the list and if it is not
				// empty execute the associated method using it
				BioMightMethodView bioMightMethod = (BioMightMethodView) bioMightMethods.get(j);
				System.out.println("Have BioMightMethod for BioText: " + bioMightMethod.getCanonicalName() + "   " + bioMightMethod.getMethodName());	
				String methodName = bioMightMethod.getMethodName();
				String canonicalName = bioMightMethod.getCanonicalName(); 
				String dataType = bioMightMethod.getDataType();
				//String dataType = bioMightMethod.getDataType();
				String methodParam = bioMightMethod.getMethodParameter(); 
				if (methodParam == null)
					methodParam = "";
				
				// We only execute those methods that are targeted for the IRIS
				// If a parameter is specified then we fire the method, otherwise
				// we just jump over it
				if (canonicalName.equals(Constants.BioText)) {				
					if (!methodParam.equals(""))
					{
						System.out.println("Execute Method " + methodName + " with Signature: "  +  dataType);
						System.out.println("with DataType: "  +  dataType  + "   value: " + methodParam);
						
						fired=true;		
						// Use the DataType parameter to convert the data into its base form
					
						if (dataType.equals(Constants.BIO_INT)) {
							
							try {
								System.out.println("Locating Method(Integer)" + methodName);
								// 	Locate the method through introspection
								int numElements = Integer.parseInt(methodParam);
								Class paramsType[] = {int.class};
								Method method = this.getClass().getMethod(methodName, paramsType);
								System.out.println("Before Execute Method(Integer)" + methodName);
								Object result = method.invoke(this, numElements);
								System.out.println("After Execute Method(Integer)" + methodName);	
							}
							catch (NumberFormatException e)
							{
								System.out.println("Could not Convert to int: " + methodParam);						
							}
							catch (NoSuchMethodException e)
							{
								System.out.println("Method with int param not found: " + e);						
							}	
							catch (Exception e)
							{
								System.out.println("General Exception occurred: " + e);						
							}										
						}
						else if (dataType.equals(Constants.BIO_DOUBLE)) {
						
							try {
								System.out.println("Locating Method(Double)" + methodName);
								// Locate the method through introspection
								double numElements = Double.parseDouble(methodParam);
								if (numElements > 0.0)
								{
									Class paramsType[] = {double.class};
									Method method = this.getClass().getDeclaredMethod(methodName, paramsType);
									System.out.println("Before Execute Method(Double)" + methodName);
									Object result = method.invoke(this, numElements);
									System.out.println("After Execute Method(Double)" + methodName);
								}
								else
									System.out.println("Not Executing Double - 0.0"); 
								}
								catch (NumberFormatException e)
								{
									System.out.println("Could not Convert to double: " + methodParam);						
								}
								catch (NoSuchMethodException e)
								{
									System.out.println("Method with double param not found: " + e);						
								}	
								catch (Exception e)
								{
									System.out.println("General Exception: " + e);						
								}										
						}
						else if (dataType.equals(Constants.BIO_TEXT)) {
							
							
							try {
								System.out.println("Locating Method(String)");
								
								Class paramsType[] = {String.class};
								Method method = this.getClass().getDeclaredMethod(methodName, paramsType );
								System.out.println("Method with String Param: " + methodName);
								
								System.out.println("Before Execute Method(String)" + methodName);
								Object result = method.invoke(this, methodParam);
								System.out.println("After Execute Method(String)" + methodName);
										
							}
							catch (NoSuchMethodException e)
							{
								System.out.println("Method with String param not found!");						
							}	
							catch (Exception e)
							{
								System.out.println("General Exception: " + e);						
							}	
							
						}
						else if (dataType.equals("")) {
							System.out.println("Data Type not found!!!");	
						}	
					}	
				}
				if (fired)
				{	
					System.out.println("BioTexts - Methods have fired.   Calling BioTexts Save method!");
				}
			}
		}
		

		/******************************************************************************************
		 * SET TEXT
		 *
		 * This method will set the Colony size for the BioTexts.  
		 *****************************************************************************************/
		public void setText(String compDesc) {

			// Run through the argument list and executes the 
			// associated methods
			boolean fired = false;
			System.out.println("BioText-SetText: " + compDesc);
			
			// Generate the BioText		
			BioMightSymbolsBeanLocal bioMightBean;
			try {
				// Get the information from the database via the Enterprise Bean		
				System.out.println("Setting the BioText: " + this.componentID + "    " + this.parentID);
				InitialContext ctx = new InitialContext();
				bioMightBean = (BioMightSymbolsBeanLocal) ctx.lookup(Constants.BioSymbolsBeanRef);
			    		 					
				double currentPoints[][] = null;
				System.out.println("Calling SetText() for: " + parentID);
				int success = bioMightBean.setComponentDesc(this.parentID, compDesc);
				
				System.out.println("Set BioText using EJB");   	
			}catch (Exception e) { 
				System.out.println("Exception SetText() - BioText");
				throw new ServerException("Remote Exception BioText():", e); 	
			}
		}

		/******************************************************************************************
		 * SET FONT
		 *
		 * This method will set the Font for the selected BioText.  
		 *****************************************************************************************/
		public void setFont(int font) {

			// Run through the argument list and executes the 
			// associated methods
			boolean fired = false;
			System.out.println("BioText-SetFont: " + font);
			
			// Generate the BioText		
			BioMightSymbolsBeanLocal bioMightBean;
			try {
				// Get the information from the database via the Enterprise Bean		
				System.out.println("Setting the BioText Font: " + this.componentID + "    " + this.parentID);
				InitialContext ctx = new InitialContext();
				bioMightBean = (BioMightSymbolsBeanLocal) ctx.lookup(Constants.BioSymbolsBeanRef);
			    		 					
				double currentPoints[][] = null;
				System.out.println("Calling SetFont for: " + parentID);
				int success = bioMightBean.setComponentFont(this.parentID, font);
				
				System.out.println("Set BioText Font using EJB");   	
			}catch (Exception e) { 
				System.out.println("Exception SetFont() - BioText");
				throw new ServerException("Remote Exception BioText():", e); 	
			}
		}
		

		/******************************************************************************************
		 * LOAD FONT
		 *
		 * This method will set the Font for the selected BioText.  
		 *****************************************************************************************/
		
		public void loadFonts() {
			try {
				// Get the information from the database via the Enterprise Bean		
				System.out.println("Getting Fonts: " + componentID + "    " + parentID);
				InitialContext ctx = new InitialContext();
				BioMightBeanLocal bioMightBean = (BioMightBeanLocal) ctx.lookup(Constants.BioMightBeanRef);	
				fontsDDMap = bioMightBean.getFontsDDMap();						
				System.out.println("Have Fonts" + fontsDDMap.size()); 		
			} 
			catch (Exception e)
			{
				//System.out.println("BioMightBase: Exception - Getting Textures");
			}
		}
		
}
