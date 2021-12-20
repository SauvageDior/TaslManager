package testfiles;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import interfaces.TaskDAO;
import interfaces.impl.XMLTaskDAO;
import model.Alert;
import model.Task;
import model.User;
import controllers.*;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import java.beans.ExceptionListener;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class Main {
    //tests
    //XmlMapper mapper = new XmlMapper();


    public static void main(String[] args) throws IOException {
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
        List<Task> taskList3 = new ArrayList<>();
        taskList3.add(task1);

        User user = new User(UUID.randomUUID(), taskList3);
        User user1 = new User(UUID.randomUUID(), taskList);
        User user2 = new User(UUID.randomUUID(), taskList2);

       /* user1.setTasks(taskList);
        user2.setTasks(taskList2);*/

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

//////////////////////////////////////////////////////////////
        //serializeToXML(user1);
        serializeToXML(user);
       /* User user3 = new User();
        user3 = deserializeFromXML();
        System.out.println("=========================");
        System.out.println(user3.getTasks());*/
/////////////////////////////////////////////////////////////////

       /* newSerializeToXML(user1);
        User user3 = new User();
        user3 = newdeserializeFromXML();*/
////////////////////////////////////////////////////


        //NewserializeToXML(user1);

        //new Thread(alert).start();*/

        //Alert alert1 = new Alert(UUID.randomUUID(), new Time(new Date().getTime()+100000),"hello");

        //    serializeToXML();
        //whenJavaSerializedToXmlFile();



       /* try {
            whenJavaSerializedToXmlFile();
        } catch (IOException e) {e.printStackTrace();}*/

      /*  try {
            serializeToXML();
        } catch (IOException e) {e.printStackTrace();}*/

    }

    private static List<Task> ldFile(){
        XMLDecoder decoder=null;
        try {
            decoder=new XMLDecoder(new BufferedInputStream(new FileInputStream("XMLtestfile")));
        } catch (FileNotFoundException e) {
            System.out.println("");
        }
        List<Task> tl=(List<Task>) decoder.readObject();
        return tl;
    }


    private static void unloadFile(User user) throws IOException {
        XMLEncoder encoder=null;
        try{
            encoder=new XMLEncoder(new BufferedOutputStream(new FileOutputStream("xmlfile.xml")));
        }catch(FileNotFoundException fileNotFound){
            System.out.println("");
        }
        encoder.writeObject(user);
        encoder.close();
    }


    public static void whenJavaSerializedToXmlFile() throws IOException {
        Alert alert = new Alert(UUID.randomUUID(), new Time(new Date().getTime()), "1234");
        List<Task> taskList = new ArrayList<>();
        Task task1 = new Task("123", "111", UUID.randomUUID(), UUID.randomUUID(), alert);
        Task task2 = new Task("123", "111", UUID.randomUUID(), UUID.randomUUID(), alert);
        taskList.add(task1);
        taskList.add(task2);
        XmlMapper xmlMapper = new XmlMapper();
        xmlMapper.writeValue(new File("XMLtestfile"), new User(UUID.randomUUID(),  taskList));
        File file = new File("XMLtestfile");
    }

   /* public void whenJavaGotFromXmlStrWithCapitalElem_thenCorrect() throws IOException {
        XmlMapper xmlMapper = new XmlMapper();
        User value
                = xmlMapper.readValue(, User.class);

    }*/

    public static void serializeToXML(User user) { ////////////////////////////////////////////
        try {
            XmlMapper xmlMapper = new XmlMapper();


            // create the manufacturer object

             //serialize our new Object into XML string
          String xmlString = xmlMapper.writeValueAsString(user);

            // write to the console
            System.out.println(xmlString);

            // write XML string to file
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

    public static User deserializeFromXML() throws IOException {

            XmlMapper xmlMapper = new XmlMapper();

            // read file and put contents into the string
            String readContent = new String(Files.readAllBytes(Paths.get("XMTesticle.xml")));

            // deserialize from the XML into a Phone object
            User deserializedData = xmlMapper.readValue(readContent, User.class);

        return deserializedData;
    }

    private static void sex(User user) {
        JAXBContext context;
        File xml = new File("sex.xml");
        try {
            context = JAXBContext.newInstance(User.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(user, xml);

        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }



    private static User loadFile() throws IOException { //загрузка из файла
        User user = null;
        File XML = new File("XMTesticle.xml");
        XmlMapper xmlMapper = new XmlMapper();
        user = xmlMapper.readValue(XML, User.class);
        return user;
    }

    private static void newSerializeToXML (User settings) throws IOException
    {
        FileOutputStream fos = new FileOutputStream("ttt.xml");
        XMLEncoder encoder = new XMLEncoder(fos);
        encoder.writeObject(settings);
        encoder.close();
        fos.close();
    }

    private static User newdeserializeFromXML() throws IOException {
        FileInputStream fis = new FileInputStream("ttt.xml");
        XMLDecoder decoder = new XMLDecoder(fis);
        User decodedSettings = (User) decoder.readObject();
        decoder.close();
        fis.close();
        return decodedSettings;
    }



}
