public class MarkCommand extends Command {
    private Integer index;

    public MarkCommand(Integer index) {
        super();
        this.index = index;
    }

    @Override
    public void execute(Storage storage, Ui ui, TaskList tasks) {
        tasks.markTaskAsDone(this.index);
        ui.showMarkedTask(tasks.getTask(this.index));
        storage.saveData(tasks);
    }
}