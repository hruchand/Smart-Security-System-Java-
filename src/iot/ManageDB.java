package iot;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.sql.Connection;

import java.sql.DriverAction;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

//import org.apache.http.HttpEntity;
//import org.apache.http.HttpResponse;
//import org.apache.http.client.HttpClient;
//import org.apache.http.client.entity.UrlEncodedFormEntity;
//import org.apache.http.client.methods.HttpPost;
//import org.apache.http.impl.client.DefaultHttpClient;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalInput;
import com.pi4j.io.gpio.PinPullResistance;
import com.pi4j.io.gpio.RaspiPin;
import com.pi4j.io.gpio.event.GpioPinDigitalStateChangeEvent;
import com.pi4j.io.gpio.event.GpioPinListenerDigital;
//import com.sun.jna.platform.win32.SetupApi;

public class ManageDB {
	static String ip="192.168.1.3";
	static	String url222 = "http://"+ip+"/iot.php";

	static	String cId ="1";
	static	String currentTempUp;
	static	String currentTempMain;
	//	String customerId = "1";
	static	ArrayList<String> currentDate = new ArrayList<>();
	static	String tempModeUp ;
	static	String tempModeMain ;
	static	String tempEnergyUp ;
	static	String tempEnergyMain ;
	static int controlTempUpstair;
	static int controlTempMainFloor;
	static String lightModeMainFloor;
	static String lightModeUpStair;
	static int energy_consumed_MF;
	static int energy_consumed_US;
	static int brightnessMainFloor;
	static String security_system = "null";
	static String f_door_status = "UNLOCKED";
	static String b_door_status = "UNLOCKED";
	static String g_door_status = "UNLOCKED";
	static String door_window_sensor_main = "OFF";
	static String door_window_sensor_up = "OFF";
	static String motion_sensor_up = "INACTIVE";
	static String motion_sensor_main = "INACTIVE";
	static String curTempUp;
	static String curTempMain;
	static String twoDoorStatus;
	static String oneDoorStatus;

