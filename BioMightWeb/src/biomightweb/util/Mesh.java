package biomightweb.util;
import java.util.ArrayList;

public class Mesh {

	// Each x position has an arraylist of y and z point that define how the 
	// entity extends from the baseline.
	private String id;
	private double x;
	private ArrayList y;
	private ArrayList z;
	
	
	public Mesh()
	{
		x=0;
		y = new ArrayList();
		z = new ArrayList();
	}


	public double getX() {
		return x;
	}


	public void setX(double x) {
		this.x = x;
	}

	public ArrayList getY() {
		return y;
	}


	public void setY(int i, double yVal) {
		this.y.add(i, yVal);
	}
	
	public void setY(ArrayList y) {
		this.y = y;
	}

	public ArrayList getZ() {
		return z;
	}


	public void setZ(ArrayList z) {
		this.z = z;
	}

	public void setZ(int i, double zVal) {
		this.z.add(i, zVal);
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


}

