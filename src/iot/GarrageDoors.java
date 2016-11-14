package iot;

public class GarrageDoors extends RPI1{
private static String Twodoor_status;
private static String Onedoor_status;



public static String getOnedoor_status() {
	return Onedoor_status;
}



public static void setOnedoor_status(String onedoor_status) {
	Onedoor_status = onedoor_status;
}



public static String getTwodoor_status() {
	return Twodoor_status;
}



public static void setTwodoor_status(String twodoor_status) {
	Twodoor_status = twodoor_status;
}



public String Two_Door(){
	String status = null;
	if(Twodoor_status.equalsIgnoreCase("open")){
		status = "2-car door is open";
	}
	else{
		status = "2-car door is closed";
	}
 return status;	
}

public String One_Door(){
	String status = null;
	if(Onedoor_status.equalsIgnoreCase("open")){
		status = "1-car door is open";
	}
	else{
		status = "1-car door is closed";
	}
 return status;	
}
}
