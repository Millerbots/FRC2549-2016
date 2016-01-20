package org.usfirst.frc.team2549.robot.commands;

import org.usfirst.frc.team2549.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class DriveCommand extends Command {
	
	public DriveCommand(){
		requires(Robot.drivetrainSubsystem);
	}

	protected void initialize() {}

	protected void execute() {
		Robot.drivetrainSubsystem.tankDrive(Robot.oi.driveSticks.getLeftValue(),
				Robot.oi.driveSticks.getRightValue());
	}

	protected boolean isFinished() {return false;}

	protected void end() {}
	
	protected void interrupted() {}
}
