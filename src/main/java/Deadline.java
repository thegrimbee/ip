public class Deadline extends Task {
    protected String deadline;

    public Deadline(String name, String deadline) {
        super(name, TaskType.DEADLINE);
        this.deadline = deadline;
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + deadline + ")";
    }
}