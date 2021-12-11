// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.Turret.Susan;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.Susan;

public class RotateSusan extends CommandBase {
  /** Creates a new RotateSusan. */
  Susan susan;

  public RotateSusan(Susan p_susan) {
    // Use addRequirements() here to declare subsystem dependencies.
    susan = p_susan;
    addRequirements(susan);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    // check that susan is not over-extending itself
    double rotation = RobotContainer.coDriverStick.getTwistAxis();
    susan.setRotationSpeed(rotation);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    // stop rotating the susan
    susan.setRotationSpeed(0.0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
