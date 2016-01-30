package org.usfirst.frc.team2549.robot.commands;

import org.usfirst.frc.team2549.robot.Robot;

import edu.wpi.first.wpilibj.Joystick.ButtonType;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

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
		if (Robot.oi.joystick1.getRawButton(4)){
			Robot.shooterSubsystem.setLeftControllerGroup(Robot.oi.joystick1.getY());
		}else if (Robot.oi.joystick1.getRawButton(5)){
			Robot.shooterSubsystem.setRightControllerGroup(Robot.oi.joystick1.getY());
		}else{
			Robot.shooterSubsystem.setLeftControllerGroup(Robot.oi.joystick1.getY());
			Robot.shooterSubsystem.setRightControllerGroup(Robot.oi.joystick1.getY());
		}
		
		SmartDashboard.putDouble("TestPot_Value", Robot.shooterSubsystem.testPot.get());
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
