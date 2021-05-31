package buildings;

import exceptions.BuildingInCoolDownException;
import exceptions.MaxRecruitedException;
import units.Unit;

abstract public class MilitaryBuilding extends Building{
    
	private int recruitmentCost ;
	private int currentRecruit;
	final private int maxRecruit;
	
	public MilitaryBuilding(int cost, int upgradeCost,int recruitmentCost ) {
		
		super(cost,upgradeCost);
		this.recruitmentCost=recruitmentCost;
        this.maxRecruit=3;

		
	}
	
    public int  getRecruitmentCost()
    {
    	return this.recruitmentCost;
    }
    
    //setters do not return 
    public void setRecruitmentCost(int r)
    {
    	this.recruitmentCost=r;
    }
    
    public int getCurrentRecruit()
    {
    	return this.currentRecruit;
    }
    
    public void setCurrentRecruit(int c)
    {
    	this.currentRecruit=c;
    }
    
    public int getMaxRecruit()
    {
    	return this.maxRecruit;
    }


    public abstract Unit recruit() throws BuildingInCoolDownException, MaxRecruitedException;

}
