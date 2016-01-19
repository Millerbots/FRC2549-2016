package org.usfirst.frc.team2549.robot.subsystems;

import org.usfirst.frc.team2549.robot.RobotMap;
import org.usfirst.frc.team2549.robot.commands.ControlTestMotorCommand;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class TestMotorSystem extends Subsystem {
	
	private Talon testTalon = new Talon(RobotMap.testMotor);

	@Override
	protected void initDefaultCommand() {
		setDefaultCommand(new ControlTestMotorCommand());
	}
	
	public void setMotor(double value){
		this.testTalon.set(value);
	}

}
