package kyrie;

public class Deadline extends Task {
    protected DateTime deadline;

    public Deadline(String name, DateTime deadline) {
        super(name, TaskType.DEADLINE);
        this.deadline = deadline;
    }

    @Override
    public String toFileString() {
        return super.toFileString() + " | " + this.deadline.toInputFormatString();
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + deadline + ")";
    }
}