package org.usfirst.frc.team2549.robot.util;

import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;

public class MotorDescriptor {

	public static enum SpeedControllerTypes {
		kJaguar,
		kTalon;
	}
	
	public SpeedControllerTypes speedControllerType;
	public int PWMChannel;
	private Boolean allocated=false;
	
	public MotorDescriptor(SpeedControllerTypes type, int indexedPWMChannel){
		this.speedControllerType = type;
		this.PWMChannel = indexedPWMChannel;
	}
	
	public SpeedController getController(){
		if (allocated) return null;
		this.allocated = true;
		switch (this.speedControllerType){
			case kJaguar:
				return new Jaguar(this.PWMChannel);
			case kTalon:
				return new Talon(this.PWMChannel);
			default:
				return null;
		}
	}
}
