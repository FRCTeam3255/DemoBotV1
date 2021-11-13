// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;

public class Susan extends SubsystemBase {
    /** Creates a new Susan. */

    private TalonSRX susanMotor;

    public Susan() {
        susanMotor = new TalonSRX(RobotMap.SusanMap.SUSAN_MOTOR);
        configure();
    }

    public void configure() {
        susanMotor.configFactoryDefault();
    }

    public double getSusanEncoderCount() {
        return susanMotor.getSelectedSensorPosition();
    }

    @Override
    public void periodic() {
        SmartDashboard.putNumber("Susan Encoder (^.w.^)", getSusanEncoderCount());
    }

}
