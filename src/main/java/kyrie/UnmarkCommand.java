package kyrie;

/**
 * Represents a command to unmark a task as done.
 */
public class UnmarkCommand extends Command {
    private Integer index;

    /**
     * Constructor for UnmarkCommand.
     * @param index The index of the task to be unmarked, 1-indexed.
     */
    public UnmarkCommand(Integer index) {
        super();
        this.index = index;
    }

    /**
     * Executes the command to unmark a task as done.
     * @param storage The storage object to save the task list to.
     * @param ui The ui object to show the user the unmarked task.
     * @param tasks The task list to unmark the task from.
     */ 
    @Override
    public void execute(Storage storage, Ui ui, TaskList tasks) {
        tasks.unmarkTaskAsDone(index);
        ui.showMarkedTask(tasks.getTask(index));
        storage.saveData(tasks);
    }
}