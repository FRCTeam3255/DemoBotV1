// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.Drivetrain;

public class MoveDrivetrain extends CommandBase {
  /** Creates a new MoveDrivetrain. */
  Drivetrain drivetrain;

  public MoveDrivetrain(Drivetrain p_drivetrain) {
    // Use addRequirements() here to declare subsystem dependencies.
    drivetrain = p_drivetrain;
    addRequirements(drivetrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    // read direction of joystick
    double speed = RobotContainer.DriverStick.getArcadeMove();
    double rotation = RobotContainer.DriverStick.getArcadeRotate();

    // set motors to direction to joystick
    drivetrain.setMovement(speed, rotation);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    // stop spinning the wheels
    drivetrain.setMovement(0, 0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
