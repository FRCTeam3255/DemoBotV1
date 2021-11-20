// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;

public class Climber extends SubsystemBase {
  /** Creates a new Climber. */
  private TalonFX climberMotor;
  private DoubleSolenoid lockPiston;
  private DigitalInput climberSafety;

  public Climber() {
    climberMotor = new TalonFX(RobotMap.ClimberMap.CLIMBER_MOTOR);
    lockPiston = new DoubleSolenoid(RobotMap.ClimberMap.LOCK_PISTON_CH_A, RobotMap.ClimberMap.LOCK_PISTON_CH_B);
    climberSafety = new DigitalInput(RobotMap.ClimberMap.CLIMBER_MAG_SWITCH);
    configure();
    climberMotor.setNeutralMode(NeutralMode.Brake);
  }

  public void configure() {
    climberMotor.configFactoryDefault();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run

  }
}