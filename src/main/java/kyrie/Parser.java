package kyrie;

/**
 * Represents a parser to parse commands.
 */
public class Parser {
    /**
     * Parses the Bye command string and returns the corresponding command object.
     * 
     * @param commandString The command string to parse.
     * @return The corresponding command object.
     */
    public static ByeCommand parseByeCommand(String commandString) {
        return new ByeCommand();
    }

    /**
     * Parses the List command string and returns the corresponding command object.
     * 
     * @param commandString The command string to parse.
     * @return The corresponding command object.
     */
    public static ListCommand parseListCommand(String commandString) {
        return new ListCommand();
    }

    /**
     * Parses the Mark command string and returns the corresponding command object.
     * 
     * @param commandString The command string to parse.
     * @return The corresponding command object.
     * @throws KyrieException If the task number is invalid.
     */
    public static MarkCommand parseMarkCommand(String commandString) throws KyrieException {
        String[] commandParts = commandString.split(" ");
        if (commandParts.length != 2) {
            throw new KyrieException("Invalid task number");
        }
        return new MarkCommand(Integer.parseInt(commandParts[1]));
    }

    /**
     * Parses the Unmark command string and returns the corresponding command object.
     * 
     * @param commandString The command string to parse.
     * @return The corresponding command object.
     * @throws KyrieException If the task number is invalid.
     */
    public static UnmarkCommand parseUnmarkCommand(String commandString) throws KyrieException {
        String[] commandParts = commandString.split(" ");
        if (commandParts.length != 2) {
            throw new KyrieException("Invalid task number");
        }
        return new UnmarkCommand(Integer.parseInt(commandParts[1]));
    }

    /**
     * Parses the Todo command string and returns the corresponding command object.
     * 
     * @param commandString The command string to parse.
     * @return The corresponding command object.
     * @throws KyrieException If the task description is invalid.
     */
    public static AddTodoCommand parseTodoCommand(String commandString) throws KyrieException {
        String[] commandParts = commandString.split(" ");
        if (commandParts.length != 2) {
            throw new KyrieException("Invalid task description");
        }
        return new AddTodoCommand(commandParts[1]);
    }

    /**
     * Parses the Deadline command string and returns the corresponding command object.
     * 
     * @param commandString The command string to parse.
     * @return The corresponding command object.
     * @throws KyrieException If the task description is invalid.
     */
    public static AddDeadlineCommand parseDeadlineCommand(String commandString) throws KyrieException {
        String[] commandParts = commandString.split(" ");
        if (commandParts.length < 4) {
            throw new KyrieException("Invalid task description");
        }
        String[] dateTimeParts = commandString.split(" /by ");
        if (dateTimeParts.length != 2) {
            throw new KyrieException("Invalid task description");
        }
        return new AddDeadlineCommand(commandParts[1], new DateTime(dateTimeParts[1]));
    }

    /**
     * Parses the Event command string and returns the corresponding command object.
     * 
     * @param commandString The command string to parse.
     * @return The corresponding command object.
     * @throws KyrieException If the task description is invalid.
     */
    public static AddEventCommand parseEventCommand(String commandString) throws KyrieException {
        String[] commandParts = commandString.split(" ");
        if (commandParts.length < 5) {
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
    }

    /**
     * Parses the Delete command string and returns the corresponding command object.
     * 
     * @param commandString The command string to parse.
     * @return The corresponding command object.
     * @throws KyrieException If the task number is invalid.
     */
    public static DeleteCommand parseDeleteCommand(String commandString) throws KyrieException {
        String[] commandParts = commandString.split(" ");
        if (commandParts.length != 2) {
            throw new KyrieException("Invalid task number");
        }
        return new DeleteCommand(Integer.parseInt(commandParts[1]));
    }

    /**
     * Parses the Find command string and returns the corresponding command object.
     * 
     * @param commandString The command string to parse.
     * @return The corresponding command object.
     * @throws KyrieException If the search query is invalid.
     */
    public static FindCommand parseFindCommand(String commandString) throws KyrieException {
        String[] commandParts = commandString.split(" ");
        if (commandParts.length < 2) {
            throw new KyrieException("Invalid search query");
        }
        return new FindCommand(commandString.substring(5));
    }

    public static TagCommand parseTagCommand(String commandString) throws KyrieException {
        String[] commandParts = commandString.split(" ");
        if (commandParts.length < 3) {
            throw new KyrieException("Invalid tag query");
        }
        return new TagCommand(Integer.parseInt(commandParts[1]), commandParts[2]);
    }

    /**
     * Parses the Invalid command string and returns the corresponding command object.
     * 
     * @param commandString The command string to parse.
     * @return The corresponding command object.
     * @throws KyrieException If the command string is invalid.
     */
    public static Command parseInvalidCommand(String commandString) throws KyrieException {
        throw new KyrieException("It seems you have entered an invalid command");
    }

    /**
     * Parses the command string and returns the corresponding command object.
     * 
     * @param commandString The command string to parse.
     * @return The corresponding command object.
     * @throws KyrieException If the command string is invalid.
     */
    public static Command parseCommand(String commandString) throws KyrieException {
        String[] commandParts = commandString.split(" ");
        String command = commandParts[0];
        switch (command) {
        case "bye":
            return parseByeCommand(commandString);
        case "list":
            return parseListCommand(commandString);
        case "mark":
            return parseMarkCommand(commandString);
        case "unmark":
            return parseUnmarkCommand(commandString);
        case "todo":
            return parseTodoCommand(commandString);
        case "deadline":
            return parseDeadlineCommand(commandString);
        case "event":
            return parseEventCommand(commandString);
        case "delete":
            return parseDeleteCommand(commandString);
        case "find":
            return parseFindCommand(commandString);
        case "tag":
            return parseTagCommand(commandString);
        default:
            return parseInvalidCommand(commandString);
        }
    }
}