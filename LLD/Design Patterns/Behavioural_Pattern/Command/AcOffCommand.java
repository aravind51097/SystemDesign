package Behavioural_Pattern.Command;


//receiver's Commands 
public class AcOffCommand implements ICommand {

    private AC ac;

    public AcOffCommand(AC ac) {
        this.ac = ac;
    }

    @Override
    public void execute() {
        ac.off();
    }

    @Override
    public void undo() {
        ac.on(); // oppsite to execute
    }

}
