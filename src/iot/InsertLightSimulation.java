package iot;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class InsertLightSimulation implements Runnable{
	Thread thread = new Thread(this);
	
	public InsertLightSimulation(){
		thread.start();
	}
	
	public void run(){
		while(true)
		{
		try{
			 
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd,HH:mm:ss");
		Calendar cal = Calendar.getInstance();
		String time = dateFormat.format(cal.getTime());
		Server.insertLightData(4002, time);
		Thread.sleep(120000);
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		}
	}
}
