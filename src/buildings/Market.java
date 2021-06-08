package buildings;

import engine.Player;
import exceptions.*;

public class Market extends EconomicBuilding {

	public Market() {
		
		super(1500,700);
	}
	
	public void upgrade() throws BuildingInCoolDownException, MaxLevelException{
		super.upgrade();
		setUpgradeCost(1000);
	
	}

	public int harvest () {
		switch (getLevel()){
			case 1: return 1000; 
			case 2: return 1500; 
			case 3: return 2000;
		}
		return -1;
	}
	public void harvest(Player p){
		p.setTreasury(p.getTreasury() + harvest());
	}
}
