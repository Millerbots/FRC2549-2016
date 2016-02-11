package org.usfirst.frc.team2549.robot.commands;

import org.usfirst.frc.team2549.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class ShooterCommand extends Command {
	
	public ShooterCommand(){
		requires(Robot.shooterSubsystem);
	}

	@Override
	protected void initialize() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void execute() {
		Robot.shooterSubsystem.setLifter(Robot.oi.joystick3.getY());
		if (Robot.oi.joystick3.getRawButton(3)){
			Robot.shooterSubsystem.setWheels(1);
		}else if (Robot.oi.joystick3.getRawButton(2)){
			Robot.shooterSubsystem.setWheels(-1);
		}else{
			Robot.shooterSubsystem.setWheels(0);
		}
		
//		SmartDashboard.putDouble("TestPot_Value", Robot.shooterSubsystem.testPot.get());
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
