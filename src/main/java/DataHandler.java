import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class DataHandler {
    private static final String DIR_PATH = "./data";
    private static final String FILE_PATH = "./data/kyrie.txt";
    static String errorSeparator = KyrieException.errorSeparator;

    public static void createDirAndFile() {
        File dir = new File(DIR_PATH);
        if (!dir.exists()) {
            dir.mkdir();
        }
        File file = new File(FILE_PATH);
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
        } catch (IOException e) {
            System.out.println(errorSeparator + "There seems to be something wrong: " + e + errorSeparator);
        }
    }

    public static void saveData(TaskList tasks) {
        try {
            File file = new File(FILE_PATH);
            FileWriter writer = new FileWriter(file);
            writer.write(tasks.toFileString());
            writer.close();
        } catch (IOException e) {
            System.out.println(errorSeparator + "There seems to be something wrong: " + e + errorSeparator);
        }
    }

    public static void loadData(TaskList tasks) {
        try {
            File file = new File(FILE_PATH);
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] parts = line.split(" \\| ");
                Task task;
                try {
                    switch (parts[0]) {
                    case "TODO":
                        if (parts.length != 3) {
                            throw new KyrieException("Invalid task format");
                        }
                        task = new ToDo(parts[2]);
                        break;
                    case "DEADLINE":
                        if (parts.length != 4) {
                            throw new KyrieException("Invalid task format");
                        }
                        task = new Deadline(parts[2], parts[3]);
                        break;
                    case "EVENT":
                        if (parts.length != 4) {
                            throw new KyrieException("Invalid task format");
                        }
                        task = new Event(parts[2], parts[3], parts[4]);
                        break;
                    default:
                        throw new KyrieException("Invalid task type");
                    }
                } catch (KyrieException e) {
                    System.out.println(errorSeparator + "There seems to be something wrong: " + e + errorSeparator);
                    continue;
                }
                if (parts[1].equals("1")) {
                    task.markAsDone();
                }
                tasks.addTask(task);
            }
            sc.close();
        } catch (IOException e) {
            System.out.println(errorSeparator + "There seems to be something wrong: " + e + errorSeparator);
        }
    }
}