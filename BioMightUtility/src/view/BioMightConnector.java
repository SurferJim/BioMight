/*
 * Created on May 21, 2007
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.view;

import java.io.Serializable;
import java.util.HashMap;


/************************************************************************
 * @author SurferJim
 *
 * BIOMIGHT CONNECTOR/ADAPTER/CABLE
 * 
 * This is attached to a Bound Box for a BioMight component.  It has
 * the connectors that allow it to hook up to other bioMight components
 * 
 * NOT SURE - a connector should only have one point, But if this is a
 * cable, then we run through have connectors at both end.Then there
 * is the split cable. Inside every cable are smaller wires that 
 * branch off.
 * 
 *************************************************************************/

public class BioMightConnector implements Serializable{

	// What type of connector does this represent
	private String connectorName = "";
	private String connectorType = "";
	private String connectorID = "";	
	private String connectorConfig = "";
	
	// What are the points 
	private double [][] connectorPoints = null;;
	
	// The start points & end points for a dual cable - this is a pass through
	// It always traverses the bound box.
	private double [][] startPoints = null;;
	private double [][] endPoints = null;;
	
	
	/*****************************************************************************
	 * BIOMIGHT CONNECTOR CONSTRUCTORS
	 * Base Constructor
	 * 
	 ****************************************************************************/
	
	public BioMightConnector()
	{	
	}

	/*****************************************************************************
	 * BIOMIGHT CONNECTOR 
	 * 
	 * Constructor that takes come parameters
	 * 
	 ****************************************************************************/

	
	public BioMightConnector(double [][] points)
	{
		this.connectorPoints = points;
	}


	public BioMightConnector(double [][] points, String connectName)
	{
		this.connectorPoints = points;
		this.connectorType = connectName;
	}

	
	public BioMightConnector(double [][] points, String connectName, String connectType)
	{
		this.connectorPoints = points;
		this.connectorName = connectName;
		this.connectorType = connectType;
	}

	public BioMightConnector(double [][] startpoints, double [][] endpoints, String connectName, String connectType)
	{
		this.startPoints = startpoints;
		this.endPoints = endpoints;
		this.connectorName = connectName;
		this.connectorType = connectType;

		System.out.println("BIOMIGHT EP CONNECTOR :  " +  
				connectName + "  " + endPoints[0][0] + " " + endPoints[0][1] + " ");
	}
	
	/*****************************************************************************
	 * GETTERS/SETTERS 
	 * 
	 * Constructor that takes come parameters
	 * 
	 ****************************************************************************/

	public String getConnectorName() {
		return connectorName;
	}
	
	public void setConnectorName(String connectorName) {
		this.connectorName = connectorName;
	}

	public void setConnectorType(String connectorType) {
		this.connectorType = connectorType;
	}

	public String getConnectorType() {
		return connectorType;
	}

	public void setConnectType(String connectType) {
		this.connectorType = connectType;
	}
		
	public double[][] getConnectorPoints() {
		return connectorPoints;
	}

	public void setConnectPoints(double[][] connectPoints) {
		this.connectorPoints = connectPoints;
	}

	public String getConnectorID() {
		return connectorID;
	}

	public void setConnectorID(String connectorID) {
		this.connectorID = connectorID;
	}

	public String getConnectorConfig() {
		return connectorConfig;
	}

	public void setConnectorConfig(String connectorConfig) {
		this.connectorConfig = connectorConfig;
	}

	public double[][] getStartPoints() {
		return startPoints;
	}

	public void setStartPoints(double[][] startPoints) {
		this.startPoints = startPoints;
	}

	public double[][] getEndPoints() {
		return endPoints;
	}

	public void setEndPoints(double[][] endPoints) {
		this.endPoints = endPoints;
	}		

	
	
}
