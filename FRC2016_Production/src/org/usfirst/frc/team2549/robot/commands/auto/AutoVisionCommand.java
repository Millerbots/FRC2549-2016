package org.usfirst.frc.team2549.robot.commands.auto;

import org.usfirst.frc.team2549.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class AutoVisionCommand extends Command {
	
	int[] firstCrosshair = {0,0};
	int[] secondCrosshair = {0,0};

	public AutoVisionCommand(){
		requires(Robot.drivetrainSubsystem);
	}
	
	@Override
	protected void end() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void execute() {
		SmartDashboard.putString("CROSSHAIR_COORDIANTES_from_java", SmartDashboard.getString("CROSSHAIR_COORDINATES", "not found"));
		String coords_raw = SmartDashboard.getString("CROSSHAIR_COORDINATES", "");
		if(coords_raw!=""){
			String[] split_coords = coords_raw.split(", ");
			int[] int_coords_raw = new int[split_coords.length];
			int i = 0;
			while (i<split_coords.length){
				int_coords_raw[i]=Integer.parseInt(split_coords[i]);
				i++;
			}
			
			if (int_coords_raw.length>0){
				firstCrosshair[0]=int_coords_raw[0];
				firstCrosshair[1]=int_coords_raw[1];
				if(int_coords_raw.length>2){
					secondCrosshair[0]=int_coords_raw[2];
					secondCrosshair[1]=int_coords_raw[3];
				}
			}
		}
		
		SmartDashboard.putNumber("firstCrosshairX", firstCrosshair[0]);
		SmartDashboard.putNumber("firstCrosshairY", firstCrosshair[1]);
		SmartDashboard.putNumber("secondCrosshairX", secondCrosshair[0]);
		SmartDashboard.putNumber("secondCrosshairY", secondCrosshair[1]);
		
		int resX = 640;
		int resY = 480;
		
		if(firstCrosshair[0]<resX/2)
		{
			Robot.drivetrainSubsystem.tankDrive(.5+((resX/2-firstCrosshair[0])/resX),.5);
		}
		else if(firstCrosshair[0]>resX/2)
		{
			Robot.drivetrainSubsystem.tankDrive(.5,.5+((resX/2-(resX-firstCrosshair[0]))/resX));
		}
		else
		{
			Robot.drivetrainSubsystem.tankDrive(0,0);
		}
		
//		if (SmartDashboard.getString("CROSSHAIR_COORDINATES", null)!= null){
//			Robot.drivetrainSubsystem.tankDrive(0.5, 0.5);
//		}else{
//			Robot.drivetrainSubsystem.tankDrive(0, 0);
//		}
	}

	@Override
	protected void initialize() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub

	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

}
