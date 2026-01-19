package Behavioural_Pattern.Command;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//A invoker who will be invoking the commands without context of type of command and Receiver 
public class Remote_Invoker {
    private List<ICommand> commands = new ArrayList<>();
    private Stack<ICommand> commandHistory = new Stack<>();

    public void setCommand(int slot, ICommand command) {
        commands.add(slot, command);
    }

    public void pressButton(int slot) {
        if (slot < commands.size() && commands.get(slot) != null) {
            commands.get(slot).execute();
            commandHistory.push(commands.get(slot));
        } else {
            System.out.println("command not found ");
        }
    }

    public void pressUndo() {
        if (commandHistory.size() > 0) {
            commandHistory.pop().undo();
        } else {
            System.out.println("No commands for Undo");
        }
    }

}
