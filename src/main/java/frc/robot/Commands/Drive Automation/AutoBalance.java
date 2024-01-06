// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.Autos;

import frc.robot.subsystems.DriveTrain;
import edu.wpi.first.wpilibj2.command.CommandBase;

/** Robot will atempt to ballance itself on the charge station */
public class AutoBalance extends CommandBase {
  private final DriveTrain m_driveTrain;

  public AutoBalance(DriveTrain subsystem) {
    m_driveTrain = subsystem;
    addRequirements(m_driveTrain);
  }

  public void execute() {
    double roll = m_driveTrain.getRoll();
    if (Math.abs(roll) <= 12) {
      m_driveTrain.setDrive(0, 0, 0, true, false);
    } else {
      m_driveTrain.setDrive(roll / 135, 0, 0, true, false);
    }
  }

  @Override
  public boolean isFinished() {
    return false;
  }

  public void end(boolean interrupted) {
    m_driveTrain.setDrive(0, 0, 0, true, true);
    m_driveTrain.setX();
  }
}
