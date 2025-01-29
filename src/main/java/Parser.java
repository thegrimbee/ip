import java.util.Scanner;

public class Parser {
    public static parseCommand(String commandString) throws KyrieException {
        String[] commandParts = commandString.split(" ");
        String command = commandParts[0];
        switch (command) {
            case "bye":
                return new ByeCommand();
            case "list":
                return new ListCommand();
            case "mark":
                if (commandParts.length != 2) {
                    throw new KyrieException("Invalid task number");
                }
                return new MarkCommand(Integer.parseInt(commandParts[1]), true);
            case "unmark":
                if (commandParts.length != 2) {
                    throw new KyrieException("Invalid task number");
                }
                return new MarkCommand(Integer.parseInt(commandParts[1]), false);
            case "todo":
                if (commandParts.length != 2) {
                    throw new KyrieException("Invalid task description");
                }
                return new AddTodoCommand(commandParts[1]);
            case "deadline":
                if (commandParts.length != 4) {
                    throw new KyrieException("Invalid task description");
                }
                String dateTimeParts = commandString.split(" /by ");
                if (dateTimeParts.length != 2) {
                    throw new KyrieException("Invalid task description");
                }
                return new AddDeadlineCommand(commandParts[1], new DateTime(dateTimeParts[1]));
            case "event":
                if (commandParts.length != 4) {
                    throw new KyrieException("Invalid task description");
                }
                String[] dateTimeParts = commandString.split(" /from ");
                if (dateTimeParts.length != 2) {
                    throw new KyrieException("Invalid task description");
                }
                String[] periodParts = dateTimeParts[1].split(" /to ");
                if (periodParts.length != 2) {
                    throw new KyrieException("Invalid task description");
                }
                return new AddEventCommand(commandParts[1], new DateTime(periodParts[0]), new DateTime(periodParts[1]));
            case "delete":
                if (commandParts.length != 2) {
                    throw new KyrieException("Invalid task number");
                }
                return new DeleteCommand(Integer.parseInt(commandParts[1]));
            default:
                throw new KyrieException("It seems you have entered an invalid command");
        }
    }


}