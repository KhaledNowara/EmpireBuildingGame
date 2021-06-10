package engine;
import java.util.ArrayList;

import buildings.*;
import exceptions.BuildingInCoolDownException;
import exceptions.FriendlyCityException;
import exceptions.MaxLevelException;
import exceptions.MaxRecruitedException;
import exceptions.NotEnoughGoldException;
import exceptions.TargetNotReachedException;
import units.Army;
import units.Status;
import units.Unit;

public class Player {

	private String name;
	private ArrayList<City> controlledCities;
	private	ArrayList<Army> controlledArmies;
	private double treasury;
	private double food;
	private Game game;



	public Game getGame() {
		return game;
	}






	public void setGame(Game game) {
		this.game = game;
	}






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
	
		for(City city:game.getAvailableCities()){
			
			if (city.getName().equals(cityName)){
				c = city;
				if (!controlledCities.contains(city)) return;
				break;
			}
		}
	

		switch(type){
			case "Archer": typeIndicator = new ArcheryRange();break;
			case "Infantry": typeIndicator = new Barracks();break;
			case "Cavalry": typeIndicator = new Stable();break;
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

	public void build (String type , String cityName ) throws NotEnoughGoldException {
		City c = null;
		Building b = null;
		
		for(City city:controlledCities){
			if (city.getName().equals(cityName)){
				c = city;
				if (!controlledCities.contains(city)) return;
				break;
			}
		}

		switch(type){
			case "ArcheryRange": b = new ArcheryRange();break;
			case "Barracks": b = new Barracks();break;
			case "Stable": b = new Stable();break;
			case "Farm": b = new Farm(); break;
			case "Market": b = new Market();break;
		}
		b.build(this, c);




	}


	public void upgradeBuilding(Building b) throws NotEnoughGoldException, BuildingInCoolDownException, MaxLevelException{
		int upcost = b.getUpgradeCost();
		if (treasury < upcost) throw new NotEnoughGoldException();
		b.upgrade();
		treasury -= upcost;
	}
   

	public void initiateArmy(City city,Unit unit)
	{

		Army A = new Army(city.getName() + "Attacking Army");
		A.getUnits().add(unit);
		city.getDefendingArmy().getUnits().remove(unit);
        unit.setParentArmy(A);
		this.controlledArmies.add(A);

	}

	public void laySiege(Army army,City city) throws TargetNotReachedException,FriendlyCityException{
	
			if (!army.getCurrentLocation().equals(city.getName())) throw new TargetNotReachedException();
			if (controlledCities.contains(city)) throw new FriendlyCityException();

			army.setCurrentStatus(Status.BESIEGING);
			city.setUnderSiege(true);

			city.setTurnsUnderSiege(0);

	}
	






















}