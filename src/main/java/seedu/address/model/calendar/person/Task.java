package seedu.address.model.calendar.person;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import seedu.address.model.calendar.tag.TaskTag;

/**
 * Represents a Task in the taskPlace book.
 * Guarantees: details are present and not null, field values are validated, immutable.
 */
public class Task {

    // Identity fields
    private final TaskTitle taskTitle;
    private final TaskTime taskTime;
    private final TaskDescription taskDescription;

    // Data fields
    private final TaskDeadline taskDeadline;
    private final TaskPlace taskPlace;
    private final Set<TaskTag> taskTags = new HashSet<>();



    /**
     * Every field must be present and not null.
     */
    public Task(TaskTitle taskTitle, TaskTime taskTime, TaskDescription taskDescription, TaskDeadline taskDeadline,
                TaskPlace taskPlace, Set<TaskTag> taskTags) {
        this.taskDeadline = taskDeadline;
        requireAllNonNull(taskTitle, taskTime, taskDescription, taskPlace, taskTags);
        this.taskTitle = taskTitle;
        this.taskTime = taskTime;
        this.taskDescription = taskDescription;
        this.taskPlace = taskPlace;
        this.taskTags.addAll(taskTags);
    }

    public TaskTitle getTaskTitle() {
        return taskTitle;
    }

    public TaskTime getTaskTime() {
        return taskTime;
    }

    public TaskDescription getTaskDescription() {
        return taskDescription;
    }

    public TaskDeadline getTaskDeadline() {
        return taskDeadline;
    }

    public TaskPlace getTaskPlace() {
        return taskPlace;
    }

    /**
     * Returns an immutable tag set, which throws {@code UnsupportedOperationException}
     * if modification is attempted.
     */
    public Set<TaskTag> getTaskTags() {
        return Collections.unmodifiableSet(taskTags);
    }

    /**
     * Returns true if both persons of the same taskTitle have at least one other identity field that is the same.
     * This defines a weaker notion of equality between two persons.
     */
    public boolean isSamePerson(Task otherTask) {
        if (otherTask == this) {
            return true;
        }

        return otherTask != null
                && otherTask.getTaskTitle().equals(getTaskTitle())
                && (otherTask.getTaskTime().equals(getTaskTime())
                && otherTask.getTaskDeadline().equals(getTaskDeadline())
                || otherTask.getTaskDescription().equals(getTaskDescription()));
    }

    /**
     * Returns true if both persons have the same identity and data fields.
     * This defines a stronger notion of equality between two persons.
     */
    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof Task)) {
            return false;
        }

        Task otherTask = (Task) other;
        return otherTask.getTaskTitle().equals(getTaskTitle())
                && otherTask.getTaskTime().equals(getTaskTime())
                && otherTask.getTaskDeadline().equals(getTaskDeadline())
                && otherTask.getTaskDescription().equals(getTaskDescription())
                && otherTask.getTaskPlace().equals(getTaskPlace())
                && otherTask.getTaskTags().equals(getTaskTags());
    }

    @Override
    public int hashCode() {
        // use this method for custom fields hashing instead of implementing your own
        return Objects.hash(taskTitle, taskTime, taskDescription, taskPlace, taskTags);
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append(getTaskTitle())
                .append(" Time: ")
                .append(getTaskTime())
                .append(" Description: ")
                .append(getTaskDescription())
                .append(" Deadline: ")
                .append(getTaskDeadline())
                .append(" Address: ")
                .append(getTaskPlace())
                .append(" Tags: ");
        getTaskTags().forEach(builder::append);
        return builder.toString();
    }

}
