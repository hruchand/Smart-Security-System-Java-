package iot;

public class ThermostatUpstair extends RPI2{
private static int currentTemperature = Integer.parseInt(ManageDB.curTempUp);	
private static int energyConsumed;
public static int getEnergyConsumed() {
	return energyConsumed;
}

public static void setEnergyConsumed(int energyConsumed) {
	ThermostatUpstair.energyConsumed = energyConsumed;
}

private static double energy_rate = 1.8;


	private static int controlTemperature;
	public static int getCurrentTemperature() {
		return currentTemperature;
	}

	public static void setCurrentTemperature(int currentTemperature) {
		ThermostatUpstair.currentTemperature = currentTemperature;
	}

	public static int getControlTemperature() {
		return controlTemperature;
	}

	public static void setControlTemperature(int controlTemperature) {
		ThermostatUpstair.controlTemperature = controlTemperature;
	}

	public static String getMode() {
		return mode;
	}

	public static void setMode(String mode) {
		ThermostatUpstair.mode = mode;
	}

	private static String mode= "off";

    private static String fanStatus;

	public ThermostatUpstair(int controlTemp, String mode){
	this.controlTemperature= controlTemp;
	this.mode=mode;	
	}
	
	public String fan(String fanMode){
		if(fanMode.equalsIgnoreCase("auto")){
			fanStatus = "autoMode";
		}
		else{
			fanStatus="offMode";
		}
		return fanStatus;
	}
	public static double EnergyConsumption(int curr_temp){
		energyConsumed = (int) (curr_temp * energy_rate);
       System.out.println("calculated energy up-"+energyConsumed);
		return energyConsumed;
	
    }
}
