package controllers;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.Time;
import java.util.*;

import controllers.*;
import model.Alert;
import model.Task;
import model.User;

public class MainController {



    public static void main(String[] args) throws AWTException {





        Task task = new Task();
   /*     Task task1 = new Task();
        Task task2 = new Task();*/

        TaskController tk = new TaskController();
        try {
           task = tk.sheduleTask(UUID.randomUUID(), "Name", "Desck", new Time(new Date().getTime() + 10000));

        } catch (IOException e){e.printStackTrace();}

        try {
            task = tk.sheduleTask(UUID.randomUUID(), "Name2", "Desck2", new Time(new Date().getTime() + 20000));

        } catch (IOException e){e.printStackTrace();}



        //tk.deleteTask(UUID.fromString("d3964bd3-dcf9-43c8-af8a-54ae7793a673"));


        Time t1 = new Time(new Date().getTime());
        System.out.println(t1);
        System.out.println(task.getAlert().getAlertTime());




    /*        PopupMenu popup = new PopupMenu();
        //   Настройка
        MenuItem exitItem = new MenuItem("Настройка...");
        exitItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    Runtime.getRuntime().exec("cmd.exe /c start java -jar D:\\NetCracker\\nk\\123\\out\\artifacts\\123_jar\\123.jar");
                } catch (IOException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            }
        });
        popup.add(exitItem);
        //   Выход
        exitItem = new MenuItem("Выход");
        exitItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        popup.add(exitItem);

        // создаем иконку в трее
        SystemTray systemTray = SystemTray.getSystemTray();
        Image image = Toolkit.getDefaultToolkit().getImage("./resources/tray_img.png");
        TrayIcon trayIcon = new TrayIcon(image, "TM", popup);
        trayIcon.setImageAutoSize(true);
        systemTray.add(trayIcon);*/



    }

    }


