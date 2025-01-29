import java.util.Scanner;

public class Ui {
    private Storage storage;
    private TaskList tasks;
    private static String separator = "\n____________________________________________________________\n";
    private String name;


    public Ui(String name) {
        this.name = name;
    }

    public static void showSeparator() {
        System.out.println(separator);
    }

    public static void showWelcome() {
        Ui.showSeparator();
        System.out.println("Shalom aleikhim, I am " + name + "\nTell me what you desire");
        Ui.showSeparator();
        System.out.println();
    }

    public static void showGoodbye() {
        Ui.showSeparator();
        System.out.println("Farewell, may you find what you seek");
        Ui.showSeparator();
    }
}