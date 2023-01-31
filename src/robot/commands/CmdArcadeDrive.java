package robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import robot.subsystems.DriveSubsystem;
import robotCore.Joystick;
import java.util.HashMap;
import java.util.Map;

import javax.tools.ForwardingFileObject;

import java.lang.String;

public class CmdArcadeDrive extends CommandBase {
    private DriveSubsystem m_drive;
    private double power = 0.6;
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
    
        m_drive.setPower(m_joystick.getY() + m_joystick.getX() , m_joystick.getY() - m_joystick.getX());

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
