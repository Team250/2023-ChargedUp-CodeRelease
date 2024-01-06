// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.SerialPort;
import edu.wpi.first.wpilibj.DriverStation.Alliance;
import edu.wpi.first.wpilibj.SerialPort.Port;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class LightsSubsystem extends SubsystemBase {

  private SerialPort lightController;
  private boolean isLightControllerConnected = false;
  private int cycle = 0;
  private Alliance alliance = Alliance.Blue;
  private boolean isHumanFeedback = false;
  private HumanFeedback rearHF = HumanFeedback.Black;
  private boolean feedbackHasChanged = true;
  private String char1 = "0";
  private String char2 = "0";
  private String char3 = "0";
  private String char4 = "0";

  public enum HumanFeedback {
    Black, Yellow, Purple, Green
  }

  /** Creates a new ExampleSubsystem. */
  public LightsSubsystem() {
    // attempt to connect to LED controller
    initConnection();
  }

  /**
   * Attempt to connect to the LED Controller via USB, report progress via console
   */
  private boolean initConnection() {
    try {
      lightController = new SerialPort(115200, Port.kUSB);
      System.out.println("Connected on kUSB!");
    } catch (Exception e) {
      System.out.println("Failed to connect on kUSB, trying kUSB1");
      try {
        lightController = new SerialPort(115200, Port.kUSB1);
        System.out.println("Connected on kUSB1!");
      } catch (Exception e1) {
        System.out.println("Failed to connect on kUSB1, trying kUSB2");
        try {
          lightController = new SerialPort(115200, Port.kUSB2);
          System.out.println("Connected on kUSB2!");
        } catch (Exception e2) {
          System.out.println("Failed to connect on kUSB2, all USB connections attempted");
          isLightControllerConnected = false;
          return false;
        }
      }
    }
    isLightControllerConnected = true;
    return true;
  }

  /** If connected, attempt to send data to the LED Controller */
  private boolean sendToLightController(String data) {
    if (!isLightControllerConnected) {
      return false;
    }
    try {
      lightController.writeString(data + "\r");
      return true;
    } catch (Exception e) {
      System.out.println(e.toString());
      System.out.println("Light Controller Not Connected, Write Failed");
      isLightControllerConnected = false;
      return false;
    }
  }

  // ** Check for data sent back from the LED controller */
  private boolean isMessagePending() {
    if (!isLightControllerConnected) {
      return false;
    }
    try {
      return lightController.getBytesReceived() > 0;
    } catch (Exception e) {
      isLightControllerConnected = false;
      return false;
    }
  }

  // ** Read data sent by LED controller */
  private String readFromLightController() {
    if (!isLightControllerConnected) {
      return "Light Controller Not Connected, Read Skipped";
    }
    if (isMessagePending()) {
      try {
        return lightController.readString();
      } catch (Exception e) {
        isLightControllerConnected = false;
        return "Light Controller Read Failed";
      }
    } else {
      return "Nothing to read";
    }
  }

  @Override
  public void periodic() {
    cycle++;

    // Run LED Controller periodic tasks approximitly twice a second
    if (cycle > 24) {
      // Only send updated to LED controller if desired color/display has changed
      // since the last run
      if (feedbackHasChanged == true) {
        // Reset Output Chars
        char1 = "0";
        char2 = "0";
        char3 = "0";
        char4 = "0";

        // Set Output Chars
        switch (getRearHumanFeedback()) {
          case Black:
            char3 = "0";
            break;
          case Yellow:
            char3 = "3";
            break;
          case Purple:
            char3 = "7";
            break;
          case Green:
            char3 = "4";
            break;
        }

        if (isDisplayModeHuman() == false) {
          char2 = "A";
        } else {
          char2 = "H";
        }

        if (getRearAlliance() == Alliance.Red) {
          char1 = "R";
        } else {
          char1 = "B";
        }

        sendToLightController(char1 + char2 + char3 + char4);
        readFromLightController();
        feedbackHasChanged = false;
      }
      cycle = 0;
      SmartDashboard.putString("Light String: ", char1 + char2 + char3 + char4);
    }
  }

  public void setRearHumanFeedback(HumanFeedback hf) {
    if (hf != rearHF) {
      feedbackHasChanged = true;
    }
    rearHF = hf;
  }

  public HumanFeedback getRearHumanFeedback() {
    return rearHF;
  }

  public void setRearAlliance(Alliance setAlliance) {
    if (setAlliance != alliance) {
      feedbackHasChanged = true;
    }
    alliance = setAlliance;
  }

  public Alliance getRearAlliance() {
    return alliance;
  }

  public void setDisplayMode(boolean isHumanMode) {
    if (isHumanMode != isHumanFeedback) {
      feedbackHasChanged = true;
    }
    isHumanFeedback = isHumanMode;
  }

  public boolean isDisplayModeHuman() {
    return isHumanFeedback;
  }
}