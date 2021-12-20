package model;

import model.Task;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;
import java.util.UUID;


public class User {

    private UUID id;
    private List<Task> tasks;

   public User(UUID id, List<Task> taskList) {
        this.id = id;
        this.tasks = taskList;
    }

    public User(){}


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
