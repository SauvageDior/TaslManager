import controllers.TaskController;
import exceptions.NotFoundException;
import model.Task;
import transport.Reqest;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.sql.Time;
import java.util.Date;
import java.util.Scanner;
import java.util.UUID;

class Client{
    private Socket socket;
    private ObjectOutputStream oos;
    private ObjectInputStream ois;

    public Client(Socket socket) throws IOException {
        this.socket = socket;
        this.oos = new ObjectOutputStream(socket.getOutputStream());
        this.ois = new ObjectInputStream(socket.getInputStream());
    }

    public void execute() throws IOException {

        Scanner scan = new Scanner(System.in);
        int x = 0;
        String s = "";

        while (!"5".equals(s)) {
            {
                System.out.println("1) add task\n2) delete task\n3) update task\n4) unshelude task\n5) exit");
                s = scan.next();

                try {
                    x = Integer.parseInt(s);
                } catch (NumberFormatException e) {
                    System.out.println("Неверный ввод");
                }

                switch (x) {
                    case 1:
                       // Task task = new Task();
                       // TaskController tk = new TaskController();
                        System.out.println("name: ");
                        String name = scan.next();

                        System.out.println("description: ");
                        String desc = scan.next();

                        System.out.println("time (10:11): ");
                        String timeS = scan.next();
                        String[] str = timeS.split(":");

                        int hour = Integer.parseInt(str[0]);
                        int min = Integer.parseInt(str[1]);

                        Time time = new Time(new Date().getTime());

                        time.setSeconds(0);
                        time.setHours(hour);
                        time.setMinutes(min);

                        System.out.println("message: ");
                        String mess = scan.next();


                        try {
                            Reqest reqest = new Reqest();
                            reqest.setCommand("add");
                            reqest.setUserId(UUID.randomUUID());
                            reqest.setAlertTime(time);
                            reqest.setTaskDesc(desc);
                            reqest.setTaskName(name);
                            reqest.setTaskId(UUID.randomUUID());

                            oos.writeObject(reqest);

                            //task.getAlert().setMessage(mess);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                        break;
                    case 2:

                        //TaskController tsk = new TaskController();
                        Reqest req = new Reqest();
                        System.out.println("task id: ");
                        String idS = scan.next();
                        UUID id = UUID.fromString(idS);
                        req.setCommand("delete");
                        req.setTaskId(id);
                        oos.writeObject(req);
                        //tsk.deleteTask(id);

                        break;
                    case 3:

                        //TaskController new_tk = new TaskController();

                        System.out.println("task id: ");
                        String newid = scan.next();
                        UUID new_id = UUID.fromString(newid);

                        System.out.println("new name: ");
                        String new_name = scan.next();

                        System.out.println("new description: ");
                        String new_desc = scan.next();


                            //Task new_task = new_tk.updateTask(new_id, new_name, new_desc);
                            Reqest reqest = new Reqest();
                            reqest.setCommand("update");
                            reqest.setTaskId(new_id);
                            reqest.setTaskName(new_name);
                            reqest.setTaskDesc(new_desc);
                        oos.writeObject(reqest);

                        break;
                    case 4:

                        //TaskController untk = new TaskController();

                        System.out.println("task id: ");
                        String idun = scan.next();
                        UUID inid = UUID.fromString(idun);

                        Reqest _reqest = new Reqest();
                        _reqest.setCommand("unshedule");
                        _reqest.setTaskId(inid);
                        _reqest.setCommand("unshedule");
                        oos.writeObject(_reqest);


                        /*try {
                            Task untask = untk.unsheludeTask(inid);
                        } catch (NotFoundException | IOException e) {
                            e.printStackTrace();
                        }*/


                }
            }

        }



    }

}