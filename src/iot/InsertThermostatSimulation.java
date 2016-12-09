package iot;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class InsertThermostatSimulation implements Runnable{
	Thread thread = new Thread(this);
	public InsertThermostatSimulation(){
		thread.start();
	}
	public void run(){
		while(true)
		{
			
		try{
			
		//	Thread.sleep(120000); 
	//	System.out.println("inside thermostat simulation thread");
		
		Server.insertThermostatData(2100);
		//Thread.sleep(10000); 
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		}
	}
}
