// RobotBuilder Version: 5.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.

package frc.robot;

import com.revrobotics.CANSparkMax.IdleMode;

import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.kinematics.SwerveDriveKinematics;
import edu.wpi.first.math.trajectory.TrapezoidProfile;
import edu.wpi.first.math.util.Units;
import edu.wpi.first.wpilibj.DriverStation.Alliance;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import edu.wpi.first.wpilibj2.command.Command;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide
 * numerical or boolean
 * constants. This class should not be used for any other purpose. All constants
 * should be
 * declared globally (i.e. public static). Do not put anything functional in
 * this class.
 *
 * <p>
 * It is advised to statically import this class (or one of its inner classes)
 * wherever the
 * constants are needed, to reduce verbosity.
 */

public class Constants {

  public static final class LimeLightConstants {
    public static final double Horizontal_Offset = 0;
    public static final double Height = 0;
    public static final double Angle = 0;

    public static final double FIELD_WIDTH = Units.inchesToMeters((12 * 26) + 3.5);

    public static final String[] nodeLocationString = { "Node9", "Node8", "Node7", "Node6", "Node5", "Node4", "Node3",
        "Node2", "Node1" };

    private static final Map<String, Pose2d> BLUE_MAP = Map.ofEntries(
        Map.entry(nodeLocationString[0],
            new Pose2d(new Translation2d(1.582 + 1, Units.inchesToMeters(19.875)), Rotation2d.fromDegrees(180))),
        Map.entry(nodeLocationString[1],
            new Pose2d(new Translation2d(1.582 + 1, Units.inchesToMeters(41.875)), Rotation2d.fromDegrees(180))),
        Map.entry(nodeLocationString[2],
            new Pose2d(new Translation2d(1.582 + 1, Units.inchesToMeters(63.875)), Rotation2d.fromDegrees(180))),
        Map.entry(nodeLocationString[3],
            new Pose2d(new Translation2d(1.582 + 1, Units.inchesToMeters(85.875)), Rotation2d.fromDegrees(180))),
        Map.entry(nodeLocationString[4],
            new Pose2d(new Translation2d(1.582 + 1, Units.inchesToMeters(107.875)), Rotation2d.fromDegrees(180))),
        Map.entry(nodeLocationString[5],
            new Pose2d(new Translation2d(1.582 + 1, Units.inchesToMeters(129.875)), Rotation2d.fromDegrees(180))),
        Map.entry(nodeLocationString[6],
            new Pose2d(new Translation2d(1.582 + 1, Units.inchesToMeters(151.875)), Rotation2d.fromDegrees(180))),
        Map.entry(nodeLocationString[7],
            new Pose2d(new Translation2d(1.582 + 1, Units.inchesToMeters(173.875)), Rotation2d.fromDegrees(180))),
        Map.entry(nodeLocationString[8],
            new Pose2d(new Translation2d(1.582 + 1, Units.inchesToMeters(195.875)), Rotation2d.fromDegrees(180))));
    private static final Map<String, Pose2d> RED_MAP = BLUE_MAP.entrySet().stream().collect(Collectors.toMap(
        entry -> entry.getKey(),
        entry -> new Pose2d(
            new Translation2d(
                entry.getValue().getX(),
                FIELD_WIDTH - entry.getValue().getY()),
            entry.getValue().getRotation())));

    public static final Map<Alliance, Map<String, Pose2d>> POSE_MAP = Map.of(
        Alliance.Blue, BLUE_MAP,
        Alliance.Red, RED_MAP);
  }

  public static final class LEDConstants {
    public static final String blueAlliance = "B";
    public static final String redAlliance = "R";
    public static final String humanFeedback = "H";
    public static final String allianceColor = "A";
    public static final String blackColor = "0";
    public static final String coneColor = "3";
    public static final String greenColor = "4";
    public static final String cubeColor = "7";
    public static final int LEDCount = 30;
  }

  public static final class DriveConstants {
    public static final double kDrivingP = 0.25;
    public static final double kDrivingI = 0;
    public static final double kDrivingD = 0;
    public static final double kBalanceToleranceDeg = 1.5;

