/*
 * Created on Feb 4, 2007
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomightweb.view;
import java.math.BigDecimal;
import java.util.Date;


/**
 * @author SurferJim
 *
 * The BioMight Project View contains the information for a project.
 * It contains the name of the project, the creation date, the number of palette
 * etc. 
 * 
 */
public class BioMightProjectView {

	private String projectID = "";
	private Date createDate = null;
	private String projectName = "";
	private String projectDesc = "";
	private Date lastModifiedDate = null;
	private String lastModifiedUser = "";
	private int numberOfPalette = 0;
	private BigDecimal size = null;
	private int	duration = 0;
	private int framesPerSecond = 0;
	private BioMightPaletteView bioMightPaletteView;
		
	/**
	 * @return
	 */
	public Date getCreateDate() {
		return createDate;
	}

	/**
	 * @return
	 */
	public int getDuration() {
		return duration;
	}


	/**
	 * @return
	 */
	public int getNumberOfPalette() {
		return numberOfPalette;
	}

	/**
	 * @return
	 */
	public String getProjectID() {
		return projectID;
	}

	/**
	 * @return
	 */
	public BigDecimal getSize() {
		return size;
	}

	/**
	 * @param date
	 */
	public void setCreateDate(Date date) {
		createDate = date;
	}

	/**
	 * @param i
	 */
	public void setDuration(int i) {
		duration = i;
	}

	/**
	 * @param i
	 */
	public void setNumberOfPalette(int i) {
		numberOfPalette = i;
	}

	/**
	 * @param string
	 */
	public void setProjectID(String string) {
		projectID = string;
	}

	/**
	 * @param decimal
	 */
	public void setSize(BigDecimal decimal) {
		size = decimal;
	}

	/**
	 * @return
	 */
	public BioMightPaletteView getBioMightPaletteView() {
		return bioMightPaletteView;
	}

	/**
	 * @return
	 */
	public Date getLastModifiedDate() {
		return lastModifiedDate;
	}

	/**
	 * @return
	 */
	public String getLastModifiedUser() {
		return lastModifiedUser;
	}

	/**
	 * @return
	 */
	public String getProjectName() {
		return projectName;
	}

	/**
	 * @param view
	 */
	public void setBioMightPaletteView(BioMightPaletteView view) {
		bioMightPaletteView = view;
	}

	/**
	 * @param date
	 */
	public void setLastModifiedDate(Date date) {
		lastModifiedDate = date;
	}

	/**
	 * @param string
	 */
	public void setLastModifiedUser(String string) {
		lastModifiedUser = string;
	}

	/**
	 * @param string
	 */
	public void setProjectName(String string) {
		projectName = string;
	}

	/**
	 * @return
	 */
	public String getProjectDesc() {
		return projectDesc;
	}

	/**
	 * @param string
	 */
	public void setProjectDesc(String string) {
		projectDesc = string;
	}

	public int getFramesPerSecond() {
		return framesPerSecond;
	}

	public void setFramesPerSecond(int framesPerSecond) {
		this.framesPerSecond = framesPerSecond;
	}

}
