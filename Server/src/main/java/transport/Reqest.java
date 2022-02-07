package transport;

import java.io.Serializable;
import java.sql.Time;
import java.util.UUID;

public class Reqest implements Serializable {

    private String command;
    private UUID userId;
    private String taskName;
    private String taskDesc;
    private Time alertTime;
    private UUID taskId;

    public UUID getTaskId() {
        return taskId;
    }

    public void setTaskId(UUID taskId) {
        this.taskId = taskId;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getTaskDesc() {
        return taskDesc;
    }

    public void setTaskDesc(String taskDesc) {
        this.taskDesc = taskDesc;
    }

    public Time getAlertTime() {
        return alertTime;
    }

    public void setAlertTime(Time alertTime) {
        this.alertTime = alertTime;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public Reqest(String command) {
        this.command = command;
    }

    public Reqest() {
    }
}
