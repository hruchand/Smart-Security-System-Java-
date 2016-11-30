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
		System.out.println("inside sim");
			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd,HH:mm:ss");
		Calendar cal = Calendar.getInstance();
		String time = dateFormat.format(cal.getTime());
		Server.insertThermostatData(2100, time);
		Thread.sleep(120000); 
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		}
	}
}
