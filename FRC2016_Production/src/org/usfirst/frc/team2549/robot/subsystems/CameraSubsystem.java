package org.usfirst.frc.team2549.robot.subsystems;

import org.usfirst.frc.team2549.robot.commands.StreamCameraCommand;

import com.ni.vision.NIVision;
import com.ni.vision.NIVision.Image;
import com.ni.vision.VisionException;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class CameraSubsystem extends Subsystem {
	private CameraServer server;
	private boolean initilizedCamera;
	
	public Image frame = NIVision.imaqCreateImage(NIVision.ImageType.IMAGE_RGB, 0);
	private int session;
	private int session2;
	private boolean doneInit=false;
	public boolean broken = false;
	
	public CameraSubsystem(){
		server=CameraServer.getInstance();
	}
	
	public void initCameras(){
		try{
			session = NIVision.IMAQdxOpenCamera("cam1",
	                NIVision.IMAQdxCameraControlMode.CameraControlModeController);
			try{
		        session2 = NIVision.IMAQdxOpenCamera("cam2",
		                NIVision.IMAQdxCameraControlMode.CameraControlModeController);
			}catch(VisionException v){
				session2 = NIVision.IMAQdxOpenCamera("cam0",
		                NIVision.IMAQdxCameraControlMode.CameraControlModeController);
			}
		       server.setQuality(50);
		}catch (VisionException v){broken=true;pushError(v);}
	}
	
	private void pushError(VisionException v){
		SmartDashboard.putString("VisionError", v.getMessage()+" -- "+v.toString());
	}
	
	private int getSession(boolean id){
		return id ? session : session2;
	}
	
	private int getCurrentSession(){
		return getSession(initilizedCamera);
	}
	
	private void resetAcquisition(){
		if (!broken){
			try{
				NIVision.IMAQdxStopAcquisition(getCurrentSession());
				NIVision.IMAQdxUnconfigureAcquisition(getCurrentSession());
			}catch (VisionException v){broken=true;pushError(v);}
		}
	}
	
	public void selectCamera(boolean id){
		if (!broken){
			try{
				if (doneInit) resetAcquisition();
				NIVision.IMAQdxConfigureGrab(getSession(id));
		        NIVision.IMAQdxStartAcquisition(getSession(id));
		        initilizedCamera = id;
		        doneInit=true;
			}catch (VisionException v){broken=true;pushError(v);}
		}
	}
	
	public boolean getInitilizedCamera(){
		return initilizedCamera;
	}
	
	public void serveLatestFrame(){
		if(!broken){
			try{
				NIVision.IMAQdxGrab(getCurrentSession(), frame, 1);
				server.setImage(frame);
			}catch (VisionException v){broken=true;pushError(v);}
		}
	}
	
	protected void initDefaultCommand() {
		setDefaultCommand(new StreamCameraCommand());
	}

}
