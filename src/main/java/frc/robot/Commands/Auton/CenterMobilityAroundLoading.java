// RobotBuilder Version: 5.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.

// ROBOTBUILDER TYPE: Command.

package frc.robot.commands.Auton;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import com.pathplanner.lib.PathPlanner;
import com.pathplanner.lib.PathConstraints;
import com.pathplanner.lib.PathPlannerTrajectory;
import com.pathplanner.lib.commands.FollowPathWithEvents;
import frc.robot.Constants.AutoConstants;

import frc.robot.subsystems.DriveTrain;

// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS

/**
 *
 */
public class CenterMobilityAroundLoading extends SequentialCommandGroup {

    public CenterMobilityAroundLoading(DriveTrain subsystem) {

        PathPlannerTrajectory centerMobilityAroundLoading = PathPlanner.loadPath("Center Mobility Around Loading",
                new PathConstraints(AutoConstants.kPathVelocity, AutoConstants.kPathAcceleration));
        addCommands(
                new FollowPathWithEvents(subsystem.followTrajectoryCommand(centerMobilityAroundLoading, true),
                        centerMobilityAroundLoading.getMarkers(), AutoConstants.eventMap));
    }
}