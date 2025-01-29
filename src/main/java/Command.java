public abstract class Command {

    public Command() {
    }

    public Boolean isEnd() {
        return false;
    }

    public abstract void execute() throws KyrieException;
}