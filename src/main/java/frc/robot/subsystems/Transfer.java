// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;

public class Transfer extends SubsystemBase {
  /** Creates a new Transfer. */

  // variables
  private TalonSRX queueMotor;
  private TalonSRX chamberMotor;
  private DigitalInput queueSensor;
  private DigitalInput chamberSensor;

  public Transfer() {
    queueMotor = new TalonSRX(RobotMap.Transfer.QUEUE_MOTOR);
    chamberMotor = new TalonSRX(RobotMap.Transfer.CHAMBER_MOTOR);
    queueSensor = new DigitalInput(RobotMap.Transfer.QUEUE_SENSOR);
    chamberSensor = new DigitalInput(RobotMap.Transfer.CHAMBER_SENSOR);
    configure();
  }

  public void configure() {
    queueMotor.configFactoryDefault();
    chamberMotor.configFactoryDefault();
  }

  public boolean getQueueSwitchhStatus() {
    return queueSensor.get();
  }

  public boolean getChamberSwitchhStatus() {
    return chamberSensor.get();
  }

  public void resetEncoderCounts() {
    queueMotor.setSelectedSensorPosition(0);
    chamberMotor.setSelectedSensorPosition(0);
  }

  // possibly will delete
  public double getLeftEncoderCount() {
    return queueMotor.getSelectedSensorPosition();
  }

  public double getRightEncoderCount() {
    return chamberMotor.getSelectedSensorPosition();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
