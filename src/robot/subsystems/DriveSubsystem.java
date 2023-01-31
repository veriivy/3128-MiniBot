/*
 *	  Copyright (C) 2022  John H. Gaby
 *
 *    This program is free software: you can redistribute it and/or modify
 *    it under the terms of the GNU General Public License as published by
 *    the Free Software Foundation, version 3 of the License.
 *
 *    This program is distributed in the hope that it will be useful,
 *    but WITHOUT ANY WARRANTY; without even the implied warranty of
 *    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *    GNU General Public License for more details.
 *
 *    You should have received a copy of the GNU General Public License
 *    along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *    
 *    Contact: robotics@gabysoft.com
 */


package robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import robotCore.Encoder;
import robotCore.Logger;
import robotCore.PWMMotor;
import robotCore.Encoder.EncoderType;
import static robot.Constants.DrivetrainConstants.*;

public class DriveSubsystem extends SubsystemBase {
  private static DriveSubsystem drive;


  //Creates objects for both motors and encoders
  private PWMMotor m_leftMotor, m_rightMotor;
  private Encoder m_leftEncoder, m_rightEncoder;

  public DriveSubsystem() {
    Logger.log("DriveSubsystem", 3, "DriveSubsystem()");

    configMotors();
    configEncoders();
    m_leftEncoder.setInverted(true); //inverts left encoder
  }

    //If there is no instance, create a new instance
    public static synchronized DriveSubsystem getInstance(){
      if (drive == null) {
          drive = new DriveSubsystem();
      }
      return drive;
    }

  private void configMotors(){
    m_leftMotor = new PWMMotor(k_leftMotorPWMPin, k_leftMotorDirPin);
    m_rightMotor = new PWMMotor(k_rightMotorPWMPin, k_rightMotorDirPin);
  }

  private void configEncoders(){
    m_leftEncoder = new Encoder(EncoderType.Quadrature, k_leftEncoderIntPin, k_leftEncoderDirPin);
    m_rightEncoder = new Encoder(EncoderType.Quadrature, k_rightEncoderIntPin, k_rightEncoderDirPin);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    Logger.log("DriveSubsystem", -1, "periodic()");
  }

  //sets power of both motors
  public void setPower(double leftPower, double rightPower){
    m_leftMotor.set(leftPower);
    m_rightMotor.set(rightPower);
  }

  //methods to get left and right encoders
  public int getLeftEncoder(){
    return (m_leftEncoder.get());
  }
  public int getRightEncoder(){
    return (m_rightEncoder.get());
  }
}
