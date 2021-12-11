// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Hood;
import frc.robot.subsystems.Susan;

public class TurretPresets extends CommandBase {

  /** Creates a new HoodPresets. */
  Hood hood;
  Susan susan;
  double angle;
  double rotation;

  public TurretPresets(Hood p_hood, Susan p_susan, double p_angle, double p_rotation) {
    // Use addRequirements() here to declare subsystem dependencies.
    angle = p_angle;
    rotation = p_rotation;
    hood = p_hood;
    susan = p_susan;

    addRequirements(hood, susan);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    // set the Motor to the angle and rotation
    hood.setAngle(angle);
    susan.setRotation(rotation);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
