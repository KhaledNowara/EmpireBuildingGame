package units;

import java.io.IOException;

import engine.Game;
import exceptions.FriendlyFireException;

public class Archer extends Unit{

	public Archer(int level,int maxSoldierCount,double idleUpkeep,double marchingUpkeep,double siegeUpkeep) {
		super(level, maxSoldierCount, idleUpkeep, marchingUpkeep, siegeUpkeep);
	}
	public Archer(int level,int maxSoldierCount,double idleUpkeep,double marchingUpkeep,double siegeUpkeep,Army parentArmy) {
		super(level, maxSoldierCount, idleUpkeep, marchingUpkeep, siegeUpkeep, parentArmy);
	}
	
	
	@Override
	public String toString() {
		return ("Archer " + super.toString());
	}
	public static  Unit createUnit(int level){
		try{
		String[] aV = Game.readFile("archer.csv").get(level);
		return new Archer(Integer.parseInt(aV[0]),Integer.parseInt(aV[1]),Double.parseDouble(aV[2]),Double.parseDouble(aV[3]),Double.parseDouble(aV[4]));
		}
		catch (IOException e){
			System.out.println("file not found a");
			return new Archer(0, 0, 0, 0, 0);
		}		
	}
	public static  Unit createUnit(int level,Army parentArmy){
		try{
		String[] aV = Game.readFile("archer.csv").get(level);
		return new Archer(Integer.parseInt(aV[0]),Integer.parseInt(aV[1]),Double.parseDouble(aV[2]),Double.parseDouble(aV[3]),Double.parseDouble(aV[4]),parentArmy);
		}
		catch (IOException e){
			System.out.println("file not found a");
			return new Archer(0, 0, 0, 0, 0);
		}		
	}

	public void attack (Unit target) throws FriendlyFireException{
		super.attack(target);
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
			setCurrentSoldierCount(0);
			getParentArmy().handleAttackedUnit(this);
		}
	}



	public void cavalryHurt(int level, int SoldierCount) {
		switch(level){
			case 1: setCurrentSoldierCount((int)(getCurrentSoldierCount()-SoldierCount*0.5));break;
			case 2: setCurrentSoldierCount((int)(getCurrentSoldierCount()-SoldierCount*0.6));break;
			case 3: setCurrentSoldierCount((int)(getCurrentSoldierCount()-SoldierCount*0.7));break;

		}
		if(getCurrentSoldierCount() <= 0){
			setCurrentSoldierCount(0);
			getParentArmy().handleAttackedUnit(this);
		}
		
	}



	public void infantryHurt(int level, int SoldierCount) {
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


}
