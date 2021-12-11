// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.DemandType;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;

public class Hood extends SubsystemBase {
  /** Creates a new Hood. */

  // creates the motor
  private TalonSRX hoodMotor;

  // link to RobotMap
  public Hood() {
    hoodMotor = new TalonSRX(RobotMap.HoodMap.HOOD_MOTOR);
    configure();
  }

  // set to factory default
  private void configure() {
    hoodMotor.configFactoryDefault();
  }

  // reset encoder count
  public void resetEncoderCounts() {
    hoodMotor.setSelectedSensorPosition(0);
  }

  // get encoder count
  public double getHoodMotorEncoderCount() {
    return hoodMotor.getSelectedSensorPosition();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    SmartDashboard.putNumber("Hood Motor", getHoodMotorEncoderCount());

  }

  public void setAngle(double angle) {
    hoodMotor.set(ControlMode.Position, angle * 85);
  };
}
