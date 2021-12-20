package controllers;

import java.io.IOException;
import java.sql.Time;
import java.util.*;

import controllers.*;
import model.Task;
import model.User;

public class MainController {

   /* private static boolean check_time(String str)
    {
        int count = 0;
        for (int i=0;i<str.length();i++)
            if (str.charAt(i)==':') count++;
        if (count!=1)	return false;

        String[] tokens=str.split(":");
        int hour = Integer.parseInt(tokens[0]);
        int min = Integer.parseInt(tokens[1]);

        if (hour<0 || hour>23) return false;
        if (min<0 || min>59) return false;

        return true;
    }*/

    public static void main(String[] args) {
        Task task = new Task();

        TaskController tk = new TaskController();
        try {
           task = tk.sheduleTask(UUID.randomUUID(), "Name", "Desck", new Time(new Date().getTime() + 20000));
        } catch (IOException e){e.printStackTrace();}

        System.out.println(task);



    }

    }


