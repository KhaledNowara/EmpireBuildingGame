package units;

import java.io.IOException;

import engine.Game;
import exceptions.FriendlyFireException;

public class Cavalry extends Unit{

	public Cavalry(int level,int maxSoldierCount,double idleUpkeep,double marchingUpkeep,double siegeUpkeep) {
		super( level, maxSoldierCount, idleUpkeep, marchingUpkeep, siegeUpkeep);
	}
	public Cavalry(int level,int maxSoldierCount,double idleUpkeep,double marchingUpkeep,double siegeUpkeep, Army parentArmy) {
		super( level, maxSoldierCount, idleUpkeep, marchingUpkeep, siegeUpkeep, parentArmy);
	}

	public static Unit createUnit(int level){
		try{
		String[] cV = Game.readFile("cavalry.csv").get(level);
		return new Cavalry(Integer.parseInt(cV[0]),Integer.parseInt(cV[1]),Double.parseDouble(cV[2]),Double.parseDouble(cV[3]),Double.parseDouble(cV[4]));
		}
		catch (Exception e){
			System.out.println("file not found c");
			return new Cavalry(0, 0, 0, 0, 0);
		}
		
	}
	public static Unit createUnit(int level, Army parentArmy){
		try{
		String[] cV = Game.readFile("cavalry.csv").get(level);
		return new Cavalry(Integer.parseInt(cV[0]),Integer.parseInt(cV[1]),Double.parseDouble(cV[2]),Double.parseDouble(cV[3]),Double.parseDouble(cV[4]),parentArmy);
		}
		catch (IOException e){
			System.out.println("file not  c ");
			return new Cavalry(0, 0, 0, 0, 0);
		}
		
	}
	public void attack (Unit target) throws FriendlyFireException{
		super.attack(target);
		target.cavalryHurt(getLevel(),getCurrentSoldierCount());
	}
	public void archerHurt(int level, int SoldierCount) {
		switch(level){
			case 1: setCurrentSoldierCount((int)(getCurrentSoldierCount()-SoldierCount*0.1));break;
			case 2: setCurrentSoldierCount((int)(getCurrentSoldierCount()-SoldierCount*0.1));break;
			case 3: setCurrentSoldierCount((int)(getCurrentSoldierCount()-SoldierCount*0.2));break;
		}
		if(getCurrentSoldierCount() <= 0){
			setCurrentSoldierCount(0);
			getParentArmy().handleAttackedUnit(this);
		}
		
	}
	
	public void cavalryHurt(int level, int SoldierCount) {
		switch(level){
			case 1: setCurrentSoldierCount((int)(getCurrentSoldierCount()-SoldierCount*0.2));break;
			case 2: setCurrentSoldierCount((int)(getCurrentSoldierCount()-SoldierCount*0.2));break;
			case 3: setCurrentSoldierCount((int)(getCurrentSoldierCount()-SoldierCount*0.3));break;
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
			case 3: setCurrentSoldierCount((int)(getCurrentSoldierCount()-SoldierCount*0.25));break;
		}
		if(getCurrentSoldierCount() <= 0){
			setCurrentSoldierCount(0);
			getParentArmy().handleAttackedUnit(this);
		}
		
	}

}
