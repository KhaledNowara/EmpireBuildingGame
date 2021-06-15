package buildings;

import exceptions.*;
import units.Infantry;
import units.Unit;

public class Barracks extends MilitaryBuilding{

	public Barracks() {
		
		super(2000,1000,500);
	}

	public void upgrade() throws BuildingInCoolDownException, MaxLevelException{
		super.upgrade();
		if (getLevel() == 2){
			setUpgradeCost(1500);
			setRecruitmentCost(550);
		}
		else if (getLevel()== 3){
			setUpgradeCost(0);
			setRecruitmentCost(600);
		}
	
	}
	public Unit recruit() throws BuildingInCoolDownException, MaxRecruitedException{
		if(isCoolDown())throw new BuildingInCoolDownException();
		if(getCurrentRecruit()==getMaxRecruit()) throw new MaxRecruitedException();
		
		setCurrentRecruit(getCurrentRecruit() + 1); 
		return Infantry.createUnit(super.getLevel()-1);
	
}


}
