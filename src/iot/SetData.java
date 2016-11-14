package iot;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;

public class SetData {
public static void setMainfloorTemp(int port) throws Exception{
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
          
              

                 String value = ManageDB.cId +" "+Thermostat.getCurrentTemperature();
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

public static void setThermDataup (int port) throws Exception{

	  try{
	     	 Thread.sleep(5000);
	     }
	     catch (Exception e) {
//				// TODO: handle exception
			}
			ServerSocket listener = new ServerSocket(port);
			listener.setReuseAddress(true);
			
	     try {
	      
	     	while (true) {
	             Socket socket = listener.accept();
	          
	              

	                 String value = ManageDB.cId +" "+ThermostatUpstair.getCurrentTemperature();
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
}

