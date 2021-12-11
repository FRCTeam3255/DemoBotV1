// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;

public class Climber extends SubsystemBase {
  /** Creates a new Climber. */
  private TalonFX climberMotor;
  private DoubleSolenoid lockPiston;
  private DigitalInput climberBottomSafetySwitch;
  private double climberSpeed;

  public Climber() {
    climberMotor = new TalonFX(RobotMap.ClimberMap.CLIMBER_MOTOR);
    lockPiston = new DoubleSolenoid(RobotMap.ClimberMap.LOCK_PISTON_CH_A, RobotMap.ClimberMap.LOCK_PISTON_CH_B);
    climberBottomSafetySwitch = new DigitalInput(RobotMap.ClimberMap.CLIMBER_BOTTOM_SAFETY_SWITCH);
    configure();
    climberMotor.setNeutralMode(NeutralMode.Brake);
  }

  public void configure() {
    climberMotor.configFactoryDefault();
    climberMotor.setInverted(true);
  }

  @Override
  public void periodic() {
    SmartDashboard.putNumber("Climber Encoder", getClimberMotorEncoderCount());
    SmartDashboard.putBoolean("Climber Down", getClimberBottomSwitch());
    // This method will be called once per scheduler run

  }

  public double getClimberMotorEncoderCount() {
    return -climberMotor.getSelectedSensorPosition();
  }

  public boolean getClimberBottomSwitch() {
    return !climberBottomSafetySwitch.get();
  }

  public void setClimberMotorEncoderCount(double encoderCount) {
    climberMotor.setSelectedSensorPosition(encoderCount);
  }

  public void setClimbSpeed(double speed) {
    double climberSpeed = speed;
    if (getClimberBottomSwitch() && climberSpeed < 0) {
      climberSpeed = 0.0;
    }

    if (getClimberMotorEncoderCount() > 370000 && climberSpeed > 0) {
      climberSpeed = 0.0;
    }

    climberMotor.set(ControlMode.PercentOutput, climberSpeed);

    if (getClimberBottomSwitch()) {
      setClimberMotorEncoderCount(0);
    }
  }

  private double getClimbSpeed() {

    return climberMotor.getSelectedSensorVelocity();

  }
}
// Monkie