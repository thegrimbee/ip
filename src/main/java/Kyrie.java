import java.util.Scanner;

public class Kyrie {
    public static void main(String[] args) {
        String logo = "Kyrie";
        String separator = "\n\t____________________________________________________________\n\t";
        System.out.println("Shalom aleikhim, I am " + logo +"\nTell me what you desire" + separator);
        Scanner sc = new Scanner(System.in);
        String[] tasks = new String[100];
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
            } else {
                tasks[taskCount++] = input;
                System.out.println(separator + "added a new task: " + input + separator);
            }
        }
        System.out.println(separator + "Farewell, my friend!" + separator);
        sc.close();
    }
}
