package org.usfirst.frc.team2549.robot.subsystems;

import org.usfirst.frc.team2549.robot.RobotMap;
import org.usfirst.frc.team2549.robot.commands.DriveCommand;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DrivetrainSubsystem extends Subsystem {
	
	private SpeedController leftMotor;
	private SpeedController rightMotor;
	public Encoder testEncoder;
	
	public DrivetrainSubsystem(){
		leftMotor = RobotMap.leftDriveMotor.getController();
		rightMotor = RobotMap.rightDriveMotor.getController();
		testEncoder = new Encoder(0,1);
		rightMotor.setInverted(true);
	}

	protected void initDefaultCommand() {
		setDefaultCommand(new DriveCommand());
	}

	public void setLeftMotor(double value){
		SmartDashboard.putDouble("AbsoluteLeftMotorSpeed", value);
		leftMotor.set(value);
	}
	
	public void setRightMotor(double value){
		SmartDashboard.putDouble("AbsoluteRightMotorSpeed", value);
		rightMotor.set(value);
	}
	
	public void tankDrive(double left, double right){
		setLeftMotor(left);
		setRightMotor(right);
	}
}
