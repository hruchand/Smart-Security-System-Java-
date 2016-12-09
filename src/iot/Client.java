package iot;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
static	String str = null;
	public static String fetchValues(int port)
	{
//	System.out.println("ip is:"+ManageDB.ip);
//	System.out.println("ip is:"+port);
	//	String ServerIP = ManageDB.ip;
		int ServerPort = port;		   	
//	System.out.println("port number"+port);
		BufferedReader in = null;
		PrintWriter out = null;
		try{
			Thread.sleep(1000);
		//	System.out.println("before connecting");
		//	System.out.println("ip is:-"+ServerIP);
//		System.out.println("before");
		//	Socket clientSocket = new Socket(ManageDB.serverIp,ServerPort);
			Socket clientSocket = new Socket(ManageDB.ip,ServerPort);
//			System.out.println("after");
		//	System.out.println("socket created"+clientSocket.getLocalPort());

			in = new BufferedReader(
					new InputStreamReader(clientSocket.getInputStream()));
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
			//in.reset();
			in.close();
			
			clientSocket.close();

		}catch(Exception e){
			//e.printStackTrace();
			System.out.println(e.getMessage());
		}
//		System.out.println("str is");
	return str;
	}
}
