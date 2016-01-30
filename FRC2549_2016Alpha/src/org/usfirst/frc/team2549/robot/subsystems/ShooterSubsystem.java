package org.usfirst.frc.team2549.robot.subsystems;

import org.usfirst.frc.team2549.robot.RobotMap;
import org.usfirst.frc.team2549.robot.commands.ShooterCommand;

import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.interfaces.Potentiometer;

public class ShooterSubsystem extends Subsystem {
	
	Compressor compressor;
	DoubleSolenoid pusherPiston;
	public Potentiometer testPot;
	private SpeedController leftControllerGroup;
	private SpeedController rightControllerGroup;
	
	public ShooterSubsystem(){
		compressor = new Compressor(0);
		compressor.start();
		pusherPiston = new DoubleSolenoid(RobotMap.pusherChannels[0], RobotMap.pusherChannels[1]);
		testPot = new AnalogPotentiometer(2, 360, 0);
		
		leftControllerGroup=RobotMap.leftLiftGroup.getController();
		rightControllerGroup=RobotMap.rightLiftGroup.getController();
	}
	
	protected void initDefaultCommand() {
		setDefaultCommand(new ShooterCommand());
	}
	
	public void setLeftControllerGroup(double value){
		leftControllerGroup.set(value);
	}
	
	public void setRightControllerGroup(double value){
		rightControllerGroup.set(value);
	}
	
	public void openPiston(){
		pusherPiston.set(DoubleSolenoid.Value.kForward);
	}
	
	public void closePiston(){
		pusherPiston.set(DoubleSolenoid.Value.kReverse);
	}
}
