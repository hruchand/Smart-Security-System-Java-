package iot;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class WriteAck implements Runnable{
	Thread thread = new Thread(this);
	static	String str = null;
	public WriteAck(){
		thread.start();
	}
	public void run(){
	
			
		try{
		//	BufferedReader in = null;
		//	Thread.sleep(10000);
		while(true){
			//if(ListenThread.status.equals("true"))
			//{
				//System.out.println("Inside if");
	//		System.out.println(ListenThread.numbersArray[0]);
				Socket clientSocket = new Socket("10.0.0.2", 6603);
		        String ack = "ipReceived";
				//	
				PrintWriter out =
						new PrintWriter(clientSocket.getOutputStream(), true);
				out.println(ack);
				
				out.flush();
				out.close();
				clientSocket.close();
				break;
			//}
		}
	/*
			ServerSocket listener = new ServerSocket(6112);
			listener.setReuseAddress(true);
			while (true) {
				//		System.out.println("before accept");
						Socket socket = listener.accept();
						in = new BufferedReader(
								new InputStreamReader(socket.getInputStream()));
						str = in.readLine();
						if(str.equalsIgnoreCase("null")){
							//	System.out.println("hello");
							}
						else{
						System.out.println("\n"+str);
					//	socket.close();	
						break;
						}
			
			}
			
		*/	
	/*
			str=in.readLine();	
			while(true)
			{
				if(str.equalsIgnoreCase("null")){
				//	System.out.println("hello");
				}
				else{
					break;
				}
			}
			*/
		/*
			ServerSocket listener = new ServerSocket(6000);
			listener.setReuseAddress(true);
			while (true) {
				Socket socket = listener.accept();

String ack = "received";

		//		String value = ManageDB.cId +" "+ time +" "+ManageDB.tempModeUp+" "+ManageDB.tempModeMain+" "+ManageDB.tempEnergyUp
		//				+" "+ManageDB.tempEnergyMain+" "+ManageDB.currentTempUp+" "+ManageDB.currentTempMain+" "+Integer.toString(ManageDB.controlTempMainFloor)
		//				+" "+Integer.toString(ManageDB.controlTempUpstair);
				PrintWriter out =
						new PrintWriter(socket.getOutputStream(), true);
				out.println(ack);
				Thread.sleep(1000);
				out.flush();
				out.close();
				}
			*/
			}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	//	}
	}
}
