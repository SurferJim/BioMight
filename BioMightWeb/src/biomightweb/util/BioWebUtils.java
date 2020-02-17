package biomightweb.util;

import java.util.ArrayList;

import biomight.view.BioMightPropertyView;

public class BioWebUtils {

	// True is the default
	public static boolean isViewEnabled(String propertyName, ArrayList<BioMightPropertyView> bioMightProperties){
		boolean isEnabled = true;
		
		if (bioMightProperties == null) {
			//System.out.println("Properties are null - view is enabled");
			return isEnabled;
		}
		
		for (int i=0; i<bioMightProperties.size(); i++)
		{
			BioMightPropertyView bioMightPropertyView = (BioMightPropertyView) bioMightProperties.get(i);
		
			//System.out.println("Checking: " + propertyName + " vs " + bioMightPropertyView.getPropertyName() + "   "  +  bioMightPropertyView.isViewEnabled());
			
			if (bioMightPropertyView.getPropertyName().equals(propertyName)) {
				isEnabled = bioMightPropertyView.isViewEnabled();
			}
		}
		
		return (isEnabled);
	}
	

	/***********************************************************************************************
	 * GET PROPERTY ID
	 * @param propertyName
	 * @param bioMightProperties
	 * @return
	 ***********************************************************************************************/
	public static String getPropertyID(String propertyName, ArrayList<BioMightPropertyView> bioMightProperties){
		String propertyID = "";
		
		if (bioMightProperties == null) {
			//System.out.println("Properties are null - view is enabled");
			return "";
		}
		
		for (int i=0; i<bioMightProperties.size(); i++)
		{
			BioMightPropertyView bioMightPropertyView = (BioMightPropertyView) bioMightProperties.get(i);
		
			System.out.println("Checking: " + propertyName + " vs " + bioMightPropertyView.getPropertyName() + "   "  +  bioMightPropertyView.isViewEnabled());
			
			if (bioMightPropertyView.getPropertyName().equals(propertyName)) {
				propertyID = bioMightPropertyView.getPropertyID();
				System.out.println("Located: " + propertyName + " = " + bioMightPropertyView.getPropertyName() + "   "  +  bioMightPropertyView.isViewEnabled());
				break;
			}
		}

		System.out.println("PropertyID is: " + propertyID);
		return (propertyID);
	}

	

	/***********************************************************************************************
	 * GET PROPERTY ID
	 * @param propertyName
	 * @param bioMightProperties
	 * @return
	 ***********************************************************************************************/
	public static  ArrayList disableProperty(String propertyName, ArrayList<BioMightPropertyView> bioMightProperties){
		String propertyID = "";
		
		if (bioMightProperties == null) {
			//System.out.println("Properties are null - view is enabled");
			return bioMightProperties;
		}
		
		for (int i=0; i<bioMightProperties.size(); i++)
		{
			BioMightPropertyView bioMightPropertyView = (BioMightPropertyView) bioMightProperties.get(i);		
			if (bioMightPropertyView.getPropertyName().equals(propertyName)) {
				propertyID = bioMightPropertyView.getPropertyID();
				
				System.out.println("Located: " + propertyName + " = " + bioMightPropertyView.getPropertyName() + "   "  +  bioMightPropertyView.isViewEnabled());
				bioMightPropertyView.setViewEnabled(false);
				break;
			}
		}
		
		return (bioMightProperties);
	}
	
	
	/*****************************************************************************
	 * MAP COLOR - Sets the color of the CellMembrane
	 * 
	 * Set the color of the CellMembrane
	 * 
	 *****************************************************************************/
	public static int mapColor(String color) {

		int numColor = 0;
		
		String tempColor = color.toUpperCase();
		if (tempColor.equals("BLUE"))
			numColor=1;
		else if (tempColor.equals("GREEN"))
			numColor=2;
		else if (tempColor.equals("RED"))
			numColor=3;
		else if (tempColor.equals("BROWN"))
			numColor=4;		
		else if (tempColor.equals("HAZEL"))
			numColor=5;		
		else if (tempColor.equals("BLACK"))
			numColor=6;	
		else if (tempColor.equals("WHITE"))
			numColor=7;
		else if (tempColor.equals("BLUE GRAY"))
			numColor=8;
		else if (tempColor.equals("LIGHT BROWN"))
			numColor=47;
		else if (tempColor.equals("DARK BROWN"))
			numColor=48;
		else if (tempColor.equals("BLONDE"))
			numColor=49;
		else if (tempColor.equals("PURPLE"))
			numColor=50;
		else if (tempColor.equals("GOLD"))
			numColor=52;
		else if (tempColor.equals("LIGHT GREEN"))
			numColor=70;
		else if (tempColor.equals("DARK GREEN"))
			numColor=71;
		else if (tempColor.equals("LIGHT BLUE"))
			numColor=72;
		else if (tempColor.equals("DARK BLUE"))
			numColor=73;
		else if (tempColor.equals("PINK"))
			numColor=78;		
		else if (tempColor.equals("PALE YELLOW"))
			numColor=19;
		
		
		return numColor;
	}
	
	
	
	 public static double randomWithRange(double min, double max)
	{
	   double range = Math.abs(max - min);     
	   return (Math.random() * range) + (min <= max ? min : max);
	}
	
	
}
