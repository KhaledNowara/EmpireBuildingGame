package units;
import java.io.IOException;

import engine.Game;
import exceptions.*;

public class Infantry extends Unit{

	public Infantry(int level,int maxSoldierCount,double idleUpkeep,double marchingUpkeep,double siegeUpkeep) {
		super( level, maxSoldierCount, idleUpkeep, marchingUpkeep, siegeUpkeep);
	}
	public Infantry(int level,int maxSoldierCount,double idleUpkeep,double marchingUpkeep,double siegeUpkeep, Army parentArmy ) {
		super( level, maxSoldierCount, idleUpkeep, marchingUpkeep, siegeUpkeep,parentArmy);
	}
	public static  Unit createUnit(int level) {
		try {
			String[] iV = Game.readFile("infantary.csv").get(level);
			return new Infantry(Integer.parseInt(iV[0]),Integer.parseInt(iV[1]),Double.parseDouble(iV[2]),Double.parseDouble(iV[3]),Double.parseDouble(iV[4]));
		}
		catch (IOException e){
			System.out.println("file not found i ");
			return new Infantry(0, 0, 0, 0, 0);
		}

	}
	public static  Unit createUnit(int level ,Army parentArmy) {
		try {
			String[] iV = Game.readFile("infantary.csv").get(level);
			return new Infantry(Integer.parseInt(iV[0]),Integer.parseInt(iV[1]),Double.parseDouble(iV[2]),Double.parseDouble(iV[3]),Double.parseDouble(iV[4]),parentArmy);
		}
		catch (IOException e){
			System.out.println("file not found i ");
			return new Infantry(0, 0, 0, 0, 0);
		}

	}

	public void attack (Unit target) throws FriendlyFireException{
		super.attack(target);
		target.infantryHurt(getLevel(),getCurrentSoldierCount());
	}
	
	public void archerHurt(int level, int SoldierCount) {
		switch(level){
			case 1: setCurrentSoldierCount((int)(getCurrentSoldierCount()-SoldierCount*0.2));break;
			case 2: setCurrentSoldierCount((int)(getCurrentSoldierCount()-SoldierCount*0.3));break;
			case 3: setCurrentSoldierCount((int)(getCurrentSoldierCount()-SoldierCount*0.4));break;
		}
		if(getCurrentSoldierCount() <= 0){
			setCurrentSoldierCount(0);
			getParentArmy().handleAttackedUnit(this);
		}
		
	}
	
	public void cavalryHurt(int level, int SoldierCount) {
		switch(level){
			case 1: setCurrentSoldierCount((int)(getCurrentSoldierCount()-SoldierCount*0.3));break;
			case 2: setCurrentSoldierCount((int)(getCurrentSoldierCount()-SoldierCount*0.4));break;
			case 3: setCurrentSoldierCount((int)(getCurrentSoldierCount()-SoldierCount*0.5));break;
		}
		if(getCurrentSoldierCount() <= 0){
			setCurrentSoldierCount(0);
			getParentArmy().handleAttackedUnit(this);
		}
		
	}
	
	public void infantryHurt(int level, int SoldierCount) {
		switch(level){
			case 1: setCurrentSoldierCount((int)(getCurrentSoldierCount()-SoldierCount*0.1));break;
			case 2: setCurrentSoldierCount((int)(getCurrentSoldierCount()-SoldierCount*0.2));break;
			case 3: setCurrentSoldierCount((int)(getCurrentSoldierCount()-SoldierCount*0.3));break;
		}
		if(getCurrentSoldierCount() <= 0){
			setCurrentSoldierCount(0);
			getParentArmy().handleAttackedUnit(this);
		}
		
	}
}
