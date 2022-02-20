package controllers;

import exceptions.NotFoundException;
import interfaces.TaskDAO;
import interfaces.impl.XMLTaskDAO;
import model.Task;

import java.io.IOException;
import java.sql.Time;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;


/**
 * class TaskController
 */
public class TaskController {
    /**
     * creating TaskDAO object
     */
    private TaskDAO taskDAO = new XMLTaskDAO();

    /**
     * schedule task
     * @param userId
     * @param taskName
     * @param taskDesc
     * @param alertTime
     * @return task
     * @throws IOException
     */
    public Task sheduleTask(UUID userId, String taskName, String taskDesc, Time alertTime) throws IOException {
        Task task = new Task(taskDesc, taskName, userId, UUID.randomUUID(), alertTime);
        taskDAO.storeTask(task);
        return task;
    }

    /**
     * delete alert
     * sets null alert time
     * @param taskId
     * @return
     * @throws NotFoundException
     * @throws IOException
     */
    public Task unsheludeTask(UUID taskId) throws NotFoundException, IOException {
        Task task = taskDAO.loadTask(taskId);
        task.setAlertTime(null);

        taskDAO.storeTask(task);
        return task;
    }

    /**
     * refresh task
     * @param taskId
     * @param name
     * @param desc
     * @return
     * @throws NotFoundException
     * @throws IOException
     */
    public Task updateTask(UUID taskId, String name, String desc) throws NotFoundException, IOException {
        Task task = taskDAO.loadTask(taskId);
        task.setName(name);
        task.setDescription(desc);
        taskDAO.storeTask(task);
        return task;
    }

    /**
     * change time
     * @param taskId
     * @param newTime
     * @return
     * @throws NotFoundException
     * @throws IOException
     */
    public Task resheludeTask(UUID taskId, Time newTime) throws NotFoundException, IOException {
        Task task = taskDAO.loadTask(taskId);
        task.setAlertTime(newTime);
        taskDAO.storeTask(task);
        return task;
    }

    public List<Task> getAllTasks(UUID userId) throws IOException {
        List<Task> tasks = taskDAO.findAllTasks(userId);
        return tasks;
    }
    /**
     * delete task
     * @param taskId
     */
    public void deleteTask(UUID taskId)  {
        taskDAO.deleteTask(taskId);
    }


/*    public void sortTasks(UUID userId, Time alertTime) throws IOException {
        List<Task> list = taskDAO.findAllTasks(userId);
        list.sort(Comparator.comparing(Task::getAlert());
    }*/

}