	static int brightnessUpStair;
	
//	try{
//		Test.check();
//	}
//	catch (Exception e) {
//		System.out.println(e.getMessage());
//	}
//	}
//
//	public static void demo() {
	public static void main(String args[]){
		try{
			String thermoStatModeMainFloor;
			String fanModeMainFloor;
			String thermoStatModeUpstair;
			String fanModeUpstair;

		//	FetchData.fetchCurTemp();
			FetchData.fetchlightData();
		//	FetchData.fetchSecurityData();
			FetchData.fetchLockData();
		//	FetchData.fetchDoorSensorData();
			FetchData.fetchMotionSensorData();
		//	FetchData.fetchWeatherData();
		//	FetchData.fetchGarageDoorStatus();
System.out.println("light status"+LightMainFloor.getLightStatus());
System.out.println("lock status"+Locks.getFront_door_status());
System.out.println("motion sensor status"+MotionDetectorMain.getMotion_detector_status());
				EventTriggerPi eventTriggerPi = new EventTriggerPi();
				

			System.out.println("Set  Control Temp for MainFloor(int)\n");	
			while(true)
			{
				Scanner scanner = new Scanner(System.in);
				if(scanner.hasNext())
				{
					controlTempMainFloor = scanner.nextInt();
					break;
				}
			}

			System.out.println("Set Thermostat Mode for mainFloor(heat/cool/off)");
			while(true)
			{
				Scanner scanner = new Scanner(System.in);
				if(scanner.hasNext())
				{
					thermoStatModeMainFloor = scanner.nextLine();
					break;
				}
			}


			System.out.println("Set Fan Mode for Mainfloor(auto/off)");
			while(true)
			{
				Scanner scanner = new Scanner(System.in);
				if(scanner.hasNext())
				{
					fanModeMainFloor = scanner.nextLine();
					break;
				}
			}
			System.out.println("Set  Control Temp for upstair(int)\n");	
			while(true)
			{
				Scanner scanner = new Scanner(System.in);
				if(scanner.hasNext())
				{
					controlTempUpstair = scanner.nextInt();
					break;
				}
			}

			System.out.println("Set Thermostat Mode for upStair(heat/cool/off)");
			while(true)
			{
				Scanner scanner = new Scanner(System.in);
				if(scanner.hasNext())
				{
					thermoStatModeUpstair = scanner.nextLine();
					break;
				}
			}

			System.out.println("Set Fan Mode for upStair(auto/off)");
			while(true)
			{
				Scanner scanner = new Scanner(System.in);
				if(scanner.hasNext())
				{
					fanModeUpstair = scanner.nextLine();
					break;
				}
			}


			System.out.println("Set Light Mode for Main Floor(on/off)");
			while(true)
			{
				Scanner scanner = new Scanner(System.in);
				if(scanner.hasNext())
				{
					lightModeMainFloor = scanner.nextLine();
					break;
				}
			}

			System.out.println("Set Brightness for Main Floor(Integer Value)");
			while(true)
			{
				Scanner scanner = new Scanner(System.in);
				if(scanner.hasNext())
				{
					brightnessMainFloor = scanner.nextInt();
					break;
				}
			}

			System.out.println("Set Light Mode for Up Stair(on/off)");
			while(true)
			{
				Scanner scanner = new Scanner(System.in);
				if(scanner.hasNext())
				{
					lightModeUpStair = scanner.nextLine();
					break;
				}
			}

			System.out.println("Set Brightness for Up Stair(Integer Value)");
			while(true)
			{
				Scanner scanner = new Scanner(System.in);
				if(scanner.hasNext())
				{
					brightnessUpStair = scanner.nextInt();
					break;
				}
			}

			System.out.println("Set Security System status(Disarmed/Armed_Stay/Armed_Away)");
			while(true)
			{
				Scanner scanner = new Scanner(System.in);
				if(scanner.hasNext())
				{
					security_system = scanner.nextLine();
					break;
				}
			}

			System.out.println("Lock the front door(Locked/Unlocked)");
			while(true)
			{
				Scanner scanner = new Scanner(System.in);
				if(scanner.hasNext())
				{
					f_door_status = scanner.nextLine();
					break;
				}
			}

			System.out.println("Lock the back door(Locked/Unlocked)");
			while(true)
			{
				Scanner scanner = new Scanner(System.in);
				if(scanner.hasNext())
				{
					b_door_status = scanner.nextLine();
					break;
				}
			}

			System.out.println("Lock the garage door(Locked/Unlocked)");
			while(true)
			{
				Scanner scanner = new Scanner(System.in);
				if(scanner.hasNext())
				{
					g_door_status = scanner.nextLine();
					break;
				}
			}

			System.out.println("Enter the Door window sensor status for main: (on/off)");
			while(true)
			{
				Scanner scanner = new Scanner(System.in);
				if(scanner.hasNext())
				{
					door_window_sensor_main = scanner.nextLine();
					break;
				}
			}

			System.out.println("Enter the Door window sensor status for upstair: (on/off)");
			while(true)
			{
				Scanner scanner = new Scanner(System.in);
				if(scanner.hasNext())
				{
					door_window_sensor_up = scanner.nextLine();
					break;
				}
			}

			System.out.println("Enter the Door window sensor status for main: (on/off)");
			while(true)
			{
				Scanner scanner = new Scanner(System.in);
				if(scanner.hasNext())
				{
					door_window_sensor_main = scanner.nextLine();
					break;
				}
			}

			System.out.println("Enter the Door window sensor status for upstair: (on/off)");
			while(true)
			{
				Scanner scanner = new Scanner(System.in);
				if(scanner.hasNext())
				{
					door_window_sensor_up = scanner.nextLine();
					break;
				}
			}

			System.out.println("Enter the Two Door GarageStatus: (Locked/Unlocked)");
			while(true)
			{
				Scanner scanner = new Scanner(System.in);
				if(scanner.hasNext())
				{
					twoDoorStatus = scanner.nextLine();
					break;
				}
			}

			System.out.println("Enter the Two Door GarageStatus: (Locked/Unlocked)");
			while(true)
			{
				Scanner scanner = new Scanner(System.in);
				if(scanner.hasNext())
				{
					oneDoorStatus = scanner.nextLine();
					break;
				}
			}


			MotionDetectorUp mu = new MotionDetectorUp();
			MotionDetectorMain mm = new MotionDetectorMain();
			mu.setMotion_detector_status(motion_sensor_up);
			mm.setMotion_detector_status(motion_sensor_main);

			Door_Window_SensorsMain dwm = new Door_Window_SensorsMain();
			dwm.setSensor_status(door_window_sensor_main);

			Door_Window_SensorsUp dwu = new Door_Window_SensorsUp();
			dwu.setSensor_status(door_window_sensor_up);

			Thermostat thermostat = new Thermostat(controlTempMainFloor, thermoStatModeMainFloor);
			SimulationThreadThermostat simulationThreadThermostat = new SimulationThreadThermostat();
			String fanStatusMainfloor = thermostat.fan(fanModeMainFloor);

			ThermostatUpstair thermostatUpstair = new ThermostatUpstair(controlTempUpstair, thermoStatModeUpstair);
			SimulationThreadThermostatUpstair simulationThreadThermostatUpstair = new SimulationThreadThermostatUpstair();
			String fanStatusUpstair = thermostatUpstair.fan(fanModeUpstair);

			SecuritySystem ss = new SecuritySystem();
			ss.setSecurity_status(security_system);
			System.out.println("\nSecurity Status:" + ss.SecurityStatus());

			LightMainFloor lightMainFloor = new LightMainFloor(lightModeMainFloor,brightnessMainFloor);
			LightUpstair lightUpStair = new LightUpstair(lightModeUpStair,brightnessUpStair);

			Locks l = new Locks();
			l.setBack_door_status(b_door_status);
			l.setFront_door_status(f_door_status);
			l.setGarage_door_status(g_door_status);
			//		System.out.println("Front door is:" + l.FrontDoorStatus());
			//		System.out.println("Back door is:" + l.BackDoorStatus());
			//		System.out.println("Garage door is:" + l.GarageDoorStatus());

		}catch (Exception e) {
			System.out.println(e.getMessage());
		}	

	//	System.out.println("above setupdata");
		//	createTable();
		try{
		InsertThermostatSimulation insertThermostatSimulation = new InsertThermostatSimulation();
		InsertLightSimulation insertLightSimulation = new InsertLightSimulation();
		InsertSecSimulation insertSecSimulation = new InsertSecSimulation();
		InsertLockSimulation insertLockSimulation = new InsertLockSimulation();
		InsertDoorSimulation insertDoorSimulation = new InsertDoorSimulation();
		InsertMotionSensorSimulation insertMotionSensorSimulation = new InsertMotionSensorSimulation();
		InsertWeatherSimulation insertWeatherSimulation = new InsertWeatherSimulation();
		InsertGarageDoorSimulation insertGarageDoorSimulation = new InsertGarageDoorSimulation();
		/*	
			for(;;)
			{
				DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd,HH:mm:ss");
				Calendar cal = Calendar.getInstance();
				String time = dateFormat.format(cal.getTime());	
				Thread.sleep(5000); 
				Server.insertThermostatData(4001, time);
				Server.insertLightData(4002, time);
				Server.insertSecData(4003, time);
				Server.insertLockData(4004, time);
				Server.insertDoorData(4005, time);
				Server.insertMotionSensorData(4006, time);
				Server.insertWeatherData(4007, time);
			}
*/
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	public static void createTable(){
		try
		{
			String url = "http://"+ip+"/iot.php";
			URL urlObj = new URL(url);
			String result = "";
			HttpURLConnection conn = (HttpURLConnection) urlObj.openConnection();
			conn.setDoInput(true);
			conn.setDoOutput(true);
			conn.setUseCaches(false);
			conn.setRequestMethod("POST");
			//DataOutputStream  dataOut = new DataOutputStream(conn.getOutputStream());
			//dataOut.flush();
			//dataOut.close();
			DataInputStream in = new DataInputStream(conn.getInputStream());
			String g;
			while((g = in.readLine()) != null){
				result += g;
			}
			in.close();
			System.out.println(result);
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
