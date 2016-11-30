package iot;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;
import java.net.URLEncoder;
public class Server {

	public static void insertThermostatData(int port, String time) throws Exception {
	
		ServerSocket listener = new ServerSocket(port);
		listener.setReuseAddress(true);
		
		try {
			
			ManageDB.tempModeUp = ThermostatUpstair.getMode();
			ManageDB.tempModeMain = Thermostat.getMode();
			ManageDB.tempEnergyUp = Integer.toString(ThermostatUpstair.getEnergyConsumed()) ;
			ManageDB.tempEnergyMain = Integer.toString(Thermostat.getEnergyConsumed()) ;
			ManageDB.currentTempUp =Integer.toString(ThermostatUpstair.getCurrentTemperature());
			ManageDB.currentTempMain = Integer.toString(Thermostat.getCurrentTemperature());

//			ManageDB.cId = "1";
//			String time1 = time;
//			ManageDB.tempModeUp = "heat";
//			ManageDB.tempModeMain = "cool";
//			ManageDB.tempEnergyUp = "54" ;
//			ManageDB.tempEnergyMain = "56" ;
//			ManageDB.currentTempUp ="55";
//			ManageDB.currentTempMain = "55";
//			ManageDB.controlTempMainFloor =66;
//			ManageDB.controlTempUpstair=88;
		/*
			String url = "http://"+ManageDB.ip+"/insertThermostat.php";
			URL urlObj = new URL(url);
			String result = "";
			String data = "cId=" + URLEncoder.encode(ManageDB.cId, "UTF-8");
			String data1 = " "  +URLEncoder.encode(time, "UTF-8");
			String data2 =  " "+URLEncoder.encode(ManageDB.tempModeUp, "UTF-8");
			String data3 =  " "+URLEncoder.encode(ManageDB.tempModeMain, "UTF-8");
			String data4 =  " "+URLEncoder.encode(ManageDB.tempEnergyUp, "UTF-8");
			String data5 =  " "+URLEncoder.encode(ManageDB.tempEnergyMain, "UTF-8");
			String data6 =  " "+URLEncoder.encode(ManageDB.currentTempUp, "UTF-8");
			String data7 = " "+URLEncoder.encode(ManageDB.currentTempMain, "UTF-8");
			String data8 = " "+URLEncoder.encode(Integer.toString(ManageDB.controlTempMainFloor), "UTF-8");
			String data9 = " "+URLEncoder.encode(Integer.toString(ManageDB.controlTempUpstair), "UTF-8");
			
		
			
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
			dataOut.writeBytes(data5);
			dataOut.writeBytes(data6);
			dataOut.writeBytes(data7);
			dataOut.writeBytes(data8);
			dataOut.writeBytes(data9);
			
			dataOut.flush();
			dataOut.close();
			DataInputStream in = new DataInputStream(conn.getInputStream());
			String g;
			while((g = in.readLine()) != null){
				result += g;
			}
			in.close();
			//System.out.println(result);
			//
			
		//	System.out.println("energy up"+ManageDB.tempEnergyUp);
		//	System.out.println("energy main"+ManageDB.tempEnergyMain);
*/
			while (true) {
				Socket socket = listener.accept();
				
				String value = ManageDB.cId +" "+ time +" "+ManageDB.tempModeUp+" "+ManageDB.tempModeMain+" "+ManageDB.tempEnergyUp
						+" "+ManageDB.tempEnergyMain+" "+ManageDB.currentTempUp+" "+ManageDB.currentTempMain+" "+Integer.toString(ManageDB.controlTempMainFloor)
						+" "+Integer.toString(ManageDB.controlTempUpstair);
				PrintWriter out =
						new PrintWriter(socket.getOutputStream(), true);
				
	System.out.println("reached output print");
				out.println(value);
				
				//Thread.sleep(1000);
				out.flush();
				out.close();
				ServerSocket listener1 = new ServerSocket(2501);
				listener1.setReuseAddress(true);

				Socket socket1 = listener1.accept();
				PrintWriter out1 = new PrintWriter(socket1.getOutputStream(), true);
				out1.println(value);
				out1.flush();
				out1.close();
			//	socket.close();
			//	listener.close();
						}
			
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		} 
	}

