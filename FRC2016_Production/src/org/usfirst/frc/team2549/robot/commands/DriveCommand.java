package org.usfirst.frc.team2549.robot.commands;

import org.usfirst.frc.team2549.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DriveCommand extends Command {
	
	public DriveCommand(){
		requires(Robot.drivetrainSubsystem);
	}

	protected void initialize() {}

	@SuppressWarnings("deprecation")
	protected void execute() {
		Robot.drivetrainSubsystem.tankDrive(Robot.oi.joystick1.getY(),
				Robot.oi.joystick2.getY());
		
//		SmartDashboard.putDouble("Encoder_Distance", Robot.drivetrainSubsystem.testEncoder.getDistance());
//		SmartDashboard.putBoolean("Encoder_Direction", Robot.drivetrainSubsystem.testEncoder.getDirection());
//		SmartDashboard.putDouble("Encoder_Rate", Robot.drivetrainSubsystem.testEncoder.getRate());
//		SmartDashboard.putDouble("Encoder_Raw", Robot.drivetrainSubsystem.testEncoder.getRaw());
		
		SmartDashboard.putDouble("leftSonarValue", Robot.drivetrainSubsystem.leftSonar.getVoltage());
		SmartDashboard.putDouble("rightSonarValue", Robot.drivetrainSubsystem.rightSonar.getVoltage());
		SmartDashboard.putDouble("leftSonarRaw", Robot.drivetrainSubsystem.leftSonar.getValue());
		SmartDashboard.putDouble("rightSonarRaw", Robot.drivetrainSubsystem.rightSonar.getValue());
	}

	protected boolean isFinished() {return false;}

	protected void end() {}
	
	protected void interrupted() {}
}
