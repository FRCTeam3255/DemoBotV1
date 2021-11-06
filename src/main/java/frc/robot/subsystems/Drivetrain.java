/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                              */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.DemandType;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;

public class Drivetrain extends SubsystemBase {
  /**
   * Creates a new Drivetrain.
   */
  // variables
  private TalonFX frontLeft;
  private TalonFX frontRight;
  private TalonFX backLeft;
  private TalonFX backRight;

  public Drivetrain() {
    frontLeft = new TalonFX(RobotMap.DrivetrainMap.FRONT_LEFT);
    frontRight = new TalonFX(RobotMap.DrivetrainMap.FRONT_RIGHT);
    backLeft = new TalonFX(RobotMap.DrivetrainMap.BACK_LEFT);
    backRight = new TalonFX(RobotMap.DrivetrainMap.BACK_RIGHT);
    configure();
  }

  public void configure() {
    frontLeft.configFactoryDefault();
    frontRight.configFactoryDefault();
    backLeft.configFactoryDefault();
    backRight.configFactoryDefault();
    backLeft.follow(frontLeft);
    backRight.follow(frontRight);
    frontRight.setInverted(true);
    backRight.setInverted(true);
  }

  public void arcadeDrive(double a_speed, double a_turn) {
    double speed = a_speed; //* RobotPreferences.drivetrainLowSpeed;
    double turn = a_turn; //* RobotPreferences.drivetrainLowTurnSpeed;
    frontLeft.set(ControlMode.PercentOutput, speed, DemandType.ArbitraryFeedForward, turn);
    frontRight.set(ControlMode.PercentOutput, speed, DemandType.ArbitraryFeedForward, -turn);
  }

  public void resetEncoderCounts() {
    frontLeft.setSelectedSensorPosition(0);
    frontRight.setSelectedSensorPosition(0);
  }

  public double getLeftEncoderCount() {
    return frontLeft.getSelectedSensorPosition();
  }

  public double getRightEncoderCount() {
    return frontRight.getSelectedSensorPosition();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    SmartDashboard.putNumber("Drivetrain Left Encoder", getLeftEncoderCount());
    SmartDashboard.putNumber("Drivetrain Right Encoder", getRightEncoderCount());
  }
}