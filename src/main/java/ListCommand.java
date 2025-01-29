public class ListCommand extends Command {
    public ListCommand(Storage storage, Ui ui) {
        super(storage, ui);
    }

    @Override
    public void execute() {
        Ui.printList();
    }
}