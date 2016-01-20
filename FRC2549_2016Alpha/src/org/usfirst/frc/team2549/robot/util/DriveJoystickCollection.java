package org.usfirst.frc.team2549.robot.util;

import edu.wpi.first.wpilibj.Joystick;

public class DriveJoystickCollection {
	private Joystick joystick1;
	private Joystick joystick2;
	public DriveJoystickCollection(Joystick stick1, Joystick stick2){
		this.joystick1=stick1;
		this.joystick2=stick2;
	}
	
	public double getLeftValue(){
		return this.joystick1.getY();
	}
	
	public double getRightValue(){
		return this.joystick2.getY();
	}
}
