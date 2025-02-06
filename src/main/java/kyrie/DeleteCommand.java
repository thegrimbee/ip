package kyrie;

/**
 * Represents a command to delete a task.
 */
public class DeleteCommand extends Command {
    private int index;

    /**
     * Constructor for DeleteCommand.
     * 
     * @param index The index of the task to be deleted, 1-indexed.
     */
    public DeleteCommand(int index) {
        super();
        this.index = index;
    }

    /**
     * Executes the command to delete a task.
     * 
     * @param storage The storage object to save the task list to.
     * @param ui The ui object to show the user the deleted task.
     * @param tasks The task list to delete the task from.
     */
    @Override
    public void execute(Storage storage, Ui ui, TaskList tasks) {
        Task task = tasks.deleteTask(index);
        storage.saveData(tasks);
        ui.showDeletedTask(task, tasks);
    }
}