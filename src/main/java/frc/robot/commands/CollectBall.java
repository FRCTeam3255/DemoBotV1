// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Transfer;

public class CollectBall extends CommandBase {
  /** Creates a new CollectBall. */
  Intake intake;
  Transfer transfer;
  double queueMotorSpeed;
  double chamberMotorSpeed;

  public CollectBall(Intake p_intake, Transfer p_transfer) {
    // Use addRequirements() here to declare subsystem dependencies.
    intake = p_intake;
    addRequirements(intake);
    transfer = p_transfer;
    addRequirements(transfer);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    // Start spinning intake motor
    intake.setIntakeSpeed(.75);
    queueMotorSpeed = 0;
    chamberMotorSpeed = 0;

  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    queueMotorSpeed = .5;
    chamberMotorSpeed = .5;

    if (transfer.isBallInChamber()) {
      chamberMotorSpeed = 0;
    }

    if (transfer.isBallQueued() && transfer.isBallInChamber()) {
      queueMotorSpeed = 0;
    }

    transfer.setChamberMotor(chamberMotorSpeed);
    transfer.setQueueMotor(queueMotorSpeed);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    // Stop running intake motor
    intake.setIntakeSpeed(0.0);
    transfer.setQueueMotor(0);
    transfer.setChamberMotor(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
