// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.Turret.Shooter;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Shooter;

public class ShootBall extends CommandBase {
  /** Creates a new ShootBall. */
  Shooter shooter;

  public ShootBall(Shooter p_shooter) {
    // Use addRequirements() here to declare subsystem dependencies.
    shooter = p_shooter;
    addRequirements(shooter);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    // Start spinning flywheel motor
    shooter.setFlywheelSpeed(1.0);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    // Wait until flywheel motor is back up to speed
    if (shooter.getFlywheelSpeed() >= 5000.0) {
      // Run push motor
      shooter.setPushSpeed(1.0);
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    // Stop running push motor
    shooter.setPushSpeed(0.0);
    // Stop running flywheel motor
    shooter.setFlywheelSpeed(0.0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
