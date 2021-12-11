/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotMap.HoodMap;
import frc.robot.subsystems.Hood;

public class AngleHood extends CommandBase {
  /** Creates a new AngleHood. */
  Hood hood;
  int MotorDirection;

  public AngleHood(Hood p_hood, int p_MotorDirection) {
    // Use addRequirements() here to declare subsystem dependencies.
    hood = p_hood;
    MotorDirection = p_MotorDirection;
    addRequirements(hood);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    // Start Spinning hood motor
    // Set Angle
    hood.setAngle(MotorDirection * .2);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    // Stop running hood motor

  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
