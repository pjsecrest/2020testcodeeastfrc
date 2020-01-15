/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;
import edu.wpi.first.wpilibj.PWMTalonSRX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
//import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

import frc.robot.Constants.DriveConstants;

public class Chassis extends SubsystemBase {

//left side motors
  private final SpeedControllerGroup m_leftMotors =
     new SpeedControllerGroup(new PWMTalonSRX(DriveConstants.leftBackMotor), 
     new PWMTalonSRX(DriveConstants.leftFrontMotor),
     new PWMTalonSRX(DriveConstants.leftTopMotor));

//right side motors
  private final SpeedControllerGroup m_rightMotors = 
     new SpeedControllerGroup(new PWMTalonSRX(DriveConstants.rightBackMotor),
     new PWMTalonSRX(DriveConstants.rightFrontMotor),
     new PWMTalonSRX(DriveConstants.rightTopMotor));

//robot's drive
  private final DifferentialDrive m_drive = new DifferentialDrive(m_leftMotors, m_rightMotors);

  public Chassis() {

  }

//drives robot using arcade drive
  public void arcadeDrive(double fwd, double rot){
    m_drive.arcadeDrive(fwd, rot);
  }

//sets max output
public void setMaxOutput(double maxOutput){
  m_drive.setMaxOutput(maxOutput);
}

}

