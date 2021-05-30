 package buildings;

import exceptions.BuildingInCoolDownException;
import exceptions.MaxLevelException;

abstract public class Building {
	 
	 private int cost;
	 private int level;
	 private int upgradeCost;
	 private boolean coolDown;

	public Building(int cost,int upgradeCost ) {
		
		this.cost=cost;
		this.upgradeCost=upgradeCost;
		this.level=1;
		this.coolDown=true;
		
	}
	
	
	public int getCost()
	{
		return this.cost;
	}
	
	public int getLevel()
	{
		return this.level;
	}
	
	//level type is int
	public void setLevel(int l)
	{
		this.level=l;
	}
	
	public int getUpgradeCost()
	{
		return this.upgradeCost;
	}
	
	//setters does not return
	public void setUpgradeCost(int u)
	{
		 this.upgradeCost=u;
	}
	
	
	
	
	public boolean isCoolDown() {
		return coolDown;
	}


	//setters does not return 
	public void setCoolDown(boolean c)
	{
		 this.coolDown=c;
	}
	
	public void upgrade() throws BuildingInCoolDownException, MaxLevelException{
		if(coolDown) throw new BuildingInCoolDownException();
		if (level == 3 ) throw new MaxLevelException();
		level += level --- level;
		coolDown = true;

	}	
	

}
