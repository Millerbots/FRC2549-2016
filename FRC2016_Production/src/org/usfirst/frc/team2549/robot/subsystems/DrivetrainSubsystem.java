package org.usfirst.frc.team2549.robot.subsystems;

import org.usfirst.frc.team2549.robot.RobotMap;
import org.usfirst.frc.team2549.robot.commands.DriveCommand;
import org.usfirst.frc.team2549.robot.util.IntegratedBuiltinAccelerometer;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.interfaces.Accelerometer.Range;

public class DrivetrainSubsystem extends Subsystem {
	
	private SpeedController leftMotor;
	private SpeedController rightMotor;
	private RobotDrive drive;
	
	public Encoder leftEncoder;
	public Encoder rightEncoder;
	
	public IntegratedBuiltinAccelerometer accelerometer;
	private AnalogGyro driveGyro;
	
	private double offset = 0;
	
	public DrivetrainSubsystem(){
		leftMotor = RobotMap.leftDriveMotor.getController();
		rightMotor = RobotMap.rightDriveMotor.getController();
		drive = new RobotDrive(leftMotor, rightMotor);
		
		accelerometer = new IntegratedBuiltinAccelerometer(Range.k2G);
		
		leftEncoder = new Encoder(RobotMap.leftEncoder[0], RobotMap.leftEncoder[1]);
		rightEncoder = new Encoder(RobotMap.rightEncoder[0], RobotMap.rightEncoder[1]);
		leftEncoder.setReverseDirection(true);
		rightEncoder.setReverseDirection(true);
		
		driveGyro = new AnalogGyro(RobotMap.driveGyroPort);
		driveGyro.reset();
		driveGyro.setSensitivity(0.007);
	}
	
	public double getRawAngle(){
		return driveGyro.getAngle();
	}
	
	public double getAngle(){
		return getRawAngle()-offset;
	}
	
	public double getGyroOffset(){
		return offset;
	}
	
	public void resetGyro(){
		offset=getRawAngle();
	}

	protected void initDefaultCommand() {
		setDefaultCommand(new DriveCommand());
	}

	public void setLeftMotor(double value){
//		SmartDashboard.putDouble("AbsoluteLeftMotorSpeed", value);
		leftMotor.set(value);
	}
	
	public void setRightMotor(double value){
//		SmartDashboard.putDouble("AbsoluteRightMotorSpeed", value);
		rightMotor.set(value);
	}
	
	public void arcadeDrive(double x, double y){
		drive.arcadeDrive(y, x);
	}
	
	public void tankDrive(double left, double right){
		drive.tankDrive(left, right);
	}
}
