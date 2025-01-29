public class Event extends Task {
    protected DateTime start;
    protected DateTime end;

    public Event(String name, DateTime start, DateTime end) {
        super(name, TaskType.EVENT);
        this.start = start;
        this.end = end;
    }

    @Override
    public String toFileString() {
        return super.toFileString() + " | " + this.start.toInputFormatString() + " | " + this.end.toInputFormatString();    
    }

    @Override
    public String toString() {
        return "[E]" + super.toString() + " (from: " + start + " to: " + end + ")";
    }
}