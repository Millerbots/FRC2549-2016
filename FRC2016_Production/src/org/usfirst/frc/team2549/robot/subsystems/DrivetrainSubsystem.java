package org.usfirst.frc.team2549.robot.subsystems;

import org.usfirst.frc.team2549.robot.RobotMap;
import org.usfirst.frc.team2549.robot.commands.DriveCommand;
import org.usfirst.frc.team2549.robot.util.MaxbotixMB1013;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;

public class DrivetrainSubsystem extends Subsystem {
	
	private SpeedController leftMotor;
	private SpeedController rightMotor;
	public Encoder testEncoder;
	private RobotDrive drive;
	
	public MaxbotixMB1013 leftSonar;
	public MaxbotixMB1013 rightSonar;
	
	public DrivetrainSubsystem(){
		leftMotor = RobotMap.leftDriveMotor.getController();
		rightMotor = RobotMap.rightDriveMotor.getController();
		testEncoder = new Encoder(0,1);
		drive = new RobotDrive(leftMotor, rightMotor);
		
		leftSonar=new MaxbotixMB1013(RobotMap.leftSonarPort);
		rightSonar=new MaxbotixMB1013(RobotMap.rightSonarPort);
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
