public class Event extends Task {
    protected String start;
    protected String end;

    public Event(String name, String start, String end) {
        super(name, TaskType.EVENT);
        this.start = start;
        this.end = end;
    }

    @Override
    public String toFileString() {
        return super.toFileString() + " | " + this.start + " | " + this.end;
    }

    @Override
    public String toString() {
        return "[E]" + super.toString() + " (from: " + start + " to: " + end + ")";
    }
}