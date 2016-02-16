package org.usfirst.frc.team2549.robot.commands.auto;

import org.usfirst.frc.team2549.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;


public class DriveDistanceCommand extends Command {
	double[] speed = {0.6, 0.6};
	double[] correctSpeed = {0.6, 0.4};
	double[] targetDistance;
	
	public DriveDistanceCommand(double[] distance){
		targetDistance=distance;
	}
	
	public DriveDistanceCommand(double[] speed, double[] correctSpeed, double[] distance){
		this(distance);
		this.speed=speed;
		this.correctSpeed=correctSpeed;
	}
	
	public DriveDistanceCommand(int i, int j) {
		double[] temp = {i, j};
		this.targetDistance = temp;
	}

	protected void initialize() {
		Robot.drivetrainSubsystem.leftEncoder.reset();
		Robot.drivetrainSubsystem.rightEncoder.reset();
	}

	protected void execute() {
		if ((Robot.drivetrainSubsystem.leftEncoder.getDistance()-Robot.drivetrainSubsystem.rightEncoder.getDistance())>30){
			Robot.drivetrainSubsystem.tankDrive(correctSpeed[0], correctSpeed[1]);
		}else if ((Robot.drivetrainSubsystem.rightEncoder.getDistance()-Robot.drivetrainSubsystem.leftEncoder.getDistance())>30){
			Robot.drivetrainSubsystem.tankDrive(correctSpeed[1], correctSpeed[0]);
		}else{
			Robot.drivetrainSubsystem.tankDrive(speed[0], speed[1]);
		}
		
		if(isFinished()){
			Robot.drivetrainSubsystem.tankDrive(0, 0);
		}
	}

	protected boolean isFinished() {
		return (Robot.drivetrainSubsystem.leftEncoder.getDistance()>targetDistance[0]) &&
				(Robot.drivetrainSubsystem.rightEncoder.getDistance()>targetDistance[1]);
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
