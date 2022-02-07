package interfaces;

import exceptions.NotFoundException;
import model.Task;
import model.User;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

/**
 * interface TaskDAO
 */
public interface TaskDAO {

    void deleteTask(UUID taskId);

    List<Task> findAllTasks(UUID userId) throws IOException;

    Task loadTask(UUID taskId) throws NotFoundException, IOException;

    void storeTask(Task task) throws IOException;

    void unloadFile(User user);

    User loadFile() throws IOException;

}
