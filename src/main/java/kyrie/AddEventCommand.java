package kyrie;

public class AddEventCommand extends Command {
    private String name;
    private DateTime from;
    private DateTime to;

    public AddEventCommand(String name, DateTime from, DateTime to) {
        super();
        this.name = name;
        this.from = from;
        this.to = to;
    }

    @Override
    public void execute(Storage storage, Ui ui, TaskList tasks) {
        Event event = new Event(name, from, to);
        tasks.addTask(event);
        ui.showAddedTask(event);
        storage.saveData(tasks);
    }
}