package interfaces.impl;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.xml.util.*;
import com.fasterxml.jackson.dataformat.xml.deser.*;
import exceptions.NotFoundException;
import interfaces.TaskDAO;
import model.Task;
import model.User;


import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;



public class XMLTaskDAO implements TaskDAO {




    public void deleteTask(UUID taskId) {
        List<Task> list = new ArrayList<>();
        for (Task task :
                list) {
            if (task.getId().equals(taskId)) {
                list.remove(task);
                break;
            }
        }
    }

    public List<Task> findAllTasks(UUID userId) {
        List<Task> list = new ArrayList<>();
        List<Task> userList = new ArrayList<>();
        for (Task task :
                list) {
            if (task.getUserId().equals(userId)) {
                userList.add(task);
            }
        }
        return userList;
    }


    public void storeTask(Task task) {
        List<Task> list = new ArrayList<>();
        list.add(task);
    }

    public Task loadTask(UUID taskId) throws NotFoundException {
        List<Task> list = new ArrayList<>();

        for (Task task :
                list) {
            if (task.getId().equals(taskId)) {
                return task;
            }
        }
        throw new NotFoundException("");
    }


/*    private static List<Task> loadFile() throws IOException { //загрузка из файла
        XmlMapper xmlMapper = new XmlMapper();
        Task task = xmlMapper.readValue(XML, Task.class);
    }*/

}







    





