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
			Thread.sleep(5000); 
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd,HH:mm:ss");
		Calendar cal = Calendar.getInstance();
		String time = dateFormat.format(cal.getTime());
		Server.insertThermostatData(4001, time);
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		}
	}
}
