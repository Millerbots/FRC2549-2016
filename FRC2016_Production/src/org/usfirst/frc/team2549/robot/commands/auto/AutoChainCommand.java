package org.usfirst.frc.team2549.robot.commands.auto;

import edu.wpi.first.wpilibj.command.Command;

public abstract class AutoChainCommand extends Command {
	
	protected Command next;
	
	public AutoChainCommand then(AutoChainCommand then){
		next=then;
		return then;
	}

	@Override
	protected void end() {
		if (this.next != null){
			this.next.start();
		}
	}
	
	public AutoChainCommand first(){
		this.start();
		return this;
	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub

	}

}
