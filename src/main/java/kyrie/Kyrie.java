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
            this.run();
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
    }

    /**
     * Gets the response from Kyrie.
     * 
     * @param input The input from the user.
     * @return The response from Kyrie.
     */
    public String getResponse(String input) {
        try {
            Command command = Parser.parseCommand(input);
            command.execute(storage, ui, tasks);
            return ui.getResponse();
        } catch (KyrieException e) {
            return e.getMessage();
        }
    } 

    /**
     * Gets the welcome message from Kyrie.
     * 
     * @return The welcome message from Kyrie.
     */
    public String getWelcomeMessage() {
        ui.showWelcome();
        return ui.getResponse();
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
