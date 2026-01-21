package Behavioural_Pattern.Command;

//Client who will create commands and executes them whenevr required 
public class CommandExecutor {
    public static void main(String[] args) {

        // Receiver product who receives commands
        AC ac = new AC();
        Light light = new Light();

        // Creating different types of commands
        ICommand lightOnCommand = new LightOnCommand(light);
        ICommand lightOffCommand = new LightOffCommand(light);
        ICommand acOnCommand = new AcOnCommand(ac);
        ICommand acOffCommand = new AcOffCommand(ac);

        // setting the commands to invoker [Remote ]
        Remote_Invoker remote = new Remote_Invoker();
        remote.setCommand(0, lightOnCommand);
        remote.setCommand(1, lightOffCommand);
        remote.setCommand(2, acOnCommand);
        remote.setCommand(3, acOffCommand);

        // executing the commands in remote
        System.out.println();
        remote.pressButton(10); // should say command not found since command not added
        remote.pressButton(0); // light on
        remote.pressButton(1); // light off
        remote.pressButton(2); // Ac on
        remote.pressButton(3); // AC Off

        // few undo operation
        System.out.println();
        remote.pressUndo(); // AC shoud ON
        remote.pressUndo(); // AC shoud OFF
        remote.pressUndo(); // light on
        remote.pressUndo(); // light OFF
        remote.pressUndo(); // No cammands

    }
}
