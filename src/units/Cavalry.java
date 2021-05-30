package units;

import engine.Game;

public class Cavalry extends Unit{

	public Cavalry(int level,int maxSoldierCount,double idleUpkeep,double marchingUpkeep,double siegeUpkeep) {
		super( level, maxSoldierCount, idleUpkeep, marchingUpkeep, siegeUpkeep);
	}

	public static Unit createUnit(int level){
		try{
		String[] cV = Game.readFile("cavalry.csv").get(level);
		return new Cavalry(Integer.parseInt(cV[0]),Integer.parseInt(cV[1]),Double.parseDouble(cV[2]),Double.parseDouble(cV[3]),Double.parseDouble(cV[4]));
		}
		catch (Exception e){
			System.out.println("file not found");
			return new Infantry(0, 0, 0, 0, 0);
		}
		
	}

}
