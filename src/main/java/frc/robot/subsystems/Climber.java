// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.TalonFX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;

public class Climber extends SubsystemBase {
  /** Creates a new Climber. */
  private TalonFX climberTalon;
  private DoubleSolenoid doubleSolenoid;
  private DigitalInput magSwitch;

  public Climber() {
    climberTalon = new TalonFX(RobotMap.ClimberMap.CLIMBER_TALON);
    doubleSolenoid = new DoubleSolenoid(RobotMap.ClimberMap.SOLENOID_FORWARD_CHANNEL,
        RobotMap.ClimberMap.SOLENOID_REVERSE_CHANNEL);
    magSwitch = new DigitalInput(RobotMap.ClimberMap.MAG_SWITCH);
    configure();
  }

  public void configure() {
    climberTalon.configFactoryDefault();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run

  }
}
