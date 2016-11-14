package iot;

public class SimulationThreadThermostatUpstair implements Runnable {
	
Thread thread = new Thread(this);
	public SimulationThreadThermostatUpstair(){	
		thread.start();
	}
	
	public void run(){
		try{
		while (true) {
			if(ThermostatUpstair.getMode().equalsIgnoreCase("off") || ThermostatUpstair.getCurrentTemperature() == ThermostatUpstair.getControlTemperature()){
				break;
			}
            switch (ThermostatUpstair.getMode()) {
                case "heat":
 System.out.println("Upstair temp:" +ThermostatUpstair.getCurrentTemperature());
 System.out.println("Upstair Control Temp:" +ThermostatUpstair.getControlTemperature());
                	Thread.sleep(10000);                    
                    if (ThermostatUpstair.getCurrentTemperature() < ThermostatUpstair.getControlTemperature() && ThermostatUpstair.getCurrentTemperature() < 80) {
               //         Thread.sleep(1000);
                        ThermostatUpstair.setCurrentTemperature(ThermostatUpstair.getCurrentTemperature()+1); 
                        System.out.println("\nCurrent Temperature of Upstair:"+ThermostatUpstair.getCurrentTemperature());
                   //     SetData.setThermDataup(5002);
                        System.out.println("\nCurrent energy consumption of Upstair:"+ThermostatUpstair.EnergyConsumption(ThermostatUpstair.getCurrentTemperature()));
                    }
                    break;

                case "cool":
                  
                    if(ThermostatUpstair.getCurrentTemperature() > ThermostatUpstair.getControlTemperature() && ThermostatUpstair.getCurrentTemperature() > 45) {
                        Thread.sleep(10000);
                        ThermostatUpstair.setCurrentTemperature(ThermostatUpstair.getCurrentTemperature()-1);
                        System.out.println("\nCurrent Temperature of Upstair:"+ThermostatUpstair.getCurrentTemperature());
                   //     SetData.setThermDataup(5002);
                        System.out.println("\nCurrent energy consumption of Upstair:"+ThermostatUpstair.EnergyConsumption(ThermostatUpstair.getCurrentTemperature()));
                        }
                break;
                default:
                break;
            }
	}
		//System.out.println("\nCurrent Temperature reached control temp:"+ThermostatUpstair.getCurrentTemperature());
		//System.out.println("\nCurrent energy consumption of Upstair:"+Thermostat.EnergyConsumption(ThermostatUpstair.getCurrentTemperature()));
}
	catch (Exception e) {
		System.out.println(e.getMessage());
	}
}
}
