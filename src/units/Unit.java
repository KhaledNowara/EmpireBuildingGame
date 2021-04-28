package units;

abstract public class Unit {
	private int level;
	private int maxSoldierCount;
	private int currentSoldierCount;
	private double idleUpkeep;
	private double marchingUpkeep;
	private double siegeUpkeep;
	// currentSoldierCount is not passed as a parameter int the constructor
	public Unit(int level,int maxSoldierCount,double idleUpkeep,double marchingUpkeep,double siegeUpkeep) {
		this.level=level;
		this.maxSoldierCount=maxSoldierCount;
		this.idleUpkeep=idleUpkeep;
		this.marchingUpkeep=marchingUpkeep;
		this.siegeUpkeep=siegeUpkeep;

	}
	
	public int getLevel() {
		return level;
	}
	
	
	
	public int getMaxSoldierCount() {
		return maxSoldierCount;
	}
	
	
	
	public int getCurrentSoldierCount() {
		return currentSoldierCount;
	}
	public void setCurrentSoldierCount(int c) {
		currentSoldierCount=c;
	}
	
	
	public double getIdleUpkeep() {
		return idleUpkeep;
	}
	
	
	
	public double getMarchingUpkeep() {
		return marchingUpkeep;
	}
	
	
	
	public double getSiegeUpkeep() {
		return siegeUpkeep;
	}
	

}
