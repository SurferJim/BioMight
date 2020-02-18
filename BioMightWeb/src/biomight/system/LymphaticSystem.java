/*
 * Created on Jul 8, 2006
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.system;
import biomight.BioMightBase;

import biomight.system.lymphatic.*;
import biomight.body.organ.thymus.*;
import biomight.body.gland.spleen.*;
import biomight.system.lymphatic.lymphnode.*;
import biomight.system.lymphatic.*;
import biomight.system.vascular.veins.*;
import biomight.system.vascular.veins.chest.*;
import biomight.system.skeletal.*;
import biomight.system.tissue.connective.bone.*;

/**
 * @author SurferJim
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class LymphaticSystem extends BioMightBase {
	

	private Lymph lymph;
	private Chyle chyle;
	private CisternaChyli cisternaChyli;
	
	// Lymph Organs
	private Spleen spleen;
	private Thymus thymus;
	private BoneMarrow boneMarrow;
			
	// Lymph Nodes
	private LymphNodes lymphNodes;
		
	// Lymph Vessels
	private Tributaries tributaries;
	private IntestinalTrunk intestinalTrunk;
	private LeftJugularTrunk leftJugularTrunk;
	private RightJugularTrunk rightJugularTrunk;
	private LeftSubClavianTrunk leftSubclavianTrunk;
	private RightSubClavianTrunk rightSubclavianTrunk;
	private RightLympahticDuct rightLympahticDuct;
	private LumbarTrunk lumbarTrunk;
	private ThoracicDuct thoracicDuct;
	private SubclavianVeins subClavianVeins;

	public LymphaticSystem()
	{
		this.setImage("images/LymphaticSystem.jpg");	
	}

	
	public void setDisease()
	{
	}
	

	public BoneMarrow getBoneMarrow() {
		return boneMarrow;
	}

	public void setBoneMarrow(BoneMarrow boneMarrow) {
		this.boneMarrow = boneMarrow;
	}

	public Chyle getChyle() {
		return chyle;
	}

	public void setChyle(Chyle chyle) {
		this.chyle = chyle;
	}


	public IntestinalTrunk getIntestinalTrunk() {
		return intestinalTrunk;
	}

	public void setIntestinalTrunk(IntestinalTrunk intestinalTrunk) {
		this.intestinalTrunk = intestinalTrunk;
	}

	public LeftJugularTrunk getLeftJugularTrunk() {
		return leftJugularTrunk;
	}

	public void setLeftJugularTrunk(LeftJugularTrunk leftJugularTrunk) {
		this.leftJugularTrunk = leftJugularTrunk;
	}

	public LeftSubClavianTrunk getLeftSubclavianTrunk() {
		return leftSubclavianTrunk;
	}

	public void setLeftSubclavianTrunk(LeftSubClavianTrunk leftSubclavianTrunk) {
		this.leftSubclavianTrunk = leftSubclavianTrunk;
	}

	public LumbarTrunk getLumbarTrunk() {
		return lumbarTrunk;
	}

	public void setLumbarTrunk(LumbarTrunk lumbarTrunk) {
		this.lumbarTrunk = lumbarTrunk;
	}

	public Lymph getLymph() {
		return lymph;
	}

	public void setLymph(Lymph lymph) {
		this.lymph = lymph;
	}

	public LymphNodes getLymphNodes() {
		return lymphNodes;
	}

	public void setLymphNodes(LymphNodes lymphNodes) {
		this.lymphNodes = lymphNodes;
	}

	public RightJugularTrunk getRightJugularTrunk() {
		return rightJugularTrunk;
	}

	public void setRightJugularTrunk(RightJugularTrunk rightJugularTrunk) {
		this.rightJugularTrunk = rightJugularTrunk;
	}

	public RightLympahticDuct getRightLympahticDuct() {
		return rightLympahticDuct;
	}

	public void setRightLympahticDuct(RightLympahticDuct rightLympahticDuct) {
		this.rightLympahticDuct = rightLympahticDuct;
	}

	public RightSubClavianTrunk getRightSubclavianTrunk() {
		return rightSubclavianTrunk;
	}

	public void setRightSubclavianTrunk(RightSubClavianTrunk rightSubclavianTrunk) {
		this.rightSubclavianTrunk = rightSubclavianTrunk;
	}

	public Spleen getSpleen() {
		return spleen;
	}

	public void setSpleen(Spleen spleen) {
		this.spleen = spleen;
	}

	public ThoracicDuct getThoracicDuct() {
		return thoracicDuct;
	}

	public void setThoracicDuct(ThoracicDuct thoracicDuct) {
		this.thoracicDuct = thoracicDuct;
	}

	public Thymus getThymus() {
		return thymus;
	}

	public void setThymus(Thymus thymus) {
		this.thymus = thymus;
	}

	public Tributaries getTributaries() {
		return tributaries;
	}

	public void setTributaries(Tributaries tributaries) {
		this.tributaries = tributaries;
	}

	public CisternaChyli getCisternaChyli() {
		return cisternaChyli;
	}

	public void setCisternaChyli(CisternaChyli cisternaChyli) {
		this.cisternaChyli = cisternaChyli;
	}	 	
}
