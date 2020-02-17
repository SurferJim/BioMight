package biomight.view;

import java.util.ArrayList;

public class BioMightInstructSet {


	private ArrayList instructionSet = new ArrayList();
	
	
	// Get an Element from the ArrayList
	public BioMightInstruction getElement(int i) {
		return (BioMightInstruction) instructionSet.get(i);
	}

	
	// Get an Element from the ArrayList
	public void addElement(BioMightInstruction bioMightInstruction) {
		instructionSet.add(bioMightInstruction);
	}
	
	// Get an Element from the ArrayList
	public void addElement(BioMightInstruction bioMightInstruction, int pos) {
		instructionSet.add(pos, bioMightInstruction);
	}
	
	
	// Get an Element from the ArrayList
	public int getSize() {
		return instructionSet.size();
	}
	
	
}
