package Behavioural_Pattern.Command;

//receiver's Commands 
public class AcOnCommand implements ICommand {

    private AC ac;

    public AcOnCommand(AC ac) {
        this.ac = ac;
    }

    @Override
    public void execute() {
        ac.on();
    }

    @Override
    public void undo() {
        ac.off(); // oppsite to execute
    }
}
