import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Kyrie {
    private Ui ui;
    private Storage storage;
    private TaskList tasks;

    public Kyrie(String dirPath) {
        this.ui = new Ui("Kyrie");
        this.storage = new Storage(dirPath);
        try {
            this.tasks = storage.loadData();
        } catch (IOException e) {
            ui.showError(e);
            this.tasks = new TaskList();
        }
    }

    public void run() {
        storage.createDirAndFile();
        while (true) {
            try {
                String commandString = ui.readCommand();
                Command command = Parser.parse(commandString);
                command.execute(storage, ui, tasks);
                if (input.equals("bye")) {
                    break;
                } else if (input.equals("list")) {
                    System.out.println(separator + "Here are the tasks in your list:");
                    for (int i = 0; i < tasks.getTaskCount(); i++) {
                        System.out.println("\t" + (i + 1) + ". " + tasks.getTask(i));
                    }
                    System.out.println(separator);
                } else if (input.startsWith("mark ")) {
                    int taskNumber = Integer.parseInt(input.substring(5)) - 1;
                    if (taskNumber >= 0 && taskNumber < tasks.getTaskCount()) {
                        tasks.markTaskAsDone(taskNumber);
                        System.out.println(separator + "Excellent, you have finished this task:\n\t" + tasks.getTask(taskNumber) + separator);
                    } else {
                        throw new KyrieException("Invalid number");
                    } 
                } else if (input.startsWith("unmark ")) {
                    int taskNumber = Integer.parseInt(input.substring(7)) - 1;
                    if (taskNumber >= 0 && taskNumber < tasks.getTaskCount()) {
                        tasks.unmarkTaskAsDone(taskNumber);
                        System.out.println(separator + "You have undone your choice, that task is no longer marked finished:\n\t" + tasks.getTask(taskNumber) + separator);
                    } else {
                        throw new KyrieException("Invalid number");
                    } 
                } else if (input.startsWith("todo ")) {
                    if (tasks.isFull()) {
                        throw new KyrieException("You have reached the maximum number of tasks");
                    }
                    tasks.addTask(new ToDo(input.substring(5)));
                    System.out.println(separator + "added a new todo: " + tasks.getTask() + separator);
                } else if (input.startsWith("deadline ")) {
                    if (tasks.isFull()) {
                        throw new KyrieException("You have reached the maximum number of tasks");
                    } else if (!input.contains(" /by ")) {
                        throw new KyrieException("Invalid command, please add /by");
                    }
                    String[] parts = input.substring(9).split(" /by ");
                    tasks.addTask(new Deadline(parts[0], new DateTime(parts[1])));
                    System.out.println(separator + "added a new deadline: " + tasks.getTask() + separator);
                } else if (input.startsWith("event ")) {
                    if (tasks.isFull()) {
                        throw new KyrieException("You have reached the maximum number of tasks");
                    } else if (!input.contains(" /from ") || !input.contains(" /to ")) {
                        throw new KyrieException("Invalid command, please add /from and /to");
                    }
                    String[] parts = input.substring(6).split(" /from ");
                    String[] periodParts = parts[1].split(" /to ");
                    tasks.addTask(new Event(parts[0], new DateTime(periodParts[0]), new DateTime(periodParts[1])));
                    System.out.println(separator + "added a new event: " + tasks.getTask() + separator);
                } else if (input.startsWith("delete")) {
                    int taskNumber = Integer.parseInt(input.substring(7)) - 1;
                    if (taskNumber >= 0 && taskNumber < tasks.getTaskCount()) {
                        Task task = tasks.getTask(taskNumber);
                        tasks.deleteTask(taskNumber);
                        System.out.println(separator + "Task vanquished:\n\t" + task + separator);
                    } else {
                        throw new KyrieException("Invalid number");
                    }
                } else {
                    throw new KyrieException("Invalid command");
                }
                storage.saveData(tasks);
            } catch (KyrieException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println(errorSeparator + "There seems to be something wrong: " + e + errorSeparator);
            }
        }
        System.out.println(separator + "Farewell, my friend!" + separator);
        sc.close();
    }

    public static void main(String[] args) {
        new Kyrie("./data").run();
    }
        
        
}
