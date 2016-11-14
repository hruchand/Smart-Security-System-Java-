package iot;

public class Weather extends RPI1{
private static int weather_temp= 70;
private static String weather_condition = "RAINY";
public static int getWeather_temp() {
	return weather_temp;
}

public static void setWeather_temp(int weather_temp) {
	Weather.weather_temp = weather_temp;
}

public static String getWeather_condition() {
	return weather_condition;
}

public static void setWeather_condition(String weather_condition) {
	Weather.weather_condition = weather_condition;
}




}
