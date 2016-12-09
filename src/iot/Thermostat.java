package iot;

public class Thermostat extends RPI1{

	private static int currentTemperature = Integer.parseInt(ManageDB.curTempMain);	

	private static int controlTemperature;
	private static int energyConsumed;
	public static int getEnergyConsumed() {
		return energyConsumed;
	}

	public static void setEnergyConsumed(int energyConsumed) {
		Thermostat.energyConsumed = energyConsumed;
	}

	private static double energy_rate = 1.8;
	
	public static int getCurrentTemperature() {
		return currentTemperature;
	}

	public static void setCurrentTemperature(int currentTemperature) {
		Thermostat.currentTemperature = currentTemperature;
	}

	public static int getControlTemperature() {
		return controlTemperature;
	}

	public static void setControlTemperature(int controlTemperature) {
		Thermostat.controlTemperature = controlTemperature;
	}

	public static String getMode() {
		return mode;
	}

	public static void setMode(String mode) {
		Thermostat.mode = mode;
	}

	private static String mode= "off";

    private static String fanStatus = "off";
	public Thermostat(int controlTemp, String mode){
		System.out.println("before the cons");
	this.controlTemperature= controlTemp;
	this.mode=mode;
//System.out.println("inside the constructor");
	
	}
	
	public String fan(String fanMode){
		if(mode.equalsIgnoreCase("heat") || mode.equalsIgnoreCase("cool")){
		if(fanMode.equalsIgnoreCase("auto")){
			fanStatus = "autoMode";
		}
		else{
			fanStatus="offMode";
		}
		}
		return fanStatus;
	}
	
	public static double EnergyConsumption(int curr_temp){
		energyConsumed = (int)(curr_temp * energy_rate);
	//	 System.out.println("calculated energy main floor-"+energyConsumed);
        return energyConsumed;	 
	}
}
