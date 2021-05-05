package units;
import java.util.ArrayList;
public class Army {
	private Status currentStatus;
	private ArrayList<Unit> units;
	private int distancetoTarget;
	private String target;
	private String currentLocation;
	private  final int maxToHold;

	public Army(String currentLocation) {
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
	

}
