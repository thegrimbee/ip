package kyrie;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Represents the storage of the task list.
 */
public class Storage {
    private final String DIR_PATH;
    private final String FILE_PATH;

    /**
     * Constructor for Storage.
     * 
     * @param dirPath The directory path to save the task list to.
     */
    public Storage(String dirPath) {
        DIR_PATH = dirPath;
        FILE_PATH = dirPath + "/tasks.txt";
    }

    /**
     * Creates the directory and file to save the task list to.
     */
    public void createDirAndFile() {
        File dir = new File(this.DIR_PATH);
        if (!dir.exists()) {
            dir.mkdir();
        }
        File file = new File(this.FILE_PATH);
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
        } catch (IOException e) {
            System.out.println("There seems to be something wrong: " + e);
        }
    }

    /**
     * Saves the task list to the file.
     * 
     * @param tasks The task list to save.
     */
    public void saveData(TaskList tasks) {
        try {
            File file = new File(this.FILE_PATH);
            FileWriter writer = new FileWriter(file);
            writer.write(tasks.toFileString());
            writer.close();
        } catch (IOException e) {
            System.out.println("There seems to be something wrong: " + e);
        }
    }

    /**
     * Loads the task list from the file.
     * 
     * @return The task list loaded from the file.
     * @throws IOException If there is an error loading the file.
     */
    public TaskList loadData() throws IOException {
        TaskList tasks = new TaskList();
        File file = new File(this.FILE_PATH);
        Scanner sc = new Scanner(file);
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            try {
                Task task = parseTask(line);
                if (isTaskDone(line)) {
                    task.markAsDone();
                }
                tasks.addTask(task);
            } catch (KyrieException e) {
                System.out.println("There seems to be something wrong: " + e);
            }
        }
        sc.close();
        return tasks;
    }

    /**
     * Parses a line from the file and returns the corresponding task.
     * 
     * @param line The line to parse.
     * @return The corresponding task.
     * @throws KyrieException If the task format is invalid.
     */
    private Task parseTask(String line) throws KyrieException {
        String[] parts = line.split(" \\| ");
        switch (parts[0]) {
            case "TODO":
                if (parts.length != 3) {
                    throw new KyrieException("Invalid task format");
                }
                return new Todo(parts[2]);
            case "DEADLINE":
                if (parts.length != 4) {
                    throw new KyrieException("Invalid task format");
                }
                return new Deadline(parts[2], new DateTime(parts[3]));
            case "EVENT":
                if (parts.length != 5) {
                    throw new KyrieException("Invalid task format");
                }
                return new Event(parts[2], new DateTime(parts[3]), new DateTime(parts[4]));
            default:
                throw new KyrieException("Invalid task type");
        }
    }

    /**
     * Checks if the task is marked as done.
     * 
     * @param line The line to check.
     * @return True if the task is marked as done, false otherwise.
     */
    private boolean isTaskDone(String line) {
        String[] parts = line.split(" \\| ");
        return parts[1].equals("1");
    }
}