package org.usfirst.frc.team2549.robot.commands;

import org.usfirst.frc.team2549.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class ControlTestMotorCommand extends Command {
	
	public ControlTestMotorCommand(){
		requires(Robot.testSubsystem);
	}

	@Override
	protected void initialize() {
		
	}

	@Override
	protected void execute() {
		Robot.testSubsystem.setMotor(Robot.oi.testStick.getY());
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
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
