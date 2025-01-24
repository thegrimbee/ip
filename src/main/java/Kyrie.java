import java.util.Scanner;


public class Kyrie {
    public static void main(String[] args) {
        String logo = "Kyrie";
        String separator = "\n\t____________________________________________________________\n\t";
        String errorSeparator = KyrieException.errorSeparator;
        System.out.println("Shalom aleikhim, I am " + logo +"\nTell me what you desire" + separator);
        Scanner sc = new Scanner(System.in);
        Task[] tasks = new Task[100];
        int taskCount = 0;
        String input;
        while (true) {
            try {
                input = sc.nextLine();
                if (input.equals("bye")) {
                    break;
                } else if (input.equals("list")) {
                    System.out.println(separator + "Here are the tasks in your list:");
                    for (int i = 0; i < taskCount; i++) {
                        System.out.println("\t" + (i + 1) + ". " + tasks[i]);
                    }
                    System.out.println(separator);
                } else if (input.startsWith("mark ")) {
                    int taskNumber = Integer.parseInt(input.substring(5)) - 1;
                    if (taskNumber >= 0 && taskNumber < taskCount) {
                        tasks[taskNumber].markAsDone();
                        System.out.println(separator + "Excellent, you have finished this task:\n\t" + tasks[taskNumber] + separator);
                    } else {
                        throw new KyrieException("Invalid number");
                    } 
                } else if (input.startsWith("unmark ")) {
                    int taskNumber = Integer.parseInt(input.substring(7)) - 1;
                    if (taskNumber >= 0 && taskNumber < taskCount) {
                        tasks[taskNumber].unmarkAsDone();
                        System.out.println(separator + "You have undone your choice, that task is no longer marked finished:\n\t" + tasks[taskNumber] + separator);
                    } else {
                        throw new KyrieException("Invalid number");
                    } 
                } else if (input.startsWith("todo ")) {
                    if (taskCount == tasks.length) {
                        throw new KyrieException("You have reached the maximum number of tasks");
                    }
                    tasks[taskCount++] = new ToDo(input.substring(5));
                    System.out.println(separator + "added a new todo: " + tasks[taskCount - 1] + separator);
                } else if (input.startsWith("deadline ")) {
                    if (taskCount == tasks.length) {
                        throw new KyrieException("You have reached the maximum number of tasks");
                    } else if (!input.contains(" /by ")) {
                        throw new KyrieException("Invalid command, please add /by");
                    }
                    String[] parts = input.substring(9).split(" /by ");
                    tasks[taskCount++] = new Deadline(parts[0], parts[1]);
                    System.out.println(separator + "added a new deadline: " + tasks[taskCount - 1] + separator);
                } else if (input.startsWith("event ")) {
                    if (taskCount == tasks.length) {
                        throw new KyrieException("You have reached the maximum number of tasks");
                    } else if (!input.contains(" /from ") || !input.contains(" /to ")) {
                        throw new KyrieException("Invalid command, please add /from and /to");
                    }
                    String[] parts = input.substring(6).split(" /from ");
                    String[] periodParts = parts[1].split(" /to ");
                    tasks[taskCount++] = new Event(parts[0], periodParts[0], periodParts[1]);
                    System.out.println(separator + "added a new event: " + tasks[taskCount - 1] + separator);
                } else {
                    throw new KyrieException("Invalid command");
                }
            } catch (KyrieException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println(errorSeparator + "There seems to be something wrong: " + e + errorSeparator);
            }
        }
        System.out.println(separator + "Farewell, my friend!" + separator);
        sc.close();
    }
}
