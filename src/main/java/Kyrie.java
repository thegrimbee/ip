import java.util.Scanner;

public class Kyrie {
    public static void main(String[] args) {
        String logo = "Kyrie";
        String separator = "\n\t____________________________________________________________\n\t";
        System.out.println("Shalom aleikhim, I am " + logo +"\nTell me what you desire" + separator);
        Scanner sc = new Scanner(System.in);
        String[] tasks = new String[100];
        Boolean[] isDone = new Boolean[100];
        int taskCount = 0;
        String input;
        while (true) {
            input = sc.nextLine();
            if (input.equals("bye")) {
                break;
            } else if (input.equals("list")) {
                System.out.println(separator + "Here are the tasks in your list:");
                for (int i = 0; i < taskCount; i++) {
                    String checkbox = isDone[i] ? "[X]" : "[ ]";
                    System.out.println("\t" + (i + 1) + ". " + checkbox + " " +  tasks[i]);
                }
                System.out.println(separator);
            } else if (input.startsWith("mark ")) {
                int taskNumber = Integer.parseInt(input.substring(5)) - 1;
                if (taskNumber >= 0 && taskNumber < taskCount) {
                    isDone[taskNumber] = true;
                    System.out.println(separator + "Excellent, your task is finished:\n\t[X] " + tasks[taskNumber] + separator);
                } else {
                    System.out.println(separator + "Are you ok, choose a valid number" + separator);
                } 
            } else if (input.startsWith("unmark ")) {
                int taskNumber = Integer.parseInt(input.substring(7)) - 1;
                if (taskNumber >= 0 && taskNumber < taskCount) {
                    isDone[taskNumber] = false;
                    System.out.println(separator + "You have undone your choice, that task is no longer marked finished:\n\t[ ] " + tasks[taskNumber] + separator);
                } else {
                    System.out.println(separator + "Are you ok, choose a valid number" + separator);
                } 
            } else {
                isDone[taskCount] = false;
                tasks[taskCount++] = input;
                System.out.println(separator + "added a new task: " + input + separator);
            }
        }
        System.out.println(separator + "Farewell, my friend!" + separator);
        sc.close();
    }
}
