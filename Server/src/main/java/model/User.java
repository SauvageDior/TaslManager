package model;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

/**
 * class User
 * contains list of Task
 * @see Task
 */
public class User implements Serializable {
    /** id */
    private UUID id;
    /**  task list */
    private List<Task> tasks;

    /**
     * constructor
     * @param id
     * @param taskList
     */
    public User(UUID id, List<Task> taskList) {
        this.id = UUID.randomUUID();
        this.tasks = taskList;
    }

    public User(){
        this.id = UUID.randomUUID();
    }


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

}
