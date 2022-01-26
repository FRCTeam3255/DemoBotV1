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
  private TalonFX frontLeftMotor;
  private TalonFX frontRightMotor;
  private TalonFX backLeftMotor;
  private TalonFX backRightMotor;

  public Drivetrain() {
    frontLeftMotor = new TalonFX(RobotMap.DrivetrainMap.FRONT_LEFT_MOTOR);
    frontRightMotor = new TalonFX(RobotMap.DrivetrainMap.FRONT_RIGHT_MOTOR);
    backLeftMotor = new TalonFX(RobotMap.DrivetrainMap.BACK_LEFT_MOTOR);
    backRightMotor = new TalonFX(RobotMap.DrivetrainMap.BACK_RIGHT_MOTOR);
    configure();
  }

  public void configure() {
    frontLeftMotor.configFactoryDefault();
    frontRightMotor.configFactoryDefault();
    backLeftMotor.configFactoryDefault();
    backRightMotor.configFactoryDefault();
    backLeftMotor.follow(frontLeftMotor);
    backRightMotor.follow(frontRightMotor);
    frontRightMotor.setInverted(false);
    backRightMotor.setInverted(false);
    frontLeftMotor.setInverted(true);
    backLeftMotor.setInverted(true);
  }

  public void arcadeDrive(double a_speed, double a_turn) {
    double speed = a_speed; // * RobotPreferences.drivetrainLowSpeed;
    double turn = a_turn; // * RobotPreferences.drivetrainLowTurnSpeed;
    frontLeftMotor.set(ControlMode.PercentOutput, speed, DemandType.ArbitraryFeedForward, -turn);
    frontRightMotor.set(ControlMode.PercentOutput, speed, DemandType.ArbitraryFeedForward, turn);
  }

  public void resetEncoderCounts() {
    frontLeftMotor.setSelectedSensorPosition(0);
    frontRightMotor.setSelectedSensorPosition(0);
  }

  public double getLeftEncoderCount() {
    return frontLeftMotor.getSelectedSensorPosition();
  }

  public double getRightEncoderCount() {
    return frontRightMotor.getSelectedSensorPosition();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    SmartDashboard.putNumber("Drivetrain Left Encoder", getLeftEncoderCount());
    SmartDashboard.putNumber("Drivetrain Right Encoder", getRightEncoderCount());
  }

  public void setMovement(double speed, double rotation) {
    frontLeftMotor.set(ControlMode.PercentOutput, speed, DemandType.ArbitraryFeedForward, rotation);
    frontRightMotor.set(ControlMode.PercentOutput, speed, DemandType.ArbitraryFeedForward, rotation);
    backLeftMotor.set(ControlMode.PercentOutput, speed, DemandType.ArbitraryFeedForward, rotation);
    backRightMotor.set(ControlMode.PercentOutput, speed, DemandType.ArbitraryFeedForward, rotation);

  }
}