    public static final double kTurnP = 0.025;
    public static final double kTurnI = 0.001;
    public static final double kTurnD = 0;

    public static final double kMaxTurnRateDegPerS = 100;
    public static final double kMaxTurnAccelerationDegPerSSquared = 300;

    public static final double kTurnToleranceDeg = 1;
    public static final double kTurnRateToleranceDegPerS = 1; // degrees per second

    public static final double kLL_LR_Offset = 20;
    public static final double kLL_Fwd_Offset = 13;
    public static final double kLL_Tolerance = 4;
    public static final double kLLTransitionalSpeed = 150; // amount to divide the output by to slow the robot
    public static final double kLLRotationalSpeed = 100;

    public static final double kMaxChange = .5;

    // Driving Parameters - Note that these are not the maximum capable speeds of
    // the robot, rather the allowed maximum speeds
    public static final double kMaxSpeedMetersPerSecond = 4.8;
    public static final double kMaxAngularSpeed = 2 * Math.PI; // radians per second

    // Chassis configuration
    public static final double kTrackWidth = Units.inchesToMeters(21.5);
    // Distance between centers of right and left wheels on robot
    public static final double kWheelBase = Units.inchesToMeters(26.5);
    // Distance between front and back wheels on robot

    public static final double kDirectionSlewRate = 1.2; // radians per second
    public static final double kMagnitudeSlewRate = 1.8; // percent per second (1 = 100%) (originally 1.8)
    public static final double kRotationalSlewRate = 2.0; // percent per second (1 = 100%) (originally 2.0)

    public static final SwerveDriveKinematics kDriveKinematics = new SwerveDriveKinematics(
        new Translation2d(kWheelBase / 2, kTrackWidth / 2),
        new Translation2d(kWheelBase / 2, -kTrackWidth / 2),
        new Translation2d(-kWheelBase / 2, kTrackWidth / 2),
        new Translation2d(-kWheelBase / 2, -kTrackWidth / 2));

    // Angular offsets of the modules relative to the chassis in radians
    public static final double kFrontLeftChassisAngularOffset = -Math.PI / 2;
    public static final double kFrontRightChassisAngularOffset = 0;
    public static final double kBackLeftChassisAngularOffset = Math.PI;
    public static final double kBackRightChassisAngularOffset = Math.PI / 2;

    // SPARK MAX CAN IDs
    public static final int kFrontLeftDrivingCanId = 1;
    public static final int kFrontLeftTurningCanId = 2;

    public static final int kFrontRightDrivingCanId = 3;
    public static final int kFrontRightTurningCanId = 4;

    public static final int kBackLeftDrivingCanId = 5;
    public static final int kBackLeftTurningCanId = 6;

    public static final int kBackRightDrivingCanId = 7;
    public static final int kBackRightTurningCanId = 8;

    public static final boolean kGyroReversed = false;
  }

  public static final class ArmConstants {
    public static final double kArmP = 0.01;
    public static final double kArmI = 0;
    public static final double kArmD = 0;
    public static final double kArmIz = 0;
    public static final double kArmFF = 0;
    public static final double kArmMinOutput = -1;
    public static final double kArmMaxOutput = 1;
    public static final double kArmPositionFactor = 2;
    public static final int kArmCanId = 9;
    public static final double kHybridHeight = 1.77;
    public static final double kMidHeight = 3.75;
    public static final double kHighHeight = 4.15;
    public static final double kLowerHeight = 0.3;
    public static final double kLoweringSpeed = 1;
    public static final double kRaisingSpeed = 1;
  }

  public static final class ModuleConstants {
    // The MAXSwerve module can be configured with one of three pinion gears: 12T,
    // 13T, or 14T.
    // This changes the drive speed of the module (a pinion gear with more teeth
    // will result in a
    // robot that drives faster).
    public static final int kDrivingMotorPinionTeeth = 14;

    // Invert the turning encoder, since the output shaft rotates in the opposite
    // direction of
    // the steering motor in the MAXSwerve Module.
    public static final boolean kTurningEncoderInverted = true;

