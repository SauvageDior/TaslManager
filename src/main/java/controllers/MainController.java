package controllers;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.Time;
import java.util.*;

import controllers.*;
import exceptions.NotFoundException;
import model.Alert;
import model.Task;
import model.User;

public class MainController {



    public static void main(String[] args) throws AWTException {




        Scanner scan = new Scanner(System.in);
        int x = 0;
        String s = "";

        while (!"5".equals(s)){{
            System.out.println("1) add task\n2) delete task\n3) update task\n4) unshelude task\n5) exit");
            s = scan.next();

            try {
                x = Integer.parseInt(s);
            } catch (NumberFormatException e){
                System.out.println("Неверный ввод");
            }

            switch (x){
                case 1:
                    Task task = new Task();
                    TaskController tk = new TaskController();
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
                        task = tk.sheduleTask(UUID.randomUUID(), name, desc, time);
                        task.getAlert().setMessage(mess);
                    } catch (IOException e){e.printStackTrace();}

                    break;
                case 2:

                    TaskController tsk = new TaskController();
                    System.out.println("task id: ");
                    String idS = scan.next();
                    UUID id = UUID.fromString(idS);
                    tsk.deleteTask(id);

                    break;
                case 3:

                    TaskController new_tk = new TaskController();

                    System.out.println("task id: ");
                    String newid = scan.next();
                    UUID new_id = UUID.fromString(newid);

                    System.out.println("new name: ");
                    String new_name = scan.next();

                    System.out.println("new description: ");
                    String new_desc = scan.next();

                    try {
                        Task new_task = new_tk.updateTask(new_id, new_name, new_desc);
                    } catch (NotFoundException | IOException e) {e.printStackTrace();}

                    break;
                case 4:

                    TaskController untk = new TaskController();

                    System.out.println("task id: ");
                    String idun = scan.next();
                    UUID inid = UUID.fromString(idun);

                    try {
                        Task untask = untk.unsheludeTask(inid);
                    } catch (NotFoundException | IOException e) {e.printStackTrace();}


            }
        }

        }






    }

    }


