package org.usfirst.frc.team2549.robot.commands;

import org.usfirst.frc.team2549.robot.Robot;

import com.ni.vision.VisionException;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class StreamCameraCommand extends Command {
	
	private SendableChooser cameraChooser;
	
	public StreamCameraCommand(){
		requires(Robot.cameraSubsystem);
		Robot.cameraSubsystem.initCameras();
	}

	@Override
	protected void initialize() {
		cameraChooser = new SendableChooser();
		cameraChooser.addDefault("Lift Camera", "cam1");
		cameraChooser.addObject("Back Camera", "cam2");
        SmartDashboard.putData("Camera", cameraChooser);
        String selectionString = (String)cameraChooser.getSelected();
		boolean selection = false;
		if (selectionString=="cam2"){
			selection = true;
		}
		Robot.cameraSubsystem.selectCamera(selection);
	}

	
	@Override
	protected void execute() {
		try{
			Robot.cameraSubsystem.serveLatestFrame();
		}catch(VisionException e){
			SmartDashboard.putString("Vision Error", e.getMessage()+e.getStackTrace());
		}
		
		String selectionString = (String)cameraChooser.getSelected();
		boolean selection = false;
		if (selectionString=="cam2"){
			selection = true;
		}
		
		/*if (selection!=Robot.cameraSubsystem.getInitilizedCamera()){
			Robot.cameraSubsystem.selectCamera(selection);
			Robot.cameraSubsystem.serveLatestFrame();
		}*/
		
		if(Robot.oi.joystick1.getRawButton(4) || Robot.oi.joystick2.getRawButton(4))
		{
			Robot.cameraSubsystem.selectCamera(true);
		}
		else if(Robot.oi.joystick1.getRawButton(5) || Robot.oi.joystick2.getRawButton(5))
		{
			Robot.cameraSubsystem.selectCamera(false);
		}
			
			
		SmartDashboard.putString("Target XY", SmartDashboard.getString("DIAMOND_COORDINATES", "?"));
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
