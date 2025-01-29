package kyrie;

public abstract class Command {

    public Command() {
    }

    public Boolean isExit() {
        return false;
    }

    public abstract void execute(Storage storage, Ui ui, TaskList tasks) throws KyrieException;
}