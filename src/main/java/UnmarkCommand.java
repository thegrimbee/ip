public class UnmarkCommand extends Command {
    private Integer index;

    public UnmarkCommand(Integer index) {
        super();
        this.index = index;
    }

    @Override
    public void execute(Storage storage, Ui ui, TaskList tasks) {
        tasks.unmarkTaskAsDone(index);
        ui.showMarkedTask(tasks.getTask(index));
        storage.saveData(tasks);
    }
}