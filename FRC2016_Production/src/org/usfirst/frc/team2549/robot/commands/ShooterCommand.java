package org.usfirst.frc.team2549.robot.commands;

import org.usfirst.frc.team2549.robot.Robot;

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
		if ((Robot.shooterSubsystem.getAngle()>30 && Robot.oi.joystick3.getY()<0) ||
				(Robot.shooterSubsystem.getLimitSwitchValue() && Robot.oi.joystick3.getY()>0)){
			Robot.shooterSubsystem.setLifter(0);
		}else{
			Robot.shooterSubsystem.setLifter(Robot.oi.joystick3.getY());
		}
		
		SmartDashboard.putDouble("JoystickValue", Robot.oi.joystick3.getY());
		
		if (Robot.oi.joystick3.getRawButton(3) || Robot.oi.joystick2.getRawButton(3) || Robot.oi.joystick1.getRawButton(3)){
			Robot.shooterSubsystem.setWheels(1);
		}else if (Robot.oi.joystick3.getRawButton(2) || Robot.oi.joystick2.getRawButton(2) || Robot.oi.joystick1.getRawButton(2)){
			Robot.shooterSubsystem.setWheels(-1);
		}else{
			Robot.shooterSubsystem.setWheels(0);
		}
		
		if (Robot.oi.joystick3.getRawButton(10) || Robot.oi.joystick2.getRawButton(10) || Robot.oi.joystick1.getRawButton(10)){
			Robot.shooterSubsystem.resetGyro();
		}
		
		if (Robot.shooterSubsystem.getLimitSwitchValue()){
			Robot.shooterSubsystem.resetGyro();
		}
		
//		SmartDashboard.putDouble("TestPot_Value", Robot.shooterSubsystem.testPot.get());
		SmartDashboard.putDouble("Gyro", Robot.shooterSubsystem.getAngle());
		SmartDashboard.putDouble("GyroOffset", Robot.shooterSubsystem.getGyroOffset());
		SmartDashboard.putBoolean("LimitSwitch", Robot.shooterSubsystem.getLimitSwitchValue());
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
