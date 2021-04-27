package buildings;

abstract public class MilitaryBuilding extends Building{
    
	private int recruitmentCost ;
	private int currentRecruit;
	private int maxRecruit;
	
	public MilitaryBuilding(int cost, int upgradeCost,int recruitmentCost ) {
		
		super(cost,upgradeCost);
		this.recruitmentCost=recruitmentCost;
		
	}
	
    public int  getRecruitmentCost()
    {
    	return this.recruitmentCost;
    }
    
    public void setRecruitmentCost(int r)
    {
    	return this.recruitmentCost=r;
    }
    
    public int getCurrentRecruit()
    {
    	return this.currentRecruit;
    }
    
    public void setCurrentRecruit(int c)
    {
    	this.currentRecruit=c;
    }
    
    public int maxRecruit()
    {
    	return this.maxRecruit;
    }

}
