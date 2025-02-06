package kyrie;

import java.io.IOException;

/**
 * Represents the Kyrie program.
 */
public class Kyrie {
    private Ui ui;
    private Storage storage;
    private TaskList tasks;

    /**
     * Constructor for Kyrie.
     * 
     * @param dirPath The directory path to save the task list to.
     */
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

    /**
     * Runs the Kyrie program.
     */
    public void run() {
        storage.createDirAndFile();
        ui.showWelcome();
        while (true) {
            try {
                String commandString = ui.readCommand();
                Command command = Parser.parseCommand(commandString);
                command.execute(storage, ui, tasks);
                if (command.isExit()) {
                    break;
                }
            } catch (KyrieException e) {
                ui.showError(e);
            } catch (Exception e) {
                ui.showError(new KyrieException("An unknown error occurred"));
            }
        }
        ui.showGoodbye();
    }

    /**
     * Main method to run the Kyrie program.
     * 
     * @param args The command line arguments.
     */
    public static void main(String[] args) {
        new Kyrie("./data").run();
    }
        
        
}
