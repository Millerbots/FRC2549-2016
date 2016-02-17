package org.usfirst.frc.team2549.robot.commands.auto;

import org.usfirst.frc.team2549.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class OrientCommand extends Command {
	
	double targetAngle;
	double[] correctSpeed = {0.9, -0.9};
	double[] slowCorrectSpeed = {0.6, -0.6};
	double fudgeZone = 6;
	boolean reset = false;
	int timer = 0;
	
	public OrientCommand(double angle){
		requires(Robot.drivetrainSubsystem);
		targetAngle=angle;
	}
	
	public OrientCommand(double angle, boolean reset){
		this(angle);
		this.reset=reset;
	}
	
	public OrientCommand(double[] correctSpeed, double fudgeZone, double angle, boolean reset){
		this(angle, reset);
		this.fudgeZone=fudgeZone;
		this.correctSpeed=correctSpeed;
	}

	protected void initialize() {
		if (reset){
			Robot.drivetrainSubsystem.resetGyro();
		}
	}

	protected void execute() {
		if(timer==0){
			if((Robot.drivetrainSubsystem.getAngle()-targetAngle)<0){
				Robot.drivetrainSubsystem.tankDrive(correctSpeed[0], correctSpeed[1]);
			}else{
				Robot.drivetrainSubsystem.tankDrive(correctSpeed[1], correctSpeed[0]);
			}
		}else{
			if((Robot.drivetrainSubsystem.getAngle()-targetAngle)<0){
				Robot.drivetrainSubsystem.tankDrive(slowCorrectSpeed[0], slowCorrectSpeed[1]);
			}else{
				Robot.drivetrainSubsystem.tankDrive(slowCorrectSpeed[1], slowCorrectSpeed[0]);
			}
		}
	}

	@Override
	protected boolean isFinished() {
		if (Math.abs(Robot.drivetrainSubsystem.getAngle()-targetAngle)<=fudgeZone){
			timer++;
		}else{
			timer=0;
		}
		return timer>50;
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