	public static void insertLightData(int port, String time) throws Exception {
		try {
/*
			String url = "http://"+ManageDB.ip+"/insertlightdata.php";
		URL urlObj = new URL(url);	
		String result = "";
	*/	
		LightMainFloor lightMainFloor = new LightMainFloor();
		LightUpstair lightUpStair = new LightUpstair();
		
		if(ManageDB.lightModeMainFloor.equalsIgnoreCase("on")){

			ManageDB.energy_consumed_MF = lightMainFloor.EnergyConsumption();
		
		}else{
			
		}


		if(ManageDB.lightModeUpStair.equalsIgnoreCase("on")){
			ManageDB.energy_consumed_US = lightUpStair.EnergyConsumption();
			
		}else{
			
		}
	/*	
		String data = "cId=" + URLEncoder.encode(ManageDB.cId, "UTF-8");
		String data1 = " "  +URLEncoder.encode(time, "UTF-8");
		String data2 =  " "+URLEncoder.encode(ManageDB.lightModeUpStair, "UTF-8");
		String data3 =  " "+URLEncoder.encode(ManageDB.lightModeMainFloor, "UTF-8");
		String data4 =  " "+URLEncoder.encode(Integer.toString(ManageDB.energy_consumed_US), "UTF-8");
		String data5 =  " "+URLEncoder.encode(Integer.toString(ManageDB.energy_consumed_MF), "UTF-8");
		String data6 =  " "+URLEncoder.encode(Integer.toString( ManageDB.brightnessUpStair), "UTF-8");
		String data7 = " "+URLEncoder.encode(Integer.toString(ManageDB.brightnessMainFloor), "UTF-8");
	//	String data8 = " "+URLEncoder.encode(Integer.toString(ManageDB.controlTempMainFloor), "UTF-8");
	//	String data9 = " "+URLEncoder.encode(Integer.toString(ManageDB.controlTempUpstair), "UTF-8");
		
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
		dataOut.writeBytes(data5);
		dataOut.writeBytes(data6);
		dataOut.writeBytes(data7);
		
		dataOut.flush();
		dataOut.close();
		DataInputStream in = new DataInputStream(conn.getInputStream());
		String g;
		while((g = in.readLine()) != null){
			result += g;
		}
		in.close();
	//	System.out.println(result);
	 */
		ServerSocket listener = new ServerSocket(port);
		listener.setReuseAddress(true);

		while (true) {
				Socket socket = listener.accept();


				String value = ManageDB.cId +" "+time+" "+ManageDB.lightModeUpStair+" "+ManageDB.lightModeMainFloor+" "+Integer.toString(ManageDB.energy_consumed_US)
				+" "+Integer.toString(ManageDB.energy_consumed_MF)+" "+Integer.toString( ManageDB.brightnessUpStair)+" "+Integer.toString(ManageDB.brightnessMainFloor);
				PrintWriter out =
						new PrintWriter(socket.getOutputStream(), true);
				out.println(value);
		//		Thread.sleep(1000);
				out.flush();
				out.close();
	//			socket.close();
	//			listener.close();
			}
			
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		} 


	}

	public static void insertSecData(int port, String time) throws Exception {
	
		/*
		String url = "http://"+ManageDB.ip+"/insertSecurity.php";
		URL urlObj = new URL(url);	
		String result = "";	
		
		String data = "cId=" + URLEncoder.encode(ManageDB.cId, "UTF-8");
		String data1 = " "  +URLEncoder.encode(time, "UTF-8");
		String data2 =  " "+URLEncoder.encode(SecuritySystem.getSecurity_status(), "UTF-8");
		*/
		ServerSocket listener = new ServerSocket(port);
		listener.setReuseAddress(true);

		try {
/*
			HttpURLConnection conn = (HttpURLConnection) urlObj.openConnection();
			conn.setDoInput(true);
			conn.setDoOutput(true);
			conn.setUseCaches(false);
			conn.setRequestMethod("POST");
			DataOutputStream  dataOut = new DataOutputStream(conn.getOutputStream());
			dataOut.writeBytes(data);
			dataOut.writeBytes(data1);
			dataOut.writeBytes(data2);
*/
			while (true) {
				Socket socket = listener.accept();
				//try {
					
					String value = ManageDB.cId +" "+ time+" "+ManageDB.security_system;
					PrintWriter out =
							new PrintWriter(socket.getOutputStream(), true);
					out.println(value);
			//		Thread.sleep(1000);
					out.flush();
					out.close();

//				} 
					
		//			socket.close();
		///			listener.close();
				
			}
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		} 
	}

