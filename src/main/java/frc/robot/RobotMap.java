// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The RobotMap class provides a convenient place for teams to hold robot-wide
 * numerical or boolean constants. This class should not be used for any other
 * purpose. All constants should be declared globally (i.e. public static). Do
 * not put anything functional in this class.
 *
 * <p>
 * It is advised to statically import this class (or one of its inner classes)
 * wherever the constants are needed, to reduce verbosity.
 */
public final class RobotMap {

    public final class DrivetrainMap {
        public static final int FRONT_LEFT_MOTOR = 0;
        public static final int BACK_LEFT_MOTOR = 1;
        public static final int FRONT_RIGHT_MOTOR = 2;
        public static final int BACK_RIGHT_MOTOR = 3;
    }

    public final class ClimberMap {
        // Motors
        public static final int CLIMBER_MOTOR = 8;

        // Pistons
        public static final int LOCK_PISTON_CH_A = 2;
        public static final int LOCK_PISTON_CH_B = 3;

        // Switches
        public static final int CLIMBER_BOTTOM_SAFETY_SWITCH = 4;
    }

    public final class IntakeMap {
        public static final int INTAKE_MOTOR = 4;
    }

    public final class ShooterMap {
        public static final int BOTTOM_FLYWHEEL_MOTOR = 13;
        public static final int TOP_FLYWHEEL_MOTOR = 14;
        public static final int PUSH_MOTOR = 7;
    }

    public final class SusanMap {
        public static final int SUSAN_MOTOR = 11;
    }

    public final class TransferMap {
        // Motors
        public static final int QUEUE_MOTOR = 5;
        public static final int CHAMBER_MOTOR = 6;

        // Switches
        public static final int QUEUE_SWITCH = 1;
        public static final int CHAMBER_SWITCH = 2;
    }

    public final class ControllerMap {
        public static final int CO_DRIVER_STICK = 1;
        public static final int DRIVER_STICK = 0;
    }

    public final class HoodMap {
        public static final int HOOD_MOTOR = 12;
        public static final int HOOD_SWITCH = 3;
    }

}
