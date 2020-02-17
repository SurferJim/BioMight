/*
 * Created on Feb 4, 2007
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomightweb.view;
import java.util.ArrayList;
import java.math.BigDecimal;


/**
 * @author SurferJim
 *
 * The BioMight Projects View presents the top level information on your
 * BioMightProjects.  It contains a collection of Project objects.
 * 
 */

public class BioMightProjectsView {
	private ArrayList projectsViewArray = null;
	
	
	public BioMightProjectsView()
	{
		projectsViewArray = new ArrayList();
		initProjects();
	}
	
	
	// Test Data
	public void initProjects()
	{
		System.out.println("Initializing Projects");

		BioMightProjectView bioMightProjectView = new BioMightProjectView();
		bioMightProjectView.setProjectID("WESTNILE");
		bioMightProjectView.setProjectName("West Nile Disease Progression & Pathology");
		bioMightProjectView.setDuration(660);
		bioMightProjectView.setFramesPerSecond(15);
		bioMightProjectView.setSize(new BigDecimal("7517"));
		projectsViewArray.add(0, bioMightProjectView);

		bioMightProjectView = new BioMightProjectView();
		bioMightProjectView.setProjectID("COLESTID");
		bioMightProjectView.setProjectName("How Colestid blocks the uptake of Cholesterol");
		bioMightProjectView.setDuration(365);
		bioMightProjectView.setFramesPerSecond(15);
		bioMightProjectView.setSize(new BigDecimal("7517"));
		projectsViewArray.add(1, bioMightProjectView);

		/*
		bioMightProjectView = new BioMightProjectView();
		bioMightProjectView.setProjectID("CLARITIN");
		bioMightProjectView.setProjectName("How Claritin Provides Safe Effective Relief");
		bioMightProjectView.setDuration(625);
		bioMightProjectView.setFramesPerSecond(15);
		bioMightProjectView.setSize(new BigDecimal("7517"));
		projectsViewArray.add(2, bioMightProjectView);		
		
		bioMightProjectView = new BioMightProjectView();
		bioMightProjectView.setProjectID("SARS");
		bioMightProjectView.setProjectName(" SARS Chloroquine Antiviral Drug Simulation");
		bioMightProjectView.setDuration(643);
		bioMightProjectView.setFramesPerSecond(15);
		bioMightProjectView.setSize(new BigDecimal("7000"));
		projectsViewArray.add(3, bioMightProjectView);
		
		bioMightProjectView = new BioMightProjectView();
		bioMightProjectView.setProjectID("LIPITOR");
		bioMightProjectView.setProjectName("Lipitor Stops Cold the Production of Cholesterol");
		bioMightProjectView.setDuration(625);
		bioMightProjectView.setFramesPerSecond(15);
		bioMightProjectView.setSize(new BigDecimal("104852"));
		projectsViewArray.add(4, bioMightProjectView);
		
		bioMightProjectView = new BioMightProjectView();
		bioMightProjectView.setProjectID("DIGESTSYS");
		bioMightProjectView.setProjectName("How the Digestive System Works");
		bioMightProjectView.setDuration(1701);
		bioMightProjectView.setFramesPerSecond(15);
		bioMightProjectView.setSize(new BigDecimal("34585"));
		projectsViewArray.add(5, bioMightProjectView);
		
		bioMightProjectView = new BioMightProjectView();
		bioMightProjectView.setProjectID("IMMUNESYS");
		bioMightProjectView.setProjectName("How the Immune System Works");
		bioMightProjectView.setDuration(1838);
		bioMightProjectView.setFramesPerSecond(15);
		bioMightProjectView.setSize(new BigDecimal("42546"));
		projectsViewArray.add(6, bioMightProjectView);
		
		bioMightProjectView = new BioMightProjectView();
		bioMightProjectView.setProjectID("ALZH");
		bioMightProjectView.setProjectName("The role of Shwann cells in Alzheimer's disease");
		bioMightProjectView.setDuration(2224);
		bioMightProjectView.setFramesPerSecond(15);
		bioMightProjectView.setSize(new BigDecimal("74686"));
		projectsViewArray.add(7, bioMightProjectView);
		
		bioMightProjectView = new BioMightProjectView();
		bioMightProjectView.setProjectID("TUMOR1");
		bioMightProjectView.setProjectName("The development of malignant tumors");
		bioMightProjectView.setDuration(22);
		bioMightProjectView.setFramesPerSecond(15);
		bioMightProjectView.setSize(new BigDecimal("68546"));
		projectsViewArray.add(8, bioMightProjectView);
		
		bioMightProjectView = new BioMightProjectView();
		bioMightProjectView.setProjectID("STEROASTHMA");
		bioMightProjectView.setProjectName("How Steriods restore clear breathing in Asthmatics");
		bioMightProjectView.setDuration(2423);
		bioMightProjectView.setFramesPerSecond(15);
		bioMightProjectView.setSize(new BigDecimal("69714"));
		projectsViewArray.add(9, bioMightProjectView);
		
		bioMightProjectView = new BioMightProjectView();
		bioMightProjectView.setProjectID("PRUVAIL");
		bioMightProjectView.setProjectName("How Oruvail (Ketaprofin) relieves pain in Rheumatoid arthritis");
		bioMightProjectView.setDuration(1915);
		bioMightProjectView.setFramesPerSecond(15);
		bioMightProjectView.setSize(new BigDecimal("79249"));
		projectsViewArray.add(10, bioMightProjectView);
		
		bioMightProjectView = new BioMightProjectView();
		bioMightProjectView.setProjectID("MARROWTRANS");
		bioMightProjectView.setProjectName("Bone Marrow Transplation");
		bioMightProjectView.setDuration(1918);
		bioMightProjectView.setFramesPerSecond(15);
		bioMightProjectView.setSize(new BigDecimal("79251"));
		projectsViewArray.add(11, bioMightProjectView);
		
		bioMightProjectView = new BioMightProjectView();
		bioMightProjectView.setProjectID("EMBOLISM");
		bioMightProjectView.setProjectName("Understanding Brain Embolisms");
		bioMightProjectView.setDuration(815);
		bioMightProjectView.setFramesPerSecond(15);
		bioMightProjectView.setSize(new BigDecimal("46261"));
		projectsViewArray.add(12, bioMightProjectView);
		*/
	}


	// Store the frame in the ArrayList
	public void add(BioMightProjectView bioMightProjectView)
	{
		projectsViewArray.add(bioMightProjectView);
	}

	// Get the frame from the ArrayList
	public BioMightProjectView get(int i)
	{
		if (i <= projectsViewArray.size())
			return (BioMightProjectView) projectsViewArray.get(i);
		else
			return null;
	}	

	
	// Get the frame from the ArrayList
	public int getSize()
	{
		int size = projectsViewArray.size();
		return (size);
	}	
}
