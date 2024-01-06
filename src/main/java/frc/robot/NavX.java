/**
 * This code is based on REV Robotics' MaxSwerve-Java-Template which is available at https://github.com/REVrobotics/MAXSwerve-Java-Template
 */

package frc.robot;

import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.SerialPort;

public class NavX {
	SerialPort serial;
	private AHRS imu;

	public NavX() {
		try {
			imu = new AHRS(SPI.Port.kMXP);
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}

	public float getYaw() {
		return -imu.getYaw();
	}

	public float getPitch() {
		return imu.getPitch();
	}

	public float getRoll() {
		return imu.getRoll();
	}

	public double getRate() {
		return imu.getRate();
	}

	public boolean isCalibrating() {
		return imu.isCalibrating();
	}

	public void test() {
		System.out.println(
				"Pitch: " + Math.round(imu.getPitch()) +
						" Roll: " + Math.round(imu.getRoll()) +
						" Yaw: " + Math.round(imu.getYaw()));
	}

	public void zeroYaw() {
		imu.zeroYaw();
	}
}
