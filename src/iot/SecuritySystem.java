package iot;

public class SecuritySystem extends RPI1{

	private static String security_status;

	public static String getSecurity_status() {
		return security_status;
	}

	public static void setSecurity_status(String security_status) {
		SecuritySystem.security_status = security_status;
	}
	
	public String SecurityStatus(){
	String status = null;
		if(security_status.equalsIgnoreCase("disarmed")){
			status = "DISARMED";
		}
		if(security_status.equalsIgnoreCase("armed_stay")){
			status = "ARMED_STAY";
		}
		if(security_status.equalsIgnoreCase("armed_away")){
			status = "ARMED_AWAY";
		}
	return status;
	}
	
}
