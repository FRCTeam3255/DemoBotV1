// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.TalonFX;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;

public class Shooter extends SubsystemBase {
  /** Creates a new Shooter. */

  private TalonFX bottomFlywheel;
  private TalonFX topFlywheel;

  public Shooter() {
    bottomFlywheel = new TalonFX(RobotMap.ShooterMap.BOTTOM_FLYWHEEL);
    topFlywheel = new TalonFX(RobotMap.ShooterMap.TOP_FLYWHEEL);
    configure();
  }

  public void configure() {
    bottomFlywheel.configFactoryDefault();
    topFlywheel.configFactoryDefault();
  }

  // Resets encoder counts. Not sure if I need this
  public void resetEncoderCounts() {
    bottomFlywheel.setSelectedSensorPosition(0);
    topFlywheel.setSelectedSensorPosition(0);
  }

  public double getBottomFlywheelEncoderCount() {
    return bottomFlywheel.getSelectedSensorPosition();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    SmartDashboard.putNumber("Shooter Bottom Flywheel");
  }
}
