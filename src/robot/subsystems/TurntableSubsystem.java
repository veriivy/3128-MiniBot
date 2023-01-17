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
import static robot.Constants.TurnTableConstants.*;


public class TurntableSubsystem extends SubsystemBase {
	private static TurntableSubsystem turn;
	

	private PWMMotor m_motor;
	private Encoder m_encoder;

	public static synchronized TurntableSubsystem getInstance(){
		if (turn == null) {
			turn = new TurntableSubsystem();
		}
		return turn;
	  }

	public void setPower(double power){
		m_motor.set(power);
	}
	public int getEncoder(){
		return (m_encoder.get());
	}

	public TurntableSubsystem() {
		Logger.log("TurntableSubsystem", 2, "TurntableSubsystem()");

		m_motor = new PWMMotor(k_PWMPin, k_DirPin);
		m_encoder = new Encoder(EncoderType.Quadrature, k_encoderIntPin, k_encoderDirPin);
	}

	public void initDefaultCommand() {
		Logger.log("TurntableSubsystem", 2, "initDefaultCommand()");
	}


	@Override
	public void periodic() {
		Logger.log("TurntableSubsystem", -1, "periodic()");
	}
}
