// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;

public class Shooter extends SubsystemBase {
  /** Creates a new Shooter. */

  // creates TalonFXs
  private CANSparkMax bottomFlywheelMotor;
  private CANSparkMax topFlywheelMotor;
  private TalonSRX pushMotor;

  // links to RobotMap
  public Shooter() {
    bottomFlywheelMotor = new CANSparkMax(RobotMap.ShooterMap.BOTTOM_FLYWHEEL_MOTOR, MotorType.kBrushless);
    topFlywheelMotor = new CANSparkMax(RobotMap.ShooterMap.TOP_FLYWHEEL_MOTOR, MotorType.kBrushless);
    pushMotor = new TalonSRX(RobotMap.ShooterMap.PUSH_MOTOR);
    configure();
  }

  // sets to Factory Default
  public void configure() {
    bottomFlywheelMotor.restoreFactoryDefaults();
    topFlywheelMotor.restoreFactoryDefaults();
    pushMotor.configFactoryDefault();
  }

  // Resets Encoder Counts
  public void resetEncoderCounts() {
    bottomFlywheelMotor.getEncoder().setPosition(0);
    topFlywheelMotor.getEncoder().setPosition(0);
    pushMotor.setSelectedSensorPosition(0);
  }

  // Gets Encoder Counts
  public double getBottomFlywheelEncoderCount() {
    return bottomFlywheelMotor.getEncoder().getPosition();
  }

  public double getTopFlywheelEncoderCount() {
    return topFlywheelMotor.getEncoder().getPosition();
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
    SmartDashboard.putNumber("Flywheel Speed", getFlywheelSpeed());
  }

  public void setFlywheelSpeed(double speed) {
    topFlywheelMotor.set(speed);
    bottomFlywheelMotor.set(speed);
  }

  public void setPushSpeed(double speed) {
    pushMotor.set(ControlMode.PercentOutput, -speed);
  }

  public double getFlywheelSpeed() {
    return topFlywheelMotor.getEncoder().getVelocity();
  }
}
