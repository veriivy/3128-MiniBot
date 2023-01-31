package robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import robot.subsystems.TurntableSubsystem;

public class CmdTurnTurret extends CommandBase {
    private TurntableSubsystem m_turnTurret;
    private double power;

    public CmdTurnTurret(double p) {
        m_turnTurret = TurntableSubsystem.getInstance();
        power = p;
        
        addRequirements(m_turnTurret);
    }

    @Override 
    public void initialize(){
        m_turnTurret.setPower(power);
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
        m_turnTurret.setPower(0);
    }
}
