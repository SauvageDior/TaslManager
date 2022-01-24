package interfaces.impl;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.xml.util.*;
import com.fasterxml.jackson.dataformat.xml.deser.*;
import exceptions.NotFoundException;
import interfaces.TaskDAO;
import model.Task;
import model.User;


import java.beans.XMLEncoder;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;


/**
 * TaskDAO interface realization
 * @see interfaces.TaskDAO
 */
public class XMLTaskDAO implements TaskDAO {


    //private static final File XML = new File("XMLtestfile");

    /**
     * delete
     * @param taskId
     */
    public void deleteTask(UUID taskId) {

        User user = null;
        try {
            user = loadFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        List<Task> list = user.getTasks();
        for (Task task :
                list) {
            if (task.getId().equals(taskId)) {
                list.remove(task);
                break;
            }
        }
        unloadFile(user);
    }

    /**
     * searching all tasks by id
     * @param userId
     * @return
     * @throws IOException
     */
    public List<Task> findAllTasks(UUID userId) throws IOException {
        //List<Task> list = loadFile();
        User user = loadFile();
        List<Task> list = user.getTasks();
        List<Task> userList = new ArrayList<>();
        for (Task task :
                list) {
            if (task.getUserId().equals(userId)) {
                userList.add(task);
            }
        }
        return userList;
    }

    /**
     * saving task
     * @param task
     * @throws IOException
     */
    public void storeTask(Task task) throws IOException {
        //List<Task> list = new ArrayList<>();
        User user = loadFile();
        if (user.getTasks() == null){
            List<Task> list = new ArrayList<>();
            list.add(task);
            user.setTasks(list);
        }
        else {
            List<Task> list = user.getTasks();
            list.add(task);
        }
        unloadFile(user);
    }

    /**
     * load task by id
     * @param taskId
     * @return
     * @throws NotFoundException
     * @throws IOException
     */
    public Task loadTask(UUID taskId) throws NotFoundException, IOException {
        List<Task> list = new ArrayList<>();
        User user = loadFile();
        list = user.getTasks();
        for (Task task :
                list) {
            if (task.getId().equals(taskId)) {
                return task;
            }
        }
        throw new NotFoundException("");
    }

    /**
     * save file
     * @param user
     */
    public static void unloadFile(User user) {
        try {
            XmlMapper xmlMapper = new XmlMapper();

            String xmlString = xmlMapper.writeValueAsString(user);

            //System.out.println(xmlString);

            File xmlOutput = new File("XMTesticle.xml");
            FileWriter fileWriter = new FileWriter(xmlOutput);
            fileWriter.write(xmlString);
            fileWriter.close();
        } catch (JsonProcessingException e) {
            // handle the exception
        } catch (IOException e) {
            // handle the exception
        }
    }

    /**
     * load from file
     * @return
     * @throws IOException
     */
    public static User loadFile() throws IOException {
        XmlMapper xmlMapper = new XmlMapper();
        String readContent = new String(Files.readAllBytes(Paths.get("XMTesticle.xml")));
        User deserializedData = xmlMapper.readValue(readContent, User.class);

        return deserializedData;
    }



}













    





