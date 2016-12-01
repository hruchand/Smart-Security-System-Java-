package iot;

public class Nodes {
public static String ip;
public static String role;
public static String sysName;
public static String macAddress;
public Nodes(String ip,  String sysName, String macAddress, String role){
	this.ip = ip;
	//this.role = role;
	this.sysName = sysName;
	this.macAddress = macAddress;
	this.role = role;
}
}
