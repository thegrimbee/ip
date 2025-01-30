package kyrie;

import java.util.Scanner;

/**
 * Represents the user interface.
 */
public class Ui {
    private static String separator = "\n____________________________________________________________\n";
    private static String errorSeparator = KyrieException.errorSeparator;
    private String name;
    private Scanner sc;

    /**
     * Constructor for Ui.
     * @param name The name of the user interface.
     */
    public Ui(String name) {
        this.name = name;
        this.sc = new Scanner(System.in);
    }

    /**
     * Shows the separator.
     */
    public static void showSeparator() {
        System.out.println(separator);
    }

    /**
     * Shows the error separator.
     */
    public static void showErrorSeparator() {
        System.out.println(errorSeparator);
    }

    /**
     * Responds to the user.
     * @param response The response to the user.
     */
    private void respond(String response) {
        Ui.showSeparator();
        System.out.println(response);
        Ui.showSeparator();
        System.out.println();
    }

    /**
     * Shows the welcome message.
     */
    public void showWelcome() {
        this.respond("Shalom aleikhim, I am " + name + "\nTell me what you desire");
    }

    /**
     * Shows the goodbye message.
     */
    public void showGoodbye() {
        this.respond("Farewell, may you find what you seek");
    }

    /**
     * Shows an error message.
     * @param e The exception that caused the error.
     */
    public void showError(Exception e) {
        Ui.showErrorSeparator();
        System.out.println(e.getMessage());
        Ui.showErrorSeparator();
    }

    /**
     * Reads the command from the user.
     * @return The command from the user.
     */
    public String readCommand() {
        return sc.nextLine();
    }

    /**
     * Shows the tasks in the task list.
     * @param tasks The task list to show.
     */
    public void showTasks(TaskList tasks) {
        String response = "Here are the tasks in your list:\n";
        for (int i = 1; i <= tasks.getTaskCount(); i++) {
            response += i + ". " + tasks.getTask(i) + "\n";
        }
        this.respond(response);
    }

    /**
     * Shows the marked task.
     * @param task The task to show.
     */
    public void showMarkedTask(Task task) {
        this.respond("Excellent, you have finished this task:\n\t" + task);
    }

    /**
     * Shows the unmarked task.
     * @param task The task to show.
     */
    public void showUnmarkedTask(Task task) {
        this.respond("You have undone your choice, that task is no longer marked finished:\n\t" + task);
    }

    /**
     * Shows the added task.
     * @param task The task to show.
     */
    public void showAddedTask(Task task) {
        this.respond("added a new task: " + task);
    }

    /**
     * Shows the deleted task.
     * @param task The task to show.
     * @param tasks The task list to show the number of tasks remaining.
     */
    public void showDeletedTask(Task task, TaskList tasks) {
        this.respond("Noted, I have removed this task:\n\t" + task + "\nNow you have " + tasks.getTaskCount() + " tasks remaining");
    }
}