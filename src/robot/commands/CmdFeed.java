package robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import robot.subsystems.FeederSubsystem;

public class CmdFeed extends CommandBase {
    private FeederSubsystem m_feed;
    private double power = 0.6;

    public CmdFeed() {
        m_feed = FeederSubsystem.getInstance();
        
        addRequirements(m_feed);
    }

    @Override 
    public void initialize(){
        m_feed.setPower(power);
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
        m_feed.setPower(0);
    }
}
