package model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import model.Task;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.List;
import java.util.UUID;


public class User implements Serializable {

    private UUID id;

    private List<Task> tasks;

   public User(UUID id, List<Task> taskList) {
        this.id = UUID.randomUUID();
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
