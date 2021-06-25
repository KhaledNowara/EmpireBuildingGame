package units;
import java.util.ArrayList;

import exceptions.MaxCapacityException;
public class Army {
	private Status currentStatus;
	private ArrayList<Unit> units;
	private int distancetoTarget;
	private String target;
	private String currentLocation;
	private  final int maxToHold;
	private String name; 
	public Army(String currentLocation,String name) {
		this.name = name;
		this.currentLocation = currentLocation;
		this.currentStatus = Status.IDLE;
		units = new ArrayList<Unit>();
		distancetoTarget=-1;
		target= "";
		maxToHold = 10;
	
	}
	
	public Status getCurrentStatus() {
		return currentStatus;
	}

	public void setCurrentStatus(Status s) {
		currentStatus=s;
	}
	
	public ArrayList<Unit> getUnits() {
		return units;
	}
	 
	public void  setUnits(ArrayList<Unit> s) {
		 units=s;
	}
	
	
	public int getDistancetoTarget() {
		return distancetoTarget;
	}
	public void setDistancetoTarget(int s) {
		distancetoTarget = s;
	}
	
	
	public String getTarget() {
		return target;
	}
	public void setTarget(String s) {
		 target = s;
	}
	
	
	
	public String getCurrentLocation() {
		return currentLocation;
	}
	public void setCurrentLocation(String s) {
		currentLocation = s;
	}
	
	
	public int getMaxToHold() {
		return maxToHold;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void relocateUnit(Unit unit) throws MaxCapacityException{
		if (units.size()>=maxToHold) throw new MaxCapacityException();
		units.add(unit);
		unit.getParentArmy().getUnits().remove(unit);
		unit.setParentArmy(this);
	}
	
	public void handleAttackedUnit(Unit u){
		if(u.getCurrentSoldierCount()==0){
			units.remove(u);
		}
	}


	public double foodNeeded()
	{   
		double sum=0;
        for(Unit u: units){

          switch (this.currentStatus){
			 case IDLE:  sum += (u.getIdleUpkeep()*u.getCurrentSoldierCount());break;
			 case MARCHING: sum=sum+(u.getMarchingUpkeep()*u.getCurrentSoldierCount());break;
			 case BESIEGING: sum=sum+(u.getSiegeUpkeep()*u.getCurrentSoldierCount());break;
		  }
       
		}

		return sum;


	}
	
	

	

}
