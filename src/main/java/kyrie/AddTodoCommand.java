package kyrie;

/**
 * Represents a command to add a todo task.
 */
public class AddTodoCommand extends Command {
    private String name;

    /**
     * Constructor for AddTodoCommand.
     * 
     * @param name The name of the todo task.
     */
    public AddTodoCommand(String name) {
        super();
        this.name = name;
    }

    /**
     * Executes the command to add a todo task.
     * 
     * @param storage The storage object to save the task list to.
     * @param ui The ui object to show the user the added task.
     * @param tasks The task list to add the task to.
     */
    @Override
    public void execute(Storage storage, Ui ui, TaskList tasks) {
        Task todo = new Todo(name);
        tasks.addTask(todo);
        ui.showAddedTask(todo);
        storage.saveData(tasks);
    }
}