	public static void insertLockData(int port, String time) throws Exception {
		
		ServerSocket listener = new ServerSocket(port);
		listener.setReuseAddress(true);

		try {

		/*	
			String url = "http://"+ManageDB.ip+"/insertLocks.php";
			URL urlObj = new URL(url);
			String result = "";
			
			String data = "cId=" + URLEncoder.encode(ManageDB.cId, "UTF-8");
			String data1 = " "  +URLEncoder.encode(time, "UTF-8");
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
		//	System.out.println(result);
		*/
			while (true) {
				Socket socket = listener.accept();
		//		try {

				
					String value = ManageDB.cId +" "+ time +" "+ManageDB.f_door_status+" "+ManageDB.b_door_status+" "+ ManageDB.g_door_status;
					PrintWriter out =
							new PrintWriter(socket.getOutputStream(), true);
					out.println(value);
				//	Thread.sleep(1000);
					out.flush();
					out.close();
			//		socket.close();
				} 
				//finally {
					//  out.c
					
				//	listener.close();
			//	}
	//		}
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		} 


	}

	public static void insertDoorData(int port, String time) throws Exception {
	
		ServerSocket listener = new ServerSocket(port);
		listener.setReuseAddress(true);

		try {
/*
			String url = "http://"+ManageDB.ip+"/insertDoorSensors.php";
			URL urlObj = new URL(url);
			String result = "";
			
			String data = "cId=" + URLEncoder.encode(ManageDB.cId, "UTF-8");
			String data1 = " "  +URLEncoder.encode(time, "UTF-8");
			String data2 =  " "+URLEncoder.encode(ManageDB.door_window_sensor_up, "UTF-8");
			String data3 =  " "+URLEncoder.encode(ManageDB.door_window_sensor_main, "UTF-8");
//			String data4 =  " "+URLEncoder.encode(ManageDB.tempEnergyUp, "UTF-8");
//			String data5 =  " "+URLEncoder.encode(ManageDB.tempEnergyMain, "UTF-8");
//			String data6 =  " "+URLEncoder.encode(ManageDB.currentTempUp, "UTF-8");
//			String data7 = " "+URLEncoder.encode(ManageDB.currentTempMain, "UTF-8");
//			String data8 = " "+URLEncoder.encode(Integer.toString(ManageDB.controlTempMainFloor), "UTF-8");
//			String data9 = " "+URLEncoder.encode(Integer.toString(ManageDB.controlTempUpstair), "UTF-8");
//			
//		
			
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
//			dataOut.writeBytes(data4);
//			dataOut.writeBytes(data5);
//			dataOut.writeBytes(data6);
//			dataOut.writeBytes(data7);
//			dataOut.writeBytes(data8);
//			dataOut.writeBytes(data9);
			
			dataOut.flush();
			dataOut.close();
			DataInputStream in = new DataInputStream(conn.getInputStream());
			String g;
			while((g = in.readLine()) != null){
				result += g;
			}
			in.close();
		//	System.out.println(result);
*/			
			
			while (true) {
				Socket socket = listener.accept();
				///try {

					String value = ManageDB.cId +" "+ time +" "+ManageDB.door_window_sensor_up+" "+ManageDB.door_window_sensor_main;
					PrintWriter out =
							new PrintWriter(socket.getOutputStream(), true);
					out.println(value);
				//	Thread.sleep(1000);
					out.flush();
					out.close();

				//} finally {
					//  out.c
		//			socket.close();
		//			listener.close();
			//	}
			}
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		} 


	}
	public static void insertMotionSensorData(int port, String time) throws Exception {
		
		ServerSocket listener = new ServerSocket(port);
		listener.setReuseAddress(true);

		try {
	/*
			String url = "http://"+ManageDB.ip+"/insertmotionSensors.php";
			URL urlObj = new URL(url);
			String result = "";
			
			String data = "cId=" + URLEncoder.encode(ManageDB.cId, "UTF-8");
			String data1 = " "  +URLEncoder.encode(time, "UTF-8");
			String data2 =  " "+URLEncoder.encode(ManageDB.motion_sensor_up, "UTF-8");
			String data3 =  " "+URLEncoder.encode(ManageDB.motion_sensor_main, "UTF-8");
//			String data4 =  " "+URLEncoder.encode(ManageDB.tempEnergyUp, "UTF-8");
//			String data5 =  " "+URLEncoder.encode(ManageDB.tempEnergyMain, "UTF-8");
//			String data6 =  " "+URLEncoder.encode(ManageDB.currentTempUp, "UTF-8");
//			String data7 = " "+URLEncoder.encode(ManageDB.currentTempMain, "UTF-8");
//			String data8 = " "+URLEncoder.encode(Integer.toString(ManageDB.controlTempMainFloor), "UTF-8");
//			String data9 = " "+URLEncoder.encode(Integer.toString(ManageDB.controlTempUpstair), "UTF-8");
//			
//		
			
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
//			dataOut.writeBytes(data4);
//			dataOut.writeBytes(data5);
//			dataOut.writeBytes(data6);
//			dataOut.writeBytes(data7);
//			dataOut.writeBytes(data8);
//			dataOut.writeBytes(data9);
			
			dataOut.flush();
			dataOut.close();
			DataInputStream in = new DataInputStream(conn.getInputStream());
			String g;
			while((g = in.readLine()) != null){
				result += g;
			}
			in.close();
		//	System.out.println(result);
	*/	
			
			while (true) {
				Socket socket = listener.accept();
			//	try {

			    	String value = ManageDB.cId +" "+ time +" "+ManageDB.motion_sensor_up+" "+ManageDB.motion_sensor_main;
					PrintWriter out =
							new PrintWriter(socket.getOutputStream(), true);
					out.println(value);
				//	Thread.sleep(1000);
					out.flush();
					out.close();

		//		} finally {
					//  out.c
				//	socket.close();
				//	listener.close();
	//			}
			}
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		} 


	}
	public static void insertWeatherData(int port, String time) throws Exception {
		
		ServerSocket listener = new ServerSocket(port);
		listener.setReuseAddress(true);

		try {

			while (true) {
				Socket socket = listener.accept();
			//	try {

			    	String value = ManageDB.cId +" "+ time +" "+Integer.toString(Weather.getWeather_temp())+" "+Weather.getWeather_condition();
					PrintWriter out =
							new PrintWriter(socket.getOutputStream(), true);
					out.println(value);
			//		Thread.sleep(1000);
					out.flush();
					out.close();

	//			} finally {
					//  out.c
			//		socket.close();
			//		listener.close();
		//		}
			}
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		} 


	
	}



