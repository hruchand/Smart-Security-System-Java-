package iot;

public class Locks extends RPI1{

	private static String front_door_status;
	private static String back_door_status;
	private static String garage_door_status;
	
	public static String getFront_door_status() {
		return front_door_status;
	}
	public static void setFront_door_status(String front_door_status) {
		Locks.front_door_status = front_door_status;
	}
	public static String getBack_door_status() {
		return back_door_status;
	}
	public static void setBack_door_status(String back_door_status) {
		Locks.back_door_status = back_door_status;
	}
	public static String getGarage_door_status() {
		return garage_door_status;
	}
	public static void setGarage_door_status(String garage_door_status) {
		Locks.garage_door_status = garage_door_status;
	}

	public String FrontDoorStatus(){
		String status = null;
		if(front_door_status.equalsIgnoreCase("locked")){
			status = "LOCKED";
		}
		else{
			status = "UNLOCKED";
		}
	 return status;
	}
	
	public String BackDoorStatus(){
		String status = null;
		if(back_door_status.equalsIgnoreCase("locked")){
			status = "LOCKED";
		}
		else{
			status = "UNLOCKED";
		}
	 return status;
	}
	
	public String GarageDoorStatus(){
		String status = null;
		if(garage_door_status.equalsIgnoreCase("locked")){
			status = "LOCKED";
		}
		else{
			status = "UNLOCKED";
		}
	 return status;
	}
	
}
