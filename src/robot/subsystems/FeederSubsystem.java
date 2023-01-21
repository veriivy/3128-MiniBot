/*
 *	  Copyright (C) 2016  John H. Gaby
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
import robotCore.Encoder.EncoderType;
import robotCore.Logger;
import robotCore.PWMMotor;
import static robot.Constants.FeederConstants.*;


public class FeederSubsystem extends SubsystemBase {
	private static FeederSubsystem feed;

	private PWMMotor m_motor;
	private Encoder m_encoder;
	private int speed;

	public FeederSubsystem() {
		Logger.log("FeederSubsystem", 2, "Constructor");

		m_motor = new PWMMotor(k_PWMPin, k_DirPin);
		m_encoder = new Encoder(EncoderType.Quadrature, k_encPin1, k_encPin2);
	}

	public static synchronized FeederSubsystem getInstance(){
		if (feed == null) {
			feed = new FeederSubsystem();
		}
		return feed;
	  }

	public void initDefaultCommand() {
		Logger.log("FeederSubsystem", 2, "initDefaultCommand()");
	}


	public void setPower(double power){
		m_motor.set(power);
	}
	public int getEncoder(){
		return (m_encoder.get());
	}

	public int getSpeed(){
		speed = m_encoder.getSpeed();
		return speed;
		
	}

	@Override
	public void periodic() {
		// This method will be called once per scheduler run
	}
}