    // Calculations required for driving motor conversion factors and feed forward
    public static final double kDrivingMotorFreeSpeedRps = NeoMotorConstants.kFreeSpeedRpm / 60;
    public static final double kWheelDiameterMeters = 0.0762;
    public static final double kWheelCircumferenceMeters = kWheelDiameterMeters * Math.PI;
    // 45 teeth on the wheel's bevel gear, 22 teeth on the first-stage spur gear, 15
    // teeth on the bevel pinion
    public static final double kDrivingMotorReduction = (45.0 * 22) / (kDrivingMotorPinionTeeth * 15);
    public static final double kDriveWheelFreeSpeedRps = (kDrivingMotorFreeSpeedRps * kWheelCircumferenceMeters)
        / kDrivingMotorReduction;

    public static final double kDrivingEncoderPositionFactor = (kWheelDiameterMeters * Math.PI)
        / kDrivingMotorReduction; // meters
    public static final double kDrivingEncoderVelocityFactor = ((kWheelDiameterMeters * Math.PI)
        / kDrivingMotorReduction) / 60.0; // meters per second

    public static final double kTurningEncoderPositionFactor = (2 * Math.PI); // radians
    public static final double kTurningEncoderVelocityFactor = (2 * Math.PI) / 60.0; // radians per second

    public static final double kTurningEncoderPositionPIDMinInput = 0; // radians
    public static final double kTurningEncoderPositionPIDMaxInput = kTurningEncoderPositionFactor; // radians

    public static final double kDrivingP = 0.04;
    public static final double kDrivingI = 0;
    public static final double kDrivingD = 0;
    public static final double kDrivingFF = 1 / kDriveWheelFreeSpeedRps;
    public static final double kDrivingMinOutput = -1;
    public static final double kDrivingMaxOutput = 1;

    public static final double kTurningP = 1;
    public static final double kTurningI = 0;
    public static final double kTurningD = 0;
    public static final double kTurningFF = 0;
    public static final double kTurningMinOutput = -1;
    public static final double kTurningMaxOutput = 1;

    public static final IdleMode kDrivingMotorIdleMode = IdleMode.kBrake;
    public static final IdleMode kTurningMotorIdleMode = IdleMode.kBrake;

    public static final int kDrivingMotorCurrentLimit = 30; // amps
    public static final int kTurningMotorCurrentLimit = 20; // amps
  }

  public static final class OIConstants {
    public static final int kDriverControllerPort = 0;
    public static final double kDriveDeadband = 0.10;
    public static final double kTurnDeadband = 0.10;
  }

  public static final class AutoConstants {

    public static HashMap<String, Command> eventMap = new HashMap<String, Command>();

    public static final double kPathVelocity = 2;
    public static final double kPathAcceleration = 2;

    public static final double kAppPathVelocity = 1;
    public static final double kAppPathAcceleration = 1;

    public static final double kFastPathVelocity = 4;
    public static final double kFastPathAcceleration = 3;

    public static final double kChargePathVelocity = 3;
    public static final double kChargePathAcceleration = 3;

    public static final double kDrivingP = .04;
    public static final double kDrivingI = 0;
    public static final double kDrivingD = 0;

    public static final double kTurningP = 1;
    public static final double kTurningI = 0;
    public static final double kTurningD = 0;

    public static final double kMaxSpeedMetersPerSecond = 3;
    public static final double kMaxAccelerationMetersPerSecondSquared = 3;
    public static final double kMaxAngularSpeedRadiansPerSecond = Math.PI;
    public static final double kMaxAngularSpeedRadiansPerSecondSquared = Math.PI;

    public static final double kPXController = 1;
    public static final double kPYController = 1;
    public static final double kPThetaController = 1;

    // Constraint for the motion profiled robot angle controller
    public static final TrapezoidProfile.Constraints kThetaControllerConstraints = new TrapezoidProfile.Constraints(
        kMaxAngularSpeedRadiansPerSecond, kMaxAngularSpeedRadiansPerSecondSquared);
  }

  public static final class NeoMotorConstants {
    public static final double kFreeSpeedRpm = 5676;
  }
}