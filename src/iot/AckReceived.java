package iot;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

//import iot.ManageDB;

public class AckReceived implements Runnable{
static	Boolean status =false;
	Thread thread = new Thread(this);
	static	String str = null;
	public AckReceived(){
		thread.start();
	}
	public void run(){
			
		try{
			BufferedReader in = null;
			//String ack = "received";
	
			ServerSocket listener = new ServerSocket(6603);
			listener.setReuseAddress(true);
			while (true) {
		
				Socket socket = listener.accept();


in = new BufferedReader(
		new InputStreamReader(socket.getInputStream()));
str = in.readLine();
if(str.equalsIgnoreCase("null")){
	//	System.out.println("hello");
	}
	else{
	String ipaddress = str;
	System.out.println("received ack is:-"+ipaddress);
	//status = true;
	socket.close();
listener.close();
break;
	//Thread.sleep(5000);
//	Socket clientSocket = new Socket("10.0.0.3", 6112);
//	//	
//		//PrintWriter out =
//		//		new PrintWriter(clientSocket.getOutputStream(), true);
//	//	out.println(ManageDB.raspberryPiIp);
//		
//	PrintWriter out =	new PrintWriter(clientSocket.getOutputStream(), true);
//	
//	out.println(ack);
//	out.flush();
//
//	out.close();
//	clientSocket.close();
//	
//		break;
	}
//out.println(ack);
//				Thread.sleep(1000);
//				
				}
			
			}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	//	}
	}
}
