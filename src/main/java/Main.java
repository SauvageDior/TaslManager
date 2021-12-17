import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import model.Alert;
import model.Task;
import model.User;
import controllers.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class Main {
    //tests
    XmlMapper mapper = new XmlMapper();

    public static void main(String[] args)  {
	        //Alert al = new Alert(UUID.randomUUID(), new Time(new Date().getTime() + 10000), "1234", UUID.randomUUID());
        Task task1 = new Task("123", "111", UUID.randomUUID(), UUID.randomUUID(), new Time(new Date().getTime() + 30000));
        Task task2 = new Task("123", "111", UUID.randomUUID(), UUID.randomUUID(), new Time(new Date().getTime()+15000));
        Task task3 = new Task("123", "111", UUID.randomUUID(), UUID.randomUUID(), new Time(new Date().getTime()+20000));
        Task task4 = new Task("123", "111", UUID.randomUUID(), UUID.randomUUID(), new Time(new Date().getTime()+25000));
        List<Task> taskList = new ArrayList<>();
        taskList.add(task1);
        taskList.add(task2);
        List<Task> taskList2 = new ArrayList<>();
        taskList2.add(task3);
        taskList2.add(task4);

        User user1 = new User();
        User user2 = new User();

        user1.setTasks(taskList);
        user2.setTasks(taskList2);

        task1.setMessage("task1");
        task2.setMessage("task2");
        task3.setMessage("task3");
        task4.setMessage("task4");

        Alert alert = task1.getAlert();
        System.out.println(alert);

        System.out.println(user1.getTasks());
        System.out.println(user2.getTasks());

        TaskController tk = new TaskController();

        tk.deleteTask(task1.getId());
        System.out.println("-------------------");
        System.out.println(taskList);


            //serializeToXML();


       /* try {
            whenJavaSerializedToXmlFile();
        } catch (IOException e) {e.printStackTrace();}*/

      /*  try {
            serializeToXML();
        } catch (IOException e) {e.printStackTrace();}*/

    }

 /*   public static void serializeToXML() throws IOException {}*/


   /* public static void whenJavaSerializedToXmlFile() throws IOException {
        XmlMapper xmlMapper = new XmlMapper();
        xmlMapper.writeValue(new File("XMLtestfile"), new Task("123", "111", UUID.randomUUID(), UUID.randomUUID(), new Time(new Date().getTime() + 30000)));
        File file = new File("XMLtestfile");
    }*/

   /* public static void serializeToXML() {
        try {
            XmlMapper xmlMapper = new XmlMapper();

            // create a list of other phones
            //List<String> otherPhones = Arrays.asList("OnePlus 6T", "OnePlus 5T", "OnePlus 5");

            // create the manufacturer object
            Alert alert = new Alert(UUID.randomUUID(), new Time(new Date().getTime()), "1234");

            // serialize our new Object into XML string
        *//*    String xmlString = xmlMapper
                    .writeValueAsString( new Task("123", "111", UUID.randomUUID(), UUID.randomUUID(), new Time(new Date().getTime()), alert));*//*

            // write to the console
            System.out.println(xmlString);

            // write XML string to file
            File xmlOutput = new File("XMLtestfile");
            FileWriter fileWriter = new FileWriter(xmlOutput);
            fileWriter.write(xmlString);
            fileWriter.close();
        } catch (JsonProcessingException e) {
            // handle the exception
        } catch (IOException e) {
            // handle the exception
        }
    }*/

}
