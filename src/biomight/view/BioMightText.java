/*
 * Created on May 21, 2007
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.view;
import java.io.Serializable;

/**
 * @author SurferJim
 *
 * An object that represents a material
 * 
 */

public class BioMightText implements Serializable {
	private int    id;
	private double name;
	private double maxEnt;
	private String style;
	private String family;
	private String justify;
	private double size;
	private double spacing;
	
	
	public BioMightText() {

	}
	
	public BioMightText(String name, double maxEnt, String style, String family, String justify, double size, double spacing) {

	}
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getName() {
		return name;
	}

	public void setName(double name) {
		this.name = name;
	}

	public double getMaxEnt() {
		return maxEnt;
	}

	public void setMaxEnt(double maxEnt) {
		this.maxEnt = maxEnt;
	}



	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
	}

	public String getFamily() {
		return family;
	}

	public void setFamily(String family) {
		this.family = family;
	}

	public String getJustify() {
		return justify;
	}

	public void setJustify(String justify) {
		this.justify = justify;
	}

	public double getSize() {
		return size;
	}

	public void setSize(double size) {
		this.size = size;
	}

	public double getSpacing() {
		return spacing;
	}

	public void setSpacing(double spacing) {
		this.spacing = spacing;
	}

	
}
