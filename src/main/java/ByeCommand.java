public class ByeCommand extends Command {
    public ByeCommand() {
        super();
    }

    @Override
    public Boolean isExit() {
        return true;
    }

    @Override
    public void execute(Storage storage, Ui ui, TaskList tasks) {
        ui.showGoodbye();
    }
}