	public static void insertGarageDoorData(int port, String time) throws Exception {
	
		ServerSocket listener = new ServerSocket(port);
		listener.setReuseAddress(true);
	
		try {
	/*
			String url = "http://"+ManageDB.ip+"/insertgarage.php";
		URL urlObj = new URL(url);
		String result = "";
		
		String data = "cId=" + URLEncoder.encode(ManageDB.cId, "UTF-8");
		String data1 = " "  +URLEncoder.encode(time, "UTF-8");
		String data2 =  " "+URLEncoder.encode(GarrageDoors.getTwodoor_status(), "UTF-8");
		String data3 =  " "+URLEncoder.encode(GarrageDoors.getOnedoor_status(), "UTF-8");
	//	System.out.println("two door insert status:"+ManageDB.twoDoorStatus);
	//	System.out.println("one door insert status:"+ManageDB.oneDoorStatus);
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
	//	System.out.println(result);
*/
					while (true) {
				Socket socket = listener.accept();
		//		try {

			    	String value = ManageDB.cId +" "+ time +" "+ManageDB.twoDoorStatus+" "+ManageDB.oneDoorStatus;
					PrintWriter out =
							new PrintWriter(socket.getOutputStream(), true);
					out.println(value);
		//			Thread.sleep(1000);
					out.flush();
					out.close();

			//	} finally {
					//  out.c
				//	socket.close();
				//	listener.close();
			//	}
			}
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		} 


	
	}

}



