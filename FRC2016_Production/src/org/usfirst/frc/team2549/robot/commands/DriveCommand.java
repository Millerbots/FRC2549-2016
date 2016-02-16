package org.usfirst.frc.team2549.robot.commands;

import org.usfirst.frc.team2549.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DriveCommand extends Command {
	
	public DriveCommand(){
		requires(Robot.drivetrainSubsystem);
	}

	protected void initialize() {
		Robot.drivetrainSubsystem.accelerometer.initSampling();
	}

	protected void execute() {
		Robot.drivetrainSubsystem.accelerometer.sample();
		Robot.drivetrainSubsystem.tankDrive(Robot.oi.joystick1.getY(),
				Robot.oi.joystick2.getY());
		
		if (Robot.oi.joystick1.getRawButton(7) || Robot.oi.joystick2.getRawButton(7)){
			Robot.drivetrainSubsystem.leftEncoder.reset();
			Robot.drivetrainSubsystem.rightEncoder.reset();
			Robot.drivetrainSubsystem.accelerometer.reset();
			Robot.drivetrainSubsystem.resetGyro();
		}
		
		SmartDashboard.putNumber("leftEncoderDistance", Robot.drivetrainSubsystem.leftEncoder.getDistance());
		SmartDashboard.putNumber("leftEncoderRate", Robot.drivetrainSubsystem.leftEncoder.getRate());
		
		SmartDashboard.putNumber("rightEncoderDistance", Robot.drivetrainSubsystem.rightEncoder.getDistance());
		SmartDashboard.putNumber("rightEncoderRate", Robot.drivetrainSubsystem.rightEncoder.getRate());
		
		SmartDashboard.putNumber("offsetAvgAccelY", Robot.drivetrainSubsystem.accelerometer.getOffsetAvgY());
		SmartDashboard.putNumber("velocityY_", Robot.drivetrainSubsystem.accelerometer.getVelocityY());
		SmartDashboard.putNumber("positionY_", Robot.drivetrainSubsystem.accelerometer.getPositionY());
		
		SmartDashboard.putNumber("driveAngle", Robot.drivetrainSubsystem.getAngle());
	}

	protected boolean isFinished() {return false;}

	protected void end() {}
	
	protected void interrupted() {}
}
