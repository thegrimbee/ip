package kyrie;

/**
 * Represents a tag command.
 */
public class TagCommand extends Command {
   private String tagName;
   private Integer taskIndex;
   
    /**
     * Constructor for TagCommand.
     * 
     * @param tagName The name of the tag.
     */
    public TagCommand(Integer taskIndex, String tagName) {
        this.tagName = tagName;
        this.taskIndex = taskIndex;
    }

    /**
     * Executes the command to tag a task.
     * 
     * @param task The task to tag.
     */
    @Override
    public void execute(Storage storage, Ui ui, TaskList tasks) {
        Task task = tasks.getTask(taskIndex);
        task.addTag(new Tag(tagName));
        ui.showTaggedTask(task);
        storage.saveData(tasks);
    }


}
