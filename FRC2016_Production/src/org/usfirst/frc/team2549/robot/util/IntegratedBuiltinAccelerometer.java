package org.usfirst.frc.team2549.robot.util;

import edu.wpi.first.wpilibj.BuiltInAccelerometer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class IntegratedBuiltinAccelerometer extends BuiltInAccelerometer {
	private double velocityX = 0;
	private double velocityY = 0;
	private double positionX = 0;
	private double positionY = 0;
	private double[] accelXBuffer = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
	private int accelXBufferPosition = 0;
	private double[] accelYBuffer = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
	private int accelYBufferPosition = 0;
	private double[] deltaBuffer = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
	private int deltaBufferPosition = 0;
	public double offsetX = 0;
	public double offsetY = 0;
	
	private long last = -1;

	public IntegratedBuiltinAccelerometer(Range range) {
		super(range);
	}
	
	public void reset(){
		velocityX = 0;
		velocityY = 0;
		positionX = 0;
		positionY = 0;
		offsetX = this.getAvgX();
		offsetY = this.getAvgY();
	}
	
	public void initSampling(){
		last=-1;
	}
	
	public double getAvgX(){
		double sum = 0;
		int i = -1;
		int c = 0;
		while (i!=9){
			i++;
			if (accelXBuffer[i]!=-1){
				sum += accelXBuffer[i];
				c++;
			}
		}
		return (sum/c);
	}
	
	public double getAvgY(){
		double sum = 0;
		int i = -1;
		int c = 0;
		while (i!=9){
			i++;
			if (accelYBuffer[i]!=-1){
				sum += accelYBuffer[i];
				c++;
			}
		}
		return (sum/c);
	}
	
	public double getOffsetAvgY(){
		return getAvgY()-offsetY;
	}
	
	public double getOffsetAvgX(){
		return getAvgX()-offsetX;
	}
	
	public double getAvgTime(){
		double sum = 0;
		int i = -1;
		int c = 0;
		while (i!=99){
			i++;
			if (deltaBuffer[i]!=-1){
				sum += deltaBuffer[i];
				c++;
			}
		}
		return (sum/c);
	}
	
	private void sampleToBuffer(){
		accelXBufferPosition++;
		if (accelXBufferPosition==10){
			accelXBufferPosition=0;
		}
		accelXBuffer[accelXBufferPosition]=this.getX();
		
		accelYBufferPosition++;
		if (accelYBufferPosition==10){
			accelYBufferPosition=0;
		}
		accelYBuffer[accelYBufferPosition]=this.getY();
	}
	
	public void sample(){
		sampleToBuffer();
		if (last==-1){
			last=System.nanoTime();
		}
		
		double accelX=getOffsetAvgX();
		double accelY=getOffsetAvgY();
		
		deltaBufferPosition++;
		if (deltaBufferPosition==100){
			deltaBufferPosition=0;
		}
		double rawTime = System.nanoTime()-last;
		deltaBuffer[deltaBufferPosition]=rawTime;
		double time=getAvgTime();
		velocityX+=accelX*time;
		velocityY+=accelY*time;
		positionX+=velocityX*time;
		positionY+=velocityY*time;
		last=System.nanoTime();
		SmartDashboard.putNumber("deltaTime", rawTime);
	}
	
	public double getVelocityX(){
		return velocityX;
	}
	
	public double getVelocityY(){
		return velocityY;
	}
	
	public double getPositionX(){
		return positionX;
	}
	
	public double getPositionY(){
		return positionY;
	}

}
