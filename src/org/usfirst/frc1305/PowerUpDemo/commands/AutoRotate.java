// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc1305.PowerUpDemo.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc1305.PowerUpDemo.Robot;
import org.usfirst.frc1305.PowerUpDemo.RobotMap;

/**
 *
 */
public class AutoRotate extends Command {

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS
    private double m_AutoRotateAngle;
    private double m_AutoRotateForwardPower;
 
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
    public AutoRotate(double AutoRotateAngle, double AutoRotateForwardPower ) {

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING
        m_AutoRotateAngle = AutoRotateAngle;
        m_AutoRotateForwardPower = AutoRotateForwardPower;

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
        requires(Robot.drive);

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	//Robot.drive.gyroReset();
    	SmartDashboard.putNumber("StartAngle", Robot.drive.gyroGetAngle());
    	setTimeout(2);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	//Robot.drive.drivelowgear(); 
    	Robot.drive.driveTurn(m_AutoRotateForwardPower, (Robot.drive.gyroGetAngle() - m_AutoRotateAngle)  * 0.2); //0.2);
     	///Robot.driveTrain.driveTurn(0, (Robot.driveTrain.ahrs.getYaw() - m_AutoRotateAngle)  * 0.0215);
     	///Robot.driveTrain.driveTurn(0, (Math.sqrt(Robot.driveTrain.ahrs.getYaw() - m_AutoRotateAngle))  * 0.3);
       	//Robot.driveTrain.updateSmartDashboard();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	return (Math.abs(m_AutoRotateAngle - Robot.drive.gyroGetAngle())  < 5) || (isTimedOut());
    }

    // Called once after isFinished returns true
    protected void end() {
    	///Robot.driveTrain.driveStop();
       // Robot.drive.driveshighgear();
    //	SmartDashboard.putNumber("EndAngle", Robot.drive.gyroGetAngle());
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}