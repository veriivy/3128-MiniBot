package robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import robot.subsystems.DriveSubsystem;
import robotCore.Joystick;

public class CmdArcadeDrive extends CommandBase {
    private DriveSubsystem m_drive;
    private Joystick m_joystick;

    public CmdArcadeDrive(Joystick joystick) {
        m_drive = DriveSubsystem.getInstance();
        m_joystick = joystick;

        addRequirements(m_drive);
    }

    @Override 
    public void initialize(){
    
    }

    @Override 
    public void execute(){
        //forward Y negative, left Y negative
        if (m_joystick.getX() <= 0) {
            m_drive.setPower((m_joystick.getY() * 0.75), (m_joystick.getY() * 0.75 + Math.abs(m_joystick.getX()) * 0.25));
        } else {
            m_drive.setPower((m_joystick.getY() * 0.75 + Math.abs(m_joystick.getX()) * 0.25), (m_joystick.getY() * 0.75));
        }
        // double filteredX = m_joystick.getX() * Math.abs(m_joystick.getX()) * 0.5;
        // double filteredY = m_joystick.getY() * Math.abs(m_joystick.getY());
        // m_drive.setPower(filteredY + filteredX, filteredY - filteredX);

    }

    @Override
    public boolean isFinished(){
        return (false);
    }

    @Override
    public void end(boolean interrupted){
        m_drive.setPower(0, 0);
    }
}
