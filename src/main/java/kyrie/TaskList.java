package kyrie;

import java.util.ArrayList;

public class TaskList {
    private ArrayList<Task> tasks;
    private int size = 100;
    private int taskCount = 0;
    public TaskList() {
        this.tasks = new ArrayList<Task>();
    }

    public void addTask(Task task) {
        this.tasks.add(task);
        this.taskCount++;
    }

    public Task deleteTask(int index) {
        Task task = this.tasks.get(index - 1);
        this.tasks.remove(index - 1);
        this.taskCount--;
        return task;
    }

    public Task getTask(int index) {
        return this.tasks.get(index - 1);
    }

    public Task getTask() {
        return this.tasks.get(this.taskCount - 1);
    }

    public int getSize() {
        return this.size;
    }

    // public ArrayList<Task> getTasks() {
    //     return this.tasks;
    // }

    public void markTaskAsDone(int index) {
        this.tasks.get(index - 1).markAsDone();
    }

    public void unmarkTaskAsDone(int index) {
        this.tasks.get(index - 1).unmarkAsDone();
    }

    public void listTasks() {
        System.out.println("Here are the tasks in your list:");
        for (int i = 0; i < this.tasks.size(); i++) {
            System.out.println("\t" + (i + 1) + ". " + this.tasks.get(i));
        }
    }

    public int getTaskCount() {
        return this.taskCount;
    }

    public Boolean isFull() {
        return this.taskCount == this.size;
    }

    public String toFileString() {
        String output = "";
        for (Task task : this.tasks) {
            output += task.toFileString() + "\n";
        }
        return output;
    }
}