package kyrie;

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

    public static void main(String[] args) {
        new Kyrie("./data").run();
    }
        
        
}
