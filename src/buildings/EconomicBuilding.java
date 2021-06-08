package buildings;

import engine.City;
import engine.Player;
import exceptions.NotEnoughGoldException;

abstract public class EconomicBuilding extends Building {

	public EconomicBuilding(int cost, int upgradeCost) {
		
		super(cost,upgradeCost);
		
	} 

	public abstract int harvest () ; 
	public abstract void harvest (Player p);
	
	public void build(Player p,City C ) throws NotEnoughGoldException {
        if (p.getTreasury()< this.getCost())throw new NotEnoughGoldException();
        for(EconomicBuilding b : C.getEconomicalBuildings()){
			if (b.getClass().equals(this.getClass()))return;
		}
		
		C.getEconomicalBuildings().add(this);
        p.setTreasury(p.getTreasury() - this.getCost());
		setCoolDown(true);

    } 



}
