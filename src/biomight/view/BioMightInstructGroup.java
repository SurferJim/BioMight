package biomight.view;

import java.util.ArrayList;

/************************************************************************************************
 * 
 * @author TheSurferJim
 *
 *  Allow one to maintain a group of instruction sets.  In this scenario, the insruction set
 *  will be have one instruction for each point in the set of points that we are manipulating.
 *  BioMight will run through the collection of instructions applying them to the points.
 *
 ***********************************************************************************************/
public class BioMightInstructGroup {


	private ArrayList instructionGroup = new ArrayList();
	
	
	// Get an Element from the ArrayList
	public BioMightInstructSet getElement(int i) {
		return (BioMightInstructSet) instructionGroup.get(i);
	}

	
	// Get an Element from the ArrayList
	public void addElement(BioMightInstructSet bioMightInstructSet) {
		instructionGroup.add(bioMightInstructSet);
	}
	
	// Get an Element from the ArrayList
	public void addElement(BioMightInstruction bioMightInstructSet, int pos) {
		instructionGroup.add(pos, bioMightInstructSet);
	}
	
	
	// Get an Element from the ArrayList
	public int getSize() {
		return instructionGroup.size();
	}
	
	
}
