package units;

import engine.Game;
import exceptions.FriendlyFireException;

public class Archer extends Unit{

	public Archer(int level,int maxSoldierCount,double idleUpkeep,double marchingUpkeep,double siegeUpkeep) {
		super(level, maxSoldierCount, idleUpkeep, marchingUpkeep, siegeUpkeep);
	}
	
	
	public static  Unit createUnit(int level){
		try{
		String[] aV = Game.readFile("archer.csv").get(level);
		return new Archer(Integer.parseInt(aV[0]),Integer.parseInt(aV[1]),Double.parseDouble(aV[2]),Double.parseDouble(aV[3]),Double.parseDouble(aV[4]));
		}
		catch (Exception e){
			System.out.println("file not found");
			return new Infantry(0, 0, 0, 0, 0);
		}		
	}

	public void attack (Unit target) throws FriendlyFireException{
       target.archerHurt(getLevel(),getCurrentSoldierCount());


	}

	public void archerHurt(int level, int SoldierCount)
	{
        switch(level){
			case 1: setCurrentSoldierCount((int)(getCurrentSoldierCount()-SoldierCount*0.3));break;
			case 2: setCurrentSoldierCount((int)(getCurrentSoldierCount()-SoldierCount*0.4));break;
			case 3: setCurrentSoldierCount((int)(getCurrentSoldierCount()-SoldierCount*0.5));break;
		}
		if(getCurrentSoldierCount() <= 0){
			getParentArmy().getUnits().remove(this);
		}
	}



	public void CavalryHurt(int level, int SoldierCount) {
		switch(level){
			case 1: setCurrentSoldierCount((int)(getCurrentSoldierCount()-SoldierCount*0.1));break;
			case 2: setCurrentSoldierCount((int)(getCurrentSoldierCount()-SoldierCount*0.2));break;
			case 3: setCurrentSoldierCount((int)(getCurrentSoldierCount()-SoldierCount*0.25));break;

		}
		
	}



	public void InfantryHurt(int level, int SoldierCount) {
		switch(level){
			case 1: setCurrentSoldierCount((int)(getCurrentSoldierCount()-SoldierCount*0.1));break;
			case 2: setCurrentSoldierCount((int)(getCurrentSoldierCount()-SoldierCount*0.2));break;
			case 3: setCurrentSoldierCount((int)(getCurrentSoldierCount()-SoldierCount*0.3));break;

		}
		
	}


}
