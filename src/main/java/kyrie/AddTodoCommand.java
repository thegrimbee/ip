package kyrie;

public class AddTodoCommand extends Command {
    private String name;

    public AddTodoCommand(String name) {
        super();
        this.name = name;
    }

    @Override
    public void execute(Storage storage, Ui ui, TaskList tasks) {
        Task todo = new Todo(name);
        tasks.addTask(todo);
        ui.showAddedTask(todo);
        storage.saveData(tasks);
    }
}