package units;

public class Army {
	
	private Status currentStatus=IDLE;
	private ArrayList<Unit> units;
	private int distancetoTarget=-1;
	private String target="";
	private String currentLocation;
	private int maxToHold=10;

	public Army(String currentLocation) {
		this.currentLocation=currentLocation;
	
	}
	
	public Status getCurrentStatus() {
		return currentStatus;
	}
	public Status getCurrentStatus(status s) {
		 currentStatus=s;
	}
	
	public ArrayList<Unit> getUnits() {
		return units;
	}
	public ArrayList<Unit> setUnits(ArrayList<Unit> s) {
		 units=s;
	}
	
	
	public int getDistancetoTarget() {
		return distancetoTarget;
	}
	public int setDistancetoTarget(int s) {
		distancetoTarget=s;
	}
	
	
	public String getTarget() {
		return target;
	}
	public String setTarget(string s) {
		 target=s;
	}
	
	
	
	public String getCurrentLocation() {
		return currentLocation;
	}
	public String setCurrentLocation(string s) {
		currentLocation=s;
	}
	
	
	public int getMaxToHold() {
		return maxToHold;
	}
	

}
