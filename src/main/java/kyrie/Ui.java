package kyrie;

import java.util.Scanner;

public class Ui {
    private static String separator = "\n____________________________________________________________\n";
    private static String errorSeparator = KyrieException.errorSeparator;
    private String name;
    private Scanner sc;

    public Ui(String name) {
        this.name = name;
        this.sc = new Scanner(System.in);
    }

    public static void showSeparator() {
        System.out.println(separator);
    }

    public void showWelcome() {
        Ui.showSeparator();
        System.out.println("Shalom aleikhim, I am " + name + "\nTell me what you desire");
        Ui.showSeparator();
        System.out.println();
    }

    public void showGoodbye() {
        Ui.showSeparator();
        System.out.println("Farewell, may you find what you seek");
        Ui.showSeparator();
    }

    public void showError(Exception e) {
        Ui.showSeparator();
        System.out.println(e.getMessage());
        Ui.showSeparator();
    }

    public String readCommand() {
        return sc.nextLine();
    }

    public void respond(String response) {
        Ui.showSeparator();
        System.out.println(response);
        Ui.showSeparator();
    }

    public void showTasks(TaskList tasks) {
        String response = "Here are the tasks in your list:\n";
        for (int i = 1; i <= tasks.getTaskCount(); i++) {
            response += i + ". " + tasks.getTask(i) + "\n";
        }
        this.respond(response);
    }

    public void showMarkedTask(Task task) {
        this.respond("Excellent, you have finished this task:\n\t" + task);
    }

    public void showUnmarkedTask(Task task) {
        this.respond("You have undone your choice, that task is no longer marked finished:\n\t" + task);
    }

    public void showAddedTask(Task task) {
        this.respond("added a new task: " + task);
    }

    public void showDeletedTask(Task task, TaskList tasks) {
        this.respond("Noted, I have removed this task:\n\t" + task + "\nNow you have " + tasks.getTaskCount() + " tasks remaining");
    }
}