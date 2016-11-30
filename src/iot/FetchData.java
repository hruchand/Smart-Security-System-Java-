package iot;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class FetchData {
static	String str="null";
	public static void fetchCurTemp(){
		String returnedValue;
		String [] numbersArray;
		
		try {
		//	System.out.println("inside the fetch cur temp");
	
		
returnedValue = Client.fetchValues(3001);

	 numbersArray = returnedValue.split(" ");
//	 System.out.println("first val"+numbersArray[0]);
//	 System.out.println("second val"+numbersArray[1]);
	
//	 ManageDB.cId = numbersArray[0];
//	 ManageDB.curtime = numbersArray[1];
	 ManageDB.curTempUp = numbersArray[0];
	 ManageDB.curTempMain = numbersArray[1];
	 ManageDB.tempModeUp = numbersArray[2];
	 ManageDB.tempModeMain = numbersArray[3];
	 System.out.println(numbersArray[2]);
//	 ManageDB.tempEnergyUp = numbersArray[4];
//	 ManageDB.tempEnergyMain = numbersArray[5];
	
//	ManageDB.controlTempUpstair = Integer.parseInt(numbersArray[8]);
//	ManageDB.controlTempMainFloor = Integer.parseInt(numbersArray[9]);
/*
	System.out.println("current  temp:"+ ManageDB.curTempUp);
	
	String url = "http://10.0.0.2/insertThermostat.php";
	System.out.println("after remote access");
	URL urlObj = new URL(url);
	String result = "";
	
	String data = "cId=" + URLEncoder.encode(ManageDB.cId, "UTF-8");
	System.out.println("after value insert 0");
	String data1 = " "  +URLEncoder.encode(ManageDB.curtime, "UTF-8");
	System.out.println("after value insert 1");
	String data2 =  " "+URLEncoder.encode(ManageDB.tempModeUp, "UTF-8");
	System.out.println("after value insert 2");
	String data3 =  " "+URLEncoder.encode(ManageDB.tempModeMain, "UTF-8");
	System.out.println("after value insert 3");
	String data4 =  " "+URLEncoder.encode(ManageDB.tempEnergyUp, "UTF-8");
	System.out.println("after value insert 4");
	String data5 =  " "+URLEncoder.encode(ManageDB.tempEnergyMain, "UTF-8");
	System.out.println("after value insert 5");
	String data6 =  " "+URLEncoder.encode(ManageDB.curTempUp, "UTF-8");
	System.out.println("after value insert 6");
	String data7 = " "+URLEncoder.encode(ManageDB.curTempMain, "UTF-8");
	System.out.println("after value insert 7");
	String data8 = " "+URLEncoder.encode(Integer.toString(ManageDB.controlTempMainFloor), "UTF-8");
	System.out.println("after value insert 8");
	String data9 = " "+URLEncoder.encode(Integer.toString(ManageDB.controlTempUpstair), "UTF-8");
	System.out.println("after value insert 9");
	

	
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
	System.out.println("final insert");
	System.out.println(result);
	//
	
//	System.out.println("energy up"+ManageDB.tempEnergyUp);
//	System.out.println("energy main"+ManageDB.tempEnergyMain);

/*			while (true) {
		Socket socket = listener.accept();



		String value = ManageDB.cId +" "+ time +" "+ManageDB.tempModeUp+" "+ManageDB.tempModeMain+" "+ManageDB.tempEnergyUp
				+" "+ManageDB.tempEnergyMain+" "+ManageDB.currentTempUp+" "+ManageDB.currentTempMain+" "+Integer.toString(ManageDB.controlTempMainFloor)
				+" "+Integer.toString(ManageDB.controlTempUpstair);
		PrintWriter out =
				new PrintWriter(socket.getOutputStream(), true);
		out.println(value);
		//Thread.sleep(1000);
		out.flush();
		out.close();
		socket.close();
		listener.close();
      
	
insertlocaldata();



        }
        catch (Exception e){
           // Log.d("fetchdata",e.getMessage());

        }
    
    }
	
	
	public static void insertlocaldata() throws Exception {
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd,HH:mm:ss");
		Calendar cal = Calendar.getInstance();
		 String time = dateFormat.format(cal.getTime());
		try {
			
			ManageDB.tempModeUp = ThermostatUpstair.getMode();
			ManageDB.tempModeMain = Thermostat.getMode();
			ManageDB.tempEnergyUp = Integer.toString(ThermostatUpstair.getEnergyConsumed()) ;
			ManageDB.tempEnergyMain = Integer.toString(Thermostat.getEnergyConsumed()) ;
			ManageDB.currentTempUp =Integer.toString(ThermostatUpstair.getCurrentTemperature());
			ManageDB.currentTempMain = Integer.toString(Thermostat.getCurrentTemperature());
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

/*			while (true) {
				Socket socket = listener.accept();



				String value = ManageDB.cId +" "+ time +" "+ManageDB.tempModeUp+" "+ManageDB.tempModeMain+" "+ManageDB.tempEnergyUp
						+" "+ManageDB.tempEnergyMain+" "+ManageDB.currentTempUp+" "+ManageDB.currentTempMain+" "+Integer.toString(ManageDB.controlTempMainFloor)
						+" "+Integer.toString(ManageDB.controlTempUpstair);
				PrintWriter out =
						new PrintWriter(socket.getOutputStream(), true);
				out.println(value);
				//Thread.sleep(1000);
				out.flush();
				out.close();
				socket.close();
				listener.close();

			}
			*/
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		} 


	}
	
	
	public static void fetchlightData() {
        try {

        	String returnedValue = Client.fetchValues(3002);
        	String [] numbersArray = returnedValue.split(" ");
        	
        	//String [] numbersArray = returnedValue.split(" ");
      //  	System.out.println("first  brighness val"+numbersArray[0]);
      //  	System.out.println("second brightness val"+numbersArray[1]);
      //  	System.out.println("light mode up"+numbersArray[2]);
      //  	System.out.println("light mode main"+numbersArray[3]);
//            int temp_curr;
//            String cId = "1";
//            String url = "http://"+ManageDB.ip+"/fetchLightmode.php";
//            URL urlObj = new URL(url);
//            String result = "";
//            String data = "cId=" + java.net.URLEncoder.encode(cId, "UTF-8");
//            //1
//            HttpURLConnection conn = (HttpURLConnection) urlObj.openConnection();
//            conn.setDoInput(true);
//            conn.setDoOutput(true);
//            conn.setUseCaches(false);
//            conn.setRequestMethod("POST");
//            //2
//            DataOutputStream dataOut = new DataOutputStream(conn.getOutputStream());
//            dataOut.writeBytes(data);
//            //3
//            dataOut.flush();
//            dataOut.close();
//            DataInputStream in = new DataInputStream(conn.getInputStream());
//
//            String g;
//            while ((g = in.readLine()) != null) {
//
//                result += g;
//
//            }
//            
//
//            in.close();
        
      //      String[] numbersArray = result.split(" ");
           LightUpstair.setBrightness(Integer.parseInt(numbersArray[0]));
           LightMainFloor.setBrightness(Integer.parseInt(numbersArray[1]));
           System.out.println(numbersArray[0]);
           //ManageDB.lightModeMainFloor        = numbersArray[1];
LightUpstair.setLightStatus(numbersArray[2])  ;
LightMainFloor.setLightStatus(numbersArray[3]);
//System.out.println("Inside Fetch Light , light status"+LightMainFloor.getLightStatus());
        } catch (Exception e) {

        }

     

    }
	
	public static void fetchSecurityData() {
        try {

        	String returnedValue = Client.fetchValues(3003);
            SecuritySystem.setSecurity_status(returnedValue);
        } catch (Exception e) {

        }

     

    }
	public static void fetchLockData() {
        try {

        	String returnedValue = Client.fetchValues(3004);
        	String [] numbersArray = returnedValue.split(" ");
      Locks.setFront_door_status(numbersArray[0]);
        	Locks.setBack_door_status(numbersArray[1]);
        	Locks.setGarage_door_status(numbersArray[2]);
        } catch (Exception e) {

        }

     

    }
	public static void fetchDoorSensorData() {
        try {

        	String returnedValue = Client.fetchValues(3005);
        	String [] numbersArray = returnedValue.split(" ");
      
      Door_Window_SensorsUp.setSensor_status(numbersArray[0]);
      Door_Window_SensorsMain.setSensor_status(numbersArray[1]);
        	
        } catch (Exception e) {

        }
}
	
	public static void fetchMotionSensorData() {
        try {

        	String returnedValue = Client.fetchValues(3006);
        	String [] numbersArray = returnedValue.split(" ");
      
      MotionDetectorUp.setMotion_detector_status(numbersArray[1]);
     MotionDetectorMain.setMotion_detector_status(numbersArray[0]);
        	
        } catch (Exception e) {
          e.printStackTrace();
        }
}
	
	public static void fetchWeatherData() {
        try {

        	String returnedValue = Client.fetchValues(3007);
        	String [] numbersArray = returnedValue.split(" ");
      Weather.setWeather_temp(Integer.parseInt(numbersArray[0]));
      Weather.setWeather_condition(numbersArray[1]);     	
        } catch (Exception e) {
          e.printStackTrace();
        }
	}
	 
	public static void fetchGarageDoorStatus() {
        try {

        	String returnedValue = Client.fetchValues(3008);
        	String [] numbersArray = returnedValue.split(" ");
            ManageDB.twoDoorStatus = numbersArray[0];
            ManageDB.oneDoorStatus = numbersArray[1]; 
 //    System.out.println("two door fetch stat"+ManageDB.twoDoorStatus);
  //   System.out.println("two door fetch stat"+ManageDB.oneDoorStatus);
        } catch (Exception e) {
          e.printStackTrace();
        }
	}
}
