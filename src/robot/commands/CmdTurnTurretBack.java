package robot.commands;
import edu.wpi.first.wpilibj2.command.CommandBase;
import robot.subsystems.TurntableSubsystem;

public class CmdTurnTurretBack extends CommandBase {
    private TurntableSubsystem m_turnTurretBack;
    private double power = -0.6;

    public CmdTurnTurretBack() {
        m_turnTurretBack = TurntableSubsystem.getInstance();
        
        addRequirements(m_turnTurretBack);
    }

    @Override 
    public void initialize(){
        m_turnTurretBack.setPower(power);
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
        m_turnTurretBack.setPower(0);
    }
}
