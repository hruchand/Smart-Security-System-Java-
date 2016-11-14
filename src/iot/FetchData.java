package iot;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class FetchData {
static	String str="null";
	public static void fetchCurTemp(){
		String returnedValue;
		String [] numbersArray;
		
		try {
			System.out.println("inside the fetch cur temp");
	
		
returnedValue = Client.fetchValues(3001);

	 numbersArray = returnedValue.split(" ");
//	 System.out.println("first val"+numbersArray[0]);
//	 System.out.println("second val"+numbersArray[1]);
	  ManageDB.curTempMain = numbersArray[1];
      ManageDB.curTempUp = numbersArray[0];
    
 

	



//System.out.println("socket returned value \n");
//System.out.println(returnedValue);
//            int temp_curr;
//            String cId = "1";
//            String url = "http://"+ManageDB.ip+"/fetchTher.php";
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
//            while((g = in.readLine()) != null){
//
//                result += g;
//
//            }
//           System.out.println("inside thermostat fetch data");
//
//            in.close();
//           
//            String[] numbersArray = result.split(" ");
          
//
//
//
//
        }
        catch (Exception e){
           // Log.d("fetchdata",e.getMessage());

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
           //ManageDB.lightModeMainFloor        = numbersArray[1];
LightUpstair.setLightStatus(numbersArray[2])  ;
LightMainFloor.setLightStatus(numbersArray[3]);

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
      
      MotionDetectorUp.setMotion_detector_status(numbersArray[0]);
     MotionDetectorMain.setMotion_detector_status(numbersArray[1]);
        	
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
        } catch (Exception e) {
          e.printStackTrace();
        }
	}
}
