package buildings;

import engine.City;
import engine.Player;
import exceptions.BuildingInCoolDownException;
import exceptions.MaxRecruitedException;
import exceptions.NotEnoughGoldException;
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
    public void build(Player p,City C ) throws NotEnoughGoldException {
        if (p.getTreasury()< this.getCost())throw new NotEnoughGoldException();
        for(MilitaryBuilding b : C.getMilitaryBuildings()){
			if (b.getClass().equals(this.getClass()))return;
		}
        C.getMilitaryBuildings().add(this);
        p.setTreasury(p.getTreasury() - this.getCost());
        setCoolDown(true);
    } 


}
