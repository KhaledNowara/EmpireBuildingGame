package units;

import exceptions.FriendlyFireException;

abstract public class Unit {
	private Army parentArmy;
	private int level;
	private int maxSoldierCount;
	private int currentSoldierCount;
	private double idleUpkeep;
	private double marchingUpkeep;
	private double siegeUpkeep;

	public Unit(int level,int maxSoldierCount,double idleUpkeep,double marchingUpkeep,double siegeUpkeep) {
		this.level=level;
		this.maxSoldierCount=maxSoldierCount;
		this.idleUpkeep=idleUpkeep;
		this.marchingUpkeep=marchingUpkeep;
		this.siegeUpkeep=siegeUpkeep;
		this.currentSoldierCount=maxSoldierCount;

	}
	public Unit(int level,int maxSoldierCount,double idleUpkeep,double marchingUpkeep,double siegeUpkeep,Army parentArmy) {
		this.level=level;
		this.maxSoldierCount=maxSoldierCount;
		this.idleUpkeep=idleUpkeep;
		this.marchingUpkeep=marchingUpkeep;
		this.siegeUpkeep=siegeUpkeep;
		this.currentSoldierCount=maxSoldierCount;
		this.parentArmy = parentArmy;

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

	public Army getParentArmy() {
		return parentArmy;
	}
	public void setParentArmy(Army parentArmy) {
		this.parentArmy = parentArmy;
	}

	public void attack (Unit target) throws FriendlyFireException{
		if (parentArmy != null){
		if(parentArmy.getUnits().contains(target))
		{
			throw new FriendlyFireException();
		}}
	}


	 public abstract void archerHurt(int level, int SoldierCount);
	 public abstract void cavalryHurt(int level, int SoldierCount);
	 public abstract void infantryHurt(int level, int SoldierCount);
	
	

}
