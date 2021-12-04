// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.frcteam3255.joystick.SN_DualActionStick;
import com.frcteam3255.joystick.SN_Extreme3DStick;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.commands.ExampleCommand;
import frc.robot.subsystems.ExampleSubsystem;

import frc.robot.subsystems.Shooter;
import frc.robot.commands.ShootBall;

import frc.robot.subsystems.Drivetrain;
import frc.robot.commands.MoveDrivetrain;

import frc.robot.subsystems.Hood;
import frc.robot.commands.TurretPresets;

import frc.robot.subsystems.Susan;

/**
 * This class is where the bulk of the robot should be declared. Since
 * Command-based is a "declarative" paradigm, very little robot logic should
 * actually be handled in the {@link Robot} periodic methods (other than the
 * scheduler calls). Instead, the structure of the robot (including subsystems,
 * commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private SN_Extreme3DStick coDriverStick = new SN_Extreme3DStick(RobotMap.ControllerMap.CO_DRIVER_STICK);
  public static SN_DualActionStick DriverStick = new SN_DualActionStick(RobotMap.ControllerMap.DRIVER_STICK);

  // Examples
  private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();
  private final ExampleCommand m_autoCommand = new ExampleCommand(m_exampleSubsystem);

  // Shooter
  private final Shooter shooter = new Shooter();
  private final ShootBall shootBall = new ShootBall(shooter);

  // Drivetrain
  private final Drivetrain drivetrain = new Drivetrain();
  private final MoveDrivetrain moveDrivetrain = new MoveDrivetrain(drivetrain);

  // Susan
  private final Susan susan = new Susan();

  // Hood
  private final Hood hood = new Hood();
  private final TurretPresets turretPresets = new TurretPresets(hood, susan, 10, 10);
  private final TurretPresets turretPresets2 = new TurretPresets(hood, susan, 20, 30);

  /**
   * The container for the robot. Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
    drivetrain.setDefaultCommand(moveDrivetrain);
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be
   * created by instantiating a {@link GenericHID} or one of its subclasses
   * ({@link edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then
   * passing it to a {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    coDriverStick.btn_1.whileHeld(shootBall);
    coDriverStick.btn_12.whenPressed(turretPresets);
    coDriverStick.btn_11.whenPressed(turretPresets2);
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return m_autoCommand;
  }
}
