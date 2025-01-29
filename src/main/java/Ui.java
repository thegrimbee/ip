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

    public void showSeparator() {
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

    public void readCommand() {
        return sc.nextLine();
    }

    public void printList(TaskList tasks) {
        System.out.println("Here are the tasks in your list:");
        for (int i = 0; i < tasks.getSize(); i++) {
            System.out.println("\t" + (i + 1) + ". " + tasks.getTask(i));
        }
    }
}