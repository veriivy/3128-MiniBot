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


package robot;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import robot.subsystems.DriveSubsystem;
import robot.subsystems.FeederSubsystem;
import robot.subsystems.ShooterSubsystem;
import robot.subsystems.TurntableSubsystem;
import robotCore.Joystick;

import robot.commands.CmdFeedAndShoot;
import robot.commands.CmdTurnTurret;
import robot.commands.CmdTurnTurretBack;
import robot.commands.CmdArcadeDrive;

/**
 * This class is where the bulk of the robot should be declared. Since
 * Command-based is a "declarative" paradigm, very little robot logic should
 * actually be handled in the {@link Robot} periodic methods (other than the
 * scheduler calls). Instead, the structure of the robot (including subsystems,
 * commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  private Joystick m_joystick;
  private JoystickButton m_b1, m_b2, m_b3;

  private ShooterSubsystem m_shooter;
  private DriveSubsystem m_drive;
  private FeederSubsystem m_feed;
  private TurntableSubsystem m_turn;

  // Defines Subsystems and Commands

  public void configJoyStick(){
  //creating objects for each joystick button
    m_joystick = new Joystick(0);
    m_b1 = new JoystickButton(m_joystick, 1);
    m_b2 = new JoystickButton(m_joystick, 2);
    m_b3 = new JoystickButton(m_joystick, 3);
  }

  public void configSubsystem(){
  //creating objects for each subsystem
    m_drive = DriveSubsystem.getInstance();
    m_shooter = ShooterSubsystem.getInstance();
    m_feed = FeederSubsystem.getInstance();
    m_turn = TurntableSubsystem.getInstance();
  }
  /**
   * The container for the robot. Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    configJoyStick();
    configSubsystem();
    configureButtonBindings();

    //TODO this line assigns drive command as the default command
    //m_drive.setDefaultCommand(new CmdArcadeDrive(m_drive, m_joystick));
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be
   * created by instantiating a {@link GenericHID} or one of its subclasses
   * ({@link edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then
   * passing it to a {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    // assigns commands to buttons 
    // TODO change buttons
    m_b1.whileHeld(new CmdFeedAndShoot());
    m_b2.whileHeld(new CmdTurnTurret());
    m_b3.whileHeld(new CmdTurnTurretBack());
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return null;
  }
}
