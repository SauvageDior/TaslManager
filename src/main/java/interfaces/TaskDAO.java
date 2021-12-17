package interfaces;

import exceptions.NotFoundException;
import model.Task;

import java.io.IOException;
import java.util.List;
import java.util.UUID;


public interface TaskDAO {

    void deleteTask(UUID taskId);

    List<Task> findAllTasks(UUID userId);

    Task loadTask(UUID taskId) throws NotFoundException;

    void storeTask(Task task);

}
