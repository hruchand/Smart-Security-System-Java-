package iot;

public class MotionDetectorMain extends RPI1{

	private static String motion_detector_status;

	public static String getMotion_detector_status() {
		return motion_detector_status;
	}

	public static void setMotion_detector_status(String motion_detector_status) {
		MotionDetectorMain.motion_detector_status = motion_detector_status;
	}
	
	public String MotionDetectorStatus(){
		String status = null;
		if(motion_detector_status.equalsIgnoreCase("active")){
			status = "ACTIVE";
		}
		else{
			status = "INACTIVE";
		}
		return status;
	}
}
