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
        public static final int FRONT_LEFT = 0;
        public static final int BACK_LEFT = 1;
        public static final int FRONT_RIGHT = 2;
        public static final int BACK_RIGHT = 3;
    }

    public final class ClimberMap {
        public static final int CLIMBER_MOTOR = 8;
        public static final int LOCK_PISTON_CH_A = 2;
        public static final int LOCK_PISTON_CH_B = 3;
        public static final int CLIMBER_MAG_SWITCH = 4;
    }

}
