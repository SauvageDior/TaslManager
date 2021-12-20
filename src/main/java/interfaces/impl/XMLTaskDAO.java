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



public class XMLTaskDAO implements TaskDAO {


    //private static final File XML = new File("XMLtestfile");

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


    public void storeTask(Task task) throws IOException {
        //List<Task> list = new ArrayList<>();
        User user = loadFile();
        List<Task> list = user.getTasks();
        list.add(task);
        unloadFile(user);
    }


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


    public static void unloadFile(User user) {
        try {
            XmlMapper xmlMapper = new XmlMapper();

            String xmlString = xmlMapper.writeValueAsString(user);

            System.out.println(xmlString);

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

    public static User loadFile() throws IOException {
        XmlMapper xmlMapper = new XmlMapper();
        String readContent = new String(Files.readAllBytes(Paths.get("XMTesticle.xml")));
        User deserializedData = xmlMapper.readValue(readContent, User.class);

        return deserializedData;
    }

    /*private static User loadFile() throws IOException { //загрузка из файла
        User user = new User();
        File XML = new File("XMTesticle.xml");
        XmlMapper xmlMapper = new XmlMapper();
        user = xmlMapper.readValue(XML, User.class);
        return user;
    }*/

 /*  private static void unloadFile(List<Task> task) throws IOException {
       XMLEncoder encoder=null;
       try{
           encoder=new XMLEncoder(new BufferedOutputStream(new FileOutputStream(XML)));
       }catch(FileNotFoundException fileNotFound){
           System.out.println("");
       }
       encoder.writeObject(task);
       encoder.close();
    }*/

}













    





