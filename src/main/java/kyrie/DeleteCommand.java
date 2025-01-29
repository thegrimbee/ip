package kyrie;

public class DeleteCommand extends Command {
    private int index;

    public DeleteCommand(int index) {
        super();
        this.index = index;
    }

    @Override
    public void execute(Storage storage, Ui ui, TaskList tasks) {
        Task task = tasks.deleteTask(index);
        storage.saveData(tasks);
        ui.showDeletedTask(task, tasks);
    }
}