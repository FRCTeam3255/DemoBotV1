// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;

public class Intake extends SubsystemBase {
  /** Creates a new Intake. */

  // Create TalonFXs
  private TalonFX intakeMotor;

  public Intake() {
    intakeMotor = new TalonFX(RobotMap.IntakeMap.INTAKE_MOTOR);
    configure();
  }

  public void configure() {
    intakeMotor.configFactoryDefault();
  }

  public double getIntakeEncoderCount() {
    return intakeMotor.getSelectedSensorPosition();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    SmartDashboard.putNumber("Intake Encoder", getIntakeEncoderCount());
  }

  public void setIntakeSpeed(double speed) {
    intakeMotor.set(ControlMode.PercentOutput, speed);
  }
}
