package kyrie;

public class Task {
    protected Boolean isDone;
    protected String name;
    protected TaskType type;

    public Task(String name, TaskType type) {
        this.name = name;
        this.isDone = false;
        this.type = type;
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

    public String toFileString() {
        return this.type + " | " + (this.isDone ? "1" : "0") + " | " + this.name;
    }

    @Override
    public String toString() {
        return this.isDone ? "[X] " + this.name : "[ ] " + this.name;
    }
}