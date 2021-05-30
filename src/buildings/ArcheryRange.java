package buildings;

import exceptions.*;
import units.Archer;
import units.Unit;

public class ArcheryRange extends MilitaryBuilding{

	public ArcheryRange() {
		
		super(1500,800,400);
	}
	
	public void upgrade() throws BuildingInCoolDownException, MaxLevelException{
		super.upgrade();
		if (getLevel() == 2){
			setUpgradeCost(700);
			setRecruitmentCost(450);
		}
		else if (getLevel()== 3){
			setUpgradeCost(0);
			setRecruitmentCost(500);
		}
	
	}
	public Unit recruit() throws BuildingInCoolDownException, MaxRecruitedException{
		if(isCoolDown())throw new BuildingInCoolDownException();
		if(getCurrentRecruit()==getMaxRecruit()) throw new MaxRecruitedException();
		
		setCoolDown(true);
		setCurrentRecruit(getCurrentRecruit() + 1);	
		return Archer.createUnit(super.getLevel());
		
	}
 
	

}
