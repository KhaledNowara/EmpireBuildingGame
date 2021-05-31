package engine;
import java.util.ArrayList;

import buildings.ArcheryRange;
import buildings.Barracks;
import buildings.MilitaryBuilding;
import buildings.Stable;
import exceptions.BuildingInCoolDownException;
import exceptions.MaxRecruitedException;
import exceptions.NotEnoughGoldException;
import units.Army;
import units.Unit;

public class Player {

	private String name;
	private ArrayList<City> controlledCities;
	private	ArrayList<Army> controlledArmies;
	private double treasury;
	private double food;



	public String getName() {
		return name;
	}



	


	public ArrayList<City> getControlledCities() {
		return controlledCities;
	}







	public ArrayList<Army> getControlledArmies() {
		return controlledArmies;
	}






	public double getTreasury() {
		return treasury;
	}



	public void setTreasury(double treasury) {
		this.treasury = treasury;
	}



	public double getFood() {
		return food;
	}



	public void setFood(double food) {
		this.food = food;
	}



	public Player(String name) {
		this.name = name;
		this.food = 0;
		this.treasury = 0;
		controlledCities = new ArrayList<City>();
		controlledArmies = new ArrayList<Army>();

	}

	public void recruitUnit(String type ,String cityName) throws BuildingInCoolDownException,MaxRecruitedException,NotEnoughGoldException{
		City c = null;
		MilitaryBuilding typeIndicator = null;
		MilitaryBuilding Building = null;
		Unit recruit;
	
		for(City city:controlledCities){
			if (city.getName().equals(cityName)){
				c = city;
				break;
			}
		}

		switch(type){
			case "Archer": typeIndicator = new ArcheryRange();
			case "Infantry": typeIndicator = new Barracks();
			case "Cavalary": typeIndicator = new Stable();
		}

		for(MilitaryBuilding a: c.getMilitaryBuildings()){
			if(a.getClass().equals(typeIndicator.getClass())){
				Building = a;
				break; 
			}
		}
		if (treasury < Building.getRecruitmentCost()) throw new NotEnoughGoldException();

		recruit = Building.recruit();
		recruit.setParentArmy(c.getDefendingArmy());
		c.getDefendingArmy().getUnits().add(recruit);
		treasury -= Building.getRecruitmentCost();
		
		
	}


}