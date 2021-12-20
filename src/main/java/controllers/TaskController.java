package controllers;

import exceptions.NotFoundException;
import interfaces.TaskDAO;
import interfaces.impl.XMLTaskDAO;
import model.Alert;
import model.Task;


import java.io.IOException;
import java.sql.Time;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;

public class TaskController {

    private TaskDAO taskDAO = new XMLTaskDAO();

    public Task sheduleTask(UUID userId, String taskName, String taskDesc, Time alertTime) throws IOException {
        Task task = new Task(taskDesc, taskName, userId, UUID.randomUUID(), alertTime);
        taskDAO.storeTask(task);
        return task;
    }

    public Task unsheludeTask(UUID taskId) throws NotFoundException, IOException { // убрать алерт
        Task task = taskDAO.loadTask(taskId);
        task.setAlertTime(null);
        return task;
    }

    public Task updateTask(UUID taskId, String name, String desc) throws NotFoundException, IOException {
        Task task = taskDAO.loadTask(taskId);
        task.setName(name);
        task.setDescription(desc);
        taskDAO.storeTask(task);
        return task;
    }

    public Task resheludeTask(UUID taskId, Time newTime) throws NotFoundException, IOException {
        Task task = taskDAO.loadTask(taskId);
        task.setAlertTime(newTime);
        return task;
    }

    public void deleteTask(UUID taskId)  {
        taskDAO.deleteTask(taskId);
    }

/*    public void sortTasks(UUID userId, Time alertTime) throws IOException {
        List<Task> list = taskDAO.findAllTasks(userId);
        list.sort(Comparator.comparing(Task::getAlert()));
    }*/

}
