
package org.usfirst.frc.team2549.robot.subsystems;

import org.usfirst.frc.team2549.robot.RobotMap;
import org.usfirst.frc.team2549.robot.commands.ExampleCommand;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class ExampleSubsystem extends Subsystem {
	
	SpeedController leftMotor;
	SpeedController rightMotor;
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	public ExampleSubsystem(){
		leftMotor = new Talon(RobotMap.leftMotor);
		rightMotor = new Talon(RobotMap.rightMotor);
	}

    public void initDefaultCommand() {
        setDefaultCommand(new ExampleCommand());
    }
    
    public void setLeftMotor(double speed){
    	leftMotor.set(speed);
    }
    
    public void setRightMotor(double speed){
    	rightMotor.set(speed);
    }
}

