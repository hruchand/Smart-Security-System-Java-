package iot;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class InsertDoorSimulation implements Runnable{
	Thread thread = new Thread(this);
	public InsertDoorSimulation(){
		thread.start();
	}
	public void run(){
		while(true)
		{
			
		try{
			
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd,HH:mm:ss");
		Calendar cal = Calendar.getInstance();
		String time = dateFormat.format(cal.getTime());
		Server.insertDoorData(4005, time);
		Thread.sleep(120000); 
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		}
	}
}
