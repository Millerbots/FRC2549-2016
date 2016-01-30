package org.usfirst.frc.team2549.robot.subsystems;

import org.usfirst.frc.team2549.robot.commands.StreamCameraCommand;

import com.ni.vision.NIVision;
import com.ni.vision.NIVision.Image;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.command.Subsystem;

public class CameraSubsystem extends Subsystem {
	private CameraServer server;
	private boolean initilizedCamera;
	
	public Image frame = NIVision.imaqCreateImage(NIVision.ImageType.IMAGE_RGB, 0);
	private int session;
	private int session2;
	private boolean doneInit=false;
	
	public CameraSubsystem(){
		server=CameraServer.getInstance();
	}
	
	public void initCameras(){
		session = NIVision.IMAQdxOpenCamera("cam1",
                NIVision.IMAQdxCameraControlMode.CameraControlModeController);
        session2 = NIVision.IMAQdxOpenCamera("cam2",
                NIVision.IMAQdxCameraControlMode.CameraControlModeController);
		server.setQuality(50);
	}
	
	private int getSession(boolean id){
		return id ? session : session2;
	}
	
	private int getCurrentSession(){
		return getSession(initilizedCamera);
	}
	
	private void resetAcquisition(){
		NIVision.IMAQdxStopAcquisition(getCurrentSession());
		NIVision.IMAQdxUnconfigureAcquisition(getCurrentSession());
	}
	
	public void selectCamera(boolean id){
		if (doneInit) resetAcquisition();
		NIVision.IMAQdxConfigureGrab(getSession(id));
        NIVision.IMAQdxStartAcquisition(getSession(id));
        initilizedCamera = id;
        doneInit=true;
	}
	
	public boolean getInitilizedCamera(){
		return initilizedCamera;
	}
	
	public void serveLatestFrame(){
		NIVision.IMAQdxGrab(getCurrentSession(), frame, 1);
		server.setImage(frame);
	}
	
	protected void initDefaultCommand() {
		setDefaultCommand(new StreamCameraCommand());
	}

}
