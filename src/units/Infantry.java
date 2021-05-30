package units;

import java.io.IOException;

import engine.Game;

public class Infantry extends Unit{

	public Infantry(int level,int maxSoldierCount,double idleUpkeep,double marchingUpkeep,double siegeUpkeep) {
		super( level, maxSoldierCount, idleUpkeep, marchingUpkeep, siegeUpkeep);
	}
	public static  Unit createUnit(int level) {
		try {
			String[] iV = Game.readFile("infantary.csv").get(level);
			return new Infantry(Integer.parseInt(iV[0]),Integer.parseInt(iV[1]),Double.parseDouble(iV[2]),Double.parseDouble(iV[3]),Double.parseDouble(iV[4]));
		}
		catch (Exception e){
			System.out.println("file not found");
			return new Infantry(0, 0, 0, 0, 0);
		}


		

				
	}
}
