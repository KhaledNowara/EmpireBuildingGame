 package buildings;

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
	
	public void setLevel(level l)
	{
		this.level=l;
	}
	
	public int getUpgradeCost()
	{
		return this.upgradeCost;
	}
	
	public void setUpgradeCost(int u)
	{
		return this.upgradeCost=u;
	}
	
	
	public boolean getCoolDown()
	{
		return this.coolDown;
	}
	
	public void setCoolDown(boolean c)
	{
		return this.coolDown=c;
	}
	
	
	

}
