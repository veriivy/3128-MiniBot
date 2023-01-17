package robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import robot.subsystems.DriveSubsystem;
import robotCore.Joystick;

public class CmdArcadeDrive extends CommandBase {
    private DriveSubsystem m_drive;
    private double power;

    public CmdArcadeDrive() {
        m_drive = DriveSubsystem.getInstance();

        addRequirements(m_drive);
    }

    @Override 
    public void initialize(){
    
    }

    @Override 
    public void execute(){
        /* 
        x = x * Math.abs(x) * 0.5;
        y = y * Math.abs(y);

        m_drive.setPower(y + x, y - x);
        */
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
