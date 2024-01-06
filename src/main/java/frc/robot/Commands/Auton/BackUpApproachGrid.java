
package frc.robot.commands.Auton;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import com.pathplanner.lib.PathPlanner;
import com.pathplanner.lib.PathConstraints;
import com.pathplanner.lib.PathPlannerTrajectory;

import frc.robot.Constants.AutoConstants;
import frc.robot.subsystems.DriveTrain;

public class BackUpApproachGrid extends SequentialCommandGroup {

    public BackUpApproachGrid(DriveTrain subsystem) {

        PathPlannerTrajectory appGrid = PathPlanner.loadPath("Back Up Approach Grid",
                new PathConstraints(AutoConstants.kAppPathVelocity, AutoConstants.kAppPathAcceleration));
        addCommands(
                subsystem.followTrajectoryCommand(appGrid, true));
    }
}
