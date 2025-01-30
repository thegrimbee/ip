package kyrie;

/**
 * Represents a command to find tasks.
 */
public class FindCommand extends Command {
    private String keyword;

    /**
     * Constructor for FindCommand.
     * @param keyword The keyword to search for.
     */
    public FindCommand(String keyword) {
        super();
        this.keyword = keyword;
    }

    /**
     * Executes the command to find tasks.
     * @param storage The storage object to save the task list to.
     * @param ui The ui object to show the user the found tasks.
     * @param tasks The task list to find the tasks from.
     */
    public void execute(Storage storage, Ui ui, TaskList tasks) {
        TaskList foundTasks = tasks.findTasks(keyword);
        ui.showFoundTasks(foundTasks);
    }
}
