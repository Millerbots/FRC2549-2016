package org.usfirst.frc.team2549.robot.commands;

import org.usfirst.frc.team2549.robot.commands.auto.AbsoluteOrientCommand;
import org.usfirst.frc.team2549.robot.commands.auto.DriveDistanceCommand;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutoCommand extends CommandGroup {
	public AutoCommand(){
		addSequential(new AbsoluteOrientCommand(0));
		addSequential(new DriveDistanceCommand(400, 400));
		addSequential(new AbsoluteOrientCommand(180));
	}
}
