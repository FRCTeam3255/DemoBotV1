// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.DemandType;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;
import frc.robot.commands.AngleHood;

public class Hood extends SubsystemBase {
  /** Creates a new Hood. */
  private double hoodMultiplier = 41;
  // creates the motor
  private TalonSRX hoodMotor;
  private DigitalInput hoodSwitch;

  // link to RobotMap
  public Hood() {
    hoodMotor = new TalonSRX(RobotMap.HoodMap.HOOD_MOTOR);
    hoodSwitch = new DigitalInput(RobotMap.HoodMap.HOOD_SWITCH);
    configure();
  }

  // set to factory default
  private void configure() {
    hoodMotor.configFactoryDefault();
    hoodMotor.configPeakOutputForward(0.4);
    hoodMotor.configPeakOutputReverse(-0.4);
    hoodMotor.config_kP(0, 1);
  }

  // reset encoder count
  public void resetEncoderCounts() {
    hoodMotor.setSelectedSensorPosition(0);
  }

  // get encoder count
  public double getHoodMotorEncoderCount() {
    return hoodMotor.getSelectedSensorPosition();
  }

  public double getHoodMotorRotation() {
    return hoodMotor.getSelectedSensorPosition() / hoodMultiplier;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    SmartDashboard.putNumber("Hood Encoder Count", getHoodMotorEncoderCount());
    SmartDashboard.putNumber("Hood Angle", getHoodAngle());
    SmartDashboard.putBoolean("Is Hood Down", isHoodDown());
    SmartDashboard.putNumber("Hood Rotation", getHoodMotorRotation());
  }

  public boolean isHoodDown() {
    return !hoodSwitch.get();
  }

  public void setSpeed(double p_speed) {

    // If limit switch is pressed, then stop
    if (isHoodDown() && p_speed <= 0) {
      p_speed = 0;
      resetEncoderCounts();
    }

    // If over 90 degrees, then stop
    if (getHoodAngle() >= 90 && p_speed >= 0) {
      p_speed = 0;
    }

    hoodMotor.set(ControlMode.PercentOutput, p_speed);
  }

  private double getHoodAngle() {
    return getHoodMotorEncoderCount() / 41.0;
  }

  public void setAngle(double angle) {
    hoodMotor.set(ControlMode.Position, angle * hoodMultiplier);
  };
}
