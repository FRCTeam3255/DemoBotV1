// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;

public class Shooter extends SubsystemBase {
  /** Creates a new Shooter. */

  // creates TalonFXs
  private TalonFX bottomFlywheelMotor;
  private TalonFX topFlywheelMotor;
  private TalonFX pushMotor;

  // links to RobotMap
  public Shooter() {
    bottomFlywheelMotor = new TalonFX(RobotMap.ShooterMap.BOTTOM_FLYWHEEL_MOTOR);
    topFlywheelMotor = new TalonFX(RobotMap.ShooterMap.TOP_FLYWHEEL_MOTOR);
    pushMotor = new TalonFX(RobotMap.ShooterMap.PUSH_MOTOR);
    configure();
  }

  // sets to Factory Default
  public void configure() {
    bottomFlywheelMotor.configFactoryDefault();
    topFlywheelMotor.configFactoryDefault();
    pushMotor.configFactoryDefault();
  }

  // Resets Encoder Counts
  public void resetEncoderCounts() {
    bottomFlywheelMotor.setSelectedSensorPosition(0);
    topFlywheelMotor.setSelectedSensorPosition(0);
    pushMotor.setSelectedSensorPosition(0);
  }

  // Gets Encoder Counts
  public double getBottomFlywheelEncoderCount() {
    return bottomFlywheelMotor.getSelectedSensorPosition();
  }

  public double getTopFlywheelEncoderCount() {
    return topFlywheelMotor.getSelectedSensorPosition();
  }

  public double getPushMotorEncoderCount() {
    return pushMotor.getSelectedSensorPosition();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    SmartDashboard.putNumber("Shooter Bottom Flywheel", getBottomFlywheelEncoderCount());
    SmartDashboard.putNumber("Shooter Top Flywheel", getTopFlywheelEncoderCount());
    SmartDashboard.putNumber("Shooter Push Motor", getPushMotorEncoderCount());
  }

  public void setFlywheelSpeed(double speed) {
    topFlywheelMotor.set(ControlMode.Velocity, speed);
    bottomFlywheelMotor.set(ControlMode.Velocity, speed);
  }

  public void setPushSpeed(double speed) {
    pushMotor.set(ControlMode.PercentOutput, speed);
  }

  public double getFlywheelSpeed() {
    return topFlywheelMotor.getSelectedSensorVelocity();
  }
}
