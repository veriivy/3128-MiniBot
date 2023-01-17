package robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import robot.subsystems.ShooterSubsystem;


public class CmdShoot extends CommandBase {
    private ShooterSubsystem m_shooter;
    private double power = 0.6;
    

    public CmdShoot() {
        m_shooter = ShooterSubsystem.getInstance();
        
        addRequirements(m_shooter);
    }

    @Override 
    public void initialize(){
        m_shooter.setPower(power);
    }

    @Override 
    public void execute(){
    
    }

    @Override
    public boolean isFinished(){
        return (false);
    }

    @Override
    public void end(boolean interrupted){
        m_shooter.setPower(0);
    }
}
