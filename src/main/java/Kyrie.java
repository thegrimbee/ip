import java.util.Scanner;

public class Kyrie {
    public static void main(String[] args) {
        String logo = "Kyrie";
        String separator = "\n\t____________________________________________________________\n\t";
        System.out.println("Shalom aleikhim, I am " + logo +"\nTell me what you desire" + separator);
        Scanner sc = new Scanner(System.in);
        Task[] tasks = new Task[100];
        int taskCount = 0;
        String input;
        while (true) {
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
                    System.out.println(separator + "Are you ok, choose a valid number" + separator);
                } 
            } else if (input.startsWith("unmark ")) {
                int taskNumber = Integer.parseInt(input.substring(7)) - 1;
                if (taskNumber >= 0 && taskNumber < taskCount) {
                    tasks[taskNumber].unmarkAsDone();
                    System.out.println(separator + "You have undone your choice, that task is no longer marked finished:\n\t" + tasks[taskNumber] + separator);
                } else {
                    System.out.println(separator + "Are you ok, choose a valid number" + separator);
                } 
            } else if (input.startsWith("todo ")) {
                tasks[taskCount++] = new ToDo(input.substring(5));
                System.out.println(separator + "added a new todo: " + tasks[taskCount - 1] + separator);
            } else if (input.startsWith("deadline ")) {
                String[] parts = input.substring(9).split(" /by ");
                tasks[taskCount++] = new Deadline(parts[0], parts[1]);
                System.out.println(separator + "added a new deadline: " + tasks[taskCount - 1] + separator);
            } else if (input.startsWith("event ")) {
                String[] parts = input.substring(6).split(" /from ");
                String[] periodParts = parts[1].split(" /to ");
                tasks[taskCount++] = new Event(parts[0], periodParts[0], periodParts[1]);
                System.out.println(separator + "added a new event: " + tasks[taskCount - 1] + separator);
            } else {
                tasks[taskCount++] = new Task(input);
                System.out.println(separator + "added a new task: " + input + separator);
            }
        }
        System.out.println(separator + "Farewell, my friend!" + separator);
        sc.close();
    }
}
