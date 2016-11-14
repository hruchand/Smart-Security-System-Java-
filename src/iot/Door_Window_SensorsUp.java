package iot;

public class Door_Window_SensorsUp extends RPI2{
//private static String door_status;
//private static String window_status;
private static String Sensor_status;

//public static String getDoor_status() {
//	return door_status;
//}
//
//public static void setDoor_status(String door_status) {
//	Door_Window_SensorsUp.door_status = door_status;
//}
//
//public static String getWindow_status() {
//	return window_status;
//}
//
//public static void setWindow_status(String window_status) {
//	Door_Window_SensorsUp.window_status = window_status;
//}

public static String getSensor_status() {
	return Sensor_status;
}

public static void setSensor_status(String sensor_status) {
	Sensor_status = sensor_status;
}

public String SensorStatus(){
	String status = null;
	if(Sensor_status.equalsIgnoreCase("on")){
		status = "ON";
	}
	else{
		status = "OFF";
	}
	return status;
}

//public String WindowStatus(){
//	String status = null;
//	if(window_status.equalsIgnoreCase("on")){
//		status = "ON";
//	}
//	else{
//		status = "OFF";
//	}
//	return status;
//}
}
