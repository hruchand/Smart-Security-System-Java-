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
	

		System.out.println("<--Pi4J--> GPIO Listen Example ... started.");

        // create gpio controller
        final GpioController gpio = GpioFactory.getInstance();

        // provision gpio pin #02 as an input pin with its internal pull down resistor enabled
        System.out.println("before final");
        final GpioPinDigitalInput myButton = gpio.provisionDigitalInputPin(RaspiPin.GPIO_06, PinPullResistance.PULL_DOWN);
       // final GpioPinDigitalOutput outputPin = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_01);
        final GpioPinDigitalOutput outputPin = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_01, "MyLED", PinState.LOW);
        final GpioPinDigitalOutput outputPin1 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_00, "MyLED1", PinState.LOW);
        final GpioPinDigitalOutput outputPin2 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_02, "MyLED2", PinState.LOW);
        PinState high = PinState.HIGH;
        PinState low = PinState.LOW;
      //  PinState toggle = PinState.t
        
        
        
        outputPin.setShutdownOptions(true, low);
        outputPin1.setShutdownOptions(true, low);
        outputPin2.setShutdownOptions(true, low);
        
        System.out.println("after final");
        System.out.println(LightMainFloor.getLightStatus());
        
      //  outputPin.high();
 //       outputPin.setState(high);
      //  outputPin.toggle();
        
        System.out.println("Initial high state of the pin:-" +outputPin.getState());
    //Thread.sleep(1000);    
       while(true)
       {
        if(LightMainFloor.getLightStatus().equalsIgnoreCase("on"))
        {
     //   System.out.println("inside light mode on"); 
      //  outputPin.low();
        outputPin.setState(high);
       // outputPin.toggle();
        }
        else
        {
       // System.out.println("inside  light mode off");
        //outputPin.low();
        outputPin.setState(low);
       }
        if(Locks.getFront_door_status().equalsIgnoreCase("Locked"))
        {
   //   System.out.println("lock  status on");
        	outputPin1.setState(high);	
        }
        else
        {
     //   	System.out.println("lock  status off");
        	outputPin1.setState(low);	 	
        }
        
        if(MotionDetectorMain.getMotion_detector_status().equalsIgnoreCase("Active"))
        {
        outputPin2.setState(high);	
        }
        else
        {
        	  outputPin2.setState(low);	 	
        }
        
        
       } 
  // System.out.println("final state of the pin:-" +outputPin.getState());
        // set shutdown state for this input pin
//        myButton.setShutdownOptions(true);
//
//        // create and register gpio pin listener
//        myButton.addListener(new GpioPinListenerDigital() {
//            @Override
//            public void handleGpioPinDigitalStateChangeEvent(GpioPinDigitalStateChangeEvent event) {
//                // display pin state on console
//                System.out.println(" --> GPIO PIN STATE CHANGE: " + event.getPin() + " = " + event.getState());
//            }
//
//        });

  //      System.out.println(" ... complete the GPIO #02 circuit and see the listener feedback here in the console.");

        // keep program running until user aborts (CTRL-C)
//        while(true) {
//            Thread.sleep(500);
//        }

        // stop all GPIO activity/threads by shutting down the GPIO controller
        // (this method will forcefully shutdown all GPIO monitoring threads and scheduled tasks)
        // gpio.shutdown();   <--- implement this method call if you wish to terminate the Pi4J GPIO controller
	}
	catch (Exception e) {
		System.out.println(e.getMessage());
	}
	}
}