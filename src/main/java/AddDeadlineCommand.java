public class AddDeadlineCommand extends Command {
    private String name;
    private DateTime deadline;

    public AddDeadlineCommand(String name, DateTime deadline) {
        super();
        this.name = name;
        this.deadline = deadline;
    }

    @Override
    public void execute(Storage storage, Ui ui, TaskList tasks) {
        Task task = new Deadline(name, deadline);
        tasks.addTask(task);
        ui.showAddedTask(task);
        storage.saveData(tasks);
    }
}