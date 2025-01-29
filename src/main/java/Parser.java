import java.util.Scanner;

public class Parser {
    public static parseCommand(String command) {
        Scanner sc = new Scanner(command);
        String firstWord = sc.next();
        switch (firstWord) {
            case "list":
                return new ListCommand();
            case "bye":
                return new ByeCommand(sc.nextInt());
            case "delete":
                return new DeleteCommand(sc.nextInt());
            case "todo":
                return new AddCommand(sc.nextLine(), TaskType.TODO);
            case "deadline":
                return new AddCommand(sc.nextLine(), TaskType.DEADLINE);
            case "event":
                return new AddCommand(sc.nextLine(), TaskType.EVENT);
            case "find":
                return new FindCommand(sc.nextLine());
            case "bye":
                return new ExitCommand();
            default:
                throw new KyrieException("I'm sorry, but I don't know what that means :-(");
        }
    }


}