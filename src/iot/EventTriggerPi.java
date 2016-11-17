package iot;
import com.pi4j.io.gpio.*;
import com.pi4j.io.gpio.event.GpioPinDigitalStateChangeEvent;
import com.pi4j.io.gpio.event.GpioPinListenerDigital;

public class EventTriggerPi implements Runnable{
	
	Thread thread = new Thread(this);
	public EventTriggerPi(){
		thread.start();
	}

	public  void run()  {
try{
	

	//	System.out.println("<--Pi4J--> GPIO Listen Example ... started.");

        // create gpio controller
        final GpioController gpio = GpioFactory.getInstance();

        // provision gpio pin #02 as an input pin with its internal pull down resistor enabled
      //  System.out.println("before final");
        //final GpioPinDigitalInput myButton = gpio.provisionDigitalInputPin(RaspiPin.GPIO_06, PinPullResistance.PULL_DOWN);
       // final GpioPinDigitalOutput outputPin = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_01);
        final GpioPinDigitalOutput outputPin = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_01, "MyLED", PinState.LOW);
        final GpioPinDigitalOutput outputPin1 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_00, "MyLED1", PinState.LOW);
        final GpioPinDigitalOutput outputPin2 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_02, "MyLED2", PinState.LOW);
       
        final GpioPinDigitalOutput outputPin3 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_03, "MyLED3", PinState.LOW);
        final GpioPinDigitalOutput outputPin4 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_12, "MyLED4", PinState.LOW);
        final GpioPinDigitalOutput outputPin5 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_13, "MyLED5", PinState.LOW);
        final GpioPinDigitalOutput outputPin6 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_14, "MyLED6", PinState.LOW);
        
        PinState high = PinState.HIGH;
        PinState low = PinState.LOW;   
        
        
        
        outputPin.setShutdownOptions(true, low);
        outputPin1.setShutdownOptions(true, low);
        outputPin2.setShutdownOptions(true, low);
        outputPin3.setShutdownOptions(true, low);
        outputPin4.setShutdownOptions(true, low);
        outputPin5.setShutdownOptions(true, low);
        outputPin6.setShutdownOptions(true, low);
        
           
   //Thread.sleep(1000);    
       while(true)
       {
    	   Thread.sleep(5000);
    	   
    	   FetchData.fetchlightData();
    	   FetchData.fetchLockData();
    	   FetchData.fetchMotionSensorData();
    	   FetchData.fetchSecurityData();
    	   FetchData.fetchGarageDoorStatus();
    	   FetchData.fetchCurTemp();
    	   FetchData.fetchDoorSensorData();
    	   
       if(LightMainFloor.getLightStatus().equalsIgnoreCase("on"))
        {
        outputPin.setState(high);
        }
        else
        {
        outputPin.setState(low);
        }
       
        if(Locks.getFront_door_status().equalsIgnoreCase("Locked"))
        {
          //  System.out.println("lock  status on");
        	outputPin1.setState(high);	
        }
        else
        {
        //	System.out.println("lock  status off");
        	outputPin1.setState(low);	 	
        }
       
      //  System.out.println("Motion Detector Status" + MotionDetectorMain.getMotion_detector_status());
        if(MotionDetectorMain.getMotion_detector_status().equalsIgnoreCase("Active"))
        {
     //   System.out.println("Motion  status on");
        outputPin2.setState(high);	
        }
        else
        {
    //    	System.out.println("Motion  status off");
        	  outputPin2.setState(low);	 	
        }
        
        if(SecuritySystem.getSecurity_status().equalsIgnoreCase("armed_stay"))
        {
          outputPin3.setState(high);
        }
        else if (SecuritySystem.getSecurity_status().equalsIgnoreCase("armed_away"))
        {
        for(int i = 0 ; i < 5 ; i++){
          Thread.sleep(1000);
          outputPin3.toggle();
        }
        }
        else
        {
         outputPin3.setState(low);	
        }
        
        if(ManageDB.twoDoorStatus.equalsIgnoreCase("locked"))
        {
        	outputPin4.setState(high);	
        }
        else
        {
        	outputPin4.setState(low);	 	
        }
        
        if(ManageDB.tempModeMain.equalsIgnoreCase("heat"))
        {
        outputPin5.setState(high);
        }
        else
        {
        outputPin5.setState(low);
        }
        
        if(Door_Window_SensorsMain.getSensor_status().equalsIgnoreCase("on"))
        {
        outputPin6.setState(high);
        }
        else
        {
        outputPin6.setState(low);
        }
        }
       
}
	catch (Exception e) {
		System.out.println(e.getMessage());
	}
	}
}