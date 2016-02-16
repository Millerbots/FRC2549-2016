package org.usfirst.frc.team2549.robot.commands.auto;

import org.usfirst.frc.team2549.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class AbsoluteOrientCommand extends Command {
	
	double targetAngle;
	double[] correctSpeed = {0.8, -0.8};
	double fudgeZone = 2;
	
	public AbsoluteOrientCommand(double angle){
		requires(Robot.drivetrainSubsystem);
		targetAngle=angle;
	}
	
	public AbsoluteOrientCommand(double[] correctSpeed, double fudgeZone, double angle){
		this(angle);
		this.fudgeZone=fudgeZone;
		this.correctSpeed=correctSpeed;
	}

	protected void initialize() {}

	protected void execute() {
		if((Robot.drivetrainSubsystem.getAngle()-targetAngle)<0){
			Robot.drivetrainSubsystem.tankDrive(correctSpeed[0], correctSpeed[1]);
		}else{
			Robot.drivetrainSubsystem.tankDrive(correctSpeed[1], correctSpeed[0]);
		}
	}

	@Override
	protected boolean isFinished() {
		return Math.abs(Robot.drivetrainSubsystem.getAngle()-targetAngle)<=fudgeZone;
	}

	@Override
	protected void end() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub
		
	}

}
