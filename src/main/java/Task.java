public class Task {
    protected Boolean isDone;
    protected String name;

    public Task(String name) {
        this.name = name;
        this.isDone = false;
    }

    public void markAsDone() {
        this.isDone = true;
    }

    public void unmarkAsDone() {
        this.isDone = false;
    }

    public String getName() {
        return this.name;
    }

    public Boolean isDone() {
        return this.isDone;
    }

    @Override
    public String toString() {
        return this.isDone ? "[X] " + this.name : "[ ] " + this.name;
    }
}