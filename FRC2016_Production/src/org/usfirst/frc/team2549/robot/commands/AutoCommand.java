package org.usfirst.frc.team2549.robot.commands;

import org.usfirst.frc.team2549.robot.commands.auto.OrientCommand;
import org.usfirst.frc.team2549.robot.commands.auto.DriveDistanceCommand;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutoCommand extends CommandGroup {
	public AutoCommand(){
		addSequential(new OrientCommand(0));
		addSequential(new DriveDistanceCommand(200, 200));
		addSequential(new OrientCommand(90, true));
		addSequential(new DriveDistanceCommand(200, 200));
		addSequential(new OrientCommand(90, true));
		addSequential(new DriveDistanceCommand(200, 200));
		addSequential(new OrientCommand(90, true));
		addSequential(new DriveDistanceCommand(200, 200));
		addSequential(new OrientCommand(90, true));
	}
}
