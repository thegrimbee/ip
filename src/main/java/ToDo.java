public class ToDo extends Task {
    public ToDo(String name) {
        super(name, TaskType.TODO);
    }

    @Override
    public String toString() {
        return "[T]" + super.toString();
    }
}