package iot;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
public class Server {

	public static void insertThermostatData(int port, String time) throws Exception {
		try{
			Thread.sleep(5000);
		}
		catch (Exception e) {
			//			// TODO: handle exception
		}
		ServerSocket listener = new ServerSocket(port);
		listener.setReuseAddress(true);

		try {
			ManageDB.tempModeUp = ThermostatUpstair.getMode();
			ManageDB.tempModeMain = Thermostat.getMode();
			ManageDB.tempEnergyUp = Integer.toString(ThermostatUpstair.getEnergyConsumed()) ;
			ManageDB.tempEnergyMain = Integer.toString(Thermostat.getEnergyConsumed()) ;
			ManageDB.currentTempUp =Integer.toString(ThermostatUpstair.getCurrentTemperature());
			ManageDB.currentTempMain = Integer.toString(Thermostat.getCurrentTemperature());
			System.out.println("energy up"+ManageDB.tempEnergyUp);
			System.out.println("energy main"+ManageDB.tempEnergyMain);

			while (true) {
				Socket socket = listener.accept();



				String value = ManageDB.cId +" "+ time +" "+ManageDB.tempModeUp+" "+ManageDB.tempModeMain+" "+ManageDB.tempEnergyUp
						+" "+ManageDB.tempEnergyMain+" "+ManageDB.currentTempUp+" "+ManageDB.currentTempMain+" "+Integer.toString(ManageDB.controlTempMainFloor)
						+" "+Integer.toString(ManageDB.controlTempUpstair);
				PrintWriter out =
						new PrintWriter(socket.getOutputStream(), true);
				out.println(value);
				Thread.sleep(1000);
				out.flush();
				out.close();
				socket.close();
				listener.close();

			}
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		} 


	}

	public static void insertLightData(int port, String time) throws Exception {
		LightMainFloor lightMainFloor = new LightMainFloor();
		LightUpstair lightUpStair = new LightUpstair();
		try{

			Thread.sleep(5000);
		}
		catch (Exception e) {
			//			// TODO: handle exception
		}
		if(ManageDB.lightModeMainFloor.equalsIgnoreCase("on")){

			ManageDB.energy_consumed_MF = lightMainFloor.EnergyConsumption();
			//	System.out.println("\nLight Status on Main Floor:" + lightMainFloor.getLightStatus());
			//	System.out.println("\nMain Floor energy consumption of light:" + ManageDB.energy_consumed_MF);
		}else{
			//	System.out.println("\nLight Status on Main Floor:" + lightMainFloor.getLightStatus());
			//	System.out.println("\nMain Floor energy consumption of light: 0");
		}


		if(ManageDB.lightModeUpStair.equalsIgnoreCase("on")){
			ManageDB.energy_consumed_US = lightUpStair.EnergyConsumption();
			//	System.out.println("\nLight Status on Up Stair:" + lightUpStair.getLightStatus());
			//	System.out.println("\nUp Stair energy consumption of light:" + ManageDB.energy_consumed_US);
		}else{
			//	System.out.println("\nLight Status on Up Stair:" + lightMainFloor.getLightStatus());
			//	System.out.println("\nUp Stair energy consumption of light: 0");
		}
		System.out.println("inside light data:-"+ManageDB.cId);
		System.out.println("inside light data:-"+time);
		System.out.println("inside light data:-"+ManageDB.lightModeUpStair);
		System.out.println("inside light data:-"+ManageDB.lightModeMainFloor);
		System.out.println("inside light data:-"+Integer.toString(ManageDB.energy_consumed_US));
		System.out.println("inside light data:-"+Integer.toString(ManageDB.energy_consumed_MF));
		System.out.println("inside light data:-"+Integer.toString( ManageDB.brightnessUpStair));
		System.out.println("inside light data:-"+Integer.toString(ManageDB.brightnessMainFloor));

		ServerSocket listener = new ServerSocket(port);
		listener.setReuseAddress(true);

		try {

			while (true) {
				Socket socket = listener.accept();


				String value = ManageDB.cId +" "+time+" "+ManageDB.lightModeUpStair+" "+ManageDB.lightModeMainFloor+" "+Integer.toString(ManageDB.energy_consumed_US)
				+" "+Integer.toString(ManageDB.energy_consumed_MF)+" "+Integer.toString( ManageDB.brightnessUpStair)+" "+Integer.toString(ManageDB.brightnessMainFloor);
				PrintWriter out =
						new PrintWriter(socket.getOutputStream(), true);
				out.println(value);
				Thread.sleep(1000);
				out.flush();
				out.close();
				socket.close();
				listener.close();
			}
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		} 


	}

