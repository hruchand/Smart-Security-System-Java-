package iot;

public class FetchSimulationThread implements Runnable{
	Thread thread = new Thread(this);
	public FetchSimulationThread(){
		thread.start();
	}
	
	public void run(){
	try{
		while(true){
			//FetchData.fetchCurTemp();
			FetchData.fetchlightData();
		//	System.out.println("Inside Thread, light status"+LightMainFloor.getLightStatus());
			Thread.sleep(2000);
		}
	}
	catch (Exception e) {
		System.out.println(e.getMessage());
	}
	}
}
