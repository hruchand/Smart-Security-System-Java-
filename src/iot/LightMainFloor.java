package iot;

public class LightMainFloor extends RPI1{
private static String lightStatus;
public static void setLightStatus(String lightStatus) {
	LightMainFloor.lightStatus = lightStatus;
}


private static int brightness;
public static void setBrightness(int brightness) {
	LightMainFloor.brightness = brightness;
}


private static int energyConsumed = 0;
private static int energy_rate = 2;
public LightMainFloor(){
	
}
public LightMainFloor(String lightStatus, int brightness ){
	this.lightStatus = lightStatus;
	this.brightness = brightness;
}


public static String getLightStatus() {
	return lightStatus;
}


public static int getBrightness() {
	return brightness;
}


public int EnergyConsumption(){
		energyConsumed = brightness * energy_rate;
 return energyConsumed;	 
}
}
