package org.usfirst.frc.team2549.robot.subsystems;

import org.usfirst.frc.team2549.robot.RobotMap;
import org.usfirst.frc.team2549.robot.commands.DriveCommand;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;

public class DrivetrainSubsystem extends Subsystem {
	
	private SpeedController leftMotor;
	private SpeedController rightMotor;
	
	public DrivetrainSubsystem(){
		leftMotor = RobotMap.leftDriveMotor.getController();
		rightMotor = RobotMap.rightDriveMotor.getController();
		rightMotor.setInverted(true);
	}

	protected void initDefaultCommand() {
		setDefaultCommand(new DriveCommand());
	}

	public void setLeftMotor(double value){
		leftMotor.set(value);
	}
	
	public void setRightMotor(double value){
		rightMotor.set(value);
	}
	
	public void tankDrive(double left, double right){
		setLeftMotor(left);
		setRightMotor(right);
	}
}
