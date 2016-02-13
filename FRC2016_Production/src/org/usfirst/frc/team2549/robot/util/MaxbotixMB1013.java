package org.usfirst.frc.team2549.robot.util;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.SensorBase;

public class MaxbotixMB1013 extends SensorBase {
	private int port;
	private AnalogInput ain;
	public MaxbotixMB1013(int AINPort){
		port=AINPort;
		ain=new AnalogInput(port);
	}
	
	public double getVoltage(){
		return ain.getVoltage();
	}
	
	public double getValue(){
		return ain.getValue();
	}
}
