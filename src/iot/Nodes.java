package iot;

public class Nodes {
 String ip;
 String role;
 String sysName;
 String macAddress;
public Nodes(String ip,  String sysName, String macAddress, String role){
	this.ip = ip;
	//this.role = role;
	this.sysName = sysName;
	this.macAddress = macAddress;
	this.role = role;
}
}
