package buildings;


import engine.Player;
import exceptions.*;

public class Farm extends EconomicBuilding{
	
	public Farm() {
		super(1000,500);
	}
	
	public void upgrade() throws BuildingInCoolDownException, MaxLevelException{
		super.upgrade();
		setUpgradeCost(700);
	
	}

	public int harvest () {
		switch (getLevel()){
			case 1: return 500; 
			case 2: return 700; 
			case 3: return 1000;
		}
		return -1;
	}	
	public void harvest(Player p){
		p.setFood(p.getFood() + harvest());
	}

}
