package buildings;

import exceptions.*;
import units.Army;
import units.Cavalry;
import units.Unit;

public class Stable extends MilitaryBuilding {

	public Stable() {
		
		super(2500,1500,600);
	}

	public void upgrade() throws BuildingInCoolDownException, MaxLevelException{
		super.upgrade();
		if (getLevel() == 2){
			setUpgradeCost(2000);
			setRecruitmentCost(650);
		}
		else if (getLevel()== 3){
			setUpgradeCost(0);
			setRecruitmentCost(700);
		}
	
	}

	public Unit recruit() throws BuildingInCoolDownException, MaxRecruitedException{
		if(isCoolDown())throw new BuildingInCoolDownException();
		if(getCurrentRecruit()==getMaxRecruit()) throw new MaxRecruitedException();

		setCurrentRecruit(getCurrentRecruit() + 1);
		return Cavalry.createUnit(super.getLevel()-1);
	
}
public Unit recruit(Army a) throws BuildingInCoolDownException, MaxRecruitedException{
	if(isCoolDown())throw new BuildingInCoolDownException();
	if(getCurrentRecruit()==getMaxRecruit()) throw new MaxRecruitedException();

	setCurrentRecruit(getCurrentRecruit() + 1);
	return Cavalry.createUnit(super.getLevel()-1 ,a);

}

}
