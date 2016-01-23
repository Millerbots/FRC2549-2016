package org.usfirst.frc.team2549.robot.subsystems;

import org.usfirst.frc.team2549.robot.RobotMap;
import org.usfirst.frc.team2549.robot.commands.ShooterCommand;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class ShooterSubsystem extends Subsystem {
	
	Compressor compressor;
	DoubleSolenoid pusherPiston;
	
	public ShooterSubsystem(){
		compressor = new Compressor(0);
		compressor.start();
		pusherPiston = new DoubleSolenoid(RobotMap.pusherChannels[0], RobotMap.pusherChannels[1]);
	}
	
	protected void initDefaultCommand() {
		setDefaultCommand(new ShooterCommand());
	}
	
	public void openPiston(){
		pusherPiston.set(DoubleSolenoid.Value.kForward);
	}
	
	public void closePiston(){
		pusherPiston.set(DoubleSolenoid.Value.kReverse);
	}
}
