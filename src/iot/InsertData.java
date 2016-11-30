package iot;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class InsertData {
	public static void insertLightData(){
		try
		{
			String url = "http://"+ManageDB.ip+"/insertThermostat.php";
			URL urlObj = new URL(url);	
					}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

public static void insertThermostatData(){
		try
		{
//String insertVal =	Server.FromServer(4001);		
		//	thread.sleep(5000);
			
//System.out.println("thermostat insert");
String url = "http://"+ManageDB.ip+"/insertThermostat.php";
URL urlObj = new URL(url);
//String result = "";
//System.out.println("values for thermostat---\n");
//System.out.println(ManageDB.currentDate.get(0));
//
String data = "cId=" + URLEncoder.encode(ManageDB.cId, "UTF-8");
//String data1 = " "  +URLEncoder.encode(ManageDB.currentDate.get(0), "UTF-8");
//String data2 =  " "+URLEncoder.encode(ManageDB.tempModeUp.get(0), "UTF-8");
//String data3 =  " "+URLEncoder.encode(ManageDB.tempModeMain.get(0), "UTF-8");
//String data4 =  " "+URLEncoder.encode(ManageDB.tempEnergyUp.get(0), "UTF-8");
//String data5 =  " "+URLEncoder.encode(ManageDB.tempEnergyMain.get(0), "UTF-8");
//String data6 =  " "+URLEncoder.encode(ManageDB.currentTempUp.get(0), "UTF-8");
//String data7 = " "+URLEncoder.encode(ManageDB.currentTempMain.get(0), "UTF-8");
//String data8 = " "+URLEncoder.encode(Integer.toString(ManageDB.controlTempMainFloor), "UTF-8");
//String data9 = " "+URLEncoder.encode(Integer.toString(ManageDB.controlTempUpstair), "UTF-8");
//
//
//HttpURLConnection conn = (HttpURLConnection) urlObj.openConnection();
//conn.setDoInput(true);
//conn.setDoOutput(true);
//conn.setUseCaches(false);
//conn.setRequestMethod("POST");
//
//DataOutputStream  dataOut = new DataOutputStream(conn.getOutputStream());
//dataOut.writeBytes(data);
//dataOut.writeBytes(data1);
//dataOut.writeBytes(data2);
//dataOut.writeBytes(data3);
//dataOut.writeBytes(data4);
//dataOut.writeBytes(data5);
//dataOut.writeBytes(data6);
//dataOut.writeBytes(data7);
//dataOut.writeBytes(data8);
//dataOut.writeBytes(data9);
//
//dataOut.flush();
//dataOut.close();
//DataInputStream in = new DataInputStream(conn.getInputStream());
//String g;
//while((g = in.readLine()) != null){
//	result += g;
//}
//in.close();
//System.out.println(result);
//

			
			}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	public static void test(){
		try{
		//	System.out.println("inside test");
			//	thread.sleep(5000);
				
	//System.out.println("BEFORE CONNECTION");
	String url = "http://"+ManageDB.ip+"/fetchEner.php";
	URL urlObj = new URL(url);
	String result = "";
	


	HttpURLConnection conn = (HttpURLConnection) urlObj.openConnection();
	conn.setDoInput(true);
	conn.setDoOutput(true);
	conn.setUseCaches(false);
	conn.setRequestMethod("POST");

	

	
	DataInputStream in = new DataInputStream(conn.getInputStream());
	String g;
	while((g = in.readLine()) != null){
		result += g;
	}
	in.close();
//	System.out.println(result);

	
				
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
	
public static void insertSecurity(){
		try
		{
		//	String insertVal =	Server.insertSecData(4003);	
		//	thread.sleep(5000);
			
//System.out.println("security insert");
//String url = "http://"+ManageDB.ip+"/insertSecurity.php";
//URL urlObj = new URL(url);
//String result = "";
//
//String data = "cId=" + URLEncoder.encode(ManageDB.cId, "UTF-8");
//String data1 = " "  +URLEncoder.encode(ManageDB.currentDate.get(0), "UTF-8");
//String data2 =  " "+URLEncoder.encode(ManageDB.security_system, "UTF-8");
//
//
//
//HttpURLConnection conn = (HttpURLConnection) urlObj.openConnection();
//conn.setDoInput(true);
//conn.setDoOutput(true);
//conn.setUseCaches(false);
//conn.setRequestMethod("POST");
//
//DataOutputStream  dataOut = new DataOutputStream(conn.getOutputStream());
//dataOut.writeBytes(data);
//dataOut.writeBytes(data1);
//dataOut.writeBytes(data2);
//
//dataOut.flush();
//dataOut.close();
//DataInputStream in = new DataInputStream(conn.getInputStream());
//String g;
//while((g = in.readLine()) != null){
//	result += g;
//}
//in.close();
//System.out.println(result);
//

			
			}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

public static void insertLocks(){
	try
	{
		
	//	thread.sleep(5000);
		
//System.out.println("Locks insert");
String url = "http://"+ManageDB.ip+"/insertLocks.php";
URL urlObj = new URL(url);
String result = "";
//System.out.println(ManageDB.currentDate.get(0));

String data = "cId=" + URLEncoder.encode(ManageDB.cId, "UTF-8");
String data1 = " "  +URLEncoder.encode(ManageDB.currentDate.get(0), "UTF-8");
String data2 =  " "+URLEncoder.encode(ManageDB.f_door_status, "UTF-8");
String data3 =  " "+URLEncoder.encode(ManageDB.b_door_status, "UTF-8");
String data4 =  " "+URLEncoder.encode(ManageDB.g_door_status, "UTF-8");


HttpURLConnection conn = (HttpURLConnection) urlObj.openConnection();
conn.setDoInput(true);
conn.setDoOutput(true);
conn.setUseCaches(false);
conn.setRequestMethod("POST");

DataOutputStream  dataOut = new DataOutputStream(conn.getOutputStream());
dataOut.writeBytes(data);
dataOut.writeBytes(data1);
dataOut.writeBytes(data2);
dataOut.writeBytes(data3);
dataOut.writeBytes(data4);

dataOut.flush();
dataOut.close();
DataInputStream in = new DataInputStream(conn.getInputStream());
String g;
while((g = in.readLine()) != null){
result += g;
}
in.close();
//System.out.println(result);


		
		}
	catch (Exception e) {
		System.out.println(e.getMessage());
	}

}

public static void insertDoorSensor(){
	try
	{
		
	//	thread.sleep(5000);
		
//System.out.println("Door Sensors insert");
String url = "http://"+ManageDB.ip+"/insertDoorSensors.php";
URL urlObj = new URL(url);
String result = "";
//System.out.println(ManageDB.currentDate.get(0));

String data = "cId=" + URLEncoder.encode(ManageDB.cId, "UTF-8");
String data1 = " "  +URLEncoder.encode(ManageDB.currentDate.get(0), "UTF-8");
String data2 =  " "+URLEncoder.encode(ManageDB.door_window_sensor_up, "UTF-8");
String data3 =  " "+URLEncoder.encode(ManageDB.door_window_sensor_main, "UTF-8");



HttpURLConnection conn = (HttpURLConnection) urlObj.openConnection();
conn.setDoInput(true);
conn.setDoOutput(true);
conn.setUseCaches(false);
conn.setRequestMethod("POST");

DataOutputStream  dataOut = new DataOutputStream(conn.getOutputStream());
dataOut.writeBytes(data);
dataOut.writeBytes(data1);
dataOut.writeBytes(data2);
dataOut.writeBytes(data3);


dataOut.flush();
dataOut.close();
DataInputStream in = new DataInputStream(conn.getInputStream());
String g;
while((g = in.readLine()) != null){
result += g;
}
in.close();
//System.out.println(result);


		
		}
	catch (Exception e) {
		System.out.println(e.getMessage());
	}

}

public static void insertMotionSensor(){
try
{
	
//	thread.sleep(5000);
	
//System.out.println("Motion Sensors insert");
String url = "http://"+ManageDB.ip+"/insertMotionSensors.php";
URL urlObj = new URL(url);
String result = "";
//System.out.println(ManageDB.currentDate.get(0));

String data = "cId=" + URLEncoder.encode(ManageDB.cId, "UTF-8");
String data1 = " "  +URLEncoder.encode(ManageDB.currentDate.get(0), "UTF-8");
String data2 =  " "+URLEncoder.encode(ManageDB.motion_sensor_up, "UTF-8");
String data3 =  " "+URLEncoder.encode(ManageDB.motion_sensor_main, "UTF-8");



HttpURLConnection conn = (HttpURLConnection) urlObj.openConnection();
conn.setDoInput(true);
conn.setDoOutput(true);
conn.setUseCaches(false);
conn.setRequestMethod("POST");

DataOutputStream  dataOut = new DataOutputStream(conn.getOutputStream());
dataOut.writeBytes(data);
dataOut.writeBytes(data1);
dataOut.writeBytes(data2);
dataOut.writeBytes(data3);


dataOut.flush();
dataOut.close();
DataInputStream in = new DataInputStream(conn.getInputStream());
String g;
while((g = in.readLine()) != null){
result += g;
}
in.close();
//System.out.println(result);


	
	}
catch (Exception e) {
	System.out.println(e.getMessage());
}

}

public static void insertWeather(){
try
{
	
//	thread.sleep(5000);
	
//System.out.println("weather data  insert");
String url = "http://"+ManageDB.ip+"/weatherInsert.php";
URL urlObj = new URL(url);
String result = "";
//System.out.println(ManageDB.currentDate.get(0));

String data = "cId=" + URLEncoder.encode(ManageDB.cId, "UTF-8");
String data1 = " "  +URLEncoder.encode(ManageDB.currentDate.get(0), "UTF-8");
String data2 =  " "+URLEncoder.encode(Integer.toString(Weather.getWeather_temp()), "UTF-8");
String data3 =  " "+URLEncoder.encode(Weather.getWeather_condition(), "UTF-8");



HttpURLConnection conn = (HttpURLConnection) urlObj.openConnection();
conn.setDoInput(true);
conn.setDoOutput(true);
conn.setUseCaches(false);
conn.setRequestMethod("POST");

DataOutputStream  dataOut = new DataOutputStream(conn.getOutputStream());
dataOut.writeBytes(data);
dataOut.writeBytes(data1);
dataOut.writeBytes(data2);
dataOut.writeBytes(data3);


dataOut.flush();
dataOut.close();
DataInputStream in = new DataInputStream(conn.getInputStream());
String g;
while((g = in.readLine()) != null){
result += g;
}
in.close();
//System.out.println(result);


	
	}
catch (Exception e) {
	System.out.println(e.getMessage());
}

}
}
