// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.Drives;

import edu.wpi.first.math.controller.PIDController;
import frc.robot.Constants.DriveConstants;
import frc.robot.subsystems.DriveTrain;
import edu.wpi.first.wpilibj2.command.PIDCommand;
import edu.wpi.first.math.MathUtil;
import frc.robot.RobotContainer;
import frc.robot.Constants.*;

/** A command that will turn the robot to the specified angle. */
public class TurnToAngle extends PIDCommand {
  /**
   * Turns to robot to the specified angle.
   *
   * @param targetAngleDegrees The angle to turn to
   * @param drive              The drive subsystem to use
   */
  public TurnToAngle(double targetAngleDegrees, DriveTrain drive) {
    super(
        new PIDController(DriveConstants.kTurnP, DriveConstants.kTurnI, DriveConstants.kTurnD),
        // Close loop on heading
        drive::getHeading,
        // Set reference to target
        targetAngleDegrees,
        // Pipe output to turn robot
        output -> drive.setDrive(
            MathUtil.applyDeadband(RobotContainer.getInstance().getdriverController().getLeftY(),
                OIConstants.kDriveDeadband),
            MathUtil.applyDeadband(RobotContainer.getInstance().getdriverController().getLeftX(),
                OIConstants.kDriveDeadband),
            // 0,0,
            output, true, false),
        // Require the drive
        drive);

    // Set the controller to be continuous (because it is an angle controller that
    // can rollover)
    getController().enableContinuousInput(-180, 180);
    // Set controller tolerance - the delta tolerance ensures the robot is
    // stationary at the setpoint before it is considered as having reached the
    // reference
    getController()
        .setTolerance(DriveConstants.kTurnToleranceDeg, DriveConstants.kTurnRateToleranceDegPerS);
  }

  @Override
  public boolean isFinished() {
    // End when the controller is at the reference.
    return getController().atSetpoint();
  }
}
