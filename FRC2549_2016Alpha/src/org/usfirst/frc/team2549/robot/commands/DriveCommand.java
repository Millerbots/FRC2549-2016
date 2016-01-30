package org.usfirst.frc.team2549.robot.commands;

import org.usfirst.frc.team2549.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DriveCommand extends Command {
	
	public DriveCommand(){
		requires(Robot.drivetrainSubsystem);
	}

	protected void initialize() {}

	protected void execute() {
//		Robot.drivetrainSubsystem.tankDrive(-Robot.oi.driveSticks.getLeftValue(),
//				Robot.oi.driveSticks.getLeftValue());
//		SmartDashboard.putDouble("LeftStickY", Robot.oi.driveSticks.getLeftValue());
//		SmartDashboard.putDouble("RightStickY", Robot.oi.driveSticks.getRightValue());
		
		SmartDashboard.putDouble("Encoder_Distance", Robot.drivetrainSubsystem.testEncoder.getDistance());
		SmartDashboard.putBoolean("Encoder_Direction", Robot.drivetrainSubsystem.testEncoder.getDirection());
		SmartDashboard.putDouble("Encoder_Rate", Robot.drivetrainSubsystem.testEncoder.getRate());
		SmartDashboard.putDouble("Encoder_Raw", Robot.drivetrainSubsystem.testEncoder.getRaw());
	}

	protected boolean isFinished() {return false;}

	protected void end() {}
	
	protected void interrupted() {}
}
