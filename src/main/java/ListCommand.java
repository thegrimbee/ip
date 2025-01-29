public class ListCommand extends Command {
    public ListCommand() {
        super();
    }

    @Override
    public void execute(Storage storage, Ui ui, TaskList tasks) {
        ui.showTasks(tasks);
    }
}