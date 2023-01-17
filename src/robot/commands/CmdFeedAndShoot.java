package robot.commands;
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;


public class CmdFeedAndShoot extends ParallelCommandGroup{

    public CmdFeedAndShoot(){
        addCommands(
            new CmdShoot(),
            new CmdFeed()
        );
    }
}