	public static void insertSecData(int port, String time) throws Exception {
		try{
			Thread.sleep(5000);
		}
		catch (Exception e) {
			//			// TODO: handle exception
		}
		ServerSocket listener = new ServerSocket(port);
		listener.setReuseAddress(true);

		try {

			while (true) {
				Socket socket = listener.accept();
				try {
					
					String value = ManageDB.cId +" "+ time+" "+ManageDB.security_system;
					PrintWriter out =
							new PrintWriter(socket.getOutputStream(), true);
					out.println(value);
					Thread.sleep(1000);
					out.flush();
					out.close();

				} finally {
					
					socket.close();
					listener.close();
				}
			}
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		} 


	}

	public static void insertLockData(int port, String time) throws Exception {
		try{
			Thread.sleep(5000);
		}
		catch (Exception e) {
			//			// TODO: handle exception
		}
		ServerSocket listener = new ServerSocket(port);
		listener.setReuseAddress(true);

		try {

			while (true) {
				Socket socket = listener.accept();
				try {

				
					String value = ManageDB.cId +" "+ time +" "+ManageDB.f_door_status+" "+ManageDB.b_door_status+" "+ ManageDB.g_door_status;
					PrintWriter out =
							new PrintWriter(socket.getOutputStream(), true);
					out.println(value);
					Thread.sleep(1000);
					out.flush();
					out.close();

				} finally {
					//  out.c
					socket.close();
					listener.close();
				}
			}
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		} 


	}

	public static void insertDoorData(int port, String time) throws Exception {
		try{
			Thread.sleep(5000);
		}
		catch (Exception e) {
			//			// TODO: handle exception
		}
		ServerSocket listener = new ServerSocket(port);
		listener.setReuseAddress(true);

		try {

			while (true) {
				Socket socket = listener.accept();
				try {

					String value = ManageDB.cId +" "+ time +" "+ManageDB.door_window_sensor_up+" "+ManageDB.door_window_sensor_main;
					PrintWriter out =
							new PrintWriter(socket.getOutputStream(), true);
					out.println(value);
					Thread.sleep(1000);
					out.flush();
					out.close();

				} finally {
					//  out.c
					socket.close();
					listener.close();
				}
			}
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		} 


	}
	public static void insertMotionSensorData(int port, String time) throws Exception {
		try{
			Thread.sleep(5000);
		}
		catch (Exception e) {
			//			// TODO: handle exception
		}
		ServerSocket listener = new ServerSocket(port);
		listener.setReuseAddress(true);

		try {

			while (true) {
				Socket socket = listener.accept();
				try {

			    	String value = ManageDB.cId +" "+ time +" "+ManageDB.motion_sensor_up+" "+ManageDB.motion_sensor_main;
					PrintWriter out =
							new PrintWriter(socket.getOutputStream(), true);
					out.println(value);
					Thread.sleep(1000);
					out.flush();
					out.close();

				} finally {
					//  out.c
					socket.close();
					listener.close();
				}
			}
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		} 


	}
	public static void insertWeatherData(int port, String time) throws Exception {
		try{
			Thread.sleep(5000);
		}
		catch (Exception e) {
			//			// TODO: handle exception
		}
		ServerSocket listener = new ServerSocket(port);
		listener.setReuseAddress(true);

		try {

			while (true) {
				Socket socket = listener.accept();
				try {

			    	String value = ManageDB.cId +" "+ time +" "+Integer.toString(Weather.getWeather_temp())+" "+Weather.getWeather_condition();
					PrintWriter out =
							new PrintWriter(socket.getOutputStream(), true);
					out.println(value);
					Thread.sleep(1000);
					out.flush();
					out.close();

				} finally {
					//  out.c
					socket.close();
					listener.close();
				}
			}
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		} 


	
	}



	public static void insertGarageDoorData(int port, String time) throws Exception {
		try{
			Thread.sleep(5000);
		}
		catch (Exception e) {
			//			// TODO: handle exception
		}
		ServerSocket listener = new ServerSocket(port);
		listener.setReuseAddress(true);

		try {

			while (true) {
				Socket socket = listener.accept();
				try {

			    	String value = ManageDB.cId +" "+ time +" "+ManageDB.twoDoorStatus+" "+ManageDB.oneDoorStatus;
					PrintWriter out =
							new PrintWriter(socket.getOutputStream(), true);
					out.println(value);
					Thread.sleep(1000);
					out.flush();
					out.close();

				} finally {
					//  out.c
					socket.close();
					listener.close();
				}
			}
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		} 


	
	}

}



