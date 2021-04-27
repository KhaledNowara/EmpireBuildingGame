package units;
//when using and arry list you have to import it first
import java.util.ArrayList;
public class Army {
	//when calling a value from an enum you have to refer to the enum first (Status.IDLE)
	private Status currentStatus=Status.IDLE;
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
	// the set method doesnt have a return type
	public void setCurrentStatus(Status s) {
		currentStatus=s;
	}
	
	public ArrayList<Unit> getUnits() {
		return units;
	}
	// setters return void 
	public void  setUnits(ArrayList<Unit> s) {
		 units=s;
	}
	
	
	public int getDistancetoTarget() {
		return distancetoTarget;
	}
	public void setDistancetoTarget(int s) {
		distancetoTarget=s;
	}
	
	
	public String getTarget() {
		return target;
	}
	public void setTarget(String s) {
		 target=s;
	}
	
	
	
	public String getCurrentLocation() {
		return currentLocation;
	}
	public void setCurrentLocation(String s) {
		currentLocation=s;
	}
	
	
	public int getMaxToHold() {
		return maxToHold;
	}
	

}
