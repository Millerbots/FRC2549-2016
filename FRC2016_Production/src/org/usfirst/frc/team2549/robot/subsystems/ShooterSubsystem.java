package org.usfirst.frc.team2549.robot.subsystems;

import org.usfirst.frc.team2549.robot.RobotMap;
import org.usfirst.frc.team2549.robot.commands.ShooterCommand;

import edu.wpi.first.wpilibj.ADXL345_I2C;
import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.interfaces.Potentiometer;

public class ShooterSubsystem extends Subsystem {
	private SpeedController liftController;
	private SpeedController wheelController;
	
	private AnalogGyro liftGyro;
	
	private DigitalInput limitSwitch;
	
	private double offset = 0.;
	
	public ShooterSubsystem(){
		liftController=RobotMap.liftMotor.getController();
		wheelController=RobotMap.wheelMotor.getController();
		
		liftGyro = new AnalogGyro(RobotMap.analogGyroPort);
		liftGyro.reset();
		liftGyro.setSensitivity(0.007);
		
		limitSwitch = new DigitalInput(RobotMap.limitSwitch);
	}
	
	public boolean getLimitSwitchValue(){
		return !limitSwitch.get();
	}
	
	protected void initDefaultCommand() {
		setDefaultCommand(new ShooterCommand());
	}
	
	public void setLifter(double value){
		liftController.set(value);
	}
	
	public void setWheels(double value){
		wheelController.set(value);
	}
	
	public double getRawAngle(){
		return liftGyro.getAngle();
	}
	
	public double getAngle(){
		return getRawAngle()-offset;
	}
	
	public double getGyroOffset(){
		return offset;
	}
	
	public void resetGyro(){
		offset=getRawAngle();
	}
}
